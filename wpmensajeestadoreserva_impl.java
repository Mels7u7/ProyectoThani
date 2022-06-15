package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpmensajeestadoreserva_impl extends GXDataArea
{
   public wpmensajeestadoreserva_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpmensajeestadoreserva_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpmensajeestadoreserva_impl.class ));
   }

   public wpmensajeestadoreserva_impl( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV13EstadoReservaCita = (short) GXutil.lval( args[0]);
         AV25NombresDoctor = (String) args[1];
         AV5TempFechaCita = (String) args[2];
         AV15HoraCita = (String) args[3];
         AV33CitaId = (int) GXutil.lval( args[4]);
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
         gxfirstwebparm = httpContext.GetFirstPar( "EstadoReservaCita") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "EstadoReservaCita") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "EstadoReservaCita") ;
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
            AV13EstadoReservaCita = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13EstadoReservaCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EstadoReservaCita), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESTADORESERVACITA", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13EstadoReservaCita), "ZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV25NombresDoctor = httpContext.GetPar( "NombresDoctor") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25NombresDoctor", AV25NombresDoctor);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESDOCTOR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25NombresDoctor, ""))));
               AV5TempFechaCita = httpContext.GetPar( "TempFechaCita") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV5TempFechaCita", AV5TempFechaCita);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTEMPFECHACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5TempFechaCita, ""))));
               AV15HoraCita = httpContext.GetPar( "HoraCita") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15HoraCita", AV15HoraCita);
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHORACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15HoraCita, ""))));
               AV33CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV33CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33CitaId), 8, 0));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV33CitaId), "ZZZZZZZ9")));
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
      pa6T2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6T2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034845", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoHomPagPaciente\" data-gx-class=\"form-horizontal FormFondoHomPagPaciente\" novalidate action=\""+formatLink("com.projectthani.wpmensajeestadoreserva", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13EstadoReservaCita,4,0)),GXutil.URLEncode(GXutil.rtrim(AV25NombresDoctor)),GXutil.URLEncode(GXutil.rtrim(AV5TempFechaCita)),GXutil.URLEncode(GXutil.rtrim(AV15HoraCita)),GXutil.URLEncode(GXutil.ltrimstr(AV33CitaId,8,0))}, new String[] {"EstadoReservaCita","NombresDoctor","TempFechaCita","HoraCita","CitaId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESTADORESERVACITA", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13EstadoReservaCita), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESDOCTOR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25NombresDoctor, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTEMPFECHACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5TempFechaCita, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHORACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15HoraCita, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV33CitaId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vESTADORESERVACITA", GXutil.ltrim( localUtil.ntoc( AV13EstadoReservaCita, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESTADORESERVACITA", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13EstadoReservaCita), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vNOMBRESDOCTOR", AV25NombresDoctor);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESDOCTOR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25NombresDoctor, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTEMPFECHACITA", AV5TempFechaCita);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTEMPFECHACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5TempFechaCita, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vHORACITA", AV15HoraCita);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHORACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15HoraCita, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV33CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV33CitaId), "ZZZZZZZ9")));
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
         we6T2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6T2( ) ;
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
      return formatLink("com.projectthani.wpmensajeestadoreserva", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV13EstadoReservaCita,4,0)),GXutil.URLEncode(GXutil.rtrim(AV25NombresDoctor)),GXutil.URLEncode(GXutil.rtrim(AV5TempFechaCita)),GXutil.URLEncode(GXutil.rtrim(AV15HoraCita)),GXutil.URLEncode(GXutil.ltrimstr(AV33CitaId,8,0))}, new String[] {"EstadoReservaCita","NombresDoctor","TempFechaCita","HoraCita","CitaId"})  ;
   }

   public String getPgmname( )
   {
      return "WPMensajeEstadoReserva" ;
   }

   public String getPgmdesc( )
   {
      return "Mensaje de la reserva" ;
   }

   public void wb6T0( )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockicono_Internalname, lblTextblockicono_Caption, "", "", lblTextblockicono_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbmsgsuccses_Internalname, lblTbmsgsuccses_Caption, "", "", lblTbmsgsuccses_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionRN", 0, "", 1, 1, 0, (short)(1), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbinfopago_Internalname, lblTbinfopago_Caption, "", "", lblTbinfopago_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttIrinicio_Internalname, "", "Ir a inicio", bttIrinicio_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMensajeEstadoReserva.htm");
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconerror_Internalname, lblTextblockiconerror_Caption, "", "", lblTextblockiconerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbmsgerror_Internalname, lblTbmsgerror_Caption, "", "", lblTbmsgerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionRN", 0, "", 1, 1, 0, (short)(1), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbinfoerror_Internalname, lblTbinfoerror_Caption, "", "", lblTbinfoerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnirinicio_Internalname, "", "Ir a inicio", bttBtnirinicio_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMensajeEstadoReserva.htm");
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbiconcitaerror_Internalname, lblTbiconcitaerror_Caption, "", "", lblTbiconcitaerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbcitaerror_Internalname, lblTbcitaerror_Caption, "", "", lblTbcitaerror_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescriptionRN", 0, "", 1, 1, 0, (short)(1), "HLP_WPMensajeEstadoReserva.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCellRN CellPaddingRN", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttIrinicio1_Internalname, "", "Ir a inicio", bttIrinicio1_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMensajeEstadoReserva.htm");
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

   public void start6T2( )
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
         Form.getMeta().addItem("description", "Mensaje de la reserva", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6T0( ) ;
   }

   public void ws6T2( )
   {
      start6T2( ) ;
      evt6T2( ) ;
   }

   public void evt6T2( )
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
                           e116T2 ();
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
                                 e126T2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e136T2 ();
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

   public void we6T2( )
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

   public void pa6T2( )
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
      rf6T2( ) ;
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

   public void rf6T2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e136T2 ();
         wb6T0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6T2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6T0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e116T2 ();
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
      e116T2 ();
      if (returnInSub) return;
   }

   public void e116T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divTablesuccess_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablesuccess_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesuccess_Visible), 5, 0), true);
      divTableerror_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTableerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableerror_Visible), 5, 0), true);
      divTablecitaerror_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablecitaerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecitaerror_Visible), 5, 0), true);
      AV14FechaCita = localUtil.ctod( AV5TempFechaCita, 3) ;
      if ( AV13EstadoReservaCita == 1 )
      {
         AV19HtmlIconSucces = "<div><i class=\"fas fa-check-circle\" style=\"font-size: 80px;color: green;\"></i></div>" ;
         lblTextblockicono_Caption = AV19HtmlIconSucces ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockicono_Internalname, "Caption", lblTextblockicono_Caption, true);
         AV23HtmlTbSuccess += "<div class=\"login-header\"  style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-top:-40px;margin-bottom: 10px;\"><h3>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlTbSuccess", AV23HtmlTbSuccess);
         AV23HtmlTbSuccess += "<font style=\"vertical-align: inherit; font-size: 24px;color: #15A015;font-family:" + "MyriadPro-Bold" + ";\">¡Cita reservada con éxito!</font></h3><p class=\"small\" style=\"padding-left: 30px; margin-right: 31px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlTbSuccess", AV23HtmlTbSuccess);
         AV23HtmlTbSuccess += "<font style=\"vertical-align: initial;font-size: 14px;text-align: justify;white-space: normal; color: #333;font-family:" + "MyriadPro-Bold" + ";\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlTbSuccess", AV23HtmlTbSuccess);
         AV23HtmlTbSuccess += "Cita reservada con el Dr(a). " + AV25NombresDoctor + " el " + GXutil.str( GXutil.day( AV14FechaCita), 10, 0) + " de " + localUtil.cmonth( AV14FechaCita, "spa") + " de " + GXutil.str( GXutil.year( AV14FechaCita), 10, 0) + " de " + AV15HoraCita + " </font></p></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23HtmlTbSuccess", AV23HtmlTbSuccess);
         lblTbmsgsuccses_Caption = AV23HtmlTbSuccess ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbmsgsuccses_Internalname, "Caption", lblTbmsgsuccses_Caption, true);
         AV20HtmlInfoPago += "<div class=\"alert alert-primary\" role=\"alert\" style=\"padding: 15px;border:3px solid #00BAED;border-radius:10px;margin-left:20px;margin-right:20px;margin-top:-15px;margin-bottom:-1px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlInfoPago", AV20HtmlInfoPago);
         AV20HtmlInfoPago += "<ul style=\"margin-left: -20px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlInfoPago", AV20HtmlInfoPago);
         AV20HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Cod. Cita: " + GXutil.str( AV33CitaId, 8, 0) + " </li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlInfoPago", AV20HtmlInfoPago);
         AV20HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Dr(a): " + AV25NombresDoctor + " </li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlInfoPago", AV20HtmlInfoPago);
         AV20HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Fecha: " + localUtil.dtoc( AV14FechaCita, 3, "/") + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlInfoPago", AV20HtmlInfoPago);
         AV20HtmlInfoPago += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Hora: " + AV15HoraCita + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlInfoPago", AV20HtmlInfoPago);
         AV20HtmlInfoPago += "</ul></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlInfoPago", AV20HtmlInfoPago);
         lblTbinfopago_Caption = AV20HtmlInfoPago ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbinfopago_Internalname, "Caption", lblTbinfopago_Caption, true);
         divTablesuccess_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablesuccess_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesuccess_Visible), 5, 0), true);
      }
      else if ( AV13EstadoReservaCita == 2 )
      {
         AV18HtmlIconError = "<div><i class=\"fas fa-times-circle\"style=\"font-size: 80px;color: red;\"></i></div>" ;
         lblTextblockiconerror_Caption = AV18HtmlIconError ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconerror_Internalname, "Caption", lblTextblockiconerror_Caption, true);
         AV22HtmlTbError += "<div class=\"login-header\"  style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-top:-40px;margin-bottom: 10px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlTbError", AV22HtmlTbError);
         AV22HtmlTbError += "<h3><font style=\"vertical-align: inherit; font-size: 24px;color:#ff0000;font-family:" + "MyriadPro-Bold" + ";\">¡Hubo un error al realizar al reservar la cita!</font></h3>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlTbError", AV22HtmlTbError);
         AV22HtmlTbError += "<p class=\"small\" style=\"padding-left: 30px; margin-right: 31px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlTbError", AV22HtmlTbError);
         AV22HtmlTbError += "<font style=\"vertical-align: initial;font-size: 17px;text-align: justify;white-space: normal;color:#333;font-family:" + "MyriadPro-Bold" + ";\">Por favor intente reservar la cita nuevamente</font></p></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22HtmlTbError", AV22HtmlTbError);
         lblTbmsgerror_Caption = AV22HtmlTbError ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbmsgerror_Internalname, "Caption", lblTbmsgerror_Caption, true);
         AV21HtmlInfoPagoErr += "<div class=\"alert alert-primary\" role=\"alert\"style=\"padding: 15px;border:3px solid #00BAED;border-radius:10px;margin-left:20px;margin-right:20px;margin-top:-15px;margin-bottom:-1px;\"><ul style=\"margin-left: -20px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21HtmlInfoPagoErr", AV21HtmlInfoPagoErr);
         AV21HtmlInfoPagoErr += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Cod. Cita: " + GXutil.str( AV33CitaId, 8, 0) + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21HtmlInfoPagoErr", AV21HtmlInfoPagoErr);
         AV21HtmlInfoPagoErr += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Dr(a): " + AV25NombresDoctor + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21HtmlInfoPagoErr", AV21HtmlInfoPagoErr);
         AV21HtmlInfoPagoErr += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Fecha: " + localUtil.dtoc( AV14FechaCita, 3, "/") + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21HtmlInfoPagoErr", AV21HtmlInfoPagoErr);
         AV21HtmlInfoPagoErr += "<li style=\"font-size: 14px;color: #333;font-family:" + "MyriadPro-Bold" + ";\">Hora: " + AV15HoraCita + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21HtmlInfoPagoErr", AV21HtmlInfoPagoErr);
         AV21HtmlInfoPagoErr += "</ul></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21HtmlInfoPagoErr", AV21HtmlInfoPagoErr);
         lblTbinfoerror_Caption = AV21HtmlInfoPagoErr ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbinfoerror_Internalname, "Caption", lblTbinfoerror_Caption, true);
         divTableerror_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTableerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTableerror_Visible), 5, 0), true);
      }
      else if ( AV13EstadoReservaCita == 3 )
      {
         AV17HtmlIconCitaError = "<div><i class=\"fas fa-exclamation-triangle\"style=\"font-size: 80px;color: orange;\"></i></div>" ;
         lblTbiconcitaerror_Caption = AV17HtmlIconCitaError ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbiconcitaerror_Internalname, "Caption", lblTbiconcitaerror_Caption, true);
         AV16HtmlCitaError += "<div class=\"login-header\"  style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-top:-15px;margin-bottom: 10px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16HtmlCitaError", AV16HtmlCitaError);
         AV16HtmlCitaError += "<h3><font style=\"vertical-align: inherit; font-size: 24px; color:#F4B008;font-family:" + "MyriadPro-Bold" + ";\">¡Cita reservada no disponible!</font></h3>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16HtmlCitaError", AV16HtmlCitaError);
         AV16HtmlCitaError += "<p class=\"small\" style=\"padding-left: 30px; margin-right: 31px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16HtmlCitaError", AV16HtmlCitaError);
         AV16HtmlCitaError += "<font style=\"vertical-align: initial;font-size: 16px;text-align: justify;white-space: normal;color:#333;font-family:" + "MyriadPro-Bold" + ";\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16HtmlCitaError", AV16HtmlCitaError);
         AV16HtmlCitaError += "El horario de esa cita ya se encuentra ocupada. Por favor intente con otro horario.</font></p></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16HtmlCitaError", AV16HtmlCitaError);
         lblTbcitaerror_Caption = AV16HtmlCitaError ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbcitaerror_Internalname, "Caption", lblTbcitaerror_Caption, true);
         divTablecitaerror_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecitaerror_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecitaerror_Visible), 5, 0), true);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e126T2 ();
      if (returnInSub) return;
   }

   public void e126T2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   protected void nextLoad( )
   {
   }

   protected void e136T2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV13EstadoReservaCita = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13EstadoReservaCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13EstadoReservaCita), 4, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESTADORESERVACITA", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV13EstadoReservaCita), "ZZZ9")));
      AV25NombresDoctor = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25NombresDoctor", AV25NombresDoctor);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNOMBRESDOCTOR", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV25NombresDoctor, ""))));
      AV5TempFechaCita = (String)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5TempFechaCita", AV5TempFechaCita);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTEMPFECHACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV5TempFechaCita, ""))));
      AV15HoraCita = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15HoraCita", AV15HoraCita);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vHORACITA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15HoraCita, ""))));
      AV33CitaId = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV33CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV33CitaId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV33CitaId), "ZZZZZZZ9")));
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
      pa6T2( ) ;
      ws6T2( ) ;
      we6T2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034897", true, true);
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
      httpContext.AddJavascriptSource("wpmensajeestadoreserva.js", "?2022511034898", false, true);
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
      Form.setCaption( "Mensaje de la reserva" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV13EstadoReservaCita',fld:'vESTADORESERVACITA',pic:'ZZZ9',hsh:true},{av:'AV25NombresDoctor',fld:'vNOMBRESDOCTOR',pic:'',hsh:true},{av:'AV5TempFechaCita',fld:'vTEMPFECHACITA',pic:'',hsh:true},{av:'AV15HoraCita',fld:'vHORACITA',pic:'',hsh:true},{av:'AV33CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e126T2',iparms:[]");
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
      wcpOAV25NombresDoctor = "" ;
      wcpOAV5TempFechaCita = "" ;
      wcpOAV15HoraCita = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV25NombresDoctor = "" ;
      AV5TempFechaCita = "" ;
      AV15HoraCita = "" ;
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
      AV14FechaCita = GXutil.nullDate() ;
      AV19HtmlIconSucces = "" ;
      AV23HtmlTbSuccess = "" ;
      AV20HtmlInfoPago = "" ;
      AV18HtmlIconError = "" ;
      AV22HtmlTbError = "" ;
      AV21HtmlInfoPagoErr = "" ;
      AV17HtmlIconCitaError = "" ;
      AV16HtmlCitaError = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOAV13EstadoReservaCita ;
   private short AV13EstadoReservaCita ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV33CitaId ;
   private int AV33CitaId ;
   private int divTablesuccess_Visible ;
   private int divTableerror_Visible ;
   private int divTablecitaerror_Visible ;
   private int idxLst ;
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
   private java.util.Date AV14FechaCita ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV19HtmlIconSucces ;
   private String AV23HtmlTbSuccess ;
   private String AV20HtmlInfoPago ;
   private String AV18HtmlIconError ;
   private String AV22HtmlTbError ;
   private String AV21HtmlInfoPagoErr ;
   private String AV17HtmlIconCitaError ;
   private String AV16HtmlCitaError ;
   private String wcpOAV25NombresDoctor ;
   private String wcpOAV5TempFechaCita ;
   private String wcpOAV15HoraCita ;
   private String AV25NombresDoctor ;
   private String AV5TempFechaCita ;
   private String AV15HoraCita ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.webpanels.GXWebForm Form ;
}

