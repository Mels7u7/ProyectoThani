package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class register_impl extends GXWebPanel
{
   public register_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public register_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( register_impl.class ));
   }

   public register_impl( int remoteHandle ,
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
      cmbavRctipodoc = new HTMLChoice();
      cmbavAnio = new HTMLChoice();
      cmbavMes = new HTMLChoice();
      cmbavDia = new HTMLChoice();
      dynavPaisid = new HTMLChoice();
      cmbavDepartamentocode = new HTMLChoice();
      dynavProvinciacode = new HTMLChoice();
      dynavDistritocode = new HTMLChoice();
      cmbavPacienteenterarse = new HTMLChoice();
      cmbavRcsexo = new HTMLChoice();
      chkavAceptacondiciones = UIFactory.getCheckbox(this);
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPROVINCIACODE") == 0 )
         {
            AV7DepartamentoCode = httpContext.GetPar( "DepartamentoCode") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7DepartamentoCode", AV7DepartamentoCode);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvprovinciacode6X2( AV7DepartamentoCode) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vDISTRITOCODE") == 0 )
         {
            AV7DepartamentoCode = httpContext.GetPar( "DepartamentoCode") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7DepartamentoCode", AV7DepartamentoCode);
            AV23ProvinciaCode = httpContext.GetPar( "ProvinciaCode") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ProvinciaCode", AV23ProvinciaCode);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvdistritocode6X2( AV7DepartamentoCode, AV23ProvinciaCode) ;
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
         pa6X2( ) ;
         validateSpaRequest();
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws6X2( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we6X2( ) ;
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
      httpContext.writeValue( "Nuevo Registro - Doctorfast Salud") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034863", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/UCUserRegisterRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/chosen.jquery.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/ChosenGxRender.js", "", false, true);
      httpContext.AddJavascriptSource("daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/UCModalRender.js", "", false, true);
      httpContext.AddJavascriptSource("GXGoogleVisualizationLibrary/GoogleAnalytics/GoogleAnalyticsRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.register", new String[] {}, new String[] {}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vUPLOADEDFILES", AV44UploadedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vUPLOADEDFILES", AV44UploadedFiles);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOAD1_Autoupload", GXutil.booltostr( Fileupload1_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOAD1_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileupload1_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOAD1_Autodisableaddingfiles", GXutil.booltostr( Fileupload1_Autodisableaddingfiles));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TAB1_Pagecount", GXutil.ltrim( localUtil.ntoc( Tab1_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TAB1_Class", GXutil.rtrim( Tab1_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TAB1_Historymanagement", GXutil.booltostr( Tab1_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVMESSAGE1_Defaultmessagetype", GXutil.rtrim( Dvmessage1_Defaultmessagetype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CHOSENGX1_Emptyitem", GXutil.rtrim( Chosengx1_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMODAL1_Id", GXutil.rtrim( Ucmodal1_Id));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMODAL1_Btnbackstyle", GXutil.rtrim( Ucmodal1_Btnbackstyle));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEANALYTICS1_Width", GXutil.rtrim( Googleanalytics1_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEANALYTICS1_Height", GXutil.rtrim( Googleanalytics1_Height));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEANALYTICS1_Code", GXutil.rtrim( Googleanalytics1_Code));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GOOGLEANALYTICS1_Domainname", GXutil.rtrim( Googleanalytics1_Domainname));
   }

   public void renderHtmlCloseForm6X2( )
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
      return "Register" ;
   }

   public String getPgmdesc( )
   {
      return "Nuevo Registro - Doctorfast Salud" ;
   }

   public void wb6X0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintableregister_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcuserregister1.render(context, "ucuserregister", Ucuserregister1_Internalname, "UCUSERREGISTER1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"UCUSERREGISTER1Container"+"Ucuserregister1_RegisterForm"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUcuserregister1_registerform_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableregister_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavRctipodoc.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavRctipodoc.getInternalname(), "Tipo Documento", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavRctipodoc, cmbavRctipodoc.getInternalname(), GXutil.rtrim( AV34RCTipoDoc), 1, cmbavRctipodoc.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavRctipodoc.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,16);\"", "", true, (byte)(1), "HLP_Register.htm");
         cmbavRctipodoc.setValue( GXutil.rtrim( AV34RCTipoDoc) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRctipodoc.getInternalname(), "Values", cmbavRctipodoc.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRcnrodoc_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavRcnrodoc_Internalname, "Nro Documento", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavRcnrodoc_Internalname, AV29RCNroDoc, GXutil.rtrim( localUtil.format( AV29RCNroDoc, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRcnrodoc_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavRcnrodoc_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRcappaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavRcappaterno_Internalname, "Apellido Paterno", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavRcappaterno_Internalname, AV25RCApPaterno, GXutil.rtrim( localUtil.format( AV25RCApPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRcappaterno_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavRcappaterno_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRcapmaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavRcapmaterno_Internalname, "Apellido Materno", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavRcapmaterno_Internalname, AV24RCApMaterno, GXutil.rtrim( localUtil.format( AV24RCApMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRcapmaterno_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavRcapmaterno_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRcnombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavRcnombres_Internalname, "Nombres", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavRcnombres_Internalname, AV28RCNombres, GXutil.rtrim( localUtil.format( AV28RCNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavRcnombres_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavRcnombres_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup1_Internalname, "Fecha de Nacimiento", 1, 0, "px", 0, "px", "Group", "", "HLP_Register.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavAnio.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavAnio.getInternalname(), "Año", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavAnio, cmbavAnio.getInternalname(), GXutil.trim( GXutil.str( AV6Anio, 4, 0)), 1, cmbavAnio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavAnio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(1), "HLP_Register.htm");
         cmbavAnio.setValue( GXutil.trim( GXutil.str( AV6Anio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAnio.getInternalname(), "Values", cmbavAnio.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavMes.getInternalname(), "Mes", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMes, cmbavMes.getInternalname(), GXutil.rtrim( AV15Mes), 1, cmbavMes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"", "", true, (byte)(1), "HLP_Register.htm");
         cmbavMes.setValue( GXutil.rtrim( AV15Mes) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavDia.getInternalname(), "Dia", "col-xs-12 AttributeRegisterLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDia, cmbavDia.getInternalname(), GXutil.trim( GXutil.str( AV8Dia, 2, 0)), 1, cmbavDia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,50);\"", "", true, (byte)(1), "HLP_Register.htm");
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV8Dia, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPaisid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPaisid.getInternalname(), "Nacionalidad", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPaisid, dynavPaisid.getInternalname(), GXutil.trim( GXutil.str( AV21PaisId, 4, 0)), 1, dynavPaisid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavPaisid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,55);\"", "", true, (byte)(1), "HLP_Register.htm");
         dynavPaisid.setValue( GXutil.trim( GXutil.str( AV21PaisId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Values", dynavPaisid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDepartamentocode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavDepartamentocode.getInternalname(), "Departamento", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDepartamentocode, cmbavDepartamentocode.getInternalname(), GXutil.rtrim( AV7DepartamentoCode), 1, cmbavDepartamentocode.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavDepartamentocode.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "", true, (byte)(1), "HLP_Register.htm");
         cmbavDepartamentocode.setValue( GXutil.rtrim( AV7DepartamentoCode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDepartamentocode.getInternalname(), "Values", cmbavDepartamentocode.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavProvinciacode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavProvinciacode.getInternalname(), "Provincia", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavProvinciacode, dynavProvinciacode.getInternalname(), GXutil.rtrim( AV23ProvinciaCode), 1, dynavProvinciacode.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavProvinciacode.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(1), "HLP_Register.htm");
         dynavProvinciacode.setValue( GXutil.rtrim( AV23ProvinciaCode) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProvinciacode.getInternalname(), "Values", dynavProvinciacode.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavDistritocode.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavDistritocode.getInternalname(), "Distrito ", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavDistritocode, dynavDistritocode.getInternalname(), GXutil.rtrim( AV9DistritoCode), 1, dynavDistritocode.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavDistritocode.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "", true, (byte)(1), "HLP_Register.htm");
         dynavDistritocode.setValue( GXutil.rtrim( AV9DistritoCode) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDistritocode.getInternalname(), "Values", dynavDistritocode.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientedireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientedireccion_Internalname, "Direccion", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
         ClassString = "AttributeRegister1" ;
         StyleString = "" ;
         ClassString = "AttributeRegister1" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavPacientedireccion_Internalname, AV17PacienteDireccion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", (short)(0), 1, edtavPacientedireccion_Enabled, 0, 80, "chr", 2, "row", StyleString, ClassString, "", "", "500", 1, 0, "", "Ejem: Calle La flores 675", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacienteenterarse.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacienteenterarse.getInternalname(), "¿Cómo se entero de Doctor Fast?", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacienteenterarse, cmbavPacienteenterarse.getInternalname(), GXutil.rtrim( AV18PacienteEnterarse), 1, cmbavPacienteenterarse.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavPacienteenterarse.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,76);\"", "", true, (byte)(1), "HLP_Register.htm");
         cmbavPacienteenterarse.setValue( GXutil.rtrim( AV18PacienteEnterarse) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacienteenterarse.getInternalname(), "Values", cmbavPacienteenterarse.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavRcsexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavRcsexo.getInternalname(), "Sexo", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 81,'',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavRcsexo, cmbavRcsexo.getInternalname(), GXutil.rtrim( AV32RCSexo), 1, cmbavRcsexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavRcsexo.getEnabled(), 0, (short)(0), 15, "em", 0, "", "", "AttributeRegister1", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,81);\"", "", true, (byte)(1), "HLP_Register.htm");
         cmbavRcsexo.setValue( GXutil.rtrim( AV32RCSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRcsexo.getInternalname(), "Values", cmbavRcsexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRctel_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavRctel_Internalname, "Teléfono", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavRctel_Internalname, AV33RCTel, GXutil.rtrim( localUtil.format( AV33RCTel, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "+9528753335", edtavRctel_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavRctel_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRccorreo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavRccorreo_Internalname, "Correo", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavRccorreo_Internalname, AV26RCCorreo, GXutil.rtrim( localUtil.format( AV26RCCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,90);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+AV26RCCorreo, "", "", "mi_correo@gmail.com", edtavRccorreo_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavRccorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavRcpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavRcpassword_Internalname, "Contraseña", "col-xs-12 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavRcpassword_Internalname, AV30RCPassword, GXutil.rtrim( localUtil.format( AV30RCPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,94);\""+" "+"data-gx-password-reveal"+" "+"idenableshowpasswordhint=\"True\""+" ", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "contraseña DoctorFast", edtavRcpassword_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavRcpassword_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-xs col-sm-6", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTb_contrasena_Internalname, "Contraseña que usará para ingresar a DoctorFast", "", "", lblTb_contrasena_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockCorreoRegister", 0, "", 1, 1, 0, (short)(0), "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-1 col-sm-2", "Right", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavAceptacondiciones.getInternalname(), "Acepta Condiciones", "col-sm-5 CheckBoxLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
         ClassString = "CheckBox" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAceptacondiciones.getInternalname(), GXutil.booltostr( AV5AceptaCondiciones), "", "Acepta Condiciones", 1, chkavAceptacondiciones.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(102, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,102);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-11 col-sm-10", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTextoacepta_Internalname, "texto Acepta", "col-sm-5 AttributeRegister1Label", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTextoacepta_Internalname, AV38textoAcepta, GXutil.rtrim( localUtil.format( AV38textoAcepta, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,105);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTextoacepta_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavTextoacepta_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(1), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "Right", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'',false,'',0)\"" ;
         ClassString = "ButtonDFS" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttRegistrar_Internalname, "", "Registrar", bttRegistrar_Jsonclick, 7, "Registrar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116x1_client"+"'", TempTags, "", 2, "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Right", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
         ClassString = "ReservaCancelar" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar_Internalname, "", "Cancelar", bttCancelar_Jsonclick, 5, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'CANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTab1.setProperty("PageCount", Tab1_Pagecount);
         ucTab1.setProperty("Class", Tab1_Class);
         ucTab1.setProperty("HistoryManagement", Tab1_Historymanagement);
         ucTab1.render(context, "tab", Tab1_Internalname, "TAB1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TAB1Container"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage1_title_Internalname, "Datos personales", "", "", lblTabpage1_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Register.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage1") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TAB1Container"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 50, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSection6_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TAB1Container"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpage2_title_Internalname, "Datos secundarios", "", "", lblTabpage2_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_Register.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPage2") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TAB1Container"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 50, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSection5_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTpacientepeso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTpacientepeso_Internalname, "Peso (kg)", "col-sm-3 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTpacientepeso_Internalname, GXutil.ltrim( localUtil.ntoc( AV41tPacientePeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtavTpacientepeso_Enabled!=0) ? localUtil.format( AV41tPacientePeso, "ZZ9.99") : localUtil.format( AV41tPacientePeso, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,139);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTpacientepeso_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavTpacientepeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTpacienteestatura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTpacienteestatura_Internalname, " Estatura (metros)", "col-sm-3 AttributeRegister1Label", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavTpacienteestatura_Internalname, GXutil.ltrim( localUtil.ntoc( AV40tPacienteEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtavTpacienteestatura_Enabled!=0) ? localUtil.format( AV40tPacienteEstatura, "9.99") : localUtil.format( AV40tPacienteEstatura, "9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,144);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTpacienteestatura_Jsonclick, 0, "AttributeRegister1", "", "", "", "", 1, edtavTpacienteestatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "Adjuntar anexos (Opcional) Si tiene información relevante médica, subirla aquí (Si es más de un archivo, tiene que ser comprimido en formato .zip o .rar y luego ser subido)", "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockBold", 0, "", 1, 1, 0, (short)(0), "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucFileupload1.setProperty("AutoUpload", Fileupload1_Autoupload);
         ucFileupload1.setProperty("TooltipText", Fileupload1_Tooltiptext);
         ucFileupload1.setProperty("MaxNumberOfFiles", Fileupload1_Maxnumberoffiles);
         ucFileupload1.setProperty("AutoDisableAddingFiles", Fileupload1_Autodisableaddingfiles);
         ucFileupload1.setProperty("UploadedFiles", AV44UploadedFiles);
         ucFileupload1.render(context, "fileupload", Fileupload1_Internalname, "FILEUPLOAD1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvmessage1.setProperty("DefaultMessageType", Dvmessage1_Defaultmessagetype);
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, "DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucChosengx1.setProperty("EmptyItem", Chosengx1_Emptyitem);
         ucChosengx1.render(context, "chosengx", Chosengx1_Internalname, "CHOSENGX1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcmodal1.setProperty("Id", Ucmodal1_Id);
         ucUcmodal1.setProperty("Title", Ucmodal1_Title);
         ucUcmodal1.setProperty("BtnBackStyle", Ucmodal1_Btnbackstyle);
         ucUcmodal1.render(context, "ucmodal", Ucmodal1_Internalname, "UCMODAL1Container");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"UCMODAL1Container"+"Ucmodal1_ModalContent"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUcmodal1_modalcontent_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavTextomensaj_Internalname, "texto Mensaj", "col-sm-3 ", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 165,'',false,'',0)\"" ;
         ClassString = "" ;
         StyleString = "" ;
         ClassString = "" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavTextomensaj_Internalname, AV39textoMensaj, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,165);\"", (short)(2), 1, edtavTextomensaj_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Register.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGoogleanalytics1.setProperty("Width", Googleanalytics1_Width);
         ucGoogleanalytics1.setProperty("Height", Googleanalytics1_Height);
         ucGoogleanalytics1.setProperty("Code", Googleanalytics1_Code);
         ucGoogleanalytics1.setProperty("DomainName", Googleanalytics1_Domainname);
         ucGoogleanalytics1.render(context, "googleanalytics", Googleanalytics1_Internalname, "GOOGLEANALYTICS1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start6X2( )
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
         Form.getMeta().addItem("description", "Nuevo Registro - Doctorfast Salud", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6X0( ) ;
   }

   public void ws6X2( )
   {
      start6X2( ) ;
      evt6X2( ) ;
   }

   public void evt6X2( )
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
                        e126X2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "'CANCELAR'") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'Cancelar' */
                        e136X2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e146X2 ();
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

   public void we6X2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm6X2( ) ;
         }
      }
   }

   public void pa6X2( )
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
            GX_FocusControl = cmbavRctipodoc.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvprovinciacode_html6X2( AV7DepartamentoCode) ;
      gxvvdistritocode_html6X2( AV7DepartamentoCode, AV23ProvinciaCode) ;
      /* End function dynload_actions */
   }

   public void gxdlvvpaisid6X1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpaisid_data6X1( ) ;
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

   public void gxvvpaisid_html6X1( )
   {
      short gxdynajaxvalue;
      gxdlvvpaisid_data6X1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPaisid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavPaisid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpaisid_data6X1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H006X2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H006X2_A43PaisId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H006X2_A184PaisDescripcion[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvprovinciacode6X2( String AV7DepartamentoCode )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvprovinciacode_data6X2( AV7DepartamentoCode) ;
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

   public void gxvvprovinciacode_html6X2( String AV7DepartamentoCode )
   {
      String gxdynajaxvalue;
      gxdlvvprovinciacode_data6X2( AV7DepartamentoCode) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavProvinciacode.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavProvinciacode.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvprovinciacode_data6X2( String AV7DepartamentoCode )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H006X3 */
      pr_default.execute(1, new Object[] {AV7DepartamentoCode});
      while ( (pr_default.getStatus(1) != 101) )
      {
         if ( GXutil.strcmp(H006X3_A295UbigeoDepartamentoCode[0], AV7DepartamentoCode) == 0 )
         {
            gxdynajaxctrlcodr.add(H006X3_A296UbigeoProvinciaCode[0]);
            gxdynajaxctrldescr.add(H006X3_A187UbigeoProvincia[0]);
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvvdistritocode6X2( String AV7DepartamentoCode ,
                                      String AV23ProvinciaCode )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvdistritocode_data6X2( AV7DepartamentoCode, AV23ProvinciaCode) ;
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

   public void gxvvdistritocode_html6X2( String AV7DepartamentoCode ,
                                         String AV23ProvinciaCode )
   {
      String gxdynajaxvalue;
      gxdlvvdistritocode_data6X2( AV7DepartamentoCode, AV23ProvinciaCode) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavDistritocode.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavDistritocode.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvdistritocode_data6X2( String AV7DepartamentoCode ,
                                              String AV23ProvinciaCode )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H006X4 */
      pr_default.execute(2, new Object[] {AV7DepartamentoCode, AV23ProvinciaCode});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(H006X4_A297UbigeoDistritoCode[0]);
         gxdynajaxctrldescr.add(H006X4_A188UbigeoDistrito[0]);
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
         dynavPaisid.setName( "vPAISID" );
         dynavPaisid.setWebtags( "" );
         dynavPaisid.removeAllItems();
         /* Using cursor H006X5 */
         pr_default.execute(3);
         while ( (pr_default.getStatus(3) != 101) )
         {
            dynavPaisid.addItem(GXutil.trim( GXutil.str( H006X5_A43PaisId[0], 4, 0)), H006X5_A184PaisDescripcion[0], (short)(0));
            pr_default.readNext(3);
         }
         pr_default.close(3);
         if ( dynavPaisid.getItemCount() > 0 )
         {
            AV21PaisId = (short)(GXutil.lval( dynavPaisid.getValidValue(GXutil.trim( GXutil.str( AV21PaisId, 4, 0))))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21PaisId), 4, 0));
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavRctipodoc.getItemCount() > 0 )
      {
         AV34RCTipoDoc = cmbavRctipodoc.getValidValue(AV34RCTipoDoc) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34RCTipoDoc", AV34RCTipoDoc);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavRctipodoc.setValue( GXutil.rtrim( AV34RCTipoDoc) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRctipodoc.getInternalname(), "Values", cmbavRctipodoc.ToJavascriptSource(), true);
      }
      if ( cmbavAnio.getItemCount() > 0 )
      {
         AV6Anio = (short)(GXutil.lval( cmbavAnio.getValidValue(GXutil.trim( GXutil.str( AV6Anio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Anio), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavAnio.setValue( GXutil.trim( GXutil.str( AV6Anio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavAnio.getInternalname(), "Values", cmbavAnio.ToJavascriptSource(), true);
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
         AV8Dia = (byte)(GXutil.lval( cmbavDia.getValidValue(GXutil.trim( GXutil.str( AV8Dia, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV8Dia, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
      }
      if ( dynavPaisid.getItemCount() > 0 )
      {
         AV21PaisId = (short)(GXutil.lval( dynavPaisid.getValidValue(GXutil.trim( GXutil.str( AV21PaisId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21PaisId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPaisid.setValue( GXutil.trim( GXutil.str( AV21PaisId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Values", dynavPaisid.ToJavascriptSource(), true);
      }
      if ( cmbavDepartamentocode.getItemCount() > 0 )
      {
         AV7DepartamentoCode = cmbavDepartamentocode.getValidValue(AV7DepartamentoCode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7DepartamentoCode", AV7DepartamentoCode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDepartamentocode.setValue( GXutil.rtrim( AV7DepartamentoCode) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDepartamentocode.getInternalname(), "Values", cmbavDepartamentocode.ToJavascriptSource(), true);
      }
      if ( dynavProvinciacode.getItemCount() > 0 )
      {
         AV23ProvinciaCode = dynavProvinciacode.getValidValue(AV23ProvinciaCode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ProvinciaCode", AV23ProvinciaCode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProvinciacode.setValue( GXutil.rtrim( AV23ProvinciaCode) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProvinciacode.getInternalname(), "Values", dynavProvinciacode.ToJavascriptSource(), true);
      }
      if ( dynavDistritocode.getItemCount() > 0 )
      {
         AV9DistritoCode = dynavDistritocode.getValidValue(AV9DistritoCode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9DistritoCode", AV9DistritoCode);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDistritocode.setValue( GXutil.rtrim( AV9DistritoCode) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDistritocode.getInternalname(), "Values", dynavDistritocode.ToJavascriptSource(), true);
      }
      if ( cmbavPacienteenterarse.getItemCount() > 0 )
      {
         AV18PacienteEnterarse = cmbavPacienteenterarse.getValidValue(AV18PacienteEnterarse) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18PacienteEnterarse", AV18PacienteEnterarse);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacienteenterarse.setValue( GXutil.rtrim( AV18PacienteEnterarse) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacienteenterarse.getInternalname(), "Values", cmbavPacienteenterarse.ToJavascriptSource(), true);
      }
      if ( cmbavRcsexo.getItemCount() > 0 )
      {
         AV32RCSexo = cmbavRcsexo.getValidValue(AV32RCSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32RCSexo", AV32RCSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavRcsexo.setValue( GXutil.rtrim( AV32RCSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavRcsexo.getInternalname(), "Values", cmbavRcsexo.ToJavascriptSource(), true);
      }
      AV5AceptaCondiciones = GXutil.strtobool( GXutil.booltostr( AV5AceptaCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AceptaCondiciones", AV5AceptaCondiciones);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6X2( ) ;
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
      edtavTextoacepta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTextoacepta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTextoacepta_Enabled), 5, 0), true);
      edtavTextomensaj_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTextomensaj_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTextomensaj_Enabled), 5, 0), true);
   }

   public void rf6X2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e146X2 ();
         wb6X0( ) ;
      }
   }

   public void send_integrity_lvl_hashes6X2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavTextoacepta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTextoacepta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTextoacepta_Enabled), 5, 0), true);
      edtavTextomensaj_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTextomensaj_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTextomensaj_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup6X0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e126X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUPLOADEDFILES"), AV44UploadedFiles);
         /* Read saved values. */
         Fileupload1_Autoupload = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOAD1_Autoupload")) ;
         Fileupload1_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "FILEUPLOAD1_Maxnumberoffiles"), ",", ".")) ;
         Fileupload1_Autodisableaddingfiles = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOAD1_Autodisableaddingfiles")) ;
         Tab1_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TAB1_Pagecount"), ",", ".")) ;
         Tab1_Class = httpContext.cgiGet( "TAB1_Class") ;
         Tab1_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TAB1_Historymanagement")) ;
         Dvmessage1_Defaultmessagetype = httpContext.cgiGet( "DVMESSAGE1_Defaultmessagetype") ;
         Chosengx1_Emptyitem = httpContext.cgiGet( "CHOSENGX1_Emptyitem") ;
         Ucmodal1_Id = httpContext.cgiGet( "UCMODAL1_Id") ;
         Ucmodal1_Btnbackstyle = httpContext.cgiGet( "UCMODAL1_Btnbackstyle") ;
         Googleanalytics1_Width = httpContext.cgiGet( "GOOGLEANALYTICS1_Width") ;
         Googleanalytics1_Height = httpContext.cgiGet( "GOOGLEANALYTICS1_Height") ;
         Googleanalytics1_Code = httpContext.cgiGet( "GOOGLEANALYTICS1_Code") ;
         Googleanalytics1_Domainname = httpContext.cgiGet( "GOOGLEANALYTICS1_Domainname") ;
         /* Read variables values. */
         cmbavRctipodoc.setValue( httpContext.cgiGet( cmbavRctipodoc.getInternalname()) );
         AV34RCTipoDoc = httpContext.cgiGet( cmbavRctipodoc.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34RCTipoDoc", AV34RCTipoDoc);
         AV29RCNroDoc = httpContext.cgiGet( edtavRcnrodoc_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29RCNroDoc", AV29RCNroDoc);
         AV25RCApPaterno = httpContext.cgiGet( edtavRcappaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25RCApPaterno", AV25RCApPaterno);
         AV24RCApMaterno = httpContext.cgiGet( edtavRcapmaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24RCApMaterno", AV24RCApMaterno);
         AV28RCNombres = httpContext.cgiGet( edtavRcnombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28RCNombres", AV28RCNombres);
         cmbavAnio.setValue( httpContext.cgiGet( cmbavAnio.getInternalname()) );
         AV6Anio = (short)(GXutil.lval( httpContext.cgiGet( cmbavAnio.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Anio), 4, 0));
         cmbavMes.setValue( httpContext.cgiGet( cmbavMes.getInternalname()) );
         AV15Mes = httpContext.cgiGet( cmbavMes.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15Mes", AV15Mes);
         cmbavDia.setValue( httpContext.cgiGet( cmbavDia.getInternalname()) );
         AV8Dia = (byte)(GXutil.lval( httpContext.cgiGet( cmbavDia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 2, 0));
         dynavPaisid.setValue( httpContext.cgiGet( dynavPaisid.getInternalname()) );
         AV21PaisId = (short)(GXutil.lval( httpContext.cgiGet( dynavPaisid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21PaisId), 4, 0));
         cmbavDepartamentocode.setValue( httpContext.cgiGet( cmbavDepartamentocode.getInternalname()) );
         AV7DepartamentoCode = httpContext.cgiGet( cmbavDepartamentocode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7DepartamentoCode", AV7DepartamentoCode);
         dynavProvinciacode.setValue( httpContext.cgiGet( dynavProvinciacode.getInternalname()) );
         AV23ProvinciaCode = httpContext.cgiGet( dynavProvinciacode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23ProvinciaCode", AV23ProvinciaCode);
         dynavDistritocode.setValue( httpContext.cgiGet( dynavDistritocode.getInternalname()) );
         AV9DistritoCode = httpContext.cgiGet( dynavDistritocode.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9DistritoCode", AV9DistritoCode);
         AV17PacienteDireccion = httpContext.cgiGet( edtavPacientedireccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17PacienteDireccion", AV17PacienteDireccion);
         cmbavPacienteenterarse.setValue( httpContext.cgiGet( cmbavPacienteenterarse.getInternalname()) );
         AV18PacienteEnterarse = httpContext.cgiGet( cmbavPacienteenterarse.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18PacienteEnterarse", AV18PacienteEnterarse);
         cmbavRcsexo.setValue( httpContext.cgiGet( cmbavRcsexo.getInternalname()) );
         AV32RCSexo = httpContext.cgiGet( cmbavRcsexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32RCSexo", AV32RCSexo);
         AV33RCTel = httpContext.cgiGet( edtavRctel_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV33RCTel", AV33RCTel);
         AV26RCCorreo = httpContext.cgiGet( edtavRccorreo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26RCCorreo", AV26RCCorreo);
         AV30RCPassword = httpContext.cgiGet( edtavRcpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30RCPassword", AV30RCPassword);
         AV5AceptaCondiciones = GXutil.strtobool( httpContext.cgiGet( chkavAceptacondiciones.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5AceptaCondiciones", AV5AceptaCondiciones);
         AV38textoAcepta = httpContext.cgiGet( edtavTextoacepta_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38textoAcepta", AV38textoAcepta);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavTpacientepeso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTpacientepeso_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTPACIENTEPESO");
            GX_FocusControl = edtavTpacientepeso_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV41tPacientePeso = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41tPacientePeso", GXutil.ltrimstr( AV41tPacientePeso, 6, 2));
         }
         else
         {
            AV41tPacientePeso = localUtil.ctond( httpContext.cgiGet( edtavTpacientepeso_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV41tPacientePeso", GXutil.ltrimstr( AV41tPacientePeso, 6, 2));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavTpacienteestatura_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavTpacienteestatura_Internalname)), DecimalUtil.stringToDec("9.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTPACIENTEESTATURA");
            GX_FocusControl = edtavTpacienteestatura_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV40tPacienteEstatura = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40tPacienteEstatura", GXutil.ltrimstr( AV40tPacienteEstatura, 4, 2));
         }
         else
         {
            AV40tPacienteEstatura = localUtil.ctond( httpContext.cgiGet( edtavTpacienteestatura_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40tPacienteEstatura", GXutil.ltrimstr( AV40tPacienteEstatura, 4, 2));
         }
         AV39textoMensaj = httpContext.cgiGet( edtavTextomensaj_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39textoMensaj", AV39textoMensaj);
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
      e126X2 ();
      if (returnInSub) return;
   }

   public void e126X2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e136X2( )
   {
      /* 'Cancelar' Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'SHOWDAYS' Routine */
      returnInSub = false ;
   }

   public void S122( )
   {
      /* 'SAVEUSER' Routine */
      returnInSub = false ;
   }

   public void S132( )
   {
      /* 'SHOWMESSAGES' Routine */
      returnInSub = false ;
      AV39textoMensaj = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39textoMensaj", AV39textoMensaj);
      AV49GXV1 = 1 ;
      while ( AV49GXV1 <= AV13Mensaje.size() )
      {
         AV14Mensajei = (String)AV13Mensaje.elementAt(-1+AV49GXV1) ;
         AV39textoMensaj += "&#10060; " + AV14Mensajei + "<br>" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39textoMensaj", AV39textoMensaj);
         AV49GXV1 = (int)(AV49GXV1+1) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e146X2( )
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
      pa6X2( ) ;
      ws6X2( ) ;
      we6X2( ) ;
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
      httpContext.AddStyleSheetFile("FileUpload/fileupload.min.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddStyleSheetFile("ChosenGx/chosen.css", "");
      httpContext.AddStyleSheetFile("daterangepicker.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110341020", true, true);
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
      httpContext.AddJavascriptSource("register.js", "?20225110341020", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/UCUserRegisterRender.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/chosen.jquery.js", "", false, true);
      httpContext.AddJavascriptSource("ChosenGx/ChosenGxRender.js", "", false, true);
      httpContext.AddJavascriptSource("daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/UCModalRender.js", "", false, true);
      httpContext.AddJavascriptSource("GXGoogleVisualizationLibrary/GoogleAnalytics/GoogleAnalyticsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbavRctipodoc.setInternalname( "vRCTIPODOC" );
      edtavRcnrodoc_Internalname = "vRCNRODOC" ;
      edtavRcappaterno_Internalname = "vRCAPPATERNO" ;
      edtavRcapmaterno_Internalname = "vRCAPMATERNO" ;
      edtavRcnombres_Internalname = "vRCNOMBRES" ;
      cmbavAnio.setInternalname( "vANIO" );
      cmbavMes.setInternalname( "vMES" );
      cmbavDia.setInternalname( "vDIA" );
      divGroup1table_Internalname = "GROUP1TABLE" ;
      grpGroup1_Internalname = "GROUP1" ;
      dynavPaisid.setInternalname( "vPAISID" );
      cmbavDepartamentocode.setInternalname( "vDEPARTAMENTOCODE" );
      dynavProvinciacode.setInternalname( "vPROVINCIACODE" );
      dynavDistritocode.setInternalname( "vDISTRITOCODE" );
      edtavPacientedireccion_Internalname = "vPACIENTEDIRECCION" ;
      cmbavPacienteenterarse.setInternalname( "vPACIENTEENTERARSE" );
      cmbavRcsexo.setInternalname( "vRCSEXO" );
      edtavRctel_Internalname = "vRCTEL" ;
      edtavRccorreo_Internalname = "vRCCORREO" ;
      edtavRcpassword_Internalname = "vRCPASSWORD" ;
      lblTb_contrasena_Internalname = "TB_CONTRASENA" ;
      chkavAceptacondiciones.setInternalname( "vACEPTACONDICIONES" );
      edtavTextoacepta_Internalname = "vTEXTOACEPTA" ;
      divTableregister_Internalname = "TABLEREGISTER" ;
      bttRegistrar_Internalname = "REGISTRAR" ;
      bttCancelar_Internalname = "CANCELAR" ;
      lblTabpage1_title_Internalname = "TABPAGE1_TITLE" ;
      divSection6_Internalname = "SECTION6" ;
      divTabpage1table_Internalname = "TABPAGE1TABLE" ;
      lblTabpage2_title_Internalname = "TABPAGE2_TITLE" ;
      divSection5_Internalname = "SECTION5" ;
      edtavTpacientepeso_Internalname = "vTPACIENTEPESO" ;
      edtavTpacienteestatura_Internalname = "vTPACIENTEESTATURA" ;
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      Fileupload1_Internalname = "FILEUPLOAD1" ;
      divTabpage2table_Internalname = "TABPAGE2TABLE" ;
      Tab1_Internalname = "TAB1" ;
      divUcuserregister1_registerform_Internalname = "UCUSERREGISTER1_REGISTERFORM" ;
      Ucuserregister1_Internalname = "UCUSERREGISTER1" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      Chosengx1_Internalname = "CHOSENGX1" ;
      edtavTextomensaj_Internalname = "vTEXTOMENSAJ" ;
      divUcmodal1_modalcontent_Internalname = "UCMODAL1_MODALCONTENT" ;
      Ucmodal1_Internalname = "UCMODAL1" ;
      Googleanalytics1_Internalname = "GOOGLEANALYTICS1" ;
      divMaintableregister_Internalname = "MAINTABLEREGISTER" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("Carmine");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      edtavTextomensaj_Backcolor = (int)(0xFFFFFF) ;
      edtavTextomensaj_Enabled = 1 ;
      Ucmodal1_Title = "" ;
      Fileupload1_Tooltiptext = "" ;
      edtavTpacienteestatura_Jsonclick = "" ;
      edtavTpacienteestatura_Enabled = 1 ;
      edtavTpacientepeso_Jsonclick = "" ;
      edtavTpacientepeso_Enabled = 1 ;
      edtavTextoacepta_Jsonclick = "" ;
      edtavTextoacepta_Enabled = 1 ;
      chkavAceptacondiciones.setEnabled( 1 );
      edtavRcpassword_Jsonclick = "" ;
      edtavRcpassword_Enabled = 1 ;
      edtavRccorreo_Jsonclick = "" ;
      edtavRccorreo_Enabled = 1 ;
      edtavRctel_Jsonclick = "" ;
      edtavRctel_Enabled = 1 ;
      cmbavRcsexo.setJsonclick( "" );
      cmbavRcsexo.setEnabled( 1 );
      cmbavPacienteenterarse.setJsonclick( "" );
      cmbavPacienteenterarse.setEnabled( 1 );
      edtavPacientedireccion_Enabled = 1 ;
      dynavDistritocode.setJsonclick( "" );
      dynavDistritocode.setEnabled( 1 );
      dynavProvinciacode.setJsonclick( "" );
      dynavProvinciacode.setEnabled( 1 );
      cmbavDepartamentocode.setJsonclick( "" );
      cmbavDepartamentocode.setEnabled( 1 );
      dynavPaisid.setJsonclick( "" );
      dynavPaisid.setEnabled( 1 );
      cmbavDia.setJsonclick( "" );
      cmbavDia.setEnabled( 1 );
      cmbavMes.setJsonclick( "" );
      cmbavMes.setEnabled( 1 );
      cmbavAnio.setJsonclick( "" );
      cmbavAnio.setEnabled( 1 );
      edtavRcnombres_Jsonclick = "" ;
      edtavRcnombres_Enabled = 1 ;
      edtavRcapmaterno_Jsonclick = "" ;
      edtavRcapmaterno_Enabled = 1 ;
      edtavRcappaterno_Jsonclick = "" ;
      edtavRcappaterno_Enabled = 1 ;
      edtavRcnrodoc_Jsonclick = "" ;
      edtavRcnrodoc_Enabled = 1 ;
      cmbavRctipodoc.setJsonclick( "" );
      cmbavRctipodoc.setEnabled( 1 );
      Googleanalytics1_Domainname = "doctorfast.pe" ;
      Googleanalytics1_Code = "UA-167763435-1" ;
      Googleanalytics1_Height = "1" ;
      Googleanalytics1_Width = "1" ;
      Ucmodal1_Btnbackstyle = "dfs-blue" ;
      Ucmodal1_Id = "ModalMensajes" ;
      Chosengx1_Emptyitem = "Seleccione" ;
      Dvmessage1_Defaultmessagetype = "error" ;
      Tab1_Historymanagement = GXutil.toBoolean( 0) ;
      Tab1_Class = "Tab" ;
      Tab1_Pagecount = 2 ;
      Fileupload1_Autodisableaddingfiles = GXutil.toBoolean( -1) ;
      Fileupload1_Maxnumberoffiles = 1 ;
      Fileupload1_Autoupload = GXutil.toBoolean( -1) ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavRctipodoc.setName( "vRCTIPODOC" );
      cmbavRctipodoc.setWebtags( "" );
      cmbavRctipodoc.addItem("1", "DNI", (short)(0));
      cmbavRctipodoc.addItem("6", "RUC", (short)(0));
      cmbavRctipodoc.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavRctipodoc.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavRctipodoc.addItem("7", "PASAPORTE", (short)(0));
      cmbavRctipodoc.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavRctipodoc.getItemCount() > 0 )
      {
         AV34RCTipoDoc = cmbavRctipodoc.getValidValue(AV34RCTipoDoc) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34RCTipoDoc", AV34RCTipoDoc);
      }
      cmbavAnio.setName( "vANIO" );
      cmbavAnio.setWebtags( "" );
      if ( cmbavAnio.getItemCount() > 0 )
      {
         AV6Anio = (short)(GXutil.lval( cmbavAnio.getValidValue(GXutil.trim( GXutil.str( AV6Anio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6Anio), 4, 0));
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
         AV8Dia = (byte)(GXutil.lval( cmbavDia.getValidValue(GXutil.trim( GXutil.str( AV8Dia, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Dia), 2, 0));
      }
      dynavPaisid.setName( "vPAISID" );
      dynavPaisid.setWebtags( "" );
      dynavPaisid.removeAllItems();
      /* Using cursor H006X6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         dynavPaisid.addItem(GXutil.trim( GXutil.str( H006X6_A43PaisId[0], 4, 0)), H006X6_A184PaisDescripcion[0], (short)(0));
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( dynavPaisid.getItemCount() > 0 )
      {
         AV21PaisId = (short)(GXutil.lval( dynavPaisid.getValidValue(GXutil.trim( GXutil.str( AV21PaisId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21PaisId), 4, 0));
      }
      cmbavDepartamentocode.setName( "vDEPARTAMENTOCODE" );
      cmbavDepartamentocode.setWebtags( "" );
      cmbavDepartamentocode.addItem("", "Seleccione", (short)(0));
      if ( cmbavDepartamentocode.getItemCount() > 0 )
      {
         AV7DepartamentoCode = cmbavDepartamentocode.getValidValue(AV7DepartamentoCode) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7DepartamentoCode", AV7DepartamentoCode);
      }
      dynavProvinciacode.setName( "vPROVINCIACODE" );
      dynavProvinciacode.setWebtags( "" );
      dynavDistritocode.setName( "vDISTRITOCODE" );
      dynavDistritocode.setWebtags( "" );
      cmbavPacienteenterarse.setName( "vPACIENTEENTERARSE" );
      cmbavPacienteenterarse.setWebtags( "" );
      cmbavPacienteenterarse.addItem("", "Seleccione una opción", (short)(0));
      cmbavPacienteenterarse.addItem("F", "Facebook", (short)(0));
      cmbavPacienteenterarse.addItem("G", "Búsqueda en Google", (short)(0));
      cmbavPacienteenterarse.addItem("T", "Twitter", (short)(0));
      cmbavPacienteenterarse.addItem("I", "Instagram", (short)(0));
      cmbavPacienteenterarse.addItem("L", "Linked In", (short)(0));
      cmbavPacienteenterarse.addItem("C", "Mediante conocido o familiar", (short)(0));
      cmbavPacienteenterarse.addItem("O", "Otros", (short)(0));
      if ( cmbavPacienteenterarse.getItemCount() > 0 )
      {
         AV18PacienteEnterarse = cmbavPacienteenterarse.getValidValue(AV18PacienteEnterarse) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18PacienteEnterarse", AV18PacienteEnterarse);
      }
      cmbavRcsexo.setName( "vRCSEXO" );
      cmbavRcsexo.setWebtags( "" );
      cmbavRcsexo.addItem("M", "Masculino", (short)(0));
      cmbavRcsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavRcsexo.getItemCount() > 0 )
      {
         AV32RCSexo = cmbavRcsexo.getValidValue(AV32RCSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV32RCSexo", AV32RCSexo);
      }
      chkavAceptacondiciones.setName( "vACEPTACONDICIONES" );
      chkavAceptacondiciones.setWebtags( "" );
      chkavAceptacondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavAceptacondiciones.getInternalname(), "TitleCaption", chkavAceptacondiciones.getCaption(), true);
      chkavAceptacondiciones.setCheckedValue( "false" );
      AV5AceptaCondiciones = GXutil.strtobool( GXutil.booltostr( AV5AceptaCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AceptaCondiciones", AV5AceptaCondiciones);
      /* End function init_web_controls */
   }

   public void validv_Departamentocode( )
   {
      AV7DepartamentoCode = cmbavDepartamentocode.getValue() ;
      AV23ProvinciaCode = dynavProvinciacode.getValue() ;
      AV9DistritoCode = dynavDistritocode.getValue() ;
      AV21PaisId = (short)(GXutil.lval( dynavPaisid.getValue())) ;
      gxvvprovinciacode_html6X2( AV7DepartamentoCode) ;
      gxvvdistritocode_html6X2( AV7DepartamentoCode, AV23ProvinciaCode) ;
      dynload_actions( ) ;
      if ( dynavProvinciacode.getItemCount() > 0 )
      {
         AV23ProvinciaCode = dynavProvinciacode.getValidValue(AV23ProvinciaCode) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProvinciacode.setValue( GXutil.rtrim( AV23ProvinciaCode) );
      }
      if ( dynavDistritocode.getItemCount() > 0 )
      {
         AV9DistritoCode = dynavDistritocode.getValidValue(AV9DistritoCode) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDistritocode.setValue( GXutil.rtrim( AV9DistritoCode) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV23ProvinciaCode", AV23ProvinciaCode);
      dynavProvinciacode.setValue( GXutil.rtrim( AV23ProvinciaCode) );
      httpContext.ajax_rsp_assign_prop("", false, dynavProvinciacode.getInternalname(), "Values", dynavProvinciacode.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV9DistritoCode", AV9DistritoCode);
      dynavDistritocode.setValue( GXutil.rtrim( AV9DistritoCode) );
      httpContext.ajax_rsp_assign_prop("", false, dynavDistritocode.getInternalname(), "Values", dynavDistritocode.ToJavascriptSource(), true);
   }

   public void validv_Provinciacode( )
   {
      AV7DepartamentoCode = cmbavDepartamentocode.getValue() ;
      AV23ProvinciaCode = dynavProvinciacode.getValue() ;
      AV9DistritoCode = dynavDistritocode.getValue() ;
      AV21PaisId = (short)(GXutil.lval( dynavPaisid.getValue())) ;
      gxvvdistritocode_html6X2( AV7DepartamentoCode, AV23ProvinciaCode) ;
      dynload_actions( ) ;
      if ( dynavDistritocode.getItemCount() > 0 )
      {
         AV9DistritoCode = dynavDistritocode.getValidValue(AV9DistritoCode) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDistritocode.setValue( GXutil.rtrim( AV9DistritoCode) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV9DistritoCode", AV9DistritoCode);
      dynavDistritocode.setValue( GXutil.rtrim( AV9DistritoCode) );
      httpContext.ajax_rsp_assign_prop("", false, dynavDistritocode.getInternalname(), "Values", dynavDistritocode.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("'REGISTRAR'","{handler:'e116X1',iparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("'REGISTRAR'",",oparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("'CANCELAR'","{handler:'e136X2',iparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("'CANCELAR'",",oparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_RCTIPODOC","{handler:'validv_Rctipodoc',iparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_RCTIPODOC",",oparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_MES","{handler:'validv_Mes',iparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_MES",",oparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_DEPARTAMENTOCODE","{handler:'validv_Departamentocode',iparms:[{av:'cmbavDepartamentocode'},{av:'AV7DepartamentoCode',fld:'vDEPARTAMENTOCODE',pic:''},{av:'dynavProvinciacode'},{av:'AV23ProvinciaCode',fld:'vPROVINCIACODE',pic:''},{av:'dynavDistritocode'},{av:'AV9DistritoCode',fld:'vDISTRITOCODE',pic:''},{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_DEPARTAMENTOCODE",",oparms:[{av:'dynavProvinciacode'},{av:'AV23ProvinciaCode',fld:'vPROVINCIACODE',pic:''},{av:'dynavDistritocode'},{av:'AV9DistritoCode',fld:'vDISTRITOCODE',pic:''},{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PROVINCIACODE","{handler:'validv_Provinciacode',iparms:[{av:'cmbavDepartamentocode'},{av:'AV7DepartamentoCode',fld:'vDEPARTAMENTOCODE',pic:''},{av:'dynavProvinciacode'},{av:'AV23ProvinciaCode',fld:'vPROVINCIACODE',pic:''},{av:'dynavDistritocode'},{av:'AV9DistritoCode',fld:'vDISTRITOCODE',pic:''},{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PROVINCIACODE",",oparms:[{av:'dynavDistritocode'},{av:'AV9DistritoCode',fld:'vDISTRITOCODE',pic:''},{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_PACIENTEENTERARSE","{handler:'validv_Pacienteenterarse',iparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_PACIENTEENTERARSE",",oparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_RCSEXO","{handler:'validv_Rcsexo',iparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_RCSEXO",",oparms:[{av:'dynavPaisid'},{av:'AV21PaisId',fld:'vPAISID',pic:'ZZZ9'},{av:'AV5AceptaCondiciones',fld:'vACEPTACONDICIONES',pic:''}]}");
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
      AV7DepartamentoCode = "" ;
      AV23ProvinciaCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV44UploadedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucUcuserregister1 = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV34RCTipoDoc = "" ;
      AV29RCNroDoc = "" ;
      AV25RCApPaterno = "" ;
      AV24RCApMaterno = "" ;
      AV28RCNombres = "" ;
      AV15Mes = "" ;
      AV9DistritoCode = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV17PacienteDireccion = "" ;
      AV18PacienteEnterarse = "" ;
      AV32RCSexo = "" ;
      AV33RCTel = "" ;
      AV26RCCorreo = "" ;
      AV30RCPassword = "" ;
      lblTb_contrasena_Jsonclick = "" ;
      AV38textoAcepta = "" ;
      bttRegistrar_Jsonclick = "" ;
      bttCancelar_Jsonclick = "" ;
      ucTab1 = new com.genexus.webpanels.GXUserControl();
      lblTabpage1_title_Jsonclick = "" ;
      lblTabpage2_title_Jsonclick = "" ;
      AV41tPacientePeso = DecimalUtil.ZERO ;
      AV40tPacienteEstatura = DecimalUtil.ZERO ;
      lblTextblock1_Jsonclick = "" ;
      ucFileupload1 = new com.genexus.webpanels.GXUserControl();
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      ucChosengx1 = new com.genexus.webpanels.GXUserControl();
      ucUcmodal1 = new com.genexus.webpanels.GXUserControl();
      AV39textoMensaj = "" ;
      ucGoogleanalytics1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H006X2_A43PaisId = new short[1] ;
      H006X2_A184PaisDescripcion = new String[] {""} ;
      H006X3_A44UbigeoCode = new String[] {""} ;
      H006X3_A187UbigeoProvincia = new String[] {""} ;
      H006X3_A296UbigeoProvinciaCode = new String[] {""} ;
      H006X3_A295UbigeoDepartamentoCode = new String[] {""} ;
      H006X4_A44UbigeoCode = new String[] {""} ;
      H006X4_A188UbigeoDistrito = new String[] {""} ;
      H006X4_A297UbigeoDistritoCode = new String[] {""} ;
      H006X4_A295UbigeoDepartamentoCode = new String[] {""} ;
      H006X4_A296UbigeoProvinciaCode = new String[] {""} ;
      H006X5_A43PaisId = new short[1] ;
      H006X5_A184PaisDescripcion = new String[] {""} ;
      AV13Mensaje = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14Mensajei = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      H006X6_A43PaisId = new short[1] ;
      H006X6_A184PaisDescripcion = new String[] {""} ;
      ZV23ProvinciaCode = "" ;
      ZV9DistritoCode = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.register__default(),
         new Object[] {
             new Object[] {
            H006X2_A43PaisId, H006X2_A184PaisDescripcion
            }
            , new Object[] {
            H006X3_A44UbigeoCode, H006X3_A187UbigeoProvincia, H006X3_A296UbigeoProvinciaCode, H006X3_A295UbigeoDepartamentoCode
            }
            , new Object[] {
            H006X4_A44UbigeoCode, H006X4_A188UbigeoDistrito, H006X4_A297UbigeoDistritoCode, H006X4_A295UbigeoDepartamentoCode, H006X4_A296UbigeoProvinciaCode
            }
            , new Object[] {
            H006X5_A43PaisId, H006X5_A184PaisDescripcion
            }
            , new Object[] {
            H006X6_A43PaisId, H006X6_A184PaisDescripcion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavTextoacepta_Enabled = 0 ;
      edtavTextomensaj_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte AV8Dia ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short AV6Anio ;
   private short AV21PaisId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Fileupload1_Maxnumberoffiles ;
   private int Tab1_Pagecount ;
   private int edtavRcnrodoc_Enabled ;
   private int edtavRcappaterno_Enabled ;
   private int edtavRcapmaterno_Enabled ;
   private int edtavRcnombres_Enabled ;
   private int edtavPacientedireccion_Enabled ;
   private int edtavRctel_Enabled ;
   private int edtavRccorreo_Enabled ;
   private int edtavRcpassword_Enabled ;
   private int edtavTextoacepta_Enabled ;
   private int edtavTpacientepeso_Enabled ;
   private int edtavTpacienteestatura_Enabled ;
   private int edtavTextomensaj_Enabled ;
   private int gxdynajaxindex ;
   private int AV49GXV1 ;
   private int idxLst ;
   private int edtavTextomensaj_Backcolor ;
   private java.math.BigDecimal AV41tPacientePeso ;
   private java.math.BigDecimal AV40tPacienteEstatura ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Tab1_Class ;
   private String Dvmessage1_Defaultmessagetype ;
   private String Chosengx1_Emptyitem ;
   private String Ucmodal1_Id ;
   private String Ucmodal1_Btnbackstyle ;
   private String Googleanalytics1_Width ;
   private String Googleanalytics1_Height ;
   private String Googleanalytics1_Code ;
   private String Googleanalytics1_Domainname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintableregister_Internalname ;
   private String Ucuserregister1_Internalname ;
   private String divUcuserregister1_registerform_Internalname ;
   private String divTableregister_Internalname ;
   private String TempTags ;
   private String AV34RCTipoDoc ;
   private String edtavRcnrodoc_Internalname ;
   private String edtavRcnrodoc_Jsonclick ;
   private String edtavRcappaterno_Internalname ;
   private String edtavRcappaterno_Jsonclick ;
   private String edtavRcapmaterno_Internalname ;
   private String edtavRcapmaterno_Jsonclick ;
   private String edtavRcnombres_Internalname ;
   private String edtavRcnombres_Jsonclick ;
   private String grpGroup1_Internalname ;
   private String divGroup1table_Internalname ;
   private String edtavPacientedireccion_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String AV32RCSexo ;
   private String edtavRctel_Internalname ;
   private String edtavRctel_Jsonclick ;
   private String edtavRccorreo_Internalname ;
   private String edtavRccorreo_Jsonclick ;
   private String edtavRcpassword_Internalname ;
   private String edtavRcpassword_Jsonclick ;
   private String lblTb_contrasena_Internalname ;
   private String lblTb_contrasena_Jsonclick ;
   private String edtavTextoacepta_Internalname ;
   private String edtavTextoacepta_Jsonclick ;
   private String bttRegistrar_Internalname ;
   private String bttRegistrar_Jsonclick ;
   private String bttCancelar_Internalname ;
   private String bttCancelar_Jsonclick ;
   private String Tab1_Internalname ;
   private String lblTabpage1_title_Internalname ;
   private String lblTabpage1_title_Jsonclick ;
   private String divTabpage1table_Internalname ;
   private String divSection6_Internalname ;
   private String lblTabpage2_title_Internalname ;
   private String lblTabpage2_title_Jsonclick ;
   private String divTabpage2table_Internalname ;
   private String divSection5_Internalname ;
   private String edtavTpacientepeso_Internalname ;
   private String edtavTpacientepeso_Jsonclick ;
   private String edtavTpacienteestatura_Internalname ;
   private String edtavTpacienteestatura_Jsonclick ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String Fileupload1_Tooltiptext ;
   private String Fileupload1_Internalname ;
   private String Dvmessage1_Internalname ;
   private String Chosengx1_Internalname ;
   private String Ucmodal1_Title ;
   private String Ucmodal1_Internalname ;
   private String divUcmodal1_modalcontent_Internalname ;
   private String edtavTextomensaj_Internalname ;
   private String Googleanalytics1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Fileupload1_Autoupload ;
   private boolean Fileupload1_Autodisableaddingfiles ;
   private boolean Tab1_Historymanagement ;
   private boolean wbLoad ;
   private boolean AV5AceptaCondiciones ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV7DepartamentoCode ;
   private String AV23ProvinciaCode ;
   private String AV29RCNroDoc ;
   private String AV25RCApPaterno ;
   private String AV24RCApMaterno ;
   private String AV28RCNombres ;
   private String AV15Mes ;
   private String AV9DistritoCode ;
   private String AV17PacienteDireccion ;
   private String AV18PacienteEnterarse ;
   private String AV33RCTel ;
   private String AV26RCCorreo ;
   private String AV30RCPassword ;
   private String AV38textoAcepta ;
   private String AV39textoMensaj ;
   private String AV14Mensajei ;
   private String ZV23ProvinciaCode ;
   private String ZV9DistritoCode ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucUcuserregister1 ;
   private com.genexus.webpanels.GXUserControl ucTab1 ;
   private com.genexus.webpanels.GXUserControl ucFileupload1 ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.webpanels.GXUserControl ucChosengx1 ;
   private com.genexus.webpanels.GXUserControl ucUcmodal1 ;
   private com.genexus.webpanels.GXUserControl ucGoogleanalytics1 ;
   private GXSimpleCollection<String> AV13Mensaje ;
   private HTMLChoice cmbavRctipodoc ;
   private HTMLChoice cmbavAnio ;
   private HTMLChoice cmbavMes ;
   private HTMLChoice cmbavDia ;
   private HTMLChoice dynavPaisid ;
   private HTMLChoice cmbavDepartamentocode ;
   private HTMLChoice dynavProvinciacode ;
   private HTMLChoice dynavDistritocode ;
   private HTMLChoice cmbavPacienteenterarse ;
   private HTMLChoice cmbavRcsexo ;
   private ICheckbox chkavAceptacondiciones ;
   private IDataStoreProvider pr_default ;
   private short[] H006X2_A43PaisId ;
   private String[] H006X2_A184PaisDescripcion ;
   private String[] H006X3_A44UbigeoCode ;
   private String[] H006X3_A187UbigeoProvincia ;
   private String[] H006X3_A296UbigeoProvinciaCode ;
   private String[] H006X3_A295UbigeoDepartamentoCode ;
   private String[] H006X4_A44UbigeoCode ;
   private String[] H006X4_A188UbigeoDistrito ;
   private String[] H006X4_A297UbigeoDistritoCode ;
   private String[] H006X4_A295UbigeoDepartamentoCode ;
   private String[] H006X4_A296UbigeoProvinciaCode ;
   private short[] H006X5_A43PaisId ;
   private String[] H006X5_A184PaisDescripcion ;
   private short[] H006X6_A43PaisId ;
   private String[] H006X6_A184PaisDescripcion ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV44UploadedFiles ;
}

final  class register__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H006X2", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006X3", "SELECT [UbigeoCode], [UbigeoProvincia], SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode FROM [Ubigeo] WHERE SUBSTRING([UbigeoCode], 1, 2) = ? ORDER BY [UbigeoProvincia] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006X4", "SELECT [UbigeoCode], [UbigeoDistrito], SUBSTRING([UbigeoCode], 5, 2) AS UbigeoDistritoCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode FROM [Ubigeo] WHERE (SUBSTRING([UbigeoCode], 1, 2) = ?) AND (SUBSTRING([UbigeoCode], 3, 2) = ?) ORDER BY [UbigeoDistrito] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006X5", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H006X6", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
      }
   }

}

