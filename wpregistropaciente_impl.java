package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpregistropaciente_impl extends GXDataArea
{
   public wpregistropaciente_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpregistropaciente_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpregistropaciente_impl.class ));
   }

   public wpregistropaciente_impl( int remoteHandle ,
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
      cmbavPacientetipodocumento = new HTMLChoice();
      cmbavPacientesexo = new HTMLChoice();
      cmbavMes = new HTMLChoice();
      cmbavDia = new HTMLChoice();
      cmbavAnio = new HTMLChoice();
      dynavPacientenacionalidad = new HTMLChoice();
      cmbavPacientedepartamento = new HTMLChoice();
      dynavPacienteprovincia = new HTMLChoice();
      dynavPacientedistrito = new HTMLChoice();
      cmbavPacientecomoseentero = new HTMLChoice();
      chkavPacienteterminoscondiciones = UIFactory.getCheckbox(this);
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPACIENTENACIONALIDAD") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvpacientenacionalidad4P2( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPACIENTEPROVINCIA") == 0 )
         {
            AV22PacienteDepartamento = httpContext.GetPar( "PacienteDepartamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22PacienteDepartamento", AV22PacienteDepartamento);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvpacienteprovincia4P2( AV22PacienteDepartamento) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPACIENTEDISTRITO") == 0 )
         {
            AV22PacienteDepartamento = httpContext.GetPar( "PacienteDepartamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22PacienteDepartamento", AV22PacienteDepartamento);
            AV32PacienteProvincia = httpContext.GetPar( "PacienteProvincia") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32PacienteProvincia", AV32PacienteProvincia);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvpacientedistrito4P2( AV22PacienteDepartamento, AV32PacienteProvincia) ;
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
      pa4P2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start4P2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110335368", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoRegPaciente\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoRegPaciente\" data-gx-class=\"form-horizontal FormFondoRegPaciente\" novalidate action=\""+formatLink("com.projectthani.wpregistropaciente", new String[] {}, new String[] {}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormFondoRegPaciente", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAISID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5PaisId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38Pattern, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPAISID", GXutil.ltrim( localUtil.ntoc( AV5PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAISID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5PaisId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPATTERN", AV38Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38Pattern, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMENSAJE", AV13Mensaje);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMENSAJE", AV13Mensaje);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSER", AV42SecUser);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSER", AV42SecUser);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSERROLE", AV43SecUserRole);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSERROLE", AV43SecUserRole);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECROLENAME", A13SecRoleName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECROLEID", GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPACIENTE", AV18Paciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPACIENTE", AV18Paciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEID", GXutil.ltrim( localUtil.ntoc( A40000PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERID", GXutil.ltrim( localUtil.ntoc( A40001SecUserId, (byte)(4), (byte)(0), ",", "")));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormFondoRegPaciente" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we4P2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt4P2( ) ;
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
      return formatLink("com.projectthani.wpregistropaciente", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPRegistroPaciente" ;
   }

   public String getPgmdesc( )
   {
      return "Registro Paciente" ;
   }

   public void wb4P0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintableregistropaciente_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "SubMainTableRegistroPaciente", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableRegistrarPacienteCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableRegistroPaciente1", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Static images/pictures */
         ClassString = "Image" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "62fabb4b-713d-4bd3-9f52-cde8b0a8f851", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgImage1_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitleinfosolicitada_Internalname, "A continuación, por favor ingrese la información solicitada.", "", "", lblTitleinfosolicitada_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableregistro_Internalname, 1, 0, "px", 0, "px", "TableRegistrarMain", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableRegistrarPacienteCell2", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable6_Internalname, 1, 0, "px", 0, "px", "TableRegistroPaciente2", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupinfogeneral_Internalname, "INFORMACIÓN GENERAL", 1, 0, "px", 0, "px", "GroupRegistroPaciente", "", "HLP_WPRegistroPaciente.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientetipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientetipodocumento.getInternalname(), "Tipo Documento", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientetipodocumento, cmbavPacientetipodocumento.getInternalname(), GXutil.rtrim( AV36PacienteTipoDocumento), 1, cmbavPacientetipodocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPacientetipodocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         cmbavPacientetipodocumento.setValue( GXutil.rtrim( AV36PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientetipodocumento.getInternalname(), "Values", cmbavPacientetipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientenrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientenrodocumento_Internalname, " Nro. Documento", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientenrodocumento_Internalname, AV30PacienteNroDocumento, GXutil.rtrim( localUtil.format( AV30PacienteNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientenrodocumento_Jsonclick, 0, "AttRegistroPaciente", "", "", "", "", 1, edtavPacientenrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientenombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientenombres_Internalname, "Nombres", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientenombres_Internalname, AV29PacienteNombres, GXutil.rtrim( localUtil.format( AV29PacienteNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientenombres_Jsonclick, 0, "AttRegistroPaciente", "", "", "", "", 1, edtavPacientenombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacienteapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacienteapellidopaterno_Internalname, "Apellido Paterno", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacienteapellidopaterno_Internalname, AV20PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( AV20PacienteApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacienteapellidopaterno_Jsonclick, 0, "AttRegistroPaciente", "", "", "", "", 1, edtavPacienteapellidopaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacienteapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacienteapellidomaterno_Internalname, "Apellido Materno", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacienteapellidomaterno_Internalname, AV19PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( AV19PacienteApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacienteapellidomaterno_Jsonclick, 0, "AttRegistroPaciente", "", "", "", "", 1, edtavPacienteapellidomaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientesexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientesexo.getInternalname(), "Sexo", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientesexo, cmbavPacientesexo.getInternalname(), GXutil.rtrim( AV33PacienteSexo), 1, cmbavPacientesexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPacientesexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,51);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         cmbavPacientesexo.setValue( GXutil.rtrim( AV33PacienteSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientesexo.getInternalname(), "Values", cmbavPacientesexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupfechanacimiento_Internalname, "Fecha de nacimiento", 1, 0, "px", 0, "px", "GroupFechaNaciento", "", "HLP_WPRegistroPaciente.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "TableFechaNac", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-lg-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavMes.getInternalname(), "Mes", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMes, cmbavMes.getInternalname(), GXutil.rtrim( AV15Mes), 1, cmbavMes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         cmbavMes.setValue( GXutil.rtrim( AV15Mes) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-lg-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavDia.getInternalname(), "Dia", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDia, cmbavDia.getInternalname(), GXutil.trim( GXutil.str( AV8Dia, 4, 0)), 1, cmbavDia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV8Dia, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavAnio.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavAnio.getInternalname(), "Año", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavAnio, cmbavAnio.getInternalname(), GXutil.trim( GXutil.str( AV7Anio, 4, 0)), 1, cmbavAnio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavAnio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         cmbavAnio.setValue( GXutil.trim( GXutil.str( AV7Anio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAnio.getInternalname(), "Values", cmbavAnio.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientetelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientetelefono_Internalname, "Teléfono", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientetelefono_Internalname, GXutil.rtrim( AV34PacienteTelefono), GXutil.rtrim( localUtil.format( AV34PacienteTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientetelefono_Jsonclick, 0, "AttRegistroPaciente", "", "", "", "", 1, edtavPacientetelefono_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "", "left", true, "", "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPacientenacionalidad.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPacientenacionalidad.getInternalname(), "Nacionalidad", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPacientenacionalidad, dynavPacientenacionalidad.getInternalname(), GXutil.trim( GXutil.str( AV28PacienteNacionalidad, 4, 0)), 1, dynavPacientenacionalidad.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavPacientenacionalidad.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,76);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         dynavPacientenacionalidad.setValue( GXutil.trim( GXutil.str( AV28PacienteNacionalidad, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPacientenacionalidad.getInternalname(), "Values", dynavPacientenacionalidad.ToJavascriptSource(), true);
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
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupubicacionresidencia_Internalname, "UBICACIÓN DE RESIDENCIA", 1, 0, "px", 0, "px", "GroupRegistroPaciente", "", "HLP_WPRegistroPaciente.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientedireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientedireccion_Internalname, "Dirección", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         ClassString = "AttRegistroPaciente" ;
         StyleString = "" ;
         ClassString = "AttRegistroPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavPacientedireccion_Internalname, AV23PacienteDireccion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", (short)(0), 1, edtavPacientedireccion_Enabled, 0, 80, "chr", 7, "row", StyleString, ClassString, "", "", "500", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientedepartamento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientedepartamento.getInternalname(), "Departamento", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientedepartamento, cmbavPacientedepartamento.getInternalname(), GXutil.rtrim( AV22PacienteDepartamento), 1, cmbavPacientedepartamento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavPacientedepartamento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         cmbavPacientedepartamento.setValue( GXutil.rtrim( AV22PacienteDepartamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientedepartamento.getInternalname(), "Values", cmbavPacientedepartamento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPacienteprovincia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPacienteprovincia.getInternalname(), "Provincia", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPacienteprovincia, dynavPacienteprovincia.getInternalname(), GXutil.rtrim( AV32PacienteProvincia), 1, dynavPacienteprovincia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavPacienteprovincia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPacienteprovincia.getInternalname(), "Values", dynavPacienteprovincia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPacientedistrito.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPacientedistrito.getInternalname(), "Distrito", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPacientedistrito, dynavPacientedistrito.getInternalname(), GXutil.rtrim( AV24PacienteDistrito), 1, dynavPacientedistrito.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavPacientedistrito.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         dynavPacientedistrito.setValue( GXutil.rtrim( AV24PacienteDistrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupinfadicional_Internalname, "INFORMACIÓN ADICIONAL", 1, 0, "px", 0, "px", "GroupRegistroPaciente", "", "HLP_WPRegistroPaciente.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup5table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientecomoseentero.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientecomoseentero.getInternalname(), "¿Como se enteró de Thani?", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientecomoseentero, cmbavPacientecomoseentero.getInternalname(), GXutil.rtrim( AV21PacienteComoSeEntero), 1, cmbavPacientecomoseentero.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavPacientecomoseentero.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttRegistroPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "", true, (byte)(1), "HLP_WPRegistroPaciente.htm");
         cmbavPacientecomoseentero.setValue( GXutil.rtrim( AV21PacienteComoSeEntero) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientecomoseentero.getInternalname(), "Values", cmbavPacientecomoseentero.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavEspesifique_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavEspesifique_Internalname, "Si seleccionó otros especifique", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
         ClassString = "AttRegistroPaciente" ;
         StyleString = "" ;
         ClassString = "AttRegistroPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavEspesifique_Internalname, AV49Espesifique, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", (short)(0), 1, edtavEspesifique_Enabled, 0, 80, "chr", 5, "row", StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupinfodelacuenta_Internalname, "INFORMACIÓN DE LA CUENTA", 1, 0, "px", 0, "px", "GroupRegistroPaciente", "", "HLP_WPRegistroPaciente.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup4table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacienteemail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacienteemail_Internalname, "Correo", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacienteemail_Internalname, AV25PacienteEmail, GXutil.rtrim( localUtil.format( AV25PacienteEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,120);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+AV25PacienteEmail, "", "", "", edtavPacienteemail_Jsonclick, 0, "AttRegistroPaciente", "", "", "", "", 1, edtavPacienteemail_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientepassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientepassword_Internalname, "Contraseña", "col-xs-12 AttRegistroPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientepassword_Internalname, AV31PacientePassword, GXutil.rtrim( localUtil.format( AV31PacientePassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,125);\""+" "+"data-gx-password-reveal"+" "+"idenableshowpasswordhint=\"True\""+" ", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientepassword_Jsonclick, 0, "AttRegistroPaciente", "", "", "", "", 1, edtavPacientepassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WPRegistroPaciente.htm");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "TableTC", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-md-2 txbCheckTC", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavPacienteterminoscondiciones.getInternalname(), "Paciente Terminos Condiciones", "col-sm-3 AttributeLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 132,'',false,'',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavPacienteterminoscondiciones.getInternalname(), GXutil.booltostr( AV35PacienteTerminosCondiciones), "", "Paciente Terminos Condiciones", 1, chkavPacienteterminoscondiciones.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(132, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,132);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-md-10 txbCheckTCD", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTxbaceptotc_Internalname, lblTxbaceptotc_Caption, "", "", lblTxbaceptotc_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRegistroPaciente.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Right", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'',false,'',0)\"" ;
         ClassString = "BtnRegistrarPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnguardarpaciente_Internalname, "", "Registrar", bttBtnguardarpaciente_Jsonclick, 5, "Registrar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'BTNGUARDARPACIENTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 142,'',false,'',0)\"" ;
         ClassString = "BtnRegistrarPaciente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelarpaciente_Internalname, "", "Cancelar", bttBtncancelarpaciente_Jsonclick, 5, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'BTNCANCELARPACIENTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistroPaciente.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start4P2( )
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
         Form.getMeta().addItem("description", "Registro Paciente", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup4P0( ) ;
   }

   public void ws4P2( )
   {
      start4P2( ) ;
      evt4P2( ) ;
   }

   public void evt4P2( )
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
                           e114P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VANIO.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e124P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VMES.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e134P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'BTNGUARDARPACIENTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'btnGuardarPaciente' */
                           e144P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'BTNCANCELARPACIENTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'btnCancelarPaciente' */
                           e154P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VPACIENTENRODOCUMENTO.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e164P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e174P2 ();
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

   public void we4P2( )
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

   public void pa4P2( )
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
            GX_FocusControl = cmbavPacientetipodocumento.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvpacientedistrito_html4P2( AV22PacienteDepartamento, AV32PacienteProvincia) ;
      /* End function dynload_actions */
   }

   public void gxdlvvpacientenacionalidad4P2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpacientenacionalidad_data4P2( ) ;
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

   public void gxvvpacientenacionalidad_html4P2( )
   {
      short gxdynajaxvalue;
      gxdlvvpacientenacionalidad_data4P2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPacientenacionalidad.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavPacientenacionalidad.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpacientenacionalidad_data4P2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H004P2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H004P2_A43PaisId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H004P2_A184PaisDescripcion[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvpacienteprovincia4P2( String AV22PacienteDepartamento )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpacienteprovincia_data4P2( AV22PacienteDepartamento) ;
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

   public void gxvvpacienteprovincia_html4P2( String AV22PacienteDepartamento )
   {
      String gxdynajaxvalue;
      gxdlvvpacienteprovincia_data4P2( AV22PacienteDepartamento) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPacienteprovincia.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavPacienteprovincia.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpacienteprovincia_data4P2( String AV22PacienteDepartamento )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H004P3 */
      pr_default.execute(1, new Object[] {AV22PacienteDepartamento});
      while ( (pr_default.getStatus(1) != 101) )
      {
         if ( GXutil.strcmp(H004P3_A295UbigeoDepartamentoCode[0], AV22PacienteDepartamento) == 0 )
         {
            gxdynajaxctrlcodr.add(H004P3_A296UbigeoProvinciaCode[0]);
            gxdynajaxctrldescr.add(H004P3_A187UbigeoProvincia[0]);
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvvpacientedistrito4P2( String AV22PacienteDepartamento ,
                                          String AV32PacienteProvincia )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpacientedistrito_data4P2( AV22PacienteDepartamento, AV32PacienteProvincia) ;
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

   public void gxvvpacientedistrito_html4P2( String AV22PacienteDepartamento ,
                                             String AV32PacienteProvincia )
   {
      String gxdynajaxvalue;
      gxdlvvpacientedistrito_data4P2( AV22PacienteDepartamento, AV32PacienteProvincia) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPacientedistrito.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavPacientedistrito.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpacientedistrito_data4P2( String AV22PacienteDepartamento ,
                                                  String AV32PacienteProvincia )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H004P4 */
      pr_default.execute(2, new Object[] {AV22PacienteDepartamento, AV32PacienteProvincia});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(H004P4_A297UbigeoDistritoCode[0]);
         gxdynajaxctrldescr.add(H004P4_A188UbigeoDistrito[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvpacientenacionalidad_html4P2( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavPacientetipodocumento.getItemCount() > 0 )
      {
         AV36PacienteTipoDocumento = cmbavPacientetipodocumento.getValidValue(AV36PacienteTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36PacienteTipoDocumento", AV36PacienteTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientetipodocumento.setValue( GXutil.rtrim( AV36PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientetipodocumento.getInternalname(), "Values", cmbavPacientetipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavPacientesexo.getItemCount() > 0 )
      {
         AV33PacienteSexo = cmbavPacientesexo.getValidValue(AV33PacienteSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33PacienteSexo", AV33PacienteSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientesexo.setValue( GXutil.rtrim( AV33PacienteSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientesexo.getInternalname(), "Values", cmbavPacientesexo.ToJavascriptSource(), true);
      }
      if ( cmbavMes.getItemCount() > 0 )
      {
         AV15Mes = cmbavMes.getValidValue(AV15Mes) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Mes", AV15Mes);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMes.setValue( GXutil.rtrim( AV15Mes) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
      }
      if ( cmbavDia.getItemCount() > 0 )
      {
         AV8Dia = (short)(GXutil.lval( cmbavDia.getValidValue(GXutil.trim( GXutil.str( AV8Dia, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV8Dia, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
      }
      if ( cmbavAnio.getItemCount() > 0 )
      {
         AV7Anio = (short)(GXutil.lval( cmbavAnio.getValidValue(GXutil.trim( GXutil.str( AV7Anio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Anio), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavAnio.setValue( GXutil.trim( GXutil.str( AV7Anio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAnio.getInternalname(), "Values", cmbavAnio.ToJavascriptSource(), true);
      }
      if ( dynavPacientenacionalidad.getItemCount() > 0 )
      {
         AV28PacienteNacionalidad = (short)(GXutil.lval( dynavPacientenacionalidad.getValidValue(GXutil.trim( GXutil.str( AV28PacienteNacionalidad, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PacienteNacionalidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28PacienteNacionalidad), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientenacionalidad.setValue( GXutil.trim( GXutil.str( AV28PacienteNacionalidad, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPacientenacionalidad.getInternalname(), "Values", dynavPacientenacionalidad.ToJavascriptSource(), true);
      }
      if ( cmbavPacientedepartamento.getItemCount() > 0 )
      {
         AV22PacienteDepartamento = cmbavPacientedepartamento.getValidValue(AV22PacienteDepartamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22PacienteDepartamento", AV22PacienteDepartamento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientedepartamento.setValue( GXutil.rtrim( AV22PacienteDepartamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientedepartamento.getInternalname(), "Values", cmbavPacientedepartamento.ToJavascriptSource(), true);
      }
      if ( dynavPacienteprovincia.getItemCount() > 0 )
      {
         AV32PacienteProvincia = dynavPacienteprovincia.getValidValue(AV32PacienteProvincia) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32PacienteProvincia", AV32PacienteProvincia);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPacienteprovincia.getInternalname(), "Values", dynavPacienteprovincia.ToJavascriptSource(), true);
      }
      if ( dynavPacientedistrito.getItemCount() > 0 )
      {
         AV24PacienteDistrito = dynavPacientedistrito.getValidValue(AV24PacienteDistrito) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PacienteDistrito", AV24PacienteDistrito);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientedistrito.setValue( GXutil.rtrim( AV24PacienteDistrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
      }
      if ( cmbavPacientecomoseentero.getItemCount() > 0 )
      {
         AV21PacienteComoSeEntero = cmbavPacientecomoseentero.getValidValue(AV21PacienteComoSeEntero) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21PacienteComoSeEntero", AV21PacienteComoSeEntero);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientecomoseentero.setValue( GXutil.rtrim( AV21PacienteComoSeEntero) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientecomoseentero.getInternalname(), "Values", cmbavPacientecomoseentero.ToJavascriptSource(), true);
      }
      AV35PacienteTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV35PacienteTerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35PacienteTerminosCondiciones", AV35PacienteTerminosCondiciones);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf4P2( ) ;
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

   public void rf4P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e174P2 ();
         wb4P0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4P2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPAISID", GXutil.ltrim( localUtil.ntoc( AV5PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAISID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV5PaisId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPATTERN", AV38Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38Pattern, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      gxvvpacientenacionalidad_html4P2( ) ;
      /* Using cursor H004P6 */
      pr_default.execute(3, new Object[] {AV30PacienteNroDocumento, AV25PacienteEmail});
      if ( (pr_default.getStatus(3) != 101) )
      {
         A40000PacienteId = H004P6_A40000PacienteId[0] ;
         n40000PacienteId = H004P6_n40000PacienteId[0] ;
      }
      else
      {
         A40000PacienteId = 0 ;
         n40000PacienteId = false ;
      }
      pr_default.close(3);
      /* Using cursor H004P8 */
      pr_default.execute(4, new Object[] {AV30PacienteNroDocumento, AV25PacienteEmail});
      if ( (pr_default.getStatus(4) != 101) )
      {
         A40001SecUserId = H004P8_A40001SecUserId[0] ;
         n40001SecUserId = H004P8_n40001SecUserId[0] ;
      }
      else
      {
         A40001SecUserId = (short)(0) ;
         n40001SecUserId = false ;
      }
      pr_default.close(4);
      fix_multi_value_controls( ) ;
   }

   public void strup4P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e114P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvpacienteprovincia_html4P2( AV22PacienteDepartamento) ;
      gxvvpacientedistrito_html4P2( AV22PacienteDepartamento, AV32PacienteProvincia) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         cmbavPacientetipodocumento.setValue( httpContext.cgiGet( cmbavPacientetipodocumento.getInternalname()) );
         AV36PacienteTipoDocumento = httpContext.cgiGet( cmbavPacientetipodocumento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36PacienteTipoDocumento", AV36PacienteTipoDocumento);
         AV30PacienteNroDocumento = httpContext.cgiGet( edtavPacientenrodocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30PacienteNroDocumento", AV30PacienteNroDocumento);
         AV29PacienteNombres = httpContext.cgiGet( edtavPacientenombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29PacienteNombres", AV29PacienteNombres);
         AV20PacienteApellidoPaterno = httpContext.cgiGet( edtavPacienteapellidopaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20PacienteApellidoPaterno", AV20PacienteApellidoPaterno);
         AV19PacienteApellidoMaterno = httpContext.cgiGet( edtavPacienteapellidomaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19PacienteApellidoMaterno", AV19PacienteApellidoMaterno);
         cmbavPacientesexo.setValue( httpContext.cgiGet( cmbavPacientesexo.getInternalname()) );
         AV33PacienteSexo = httpContext.cgiGet( cmbavPacientesexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33PacienteSexo", AV33PacienteSexo);
         cmbavMes.setValue( httpContext.cgiGet( cmbavMes.getInternalname()) );
         AV15Mes = httpContext.cgiGet( cmbavMes.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Mes", AV15Mes);
         cmbavDia.setValue( httpContext.cgiGet( cmbavDia.getInternalname()) );
         AV8Dia = (short)(GXutil.lval( httpContext.cgiGet( cmbavDia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 4, 0));
         cmbavAnio.setValue( httpContext.cgiGet( cmbavAnio.getInternalname()) );
         AV7Anio = (short)(GXutil.lval( httpContext.cgiGet( cmbavAnio.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Anio), 4, 0));
         AV34PacienteTelefono = httpContext.cgiGet( edtavPacientetelefono_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34PacienteTelefono", AV34PacienteTelefono);
         dynavPacientenacionalidad.setValue( httpContext.cgiGet( dynavPacientenacionalidad.getInternalname()) );
         AV28PacienteNacionalidad = (short)(GXutil.lval( httpContext.cgiGet( dynavPacientenacionalidad.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28PacienteNacionalidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28PacienteNacionalidad), 4, 0));
         AV23PacienteDireccion = httpContext.cgiGet( edtavPacientedireccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23PacienteDireccion", AV23PacienteDireccion);
         cmbavPacientedepartamento.setValue( httpContext.cgiGet( cmbavPacientedepartamento.getInternalname()) );
         AV22PacienteDepartamento = httpContext.cgiGet( cmbavPacientedepartamento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22PacienteDepartamento", AV22PacienteDepartamento);
         dynavPacienteprovincia.setValue( httpContext.cgiGet( dynavPacienteprovincia.getInternalname()) );
         AV32PacienteProvincia = httpContext.cgiGet( dynavPacienteprovincia.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32PacienteProvincia", AV32PacienteProvincia);
         dynavPacientedistrito.setValue( httpContext.cgiGet( dynavPacientedistrito.getInternalname()) );
         AV24PacienteDistrito = httpContext.cgiGet( dynavPacientedistrito.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PacienteDistrito", AV24PacienteDistrito);
         cmbavPacientecomoseentero.setValue( httpContext.cgiGet( cmbavPacientecomoseentero.getInternalname()) );
         AV21PacienteComoSeEntero = httpContext.cgiGet( cmbavPacientecomoseentero.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21PacienteComoSeEntero", AV21PacienteComoSeEntero);
         AV49Espesifique = httpContext.cgiGet( edtavEspesifique_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49Espesifique", AV49Espesifique);
         AV25PacienteEmail = httpContext.cgiGet( edtavPacienteemail_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25PacienteEmail", AV25PacienteEmail);
         AV31PacientePassword = httpContext.cgiGet( edtavPacientepassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV31PacientePassword", AV31PacientePassword);
         AV35PacienteTerminosCondiciones = GXutil.strtobool( httpContext.cgiGet( chkavPacienteterminoscondiciones.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV35PacienteTerminosCondiciones", AV35PacienteTerminosCondiciones);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvvpacientenacionalidad_html4P2( ) ;
         gxvvpacienteprovincia_html4P2( AV22PacienteDepartamento) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e114P2 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e114P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/RegistroPaciente.css\" type=\"text/css\">" );
      Form.getJscriptsrc().add("sweetalert2.all.min.js") ;
      Form.getJscriptsrc().add("SweetAlert2.js") ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/bootstrap-4.min.css\" type=\"text/css\">" );
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" href=\"./static/sweetalert2.min.css\" type=\"text/css\">" );
      /* Execute user subroutine: 'TERMINOSCODICIONES' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         returnInSub = true;
         if (true) return;
      }
      AV28PacienteNacionalidad = (short)(28) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28PacienteNacionalidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28PacienteNacionalidad), 4, 0));
      AV12i = (short)(GXutil.year( GXutil.addyr( Gx_date, (short)(-18)))) ;
      cmbavAnio.removeAllItems();
      while ( AV12i > GXutil.year( GXutil.addyr( Gx_date, (short)(-18))) - 92 )
      {
         cmbavAnio.addItem(GXutil.trim( GXutil.str( AV12i, 4, 0)), GXutil.str( AV12i, 10, 0), (short)(0));
         AV12i = (short)(AV12i-1) ;
      }
      /* Execute user subroutine: 'SHOWDAYS' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         returnInSub = true;
         if (true) return;
      }
      AV38Pattern = "^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pattern", AV38Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPATTERN", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV38Pattern, ""))));
      AV35PacienteTerminosCondiciones = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35PacienteTerminosCondiciones", AV35PacienteTerminosCondiciones);
      /* Using cursor H004P9 */
      pr_default.execute(5);
      while ( (pr_default.getStatus(5) != 101) )
      {
         A186UbigeoDepartamento = H004P9_A186UbigeoDepartamento[0] ;
         A295UbigeoDepartamentoCode = H004P9_A295UbigeoDepartamentoCode[0] ;
         A44UbigeoCode = H004P9_A44UbigeoCode[0] ;
         cmbavPacientedepartamento.addItem(A295UbigeoDepartamentoCode, A186UbigeoDepartamento, (short)(0));
         pr_default.readNext(5);
      }
      pr_default.close(5);
   }

   public void e124P2( )
   {
      /* Anio_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SHOWDAYS' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         returnInSub = true;
         if (true) return;
      }
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV8Dia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void e134P2( )
   {
      /* Mes_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SHOWDAYS' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         returnInSub = true;
         if (true) return;
      }
      AV8Dia = (short)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 4, 0));
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV8Dia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void S122( )
   {
      /* 'SHOWDAYS' Routine */
      returnInSub = false ;
      AV45TempFechaNac = localUtil.ymdtod( AV7Anio, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV15Mes, "."))), 1) ;
      AV12i = (short)(1) ;
      cmbavDia.removeAllItems();
      while ( AV12i <= GXutil.day( GXutil.eomdate( AV45TempFechaNac)) )
      {
         cmbavDia.addItem(GXutil.trim( GXutil.str( AV12i, 4, 0)), GXutil.str( AV12i, 10, 0), (short)(0));
         AV12i = (short)(AV12i+1) ;
      }
   }

   public void e144P2( )
   {
      /* 'btnGuardarPaciente' Routine */
      returnInSub = false ;
      /* Using cursor H004P11 */
      pr_default.execute(6, new Object[] {AV30PacienteNroDocumento, AV25PacienteEmail});
      if ( (pr_default.getStatus(6) != 101) )
      {
         A40000PacienteId = H004P11_A40000PacienteId[0] ;
         n40000PacienteId = H004P11_n40000PacienteId[0] ;
      }
      else
      {
         A40000PacienteId = 0 ;
         n40000PacienteId = false ;
      }
      pr_default.close(6);
      /* Using cursor H004P13 */
      pr_default.execute(7, new Object[] {AV30PacienteNroDocumento, AV25PacienteEmail});
      if ( (pr_default.getStatus(7) != 101) )
      {
         A40001SecUserId = H004P13_A40001SecUserId[0] ;
         n40001SecUserId = H004P13_n40001SecUserId[0] ;
      }
      else
      {
         A40001SecUserId = (short)(0) ;
         n40001SecUserId = false ;
      }
      pr_default.close(7);
      AV47UbigeoCode = AV22PacienteDepartamento + AV32PacienteProvincia + AV24PacienteDistrito ;
      AV26PacienteFechaNacimiento = localUtil.ymdtod( AV7Anio, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV15Mes, "."))), AV8Dia) ;
      AV13Mensaje.clear();
      if ( ( GXutil.strSearch( AV29PacienteNombres, "1", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "2", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "3", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "4", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "5", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "6", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "7", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "8", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "9", 1) > 0 ) || ( GXutil.strSearch( AV29PacienteNombres, "0", 1) > 0 ) )
      {
         AV13Mensaje.add("El Nombre contiene números", 0);
      }
      else
      {
         if ( ( GXutil.strSearch( AV20PacienteApellidoPaterno, "1", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "2", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "3", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "4", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "5", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "6", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "7", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "8", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "9", 1) > 0 ) || ( GXutil.strSearch( AV20PacienteApellidoPaterno, "0", 1) > 0 ) )
         {
            AV13Mensaje.add("El Apellido Paterno contiene números", 0);
         }
         else
         {
            if ( ( GXutil.strSearch( AV19PacienteApellidoMaterno, "1", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "2", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "3", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "4", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "5", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "6", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "7", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "8", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "9", 1) > 0 ) || ( GXutil.strSearch( AV19PacienteApellidoMaterno, "0", 1) > 0 ) )
            {
               AV13Mensaje.add("El Apellido Materno contiene números", 0);
            }
            else
            {
               if ( ( GXutil.strcmp(GXutil.trim( AV20PacienteApellidoPaterno), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV19PacienteApellidoMaterno), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV25PacienteEmail), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV29PacienteNombres), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV30PacienteNroDocumento), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV36PacienteTipoDocumento), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV33PacienteSexo), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV34PacienteTelefono), "") == 0 ) )
               {
                  AV13Mensaje.add("Todos los datos son obligatorios", 0);
               }
               else
               {
                  if ( GXutil.strcmp(AV36PacienteTipoDocumento, "1") == 0 )
                  {
                     if ( GXutil.len( GXutil.trim( AV30PacienteNroDocumento)) != 8 )
                     {
                        AV13Mensaje.add("Ingrese un Número de DNI correcto", 0);
                     }
                     if ( CommonUtil.decimalVal( GXutil.trim( AV30PacienteNroDocumento), ".").doubleValue() == 0 )
                     {
                        AV13Mensaje.add("El Número de DNI ingresado no es correcto", 0);
                     }
                  }
                  else
                  {
                     if ( GXutil.len( GXutil.trim( AV30PacienteNroDocumento)) < 8 )
                     {
                        AV13Mensaje.add("Ingrese un Número de Documento correcto", 0);
                     }
                  }
                  if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV26PacienteFechaNacimiento)) )
                  {
                     AV13Mensaje.add("Debe Seleccionar su fecha de nacimiento", 0);
                  }
                  GXt_dtime1 = GXutil.resetTime( AV26PacienteFechaNacimiento );
                  if ( GXutil.age( GXt_dtime1, GXutil.now( )) < 18 )
                  {
                     AV13Mensaje.add("Debe ser mayor de 18 años", 0);
                  }
                  if ( (GXutil.strcmp("", AV21PacienteComoSeEntero)==0) )
                  {
                     AV13Mensaje.add("Debe seleccionar el cómo se enteró de Thani.", 0);
                  }
                  if ( (GXutil.strcmp("", AV31PacientePassword)==0) )
                  {
                     AV13Mensaje.add("Debe ingresar su contraseña", 0);
                  }
                  if ( (GXutil.strcmp("", AV22PacienteDepartamento)==0) )
                  {
                     AV13Mensaje.add("Debe seleccionar un pais del listado", 0);
                  }
                  if ( ( GXutil.len( AV47UbigeoCode) != 6 ) && ( AV5PaisId == 28 ) )
                  {
                     AV13Mensaje.add("Debe seleccionar un distrito del listado", 0);
                  }
                  if ( ! GxRegex.IsMatch(AV25PacienteEmail,AV38Pattern) )
                  {
                     AV13Mensaje.add("Debe ingresar un correo electrónico válido", 0);
                  }
                  if ( ! AV35PacienteTerminosCondiciones )
                  {
                     AV13Mensaje.add("Debe aceptar los términos y condiciones", 0);
                  }
                  if ( ( A40000PacienteId > 0 ) && ( GXutil.strcmp(GXutil.trim( AV30PacienteNroDocumento), "") != 0 ) )
                  {
                     AV13Mensaje.add("Ya existe un usuario con los datos ingresados. Por favor inicie sesión", 0);
                  }
                  else
                  {
                     if ( ( A40001SecUserId > 0 ) && ( GXutil.strcmp(GXutil.trim( AV30PacienteNroDocumento), "") != 0 ) )
                     {
                        AV13Mensaje.add("Ya existe un usuario con los datos ingresados. Por favor inicie sesión", 0);
                     }
                  }
               }
            }
         }
      }
      if ( AV13Mensaje.size() > 0 )
      {
         /* Execute user subroutine: 'SHOWMESSAGES' */
         S132 ();
         if ( returnInSub )
         {
            pr_default.close(7);
            pr_default.close(6);
            returnInSub = true;
            if (true) return;
         }
      }
      else
      {
         /* Execute user subroutine: 'GUARDARPACIENTE' */
         S142 ();
         if ( returnInSub )
         {
            pr_default.close(7);
            pr_default.close(6);
            returnInSub = true;
            if (true) return;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV13Mensaje", AV13Mensaje);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV42SecUser", AV42SecUser);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV43SecUserRole", AV43SecUserRole);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18Paciente", AV18Paciente);
   }

   public void S142( )
   {
      /* 'GUARDARPACIENTE' Routine */
      returnInSub = false ;
      AV47UbigeoCode = AV22PacienteDepartamento + AV32PacienteProvincia + AV24PacienteDistrito ;
      AV26PacienteFechaNacimiento = localUtil.ymdtod( AV7Anio, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV15Mes, "."))), AV8Dia) ;
      AV42SecUser.setgxTv_SdtSecUser_Secusername( GXutil.trim( AV30PacienteNroDocumento) );
      AV42SecUser.setgxTv_SdtSecUser_Secuseremail( GXutil.trim( AV25PacienteEmail) );
      AV42SecUser.setgxTv_SdtSecUser_Secuserpassword( GXutil.trim( AV31PacientePassword) );
      AV42SecUser.Save();
      if ( AV42SecUser.Success() )
      {
         AV43SecUserRole.setgxTv_SdtSecUserRole_Secuserid( AV42SecUser.getgxTv_SdtSecUser_Secuserid() );
         /* Using cursor H004P14 */
         pr_default.execute(8);
         while ( (pr_default.getStatus(8) != 101) )
         {
            A13SecRoleName = H004P14_A13SecRoleName[0] ;
            A4SecRoleId = H004P14_A4SecRoleId[0] ;
            AV43SecUserRole.setgxTv_SdtSecUserRole_Secroleid( A4SecRoleId );
            pr_default.readNext(8);
         }
         pr_default.close(8);
         AV43SecUserRole.Save();
         AV18Paciente.setgxTv_SdtPaciente_Pacientenombres( AV29PacienteNombres );
         AV18Paciente.setgxTv_SdtPaciente_Pacienteapellidopaterno( AV20PacienteApellidoPaterno );
         AV18Paciente.setgxTv_SdtPaciente_Pacienteapellidomaterno( AV19PacienteApellidoMaterno );
         AV18Paciente.setgxTv_SdtPaciente_Pacientetipodocumento( AV36PacienteTipoDocumento );
         AV18Paciente.setgxTv_SdtPaciente_Pacientenrodocumento( GXutil.trim( AV30PacienteNroDocumento) );
         AV18Paciente.setgxTv_SdtPaciente_Pacientefechanacimiento( AV26PacienteFechaNacimiento );
         AV18Paciente.setgxTv_SdtPaciente_Pacientesexo( AV33PacienteSexo );
         AV18Paciente.setgxTv_SdtPaciente_Pacientecorreo( AV25PacienteEmail );
         AV18Paciente.setgxTv_SdtPaciente_Pacientedireccion( AV23PacienteDireccion );
         AV18Paciente.setgxTv_SdtPaciente_Pacienteenterarse( AV21PacienteComoSeEntero );
         AV18Paciente.setgxTv_SdtPaciente_Pacientetelefono( AV34PacienteTelefono );
         AV18Paciente.setgxTv_SdtPaciente_Paisid( AV28PacienteNacionalidad );
         AV18Paciente.setgxTv_SdtPaciente_Pacienteestado( "P" );
         AV18Paciente.setgxTv_SdtPaciente_Secuserid( AV42SecUser.getgxTv_SdtSecUser_Secuserid() );
         AV18Paciente.setgxTv_SdtPaciente_Ubigeocode( AV47UbigeoCode );
         AV18Paciente.setgxTv_SdtPaciente_Pacientepeso( DecimalUtil.doubleToDec(0) );
         AV18Paciente.setgxTv_SdtPaciente_Pacienteestatura( DecimalUtil.doubleToDec(0) );
         AV18Paciente.setgxTv_SdtPaciente_Pacienteespecifique( AV49Espesifique );
         AV18Paciente.Save();
         if ( AV18Paciente.Success() )
         {
            AV6WebSession.destroy();
            AV6WebSession.setValue("ValidateAccount", "Y");
            AV6WebSession.setValue("ValidateEmail", AV18Paciente.getgxTv_SdtPaciente_Pacientecorreo());
            Application.commitDataStores(context, remoteHandle, pr_default, "wpregistropaciente");
            new com.projectthani.prcactivarcuentapaciente(remoteHandle, context).execute( AV18Paciente.getgxTv_SdtPaciente_Pacienteid()) ;
            AV17MsgSuccss = "Para finalizar el registro se le envió un correo de confirmación a la siguiente dirección:<b> " + AV18Paciente.getgxTv_SdtPaciente_Pacientecorreo() + "</b>, en caso de no visualizar dicho correo en su bandeja de entrada, verificar la bandeja de correos no deseados o Spam." ;
            this.executeExternalObjectMethod("", false, "AV44SweetAlert", "Alert", new Object[] {"success","Sus datos se registraron correctamente.",AV17MsgSuccss,""}, false);
            callWebObject(formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "wpregistropaciente");
            httpContext.GX_msglist.addItem("Ocurrió un error, por favor intente nuevamente 1");
         }
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wpregistropaciente");
         httpContext.GX_msglist.addItem("Ocurrió un error, por favor intente nuevamente 2");
      }
   }

   public void e154P2( )
   {
      /* 'btnCancelarPaciente' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      returnInSub = true;
      if (true) return;
   }

   public void S132( )
   {
      /* 'SHOWMESSAGES' Routine */
      returnInSub = false ;
      AV46textoMensaj = "" ;
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV13Mensaje.size() )
      {
         AV14Mensajei = (String)AV13Mensaje.elementAt(-1+AV55GXV1) ;
         AV46textoMensaj += "&#10060; " + AV14Mensajei + GXutil.newLine( ) ;
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
      httpContext.GX_msglist.addItem(AV46textoMensaj);
   }

   public void e164P2( )
   {
      /* Pacientenrodocumento_Controlvaluechanged Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV36PacienteTipoDocumento, "1") == 0 )
      {
         AV40SDTResponseDni = (com.projectthani.SdtSDTResponseDni)new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
         GXv_int2[0] = AV11httpstatus ;
         GXv_char3[0] = AV39result ;
         new com.projectthani.consultareniec(remoteHandle, context).execute( AV30PacienteNroDocumento, GXv_int2, GXv_char3, "Content-Type", "application/json") ;
         wpregistropaciente_impl.this.AV11httpstatus = (short)((short)(GXv_int2[0])) ;
         wpregistropaciente_impl.this.AV39result = GXv_char3[0] ;
         AV41SDTResponseWSDni.fromJSonString(AV39result, null);
         AV40SDTResponseDni = AV41SDTResponseWSDni.getgxTv_SdtSDTResponseWSDni_Data();
         if ( ! (GXutil.strcmp("", AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_materno())==0) )
         {
            AV19PacienteApellidoMaterno = AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_materno() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19PacienteApellidoMaterno", AV19PacienteApellidoMaterno);
         }
         if ( ! (GXutil.strcmp("", AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_paterno())==0) )
         {
            AV20PacienteApellidoPaterno = AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_paterno() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20PacienteApellidoPaterno", AV20PacienteApellidoPaterno);
         }
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento())) )
         {
            AV8Dia = (short)(GXutil.day( AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 4, 0));
            AV7Anio = (short)(GXutil.year( AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Anio), 4, 0));
            AV16MesTemporal = "" ;
            if ( GXutil.month( AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento()) < 10 )
            {
               AV16MesTemporal = "0" ;
            }
            AV16MesTemporal += GXutil.trim( GXutil.str( GXutil.month( AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento()), 10, 0)) ;
            AV15Mes = AV16MesTemporal ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15Mes", AV15Mes);
            /* Execute user subroutine: 'SHOWDAYS' */
            S122 ();
            if ( returnInSub )
            {
               pr_default.close(7);
               pr_default.close(6);
               returnInSub = true;
               if (true) return;
            }
         }
         if ( ! (GXutil.strcmp("", AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Nombres())==0) )
         {
            AV29PacienteNombres = AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Nombres() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29PacienteNombres", AV29PacienteNombres);
         }
         if ( ! (GXutil.strcmp("", AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo())==0) )
         {
            if ( GXutil.strcmp(GXutil.charAt( AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo(), 1), "M") == 0 )
            {
               AV33PacienteSexo = "M" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV33PacienteSexo", AV33PacienteSexo);
            }
            if ( GXutil.strcmp(GXutil.charAt( AV40SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo(), 1), "F") == 0 )
            {
               AV33PacienteSexo = "F" ;
               httpContext.ajax_rsp_assign_attri("", false, "AV33PacienteSexo", AV33PacienteSexo);
            }
         }
      }
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV8Dia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
      cmbavAnio.setValue( GXutil.trim( GXutil.str( AV7Anio, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavAnio.getInternalname(), "Values", cmbavAnio.ToJavascriptSource(), true);
      cmbavMes.setValue( GXutil.rtrim( AV15Mes) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
      cmbavPacientesexo.setValue( GXutil.rtrim( AV33PacienteSexo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPacientesexo.getInternalname(), "Values", cmbavPacientesexo.ToJavascriptSource(), true);
   }

   public void S112( )
   {
      /* 'TERMINOSCODICIONES' Routine */
      returnInSub = false ;
      AV10HtmlTerminosCondiciones += "<span style=\"font-family: Poppins, sans-serif;\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10HtmlTerminosCondiciones", AV10HtmlTerminosCondiciones);
      AV10HtmlTerminosCondiciones += "Acepto el tratamiento de mis datos personales para" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10HtmlTerminosCondiciones", AV10HtmlTerminosCondiciones);
      AV10HtmlTerminosCondiciones += "los servicios de Teleorientación Médica y " ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10HtmlTerminosCondiciones", AV10HtmlTerminosCondiciones);
      AV10HtmlTerminosCondiciones += "Telemonitoreo. " ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10HtmlTerminosCondiciones", AV10HtmlTerminosCondiciones);
      AV10HtmlTerminosCondiciones += "<a href=\"" + formatLink("com.projectthani.terminoscondicionesuser", new String[] {}, new String[] {})  + "\" target=\"_blank\">" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10HtmlTerminosCondiciones", AV10HtmlTerminosCondiciones);
      AV10HtmlTerminosCondiciones += "Términos y Condiciones </a></span>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10HtmlTerminosCondiciones", AV10HtmlTerminosCondiciones);
      lblTxbaceptotc_Caption = AV10HtmlTerminosCondiciones ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxbaceptotc_Internalname, "Caption", lblTxbaceptotc_Caption, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e174P2( )
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
      pa4P2( ) ;
      ws4P2( ) ;
      we4P2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110335552", true, true);
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
      httpContext.AddJavascriptSource("wpregistropaciente.js", "?20225110335553", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgImage1_Internalname = "IMAGE1" ;
      lblTitleinfosolicitada_Internalname = "TITLEINFOSOLICITADA" ;
      divTable3_Internalname = "TABLE3" ;
      cmbavPacientetipodocumento.setInternalname( "vPACIENTETIPODOCUMENTO" );
      edtavPacientenrodocumento_Internalname = "vPACIENTENRODOCUMENTO" ;
      edtavPacientenombres_Internalname = "vPACIENTENOMBRES" ;
      edtavPacienteapellidopaterno_Internalname = "vPACIENTEAPELLIDOPATERNO" ;
      edtavPacienteapellidomaterno_Internalname = "vPACIENTEAPELLIDOMATERNO" ;
      cmbavPacientesexo.setInternalname( "vPACIENTESEXO" );
      cmbavMes.setInternalname( "vMES" );
      cmbavDia.setInternalname( "vDIA" );
      cmbavAnio.setInternalname( "vANIO" );
      divGroup1table_Internalname = "GROUP1TABLE" ;
      grpGroupfechanacimiento_Internalname = "GROUPFECHANACIMIENTO" ;
      edtavPacientetelefono_Internalname = "vPACIENTETELEFONO" ;
      dynavPacientenacionalidad.setInternalname( "vPACIENTENACIONALIDAD" );
      divGroup2table_Internalname = "GROUP2TABLE" ;
      grpGroupinfogeneral_Internalname = "GROUPINFOGENERAL" ;
      edtavPacientedireccion_Internalname = "vPACIENTEDIRECCION" ;
      cmbavPacientedepartamento.setInternalname( "vPACIENTEDEPARTAMENTO" );
      dynavPacienteprovincia.setInternalname( "vPACIENTEPROVINCIA" );
      dynavPacientedistrito.setInternalname( "vPACIENTEDISTRITO" );
      divGroup1table1_Internalname = "GROUP1TABLE1" ;
      grpGroupubicacionresidencia_Internalname = "GROUPUBICACIONRESIDENCIA" ;
      cmbavPacientecomoseentero.setInternalname( "vPACIENTECOMOSEENTERO" );
      edtavEspesifique_Internalname = "vESPESIFIQUE" ;
      divGroup5table_Internalname = "GROUP5TABLE" ;
      grpGroupinfadicional_Internalname = "GROUPINFADICIONAL" ;
      edtavPacienteemail_Internalname = "vPACIENTEEMAIL" ;
      edtavPacientepassword_Internalname = "vPACIENTEPASSWORD" ;
      divGroup4table_Internalname = "GROUP4TABLE" ;
      grpGroupinfodelacuenta_Internalname = "GROUPINFODELACUENTA" ;
      chkavPacienteterminoscondiciones.setInternalname( "vPACIENTETERMINOSCONDICIONES" );
      lblTxbaceptotc_Internalname = "TXBACEPTOTC" ;
      divTable1_Internalname = "TABLE1" ;
      bttBtnguardarpaciente_Internalname = "BTNGUARDARPACIENTE" ;
      bttBtncancelarpaciente_Internalname = "BTNCANCELARPACIENTE" ;
      divTable5_Internalname = "TABLE5" ;
      divTable6_Internalname = "TABLE6" ;
      divTableregistro_Internalname = "TABLEREGISTRO" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      divTable2_Internalname = "TABLE2" ;
      divMaintableregistropaciente_Internalname = "MAINTABLEREGISTROPACIENTE" ;
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
      lblTxbaceptotc_Caption = "Textblock" ;
      chkavPacienteterminoscondiciones.setEnabled( 1 );
      edtavPacientepassword_Jsonclick = "" ;
      edtavPacientepassword_Enabled = 1 ;
      edtavPacienteemail_Jsonclick = "" ;
      edtavPacienteemail_Enabled = 1 ;
      edtavEspesifique_Enabled = 1 ;
      cmbavPacientecomoseentero.setJsonclick( "" );
      cmbavPacientecomoseentero.setEnabled( 1 );
      dynavPacientedistrito.setJsonclick( "" );
      dynavPacientedistrito.setEnabled( 1 );
      dynavPacienteprovincia.setJsonclick( "" );
      dynavPacienteprovincia.setEnabled( 1 );
      cmbavPacientedepartamento.setJsonclick( "" );
      cmbavPacientedepartamento.setEnabled( 1 );
      edtavPacientedireccion_Enabled = 1 ;
      dynavPacientenacionalidad.setJsonclick( "" );
      dynavPacientenacionalidad.setEnabled( 1 );
      edtavPacientetelefono_Jsonclick = "" ;
      edtavPacientetelefono_Enabled = 1 ;
      cmbavAnio.setJsonclick( "" );
      cmbavAnio.setEnabled( 1 );
      cmbavDia.setJsonclick( "" );
      cmbavDia.setEnabled( 1 );
      cmbavMes.setJsonclick( "" );
      cmbavMes.setEnabled( 1 );
      cmbavPacientesexo.setJsonclick( "" );
      cmbavPacientesexo.setEnabled( 1 );
      edtavPacienteapellidomaterno_Jsonclick = "" ;
      edtavPacienteapellidomaterno_Enabled = 1 ;
      edtavPacienteapellidopaterno_Jsonclick = "" ;
      edtavPacienteapellidopaterno_Enabled = 1 ;
      edtavPacientenombres_Jsonclick = "" ;
      edtavPacientenombres_Enabled = 1 ;
      edtavPacientenrodocumento_Jsonclick = "" ;
      edtavPacientenrodocumento_Enabled = 1 ;
      cmbavPacientetipodocumento.setJsonclick( "" );
      cmbavPacientetipodocumento.setEnabled( 1 );
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Registro Paciente" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavPacientetipodocumento.setName( "vPACIENTETIPODOCUMENTO" );
      cmbavPacientetipodocumento.setWebtags( "" );
      cmbavPacientetipodocumento.addItem("", "Seleccione", (short)(0));
      cmbavPacientetipodocumento.addItem("1", "DNI", (short)(0));
      cmbavPacientetipodocumento.addItem("6", "RUC", (short)(0));
      cmbavPacientetipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavPacientetipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavPacientetipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavPacientetipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavPacientetipodocumento.getItemCount() > 0 )
      {
         AV36PacienteTipoDocumento = cmbavPacientetipodocumento.getValidValue(AV36PacienteTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36PacienteTipoDocumento", AV36PacienteTipoDocumento);
      }
      cmbavPacientesexo.setName( "vPACIENTESEXO" );
      cmbavPacientesexo.setWebtags( "" );
      cmbavPacientesexo.addItem("", "Seleccione", (short)(0));
      cmbavPacientesexo.addItem("M", "Masculino", (short)(0));
      cmbavPacientesexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavPacientesexo.getItemCount() > 0 )
      {
         AV33PacienteSexo = cmbavPacientesexo.getValidValue(AV33PacienteSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33PacienteSexo", AV33PacienteSexo);
      }
      cmbavMes.setName( "vMES" );
      cmbavMes.setWebtags( "" );
      cmbavMes.addItem("01", "Enero", (short)(0));
      cmbavMes.addItem("02", "Febrero", (short)(0));
      cmbavMes.addItem("03", "Marzo", (short)(0));
      cmbavMes.addItem("04", "Abril", (short)(0));
      cmbavMes.addItem("05", "Mayo", (short)(0));
      cmbavMes.addItem("06", "Junio", (short)(0));
      cmbavMes.addItem("07", "Julio", (short)(0));
      cmbavMes.addItem("08", "Agosto", (short)(0));
      cmbavMes.addItem("09", "Septiembre", (short)(0));
      cmbavMes.addItem("10", "Octubre", (short)(0));
      cmbavMes.addItem("11", "Noviembre", (short)(0));
      cmbavMes.addItem("12", "Diciembre", (short)(0));
      if ( cmbavMes.getItemCount() > 0 )
      {
         AV15Mes = cmbavMes.getValidValue(AV15Mes) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Mes", AV15Mes);
      }
      cmbavDia.setName( "vDIA" );
      cmbavDia.setWebtags( "" );
      if ( cmbavDia.getItemCount() > 0 )
      {
         AV8Dia = (short)(GXutil.lval( cmbavDia.getValidValue(GXutil.trim( GXutil.str( AV8Dia, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 4, 0));
      }
      cmbavAnio.setName( "vANIO" );
      cmbavAnio.setWebtags( "" );
      if ( cmbavAnio.getItemCount() > 0 )
      {
         AV7Anio = (short)(GXutil.lval( cmbavAnio.getValidValue(GXutil.trim( GXutil.str( AV7Anio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Anio), 4, 0));
      }
      dynavPacientenacionalidad.setName( "vPACIENTENACIONALIDAD" );
      dynavPacientenacionalidad.setWebtags( "" );
      cmbavPacientedepartamento.setName( "vPACIENTEDEPARTAMENTO" );
      cmbavPacientedepartamento.setWebtags( "" );
      cmbavPacientedepartamento.addItem("", "Seleccione", (short)(0));
      if ( cmbavPacientedepartamento.getItemCount() > 0 )
      {
         AV22PacienteDepartamento = cmbavPacientedepartamento.getValidValue(AV22PacienteDepartamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22PacienteDepartamento", AV22PacienteDepartamento);
      }
      dynavPacienteprovincia.setName( "vPACIENTEPROVINCIA" );
      dynavPacienteprovincia.setWebtags( "" );
      dynavPacientedistrito.setName( "vPACIENTEDISTRITO" );
      dynavPacientedistrito.setWebtags( "" );
      cmbavPacientecomoseentero.setName( "vPACIENTECOMOSEENTERO" );
      cmbavPacientecomoseentero.setWebtags( "" );
      cmbavPacientecomoseentero.addItem("", "Seleccione", (short)(0));
      cmbavPacientecomoseentero.addItem("F", "Facebook", (short)(0));
      cmbavPacientecomoseentero.addItem("G", "Búsqueda en Google", (short)(0));
      cmbavPacientecomoseentero.addItem("T", "Twitter", (short)(0));
      cmbavPacientecomoseentero.addItem("I", "Instagram", (short)(0));
      cmbavPacientecomoseentero.addItem("L", "Linked In", (short)(0));
      cmbavPacientecomoseentero.addItem("C", "Mediante conocido o familiar", (short)(0));
      cmbavPacientecomoseentero.addItem("O", "Otros", (short)(0));
      if ( cmbavPacientecomoseentero.getItemCount() > 0 )
      {
         AV21PacienteComoSeEntero = cmbavPacientecomoseentero.getValidValue(AV21PacienteComoSeEntero) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21PacienteComoSeEntero", AV21PacienteComoSeEntero);
      }
      chkavPacienteterminoscondiciones.setName( "vPACIENTETERMINOSCONDICIONES" );
      chkavPacienteterminoscondiciones.setWebtags( "" );
      chkavPacienteterminoscondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavPacienteterminoscondiciones.getInternalname(), "TitleCaption", chkavPacienteterminoscondiciones.getCaption(), true);
      chkavPacienteterminoscondiciones.setCheckedValue( "false" );
      AV35PacienteTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV35PacienteTerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35PacienteTerminosCondiciones", AV35PacienteTerminosCondiciones);
      /* End function init_web_controls */
   }

   public void validv_Pacientedepartamento( )
   {
      AV28PacienteNacionalidad = (short)(GXutil.lval( dynavPacientenacionalidad.getValue())) ;
      AV22PacienteDepartamento = cmbavPacientedepartamento.getValue() ;
      AV32PacienteProvincia = dynavPacienteprovincia.getValue() ;
      AV24PacienteDistrito = dynavPacientedistrito.getValue() ;
      gxvvpacienteprovincia_html4P2( AV22PacienteDepartamento) ;
      gxvvpacientedistrito_html4P2( AV22PacienteDepartamento, AV32PacienteProvincia) ;
      dynload_actions( ) ;
      if ( dynavPacienteprovincia.getItemCount() > 0 )
      {
         AV32PacienteProvincia = dynavPacienteprovincia.getValidValue(AV32PacienteProvincia) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
      }
      if ( dynavPacientedistrito.getItemCount() > 0 )
      {
         AV24PacienteDistrito = dynavPacientedistrito.getValidValue(AV24PacienteDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientedistrito.setValue( GXutil.rtrim( AV24PacienteDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV32PacienteProvincia", AV32PacienteProvincia);
      dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
      httpContext.ajax_rsp_assign_prop("", false, dynavPacienteprovincia.getInternalname(), "Values", dynavPacienteprovincia.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV24PacienteDistrito", AV24PacienteDistrito);
      dynavPacientedistrito.setValue( GXutil.rtrim( AV24PacienteDistrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
   }

   public void validv_Pacienteprovincia( )
   {
      AV28PacienteNacionalidad = (short)(GXutil.lval( dynavPacientenacionalidad.getValue())) ;
      AV22PacienteDepartamento = cmbavPacientedepartamento.getValue() ;
      AV32PacienteProvincia = dynavPacienteprovincia.getValue() ;
      AV24PacienteDistrito = dynavPacientedistrito.getValue() ;
      gxvvpacientedistrito_html4P2( AV22PacienteDepartamento, AV32PacienteProvincia) ;
      dynload_actions( ) ;
      if ( dynavPacientedistrito.getItemCount() > 0 )
      {
         AV24PacienteDistrito = dynavPacientedistrito.getValidValue(AV24PacienteDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientedistrito.setValue( GXutil.rtrim( AV24PacienteDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV24PacienteDistrito", AV24PacienteDistrito);
      dynavPacientedistrito.setValue( GXutil.rtrim( AV24PacienteDistrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV5PaisId',fld:'vPAISID',pic:'ZZZ9',hsh:true},{av:'AV38Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VANIO.CONTROLVALUECHANGED","{handler:'e124P2',iparms:[{av:'cmbavAnio'},{av:'AV7Anio',fld:'vANIO',pic:'ZZZ9'},{av:'cmbavMes'},{av:'AV15Mes',fld:'vMES',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VANIO.CONTROLVALUECHANGED",",oparms:[{av:'cmbavDia'},{av:'AV8Dia',fld:'vDIA',pic:'ZZZ9'},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VMES.CONTROLVALUECHANGED","{handler:'e134P2',iparms:[{av:'cmbavAnio'},{av:'AV7Anio',fld:'vANIO',pic:'ZZZ9'},{av:'cmbavMes'},{av:'AV15Mes',fld:'vMES',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VMES.CONTROLVALUECHANGED",",oparms:[{av:'cmbavDia'},{av:'AV8Dia',fld:'vDIA',pic:'ZZZ9'},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'BTNGUARDARPACIENTE'","{handler:'e144P2',iparms:[{av:'cmbavPacientedepartamento'},{av:'AV22PacienteDepartamento',fld:'vPACIENTEDEPARTAMENTO',pic:''},{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV24PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'cmbavAnio'},{av:'AV7Anio',fld:'vANIO',pic:'ZZZ9'},{av:'cmbavMes'},{av:'AV15Mes',fld:'vMES',pic:''},{av:'cmbavDia'},{av:'AV8Dia',fld:'vDIA',pic:'ZZZ9'},{av:'AV29PacienteNombres',fld:'vPACIENTENOMBRES',pic:''},{av:'AV20PacienteApellidoPaterno',fld:'vPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV19PacienteApellidoMaterno',fld:'vPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV25PacienteEmail',fld:'vPACIENTEEMAIL',pic:''},{av:'AV30PacienteNroDocumento',fld:'vPACIENTENRODOCUMENTO',pic:''},{av:'cmbavPacientetipodocumento'},{av:'AV36PacienteTipoDocumento',fld:'vPACIENTETIPODOCUMENTO',pic:''},{av:'cmbavPacientesexo'},{av:'AV33PacienteSexo',fld:'vPACIENTESEXO',pic:''},{av:'AV34PacienteTelefono',fld:'vPACIENTETELEFONO',pic:''},{av:'cmbavPacientecomoseentero'},{av:'AV21PacienteComoSeEntero',fld:'vPACIENTECOMOSEENTERO',pic:''},{av:'AV31PacientePassword',fld:'vPACIENTEPASSWORD',pic:''},{av:'AV5PaisId',fld:'vPAISID',pic:'ZZZ9',hsh:true},{av:'AV38Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'AV13Mensaje',fld:'vMENSAJE',pic:''},{av:'AV42SecUser',fld:'vSECUSER',pic:''},{av:'AV43SecUserRole',fld:'vSECUSERROLE',pic:''},{av:'A13SecRoleName',fld:'SECROLENAME',pic:''},{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'AV18Paciente',fld:'vPACIENTE',pic:''},{av:'AV23PacienteDireccion',fld:'vPACIENTEDIRECCION',pic:''},{av:'AV49Espesifique',fld:'vESPESIFIQUE',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'BTNGUARDARPACIENTE'",",oparms:[{av:'AV13Mensaje',fld:'vMENSAJE',pic:''},{av:'AV42SecUser',fld:'vSECUSER',pic:''},{av:'AV43SecUserRole',fld:'vSECUSERROLE',pic:''},{av:'AV18Paciente',fld:'vPACIENTE',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'BTNCANCELARPACIENTE'","{handler:'e154P2',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'BTNCANCELARPACIENTE'",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VPACIENTENRODOCUMENTO.CONTROLVALUECHANGED","{handler:'e164P2',iparms:[{av:'cmbavPacientetipodocumento'},{av:'AV36PacienteTipoDocumento',fld:'vPACIENTETIPODOCUMENTO',pic:''},{av:'AV30PacienteNroDocumento',fld:'vPACIENTENRODOCUMENTO',pic:''},{av:'cmbavAnio'},{av:'AV7Anio',fld:'vANIO',pic:'ZZZ9'},{av:'cmbavMes'},{av:'AV15Mes',fld:'vMES',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VPACIENTENRODOCUMENTO.CONTROLVALUECHANGED",",oparms:[{av:'AV19PacienteApellidoMaterno',fld:'vPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV20PacienteApellidoPaterno',fld:'vPACIENTEAPELLIDOPATERNO',pic:''},{av:'cmbavDia'},{av:'AV8Dia',fld:'vDIA',pic:'ZZZ9'},{av:'cmbavAnio'},{av:'AV7Anio',fld:'vANIO',pic:'ZZZ9'},{av:'cmbavMes'},{av:'AV15Mes',fld:'vMES',pic:''},{av:'AV29PacienteNombres',fld:'vPACIENTENOMBRES',pic:''},{av:'cmbavPacientesexo'},{av:'AV33PacienteSexo',fld:'vPACIENTESEXO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTETIPODOCUMENTO","{handler:'validv_Pacientetipodocumento',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTETIPODOCUMENTO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTENRODOCUMENTO","{handler:'validv_Pacientenrodocumento',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTENRODOCUMENTO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTENOMBRES","{handler:'validv_Pacientenombres',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTENOMBRES",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTEAPELLIDOPATERNO","{handler:'validv_Pacienteapellidopaterno',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTEAPELLIDOPATERNO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTEAPELLIDOMATERNO","{handler:'validv_Pacienteapellidomaterno',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTEAPELLIDOMATERNO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTESEXO","{handler:'validv_Pacientesexo',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTESEXO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_MES","{handler:'validv_Mes',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_MES",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTETELEFONO","{handler:'validv_Pacientetelefono',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTETELEFONO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTEDEPARTAMENTO","{handler:'validv_Pacientedepartamento',iparms:[{av:'cmbavPacientedepartamento'},{av:'AV22PacienteDepartamento',fld:'vPACIENTEDEPARTAMENTO',pic:''},{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV24PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTEDEPARTAMENTO",",oparms:[{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV24PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTEPROVINCIA","{handler:'validv_Pacienteprovincia',iparms:[{av:'cmbavPacientedepartamento'},{av:'AV22PacienteDepartamento',fld:'vPACIENTEDEPARTAMENTO',pic:''},{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV24PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTEPROVINCIA",",oparms:[{av:'dynavPacientedistrito'},{av:'AV24PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTECOMOSEENTERO","{handler:'validv_Pacientecomoseentero',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTECOMOSEENTERO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTEEMAIL","{handler:'validv_Pacienteemail',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTEEMAIL",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV28PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'},{av:'AV35PacienteTerminosCondiciones',fld:'vPACIENTETERMINOSCONDICIONES',pic:''}]}");
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
      AV22PacienteDepartamento = "" ;
      AV32PacienteProvincia = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV38Pattern = "" ;
      GXKey = "" ;
      AV13Mensaje = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      AV43SecUserRole = new com.projectthani.wwpbaseobjects.SdtSecUserRole(remoteHandle);
      A13SecRoleName = "" ;
      AV18Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      sImgUrl = "" ;
      lblTitleinfosolicitada_Jsonclick = "" ;
      TempTags = "" ;
      AV36PacienteTipoDocumento = "" ;
      AV30PacienteNroDocumento = "" ;
      AV29PacienteNombres = "" ;
      AV20PacienteApellidoPaterno = "" ;
      AV19PacienteApellidoMaterno = "" ;
      AV33PacienteSexo = "" ;
      AV15Mes = "" ;
      AV34PacienteTelefono = "" ;
      AV23PacienteDireccion = "" ;
      AV24PacienteDistrito = "" ;
      AV21PacienteComoSeEntero = "" ;
      AV49Espesifique = "" ;
      AV25PacienteEmail = "" ;
      AV31PacientePassword = "" ;
      lblTxbaceptotc_Jsonclick = "" ;
      bttBtnguardarpaciente_Jsonclick = "" ;
      bttBtncancelarpaciente_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H004P2_A43PaisId = new short[1] ;
      H004P2_A184PaisDescripcion = new String[] {""} ;
      H004P3_A44UbigeoCode = new String[] {""} ;
      H004P3_A187UbigeoProvincia = new String[] {""} ;
      H004P3_A296UbigeoProvinciaCode = new String[] {""} ;
      H004P3_A295UbigeoDepartamentoCode = new String[] {""} ;
      H004P4_A44UbigeoCode = new String[] {""} ;
      H004P4_A188UbigeoDistrito = new String[] {""} ;
      H004P4_A297UbigeoDistritoCode = new String[] {""} ;
      H004P4_A295UbigeoDepartamentoCode = new String[] {""} ;
      H004P4_A296UbigeoProvinciaCode = new String[] {""} ;
      Gx_date = GXutil.nullDate() ;
      H004P6_A40000PacienteId = new int[1] ;
      H004P6_n40000PacienteId = new boolean[] {false} ;
      H004P8_A40001SecUserId = new short[1] ;
      H004P8_n40001SecUserId = new boolean[] {false} ;
      H004P9_A186UbigeoDepartamento = new String[] {""} ;
      H004P9_A295UbigeoDepartamentoCode = new String[] {""} ;
      H004P9_A44UbigeoCode = new String[] {""} ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A44UbigeoCode = "" ;
      AV45TempFechaNac = GXutil.nullDate() ;
      H004P11_A40000PacienteId = new int[1] ;
      H004P11_n40000PacienteId = new boolean[] {false} ;
      H004P13_A40001SecUserId = new short[1] ;
      H004P13_n40001SecUserId = new boolean[] {false} ;
      AV47UbigeoCode = "" ;
      AV26PacienteFechaNacimiento = GXutil.nullDate() ;
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      H004P14_A13SecRoleName = new String[] {""} ;
      H004P14_A4SecRoleId = new short[1] ;
      AV6WebSession = httpContext.getWebSession();
      AV17MsgSuccss = "" ;
      AV46textoMensaj = "" ;
      AV14Mensajei = "" ;
      AV40SDTResponseDni = new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
      GXv_int2 = new int[1] ;
      AV39result = "" ;
      GXv_char3 = new String[1] ;
      AV41SDTResponseWSDni = new com.projectthani.SdtSDTResponseWSDni(remoteHandle, context);
      AV16MesTemporal = "" ;
      AV10HtmlTerminosCondiciones = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ZV32PacienteProvincia = "" ;
      ZV24PacienteDistrito = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpregistropaciente__default(),
         new Object[] {
             new Object[] {
            H004P2_A43PaisId, H004P2_A184PaisDescripcion
            }
            , new Object[] {
            H004P3_A44UbigeoCode, H004P3_A187UbigeoProvincia, H004P3_A296UbigeoProvinciaCode, H004P3_A295UbigeoDepartamentoCode
            }
            , new Object[] {
            H004P4_A44UbigeoCode, H004P4_A188UbigeoDistrito, H004P4_A297UbigeoDistritoCode, H004P4_A295UbigeoDepartamentoCode, H004P4_A296UbigeoProvinciaCode
            }
            , new Object[] {
            H004P6_A40000PacienteId, H004P6_n40000PacienteId
            }
            , new Object[] {
            H004P8_A40001SecUserId, H004P8_n40001SecUserId
            }
            , new Object[] {
            H004P9_A186UbigeoDepartamento, H004P9_A295UbigeoDepartamentoCode, H004P9_A44UbigeoCode
            }
            , new Object[] {
            H004P11_A40000PacienteId, H004P11_n40000PacienteId
            }
            , new Object[] {
            H004P13_A40001SecUserId, H004P13_n40001SecUserId
            }
            , new Object[] {
            H004P14_A13SecRoleName, H004P14_A4SecRoleId
            }
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
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV5PaisId ;
   private short A4SecRoleId ;
   private short A40001SecUserId ;
   private short wbEnd ;
   private short wbStart ;
   private short AV8Dia ;
   private short AV7Anio ;
   private short AV28PacienteNacionalidad ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV12i ;
   private short AV11httpstatus ;
   private int A40000PacienteId ;
   private int edtavPacientenrodocumento_Enabled ;
   private int edtavPacientenombres_Enabled ;
   private int edtavPacienteapellidopaterno_Enabled ;
   private int edtavPacienteapellidomaterno_Enabled ;
   private int edtavPacientetelefono_Enabled ;
   private int edtavPacientedireccion_Enabled ;
   private int edtavEspesifique_Enabled ;
   private int edtavPacienteemail_Enabled ;
   private int edtavPacientepassword_Enabled ;
   private int gxdynajaxindex ;
   private int AV55GXV1 ;
   private int GXv_int2[] ;
   private int idxLst ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintableregistropaciente_Internalname ;
   private String divTable2_Internalname ;
   private String divTable3_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String imgImage1_Internalname ;
   private String lblTitleinfosolicitada_Internalname ;
   private String lblTitleinfosolicitada_Jsonclick ;
   private String divTableregistro_Internalname ;
   private String divTable6_Internalname ;
   private String grpGroupinfogeneral_Internalname ;
   private String divGroup2table_Internalname ;
   private String TempTags ;
   private String AV36PacienteTipoDocumento ;
   private String edtavPacientenrodocumento_Internalname ;
   private String edtavPacientenrodocumento_Jsonclick ;
   private String edtavPacientenombres_Internalname ;
   private String edtavPacientenombres_Jsonclick ;
   private String edtavPacienteapellidopaterno_Internalname ;
   private String edtavPacienteapellidopaterno_Jsonclick ;
   private String edtavPacienteapellidomaterno_Internalname ;
   private String edtavPacienteapellidomaterno_Jsonclick ;
   private String AV33PacienteSexo ;
   private String grpGroupfechanacimiento_Internalname ;
   private String divGroup1table_Internalname ;
   private String edtavPacientetelefono_Internalname ;
   private String AV34PacienteTelefono ;
   private String edtavPacientetelefono_Jsonclick ;
   private String grpGroupubicacionresidencia_Internalname ;
   private String divGroup1table1_Internalname ;
   private String edtavPacientedireccion_Internalname ;
   private String grpGroupinfadicional_Internalname ;
   private String divGroup5table_Internalname ;
   private String edtavEspesifique_Internalname ;
   private String grpGroupinfodelacuenta_Internalname ;
   private String divGroup4table_Internalname ;
   private String edtavPacienteemail_Internalname ;
   private String edtavPacienteemail_Jsonclick ;
   private String edtavPacientepassword_Internalname ;
   private String edtavPacientepassword_Jsonclick ;
   private String divTable1_Internalname ;
   private String lblTxbaceptotc_Internalname ;
   private String lblTxbaceptotc_Caption ;
   private String lblTxbaceptotc_Jsonclick ;
   private String divTable5_Internalname ;
   private String bttBtnguardarpaciente_Internalname ;
   private String bttBtnguardarpaciente_Jsonclick ;
   private String bttBtncancelarpaciente_Internalname ;
   private String bttBtncancelarpaciente_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String A44UbigeoCode ;
   private String AV47UbigeoCode ;
   private String GXv_char3[] ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date Gx_date ;
   private java.util.Date AV45TempFechaNac ;
   private java.util.Date AV26PacienteFechaNacimiento ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean AV35PacienteTerminosCondiciones ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000PacienteId ;
   private boolean n40001SecUserId ;
   private boolean returnInSub ;
   private String AV17MsgSuccss ;
   private String AV39result ;
   private String AV10HtmlTerminosCondiciones ;
   private String AV22PacienteDepartamento ;
   private String AV32PacienteProvincia ;
   private String AV38Pattern ;
   private String A13SecRoleName ;
   private String AV30PacienteNroDocumento ;
   private String AV29PacienteNombres ;
   private String AV20PacienteApellidoPaterno ;
   private String AV19PacienteApellidoMaterno ;
   private String AV15Mes ;
   private String AV23PacienteDireccion ;
   private String AV24PacienteDistrito ;
   private String AV21PacienteComoSeEntero ;
   private String AV49Espesifique ;
   private String AV25PacienteEmail ;
   private String AV31PacientePassword ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String AV46textoMensaj ;
   private String AV14Mensajei ;
   private String AV16MesTemporal ;
   private String ZV32PacienteProvincia ;
   private String ZV24PacienteDistrito ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private HTMLChoice cmbavPacientetipodocumento ;
   private HTMLChoice cmbavPacientesexo ;
   private HTMLChoice cmbavMes ;
   private HTMLChoice cmbavDia ;
   private HTMLChoice cmbavAnio ;
   private HTMLChoice dynavPacientenacionalidad ;
   private HTMLChoice cmbavPacientedepartamento ;
   private HTMLChoice dynavPacienteprovincia ;
   private HTMLChoice dynavPacientedistrito ;
   private HTMLChoice cmbavPacientecomoseentero ;
   private ICheckbox chkavPacienteterminoscondiciones ;
   private IDataStoreProvider pr_default ;
   private short[] H004P2_A43PaisId ;
   private String[] H004P2_A184PaisDescripcion ;
   private String[] H004P3_A44UbigeoCode ;
   private String[] H004P3_A187UbigeoProvincia ;
   private String[] H004P3_A296UbigeoProvinciaCode ;
   private String[] H004P3_A295UbigeoDepartamentoCode ;
   private String[] H004P4_A44UbigeoCode ;
   private String[] H004P4_A188UbigeoDistrito ;
   private String[] H004P4_A297UbigeoDistritoCode ;
   private String[] H004P4_A295UbigeoDepartamentoCode ;
   private String[] H004P4_A296UbigeoProvinciaCode ;
   private int[] H004P6_A40000PacienteId ;
   private boolean[] H004P6_n40000PacienteId ;
   private short[] H004P8_A40001SecUserId ;
   private boolean[] H004P8_n40001SecUserId ;
   private String[] H004P9_A186UbigeoDepartamento ;
   private String[] H004P9_A295UbigeoDepartamentoCode ;
   private String[] H004P9_A44UbigeoCode ;
   private int[] H004P11_A40000PacienteId ;
   private boolean[] H004P11_n40000PacienteId ;
   private short[] H004P13_A40001SecUserId ;
   private boolean[] H004P13_n40001SecUserId ;
   private String[] H004P14_A13SecRoleName ;
   private short[] H004P14_A4SecRoleId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV6WebSession ;
   private GXSimpleCollection<String> AV13Mensaje ;
   private com.projectthani.SdtPaciente AV18Paciente ;
   private com.projectthani.SdtSDTResponseDni AV40SDTResponseDni ;
   private com.projectthani.SdtSDTResponseWSDni AV41SDTResponseWSDni ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV42SecUser ;
   private com.projectthani.wwpbaseobjects.SdtSecUserRole AV43SecUserRole ;
}

final  class wpregistropaciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004P2", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P3", "SELECT [UbigeoCode], [UbigeoProvincia], SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode FROM [Ubigeo] WHERE SUBSTRING([UbigeoCode], 1, 2) = ? ORDER BY [UbigeoProvincia] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P4", "SELECT [UbigeoCode], [UbigeoDistrito], SUBSTRING([UbigeoCode], 5, 2) AS UbigeoDistritoCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode FROM [Ubigeo] WHERE (SUBSTRING([UbigeoCode], 1, 2) = ?) AND (SUBSTRING([UbigeoCode], 3, 2) = ?) ORDER BY [UbigeoDistrito] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P6", "SELECT COALESCE( T1.[PacienteId], 0) AS PacienteId FROM (SELECT MIN([PacienteId]) AS PacienteId FROM [Paciente] WHERE [PacienteNroDocumento] = RTRIM(LTRIM(?)) or [PacienteCorreo] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P8", "SELECT COALESCE( T1.[SecUserId], 0) AS SecUserId FROM (SELECT MIN([SecUserId]) AS SecUserId FROM [SecUser] WHERE [SecUserName] = RTRIM(LTRIM(?)) or [SecUserEmail] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P9", "SELECT DISTINCT [UbigeoDepartamento], [UbigeoDepartamentoCode], NULL AS [UbigeoCode] FROM ( SELECT TOP(100) PERCENT [UbigeoDepartamento], SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, [UbigeoCode] FROM [Ubigeo] ORDER BY [UbigeoDepartamento]) DistinctT ORDER BY [UbigeoDepartamento] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P11", "SELECT COALESCE( T1.[PacienteId], 0) AS PacienteId FROM (SELECT MIN([PacienteId]) AS PacienteId FROM [Paciente] WHERE [PacienteNroDocumento] = RTRIM(LTRIM(?)) or [PacienteCorreo] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P13", "SELECT COALESCE( T1.[SecUserId], 0) AS SecUserId FROM (SELECT MIN([SecUserId]) AS SecUserId FROM [SecUser] WHERE [SecUserName] = RTRIM(LTRIM(?)) or [SecUserEmail] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004P14", "SELECT [SecRoleName], [SecRoleId] FROM [SecRole] WHERE [SecRoleName] = 'Paciente' ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 2);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 2);
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 15);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
      }
   }

}

