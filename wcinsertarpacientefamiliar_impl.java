package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wcinsertarpacientefamiliar_impl extends GXWebComponent
{
   public wcinsertarpacientefamiliar_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wcinsertarpacientefamiliar_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wcinsertarpacientefamiliar_impl.class ));
   }

   public wcinsertarpacientefamiliar_impl( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
      cmbavFamiliartipodocumento = new HTMLChoice();
      cmbavFamiliarsexo = new HTMLChoice();
      cmbavFamiliarparentesco = new HTMLChoice();
      dynavFamiliarpais = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vFAMILIARPAIS") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvvfamiliarpais4Z2( ) ;
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
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa4Z2( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
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
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( "WCInsertar Paciente Familiar") ;
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
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325423", false, true);
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
      if ( GXutil.len( sPrefix) == 0 )
      {
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wcinsertarpacientefamiliar", new String[] {}, new String[] {}) +"\">") ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
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
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMENSAJE", AV21Mensaje);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMENSAJE", AV21Mensaje);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vPACIENTE", AV23Paciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vPACIENTE", AV23Paciente);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vPACIENTEFAMILIAR", AV24PacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vPACIENTEFAMILIAR", AV24PacienteFamiliar);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PACIENTEID", GXutil.ltrim( localUtil.ntoc( A40000PacienteId, (byte)(8), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm4Z2( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
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
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "WCInsertarPacienteFamiliar" ;
   }

   public String getPgmdesc( )
   {
      return "WCInsertar Paciente Familiar" ;
   }

   public void wb4Z0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.wcinsertarpacientefamiliar");
            httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
         }
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableinsert_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSection2_Internalname, 1, 0, "px", 0, "px", "SeccionCitas", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitleinsertf_Internalname, "Ingrese los siguientes datos para realizar el registro del familiar.", "", "", lblTextblocktitleinsertf_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlockCitas", 0, "", 1, 1, 0, (short)(0), "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable7_Internalname, 1, 0, "px", 0, "px", "TableInsertEditFamiliar", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupinfogeneral_Internalname, "INFORMACIÓN GENERAL", 1, 0, "px", 0, "px", "GroupInfoGenAsociadoPaciente", "", "HLP_WCInsertarPacienteFamiliar.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFamiliartipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavFamiliartipodocumento.getInternalname(), "Tipo Documento", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFamiliartipodocumento, cmbavFamiliartipodocumento.getInternalname(), GXutil.rtrim( AV19FamiliarTipoDocumento), 1, cmbavFamiliartipodocumento.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFamiliartipodocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "", true, (byte)(1), "HLP_WCInsertarPacienteFamiliar.htm");
         cmbavFamiliartipodocumento.setValue( GXutil.rtrim( AV19FamiliarTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliartipodocumento.getInternalname(), "Values", cmbavFamiliartipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliarnrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliarnrodocumento_Internalname, "Nro Documento", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliarnrodocumento_Internalname, AV14FamiliarNroDocumento, GXutil.rtrim( localUtil.format( AV14FamiliarNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliarnrodocumento_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliarnrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliarnombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliarnombres_Internalname, "Nombres", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliarnombres_Internalname, AV13FamiliarNombres, GXutil.rtrim( localUtil.format( AV13FamiliarNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,36);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliarnombres_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliarnombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliarapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliarapellidopaterno_Internalname, "Apellido Paterno", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliarapellidopaterno_Internalname, AV9FamiliarApellidoPaterno, GXutil.rtrim( localUtil.format( AV9FamiliarApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,41);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliarapellidopaterno_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliarapellidopaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliarapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliarapellidomaterno_Internalname, "Apellido Materno", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliarapellidomaterno_Internalname, AV8FamiliarApellidoMaterno, GXutil.rtrim( localUtil.format( AV8FamiliarApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliarapellidomaterno_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliarapellidomaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliarfechanacimiento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliarfechanacimiento_Internalname, "Fecha Nacimiento", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavFamiliarfechanacimiento_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliarfechanacimiento_Internalname, localUtil.format(AV12FamiliarFechaNacimiento, "99/99/99"), localUtil.format( AV12FamiliarFechaNacimiento, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,49);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliarfechanacimiento_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliarfechanacimiento_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavFamiliarfechanacimiento_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavFamiliarfechanacimiento_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WCInsertarPacienteFamiliar.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFamiliarsexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavFamiliarsexo.getInternalname(), "Sexo", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFamiliarsexo, cmbavFamiliarsexo.getInternalname(), GXutil.rtrim( AV18FamiliarSexo), 1, cmbavFamiliarsexo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFamiliarsexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,54);\"", "", true, (byte)(1), "HLP_WCInsertarPacienteFamiliar.htm");
         cmbavFamiliarsexo.setValue( GXutil.rtrim( AV18FamiliarSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliarsexo.getInternalname(), "Values", cmbavFamiliarsexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFamiliarparentesco.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavFamiliarparentesco.getInternalname(), "Parentesco", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFamiliarparentesco, cmbavFamiliarparentesco.getInternalname(), GXutil.rtrim( AV16FamiliarParentesco), 1, cmbavFamiliarparentesco.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFamiliarparentesco.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(1), "HLP_WCInsertarPacienteFamiliar.htm");
         cmbavFamiliarparentesco.setValue( GXutil.rtrim( AV16FamiliarParentesco) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliarparentesco.getInternalname(), "Values", cmbavFamiliarparentesco.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavFamiliarpais.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavFamiliarpais.getInternalname(), "Nacionalidad", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavFamiliarpais, dynavFamiliarpais.getInternalname(), GXutil.trim( GXutil.str( AV15FamiliarPais, 4, 0)), 1, dynavFamiliarpais.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavFamiliarpais.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", true, (byte)(1), "HLP_WCInsertarPacienteFamiliar.htm");
         dynavFamiliarpais.setValue( GXutil.trim( GXutil.str( AV15FamiliarPais, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavFamiliarpais.getInternalname(), "Values", dynavFamiliarpais.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliarestatura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliarestatura_Internalname, "Estatura", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliarestatura_Internalname, GXutil.ltrim( localUtil.ntoc( AV11FamiliarEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtavFamiliarestatura_Enabled!=0) ? localUtil.format( AV11FamiliarEstatura, "9.99") : localUtil.format( AV11FamiliarEstatura, "9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,67);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliarestatura_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliarestatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliarpeso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliarpeso_Internalname, "Peso", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliarpeso_Internalname, GXutil.ltrim( localUtil.ntoc( AV17FamiliarPeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtavFamiliarpeso_Enabled!=0) ? localUtil.format( AV17FamiliarPeso, "ZZ9.99") : localUtil.format( AV17FamiliarPeso, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,71);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliarpeso_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliarpeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCInsertarPacienteFamiliar.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonNuevoFamiliar" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttRegistrar_Internalname, "", "Registrar", bttRegistrar_Jsonclick, 5, "Registrar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'REGISTRAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WCInsertarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonNuevoFamiliar" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar_Internalname, "", "Cancelar", bttCancelar_Jsonclick, 5, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'CANCELAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WCInsertarPacienteFamiliar.htm");
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
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, sPrefix+"DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start4Z2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_7-156546", (short)(0)) ;
            }
            Form.getMeta().addItem("description", "WCInsertar Paciente Familiar", (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strup4Z0( ) ;
         }
      }
   }

   public void ws4Z2( )
   {
      start4Z2( ) ;
      evt4Z2( ) ;
   }

   public void evt4Z2( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
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
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'REGISTRAR'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'Registrar' */
                                 e114Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VFAMILIARNRODOCUMENTO.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e124Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e134Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e144Z2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "'CANCELAR'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Z0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = cmbavFamiliartipodocumento.getInternalname() ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
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

   public void we4Z2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4Z2( ) ;
         }
      }
   }

   public void pa4Z2( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = cmbavFamiliartipodocumento.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvfamiliarpais4Z2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvfamiliarpais_data4Z2( ) ;
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

   public void gxvvfamiliarpais_html4Z2( )
   {
      short gxdynajaxvalue;
      gxdlvvfamiliarpais_data4Z2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavFamiliarpais.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavFamiliarpais.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvfamiliarpais_data4Z2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H004Z2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H004Z2_A43PaisId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H004Z2_A184PaisDescripcion[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvfamiliarpais_html4Z2( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavFamiliartipodocumento.getItemCount() > 0 )
      {
         AV19FamiliarTipoDocumento = cmbavFamiliartipodocumento.getValidValue(AV19FamiliarTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19FamiliarTipoDocumento", AV19FamiliarTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFamiliartipodocumento.setValue( GXutil.rtrim( AV19FamiliarTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliartipodocumento.getInternalname(), "Values", cmbavFamiliartipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavFamiliarsexo.getItemCount() > 0 )
      {
         AV18FamiliarSexo = cmbavFamiliarsexo.getValidValue(AV18FamiliarSexo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18FamiliarSexo", AV18FamiliarSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFamiliarsexo.setValue( GXutil.rtrim( AV18FamiliarSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliarsexo.getInternalname(), "Values", cmbavFamiliarsexo.ToJavascriptSource(), true);
      }
      if ( cmbavFamiliarparentesco.getItemCount() > 0 )
      {
         AV16FamiliarParentesco = cmbavFamiliarparentesco.getValidValue(AV16FamiliarParentesco) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FamiliarParentesco", AV16FamiliarParentesco);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFamiliarparentesco.setValue( GXutil.rtrim( AV16FamiliarParentesco) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliarparentesco.getInternalname(), "Values", cmbavFamiliarparentesco.ToJavascriptSource(), true);
      }
      if ( dynavFamiliarpais.getItemCount() > 0 )
      {
         AV15FamiliarPais = (short)(GXutil.lval( dynavFamiliarpais.getValidValue(GXutil.trim( GXutil.str( AV15FamiliarPais, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15FamiliarPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15FamiliarPais), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavFamiliarpais.setValue( GXutil.trim( GXutil.str( AV15FamiliarPais, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavFamiliarpais.getInternalname(), "Values", dynavFamiliarpais.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf4Z2( ) ;
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

   public void rf4Z2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e144Z2 ();
         wb4Z0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4Z2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      gxvvfamiliarpais_html4Z2( ) ;
      /* Using cursor H004Z4 */
      pr_default.execute(1, new Object[] {AV14FamiliarNroDocumento});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40000PacienteId = H004Z4_A40000PacienteId[0] ;
         n40000PacienteId = H004Z4_n40000PacienteId[0] ;
      }
      else
      {
         A40000PacienteId = 0 ;
         n40000PacienteId = false ;
      }
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup4Z0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e134Z2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         cmbavFamiliartipodocumento.setValue( httpContext.cgiGet( cmbavFamiliartipodocumento.getInternalname()) );
         AV19FamiliarTipoDocumento = httpContext.cgiGet( cmbavFamiliartipodocumento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV19FamiliarTipoDocumento", AV19FamiliarTipoDocumento);
         AV14FamiliarNroDocumento = httpContext.cgiGet( edtavFamiliarnrodocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14FamiliarNroDocumento", AV14FamiliarNroDocumento);
         AV13FamiliarNombres = httpContext.cgiGet( edtavFamiliarnombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13FamiliarNombres", AV13FamiliarNombres);
         AV9FamiliarApellidoPaterno = httpContext.cgiGet( edtavFamiliarapellidopaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9FamiliarApellidoPaterno", AV9FamiliarApellidoPaterno);
         AV8FamiliarApellidoMaterno = httpContext.cgiGet( edtavFamiliarapellidomaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8FamiliarApellidoMaterno", AV8FamiliarApellidoMaterno);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavFamiliarfechanacimiento_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vFAMILIARFECHANACIMIENTO");
            GX_FocusControl = edtavFamiliarfechanacimiento_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12FamiliarFechaNacimiento = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12FamiliarFechaNacimiento", localUtil.format(AV12FamiliarFechaNacimiento, "99/99/99"));
         }
         else
         {
            AV12FamiliarFechaNacimiento = localUtil.ctod( httpContext.cgiGet( edtavFamiliarfechanacimiento_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12FamiliarFechaNacimiento", localUtil.format(AV12FamiliarFechaNacimiento, "99/99/99"));
         }
         cmbavFamiliarsexo.setValue( httpContext.cgiGet( cmbavFamiliarsexo.getInternalname()) );
         AV18FamiliarSexo = httpContext.cgiGet( cmbavFamiliarsexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18FamiliarSexo", AV18FamiliarSexo);
         cmbavFamiliarparentesco.setValue( httpContext.cgiGet( cmbavFamiliarparentesco.getInternalname()) );
         AV16FamiliarParentesco = httpContext.cgiGet( cmbavFamiliarparentesco.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16FamiliarParentesco", AV16FamiliarParentesco);
         dynavFamiliarpais.setValue( httpContext.cgiGet( dynavFamiliarpais.getInternalname()) );
         AV15FamiliarPais = (short)(GXutil.lval( httpContext.cgiGet( dynavFamiliarpais.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15FamiliarPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15FamiliarPais), 4, 0));
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavFamiliarestatura_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavFamiliarestatura_Internalname)), DecimalUtil.stringToDec("9.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vFAMILIARESTATURA");
            GX_FocusControl = edtavFamiliarestatura_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11FamiliarEstatura = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FamiliarEstatura", GXutil.ltrimstr( AV11FamiliarEstatura, 4, 2));
         }
         else
         {
            AV11FamiliarEstatura = localUtil.ctond( httpContext.cgiGet( edtavFamiliarestatura_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FamiliarEstatura", GXutil.ltrimstr( AV11FamiliarEstatura, 4, 2));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavFamiliarpeso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavFamiliarpeso_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vFAMILIARPESO");
            GX_FocusControl = edtavFamiliarpeso_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV17FamiliarPeso = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17FamiliarPeso", GXutil.ltrimstr( AV17FamiliarPeso, 6, 2));
         }
         else
         {
            AV17FamiliarPeso = localUtil.ctond( httpContext.cgiGet( edtavFamiliarpeso_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17FamiliarPeso", GXutil.ltrimstr( AV17FamiliarPeso, 6, 2));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvvfamiliarpais_html4Z2( ) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   public void S122( )
   {
      /* 'GUARDARFAMILIAR' Routine */
      returnInSub = false ;
      AV23Paciente.setgxTv_SdtPaciente_Pacientenombres( AV13FamiliarNombres );
      AV23Paciente.setgxTv_SdtPaciente_Pacienteapellidopaterno( AV9FamiliarApellidoPaterno );
      AV23Paciente.setgxTv_SdtPaciente_Pacienteapellidomaterno( AV8FamiliarApellidoMaterno );
      AV23Paciente.setgxTv_SdtPaciente_Pacientetipodocumento( AV19FamiliarTipoDocumento );
      AV23Paciente.setgxTv_SdtPaciente_Pacientenrodocumento( GXutil.trim( AV14FamiliarNroDocumento) );
      AV23Paciente.setgxTv_SdtPaciente_Pacientefechanacimiento( AV12FamiliarFechaNacimiento );
      AV23Paciente.setgxTv_SdtPaciente_Pacientesexo( AV18FamiliarSexo );
      AV23Paciente.setgxTv_SdtPaciente_Paisid( AV15FamiliarPais );
      AV23Paciente.setgxTv_SdtPaciente_Pacienteestado( "A" );
      AV23Paciente.setgxTv_SdtPaciente_Secuserid_SetNull();
      AV23Paciente.setgxTv_SdtPaciente_Ubigeocode( "150101" );
      AV23Paciente.setgxTv_SdtPaciente_Pacientepeso( AV17FamiliarPeso );
      AV23Paciente.setgxTv_SdtPaciente_Pacienteestatura( AV11FamiliarEstatura );
      AV23Paciente.Save();
      if ( AV23Paciente.Success() )
      {
         AV5PacienteId = (int)(GXutil.lval( AV6WebSession.getValue("WSPacienteId"))) ;
         AV24PacienteFamiliar.setgxTv_SdtPacienteFamiliar_Pacienteid( AV5PacienteId );
         AV24PacienteFamiliar.setgxTv_SdtPacienteFamiliar_Sgpacientehijopacienteid( AV23Paciente.getgxTv_SdtPaciente_Pacienteid() );
         AV24PacienteFamiliar.setgxTv_SdtPacienteFamiliar_Pacientefamiliarparentesco( AV16FamiliarParentesco );
         AV24PacienteFamiliar.setgxTv_SdtPacienteFamiliar_Pacientefamiliarestado( "A" );
         AV24PacienteFamiliar.Save();
         if ( AV24PacienteFamiliar.Success() )
         {
            Application.commitDataStores(context, remoteHandle, pr_default, "wcinsertarpacientefamiliar");
            this.executeExternalObjectMethod(sPrefix, false, "AV29SweetAlert", "successAlert", new Object[] {"success","El familiar se registro correctamente.",""}, false);
            this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "RegresarWebComponet", new Object[] {"Familiar"}, true);
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "wcinsertarpacientefamiliar");
            this.executeExternalObjectMethod(sPrefix, false, "AV29SweetAlert", "successAlert", new Object[] {"error","Ocurrió un error, por favor intente nuevamente",""}, false);
         }
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wcinsertarpacientefamiliar");
         this.executeExternalObjectMethod(sPrefix, false, "AV29SweetAlert", "successAlert", new Object[] {"error","Ocurrió un error, por favor intente nuevamente",""}, false);
      }
   }

   public void e114Z2( )
   {
      /* 'Registrar' Routine */
      returnInSub = false ;
      /* Using cursor H004Z6 */
      pr_default.execute(2, new Object[] {AV14FamiliarNroDocumento});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A40000PacienteId = H004Z6_A40000PacienteId[0] ;
         n40000PacienteId = H004Z6_n40000PacienteId[0] ;
      }
      else
      {
         A40000PacienteId = 0 ;
         n40000PacienteId = false ;
      }
      pr_default.close(2);
      AV21Mensaje.clear();
      if ( ( GXutil.strcmp(GXutil.trim( AV9FamiliarApellidoPaterno), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV8FamiliarApellidoMaterno), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV13FamiliarNombres), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV14FamiliarNroDocumento), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV19FamiliarTipoDocumento), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV18FamiliarSexo), "") == 0 ) )
      {
         AV21Mensaje.add("Todos los datos son obligatorios", 0);
      }
      else
      {
         if ( GXutil.strcmp(AV19FamiliarTipoDocumento, "1") == 0 )
         {
            if ( GXutil.len( GXutil.trim( AV14FamiliarNroDocumento)) != 8 )
            {
               AV21Mensaje.add("Ingrese un Número de DNI correcto", 0);
            }
            if ( CommonUtil.decimalVal( GXutil.trim( AV14FamiliarNroDocumento), ".").doubleValue() == 0 )
            {
               AV21Mensaje.add("El Número de DNI ingresado no es correcto", 0);
            }
         }
         else
         {
            if ( GXutil.len( GXutil.trim( AV14FamiliarNroDocumento)) < 8 )
            {
               AV21Mensaje.add("Ingrese un Número de Documento correcto", 0);
            }
         }
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV12FamiliarFechaNacimiento)) )
         {
            AV21Mensaje.add("Debe Seleccionar su fecha de nacimiento", 0);
         }
         if ( (0==AV15FamiliarPais) )
         {
            AV21Mensaje.add("Debe seleccionar un pais del listado", 0);
         }
         if ( ( A40000PacienteId > 0 ) && ( GXutil.strcmp(GXutil.trim( AV14FamiliarNroDocumento), "") != 0 ) )
         {
            AV21Mensaje.add("Ya existe un usuario o familiar con los datos ingresados", 0);
         }
      }
      if ( AV21Mensaje.size() > 0 )
      {
         /* Execute user subroutine: 'SHOWMESSAGES' */
         S112 ();
         if ( returnInSub )
         {
            pr_default.close(2);
            returnInSub = true;
            if (true) return;
         }
      }
      else
      {
         /* Execute user subroutine: 'GUARDARFAMILIAR' */
         S122 ();
         if ( returnInSub )
         {
            pr_default.close(2);
            returnInSub = true;
            if (true) return;
         }
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV21Mensaje", AV21Mensaje);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV23Paciente", AV23Paciente);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV24PacienteFamiliar", AV24PacienteFamiliar);
   }

   public void S112( )
   {
      /* 'SHOWMESSAGES' Routine */
      returnInSub = false ;
      AV30textoMensaj = "" ;
      AV33GXV1 = 1 ;
      while ( AV33GXV1 <= AV21Mensaje.size() )
      {
         AV22Mensajei = (String)AV21Mensaje.elementAt(-1+AV33GXV1) ;
         AV30textoMensaj += "&#10060; " + AV22Mensajei + GXutil.newLine( ) ;
         AV33GXV1 = (int)(AV33GXV1+1) ;
      }
      httpContext.GX_msglist.addItem(AV30textoMensaj);
   }

   public void e124Z2( )
   {
      /* Familiarnrodocumento_Controlvaluechanged Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV19FamiliarTipoDocumento, "1") == 0 )
      {
         AV27SDTResponseDni = (com.projectthani.SdtSDTResponseDni)new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
         GXv_int1[0] = AV20httpstatus ;
         GXv_char2[0] = AV25result ;
         new com.projectthani.consultareniec(remoteHandle, context).execute( AV14FamiliarNroDocumento, GXv_int1, GXv_char2, "Content-Type", "application/json") ;
         wcinsertarpacientefamiliar_impl.this.AV20httpstatus = (short)((short)(GXv_int1[0])) ;
         wcinsertarpacientefamiliar_impl.this.AV25result = GXv_char2[0] ;
         AV28SDTResponseWSDni.fromJSonString(AV25result, null);
         AV27SDTResponseDni = AV28SDTResponseWSDni.getgxTv_SdtSDTResponseWSDni_Data();
         if ( ! (GXutil.strcmp("", AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_materno())==0) )
         {
            AV8FamiliarApellidoMaterno = AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_materno() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8FamiliarApellidoMaterno", AV8FamiliarApellidoMaterno);
         }
         if ( ! (GXutil.strcmp("", AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_paterno())==0) )
         {
            AV9FamiliarApellidoPaterno = AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Apellido_paterno() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9FamiliarApellidoPaterno", AV9FamiliarApellidoPaterno);
         }
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento())) )
         {
            AV12FamiliarFechaNacimiento = AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Fecha_nacimiento() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12FamiliarFechaNacimiento", localUtil.format(AV12FamiliarFechaNacimiento, "99/99/99"));
         }
         if ( ! (GXutil.strcmp("", AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Nombres())==0) )
         {
            AV13FamiliarNombres = AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Nombres() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13FamiliarNombres", AV13FamiliarNombres);
         }
         if ( ! (GXutil.strcmp("", AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo())==0) )
         {
            if ( GXutil.strcmp(GXutil.charAt( AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo(), 1), "M") == 0 )
            {
               AV18FamiliarSexo = "M" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18FamiliarSexo", AV18FamiliarSexo);
            }
            if ( GXutil.strcmp(GXutil.charAt( AV27SDTResponseDni.getgxTv_SdtSDTResponseDni_Sexo(), 1), "F") == 0 )
            {
               AV18FamiliarSexo = "F" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18FamiliarSexo", AV18FamiliarSexo);
            }
         }
      }
      /*  Sending Event outputs  */
      cmbavFamiliarsexo.setValue( GXutil.rtrim( AV18FamiliarSexo) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliarsexo.getInternalname(), "Values", cmbavFamiliarsexo.ToJavascriptSource(), true);
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e134Z2 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e134Z2( )
   {
      /* Start Routine */
      returnInSub = false ;
      AV5PacienteId = (int)(GXutil.lval( AV6WebSession.getValue("WSPacienteId"))) ;
   }

   protected void nextLoad( )
   {
   }

   protected void e144Z2( )
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
      pa4Z2( ) ;
      ws4Z2( ) ;
      we4Z2( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
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

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4Z2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wcinsertarpacientefamiliar", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4Z2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
      }
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      pa4Z2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4Z2( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      ws4Z2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      we4Z2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325534", true, true);
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
      httpContext.AddJavascriptSource("wcinsertarpacientefamiliar.js", "?20225110325534", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblocktitleinsertf_Internalname = sPrefix+"TEXTBLOCKTITLEINSERTF" ;
      divSection2_Internalname = sPrefix+"SECTION2" ;
      cmbavFamiliartipodocumento.setInternalname( sPrefix+"vFAMILIARTIPODOCUMENTO" );
      edtavFamiliarnrodocumento_Internalname = sPrefix+"vFAMILIARNRODOCUMENTO" ;
      edtavFamiliarnombres_Internalname = sPrefix+"vFAMILIARNOMBRES" ;
      edtavFamiliarapellidopaterno_Internalname = sPrefix+"vFAMILIARAPELLIDOPATERNO" ;
      edtavFamiliarapellidomaterno_Internalname = sPrefix+"vFAMILIARAPELLIDOMATERNO" ;
      edtavFamiliarfechanacimiento_Internalname = sPrefix+"vFAMILIARFECHANACIMIENTO" ;
      cmbavFamiliarsexo.setInternalname( sPrefix+"vFAMILIARSEXO" );
      cmbavFamiliarparentesco.setInternalname( sPrefix+"vFAMILIARPARENTESCO" );
      dynavFamiliarpais.setInternalname( sPrefix+"vFAMILIARPAIS" );
      edtavFamiliarestatura_Internalname = sPrefix+"vFAMILIARESTATURA" ;
      edtavFamiliarpeso_Internalname = sPrefix+"vFAMILIARPESO" ;
      divGroup1table_Internalname = sPrefix+"GROUP1TABLE" ;
      grpGroupinfogeneral_Internalname = sPrefix+"GROUPINFOGENERAL" ;
      bttRegistrar_Internalname = sPrefix+"REGISTRAR" ;
      bttCancelar_Internalname = sPrefix+"CANCELAR" ;
      divTable7_Internalname = sPrefix+"TABLE7" ;
      divTable5_Internalname = sPrefix+"TABLE5" ;
      divTableinsert_Internalname = sPrefix+"TABLEINSERT" ;
      divTable1_Internalname = sPrefix+"TABLE1" ;
      Dvmessage1_Internalname = sPrefix+"DVMESSAGE1" ;
      divMaintable_Internalname = sPrefix+"MAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusTheme");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      edtavFamiliarpeso_Jsonclick = "" ;
      edtavFamiliarpeso_Enabled = 1 ;
      edtavFamiliarestatura_Jsonclick = "" ;
      edtavFamiliarestatura_Enabled = 1 ;
      dynavFamiliarpais.setJsonclick( "" );
      dynavFamiliarpais.setEnabled( 1 );
      cmbavFamiliarparentesco.setJsonclick( "" );
      cmbavFamiliarparentesco.setEnabled( 1 );
      cmbavFamiliarsexo.setJsonclick( "" );
      cmbavFamiliarsexo.setEnabled( 1 );
      edtavFamiliarfechanacimiento_Jsonclick = "" ;
      edtavFamiliarfechanacimiento_Enabled = 1 ;
      edtavFamiliarapellidomaterno_Jsonclick = "" ;
      edtavFamiliarapellidomaterno_Enabled = 1 ;
      edtavFamiliarapellidopaterno_Jsonclick = "" ;
      edtavFamiliarapellidopaterno_Enabled = 1 ;
      edtavFamiliarnombres_Jsonclick = "" ;
      edtavFamiliarnombres_Enabled = 1 ;
      edtavFamiliarnrodocumento_Jsonclick = "" ;
      edtavFamiliarnrodocumento_Enabled = 1 ;
      cmbavFamiliartipodocumento.setJsonclick( "" );
      cmbavFamiliartipodocumento.setEnabled( 1 );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      cmbavFamiliartipodocumento.setName( "vFAMILIARTIPODOCUMENTO" );
      cmbavFamiliartipodocumento.setWebtags( "" );
      cmbavFamiliartipodocumento.addItem("1", "DNI", (short)(0));
      cmbavFamiliartipodocumento.addItem("6", "RUC", (short)(0));
      cmbavFamiliartipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavFamiliartipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavFamiliartipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavFamiliartipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavFamiliartipodocumento.getItemCount() > 0 )
      {
      }
      cmbavFamiliarsexo.setName( "vFAMILIARSEXO" );
      cmbavFamiliarsexo.setWebtags( "" );
      cmbavFamiliarsexo.addItem("", "Seleccione", (short)(0));
      cmbavFamiliarsexo.addItem("M", "Masculino", (short)(0));
      cmbavFamiliarsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavFamiliarsexo.getItemCount() > 0 )
      {
      }
      cmbavFamiliarparentesco.setName( "vFAMILIARPARENTESCO" );
      cmbavFamiliarparentesco.setWebtags( "" );
      cmbavFamiliarparentesco.addItem("H", "Hijo(a)", (short)(0));
      cmbavFamiliarparentesco.addItem("P", "Padre", (short)(0));
      cmbavFamiliarparentesco.addItem("M", "Madre", (short)(0));
      cmbavFamiliarparentesco.addItem("HM", "Hermano(a)", (short)(0));
      cmbavFamiliarparentesco.addItem("S", "Sobrino(a)", (short)(0));
      cmbavFamiliarparentesco.addItem("T", "Tio(a)", (short)(0));
      cmbavFamiliarparentesco.addItem("A", "Abuelo(a)", (short)(0));
      cmbavFamiliarparentesco.addItem("N", "Nieto(a)", (short)(0));
      cmbavFamiliarparentesco.addItem("O", "Otro", (short)(0));
      if ( cmbavFamiliarparentesco.getItemCount() > 0 )
      {
      }
      dynavFamiliarpais.setName( "vFAMILIARPAIS" );
      dynavFamiliarpais.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("'REGISTRAR'","{handler:'e114Z2',iparms:[{av:'AV9FamiliarApellidoPaterno',fld:'vFAMILIARAPELLIDOPATERNO',pic:''},{av:'AV8FamiliarApellidoMaterno',fld:'vFAMILIARAPELLIDOMATERNO',pic:''},{av:'AV13FamiliarNombres',fld:'vFAMILIARNOMBRES',pic:''},{av:'AV14FamiliarNroDocumento',fld:'vFAMILIARNRODOCUMENTO',pic:''},{av:'cmbavFamiliartipodocumento'},{av:'AV19FamiliarTipoDocumento',fld:'vFAMILIARTIPODOCUMENTO',pic:''},{av:'cmbavFamiliarsexo'},{av:'AV18FamiliarSexo',fld:'vFAMILIARSEXO',pic:''},{av:'AV12FamiliarFechaNacimiento',fld:'vFAMILIARFECHANACIMIENTO',pic:''},{av:'AV21Mensaje',fld:'vMENSAJE',pic:''},{av:'AV23Paciente',fld:'vPACIENTE',pic:''},{av:'AV17FamiliarPeso',fld:'vFAMILIARPESO',pic:'ZZ9.99'},{av:'AV11FamiliarEstatura',fld:'vFAMILIARESTATURA',pic:'9.99'},{av:'AV24PacienteFamiliar',fld:'vPACIENTEFAMILIAR',pic:''},{av:'cmbavFamiliarparentesco'},{av:'AV16FamiliarParentesco',fld:'vFAMILIARPARENTESCO',pic:''},{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]");
      setEventMetadata("'REGISTRAR'",",oparms:[{av:'AV21Mensaje',fld:'vMENSAJE',pic:''},{av:'AV23Paciente',fld:'vPACIENTE',pic:''},{av:'AV24PacienteFamiliar',fld:'vPACIENTEFAMILIAR',pic:''},{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VFAMILIARNRODOCUMENTO.CONTROLVALUECHANGED","{handler:'e124Z2',iparms:[{av:'cmbavFamiliartipodocumento'},{av:'AV19FamiliarTipoDocumento',fld:'vFAMILIARTIPODOCUMENTO',pic:''},{av:'AV14FamiliarNroDocumento',fld:'vFAMILIARNRODOCUMENTO',pic:''},{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VFAMILIARNRODOCUMENTO.CONTROLVALUECHANGED",",oparms:[{av:'AV8FamiliarApellidoMaterno',fld:'vFAMILIARAPELLIDOMATERNO',pic:''},{av:'AV9FamiliarApellidoPaterno',fld:'vFAMILIARAPELLIDOPATERNO',pic:''},{av:'AV12FamiliarFechaNacimiento',fld:'vFAMILIARFECHANACIMIENTO',pic:''},{av:'AV13FamiliarNombres',fld:'vFAMILIARNOMBRES',pic:''},{av:'cmbavFamiliarsexo'},{av:'AV18FamiliarSexo',fld:'vFAMILIARSEXO',pic:''},{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIARTIPODOCUMENTO","{handler:'validv_Familiartipodocumento',iparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIARTIPODOCUMENTO",",oparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIARFECHANACIMIENTO","{handler:'validv_Familiarfechanacimiento',iparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIARFECHANACIMIENTO",",oparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIARSEXO","{handler:'validv_Familiarsexo',iparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIARSEXO",",oparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIARPARENTESCO","{handler:'validv_Familiarparentesco',iparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIARPARENTESCO",",oparms:[{av:'dynavFamiliarpais'},{av:'AV15FamiliarPais',fld:'vFAMILIARPAIS',pic:'ZZZ9'}]}");
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
      sPrefix = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV21Mensaje = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      AV24PacienteFamiliar = new com.projectthani.SdtPacienteFamiliar(remoteHandle);
      GX_FocusControl = "" ;
      lblTextblocktitleinsertf_Jsonclick = "" ;
      TempTags = "" ;
      AV19FamiliarTipoDocumento = "" ;
      AV14FamiliarNroDocumento = "" ;
      AV13FamiliarNombres = "" ;
      AV9FamiliarApellidoPaterno = "" ;
      AV8FamiliarApellidoMaterno = "" ;
      AV12FamiliarFechaNacimiento = GXutil.nullDate() ;
      AV18FamiliarSexo = "" ;
      AV16FamiliarParentesco = "" ;
      AV11FamiliarEstatura = DecimalUtil.ZERO ;
      AV17FamiliarPeso = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttRegistrar_Jsonclick = "" ;
      bttCancelar_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H004Z2_A43PaisId = new short[1] ;
      H004Z2_A184PaisDescripcion = new String[] {""} ;
      H004Z4_A40000PacienteId = new int[1] ;
      H004Z4_n40000PacienteId = new boolean[] {false} ;
      AV6WebSession = httpContext.getWebSession();
      H004Z6_A40000PacienteId = new int[1] ;
      H004Z6_n40000PacienteId = new boolean[] {false} ;
      AV30textoMensaj = "" ;
      AV22Mensajei = "" ;
      AV27SDTResponseDni = new com.projectthani.SdtSDTResponseDni(remoteHandle, context);
      GXv_int1 = new int[1] ;
      AV25result = "" ;
      GXv_char2 = new String[1] ;
      AV28SDTResponseWSDni = new com.projectthani.SdtSDTResponseWSDni(remoteHandle, context);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wcinsertarpacientefamiliar__default(),
         new Object[] {
             new Object[] {
            H004Z2_A43PaisId, H004Z2_A184PaisDescripcion
            }
            , new Object[] {
            H004Z4_A40000PacienteId, H004Z4_n40000PacienteId
            }
            , new Object[] {
            H004Z6_A40000PacienteId, H004Z6_n40000PacienteId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wbEnd ;
   private short wbStart ;
   private short AV15FamiliarPais ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV20httpstatus ;
   private int A40000PacienteId ;
   private int edtavFamiliarnrodocumento_Enabled ;
   private int edtavFamiliarnombres_Enabled ;
   private int edtavFamiliarapellidopaterno_Enabled ;
   private int edtavFamiliarapellidomaterno_Enabled ;
   private int edtavFamiliarfechanacimiento_Enabled ;
   private int edtavFamiliarestatura_Enabled ;
   private int edtavFamiliarpeso_Enabled ;
   private int gxdynajaxindex ;
   private int AV5PacienteId ;
   private int AV33GXV1 ;
   private int GXv_int1[] ;
   private int idxLst ;
   private java.math.BigDecimal AV11FamiliarEstatura ;
   private java.math.BigDecimal AV17FamiliarPeso ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTableinsert_Internalname ;
   private String divTable5_Internalname ;
   private String divSection2_Internalname ;
   private String lblTextblocktitleinsertf_Internalname ;
   private String lblTextblocktitleinsertf_Jsonclick ;
   private String divTable7_Internalname ;
   private String grpGroupinfogeneral_Internalname ;
   private String divGroup1table_Internalname ;
   private String TempTags ;
   private String AV19FamiliarTipoDocumento ;
   private String edtavFamiliarnrodocumento_Internalname ;
   private String edtavFamiliarnrodocumento_Jsonclick ;
   private String edtavFamiliarnombres_Internalname ;
   private String edtavFamiliarnombres_Jsonclick ;
   private String edtavFamiliarapellidopaterno_Internalname ;
   private String edtavFamiliarapellidopaterno_Jsonclick ;
   private String edtavFamiliarapellidomaterno_Internalname ;
   private String edtavFamiliarapellidomaterno_Jsonclick ;
   private String edtavFamiliarfechanacimiento_Internalname ;
   private String edtavFamiliarfechanacimiento_Jsonclick ;
   private String AV18FamiliarSexo ;
   private String AV16FamiliarParentesco ;
   private String edtavFamiliarestatura_Internalname ;
   private String edtavFamiliarestatura_Jsonclick ;
   private String edtavFamiliarpeso_Internalname ;
   private String edtavFamiliarpeso_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttRegistrar_Internalname ;
   private String bttRegistrar_Jsonclick ;
   private String bttCancelar_Internalname ;
   private String bttCancelar_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String GXv_char2[] ;
   private java.util.Date AV12FamiliarFechaNacimiento ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000PacienteId ;
   private boolean returnInSub ;
   private String AV25result ;
   private String AV14FamiliarNroDocumento ;
   private String AV13FamiliarNombres ;
   private String AV9FamiliarApellidoPaterno ;
   private String AV8FamiliarApellidoMaterno ;
   private String AV30textoMensaj ;
   private String AV22Mensajei ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV6WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private HTMLChoice cmbavFamiliartipodocumento ;
   private HTMLChoice cmbavFamiliarsexo ;
   private HTMLChoice cmbavFamiliarparentesco ;
   private HTMLChoice dynavFamiliarpais ;
   private IDataStoreProvider pr_default ;
   private short[] H004Z2_A43PaisId ;
   private String[] H004Z2_A184PaisDescripcion ;
   private int[] H004Z4_A40000PacienteId ;
   private boolean[] H004Z4_n40000PacienteId ;
   private int[] H004Z6_A40000PacienteId ;
   private boolean[] H004Z6_n40000PacienteId ;
   private GXSimpleCollection<String> AV21Mensaje ;
   private com.projectthani.SdtPaciente AV23Paciente ;
   private com.projectthani.SdtPacienteFamiliar AV24PacienteFamiliar ;
   private com.projectthani.SdtSDTResponseDni AV27SDTResponseDni ;
   private com.projectthani.SdtSDTResponseWSDni AV28SDTResponseWSDni ;
}

final  class wcinsertarpacientefamiliar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004Z2", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004Z4", "SELECT COALESCE( T1.[PacienteId], 0) AS PacienteId FROM (SELECT MIN([PacienteId]) AS PacienteId FROM [Paciente] WHERE [PacienteNroDocumento] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H004Z6", "SELECT COALESCE( T1.[PacienteId], 0) AS PacienteId FROM (SELECT MIN([PacienteId]) AS PacienteId FROM [Paciente] WHERE [PacienteNroDocumento] = RTRIM(LTRIM(?)) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 2 :
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
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 15);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 15);
               return;
      }
   }

}

