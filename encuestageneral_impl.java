package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class encuestageneral_impl extends GXWebComponent
{
   public encuestageneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public encuestageneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( encuestageneral_impl.class ));
   }

   public encuestageneral_impl( int remoteHandle ,
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
      cmbEncuestaAtencion = new HTMLChoice();
      cmbEncuestaAtendido = new HTMLChoice();
      cmbEncuestaEstado = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "EncuestaId") ;
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
               A37EncuestaId = (short)(GXutil.lval( httpContext.GetPar( "EncuestaId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A37EncuestaId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "EncuestaId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "EncuestaId") ;
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
         pa3Y2( ) ;
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
         httpContext.writeValue( "Encuesta General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110324532", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.encuestageneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A37EncuestaId,4,0))}, new String[] {"EncuestaId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA37EncuestaId", GXutil.ltrim( localUtil.ntoc( wcpOA37EncuestaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROFESIONALNOMBRES", A84ProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROFESIONALAPELLIDOPATERNO", A85ProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"PROFESIONALAPELLIDOMATERNO", A86ProfesionalApellidoMaterno);
   }

   public void renderHtmlCloseForm3Y2( )
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
      return "EncuestaGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Encuesta General" ;
   }

   public void wb3Y0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.encuestageneral");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaId_Internalname, "Id", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEncuestaId_Internalname, GXutil.ltrim( localUtil.ntoc( A37EncuestaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtEncuestaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEncuestaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtEncuestaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaCode_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaCode_Internalname, "Cita Id", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaCode_Internalname, A64CitaCode, GXutil.rtrim( localUtil.format( A64CitaCode, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtCitaCode_Link, "", "", "", edtCitaCode_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaCode_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadProfesionalId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, "Profesional Id", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProfesionalId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadProFullName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, "Profesional", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, A82SGCitaDisponibilidadProFullName, GXutil.rtrim( localUtil.format( A82SGCitaDisponibilidadProFullName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProFullName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadProFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadEspecialidadId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Especialidad Id", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadEspecialidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadEspecialidadId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadEspecialidadNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Especialidad", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, A146SGCitaDisponibilidadEspecialidadNombre, GXutil.rtrim( localUtil.format( A146SGCitaDisponibilidadEspecialidadNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadId_Internalname, "Disponibilidad Id", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadFecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadFecha_Internalname, "Disponibilidad Fecha", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadFecha_Internalname, localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"), localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadFecha_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_EncuestaGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteId_Internalname, "Paciente Id", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoPaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoPaterno_Internalname, "Paciente Ap. Paterno", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoPaterno_Internalname, A103PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoPaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteApellidoPaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoMaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoMaterno_Internalname, "Paciente Ap. Materno", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoMaterno_Internalname, A104PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoMaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteApellidoMaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombres_Internalname, "Paciente Nombres", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombres_Internalname, A105PacienteNombres, GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtPacienteNombres_Link, "", "", "", edtPacienteNombres_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteNombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadClinicaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, "Clinica Id", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadClinicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadClinicaNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Clinica", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, A78SGCitaDisponibilidadClinicaNombre, GXutil.rtrim( localUtil.format( A78SGCitaDisponibilidadClinicaNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEncuestaAtencion.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEncuestaAtencion.getInternalname(), "Atencion", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEncuestaAtencion, cmbEncuestaAtencion.getInternalname(), GXutil.rtrim( A148EncuestaAtencion), 1, cmbEncuestaAtencion.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEncuestaAtencion.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_EncuestaGeneral.htm");
         cmbEncuestaAtencion.setValue( GXutil.rtrim( A148EncuestaAtencion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEncuestaAtencion.getInternalname(), "Values", cmbEncuestaAtencion.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEncuestaAtendido.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEncuestaAtendido.getInternalname(), "Atendido", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEncuestaAtendido, cmbEncuestaAtendido.getInternalname(), GXutil.rtrim( A149EncuestaAtendido), 1, cmbEncuestaAtendido.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEncuestaAtendido.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_EncuestaGeneral.htm");
         cmbEncuestaAtendido.setValue( GXutil.rtrim( A149EncuestaAtendido) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEncuestaAtendido.getInternalname(), "Values", cmbEncuestaAtendido.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaHoraAtencion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaHoraAtencion_Internalname, "Hora Atencion", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtEncuestaHoraAtencion_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEncuestaHoraAtencion_Internalname, localUtil.ttoc( A150EncuestaHoraAtencion, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A150EncuestaHoraAtencion, "99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEncuestaHoraAtencion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtEncuestaHoraAtencion_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtEncuestaHoraAtencion_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtEncuestaHoraAtencion_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_EncuestaGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaComentarios_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaComentarios_Internalname, "Comentarios", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtEncuestaComentarios_Internalname, A151EncuestaComentarios, "", "", (short)(0), 1, edtEncuestaComentarios_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaRecomendacion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaRecomendacion_Internalname, "Recomendacion", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEncuestaRecomendacion_Internalname, GXutil.ltrim( localUtil.ntoc( A152EncuestaRecomendacion, (byte)(2), (byte)(0), ",", "")), GXutil.ltrim( ((edtEncuestaRecomendacion_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEncuestaRecomendacion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtEncuestaRecomendacion_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEncuestaEstado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEncuestaEstado.getInternalname(), "Estado", " ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEncuestaEstado, cmbEncuestaEstado.getInternalname(), GXutil.rtrim( A153EncuestaEstado), 1, cmbEncuestaEstado.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEncuestaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_EncuestaGeneral.htm");
         cmbEncuestaEstado.setValue( GXutil.rtrim( A153EncuestaEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEncuestaEstado.getInternalname(), "Values", cmbEncuestaEstado.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e113y1_client"+"'", TempTags, "", 2, "HLP_EncuestaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e123y1_client"+"'", TempTags, "", 2, "HLP_EncuestaGeneral.htm");
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

   public void start3Y2( )
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
            Form.getMeta().addItem("description", "Encuesta General", (short)(0)) ;
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
            strup3Y0( ) ;
         }
      }
   }

   public void ws3Y2( )
   {
      start3Y2( ) ;
      evt3Y2( ) ;
   }

   public void evt3Y2( )
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
                              strup3Y0( ) ;
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
                              strup3Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e133Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3Y0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e143Y2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3Y0( ) ;
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
                              strup3Y0( ) ;
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

   public void we3Y2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3Y2( ) ;
         }
      }
   }

   public void pa3Y2( )
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
      if ( cmbEncuestaAtencion.getItemCount() > 0 )
      {
         A148EncuestaAtencion = cmbEncuestaAtencion.getValidValue(A148EncuestaAtencion) ;
         n148EncuestaAtencion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A148EncuestaAtencion", A148EncuestaAtencion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEncuestaAtencion.setValue( GXutil.rtrim( A148EncuestaAtencion) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEncuestaAtencion.getInternalname(), "Values", cmbEncuestaAtencion.ToJavascriptSource(), true);
      }
      if ( cmbEncuestaAtendido.getItemCount() > 0 )
      {
         A149EncuestaAtendido = cmbEncuestaAtendido.getValidValue(A149EncuestaAtendido) ;
         n149EncuestaAtendido = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A149EncuestaAtendido", A149EncuestaAtendido);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEncuestaAtendido.setValue( GXutil.rtrim( A149EncuestaAtendido) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEncuestaAtendido.getInternalname(), "Values", cmbEncuestaAtendido.ToJavascriptSource(), true);
      }
      if ( cmbEncuestaEstado.getItemCount() > 0 )
      {
         A153EncuestaEstado = cmbEncuestaEstado.getValidValue(A153EncuestaEstado) ;
         n153EncuestaEstado = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A153EncuestaEstado", A153EncuestaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEncuestaEstado.setValue( GXutil.rtrim( A153EncuestaEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbEncuestaEstado.getInternalname(), "Values", cmbEncuestaEstado.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3Y2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "EncuestaGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf3Y2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H003Y2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A37EncuestaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A72SGCitaDisponibilidadSedeId = H003Y2_A72SGCitaDisponibilidadSedeId[0] ;
            A19CitaId = H003Y2_A19CitaId[0] ;
            A153EncuestaEstado = H003Y2_A153EncuestaEstado[0] ;
            n153EncuestaEstado = H003Y2_n153EncuestaEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A153EncuestaEstado", A153EncuestaEstado);
            A152EncuestaRecomendacion = H003Y2_A152EncuestaRecomendacion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A152EncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), 2, 0));
            A151EncuestaComentarios = H003Y2_A151EncuestaComentarios[0] ;
            n151EncuestaComentarios = H003Y2_n151EncuestaComentarios[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A151EncuestaComentarios", A151EncuestaComentarios);
            A150EncuestaHoraAtencion = H003Y2_A150EncuestaHoraAtencion[0] ;
            n150EncuestaHoraAtencion = H003Y2_n150EncuestaHoraAtencion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
            A149EncuestaAtendido = H003Y2_A149EncuestaAtendido[0] ;
            n149EncuestaAtendido = H003Y2_n149EncuestaAtendido[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A149EncuestaAtendido", A149EncuestaAtendido);
            A148EncuestaAtencion = H003Y2_A148EncuestaAtencion[0] ;
            n148EncuestaAtencion = H003Y2_n148EncuestaAtencion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A148EncuestaAtencion", A148EncuestaAtencion);
            A78SGCitaDisponibilidadClinicaNombre = H003Y2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
            A76SGCitaDisponibilidadClinicaId = H003Y2_A76SGCitaDisponibilidadClinicaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
            A105PacienteNombres = H003Y2_A105PacienteNombres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
            A104PacienteApellidoMaterno = H003Y2_A104PacienteApellidoMaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A103PacienteApellidoPaterno = H003Y2_A103PacienteApellidoPaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A20PacienteId = H003Y2_A20PacienteId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            A66SGCitaDisponibilidadFecha = H003Y2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H003Y2_n66SGCitaDisponibilidadFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            A21SGCitaDisponibilidadId = H003Y2_A21SGCitaDisponibilidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
            A146SGCitaDisponibilidadEspecialidadNombre = H003Y2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
            A70SGCitaDisponibilidadEspecialidadId = H003Y2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
            A81SGCitaDisponibilidadProfesionalId = H003Y2_A81SGCitaDisponibilidadProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
            A64CitaCode = H003Y2_A64CitaCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
            A86ProfesionalApellidoMaterno = H003Y2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H003Y2_n86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = H003Y2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H003Y2_n85ProfesionalApellidoPaterno[0] ;
            A84ProfesionalNombres = H003Y2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H003Y2_n84ProfesionalNombres[0] ;
            A20PacienteId = H003Y2_A20PacienteId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            A21SGCitaDisponibilidadId = H003Y2_A21SGCitaDisponibilidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
            A64CitaCode = H003Y2_A64CitaCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
            A105PacienteNombres = H003Y2_A105PacienteNombres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
            A104PacienteApellidoMaterno = H003Y2_A104PacienteApellidoMaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A103PacienteApellidoPaterno = H003Y2_A103PacienteApellidoPaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A72SGCitaDisponibilidadSedeId = H003Y2_A72SGCitaDisponibilidadSedeId[0] ;
            A66SGCitaDisponibilidadFecha = H003Y2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H003Y2_n66SGCitaDisponibilidadFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            A70SGCitaDisponibilidadEspecialidadId = H003Y2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
            A81SGCitaDisponibilidadProfesionalId = H003Y2_A81SGCitaDisponibilidadProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
            A76SGCitaDisponibilidadClinicaId = H003Y2_A76SGCitaDisponibilidadClinicaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
            A78SGCitaDisponibilidadClinicaNombre = H003Y2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
            A146SGCitaDisponibilidadEspecialidadNombre = H003Y2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
            A86ProfesionalApellidoMaterno = H003Y2_A86ProfesionalApellidoMaterno[0] ;
            n86ProfesionalApellidoMaterno = H003Y2_n86ProfesionalApellidoMaterno[0] ;
            A85ProfesionalApellidoPaterno = H003Y2_A85ProfesionalApellidoPaterno[0] ;
            n85ProfesionalApellidoPaterno = H003Y2_n85ProfesionalApellidoPaterno[0] ;
            A84ProfesionalNombres = H003Y2_A84ProfesionalNombres[0] ;
            n84ProfesionalNombres = H003Y2_n84ProfesionalNombres[0] ;
            A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
            /* Execute user event: Load */
            e143Y2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb3Y0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3Y2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "EncuestaGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup3Y0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e133Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA37EncuestaId"), ",", ".")) ;
         /* Read variables values. */
         A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
         A81SGCitaDisponibilidadProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadProfesionalId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A82SGCitaDisponibilidadProFullName = httpContext.cgiGet( edtSGCitaDisponibilidadProFullName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
         A70SGCitaDisponibilidadEspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         A146SGCitaDisponibilidadEspecialidadNombre = httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         A66SGCitaDisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 3) ;
         n66SGCitaDisponibilidadFecha = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
         A76SGCitaDisponibilidadClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadClinicaId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         A78SGCitaDisponibilidadClinicaNombre = httpContext.cgiGet( edtSGCitaDisponibilidadClinicaNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         cmbEncuestaAtencion.setValue( httpContext.cgiGet( cmbEncuestaAtencion.getInternalname()) );
         A148EncuestaAtencion = httpContext.cgiGet( cmbEncuestaAtencion.getInternalname()) ;
         n148EncuestaAtencion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A148EncuestaAtencion", A148EncuestaAtencion);
         cmbEncuestaAtendido.setValue( httpContext.cgiGet( cmbEncuestaAtendido.getInternalname()) );
         A149EncuestaAtendido = httpContext.cgiGet( cmbEncuestaAtendido.getInternalname()) ;
         n149EncuestaAtendido = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A149EncuestaAtendido", A149EncuestaAtendido);
         A150EncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtEncuestaHoraAtencion_Internalname))) ;
         n150EncuestaHoraAtencion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
         A151EncuestaComentarios = httpContext.cgiGet( edtEncuestaComentarios_Internalname) ;
         n151EncuestaComentarios = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A151EncuestaComentarios", A151EncuestaComentarios);
         A152EncuestaRecomendacion = (byte)(localUtil.ctol( httpContext.cgiGet( edtEncuestaRecomendacion_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A152EncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), 2, 0));
         cmbEncuestaEstado.setValue( httpContext.cgiGet( cmbEncuestaEstado.getInternalname()) );
         A153EncuestaEstado = httpContext.cgiGet( cmbEncuestaEstado.getInternalname()) ;
         n153EncuestaEstado = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A153EncuestaEstado", A153EncuestaEstado);
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
      e133Y2 ();
      if (returnInSub) return;
   }

   public void e133Y2( )
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

   protected void e143Y2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita", GXv_boolean3) ;
      encuestageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( AV12TempBoolean )
      {
         edtCitaCode_Link = formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CitaId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaCode_Internalname, "Link", edtCitaCode_Link, true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente", GXv_boolean3) ;
      encuestageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( AV12TempBoolean )
      {
         edtPacienteNombres_Link = formatLink("com.projectthani.pacienteview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PacienteId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPacienteNombres_Internalname, "Link", edtPacienteNombres_Link, true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Update", GXv_boolean3) ;
      encuestageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Delete", GXv_boolean3) ;
      encuestageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( ! ( AV12TempBoolean ) )
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Encuesta" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A37EncuestaId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
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
      pa3Y2( ) ;
      ws3Y2( ) ;
      we3Y2( ) ;
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
      sCtrlA37EncuestaId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3Y2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "encuestageneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3Y2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A37EncuestaId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
      }
      wcpOA37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA37EncuestaId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A37EncuestaId != wcpOA37EncuestaId ) ) )
      {
         setjustcreated();
      }
      wcpOA37EncuestaId = A37EncuestaId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA37EncuestaId = httpContext.cgiGet( sPrefix+"A37EncuestaId_CTRL") ;
      if ( GXutil.len( sCtrlA37EncuestaId) > 0 )
      {
         A37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA37EncuestaId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
      }
      else
      {
         A37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A37EncuestaId_PARM"), ",", ".")) ;
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
      pa3Y2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3Y2( ) ;
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
      ws3Y2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A37EncuestaId_PARM", GXutil.ltrim( localUtil.ntoc( A37EncuestaId, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA37EncuestaId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A37EncuestaId_CTRL", GXutil.rtrim( sCtrlA37EncuestaId));
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
      we3Y2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110324618", true, true);
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
      httpContext.AddJavascriptSource("encuestageneral.js", "?20225110324619", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtEncuestaId_Internalname = sPrefix+"ENCUESTAID" ;
      edtCitaCode_Internalname = sPrefix+"CITACODE" ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = sPrefix+"SGCITADISPONIBILIDADPROFESIONALID" ;
      edtSGCitaDisponibilidadProFullName_Internalname = sPrefix+"SGCITADISPONIBILIDADPROFULLNAME" ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = sPrefix+"SGCITADISPONIBILIDADESPECIALIDADID" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = sPrefix+"SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtSGCitaDisponibilidadId_Internalname = sPrefix+"SGCITADISPONIBILIDADID" ;
      edtSGCitaDisponibilidadFecha_Internalname = sPrefix+"SGCITADISPONIBILIDADFECHA" ;
      edtPacienteId_Internalname = sPrefix+"PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = sPrefix+"PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = sPrefix+"PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = sPrefix+"PACIENTENOMBRES" ;
      edtSGCitaDisponibilidadClinicaId_Internalname = sPrefix+"SGCITADISPONIBILIDADCLINICAID" ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = sPrefix+"SGCITADISPONIBILIDADCLINICANOMBRE" ;
      cmbEncuestaAtencion.setInternalname( sPrefix+"ENCUESTAATENCION" );
      cmbEncuestaAtendido.setInternalname( sPrefix+"ENCUESTAATENDIDO" );
      edtEncuestaHoraAtencion_Internalname = sPrefix+"ENCUESTAHORAATENCION" ;
      edtEncuestaComentarios_Internalname = sPrefix+"ENCUESTACOMENTARIOS" ;
      edtEncuestaRecomendacion_Internalname = sPrefix+"ENCUESTARECOMENDACION" ;
      cmbEncuestaEstado.setInternalname( sPrefix+"ENCUESTAESTADO" );
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
      cmbEncuestaEstado.setJsonclick( "" );
      cmbEncuestaEstado.setEnabled( 0 );
      edtEncuestaRecomendacion_Jsonclick = "" ;
      edtEncuestaRecomendacion_Enabled = 0 ;
      edtEncuestaComentarios_Enabled = 0 ;
      edtEncuestaHoraAtencion_Jsonclick = "" ;
      edtEncuestaHoraAtencion_Enabled = 0 ;
      cmbEncuestaAtendido.setJsonclick( "" );
      cmbEncuestaAtendido.setEnabled( 0 );
      cmbEncuestaAtencion.setJsonclick( "" );
      cmbEncuestaAtencion.setEnabled( 0 );
      edtSGCitaDisponibilidadClinicaNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadClinicaId_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaId_Enabled = 0 ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteNombres_Link = "" ;
      edtPacienteNombres_Enabled = 0 ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Enabled = 0 ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Enabled = 0 ;
      edtPacienteId_Jsonclick = "" ;
      edtPacienteId_Enabled = 0 ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      edtSGCitaDisponibilidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadId_Enabled = 0 ;
      edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadEspecialidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadId_Enabled = 0 ;
      edtSGCitaDisponibilidadProFullName_Jsonclick = "" ;
      edtSGCitaDisponibilidadProFullName_Enabled = 0 ;
      edtSGCitaDisponibilidadProfesionalId_Jsonclick = "" ;
      edtSGCitaDisponibilidadProfesionalId_Enabled = 0 ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaCode_Link = "" ;
      edtCitaCode_Enabled = 0 ;
      edtEncuestaId_Jsonclick = "" ;
      edtEncuestaId_Enabled = 0 ;
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
      cmbEncuestaAtencion.setName( "ENCUESTAATENCION" );
      cmbEncuestaAtencion.setWebtags( "" );
      cmbEncuestaAtencion.addItem("B", "Buena", (short)(0));
      cmbEncuestaAtencion.addItem("R", "Regular", (short)(0));
      cmbEncuestaAtencion.addItem("M", "Mala", (short)(0));
      if ( cmbEncuestaAtencion.getItemCount() > 0 )
      {
      }
      cmbEncuestaAtendido.setName( "ENCUESTAATENDIDO" );
      cmbEncuestaAtendido.setWebtags( "" );
      cmbEncuestaAtendido.addItem("S", "Si", (short)(0));
      cmbEncuestaAtendido.addItem("N", "No", (short)(0));
      if ( cmbEncuestaAtendido.getItemCount() > 0 )
      {
      }
      cmbEncuestaEstado.setName( "ENCUESTAESTADO" );
      cmbEncuestaEstado.setWebtags( "" );
      cmbEncuestaEstado.addItem("P", "Pendiente", (short)(0));
      cmbEncuestaEstado.addItem("R", "Realizada", (short)(0));
      cmbEncuestaEstado.addItem("", "", (short)(0));
      if ( cmbEncuestaEstado.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A37EncuestaId',fld:'ENCUESTAID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e113Y1',iparms:[{av:'A37EncuestaId',fld:'ENCUESTAID',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e123Y1',iparms:[{av:'A37EncuestaId',fld:'ENCUESTAID',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_ENCUESTAID","{handler:'valid_Encuestaid',iparms:[]");
      setEventMetadata("VALID_ENCUESTAID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID","{handler:'valid_Sgcitadisponibilidadprofesionalid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID","{handler:'valid_Sgcitadisponibilidadespecialidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID","{handler:'valid_Sgcitadisponibilidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID","{handler:'valid_Sgcitadisponibilidadclinicaid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID",",oparms:[]}");
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
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      GX_FocusControl = "" ;
      A64CitaCode = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A148EncuestaAtencion = "" ;
      A149EncuestaAtendido = "" ;
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      ClassString = "" ;
      StyleString = "" ;
      A151EncuestaComentarios = "" ;
      A153EncuestaEstado = "" ;
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
      H003Y2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      H003Y2_A37EncuestaId = new short[1] ;
      H003Y2_A19CitaId = new int[1] ;
      H003Y2_A153EncuestaEstado = new String[] {""} ;
      H003Y2_n153EncuestaEstado = new boolean[] {false} ;
      H003Y2_A152EncuestaRecomendacion = new byte[1] ;
      H003Y2_A151EncuestaComentarios = new String[] {""} ;
      H003Y2_n151EncuestaComentarios = new boolean[] {false} ;
      H003Y2_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      H003Y2_n150EncuestaHoraAtencion = new boolean[] {false} ;
      H003Y2_A149EncuestaAtendido = new String[] {""} ;
      H003Y2_n149EncuestaAtendido = new boolean[] {false} ;
      H003Y2_A148EncuestaAtencion = new String[] {""} ;
      H003Y2_n148EncuestaAtencion = new boolean[] {false} ;
      H003Y2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      H003Y2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      H003Y2_A105PacienteNombres = new String[] {""} ;
      H003Y2_A104PacienteApellidoMaterno = new String[] {""} ;
      H003Y2_A103PacienteApellidoPaterno = new String[] {""} ;
      H003Y2_A20PacienteId = new int[1] ;
      H003Y2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H003Y2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H003Y2_A21SGCitaDisponibilidadId = new int[1] ;
      H003Y2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      H003Y2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      H003Y2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      H003Y2_A64CitaCode = new String[] {""} ;
      H003Y2_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H003Y2_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      H003Y2_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H003Y2_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      H003Y2_A84ProfesionalNombres = new String[] {""} ;
      H003Y2_n84ProfesionalNombres = new boolean[] {false} ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA37EncuestaId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.encuestageneral__default(),
         new Object[] {
             new Object[] {
            H003Y2_A72SGCitaDisponibilidadSedeId, H003Y2_A37EncuestaId, H003Y2_A19CitaId, H003Y2_A153EncuestaEstado, H003Y2_n153EncuestaEstado, H003Y2_A152EncuestaRecomendacion, H003Y2_A151EncuestaComentarios, H003Y2_n151EncuestaComentarios, H003Y2_A150EncuestaHoraAtencion, H003Y2_n150EncuestaHoraAtencion,
            H003Y2_A149EncuestaAtendido, H003Y2_n149EncuestaAtendido, H003Y2_A148EncuestaAtencion, H003Y2_n148EncuestaAtencion, H003Y2_A78SGCitaDisponibilidadClinicaNombre, H003Y2_A76SGCitaDisponibilidadClinicaId, H003Y2_A105PacienteNombres, H003Y2_A104PacienteApellidoMaterno, H003Y2_A103PacienteApellidoPaterno, H003Y2_A20PacienteId,
            H003Y2_A66SGCitaDisponibilidadFecha, H003Y2_n66SGCitaDisponibilidadFecha, H003Y2_A21SGCitaDisponibilidadId, H003Y2_A146SGCitaDisponibilidadEspecialidadNombre, H003Y2_A70SGCitaDisponibilidadEspecialidadId, H003Y2_A81SGCitaDisponibilidadProfesionalId, H003Y2_A64CitaCode, H003Y2_A86ProfesionalApellidoMaterno, H003Y2_n86ProfesionalApellidoMaterno, H003Y2_A85ProfesionalApellidoPaterno,
            H003Y2_n85ProfesionalApellidoPaterno, H003Y2_A84ProfesionalNombres, H003Y2_n84ProfesionalNombres
            }
         }
      );
      AV18Pgmname = "EncuestaGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "EncuestaGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A152EncuestaRecomendacion ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA37EncuestaId ;
   private short A37EncuestaId ;
   private short wbEnd ;
   private short wbStart ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A72SGCitaDisponibilidadSedeId ;
   private int edtEncuestaId_Enabled ;
   private int edtCitaCode_Enabled ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int edtSGCitaDisponibilidadProfesionalId_Enabled ;
   private int edtSGCitaDisponibilidadProFullName_Enabled ;
   private int edtSGCitaDisponibilidadEspecialidadId_Enabled ;
   private int edtSGCitaDisponibilidadEspecialidadNombre_Enabled ;
   private int A21SGCitaDisponibilidadId ;
   private int edtSGCitaDisponibilidadId_Enabled ;
   private int edtSGCitaDisponibilidadFecha_Enabled ;
   private int A20PacienteId ;
   private int edtPacienteId_Enabled ;
   private int edtPacienteApellidoPaterno_Enabled ;
   private int edtPacienteApellidoMaterno_Enabled ;
   private int edtPacienteNombres_Enabled ;
   private int edtSGCitaDisponibilidadClinicaId_Enabled ;
   private int edtSGCitaDisponibilidadClinicaNombre_Enabled ;
   private int edtEncuestaHoraAtencion_Enabled ;
   private int edtEncuestaComentarios_Enabled ;
   private int edtEncuestaRecomendacion_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int A19CitaId ;
   private int idxLst ;
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
   private String edtEncuestaId_Internalname ;
   private String edtEncuestaId_Jsonclick ;
   private String edtCitaCode_Internalname ;
   private String edtCitaCode_Link ;
   private String edtCitaCode_Jsonclick ;
   private String edtSGCitaDisponibilidadProfesionalId_Internalname ;
   private String edtSGCitaDisponibilidadProfesionalId_Jsonclick ;
   private String edtSGCitaDisponibilidadProFullName_Internalname ;
   private String edtSGCitaDisponibilidadProFullName_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadId_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadId_Internalname ;
   private String edtSGCitaDisponibilidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteId_Jsonclick ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNombres_Link ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaId_Internalname ;
   private String edtSGCitaDisponibilidadClinicaId_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaNombre_Internalname ;
   private String edtSGCitaDisponibilidadClinicaNombre_Jsonclick ;
   private String A148EncuestaAtencion ;
   private String A149EncuestaAtendido ;
   private String edtEncuestaHoraAtencion_Internalname ;
   private String edtEncuestaHoraAtencion_Jsonclick ;
   private String edtEncuestaComentarios_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtEncuestaRecomendacion_Internalname ;
   private String edtEncuestaRecomendacion_Jsonclick ;
   private String A153EncuestaEstado ;
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
   private String sCtrlA37EncuestaId ;
   private java.util.Date A150EncuestaHoraAtencion ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n148EncuestaAtencion ;
   private boolean n149EncuestaAtendido ;
   private boolean n153EncuestaEstado ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n151EncuestaComentarios ;
   private boolean n150EncuestaHoraAtencion ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n84ProfesionalNombres ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A151EncuestaComentarios ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A64CitaCode ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private HTMLChoice cmbEncuestaAtencion ;
   private HTMLChoice cmbEncuestaAtendido ;
   private HTMLChoice cmbEncuestaEstado ;
   private IDataStoreProvider pr_default ;
   private short[] H003Y2_A72SGCitaDisponibilidadSedeId ;
   private short[] H003Y2_A37EncuestaId ;
   private int[] H003Y2_A19CitaId ;
   private String[] H003Y2_A153EncuestaEstado ;
   private boolean[] H003Y2_n153EncuestaEstado ;
   private byte[] H003Y2_A152EncuestaRecomendacion ;
   private String[] H003Y2_A151EncuestaComentarios ;
   private boolean[] H003Y2_n151EncuestaComentarios ;
   private java.util.Date[] H003Y2_A150EncuestaHoraAtencion ;
   private boolean[] H003Y2_n150EncuestaHoraAtencion ;
   private String[] H003Y2_A149EncuestaAtendido ;
   private boolean[] H003Y2_n149EncuestaAtendido ;
   private String[] H003Y2_A148EncuestaAtencion ;
   private boolean[] H003Y2_n148EncuestaAtencion ;
   private String[] H003Y2_A78SGCitaDisponibilidadClinicaNombre ;
   private short[] H003Y2_A76SGCitaDisponibilidadClinicaId ;
   private String[] H003Y2_A105PacienteNombres ;
   private String[] H003Y2_A104PacienteApellidoMaterno ;
   private String[] H003Y2_A103PacienteApellidoPaterno ;
   private int[] H003Y2_A20PacienteId ;
   private java.util.Date[] H003Y2_A66SGCitaDisponibilidadFecha ;
   private boolean[] H003Y2_n66SGCitaDisponibilidadFecha ;
   private int[] H003Y2_A21SGCitaDisponibilidadId ;
   private String[] H003Y2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] H003Y2_A70SGCitaDisponibilidadEspecialidadId ;
   private int[] H003Y2_A81SGCitaDisponibilidadProfesionalId ;
   private String[] H003Y2_A64CitaCode ;
   private String[] H003Y2_A86ProfesionalApellidoMaterno ;
   private boolean[] H003Y2_n86ProfesionalApellidoMaterno ;
   private String[] H003Y2_A85ProfesionalApellidoPaterno ;
   private boolean[] H003Y2_n85ProfesionalApellidoPaterno ;
   private String[] H003Y2_A84ProfesionalNombres ;
   private boolean[] H003Y2_n84ProfesionalNombres ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class encuestageneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003Y2", "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T1.[EncuestaId], T1.[CitaId], T1.[EncuestaEstado], T1.[EncuestaRecomendacion], T1.[EncuestaComentarios], T1.[EncuestaHoraAtencion], T1.[EncuestaAtendido], T1.[EncuestaAtencion], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T3.[PacienteNombres], T3.[PacienteApellidoMaterno], T3.[PacienteApellidoPaterno], T2.[PacienteId], T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T7.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T2.[CitaCode], T8.[ProfesionalApellidoMaterno], T8.[ProfesionalApellidoPaterno], T8.[ProfesionalNombres] FROM ((((((([Encuesta] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) INNER JOIN [Especialidad] T7 ON T7.[EspecialidadId] = T4.[EspecialidadId]) INNER JOIN [Profesional] T8 ON T8.[ProfesionalId] = T4.[ProfesionalId]) WHERE T1.[EncuestaId] = ? ORDER BY T1.[EncuestaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = GXutil.resetDate(rslt.getGXDateTime(7));
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 1);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(10);
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((String[]) buf[16])[0] = rslt.getVarchar(12);
               ((String[]) buf[17])[0] = rslt.getVarchar(13);
               ((String[]) buf[18])[0] = rslt.getVarchar(14);
               ((int[]) buf[19])[0] = rslt.getInt(15);
               ((java.util.Date[]) buf[20])[0] = rslt.getGXDate(16);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((int[]) buf[22])[0] = rslt.getInt(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((short[]) buf[24])[0] = rslt.getShort(19);
               ((int[]) buf[25])[0] = rslt.getInt(20);
               ((String[]) buf[26])[0] = rslt.getVarchar(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getVarchar(23);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[32])[0] = rslt.wasNull();
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

