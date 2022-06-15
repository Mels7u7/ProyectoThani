package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wceditarpacientefamiliar_impl extends GXWebComponent
{
   public wceditarpacientefamiliar_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wceditarpacientefamiliar_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wceditarpacientefamiliar_impl.class ));
   }

   public wceditarpacientefamiliar_impl( int remoteHandle ,
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
      cmbavFamiliaredittipodocumento = new HTMLChoice();
      cmbavFamiliareditsexo = new HTMLChoice();
      cmbavFamiliareditparentesco = new HTMLChoice();
      dynavFamiliareditpais = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "PacienteId") ;
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
               AV18PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18PacienteId), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(AV18PacienteId)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vFAMILIAREDITPAIS") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvvfamiliareditpais4Y2( ) ;
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
               gxfirstwebparm = httpContext.GetFirstPar( "PacienteId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "PacienteId") ;
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
         pa4Y2( ) ;
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
         httpContext.writeValue( "WCEditar Paciente Familiar") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325325", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wceditarpacientefamiliar", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV18PacienteId,8,0))}, new String[] {"PacienteId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOAV18PacienteId", GXutil.ltrim( localUtil.ntoc( wcpOAV18PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV18PacienteId, (byte)(8), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm4Y2( )
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
      return "WCEditarPacienteFamiliar" ;
   }

   public String getPgmdesc( )
   {
      return "WCEditar Paciente Familiar" ;
   }

   public void wb4Y0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.wceditarpacientefamiliar");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableactualizar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSection3_Internalname, 1, 0, "px", 0, "px", "SeccionCitas", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock4_Internalname, "Ingrese los siguientes datos para actualizar el registro del familiar", "", "", lblTextblock4_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlockCitas", 0, "", 1, 1, 0, (short)(0), "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableInsertEditFamiliar", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroupeditarpacientefamiliar_Internalname, "INFORMACIÓN GENERAL", 1, 0, "px", 0, "px", "GroupInfoGenAsociadoPaciente", "", "HLP_WCEditarPacienteFamiliar.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFamiliaredittipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavFamiliaredittipodocumento.getInternalname(), "Tipo Documento", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFamiliaredittipodocumento, cmbavFamiliaredittipodocumento.getInternalname(), GXutil.rtrim( AV15FamiliarEditTipoDocumento), 1, cmbavFamiliaredittipodocumento.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFamiliaredittipodocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,25);\"", "", true, (byte)(1), "HLP_WCEditarPacienteFamiliar.htm");
         cmbavFamiliaredittipodocumento.setValue( GXutil.rtrim( AV15FamiliarEditTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliaredittipodocumento.getInternalname(), "Values", cmbavFamiliaredittipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliareditnrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliareditnrodocumento_Internalname, "Nro Documento", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliareditnrodocumento_Internalname, AV10FamiliarEditNroDocumento, GXutil.rtrim( localUtil.format( AV10FamiliarEditNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliareditnrodocumento_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliareditnrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliareditnombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliareditnombres_Internalname, "Nombres", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliareditnombres_Internalname, AV9FamiliarEditNombres, GXutil.rtrim( localUtil.format( AV9FamiliarEditNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliareditnombres_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliareditnombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliareditapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliareditapellidopaterno_Internalname, "Apellido Paterno", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliareditapellidopaterno_Internalname, AV6FamiliarEditApellidoPaterno, GXutil.rtrim( localUtil.format( AV6FamiliarEditApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliareditapellidopaterno_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliareditapellidopaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliareditapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliareditapellidomaterno_Internalname, "Apellido Materno", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliareditapellidomaterno_Internalname, AV5FamiliarEditApellidoMaterno, GXutil.rtrim( localUtil.format( AV5FamiliarEditApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliareditapellidomaterno_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliareditapellidomaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliareditfechanacimiento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliareditfechanacimiento_Internalname, "Fecha Nacimiento", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'" + sPrefix + "',false,'',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavFamiliareditfechanacimiento_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliareditfechanacimiento_Internalname, localUtil.format(AV8FamiliarEditFechaNacimiento, "99/99/9999"), localUtil.format( AV8FamiliarEditFechaNacimiento, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,46);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliareditfechanacimiento_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliareditfechanacimiento_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavFamiliareditfechanacimiento_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavFamiliareditfechanacimiento_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WCEditarPacienteFamiliar.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFamiliareditsexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavFamiliareditsexo.getInternalname(), "Sexo", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFamiliareditsexo, cmbavFamiliareditsexo.getInternalname(), GXutil.rtrim( AV14FamiliarEditSexo), 1, cmbavFamiliareditsexo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFamiliareditsexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,51);\"", "", true, (byte)(1), "HLP_WCEditarPacienteFamiliar.htm");
         cmbavFamiliareditsexo.setValue( GXutil.rtrim( AV14FamiliarEditSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliareditsexo.getInternalname(), "Values", cmbavFamiliareditsexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavFamiliareditparentesco.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavFamiliareditparentesco.getInternalname(), "Parentesco", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavFamiliareditparentesco, cmbavFamiliareditparentesco.getInternalname(), GXutil.rtrim( AV12FamiliarEditParentesco), 1, cmbavFamiliareditparentesco.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavFamiliareditparentesco.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,55);\"", "", true, (byte)(1), "HLP_WCEditarPacienteFamiliar.htm");
         cmbavFamiliareditparentesco.setValue( GXutil.rtrim( AV12FamiliarEditParentesco) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliareditparentesco.getInternalname(), "Values", cmbavFamiliareditparentesco.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavFamiliareditpais.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavFamiliareditpais.getInternalname(), "Nacionalidad", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavFamiliareditpais, dynavFamiliareditpais.getInternalname(), GXutil.trim( GXutil.str( AV11FamiliarEditPais, 4, 0)), 1, dynavFamiliareditpais.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavFamiliareditpais.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttFamiliarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "", true, (byte)(1), "HLP_WCEditarPacienteFamiliar.htm");
         dynavFamiliareditpais.setValue( GXutil.trim( GXutil.str( AV11FamiliarEditPais, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavFamiliareditpais.getInternalname(), "Values", dynavFamiliareditpais.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliareditestatura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliareditestatura_Internalname, "Estatura", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliareditestatura_Internalname, GXutil.ltrim( localUtil.ntoc( AV7FamiliarEditEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtavFamiliareditestatura_Enabled!=0) ? localUtil.format( AV7FamiliarEditEstatura, "9.99") : localUtil.format( AV7FamiliarEditEstatura, "9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,64);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliareditestatura_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliareditestatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFamiliareditpeso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFamiliareditpeso_Internalname, "Peso", "col-xs-12 AttFamiliarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFamiliareditpeso_Internalname, GXutil.ltrim( localUtil.ntoc( AV13FamiliarEditPeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtavFamiliareditpeso_Enabled!=0) ? localUtil.format( AV13FamiliarEditPeso, "ZZ9.99") : localUtil.format( AV13FamiliarEditPeso, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,68);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavFamiliareditpeso_Jsonclick, 0, "AttFamiliarPaciente", "", "", "", "", 1, edtavFamiliareditpeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCEditarPacienteFamiliar.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonNuevoFamiliar" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttActualizar_Internalname, "", "Actualizar", bttActualizar_Jsonclick, 5, "Actualizar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'ACTUALIZAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WCEditarPacienteFamiliar.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonNuevoFamiliar" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelarbtn_Internalname, "", "Cancelar", bttCancelarbtn_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e114y1_client"+"'", TempTags, "", 2, "HLP_WCEditarPacienteFamiliar.htm");
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
      }
      wbLoad = true ;
   }

   public void start4Y2( )
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
            Form.getMeta().addItem("description", "WCEditar Paciente Familiar", (short)(0)) ;
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
            strup4Y0( ) ;
         }
      }
   }

   public void ws4Y2( )
   {
      start4Y2( ) ;
      evt4Y2( ) ;
   }

   public void evt4Y2( )
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
                              strup4Y0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e124Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'ACTUALIZAR'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'Actualizar' */
                                 e134Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e144Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
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
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = cmbavFamiliaredittipodocumento.getInternalname() ;
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

   public void we4Y2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4Y2( ) ;
         }
      }
   }

   public void pa4Y2( )
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
            GX_FocusControl = cmbavFamiliaredittipodocumento.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvfamiliareditpais4Y2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvfamiliareditpais_data4Y2( ) ;
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

   public void gxvvfamiliareditpais_html4Y2( )
   {
      short gxdynajaxvalue;
      gxdlvvfamiliareditpais_data4Y2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavFamiliareditpais.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavFamiliareditpais.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvfamiliareditpais_data4Y2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccione");
      /* Using cursor H004Y2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H004Y2_A43PaisId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H004Y2_A184PaisDescripcion[0]);
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
         gxvvfamiliareditpais_html4Y2( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavFamiliaredittipodocumento.getItemCount() > 0 )
      {
         AV15FamiliarEditTipoDocumento = cmbavFamiliaredittipodocumento.getValidValue(AV15FamiliarEditTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15FamiliarEditTipoDocumento", AV15FamiliarEditTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFamiliaredittipodocumento.setValue( GXutil.rtrim( AV15FamiliarEditTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliaredittipodocumento.getInternalname(), "Values", cmbavFamiliaredittipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavFamiliareditsexo.getItemCount() > 0 )
      {
         AV14FamiliarEditSexo = cmbavFamiliareditsexo.getValidValue(AV14FamiliarEditSexo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14FamiliarEditSexo", AV14FamiliarEditSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFamiliareditsexo.setValue( GXutil.rtrim( AV14FamiliarEditSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliareditsexo.getInternalname(), "Values", cmbavFamiliareditsexo.ToJavascriptSource(), true);
      }
      if ( cmbavFamiliareditparentesco.getItemCount() > 0 )
      {
         AV12FamiliarEditParentesco = cmbavFamiliareditparentesco.getValidValue(AV12FamiliarEditParentesco) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12FamiliarEditParentesco", AV12FamiliarEditParentesco);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavFamiliareditparentesco.setValue( GXutil.rtrim( AV12FamiliarEditParentesco) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavFamiliareditparentesco.getInternalname(), "Values", cmbavFamiliareditparentesco.ToJavascriptSource(), true);
      }
      if ( dynavFamiliareditpais.getItemCount() > 0 )
      {
         AV11FamiliarEditPais = (short)(GXutil.lval( dynavFamiliareditpais.getValidValue(GXutil.trim( GXutil.str( AV11FamiliarEditPais, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FamiliarEditPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11FamiliarEditPais), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavFamiliareditpais.setValue( GXutil.trim( GXutil.str( AV11FamiliarEditPais, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavFamiliareditpais.getInternalname(), "Values", dynavFamiliareditpais.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf4Y2( ) ;
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

   public void rf4Y2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e144Y2 ();
         wb4Y0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4Y2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      gxvvfamiliareditpais_html4Y2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strup4Y0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e124Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOAV18PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV18PacienteId"), ",", ".")) ;
         /* Read variables values. */
         cmbavFamiliaredittipodocumento.setValue( httpContext.cgiGet( cmbavFamiliaredittipodocumento.getInternalname()) );
         AV15FamiliarEditTipoDocumento = httpContext.cgiGet( cmbavFamiliaredittipodocumento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15FamiliarEditTipoDocumento", AV15FamiliarEditTipoDocumento);
         AV10FamiliarEditNroDocumento = httpContext.cgiGet( edtavFamiliareditnrodocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10FamiliarEditNroDocumento", AV10FamiliarEditNroDocumento);
         AV9FamiliarEditNombres = httpContext.cgiGet( edtavFamiliareditnombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9FamiliarEditNombres", AV9FamiliarEditNombres);
         AV6FamiliarEditApellidoPaterno = httpContext.cgiGet( edtavFamiliareditapellidopaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6FamiliarEditApellidoPaterno", AV6FamiliarEditApellidoPaterno);
         AV5FamiliarEditApellidoMaterno = httpContext.cgiGet( edtavFamiliareditapellidomaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5FamiliarEditApellidoMaterno", AV5FamiliarEditApellidoMaterno);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavFamiliareditfechanacimiento_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vFAMILIAREDITFECHANACIMIENTO");
            GX_FocusControl = edtavFamiliareditfechanacimiento_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8FamiliarEditFechaNacimiento = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8FamiliarEditFechaNacimiento", localUtil.format(AV8FamiliarEditFechaNacimiento, "99/99/9999"));
         }
         else
         {
            AV8FamiliarEditFechaNacimiento = localUtil.ctod( httpContext.cgiGet( edtavFamiliareditfechanacimiento_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8FamiliarEditFechaNacimiento", localUtil.format(AV8FamiliarEditFechaNacimiento, "99/99/9999"));
         }
         cmbavFamiliareditsexo.setValue( httpContext.cgiGet( cmbavFamiliareditsexo.getInternalname()) );
         AV14FamiliarEditSexo = httpContext.cgiGet( cmbavFamiliareditsexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14FamiliarEditSexo", AV14FamiliarEditSexo);
         cmbavFamiliareditparentesco.setValue( httpContext.cgiGet( cmbavFamiliareditparentesco.getInternalname()) );
         AV12FamiliarEditParentesco = httpContext.cgiGet( cmbavFamiliareditparentesco.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12FamiliarEditParentesco", AV12FamiliarEditParentesco);
         dynavFamiliareditpais.setValue( httpContext.cgiGet( dynavFamiliareditpais.getInternalname()) );
         AV11FamiliarEditPais = (short)(GXutil.lval( httpContext.cgiGet( dynavFamiliareditpais.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FamiliarEditPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11FamiliarEditPais), 4, 0));
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavFamiliareditestatura_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavFamiliareditestatura_Internalname)), DecimalUtil.stringToDec("9.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vFAMILIAREDITESTATURA");
            GX_FocusControl = edtavFamiliareditestatura_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV7FamiliarEditEstatura = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FamiliarEditEstatura", GXutil.ltrimstr( AV7FamiliarEditEstatura, 4, 2));
         }
         else
         {
            AV7FamiliarEditEstatura = localUtil.ctond( httpContext.cgiGet( edtavFamiliareditestatura_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FamiliarEditEstatura", GXutil.ltrimstr( AV7FamiliarEditEstatura, 4, 2));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavFamiliareditpeso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavFamiliareditpeso_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vFAMILIAREDITPESO");
            GX_FocusControl = edtavFamiliareditpeso_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV13FamiliarEditPeso = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13FamiliarEditPeso", GXutil.ltrimstr( AV13FamiliarEditPeso, 6, 2));
         }
         else
         {
            AV13FamiliarEditPeso = localUtil.ctond( httpContext.cgiGet( edtavFamiliareditpeso_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13FamiliarEditPeso", GXutil.ltrimstr( AV13FamiliarEditPeso, 6, 2));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         gxvvfamiliareditpais_html4Y2( ) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e124Y2 ();
      if (returnInSub) return;
   }

   public void e124Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( AV18PacienteId > 0 )
      {
         AV16Paciente.Load(AV18PacienteId);
         AV9FamiliarEditNombres = AV16Paciente.getgxTv_SdtPaciente_Pacientenombres() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV9FamiliarEditNombres", AV9FamiliarEditNombres);
         AV6FamiliarEditApellidoPaterno = AV16Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6FamiliarEditApellidoPaterno", AV6FamiliarEditApellidoPaterno);
         AV5FamiliarEditApellidoMaterno = AV16Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5FamiliarEditApellidoMaterno", AV5FamiliarEditApellidoMaterno);
         AV15FamiliarEditTipoDocumento = AV16Paciente.getgxTv_SdtPaciente_Pacientetipodocumento() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV15FamiliarEditTipoDocumento", AV15FamiliarEditTipoDocumento);
         AV10FamiliarEditNroDocumento = AV16Paciente.getgxTv_SdtPaciente_Pacientenrodocumento() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV10FamiliarEditNroDocumento", AV10FamiliarEditNroDocumento);
         AV8FamiliarEditFechaNacimiento = AV16Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV8FamiliarEditFechaNacimiento", localUtil.format(AV8FamiliarEditFechaNacimiento, "99/99/9999"));
         AV11FamiliarEditPais = AV16Paciente.getgxTv_SdtPaciente_Paisid() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11FamiliarEditPais", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11FamiliarEditPais), 4, 0));
         AV7FamiliarEditEstatura = AV16Paciente.getgxTv_SdtPaciente_Pacienteestatura() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7FamiliarEditEstatura", GXutil.ltrimstr( AV7FamiliarEditEstatura, 4, 2));
         AV13FamiliarEditPeso = AV16Paciente.getgxTv_SdtPaciente_Pacientepeso() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13FamiliarEditPeso", GXutil.ltrimstr( AV13FamiliarEditPeso, 6, 2));
      }
   }

   public void e134Y2( )
   {
      /* 'Actualizar' Routine */
      returnInSub = false ;
      AV16Paciente.Load(AV18PacienteId);
      AV16Paciente.setgxTv_SdtPaciente_Pacientenombres( AV9FamiliarEditNombres );
      AV16Paciente.setgxTv_SdtPaciente_Pacienteapellidopaterno( AV6FamiliarEditApellidoPaterno );
      AV16Paciente.setgxTv_SdtPaciente_Pacienteapellidomaterno( AV5FamiliarEditApellidoMaterno );
      AV16Paciente.setgxTv_SdtPaciente_Pacientetipodocumento( AV15FamiliarEditTipoDocumento );
      AV16Paciente.setgxTv_SdtPaciente_Pacientenrodocumento( AV10FamiliarEditNroDocumento );
      AV16Paciente.setgxTv_SdtPaciente_Pacientefechanacimiento( AV8FamiliarEditFechaNacimiento );
      AV16Paciente.setgxTv_SdtPaciente_Paisid( AV11FamiliarEditPais );
      AV16Paciente.setgxTv_SdtPaciente_Pacienteestatura( AV7FamiliarEditEstatura );
      AV16Paciente.setgxTv_SdtPaciente_Pacientepeso( AV13FamiliarEditPeso );
      AV16Paciente.Update();
      if ( AV16Paciente.Success() )
      {
         this.executeExternalObjectMethod(sPrefix, false, "AV19SweetAlert", "successAlert", new Object[] {"success","Los datos del familiar se actualizó correctamente.",""}, false);
         Application.commitDataStores(context, remoteHandle, pr_default, "wceditarpacientefamiliar");
         this.executeExternalObjectMethod(sPrefix, false, "GlobalEvents", "RegresarWebComponet", new Object[] {"ListadoPacienteFamiliar"}, true);
      }
      else
      {
         this.executeExternalObjectMethod(sPrefix, false, "AV19SweetAlert", "successAlert", new Object[] {"error","Error en actualizar los datos del familiar.",""}, false);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wceditarpacientefamiliar");
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e144Y2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV18PacienteId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18PacienteId), 8, 0));
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
      pa4Y2( ) ;
      ws4Y2( ) ;
      we4Y2( ) ;
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
      sCtrlAV18PacienteId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4Y2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wceditarpacientefamiliar", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4Y2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         AV18PacienteId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18PacienteId), 8, 0));
      }
      wcpOAV18PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOAV18PacienteId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( AV18PacienteId != wcpOAV18PacienteId ) ) )
      {
         setjustcreated();
      }
      wcpOAV18PacienteId = AV18PacienteId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlAV18PacienteId = httpContext.cgiGet( sPrefix+"AV18PacienteId_CTRL") ;
      if ( GXutil.len( sCtrlAV18PacienteId) > 0 )
      {
         AV18PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlAV18PacienteId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18PacienteId), 8, 0));
      }
      else
      {
         AV18PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"AV18PacienteId_PARM"), ",", ".")) ;
      }
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
      pa4Y2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4Y2( ) ;
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
      ws4Y2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18PacienteId_PARM", GXutil.ltrim( localUtil.ntoc( AV18PacienteId, (byte)(8), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlAV18PacienteId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"AV18PacienteId_CTRL", GXutil.rtrim( sCtrlAV18PacienteId));
      }
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
      we4Y2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325393", true, true);
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
      httpContext.AddJavascriptSource("wceditarpacientefamiliar.js", "?20225110325393", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblock4_Internalname = sPrefix+"TEXTBLOCK4" ;
      divSection3_Internalname = sPrefix+"SECTION3" ;
      cmbavFamiliaredittipodocumento.setInternalname( sPrefix+"vFAMILIAREDITTIPODOCUMENTO" );
      edtavFamiliareditnrodocumento_Internalname = sPrefix+"vFAMILIAREDITNRODOCUMENTO" ;
      edtavFamiliareditnombres_Internalname = sPrefix+"vFAMILIAREDITNOMBRES" ;
      edtavFamiliareditapellidopaterno_Internalname = sPrefix+"vFAMILIAREDITAPELLIDOPATERNO" ;
      edtavFamiliareditapellidomaterno_Internalname = sPrefix+"vFAMILIAREDITAPELLIDOMATERNO" ;
      edtavFamiliareditfechanacimiento_Internalname = sPrefix+"vFAMILIAREDITFECHANACIMIENTO" ;
      cmbavFamiliareditsexo.setInternalname( sPrefix+"vFAMILIAREDITSEXO" );
      cmbavFamiliareditparentesco.setInternalname( sPrefix+"vFAMILIAREDITPARENTESCO" );
      dynavFamiliareditpais.setInternalname( sPrefix+"vFAMILIAREDITPAIS" );
      edtavFamiliareditestatura_Internalname = sPrefix+"vFAMILIAREDITESTATURA" ;
      edtavFamiliareditpeso_Internalname = sPrefix+"vFAMILIAREDITPESO" ;
      divGroup1table_Internalname = sPrefix+"GROUP1TABLE" ;
      grpGroupeditarpacientefamiliar_Internalname = sPrefix+"GROUPEDITARPACIENTEFAMILIAR" ;
      bttActualizar_Internalname = sPrefix+"ACTUALIZAR" ;
      bttCancelarbtn_Internalname = sPrefix+"CANCELARBTN" ;
      divTable3_Internalname = sPrefix+"TABLE3" ;
      divTableactualizar_Internalname = sPrefix+"TABLEACTUALIZAR" ;
      divTable1_Internalname = sPrefix+"TABLE1" ;
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
      edtavFamiliareditpeso_Jsonclick = "" ;
      edtavFamiliareditpeso_Enabled = 1 ;
      edtavFamiliareditestatura_Jsonclick = "" ;
      edtavFamiliareditestatura_Enabled = 1 ;
      dynavFamiliareditpais.setJsonclick( "" );
      dynavFamiliareditpais.setEnabled( 1 );
      cmbavFamiliareditparentesco.setJsonclick( "" );
      cmbavFamiliareditparentesco.setEnabled( 1 );
      cmbavFamiliareditsexo.setJsonclick( "" );
      cmbavFamiliareditsexo.setEnabled( 1 );
      edtavFamiliareditfechanacimiento_Jsonclick = "" ;
      edtavFamiliareditfechanacimiento_Enabled = 1 ;
      edtavFamiliareditapellidomaterno_Jsonclick = "" ;
      edtavFamiliareditapellidomaterno_Enabled = 1 ;
      edtavFamiliareditapellidopaterno_Jsonclick = "" ;
      edtavFamiliareditapellidopaterno_Enabled = 1 ;
      edtavFamiliareditnombres_Jsonclick = "" ;
      edtavFamiliareditnombres_Enabled = 1 ;
      edtavFamiliareditnrodocumento_Jsonclick = "" ;
      edtavFamiliareditnrodocumento_Enabled = 1 ;
      cmbavFamiliaredittipodocumento.setJsonclick( "" );
      cmbavFamiliaredittipodocumento.setEnabled( 1 );
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
      cmbavFamiliaredittipodocumento.setName( "vFAMILIAREDITTIPODOCUMENTO" );
      cmbavFamiliaredittipodocumento.setWebtags( "" );
      cmbavFamiliaredittipodocumento.addItem("1", "DNI", (short)(0));
      cmbavFamiliaredittipodocumento.addItem("6", "RUC", (short)(0));
      cmbavFamiliaredittipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavFamiliaredittipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavFamiliaredittipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavFamiliaredittipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavFamiliaredittipodocumento.getItemCount() > 0 )
      {
      }
      cmbavFamiliareditsexo.setName( "vFAMILIAREDITSEXO" );
      cmbavFamiliareditsexo.setWebtags( "" );
      cmbavFamiliareditsexo.addItem("", "Seleccione", (short)(0));
      cmbavFamiliareditsexo.addItem("M", "Masculino", (short)(0));
      cmbavFamiliareditsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavFamiliareditsexo.getItemCount() > 0 )
      {
      }
      cmbavFamiliareditparentesco.setName( "vFAMILIAREDITPARENTESCO" );
      cmbavFamiliareditparentesco.setWebtags( "" );
      cmbavFamiliareditparentesco.addItem("H", "Hijo(a)", (short)(0));
      cmbavFamiliareditparentesco.addItem("P", "Padre", (short)(0));
      cmbavFamiliareditparentesco.addItem("M", "Madre", (short)(0));
      cmbavFamiliareditparentesco.addItem("HM", "Hermano(a)", (short)(0));
      cmbavFamiliareditparentesco.addItem("S", "Sobrino(a)", (short)(0));
      cmbavFamiliareditparentesco.addItem("T", "Tio(a)", (short)(0));
      cmbavFamiliareditparentesco.addItem("A", "Abuelo(a)", (short)(0));
      cmbavFamiliareditparentesco.addItem("N", "Nieto(a)", (short)(0));
      cmbavFamiliareditparentesco.addItem("O", "Otro", (short)(0));
      if ( cmbavFamiliareditparentesco.getItemCount() > 0 )
      {
      }
      dynavFamiliareditpais.setName( "vFAMILIAREDITPAIS" );
      dynavFamiliareditpais.setWebtags( "" );
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("'CANCELAR'","{handler:'e114Y1',iparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]");
      setEventMetadata("'CANCELAR'",",oparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("'ACTUALIZAR'","{handler:'e134Y2',iparms:[{av:'AV18PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9'},{av:'AV9FamiliarEditNombres',fld:'vFAMILIAREDITNOMBRES',pic:''},{av:'AV6FamiliarEditApellidoPaterno',fld:'vFAMILIAREDITAPELLIDOPATERNO',pic:''},{av:'AV5FamiliarEditApellidoMaterno',fld:'vFAMILIAREDITAPELLIDOMATERNO',pic:''},{av:'cmbavFamiliaredittipodocumento'},{av:'AV15FamiliarEditTipoDocumento',fld:'vFAMILIAREDITTIPODOCUMENTO',pic:''},{av:'AV10FamiliarEditNroDocumento',fld:'vFAMILIAREDITNRODOCUMENTO',pic:''},{av:'AV8FamiliarEditFechaNacimiento',fld:'vFAMILIAREDITFECHANACIMIENTO',pic:''},{av:'AV7FamiliarEditEstatura',fld:'vFAMILIAREDITESTATURA',pic:'9.99'},{av:'AV13FamiliarEditPeso',fld:'vFAMILIAREDITPESO',pic:'ZZ9.99'},{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]");
      setEventMetadata("'ACTUALIZAR'",",oparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIAREDITTIPODOCUMENTO","{handler:'validv_Familiaredittipodocumento',iparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIAREDITTIPODOCUMENTO",",oparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIAREDITFECHANACIMIENTO","{handler:'validv_Familiareditfechanacimiento',iparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIAREDITFECHANACIMIENTO",",oparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIAREDITSEXO","{handler:'validv_Familiareditsexo',iparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIAREDITSEXO",",oparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_FAMILIAREDITPARENTESCO","{handler:'validv_Familiareditparentesco',iparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_FAMILIAREDITPARENTESCO",",oparms:[{av:'dynavFamiliareditpais'},{av:'AV11FamiliarEditPais',fld:'vFAMILIAREDITPAIS',pic:'ZZZ9'}]}");
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
      GX_FocusControl = "" ;
      lblTextblock4_Jsonclick = "" ;
      TempTags = "" ;
      AV15FamiliarEditTipoDocumento = "" ;
      AV10FamiliarEditNroDocumento = "" ;
      AV9FamiliarEditNombres = "" ;
      AV6FamiliarEditApellidoPaterno = "" ;
      AV5FamiliarEditApellidoMaterno = "" ;
      AV8FamiliarEditFechaNacimiento = GXutil.nullDate() ;
      AV14FamiliarEditSexo = "" ;
      AV12FamiliarEditParentesco = "" ;
      AV7FamiliarEditEstatura = DecimalUtil.ZERO ;
      AV13FamiliarEditPeso = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttActualizar_Jsonclick = "" ;
      bttCancelarbtn_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H004Y2_A43PaisId = new short[1] ;
      H004Y2_A184PaisDescripcion = new String[] {""} ;
      AV16Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlAV18PacienteId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wceditarpacientefamiliar__default(),
         new Object[] {
             new Object[] {
            H004Y2_A43PaisId, H004Y2_A184PaisDescripcion
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
   private short AV11FamiliarEditPais ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOAV18PacienteId ;
   private int AV18PacienteId ;
   private int edtavFamiliareditnrodocumento_Enabled ;
   private int edtavFamiliareditnombres_Enabled ;
   private int edtavFamiliareditapellidopaterno_Enabled ;
   private int edtavFamiliareditapellidomaterno_Enabled ;
   private int edtavFamiliareditfechanacimiento_Enabled ;
   private int edtavFamiliareditestatura_Enabled ;
   private int edtavFamiliareditpeso_Enabled ;
   private int gxdynajaxindex ;
   private int idxLst ;
   private java.math.BigDecimal AV7FamiliarEditEstatura ;
   private java.math.BigDecimal AV13FamiliarEditPeso ;
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
   private String divTableactualizar_Internalname ;
   private String divSection3_Internalname ;
   private String lblTextblock4_Internalname ;
   private String lblTextblock4_Jsonclick ;
   private String divTable3_Internalname ;
   private String grpGroupeditarpacientefamiliar_Internalname ;
   private String divGroup1table_Internalname ;
   private String TempTags ;
   private String AV15FamiliarEditTipoDocumento ;
   private String edtavFamiliareditnrodocumento_Internalname ;
   private String edtavFamiliareditnrodocumento_Jsonclick ;
   private String edtavFamiliareditnombres_Internalname ;
   private String edtavFamiliareditnombres_Jsonclick ;
   private String edtavFamiliareditapellidopaterno_Internalname ;
   private String edtavFamiliareditapellidopaterno_Jsonclick ;
   private String edtavFamiliareditapellidomaterno_Internalname ;
   private String edtavFamiliareditapellidomaterno_Jsonclick ;
   private String edtavFamiliareditfechanacimiento_Internalname ;
   private String edtavFamiliareditfechanacimiento_Jsonclick ;
   private String AV14FamiliarEditSexo ;
   private String AV12FamiliarEditParentesco ;
   private String edtavFamiliareditestatura_Internalname ;
   private String edtavFamiliareditestatura_Jsonclick ;
   private String edtavFamiliareditpeso_Internalname ;
   private String edtavFamiliareditpeso_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String bttActualizar_Internalname ;
   private String bttActualizar_Jsonclick ;
   private String bttCancelarbtn_Internalname ;
   private String bttCancelarbtn_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String sCtrlAV18PacienteId ;
   private java.util.Date AV8FamiliarEditFechaNacimiento ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV10FamiliarEditNroDocumento ;
   private String AV9FamiliarEditNombres ;
   private String AV6FamiliarEditApellidoPaterno ;
   private String AV5FamiliarEditApellidoMaterno ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private HTMLChoice cmbavFamiliaredittipodocumento ;
   private HTMLChoice cmbavFamiliareditsexo ;
   private HTMLChoice cmbavFamiliareditparentesco ;
   private HTMLChoice dynavFamiliareditpais ;
   private IDataStoreProvider pr_default ;
   private short[] H004Y2_A43PaisId ;
   private String[] H004Y2_A184PaisDescripcion ;
   private com.projectthani.SdtPaciente AV16Paciente ;
}

final  class wceditarpacientefamiliar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004Y2", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
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
      }
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

