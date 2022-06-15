package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class recetamedicageneral_impl extends GXWebComponent
{
   public recetamedicageneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public recetamedicageneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recetamedicageneral_impl.class ));
   }

   public recetamedicageneral_impl( int remoteHandle ,
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
            gxfirstwebparm = httpContext.GetFirstPar( "RecetaMedicaId") ;
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
               A50RecetaMedicaId = (short)(GXutil.lval( httpContext.GetPar( "RecetaMedicaId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Short.valueOf(A50RecetaMedicaId)});
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
               gxfirstwebparm = httpContext.GetFirstPar( "RecetaMedicaId") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "RecetaMedicaId") ;
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
         pa4C2( ) ;
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
         httpContext.writeValue( "Receta Medica General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?202251103317", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.recetamedicageneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A50RecetaMedicaId,4,0))}, new String[] {"RecetaMedicaId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA50RecetaMedicaId", GXutil.ltrim( localUtil.ntoc( wcpOA50RecetaMedicaId, (byte)(4), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm4C2( )
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
      return "RecetaMedicaGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Receta Medica General" ;
   }

   public void wb4C0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.recetamedicageneral");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaMedicaId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaId_Internalname, "Medica Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A50RecetaMedicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtRecetaMedicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRecetaMedicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_RecetaMedicaGeneral.htm");
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
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaCode_Internalname, A64CitaCode, GXutil.rtrim( localUtil.format( A64CitaCode, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtCitaCode_Link, "", "", "", edtCitaCode_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtCitaCode_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMedicamentoCodigo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtMedicamentoCodigo_Internalname, "Medicamento Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtMedicamentoCodigo_Internalname, A229MedicamentoCodigo, GXutil.rtrim( localUtil.format( A229MedicamentoCodigo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtMedicamentoCodigo_Link, "", "", "", edtMedicamentoCodigo_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtMedicamentoCodigo_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMedicamentoNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtMedicamentoNombre_Internalname, "Medicamento Nombre", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtMedicamentoNombre_Internalname, A230MedicamentoNombre, GXutil.rtrim( localUtil.format( A230MedicamentoNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMedicamentoNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtMedicamentoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMedicamentoFormaFarm_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtMedicamentoFormaFarm_Internalname, "Medicamento Forma Farm", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtMedicamentoFormaFarm_Internalname, A231MedicamentoFormaFarm, GXutil.rtrim( localUtil.format( A231MedicamentoFormaFarm, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMedicamentoFormaFarm_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtMedicamentoFormaFarm_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaMedicaConcentracion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaConcentracion_Internalname, "Medica Concentracion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaConcentracion_Internalname, A268RecetaMedicaConcentracion, GXutil.rtrim( localUtil.format( A268RecetaMedicaConcentracion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaConcentracion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRecetaMedicaConcentracion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaMedicaCantidad_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaCantidad_Internalname, "Medica Cantidad", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A269RecetaMedicaCantidad, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtRecetaMedicaCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaCantidad_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRecetaMedicaCantidad_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaMedicaAtencion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaAtencion_Internalname, "Medica Atencion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaAtencion_Internalname, A273RecetaMedicaAtencion, GXutil.rtrim( localUtil.format( A273RecetaMedicaAtencion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaAtencion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRecetaMedicaAtencion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaMedicaArchivo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaArchivo_Internalname, "Medica Archivo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         edtRecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         edtRecetaMedicaArchivo_Filetype = "" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
         edtRecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
         if ( ! (GXutil.strcmp("", A270RecetaMedicaArchivo)==0) )
         {
            gxblobfileaux.setSource( A270RecetaMedicaArchivo );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtRecetaMedicaArchivo_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtRecetaMedicaArchivo_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A270RecetaMedicaArchivo = gxblobfileaux.getURI() ;
               n270RecetaMedicaArchivo = false ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
               edtRecetaMedicaArchivo_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
         }
         com.projectthani.GxWebStd.gx_blob_field( httpContext, edtRecetaMedicaArchivo_Internalname, GXutil.rtrim( A270RecetaMedicaArchivo), httpContext.getResourceRelative(A270RecetaMedicaArchivo), ((GXutil.strcmp("", edtRecetaMedicaArchivo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtRecetaMedicaArchivo_Filetype)==0) ? A270RecetaMedicaArchivo : edtRecetaMedicaArchivo_Filetype)) : edtRecetaMedicaArchivo_Contenttype), true, "", edtRecetaMedicaArchivo_Parameters, 0, edtRecetaMedicaArchivo_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtRecetaMedicaArchivo_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+"", "", "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaMedicaFlag_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaFlag_Internalname, "Medica Flag", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaFlag_Internalname, GXutil.ltrim( localUtil.ntoc( A272RecetaMedicaFlag, (byte)(1), (byte)(0), ",", "")), GXutil.ltrim( ((edtRecetaMedicaFlag_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A272RecetaMedicaFlag), "9") : localUtil.format( DecimalUtil.doubleToDec(A272RecetaMedicaFlag), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaFlag_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtRecetaMedicaFlag_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaIndicaciones_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaIndicaciones_Internalname, "Indicaciones", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtRecetaIndicaciones_Internalname, A332RecetaIndicaciones, "", "", (short)(0), 1, edtRecetaIndicaciones_Enabled, 0, 80, "chr", 4, "row", StyleString, ClassString, "", "", "300", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_RecetaMedicaGeneral.htm");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e114c1_client"+"'", TempTags, "", 2, "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e124c1_client"+"'", TempTags, "", 2, "HLP_RecetaMedicaGeneral.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaNombreArchivo_Internalname, A267RecetaMedicaNombreArchivo, GXutil.rtrim( localUtil.format( A267RecetaMedicaNombreArchivo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaNombreArchivo_Jsonclick, 0, "Attribute", "", "", "", "", edtRecetaMedicaNombreArchivo_Visible, 0, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaArchivoTipo_Internalname, A271RecetaArchivoTipo, GXutil.rtrim( localUtil.format( A271RecetaArchivoTipo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaArchivoTipo_Jsonclick, 0, "Attribute", "", "", "", "", edtRecetaArchivoTipo_Visible, 0, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedicaGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start4C2( )
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
            Form.getMeta().addItem("description", "Receta Medica General", (short)(0)) ;
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
            strup4C0( ) ;
         }
      }
   }

   public void ws4C2( )
   {
      start4C2( ) ;
      evt4C2( ) ;
   }

   public void evt4C2( )
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
                              strup4C0( ) ;
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
                              strup4C0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e134C2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4C0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e144C2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4C0( ) ;
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
                              strup4C0( ) ;
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

   public void we4C2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4C2( ) ;
         }
      }
   }

   public void pa4C2( )
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
      rf4C2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "RecetaMedicaGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf4C2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H004C2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A50RecetaMedicaId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A267RecetaMedicaNombreArchivo = H004C2_A267RecetaMedicaNombreArchivo[0] ;
            n267RecetaMedicaNombreArchivo = H004C2_n267RecetaMedicaNombreArchivo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A267RecetaMedicaNombreArchivo", A267RecetaMedicaNombreArchivo);
            edtRecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
            A271RecetaArchivoTipo = H004C2_A271RecetaArchivoTipo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A271RecetaArchivoTipo", A271RecetaArchivoTipo);
            edtRecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
            A19CitaId = H004C2_A19CitaId[0] ;
            A42MedicamentoId = H004C2_A42MedicamentoId[0] ;
            n42MedicamentoId = H004C2_n42MedicamentoId[0] ;
            A332RecetaIndicaciones = H004C2_A332RecetaIndicaciones[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A332RecetaIndicaciones", A332RecetaIndicaciones);
            A272RecetaMedicaFlag = H004C2_A272RecetaMedicaFlag[0] ;
            n272RecetaMedicaFlag = H004C2_n272RecetaMedicaFlag[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A272RecetaMedicaFlag", GXutil.str( A272RecetaMedicaFlag, 1, 0));
            A270RecetaMedicaArchivo = H004C2_A270RecetaMedicaArchivo[0] ;
            n270RecetaMedicaArchivo = H004C2_n270RecetaMedicaArchivo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
            A273RecetaMedicaAtencion = H004C2_A273RecetaMedicaAtencion[0] ;
            n273RecetaMedicaAtencion = H004C2_n273RecetaMedicaAtencion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A273RecetaMedicaAtencion", A273RecetaMedicaAtencion);
            A269RecetaMedicaCantidad = H004C2_A269RecetaMedicaCantidad[0] ;
            n269RecetaMedicaCantidad = H004C2_n269RecetaMedicaCantidad[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A269RecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), 4, 0));
            A268RecetaMedicaConcentracion = H004C2_A268RecetaMedicaConcentracion[0] ;
            n268RecetaMedicaConcentracion = H004C2_n268RecetaMedicaConcentracion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A268RecetaMedicaConcentracion", A268RecetaMedicaConcentracion);
            A231MedicamentoFormaFarm = H004C2_A231MedicamentoFormaFarm[0] ;
            n231MedicamentoFormaFarm = H004C2_n231MedicamentoFormaFarm[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
            A230MedicamentoNombre = H004C2_A230MedicamentoNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230MedicamentoNombre", A230MedicamentoNombre);
            A229MedicamentoCodigo = H004C2_A229MedicamentoCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
            A64CitaCode = H004C2_A64CitaCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
            A64CitaCode = H004C2_A64CitaCode[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
            A231MedicamentoFormaFarm = H004C2_A231MedicamentoFormaFarm[0] ;
            n231MedicamentoFormaFarm = H004C2_n231MedicamentoFormaFarm[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
            A230MedicamentoNombre = H004C2_A230MedicamentoNombre[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230MedicamentoNombre", A230MedicamentoNombre);
            A229MedicamentoCodigo = H004C2_A229MedicamentoCodigo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
            /* Execute user event: Load */
            e144C2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb4C0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4C2( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "RecetaMedicaGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup4C0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e134C2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA50RecetaMedicaId"), ",", ".")) ;
         /* Read variables values. */
         A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A64CitaCode", A64CitaCode);
         A229MedicamentoCodigo = httpContext.cgiGet( edtMedicamentoCodigo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
         A230MedicamentoNombre = httpContext.cgiGet( edtMedicamentoNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A230MedicamentoNombre", A230MedicamentoNombre);
         A231MedicamentoFormaFarm = httpContext.cgiGet( edtMedicamentoFormaFarm_Internalname) ;
         n231MedicamentoFormaFarm = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
         A268RecetaMedicaConcentracion = httpContext.cgiGet( edtRecetaMedicaConcentracion_Internalname) ;
         n268RecetaMedicaConcentracion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A268RecetaMedicaConcentracion", A268RecetaMedicaConcentracion);
         A269RecetaMedicaCantidad = (short)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaCantidad_Internalname), ",", ".")) ;
         n269RecetaMedicaCantidad = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A269RecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), 4, 0));
         A273RecetaMedicaAtencion = httpContext.cgiGet( edtRecetaMedicaAtencion_Internalname) ;
         n273RecetaMedicaAtencion = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A273RecetaMedicaAtencion", A273RecetaMedicaAtencion);
         A270RecetaMedicaArchivo = httpContext.cgiGet( edtRecetaMedicaArchivo_Internalname) ;
         n270RecetaMedicaArchivo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
         A272RecetaMedicaFlag = (byte)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaFlag_Internalname), ",", ".")) ;
         n272RecetaMedicaFlag = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A272RecetaMedicaFlag", GXutil.str( A272RecetaMedicaFlag, 1, 0));
         A332RecetaIndicaciones = httpContext.cgiGet( edtRecetaIndicaciones_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A332RecetaIndicaciones", A332RecetaIndicaciones);
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
      e134C2 ();
      if (returnInSub) return;
   }

   public void e134C2( )
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

   protected void e144C2( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita", GXv_boolean3) ;
      recetamedicageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( AV12TempBoolean )
      {
         edtCitaCode_Link = formatLink("com.projectthani.citaview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"CitaId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtCitaCode_Internalname, "Link", edtCitaCode_Link, true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMedicamento", GXv_boolean3) ;
      recetamedicageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( AV12TempBoolean )
      {
         edtMedicamentoCodigo_Link = formatLink("com.projectthani.medicamentoview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A42MedicamentoId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"MedicamentoId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtMedicamentoCodigo_Internalname, "Link", edtMedicamentoCodigo_Link, true);
      }
      edtRecetaMedicaNombreArchivo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaMedicaNombreArchivo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaNombreArchivo_Visible), 5, 0), true);
      edtRecetaArchivoTipo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtRecetaArchivoTipo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaArchivoTipo_Visible), 5, 0), true);
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Update", GXv_boolean3) ;
      recetamedicageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV12TempBoolean = GXt_boolean2 ;
      if ( ! ( AV12TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV12TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Delete", GXv_boolean3) ;
      recetamedicageneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "RecetaMedica" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A50RecetaMedicaId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
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
      pa4C2( ) ;
      ws4C2( ) ;
      we4C2( ) ;
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
      sCtrlA50RecetaMedicaId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa4C2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "recetamedicageneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4C2( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A50RecetaMedicaId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.SHORT), TypeConstants.SHORT)).shortValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
      }
      wcpOA50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA50RecetaMedicaId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A50RecetaMedicaId != wcpOA50RecetaMedicaId ) ) )
      {
         setjustcreated();
      }
      wcpOA50RecetaMedicaId = A50RecetaMedicaId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA50RecetaMedicaId = httpContext.cgiGet( sPrefix+"A50RecetaMedicaId_CTRL") ;
      if ( GXutil.len( sCtrlA50RecetaMedicaId) > 0 )
      {
         A50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( sCtrlA50RecetaMedicaId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
      }
      else
      {
         A50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A50RecetaMedicaId_PARM"), ",", ".")) ;
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
      pa4C2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4C2( ) ;
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
      ws4C2( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A50RecetaMedicaId_PARM", GXutil.ltrim( localUtil.ntoc( A50RecetaMedicaId, (byte)(4), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA50RecetaMedicaId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A50RecetaMedicaId_CTRL", GXutil.rtrim( sCtrlA50RecetaMedicaId));
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
      we4C2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033153", true, true);
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
      httpContext.AddJavascriptSource("recetamedicageneral.js", "?2022511033153", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtRecetaMedicaId_Internalname = sPrefix+"RECETAMEDICAID" ;
      edtCitaCode_Internalname = sPrefix+"CITACODE" ;
      edtMedicamentoCodigo_Internalname = sPrefix+"MEDICAMENTOCODIGO" ;
      edtMedicamentoNombre_Internalname = sPrefix+"MEDICAMENTONOMBRE" ;
      edtMedicamentoFormaFarm_Internalname = sPrefix+"MEDICAMENTOFORMAFARM" ;
      edtRecetaMedicaConcentracion_Internalname = sPrefix+"RECETAMEDICACONCENTRACION" ;
      edtRecetaMedicaCantidad_Internalname = sPrefix+"RECETAMEDICACANTIDAD" ;
      edtRecetaMedicaAtencion_Internalname = sPrefix+"RECETAMEDICAATENCION" ;
      edtRecetaMedicaArchivo_Internalname = sPrefix+"RECETAMEDICAARCHIVO" ;
      edtRecetaMedicaFlag_Internalname = sPrefix+"RECETAMEDICAFLAG" ;
      edtRecetaIndicaciones_Internalname = sPrefix+"RECETAINDICACIONES" ;
      divTransactiondetail_tableattributes_Internalname = sPrefix+"TRANSACTIONDETAIL_TABLEATTRIBUTES" ;
      bttBtnupdate_Internalname = sPrefix+"BTNUPDATE" ;
      bttBtndelete_Internalname = sPrefix+"BTNDELETE" ;
      divTable_Internalname = sPrefix+"TABLE" ;
      edtRecetaMedicaNombreArchivo_Internalname = sPrefix+"RECETAMEDICANOMBREARCHIVO" ;
      edtRecetaArchivoTipo_Internalname = sPrefix+"RECETAARCHIVOTIPO" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
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
      edtRecetaArchivoTipo_Jsonclick = "" ;
      edtRecetaArchivoTipo_Visible = 1 ;
      edtRecetaMedicaNombreArchivo_Jsonclick = "" ;
      edtRecetaMedicaNombreArchivo_Visible = 1 ;
      bttBtndelete_Visible = 1 ;
      bttBtnupdate_Visible = 1 ;
      edtRecetaIndicaciones_Enabled = 0 ;
      edtRecetaMedicaFlag_Jsonclick = "" ;
      edtRecetaMedicaFlag_Enabled = 0 ;
      edtRecetaMedicaArchivo_Jsonclick = "" ;
      edtRecetaMedicaArchivo_Parameters = "" ;
      edtRecetaMedicaArchivo_Contenttype = "" ;
      edtRecetaMedicaArchivo_Filetype = "" ;
      edtRecetaMedicaArchivo_Enabled = 0 ;
      edtRecetaMedicaAtencion_Jsonclick = "" ;
      edtRecetaMedicaAtencion_Enabled = 0 ;
      edtRecetaMedicaCantidad_Jsonclick = "" ;
      edtRecetaMedicaCantidad_Enabled = 0 ;
      edtRecetaMedicaConcentracion_Jsonclick = "" ;
      edtRecetaMedicaConcentracion_Enabled = 0 ;
      edtMedicamentoFormaFarm_Jsonclick = "" ;
      edtMedicamentoFormaFarm_Enabled = 0 ;
      edtMedicamentoNombre_Jsonclick = "" ;
      edtMedicamentoNombre_Enabled = 0 ;
      edtMedicamentoCodigo_Jsonclick = "" ;
      edtMedicamentoCodigo_Link = "" ;
      edtMedicamentoCodigo_Enabled = 0 ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaCode_Link = "" ;
      edtCitaCode_Enabled = 0 ;
      edtRecetaMedicaId_Jsonclick = "" ;
      edtRecetaMedicaId_Enabled = 0 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A50RecetaMedicaId',fld:'RECETAMEDICAID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e114C1',iparms:[{av:'A50RecetaMedicaId',fld:'RECETAMEDICAID',pic:'ZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e124C1',iparms:[{av:'A50RecetaMedicaId',fld:'RECETAMEDICAID',pic:'ZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_RECETAMEDICAID","{handler:'valid_Recetamedicaid',iparms:[]");
      setEventMetadata("VALID_RECETAMEDICAID",",oparms:[]}");
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
      A64CitaCode = "" ;
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      A268RecetaMedicaConcentracion = "" ;
      A273RecetaMedicaAtencion = "" ;
      ClassString = "" ;
      StyleString = "" ;
      edtRecetaMedicaArchivo_Filename = "" ;
      A267RecetaMedicaNombreArchivo = "" ;
      A271RecetaArchivoTipo = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A270RecetaMedicaArchivo = "" ;
      A332RecetaIndicaciones = "" ;
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
      H004C2_A50RecetaMedicaId = new short[1] ;
      H004C2_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      H004C2_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      H004C2_A271RecetaArchivoTipo = new String[] {""} ;
      H004C2_A19CitaId = new int[1] ;
      H004C2_A42MedicamentoId = new short[1] ;
      H004C2_n42MedicamentoId = new boolean[] {false} ;
      H004C2_A332RecetaIndicaciones = new String[] {""} ;
      H004C2_A272RecetaMedicaFlag = new byte[1] ;
      H004C2_n272RecetaMedicaFlag = new boolean[] {false} ;
      H004C2_A270RecetaMedicaArchivo = new String[] {""} ;
      H004C2_n270RecetaMedicaArchivo = new boolean[] {false} ;
      H004C2_A273RecetaMedicaAtencion = new String[] {""} ;
      H004C2_n273RecetaMedicaAtencion = new boolean[] {false} ;
      H004C2_A269RecetaMedicaCantidad = new short[1] ;
      H004C2_n269RecetaMedicaCantidad = new boolean[] {false} ;
      H004C2_A268RecetaMedicaConcentracion = new String[] {""} ;
      H004C2_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      H004C2_A231MedicamentoFormaFarm = new String[] {""} ;
      H004C2_n231MedicamentoFormaFarm = new boolean[] {false} ;
      H004C2_A230MedicamentoNombre = new String[] {""} ;
      H004C2_A229MedicamentoCodigo = new String[] {""} ;
      H004C2_A64CitaCode = new String[] {""} ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA50RecetaMedicaId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.recetamedicageneral__default(),
         new Object[] {
             new Object[] {
            H004C2_A50RecetaMedicaId, H004C2_A267RecetaMedicaNombreArchivo, H004C2_n267RecetaMedicaNombreArchivo, H004C2_A271RecetaArchivoTipo, H004C2_A19CitaId, H004C2_A42MedicamentoId, H004C2_n42MedicamentoId, H004C2_A332RecetaIndicaciones, H004C2_A272RecetaMedicaFlag, H004C2_n272RecetaMedicaFlag,
            H004C2_A270RecetaMedicaArchivo, H004C2_n270RecetaMedicaArchivo, H004C2_A273RecetaMedicaAtencion, H004C2_n273RecetaMedicaAtencion, H004C2_A269RecetaMedicaCantidad, H004C2_n269RecetaMedicaCantidad, H004C2_A268RecetaMedicaConcentracion, H004C2_n268RecetaMedicaConcentracion, H004C2_A231MedicamentoFormaFarm, H004C2_n231MedicamentoFormaFarm,
            H004C2_A230MedicamentoNombre, H004C2_A229MedicamentoCodigo, H004C2_A64CitaCode
            }
         }
      );
      AV18Pgmname = "RecetaMedicaGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "RecetaMedicaGeneral" ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte A272RecetaMedicaFlag ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA50RecetaMedicaId ;
   private short A50RecetaMedicaId ;
   private short wbEnd ;
   private short wbStart ;
   private short A269RecetaMedicaCantidad ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A42MedicamentoId ;
   private int edtRecetaMedicaId_Enabled ;
   private int edtCitaCode_Enabled ;
   private int edtMedicamentoCodigo_Enabled ;
   private int edtMedicamentoNombre_Enabled ;
   private int edtMedicamentoFormaFarm_Enabled ;
   private int edtRecetaMedicaConcentracion_Enabled ;
   private int edtRecetaMedicaCantidad_Enabled ;
   private int edtRecetaMedicaAtencion_Enabled ;
   private int edtRecetaMedicaArchivo_Enabled ;
   private int edtRecetaMedicaFlag_Enabled ;
   private int edtRecetaIndicaciones_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int edtRecetaMedicaNombreArchivo_Visible ;
   private int edtRecetaArchivoTipo_Visible ;
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
   private String edtRecetaMedicaId_Internalname ;
   private String edtRecetaMedicaId_Jsonclick ;
   private String edtCitaCode_Internalname ;
   private String edtCitaCode_Link ;
   private String edtCitaCode_Jsonclick ;
   private String edtMedicamentoCodigo_Internalname ;
   private String edtMedicamentoCodigo_Link ;
   private String edtMedicamentoCodigo_Jsonclick ;
   private String edtMedicamentoNombre_Internalname ;
   private String edtMedicamentoNombre_Jsonclick ;
   private String edtMedicamentoFormaFarm_Internalname ;
   private String edtMedicamentoFormaFarm_Jsonclick ;
   private String edtRecetaMedicaConcentracion_Internalname ;
   private String edtRecetaMedicaConcentracion_Jsonclick ;
   private String edtRecetaMedicaCantidad_Internalname ;
   private String edtRecetaMedicaCantidad_Jsonclick ;
   private String edtRecetaMedicaAtencion_Internalname ;
   private String edtRecetaMedicaAtencion_Jsonclick ;
   private String edtRecetaMedicaArchivo_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtRecetaMedicaArchivo_Filename ;
   private String edtRecetaMedicaArchivo_Filetype ;
   private String edtRecetaMedicaArchivo_Contenttype ;
   private String edtRecetaMedicaArchivo_Parameters ;
   private String edtRecetaMedicaArchivo_Jsonclick ;
   private String edtRecetaMedicaFlag_Internalname ;
   private String edtRecetaMedicaFlag_Jsonclick ;
   private String edtRecetaIndicaciones_Internalname ;
   private String TempTags ;
   private String bttBtnupdate_Internalname ;
   private String bttBtnupdate_Jsonclick ;
   private String bttBtndelete_Internalname ;
   private String bttBtndelete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtRecetaMedicaNombreArchivo_Internalname ;
   private String edtRecetaMedicaNombreArchivo_Jsonclick ;
   private String edtRecetaArchivoTipo_Internalname ;
   private String edtRecetaArchivoTipo_Jsonclick ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV18Pgmname ;
   private String scmdbuf ;
   private String sCtrlA50RecetaMedicaId ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean n270RecetaMedicaArchivo ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean n42MedicamentoId ;
   private boolean n272RecetaMedicaFlag ;
   private boolean n273RecetaMedicaAtencion ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n268RecetaMedicaConcentracion ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean returnInSub ;
   private boolean AV12TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A270RecetaMedicaArchivo ;
   private String A64CitaCode ;
   private String A229MedicamentoCodigo ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String A268RecetaMedicaConcentracion ;
   private String A273RecetaMedicaAtencion ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A271RecetaArchivoTipo ;
   private String A332RecetaIndicaciones ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private IDataStoreProvider pr_default ;
   private short[] H004C2_A50RecetaMedicaId ;
   private String[] H004C2_A267RecetaMedicaNombreArchivo ;
   private boolean[] H004C2_n267RecetaMedicaNombreArchivo ;
   private String[] H004C2_A271RecetaArchivoTipo ;
   private int[] H004C2_A19CitaId ;
   private short[] H004C2_A42MedicamentoId ;
   private boolean[] H004C2_n42MedicamentoId ;
   private String[] H004C2_A332RecetaIndicaciones ;
   private byte[] H004C2_A272RecetaMedicaFlag ;
   private boolean[] H004C2_n272RecetaMedicaFlag ;
   private String[] H004C2_A270RecetaMedicaArchivo ;
   private boolean[] H004C2_n270RecetaMedicaArchivo ;
   private String[] H004C2_A273RecetaMedicaAtencion ;
   private boolean[] H004C2_n273RecetaMedicaAtencion ;
   private short[] H004C2_A269RecetaMedicaCantidad ;
   private boolean[] H004C2_n269RecetaMedicaCantidad ;
   private String[] H004C2_A268RecetaMedicaConcentracion ;
   private boolean[] H004C2_n268RecetaMedicaConcentracion ;
   private String[] H004C2_A231MedicamentoFormaFarm ;
   private boolean[] H004C2_n231MedicamentoFormaFarm ;
   private String[] H004C2_A230MedicamentoNombre ;
   private String[] H004C2_A229MedicamentoCodigo ;
   private String[] H004C2_A64CitaCode ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class recetamedicageneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004C2", "SELECT T1.[RecetaMedicaId], T1.[RecetaMedicaNombreArchivo], T1.[RecetaArchivoTipo], T1.[CitaId], T1.[MedicamentoId], T1.[RecetaIndicaciones], T1.[RecetaMedicaFlag], T1.[RecetaMedicaArchivo], T1.[RecetaMedicaAtencion], T1.[RecetaMedicaCantidad], T1.[RecetaMedicaConcentracion], T3.[MedicamentoFormaFarm], T3.[MedicamentoNombre], T3.[MedicamentoCodigo], T2.[CitaCode] FROM (([RecetaMedica] T1 INNER JOIN [Cita] T2 ON T2.[CitaId] = T1.[CitaId]) LEFT JOIN [Medicamento] T3 ON T3.[MedicamentoId] = T1.[MedicamentoId]) WHERE T1.[RecetaMedicaId] = ? ORDER BY T1.[RecetaMedicaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((byte[]) buf[8])[0] = rslt.getByte(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getBLOBFile(8, rslt.getVarchar(3), rslt.getVarchar(2));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(10);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(13);
               ((String[]) buf[21])[0] = rslt.getVarchar(14);
               ((String[]) buf[22])[0] = rslt.getVarchar(15);
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

