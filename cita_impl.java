package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class cita_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A20PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A20PacienteId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A21SGCitaDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A21SGCitaDisponibilidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A81SGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadProfesionalId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A81SGCitaDisponibilidadProfesionalId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A70SGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadEspecialidadId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A70SGCitaDisponibilidadEspecialidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_24") == 0 )
      {
         A72SGCitaDisponibilidadSedeId = (short)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadSedeId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_24( A72SGCitaDisponibilidadSedeId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
      {
         A76SGCitaDisponibilidadClinicaId = (short)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadClinicaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_25( A76SGCitaDisponibilidadClinicaId) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV28CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28CitaId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV28CitaId), "ZZZZZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_7-156546", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCitaCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public cita_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public cita_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cita_impl.class ));
   }

   public cita_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
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

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.wwpbaseobjects.workwithplusmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbCitaTipoDiagnostico.getItemCount() > 0 )
      {
         A65CitaTipoDiagnostico = cmbCitaTipoDiagnostico.getValidValue(A65CitaTipoDiagnostico) ;
         n65CitaTipoDiagnostico = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaTipoDiagnostico.setValue( GXutil.rtrim( A65CitaTipoDiagnostico) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaTipoDiagnostico.getInternalname(), "Values", cmbCitaTipoDiagnostico.ToJavascriptSource(), true);
      }
      if ( cmbCitaEstadoCita.getItemCount() > 0 )
      {
         A89CitaEstadoCita = cmbCitaEstadoCita.getValidValue(A89CitaEstadoCita) ;
         n89CitaEstadoCita = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A89CitaEstadoCita", A89CitaEstadoCita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaEstadoCita.setValue( GXutil.rtrim( A89CitaEstadoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoCita.getInternalname(), "Values", cmbCitaEstadoCita.ToJavascriptSource(), true);
      }
      if ( cmbCitaEstado.getItemCount() > 0 )
      {
         A95CitaEstado = cmbCitaEstado.getValidValue(A95CitaEstado) ;
         n95CitaEstado = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A95CitaEstado", A95CitaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaEstado.setValue( GXutil.rtrim( A95CitaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstado.getInternalname(), "Values", cmbCitaEstado.ToJavascriptSource(), true);
      }
      A97CitaConsentimiento = GXutil.strtobool( GXutil.booltostr( A97CitaConsentimiento)) ;
      n97CitaConsentimiento = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A97CitaConsentimiento", A97CitaConsentimiento);
      A101CitaGestante = GXutil.strtobool( GXutil.booltostr( A101CitaGestante)) ;
      n101CitaGestante = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A101CitaGestante", A101CitaGestante);
      if ( cmbCitaEstadoPago.getItemCount() > 0 )
      {
         A102CitaEstadoPago = cmbCitaEstadoPago.getValidValue(A102CitaEstadoPago) ;
         n102CitaEstadoPago = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A102CitaEstadoPago", A102CitaEstadoPago);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaEstadoPago.setValue( GXutil.rtrim( A102CitaEstadoPago) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoPago.getInternalname(), "Values", cmbCitaEstadoPago.ToJavascriptSource(), true);
      }
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainTransaction", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContent", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaCode_Internalname, "Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaCode_Internalname, A64CitaCode, GXutil.rtrim( localUtil.format( A64CitaCode, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaCode_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedpacienteid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpacienteid_Internalname, "Paciente Id", "", "", lblTextblockpacienteid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_pacienteid.setProperty("Caption", Combo_pacienteid_Caption);
      ucCombo_pacienteid.setProperty("Cls", Combo_pacienteid_Cls);
      ucCombo_pacienteid.setProperty("DataListProc", Combo_pacienteid_Datalistproc);
      ucCombo_pacienteid.setProperty("DataListProcParametersPrefix", Combo_pacienteid_Datalistprocparametersprefix);
      ucCombo_pacienteid.setProperty("EmptyItem", Combo_pacienteid_Emptyitem);
      ucCombo_pacienteid.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_pacienteid.setProperty("DropDownOptionsData", AV17PacienteId_Data);
      ucCombo_pacienteid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_pacienteid_Internalname, "COMBO_PACIENTEIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteId_Internalname, "Paciente Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteId_Jsonclick, 0, "Attribute", "", "", "", "", edtPacienteId_Visible, edtPacienteId_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoPaterno_Internalname, "Paciente Apellido Paterno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoPaterno_Internalname, A103PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoPaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteApellidoPaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoMaterno_Internalname, "Paciente Apellido Materno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoMaterno_Internalname, A104PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoMaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteApellidoMaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombres_Internalname, "Paciente Nombres", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombres_Internalname, A105PacienteNombres, GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteNombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNroDocumento_Internalname, "Paciente Nro Documento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNroDocumento_Internalname, A106PacienteNroDocumento, GXutil.rtrim( localUtil.format( A106PacienteNroDocumento, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNroDocumento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteNroDocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaTipoDiagnostico.getInternalname(), "Tipo Diagnostico", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaTipoDiagnostico, cmbCitaTipoDiagnostico.getInternalname(), GXutil.rtrim( A65CitaTipoDiagnostico), 1, cmbCitaTipoDiagnostico.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbCitaTipoDiagnostico.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(1), "HLP_Cita.htm");
      cmbCitaTipoDiagnostico.setValue( GXutil.rtrim( A65CitaTipoDiagnostico) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaTipoDiagnostico.getInternalname(), "Values", cmbCitaTipoDiagnostico.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedsgcitadisponibilidadid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksgcitadisponibilidadid_Internalname, "Disponibilidad Id", "", "", lblTextblocksgcitadisponibilidadid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_sgcitadisponibilidadid.setProperty("Caption", Combo_sgcitadisponibilidadid_Caption);
      ucCombo_sgcitadisponibilidadid.setProperty("Cls", Combo_sgcitadisponibilidadid_Cls);
      ucCombo_sgcitadisponibilidadid.setProperty("DataListProc", Combo_sgcitadisponibilidadid_Datalistproc);
      ucCombo_sgcitadisponibilidadid.setProperty("DataListProcParametersPrefix", Combo_sgcitadisponibilidadid_Datalistprocparametersprefix);
      ucCombo_sgcitadisponibilidadid.setProperty("EmptyItem", Combo_sgcitadisponibilidadid_Emptyitem);
      ucCombo_sgcitadisponibilidadid.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_sgcitadisponibilidadid.setProperty("DropDownOptionsData", AV25SGCitaDisponibilidadId_Data);
      ucCombo_sgcitadisponibilidadid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_sgcitadisponibilidadid_Internalname, "COMBO_SGCITADISPONIBILIDADIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadId_Internalname, "SGCita Disponibilidad Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadId_Jsonclick, 0, "Attribute", "", "", "", "", edtSGCitaDisponibilidadId_Visible, edtSGCitaDisponibilidadId_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadFecha_Internalname, "Disponibilidad Fecha", "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadFecha_Internalname, localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"), localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadFecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtSGCitaDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadHoraInicio_Internalname, "Hora Inicio", "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadHoraInicio_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadHoraInicio_Internalname, localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A68SGCitaDisponibilidadHoraInicio, "99:99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadHoraInicio_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtSGCitaDisponibilidadHoraInicio_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadHoraInicio_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadHoraInicio_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadHoraFin_Internalname, "Hora Fin", "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadHoraFin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadHoraFin_Internalname, localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A387SGCitaDisponibilidadHoraFin, "99:99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadHoraFin_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtSGCitaDisponibilidadHoraFin_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadHoraFin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadHoraFin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Especialidad Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadEspecialidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadEspecialidadId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Especialidad Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, A146SGCitaDisponibilidadEspecialidadNombre, GXutil.rtrim( localUtil.format( A146SGCitaDisponibilidadEspecialidadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadSedeId_Internalname, "Sede Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadSedeId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadSedeId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadSedeId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadSedeNombre_Internalname, "Sede Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadSedeNombre_Internalname, A73SGCitaDisponibilidadSedeNombre, GXutil.rtrim( localUtil.format( A73SGCitaDisponibilidadSedeNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadSedeNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadSedeNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, "Clinica Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadClinicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Clinica Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, A78SGCitaDisponibilidadClinicaNombre, GXutil.rtrim( localUtil.format( A78SGCitaDisponibilidadClinicaNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, "Profesional Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, "Full Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, A82SGCitaDisponibilidadProFullName, GXutil.rtrim( localUtil.format( A82SGCitaDisponibilidadProFullName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProFullName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadProFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProCOP_Internalname, "Pro COP", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProCOP_Internalname, A87SGCitaDisponibilidadProCOP, GXutil.rtrim( localUtil.format( A87SGCitaDisponibilidadProCOP, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProCOP_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadProCOP_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaEstadoCita.getInternalname(), "Estado Cita", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaEstadoCita, cmbCitaEstadoCita.getInternalname(), GXutil.rtrim( A89CitaEstadoCita), 1, cmbCitaEstadoCita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaEstadoCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,139);\"", "", true, (byte)(1), "HLP_Cita.htm");
      cmbCitaEstadoCita.setValue( GXutil.rtrim( A89CitaEstadoCita) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoCita.getInternalname(), "Values", cmbCitaEstadoCita.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaInforme_Internalname, "Informe", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaInforme_Internalname, A90CitaInforme, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,144);\"", (short)(0), 1, edtCitaInforme_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaAntecedentes_Internalname, "Antecedentes", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaAntecedentes_Internalname, A100CitaAntecedentes, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,149);\"", (short)(0), 1, edtCitaAntecedentes_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaLink_Internalname, "Link", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 154,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaLink_Internalname, A91CitaLink, GXutil.rtrim( localUtil.format( A91CitaLink, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,154);\"", "'"+""+"'"+",false,"+"'"+""+"'", A91CitaLink, "_blank", "", "", edtCitaLink_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaLink_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaFechaReserva_Internalname, "Fecha Reserva", "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCitaFechaReserva_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaFechaReserva_Internalname, localUtil.ttoc( A92CitaFechaReserva, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A92CitaFechaReserva, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onblur(this,159);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaFechaReserva_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtCitaFechaReserva_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtCitaFechaReserva_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCitaFechaReserva_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaLog_Internalname, "Log", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 164,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaLog_Internalname, A93CitaLog, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,164);\"", (short)(0), 1, edtCitaLog_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaEmailGenLink_Internalname, "Gen Link", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaEmailGenLink_Internalname, A94CitaEmailGenLink, GXutil.rtrim( localUtil.format( A94CitaEmailGenLink, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,169);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A94CitaEmailGenLink, "", "", "", edtCitaEmailGenLink_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaEmailGenLink_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 174,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaEstado, cmbCitaEstado.getInternalname(), GXutil.rtrim( A95CitaEstado), 1, cmbCitaEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,174);\"", "", true, (byte)(1), "HLP_Cita.htm");
      cmbCitaEstado.setValue( GXutil.rtrim( A95CitaEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstado.getInternalname(), "Values", cmbCitaEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaMotivoConsulta_Internalname, "Motivo Consulta", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 179,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaMotivoConsulta_Internalname, A99CitaMotivoConsulta, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,179);\"", (short)(0), 1, edtCitaMotivoConsulta_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaArchivoNombre_Internalname, "Archivo Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 184,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaArchivoNombre_Internalname, A96CitaArchivoNombre, GXutil.rtrim( localUtil.format( A96CitaArchivoNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,184);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaArchivoNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaArchivoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaArchivo_Internalname, "Archivo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'',false,'',0)\"" ;
      edtCitaArchivo_Filetype = "tmp" ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "Filetype", edtCitaArchivo_Filetype, true);
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
            httpContext.ajax_rsp_assign_attri("", false, "A98CitaArchivo", A98CitaArchivo);
            httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
            edtCitaArchivo_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "Filetype", edtCitaArchivo_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
      }
      com.projectthani.GxWebStd.gx_blob_field( httpContext, edtCitaArchivo_Internalname, GXutil.rtrim( A98CitaArchivo), httpContext.getResourceRelative(A98CitaArchivo), ((GXutil.strcmp("", edtCitaArchivo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtCitaArchivo_Filetype)==0) ? A98CitaArchivo : edtCitaArchivo_Filetype)) : edtCitaArchivo_Contenttype), false, "", edtCitaArchivo_Parameters, 0, edtCitaArchivo_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtCitaArchivo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,189);\"", "", "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaArchivoExtencion_Internalname, "Archivo Extencion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 194,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaArchivoExtencion_Internalname, A333CitaArchivoExtencion, GXutil.rtrim( localUtil.format( A333CitaArchivoExtencion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,194);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaArchivoExtencion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaArchivoExtencion_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, chkCitaConsentimiento.getInternalname(), "Consentimiento", "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkCitaConsentimiento.getInternalname(), GXutil.booltostr( A97CitaConsentimiento), "", "Consentimiento", 1, chkCitaConsentimiento.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(199, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,199);\"");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, chkCitaGestante.getInternalname(), "Gestante", "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      drawcontrols1( ) ;
   }

   public void drawcontrols1( )
   {
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 204,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkCitaGestante.getInternalname(), GXutil.booltostr( A101CitaGestante), "", "Gestante", 1, chkCitaGestante.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(204, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,204);\"");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaEstadoPago.getInternalname(), "Estado Pago", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 209,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaEstadoPago, cmbCitaEstadoPago.getInternalname(), GXutil.rtrim( A102CitaEstadoPago), 1, cmbCitaEstadoPago.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaEstadoPago.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,209);\"", "", true, (byte)(1), "HLP_Cita.htm");
      cmbCitaEstadoPago.setValue( GXutil.rtrim( A102CitaEstadoPago) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoPago.getInternalname(), "Values", cmbCitaEstadoPago.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaPeso_Internalname, "Peso", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 214,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaPeso_Internalname, GXutil.ltrim( localUtil.ntoc( A306CitaPeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtCitaPeso_Enabled!=0) ? localUtil.format( A306CitaPeso, "ZZ9.99") : localUtil.format( A306CitaPeso, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,214);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaPeso_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaPeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaEstatura_Internalname, "Estatura", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 219,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaEstatura_Internalname, GXutil.ltrim( localUtil.ntoc( A307CitaEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtCitaEstatura_Enabled!=0) ? localUtil.format( A307CitaEstatura, "9.99") : localUtil.format( A307CitaEstatura, "9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,219);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaEstatura_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaEstatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 224,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 226,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 228,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Cita.htm");
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
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_pacienteid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombopacienteid_Internalname, GXutil.ltrim( localUtil.ntoc( AV22ComboPacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombopacienteid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV22ComboPacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV22ComboPacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopacienteid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopacienteid_Visible, edtavCombopacienteid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_sgcitadisponibilidadid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombosgcitadisponibilidadid_Internalname, GXutil.ltrim( localUtil.ntoc( AV26ComboSGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombosgcitadisponibilidadid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV26ComboSGCitaDisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV26ComboSGCitaDisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosgcitadisponibilidadid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosgcitadisponibilidadid_Visible, edtavCombosgcitadisponibilidadid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Cita.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e110A2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPACIENTEID_DATA"), AV17PacienteId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSGCITADISPONIBILIDADID_DATA"), AV25SGCitaDisponibilidadId_Data);
            /* Read saved values. */
            Z19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z19CitaId"), ",", ".")) ;
            Z64CitaCode = httpContext.cgiGet( "Z64CitaCode") ;
            Z65CitaTipoDiagnostico = httpContext.cgiGet( "Z65CitaTipoDiagnostico") ;
            n65CitaTipoDiagnostico = ((GXutil.strcmp("", A65CitaTipoDiagnostico)==0) ? true : false) ;
            Z89CitaEstadoCita = httpContext.cgiGet( "Z89CitaEstadoCita") ;
            n89CitaEstadoCita = ((GXutil.strcmp("", A89CitaEstadoCita)==0) ? true : false) ;
            Z91CitaLink = httpContext.cgiGet( "Z91CitaLink") ;
            n91CitaLink = ((GXutil.strcmp("", A91CitaLink)==0) ? true : false) ;
            Z92CitaFechaReserva = localUtil.ctot( httpContext.cgiGet( "Z92CitaFechaReserva"), 0) ;
            n92CitaFechaReserva = (GXutil.dateCompare(GXutil.nullDate(), A92CitaFechaReserva) ? true : false) ;
            Z93CitaLog = httpContext.cgiGet( "Z93CitaLog") ;
            n93CitaLog = ((GXutil.strcmp("", A93CitaLog)==0) ? true : false) ;
            Z94CitaEmailGenLink = httpContext.cgiGet( "Z94CitaEmailGenLink") ;
            n94CitaEmailGenLink = ((GXutil.strcmp("", A94CitaEmailGenLink)==0) ? true : false) ;
            Z95CitaEstado = httpContext.cgiGet( "Z95CitaEstado") ;
            n95CitaEstado = ((GXutil.strcmp("", A95CitaEstado)==0) ? true : false) ;
            Z96CitaArchivoNombre = httpContext.cgiGet( "Z96CitaArchivoNombre") ;
            n96CitaArchivoNombre = ((GXutil.strcmp("", A96CitaArchivoNombre)==0) ? true : false) ;
            Z333CitaArchivoExtencion = httpContext.cgiGet( "Z333CitaArchivoExtencion") ;
            n333CitaArchivoExtencion = ((GXutil.strcmp("", A333CitaArchivoExtencion)==0) ? true : false) ;
            Z97CitaConsentimiento = GXutil.strtobool( httpContext.cgiGet( "Z97CitaConsentimiento")) ;
            n97CitaConsentimiento = ((false==A97CitaConsentimiento) ? true : false) ;
            Z101CitaGestante = GXutil.strtobool( httpContext.cgiGet( "Z101CitaGestante")) ;
            n101CitaGestante = ((false==A101CitaGestante) ? true : false) ;
            Z102CitaEstadoPago = httpContext.cgiGet( "Z102CitaEstadoPago") ;
            n102CitaEstadoPago = ((GXutil.strcmp("", A102CitaEstadoPago)==0) ? true : false) ;
            Z306CitaPeso = localUtil.ctond( httpContext.cgiGet( "Z306CitaPeso")) ;
            n306CitaPeso = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A306CitaPeso)==0) ? true : false) ;
            Z307CitaEstatura = localUtil.ctond( httpContext.cgiGet( "Z307CitaEstatura")) ;
            n307CitaEstatura = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A307CitaEstatura)==0) ? true : false) ;
            Z20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z20PacienteId"), ",", ".")) ;
            Z21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "Z21SGCitaDisponibilidadId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "N20PacienteId"), ",", ".")) ;
            N21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "N21SGCitaDisponibilidadId"), ",", ".")) ;
            A84ProfesionalNombres = httpContext.cgiGet( "PROFESIONALNOMBRES") ;
            n84ProfesionalNombres = false ;
            A85ProfesionalApellidoPaterno = httpContext.cgiGet( "PROFESIONALAPELLIDOPATERNO") ;
            n85ProfesionalApellidoPaterno = false ;
            A86ProfesionalApellidoMaterno = httpContext.cgiGet( "PROFESIONALAPELLIDOMATERNO") ;
            n86ProfesionalApellidoMaterno = false ;
            AV28CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "vCITAID"), ",", ".")) ;
            AV12Insert_PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PACIENTEID"), ",", ".")) ;
            AV13Insert_SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SGCITADISPONIBILIDADID"), ",", ".")) ;
            AV29Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_pacienteid_Objectcall = httpContext.cgiGet( "COMBO_PACIENTEID_Objectcall") ;
            Combo_pacienteid_Class = httpContext.cgiGet( "COMBO_PACIENTEID_Class") ;
            Combo_pacienteid_Icontype = httpContext.cgiGet( "COMBO_PACIENTEID_Icontype") ;
            Combo_pacienteid_Icon = httpContext.cgiGet( "COMBO_PACIENTEID_Icon") ;
            Combo_pacienteid_Caption = httpContext.cgiGet( "COMBO_PACIENTEID_Caption") ;
            Combo_pacienteid_Tooltip = httpContext.cgiGet( "COMBO_PACIENTEID_Tooltip") ;
            Combo_pacienteid_Cls = httpContext.cgiGet( "COMBO_PACIENTEID_Cls") ;
            Combo_pacienteid_Selectedvalue_set = httpContext.cgiGet( "COMBO_PACIENTEID_Selectedvalue_set") ;
            Combo_pacienteid_Selectedvalue_get = httpContext.cgiGet( "COMBO_PACIENTEID_Selectedvalue_get") ;
            Combo_pacienteid_Selectedtext_set = httpContext.cgiGet( "COMBO_PACIENTEID_Selectedtext_set") ;
            Combo_pacienteid_Selectedtext_get = httpContext.cgiGet( "COMBO_PACIENTEID_Selectedtext_get") ;
            Combo_pacienteid_Gamoauthtoken = httpContext.cgiGet( "COMBO_PACIENTEID_Gamoauthtoken") ;
            Combo_pacienteid_Ddointernalname = httpContext.cgiGet( "COMBO_PACIENTEID_Ddointernalname") ;
            Combo_pacienteid_Titlecontrolalign = httpContext.cgiGet( "COMBO_PACIENTEID_Titlecontrolalign") ;
            Combo_pacienteid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PACIENTEID_Dropdownoptionstype") ;
            Combo_pacienteid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Enabled")) ;
            Combo_pacienteid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Visible")) ;
            Combo_pacienteid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PACIENTEID_Titlecontrolidtoreplace") ;
            Combo_pacienteid_Datalisttype = httpContext.cgiGet( "COMBO_PACIENTEID_Datalisttype") ;
            Combo_pacienteid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Allowmultipleselection")) ;
            Combo_pacienteid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PACIENTEID_Datalistfixedvalues") ;
            Combo_pacienteid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Isgriditem")) ;
            Combo_pacienteid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Hasdescription")) ;
            Combo_pacienteid_Datalistproc = httpContext.cgiGet( "COMBO_PACIENTEID_Datalistproc") ;
            Combo_pacienteid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PACIENTEID_Datalistprocparametersprefix") ;
            Combo_pacienteid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PACIENTEID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_pacienteid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Includeonlyselectedoption")) ;
            Combo_pacienteid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Includeselectalloption")) ;
            Combo_pacienteid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Emptyitem")) ;
            Combo_pacienteid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PACIENTEID_Includeaddnewoption")) ;
            Combo_pacienteid_Htmltemplate = httpContext.cgiGet( "COMBO_PACIENTEID_Htmltemplate") ;
            Combo_pacienteid_Multiplevaluestype = httpContext.cgiGet( "COMBO_PACIENTEID_Multiplevaluestype") ;
            Combo_pacienteid_Loadingdata = httpContext.cgiGet( "COMBO_PACIENTEID_Loadingdata") ;
            Combo_pacienteid_Noresultsfound = httpContext.cgiGet( "COMBO_PACIENTEID_Noresultsfound") ;
            Combo_pacienteid_Emptyitemtext = httpContext.cgiGet( "COMBO_PACIENTEID_Emptyitemtext") ;
            Combo_pacienteid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PACIENTEID_Onlyselectedvalues") ;
            Combo_pacienteid_Selectalltext = httpContext.cgiGet( "COMBO_PACIENTEID_Selectalltext") ;
            Combo_pacienteid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PACIENTEID_Multiplevaluesseparator") ;
            Combo_pacienteid_Addnewoptiontext = httpContext.cgiGet( "COMBO_PACIENTEID_Addnewoptiontext") ;
            Combo_sgcitadisponibilidadid_Objectcall = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Objectcall") ;
            Combo_sgcitadisponibilidadid_Class = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Class") ;
            Combo_sgcitadisponibilidadid_Icontype = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Icontype") ;
            Combo_sgcitadisponibilidadid_Icon = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Icon") ;
            Combo_sgcitadisponibilidadid_Caption = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Caption") ;
            Combo_sgcitadisponibilidadid_Tooltip = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Tooltip") ;
            Combo_sgcitadisponibilidadid_Cls = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Cls") ;
            Combo_sgcitadisponibilidadid_Selectedvalue_set = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Selectedvalue_set") ;
            Combo_sgcitadisponibilidadid_Selectedvalue_get = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Selectedvalue_get") ;
            Combo_sgcitadisponibilidadid_Selectedtext_set = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Selectedtext_set") ;
            Combo_sgcitadisponibilidadid_Selectedtext_get = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Selectedtext_get") ;
            Combo_sgcitadisponibilidadid_Gamoauthtoken = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Gamoauthtoken") ;
            Combo_sgcitadisponibilidadid_Ddointernalname = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Ddointernalname") ;
            Combo_sgcitadisponibilidadid_Titlecontrolalign = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Titlecontrolalign") ;
            Combo_sgcitadisponibilidadid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Dropdownoptionstype") ;
            Combo_sgcitadisponibilidadid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Enabled")) ;
            Combo_sgcitadisponibilidadid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Visible")) ;
            Combo_sgcitadisponibilidadid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Titlecontrolidtoreplace") ;
            Combo_sgcitadisponibilidadid_Datalisttype = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Datalisttype") ;
            Combo_sgcitadisponibilidadid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Allowmultipleselection")) ;
            Combo_sgcitadisponibilidadid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Datalistfixedvalues") ;
            Combo_sgcitadisponibilidadid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Isgriditem")) ;
            Combo_sgcitadisponibilidadid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Hasdescription")) ;
            Combo_sgcitadisponibilidadid_Datalistproc = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Datalistproc") ;
            Combo_sgcitadisponibilidadid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Datalistprocparametersprefix") ;
            Combo_sgcitadisponibilidadid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_sgcitadisponibilidadid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Includeonlyselectedoption")) ;
            Combo_sgcitadisponibilidadid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Includeselectalloption")) ;
            Combo_sgcitadisponibilidadid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Emptyitem")) ;
            Combo_sgcitadisponibilidadid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Includeaddnewoption")) ;
            Combo_sgcitadisponibilidadid_Htmltemplate = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Htmltemplate") ;
            Combo_sgcitadisponibilidadid_Multiplevaluestype = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Multiplevaluestype") ;
            Combo_sgcitadisponibilidadid_Loadingdata = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Loadingdata") ;
            Combo_sgcitadisponibilidadid_Noresultsfound = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Noresultsfound") ;
            Combo_sgcitadisponibilidadid_Emptyitemtext = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Emptyitemtext") ;
            Combo_sgcitadisponibilidadid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Onlyselectedvalues") ;
            Combo_sgcitadisponibilidadid_Selectalltext = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Selectalltext") ;
            Combo_sgcitadisponibilidadid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Multiplevaluesseparator") ;
            Combo_sgcitadisponibilidadid_Addnewoptiontext = httpContext.cgiGet( "COMBO_SGCITADISPONIBILIDADID_Addnewoptiontext") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            edtCitaArchivo_Filename = httpContext.cgiGet( "CITAARCHIVO_Filename") ;
            edtCitaArchivo_Filetype = httpContext.cgiGet( "CITAARCHIVO_Filetype") ;
            /* Read variables values. */
            A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
            n19CitaId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PACIENTEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPacienteId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A20PacienteId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            }
            else
            {
               A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            }
            A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
            A106PacienteNroDocumento = httpContext.cgiGet( edtPacienteNroDocumento_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
            cmbCitaTipoDiagnostico.setValue( httpContext.cgiGet( cmbCitaTipoDiagnostico.getInternalname()) );
            A65CitaTipoDiagnostico = httpContext.cgiGet( cmbCitaTipoDiagnostico.getInternalname()) ;
            n65CitaTipoDiagnostico = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
            n65CitaTipoDiagnostico = ((GXutil.strcmp("", A65CitaTipoDiagnostico)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SGCITADISPONIBILIDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSGCitaDisponibilidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A21SGCitaDisponibilidadId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
            }
            else
            {
               A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
            }
            A66SGCitaDisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 3) ;
            n66SGCitaDisponibilidadFecha = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            A68SGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraInicio_Internalname))) ;
            n68SGCitaDisponibilidadHoraInicio = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            A387SGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraFin_Internalname))) ;
            n387SGCitaDisponibilidadHoraFin = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            A70SGCitaDisponibilidadEspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
            A146SGCitaDisponibilidadEspecialidadNombre = httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
            A72SGCitaDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadSedeId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
            A73SGCitaDisponibilidadSedeNombre = httpContext.cgiGet( edtSGCitaDisponibilidadSedeNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
            A76SGCitaDisponibilidadClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadClinicaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
            A78SGCitaDisponibilidadClinicaNombre = httpContext.cgiGet( edtSGCitaDisponibilidadClinicaNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
            A81SGCitaDisponibilidadProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadProfesionalId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
            A82SGCitaDisponibilidadProFullName = httpContext.cgiGet( edtSGCitaDisponibilidadProFullName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
            A87SGCitaDisponibilidadProCOP = httpContext.cgiGet( edtSGCitaDisponibilidadProCOP_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
            cmbCitaEstadoCita.setValue( httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) );
            A89CitaEstadoCita = httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) ;
            n89CitaEstadoCita = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A89CitaEstadoCita", A89CitaEstadoCita);
            n89CitaEstadoCita = ((GXutil.strcmp("", A89CitaEstadoCita)==0) ? true : false) ;
            A90CitaInforme = httpContext.cgiGet( edtCitaInforme_Internalname) ;
            n90CitaInforme = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A90CitaInforme", A90CitaInforme);
            n90CitaInforme = ((GXutil.strcmp("", A90CitaInforme)==0) ? true : false) ;
            A100CitaAntecedentes = httpContext.cgiGet( edtCitaAntecedentes_Internalname) ;
            n100CitaAntecedentes = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A100CitaAntecedentes", A100CitaAntecedentes);
            n100CitaAntecedentes = ((GXutil.strcmp("", A100CitaAntecedentes)==0) ? true : false) ;
            A91CitaLink = httpContext.cgiGet( edtCitaLink_Internalname) ;
            n91CitaLink = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A91CitaLink", A91CitaLink);
            n91CitaLink = ((GXutil.strcmp("", A91CitaLink)==0) ? true : false) ;
            if ( localUtil.vcdtime( httpContext.cgiGet( edtCitaFechaReserva_Internalname), (byte)(3), (byte)(0)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "CITAFECHARESERVA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaFechaReserva_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
               n92CitaFechaReserva = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A92CitaFechaReserva", localUtil.ttoc( A92CitaFechaReserva, 8, 5, 0, 3, "/", ":", " "));
            }
            else
            {
               A92CitaFechaReserva = localUtil.ctot( httpContext.cgiGet( edtCitaFechaReserva_Internalname)) ;
               n92CitaFechaReserva = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A92CitaFechaReserva", localUtil.ttoc( A92CitaFechaReserva, 8, 5, 0, 3, "/", ":", " "));
            }
            n92CitaFechaReserva = (GXutil.dateCompare(GXutil.nullDate(), A92CitaFechaReserva) ? true : false) ;
            A93CitaLog = httpContext.cgiGet( edtCitaLog_Internalname) ;
            n93CitaLog = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A93CitaLog", A93CitaLog);
            n93CitaLog = ((GXutil.strcmp("", A93CitaLog)==0) ? true : false) ;
            A94CitaEmailGenLink = httpContext.cgiGet( edtCitaEmailGenLink_Internalname) ;
            n94CitaEmailGenLink = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A94CitaEmailGenLink", A94CitaEmailGenLink);
            n94CitaEmailGenLink = ((GXutil.strcmp("", A94CitaEmailGenLink)==0) ? true : false) ;
            cmbCitaEstado.setValue( httpContext.cgiGet( cmbCitaEstado.getInternalname()) );
            A95CitaEstado = httpContext.cgiGet( cmbCitaEstado.getInternalname()) ;
            n95CitaEstado = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A95CitaEstado", A95CitaEstado);
            n95CitaEstado = ((GXutil.strcmp("", A95CitaEstado)==0) ? true : false) ;
            A99CitaMotivoConsulta = httpContext.cgiGet( edtCitaMotivoConsulta_Internalname) ;
            n99CitaMotivoConsulta = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A99CitaMotivoConsulta", A99CitaMotivoConsulta);
            n99CitaMotivoConsulta = ((GXutil.strcmp("", A99CitaMotivoConsulta)==0) ? true : false) ;
            A96CitaArchivoNombre = httpContext.cgiGet( edtCitaArchivoNombre_Internalname) ;
            n96CitaArchivoNombre = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A96CitaArchivoNombre", A96CitaArchivoNombre);
            n96CitaArchivoNombre = ((GXutil.strcmp("", A96CitaArchivoNombre)==0) ? true : false) ;
            A98CitaArchivo = httpContext.cgiGet( edtCitaArchivo_Internalname) ;
            n98CitaArchivo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A98CitaArchivo", A98CitaArchivo);
            n98CitaArchivo = ((GXutil.strcmp("", A98CitaArchivo)==0) ? true : false) ;
            A333CitaArchivoExtencion = httpContext.cgiGet( edtCitaArchivoExtencion_Internalname) ;
            n333CitaArchivoExtencion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A333CitaArchivoExtencion", A333CitaArchivoExtencion);
            n333CitaArchivoExtencion = ((GXutil.strcmp("", A333CitaArchivoExtencion)==0) ? true : false) ;
            A97CitaConsentimiento = GXutil.strtobool( httpContext.cgiGet( chkCitaConsentimiento.getInternalname())) ;
            n97CitaConsentimiento = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A97CitaConsentimiento", A97CitaConsentimiento);
            n97CitaConsentimiento = ((false==A97CitaConsentimiento) ? true : false) ;
            A101CitaGestante = GXutil.strtobool( httpContext.cgiGet( chkCitaGestante.getInternalname())) ;
            n101CitaGestante = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A101CitaGestante", A101CitaGestante);
            n101CitaGestante = ((false==A101CitaGestante) ? true : false) ;
            cmbCitaEstadoPago.setValue( httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) );
            A102CitaEstadoPago = httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) ;
            n102CitaEstadoPago = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A102CitaEstadoPago", A102CitaEstadoPago);
            n102CitaEstadoPago = ((GXutil.strcmp("", A102CitaEstadoPago)==0) ? true : false) ;
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtCitaPeso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCitaPeso_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITAPESO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaPeso_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A306CitaPeso = DecimalUtil.ZERO ;
               n306CitaPeso = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A306CitaPeso", GXutil.ltrimstr( A306CitaPeso, 6, 2));
            }
            else
            {
               A306CitaPeso = localUtil.ctond( httpContext.cgiGet( edtCitaPeso_Internalname)) ;
               n306CitaPeso = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A306CitaPeso", GXutil.ltrimstr( A306CitaPeso, 6, 2));
            }
            n306CitaPeso = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A306CitaPeso)==0) ? true : false) ;
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtCitaEstatura_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCitaEstatura_Internalname)), DecimalUtil.stringToDec("9.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITAESTATURA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaEstatura_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A307CitaEstatura = DecimalUtil.ZERO ;
               n307CitaEstatura = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A307CitaEstatura", GXutil.ltrimstr( A307CitaEstatura, 4, 2));
            }
            else
            {
               A307CitaEstatura = localUtil.ctond( httpContext.cgiGet( edtCitaEstatura_Internalname)) ;
               n307CitaEstatura = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A307CitaEstatura", GXutil.ltrimstr( A307CitaEstatura, 4, 2));
            }
            n307CitaEstatura = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A307CitaEstatura)==0) ? true : false) ;
            AV22ComboPacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombopacienteid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboPacienteId), 8, 0));
            AV26ComboSGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombosgcitadisponibilidadid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ComboSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboSGCitaDisponibilidadId), 8, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            if ( ! (GXutil.strcmp("", A98CitaArchivo)==0) )
            {
               edtCitaArchivo_Filename = httpContext.cgiGetFileName( edtCitaArchivo_Internalname) ;
               edtCitaArchivo_Filetype = httpContext.cgiGetFileType( edtCitaArchivo_Internalname) ;
            }
            if ( (GXutil.strcmp("", A98CitaArchivo)==0) )
            {
               GXCCtlgxBlob = "CITAARCHIVO" + "_gxBlob" ;
               A98CitaArchivo = httpContext.cgiGet( GXCCtlgxBlob) ;
               n98CitaArchivo = false ;
               n98CitaArchivo = ((GXutil.strcmp("", A98CitaArchivo)==0) ? true : false) ;
            }
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Cita");
            A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
            n19CitaId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            forbiddenHiddens.add("CitaId", localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A19CitaId != Z19CitaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("cita:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A19CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
               n19CitaId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode17 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode17 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound17 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0A0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CITAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCitaId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e110A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120A2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e120A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0A17( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes0A17( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopacienteid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopacienteid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosgcitadisponibilidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosgcitadisponibilidadid_Enabled), 5, 0), true);
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_0A0( )
   {
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0A17( ) ;
         }
         else
         {
            checkExtendedTable0A17( ) ;
            closeExtendedTableCursors0A17( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0A0( )
   {
   }

   public void e110A2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtSGCitaDisponibilidadId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Visible), 5, 0), true);
      AV26ComboSGCitaDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboSGCitaDisponibilidadId), 8, 0));
      edtavCombosgcitadisponibilidadid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosgcitadisponibilidadid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosgcitadisponibilidadid_Visible), 5, 0), true);
      edtPacienteId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Visible), 5, 0), true);
      AV22ComboPacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboPacienteId), 8, 0));
      edtavCombopacienteid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopacienteid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopacienteid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPACIENTEID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOSGCITADISPONIBILIDADID' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV8IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Insert", GXv_boolean5) ;
         cita_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Update", GXv_boolean5) ;
         cita_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCita_Delete", GXv_boolean5) ;
         cita_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         while ( AV30GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PacienteId") == 0 )
            {
               AV12Insert_PacienteId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_PacienteId), 8, 0));
               if ( ! (0==AV12Insert_PacienteId) )
               {
                  AV22ComboPacienteId = AV12Insert_PacienteId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboPacienteId), 8, 0));
                  Combo_pacienteid_Selectedvalue_set = GXutil.trim( GXutil.str( AV22ComboPacienteId, 8, 0)) ;
                  ucCombo_pacienteid.sendProperty(context, "", false, Combo_pacienteid_Internalname, "SelectedValue_set", Combo_pacienteid_Selectedvalue_set);
                  GXt_char6 = AV21Combo_DataJson ;
                  GXv_char7[0] = AV19ComboSelectedValue ;
                  GXv_char8[0] = AV20ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.citaloaddvcombo(remoteHandle, context).execute( "PacienteId", "GET", false, AV28CitaId, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  cita_impl.this.AV19ComboSelectedValue = GXv_char7[0] ;
                  cita_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
                  cita_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
                  AV21Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
                  Combo_pacienteid_Selectedtext_set = AV20ComboSelectedText ;
                  ucCombo_pacienteid.sendProperty(context, "", false, Combo_pacienteid_Internalname, "SelectedText_set", Combo_pacienteid_Selectedtext_set);
                  Combo_pacienteid_Enabled = false ;
                  ucCombo_pacienteid.sendProperty(context, "", false, Combo_pacienteid_Internalname, "Enabled", GXutil.booltostr( Combo_pacienteid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SGCitaDisponibilidadId") == 0 )
            {
               AV13Insert_SGCitaDisponibilidadId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_SGCitaDisponibilidadId), 8, 0));
               if ( ! (0==AV13Insert_SGCitaDisponibilidadId) )
               {
                  AV26ComboSGCitaDisponibilidadId = AV13Insert_SGCitaDisponibilidadId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV26ComboSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboSGCitaDisponibilidadId), 8, 0));
                  Combo_sgcitadisponibilidadid_Selectedvalue_set = GXutil.trim( GXutil.str( AV26ComboSGCitaDisponibilidadId, 8, 0)) ;
                  ucCombo_sgcitadisponibilidadid.sendProperty(context, "", false, Combo_sgcitadisponibilidadid_Internalname, "SelectedValue_set", Combo_sgcitadisponibilidadid_Selectedvalue_set);
                  Combo_sgcitadisponibilidadid_Enabled = false ;
                  ucCombo_sgcitadisponibilidadid.sendProperty(context, "", false, Combo_sgcitadisponibilidadid_Internalname, "Enabled", GXutil.booltostr( Combo_sgcitadisponibilidadid_Enabled));
               }
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         }
      }
   }

   public void e120A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.citaww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'LOADCOMBOSGCITADISPONIBILIDADID' Routine */
      returnInSub = false ;
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char9[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.citaloaddvcombo(remoteHandle, context).execute( "SGCitaDisponibilidadId", Gx_mode, false, AV28CitaId, "", GXv_char9, GXv_char8, GXv_char7) ;
      cita_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
      cita_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      cita_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
      AV21Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
      Combo_sgcitadisponibilidadid_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_sgcitadisponibilidadid.sendProperty(context, "", false, Combo_sgcitadisponibilidadid_Internalname, "SelectedValue_set", Combo_sgcitadisponibilidadid_Selectedvalue_set);
      Combo_sgcitadisponibilidadid_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_sgcitadisponibilidadid.sendProperty(context, "", false, Combo_sgcitadisponibilidadid_Internalname, "SelectedText_set", Combo_sgcitadisponibilidadid_Selectedtext_set);
      AV26ComboSGCitaDisponibilidadId = (int)(GXutil.lval( AV19ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboSGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26ComboSGCitaDisponibilidadId), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_sgcitadisponibilidadid_Enabled = false ;
         ucCombo_sgcitadisponibilidadid.sendProperty(context, "", false, Combo_sgcitadisponibilidadid_Internalname, "Enabled", GXutil.booltostr( Combo_sgcitadisponibilidadid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOPACIENTEID' Routine */
      returnInSub = false ;
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char9[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.citaloaddvcombo(remoteHandle, context).execute( "PacienteId", Gx_mode, false, AV28CitaId, "", GXv_char9, GXv_char8, GXv_char7) ;
      cita_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
      cita_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      cita_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
      AV21Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
      Combo_pacienteid_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_pacienteid.sendProperty(context, "", false, Combo_pacienteid_Internalname, "SelectedValue_set", Combo_pacienteid_Selectedvalue_set);
      Combo_pacienteid_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_pacienteid.sendProperty(context, "", false, Combo_pacienteid_Internalname, "SelectedText_set", Combo_pacienteid_Selectedtext_set);
      AV22ComboPacienteId = (int)(GXutil.lval( AV19ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboPacienteId), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_pacienteid_Enabled = false ;
         ucCombo_pacienteid.sendProperty(context, "", false, Combo_pacienteid_Internalname, "Enabled", GXutil.booltostr( Combo_pacienteid_Enabled));
      }
   }

   public void zm0A17( int GX_JID )
   {
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z64CitaCode = T000A3_A64CitaCode[0] ;
            Z65CitaTipoDiagnostico = T000A3_A65CitaTipoDiagnostico[0] ;
            Z89CitaEstadoCita = T000A3_A89CitaEstadoCita[0] ;
            Z91CitaLink = T000A3_A91CitaLink[0] ;
            Z92CitaFechaReserva = T000A3_A92CitaFechaReserva[0] ;
            Z93CitaLog = T000A3_A93CitaLog[0] ;
            Z94CitaEmailGenLink = T000A3_A94CitaEmailGenLink[0] ;
            Z95CitaEstado = T000A3_A95CitaEstado[0] ;
            Z96CitaArchivoNombre = T000A3_A96CitaArchivoNombre[0] ;
            Z333CitaArchivoExtencion = T000A3_A333CitaArchivoExtencion[0] ;
            Z97CitaConsentimiento = T000A3_A97CitaConsentimiento[0] ;
            Z101CitaGestante = T000A3_A101CitaGestante[0] ;
            Z102CitaEstadoPago = T000A3_A102CitaEstadoPago[0] ;
            Z306CitaPeso = T000A3_A306CitaPeso[0] ;
            Z307CitaEstatura = T000A3_A307CitaEstatura[0] ;
            Z20PacienteId = T000A3_A20PacienteId[0] ;
            Z21SGCitaDisponibilidadId = T000A3_A21SGCitaDisponibilidadId[0] ;
         }
         else
         {
            Z64CitaCode = A64CitaCode ;
            Z65CitaTipoDiagnostico = A65CitaTipoDiagnostico ;
            Z89CitaEstadoCita = A89CitaEstadoCita ;
            Z91CitaLink = A91CitaLink ;
            Z92CitaFechaReserva = A92CitaFechaReserva ;
            Z93CitaLog = A93CitaLog ;
            Z94CitaEmailGenLink = A94CitaEmailGenLink ;
            Z95CitaEstado = A95CitaEstado ;
            Z96CitaArchivoNombre = A96CitaArchivoNombre ;
            Z333CitaArchivoExtencion = A333CitaArchivoExtencion ;
            Z97CitaConsentimiento = A97CitaConsentimiento ;
            Z101CitaGestante = A101CitaGestante ;
            Z102CitaEstadoPago = A102CitaEstadoPago ;
            Z306CitaPeso = A306CitaPeso ;
            Z307CitaEstatura = A307CitaEstatura ;
            Z20PacienteId = A20PacienteId ;
            Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         }
      }
      if ( GX_JID == -19 )
      {
         Z19CitaId = A19CitaId ;
         Z64CitaCode = A64CitaCode ;
         Z65CitaTipoDiagnostico = A65CitaTipoDiagnostico ;
         Z89CitaEstadoCita = A89CitaEstadoCita ;
         Z90CitaInforme = A90CitaInforme ;
         Z100CitaAntecedentes = A100CitaAntecedentes ;
         Z91CitaLink = A91CitaLink ;
         Z92CitaFechaReserva = A92CitaFechaReserva ;
         Z93CitaLog = A93CitaLog ;
         Z94CitaEmailGenLink = A94CitaEmailGenLink ;
         Z95CitaEstado = A95CitaEstado ;
         Z99CitaMotivoConsulta = A99CitaMotivoConsulta ;
         Z96CitaArchivoNombre = A96CitaArchivoNombre ;
         Z98CitaArchivo = A98CitaArchivo ;
         Z333CitaArchivoExtencion = A333CitaArchivoExtencion ;
         Z97CitaConsentimiento = A97CitaConsentimiento ;
         Z101CitaGestante = A101CitaGestante ;
         Z102CitaEstadoPago = A102CitaEstadoPago ;
         Z306CitaPeso = A306CitaPeso ;
         Z307CitaEstatura = A307CitaEstatura ;
         Z20PacienteId = A20PacienteId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z106PacienteNroDocumento = A106PacienteNroDocumento ;
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
         Z68SGCitaDisponibilidadHoraInicio = A68SGCitaDisponibilidadHoraInicio ;
         Z387SGCitaDisponibilidadHoraFin = A387SGCitaDisponibilidadHoraFin ;
         Z81SGCitaDisponibilidadProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         Z70SGCitaDisponibilidadEspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         Z72SGCitaDisponibilidadSedeId = A72SGCitaDisponibilidadSedeId ;
         Z87SGCitaDisponibilidadProCOP = A87SGCitaDisponibilidadProCOP ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z146SGCitaDisponibilidadEspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
         Z73SGCitaDisponibilidadSedeNombre = A73SGCitaDisponibilidadSedeNombre ;
         Z76SGCitaDisponibilidadClinicaId = A76SGCitaDisponibilidadClinicaId ;
         Z78SGCitaDisponibilidadClinicaNombre = A78SGCitaDisponibilidadClinicaNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV28CitaId) )
      {
         A19CitaId = AV28CitaId ;
         n19CitaId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_PacienteId) )
      {
         edtPacienteId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      }
      else
      {
         edtPacienteId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_SGCitaDisponibilidadId) )
      {
         edtSGCitaDisponibilidadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Enabled), 5, 0), true);
      }
      else
      {
         edtSGCitaDisponibilidadId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_PacienteId) )
      {
         A20PacienteId = AV12Insert_PacienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      }
      else
      {
         A20PacienteId = AV22ComboPacienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_SGCitaDisponibilidadId) )
      {
         A21SGCitaDisponibilidadId = AV13Insert_SGCitaDisponibilidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
      }
      else
      {
         A21SGCitaDisponibilidadId = AV26ComboSGCitaDisponibilidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV29Pgmname = "Cita" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
         /* Using cursor T000A4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A20PacienteId)});
         A103PacienteApellidoPaterno = T000A4_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T000A4_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T000A4_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         A106PacienteNroDocumento = T000A4_A106PacienteNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
         pr_default.close(2);
         /* Using cursor T000A5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A66SGCitaDisponibilidadFecha = T000A5_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000A5_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A68SGCitaDisponibilidadHoraInicio = T000A5_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = T000A5_n68SGCitaDisponibilidadHoraInicio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
         A387SGCitaDisponibilidadHoraFin = T000A5_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = T000A5_n387SGCitaDisponibilidadHoraFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
         A81SGCitaDisponibilidadProfesionalId = T000A5_A81SGCitaDisponibilidadProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A70SGCitaDisponibilidadEspecialidadId = T000A5_A70SGCitaDisponibilidadEspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         A72SGCitaDisponibilidadSedeId = T000A5_A72SGCitaDisponibilidadSedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
         pr_default.close(3);
         /* Using cursor T000A6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
         A87SGCitaDisponibilidadProCOP = T000A6_A87SGCitaDisponibilidadProCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
         A84ProfesionalNombres = T000A6_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = T000A6_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = T000A6_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = T000A6_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = T000A6_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = T000A6_n86ProfesionalApellidoMaterno[0] ;
         pr_default.close(4);
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
         /* Using cursor T000A7 */
         pr_default.execute(5, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
         A146SGCitaDisponibilidadEspecialidadNombre = T000A7_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         pr_default.close(5);
         /* Using cursor T000A8 */
         pr_default.execute(6, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
         A73SGCitaDisponibilidadSedeNombre = T000A8_A73SGCitaDisponibilidadSedeNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
         A76SGCitaDisponibilidadClinicaId = T000A8_A76SGCitaDisponibilidadClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         pr_default.close(6);
         /* Using cursor T000A9 */
         pr_default.execute(7, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
         A78SGCitaDisponibilidadClinicaNombre = T000A9_A78SGCitaDisponibilidadClinicaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         pr_default.close(7);
      }
   }

   public void load0A17( )
   {
      /* Using cursor T000A10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A64CitaCode = T000A10_A64CitaCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
         A103PacienteApellidoPaterno = T000A10_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T000A10_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T000A10_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         A106PacienteNroDocumento = T000A10_A106PacienteNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
         A65CitaTipoDiagnostico = T000A10_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = T000A10_n65CitaTipoDiagnostico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
         A66SGCitaDisponibilidadFecha = T000A10_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000A10_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A68SGCitaDisponibilidadHoraInicio = T000A10_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = T000A10_n68SGCitaDisponibilidadHoraInicio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
         A387SGCitaDisponibilidadHoraFin = T000A10_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = T000A10_n387SGCitaDisponibilidadHoraFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
         A146SGCitaDisponibilidadEspecialidadNombre = T000A10_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         A73SGCitaDisponibilidadSedeNombre = T000A10_A73SGCitaDisponibilidadSedeNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
         A78SGCitaDisponibilidadClinicaNombre = T000A10_A78SGCitaDisponibilidadClinicaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         A87SGCitaDisponibilidadProCOP = T000A10_A87SGCitaDisponibilidadProCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
         A89CitaEstadoCita = T000A10_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = T000A10_n89CitaEstadoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89CitaEstadoCita", A89CitaEstadoCita);
         A90CitaInforme = T000A10_A90CitaInforme[0] ;
         n90CitaInforme = T000A10_n90CitaInforme[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A90CitaInforme", A90CitaInforme);
         A100CitaAntecedentes = T000A10_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = T000A10_n100CitaAntecedentes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A100CitaAntecedentes", A100CitaAntecedentes);
         A91CitaLink = T000A10_A91CitaLink[0] ;
         n91CitaLink = T000A10_n91CitaLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A91CitaLink", A91CitaLink);
         A92CitaFechaReserva = T000A10_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = T000A10_n92CitaFechaReserva[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A92CitaFechaReserva", localUtil.ttoc( A92CitaFechaReserva, 8, 5, 0, 3, "/", ":", " "));
         A93CitaLog = T000A10_A93CitaLog[0] ;
         n93CitaLog = T000A10_n93CitaLog[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A93CitaLog", A93CitaLog);
         A94CitaEmailGenLink = T000A10_A94CitaEmailGenLink[0] ;
         n94CitaEmailGenLink = T000A10_n94CitaEmailGenLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A94CitaEmailGenLink", A94CitaEmailGenLink);
         A95CitaEstado = T000A10_A95CitaEstado[0] ;
         n95CitaEstado = T000A10_n95CitaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A95CitaEstado", A95CitaEstado);
         A99CitaMotivoConsulta = T000A10_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = T000A10_n99CitaMotivoConsulta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A99CitaMotivoConsulta", A99CitaMotivoConsulta);
         A96CitaArchivoNombre = T000A10_A96CitaArchivoNombre[0] ;
         n96CitaArchivoNombre = T000A10_n96CitaArchivoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A96CitaArchivoNombre", A96CitaArchivoNombre);
         A98CitaArchivo = T000A10_A98CitaArchivo[0] ;
         n98CitaArchivo = T000A10_n98CitaArchivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A98CitaArchivo", A98CitaArchivo);
         httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
         A333CitaArchivoExtencion = T000A10_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = T000A10_n333CitaArchivoExtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A333CitaArchivoExtencion", A333CitaArchivoExtencion);
         A97CitaConsentimiento = T000A10_A97CitaConsentimiento[0] ;
         n97CitaConsentimiento = T000A10_n97CitaConsentimiento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A97CitaConsentimiento", A97CitaConsentimiento);
         A101CitaGestante = T000A10_A101CitaGestante[0] ;
         n101CitaGestante = T000A10_n101CitaGestante[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A101CitaGestante", A101CitaGestante);
         A102CitaEstadoPago = T000A10_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = T000A10_n102CitaEstadoPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A102CitaEstadoPago", A102CitaEstadoPago);
         A306CitaPeso = T000A10_A306CitaPeso[0] ;
         n306CitaPeso = T000A10_n306CitaPeso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A306CitaPeso", GXutil.ltrimstr( A306CitaPeso, 6, 2));
         A307CitaEstatura = T000A10_A307CitaEstatura[0] ;
         n307CitaEstatura = T000A10_n307CitaEstatura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A307CitaEstatura", GXutil.ltrimstr( A307CitaEstatura, 4, 2));
         A84ProfesionalNombres = T000A10_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = T000A10_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = T000A10_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = T000A10_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = T000A10_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = T000A10_n86ProfesionalApellidoMaterno[0] ;
         A20PacienteId = T000A10_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A21SGCitaDisponibilidadId = T000A10_A21SGCitaDisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         A81SGCitaDisponibilidadProfesionalId = T000A10_A81SGCitaDisponibilidadProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A70SGCitaDisponibilidadEspecialidadId = T000A10_A70SGCitaDisponibilidadEspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         A72SGCitaDisponibilidadSedeId = T000A10_A72SGCitaDisponibilidadSedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
         A76SGCitaDisponibilidadClinicaId = T000A10_A76SGCitaDisponibilidadClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         zm0A17( -19) ;
      }
      pr_default.close(8);
      onLoadActions0A17( ) ;
   }

   public void onLoadActions0A17( )
   {
      AV29Pgmname = "Cita" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
   }

   public void checkExtendedTable0A17( )
   {
      nIsDirty_17 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV29Pgmname = "Cita" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      /* Using cursor T000A4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A103PacienteApellidoPaterno = T000A4_A103PacienteApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      A104PacienteApellidoMaterno = T000A4_A104PacienteApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      A105PacienteNombres = T000A4_A105PacienteNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      A106PacienteNroDocumento = T000A4_A106PacienteNroDocumento[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A65CitaTipoDiagnostico, "Prensuntivo") == 0 ) || ( GXutil.strcmp(A65CitaTipoDiagnostico, "Definitivo") == 0 ) || ( GXutil.strcmp(A65CitaTipoDiagnostico, "Repetitivo") == 0 ) || (GXutil.strcmp("", A65CitaTipoDiagnostico)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Tipo Diagnostico fuera de rango", "OutOfRange", 1, "CITATIPODIAGNOSTICO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCitaTipoDiagnostico.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000A5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGCitaDisponibilidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A66SGCitaDisponibilidadFecha = T000A5_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000A5_n66SGCitaDisponibilidadFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      A68SGCitaDisponibilidadHoraInicio = T000A5_A68SGCitaDisponibilidadHoraInicio[0] ;
      n68SGCitaDisponibilidadHoraInicio = T000A5_n68SGCitaDisponibilidadHoraInicio[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
      A387SGCitaDisponibilidadHoraFin = T000A5_A387SGCitaDisponibilidadHoraFin[0] ;
      n387SGCitaDisponibilidadHoraFin = T000A5_n387SGCitaDisponibilidadHoraFin[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
      A81SGCitaDisponibilidadProfesionalId = T000A5_A81SGCitaDisponibilidadProfesionalId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
      A70SGCitaDisponibilidadEspecialidadId = T000A5_A70SGCitaDisponibilidadEspecialidadId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
      A72SGCitaDisponibilidadSedeId = T000A5_A72SGCitaDisponibilidadSedeId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
      pr_default.close(3);
      /* Using cursor T000A6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A87SGCitaDisponibilidadProCOP = T000A6_A87SGCitaDisponibilidadProCOP[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
      A84ProfesionalNombres = T000A6_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = T000A6_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = T000A6_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = T000A6_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = T000A6_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = T000A6_n86ProfesionalApellidoMaterno[0] ;
      pr_default.close(4);
      nIsDirty_17 = (short)(1) ;
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
      /* Using cursor T000A7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = T000A7_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
      pr_default.close(5);
      /* Using cursor T000A8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A73SGCitaDisponibilidadSedeNombre = T000A8_A73SGCitaDisponibilidadSedeNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
      A76SGCitaDisponibilidadClinicaId = T000A8_A76SGCitaDisponibilidadClinicaId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
      pr_default.close(6);
      /* Using cursor T000A9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = T000A9_A78SGCitaDisponibilidadClinicaNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
      pr_default.close(7);
      if ( ! ( ( GXutil.strcmp(A89CitaEstadoCita, "R") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "C") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "A") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "F") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "X") == 0 ) || ( GXutil.strcmp(A89CitaEstadoCita, "N") == 0 ) || (GXutil.strcmp("", A89CitaEstadoCita)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Estado Cita fuera de rango", "OutOfRange", 1, "CITAESTADOCITA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCitaEstadoCita.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A91CitaLink,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") || (GXutil.strcmp("", A91CitaLink)==0) ) )
      {
         httpContext.GX_msglist.addItem("El valor de Cita Link no coincide con el patrón especificado", "OutOfRange", 1, "CITALINK");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaLink_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A92CitaFechaReserva) || (( A92CitaFechaReserva.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A92CitaFechaReserva, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Fecha Reserva fuera de rango", "OutOfRange", 1, "CITAFECHARESERVA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaFechaReserva_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A94CitaEmailGenLink,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") || (GXutil.strcmp("", A94CitaEmailGenLink)==0) ) )
      {
         httpContext.GX_msglist.addItem("El valor de Cita Email Gen Link no coincide con el patrón especificado", "OutOfRange", 1, "CITAEMAILGENLINK");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaEmailGenLink_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A95CitaEstado, "A") == 0 ) || ( GXutil.strcmp(A95CitaEstado, "I") == 0 ) || (GXutil.strcmp("", A95CitaEstado)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Estado fuera de rango", "OutOfRange", 1, "CITAESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCitaEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A102CitaEstadoPago, "S") == 0 ) || ( GXutil.strcmp(A102CitaEstadoPago, "P") == 0 ) || ( GXutil.strcmp(A102CitaEstadoPago, "G") == 0 ) || (GXutil.strcmp("", A102CitaEstadoPago)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Estado Pago fuera de rango", "OutOfRange", 1, "CITAESTADOPAGO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCitaEstadoPago.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0A17( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(5);
      pr_default.close(6);
      pr_default.close(7);
   }

   public void enableDisable( )
   {
   }

   public void gxload_20( int A20PacienteId )
   {
      /* Using cursor T000A11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A103PacienteApellidoPaterno = T000A11_A103PacienteApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      A104PacienteApellidoMaterno = T000A11_A104PacienteApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      A105PacienteNombres = T000A11_A105PacienteNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      A106PacienteNroDocumento = T000A11_A106PacienteNroDocumento[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A103PacienteApellidoPaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A104PacienteApellidoMaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A105PacienteNombres)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A106PacienteNroDocumento)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_21( int A21SGCitaDisponibilidadId )
   {
      /* Using cursor T000A12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGCitaDisponibilidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A66SGCitaDisponibilidadFecha = T000A12_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000A12_n66SGCitaDisponibilidadFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      A68SGCitaDisponibilidadHoraInicio = T000A12_A68SGCitaDisponibilidadHoraInicio[0] ;
      n68SGCitaDisponibilidadHoraInicio = T000A12_n68SGCitaDisponibilidadHoraInicio[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
      A387SGCitaDisponibilidadHoraFin = T000A12_A387SGCitaDisponibilidadHoraFin[0] ;
      n387SGCitaDisponibilidadHoraFin = T000A12_n387SGCitaDisponibilidadHoraFin[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
      A81SGCitaDisponibilidadProfesionalId = T000A12_A81SGCitaDisponibilidadProfesionalId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
      A70SGCitaDisponibilidadEspecialidadId = T000A12_A70SGCitaDisponibilidadEspecialidadId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
      A72SGCitaDisponibilidadSedeId = T000A12_A72SGCitaDisponibilidadSedeId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_22( int A81SGCitaDisponibilidadProfesionalId )
   {
      /* Using cursor T000A13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A87SGCitaDisponibilidadProCOP = T000A13_A87SGCitaDisponibilidadProCOP[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
      A84ProfesionalNombres = T000A13_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = T000A13_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = T000A13_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = T000A13_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = T000A13_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = T000A13_n86ProfesionalApellidoMaterno[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A87SGCitaDisponibilidadProCOP)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A84ProfesionalNombres)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A85ProfesionalApellidoPaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A86ProfesionalApellidoMaterno)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_23( short A70SGCitaDisponibilidadEspecialidadId )
   {
      /* Using cursor T000A14 */
      pr_default.execute(12, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = T000A14_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A146SGCitaDisponibilidadEspecialidadNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_24( short A72SGCitaDisponibilidadSedeId )
   {
      /* Using cursor T000A15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A73SGCitaDisponibilidadSedeNombre = T000A15_A73SGCitaDisponibilidadSedeNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
      A76SGCitaDisponibilidadClinicaId = T000A15_A76SGCitaDisponibilidadClinicaId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A73SGCitaDisponibilidadSedeNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_25( short A76SGCitaDisponibilidadClinicaId )
   {
      /* Using cursor T000A16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = T000A16_A78SGCitaDisponibilidadClinicaNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A78SGCitaDisponibilidadClinicaNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void getKey0A17( )
   {
      /* Using cursor T000A17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound17 = (short)(1) ;
      }
      else
      {
         RcdFound17 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000A3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0A17( 19) ;
         RcdFound17 = (short)(1) ;
         A19CitaId = T000A3_A19CitaId[0] ;
         n19CitaId = T000A3_n19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A64CitaCode = T000A3_A64CitaCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
         A65CitaTipoDiagnostico = T000A3_A65CitaTipoDiagnostico[0] ;
         n65CitaTipoDiagnostico = T000A3_n65CitaTipoDiagnostico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
         A89CitaEstadoCita = T000A3_A89CitaEstadoCita[0] ;
         n89CitaEstadoCita = T000A3_n89CitaEstadoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A89CitaEstadoCita", A89CitaEstadoCita);
         A90CitaInforme = T000A3_A90CitaInforme[0] ;
         n90CitaInforme = T000A3_n90CitaInforme[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A90CitaInforme", A90CitaInforme);
         A100CitaAntecedentes = T000A3_A100CitaAntecedentes[0] ;
         n100CitaAntecedentes = T000A3_n100CitaAntecedentes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A100CitaAntecedentes", A100CitaAntecedentes);
         A91CitaLink = T000A3_A91CitaLink[0] ;
         n91CitaLink = T000A3_n91CitaLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A91CitaLink", A91CitaLink);
         A92CitaFechaReserva = T000A3_A92CitaFechaReserva[0] ;
         n92CitaFechaReserva = T000A3_n92CitaFechaReserva[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A92CitaFechaReserva", localUtil.ttoc( A92CitaFechaReserva, 8, 5, 0, 3, "/", ":", " "));
         A93CitaLog = T000A3_A93CitaLog[0] ;
         n93CitaLog = T000A3_n93CitaLog[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A93CitaLog", A93CitaLog);
         A94CitaEmailGenLink = T000A3_A94CitaEmailGenLink[0] ;
         n94CitaEmailGenLink = T000A3_n94CitaEmailGenLink[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A94CitaEmailGenLink", A94CitaEmailGenLink);
         A95CitaEstado = T000A3_A95CitaEstado[0] ;
         n95CitaEstado = T000A3_n95CitaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A95CitaEstado", A95CitaEstado);
         A99CitaMotivoConsulta = T000A3_A99CitaMotivoConsulta[0] ;
         n99CitaMotivoConsulta = T000A3_n99CitaMotivoConsulta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A99CitaMotivoConsulta", A99CitaMotivoConsulta);
         A96CitaArchivoNombre = T000A3_A96CitaArchivoNombre[0] ;
         n96CitaArchivoNombre = T000A3_n96CitaArchivoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A96CitaArchivoNombre", A96CitaArchivoNombre);
         A98CitaArchivo = T000A3_A98CitaArchivo[0] ;
         n98CitaArchivo = T000A3_n98CitaArchivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A98CitaArchivo", A98CitaArchivo);
         httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
         A333CitaArchivoExtencion = T000A3_A333CitaArchivoExtencion[0] ;
         n333CitaArchivoExtencion = T000A3_n333CitaArchivoExtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A333CitaArchivoExtencion", A333CitaArchivoExtencion);
         A97CitaConsentimiento = T000A3_A97CitaConsentimiento[0] ;
         n97CitaConsentimiento = T000A3_n97CitaConsentimiento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A97CitaConsentimiento", A97CitaConsentimiento);
         A101CitaGestante = T000A3_A101CitaGestante[0] ;
         n101CitaGestante = T000A3_n101CitaGestante[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A101CitaGestante", A101CitaGestante);
         A102CitaEstadoPago = T000A3_A102CitaEstadoPago[0] ;
         n102CitaEstadoPago = T000A3_n102CitaEstadoPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A102CitaEstadoPago", A102CitaEstadoPago);
         A306CitaPeso = T000A3_A306CitaPeso[0] ;
         n306CitaPeso = T000A3_n306CitaPeso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A306CitaPeso", GXutil.ltrimstr( A306CitaPeso, 6, 2));
         A307CitaEstatura = T000A3_A307CitaEstatura[0] ;
         n307CitaEstatura = T000A3_n307CitaEstatura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A307CitaEstatura", GXutil.ltrimstr( A307CitaEstatura, 4, 2));
         A20PacienteId = T000A3_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A21SGCitaDisponibilidadId = T000A3_A21SGCitaDisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         Z19CitaId = A19CitaId ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0A17( ) ;
         if ( AnyError == 1 )
         {
            RcdFound17 = (short)(0) ;
            initializeNonKey0A17( ) ;
         }
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound17 = (short)(0) ;
         initializeNonKey0A17( ) ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0A17( ) ;
      if ( RcdFound17 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound17 = (short)(0) ;
      /* Using cursor T000A18 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         while ( (pr_default.getStatus(16) != 101) && ( ( T000A18_A19CitaId[0] < A19CitaId ) ) )
         {
            pr_default.readNext(16);
         }
         if ( (pr_default.getStatus(16) != 101) && ( ( T000A18_A19CitaId[0] > A19CitaId ) ) )
         {
            A19CitaId = T000A18_A19CitaId[0] ;
            n19CitaId = T000A18_n19CitaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            RcdFound17 = (short)(1) ;
         }
      }
      pr_default.close(16);
   }

   public void move_previous( )
   {
      RcdFound17 = (short)(0) ;
      /* Using cursor T000A19 */
      pr_default.execute(17, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         while ( (pr_default.getStatus(17) != 101) && ( ( T000A19_A19CitaId[0] > A19CitaId ) ) )
         {
            pr_default.readNext(17);
         }
         if ( (pr_default.getStatus(17) != 101) && ( ( T000A19_A19CitaId[0] < A19CitaId ) ) )
         {
            A19CitaId = T000A19_A19CitaId[0] ;
            n19CitaId = T000A19_n19CitaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            RcdFound17 = (short)(1) ;
         }
      }
      pr_default.close(17);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0A17( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCitaCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0A17( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound17 == 1 )
         {
            if ( A19CitaId != Z19CitaId )
            {
               A19CitaId = Z19CitaId ;
               n19CitaId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CITAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCitaCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0A17( ) ;
               GX_FocusControl = edtCitaCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A19CitaId != Z19CitaId )
            {
               /* Insert record */
               GX_FocusControl = edtCitaCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0A17( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CITAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCitaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCitaCode_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0A17( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( A19CitaId != Z19CitaId )
      {
         A19CitaId = Z19CitaId ;
         n19CitaId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCitaCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0A17( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000A2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cita"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z64CitaCode, T000A2_A64CitaCode[0]) != 0 ) || ( GXutil.strcmp(Z65CitaTipoDiagnostico, T000A2_A65CitaTipoDiagnostico[0]) != 0 ) || ( GXutil.strcmp(Z89CitaEstadoCita, T000A2_A89CitaEstadoCita[0]) != 0 ) || ( GXutil.strcmp(Z91CitaLink, T000A2_A91CitaLink[0]) != 0 ) || !( GXutil.dateCompare(Z92CitaFechaReserva, T000A2_A92CitaFechaReserva[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z93CitaLog, T000A2_A93CitaLog[0]) != 0 ) || ( GXutil.strcmp(Z94CitaEmailGenLink, T000A2_A94CitaEmailGenLink[0]) != 0 ) || ( GXutil.strcmp(Z95CitaEstado, T000A2_A95CitaEstado[0]) != 0 ) || ( GXutil.strcmp(Z96CitaArchivoNombre, T000A2_A96CitaArchivoNombre[0]) != 0 ) || ( GXutil.strcmp(Z333CitaArchivoExtencion, T000A2_A333CitaArchivoExtencion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z97CitaConsentimiento != T000A2_A97CitaConsentimiento[0] ) || ( Z101CitaGestante != T000A2_A101CitaGestante[0] ) || ( GXutil.strcmp(Z102CitaEstadoPago, T000A2_A102CitaEstadoPago[0]) != 0 ) || ( DecimalUtil.compareTo(Z306CitaPeso, T000A2_A306CitaPeso[0]) != 0 ) || ( DecimalUtil.compareTo(Z307CitaEstatura, T000A2_A307CitaEstatura[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z20PacienteId != T000A2_A20PacienteId[0] ) || ( Z21SGCitaDisponibilidadId != T000A2_A21SGCitaDisponibilidadId[0] ) )
         {
            if ( GXutil.strcmp(Z64CitaCode, T000A2_A64CitaCode[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaCode");
               GXutil.writeLogRaw("Old: ",Z64CitaCode);
               GXutil.writeLogRaw("Current: ",T000A2_A64CitaCode[0]);
            }
            if ( GXutil.strcmp(Z65CitaTipoDiagnostico, T000A2_A65CitaTipoDiagnostico[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaTipoDiagnostico");
               GXutil.writeLogRaw("Old: ",Z65CitaTipoDiagnostico);
               GXutil.writeLogRaw("Current: ",T000A2_A65CitaTipoDiagnostico[0]);
            }
            if ( GXutil.strcmp(Z89CitaEstadoCita, T000A2_A89CitaEstadoCita[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaEstadoCita");
               GXutil.writeLogRaw("Old: ",Z89CitaEstadoCita);
               GXutil.writeLogRaw("Current: ",T000A2_A89CitaEstadoCita[0]);
            }
            if ( GXutil.strcmp(Z91CitaLink, T000A2_A91CitaLink[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaLink");
               GXutil.writeLogRaw("Old: ",Z91CitaLink);
               GXutil.writeLogRaw("Current: ",T000A2_A91CitaLink[0]);
            }
            if ( !( GXutil.dateCompare(Z92CitaFechaReserva, T000A2_A92CitaFechaReserva[0]) ) )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaFechaReserva");
               GXutil.writeLogRaw("Old: ",Z92CitaFechaReserva);
               GXutil.writeLogRaw("Current: ",T000A2_A92CitaFechaReserva[0]);
            }
            if ( GXutil.strcmp(Z93CitaLog, T000A2_A93CitaLog[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaLog");
               GXutil.writeLogRaw("Old: ",Z93CitaLog);
               GXutil.writeLogRaw("Current: ",T000A2_A93CitaLog[0]);
            }
            if ( GXutil.strcmp(Z94CitaEmailGenLink, T000A2_A94CitaEmailGenLink[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaEmailGenLink");
               GXutil.writeLogRaw("Old: ",Z94CitaEmailGenLink);
               GXutil.writeLogRaw("Current: ",T000A2_A94CitaEmailGenLink[0]);
            }
            if ( GXutil.strcmp(Z95CitaEstado, T000A2_A95CitaEstado[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaEstado");
               GXutil.writeLogRaw("Old: ",Z95CitaEstado);
               GXutil.writeLogRaw("Current: ",T000A2_A95CitaEstado[0]);
            }
            if ( GXutil.strcmp(Z96CitaArchivoNombre, T000A2_A96CitaArchivoNombre[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaArchivoNombre");
               GXutil.writeLogRaw("Old: ",Z96CitaArchivoNombre);
               GXutil.writeLogRaw("Current: ",T000A2_A96CitaArchivoNombre[0]);
            }
            if ( GXutil.strcmp(Z333CitaArchivoExtencion, T000A2_A333CitaArchivoExtencion[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaArchivoExtencion");
               GXutil.writeLogRaw("Old: ",Z333CitaArchivoExtencion);
               GXutil.writeLogRaw("Current: ",T000A2_A333CitaArchivoExtencion[0]);
            }
            if ( Z97CitaConsentimiento != T000A2_A97CitaConsentimiento[0] )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaConsentimiento");
               GXutil.writeLogRaw("Old: ",Z97CitaConsentimiento);
               GXutil.writeLogRaw("Current: ",T000A2_A97CitaConsentimiento[0]);
            }
            if ( Z101CitaGestante != T000A2_A101CitaGestante[0] )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaGestante");
               GXutil.writeLogRaw("Old: ",Z101CitaGestante);
               GXutil.writeLogRaw("Current: ",T000A2_A101CitaGestante[0]);
            }
            if ( GXutil.strcmp(Z102CitaEstadoPago, T000A2_A102CitaEstadoPago[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaEstadoPago");
               GXutil.writeLogRaw("Old: ",Z102CitaEstadoPago);
               GXutil.writeLogRaw("Current: ",T000A2_A102CitaEstadoPago[0]);
            }
            if ( DecimalUtil.compareTo(Z306CitaPeso, T000A2_A306CitaPeso[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaPeso");
               GXutil.writeLogRaw("Old: ",Z306CitaPeso);
               GXutil.writeLogRaw("Current: ",T000A2_A306CitaPeso[0]);
            }
            if ( DecimalUtil.compareTo(Z307CitaEstatura, T000A2_A307CitaEstatura[0]) != 0 )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"CitaEstatura");
               GXutil.writeLogRaw("Old: ",Z307CitaEstatura);
               GXutil.writeLogRaw("Current: ",T000A2_A307CitaEstatura[0]);
            }
            if ( Z20PacienteId != T000A2_A20PacienteId[0] )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"PacienteId");
               GXutil.writeLogRaw("Old: ",Z20PacienteId);
               GXutil.writeLogRaw("Current: ",T000A2_A20PacienteId[0]);
            }
            if ( Z21SGCitaDisponibilidadId != T000A2_A21SGCitaDisponibilidadId[0] )
            {
               GXutil.writeLogln("cita:[seudo value changed for attri]"+"SGCitaDisponibilidadId");
               GXutil.writeLogRaw("Old: ",Z21SGCitaDisponibilidadId);
               GXutil.writeLogRaw("Current: ",T000A2_A21SGCitaDisponibilidadId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Cita"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0A17( )
   {
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0A17( 0) ;
         checkOptimisticConcurrency0A17( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A17( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0A17( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A20 */
                  pr_default.execute(18, new Object[] {A64CitaCode, Boolean.valueOf(n65CitaTipoDiagnostico), A65CitaTipoDiagnostico, Boolean.valueOf(n89CitaEstadoCita), A89CitaEstadoCita, Boolean.valueOf(n90CitaInforme), A90CitaInforme, Boolean.valueOf(n100CitaAntecedentes), A100CitaAntecedentes, Boolean.valueOf(n91CitaLink), A91CitaLink, Boolean.valueOf(n92CitaFechaReserva), A92CitaFechaReserva, Boolean.valueOf(n93CitaLog), A93CitaLog, Boolean.valueOf(n94CitaEmailGenLink), A94CitaEmailGenLink, Boolean.valueOf(n95CitaEstado), A95CitaEstado, Boolean.valueOf(n99CitaMotivoConsulta), A99CitaMotivoConsulta, Boolean.valueOf(n96CitaArchivoNombre), A96CitaArchivoNombre, Boolean.valueOf(n98CitaArchivo), A98CitaArchivo, Boolean.valueOf(n333CitaArchivoExtencion), A333CitaArchivoExtencion, Boolean.valueOf(n97CitaConsentimiento), Boolean.valueOf(A97CitaConsentimiento), Boolean.valueOf(n101CitaGestante), Boolean.valueOf(A101CitaGestante), Boolean.valueOf(n102CitaEstadoPago), A102CitaEstadoPago, Boolean.valueOf(n306CitaPeso), A306CitaPeso, Boolean.valueOf(n307CitaEstatura), A307CitaEstatura, Integer.valueOf(A20PacienteId), Integer.valueOf(A21SGCitaDisponibilidadId)});
                  A19CitaId = T000A20_A19CitaId[0] ;
                  n19CitaId = T000A20_n19CitaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0A0( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0A17( ) ;
         }
         endLevel0A17( ) ;
      }
      closeExtendedTableCursors0A17( ) ;
   }

   public void update0A17( )
   {
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A17( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0A17( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0A17( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000A21 */
                  pr_default.execute(19, new Object[] {A64CitaCode, Boolean.valueOf(n65CitaTipoDiagnostico), A65CitaTipoDiagnostico, Boolean.valueOf(n89CitaEstadoCita), A89CitaEstadoCita, Boolean.valueOf(n90CitaInforme), A90CitaInforme, Boolean.valueOf(n100CitaAntecedentes), A100CitaAntecedentes, Boolean.valueOf(n91CitaLink), A91CitaLink, Boolean.valueOf(n92CitaFechaReserva), A92CitaFechaReserva, Boolean.valueOf(n93CitaLog), A93CitaLog, Boolean.valueOf(n94CitaEmailGenLink), A94CitaEmailGenLink, Boolean.valueOf(n95CitaEstado), A95CitaEstado, Boolean.valueOf(n99CitaMotivoConsulta), A99CitaMotivoConsulta, Boolean.valueOf(n96CitaArchivoNombre), A96CitaArchivoNombre, Boolean.valueOf(n333CitaArchivoExtencion), A333CitaArchivoExtencion, Boolean.valueOf(n97CitaConsentimiento), Boolean.valueOf(A97CitaConsentimiento), Boolean.valueOf(n101CitaGestante), Boolean.valueOf(A101CitaGestante), Boolean.valueOf(n102CitaEstadoPago), A102CitaEstadoPago, Boolean.valueOf(n306CitaPeso), A306CitaPeso, Boolean.valueOf(n307CitaEstatura), A307CitaEstatura, Integer.valueOf(A20PacienteId), Integer.valueOf(A21SGCitaDisponibilidadId), Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Cita"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0A17( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0A17( ) ;
      }
      closeExtendedTableCursors0A17( ) ;
   }

   public void deferredUpdate0A17( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000A22 */
         pr_default.execute(20, new Object[] {Boolean.valueOf(n98CitaArchivo), A98CitaArchivo, Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
      }
   }

   public void delete( )
   {
      beforeValidate0A17( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0A17( ) ;
         afterConfirm0A17( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0A17( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000A23 */
               pr_default.execute(21, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Cita");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode17 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0A17( ) ;
      Gx_mode = sMode17 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0A17( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "Cita" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
         /* Using cursor T000A24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A20PacienteId)});
         A103PacienteApellidoPaterno = T000A24_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T000A24_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T000A24_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         A106PacienteNroDocumento = T000A24_A106PacienteNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
         pr_default.close(22);
         /* Using cursor T000A25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A66SGCitaDisponibilidadFecha = T000A25_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000A25_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A68SGCitaDisponibilidadHoraInicio = T000A25_A68SGCitaDisponibilidadHoraInicio[0] ;
         n68SGCitaDisponibilidadHoraInicio = T000A25_n68SGCitaDisponibilidadHoraInicio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
         A387SGCitaDisponibilidadHoraFin = T000A25_A387SGCitaDisponibilidadHoraFin[0] ;
         n387SGCitaDisponibilidadHoraFin = T000A25_n387SGCitaDisponibilidadHoraFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
         A81SGCitaDisponibilidadProfesionalId = T000A25_A81SGCitaDisponibilidadProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A70SGCitaDisponibilidadEspecialidadId = T000A25_A70SGCitaDisponibilidadEspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         A72SGCitaDisponibilidadSedeId = T000A25_A72SGCitaDisponibilidadSedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
         pr_default.close(23);
         /* Using cursor T000A26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
         A87SGCitaDisponibilidadProCOP = T000A26_A87SGCitaDisponibilidadProCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
         A84ProfesionalNombres = T000A26_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = T000A26_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = T000A26_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = T000A26_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = T000A26_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = T000A26_n86ProfesionalApellidoMaterno[0] ;
         pr_default.close(24);
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
         /* Using cursor T000A27 */
         pr_default.execute(25, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
         A146SGCitaDisponibilidadEspecialidadNombre = T000A27_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         pr_default.close(25);
         /* Using cursor T000A28 */
         pr_default.execute(26, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
         A73SGCitaDisponibilidadSedeNombre = T000A28_A73SGCitaDisponibilidadSedeNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
         A76SGCitaDisponibilidadClinicaId = T000A28_A76SGCitaDisponibilidadClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         pr_default.close(26);
         /* Using cursor T000A29 */
         pr_default.execute(27, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
         A78SGCitaDisponibilidadClinicaNombre = T000A29_A78SGCitaDisponibilidadClinicaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         pr_default.close(27);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000A30 */
         pr_default.execute(28, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Receta Medica"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor T000A31 */
         pr_default.execute(29, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Pago"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor T000A32 */
         pr_default.execute(30, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Encuesta"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor T000A33 */
         pr_default.execute(31, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Servicio"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor T000A34 */
         pr_default.execute(32, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Receta"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor T000A35 */
         pr_default.execute(33, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Diagnostico"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
      }
   }

   public void endLevel0A17( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0A17( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(22);
         pr_default.close(23);
         pr_default.close(24);
         pr_default.close(25);
         pr_default.close(26);
         pr_default.close(27);
         Application.commitDataStores(context, remoteHandle, pr_default, "cita");
         if ( AnyError == 0 )
         {
            confirmValues0A0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(22);
         pr_default.close(23);
         pr_default.close(24);
         pr_default.close(25);
         pr_default.close(26);
         pr_default.close(27);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "cita");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0A17( )
   {
      /* Scan By routine */
      /* Using cursor T000A36 */
      pr_default.execute(34);
      RcdFound17 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A19CitaId = T000A36_A19CitaId[0] ;
         n19CitaId = T000A36_n19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0A17( )
   {
      /* Scan next routine */
      pr_default.readNext(34);
      RcdFound17 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A19CitaId = T000A36_A19CitaId[0] ;
         n19CitaId = T000A36_n19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
   }

   public void scanEnd0A17( )
   {
      pr_default.close(34);
   }

   public void afterConfirm0A17( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0A17( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0A17( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0A17( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0A17( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0A17( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0A17( )
   {
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      edtCitaCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaCode_Enabled), 5, 0), true);
      edtPacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      edtPacienteApellidoPaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoPaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoPaterno_Enabled), 5, 0), true);
      edtPacienteApellidoMaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoMaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoMaterno_Enabled), 5, 0), true);
      edtPacienteNombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombres_Enabled), 5, 0), true);
      edtPacienteNroDocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNroDocumento_Enabled), 5, 0), true);
      cmbCitaTipoDiagnostico.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaTipoDiagnostico.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCitaTipoDiagnostico.getEnabled(), 5, 0), true);
      edtSGCitaDisponibilidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadFecha_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadHoraInicio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadHoraInicio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadHoraInicio_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadHoraFin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadHoraFin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadHoraFin_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadEspecialidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadNombre_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadSedeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadSedeId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadSedeNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadSedeNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadSedeNombre_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadClinicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadClinicaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaNombre_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProfesionalId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadProFullName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProFullName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProFullName_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadProCOP_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProCOP_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProCOP_Enabled), 5, 0), true);
      cmbCitaEstadoCita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoCita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCitaEstadoCita.getEnabled(), 5, 0), true);
      edtCitaInforme_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaInforme_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaInforme_Enabled), 5, 0), true);
      edtCitaAntecedentes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaAntecedentes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaAntecedentes_Enabled), 5, 0), true);
      edtCitaLink_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaLink_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaLink_Enabled), 5, 0), true);
      edtCitaFechaReserva_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaFechaReserva_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaFechaReserva_Enabled), 5, 0), true);
      edtCitaLog_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaLog_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaLog_Enabled), 5, 0), true);
      edtCitaEmailGenLink_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaEmailGenLink_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaEmailGenLink_Enabled), 5, 0), true);
      cmbCitaEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCitaEstado.getEnabled(), 5, 0), true);
      edtCitaMotivoConsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaMotivoConsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaMotivoConsulta_Enabled), 5, 0), true);
      edtCitaArchivoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaArchivoNombre_Enabled), 5, 0), true);
      edtCitaArchivo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaArchivo_Enabled), 5, 0), true);
      edtCitaArchivoExtencion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivoExtencion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaArchivoExtencion_Enabled), 5, 0), true);
      chkCitaConsentimiento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCitaConsentimiento.getInternalname(), "Enabled", GXutil.ltrimstr( chkCitaConsentimiento.getEnabled(), 5, 0), true);
      chkCitaGestante.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkCitaGestante.getInternalname(), "Enabled", GXutil.ltrimstr( chkCitaGestante.getEnabled(), 5, 0), true);
      cmbCitaEstadoPago.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoPago.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCitaEstadoPago.getEnabled(), 5, 0), true);
      edtCitaPeso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaPeso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaPeso_Enabled), 5, 0), true);
      edtCitaEstatura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaEstatura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaEstatura_Enabled), 5, 0), true);
      edtavCombopacienteid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopacienteid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopacienteid_Enabled), 5, 0), true);
      edtavCombosgcitadisponibilidadid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosgcitadisponibilidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosgcitadisponibilidadid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0A17( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0A0( )
   {
   }

   public void renderHtmlHeaders( )
   {
      com.projectthani.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
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
      MasterPageObj.master_styles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110324192", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV28CitaId,8,0))}, new String[] {"Gx_mode","CitaId"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Cita");
      forbiddenHiddens.add("CitaId", localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("cita:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z64CitaCode", Z64CitaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z65CitaTipoDiagnostico", Z65CitaTipoDiagnostico);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z89CitaEstadoCita", GXutil.rtrim( Z89CitaEstadoCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z91CitaLink", Z91CitaLink);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z92CitaFechaReserva", localUtil.ttoc( Z92CitaFechaReserva, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z93CitaLog", Z93CitaLog);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z94CitaEmailGenLink", Z94CitaEmailGenLink);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z95CitaEstado", GXutil.rtrim( Z95CitaEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z96CitaArchivoNombre", Z96CitaArchivoNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z333CitaArchivoExtencion", Z333CitaArchivoExtencion);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "Z97CitaConsentimiento", Z97CitaConsentimiento);
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "Z101CitaGestante", Z101CitaGestante);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z102CitaEstadoPago", GXutil.rtrim( Z102CitaEstadoPago));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z306CitaPeso", GXutil.ltrim( localUtil.ntoc( Z306CitaPeso, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z307CitaEstatura", GXutil.ltrim( localUtil.ntoc( Z307CitaEstatura, (byte)(4), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z20PacienteId", GXutil.ltrim( localUtil.ntoc( Z20PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z21SGCitaDisponibilidadId", GXutil.ltrim( localUtil.ntoc( Z21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N20PacienteId", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N21SGCitaDisponibilidadId", GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPACIENTEID_DATA", AV17PacienteId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPACIENTEID_DATA", AV17PacienteId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSGCITADISPONIBILIDADID_DATA", AV25SGCitaDisponibilidadId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSGCITADISPONIBILIDADID_DATA", AV25SGCitaDisponibilidadId_Data);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV10TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV10TrnContext);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV10TrnContext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALNOMBRES", A84ProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALAPELLIDOPATERNO", A85ProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALAPELLIDOMATERNO", A86ProfesionalApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCITAID", GXutil.ltrim( localUtil.ntoc( AV28CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCITAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV28CitaId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PACIENTEID", GXutil.ltrim( localUtil.ntoc( AV12Insert_PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SGCITADISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV13Insert_SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV29Pgmname));
      GXCCtlgxBlob = "CITAARCHIVO" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A98CitaArchivo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Objectcall", GXutil.rtrim( Combo_pacienteid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Cls", GXutil.rtrim( Combo_pacienteid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Selectedvalue_set", GXutil.rtrim( Combo_pacienteid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Selectedtext_set", GXutil.rtrim( Combo_pacienteid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Enabled", GXutil.booltostr( Combo_pacienteid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Datalistproc", GXutil.rtrim( Combo_pacienteid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Datalistprocparametersprefix", GXutil.rtrim( Combo_pacienteid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PACIENTEID_Emptyitem", GXutil.booltostr( Combo_pacienteid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Objectcall", GXutil.rtrim( Combo_sgcitadisponibilidadid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Cls", GXutil.rtrim( Combo_sgcitadisponibilidadid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Selectedvalue_set", GXutil.rtrim( Combo_sgcitadisponibilidadid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Selectedtext_set", GXutil.rtrim( Combo_sgcitadisponibilidadid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Enabled", GXutil.booltostr( Combo_sgcitadisponibilidadid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Datalistproc", GXutil.rtrim( Combo_sgcitadisponibilidadid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Datalistprocparametersprefix", GXutil.rtrim( Combo_sgcitadisponibilidadid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGCITADISPONIBILIDADID_Emptyitem", GXutil.booltostr( Combo_sgcitadisponibilidadid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CITAARCHIVO_Filename", GXutil.rtrim( edtCitaArchivo_Filename));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CITAARCHIVO_Filetype", GXutil.rtrim( edtCitaArchivo_Filetype));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
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
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.projectthani.cita", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV28CitaId,8,0))}, new String[] {"Gx_mode","CitaId"})  ;
   }

   public String getPgmname( )
   {
      return "Cita" ;
   }

   public String getPgmdesc( )
   {
      return "Cita" ;
   }

   public void initializeNonKey0A17( )
   {
      A20PacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      A21SGCitaDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
      A64CitaCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
      A103PacienteApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      A104PacienteApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      A105PacienteNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      A106PacienteNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
      A65CitaTipoDiagnostico = "" ;
      n65CitaTipoDiagnostico = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
      n65CitaTipoDiagnostico = ((GXutil.strcmp("", A65CitaTipoDiagnostico)==0) ? true : false) ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      n66SGCitaDisponibilidadFecha = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      n68SGCitaDisponibilidadHoraInicio = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      n387SGCitaDisponibilidadHoraFin = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
      A70SGCitaDisponibilidadEspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
      A72SGCitaDisponibilidadSedeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
      A73SGCitaDisponibilidadSedeNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
      A76SGCitaDisponibilidadClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
      A81SGCitaDisponibilidadProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
      A82SGCitaDisponibilidadProFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
      A87SGCitaDisponibilidadProCOP = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
      A89CitaEstadoCita = "" ;
      n89CitaEstadoCita = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A89CitaEstadoCita", A89CitaEstadoCita);
      n89CitaEstadoCita = ((GXutil.strcmp("", A89CitaEstadoCita)==0) ? true : false) ;
      A90CitaInforme = "" ;
      n90CitaInforme = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A90CitaInforme", A90CitaInforme);
      n90CitaInforme = ((GXutil.strcmp("", A90CitaInforme)==0) ? true : false) ;
      A100CitaAntecedentes = "" ;
      n100CitaAntecedentes = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A100CitaAntecedentes", A100CitaAntecedentes);
      n100CitaAntecedentes = ((GXutil.strcmp("", A100CitaAntecedentes)==0) ? true : false) ;
      A91CitaLink = "" ;
      n91CitaLink = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A91CitaLink", A91CitaLink);
      n91CitaLink = ((GXutil.strcmp("", A91CitaLink)==0) ? true : false) ;
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      n92CitaFechaReserva = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A92CitaFechaReserva", localUtil.ttoc( A92CitaFechaReserva, 8, 5, 0, 3, "/", ":", " "));
      n92CitaFechaReserva = (GXutil.dateCompare(GXutil.nullDate(), A92CitaFechaReserva) ? true : false) ;
      A93CitaLog = "" ;
      n93CitaLog = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A93CitaLog", A93CitaLog);
      n93CitaLog = ((GXutil.strcmp("", A93CitaLog)==0) ? true : false) ;
      A94CitaEmailGenLink = "" ;
      n94CitaEmailGenLink = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A94CitaEmailGenLink", A94CitaEmailGenLink);
      n94CitaEmailGenLink = ((GXutil.strcmp("", A94CitaEmailGenLink)==0) ? true : false) ;
      A95CitaEstado = "" ;
      n95CitaEstado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A95CitaEstado", A95CitaEstado);
      n95CitaEstado = ((GXutil.strcmp("", A95CitaEstado)==0) ? true : false) ;
      A99CitaMotivoConsulta = "" ;
      n99CitaMotivoConsulta = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A99CitaMotivoConsulta", A99CitaMotivoConsulta);
      n99CitaMotivoConsulta = ((GXutil.strcmp("", A99CitaMotivoConsulta)==0) ? true : false) ;
      A96CitaArchivoNombre = "" ;
      n96CitaArchivoNombre = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A96CitaArchivoNombre", A96CitaArchivoNombre);
      n96CitaArchivoNombre = ((GXutil.strcmp("", A96CitaArchivoNombre)==0) ? true : false) ;
      A98CitaArchivo = "" ;
      n98CitaArchivo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A98CitaArchivo", A98CitaArchivo);
      httpContext.ajax_rsp_assign_prop("", false, edtCitaArchivo_Internalname, "URL", httpContext.getResourceRelative(A98CitaArchivo), true);
      n98CitaArchivo = ((GXutil.strcmp("", A98CitaArchivo)==0) ? true : false) ;
      A333CitaArchivoExtencion = "" ;
      n333CitaArchivoExtencion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A333CitaArchivoExtencion", A333CitaArchivoExtencion);
      n333CitaArchivoExtencion = ((GXutil.strcmp("", A333CitaArchivoExtencion)==0) ? true : false) ;
      A97CitaConsentimiento = false ;
      n97CitaConsentimiento = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A97CitaConsentimiento", A97CitaConsentimiento);
      n97CitaConsentimiento = ((false==A97CitaConsentimiento) ? true : false) ;
      A101CitaGestante = false ;
      n101CitaGestante = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A101CitaGestante", A101CitaGestante);
      n101CitaGestante = ((false==A101CitaGestante) ? true : false) ;
      A102CitaEstadoPago = "" ;
      n102CitaEstadoPago = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A102CitaEstadoPago", A102CitaEstadoPago);
      n102CitaEstadoPago = ((GXutil.strcmp("", A102CitaEstadoPago)==0) ? true : false) ;
      A306CitaPeso = DecimalUtil.ZERO ;
      n306CitaPeso = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A306CitaPeso", GXutil.ltrimstr( A306CitaPeso, 6, 2));
      n306CitaPeso = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A306CitaPeso)==0) ? true : false) ;
      A307CitaEstatura = DecimalUtil.ZERO ;
      n307CitaEstatura = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A307CitaEstatura", GXutil.ltrimstr( A307CitaEstatura, 4, 2));
      n307CitaEstatura = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A307CitaEstatura)==0) ? true : false) ;
      A84ProfesionalNombres = "" ;
      n84ProfesionalNombres = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      A85ProfesionalApellidoPaterno = "" ;
      n85ProfesionalApellidoPaterno = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      A86ProfesionalApellidoMaterno = "" ;
      n86ProfesionalApellidoMaterno = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      Z64CitaCode = "" ;
      Z65CitaTipoDiagnostico = "" ;
      Z89CitaEstadoCita = "" ;
      Z91CitaLink = "" ;
      Z92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      Z93CitaLog = "" ;
      Z94CitaEmailGenLink = "" ;
      Z95CitaEstado = "" ;
      Z96CitaArchivoNombre = "" ;
      Z333CitaArchivoExtencion = "" ;
      Z97CitaConsentimiento = false ;
      Z101CitaGestante = false ;
      Z102CitaEstadoPago = "" ;
      Z306CitaPeso = DecimalUtil.ZERO ;
      Z307CitaEstatura = DecimalUtil.ZERO ;
      Z20PacienteId = 0 ;
      Z21SGCitaDisponibilidadId = 0 ;
   }

   public void initAll0A17( )
   {
      A19CitaId = 0 ;
      n19CitaId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      initializeNonKey0A17( ) ;
   }

   public void standaloneModalInsert( )
   {
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110324245", true, true);
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
      httpContext.AddJavascriptSource("messages.spa.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("cita.js", "?20225110324245", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtCitaId_Internalname = "CITAID" ;
      edtCitaCode_Internalname = "CITACODE" ;
      lblTextblockpacienteid_Internalname = "TEXTBLOCKPACIENTEID" ;
      Combo_pacienteid_Internalname = "COMBO_PACIENTEID" ;
      edtPacienteId_Internalname = "PACIENTEID" ;
      divTablesplittedpacienteid_Internalname = "TABLESPLITTEDPACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES" ;
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO" ;
      cmbCitaTipoDiagnostico.setInternalname( "CITATIPODIAGNOSTICO" );
      lblTextblocksgcitadisponibilidadid_Internalname = "TEXTBLOCKSGCITADISPONIBILIDADID" ;
      Combo_sgcitadisponibilidadid_Internalname = "COMBO_SGCITADISPONIBILIDADID" ;
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID" ;
      divTablesplittedsgcitadisponibilidadid_Internalname = "TABLESPLITTEDSGCITADISPONIBILIDADID" ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA" ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = "SGCITADISPONIBILIDADHORAINICIO" ;
      edtSGCitaDisponibilidadHoraFin_Internalname = "SGCITADISPONIBILIDADHORAFIN" ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtSGCitaDisponibilidadSedeId_Internalname = "SGCITADISPONIBILIDADSEDEID" ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = "SGCITADISPONIBILIDADSEDENOMBRE" ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID" ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE" ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID" ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME" ;
      edtSGCitaDisponibilidadProCOP_Internalname = "SGCITADISPONIBILIDADPROCOP" ;
      cmbCitaEstadoCita.setInternalname( "CITAESTADOCITA" );
      edtCitaInforme_Internalname = "CITAINFORME" ;
      edtCitaAntecedentes_Internalname = "CITAANTECEDENTES" ;
      edtCitaLink_Internalname = "CITALINK" ;
      edtCitaFechaReserva_Internalname = "CITAFECHARESERVA" ;
      edtCitaLog_Internalname = "CITALOG" ;
      edtCitaEmailGenLink_Internalname = "CITAEMAILGENLINK" ;
      cmbCitaEstado.setInternalname( "CITAESTADO" );
      edtCitaMotivoConsulta_Internalname = "CITAMOTIVOCONSULTA" ;
      edtCitaArchivoNombre_Internalname = "CITAARCHIVONOMBRE" ;
      edtCitaArchivo_Internalname = "CITAARCHIVO" ;
      edtCitaArchivoExtencion_Internalname = "CITAARCHIVOEXTENCION" ;
      chkCitaConsentimiento.setInternalname( "CITACONSENTIMIENTO" );
      chkCitaGestante.setInternalname( "CITAGESTANTE" );
      cmbCitaEstadoPago.setInternalname( "CITAESTADOPAGO" );
      edtCitaPeso_Internalname = "CITAPESO" ;
      edtCitaEstatura_Internalname = "CITAESTATURA" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombopacienteid_Internalname = "vCOMBOPACIENTEID" ;
      divSectionattribute_pacienteid_Internalname = "SECTIONATTRIBUTE_PACIENTEID" ;
      edtavCombosgcitadisponibilidadid_Internalname = "vCOMBOSGCITADISPONIBILIDADID" ;
      divSectionattribute_sgcitadisponibilidadid_Internalname = "SECTIONATTRIBUTE_SGCITADISPONIBILIDADID" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      edtCitaArchivo_Filename = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Cita" );
      edtavCombosgcitadisponibilidadid_Jsonclick = "" ;
      edtavCombosgcitadisponibilidadid_Enabled = 0 ;
      edtavCombosgcitadisponibilidadid_Visible = 1 ;
      edtavCombopacienteid_Jsonclick = "" ;
      edtavCombopacienteid_Enabled = 0 ;
      edtavCombopacienteid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtCitaEstatura_Jsonclick = "" ;
      edtCitaEstatura_Enabled = 1 ;
      edtCitaPeso_Jsonclick = "" ;
      edtCitaPeso_Enabled = 1 ;
      cmbCitaEstadoPago.setJsonclick( "" );
      cmbCitaEstadoPago.setEnabled( 1 );
      chkCitaGestante.setEnabled( 1 );
      chkCitaConsentimiento.setEnabled( 1 );
      edtCitaArchivoExtencion_Jsonclick = "" ;
      edtCitaArchivoExtencion_Enabled = 1 ;
      edtCitaArchivo_Jsonclick = "" ;
      edtCitaArchivo_Parameters = "" ;
      edtCitaArchivo_Contenttype = "" ;
      edtCitaArchivo_Filetype = "" ;
      edtCitaArchivo_Enabled = 1 ;
      edtCitaArchivoNombre_Jsonclick = "" ;
      edtCitaArchivoNombre_Enabled = 1 ;
      edtCitaMotivoConsulta_Enabled = 1 ;
      cmbCitaEstado.setJsonclick( "" );
      cmbCitaEstado.setEnabled( 1 );
      edtCitaEmailGenLink_Jsonclick = "" ;
      edtCitaEmailGenLink_Enabled = 1 ;
      edtCitaLog_Enabled = 1 ;
      edtCitaFechaReserva_Jsonclick = "" ;
      edtCitaFechaReserva_Enabled = 1 ;
      edtCitaLink_Jsonclick = "" ;
      edtCitaLink_Enabled = 1 ;
      edtCitaAntecedentes_Enabled = 1 ;
      edtCitaInforme_Enabled = 1 ;
      cmbCitaEstadoCita.setJsonclick( "" );
      cmbCitaEstadoCita.setEnabled( 1 );
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
      edtSGCitaDisponibilidadSedeNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadSedeId_Jsonclick = "" ;
      edtSGCitaDisponibilidadSedeId_Enabled = 0 ;
      edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick = "" ;
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
      edtSGCitaDisponibilidadId_Enabled = 1 ;
      edtSGCitaDisponibilidadId_Visible = 1 ;
      Combo_sgcitadisponibilidadid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_sgcitadisponibilidadid_Datalistprocparametersprefix = " \"ComboName\": \"SGCitaDisponibilidadId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CitaId\": 0" ;
      Combo_sgcitadisponibilidadid_Datalistproc = "CitaLoadDVCombo" ;
      Combo_sgcitadisponibilidadid_Cls = "ExtendedCombo Attribute" ;
      Combo_sgcitadisponibilidadid_Caption = "" ;
      Combo_sgcitadisponibilidadid_Enabled = GXutil.toBoolean( -1) ;
      cmbCitaTipoDiagnostico.setJsonclick( "" );
      cmbCitaTipoDiagnostico.setEnabled( 1 );
      edtPacienteNroDocumento_Jsonclick = "" ;
      edtPacienteNroDocumento_Enabled = 0 ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteNombres_Enabled = 0 ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Enabled = 0 ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Enabled = 0 ;
      edtPacienteId_Jsonclick = "" ;
      edtPacienteId_Enabled = 1 ;
      edtPacienteId_Visible = 1 ;
      Combo_pacienteid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_pacienteid_Datalistprocparametersprefix = " \"ComboName\": \"PacienteId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CitaId\": 0" ;
      Combo_pacienteid_Datalistproc = "CitaLoadDVCombo" ;
      Combo_pacienteid_Cls = "ExtendedCombo Attribute" ;
      Combo_pacienteid_Caption = "" ;
      Combo_pacienteid_Enabled = GXutil.toBoolean( -1) ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaCode_Enabled = 1 ;
      edtCitaId_Jsonclick = "" ;
      edtCitaId_Enabled = 0 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = "Información General" ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
         A65CitaTipoDiagnostico = cmbCitaTipoDiagnostico.getValidValue(A65CitaTipoDiagnostico) ;
         n65CitaTipoDiagnostico = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A65CitaTipoDiagnostico", A65CitaTipoDiagnostico);
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
         A89CitaEstadoCita = cmbCitaEstadoCita.getValidValue(A89CitaEstadoCita) ;
         n89CitaEstadoCita = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A89CitaEstadoCita", A89CitaEstadoCita);
      }
      cmbCitaEstado.setName( "CITAESTADO" );
      cmbCitaEstado.setWebtags( "" );
      cmbCitaEstado.addItem("A", "Activo", (short)(0));
      cmbCitaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbCitaEstado.getItemCount() > 0 )
      {
         A95CitaEstado = cmbCitaEstado.getValidValue(A95CitaEstado) ;
         n95CitaEstado = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A95CitaEstado", A95CitaEstado);
      }
      chkCitaConsentimiento.setName( "CITACONSENTIMIENTO" );
      chkCitaConsentimiento.setWebtags( "" );
      chkCitaConsentimiento.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCitaConsentimiento.getInternalname(), "TitleCaption", chkCitaConsentimiento.getCaption(), true);
      chkCitaConsentimiento.setCheckedValue( "false" );
      A97CitaConsentimiento = GXutil.strtobool( GXutil.booltostr( A97CitaConsentimiento)) ;
      n97CitaConsentimiento = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A97CitaConsentimiento", A97CitaConsentimiento);
      chkCitaGestante.setName( "CITAGESTANTE" );
      chkCitaGestante.setWebtags( "" );
      chkCitaGestante.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkCitaGestante.getInternalname(), "TitleCaption", chkCitaGestante.getCaption(), true);
      chkCitaGestante.setCheckedValue( "false" );
      A101CitaGestante = GXutil.strtobool( GXutil.booltostr( A101CitaGestante)) ;
      n101CitaGestante = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A101CitaGestante", A101CitaGestante);
      cmbCitaEstadoPago.setName( "CITAESTADOPAGO" );
      cmbCitaEstadoPago.setWebtags( "" );
      cmbCitaEstadoPago.addItem("S", "Sin Pago", (short)(0));
      cmbCitaEstadoPago.addItem("P", "Pendiente", (short)(0));
      cmbCitaEstadoPago.addItem("G", "Pagado", (short)(0));
      if ( cmbCitaEstadoPago.getItemCount() > 0 )
      {
         A102CitaEstadoPago = cmbCitaEstadoPago.getValidValue(A102CitaEstadoPago) ;
         n102CitaEstadoPago = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A102CitaEstadoPago", A102CitaEstadoPago);
      }
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Pacienteid( )
   {
      /* Using cursor T000A24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteId_Internalname ;
      }
      A103PacienteApellidoPaterno = T000A24_A103PacienteApellidoPaterno[0] ;
      A104PacienteApellidoMaterno = T000A24_A104PacienteApellidoMaterno[0] ;
      A105PacienteNombres = T000A24_A105PacienteNombres[0] ;
      A106PacienteNroDocumento = T000A24_A106PacienteNroDocumento[0] ;
      pr_default.close(22);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
   }

   public void valid_Sgcitadisponibilidadid( )
   {
      n84ProfesionalNombres = false ;
      n85ProfesionalApellidoPaterno = false ;
      n86ProfesionalApellidoMaterno = false ;
      n66SGCitaDisponibilidadFecha = false ;
      n68SGCitaDisponibilidadHoraInicio = false ;
      n387SGCitaDisponibilidadHoraFin = false ;
      /* Using cursor T000A25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGCitaDisponibilidadId_Internalname ;
      }
      A66SGCitaDisponibilidadFecha = T000A25_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000A25_n66SGCitaDisponibilidadFecha[0] ;
      A68SGCitaDisponibilidadHoraInicio = T000A25_A68SGCitaDisponibilidadHoraInicio[0] ;
      n68SGCitaDisponibilidadHoraInicio = T000A25_n68SGCitaDisponibilidadHoraInicio[0] ;
      A387SGCitaDisponibilidadHoraFin = T000A25_A387SGCitaDisponibilidadHoraFin[0] ;
      n387SGCitaDisponibilidadHoraFin = T000A25_n387SGCitaDisponibilidadHoraFin[0] ;
      A81SGCitaDisponibilidadProfesionalId = T000A25_A81SGCitaDisponibilidadProfesionalId[0] ;
      A70SGCitaDisponibilidadEspecialidadId = T000A25_A70SGCitaDisponibilidadEspecialidadId[0] ;
      A72SGCitaDisponibilidadSedeId = T000A25_A72SGCitaDisponibilidadSedeId[0] ;
      pr_default.close(23);
      /* Using cursor T000A26 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(24) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A87SGCitaDisponibilidadProCOP = T000A26_A87SGCitaDisponibilidadProCOP[0] ;
      A84ProfesionalNombres = T000A26_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = T000A26_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = T000A26_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = T000A26_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = T000A26_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = T000A26_n86ProfesionalApellidoMaterno[0] ;
      pr_default.close(24);
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      /* Using cursor T000A27 */
      pr_default.execute(25, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(25) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = T000A27_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      pr_default.close(25);
      /* Using cursor T000A28 */
      pr_default.execute(26, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(26) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A73SGCitaDisponibilidadSedeNombre = T000A28_A73SGCitaDisponibilidadSedeNombre[0] ;
      A76SGCitaDisponibilidadClinicaId = T000A28_A76SGCitaDisponibilidadClinicaId[0] ;
      pr_default.close(26);
      /* Using cursor T000A29 */
      pr_default.execute(27, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(27) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = T000A29_A78SGCitaDisponibilidadClinicaNombre[0] ;
      pr_default.close(27);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A68SGCitaDisponibilidadHoraInicio", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A387SGCitaDisponibilidadHoraFin", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A87SGCitaDisponibilidadProCOP", A87SGCitaDisponibilidadProCOP);
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A73SGCitaDisponibilidadSedeNombre", A73SGCitaDisponibilidadSedeNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV28CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV28CitaId',fld:'vCITAID',pic:'ZZZZZZZ9',hsh:true},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e120A2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITAID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'A103PacienteApellidoPaterno',fld:'PACIENTEAPELLIDOPATERNO',pic:''},{av:'A104PacienteApellidoMaterno',fld:'PACIENTEAPELLIDOMATERNO',pic:''},{av:'A105PacienteNombres',fld:'PACIENTENOMBRES',pic:''},{av:'A106PacienteNroDocumento',fld:'PACIENTENRODOCUMENTO',pic:''},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[{av:'A103PacienteApellidoPaterno',fld:'PACIENTEAPELLIDOPATERNO',pic:''},{av:'A104PacienteApellidoMaterno',fld:'PACIENTEAPELLIDOMATERNO',pic:''},{av:'A105PacienteNombres',fld:'PACIENTENOMBRES',pic:''},{av:'A106PacienteNroDocumento',fld:'PACIENTENRODOCUMENTO',pic:''},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITATIPODIAGNOSTICO","{handler:'valid_Citatipodiagnostico',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITATIPODIAGNOSTICO",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID","{handler:'valid_Sgcitadisponibilidadid',iparms:[{av:'A21SGCitaDisponibilidadId',fld:'SGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A81SGCitaDisponibilidadProfesionalId',fld:'SGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A84ProfesionalNombres',fld:'PROFESIONALNOMBRES',pic:''},{av:'A85ProfesionalApellidoPaterno',fld:'PROFESIONALAPELLIDOPATERNO',pic:''},{av:'A86ProfesionalApellidoMaterno',fld:'PROFESIONALAPELLIDOMATERNO',pic:''},{av:'A70SGCitaDisponibilidadEspecialidadId',fld:'SGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'A72SGCitaDisponibilidadSedeId',fld:'SGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'A76SGCitaDisponibilidadClinicaId',fld:'SGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'A66SGCitaDisponibilidadFecha',fld:'SGCITADISPONIBILIDADFECHA',pic:''},{av:'A68SGCitaDisponibilidadHoraInicio',fld:'SGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'A387SGCitaDisponibilidadHoraFin',fld:'SGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'A87SGCitaDisponibilidadProCOP',fld:'SGCITADISPONIBILIDADPROCOP',pic:''},{av:'A82SGCitaDisponibilidadProFullName',fld:'SGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'A146SGCitaDisponibilidadEspecialidadNombre',fld:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'A73SGCitaDisponibilidadSedeNombre',fld:'SGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'A78SGCitaDisponibilidadClinicaNombre',fld:'SGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID",",oparms:[{av:'A66SGCitaDisponibilidadFecha',fld:'SGCITADISPONIBILIDADFECHA',pic:''},{av:'A68SGCitaDisponibilidadHoraInicio',fld:'SGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'A387SGCitaDisponibilidadHoraFin',fld:'SGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'A81SGCitaDisponibilidadProfesionalId',fld:'SGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A70SGCitaDisponibilidadEspecialidadId',fld:'SGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'A72SGCitaDisponibilidadSedeId',fld:'SGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'A87SGCitaDisponibilidadProCOP',fld:'SGCITADISPONIBILIDADPROCOP',pic:''},{av:'A84ProfesionalNombres',fld:'PROFESIONALNOMBRES',pic:''},{av:'A85ProfesionalApellidoPaterno',fld:'PROFESIONALAPELLIDOPATERNO',pic:''},{av:'A86ProfesionalApellidoMaterno',fld:'PROFESIONALAPELLIDOMATERNO',pic:''},{av:'A82SGCitaDisponibilidadProFullName',fld:'SGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'A146SGCitaDisponibilidadEspecialidadNombre',fld:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'A73SGCitaDisponibilidadSedeNombre',fld:'SGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'A76SGCitaDisponibilidadClinicaId',fld:'SGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'A78SGCitaDisponibilidadClinicaNombre',fld:'SGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID","{handler:'valid_Sgcitadisponibilidadespecialidadid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADSEDEID","{handler:'valid_Sgcitadisponibilidadsedeid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADSEDEID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID","{handler:'valid_Sgcitadisponibilidadclinicaid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID","{handler:'valid_Sgcitadisponibilidadprofesionalid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITAESTADOCITA","{handler:'valid_Citaestadocita',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITAESTADOCITA",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITALINK","{handler:'valid_Citalink',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITALINK",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITAFECHARESERVA","{handler:'valid_Citafechareserva',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITAFECHARESERVA",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITAEMAILGENLINK","{handler:'valid_Citaemailgenlink',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITAEMAILGENLINK",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITAESTADO","{handler:'valid_Citaestado',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITAESTADO",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALID_CITAESTADOPAGO","{handler:'valid_Citaestadopago',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALID_CITAESTADOPAGO",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALIDV_COMBOPACIENTEID","{handler:'validv_Combopacienteid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALIDV_COMBOPACIENTEID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
      setEventMetadata("VALIDV_COMBOSGCITADISPONIBILIDADID","{handler:'validv_Combosgcitadisponibilidadid',iparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]");
      setEventMetadata("VALIDV_COMBOSGCITADISPONIBILIDADID",",oparms:[{av:'A97CitaConsentimiento',fld:'CITACONSENTIMIENTO',pic:''},{av:'A101CitaGestante',fld:'CITAGESTANTE',pic:''}]}");
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
      pr_default.close(22);
      pr_default.close(23);
      pr_default.close(24);
      pr_default.close(25);
      pr_default.close(26);
      pr_default.close(27);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z64CitaCode = "" ;
      Z65CitaTipoDiagnostico = "" ;
      Z89CitaEstadoCita = "" ;
      Z91CitaLink = "" ;
      Z92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      Z93CitaLog = "" ;
      Z94CitaEmailGenLink = "" ;
      Z95CitaEstado = "" ;
      Z96CitaArchivoNombre = "" ;
      Z333CitaArchivoExtencion = "" ;
      Z102CitaEstadoPago = "" ;
      Z306CitaPeso = DecimalUtil.ZERO ;
      Z307CitaEstatura = DecimalUtil.ZERO ;
      Combo_sgcitadisponibilidadid_Selectedvalue_get = "" ;
      Combo_pacienteid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A65CitaTipoDiagnostico = "" ;
      A89CitaEstadoCita = "" ;
      A95CitaEstado = "" ;
      A102CitaEstadoPago = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A64CitaCode = "" ;
      lblTextblockpacienteid_Jsonclick = "" ;
      ucCombo_pacienteid = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17PacienteId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A106PacienteNroDocumento = "" ;
      lblTextblocksgcitadisponibilidadid_Jsonclick = "" ;
      ucCombo_sgcitadisponibilidadid = new com.genexus.webpanels.GXUserControl();
      AV25SGCitaDisponibilidadId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A87SGCitaDisponibilidadProCOP = "" ;
      A90CitaInforme = "" ;
      A100CitaAntecedentes = "" ;
      A91CitaLink = "" ;
      A92CitaFechaReserva = GXutil.resetTime( GXutil.nullDate() );
      A93CitaLog = "" ;
      A94CitaEmailGenLink = "" ;
      A99CitaMotivoConsulta = "" ;
      A96CitaArchivoNombre = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A98CitaArchivo = "" ;
      A333CitaArchivoExtencion = "" ;
      A306CitaPeso = DecimalUtil.ZERO ;
      A307CitaEstatura = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      AV29Pgmname = "" ;
      Combo_pacienteid_Objectcall = "" ;
      Combo_pacienteid_Class = "" ;
      Combo_pacienteid_Icontype = "" ;
      Combo_pacienteid_Icon = "" ;
      Combo_pacienteid_Tooltip = "" ;
      Combo_pacienteid_Selectedvalue_set = "" ;
      Combo_pacienteid_Selectedtext_set = "" ;
      Combo_pacienteid_Selectedtext_get = "" ;
      Combo_pacienteid_Gamoauthtoken = "" ;
      Combo_pacienteid_Ddointernalname = "" ;
      Combo_pacienteid_Titlecontrolalign = "" ;
      Combo_pacienteid_Dropdownoptionstype = "" ;
      Combo_pacienteid_Titlecontrolidtoreplace = "" ;
      Combo_pacienteid_Datalisttype = "" ;
      Combo_pacienteid_Datalistfixedvalues = "" ;
      Combo_pacienteid_Htmltemplate = "" ;
      Combo_pacienteid_Multiplevaluestype = "" ;
      Combo_pacienteid_Loadingdata = "" ;
      Combo_pacienteid_Noresultsfound = "" ;
      Combo_pacienteid_Emptyitemtext = "" ;
      Combo_pacienteid_Onlyselectedvalues = "" ;
      Combo_pacienteid_Selectalltext = "" ;
      Combo_pacienteid_Multiplevaluesseparator = "" ;
      Combo_pacienteid_Addnewoptiontext = "" ;
      Combo_sgcitadisponibilidadid_Objectcall = "" ;
      Combo_sgcitadisponibilidadid_Class = "" ;
      Combo_sgcitadisponibilidadid_Icontype = "" ;
      Combo_sgcitadisponibilidadid_Icon = "" ;
      Combo_sgcitadisponibilidadid_Tooltip = "" ;
      Combo_sgcitadisponibilidadid_Selectedvalue_set = "" ;
      Combo_sgcitadisponibilidadid_Selectedtext_set = "" ;
      Combo_sgcitadisponibilidadid_Selectedtext_get = "" ;
      Combo_sgcitadisponibilidadid_Gamoauthtoken = "" ;
      Combo_sgcitadisponibilidadid_Ddointernalname = "" ;
      Combo_sgcitadisponibilidadid_Titlecontrolalign = "" ;
      Combo_sgcitadisponibilidadid_Dropdownoptionstype = "" ;
      Combo_sgcitadisponibilidadid_Titlecontrolidtoreplace = "" ;
      Combo_sgcitadisponibilidadid_Datalisttype = "" ;
      Combo_sgcitadisponibilidadid_Datalistfixedvalues = "" ;
      Combo_sgcitadisponibilidadid_Htmltemplate = "" ;
      Combo_sgcitadisponibilidadid_Multiplevaluestype = "" ;
      Combo_sgcitadisponibilidadid_Loadingdata = "" ;
      Combo_sgcitadisponibilidadid_Noresultsfound = "" ;
      Combo_sgcitadisponibilidadid_Emptyitemtext = "" ;
      Combo_sgcitadisponibilidadid_Onlyselectedvalues = "" ;
      Combo_sgcitadisponibilidadid_Selectalltext = "" ;
      Combo_sgcitadisponibilidadid_Multiplevaluesseparator = "" ;
      Combo_sgcitadisponibilidadid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      GXCCtlgxBlob = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode17 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV21Combo_DataJson = "" ;
      AV19ComboSelectedValue = "" ;
      AV20ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z90CitaInforme = "" ;
      Z100CitaAntecedentes = "" ;
      Z99CitaMotivoConsulta = "" ;
      Z98CitaArchivo = "" ;
      Z103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      Z106PacienteNroDocumento = "" ;
      Z66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      Z68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      Z387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      Z87SGCitaDisponibilidadProCOP = "" ;
      Z84ProfesionalNombres = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      Z146SGCitaDisponibilidadEspecialidadNombre = "" ;
      Z73SGCitaDisponibilidadSedeNombre = "" ;
      Z78SGCitaDisponibilidadClinicaNombre = "" ;
      T000A4_A103PacienteApellidoPaterno = new String[] {""} ;
      T000A4_A104PacienteApellidoMaterno = new String[] {""} ;
      T000A4_A105PacienteNombres = new String[] {""} ;
      T000A4_A106PacienteNroDocumento = new String[] {""} ;
      T000A5_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000A5_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000A5_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T000A5_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      T000A5_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      T000A5_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      T000A5_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000A5_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000A5_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000A6_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      T000A6_A84ProfesionalNombres = new String[] {""} ;
      T000A6_n84ProfesionalNombres = new boolean[] {false} ;
      T000A6_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000A6_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000A6_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000A6_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000A7_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000A8_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      T000A8_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000A9_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000A10_A19CitaId = new int[1] ;
      T000A10_n19CitaId = new boolean[] {false} ;
      T000A10_A64CitaCode = new String[] {""} ;
      T000A10_A103PacienteApellidoPaterno = new String[] {""} ;
      T000A10_A104PacienteApellidoMaterno = new String[] {""} ;
      T000A10_A105PacienteNombres = new String[] {""} ;
      T000A10_A106PacienteNroDocumento = new String[] {""} ;
      T000A10_A65CitaTipoDiagnostico = new String[] {""} ;
      T000A10_n65CitaTipoDiagnostico = new boolean[] {false} ;
      T000A10_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000A10_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000A10_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T000A10_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      T000A10_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      T000A10_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      T000A10_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000A10_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      T000A10_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000A10_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      T000A10_A89CitaEstadoCita = new String[] {""} ;
      T000A10_n89CitaEstadoCita = new boolean[] {false} ;
      T000A10_A90CitaInforme = new String[] {""} ;
      T000A10_n90CitaInforme = new boolean[] {false} ;
      T000A10_A100CitaAntecedentes = new String[] {""} ;
      T000A10_n100CitaAntecedentes = new boolean[] {false} ;
      T000A10_A91CitaLink = new String[] {""} ;
      T000A10_n91CitaLink = new boolean[] {false} ;
      T000A10_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      T000A10_n92CitaFechaReserva = new boolean[] {false} ;
      T000A10_A93CitaLog = new String[] {""} ;
      T000A10_n93CitaLog = new boolean[] {false} ;
      T000A10_A94CitaEmailGenLink = new String[] {""} ;
      T000A10_n94CitaEmailGenLink = new boolean[] {false} ;
      T000A10_A95CitaEstado = new String[] {""} ;
      T000A10_n95CitaEstado = new boolean[] {false} ;
      T000A10_A99CitaMotivoConsulta = new String[] {""} ;
      T000A10_n99CitaMotivoConsulta = new boolean[] {false} ;
      T000A10_A96CitaArchivoNombre = new String[] {""} ;
      T000A10_n96CitaArchivoNombre = new boolean[] {false} ;
      T000A10_A98CitaArchivo = new String[] {""} ;
      T000A10_n98CitaArchivo = new boolean[] {false} ;
      T000A10_A333CitaArchivoExtencion = new String[] {""} ;
      T000A10_n333CitaArchivoExtencion = new boolean[] {false} ;
      T000A10_A97CitaConsentimiento = new boolean[] {false} ;
      T000A10_n97CitaConsentimiento = new boolean[] {false} ;
      T000A10_A101CitaGestante = new boolean[] {false} ;
      T000A10_n101CitaGestante = new boolean[] {false} ;
      T000A10_A102CitaEstadoPago = new String[] {""} ;
      T000A10_n102CitaEstadoPago = new boolean[] {false} ;
      T000A10_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A10_n306CitaPeso = new boolean[] {false} ;
      T000A10_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A10_n307CitaEstatura = new boolean[] {false} ;
      T000A10_A84ProfesionalNombres = new String[] {""} ;
      T000A10_n84ProfesionalNombres = new boolean[] {false} ;
      T000A10_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000A10_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000A10_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000A10_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000A10_A20PacienteId = new int[1] ;
      T000A10_A21SGCitaDisponibilidadId = new int[1] ;
      T000A10_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000A10_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000A10_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000A10_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000A11_A103PacienteApellidoPaterno = new String[] {""} ;
      T000A11_A104PacienteApellidoMaterno = new String[] {""} ;
      T000A11_A105PacienteNombres = new String[] {""} ;
      T000A11_A106PacienteNroDocumento = new String[] {""} ;
      T000A12_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000A12_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000A12_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T000A12_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      T000A12_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      T000A12_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      T000A12_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000A12_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000A12_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000A13_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      T000A13_A84ProfesionalNombres = new String[] {""} ;
      T000A13_n84ProfesionalNombres = new boolean[] {false} ;
      T000A13_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000A13_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000A13_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000A13_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000A14_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000A15_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      T000A15_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000A16_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000A17_A19CitaId = new int[1] ;
      T000A17_n19CitaId = new boolean[] {false} ;
      T000A3_A19CitaId = new int[1] ;
      T000A3_n19CitaId = new boolean[] {false} ;
      T000A3_A64CitaCode = new String[] {""} ;
      T000A3_A65CitaTipoDiagnostico = new String[] {""} ;
      T000A3_n65CitaTipoDiagnostico = new boolean[] {false} ;
      T000A3_A89CitaEstadoCita = new String[] {""} ;
      T000A3_n89CitaEstadoCita = new boolean[] {false} ;
      T000A3_A90CitaInforme = new String[] {""} ;
      T000A3_n90CitaInforme = new boolean[] {false} ;
      T000A3_A100CitaAntecedentes = new String[] {""} ;
      T000A3_n100CitaAntecedentes = new boolean[] {false} ;
      T000A3_A91CitaLink = new String[] {""} ;
      T000A3_n91CitaLink = new boolean[] {false} ;
      T000A3_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      T000A3_n92CitaFechaReserva = new boolean[] {false} ;
      T000A3_A93CitaLog = new String[] {""} ;
      T000A3_n93CitaLog = new boolean[] {false} ;
      T000A3_A94CitaEmailGenLink = new String[] {""} ;
      T000A3_n94CitaEmailGenLink = new boolean[] {false} ;
      T000A3_A95CitaEstado = new String[] {""} ;
      T000A3_n95CitaEstado = new boolean[] {false} ;
      T000A3_A99CitaMotivoConsulta = new String[] {""} ;
      T000A3_n99CitaMotivoConsulta = new boolean[] {false} ;
      T000A3_A96CitaArchivoNombre = new String[] {""} ;
      T000A3_n96CitaArchivoNombre = new boolean[] {false} ;
      T000A3_A98CitaArchivo = new String[] {""} ;
      T000A3_n98CitaArchivo = new boolean[] {false} ;
      T000A3_A333CitaArchivoExtencion = new String[] {""} ;
      T000A3_n333CitaArchivoExtencion = new boolean[] {false} ;
      T000A3_A97CitaConsentimiento = new boolean[] {false} ;
      T000A3_n97CitaConsentimiento = new boolean[] {false} ;
      T000A3_A101CitaGestante = new boolean[] {false} ;
      T000A3_n101CitaGestante = new boolean[] {false} ;
      T000A3_A102CitaEstadoPago = new String[] {""} ;
      T000A3_n102CitaEstadoPago = new boolean[] {false} ;
      T000A3_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A3_n306CitaPeso = new boolean[] {false} ;
      T000A3_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A3_n307CitaEstatura = new boolean[] {false} ;
      T000A3_A20PacienteId = new int[1] ;
      T000A3_A21SGCitaDisponibilidadId = new int[1] ;
      T000A18_A19CitaId = new int[1] ;
      T000A18_n19CitaId = new boolean[] {false} ;
      T000A19_A19CitaId = new int[1] ;
      T000A19_n19CitaId = new boolean[] {false} ;
      T000A2_A19CitaId = new int[1] ;
      T000A2_n19CitaId = new boolean[] {false} ;
      T000A2_A64CitaCode = new String[] {""} ;
      T000A2_A65CitaTipoDiagnostico = new String[] {""} ;
      T000A2_n65CitaTipoDiagnostico = new boolean[] {false} ;
      T000A2_A89CitaEstadoCita = new String[] {""} ;
      T000A2_n89CitaEstadoCita = new boolean[] {false} ;
      T000A2_A90CitaInforme = new String[] {""} ;
      T000A2_n90CitaInforme = new boolean[] {false} ;
      T000A2_A100CitaAntecedentes = new String[] {""} ;
      T000A2_n100CitaAntecedentes = new boolean[] {false} ;
      T000A2_A91CitaLink = new String[] {""} ;
      T000A2_n91CitaLink = new boolean[] {false} ;
      T000A2_A92CitaFechaReserva = new java.util.Date[] {GXutil.nullDate()} ;
      T000A2_n92CitaFechaReserva = new boolean[] {false} ;
      T000A2_A93CitaLog = new String[] {""} ;
      T000A2_n93CitaLog = new boolean[] {false} ;
      T000A2_A94CitaEmailGenLink = new String[] {""} ;
      T000A2_n94CitaEmailGenLink = new boolean[] {false} ;
      T000A2_A95CitaEstado = new String[] {""} ;
      T000A2_n95CitaEstado = new boolean[] {false} ;
      T000A2_A99CitaMotivoConsulta = new String[] {""} ;
      T000A2_n99CitaMotivoConsulta = new boolean[] {false} ;
      T000A2_A96CitaArchivoNombre = new String[] {""} ;
      T000A2_n96CitaArchivoNombre = new boolean[] {false} ;
      T000A2_A98CitaArchivo = new String[] {""} ;
      T000A2_n98CitaArchivo = new boolean[] {false} ;
      T000A2_A333CitaArchivoExtencion = new String[] {""} ;
      T000A2_n333CitaArchivoExtencion = new boolean[] {false} ;
      T000A2_A97CitaConsentimiento = new boolean[] {false} ;
      T000A2_n97CitaConsentimiento = new boolean[] {false} ;
      T000A2_A101CitaGestante = new boolean[] {false} ;
      T000A2_n101CitaGestante = new boolean[] {false} ;
      T000A2_A102CitaEstadoPago = new String[] {""} ;
      T000A2_n102CitaEstadoPago = new boolean[] {false} ;
      T000A2_A306CitaPeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A2_n306CitaPeso = new boolean[] {false} ;
      T000A2_A307CitaEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000A2_n307CitaEstatura = new boolean[] {false} ;
      T000A2_A20PacienteId = new int[1] ;
      T000A2_A21SGCitaDisponibilidadId = new int[1] ;
      T000A20_A19CitaId = new int[1] ;
      T000A20_n19CitaId = new boolean[] {false} ;
      T000A24_A103PacienteApellidoPaterno = new String[] {""} ;
      T000A24_A104PacienteApellidoMaterno = new String[] {""} ;
      T000A24_A105PacienteNombres = new String[] {""} ;
      T000A24_A106PacienteNroDocumento = new String[] {""} ;
      T000A25_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000A25_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000A25_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T000A25_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      T000A25_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      T000A25_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      T000A25_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000A25_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000A25_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000A26_A87SGCitaDisponibilidadProCOP = new String[] {""} ;
      T000A26_A84ProfesionalNombres = new String[] {""} ;
      T000A26_n84ProfesionalNombres = new boolean[] {false} ;
      T000A26_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000A26_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000A26_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000A26_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000A27_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000A28_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      T000A28_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000A29_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000A30_A50RecetaMedicaId = new short[1] ;
      T000A31_A47PagoId = new int[1] ;
      T000A32_A37EncuestaId = new short[1] ;
      T000A33_A26CitaServicioId = new int[1] ;
      T000A34_A24CitaRecetaId = new int[1] ;
      T000A35_A22CitaDiagnosticoId = new int[1] ;
      T000A36_A19CitaId = new int[1] ;
      T000A36_n19CitaId = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Z82SGCitaDisponibilidadProFullName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.cita__default(),
         new Object[] {
             new Object[] {
            T000A2_A19CitaId, T000A2_A64CitaCode, T000A2_A65CitaTipoDiagnostico, T000A2_n65CitaTipoDiagnostico, T000A2_A89CitaEstadoCita, T000A2_n89CitaEstadoCita, T000A2_A90CitaInforme, T000A2_n90CitaInforme, T000A2_A100CitaAntecedentes, T000A2_n100CitaAntecedentes,
            T000A2_A91CitaLink, T000A2_n91CitaLink, T000A2_A92CitaFechaReserva, T000A2_n92CitaFechaReserva, T000A2_A93CitaLog, T000A2_n93CitaLog, T000A2_A94CitaEmailGenLink, T000A2_n94CitaEmailGenLink, T000A2_A95CitaEstado, T000A2_n95CitaEstado,
            T000A2_A99CitaMotivoConsulta, T000A2_n99CitaMotivoConsulta, T000A2_A96CitaArchivoNombre, T000A2_n96CitaArchivoNombre, T000A2_A98CitaArchivo, T000A2_n98CitaArchivo, T000A2_A333CitaArchivoExtencion, T000A2_n333CitaArchivoExtencion, T000A2_A97CitaConsentimiento, T000A2_n97CitaConsentimiento,
            T000A2_A101CitaGestante, T000A2_n101CitaGestante, T000A2_A102CitaEstadoPago, T000A2_n102CitaEstadoPago, T000A2_A306CitaPeso, T000A2_n306CitaPeso, T000A2_A307CitaEstatura, T000A2_n307CitaEstatura, T000A2_A20PacienteId, T000A2_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            T000A3_A19CitaId, T000A3_A64CitaCode, T000A3_A65CitaTipoDiagnostico, T000A3_n65CitaTipoDiagnostico, T000A3_A89CitaEstadoCita, T000A3_n89CitaEstadoCita, T000A3_A90CitaInforme, T000A3_n90CitaInforme, T000A3_A100CitaAntecedentes, T000A3_n100CitaAntecedentes,
            T000A3_A91CitaLink, T000A3_n91CitaLink, T000A3_A92CitaFechaReserva, T000A3_n92CitaFechaReserva, T000A3_A93CitaLog, T000A3_n93CitaLog, T000A3_A94CitaEmailGenLink, T000A3_n94CitaEmailGenLink, T000A3_A95CitaEstado, T000A3_n95CitaEstado,
            T000A3_A99CitaMotivoConsulta, T000A3_n99CitaMotivoConsulta, T000A3_A96CitaArchivoNombre, T000A3_n96CitaArchivoNombre, T000A3_A98CitaArchivo, T000A3_n98CitaArchivo, T000A3_A333CitaArchivoExtencion, T000A3_n333CitaArchivoExtencion, T000A3_A97CitaConsentimiento, T000A3_n97CitaConsentimiento,
            T000A3_A101CitaGestante, T000A3_n101CitaGestante, T000A3_A102CitaEstadoPago, T000A3_n102CitaEstadoPago, T000A3_A306CitaPeso, T000A3_n306CitaPeso, T000A3_A307CitaEstatura, T000A3_n307CitaEstatura, T000A3_A20PacienteId, T000A3_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            T000A4_A103PacienteApellidoPaterno, T000A4_A104PacienteApellidoMaterno, T000A4_A105PacienteNombres, T000A4_A106PacienteNroDocumento
            }
            , new Object[] {
            T000A5_A66SGCitaDisponibilidadFecha, T000A5_n66SGCitaDisponibilidadFecha, T000A5_A68SGCitaDisponibilidadHoraInicio, T000A5_n68SGCitaDisponibilidadHoraInicio, T000A5_A387SGCitaDisponibilidadHoraFin, T000A5_n387SGCitaDisponibilidadHoraFin, T000A5_A81SGCitaDisponibilidadProfesionalId, T000A5_A70SGCitaDisponibilidadEspecialidadId, T000A5_A72SGCitaDisponibilidadSedeId
            }
            , new Object[] {
            T000A6_A87SGCitaDisponibilidadProCOP, T000A6_A84ProfesionalNombres, T000A6_n84ProfesionalNombres, T000A6_A85ProfesionalApellidoPaterno, T000A6_n85ProfesionalApellidoPaterno, T000A6_A86ProfesionalApellidoMaterno, T000A6_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            T000A7_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            T000A8_A73SGCitaDisponibilidadSedeNombre, T000A8_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000A9_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            T000A10_A19CitaId, T000A10_A64CitaCode, T000A10_A103PacienteApellidoPaterno, T000A10_A104PacienteApellidoMaterno, T000A10_A105PacienteNombres, T000A10_A106PacienteNroDocumento, T000A10_A65CitaTipoDiagnostico, T000A10_n65CitaTipoDiagnostico, T000A10_A66SGCitaDisponibilidadFecha, T000A10_n66SGCitaDisponibilidadFecha,
            T000A10_A68SGCitaDisponibilidadHoraInicio, T000A10_n68SGCitaDisponibilidadHoraInicio, T000A10_A387SGCitaDisponibilidadHoraFin, T000A10_n387SGCitaDisponibilidadHoraFin, T000A10_A146SGCitaDisponibilidadEspecialidadNombre, T000A10_A73SGCitaDisponibilidadSedeNombre, T000A10_A78SGCitaDisponibilidadClinicaNombre, T000A10_A87SGCitaDisponibilidadProCOP, T000A10_A89CitaEstadoCita, T000A10_n89CitaEstadoCita,
            T000A10_A90CitaInforme, T000A10_n90CitaInforme, T000A10_A100CitaAntecedentes, T000A10_n100CitaAntecedentes, T000A10_A91CitaLink, T000A10_n91CitaLink, T000A10_A92CitaFechaReserva, T000A10_n92CitaFechaReserva, T000A10_A93CitaLog, T000A10_n93CitaLog,
            T000A10_A94CitaEmailGenLink, T000A10_n94CitaEmailGenLink, T000A10_A95CitaEstado, T000A10_n95CitaEstado, T000A10_A99CitaMotivoConsulta, T000A10_n99CitaMotivoConsulta, T000A10_A96CitaArchivoNombre, T000A10_n96CitaArchivoNombre, T000A10_A98CitaArchivo, T000A10_n98CitaArchivo,
            T000A10_A333CitaArchivoExtencion, T000A10_n333CitaArchivoExtencion, T000A10_A97CitaConsentimiento, T000A10_n97CitaConsentimiento, T000A10_A101CitaGestante, T000A10_n101CitaGestante, T000A10_A102CitaEstadoPago, T000A10_n102CitaEstadoPago, T000A10_A306CitaPeso, T000A10_n306CitaPeso,
            T000A10_A307CitaEstatura, T000A10_n307CitaEstatura, T000A10_A84ProfesionalNombres, T000A10_n84ProfesionalNombres, T000A10_A85ProfesionalApellidoPaterno, T000A10_n85ProfesionalApellidoPaterno, T000A10_A86ProfesionalApellidoMaterno, T000A10_n86ProfesionalApellidoMaterno, T000A10_A20PacienteId, T000A10_A21SGCitaDisponibilidadId,
            T000A10_A81SGCitaDisponibilidadProfesionalId, T000A10_A70SGCitaDisponibilidadEspecialidadId, T000A10_A72SGCitaDisponibilidadSedeId, T000A10_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000A11_A103PacienteApellidoPaterno, T000A11_A104PacienteApellidoMaterno, T000A11_A105PacienteNombres, T000A11_A106PacienteNroDocumento
            }
            , new Object[] {
            T000A12_A66SGCitaDisponibilidadFecha, T000A12_n66SGCitaDisponibilidadFecha, T000A12_A68SGCitaDisponibilidadHoraInicio, T000A12_n68SGCitaDisponibilidadHoraInicio, T000A12_A387SGCitaDisponibilidadHoraFin, T000A12_n387SGCitaDisponibilidadHoraFin, T000A12_A81SGCitaDisponibilidadProfesionalId, T000A12_A70SGCitaDisponibilidadEspecialidadId, T000A12_A72SGCitaDisponibilidadSedeId
            }
            , new Object[] {
            T000A13_A87SGCitaDisponibilidadProCOP, T000A13_A84ProfesionalNombres, T000A13_n84ProfesionalNombres, T000A13_A85ProfesionalApellidoPaterno, T000A13_n85ProfesionalApellidoPaterno, T000A13_A86ProfesionalApellidoMaterno, T000A13_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            T000A14_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            T000A15_A73SGCitaDisponibilidadSedeNombre, T000A15_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000A16_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            T000A17_A19CitaId
            }
            , new Object[] {
            T000A18_A19CitaId
            }
            , new Object[] {
            T000A19_A19CitaId
            }
            , new Object[] {
            T000A20_A19CitaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000A24_A103PacienteApellidoPaterno, T000A24_A104PacienteApellidoMaterno, T000A24_A105PacienteNombres, T000A24_A106PacienteNroDocumento
            }
            , new Object[] {
            T000A25_A66SGCitaDisponibilidadFecha, T000A25_n66SGCitaDisponibilidadFecha, T000A25_A68SGCitaDisponibilidadHoraInicio, T000A25_n68SGCitaDisponibilidadHoraInicio, T000A25_A387SGCitaDisponibilidadHoraFin, T000A25_n387SGCitaDisponibilidadHoraFin, T000A25_A81SGCitaDisponibilidadProfesionalId, T000A25_A70SGCitaDisponibilidadEspecialidadId, T000A25_A72SGCitaDisponibilidadSedeId
            }
            , new Object[] {
            T000A26_A87SGCitaDisponibilidadProCOP, T000A26_A84ProfesionalNombres, T000A26_n84ProfesionalNombres, T000A26_A85ProfesionalApellidoPaterno, T000A26_n85ProfesionalApellidoPaterno, T000A26_A86ProfesionalApellidoMaterno, T000A26_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            T000A27_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            T000A28_A73SGCitaDisponibilidadSedeNombre, T000A28_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000A29_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            T000A30_A50RecetaMedicaId
            }
            , new Object[] {
            T000A31_A47PagoId
            }
            , new Object[] {
            T000A32_A37EncuestaId
            }
            , new Object[] {
            T000A33_A26CitaServicioId
            }
            , new Object[] {
            T000A34_A24CitaRecetaId
            }
            , new Object[] {
            T000A35_A22CitaDiagnosticoId
            }
            , new Object[] {
            T000A36_A19CitaId
            }
         }
      );
      AV29Pgmname = "Cita" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound17 ;
   private short Z70SGCitaDisponibilidadEspecialidadId ;
   private short Z72SGCitaDisponibilidadSedeId ;
   private short Z76SGCitaDisponibilidadClinicaId ;
   private short nIsDirty_17 ;
   private int wcpOAV28CitaId ;
   private int Z19CitaId ;
   private int Z20PacienteId ;
   private int Z21SGCitaDisponibilidadId ;
   private int N20PacienteId ;
   private int N21SGCitaDisponibilidadId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int AV28CitaId ;
   private int trnEnded ;
   private int A19CitaId ;
   private int edtCitaId_Enabled ;
   private int edtCitaCode_Enabled ;
   private int edtPacienteId_Visible ;
   private int edtPacienteId_Enabled ;
   private int edtPacienteApellidoPaterno_Enabled ;
   private int edtPacienteApellidoMaterno_Enabled ;
   private int edtPacienteNombres_Enabled ;
   private int edtPacienteNroDocumento_Enabled ;
   private int edtSGCitaDisponibilidadId_Visible ;
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
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV22ComboPacienteId ;
   private int edtavCombopacienteid_Enabled ;
   private int edtavCombopacienteid_Visible ;
   private int AV26ComboSGCitaDisponibilidadId ;
   private int edtavCombosgcitadisponibilidadid_Enabled ;
   private int edtavCombosgcitadisponibilidadid_Visible ;
   private int AV12Insert_PacienteId ;
   private int AV13Insert_SGCitaDisponibilidadId ;
   private int Combo_pacienteid_Datalistupdateminimumcharacters ;
   private int Combo_sgcitadisponibilidadid_Datalistupdateminimumcharacters ;
   private int AV30GXV1 ;
   private int GX_JID ;
   private int Z81SGCitaDisponibilidadProfesionalId ;
   private int idxLst ;
   private java.math.BigDecimal Z306CitaPeso ;
   private java.math.BigDecimal Z307CitaEstatura ;
   private java.math.BigDecimal A306CitaPeso ;
   private java.math.BigDecimal A307CitaEstatura ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z89CitaEstadoCita ;
   private String Z95CitaEstado ;
   private String Z102CitaEstadoPago ;
   private String Combo_sgcitadisponibilidadid_Selectedvalue_get ;
   private String Combo_pacienteid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCitaCode_Internalname ;
   private String A89CitaEstadoCita ;
   private String A95CitaEstado ;
   private String A102CitaEstadoPago ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtCitaId_Jsonclick ;
   private String TempTags ;
   private String edtCitaCode_Jsonclick ;
   private String divTablesplittedpacienteid_Internalname ;
   private String lblTextblockpacienteid_Internalname ;
   private String lblTextblockpacienteid_Jsonclick ;
   private String Combo_pacienteid_Caption ;
   private String Combo_pacienteid_Cls ;
   private String Combo_pacienteid_Datalistproc ;
   private String Combo_pacienteid_Datalistprocparametersprefix ;
   private String Combo_pacienteid_Internalname ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteId_Jsonclick ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtPacienteNroDocumento_Jsonclick ;
   private String divTablesplittedsgcitadisponibilidadid_Internalname ;
   private String lblTextblocksgcitadisponibilidadid_Internalname ;
   private String lblTextblocksgcitadisponibilidadid_Jsonclick ;
   private String Combo_sgcitadisponibilidadid_Caption ;
   private String Combo_sgcitadisponibilidadid_Cls ;
   private String Combo_sgcitadisponibilidadid_Datalistproc ;
   private String Combo_sgcitadisponibilidadid_Datalistprocparametersprefix ;
   private String Combo_sgcitadisponibilidadid_Internalname ;
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
   private String edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadSedeId_Internalname ;
   private String edtSGCitaDisponibilidadSedeId_Jsonclick ;
   private String edtSGCitaDisponibilidadSedeNombre_Internalname ;
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
   private String edtCitaInforme_Internalname ;
   private String edtCitaAntecedentes_Internalname ;
   private String edtCitaLink_Internalname ;
   private String edtCitaLink_Jsonclick ;
   private String edtCitaFechaReserva_Internalname ;
   private String edtCitaFechaReserva_Jsonclick ;
   private String edtCitaLog_Internalname ;
   private String edtCitaEmailGenLink_Internalname ;
   private String edtCitaEmailGenLink_Jsonclick ;
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
   private String edtCitaPeso_Internalname ;
   private String edtCitaPeso_Jsonclick ;
   private String edtCitaEstatura_Internalname ;
   private String edtCitaEstatura_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_pacienteid_Internalname ;
   private String edtavCombopacienteid_Internalname ;
   private String edtavCombopacienteid_Jsonclick ;
   private String divSectionattribute_sgcitadisponibilidadid_Internalname ;
   private String edtavCombosgcitadisponibilidadid_Internalname ;
   private String edtavCombosgcitadisponibilidadid_Jsonclick ;
   private String AV29Pgmname ;
   private String Combo_pacienteid_Objectcall ;
   private String Combo_pacienteid_Class ;
   private String Combo_pacienteid_Icontype ;
   private String Combo_pacienteid_Icon ;
   private String Combo_pacienteid_Tooltip ;
   private String Combo_pacienteid_Selectedvalue_set ;
   private String Combo_pacienteid_Selectedtext_set ;
   private String Combo_pacienteid_Selectedtext_get ;
   private String Combo_pacienteid_Gamoauthtoken ;
   private String Combo_pacienteid_Ddointernalname ;
   private String Combo_pacienteid_Titlecontrolalign ;
   private String Combo_pacienteid_Dropdownoptionstype ;
   private String Combo_pacienteid_Titlecontrolidtoreplace ;
   private String Combo_pacienteid_Datalisttype ;
   private String Combo_pacienteid_Datalistfixedvalues ;
   private String Combo_pacienteid_Htmltemplate ;
   private String Combo_pacienteid_Multiplevaluestype ;
   private String Combo_pacienteid_Loadingdata ;
   private String Combo_pacienteid_Noresultsfound ;
   private String Combo_pacienteid_Emptyitemtext ;
   private String Combo_pacienteid_Onlyselectedvalues ;
   private String Combo_pacienteid_Selectalltext ;
   private String Combo_pacienteid_Multiplevaluesseparator ;
   private String Combo_pacienteid_Addnewoptiontext ;
   private String Combo_sgcitadisponibilidadid_Objectcall ;
   private String Combo_sgcitadisponibilidadid_Class ;
   private String Combo_sgcitadisponibilidadid_Icontype ;
   private String Combo_sgcitadisponibilidadid_Icon ;
   private String Combo_sgcitadisponibilidadid_Tooltip ;
   private String Combo_sgcitadisponibilidadid_Selectedvalue_set ;
   private String Combo_sgcitadisponibilidadid_Selectedtext_set ;
   private String Combo_sgcitadisponibilidadid_Selectedtext_get ;
   private String Combo_sgcitadisponibilidadid_Gamoauthtoken ;
   private String Combo_sgcitadisponibilidadid_Ddointernalname ;
   private String Combo_sgcitadisponibilidadid_Titlecontrolalign ;
   private String Combo_sgcitadisponibilidadid_Dropdownoptionstype ;
   private String Combo_sgcitadisponibilidadid_Titlecontrolidtoreplace ;
   private String Combo_sgcitadisponibilidadid_Datalisttype ;
   private String Combo_sgcitadisponibilidadid_Datalistfixedvalues ;
   private String Combo_sgcitadisponibilidadid_Htmltemplate ;
   private String Combo_sgcitadisponibilidadid_Multiplevaluestype ;
   private String Combo_sgcitadisponibilidadid_Loadingdata ;
   private String Combo_sgcitadisponibilidadid_Noresultsfound ;
   private String Combo_sgcitadisponibilidadid_Emptyitemtext ;
   private String Combo_sgcitadisponibilidadid_Onlyselectedvalues ;
   private String Combo_sgcitadisponibilidadid_Selectalltext ;
   private String Combo_sgcitadisponibilidadid_Multiplevaluesseparator ;
   private String Combo_sgcitadisponibilidadid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String edtCitaArchivo_Filename ;
   private String GXCCtlgxBlob ;
   private String hsh ;
   private String sMode17 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z92CitaFechaReserva ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date A92CitaFechaReserva ;
   private java.util.Date Z68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date Z387SGCitaDisponibilidadHoraFin ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date Z66SGCitaDisponibilidadFecha ;
   private boolean Z97CitaConsentimiento ;
   private boolean Z101CitaGestante ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n65CitaTipoDiagnostico ;
   private boolean n89CitaEstadoCita ;
   private boolean n95CitaEstado ;
   private boolean A97CitaConsentimiento ;
   private boolean n97CitaConsentimiento ;
   private boolean A101CitaGestante ;
   private boolean n101CitaGestante ;
   private boolean n102CitaEstadoPago ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_pacienteid_Emptyitem ;
   private boolean Combo_sgcitadisponibilidadid_Emptyitem ;
   private boolean n98CitaArchivo ;
   private boolean n91CitaLink ;
   private boolean n92CitaFechaReserva ;
   private boolean n93CitaLog ;
   private boolean n94CitaEmailGenLink ;
   private boolean n96CitaArchivoNombre ;
   private boolean n333CitaArchivoExtencion ;
   private boolean n306CitaPeso ;
   private boolean n307CitaEstatura ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean Combo_pacienteid_Enabled ;
   private boolean Combo_pacienteid_Visible ;
   private boolean Combo_pacienteid_Allowmultipleselection ;
   private boolean Combo_pacienteid_Isgriditem ;
   private boolean Combo_pacienteid_Hasdescription ;
   private boolean Combo_pacienteid_Includeonlyselectedoption ;
   private boolean Combo_pacienteid_Includeselectalloption ;
   private boolean Combo_pacienteid_Includeaddnewoption ;
   private boolean Combo_sgcitadisponibilidadid_Enabled ;
   private boolean Combo_sgcitadisponibilidadid_Visible ;
   private boolean Combo_sgcitadisponibilidadid_Allowmultipleselection ;
   private boolean Combo_sgcitadisponibilidadid_Isgriditem ;
   private boolean Combo_sgcitadisponibilidadid_Hasdescription ;
   private boolean Combo_sgcitadisponibilidadid_Includeonlyselectedoption ;
   private boolean Combo_sgcitadisponibilidadid_Includeselectalloption ;
   private boolean Combo_sgcitadisponibilidadid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n19CitaId ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n90CitaInforme ;
   private boolean n100CitaAntecedentes ;
   private boolean n99CitaMotivoConsulta ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String A90CitaInforme ;
   private String A100CitaAntecedentes ;
   private String A99CitaMotivoConsulta ;
   private String AV21Combo_DataJson ;
   private String Z90CitaInforme ;
   private String Z100CitaAntecedentes ;
   private String Z99CitaMotivoConsulta ;
   private String A98CitaArchivo ;
   private String Z98CitaArchivo ;
   private String Z64CitaCode ;
   private String Z65CitaTipoDiagnostico ;
   private String Z91CitaLink ;
   private String Z93CitaLog ;
   private String Z94CitaEmailGenLink ;
   private String Z96CitaArchivoNombre ;
   private String Z333CitaArchivoExtencion ;
   private String A65CitaTipoDiagnostico ;
   private String A64CitaCode ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A106PacienteNroDocumento ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A87SGCitaDisponibilidadProCOP ;
   private String A91CitaLink ;
   private String A93CitaLog ;
   private String A94CitaEmailGenLink ;
   private String A96CitaArchivoNombre ;
   private String A333CitaArchivoExtencion ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private String Z103PacienteApellidoPaterno ;
   private String Z104PacienteApellidoMaterno ;
   private String Z105PacienteNombres ;
   private String Z106PacienteNroDocumento ;
   private String Z87SGCitaDisponibilidadProCOP ;
   private String Z84ProfesionalNombres ;
   private String Z85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String Z146SGCitaDisponibilidadEspecialidadNombre ;
   private String Z73SGCitaDisponibilidadSedeNombre ;
   private String Z78SGCitaDisponibilidadClinicaNombre ;
   private String Z82SGCitaDisponibilidadProFullName ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_pacienteid ;
   private com.genexus.webpanels.GXUserControl ucCombo_sgcitadisponibilidadid ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbCitaTipoDiagnostico ;
   private HTMLChoice cmbCitaEstadoCita ;
   private HTMLChoice cmbCitaEstado ;
   private ICheckbox chkCitaConsentimiento ;
   private ICheckbox chkCitaGestante ;
   private HTMLChoice cmbCitaEstadoPago ;
   private IDataStoreProvider pr_default ;
   private String[] T000A4_A103PacienteApellidoPaterno ;
   private String[] T000A4_A104PacienteApellidoMaterno ;
   private String[] T000A4_A105PacienteNombres ;
   private String[] T000A4_A106PacienteNroDocumento ;
   private java.util.Date[] T000A5_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000A5_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] T000A5_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] T000A5_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] T000A5_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] T000A5_n387SGCitaDisponibilidadHoraFin ;
   private int[] T000A5_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000A5_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000A5_A72SGCitaDisponibilidadSedeId ;
   private String[] T000A6_A87SGCitaDisponibilidadProCOP ;
   private String[] T000A6_A84ProfesionalNombres ;
   private boolean[] T000A6_n84ProfesionalNombres ;
   private String[] T000A6_A85ProfesionalApellidoPaterno ;
   private boolean[] T000A6_n85ProfesionalApellidoPaterno ;
   private String[] T000A6_A86ProfesionalApellidoMaterno ;
   private boolean[] T000A6_n86ProfesionalApellidoMaterno ;
   private String[] T000A7_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] T000A8_A73SGCitaDisponibilidadSedeNombre ;
   private short[] T000A8_A76SGCitaDisponibilidadClinicaId ;
   private String[] T000A9_A78SGCitaDisponibilidadClinicaNombre ;
   private int[] T000A10_A19CitaId ;
   private boolean[] T000A10_n19CitaId ;
   private String[] T000A10_A64CitaCode ;
   private String[] T000A10_A103PacienteApellidoPaterno ;
   private String[] T000A10_A104PacienteApellidoMaterno ;
   private String[] T000A10_A105PacienteNombres ;
   private String[] T000A10_A106PacienteNroDocumento ;
   private String[] T000A10_A65CitaTipoDiagnostico ;
   private boolean[] T000A10_n65CitaTipoDiagnostico ;
   private java.util.Date[] T000A10_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000A10_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] T000A10_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] T000A10_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] T000A10_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] T000A10_n387SGCitaDisponibilidadHoraFin ;
   private String[] T000A10_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] T000A10_A73SGCitaDisponibilidadSedeNombre ;
   private String[] T000A10_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] T000A10_A87SGCitaDisponibilidadProCOP ;
   private String[] T000A10_A89CitaEstadoCita ;
   private boolean[] T000A10_n89CitaEstadoCita ;
   private String[] T000A10_A90CitaInforme ;
   private boolean[] T000A10_n90CitaInforme ;
   private String[] T000A10_A100CitaAntecedentes ;
   private boolean[] T000A10_n100CitaAntecedentes ;
   private String[] T000A10_A91CitaLink ;
   private boolean[] T000A10_n91CitaLink ;
   private java.util.Date[] T000A10_A92CitaFechaReserva ;
   private boolean[] T000A10_n92CitaFechaReserva ;
   private String[] T000A10_A93CitaLog ;
   private boolean[] T000A10_n93CitaLog ;
   private String[] T000A10_A94CitaEmailGenLink ;
   private boolean[] T000A10_n94CitaEmailGenLink ;
   private String[] T000A10_A95CitaEstado ;
   private boolean[] T000A10_n95CitaEstado ;
   private String[] T000A10_A99CitaMotivoConsulta ;
   private boolean[] T000A10_n99CitaMotivoConsulta ;
   private String[] T000A10_A96CitaArchivoNombre ;
   private boolean[] T000A10_n96CitaArchivoNombre ;
   private String[] T000A10_A98CitaArchivo ;
   private boolean[] T000A10_n98CitaArchivo ;
   private String[] T000A10_A333CitaArchivoExtencion ;
   private boolean[] T000A10_n333CitaArchivoExtencion ;
   private boolean[] T000A10_A97CitaConsentimiento ;
   private boolean[] T000A10_n97CitaConsentimiento ;
   private boolean[] T000A10_A101CitaGestante ;
   private boolean[] T000A10_n101CitaGestante ;
   private String[] T000A10_A102CitaEstadoPago ;
   private boolean[] T000A10_n102CitaEstadoPago ;
   private java.math.BigDecimal[] T000A10_A306CitaPeso ;
   private boolean[] T000A10_n306CitaPeso ;
   private java.math.BigDecimal[] T000A10_A307CitaEstatura ;
   private boolean[] T000A10_n307CitaEstatura ;
   private String[] T000A10_A84ProfesionalNombres ;
   private boolean[] T000A10_n84ProfesionalNombres ;
   private String[] T000A10_A85ProfesionalApellidoPaterno ;
   private boolean[] T000A10_n85ProfesionalApellidoPaterno ;
   private String[] T000A10_A86ProfesionalApellidoMaterno ;
   private boolean[] T000A10_n86ProfesionalApellidoMaterno ;
   private int[] T000A10_A20PacienteId ;
   private int[] T000A10_A21SGCitaDisponibilidadId ;
   private int[] T000A10_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000A10_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000A10_A72SGCitaDisponibilidadSedeId ;
   private short[] T000A10_A76SGCitaDisponibilidadClinicaId ;
   private String[] T000A11_A103PacienteApellidoPaterno ;
   private String[] T000A11_A104PacienteApellidoMaterno ;
   private String[] T000A11_A105PacienteNombres ;
   private String[] T000A11_A106PacienteNroDocumento ;
   private java.util.Date[] T000A12_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000A12_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] T000A12_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] T000A12_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] T000A12_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] T000A12_n387SGCitaDisponibilidadHoraFin ;
   private int[] T000A12_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000A12_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000A12_A72SGCitaDisponibilidadSedeId ;
   private String[] T000A13_A87SGCitaDisponibilidadProCOP ;
   private String[] T000A13_A84ProfesionalNombres ;
   private boolean[] T000A13_n84ProfesionalNombres ;
   private String[] T000A13_A85ProfesionalApellidoPaterno ;
   private boolean[] T000A13_n85ProfesionalApellidoPaterno ;
   private String[] T000A13_A86ProfesionalApellidoMaterno ;
   private boolean[] T000A13_n86ProfesionalApellidoMaterno ;
   private String[] T000A14_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] T000A15_A73SGCitaDisponibilidadSedeNombre ;
   private short[] T000A15_A76SGCitaDisponibilidadClinicaId ;
   private String[] T000A16_A78SGCitaDisponibilidadClinicaNombre ;
   private int[] T000A17_A19CitaId ;
   private boolean[] T000A17_n19CitaId ;
   private int[] T000A3_A19CitaId ;
   private boolean[] T000A3_n19CitaId ;
   private String[] T000A3_A64CitaCode ;
   private String[] T000A3_A65CitaTipoDiagnostico ;
   private boolean[] T000A3_n65CitaTipoDiagnostico ;
   private String[] T000A3_A89CitaEstadoCita ;
   private boolean[] T000A3_n89CitaEstadoCita ;
   private String[] T000A3_A90CitaInforme ;
   private boolean[] T000A3_n90CitaInforme ;
   private String[] T000A3_A100CitaAntecedentes ;
   private boolean[] T000A3_n100CitaAntecedentes ;
   private String[] T000A3_A91CitaLink ;
   private boolean[] T000A3_n91CitaLink ;
   private java.util.Date[] T000A3_A92CitaFechaReserva ;
   private boolean[] T000A3_n92CitaFechaReserva ;
   private String[] T000A3_A93CitaLog ;
   private boolean[] T000A3_n93CitaLog ;
   private String[] T000A3_A94CitaEmailGenLink ;
   private boolean[] T000A3_n94CitaEmailGenLink ;
   private String[] T000A3_A95CitaEstado ;
   private boolean[] T000A3_n95CitaEstado ;
   private String[] T000A3_A99CitaMotivoConsulta ;
   private boolean[] T000A3_n99CitaMotivoConsulta ;
   private String[] T000A3_A96CitaArchivoNombre ;
   private boolean[] T000A3_n96CitaArchivoNombre ;
   private String[] T000A3_A98CitaArchivo ;
   private boolean[] T000A3_n98CitaArchivo ;
   private String[] T000A3_A333CitaArchivoExtencion ;
   private boolean[] T000A3_n333CitaArchivoExtencion ;
   private boolean[] T000A3_A97CitaConsentimiento ;
   private boolean[] T000A3_n97CitaConsentimiento ;
   private boolean[] T000A3_A101CitaGestante ;
   private boolean[] T000A3_n101CitaGestante ;
   private String[] T000A3_A102CitaEstadoPago ;
   private boolean[] T000A3_n102CitaEstadoPago ;
   private java.math.BigDecimal[] T000A3_A306CitaPeso ;
   private boolean[] T000A3_n306CitaPeso ;
   private java.math.BigDecimal[] T000A3_A307CitaEstatura ;
   private boolean[] T000A3_n307CitaEstatura ;
   private int[] T000A3_A20PacienteId ;
   private int[] T000A3_A21SGCitaDisponibilidadId ;
   private int[] T000A18_A19CitaId ;
   private boolean[] T000A18_n19CitaId ;
   private int[] T000A19_A19CitaId ;
   private boolean[] T000A19_n19CitaId ;
   private int[] T000A2_A19CitaId ;
   private boolean[] T000A2_n19CitaId ;
   private String[] T000A2_A64CitaCode ;
   private String[] T000A2_A65CitaTipoDiagnostico ;
   private boolean[] T000A2_n65CitaTipoDiagnostico ;
   private String[] T000A2_A89CitaEstadoCita ;
   private boolean[] T000A2_n89CitaEstadoCita ;
   private String[] T000A2_A90CitaInforme ;
   private boolean[] T000A2_n90CitaInforme ;
   private String[] T000A2_A100CitaAntecedentes ;
   private boolean[] T000A2_n100CitaAntecedentes ;
   private String[] T000A2_A91CitaLink ;
   private boolean[] T000A2_n91CitaLink ;
   private java.util.Date[] T000A2_A92CitaFechaReserva ;
   private boolean[] T000A2_n92CitaFechaReserva ;
   private String[] T000A2_A93CitaLog ;
   private boolean[] T000A2_n93CitaLog ;
   private String[] T000A2_A94CitaEmailGenLink ;
   private boolean[] T000A2_n94CitaEmailGenLink ;
   private String[] T000A2_A95CitaEstado ;
   private boolean[] T000A2_n95CitaEstado ;
   private String[] T000A2_A99CitaMotivoConsulta ;
   private boolean[] T000A2_n99CitaMotivoConsulta ;
   private String[] T000A2_A96CitaArchivoNombre ;
   private boolean[] T000A2_n96CitaArchivoNombre ;
   private String[] T000A2_A98CitaArchivo ;
   private boolean[] T000A2_n98CitaArchivo ;
   private String[] T000A2_A333CitaArchivoExtencion ;
   private boolean[] T000A2_n333CitaArchivoExtencion ;
   private boolean[] T000A2_A97CitaConsentimiento ;
   private boolean[] T000A2_n97CitaConsentimiento ;
   private boolean[] T000A2_A101CitaGestante ;
   private boolean[] T000A2_n101CitaGestante ;
   private String[] T000A2_A102CitaEstadoPago ;
   private boolean[] T000A2_n102CitaEstadoPago ;
   private java.math.BigDecimal[] T000A2_A306CitaPeso ;
   private boolean[] T000A2_n306CitaPeso ;
   private java.math.BigDecimal[] T000A2_A307CitaEstatura ;
   private boolean[] T000A2_n307CitaEstatura ;
   private int[] T000A2_A20PacienteId ;
   private int[] T000A2_A21SGCitaDisponibilidadId ;
   private int[] T000A20_A19CitaId ;
   private boolean[] T000A20_n19CitaId ;
   private String[] T000A24_A103PacienteApellidoPaterno ;
   private String[] T000A24_A104PacienteApellidoMaterno ;
   private String[] T000A24_A105PacienteNombres ;
   private String[] T000A24_A106PacienteNroDocumento ;
   private java.util.Date[] T000A25_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000A25_n66SGCitaDisponibilidadFecha ;
   private java.util.Date[] T000A25_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] T000A25_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] T000A25_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] T000A25_n387SGCitaDisponibilidadHoraFin ;
   private int[] T000A25_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000A25_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000A25_A72SGCitaDisponibilidadSedeId ;
   private String[] T000A26_A87SGCitaDisponibilidadProCOP ;
   private String[] T000A26_A84ProfesionalNombres ;
   private boolean[] T000A26_n84ProfesionalNombres ;
   private String[] T000A26_A85ProfesionalApellidoPaterno ;
   private boolean[] T000A26_n85ProfesionalApellidoPaterno ;
   private String[] T000A26_A86ProfesionalApellidoMaterno ;
   private boolean[] T000A26_n86ProfesionalApellidoMaterno ;
   private String[] T000A27_A146SGCitaDisponibilidadEspecialidadNombre ;
   private String[] T000A28_A73SGCitaDisponibilidadSedeNombre ;
   private short[] T000A28_A76SGCitaDisponibilidadClinicaId ;
   private String[] T000A29_A78SGCitaDisponibilidadClinicaNombre ;
   private short[] T000A30_A50RecetaMedicaId ;
   private int[] T000A31_A47PagoId ;
   private short[] T000A32_A37EncuestaId ;
   private int[] T000A33_A26CitaServicioId ;
   private int[] T000A34_A24CitaRecetaId ;
   private int[] T000A35_A22CitaDiagnosticoId ;
   private int[] T000A36_A19CitaId ;
   private boolean[] T000A36_n19CitaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV17PacienteId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV25SGCitaDisponibilidadId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class cita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000A2", "SELECT [CitaId], [CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WITH (UPDLOCK) WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A3", "SELECT [CitaId], [CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A4", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteNroDocumento] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A5", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, [DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A6", "SELECT [ProfesionalCOP] AS SGCitaDisponibilidadProCOP, [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A7", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A8", "SELECT [SedeNombre] AS SGCitaDisponibilidadSedeNombre, [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A9", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A10", "SELECT TM1.[CitaId], TM1.[CitaCode], T2.[PacienteApellidoPaterno], T2.[PacienteApellidoMaterno], T2.[PacienteNombres], T2.[PacienteNroDocumento], TM1.[CitaTipoDiagnostico], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T5.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T6.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T7.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, T4.[ProfesionalCOP] AS SGCitaDisponibilidadProCOP, TM1.[CitaEstadoCita], TM1.[CitaInforme], TM1.[CitaAntecedentes], TM1.[CitaLink], TM1.[CitaFechaReserva], TM1.[CitaLog], TM1.[CitaEmailGenLink], TM1.[CitaEstado], TM1.[CitaMotivoConsulta], TM1.[CitaArchivoNombre], TM1.[CitaArchivo], TM1.[CitaArchivoExtencion], TM1.[CitaConsentimiento], TM1.[CitaGestante], TM1.[CitaEstadoPago], TM1.[CitaPeso], TM1.[CitaEstatura], T4.[ProfesionalNombres], T4.[ProfesionalApellidoPaterno], T4.[ProfesionalApellidoMaterno], TM1.[PacienteId], TM1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, T6.[ClinicaId] AS SGCitaDisponibilidadClinicaId FROM (((((([Cita] TM1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = TM1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = TM1.[SGCitaDisponibilidadId]) INNER JOIN [Profesional] T4 ON T4.[ProfesionalId] = T3.[ProfesionalId]) INNER JOIN [Especialidad] T5 ON T5.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T6 ON T6.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T7 ON T7.[ClinicaId] = T6.[ClinicaId]) WHERE TM1.[CitaId] = ? ORDER BY TM1.[CitaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A11", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteNroDocumento] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A12", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, [DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A13", "SELECT [ProfesionalCOP] AS SGCitaDisponibilidadProCOP, [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A14", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A15", "SELECT [SedeNombre] AS SGCitaDisponibilidadSedeNombre, [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A16", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A17", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A18", "SELECT TOP 1 [CitaId] FROM [Cita] WHERE ( [CitaId] > ?) ORDER BY [CitaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A19", "SELECT TOP 1 [CitaId] FROM [Cita] WHERE ( [CitaId] < ?) ORDER BY [CitaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A20", "INSERT INTO [Cita]([CitaCode], [CitaTipoDiagnostico], [CitaEstadoCita], [CitaInforme], [CitaAntecedentes], [CitaLink], [CitaFechaReserva], [CitaLog], [CitaEmailGenLink], [CitaEstado], [CitaMotivoConsulta], [CitaArchivoNombre], [CitaArchivo], [CitaArchivoExtencion], [CitaConsentimiento], [CitaGestante], [CitaEstadoPago], [CitaPeso], [CitaEstatura], [PacienteId], [SGCitaDisponibilidadId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000A21", "UPDATE [Cita] SET [CitaCode]=?, [CitaTipoDiagnostico]=?, [CitaEstadoCita]=?, [CitaInforme]=?, [CitaAntecedentes]=?, [CitaLink]=?, [CitaFechaReserva]=?, [CitaLog]=?, [CitaEmailGenLink]=?, [CitaEstado]=?, [CitaMotivoConsulta]=?, [CitaArchivoNombre]=?, [CitaArchivoExtencion]=?, [CitaConsentimiento]=?, [CitaGestante]=?, [CitaEstadoPago]=?, [CitaPeso]=?, [CitaEstatura]=?, [PacienteId]=?, [SGCitaDisponibilidadId]=?  WHERE [CitaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000A22", "UPDATE [Cita] SET [CitaArchivo]=?  WHERE [CitaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000A23", "DELETE FROM [Cita]  WHERE [CitaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000A24", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteNroDocumento] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A25", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio, [DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A26", "SELECT [ProfesionalCOP] AS SGCitaDisponibilidadProCOP, [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A27", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A28", "SELECT [SedeNombre] AS SGCitaDisponibilidadSedeNombre, [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A29", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000A30", "SELECT TOP 1 [RecetaMedicaId] FROM [RecetaMedica] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A31", "SELECT TOP 1 [PagoId] FROM [Pago] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A32", "SELECT TOP 1 [EncuestaId] FROM [Encuesta] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A33", "SELECT TOP 1 [CitaServicioId] FROM [CitaServicio] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A34", "SELECT TOP 1 [CitaRecetaId] FROM [CitaReceta] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A35", "SELECT TOP 1 [CitaDiagnosticoId] FROM [CitaDiagnostico] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000A36", "SELECT [CitaId] FROM [Cita] ORDER BY [CitaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(11, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getBLOBFile(14, "tmp", "");
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((boolean[]) buf[30])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(18, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((int[]) buf[38])[0] = rslt.getInt(21);
               ((int[]) buf[39])[0] = rslt.getInt(22);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDateTime(8);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(11, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getBLOBFile(14, "tmp", "");
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((boolean[]) buf[28])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((boolean[]) buf[30])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(18, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(19,2);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(20,2);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((int[]) buf[38])[0] = rslt.getInt(21);
               ((int[]) buf[39])[0] = rslt.getInt(22);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(2));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[10])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[12])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((String[]) buf[17])[0] = rslt.getVarchar(14);
               ((String[]) buf[18])[0] = rslt.getString(15, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(16);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getLongVarchar(17);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDateTime(19);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(20);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               ((String[]) buf[32])[0] = rslt.getString(22, 1);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
               ((String[]) buf[34])[0] = rslt.getLongVarchar(23);
               ((boolean[]) buf[35])[0] = rslt.wasNull();
               ((String[]) buf[36])[0] = rslt.getVarchar(24);
               ((boolean[]) buf[37])[0] = rslt.wasNull();
               ((String[]) buf[38])[0] = rslt.getBLOBFile(25, "tmp", "");
               ((boolean[]) buf[39])[0] = rslt.wasNull();
               ((String[]) buf[40])[0] = rslt.getVarchar(26);
               ((boolean[]) buf[41])[0] = rslt.wasNull();
               ((boolean[]) buf[42])[0] = rslt.getBoolean(27);
               ((boolean[]) buf[43])[0] = rslt.wasNull();
               ((boolean[]) buf[44])[0] = rslt.getBoolean(28);
               ((boolean[]) buf[45])[0] = rslt.wasNull();
               ((String[]) buf[46])[0] = rslt.getString(29, 1);
               ((boolean[]) buf[47])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[48])[0] = rslt.getBigDecimal(30,2);
               ((boolean[]) buf[49])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[50])[0] = rslt.getBigDecimal(31,2);
               ((boolean[]) buf[51])[0] = rslt.wasNull();
               ((String[]) buf[52])[0] = rslt.getVarchar(32);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(33);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((String[]) buf[56])[0] = rslt.getVarchar(34);
               ((boolean[]) buf[57])[0] = rslt.wasNull();
               ((int[]) buf[58])[0] = rslt.getInt(35);
               ((int[]) buf[59])[0] = rslt.getInt(36);
               ((int[]) buf[60])[0] = rslt.getInt(37);
               ((short[]) buf[61])[0] = rslt.getShort(38);
               ((short[]) buf[62])[0] = rslt.getShort(39);
               ((short[]) buf[63])[0] = rslt.getShort(40);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 10 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(2));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 23 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = GXutil.resetDate(rslt.getGXDateTime(2));
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = GXutil.resetDate(rslt.getGXDateTime(3));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((short[]) buf[8])[0] = rslt.getShort(6);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 18 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 40);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 1);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[6]);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[8]);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[10], 1000);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[12], false);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[14], 2000);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(9, (String)parms[16], 100);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[18], 1);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(11, (String)parms[20]);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[22], 100);
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(13, (String)parms[24]);
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[26], 30);
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(15, ((Boolean) parms[28]).booleanValue());
               }
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(16, ((Boolean) parms[30]).booleanValue());
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(17, (String)parms[32], 1);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(18, (java.math.BigDecimal)parms[34], 2);
               }
               if ( ((Boolean) parms[35]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(19, (java.math.BigDecimal)parms[36], 2);
               }
               stmt.setInt(20, ((Number) parms[37]).intValue());
               stmt.setInt(21, ((Number) parms[38]).intValue());
               return;
            case 19 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 40);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[4], 1);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[6]);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(5, (String)parms[8]);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[10], 1000);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(7, (java.util.Date)parms[12], false);
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[14], 2000);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(9, (String)parms[16], 100);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[18], 1);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(11, (String)parms[20]);
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(12, (String)parms[22], 100);
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(13, (String)parms[24], 30);
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(14, ((Boolean) parms[26]).booleanValue());
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(15, ((Boolean) parms[28]).booleanValue());
               }
               if ( ((Boolean) parms[29]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(16, (String)parms[30], 1);
               }
               if ( ((Boolean) parms[31]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(17, (java.math.BigDecimal)parms[32], 2);
               }
               if ( ((Boolean) parms[33]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(18, (java.math.BigDecimal)parms[34], 2);
               }
               stmt.setInt(19, ((Number) parms[35]).intValue());
               stmt.setInt(20, ((Number) parms[36]).intValue());
               if ( ((Boolean) parms[37]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(21, ((Number) parms[38]).intValue());
               }
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 28 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 29 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 31 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 32 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 33 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
      }
   }

}

