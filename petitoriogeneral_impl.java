package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class petitoriogeneral_impl extends GXWebComponent
{
   public petitoriogeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public petitoriogeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitoriogeneral_impl.class ));
   }

   public petitoriogeneral_impl( int remoteHandle ,
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
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "PetitorioId") ;
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
               A25PetitorioId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A25PetitorioId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "PetitorioId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "PetitorioId") ;
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
         pa3P2( ) ;
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
         httpContext.writeValue( "Petitorio General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325781", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.petitoriogeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A25PetitorioId,4,0))}, new String[] {"PetitorioId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA25PetitorioId", GXutil.ltrim( localUtil.ntoc( wcpOA25PetitorioId, (byte)(4), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm3P2( )
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
      return "PetitorioGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Petitorio General" ;
   }

   public void wb3P0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.petitoriogeneral");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioId_Internalname, GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPetitorioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPetitorioId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDrogueriaNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtDrogueriaNombre_Internalname, "Drogueria Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDrogueriaNombre_Internalname, A141DrogueriaNombre, GXutil.rtrim( localUtil.format( A141DrogueriaNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtDrogueriaNombre_Link, "", "", "", edtDrogueriaNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtDrogueriaNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioPrincipioActivo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioPrincipioActivo_Internalname, "Principio Activo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPetitorioPrincipioActivo_Internalname, A262PetitorioPrincipioActivo, "", "", (short)(0), 1, edtPetitorioPrincipioActivo_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioProducto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioProducto_Internalname, "Producto", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioProducto_Internalname, A263PetitorioProducto, GXutil.rtrim( localUtil.format( A263PetitorioProducto, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioProducto_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPetitorioProducto_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioCategId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioCategId_Internalname, "Petitorio Categ Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioCategId_Internalname, GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPetitorioCategId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioCategId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPetitorioCategId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioSubCategNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioSubCategNombre_Internalname, "Sub Categoría", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPetitorioSubCategNombre_Internalname, A265PetitorioSubCategNombre, edtPetitorioSubCategNombre_Link, "", (short)(0), 1, edtPetitorioSubCategNombre_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioConcentracion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioConcentracion_Internalname, "Concentracion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioConcentracion_Internalname, A260PetitorioConcentracion, GXutil.rtrim( localUtil.format( A260PetitorioConcentracion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioConcentracion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPetitorioConcentracion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFormaFarmaceuticaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtFormaFarmaceuticaId_Internalname, "Forma Farmaceutica", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtFormaFarmaceuticaId_Internalname, GXutil.ltrim( localUtil.ntoc( A39FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtFormaFarmaceuticaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFormaFarmaceuticaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtFormaFarmaceuticaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioPresentacion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioPresentacion_Internalname, "Presentacion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioPresentacion_Internalname, A261PetitorioPresentacion, GXutil.rtrim( localUtil.format( A261PetitorioPresentacion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioPresentacion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPetitorioPresentacion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioPrecio_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioPrecio_Internalname, "Precio", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioPrecio_Internalname, GXutil.ltrim( localUtil.ntoc( A264PetitorioPrecio, (byte)(7), (byte)(2), ",", "")), GXutil.ltrim( ((edtPetitorioPrecio_Enabled!=0) ? localUtil.format( A264PetitorioPrecio, "ZZZ9.99") : localUtil.format( A264PetitorioPrecio, "ZZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioPrecio_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPetitorioPrecio_Enabled, 0, "text", "", 7, "chr", 1, "row", 7, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PetitorioGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e113p1_client"+"'", TempTags, "", 2, "HLP_PetitorioGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e123p1_client"+"'", TempTags, "", 2, "HLP_PetitorioGeneral.htm");
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

   public void start3P2( )
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
            Form.getMeta().addItem("description", "Petitorio General", (short)(0)) ;
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
            strup3P0( ) ;
         }
      }
   }

   public void ws3P2( )
   {
      start3P2( ) ;
      evt3P2( ) ;
   }

   public void evt3P2( )
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
                              strup3P0( ) ;
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
                              strup3P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e133P2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3P0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e143P2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup3P0( ) ;
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
                              strup3P0( ) ;
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

   public void we3P2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm3P2( ) ;
         }
      }
   }

   public void pa3P2( )
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf3P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV19Pgmname = "PetitorioGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf3P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H003P2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A25PetitorioId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A36DrogueriaId = H003P2_A36DrogueriaId[0] ;
            A48PetitorioSubCategId = H003P2_A48PetitorioSubCategId[0] ;
            A264PetitorioPrecio = H003P2_A264PetitorioPrecio[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A264PetitorioPrecio", GXutil.ltrimstr( A264PetitorioPrecio, 7, 2));
            A261PetitorioPresentacion = H003P2_A261PetitorioPresentacion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A261PetitorioPresentacion", A261PetitorioPresentacion);
            A39FormaFarmaceuticaId = H003P2_A39FormaFarmaceuticaId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
            A260PetitorioConcentracion = H003P2_A260PetitorioConcentracion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A260PetitorioConcentracion", A260PetitorioConcentracion);
            A265PetitorioSubCategNombre = H003P2_A265PetitorioSubCategNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A265PetitorioSubCategNombre", A265PetitorioSubCategNombre);
            A49PetitorioCategId = H003P2_A49PetitorioCategId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
            A263PetitorioProducto = H003P2_A263PetitorioProducto[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263PetitorioProducto", A263PetitorioProducto);
            A262PetitorioPrincipioActivo = H003P2_A262PetitorioPrincipioActivo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A262PetitorioPrincipioActivo", A262PetitorioPrincipioActivo);
            A141DrogueriaNombre = H003P2_A141DrogueriaNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A141DrogueriaNombre", A141DrogueriaNombre);
            A141DrogueriaNombre = H003P2_A141DrogueriaNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A141DrogueriaNombre", A141DrogueriaNombre);
            A265PetitorioSubCategNombre = H003P2_A265PetitorioSubCategNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A265PetitorioSubCategNombre", A265PetitorioSubCategNombre);
            A49PetitorioCategId = H003P2_A49PetitorioCategId[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
            /* Execute user event: Load */
            e143P2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb3P0( ) ;
      }
   }

   public void send_integrity_lvl_hashes3P2( )
   {
   }

   public void before_start_formulas( )
   {
      AV19Pgmname = "PetitorioGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup3P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e133P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA25PetitorioId"), ",", ".")) ;
         /* Read variables values. */
         A141DrogueriaNombre = httpContext.cgiGet( edtDrogueriaNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A141DrogueriaNombre", A141DrogueriaNombre);
         A262PetitorioPrincipioActivo = httpContext.cgiGet( edtPetitorioPrincipioActivo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A262PetitorioPrincipioActivo", A262PetitorioPrincipioActivo);
         A263PetitorioProducto = httpContext.cgiGet( edtPetitorioProducto_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A263PetitorioProducto", A263PetitorioProducto);
         A49PetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioCategId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
         A265PetitorioSubCategNombre = httpContext.cgiGet( edtPetitorioSubCategNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A265PetitorioSubCategNombre", A265PetitorioSubCategNombre);
         A260PetitorioConcentracion = httpContext.cgiGet( edtPetitorioConcentracion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A260PetitorioConcentracion", A260PetitorioConcentracion);
         A39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( edtFormaFarmaceuticaId_Internalname), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
         A261PetitorioPresentacion = httpContext.cgiGet( edtPetitorioPresentacion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A261PetitorioPresentacion", A261PetitorioPresentacion);
         A264PetitorioPrecio = localUtil.ctond( httpContext.cgiGet( edtPetitorioPrecio_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A264PetitorioPrecio", GXutil.ltrimstr( A264PetitorioPrecio, 7, 2));
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
      e133P2 ();
      if (returnInSub) return;
   }

   public void e133P2( )
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

   protected void e143P2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV14TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria", GXv_boolean3) ;
      petitoriogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV14TempBoolean = GXt_boolean2 ;
      if ( AV14TempBoolean )
      {
         edtDrogueriaNombre_Link = formatLink("com.projectthani.drogueriaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A36DrogueriaId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"DrogueriaId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtDrogueriaNombre_Internalname, "Link", edtDrogueriaNombre_Link, true);
      }
      GXt_boolean2 = AV14TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioSubCateg", GXv_boolean3) ;
      petitoriogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV14TempBoolean = GXt_boolean2 ;
      if ( AV14TempBoolean )
      {
         edtPetitorioSubCategNombre_Link = formatLink("com.projectthani.petitoriosubcategview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A48PetitorioSubCategId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PetitorioSubCategId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPetitorioSubCategNombre_Internalname, "Link", edtPetitorioSubCategNombre_Link, true);
      }
      GXt_boolean2 = AV14TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Update", GXv_boolean3) ;
      petitoriogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV14TempBoolean = GXt_boolean2 ;
      if ( ! ( AV14TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV14TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Delete", GXv_boolean3) ;
      petitoriogeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV14TempBoolean = GXt_boolean2 ;
      if ( ! ( AV14TempBoolean ) )
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV19Pgmname );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( false );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV11HTTPRequest.getScriptName()+"?"+AV11HTTPRequest.getQuerystring() );
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Petitorio" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A25PetitorioId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
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
      pa3P2( ) ;
      ws3P2( ) ;
      we3P2( ) ;
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
      sCtrlA25PetitorioId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa3P2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "petitoriogeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa3P2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A25PetitorioId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
      }
      wcpOA25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA25PetitorioId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A25PetitorioId != wcpOA25PetitorioId ) ) )
      {
         setjustcreated();
      }
      wcpOA25PetitorioId = A25PetitorioId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA25PetitorioId = httpContext.cgiGet( sPrefix+"A25PetitorioId_CTRL") ;
      if ( GXutil.len( sCtrlA25PetitorioId) > 0 )
      {
         A25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA25PetitorioId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
      }
      else
      {
         A25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A25PetitorioId_PARM"), ",", ".")) ;
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
      pa3P2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws3P2( ) ;
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
      ws3P2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A25PetitorioId_PARM", GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA25PetitorioId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A25PetitorioId_CTRL", GXutil.rtrim( sCtrlA25PetitorioId));
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
      we3P2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325818", true, true);
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
      httpContext.AddJavascriptSource("petitoriogeneral.js", "?20225110325818", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPetitorioId_Internalname = sPrefix+"PETITORIOID" ;
      edtDrogueriaNombre_Internalname = sPrefix+"DROGUERIANOMBRE" ;
      edtPetitorioPrincipioActivo_Internalname = sPrefix+"PETITORIOPRINCIPIOACTIVO" ;
      edtPetitorioProducto_Internalname = sPrefix+"PETITORIOPRODUCTO" ;
      edtPetitorioCategId_Internalname = sPrefix+"PETITORIOCATEGID" ;
      edtPetitorioSubCategNombre_Internalname = sPrefix+"PETITORIOSUBCATEGNOMBRE" ;
      edtPetitorioConcentracion_Internalname = sPrefix+"PETITORIOCONCENTRACION" ;
      edtFormaFarmaceuticaId_Internalname = sPrefix+"FORMAFARMACEUTICAID" ;
      edtPetitorioPresentacion_Internalname = sPrefix+"PETITORIOPRESENTACION" ;
      edtPetitorioPrecio_Internalname = sPrefix+"PETITORIOPRECIO" ;
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
      edtPetitorioPrecio_Jsonclick = "" ;
      edtPetitorioPrecio_Enabled = 0 ;
      edtPetitorioPresentacion_Jsonclick = "" ;
      edtPetitorioPresentacion_Enabled = 0 ;
      edtFormaFarmaceuticaId_Jsonclick = "" ;
      edtFormaFarmaceuticaId_Enabled = 0 ;
      edtPetitorioConcentracion_Jsonclick = "" ;
      edtPetitorioConcentracion_Enabled = 0 ;
      edtPetitorioSubCategNombre_Link = "" ;
      edtPetitorioSubCategNombre_Enabled = 0 ;
      edtPetitorioCategId_Jsonclick = "" ;
      edtPetitorioCategId_Enabled = 0 ;
      edtPetitorioProducto_Jsonclick = "" ;
      edtPetitorioProducto_Enabled = 0 ;
      edtPetitorioPrincipioActivo_Enabled = 0 ;
      edtDrogueriaNombre_Jsonclick = "" ;
      edtDrogueriaNombre_Link = "" ;
      edtDrogueriaNombre_Enabled = 0 ;
      edtPetitorioId_Jsonclick = "" ;
      edtPetitorioId_Enabled = 0 ;
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
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e113P1',iparms:[{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e123P1',iparms:[{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_PETITORIOID","{handler:'valid_Petitorioid',iparms:[]");
      setEventMetadata("VALID_PETITORIOID",",oparms:[]}");
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
      A141DrogueriaNombre = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A262PetitorioPrincipioActivo = "" ;
      A263PetitorioProducto = "" ;
      A265PetitorioSubCategNombre = "" ;
      A260PetitorioConcentracion = "" ;
      A261PetitorioPresentacion = "" ;
      A264PetitorioPrecio = DecimalUtil.ZERO ;
      TempTags = "" ;
      bttBtnupdate_Jsonclick = "" ;
      bttBtndelete_Jsonclick = "" ;
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV19Pgmname = "" ;
      scmdbuf = "" ;
      H003P2_A25PetitorioId = new short[1] ;
      H003P2_A36DrogueriaId = new short[1] ;
      H003P2_A48PetitorioSubCategId = new short[1] ;
      H003P2_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H003P2_A261PetitorioPresentacion = new String[] {""} ;
      H003P2_A39FormaFarmaceuticaId = new short[1] ;
      H003P2_A260PetitorioConcentracion = new String[] {""} ;
      H003P2_A265PetitorioSubCategNombre = new String[] {""} ;
      H003P2_A49PetitorioCategId = new short[1] ;
      H003P2_A263PetitorioProducto = new String[] {""} ;
      H003P2_A262PetitorioPrincipioActivo = new String[] {""} ;
      H003P2_A141DrogueriaNombre = new String[] {""} ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA25PetitorioId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriogeneral__default(),
         new Object[] {
             new Object[] {
            H003P2_A25PetitorioId, H003P2_A36DrogueriaId, H003P2_A48PetitorioSubCategId, H003P2_A264PetitorioPrecio, H003P2_A261PetitorioPresentacion, H003P2_A39FormaFarmaceuticaId, H003P2_A260PetitorioConcentracion, H003P2_A265PetitorioSubCategNombre, H003P2_A49PetitorioCategId, H003P2_A263PetitorioProducto,
            H003P2_A262PetitorioPrincipioActivo, H003P2_A141DrogueriaNombre
            }
         }
      );
      AV19Pgmname = "PetitorioGeneral" ;
      /* GeneXus formulas. */
      AV19Pgmname = "PetitorioGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA25PetitorioId ;
   private short A25PetitorioId ;
   private short wbEnd ;
   private short wbStart ;
   private short A49PetitorioCategId ;
   private short A39FormaFarmaceuticaId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A36DrogueriaId ;
   private short A48PetitorioSubCategId ;
   private int edtPetitorioId_Enabled ;
   private int edtDrogueriaNombre_Enabled ;
   private int edtPetitorioPrincipioActivo_Enabled ;
   private int edtPetitorioProducto_Enabled ;
   private int edtPetitorioCategId_Enabled ;
   private int edtPetitorioSubCategNombre_Enabled ;
   private int edtPetitorioConcentracion_Enabled ;
   private int edtFormaFarmaceuticaId_Enabled ;
   private int edtPetitorioPresentacion_Enabled ;
   private int edtPetitorioPrecio_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int idxLst ;
   private java.math.BigDecimal A264PetitorioPrecio ;
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
   private String edtPetitorioId_Internalname ;
   private String edtPetitorioId_Jsonclick ;
   private String edtDrogueriaNombre_Internalname ;
   private String edtDrogueriaNombre_Link ;
   private String edtDrogueriaNombre_Jsonclick ;
   private String edtPetitorioPrincipioActivo_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtPetitorioProducto_Internalname ;
   private String edtPetitorioProducto_Jsonclick ;
   private String edtPetitorioCategId_Internalname ;
   private String edtPetitorioCategId_Jsonclick ;
   private String edtPetitorioSubCategNombre_Internalname ;
   private String edtPetitorioSubCategNombre_Link ;
   private String edtPetitorioConcentracion_Internalname ;
   private String edtPetitorioConcentracion_Jsonclick ;
   private String edtFormaFarmaceuticaId_Internalname ;
   private String edtFormaFarmaceuticaId_Jsonclick ;
   private String edtPetitorioPresentacion_Internalname ;
   private String edtPetitorioPresentacion_Jsonclick ;
   private String edtPetitorioPrecio_Internalname ;
   private String edtPetitorioPrecio_Jsonclick ;
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
   private String AV19Pgmname ;
   private String scmdbuf ;
   private String sCtrlA25PetitorioId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV14TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A141DrogueriaNombre ;
   private String A262PetitorioPrincipioActivo ;
   private String A263PetitorioProducto ;
   private String A265PetitorioSubCategNombre ;
   private String A260PetitorioConcentracion ;
   private String A261PetitorioPresentacion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private IDataStoreProvider pr_default ;
   private short[] H003P2_A25PetitorioId ;
   private short[] H003P2_A36DrogueriaId ;
   private short[] H003P2_A48PetitorioSubCategId ;
   private java.math.BigDecimal[] H003P2_A264PetitorioPrecio ;
   private String[] H003P2_A261PetitorioPresentacion ;
   private short[] H003P2_A39FormaFarmaceuticaId ;
   private String[] H003P2_A260PetitorioConcentracion ;
   private String[] H003P2_A265PetitorioSubCategNombre ;
   private short[] H003P2_A49PetitorioCategId ;
   private String[] H003P2_A263PetitorioProducto ;
   private String[] H003P2_A262PetitorioPrincipioActivo ;
   private String[] H003P2_A141DrogueriaNombre ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class petitoriogeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H003P2", "SELECT T1.[PetitorioId], T1.[DrogueriaId], T1.[PetitorioSubCategId], T1.[PetitorioPrecio], T1.[PetitorioPresentacion], T1.[FormaFarmaceuticaId], T1.[PetitorioConcentracion], T3.[PetitorioSubCategNombre], T3.[PetitorioCategId], T1.[PetitorioProducto], T1.[PetitorioPrincipioActivo], T2.[DrogueriaNombre] FROM (([Petitorio] T1 INNER JOIN [Drogueria] T2 ON T2.[DrogueriaId] = T1.[DrogueriaId]) INNER JOIN [PetitorioSubCateg] T3 ON T3.[PetitorioSubCategId] = T1.[PetitorioSubCategId]) WHERE T1.[PetitorioId] = ? ORDER BY T1.[PetitorioId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
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

