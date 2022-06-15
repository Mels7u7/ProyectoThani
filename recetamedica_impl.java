package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class recetamedica_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A19CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A19CitaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A42MedicamentoId = (short)(GXutil.lval( httpContext.GetPar( "MedicamentoId"))) ;
         n42MedicamentoId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A42MedicamentoId) ;
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
            AV15RecetaMedicaId = (short)(GXutil.lval( httpContext.GetPar( "RecetaMedicaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15RecetaMedicaId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vRECETAMEDICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15RecetaMedicaId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Receta Medica", (short)(0)) ;
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

   public recetamedica_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public recetamedica_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( recetamedica_impl.class ));
   }

   public recetamedica_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRecetaMedicaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaId_Internalname, "Medica Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A50RecetaMedicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtRecetaMedicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRecetaMedicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcitaid_Internalname, "Cita Id", "", "", lblTextblockcitaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_RecetaMedica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_citaid.setProperty("Caption", Combo_citaid_Caption);
      ucCombo_citaid.setProperty("Cls", Combo_citaid_Cls);
      ucCombo_citaid.setProperty("DataListProc", Combo_citaid_Datalistproc);
      ucCombo_citaid.setProperty("DataListProcParametersPrefix", Combo_citaid_Datalistprocparametersprefix);
      ucCombo_citaid.setProperty("EmptyItem", Combo_citaid_Emptyitem);
      ucCombo_citaid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_citaid.setProperty("DropDownOptionsData", AV16CitaId_Data);
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
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaId_Jsonclick, 0, "Attribute", "", "", "", "", edtCitaId_Visible, edtCitaId_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RecetaMedica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedmedicamentoid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmedicamentoid_Internalname, "Medicamento Id", "", "", lblTextblockmedicamentoid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_RecetaMedica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_medicamentoid.setProperty("Caption", Combo_medicamentoid_Caption);
      ucCombo_medicamentoid.setProperty("Cls", Combo_medicamentoid_Cls);
      ucCombo_medicamentoid.setProperty("DataListProc", Combo_medicamentoid_Datalistproc);
      ucCombo_medicamentoid.setProperty("DataListProcParametersPrefix", Combo_medicamentoid_Datalistprocparametersprefix);
      ucCombo_medicamentoid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_medicamentoid.setProperty("DropDownOptionsData", AV22MedicamentoId_Data);
      ucCombo_medicamentoid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_medicamentoid_Internalname, "COMBO_MEDICAMENTOIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtMedicamentoId_Internalname, "Medicamento Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtMedicamentoId_Internalname, GXutil.ltrim( localUtil.ntoc( A42MedicamentoId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A42MedicamentoId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMedicamentoId_Jsonclick, 0, "Attribute", "", "", "", "", edtMedicamentoId_Visible, edtMedicamentoId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMedicamentoCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtMedicamentoCodigo_Internalname, "Medicamento Codigo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtMedicamentoCodigo_Internalname, A229MedicamentoCodigo, GXutil.rtrim( localUtil.format( A229MedicamentoCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMedicamentoCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMedicamentoCodigo_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtMedicamentoNombre_Internalname, "Medicamento Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtMedicamentoNombre_Internalname, A230MedicamentoNombre, GXutil.rtrim( localUtil.format( A230MedicamentoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMedicamentoNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMedicamentoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtMedicamentoFormaFarm_Internalname, "Medicamento Forma Farm", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtMedicamentoFormaFarm_Internalname, A231MedicamentoFormaFarm, GXutil.rtrim( localUtil.format( A231MedicamentoFormaFarm, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMedicamentoFormaFarm_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMedicamentoFormaFarm_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaConcentracion_Internalname, "Medica Concentracion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaConcentracion_Internalname, A268RecetaMedicaConcentracion, GXutil.rtrim( localUtil.format( A268RecetaMedicaConcentracion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaConcentracion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRecetaMedicaConcentracion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaCantidad_Internalname, "Medica Cantidad", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A269RecetaMedicaCantidad, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtRecetaMedicaCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaCantidad_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRecetaMedicaCantidad_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaAtencion_Internalname, "Medica Atencion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaAtencion_Internalname, A273RecetaMedicaAtencion, GXutil.rtrim( localUtil.format( A273RecetaMedicaAtencion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaAtencion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRecetaMedicaAtencion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaArchivo_Internalname, "Medica Archivo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      edtRecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
      edtRecetaMedicaArchivo_Filetype = "" ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
      edtRecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
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
            httpContext.ajax_rsp_assign_attri("", false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
            httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
            edtRecetaMedicaArchivo_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
      }
      com.projectthani.GxWebStd.gx_blob_field( httpContext, edtRecetaMedicaArchivo_Internalname, GXutil.rtrim( A270RecetaMedicaArchivo), httpContext.getResourceRelative(A270RecetaMedicaArchivo), ((GXutil.strcmp("", edtRecetaMedicaArchivo_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtRecetaMedicaArchivo_Filetype)==0) ? A270RecetaMedicaArchivo : edtRecetaMedicaArchivo_Filetype)) : edtRecetaMedicaArchivo_Contenttype), true, "", edtRecetaMedicaArchivo_Parameters, 0, edtRecetaMedicaArchivo_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtRecetaMedicaArchivo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaMedicaFlag_Internalname, "Medica Flag", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaFlag_Internalname, GXutil.ltrim( localUtil.ntoc( A272RecetaMedicaFlag, (byte)(1), (byte)(0), ",", "")), GXutil.ltrim( ((edtRecetaMedicaFlag_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A272RecetaMedicaFlag), "9") : localUtil.format( DecimalUtil.doubleToDec(A272RecetaMedicaFlag), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,84);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaFlag_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRecetaMedicaFlag_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRecetaIndicaciones_Internalname, "Indicaciones", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtRecetaIndicaciones_Internalname, A332RecetaIndicaciones, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", (short)(0), 1, edtRecetaIndicaciones_Enabled, 0, 80, "chr", 4, "row", StyleString, ClassString, "", "", "300", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_RecetaMedica.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RecetaMedica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RecetaMedica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RecetaMedica.htm");
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
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombocitaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboCitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombocitaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboCitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboCitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocitaid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocitaid_Visible, edtavCombocitaid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RecetaMedica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_medicamentoid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombomedicamentoid_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboMedicamentoId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombomedicamentoid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboMedicamentoId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboMedicamentoId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombomedicamentoid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombomedicamentoid_Visible, edtavCombomedicamentoid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RecetaMedica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 106,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaMedicaNombreArchivo_Internalname, A267RecetaMedicaNombreArchivo, GXutil.rtrim( localUtil.format( A267RecetaMedicaNombreArchivo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,106);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaMedicaNombreArchivo_Jsonclick, 0, "Attribute", "", "", "", "", edtRecetaMedicaNombreArchivo_Visible, edtRecetaMedicaNombreArchivo_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedica.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRecetaArchivoTipo_Internalname, A271RecetaArchivoTipo, GXutil.rtrim( localUtil.format( A271RecetaArchivoTipo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRecetaArchivoTipo_Jsonclick, 0, "Attribute", "", "", "", "", edtRecetaArchivoTipo_Visible, edtRecetaArchivoTipo_Enabled, 0, "text", "", 30, "chr", 1, "row", 30, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_RecetaMedica.htm");
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
      e110Y2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCITAID_DATA"), AV16CitaId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vMEDICAMENTOID_DATA"), AV22MedicamentoId_Data);
            /* Read saved values. */
            Z50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z50RecetaMedicaId"), ",", ".")) ;
            Z268RecetaMedicaConcentracion = httpContext.cgiGet( "Z268RecetaMedicaConcentracion") ;
            n268RecetaMedicaConcentracion = ((GXutil.strcmp("", A268RecetaMedicaConcentracion)==0) ? true : false) ;
            Z269RecetaMedicaCantidad = (short)(localUtil.ctol( httpContext.cgiGet( "Z269RecetaMedicaCantidad"), ",", ".")) ;
            n269RecetaMedicaCantidad = ((0==A269RecetaMedicaCantidad) ? true : false) ;
            Z273RecetaMedicaAtencion = httpContext.cgiGet( "Z273RecetaMedicaAtencion") ;
            n273RecetaMedicaAtencion = ((GXutil.strcmp("", A273RecetaMedicaAtencion)==0) ? true : false) ;
            Z272RecetaMedicaFlag = (byte)(localUtil.ctol( httpContext.cgiGet( "Z272RecetaMedicaFlag"), ",", ".")) ;
            n272RecetaMedicaFlag = ((0==A272RecetaMedicaFlag) ? true : false) ;
            Z332RecetaIndicaciones = httpContext.cgiGet( "Z332RecetaIndicaciones") ;
            Z19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z19CitaId"), ",", ".")) ;
            Z42MedicamentoId = (short)(localUtil.ctol( httpContext.cgiGet( "Z42MedicamentoId"), ",", ".")) ;
            n42MedicamentoId = ((0==A42MedicamentoId) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "N19CitaId"), ",", ".")) ;
            N42MedicamentoId = (short)(localUtil.ctol( httpContext.cgiGet( "N42MedicamentoId"), ",", ".")) ;
            n42MedicamentoId = ((0==A42MedicamentoId) ? true : false) ;
            AV15RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( "vRECETAMEDICAID"), ",", ".")) ;
            AV12Insert_CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CITAID"), ",", ".")) ;
            AV13Insert_MedicamentoId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_MEDICAMENTOID"), ",", ".")) ;
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
            Combo_medicamentoid_Objectcall = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Objectcall") ;
            Combo_medicamentoid_Class = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Class") ;
            Combo_medicamentoid_Icontype = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Icontype") ;
            Combo_medicamentoid_Icon = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Icon") ;
            Combo_medicamentoid_Caption = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Caption") ;
            Combo_medicamentoid_Tooltip = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Tooltip") ;
            Combo_medicamentoid_Cls = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Cls") ;
            Combo_medicamentoid_Selectedvalue_set = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Selectedvalue_set") ;
            Combo_medicamentoid_Selectedvalue_get = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Selectedvalue_get") ;
            Combo_medicamentoid_Selectedtext_set = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Selectedtext_set") ;
            Combo_medicamentoid_Selectedtext_get = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Selectedtext_get") ;
            Combo_medicamentoid_Gamoauthtoken = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Gamoauthtoken") ;
            Combo_medicamentoid_Ddointernalname = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Ddointernalname") ;
            Combo_medicamentoid_Titlecontrolalign = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Titlecontrolalign") ;
            Combo_medicamentoid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Dropdownoptionstype") ;
            Combo_medicamentoid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Enabled")) ;
            Combo_medicamentoid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Visible")) ;
            Combo_medicamentoid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Titlecontrolidtoreplace") ;
            Combo_medicamentoid_Datalisttype = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Datalisttype") ;
            Combo_medicamentoid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Allowmultipleselection")) ;
            Combo_medicamentoid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Datalistfixedvalues") ;
            Combo_medicamentoid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Isgriditem")) ;
            Combo_medicamentoid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Hasdescription")) ;
            Combo_medicamentoid_Datalistproc = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Datalistproc") ;
            Combo_medicamentoid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Datalistprocparametersprefix") ;
            Combo_medicamentoid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_medicamentoid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Includeonlyselectedoption")) ;
            Combo_medicamentoid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Includeselectalloption")) ;
            Combo_medicamentoid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Emptyitem")) ;
            Combo_medicamentoid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_MEDICAMENTOID_Includeaddnewoption")) ;
            Combo_medicamentoid_Htmltemplate = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Htmltemplate") ;
            Combo_medicamentoid_Multiplevaluestype = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Multiplevaluestype") ;
            Combo_medicamentoid_Loadingdata = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Loadingdata") ;
            Combo_medicamentoid_Noresultsfound = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Noresultsfound") ;
            Combo_medicamentoid_Emptyitemtext = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Emptyitemtext") ;
            Combo_medicamentoid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Onlyselectedvalues") ;
            Combo_medicamentoid_Selectalltext = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Selectalltext") ;
            Combo_medicamentoid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Multiplevaluesseparator") ;
            Combo_medicamentoid_Addnewoptiontext = httpContext.cgiGet( "COMBO_MEDICAMENTOID_Addnewoptiontext") ;
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
            edtRecetaMedicaArchivo_Filetype = httpContext.cgiGet( "RECETAMEDICAARCHIVO_Filetype") ;
            edtRecetaMedicaArchivo_Filename = httpContext.cgiGet( "RECETAMEDICAARCHIVO_Filename") ;
            edtRecetaMedicaArchivo_Filename = httpContext.cgiGet( "RECETAMEDICAARCHIVO_Filename") ;
            edtRecetaMedicaArchivo_Filetype = httpContext.cgiGet( "RECETAMEDICAARCHIVO_Filetype") ;
            /* Read variables values. */
            A50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMedicamentoId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMedicamentoId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MEDICAMENTOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMedicamentoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A42MedicamentoId = (short)(0) ;
               n42MedicamentoId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
            }
            else
            {
               A42MedicamentoId = (short)(localUtil.ctol( httpContext.cgiGet( edtMedicamentoId_Internalname), ",", ".")) ;
               n42MedicamentoId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
            }
            n42MedicamentoId = ((0==A42MedicamentoId) ? true : false) ;
            A229MedicamentoCodigo = httpContext.cgiGet( edtMedicamentoCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
            A230MedicamentoNombre = httpContext.cgiGet( edtMedicamentoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
            A231MedicamentoFormaFarm = httpContext.cgiGet( edtMedicamentoFormaFarm_Internalname) ;
            n231MedicamentoFormaFarm = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
            A268RecetaMedicaConcentracion = httpContext.cgiGet( edtRecetaMedicaConcentracion_Internalname) ;
            n268RecetaMedicaConcentracion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A268RecetaMedicaConcentracion", A268RecetaMedicaConcentracion);
            n268RecetaMedicaConcentracion = ((GXutil.strcmp("", A268RecetaMedicaConcentracion)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaCantidad_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaCantidad_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RECETAMEDICACANTIDAD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRecetaMedicaCantidad_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A269RecetaMedicaCantidad = (short)(0) ;
               n269RecetaMedicaCantidad = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A269RecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), 4, 0));
            }
            else
            {
               A269RecetaMedicaCantidad = (short)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaCantidad_Internalname), ",", ".")) ;
               n269RecetaMedicaCantidad = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A269RecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), 4, 0));
            }
            n269RecetaMedicaCantidad = ((0==A269RecetaMedicaCantidad) ? true : false) ;
            A273RecetaMedicaAtencion = httpContext.cgiGet( edtRecetaMedicaAtencion_Internalname) ;
            n273RecetaMedicaAtencion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A273RecetaMedicaAtencion", A273RecetaMedicaAtencion);
            n273RecetaMedicaAtencion = ((GXutil.strcmp("", A273RecetaMedicaAtencion)==0) ? true : false) ;
            A270RecetaMedicaArchivo = httpContext.cgiGet( edtRecetaMedicaArchivo_Internalname) ;
            n270RecetaMedicaArchivo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
            n270RecetaMedicaArchivo = ((GXutil.strcmp("", A270RecetaMedicaArchivo)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaFlag_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaFlag_Internalname), ",", ".") > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RECETAMEDICAFLAG");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRecetaMedicaFlag_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A272RecetaMedicaFlag = (byte)(0) ;
               n272RecetaMedicaFlag = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A272RecetaMedicaFlag", GXutil.str( A272RecetaMedicaFlag, 1, 0));
            }
            else
            {
               A272RecetaMedicaFlag = (byte)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaFlag_Internalname), ",", ".")) ;
               n272RecetaMedicaFlag = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A272RecetaMedicaFlag", GXutil.str( A272RecetaMedicaFlag, 1, 0));
            }
            n272RecetaMedicaFlag = ((0==A272RecetaMedicaFlag) ? true : false) ;
            A332RecetaIndicaciones = httpContext.cgiGet( edtRecetaIndicaciones_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A332RecetaIndicaciones", A332RecetaIndicaciones);
            AV21ComboCitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombocitaid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCitaId), 8, 0));
            AV23ComboMedicamentoId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombomedicamentoid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboMedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboMedicamentoId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            if ( ! (GXutil.strcmp("", A270RecetaMedicaArchivo)==0) )
            {
               edtRecetaMedicaArchivo_Filename = httpContext.cgiGetFileName( edtRecetaMedicaArchivo_Internalname) ;
               edtRecetaMedicaArchivo_Filetype = httpContext.cgiGetFileType( edtRecetaMedicaArchivo_Internalname) ;
            }
            A271RecetaArchivoTipo = edtRecetaMedicaArchivo_Filetype ;
            httpContext.ajax_rsp_assign_attri("", false, "A271RecetaArchivoTipo", A271RecetaArchivoTipo);
            A267RecetaMedicaNombreArchivo = edtRecetaMedicaArchivo_Filename ;
            n267RecetaMedicaNombreArchivo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A267RecetaMedicaNombreArchivo", A267RecetaMedicaNombreArchivo);
            if ( (GXutil.strcmp("", A270RecetaMedicaArchivo)==0) )
            {
               GXCCtlgxBlob = "RECETAMEDICAARCHIVO" + "_gxBlob" ;
               A270RecetaMedicaArchivo = httpContext.cgiGet( GXCCtlgxBlob) ;
               n270RecetaMedicaArchivo = false ;
               n270RecetaMedicaArchivo = ((GXutil.strcmp("", A270RecetaMedicaArchivo)==0) ? true : false) ;
            }
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"RecetaMedica");
            A50RecetaMedicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtRecetaMedicaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
            forbiddenHiddens.add("RecetaMedicaId", localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A50RecetaMedicaId != Z50RecetaMedicaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("recetamedica:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A50RecetaMedicaId = (short)(GXutil.lval( httpContext.GetPar( "RecetaMedicaId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
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
                  sMode43 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode43 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound43 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0Y0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "RECETAMEDICAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtRecetaMedicaId_Internalname ;
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
                        e110Y2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120Y2 ();
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
         e120Y2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0Y43( ) ;
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
         disableAttributes0Y43( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomedicamentoid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomedicamentoid_Enabled), 5, 0), true);
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

   public void confirm_0Y0( )
   {
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Y43( ) ;
         }
         else
         {
            checkExtendedTable0Y43( ) ;
            closeExtendedTableCursors0Y43( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0Y0( )
   {
   }

   public void e110Y2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtMedicamentoId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoId_Visible), 5, 0), true);
      AV23ComboMedicamentoId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboMedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboMedicamentoId), 4, 0));
      edtavCombomedicamentoid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomedicamentoid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomedicamentoid_Visible), 5, 0), true);
      edtCitaId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Visible), 5, 0), true);
      AV21ComboCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCitaId), 8, 0));
      edtavCombocitaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCITAID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOMEDICAMENTOID' */
      S122 ();
      if ( returnInSub )
      {
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Insert", GXv_boolean5) ;
         recetamedica_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Update", GXv_boolean5) ;
         recetamedica_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWRecetaMedica_Delete", GXv_boolean5) ;
         recetamedica_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV24Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV25GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GXV1), 8, 0));
         while ( AV25GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV25GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CitaId") == 0 )
            {
               AV12Insert_CitaId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CitaId), 8, 0));
               if ( ! (0==AV12Insert_CitaId) )
               {
                  AV21ComboCitaId = AV12Insert_CitaId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCitaId), 8, 0));
                  Combo_citaid_Selectedvalue_set = GXutil.trim( GXutil.str( AV21ComboCitaId, 8, 0)) ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedValue_set", Combo_citaid_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char7[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.recetamedicaloaddvcombo(remoteHandle, context).execute( "CitaId", "GET", false, AV15RecetaMedicaId, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  recetamedica_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
                  recetamedica_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  recetamedica_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_citaid_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedText_set", Combo_citaid_Selectedtext_set);
                  Combo_citaid_Enabled = false ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "Enabled", GXutil.booltostr( Combo_citaid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "MedicamentoId") == 0 )
            {
               AV13Insert_MedicamentoId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_MedicamentoId), 4, 0));
               if ( ! (0==AV13Insert_MedicamentoId) )
               {
                  AV23ComboMedicamentoId = AV13Insert_MedicamentoId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboMedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboMedicamentoId), 4, 0));
                  Combo_medicamentoid_Selectedvalue_set = GXutil.trim( GXutil.str( AV23ComboMedicamentoId, 4, 0)) ;
                  ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "SelectedValue_set", Combo_medicamentoid_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new com.projectthani.recetamedicaloaddvcombo(remoteHandle, context).execute( "MedicamentoId", "GET", false, AV15RecetaMedicaId, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  recetamedica_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  recetamedica_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  recetamedica_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_medicamentoid_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "SelectedText_set", Combo_medicamentoid_Selectedtext_set);
                  Combo_medicamentoid_Enabled = false ;
                  ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "Enabled", GXutil.booltostr( Combo_medicamentoid_Enabled));
               }
            }
            AV25GXV1 = (int)(AV25GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GXV1), 8, 0));
         }
      }
      edtRecetaMedicaNombreArchivo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaNombreArchivo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaNombreArchivo_Visible), 5, 0), true);
      edtRecetaArchivoTipo_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaArchivoTipo_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaArchivoTipo_Visible), 5, 0), true);
   }

   public void e120Y2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.recetamedicaww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'LOADCOMBOMEDICAMENTOID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.recetamedicaloaddvcombo(remoteHandle, context).execute( "MedicamentoId", Gx_mode, false, AV15RecetaMedicaId, "", GXv_char9, GXv_char8, GXv_char7) ;
      recetamedica_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      recetamedica_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      recetamedica_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_medicamentoid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "SelectedValue_set", Combo_medicamentoid_Selectedvalue_set);
      Combo_medicamentoid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "SelectedText_set", Combo_medicamentoid_Selectedtext_set);
      AV23ComboMedicamentoId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboMedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboMedicamentoId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_medicamentoid_Enabled = false ;
         ucCombo_medicamentoid.sendProperty(context, "", false, Combo_medicamentoid_Internalname, "Enabled", GXutil.booltostr( Combo_medicamentoid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCITAID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.recetamedicaloaddvcombo(remoteHandle, context).execute( "CitaId", Gx_mode, false, AV15RecetaMedicaId, "", GXv_char9, GXv_char8, GXv_char7) ;
      recetamedica_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      recetamedica_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      recetamedica_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_citaid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedValue_set", Combo_citaid_Selectedvalue_set);
      Combo_citaid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedText_set", Combo_citaid_Selectedtext_set);
      AV21ComboCitaId = (int)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboCitaId), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_citaid_Enabled = false ;
         ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "Enabled", GXutil.booltostr( Combo_citaid_Enabled));
      }
   }

   public void zm0Y43( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z268RecetaMedicaConcentracion = T000Y3_A268RecetaMedicaConcentracion[0] ;
            Z269RecetaMedicaCantidad = T000Y3_A269RecetaMedicaCantidad[0] ;
            Z273RecetaMedicaAtencion = T000Y3_A273RecetaMedicaAtencion[0] ;
            Z272RecetaMedicaFlag = T000Y3_A272RecetaMedicaFlag[0] ;
            Z332RecetaIndicaciones = T000Y3_A332RecetaIndicaciones[0] ;
            Z19CitaId = T000Y3_A19CitaId[0] ;
            Z42MedicamentoId = T000Y3_A42MedicamentoId[0] ;
         }
         else
         {
            Z268RecetaMedicaConcentracion = A268RecetaMedicaConcentracion ;
            Z269RecetaMedicaCantidad = A269RecetaMedicaCantidad ;
            Z273RecetaMedicaAtencion = A273RecetaMedicaAtencion ;
            Z272RecetaMedicaFlag = A272RecetaMedicaFlag ;
            Z332RecetaIndicaciones = A332RecetaIndicaciones ;
            Z19CitaId = A19CitaId ;
            Z42MedicamentoId = A42MedicamentoId ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z50RecetaMedicaId = A50RecetaMedicaId ;
         Z268RecetaMedicaConcentracion = A268RecetaMedicaConcentracion ;
         Z269RecetaMedicaCantidad = A269RecetaMedicaCantidad ;
         Z273RecetaMedicaAtencion = A273RecetaMedicaAtencion ;
         Z270RecetaMedicaArchivo = A270RecetaMedicaArchivo ;
         Z272RecetaMedicaFlag = A272RecetaMedicaFlag ;
         Z332RecetaIndicaciones = A332RecetaIndicaciones ;
         Z271RecetaArchivoTipo = A271RecetaArchivoTipo ;
         Z267RecetaMedicaNombreArchivo = A267RecetaMedicaNombreArchivo ;
         Z19CitaId = A19CitaId ;
         Z42MedicamentoId = A42MedicamentoId ;
         Z229MedicamentoCodigo = A229MedicamentoCodigo ;
         Z230MedicamentoNombre = A230MedicamentoNombre ;
         Z231MedicamentoFormaFarm = A231MedicamentoFormaFarm ;
      }
   }

   public void standaloneNotModal( )
   {
      edtRecetaMedicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaId_Enabled), 5, 0), true);
      edtRecetaMedicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV15RecetaMedicaId) )
      {
         A50RecetaMedicaId = AV15RecetaMedicaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CitaId) )
      {
         edtCitaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      }
      else
      {
         edtCitaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_MedicamentoId) )
      {
         edtMedicamentoId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoId_Enabled), 5, 0), true);
      }
      else
      {
         edtMedicamentoId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CitaId) )
      {
         A19CitaId = AV12Insert_CitaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      else
      {
         A19CitaId = AV21ComboCitaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_MedicamentoId) )
      {
         A42MedicamentoId = AV13Insert_MedicamentoId ;
         n42MedicamentoId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
      }
      else
      {
         if ( (0==AV23ComboMedicamentoId) )
         {
            A42MedicamentoId = (short)(0) ;
            n42MedicamentoId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
            n42MedicamentoId = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
         }
         else
         {
            if ( ! (0==AV23ComboMedicamentoId) )
            {
               A42MedicamentoId = AV23ComboMedicamentoId ;
               n42MedicamentoId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
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
         AV24Pgmname = "RecetaMedica" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         /* Using cursor T000Y5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
         A229MedicamentoCodigo = T000Y5_A229MedicamentoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
         A230MedicamentoNombre = T000Y5_A230MedicamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
         A231MedicamentoFormaFarm = T000Y5_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = T000Y5_n231MedicamentoFormaFarm[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
         pr_default.close(3);
      }
   }

   public void load0Y43( )
   {
      /* Using cursor T000Y6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A229MedicamentoCodigo = T000Y6_A229MedicamentoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
         A230MedicamentoNombre = T000Y6_A230MedicamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
         A231MedicamentoFormaFarm = T000Y6_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = T000Y6_n231MedicamentoFormaFarm[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
         A268RecetaMedicaConcentracion = T000Y6_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = T000Y6_n268RecetaMedicaConcentracion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A268RecetaMedicaConcentracion", A268RecetaMedicaConcentracion);
         A269RecetaMedicaCantidad = T000Y6_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = T000Y6_n269RecetaMedicaCantidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A269RecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), 4, 0));
         A273RecetaMedicaAtencion = T000Y6_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = T000Y6_n273RecetaMedicaAtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A273RecetaMedicaAtencion", A273RecetaMedicaAtencion);
         A270RecetaMedicaArchivo = T000Y6_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = T000Y6_n270RecetaMedicaArchivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
         httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
         A272RecetaMedicaFlag = T000Y6_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = T000Y6_n272RecetaMedicaFlag[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A272RecetaMedicaFlag", GXutil.str( A272RecetaMedicaFlag, 1, 0));
         A332RecetaIndicaciones = T000Y6_A332RecetaIndicaciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A332RecetaIndicaciones", A332RecetaIndicaciones);
         A271RecetaArchivoTipo = T000Y6_A271RecetaArchivoTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A271RecetaArchivoTipo", A271RecetaArchivoTipo);
         edtRecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
         A267RecetaMedicaNombreArchivo = T000Y6_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = T000Y6_n267RecetaMedicaNombreArchivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A267RecetaMedicaNombreArchivo", A267RecetaMedicaNombreArchivo);
         edtRecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A19CitaId = T000Y6_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A42MedicamentoId = T000Y6_A42MedicamentoId[0] ;
         n42MedicamentoId = T000Y6_n42MedicamentoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
         zm0Y43( -11) ;
      }
      pr_default.close(4);
      onLoadActions0Y43( ) ;
   }

   public void onLoadActions0Y43( )
   {
      AV24Pgmname = "RecetaMedica" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
   }

   public void checkExtendedTable0Y43( )
   {
      nIsDirty_43 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV24Pgmname = "RecetaMedica" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      /* Using cursor T000Y4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T000Y5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A42MedicamentoId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Medicamento'.", "ForeignKeyNotFound", 1, "MEDICAMENTOID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtMedicamentoId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A229MedicamentoCodigo = T000Y5_A229MedicamentoCodigo[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
      A230MedicamentoNombre = T000Y5_A230MedicamentoNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
      A231MedicamentoFormaFarm = T000Y5_A231MedicamentoFormaFarm[0] ;
      n231MedicamentoFormaFarm = T000Y5_n231MedicamentoFormaFarm[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
      pr_default.close(3);
   }

   public void closeExtendedTableCursors0Y43( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( int A19CitaId )
   {
      /* Using cursor T000Y7 */
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

   public void gxload_13( short A42MedicamentoId )
   {
      /* Using cursor T000Y8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A42MedicamentoId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Medicamento'.", "ForeignKeyNotFound", 1, "MEDICAMENTOID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtMedicamentoId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A229MedicamentoCodigo = T000Y8_A229MedicamentoCodigo[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
      A230MedicamentoNombre = T000Y8_A230MedicamentoNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
      A231MedicamentoFormaFarm = T000Y8_A231MedicamentoFormaFarm[0] ;
      n231MedicamentoFormaFarm = T000Y8_n231MedicamentoFormaFarm[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A229MedicamentoCodigo)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A230MedicamentoNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A231MedicamentoFormaFarm)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0Y43( )
   {
      /* Using cursor T000Y9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound43 = (short)(1) ;
      }
      else
      {
         RcdFound43 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Y3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Y43( 11) ;
         RcdFound43 = (short)(1) ;
         A50RecetaMedicaId = T000Y3_A50RecetaMedicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
         A268RecetaMedicaConcentracion = T000Y3_A268RecetaMedicaConcentracion[0] ;
         n268RecetaMedicaConcentracion = T000Y3_n268RecetaMedicaConcentracion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A268RecetaMedicaConcentracion", A268RecetaMedicaConcentracion);
         A269RecetaMedicaCantidad = T000Y3_A269RecetaMedicaCantidad[0] ;
         n269RecetaMedicaCantidad = T000Y3_n269RecetaMedicaCantidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A269RecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), 4, 0));
         A273RecetaMedicaAtencion = T000Y3_A273RecetaMedicaAtencion[0] ;
         n273RecetaMedicaAtencion = T000Y3_n273RecetaMedicaAtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A273RecetaMedicaAtencion", A273RecetaMedicaAtencion);
         A270RecetaMedicaArchivo = T000Y3_A270RecetaMedicaArchivo[0] ;
         n270RecetaMedicaArchivo = T000Y3_n270RecetaMedicaArchivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
         httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
         A272RecetaMedicaFlag = T000Y3_A272RecetaMedicaFlag[0] ;
         n272RecetaMedicaFlag = T000Y3_n272RecetaMedicaFlag[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A272RecetaMedicaFlag", GXutil.str( A272RecetaMedicaFlag, 1, 0));
         A332RecetaIndicaciones = T000Y3_A332RecetaIndicaciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A332RecetaIndicaciones", A332RecetaIndicaciones);
         A271RecetaArchivoTipo = T000Y3_A271RecetaArchivoTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A271RecetaArchivoTipo", A271RecetaArchivoTipo);
         edtRecetaMedicaArchivo_Filetype = A271RecetaArchivoTipo ;
         httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Filetype", edtRecetaMedicaArchivo_Filetype, true);
         A267RecetaMedicaNombreArchivo = T000Y3_A267RecetaMedicaNombreArchivo[0] ;
         n267RecetaMedicaNombreArchivo = T000Y3_n267RecetaMedicaNombreArchivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A267RecetaMedicaNombreArchivo", A267RecetaMedicaNombreArchivo);
         edtRecetaMedicaArchivo_Filename = A267RecetaMedicaNombreArchivo ;
         A19CitaId = T000Y3_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A42MedicamentoId = T000Y3_A42MedicamentoId[0] ;
         n42MedicamentoId = T000Y3_n42MedicamentoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
         Z50RecetaMedicaId = A50RecetaMedicaId ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0Y43( ) ;
         if ( AnyError == 1 )
         {
            RcdFound43 = (short)(0) ;
            initializeNonKey0Y43( ) ;
         }
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound43 = (short)(0) ;
         initializeNonKey0Y43( ) ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode43 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Y43( ) ;
      if ( RcdFound43 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound43 = (short)(0) ;
      /* Using cursor T000Y10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000Y10_A50RecetaMedicaId[0] < A50RecetaMedicaId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000Y10_A50RecetaMedicaId[0] > A50RecetaMedicaId ) ) )
         {
            A50RecetaMedicaId = T000Y10_A50RecetaMedicaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
            RcdFound43 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound43 = (short)(0) ;
      /* Using cursor T000Y11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A50RecetaMedicaId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000Y11_A50RecetaMedicaId[0] > A50RecetaMedicaId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000Y11_A50RecetaMedicaId[0] < A50RecetaMedicaId ) ) )
         {
            A50RecetaMedicaId = T000Y11_A50RecetaMedicaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
            RcdFound43 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Y43( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Y43( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound43 == 1 )
         {
            if ( A50RecetaMedicaId != Z50RecetaMedicaId )
            {
               A50RecetaMedicaId = Z50RecetaMedicaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "RECETAMEDICAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRecetaMedicaId_Internalname ;
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
               update0Y43( ) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A50RecetaMedicaId != Z50RecetaMedicaId )
            {
               /* Insert record */
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Y43( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "RECETAMEDICAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtRecetaMedicaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCitaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Y43( ) ;
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
      if ( A50RecetaMedicaId != Z50RecetaMedicaId )
      {
         A50RecetaMedicaId = Z50RecetaMedicaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "RECETAMEDICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRecetaMedicaId_Internalname ;
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

   public void checkOptimisticConcurrency0Y43( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Y2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A50RecetaMedicaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RecetaMedica"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z268RecetaMedicaConcentracion, T000Y2_A268RecetaMedicaConcentracion[0]) != 0 ) || ( Z269RecetaMedicaCantidad != T000Y2_A269RecetaMedicaCantidad[0] ) || ( GXutil.strcmp(Z273RecetaMedicaAtencion, T000Y2_A273RecetaMedicaAtencion[0]) != 0 ) || ( Z272RecetaMedicaFlag != T000Y2_A272RecetaMedicaFlag[0] ) || ( GXutil.strcmp(Z332RecetaIndicaciones, T000Y2_A332RecetaIndicaciones[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z19CitaId != T000Y2_A19CitaId[0] ) || ( Z42MedicamentoId != T000Y2_A42MedicamentoId[0] ) )
         {
            if ( GXutil.strcmp(Z268RecetaMedicaConcentracion, T000Y2_A268RecetaMedicaConcentracion[0]) != 0 )
            {
               GXutil.writeLogln("recetamedica:[seudo value changed for attri]"+"RecetaMedicaConcentracion");
               GXutil.writeLogRaw("Old: ",Z268RecetaMedicaConcentracion);
               GXutil.writeLogRaw("Current: ",T000Y2_A268RecetaMedicaConcentracion[0]);
            }
            if ( Z269RecetaMedicaCantidad != T000Y2_A269RecetaMedicaCantidad[0] )
            {
               GXutil.writeLogln("recetamedica:[seudo value changed for attri]"+"RecetaMedicaCantidad");
               GXutil.writeLogRaw("Old: ",Z269RecetaMedicaCantidad);
               GXutil.writeLogRaw("Current: ",T000Y2_A269RecetaMedicaCantidad[0]);
            }
            if ( GXutil.strcmp(Z273RecetaMedicaAtencion, T000Y2_A273RecetaMedicaAtencion[0]) != 0 )
            {
               GXutil.writeLogln("recetamedica:[seudo value changed for attri]"+"RecetaMedicaAtencion");
               GXutil.writeLogRaw("Old: ",Z273RecetaMedicaAtencion);
               GXutil.writeLogRaw("Current: ",T000Y2_A273RecetaMedicaAtencion[0]);
            }
            if ( Z272RecetaMedicaFlag != T000Y2_A272RecetaMedicaFlag[0] )
            {
               GXutil.writeLogln("recetamedica:[seudo value changed for attri]"+"RecetaMedicaFlag");
               GXutil.writeLogRaw("Old: ",Z272RecetaMedicaFlag);
               GXutil.writeLogRaw("Current: ",T000Y2_A272RecetaMedicaFlag[0]);
            }
            if ( GXutil.strcmp(Z332RecetaIndicaciones, T000Y2_A332RecetaIndicaciones[0]) != 0 )
            {
               GXutil.writeLogln("recetamedica:[seudo value changed for attri]"+"RecetaIndicaciones");
               GXutil.writeLogRaw("Old: ",Z332RecetaIndicaciones);
               GXutil.writeLogRaw("Current: ",T000Y2_A332RecetaIndicaciones[0]);
            }
            if ( Z19CitaId != T000Y2_A19CitaId[0] )
            {
               GXutil.writeLogln("recetamedica:[seudo value changed for attri]"+"CitaId");
               GXutil.writeLogRaw("Old: ",Z19CitaId);
               GXutil.writeLogRaw("Current: ",T000Y2_A19CitaId[0]);
            }
            if ( Z42MedicamentoId != T000Y2_A42MedicamentoId[0] )
            {
               GXutil.writeLogln("recetamedica:[seudo value changed for attri]"+"MedicamentoId");
               GXutil.writeLogRaw("Old: ",Z42MedicamentoId);
               GXutil.writeLogRaw("Current: ",T000Y2_A42MedicamentoId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"RecetaMedica"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Y43( )
   {
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y43( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Y43( 0) ;
         checkOptimisticConcurrency0Y43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y43( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Y43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Y12 */
                  A271RecetaArchivoTipo = edtRecetaMedicaArchivo_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A271RecetaArchivoTipo", A271RecetaArchivoTipo);
                  A267RecetaMedicaNombreArchivo = edtRecetaMedicaArchivo_Filename ;
                  n267RecetaMedicaNombreArchivo = false ;
                  httpContext.ajax_rsp_assign_attri("", false, "A267RecetaMedicaNombreArchivo", A267RecetaMedicaNombreArchivo);
                  pr_default.execute(10, new Object[] {Boolean.valueOf(n268RecetaMedicaConcentracion), A268RecetaMedicaConcentracion, Boolean.valueOf(n269RecetaMedicaCantidad), Short.valueOf(A269RecetaMedicaCantidad), Boolean.valueOf(n273RecetaMedicaAtencion), A273RecetaMedicaAtencion, Boolean.valueOf(n270RecetaMedicaArchivo), A270RecetaMedicaArchivo, Boolean.valueOf(n272RecetaMedicaFlag), Byte.valueOf(A272RecetaMedicaFlag), A332RecetaIndicaciones, A271RecetaArchivoTipo, Boolean.valueOf(n267RecetaMedicaNombreArchivo), A267RecetaMedicaNombreArchivo, Integer.valueOf(A19CitaId), Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
                  A50RecetaMedicaId = T000Y12_A50RecetaMedicaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0Y0( ) ;
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
            load0Y43( ) ;
         }
         endLevel0Y43( ) ;
      }
      closeExtendedTableCursors0Y43( ) ;
   }

   public void update0Y43( )
   {
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Y43( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Y43( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Y43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Y13 */
                  A271RecetaArchivoTipo = edtRecetaMedicaArchivo_Filetype ;
                  httpContext.ajax_rsp_assign_attri("", false, "A271RecetaArchivoTipo", A271RecetaArchivoTipo);
                  A267RecetaMedicaNombreArchivo = edtRecetaMedicaArchivo_Filename ;
                  n267RecetaMedicaNombreArchivo = false ;
                  httpContext.ajax_rsp_assign_attri("", false, "A267RecetaMedicaNombreArchivo", A267RecetaMedicaNombreArchivo);
                  pr_default.execute(11, new Object[] {Boolean.valueOf(n268RecetaMedicaConcentracion), A268RecetaMedicaConcentracion, Boolean.valueOf(n269RecetaMedicaCantidad), Short.valueOf(A269RecetaMedicaCantidad), Boolean.valueOf(n273RecetaMedicaAtencion), A273RecetaMedicaAtencion, Boolean.valueOf(n272RecetaMedicaFlag), Byte.valueOf(A272RecetaMedicaFlag), A332RecetaIndicaciones, A271RecetaArchivoTipo, Boolean.valueOf(n267RecetaMedicaNombreArchivo), A267RecetaMedicaNombreArchivo, Integer.valueOf(A19CitaId), Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId), Short.valueOf(A50RecetaMedicaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RecetaMedica"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Y43( ) ;
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
         endLevel0Y43( ) ;
      }
      closeExtendedTableCursors0Y43( ) ;
   }

   public void deferredUpdate0Y43( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000Y14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n270RecetaMedicaArchivo), A270RecetaMedicaArchivo, Short.valueOf(A50RecetaMedicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
      }
   }

   public void delete( )
   {
      beforeValidate0Y43( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Y43( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Y43( ) ;
         afterConfirm0Y43( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Y43( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Y15 */
               pr_default.execute(13, new Object[] {Short.valueOf(A50RecetaMedicaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("RecetaMedica");
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
      sMode43 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Y43( ) ;
      Gx_mode = sMode43 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Y43( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "RecetaMedica" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         /* Using cursor T000Y16 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
         A229MedicamentoCodigo = T000Y16_A229MedicamentoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
         A230MedicamentoNombre = T000Y16_A230MedicamentoNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
         A231MedicamentoFormaFarm = T000Y16_A231MedicamentoFormaFarm[0] ;
         n231MedicamentoFormaFarm = T000Y16_n231MedicamentoFormaFarm[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
         pr_default.close(14);
      }
   }

   public void endLevel0Y43( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Y43( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(14);
         Application.commitDataStores(context, remoteHandle, pr_default, "recetamedica");
         if ( AnyError == 0 )
         {
            confirmValues0Y0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(14);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "recetamedica");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Y43( )
   {
      /* Scan By routine */
      /* Using cursor T000Y17 */
      pr_default.execute(15);
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A50RecetaMedicaId = T000Y17_A50RecetaMedicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Y43( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A50RecetaMedicaId = T000Y17_A50RecetaMedicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
      }
   }

   public void scanEnd0Y43( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0Y43( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Y43( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Y43( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Y43( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Y43( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Y43( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Y43( )
   {
      edtRecetaMedicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaId_Enabled), 5, 0), true);
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      edtMedicamentoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoId_Enabled), 5, 0), true);
      edtMedicamentoCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoCodigo_Enabled), 5, 0), true);
      edtMedicamentoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoNombre_Enabled), 5, 0), true);
      edtMedicamentoFormaFarm_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMedicamentoFormaFarm_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMedicamentoFormaFarm_Enabled), 5, 0), true);
      edtRecetaMedicaConcentracion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaConcentracion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaConcentracion_Enabled), 5, 0), true);
      edtRecetaMedicaCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaCantidad_Enabled), 5, 0), true);
      edtRecetaMedicaAtencion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaAtencion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaAtencion_Enabled), 5, 0), true);
      edtRecetaMedicaArchivo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaArchivo_Enabled), 5, 0), true);
      edtRecetaMedicaFlag_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaFlag_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaFlag_Enabled), 5, 0), true);
      edtRecetaIndicaciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaIndicaciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaIndicaciones_Enabled), 5, 0), true);
      edtavCombocitaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Enabled), 5, 0), true);
      edtavCombomedicamentoid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombomedicamentoid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombomedicamentoid_Enabled), 5, 0), true);
      edtRecetaMedicaNombreArchivo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaNombreArchivo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaMedicaNombreArchivo_Enabled), 5, 0), true);
      edtRecetaArchivoTipo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaArchivoTipo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRecetaArchivoTipo_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Y43( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Y0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033412", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.recetamedica", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV15RecetaMedicaId,4,0))}, new String[] {"Gx_mode","RecetaMedicaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"RecetaMedica");
      forbiddenHiddens.add("RecetaMedicaId", localUtil.format( DecimalUtil.doubleToDec(A50RecetaMedicaId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("recetamedica:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z50RecetaMedicaId", GXutil.ltrim( localUtil.ntoc( Z50RecetaMedicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z268RecetaMedicaConcentracion", Z268RecetaMedicaConcentracion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z269RecetaMedicaCantidad", GXutil.ltrim( localUtil.ntoc( Z269RecetaMedicaCantidad, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z273RecetaMedicaAtencion", Z273RecetaMedicaAtencion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z272RecetaMedicaFlag", GXutil.ltrim( localUtil.ntoc( Z272RecetaMedicaFlag, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z332RecetaIndicaciones", Z332RecetaIndicaciones);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z42MedicamentoId", GXutil.ltrim( localUtil.ntoc( Z42MedicamentoId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N19CitaId", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N42MedicamentoId", GXutil.ltrim( localUtil.ntoc( A42MedicamentoId, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV17DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITAID_DATA", AV16CitaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITAID_DATA", AV16CitaId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vMEDICAMENTOID_DATA", AV22MedicamentoId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vMEDICAMENTOID_DATA", AV22MedicamentoId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vRECETAMEDICAID", GXutil.ltrim( localUtil.ntoc( AV15RecetaMedicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vRECETAMEDICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15RecetaMedicaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CITAID", GXutil.ltrim( localUtil.ntoc( AV12Insert_CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_MEDICAMENTOID", GXutil.ltrim( localUtil.ntoc( AV13Insert_MedicamentoId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
      GXCCtlgxBlob = "RECETAMEDICAARCHIVO" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A270RecetaMedicaArchivo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Objectcall", GXutil.rtrim( Combo_citaid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Cls", GXutil.rtrim( Combo_citaid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Selectedvalue_set", GXutil.rtrim( Combo_citaid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Selectedtext_set", GXutil.rtrim( Combo_citaid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Enabled", GXutil.booltostr( Combo_citaid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistproc", GXutil.rtrim( Combo_citaid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_citaid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Emptyitem", GXutil.booltostr( Combo_citaid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Objectcall", GXutil.rtrim( Combo_medicamentoid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Cls", GXutil.rtrim( Combo_medicamentoid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Selectedvalue_set", GXutil.rtrim( Combo_medicamentoid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Selectedtext_set", GXutil.rtrim( Combo_medicamentoid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Enabled", GXutil.booltostr( Combo_medicamentoid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Datalistproc", GXutil.rtrim( Combo_medicamentoid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_MEDICAMENTOID_Datalistprocparametersprefix", GXutil.rtrim( Combo_medicamentoid_Datalistprocparametersprefix));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RECETAMEDICAARCHIVO_Filetype", GXutil.rtrim( edtRecetaMedicaArchivo_Filetype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RECETAMEDICAARCHIVO_Filename", GXutil.rtrim( edtRecetaMedicaArchivo_Filename));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RECETAMEDICAARCHIVO_Filename", GXutil.rtrim( edtRecetaMedicaArchivo_Filename));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RECETAMEDICAARCHIVO_Filetype", GXutil.rtrim( edtRecetaMedicaArchivo_Filetype));
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
      return formatLink("com.projectthani.recetamedica", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV15RecetaMedicaId,4,0))}, new String[] {"Gx_mode","RecetaMedicaId"})  ;
   }

   public String getPgmname( )
   {
      return "RecetaMedica" ;
   }

   public String getPgmdesc( )
   {
      return "Receta Medica" ;
   }

   public void initializeNonKey0Y43( )
   {
      A19CitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      A42MedicamentoId = (short)(0) ;
      n42MedicamentoId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A42MedicamentoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A42MedicamentoId), 4, 0));
      n42MedicamentoId = ((0==A42MedicamentoId) ? true : false) ;
      A229MedicamentoCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
      A230MedicamentoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
      A231MedicamentoFormaFarm = "" ;
      n231MedicamentoFormaFarm = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
      A268RecetaMedicaConcentracion = "" ;
      n268RecetaMedicaConcentracion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A268RecetaMedicaConcentracion", A268RecetaMedicaConcentracion);
      n268RecetaMedicaConcentracion = ((GXutil.strcmp("", A268RecetaMedicaConcentracion)==0) ? true : false) ;
      A269RecetaMedicaCantidad = (short)(0) ;
      n269RecetaMedicaCantidad = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A269RecetaMedicaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A269RecetaMedicaCantidad), 4, 0));
      n269RecetaMedicaCantidad = ((0==A269RecetaMedicaCantidad) ? true : false) ;
      A273RecetaMedicaAtencion = "" ;
      n273RecetaMedicaAtencion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A273RecetaMedicaAtencion", A273RecetaMedicaAtencion);
      n273RecetaMedicaAtencion = ((GXutil.strcmp("", A273RecetaMedicaAtencion)==0) ? true : false) ;
      A270RecetaMedicaArchivo = "" ;
      n270RecetaMedicaArchivo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A270RecetaMedicaArchivo", A270RecetaMedicaArchivo);
      httpContext.ajax_rsp_assign_prop("", false, edtRecetaMedicaArchivo_Internalname, "URL", httpContext.getResourceRelative(A270RecetaMedicaArchivo), true);
      n270RecetaMedicaArchivo = ((GXutil.strcmp("", A270RecetaMedicaArchivo)==0) ? true : false) ;
      A272RecetaMedicaFlag = (byte)(0) ;
      n272RecetaMedicaFlag = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A272RecetaMedicaFlag", GXutil.str( A272RecetaMedicaFlag, 1, 0));
      n272RecetaMedicaFlag = ((0==A272RecetaMedicaFlag) ? true : false) ;
      A332RecetaIndicaciones = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A332RecetaIndicaciones", A332RecetaIndicaciones);
      A271RecetaArchivoTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A271RecetaArchivoTipo", A271RecetaArchivoTipo);
      A267RecetaMedicaNombreArchivo = "" ;
      n267RecetaMedicaNombreArchivo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A267RecetaMedicaNombreArchivo", A267RecetaMedicaNombreArchivo);
      n267RecetaMedicaNombreArchivo = ((GXutil.strcmp("", A267RecetaMedicaNombreArchivo)==0) ? true : false) ;
      Z268RecetaMedicaConcentracion = "" ;
      Z269RecetaMedicaCantidad = (short)(0) ;
      Z273RecetaMedicaAtencion = "" ;
      Z272RecetaMedicaFlag = (byte)(0) ;
      Z332RecetaIndicaciones = "" ;
      Z19CitaId = 0 ;
      Z42MedicamentoId = (short)(0) ;
   }

   public void initAll0Y43( )
   {
      A50RecetaMedicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A50RecetaMedicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A50RecetaMedicaId), 4, 0));
      initializeNonKey0Y43( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033442", true, true);
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
      httpContext.AddJavascriptSource("recetamedica.js", "?2022511033442", false, true);
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
      edtRecetaMedicaId_Internalname = "RECETAMEDICAID" ;
      lblTextblockcitaid_Internalname = "TEXTBLOCKCITAID" ;
      Combo_citaid_Internalname = "COMBO_CITAID" ;
      edtCitaId_Internalname = "CITAID" ;
      divTablesplittedcitaid_Internalname = "TABLESPLITTEDCITAID" ;
      lblTextblockmedicamentoid_Internalname = "TEXTBLOCKMEDICAMENTOID" ;
      Combo_medicamentoid_Internalname = "COMBO_MEDICAMENTOID" ;
      edtMedicamentoId_Internalname = "MEDICAMENTOID" ;
      divTablesplittedmedicamentoid_Internalname = "TABLESPLITTEDMEDICAMENTOID" ;
      edtMedicamentoCodigo_Internalname = "MEDICAMENTOCODIGO" ;
      edtMedicamentoNombre_Internalname = "MEDICAMENTONOMBRE" ;
      edtMedicamentoFormaFarm_Internalname = "MEDICAMENTOFORMAFARM" ;
      edtRecetaMedicaConcentracion_Internalname = "RECETAMEDICACONCENTRACION" ;
      edtRecetaMedicaCantidad_Internalname = "RECETAMEDICACANTIDAD" ;
      edtRecetaMedicaAtencion_Internalname = "RECETAMEDICAATENCION" ;
      edtRecetaMedicaArchivo_Internalname = "RECETAMEDICAARCHIVO" ;
      edtRecetaMedicaFlag_Internalname = "RECETAMEDICAFLAG" ;
      edtRecetaIndicaciones_Internalname = "RECETAINDICACIONES" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocitaid_Internalname = "vCOMBOCITAID" ;
      divSectionattribute_citaid_Internalname = "SECTIONATTRIBUTE_CITAID" ;
      edtavCombomedicamentoid_Internalname = "vCOMBOMEDICAMENTOID" ;
      divSectionattribute_medicamentoid_Internalname = "SECTIONATTRIBUTE_MEDICAMENTOID" ;
      edtRecetaMedicaNombreArchivo_Internalname = "RECETAMEDICANOMBREARCHIVO" ;
      edtRecetaArchivoTipo_Internalname = "RECETAARCHIVOTIPO" ;
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
      Form.setCaption( "Receta Medica" );
      edtRecetaMedicaArchivo_Filename = "" ;
      edtRecetaArchivoTipo_Jsonclick = "" ;
      edtRecetaArchivoTipo_Enabled = 1 ;
      edtRecetaArchivoTipo_Visible = 1 ;
      edtRecetaMedicaNombreArchivo_Jsonclick = "" ;
      edtRecetaMedicaNombreArchivo_Enabled = 1 ;
      edtRecetaMedicaNombreArchivo_Visible = 1 ;
      edtavCombomedicamentoid_Jsonclick = "" ;
      edtavCombomedicamentoid_Enabled = 0 ;
      edtavCombomedicamentoid_Visible = 1 ;
      edtavCombocitaid_Jsonclick = "" ;
      edtavCombocitaid_Enabled = 0 ;
      edtavCombocitaid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtRecetaIndicaciones_Enabled = 1 ;
      edtRecetaMedicaFlag_Jsonclick = "" ;
      edtRecetaMedicaFlag_Enabled = 1 ;
      edtRecetaMedicaArchivo_Jsonclick = "" ;
      edtRecetaMedicaArchivo_Parameters = "" ;
      edtRecetaMedicaArchivo_Contenttype = "" ;
      edtRecetaMedicaArchivo_Filetype = "" ;
      edtRecetaMedicaArchivo_Enabled = 1 ;
      edtRecetaMedicaAtencion_Jsonclick = "" ;
      edtRecetaMedicaAtencion_Enabled = 1 ;
      edtRecetaMedicaCantidad_Jsonclick = "" ;
      edtRecetaMedicaCantidad_Enabled = 1 ;
      edtRecetaMedicaConcentracion_Jsonclick = "" ;
      edtRecetaMedicaConcentracion_Enabled = 1 ;
      edtMedicamentoFormaFarm_Jsonclick = "" ;
      edtMedicamentoFormaFarm_Enabled = 0 ;
      edtMedicamentoNombre_Jsonclick = "" ;
      edtMedicamentoNombre_Enabled = 0 ;
      edtMedicamentoCodigo_Jsonclick = "" ;
      edtMedicamentoCodigo_Enabled = 0 ;
      edtMedicamentoId_Jsonclick = "" ;
      edtMedicamentoId_Enabled = 1 ;
      edtMedicamentoId_Visible = 1 ;
      Combo_medicamentoid_Datalistprocparametersprefix = " \"ComboName\": \"MedicamentoId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"RecetaMedicaId\": 0" ;
      Combo_medicamentoid_Datalistproc = "RecetaMedicaLoadDVCombo" ;
      Combo_medicamentoid_Cls = "ExtendedCombo Attribute" ;
      Combo_medicamentoid_Caption = "" ;
      Combo_medicamentoid_Enabled = GXutil.toBoolean( -1) ;
      edtCitaId_Jsonclick = "" ;
      edtCitaId_Enabled = 1 ;
      edtCitaId_Visible = 1 ;
      Combo_citaid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_citaid_Datalistprocparametersprefix = " \"ComboName\": \"CitaId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"RecetaMedicaId\": 0" ;
      Combo_citaid_Datalistproc = "RecetaMedicaLoadDVCombo" ;
      Combo_citaid_Cls = "ExtendedCombo Attribute" ;
      Combo_citaid_Caption = "" ;
      Combo_citaid_Enabled = GXutil.toBoolean( -1) ;
      edtRecetaMedicaId_Jsonclick = "" ;
      edtRecetaMedicaId_Enabled = 0 ;
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
      /* Using cursor T000Y18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
      }
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Medicamentoid( )
   {
      n42MedicamentoId = false ;
      n231MedicamentoFormaFarm = false ;
      /* Using cursor T000Y16 */
      pr_default.execute(14, new Object[] {Boolean.valueOf(n42MedicamentoId), Short.valueOf(A42MedicamentoId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         if ( ! ( (0==A42MedicamentoId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Medicamento'.", "ForeignKeyNotFound", 1, "MEDICAMENTOID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtMedicamentoId_Internalname ;
         }
      }
      A229MedicamentoCodigo = T000Y16_A229MedicamentoCodigo[0] ;
      A230MedicamentoNombre = T000Y16_A230MedicamentoNombre[0] ;
      A231MedicamentoFormaFarm = T000Y16_A231MedicamentoFormaFarm[0] ;
      n231MedicamentoFormaFarm = T000Y16_n231MedicamentoFormaFarm[0] ;
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A229MedicamentoCodigo", A229MedicamentoCodigo);
      httpContext.ajax_rsp_assign_attri("", false, "A230MedicamentoNombre", A230MedicamentoNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A231MedicamentoFormaFarm", A231MedicamentoFormaFarm);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV15RecetaMedicaId',fld:'vRECETAMEDICAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV15RecetaMedicaId',fld:'vRECETAMEDICAID',pic:'ZZZ9',hsh:true},{av:'A50RecetaMedicaId',fld:'RECETAMEDICAID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120Y2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_RECETAMEDICAID","{handler:'valid_Recetamedicaid',iparms:[]");
      setEventMetadata("VALID_RECETAMEDICAID",",oparms:[]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_CITAID",",oparms:[]}");
      setEventMetadata("VALID_MEDICAMENTOID","{handler:'valid_Medicamentoid',iparms:[{av:'A42MedicamentoId',fld:'MEDICAMENTOID',pic:'ZZZ9'},{av:'A229MedicamentoCodigo',fld:'MEDICAMENTOCODIGO',pic:''},{av:'A230MedicamentoNombre',fld:'MEDICAMENTONOMBRE',pic:''},{av:'A231MedicamentoFormaFarm',fld:'MEDICAMENTOFORMAFARM',pic:''}]");
      setEventMetadata("VALID_MEDICAMENTOID",",oparms:[{av:'A229MedicamentoCodigo',fld:'MEDICAMENTOCODIGO',pic:''},{av:'A230MedicamentoNombre',fld:'MEDICAMENTONOMBRE',pic:''},{av:'A231MedicamentoFormaFarm',fld:'MEDICAMENTOFORMAFARM',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCITAID","{handler:'validv_Combocitaid',iparms:[]");
      setEventMetadata("VALIDV_COMBOCITAID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOMEDICAMENTOID","{handler:'validv_Combomedicamentoid',iparms:[]");
      setEventMetadata("VALIDV_COMBOMEDICAMENTOID",",oparms:[]}");
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
      pr_default.close(16);
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z268RecetaMedicaConcentracion = "" ;
      Z273RecetaMedicaAtencion = "" ;
      Z332RecetaIndicaciones = "" ;
      Combo_medicamentoid_Selectedvalue_get = "" ;
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
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcitaid_Jsonclick = "" ;
      ucCombo_citaid = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16CitaId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblockmedicamentoid_Jsonclick = "" ;
      ucCombo_medicamentoid = new com.genexus.webpanels.GXUserControl();
      AV22MedicamentoId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A229MedicamentoCodigo = "" ;
      A230MedicamentoNombre = "" ;
      A231MedicamentoFormaFarm = "" ;
      A268RecetaMedicaConcentracion = "" ;
      A273RecetaMedicaAtencion = "" ;
      A267RecetaMedicaNombreArchivo = "" ;
      A271RecetaArchivoTipo = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A270RecetaMedicaArchivo = "" ;
      A332RecetaIndicaciones = "" ;
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
      Combo_medicamentoid_Objectcall = "" ;
      Combo_medicamentoid_Class = "" ;
      Combo_medicamentoid_Icontype = "" ;
      Combo_medicamentoid_Icon = "" ;
      Combo_medicamentoid_Tooltip = "" ;
      Combo_medicamentoid_Selectedvalue_set = "" ;
      Combo_medicamentoid_Selectedtext_set = "" ;
      Combo_medicamentoid_Selectedtext_get = "" ;
      Combo_medicamentoid_Gamoauthtoken = "" ;
      Combo_medicamentoid_Ddointernalname = "" ;
      Combo_medicamentoid_Titlecontrolalign = "" ;
      Combo_medicamentoid_Dropdownoptionstype = "" ;
      Combo_medicamentoid_Titlecontrolidtoreplace = "" ;
      Combo_medicamentoid_Datalisttype = "" ;
      Combo_medicamentoid_Datalistfixedvalues = "" ;
      Combo_medicamentoid_Htmltemplate = "" ;
      Combo_medicamentoid_Multiplevaluestype = "" ;
      Combo_medicamentoid_Loadingdata = "" ;
      Combo_medicamentoid_Noresultsfound = "" ;
      Combo_medicamentoid_Emptyitemtext = "" ;
      Combo_medicamentoid_Onlyselectedvalues = "" ;
      Combo_medicamentoid_Selectalltext = "" ;
      Combo_medicamentoid_Multiplevaluesseparator = "" ;
      Combo_medicamentoid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      GXCCtlgxBlob = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode43 = "" ;
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
      AV20Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      AV19ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z270RecetaMedicaArchivo = "" ;
      Z271RecetaArchivoTipo = "" ;
      Z267RecetaMedicaNombreArchivo = "" ;
      Z229MedicamentoCodigo = "" ;
      Z230MedicamentoNombre = "" ;
      Z231MedicamentoFormaFarm = "" ;
      T000Y5_A229MedicamentoCodigo = new String[] {""} ;
      T000Y5_A230MedicamentoNombre = new String[] {""} ;
      T000Y5_A231MedicamentoFormaFarm = new String[] {""} ;
      T000Y5_n231MedicamentoFormaFarm = new boolean[] {false} ;
      T000Y6_A50RecetaMedicaId = new short[1] ;
      T000Y6_A229MedicamentoCodigo = new String[] {""} ;
      T000Y6_A230MedicamentoNombre = new String[] {""} ;
      T000Y6_A231MedicamentoFormaFarm = new String[] {""} ;
      T000Y6_n231MedicamentoFormaFarm = new boolean[] {false} ;
      T000Y6_A268RecetaMedicaConcentracion = new String[] {""} ;
      T000Y6_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      T000Y6_A269RecetaMedicaCantidad = new short[1] ;
      T000Y6_n269RecetaMedicaCantidad = new boolean[] {false} ;
      T000Y6_A273RecetaMedicaAtencion = new String[] {""} ;
      T000Y6_n273RecetaMedicaAtencion = new boolean[] {false} ;
      T000Y6_A270RecetaMedicaArchivo = new String[] {""} ;
      T000Y6_n270RecetaMedicaArchivo = new boolean[] {false} ;
      T000Y6_A272RecetaMedicaFlag = new byte[1] ;
      T000Y6_n272RecetaMedicaFlag = new boolean[] {false} ;
      T000Y6_A332RecetaIndicaciones = new String[] {""} ;
      T000Y6_A271RecetaArchivoTipo = new String[] {""} ;
      T000Y6_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      T000Y6_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      T000Y6_A19CitaId = new int[1] ;
      T000Y6_A42MedicamentoId = new short[1] ;
      T000Y6_n42MedicamentoId = new boolean[] {false} ;
      T000Y4_A19CitaId = new int[1] ;
      T000Y7_A19CitaId = new int[1] ;
      T000Y8_A229MedicamentoCodigo = new String[] {""} ;
      T000Y8_A230MedicamentoNombre = new String[] {""} ;
      T000Y8_A231MedicamentoFormaFarm = new String[] {""} ;
      T000Y8_n231MedicamentoFormaFarm = new boolean[] {false} ;
      T000Y9_A50RecetaMedicaId = new short[1] ;
      T000Y3_A50RecetaMedicaId = new short[1] ;
      T000Y3_A268RecetaMedicaConcentracion = new String[] {""} ;
      T000Y3_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      T000Y3_A269RecetaMedicaCantidad = new short[1] ;
      T000Y3_n269RecetaMedicaCantidad = new boolean[] {false} ;
      T000Y3_A273RecetaMedicaAtencion = new String[] {""} ;
      T000Y3_n273RecetaMedicaAtencion = new boolean[] {false} ;
      T000Y3_A270RecetaMedicaArchivo = new String[] {""} ;
      T000Y3_n270RecetaMedicaArchivo = new boolean[] {false} ;
      T000Y3_A272RecetaMedicaFlag = new byte[1] ;
      T000Y3_n272RecetaMedicaFlag = new boolean[] {false} ;
      T000Y3_A332RecetaIndicaciones = new String[] {""} ;
      T000Y3_A271RecetaArchivoTipo = new String[] {""} ;
      T000Y3_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      T000Y3_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      T000Y3_A19CitaId = new int[1] ;
      T000Y3_A42MedicamentoId = new short[1] ;
      T000Y3_n42MedicamentoId = new boolean[] {false} ;
      T000Y10_A50RecetaMedicaId = new short[1] ;
      T000Y11_A50RecetaMedicaId = new short[1] ;
      T000Y2_A50RecetaMedicaId = new short[1] ;
      T000Y2_A268RecetaMedicaConcentracion = new String[] {""} ;
      T000Y2_n268RecetaMedicaConcentracion = new boolean[] {false} ;
      T000Y2_A269RecetaMedicaCantidad = new short[1] ;
      T000Y2_n269RecetaMedicaCantidad = new boolean[] {false} ;
      T000Y2_A273RecetaMedicaAtencion = new String[] {""} ;
      T000Y2_n273RecetaMedicaAtencion = new boolean[] {false} ;
      T000Y2_A270RecetaMedicaArchivo = new String[] {""} ;
      T000Y2_n270RecetaMedicaArchivo = new boolean[] {false} ;
      T000Y2_A272RecetaMedicaFlag = new byte[1] ;
      T000Y2_n272RecetaMedicaFlag = new boolean[] {false} ;
      T000Y2_A332RecetaIndicaciones = new String[] {""} ;
      T000Y2_A271RecetaArchivoTipo = new String[] {""} ;
      T000Y2_A267RecetaMedicaNombreArchivo = new String[] {""} ;
      T000Y2_n267RecetaMedicaNombreArchivo = new boolean[] {false} ;
      T000Y2_A19CitaId = new int[1] ;
      T000Y2_A42MedicamentoId = new short[1] ;
      T000Y2_n42MedicamentoId = new boolean[] {false} ;
      T000Y12_A50RecetaMedicaId = new short[1] ;
      T000Y16_A229MedicamentoCodigo = new String[] {""} ;
      T000Y16_A230MedicamentoNombre = new String[] {""} ;
      T000Y16_A231MedicamentoFormaFarm = new String[] {""} ;
      T000Y16_n231MedicamentoFormaFarm = new boolean[] {false} ;
      T000Y17_A50RecetaMedicaId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000Y18_A19CitaId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.recetamedica__default(),
         new Object[] {
             new Object[] {
            T000Y2_A50RecetaMedicaId, T000Y2_A268RecetaMedicaConcentracion, T000Y2_n268RecetaMedicaConcentracion, T000Y2_A269RecetaMedicaCantidad, T000Y2_n269RecetaMedicaCantidad, T000Y2_A273RecetaMedicaAtencion, T000Y2_n273RecetaMedicaAtencion, T000Y2_A270RecetaMedicaArchivo, T000Y2_n270RecetaMedicaArchivo, T000Y2_A272RecetaMedicaFlag,
            T000Y2_n272RecetaMedicaFlag, T000Y2_A332RecetaIndicaciones, T000Y2_A271RecetaArchivoTipo, T000Y2_A267RecetaMedicaNombreArchivo, T000Y2_n267RecetaMedicaNombreArchivo, T000Y2_A19CitaId, T000Y2_A42MedicamentoId, T000Y2_n42MedicamentoId
            }
            , new Object[] {
            T000Y3_A50RecetaMedicaId, T000Y3_A268RecetaMedicaConcentracion, T000Y3_n268RecetaMedicaConcentracion, T000Y3_A269RecetaMedicaCantidad, T000Y3_n269RecetaMedicaCantidad, T000Y3_A273RecetaMedicaAtencion, T000Y3_n273RecetaMedicaAtencion, T000Y3_A270RecetaMedicaArchivo, T000Y3_n270RecetaMedicaArchivo, T000Y3_A272RecetaMedicaFlag,
            T000Y3_n272RecetaMedicaFlag, T000Y3_A332RecetaIndicaciones, T000Y3_A271RecetaArchivoTipo, T000Y3_A267RecetaMedicaNombreArchivo, T000Y3_n267RecetaMedicaNombreArchivo, T000Y3_A19CitaId, T000Y3_A42MedicamentoId, T000Y3_n42MedicamentoId
            }
            , new Object[] {
            T000Y4_A19CitaId
            }
            , new Object[] {
            T000Y5_A229MedicamentoCodigo, T000Y5_A230MedicamentoNombre, T000Y5_A231MedicamentoFormaFarm, T000Y5_n231MedicamentoFormaFarm
            }
            , new Object[] {
            T000Y6_A50RecetaMedicaId, T000Y6_A229MedicamentoCodigo, T000Y6_A230MedicamentoNombre, T000Y6_A231MedicamentoFormaFarm, T000Y6_n231MedicamentoFormaFarm, T000Y6_A268RecetaMedicaConcentracion, T000Y6_n268RecetaMedicaConcentracion, T000Y6_A269RecetaMedicaCantidad, T000Y6_n269RecetaMedicaCantidad, T000Y6_A273RecetaMedicaAtencion,
            T000Y6_n273RecetaMedicaAtencion, T000Y6_A270RecetaMedicaArchivo, T000Y6_n270RecetaMedicaArchivo, T000Y6_A272RecetaMedicaFlag, T000Y6_n272RecetaMedicaFlag, T000Y6_A332RecetaIndicaciones, T000Y6_A271RecetaArchivoTipo, T000Y6_A267RecetaMedicaNombreArchivo, T000Y6_n267RecetaMedicaNombreArchivo, T000Y6_A19CitaId,
            T000Y6_A42MedicamentoId, T000Y6_n42MedicamentoId
            }
            , new Object[] {
            T000Y7_A19CitaId
            }
            , new Object[] {
            T000Y8_A229MedicamentoCodigo, T000Y8_A230MedicamentoNombre, T000Y8_A231MedicamentoFormaFarm, T000Y8_n231MedicamentoFormaFarm
            }
            , new Object[] {
            T000Y9_A50RecetaMedicaId
            }
            , new Object[] {
            T000Y10_A50RecetaMedicaId
            }
            , new Object[] {
            T000Y11_A50RecetaMedicaId
            }
            , new Object[] {
            T000Y12_A50RecetaMedicaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Y16_A229MedicamentoCodigo, T000Y16_A230MedicamentoNombre, T000Y16_A231MedicamentoFormaFarm, T000Y16_n231MedicamentoFormaFarm
            }
            , new Object[] {
            T000Y17_A50RecetaMedicaId
            }
            , new Object[] {
            T000Y18_A19CitaId
            }
         }
      );
      AV24Pgmname = "RecetaMedica" ;
   }

   private byte Z272RecetaMedicaFlag ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A272RecetaMedicaFlag ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV15RecetaMedicaId ;
   private short Z50RecetaMedicaId ;
   private short Z269RecetaMedicaCantidad ;
   private short Z42MedicamentoId ;
   private short N42MedicamentoId ;
   private short A42MedicamentoId ;
   private short AV15RecetaMedicaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A50RecetaMedicaId ;
   private short A269RecetaMedicaCantidad ;
   private short AV23ComboMedicamentoId ;
   private short AV13Insert_MedicamentoId ;
   private short RcdFound43 ;
   private short nIsDirty_43 ;
   private int Z19CitaId ;
   private int N19CitaId ;
   private int A19CitaId ;
   private int trnEnded ;
   private int edtRecetaMedicaId_Enabled ;
   private int edtCitaId_Visible ;
   private int edtCitaId_Enabled ;
   private int edtMedicamentoId_Visible ;
   private int edtMedicamentoId_Enabled ;
   private int edtMedicamentoCodigo_Enabled ;
   private int edtMedicamentoNombre_Enabled ;
   private int edtMedicamentoFormaFarm_Enabled ;
   private int edtRecetaMedicaConcentracion_Enabled ;
   private int edtRecetaMedicaCantidad_Enabled ;
   private int edtRecetaMedicaAtencion_Enabled ;
   private int edtRecetaMedicaArchivo_Enabled ;
   private int edtRecetaMedicaFlag_Enabled ;
   private int edtRecetaIndicaciones_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV21ComboCitaId ;
   private int edtavCombocitaid_Enabled ;
   private int edtavCombocitaid_Visible ;
   private int edtavCombomedicamentoid_Enabled ;
   private int edtavCombomedicamentoid_Visible ;
   private int edtRecetaMedicaNombreArchivo_Visible ;
   private int edtRecetaMedicaNombreArchivo_Enabled ;
   private int edtRecetaArchivoTipo_Visible ;
   private int edtRecetaArchivoTipo_Enabled ;
   private int AV12Insert_CitaId ;
   private int Combo_citaid_Datalistupdateminimumcharacters ;
   private int Combo_medicamentoid_Datalistupdateminimumcharacters ;
   private int AV25GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_medicamentoid_Selectedvalue_get ;
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
   private String edtRecetaMedicaId_Internalname ;
   private String edtRecetaMedicaId_Jsonclick ;
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
   private String divTablesplittedmedicamentoid_Internalname ;
   private String lblTextblockmedicamentoid_Internalname ;
   private String lblTextblockmedicamentoid_Jsonclick ;
   private String Combo_medicamentoid_Caption ;
   private String Combo_medicamentoid_Cls ;
   private String Combo_medicamentoid_Datalistproc ;
   private String Combo_medicamentoid_Datalistprocparametersprefix ;
   private String Combo_medicamentoid_Internalname ;
   private String edtMedicamentoId_Internalname ;
   private String edtMedicamentoId_Jsonclick ;
   private String edtMedicamentoCodigo_Internalname ;
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
   private String edtRecetaMedicaArchivo_Filename ;
   private String edtRecetaMedicaArchivo_Filetype ;
   private String edtRecetaMedicaArchivo_Contenttype ;
   private String edtRecetaMedicaArchivo_Parameters ;
   private String edtRecetaMedicaArchivo_Jsonclick ;
   private String edtRecetaMedicaFlag_Internalname ;
   private String edtRecetaMedicaFlag_Jsonclick ;
   private String edtRecetaIndicaciones_Internalname ;
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
   private String divSectionattribute_medicamentoid_Internalname ;
   private String edtavCombomedicamentoid_Internalname ;
   private String edtavCombomedicamentoid_Jsonclick ;
   private String edtRecetaMedicaNombreArchivo_Internalname ;
   private String edtRecetaMedicaNombreArchivo_Jsonclick ;
   private String edtRecetaArchivoTipo_Internalname ;
   private String edtRecetaArchivoTipo_Jsonclick ;
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
   private String Combo_medicamentoid_Objectcall ;
   private String Combo_medicamentoid_Class ;
   private String Combo_medicamentoid_Icontype ;
   private String Combo_medicamentoid_Icon ;
   private String Combo_medicamentoid_Tooltip ;
   private String Combo_medicamentoid_Selectedvalue_set ;
   private String Combo_medicamentoid_Selectedtext_set ;
   private String Combo_medicamentoid_Selectedtext_get ;
   private String Combo_medicamentoid_Gamoauthtoken ;
   private String Combo_medicamentoid_Ddointernalname ;
   private String Combo_medicamentoid_Titlecontrolalign ;
   private String Combo_medicamentoid_Dropdownoptionstype ;
   private String Combo_medicamentoid_Titlecontrolidtoreplace ;
   private String Combo_medicamentoid_Datalisttype ;
   private String Combo_medicamentoid_Datalistfixedvalues ;
   private String Combo_medicamentoid_Htmltemplate ;
   private String Combo_medicamentoid_Multiplevaluestype ;
   private String Combo_medicamentoid_Loadingdata ;
   private String Combo_medicamentoid_Noresultsfound ;
   private String Combo_medicamentoid_Emptyitemtext ;
   private String Combo_medicamentoid_Onlyselectedvalues ;
   private String Combo_medicamentoid_Selectalltext ;
   private String Combo_medicamentoid_Multiplevaluesseparator ;
   private String Combo_medicamentoid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String GXCCtlgxBlob ;
   private String hsh ;
   private String sMode43 ;
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
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n42MedicamentoId ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_citaid_Emptyitem ;
   private boolean n270RecetaMedicaArchivo ;
   private boolean n268RecetaMedicaConcentracion ;
   private boolean n269RecetaMedicaCantidad ;
   private boolean n273RecetaMedicaAtencion ;
   private boolean n272RecetaMedicaFlag ;
   private boolean Combo_citaid_Enabled ;
   private boolean Combo_citaid_Visible ;
   private boolean Combo_citaid_Allowmultipleselection ;
   private boolean Combo_citaid_Isgriditem ;
   private boolean Combo_citaid_Hasdescription ;
   private boolean Combo_citaid_Includeonlyselectedoption ;
   private boolean Combo_citaid_Includeselectalloption ;
   private boolean Combo_citaid_Includeaddnewoption ;
   private boolean Combo_medicamentoid_Enabled ;
   private boolean Combo_medicamentoid_Visible ;
   private boolean Combo_medicamentoid_Allowmultipleselection ;
   private boolean Combo_medicamentoid_Isgriditem ;
   private boolean Combo_medicamentoid_Hasdescription ;
   private boolean Combo_medicamentoid_Includeonlyselectedoption ;
   private boolean Combo_medicamentoid_Includeselectalloption ;
   private boolean Combo_medicamentoid_Emptyitem ;
   private boolean Combo_medicamentoid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n231MedicamentoFormaFarm ;
   private boolean n267RecetaMedicaNombreArchivo ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV20Combo_DataJson ;
   private String A270RecetaMedicaArchivo ;
   private String Z270RecetaMedicaArchivo ;
   private String Z268RecetaMedicaConcentracion ;
   private String Z273RecetaMedicaAtencion ;
   private String Z332RecetaIndicaciones ;
   private String A229MedicamentoCodigo ;
   private String A230MedicamentoNombre ;
   private String A231MedicamentoFormaFarm ;
   private String A268RecetaMedicaConcentracion ;
   private String A273RecetaMedicaAtencion ;
   private String A267RecetaMedicaNombreArchivo ;
   private String A271RecetaArchivoTipo ;
   private String A332RecetaIndicaciones ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private String Z271RecetaArchivoTipo ;
   private String Z267RecetaMedicaNombreArchivo ;
   private String Z229MedicamentoCodigo ;
   private String Z230MedicamentoNombre ;
   private String Z231MedicamentoFormaFarm ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_citaid ;
   private com.genexus.webpanels.GXUserControl ucCombo_medicamentoid ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T000Y5_A229MedicamentoCodigo ;
   private String[] T000Y5_A230MedicamentoNombre ;
   private String[] T000Y5_A231MedicamentoFormaFarm ;
   private boolean[] T000Y5_n231MedicamentoFormaFarm ;
   private short[] T000Y6_A50RecetaMedicaId ;
   private String[] T000Y6_A229MedicamentoCodigo ;
   private String[] T000Y6_A230MedicamentoNombre ;
   private String[] T000Y6_A231MedicamentoFormaFarm ;
   private boolean[] T000Y6_n231MedicamentoFormaFarm ;
   private String[] T000Y6_A268RecetaMedicaConcentracion ;
   private boolean[] T000Y6_n268RecetaMedicaConcentracion ;
   private short[] T000Y6_A269RecetaMedicaCantidad ;
   private boolean[] T000Y6_n269RecetaMedicaCantidad ;
   private String[] T000Y6_A273RecetaMedicaAtencion ;
   private boolean[] T000Y6_n273RecetaMedicaAtencion ;
   private String[] T000Y6_A270RecetaMedicaArchivo ;
   private boolean[] T000Y6_n270RecetaMedicaArchivo ;
   private byte[] T000Y6_A272RecetaMedicaFlag ;
   private boolean[] T000Y6_n272RecetaMedicaFlag ;
   private String[] T000Y6_A332RecetaIndicaciones ;
   private String[] T000Y6_A271RecetaArchivoTipo ;
   private String[] T000Y6_A267RecetaMedicaNombreArchivo ;
   private boolean[] T000Y6_n267RecetaMedicaNombreArchivo ;
   private int[] T000Y6_A19CitaId ;
   private short[] T000Y6_A42MedicamentoId ;
   private boolean[] T000Y6_n42MedicamentoId ;
   private int[] T000Y4_A19CitaId ;
   private int[] T000Y7_A19CitaId ;
   private String[] T000Y8_A229MedicamentoCodigo ;
   private String[] T000Y8_A230MedicamentoNombre ;
   private String[] T000Y8_A231MedicamentoFormaFarm ;
   private boolean[] T000Y8_n231MedicamentoFormaFarm ;
   private short[] T000Y9_A50RecetaMedicaId ;
   private short[] T000Y3_A50RecetaMedicaId ;
   private String[] T000Y3_A268RecetaMedicaConcentracion ;
   private boolean[] T000Y3_n268RecetaMedicaConcentracion ;
   private short[] T000Y3_A269RecetaMedicaCantidad ;
   private boolean[] T000Y3_n269RecetaMedicaCantidad ;
   private String[] T000Y3_A273RecetaMedicaAtencion ;
   private boolean[] T000Y3_n273RecetaMedicaAtencion ;
   private String[] T000Y3_A270RecetaMedicaArchivo ;
   private boolean[] T000Y3_n270RecetaMedicaArchivo ;
   private byte[] T000Y3_A272RecetaMedicaFlag ;
   private boolean[] T000Y3_n272RecetaMedicaFlag ;
   private String[] T000Y3_A332RecetaIndicaciones ;
   private String[] T000Y3_A271RecetaArchivoTipo ;
   private String[] T000Y3_A267RecetaMedicaNombreArchivo ;
   private boolean[] T000Y3_n267RecetaMedicaNombreArchivo ;
   private int[] T000Y3_A19CitaId ;
   private short[] T000Y3_A42MedicamentoId ;
   private boolean[] T000Y3_n42MedicamentoId ;
   private short[] T000Y10_A50RecetaMedicaId ;
   private short[] T000Y11_A50RecetaMedicaId ;
   private short[] T000Y2_A50RecetaMedicaId ;
   private String[] T000Y2_A268RecetaMedicaConcentracion ;
   private boolean[] T000Y2_n268RecetaMedicaConcentracion ;
   private short[] T000Y2_A269RecetaMedicaCantidad ;
   private boolean[] T000Y2_n269RecetaMedicaCantidad ;
   private String[] T000Y2_A273RecetaMedicaAtencion ;
   private boolean[] T000Y2_n273RecetaMedicaAtencion ;
   private String[] T000Y2_A270RecetaMedicaArchivo ;
   private boolean[] T000Y2_n270RecetaMedicaArchivo ;
   private byte[] T000Y2_A272RecetaMedicaFlag ;
   private boolean[] T000Y2_n272RecetaMedicaFlag ;
   private String[] T000Y2_A332RecetaIndicaciones ;
   private String[] T000Y2_A271RecetaArchivoTipo ;
   private String[] T000Y2_A267RecetaMedicaNombreArchivo ;
   private boolean[] T000Y2_n267RecetaMedicaNombreArchivo ;
   private int[] T000Y2_A19CitaId ;
   private short[] T000Y2_A42MedicamentoId ;
   private boolean[] T000Y2_n42MedicamentoId ;
   private short[] T000Y12_A50RecetaMedicaId ;
   private String[] T000Y16_A229MedicamentoCodigo ;
   private String[] T000Y16_A230MedicamentoNombre ;
   private String[] T000Y16_A231MedicamentoFormaFarm ;
   private boolean[] T000Y16_n231MedicamentoFormaFarm ;
   private short[] T000Y17_A50RecetaMedicaId ;
   private int[] T000Y18_A19CitaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16CitaId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22MedicamentoId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class recetamedica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Y2", "SELECT [RecetaMedicaId], [RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId] FROM [RecetaMedica] WITH (UPDLOCK) WHERE [RecetaMedicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y3", "SELECT [RecetaMedicaId], [RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId] FROM [RecetaMedica] WHERE [RecetaMedicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y4", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y5", "SELECT [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y6", "SELECT TM1.[RecetaMedicaId], T2.[MedicamentoCodigo], T2.[MedicamentoNombre], T2.[MedicamentoFormaFarm], TM1.[RecetaMedicaConcentracion], TM1.[RecetaMedicaCantidad], TM1.[RecetaMedicaAtencion], TM1.[RecetaMedicaArchivo], TM1.[RecetaMedicaFlag], TM1.[RecetaIndicaciones], TM1.[RecetaArchivoTipo], TM1.[RecetaMedicaNombreArchivo], TM1.[CitaId], TM1.[MedicamentoId] FROM ([RecetaMedica] TM1 LEFT JOIN [Medicamento] T2 ON T2.[MedicamentoId] = TM1.[MedicamentoId]) WHERE TM1.[RecetaMedicaId] = ? ORDER BY TM1.[RecetaMedicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y7", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y8", "SELECT [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y9", "SELECT [RecetaMedicaId] FROM [RecetaMedica] WHERE [RecetaMedicaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y10", "SELECT TOP 1 [RecetaMedicaId] FROM [RecetaMedica] WHERE ( [RecetaMedicaId] > ?) ORDER BY [RecetaMedicaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y11", "SELECT TOP 1 [RecetaMedicaId] FROM [RecetaMedica] WHERE ( [RecetaMedicaId] < ?) ORDER BY [RecetaMedicaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Y12", "INSERT INTO [RecetaMedica]([RecetaMedicaConcentracion], [RecetaMedicaCantidad], [RecetaMedicaAtencion], [RecetaMedicaArchivo], [RecetaMedicaFlag], [RecetaIndicaciones], [RecetaArchivoTipo], [RecetaMedicaNombreArchivo], [CitaId], [MedicamentoId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000Y13", "UPDATE [RecetaMedica] SET [RecetaMedicaConcentracion]=?, [RecetaMedicaCantidad]=?, [RecetaMedicaAtencion]=?, [RecetaMedicaFlag]=?, [RecetaIndicaciones]=?, [RecetaArchivoTipo]=?, [RecetaMedicaNombreArchivo]=?, [CitaId]=?, [MedicamentoId]=?  WHERE [RecetaMedicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000Y14", "UPDATE [RecetaMedica] SET [RecetaMedicaArchivo]=?  WHERE [RecetaMedicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000Y15", "DELETE FROM [RecetaMedica]  WHERE [RecetaMedicaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000Y16", "SELECT [MedicamentoCodigo], [MedicamentoNombre], [MedicamentoFormaFarm] FROM [Medicamento] WHERE [MedicamentoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y17", "SELECT [RecetaMedicaId] FROM [RecetaMedica] ORDER BY [RecetaMedicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Y18", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getBLOBFile(5, rslt.getVarchar(8), rslt.getVarchar(9));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(7);
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((short[]) buf[16])[0] = rslt.getShort(11);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getBLOBFile(5, rslt.getVarchar(8), rslt.getVarchar(9));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(7);
               ((String[]) buf[12])[0] = rslt.getVarchar(8);
               ((String[]) buf[13])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((int[]) buf[15])[0] = rslt.getInt(10);
               ((short[]) buf[16])[0] = rslt.getShort(11);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getBLOBFile(8, rslt.getVarchar(11), rslt.getVarchar(12));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(9);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getVarchar(10);
               ((String[]) buf[16])[0] = rslt.getVarchar(11);
               ((String[]) buf[17])[0] = rslt.getVarchar(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(13);
               ((short[]) buf[20])[0] = rslt.getShort(14);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 40);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[5], 40);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(4, (String)parms[7]);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(5, ((Number) parms[9]).byteValue());
               }
               stmt.setVarchar(6, (String)parms[10], 300, false);
               stmt.setVarchar(7, (String)parms[11], 30, false);
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[13], 100);
               }
               stmt.setInt(9, ((Number) parms[14]).intValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[16]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 40);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[3]).shortValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[5], 40);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[7]).byteValue());
               }
               stmt.setVarchar(5, (String)parms[8], 300, false);
               stmt.setVarchar(6, (String)parms[9], 30, false);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[11], 100);
               }
               stmt.setInt(8, ((Number) parms[12]).intValue());
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(9, ((Number) parms[14]).shortValue());
               }
               stmt.setShort(10, ((Number) parms[15]).shortValue());
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               stmt.setShort(2, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

