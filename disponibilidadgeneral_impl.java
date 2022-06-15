package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidadgeneral_impl extends GXWebComponent
{
   public disponibilidadgeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public disponibilidadgeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidadgeneral_impl.class ));
   }

   public disponibilidadgeneral_impl( int remoteHandle ,
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
      cmbDisponibilidadEstado = new HTMLChoice();
      cmbDisponibilidadEstadoCita = new HTMLChoice();
      cmbDisponibilidadTipoCita = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
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
               A34DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A34DisponibilidadId)});
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
         pa3S2( ) ;
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
         httpContext.writeValue( "Disponibilidad General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110324070", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.disponibilidadgeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A34DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"DisponibilidadGeneral");
      forbiddenHiddens.add("EspecialidadId", localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("disponibilidadgeneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA34DisponibilidadId", GXutil.ltrim( localUtil.ntoc( wcpOA34DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm3S2( )
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
      return "DisponibilidadGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Disponibilidad General" ;
   }

   public void wb3S0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.disponibilidadgeneral");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtDisponibilidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDisponibilidadId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEventId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEventId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEventId_Internalname, GXutil.rtrim( A133EventId), GXutil.rtrim( localUtil.format( A133EventId, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEventId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtEventId_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadDescription_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadDescription_Internalname, "Description", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadDescription_Internalname, A134DisponibilidadDescription, GXutil.rtrim( localUtil.format( A134DisponibilidadDescription, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadDescription_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDisponibilidadDescription_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalId_Internalname, "Profesional Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalApellidoPaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalApellidoPaterno_Internalname, "Apellido Paterno", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalApellidoPaterno_Internalname, A85ProfesionalApellidoPaterno, GXutil.rtrim( localUtil.format( A85ProfesionalApellidoPaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalApellidoPaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtProfesionalApellidoPaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalApellidoMaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalApellidoMaterno_Internalname, "Apellido Materno", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalApellidoMaterno_Internalname, A86ProfesionalApellidoMaterno, GXutil.rtrim( localUtil.format( A86ProfesionalApellidoMaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalApellidoMaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtProfesionalApellidoMaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalNombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalNombres_Internalname, "Nombres", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalNombres_Internalname, A84ProfesionalNombres, GXutil.rtrim( localUtil.format( A84ProfesionalNombres, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalNombres_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtProfesionalNombres_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalNombreCompleto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalNombreCompleto_Internalname, "Nombre Completo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalNombreCompleto_Internalname, A83ProfesionalNombreCompleto, GXutil.rtrim( localUtil.format( A83ProfesionalNombreCompleto, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalNombreCompleto_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtProfesionalNombreCompleto_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalCOP_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalCOP_Internalname, "CMP", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalCOP_Internalname, A88ProfesionalCOP, GXutil.rtrim( localUtil.format( A88ProfesionalCOP, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalCOP_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtProfesionalCOP_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadFecha_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadFecha_Internalname, "Fecha", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadFecha_Internalname, localUtil.format(A67DisponibilidadFecha, "99/99/99"), localUtil.format( A67DisponibilidadFecha, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadFecha_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_DisponibilidadGeneral.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadHoraInicio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadHoraInicio_Internalname, "Hora Inicio", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtDisponibilidadHoraInicio_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadHoraInicio_Internalname, localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A69DisponibilidadHoraInicio, "99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadHoraInicio_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDisponibilidadHoraInicio_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtDisponibilidadHoraInicio_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDisponibilidadHoraInicio_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_DisponibilidadGeneral.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadHoraFin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadHoraFin_Internalname, "Hora Fin", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtDisponibilidadHoraFin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadHoraFin_Internalname, localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A135DisponibilidadHoraFin, "99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadHoraFin_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDisponibilidadHoraFin_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtDisponibilidadHoraFin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDisponibilidadHoraFin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_DisponibilidadGeneral.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadId_Internalname, "Especialidad Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtEspecialidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtEspecialidadId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadCodigo_Internalname, "Especialidad Codigo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadCodigo_Internalname, A140EspecialidadCodigo, GXutil.rtrim( localUtil.format( A140EspecialidadCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadCodigo_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtEspecialidadCodigo_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadNombre_Internalname, "Especialidad Nombre", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadNombre_Internalname, A71EspecialidadNombre, GXutil.rtrim( localUtil.format( A71EspecialidadNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtEspecialidadNombre_Link, "", "", "", edtEspecialidadNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtEspecialidadNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadUser_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadUser_Internalname, "User", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadUser_Internalname, GXutil.ltrim( localUtil.ntoc( A137DisponibilidadUser, (byte)(6), (byte)(0), ",", "")), GXutil.ltrim( ((edtDisponibilidadUser_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A137DisponibilidadUser), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A137DisponibilidadUser), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadUser_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDisponibilidadUser_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDisponibilidadEstado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDisponibilidadEstado.getInternalname(), "Estado", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDisponibilidadEstado, cmbDisponibilidadEstado.getInternalname(), GXutil.rtrim( A136DisponibilidadEstado), 1, cmbDisponibilidadEstado.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDisponibilidadEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_DisponibilidadGeneral.htm");
         cmbDisponibilidadEstado.setValue( GXutil.rtrim( A136DisponibilidadEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbDisponibilidadEstado.getInternalname(), "Values", cmbDisponibilidadEstado.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDisponibilidadEstadoCita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDisponibilidadEstadoCita.getInternalname(), "Estado Cita", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDisponibilidadEstadoCita, cmbDisponibilidadEstadoCita.getInternalname(), GXutil.rtrim( A139DisponibilidadEstadoCita), 1, cmbDisponibilidadEstadoCita.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbDisponibilidadEstadoCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_DisponibilidadGeneral.htm");
         cmbDisponibilidadEstadoCita.setValue( GXutil.rtrim( A139DisponibilidadEstadoCita) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbDisponibilidadEstadoCita.getInternalname(), "Values", cmbDisponibilidadEstadoCita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDisponibilidadTipoCita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDisponibilidadTipoCita.getInternalname(), "Tipo Cita", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDisponibilidadTipoCita, cmbDisponibilidadTipoCita.getInternalname(), GXutil.rtrim( A298DisponibilidadTipoCita), 1, cmbDisponibilidadTipoCita.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDisponibilidadTipoCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_DisponibilidadGeneral.htm");
         cmbDisponibilidadTipoCita.setValue( GXutil.rtrim( A298DisponibilidadTipoCita) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbDisponibilidadTipoCita.getInternalname(), "Values", cmbDisponibilidadTipoCita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDCitaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDCitaId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ",", "")), GXutil.ltrim( ((edtDCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A138DCitaId), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A138DCitaId), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDCitaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDCitaId_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_DisponibilidadGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e113s1_client"+"'", TempTags, "", 2, "HLP_DisponibilidadGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e123s1_client"+"'", TempTags, "", 2, "HLP_DisponibilidadGeneral.htm");
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

   public void start3S2( )
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
            Form.getMeta().addItem("description", "Disponibilidad General", (short)(0)) ;
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
            strup3S0( ) ;
         }
      }
   }

   public void ws3S2( )
   {
      start3S2( ) ;
      evt3S2( ) ;
   }

   public void evt3S2( )
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
                              strup3S0( ) ;
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
                              strup3S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e133S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3S0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e143S2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3S0( ) ;
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
                              strup3S0( ) ;
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

   public void we3S2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3S2( ) ;
         }
      }
   }

   public void pa3S2( )
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
      if ( cmbDisponibilidadEstado.getItemCount() > 0 )
      {
         A136DisponibilidadEstado = cmbDisponibilidadEstado.getValidValue(A136DisponibilidadEstado) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDisponibilidadEstado.setValue( GXutil.rtrim( A136DisponibilidadEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbDisponibilidadEstado.getInternalname(), "Values", cmbDisponibilidadEstado.ToJavascriptSource(), true);
      }
      if ( cmbDisponibilidadEstadoCita.getItemCount() > 0 )
      {
         A139DisponibilidadEstadoCita = cmbDisponibilidadEstadoCita.getValidValue(A139DisponibilidadEstadoCita) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDisponibilidadEstadoCita.setValue( GXutil.rtrim( A139DisponibilidadEstadoCita) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbDisponibilidadEstadoCita.getInternalname(), "Values", cmbDisponibilidadEstadoCita.ToJavascriptSource(), true);
      }
      if ( cmbDisponibilidadTipoCita.getItemCount() > 0 )
      {
         A298DisponibilidadTipoCita = cmbDisponibilidadTipoCita.getValidValue(A298DisponibilidadTipoCita) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDisponibilidadTipoCita.setValue( GXutil.rtrim( A298DisponibilidadTipoCita) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbDisponibilidadTipoCita.getInternalname(), "Values", cmbDisponibilidadTipoCita.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3S2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV15Pgmname = "DisponibilidadGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf3S2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H003S3 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A34DisponibilidadId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A298DisponibilidadTipoCita = H003S3_A298DisponibilidadTipoCita[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
            A139DisponibilidadEstadoCita = H003S3_A139DisponibilidadEstadoCita[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
            A136DisponibilidadEstado = H003S3_A136DisponibilidadEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
            A137DisponibilidadUser = H003S3_A137DisponibilidadUser[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A137DisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(A137DisponibilidadUser), 6, 0));
            A71EspecialidadNombre = H003S3_A71EspecialidadNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A71EspecialidadNombre", A71EspecialidadNombre);
            A140EspecialidadCodigo = H003S3_A140EspecialidadCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
            A32EspecialidadId = H003S3_A32EspecialidadId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
            A135DisponibilidadHoraFin = H003S3_A135DisponibilidadHoraFin[0] ;
            n135DisponibilidadHoraFin = H003S3_n135DisponibilidadHoraFin[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A135DisponibilidadHoraFin", localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            A69DisponibilidadHoraInicio = H003S3_A69DisponibilidadHoraInicio[0] ;
            n69DisponibilidadHoraInicio = H003S3_n69DisponibilidadHoraInicio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A69DisponibilidadHoraInicio", localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            A67DisponibilidadFecha = H003S3_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = H003S3_n67DisponibilidadFecha[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A67DisponibilidadFecha", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
            A88ProfesionalCOP = H003S3_A88ProfesionalCOP[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ProfesionalCOP", A88ProfesionalCOP);
            A31ProfesionalId = H003S3_A31ProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
            A134DisponibilidadDescription = H003S3_A134DisponibilidadDescription[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A134DisponibilidadDescription", A134DisponibilidadDescription);
            A133EventId = H003S3_A133EventId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A133EventId", A133EventId);
            A138DCitaId = H003S3_A138DCitaId[0] ;
            n138DCitaId = H003S3_n138DCitaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
            A86ProfesionalApellidoMaterno = H003S3_A86ProfesionalApellidoMaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
            A85ProfesionalApellidoPaterno = H003S3_A85ProfesionalApellidoPaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
            A84ProfesionalNombres = H003S3_A84ProfesionalNombres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A84ProfesionalNombres", A84ProfesionalNombres);
            A71EspecialidadNombre = H003S3_A71EspecialidadNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A71EspecialidadNombre", A71EspecialidadNombre);
            A140EspecialidadCodigo = H003S3_A140EspecialidadCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
            A88ProfesionalCOP = H003S3_A88ProfesionalCOP[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ProfesionalCOP", A88ProfesionalCOP);
            A86ProfesionalApellidoMaterno = H003S3_A86ProfesionalApellidoMaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
            A85ProfesionalApellidoPaterno = H003S3_A85ProfesionalApellidoPaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
            A84ProfesionalNombres = H003S3_A84ProfesionalNombres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A84ProfesionalNombres", A84ProfesionalNombres);
            A138DCitaId = H003S3_A138DCitaId[0] ;
            n138DCitaId = H003S3_n138DCitaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
            A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
            /* Execute user event: Load */
            e143S2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb3S0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3S2( )
   {
   }

   public void before_start_formulas( )
   {
      AV15Pgmname = "DisponibilidadGeneral" ;
      Gx_err = (short)(0) ;
      /* Using cursor H003S5 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A138DCitaId = H003S5_A138DCitaId[0] ;
         n138DCitaId = H003S5_n138DCitaId[0] ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
      }
      else
      {
         A138DCitaId = 0 ;
         n138DCitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
      }
      pr_default.close(1);
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup3S0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e133S2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA34DisponibilidadId"), ",", ".")) ;
         /* Read variables values. */
         A133EventId = httpContext.cgiGet( edtEventId_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A133EventId", A133EventId);
         A134DisponibilidadDescription = httpContext.cgiGet( edtDisponibilidadDescription_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A134DisponibilidadDescription", A134DisponibilidadDescription);
         A31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         A85ProfesionalApellidoPaterno = httpContext.cgiGet( edtProfesionalApellidoPaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
         A86ProfesionalApellidoMaterno = httpContext.cgiGet( edtProfesionalApellidoMaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
         A84ProfesionalNombres = httpContext.cgiGet( edtProfesionalNombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A84ProfesionalNombres", A84ProfesionalNombres);
         A83ProfesionalNombreCompleto = httpContext.cgiGet( edtProfesionalNombreCompleto_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
         A88ProfesionalCOP = httpContext.cgiGet( edtProfesionalCOP_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A88ProfesionalCOP", A88ProfesionalCOP);
         A67DisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtDisponibilidadFecha_Internalname), 3) ;
         n67DisponibilidadFecha = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A67DisponibilidadFecha", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
         A69DisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraInicio_Internalname))) ;
         n69DisponibilidadHoraInicio = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A69DisponibilidadHoraInicio", localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
         A135DisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraFin_Internalname))) ;
         n135DisponibilidadHoraFin = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A135DisponibilidadHoraFin", localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
         A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         A140EspecialidadCodigo = httpContext.cgiGet( edtEspecialidadCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
         A71EspecialidadNombre = httpContext.cgiGet( edtEspecialidadNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A71EspecialidadNombre", A71EspecialidadNombre);
         A137DisponibilidadUser = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadUser_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A137DisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(A137DisponibilidadUser), 6, 0));
         cmbDisponibilidadEstado.setValue( httpContext.cgiGet( cmbDisponibilidadEstado.getInternalname()) );
         A136DisponibilidadEstado = httpContext.cgiGet( cmbDisponibilidadEstado.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
         cmbDisponibilidadEstadoCita.setValue( httpContext.cgiGet( cmbDisponibilidadEstadoCita.getInternalname()) );
         A139DisponibilidadEstadoCita = httpContext.cgiGet( cmbDisponibilidadEstadoCita.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
         cmbDisponibilidadTipoCita.setValue( httpContext.cgiGet( cmbDisponibilidadTipoCita.getInternalname()) );
         A298DisponibilidadTipoCita = httpContext.cgiGet( cmbDisponibilidadTipoCita.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
         A138DCitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtDCitaId_Internalname), ",", ".")) ;
         n138DCitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"DisponibilidadGeneral");
         A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         forbiddenHiddens.add("EspecialidadId", localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("disponibilidadgeneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e133S2 ();
      if (returnInSub) return;
   }

   public void e133S2( )
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

   protected void e143S2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad", GXv_boolean3) ;
      disponibilidadgeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( AV12TempBoolean )
      {
         edtEspecialidadNombre_Link = formatLink("com.projectthani.especialidadview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A32EspecialidadId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"EspecialidadId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtEspecialidadNombre_Internalname, "Link", edtEspecialidadNombre_Link, true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Update", GXv_boolean3) ;
      disponibilidadgeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Delete", GXv_boolean3) ;
      disponibilidadgeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Disponibilidad" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A34DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
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
      pa3S2( ) ;
      ws3S2( ) ;
      we3S2( ) ;
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
      sCtrlA34DisponibilidadId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3S2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "disponibilidadgeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3S2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A34DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      }
      wcpOA34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA34DisponibilidadId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A34DisponibilidadId != wcpOA34DisponibilidadId ) ) )
      {
         setjustcreated();
      }
      wcpOA34DisponibilidadId = A34DisponibilidadId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA34DisponibilidadId = httpContext.cgiGet( sPrefix+"A34DisponibilidadId_CTRL") ;
      if ( GXutil.len( sCtrlA34DisponibilidadId) > 0 )
      {
         A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA34DisponibilidadId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      }
      else
      {
         A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A34DisponibilidadId_PARM"), ",", ".")) ;
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
      pa3S2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3S2( ) ;
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
      ws3S2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A34DisponibilidadId_PARM", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA34DisponibilidadId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A34DisponibilidadId_CTRL", GXutil.rtrim( sCtrlA34DisponibilidadId));
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
      we3S2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110324145", true, true);
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
      httpContext.AddJavascriptSource("disponibilidadgeneral.js", "?20225110324145", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtDisponibilidadId_Internalname = sPrefix+"DISPONIBILIDADID" ;
      edtEventId_Internalname = sPrefix+"EVENTID" ;
      edtDisponibilidadDescription_Internalname = sPrefix+"DISPONIBILIDADDESCRIPTION" ;
      edtProfesionalId_Internalname = sPrefix+"PROFESIONALID" ;
      edtProfesionalApellidoPaterno_Internalname = sPrefix+"PROFESIONALAPELLIDOPATERNO" ;
      edtProfesionalApellidoMaterno_Internalname = sPrefix+"PROFESIONALAPELLIDOMATERNO" ;
      edtProfesionalNombres_Internalname = sPrefix+"PROFESIONALNOMBRES" ;
      edtProfesionalNombreCompleto_Internalname = sPrefix+"PROFESIONALNOMBRECOMPLETO" ;
      edtProfesionalCOP_Internalname = sPrefix+"PROFESIONALCOP" ;
      edtDisponibilidadFecha_Internalname = sPrefix+"DISPONIBILIDADFECHA" ;
      edtDisponibilidadHoraInicio_Internalname = sPrefix+"DISPONIBILIDADHORAINICIO" ;
      edtDisponibilidadHoraFin_Internalname = sPrefix+"DISPONIBILIDADHORAFIN" ;
      edtEspecialidadId_Internalname = sPrefix+"ESPECIALIDADID" ;
      edtEspecialidadCodigo_Internalname = sPrefix+"ESPECIALIDADCODIGO" ;
      edtEspecialidadNombre_Internalname = sPrefix+"ESPECIALIDADNOMBRE" ;
      edtDisponibilidadUser_Internalname = sPrefix+"DISPONIBILIDADUSER" ;
      cmbDisponibilidadEstado.setInternalname( sPrefix+"DISPONIBILIDADESTADO" );
      cmbDisponibilidadEstadoCita.setInternalname( sPrefix+"DISPONIBILIDADESTADOCITA" );
      cmbDisponibilidadTipoCita.setInternalname( sPrefix+"DISPONIBILIDADTIPOCITA" );
      edtDCitaId_Internalname = sPrefix+"DCITAID" ;
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
      edtDCitaId_Jsonclick = "" ;
      edtDCitaId_Enabled = 0 ;
      cmbDisponibilidadTipoCita.setJsonclick( "" );
      cmbDisponibilidadTipoCita.setEnabled( 0 );
      cmbDisponibilidadEstadoCita.setJsonclick( "" );
      cmbDisponibilidadEstadoCita.setEnabled( 0 );
      cmbDisponibilidadEstado.setJsonclick( "" );
      cmbDisponibilidadEstado.setEnabled( 0 );
      edtDisponibilidadUser_Jsonclick = "" ;
      edtDisponibilidadUser_Enabled = 0 ;
      edtEspecialidadNombre_Jsonclick = "" ;
      edtEspecialidadNombre_Link = "" ;
      edtEspecialidadNombre_Enabled = 0 ;
      edtEspecialidadCodigo_Jsonclick = "" ;
      edtEspecialidadCodigo_Enabled = 0 ;
      edtEspecialidadId_Jsonclick = "" ;
      edtEspecialidadId_Enabled = 0 ;
      edtDisponibilidadHoraFin_Jsonclick = "" ;
      edtDisponibilidadHoraFin_Enabled = 0 ;
      edtDisponibilidadHoraInicio_Jsonclick = "" ;
      edtDisponibilidadHoraInicio_Enabled = 0 ;
      edtDisponibilidadFecha_Jsonclick = "" ;
      edtDisponibilidadFecha_Enabled = 0 ;
      edtProfesionalCOP_Jsonclick = "" ;
      edtProfesionalCOP_Enabled = 0 ;
      edtProfesionalNombreCompleto_Jsonclick = "" ;
      edtProfesionalNombreCompleto_Enabled = 0 ;
      edtProfesionalNombres_Jsonclick = "" ;
      edtProfesionalNombres_Enabled = 0 ;
      edtProfesionalApellidoMaterno_Jsonclick = "" ;
      edtProfesionalApellidoMaterno_Enabled = 0 ;
      edtProfesionalApellidoPaterno_Jsonclick = "" ;
      edtProfesionalApellidoPaterno_Enabled = 0 ;
      edtProfesionalId_Jsonclick = "" ;
      edtProfesionalId_Enabled = 0 ;
      edtDisponibilidadDescription_Jsonclick = "" ;
      edtDisponibilidadDescription_Enabled = 0 ;
      edtEventId_Jsonclick = "" ;
      edtEventId_Enabled = 0 ;
      edtDisponibilidadId_Jsonclick = "" ;
      edtDisponibilidadId_Enabled = 0 ;
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
      cmbDisponibilidadEstado.setName( "DISPONIBILIDADESTADO" );
      cmbDisponibilidadEstado.setWebtags( "" );
      cmbDisponibilidadEstado.addItem("A", "Activo", (short)(0));
      cmbDisponibilidadEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbDisponibilidadEstado.getItemCount() > 0 )
      {
      }
      cmbDisponibilidadEstadoCita.setName( "DISPONIBILIDADESTADOCITA" );
      cmbDisponibilidadEstadoCita.setWebtags( "" );
      cmbDisponibilidadEstadoCita.addItem("L", "Libre", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("O", "Ocupado", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("E", "Expiró", (short)(0));
      if ( cmbDisponibilidadEstadoCita.getItemCount() > 0 )
      {
      }
      cmbDisponibilidadTipoCita.setName( "DISPONIBILIDADTIPOCITA" );
      cmbDisponibilidadTipoCita.setWebtags( "" );
      cmbDisponibilidadTipoCita.addItem("V", "Virtual", (short)(0));
      cmbDisponibilidadTipoCita.addItem("P", "En consultorio", (short)(0));
      cmbDisponibilidadTipoCita.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbDisponibilidadTipoCita.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A32EspecialidadId',fld:'ESPECIALIDADID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e113S1',iparms:[{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e123S1',iparms:[{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_DISPONIBILIDADID","{handler:'valid_Disponibilidadid',iparms:[]");
      setEventMetadata("VALID_DISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALID","{handler:'valid_Profesionalid',iparms:[]");
      setEventMetadata("VALID_PROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO","{handler:'valid_Profesionalapellidopaterno',iparms:[]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO","{handler:'valid_Profesionalapellidomaterno',iparms:[]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALNOMBRES","{handler:'valid_Profesionalnombres',iparms:[]");
      setEventMetadata("VALID_PROFESIONALNOMBRES",",oparms:[]}");
      setEventMetadata("VALID_ESPECIALIDADID","{handler:'valid_Especialidadid',iparms:[]");
      setEventMetadata("VALID_ESPECIALIDADID",",oparms:[]}");
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
      GX_FocusControl = "" ;
      A133EventId = "" ;
      A134DisponibilidadDescription = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A83ProfesionalNombreCompleto = "" ;
      A88ProfesionalCOP = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      H003S3_A34DisponibilidadId = new int[1] ;
      H003S3_A298DisponibilidadTipoCita = new String[] {""} ;
      H003S3_A139DisponibilidadEstadoCita = new String[] {""} ;
      H003S3_A136DisponibilidadEstado = new String[] {""} ;
      H003S3_A137DisponibilidadUser = new int[1] ;
      H003S3_A71EspecialidadNombre = new String[] {""} ;
      H003S3_A140EspecialidadCodigo = new String[] {""} ;
      H003S3_A32EspecialidadId = new short[1] ;
      H003S3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      H003S3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      H003S3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      H003S3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      H003S3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H003S3_n67DisponibilidadFecha = new boolean[] {false} ;
      H003S3_A88ProfesionalCOP = new String[] {""} ;
      H003S3_A31ProfesionalId = new int[1] ;
      H003S3_A134DisponibilidadDescription = new String[] {""} ;
      H003S3_A133EventId = new String[] {""} ;
      H003S3_A138DCitaId = new int[1] ;
      H003S3_n138DCitaId = new boolean[] {false} ;
      H003S3_A86ProfesionalApellidoMaterno = new String[] {""} ;
      H003S3_A85ProfesionalApellidoPaterno = new String[] {""} ;
      H003S3_A84ProfesionalNombres = new String[] {""} ;
      H003S5_A138DCitaId = new int[1] ;
      H003S5_n138DCitaId = new boolean[] {false} ;
      hsh = "" ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA34DisponibilidadId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidadgeneral__default(),
         new Object[] {
             new Object[] {
            H003S3_A34DisponibilidadId, H003S3_A298DisponibilidadTipoCita, H003S3_A139DisponibilidadEstadoCita, H003S3_A136DisponibilidadEstado, H003S3_A137DisponibilidadUser, H003S3_A71EspecialidadNombre, H003S3_A140EspecialidadCodigo, H003S3_A32EspecialidadId, H003S3_A135DisponibilidadHoraFin, H003S3_n135DisponibilidadHoraFin,
            H003S3_A69DisponibilidadHoraInicio, H003S3_n69DisponibilidadHoraInicio, H003S3_A67DisponibilidadFecha, H003S3_n67DisponibilidadFecha, H003S3_A88ProfesionalCOP, H003S3_A31ProfesionalId, H003S3_A134DisponibilidadDescription, H003S3_A133EventId, H003S3_A138DCitaId, H003S3_n138DCitaId,
            H003S3_A86ProfesionalApellidoMaterno, H003S3_A85ProfesionalApellidoPaterno, H003S3_A84ProfesionalNombres
            }
            , new Object[] {
            H003S5_A138DCitaId, H003S5_n138DCitaId
            }
         }
      );
      AV15Pgmname = "DisponibilidadGeneral" ;
      /* GeneXus formulas. */
      AV15Pgmname = "DisponibilidadGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short A32EspecialidadId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA34DisponibilidadId ;
   private int A34DisponibilidadId ;
   private int edtDisponibilidadId_Enabled ;
   private int edtEventId_Enabled ;
   private int edtDisponibilidadDescription_Enabled ;
   private int A31ProfesionalId ;
   private int edtProfesionalId_Enabled ;
   private int edtProfesionalApellidoPaterno_Enabled ;
   private int edtProfesionalApellidoMaterno_Enabled ;
   private int edtProfesionalNombres_Enabled ;
   private int edtProfesionalNombreCompleto_Enabled ;
   private int edtProfesionalCOP_Enabled ;
   private int edtDisponibilidadFecha_Enabled ;
   private int edtDisponibilidadHoraInicio_Enabled ;
   private int edtDisponibilidadHoraFin_Enabled ;
   private int edtEspecialidadId_Enabled ;
   private int edtEspecialidadCodigo_Enabled ;
   private int edtEspecialidadNombre_Enabled ;
   private int A137DisponibilidadUser ;
   private int edtDisponibilidadUser_Enabled ;
   private int A138DCitaId ;
   private int edtDCitaId_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
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
   private String edtDisponibilidadId_Internalname ;
   private String edtDisponibilidadId_Jsonclick ;
   private String edtEventId_Internalname ;
   private String A133EventId ;
   private String edtEventId_Jsonclick ;
   private String edtDisponibilidadDescription_Internalname ;
   private String edtDisponibilidadDescription_Jsonclick ;
   private String edtProfesionalId_Internalname ;
   private String edtProfesionalId_Jsonclick ;
   private String edtProfesionalApellidoPaterno_Internalname ;
   private String edtProfesionalApellidoPaterno_Jsonclick ;
   private String edtProfesionalApellidoMaterno_Internalname ;
   private String edtProfesionalApellidoMaterno_Jsonclick ;
   private String edtProfesionalNombres_Internalname ;
   private String edtProfesionalNombres_Jsonclick ;
   private String edtProfesionalNombreCompleto_Internalname ;
   private String edtProfesionalNombreCompleto_Jsonclick ;
   private String edtProfesionalCOP_Internalname ;
   private String edtProfesionalCOP_Jsonclick ;
   private String edtDisponibilidadFecha_Internalname ;
   private String edtDisponibilidadFecha_Jsonclick ;
   private String edtDisponibilidadHoraInicio_Internalname ;
   private String edtDisponibilidadHoraInicio_Jsonclick ;
   private String edtDisponibilidadHoraFin_Internalname ;
   private String edtDisponibilidadHoraFin_Jsonclick ;
   private String edtEspecialidadId_Internalname ;
   private String edtEspecialidadId_Jsonclick ;
   private String edtEspecialidadCodigo_Internalname ;
   private String edtEspecialidadCodigo_Jsonclick ;
   private String edtEspecialidadNombre_Internalname ;
   private String edtEspecialidadNombre_Link ;
   private String edtEspecialidadNombre_Jsonclick ;
   private String edtDisponibilidadUser_Internalname ;
   private String edtDisponibilidadUser_Jsonclick ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
   private String edtDCitaId_Internalname ;
   private String edtDCitaId_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
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
   private String sCtrlA34DisponibilidadId ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n67DisponibilidadFecha ;
   private boolean n138DCitaId ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A134DisponibilidadDescription ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A83ProfesionalNombreCompleto ;
   private String A88ProfesionalCOP ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A139DisponibilidadEstadoCita ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbDisponibilidadEstado ;
   private HTMLChoice cmbDisponibilidadEstadoCita ;
   private HTMLChoice cmbDisponibilidadTipoCita ;
   private IDataStoreProvider pr_default ;
   private int[] H003S3_A34DisponibilidadId ;
   private String[] H003S3_A298DisponibilidadTipoCita ;
   private String[] H003S3_A139DisponibilidadEstadoCita ;
   private String[] H003S3_A136DisponibilidadEstado ;
   private int[] H003S3_A137DisponibilidadUser ;
   private String[] H003S3_A71EspecialidadNombre ;
   private String[] H003S3_A140EspecialidadCodigo ;
   private short[] H003S3_A32EspecialidadId ;
   private java.util.Date[] H003S3_A135DisponibilidadHoraFin ;
   private boolean[] H003S3_n135DisponibilidadHoraFin ;
   private java.util.Date[] H003S3_A69DisponibilidadHoraInicio ;
   private boolean[] H003S3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] H003S3_A67DisponibilidadFecha ;
   private boolean[] H003S3_n67DisponibilidadFecha ;
   private String[] H003S3_A88ProfesionalCOP ;
   private int[] H003S3_A31ProfesionalId ;
   private String[] H003S3_A134DisponibilidadDescription ;
   private String[] H003S3_A133EventId ;
   private int[] H003S3_A138DCitaId ;
   private boolean[] H003S3_n138DCitaId ;
   private String[] H003S3_A86ProfesionalApellidoMaterno ;
   private String[] H003S3_A85ProfesionalApellidoPaterno ;
   private String[] H003S3_A84ProfesionalNombres ;
   private int[] H003S5_A138DCitaId ;
   private boolean[] H003S5_n138DCitaId ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class disponibilidadgeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003S3", "SELECT T1.[DisponibilidadId], T1.[DisponibilidadTipoCita], T1.[DisponibilidadEstadoCita], T1.[DisponibilidadEstado], T1.[DisponibilidadUser], T2.[EspecialidadNombre], T2.[EspecialidadCodigo], T1.[EspecialidadId], T1.[DisponibilidadHoraFin], T1.[DisponibilidadHoraInicio], T1.[DisponibilidadFecha], T3.[ProfesionalCOP], T1.[ProfesionalId], T1.[DisponibilidadDescription], T1.[EventId], COALESCE( T4.[DCitaId], 0) AS DCitaId, T3.[ProfesionalApellidoMaterno], T3.[ProfesionalApellidoPaterno], T3.[ProfesionalNombres] FROM ((([Disponibilidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) INNER JOIN [Profesional] T3 ON T3.[ProfesionalId] = T1.[ProfesionalId]) LEFT JOIN (SELECT MIN(T5.[CitaId]) AS DCitaId, T5.[SGCitaDisponibilidadId] FROM [Cita] T5,  [Disponibilidad] T6 WHERE (T5.[SGCitaDisponibilidadId] = T6.[DisponibilidadId]) AND (T5.[CitaEstado] = 'A') GROUP BY T5.[SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = T1.[DisponibilidadId]) WHERE T1.[DisponibilidadId] = ? ORDER BY T1.[DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H003S5", "SELECT COALESCE( T1.[DCitaId], 0) AS DCitaId FROM (SELECT MIN(T2.[CitaId]) AS DCitaId, T2.[SGCitaDisponibilidadId] FROM [Cita] T2,  [Disponibilidad] T3 WHERE (T2.[SGCitaDisponibilidadId] = T3.[DisponibilidadId]) AND (T2.[CitaEstado] = 'A') GROUP BY T2.[SGCitaDisponibilidadId] ) T1 WHERE T1.[SGCitaDisponibilidadId] = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((java.util.Date[]) buf[8])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[10])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(11);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((String[]) buf[17])[0] = rslt.getString(15, 20);
               ((int[]) buf[18])[0] = rslt.getInt(16);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(17);
               ((String[]) buf[21])[0] = rslt.getVarchar(18);
               ((String[]) buf[22])[0] = rslt.getVarchar(19);
               return;
            case 1 :
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
      }
   }

}

