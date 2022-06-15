package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpcalificaratencionplataforma_impl extends GXDataArea
{
   public wpcalificaratencionplataforma_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpcalificaratencionplataforma_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpcalificaratencionplataforma_impl.class ));
   }

   public wpcalificaratencionplataforma_impl( int remoteHandle ,
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
            AV10DisponibilidadId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10DisponibilidadId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10DisponibilidadId), "ZZZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV8CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CitaId), 8, 0));
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CitaId), "ZZZZZZZ9")));
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
      pa6W2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6W2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034738", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("StarRating/StarRatingRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoHomPagPaciente\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoHomPagPaciente\" data-gx-class=\"form-horizontal FormFondoHomPagPaciente\" novalidate action=\""+formatLink("com.projectthani.wpcalificaratencionplataforma", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10DisponibilidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CitaId,8,0))}, new String[] {"DisponibilidadId","CitaId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10DisponibilidadId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vRATINGPLATAFORMAA", GXutil.ltrim( localUtil.ntoc( AV20RatingPlataformaa, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV18PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV8CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CitaId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vRATINGPLATAFORMA", AV5RatingPlataforma);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vRATINGPLATAFORMA", AV5RatingPlataforma);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSUGERENCIASMEJORASPLATAFORMA", AV6SugerenciasMejorasPlataforma);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSUGERENCIASMEJORASPLATAFORMA", AV6SugerenciasMejorasPlataforma);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV10DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10DisponibilidadId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMAA_Enabled", GXutil.booltostr( Ratingplataformaa_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMAA_Captionclass", GXutil.rtrim( Ratingplataformaa_Captionclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMAA_Captionstyle", GXutil.rtrim( Ratingplataformaa_Captionstyle));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMAA_Captionposition", GXutil.rtrim( Ratingplataformaa_Captionposition));
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
         we6W2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6W2( ) ;
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
      return formatLink("com.projectthani.wpcalificaratencionplataforma", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV10DisponibilidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CitaId,8,0))}, new String[] {"DisponibilidadId","CitaId"})  ;
   }

   public String getPgmname( )
   {
      return "WPCalificarAtencionPlataforma" ;
   }

   public String getPgmdesc( )
   {
      return "Calificar Atención Plataforma" ;
   }

   public void wb6W0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "TableMainCalificacion", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablefromcalificacion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabletitle_Internalname, 1, 0, "px", 0, "px", "TableTitleHomePagePaciente", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock6_Internalname, "Calificar la calidad de la plataforma", "", "", lblTextblock6_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockCitas", 0, "", 1, 1, 0, (short)(0), "HLP_WPCalificarAtencionPlataforma.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableMejorasSugerencias", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesubtitle_Internalname, 1, 0, "px", 0, "px", "TableContTitle", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktilecal_Internalname, lblTextblocktilecal_Caption, "", "", lblTextblocktilecal_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockTitleDC", 0, "", 1, 1, 0, (short)(0), "HLP_WPCalificarAtencionPlataforma.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemejorassugerencias_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupcalificacion_Internalname, "Calificar la calidad de la plataforma", 1, 0, "px", 0, "px", "GroupCalificacion", "", "HLP_WPCalificarAtencionPlataforma.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "TableCalificacion", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 60, "px", "col-xs-12", "Center", "Middle", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* User Defined Control */
         ucRatingplataformaa.setProperty("TooltipText", Ratingplataformaa_Tooltiptext);
         ucRatingplataformaa.setProperty("Attribute", AV20RatingPlataformaa);
         ucRatingplataformaa.setProperty("CaptionClass", Ratingplataformaa_Captionclass);
         ucRatingplataformaa.setProperty("CaptionStyle", Ratingplataformaa_Captionstyle);
         ucRatingplataformaa.setProperty("CaptionPosition", Ratingplataformaa_Captionposition);
         ucRatingplataformaa.render(context, "starrating", Ratingplataformaa_Internalname, "RATINGPLATAFORMAAContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "Middle", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 col-xs-offset-1 TableMT16PX", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmalo_Internalname, "Deficiente", "", "", lblTextblockmalo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockCalDeficiente", 0, "", 1, 1, 0, (short)(0), "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 TableMT16PX", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, "Aceptable", "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockCalAceptable", 0, "", 1, 1, 0, (short)(0), "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 TableMT16PX", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock3_Internalname, "Regular", "", "", lblTextblock3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockCalRegular", 0, "", 1, 1, 0, (short)(0), "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 TableMT16PX", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock5_Internalname, "Bueno", "", "", lblTextblock5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockCalBueno", 0, "", 1, 1, 0, (short)(0), "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-2 TableMT16PX", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock4_Internalname, "Muy Bueno", "", "", lblTextblock4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockCalMuyBueno", 0, "", 1, 1, 0, (short)(0), "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupcomentarios_Internalname, "Déjanos tu opinión acerca de la plataforma", 1, 0, "px", 0, "px", "GroupComentarios", "", "HLP_WPCalificarAtencionPlataforma.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable6_Internalname, 1, 0, "px", 0, "px", "TableV2CalificarPlat", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavOpinionplataforma_Internalname, "Opinion Plataforma", "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavOpinionplataforma_Internalname, AV17OpinionPlataforma, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", (short)(0), 1, edtavOpinionplataforma_Enabled, 0, 80, "chr", 5, "row", StyleString, ClassString, "", "", "2097152", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup1_Internalname, "Déjanos tus sugerencias para la mejorar la plataforma", 1, 0, "px", 0, "px", "GroupComentarios", "", "HLP_WPCalificarAtencionPlataforma.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "TableV2CalificarPlat", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavMejoraraplataforma_Internalname, "Mejorara Plataforma", "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavMejoraraplataforma_Internalname, AV12MejoraraPlataforma, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", (short)(0), 1, edtavMejoraraplataforma_Enabled, 0, 80, "chr", 5, "row", StyleString, ClassString, "", "", "2097152", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "TableDetalleCitaComCal", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockfechacita_Internalname, lblTextblockfechacita_Caption, "", "", lblTextblockfechacita_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
         ClassString = "ButtonCalificacionEnviar" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttEnviar_Internalname, "", "Enviar", bttEnviar_Jsonclick, 5, "Enviar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ENVIAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
         ClassString = "ButtonCalificacionCancel" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar_Internalname, "", "Cancelar", bttCancelar_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116w1_client"+"'", TempTags, "", 2, "HLP_WPCalificarAtencionPlataforma.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
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
         /* User Defined Control */
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, "DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start6W2( )
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
         Form.getMeta().addItem("description", "Calificar Atención Plataforma", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6W0( ) ;
   }

   public void ws6W2( )
   {
      start6W2( ) ;
      evt6W2( ) ;
   }

   public void evt6W2( )
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
                           e126W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ENVIAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Enviar' */
                           e136W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e146W2 ();
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

   public void we6W2( )
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

   public void pa6W2( )
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
            GX_FocusControl = edtavOpinionplataforma_Internalname ;
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
      rf6W2( ) ;
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
   }

   public void rf6W2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e146W2 ();
         wb6W0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6W2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV18PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV8CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup6W0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e126W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV20RatingPlataformaa = (short)(localUtil.ctol( httpContext.cgiGet( "vRATINGPLATAFORMAA"), ",", ".")) ;
         Ratingplataformaa_Enabled = GXutil.strtobool( httpContext.cgiGet( "RATINGPLATAFORMAA_Enabled")) ;
         Ratingplataformaa_Captionclass = httpContext.cgiGet( "RATINGPLATAFORMAA_Captionclass") ;
         Ratingplataformaa_Captionstyle = httpContext.cgiGet( "RATINGPLATAFORMAA_Captionstyle") ;
         Ratingplataformaa_Captionposition = httpContext.cgiGet( "RATINGPLATAFORMAA_Captionposition") ;
         /* Read variables values. */
         AV17OpinionPlataforma = httpContext.cgiGet( edtavOpinionplataforma_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17OpinionPlataforma", AV17OpinionPlataforma);
         AV12MejoraraPlataforma = httpContext.cgiGet( edtavMejoraraplataforma_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12MejoraraPlataforma", AV12MejoraraPlataforma);
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
      e126W2 ();
      if (returnInSub) return;
   }

   public void e126W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/CalificacionCitaMedica.css\">" );
      Form.getJscriptsrc().add("sweetalert2.all.min.js") ;
      Form.getJscriptsrc().add("SweetAlert2.js") ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/bootstrap-4.min.css\" type=\"text/css\">" );
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/sweetalert2.min.css\" type=\"text/css\">" );
      if ( (GXutil.strcmp("", AV26WebSession.getValue("WSPacienteId"))==0) )
      {
         callWebObject(formatLink("com.projectthani.wploginpaciente", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      Form.getJscriptsrc().add("ActualizarPagina.js") ;
      this.executeExternalObjectMethod("", false, "AV7ActualizarPagina", "ActualizarPaginaV3", new Object[] {Integer.valueOf(1)}, false);
      AV18PacienteId = (int)(GXutil.lval( AV26WebSession.getValue("WSPacienteId"))) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18PacienteId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18PacienteId), "ZZZZZZZ9")));
      AV9Disponibilidad.Load(AV10DisponibilidadId);
      AV15MesSpa = localUtil.cmonth( AV9Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha(), "spa") ;
      AV11FechaDisponibilidad = GXutil.str( GXutil.day( AV9Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha()), 10, 0) + " DE " + GXutil.upper( AV15MesSpa) + " DEL " + GXutil.str( GXutil.year( AV9Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha()), 10, 0) ;
      lblTextblocktilecal_Caption = "Ayúdanos a mejorar la calidad de la plataforma dejando tu calificación, opinión y sugerencias." ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocktilecal_Internalname, "Caption", lblTextblocktilecal_Caption, true);
      lblTextblockfechacita_Caption = "<h2 style=\"font-size: 20px;color: #aeaeae;font-family:"+"MyriadPro-Bold"+";\"><i class=\"fas fa-calendar-alt\"></i><span>"+AV11FechaDisponibilidad+"</span></h2>" ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockfechacita_Internalname, "Caption", lblTextblockfechacita_Caption, true);
   }

   public void e136W2( )
   {
      /* 'Enviar' Routine */
      returnInSub = false ;
      AV13MensajeVal = (short)(0) ;
      AV14MensajeVal2 = (short)(0) ;
      if ( AV18PacienteId > 0 )
      {
         AV23valExist = (short)(0) ;
         AV24valExiste = (short)(0) ;
         if ( ! (0==AV20RatingPlataformaa) )
         {
            GXv_boolean1[0] = AV25ValRating ;
            new com.projectthani.prcvalidarexisteratingplataforma(remoteHandle, context).execute( AV18PacienteId, AV8CitaId, GXv_boolean1) ;
            wpcalificaratencionplataforma_impl.this.AV25ValRating = GXv_boolean1[0] ;
            if ( AV25ValRating )
            {
               AV23valExist = (short)(1) ;
            }
            else
            {
               /* Execute user subroutine: 'REGISTRARRATING' */
               S112 ();
               if (returnInSub) return;
               AV13MensajeVal = (short)(1) ;
            }
         }
         if ( ! (GXutil.strcmp("", AV17OpinionPlataforma)==0) || ! (GXutil.strcmp("", AV12MejoraraPlataforma)==0) )
         {
            GXv_boolean1[0] = AV22ValComentario ;
            new com.projectthani.prcvalidarexisteopplataforma(remoteHandle, context).execute( AV18PacienteId, AV8CitaId, GXv_boolean1) ;
            wpcalificaratencionplataforma_impl.this.AV22ValComentario = GXv_boolean1[0] ;
            if ( AV22ValComentario )
            {
               AV24valExiste = (short)(2) ;
            }
            else
            {
               /* Execute user subroutine: 'REGISTRAROPINIONSUGERENCIAS' */
               S122 ();
               if (returnInSub) return;
               AV13MensajeVal = (short)(AV13MensajeVal+1) ;
               AV14MensajeVal2 = (short)(2) ;
            }
         }
         if ( AV13MensajeVal == 1 )
         {
            AV16MsgSuccss = "Su calificación para la plataforma se registró con éxito" ;
            this.executeExternalObjectMethod("", false, "AV21SweetAlert", "Alert", new Object[] {"success","Registro Exitoso",AV16MsgSuccss,""}, false);
            callWebObject(formatLink("com.projectthani.wphomepaciente", new String[] {GXutil.URLEncode(GXutil.rtrim("MisCitas")),GXutil.URLEncode(GXutil.ltrimstr(-1,9,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else if ( ( AV13MensajeVal == 2 ) && ( AV14MensajeVal2 == 2 ) )
         {
            AV16MsgSuccss = "Su calificación, opinión y sugerencias se registraron con éxito" ;
            this.executeExternalObjectMethod("", false, "AV21SweetAlert", "Alert", new Object[] {"success","Registro Exitoso",AV16MsgSuccss,""}, false);
            callWebObject(formatLink("com.projectthani.wphomepaciente", new String[] {GXutil.URLEncode(GXutil.rtrim("MisCitas")),GXutil.URLEncode(GXutil.ltrimstr(-1,9,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else if ( ( AV13MensajeVal == 1 ) && ( AV14MensajeVal2 == 2 ) )
         {
            AV16MsgSuccss = "Su calificación, opinión y sugerencias se registraron con éxito" ;
            this.executeExternalObjectMethod("", false, "AV21SweetAlert", "Alert", new Object[] {"success","Registro Exitoso",AV16MsgSuccss,""}, false);
            callWebObject(formatLink("com.projectthani.wphomepaciente", new String[] {GXutil.URLEncode(GXutil.rtrim("MisCitas")),GXutil.URLEncode(GXutil.ltrimstr(-1,9,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else if ( ( AV23valExist == 1 ) && ( AV24valExiste == 2 ) )
         {
            AV16MsgSuccss = "Usted ya registro una calificación, opinión y sugerencias para mejorar la plataforma" ;
            this.executeExternalObjectMethod("", false, "AV21SweetAlert", "Alert", new Object[] {"success","Existe Registro",AV16MsgSuccss,""}, false);
            callWebObject(formatLink("com.projectthani.wphomepaciente", new String[] {GXutil.URLEncode(GXutil.rtrim("MisCitas")),GXutil.URLEncode(GXutil.ltrimstr(-1,9,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      else
      {
         this.executeExternalObjectMethod("", false, "AV21SweetAlert", "Alert", new Object[] {"error","Registro Erróneo","Su calificación, opinión y sugerencias no se registraron, intente nuevamente",""}, false);
         callWebObject(formatLink("com.projectthani.wphomepaciente", new String[] {GXutil.URLEncode(GXutil.rtrim("MisCitas")),GXutil.URLEncode(GXutil.ltrimstr(-1,9,0))}, new String[] {"PantallaEdit","PacienteFamiliarIdEdit"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5RatingPlataforma", AV5RatingPlataforma);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV6SugerenciasMejorasPlataforma", AV6SugerenciasMejorasPlataforma);
   }

   public void S112( )
   {
      /* 'REGISTRARRATING' Routine */
      returnInSub = false ;
      AV5RatingPlataforma.setgxTv_SdtRatingPlataforma_Sgpacientepacienteid( AV18PacienteId );
      AV5RatingPlataforma.setgxTv_SdtRatingPlataforma_Ratingplataformacitaid( (short)(AV8CitaId) );
      AV5RatingPlataforma.setgxTv_SdtRatingPlataforma_Ratingplataformarating( AV20RatingPlataformaa );
      AV5RatingPlataforma.setgxTv_SdtRatingPlataforma_Ratingplataformafecharegistro( Gx_date );
      AV5RatingPlataforma.Save();
      if ( AV5RatingPlataforma.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wpcalificaratencionplataforma");
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wpcalificaratencionplataforma");
      }
   }

   public void S122( )
   {
      /* 'REGISTRAROPINIONSUGERENCIAS' Routine */
      returnInSub = false ;
      AV6SugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Sgpacientepacienteid( AV18PacienteId );
      AV6SugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformacitaid( (short)(AV8CitaId) );
      AV6SugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformaop( AV17OpinionPlataforma );
      AV6SugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformamej( AV12MejoraraPlataforma );
      AV6SugerenciasMejorasPlataforma.setgxTv_SdtSugerenciasMejorasPlataforma_Sugerenciasmejorasplataformafecregistro( Gx_date );
      AV6SugerenciasMejorasPlataforma.Save();
      if ( AV6SugerenciasMejorasPlataforma.Success() )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wpcalificaratencionplataforma");
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wpcalificaratencionplataforma");
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e146W2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV10DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10DisponibilidadId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10DisponibilidadId), "ZZZZZZZ9")));
      AV8CitaId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CitaId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CitaId), "ZZZZZZZ9")));
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
      pa6W2( ) ;
      ws6W2( ) ;
      we6W2( ) ;
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
      httpContext.AddStyleSheetFile("StarRating/style.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202251103484", true, true);
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
      httpContext.AddJavascriptSource("wpcalificaratencionplataforma.js", "?202251103484", false, true);
      httpContext.AddJavascriptSource("StarRating/StarRatingRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblock6_Internalname = "TEXTBLOCK6" ;
      divTabletitle_Internalname = "TABLETITLE" ;
      lblTextblocktilecal_Internalname = "TEXTBLOCKTILECAL" ;
      divTablesubtitle_Internalname = "TABLESUBTITLE" ;
      Ratingplataformaa_Internalname = "RATINGPLATAFORMAA" ;
      lblTextblockmalo_Internalname = "TEXTBLOCKMALO" ;
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      lblTextblock3_Internalname = "TEXTBLOCK3" ;
      lblTextblock5_Internalname = "TEXTBLOCK5" ;
      lblTextblock4_Internalname = "TEXTBLOCK4" ;
      divTable4_Internalname = "TABLE4" ;
      divGroup1table_Internalname = "GROUP1TABLE" ;
      grpGroupcalificacion_Internalname = "GROUPCALIFICACION" ;
      edtavOpinionplataforma_Internalname = "vOPINIONPLATAFORMA" ;
      divTable6_Internalname = "TABLE6" ;
      divGroup2table_Internalname = "GROUP2TABLE" ;
      grpGroupcomentarios_Internalname = "GROUPCOMENTARIOS" ;
      edtavMejoraraplataforma_Internalname = "vMEJORARAPLATAFORMA" ;
      divTable1_Internalname = "TABLE1" ;
      divGroup1table2_Internalname = "GROUP1TABLE2" ;
      grpGroup1_Internalname = "GROUP1" ;
      lblTextblockfechacita_Internalname = "TEXTBLOCKFECHACITA" ;
      bttEnviar_Internalname = "ENVIAR" ;
      bttCancelar_Internalname = "CANCELAR" ;
      divTable5_Internalname = "TABLE5" ;
      divTablemejorassugerencias_Internalname = "TABLEMEJORASSUGERENCIAS" ;
      divTable2_Internalname = "TABLE2" ;
      divTablefromcalificacion_Internalname = "TABLEFROMCALIFICACION" ;
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
      lblTextblockfechacita_Caption = "Text Block" ;
      edtavMejoraraplataforma_Enabled = 1 ;
      edtavOpinionplataforma_Enabled = 1 ;
      Ratingplataformaa_Tooltiptext = "" ;
      lblTextblocktilecal_Caption = "Text Block" ;
      Ratingplataformaa_Captionposition = "None" ;
      Ratingplataformaa_Captionstyle = "" ;
      Ratingplataformaa_Captionclass = "col-sm-3 AttributeLabel" ;
      Ratingplataformaa_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Calificar Atención Plataforma" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV18PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV8CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV10DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'ENVIAR'","{handler:'e136W2',iparms:[{av:'AV18PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV20RatingPlataformaa',fld:'vRATINGPLATAFORMAA',pic:'ZZZ9'},{av:'AV8CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'AV17OpinionPlataforma',fld:'vOPINIONPLATAFORMA',pic:''},{av:'AV12MejoraraPlataforma',fld:'vMEJORARAPLATAFORMA',pic:''},{av:'AV5RatingPlataforma',fld:'vRATINGPLATAFORMA',pic:''},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV6SugerenciasMejorasPlataforma',fld:'vSUGERENCIASMEJORASPLATAFORMA',pic:''}]");
      setEventMetadata("'ENVIAR'",",oparms:[{av:'AV5RatingPlataforma',fld:'vRATINGPLATAFORMA',pic:''},{av:'AV6SugerenciasMejorasPlataforma',fld:'vSUGERENCIASMEJORASPLATAFORMA',pic:''}]}");
      setEventMetadata("'CANCELAR'","{handler:'e116W1',iparms:[]");
      setEventMetadata("'CANCELAR'",",oparms:[]}");
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
      Gx_date = GXutil.nullDate() ;
      GXKey = "" ;
      AV5RatingPlataforma = new com.projectthani.SdtRatingPlataforma(remoteHandle);
      AV6SugerenciasMejorasPlataforma = new com.projectthani.SdtSugerenciasMejorasPlataforma(remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblock6_Jsonclick = "" ;
      lblTextblocktilecal_Jsonclick = "" ;
      ucRatingplataformaa = new com.genexus.webpanels.GXUserControl();
      lblTextblockmalo_Jsonclick = "" ;
      lblTextblock2_Jsonclick = "" ;
      lblTextblock3_Jsonclick = "" ;
      lblTextblock5_Jsonclick = "" ;
      lblTextblock4_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV17OpinionPlataforma = "" ;
      AV12MejoraraPlataforma = "" ;
      lblTextblockfechacita_Jsonclick = "" ;
      bttEnviar_Jsonclick = "" ;
      bttCancelar_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV26WebSession = httpContext.getWebSession();
      AV9Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      AV15MesSpa = "" ;
      AV11FechaDisponibilidad = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV16MsgSuccss = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpcalificaratencionplataforma__default(),
         new Object[] {
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short AV20RatingPlataformaa ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV13MensajeVal ;
   private short AV14MensajeVal2 ;
   private short AV23valExist ;
   private short AV24valExiste ;
   private int wcpOAV10DisponibilidadId ;
   private int wcpOAV8CitaId ;
   private int AV10DisponibilidadId ;
   private int AV8CitaId ;
   private int AV18PacienteId ;
   private int edtavOpinionplataforma_Enabled ;
   private int edtavMejoraraplataforma_Enabled ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ratingplataformaa_Captionclass ;
   private String Ratingplataformaa_Captionstyle ;
   private String Ratingplataformaa_Captionposition ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTablefromcalificacion_Internalname ;
   private String divTabletitle_Internalname ;
   private String lblTextblock6_Internalname ;
   private String lblTextblock6_Jsonclick ;
   private String divTable2_Internalname ;
   private String divTablesubtitle_Internalname ;
   private String lblTextblocktilecal_Internalname ;
   private String lblTextblocktilecal_Caption ;
   private String lblTextblocktilecal_Jsonclick ;
   private String divTablemejorassugerencias_Internalname ;
   private String grpGroupcalificacion_Internalname ;
   private String divGroup1table_Internalname ;
   private String divTable4_Internalname ;
   private String Ratingplataformaa_Tooltiptext ;
   private String Ratingplataformaa_Internalname ;
   private String lblTextblockmalo_Internalname ;
   private String lblTextblockmalo_Jsonclick ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String lblTextblock3_Internalname ;
   private String lblTextblock3_Jsonclick ;
   private String lblTextblock5_Internalname ;
   private String lblTextblock5_Jsonclick ;
   private String lblTextblock4_Internalname ;
   private String lblTextblock4_Jsonclick ;
   private String grpGroupcomentarios_Internalname ;
   private String divGroup2table_Internalname ;
   private String divTable6_Internalname ;
   private String edtavOpinionplataforma_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String grpGroup1_Internalname ;
   private String divGroup1table2_Internalname ;
   private String divTable1_Internalname ;
   private String edtavMejoraraplataforma_Internalname ;
   private String divTable5_Internalname ;
   private String lblTextblockfechacita_Internalname ;
   private String lblTextblockfechacita_Caption ;
   private String lblTextblockfechacita_Jsonclick ;
   private String bttEnviar_Internalname ;
   private String bttEnviar_Jsonclick ;
   private String bttCancelar_Internalname ;
   private String bttCancelar_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Ratingplataformaa_Enabled ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV25ValRating ;
   private boolean AV22ValComentario ;
   private boolean GXv_boolean1[] ;
   private String AV17OpinionPlataforma ;
   private String AV12MejoraraPlataforma ;
   private String AV16MsgSuccss ;
   private String AV15MesSpa ;
   private String AV11FechaDisponibilidad ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV26WebSession ;
   private com.genexus.webpanels.GXUserControl ucRatingplataformaa ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private IDataStoreProvider pr_default ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.SdtRatingPlataforma AV5RatingPlataforma ;
   private com.projectthani.SdtSugerenciasMejorasPlataforma AV6SugerenciasMejorasPlataforma ;
   private com.projectthani.SdtDisponibilidad AV9Disponibilidad ;
}

final  class wpcalificaratencionplataforma__default extends DataStoreHelperBase implements ILocalDataStoreHelper
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

