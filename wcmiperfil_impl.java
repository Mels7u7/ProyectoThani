package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wcmiperfil_impl extends GXWebComponent
{
   public wcmiperfil_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wcmiperfil_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wcmiperfil_impl.class ));
   }

   public wcmiperfil_impl( int remoteHandle ,
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
      cmbavPacientetipodocumento = new HTMLChoice();
      cmbavPacientesexo = new HTMLChoice();
      cmbavMes = new HTMLChoice();
      cmbavDia = new HTMLChoice();
      cmbavAnio = new HTMLChoice();
      dynavPacientenacionalidad = new HTMLChoice();
      cmbavPacientedepartamento = new HTMLChoice();
      dynavPacienteprovincia = new HTMLChoice();
      dynavPacientedistrito = new HTMLChoice();
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
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPACIENTENACIONALIDAD") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvvpacientenacionalidad512( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPACIENTEPROVINCIA") == 0 )
            {
               AV20PacienteDepartamento = httpContext.GetPar( "PacienteDepartamento") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20PacienteDepartamento", AV20PacienteDepartamento);
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvvpacienteprovincia512( AV20PacienteDepartamento) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPACIENTEDISTRITO") == 0 )
            {
               AV20PacienteDepartamento = httpContext.GetPar( "PacienteDepartamento") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20PacienteDepartamento", AV20PacienteDepartamento);
               AV32PacienteProvincia = httpContext.GetPar( "PacienteProvincia") ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32PacienteProvincia", AV32PacienteProvincia);
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxdlvvpacientedistrito512( AV20PacienteDepartamento, AV32PacienteProvincia) ;
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
         pa512( ) ;
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
         httpContext.writeValue( "WCMi Perfil") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110322098", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wcmiperfil", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAISID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV49PaisId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPATTERN", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV37Pattern, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"WCMiPerfil");
      forbiddenHiddens.add("Mes", GXutil.rtrim( localUtil.format( AV14Mes, "")));
      forbiddenHiddens.add("Anio", localUtil.format( DecimalUtil.doubleToDec(AV5Anio), "ZZZ9"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wcmiperfil:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAISID", GXutil.ltrim( localUtil.ntoc( AV49PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAISID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV49PaisId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPATTERN", AV37Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPATTERN", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV37Pattern, ""))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vMENSAJE", AV12Mensaje);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vMENSAJE", AV12Mensaje);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vUBIGEOCODE", GXutil.rtrim( AV44UbigeoCode));
   }

   public void renderHtmlCloseForm512( )
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
      return "WCMiPerfil" ;
   }

   public String getPgmdesc( )
   {
      return "WCMi Perfil" ;
   }

   public void wb510( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.wcmiperfil");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSectiontitlecitas_Internalname, 1, 0, "px", 0, "px", "SeccionCitas", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "Mi Perfil", "", "", lblTextblock1_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlockCitas", 0, "", 1, 1, 0, (short)(0), "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TablePerfilPacienteGen", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup2_Internalname, "INFORMACIÓN GENERAL", 1, 0, "px", 0, "px", "GroupHPPEditarPaciente", "", "HLP_WCMiPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientenombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientenombres_Internalname, "Nombres", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientenombres_Internalname, AV28PacienteNombres, GXutil.rtrim( localUtil.format( AV28PacienteNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientenombres_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacientenombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacienteapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacienteapellidopaterno_Internalname, "Apellido Paterno", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacienteapellidopaterno_Internalname, AV18PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( AV18PacienteApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacienteapellidopaterno_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacienteapellidopaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacienteapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacienteapellidomaterno_Internalname, "Apellido Materno", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 30,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacienteapellidomaterno_Internalname, AV17PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( AV17PacienteApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,30);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacienteapellidomaterno_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacienteapellidomaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientetipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientetipodocumento.getInternalname(), "Tipo Documento", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientetipodocumento, cmbavPacientetipodocumento.getInternalname(), GXutil.rtrim( AV35PacienteTipoDocumento), 1, cmbavPacientetipodocumento.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPacientetipodocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         cmbavPacientetipodocumento.setValue( GXutil.rtrim( AV35PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientetipodocumento.getInternalname(), "Values", cmbavPacientetipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientenrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientenrodocumento_Internalname, "Nro Documento", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientenrodocumento_Internalname, AV29PacienteNroDocumento, GXutil.rtrim( localUtil.format( AV29PacienteNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,39);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientenrodocumento_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacientenrodocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientesexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientesexo.getInternalname(), "Sexo", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientesexo, cmbavPacientesexo.getInternalname(), GXutil.rtrim( AV33PacienteSexo), 1, cmbavPacientesexo.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavPacientesexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         cmbavPacientesexo.setValue( GXutil.rtrim( AV33PacienteSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientesexo.getInternalname(), "Values", cmbavPacientesexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup1_Internalname, "Fecha Nacimiento", 1, 0, "px", 0, "px", "GroupFechaNaciento", "", "HLP_WCMiPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavMes.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavMes.getInternalname(), "Mes", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavMes, cmbavMes.getInternalname(), GXutil.rtrim( AV14Mes), 1, cmbavMes.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         cmbavMes.setValue( GXutil.rtrim( AV14Mes) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavDia.getInternalname(), "Día", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDia, cmbavDia.getInternalname(), GXutil.trim( GXutil.str( AV7Dia, 4, 0)), 1, cmbavDia.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavDia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,56);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV7Dia, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavAnio.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavAnio.getInternalname(), "Año", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavAnio, cmbavAnio.getInternalname(), GXutil.trim( GXutil.str( AV5Anio, 4, 0)), 1, cmbavAnio.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavAnio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,60);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         cmbavAnio.setValue( GXutil.trim( GXutil.str( AV5Anio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavAnio.getInternalname(), "Values", cmbavAnio.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPacientenacionalidad.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPacientenacionalidad.getInternalname(), "Nacionalidad", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPacientenacionalidad, dynavPacientenacionalidad.getInternalname(), GXutil.trim( GXutil.str( AV27PacienteNacionalidad, 4, 0)), 1, dynavPacientenacionalidad.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavPacientenacionalidad.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         dynavPacientenacionalidad.setValue( GXutil.trim( GXutil.str( AV27PacienteNacionalidad, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientenacionalidad.getInternalname(), "Values", dynavPacientenacionalidad.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientetelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientetelefono_Internalname, "Teléfono", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientetelefono_Internalname, GXutil.rtrim( AV34PacienteTelefono), GXutil.rtrim( localUtil.format( AV34PacienteTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientetelefono_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacientetelefono_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacienteestatura_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacienteestatura_Internalname, "Estatura", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacienteestatura_Internalname, GXutil.ltrim( localUtil.ntoc( AV24PacienteEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( localUtil.format( AV24PacienteEstatura, "9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,73);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacienteestatura_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacienteestatura_Enabled, 1, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientepeso_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientepeso_Internalname, "Peso", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientepeso_Internalname, GXutil.ltrim( localUtil.ntoc( AV31PacientePeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( localUtil.format( AV31PacientePeso, "ZZ9.99")), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,77);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientepeso_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacientepeso_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacienteemail_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacienteemail_Internalname, "Email", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacienteemail_Internalname, AV23PacienteEmail, GXutil.rtrim( localUtil.format( AV23PacienteEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "mailto:"+AV23PacienteEmail, "", "", "", edtavPacienteemail_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacienteemail_Enabled, 1, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_WCMiPerfil.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup4_Internalname, "UBICACIÓN DE RESIDENCIA", 1, 0, "px", 0, "px", "GroupHPPEditarPaciente", "", "HLP_WCMiPerfil.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup4table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavPacientedireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPacientedireccion_Internalname, "Dirección", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'" + sPrefix + "',false,'',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPacientedireccion_Internalname, AV21PacienteDireccion, GXutil.rtrim( localUtil.format( AV21PacienteDireccion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,91);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPacientedireccion_Jsonclick, 0, "AttEditarPaciente", "", "", "", "", 1, edtavPacientedireccion_Enabled, 1, "text", "", 80, "chr", 1, "row", 500, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientedepartamento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientedepartamento.getInternalname(), "Departamento", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientedepartamento, cmbavPacientedepartamento.getInternalname(), GXutil.rtrim( AV20PacienteDepartamento), 1, cmbavPacientedepartamento.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavPacientedepartamento.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,96);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         cmbavPacientedepartamento.setValue( GXutil.rtrim( AV20PacienteDepartamento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientedepartamento.getInternalname(), "Values", cmbavPacientedepartamento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPacienteprovincia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPacienteprovincia.getInternalname(), "Provincia", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPacienteprovincia, dynavPacienteprovincia.getInternalname(), GXutil.rtrim( AV32PacienteProvincia), 1, dynavPacienteprovincia.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavPacienteprovincia.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,100);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacienteprovincia.getInternalname(), "Values", dynavPacienteprovincia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPacientedistrito.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPacientedistrito.getInternalname(), "Distrito", "col-xs-12 AttEditarPacienteLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPacientedistrito, dynavPacientedistrito.getInternalname(), GXutil.rtrim( AV22PacienteDistrito), 1, dynavPacientedistrito.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavPacientedistrito.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttEditarPaciente", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,104);\"", "", true, (byte)(1), "HLP_WCMiPerfil.htm");
         dynavPacientedistrito.setValue( GXutil.rtrim( AV22PacienteDistrito) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableSeparadorBtnRP", "Center", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 110,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMiPerfilHomePage" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttGuardar_Internalname, "", "Guardar", bttGuardar_Jsonclick, 5, "Guardar", "", StyleString, ClassString, bttGuardar_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+sPrefix+"E\\'GUARDAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMiPerfilHomePage" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttActualizar_Internalname, "", "Editar", bttActualizar_Jsonclick, 7, "Editar", "", StyleString, ClassString, bttActualizar_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e11511_client"+"'", TempTags, "", 2, "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "ButtonMiPerfilHomePage" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "", "Cancelar", bttBtncancel_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, bttBtncancel_Visible, 1, "standard", "'"+sPrefix+"'"+",false,"+"'"+"e12511_client"+"'", TempTags, "", 2, "HLP_WCMiPerfil.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
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

   public void start512( )
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
            Form.getMeta().addItem("description", "WCMi Perfil", (short)(0)) ;
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
            strup510( ) ;
         }
      }
   }

   public void ws512( )
   {
      start512( ) ;
      evt512( ) ;
   }

   public void evt512( )
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
                              strup510( ) ;
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
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e13512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VANIO.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e14512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VMES.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e15512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "'GUARDAR'") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: 'Guardar' */
                                 e16512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e17512 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup510( ) ;
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
                              strup510( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavPacientenombres_Internalname ;
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

   public void we512( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm512( ) ;
         }
      }
   }

   public void pa512( )
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
            GX_FocusControl = edtavPacientenombres_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlvvpacientenacionalidad512( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpacientenacionalidad_data512( ) ;
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

   public void gxvvpacientenacionalidad_html512( )
   {
      short gxdynajaxvalue;
      gxdlvvpacientenacionalidad_data512( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPacientenacionalidad.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavPacientenacionalidad.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpacientenacionalidad_data512( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H00512 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H00512_A43PaisId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H00512_A184PaisDescripcion[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvpacienteprovincia512( String AV20PacienteDepartamento )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpacienteprovincia_data512( AV20PacienteDepartamento) ;
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

   public void gxvvpacienteprovincia_html512( String AV20PacienteDepartamento )
   {
      String gxdynajaxvalue;
      gxdlvvpacienteprovincia_data512( AV20PacienteDepartamento) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPacienteprovincia.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavPacienteprovincia.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpacienteprovincia_data512( String AV20PacienteDepartamento )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H00513 */
      pr_default.execute(1, new Object[] {AV20PacienteDepartamento});
      while ( (pr_default.getStatus(1) != 101) )
      {
         if ( GXutil.strcmp(H00513_A295UbigeoDepartamentoCode[0], AV20PacienteDepartamento) == 0 )
         {
            gxdynajaxctrlcodr.add(H00513_A296UbigeoProvinciaCode[0]);
            gxdynajaxctrldescr.add(H00513_A187UbigeoProvincia[0]);
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvvpacientedistrito512( String AV20PacienteDepartamento ,
                                          String AV32PacienteProvincia )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpacientedistrito_data512( AV20PacienteDepartamento, AV32PacienteProvincia) ;
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

   public void gxvvpacientedistrito_html512( String AV20PacienteDepartamento ,
                                             String AV32PacienteProvincia )
   {
      String gxdynajaxvalue;
      gxdlvvpacientedistrito_data512( AV20PacienteDepartamento, AV32PacienteProvincia) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPacientedistrito.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavPacientedistrito.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpacientedistrito_data512( String AV20PacienteDepartamento ,
                                                  String AV32PacienteProvincia )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H00514 */
      pr_default.execute(2, new Object[] {AV20PacienteDepartamento, AV32PacienteProvincia});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(H00514_A297UbigeoDistritoCode[0]);
         gxdynajaxctrldescr.add(H00514_A188UbigeoDistrito[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvpacientenacionalidad_html512( ) ;
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavPacientetipodocumento.getItemCount() > 0 )
      {
         AV35PacienteTipoDocumento = cmbavPacientetipodocumento.getValidValue(AV35PacienteTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35PacienteTipoDocumento", AV35PacienteTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientetipodocumento.setValue( GXutil.rtrim( AV35PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientetipodocumento.getInternalname(), "Values", cmbavPacientetipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavPacientesexo.getItemCount() > 0 )
      {
         AV33PacienteSexo = cmbavPacientesexo.getValidValue(AV33PacienteSexo) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33PacienteSexo", AV33PacienteSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientesexo.setValue( GXutil.rtrim( AV33PacienteSexo) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientesexo.getInternalname(), "Values", cmbavPacientesexo.ToJavascriptSource(), true);
      }
      if ( cmbavMes.getItemCount() > 0 )
      {
         AV14Mes = cmbavMes.getValidValue(AV14Mes) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Mes", AV14Mes);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavMes.setValue( GXutil.rtrim( AV14Mes) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavMes.getInternalname(), "Values", cmbavMes.ToJavascriptSource(), true);
      }
      if ( cmbavDia.getItemCount() > 0 )
      {
         AV7Dia = (short)(GXutil.lval( cmbavDia.getValidValue(GXutil.trim( GXutil.str( AV7Dia, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Dia), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDia.setValue( GXutil.trim( GXutil.str( AV7Dia, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
      }
      if ( cmbavAnio.getItemCount() > 0 )
      {
         AV5Anio = (short)(GXutil.lval( cmbavAnio.getValidValue(GXutil.trim( GXutil.str( AV5Anio, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5Anio), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavAnio.setValue( GXutil.trim( GXutil.str( AV5Anio, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavAnio.getInternalname(), "Values", cmbavAnio.ToJavascriptSource(), true);
      }
      if ( dynavPacientenacionalidad.getItemCount() > 0 )
      {
         AV27PacienteNacionalidad = (short)(GXutil.lval( dynavPacientenacionalidad.getValidValue(GXutil.trim( GXutil.str( AV27PacienteNacionalidad, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27PacienteNacionalidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PacienteNacionalidad), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientenacionalidad.setValue( GXutil.trim( GXutil.str( AV27PacienteNacionalidad, 4, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientenacionalidad.getInternalname(), "Values", dynavPacientenacionalidad.ToJavascriptSource(), true);
      }
      if ( cmbavPacientedepartamento.getItemCount() > 0 )
      {
         AV20PacienteDepartamento = cmbavPacientedepartamento.getValidValue(AV20PacienteDepartamento) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20PacienteDepartamento", AV20PacienteDepartamento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientedepartamento.setValue( GXutil.rtrim( AV20PacienteDepartamento) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientedepartamento.getInternalname(), "Values", cmbavPacientedepartamento.ToJavascriptSource(), true);
      }
      if ( dynavPacienteprovincia.getItemCount() > 0 )
      {
         AV32PacienteProvincia = dynavPacienteprovincia.getValidValue(AV32PacienteProvincia) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32PacienteProvincia", AV32PacienteProvincia);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacienteprovincia.getInternalname(), "Values", dynavPacienteprovincia.ToJavascriptSource(), true);
      }
      if ( dynavPacientedistrito.getItemCount() > 0 )
      {
         AV22PacienteDistrito = dynavPacientedistrito.getValidValue(AV22PacienteDistrito) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22PacienteDistrito", AV22PacienteDistrito);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientedistrito.setValue( GXutil.rtrim( AV22PacienteDistrito) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf512( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavPacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientenombres_Enabled), 5, 0), true);
      edtavPacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteapellidopaterno_Enabled), 5, 0), true);
      edtavPacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteapellidomaterno_Enabled), 5, 0), true);
      cmbavPacientetipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientetipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavPacientetipodocumento.getEnabled(), 5, 0), true);
      edtavPacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientenrodocumento_Enabled), 5, 0), true);
      cmbavPacientesexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientesexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavPacientesexo.getEnabled(), 5, 0), true);
      cmbavMes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavMes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMes.getEnabled(), 5, 0), true);
      cmbavDia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavDia.getEnabled(), 5, 0), true);
      cmbavAnio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavAnio.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAnio.getEnabled(), 5, 0), true);
      dynavPacientenacionalidad.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientenacionalidad.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacientenacionalidad.getEnabled(), 5, 0), true);
      edtavPacientetelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientetelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientetelefono_Enabled), 5, 0), true);
      edtavPacienteestatura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteestatura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteestatura_Enabled), 5, 0), true);
      edtavPacientepeso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientepeso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientepeso_Enabled), 5, 0), true);
      edtavPacienteemail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteemail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteemail_Enabled), 5, 0), true);
      edtavPacientedireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientedireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientedireccion_Enabled), 5, 0), true);
      cmbavPacientedepartamento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientedepartamento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavPacientedepartamento.getEnabled(), 5, 0), true);
      dynavPacienteprovincia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacienteprovincia.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacienteprovincia.getEnabled(), 5, 0), true);
      dynavPacientedistrito.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientedistrito.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacientedistrito.getEnabled(), 5, 0), true);
   }

   public void rf512( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e17512 ();
         wb510( ) ;
      }
   }

   public void send_integrity_lvl_hashes512( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPAISID", GXutil.ltrim( localUtil.ntoc( AV49PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPAISID", getSecureSignedToken( sPrefix, localUtil.format( DecimalUtil.doubleToDec(AV49PaisId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vPATTERN", AV37Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPATTERN", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV37Pattern, ""))));
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavPacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientenombres_Enabled), 5, 0), true);
      edtavPacienteapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteapellidopaterno_Enabled), 5, 0), true);
      edtavPacienteapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteapellidomaterno_Enabled), 5, 0), true);
      cmbavPacientetipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientetipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavPacientetipodocumento.getEnabled(), 5, 0), true);
      edtavPacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientenrodocumento_Enabled), 5, 0), true);
      cmbavPacientesexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientesexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavPacientesexo.getEnabled(), 5, 0), true);
      cmbavMes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavMes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavMes.getEnabled(), 5, 0), true);
      cmbavDia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavDia.getEnabled(), 5, 0), true);
      cmbavAnio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavAnio.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavAnio.getEnabled(), 5, 0), true);
      dynavPacientenacionalidad.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientenacionalidad.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacientenacionalidad.getEnabled(), 5, 0), true);
      edtavPacientetelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientetelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientetelefono_Enabled), 5, 0), true);
      edtavPacienteestatura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteestatura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteestatura_Enabled), 5, 0), true);
      edtavPacientepeso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientepeso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientepeso_Enabled), 5, 0), true);
      edtavPacienteemail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteemail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteemail_Enabled), 5, 0), true);
      edtavPacientedireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientedireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientedireccion_Enabled), 5, 0), true);
      cmbavPacientedepartamento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientedepartamento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavPacientedepartamento.getEnabled(), 5, 0), true);
      dynavPacienteprovincia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacienteprovincia.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacienteprovincia.getEnabled(), 5, 0), true);
      dynavPacientedistrito.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientedistrito.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacientedistrito.getEnabled(), 5, 0), true);
      gxvvpacientenacionalidad_html512( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strup510( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13512 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvpacienteprovincia_html512( AV20PacienteDepartamento) ;
      gxvvpacientedistrito_html512( AV20PacienteDepartamento, AV32PacienteProvincia) ;
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV28PacienteNombres = httpContext.cgiGet( edtavPacientenombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28PacienteNombres", AV28PacienteNombres);
         AV18PacienteApellidoPaterno = httpContext.cgiGet( edtavPacienteapellidopaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18PacienteApellidoPaterno", AV18PacienteApellidoPaterno);
         AV17PacienteApellidoMaterno = httpContext.cgiGet( edtavPacienteapellidomaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17PacienteApellidoMaterno", AV17PacienteApellidoMaterno);
         cmbavPacientetipodocumento.setValue( httpContext.cgiGet( cmbavPacientetipodocumento.getInternalname()) );
         AV35PacienteTipoDocumento = httpContext.cgiGet( cmbavPacientetipodocumento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35PacienteTipoDocumento", AV35PacienteTipoDocumento);
         AV29PacienteNroDocumento = httpContext.cgiGet( edtavPacientenrodocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29PacienteNroDocumento", AV29PacienteNroDocumento);
         cmbavPacientesexo.setValue( httpContext.cgiGet( cmbavPacientesexo.getInternalname()) );
         AV33PacienteSexo = httpContext.cgiGet( cmbavPacientesexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33PacienteSexo", AV33PacienteSexo);
         cmbavMes.setValue( httpContext.cgiGet( cmbavMes.getInternalname()) );
         AV14Mes = httpContext.cgiGet( cmbavMes.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Mes", AV14Mes);
         cmbavDia.setValue( httpContext.cgiGet( cmbavDia.getInternalname()) );
         AV7Dia = (short)(GXutil.lval( httpContext.cgiGet( cmbavDia.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Dia), 4, 0));
         cmbavAnio.setValue( httpContext.cgiGet( cmbavAnio.getInternalname()) );
         AV5Anio = (short)(GXutil.lval( httpContext.cgiGet( cmbavAnio.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5Anio), 4, 0));
         dynavPacientenacionalidad.setValue( httpContext.cgiGet( dynavPacientenacionalidad.getInternalname()) );
         AV27PacienteNacionalidad = (short)(GXutil.lval( httpContext.cgiGet( dynavPacientenacionalidad.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27PacienteNacionalidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PacienteNacionalidad), 4, 0));
         AV34PacienteTelefono = httpContext.cgiGet( edtavPacientetelefono_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34PacienteTelefono", AV34PacienteTelefono);
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavPacienteestatura_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavPacienteestatura_Internalname)), DecimalUtil.stringToDec("9.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPACIENTEESTATURA");
            GX_FocusControl = edtavPacienteestatura_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV24PacienteEstatura = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24PacienteEstatura", GXutil.ltrimstr( AV24PacienteEstatura, 4, 2));
         }
         else
         {
            AV24PacienteEstatura = localUtil.ctond( httpContext.cgiGet( edtavPacienteestatura_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24PacienteEstatura", GXutil.ltrimstr( AV24PacienteEstatura, 4, 2));
         }
         if ( ( ( localUtil.ctond( httpContext.cgiGet( edtavPacientepeso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavPacientepeso_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vPACIENTEPESO");
            GX_FocusControl = edtavPacientepeso_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV31PacientePeso = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31PacientePeso", GXutil.ltrimstr( AV31PacientePeso, 6, 2));
         }
         else
         {
            AV31PacientePeso = localUtil.ctond( httpContext.cgiGet( edtavPacientepeso_Internalname)) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31PacientePeso", GXutil.ltrimstr( AV31PacientePeso, 6, 2));
         }
         AV23PacienteEmail = httpContext.cgiGet( edtavPacienteemail_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23PacienteEmail", AV23PacienteEmail);
         AV21PacienteDireccion = httpContext.cgiGet( edtavPacientedireccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21PacienteDireccion", AV21PacienteDireccion);
         cmbavPacientedepartamento.setValue( httpContext.cgiGet( cmbavPacientedepartamento.getInternalname()) );
         AV20PacienteDepartamento = httpContext.cgiGet( cmbavPacientedepartamento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20PacienteDepartamento", AV20PacienteDepartamento);
         dynavPacienteprovincia.setValue( httpContext.cgiGet( dynavPacienteprovincia.getInternalname()) );
         AV32PacienteProvincia = httpContext.cgiGet( dynavPacienteprovincia.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32PacienteProvincia", AV32PacienteProvincia);
         dynavPacientedistrito.setValue( httpContext.cgiGet( dynavPacientedistrito.getInternalname()) );
         AV22PacienteDistrito = httpContext.cgiGet( dynavPacientedistrito.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22PacienteDistrito", AV22PacienteDistrito);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", sPrefix+"hsh"+"WCMiPerfil");
         AV14Mes = httpContext.cgiGet( cmbavMes.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Mes", AV14Mes);
         forbiddenHiddens.add("Mes", GXutil.rtrim( localUtil.format( AV14Mes, "")));
         AV5Anio = (short)(GXutil.lval( httpContext.cgiGet( cmbavAnio.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5Anio), 4, 0));
         forbiddenHiddens.add("Anio", localUtil.format( DecimalUtil.doubleToDec(AV5Anio), "ZZZ9"));
         hsh = httpContext.cgiGet( sPrefix+"hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("wcmiperfil:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
         }
         gxvvpacientenacionalidad_html512( ) ;
         gxvvpacienteprovincia_html512( AV20PacienteDepartamento) ;
         gxvvpacientedistrito_html512( AV20PacienteDepartamento, AV32PacienteProvincia) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e13512 ();
      if (returnInSub) return;
   }

   public void e13512( )
   {
      /* Start Routine */
      returnInSub = false ;
      bttGuardar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttGuardar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGuardar_Visible), 5, 0), true);
      bttBtncancel_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtncancel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtncancel_Visible), 5, 0), true);
      AV26PacienteId = (int)(GXutil.lval( AV46WebSession.getValue("WSPacienteId"))) ;
      AV16Paciente.Load(AV26PacienteId);
      AV28PacienteNombres = AV16Paciente.getgxTv_SdtPaciente_Pacientenombres() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV28PacienteNombres", AV28PacienteNombres);
      AV18PacienteApellidoPaterno = AV16Paciente.getgxTv_SdtPaciente_Pacienteapellidopaterno() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV18PacienteApellidoPaterno", AV18PacienteApellidoPaterno);
      AV17PacienteApellidoMaterno = AV16Paciente.getgxTv_SdtPaciente_Pacienteapellidomaterno() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17PacienteApellidoMaterno", AV17PacienteApellidoMaterno);
      AV29PacienteNroDocumento = AV16Paciente.getgxTv_SdtPaciente_Pacientenrodocumento() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV29PacienteNroDocumento", AV29PacienteNroDocumento);
      AV35PacienteTipoDocumento = AV16Paciente.getgxTv_SdtPaciente_Pacientetipodocumento() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV35PacienteTipoDocumento", AV35PacienteTipoDocumento);
      AV33PacienteSexo = AV16Paciente.getgxTv_SdtPaciente_Pacientesexo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV33PacienteSexo", AV33PacienteSexo);
      AV34PacienteTelefono = AV16Paciente.getgxTv_SdtPaciente_Pacientetelefono() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV34PacienteTelefono", AV34PacienteTelefono);
      AV21PacienteDireccion = AV16Paciente.getgxTv_SdtPaciente_Pacientedireccion() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV21PacienteDireccion", AV21PacienteDireccion);
      AV23PacienteEmail = AV16Paciente.getgxTv_SdtPaciente_Pacientecorreo() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV23PacienteEmail", AV23PacienteEmail);
      AV24PacienteEstatura = AV16Paciente.getgxTv_SdtPaciente_Pacienteestatura() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV24PacienteEstatura", GXutil.ltrimstr( AV24PacienteEstatura, 4, 2));
      AV31PacientePeso = AV16Paciente.getgxTv_SdtPaciente_Pacientepeso() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV31PacientePeso", GXutil.ltrimstr( AV31PacientePeso, 6, 2));
      AV5Anio = (short)(GXutil.year( AV16Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento())) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV5Anio", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5Anio), 4, 0));
      AV7Dia = (short)(GXutil.day( AV16Paciente.getgxTv_SdtPaciente_Pacientefechanacimiento())) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Dia), 4, 0));
      AV14Mes = GXutil.str( 0, 10, 0) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV14Mes", AV14Mes);
      AV27PacienteNacionalidad = AV16Paciente.getgxTv_SdtPaciente_Paisid() ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV27PacienteNacionalidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27PacienteNacionalidad), 4, 0));
      /* Using cursor H00515 */
      pr_default.execute(3, new Object[] {AV16Paciente.getgxTv_SdtPaciente_Ubigeocode()});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A44UbigeoCode = H00515_A44UbigeoCode[0] ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
         AV38Provincia = A296UbigeoProvinciaCode ;
         AV9Distrito = A297UbigeoDistritoCode ;
         AV6Departamento = A295UbigeoDepartamentoCode ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(3);
      AV20PacienteDepartamento = AV6Departamento ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20PacienteDepartamento", AV20PacienteDepartamento);
      AV22PacienteDistrito = AV9Distrito ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22PacienteDistrito", AV22PacienteDistrito);
      AV32PacienteProvincia = AV38Provincia ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32PacienteProvincia", AV32PacienteProvincia);
      AV37Pattern = "^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV37Pattern", AV37Pattern);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vPATTERN", getSecureSignedToken( sPrefix, GXutil.rtrim( localUtil.format( AV37Pattern, ""))));
      AV11i = (short)(GXutil.year( GXutil.addyr( Gx_date, (short)(-18)))) ;
      cmbavAnio.removeAllItems();
      while ( AV11i > GXutil.year( GXutil.addyr( Gx_date, (short)(-18))) - 92 )
      {
         cmbavAnio.addItem(GXutil.trim( GXutil.str( AV11i, 4, 0)), GXutil.str( AV11i, 10, 0), (short)(0));
         AV11i = (short)(AV11i-1) ;
      }
      /* Execute user subroutine: 'SHOWDAYS' */
      S112 ();
      if (returnInSub) return;
      /* Using cursor H00516 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         A186UbigeoDepartamento = H00516_A186UbigeoDepartamento[0] ;
         A295UbigeoDepartamentoCode = H00516_A295UbigeoDepartamentoCode[0] ;
         A44UbigeoCode = H00516_A44UbigeoCode[0] ;
         cmbavPacientedepartamento.addItem(A295UbigeoDepartamentoCode, A186UbigeoDepartamento, (short)(0));
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void e14512( )
   {
      /* Anio_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SHOWDAYS' */
      S112 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV7Dia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void e15512( )
   {
      /* Mes_Controlvaluechanged Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'SHOWDAYS' */
      S112 ();
      if (returnInSub) return;
      AV7Dia = (short)(1) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7Dia", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7Dia), 4, 0));
      /*  Sending Event outputs  */
      cmbavDia.setValue( GXutil.trim( GXutil.str( AV7Dia, 4, 0)) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavDia.getInternalname(), "Values", cmbavDia.ToJavascriptSource(), true);
   }

   public void S112( )
   {
      /* 'SHOWDAYS' Routine */
      returnInSub = false ;
      AV42TempFechaNac = localUtil.ymdtod( AV5Anio, (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV14Mes, "."))), 1) ;
      AV11i = (short)(1) ;
      cmbavDia.removeAllItems();
      while ( AV11i <= GXutil.day( GXutil.eomdate( AV42TempFechaNac)) )
      {
         cmbavDia.addItem(GXutil.trim( GXutil.str( AV11i, 4, 0)), GXutil.str( AV11i, 10, 0), (short)(0));
         AV11i = (short)(AV11i+1) ;
      }
   }

   public void e16512( )
   {
      /* 'Guardar' Routine */
      returnInSub = false ;
      AV44UbigeoCode = AV20PacienteDepartamento + AV32PacienteProvincia + AV22PacienteDistrito ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV44UbigeoCode", AV44UbigeoCode);
      AV12Mensaje.clear();
      if ( ( GXutil.strcmp(GXutil.trim( AV23PacienteEmail), "") == 0 ) || ( GXutil.strcmp(GXutil.trim( AV34PacienteTelefono), "") == 0 ) )
      {
         AV12Mensaje.add("Todos los datos son obligatorios", 0);
      }
      else
      {
         if ( (GXutil.strcmp("", AV20PacienteDepartamento)==0) )
         {
            AV12Mensaje.add("Debe seleccionar un pais del listado", 0);
         }
         if ( ( GXutil.len( AV44UbigeoCode) != 6 ) && ( AV49PaisId == 28 ) )
         {
            AV12Mensaje.add("Debe seleccionar un distrito del listado", 0);
         }
         if ( ! GxRegex.IsMatch(AV23PacienteEmail,AV37Pattern) )
         {
            AV12Mensaje.add("Debe ingresar un correo electrónico válido", 0);
         }
      }
      if ( AV12Mensaje.size() > 0 )
      {
         /* Execute user subroutine: 'SHOWMESSAGES' */
         S122 ();
         if (returnInSub) return;
      }
      else
      {
         /* Execute user subroutine: 'UPDATEDATA' */
         S132 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV12Mensaje", AV12Mensaje);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV16Paciente", AV16Paciente);
   }

   public void S132( )
   {
      /* 'UPDATEDATA' Routine */
      returnInSub = false ;
      AV26PacienteId = (int)(GXutil.lval( AV46WebSession.getValue("WSPacienteId"))) ;
      AV16Paciente.Load(AV26PacienteId);
      AV16Paciente.setgxTv_SdtPaciente_Pacientetelefono( AV34PacienteTelefono );
      AV16Paciente.setgxTv_SdtPaciente_Pacientedireccion( AV21PacienteDireccion );
      AV16Paciente.setgxTv_SdtPaciente_Pacientecorreo( AV23PacienteEmail );
      AV16Paciente.setgxTv_SdtPaciente_Pacienteestatura( AV24PacienteEstatura );
      AV16Paciente.setgxTv_SdtPaciente_Pacientepeso( AV31PacientePeso );
      AV16Paciente.setgxTv_SdtPaciente_Paisid( AV27PacienteNacionalidad );
      AV16Paciente.setgxTv_SdtPaciente_Ubigeocode( AV44UbigeoCode );
      AV16Paciente.Update();
      if ( AV16Paciente.Success() )
      {
         new com.projectthani.prcactualizacionperfilpaciente(remoteHandle, context).execute( AV26PacienteId) ;
         this.executeExternalObjectMethod(sPrefix, false, "AV48SweetAlert2", "successAlert", new Object[] {"success","Sus datos se modificaron correctamente",""}, false);
         Application.commitDataStores(context, remoteHandle, pr_default, "wcmiperfil");
         edtavPacientetelefono_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientetelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientetelefono_Enabled), 5, 0), true);
         edtavPacientedireccion_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientedireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientedireccion_Enabled), 5, 0), true);
         edtavPacienteemail_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteemail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteemail_Enabled), 5, 0), true);
         edtavPacienteestatura_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacienteestatura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacienteestatura_Enabled), 5, 0), true);
         edtavPacientepeso_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavPacientepeso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavPacientepeso_Enabled), 5, 0), true);
         cmbavPacientedepartamento.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientedepartamento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavPacientedepartamento.getEnabled(), 5, 0), true);
         dynavPacientenacionalidad.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientenacionalidad.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacientenacionalidad.getEnabled(), 5, 0), true);
         dynavPacienteprovincia.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacienteprovincia.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacienteprovincia.getEnabled(), 5, 0), true);
         dynavPacientedistrito.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientedistrito.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPacientedistrito.getEnabled(), 5, 0), true);
         bttGuardar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttGuardar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttGuardar_Visible), 5, 0), true);
         bttActualizar_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttActualizar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttActualizar_Visible), 5, 0), true);
         bttBtncancel_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop(sPrefix, false, bttBtncancel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtncancel_Visible), 5, 0), true);
      }
      else
      {
         this.executeExternalObjectMethod(sPrefix, false, "AV48SweetAlert2", "successAlert", new Object[] {"error","Error, por favor intente nuevamente",""}, false);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wcmiperfil");
      }
   }

   public void S122( )
   {
      /* 'SHOWMESSAGES' Routine */
      returnInSub = false ;
      AV43textoMensaj = "" ;
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV12Mensaje.size() )
      {
         AV13Mensajei = (String)AV12Mensaje.elementAt(-1+AV55GXV1) ;
         AV43textoMensaj += "&#10060; " + AV13Mensajei + GXutil.newLine( ) ;
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
      httpContext.GX_msglist.addItem(AV43textoMensaj);
   }

   protected void nextLoad( )
   {
   }

   protected void e17512( )
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
      pa512( ) ;
      ws512( ) ;
      we512( ) ;
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
      pa512( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wcmiperfil", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa512( ) ;
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
      pa512( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws512( ) ;
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
      ws512( ) ;
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
      we512( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511032238", true, true);
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
      httpContext.AddJavascriptSource("wcmiperfil.js", "?2022511032239", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = sPrefix+"TEXTBLOCK1" ;
      divSectiontitlecitas_Internalname = sPrefix+"SECTIONTITLECITAS" ;
      edtavPacientenombres_Internalname = sPrefix+"vPACIENTENOMBRES" ;
      edtavPacienteapellidopaterno_Internalname = sPrefix+"vPACIENTEAPELLIDOPATERNO" ;
      edtavPacienteapellidomaterno_Internalname = sPrefix+"vPACIENTEAPELLIDOMATERNO" ;
      cmbavPacientetipodocumento.setInternalname( sPrefix+"vPACIENTETIPODOCUMENTO" );
      edtavPacientenrodocumento_Internalname = sPrefix+"vPACIENTENRODOCUMENTO" ;
      cmbavPacientesexo.setInternalname( sPrefix+"vPACIENTESEXO" );
      cmbavMes.setInternalname( sPrefix+"vMES" );
      cmbavDia.setInternalname( sPrefix+"vDIA" );
      cmbavAnio.setInternalname( sPrefix+"vANIO" );
      divGroup1table_Internalname = sPrefix+"GROUP1TABLE" ;
      grpGroup1_Internalname = sPrefix+"GROUP1" ;
      dynavPacientenacionalidad.setInternalname( sPrefix+"vPACIENTENACIONALIDAD" );
      edtavPacientetelefono_Internalname = sPrefix+"vPACIENTETELEFONO" ;
      edtavPacienteestatura_Internalname = sPrefix+"vPACIENTEESTATURA" ;
      edtavPacientepeso_Internalname = sPrefix+"vPACIENTEPESO" ;
      edtavPacienteemail_Internalname = sPrefix+"vPACIENTEEMAIL" ;
      divGroup2table_Internalname = sPrefix+"GROUP2TABLE" ;
      grpGroup2_Internalname = sPrefix+"GROUP2" ;
      edtavPacientedireccion_Internalname = sPrefix+"vPACIENTEDIRECCION" ;
      cmbavPacientedepartamento.setInternalname( sPrefix+"vPACIENTEDEPARTAMENTO" );
      dynavPacienteprovincia.setInternalname( sPrefix+"vPACIENTEPROVINCIA" );
      dynavPacientedistrito.setInternalname( sPrefix+"vPACIENTEDISTRITO" );
      divGroup4table_Internalname = sPrefix+"GROUP4TABLE" ;
      grpGroup4_Internalname = sPrefix+"GROUP4" ;
      bttGuardar_Internalname = sPrefix+"GUARDAR" ;
      bttActualizar_Internalname = sPrefix+"ACTUALIZAR" ;
      bttBtncancel_Internalname = sPrefix+"BTNCANCEL" ;
      divTable3_Internalname = sPrefix+"TABLE3" ;
      divTable2_Internalname = sPrefix+"TABLE2" ;
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
      bttBtncancel_Visible = 1 ;
      bttActualizar_Visible = 1 ;
      bttGuardar_Visible = 1 ;
      dynavPacientedistrito.setJsonclick( "" );
      dynavPacientedistrito.setEnabled( 1 );
      dynavPacienteprovincia.setJsonclick( "" );
      dynavPacienteprovincia.setEnabled( 1 );
      cmbavPacientedepartamento.setJsonclick( "" );
      cmbavPacientedepartamento.setEnabled( 1 );
      edtavPacientedireccion_Jsonclick = "" ;
      edtavPacientedireccion_Enabled = 1 ;
      edtavPacienteemail_Jsonclick = "" ;
      edtavPacienteemail_Enabled = 1 ;
      edtavPacientepeso_Jsonclick = "" ;
      edtavPacientepeso_Enabled = 1 ;
      edtavPacienteestatura_Jsonclick = "" ;
      edtavPacienteestatura_Enabled = 1 ;
      edtavPacientetelefono_Jsonclick = "" ;
      edtavPacientetelefono_Enabled = 1 ;
      dynavPacientenacionalidad.setJsonclick( "" );
      dynavPacientenacionalidad.setEnabled( 1 );
      cmbavAnio.setJsonclick( "" );
      cmbavAnio.setEnabled( 1 );
      cmbavDia.setJsonclick( "" );
      cmbavDia.setEnabled( 1 );
      cmbavMes.setJsonclick( "" );
      cmbavMes.setEnabled( 1 );
      cmbavPacientesexo.setJsonclick( "" );
      cmbavPacientesexo.setEnabled( 1 );
      edtavPacientenrodocumento_Jsonclick = "" ;
      edtavPacientenrodocumento_Enabled = 1 ;
      cmbavPacientetipodocumento.setJsonclick( "" );
      cmbavPacientetipodocumento.setEnabled( 1 );
      edtavPacienteapellidomaterno_Jsonclick = "" ;
      edtavPacienteapellidomaterno_Enabled = 1 ;
      edtavPacienteapellidopaterno_Jsonclick = "" ;
      edtavPacienteapellidopaterno_Enabled = 1 ;
      edtavPacientenombres_Jsonclick = "" ;
      edtavPacientenombres_Enabled = 1 ;
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
      cmbavPacientetipodocumento.setName( "vPACIENTETIPODOCUMENTO" );
      cmbavPacientetipodocumento.setWebtags( "" );
      cmbavPacientetipodocumento.addItem("1", "DNI", (short)(0));
      cmbavPacientetipodocumento.addItem("6", "RUC", (short)(0));
      cmbavPacientetipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavPacientetipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavPacientetipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavPacientetipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavPacientetipodocumento.getItemCount() > 0 )
      {
      }
      cmbavPacientesexo.setName( "vPACIENTESEXO" );
      cmbavPacientesexo.setWebtags( "" );
      cmbavPacientesexo.addItem("M", "Masculino", (short)(0));
      cmbavPacientesexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavPacientesexo.getItemCount() > 0 )
      {
      }
      cmbavMes.setName( "vMES" );
      cmbavMes.setWebtags( "" );
      cmbavMes.addItem("01", "Enero", (short)(0));
      cmbavMes.addItem("02", "Febrero", (short)(0));
      cmbavMes.addItem("03", "Marzo", (short)(0));
      cmbavMes.addItem("04", "Abril", (short)(0));
      cmbavMes.addItem("05", "Mayo", (short)(0));
      cmbavMes.addItem("06", "Junio", (short)(0));
      cmbavMes.addItem("07", "Julio", (short)(0));
      cmbavMes.addItem("08", "Agosto", (short)(0));
      cmbavMes.addItem("09", "Septiembre", (short)(0));
      cmbavMes.addItem("10", "Octubre", (short)(0));
      cmbavMes.addItem("11", "Noviembre", (short)(0));
      cmbavMes.addItem("12", "Diciembre", (short)(0));
      if ( cmbavMes.getItemCount() > 0 )
      {
      }
      cmbavDia.setName( "vDIA" );
      cmbavDia.setWebtags( "" );
      if ( cmbavDia.getItemCount() > 0 )
      {
      }
      cmbavAnio.setName( "vANIO" );
      cmbavAnio.setWebtags( "" );
      if ( cmbavAnio.getItemCount() > 0 )
      {
      }
      dynavPacientenacionalidad.setName( "vPACIENTENACIONALIDAD" );
      dynavPacientenacionalidad.setWebtags( "" );
      cmbavPacientedepartamento.setName( "vPACIENTEDEPARTAMENTO" );
      cmbavPacientedepartamento.setWebtags( "" );
      cmbavPacientedepartamento.addItem("", "Seleccionar", (short)(0));
      if ( cmbavPacientedepartamento.getItemCount() > 0 )
      {
      }
      dynavPacienteprovincia.setName( "vPACIENTEPROVINCIA" );
      dynavPacienteprovincia.setWebtags( "" );
      dynavPacientedistrito.setName( "vPACIENTEDISTRITO" );
      dynavPacientedistrito.setWebtags( "" );
      /* End function init_web_controls */
   }

   public void validv_Pacientedepartamento( )
   {
      AV27PacienteNacionalidad = (short)(GXutil.lval( dynavPacientenacionalidad.getValue())) ;
      AV20PacienteDepartamento = cmbavPacientedepartamento.getValue() ;
      AV32PacienteProvincia = dynavPacienteprovincia.getValue() ;
      AV22PacienteDistrito = dynavPacientedistrito.getValue() ;
      gxvvpacienteprovincia_html512( AV20PacienteDepartamento) ;
      gxvvpacientedistrito_html512( AV20PacienteDepartamento, AV32PacienteProvincia) ;
      dynload_actions( ) ;
      if ( dynavPacienteprovincia.getItemCount() > 0 )
      {
         AV32PacienteProvincia = dynavPacienteprovincia.getValidValue(AV32PacienteProvincia) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
      }
      if ( dynavPacientedistrito.getItemCount() > 0 )
      {
         AV22PacienteDistrito = dynavPacientedistrito.getValidValue(AV22PacienteDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientedistrito.setValue( GXutil.rtrim( AV22PacienteDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV32PacienteProvincia", AV32PacienteProvincia);
      dynavPacienteprovincia.setValue( GXutil.rtrim( AV32PacienteProvincia) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacienteprovincia.getInternalname(), "Values", dynavPacienteprovincia.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22PacienteDistrito", AV22PacienteDistrito);
      dynavPacientedistrito.setValue( GXutil.rtrim( AV22PacienteDistrito) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
   }

   public void validv_Pacienteprovincia( )
   {
      AV27PacienteNacionalidad = (short)(GXutil.lval( dynavPacientenacionalidad.getValue())) ;
      AV20PacienteDepartamento = cmbavPacientedepartamento.getValue() ;
      AV32PacienteProvincia = dynavPacienteprovincia.getValue() ;
      AV22PacienteDistrito = dynavPacientedistrito.getValue() ;
      gxvvpacientedistrito_html512( AV20PacienteDepartamento, AV32PacienteProvincia) ;
      dynload_actions( ) ;
      if ( dynavPacientedistrito.getItemCount() > 0 )
      {
         AV22PacienteDistrito = dynavPacientedistrito.getValidValue(AV22PacienteDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPacientedistrito.setValue( GXutil.rtrim( AV22PacienteDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22PacienteDistrito", AV22PacienteDistrito);
      dynavPacientedistrito.setValue( GXutil.rtrim( AV22PacienteDistrito) );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, dynavPacientedistrito.getInternalname(), "Values", dynavPacientedistrito.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV49PaisId',fld:'vPAISID',pic:'ZZZ9',hsh:true},{av:'AV37Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'cmbavMes'},{av:'AV14Mes',fld:'vMES',pic:''},{av:'cmbavAnio'},{av:'AV5Anio',fld:'vANIO',pic:'ZZZ9'},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VANIO.CONTROLVALUECHANGED","{handler:'e14512',iparms:[{av:'cmbavAnio'},{av:'AV5Anio',fld:'vANIO',pic:'ZZZ9'},{av:'cmbavMes'},{av:'AV14Mes',fld:'vMES',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VANIO.CONTROLVALUECHANGED",",oparms:[{av:'cmbavDia'},{av:'AV7Dia',fld:'vDIA',pic:'ZZZ9'},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VMES.CONTROLVALUECHANGED","{handler:'e15512',iparms:[{av:'cmbavAnio'},{av:'AV5Anio',fld:'vANIO',pic:'ZZZ9'},{av:'cmbavMes'},{av:'AV14Mes',fld:'vMES',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VMES.CONTROLVALUECHANGED",",oparms:[{av:'cmbavDia'},{av:'AV7Dia',fld:'vDIA',pic:'ZZZ9'},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("'ACTUALIZAR'","{handler:'e11511',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("'ACTUALIZAR'",",oparms:[{av:'edtavPacientetelefono_Enabled',ctrl:'vPACIENTETELEFONO',prop:'Enabled'},{av:'edtavPacientedireccion_Enabled',ctrl:'vPACIENTEDIRECCION',prop:'Enabled'},{av:'edtavPacienteemail_Enabled',ctrl:'vPACIENTEEMAIL',prop:'Enabled'},{av:'edtavPacienteestatura_Enabled',ctrl:'vPACIENTEESTATURA',prop:'Enabled'},{av:'edtavPacientepeso_Enabled',ctrl:'vPACIENTEPESO',prop:'Enabled'},{av:'cmbavPacientedepartamento'},{av:'dynavPacienteprovincia'},{av:'dynavPacientedistrito'},{ctrl:'GUARDAR',prop:'Visible'},{ctrl:'ACTUALIZAR',prop:'Visible'},{ctrl:'BTNCANCEL',prop:'Visible'},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("'GUARDAR'","{handler:'e16512',iparms:[{av:'cmbavPacientedepartamento'},{av:'AV20PacienteDepartamento',fld:'vPACIENTEDEPARTAMENTO',pic:''},{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV22PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'AV23PacienteEmail',fld:'vPACIENTEEMAIL',pic:''},{av:'AV34PacienteTelefono',fld:'vPACIENTETELEFONO',pic:''},{av:'AV49PaisId',fld:'vPAISID',pic:'ZZZ9',hsh:true},{av:'AV37Pattern',fld:'vPATTERN',pic:'',hsh:true},{av:'AV12Mensaje',fld:'vMENSAJE',pic:''},{av:'AV21PacienteDireccion',fld:'vPACIENTEDIRECCION',pic:''},{av:'AV24PacienteEstatura',fld:'vPACIENTEESTATURA',pic:'9.99'},{av:'AV31PacientePeso',fld:'vPACIENTEPESO',pic:'ZZ9.99'},{av:'AV44UbigeoCode',fld:'vUBIGEOCODE',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("'GUARDAR'",",oparms:[{av:'AV44UbigeoCode',fld:'vUBIGEOCODE',pic:''},{av:'AV12Mensaje',fld:'vMENSAJE',pic:''},{av:'AV16Paciente',fld:'vPACIENTE',pic:''},{av:'edtavPacientetelefono_Enabled',ctrl:'vPACIENTETELEFONO',prop:'Enabled'},{av:'edtavPacientedireccion_Enabled',ctrl:'vPACIENTEDIRECCION',prop:'Enabled'},{av:'edtavPacienteemail_Enabled',ctrl:'vPACIENTEEMAIL',prop:'Enabled'},{av:'edtavPacienteestatura_Enabled',ctrl:'vPACIENTEESTATURA',prop:'Enabled'},{av:'edtavPacientepeso_Enabled',ctrl:'vPACIENTEPESO',prop:'Enabled'},{av:'cmbavPacientedepartamento'},{av:'dynavPacienteprovincia'},{av:'dynavPacientedistrito'},{ctrl:'GUARDAR',prop:'Visible'},{ctrl:'ACTUALIZAR',prop:'Visible'},{ctrl:'BTNCANCEL',prop:'Visible'},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("'BTNCANCELAR'","{handler:'e12511',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("'BTNCANCELAR'",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PACIENTETIPODOCUMENTO","{handler:'validv_Pacientetipodocumento',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PACIENTETIPODOCUMENTO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PACIENTESEXO","{handler:'validv_Pacientesexo',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PACIENTESEXO",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_MES","{handler:'validv_Mes',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_MES",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PACIENTEEMAIL","{handler:'validv_Pacienteemail',iparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PACIENTEEMAIL",",oparms:[{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PACIENTEDEPARTAMENTO","{handler:'validv_Pacientedepartamento',iparms:[{av:'cmbavPacientedepartamento'},{av:'AV20PacienteDepartamento',fld:'vPACIENTEDEPARTAMENTO',pic:''},{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV22PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PACIENTEDEPARTAMENTO",",oparms:[{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV22PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PACIENTEPROVINCIA","{handler:'validv_Pacienteprovincia',iparms:[{av:'cmbavPacientedepartamento'},{av:'AV20PacienteDepartamento',fld:'vPACIENTEDEPARTAMENTO',pic:''},{av:'dynavPacienteprovincia'},{av:'AV32PacienteProvincia',fld:'vPACIENTEPROVINCIA',pic:''},{av:'dynavPacientedistrito'},{av:'AV22PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PACIENTEPROVINCIA",",oparms:[{av:'dynavPacientedistrito'},{av:'AV22PacienteDistrito',fld:'vPACIENTEDISTRITO',pic:''},{av:'dynavPacientenacionalidad'},{av:'AV27PacienteNacionalidad',fld:'vPACIENTENACIONALIDAD',pic:'ZZZ9'}]}");
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
      AV20PacienteDepartamento = "" ;
      AV32PacienteProvincia = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      AV37Pattern = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      AV14Mes = "" ;
      AV12Mensaje = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44UbigeoCode = "" ;
      GX_FocusControl = "" ;
      lblTextblock1_Jsonclick = "" ;
      TempTags = "" ;
      AV28PacienteNombres = "" ;
      AV18PacienteApellidoPaterno = "" ;
      AV17PacienteApellidoMaterno = "" ;
      AV35PacienteTipoDocumento = "" ;
      AV29PacienteNroDocumento = "" ;
      AV33PacienteSexo = "" ;
      AV34PacienteTelefono = "" ;
      AV24PacienteEstatura = DecimalUtil.ZERO ;
      AV31PacientePeso = DecimalUtil.ZERO ;
      AV23PacienteEmail = "" ;
      AV21PacienteDireccion = "" ;
      AV22PacienteDistrito = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttGuardar_Jsonclick = "" ;
      bttActualizar_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
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
      H00512_A43PaisId = new short[1] ;
      H00512_A184PaisDescripcion = new String[] {""} ;
      H00513_A44UbigeoCode = new String[] {""} ;
      H00513_A187UbigeoProvincia = new String[] {""} ;
      H00513_A296UbigeoProvinciaCode = new String[] {""} ;
      H00513_A295UbigeoDepartamentoCode = new String[] {""} ;
      H00514_A44UbigeoCode = new String[] {""} ;
      H00514_A188UbigeoDistrito = new String[] {""} ;
      H00514_A297UbigeoDistritoCode = new String[] {""} ;
      H00514_A295UbigeoDepartamentoCode = new String[] {""} ;
      H00514_A296UbigeoProvinciaCode = new String[] {""} ;
      Gx_date = GXutil.nullDate() ;
      hsh = "" ;
      AV46WebSession = httpContext.getWebSession();
      AV16Paciente = new com.projectthani.SdtPaciente(remoteHandle);
      H00515_A44UbigeoCode = new String[] {""} ;
      A44UbigeoCode = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A297UbigeoDistritoCode = "" ;
      A296UbigeoProvinciaCode = "" ;
      AV38Provincia = "" ;
      AV9Distrito = "" ;
      AV6Departamento = "" ;
      H00516_A186UbigeoDepartamento = new String[] {""} ;
      H00516_A295UbigeoDepartamentoCode = new String[] {""} ;
      H00516_A44UbigeoCode = new String[] {""} ;
      A186UbigeoDepartamento = "" ;
      AV42TempFechaNac = GXutil.nullDate() ;
      AV43textoMensaj = "" ;
      AV13Mensajei = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ZV32PacienteProvincia = "" ;
      ZV22PacienteDistrito = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wcmiperfil__default(),
         new Object[] {
             new Object[] {
            H00512_A43PaisId, H00512_A184PaisDescripcion
            }
            , new Object[] {
            H00513_A44UbigeoCode, H00513_A187UbigeoProvincia, H00513_A296UbigeoProvinciaCode, H00513_A295UbigeoDepartamentoCode
            }
            , new Object[] {
            H00514_A44UbigeoCode, H00514_A188UbigeoDistrito, H00514_A297UbigeoDistritoCode, H00514_A295UbigeoDepartamentoCode, H00514_A296UbigeoProvinciaCode
            }
            , new Object[] {
            H00515_A44UbigeoCode
            }
            , new Object[] {
            H00516_A186UbigeoDepartamento, H00516_A295UbigeoDepartamentoCode, H00516_A44UbigeoCode
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavPacientenombres_Enabled = 0 ;
      edtavPacienteapellidopaterno_Enabled = 0 ;
      edtavPacienteapellidomaterno_Enabled = 0 ;
      cmbavPacientetipodocumento.setEnabled( 0 );
      edtavPacientenrodocumento_Enabled = 0 ;
      cmbavPacientesexo.setEnabled( 0 );
      cmbavMes.setEnabled( 0 );
      cmbavDia.setEnabled( 0 );
      cmbavAnio.setEnabled( 0 );
      dynavPacientenacionalidad.setEnabled( 0 );
      edtavPacientetelefono_Enabled = 0 ;
      edtavPacienteestatura_Enabled = 0 ;
      edtavPacientepeso_Enabled = 0 ;
      edtavPacienteemail_Enabled = 0 ;
      edtavPacientedireccion_Enabled = 0 ;
      cmbavPacientedepartamento.setEnabled( 0 );
      dynavPacienteprovincia.setEnabled( 0 );
      dynavPacientedistrito.setEnabled( 0 );
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short AV49PaisId ;
   private short AV5Anio ;
   private short wbEnd ;
   private short wbStart ;
   private short AV7Dia ;
   private short AV27PacienteNacionalidad ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV11i ;
   private int edtavPacientenombres_Enabled ;
   private int edtavPacienteapellidopaterno_Enabled ;
   private int edtavPacienteapellidomaterno_Enabled ;
   private int edtavPacientenrodocumento_Enabled ;
   private int edtavPacientetelefono_Enabled ;
   private int edtavPacienteestatura_Enabled ;
   private int edtavPacientepeso_Enabled ;
   private int edtavPacienteemail_Enabled ;
   private int edtavPacientedireccion_Enabled ;
   private int bttGuardar_Visible ;
   private int bttActualizar_Visible ;
   private int bttBtncancel_Visible ;
   private int gxdynajaxindex ;
   private int AV26PacienteId ;
   private int AV55GXV1 ;
   private int idxLst ;
   private java.math.BigDecimal AV24PacienteEstatura ;
   private java.math.BigDecimal AV31PacientePeso ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV44UbigeoCode ;
   private String GX_FocusControl ;
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divSectiontitlecitas_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String divTable2_Internalname ;
   private String grpGroup2_Internalname ;
   private String divGroup2table_Internalname ;
   private String edtavPacientenombres_Internalname ;
   private String TempTags ;
   private String edtavPacientenombres_Jsonclick ;
   private String edtavPacienteapellidopaterno_Internalname ;
   private String edtavPacienteapellidopaterno_Jsonclick ;
   private String edtavPacienteapellidomaterno_Internalname ;
   private String edtavPacienteapellidomaterno_Jsonclick ;
   private String AV35PacienteTipoDocumento ;
   private String edtavPacientenrodocumento_Internalname ;
   private String edtavPacientenrodocumento_Jsonclick ;
   private String AV33PacienteSexo ;
   private String grpGroup1_Internalname ;
   private String divGroup1table_Internalname ;
   private String edtavPacientetelefono_Internalname ;
   private String AV34PacienteTelefono ;
   private String edtavPacientetelefono_Jsonclick ;
   private String edtavPacienteestatura_Internalname ;
   private String edtavPacienteestatura_Jsonclick ;
   private String edtavPacientepeso_Internalname ;
   private String edtavPacientepeso_Jsonclick ;
   private String edtavPacienteemail_Internalname ;
   private String edtavPacienteemail_Jsonclick ;
   private String grpGroup4_Internalname ;
   private String divGroup4table_Internalname ;
   private String edtavPacientedireccion_Internalname ;
   private String edtavPacientedireccion_Jsonclick ;
   private String divTable3_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttGuardar_Internalname ;
   private String bttGuardar_Jsonclick ;
   private String bttActualizar_Internalname ;
   private String bttActualizar_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String hsh ;
   private String A44UbigeoCode ;
   private java.util.Date Gx_date ;
   private java.util.Date AV42TempFechaNac ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private String AV20PacienteDepartamento ;
   private String AV32PacienteProvincia ;
   private String AV37Pattern ;
   private String AV14Mes ;
   private String AV28PacienteNombres ;
   private String AV18PacienteApellidoPaterno ;
   private String AV17PacienteApellidoMaterno ;
   private String AV29PacienteNroDocumento ;
   private String AV23PacienteEmail ;
   private String AV21PacienteDireccion ;
   private String AV22PacienteDistrito ;
   private String A295UbigeoDepartamentoCode ;
   private String A297UbigeoDistritoCode ;
   private String A296UbigeoProvinciaCode ;
   private String AV38Provincia ;
   private String AV9Distrito ;
   private String AV6Departamento ;
   private String A186UbigeoDepartamento ;
   private String AV43textoMensaj ;
   private String AV13Mensajei ;
   private String ZV32PacienteProvincia ;
   private String ZV22PacienteDistrito ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV46WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbavPacientetipodocumento ;
   private HTMLChoice cmbavPacientesexo ;
   private HTMLChoice cmbavMes ;
   private HTMLChoice cmbavDia ;
   private HTMLChoice cmbavAnio ;
   private HTMLChoice dynavPacientenacionalidad ;
   private HTMLChoice cmbavPacientedepartamento ;
   private HTMLChoice dynavPacienteprovincia ;
   private HTMLChoice dynavPacientedistrito ;
   private IDataStoreProvider pr_default ;
   private short[] H00512_A43PaisId ;
   private String[] H00512_A184PaisDescripcion ;
   private String[] H00513_A44UbigeoCode ;
   private String[] H00513_A187UbigeoProvincia ;
   private String[] H00513_A296UbigeoProvinciaCode ;
   private String[] H00513_A295UbigeoDepartamentoCode ;
   private String[] H00514_A44UbigeoCode ;
   private String[] H00514_A188UbigeoDistrito ;
   private String[] H00514_A297UbigeoDistritoCode ;
   private String[] H00514_A295UbigeoDepartamentoCode ;
   private String[] H00514_A296UbigeoProvinciaCode ;
   private String[] H00515_A44UbigeoCode ;
   private String[] H00516_A186UbigeoDepartamento ;
   private String[] H00516_A295UbigeoDepartamentoCode ;
   private String[] H00516_A44UbigeoCode ;
   private GXSimpleCollection<String> AV12Mensaje ;
   private com.projectthani.SdtPaciente AV16Paciente ;
}

final  class wcmiperfil__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00512", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00513", "SELECT [UbigeoCode], [UbigeoProvincia], SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode FROM [Ubigeo] WHERE SUBSTRING([UbigeoCode], 1, 2) = ? ORDER BY [UbigeoProvincia] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00514", "SELECT [UbigeoCode], [UbigeoDistrito], SUBSTRING([UbigeoCode], 5, 2) AS UbigeoDistritoCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode FROM [Ubigeo] WHERE (SUBSTRING([UbigeoCode], 1, 2) = ?) AND (SUBSTRING([UbigeoCode], 3, 2) = ?) ORDER BY [UbigeoDistrito] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00515", "SELECT [UbigeoCode] FROM [Ubigeo] WHERE [UbigeoCode] = ? ORDER BY [UbigeoCode] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00516", "SELECT DISTINCT [UbigeoDepartamento], [UbigeoDepartamentoCode], NULL AS [UbigeoCode] FROM ( SELECT TOP(100) PERCENT [UbigeoDepartamento], SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, [UbigeoCode] FROM [Ubigeo] ORDER BY [UbigeoDepartamento]) DistinctT ORDER BY [UbigeoDepartamento] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
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
               stmt.setVarchar(1, (String)parms[0], 2);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 2);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 10);
               return;
      }
   }

}

