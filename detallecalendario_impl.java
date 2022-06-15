package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class detallecalendario_impl extends GXDataArea
{
   public detallecalendario_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public detallecalendario_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( detallecalendario_impl.class ));
   }

   public detallecalendario_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      dynavProfesionalid = new HTMLChoice();
      dynavDisponibilidadhorainicio = new HTMLChoice();
      dynavDisponibilidadhorafin = new HTMLChoice();
      dynavEspecialidadid = new HTMLChoice();
      dynavSedeid = new HTMLChoice();
      cmbavMinutosdecita = new HTMLChoice();
      dynavTipocita = new HTMLChoice();
      cmbavSerepite = new HTMLChoice();
      cmbavRepitecada = new HTMLChoice();
      chkavLunes = UIFactory.getCheckbox(this);
      chkavMartes = UIFactory.getCheckbox(this);
      chkavMiercoles = UIFactory.getCheckbox(this);
      chkavJueves = UIFactory.getCheckbox(this);
      chkavViernes = UIFactory.getCheckbox(this);
      chkavSabado = UIFactory.getCheckbox(this);
      chkavDomingo = UIFactory.getCheckbox(this);
      radavFinaliza = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPROFESIONALID") == 0 )
         {
            AV12ClinicaId = (short)(GXutil.lval( httpContext.GetPar( "ClinicaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12ClinicaId), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvprofesionalid322( AV12ClinicaId) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vDISPONIBILIDADHORAINICIO") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvdisponibilidadhorainicio322( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vDISPONIBILIDADHORAFIN") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvdisponibilidadhorafin322( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vESPECIALIDADID") == 0 )
         {
            AV51ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51ProfesionalId), 8, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvespecialidadid322( AV51ProfesionalId) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vSEDEID") == 0 )
         {
            AV26EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26EspecialidadId), 4, 0));
            AV51ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51ProfesionalId), 8, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvsedeid322( AV26EspecialidadId, AV51ProfesionalId) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vTIPOCITA") == 0 )
         {
            AV51ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51ProfesionalId), 8, 0));
            AV26EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26EspecialidadId), 4, 0));
            AV63SedeId = (short)(GXutil.lval( httpContext.GetPar( "SedeId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV63SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63SedeId), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdsvvtipocita322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
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
      pa322( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start322( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110335158", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/chosen.jquery.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/ChosenGxRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormNoBackgroundColor\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormNoBackgroundColor\" data-gx-class=\"form-horizontal FormNoBackgroundColor\" novalidate action=\""+formatLink("com.projectthani.detallecalendario", new String[] {}, new String[] {}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormNoBackgroundColor", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTEVENT", getSecureSignedToken( "", AV14currentEvent));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62SecUserId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAEMAILGENLINK", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CitaEmailGenLink, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISRESULT", getSecureSignedToken( "", AV39IsResult));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCURRENTEVENT", AV14currentEvent);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCURRENTEVENT", AV14currentEvent);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTEVENT", getSecureSignedToken( "", AV14currentEvent));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vNROTRASLAPES", GXutil.ltrim( localUtil.ntoc( AV49NroTraslapes, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDISPONIBILIDAD", AV18Disponibilidad);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDISPONIBILIDAD", AV18Disponibilidad);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECUSERID", GXutil.ltrim( localUtil.ntoc( AV62SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62SecUserId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vREPETIR", AV57Repetir);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vQJ", GXutil.ltrim( localUtil.ntoc( AV55Qj, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vAGREGAR", AV7Agregar);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vVPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV76vPacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTENRODOCUMENTO", A106PacienteNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEAPELLIDOPATERNO", A103PacienteApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEAPELLIDOMATERNO", A104PacienteApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTENOMBRES", A105PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEID", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV10CitaId, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITA", AV8Cita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITA", AV8Cita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vRESJSON", AV59resjson);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAEMAILGENLINK", AV9CitaEmailGenLink);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAEMAILGENLINK", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CitaEmailGenLink, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISRESULT", AV39IsResult);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISRESULT", getSecureSignedToken( "", AV39IsResult));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGCITADISPONIBILIDADFECHA", localUtil.dtoc( A66SGCitaDisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGCITADISPONIBILIDADESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CITAID", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCLINICAID", GXutil.ltrim( localUtil.ntoc( AV12ClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALID", GXutil.ltrim( localUtil.ntoc( A40000ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CITAID", GXutil.ltrim( localUtil.ntoc( A40001CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVMESSAGE1_Defaultmessagetype", GXutil.rtrim( Dvmessage1_Defaultmessagetype));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormNoBackgroundColor" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we322( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt322( ) ;
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
      return formatLink("com.projectthani.detallecalendario", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "DetalleCalendario" ;
   }

   public String getPgmdesc( )
   {
      return "Disponibilidad del Profesional - Thani" ;
   }

   public void wb320( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, divTable4_Visible, 0, "px", 0, "px", "TableFondoDetalleCalendario", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-1", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-11", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavInformecita_Internalname, "Informe Cita", "col-sm-3 AttributeLoginLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 11,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavInformecita_Internalname, AV36InformeCita, GXutil.rtrim( localUtil.format( AV36InformeCita, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,11);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavInformecita_Jsonclick, 0, "AttributeLogin", "", "", "", "", edtavInformecita_Visible, edtavInformecita_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-1", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-11", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavInformecita2_Internalname, "Informe Cita2", "col-sm-3 AttributeLoginLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavInformecita2_Internalname, AV37InformeCita2, GXutil.rtrim( localUtil.format( AV37InformeCita2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,16);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavInformecita2_Jsonclick, 0, "AttributeLogin", "", "", "", "", edtavInformecita2_Visible, edtavInformecita2_Enabled, 0, "text", "", 60, "chr", 1, "row", 60, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-1", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-11", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavInformecita3_Internalname, "Informe Cita3", "col-sm-3 AttributeLoginLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
         ClassString = "AttributeLogin" ;
         StyleString = "" ;
         ClassString = "AttributeLogin" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavInformecita3_Internalname, AV38InformeCita3, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,21);\"", (short)(1), edtavInformecita3_Visible, edtavInformecita3_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-1", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-lg-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableDoctorInfo", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10 mt10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2 TextBlockBoldCalendario", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock5_Internalname, "Profesional", "", "", lblTextblock5_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavProfesionalid.getInternalname(), "Profesional", "col-sm-3 chosen-selectLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavProfesionalid, dynavProfesionalid.getInternalname(), GXutil.trim( GXutil.str( AV51ProfesionalId, 8, 0)), 1, dynavProfesionalid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavProfesionalid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "chosen-select", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         dynavProfesionalid.setValue( GXutil.trim( GXutil.str( AV51ProfesionalId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalid.getInternalname(), "Values", dynavProfesionalid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2 TextBlockBoldCalendario", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "Fecha", "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavDisponibilidadfecha_Internalname, "Fecha", "col-sm-3 AttributeDFSLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavDisponibilidadfecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDisponibilidadfecha_Internalname, localUtil.format(AV19DisponibilidadFecha, "99/99/99"), localUtil.format( AV19DisponibilidadFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDisponibilidadfecha_Jsonclick, 0, "AttributeDFS", "", "", "", "", 1, edtavDisponibilidadfecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavDisponibilidadfecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavDisponibilidadfecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_DetalleCalendario.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2 TextBlockBoldCalendario", "left", "Bottom", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock2_Internalname, "Hora Inicio", "", "", lblTextblock2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "Bottom", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavDisponibilidadhorainicio.getInternalname(), "Hora Inicio", "col-sm-3 AttributeDFSLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavDisponibilidadhorainicio, dynavDisponibilidadhorainicio.getInternalname(), GXutil.rtrim( AV21DisponibilidadHoraInicio), 1, dynavDisponibilidadhorainicio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavDisponibilidadhorainicio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         dynavDisponibilidadhorainicio.setValue( GXutil.rtrim( AV21DisponibilidadHoraInicio) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDisponibilidadhorainicio.getInternalname(), "Values", dynavDisponibilidadhorainicio.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2 TextBlockBoldCalendario", "Right", "Bottom", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock3_Internalname, "Hora Fin", "", "", lblTextblock3_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Right", "Bottom", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavDisponibilidadhorafin.getInternalname(), "Hora Fin", "col-sm-3 AttributeDFSLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavDisponibilidadhorafin, dynavDisponibilidadhorafin.getInternalname(), GXutil.rtrim( AV20DisponibilidadHoraFin), 1, dynavDisponibilidadhorafin.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavDisponibilidadhorafin.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,51);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         dynavDisponibilidadhorafin.setValue( GXutil.rtrim( AV20DisponibilidadHoraFin) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDisponibilidadhorafin.getInternalname(), "Values", dynavDisponibilidadhorafin.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2 TextBlockBoldCalendario", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock4_Internalname, "Especialidad", "", "", lblTextblock4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavEspecialidadid.getInternalname(), "Especialidad", "col-sm-3 AttributeDFSLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEspecialidadid, dynavEspecialidadid.getInternalname(), GXutil.trim( GXutil.str( AV26EspecialidadId, 4, 0)), 1, dynavEspecialidadid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEspecialidadid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         dynavEspecialidadid.setValue( GXutil.trim( GXutil.str( AV26EspecialidadId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadid.getInternalname(), "Values", dynavEspecialidadid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2 TextBlockBoldCalendario", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock6_Internalname, "Sede", "", "", lblTextblock6_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavSedeid.getInternalname(), "Sede Id", "col-sm-3 AttributeDFSLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavSedeid, dynavSedeid.getInternalname(), GXutil.trim( GXutil.str( AV63SedeId, 4, 0)), 1, dynavSedeid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavSedeid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         dynavSedeid.setValue( GXutil.trim( GXutil.str( AV63SedeId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSedeid.getInternalname(), "Values", dynavSedeid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 TextBlockBoldCalendario", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock9_Internalname, "Tiempo de Cita", "", "", lblTextblock9_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavMinutosdecita.getInternalname(), "Minutos De Cita", "col-sm-3 AttributeDFSLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMinutosdecita, cmbavMinutosdecita.getInternalname(), GXutil.trim( GXutil.str( AV46MinutosDeCita, 4, 0)), 1, cmbavMinutosdecita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavMinutosdecita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         cmbavMinutosdecita.setValue( GXutil.trim( GXutil.str( AV46MinutosDeCita, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMinutosdecita.getInternalname(), "Values", cmbavMinutosdecita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock10_Internalname, "Tipo Cita", "", "", lblTextblock10_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBoldCalendario", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavTipocita.getInternalname(), "Tipo Cita", "col-sm-3 AttributeDFSLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavTipocita, dynavTipocita.getInternalname(), GXutil.rtrim( AV81TipoCita), 1, dynavTipocita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynavTipocita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,75);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
         httpContext.ajax_rsp_assign_prop("", false, dynavTipocita.getInternalname(), "Values", dynavTipocita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-3", "Center", "Middle", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Profesional Foto", "col-sm-3 ImageCalendarioProfesionalLabel", 0, true, "");
         /* Static Bitmap Variable */
         ClassString = "ImageCalendarioProfesional" ;
         StyleString = "" ;
         AV50ProfesionalFoto_IsBlob = (boolean)(((GXutil.strcmp("", AV50ProfesionalFoto)==0)&&(GXutil.strcmp("", A40002ProfesionalFoto_GXI)==0))||!(GXutil.strcmp("", AV50ProfesionalFoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV50ProfesionalFoto)==0) ? A40002ProfesionalFoto_GXI : httpContext.getResourceRelative(AV50ProfesionalFoto)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgavProfesionalfoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV50ProfesionalFoto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "Middle", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row mb10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttRepetir_Internalname, "", "Generación masiva de fechas", bttRepetir_Jsonclick, 7, "Generación masiva de fechas", "", StyleString, ClassString, bttRepetir_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11321_client"+"'", TempTags, "", 2, "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAgregarpaciente_Internalname, "", "Agregar Paciente", bttAgregarpaciente_Jsonclick, 5, "Agregar Paciente", "", StyleString, ClassString, bttAgregarpaciente_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'AGREGARPACIENTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divHn1_Internalname, divHn1_Visible, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablepaciente_Internalname, divTablepaciente_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTpacientenrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTpacientenrodocumento_Internalname, "Documento del paciente", "col-sm-3 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTpacientenrodocumento_Internalname, AV72tPacienteNroDocumento, GXutil.rtrim( localUtil.format( AV72tPacienteNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTpacientenrodocumento_Jsonclick, 0, "AttributeDFS", "", "", "", "", 1, edtavTpacientenrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgavFind_Internalname+"\"", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Active Bitmap Variable */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
         ClassString = "Image" ;
         StyleString = "" ;
         AV32find_IsBlob = (boolean)(((GXutil.strcmp("", AV32find)==0)&&(GXutil.strcmp("", AV89Find_GXI)==0))||!(GXutil.strcmp("", AV32find)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV32find)==0) ? AV89Find_GXI : httpContext.getResourceRelative(AV32find)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgavFind_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, -1, 0, "", 0, "", 0, 0, 5, imgavFind_Jsonclick, "'"+""+"'"+",false,"+"'"+"EVFIND.CLICK."+"'", StyleString, ClassString, "", "", "", "", ""+TempTags, "", "", 1, AV32find_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", edtavTpacientenombrecompleto_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTpacientenombrecompleto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTpacientenombrecompleto_Internalname, "Nombre del paciente", "col-sm-3 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
         ClassString = "AttributeDFS" ;
         StyleString = "" ;
         ClassString = "AttributeDFS" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavTpacientenombrecompleto_Internalname, AV71tPacienteNombreCompleto, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,102);\"", (short)(0), edtavTpacientenombrecompleto_Visible, edtavTpacientenombrecompleto_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttGenerarcita_Internalname, "", "Generar Cita", bttGenerarcita_Jsonclick, 5, "Generar Cita", "", StyleString, ClassString, bttGenerarcita_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'GENERAR CITA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DetalleCalendario.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablerepetir_Internalname, divTablerepetir_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFechainicio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFechainicio_Internalname, "Inicio", "col-sm-3 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavFechainicio_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFechainicio_Internalname, localUtil.format(AV28FechaInicio, "99/99/99"), localUtil.format( AV28FechaInicio, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,112);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFechainicio_Jsonclick, 0, "AttributeDFS", "", "", "", "", 1, edtavFechainicio_Enabled, 1, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavFechainicio_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavFechainicio_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_DetalleCalendario.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSerepite.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSerepite.getInternalname(), "Se Repite", "col-sm-3 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSerepite, cmbavSerepite.getInternalname(), GXutil.trim( GXutil.str( AV65SeRepite, 2, 0)), 1, cmbavSerepite.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavSerepite.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         cmbavSerepite.setValue( GXutil.trim( GXutil.str( AV65SeRepite, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSerepite.getInternalname(), "Values", cmbavSerepite.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", cmbavRepitecada.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavRepitecada.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavRepitecada.getInternalname(), "Repite Cada", "col-sm-3 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 121,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavRepitecada, cmbavRepitecada.getInternalname(), GXutil.trim( GXutil.str( AV58RepiteCada, 2, 0)), 1, cmbavRepitecada.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavRepitecada.getVisible(), cmbavRepitecada.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeDFS", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,121);\"", "", true, (byte)(1), "HLP_DetalleCalendario.htm");
         cmbavRepitecada.setValue( GXutil.trim( GXutil.str( AV58RepiteCada, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRepitecada.getInternalname(), "Values", cmbavRepitecada.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesemana_Internalname, divTablesemana_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock7_Internalname, "Repetir El", "", "", lblTextblock7_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavLunes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavLunes.getInternalname(), "L", "col-lg-1 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-lg-11 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavLunes.getInternalname(), GXutil.booltostr( AV41Lunes), "", "L", 1, chkavLunes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(131, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,131);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavMartes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavMartes.getInternalname(), "M", "col-lg-1 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-lg-11 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavMartes.getInternalname(), GXutil.booltostr( AV42Martes), "", "M", 1, chkavMartes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(135, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,135);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavMiercoles.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavMiercoles.getInternalname(), "X", "col-lg-1 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-lg-11 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavMiercoles.getInternalname(), GXutil.booltostr( AV45Miercoles), "", "X", 1, chkavMiercoles.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(139, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,139);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavJueves.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavJueves.getInternalname(), "J", "col-lg-1 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-lg-11 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 143,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavJueves.getInternalname(), GXutil.booltostr( AV40Jueves), "", "J", 1, chkavJueves.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(143, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,143);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavViernes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavViernes.getInternalname(), "V", "col-lg-1 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-lg-11 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 147,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavViernes.getInternalname(), GXutil.booltostr( AV75Viernes), "", "V", 1, chkavViernes.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(147, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,147);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavSabado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavSabado.getInternalname(), "S", "col-lg-1 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-lg-11 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavSabado.getInternalname(), GXutil.booltostr( AV61Sabado), "", "S", 1, chkavSabado.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(151, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,151);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavDomingo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavDomingo.getInternalname(), "D", "col-lg-1 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-lg-11 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 155,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavDomingo.getInternalname(), GXutil.booltostr( AV23Domingo), "", "D", 1, chkavDomingo.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(155, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,155);\"");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+radavFinaliza.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Finaliza", "col-sm-3 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Radio button */
         ClassString = "AttributeDFS" ;
         StyleString = "" ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_radio_ctrl( httpContext, radavFinaliza, radavFinaliza.getInternalname(), GXutil.rtrim( AV29Finaliza), "", 1, 1, 1, 1, StyleString, ClassString, "", "", 0, radavFinaliza.getJsonclick(), "'"+""+"'"+",false,"+"'"+""+"'", TempTags+" onclick="+"\""+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,160);\"", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", edtavFinalizafecha_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFinalizafecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFinalizafecha_Internalname, "Finaliza Fecha", "col-sm-6 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-6 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 164,'',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavFinalizafecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFinalizafecha_Internalname, localUtil.format(AV30FinalizaFecha, "99/99/99"), localUtil.format( AV30FinalizaFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,164);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFinalizafecha_Jsonclick, 0, "AttributeDFS", "", "", "", "", edtavFinalizafecha_Visible, edtavFinalizafecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavFinalizafecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((edtavFinalizafecha_Visible==0)||(edtavFinalizafecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_DetalleCalendario.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, divTable1_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFinalizanroveces_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFinalizanroveces_Internalname, "Finaliza Nro Veces", "col-sm-3 AttributeDFSLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 171,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFinalizanroveces_Internalname, GXutil.ltrim( localUtil.ntoc( AV31FinalizaNroVeces, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavFinalizanroveces_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV31FinalizaNroVeces), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV31FinalizaNroVeces), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,171);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFinalizanroveces_Jsonclick, 0, "AttributeDFS", "", "", "", "", 1, edtavFinalizanroveces_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock8_Internalname, "veces", "", "", lblTextblock8_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_DetalleCalendario.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", edtavResumen_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavResumen_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavResumen_Internalname, "Resumen", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 178,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavResumen_Internalname, AV60Resumen, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,178);\"", (short)(0), edtavResumen_Visible, edtavResumen_Enabled, 0, 80, "chr", 2, "row", StyleString, ClassString, "", "", "2000", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_DetalleCalendario.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-1", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 188,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttGuardar_Internalname, "", bttGuardar_Caption, bttGuardar_Jsonclick, 5, "Guardar", "", StyleString, ClassString, bttGuardar_Visible, bttGuardar_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"E\\'GUARDAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 190,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialWarn" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttEliminar_Internalname, "", "Eliminar", bttEliminar_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, 1, bttEliminar_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"E\\'ELIMINAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 192,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttRegistrarinformemedico_Internalname, "", "Informe", bttRegistrarinformemedico_Jsonclick, 7, "Informe", "", StyleString, ClassString, bttRegistrarinformemedico_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e12321_client"+"'", TempTags, "", 2, "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 194,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar_Internalname, "", "Salir", bttCancelar_Jsonclick, 5, "Salir", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'CANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_DetalleCalendario.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-2", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucChosengx1.render(context, "chosengx", Chosengx1_Internalname, "CHOSENGX1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start322( )
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
         Form.getMeta().addItem("description", "Disponibilidad del Profesional - Thani", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup320( ) ;
   }

   public void ws322( )
   {
      start322( ) ;
      evt322( ) ;
   }

   public void evt322( )
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
                           e13322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VPROFESIONALID.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'CANCELAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Cancelar' */
                           e15322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'GUARDAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Guardar' */
                           e16322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'ELIMINAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Eliminar' */
                           e17322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.RETURN") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e18322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VFIND.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e19322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'GENERAR CITA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'Generar Cita' */
                           e20322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e21322 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'AGREGARPACIENTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'AgregarPaciente' */
                           e22322 ();
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

   public void we322( )
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

   public void pa322( )
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
            GX_FocusControl = edtavInformecita_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvsedeid_html322( AV26EspecialidadId, AV51ProfesionalId) ;
      gxvvtipocita_html322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
      /* End function dynload_actions */
   }

   public void gxdsvvprofesionalid322( short AV12ClinicaId )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvprofesionalid_data322( AV12ClinicaId) ;
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

   public void gxvvprofesionalid_html322( short AV12ClinicaId )
   {
      int gxdynajaxvalue;
      gxdsvvprofesionalid_data322( AV12ClinicaId) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavProfesionalid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavProfesionalid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdsvvprofesionalid_data322( short AV12ClinicaId )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione");
      com.projectthani.SdtSDTProfesional gxcolitemvPROFESIONALID;
      GXv_objcol_SdtSDTProfesional1[0] = gxcolvPROFESIONALID ;
      new com.projectthani.dpprofesionaldisponibilidad(remoteHandle, context).execute( AV12ClinicaId, GXv_objcol_SdtSDTProfesional1) ;
      detallecalendario_impl.this.gxcolvPROFESIONALID = GXv_objcol_SdtSDTProfesional1[0] ;
      gxcolvPROFESIONALID.sort("Profesionalfullname");
      int gxindex = 1;
      while ( gxindex <= gxcolvPROFESIONALID.size() )
      {
         gxcolitemvPROFESIONALID = ((com.projectthani.SdtSDTProfesional)gxcolvPROFESIONALID.elementAt(-1+gxindex)) ;
         gxdynajaxctrlcodr.add(GXutil.ltrimstr( gxcolitemvPROFESIONALID.getgxTv_SdtSDTProfesional_Profesionalid(), 8, 0));
         gxdynajaxctrldescr.add(gxcolitemvPROFESIONALID.getgxTv_SdtSDTProfesional_Profesionalfullname());
         gxindex = (int)(gxindex+1) ;
      }
   }

   public void gxdsvvdisponibilidadhorainicio322( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvdisponibilidadhorainicio_data322( ) ;
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

   public void gxvvdisponibilidadhorainicio_html322( )
   {
      String gxdynajaxvalue;
      gxdsvvdisponibilidadhorainicio_data322( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavDisponibilidadhorainicio.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavDisponibilidadhorainicio.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdsvvdisponibilidadhorainicio_data322( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      com.projectthani.SdtSDTHora_SDTHoraItem gxcolitemvDISPONIBILIDADHORAINICIO;
      GXv_objcol_SdtSDTHora_SDTHoraItem2[0] = gxcolvDISPONIBILIDADHORAINICIO ;
      new com.projectthani.dphora30(remoteHandle, context).execute( GXv_objcol_SdtSDTHora_SDTHoraItem2) ;
      detallecalendario_impl.this.gxcolvDISPONIBILIDADHORAINICIO = GXv_objcol_SdtSDTHora_SDTHoraItem2[0] ;
      gxcolvDISPONIBILIDADHORAINICIO.sort("Horavalue");
      int gxindex = 1;
      while ( gxindex <= gxcolvDISPONIBILIDADHORAINICIO.size() )
      {
         gxcolitemvDISPONIBILIDADHORAINICIO = ((com.projectthani.SdtSDTHora_SDTHoraItem)gxcolvDISPONIBILIDADHORAINICIO.elementAt(-1+gxindex)) ;
         gxdynajaxctrlcodr.add(gxcolitemvDISPONIBILIDADHORAINICIO.getgxTv_SdtSDTHora_SDTHoraItem_Horaid());
         gxdynajaxctrldescr.add(gxcolitemvDISPONIBILIDADHORAINICIO.getgxTv_SdtSDTHora_SDTHoraItem_Horavalue());
         gxindex = (int)(gxindex+1) ;
      }
   }

   public void gxdsvvdisponibilidadhorafin322( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvdisponibilidadhorafin_data322( ) ;
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

   public void gxvvdisponibilidadhorafin_html322( )
   {
      String gxdynajaxvalue;
      gxdsvvdisponibilidadhorafin_data322( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavDisponibilidadhorafin.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavDisponibilidadhorafin.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdsvvdisponibilidadhorafin_data322( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      com.projectthani.SdtSDTHora_SDTHoraItem gxcolitemvDISPONIBILIDADHORAFIN;
      GXv_objcol_SdtSDTHora_SDTHoraItem2[0] = gxcolvDISPONIBILIDADHORAFIN ;
      new com.projectthani.dphora30(remoteHandle, context).execute( GXv_objcol_SdtSDTHora_SDTHoraItem2) ;
      detallecalendario_impl.this.gxcolvDISPONIBILIDADHORAFIN = GXv_objcol_SdtSDTHora_SDTHoraItem2[0] ;
      gxcolvDISPONIBILIDADHORAFIN.sort("Horavalue");
      int gxindex = 1;
      while ( gxindex <= gxcolvDISPONIBILIDADHORAFIN.size() )
      {
         gxcolitemvDISPONIBILIDADHORAFIN = ((com.projectthani.SdtSDTHora_SDTHoraItem)gxcolvDISPONIBILIDADHORAFIN.elementAt(-1+gxindex)) ;
         gxdynajaxctrlcodr.add(gxcolitemvDISPONIBILIDADHORAFIN.getgxTv_SdtSDTHora_SDTHoraItem_Horaid());
         gxdynajaxctrldescr.add(gxcolitemvDISPONIBILIDADHORAFIN.getgxTv_SdtSDTHora_SDTHoraItem_Horavalue());
         gxindex = (int)(gxindex+1) ;
      }
   }

   public void gxdsvvespecialidadid322( int AV51ProfesionalId )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvespecialidadid_data322( AV51ProfesionalId) ;
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

   public void gxvvespecialidadid_html322( int AV51ProfesionalId )
   {
      short gxdynajaxvalue;
      gxdsvvespecialidadid_data322( AV51ProfesionalId) ;
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

   protected void gxdsvvespecialidadid_data322( int AV51ProfesionalId )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione especialidad");
      com.projectthani.SdtSDTEspecialidad gxcolitemvESPECIALIDADID;
      GXv_objcol_SdtSDTEspecialidad3[0] = gxcolvESPECIALIDADID ;
      new com.projectthani.dpespecialidaddisponibilidad(remoteHandle, context).execute( AV51ProfesionalId, GXv_objcol_SdtSDTEspecialidad3) ;
      detallecalendario_impl.this.gxcolvESPECIALIDADID = GXv_objcol_SdtSDTEspecialidad3[0] ;
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

   public void gxdsvvsedeid322( short AV26EspecialidadId ,
                                int AV51ProfesionalId )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvsedeid_data322( AV26EspecialidadId, AV51ProfesionalId) ;
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

   public void gxvvsedeid_html322( short AV26EspecialidadId ,
                                   int AV51ProfesionalId )
   {
      short gxdynajaxvalue;
      gxdsvvsedeid_data322( AV26EspecialidadId, AV51ProfesionalId) ;
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

   protected void gxdsvvsedeid_data322( short AV26EspecialidadId ,
                                        int AV51ProfesionalId )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione sede");
      com.projectthani.SdtSDTSede gxcolitemvSEDEID;
      GXv_objcol_SdtSDTSede4[0] = gxcolvSEDEID ;
      new com.projectthani.dpsededisponibilidad(remoteHandle, context).execute( AV26EspecialidadId, AV51ProfesionalId, GXv_objcol_SdtSDTSede4) ;
      detallecalendario_impl.this.gxcolvSEDEID = GXv_objcol_SdtSDTSede4[0] ;
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

   public void gxdsvvtipocita322( int AV51ProfesionalId ,
                                  short AV26EspecialidadId ,
                                  short AV63SedeId )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdsvvtipocita_data322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
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

   public void gxvvtipocita_html322( int AV51ProfesionalId ,
                                     short AV26EspecialidadId ,
                                     short AV63SedeId )
   {
      String gxdynajaxvalue;
      gxdsvvtipocita_data322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavTipocita.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavTipocita.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdsvvtipocita_data322( int AV51ProfesionalId ,
                                          short AV26EspecialidadId ,
                                          short AV63SedeId )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione tipo de consulta");
      com.projectthani.SdtSDTTipoConsulta gxcolitemvTIPOCITA;
      GXv_objcol_SdtSDTTipoConsulta5[0] = gxcolvTIPOCITA ;
      new com.projectthani.dpgettiposconsulta(remoteHandle, context).execute( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId, GXv_objcol_SdtSDTTipoConsulta5) ;
      detallecalendario_impl.this.gxcolvTIPOCITA = GXv_objcol_SdtSDTTipoConsulta5[0] ;
      gxcolvTIPOCITA.sort("Sedetipoconsultadescripcion");
      int gxindex = 1;
      while ( gxindex <= gxcolvTIPOCITA.size() )
      {
         gxcolitemvTIPOCITA = ((com.projectthani.SdtSDTTipoConsulta)gxcolvTIPOCITA.elementAt(-1+gxindex)) ;
         gxdynajaxctrlcodr.add(gxcolitemvTIPOCITA.getgxTv_SdtSDTTipoConsulta_Sedetipoconsulta());
         gxdynajaxctrldescr.add(gxcolitemvTIPOCITA.getgxTv_SdtSDTTipoConsulta_Sedetipoconsultadescripcion());
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
         gxvvdisponibilidadhorainicio_html322( ) ;
         gxvvdisponibilidadhorafin_html322( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( dynavProfesionalid.getItemCount() > 0 )
      {
         AV51ProfesionalId = (int)(GXutil.lval( dynavProfesionalid.getValidValue(GXutil.trim( GXutil.str( AV51ProfesionalId, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51ProfesionalId), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProfesionalid.setValue( GXutil.trim( GXutil.str( AV51ProfesionalId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalid.getInternalname(), "Values", dynavProfesionalid.ToJavascriptSource(), true);
      }
      if ( dynavDisponibilidadhorainicio.getItemCount() > 0 )
      {
         AV21DisponibilidadHoraInicio = dynavDisponibilidadhorainicio.getValidValue(AV21DisponibilidadHoraInicio) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21DisponibilidadHoraInicio", AV21DisponibilidadHoraInicio);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDisponibilidadhorainicio.setValue( GXutil.rtrim( AV21DisponibilidadHoraInicio) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDisponibilidadhorainicio.getInternalname(), "Values", dynavDisponibilidadhorainicio.ToJavascriptSource(), true);
      }
      if ( dynavDisponibilidadhorafin.getItemCount() > 0 )
      {
         AV20DisponibilidadHoraFin = dynavDisponibilidadhorafin.getValidValue(AV20DisponibilidadHoraFin) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20DisponibilidadHoraFin", AV20DisponibilidadHoraFin);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDisponibilidadhorafin.setValue( GXutil.rtrim( AV20DisponibilidadHoraFin) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDisponibilidadhorafin.getInternalname(), "Values", dynavDisponibilidadhorafin.ToJavascriptSource(), true);
      }
      if ( dynavEspecialidadid.getItemCount() > 0 )
      {
         AV26EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValidValue(GXutil.trim( GXutil.str( AV26EspecialidadId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26EspecialidadId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEspecialidadid.setValue( GXutil.trim( GXutil.str( AV26EspecialidadId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadid.getInternalname(), "Values", dynavEspecialidadid.ToJavascriptSource(), true);
      }
      if ( dynavSedeid.getItemCount() > 0 )
      {
         AV63SedeId = (short)(GXutil.lval( dynavSedeid.getValidValue(GXutil.trim( GXutil.str( AV63SedeId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63SedeId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedeid.setValue( GXutil.trim( GXutil.str( AV63SedeId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavSedeid.getInternalname(), "Values", dynavSedeid.ToJavascriptSource(), true);
      }
      if ( cmbavMinutosdecita.getItemCount() > 0 )
      {
         AV46MinutosDeCita = (short)(GXutil.lval( cmbavMinutosdecita.getValidValue(GXutil.trim( GXutil.str( AV46MinutosDeCita, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46MinutosDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46MinutosDeCita), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMinutosdecita.setValue( GXutil.trim( GXutil.str( AV46MinutosDeCita, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMinutosdecita.getInternalname(), "Values", cmbavMinutosdecita.ToJavascriptSource(), true);
      }
      if ( dynavTipocita.getItemCount() > 0 )
      {
         AV81TipoCita = dynavTipocita.getValidValue(AV81TipoCita) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV81TipoCita", AV81TipoCita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
         httpContext.ajax_rsp_assign_prop("", false, dynavTipocita.getInternalname(), "Values", dynavTipocita.ToJavascriptSource(), true);
      }
      if ( cmbavSerepite.getItemCount() > 0 )
      {
         AV65SeRepite = (byte)(GXutil.lval( cmbavSerepite.getValidValue(GXutil.trim( GXutil.str( AV65SeRepite, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65SeRepite", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65SeRepite), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSerepite.setValue( GXutil.trim( GXutil.str( AV65SeRepite, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSerepite.getInternalname(), "Values", cmbavSerepite.ToJavascriptSource(), true);
      }
      if ( cmbavRepitecada.getItemCount() > 0 )
      {
         AV58RepiteCada = (byte)(GXutil.lval( cmbavRepitecada.getValidValue(GXutil.trim( GXutil.str( AV58RepiteCada, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58RepiteCada", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58RepiteCada), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavRepitecada.setValue( GXutil.trim( GXutil.str( AV58RepiteCada, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRepitecada.getInternalname(), "Values", cmbavRepitecada.ToJavascriptSource(), true);
      }
      AV41Lunes = GXutil.strtobool( GXutil.booltostr( AV41Lunes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41Lunes", AV41Lunes);
      AV42Martes = GXutil.strtobool( GXutil.booltostr( AV42Martes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42Martes", AV42Martes);
      AV45Miercoles = GXutil.strtobool( GXutil.booltostr( AV45Miercoles)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45Miercoles", AV45Miercoles);
      AV40Jueves = GXutil.strtobool( GXutil.booltostr( AV40Jueves)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40Jueves", AV40Jueves);
      AV75Viernes = GXutil.strtobool( GXutil.booltostr( AV75Viernes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75Viernes", AV75Viernes);
      AV61Sabado = GXutil.strtobool( GXutil.booltostr( AV61Sabado)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61Sabado", AV61Sabado);
      AV23Domingo = GXutil.strtobool( GXutil.booltostr( AV23Domingo)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Domingo", AV23Domingo);
      httpContext.ajax_rsp_assign_attri("", false, "AV29Finaliza", AV29Finaliza);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf322( ) ;
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
      edtavInformecita_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita_Enabled), 5, 0), true);
      edtavInformecita2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita2_Enabled), 5, 0), true);
      edtavInformecita3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita3_Enabled), 5, 0), true);
      edtavResumen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavResumen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavResumen_Enabled), 5, 0), true);
   }

   public void rf322( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e21322 ();
         wb320( ) ;
      }
   }

   public void send_integrity_lvl_hashes322( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCURRENTEVENT", AV14currentEvent);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCURRENTEVENT", AV14currentEvent);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCURRENTEVENT", getSecureSignedToken( "", AV14currentEvent));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECUSERID", GXutil.ltrim( localUtil.ntoc( AV62SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62SecUserId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAEMAILGENLINK", AV9CitaEmailGenLink);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAEMAILGENLINK", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CitaEmailGenLink, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vISRESULT", AV39IsResult);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vISRESULT", getSecureSignedToken( "", AV39IsResult));
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavInformecita_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita_Enabled), 5, 0), true);
      edtavInformecita2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita2_Enabled), 5, 0), true);
      edtavInformecita3_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita3_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita3_Enabled), 5, 0), true);
      edtavResumen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavResumen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavResumen_Enabled), 5, 0), true);
      gxvvdisponibilidadhorainicio_html322( ) ;
      gxvvdisponibilidadhorafin_html322( ) ;
      /* Using cursor H00323 */
      pr_default.execute(0, new Object[] {AV82SecUserName, AV83SecUserEmail});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000ProfesionalId = H00323_A40000ProfesionalId[0] ;
         n40000ProfesionalId = H00323_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000ProfesionalId), 8, 0));
      }
      pr_default.close(0);
      /* Using cursor H00325 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV22DisponibilidadId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40001CitaId = H00325_A40001CitaId[0] ;
         n40001CitaId = H00325_n40001CitaId[0] ;
      }
      else
      {
         A40001CitaId = 0 ;
         n40001CitaId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40001CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001CitaId), 8, 0));
      }
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup320( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13322 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvprofesionalid_html322( AV12ClinicaId) ;
      gxvvespecialidadid_html322( AV51ProfesionalId) ;
      gxvvsedeid_html322( AV26EspecialidadId, AV51ProfesionalId) ;
      gxvvtipocita_html322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV57Repetir = GXutil.strtobool( httpContext.cgiGet( "vREPETIR")) ;
         Dvmessage1_Defaultmessagetype = httpContext.cgiGet( "DVMESSAGE1_Defaultmessagetype") ;
         /* Read variables values. */
         AV36InformeCita = httpContext.cgiGet( edtavInformecita_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36InformeCita", AV36InformeCita);
         AV37InformeCita2 = httpContext.cgiGet( edtavInformecita2_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV37InformeCita2", AV37InformeCita2);
         AV38InformeCita3 = httpContext.cgiGet( edtavInformecita3_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38InformeCita3", AV38InformeCita3);
         dynavProfesionalid.setValue( httpContext.cgiGet( dynavProfesionalid.getInternalname()) );
         AV51ProfesionalId = (int)(GXutil.lval( httpContext.cgiGet( dynavProfesionalid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51ProfesionalId), 8, 0));
         if ( localUtil.vcdate( httpContext.cgiGet( edtavDisponibilidadfecha_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vDISPONIBILIDADFECHA");
            GX_FocusControl = edtavDisponibilidadfecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV19DisponibilidadFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19DisponibilidadFecha", localUtil.format(AV19DisponibilidadFecha, "99/99/99"));
         }
         else
         {
            AV19DisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtavDisponibilidadfecha_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19DisponibilidadFecha", localUtil.format(AV19DisponibilidadFecha, "99/99/99"));
         }
         dynavDisponibilidadhorainicio.setValue( httpContext.cgiGet( dynavDisponibilidadhorainicio.getInternalname()) );
         AV21DisponibilidadHoraInicio = httpContext.cgiGet( dynavDisponibilidadhorainicio.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21DisponibilidadHoraInicio", AV21DisponibilidadHoraInicio);
         dynavDisponibilidadhorafin.setValue( httpContext.cgiGet( dynavDisponibilidadhorafin.getInternalname()) );
         AV20DisponibilidadHoraFin = httpContext.cgiGet( dynavDisponibilidadhorafin.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20DisponibilidadHoraFin", AV20DisponibilidadHoraFin);
         dynavEspecialidadid.setValue( httpContext.cgiGet( dynavEspecialidadid.getInternalname()) );
         AV26EspecialidadId = (short)(GXutil.lval( httpContext.cgiGet( dynavEspecialidadid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26EspecialidadId), 4, 0));
         dynavSedeid.setValue( httpContext.cgiGet( dynavSedeid.getInternalname()) );
         AV63SedeId = (short)(GXutil.lval( httpContext.cgiGet( dynavSedeid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV63SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63SedeId), 4, 0));
         cmbavMinutosdecita.setValue( httpContext.cgiGet( cmbavMinutosdecita.getInternalname()) );
         AV46MinutosDeCita = (short)(GXutil.lval( httpContext.cgiGet( cmbavMinutosdecita.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46MinutosDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46MinutosDeCita), 4, 0));
         dynavTipocita.setValue( httpContext.cgiGet( dynavTipocita.getInternalname()) );
         AV81TipoCita = httpContext.cgiGet( dynavTipocita.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV81TipoCita", AV81TipoCita);
         AV50ProfesionalFoto = httpContext.cgiGet( imgavProfesionalfoto_Internalname) ;
         AV72tPacienteNroDocumento = httpContext.cgiGet( edtavTpacientenrodocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV72tPacienteNroDocumento", AV72tPacienteNroDocumento);
         AV32find = httpContext.cgiGet( imgavFind_Internalname) ;
         AV71tPacienteNombreCompleto = httpContext.cgiGet( edtavTpacientenombrecompleto_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71tPacienteNombreCompleto", AV71tPacienteNombreCompleto);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavFechainicio_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vFECHAINICIO");
            GX_FocusControl = edtavFechainicio_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV28FechaInicio = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28FechaInicio", localUtil.format(AV28FechaInicio, "99/99/99"));
         }
         else
         {
            AV28FechaInicio = localUtil.ctod( httpContext.cgiGet( edtavFechainicio_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28FechaInicio", localUtil.format(AV28FechaInicio, "99/99/99"));
         }
         cmbavSerepite.setValue( httpContext.cgiGet( cmbavSerepite.getInternalname()) );
         AV65SeRepite = (byte)(GXutil.lval( httpContext.cgiGet( cmbavSerepite.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65SeRepite", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65SeRepite), 2, 0));
         cmbavRepitecada.setValue( httpContext.cgiGet( cmbavRepitecada.getInternalname()) );
         AV58RepiteCada = (byte)(GXutil.lval( httpContext.cgiGet( cmbavRepitecada.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58RepiteCada", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58RepiteCada), 2, 0));
         AV41Lunes = GXutil.strtobool( httpContext.cgiGet( chkavLunes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41Lunes", AV41Lunes);
         AV42Martes = GXutil.strtobool( httpContext.cgiGet( chkavMartes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42Martes", AV42Martes);
         AV45Miercoles = GXutil.strtobool( httpContext.cgiGet( chkavMiercoles.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45Miercoles", AV45Miercoles);
         AV40Jueves = GXutil.strtobool( httpContext.cgiGet( chkavJueves.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40Jueves", AV40Jueves);
         AV75Viernes = GXutil.strtobool( httpContext.cgiGet( chkavViernes.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV75Viernes", AV75Viernes);
         AV61Sabado = GXutil.strtobool( httpContext.cgiGet( chkavSabado.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV61Sabado", AV61Sabado);
         AV23Domingo = GXutil.strtobool( httpContext.cgiGet( chkavDomingo.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23Domingo", AV23Domingo);
         AV29Finaliza = httpContext.cgiGet( radavFinaliza.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Finaliza", AV29Finaliza);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavFinalizafecha_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vFINALIZAFECHA");
            GX_FocusControl = edtavFinalizafecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV30FinalizaFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30FinalizaFecha", localUtil.format(AV30FinalizaFecha, "99/99/99"));
         }
         else
         {
            AV30FinalizaFecha = localUtil.ctod( httpContext.cgiGet( edtavFinalizafecha_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30FinalizaFecha", localUtil.format(AV30FinalizaFecha, "99/99/99"));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavFinalizanroveces_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavFinalizanroveces_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vFINALIZANROVECES");
            GX_FocusControl = edtavFinalizanroveces_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV31FinalizaNroVeces = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31FinalizaNroVeces", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31FinalizaNroVeces), 4, 0));
         }
         else
         {
            AV31FinalizaNroVeces = (short)(localUtil.ctol( httpContext.cgiGet( edtavFinalizanroveces_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31FinalizaNroVeces", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31FinalizaNroVeces), 4, 0));
         }
         AV60Resumen = httpContext.cgiGet( edtavResumen_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV60Resumen", AV60Resumen);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvvdisponibilidadhorainicio_html322( ) ;
         gxvvdisponibilidadhorafin_html322( ) ;
         gxvvprofesionalid_html322( AV12ClinicaId) ;
         gxvvespecialidadid_html322( AV51ProfesionalId) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e13322 ();
      if ( returnInSub )
      {
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e13322( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext6[0] = AV6WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext6) ;
      AV6WWPContext = GXv_SdtWWPContext6[0] ;
      AV62SecUserId = AV6WWPContext.getgxTv_SdtWWPContext_Userid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV62SecUserId), 4, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV62SecUserId), "ZZZ9")));
      if ( (0==AV62SecUserId) || ( AV62SecUserId == 0 ) )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.seclogin", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Using cursor H00326 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV62SecUserId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A6SecUserId = H00326_A6SecUserId[0] ;
         A14SecUserName = H00326_A14SecUserName[0] ;
         A122SecUserEmail = H00326_A122SecUserEmail[0] ;
         AV82SecUserName = A14SecUserName ;
         AV83SecUserEmail = A122SecUserEmail ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      /* Using cursor H00327 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV62SecUserId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A6SecUserId = H00327_A6SecUserId[0] ;
         A4SecRoleId = H00327_A4SecRoleId[0] ;
         AV5SecRoleId = A4SecRoleId ;
         pr_default.readNext(3);
      }
      pr_default.close(3);
      /* Using cursor H00329 */
      pr_default.execute(4, new Object[] {AV82SecUserName, AV83SecUserEmail});
      if ( (pr_default.getStatus(4) != 101) )
      {
         A40000ProfesionalId = H00329_A40000ProfesionalId[0] ;
         n40000ProfesionalId = H00329_n40000ProfesionalId[0] ;
      }
      else
      {
         A40000ProfesionalId = 0 ;
         n40000ProfesionalId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000ProfesionalId), 8, 0));
      }
      pr_default.close(4);
      edtavResumen_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavResumen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavResumen_Visible), 5, 0), true);
      AV50ProfesionalFoto = formatLink("doctor1", new String[] {}, new String[] {})  ;
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "Bitmap", ((GXutil.strcmp("", AV50ProfesionalFoto)==0) ? A40002ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV50ProfesionalFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV50ProfesionalFoto), true);
      if ( AV5SecRoleId == 2 )
      {
         AV51ProfesionalId = A40000ProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51ProfesionalId), 8, 0));
         dynavProfesionalid.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynavProfesionalid.getInternalname(), "Enabled", GXutil.ltrimstr( dynavProfesionalid.getEnabled(), 5, 0), true);
         GXv_char7[0] = AV50ProfesionalFoto ;
         GXv_int8[0] = AV67TiempoDeCita ;
         new com.projectthani.prccdprof(remoteHandle, context).execute( AV51ProfesionalId, GXv_char7, GXv_int8) ;
         detallecalendario_impl.this.AV50ProfesionalFoto = GXv_char7[0] ;
         detallecalendario_impl.this.AV67TiempoDeCita = GXv_int8[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "Bitmap", ((GXutil.strcmp("", AV50ProfesionalFoto)==0) ? A40002ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV50ProfesionalFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV50ProfesionalFoto), true);
      }
      AV12ClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12ClinicaId), 4, 0));
      if ( AV5SecRoleId == 3 )
      {
      }
      Dvmessage1_Defaultmessagetype = "notice" ;
      ucDvmessage1.sendProperty(context, "", false, Dvmessage1_Internalname, "DefaultMessageType", Dvmessage1_Defaultmessagetype);
      GX_FocusControl = bttCancelar_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      httpContext.doAjaxSetFocus(GX_FocusControl);
      bttEliminar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttEliminar_Enabled), 5, 0), true);
      divTable4_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable4_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable4_Visible), 5, 0), true);
      edtavInformecita_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita_Visible), 5, 0), true);
      edtavInformecita2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita2_Visible), 5, 0), true);
      edtavInformecita3_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavInformecita3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita3_Visible), 5, 0), true);
      bttRegistrarinformemedico_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttRegistrarinformemedico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttRegistrarinformemedico_Visible), 5, 0), true);
      AV14currentEvent.fromxml(AV77websession.getValue("currentevent"), null, null);
      AV70titulo = "Agregar disponibilidad del profesional: " + AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id() ;
      if ( (GXutil.strcmp("", AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id())==0) )
      {
         Form.setCaption( "Agregar disponibilidad del profesional" );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         bttGuardar_Caption = "Guardar" ;
         httpContext.ajax_rsp_assign_prop("", false, bttGuardar_Internalname, "Caption", bttGuardar_Caption, true);
         bttGuardar_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttGuardar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGuardar_Visible), 5, 0), true);
      }
      else
      {
         Form.setCaption( "Modificar disponibilidad del profesional" );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         bttGuardar_Caption = "Actualizar" ;
         httpContext.ajax_rsp_assign_prop("", false, bttGuardar_Internalname, "Caption", bttGuardar_Caption, true);
         bttRepetir_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttRepetir_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttRepetir_Visible), 5, 0), true);
         bttEliminar_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttEliminar_Enabled), 5, 0), true);
         /* Using cursor H003210 */
         pr_default.execute(5, new Object[] {AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id()});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A133EventId = H003210_A133EventId[0] ;
            A34DisponibilidadId = H003210_A34DisponibilidadId[0] ;
            AV22DisponibilidadId = A34DisponibilidadId ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22DisponibilidadId), 8, 0));
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(5);
         }
         pr_default.close(5);
         /* Using cursor H003212 */
         pr_default.execute(6, new Object[] {Integer.valueOf(AV22DisponibilidadId)});
         if ( (pr_default.getStatus(6) != 101) )
         {
            A40001CitaId = H003212_A40001CitaId[0] ;
            n40001CitaId = H003212_n40001CitaId[0] ;
         }
         else
         {
            A40001CitaId = 0 ;
            n40001CitaId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A40001CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001CitaId), 8, 0));
         }
         pr_default.close(6);
         /* Execute user subroutine: 'CARGARDISPONIBILIDAD' */
         S112 ();
         if ( returnInSub )
         {
            pr_default.close(6);
            pr_default.close(4);
            returnInSub = true;
            if (true) return;
         }
         AV10CitaId = A40001CitaId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CitaId), 8, 0));
         if ( AV10CitaId > 0 )
         {
            bttAgregarpaciente_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttAgregarpaciente_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttAgregarpaciente_Visible), 5, 0), true);
            Form.setCaption( "Ingresar Resultado de cita" );
            httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
            AV8Cita.Load(AV10CitaId);
            edtavInformecita_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavInformecita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita_Visible), 5, 0), true);
            edtavInformecita2_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavInformecita2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita2_Visible), 5, 0), true);
            edtavInformecita3_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavInformecita3_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavInformecita3_Visible), 5, 0), true);
            divTable4_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, divTable4_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable4_Visible), 5, 0), true);
            AV36InformeCita = "Existe una cita asociada a este calendario - Código de Cita: " + AV8Cita.getgxTv_SdtCita_Citacode() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36InformeCita", AV36InformeCita);
            AV37InformeCita2 = "Presione en la opción INFORME para registrar el resultado de la Cita" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV37InformeCita2", AV37InformeCita2);
            AV38InformeCita3 = "Link de Videoconferencia: <b><a href=\"" + GXutil.trim( AV8Cita.getgxTv_SdtCita_Citalink()) + "\" target=\"_blank\" style=\"    background-color: #08b4e7;padding: 0px 10px;border-radius: 10px;color: white;bottom: -;\">" + "Click Aquí" + "</a></b>" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38InformeCita3", AV38InformeCita3);
            bttGuardar_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttGuardar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGuardar_Enabled), 5, 0), true);
            bttEliminar_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttEliminar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttEliminar_Enabled), 5, 0), true);
         }
      }
      AV32find = context.getHttpContext().getImagePath( "d865e95c-4223-4395-8c8b-7e6abe50c192", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_prop("", false, imgavFind_Internalname, "Bitmap", ((GXutil.strcmp("", AV32find)==0) ? AV89Find_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV32find))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavFind_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV32find), true);
      AV89Find_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "d865e95c-4223-4395-8c8b-7e6abe50c192", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      httpContext.ajax_rsp_assign_prop("", false, imgavFind_Internalname, "Bitmap", ((GXutil.strcmp("", AV32find)==0) ? AV89Find_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV32find))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavFind_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV32find), true);
      edtavTpacientenombrecompleto_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTpacientenombrecompleto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTpacientenombrecompleto_Visible), 5, 0), true);
      bttGenerarcita_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttGenerarcita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGenerarcita_Visible), 5, 0), true);
      AV57Repetir = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV57Repetir", AV57Repetir);
      divTablerepetir_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablerepetir_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablerepetir_Visible), 5, 0), true);
      divTablesemana_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablesemana_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablesemana_Visible), 5, 0), true);
      edtavFechainicio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFechainicio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFechainicio_Enabled), 5, 0), true);
      AV7Agregar = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7Agregar", AV7Agregar);
      divTablepaciente_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablepaciente_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablepaciente_Visible), 5, 0), true);
      AV29Finaliza = "EL" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Finaliza", AV29Finaliza);
      AV30FinalizaFecha = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30FinalizaFecha", localUtil.format(AV30FinalizaFecha, "99/99/99"));
      edtavFinalizafecha_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFinalizafecha_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFinalizafecha_Visible), 5, 0), true);
      divTable1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable1_Visible), 5, 0), true);
      divHn1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divHn1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divHn1_Visible), 5, 0), true);
   }

   public void e14322( )
   {
      /* Profesionalid_Controlvaluechanged Routine */
      returnInSub = false ;
      GXv_char7[0] = AV50ProfesionalFoto ;
      GXv_int8[0] = AV67TiempoDeCita ;
      new com.projectthani.prccdprof(remoteHandle, context).execute( AV51ProfesionalId, GXv_char7, GXv_int8) ;
      detallecalendario_impl.this.AV50ProfesionalFoto = GXv_char7[0] ;
      detallecalendario_impl.this.AV67TiempoDeCita = GXv_int8[0] ;
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "Bitmap", ((GXutil.strcmp("", AV50ProfesionalFoto)==0) ? A40002ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV50ProfesionalFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV50ProfesionalFoto), true);
      /*  Sending Event outputs  */
   }

   public void S112( )
   {
      /* 'CARGARDISPONIBILIDAD' Routine */
      returnInSub = false ;
      AV18Disponibilidad.Load(AV22DisponibilidadId);
      AV34horaIni = localUtil.ttoc( AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadhorainicio(), 0, 5, 0, 3, "/", ":", " ") ;
      AV33horaFin = localUtil.ttoc( AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadhorafin(), 0, 5, 0, 3, "/", ":", " ") ;
      AV19DisponibilidadFecha = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadfecha() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19DisponibilidadFecha", localUtil.format(AV19DisponibilidadFecha, "99/99/99"));
      AV21DisponibilidadHoraInicio = AV34horaIni ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21DisponibilidadHoraInicio", AV21DisponibilidadHoraInicio);
      AV20DisponibilidadHoraFin = AV33horaFin ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20DisponibilidadHoraFin", AV20DisponibilidadHoraFin);
      AV51ProfesionalId = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Profesionalid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51ProfesionalId), 8, 0));
      AV26EspecialidadId = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Especialidadid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26EspecialidadId), 4, 0));
      AV63SedeId = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV63SedeId), 4, 0));
      AV81TipoCita = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadtipocita() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV81TipoCita", AV81TipoCita);
      GXv_char7[0] = AV50ProfesionalFoto ;
      GXv_int8[0] = AV67TiempoDeCita ;
      new com.projectthani.prccdprof(remoteHandle, context).execute( AV51ProfesionalId, GXv_char7, GXv_int8) ;
      detallecalendario_impl.this.AV50ProfesionalFoto = GXv_char7[0] ;
      detallecalendario_impl.this.AV67TiempoDeCita = GXv_int8[0] ;
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "Bitmap", ((GXutil.strcmp("", AV50ProfesionalFoto)==0) ? A40002ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV50ProfesionalFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV50ProfesionalFoto), true);
   }

   public void e15322( )
   {
      /* 'Cancelar' Routine */
      returnInSub = false ;
      AV77websession.remove("currentevent");
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(6);
      pr_default.close(4);
      returnInSub = true;
      if (true) return;
   }

   public void e16322( )
   {
      /* 'Guardar' Routine */
      returnInSub = false ;
      if ( (GXutil.strcmp("", AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id())==0) )
      {
         AV69TimeHoraInicio = localUtil.dtoc( AV19DisponibilidadFecha, 3, "/") + " " + AV21DisponibilidadHoraInicio ;
         AV68TimeHoraFin = localUtil.dtoc( AV19DisponibilidadFecha, 3, "/") + " " + AV20DisponibilidadHoraFin ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV19DisponibilidadFecha)) )
         {
            httpContext.GX_msglist.addItem("Por favor seleccione una fecha");
         }
         else
         {
            if ( GXutil.strcmp(AV21DisponibilidadHoraInicio, AV20DisponibilidadHoraFin) == 0 )
            {
               httpContext.GX_msglist.addItem("La hora de inicio y hora fin deben ser diferentes");
            }
            else
            {
               if ( localUtil.ctot( AV68TimeHoraFin, 3).before( localUtil.ctot( AV69TimeHoraInicio, 3) ) )
               {
                  httpContext.GX_msglist.addItem("La hora de inicio debe ser menor a la hora fin");
               }
               else
               {
                  if ( (0==AV51ProfesionalId) )
                  {
                     httpContext.GX_msglist.addItem("Por favor seleccione un profesional");
                  }
                  else
                  {
                     if ( (0==AV26EspecialidadId) )
                     {
                        httpContext.GX_msglist.addItem("Por favor seleccione una especialidad");
                     }
                     else
                     {
                        if ( (0==AV63SedeId) )
                        {
                           httpContext.GX_msglist.addItem("Por favor seleccione una sede");
                        }
                        else
                        {
                           /* Execute user subroutine: 'BOTON' */
                           S122 ();
                           if ( returnInSub )
                           {
                              pr_default.close(6);
                              pr_default.close(4);
                              returnInSub = true;
                              if (true) return;
                           }
                           if ( AV49NroTraslapes > 0 )
                           {
                              this.executeExternalObjectMethod("", false, "GlobalEvents", "MostrarTraslapesDisponibilidad", new Object[] {Short.valueOf(AV49NroTraslapes)}, true);
                           }
                           httpContext.setWebReturnParms(new Object[] {});
                           httpContext.setWebReturnParmsMetadata(new Object[] {});
                           httpContext.wjLocDisableFrm = (byte)(1) ;
                           httpContext.nUserReturn = (byte)(1) ;
                           pr_default.close(6);
                           pr_default.close(4);
                           returnInSub = true;
                           if (true) return;
                        }
                     }
                  }
               }
            }
         }
      }
      else
      {
         AV69TimeHoraInicio = localUtil.dtoc( AV19DisponibilidadFecha, 3, "/") + " " + AV21DisponibilidadHoraInicio ;
         AV68TimeHoraFin = localUtil.dtoc( AV19DisponibilidadFecha, 3, "/") + " " + AV20DisponibilidadHoraFin ;
         if ( new com.projectthani.verificarhorarioduplicado(remoteHandle, context).executeUdp( AV51ProfesionalId, AV26EspecialidadId, AV19DisponibilidadFecha, AV69TimeHoraInicio) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            httpContext.GX_msglist.addItem("Ya existe una disponibilidad con cruce de horario. Por favor revisar.");
         }
         else
         {
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadfecha( AV19DisponibilidadFecha );
            GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV69TimeHoraInicio, 3)) ;
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
            GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV68TimeHoraFin, 3)) ;
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadhorafin( GXt_dtime9 );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidaddescription( AV21DisponibilidadHoraInicio+" a "+AV20DisponibilidadHoraFin );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Profesionalid( AV51ProfesionalId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Especialidadid( AV26EspecialidadId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid( AV63SedeId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadestado( "A" );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidaduser( AV62SecUserId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadtipocita( AV81TipoCita );
            AV18Disponibilidad.Save();
            if ( AV18Disponibilidad.Success() )
            {
               AV74vDisponbilidadId2 = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid() ;
               Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
               httpContext.GX_msglist.addItem("Los datos se guardaron correctamente correctamente");
               if ( (GXutil.strcmp("", AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id())==0) )
               {
                  AV18Disponibilidad.Load(AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid());
                  AV18Disponibilidad.setgxTv_SdtDisponibilidad_Eventid( GXutil.str( AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid(), 8, 0) );
                  AV18Disponibilidad.Update();
                  Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
               }
               AV77websession.remove("currentevent");
               httpContext.setWebReturnParms(new Object[] {});
               httpContext.setWebReturnParmsMetadata(new Object[] {});
               httpContext.wjLocDisableFrm = (byte)(1) ;
               httpContext.nUserReturn = (byte)(1) ;
               pr_default.close(6);
               pr_default.close(4);
               returnInSub = true;
               if (true) return;
            }
            else
            {
               httpContext.GX_msglist.addItem("Hubo un error al guardar. Contactar con el administrador");
               Application.rollbackDataStores(context, remoteHandle, pr_default, "detallecalendario");
            }
         }
      }
      AV77websession.remove("currentevent");
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18Disponibilidad", AV18Disponibilidad);
   }

   public void e17322( )
   {
      /* 'Eliminar' Routine */
      returnInSub = false ;
      AV18Disponibilidad.Delete();
      if ( AV18Disponibilidad.Success() )
      {
         AV77websession.remove("currentevent");
         Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
         httpContext.setWebReturnParms(new Object[] {});
         httpContext.setWebReturnParmsMetadata(new Object[] {});
         httpContext.wjLocDisableFrm = (byte)(1) ;
         httpContext.nUserReturn = (byte)(1) ;
         pr_default.close(6);
         pr_default.close(4);
         returnInSub = true;
         if (true) return;
         httpContext.GX_msglist.addItem("Se eliminó la disponibilidad correctamente");
      }
      else
      {
         AV77websession.remove("currentevent");
         httpContext.GX_msglist.addItem("Hubo un error al eliminar. Contactar con el administrador");
         Application.rollbackDataStores(context, remoteHandle, pr_default, "detallecalendario");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18Disponibilidad", AV18Disponibilidad);
   }

   public void S122( )
   {
      /* 'BOTON' Routine */
      returnInSub = false ;
      AV67TiempoDeCita = (int)(AV46MinutosDeCita*60) ;
      AV15D.clear();
      AV69TimeHoraInicio = "1753-01-01 " + AV21DisponibilidadHoraInicio + ":00" ;
      AV68TimeHoraFin = "1753-01-01 " + AV20DisponibilidadHoraFin + ":00" ;
      AV48NroSegundos = (int)(GXutil.dtdiff( localUtil.ctot( AV68TimeHoraFin, 3), localUtil.ctot( AV69TimeHoraInicio, 3))) ;
      AV64SegundosSobrantes = (int)(((int)((AV48NroSegundos) % (AV67TiempoDeCita)))) ;
      AV48NroSegundos = (int)(AV48NroSegundos-AV64SegundosSobrantes) ;
      if ( ! AV57Repetir )
      {
         AV78x = (short)(0) ;
         AV54Qi = (short)(AV48NroSegundos/ (double) (AV67TiempoDeCita)) ;
         while ( AV78x < AV54Qi )
         {
            AV16Di = (com.projectthani.SdtSDTDisponibilidad)new com.projectthani.SdtSDTDisponibilidad(remoteHandle, context);
            AV16Di.setgxTv_SdtSDTDisponibilidad_Eventid( AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id() );
            AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadfecha( AV19DisponibilidadFecha );
            AV69TimeHoraInicio = localUtil.dtoc( AV19DisponibilidadFecha, 3, "/") + " " + AV21DisponibilidadHoraInicio ;
            GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV69TimeHoraInicio, 3)) ;
            AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
            GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), AV67TiempoDeCita*AV78x)) ;
            AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
            AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio() );
            GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), AV67TiempoDeCita)) ;
            AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( GXt_dtime9 );
            AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidaddescription( localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), 0, 5, 0, 3, "/", ":", " ")+" a "+localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), 0, 5, 0, 3, "/", ":", " ") );
            AV16Di.setgxTv_SdtSDTDisponibilidad_Profesionalid( AV51ProfesionalId );
            AV16Di.setgxTv_SdtSDTDisponibilidad_Especialidadid( AV26EspecialidadId );
            AV16Di.setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid( AV63SedeId );
            AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadestado( "A" );
            AV15D.add(AV16Di, 0);
            AV78x = (short)(AV78x+1) ;
         }
      }
      else
      {
         AV25dtInicio = localUtil.ymdhmsToT( (short)(GXutil.year( AV28FechaInicio)), (byte)(GXutil.month( AV28FechaInicio)), (byte)(GXutil.day( AV28FechaInicio)), (byte)(0), (byte)(0), (byte)(0)) ;
         AV24dtFin = localUtil.ymdhmsToT( (short)(GXutil.year( AV30FinalizaFecha)), (byte)(GXutil.month( AV30FinalizaFecha)), (byte)(GXutil.day( AV30FinalizaFecha)), (byte)(0), (byte)(0), (byte)(0)) ;
         if ( AV65SeRepite == 1 )
         {
            if ( GXutil.strcmp(AV29Finaliza, "EL") == 0 )
            {
               AV55Qj = (short)(GXutil.dtdiff( AV24dtFin, AV25dtInicio)/ (double) (86400)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55Qj", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55Qj), 4, 0));
            }
            if ( GXutil.strcmp(AV29Finaliza, "DD") == 0 )
            {
               AV55Qj = (short)((AV31FinalizaNroVeces-1)*AV58RepiteCada) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55Qj", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55Qj), 4, 0));
            }
            AV54Qi = (short)(AV48NroSegundos/ (double) (AV67TiempoDeCita)) ;
            AV79y = (short)(0) ;
            while ( AV79y <= AV55Qj )
            {
               AV78x = (short)(0) ;
               while ( AV78x < AV54Qi )
               {
                  AV16Di = (com.projectthani.SdtSDTDisponibilidad)new com.projectthani.SdtSDTDisponibilidad(remoteHandle, context);
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Eventid( AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id() );
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadfecha( GXutil.dadd( AV19DisponibilidadFecha, (AV79y)) );
                  AV69TimeHoraInicio = localUtil.dtoc( GXutil.dadd( AV19DisponibilidadFecha, (AV79y)), 3, "/") + " " + AV21DisponibilidadHoraInicio ;
                  GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV69TimeHoraInicio, 3)) ;
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
                  GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), AV67TiempoDeCita*AV78x)) ;
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio() );
                  GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), AV67TiempoDeCita)) ;
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( GXt_dtime9 );
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidaddescription( localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), 0, 5, 0, 3, "/", ":", " ")+" a "+localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), 0, 5, 0, 3, "/", ":", " ") );
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Profesionalid( AV51ProfesionalId );
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Especialidadid( AV26EspecialidadId );
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid( AV63SedeId );
                  AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadestado( "A" );
                  AV15D.add(AV16Di, 0);
                  AV78x = (short)(AV78x+1) ;
               }
               AV79y = (short)(AV79y+AV58RepiteCada) ;
            }
         }
         if ( ( AV65SeRepite == 2 ) || ( AV65SeRepite == 3 ) || ( AV65SeRepite == 4 ) )
         {
            if ( GXutil.strcmp(AV29Finaliza, "EL") == 0 )
            {
               AV55Qj = (short)(GXutil.dtdiff( AV24dtFin, AV25dtInicio)/ (double) (86400)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55Qj", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55Qj), 4, 0));
            }
            if ( GXutil.strcmp(AV29Finaliza, "DD") == 0 )
            {
               AV55Qj = (short)(AV31FinalizaNroVeces-1) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55Qj", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55Qj), 4, 0));
            }
            AV54Qi = (short)(AV48NroSegundos/ (double) (AV67TiempoDeCita)) ;
            AV79y = (short)(0) ;
            while ( AV79y <= AV55Qj )
            {
               if ( ( ( AV65SeRepite == 2 ) && ( GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) >= 2 ) && ( GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) <= 6 ) ) || ( ( AV65SeRepite == 3 ) && ( GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) == 2 ) ) || ( ( AV65SeRepite == 3 ) && ( GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) == 4 ) ) || ( ( AV65SeRepite == 3 ) && ( GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) == 6 ) ) || ( ( AV65SeRepite == 4 ) && ( GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) == 3 ) ) || ( ( AV65SeRepite == 4 ) && ( GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) == 5 ) ) )
               {
                  AV78x = (short)(0) ;
                  while ( AV78x < AV54Qi )
                  {
                     AV16Di = (com.projectthani.SdtSDTDisponibilidad)new com.projectthani.SdtSDTDisponibilidad(remoteHandle, context);
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Eventid( AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id() );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadfecha( GXutil.dadd( AV19DisponibilidadFecha, (AV79y)) );
                     AV69TimeHoraInicio = localUtil.dtoc( GXutil.dadd( AV19DisponibilidadFecha, (AV79y)), 3, "/") + " " + AV21DisponibilidadHoraInicio ;
                     GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV69TimeHoraInicio, 3)) ;
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
                     GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), AV67TiempoDeCita*AV78x)) ;
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio() );
                     GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), AV67TiempoDeCita)) ;
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( GXt_dtime9 );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidaddescription( localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), 0, 5, 0, 3, "/", ":", " ")+" a "+localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), 0, 5, 0, 3, "/", ":", " ") );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Profesionalid( AV51ProfesionalId );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Especialidadid( AV26EspecialidadId );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid( AV63SedeId );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadestado( "A" );
                     AV15D.add(AV16Di, 0);
                     AV78x = (short)(AV78x+1) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(AV29Finaliza, "DD") == 0 )
                  {
                     AV55Qj = (short)(AV55Qj+1) ;
                     httpContext.ajax_rsp_assign_attri("", false, "AV55Qj", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55Qj), 4, 0));
                  }
               }
               AV79y = (short)(AV79y+1) ;
            }
         }
         if ( AV65SeRepite == 5 )
         {
            if ( GXutil.strcmp(AV29Finaliza, "EL") == 0 )
            {
               AV55Qj = (short)(GXutil.dtdiff( AV24dtFin, AV25dtInicio)/ (double) (86400)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55Qj", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55Qj), 4, 0));
            }
            if ( GXutil.strcmp(AV29Finaliza, "DD") == 0 )
            {
               AV55Qj = (short)(AV31FinalizaNroVeces*AV58RepiteCada*7-1) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55Qj", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55Qj), 4, 0));
            }
            AV17Dias.clear();
            AV17Dias.add(AV23Domingo, 0);
            AV17Dias.add(AV41Lunes, 0);
            AV17Dias.add(AV42Martes, 0);
            AV17Dias.add(AV45Miercoles, 0);
            AV17Dias.add(AV40Jueves, 0);
            AV17Dias.add(AV75Viernes, 0);
            AV17Dias.add(AV61Sabado, 0);
            AV54Qi = (short)(AV48NroSegundos/ (double) (AV67TiempoDeCita)) ;
            AV79y = (short)(0) ;
            while ( AV79y <= AV55Qj )
            {
               AV78x = (short)(0) ;
               while ( AV78x < AV54Qi )
               {
                  AV80z = GXutil.dow( GXutil.dadd( AV19DisponibilidadFecha, (AV79y))) ;
                  if ( ((Boolean) AV17Dias.elementAt(-1+AV80z)).booleanValue() )
                  {
                     AV16Di = (com.projectthani.SdtSDTDisponibilidad)new com.projectthani.SdtSDTDisponibilidad(remoteHandle, context);
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Eventid( AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id() );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadfecha( GXutil.dadd( AV19DisponibilidadFecha, (AV79y)) );
                     AV69TimeHoraInicio = localUtil.dtoc( GXutil.dadd( AV19DisponibilidadFecha, (AV79y)), 3, "/") + " " + AV21DisponibilidadHoraInicio ;
                     GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV69TimeHoraInicio, 3)) ;
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
                     GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), AV67TiempoDeCita*AV78x)) ;
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio() );
                     GXt_dtime9 = GXutil.resetDate(GXutil.dtadd( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), AV67TiempoDeCita)) ;
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin( GXt_dtime9 );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidaddescription( localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio(), 0, 5, 0, 3, "/", ":", " ")+" a "+localUtil.ttoc( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin(), 0, 5, 0, 3, "/", ":", " ") );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Profesionalid( AV51ProfesionalId );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Especialidadid( AV26EspecialidadId );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid( AV63SedeId );
                     AV16Di.setgxTv_SdtSDTDisponibilidad_Disponibilidadestado( "A" );
                     AV15D.add(AV16Di, 0);
                  }
                  AV78x = (short)(AV78x+1) ;
               }
               AV79y = (short)(AV79y+AV58RepiteCada) ;
            }
         }
      }
      AV49NroTraslapes = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49NroTraslapes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49NroTraslapes), 4, 0));
      AV90GXV1 = 1 ;
      while ( AV90GXV1 <= AV15D.size() )
      {
         AV16Di = (com.projectthani.SdtSDTDisponibilidad)((com.projectthani.SdtSDTDisponibilidad)AV15D.elementAt(-1+AV90GXV1));
         if ( new com.projectthani.verificarhorarioduplicadonuevo(remoteHandle, context).executeUdp( AV16Di.getgxTv_SdtSDTDisponibilidad_Profesionalid(), AV16Di.getgxTv_SdtSDTDisponibilidad_Especialidadid(), AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadfecha(), AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio()) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV49NroTraslapes = (short)(AV49NroTraslapes+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV49NroTraslapes", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV49NroTraslapes), 4, 0));
         }
         else
         {
            AV18Disponibilidad = (com.projectthani.SdtDisponibilidad)new com.projectthani.SdtDisponibilidad( remoteHandle, context);
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Eventid( AV16Di.getgxTv_SdtSDTDisponibilidad_Eventid() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadfecha( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadfecha() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadhorainicio( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorainicio() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadhorafin( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadhorafin() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidaddescription( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidaddescription() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Profesionalid( AV16Di.getgxTv_SdtSDTDisponibilidad_Profesionalid() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Especialidadid( AV16Di.getgxTv_SdtSDTDisponibilidad_Especialidadid() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid( AV16Di.getgxTv_SdtSDTDisponibilidad_Sgsededisponibilidadsedeid() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadestado( AV16Di.getgxTv_SdtSDTDisponibilidad_Disponibilidadestado() );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidaduser( AV62SecUserId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadestadocita( "L" );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadtipocita( AV81TipoCita );
            AV18Disponibilidad.Save();
            httpContext.GX_msglist.addItem("Insertando");
            if ( AV18Disponibilidad.Success() )
            {
               Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
               AV18Disponibilidad.Load(AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid());
               GXt_char10 = "" ;
               GXv_char7[0] = GXt_char10 ;
               new com.projectthani.prcgetrandomstring(remoteHandle, context).execute( AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid(), (short)(20), GXv_char7) ;
               detallecalendario_impl.this.GXt_char10 = GXv_char7[0] ;
               AV18Disponibilidad.setgxTv_SdtDisponibilidad_Eventid( GXt_char10 );
               AV18Disponibilidad.Update();
               Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
            }
         }
         AV90GXV1 = (int)(AV90GXV1+1) ;
      }
      if ( AV18Disponibilidad.Success() )
      {
         Dvmessage1_Defaultmessagetype = "success" ;
         ucDvmessage1.sendProperty(context, "", false, Dvmessage1_Internalname, "DefaultMessageType", Dvmessage1_Defaultmessagetype);
         httpContext.GX_msglist.addItem("Los datos se guardaron correctamente correctamente");
      }
      else
      {
         httpContext.GX_msglist.addItem("Hubo un error. Contactar con el administrador");
      }
   }

   public void e22322( )
   {
      /* 'AgregarPaciente' Routine */
      returnInSub = false ;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV19DisponibilidadFecha)) )
      {
         Dvmessage1_Defaultmessagetype = "notice" ;
         ucDvmessage1.sendProperty(context, "", false, Dvmessage1_Internalname, "DefaultMessageType", Dvmessage1_Defaultmessagetype);
         httpContext.GX_msglist.addItem("Seleccione una fecha primero");
      }
      else
      {
         if ( (GXutil.strcmp("", AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id())==0) )
         {
            AV7Agregar = (boolean)(!AV7Agregar) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7Agregar", AV7Agregar);
            if ( AV7Agregar )
            {
               divTablepaciente_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divTablepaciente_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablepaciente_Visible), 5, 0), true);
               divHn1_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divHn1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divHn1_Visible), 5, 0), true);
               bttRepetir_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, bttRepetir_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttRepetir_Visible), 5, 0), true);
               edtavTpacientenombrecompleto_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavTpacientenombrecompleto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTpacientenombrecompleto_Visible), 5, 0), true);
            }
            else
            {
               divTablepaciente_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, divTablepaciente_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablepaciente_Visible), 5, 0), true);
               divHn1_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, divHn1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divHn1_Visible), 5, 0), true);
               bttGenerarcita_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, bttGenerarcita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGenerarcita_Visible), 5, 0), true);
               bttRepetir_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, bttRepetir_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttRepetir_Visible), 5, 0), true);
               AV71tPacienteNombreCompleto = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV71tPacienteNombreCompleto", AV71tPacienteNombreCompleto);
               AV72tPacienteNroDocumento = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV72tPacienteNroDocumento", AV72tPacienteNroDocumento);
            }
         }
         else
         {
            AV7Agregar = (boolean)(!AV7Agregar) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7Agregar", AV7Agregar);
            if ( AV7Agregar )
            {
               divTablepaciente_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divTablepaciente_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablepaciente_Visible), 5, 0), true);
               divHn1_Visible = 1 ;
               httpContext.ajax_rsp_assign_prop("", false, divHn1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divHn1_Visible), 5, 0), true);
               edtavTpacientenombrecompleto_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, edtavTpacientenombrecompleto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTpacientenombrecompleto_Visible), 5, 0), true);
            }
            else
            {
               divTablepaciente_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, divTablepaciente_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablepaciente_Visible), 5, 0), true);
               divHn1_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, divHn1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divHn1_Visible), 5, 0), true);
               bttGenerarcita_Visible = 0 ;
               httpContext.ajax_rsp_assign_prop("", false, bttGenerarcita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGenerarcita_Visible), 5, 0), true);
               AV71tPacienteNombreCompleto = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV71tPacienteNombreCompleto", AV71tPacienteNombreCompleto);
               AV72tPacienteNroDocumento = "" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV72tPacienteNroDocumento", AV72tPacienteNroDocumento);
            }
         }
      }
      /*  Sending Event outputs  */
   }

   public void e18322( )
   {
      /* GlobalEvents_Return Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(6);
      pr_default.close(4);
      returnInSub = true;
      if (true) return;
   }

   public void e19322( )
   {
      /* Find_Click Routine */
      returnInSub = false ;
      AV76vPacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV76vPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76vPacienteId), 8, 0));
      if ( GXutil.strcmp(GXutil.trim( AV72tPacienteNroDocumento), "") == 0 )
      {
         httpContext.GX_msglist.addItem("Debe ingresar el número de documento");
      }
      else
      {
         /* Using cursor H003213 */
         pr_default.execute(7, new Object[] {AV72tPacienteNroDocumento});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A106PacienteNroDocumento = H003213_A106PacienteNroDocumento[0] ;
            A105PacienteNombres = H003213_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H003213_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H003213_A103PacienteApellidoPaterno[0] ;
            A20PacienteId = H003213_A20PacienteId[0] ;
            AV71tPacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71tPacienteNombreCompleto", AV71tPacienteNombreCompleto);
            AV76vPacienteId = A20PacienteId ;
            httpContext.ajax_rsp_assign_attri("", false, "AV76vPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV76vPacienteId), 8, 0));
            pr_default.readNext(7);
         }
         pr_default.close(7);
         if ( (0==AV76vPacienteId) )
         {
            httpContext.GX_msglist.addItem("No se encontró al paciente, revise el documento ingresado");
            AV71tPacienteNombreCompleto = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV71tPacienteNombreCompleto", AV71tPacienteNombreCompleto);
         }
         else
         {
            edtavTpacientenombrecompleto_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtavTpacientenombrecompleto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTpacientenombrecompleto_Visible), 5, 0), true);
            bttGenerarcita_Visible = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, bttGenerarcita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGenerarcita_Visible), 5, 0), true);
         }
      }
      /*  Sending Event outputs  */
   }

   public void e20322( )
   {
      /* 'Generar Cita' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'VERIFICARCITAS' */
      S132 ();
      if ( returnInSub )
      {
         pr_default.close(6);
         pr_default.close(4);
         returnInSub = true;
         if (true) return;
      }
      if ( AV10CitaId > 0 )
      {
         httpContext.GX_msglist.addItem("Ya cuenta con una cita para esta especialidad en el dia "+localUtil.dtoc( AV19DisponibilidadFecha, 3, "/")+" , por favor intente con otra fecha.");
      }
      else
      {
         if ( new com.projectthani.verificarhorarioduplicado(remoteHandle, context).executeUdp( AV51ProfesionalId, AV26EspecialidadId, AV19DisponibilidadFecha, AV21DisponibilidadHoraInicio) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV18Disponibilidad = (com.projectthani.SdtDisponibilidad)new com.projectthani.SdtDisponibilidad( remoteHandle, context);
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadfecha( AV19DisponibilidadFecha );
            AV69TimeHoraInicio = localUtil.dtoc( AV19DisponibilidadFecha, 3, "/") + " " + AV21DisponibilidadHoraInicio ;
            AV68TimeHoraFin = localUtil.dtoc( AV19DisponibilidadFecha, 3, "/") + " " + AV20DisponibilidadHoraFin ;
            GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV69TimeHoraInicio, 3)) ;
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadhorainicio( GXt_dtime9 );
            GXt_dtime9 = GXutil.resetDate(localUtil.ctot( AV68TimeHoraFin, 3)) ;
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadhorafin( GXt_dtime9 );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidaddescription( AV21DisponibilidadHoraInicio+" a "+AV20DisponibilidadHoraFin );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Profesionalid( AV51ProfesionalId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Especialidadid( AV26EspecialidadId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Sgsededisponibilidadsedeid( AV63SedeId );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadtipocita( AV81TipoCita );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadestado( "A" );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadestadocita( "O" );
            AV18Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidaduser( AV62SecUserId );
            AV18Disponibilidad.Save();
            if ( AV18Disponibilidad.Success() )
            {
               AV74vDisponbilidadId2 = AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid() ;
               Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
               AV8Cita.setgxTv_SdtCita_Pacienteid( AV76vPacienteId );
               AV8Cita.setgxTv_SdtCita_Sgcitadisponibilidadid( AV74vDisponbilidadId2 );
               GXt_char10 = "" ;
               GXv_char7[0] = GXt_char10 ;
               new com.projectthani.prcgetrandomstring(remoteHandle, context).execute( AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid(), (short)(20), GXv_char7) ;
               detallecalendario_impl.this.GXt_char10 = GXv_char7[0] ;
               AV8Cita.setgxTv_SdtCita_Citacode( GXt_char10 );
               AV8Cita.setgxTv_SdtCita_Citaestadocita( "R" );
               AV8Cita.setgxTv_SdtCita_Citaestado( "A" );
               AV8Cita.setgxTv_SdtCita_Citafechareserva( GXutil.now( ) );
               AV8Cita.setgxTv_SdtCita_Citalink( "https://meet.jit.si/"+java.util.UUID.randomUUID( ).toString()+"-"+AV8Cita.getgxTv_SdtCita_Citacode() );
               AV8Cita.setgxTv_SdtCita_Citaestadopago( "S" );
               AV8Cita.Save();
               if ( AV8Cita.Success() )
               {
                  AV11CitaId2 = AV8Cita.getgxTv_SdtCita_Citaid() ;
                  AV47Mod = "INS" ;
                  Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
                  if ( (( GXutil.resetTime(AV19DisponibilidadFecha).after( GXutil.resetTime( Gx_date )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV19DisponibilidadFecha), GXutil.resetTime(Gx_date)) )) )
                  {
                     if ( GXutil.strcmp(AV59resjson, "error") == 0 )
                     {
                        AV59resjson = "Enlace de videoconferencia por confirmar" ;
                        httpContext.ajax_rsp_assign_attri("", false, "AV59resjson", AV59resjson);
                     }
                     AV8Cita.Load(AV11CitaId2);
                     AV8Cita.setgxTv_SdtCita_Citalink( AV59resjson );
                     AV8Cita.setgxTv_SdtCita_Citaemailgenlink( AV9CitaEmailGenLink );
                     AV8Cita.Update();
                     Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
                  }
                  if ( AV39IsResult )
                  {
                     Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
                     Dvmessage1_Defaultmessagetype = "success" ;
                     ucDvmessage1.sendProperty(context, "", false, Dvmessage1_Internalname, "DefaultMessageType", Dvmessage1_Defaultmessagetype);
                     httpContext.GX_msglist.addItem("La reserva se hizo satisfactoriamente. Revise su correo electrónico");
                  }
               }
               else
               {
               }
               if ( (GXutil.strcmp("", AV14currentEvent.getgxTv_SdtSchedulerEvents_event_Id())==0) )
               {
                  AV18Disponibilidad.Load(AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid());
                  AV18Disponibilidad.setgxTv_SdtDisponibilidad_Eventid( GXutil.trim( GXutil.str( AV18Disponibilidad.getgxTv_SdtDisponibilidad_Disponibilidadid(), 8, 0)) );
                  AV18Disponibilidad.Update();
                  Application.commitDataStores(context, remoteHandle, pr_default, "detallecalendario");
               }
               AV77websession.remove("currentevent");
               httpContext.setWebReturnParms(new Object[] {});
               httpContext.setWebReturnParmsMetadata(new Object[] {});
               httpContext.wjLocDisableFrm = (byte)(1) ;
               httpContext.nUserReturn = (byte)(1) ;
               pr_default.close(6);
               pr_default.close(4);
               returnInSub = true;
               if (true) return;
            }
            else
            {
               httpContext.GX_msglist.addItem("Hubo un error al guardar. Contactar con el administrador");
               Application.rollbackDataStores(context, remoteHandle, pr_default, "detallecalendario");
            }
         }
         else
         {
            httpContext.GX_msglist.addItem("Hay un cruce con esa disponibilidad.");
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18Disponibilidad", AV18Disponibilidad);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV8Cita", AV8Cita);
   }

   public void S132( )
   {
      /* 'VERIFICARCITAS' Routine */
      returnInSub = false ;
      AV10CitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CitaId), 8, 0));
      /* Using cursor H003214 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV76vPacienteId), AV19DisponibilidadFecha, Short.valueOf(AV26EspecialidadId)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A21SGCitaDisponibilidadId = H003214_A21SGCitaDisponibilidadId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = H003214_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A66SGCitaDisponibilidadFecha = H003214_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = H003214_n66SGCitaDisponibilidadFecha[0] ;
         A20PacienteId = H003214_A20PacienteId[0] ;
         A19CitaId = H003214_A19CitaId[0] ;
         A70SGCitaDisponibilidadEspecialidadId = H003214_A70SGCitaDisponibilidadEspecialidadId[0] ;
         A66SGCitaDisponibilidadFecha = H003214_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = H003214_n66SGCitaDisponibilidadFecha[0] ;
         AV10CitaId = A19CitaId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10CitaId), 8, 0));
         pr_default.readNext(8);
      }
      pr_default.close(8);
   }

   protected void nextLoad( )
   {
   }

   protected void e21322( )
   {
      /* Load Routine */
      returnInSub = false ;
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
      pa322( ) ;
      ws322( ) ;
      we322( ) ;
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
      httpContext.AddStyleSheetFile("ChosenGx/chosen.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110335726", true, true);
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
      httpContext.AddJavascriptSource("detallecalendario.js", "?20225110335727", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/chosen.jquery.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/ChosenGxRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtavInformecita_Internalname = "vINFORMECITA" ;
      edtavInformecita2_Internalname = "vINFORMECITA2" ;
      edtavInformecita3_Internalname = "vINFORMECITA3" ;
      divTable4_Internalname = "TABLE4" ;
      lblTextblock5_Internalname = "TEXTBLOCK5" ;
      dynavProfesionalid.setInternalname( "vPROFESIONALID" );
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      edtavDisponibilidadfecha_Internalname = "vDISPONIBILIDADFECHA" ;
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      dynavDisponibilidadhorainicio.setInternalname( "vDISPONIBILIDADHORAINICIO" );
      lblTextblock3_Internalname = "TEXTBLOCK3" ;
      dynavDisponibilidadhorafin.setInternalname( "vDISPONIBILIDADHORAFIN" );
      lblTextblock4_Internalname = "TEXTBLOCK4" ;
      dynavEspecialidadid.setInternalname( "vESPECIALIDADID" );
      lblTextblock6_Internalname = "TEXTBLOCK6" ;
      dynavSedeid.setInternalname( "vSEDEID" );
      lblTextblock9_Internalname = "TEXTBLOCK9" ;
      cmbavMinutosdecita.setInternalname( "vMINUTOSDECITA" );
      lblTextblock10_Internalname = "TEXTBLOCK10" ;
      dynavTipocita.setInternalname( "vTIPOCITA" );
      divTable3_Internalname = "TABLE3" ;
      imgavProfesionalfoto_Internalname = "vPROFESIONALFOTO" ;
      bttRepetir_Internalname = "REPETIR" ;
      bttAgregarpaciente_Internalname = "AGREGARPACIENTE" ;
      divHn1_Internalname = "HN1" ;
      edtavTpacientenrodocumento_Internalname = "vTPACIENTENRODOCUMENTO" ;
      imgavFind_Internalname = "vFIND" ;
      edtavTpacientenombrecompleto_Internalname = "vTPACIENTENOMBRECOMPLETO" ;
      bttGenerarcita_Internalname = "GENERARCITA" ;
      divTablepaciente_Internalname = "TABLEPACIENTE" ;
      edtavFechainicio_Internalname = "vFECHAINICIO" ;
      cmbavSerepite.setInternalname( "vSEREPITE" );
      cmbavRepitecada.setInternalname( "vREPITECADA" );
      lblTextblock7_Internalname = "TEXTBLOCK7" ;
      chkavLunes.setInternalname( "vLUNES" );
      chkavMartes.setInternalname( "vMARTES" );
      chkavMiercoles.setInternalname( "vMIERCOLES" );
      chkavJueves.setInternalname( "vJUEVES" );
      chkavViernes.setInternalname( "vVIERNES" );
      chkavSabado.setInternalname( "vSABADO" );
      chkavDomingo.setInternalname( "vDOMINGO" );
      divTablesemana_Internalname = "TABLESEMANA" ;
      radavFinaliza.setInternalname( "vFINALIZA" );
      edtavFinalizafecha_Internalname = "vFINALIZAFECHA" ;
      edtavFinalizanroveces_Internalname = "vFINALIZANROVECES" ;
      lblTextblock8_Internalname = "TEXTBLOCK8" ;
      divTable1_Internalname = "TABLE1" ;
      edtavResumen_Internalname = "vRESUMEN" ;
      divTablerepetir_Internalname = "TABLEREPETIR" ;
      divTable2_Internalname = "TABLE2" ;
      bttGuardar_Internalname = "GUARDAR" ;
      bttEliminar_Internalname = "ELIMINAR" ;
      bttRegistrarinformemedico_Internalname = "REGISTRARINFORMEMEDICO" ;
      bttCancelar_Internalname = "CANCELAR" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      Chosengx1_Internalname = "CHOSENGX1" ;
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
      bttRegistrarinformemedico_Visible = 1 ;
      bttEliminar_Enabled = 1 ;
      bttGuardar_Caption = "Guardar" ;
      bttGuardar_Enabled = 1 ;
      bttGuardar_Visible = 1 ;
      edtavResumen_Enabled = 1 ;
      edtavResumen_Visible = 1 ;
      edtavFinalizanroveces_Jsonclick = "" ;
      edtavFinalizanroveces_Enabled = 1 ;
      divTable1_Visible = 1 ;
      edtavFinalizafecha_Jsonclick = "" ;
      edtavFinalizafecha_Enabled = 1 ;
      edtavFinalizafecha_Visible = 1 ;
      radavFinaliza.setJsonclick( "" );
      chkavDomingo.setEnabled( 1 );
      chkavSabado.setEnabled( 1 );
      chkavViernes.setEnabled( 1 );
      chkavJueves.setEnabled( 1 );
      chkavMiercoles.setEnabled( 1 );
      chkavMartes.setEnabled( 1 );
      chkavLunes.setEnabled( 1 );
      divTablesemana_Visible = 1 ;
      cmbavRepitecada.setJsonclick( "" );
      cmbavRepitecada.setEnabled( 1 );
      cmbavRepitecada.setVisible( 1 );
      cmbavSerepite.setJsonclick( "" );
      cmbavSerepite.setEnabled( 1 );
      edtavFechainicio_Jsonclick = "" ;
      edtavFechainicio_Enabled = 1 ;
      divTablerepetir_Visible = 1 ;
      bttGenerarcita_Visible = 1 ;
      edtavTpacientenombrecompleto_Enabled = 1 ;
      edtavTpacientenombrecompleto_Visible = 1 ;
      imgavFind_Jsonclick = "" ;
      edtavTpacientenrodocumento_Jsonclick = "" ;
      edtavTpacientenrodocumento_Enabled = 1 ;
      divTablepaciente_Visible = 1 ;
      divHn1_Visible = 1 ;
      bttAgregarpaciente_Visible = 1 ;
      bttRepetir_Visible = 1 ;
      dynavTipocita.setJsonclick( "" );
      dynavTipocita.setEnabled( 1 );
      cmbavMinutosdecita.setJsonclick( "" );
      cmbavMinutosdecita.setEnabled( 1 );
      dynavSedeid.setJsonclick( "" );
      dynavSedeid.setEnabled( 1 );
      dynavEspecialidadid.setJsonclick( "" );
      dynavEspecialidadid.setEnabled( 1 );
      dynavDisponibilidadhorafin.setJsonclick( "" );
      dynavDisponibilidadhorafin.setEnabled( 1 );
      dynavDisponibilidadhorainicio.setJsonclick( "" );
      dynavDisponibilidadhorainicio.setEnabled( 1 );
      edtavDisponibilidadfecha_Jsonclick = "" ;
      edtavDisponibilidadfecha_Enabled = 1 ;
      dynavProfesionalid.setJsonclick( "" );
      dynavProfesionalid.setEnabled( 1 );
      edtavInformecita3_Enabled = 1 ;
      edtavInformecita3_Visible = 1 ;
      edtavInformecita2_Jsonclick = "" ;
      edtavInformecita2_Enabled = 1 ;
      edtavInformecita2_Visible = 1 ;
      edtavInformecita_Jsonclick = "" ;
      edtavInformecita_Enabled = 1 ;
      edtavInformecita_Visible = 1 ;
      divTable4_Visible = 1 ;
      Dvmessage1_Defaultmessagetype = "notice" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Disponibilidad del Profesional - Thani" );
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      dynavProfesionalid.setName( "vPROFESIONALID" );
      dynavProfesionalid.setWebtags( "" );
      dynavDisponibilidadhorainicio.setName( "vDISPONIBILIDADHORAINICIO" );
      dynavDisponibilidadhorainicio.setWebtags( "" );
      dynavDisponibilidadhorafin.setName( "vDISPONIBILIDADHORAFIN" );
      dynavDisponibilidadhorafin.setWebtags( "" );
      dynavEspecialidadid.setName( "vESPECIALIDADID" );
      dynavEspecialidadid.setWebtags( "" );
      dynavSedeid.setName( "vSEDEID" );
      dynavSedeid.setWebtags( "" );
      cmbavMinutosdecita.setName( "vMINUTOSDECITA" );
      cmbavMinutosdecita.setWebtags( "" );
      cmbavMinutosdecita.addItem("30", "30 Minutos", (short)(0));
      cmbavMinutosdecita.addItem("60", "1 Hora", (short)(0));
      cmbavMinutosdecita.addItem("90", "1 Hora, 30 Minutos", (short)(0));
      cmbavMinutosdecita.addItem("120", "2 horas", (short)(0));
      if ( cmbavMinutosdecita.getItemCount() > 0 )
      {
         AV46MinutosDeCita = (short)(GXutil.lval( cmbavMinutosdecita.getValidValue(GXutil.trim( GXutil.str( AV46MinutosDeCita, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46MinutosDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV46MinutosDeCita), 4, 0));
      }
      dynavTipocita.setName( "vTIPOCITA" );
      dynavTipocita.setWebtags( "" );
      cmbavSerepite.setName( "vSEREPITE" );
      cmbavSerepite.setWebtags( "" );
      cmbavSerepite.addItem("1", "Todos los días", (short)(0));
      cmbavSerepite.addItem("2", "Todos los días hábiles (Lunes - Viernes)", (short)(0));
      cmbavSerepite.addItem("3", "Todos los Lunes-Miércoles-Viernes", (short)(0));
      cmbavSerepite.addItem("4", "Todos los Martes-Jueves", (short)(0));
      cmbavSerepite.addItem("5", "Todas las semanas", (short)(0));
      if ( cmbavSerepite.getItemCount() > 0 )
      {
         AV65SeRepite = (byte)(GXutil.lval( cmbavSerepite.getValidValue(GXutil.trim( GXutil.str( AV65SeRepite, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65SeRepite", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65SeRepite), 2, 0));
      }
      cmbavRepitecada.setName( "vREPITECADA" );
      cmbavRepitecada.setWebtags( "" );
      cmbavRepitecada.addItem("1", "1", (short)(0));
      cmbavRepitecada.addItem("2", "2", (short)(0));
      cmbavRepitecada.addItem("3", "3", (short)(0));
      cmbavRepitecada.addItem("4", "4", (short)(0));
      cmbavRepitecada.addItem("5", "5", (short)(0));
      cmbavRepitecada.addItem("6", "6", (short)(0));
      cmbavRepitecada.addItem("7", "7", (short)(0));
      cmbavRepitecada.addItem("8", "8", (short)(0));
      cmbavRepitecada.addItem("9", "9", (short)(0));
      cmbavRepitecada.addItem("10", "10", (short)(0));
      cmbavRepitecada.addItem("11", "11", (short)(0));
      cmbavRepitecada.addItem("12", "12", (short)(0));
      cmbavRepitecada.addItem("13", "13", (short)(0));
      cmbavRepitecada.addItem("14", "14", (short)(0));
      cmbavRepitecada.addItem("15", "15", (short)(0));
      cmbavRepitecada.addItem("16", "16", (short)(0));
      cmbavRepitecada.addItem("17", "17", (short)(0));
      cmbavRepitecada.addItem("18", "18", (short)(0));
      cmbavRepitecada.addItem("19", "19", (short)(0));
      cmbavRepitecada.addItem("20", "20", (short)(0));
      cmbavRepitecada.addItem("21", "21", (short)(0));
      cmbavRepitecada.addItem("22", "22", (short)(0));
      cmbavRepitecada.addItem("23", "23", (short)(0));
      cmbavRepitecada.addItem("24", "24", (short)(0));
      cmbavRepitecada.addItem("25", "25", (short)(0));
      cmbavRepitecada.addItem("26", "26", (short)(0));
      cmbavRepitecada.addItem("27", "27", (short)(0));
      cmbavRepitecada.addItem("28", "28", (short)(0));
      cmbavRepitecada.addItem("29", "29", (short)(0));
      cmbavRepitecada.addItem("30", "30", (short)(0));
      cmbavRepitecada.addItem("31", "31", (short)(0));
      if ( cmbavRepitecada.getItemCount() > 0 )
      {
         AV58RepiteCada = (byte)(GXutil.lval( cmbavRepitecada.getValidValue(GXutil.trim( GXutil.str( AV58RepiteCada, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV58RepiteCada", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV58RepiteCada), 2, 0));
      }
      chkavLunes.setName( "vLUNES" );
      chkavLunes.setWebtags( "" );
      chkavLunes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavLunes.getInternalname(), "TitleCaption", chkavLunes.getCaption(), true);
      chkavLunes.setCheckedValue( "false" );
      AV41Lunes = GXutil.strtobool( GXutil.booltostr( AV41Lunes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41Lunes", AV41Lunes);
      chkavMartes.setName( "vMARTES" );
      chkavMartes.setWebtags( "" );
      chkavMartes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavMartes.getInternalname(), "TitleCaption", chkavMartes.getCaption(), true);
      chkavMartes.setCheckedValue( "false" );
      AV42Martes = GXutil.strtobool( GXutil.booltostr( AV42Martes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42Martes", AV42Martes);
      chkavMiercoles.setName( "vMIERCOLES" );
      chkavMiercoles.setWebtags( "" );
      chkavMiercoles.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavMiercoles.getInternalname(), "TitleCaption", chkavMiercoles.getCaption(), true);
      chkavMiercoles.setCheckedValue( "false" );
      AV45Miercoles = GXutil.strtobool( GXutil.booltostr( AV45Miercoles)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45Miercoles", AV45Miercoles);
      chkavJueves.setName( "vJUEVES" );
      chkavJueves.setWebtags( "" );
      chkavJueves.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavJueves.getInternalname(), "TitleCaption", chkavJueves.getCaption(), true);
      chkavJueves.setCheckedValue( "false" );
      AV40Jueves = GXutil.strtobool( GXutil.booltostr( AV40Jueves)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV40Jueves", AV40Jueves);
      chkavViernes.setName( "vVIERNES" );
      chkavViernes.setWebtags( "" );
      chkavViernes.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavViernes.getInternalname(), "TitleCaption", chkavViernes.getCaption(), true);
      chkavViernes.setCheckedValue( "false" );
      AV75Viernes = GXutil.strtobool( GXutil.booltostr( AV75Viernes)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV75Viernes", AV75Viernes);
      chkavSabado.setName( "vSABADO" );
      chkavSabado.setWebtags( "" );
      chkavSabado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavSabado.getInternalname(), "TitleCaption", chkavSabado.getCaption(), true);
      chkavSabado.setCheckedValue( "false" );
      AV61Sabado = GXutil.strtobool( GXutil.booltostr( AV61Sabado)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV61Sabado", AV61Sabado);
      chkavDomingo.setName( "vDOMINGO" );
      chkavDomingo.setWebtags( "" );
      chkavDomingo.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavDomingo.getInternalname(), "TitleCaption", chkavDomingo.getCaption(), true);
      chkavDomingo.setCheckedValue( "false" );
      AV23Domingo = GXutil.strtobool( GXutil.booltostr( AV23Domingo)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Domingo", AV23Domingo);
      radavFinaliza.setName( "vFINALIZA" );
      radavFinaliza.setWebtags( "" );
      radavFinaliza.addItem("EL", "El", (short)(0));
      radavFinaliza.addItem("DD", "Después de", (short)(0));
      /* End function init_web_controls */
   }

   public void validv_Profesionalid( )
   {
      AV51ProfesionalId = (int)(GXutil.lval( dynavProfesionalid.getValue())) ;
      AV21DisponibilidadHoraInicio = dynavDisponibilidadhorainicio.getValue() ;
      AV20DisponibilidadHoraFin = dynavDisponibilidadhorafin.getValue() ;
      AV26EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValue())) ;
      AV63SedeId = (short)(GXutil.lval( dynavSedeid.getValue())) ;
      AV81TipoCita = dynavTipocita.getValue() ;
      gxvvespecialidadid_html322( AV51ProfesionalId) ;
      gxvvsedeid_html322( AV26EspecialidadId, AV51ProfesionalId) ;
      gxvvtipocita_html322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
      dynload_actions( ) ;
      if ( dynavEspecialidadid.getItemCount() > 0 )
      {
         AV26EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValidValue(GXutil.trim( GXutil.str( AV26EspecialidadId, 4, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEspecialidadid.setValue( GXutil.trim( GXutil.str( AV26EspecialidadId, 4, 0)) );
      }
      if ( dynavSedeid.getItemCount() > 0 )
      {
         AV63SedeId = (short)(GXutil.lval( dynavSedeid.getValidValue(GXutil.trim( GXutil.str( AV63SedeId, 4, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedeid.setValue( GXutil.trim( GXutil.str( AV63SedeId, 4, 0)) );
      }
      if ( dynavTipocita.getItemCount() > 0 )
      {
         AV81TipoCita = dynavTipocita.getValidValue(AV81TipoCita) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV26EspecialidadId", GXutil.ltrim( localUtil.ntoc( AV26EspecialidadId, (byte)(4), (byte)(0), ".", "")));
      dynavEspecialidadid.setValue( GXutil.trim( GXutil.str( AV26EspecialidadId, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadid.getInternalname(), "Values", dynavEspecialidadid.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV63SedeId", GXutil.ltrim( localUtil.ntoc( AV63SedeId, (byte)(4), (byte)(0), ".", "")));
      dynavSedeid.setValue( GXutil.trim( GXutil.str( AV63SedeId, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavSedeid.getInternalname(), "Values", dynavSedeid.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV81TipoCita", GXutil.rtrim( AV81TipoCita));
      dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
      httpContext.ajax_rsp_assign_prop("", false, dynavTipocita.getInternalname(), "Values", dynavTipocita.ToJavascriptSource(), true);
   }

   public void validv_Especialidadid( )
   {
      AV51ProfesionalId = (int)(GXutil.lval( dynavProfesionalid.getValue())) ;
      AV21DisponibilidadHoraInicio = dynavDisponibilidadhorainicio.getValue() ;
      AV20DisponibilidadHoraFin = dynavDisponibilidadhorafin.getValue() ;
      AV26EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValue())) ;
      AV63SedeId = (short)(GXutil.lval( dynavSedeid.getValue())) ;
      AV81TipoCita = dynavTipocita.getValue() ;
      gxvvsedeid_html322( AV26EspecialidadId, AV51ProfesionalId) ;
      gxvvtipocita_html322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
      dynload_actions( ) ;
      if ( dynavSedeid.getItemCount() > 0 )
      {
         AV63SedeId = (short)(GXutil.lval( dynavSedeid.getValidValue(GXutil.trim( GXutil.str( AV63SedeId, 4, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavSedeid.setValue( GXutil.trim( GXutil.str( AV63SedeId, 4, 0)) );
      }
      if ( dynavTipocita.getItemCount() > 0 )
      {
         AV81TipoCita = dynavTipocita.getValidValue(AV81TipoCita) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV63SedeId", GXutil.ltrim( localUtil.ntoc( AV63SedeId, (byte)(4), (byte)(0), ".", "")));
      dynavSedeid.setValue( GXutil.trim( GXutil.str( AV63SedeId, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavSedeid.getInternalname(), "Values", dynavSedeid.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV81TipoCita", GXutil.rtrim( AV81TipoCita));
      dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
      httpContext.ajax_rsp_assign_prop("", false, dynavTipocita.getInternalname(), "Values", dynavTipocita.ToJavascriptSource(), true);
   }

   public void validv_Sedeid( )
   {
      AV51ProfesionalId = (int)(GXutil.lval( dynavProfesionalid.getValue())) ;
      AV21DisponibilidadHoraInicio = dynavDisponibilidadhorainicio.getValue() ;
      AV20DisponibilidadHoraFin = dynavDisponibilidadhorafin.getValue() ;
      AV26EspecialidadId = (short)(GXutil.lval( dynavEspecialidadid.getValue())) ;
      AV63SedeId = (short)(GXutil.lval( dynavSedeid.getValue())) ;
      AV81TipoCita = dynavTipocita.getValue() ;
      gxvvtipocita_html322( AV51ProfesionalId, AV26EspecialidadId, AV63SedeId) ;
      dynload_actions( ) ;
      if ( dynavTipocita.getItemCount() > 0 )
      {
         AV81TipoCita = dynavTipocita.getValidValue(AV81TipoCita) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV81TipoCita", GXutil.rtrim( AV81TipoCita));
      dynavTipocita.setValue( GXutil.rtrim( AV81TipoCita) );
      httpContext.ajax_rsp_assign_prop("", false, dynavTipocita.getInternalname(), "Values", dynavTipocita.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV14currentEvent',fld:'vCURRENTEVENT',pic:'',hsh:true},{av:'AV62SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV9CitaEmailGenLink',fld:'vCITAEMAILGENLINK',pic:'',hsh:true},{av:'AV39IsResult',fld:'vISRESULT',pic:'',hsh:true},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VPROFESIONALID.CONTROLVALUECHANGED","{handler:'e14322',iparms:[{av:'dynavProfesionalid'},{av:'AV51ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VPROFESIONALID.CONTROLVALUECHANGED",",oparms:[{av:'AV50ProfesionalFoto',fld:'vPROFESIONALFOTO',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("'CANCELAR'","{handler:'e15322',iparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("'CANCELAR'",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("'GUARDAR'","{handler:'e16322',iparms:[{av:'AV14currentEvent',fld:'vCURRENTEVENT',pic:'',hsh:true},{av:'AV19DisponibilidadFecha',fld:'vDISPONIBILIDADFECHA',pic:''},{av:'dynavProfesionalid'},{av:'AV51ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'dynavEspecialidadid'},{av:'AV26EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV63SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'AV49NroTraslapes',fld:'vNROTRASLAPES',pic:'ZZZ9'},{av:'AV18Disponibilidad',fld:'vDISPONIBILIDAD',pic:''},{av:'AV62SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true},{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'cmbavMinutosdecita'},{av:'AV46MinutosDeCita',fld:'vMINUTOSDECITA',pic:'ZZZ9'},{av:'AV57Repetir',fld:'vREPETIR',pic:''},{av:'AV28FechaInicio',fld:'vFECHAINICIO',pic:''},{av:'AV30FinalizaFecha',fld:'vFINALIZAFECHA',pic:''},{av:'cmbavSerepite'},{av:'AV65SeRepite',fld:'vSEREPITE',pic:'Z9'},{av:'AV31FinalizaNroVeces',fld:'vFINALIZANROVECES',pic:'ZZZ9'},{av:'cmbavRepitecada'},{av:'AV58RepiteCada',fld:'vREPITECADA',pic:'Z9'},{av:'AV55Qj',fld:'vQJ',pic:'ZZZ9'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("'GUARDAR'",",oparms:[{av:'AV18Disponibilidad',fld:'vDISPONIBILIDAD',pic:''},{av:'AV55Qj',fld:'vQJ',pic:'ZZZ9'},{av:'AV49NroTraslapes',fld:'vNROTRASLAPES',pic:'ZZZ9'},{av:'Dvmessage1_Defaultmessagetype',ctrl:'DVMESSAGE1',prop:'DefaultMessageType'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("'ELIMINAR'","{handler:'e17322',iparms:[{av:'AV18Disponibilidad',fld:'vDISPONIBILIDAD',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("'ELIMINAR'",",oparms:[{av:'AV18Disponibilidad',fld:'vDISPONIBILIDAD',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("'REGISTRAR INFORME MéDICO'","{handler:'e12321',iparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("'REGISTRAR INFORME MéDICO'",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("'REPETIR'","{handler:'e11321',iparms:[{av:'AV19DisponibilidadFecha',fld:'vDISPONIBILIDADFECHA',pic:''},{av:'AV57Repetir',fld:'vREPETIR',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("'REPETIR'",",oparms:[{av:'Dvmessage1_Defaultmessagetype',ctrl:'DVMESSAGE1',prop:'DefaultMessageType'},{av:'AV57Repetir',fld:'vREPETIR',pic:''},{av:'divTablerepetir_Visible',ctrl:'TABLEREPETIR',prop:'Visible'},{av:'divHn1_Visible',ctrl:'HN1',prop:'Visible'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("'AGREGARPACIENTE'","{handler:'e22322',iparms:[{av:'AV19DisponibilidadFecha',fld:'vDISPONIBILIDADFECHA',pic:''},{av:'AV14currentEvent',fld:'vCURRENTEVENT',pic:'',hsh:true},{av:'AV7Agregar',fld:'vAGREGAR',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("'AGREGARPACIENTE'",",oparms:[{av:'Dvmessage1_Defaultmessagetype',ctrl:'DVMESSAGE1',prop:'DefaultMessageType'},{av:'edtavTpacientenombrecompleto_Visible',ctrl:'vTPACIENTENOMBRECOMPLETO',prop:'Visible'},{ctrl:'GENERARCITA',prop:'Visible'},{av:'AV71tPacienteNombreCompleto',fld:'vTPACIENTENOMBRECOMPLETO',pic:''},{av:'AV72tPacienteNroDocumento',fld:'vTPACIENTENRODOCUMENTO',pic:''},{ctrl:'REPETIR',prop:'Visible'},{av:'AV7Agregar',fld:'vAGREGAR',pic:''},{av:'divTablepaciente_Visible',ctrl:'TABLEPACIENTE',prop:'Visible'},{av:'divHn1_Visible',ctrl:'HN1',prop:'Visible'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("GLOBALEVENTS.RETURN","{handler:'e18322',iparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("GLOBALEVENTS.RETURN",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VFIND.CLICK","{handler:'e19322',iparms:[{av:'AV76vPacienteId',fld:'vVPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV72tPacienteNroDocumento',fld:'vTPACIENTENRODOCUMENTO',pic:''},{av:'A106PacienteNroDocumento',fld:'PACIENTENRODOCUMENTO',pic:''},{av:'A103PacienteApellidoPaterno',fld:'PACIENTEAPELLIDOPATERNO',pic:''},{av:'A104PacienteApellidoMaterno',fld:'PACIENTEAPELLIDOMATERNO',pic:''},{av:'A105PacienteNombres',fld:'PACIENTENOMBRES',pic:''},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VFIND.CLICK",",oparms:[{av:'AV76vPacienteId',fld:'vVPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV71tPacienteNombreCompleto',fld:'vTPACIENTENOMBRECOMPLETO',pic:''},{av:'edtavTpacientenombrecompleto_Visible',ctrl:'vTPACIENTENOMBRECOMPLETO',prop:'Visible'},{ctrl:'GENERARCITA',prop:'Visible'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("'GENERAR CITA'","{handler:'e20322',iparms:[{av:'AV10CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'AV19DisponibilidadFecha',fld:'vDISPONIBILIDADFECHA',pic:''},{av:'dynavEspecialidadid'},{av:'AV26EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavProfesionalid'},{av:'AV51ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'dynavSedeid'},{av:'AV63SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'AV62SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true},{av:'AV76vPacienteId',fld:'vVPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV8Cita',fld:'vCITA',pic:''},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV59resjson',fld:'vRESJSON',pic:''},{av:'AV9CitaEmailGenLink',fld:'vCITAEMAILGENLINK',pic:'',hsh:true},{av:'AV39IsResult',fld:'vISRESULT',pic:'',hsh:true},{av:'AV14currentEvent',fld:'vCURRENTEVENT',pic:'',hsh:true},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'A66SGCitaDisponibilidadFecha',fld:'SGCITADISPONIBILIDADFECHA',pic:''},{av:'A70SGCitaDisponibilidadEspecialidadId',fld:'SGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("'GENERAR CITA'",",oparms:[{av:'AV18Disponibilidad',fld:'vDISPONIBILIDAD',pic:''},{av:'AV8Cita',fld:'vCITA',pic:''},{av:'AV59resjson',fld:'vRESJSON',pic:''},{av:'Dvmessage1_Defaultmessagetype',ctrl:'DVMESSAGE1',prop:'DefaultMessageType'},{av:'AV10CitaId',fld:'vCITAID',pic:'ZZZZZZZ9'},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VALIDV_PROFESIONALID","{handler:'validv_Profesionalid',iparms:[{av:'AV12ClinicaId',fld:'vCLINICAID',pic:'ZZZ9'},{av:'dynavProfesionalid'},{av:'AV51ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'dynavEspecialidadid'},{av:'AV26EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV63SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VALIDV_PROFESIONALID",",oparms:[{av:'dynavEspecialidadid'},{av:'AV26EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV63SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VALIDV_DISPONIBILIDADFECHA","{handler:'validv_Disponibilidadfecha',iparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VALIDV_DISPONIBILIDADFECHA",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VALIDV_ESPECIALIDADID","{handler:'validv_Especialidadid',iparms:[{av:'AV12ClinicaId',fld:'vCLINICAID',pic:'ZZZ9'},{av:'dynavProfesionalid'},{av:'AV51ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'dynavEspecialidadid'},{av:'AV26EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV63SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VALIDV_ESPECIALIDADID",",oparms:[{av:'dynavSedeid'},{av:'AV63SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VALIDV_SEDEID","{handler:'validv_Sedeid',iparms:[{av:'AV12ClinicaId',fld:'vCLINICAID',pic:'ZZZ9'},{av:'dynavProfesionalid'},{av:'AV51ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'dynavEspecialidadid'},{av:'AV26EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9'},{av:'dynavSedeid'},{av:'AV63SedeId',fld:'vSEDEID',pic:'ZZZ9'},{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VALIDV_SEDEID",",oparms:[{av:'dynavTipocita'},{av:'AV81TipoCita',fld:'vTIPOCITA',pic:''},{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VALIDV_TIPOCITA","{handler:'validv_Tipocita',iparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VALIDV_TIPOCITA",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VALIDV_FECHAINICIO","{handler:'validv_Fechainicio',iparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VALIDV_FECHAINICIO",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
      setEventMetadata("VALIDV_FINALIZAFECHA","{handler:'validv_Finalizafecha',iparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]");
      setEventMetadata("VALIDV_FINALIZAFECHA",",oparms:[{av:'dynavDisponibilidadhorainicio'},{av:'AV21DisponibilidadHoraInicio',fld:'vDISPONIBILIDADHORAINICIO',pic:''},{av:'dynavDisponibilidadhorafin'},{av:'AV20DisponibilidadHoraFin',fld:'vDISPONIBILIDADHORAFIN',pic:''},{av:'AV41Lunes',fld:'vLUNES',pic:''},{av:'AV42Martes',fld:'vMARTES',pic:''},{av:'AV45Miercoles',fld:'vMIERCOLES',pic:''},{av:'AV40Jueves',fld:'vJUEVES',pic:''},{av:'AV75Viernes',fld:'vVIERNES',pic:''},{av:'AV61Sabado',fld:'vSABADO',pic:''},{av:'AV23Domingo',fld:'vDOMINGO',pic:''},{av:'radavFinaliza'},{av:'AV29Finaliza',fld:'vFINALIZA',pic:''}]}");
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
      AV14currentEvent = new com.projectthani.SdtSchedulerEvents_event(remoteHandle, context);
      Gx_date = GXutil.nullDate() ;
      AV9CitaEmailGenLink = "" ;
      GXKey = "" ;
      AV18Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      A106PacienteNroDocumento = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      AV8Cita = new com.projectthani.SdtCita(remoteHandle);
      AV59resjson = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      AV36InformeCita = "" ;
      AV37InformeCita2 = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV38InformeCita3 = "" ;
      lblTextblock5_Jsonclick = "" ;
      lblTextblock1_Jsonclick = "" ;
      AV19DisponibilidadFecha = GXutil.nullDate() ;
      lblTextblock2_Jsonclick = "" ;
      AV21DisponibilidadHoraInicio = "" ;
      lblTextblock3_Jsonclick = "" ;
      AV20DisponibilidadHoraFin = "" ;
      lblTextblock4_Jsonclick = "" ;
      lblTextblock6_Jsonclick = "" ;
      lblTextblock9_Jsonclick = "" ;
      lblTextblock10_Jsonclick = "" ;
      AV81TipoCita = "" ;
      AV50ProfesionalFoto = "" ;
      A40002ProfesionalFoto_GXI = "" ;
      sImgUrl = "" ;
      bttRepetir_Jsonclick = "" ;
      bttAgregarpaciente_Jsonclick = "" ;
      AV72tPacienteNroDocumento = "" ;
      AV32find = "" ;
      AV89Find_GXI = "" ;
      AV71tPacienteNombreCompleto = "" ;
      bttGenerarcita_Jsonclick = "" ;
      AV28FechaInicio = GXutil.nullDate() ;
      lblTextblock7_Jsonclick = "" ;
      AV29Finaliza = "" ;
      AV30FinalizaFecha = GXutil.nullDate() ;
      lblTextblock8_Jsonclick = "" ;
      AV60Resumen = "" ;
      bttGuardar_Jsonclick = "" ;
      bttEliminar_Jsonclick = "" ;
      bttRegistrarinformemedico_Jsonclick = "" ;
      bttCancelar_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      ucChosengx1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      gxcolvPROFESIONALID = new GXBaseCollection<com.projectthani.SdtSDTProfesional>(com.projectthani.SdtSDTProfesional.class, "SDTProfesional", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTProfesional1 = new GXBaseCollection[1] ;
      gxcolvDISPONIBILIDADHORAINICIO = new GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem>(com.projectthani.SdtSDTHora_SDTHoraItem.class, "SDTHoraItem", "ProjectThani", remoteHandle);
      gxcolvDISPONIBILIDADHORAFIN = new GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem>(com.projectthani.SdtSDTHora_SDTHoraItem.class, "SDTHoraItem", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTHora_SDTHoraItem2 = new GXBaseCollection[1] ;
      gxcolvESPECIALIDADID = new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>(com.projectthani.SdtSDTEspecialidad.class, "SDTEspecialidad", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTEspecialidad3 = new GXBaseCollection[1] ;
      gxcolvSEDEID = new GXBaseCollection<com.projectthani.SdtSDTSede>(com.projectthani.SdtSDTSede.class, "SDTSede", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTSede4 = new GXBaseCollection[1] ;
      gxcolvTIPOCITA = new GXBaseCollection<com.projectthani.SdtSDTTipoConsulta>(com.projectthani.SdtSDTTipoConsulta.class, "SDTTipoConsulta", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTTipoConsulta5 = new GXBaseCollection[1] ;
      scmdbuf = "" ;
      AV82SecUserName = "" ;
      AV83SecUserEmail = "" ;
      H00323_A40000ProfesionalId = new int[1] ;
      H00323_n40000ProfesionalId = new boolean[] {false} ;
      H00325_A40001CitaId = new int[1] ;
      H00325_n40001CitaId = new boolean[] {false} ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext6 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      H00326_A6SecUserId = new short[1] ;
      H00326_A14SecUserName = new String[] {""} ;
      H00326_A122SecUserEmail = new String[] {""} ;
      A14SecUserName = "" ;
      A122SecUserEmail = "" ;
      H00327_A6SecUserId = new short[1] ;
      H00327_A4SecRoleId = new short[1] ;
      H00329_A40000ProfesionalId = new int[1] ;
      H00329_n40000ProfesionalId = new boolean[] {false} ;
      AV77websession = httpContext.getWebSession();
      AV70titulo = "" ;
      H003210_A133EventId = new String[] {""} ;
      H003210_A34DisponibilidadId = new int[1] ;
      A133EventId = "" ;
      H003212_A40001CitaId = new int[1] ;
      H003212_n40001CitaId = new boolean[] {false} ;
      AV34horaIni = "" ;
      AV33horaFin = "" ;
      GXv_int8 = new int[1] ;
      AV69TimeHoraInicio = "" ;
      AV68TimeHoraFin = "" ;
      AV15D = new GXBaseCollection<com.projectthani.SdtSDTDisponibilidad>(com.projectthani.SdtSDTDisponibilidad.class, "SDTDisponibilidad", "ProjectThani", remoteHandle);
      AV16Di = new com.projectthani.SdtSDTDisponibilidad(remoteHandle, context);
      AV25dtInicio = GXutil.resetTime( GXutil.nullDate() );
      AV24dtFin = GXutil.resetTime( GXutil.nullDate() );
      AV17Dias = new GXSimpleCollection<Boolean>(Boolean.class, "internal", "");
      H003213_A106PacienteNroDocumento = new String[] {""} ;
      H003213_A105PacienteNombres = new String[] {""} ;
      H003213_A104PacienteApellidoMaterno = new String[] {""} ;
      H003213_A103PacienteApellidoPaterno = new String[] {""} ;
      H003213_A20PacienteId = new int[1] ;
      GXt_dtime9 = GXutil.resetTime( GXutil.nullDate() );
      GXt_char10 = "" ;
      GXv_char7 = new String[1] ;
      AV47Mod = "" ;
      H003214_A21SGCitaDisponibilidadId = new int[1] ;
      H003214_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      H003214_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H003214_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H003214_A20PacienteId = new int[1] ;
      H003214_A19CitaId = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ZV81TipoCita = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.detallecalendario__default(),
         new Object[] {
             new Object[] {
            H00323_A40000ProfesionalId, H00323_n40000ProfesionalId
            }
            , new Object[] {
            H00325_A40001CitaId, H00325_n40001CitaId
            }
            , new Object[] {
            H00326_A6SecUserId, H00326_A14SecUserName, H00326_A122SecUserEmail
            }
            , new Object[] {
            H00327_A6SecUserId, H00327_A4SecRoleId
            }
            , new Object[] {
            H00329_A40000ProfesionalId, H00329_n40000ProfesionalId
            }
            , new Object[] {
            H003210_A133EventId, H003210_A34DisponibilidadId
            }
            , new Object[] {
            H003212_A40001CitaId, H003212_n40001CitaId
            }
            , new Object[] {
            H003213_A106PacienteNroDocumento, H003213_A105PacienteNombres, H003213_A104PacienteApellidoMaterno, H003213_A103PacienteApellidoPaterno, H003213_A20PacienteId
            }
            , new Object[] {
            H003214_A21SGCitaDisponibilidadId, H003214_A70SGCitaDisponibilidadEspecialidadId, H003214_A66SGCitaDisponibilidadFecha, H003214_n66SGCitaDisponibilidadFecha, H003214_A20PacienteId, H003214_A19CitaId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavInformecita_Enabled = 0 ;
      edtavInformecita2_Enabled = 0 ;
      edtavInformecita3_Enabled = 0 ;
      edtavResumen_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV65SeRepite ;
   private byte AV58RepiteCada ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV12ClinicaId ;
   private short AV26EspecialidadId ;
   private short AV63SedeId ;
   private short AV62SecUserId ;
   private short AV49NroTraslapes ;
   private short AV55Qj ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short wbEnd ;
   private short wbStart ;
   private short AV46MinutosDeCita ;
   private short AV31FinalizaNroVeces ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short AV5SecRoleId ;
   private short AV78x ;
   private short AV54Qi ;
   private short AV79y ;
   private short AV80z ;
   private short ZV26EspecialidadId ;
   private short ZV63SedeId ;
   private int AV51ProfesionalId ;
   private int AV76vPacienteId ;
   private int A20PacienteId ;
   private int AV10CitaId ;
   private int A19CitaId ;
   private int A40000ProfesionalId ;
   private int A40001CitaId ;
   private int divTable4_Visible ;
   private int edtavInformecita_Visible ;
   private int edtavInformecita_Enabled ;
   private int edtavInformecita2_Visible ;
   private int edtavInformecita2_Enabled ;
   private int edtavInformecita3_Visible ;
   private int edtavInformecita3_Enabled ;
   private int edtavDisponibilidadfecha_Enabled ;
   private int bttRepetir_Visible ;
   private int bttAgregarpaciente_Visible ;
   private int divHn1_Visible ;
   private int divTablepaciente_Visible ;
   private int edtavTpacientenrodocumento_Enabled ;
   private int edtavTpacientenombrecompleto_Visible ;
   private int edtavTpacientenombrecompleto_Enabled ;
   private int bttGenerarcita_Visible ;
   private int divTablerepetir_Visible ;
   private int edtavFechainicio_Enabled ;
   private int divTablesemana_Visible ;
   private int edtavFinalizafecha_Visible ;
   private int edtavFinalizafecha_Enabled ;
   private int divTable1_Visible ;
   private int edtavFinalizanroveces_Enabled ;
   private int edtavResumen_Visible ;
   private int edtavResumen_Enabled ;
   private int bttGuardar_Visible ;
   private int bttGuardar_Enabled ;
   private int bttEliminar_Enabled ;
   private int bttRegistrarinformemedico_Visible ;
   private int gxdynajaxindex ;
   private int AV22DisponibilidadId ;
   private int AV67TiempoDeCita ;
   private int A34DisponibilidadId ;
   private int GXv_int8[] ;
   private int AV74vDisponbilidadId2 ;
   private int AV48NroSegundos ;
   private int AV64SegundosSobrantes ;
   private int AV90GXV1 ;
   private int AV11CitaId2 ;
   private int A21SGCitaDisponibilidadId ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Dvmessage1_Defaultmessagetype ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable4_Internalname ;
   private String edtavInformecita_Internalname ;
   private String TempTags ;
   private String edtavInformecita_Jsonclick ;
   private String edtavInformecita2_Internalname ;
   private String edtavInformecita2_Jsonclick ;
   private String edtavInformecita3_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTable2_Internalname ;
   private String divTable3_Internalname ;
   private String lblTextblock5_Internalname ;
   private String lblTextblock5_Jsonclick ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String edtavDisponibilidadfecha_Internalname ;
   private String edtavDisponibilidadfecha_Jsonclick ;
   private String lblTextblock2_Internalname ;
   private String lblTextblock2_Jsonclick ;
   private String lblTextblock3_Internalname ;
   private String lblTextblock3_Jsonclick ;
   private String lblTextblock4_Internalname ;
   private String lblTextblock4_Jsonclick ;
   private String lblTextblock6_Internalname ;
   private String lblTextblock6_Jsonclick ;
   private String lblTextblock9_Internalname ;
   private String lblTextblock9_Jsonclick ;
   private String lblTextblock10_Internalname ;
   private String lblTextblock10_Jsonclick ;
   private String AV81TipoCita ;
   private String sImgUrl ;
   private String imgavProfesionalfoto_Internalname ;
   private String bttRepetir_Internalname ;
   private String bttRepetir_Jsonclick ;
   private String bttAgregarpaciente_Internalname ;
   private String bttAgregarpaciente_Jsonclick ;
   private String divHn1_Internalname ;
   private String divTablepaciente_Internalname ;
   private String edtavTpacientenrodocumento_Internalname ;
   private String edtavTpacientenrodocumento_Jsonclick ;
   private String imgavFind_Internalname ;
   private String imgavFind_Jsonclick ;
   private String edtavTpacientenombrecompleto_Internalname ;
   private String bttGenerarcita_Internalname ;
   private String bttGenerarcita_Jsonclick ;
   private String divTablerepetir_Internalname ;
   private String edtavFechainicio_Internalname ;
   private String edtavFechainicio_Jsonclick ;
   private String divTablesemana_Internalname ;
   private String lblTextblock7_Internalname ;
   private String lblTextblock7_Jsonclick ;
   private String edtavFinalizafecha_Internalname ;
   private String edtavFinalizafecha_Jsonclick ;
   private String divTable1_Internalname ;
   private String edtavFinalizanroveces_Internalname ;
   private String edtavFinalizanroveces_Jsonclick ;
   private String lblTextblock8_Internalname ;
   private String lblTextblock8_Jsonclick ;
   private String edtavResumen_Internalname ;
   private String bttGuardar_Internalname ;
   private String bttGuardar_Caption ;
   private String bttGuardar_Jsonclick ;
   private String bttEliminar_Internalname ;
   private String bttEliminar_Jsonclick ;
   private String bttRegistrarinformemedico_Internalname ;
   private String bttRegistrarinformemedico_Jsonclick ;
   private String bttCancelar_Internalname ;
   private String bttCancelar_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String Chosengx1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String A133EventId ;
   private String GXt_char10 ;
   private String GXv_char7[] ;
   private String AV47Mod ;
   private String ZV81TipoCita ;
   private java.util.Date AV25dtInicio ;
   private java.util.Date AV24dtFin ;
   private java.util.Date GXt_dtime9 ;
   private java.util.Date Gx_date ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV19DisponibilidadFecha ;
   private java.util.Date AV28FechaInicio ;
   private java.util.Date AV30FinalizaFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV39IsResult ;
   private boolean AV57Repetir ;
   private boolean AV7Agregar ;
   private boolean wbLoad ;
   private boolean AV50ProfesionalFoto_IsBlob ;
   private boolean AV32find_IsBlob ;
   private boolean AV41Lunes ;
   private boolean AV42Martes ;
   private boolean AV45Miercoles ;
   private boolean AV40Jueves ;
   private boolean AV75Viernes ;
   private boolean AV61Sabado ;
   private boolean AV23Domingo ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000ProfesionalId ;
   private boolean n40001CitaId ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private String AV9CitaEmailGenLink ;
   private String A106PacienteNroDocumento ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String AV59resjson ;
   private String AV36InformeCita ;
   private String AV37InformeCita2 ;
   private String AV38InformeCita3 ;
   private String AV21DisponibilidadHoraInicio ;
   private String AV20DisponibilidadHoraFin ;
   private String A40002ProfesionalFoto_GXI ;
   private String AV72tPacienteNroDocumento ;
   private String AV89Find_GXI ;
   private String AV71tPacienteNombreCompleto ;
   private String AV29Finaliza ;
   private String AV60Resumen ;
   private String AV82SecUserName ;
   private String AV83SecUserEmail ;
   private String A14SecUserName ;
   private String A122SecUserEmail ;
   private String AV70titulo ;
   private String AV34horaIni ;
   private String AV33horaFin ;
   private String AV69TimeHoraInicio ;
   private String AV68TimeHoraFin ;
   private String AV50ProfesionalFoto ;
   private String AV32find ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV77websession ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.webpanels.GXUserControl ucChosengx1 ;
   private GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem> gxcolvDISPONIBILIDADHORAINICIO ;
   private GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem> gxcolvDISPONIBILIDADHORAFIN ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesional> gxcolvPROFESIONALID ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> gxcolvESPECIALIDADID ;
   private GXBaseCollection<com.projectthani.SdtSDTSede> gxcolvSEDEID ;
   private GXBaseCollection<com.projectthani.SdtSDTTipoConsulta> gxcolvTIPOCITA ;
   private HTMLChoice dynavProfesionalid ;
   private HTMLChoice dynavDisponibilidadhorainicio ;
   private HTMLChoice dynavDisponibilidadhorafin ;
   private HTMLChoice dynavEspecialidadid ;
   private HTMLChoice dynavSedeid ;
   private HTMLChoice cmbavMinutosdecita ;
   private HTMLChoice dynavTipocita ;
   private HTMLChoice cmbavSerepite ;
   private HTMLChoice cmbavRepitecada ;
   private ICheckbox chkavLunes ;
   private ICheckbox chkavMartes ;
   private ICheckbox chkavMiercoles ;
   private ICheckbox chkavJueves ;
   private ICheckbox chkavViernes ;
   private ICheckbox chkavSabado ;
   private ICheckbox chkavDomingo ;
   private HTMLChoice radavFinaliza ;
   private IDataStoreProvider pr_default ;
   private int[] H00323_A40000ProfesionalId ;
   private boolean[] H00323_n40000ProfesionalId ;
   private int[] H00325_A40001CitaId ;
   private boolean[] H00325_n40001CitaId ;
   private short[] H00326_A6SecUserId ;
   private String[] H00326_A14SecUserName ;
   private String[] H00326_A122SecUserEmail ;
   private short[] H00327_A6SecUserId ;
   private short[] H00327_A4SecRoleId ;
   private int[] H00329_A40000ProfesionalId ;
   private boolean[] H00329_n40000ProfesionalId ;
   private String[] H003210_A133EventId ;
   private int[] H003210_A34DisponibilidadId ;
   private int[] H003212_A40001CitaId ;
   private boolean[] H003212_n40001CitaId ;
   private String[] H003213_A106PacienteNroDocumento ;
   private String[] H003213_A105PacienteNombres ;
   private String[] H003213_A104PacienteApellidoMaterno ;
   private String[] H003213_A103PacienteApellidoPaterno ;
   private int[] H003213_A20PacienteId ;
   private int[] H003214_A21SGCitaDisponibilidadId ;
   private short[] H003214_A70SGCitaDisponibilidadEspecialidadId ;
   private java.util.Date[] H003214_A66SGCitaDisponibilidadFecha ;
   private boolean[] H003214_n66SGCitaDisponibilidadFecha ;
   private int[] H003214_A20PacienteId ;
   private int[] H003214_A19CitaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<Boolean> AV17Dias ;
   private GXBaseCollection<com.projectthani.SdtSDTDisponibilidad> AV15D ;
   private GXBaseCollection<com.projectthani.SdtSDTHora_SDTHoraItem> GXv_objcol_SdtSDTHora_SDTHoraItem2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesional> GXv_objcol_SdtSDTProfesional1[] ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> GXv_objcol_SdtSDTEspecialidad3[] ;
   private GXBaseCollection<com.projectthani.SdtSDTSede> GXv_objcol_SdtSDTSede4[] ;
   private GXBaseCollection<com.projectthani.SdtSDTTipoConsulta> GXv_objcol_SdtSDTTipoConsulta5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext6[] ;
   private com.projectthani.SdtCita AV8Cita ;
   private com.projectthani.SdtSchedulerEvents_event AV14currentEvent ;
   private com.projectthani.SdtSDTDisponibilidad AV16Di ;
   private com.projectthani.SdtDisponibilidad AV18Disponibilidad ;
}

final  class detallecalendario__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00323", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = ? or [ProfesionalCorreo] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00325", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [Cita] WHERE [SGCitaDisponibilidadId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00326", "SELECT [SecUserId], [SecUserName], [SecUserEmail] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00327", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00329", "SELECT COALESCE( T1.[ProfesionalId], 0) AS ProfesionalId FROM (SELECT MIN([ProfesionalId]) AS ProfesionalId FROM [Profesional] WHERE [ProfesionalNroDocumento] = ? or [ProfesionalCorreo] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H003210", "SELECT TOP 1 [EventId], [DisponibilidadId] FROM [Disponibilidad] WHERE [EventId] = RTRIM(LTRIM(?)) ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H003212", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [Cita] WHERE [SGCitaDisponibilidadId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H003213", "SELECT [PacienteNroDocumento], [PacienteNombres], [PacienteApellidoMaterno], [PacienteApellidoPaterno], [PacienteId] FROM [Paciente] WHERE [PacienteNroDocumento] = RTRIM(LTRIM(?)) ORDER BY [PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H003214", "SELECT T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T2.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T2.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[PacienteId], T1.[CitaId] FROM ([Cita] T1 INNER JOIN [Disponibilidad] T2 ON T2.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) WHERE (T1.[PacienteId] = ?) AND (T2.[DisponibilidadFecha] = ?) AND (T2.[EspecialidadId] = ?) ORDER BY T1.[PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
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
               stmt.setVarchar(1, (String)parms[0], 100);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 100);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 15);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

