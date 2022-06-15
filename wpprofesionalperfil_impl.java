package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpprofesionalperfil_impl extends GXDataArea
{
   public wpprofesionalperfil_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpprofesionalperfil_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpprofesionalperfil_impl.class ));
   }

   public wpprofesionalperfil_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV35ProfesionalId = (int) GXutil.lval( args[0]);
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
         gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "ProfesionalId") ;
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
            AV35ProfesionalId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35ProfesionalId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35ProfesionalId), "ZZZZZZZ9")));
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
      pa692( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start692( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034395", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoGeneral\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoGeneral\" data-gx-class=\"form-horizontal FormFondoGeneral\" novalidate action=\""+formatLink("com.projectthani.wpprofesionalperfil", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV35ProfesionalId,8,0))}, new String[] {"ProfesionalId"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormFondoGeneral", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALES", getSecureSignedToken( "", AV34Profesionales));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35ProfesionalId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPROFESIONALES", AV34Profesionales);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPROFESIONALES", AV34Profesionales);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALES", getSecureSignedToken( "", AV34Profesionales));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV35ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35ProfesionalId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXC1", GXutil.ltrim( localUtil.ntoc( A40000GXC1, (byte)(9), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXC2", GXutil.ltrim( localUtil.ntoc( A40001GXC2, (byte)(9), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABDETALLEPERFIL_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabdetalleperfil_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABDETALLEPERFIL_Class", GXutil.rtrim( Tabdetalleperfil_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABDETALLEPERFIL_Historymanagement", GXutil.booltostr( Tabdetalleperfil_Historymanagement));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormFondoGeneral" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we692( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt692( ) ;
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
      return formatLink("com.projectthani.wpprofesionalperfil", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV35ProfesionalId,8,0))}, new String[] {"ProfesionalId"})  ;
   }

   public String getPgmname( )
   {
      return "WPProfesionalPerfil" ;
   }

   public String getPgmdesc( )
   {
      return "Perfil del Médico" ;
   }

   public void wb690( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "ContainerFluid", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-lg-4 TableProfesionalPerfilCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableperfil_Internalname, 1, 0, "px", 0, "px", "TableProfesionalPerfil", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "TableGridProfesionalP", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 imgPerfilProfesionalCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Foto Profesional", "col-sm-3 imgPerfilProfesionalLabel", 0, true, "");
         /* Static Bitmap Variable */
         ClassString = "imgPerfilProfesional" ;
         StyleString = "" ;
         AV18FotoProfesional_IsBlob = (boolean)(((GXutil.strcmp("", AV18FotoProfesional)==0)&&(GXutil.strcmp("", AV45Fotoprofesional_GXI)==0))||!(GXutil.strcmp("", AV18FotoProfesional)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV18FotoProfesional)==0) ? AV45Fotoprofesional_GXI : httpContext.getResourceRelative(AV18FotoProfesional)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgavFotoprofesional_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV18FotoProfesional_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblDetalleprofesional_Internalname, lblDetalleprofesional_Caption, "", "", lblDetalleprofesional_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableAgendarCita", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
         ClassString = "btnAgendarCita" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnagendarcita_Internalname, "", "Agendar cita", bttBtnagendarcita_Jsonclick, 7, "Agendar cita", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11691_client"+"'", TempTags, "", 2, "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-lg-8 TableDetalleProfesional", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabdetalleperfil.setProperty("PageCount", Tabdetalleperfil_Pagecount);
         ucTabdetalleperfil.setProperty("Class", Tabdetalleperfil_Class);
         ucTabdetalleperfil.setProperty("HistoryManagement", Tabdetalleperfil_Historymanagement);
         ucTabdetalleperfil.render(context, "tab", Tabdetalleperfil_Internalname, "TABDETALLEPERFILContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblOverwiew_title_Internalname, "Sobre mí", "", "", lblOverwiew_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPProfesionalPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Overwiew") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavDescripcion_Internalname, "Descripcion", "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavDescripcion_Internalname, AV11Descripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", (short)(0), 1, edtavDescripcion_Enabled, 0, 80, "chr", 7, "row", StyleString, ClassString, "", "", "500", -1, 0, "", "", (byte)(-1), false, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage2_title_Internalname, "Educación", "", "", lblTabpage2_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPProfesionalPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage2") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbeducacion_Internalname, lblTbeducacion_Caption, "", "", lblTbeducacion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage3_title_Internalname, "Experiencia laboral", "", "", lblTabpage3_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPProfesionalPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage3") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage3table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbexperiencialaboral_Internalname, lblTbexperiencialaboral_Caption, "", "", lblTbexperiencialaboral_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage1_title_Internalname, "Premios", "", "", lblTabpage1_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPProfesionalPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage1") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage1table1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbpremios_Internalname, lblTbpremios_Caption, "", "", lblTbpremios_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage4_title_Internalname, "Servicios", "", "", lblTabpage4_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPProfesionalPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage4") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage4table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbservicios_Internalname, lblTbservicios_Caption, "", "", lblTbservicios_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"title6"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpageopiniones_title_Internalname, "Opiniones", "", "", lblTabpageopiniones_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPProfesionalPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPageOpiniones") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABDETALLEPERFILContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage5table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTxtopiniones_Internalname, lblTxtopiniones_Caption, "", "", lblTxtopiniones_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPProfesionalPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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

   public void start692( )
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
         Form.getMeta().addItem("description", "Perfil del Médico", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup690( ) ;
   }

   public void ws692( )
   {
      start692( ) ;
      evt692( ) ;
   }

   public void evt692( )
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
                           e12692 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e13692 ();
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

   public void we692( )
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

   public void pa692( )
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
            GX_FocusControl = edtavDescripcion_Internalname ;
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
      rf692( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDescripcion_Enabled), 5, 0), true);
   }

   public void rf692( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e13692 ();
         wb690( ) ;
      }
   }

   public void send_integrity_lvl_hashes692( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPROFESIONALES", AV34Profesionales);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPROFESIONALES", AV34Profesionales);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALES", getSecureSignedToken( "", AV34Profesionales));
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavDescripcion_Enabled), 5, 0), true);
      /* Using cursor H00693 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV35ProfesionalId)});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000GXC1 = H00693_A40000GXC1[0] ;
         n40000GXC1 = H00693_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000GXC1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000GXC1), 9, 0));
      }
      pr_default.close(0);
      /* Using cursor H00695 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV35ProfesionalId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40001GXC2 = H00695_A40001GXC2[0] ;
         n40001GXC2 = H00695_n40001GXC2[0] ;
      }
      else
      {
         A40001GXC2 = 0 ;
         n40001GXC2 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40001GXC2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001GXC2), 9, 0));
      }
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup690( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12692 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPROFESIONALES"), AV34Profesionales);
         /* Read saved values. */
         Tabdetalleperfil_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABDETALLEPERFIL_Pagecount"), ",", ".")) ;
         Tabdetalleperfil_Class = httpContext.cgiGet( "TABDETALLEPERFIL_Class") ;
         Tabdetalleperfil_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABDETALLEPERFIL_Historymanagement")) ;
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
      e12692 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e12692( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTProfesionalPerfil1[0] = AV34Profesionales ;
      new com.projectthani.prcgetprofesionalperfil(remoteHandle, context).execute( AV35ProfesionalId, GXv_objcol_SdtSDTProfesionalPerfil1) ;
      AV34Profesionales = GXv_objcol_SdtSDTProfesionalPerfil1[0] ;
      AV37RatingProf = ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion() ;
      AV11Descripcion = ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildescripcion() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Descripcion", AV11Descripcion);
      /* Execute user subroutine: 'DETALLEPROFESIONAL' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LISTAEDUCACION' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'EPERIENCIALABORAL' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'PREMIOS' */
      S142 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'SERVICIOS' */
      S152 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'OPINIONESPROFESIONAL' */
      S162 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
   }

   public void S112( )
   {
      /* 'DETALLEPROFESIONAL' Routine */
      returnInSub = false ;
      /* Using cursor H00697 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV35ProfesionalId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A40000GXC1 = H00697_A40000GXC1[0] ;
         n40000GXC1 = H00697_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000GXC1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000GXC1), 9, 0));
      }
      pr_default.close(2);
      /* Using cursor H00699 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV35ProfesionalId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         A40001GXC2 = H00699_A40001GXC2[0] ;
         n40001GXC2 = H00699_n40001GXC2[0] ;
      }
      else
      {
         A40001GXC2 = 0 ;
         n40001GXC2 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40001GXC2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001GXC2), 9, 0));
      }
      pr_default.close(3);
      AV18FotoProfesional = ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia() ;
      httpContext.ajax_rsp_assign_prop("", false, imgavFotoprofesional_Internalname, "Bitmap", ((GXutil.strcmp("", AV18FotoProfesional)==0) ? AV45Fotoprofesional_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV18FotoProfesional))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavFotoprofesional_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV18FotoProfesional), true);
      AV45Fotoprofesional_GXI = ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilfotografia_gxi() ;
      httpContext.ajax_rsp_assign_prop("", false, imgavFotoprofesional_Internalname, "Bitmap", ((GXutil.strcmp("", AV18FotoProfesional)==0) ? AV45Fotoprofesional_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV18FotoProfesional))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavFotoprofesional_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV18FotoProfesional), true);
      AV19HtmlDetalleProfesional += "<div class=\"profile-widget\" style=\"width:100%;display:inline-block;border:none;border-radius:0px;margin-bottom:-30px;\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "    <div class=\"pro-content\" style=\"margin-top: -55px;\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "        <h3 class=\"title\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "            <a tabindex=\"0\">" + GXutil.upper( ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilnombresapellidos()) + "<i class=\"fas fa-check-circle verified\"></i></a>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "        </h3>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "        <ul class=\"available-info\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "            <li>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "                <i class=\"fas fa-book-medical\"></i>" + ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilespecialidades() + "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "            </li>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "            <li>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "                <i class=\"fas fa-map-marker-alt\"></i>" + ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfildireccion() + "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "            </li>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "            <li>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV42NroOpiniones = (short)(A40000GXC1) ;
      AV19HtmlDetalleProfesional += "                <i class=\"far fa-comment\"></i>" + GXutil.str( AV42NroOpiniones, 4, 0) + " Opiniones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "            </li>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "        </ul>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "        <div class=\"rating\" style=\"margin-top:-10px;\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      if ( ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion() == 0 )
      {
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      }
      else if ( ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion() == 1 )
      {
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      }
      else if ( ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion() == 2 )
      {
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      }
      else if ( ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion() == 3 )
      {
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      }
      else if ( ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion() == 4 )
      {
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      }
      else if ( ((com.projectthani.SdtSDTProfesionalPerfil)AV34Profesionales.elementAt(-1+1)).getgxTv_SdtSDTProfesionalPerfil_Sdtprofesionalperfilcalificacion() == 5 )
      {
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
         AV19HtmlDetalleProfesional += "<i class=\"fas fa-star filled\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      }
      AV36RatingNroRegistros = (short)(A40001GXC2) ;
      AV19HtmlDetalleProfesional += "            <span class=\"d-inline-block average-rating\">(" + GXutil.str( AV36RatingNroRegistros, 4, 0) + ")</span>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "        </div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "    </div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      AV19HtmlDetalleProfesional += "</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19HtmlDetalleProfesional", AV19HtmlDetalleProfesional);
      lblDetalleprofesional_Caption = AV19HtmlDetalleProfesional ;
      httpContext.ajax_rsp_assign_prop("", false, lblDetalleprofesional_Internalname, "Caption", lblDetalleprofesional_Caption, true);
   }

   public void S122( )
   {
      /* 'LISTAEDUCACION' Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTProfesionalEducacionPerfil2[0] = AV21ListaEducacion ;
      new com.projectthani.prcgetprofesionaleducacion(remoteHandle, context).execute( AV35ProfesionalId, GXv_objcol_SdtSDTProfesionalEducacionPerfil2) ;
      AV21ListaEducacion = GXv_objcol_SdtSDTProfesionalEducacionPerfil2[0] ;
      AV25ListEducacion += "<div class=\"widget education-widget\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
      AV25ListEducacion += "    <div class=\"experience-box\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
      AV25ListEducacion += "        <ul class=\"experience-list\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV21ListaEducacion.size() )
      {
         AV14Educacion = (com.projectthani.SdtSDTProfesionalEducacionPerfil)((com.projectthani.SdtSDTProfesionalEducacionPerfil)AV21ListaEducacion.elementAt(-1+AV46GXV1));
         AV25ListEducacion += "            <li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                <div class=\"experience-user\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                    <div class=\"before-circle\"></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                <div class=\"experience-content\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                    <div class=\"timeline-content\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                        <a href=\"#\" class=\"name\" style=\"font-size: 14px;white-space: normal;\">" + AV14Educacion.getgxTv_SdtSDTProfesionalEducacionPerfil_Nombreinstitucion() + "</a>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                        <div>" + AV14Educacion.getgxTv_SdtSDTProfesionalEducacionPerfil_Paisnombre() + "</div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV12DesdeEdu = (short)(GXutil.year( AV14Educacion.getgxTv_SdtSDTProfesionalEducacionPerfil_Desde())) ;
         AV6AstaEdu = (short)(GXutil.year( AV14Educacion.getgxTv_SdtSDTProfesionalEducacionPerfil_Hasta())) ;
         AV25ListEducacion += "                        <span class=\"time\">" + GXutil.str( AV12DesdeEdu, 4, 0) + " - " + GXutil.str( AV6AstaEdu, 4, 0) + "</span>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                    </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "                </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV25ListEducacion += "            </li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
      AV25ListEducacion += "        </ul>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
      AV25ListEducacion += "    </div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
      AV25ListEducacion += "</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ListEducacion", AV25ListEducacion);
      lblTbeducacion_Caption = AV25ListEducacion ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbeducacion_Internalname, "Caption", lblTbeducacion_Caption, true);
   }

   public void S132( )
   {
      /* 'EPERIENCIALABORAL' Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTProfesionalExperienciaLaboralProfesional3[0] = AV22ListaExperienciaLaboral ;
      new com.projectthani.prcgetprofesionalexperiencialaboral(remoteHandle, context).execute( AV35ProfesionalId, GXv_objcol_SdtSDTProfesionalExperienciaLaboralProfesional3) ;
      AV22ListaExperienciaLaboral = GXv_objcol_SdtSDTProfesionalExperienciaLaboralProfesional3[0] ;
      AV26ListExperienciaLaboral += "<div class=\"widget experience-widget\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
      AV26ListExperienciaLaboral += "    <div class=\"experience-box\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
      AV26ListExperienciaLaboral += "        <ul class=\"experience-list\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
      AV47GXV2 = 1 ;
      while ( AV47GXV2 <= AV22ListaExperienciaLaboral.size() )
      {
         AV15ExperienciaLaboral = (com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional)((com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional)AV22ListaExperienciaLaboral.elementAt(-1+AV47GXV2));
         AV26ListExperienciaLaboral += "            <li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "                <div class=\"experience-user\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "                    <div class=\"before-circle\"></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "                </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "                <div class=\"experience-content\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "                    <div class=\"timeline-content\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "                        <a href=\"#/\" class=\"name\" style=\"font-size:14px;\">" + AV15ExperienciaLaboral.getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Nombreempresa() + "</a>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV13DesdeExp = (short)(GXutil.year( AV15ExperienciaLaboral.getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Desde())) ;
         AV7AstaExp = (short)(GXutil.year( AV15ExperienciaLaboral.getgxTv_SdtSDTProfesionalExperienciaLaboralProfesional_Hasta())) ;
         AV41YearActual = (short)(GXutil.year( Gx_date)) ;
         AV39SumaYear = (short)(AV7AstaExp-AV13DesdeExp) ;
         if ( ( AV7AstaExp == AV41YearActual ) && ( AV13DesdeExp == AV41YearActual ) )
         {
            AV26ListExperienciaLaboral += "<span class=\"time\" style=\"font-size:14px;\">" + GXutil.str( AV13DesdeExp, 4, 0) + " - Actualidad (1 año)</span>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         }
         if ( ( AV7AstaExp == AV41YearActual ) && ( AV13DesdeExp != AV41YearActual ) )
         {
            AV26ListExperienciaLaboral += "<span class=\"time\" style=\"font-size:14px;\">" + GXutil.str( AV13DesdeExp, 4, 0) + " - Actualidad (" + GXutil.str( AV39SumaYear, 4, 0) + " años)</span>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         }
         if ( ( AV13DesdeExp == AV7AstaExp ) && ( AV7AstaExp != AV41YearActual ) && ( AV13DesdeExp != AV41YearActual ) )
         {
            AV26ListExperienciaLaboral += "<span class=\"time\" style=\"font-size:14px;\">" + GXutil.str( AV13DesdeExp, 4, 0) + " - " + GXutil.str( AV7AstaExp, 4, 0) + "(1 año)</span>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         }
         if ( ( AV7AstaExp != AV41YearActual ) && ( AV13DesdeExp != AV41YearActual ) && ( AV13DesdeExp != AV7AstaExp ) )
         {
            AV26ListExperienciaLaboral += "<span class=\"time\"style=\"font-size:14px;\">" + GXutil.str( AV13DesdeExp, 4, 0) + " - " + GXutil.str( AV7AstaExp, 4, 0) + " (" + GXutil.str( AV39SumaYear, 4, 0) + " años)</span>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         }
         AV26ListExperienciaLaboral += "                    </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "                </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV26ListExperienciaLaboral += "            </li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
         AV47GXV2 = (int)(AV47GXV2+1) ;
      }
      AV26ListExperienciaLaboral += "        </ul>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
      AV26ListExperienciaLaboral += "    </div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
      AV26ListExperienciaLaboral += "</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ListExperienciaLaboral", AV26ListExperienciaLaboral);
      lblTbexperiencialaboral_Caption = AV26ListExperienciaLaboral ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbexperiencialaboral_Internalname, "Caption", lblTbexperiencialaboral_Caption, true);
   }

   public void S142( )
   {
      /* 'PREMIOS' Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTProfesionalPremiosPerfil4[0] = AV23ListaPremios ;
      new com.projectthani.prcgetprofesionalpremios(remoteHandle, context).execute( AV35ProfesionalId, GXv_objcol_SdtSDTProfesionalPremiosPerfil4) ;
      AV23ListaPremios = GXv_objcol_SdtSDTProfesionalPremiosPerfil4[0] ;
      AV27ListPremios += "<div class=\"widget awards-widget\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
      AV27ListPremios += "    <div class=\"experience-box\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
      AV27ListPremios += "        <ul class=\"experience-list\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
      AV49GXV3 = 1 ;
      while ( AV49GXV3 <= AV23ListaPremios.size() )
      {
         AV31Premios = (com.projectthani.SdtSDTProfesionalPremiosPerfil)((com.projectthani.SdtSDTProfesionalPremiosPerfil)AV23ListaPremios.elementAt(-1+AV49GXV3));
         AV40Year = (short)(GXutil.year( AV31Premios.getgxTv_SdtSDTProfesionalPremiosPerfil_Fecha())) ;
         AV10Day = (short)(GXutil.day( AV31Premios.getgxTv_SdtSDTProfesionalPremiosPerfil_Fecha())) ;
         AV30Month = localUtil.cmonth( AV31Premios.getgxTv_SdtSDTProfesionalPremiosPerfil_Fecha(), "spa") ;
         AV16FechaActual = GXutil.str( AV10Day, 4, 0) + " de " + GXutil.lower( AV30Month) + " del " + GXutil.str( AV40Year, 4, 0) ;
         AV27ListPremios += "           <li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                <div class=\"experience-user\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                    <div class=\"before-circle\"></div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                <div class=\"experience-content\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                    <div class=\"timeline-content\">" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                        <p class=\"exp-year\" style=\"font-size:17px;\">" + AV16FechaActual + "</p>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                        <h4 class=\"exp-title\">" + AV31Premios.getgxTv_SdtSDTProfesionalPremiosPerfil_Nombre() + "</h4>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                        <p style=\"font-size:14px;\">" + AV31Premios.getgxTv_SdtSDTProfesionalPremiosPerfil_Descripcion() + "</p>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                    </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "                </div>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV27ListPremios += "            </li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
         AV49GXV3 = (int)(AV49GXV3+1) ;
      }
      AV27ListPremios += "        </ul>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
      AV27ListPremios += "    </div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
      AV27ListPremios += "</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ListPremios", AV27ListPremios);
      lblTbpremios_Caption = AV27ListPremios ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbpremios_Internalname, "Caption", lblTbpremios_Caption, true);
   }

   public void S152( )
   {
      /* 'SERVICIOS' Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTProfesionalServiciosPerfil5[0] = AV24ListaServicios ;
      new com.projectthani.prcgetprofesionalservicios(remoteHandle, context).execute( AV35ProfesionalId, GXv_objcol_SdtSDTProfesionalServiciosPerfil5) ;
      AV24ListaServicios = GXv_objcol_SdtSDTProfesionalServiciosPerfil5[0] ;
      AV28ListServicios += "<div class=\"service-list\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ListServicios", AV28ListServicios);
      AV28ListServicios += "    <ul class=\"clearfix\" style=\"font-size:14px;\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ListServicios", AV28ListServicios);
      AV50GXV4 = 1 ;
      while ( AV50GXV4 <= AV24ListaServicios.size() )
      {
         AV38Servicios = (com.projectthani.SdtSDTProfesionalServiciosPerfil)((com.projectthani.SdtSDTProfesionalServiciosPerfil)AV24ListaServicios.elementAt(-1+AV50GXV4));
         AV28ListServicios += "        <li>" + AV38Servicios.getgxTv_SdtSDTProfesionalServiciosPerfil_Nombreservicio() + "</li>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28ListServicios", AV28ListServicios);
         AV50GXV4 = (int)(AV50GXV4+1) ;
      }
      AV28ListServicios += "    </ul>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ListServicios", AV28ListServicios);
      AV28ListServicios += "</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28ListServicios", AV28ListServicios);
      lblTbservicios_Caption = AV28ListServicios ;
      httpContext.ajax_rsp_assign_prop("", false, lblTbservicios_Internalname, "Caption", lblTbservicios_Caption, true);
   }

   public void S162( )
   {
      /* 'OPINIONESPROFESIONAL' Routine */
      returnInSub = false ;
      AV20HtmlOpinion += "	<div class=\"widget review-listing\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
      AV20HtmlOpinion += "		<ul class=\"comments-list\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
      GXv_objcol_SdtSDTComentariosProfesional6[0] = AV9ComentarioList ;
      new com.projectthani.prccomentariosprofesional(remoteHandle, context).execute( AV35ProfesionalId, GXv_objcol_SdtSDTComentariosProfesional6) ;
      AV9ComentarioList = GXv_objcol_SdtSDTComentariosProfesional6[0] ;
      AV51GXV5 = 1 ;
      while ( AV51GXV5 <= AV9ComentarioList.size() )
      {
         AV8ComentarioItem = (com.projectthani.SdtSDTComentariosProfesional)((com.projectthani.SdtSDTComentariosProfesional)AV9ComentarioList.elementAt(-1+AV51GXV5));
         if ( ! (GXutil.strcmp("", AV8ComentarioItem.getgxTv_SdtSDTComentariosProfesional_Comentario())==0) )
         {
            AV5Paciente.Load(AV8ComentarioItem.getgxTv_SdtSDTComentariosProfesional_Pacienteid());
            AV20HtmlOpinion += "			<li>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "				<div class=\"comment\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "A") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "a") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "6ea3666f-505d-4848-9afb-87150432b315", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "B") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "b") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "abe91b5a-9e1e-4a8c-a17f-e64439b2d500", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "C") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "c") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "634d65de-217f-4743-93a6-e1b6a380191e", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "D") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "d") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "b25b5ad8-06a6-4b6f-9d3e-159719bd1642", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "E") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "e") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "a72cbc5e-313f-4e40-8f2f-17927c632552", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "F") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "f") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "a1a3349f-c240-44a1-b4af-e0f0dfff1a71", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "G") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "g") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "7caba0a8-41cc-43c2-bc6b-f84f4c4453b5", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "H") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "h") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "1c4c6a26-c7d2-4ae9-85b0-ba33d6b57a55", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "I") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "i") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "1b8c72bd-aa45-436f-89c6-1a2e2c6d142e", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "J") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "j") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "16d8dea8-53b5-427c-9a36-222b42f8210b", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "K") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "k") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "22d115a9-6edd-406f-a963-c99342858481", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "L") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "l") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "acf88e6e-0770-4f5a-a762-313b5933faf3", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "M") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "m") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "59980e09-7b0c-41b5-8250-525ec4da4b98", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "N") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "n") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "2dc75701-3327-4d6f-a3c5-caef09e2b6c0", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "Ñ") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "ñ") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "2dc75701-3327-4d6f-a3c5-caef09e2b6c0", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "O") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "o") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "7f40336d-5bf8-471d-8824-362f3f713c7f", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "P") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "p") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "b5516059-dfa3-4f12-9b23-8bb5d49c0e23", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "Q") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "q") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "f04bfb80-08b9-40d1-9088-5d399bf3d3aa", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "R") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "r") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "454e60cf-327d-4989-b6ec-c9db47c4a20b", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "S") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "s") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "44d01d62-9a6b-4ef6-b9fb-f1914767185e", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "T") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "t") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "e2cfe4c2-cda5-4b47-b281-f2874b8dba93", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "U") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "u") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "2c950e38-e891-4a35-8587-194fb308d453", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "V") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "v") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "71d123b5-b8e5-42fe-bb54-bb68a318cb2a", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "W") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "w") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "cbdd984f-e9a5-4215-b262-9d1bc7e5f6ba", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "X") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "x") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "d5c78b03-e2de-4012-aeeb-88ec5c09c16f", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "Y") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "y") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "6088b719-b9ef-470b-95da-85042a6e192e", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else if ( ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "Z") == 0 ) || ( GXutil.strcmp(GXutil.substring( AV5Paciente.getgxTv_SdtPaciente_Pacientenombres(), 1, 1), "z") == 0 ) )
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "779d77ed-1ba5-4b4b-be6c-a2a6b97408df", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            else
            {
               AV20HtmlOpinion += "<img src=\"" + httpContext.convertURL( context.getHttpContext().getImagePath( "896d6dcd-8a68-45bb-82b6-794d23c2d80b", "", context.getHttpContext().getTheme( ))) + "\" class=\"avatar avatar-sm rounded-circle\">" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            }
            AV20HtmlOpinion += "					<div class=\"comment-body\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "						<div class=\"meta-data\">" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "							<span class=\"comment-author\"><font style=\"vertical-align: inherit;\">" + AV5Paciente.getgxTv_SdtPaciente_Pacientenombres() + " " + AV5Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() + " " + AV5Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() + "</font></span>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV29MesSpa = localUtil.cmonth( AV8ComentarioItem.getgxTv_SdtSDTComentariosProfesional_Fecharegistro(), "spa") ;
            AV17FechaComentario = "Opinión escrita el " + GXutil.str( GXutil.day( AV8ComentarioItem.getgxTv_SdtSDTComentariosProfesional_Fecharegistro()), 10, 0) + " de " + GXutil.lower( AV29MesSpa) + " del " + GXutil.str( GXutil.year( AV8ComentarioItem.getgxTv_SdtSDTComentariosProfesional_Fecharegistro()), 10, 0) ;
            AV20HtmlOpinion += "							<span class=\"comment-date\"><font style=\"vertical-align: inherit;\">" + AV17FechaComentario + "</font></span>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "						</div>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "						<p class=\"comment-content\"><font style=\"vertical-align: inherit;\">" + AV8ComentarioItem.getgxTv_SdtSDTComentariosProfesional_Comentario() + "</font></p>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "					</div>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "				</div>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
            AV20HtmlOpinion += "			</li>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
         }
         AV51GXV5 = (int)(AV51GXV5+1) ;
      }
      AV20HtmlOpinion += "		</ul>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
      AV20HtmlOpinion += "	</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20HtmlOpinion", AV20HtmlOpinion);
      lblTxtopiniones_Caption = AV20HtmlOpinion ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxtopiniones_Internalname, "Caption", lblTxtopiniones_Caption, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e13692( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV35ProfesionalId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35ProfesionalId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35ProfesionalId), "ZZZZZZZ9")));
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
      pa692( ) ;
      ws692( ) ;
      we692( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034487", true, true);
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
      httpContext.AddJavascriptSource("wpprofesionalperfil.js", "?2022511034487", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgavFotoprofesional_Internalname = "vFOTOPROFESIONAL" ;
      divTable3_Internalname = "TABLE3" ;
      lblDetalleprofesional_Internalname = "DETALLEPROFESIONAL" ;
      bttBtnagendarcita_Internalname = "BTNAGENDARCITA" ;
      divTable4_Internalname = "TABLE4" ;
      divTable1_Internalname = "TABLE1" ;
      divTableperfil_Internalname = "TABLEPERFIL" ;
      lblOverwiew_title_Internalname = "OVERWIEW_TITLE" ;
      edtavDescripcion_Internalname = "vDESCRIPCION" ;
      divTabpage1table_Internalname = "TABPAGE1TABLE" ;
      lblTabpage2_title_Internalname = "TABPAGE2_TITLE" ;
      lblTbeducacion_Internalname = "TBEDUCACION" ;
      divTabpage2table_Internalname = "TABPAGE2TABLE" ;
      lblTabpage3_title_Internalname = "TABPAGE3_TITLE" ;
      lblTbexperiencialaboral_Internalname = "TBEXPERIENCIALABORAL" ;
      divTabpage3table_Internalname = "TABPAGE3TABLE" ;
      lblTabpage1_title_Internalname = "TABPAGE1_TITLE" ;
      lblTbpremios_Internalname = "TBPREMIOS" ;
      divTabpage1table1_Internalname = "TABPAGE1TABLE1" ;
      lblTabpage4_title_Internalname = "TABPAGE4_TITLE" ;
      lblTbservicios_Internalname = "TBSERVICIOS" ;
      divTabpage4table_Internalname = "TABPAGE4TABLE" ;
      lblTabpageopiniones_title_Internalname = "TABPAGEOPINIONES_TITLE" ;
      lblTxtopiniones_Internalname = "TXTOPINIONES" ;
      divTabpage5table_Internalname = "TABPAGE5TABLE" ;
      Tabdetalleperfil_Internalname = "TABDETALLEPERFIL" ;
      divTable2_Internalname = "TABLE2" ;
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
      lblTxtopiniones_Caption = "Text Block" ;
      lblTbservicios_Caption = "Text Block" ;
      lblTbpremios_Caption = "Text Block" ;
      lblTbexperiencialaboral_Caption = "Text Block" ;
      lblTbeducacion_Caption = "Text Block" ;
      edtavDescripcion_Enabled = 1 ;
      lblDetalleprofesional_Caption = "Text Block" ;
      Tabdetalleperfil_Historymanagement = GXutil.toBoolean( 0) ;
      Tabdetalleperfil_Class = "Tab" ;
      Tabdetalleperfil_Pagecount = 6 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Perfil del Médico" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV34Profesionales',fld:'vPROFESIONALES',pic:'',hsh:true},{av:'AV35ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'BTNAGENDARCITA'","{handler:'e11691',iparms:[{av:'AV34Profesionales',fld:'vPROFESIONALES',pic:'',hsh:true}]");
      setEventMetadata("'BTNAGENDARCITA'",",oparms:[]}");
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
      AV34Profesionales = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil>(com.projectthani.SdtSDTProfesionalPerfil.class, "SDTProfesionalPerfil", "ProjectThani", remoteHandle);
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV18FotoProfesional = "" ;
      AV45Fotoprofesional_GXI = "" ;
      sImgUrl = "" ;
      lblDetalleprofesional_Jsonclick = "" ;
      TempTags = "" ;
      bttBtnagendarcita_Jsonclick = "" ;
      ucTabdetalleperfil = new com.genexus.webpanels.GXUserControl();
      lblOverwiew_title_Jsonclick = "" ;
      AV11Descripcion = "" ;
      lblTabpage2_title_Jsonclick = "" ;
      lblTbeducacion_Jsonclick = "" ;
      lblTabpage3_title_Jsonclick = "" ;
      lblTbexperiencialaboral_Jsonclick = "" ;
      lblTabpage1_title_Jsonclick = "" ;
      lblTbpremios_Jsonclick = "" ;
      lblTabpage4_title_Jsonclick = "" ;
      lblTbservicios_Jsonclick = "" ;
      lblTabpageopiniones_title_Jsonclick = "" ;
      lblTxtopiniones_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      Gx_date = GXutil.nullDate() ;
      scmdbuf = "" ;
      H00693_A40000GXC1 = new int[1] ;
      H00693_n40000GXC1 = new boolean[] {false} ;
      H00695_A40001GXC2 = new int[1] ;
      H00695_n40001GXC2 = new boolean[] {false} ;
      GXv_objcol_SdtSDTProfesionalPerfil1 = new GXBaseCollection[1] ;
      H00697_A40000GXC1 = new int[1] ;
      H00697_n40000GXC1 = new boolean[] {false} ;
      H00699_A40001GXC2 = new int[1] ;
      H00699_n40001GXC2 = new boolean[] {false} ;
      AV19HtmlDetalleProfesional = "" ;
      AV21ListaEducacion = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil>(com.projectthani.SdtSDTProfesionalEducacionPerfil.class, "SDTProfesionalEducacionPerfil", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTProfesionalEducacionPerfil2 = new GXBaseCollection[1] ;
      AV25ListEducacion = "" ;
      AV14Educacion = new com.projectthani.SdtSDTProfesionalEducacionPerfil(remoteHandle, context);
      AV22ListaExperienciaLaboral = new GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional>(com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional.class, "SDTProfesionalExperienciaLaboralProfesional", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTProfesionalExperienciaLaboralProfesional3 = new GXBaseCollection[1] ;
      AV26ListExperienciaLaboral = "" ;
      AV15ExperienciaLaboral = new com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional(remoteHandle, context);
      AV23ListaPremios = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil>(com.projectthani.SdtSDTProfesionalPremiosPerfil.class, "SDTProfesionalPremiosPerfil", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTProfesionalPremiosPerfil4 = new GXBaseCollection[1] ;
      AV27ListPremios = "" ;
      AV31Premios = new com.projectthani.SdtSDTProfesionalPremiosPerfil(remoteHandle, context);
      AV30Month = "" ;
      AV16FechaActual = "" ;
      AV24ListaServicios = new GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil>(com.projectthani.SdtSDTProfesionalServiciosPerfil.class, "SDTProfesionalServiciosPerfil", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTProfesionalServiciosPerfil5 = new GXBaseCollection[1] ;
      AV28ListServicios = "" ;
      AV38Servicios = new com.projectthani.SdtSDTProfesionalServiciosPerfil(remoteHandle, context);
      AV20HtmlOpinion = "" ;
      AV9ComentarioList = new GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional>(com.projectthani.SdtSDTComentariosProfesional.class, "SDTComentariosProfesional", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTComentariosProfesional6 = new GXBaseCollection[1] ;
      AV8ComentarioItem = new com.projectthani.SdtSDTComentariosProfesional(remoteHandle, context);
      AV5Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV29MesSpa = "" ;
      AV17FechaComentario = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpprofesionalperfil__default(),
         new Object[] {
             new Object[] {
            H00693_A40000GXC1, H00693_n40000GXC1
            }
            , new Object[] {
            H00695_A40001GXC2, H00695_n40001GXC2
            }
            , new Object[] {
            H00697_A40000GXC1, H00697_n40000GXC1
            }
            , new Object[] {
            H00699_A40001GXC2, H00699_n40001GXC2
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavDescripcion_Enabled = 0 ;
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
   private short AV37RatingProf ;
   private short AV42NroOpiniones ;
   private short AV36RatingNroRegistros ;
   private short AV12DesdeEdu ;
   private short AV6AstaEdu ;
   private short AV13DesdeExp ;
   private short AV7AstaExp ;
   private short AV41YearActual ;
   private short AV39SumaYear ;
   private short AV40Year ;
   private short AV10Day ;
   private int wcpOAV35ProfesionalId ;
   private int AV35ProfesionalId ;
   private int A40000GXC1 ;
   private int A40001GXC2 ;
   private int Tabdetalleperfil_Pagecount ;
   private int edtavDescripcion_Enabled ;
   private int AV46GXV1 ;
   private int AV47GXV2 ;
   private int AV49GXV3 ;
   private int AV50GXV4 ;
   private int AV51GXV5 ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Tabdetalleperfil_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable2_Internalname ;
   private String divTableperfil_Internalname ;
   private String divTable1_Internalname ;
   private String divTable3_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgavFotoprofesional_Internalname ;
   private String divTable4_Internalname ;
   private String lblDetalleprofesional_Internalname ;
   private String lblDetalleprofesional_Caption ;
   private String lblDetalleprofesional_Jsonclick ;
   private String TempTags ;
   private String bttBtnagendarcita_Internalname ;
   private String bttBtnagendarcita_Jsonclick ;
   private String Tabdetalleperfil_Internalname ;
   private String lblOverwiew_title_Internalname ;
   private String lblOverwiew_title_Jsonclick ;
   private String divTabpage1table_Internalname ;
   private String edtavDescripcion_Internalname ;
   private String lblTabpage2_title_Internalname ;
   private String lblTabpage2_title_Jsonclick ;
   private String divTabpage2table_Internalname ;
   private String lblTbeducacion_Internalname ;
   private String lblTbeducacion_Caption ;
   private String lblTbeducacion_Jsonclick ;
   private String lblTabpage3_title_Internalname ;
   private String lblTabpage3_title_Jsonclick ;
   private String divTabpage3table_Internalname ;
   private String lblTbexperiencialaboral_Internalname ;
   private String lblTbexperiencialaboral_Caption ;
   private String lblTbexperiencialaboral_Jsonclick ;
   private String lblTabpage1_title_Internalname ;
   private String lblTabpage1_title_Jsonclick ;
   private String divTabpage1table1_Internalname ;
   private String lblTbpremios_Internalname ;
   private String lblTbpremios_Caption ;
   private String lblTbpremios_Jsonclick ;
   private String lblTabpage4_title_Internalname ;
   private String lblTabpage4_title_Jsonclick ;
   private String divTabpage4table_Internalname ;
   private String lblTbservicios_Internalname ;
   private String lblTbservicios_Caption ;
   private String lblTbservicios_Jsonclick ;
   private String lblTabpageopiniones_title_Internalname ;
   private String lblTabpageopiniones_title_Jsonclick ;
   private String divTabpage5table_Internalname ;
   private String lblTxtopiniones_Internalname ;
   private String lblTxtopiniones_Caption ;
   private String lblTxtopiniones_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Tabdetalleperfil_Historymanagement ;
   private boolean wbLoad ;
   private boolean AV18FotoProfesional_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000GXC1 ;
   private boolean n40001GXC2 ;
   private boolean returnInSub ;
   private String AV19HtmlDetalleProfesional ;
   private String AV25ListEducacion ;
   private String AV26ListExperienciaLaboral ;
   private String AV27ListPremios ;
   private String AV28ListServicios ;
   private String AV20HtmlOpinion ;
   private String AV45Fotoprofesional_GXI ;
   private String AV11Descripcion ;
   private String AV30Month ;
   private String AV16FechaActual ;
   private String AV29MesSpa ;
   private String AV17FechaComentario ;
   private String AV18FotoProfesional ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucTabdetalleperfil ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private IDataStoreProvider pr_default ;
   private int[] H00693_A40000GXC1 ;
   private boolean[] H00693_n40000GXC1 ;
   private int[] H00695_A40001GXC2 ;
   private boolean[] H00695_n40001GXC2 ;
   private int[] H00697_A40000GXC1 ;
   private boolean[] H00697_n40000GXC1 ;
   private int[] H00699_A40001GXC2 ;
   private boolean[] H00699_n40001GXC2 ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional> AV9ComentarioList ;
   private GXBaseCollection<com.projectthani.SdtSDTComentariosProfesional> GXv_objcol_SdtSDTComentariosProfesional6[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil> AV21ListaEducacion ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacionPerfil> GXv_objcol_SdtSDTProfesionalEducacionPerfil2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional> AV22ListaExperienciaLaboral ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional> GXv_objcol_SdtSDTProfesionalExperienciaLaboralProfesional3[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil> AV23ListaPremios ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremiosPerfil> GXv_objcol_SdtSDTProfesionalPremiosPerfil4[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil> AV24ListaServicios ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServiciosPerfil> GXv_objcol_SdtSDTProfesionalServiciosPerfil5[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil> AV34Profesionales ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPerfil> GXv_objcol_SdtSDTProfesionalPerfil1[] ;
   private com.projectthani.SdtPaciente AV5Paciente ;
   private com.projectthani.SdtSDTComentariosProfesional AV8ComentarioItem ;
   private com.projectthani.SdtSDTProfesionalEducacionPerfil AV14Educacion ;
   private com.projectthani.SdtSDTProfesionalExperienciaLaboralProfesional AV15ExperienciaLaboral ;
   private com.projectthani.SdtSDTProfesionalPremiosPerfil AV31Premios ;
   private com.projectthani.SdtSDTProfesionalServiciosPerfil AV38Servicios ;
}

final  class wpprofesionalperfil__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00693", "SELECT COALESCE( T1.[GXC1], 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1 FROM [ComentarioProfesional] WHERE [SGProfesionalProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00695", "SELECT COALESCE( T1.[GXC2], 0) AS GXC2 FROM (SELECT COUNT(*) AS GXC2 FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00697", "SELECT COALESCE( T1.[GXC1], 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1 FROM [ComentarioProfesional] WHERE [SGProfesionalProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00699", "SELECT COALESCE( T1.[GXC2], 0) AS GXC2 FROM (SELECT COUNT(*) AS GXC2 FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

