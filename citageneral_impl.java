package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citageneral_impl extends GXWebComponent
{
   public citageneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public citageneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citageneral_impl.class ));
   }

   public citageneral_impl( int remoteHandle ,
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
      cmbCitaTipoDiagnostico = new HTMLChoice();
      cmbCitaEstadoCita = new HTMLChoice();
      cmbCitaEstado = new HTMLChoice();
      chkCitaConsentimiento = UIFactory.getCheckbox(this);
      chkCitaGestante = UIFactory.getCheckbox(this);
      cmbCitaEstadoPago = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
               A19CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A19CitaId)});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
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
         pa3A2( ) ;
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
         httpContext.writeValue( "Cita General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110322936", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.citageneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0))}, new String[] {"CitaId"}) +"\">") ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"CitaGeneral");
      forbiddenHiddens.add("CitaLink", GXutil.rtrim( localUtil.format( A91CitaLink, "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("citageneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA19CitaId", GXutil.ltrim( localUtil.ntoc( wcpOA19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROFESIONALNOMBRES", A84ProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROFESIONALAPELLIDOPATERNO", A85ProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROFESIONALAPELLIDOMATERNO", A86ProfesionalApellidoMaterno);
   }

   public void renderHtmlCloseForm3A2( )
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
      return "CitaGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Cita General" ;
   }

   public void wb3A0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.citageneral");
         }
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", sPrefix, "false");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTransactiondetail_tableattributes_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaCode_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaCode_Internalname, "Code", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaCode_Internalname, A64CitaCode, GXutil.rtrim( localUtil.format( A64CitaCode, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaCode_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaCode_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombres_Internalname, "Paciente Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombres_Internalname, A105PacienteNombres, GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtPacienteNombres_Link, "", "", "", edtPacienteNombres_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteNombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoPaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoPaterno_Internalname, "Paciente Apellido Paterno", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoPaterno_Internalname, A103PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoPaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteApellidoPaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoMaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoMaterno_Internalname, "Paciente Apellido Materno", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoMaterno_Internalname, A104PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoMaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteApellidoMaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNroDocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNroDocumento_Internalname, "Paciente Nro Documento", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNroDocumento_Internalname, A106PacienteNroDocumento, GXutil.rtrim( localUtil.format( A106PacienteNroDocumento, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNroDocumento_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteNroDocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCitaTipoDiagnostico.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaTipoDiagnostico.getInternalname(), "Tipo Diagnostico", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaTipoDiagnostico, cmbCitaTipoDiagnostico.getInternalname(), GXutil.rtrim( A65CitaTipoDiagnostico), 1, cmbCitaTipoDiagnostico.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbCitaTipoDiagnostico.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_CitaGeneral.htm");
         cmbCitaTipoDiagnostico.setValue( GXutil.rtrim( A65CitaTipoDiagnostico) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaTipoDiagnostico.getInternalname(), "Values", cmbCitaTipoDiagnostico.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadId_Internalname, "Disponibilidad Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadFecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadFecha_Internalname, "Disponibilidad Fecha", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadFecha_Internalname, localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"), localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadFecha_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_CitaGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadHoraInicio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadHoraInicio_Internalname, "Hora Inicio", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadHoraInicio_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadHoraInicio_Internalname, localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A68SGCitaDisponibilidadHoraInicio, "99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadHoraInicio_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadHoraInicio_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadHoraInicio_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadHoraInicio_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_CitaGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadHoraFin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadHoraFin_Internalname, "Hora Fin", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadHoraFin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadHoraFin_Internalname, localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A387SGCitaDisponibilidadHoraFin, "99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadHoraFin_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadHoraFin_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadHoraFin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadHoraFin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_CitaGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadEspecialidadId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Especialidad Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadEspecialidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadEspecialidadId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadEspecialidadNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Especialidad Nombre", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, A146SGCitaDisponibilidadEspecialidadNombre, GXutil.rtrim( localUtil.format( A146SGCitaDisponibilidadEspecialidadNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtSGCitaDisponibilidadEspecialidadNombre_Link, "", "", "", edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadSedeId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadSedeId_Internalname, "Sede Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadSedeId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadSedeId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadSedeId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadSedeNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadSedeNombre_Internalname, "Sede Nombre", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadSedeNombre_Internalname, A73SGCitaDisponibilidadSedeNombre, GXutil.rtrim( localUtil.format( A73SGCitaDisponibilidadSedeNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtSGCitaDisponibilidadSedeNombre_Link, "", "", "", edtSGCitaDisponibilidadSedeNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadSedeNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadClinicaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, "Clinica Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadClinicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadClinicaNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Clinica Nombre", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, A78SGCitaDisponibilidadClinicaNombre, GXutil.rtrim( localUtil.format( A78SGCitaDisponibilidadClinicaNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadProfesionalId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, "Profesional Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProfesionalId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadProFullName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, "Full Name", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, A82SGCitaDisponibilidadProFullName, GXutil.rtrim( localUtil.format( A82SGCitaDisponibilidadProFullName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProFullName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadProFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadProCOP_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProCOP_Internalname, "Pro COP", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProCOP_Internalname, A87SGCitaDisponibilidadProCOP, GXutil.rtrim( localUtil.format( A87SGCitaDisponibilidadProCOP, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProCOP_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadProCOP_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCitaEstadoCita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaEstadoCita.getInternalname(), "Estado Cita", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaEstadoCita, cmbCitaEstadoCita.getInternalname(), GXutil.rtrim( A89CitaEstadoCita), 1, cmbCitaEstadoCita.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaEstadoCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_CitaGeneral.htm");
         cmbCitaEstadoCita.setValue( GXutil.rtrim( A89CitaEstadoCita) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstadoCita.getInternalname(), "Values", cmbCitaEstadoCita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaInforme_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaInforme_Internalname, "Informe", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaInforme_Internalname, A90CitaInforme, "", "", (short)(0), 1, edtCitaInforme_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaAntecedentes_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaAntecedentes_Internalname, "Antecedentes", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaAntecedentes_Internalname, A100CitaAntecedentes, "", "", (short)(0), 1, edtCitaAntecedentes_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaLink_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaLink_Internalname, "Link", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaLink_Internalname, A91CitaLink, GXutil.rtrim( localUtil.format( A91CitaLink, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtCitaLink_Link, edtCitaLink_Linktarget, "", "", edtCitaLink_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaLink_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaFechaReserva_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaFechaReserva_Internalname, "Fecha Reserva", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtCitaFechaReserva_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaFechaReserva_Internalname, localUtil.ttoc( A92CitaFechaReserva, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A92CitaFechaReserva, "99/99/99 99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaFechaReserva_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaFechaReserva_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtCitaFechaReserva_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCitaFechaReserva_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_CitaGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaLog_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaLog_Internalname, "Log", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaLog_Internalname, A93CitaLog, "", "", (short)(0), 1, edtCitaLog_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaEmailGenLink_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaEmailGenLink_Internalname, "Gen Link", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaEmailGenLink_Internalname, A94CitaEmailGenLink, GXutil.rtrim( localUtil.format( A94CitaEmailGenLink, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "mailto:"+A94CitaEmailGenLink, "", "", "", edtCitaEmailGenLink_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaEmailGenLink_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCitaEstado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaEstado.getInternalname(), "Estado", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaEstado, cmbCitaEstado.getInternalname(), GXutil.rtrim( A95CitaEstado), 1, cmbCitaEstado.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_CitaGeneral.htm");
         cmbCitaEstado.setValue( GXutil.rtrim( A95CitaEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstado.getInternalname(), "Values", cmbCitaEstado.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaMotivoConsulta_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaMotivoConsulta_Internalname, "Motivo Consulta", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaMotivoConsulta_Internalname, A99CitaMotivoConsulta, "", "", (short)(0), 1, edtCitaMotivoConsulta_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaArchivoNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaArchivoNombre_Internalname, "Archivo Nombre", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaArchivoNombre_Internalname, A96CitaArchivoNombre, GXutil.rtrim( localUtil.format( A96CitaArchivoNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaArchivoNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaArchivoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaArchivo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaArchivo_Internalname, "Archivo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         edtCitaArchivo_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "Filetype", edtCitaArchivo_Filetype, true);
         if ( ! (GXutil.strcmp("", A98CitaArchivo)==0) )
         {
            gxblobfileaux.setSource( A98CitaArchivo );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtCitaArchivo_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtCitaArchivo_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A98CitaArchivo = gxblobfileaux.getURI() ;
               n98CitaArchivo = false ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A98CitaArchivo", A98CitaArchivo);
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
               edtCitaArchivo_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "Filetype", edtCitaArchivo_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
         }
         com.projectthani.GxWebStd.gx_blob_field( httpContext, edtCitaArchivo_Internalname, GXutil.rtrim( A98CitaArchivo), httpContext.getResourceRelative(A98CitaArchivo), ((GXutil.strcmp("", edtCitaArchivo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtCitaArchivo_Filetype)==0) ? A98CitaArchivo : edtCitaArchivo_Filetype)) : edtCitaArchivo_Contenttype), false, "", edtCitaArchivo_Parameters, 0, edtCitaArchivo_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtCitaArchivo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+"", "", "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaArchivoExtencion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaArchivoExtencion_Internalname, "Archivo Extencion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaArchivoExtencion_Internalname, A333CitaArchivoExtencion, GXutil.rtrim( localUtil.format( A333CitaArchivoExtencion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaArchivoExtencion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaArchivoExtencion_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCitaConsentimiento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkCitaConsentimiento.getInternalname(), "Consentimiento", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkCitaConsentimiento.getInternalname(), GXutil.booltostr( A97CitaConsentimiento), "", "Consentimiento", 1, chkCitaConsentimiento.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkCitaGestante.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkCitaGestante.getInternalname(), "Gestante", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkCitaGestante.getInternalname(), GXutil.booltostr( A101CitaGestante), "", "Gestante", 1, chkCitaGestante.getEnabled(), "true", "", StyleString, ClassString, "", "", "");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCitaEstadoPago.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaEstadoPago.getInternalname(), "Estado Pago", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaEstadoPago, cmbCitaEstadoPago.getInternalname(), GXutil.rtrim( A102CitaEstadoPago), 1, cmbCitaEstadoPago.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaEstadoPago.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_CitaGeneral.htm");
         cmbCitaEstadoPago.setValue( GXutil.rtrim( A102CitaEstadoPago) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstadoPago.getInternalname(), "Values", cmbCitaEstadoPago.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaPeso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaPeso_Internalname, "Peso", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaPeso_Internalname, GXutil.ltrim( localUtil.ntoc( A306CitaPeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtCitaPeso_Enabled!=0) ? localUtil.format( A306CitaPeso, "ZZ9.99") : localUtil.format( A306CitaPeso, "ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaPeso_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaPeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaEstatura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaEstatura_Internalname, "Estatura", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaEstatura_Internalname, GXutil.ltrim( localUtil.ntoc( A307CitaEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtCitaEstatura_Enabled!=0) ? localUtil.format( A307CitaEstatura, "9.99") : localUtil.format( A307CitaEstatura, "9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaEstatura_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaEstatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaGeneral.htm");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TrnActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e113a1_client"+"'", TempTags, "", 2, "HLP_CitaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 201,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e123a1_client"+"'", TempTags, "", 2, "HLP_CitaGeneral.htm");
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

   public void start3A2( )
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
            Form.getMeta().addItem("description", "Cita General", (short)(0)) ;
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
            strup3A0( ) ;
         }
      }
   }

   public void ws3A2( )
   {
      start3A2( ) ;
      evt3A2( ) ;
   }

   public void evt3A2( )
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
                              strup3A0( ) ;
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
                              strup3A0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e133A2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3A0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e143A2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3A0( ) ;
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
                              strup3A0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
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

   public void we3A2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3A2( ) ;
         }
      }
   }

   public void pa3A2( )
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
      if ( cmbCitaTipoDiagnostico.getItemCount() > 0 )
      {
         A65CitaTipoDiagnostico = cmbCitaTipoDiagnostico.getValidValue(A65CitaTipoDiagnostico) ;
         n65CitaTipoDiagnostico = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaTipoDiagnostico.setValue( GXutil.rtrim( A65CitaTipoDiagnostico) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaTipoDiagnostico.getInternalname(), "Values", cmbCitaTipoDiagnostico.ToJavascriptSource(), true);
      }
      if ( cmbCitaEstadoCita.getItemCount() > 0 )
      {
         A89CitaEstadoCita = cmbCitaEstadoCita.getValidValue(A89CitaEstadoCita) ;
         n89CitaEstadoCita = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89CitaEstadoCita", A89CitaEstadoCita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaEstadoCita.setValue( GXutil.rtrim( A89CitaEstadoCita) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstadoCita.getInternalname(), "Values", cmbCitaEstadoCita.ToJavascriptSource(), true);
      }
      if ( cmbCitaEstado.getItemCount() > 0 )
      {
         A95CitaEstado = cmbCitaEstado.getValidValue(A95CitaEstado) ;
         n95CitaEstado = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A95CitaEstado", A95CitaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaEstado.setValue( GXutil.rtrim( A95CitaEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstado.getInternalname(), "Values", cmbCitaEstado.ToJavascriptSource(), true);
      }
      A97CitaConsentimiento = GXutil.strtobool( GXutil.booltostr( A97CitaConsentimiento)) ;
      n97CitaConsentimiento = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A97CitaConsentimiento", A97CitaConsentimiento);
      A101CitaGestante = GXutil.strtobool( GXutil.booltostr( A101CitaGestante)) ;
      n101CitaGestante = false ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A101CitaGestante", A101CitaGestante);
      if ( cmbCitaEstadoPago.getItemCount() > 0 )
      {
         A102CitaEstadoPago = cmbCitaEstadoPago.getValidValue(A102CitaEstadoPago) ;
         n102CitaEstadoPago = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A102CitaEstadoPago", A102CitaEstadoPago);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaEstadoPago.setValue( GXutil.rtrim( A102CitaEstadoPago) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbCitaEstadoPago.getInternalname(), "Values", cmbCitaEstadoPago.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3A2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "CitaGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf3A2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H003A2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A19CitaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A20PacienteId = H003A2_A20PacienteId[0] ;
            A307CitaEstatura = H003A2_A307CitaEstatura[0] ;
            n307CitaEstatura = H003A2_n307CitaEstatura[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A307CitaEstatura", GXutil.ltrimstr( A307CitaEstatura, 4, 2));
            A306CitaPeso = H003A2_A306CitaPeso[0] ;
            n306CitaPeso = H003A2_n306CitaPeso[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A306CitaPeso", GXutil.ltrimstr( A306CitaPeso, 6, 2));
            A102CitaEstadoPago = H003A2_A102CitaEstadoPago[0] ;
            n102CitaEstadoPago = H003A2_n102CitaEstadoPago[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A102CitaEstadoPago", A102CitaEstadoPago);
            A101CitaGestante = H003A2_A101CitaGestante[0] ;
            n101CitaGestante = H003A2_n101CitaGestante[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A101CitaGestante", A101CitaGestante);
            A97CitaConsentimiento = H003A2_A97CitaConsentimiento[0] ;
            n97CitaConsentimiento = H003A2_n97CitaConsentimiento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A97CitaConsentimiento", A97CitaConsentimiento);
            A333CitaArchivoExtencion = H003A2_A333CitaArchivoExtencion[0] ;
            n333CitaArchivoExtencion = H003A2_n333CitaArchivoExtencion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A333CitaArchivoExtencion", A333CitaArchivoExtencion);
            A98CitaArchivo = H003A2_A98CitaArchivo[0] ;
            n98CitaArchivo = H003A2_n98CitaArchivo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A98CitaArchivo", A98CitaArchivo);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
            A96CitaArchivoNombre = H003A2_A96CitaArchivoNombre[0] ;
            n96CitaArchivoNombre = H003A2_n96CitaArchivoNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A96CitaArchivoNombre", A96CitaArchivoNombre);
            A99CitaMotivoConsulta = H003A2_A99CitaMotivoConsulta[0] ;
            n99CitaMotivoConsulta = H003A2_n99CitaMotivoConsulta[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A99CitaMotivoConsulta", A99CitaMotivoConsulta);
            A95CitaEstado = H003A2_A95CitaEstado[0] ;
            n95CitaEstado = H003A2_n95CitaEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A95CitaEstado", A95CitaEstado);
            A94CitaEmailGenLink = H003A2_A94CitaEmailGenLink[0] ;
            n94CitaEmailGenLink = H003A2_n94CitaEmailGenLink[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A94CitaEmailGenLink", A94CitaEmailGenLink);
            A93CitaLog = H003A2_A93CitaLog[0] ;
            n93CitaLog = H003A2_n93CitaLog[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A93CitaLog", A93CitaLog);
            A92CitaFechaReserva = H003A2_A92CitaFechaReserva[0] ;
            n92CitaFechaReserva = H003A2_n92CitaFechaReserva[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A92CitaFechaReserva", localUtil.ttoc( A92CitaFechaReserva, 8, 5, 0, 3, "/", ":", " "));
            A91CitaLink = H003A2_A91CitaLink[0] ;
            n91CitaLink = H003A2_n91CitaLink[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A91CitaLink", A91CitaLink);
            A100CitaAntecedentes = H003A2_A100CitaAntecedentes[0] ;
            n100CitaAntecedentes = H003A2_n100CitaAntecedentes[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A100CitaAntecedentes", A100CitaAntecedentes);
            A90CitaInforme = H003A2_A90CitaInforme[0] ;
            n90CitaInforme = H003A2_n90CitaInforme[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A90CitaInforme", A90CitaInforme);
            A89CitaEstadoCita = H003A2_A89CitaEstadoCita[0] ;
            n89CitaEstadoCita = H003A2_n89CitaEstadoCita[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89CitaEstadoCita", A89CitaEstadoCita);
            A87SGCitaDisponibilidadProCOP = H003A2_A87SGCitaDisponibilidadProCOP[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
            A81SGCitaDisponibilidadProfesionalId = H003A2_A81SGCitaDisponibilidadProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
            A78SGCitaDisponibilidadClinicaNombre = H003A2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
            A76SGCitaDisponibilidadClinicaId = H003A2_A76SGCitaDisponibilidadClinicaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
            A73SGCitaDisponibilidadSedeNombre = H003A2_A73SGCitaDisponibilidadSedeNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
            A72SGCitaDisponibilidadSedeId = H003A2_A72SGCitaDisponibilidadSedeId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
            A146SGCitaDisponibilidadEspecialidadNombre = H003A2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
            A70SGCitaDisponibilidadEspecialidadId = H003A2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
            A387SGCitaDisponibilidadHoraFin = H003A2_A387SGCitaDisponibilidadHoraFin[0] ;
            n387SGCitaDisponibilidadHoraFin = H003A2_n387SGCitaDisponibilidadHoraFin[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            A68SGCitaDisponibilidadHoraInicio = H003A2_A68SGCitaDisponibilidadHoraInicio[0] ;
            n68SGCitaDisponibilidadHoraInicio = H003A2_n68SGCitaDisponibilidadHoraInicio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            A66SGCitaDisponibilidadFecha = H003A2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H003A2_n66SGCitaDisponibilidadFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            A21SGCitaDisponibilidadId = H003A2_A21SGCitaDisponibilidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
            A65CitaTipoDiagnostico = H003A2_A65CitaTipoDiagnostico[0] ;
            n65CitaTipoDiagnostico = H003A2_n65CitaTipoDiagnostico[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
            A106PacienteNroDocumento = H003A2_A106PacienteNroDocumento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
            A104PacienteApellidoMaterno = H003A2_A104PacienteApellidoMaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A103PacienteApellidoPaterno = H003A2_A103PacienteApellidoPaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A105PacienteNombres = H003A2_A105PacienteNombres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
            A64CitaCode = H003A2_A64CitaCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
            A86ProfesionalApellidoMaterno = H003A2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H003A2_n86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = H003A2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H003A2_n85ProfesionalApellidoPaterno[0] ;
            A84ProfesionalNombres = H003A2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H003A2_n84ProfesionalNombres[0] ;
            A106PacienteNroDocumento = H003A2_A106PacienteNroDocumento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
            A104PacienteApellidoMaterno = H003A2_A104PacienteApellidoMaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A103PacienteApellidoPaterno = H003A2_A103PacienteApellidoPaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A105PacienteNombres = H003A2_A105PacienteNombres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
            A81SGCitaDisponibilidadProfesionalId = H003A2_A81SGCitaDisponibilidadProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
            A72SGCitaDisponibilidadSedeId = H003A2_A72SGCitaDisponibilidadSedeId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
            A70SGCitaDisponibilidadEspecialidadId = H003A2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
            A387SGCitaDisponibilidadHoraFin = H003A2_A387SGCitaDisponibilidadHoraFin[0] ;
            n387SGCitaDisponibilidadHoraFin = H003A2_n387SGCitaDisponibilidadHoraFin[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            A68SGCitaDisponibilidadHoraInicio = H003A2_A68SGCitaDisponibilidadHoraInicio[0] ;
            n68SGCitaDisponibilidadHoraInicio = H003A2_n68SGCitaDisponibilidadHoraInicio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            A66SGCitaDisponibilidadFecha = H003A2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H003A2_n66SGCitaDisponibilidadFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            A87SGCitaDisponibilidadProCOP = H003A2_A87SGCitaDisponibilidadProCOP[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
            A86ProfesionalApellidoMaterno = H003A2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H003A2_n86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = H003A2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H003A2_n85ProfesionalApellidoPaterno[0] ;
            A84ProfesionalNombres = H003A2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H003A2_n84ProfesionalNombres[0] ;
            A76SGCitaDisponibilidadClinicaId = H003A2_A76SGCitaDisponibilidadClinicaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
            A73SGCitaDisponibilidadSedeNombre = H003A2_A73SGCitaDisponibilidadSedeNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
            A78SGCitaDisponibilidadClinicaNombre = H003A2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
            A146SGCitaDisponibilidadEspecialidadNombre = H003A2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
            A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
            /* Execute user event: Load */
            e143A2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb3A0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3A2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "CitaGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup3A0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e133A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA19CitaId"), ",", ".")) ;
         /* Read variables values. */
         A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
         A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
         A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A106PacienteNroDocumento = httpContext.cgiGet( edtPacienteNroDocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
         cmbCitaTipoDiagnostico.setValue( httpContext.cgiGet( cmbCitaTipoDiagnostico.getInternalname()) );
         A65CitaTipoDiagnostico = httpContext.cgiGet( cmbCitaTipoDiagnostico.getInternalname()) ;
         n65CitaTipoDiagnostico = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
         A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         A66SGCitaDisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 3) ;
         n66SGCitaDisponibilidadFecha = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A68SGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraInicio_Internalname))) ;
         n68SGCitaDisponibilidadHoraInicio = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
         A387SGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraFin_Internalname))) ;
         n387SGCitaDisponibilidadHoraFin = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
         A70SGCitaDisponibilidadEspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         A146SGCitaDisponibilidadEspecialidadNombre = httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         A72SGCitaDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadSedeId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
         A73SGCitaDisponibilidadSedeNombre = httpContext.cgiGet( edtSGCitaDisponibilidadSedeNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
         A76SGCitaDisponibilidadClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadClinicaId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         A78SGCitaDisponibilidadClinicaNombre = httpContext.cgiGet( edtSGCitaDisponibilidadClinicaNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         A81SGCitaDisponibilidadProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadProfesionalId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A82SGCitaDisponibilidadProFullName = httpContext.cgiGet( edtSGCitaDisponibilidadProFullName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
         A87SGCitaDisponibilidadProCOP = httpContext.cgiGet( edtSGCitaDisponibilidadProCOP_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
         cmbCitaEstadoCita.setValue( httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) );
         A89CitaEstadoCita = httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) ;
         n89CitaEstadoCita = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A89CitaEstadoCita", A89CitaEstadoCita);
         A90CitaInforme = httpContext.cgiGet( edtCitaInforme_Internalname) ;
         n90CitaInforme = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A90CitaInforme", A90CitaInforme);
         A100CitaAntecedentes = httpContext.cgiGet( edtCitaAntecedentes_Internalname) ;
         n100CitaAntecedentes = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A100CitaAntecedentes", A100CitaAntecedentes);
         A91CitaLink = httpContext.cgiGet( edtCitaLink_Internalname) ;
         n91CitaLink = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A91CitaLink", A91CitaLink);
         A92CitaFechaReserva = localUtil.ctot( httpContext.cgiGet( edtCitaFechaReserva_Internalname)) ;
         n92CitaFechaReserva = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A92CitaFechaReserva", localUtil.ttoc( A92CitaFechaReserva, 8, 5, 0, 3, "/", ":", " "));
         A93CitaLog = httpContext.cgiGet( edtCitaLog_Internalname) ;
         n93CitaLog = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A93CitaLog", A93CitaLog);
         A94CitaEmailGenLink = httpContext.cgiGet( edtCitaEmailGenLink_Internalname) ;
         n94CitaEmailGenLink = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A94CitaEmailGenLink", A94CitaEmailGenLink);
         cmbCitaEstado.setValue( httpContext.cgiGet( cmbCitaEstado.getInternalname()) );
         A95CitaEstado = httpContext.cgiGet( cmbCitaEstado.getInternalname()) ;
         n95CitaEstado = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A95CitaEstado", A95CitaEstado);
         A99CitaMotivoConsulta = httpContext.cgiGet( edtCitaMotivoConsulta_Internalname) ;
         n99CitaMotivoConsulta = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A99CitaMotivoConsulta", A99CitaMotivoConsulta);
         A96CitaArchivoNombre = httpContext.cgiGet( edtCitaArchivoNombre_Internalname) ;
         n96CitaArchivoNombre = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A96CitaArchivoNombre", A96CitaArchivoNombre);
         A98CitaArchivo = httpContext.cgiGet( edtCitaArchivo_Internalname) ;
         n98CitaArchivo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A98CitaArchivo", A98CitaArchivo);
         A333CitaArchivoExtencion = httpContext.cgiGet( edtCitaArchivoExtencion_Internalname) ;
         n333CitaArchivoExtencion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A333CitaArchivoExtencion", A333CitaArchivoExtencion);
         A97CitaConsentimiento = GXutil.strtobool( httpContext.cgiGet( chkCitaConsentimiento.getInternalname())) ;
         n97CitaConsentimiento = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A97CitaConsentimiento", A97CitaConsentimiento);
         A101CitaGestante = GXutil.strtobool( httpContext.cgiGet( chkCitaGestante.getInternalname())) ;
         n101CitaGestante = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A101CitaGestante", A101CitaGestante);
         cmbCitaEstadoPago.setValue( httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) );
         A102CitaEstadoPago = httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) ;
         n102CitaEstadoPago = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A102CitaEstadoPago", A102CitaEstadoPago);
         A306CitaPeso = localUtil.ctond( httpContext.cgiGet( edtCitaPeso_Internalname)) ;
         n306CitaPeso = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A306CitaPeso", GXutil.ltrimstr( A306CitaPeso, 6, 2));
         A307CitaEstatura = localUtil.ctond( httpContext.cgiGet( edtCitaEstatura_Internalname)) ;
         n307CitaEstatura = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A307CitaEstatura", GXutil.ltrimstr( A307CitaEstatura, 4, 2));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"CitaGeneral");
         A91CitaLink = httpContext.cgiGet( edtCitaLink_Internalname) ;
         n91CitaLink = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A91CitaLink", A91CitaLink);
         forbiddenHiddens.add("CitaLink", GXutil.rtrim( localUtil.format( A91CitaLink, "")));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("citageneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e133A2 ();
      if (returnInSub) return;
   }

   public void e133A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV6WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV6WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
   }

   protected void nextLoad( )
   {
   }

   protected void e143A2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean3) ;
      citageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( AV13TempBoolean )
      {
         edtPacienteNombres_Link = formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PacienteId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPacienteNombres_Internalname, "Link", edtPacienteNombres_Link, true);
      }
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean3) ;
      citageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( AV13TempBoolean )
      {
         edtSGCitaDisponibilidadEspecialidadNombre_Link = formatLink("com.projectthani.especialidadview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A70SGCitaDisponibilidadEspecialidadId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"EspecialidadId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Link", edtSGCitaDisponibilidadEspecialidadNombre_Link, true);
      }
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede", GXv_boolean3) ;
      citageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( AV13TempBoolean )
      {
         edtSGCitaDisponibilidadSedeNombre_Link = formatLink("com.projectthani.sedeview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A72SGCitaDisponibilidadSedeId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SedeId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtSGCitaDisponibilidadSedeNombre_Internalname, "Link", edtSGCitaDisponibilidadSedeNombre_Link, true);
      }
      edtCitaLink_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaLink_Internalname, "Linktarget", edtCitaLink_Linktarget, true);
      edtCitaLink_Link = A91CitaLink ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaLink_Internalname, "Link", edtCitaLink_Link, true);
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Update", GXv_boolean3) ;
      citageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Delete", GXv_boolean3) ;
      citageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtndelete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtndelete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtndelete_Visible), 5, 0), true);
      }
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV8TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV18Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Cita" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A19CitaId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
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
      pa3A2( ) ;
      ws3A2( ) ;
      we3A2( ) ;
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
      sCtrlA19CitaId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3A2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "citageneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3A2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A19CitaId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      wcpOA19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA19CitaId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A19CitaId != wcpOA19CitaId ) ) )
      {
         setjustcreated();
      }
      wcpOA19CitaId = A19CitaId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA19CitaId = httpContext.cgiGet( sPrefix+"A19CitaId_CTRL") ;
      if ( GXutil.len( sCtrlA19CitaId) > 0 )
      {
         A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA19CitaId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      else
      {
         A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A19CitaId_PARM"), ",", ".")) ;
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
      pa3A2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3A2( ) ;
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
      ws3A2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A19CitaId_PARM", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA19CitaId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A19CitaId_CTRL", GXutil.rtrim( sCtrlA19CitaId));
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
      we3A2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323118", true, true);
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
      httpContext.AddJavascriptSource("citageneral.js", "?20225110323118", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCitaId_Internalname = sPrefix+"CITAID" ;
      edtCitaCode_Internalname = sPrefix+"CITACODE" ;
      edtPacienteNombres_Internalname = sPrefix+"PACIENTENOMBRES" ;
      edtPacienteApellidoPaterno_Internalname = sPrefix+"PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = sPrefix+"PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNroDocumento_Internalname = sPrefix+"PACIENTENRODOCUMENTO" ;
      cmbCitaTipoDiagnostico.setInternalname( sPrefix+"CITATIPODIAGNOSTICO" );
      edtSGCitaDisponibilidadId_Internalname = sPrefix+"SGCITADISPONIBILIDADID" ;
      edtSGCitaDisponibilidadFecha_Internalname = sPrefix+"SGCITADISPONIBILIDADFECHA" ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = sPrefix+"SGCITADISPONIBILIDADHORAINICIO" ;
      edtSGCitaDisponibilidadHoraFin_Internalname = sPrefix+"SGCITADISPONIBILIDADHORAFIN" ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = sPrefix+"SGCITADISPONIBILIDADESPECIALIDADID" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = sPrefix+"SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtSGCitaDisponibilidadSedeId_Internalname = sPrefix+"SGCITADISPONIBILIDADSEDEID" ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = sPrefix+"SGCITADISPONIBILIDADSEDENOMBRE" ;
      edtSGCitaDisponibilidadClinicaId_Internalname = sPrefix+"SGCITADISPONIBILIDADCLINICAID" ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = sPrefix+"SGCITADISPONIBILIDADCLINICANOMBRE" ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = sPrefix+"SGCITADISPONIBILIDADPROFESIONALID" ;
      edtSGCitaDisponibilidadProFullName_Internalname = sPrefix+"SGCITADISPONIBILIDADPROFULLNAME" ;
      edtSGCitaDisponibilidadProCOP_Internalname = sPrefix+"SGCITADISPONIBILIDADPROCOP" ;
      cmbCitaEstadoCita.setInternalname( sPrefix+"CITAESTADOCITA" );
      edtCitaInforme_Internalname = sPrefix+"CITAINFORME" ;
      edtCitaAntecedentes_Internalname = sPrefix+"CITAANTECEDENTES" ;
      edtCitaLink_Internalname = sPrefix+"CITALINK" ;
      edtCitaFechaReserva_Internalname = sPrefix+"CITAFECHARESERVA" ;
      edtCitaLog_Internalname = sPrefix+"CITALOG" ;
      edtCitaEmailGenLink_Internalname = sPrefix+"CITAEMAILGENLINK" ;
      cmbCitaEstado.setInternalname( sPrefix+"CITAESTADO" );
      edtCitaMotivoConsulta_Internalname = sPrefix+"CITAMOTIVOCONSULTA" ;
      edtCitaArchivoNombre_Internalname = sPrefix+"CITAARCHIVONOMBRE" ;
      edtCitaArchivo_Internalname = sPrefix+"CITAARCHIVO" ;
      edtCitaArchivoExtencion_Internalname = sPrefix+"CITAARCHIVOEXTENCION" ;
      chkCitaConsentimiento.setInternalname( sPrefix+"CITACONSENTIMIENTO" );
      chkCitaGestante.setInternalname( sPrefix+"CITAGESTANTE" );
      cmbCitaEstadoPago.setInternalname( sPrefix+"CITAESTADOPAGO" );
      edtCitaPeso_Internalname = sPrefix+"CITAPESO" ;
      edtCitaEstatura_Internalname = sPrefix+"CITAESTATURA" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
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
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtCitaEstatura_Jsonclick = "" ;
      edtCitaEstatura_Enabled = 0 ;
      edtCitaPeso_Jsonclick = "" ;
      edtCitaPeso_Enabled = 0 ;
      cmbCitaEstadoPago.setJsonclick( "" );
      cmbCitaEstadoPago.setEnabled( 0 );
      chkCitaGestante.setEnabled( 0 );
      chkCitaConsentimiento.setEnabled( 0 );
      edtCitaArchivoExtencion_Jsonclick = "" ;
      edtCitaArchivoExtencion_Enabled = 0 ;
      edtCitaArchivo_Jsonclick = "" ;
      edtCitaArchivo_Parameters = "" ;
      edtCitaArchivo_Contenttype = "" ;
      edtCitaArchivo_Filetype = "" ;
      edtCitaArchivo_Enabled = 0 ;
      edtCitaArchivoNombre_Jsonclick = "" ;
      edtCitaArchivoNombre_Enabled = 0 ;
      edtCitaMotivoConsulta_Enabled = 0 ;
      cmbCitaEstado.setJsonclick( "" );
      cmbCitaEstado.setEnabled( 0 );
      edtCitaEmailGenLink_Jsonclick = "" ;
      edtCitaEmailGenLink_Enabled = 0 ;
      edtCitaLog_Enabled = 0 ;
      edtCitaFechaReserva_Jsonclick = "" ;
      edtCitaFechaReserva_Enabled = 0 ;
      edtCitaLink_Jsonclick = "" ;
      edtCitaLink_Linktarget = "" ;
      edtCitaLink_Link = "" ;
      edtCitaLink_Enabled = 0 ;
      edtCitaAntecedentes_Enabled = 0 ;
      edtCitaInforme_Enabled = 0 ;
      cmbCitaEstadoCita.setJsonclick( "" );
      cmbCitaEstadoCita.setEnabled( 0 );
      edtSGCitaDisponibilidadProCOP_Jsonclick = "" ;
      edtSGCitaDisponibilidadProCOP_Enabled = 0 ;
      edtSGCitaDisponibilidadProFullName_Jsonclick = "" ;
      edtSGCitaDisponibilidadProFullName_Enabled = 0 ;
      edtSGCitaDisponibilidadProfesionalId_Jsonclick = "" ;
      edtSGCitaDisponibilidadProfesionalId_Enabled = 0 ;
      edtSGCitaDisponibilidadClinicaNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadClinicaId_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaId_Enabled = 0 ;
      edtSGCitaDisponibilidadSedeNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadSedeNombre_Link = "" ;
      edtSGCitaDisponibilidadSedeNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadSedeId_Jsonclick = "" ;
      edtSGCitaDisponibilidadSedeId_Enabled = 0 ;
      edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Link = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadEspecialidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadId_Enabled = 0 ;
      edtSGCitaDisponibilidadHoraFin_Jsonclick = "" ;
      edtSGCitaDisponibilidadHoraFin_Enabled = 0 ;
      edtSGCitaDisponibilidadHoraInicio_Jsonclick = "" ;
      edtSGCitaDisponibilidadHoraInicio_Enabled = 0 ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      edtSGCitaDisponibilidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadId_Enabled = 0 ;
      cmbCitaTipoDiagnostico.setJsonclick( "" );
      cmbCitaTipoDiagnostico.setEnabled( 0 );
      edtPacienteNroDocumento_Jsonclick = "" ;
      edtPacienteNroDocumento_Enabled = 0 ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Enabled = 0 ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Enabled = 0 ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteNombres_Link = "" ;
      edtPacienteNombres_Enabled = 0 ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaCode_Enabled = 0 ;
      edtCitaId_Jsonclick = "" ;
      edtCitaId_Enabled = 0 ;
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
      cmbCitaTipoDiagnostico.setName( "CITATIPODIAGNOSTICO" );
      cmbCitaTipoDiagnostico.setWebtags( "" );
      cmbCitaTipoDiagnostico.addItem("Prensuntivo", "Prensuntivo", (short)(0));
      cmbCitaTipoDiagnostico.addItem("Definitivo", "Definitivo", (short)(0));
      cmbCitaTipoDiagnostico.addItem("Repetitivo", "Repetitivo", (short)(0));
      if ( cmbCitaTipoDiagnostico.getItemCount() > 0 )
      {
      }
      cmbCitaEstadoCita.setName( "CITAESTADOCITA" );
      cmbCitaEstadoCita.setWebtags( "" );
      cmbCitaEstadoCita.addItem("R", "Registrado", (short)(0));
      cmbCitaEstadoCita.addItem("C", "Confirmado", (short)(0));
      cmbCitaEstadoCita.addItem("A", "En Atención", (short)(0));
      cmbCitaEstadoCita.addItem("F", "Finalizado", (short)(0));
      cmbCitaEstadoCita.addItem("X", "Cancelado", (short)(0));
      cmbCitaEstadoCita.addItem("N", "No se presentó", (short)(0));
      if ( cmbCitaEstadoCita.getItemCount() > 0 )
      {
      }
      cmbCitaEstado.setName( "CITAESTADO" );
      cmbCitaEstado.setWebtags( "" );
      cmbCitaEstado.addItem("A", "Activo", (short)(0));
      cmbCitaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbCitaEstado.getItemCount() > 0 )
      {
      }
      chkCitaConsentimiento.setName( "CITACONSENTIMIENTO" );
      chkCitaConsentimiento.setWebtags( "" );
      chkCitaConsentimiento.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCitaConsentimiento.getInternalname(), "TitleCaption", chkCitaConsentimiento.getCaption(), true);
      chkCitaConsentimiento.setCheckedValue( "false" );
      chkCitaGestante.setName( "CITAGESTANTE" );
      chkCitaGestante.setWebtags( "" );
      chkCitaGestante.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkCitaGestante.getInternalname(), "TitleCaption", chkCitaGestante.getCaption(), true);
      chkCitaGestante.setCheckedValue( "false" );
      cmbCitaEstadoPago.setName( "CITAESTADOPAGO" );
      cmbCitaEstadoPago.setWebtags( "" );
      cmbCitaEstadoPago.addItem("S", "Sin Pago", (short)(0));
      cmbCitaEstadoPago.addItem("P", "Pendiente", (short)(0));
      cmbCitaEstadoPago.addItem("G", "Pagado", (short)(0));
      if ( cmbCitaEstadoPago.getItemCount() > 0 )
      {
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A91CitaLink',fld:'CITALINK',pic:''},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("'DOUPDATE'","{handler:'e113A1',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("'DOUPDATE'",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("'DODELETE'","{handler:'e123A1',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("'DODELETE'",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITAID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID","{handler:'valid_Sgcitadisponibilidadid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID","{handler:'valid_Sgcitadisponibilidadespecialidadid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADSEDEID","{handler:'valid_Sgcitadisponibilidadsedeid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADSEDEID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID","{handler:'valid_Sgcitadisponibilidadclinicaid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID","{handler:'valid_Sgcitadisponibilidadprofesionalid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
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
      forbiddenHiddens = new com.genexus.util.GXProperties();
      A91CitaLink = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      GX_FocusControl = "" ;
      A64CitaCode = "" ;
      A105PacienteNombres = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A106PacienteNroDocumento = "" ;
      A65CitaTipoDiagnostico = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      A89CitaEstadoCita = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A90CitaInforme = "" ;
      A100CitaAntecedentes = "" ;
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      A93CitaLog = "" ;
      A94CitaEmailGenLink = "" ;
      A95CitaEstado = "" ;
      A99CitaMotivoConsulta = "" ;
      A96CitaArchivoNombre = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A98CitaArchivo = "" ;
      A333CitaArchivoExtencion = "" ;
      A102CitaEstadoPago = "" ;
      A306CitaPeso = DecimalUtil.ZERO ;
      A307CitaEstatura = DecimalUtil.ZERO ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV18Pgmname = "" ;
      scmdbuf = "" ;
      H003A2_A19CitaId = new int[1] ;
      H003A2_A20PacienteId = new int[1] ;
      H003A2_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H003A2_n307CitaEstatura = new boolean[] {false} ;
      H003A2_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H003A2_n306CitaPeso = new boolean[] {false} ;
      H003A2_A102CitaEstadoPago = new String[] {""} ;
      H003A2_n102CitaEstadoPago = new boolean[] {false} ;
      H003A2_A101CitaGestante = new boolean[] {false} ;
      H003A2_n101CitaGestante = new boolean[] {false} ;
      H003A2_A97CitaConsentimiento = new boolean[] {false} ;
      H003A2_n97CitaConsentimiento = new boolean[] {false} ;
      H003A2_A333CitaArchivoExtencion = new String[] {""} ;
      H003A2_n333CitaArchivoExtencion = new boolean[] {false} ;
      H003A2_A98CitaArchivo = new String[] {""} ;
      H003A2_n98CitaArchivo = new boolean[] {false} ;
      H003A2_A96CitaArchivoNombre = new String[] {""} ;
      H003A2_n96CitaArchivoNombre = new boolean[] {false} ;
      H003A2_A99CitaMotivoConsulta = new String[] {""} ;
      H003A2_n99CitaMotivoConsulta = new boolean[] {false} ;
      H003A2_A95CitaEstado = new String[] {""} ;
      H003A2_n95CitaEstado = new boolean[] {false} ;
      H003A2_A94CitaEmailGenLink = new String[] {""} ;
      H003A2_n94CitaEmailGenLink = new boolean[] {false} ;
      H003A2_A93CitaLog = new String[] {""} ;
      H003A2_n93CitaLog = new boolean[] {false} ;
      H003A2_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      H003A2_n92CitaFechaReserva = new boolean[] {false} ;
      H003A2_A91CitaLink = new String[] {""} ;
      H003A2_n91CitaLink = new boolean[] {false} ;
      H003A2_A100CitaAntecedentes = new String[] {""} ;
      H003A2_n100CitaAntecedentes = new boolean[] {false} ;
      H003A2_A90CitaInforme = new String[] {""} ;
      H003A2_n90CitaInforme = new boolean[] {false} ;
      H003A2_A89CitaEstadoCita = new String[] {""} ;
      H003A2_n89CitaEstadoCita = new boolean[] {false} ;
      H003A2_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      H003A2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      H003A2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      H003A2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      H003A2_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      H003A2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      H003A2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      H003A2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      H003A2_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      H003A2_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      H003A2_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      H003A2_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      H003A2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H003A2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H003A2_A21SGCitaDisponibilidadId = new int[1] ;
      H003A2_A65CitaTipoDiagnostico = new String[] {""} ;
      H003A2_n65CitaTipoDiagnostico = new boolean[] {false} ;
      H003A2_A106PacienteNroDocumento = new String[] {""} ;
      H003A2_A104PacienteApellidoMaterno = new String[] {""} ;
      H003A2_A103PacienteApellidoPaterno = new String[] {""} ;
      H003A2_A105PacienteNombres = new String[] {""} ;
      H003A2_A64CitaCode = new String[] {""} ;
      H003A2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H003A2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      H003A2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H003A2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      H003A2_A84ProfesionalNombres = new String[] {""} ;
      H003A2_n84ProfesionalNombres = new boolean[] {false} ;
      hsh = "" ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA19CitaId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citageneral__default(),
         new Object[] {
             new Object[] {
            H003A2_A19CitaId, H003A2_A20PacienteId, H003A2_A307CitaEstatura, H003A2_n307CitaEstatura, H003A2_A306CitaPeso, H003A2_n306CitaPeso, H003A2_A102CitaEstadoPago, H003A2_n102CitaEstadoPago, H003A2_A101CitaGestante, H003A2_n101CitaGestante,
            H003A2_A97CitaConsentimiento, H003A2_n97CitaConsentimiento, H003A2_A333CitaArchivoExtencion, H003A2_n333CitaArchivoExtencion, H003A2_A98CitaArchivo, H003A2_n98CitaArchivo, H003A2_A96CitaArchivoNombre, H003A2_n96CitaArchivoNombre, H003A2_A99CitaMotivoConsulta, H003A2_n99CitaMotivoConsulta,
            H003A2_A95CitaEstado, H003A2_n95CitaEstado, H003A2_A94CitaEmailGenLink, H003A2_n94CitaEmailGenLink, H003A2_A93CitaLog, H003A2_n93CitaLog, H003A2_A92CitaFechaReserva, H003A2_n92CitaFechaReserva, H003A2_A91CitaLink, H003A2_n91CitaLink,
            H003A2_A100CitaAntecedentes, H003A2_n100CitaAntecedentes, H003A2_A90CitaInforme, H003A2_n90CitaInforme, H003A2_A89CitaEstadoCita, H003A2_n89CitaEstadoCita, H003A2_A87SGCitaDisponibilidadProCOP, H003A2_A81SGCitaDisponibilidadProfesionalId, H003A2_A78SGCitaDisponibilidadClinicaNombre, H003A2_A76SGCitaDisponibilidadClinicaId,
            H003A2_A73SGCitaDisponibilidadSedeNombre, H003A2_A72SGCitaDisponibilidadSedeId, H003A2_A146SGCitaDisponibilidadEspecialidadNombre, H003A2_A70SGCitaDisponibilidadEspecialidadId, H003A2_A387SGCitaDisponibilidadHoraFin, H003A2_n387SGCitaDisponibilidadHoraFin, H003A2_A68SGCitaDisponibilidadHoraInicio, H003A2_n68SGCitaDisponibilidadHoraInicio, H003A2_A66SGCitaDisponibilidadFecha, H003A2_n66SGCitaDisponibilidadFecha,
            H003A2_A21SGCitaDisponibilidadId, H003A2_A65CitaTipoDiagnostico, H003A2_n65CitaTipoDiagnostico, H003A2_A106PacienteNroDocumento, H003A2_A104PacienteApellidoMaterno, H003A2_A103PacienteApellidoPaterno, H003A2_A105PacienteNombres, H003A2_A64CitaCode, H003A2_A86ProfesionalApellidoMaterno, H003A2_n86ProfesionalApellidoMaterno,
            H003A2_A85ProfesionalApellidoPaterno, H003A2_n85ProfesionalApellidoPaterno, H003A2_A84ProfesionalNombres, H003A2_n84ProfesionalNombres
            }
         }
      );
      AV18Pgmname = "CitaGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "CitaGeneral" ;
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
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA19CitaId ;
   private int A19CitaId ;
   private int edtCitaId_Enabled ;
   private int edtCitaCode_Enabled ;
   private int edtPacienteNombres_Enabled ;
   private int edtPacienteApellidoPaterno_Enabled ;
   private int edtPacienteApellidoMaterno_Enabled ;
   private int edtPacienteNroDocumento_Enabled ;
   private int A21SGCitaDisponibilidadId ;
   private int edtSGCitaDisponibilidadId_Enabled ;
   private int edtSGCitaDisponibilidadFecha_Enabled ;
   private int edtSGCitaDisponibilidadHoraInicio_Enabled ;
   private int edtSGCitaDisponibilidadHoraFin_Enabled ;
   private int edtSGCitaDisponibilidadEspecialidadId_Enabled ;
   private int edtSGCitaDisponibilidadEspecialidadNombre_Enabled ;
   private int edtSGCitaDisponibilidadSedeId_Enabled ;
   private int edtSGCitaDisponibilidadSedeNombre_Enabled ;
   private int edtSGCitaDisponibilidadClinicaId_Enabled ;
   private int edtSGCitaDisponibilidadClinicaNombre_Enabled ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int edtSGCitaDisponibilidadProfesionalId_Enabled ;
   private int edtSGCitaDisponibilidadProFullName_Enabled ;
   private int edtSGCitaDisponibilidadProCOP_Enabled ;
   private int edtCitaInforme_Enabled ;
   private int edtCitaAntecedentes_Enabled ;
   private int edtCitaLink_Enabled ;
   private int edtCitaFechaReserva_Enabled ;
   private int edtCitaLog_Enabled ;
   private int edtCitaEmailGenLink_Enabled ;
   private int edtCitaMotivoConsulta_Enabled ;
   private int edtCitaArchivoNombre_Enabled ;
   private int edtCitaArchivo_Enabled ;
   private int edtCitaArchivoExtencion_Enabled ;
   private int edtCitaPeso_Enabled ;
   private int edtCitaEstatura_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int A20PacienteId ;
   private int idxLst ;
   private java.math.BigDecimal A306CitaPeso ;
   private java.math.BigDecimal A307CitaEstatura ;
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
   private String divLayoutmaintable_Internalname ;
   private String divTable_Internalname ;
   private String divTransactiondetail_tableattributes_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtCitaId_Jsonclick ;
   private String edtCitaCode_Internalname ;
   private String edtCitaCode_Jsonclick ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNombres_Link ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtPacienteNroDocumento_Jsonclick ;
   private String edtSGCitaDisponibilidadId_Internalname ;
   private String edtSGCitaDisponibilidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtSGCitaDisponibilidadHoraInicio_Internalname ;
   private String edtSGCitaDisponibilidadHoraInicio_Jsonclick ;
   private String edtSGCitaDisponibilidadHoraFin_Internalname ;
   private String edtSGCitaDisponibilidadHoraFin_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadId_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Link ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadSedeId_Internalname ;
   private String edtSGCitaDisponibilidadSedeId_Jsonclick ;
   private String edtSGCitaDisponibilidadSedeNombre_Internalname ;
   private String edtSGCitaDisponibilidadSedeNombre_Link ;
   private String edtSGCitaDisponibilidadSedeNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaId_Internalname ;
   private String edtSGCitaDisponibilidadClinicaId_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaNombre_Internalname ;
   private String edtSGCitaDisponibilidadClinicaNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadProfesionalId_Internalname ;
   private String edtSGCitaDisponibilidadProfesionalId_Jsonclick ;
   private String edtSGCitaDisponibilidadProFullName_Internalname ;
   private String edtSGCitaDisponibilidadProFullName_Jsonclick ;
   private String edtSGCitaDisponibilidadProCOP_Internalname ;
   private String edtSGCitaDisponibilidadProCOP_Jsonclick ;
   private String A89CitaEstadoCita ;
   private String edtCitaInforme_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtCitaAntecedentes_Internalname ;
   private String edtCitaLink_Internalname ;
   private String edtCitaLink_Link ;
   private String edtCitaLink_Linktarget ;
   private String edtCitaLink_Jsonclick ;
   private String edtCitaFechaReserva_Internalname ;
   private String edtCitaFechaReserva_Jsonclick ;
   private String edtCitaLog_Internalname ;
   private String edtCitaEmailGenLink_Internalname ;
   private String edtCitaEmailGenLink_Jsonclick ;
   private String A95CitaEstado ;
   private String edtCitaMotivoConsulta_Internalname ;
   private String edtCitaArchivoNombre_Internalname ;
   private String edtCitaArchivoNombre_Jsonclick ;
   private String edtCitaArchivo_Internalname ;
   private String edtCitaArchivo_Filetype ;
   private String edtCitaArchivo_Contenttype ;
   private String edtCitaArchivo_Parameters ;
   private String edtCitaArchivo_Jsonclick ;
   private String edtCitaArchivoExtencion_Internalname ;
   private String edtCitaArchivoExtencion_Jsonclick ;
   private String A102CitaEstadoPago ;
   private String edtCitaPeso_Internalname ;
   private String edtCitaPeso_Jsonclick ;
   private String edtCitaEstatura_Internalname ;
   private String edtCitaEstatura_Jsonclick ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV18Pgmname ;
   private String scmdbuf ;
   private String hsh ;
   private String sCtrlA19CitaId ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date A92CitaFechaReserva ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean n98CitaArchivo ;
   private boolean A97CitaConsentimiento ;
   private boolean A101CitaGestante ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n65CitaTipoDiagnostico ;
   private boolean n89CitaEstadoCita ;
   private boolean n95CitaEstado ;
   private boolean n97CitaConsentimiento ;
   private boolean n101CitaGestante ;
   private boolean n102CitaEstadoPago ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n307CitaEstatura ;
   private boolean n306CitaPeso ;
   private boolean n333CitaArchivoExtencion ;
   private boolean n96CitaArchivoNombre ;
   private boolean n99CitaMotivoConsulta ;
   private boolean n94CitaEmailGenLink ;
   private boolean n93CitaLog ;
   private boolean n92CitaFechaReserva ;
   private boolean n91CitaLink ;
   private boolean n100CitaAntecedentes ;
   private boolean n90CitaInforme ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n84ProfesionalNombres ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A90CitaInforme ;
   private String A100CitaAntecedentes ;
   private String A99CitaMotivoConsulta ;
   private String A98CitaArchivo ;
   private String A91CitaLink ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A64CitaCode ;
   private String A105PacienteNombres ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A106PacienteNroDocumento ;
   private String A65CitaTipoDiagnostico ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A87SGCitaDisponibilidadProCOP ;
   private String A93CitaLog ;
   private String A94CitaEmailGenLink ;
   private String A96CitaArchivoNombre ;
   private String A333CitaArchivoExtencion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbCitaTipoDiagnostico ;
   private HTMLChoice cmbCitaEstadoCita ;
   private HTMLChoice cmbCitaEstado ;
   private ICheckbox chkCitaConsentimiento ;
   private ICheckbox chkCitaGestante ;
   private HTMLChoice cmbCitaEstadoPago ;
   private IDataStoreProvider pr_default ;
   private int[] H003A2_A19CitaId ;
   private int[] H003A2_A20PacienteId ;
   private java.math.BigDecimal[] H003A2_A307CitaEstatura ;
   private boolean[] H003A2_n307CitaEstatura ;
   private java.math.BigDecimal[] H003A2_A306CitaPeso ;
   private boolean[] H003A2_n306CitaPeso ;
   private String[] H003A2_A102CitaEstadoPago ;
   private boolean[] H003A2_n102CitaEstadoPago ;
   private boolean[] H003A2_A101CitaGestante ;
   private boolean[] H003A2_n101CitaGestante ;
   private boolean[] H003A2_A97CitaConsentimiento ;
   private boolean[] H003A2_n97CitaConsentimiento ;
   private String[] H003A2_A333CitaArchivoExtencion ;
   private boolean[] H003A2_n333CitaArchivoExtencion ;
   private String[] H003A2_A98CitaArchivo ;
   private boolean[] H003A2_n98CitaArchivo ;
   private String[] H003A2_A96CitaArchivoNombre ;
   private boolean[] H003A2_n96CitaArchivoNombre ;
   private String[] H003A2_A99CitaMotivoConsulta ;
   private boolean[] H003A2_n99CitaMotivoConsulta ;
   private String[] H003A2_A95CitaEstado ;
   private boolean[] H003A2_n95CitaEstado ;
   private String[] H003A2_A94CitaEmailGenLink ;
   private boolean[] H003A2_n94CitaEmailGenLink ;
   private String[] H003A2_A93CitaLog ;
   private boolean[] H003A2_n93CitaLog ;
   private java.util.Date[] H003A2_A92CitaFechaReserva ;
   private boolean[] H003A2_n92CitaFechaReserva ;
   private String[] H003A2_A91CitaLink ;
   private boolean[] H003A2_n91CitaLink ;
   private String[] H003A2_A100CitaAntecedentes ;
   private boolean[] H003A2_n100CitaAntecedentes ;
   private String[] H003A2_A90CitaInforme ;
   private boolean[] H003A2_n90CitaInforme ;
   private String[] H003A2_A89CitaEstadoCita ;
   private boolean[] H003A2_n89CitaEstadoCita ;
   private String[] H003A2_A87SGCitaDisponibilidadProCOP ;
   private int[] H003A2_A81SGCitaDisponibilidadProfesionalId ;
   private String[] H003A2_A78SGCitaDisponibilidadClinicaNombre ;
   private short[] H003A2_A76SGCitaDisponibilidadClinicaId ;
   private String[] H003A2_A73SGCitaDisponibilidadSedeNombre ;
   private short[] H003A2_A72SGCitaDisponibilidadSedeId ;
   private String[] H003A2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] H003A2_A70SGCitaDisponibilidadEspecialidadId ;
   private java.util.Date[] H003A2_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] H003A2_n387SGCitaDisponibilidadHoraFin ;
   private java.util.Date[] H003A2_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] H003A2_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] H003A2_A66SGCitaDisponibilidadFecha ;
   private boolean[] H003A2_n66SGCitaDisponibilidadFecha ;
   private int[] H003A2_A21SGCitaDisponibilidadId ;
   private String[] H003A2_A65CitaTipoDiagnostico ;
   private boolean[] H003A2_n65CitaTipoDiagnostico ;
   private String[] H003A2_A106PacienteNroDocumento ;
   private String[] H003A2_A104PacienteApellidoMaterno ;
   private String[] H003A2_A103PacienteApellidoPaterno ;
   private String[] H003A2_A105PacienteNombres ;
   private String[] H003A2_A64CitaCode ;
   private String[] H003A2_A86ProfesionalApellidoMaterno ;
   private boolean[] H003A2_n86ProfesionalApellidoMaterno ;
   private String[] H003A2_A85ProfesionalApellidoPaterno ;
   private boolean[] H003A2_n85ProfesionalApellidoPaterno ;
   private String[] H003A2_A84ProfesionalNombres ;
   private boolean[] H003A2_n84ProfesionalNombres ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class citageneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003A2", "SELECT T1.[CitaId], T1.[PacienteId], T1.[CitaEstatura], T1.[CitaPeso], T1.[CitaEstadoPago], T1.[CitaGestante], T1.[CitaConsentimiento], T1.[CitaArchivoExtencion], T1.[CitaArchivo], T1.[CitaArchivoNombre], T1.[CitaMotivoConsulta], T1.[CitaEstado], T1.[CitaEmailGenLink], T1.[CitaLog], T1.[CitaFechaReserva], T1.[CitaLink], T1.[CitaAntecedentes], T1.[CitaInforme], T1.[CitaEstadoCita], T4.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T3.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[CitaTipoDiagnostico], T2.[PacienteNroDocumento], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNombres], T1.[CitaCode], T4.[ProfesionalApellidoMaterno], T4.[ProfesionalApellidoPaterno], T4.[ProfesionalNombres] FROM (((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId] = T3.[ProfesionalId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T3.[EspecialidadId]) WHERE T1.[CitaId] = ? ORDER BY T1.[CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(5, 1);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((boolean[]) buf[10])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getBLOBFile(9, "tmp", "");
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getLongVarchar(11);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(12, 1);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(14);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDateTime(15);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getLongVarchar(17);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getLongVarchar(18);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getString(19, 1);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(20);
               ((int[]) buf[37])[0] = rslt.getInt(21);
               ((String[]) buf[38])[0] = rslt.getVarchar(22);
               ((short[]) buf[39])[0] = rslt.getShort(23);
               ((String[]) buf[40])[0] = rslt.getVarchar(24);
               ((short[]) buf[41])[0] = rslt.getShort(25);
               ((String[]) buf[42])[0] = rslt.getVarchar(26);
               ((short[]) buf[43])[0] = rslt.getShort(27);
               ((java.util.Date[]) buf[44])[0] = GXutil.resetDate(rslt.getGXDateTime(28));
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[46])[0] = GXutil.resetDate(rslt.getGXDateTime(29));
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[48])[0] = rslt.getGXDate(30);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((int[]) buf[50])[0] = rslt.getInt(31);
               ((String[]) buf[51])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((String[]) buf[53])[0] = rslt.getVarchar(33);
               ((String[]) buf[54])[0] = rslt.getVarchar(34);
               ((String[]) buf[55])[0] = rslt.getVarchar(35);
               ((String[]) buf[56])[0] = rslt.getVarchar(36);
               ((String[]) buf[57])[0] = rslt.getVarchar(37);
               ((String[]) buf[58])[0] = rslt.getVarchar(38);
               ((boolean[]) buf[59])[0] = rslt.wasNull();
               ((String[]) buf[60])[0] = rslt.getVarchar(39);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((String[]) buf[62])[0] = rslt.getVarchar(40);
               ((boolean[]) buf[63])[0] = rslt.wasNull();
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

