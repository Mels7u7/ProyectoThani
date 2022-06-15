package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citaservicio_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A19CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A19CitaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A27ServicioId = (short)(GXutil.lval( httpContext.GetPar( "ServicioId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A27ServicioId) ;
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
         Form.getMeta().addItem("description", "Cita Servicio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCitaServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public citaservicio_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public citaservicio_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citaservicio_impl.class ));
   }

   public citaservicio_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbCitaServicioEstado = new HTMLChoice();
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
      if ( cmbCitaServicioEstado.getItemCount() > 0 )
      {
         A114CitaServicioEstado = cmbCitaServicioEstado.getValidValue(A114CitaServicioEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A114CitaServicioEstado", A114CitaServicioEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaServicioEstado.setValue( GXutil.rtrim( A114CitaServicioEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaServicioEstado.getInternalname(), "Values", cmbCitaServicioEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-lg-9", "left", "top", "", "", "div");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaServicioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaServicioId_Internalname, "Servicio Id", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaServicioId_Internalname, GXutil.ltrim( localUtil.ntoc( A26CitaServicioId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaServicioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A26CitaServicioId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A26CitaServicioId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaServicioId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaServicioId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedcitaid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcitaid_Internalname, "Cita Id", "", "", lblTextblockcitaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_citaid.setProperty("Caption", Combo_citaid_Caption);
      ucCombo_citaid.setProperty("Cls", Combo_citaid_Cls);
      ucCombo_citaid.setProperty("DataListProc", Combo_citaid_Datalistproc);
      ucCombo_citaid.setProperty("DataListProcParametersPrefix", Combo_citaid_Datalistprocparametersprefix);
      ucCombo_citaid.setProperty("EmptyItem", Combo_citaid_Emptyitem);
      ucCombo_citaid.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_citaid.setProperty("DropDownOptionsData", AV15CitaId_Data);
      ucCombo_citaid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_citaid_Internalname, "COMBO_CITAIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedservicioid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockservicioid_Internalname, "Servicio Id", "", "", lblTextblockservicioid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_servicioid.setProperty("Caption", Combo_servicioid_Caption);
      ucCombo_servicioid.setProperty("Cls", Combo_servicioid_Cls);
      ucCombo_servicioid.setProperty("DataListProc", Combo_servicioid_Datalistproc);
      ucCombo_servicioid.setProperty("DataListProcParametersPrefix", Combo_servicioid_Datalistprocparametersprefix);
      ucCombo_servicioid.setProperty("EmptyItem", Combo_servicioid_Emptyitem);
      ucCombo_servicioid.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_servicioid.setProperty("DropDownOptionsData", AV21ServicioId_Data);
      ucCombo_servicioid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_servicioid_Internalname, "COMBO_SERVICIOIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioId_Internalname, "Servicio Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioId_Internalname, GXutil.ltrim( localUtil.ntoc( A27ServicioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtServicioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtServicioId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaServicioFlag_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaServicioFlag_Internalname, "Servicio Flag", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaServicioFlag_Internalname, GXutil.ltrim( localUtil.ntoc( A115CitaServicioFlag, (byte)(1), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaServicioFlag_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A115CitaServicioFlag), "9") : localUtil.format( DecimalUtil.doubleToDec(A115CitaServicioFlag), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaServicioFlag_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaServicioFlag_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCitaServicioEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaServicioEstado.getInternalname(), "Servicio Estado", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaServicioEstado, cmbCitaServicioEstado.getInternalname(), GXutil.rtrim( A114CitaServicioEstado), 1, cmbCitaServicioEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaServicioEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "", true, (byte)(1), "HLP_CitaServicio.htm");
      cmbCitaServicioEstado.setValue( GXutil.rtrim( A114CitaServicioEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaServicioEstado.getInternalname(), "Values", cmbCitaServicioEstado.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "Button" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      ClassString = "BtnDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaServicio.htm");
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
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombocitaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV20ComboCitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombocitaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV20ComboCitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV20ComboCitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocitaid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavCombocitaid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaServicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_servicioid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboservicioid_Internalname, GXutil.ltrim( localUtil.ntoc( AV22ComboServicioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavComboservicioid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV22ComboServicioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV22ComboServicioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboservicioid_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavComboservicioid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaServicio.htm");
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
      e110D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCITAID_DATA"), AV15CitaId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSERVICIOID_DATA"), AV21ServicioId_Data);
            /* Read saved values. */
            Z26CitaServicioId = (int)(localUtil.ctol( httpContext.cgiGet( "Z26CitaServicioId"), ",", ".")) ;
            Z115CitaServicioFlag = (byte)(localUtil.ctol( httpContext.cgiGet( "Z115CitaServicioFlag"), ",", ".")) ;
            Z114CitaServicioEstado = httpContext.cgiGet( "Z114CitaServicioEstado") ;
            Z19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z19CitaId"), ",", ".")) ;
            Z27ServicioId = (short)(localUtil.ctol( httpContext.cgiGet( "Z27ServicioId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
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
            Combo_servicioid_Objectcall = httpContext.cgiGet( "COMBO_SERVICIOID_Objectcall") ;
            Combo_servicioid_Class = httpContext.cgiGet( "COMBO_SERVICIOID_Class") ;
            Combo_servicioid_Icontype = httpContext.cgiGet( "COMBO_SERVICIOID_Icontype") ;
            Combo_servicioid_Icon = httpContext.cgiGet( "COMBO_SERVICIOID_Icon") ;
            Combo_servicioid_Caption = httpContext.cgiGet( "COMBO_SERVICIOID_Caption") ;
            Combo_servicioid_Tooltip = httpContext.cgiGet( "COMBO_SERVICIOID_Tooltip") ;
            Combo_servicioid_Cls = httpContext.cgiGet( "COMBO_SERVICIOID_Cls") ;
            Combo_servicioid_Selectedvalue_set = httpContext.cgiGet( "COMBO_SERVICIOID_Selectedvalue_set") ;
            Combo_servicioid_Selectedvalue_get = httpContext.cgiGet( "COMBO_SERVICIOID_Selectedvalue_get") ;
            Combo_servicioid_Selectedtext_set = httpContext.cgiGet( "COMBO_SERVICIOID_Selectedtext_set") ;
            Combo_servicioid_Selectedtext_get = httpContext.cgiGet( "COMBO_SERVICIOID_Selectedtext_get") ;
            Combo_servicioid_Gamoauthtoken = httpContext.cgiGet( "COMBO_SERVICIOID_Gamoauthtoken") ;
            Combo_servicioid_Ddointernalname = httpContext.cgiGet( "COMBO_SERVICIOID_Ddointernalname") ;
            Combo_servicioid_Titlecontrolalign = httpContext.cgiGet( "COMBO_SERVICIOID_Titlecontrolalign") ;
            Combo_servicioid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SERVICIOID_Dropdownoptionstype") ;
            Combo_servicioid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Enabled")) ;
            Combo_servicioid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Visible")) ;
            Combo_servicioid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SERVICIOID_Titlecontrolidtoreplace") ;
            Combo_servicioid_Datalisttype = httpContext.cgiGet( "COMBO_SERVICIOID_Datalisttype") ;
            Combo_servicioid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Allowmultipleselection")) ;
            Combo_servicioid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SERVICIOID_Datalistfixedvalues") ;
            Combo_servicioid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Isgriditem")) ;
            Combo_servicioid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Hasdescription")) ;
            Combo_servicioid_Datalistproc = httpContext.cgiGet( "COMBO_SERVICIOID_Datalistproc") ;
            Combo_servicioid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SERVICIOID_Datalistprocparametersprefix") ;
            Combo_servicioid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SERVICIOID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_servicioid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Includeonlyselectedoption")) ;
            Combo_servicioid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Includeselectalloption")) ;
            Combo_servicioid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Emptyitem")) ;
            Combo_servicioid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOID_Includeaddnewoption")) ;
            Combo_servicioid_Htmltemplate = httpContext.cgiGet( "COMBO_SERVICIOID_Htmltemplate") ;
            Combo_servicioid_Multiplevaluestype = httpContext.cgiGet( "COMBO_SERVICIOID_Multiplevaluestype") ;
            Combo_servicioid_Loadingdata = httpContext.cgiGet( "COMBO_SERVICIOID_Loadingdata") ;
            Combo_servicioid_Noresultsfound = httpContext.cgiGet( "COMBO_SERVICIOID_Noresultsfound") ;
            Combo_servicioid_Emptyitemtext = httpContext.cgiGet( "COMBO_SERVICIOID_Emptyitemtext") ;
            Combo_servicioid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SERVICIOID_Onlyselectedvalues") ;
            Combo_servicioid_Selectalltext = httpContext.cgiGet( "COMBO_SERVICIOID_Selectalltext") ;
            Combo_servicioid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SERVICIOID_Multiplevaluesseparator") ;
            Combo_servicioid_Addnewoptiontext = httpContext.cgiGet( "COMBO_SERVICIOID_Addnewoptiontext") ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCitaServicioId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCitaServicioId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITASERVICIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaServicioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A26CitaServicioId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
            }
            else
            {
               A26CitaServicioId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaServicioId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A19CitaId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            }
            else
            {
               A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtServicioId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtServicioId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SERVICIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtServicioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A27ServicioId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
            }
            else
            {
               A27ServicioId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCitaServicioFlag_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCitaServicioFlag_Internalname), ",", ".") > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITASERVICIOFLAG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaServicioFlag_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A115CitaServicioFlag = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A115CitaServicioFlag", GXutil.str( A115CitaServicioFlag, 1, 0));
            }
            else
            {
               A115CitaServicioFlag = (byte)(localUtil.ctol( httpContext.cgiGet( edtCitaServicioFlag_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A115CitaServicioFlag", GXutil.str( A115CitaServicioFlag, 1, 0));
            }
            cmbCitaServicioEstado.setValue( httpContext.cgiGet( cmbCitaServicioEstado.getInternalname()) );
            A114CitaServicioEstado = httpContext.cgiGet( cmbCitaServicioEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A114CitaServicioEstado", A114CitaServicioEstado);
            AV20ComboCitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombocitaid_Internalname), ",", ".")) ;
            AV22ComboServicioId = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboservicioid_Internalname), ",", ".")) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A26CitaServicioId = (int)(GXutil.lval( httpContext.GetPar( "CitaServicioId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons_dsp( ) ;
               standaloneModal( ) ;
            }
            else
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal( ) ;
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
                        e110D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120D2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
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
         e120D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0D20( ) ;
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
      if ( isIns( ) )
      {
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboservicioid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboservicioid_Enabled), 5, 0), true);
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtntrn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
      }
      disableAttributes0D20( ) ;
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

   public void resetCaption0D0( )
   {
   }

   public void e110D2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e120D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'LOADCOMBOSERVICIOID' Routine */
      returnInSub = false ;
   }

   public void S122( )
   {
      /* 'LOADCOMBOCITAID' Routine */
      returnInSub = false ;
   }

   public void zm0D20( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z115CitaServicioFlag = T000D3_A115CitaServicioFlag[0] ;
            Z114CitaServicioEstado = T000D3_A114CitaServicioEstado[0] ;
            Z19CitaId = T000D3_A19CitaId[0] ;
            Z27ServicioId = T000D3_A27ServicioId[0] ;
         }
         else
         {
            Z115CitaServicioFlag = A115CitaServicioFlag ;
            Z114CitaServicioEstado = A114CitaServicioEstado ;
            Z19CitaId = A19CitaId ;
            Z27ServicioId = A27ServicioId ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z26CitaServicioId = A26CitaServicioId ;
         Z115CitaServicioFlag = A115CitaServicioFlag ;
         Z114CitaServicioEstado = A114CitaServicioEstado ;
         Z19CitaId = A19CitaId ;
         Z27ServicioId = A27ServicioId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
   }

   public void load0D20( )
   {
      /* Using cursor T000D6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A115CitaServicioFlag = T000D6_A115CitaServicioFlag[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A115CitaServicioFlag", GXutil.str( A115CitaServicioFlag, 1, 0));
         A114CitaServicioEstado = T000D6_A114CitaServicioEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A114CitaServicioEstado", A114CitaServicioEstado);
         A19CitaId = T000D6_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A27ServicioId = T000D6_A27ServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
         zm0D20( -2) ;
      }
      pr_default.close(4);
      onLoadActions0D20( ) ;
   }

   public void onLoadActions0D20( )
   {
   }

   public void checkExtendedTable0D20( )
   {
      nIsDirty_20 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000D4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T000D5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Servicio'.", "ForeignKeyNotFound", 1, "SERVICIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A114CitaServicioEstado, "P") == 0 ) || ( GXutil.strcmp(A114CitaServicioEstado, "G") == 0 ) || ( GXutil.strcmp(A114CitaServicioEstado, "R") == 0 ) || ( GXutil.strcmp(A114CitaServicioEstado, "F") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Servicio Estado fuera de rango", "OutOfRange", 1, "CITASERVICIOESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCitaServicioEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0D20( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( int A19CitaId )
   {
      /* Using cursor T000D7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_4( short A27ServicioId )
   {
      /* Using cursor T000D8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Servicio'.", "ForeignKeyNotFound", 1, "SERVICIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0D20( )
   {
      /* Using cursor T000D9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound20 = (short)(1) ;
      }
      else
      {
         RcdFound20 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000D3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0D20( 2) ;
         RcdFound20 = (short)(1) ;
         A26CitaServicioId = T000D3_A26CitaServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
         A115CitaServicioFlag = T000D3_A115CitaServicioFlag[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A115CitaServicioFlag", GXutil.str( A115CitaServicioFlag, 1, 0));
         A114CitaServicioEstado = T000D3_A114CitaServicioEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A114CitaServicioEstado", A114CitaServicioEstado);
         A19CitaId = T000D3_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A27ServicioId = T000D3_A27ServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
         Z26CitaServicioId = A26CitaServicioId ;
         sMode20 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0D20( ) ;
         if ( AnyError == 1 )
         {
            RcdFound20 = (short)(0) ;
            initializeNonKey0D20( ) ;
         }
         Gx_mode = sMode20 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound20 = (short)(0) ;
         initializeNonKey0D20( ) ;
         sMode20 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode20 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0D20( ) ;
      if ( RcdFound20 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound20 = (short)(0) ;
      /* Using cursor T000D10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000D10_A26CitaServicioId[0] < A26CitaServicioId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000D10_A26CitaServicioId[0] > A26CitaServicioId ) ) )
         {
            A26CitaServicioId = T000D10_A26CitaServicioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
            RcdFound20 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound20 = (short)(0) ;
      /* Using cursor T000D11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A26CitaServicioId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000D11_A26CitaServicioId[0] > A26CitaServicioId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000D11_A26CitaServicioId[0] < A26CitaServicioId ) ) )
         {
            A26CitaServicioId = T000D11_A26CitaServicioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
            RcdFound20 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0D20( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCitaServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0D20( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound20 == 1 )
         {
            if ( A26CitaServicioId != Z26CitaServicioId )
            {
               A26CitaServicioId = Z26CitaServicioId ;
               httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CITASERVICIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaServicioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCitaServicioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0D20( ) ;
               GX_FocusControl = edtCitaServicioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A26CitaServicioId != Z26CitaServicioId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCitaServicioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0D20( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CITASERVICIOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCitaServicioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtCitaServicioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0D20( ) ;
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
   }

   public void btn_delete( )
   {
      if ( A26CitaServicioId != Z26CitaServicioId )
      {
         A26CitaServicioId = Z26CitaServicioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CITASERVICIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCitaServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CITASERVICIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0D20( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0D20( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0D20( ) ;
      if ( RcdFound20 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound20 != 0 )
         {
            scanNext0D20( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0D20( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0D20( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000D2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A26CitaServicioId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaServicio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z115CitaServicioFlag != T000D2_A115CitaServicioFlag[0] ) || ( GXutil.strcmp(Z114CitaServicioEstado, T000D2_A114CitaServicioEstado[0]) != 0 ) || ( Z19CitaId != T000D2_A19CitaId[0] ) || ( Z27ServicioId != T000D2_A27ServicioId[0] ) )
         {
            if ( Z115CitaServicioFlag != T000D2_A115CitaServicioFlag[0] )
            {
               GXutil.writeLogln("citaservicio:[seudo value changed for attri]"+"CitaServicioFlag");
               GXutil.writeLogRaw("Old: ",Z115CitaServicioFlag);
               GXutil.writeLogRaw("Current: ",T000D2_A115CitaServicioFlag[0]);
            }
            if ( GXutil.strcmp(Z114CitaServicioEstado, T000D2_A114CitaServicioEstado[0]) != 0 )
            {
               GXutil.writeLogln("citaservicio:[seudo value changed for attri]"+"CitaServicioEstado");
               GXutil.writeLogRaw("Old: ",Z114CitaServicioEstado);
               GXutil.writeLogRaw("Current: ",T000D2_A114CitaServicioEstado[0]);
            }
            if ( Z19CitaId != T000D2_A19CitaId[0] )
            {
               GXutil.writeLogln("citaservicio:[seudo value changed for attri]"+"CitaId");
               GXutil.writeLogRaw("Old: ",Z19CitaId);
               GXutil.writeLogRaw("Current: ",T000D2_A19CitaId[0]);
            }
            if ( Z27ServicioId != T000D2_A27ServicioId[0] )
            {
               GXutil.writeLogln("citaservicio:[seudo value changed for attri]"+"ServicioId");
               GXutil.writeLogRaw("Old: ",Z27ServicioId);
               GXutil.writeLogRaw("Current: ",T000D2_A27ServicioId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CitaServicio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0D20( )
   {
      beforeValidate0D20( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D20( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0D20( 0) ;
         checkOptimisticConcurrency0D20( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D20( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0D20( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000D12 */
                  pr_default.execute(10, new Object[] {Byte.valueOf(A115CitaServicioFlag), A114CitaServicioEstado, Integer.valueOf(A19CitaId), Short.valueOf(A27ServicioId)});
                  A26CitaServicioId = T000D12_A26CitaServicioId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaServicio");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0D0( ) ;
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
            load0D20( ) ;
         }
         endLevel0D20( ) ;
      }
      closeExtendedTableCursors0D20( ) ;
   }

   public void update0D20( )
   {
      beforeValidate0D20( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D20( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D20( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D20( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0D20( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000D13 */
                  pr_default.execute(11, new Object[] {Byte.valueOf(A115CitaServicioFlag), A114CitaServicioEstado, Integer.valueOf(A19CitaId), Short.valueOf(A27ServicioId), Integer.valueOf(A26CitaServicioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaServicio");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaServicio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0D20( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0D0( ) ;
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
         endLevel0D20( ) ;
      }
      closeExtendedTableCursors0D20( ) ;
   }

   public void deferredUpdate0D20( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0D20( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D20( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0D20( ) ;
         afterConfirm0D20( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0D20( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000D14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A26CitaServicioId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaServicio");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound20 == 0 )
                     {
                        initAll0D20( ) ;
                        Gx_mode = "INS" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     else
                     {
                        getByPrimaryKey( ) ;
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                     resetCaption0D0( ) ;
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
      sMode20 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0D20( ) ;
      Gx_mode = sMode20 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0D20( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0D20( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0D20( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "citaservicio");
         if ( AnyError == 0 )
         {
            confirmValues0D0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "citaservicio");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0D20( )
   {
      /* Scan By routine */
      /* Using cursor T000D15 */
      pr_default.execute(13);
      RcdFound20 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A26CitaServicioId = T000D15_A26CitaServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0D20( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound20 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound20 = (short)(1) ;
         A26CitaServicioId = T000D15_A26CitaServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
      }
   }

   public void scanEnd0D20( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0D20( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0D20( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0D20( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0D20( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0D20( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0D20( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0D20( )
   {
      edtCitaServicioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaServicioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaServicioId_Enabled), 5, 0), true);
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      edtServicioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioId_Enabled), 5, 0), true);
      edtCitaServicioFlag_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaServicioFlag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaServicioFlag_Enabled), 5, 0), true);
      cmbCitaServicioEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaServicioEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCitaServicioEstado.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0D20( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0D0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110323379", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.citaservicio", new String[] {}, new String[] {}) +"\">") ;
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
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z26CitaServicioId", GXutil.ltrim( localUtil.ntoc( Z26CitaServicioId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z115CitaServicioFlag", GXutil.ltrim( localUtil.ntoc( Z115CitaServicioFlag, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z114CitaServicioEstado", GXutil.rtrim( Z114CitaServicioEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z27ServicioId", GXutil.ltrim( localUtil.ntoc( Z27ServicioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITAID_DATA", AV15CitaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITAID_DATA", AV15CitaId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSERVICIOID_DATA", AV21ServicioId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSERVICIOID_DATA", AV21ServicioId_Data);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Objectcall", GXutil.rtrim( Combo_citaid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Cls", GXutil.rtrim( Combo_citaid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Enabled", GXutil.booltostr( Combo_citaid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistproc", GXutil.rtrim( Combo_citaid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_citaid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Emptyitem", GXutil.booltostr( Combo_citaid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOID_Objectcall", GXutil.rtrim( Combo_servicioid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOID_Cls", GXutil.rtrim( Combo_servicioid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOID_Enabled", GXutil.booltostr( Combo_servicioid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOID_Datalistproc", GXutil.rtrim( Combo_servicioid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOID_Datalistprocparametersprefix", GXutil.rtrim( Combo_servicioid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOID_Emptyitem", GXutil.booltostr( Combo_servicioid_Emptyitem));
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
      return formatLink("com.projectthani.citaservicio", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "CitaServicio" ;
   }

   public String getPgmdesc( )
   {
      return "Cita Servicio" ;
   }

   public void initializeNonKey0D20( )
   {
      A19CitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      A27ServicioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
      A115CitaServicioFlag = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A115CitaServicioFlag", GXutil.str( A115CitaServicioFlag, 1, 0));
      A114CitaServicioEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A114CitaServicioEstado", A114CitaServicioEstado);
      Z115CitaServicioFlag = (byte)(0) ;
      Z114CitaServicioEstado = "" ;
      Z19CitaId = 0 ;
      Z27ServicioId = (short)(0) ;
   }

   public void initAll0D20( )
   {
      A26CitaServicioId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A26CitaServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A26CitaServicioId), 8, 0));
      initializeNonKey0D20( ) ;
   }

   public void standaloneModalInsert( )
   {
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323396", true, true);
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
      httpContext.AddJavascriptSource("citaservicio.js", "?20225110323397", false, true);
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
      edtCitaServicioId_Internalname = "CITASERVICIOID" ;
      lblTextblockcitaid_Internalname = "TEXTBLOCKCITAID" ;
      Combo_citaid_Internalname = "COMBO_CITAID" ;
      edtCitaId_Internalname = "CITAID" ;
      divTablesplittedcitaid_Internalname = "TABLESPLITTEDCITAID" ;
      lblTextblockservicioid_Internalname = "TEXTBLOCKSERVICIOID" ;
      Combo_servicioid_Internalname = "COMBO_SERVICIOID" ;
      edtServicioId_Internalname = "SERVICIOID" ;
      divTablesplittedservicioid_Internalname = "TABLESPLITTEDSERVICIOID" ;
      edtCitaServicioFlag_Internalname = "CITASERVICIOFLAG" ;
      cmbCitaServicioEstado.setInternalname( "CITASERVICIOESTADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocitaid_Internalname = "vCOMBOCITAID" ;
      divSectionattribute_citaid_Internalname = "SECTIONATTRIBUTE_CITAID" ;
      edtavComboservicioid_Internalname = "vCOMBOSERVICIOID" ;
      divSectionattribute_servicioid_Internalname = "SECTIONATTRIBUTE_SERVICIOID" ;
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
      Combo_servicioid_Enabled = GXutil.toBoolean( -1) ;
      Combo_citaid_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Cita Servicio" );
      edtavComboservicioid_Jsonclick = "" ;
      edtavComboservicioid_Enabled = 0 ;
      edtavCombocitaid_Jsonclick = "" ;
      edtavCombocitaid_Enabled = 0 ;
      bttBtntrn_delete_Enabled = 1 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbCitaServicioEstado.setJsonclick( "" );
      cmbCitaServicioEstado.setEnabled( 1 );
      edtCitaServicioFlag_Jsonclick = "" ;
      edtCitaServicioFlag_Enabled = 1 ;
      edtServicioId_Jsonclick = "" ;
      edtServicioId_Enabled = 1 ;
      Combo_servicioid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_servicioid_Datalistprocparametersprefix = " \"ComboName\": \"ServicioId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CitaServicioId\": 0" ;
      Combo_servicioid_Datalistproc = "CitaServicioLoadDVCombo" ;
      Combo_servicioid_Cls = "ExtendedCombo Attribute" ;
      Combo_servicioid_Caption = "" ;
      edtCitaId_Jsonclick = "" ;
      edtCitaId_Enabled = 1 ;
      Combo_citaid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_citaid_Datalistprocparametersprefix = " \"ComboName\": \"CitaId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CitaServicioId\": 0" ;
      Combo_citaid_Datalistproc = "CitaServicioLoadDVCombo" ;
      Combo_citaid_Cls = "ExtendedCombo Attribute" ;
      Combo_citaid_Caption = "" ;
      edtCitaServicioId_Jsonclick = "" ;
      edtCitaServicioId_Enabled = 1 ;
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
      cmbCitaServicioEstado.setName( "CITASERVICIOESTADO" );
      cmbCitaServicioEstado.setWebtags( "" );
      cmbCitaServicioEstado.addItem("P", "Pendiente", (short)(0));
      cmbCitaServicioEstado.addItem("G", "Pagado", (short)(0));
      cmbCitaServicioEstado.addItem("R", "Rechazado", (short)(0));
      cmbCitaServicioEstado.addItem("F", "Finalizado", (short)(0));
      if ( cmbCitaServicioEstado.getItemCount() > 0 )
      {
         A114CitaServicioEstado = cmbCitaServicioEstado.getValidValue(A114CitaServicioEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A114CitaServicioEstado", A114CitaServicioEstado);
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
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

   public void valid_Citaservicioid( )
   {
      A114CitaServicioEstado = cmbCitaServicioEstado.getValue() ;
      cmbCitaServicioEstado.setValue( A114CitaServicioEstado );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbCitaServicioEstado.getItemCount() > 0 )
      {
         A114CitaServicioEstado = cmbCitaServicioEstado.getValidValue(A114CitaServicioEstado) ;
         cmbCitaServicioEstado.setValue( A114CitaServicioEstado );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaServicioEstado.setValue( GXutil.rtrim( A114CitaServicioEstado) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrim( localUtil.ntoc( A27ServicioId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A115CitaServicioFlag", GXutil.ltrim( localUtil.ntoc( A115CitaServicioFlag, (byte)(1), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A114CitaServicioEstado", GXutil.rtrim( A114CitaServicioEstado));
      cmbCitaServicioEstado.setValue( GXutil.rtrim( A114CitaServicioEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaServicioEstado.getInternalname(), "Values", cmbCitaServicioEstado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z26CitaServicioId", GXutil.ltrim( localUtil.ntoc( Z26CitaServicioId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z27ServicioId", GXutil.ltrim( localUtil.ntoc( Z27ServicioId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z115CitaServicioFlag", GXutil.ltrim( localUtil.ntoc( Z115CitaServicioFlag, (byte)(1), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z114CitaServicioEstado", GXutil.rtrim( Z114CitaServicioEstado));
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Citaid( )
   {
      /* Using cursor T000D16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Servicioid( )
   {
      /* Using cursor T000D17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Servicio'.", "ForeignKeyNotFound", 1, "SERVICIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioId_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120D2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CITASERVICIOID","{handler:'valid_Citaservicioid',iparms:[{av:'cmbCitaServicioEstado'},{av:'A114CitaServicioEstado',fld:'CITASERVICIOESTADO',pic:''},{av:'A26CitaServicioId',fld:'CITASERVICIOID',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_CITASERVICIOID",",oparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A27ServicioId',fld:'SERVICIOID',pic:'ZZZ9'},{av:'A115CitaServicioFlag',fld:'CITASERVICIOFLAG',pic:'9'},{av:'cmbCitaServicioEstado'},{av:'A114CitaServicioEstado',fld:'CITASERVICIOESTADO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z26CitaServicioId'},{av:'Z19CitaId'},{av:'Z27ServicioId'},{av:'Z115CitaServicioFlag'},{av:'Z114CitaServicioEstado'},{ctrl:'BTNTRN_DELETE',prop:'Enabled'},{ctrl:'BTNTRN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_CITAID",",oparms:[]}");
      setEventMetadata("VALID_SERVICIOID","{handler:'valid_Servicioid',iparms:[{av:'A27ServicioId',fld:'SERVICIOID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_SERVICIOID",",oparms:[]}");
      setEventMetadata("VALID_CITASERVICIOESTADO","{handler:'valid_Citaservicioestado',iparms:[]");
      setEventMetadata("VALID_CITASERVICIOESTADO",",oparms:[]}");
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
      pr_default.close(14);
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z114CitaServicioEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A114CitaServicioEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      lblTextblockcitaid_Jsonclick = "" ;
      ucCombo_citaid = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15CitaId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockservicioid_Jsonclick = "" ;
      ucCombo_servicioid = new com.genexus.webpanels.GXUserControl();
      AV21ServicioId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      Combo_citaid_Objectcall = "" ;
      Combo_citaid_Class = "" ;
      Combo_citaid_Icontype = "" ;
      Combo_citaid_Icon = "" ;
      Combo_citaid_Tooltip = "" ;
      Combo_citaid_Selectedvalue_set = "" ;
      Combo_citaid_Selectedvalue_get = "" ;
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
      Combo_servicioid_Objectcall = "" ;
      Combo_servicioid_Class = "" ;
      Combo_servicioid_Icontype = "" ;
      Combo_servicioid_Icon = "" ;
      Combo_servicioid_Tooltip = "" ;
      Combo_servicioid_Selectedvalue_set = "" ;
      Combo_servicioid_Selectedvalue_get = "" ;
      Combo_servicioid_Selectedtext_set = "" ;
      Combo_servicioid_Selectedtext_get = "" ;
      Combo_servicioid_Gamoauthtoken = "" ;
      Combo_servicioid_Ddointernalname = "" ;
      Combo_servicioid_Titlecontrolalign = "" ;
      Combo_servicioid_Dropdownoptionstype = "" ;
      Combo_servicioid_Titlecontrolidtoreplace = "" ;
      Combo_servicioid_Datalisttype = "" ;
      Combo_servicioid_Datalistfixedvalues = "" ;
      Combo_servicioid_Htmltemplate = "" ;
      Combo_servicioid_Multiplevaluestype = "" ;
      Combo_servicioid_Loadingdata = "" ;
      Combo_servicioid_Noresultsfound = "" ;
      Combo_servicioid_Emptyitemtext = "" ;
      Combo_servicioid_Onlyselectedvalues = "" ;
      Combo_servicioid_Selectalltext = "" ;
      Combo_servicioid_Multiplevaluesseparator = "" ;
      Combo_servicioid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      T000D6_A26CitaServicioId = new int[1] ;
      T000D6_A115CitaServicioFlag = new byte[1] ;
      T000D6_A114CitaServicioEstado = new String[] {""} ;
      T000D6_A19CitaId = new int[1] ;
      T000D6_A27ServicioId = new short[1] ;
      T000D4_A19CitaId = new int[1] ;
      T000D5_A27ServicioId = new short[1] ;
      T000D7_A19CitaId = new int[1] ;
      T000D8_A27ServicioId = new short[1] ;
      T000D9_A26CitaServicioId = new int[1] ;
      T000D3_A26CitaServicioId = new int[1] ;
      T000D3_A115CitaServicioFlag = new byte[1] ;
      T000D3_A114CitaServicioEstado = new String[] {""} ;
      T000D3_A19CitaId = new int[1] ;
      T000D3_A27ServicioId = new short[1] ;
      sMode20 = "" ;
      T000D10_A26CitaServicioId = new int[1] ;
      T000D11_A26CitaServicioId = new int[1] ;
      T000D2_A26CitaServicioId = new int[1] ;
      T000D2_A115CitaServicioFlag = new byte[1] ;
      T000D2_A114CitaServicioEstado = new String[] {""} ;
      T000D2_A19CitaId = new int[1] ;
      T000D2_A27ServicioId = new short[1] ;
      T000D12_A26CitaServicioId = new int[1] ;
      T000D15_A26CitaServicioId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ114CitaServicioEstado = "" ;
      T000D16_A19CitaId = new int[1] ;
      T000D17_A27ServicioId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citaservicio__default(),
         new Object[] {
             new Object[] {
            T000D2_A26CitaServicioId, T000D2_A115CitaServicioFlag, T000D2_A114CitaServicioEstado, T000D2_A19CitaId, T000D2_A27ServicioId
            }
            , new Object[] {
            T000D3_A26CitaServicioId, T000D3_A115CitaServicioFlag, T000D3_A114CitaServicioEstado, T000D3_A19CitaId, T000D3_A27ServicioId
            }
            , new Object[] {
            T000D4_A19CitaId
            }
            , new Object[] {
            T000D5_A27ServicioId
            }
            , new Object[] {
            T000D6_A26CitaServicioId, T000D6_A115CitaServicioFlag, T000D6_A114CitaServicioEstado, T000D6_A19CitaId, T000D6_A27ServicioId
            }
            , new Object[] {
            T000D7_A19CitaId
            }
            , new Object[] {
            T000D8_A27ServicioId
            }
            , new Object[] {
            T000D9_A26CitaServicioId
            }
            , new Object[] {
            T000D10_A26CitaServicioId
            }
            , new Object[] {
            T000D11_A26CitaServicioId
            }
            , new Object[] {
            T000D12_A26CitaServicioId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000D15_A26CitaServicioId
            }
            , new Object[] {
            T000D16_A19CitaId
            }
            , new Object[] {
            T000D17_A27ServicioId
            }
         }
      );
   }

   private byte Z115CitaServicioFlag ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A115CitaServicioFlag ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private byte ZZ115CitaServicioFlag ;
   private short Z27ServicioId ;
   private short A27ServicioId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV22ComboServicioId ;
   private short RcdFound20 ;
   private short nIsDirty_20 ;
   private short ZZ27ServicioId ;
   private int Z26CitaServicioId ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private int trnEnded ;
   private int A26CitaServicioId ;
   private int edtCitaServicioId_Enabled ;
   private int edtCitaId_Enabled ;
   private int edtServicioId_Enabled ;
   private int edtCitaServicioFlag_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV20ComboCitaId ;
   private int edtavCombocitaid_Enabled ;
   private int edtavComboservicioid_Enabled ;
   private int Combo_citaid_Datalistupdateminimumcharacters ;
   private int Combo_servicioid_Datalistupdateminimumcharacters ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ26CitaServicioId ;
   private int ZZ19CitaId ;
   private String sPrefix ;
   private String Z114CitaServicioEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCitaServicioId_Internalname ;
   private String A114CitaServicioEstado ;
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
   private String TempTags ;
   private String edtCitaServicioId_Jsonclick ;
   private String divTablesplittedcitaid_Internalname ;
   private String lblTextblockcitaid_Internalname ;
   private String lblTextblockcitaid_Jsonclick ;
   private String Combo_citaid_Caption ;
   private String Combo_citaid_Cls ;
   private String Combo_citaid_Datalistproc ;
   private String Combo_citaid_Datalistprocparametersprefix ;
   private String Combo_citaid_Internalname ;
   private String edtCitaId_Internalname ;
   private String edtCitaId_Jsonclick ;
   private String divTablesplittedservicioid_Internalname ;
   private String lblTextblockservicioid_Internalname ;
   private String lblTextblockservicioid_Jsonclick ;
   private String Combo_servicioid_Caption ;
   private String Combo_servicioid_Cls ;
   private String Combo_servicioid_Datalistproc ;
   private String Combo_servicioid_Datalistprocparametersprefix ;
   private String Combo_servicioid_Internalname ;
   private String edtServicioId_Internalname ;
   private String edtServicioId_Jsonclick ;
   private String edtCitaServicioFlag_Internalname ;
   private String edtCitaServicioFlag_Jsonclick ;
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
   private String divSectionattribute_servicioid_Internalname ;
   private String edtavComboservicioid_Internalname ;
   private String edtavComboservicioid_Jsonclick ;
   private String Gx_mode ;
   private String Combo_citaid_Objectcall ;
   private String Combo_citaid_Class ;
   private String Combo_citaid_Icontype ;
   private String Combo_citaid_Icon ;
   private String Combo_citaid_Tooltip ;
   private String Combo_citaid_Selectedvalue_set ;
   private String Combo_citaid_Selectedvalue_get ;
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
   private String Combo_servicioid_Objectcall ;
   private String Combo_servicioid_Class ;
   private String Combo_servicioid_Icontype ;
   private String Combo_servicioid_Icon ;
   private String Combo_servicioid_Tooltip ;
   private String Combo_servicioid_Selectedvalue_set ;
   private String Combo_servicioid_Selectedvalue_get ;
   private String Combo_servicioid_Selectedtext_set ;
   private String Combo_servicioid_Selectedtext_get ;
   private String Combo_servicioid_Gamoauthtoken ;
   private String Combo_servicioid_Ddointernalname ;
   private String Combo_servicioid_Titlecontrolalign ;
   private String Combo_servicioid_Dropdownoptionstype ;
   private String Combo_servicioid_Titlecontrolidtoreplace ;
   private String Combo_servicioid_Datalisttype ;
   private String Combo_servicioid_Datalistfixedvalues ;
   private String Combo_servicioid_Htmltemplate ;
   private String Combo_servicioid_Multiplevaluestype ;
   private String Combo_servicioid_Loadingdata ;
   private String Combo_servicioid_Noresultsfound ;
   private String Combo_servicioid_Emptyitemtext ;
   private String Combo_servicioid_Onlyselectedvalues ;
   private String Combo_servicioid_Selectalltext ;
   private String Combo_servicioid_Multiplevaluesseparator ;
   private String Combo_servicioid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode20 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ114CitaServicioEstado ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_citaid_Emptyitem ;
   private boolean Combo_servicioid_Emptyitem ;
   private boolean Combo_citaid_Enabled ;
   private boolean Combo_citaid_Visible ;
   private boolean Combo_citaid_Allowmultipleselection ;
   private boolean Combo_citaid_Isgriditem ;
   private boolean Combo_citaid_Hasdescription ;
   private boolean Combo_citaid_Includeonlyselectedoption ;
   private boolean Combo_citaid_Includeselectalloption ;
   private boolean Combo_citaid_Includeaddnewoption ;
   private boolean Combo_servicioid_Enabled ;
   private boolean Combo_servicioid_Visible ;
   private boolean Combo_servicioid_Allowmultipleselection ;
   private boolean Combo_servicioid_Isgriditem ;
   private boolean Combo_servicioid_Hasdescription ;
   private boolean Combo_servicioid_Includeonlyselectedoption ;
   private boolean Combo_servicioid_Includeselectalloption ;
   private boolean Combo_servicioid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_citaid ;
   private com.genexus.webpanels.GXUserControl ucCombo_servicioid ;
   private HTMLChoice cmbCitaServicioEstado ;
   private IDataStoreProvider pr_default ;
   private int[] T000D6_A26CitaServicioId ;
   private byte[] T000D6_A115CitaServicioFlag ;
   private String[] T000D6_A114CitaServicioEstado ;
   private int[] T000D6_A19CitaId ;
   private short[] T000D6_A27ServicioId ;
   private int[] T000D4_A19CitaId ;
   private short[] T000D5_A27ServicioId ;
   private int[] T000D7_A19CitaId ;
   private short[] T000D8_A27ServicioId ;
   private int[] T000D9_A26CitaServicioId ;
   private int[] T000D3_A26CitaServicioId ;
   private byte[] T000D3_A115CitaServicioFlag ;
   private String[] T000D3_A114CitaServicioEstado ;
   private int[] T000D3_A19CitaId ;
   private short[] T000D3_A27ServicioId ;
   private int[] T000D10_A26CitaServicioId ;
   private int[] T000D11_A26CitaServicioId ;
   private int[] T000D2_A26CitaServicioId ;
   private byte[] T000D2_A115CitaServicioFlag ;
   private String[] T000D2_A114CitaServicioEstado ;
   private int[] T000D2_A19CitaId ;
   private short[] T000D2_A27ServicioId ;
   private int[] T000D12_A26CitaServicioId ;
   private int[] T000D15_A26CitaServicioId ;
   private int[] T000D16_A19CitaId ;
   private short[] T000D17_A27ServicioId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV15CitaId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV21ServicioId_Data ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
}

final  class citaservicio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000D2", "SELECT [CitaServicioId], [CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId] FROM [CitaServicio] WITH (UPDLOCK) WHERE [CitaServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D3", "SELECT [CitaServicioId], [CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId] FROM [CitaServicio] WHERE [CitaServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D4", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D5", "SELECT [ServicioId] FROM [Servicio] WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D6", "SELECT TM1.[CitaServicioId], TM1.[CitaServicioFlag], TM1.[CitaServicioEstado], TM1.[CitaId], TM1.[ServicioId] FROM [CitaServicio] TM1 WHERE TM1.[CitaServicioId] = ? ORDER BY TM1.[CitaServicioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D7", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D8", "SELECT [ServicioId] FROM [Servicio] WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D9", "SELECT [CitaServicioId] FROM [CitaServicio] WHERE [CitaServicioId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D10", "SELECT TOP 1 [CitaServicioId] FROM [CitaServicio] WHERE ( [CitaServicioId] > ?) ORDER BY [CitaServicioId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000D11", "SELECT TOP 1 [CitaServicioId] FROM [CitaServicio] WHERE ( [CitaServicioId] < ?) ORDER BY [CitaServicioId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000D12", "INSERT INTO [CitaServicio]([CitaServicioFlag], [CitaServicioEstado], [CitaId], [ServicioId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000D13", "UPDATE [CitaServicio] SET [CitaServicioFlag]=?, [CitaServicioEstado]=?, [CitaId]=?, [ServicioId]=?  WHERE [CitaServicioId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000D14", "DELETE FROM [CitaServicio]  WHERE [CitaServicioId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000D15", "SELECT [CitaServicioId] FROM [CitaServicio] ORDER BY [CitaServicioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D16", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000D17", "SELECT [ServicioId] FROM [Servicio] WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

