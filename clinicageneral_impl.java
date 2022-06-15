package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clinicageneral_impl extends GXWebComponent
{
   public clinicageneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clinicageneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clinicageneral_impl.class ));
   }

   public clinicageneral_impl( int remoteHandle ,
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
      cmbClinicaMoneda = new HTMLChoice();
      cmbClinicaTiempoDeCita = new HTMLChoice();
      cmbClinicaEstado = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "ClinicaId") ;
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
               A28ClinicaId = (short)(GXutil.lval( httpContext.GetPar( "ClinicaId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A28ClinicaId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "ClinicaId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "ClinicaId") ;
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
         pa5C2( ) ;
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
         httpContext.writeValue( "Clinica General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110323463", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.clinicageneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A28ClinicaId,4,0))}, new String[] {"ClinicaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ClinicaGeneral");
      forbiddenHiddens.add("ClinicaFacebook", GXutil.rtrim( localUtil.format( A348ClinicaFacebook, "")));
      forbiddenHiddens.add("ClinicaTwiter", GXutil.rtrim( localUtil.format( A349ClinicaTwiter, "")));
      forbiddenHiddens.add("ClinicaInstagram", GXutil.rtrim( localUtil.format( A350ClinicaInstagram, "")));
      forbiddenHiddens.add("ClinicaLinkedin", GXutil.rtrim( localUtil.format( A351ClinicaLinkedin, "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("clinicageneral:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA28ClinicaId", GXutil.ltrim( localUtil.ntoc( wcpOA28ClinicaId, (byte)(4), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm5C2( )
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
      return "ClinicaGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Clinica General" ;
   }

   public void wb5C0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.clinicageneral");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtClinicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaRUC_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaRUC_Internalname, "RUC", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaRUC_Internalname, GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ",", "")), GXutil.ltrim( ((edtClinicaRUC_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaRUC_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaRUC_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaNombreComercial_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaNombreComercial_Internalname, "Nombre Comercial", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaNombreComercial_Internalname, A116ClinicaNombreComercial, GXutil.rtrim( localUtil.format( A116ClinicaNombreComercial, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaNombreComercial_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaNombreComercial_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaNombreAbreviado_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaNombreAbreviado_Internalname, "Nombre Abrev.", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaNombreAbreviado_Internalname, A80ClinicaNombreAbreviado, GXutil.rtrim( localUtil.format( A80ClinicaNombreAbreviado, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaNombreAbreviado_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaNombreAbreviado_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaDireccionComercial_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaDireccionComercial_Internalname, "Direccion Comercial", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtClinicaDireccionComercial_Internalname, A119ClinicaDireccionComercial, "http://maps.google.com/maps?q="+PrivateUtilities.encodeURL( A119ClinicaDireccionComercial), "", (short)(0), 1, edtClinicaDireccionComercial_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "1024", -1, 0, "_blank", "", (byte)(0), true, "GeneXus\\Address", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaCorreo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaCorreo_Internalname, "Correo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaCorreo_Internalname, A340ClinicaCorreo, GXutil.rtrim( localUtil.format( A340ClinicaCorreo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "mailto:"+A340ClinicaCorreo, "", "", "", edtClinicaCorreo_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbClinicaMoneda.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbClinicaMoneda.getInternalname(), "Moneda", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbClinicaMoneda, cmbClinicaMoneda.getInternalname(), GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)), 1, cmbClinicaMoneda.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbClinicaMoneda.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_ClinicaGeneral.htm");
         cmbClinicaMoneda.setValue( GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbClinicaMoneda.getInternalname(), "Values", cmbClinicaMoneda.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         A117ClinicaLogo_IsBlob = (boolean)(((GXutil.strcmp("", A117ClinicaLogo)==0)&&(GXutil.strcmp("", A40000ClinicaLogo_GXI)==0))||!(GXutil.strcmp("", A117ClinicaLogo)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.getResourceRelative(A117ClinicaLogo)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogo_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A117ClinicaLogo_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoHeader_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Header", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         A342ClinicaLogoHeader_IsBlob = (boolean)(((GXutil.strcmp("", A342ClinicaLogoHeader)==0)&&(GXutil.strcmp("", A40001ClinicaLogoHeader_GXI)==0))||!(GXutil.strcmp("", A342ClinicaLogoHeader)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.getResourceRelative(A342ClinicaLogoHeader)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoHeader_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A342ClinicaLogoHeader_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoFactura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Factura", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         A343ClinicaLogoFactura_IsBlob = (boolean)(((GXutil.strcmp("", A343ClinicaLogoFactura)==0)&&(GXutil.strcmp("", A40002ClinicaLogoFactura_GXI)==0))||!(GXutil.strcmp("", A343ClinicaLogoFactura)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.getResourceRelative(A343ClinicaLogoFactura)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoFactura_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A343ClinicaLogoFactura_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoBoleta_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Boleta", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         A344ClinicaLogoBoleta_IsBlob = (boolean)(((GXutil.strcmp("", A344ClinicaLogoBoleta)==0)&&(GXutil.strcmp("", A40003ClinicaLogoBoleta_GXI)==0))||!(GXutil.strcmp("", A344ClinicaLogoBoleta)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.getResourceRelative(A344ClinicaLogoBoleta)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoBoleta_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A344ClinicaLogoBoleta_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoPago_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Pago", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         A345ClinicaLogoPago_IsBlob = (boolean)(((GXutil.strcmp("", A345ClinicaLogoPago)==0)&&(GXutil.strcmp("", A40004ClinicaLogoPago_GXI)==0))||!(GXutil.strcmp("", A345ClinicaLogoPago)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.getResourceRelative(A345ClinicaLogoPago)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoPago_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A345ClinicaLogoPago_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaTelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaTelefono_Internalname, "Telefono", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaTelefono_Internalname, GXutil.rtrim( A346ClinicaTelefono), GXutil.rtrim( localUtil.format( A346ClinicaTelefono, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaTelefono_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaTelefono_Enabled, 0, "text", "", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaWhatsApp_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaWhatsApp_Internalname, "Whats App", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaWhatsApp_Internalname, GXutil.rtrim( A347ClinicaWhatsApp), GXutil.rtrim( localUtil.format( A347ClinicaWhatsApp, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaWhatsApp_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaWhatsApp_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaFacebook_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaFacebook_Internalname, "Facebook", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaFacebook_Internalname, A348ClinicaFacebook, GXutil.rtrim( localUtil.format( A348ClinicaFacebook, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtClinicaFacebook_Link, edtClinicaFacebook_Linktarget, "", "", edtClinicaFacebook_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaFacebook_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaTwiter_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaTwiter_Internalname, "Twiter", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaTwiter_Internalname, A349ClinicaTwiter, GXutil.rtrim( localUtil.format( A349ClinicaTwiter, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtClinicaTwiter_Link, edtClinicaTwiter_Linktarget, "", "", edtClinicaTwiter_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaTwiter_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaInstagram_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaInstagram_Internalname, "Instagram", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaInstagram_Internalname, A350ClinicaInstagram, GXutil.rtrim( localUtil.format( A350ClinicaInstagram, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtClinicaInstagram_Link, edtClinicaInstagram_Linktarget, "", "", edtClinicaInstagram_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaInstagram_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaLinkedin_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaLinkedin_Internalname, "Linkedin", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaLinkedin_Internalname, A351ClinicaLinkedin, GXutil.rtrim( localUtil.format( A351ClinicaLinkedin, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtClinicaLinkedin_Link, edtClinicaLinkedin_Linktarget, "", "", edtClinicaLinkedin_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtClinicaLinkedin_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbClinicaTiempoDeCita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbClinicaTiempoDeCita.getInternalname(), "Tiempo De Cita", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbClinicaTiempoDeCita, cmbClinicaTiempoDeCita.getInternalname(), GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)), 1, cmbClinicaTiempoDeCita.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbClinicaTiempoDeCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_ClinicaGeneral.htm");
         cmbClinicaTiempoDeCita.setValue( GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbClinicaTiempoDeCita.getInternalname(), "Values", cmbClinicaTiempoDeCita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbClinicaEstado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbClinicaEstado.getInternalname(), "Estado", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbClinicaEstado, cmbClinicaEstado.getInternalname(), GXutil.rtrim( A121ClinicaEstado), 1, cmbClinicaEstado.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbClinicaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_ClinicaGeneral.htm");
         cmbClinicaEstado.setValue( GXutil.rtrim( A121ClinicaEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbClinicaEstado.getInternalname(), "Values", cmbClinicaEstado.ToJavascriptSource(), true);
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
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e115c1_client"+"'", TempTags, "", 2, "HLP_ClinicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 116,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e125c1_client"+"'", TempTags, "", 2, "HLP_ClinicaGeneral.htm");
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

   public void start5C2( )
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
            Form.getMeta().addItem("description", "Clinica General", (short)(0)) ;
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
            strup5C0( ) ;
         }
      }
   }

   public void ws5C2( )
   {
      start5C2( ) ;
      evt5C2( ) ;
   }

   public void evt5C2( )
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
                              strup5C0( ) ;
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
                              strup5C0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e135C2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5C0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e145C2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup5C0( ) ;
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
                              strup5C0( ) ;
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

   public void we5C2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm5C2( ) ;
         }
      }
   }

   public void pa5C2( )
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
      if ( cmbClinicaMoneda.getItemCount() > 0 )
      {
         A341ClinicaMoneda = (short)(GXutil.lval( cmbClinicaMoneda.getValidValue(GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbClinicaMoneda.setValue( GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbClinicaMoneda.getInternalname(), "Values", cmbClinicaMoneda.ToJavascriptSource(), true);
      }
      if ( cmbClinicaTiempoDeCita.getItemCount() > 0 )
      {
         A120ClinicaTiempoDeCita = (byte)(GXutil.lval( cmbClinicaTiempoDeCita.getValidValue(GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbClinicaTiempoDeCita.setValue( GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbClinicaTiempoDeCita.getInternalname(), "Values", cmbClinicaTiempoDeCita.ToJavascriptSource(), true);
      }
      if ( cmbClinicaEstado.getItemCount() > 0 )
      {
         A121ClinicaEstado = cmbClinicaEstado.getValidValue(A121ClinicaEstado) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A121ClinicaEstado", A121ClinicaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbClinicaEstado.setValue( GXutil.rtrim( A121ClinicaEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbClinicaEstado.getInternalname(), "Values", cmbClinicaEstado.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf5C2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV15Pgmname = "ClinicaGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf5C2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H005C2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A28ClinicaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A121ClinicaEstado = H005C2_A121ClinicaEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A121ClinicaEstado", A121ClinicaEstado);
            A120ClinicaTiempoDeCita = H005C2_A120ClinicaTiempoDeCita[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
            A351ClinicaLinkedin = H005C2_A351ClinicaLinkedin[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A351ClinicaLinkedin", A351ClinicaLinkedin);
            A350ClinicaInstagram = H005C2_A350ClinicaInstagram[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A350ClinicaInstagram", A350ClinicaInstagram);
            A349ClinicaTwiter = H005C2_A349ClinicaTwiter[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A349ClinicaTwiter", A349ClinicaTwiter);
            A348ClinicaFacebook = H005C2_A348ClinicaFacebook[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A348ClinicaFacebook", A348ClinicaFacebook);
            A347ClinicaWhatsApp = H005C2_A347ClinicaWhatsApp[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A347ClinicaWhatsApp", A347ClinicaWhatsApp);
            A346ClinicaTelefono = H005C2_A346ClinicaTelefono[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A346ClinicaTelefono", A346ClinicaTelefono);
            A345ClinicaLogoPago = H005C2_A345ClinicaLogoPago[0] ;
            n345ClinicaLogoPago = H005C2_n345ClinicaLogoPago[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A345ClinicaLogoPago", A345ClinicaLogoPago);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
            A40004ClinicaLogoPago_GXI = H005C2_A40004ClinicaLogoPago_GXI[0] ;
            n40004ClinicaLogoPago_GXI = H005C2_n40004ClinicaLogoPago_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
            A344ClinicaLogoBoleta = H005C2_A344ClinicaLogoBoleta[0] ;
            n344ClinicaLogoBoleta = H005C2_n344ClinicaLogoBoleta[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A344ClinicaLogoBoleta", A344ClinicaLogoBoleta);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
            A40003ClinicaLogoBoleta_GXI = H005C2_A40003ClinicaLogoBoleta_GXI[0] ;
            n40003ClinicaLogoBoleta_GXI = H005C2_n40003ClinicaLogoBoleta_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
            A343ClinicaLogoFactura = H005C2_A343ClinicaLogoFactura[0] ;
            n343ClinicaLogoFactura = H005C2_n343ClinicaLogoFactura[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A343ClinicaLogoFactura", A343ClinicaLogoFactura);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
            A40002ClinicaLogoFactura_GXI = H005C2_A40002ClinicaLogoFactura_GXI[0] ;
            n40002ClinicaLogoFactura_GXI = H005C2_n40002ClinicaLogoFactura_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
            A342ClinicaLogoHeader = H005C2_A342ClinicaLogoHeader[0] ;
            n342ClinicaLogoHeader = H005C2_n342ClinicaLogoHeader[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A342ClinicaLogoHeader", A342ClinicaLogoHeader);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
            A40001ClinicaLogoHeader_GXI = H005C2_A40001ClinicaLogoHeader_GXI[0] ;
            n40001ClinicaLogoHeader_GXI = H005C2_n40001ClinicaLogoHeader_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
            A117ClinicaLogo = H005C2_A117ClinicaLogo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A117ClinicaLogo", A117ClinicaLogo);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
            A40000ClinicaLogo_GXI = H005C2_A40000ClinicaLogo_GXI[0] ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
            A341ClinicaMoneda = H005C2_A341ClinicaMoneda[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
            A340ClinicaCorreo = H005C2_A340ClinicaCorreo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A340ClinicaCorreo", A340ClinicaCorreo);
            A119ClinicaDireccionComercial = H005C2_A119ClinicaDireccionComercial[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A119ClinicaDireccionComercial", A119ClinicaDireccionComercial);
            A80ClinicaNombreAbreviado = H005C2_A80ClinicaNombreAbreviado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A80ClinicaNombreAbreviado", A80ClinicaNombreAbreviado);
            A116ClinicaNombreComercial = H005C2_A116ClinicaNombreComercial[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
            A118ClinicaRUC = H005C2_A118ClinicaRUC[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
            /* Execute user event: Load */
            e145C2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb5C0( ) ;
      }
   }

   public void send_integrity_lvl_hashes5C2( )
   {
   }

   public void before_start_formulas( )
   {
      AV15Pgmname = "ClinicaGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup5C0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e135C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA28ClinicaId"), ",", ".")) ;
         /* Read variables values. */
         A118ClinicaRUC = localUtil.ctol( httpContext.cgiGet( edtClinicaRUC_Internalname), ",", ".") ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
         A116ClinicaNombreComercial = httpContext.cgiGet( edtClinicaNombreComercial_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
         A80ClinicaNombreAbreviado = httpContext.cgiGet( edtClinicaNombreAbreviado_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A80ClinicaNombreAbreviado", A80ClinicaNombreAbreviado);
         A119ClinicaDireccionComercial = httpContext.cgiGet( edtClinicaDireccionComercial_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A119ClinicaDireccionComercial", A119ClinicaDireccionComercial);
         A340ClinicaCorreo = httpContext.cgiGet( edtClinicaCorreo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A340ClinicaCorreo", A340ClinicaCorreo);
         cmbClinicaMoneda.setValue( httpContext.cgiGet( cmbClinicaMoneda.getInternalname()) );
         A341ClinicaMoneda = (short)(GXutil.lval( httpContext.cgiGet( cmbClinicaMoneda.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
         A117ClinicaLogo = httpContext.cgiGet( imgClinicaLogo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A117ClinicaLogo", A117ClinicaLogo);
         A342ClinicaLogoHeader = httpContext.cgiGet( imgClinicaLogoHeader_Internalname) ;
         n342ClinicaLogoHeader = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A342ClinicaLogoHeader", A342ClinicaLogoHeader);
         A343ClinicaLogoFactura = httpContext.cgiGet( imgClinicaLogoFactura_Internalname) ;
         n343ClinicaLogoFactura = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A343ClinicaLogoFactura", A343ClinicaLogoFactura);
         A344ClinicaLogoBoleta = httpContext.cgiGet( imgClinicaLogoBoleta_Internalname) ;
         n344ClinicaLogoBoleta = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A344ClinicaLogoBoleta", A344ClinicaLogoBoleta);
         A345ClinicaLogoPago = httpContext.cgiGet( imgClinicaLogoPago_Internalname) ;
         n345ClinicaLogoPago = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A345ClinicaLogoPago", A345ClinicaLogoPago);
         A346ClinicaTelefono = httpContext.cgiGet( edtClinicaTelefono_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A346ClinicaTelefono", A346ClinicaTelefono);
         A347ClinicaWhatsApp = httpContext.cgiGet( edtClinicaWhatsApp_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A347ClinicaWhatsApp", A347ClinicaWhatsApp);
         A348ClinicaFacebook = httpContext.cgiGet( edtClinicaFacebook_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A348ClinicaFacebook", A348ClinicaFacebook);
         A349ClinicaTwiter = httpContext.cgiGet( edtClinicaTwiter_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A349ClinicaTwiter", A349ClinicaTwiter);
         A350ClinicaInstagram = httpContext.cgiGet( edtClinicaInstagram_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A350ClinicaInstagram", A350ClinicaInstagram);
         A351ClinicaLinkedin = httpContext.cgiGet( edtClinicaLinkedin_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A351ClinicaLinkedin", A351ClinicaLinkedin);
         cmbClinicaTiempoDeCita.setValue( httpContext.cgiGet( cmbClinicaTiempoDeCita.getInternalname()) );
         A120ClinicaTiempoDeCita = (byte)(GXutil.lval( httpContext.cgiGet( cmbClinicaTiempoDeCita.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
         cmbClinicaEstado.setValue( httpContext.cgiGet( cmbClinicaEstado.getInternalname()) );
         A121ClinicaEstado = httpContext.cgiGet( cmbClinicaEstado.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A121ClinicaEstado", A121ClinicaEstado);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"ClinicaGeneral");
         A348ClinicaFacebook = httpContext.cgiGet( edtClinicaFacebook_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A348ClinicaFacebook", A348ClinicaFacebook);
         forbiddenHiddens.add("ClinicaFacebook", GXutil.rtrim( localUtil.format( A348ClinicaFacebook, "")));
         A349ClinicaTwiter = httpContext.cgiGet( edtClinicaTwiter_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A349ClinicaTwiter", A349ClinicaTwiter);
         forbiddenHiddens.add("ClinicaTwiter", GXutil.rtrim( localUtil.format( A349ClinicaTwiter, "")));
         A350ClinicaInstagram = httpContext.cgiGet( edtClinicaInstagram_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A350ClinicaInstagram", A350ClinicaInstagram);
         forbiddenHiddens.add("ClinicaInstagram", GXutil.rtrim( localUtil.format( A350ClinicaInstagram, "")));
         A351ClinicaLinkedin = httpContext.cgiGet( edtClinicaLinkedin_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A351ClinicaLinkedin", A351ClinicaLinkedin);
         forbiddenHiddens.add("ClinicaLinkedin", GXutil.rtrim( localUtil.format( A351ClinicaLinkedin, "")));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("clinicageneral:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
      e135C2 ();
      if (returnInSub) return;
   }

   public void e135C2( )
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

   protected void e145C2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtClinicaFacebook_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaFacebook_Internalname, "Linktarget", edtClinicaFacebook_Linktarget, true);
      edtClinicaFacebook_Link = A348ClinicaFacebook ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaFacebook_Internalname, "Link", edtClinicaFacebook_Link, true);
      edtClinicaTwiter_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaTwiter_Internalname, "Linktarget", edtClinicaTwiter_Linktarget, true);
      edtClinicaTwiter_Link = A349ClinicaTwiter ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaTwiter_Internalname, "Link", edtClinicaTwiter_Link, true);
      edtClinicaInstagram_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaInstagram_Internalname, "Linktarget", edtClinicaInstagram_Linktarget, true);
      edtClinicaInstagram_Link = A350ClinicaInstagram ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaInstagram_Internalname, "Link", edtClinicaInstagram_Link, true);
      edtClinicaLinkedin_Linktarget = "_blank" ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaLinkedin_Internalname, "Linktarget", edtClinicaLinkedin_Linktarget, true);
      edtClinicaLinkedin_Link = A351ClinicaLinkedin ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtClinicaLinkedin_Internalname, "Link", edtClinicaLinkedin_Link, true);
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Update", GXv_boolean3) ;
      clinicageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Delete", GXv_boolean3) ;
      clinicageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Clinica" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A28ClinicaId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
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
      pa5C2( ) ;
      ws5C2( ) ;
      we5C2( ) ;
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
      sCtrlA28ClinicaId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa5C2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "clinicageneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa5C2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A28ClinicaId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      }
      wcpOA28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA28ClinicaId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A28ClinicaId != wcpOA28ClinicaId ) ) )
      {
         setjustcreated();
      }
      wcpOA28ClinicaId = A28ClinicaId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA28ClinicaId = httpContext.cgiGet( sPrefix+"A28ClinicaId_CTRL") ;
      if ( GXutil.len( sCtrlA28ClinicaId) > 0 )
      {
         A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA28ClinicaId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      }
      else
      {
         A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A28ClinicaId_PARM"), ",", ".")) ;
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
      pa5C2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws5C2( ) ;
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
      ws5C2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A28ClinicaId_PARM", GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA28ClinicaId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A28ClinicaId_CTRL", GXutil.rtrim( sCtrlA28ClinicaId));
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
      we5C2( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323550", true, true);
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
      httpContext.AddJavascriptSource("clinicageneral.js", "?20225110323551", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtClinicaId_Internalname = sPrefix+"CLINICAID" ;
      edtClinicaRUC_Internalname = sPrefix+"CLINICARUC" ;
      edtClinicaNombreComercial_Internalname = sPrefix+"CLINICANOMBRECOMERCIAL" ;
      edtClinicaNombreAbreviado_Internalname = sPrefix+"CLINICANOMBREABREVIADO" ;
      edtClinicaDireccionComercial_Internalname = sPrefix+"CLINICADIRECCIONCOMERCIAL" ;
      edtClinicaCorreo_Internalname = sPrefix+"CLINICACORREO" ;
      cmbClinicaMoneda.setInternalname( sPrefix+"CLINICAMONEDA" );
      imgClinicaLogo_Internalname = sPrefix+"CLINICALOGO" ;
      imgClinicaLogoHeader_Internalname = sPrefix+"CLINICALOGOHEADER" ;
      imgClinicaLogoFactura_Internalname = sPrefix+"CLINICALOGOFACTURA" ;
      imgClinicaLogoBoleta_Internalname = sPrefix+"CLINICALOGOBOLETA" ;
      imgClinicaLogoPago_Internalname = sPrefix+"CLINICALOGOPAGO" ;
      edtClinicaTelefono_Internalname = sPrefix+"CLINICATELEFONO" ;
      edtClinicaWhatsApp_Internalname = sPrefix+"CLINICAWHATSAPP" ;
      edtClinicaFacebook_Internalname = sPrefix+"CLINICAFACEBOOK" ;
      edtClinicaTwiter_Internalname = sPrefix+"CLINICATWITER" ;
      edtClinicaInstagram_Internalname = sPrefix+"CLINICAINSTAGRAM" ;
      edtClinicaLinkedin_Internalname = sPrefix+"CLINICALINKEDIN" ;
      cmbClinicaTiempoDeCita.setInternalname( sPrefix+"CLINICATIEMPODECITA" );
      cmbClinicaEstado.setInternalname( sPrefix+"CLINICAESTADO" );
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
      cmbClinicaEstado.setJsonclick( "" );
      cmbClinicaEstado.setEnabled( 0 );
      cmbClinicaTiempoDeCita.setJsonclick( "" );
      cmbClinicaTiempoDeCita.setEnabled( 0 );
      edtClinicaLinkedin_Jsonclick = "" ;
      edtClinicaLinkedin_Linktarget = "" ;
      edtClinicaLinkedin_Link = "" ;
      edtClinicaLinkedin_Enabled = 0 ;
      edtClinicaInstagram_Jsonclick = "" ;
      edtClinicaInstagram_Linktarget = "" ;
      edtClinicaInstagram_Link = "" ;
      edtClinicaInstagram_Enabled = 0 ;
      edtClinicaTwiter_Jsonclick = "" ;
      edtClinicaTwiter_Linktarget = "" ;
      edtClinicaTwiter_Link = "" ;
      edtClinicaTwiter_Enabled = 0 ;
      edtClinicaFacebook_Jsonclick = "" ;
      edtClinicaFacebook_Linktarget = "" ;
      edtClinicaFacebook_Link = "" ;
      edtClinicaFacebook_Enabled = 0 ;
      edtClinicaWhatsApp_Jsonclick = "" ;
      edtClinicaWhatsApp_Enabled = 0 ;
      edtClinicaTelefono_Jsonclick = "" ;
      edtClinicaTelefono_Enabled = 0 ;
      cmbClinicaMoneda.setJsonclick( "" );
      cmbClinicaMoneda.setEnabled( 0 );
      edtClinicaCorreo_Jsonclick = "" ;
      edtClinicaCorreo_Enabled = 0 ;
      edtClinicaDireccionComercial_Enabled = 0 ;
      edtClinicaNombreAbreviado_Jsonclick = "" ;
      edtClinicaNombreAbreviado_Enabled = 0 ;
      edtClinicaNombreComercial_Jsonclick = "" ;
      edtClinicaNombreComercial_Enabled = 0 ;
      edtClinicaRUC_Jsonclick = "" ;
      edtClinicaRUC_Enabled = 0 ;
      edtClinicaId_Jsonclick = "" ;
      edtClinicaId_Enabled = 0 ;
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
      cmbClinicaMoneda.setName( "CLINICAMONEDA" );
      cmbClinicaMoneda.setWebtags( "" );
      cmbClinicaMoneda.addItem("1", "Soles", (short)(0));
      cmbClinicaMoneda.addItem("2", "Dólares", (short)(0));
      cmbClinicaMoneda.addItem("3", "Euros", (short)(0));
      if ( cmbClinicaMoneda.getItemCount() > 0 )
      {
      }
      cmbClinicaTiempoDeCita.setName( "CLINICATIEMPODECITA" );
      cmbClinicaTiempoDeCita.setWebtags( "" );
      cmbClinicaTiempoDeCita.addItem("30", "30 minutos", (short)(0));
      cmbClinicaTiempoDeCita.addItem("60", "1 hora", (short)(0));
      if ( cmbClinicaTiempoDeCita.getItemCount() > 0 )
      {
      }
      cmbClinicaEstado.setName( "CLINICAESTADO" );
      cmbClinicaEstado.setWebtags( "" );
      cmbClinicaEstado.addItem("A", "Activo", (short)(0));
      cmbClinicaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbClinicaEstado.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'},{av:'A348ClinicaFacebook',fld:'CLINICAFACEBOOK',pic:''},{av:'A349ClinicaTwiter',fld:'CLINICATWITER',pic:''},{av:'A350ClinicaInstagram',fld:'CLINICAINSTAGRAM',pic:''},{av:'A351ClinicaLinkedin',fld:'CLINICALINKEDIN',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e115C1',iparms:[{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e125C1',iparms:[{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_CLINICAID","{handler:'valid_Clinicaid',iparms:[]");
      setEventMetadata("VALID_CLINICAID",",oparms:[]}");
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
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      GX_FocusControl = "" ;
      A116ClinicaNombreComercial = "" ;
      A80ClinicaNombreAbreviado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A119ClinicaDireccionComercial = "" ;
      A340ClinicaCorreo = "" ;
      A117ClinicaLogo = "" ;
      A40000ClinicaLogo_GXI = "" ;
      sImgUrl = "" ;
      A342ClinicaLogoHeader = "" ;
      A40001ClinicaLogoHeader_GXI = "" ;
      A343ClinicaLogoFactura = "" ;
      A40002ClinicaLogoFactura_GXI = "" ;
      A344ClinicaLogoBoleta = "" ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      A345ClinicaLogoPago = "" ;
      A40004ClinicaLogoPago_GXI = "" ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A121ClinicaEstado = "" ;
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
      H005C2_A28ClinicaId = new short[1] ;
      H005C2_A121ClinicaEstado = new String[] {""} ;
      H005C2_A120ClinicaTiempoDeCita = new byte[1] ;
      H005C2_A351ClinicaLinkedin = new String[] {""} ;
      H005C2_A350ClinicaInstagram = new String[] {""} ;
      H005C2_A349ClinicaTwiter = new String[] {""} ;
      H005C2_A348ClinicaFacebook = new String[] {""} ;
      H005C2_A347ClinicaWhatsApp = new String[] {""} ;
      H005C2_A346ClinicaTelefono = new String[] {""} ;
      H005C2_A345ClinicaLogoPago = new String[] {""} ;
      H005C2_n345ClinicaLogoPago = new boolean[] {false} ;
      H005C2_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      H005C2_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      H005C2_A344ClinicaLogoBoleta = new String[] {""} ;
      H005C2_n344ClinicaLogoBoleta = new boolean[] {false} ;
      H005C2_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      H005C2_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      H005C2_A343ClinicaLogoFactura = new String[] {""} ;
      H005C2_n343ClinicaLogoFactura = new boolean[] {false} ;
      H005C2_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      H005C2_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      H005C2_A342ClinicaLogoHeader = new String[] {""} ;
      H005C2_n342ClinicaLogoHeader = new boolean[] {false} ;
      H005C2_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      H005C2_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      H005C2_A117ClinicaLogo = new String[] {""} ;
      H005C2_A40000ClinicaLogo_GXI = new String[] {""} ;
      H005C2_A341ClinicaMoneda = new short[1] ;
      H005C2_A340ClinicaCorreo = new String[] {""} ;
      H005C2_A119ClinicaDireccionComercial = new String[] {""} ;
      H005C2_A80ClinicaNombreAbreviado = new String[] {""} ;
      H005C2_A116ClinicaNombreComercial = new String[] {""} ;
      H005C2_A118ClinicaRUC = new long[1] ;
      hsh = "" ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA28ClinicaId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.clinicageneral__default(),
         new Object[] {
             new Object[] {
            H005C2_A28ClinicaId, H005C2_A121ClinicaEstado, H005C2_A120ClinicaTiempoDeCita, H005C2_A351ClinicaLinkedin, H005C2_A350ClinicaInstagram, H005C2_A349ClinicaTwiter, H005C2_A348ClinicaFacebook, H005C2_A347ClinicaWhatsApp, H005C2_A346ClinicaTelefono, H005C2_A345ClinicaLogoPago,
            H005C2_n345ClinicaLogoPago, H005C2_A40004ClinicaLogoPago_GXI, H005C2_n40004ClinicaLogoPago_GXI, H005C2_A344ClinicaLogoBoleta, H005C2_n344ClinicaLogoBoleta, H005C2_A40003ClinicaLogoBoleta_GXI, H005C2_n40003ClinicaLogoBoleta_GXI, H005C2_A343ClinicaLogoFactura, H005C2_n343ClinicaLogoFactura, H005C2_A40002ClinicaLogoFactura_GXI,
            H005C2_n40002ClinicaLogoFactura_GXI, H005C2_A342ClinicaLogoHeader, H005C2_n342ClinicaLogoHeader, H005C2_A40001ClinicaLogoHeader_GXI, H005C2_n40001ClinicaLogoHeader_GXI, H005C2_A117ClinicaLogo, H005C2_A40000ClinicaLogo_GXI, H005C2_A341ClinicaMoneda, H005C2_A340ClinicaCorreo, H005C2_A119ClinicaDireccionComercial,
            H005C2_A80ClinicaNombreAbreviado, H005C2_A116ClinicaNombreComercial, H005C2_A118ClinicaRUC
            }
         }
      );
      AV15Pgmname = "ClinicaGeneral" ;
      /* GeneXus formulas. */
      AV15Pgmname = "ClinicaGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A120ClinicaTiempoDeCita ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA28ClinicaId ;
   private short A28ClinicaId ;
   private short wbEnd ;
   private short wbStart ;
   private short A341ClinicaMoneda ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int edtClinicaId_Enabled ;
   private int edtClinicaRUC_Enabled ;
   private int edtClinicaNombreComercial_Enabled ;
   private int edtClinicaNombreAbreviado_Enabled ;
   private int edtClinicaDireccionComercial_Enabled ;
   private int edtClinicaCorreo_Enabled ;
   private int edtClinicaTelefono_Enabled ;
   private int edtClinicaWhatsApp_Enabled ;
   private int edtClinicaFacebook_Enabled ;
   private int edtClinicaTwiter_Enabled ;
   private int edtClinicaInstagram_Enabled ;
   private int edtClinicaLinkedin_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int idxLst ;
   private long A118ClinicaRUC ;
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
   private String edtClinicaId_Internalname ;
   private String edtClinicaId_Jsonclick ;
   private String edtClinicaRUC_Internalname ;
   private String edtClinicaRUC_Jsonclick ;
   private String edtClinicaNombreComercial_Internalname ;
   private String edtClinicaNombreComercial_Jsonclick ;
   private String edtClinicaNombreAbreviado_Internalname ;
   private String edtClinicaNombreAbreviado_Jsonclick ;
   private String edtClinicaDireccionComercial_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtClinicaCorreo_Internalname ;
   private String edtClinicaCorreo_Jsonclick ;
   private String imgClinicaLogo_Internalname ;
   private String sImgUrl ;
   private String imgClinicaLogoHeader_Internalname ;
   private String imgClinicaLogoFactura_Internalname ;
   private String imgClinicaLogoBoleta_Internalname ;
   private String imgClinicaLogoPago_Internalname ;
   private String edtClinicaTelefono_Internalname ;
   private String A346ClinicaTelefono ;
   private String edtClinicaTelefono_Jsonclick ;
   private String edtClinicaWhatsApp_Internalname ;
   private String A347ClinicaWhatsApp ;
   private String edtClinicaWhatsApp_Jsonclick ;
   private String edtClinicaFacebook_Internalname ;
   private String edtClinicaFacebook_Link ;
   private String edtClinicaFacebook_Linktarget ;
   private String edtClinicaFacebook_Jsonclick ;
   private String edtClinicaTwiter_Internalname ;
   private String edtClinicaTwiter_Link ;
   private String edtClinicaTwiter_Linktarget ;
   private String edtClinicaTwiter_Jsonclick ;
   private String edtClinicaInstagram_Internalname ;
   private String edtClinicaInstagram_Link ;
   private String edtClinicaInstagram_Linktarget ;
   private String edtClinicaInstagram_Jsonclick ;
   private String edtClinicaLinkedin_Internalname ;
   private String edtClinicaLinkedin_Link ;
   private String edtClinicaLinkedin_Linktarget ;
   private String edtClinicaLinkedin_Jsonclick ;
   private String A121ClinicaEstado ;
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
   private String sCtrlA28ClinicaId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A117ClinicaLogo_IsBlob ;
   private boolean A342ClinicaLogoHeader_IsBlob ;
   private boolean A343ClinicaLogoFactura_IsBlob ;
   private boolean A344ClinicaLogoBoleta_IsBlob ;
   private boolean A345ClinicaLogoPago_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n345ClinicaLogoPago ;
   private boolean n40004ClinicaLogoPago_GXI ;
   private boolean n344ClinicaLogoBoleta ;
   private boolean n40003ClinicaLogoBoleta_GXI ;
   private boolean n343ClinicaLogoFactura ;
   private boolean n40002ClinicaLogoFactura_GXI ;
   private boolean n342ClinicaLogoHeader ;
   private boolean n40001ClinicaLogoHeader_GXI ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A348ClinicaFacebook ;
   private String A349ClinicaTwiter ;
   private String A350ClinicaInstagram ;
   private String A351ClinicaLinkedin ;
   private String A116ClinicaNombreComercial ;
   private String A80ClinicaNombreAbreviado ;
   private String A119ClinicaDireccionComercial ;
   private String A340ClinicaCorreo ;
   private String A40000ClinicaLogo_GXI ;
   private String A40001ClinicaLogoHeader_GXI ;
   private String A40002ClinicaLogoFactura_GXI ;
   private String A40003ClinicaLogoBoleta_GXI ;
   private String A40004ClinicaLogoPago_GXI ;
   private String A117ClinicaLogo ;
   private String A342ClinicaLogoHeader ;
   private String A343ClinicaLogoFactura ;
   private String A344ClinicaLogoBoleta ;
   private String A345ClinicaLogoPago ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbClinicaMoneda ;
   private HTMLChoice cmbClinicaTiempoDeCita ;
   private HTMLChoice cmbClinicaEstado ;
   private IDataStoreProvider pr_default ;
   private short[] H005C2_A28ClinicaId ;
   private String[] H005C2_A121ClinicaEstado ;
   private byte[] H005C2_A120ClinicaTiempoDeCita ;
   private String[] H005C2_A351ClinicaLinkedin ;
   private String[] H005C2_A350ClinicaInstagram ;
   private String[] H005C2_A349ClinicaTwiter ;
   private String[] H005C2_A348ClinicaFacebook ;
   private String[] H005C2_A347ClinicaWhatsApp ;
   private String[] H005C2_A346ClinicaTelefono ;
   private String[] H005C2_A345ClinicaLogoPago ;
   private boolean[] H005C2_n345ClinicaLogoPago ;
   private String[] H005C2_A40004ClinicaLogoPago_GXI ;
   private boolean[] H005C2_n40004ClinicaLogoPago_GXI ;
   private String[] H005C2_A344ClinicaLogoBoleta ;
   private boolean[] H005C2_n344ClinicaLogoBoleta ;
   private String[] H005C2_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] H005C2_n40003ClinicaLogoBoleta_GXI ;
   private String[] H005C2_A343ClinicaLogoFactura ;
   private boolean[] H005C2_n343ClinicaLogoFactura ;
   private String[] H005C2_A40002ClinicaLogoFactura_GXI ;
   private boolean[] H005C2_n40002ClinicaLogoFactura_GXI ;
   private String[] H005C2_A342ClinicaLogoHeader ;
   private boolean[] H005C2_n342ClinicaLogoHeader ;
   private String[] H005C2_A40001ClinicaLogoHeader_GXI ;
   private boolean[] H005C2_n40001ClinicaLogoHeader_GXI ;
   private String[] H005C2_A117ClinicaLogo ;
   private String[] H005C2_A40000ClinicaLogo_GXI ;
   private short[] H005C2_A341ClinicaMoneda ;
   private String[] H005C2_A340ClinicaCorreo ;
   private String[] H005C2_A119ClinicaDireccionComercial ;
   private String[] H005C2_A80ClinicaNombreAbreviado ;
   private String[] H005C2_A116ClinicaNombreComercial ;
   private long[] H005C2_A118ClinicaRUC ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class clinicageneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H005C2", "SELECT [ClinicaId], [ClinicaEstado], [ClinicaTiempoDeCita], [ClinicaLinkedin], [ClinicaInstagram], [ClinicaTwiter], [ClinicaFacebook], [ClinicaWhatsApp], [ClinicaTelefono], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaMoneda], [ClinicaCorreo], [ClinicaDireccionComercial], [ClinicaNombreAbreviado], [ClinicaNombreComercial], [ClinicaRUC] FROM [Clinica] WHERE [ClinicaId] = ? ORDER BY [ClinicaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 15);
               ((String[]) buf[8])[0] = rslt.getString(9, 12);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getMultimediaFile(18, rslt.getVarchar(19));
               ((String[]) buf[26])[0] = rslt.getMultimediaUri(19);
               ((short[]) buf[27])[0] = rslt.getShort(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((String[]) buf[31])[0] = rslt.getVarchar(24);
               ((long[]) buf[32])[0] = rslt.getLong(25);
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

