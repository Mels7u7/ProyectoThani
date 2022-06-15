package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpverificarcuenta_impl extends GXDataArea
{
   public wpverificarcuenta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpverificarcuenta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpverificarcuenta_impl.class ));
   }

   public wpverificarcuenta_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "VarPacienteId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "VarPacienteId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "VarPacienteId") ;
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
            AV15VarPacienteId = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15VarPacienteId", AV15VarPacienteId);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVARPACIENTEID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15VarPacienteId, ""))));
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
      pa2Y2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2Y2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334514", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoHomPagPaciente\" data-gx-class=\"form-horizontal FormFondoHomPagPaciente\" novalidate action=\""+formatLink("com.projectthani.wpverificarcuenta", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15VarPacienteId))}, new String[] {"VarPacienteId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVARPACIENTEID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15VarPacienteId, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vVARPACIENTEID", AV15VarPacienteId);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVARPACIENTEID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15VarPacienteId, ""))));
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
         we2Y2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2Y2( ) ;
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
      return formatLink("com.projectthani.wpverificarcuenta", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15VarPacienteId))}, new String[] {"VarPacienteId"})  ;
   }

   public String getPgmname( )
   {
      return "WPVerificarCuenta" ;
   }

   public String getPgmdesc( )
   {
      return "Verificar Cuenta Paciente" ;
   }

   public void wb2Y0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginActivarCuenta", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableActivarCuenta", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellMarginTop", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecuentaactivada_Internalname, divTablecuentaactivada_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbcuentaverificada_Internalname, lblTbcuentaverificada_Caption, "", "", lblTbcuentaverificada_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "", 0, "", 1, 1, 0, (short)(2), "HLP_WPVerificarCuenta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbmsgcorreo_Internalname, lblTbmsgcorreo_Caption, "", "", lblTbmsgcorreo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPVerificarCuenta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbmsginiciarsesion_Internalname, lblTbmsginiciarsesion_Caption, "", "", lblTbmsginiciarsesion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPVerificarCuenta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingActivarCuenta", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttIriniciocpc_Internalname, "", "Ir inicio", bttIriniciocpc_Jsonclick, 5, "", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPVerificarCuenta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecuentaporactivar_Internalname, divTablecuentaporactivar_Visible, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbcuentaporverificar_Internalname, lblTbcuentaporverificar_Caption, "", "", lblTbcuentaporverificar_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "", 0, "", 1, 1, 0, (short)(2), "HLP_WPVerificarCuenta.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 CellPaddingActivarCuenta", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'',0)\"" ;
         ClassString = "ButtonIrIinicio" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttIriniciocc_Internalname, "", "Ir inicio", bttIriniciocc_Jsonclick, 5, "", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPVerificarCuenta.htm");
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
         /* User Defined Control */
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, "DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start2Y2( )
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
         Form.getMeta().addItem("description", "Verificar Cuenta Paciente", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2Y0( ) ;
   }

   public void ws2Y2( )
   {
      start2Y2( ) ;
      evt2Y2( ) ;
   }

   public void evt2Y2( )
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
                           e112Y2 ();
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
                                 e122Y2 ();
                              }
                              dynload_actions( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e132Y2 ();
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

   public void we2Y2( )
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

   public void pa2Y2( )
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
      rf2Y2( ) ;
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

   public void rf2Y2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e132Y2 ();
         wb2Y0( ) ;
      }
   }

   public void send_integrity_lvl_hashes2Y2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2Y0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e112Y2 ();
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
      e112Y2 ();
      if (returnInSub) return;
   }

   public void e112Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_char1 = "" ;
      GXv_char2[0] = GXt_char1 ;
      new com.projectthani.decryptpassword(remoteHandle, context).execute( AV15VarPacienteId, GXv_char2) ;
      wpverificarcuenta_impl.this.GXt_char1 = GXv_char2[0] ;
      AV11PacienteId = (int)(GXutil.lval( GXt_char1)) ;
      GXv_char2[0] = AV12PacienteNombresApellidos ;
      GXv_char3[0] = AV10PacienteCorreo ;
      GXv_char4[0] = AV13PacienteSexo ;
      GXv_char5[0] = AV14Resultado ;
      new com.projectthani.prcconfirmarcuentapaciente(remoteHandle, context).execute( AV11PacienteId, GXv_char2, GXv_char3, GXv_char4, GXv_char5) ;
      wpverificarcuenta_impl.this.AV12PacienteNombresApellidos = GXv_char2[0] ;
      wpverificarcuenta_impl.this.AV10PacienteCorreo = GXv_char3[0] ;
      wpverificarcuenta_impl.this.AV13PacienteSexo = GXv_char4[0] ;
      wpverificarcuenta_impl.this.AV14Resultado = GXv_char5[0] ;
      AV5Estimado = "" ;
      if ( GXutil.strcmp(AV13PacienteSexo, "M") == 0 )
      {
         AV5Estimado = "Estimado" ;
      }
      else
      {
         AV5Estimado = "Estimada" ;
      }
      if ( GXutil.strcmp(AV14Resultado, "Pendiente") == 0 )
      {
         divTablecuentaactivada_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecuentaactivada_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecuentaactivada_Visible), 5, 0), true);
         divTablecuentaporactivar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecuentaporactivar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecuentaporactivar_Visible), 5, 0), true);
         AV6HtmlMensajeCV1 += "<div class=\"login-header\"  style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-bottom: 10px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6HtmlMensajeCV1", AV6HtmlMensajeCV1);
         AV6HtmlMensajeCV1 += "<h3><font style=\"font-size: 20px;font-family:" + "MyriadPro-Bold" + ";\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6HtmlMensajeCV1", AV6HtmlMensajeCV1);
         AV6HtmlMensajeCV1 += AV5Estimado + " " + AV12PacienteNombresApellidos + ", bienvenido a Thani." ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6HtmlMensajeCV1", AV6HtmlMensajeCV1);
         AV6HtmlMensajeCV1 += "</font></h3><p class=\"small\" style=\"padding-left: 30px; margin-right: 31px;margin-top: 10px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6HtmlMensajeCV1", AV6HtmlMensajeCV1);
         AV6HtmlMensajeCV1 += "<font style=\"font-size: 16px;white-space: normal;color:#333; font-family:" + "MyriadPro-Regular" + ";\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6HtmlMensajeCV1", AV6HtmlMensajeCV1);
         AV6HtmlMensajeCV1 += "Su cuenta ha sido activada correctamente.</font></p></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6HtmlMensajeCV1", AV6HtmlMensajeCV1);
         lblTbcuentaverificada_Caption = AV6HtmlMensajeCV1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbcuentaverificada_Internalname, "Caption", lblTbcuentaverificada_Caption, true);
         AV8HtmlMsgAc1 += "<div style=\"color:white;background-color:#40C4F4;border-color:#40C4F4;border-radius:20px;text-align:center;font-size:14px;font-family:" + "AcuminVariableConcept" + ";margin-left:25px;margin-right:25px;margin-bottom: 10px;\" class=\"alert alert-warning\" role=\"alert\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8HtmlMsgAc1", AV8HtmlMsgAc1);
         AV8HtmlMsgAc1 += "Se le ha enviado su usuario y contraseña al correo electrónico <b style=\"color:black;\">" + AV10PacienteCorreo + " </b></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8HtmlMsgAc1", AV8HtmlMsgAc1);
         lblTbmsgcorreo_Caption = AV8HtmlMsgAc1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbmsgcorreo_Internalname, "Caption", lblTbmsgcorreo_Caption, true);
         AV9HtmlMsgAc2 += "<div style=\"color:white;background-color:#40C4F4;border-color:#40C4F4;border-radius:20px;text-align:center;font-size:14px;font-family:" + "AcuminVariableConcept" + ";margin-left:25px;margin-right:25px;margin-bottom: 10px;\" class=\"alert alert-warning\" role=\"alert\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9HtmlMsgAc2", AV9HtmlMsgAc2);
         AV9HtmlMsgAc2 += "Presione el botón <b style=\"color:black;\">Ir inicio</b> para regresar al inicio e iniciar sesión en la plataforma.</div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9HtmlMsgAc2", AV9HtmlMsgAc2);
         lblTbmsginiciarsesion_Caption = AV9HtmlMsgAc2 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbmsginiciarsesion_Internalname, "Caption", lblTbmsginiciarsesion_Caption, true);
      }
      else if ( GXutil.strcmp(AV14Resultado, "Activo") == 0 )
      {
         divTablecuentaactivada_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecuentaactivada_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecuentaactivada_Visible), 5, 0), true);
         divTablecuentaporactivar_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, divTablecuentaporactivar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecuentaporactivar_Visible), 5, 0), true);
         AV7HtmlMensajeCV2 += "<div class=\"login-header\" style=\"padding-right: 4px;padding-left: 4px;white-space: normal;text-align:center;margin-bottom: 10px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7HtmlMensajeCV2", AV7HtmlMensajeCV2);
         AV7HtmlMensajeCV2 += "<h3><font style=\"font-size: 20px;font-family:" + "MyriadPro-Bold" + ";\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7HtmlMensajeCV2", AV7HtmlMensajeCV2);
         AV7HtmlMensajeCV2 += AV5Estimado + " " + AV12PacienteNombresApellidos + ", su cuenta ya se encuentra confirmada.</font></h3>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7HtmlMensajeCV2", AV7HtmlMensajeCV2);
         AV7HtmlMensajeCV2 += "<p class=\"small\" style=\"margin-top: 10px;padding-left: 30px; margin-right: 31px;\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7HtmlMensajeCV2", AV7HtmlMensajeCV2);
         AV7HtmlMensajeCV2 += "<font style=\"font-size: 16px;white-space: normal;color:#333; font-family:" + "MyriadPro-Regular" + ";\">Por favor regrese a la página de inicio para iniciar sesión..</font></p></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7HtmlMensajeCV2", AV7HtmlMensajeCV2);
         lblTbcuentaporverificar_Caption = AV7HtmlMensajeCV2 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTbcuentaporverificar_Internalname, "Caption", lblTbcuentaporverificar_Caption, true);
      }
      else
      {
         callWebObject(formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e122Y2 ();
      if (returnInSub) return;
   }

   public void e122Y2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   protected void nextLoad( )
   {
   }

   protected void e132Y2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV15VarPacienteId = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15VarPacienteId", AV15VarPacienteId);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vVARPACIENTEID", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV15VarPacienteId, ""))));
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
      pa2Y2( ) ;
      ws2Y2( ) ;
      we2Y2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334549", true, true);
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
      httpContext.AddJavascriptSource("wpverificarcuenta.js", "?20225110334549", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTbcuentaverificada_Internalname = "TBCUENTAVERIFICADA" ;
      lblTbmsgcorreo_Internalname = "TBMSGCORREO" ;
      lblTbmsginiciarsesion_Internalname = "TBMSGINICIARSESION" ;
      bttIriniciocpc_Internalname = "IRINICIOCPC" ;
      divTablecuentaactivada_Internalname = "TABLECUENTAACTIVADA" ;
      lblTbcuentaporverificar_Internalname = "TBCUENTAPORVERIFICAR" ;
      bttIriniciocc_Internalname = "IRINICIOCC" ;
      divTablecuentaporactivar_Internalname = "TABLECUENTAPORACTIVAR" ;
      divTable2_Internalname = "TABLE2" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      lblTbcuentaporverificar_Caption = "TBCuentaPorVerificar" ;
      divTablecuentaporactivar_Visible = 1 ;
      lblTbmsginiciarsesion_Caption = "Text Block" ;
      lblTbmsgcorreo_Caption = "Text Block" ;
      lblTbcuentaverificada_Caption = "TBCuentaVerificada" ;
      divTablecuentaactivada_Visible = 1 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Verificar Cuenta Paciente" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV15VarPacienteId',fld:'vVARPACIENTEID',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("ENTER","{handler:'e122Y2',iparms:[]");
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
      wcpOAV15VarPacienteId = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV15VarPacienteId = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTbcuentaverificada_Jsonclick = "" ;
      lblTbmsgcorreo_Jsonclick = "" ;
      lblTbmsginiciarsesion_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttIriniciocpc_Jsonclick = "" ;
      lblTbcuentaporverificar_Jsonclick = "" ;
      bttIriniciocc_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXt_char1 = "" ;
      AV12PacienteNombresApellidos = "" ;
      GXv_char2 = new String[1] ;
      AV10PacienteCorreo = "" ;
      GXv_char3 = new String[1] ;
      AV13PacienteSexo = "" ;
      GXv_char4 = new String[1] ;
      AV14Resultado = "" ;
      GXv_char5 = new String[1] ;
      AV5Estimado = "" ;
      AV6HtmlMensajeCV1 = "" ;
      AV8HtmlMsgAc1 = "" ;
      AV9HtmlMsgAc2 = "" ;
      AV7HtmlMensajeCV2 = "" ;
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
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int divTablecuentaactivada_Visible ;
   private int divTablecuentaporactivar_Visible ;
   private int AV11PacienteId ;
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
   private String divTablecontent_Internalname ;
   private String divTable2_Internalname ;
   private String divTablecuentaactivada_Internalname ;
   private String lblTbcuentaverificada_Internalname ;
   private String lblTbcuentaverificada_Caption ;
   private String lblTbcuentaverificada_Jsonclick ;
   private String lblTbmsgcorreo_Internalname ;
   private String lblTbmsgcorreo_Caption ;
   private String lblTbmsgcorreo_Jsonclick ;
   private String lblTbmsginiciarsesion_Internalname ;
   private String lblTbmsginiciarsesion_Caption ;
   private String lblTbmsginiciarsesion_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttIriniciocpc_Internalname ;
   private String bttIriniciocpc_Jsonclick ;
   private String divTablecuentaporactivar_Internalname ;
   private String lblTbcuentaporverificar_Internalname ;
   private String lblTbcuentaporverificar_Caption ;
   private String lblTbcuentaporverificar_Jsonclick ;
   private String bttIriniciocc_Internalname ;
   private String bttIriniciocc_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String AV13PacienteSexo ;
   private String GXv_char4[] ;
   private String AV14Resultado ;
   private String GXv_char5[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV6HtmlMensajeCV1 ;
   private String AV8HtmlMsgAc1 ;
   private String AV9HtmlMsgAc2 ;
   private String AV7HtmlMensajeCV2 ;
   private String wcpOAV15VarPacienteId ;
   private String AV15VarPacienteId ;
   private String AV12PacienteNombresApellidos ;
   private String AV10PacienteCorreo ;
   private String AV5Estimado ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.webpanels.GXWebForm Form ;
}

