package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wcmiscitas_impl extends GXWebComponent
{
   public wcmiscitas_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wcmiscitas_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wcmiscitas_impl.class ));
   }

   public wcmiscitas_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   public void executeCmdLine( String args[] )
   {
      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      chkavMiscitas = UIFactory.getCheckbox(this);
      chkavCitafamiliar = UIFactory.getCheckbox(this);
      cmbavPacientefamiliarid = new HTMLChoice();
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
         pa4U2( ) ;
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
         httpContext.writeValue( "WCMis Citas") ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110312665", false, true);
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
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wcmiscitas", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTODAY", getSecureSignedToken( sPrefix, Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLISTADOCITA", getSecureSignedToken( sPrefix, AV14ListadoCita));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTABLEFAMILIAR", AV22TableFamiliar);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vCITASFAMILIARLIST", AV8CitasFamiliarList);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vCITASFAMILIARLIST", AV8CitasFamiliarList);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CITAID", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"SGCITADISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"DISPONIBILIDADFECHA", localUtil.dtoc( A67DisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTODAY", getSecureSignedToken( sPrefix, Gx_date));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vLISTADOCITA", AV14ListadoCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vLISTADOCITA", AV14ListadoCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLISTADOCITA", getSecureSignedToken( sPrefix, AV14ListadoCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CITAID", GXutil.ltrim( localUtil.ntoc( A40000CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CITAID", GXutil.ltrim( localUtil.ntoc( A40001CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"CITAID", GXutil.ltrim( localUtil.ntoc( A40002CitaId, (byte)(8), (byte)(0), ",", "")));
   }

   public void renderHtmlCloseForm4U2( )
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
      return "WCMisCitas" ;
   }

   public String getPgmdesc( )
   {
      return "WCMis Citas" ;
   }

   public void wb4U0( )
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
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "com.projectthani.wcmiscitas");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSectiontitlecitas_Internalname, 1, 0, "px", 0, "px", "SeccionCitas", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "Mis citas", "", "", lblTextblock1_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlockCitas", 0, "", 1, 1, 0, (short)(0), "HLP_WCMisCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "TableCitasBuscador", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-5", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavMiscitas.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavMiscitas.getInternalname(), "Mis citas ", "col-xs-8 col-sm-3 CheckBoxMisCitasLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4 col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "CheckBoxMisCitas" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavMiscitas.getInternalname(), GXutil.booltostr( AV16MisCitas), "", "Mis citas ", 1, chkavMiscitas.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(21, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,21);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-7", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavCitafamiliar.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavCitafamiliar.getInternalname(), "Cita de un familiar", "col-xs-8 col-sm-6 CheckBoxMisCitasLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-4 col-sm-6 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'" + sPrefix + "',false,'',0)\"" ;
         ClassString = "CheckBoxMisCitas" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavCitafamiliar.getInternalname(), GXutil.booltostr( AV6CitaFamiliar), "", "Cita de un familiar", 1, chkavCitafamiliar.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(25, this, 'true', 'false',"+"'"+sPrefix+"'"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,25);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionseleccionafamiliar_Internalname, divSectionseleccionafamiliar_Visible, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientefamiliarid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientefamiliarid.getInternalname(), "Familiar: ", "gx-form-item AttributeSelecFamCitaLabel", 1, true, "width: 25%;");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'" + sPrefix + "',false,'',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientefamiliarid, cmbavPacientefamiliarid.getInternalname(), GXutil.trim( GXutil.str( AV17PacienteFamiliarId, 8, 0)), 1, cmbavPacientefamiliarid.getJsonclick(), 0, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavPacientefamiliarid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeSelecFamCita", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "", true, (byte)(1), "HLP_WCMisCitas.htm");
         cmbavPacientefamiliarid.setValue( GXutil.trim( GXutil.str( AV17PacienteFamiliarId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientefamiliarid.getInternalname(), "Values", cmbavPacientefamiliarid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemicita_Internalname, divTablemicita_Visible, 0, "px", 0, "px", "TableCitas", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktable_Internalname, lblTextblocktable_Caption, "", "", lblTextblocktable_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WCMisCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecitafamiliarcell_Internalname, divTablecitafamiliarcell_Visible, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecitafamiliar_Internalname, divTablecitafamiliar_Visible, 0, "px", 0, "px", "TableCitas", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpacientefamiliar_Internalname, lblTextblockpacientefamiliar_Caption, "", "", lblTextblockpacientefamiliar_Jsonclick, "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_WCMisCitas.htm");
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

   public void start4U2( )
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
            Form.getMeta().addItem("description", "WCMis Citas", (short)(0)) ;
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
            strup4U0( ) ;
         }
      }
   }

   public void ws4U2( )
   {
      start4U2( ) ;
      evt4U2( ) ;
   }

   public void evt4U2( )
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
                              strup4U0( ) ;
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
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e114U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "VPACIENTEFAMILIARID.CONTROLVALUECHANGED") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e124U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e134U2 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strup4U0( ) ;
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
                              strup4U0( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = chkavMiscitas.getInternalname() ;
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

   public void we4U2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm4U2( ) ;
         }
      }
   }

   public void pa4U2( )
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
            GX_FocusControl = chkavMiscitas.getInternalname() ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
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
      AV16MisCitas = GXutil.strtobool( GXutil.booltostr( AV16MisCitas)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16MisCitas", AV16MisCitas);
      AV6CitaFamiliar = GXutil.strtobool( GXutil.booltostr( AV6CitaFamiliar)) ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CitaFamiliar", AV6CitaFamiliar);
      if ( cmbavPacientefamiliarid.getItemCount() > 0 )
      {
         AV17PacienteFamiliarId = (int)(GXutil.lval( cmbavPacientefamiliarid.getValidValue(GXutil.trim( GXutil.str( AV17PacienteFamiliarId, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17PacienteFamiliarId), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientefamiliarid.setValue( GXutil.trim( GXutil.str( AV17PacienteFamiliarId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop(sPrefix, false, cmbavPacientefamiliarid.getInternalname(), "Values", cmbavPacientefamiliarid.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf4U2( ) ;
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
   }

   public void rf4U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e134U2 ();
         wb4U0( ) ;
      }
   }

   public void send_integrity_lvl_hashes4U2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vTODAY", getSecureSignedToken( sPrefix, Gx_date));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, sPrefix+"vLISTADOCITA", AV14ListadoCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(sPrefix+"vLISTADOCITA", AV14ListadoCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, sPrefix+"gxhash_vLISTADOCITA", getSecureSignedToken( sPrefix, AV14ListadoCita));
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      /* Using cursor H004U3 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
      if ( (pr_default.getStatus(0) != 101) )
      {
         A40000CitaId = H004U3_A40000CitaId[0] ;
         n40000CitaId = H004U3_n40000CitaId[0] ;
      }
      else
      {
         A40000CitaId = 0 ;
         n40000CitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40000CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000CitaId), 8, 0));
      }
      pr_default.close(0);
      /* Using cursor H004U5 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40001CitaId = H004U5_A40001CitaId[0] ;
         n40001CitaId = H004U5_n40001CitaId[0] ;
      }
      else
      {
         A40001CitaId = 0 ;
         n40001CitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40001CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001CitaId), 8, 0));
      }
      pr_default.close(1);
      /* Using cursor H004U7 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
      if ( (pr_default.getStatus(2) != 101) )
      {
         A40002CitaId = H004U7_A40002CitaId[0] ;
         n40002CitaId = H004U7_n40002CitaId[0] ;
      }
      else
      {
         A40002CitaId = 0 ;
         n40002CitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40002CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40002CitaId), 8, 0));
      }
      pr_default.close(2);
      /* Using cursor H004U9 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
      if ( (pr_default.getStatus(3) != 101) )
      {
         A40000CitaId = H004U9_A40000CitaId[0] ;
         n40000CitaId = H004U9_n40000CitaId[0] ;
      }
      else
      {
         A40000CitaId = 0 ;
         n40000CitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40000CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000CitaId), 8, 0));
      }
      pr_default.close(3);
      /* Using cursor H004U11 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
      if ( (pr_default.getStatus(4) != 101) )
      {
         A40001CitaId = H004U11_A40001CitaId[0] ;
         n40001CitaId = H004U11_n40001CitaId[0] ;
      }
      else
      {
         A40001CitaId = 0 ;
         n40001CitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40001CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001CitaId), 8, 0));
      }
      pr_default.close(4);
      /* Using cursor H004U13 */
      pr_default.execute(5, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
      if ( (pr_default.getStatus(5) != 101) )
      {
         A40002CitaId = H004U13_A40002CitaId[0] ;
         n40002CitaId = H004U13_n40002CitaId[0] ;
      }
      else
      {
         A40002CitaId = 0 ;
         n40002CitaId = false ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40002CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40002CitaId), 8, 0));
      }
      pr_default.close(5);
      fix_multi_value_controls( ) ;
   }

   public void strup4U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e114U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         AV16MisCitas = GXutil.strtobool( httpContext.cgiGet( chkavMiscitas.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV16MisCitas", AV16MisCitas);
         AV6CitaFamiliar = GXutil.strtobool( httpContext.cgiGet( chkavCitafamiliar.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV6CitaFamiliar", AV6CitaFamiliar);
         cmbavPacientefamiliarid.setValue( httpContext.cgiGet( cmbavPacientefamiliarid.getInternalname()) );
         AV17PacienteFamiliarId = (int)(GXutil.lval( httpContext.cgiGet( cmbavPacientefamiliarid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV17PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17PacienteFamiliarId), 8, 0));
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
      e114U2 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
   }

   public void e114U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.getJscriptsrc().add("ActualizarPagina.js") ;
      Form.getJscriptsrc().add("AbrirNuevaVentana.js") ;
      this.executeExternalObjectMethod(sPrefix, false, "AV27ActualizarPagina", "ActualizarPaginaV2", new Object[] {Integer.valueOf(2)}, false);
      this.executeExternalObjectMethod(sPrefix, false, "AV27ActualizarPagina", "ActualizarPaginaV3", new Object[] {Integer.valueOf(2)}, false);
      AV18PacienteId = (int)(GXutil.lval( AV21WebSession.getValue("WSPacienteId"))) ;
      AV24Contador = (short)(0) ;
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox1[0] = AV13FamiliarList ;
      new com.projectthani.prcgetlistadopacientefamiliarcombobox(remoteHandle, context).execute( AV18PacienteId, GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox1) ;
      AV13FamiliarList = GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox1[0] ;
      AV36GXV1 = 1 ;
      while ( AV36GXV1 <= AV13FamiliarList.size() )
      {
         AV12FamiliarItem = (com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)((com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)AV13FamiliarList.elementAt(-1+AV36GXV1));
         cmbavPacientefamiliarid.addItem(GXutil.trim( GXutil.str( AV12FamiliarItem.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid(), 8, 0)), AV12FamiliarItem.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos(), (short)(0));
         AV36GXV1 = (int)(AV36GXV1+1) ;
      }
      divSectionseleccionafamiliar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divSectionseleccionafamiliar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divSectionseleccionafamiliar_Visible), 5, 0), true);
      divTablecitafamiliar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablecitafamiliar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecitafamiliar_Visible), 5, 0), true);
      divTablemicita_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablemicita_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablemicita_Visible), 5, 0), true);
      GXv_objcol_SdtSDTListadoCitasPorPaciente2[0] = AV15ListadoCitas ;
      new com.projectthani.prcgetlistadocitapaciente(remoteHandle, context).execute( AV18PacienteId, GXv_objcol_SdtSDTListadoCitasPorPaciente2) ;
      AV15ListadoCitas = GXv_objcol_SdtSDTListadoCitasPorPaciente2[0] ;
      /* Execute user subroutine: 'MOSTARMISCITAS' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         pr_default.close(0);
         returnInSub = true;
         if (true) return;
      }
      divTablecitafamiliarcell_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablecitafamiliarcell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecitafamiliarcell_Visible), 5, 0), true);
   }

   public void e124U2( )
   {
      /* Pacientefamiliarid_Controlvaluechanged Routine */
      returnInSub = false ;
      divTablecitafamiliarcell_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, divTablecitafamiliarcell_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablecitafamiliarcell_Visible), 5, 0), true);
      AV24Contador = (short)(GXutil.Int( GXutil.len( AV22TableFamiliar))) ;
      if ( AV24Contador <= 0 )
      {
         GXv_objcol_SdtSDTListadoCitasPorPaciente2[0] = AV8CitasFamiliarList ;
         new com.projectthani.prcgetlistadocitapaciente(remoteHandle, context).execute( AV17PacienteFamiliarId, GXv_objcol_SdtSDTListadoCitasPorPaciente2) ;
         AV8CitasFamiliarList = GXv_objcol_SdtSDTListadoCitasPorPaciente2[0] ;
         /* Execute user subroutine: 'MOSTRARCITAFAMILIAR' */
         S122 ();
         if ( returnInSub )
         {
            pr_default.close(5);
            pr_default.close(4);
            pr_default.close(3);
            pr_default.close(2);
            pr_default.close(1);
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
      }
      else
      {
         AV22TableFamiliar = "" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV8CitasFamiliarList", AV8CitasFamiliarList);
      httpContext.ajax_rsp_assign_sdt_attri(sPrefix, false, "AV5CitasFamiliarItem", AV5CitasFamiliarItem);
   }

   public void S112( )
   {
      /* 'MOSTARMISCITAS' Routine */
      returnInSub = false ;
      AV20Table += "<div class=\"card\" style=\"background-color: #fff;\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "    <div class=\"card-body\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "        <table class=\"table table-bordered table-hover table-sm dt-responsive  TablaCitas table-sm\" style=\"width:100%\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "            <thead>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                <tr>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                   <th>Paciente</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                    <th>Fecha</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                    <th>Hora</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                    <th>Doctor</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                    <th>Especialidad</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                    <th>Estado</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                    <th>Accion</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "                </tr>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "            </thead>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "            <tbody>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV37GXV2 = 1 ;
      while ( AV37GXV2 <= AV15ListadoCitas.size() )
      {
         AV14ListadoCita = (com.projectthani.SdtSDTListadoCitasPorPaciente)((com.projectthani.SdtSDTListadoCitasPorPaciente)AV15ListadoCitas.elementAt(-1+AV37GXV2));
         AV20Table += "               <tr style=\"border: 1px solid #F0F0F0;\">" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         AV20Table += "                   <td>" + AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         AV20Table += "                    <td>" + localUtil.dtoc( AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Fechacita(), 3, "/") + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         AV20Table += "                    <td>" + AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Horacita() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         AV20Table += "                    <td>" + AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         AV20Table += "                    <td>" + AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Especialidad() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "R") == 0 )
         {
            AV20Table += "<td><span class=\"badge bg-primary\">Registrado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         else if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "C") == 0 )
         {
            AV20Table += "<td><span class=\"badge bg-secondary\">Confirmado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         else if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "X") == 0 )
         {
            AV20Table += "<td><span class=\"badge bg-primary\">Cancelado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         else if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "F") == 0 )
         {
            AV20Table += "<td><span class=\"badge bg-success\">Finalizado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         else if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "N") == 0 )
         {
            AV20Table += "<td><span class=\"badge bg-danger\">No se presento</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         else if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "A") == 0 )
         {
            AV20Table += "<td><span class=\"badge bg-primary\">En atención</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         AV20Table += " <td><div class=\"btn-group\">" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         /* Using cursor H004U14 */
         pr_default.execute(6, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         while ( (pr_default.getStatus(6) != 101) )
         {
            A19CitaId = H004U14_A19CitaId[0] ;
            A21SGCitaDisponibilidadId = H004U14_A21SGCitaDisponibilidadId[0] ;
            AV11DisponiblidadId = A21SGCitaDisponibilidadId ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11DisponiblidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DisponiblidadId), 8, 0));
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(6);
         /* Using cursor H004U15 */
         pr_default.execute(7, new Object[] {Integer.valueOf(AV11DisponiblidadId)});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A34DisponibilidadId = H004U15_A34DisponibilidadId[0] ;
            A67DisponibilidadFecha = H004U15_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = H004U15_n67DisponibilidadFecha[0] ;
            AV10disponibilidadFecha = A67DisponibilidadFecha ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(7);
         /* Using cursor H004U17 */
         pr_default.execute(8, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         if ( (pr_default.getStatus(8) != 101) )
         {
            A40000CitaId = H004U17_A40000CitaId[0] ;
            n40000CitaId = H004U17_n40000CitaId[0] ;
         }
         else
         {
            A40000CitaId = 0 ;
            n40000CitaId = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40000CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000CitaId), 8, 0));
         }
         pr_default.close(8);
         /* Using cursor H004U19 */
         pr_default.execute(9, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         if ( (pr_default.getStatus(9) != 101) )
         {
            A40001CitaId = H004U19_A40001CitaId[0] ;
            n40001CitaId = H004U19_n40001CitaId[0] ;
         }
         else
         {
            A40001CitaId = 0 ;
            n40001CitaId = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40001CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001CitaId), 8, 0));
         }
         pr_default.close(9);
         /* Using cursor H004U21 */
         pr_default.execute(10, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         if ( (pr_default.getStatus(10) != 101) )
         {
            A40002CitaId = H004U21_A40002CitaId[0] ;
            n40002CitaId = H004U21_n40002CitaId[0] ;
         }
         else
         {
            A40002CitaId = 0 ;
            n40002CitaId = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40002CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40002CitaId), 8, 0));
         }
         pr_default.close(10);
         if ( GXutil.dateCompare(GXutil.resetTime(AV10disponibilidadFecha), GXutil.resetTime(Gx_date)) )
         {
            AV20Table += "    <a href=\"" + formatLink("com.projectthani.wpvideollamadapaciente", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"CitaId"})  + "\" class=\"btn btn-success btn-sm\"><i class=\"fas fa-video\"></i> Videollamada</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         AV30ValidarId = A40000CitaId ;
         if ( AV30ValidarId > 0 )
         {
            AV32ValId1 = (short)(A40001CitaId) ;
            if ( AV32ValId1 > 0 )
            {
               AV20Table += "<a href=\"" + formatLink("com.projectthani.prcdescargarrectamedica", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"CitaId"})  + "\" class=\"btn btn-primary btn-sm\" target=\"_blank\" rel=\"noopener noreferrer\"><i class=\"fas fa-file-medical-alt\"></i>Receta</a>" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
            }
            AV33ValId2 = (short)(A40002CitaId) ;
            if ( AV33ValId2 > 0 )
            {
               AV20Table += "<a href=\"" + formatLink("com.projectthani.aprcgenerarrecetamedica", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"CitaId"})  + "\" class=\"btn btn-primary btn-sm\" target=\"_blank\" rel=\"noopener noreferrer\"><i class=\"fas fa-file-medical-alt\"></i>Receta</a>" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
            }
         }
         if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "R") == 0 )
         {
            AV20Table += "<a href=\"" + formatLink("com.projectthani.wpcalificaratencionmedico", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid(),8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11DisponiblidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"ProfesionalId","DisponibilidadId","CitaId"})  + "\" class=\"btn btn-secondary btn-sm\"><i class=\"fas fa-star\"></i>Calificar Med.</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "F") == 0 )
         {
            AV20Table += "<a href=\"" + formatLink("com.projectthani.wpcalificaratencionmedico", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid(),8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11DisponiblidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"ProfesionalId","DisponibilidadId","CitaId"})  + "\" class=\"btn btn-secondary btn-sm\"><i class=\"fas fa-star\"></i>Calificar Med.</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "R") == 0 )
         {
            AV20Table += "<a href=\"" + formatLink("com.projectthani.wpcalificaratencionplataforma", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponiblidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"DisponibilidadId","CitaId"})  + "\" class=\"btn btn-warning btn-sm\"><i class=\"fas fa-star-half-alt\"></i>Calificar Plat.</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "F") == 0 )
         {
            AV20Table += "<a href=\"" + formatLink("com.projectthani.wpcalificaratencionplataforma", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponiblidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"DisponibilidadId","CitaId"})  + "\" class=\"btn btn-warning btn-sm\"><i class=\"fas fa-star-half-alt\"></i>Calificar Plat.</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         }
         AV20Table += " </div></td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         AV20Table += "                </tr>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
         AV37GXV2 = (int)(AV37GXV2+1) ;
      }
      AV20Table += "            </tbody>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "        </table>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "    </div>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      AV20Table += "</div>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV20Table", AV20Table);
      lblTextblocktable_Caption = AV20Table ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTextblocktable_Internalname, "Caption", lblTextblocktable_Caption, true);
      this.executeExternalObjectMethod(sPrefix, false, "AV9DataTables", "dataTable", new Object[] {"TablaCitas"}, false);
   }

   public void S122( )
   {
      /* 'MOSTRARCITAFAMILIAR' Routine */
      returnInSub = false ;
      AV22TableFamiliar += "<div class=\"card\" style=\"background-color: #fff;\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "    <div class=\"card-body\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "        <table class=\"table table-bordered table-hover table-sm dt-responsive  TablaCitasFamiliar table-sm\" style=\"width:100%\">" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "            <thead>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                <tr>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                   <th>Paciente</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                    <th>Fecha</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                    <th>Hora</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                    <th>Doctor</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                    <th>Especialidad</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                    <th>Estado</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                    <th>Accion</th>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "                </tr>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "            </thead>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "            <tbody>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV41GXV3 = 1 ;
      while ( AV41GXV3 <= AV8CitasFamiliarList.size() )
      {
         AV5CitasFamiliarItem = (com.projectthani.SdtSDTListadoCitasPorPaciente)((com.projectthani.SdtSDTListadoCitasPorPaciente)AV8CitasFamiliarList.elementAt(-1+AV41GXV3));
         AV22TableFamiliar += "               <tr style=\"border: 1px solid #F0F0F0;\">" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         AV22TableFamiliar += "                   <td>" + AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Pacientenombresapellidos() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         AV22TableFamiliar += "                    <td>" + localUtil.dtoc( AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Fechacita(), 3, "/") + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         AV22TableFamiliar += "                    <td>" + AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Horacita() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         AV22TableFamiliar += "                    <td>" + AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Doctornombresapellidos() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         AV22TableFamiliar += "                    <td>" + AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Especialidad() + "</td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         if ( GXutil.strcmp(AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "R") == 0 )
         {
            AV22TableFamiliar += "<td><span class=\"badge bg-primary\">Registrado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         else if ( GXutil.strcmp(AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "C") == 0 )
         {
            AV22TableFamiliar += "<td><span class=\"badge bg-secondary\">Confirmado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         else if ( GXutil.strcmp(AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "X") == 0 )
         {
            AV22TableFamiliar += "<td><span class=\"badge bg-primAry\">Cancelado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         else if ( GXutil.strcmp(AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "F") == 0 )
         {
            AV22TableFamiliar += "<td><span class=\"badge bg-success\">Finalizado</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         else if ( GXutil.strcmp(AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "N") == 0 )
         {
            AV22TableFamiliar += "<td><span class=\"badge bg-danger\">No se presento</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         else if ( GXutil.strcmp(AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "A") == 0 )
         {
            AV22TableFamiliar += "<td><span class=\"badge bg-primary\">En atención</span></td>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         AV22TableFamiliar += " <td><div class=\"btn-group\">" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         /* Using cursor H004U22 */
         pr_default.execute(11, new Object[] {Integer.valueOf(AV5CitasFamiliarItem.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         while ( (pr_default.getStatus(11) != 101) )
         {
            A19CitaId = H004U22_A19CitaId[0] ;
            A21SGCitaDisponibilidadId = H004U22_A21SGCitaDisponibilidadId[0] ;
            AV11DisponiblidadId = A21SGCitaDisponibilidadId ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV11DisponiblidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DisponiblidadId), 8, 0));
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(11);
         /* Using cursor H004U23 */
         pr_default.execute(12, new Object[] {Integer.valueOf(AV11DisponiblidadId)});
         while ( (pr_default.getStatus(12) != 101) )
         {
            A34DisponibilidadId = H004U23_A34DisponibilidadId[0] ;
            A67DisponibilidadFecha = H004U23_A67DisponibilidadFecha[0] ;
            n67DisponibilidadFecha = H004U23_n67DisponibilidadFecha[0] ;
            AV10disponibilidadFecha = A67DisponibilidadFecha ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(12);
         /* Using cursor H004U25 */
         pr_default.execute(13, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         if ( (pr_default.getStatus(13) != 101) )
         {
            A40000CitaId = H004U25_A40000CitaId[0] ;
            n40000CitaId = H004U25_n40000CitaId[0] ;
         }
         else
         {
            A40000CitaId = 0 ;
            n40000CitaId = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40000CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000CitaId), 8, 0));
         }
         pr_default.close(13);
         /* Using cursor H004U27 */
         pr_default.execute(14, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         if ( (pr_default.getStatus(14) != 101) )
         {
            A40001CitaId = H004U27_A40001CitaId[0] ;
            n40001CitaId = H004U27_n40001CitaId[0] ;
         }
         else
         {
            A40001CitaId = 0 ;
            n40001CitaId = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40001CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40001CitaId), 8, 0));
         }
         pr_default.close(14);
         /* Using cursor H004U29 */
         pr_default.execute(15, new Object[] {Integer.valueOf(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid())});
         if ( (pr_default.getStatus(15) != 101) )
         {
            A40002CitaId = H004U29_A40002CitaId[0] ;
            n40002CitaId = H004U29_n40002CitaId[0] ;
         }
         else
         {
            A40002CitaId = 0 ;
            n40002CitaId = false ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "A40002CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40002CitaId), 8, 0));
         }
         pr_default.close(15);
         if ( GXutil.dateCompare(GXutil.resetTime(AV10disponibilidadFecha), GXutil.resetTime(Gx_date)) )
         {
            AV22TableFamiliar += "    <a href=\"" + formatLink("com.projectthani.wpvideollamadapaciente", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"CitaId"})  + "\" class=\"btn btn-success btn-sm\"><i class=\"fas fa-video\"></i> Videollamada</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         AV30ValidarId = A40000CitaId ;
         if ( AV30ValidarId > 0 )
         {
            AV32ValId1 = (short)(A40001CitaId) ;
            if ( AV32ValId1 > 0 )
            {
               AV22TableFamiliar += "<a href=\"" + formatLink("com.projectthani.prcdescargarrectamedica", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"CitaId"})  + "\" class=\"btn btn-primary btn-sm\" target=\"_blank\" rel=\"noopener noreferrer\"><i class=\"fas fa-file-medical-alt\"></i>Receta</a>" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
            }
            AV33ValId2 = (short)(A40002CitaId) ;
            if ( AV33ValId2 > 0 )
            {
               AV22TableFamiliar += "<a href=\"" + formatLink("com.projectthani.aprcgenerarrecetamedica", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"CitaId"})  + "\" class=\"btn btn-primary btn-sm\" target=\"_blank\" rel=\"noopener noreferrer\"><i class=\"fas fa-file-medical-alt\"></i>Receta</a>" ;
               httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
            }
         }
         if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "R") == 0 )
         {
            AV22TableFamiliar += "<a href=\"" + formatLink("com.projectthani.wpcalificaratencionmedico", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Profesionalid(),8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV11DisponiblidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"ProfesionalId","DisponibilidadId","CitaId"})  + "\" class=\"btn btn-secondary btn-sm\"><i class=\"fas fa-star\"></i>Calificar Med.</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         if ( GXutil.strcmp(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Estadocita(), "R") == 0 )
         {
            AV22TableFamiliar += "<a href=\"" + formatLink("com.projectthani.wpcalificaratencionplataforma", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponiblidadId,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV14ListadoCita.getgxTv_SdtSDTListadoCitasPorPaciente_Citaid(),8,0))}, new String[] {"DisponibilidadId","CitaId"})  + "\" class=\"btn btn-warning btn-sm\"><i class=\"fas fa-star-half-alt\"></i>Calificar Plat.</a>" ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         }
         AV22TableFamiliar += " </div></td>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         AV22TableFamiliar += "                </tr>" ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
         AV41GXV3 = (int)(AV41GXV3+1) ;
      }
      AV22TableFamiliar += "            </tbody>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "        </table>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "    </div>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      AV22TableFamiliar += "</div>" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
      lblTextblockpacientefamiliar_Caption = AV22TableFamiliar ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, lblTextblockpacientefamiliar_Internalname, "Caption", lblTextblockpacientefamiliar_Caption, true);
      this.executeExternalObjectMethod(sPrefix, false, "AV23DataTableFamiliar", "dataTable", new Object[] {"TablaCitasFamiliar"}, false);
      AV22TableFamiliar = "" ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV22TableFamiliar", AV22TableFamiliar);
   }

   protected void nextLoad( )
   {
   }

   protected void e134U2( )
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
      pa4U2( ) ;
      ws4U2( ) ;
      we4U2( ) ;
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
      pa4U2( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "wcmiscitas", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      pa4U2( ) ;
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
      pa4U2( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      ws4U2( ) ;
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
      ws4U2( ) ;
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
      we4U2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110312790", true, true);
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
      httpContext.AddJavascriptSource("wcmiscitas.js", "?20225110312790", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTextblock1_Internalname = sPrefix+"TEXTBLOCK1" ;
      divSectiontitlecitas_Internalname = sPrefix+"SECTIONTITLECITAS" ;
      chkavMiscitas.setInternalname( sPrefix+"vMISCITAS" );
      chkavCitafamiliar.setInternalname( sPrefix+"vCITAFAMILIAR" );
      cmbavPacientefamiliarid.setInternalname( sPrefix+"vPACIENTEFAMILIARID" );
      divSectionseleccionafamiliar_Internalname = sPrefix+"SECTIONSELECCIONAFAMILIAR" ;
      divTable5_Internalname = sPrefix+"TABLE5" ;
      lblTextblocktable_Internalname = sPrefix+"TEXTBLOCKTABLE" ;
      divTablemicita_Internalname = sPrefix+"TABLEMICITA" ;
      lblTextblockpacientefamiliar_Internalname = sPrefix+"TEXTBLOCKPACIENTEFAMILIAR" ;
      divTablecitafamiliar_Internalname = sPrefix+"TABLECITAFAMILIAR" ;
      divTablecitafamiliarcell_Internalname = sPrefix+"TABLECITAFAMILIARCELL" ;
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
      lblTextblockpacientefamiliar_Caption = "Text Block" ;
      divTablecitafamiliar_Visible = 1 ;
      divTablecitafamiliarcell_Visible = 1 ;
      lblTextblocktable_Caption = "Text Block" ;
      divTablemicita_Visible = 1 ;
      cmbavPacientefamiliarid.setJsonclick( "" );
      cmbavPacientefamiliarid.setEnabled( 1 );
      divSectionseleccionafamiliar_Visible = 1 ;
      chkavCitafamiliar.setEnabled( 1 );
      chkavMiscitas.setEnabled( 1 );
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
      chkavMiscitas.setName( "vMISCITAS" );
      chkavMiscitas.setWebtags( "" );
      chkavMiscitas.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavMiscitas.getInternalname(), "TitleCaption", chkavMiscitas.getCaption(), true);
      chkavMiscitas.setCheckedValue( "false" );
      chkavCitafamiliar.setName( "vCITAFAMILIAR" );
      chkavCitafamiliar.setWebtags( "" );
      chkavCitafamiliar.setCaption( "" );
      httpContext.ajax_rsp_assign_prop(sPrefix, false, chkavCitafamiliar.getInternalname(), "TitleCaption", chkavCitafamiliar.getCaption(), true);
      chkavCitafamiliar.setCheckedValue( "false" );
      cmbavPacientefamiliarid.setName( "vPACIENTEFAMILIARID" );
      cmbavPacientefamiliarid.setWebtags( "" );
      cmbavPacientefamiliarid.addItem(GXutil.trim( GXutil.str( 0, 8, 0)), "Seleccionar", (short)(0));
      if ( cmbavPacientefamiliarid.getItemCount() > 0 )
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV14ListadoCita',fld:'vLISTADOCITA',pic:'',hsh:true},{av:'AV16MisCitas',fld:'vMISCITAS',pic:''},{av:'AV6CitaFamiliar',fld:'vCITAFAMILIAR',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV16MisCitas',fld:'vMISCITAS',pic:''},{av:'AV6CitaFamiliar',fld:'vCITAFAMILIAR',pic:''}]}");
      setEventMetadata("VPACIENTEFAMILIARID.CONTROLVALUECHANGED","{handler:'e124U2',iparms:[{av:'AV22TableFamiliar',fld:'vTABLEFAMILIAR',pic:''},{av:'cmbavPacientefamiliarid'},{av:'AV17PacienteFamiliarId',fld:'vPACIENTEFAMILIARID',pic:'ZZZZZZZ9'},{av:'AV8CitasFamiliarList',fld:'vCITASFAMILIARLIST',pic:''},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A21SGCitaDisponibilidadId',fld:'SGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A67DisponibilidadFecha',fld:'DISPONIBILIDADFECHA',pic:''},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV14ListadoCita',fld:'vLISTADOCITA',pic:'',hsh:true},{av:'AV16MisCitas',fld:'vMISCITAS',pic:''},{av:'AV6CitaFamiliar',fld:'vCITAFAMILIAR',pic:''}]");
      setEventMetadata("VPACIENTEFAMILIARID.CONTROLVALUECHANGED",",oparms:[{av:'divTablecitafamiliarcell_Visible',ctrl:'TABLECITAFAMILIARCELL',prop:'Visible'},{av:'AV8CitasFamiliarList',fld:'vCITASFAMILIARLIST',pic:''},{av:'AV22TableFamiliar',fld:'vTABLEFAMILIAR',pic:''},{av:'AV5CitasFamiliarItem',fld:'vCITASFAMILIARITEM',pic:''},{av:'AV11DisponiblidadId',fld:'vDISPONIBLIDADID',pic:'ZZZZZZZ9'},{av:'A40000CitaId',fld:'CITAID',pic:'99999999'},{av:'A40001CitaId',fld:'CITAID',pic:'99999999'},{av:'A40002CitaId',fld:'CITAID',pic:'99999999'},{av:'lblTextblockpacientefamiliar_Caption',ctrl:'TEXTBLOCKPACIENTEFAMILIAR',prop:'Caption'},{av:'AV16MisCitas',fld:'vMISCITAS',pic:''},{av:'AV6CitaFamiliar',fld:'vCITAFAMILIAR',pic:''}]}");
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
      Gx_date = GXutil.nullDate() ;
      AV14ListadoCita = new com.projectthani.SdtSDTListadoCitasPorPaciente(remoteHandle, context);
      GXKey = "" ;
      AV22TableFamiliar = "" ;
      AV8CitasFamiliarList = new GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente>(com.projectthani.SdtSDTListadoCitasPorPaciente.class, "SDTListadoCitasPorPaciente", "ProjectThani", remoteHandle);
      A67DisponibilidadFecha = GXutil.nullDate() ;
      GX_FocusControl = "" ;
      lblTextblock1_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV16MisCitas = true ;
      lblTextblocktable_Jsonclick = "" ;
      lblTextblockpacientefamiliar_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H004U3_A40000CitaId = new int[1] ;
      H004U3_n40000CitaId = new boolean[] {false} ;
      H004U5_A40001CitaId = new int[1] ;
      H004U5_n40001CitaId = new boolean[] {false} ;
      H004U7_A40002CitaId = new int[1] ;
      H004U7_n40002CitaId = new boolean[] {false} ;
      H004U9_A40000CitaId = new int[1] ;
      H004U9_n40000CitaId = new boolean[] {false} ;
      H004U11_A40001CitaId = new int[1] ;
      H004U11_n40001CitaId = new boolean[] {false} ;
      H004U13_A40002CitaId = new int[1] ;
      H004U13_n40002CitaId = new boolean[] {false} ;
      AV21WebSession = httpContext.getWebSession();
      AV13FamiliarList = new GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>(com.projectthani.SdtSDTListadoPacienteFamiliarComboBox.class, "SDTListadoPacienteFamiliarComboBox", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox1 = new GXBaseCollection[1] ;
      AV12FamiliarItem = new com.projectthani.SdtSDTListadoPacienteFamiliarComboBox(remoteHandle, context);
      AV15ListadoCitas = new GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente>(com.projectthani.SdtSDTListadoCitasPorPaciente.class, "SDTListadoCitasPorPaciente", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTListadoCitasPorPaciente2 = new GXBaseCollection[1] ;
      AV5CitasFamiliarItem = new com.projectthani.SdtSDTListadoCitasPorPaciente(remoteHandle, context);
      AV20Table = "" ;
      H004U14_A19CitaId = new int[1] ;
      H004U14_A21SGCitaDisponibilidadId = new int[1] ;
      H004U15_A34DisponibilidadId = new int[1] ;
      H004U15_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H004U15_n67DisponibilidadFecha = new boolean[] {false} ;
      AV10disponibilidadFecha = GXutil.nullDate() ;
      H004U17_A40000CitaId = new int[1] ;
      H004U17_n40000CitaId = new boolean[] {false} ;
      H004U19_A40001CitaId = new int[1] ;
      H004U19_n40001CitaId = new boolean[] {false} ;
      H004U21_A40002CitaId = new int[1] ;
      H004U21_n40002CitaId = new boolean[] {false} ;
      H004U22_A19CitaId = new int[1] ;
      H004U22_A21SGCitaDisponibilidadId = new int[1] ;
      H004U23_A34DisponibilidadId = new int[1] ;
      H004U23_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H004U23_n67DisponibilidadFecha = new boolean[] {false} ;
      H004U25_A40000CitaId = new int[1] ;
      H004U25_n40000CitaId = new boolean[] {false} ;
      H004U27_A40001CitaId = new int[1] ;
      H004U27_n40001CitaId = new boolean[] {false} ;
      H004U29_A40002CitaId = new int[1] ;
      H004U29_n40002CitaId = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wcmiscitas__default(),
         new Object[] {
             new Object[] {
            H004U3_A40000CitaId, H004U3_n40000CitaId
            }
            , new Object[] {
            H004U5_A40001CitaId, H004U5_n40001CitaId
            }
            , new Object[] {
            H004U7_A40002CitaId, H004U7_n40002CitaId
            }
            , new Object[] {
            H004U9_A40000CitaId, H004U9_n40000CitaId
            }
            , new Object[] {
            H004U11_A40001CitaId, H004U11_n40001CitaId
            }
            , new Object[] {
            H004U13_A40002CitaId, H004U13_n40002CitaId
            }
            , new Object[] {
            H004U14_A19CitaId, H004U14_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            H004U15_A34DisponibilidadId, H004U15_A67DisponibilidadFecha, H004U15_n67DisponibilidadFecha
            }
            , new Object[] {
            H004U17_A40000CitaId, H004U17_n40000CitaId
            }
            , new Object[] {
            H004U19_A40001CitaId, H004U19_n40001CitaId
            }
            , new Object[] {
            H004U21_A40002CitaId, H004U21_n40002CitaId
            }
            , new Object[] {
            H004U22_A19CitaId, H004U22_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            H004U23_A34DisponibilidadId, H004U23_A67DisponibilidadFecha, H004U23_n67DisponibilidadFecha
            }
            , new Object[] {
            H004U25_A40000CitaId, H004U25_n40000CitaId
            }
            , new Object[] {
            H004U27_A40001CitaId, H004U27_n40001CitaId
            }
            , new Object[] {
            H004U29_A40002CitaId, H004U29_n40002CitaId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV24Contador ;
   private short AV32ValId1 ;
   private short AV33ValId2 ;
   private int A19CitaId ;
   private int A21SGCitaDisponibilidadId ;
   private int A34DisponibilidadId ;
   private int A40000CitaId ;
   private int A40001CitaId ;
   private int A40002CitaId ;
   private int divSectionseleccionafamiliar_Visible ;
   private int AV17PacienteFamiliarId ;
   private int divTablemicita_Visible ;
   private int divTablecitafamiliarcell_Visible ;
   private int divTablecitafamiliar_Visible ;
   private int AV18PacienteId ;
   private int AV36GXV1 ;
   private int AV37GXV2 ;
   private int AV11DisponiblidadId ;
   private int AV30ValidarId ;
   private int AV41GXV3 ;
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
   private String divMaintable_Internalname ;
   private String divTable1_Internalname ;
   private String divTable2_Internalname ;
   private String divSectiontitlecitas_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String divTable5_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String divSectionseleccionafamiliar_Internalname ;
   private String divTablemicita_Internalname ;
   private String lblTextblocktable_Internalname ;
   private String lblTextblocktable_Caption ;
   private String lblTextblocktable_Jsonclick ;
   private String divTablecitafamiliarcell_Internalname ;
   private String divTablecitafamiliar_Internalname ;
   private String lblTextblockpacientefamiliar_Internalname ;
   private String lblTextblockpacientefamiliar_Caption ;
   private String lblTextblockpacientefamiliar_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private java.util.Date A67DisponibilidadFecha ;
   private java.util.Date AV10disponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean AV16MisCitas ;
   private boolean AV6CitaFamiliar ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000CitaId ;
   private boolean n40001CitaId ;
   private boolean n40002CitaId ;
   private boolean returnInSub ;
   private boolean n67DisponibilidadFecha ;
   private String AV22TableFamiliar ;
   private String AV20Table ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV21WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private ICheckbox chkavMiscitas ;
   private ICheckbox chkavCitafamiliar ;
   private HTMLChoice cmbavPacientefamiliarid ;
   private IDataStoreProvider pr_default ;
   private int[] H004U3_A40000CitaId ;
   private boolean[] H004U3_n40000CitaId ;
   private int[] H004U5_A40001CitaId ;
   private boolean[] H004U5_n40001CitaId ;
   private int[] H004U7_A40002CitaId ;
   private boolean[] H004U7_n40002CitaId ;
   private int[] H004U9_A40000CitaId ;
   private boolean[] H004U9_n40000CitaId ;
   private int[] H004U11_A40001CitaId ;
   private boolean[] H004U11_n40001CitaId ;
   private int[] H004U13_A40002CitaId ;
   private boolean[] H004U13_n40002CitaId ;
   private int[] H004U14_A19CitaId ;
   private int[] H004U14_A21SGCitaDisponibilidadId ;
   private int[] H004U15_A34DisponibilidadId ;
   private java.util.Date[] H004U15_A67DisponibilidadFecha ;
   private boolean[] H004U15_n67DisponibilidadFecha ;
   private int[] H004U17_A40000CitaId ;
   private boolean[] H004U17_n40000CitaId ;
   private int[] H004U19_A40001CitaId ;
   private boolean[] H004U19_n40001CitaId ;
   private int[] H004U21_A40002CitaId ;
   private boolean[] H004U21_n40002CitaId ;
   private int[] H004U22_A19CitaId ;
   private int[] H004U22_A21SGCitaDisponibilidadId ;
   private int[] H004U23_A34DisponibilidadId ;
   private java.util.Date[] H004U23_A67DisponibilidadFecha ;
   private boolean[] H004U23_n67DisponibilidadFecha ;
   private int[] H004U25_A40000CitaId ;
   private boolean[] H004U25_n40000CitaId ;
   private int[] H004U27_A40001CitaId ;
   private boolean[] H004U27_n40001CitaId ;
   private int[] H004U29_A40002CitaId ;
   private boolean[] H004U29_n40002CitaId ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente> AV8CitasFamiliarList ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente> AV15ListadoCitas ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoCitasPorPaciente> GXv_objcol_SdtSDTListadoCitasPorPaciente2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> AV13FamiliarList ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox1[] ;
   private com.projectthani.SdtSDTListadoCitasPorPaciente AV14ListadoCita ;
   private com.projectthani.SdtSDTListadoCitasPorPaciente AV5CitasFamiliarItem ;
   private com.projectthani.SdtSDTListadoPacienteFamiliarComboBox AV12FamiliarItem ;
}

final  class wcmiscitas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H004U3", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT [CitaId] AS CitaId FROM [Cita] WHERE [CitaId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U5", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 0) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U7", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 1) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U9", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT [CitaId] AS CitaId FROM [Cita] WHERE [CitaId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U11", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 0) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U13", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 1) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U14", "SELECT [CitaId], [SGCitaDisponibilidadId] FROM [Cita] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U15", "SELECT [DisponibilidadId], [DisponibilidadFecha] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U17", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT [CitaId] AS CitaId FROM [Cita] WHERE [CitaId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U19", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 0) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U21", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 1) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U22", "SELECT [CitaId], [SGCitaDisponibilidadId] FROM [Cita] WHERE [CitaId] = ? ORDER BY [CitaId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U23", "SELECT [DisponibilidadId], [DisponibilidadFecha] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ORDER BY [DisponibilidadId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U25", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT [CitaId] AS CitaId FROM [Cita] WHERE [CitaId] = ? ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U27", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 0) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H004U29", "SELECT COALESCE( T1.[CitaId], 0) AS CitaId FROM (SELECT MIN([CitaId]) AS CitaId FROM [RecetaMedica] WHERE ([CitaId] = ?) AND ([RecetaMedicaFlag] = 1) ) T1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 15 :
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
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

