package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pago_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A19CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
         n19CitaId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A19CitaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A21SGCitaDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A21SGCitaDisponibilidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A34DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
         n34DisponibilidadId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A34DisponibilidadId) ;
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
            AV20PagoId = (int)(GXutil.lval( httpContext.GetPar( "PagoId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20PagoId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAGOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20PagoId), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", "Pago", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public pago_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pago_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pago_impl.class ));
   }

   public pago_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPagoTipoDocumentoCliente = new HTMLChoice();
      cmbPagoTipoDocumento = new HTMLChoice();
      cmbPagoMoneda = new HTMLChoice();
      cmbPagoEstadoR = new HTMLChoice();
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
      if ( cmbPagoTipoDocumentoCliente.getItemCount() > 0 )
      {
         A247PagoTipoDocumentoCliente = cmbPagoTipoDocumentoCliente.getValidValue(A247PagoTipoDocumentoCliente) ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoTipoDocumentoCliente.setValue( GXutil.rtrim( A247PagoTipoDocumentoCliente) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumentoCliente.getInternalname(), "Values", cmbPagoTipoDocumentoCliente.ToJavascriptSource(), true);
      }
      if ( cmbPagoTipoDocumento.getItemCount() > 0 )
      {
         A244PagoTipoDocumento = (short)(GXutil.lval( cmbPagoTipoDocumento.getValidValue(GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoTipoDocumento.setValue( GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumento.getInternalname(), "Values", cmbPagoTipoDocumento.ToJavascriptSource(), true);
      }
      if ( cmbPagoMoneda.getItemCount() > 0 )
      {
         A253PagoMoneda = (short)(GXutil.lval( cmbPagoMoneda.getValidValue(GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoMoneda.setValue( GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoMoneda.getInternalname(), "Values", cmbPagoMoneda.ToJavascriptSource(), true);
      }
      if ( cmbPagoEstadoR.getItemCount() > 0 )
      {
         A246PagoEstadoR = cmbPagoEstadoR.getValidValue(A246PagoEstadoR) ;
         httpContext.ajax_rsp_assign_attri("", false, "A246PagoEstadoR", A246PagoEstadoR);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPagoEstadoR.setValue( GXutil.rtrim( A246PagoEstadoR) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPagoEstadoR.getInternalname(), "Values", cmbPagoEstadoR.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoId_Internalname, GXutil.ltrim( localUtil.ntoc( A47PagoId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPagoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedcitaid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcitaid_Internalname, "Cita Id", "", "", lblTextblockcitaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_citaid.setProperty("Caption", Combo_citaid_Caption);
      ucCombo_citaid.setProperty("Cls", Combo_citaid_Cls);
      ucCombo_citaid.setProperty("DataListProc", Combo_citaid_Datalistproc);
      ucCombo_citaid.setProperty("DataListProcParametersPrefix", Combo_citaid_Datalistprocparametersprefix);
      ucCombo_citaid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_citaid.setProperty("DropDownOptionsData", AV14CitaId_Data);
      ucCombo_citaid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_citaid_Internalname, "COMBO_CITAIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaId_Jsonclick, 0, "Attribute", "", "", "", "", edtCitaId_Visible, edtCitaId_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaCode_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaCode_Internalname, "Cita Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaCode_Internalname, A64CitaCode, GXutil.rtrim( localUtil.format( A64CitaCode, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaCode_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadFecha_Internalname, "SGCita Disponibilidad Fecha", "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadFecha_Internalname, localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"), localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadFecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtSGCitaDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoMonto_Internalname, "Monto", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoMonto_Internalname, GXutil.ltrim( localUtil.ntoc( A242PagoMonto, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtPagoMonto_Enabled!=0) ? localUtil.format( A242PagoMonto, "ZZ9.99") : localUtil.format( A242PagoMonto, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoMonto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoMonto_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoToken_Internalname, "Token", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoToken_Internalname, A243PagoToken, GXutil.rtrim( localUtil.format( A243PagoToken, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoToken_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoToken_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoTipoDocumentoCliente.getInternalname(), "Documento Cliente", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoTipoDocumentoCliente, cmbPagoTipoDocumentoCliente.getInternalname(), GXutil.rtrim( A247PagoTipoDocumentoCliente), 1, cmbPagoTipoDocumentoCliente.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPagoTipoDocumentoCliente.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(1), "HLP_Pago.htm");
      cmbPagoTipoDocumentoCliente.setValue( GXutil.rtrim( A247PagoTipoDocumentoCliente) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumentoCliente.getInternalname(), "Values", cmbPagoTipoDocumentoCliente.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteNroDocumento_Internalname, "Nro Documento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteNroDocumento_Internalname, A248PagoClienteNroDocumento, GXutil.rtrim( localUtil.format( A248PagoClienteNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoClienteNroDocumento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoClienteNroDocumento_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteDenominacion_Internalname, "Cliente Denominacion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteDenominacion_Internalname, A249PagoClienteDenominacion, GXutil.rtrim( localUtil.format( A249PagoClienteDenominacion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoClienteDenominacion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoClienteDenominacion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteDireccion_Internalname, "Cliente Direccion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteDireccion_Internalname, A250PagoClienteDireccion, GXutil.rtrim( localUtil.format( A250PagoClienteDireccion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoClienteDireccion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoClienteDireccion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoClienteEmail_Internalname, "Cliente Email", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoClienteEmail_Internalname, A251PagoClienteEmail, GXutil.rtrim( localUtil.format( A251PagoClienteEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A251PagoClienteEmail, "", "", "", edtPagoClienteEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoClienteEmail_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoTipoDocumento.getInternalname(), "Tipo Documento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoTipoDocumento, cmbPagoTipoDocumento.getInternalname(), GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)), 1, cmbPagoTipoDocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPagoTipoDocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "", true, (byte)(1), "HLP_Pago.htm");
      cmbPagoTipoDocumento.setValue( GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumento.getInternalname(), "Values", cmbPagoTipoDocumento.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoNumero_Internalname, "Numero", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A245PagoNumero, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPagoNumero_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A245PagoNumero), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A245PagoNumero), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoNumero_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoNumero_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoFechaEmision_Internalname, "Fecha Emision", "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtPagoFechaEmision_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoFechaEmision_Internalname, localUtil.format(A252PagoFechaEmision, "99/99/9999"), localUtil.format( A252PagoFechaEmision, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,93);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoFechaEmision_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtPagoFechaEmision_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtPagoFechaEmision_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtPagoFechaEmision_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoMoneda.getInternalname(), "Moneda", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoMoneda, cmbPagoMoneda.getInternalname(), GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)), 1, cmbPagoMoneda.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbPagoMoneda.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(1), "HLP_Pago.htm");
      cmbPagoMoneda.setValue( GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoMoneda.getInternalname(), "Values", cmbPagoMoneda.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoNubefactRequest_Internalname, "Nubefact Request", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoNubefactRequest_Internalname, A256PagoNubefactRequest, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", (short)(0), 1, edtPagoNubefactRequest_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoNubefactResponse_Internalname, "Nubefact Response", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoNubefactResponse_Internalname, A257PagoNubefactResponse, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,108);\"", (short)(0), 1, edtPagoNubefactResponse_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoRequest_Internalname, "Request", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoRequest_Internalname, A308PagoRequest, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,113);\"", (short)(0), 1, edtPagoRequest_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoResponse_Internalname, "Response", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPagoResponse_Internalname, A309PagoResponse, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", (short)(0), 1, edtPagoResponse_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoPasarelaId_Internalname, "Pasarela Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 123,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoPasarelaId_Internalname, A310PagoPasarelaId, GXutil.rtrim( localUtil.format( A310PagoPasarelaId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,123);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoPasarelaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoPasarelaId_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoStatusCode_Internalname, "Status Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoStatusCode_Internalname, GXutil.ltrim( localUtil.ntoc( A311PagoStatusCode, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPagoStatusCode_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A311PagoStatusCode), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A311PagoStatusCode), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,128);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPagoStatusCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoStatusCode_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplitteddisponibilidadid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockdisponibilidadid_Internalname, "Disponibilidad Id", "", "", lblTextblockdisponibilidadid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_disponibilidadid.setProperty("Caption", Combo_disponibilidadid_Caption);
      ucCombo_disponibilidadid.setProperty("Cls", Combo_disponibilidadid_Cls);
      ucCombo_disponibilidadid.setProperty("DataListProc", Combo_disponibilidadid_Datalistproc);
      ucCombo_disponibilidadid.setProperty("DataListProcParametersPrefix", Combo_disponibilidadid_Datalistprocparametersprefix);
      ucCombo_disponibilidadid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_disponibilidadid.setProperty("DropDownOptionsData", AV22DisponibilidadId_Data);
      ucCombo_disponibilidadid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_disponibilidadid_Internalname, "COMBO_DISPONIBILIDADIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadId_Internalname, "Disponibilidad Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 139,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,139);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadId_Jsonclick, 0, "Attribute", "", "", "", "", edtDisponibilidadId_Visible, edtDisponibilidadId_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPagoEnlacePDF_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoEnlacePDF_Internalname, "Enlace PDF", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 144,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoEnlacePDF_Internalname, A338PagoEnlacePDF, GXutil.rtrim( localUtil.format( A338PagoEnlacePDF, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,144);\"", "'"+""+"'"+",false,"+"'"+""+"'", A338PagoEnlacePDF, "_blank", "", "", edtPagoEnlacePDF_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoEnlacePDF_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPagoEnlaceXML_Internalname, "Enlace XML", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 149,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPagoEnlaceXML_Internalname, A339PagoEnlaceXML, GXutil.rtrim( localUtil.format( A339PagoEnlaceXML, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,149);\"", "'"+""+"'"+",false,"+"'"+""+"'", A339PagoEnlaceXML, "_blank", "", "", edtPagoEnlaceXML_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPagoEnlaceXML_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPagoEstadoR.getInternalname(), "Estado R", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 154,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPagoEstadoR, cmbPagoEstadoR.getInternalname(), GXutil.rtrim( A246PagoEstadoR), 1, cmbPagoEstadoR.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPagoEstadoR.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,154);\"", "", true, (byte)(1), "HLP_Pago.htm");
      cmbPagoEstadoR.setValue( GXutil.rtrim( A246PagoEstadoR) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoEstadoR.getInternalname(), "Values", cmbPagoEstadoR.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 161,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 163,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Pago.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_citaid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombocitaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboCitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombocitaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboCitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboCitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocitaid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocitaid_Visible, edtavCombocitaid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pago.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_disponibilidadid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombodisponibilidadid_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboDisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombodisponibilidadid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboDisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboDisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombodisponibilidadid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombodisponibilidadid_Visible, edtavCombodisponibilidadid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Pago.htm");
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
      e110T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCITAID_DATA"), AV14CitaId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDISPONIBILIDADID_DATA"), AV22DisponibilidadId_Data);
            /* Read saved values. */
            Z47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( "Z47PagoId"), ",", ".")) ;
            Z242PagoMonto = localUtil.ctond( httpContext.cgiGet( "Z242PagoMonto")) ;
            Z243PagoToken = httpContext.cgiGet( "Z243PagoToken") ;
            Z247PagoTipoDocumentoCliente = httpContext.cgiGet( "Z247PagoTipoDocumentoCliente") ;
            Z248PagoClienteNroDocumento = httpContext.cgiGet( "Z248PagoClienteNroDocumento") ;
            Z249PagoClienteDenominacion = httpContext.cgiGet( "Z249PagoClienteDenominacion") ;
            Z250PagoClienteDireccion = httpContext.cgiGet( "Z250PagoClienteDireccion") ;
            Z251PagoClienteEmail = httpContext.cgiGet( "Z251PagoClienteEmail") ;
            Z244PagoTipoDocumento = (short)(localUtil.ctol( httpContext.cgiGet( "Z244PagoTipoDocumento"), ",", ".")) ;
            Z245PagoNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z245PagoNumero"), ",", ".")) ;
            Z252PagoFechaEmision = localUtil.ctod( httpContext.cgiGet( "Z252PagoFechaEmision"), 0) ;
            Z253PagoMoneda = (short)(localUtil.ctol( httpContext.cgiGet( "Z253PagoMoneda"), ",", ".")) ;
            Z310PagoPasarelaId = httpContext.cgiGet( "Z310PagoPasarelaId") ;
            Z311PagoStatusCode = (int)(localUtil.ctol( httpContext.cgiGet( "Z311PagoStatusCode"), ",", ".")) ;
            Z338PagoEnlacePDF = httpContext.cgiGet( "Z338PagoEnlacePDF") ;
            Z339PagoEnlaceXML = httpContext.cgiGet( "Z339PagoEnlaceXML") ;
            Z246PagoEstadoR = httpContext.cgiGet( "Z246PagoEstadoR") ;
            Z34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "Z34DisponibilidadId"), ",", ".")) ;
            n34DisponibilidadId = ((0==A34DisponibilidadId) ? true : false) ;
            Z19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z19CitaId"), ",", ".")) ;
            n19CitaId = ((0==A19CitaId) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "N19CitaId"), ",", ".")) ;
            n19CitaId = ((0==A19CitaId) ? true : false) ;
            N34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "N34DisponibilidadId"), ",", ".")) ;
            n34DisponibilidadId = ((0==A34DisponibilidadId) ? true : false) ;
            AV20PagoId = (int)(localUtil.ctol( httpContext.cgiGet( "vPAGOID"), ",", ".")) ;
            AV10Insert_CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CITAID"), ",", ".")) ;
            AV21Insert_DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_DISPONIBILIDADID"), ",", ".")) ;
            A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "SGCITADISPONIBILIDADID"), ",", ".")) ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_citaid_Objectcall = httpContext.cgiGet( "COMBO_CITAID_Objectcall") ;
            Combo_citaid_Class = httpContext.cgiGet( "COMBO_CITAID_Class") ;
            Combo_citaid_Icontype = httpContext.cgiGet( "COMBO_CITAID_Icontype") ;
            Combo_citaid_Icon = httpContext.cgiGet( "COMBO_CITAID_Icon") ;
            Combo_citaid_Caption = httpContext.cgiGet( "COMBO_CITAID_Caption") ;
            Combo_citaid_Tooltip = httpContext.cgiGet( "COMBO_CITAID_Tooltip") ;
            Combo_citaid_Cls = httpContext.cgiGet( "COMBO_CITAID_Cls") ;
            Combo_citaid_Selectedvalue_set = httpContext.cgiGet( "COMBO_CITAID_Selectedvalue_set") ;
            Combo_citaid_Selectedvalue_get = httpContext.cgiGet( "COMBO_CITAID_Selectedvalue_get") ;
            Combo_citaid_Selectedtext_set = httpContext.cgiGet( "COMBO_CITAID_Selectedtext_set") ;
            Combo_citaid_Selectedtext_get = httpContext.cgiGet( "COMBO_CITAID_Selectedtext_get") ;
            Combo_citaid_Gamoauthtoken = httpContext.cgiGet( "COMBO_CITAID_Gamoauthtoken") ;
            Combo_citaid_Ddointernalname = httpContext.cgiGet( "COMBO_CITAID_Ddointernalname") ;
            Combo_citaid_Titlecontrolalign = httpContext.cgiGet( "COMBO_CITAID_Titlecontrolalign") ;
            Combo_citaid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CITAID_Dropdownoptionstype") ;
            Combo_citaid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Enabled")) ;
            Combo_citaid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Visible")) ;
            Combo_citaid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CITAID_Titlecontrolidtoreplace") ;
            Combo_citaid_Datalisttype = httpContext.cgiGet( "COMBO_CITAID_Datalisttype") ;
            Combo_citaid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Allowmultipleselection")) ;
            Combo_citaid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CITAID_Datalistfixedvalues") ;
            Combo_citaid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Isgriditem")) ;
            Combo_citaid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Hasdescription")) ;
            Combo_citaid_Datalistproc = httpContext.cgiGet( "COMBO_CITAID_Datalistproc") ;
            Combo_citaid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CITAID_Datalistprocparametersprefix") ;
            Combo_citaid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CITAID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_citaid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Includeonlyselectedoption")) ;
            Combo_citaid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Includeselectalloption")) ;
            Combo_citaid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Emptyitem")) ;
            Combo_citaid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Includeaddnewoption")) ;
            Combo_citaid_Htmltemplate = httpContext.cgiGet( "COMBO_CITAID_Htmltemplate") ;
            Combo_citaid_Multiplevaluestype = httpContext.cgiGet( "COMBO_CITAID_Multiplevaluestype") ;
            Combo_citaid_Loadingdata = httpContext.cgiGet( "COMBO_CITAID_Loadingdata") ;
            Combo_citaid_Noresultsfound = httpContext.cgiGet( "COMBO_CITAID_Noresultsfound") ;
            Combo_citaid_Emptyitemtext = httpContext.cgiGet( "COMBO_CITAID_Emptyitemtext") ;
            Combo_citaid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CITAID_Onlyselectedvalues") ;
            Combo_citaid_Selectalltext = httpContext.cgiGet( "COMBO_CITAID_Selectalltext") ;
            Combo_citaid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CITAID_Multiplevaluesseparator") ;
            Combo_citaid_Addnewoptiontext = httpContext.cgiGet( "COMBO_CITAID_Addnewoptiontext") ;
            Combo_disponibilidadid_Objectcall = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Objectcall") ;
            Combo_disponibilidadid_Class = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Class") ;
            Combo_disponibilidadid_Icontype = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Icontype") ;
            Combo_disponibilidadid_Icon = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Icon") ;
            Combo_disponibilidadid_Caption = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Caption") ;
            Combo_disponibilidadid_Tooltip = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Tooltip") ;
            Combo_disponibilidadid_Cls = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Cls") ;
            Combo_disponibilidadid_Selectedvalue_set = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Selectedvalue_set") ;
            Combo_disponibilidadid_Selectedvalue_get = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Selectedvalue_get") ;
            Combo_disponibilidadid_Selectedtext_set = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Selectedtext_set") ;
            Combo_disponibilidadid_Selectedtext_get = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Selectedtext_get") ;
            Combo_disponibilidadid_Gamoauthtoken = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Gamoauthtoken") ;
            Combo_disponibilidadid_Ddointernalname = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Ddointernalname") ;
            Combo_disponibilidadid_Titlecontrolalign = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Titlecontrolalign") ;
            Combo_disponibilidadid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Dropdownoptionstype") ;
            Combo_disponibilidadid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Enabled")) ;
            Combo_disponibilidadid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Visible")) ;
            Combo_disponibilidadid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Titlecontrolidtoreplace") ;
            Combo_disponibilidadid_Datalisttype = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Datalisttype") ;
            Combo_disponibilidadid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Allowmultipleselection")) ;
            Combo_disponibilidadid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Datalistfixedvalues") ;
            Combo_disponibilidadid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Isgriditem")) ;
            Combo_disponibilidadid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Hasdescription")) ;
            Combo_disponibilidadid_Datalistproc = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Datalistproc") ;
            Combo_disponibilidadid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Datalistprocparametersprefix") ;
            Combo_disponibilidadid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_disponibilidadid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Includeonlyselectedoption")) ;
            Combo_disponibilidadid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Includeselectalloption")) ;
            Combo_disponibilidadid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Emptyitem")) ;
            Combo_disponibilidadid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Includeaddnewoption")) ;
            Combo_disponibilidadid_Htmltemplate = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Htmltemplate") ;
            Combo_disponibilidadid_Multiplevaluestype = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Multiplevaluestype") ;
            Combo_disponibilidadid_Loadingdata = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Loadingdata") ;
            Combo_disponibilidadid_Noresultsfound = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Noresultsfound") ;
            Combo_disponibilidadid_Emptyitemtext = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Emptyitemtext") ;
            Combo_disponibilidadid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Onlyselectedvalues") ;
            Combo_disponibilidadid_Selectalltext = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Selectalltext") ;
            Combo_disponibilidadid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Multiplevaluesseparator") ;
            Combo_disponibilidadid_Addnewoptiontext = httpContext.cgiGet( "COMBO_DISPONIBILIDADID_Addnewoptiontext") ;
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
            /* Read variables values. */
            A47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A19CitaId = 0 ;
               n19CitaId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            }
            else
            {
               A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
               n19CitaId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            }
            n19CitaId = ((0==A19CitaId) ? true : false) ;
            A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
            A66SGCitaDisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 3) ;
            n66SGCitaDisponibilidadFecha = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPagoMonto_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPagoMonto_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAGOMONTO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPagoMonto_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A242PagoMonto = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A242PagoMonto", GXutil.ltrimstr( A242PagoMonto, 6, 2));
            }
            else
            {
               A242PagoMonto = localUtil.ctond( httpContext.cgiGet( edtPagoMonto_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A242PagoMonto", GXutil.ltrimstr( A242PagoMonto, 6, 2));
            }
            A243PagoToken = httpContext.cgiGet( edtPagoToken_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A243PagoToken", A243PagoToken);
            cmbPagoTipoDocumentoCliente.setValue( httpContext.cgiGet( cmbPagoTipoDocumentoCliente.getInternalname()) );
            A247PagoTipoDocumentoCliente = httpContext.cgiGet( cmbPagoTipoDocumentoCliente.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
            A248PagoClienteNroDocumento = httpContext.cgiGet( edtPagoClienteNroDocumento_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A248PagoClienteNroDocumento", A248PagoClienteNroDocumento);
            A249PagoClienteDenominacion = httpContext.cgiGet( edtPagoClienteDenominacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A249PagoClienteDenominacion", A249PagoClienteDenominacion);
            A250PagoClienteDireccion = httpContext.cgiGet( edtPagoClienteDireccion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A250PagoClienteDireccion", A250PagoClienteDireccion);
            A251PagoClienteEmail = httpContext.cgiGet( edtPagoClienteEmail_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A251PagoClienteEmail", A251PagoClienteEmail);
            cmbPagoTipoDocumento.setValue( httpContext.cgiGet( cmbPagoTipoDocumento.getInternalname()) );
            A244PagoTipoDocumento = (short)(GXutil.lval( httpContext.cgiGet( cmbPagoTipoDocumento.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPagoNumero_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPagoNumero_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAGONUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPagoNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A245PagoNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A245PagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A245PagoNumero), 8, 0));
            }
            else
            {
               A245PagoNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoNumero_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A245PagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A245PagoNumero), 8, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtPagoFechaEmision_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "PAGOFECHAEMISION");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPagoFechaEmision_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A252PagoFechaEmision = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A252PagoFechaEmision", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
            }
            else
            {
               A252PagoFechaEmision = localUtil.ctod( httpContext.cgiGet( edtPagoFechaEmision_Internalname), 3) ;
               httpContext.ajax_rsp_assign_attri("", false, "A252PagoFechaEmision", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
            }
            cmbPagoMoneda.setValue( httpContext.cgiGet( cmbPagoMoneda.getInternalname()) );
            A253PagoMoneda = (short)(GXutil.lval( httpContext.cgiGet( cmbPagoMoneda.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
            A256PagoNubefactRequest = httpContext.cgiGet( edtPagoNubefactRequest_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A256PagoNubefactRequest", A256PagoNubefactRequest);
            A257PagoNubefactResponse = httpContext.cgiGet( edtPagoNubefactResponse_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A257PagoNubefactResponse", A257PagoNubefactResponse);
            A308PagoRequest = httpContext.cgiGet( edtPagoRequest_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A308PagoRequest", A308PagoRequest);
            A309PagoResponse = httpContext.cgiGet( edtPagoResponse_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A309PagoResponse", A309PagoResponse);
            A310PagoPasarelaId = httpContext.cgiGet( edtPagoPasarelaId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A310PagoPasarelaId", A310PagoPasarelaId);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPagoStatusCode_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPagoStatusCode_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAGOSTATUSCODE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPagoStatusCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A311PagoStatusCode = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A311PagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311PagoStatusCode), 8, 0));
            }
            else
            {
               A311PagoStatusCode = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoStatusCode_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A311PagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311PagoStatusCode), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "DISPONIBILIDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDisponibilidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A34DisponibilidadId = 0 ;
               n34DisponibilidadId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            }
            else
            {
               A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".")) ;
               n34DisponibilidadId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            }
            n34DisponibilidadId = ((0==A34DisponibilidadId) ? true : false) ;
            A338PagoEnlacePDF = httpContext.cgiGet( edtPagoEnlacePDF_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A338PagoEnlacePDF", A338PagoEnlacePDF);
            A339PagoEnlaceXML = httpContext.cgiGet( edtPagoEnlaceXML_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A339PagoEnlaceXML", A339PagoEnlaceXML);
            cmbPagoEstadoR.setValue( httpContext.cgiGet( cmbPagoEstadoR.getInternalname()) );
            A246PagoEstadoR = httpContext.cgiGet( cmbPagoEstadoR.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A246PagoEstadoR", A246PagoEstadoR);
            AV19ComboCitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombocitaid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
            AV23ComboDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombodisponibilidadid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboDisponibilidadId), 8, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Pago");
            A47PagoId = (int)(localUtil.ctol( httpContext.cgiGet( edtPagoId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
            forbiddenHiddens.add("PagoId", localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A47PagoId != Z47PagoId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("pago:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A47PagoId = (int)(GXutil.lval( httpContext.GetPar( "PagoId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
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
                  sMode38 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode38 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound38 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0T0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PAGOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPagoId_Internalname ;
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
                        e110T2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120T2 ();
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
         e120T2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0T38( ) ;
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
         disableAttributes0T38( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombodisponibilidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombodisponibilidadid_Enabled), 5, 0), true);
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

   public void confirm_0T0( )
   {
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0T38( ) ;
         }
         else
         {
            checkExtendedTable0T38( ) ;
            closeExtendedTableCursors0T38( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0T0( )
   {
   }

   public void e110T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtDisponibilidadId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Visible), 5, 0), true);
      AV23ComboDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboDisponibilidadId), 8, 0));
      edtavCombodisponibilidadid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombodisponibilidadid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombodisponibilidadid_Visible), 5, 0), true);
      edtCitaId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Visible), 5, 0), true);
      AV19ComboCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
      edtavCombocitaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCITAID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBODISPONIBILIDADID' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV7IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7IsAuthorized", AV7IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV7IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Insert", GXv_boolean5) ;
         pago_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV7IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7IsAuthorized", AV7IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV7IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Update", GXv_boolean5) ;
         pago_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV7IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7IsAuthorized", AV7IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV7IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPago_Delete", GXv_boolean5) ;
         pago_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV7IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7IsAuthorized", AV7IsAuthorized);
      }
      if ( ! AV7IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV8TrnContext.fromxml(AV9WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV8TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV24Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV25GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GXV1), 8, 0));
         while ( AV25GXV1 <= AV8TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV11TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV8TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV25GXV1));
            if ( GXutil.strcmp(AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CitaId") == 0 )
            {
               AV10Insert_CitaId = (int)(GXutil.lval( AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10Insert_CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10Insert_CitaId), 8, 0));
               if ( ! (0==AV10Insert_CitaId) )
               {
                  AV19ComboCitaId = AV10Insert_CitaId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
                  Combo_citaid_Selectedvalue_set = GXutil.trim( GXutil.str( AV19ComboCitaId, 8, 0)) ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedValue_set", Combo_citaid_Selectedvalue_set);
                  GXt_char6 = AV18Combo_DataJson ;
                  GXv_char7[0] = AV16ComboSelectedValue ;
                  GXv_char8[0] = AV17ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.pagoloaddvcombo(remoteHandle, context).execute( "CitaId", "GET", false, AV20PagoId, AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  pago_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
                  pago_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
                  pago_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
                  AV18Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
                  Combo_citaid_Selectedtext_set = AV17ComboSelectedText ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedText_set", Combo_citaid_Selectedtext_set);
                  Combo_citaid_Enabled = false ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "Enabled", GXutil.booltostr( Combo_citaid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "DisponibilidadId") == 0 )
            {
               AV21Insert_DisponibilidadId = (int)(GXutil.lval( AV11TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21Insert_DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21Insert_DisponibilidadId), 8, 0));
               if ( ! (0==AV21Insert_DisponibilidadId) )
               {
                  AV23ComboDisponibilidadId = AV21Insert_DisponibilidadId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboDisponibilidadId), 8, 0));
                  Combo_disponibilidadid_Selectedvalue_set = GXutil.trim( GXutil.str( AV23ComboDisponibilidadId, 8, 0)) ;
                  ucCombo_disponibilidadid.sendProperty(context, "", false, Combo_disponibilidadid_Internalname, "SelectedValue_set", Combo_disponibilidadid_Selectedvalue_set);
                  Combo_disponibilidadid_Enabled = false ;
                  ucCombo_disponibilidadid.sendProperty(context, "", false, Combo_disponibilidadid_Internalname, "Enabled", GXutil.booltostr( Combo_disponibilidadid_Enabled));
               }
            }
            AV25GXV1 = (int)(AV25GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GXV1), 8, 0));
         }
      }
   }

   public void e120T2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV8TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.pagoww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'LOADCOMBODISPONIBILIDADID' Routine */
      returnInSub = false ;
      GXt_char6 = AV18Combo_DataJson ;
      GXv_char9[0] = AV16ComboSelectedValue ;
      GXv_char8[0] = AV17ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.pagoloaddvcombo(remoteHandle, context).execute( "DisponibilidadId", Gx_mode, false, AV20PagoId, "", GXv_char9, GXv_char8, GXv_char7) ;
      pago_impl.this.AV16ComboSelectedValue = GXv_char9[0] ;
      pago_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
      pago_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
      AV18Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
      Combo_disponibilidadid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_disponibilidadid.sendProperty(context, "", false, Combo_disponibilidadid_Internalname, "SelectedValue_set", Combo_disponibilidadid_Selectedvalue_set);
      Combo_disponibilidadid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_disponibilidadid.sendProperty(context, "", false, Combo_disponibilidadid_Internalname, "SelectedText_set", Combo_disponibilidadid_Selectedtext_set);
      AV23ComboDisponibilidadId = (int)(GXutil.lval( AV16ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboDisponibilidadId), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_disponibilidadid_Enabled = false ;
         ucCombo_disponibilidadid.sendProperty(context, "", false, Combo_disponibilidadid_Internalname, "Enabled", GXutil.booltostr( Combo_disponibilidadid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCITAID' Routine */
      returnInSub = false ;
      GXt_char6 = AV18Combo_DataJson ;
      GXv_char9[0] = AV16ComboSelectedValue ;
      GXv_char8[0] = AV17ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.pagoloaddvcombo(remoteHandle, context).execute( "CitaId", Gx_mode, false, AV20PagoId, "", GXv_char9, GXv_char8, GXv_char7) ;
      pago_impl.this.AV16ComboSelectedValue = GXv_char9[0] ;
      pago_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
      pago_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
      AV18Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
      Combo_citaid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedValue_set", Combo_citaid_Selectedvalue_set);
      Combo_citaid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedText_set", Combo_citaid_Selectedtext_set);
      AV19ComboCitaId = (int)(GXutil.lval( AV16ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_citaid_Enabled = false ;
         ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "Enabled", GXutil.booltostr( Combo_citaid_Enabled));
      }
   }

   public void zm0T38( int GX_JID )
   {
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z242PagoMonto = T000T3_A242PagoMonto[0] ;
            Z243PagoToken = T000T3_A243PagoToken[0] ;
            Z247PagoTipoDocumentoCliente = T000T3_A247PagoTipoDocumentoCliente[0] ;
            Z248PagoClienteNroDocumento = T000T3_A248PagoClienteNroDocumento[0] ;
            Z249PagoClienteDenominacion = T000T3_A249PagoClienteDenominacion[0] ;
            Z250PagoClienteDireccion = T000T3_A250PagoClienteDireccion[0] ;
            Z251PagoClienteEmail = T000T3_A251PagoClienteEmail[0] ;
            Z244PagoTipoDocumento = T000T3_A244PagoTipoDocumento[0] ;
            Z245PagoNumero = T000T3_A245PagoNumero[0] ;
            Z252PagoFechaEmision = T000T3_A252PagoFechaEmision[0] ;
            Z253PagoMoneda = T000T3_A253PagoMoneda[0] ;
            Z310PagoPasarelaId = T000T3_A310PagoPasarelaId[0] ;
            Z311PagoStatusCode = T000T3_A311PagoStatusCode[0] ;
            Z338PagoEnlacePDF = T000T3_A338PagoEnlacePDF[0] ;
            Z339PagoEnlaceXML = T000T3_A339PagoEnlaceXML[0] ;
            Z246PagoEstadoR = T000T3_A246PagoEstadoR[0] ;
            Z34DisponibilidadId = T000T3_A34DisponibilidadId[0] ;
            Z19CitaId = T000T3_A19CitaId[0] ;
         }
         else
         {
            Z242PagoMonto = A242PagoMonto ;
            Z243PagoToken = A243PagoToken ;
            Z247PagoTipoDocumentoCliente = A247PagoTipoDocumentoCliente ;
            Z248PagoClienteNroDocumento = A248PagoClienteNroDocumento ;
            Z249PagoClienteDenominacion = A249PagoClienteDenominacion ;
            Z250PagoClienteDireccion = A250PagoClienteDireccion ;
            Z251PagoClienteEmail = A251PagoClienteEmail ;
            Z244PagoTipoDocumento = A244PagoTipoDocumento ;
            Z245PagoNumero = A245PagoNumero ;
            Z252PagoFechaEmision = A252PagoFechaEmision ;
            Z253PagoMoneda = A253PagoMoneda ;
            Z310PagoPasarelaId = A310PagoPasarelaId ;
            Z311PagoStatusCode = A311PagoStatusCode ;
            Z338PagoEnlacePDF = A338PagoEnlacePDF ;
            Z339PagoEnlaceXML = A339PagoEnlaceXML ;
            Z246PagoEstadoR = A246PagoEstadoR ;
            Z34DisponibilidadId = A34DisponibilidadId ;
            Z19CitaId = A19CitaId ;
         }
      }
      if ( GX_JID == -19 )
      {
         Z47PagoId = A47PagoId ;
         Z242PagoMonto = A242PagoMonto ;
         Z243PagoToken = A243PagoToken ;
         Z247PagoTipoDocumentoCliente = A247PagoTipoDocumentoCliente ;
         Z248PagoClienteNroDocumento = A248PagoClienteNroDocumento ;
         Z249PagoClienteDenominacion = A249PagoClienteDenominacion ;
         Z250PagoClienteDireccion = A250PagoClienteDireccion ;
         Z251PagoClienteEmail = A251PagoClienteEmail ;
         Z244PagoTipoDocumento = A244PagoTipoDocumento ;
         Z245PagoNumero = A245PagoNumero ;
         Z252PagoFechaEmision = A252PagoFechaEmision ;
         Z253PagoMoneda = A253PagoMoneda ;
         Z256PagoNubefactRequest = A256PagoNubefactRequest ;
         Z257PagoNubefactResponse = A257PagoNubefactResponse ;
         Z308PagoRequest = A308PagoRequest ;
         Z309PagoResponse = A309PagoResponse ;
         Z310PagoPasarelaId = A310PagoPasarelaId ;
         Z311PagoStatusCode = A311PagoStatusCode ;
         Z338PagoEnlacePDF = A338PagoEnlacePDF ;
         Z339PagoEnlaceXML = A339PagoEnlaceXML ;
         Z246PagoEstadoR = A246PagoEstadoR ;
         Z34DisponibilidadId = A34DisponibilidadId ;
         Z19CitaId = A19CitaId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z64CitaCode = A64CitaCode ;
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
      }
   }

   public void standaloneNotModal( )
   {
      edtPagoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoId_Enabled), 5, 0), true);
      edtPagoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV20PagoId) )
      {
         A47PagoId = AV20PagoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV10Insert_CitaId) )
      {
         edtCitaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      }
      else
      {
         edtCitaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV21Insert_DisponibilidadId) )
      {
         edtDisponibilidadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Enabled), 5, 0), true);
      }
      else
      {
         edtDisponibilidadId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV10Insert_CitaId) )
      {
         A19CitaId = AV10Insert_CitaId ;
         n19CitaId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      else
      {
         if ( (0==AV19ComboCitaId) )
         {
            A19CitaId = 0 ;
            n19CitaId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            n19CitaId = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         }
         else
         {
            if ( ! (0==AV19ComboCitaId) )
            {
               A19CitaId = AV19ComboCitaId ;
               n19CitaId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV21Insert_DisponibilidadId) )
      {
         A34DisponibilidadId = AV21Insert_DisponibilidadId ;
         n34DisponibilidadId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      }
      else
      {
         if ( (0==AV23ComboDisponibilidadId) )
         {
            A34DisponibilidadId = 0 ;
            n34DisponibilidadId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            n34DisponibilidadId = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         }
         else
         {
            if ( ! (0==AV23ComboDisponibilidadId) )
            {
               A34DisponibilidadId = AV23ComboDisponibilidadId ;
               n34DisponibilidadId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            }
         }
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
         AV24Pgmname = "Pago" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         /* Using cursor T000T5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         A21SGCitaDisponibilidadId = T000T5_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = T000T5_A64CitaCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
         pr_default.close(3);
         /* Using cursor T000T6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A66SGCitaDisponibilidadFecha = T000T6_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000T6_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         pr_default.close(4);
      }
   }

   public void load0T38( )
   {
      /* Using cursor T000T7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A21SGCitaDisponibilidadId = T000T7_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = T000T7_A64CitaCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
         A66SGCitaDisponibilidadFecha = T000T7_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000T7_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A242PagoMonto = T000T7_A242PagoMonto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A242PagoMonto", GXutil.ltrimstr( A242PagoMonto, 6, 2));
         A243PagoToken = T000T7_A243PagoToken[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A243PagoToken", A243PagoToken);
         A247PagoTipoDocumentoCliente = T000T7_A247PagoTipoDocumentoCliente[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
         A248PagoClienteNroDocumento = T000T7_A248PagoClienteNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PagoClienteNroDocumento", A248PagoClienteNroDocumento);
         A249PagoClienteDenominacion = T000T7_A249PagoClienteDenominacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A249PagoClienteDenominacion", A249PagoClienteDenominacion);
         A250PagoClienteDireccion = T000T7_A250PagoClienteDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PagoClienteDireccion", A250PagoClienteDireccion);
         A251PagoClienteEmail = T000T7_A251PagoClienteEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A251PagoClienteEmail", A251PagoClienteEmail);
         A244PagoTipoDocumento = T000T7_A244PagoTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
         A245PagoNumero = T000T7_A245PagoNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A245PagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A245PagoNumero), 8, 0));
         A252PagoFechaEmision = T000T7_A252PagoFechaEmision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A252PagoFechaEmision", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
         A253PagoMoneda = T000T7_A253PagoMoneda[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
         A256PagoNubefactRequest = T000T7_A256PagoNubefactRequest[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A256PagoNubefactRequest", A256PagoNubefactRequest);
         A257PagoNubefactResponse = T000T7_A257PagoNubefactResponse[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A257PagoNubefactResponse", A257PagoNubefactResponse);
         A308PagoRequest = T000T7_A308PagoRequest[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A308PagoRequest", A308PagoRequest);
         A309PagoResponse = T000T7_A309PagoResponse[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A309PagoResponse", A309PagoResponse);
         A310PagoPasarelaId = T000T7_A310PagoPasarelaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A310PagoPasarelaId", A310PagoPasarelaId);
         A311PagoStatusCode = T000T7_A311PagoStatusCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A311PagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311PagoStatusCode), 8, 0));
         A338PagoEnlacePDF = T000T7_A338PagoEnlacePDF[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A338PagoEnlacePDF", A338PagoEnlacePDF);
         A339PagoEnlaceXML = T000T7_A339PagoEnlaceXML[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A339PagoEnlaceXML", A339PagoEnlaceXML);
         A246PagoEstadoR = T000T7_A246PagoEstadoR[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A246PagoEstadoR", A246PagoEstadoR);
         A34DisponibilidadId = T000T7_A34DisponibilidadId[0] ;
         n34DisponibilidadId = T000T7_n34DisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         A19CitaId = T000T7_A19CitaId[0] ;
         n19CitaId = T000T7_n19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         zm0T38( -19) ;
      }
      pr_default.close(5);
      onLoadActions0T38( ) ;
   }

   public void onLoadActions0T38( )
   {
      AV24Pgmname = "Pago" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
   }

   public void checkExtendedTable0T38( )
   {
      nIsDirty_38 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV24Pgmname = "Pago" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      /* Using cursor T000T5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A19CitaId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCitaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A21SGCitaDisponibilidadId = T000T5_A21SGCitaDisponibilidadId[0] ;
      A64CitaCode = T000T5_A64CitaCode[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
      pr_default.close(3);
      /* Using cursor T000T6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (0==A21SGCitaDisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
            AnyError = (short)(1) ;
         }
      }
      A66SGCitaDisponibilidadFecha = T000T6_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000T6_n66SGCitaDisponibilidadFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      pr_default.close(4);
      if ( ! ( ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "6") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "1") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "4") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "7") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "A") == 0 ) || ( GXutil.strcmp(A247PagoTipoDocumentoCliente, "0") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Tipo Documento Cliente fuera de rango", "OutOfRange", 1, "PAGOTIPODOCUMENTOCLIENTE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPagoTipoDocumentoCliente.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A251PagoClienteEmail,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Pago Cliente Email no coincide con el patrón especificado", "OutOfRange", 1, "PAGOCLIENTEEMAIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPagoClienteEmail_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A244PagoTipoDocumento == 1 ) || ( A244PagoTipoDocumento == 2 ) || ( A244PagoTipoDocumento == 3 ) || ( A244PagoTipoDocumento == 4 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Tipo Documento fuera de rango", "OutOfRange", 1, "PAGOTIPODOCUMENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPagoTipoDocumento.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A252PagoFechaEmision)) || (( GXutil.resetTime(A252PagoFechaEmision).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A252PagoFechaEmision), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Fecha Emision fuera de rango", "OutOfRange", 1, "PAGOFECHAEMISION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPagoFechaEmision_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A253PagoMoneda == 1 ) || ( A253PagoMoneda == 2 ) || ( A253PagoMoneda == 3 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Moneda fuera de rango", "OutOfRange", 1, "PAGOMONEDA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPagoMoneda.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000T4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A34DisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Disponibilidad'.", "ForeignKeyNotFound", 1, "DISPONIBILIDADID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtDisponibilidadId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(2);
      if ( ! ( GxRegex.IsMatch(A338PagoEnlacePDF,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Pago Enlace PDF no coincide con el patrón especificado", "OutOfRange", 1, "PAGOENLACEPDF");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPagoEnlacePDF_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A339PagoEnlaceXML,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Pago Enlace XML no coincide con el patrón especificado", "OutOfRange", 1, "PAGOENLACEXML");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPagoEnlaceXML_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A246PagoEstadoR, "A") == 0 ) || ( GXutil.strcmp(A246PagoEstadoR, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Pago Estado R fuera de rango", "OutOfRange", 1, "PAGOESTADOR");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPagoEstadoR.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0T38( )
   {
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_21( int A19CitaId )
   {
      /* Using cursor T000T8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A19CitaId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCitaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A21SGCitaDisponibilidadId = T000T8_A21SGCitaDisponibilidadId[0] ;
      A64CitaCode = T000T8_A64CitaCode[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A64CitaCode)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_22( int A21SGCitaDisponibilidadId )
   {
      /* Using cursor T000T9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A21SGCitaDisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
            AnyError = (short)(1) ;
         }
      }
      A66SGCitaDisponibilidadFecha = T000T9_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000T9_n66SGCitaDisponibilidadFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_20( int A34DisponibilidadId )
   {
      /* Using cursor T000T10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A34DisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Disponibilidad'.", "ForeignKeyNotFound", 1, "DISPONIBILIDADID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtDisponibilidadId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey0T38( )
   {
      /* Using cursor T000T11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound38 = (short)(1) ;
      }
      else
      {
         RcdFound38 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000T3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0T38( 19) ;
         RcdFound38 = (short)(1) ;
         A47PagoId = T000T3_A47PagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
         A242PagoMonto = T000T3_A242PagoMonto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A242PagoMonto", GXutil.ltrimstr( A242PagoMonto, 6, 2));
         A243PagoToken = T000T3_A243PagoToken[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A243PagoToken", A243PagoToken);
         A247PagoTipoDocumentoCliente = T000T3_A247PagoTipoDocumentoCliente[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
         A248PagoClienteNroDocumento = T000T3_A248PagoClienteNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A248PagoClienteNroDocumento", A248PagoClienteNroDocumento);
         A249PagoClienteDenominacion = T000T3_A249PagoClienteDenominacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A249PagoClienteDenominacion", A249PagoClienteDenominacion);
         A250PagoClienteDireccion = T000T3_A250PagoClienteDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A250PagoClienteDireccion", A250PagoClienteDireccion);
         A251PagoClienteEmail = T000T3_A251PagoClienteEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A251PagoClienteEmail", A251PagoClienteEmail);
         A244PagoTipoDocumento = T000T3_A244PagoTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
         A245PagoNumero = T000T3_A245PagoNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A245PagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A245PagoNumero), 8, 0));
         A252PagoFechaEmision = T000T3_A252PagoFechaEmision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A252PagoFechaEmision", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
         A253PagoMoneda = T000T3_A253PagoMoneda[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
         A256PagoNubefactRequest = T000T3_A256PagoNubefactRequest[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A256PagoNubefactRequest", A256PagoNubefactRequest);
         A257PagoNubefactResponse = T000T3_A257PagoNubefactResponse[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A257PagoNubefactResponse", A257PagoNubefactResponse);
         A308PagoRequest = T000T3_A308PagoRequest[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A308PagoRequest", A308PagoRequest);
         A309PagoResponse = T000T3_A309PagoResponse[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A309PagoResponse", A309PagoResponse);
         A310PagoPasarelaId = T000T3_A310PagoPasarelaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A310PagoPasarelaId", A310PagoPasarelaId);
         A311PagoStatusCode = T000T3_A311PagoStatusCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A311PagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311PagoStatusCode), 8, 0));
         A338PagoEnlacePDF = T000T3_A338PagoEnlacePDF[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A338PagoEnlacePDF", A338PagoEnlacePDF);
         A339PagoEnlaceXML = T000T3_A339PagoEnlaceXML[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A339PagoEnlaceXML", A339PagoEnlaceXML);
         A246PagoEstadoR = T000T3_A246PagoEstadoR[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A246PagoEstadoR", A246PagoEstadoR);
         A34DisponibilidadId = T000T3_A34DisponibilidadId[0] ;
         n34DisponibilidadId = T000T3_n34DisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         A19CitaId = T000T3_A19CitaId[0] ;
         n19CitaId = T000T3_n19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         Z47PagoId = A47PagoId ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0T38( ) ;
         if ( AnyError == 1 )
         {
            RcdFound38 = (short)(0) ;
            initializeNonKey0T38( ) ;
         }
         Gx_mode = sMode38 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound38 = (short)(0) ;
         initializeNonKey0T38( ) ;
         sMode38 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode38 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0T38( ) ;
      if ( RcdFound38 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound38 = (short)(0) ;
      /* Using cursor T000T12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000T12_A47PagoId[0] < A47PagoId ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000T12_A47PagoId[0] > A47PagoId ) ) )
         {
            A47PagoId = T000T12_A47PagoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
            RcdFound38 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound38 = (short)(0) ;
      /* Using cursor T000T13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A47PagoId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000T13_A47PagoId[0] > A47PagoId ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000T13_A47PagoId[0] < A47PagoId ) ) )
         {
            A47PagoId = T000T13_A47PagoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
            RcdFound38 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0T38( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0T38( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound38 == 1 )
         {
            if ( A47PagoId != Z47PagoId )
            {
               A47PagoId = Z47PagoId ;
               httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAGOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPagoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0T38( ) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A47PagoId != Z47PagoId )
            {
               /* Insert record */
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0T38( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAGOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPagoId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCitaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0T38( ) ;
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
      if ( A47PagoId != Z47PagoId )
      {
         A47PagoId = Z47PagoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAGOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPagoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0T38( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000T2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A47PagoId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pago"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z242PagoMonto, T000T2_A242PagoMonto[0]) != 0 ) || ( GXutil.strcmp(Z243PagoToken, T000T2_A243PagoToken[0]) != 0 ) || ( GXutil.strcmp(Z247PagoTipoDocumentoCliente, T000T2_A247PagoTipoDocumentoCliente[0]) != 0 ) || ( GXutil.strcmp(Z248PagoClienteNroDocumento, T000T2_A248PagoClienteNroDocumento[0]) != 0 ) || ( GXutil.strcmp(Z249PagoClienteDenominacion, T000T2_A249PagoClienteDenominacion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z250PagoClienteDireccion, T000T2_A250PagoClienteDireccion[0]) != 0 ) || ( GXutil.strcmp(Z251PagoClienteEmail, T000T2_A251PagoClienteEmail[0]) != 0 ) || ( Z244PagoTipoDocumento != T000T2_A244PagoTipoDocumento[0] ) || ( Z245PagoNumero != T000T2_A245PagoNumero[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z252PagoFechaEmision), GXutil.resetTime(T000T2_A252PagoFechaEmision[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z253PagoMoneda != T000T2_A253PagoMoneda[0] ) || ( GXutil.strcmp(Z310PagoPasarelaId, T000T2_A310PagoPasarelaId[0]) != 0 ) || ( Z311PagoStatusCode != T000T2_A311PagoStatusCode[0] ) || ( GXutil.strcmp(Z338PagoEnlacePDF, T000T2_A338PagoEnlacePDF[0]) != 0 ) || ( GXutil.strcmp(Z339PagoEnlaceXML, T000T2_A339PagoEnlaceXML[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z246PagoEstadoR, T000T2_A246PagoEstadoR[0]) != 0 ) || ( Z34DisponibilidadId != T000T2_A34DisponibilidadId[0] ) || ( Z19CitaId != T000T2_A19CitaId[0] ) )
         {
            if ( DecimalUtil.compareTo(Z242PagoMonto, T000T2_A242PagoMonto[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoMonto");
               GXutil.writeLogRaw("Old: ",Z242PagoMonto);
               GXutil.writeLogRaw("Current: ",T000T2_A242PagoMonto[0]);
            }
            if ( GXutil.strcmp(Z243PagoToken, T000T2_A243PagoToken[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoToken");
               GXutil.writeLogRaw("Old: ",Z243PagoToken);
               GXutil.writeLogRaw("Current: ",T000T2_A243PagoToken[0]);
            }
            if ( GXutil.strcmp(Z247PagoTipoDocumentoCliente, T000T2_A247PagoTipoDocumentoCliente[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoTipoDocumentoCliente");
               GXutil.writeLogRaw("Old: ",Z247PagoTipoDocumentoCliente);
               GXutil.writeLogRaw("Current: ",T000T2_A247PagoTipoDocumentoCliente[0]);
            }
            if ( GXutil.strcmp(Z248PagoClienteNroDocumento, T000T2_A248PagoClienteNroDocumento[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoClienteNroDocumento");
               GXutil.writeLogRaw("Old: ",Z248PagoClienteNroDocumento);
               GXutil.writeLogRaw("Current: ",T000T2_A248PagoClienteNroDocumento[0]);
            }
            if ( GXutil.strcmp(Z249PagoClienteDenominacion, T000T2_A249PagoClienteDenominacion[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoClienteDenominacion");
               GXutil.writeLogRaw("Old: ",Z249PagoClienteDenominacion);
               GXutil.writeLogRaw("Current: ",T000T2_A249PagoClienteDenominacion[0]);
            }
            if ( GXutil.strcmp(Z250PagoClienteDireccion, T000T2_A250PagoClienteDireccion[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoClienteDireccion");
               GXutil.writeLogRaw("Old: ",Z250PagoClienteDireccion);
               GXutil.writeLogRaw("Current: ",T000T2_A250PagoClienteDireccion[0]);
            }
            if ( GXutil.strcmp(Z251PagoClienteEmail, T000T2_A251PagoClienteEmail[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoClienteEmail");
               GXutil.writeLogRaw("Old: ",Z251PagoClienteEmail);
               GXutil.writeLogRaw("Current: ",T000T2_A251PagoClienteEmail[0]);
            }
            if ( Z244PagoTipoDocumento != T000T2_A244PagoTipoDocumento[0] )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoTipoDocumento");
               GXutil.writeLogRaw("Old: ",Z244PagoTipoDocumento);
               GXutil.writeLogRaw("Current: ",T000T2_A244PagoTipoDocumento[0]);
            }
            if ( Z245PagoNumero != T000T2_A245PagoNumero[0] )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoNumero");
               GXutil.writeLogRaw("Old: ",Z245PagoNumero);
               GXutil.writeLogRaw("Current: ",T000T2_A245PagoNumero[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z252PagoFechaEmision), GXutil.resetTime(T000T2_A252PagoFechaEmision[0])) ) )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoFechaEmision");
               GXutil.writeLogRaw("Old: ",Z252PagoFechaEmision);
               GXutil.writeLogRaw("Current: ",T000T2_A252PagoFechaEmision[0]);
            }
            if ( Z253PagoMoneda != T000T2_A253PagoMoneda[0] )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoMoneda");
               GXutil.writeLogRaw("Old: ",Z253PagoMoneda);
               GXutil.writeLogRaw("Current: ",T000T2_A253PagoMoneda[0]);
            }
            if ( GXutil.strcmp(Z310PagoPasarelaId, T000T2_A310PagoPasarelaId[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoPasarelaId");
               GXutil.writeLogRaw("Old: ",Z310PagoPasarelaId);
               GXutil.writeLogRaw("Current: ",T000T2_A310PagoPasarelaId[0]);
            }
            if ( Z311PagoStatusCode != T000T2_A311PagoStatusCode[0] )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoStatusCode");
               GXutil.writeLogRaw("Old: ",Z311PagoStatusCode);
               GXutil.writeLogRaw("Current: ",T000T2_A311PagoStatusCode[0]);
            }
            if ( GXutil.strcmp(Z338PagoEnlacePDF, T000T2_A338PagoEnlacePDF[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoEnlacePDF");
               GXutil.writeLogRaw("Old: ",Z338PagoEnlacePDF);
               GXutil.writeLogRaw("Current: ",T000T2_A338PagoEnlacePDF[0]);
            }
            if ( GXutil.strcmp(Z339PagoEnlaceXML, T000T2_A339PagoEnlaceXML[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoEnlaceXML");
               GXutil.writeLogRaw("Old: ",Z339PagoEnlaceXML);
               GXutil.writeLogRaw("Current: ",T000T2_A339PagoEnlaceXML[0]);
            }
            if ( GXutil.strcmp(Z246PagoEstadoR, T000T2_A246PagoEstadoR[0]) != 0 )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"PagoEstadoR");
               GXutil.writeLogRaw("Old: ",Z246PagoEstadoR);
               GXutil.writeLogRaw("Current: ",T000T2_A246PagoEstadoR[0]);
            }
            if ( Z34DisponibilidadId != T000T2_A34DisponibilidadId[0] )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"DisponibilidadId");
               GXutil.writeLogRaw("Old: ",Z34DisponibilidadId);
               GXutil.writeLogRaw("Current: ",T000T2_A34DisponibilidadId[0]);
            }
            if ( Z19CitaId != T000T2_A19CitaId[0] )
            {
               GXutil.writeLogln("pago:[seudo value changed for attri]"+"CitaId");
               GXutil.writeLogRaw("Old: ",Z19CitaId);
               GXutil.writeLogRaw("Current: ",T000T2_A19CitaId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Pago"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0T38( )
   {
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0T38( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0T38( 0) ;
         checkOptimisticConcurrency0T38( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0T38( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0T38( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000T14 */
                  pr_default.execute(12, new Object[] {A242PagoMonto, A243PagoToken, A247PagoTipoDocumentoCliente, A248PagoClienteNroDocumento, A249PagoClienteDenominacion, A250PagoClienteDireccion, A251PagoClienteEmail, Short.valueOf(A244PagoTipoDocumento), Integer.valueOf(A245PagoNumero), A252PagoFechaEmision, Short.valueOf(A253PagoMoneda), A256PagoNubefactRequest, A257PagoNubefactResponse, A308PagoRequest, A309PagoResponse, A310PagoPasarelaId, Integer.valueOf(A311PagoStatusCode), A338PagoEnlacePDF, A339PagoEnlaceXML, A246PagoEstadoR, Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
                  A47PagoId = T000T14_A47PagoId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pago");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0T0( ) ;
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
            load0T38( ) ;
         }
         endLevel0T38( ) ;
      }
      closeExtendedTableCursors0T38( ) ;
   }

   public void update0T38( )
   {
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0T38( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0T38( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0T38( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0T38( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000T15 */
                  pr_default.execute(13, new Object[] {A242PagoMonto, A243PagoToken, A247PagoTipoDocumentoCliente, A248PagoClienteNroDocumento, A249PagoClienteDenominacion, A250PagoClienteDireccion, A251PagoClienteEmail, Short.valueOf(A244PagoTipoDocumento), Integer.valueOf(A245PagoNumero), A252PagoFechaEmision, Short.valueOf(A253PagoMoneda), A256PagoNubefactRequest, A257PagoNubefactResponse, A308PagoRequest, A309PagoResponse, A310PagoPasarelaId, Integer.valueOf(A311PagoStatusCode), A338PagoEnlacePDF, A339PagoEnlaceXML, A246PagoEstadoR, Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId), Integer.valueOf(A47PagoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Pago");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Pago"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0T38( ) ;
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
         endLevel0T38( ) ;
      }
      closeExtendedTableCursors0T38( ) ;
   }

   public void deferredUpdate0T38( )
   {
   }

   public void delete( )
   {
      beforeValidate0T38( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0T38( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0T38( ) ;
         afterConfirm0T38( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0T38( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000T16 */
               pr_default.execute(14, new Object[] {Integer.valueOf(A47PagoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Pago");
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
      sMode38 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0T38( ) ;
      Gx_mode = sMode38 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0T38( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "Pago" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         /* Using cursor T000T17 */
         pr_default.execute(15, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
         A21SGCitaDisponibilidadId = T000T17_A21SGCitaDisponibilidadId[0] ;
         A64CitaCode = T000T17_A64CitaCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
         pr_default.close(15);
         /* Using cursor T000T18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A66SGCitaDisponibilidadFecha = T000T18_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000T18_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         pr_default.close(16);
      }
   }

   public void endLevel0T38( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0T38( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(15);
         pr_default.close(16);
         Application.commitDataStores(context, remoteHandle, pr_default, "pago");
         if ( AnyError == 0 )
         {
            confirmValues0T0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(15);
         pr_default.close(16);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "pago");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0T38( )
   {
      /* Scan By routine */
      /* Using cursor T000T19 */
      pr_default.execute(17);
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A47PagoId = T000T19_A47PagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0T38( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound38 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound38 = (short)(1) ;
         A47PagoId = T000T19_A47PagoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
      }
   }

   public void scanEnd0T38( )
   {
      pr_default.close(17);
   }

   public void afterConfirm0T38( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0T38( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0T38( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0T38( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0T38( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0T38( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0T38( )
   {
      edtPagoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoId_Enabled), 5, 0), true);
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      edtCitaCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaCode_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadFecha_Enabled), 5, 0), true);
      edtPagoMonto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoMonto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoMonto_Enabled), 5, 0), true);
      edtPagoToken_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoToken_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoToken_Enabled), 5, 0), true);
      cmbPagoTipoDocumentoCliente.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumentoCliente.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPagoTipoDocumentoCliente.getEnabled(), 5, 0), true);
      edtPagoClienteNroDocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteNroDocumento_Enabled), 5, 0), true);
      edtPagoClienteDenominacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteDenominacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteDenominacion_Enabled), 5, 0), true);
      edtPagoClienteDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteDireccion_Enabled), 5, 0), true);
      edtPagoClienteEmail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoClienteEmail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoClienteEmail_Enabled), 5, 0), true);
      cmbPagoTipoDocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoTipoDocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPagoTipoDocumento.getEnabled(), 5, 0), true);
      edtPagoNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoNumero_Enabled), 5, 0), true);
      edtPagoFechaEmision_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoFechaEmision_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoFechaEmision_Enabled), 5, 0), true);
      cmbPagoMoneda.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoMoneda.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPagoMoneda.getEnabled(), 5, 0), true);
      edtPagoNubefactRequest_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoNubefactRequest_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoNubefactRequest_Enabled), 5, 0), true);
      edtPagoNubefactResponse_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoNubefactResponse_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoNubefactResponse_Enabled), 5, 0), true);
      edtPagoRequest_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoRequest_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoRequest_Enabled), 5, 0), true);
      edtPagoResponse_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoResponse_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoResponse_Enabled), 5, 0), true);
      edtPagoPasarelaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoPasarelaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoPasarelaId_Enabled), 5, 0), true);
      edtPagoStatusCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoStatusCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoStatusCode_Enabled), 5, 0), true);
      edtDisponibilidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Enabled), 5, 0), true);
      edtPagoEnlacePDF_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoEnlacePDF_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoEnlacePDF_Enabled), 5, 0), true);
      edtPagoEnlaceXML_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPagoEnlaceXML_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPagoEnlaceXML_Enabled), 5, 0), true);
      cmbPagoEstadoR.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPagoEstadoR.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPagoEstadoR.getEnabled(), 5, 0), true);
      edtavCombocitaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Enabled), 5, 0), true);
      edtavCombodisponibilidadid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombodisponibilidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombodisponibilidadid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0T38( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0T0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033251", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.pago", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20PagoId,8,0))}, new String[] {"Gx_mode","PagoId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Pago");
      forbiddenHiddens.add("PagoId", localUtil.format( DecimalUtil.doubleToDec(A47PagoId), "ZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("pago:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z47PagoId", GXutil.ltrim( localUtil.ntoc( Z47PagoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z242PagoMonto", GXutil.ltrim( localUtil.ntoc( Z242PagoMonto, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z243PagoToken", Z243PagoToken);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z247PagoTipoDocumentoCliente", GXutil.rtrim( Z247PagoTipoDocumentoCliente));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z248PagoClienteNroDocumento", Z248PagoClienteNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z249PagoClienteDenominacion", Z249PagoClienteDenominacion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z250PagoClienteDireccion", Z250PagoClienteDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z251PagoClienteEmail", Z251PagoClienteEmail);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z244PagoTipoDocumento", GXutil.ltrim( localUtil.ntoc( Z244PagoTipoDocumento, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z245PagoNumero", GXutil.ltrim( localUtil.ntoc( Z245PagoNumero, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z252PagoFechaEmision", localUtil.dtoc( Z252PagoFechaEmision, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z253PagoMoneda", GXutil.ltrim( localUtil.ntoc( Z253PagoMoneda, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z310PagoPasarelaId", Z310PagoPasarelaId);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z311PagoStatusCode", GXutil.ltrim( localUtil.ntoc( Z311PagoStatusCode, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z338PagoEnlacePDF", Z338PagoEnlacePDF);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z339PagoEnlaceXML", Z339PagoEnlaceXML);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z246PagoEstadoR", GXutil.rtrim( Z246PagoEstadoR));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z34DisponibilidadId", GXutil.ltrim( localUtil.ntoc( Z34DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N19CitaId", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N34DisponibilidadId", GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITAID_DATA", AV14CitaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITAID_DATA", AV14CitaId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDISPONIBILIDADID_DATA", AV22DisponibilidadId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDISPONIBILIDADID_DATA", AV22DisponibilidadId_Data);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV8TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV8TrnContext);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV8TrnContext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPAGOID", GXutil.ltrim( localUtil.ntoc( AV20PagoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAGOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20PagoId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CITAID", GXutil.ltrim( localUtil.ntoc( AV10Insert_CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_DISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV21Insert_DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGCITADISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Objectcall", GXutil.rtrim( Combo_citaid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Cls", GXutil.rtrim( Combo_citaid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Selectedvalue_set", GXutil.rtrim( Combo_citaid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Selectedtext_set", GXutil.rtrim( Combo_citaid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Enabled", GXutil.booltostr( Combo_citaid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistproc", GXutil.rtrim( Combo_citaid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_citaid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DISPONIBILIDADID_Objectcall", GXutil.rtrim( Combo_disponibilidadid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DISPONIBILIDADID_Cls", GXutil.rtrim( Combo_disponibilidadid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DISPONIBILIDADID_Selectedvalue_set", GXutil.rtrim( Combo_disponibilidadid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DISPONIBILIDADID_Selectedtext_set", GXutil.rtrim( Combo_disponibilidadid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DISPONIBILIDADID_Enabled", GXutil.booltostr( Combo_disponibilidadid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DISPONIBILIDADID_Datalistproc", GXutil.rtrim( Combo_disponibilidadid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DISPONIBILIDADID_Datalistprocparametersprefix", GXutil.rtrim( Combo_disponibilidadid_Datalistprocparametersprefix));
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
      return formatLink("com.projectthani.pago", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20PagoId,8,0))}, new String[] {"Gx_mode","PagoId"})  ;
   }

   public String getPgmname( )
   {
      return "Pago" ;
   }

   public String getPgmdesc( )
   {
      return "Pago" ;
   }

   public void initializeNonKey0T38( )
   {
      A21SGCitaDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
      A19CitaId = 0 ;
      n19CitaId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      n19CitaId = ((0==A19CitaId) ? true : false) ;
      A34DisponibilidadId = 0 ;
      n34DisponibilidadId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      n34DisponibilidadId = ((0==A34DisponibilidadId) ? true : false) ;
      A64CitaCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      n66SGCitaDisponibilidadFecha = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      A242PagoMonto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A242PagoMonto", GXutil.ltrimstr( A242PagoMonto, 6, 2));
      A243PagoToken = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A243PagoToken", A243PagoToken);
      A247PagoTipoDocumentoCliente = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
      A248PagoClienteNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A248PagoClienteNroDocumento", A248PagoClienteNroDocumento);
      A249PagoClienteDenominacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A249PagoClienteDenominacion", A249PagoClienteDenominacion);
      A250PagoClienteDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A250PagoClienteDireccion", A250PagoClienteDireccion);
      A251PagoClienteEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A251PagoClienteEmail", A251PagoClienteEmail);
      A244PagoTipoDocumento = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
      A245PagoNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A245PagoNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A245PagoNumero), 8, 0));
      A252PagoFechaEmision = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A252PagoFechaEmision", localUtil.format(A252PagoFechaEmision, "99/99/9999"));
      A253PagoMoneda = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
      A256PagoNubefactRequest = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A256PagoNubefactRequest", A256PagoNubefactRequest);
      A257PagoNubefactResponse = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A257PagoNubefactResponse", A257PagoNubefactResponse);
      A308PagoRequest = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A308PagoRequest", A308PagoRequest);
      A309PagoResponse = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A309PagoResponse", A309PagoResponse);
      A310PagoPasarelaId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A310PagoPasarelaId", A310PagoPasarelaId);
      A311PagoStatusCode = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A311PagoStatusCode", GXutil.ltrimstr( DecimalUtil.doubleToDec(A311PagoStatusCode), 8, 0));
      A338PagoEnlacePDF = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A338PagoEnlacePDF", A338PagoEnlacePDF);
      A339PagoEnlaceXML = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A339PagoEnlaceXML", A339PagoEnlaceXML);
      A246PagoEstadoR = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A246PagoEstadoR", A246PagoEstadoR);
      Z242PagoMonto = DecimalUtil.ZERO ;
      Z243PagoToken = "" ;
      Z247PagoTipoDocumentoCliente = "" ;
      Z248PagoClienteNroDocumento = "" ;
      Z249PagoClienteDenominacion = "" ;
      Z250PagoClienteDireccion = "" ;
      Z251PagoClienteEmail = "" ;
      Z244PagoTipoDocumento = (short)(0) ;
      Z245PagoNumero = 0 ;
      Z252PagoFechaEmision = GXutil.nullDate() ;
      Z253PagoMoneda = (short)(0) ;
      Z310PagoPasarelaId = "" ;
      Z311PagoStatusCode = 0 ;
      Z338PagoEnlacePDF = "" ;
      Z339PagoEnlaceXML = "" ;
      Z246PagoEstadoR = "" ;
      Z34DisponibilidadId = 0 ;
      Z19CitaId = 0 ;
   }

   public void initAll0T38( )
   {
      A47PagoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A47PagoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A47PagoId), 8, 0));
      initializeNonKey0T38( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033289", true, true);
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
      httpContext.AddJavascriptSource("pago.js", "?2022511033289", false, true);
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
      edtPagoId_Internalname = "PAGOID" ;
      lblTextblockcitaid_Internalname = "TEXTBLOCKCITAID" ;
      Combo_citaid_Internalname = "COMBO_CITAID" ;
      edtCitaId_Internalname = "CITAID" ;
      divTablesplittedcitaid_Internalname = "TABLESPLITTEDCITAID" ;
      edtCitaCode_Internalname = "CITACODE" ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA" ;
      edtPagoMonto_Internalname = "PAGOMONTO" ;
      edtPagoToken_Internalname = "PAGOTOKEN" ;
      cmbPagoTipoDocumentoCliente.setInternalname( "PAGOTIPODOCUMENTOCLIENTE" );
      edtPagoClienteNroDocumento_Internalname = "PAGOCLIENTENRODOCUMENTO" ;
      edtPagoClienteDenominacion_Internalname = "PAGOCLIENTEDENOMINACION" ;
      edtPagoClienteDireccion_Internalname = "PAGOCLIENTEDIRECCION" ;
      edtPagoClienteEmail_Internalname = "PAGOCLIENTEEMAIL" ;
      cmbPagoTipoDocumento.setInternalname( "PAGOTIPODOCUMENTO" );
      edtPagoNumero_Internalname = "PAGONUMERO" ;
      edtPagoFechaEmision_Internalname = "PAGOFECHAEMISION" ;
      cmbPagoMoneda.setInternalname( "PAGOMONEDA" );
      edtPagoNubefactRequest_Internalname = "PAGONUBEFACTREQUEST" ;
      edtPagoNubefactResponse_Internalname = "PAGONUBEFACTRESPONSE" ;
      edtPagoRequest_Internalname = "PAGOREQUEST" ;
      edtPagoResponse_Internalname = "PAGORESPONSE" ;
      edtPagoPasarelaId_Internalname = "PAGOPASARELAID" ;
      edtPagoStatusCode_Internalname = "PAGOSTATUSCODE" ;
      lblTextblockdisponibilidadid_Internalname = "TEXTBLOCKDISPONIBILIDADID" ;
      Combo_disponibilidadid_Internalname = "COMBO_DISPONIBILIDADID" ;
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID" ;
      divTablesplitteddisponibilidadid_Internalname = "TABLESPLITTEDDISPONIBILIDADID" ;
      edtPagoEnlacePDF_Internalname = "PAGOENLACEPDF" ;
      edtPagoEnlaceXML_Internalname = "PAGOENLACEXML" ;
      cmbPagoEstadoR.setInternalname( "PAGOESTADOR" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocitaid_Internalname = "vCOMBOCITAID" ;
      divSectionattribute_citaid_Internalname = "SECTIONATTRIBUTE_CITAID" ;
      edtavCombodisponibilidadid_Internalname = "vCOMBODISPONIBILIDADID" ;
      divSectionattribute_disponibilidadid_Internalname = "SECTIONATTRIBUTE_DISPONIBILIDADID" ;
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Pago" );
      edtavCombodisponibilidadid_Jsonclick = "" ;
      edtavCombodisponibilidadid_Enabled = 0 ;
      edtavCombodisponibilidadid_Visible = 1 ;
      edtavCombocitaid_Jsonclick = "" ;
      edtavCombocitaid_Enabled = 0 ;
      edtavCombocitaid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbPagoEstadoR.setJsonclick( "" );
      cmbPagoEstadoR.setEnabled( 1 );
      edtPagoEnlaceXML_Jsonclick = "" ;
      edtPagoEnlaceXML_Enabled = 1 ;
      edtPagoEnlacePDF_Jsonclick = "" ;
      edtPagoEnlacePDF_Enabled = 1 ;
      edtDisponibilidadId_Jsonclick = "" ;
      edtDisponibilidadId_Enabled = 1 ;
      edtDisponibilidadId_Visible = 1 ;
      Combo_disponibilidadid_Datalistprocparametersprefix = " \"ComboName\": \"DisponibilidadId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PagoId\": 0" ;
      Combo_disponibilidadid_Datalistproc = "PagoLoadDVCombo" ;
      Combo_disponibilidadid_Cls = "ExtendedCombo Attribute" ;
      Combo_disponibilidadid_Caption = "" ;
      Combo_disponibilidadid_Enabled = GXutil.toBoolean( -1) ;
      edtPagoStatusCode_Jsonclick = "" ;
      edtPagoStatusCode_Enabled = 1 ;
      edtPagoPasarelaId_Jsonclick = "" ;
      edtPagoPasarelaId_Enabled = 1 ;
      edtPagoResponse_Enabled = 1 ;
      edtPagoRequest_Enabled = 1 ;
      edtPagoNubefactResponse_Enabled = 1 ;
      edtPagoNubefactRequest_Enabled = 1 ;
      cmbPagoMoneda.setJsonclick( "" );
      cmbPagoMoneda.setEnabled( 1 );
      edtPagoFechaEmision_Jsonclick = "" ;
      edtPagoFechaEmision_Enabled = 1 ;
      edtPagoNumero_Jsonclick = "" ;
      edtPagoNumero_Enabled = 1 ;
      cmbPagoTipoDocumento.setJsonclick( "" );
      cmbPagoTipoDocumento.setEnabled( 1 );
      edtPagoClienteEmail_Jsonclick = "" ;
      edtPagoClienteEmail_Enabled = 1 ;
      edtPagoClienteDireccion_Jsonclick = "" ;
      edtPagoClienteDireccion_Enabled = 1 ;
      edtPagoClienteDenominacion_Jsonclick = "" ;
      edtPagoClienteDenominacion_Enabled = 1 ;
      edtPagoClienteNroDocumento_Jsonclick = "" ;
      edtPagoClienteNroDocumento_Enabled = 1 ;
      cmbPagoTipoDocumentoCliente.setJsonclick( "" );
      cmbPagoTipoDocumentoCliente.setEnabled( 1 );
      edtPagoToken_Jsonclick = "" ;
      edtPagoToken_Enabled = 1 ;
      edtPagoMonto_Jsonclick = "" ;
      edtPagoMonto_Enabled = 1 ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaCode_Enabled = 0 ;
      edtCitaId_Jsonclick = "" ;
      edtCitaId_Enabled = 1 ;
      edtCitaId_Visible = 1 ;
      Combo_citaid_Datalistprocparametersprefix = " \"ComboName\": \"CitaId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PagoId\": 0" ;
      Combo_citaid_Datalistproc = "PagoLoadDVCombo" ;
      Combo_citaid_Cls = "ExtendedCombo Attribute" ;
      Combo_citaid_Caption = "" ;
      Combo_citaid_Enabled = GXutil.toBoolean( -1) ;
      edtPagoId_Jsonclick = "" ;
      edtPagoId_Enabled = 0 ;
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
         A247PagoTipoDocumentoCliente = cmbPagoTipoDocumentoCliente.getValidValue(A247PagoTipoDocumentoCliente) ;
         httpContext.ajax_rsp_assign_attri("", false, "A247PagoTipoDocumentoCliente", A247PagoTipoDocumentoCliente);
      }
      cmbPagoTipoDocumento.setName( "PAGOTIPODOCUMENTO" );
      cmbPagoTipoDocumento.setWebtags( "" );
      cmbPagoTipoDocumento.addItem("1", "Factura", (short)(0));
      cmbPagoTipoDocumento.addItem("2", "Boleta", (short)(0));
      cmbPagoTipoDocumento.addItem("3", "Nota Credito", (short)(0));
      cmbPagoTipoDocumento.addItem("4", "Nota Debito", (short)(0));
      if ( cmbPagoTipoDocumento.getItemCount() > 0 )
      {
         A244PagoTipoDocumento = (short)(GXutil.lval( cmbPagoTipoDocumento.getValidValue(GXutil.trim( GXutil.str( A244PagoTipoDocumento, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A244PagoTipoDocumento", GXutil.ltrimstr( DecimalUtil.doubleToDec(A244PagoTipoDocumento), 4, 0));
      }
      cmbPagoMoneda.setName( "PAGOMONEDA" );
      cmbPagoMoneda.setWebtags( "" );
      cmbPagoMoneda.addItem("1", "Soles", (short)(0));
      cmbPagoMoneda.addItem("2", "Dólares", (short)(0));
      cmbPagoMoneda.addItem("3", "Euros", (short)(0));
      if ( cmbPagoMoneda.getItemCount() > 0 )
      {
         A253PagoMoneda = (short)(GXutil.lval( cmbPagoMoneda.getValidValue(GXutil.trim( GXutil.str( A253PagoMoneda, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A253PagoMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A253PagoMoneda), 4, 0));
      }
      cmbPagoEstadoR.setName( "PAGOESTADOR" );
      cmbPagoEstadoR.setWebtags( "" );
      cmbPagoEstadoR.addItem("A", "Activo", (short)(0));
      cmbPagoEstadoR.addItem("I", "Inactivo", (short)(0));
      if ( cmbPagoEstadoR.getItemCount() > 0 )
      {
         A246PagoEstadoR = cmbPagoEstadoR.getValidValue(A246PagoEstadoR) ;
         httpContext.ajax_rsp_assign_attri("", false, "A246PagoEstadoR", A246PagoEstadoR);
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

   public void valid_Citaid( )
   {
      n19CitaId = false ;
      n66SGCitaDisponibilidadFecha = false ;
      /* Using cursor T000T17 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n19CitaId), Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         if ( ! ( (0==A19CitaId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCitaId_Internalname ;
         }
      }
      A21SGCitaDisponibilidadId = T000T17_A21SGCitaDisponibilidadId[0] ;
      A64CitaCode = T000T17_A64CitaCode[0] ;
      pr_default.close(15);
      /* Using cursor T000T18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         if ( ! ( (0==A21SGCitaDisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
            AnyError = (short)(1) ;
         }
      }
      A66SGCitaDisponibilidadFecha = T000T18_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000T18_n66SGCitaDisponibilidadFecha[0] ;
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A64CitaCode", A64CitaCode);
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
   }

   public void valid_Disponibilidadid( )
   {
      n34DisponibilidadId = false ;
      /* Using cursor T000T20 */
      pr_default.execute(18, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         if ( ! ( (0==A34DisponibilidadId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Disponibilidad'.", "ForeignKeyNotFound", 1, "DISPONIBILIDADID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtDisponibilidadId_Internalname ;
         }
      }
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20PagoId',fld:'vPAGOID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV20PagoId',fld:'vPAGOID',pic:'ZZZZZZZ9',hsh:true},{av:'A47PagoId',fld:'PAGOID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120T2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PAGOID","{handler:'valid_Pagoid',iparms:[]");
      setEventMetadata("VALID_PAGOID",",oparms:[]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A21SGCitaDisponibilidadId',fld:'SGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A64CitaCode',fld:'CITACODE',pic:''},{av:'A66SGCitaDisponibilidadFecha',fld:'SGCITADISPONIBILIDADFECHA',pic:''}]");
      setEventMetadata("VALID_CITAID",",oparms:[{av:'A21SGCitaDisponibilidadId',fld:'SGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A64CitaCode',fld:'CITACODE',pic:''},{av:'A66SGCitaDisponibilidadFecha',fld:'SGCITADISPONIBILIDADFECHA',pic:''}]}");
      setEventMetadata("VALID_PAGOTIPODOCUMENTOCLIENTE","{handler:'valid_Pagotipodocumentocliente',iparms:[]");
      setEventMetadata("VALID_PAGOTIPODOCUMENTOCLIENTE",",oparms:[]}");
      setEventMetadata("VALID_PAGOCLIENTEEMAIL","{handler:'valid_Pagoclienteemail',iparms:[]");
      setEventMetadata("VALID_PAGOCLIENTEEMAIL",",oparms:[]}");
      setEventMetadata("VALID_PAGOTIPODOCUMENTO","{handler:'valid_Pagotipodocumento',iparms:[]");
      setEventMetadata("VALID_PAGOTIPODOCUMENTO",",oparms:[]}");
      setEventMetadata("VALID_PAGOFECHAEMISION","{handler:'valid_Pagofechaemision',iparms:[]");
      setEventMetadata("VALID_PAGOFECHAEMISION",",oparms:[]}");
      setEventMetadata("VALID_PAGOMONEDA","{handler:'valid_Pagomoneda',iparms:[]");
      setEventMetadata("VALID_PAGOMONEDA",",oparms:[]}");
      setEventMetadata("VALID_DISPONIBILIDADID","{handler:'valid_Disponibilidadid',iparms:[{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_DISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("VALID_PAGOENLACEPDF","{handler:'valid_Pagoenlacepdf',iparms:[]");
      setEventMetadata("VALID_PAGOENLACEPDF",",oparms:[]}");
      setEventMetadata("VALID_PAGOENLACEXML","{handler:'valid_Pagoenlacexml',iparms:[]");
      setEventMetadata("VALID_PAGOENLACEXML",",oparms:[]}");
      setEventMetadata("VALID_PAGOESTADOR","{handler:'valid_Pagoestador',iparms:[]");
      setEventMetadata("VALID_PAGOESTADOR",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCITAID","{handler:'validv_Combocitaid',iparms:[]");
      setEventMetadata("VALIDV_COMBOCITAID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBODISPONIBILIDADID","{handler:'validv_Combodisponibilidadid',iparms:[]");
      setEventMetadata("VALIDV_COMBODISPONIBILIDADID",",oparms:[]}");
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
      pr_default.close(18);
      pr_default.close(15);
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z242PagoMonto = DecimalUtil.ZERO ;
      Z243PagoToken = "" ;
      Z247PagoTipoDocumentoCliente = "" ;
      Z248PagoClienteNroDocumento = "" ;
      Z249PagoClienteDenominacion = "" ;
      Z250PagoClienteDireccion = "" ;
      Z251PagoClienteEmail = "" ;
      Z252PagoFechaEmision = GXutil.nullDate() ;
      Z310PagoPasarelaId = "" ;
      Z338PagoEnlacePDF = "" ;
      Z339PagoEnlaceXML = "" ;
      Z246PagoEstadoR = "" ;
      Combo_disponibilidadid_Selectedvalue_get = "" ;
      Combo_citaid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A247PagoTipoDocumentoCliente = "" ;
      A246PagoEstadoR = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcitaid_Jsonclick = "" ;
      ucCombo_citaid = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14CitaId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A64CitaCode = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A242PagoMonto = DecimalUtil.ZERO ;
      A243PagoToken = "" ;
      A248PagoClienteNroDocumento = "" ;
      A249PagoClienteDenominacion = "" ;
      A250PagoClienteDireccion = "" ;
      A251PagoClienteEmail = "" ;
      A252PagoFechaEmision = GXutil.nullDate() ;
      A256PagoNubefactRequest = "" ;
      A257PagoNubefactResponse = "" ;
      A308PagoRequest = "" ;
      A309PagoResponse = "" ;
      A310PagoPasarelaId = "" ;
      lblTextblockdisponibilidadid_Jsonclick = "" ;
      ucCombo_disponibilidadid = new com.genexus.webpanels.GXUserControl();
      AV22DisponibilidadId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A338PagoEnlacePDF = "" ;
      A339PagoEnlaceXML = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV24Pgmname = "" ;
      Combo_citaid_Objectcall = "" ;
      Combo_citaid_Class = "" ;
      Combo_citaid_Icontype = "" ;
      Combo_citaid_Icon = "" ;
      Combo_citaid_Tooltip = "" ;
      Combo_citaid_Selectedvalue_set = "" ;
      Combo_citaid_Selectedtext_set = "" ;
      Combo_citaid_Selectedtext_get = "" ;
      Combo_citaid_Gamoauthtoken = "" ;
      Combo_citaid_Ddointernalname = "" ;
      Combo_citaid_Titlecontrolalign = "" ;
      Combo_citaid_Dropdownoptionstype = "" ;
      Combo_citaid_Titlecontrolidtoreplace = "" ;
      Combo_citaid_Datalisttype = "" ;
      Combo_citaid_Datalistfixedvalues = "" ;
      Combo_citaid_Htmltemplate = "" ;
      Combo_citaid_Multiplevaluestype = "" ;
      Combo_citaid_Loadingdata = "" ;
      Combo_citaid_Noresultsfound = "" ;
      Combo_citaid_Emptyitemtext = "" ;
      Combo_citaid_Onlyselectedvalues = "" ;
      Combo_citaid_Selectalltext = "" ;
      Combo_citaid_Multiplevaluesseparator = "" ;
      Combo_citaid_Addnewoptiontext = "" ;
      Combo_disponibilidadid_Objectcall = "" ;
      Combo_disponibilidadid_Class = "" ;
      Combo_disponibilidadid_Icontype = "" ;
      Combo_disponibilidadid_Icon = "" ;
      Combo_disponibilidadid_Tooltip = "" ;
      Combo_disponibilidadid_Selectedvalue_set = "" ;
      Combo_disponibilidadid_Selectedtext_set = "" ;
      Combo_disponibilidadid_Selectedtext_get = "" ;
      Combo_disponibilidadid_Gamoauthtoken = "" ;
      Combo_disponibilidadid_Ddointernalname = "" ;
      Combo_disponibilidadid_Titlecontrolalign = "" ;
      Combo_disponibilidadid_Dropdownoptionstype = "" ;
      Combo_disponibilidadid_Titlecontrolidtoreplace = "" ;
      Combo_disponibilidadid_Datalisttype = "" ;
      Combo_disponibilidadid_Datalistfixedvalues = "" ;
      Combo_disponibilidadid_Htmltemplate = "" ;
      Combo_disponibilidadid_Multiplevaluestype = "" ;
      Combo_disponibilidadid_Loadingdata = "" ;
      Combo_disponibilidadid_Noresultsfound = "" ;
      Combo_disponibilidadid_Emptyitemtext = "" ;
      Combo_disponibilidadid_Onlyselectedvalues = "" ;
      Combo_disponibilidadid_Selectalltext = "" ;
      Combo_disponibilidadid_Multiplevaluesseparator = "" ;
      Combo_disponibilidadid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode38 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV12WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV8TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9WebSession = httpContext.getWebSession();
      AV11TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV18Combo_DataJson = "" ;
      AV16ComboSelectedValue = "" ;
      AV17ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z256PagoNubefactRequest = "" ;
      Z257PagoNubefactResponse = "" ;
      Z308PagoRequest = "" ;
      Z309PagoResponse = "" ;
      Z64CitaCode = "" ;
      Z66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      T000T5_A21SGCitaDisponibilidadId = new int[1] ;
      T000T5_A64CitaCode = new String[] {""} ;
      T000T6_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000T6_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000T7_A21SGCitaDisponibilidadId = new int[1] ;
      T000T7_A47PagoId = new int[1] ;
      T000T7_A64CitaCode = new String[] {""} ;
      T000T7_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000T7_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000T7_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000T7_A243PagoToken = new String[] {""} ;
      T000T7_A247PagoTipoDocumentoCliente = new String[] {""} ;
      T000T7_A248PagoClienteNroDocumento = new String[] {""} ;
      T000T7_A249PagoClienteDenominacion = new String[] {""} ;
      T000T7_A250PagoClienteDireccion = new String[] {""} ;
      T000T7_A251PagoClienteEmail = new String[] {""} ;
      T000T7_A244PagoTipoDocumento = new short[1] ;
      T000T7_A245PagoNumero = new int[1] ;
      T000T7_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      T000T7_A253PagoMoneda = new short[1] ;
      T000T7_A256PagoNubefactRequest = new String[] {""} ;
      T000T7_A257PagoNubefactResponse = new String[] {""} ;
      T000T7_A308PagoRequest = new String[] {""} ;
      T000T7_A309PagoResponse = new String[] {""} ;
      T000T7_A310PagoPasarelaId = new String[] {""} ;
      T000T7_A311PagoStatusCode = new int[1] ;
      T000T7_A338PagoEnlacePDF = new String[] {""} ;
      T000T7_A339PagoEnlaceXML = new String[] {""} ;
      T000T7_A246PagoEstadoR = new String[] {""} ;
      T000T7_A34DisponibilidadId = new int[1] ;
      T000T7_n34DisponibilidadId = new boolean[] {false} ;
      T000T7_A19CitaId = new int[1] ;
      T000T7_n19CitaId = new boolean[] {false} ;
      T000T4_A34DisponibilidadId = new int[1] ;
      T000T4_n34DisponibilidadId = new boolean[] {false} ;
      T000T8_A21SGCitaDisponibilidadId = new int[1] ;
      T000T8_A64CitaCode = new String[] {""} ;
      T000T9_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000T9_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000T10_A34DisponibilidadId = new int[1] ;
      T000T10_n34DisponibilidadId = new boolean[] {false} ;
      T000T11_A47PagoId = new int[1] ;
      T000T3_A47PagoId = new int[1] ;
      T000T3_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000T3_A243PagoToken = new String[] {""} ;
      T000T3_A247PagoTipoDocumentoCliente = new String[] {""} ;
      T000T3_A248PagoClienteNroDocumento = new String[] {""} ;
      T000T3_A249PagoClienteDenominacion = new String[] {""} ;
      T000T3_A250PagoClienteDireccion = new String[] {""} ;
      T000T3_A251PagoClienteEmail = new String[] {""} ;
      T000T3_A244PagoTipoDocumento = new short[1] ;
      T000T3_A245PagoNumero = new int[1] ;
      T000T3_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      T000T3_A253PagoMoneda = new short[1] ;
      T000T3_A256PagoNubefactRequest = new String[] {""} ;
      T000T3_A257PagoNubefactResponse = new String[] {""} ;
      T000T3_A308PagoRequest = new String[] {""} ;
      T000T3_A309PagoResponse = new String[] {""} ;
      T000T3_A310PagoPasarelaId = new String[] {""} ;
      T000T3_A311PagoStatusCode = new int[1] ;
      T000T3_A338PagoEnlacePDF = new String[] {""} ;
      T000T3_A339PagoEnlaceXML = new String[] {""} ;
      T000T3_A246PagoEstadoR = new String[] {""} ;
      T000T3_A34DisponibilidadId = new int[1] ;
      T000T3_n34DisponibilidadId = new boolean[] {false} ;
      T000T3_A19CitaId = new int[1] ;
      T000T3_n19CitaId = new boolean[] {false} ;
      T000T12_A47PagoId = new int[1] ;
      T000T13_A47PagoId = new int[1] ;
      T000T2_A47PagoId = new int[1] ;
      T000T2_A242PagoMonto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000T2_A243PagoToken = new String[] {""} ;
      T000T2_A247PagoTipoDocumentoCliente = new String[] {""} ;
      T000T2_A248PagoClienteNroDocumento = new String[] {""} ;
      T000T2_A249PagoClienteDenominacion = new String[] {""} ;
      T000T2_A250PagoClienteDireccion = new String[] {""} ;
      T000T2_A251PagoClienteEmail = new String[] {""} ;
      T000T2_A244PagoTipoDocumento = new short[1] ;
      T000T2_A245PagoNumero = new int[1] ;
      T000T2_A252PagoFechaEmision = new java.util.Date[] {GXutil.nullDate()} ;
      T000T2_A253PagoMoneda = new short[1] ;
      T000T2_A256PagoNubefactRequest = new String[] {""} ;
      T000T2_A257PagoNubefactResponse = new String[] {""} ;
      T000T2_A308PagoRequest = new String[] {""} ;
      T000T2_A309PagoResponse = new String[] {""} ;
      T000T2_A310PagoPasarelaId = new String[] {""} ;
      T000T2_A311PagoStatusCode = new int[1] ;
      T000T2_A338PagoEnlacePDF = new String[] {""} ;
      T000T2_A339PagoEnlaceXML = new String[] {""} ;
      T000T2_A246PagoEstadoR = new String[] {""} ;
      T000T2_A34DisponibilidadId = new int[1] ;
      T000T2_n34DisponibilidadId = new boolean[] {false} ;
      T000T2_A19CitaId = new int[1] ;
      T000T2_n19CitaId = new boolean[] {false} ;
      T000T14_A47PagoId = new int[1] ;
      T000T17_A21SGCitaDisponibilidadId = new int[1] ;
      T000T17_A64CitaCode = new String[] {""} ;
      T000T18_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000T18_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000T19_A47PagoId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000T20_A34DisponibilidadId = new int[1] ;
      T000T20_n34DisponibilidadId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pago__default(),
         new Object[] {
             new Object[] {
            T000T2_A47PagoId, T000T2_A242PagoMonto, T000T2_A243PagoToken, T000T2_A247PagoTipoDocumentoCliente, T000T2_A248PagoClienteNroDocumento, T000T2_A249PagoClienteDenominacion, T000T2_A250PagoClienteDireccion, T000T2_A251PagoClienteEmail, T000T2_A244PagoTipoDocumento, T000T2_A245PagoNumero,
            T000T2_A252PagoFechaEmision, T000T2_A253PagoMoneda, T000T2_A256PagoNubefactRequest, T000T2_A257PagoNubefactResponse, T000T2_A308PagoRequest, T000T2_A309PagoResponse, T000T2_A310PagoPasarelaId, T000T2_A311PagoStatusCode, T000T2_A338PagoEnlacePDF, T000T2_A339PagoEnlaceXML,
            T000T2_A246PagoEstadoR, T000T2_A34DisponibilidadId, T000T2_n34DisponibilidadId, T000T2_A19CitaId, T000T2_n19CitaId
            }
            , new Object[] {
            T000T3_A47PagoId, T000T3_A242PagoMonto, T000T3_A243PagoToken, T000T3_A247PagoTipoDocumentoCliente, T000T3_A248PagoClienteNroDocumento, T000T3_A249PagoClienteDenominacion, T000T3_A250PagoClienteDireccion, T000T3_A251PagoClienteEmail, T000T3_A244PagoTipoDocumento, T000T3_A245PagoNumero,
            T000T3_A252PagoFechaEmision, T000T3_A253PagoMoneda, T000T3_A256PagoNubefactRequest, T000T3_A257PagoNubefactResponse, T000T3_A308PagoRequest, T000T3_A309PagoResponse, T000T3_A310PagoPasarelaId, T000T3_A311PagoStatusCode, T000T3_A338PagoEnlacePDF, T000T3_A339PagoEnlaceXML,
            T000T3_A246PagoEstadoR, T000T3_A34DisponibilidadId, T000T3_n34DisponibilidadId, T000T3_A19CitaId, T000T3_n19CitaId
            }
            , new Object[] {
            T000T4_A34DisponibilidadId
            }
            , new Object[] {
            T000T5_A21SGCitaDisponibilidadId, T000T5_A64CitaCode
            }
            , new Object[] {
            T000T6_A66SGCitaDisponibilidadFecha, T000T6_n66SGCitaDisponibilidadFecha
            }
            , new Object[] {
            T000T7_A21SGCitaDisponibilidadId, T000T7_A47PagoId, T000T7_A64CitaCode, T000T7_A66SGCitaDisponibilidadFecha, T000T7_n66SGCitaDisponibilidadFecha, T000T7_A242PagoMonto, T000T7_A243PagoToken, T000T7_A247PagoTipoDocumentoCliente, T000T7_A248PagoClienteNroDocumento, T000T7_A249PagoClienteDenominacion,
            T000T7_A250PagoClienteDireccion, T000T7_A251PagoClienteEmail, T000T7_A244PagoTipoDocumento, T000T7_A245PagoNumero, T000T7_A252PagoFechaEmision, T000T7_A253PagoMoneda, T000T7_A256PagoNubefactRequest, T000T7_A257PagoNubefactResponse, T000T7_A308PagoRequest, T000T7_A309PagoResponse,
            T000T7_A310PagoPasarelaId, T000T7_A311PagoStatusCode, T000T7_A338PagoEnlacePDF, T000T7_A339PagoEnlaceXML, T000T7_A246PagoEstadoR, T000T7_A34DisponibilidadId, T000T7_n34DisponibilidadId, T000T7_A19CitaId, T000T7_n19CitaId
            }
            , new Object[] {
            T000T8_A21SGCitaDisponibilidadId, T000T8_A64CitaCode
            }
            , new Object[] {
            T000T9_A66SGCitaDisponibilidadFecha, T000T9_n66SGCitaDisponibilidadFecha
            }
            , new Object[] {
            T000T10_A34DisponibilidadId
            }
            , new Object[] {
            T000T11_A47PagoId
            }
            , new Object[] {
            T000T12_A47PagoId
            }
            , new Object[] {
            T000T13_A47PagoId
            }
            , new Object[] {
            T000T14_A47PagoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000T17_A21SGCitaDisponibilidadId, T000T17_A64CitaCode
            }
            , new Object[] {
            T000T18_A66SGCitaDisponibilidadFecha, T000T18_n66SGCitaDisponibilidadFecha
            }
            , new Object[] {
            T000T19_A47PagoId
            }
            , new Object[] {
            T000T20_A34DisponibilidadId
            }
         }
      );
      AV24Pgmname = "Pago" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z244PagoTipoDocumento ;
   private short Z253PagoMoneda ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A244PagoTipoDocumento ;
   private short A253PagoMoneda ;
   private short RcdFound38 ;
   private short nIsDirty_38 ;
   private int wcpOAV20PagoId ;
   private int Z47PagoId ;
   private int Z245PagoNumero ;
   private int Z311PagoStatusCode ;
   private int Z34DisponibilidadId ;
   private int Z19CitaId ;
   private int N19CitaId ;
   private int N34DisponibilidadId ;
   private int A19CitaId ;
   private int A21SGCitaDisponibilidadId ;
   private int A34DisponibilidadId ;
   private int AV20PagoId ;
   private int trnEnded ;
   private int A47PagoId ;
   private int edtPagoId_Enabled ;
   private int edtCitaId_Visible ;
   private int edtCitaId_Enabled ;
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
   private int edtDisponibilidadId_Visible ;
   private int edtDisponibilidadId_Enabled ;
   private int edtPagoEnlacePDF_Enabled ;
   private int edtPagoEnlaceXML_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV19ComboCitaId ;
   private int edtavCombocitaid_Enabled ;
   private int edtavCombocitaid_Visible ;
   private int AV23ComboDisponibilidadId ;
   private int edtavCombodisponibilidadid_Enabled ;
   private int edtavCombodisponibilidadid_Visible ;
   private int AV10Insert_CitaId ;
   private int AV21Insert_DisponibilidadId ;
   private int Combo_citaid_Datalistupdateminimumcharacters ;
   private int Combo_disponibilidadid_Datalistupdateminimumcharacters ;
   private int AV25GXV1 ;
   private int GX_JID ;
   private int Z21SGCitaDisponibilidadId ;
   private int idxLst ;
   private java.math.BigDecimal Z242PagoMonto ;
   private java.math.BigDecimal A242PagoMonto ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z247PagoTipoDocumentoCliente ;
   private String Z246PagoEstadoR ;
   private String Combo_disponibilidadid_Selectedvalue_get ;
   private String Combo_citaid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCitaId_Internalname ;
   private String A247PagoTipoDocumentoCliente ;
   private String A246PagoEstadoR ;
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
   private String edtPagoId_Internalname ;
   private String edtPagoId_Jsonclick ;
   private String divTablesplittedcitaid_Internalname ;
   private String lblTextblockcitaid_Internalname ;
   private String lblTextblockcitaid_Jsonclick ;
   private String Combo_citaid_Caption ;
   private String Combo_citaid_Cls ;
   private String Combo_citaid_Datalistproc ;
   private String Combo_citaid_Datalistprocparametersprefix ;
   private String Combo_citaid_Internalname ;
   private String TempTags ;
   private String edtCitaId_Jsonclick ;
   private String edtCitaCode_Internalname ;
   private String edtCitaCode_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtPagoMonto_Internalname ;
   private String edtPagoMonto_Jsonclick ;
   private String edtPagoToken_Internalname ;
   private String edtPagoToken_Jsonclick ;
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
   private String edtPagoNubefactResponse_Internalname ;
   private String edtPagoRequest_Internalname ;
   private String edtPagoResponse_Internalname ;
   private String edtPagoPasarelaId_Internalname ;
   private String edtPagoPasarelaId_Jsonclick ;
   private String edtPagoStatusCode_Internalname ;
   private String edtPagoStatusCode_Jsonclick ;
   private String divTablesplitteddisponibilidadid_Internalname ;
   private String lblTextblockdisponibilidadid_Internalname ;
   private String lblTextblockdisponibilidadid_Jsonclick ;
   private String Combo_disponibilidadid_Caption ;
   private String Combo_disponibilidadid_Cls ;
   private String Combo_disponibilidadid_Datalistproc ;
   private String Combo_disponibilidadid_Datalistprocparametersprefix ;
   private String Combo_disponibilidadid_Internalname ;
   private String edtDisponibilidadId_Internalname ;
   private String edtDisponibilidadId_Jsonclick ;
   private String edtPagoEnlacePDF_Internalname ;
   private String edtPagoEnlacePDF_Jsonclick ;
   private String edtPagoEnlaceXML_Internalname ;
   private String edtPagoEnlaceXML_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_citaid_Internalname ;
   private String edtavCombocitaid_Internalname ;
   private String edtavCombocitaid_Jsonclick ;
   private String divSectionattribute_disponibilidadid_Internalname ;
   private String edtavCombodisponibilidadid_Internalname ;
   private String edtavCombodisponibilidadid_Jsonclick ;
   private String AV24Pgmname ;
   private String Combo_citaid_Objectcall ;
   private String Combo_citaid_Class ;
   private String Combo_citaid_Icontype ;
   private String Combo_citaid_Icon ;
   private String Combo_citaid_Tooltip ;
   private String Combo_citaid_Selectedvalue_set ;
   private String Combo_citaid_Selectedtext_set ;
   private String Combo_citaid_Selectedtext_get ;
   private String Combo_citaid_Gamoauthtoken ;
   private String Combo_citaid_Ddointernalname ;
   private String Combo_citaid_Titlecontrolalign ;
   private String Combo_citaid_Dropdownoptionstype ;
   private String Combo_citaid_Titlecontrolidtoreplace ;
   private String Combo_citaid_Datalisttype ;
   private String Combo_citaid_Datalistfixedvalues ;
   private String Combo_citaid_Htmltemplate ;
   private String Combo_citaid_Multiplevaluestype ;
   private String Combo_citaid_Loadingdata ;
   private String Combo_citaid_Noresultsfound ;
   private String Combo_citaid_Emptyitemtext ;
   private String Combo_citaid_Onlyselectedvalues ;
   private String Combo_citaid_Selectalltext ;
   private String Combo_citaid_Multiplevaluesseparator ;
   private String Combo_citaid_Addnewoptiontext ;
   private String Combo_disponibilidadid_Objectcall ;
   private String Combo_disponibilidadid_Class ;
   private String Combo_disponibilidadid_Icontype ;
   private String Combo_disponibilidadid_Icon ;
   private String Combo_disponibilidadid_Tooltip ;
   private String Combo_disponibilidadid_Selectedvalue_set ;
   private String Combo_disponibilidadid_Selectedtext_set ;
   private String Combo_disponibilidadid_Selectedtext_get ;
   private String Combo_disponibilidadid_Gamoauthtoken ;
   private String Combo_disponibilidadid_Ddointernalname ;
   private String Combo_disponibilidadid_Titlecontrolalign ;
   private String Combo_disponibilidadid_Dropdownoptionstype ;
   private String Combo_disponibilidadid_Titlecontrolidtoreplace ;
   private String Combo_disponibilidadid_Datalisttype ;
   private String Combo_disponibilidadid_Datalistfixedvalues ;
   private String Combo_disponibilidadid_Htmltemplate ;
   private String Combo_disponibilidadid_Multiplevaluestype ;
   private String Combo_disponibilidadid_Loadingdata ;
   private String Combo_disponibilidadid_Noresultsfound ;
   private String Combo_disponibilidadid_Emptyitemtext ;
   private String Combo_disponibilidadid_Onlyselectedvalues ;
   private String Combo_disponibilidadid_Selectalltext ;
   private String Combo_disponibilidadid_Multiplevaluesseparator ;
   private String Combo_disponibilidadid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode38 ;
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
   private java.util.Date Z252PagoFechaEmision ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date A252PagoFechaEmision ;
   private java.util.Date Z66SGCitaDisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n19CitaId ;
   private boolean n34DisponibilidadId ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_citaid_Enabled ;
   private boolean Combo_citaid_Visible ;
   private boolean Combo_citaid_Allowmultipleselection ;
   private boolean Combo_citaid_Isgriditem ;
   private boolean Combo_citaid_Hasdescription ;
   private boolean Combo_citaid_Includeonlyselectedoption ;
   private boolean Combo_citaid_Includeselectalloption ;
   private boolean Combo_citaid_Emptyitem ;
   private boolean Combo_citaid_Includeaddnewoption ;
   private boolean Combo_disponibilidadid_Enabled ;
   private boolean Combo_disponibilidadid_Visible ;
   private boolean Combo_disponibilidadid_Allowmultipleselection ;
   private boolean Combo_disponibilidadid_Isgriditem ;
   private boolean Combo_disponibilidadid_Hasdescription ;
   private boolean Combo_disponibilidadid_Includeonlyselectedoption ;
   private boolean Combo_disponibilidadid_Includeselectalloption ;
   private boolean Combo_disponibilidadid_Emptyitem ;
   private boolean Combo_disponibilidadid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean returnInSub ;
   private boolean AV7IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String A256PagoNubefactRequest ;
   private String A257PagoNubefactResponse ;
   private String A308PagoRequest ;
   private String A309PagoResponse ;
   private String AV18Combo_DataJson ;
   private String Z256PagoNubefactRequest ;
   private String Z257PagoNubefactResponse ;
   private String Z308PagoRequest ;
   private String Z309PagoResponse ;
   private String Z243PagoToken ;
   private String Z248PagoClienteNroDocumento ;
   private String Z249PagoClienteDenominacion ;
   private String Z250PagoClienteDireccion ;
   private String Z251PagoClienteEmail ;
   private String Z310PagoPasarelaId ;
   private String Z338PagoEnlacePDF ;
   private String Z339PagoEnlaceXML ;
   private String A64CitaCode ;
   private String A243PagoToken ;
   private String A248PagoClienteNroDocumento ;
   private String A249PagoClienteDenominacion ;
   private String A250PagoClienteDireccion ;
   private String A251PagoClienteEmail ;
   private String A310PagoPasarelaId ;
   private String A338PagoEnlacePDF ;
   private String A339PagoEnlaceXML ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private String Z64CitaCode ;
   private com.genexus.webpanels.WebSession AV9WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_citaid ;
   private com.genexus.webpanels.GXUserControl ucCombo_disponibilidadid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPagoTipoDocumentoCliente ;
   private HTMLChoice cmbPagoTipoDocumento ;
   private HTMLChoice cmbPagoMoneda ;
   private HTMLChoice cmbPagoEstadoR ;
   private IDataStoreProvider pr_default ;
   private int[] T000T5_A21SGCitaDisponibilidadId ;
   private String[] T000T5_A64CitaCode ;
   private java.util.Date[] T000T6_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000T6_n66SGCitaDisponibilidadFecha ;
   private int[] T000T7_A21SGCitaDisponibilidadId ;
   private int[] T000T7_A47PagoId ;
   private String[] T000T7_A64CitaCode ;
   private java.util.Date[] T000T7_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000T7_n66SGCitaDisponibilidadFecha ;
   private java.math.BigDecimal[] T000T7_A242PagoMonto ;
   private String[] T000T7_A243PagoToken ;
   private String[] T000T7_A247PagoTipoDocumentoCliente ;
   private String[] T000T7_A248PagoClienteNroDocumento ;
   private String[] T000T7_A249PagoClienteDenominacion ;
   private String[] T000T7_A250PagoClienteDireccion ;
   private String[] T000T7_A251PagoClienteEmail ;
   private short[] T000T7_A244PagoTipoDocumento ;
   private int[] T000T7_A245PagoNumero ;
   private java.util.Date[] T000T7_A252PagoFechaEmision ;
   private short[] T000T7_A253PagoMoneda ;
   private String[] T000T7_A256PagoNubefactRequest ;
   private String[] T000T7_A257PagoNubefactResponse ;
   private String[] T000T7_A308PagoRequest ;
   private String[] T000T7_A309PagoResponse ;
   private String[] T000T7_A310PagoPasarelaId ;
   private int[] T000T7_A311PagoStatusCode ;
   private String[] T000T7_A338PagoEnlacePDF ;
   private String[] T000T7_A339PagoEnlaceXML ;
   private String[] T000T7_A246PagoEstadoR ;
   private int[] T000T7_A34DisponibilidadId ;
   private boolean[] T000T7_n34DisponibilidadId ;
   private int[] T000T7_A19CitaId ;
   private boolean[] T000T7_n19CitaId ;
   private int[] T000T4_A34DisponibilidadId ;
   private boolean[] T000T4_n34DisponibilidadId ;
   private int[] T000T8_A21SGCitaDisponibilidadId ;
   private String[] T000T8_A64CitaCode ;
   private java.util.Date[] T000T9_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000T9_n66SGCitaDisponibilidadFecha ;
   private int[] T000T10_A34DisponibilidadId ;
   private boolean[] T000T10_n34DisponibilidadId ;
   private int[] T000T11_A47PagoId ;
   private int[] T000T3_A47PagoId ;
   private java.math.BigDecimal[] T000T3_A242PagoMonto ;
   private String[] T000T3_A243PagoToken ;
   private String[] T000T3_A247PagoTipoDocumentoCliente ;
   private String[] T000T3_A248PagoClienteNroDocumento ;
   private String[] T000T3_A249PagoClienteDenominacion ;
   private String[] T000T3_A250PagoClienteDireccion ;
   private String[] T000T3_A251PagoClienteEmail ;
   private short[] T000T3_A244PagoTipoDocumento ;
   private int[] T000T3_A245PagoNumero ;
   private java.util.Date[] T000T3_A252PagoFechaEmision ;
   private short[] T000T3_A253PagoMoneda ;
   private String[] T000T3_A256PagoNubefactRequest ;
   private String[] T000T3_A257PagoNubefactResponse ;
   private String[] T000T3_A308PagoRequest ;
   private String[] T000T3_A309PagoResponse ;
   private String[] T000T3_A310PagoPasarelaId ;
   private int[] T000T3_A311PagoStatusCode ;
   private String[] T000T3_A338PagoEnlacePDF ;
   private String[] T000T3_A339PagoEnlaceXML ;
   private String[] T000T3_A246PagoEstadoR ;
   private int[] T000T3_A34DisponibilidadId ;
   private boolean[] T000T3_n34DisponibilidadId ;
   private int[] T000T3_A19CitaId ;
   private boolean[] T000T3_n19CitaId ;
   private int[] T000T12_A47PagoId ;
   private int[] T000T13_A47PagoId ;
   private int[] T000T2_A47PagoId ;
   private java.math.BigDecimal[] T000T2_A242PagoMonto ;
   private String[] T000T2_A243PagoToken ;
   private String[] T000T2_A247PagoTipoDocumentoCliente ;
   private String[] T000T2_A248PagoClienteNroDocumento ;
   private String[] T000T2_A249PagoClienteDenominacion ;
   private String[] T000T2_A250PagoClienteDireccion ;
   private String[] T000T2_A251PagoClienteEmail ;
   private short[] T000T2_A244PagoTipoDocumento ;
   private int[] T000T2_A245PagoNumero ;
   private java.util.Date[] T000T2_A252PagoFechaEmision ;
   private short[] T000T2_A253PagoMoneda ;
   private String[] T000T2_A256PagoNubefactRequest ;
   private String[] T000T2_A257PagoNubefactResponse ;
   private String[] T000T2_A308PagoRequest ;
   private String[] T000T2_A309PagoResponse ;
   private String[] T000T2_A310PagoPasarelaId ;
   private int[] T000T2_A311PagoStatusCode ;
   private String[] T000T2_A338PagoEnlacePDF ;
   private String[] T000T2_A339PagoEnlaceXML ;
   private String[] T000T2_A246PagoEstadoR ;
   private int[] T000T2_A34DisponibilidadId ;
   private boolean[] T000T2_n34DisponibilidadId ;
   private int[] T000T2_A19CitaId ;
   private boolean[] T000T2_n19CitaId ;
   private int[] T000T14_A47PagoId ;
   private int[] T000T17_A21SGCitaDisponibilidadId ;
   private String[] T000T17_A64CitaCode ;
   private java.util.Date[] T000T18_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000T18_n66SGCitaDisponibilidadFecha ;
   private int[] T000T19_A47PagoId ;
   private int[] T000T20_A34DisponibilidadId ;
   private boolean[] T000T20_n34DisponibilidadId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14CitaId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22DisponibilidadId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV8TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV11TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class pago__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000T2", "SELECT [PagoId], [PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId] FROM [Pago] WITH (UPDLOCK) WHERE [PagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T3", "SELECT [PagoId], [PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId] FROM [Pago] WHERE [PagoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T4", "SELECT [DisponibilidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T5", "SELECT [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, [CitaCode] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T6", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T7", "SELECT T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, TM1.[PagoId], T2.[CitaCode], T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, TM1.[PagoMonto], TM1.[PagoToken], TM1.[PagoTipoDocumentoCliente], TM1.[PagoClienteNroDocumento], TM1.[PagoClienteDenominacion], TM1.[PagoClienteDireccion], TM1.[PagoClienteEmail], TM1.[PagoTipoDocumento], TM1.[PagoNumero], TM1.[PagoFechaEmision], TM1.[PagoMoneda], TM1.[PagoNubefactRequest], TM1.[PagoNubefactResponse], TM1.[PagoRequest], TM1.[PagoResponse], TM1.[PagoPasarelaId], TM1.[PagoStatusCode], TM1.[PagoEnlacePDF], TM1.[PagoEnlaceXML], TM1.[PagoEstadoR], TM1.[DisponibilidadId], TM1.[CitaId] FROM (([Pago] TM1 LEFT JOIN [Cita] T2 ON T2.[CitaId] = TM1.[CitaId]) LEFT JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) WHERE TM1.[PagoId] = ? ORDER BY TM1.[PagoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T8", "SELECT [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, [CitaCode] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T9", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T10", "SELECT [DisponibilidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T11", "SELECT [PagoId] FROM [Pago] WHERE [PagoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T12", "SELECT TOP 1 [PagoId] FROM [Pago] WHERE ( [PagoId] > ?) ORDER BY [PagoId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000T13", "SELECT TOP 1 [PagoId] FROM [Pago] WHERE ( [PagoId] < ?) ORDER BY [PagoId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000T14", "INSERT INTO [Pago]([PagoMonto], [PagoToken], [PagoTipoDocumentoCliente], [PagoClienteNroDocumento], [PagoClienteDenominacion], [PagoClienteDireccion], [PagoClienteEmail], [PagoTipoDocumento], [PagoNumero], [PagoFechaEmision], [PagoMoneda], [PagoNubefactRequest], [PagoNubefactResponse], [PagoRequest], [PagoResponse], [PagoPasarelaId], [PagoStatusCode], [PagoEnlacePDF], [PagoEnlaceXML], [PagoEstadoR], [DisponibilidadId], [CitaId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000T15", "UPDATE [Pago] SET [PagoMonto]=?, [PagoToken]=?, [PagoTipoDocumentoCliente]=?, [PagoClienteNroDocumento]=?, [PagoClienteDenominacion]=?, [PagoClienteDireccion]=?, [PagoClienteEmail]=?, [PagoTipoDocumento]=?, [PagoNumero]=?, [PagoFechaEmision]=?, [PagoMoneda]=?, [PagoNubefactRequest]=?, [PagoNubefactResponse]=?, [PagoRequest]=?, [PagoResponse]=?, [PagoPasarelaId]=?, [PagoStatusCode]=?, [PagoEnlacePDF]=?, [PagoEnlaceXML]=?, [PagoEstadoR]=?, [DisponibilidadId]=?, [CitaId]=?  WHERE [PagoId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000T16", "DELETE FROM [Pago]  WHERE [PagoId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000T17", "SELECT [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, [CitaCode] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T18", "SELECT [DisponibilidadFecha] AS SGCitaDisponibilidadFecha FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T19", "SELECT [PagoId] FROM [Pago] ORDER BY [PagoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000T20", "SELECT [DisponibilidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(23);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[13])[0] = rslt.getLongVarchar(14);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[15])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((int[]) buf[17])[0] = rslt.getInt(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((int[]) buf[23])[0] = rslt.getInt(23);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((int[]) buf[13])[0] = rslt.getInt(13);
               ((java.util.Date[]) buf[14])[0] = rslt.getGXDate(14);
               ((short[]) buf[15])[0] = rslt.getShort(15);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(16);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(17);
               ((String[]) buf[18])[0] = rslt.getLongVarchar(18);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(19);
               ((String[]) buf[20])[0] = rslt.getVarchar(20);
               ((int[]) buf[21])[0] = rslt.getInt(21);
               ((String[]) buf[22])[0] = rslt.getVarchar(22);
               ((String[]) buf[23])[0] = rslt.getVarchar(23);
               ((String[]) buf[24])[0] = rslt.getString(24, 1);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((int[]) buf[27])[0] = rslt.getInt(26);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 16 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setVarchar(7, (String)parms[6], 100, false);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setNLongVarchar(14, (String)parms[13], false);
               stmt.setNLongVarchar(15, (String)parms[14], false);
               stmt.setVarchar(16, (String)parms[15], 100, false);
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setVarchar(19, (String)parms[18], 1000, false);
               stmt.setString(20, (String)parms[19], 1);
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(21, ((Number) parms[21]).intValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(22, ((Number) parms[23]).intValue());
               }
               return;
            case 13 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               stmt.setVarchar(7, (String)parms[6], 100, false);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setNLongVarchar(12, (String)parms[11], false);
               stmt.setNLongVarchar(13, (String)parms[12], false);
               stmt.setNLongVarchar(14, (String)parms[13], false);
               stmt.setNLongVarchar(15, (String)parms[14], false);
               stmt.setVarchar(16, (String)parms[15], 100, false);
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setVarchar(19, (String)parms[18], 1000, false);
               stmt.setString(20, (String)parms[19], 1);
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(21, ((Number) parms[21]).intValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(22, ((Number) parms[23]).intValue());
               }
               stmt.setInt(23, ((Number) parms[24]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 18 :
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

