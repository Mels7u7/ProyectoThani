package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pagogeneral_impl extends GXWebComponent
{
   public pagogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pagogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pagogeneral_impl.class ));
   }

   public pagogeneral_impl( int remoteHandle ,
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
      cmbPagoTipoDocumentoCliente = new HTMLChoice();
      cmbPagoTipoDocumento = new HTMLChoice();
      cmbPagoMoneda = new HTMLChoice();
      cmbPagoEstadoR = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "PagoId") ;
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
               A47PagoId = (int)(GXutil.lval( httpContext.GetPar( "PagoId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A47PagoId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "PagoId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "PagoId") ;
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
         pa422( ) ;
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
         httpContext.writeValue( "Pago General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325493", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.pagogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A47PagoId,8,0))}, new String[] {"PagoId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"PagoGeneral");
      forbiddenHiddens.add("PagoEnlacePDF", GXutil.rtrim( localUtil.format( A338PagoEnlacePDF, "")));
      forbiddenHiddens.add("PagoEnlaceXML", GXutil.rtrim( localUtil.format( A339PagoEnlaceXML, "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("pagogeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA47PagoId", GXutil.ltrim( localUtil.ntoc( wcpOA47PagoId, (byte)(8), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm422( )
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
      return "PagoGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Pago General" ;
   }

   public void wb420( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.pagogeneral");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoId_Internalname, GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPagoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_PagoGeneral.htm");
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
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaCode_Internalname, "Cita Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaCode_Internalname, A64CitaCode, GXutil.rtrim( localUtil.format( A64CitaCode, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtCitaCode_Link, "", "", "", edtCitaCode_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaCode_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoGeneral.htm");
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
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadFecha_Internalname, "SGCita Disponibilidad Fecha", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadFecha_Internalname, localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"), localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadFecha_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSGCitaDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_PagoGeneral.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoMonto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoMonto_Internalname, "Monto", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoMonto_Internalname, GXutil.ltrim( localUtil.ntoc( A242PagoMonto, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtPagoMonto_Enabled!=0) ? localUtil.format( A242PagoMonto, "ZZ9.99") : localUtil.format( A242PagoMonto, "ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoMonto_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoMonto_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoToken_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoToken_Internalname, "Token", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoToken_Internalname, A243PagoToken, GXutil.rtrim( localUtil.format( A243PagoToken, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoToken_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoToken_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPagoTipoDocumentoCliente.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoTipoDocumentoCliente.getInternalname(), "Documento Cliente", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoTipoDocumentoCliente, cmbPagoTipoDocumentoCliente.getInternalname(), GXutil.rtrim( A247PagoTipoDocumentoCliente), 1, cmbPagoTipoDocumentoCliente.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPagoTipoDocumentoCliente.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PagoGeneral.htm");
         cmbPagoTipoDocumentoCliente.setValue( GXutil.rtrim( A247PagoTipoDocumentoCliente) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoTipoDocumentoCliente.getInternalname(), "Values", cmbPagoTipoDocumentoCliente.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoClienteNroDocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteNroDocumento_Internalname, "Nro Documento", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteNroDocumento_Internalname, A248PagoClienteNroDocumento, GXutil.rtrim( localUtil.format( A248PagoClienteNroDocumento, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoClienteNroDocumento_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoClienteNroDocumento_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoClienteDenominacion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteDenominacion_Internalname, "Cliente Denominacion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteDenominacion_Internalname, A249PagoClienteDenominacion, GXutil.rtrim( localUtil.format( A249PagoClienteDenominacion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoClienteDenominacion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoClienteDenominacion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoClienteDireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteDireccion_Internalname, "Cliente Direccion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteDireccion_Internalname, A250PagoClienteDireccion, GXutil.rtrim( localUtil.format( A250PagoClienteDireccion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoClienteDireccion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoClienteDireccion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoClienteEmail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteEmail_Internalname, "Cliente Email", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteEmail_Internalname, A251PagoClienteEmail, GXutil.rtrim( localUtil.format( A251PagoClienteEmail, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "mailto:"+A251PagoClienteEmail, "", "", "", edtPagoClienteEmail_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoClienteEmail_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPagoTipoDocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoTipoDocumento.getInternalname(), "Tipo Documento", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoTipoDocumento, cmbPagoTipoDocumento.getInternalname(), GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)), 1, cmbPagoTipoDocumento.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPagoTipoDocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PagoGeneral.htm");
         cmbPagoTipoDocumento.setValue( GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoTipoDocumento.getInternalname(), "Values", cmbPagoTipoDocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoNumero_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoNumero_Internalname, "Numero", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A245PagoNumero, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPagoNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A245PagoNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A245PagoNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoNumero_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoFechaEmision_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoFechaEmision_Internalname, "Fecha Emision", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtPagoFechaEmision_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoFechaEmision_Internalname, localUtil.format(A252PagoFechaEmision, "99/99/9999"), localUtil.format( A252PagoFechaEmision, "99/99/9999"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoFechaEmision_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoFechaEmision_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtPagoFechaEmision_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtPagoFechaEmision_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_PagoGeneral.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPagoMoneda.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoMoneda.getInternalname(), "Moneda", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoMoneda, cmbPagoMoneda.getInternalname(), GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)), 1, cmbPagoMoneda.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPagoMoneda.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PagoGeneral.htm");
         cmbPagoMoneda.setValue( GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoMoneda.getInternalname(), "Values", cmbPagoMoneda.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoNubefactRequest_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoNubefactRequest_Internalname, "Nubefact Request", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoNubefactRequest_Internalname, A256PagoNubefactRequest, "", "", (short)(0), 1, edtPagoNubefactRequest_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoNubefactResponse_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoNubefactResponse_Internalname, "Nubefact Response", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoNubefactResponse_Internalname, A257PagoNubefactResponse, "", "", (short)(0), 1, edtPagoNubefactResponse_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoRequest_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoRequest_Internalname, "Request", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoRequest_Internalname, A308PagoRequest, "", "", (short)(0), 1, edtPagoRequest_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoResponse_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoResponse_Internalname, "Response", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoResponse_Internalname, A309PagoResponse, "", "", (short)(0), 1, edtPagoResponse_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoPasarelaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoPasarelaId_Internalname, "Pasarela Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoPasarelaId_Internalname, A310PagoPasarelaId, GXutil.rtrim( localUtil.format( A310PagoPasarelaId, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoPasarelaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoPasarelaId_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoStatusCode_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoStatusCode_Internalname, "Status Code", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoStatusCode_Internalname, GXutil.ltrim( localUtil.ntoc( A311PagoStatusCode, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPagoStatusCode_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A311PagoStatusCode), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A311PagoStatusCode), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoStatusCode_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoStatusCode_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadId_Internalname, "Disponibilidad Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtDisponibilidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDisponibilidadId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoEnlacePDF_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoEnlacePDF_Internalname, "Enlace PDF", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoEnlacePDF_Internalname, A338PagoEnlacePDF, GXutil.rtrim( localUtil.format( A338PagoEnlacePDF, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtPagoEnlacePDF_Link, edtPagoEnlacePDF_Linktarget, "", "", edtPagoEnlacePDF_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoEnlacePDF_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoEnlaceXML_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoEnlaceXML_Internalname, "Enlace XML", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoEnlaceXML_Internalname, A339PagoEnlaceXML, GXutil.rtrim( localUtil.format( A339PagoEnlaceXML, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtPagoEnlaceXML_Link, edtPagoEnlaceXML_Linktarget, "", "", edtPagoEnlaceXML_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPagoEnlaceXML_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPagoEstadoR.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoEstadoR.getInternalname(), "Estado R", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoEstadoR, cmbPagoEstadoR.getInternalname(), GXutil.rtrim( A246PagoEstadoR), 1, cmbPagoEstadoR.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPagoEstadoR.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PagoGeneral.htm");
         cmbPagoEstadoR.setValue( GXutil.rtrim( A246PagoEstadoR) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoEstadoR.getInternalname(), "Values", cmbPagoEstadoR.ToJavascriptSource(), true);
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11421_client"+"'", TempTags, "", 2, "HLP_PagoGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 136,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12421_client"+"'", TempTags, "", 2, "HLP_PagoGeneral.htm");
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

   public void start422( )
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
            Form.getMeta().addItem("description", "Pago General", (short)(0)) ;
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
            strup420( ) ;
         }
      }
   }

   public void ws422( )
   {
      start422( ) ;
      evt422( ) ;
   }

   public void evt422( )
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
                              strup420( ) ;
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
                              strup420( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13422 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup420( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14422 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup420( ) ;
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
                              strup420( ) ;
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

   public void we422( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm422( ) ;
         }
      }
   }

   public void pa422( )
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
      if ( cmbPagoTipoDocumentoCliente.getItemCount() > 0 )
      {
         A247PagoTipoDocumentoCliente = cmbPagoTipoDocumentoCliente.getValidValue(A247PagoTipoDocumentoCliente) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoTipoDocumentoCliente.setValue( GXutil.rtrim( A247PagoTipoDocumentoCliente) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoTipoDocumentoCliente.getInternalname(), "Values", cmbPagoTipoDocumentoCliente.ToJavascriptSource(), true);
      }
      if ( cmbPagoTipoDocumento.getItemCount() > 0 )
      {
         A244PagoTipoDocumento = (short)(GXutil.lval( cmbPagoTipoDocumento.getValidValue(GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoTipoDocumento.setValue( GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoTipoDocumento.getInternalname(), "Values", cmbPagoTipoDocumento.ToJavascriptSource(), true);
      }
      if ( cmbPagoMoneda.getItemCount() > 0 )
      {
         A253PagoMoneda = (short)(GXutil.lval( cmbPagoMoneda.getValidValue(GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoMoneda.setValue( GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoMoneda.getInternalname(), "Values", cmbPagoMoneda.ToJavascriptSource(), true);
      }
      if ( cmbPagoEstadoR.getItemCount() > 0 )
      {
         A246PagoEstadoR = cmbPagoEstadoR.getValidValue(A246PagoEstadoR) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A246PagoEstadoR", A246PagoEstadoR);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoEstadoR.setValue( GXutil.rtrim( A246PagoEstadoR) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPagoEstadoR.getInternalname(), "Values", cmbPagoEstadoR.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf422( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV15Pgmname = "PagoGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf422( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00422 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A47PagoId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A21SGCitaDisponibilidadId = H00422_A21SGCitaDisponibilidadId[0] ;
            A19CitaId = H00422_A19CitaId[0] ;
            n19CitaId = H00422_n19CitaId[0] ;
            A246PagoEstadoR = H00422_A246PagoEstadoR[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A246PagoEstadoR", A246PagoEstadoR);
            A339PagoEnlaceXML = H00422_A339PagoEnlaceXML[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A339PagoEnlaceXML", A339PagoEnlaceXML);
            A338PagoEnlacePDF = H00422_A338PagoEnlacePDF[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A338PagoEnlacePDF", A338PagoEnlacePDF);
            A34DisponibilidadId = H00422_A34DisponibilidadId[0] ;
            n34DisponibilidadId = H00422_n34DisponibilidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            A311PagoStatusCode = H00422_A311PagoStatusCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A311PagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311PagoStatusCode), 8, 0));
            A310PagoPasarelaId = H00422_A310PagoPasarelaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A310PagoPasarelaId", A310PagoPasarelaId);
            A309PagoResponse = H00422_A309PagoResponse[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A309PagoResponse", A309PagoResponse);
            A308PagoRequest = H00422_A308PagoRequest[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A308PagoRequest", A308PagoRequest);
            A257PagoNubefactResponse = H00422_A257PagoNubefactResponse[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A257PagoNubefactResponse", A257PagoNubefactResponse);
            A256PagoNubefactRequest = H00422_A256PagoNubefactRequest[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A256PagoNubefactRequest", A256PagoNubefactRequest);
            A253PagoMoneda = H00422_A253PagoMoneda[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
            A252PagoFechaEmision = H00422_A252PagoFechaEmision[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A252PagoFechaEmision", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
            A245PagoNumero = H00422_A245PagoNumero[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A245PagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A245PagoNumero), 8, 0));
            A244PagoTipoDocumento = H00422_A244PagoTipoDocumento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
            A251PagoClienteEmail = H00422_A251PagoClienteEmail[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A251PagoClienteEmail", A251PagoClienteEmail);
            A250PagoClienteDireccion = H00422_A250PagoClienteDireccion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A250PagoClienteDireccion", A250PagoClienteDireccion);
            A249PagoClienteDenominacion = H00422_A249PagoClienteDenominacion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A249PagoClienteDenominacion", A249PagoClienteDenominacion);
            A248PagoClienteNroDocumento = H00422_A248PagoClienteNroDocumento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A248PagoClienteNroDocumento", A248PagoClienteNroDocumento);
            A247PagoTipoDocumentoCliente = H00422_A247PagoTipoDocumentoCliente[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
            A243PagoToken = H00422_A243PagoToken[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243PagoToken", A243PagoToken);
            A242PagoMonto = H00422_A242PagoMonto[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A242PagoMonto", GXutil.ltrimstr( A242PagoMonto, 6, 2));
            A66SGCitaDisponibilidadFecha = H00422_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H00422_n66SGCitaDisponibilidadFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            A64CitaCode = H00422_A64CitaCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
            A21SGCitaDisponibilidadId = H00422_A21SGCitaDisponibilidadId[0] ;
            A64CitaCode = H00422_A64CitaCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
            A66SGCitaDisponibilidadFecha = H00422_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H00422_n66SGCitaDisponibilidadFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            /* Execute user event: Load */
            e14422 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb420( ) ;
      }
   }

   public void send_integrity_lvl_hashes422( )
   {
   }

   public void before_start_formulas( )
   {
      AV15Pgmname = "PagoGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup420( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13422 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA47PagoId"), ",", ".")) ;
         /* Read variables values. */
         A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
         A66SGCitaDisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 3) ;
         n66SGCitaDisponibilidadFecha = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A242PagoMonto = localUtil.ctond( httpContext.cgiGet( edtPagoMonto_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A242PagoMonto", GXutil.ltrimstr( A242PagoMonto, 6, 2));
         A243PagoToken = httpContext.cgiGet( edtPagoToken_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A243PagoToken", A243PagoToken);
         cmbPagoTipoDocumentoCliente.setValue( httpContext.cgiGet( cmbPagoTipoDocumentoCliente.getInternalname()) );
         A247PagoTipoDocumentoCliente = httpContext.cgiGet( cmbPagoTipoDocumentoCliente.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
         A248PagoClienteNroDocumento = httpContext.cgiGet( edtPagoClienteNroDocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A248PagoClienteNroDocumento", A248PagoClienteNroDocumento);
         A249PagoClienteDenominacion = httpContext.cgiGet( edtPagoClienteDenominacion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A249PagoClienteDenominacion", A249PagoClienteDenominacion);
         A250PagoClienteDireccion = httpContext.cgiGet( edtPagoClienteDireccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A250PagoClienteDireccion", A250PagoClienteDireccion);
         A251PagoClienteEmail = httpContext.cgiGet( edtPagoClienteEmail_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A251PagoClienteEmail", A251PagoClienteEmail);
         cmbPagoTipoDocumento.setValue( httpContext.cgiGet( cmbPagoTipoDocumento.getInternalname()) );
         A244PagoTipoDocumento = (short)(GXutil.lval( httpContext.cgiGet( cmbPagoTipoDocumento.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
         A245PagoNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoNumero_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A245PagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A245PagoNumero), 8, 0));
         A252PagoFechaEmision = localUtil.ctod( httpContext.cgiGet( edtPagoFechaEmision_Internalname), 3) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A252PagoFechaEmision", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
         cmbPagoMoneda.setValue( httpContext.cgiGet( cmbPagoMoneda.getInternalname()) );
         A253PagoMoneda = (short)(GXutil.lval( httpContext.cgiGet( cmbPagoMoneda.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
         A256PagoNubefactRequest = httpContext.cgiGet( edtPagoNubefactRequest_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A256PagoNubefactRequest", A256PagoNubefactRequest);
         A257PagoNubefactResponse = httpContext.cgiGet( edtPagoNubefactResponse_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A257PagoNubefactResponse", A257PagoNubefactResponse);
         A308PagoRequest = httpContext.cgiGet( edtPagoRequest_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A308PagoRequest", A308PagoRequest);
         A309PagoResponse = httpContext.cgiGet( edtPagoResponse_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A309PagoResponse", A309PagoResponse);
         A310PagoPasarelaId = httpContext.cgiGet( edtPagoPasarelaId_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A310PagoPasarelaId", A310PagoPasarelaId);
         A311PagoStatusCode = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoStatusCode_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A311PagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311PagoStatusCode), 8, 0));
         A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".")) ;
         n34DisponibilidadId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         A338PagoEnlacePDF = httpContext.cgiGet( edtPagoEnlacePDF_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A338PagoEnlacePDF", A338PagoEnlacePDF);
         A339PagoEnlaceXML = httpContext.cgiGet( edtPagoEnlaceXML_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A339PagoEnlaceXML", A339PagoEnlaceXML);
         cmbPagoEstadoR.setValue( httpContext.cgiGet( cmbPagoEstadoR.getInternalname()) );
         A246PagoEstadoR = httpContext.cgiGet( cmbPagoEstadoR.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A246PagoEstadoR", A246PagoEstadoR);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"PagoGeneral");
         A338PagoEnlacePDF = httpContext.cgiGet( edtPagoEnlacePDF_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A338PagoEnlacePDF", A338PagoEnlacePDF);
         forbiddenHiddens.add("PagoEnlacePDF", GXutil.rtrim( localUtil.format( A338PagoEnlacePDF, "")));
         A339PagoEnlaceXML = httpContext.cgiGet( edtPagoEnlaceXML_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A339PagoEnlaceXML", A339PagoEnlaceXML);
         forbiddenHiddens.add("PagoEnlaceXML", GXutil.rtrim( localUtil.format( A339PagoEnlaceXML, "")));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("pagogeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e13422 ();
      if (returnInSub) return;
   }

   public void e13422( )
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

   protected void e14422( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita", GXv_boolean3) ;
      pagogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( AV12TempBoolean )
      {
         edtCitaCode_Link = formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CitaId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaCode_Internalname, "Link", edtCitaCode_Link, true);
      }
      edtPagoEnlacePDF_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPagoEnlacePDF_Internalname, "Linktarget", edtPagoEnlacePDF_Linktarget, true);
      edtPagoEnlacePDF_Link = A338PagoEnlacePDF ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPagoEnlacePDF_Internalname, "Link", edtPagoEnlacePDF_Link, true);
      edtPagoEnlaceXML_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPagoEnlaceXML_Internalname, "Linktarget", edtPagoEnlaceXML_Linktarget, true);
      edtPagoEnlaceXML_Link = A339PagoEnlaceXML ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPagoEnlaceXML_Internalname, "Link", edtPagoEnlaceXML_Link, true);
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Update", GXv_boolean3) ;
      pagogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Delete", GXv_boolean3) ;
      pagogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV15Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Pago" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A47PagoId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
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
      pa422( ) ;
      ws422( ) ;
      we422( ) ;
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
      sCtrlA47PagoId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa422( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "pagogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa422( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A47PagoId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
      }
      wcpOA47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA47PagoId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A47PagoId != wcpOA47PagoId ) ) )
      {
         setjustcreated();
      }
      wcpOA47PagoId = A47PagoId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA47PagoId = httpContext.cgiGet( sPrefix+"A47PagoId_CTRL") ;
      if ( GXutil.len( sCtrlA47PagoId) > 0 )
      {
         A47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA47PagoId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
      }
      else
      {
         A47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A47PagoId_PARM"), ",", ".")) ;
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
      pa422( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws422( ) ;
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
      ws422( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A47PagoId_PARM", GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA47PagoId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A47PagoId_CTRL", GXutil.rtrim( sCtrlA47PagoId));
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
      we422( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325585", true, true);
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
      httpContext.AddJavascriptSource("pagogeneral.js", "?20225110325586", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPagoId_Internalname = sPrefix+"PAGOID" ;
      edtCitaCode_Internalname = sPrefix+"CITACODE" ;
      edtSGCitaDisponibilidadFecha_Internalname = sPrefix+"SGCITADISPONIBILIDADFECHA" ;
      edtPagoMonto_Internalname = sPrefix+"PAGOMONTO" ;
      edtPagoToken_Internalname = sPrefix+"PAGOTOKEN" ;
      cmbPagoTipoDocumentoCliente.setInternalname( sPrefix+"PAGOTIPODOCUMENTOCLIENTE" );
      edtPagoClienteNroDocumento_Internalname = sPrefix+"PAGOCLIENTENRODOCUMENTO" ;
      edtPagoClienteDenominacion_Internalname = sPrefix+"PAGOCLIENTEDENOMINACION" ;
      edtPagoClienteDireccion_Internalname = sPrefix+"PAGOCLIENTEDIRECCION" ;
      edtPagoClienteEmail_Internalname = sPrefix+"PAGOCLIENTEEMAIL" ;
      cmbPagoTipoDocumento.setInternalname( sPrefix+"PAGOTIPODOCUMENTO" );
      edtPagoNumero_Internalname = sPrefix+"PAGONUMERO" ;
      edtPagoFechaEmision_Internalname = sPrefix+"PAGOFECHAEMISION" ;
      cmbPagoMoneda.setInternalname( sPrefix+"PAGOMONEDA" );
      edtPagoNubefactRequest_Internalname = sPrefix+"PAGONUBEFACTREQUEST" ;
      edtPagoNubefactResponse_Internalname = sPrefix+"PAGONUBEFACTRESPONSE" ;
      edtPagoRequest_Internalname = sPrefix+"PAGOREQUEST" ;
      edtPagoResponse_Internalname = sPrefix+"PAGORESPONSE" ;
      edtPagoPasarelaId_Internalname = sPrefix+"PAGOPASARELAID" ;
      edtPagoStatusCode_Internalname = sPrefix+"PAGOSTATUSCODE" ;
      edtDisponibilidadId_Internalname = sPrefix+"DISPONIBILIDADID" ;
      edtPagoEnlacePDF_Internalname = sPrefix+"PAGOENLACEPDF" ;
      edtPagoEnlaceXML_Internalname = sPrefix+"PAGOENLACEXML" ;
      cmbPagoEstadoR.setInternalname( sPrefix+"PAGOESTADOR" );
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
      cmbPagoEstadoR.setJsonclick( "" );
      cmbPagoEstadoR.setEnabled( 0 );
      edtPagoEnlaceXML_Jsonclick = "" ;
      edtPagoEnlaceXML_Linktarget = "" ;
      edtPagoEnlaceXML_Link = "" ;
      edtPagoEnlaceXML_Enabled = 0 ;
      edtPagoEnlacePDF_Jsonclick = "" ;
      edtPagoEnlacePDF_Linktarget = "" ;
      edtPagoEnlacePDF_Link = "" ;
      edtPagoEnlacePDF_Enabled = 0 ;
      edtDisponibilidadId_Jsonclick = "" ;
      edtDisponibilidadId_Enabled = 0 ;
      edtPagoStatusCode_Jsonclick = "" ;
      edtPagoStatusCode_Enabled = 0 ;
      edtPagoPasarelaId_Jsonclick = "" ;
      edtPagoPasarelaId_Enabled = 0 ;
      edtPagoResponse_Enabled = 0 ;
      edtPagoRequest_Enabled = 0 ;
      edtPagoNubefactResponse_Enabled = 0 ;
      edtPagoNubefactRequest_Enabled = 0 ;
      cmbPagoMoneda.setJsonclick( "" );
      cmbPagoMoneda.setEnabled( 0 );
      edtPagoFechaEmision_Jsonclick = "" ;
      edtPagoFechaEmision_Enabled = 0 ;
      edtPagoNumero_Jsonclick = "" ;
      edtPagoNumero_Enabled = 0 ;
      cmbPagoTipoDocumento.setJsonclick( "" );
      cmbPagoTipoDocumento.setEnabled( 0 );
      edtPagoClienteEmail_Jsonclick = "" ;
      edtPagoClienteEmail_Enabled = 0 ;
      edtPagoClienteDireccion_Jsonclick = "" ;
      edtPagoClienteDireccion_Enabled = 0 ;
      edtPagoClienteDenominacion_Jsonclick = "" ;
      edtPagoClienteDenominacion_Enabled = 0 ;
      edtPagoClienteNroDocumento_Jsonclick = "" ;
      edtPagoClienteNroDocumento_Enabled = 0 ;
      cmbPagoTipoDocumentoCliente.setJsonclick( "" );
      cmbPagoTipoDocumentoCliente.setEnabled( 0 );
      edtPagoToken_Jsonclick = "" ;
      edtPagoToken_Enabled = 0 ;
      edtPagoMonto_Jsonclick = "" ;
      edtPagoMonto_Enabled = 0 ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaCode_Link = "" ;
      edtCitaCode_Enabled = 0 ;
      edtPagoId_Jsonclick = "" ;
      edtPagoId_Enabled = 0 ;
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
      cmbPagoTipoDocumentoCliente.setName( "PAGOTIPODOCUMENTOCLIENTE" );
      cmbPagoTipoDocumentoCliente.setWebtags( "" );
      cmbPagoTipoDocumentoCliente.addItem("6", "RUC", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("1", "DNI", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("4", "CARNET DE EXT.", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("7", "PASAPORTE", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("A", "CDI", (short)(0));
      cmbPagoTipoDocumentoCliente.addItem("0", "NO DOMICILIADO", (short)(0));
      if ( cmbPagoTipoDocumentoCliente.getItemCount() > 0 )
      {
      }
      cmbPagoTipoDocumento.setName( "PAGOTIPODOCUMENTO" );
      cmbPagoTipoDocumento.setWebtags( "" );
      cmbPagoTipoDocumento.addItem("1", "Factura", (short)(0));
      cmbPagoTipoDocumento.addItem("2", "Boleta", (short)(0));
      cmbPagoTipoDocumento.addItem("3", "Nota Credito", (short)(0));
      cmbPagoTipoDocumento.addItem("4", "Nota Debito", (short)(0));
      if ( cmbPagoTipoDocumento.getItemCount() > 0 )
      {
      }
      cmbPagoMoneda.setName( "PAGOMONEDA" );
      cmbPagoMoneda.setWebtags( "" );
      cmbPagoMoneda.addItem("1", "Soles", (short)(0));
      cmbPagoMoneda.addItem("2", "Dólares", (short)(0));
      cmbPagoMoneda.addItem("3", "Euros", (short)(0));
      if ( cmbPagoMoneda.getItemCount() > 0 )
      {
      }
      cmbPagoEstadoR.setName( "PAGOESTADOR" );
      cmbPagoEstadoR.setWebtags( "" );
      cmbPagoEstadoR.addItem("A", "Activo", (short)(0));
      cmbPagoEstadoR.addItem("I", "Inactivo", (short)(0));
      if ( cmbPagoEstadoR.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A47PagoId',fld:'PAGOID',pic:'ZZZZZZZ9'},{av:'A338PagoEnlacePDF',fld:'PAGOENLACEPDF',pic:''},{av:'A339PagoEnlaceXML',fld:'PAGOENLACEXML',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11421',iparms:[{av:'A47PagoId',fld:'PAGOID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12421',iparms:[{av:'A47PagoId',fld:'PAGOID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_PAGOID","{handler:'valid_Pagoid',iparms:[]");
      setEventMetadata("VALID_PAGOID",",oparms:[]}");
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
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      GX_FocusControl = "" ;
      A64CitaCode = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A243PagoToken = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A248PagoClienteNroDocumento = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      ClassString = "" ;
      StyleString = "" ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A310PagoPasarelaId = "" ;
      A246PagoEstadoR = "" ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      H00422_A21SGCitaDisponibilidadId = new int[1] ;
      H00422_A47PagoId = new int[1] ;
      H00422_A19CitaId = new int[1] ;
      H00422_n19CitaId = new boolean[] {false} ;
      H00422_A246PagoEstadoR = new String[] {""} ;
      H00422_A339PagoEnlaceXML = new String[] {""} ;
      H00422_A338PagoEnlacePDF = new String[] {""} ;
      H00422_A34DisponibilidadId = new int[1] ;
      H00422_n34DisponibilidadId = new boolean[] {false} ;
      H00422_A311PagoStatusCode = new int[1] ;
      H00422_A310PagoPasarelaId = new String[] {""} ;
      H00422_A309PagoResponse = new String[] {""} ;
      H00422_A308PagoRequest = new String[] {""} ;
      H00422_A257PagoNubefactResponse = new String[] {""} ;
      H00422_A256PagoNubefactRequest = new String[] {""} ;
      H00422_A253PagoMoneda = new short[1] ;
      H00422_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      H00422_A245PagoNumero = new int[1] ;
      H00422_A244PagoTipoDocumento = new short[1] ;
      H00422_A251PagoClienteEmail = new String[] {""} ;
      H00422_A250PagoClienteDireccion = new String[] {""} ;
      H00422_A249PagoClienteDenominacion = new String[] {""} ;
      H00422_A248PagoClienteNroDocumento = new String[] {""} ;
      H00422_A247PagoTipoDocumentoCliente = new String[] {""} ;
      H00422_A243PagoToken = new String[] {""} ;
      H00422_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00422_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H00422_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H00422_A64CitaCode = new String[] {""} ;
      hsh = "" ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA47PagoId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pagogeneral__default(),
         new Object[] {
             new Object[] {
            H00422_A21SGCitaDisponibilidadId, H00422_A47PagoId, H00422_A19CitaId, H00422_n19CitaId, H00422_A246PagoEstadoR, H00422_A339PagoEnlaceXML, H00422_A338PagoEnlacePDF, H00422_A34DisponibilidadId, H00422_n34DisponibilidadId, H00422_A311PagoStatusCode,
            H00422_A310PagoPasarelaId, H00422_A309PagoResponse, H00422_A308PagoRequest, H00422_A257PagoNubefactResponse, H00422_A256PagoNubefactRequest, H00422_A253PagoMoneda, H00422_A252PagoFechaEmision, H00422_A245PagoNumero, H00422_A244PagoTipoDocumento, H00422_A251PagoClienteEmail,
            H00422_A250PagoClienteDireccion, H00422_A249PagoClienteDenominacion, H00422_A248PagoClienteNroDocumento, H00422_A247PagoTipoDocumentoCliente, H00422_A243PagoToken, H00422_A242PagoMonto, H00422_A66SGCitaDisponibilidadFecha, H00422_n66SGCitaDisponibilidadFecha, H00422_A64CitaCode
            }
         }
      );
      AV15Pgmname = "PagoGeneral" ;
      /* GeneXus formulas. */
      AV15Pgmname = "PagoGeneral" ;
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
   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA47PagoId ;
   private int A47PagoId ;
   private int edtPagoId_Enabled ;
   private int edtCitaCode_Enabled ;
   private int edtSGCitaDisponibilidadFecha_Enabled ;
   private int edtPagoMonto_Enabled ;
   private int edtPagoToken_Enabled ;
   private int edtPagoClienteNroDocumento_Enabled ;
   private int edtPagoClienteDenominacion_Enabled ;
   private int edtPagoClienteDireccion_Enabled ;
   private int edtPagoClienteEmail_Enabled ;
   private int A245PagoNumero ;
   private int edtPagoNumero_Enabled ;
   private int edtPagoFechaEmision_Enabled ;
   private int edtPagoNubefactRequest_Enabled ;
   private int edtPagoNubefactResponse_Enabled ;
   private int edtPagoRequest_Enabled ;
   private int edtPagoResponse_Enabled ;
   private int edtPagoPasarelaId_Enabled ;
   private int A311PagoStatusCode ;
   private int edtPagoStatusCode_Enabled ;
   private int A34DisponibilidadId ;
   private int edtDisponibilidadId_Enabled ;
   private int edtPagoEnlacePDF_Enabled ;
   private int edtPagoEnlaceXML_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int A21SGCitaDisponibilidadId ;
   private int A19CitaId ;
   private int idxLst ;
   private java.math.BigDecimal A242PagoMonto ;
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
   private String edtPagoId_Internalname ;
   private String edtPagoId_Jsonclick ;
   private String edtCitaCode_Internalname ;
   private String edtCitaCode_Link ;
   private String edtCitaCode_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtPagoMonto_Internalname ;
   private String edtPagoMonto_Jsonclick ;
   private String edtPagoToken_Internalname ;
   private String edtPagoToken_Jsonclick ;
   private String A247PagoTipoDocumentoCliente ;
   private String edtPagoClienteNroDocumento_Internalname ;
   private String edtPagoClienteNroDocumento_Jsonclick ;
   private String edtPagoClienteDenominacion_Internalname ;
   private String edtPagoClienteDenominacion_Jsonclick ;
   private String edtPagoClienteDireccion_Internalname ;
   private String edtPagoClienteDireccion_Jsonclick ;
   private String edtPagoClienteEmail_Internalname ;
   private String edtPagoClienteEmail_Jsonclick ;
   private String edtPagoNumero_Internalname ;
   private String edtPagoNumero_Jsonclick ;
   private String edtPagoFechaEmision_Internalname ;
   private String edtPagoFechaEmision_Jsonclick ;
   private String edtPagoNubefactRequest_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtPagoNubefactResponse_Internalname ;
   private String edtPagoRequest_Internalname ;
   private String edtPagoResponse_Internalname ;
   private String edtPagoPasarelaId_Internalname ;
   private String edtPagoPasarelaId_Jsonclick ;
   private String edtPagoStatusCode_Internalname ;
   private String edtPagoStatusCode_Jsonclick ;
   private String edtDisponibilidadId_Internalname ;
   private String edtDisponibilidadId_Jsonclick ;
   private String edtPagoEnlacePDF_Internalname ;
   private String edtPagoEnlacePDF_Link ;
   private String edtPagoEnlacePDF_Linktarget ;
   private String edtPagoEnlacePDF_Jsonclick ;
   private String edtPagoEnlaceXML_Internalname ;
   private String edtPagoEnlaceXML_Link ;
   private String edtPagoEnlaceXML_Linktarget ;
   private String edtPagoEnlaceXML_Jsonclick ;
   private String A246PagoEstadoR ;
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
   private String AV15Pgmname ;
   private String scmdbuf ;
   private String hsh ;
   private String sCtrlA47PagoId ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date A252PagoFechaEmision ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n19CitaId ;
   private boolean n34DisponibilidadId ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private String A64CitaCode ;
   private String A243PagoToken ;
   private String A248PagoClienteNroDocumento ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A310PagoPasarelaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPagoTipoDocumentoCliente ;
   private HTMLChoice cmbPagoTipoDocumento ;
   private HTMLChoice cmbPagoMoneda ;
   private HTMLChoice cmbPagoEstadoR ;
   private IDataStoreProvider pr_default ;
   private int[] H00422_A21SGCitaDisponibilidadId ;
   private int[] H00422_A47PagoId ;
   private int[] H00422_A19CitaId ;
   private boolean[] H00422_n19CitaId ;
   private String[] H00422_A246PagoEstadoR ;
   private String[] H00422_A339PagoEnlaceXML ;
   private String[] H00422_A338PagoEnlacePDF ;
   private int[] H00422_A34DisponibilidadId ;
   private boolean[] H00422_n34DisponibilidadId ;
   private int[] H00422_A311PagoStatusCode ;
   private String[] H00422_A310PagoPasarelaId ;
   private String[] H00422_A309PagoResponse ;
   private String[] H00422_A308PagoRequest ;
   private String[] H00422_A257PagoNubefactResponse ;
   private String[] H00422_A256PagoNubefactRequest ;
   private short[] H00422_A253PagoMoneda ;
   private java.util.Date[] H00422_A252PagoFechaEmision ;
   private int[] H00422_A245PagoNumero ;
   private short[] H00422_A244PagoTipoDocumento ;
   private String[] H00422_A251PagoClienteEmail ;
   private String[] H00422_A250PagoClienteDireccion ;
   private String[] H00422_A249PagoClienteDenominacion ;
   private String[] H00422_A248PagoClienteNroDocumento ;
   private String[] H00422_A247PagoTipoDocumentoCliente ;
   private String[] H00422_A243PagoToken ;
   private java.math.BigDecimal[] H00422_A242PagoMonto ;
   private java.util.Date[] H00422_A66SGCitaDisponibilidadFecha ;
   private boolean[] H00422_n66SGCitaDisponibilidadFecha ;
   private String[] H00422_A64CitaCode ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class pagogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00422", "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T1.[PagoId], T1.[CitaId], T1.[PagoEstadoR], T1.[PagoEnlaceXML], T1.[PagoEnlacePDF], T1.[DisponibilidadId], T1.[PagoStatusCode], T1.[PagoPasarelaId], T1.[PagoResponse], T1.[PagoRequest], T1.[PagoNubefactResponse], T1.[PagoNubefactRequest], T1.[PagoMoneda], T1.[PagoFechaEmision], T1.[PagoNumero], T1.[PagoTipoDocumento], T1.[PagoClienteEmail], T1.[PagoClienteDireccion], T1.[PagoClienteDenominacion], T1.[PagoClienteNroDocumento], T1.[PagoTipoDocumentoCliente], T1.[PagoToken], T1.[PagoMonto], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[CitaCode] FROM (([Pago] T1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) WHERE T1.[PagoId] = ? ORDER BY T1.[PagoId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(8);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               ((String[]) buf[11])[0] = rslt.getLongVarchar(10);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(11);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(12);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((java.util.Date[]) buf[16])[0] = rslt.getGXDate(15);
               ((int[]) buf[17])[0] = rslt.getInt(16);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((String[]) buf[19])[0] = rslt.getVarchar(18);
               ((String[]) buf[20])[0] = rslt.getVarchar(19);
               ((String[]) buf[21])[0] = rslt.getVarchar(20);
               ((String[]) buf[22])[0] = rslt.getVarchar(21);
               ((String[]) buf[23])[0] = rslt.getString(22, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(23);
               ((java.math.BigDecimal[]) buf[25])[0] = rslt.getBigDecimal(24,2);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(25);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(26);
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

