package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pacientegeneral_impl extends GXWebComponent
{
   public pacientegeneral_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pacientegeneral_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacientegeneral_impl.class ));
   }

   public pacientegeneral_impl( int remoteHandle ,
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
      cmbPacienteTipoDocumento = new HTMLChoice();
      cmbPacienteSexo = new HTMLChoice();
      cmbPacienteEstado = new HTMLChoice();
      cmbPacienteEnterarse = new HTMLChoice();
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
               A20PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,Integer.valueOf(A20PacienteId)});
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
         pa522( ) ;
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
         httpContext.writeValue( "Paciente General") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110322078", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.pacientegeneral", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A20PacienteId,8,0))}, new String[] {"PacienteId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA20PacienteId", GXutil.ltrim( localUtil.ntoc( wcpOA20PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UBIGEODEPARTAMENTO", A186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UBIGEOPROVINCIA", A187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"UBIGEODISTRITO", A188UbigeoDistrito);
   }

   public void renderHtmlCloseForm522( )
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
      return "PacienteGeneral" ;
   }

   public String getPgmdesc( )
   {
      return "Paciente General" ;
   }

   public void wb520( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.pacientegeneral");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteId_Internalname, "Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteId_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_PacienteGeneral.htm");
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
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoPaterno_Internalname, "Apellido Paterno", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoPaterno_Internalname, A103PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoPaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteApellidoPaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
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
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoMaterno_Internalname, "Apellido Materno", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoMaterno_Internalname, A104PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoMaterno_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteApellidoMaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
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
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombres_Internalname, "Nombres", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombres_Internalname, A105PacienteNombres, GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombres_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteNombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombreCompleto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombreCompleto_Internalname, "Nombre Completo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombreCompleto_Internalname, A212PacienteNombreCompleto, GXutil.rtrim( localUtil.format( A212PacienteNombreCompleto, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombreCompleto_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteNombreCompleto_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteFechaNacimiento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteFechaNacimiento_Internalname, "Fecha Nacimiento", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtPacienteFechaNacimiento_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteFechaNacimiento_Internalname, localUtil.format(A213PacienteFechaNacimiento, "99/99/99"), localUtil.format( A213PacienteFechaNacimiento, "99/99/99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteFechaNacimiento_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteFechaNacimiento_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtPacienteFechaNacimiento_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtPacienteFechaNacimiento_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_PacienteGeneral.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteTipoDocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteTipoDocumento.getInternalname(), "Tipo Documento", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteTipoDocumento, cmbPacienteTipoDocumento.getInternalname(), GXutil.rtrim( A214PacienteTipoDocumento), 1, cmbPacienteTipoDocumento.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteTipoDocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PacienteGeneral.htm");
         cmbPacienteTipoDocumento.setValue( GXutil.rtrim( A214PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteTipoDocumento.getInternalname(), "Values", cmbPacienteTipoDocumento.ToJavascriptSource(), true);
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
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNroDocumento_Internalname, "Nro Documento", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNroDocumento_Internalname, A106PacienteNroDocumento, GXutil.rtrim( localUtil.format( A106PacienteNroDocumento, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNroDocumento_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteNroDocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteDireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteDireccion_Internalname, "Direccion", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPacienteDireccion_Internalname, A215PacienteDireccion, "", "", (short)(0), 1, edtPacienteDireccion_Enabled, 0, 80, "chr", 7, "row", StyleString, ClassString, "", "", "500", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteSexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteSexo.getInternalname(), "Sexo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteSexo, cmbPacienteSexo.getInternalname(), GXutil.rtrim( A216PacienteSexo), 1, cmbPacienteSexo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteSexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PacienteGeneral.htm");
         cmbPacienteSexo.setValue( GXutil.rtrim( A216PacienteSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteSexo.getInternalname(), "Values", cmbPacienteSexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteCorreo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteCorreo_Internalname, "Correo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteCorreo_Internalname, A217PacienteCorreo, GXutil.rtrim( localUtil.format( A217PacienteCorreo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "mailto:"+A217PacienteCorreo, "", "", "", edtPacienteCorreo_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteTelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteTelefono_Internalname, "Telefono", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         if ( httpContext.isSmartDevice( ) )
         {
            gxphoneLink = "tel:" + GXutil.rtrim( A218PacienteTelefono) ;
         }
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteTelefono_Internalname, GXutil.rtrim( A218PacienteTelefono), GXutil.rtrim( localUtil.format( A218PacienteTelefono, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", gxphoneLink, "", "", "", edtPacienteTelefono_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteTelefono_Enabled, 0, "tel", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Phone", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaisDescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPaisDescripcion_Internalname, "Pais Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPaisDescripcion_Internalname, A184PaisDescripcion, GXutil.rtrim( localUtil.format( A184PaisDescripcion, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtPaisDescripcion_Link, "", "", "", edtPaisDescripcion_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPaisDescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteEstado.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteEstado.getInternalname(), "Estado", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteEstado, cmbPacienteEstado.getInternalname(), GXutil.rtrim( A219PacienteEstado), 1, cmbPacienteEstado.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PacienteGeneral.htm");
         cmbPacienteEstado.setValue( GXutil.rtrim( A219PacienteEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteEstado.getInternalname(), "Values", cmbPacienteEstado.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserName_Internalname, "User Id", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserName_Internalname, A14SecUserName, GXutil.rtrim( localUtil.format( A14SecUserName, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtSecUserName_Link, "", "", "", edtSecUserName_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtSecUserName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoNombre_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoNombre_Internalname, "Ubigeo Code", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoNombre_Internalname, A185UbigeoNombre, GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", edtUbigeoNombre_Link, "", "", "", edtUbigeoNombre_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtUbigeoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteEstatura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteEstatura_Internalname, "Estatura", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteEstatura_Internalname, GXutil.ltrim( localUtil.ntoc( A220PacienteEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtPacienteEstatura_Enabled!=0) ? localUtil.format( A220PacienteEstatura, "9.99") : localUtil.format( A220PacienteEstatura, "9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteEstatura_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteEstatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacientePeso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacientePeso_Internalname, "Peso", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacientePeso_Internalname, GXutil.ltrim( localUtil.ntoc( A221PacientePeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtPacientePeso_Enabled!=0) ? localUtil.format( A221PacientePeso, "ZZ9.99") : localUtil.format( A221PacientePeso, "ZZ9.99"))), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacientePeso_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacientePeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombreAnexo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombreAnexo_Internalname, "Nombre Anexo", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombreAnexo_Internalname, A222PacienteNombreAnexo, GXutil.rtrim( localUtil.format( A222PacienteNombreAnexo, "")), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombreAnexo_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteNombreAnexo_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteAnexos_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteAnexos_Internalname, "Anexos", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         edtPacienteAnexos_Filetype = "tmp" ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, true);
         if ( ! (GXutil.strcmp("", A223PacienteAnexos)==0) )
         {
            gxblobfileaux.setSource( A223PacienteAnexos );
            if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtPacienteAnexos_Filetype, "tmp") != 0 ) )
            {
               gxblobfileaux.setExt(GXutil.trim( edtPacienteAnexos_Filetype));
            }
            if ( gxblobfileaux.getErrCode() == 0 )
            {
               A223PacienteAnexos = gxblobfileaux.getURI() ;
               n223PacienteAnexos = false ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223PacienteAnexos", A223PacienteAnexos);
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
               edtPacienteAnexos_Filetype = gxblobfileaux.getExtension() ;
               httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, true);
               gxblobfileaux.setBlobToDelete();
            }
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
         }
         com.projectthani.GxWebStd.gx_blob_field( httpContext, edtPacienteAnexos_Internalname, GXutil.rtrim( A223PacienteAnexos), httpContext.getResourceRelative(A223PacienteAnexos), ((GXutil.strcmp("", edtPacienteAnexos_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtPacienteAnexos_Filetype)==0) ? A223PacienteAnexos : edtPacienteAnexos_Filetype)) : edtPacienteAnexos_Contenttype), false, "", edtPacienteAnexos_Parameters, 0, edtPacienteAnexos_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtPacienteAnexos_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+"", "", "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteEnterarse.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteEnterarse.getInternalname(), "Enterarse", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteEnterarse, cmbPacienteEnterarse.getInternalname(), GXutil.rtrim( A224PacienteEnterarse), 1, cmbPacienteEnterarse.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbPacienteEnterarse.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "ReadonlyAttribute", "", "", "", "", true, (byte)(1), "HLP_PacienteGeneral.htm");
         cmbPacienteEnterarse.setValue( GXutil.rtrim( A224PacienteEnterarse) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteEnterarse.getInternalname(), "Values", cmbPacienteEnterarse.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteEspecifique_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteEspecifique_Internalname, "Especifique", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         ClassString = "ReadonlyAttribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPacienteEspecifique_Internalname, A225PacienteEspecifique, "", "", (short)(0), 1, edtPacienteEspecifique_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", 0, "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteFechaRegistro_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteFechaRegistro_Internalname, "Fecha Registro", "col-sm-3 ReadonlyAttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         httpContext.writeText( "<div id=\""+edtPacienteFechaRegistro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteFechaRegistro_Internalname, localUtil.ttoc( A226PacienteFechaRegistro, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A226PacienteFechaRegistro, "99/99/99 99:99"), "", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteFechaRegistro_Jsonclick, 0, "ReadonlyAttribute", "", "", "", "", 1, edtPacienteFechaRegistro_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtPacienteFechaRegistro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtPacienteFechaRegistro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_PacienteGeneral.htm");
         httpContext.writeTextNL( "</div>") ;
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnupdate_Internalname, "", "Modificar", bttBtnupdate_Jsonclick, 7, "Modificar", "", StyleString, ClassString, bttBtnupdate_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11521_client"+"'", TempTags, "", 2, "HLP_PacienteGeneral.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 131,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtndelete_Internalname, "", "Eliminar", bttBtndelete_Jsonclick, 7, "Eliminar", "", StyleString, ClassString, bttBtndelete_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12521_client"+"'", TempTags, "", 2, "HLP_PacienteGeneral.htm");
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

   public void start522( )
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
            Form.getMeta().addItem("description", "Paciente General", (short)(0)) ;
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
            strup520( ) ;
         }
      }
   }

   public void ws522( )
   {
      start522( ) ;
      evt522( ) ;
   }

   public void evt522( )
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
                              strup520( ) ;
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
                              strup520( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13522 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup520( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e14522 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup520( ) ;
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
                              strup520( ) ;
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

   public void we522( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm522( ) ;
         }
      }
   }

   public void pa522( )
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
      if ( cmbPacienteTipoDocumento.getItemCount() > 0 )
      {
         A214PacienteTipoDocumento = cmbPacienteTipoDocumento.getValidValue(A214PacienteTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteTipoDocumento.setValue( GXutil.rtrim( A214PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteTipoDocumento.getInternalname(), "Values", cmbPacienteTipoDocumento.ToJavascriptSource(), true);
      }
      if ( cmbPacienteSexo.getItemCount() > 0 )
      {
         A216PacienteSexo = cmbPacienteSexo.getValidValue(A216PacienteSexo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A216PacienteSexo", A216PacienteSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteSexo.setValue( GXutil.rtrim( A216PacienteSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteSexo.getInternalname(), "Values", cmbPacienteSexo.ToJavascriptSource(), true);
      }
      if ( cmbPacienteEstado.getItemCount() > 0 )
      {
         A219PacienteEstado = cmbPacienteEstado.getValidValue(A219PacienteEstado) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A219PacienteEstado", A219PacienteEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteEstado.setValue( GXutil.rtrim( A219PacienteEstado) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteEstado.getInternalname(), "Values", cmbPacienteEstado.ToJavascriptSource(), true);
      }
      if ( cmbPacienteEnterarse.getItemCount() > 0 )
      {
         A224PacienteEnterarse = cmbPacienteEnterarse.getValidValue(A224PacienteEnterarse) ;
         n224PacienteEnterarse = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224PacienteEnterarse", A224PacienteEnterarse);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteEnterarse.setValue( GXutil.rtrim( A224PacienteEnterarse) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbPacienteEnterarse.getInternalname(), "Values", cmbPacienteEnterarse.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf522( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV18Pgmname = "PacienteGeneral" ;
      Gx_err = (short)(0) ;
   }

   public void rf522( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00522 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A20PacienteId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A43PaisId = H00522_A43PaisId[0] ;
            A6SecUserId = H00522_A6SecUserId[0] ;
            n6SecUserId = H00522_n6SecUserId[0] ;
            A44UbigeoCode = H00522_A44UbigeoCode[0] ;
            n44UbigeoCode = H00522_n44UbigeoCode[0] ;
            A226PacienteFechaRegistro = H00522_A226PacienteFechaRegistro[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
            A225PacienteEspecifique = H00522_A225PacienteEspecifique[0] ;
            n225PacienteEspecifique = H00522_n225PacienteEspecifique[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A225PacienteEspecifique", A225PacienteEspecifique);
            A224PacienteEnterarse = H00522_A224PacienteEnterarse[0] ;
            n224PacienteEnterarse = H00522_n224PacienteEnterarse[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224PacienteEnterarse", A224PacienteEnterarse);
            A223PacienteAnexos = H00522_A223PacienteAnexos[0] ;
            n223PacienteAnexos = H00522_n223PacienteAnexos[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223PacienteAnexos", A223PacienteAnexos);
            httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
            A222PacienteNombreAnexo = H00522_A222PacienteNombreAnexo[0] ;
            n222PacienteNombreAnexo = H00522_n222PacienteNombreAnexo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222PacienteNombreAnexo", A222PacienteNombreAnexo);
            A221PacientePeso = H00522_A221PacientePeso[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221PacientePeso", GXutil.ltrimstr( A221PacientePeso, 6, 2));
            A220PacienteEstatura = H00522_A220PacienteEstatura[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A220PacienteEstatura", GXutil.ltrimstr( A220PacienteEstatura, 4, 2));
            A14SecUserName = H00522_A14SecUserName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A14SecUserName", A14SecUserName);
            A219PacienteEstado = H00522_A219PacienteEstado[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A219PacienteEstado", A219PacienteEstado);
            A184PaisDescripcion = H00522_A184PaisDescripcion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A184PaisDescripcion", A184PaisDescripcion);
            A218PacienteTelefono = H00522_A218PacienteTelefono[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A218PacienteTelefono", A218PacienteTelefono);
            A217PacienteCorreo = H00522_A217PacienteCorreo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A217PacienteCorreo", A217PacienteCorreo);
            A216PacienteSexo = H00522_A216PacienteSexo[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A216PacienteSexo", A216PacienteSexo);
            A215PacienteDireccion = H00522_A215PacienteDireccion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A215PacienteDireccion", A215PacienteDireccion);
            A106PacienteNroDocumento = H00522_A106PacienteNroDocumento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
            A214PacienteTipoDocumento = H00522_A214PacienteTipoDocumento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
            A213PacienteFechaNacimiento = H00522_A213PacienteFechaNacimiento[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A213PacienteFechaNacimiento", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
            A105PacienteNombres = H00522_A105PacienteNombres[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
            A104PacienteApellidoMaterno = H00522_A104PacienteApellidoMaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A103PacienteApellidoPaterno = H00522_A103PacienteApellidoPaterno[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A188UbigeoDistrito = H00522_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H00522_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H00522_A186UbigeoDepartamento[0] ;
            A184PaisDescripcion = H00522_A184PaisDescripcion[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A184PaisDescripcion", A184PaisDescripcion);
            A14SecUserName = H00522_A14SecUserName[0] ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A14SecUserName", A14SecUserName);
            A188UbigeoDistrito = H00522_A188UbigeoDistrito[0] ;
            A187UbigeoProvincia = H00522_A187UbigeoProvincia[0] ;
            A186UbigeoDepartamento = H00522_A186UbigeoDepartamento[0] ;
            A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A212PacienteNombreCompleto", A212PacienteNombreCompleto);
            A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A185UbigeoNombre", A185UbigeoNombre);
            /* Execute user event: Load */
            e14522 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb520( ) ;
      }
   }

   public void send_integrity_lvl_hashes522( )
   {
   }

   public void before_start_formulas( )
   {
      AV18Pgmname = "PacienteGeneral" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup520( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13522 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         wcpOA20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA20PacienteId"), ",", ".")) ;
         /* Read variables values. */
         A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A105PacienteNombres", A105PacienteNombres);
         A212PacienteNombreCompleto = httpContext.cgiGet( edtPacienteNombreCompleto_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A212PacienteNombreCompleto", A212PacienteNombreCompleto);
         A213PacienteFechaNacimiento = localUtil.ctod( httpContext.cgiGet( edtPacienteFechaNacimiento_Internalname), 3) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A213PacienteFechaNacimiento", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
         cmbPacienteTipoDocumento.setValue( httpContext.cgiGet( cmbPacienteTipoDocumento.getInternalname()) );
         A214PacienteTipoDocumento = httpContext.cgiGet( cmbPacienteTipoDocumento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
         A106PacienteNroDocumento = httpContext.cgiGet( edtPacienteNroDocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
         A215PacienteDireccion = httpContext.cgiGet( edtPacienteDireccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A215PacienteDireccion", A215PacienteDireccion);
         cmbPacienteSexo.setValue( httpContext.cgiGet( cmbPacienteSexo.getInternalname()) );
         A216PacienteSexo = httpContext.cgiGet( cmbPacienteSexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A216PacienteSexo", A216PacienteSexo);
         A217PacienteCorreo = httpContext.cgiGet( edtPacienteCorreo_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A217PacienteCorreo", A217PacienteCorreo);
         A218PacienteTelefono = httpContext.cgiGet( edtPacienteTelefono_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A218PacienteTelefono", A218PacienteTelefono);
         A184PaisDescripcion = httpContext.cgiGet( edtPaisDescripcion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A184PaisDescripcion", A184PaisDescripcion);
         cmbPacienteEstado.setValue( httpContext.cgiGet( cmbPacienteEstado.getInternalname()) );
         A219PacienteEstado = httpContext.cgiGet( cmbPacienteEstado.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A219PacienteEstado", A219PacienteEstado);
         A14SecUserName = httpContext.cgiGet( edtSecUserName_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A14SecUserName", A14SecUserName);
         A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A185UbigeoNombre", A185UbigeoNombre);
         A220PacienteEstatura = localUtil.ctond( httpContext.cgiGet( edtPacienteEstatura_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A220PacienteEstatura", GXutil.ltrimstr( A220PacienteEstatura, 4, 2));
         A221PacientePeso = localUtil.ctond( httpContext.cgiGet( edtPacientePeso_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A221PacientePeso", GXutil.ltrimstr( A221PacientePeso, 6, 2));
         A222PacienteNombreAnexo = httpContext.cgiGet( edtPacienteNombreAnexo_Internalname) ;
         n222PacienteNombreAnexo = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A222PacienteNombreAnexo", A222PacienteNombreAnexo);
         A223PacienteAnexos = httpContext.cgiGet( edtPacienteAnexos_Internalname) ;
         n223PacienteAnexos = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A223PacienteAnexos", A223PacienteAnexos);
         cmbPacienteEnterarse.setValue( httpContext.cgiGet( cmbPacienteEnterarse.getInternalname()) );
         A224PacienteEnterarse = httpContext.cgiGet( cmbPacienteEnterarse.getInternalname()) ;
         n224PacienteEnterarse = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A224PacienteEnterarse", A224PacienteEnterarse);
         A225PacienteEspecifique = httpContext.cgiGet( edtPacienteEspecifique_Internalname) ;
         n225PacienteEspecifique = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A225PacienteEspecifique", A225PacienteEspecifique);
         A226PacienteFechaRegistro = localUtil.ctot( httpContext.cgiGet( edtPacienteFechaRegistro_Internalname)) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
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
      e13522 ();
      if (returnInSub) return;
   }

   public void e13522( )
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

   protected void e14522( )
   {
      /* Load Routine */
      returnInSub = false ;
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPais", GXv_boolean3) ;
      pacientegeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( AV13TempBoolean )
      {
         edtPaisDescripcion_Link = formatLink("com.projectthani.paisview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A43PaisId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"PaisId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtPaisDescripcion_Internalname, "Link", edtPaisDescripcion_Link, true);
      }
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser", GXv_boolean3) ;
      pacientegeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( AV13TempBoolean )
      {
         edtSecUserName_Link = formatLink("com.projectthani.wwpbaseobjects.secuserview", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A6SecUserId,4,0)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"SecUserId","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtSecUserName_Internalname, "Link", edtSecUserName_Link, true);
      }
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo", GXv_boolean3) ;
      pacientegeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( AV13TempBoolean )
      {
         edtUbigeoNombre_Link = formatLink("com.projectthani.ubigeoview", new String[] {GXutil.URLEncode(GXutil.rtrim(A44UbigeoCode)),GXutil.URLEncode(GXutil.rtrim(""))}, new String[] {"UbigeoCode","TabCode"})  ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtUbigeoNombre_Internalname, "Link", edtUbigeoNombre_Link, true);
      }
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Update", GXv_boolean3) ;
      pacientegeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      AV13TempBoolean = GXt_boolean2 ;
      if ( ! ( AV13TempBoolean ) )
      {
         bttBtnupdate_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtnupdate_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnupdate_Visible), 5, 0), true);
      }
      GXt_boolean2 = AV13TempBoolean ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Delete", GXv_boolean3) ;
      pacientegeneral_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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
      AV8TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Paciente" );
      AV10Session.setValue("TrnContext", AV8TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A20PacienteId = ((Number) GXutil.testNumericType( getParm(obj,0,TypeConstants.INT), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
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
      pa522( ) ;
      ws522( ) ;
      we522( ) ;
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
      sCtrlA20PacienteId = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      pa522( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "pacientegeneral", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa522( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A20PacienteId = ((Number) GXutil.testNumericType( getParm(obj,2,TypeConstants.INT), TypeConstants.INT)).intValue() ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      }
      wcpOA20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"wcpOA20PacienteId"), ",", ".")) ;
      if ( ! GetJustCreated( ) && ( ( A20PacienteId != wcpOA20PacienteId ) ) )
      {
         setjustcreated();
      }
      wcpOA20PacienteId = A20PacienteId ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA20PacienteId = httpContext.cgiGet( sPrefix+"A20PacienteId_CTRL") ;
      if ( GXutil.len( sCtrlA20PacienteId) > 0 )
      {
         A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sCtrlA20PacienteId), ",", ".")) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      }
      else
      {
         A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"A20PacienteId_PARM"), ",", ".")) ;
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
      pa522( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws522( ) ;
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
      ws522( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A20PacienteId_PARM", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")));
      if ( GXutil.len( GXutil.rtrim( sCtrlA20PacienteId)) > 0 )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A20PacienteId_CTRL", GXutil.rtrim( sCtrlA20PacienteId));
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
      we522( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110322169", true, true);
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
      httpContext.AddJavascriptSource("pacientegeneral.js", "?20225110322169", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPacienteId_Internalname = sPrefix+"PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = sPrefix+"PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = sPrefix+"PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = sPrefix+"PACIENTENOMBRES" ;
      edtPacienteNombreCompleto_Internalname = sPrefix+"PACIENTENOMBRECOMPLETO" ;
      edtPacienteFechaNacimiento_Internalname = sPrefix+"PACIENTEFECHANACIMIENTO" ;
      cmbPacienteTipoDocumento.setInternalname( sPrefix+"PACIENTETIPODOCUMENTO" );
      edtPacienteNroDocumento_Internalname = sPrefix+"PACIENTENRODOCUMENTO" ;
      edtPacienteDireccion_Internalname = sPrefix+"PACIENTEDIRECCION" ;
      cmbPacienteSexo.setInternalname( sPrefix+"PACIENTESEXO" );
      edtPacienteCorreo_Internalname = sPrefix+"PACIENTECORREO" ;
      edtPacienteTelefono_Internalname = sPrefix+"PACIENTETELEFONO" ;
      edtPaisDescripcion_Internalname = sPrefix+"PAISDESCRIPCION" ;
      cmbPacienteEstado.setInternalname( sPrefix+"PACIENTEESTADO" );
      edtSecUserName_Internalname = sPrefix+"SECUSERNAME" ;
      edtUbigeoNombre_Internalname = sPrefix+"UBIGEONOMBRE" ;
      edtPacienteEstatura_Internalname = sPrefix+"PACIENTEESTATURA" ;
      edtPacientePeso_Internalname = sPrefix+"PACIENTEPESO" ;
      edtPacienteNombreAnexo_Internalname = sPrefix+"PACIENTENOMBREANEXO" ;
      edtPacienteAnexos_Internalname = sPrefix+"PACIENTEANEXOS" ;
      cmbPacienteEnterarse.setInternalname( sPrefix+"PACIENTEENTERARSE" );
      edtPacienteEspecifique_Internalname = sPrefix+"PACIENTEESPECIFIQUE" ;
      edtPacienteFechaRegistro_Internalname = sPrefix+"PACIENTEFECHAREGISTRO" ;
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
      edtPacienteFechaRegistro_Jsonclick = "" ;
      edtPacienteFechaRegistro_Enabled = 0 ;
      edtPacienteEspecifique_Enabled = 0 ;
      cmbPacienteEnterarse.setJsonclick( "" );
      cmbPacienteEnterarse.setEnabled( 0 );
      edtPacienteAnexos_Jsonclick = "" ;
      edtPacienteAnexos_Parameters = "" ;
      edtPacienteAnexos_Contenttype = "" ;
      edtPacienteAnexos_Filetype = "" ;
      edtPacienteAnexos_Enabled = 0 ;
      edtPacienteNombreAnexo_Jsonclick = "" ;
      edtPacienteNombreAnexo_Enabled = 0 ;
      edtPacientePeso_Jsonclick = "" ;
      edtPacientePeso_Enabled = 0 ;
      edtPacienteEstatura_Jsonclick = "" ;
      edtPacienteEstatura_Enabled = 0 ;
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoNombre_Link = "" ;
      edtUbigeoNombre_Enabled = 0 ;
      edtSecUserName_Jsonclick = "" ;
      edtSecUserName_Link = "" ;
      edtSecUserName_Enabled = 0 ;
      cmbPacienteEstado.setJsonclick( "" );
      cmbPacienteEstado.setEnabled( 0 );
      edtPaisDescripcion_Jsonclick = "" ;
      edtPaisDescripcion_Link = "" ;
      edtPaisDescripcion_Enabled = 0 ;
      edtPacienteTelefono_Jsonclick = "" ;
      edtPacienteTelefono_Enabled = 0 ;
      edtPacienteCorreo_Jsonclick = "" ;
      edtPacienteCorreo_Enabled = 0 ;
      cmbPacienteSexo.setJsonclick( "" );
      cmbPacienteSexo.setEnabled( 0 );
      edtPacienteDireccion_Enabled = 0 ;
      edtPacienteNroDocumento_Jsonclick = "" ;
      edtPacienteNroDocumento_Enabled = 0 ;
      cmbPacienteTipoDocumento.setJsonclick( "" );
      cmbPacienteTipoDocumento.setEnabled( 0 );
      edtPacienteFechaNacimiento_Jsonclick = "" ;
      edtPacienteFechaNacimiento_Enabled = 0 ;
      edtPacienteNombreCompleto_Jsonclick = "" ;
      edtPacienteNombreCompleto_Enabled = 0 ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteNombres_Enabled = 0 ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Enabled = 0 ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Enabled = 0 ;
      edtPacienteId_Jsonclick = "" ;
      edtPacienteId_Enabled = 0 ;
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
      cmbPacienteTipoDocumento.setName( "PACIENTETIPODOCUMENTO" );
      cmbPacienteTipoDocumento.setWebtags( "" );
      cmbPacienteTipoDocumento.addItem("1", "DNI", (short)(0));
      cmbPacienteTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbPacienteTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbPacienteTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbPacienteTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbPacienteTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbPacienteTipoDocumento.getItemCount() > 0 )
      {
      }
      cmbPacienteSexo.setName( "PACIENTESEXO" );
      cmbPacienteSexo.setWebtags( "" );
      cmbPacienteSexo.addItem("M", "Masculino", (short)(0));
      cmbPacienteSexo.addItem("F", "Femenino", (short)(0));
      if ( cmbPacienteSexo.getItemCount() > 0 )
      {
      }
      cmbPacienteEstado.setName( "PACIENTEESTADO" );
      cmbPacienteEstado.setWebtags( "" );
      cmbPacienteEstado.addItem("A", "Activo", (short)(0));
      cmbPacienteEstado.addItem("P", "Pendiente", (short)(0));
      cmbPacienteEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbPacienteEstado.getItemCount() > 0 )
      {
      }
      cmbPacienteEnterarse.setName( "PACIENTEENTERARSE" );
      cmbPacienteEnterarse.setWebtags( "" );
      cmbPacienteEnterarse.addItem("F", "Facebook", (short)(0));
      cmbPacienteEnterarse.addItem("G", "Búsqueda en Google", (short)(0));
      cmbPacienteEnterarse.addItem("T", "Twitter", (short)(0));
      cmbPacienteEnterarse.addItem("I", "Instagram", (short)(0));
      cmbPacienteEnterarse.addItem("L", "Linked In", (short)(0));
      cmbPacienteEnterarse.addItem("C", "Mediante conocido o familiar", (short)(0));
      cmbPacienteEnterarse.addItem("O", "Otros", (short)(0));
      if ( cmbPacienteEnterarse.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'DOUPDATE'","{handler:'e11521',iparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOUPDATE'",",oparms:[]}");
      setEventMetadata("'DODELETE'","{handler:'e12521',iparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DODELETE'",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEAPELLIDOPATERNO","{handler:'valid_Pacienteapellidopaterno',iparms:[]");
      setEventMetadata("VALID_PACIENTEAPELLIDOPATERNO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEAPELLIDOMATERNO","{handler:'valid_Pacienteapellidomaterno',iparms:[]");
      setEventMetadata("VALID_PACIENTEAPELLIDOMATERNO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTENOMBRES","{handler:'valid_Pacientenombres',iparms:[]");
      setEventMetadata("VALID_PACIENTENOMBRES",",oparms:[]}");
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
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      GX_FocusControl = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A212PacienteNombreCompleto = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A214PacienteTipoDocumento = "" ;
      A106PacienteNroDocumento = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A215PacienteDireccion = "" ;
      A216PacienteSexo = "" ;
      A217PacienteCorreo = "" ;
      gxphoneLink = "" ;
      A218PacienteTelefono = "" ;
      A184PaisDescripcion = "" ;
      A219PacienteEstado = "" ;
      A14SecUserName = "" ;
      A185UbigeoNombre = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A222PacienteNombreAnexo = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A223PacienteAnexos = "" ;
      A224PacienteEnterarse = "" ;
      A225PacienteEspecifique = "" ;
      A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
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
      H00522_A20PacienteId = new int[1] ;
      H00522_A43PaisId = new short[1] ;
      H00522_A6SecUserId = new short[1] ;
      H00522_n6SecUserId = new boolean[] {false} ;
      H00522_A44UbigeoCode = new String[] {""} ;
      H00522_n44UbigeoCode = new boolean[] {false} ;
      H00522_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      H00522_A225PacienteEspecifique = new String[] {""} ;
      H00522_n225PacienteEspecifique = new boolean[] {false} ;
      H00522_A224PacienteEnterarse = new String[] {""} ;
      H00522_n224PacienteEnterarse = new boolean[] {false} ;
      H00522_A223PacienteAnexos = new String[] {""} ;
      H00522_n223PacienteAnexos = new boolean[] {false} ;
      H00522_A222PacienteNombreAnexo = new String[] {""} ;
      H00522_n222PacienteNombreAnexo = new boolean[] {false} ;
      H00522_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00522_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00522_A14SecUserName = new String[] {""} ;
      H00522_A219PacienteEstado = new String[] {""} ;
      H00522_A184PaisDescripcion = new String[] {""} ;
      H00522_A218PacienteTelefono = new String[] {""} ;
      H00522_A217PacienteCorreo = new String[] {""} ;
      H00522_A216PacienteSexo = new String[] {""} ;
      H00522_A215PacienteDireccion = new String[] {""} ;
      H00522_A106PacienteNroDocumento = new String[] {""} ;
      H00522_A214PacienteTipoDocumento = new String[] {""} ;
      H00522_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      H00522_A105PacienteNombres = new String[] {""} ;
      H00522_A104PacienteApellidoMaterno = new String[] {""} ;
      H00522_A103PacienteApellidoPaterno = new String[] {""} ;
      H00522_A188UbigeoDistrito = new String[] {""} ;
      H00522_A187UbigeoProvincia = new String[] {""} ;
      H00522_A186UbigeoDepartamento = new String[] {""} ;
      A44UbigeoCode = "" ;
      AV6WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11HTTPRequest = httpContext.getHttpRequest();
      AV10Session = httpContext.getWebSession();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA20PacienteId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacientegeneral__default(),
         new Object[] {
             new Object[] {
            H00522_A20PacienteId, H00522_A43PaisId, H00522_A6SecUserId, H00522_n6SecUserId, H00522_A44UbigeoCode, H00522_n44UbigeoCode, H00522_A226PacienteFechaRegistro, H00522_A225PacienteEspecifique, H00522_n225PacienteEspecifique, H00522_A224PacienteEnterarse,
            H00522_n224PacienteEnterarse, H00522_A223PacienteAnexos, H00522_n223PacienteAnexos, H00522_A222PacienteNombreAnexo, H00522_n222PacienteNombreAnexo, H00522_A221PacientePeso, H00522_A220PacienteEstatura, H00522_A14SecUserName, H00522_A219PacienteEstado, H00522_A184PaisDescripcion,
            H00522_A218PacienteTelefono, H00522_A217PacienteCorreo, H00522_A216PacienteSexo, H00522_A215PacienteDireccion, H00522_A106PacienteNroDocumento, H00522_A214PacienteTipoDocumento, H00522_A213PacienteFechaNacimiento, H00522_A105PacienteNombres, H00522_A104PacienteApellidoMaterno, H00522_A103PacienteApellidoPaterno,
            H00522_A188UbigeoDistrito, H00522_A187UbigeoProvincia, H00522_A186UbigeoDepartamento
            }
         }
      );
      AV18Pgmname = "PacienteGeneral" ;
      /* GeneXus formulas. */
      AV18Pgmname = "PacienteGeneral" ;
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
   private short gxcookieaux ;
   private short Gx_err ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private int wcpOA20PacienteId ;
   private int A20PacienteId ;
   private int edtPacienteId_Enabled ;
   private int edtPacienteApellidoPaterno_Enabled ;
   private int edtPacienteApellidoMaterno_Enabled ;
   private int edtPacienteNombres_Enabled ;
   private int edtPacienteNombreCompleto_Enabled ;
   private int edtPacienteFechaNacimiento_Enabled ;
   private int edtPacienteNroDocumento_Enabled ;
   private int edtPacienteDireccion_Enabled ;
   private int edtPacienteCorreo_Enabled ;
   private int edtPacienteTelefono_Enabled ;
   private int edtPaisDescripcion_Enabled ;
   private int edtSecUserName_Enabled ;
   private int edtUbigeoNombre_Enabled ;
   private int edtPacienteEstatura_Enabled ;
   private int edtPacientePeso_Enabled ;
   private int edtPacienteNombreAnexo_Enabled ;
   private int edtPacienteAnexos_Enabled ;
   private int edtPacienteEspecifique_Enabled ;
   private int edtPacienteFechaRegistro_Enabled ;
   private int bttBtnupdate_Visible ;
   private int bttBtndelete_Visible ;
   private int idxLst ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
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
   private String edtPacienteId_Internalname ;
   private String edtPacienteId_Jsonclick ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtPacienteNombreCompleto_Internalname ;
   private String edtPacienteNombreCompleto_Jsonclick ;
   private String edtPacienteFechaNacimiento_Internalname ;
   private String edtPacienteFechaNacimiento_Jsonclick ;
   private String A214PacienteTipoDocumento ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtPacienteNroDocumento_Jsonclick ;
   private String edtPacienteDireccion_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String A216PacienteSexo ;
   private String edtPacienteCorreo_Internalname ;
   private String edtPacienteCorreo_Jsonclick ;
   private String edtPacienteTelefono_Internalname ;
   private String gxphoneLink ;
   private String A218PacienteTelefono ;
   private String edtPacienteTelefono_Jsonclick ;
   private String edtPaisDescripcion_Internalname ;
   private String edtPaisDescripcion_Link ;
   private String edtPaisDescripcion_Jsonclick ;
   private String A219PacienteEstado ;
   private String edtSecUserName_Internalname ;
   private String edtSecUserName_Link ;
   private String edtSecUserName_Jsonclick ;
   private String edtUbigeoNombre_Internalname ;
   private String edtUbigeoNombre_Link ;
   private String edtUbigeoNombre_Jsonclick ;
   private String edtPacienteEstatura_Internalname ;
   private String edtPacienteEstatura_Jsonclick ;
   private String edtPacientePeso_Internalname ;
   private String edtPacientePeso_Jsonclick ;
   private String edtPacienteNombreAnexo_Internalname ;
   private String edtPacienteNombreAnexo_Jsonclick ;
   private String edtPacienteAnexos_Internalname ;
   private String edtPacienteAnexos_Filetype ;
   private String edtPacienteAnexos_Contenttype ;
   private String edtPacienteAnexos_Parameters ;
   private String edtPacienteAnexos_Jsonclick ;
   private String edtPacienteEspecifique_Internalname ;
   private String edtPacienteFechaRegistro_Internalname ;
   private String edtPacienteFechaRegistro_Jsonclick ;
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
   private String A44UbigeoCode ;
   private String sCtrlA20PacienteId ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean n223PacienteAnexos ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n224PacienteEnterarse ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n6SecUserId ;
   private boolean n44UbigeoCode ;
   private boolean n225PacienteEspecifique ;
   private boolean n222PacienteNombreAnexo ;
   private boolean returnInSub ;
   private boolean AV13TempBoolean ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String A225PacienteEspecifique ;
   private String A223PacienteAnexos ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A212PacienteNombreCompleto ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private String A217PacienteCorreo ;
   private String A184PaisDescripcion ;
   private String A14SecUserName ;
   private String A185UbigeoNombre ;
   private String A222PacienteNombreAnexo ;
   private String A224PacienteEnterarse ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV11HTTPRequest ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private HTMLChoice cmbPacienteTipoDocumento ;
   private HTMLChoice cmbPacienteSexo ;
   private HTMLChoice cmbPacienteEstado ;
   private HTMLChoice cmbPacienteEnterarse ;
   private IDataStoreProvider pr_default ;
   private int[] H00522_A20PacienteId ;
   private short[] H00522_A43PaisId ;
   private short[] H00522_A6SecUserId ;
   private boolean[] H00522_n6SecUserId ;
   private String[] H00522_A44UbigeoCode ;
   private boolean[] H00522_n44UbigeoCode ;
   private java.util.Date[] H00522_A226PacienteFechaRegistro ;
   private String[] H00522_A225PacienteEspecifique ;
   private boolean[] H00522_n225PacienteEspecifique ;
   private String[] H00522_A224PacienteEnterarse ;
   private boolean[] H00522_n224PacienteEnterarse ;
   private String[] H00522_A223PacienteAnexos ;
   private boolean[] H00522_n223PacienteAnexos ;
   private String[] H00522_A222PacienteNombreAnexo ;
   private boolean[] H00522_n222PacienteNombreAnexo ;
   private java.math.BigDecimal[] H00522_A221PacientePeso ;
   private java.math.BigDecimal[] H00522_A220PacienteEstatura ;
   private String[] H00522_A14SecUserName ;
   private String[] H00522_A219PacienteEstado ;
   private String[] H00522_A184PaisDescripcion ;
   private String[] H00522_A218PacienteTelefono ;
   private String[] H00522_A217PacienteCorreo ;
   private String[] H00522_A216PacienteSexo ;
   private String[] H00522_A215PacienteDireccion ;
   private String[] H00522_A106PacienteNroDocumento ;
   private String[] H00522_A214PacienteTipoDocumento ;
   private java.util.Date[] H00522_A213PacienteFechaNacimiento ;
   private String[] H00522_A105PacienteNombres ;
   private String[] H00522_A104PacienteApellidoMaterno ;
   private String[] H00522_A103PacienteApellidoPaterno ;
   private String[] H00522_A188UbigeoDistrito ;
   private String[] H00522_A187UbigeoProvincia ;
   private String[] H00522_A186UbigeoDepartamento ;
   private com.genexus.webpanels.WebSession AV10Session ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
}

final  class pacientegeneral__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00522", "SELECT T1.[PacienteId], T1.[PaisId], T1.[SecUserId], T1.[UbigeoCode], T1.[PacienteFechaRegistro], T1.[PacienteEspecifique], T1.[PacienteEnterarse], T1.[PacienteAnexos], T1.[PacienteNombreAnexo], T1.[PacientePeso], T1.[PacienteEstatura], T3.[SecUserName], T1.[PacienteEstado], T2.[PaisDescripcion], T1.[PacienteTelefono], T1.[PacienteCorreo], T1.[PacienteSexo], T1.[PacienteDireccion], T1.[PacienteNroDocumento], T1.[PacienteTipoDocumento], T1.[PacienteFechaNacimiento], T1.[PacienteNombres], T1.[PacienteApellidoMaterno], T1.[PacienteApellidoPaterno], T4.[UbigeoDistrito], T4.[UbigeoProvincia], T4.[UbigeoDepartamento] FROM ((([Paciente] T1 INNER JOIN [Pais] T2 ON T2.[PaisId] = T1.[PaisId]) LEFT JOIN [SecUser] T3 ON T3.[SecUserId] = T1.[SecUserId]) LEFT JOIN [Ubigeo] T4 ON T4.[UbigeoCode] = T1.[UbigeoCode]) WHERE T1.[PacienteId] = ? ORDER BY T1.[PacienteId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDateTime(5);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getBLOBFile(8, "tmp", "");
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[16])[0] = rslt.getBigDecimal(11,2);
               ((String[]) buf[17])[0] = rslt.getVarchar(12);
               ((String[]) buf[18])[0] = rslt.getString(13, 1);
               ((String[]) buf[19])[0] = rslt.getVarchar(14);
               ((String[]) buf[20])[0] = rslt.getString(15, 20);
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getString(17, 1);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getString(20, 1);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(21);
               ((String[]) buf[27])[0] = rslt.getVarchar(22);
               ((String[]) buf[28])[0] = rslt.getVarchar(23);
               ((String[]) buf[29])[0] = rslt.getVarchar(24);
               ((String[]) buf[30])[0] = rslt.getVarchar(25);
               ((String[]) buf[31])[0] = rslt.getVarchar(26);
               ((String[]) buf[32])[0] = rslt.getVarchar(27);
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

