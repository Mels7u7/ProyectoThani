package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sede_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A28ClinicaId = (short)(GXutil.lval( httpContext.GetPar( "ClinicaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A28ClinicaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_18") == 0 )
      {
         A44UbigeoCode = httpContext.GetPar( "UbigeoCode") ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_18( A44UbigeoCode) ;
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
            AV27SedeId = (short)(GXutil.lval( httpContext.GetPar( "SedeId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27SedeId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSEDEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27SedeId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Sede", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSedeNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public sede_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sede_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sede_impl.class ));
   }

   public sede_impl( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSedeEstado = new HTMLChoice();
      cmbSedeTipo = new HTMLChoice();
      cmbSedeSector = new HTMLChoice();
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
      if ( cmbSedeEstado.getItemCount() > 0 )
      {
         A278SedeEstado = cmbSedeEstado.getValidValue(A278SedeEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A278SedeEstado", A278SedeEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSedeEstado.setValue( GXutil.rtrim( A278SedeEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeEstado.getInternalname(), "Values", cmbSedeEstado.ToJavascriptSource(), true);
      }
      if ( cmbSedeTipo.getItemCount() > 0 )
      {
         A279SedeTipo = cmbSedeTipo.getValidValue(A279SedeTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A279SedeTipo", A279SedeTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSedeTipo.setValue( GXutil.rtrim( A279SedeTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipo.getInternalname(), "Values", cmbSedeTipo.ToJavascriptSource(), true);
      }
      if ( cmbSedeSector.getItemCount() > 0 )
      {
         A280SedeSector = cmbSedeSector.getValidValue(A280SedeSector) ;
         httpContext.ajax_rsp_assign_attri("", false, "A280SedeSector", A280SedeSector);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSedeSector.setValue( GXutil.rtrim( A280SedeSector) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeSector.getInternalname(), "Values", cmbSedeSector.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSedeId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSedeId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSedeId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSedeId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSedeId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSedeNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSedeNombre_Internalname, "Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSedeNombre_Internalname, A75SedeNombre, GXutil.rtrim( localUtil.format( A75SedeNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSedeNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSedeNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedclinicaid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockclinicaid_Internalname, "Clinica Id", "", "", lblTextblockclinicaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_clinicaid.setProperty("Caption", Combo_clinicaid_Caption);
      ucCombo_clinicaid.setProperty("Cls", Combo_clinicaid_Cls);
      ucCombo_clinicaid.setProperty("DataListProc", Combo_clinicaid_Datalistproc);
      ucCombo_clinicaid.setProperty("DataListProcParametersPrefix", Combo_clinicaid_Datalistprocparametersprefix);
      ucCombo_clinicaid.setProperty("EmptyItem", Combo_clinicaid_Emptyitem);
      ucCombo_clinicaid.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_clinicaid.setProperty("DropDownOptionsData", AV23ClinicaId_Data);
      ucCombo_clinicaid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_clinicaid_Internalname, "COMBO_CLINICAIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaId_Internalname, "Clinica Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaId_Jsonclick, 0, "Attribute", "", "", "", "", edtClinicaId_Visible, edtClinicaId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Sede.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgprompt_28_Internalname, sImgUrl, imgprompt_28_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_28_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Sede.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaRUC_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaRUC_Internalname, "Clinica RUC", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaRUC_Internalname, GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ",", "")), GXutil.ltrim( ((edtClinicaRUC_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaRUC_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaRUC_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Sede.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaNombreComercial_Internalname, "Nombre Comercial", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaNombreComercial_Internalname, A116ClinicaNombreComercial, GXutil.rtrim( localUtil.format( A116ClinicaNombreComercial, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaNombreComercial_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaNombreComercial_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedubigeocode_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockubigeocode_Internalname, "Ubigeo Code", "", "", lblTextblockubigeocode_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_ubigeocode.setProperty("Caption", Combo_ubigeocode_Caption);
      ucCombo_ubigeocode.setProperty("Cls", Combo_ubigeocode_Cls);
      ucCombo_ubigeocode.setProperty("DataListProc", Combo_ubigeocode_Datalistproc);
      ucCombo_ubigeocode.setProperty("DataListProcParametersPrefix", Combo_ubigeocode_Datalistprocparametersprefix);
      ucCombo_ubigeocode.setProperty("EmptyItem", Combo_ubigeocode_Emptyitem);
      ucCombo_ubigeocode.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_ubigeocode.setProperty("DropDownOptionsData", AV25UbigeoCode_Data);
      ucCombo_ubigeocode.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_ubigeocode_Internalname, "COMBO_UBIGEOCODEContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoCode_Internalname, "Ubigeo Code", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoCode_Internalname, GXutil.rtrim( A44UbigeoCode), GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoCode_Jsonclick, 0, "Attribute", "", "", "", "", edtUbigeoCode_Visible, edtUbigeoCode_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sede.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "f5b04895-0024-488b-8e3b-b687ca4598ee", "", context.getHttpContext().getTheme( )) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgprompt_44_Internalname, sImgUrl, imgprompt_44_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_44_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Sede.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoNombre_Internalname, "Ubigeo Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoNombre_Internalname, A185UbigeoNombre, GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSedeDireccion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSedeDireccion_Internalname, "Direccion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSedeDireccion_Internalname, A276SedeDireccion, GXutil.rtrim( localUtil.format( A276SedeDireccion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSedeDireccion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSedeDireccion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSedeCorreo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSedeCorreo_Internalname, "Correo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSedeCorreo_Internalname, A277SedeCorreo, GXutil.rtrim( localUtil.format( A277SedeCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A277SedeCorreo, "", "", "", edtSedeCorreo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSedeCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSedeEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbSedeEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 79,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSedeEstado, cmbSedeEstado.getInternalname(), GXutil.rtrim( A278SedeEstado), 1, cmbSedeEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbSedeEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,79);\"", "", true, (byte)(1), "HLP_Sede.htm");
      cmbSedeEstado.setValue( GXutil.rtrim( A278SedeEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeEstado.getInternalname(), "Values", cmbSedeEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSedeTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbSedeTipo.getInternalname(), "Tipo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 84,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSedeTipo, cmbSedeTipo.getInternalname(), GXutil.rtrim( A279SedeTipo), 1, cmbSedeTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbSedeTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,84);\"", "", true, (byte)(1), "HLP_Sede.htm");
      cmbSedeTipo.setValue( GXutil.rtrim( A279SedeTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipo.getInternalname(), "Values", cmbSedeTipo.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSedeSector.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbSedeSector.getInternalname(), "Sector", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSedeSector, cmbSedeSector.getInternalname(), GXutil.rtrim( A280SedeSector), 1, cmbSedeSector.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbSedeSector.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "", true, (byte)(1), "HLP_Sede.htm");
      cmbSedeSector.setValue( GXutil.rtrim( A280SedeSector) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeSector.getInternalname(), "Values", cmbSedeSector.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 96,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Sede.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_clinicaid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboclinicaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV24ComboClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavComboclinicaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV24ComboClinicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV24ComboClinicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboclinicaid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboclinicaid_Visible, edtavComboclinicaid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Sede.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_ubigeocode_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboubigeocode_Internalname, GXutil.rtrim( AV26ComboUbigeoCode), GXutil.rtrim( localUtil.format( AV26ComboUbigeoCode, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboubigeocode_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboubigeocode_Visible, edtavComboubigeocode_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Sede.htm");
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
      e110N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCLINICAID_DATA"), AV23ClinicaId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUBIGEOCODE_DATA"), AV25UbigeoCode_Data);
            /* Read saved values. */
            Z30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( "Z30SedeId"), ",", ".")) ;
            Z75SedeNombre = httpContext.cgiGet( "Z75SedeNombre") ;
            Z276SedeDireccion = httpContext.cgiGet( "Z276SedeDireccion") ;
            Z277SedeCorreo = httpContext.cgiGet( "Z277SedeCorreo") ;
            Z278SedeEstado = httpContext.cgiGet( "Z278SedeEstado") ;
            Z279SedeTipo = httpContext.cgiGet( "Z279SedeTipo") ;
            Z280SedeSector = httpContext.cgiGet( "Z280SedeSector") ;
            Z28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z28ClinicaId"), ",", ".")) ;
            Z44UbigeoCode = httpContext.cgiGet( "Z44UbigeoCode") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( "N28ClinicaId"), ",", ".")) ;
            N44UbigeoCode = httpContext.cgiGet( "N44UbigeoCode") ;
            A186UbigeoDepartamento = httpContext.cgiGet( "UBIGEODEPARTAMENTO") ;
            A187UbigeoProvincia = httpContext.cgiGet( "UBIGEOPROVINCIA") ;
            A188UbigeoDistrito = httpContext.cgiGet( "UBIGEODISTRITO") ;
            AV27SedeId = (short)(localUtil.ctol( httpContext.cgiGet( "vSEDEID"), ",", ".")) ;
            AV14Insert_ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CLINICAID"), ",", ".")) ;
            AV12Insert_UbigeoCode = httpContext.cgiGet( "vINSERT_UBIGEOCODE") ;
            AV28Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_clinicaid_Objectcall = httpContext.cgiGet( "COMBO_CLINICAID_Objectcall") ;
            Combo_clinicaid_Class = httpContext.cgiGet( "COMBO_CLINICAID_Class") ;
            Combo_clinicaid_Icontype = httpContext.cgiGet( "COMBO_CLINICAID_Icontype") ;
            Combo_clinicaid_Icon = httpContext.cgiGet( "COMBO_CLINICAID_Icon") ;
            Combo_clinicaid_Caption = httpContext.cgiGet( "COMBO_CLINICAID_Caption") ;
            Combo_clinicaid_Tooltip = httpContext.cgiGet( "COMBO_CLINICAID_Tooltip") ;
            Combo_clinicaid_Cls = httpContext.cgiGet( "COMBO_CLINICAID_Cls") ;
            Combo_clinicaid_Selectedvalue_set = httpContext.cgiGet( "COMBO_CLINICAID_Selectedvalue_set") ;
            Combo_clinicaid_Selectedvalue_get = httpContext.cgiGet( "COMBO_CLINICAID_Selectedvalue_get") ;
            Combo_clinicaid_Selectedtext_set = httpContext.cgiGet( "COMBO_CLINICAID_Selectedtext_set") ;
            Combo_clinicaid_Selectedtext_get = httpContext.cgiGet( "COMBO_CLINICAID_Selectedtext_get") ;
            Combo_clinicaid_Gamoauthtoken = httpContext.cgiGet( "COMBO_CLINICAID_Gamoauthtoken") ;
            Combo_clinicaid_Ddointernalname = httpContext.cgiGet( "COMBO_CLINICAID_Ddointernalname") ;
            Combo_clinicaid_Titlecontrolalign = httpContext.cgiGet( "COMBO_CLINICAID_Titlecontrolalign") ;
            Combo_clinicaid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CLINICAID_Dropdownoptionstype") ;
            Combo_clinicaid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Enabled")) ;
            Combo_clinicaid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Visible")) ;
            Combo_clinicaid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CLINICAID_Titlecontrolidtoreplace") ;
            Combo_clinicaid_Datalisttype = httpContext.cgiGet( "COMBO_CLINICAID_Datalisttype") ;
            Combo_clinicaid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Allowmultipleselection")) ;
            Combo_clinicaid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CLINICAID_Datalistfixedvalues") ;
            Combo_clinicaid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Isgriditem")) ;
            Combo_clinicaid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Hasdescription")) ;
            Combo_clinicaid_Datalistproc = httpContext.cgiGet( "COMBO_CLINICAID_Datalistproc") ;
            Combo_clinicaid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CLINICAID_Datalistprocparametersprefix") ;
            Combo_clinicaid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CLINICAID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_clinicaid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Includeonlyselectedoption")) ;
            Combo_clinicaid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Includeselectalloption")) ;
            Combo_clinicaid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Emptyitem")) ;
            Combo_clinicaid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CLINICAID_Includeaddnewoption")) ;
            Combo_clinicaid_Htmltemplate = httpContext.cgiGet( "COMBO_CLINICAID_Htmltemplate") ;
            Combo_clinicaid_Multiplevaluestype = httpContext.cgiGet( "COMBO_CLINICAID_Multiplevaluestype") ;
            Combo_clinicaid_Loadingdata = httpContext.cgiGet( "COMBO_CLINICAID_Loadingdata") ;
            Combo_clinicaid_Noresultsfound = httpContext.cgiGet( "COMBO_CLINICAID_Noresultsfound") ;
            Combo_clinicaid_Emptyitemtext = httpContext.cgiGet( "COMBO_CLINICAID_Emptyitemtext") ;
            Combo_clinicaid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CLINICAID_Onlyselectedvalues") ;
            Combo_clinicaid_Selectalltext = httpContext.cgiGet( "COMBO_CLINICAID_Selectalltext") ;
            Combo_clinicaid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CLINICAID_Multiplevaluesseparator") ;
            Combo_clinicaid_Addnewoptiontext = httpContext.cgiGet( "COMBO_CLINICAID_Addnewoptiontext") ;
            Combo_ubigeocode_Objectcall = httpContext.cgiGet( "COMBO_UBIGEOCODE_Objectcall") ;
            Combo_ubigeocode_Class = httpContext.cgiGet( "COMBO_UBIGEOCODE_Class") ;
            Combo_ubigeocode_Icontype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Icontype") ;
            Combo_ubigeocode_Icon = httpContext.cgiGet( "COMBO_UBIGEOCODE_Icon") ;
            Combo_ubigeocode_Caption = httpContext.cgiGet( "COMBO_UBIGEOCODE_Caption") ;
            Combo_ubigeocode_Tooltip = httpContext.cgiGet( "COMBO_UBIGEOCODE_Tooltip") ;
            Combo_ubigeocode_Cls = httpContext.cgiGet( "COMBO_UBIGEOCODE_Cls") ;
            Combo_ubigeocode_Selectedvalue_set = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedvalue_set") ;
            Combo_ubigeocode_Selectedvalue_get = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedvalue_get") ;
            Combo_ubigeocode_Selectedtext_set = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedtext_set") ;
            Combo_ubigeocode_Selectedtext_get = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedtext_get") ;
            Combo_ubigeocode_Gamoauthtoken = httpContext.cgiGet( "COMBO_UBIGEOCODE_Gamoauthtoken") ;
            Combo_ubigeocode_Ddointernalname = httpContext.cgiGet( "COMBO_UBIGEOCODE_Ddointernalname") ;
            Combo_ubigeocode_Titlecontrolalign = httpContext.cgiGet( "COMBO_UBIGEOCODE_Titlecontrolalign") ;
            Combo_ubigeocode_Dropdownoptionstype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Dropdownoptionstype") ;
            Combo_ubigeocode_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Enabled")) ;
            Combo_ubigeocode_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Visible")) ;
            Combo_ubigeocode_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_UBIGEOCODE_Titlecontrolidtoreplace") ;
            Combo_ubigeocode_Datalisttype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalisttype") ;
            Combo_ubigeocode_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Allowmultipleselection")) ;
            Combo_ubigeocode_Datalistfixedvalues = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistfixedvalues") ;
            Combo_ubigeocode_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Isgriditem")) ;
            Combo_ubigeocode_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Hasdescription")) ;
            Combo_ubigeocode_Datalistproc = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistproc") ;
            Combo_ubigeocode_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistprocparametersprefix") ;
            Combo_ubigeocode_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_ubigeocode_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Includeonlyselectedoption")) ;
            Combo_ubigeocode_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Includeselectalloption")) ;
            Combo_ubigeocode_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Emptyitem")) ;
            Combo_ubigeocode_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Includeaddnewoption")) ;
            Combo_ubigeocode_Htmltemplate = httpContext.cgiGet( "COMBO_UBIGEOCODE_Htmltemplate") ;
            Combo_ubigeocode_Multiplevaluestype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Multiplevaluestype") ;
            Combo_ubigeocode_Loadingdata = httpContext.cgiGet( "COMBO_UBIGEOCODE_Loadingdata") ;
            Combo_ubigeocode_Noresultsfound = httpContext.cgiGet( "COMBO_UBIGEOCODE_Noresultsfound") ;
            Combo_ubigeocode_Emptyitemtext = httpContext.cgiGet( "COMBO_UBIGEOCODE_Emptyitemtext") ;
            Combo_ubigeocode_Onlyselectedvalues = httpContext.cgiGet( "COMBO_UBIGEOCODE_Onlyselectedvalues") ;
            Combo_ubigeocode_Selectalltext = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectalltext") ;
            Combo_ubigeocode_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_UBIGEOCODE_Multiplevaluesseparator") ;
            Combo_ubigeocode_Addnewoptiontext = httpContext.cgiGet( "COMBO_UBIGEOCODE_Addnewoptiontext") ;
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
            A30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
            A75SedeNombre = httpContext.cgiGet( edtSedeNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A75SedeNombre", A75SedeNombre);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtClinicaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtClinicaId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLINICAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtClinicaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A28ClinicaId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
            }
            else
            {
               A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtClinicaId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
            }
            A118ClinicaRUC = localUtil.ctol( httpContext.cgiGet( edtClinicaRUC_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
            A116ClinicaNombreComercial = httpContext.cgiGet( edtClinicaNombreComercial_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
            A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
            A276SedeDireccion = httpContext.cgiGet( edtSedeDireccion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A276SedeDireccion", A276SedeDireccion);
            A277SedeCorreo = httpContext.cgiGet( edtSedeCorreo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A277SedeCorreo", A277SedeCorreo);
            cmbSedeEstado.setValue( httpContext.cgiGet( cmbSedeEstado.getInternalname()) );
            A278SedeEstado = httpContext.cgiGet( cmbSedeEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A278SedeEstado", A278SedeEstado);
            cmbSedeTipo.setValue( httpContext.cgiGet( cmbSedeTipo.getInternalname()) );
            A279SedeTipo = httpContext.cgiGet( cmbSedeTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A279SedeTipo", A279SedeTipo);
            cmbSedeSector.setValue( httpContext.cgiGet( cmbSedeSector.getInternalname()) );
            A280SedeSector = httpContext.cgiGet( cmbSedeSector.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A280SedeSector", A280SedeSector);
            AV24ComboClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboclinicaid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV24ComboClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboClinicaId), 4, 0));
            AV26ComboUbigeoCode = httpContext.cgiGet( edtavComboubigeocode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26ComboUbigeoCode", AV26ComboUbigeoCode);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Sede");
            A30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
            forbiddenHiddens.add("SedeId", localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A30SedeId != Z30SedeId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("sede:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A30SedeId = (short)(GXutil.lval( httpContext.GetPar( "SedeId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
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
                  sMode44 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode44 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound44 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0N0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SEDEID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSedeId_Internalname ;
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
                        e110N2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120N2 ();
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
         e120N2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0N44( ) ;
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
         disableAttributes0N44( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclinicaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclinicaid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboubigeocode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboubigeocode_Enabled), 5, 0), true);
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

   public void confirm_0N0( )
   {
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0N44( ) ;
         }
         else
         {
            checkExtendedTable0N44( ) ;
            closeExtendedTableCursors0N44( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0N0( )
   {
   }

   public void e110N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV19DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV19DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtUbigeoCode_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Visible), 5, 0), true);
      AV26ComboUbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboUbigeoCode", AV26ComboUbigeoCode);
      edtavComboubigeocode_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboubigeocode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboubigeocode_Visible), 5, 0), true);
      edtClinicaId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Visible), 5, 0), true);
      AV24ComboClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboClinicaId), 4, 0));
      edtavComboclinicaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclinicaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclinicaid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCLINICAID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOUBIGEOCODE' */
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Insert", GXv_boolean5) ;
         sede_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Update", GXv_boolean5) ;
         sede_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSede_Delete", GXv_boolean5) ;
         sede_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV28Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV28Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV29GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29GXV1), 8, 0));
         while ( AV29GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV29GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ClinicaId") == 0 )
            {
               AV14Insert_ClinicaId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_ClinicaId), 4, 0));
               if ( ! (0==AV14Insert_ClinicaId) )
               {
                  AV24ComboClinicaId = AV14Insert_ClinicaId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV24ComboClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboClinicaId), 4, 0));
                  Combo_clinicaid_Selectedvalue_set = GXutil.trim( GXutil.str( AV24ComboClinicaId, 4, 0)) ;
                  ucCombo_clinicaid.sendProperty(context, "", false, Combo_clinicaid_Internalname, "SelectedValue_set", Combo_clinicaid_Selectedvalue_set);
                  GXt_char6 = AV22Combo_DataJson ;
                  GXv_char7[0] = AV20ComboSelectedValue ;
                  GXv_char8[0] = AV21ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.sedeloaddvcombo(remoteHandle, context).execute( "ClinicaId", "GET", false, AV27SedeId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  sede_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
                  sede_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
                  sede_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedValue", AV20ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedText", AV21ComboSelectedText);
                  AV22Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22Combo_DataJson", AV22Combo_DataJson);
                  Combo_clinicaid_Selectedtext_set = AV21ComboSelectedText ;
                  ucCombo_clinicaid.sendProperty(context, "", false, Combo_clinicaid_Internalname, "SelectedText_set", Combo_clinicaid_Selectedtext_set);
                  Combo_clinicaid_Enabled = false ;
                  ucCombo_clinicaid.sendProperty(context, "", false, Combo_clinicaid_Internalname, "Enabled", GXutil.booltostr( Combo_clinicaid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "UbigeoCode") == 0 )
            {
               AV12Insert_UbigeoCode = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_UbigeoCode", AV12Insert_UbigeoCode);
               if ( ! (GXutil.strcmp("", AV12Insert_UbigeoCode)==0) )
               {
                  AV26ComboUbigeoCode = AV12Insert_UbigeoCode ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV26ComboUbigeoCode", AV26ComboUbigeoCode);
                  Combo_ubigeocode_Selectedvalue_set = AV26ComboUbigeoCode ;
                  ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedValue_set", Combo_ubigeocode_Selectedvalue_set);
                  GXt_char6 = AV22Combo_DataJson ;
                  GXv_char9[0] = AV20ComboSelectedValue ;
                  GXv_char8[0] = AV21ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new com.projectthani.sedeloaddvcombo(remoteHandle, context).execute( "UbigeoCode", "GET", false, AV27SedeId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  sede_impl.this.AV20ComboSelectedValue = GXv_char9[0] ;
                  sede_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
                  sede_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedValue", AV20ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedText", AV21ComboSelectedText);
                  AV22Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22Combo_DataJson", AV22Combo_DataJson);
                  Combo_ubigeocode_Selectedtext_set = AV21ComboSelectedText ;
                  ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedText_set", Combo_ubigeocode_Selectedtext_set);
                  Combo_ubigeocode_Enabled = false ;
                  ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "Enabled", GXutil.booltostr( Combo_ubigeocode_Enabled));
               }
            }
            AV29GXV1 = (int)(AV29GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29GXV1), 8, 0));
         }
      }
   }

   public void e120N2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.sedeww", new String[] {}, new String[] {}) );
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
      /* 'LOADCOMBOUBIGEOCODE' Routine */
      returnInSub = false ;
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char9[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.sedeloaddvcombo(remoteHandle, context).execute( "UbigeoCode", Gx_mode, false, AV27SedeId, "", GXv_char9, GXv_char8, GXv_char7) ;
      sede_impl.this.AV20ComboSelectedValue = GXv_char9[0] ;
      sede_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      sede_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedValue", AV20ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedText", AV21ComboSelectedText);
      AV22Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Combo_DataJson", AV22Combo_DataJson);
      Combo_ubigeocode_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedValue_set", Combo_ubigeocode_Selectedvalue_set);
      Combo_ubigeocode_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedText_set", Combo_ubigeocode_Selectedtext_set);
      AV26ComboUbigeoCode = AV20ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26ComboUbigeoCode", AV26ComboUbigeoCode);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_ubigeocode_Enabled = false ;
         ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "Enabled", GXutil.booltostr( Combo_ubigeocode_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOCLINICAID' Routine */
      returnInSub = false ;
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char9[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.sedeloaddvcombo(remoteHandle, context).execute( "ClinicaId", Gx_mode, false, AV27SedeId, "", GXv_char9, GXv_char8, GXv_char7) ;
      sede_impl.this.AV20ComboSelectedValue = GXv_char9[0] ;
      sede_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      sede_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedValue", AV20ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSelectedText", AV21ComboSelectedText);
      AV22Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Combo_DataJson", AV22Combo_DataJson);
      Combo_clinicaid_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_clinicaid.sendProperty(context, "", false, Combo_clinicaid_Internalname, "SelectedValue_set", Combo_clinicaid_Selectedvalue_set);
      Combo_clinicaid_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_clinicaid.sendProperty(context, "", false, Combo_clinicaid_Internalname, "SelectedText_set", Combo_clinicaid_Selectedtext_set);
      AV24ComboClinicaId = (short)(GXutil.lval( AV20ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24ComboClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24ComboClinicaId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_clinicaid_Enabled = false ;
         ucCombo_clinicaid.sendProperty(context, "", false, Combo_clinicaid_Internalname, "Enabled", GXutil.booltostr( Combo_clinicaid_Enabled));
      }
   }

   public void zm0N44( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z75SedeNombre = T000N3_A75SedeNombre[0] ;
            Z276SedeDireccion = T000N3_A276SedeDireccion[0] ;
            Z277SedeCorreo = T000N3_A277SedeCorreo[0] ;
            Z278SedeEstado = T000N3_A278SedeEstado[0] ;
            Z279SedeTipo = T000N3_A279SedeTipo[0] ;
            Z280SedeSector = T000N3_A280SedeSector[0] ;
            Z28ClinicaId = T000N3_A28ClinicaId[0] ;
            Z44UbigeoCode = T000N3_A44UbigeoCode[0] ;
         }
         else
         {
            Z75SedeNombre = A75SedeNombre ;
            Z276SedeDireccion = A276SedeDireccion ;
            Z277SedeCorreo = A277SedeCorreo ;
            Z278SedeEstado = A278SedeEstado ;
            Z279SedeTipo = A279SedeTipo ;
            Z280SedeSector = A280SedeSector ;
            Z28ClinicaId = A28ClinicaId ;
            Z44UbigeoCode = A44UbigeoCode ;
         }
      }
      if ( GX_JID == -16 )
      {
         Z30SedeId = A30SedeId ;
         Z75SedeNombre = A75SedeNombre ;
         Z276SedeDireccion = A276SedeDireccion ;
         Z277SedeCorreo = A277SedeCorreo ;
         Z278SedeEstado = A278SedeEstado ;
         Z279SedeTipo = A279SedeTipo ;
         Z280SedeSector = A280SedeSector ;
         Z28ClinicaId = A28ClinicaId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z118ClinicaRUC = A118ClinicaRUC ;
         Z116ClinicaNombreComercial = A116ClinicaNombreComercial ;
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
      }
   }

   public void standaloneNotModal( )
   {
      edtSedeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), true);
      imgprompt_28_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.projectthani.clinicaprompt"+"',["+"{Ctrl:gx.dom.el('"+"CLINICAID"+"'), id:'"+"CLINICAID"+"'"+",IOType:'inout'}"+","+"{Ctrl:gx.dom.el('"+"CLINICARUC"+"'), id:'"+"CLINICARUC"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_44_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.projectthani.ubigeoprompt"+"',["+"{Ctrl:gx.dom.el('"+"UBIGEOCODE"+"'), id:'"+"UBIGEOCODE"+"'"+",IOType:'inout'}"+","+"{Ctrl:gx.dom.el('"+"UBIGEONOMBRE"+"'), id:'"+"UBIGEONOMBRE"+"'"+",IOType:'inout'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      edtSedeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV27SedeId) )
      {
         A30SedeId = AV27SedeId ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_ClinicaId) )
      {
         edtClinicaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Enabled), 5, 0), true);
      }
      else
      {
         edtClinicaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV12Insert_UbigeoCode)==0) )
      {
         edtUbigeoCode_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      }
      else
      {
         edtUbigeoCode_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_ClinicaId) )
      {
         A28ClinicaId = AV14Insert_ClinicaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      }
      else
      {
         A28ClinicaId = AV24ComboClinicaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV12Insert_UbigeoCode)==0) )
      {
         A44UbigeoCode = AV12Insert_UbigeoCode ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      }
      else
      {
         A44UbigeoCode = AV26ComboUbigeoCode ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
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
         AV28Pgmname = "Sede" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
         /* Using cursor T000N4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A28ClinicaId)});
         A118ClinicaRUC = T000N4_A118ClinicaRUC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
         A116ClinicaNombreComercial = T000N4_A116ClinicaNombreComercial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
         pr_default.close(2);
         /* Using cursor T000N5 */
         pr_default.execute(3, new Object[] {A44UbigeoCode});
         A186UbigeoDepartamento = T000N5_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T000N5_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T000N5_A188UbigeoDistrito[0] ;
         pr_default.close(3);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      }
   }

   public void load0N44( )
   {
      /* Using cursor T000N6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound44 = (short)(1) ;
         A75SedeNombre = T000N6_A75SedeNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A75SedeNombre", A75SedeNombre);
         A118ClinicaRUC = T000N6_A118ClinicaRUC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
         A116ClinicaNombreComercial = T000N6_A116ClinicaNombreComercial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
         A276SedeDireccion = T000N6_A276SedeDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A276SedeDireccion", A276SedeDireccion);
         A277SedeCorreo = T000N6_A277SedeCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A277SedeCorreo", A277SedeCorreo);
         A278SedeEstado = T000N6_A278SedeEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A278SedeEstado", A278SedeEstado);
         A279SedeTipo = T000N6_A279SedeTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A279SedeTipo", A279SedeTipo);
         A280SedeSector = T000N6_A280SedeSector[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A280SedeSector", A280SedeSector);
         A186UbigeoDepartamento = T000N6_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T000N6_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T000N6_A188UbigeoDistrito[0] ;
         A28ClinicaId = T000N6_A28ClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
         A44UbigeoCode = T000N6_A44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         zm0N44( -16) ;
      }
      pr_default.close(4);
      onLoadActions0N44( ) ;
   }

   public void onLoadActions0N44( )
   {
      AV28Pgmname = "Sede" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
   }

   public void checkExtendedTable0N44( )
   {
      nIsDirty_44 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV28Pgmname = "Sede" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
      /* Using cursor T000N4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A118ClinicaRUC = T000N4_A118ClinicaRUC[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
      A116ClinicaNombreComercial = T000N4_A116ClinicaNombreComercial[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
      pr_default.close(2);
      /* Using cursor T000N5 */
      pr_default.execute(3, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A186UbigeoDepartamento = T000N5_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000N5_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000N5_A188UbigeoDistrito[0] ;
      pr_default.close(3);
      nIsDirty_44 = (short)(1) ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      if ( ! ( GxRegex.IsMatch(A277SedeCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Sede Correo no coincide con el patrón especificado", "OutOfRange", 1, "SEDECORREO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeCorreo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A278SedeEstado, "A") == 0 ) || ( GXutil.strcmp(A278SedeEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sede Estado fuera de rango", "OutOfRange", 1, "SEDEESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSedeEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A279SedeTipo, "H") == 0 ) || ( GXutil.strcmp(A279SedeTipo, "C") == 0 ) || ( GXutil.strcmp(A279SedeTipo, "P") == 0 ) || ( GXutil.strcmp(A279SedeTipo, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sede Tipo fuera de rango", "OutOfRange", 1, "SEDETIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSedeTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A280SedeSector, "P") == 0 ) || ( GXutil.strcmp(A280SedeSector, "V") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sede Sector fuera de rango", "OutOfRange", 1, "SEDESECTOR");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSedeSector.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0N44( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_17( short A28ClinicaId )
   {
      /* Using cursor T000N7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A118ClinicaRUC = T000N7_A118ClinicaRUC[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
      A116ClinicaNombreComercial = T000N7_A116ClinicaNombreComercial[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A116ClinicaNombreComercial)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_18( String A44UbigeoCode )
   {
      /* Using cursor T000N8 */
      pr_default.execute(6, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A186UbigeoDepartamento = T000N8_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000N8_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000N8_A188UbigeoDistrito[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A186UbigeoDepartamento)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A187UbigeoProvincia)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A188UbigeoDistrito)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0N44( )
   {
      /* Using cursor T000N9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound44 = (short)(1) ;
      }
      else
      {
         RcdFound44 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000N3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0N44( 16) ;
         RcdFound44 = (short)(1) ;
         A30SedeId = T000N3_A30SedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
         A75SedeNombre = T000N3_A75SedeNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A75SedeNombre", A75SedeNombre);
         A276SedeDireccion = T000N3_A276SedeDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A276SedeDireccion", A276SedeDireccion);
         A277SedeCorreo = T000N3_A277SedeCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A277SedeCorreo", A277SedeCorreo);
         A278SedeEstado = T000N3_A278SedeEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A278SedeEstado", A278SedeEstado);
         A279SedeTipo = T000N3_A279SedeTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A279SedeTipo", A279SedeTipo);
         A280SedeSector = T000N3_A280SedeSector[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A280SedeSector", A280SedeSector);
         A28ClinicaId = T000N3_A28ClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
         A44UbigeoCode = T000N3_A44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         Z30SedeId = A30SedeId ;
         sMode44 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0N44( ) ;
         if ( AnyError == 1 )
         {
            RcdFound44 = (short)(0) ;
            initializeNonKey0N44( ) ;
         }
         Gx_mode = sMode44 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound44 = (short)(0) ;
         initializeNonKey0N44( ) ;
         sMode44 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode44 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0N44( ) ;
      if ( RcdFound44 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound44 = (short)(0) ;
      /* Using cursor T000N10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000N10_A30SedeId[0] < A30SedeId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000N10_A30SedeId[0] > A30SedeId ) ) )
         {
            A30SedeId = T000N10_A30SedeId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
            RcdFound44 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound44 = (short)(0) ;
      /* Using cursor T000N11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000N11_A30SedeId[0] > A30SedeId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000N11_A30SedeId[0] < A30SedeId ) ) )
         {
            A30SedeId = T000N11_A30SedeId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
            RcdFound44 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0N44( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSedeNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0N44( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound44 == 1 )
         {
            if ( A30SedeId != Z30SedeId )
            {
               A30SedeId = Z30SedeId ;
               httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SEDEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSedeId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSedeNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0N44( ) ;
               GX_FocusControl = edtSedeNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A30SedeId != Z30SedeId )
            {
               /* Insert record */
               GX_FocusControl = edtSedeNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0N44( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SEDEID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSedeId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSedeNombre_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0N44( ) ;
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
      if ( A30SedeId != Z30SedeId )
      {
         A30SedeId = Z30SedeId ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SEDEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSedeNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0N44( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000N2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sede"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z75SedeNombre, T000N2_A75SedeNombre[0]) != 0 ) || ( GXutil.strcmp(Z276SedeDireccion, T000N2_A276SedeDireccion[0]) != 0 ) || ( GXutil.strcmp(Z277SedeCorreo, T000N2_A277SedeCorreo[0]) != 0 ) || ( GXutil.strcmp(Z278SedeEstado, T000N2_A278SedeEstado[0]) != 0 ) || ( GXutil.strcmp(Z279SedeTipo, T000N2_A279SedeTipo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z280SedeSector, T000N2_A280SedeSector[0]) != 0 ) || ( Z28ClinicaId != T000N2_A28ClinicaId[0] ) || ( GXutil.strcmp(Z44UbigeoCode, T000N2_A44UbigeoCode[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z75SedeNombre, T000N2_A75SedeNombre[0]) != 0 )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"SedeNombre");
               GXutil.writeLogRaw("Old: ",Z75SedeNombre);
               GXutil.writeLogRaw("Current: ",T000N2_A75SedeNombre[0]);
            }
            if ( GXutil.strcmp(Z276SedeDireccion, T000N2_A276SedeDireccion[0]) != 0 )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"SedeDireccion");
               GXutil.writeLogRaw("Old: ",Z276SedeDireccion);
               GXutil.writeLogRaw("Current: ",T000N2_A276SedeDireccion[0]);
            }
            if ( GXutil.strcmp(Z277SedeCorreo, T000N2_A277SedeCorreo[0]) != 0 )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"SedeCorreo");
               GXutil.writeLogRaw("Old: ",Z277SedeCorreo);
               GXutil.writeLogRaw("Current: ",T000N2_A277SedeCorreo[0]);
            }
            if ( GXutil.strcmp(Z278SedeEstado, T000N2_A278SedeEstado[0]) != 0 )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"SedeEstado");
               GXutil.writeLogRaw("Old: ",Z278SedeEstado);
               GXutil.writeLogRaw("Current: ",T000N2_A278SedeEstado[0]);
            }
            if ( GXutil.strcmp(Z279SedeTipo, T000N2_A279SedeTipo[0]) != 0 )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"SedeTipo");
               GXutil.writeLogRaw("Old: ",Z279SedeTipo);
               GXutil.writeLogRaw("Current: ",T000N2_A279SedeTipo[0]);
            }
            if ( GXutil.strcmp(Z280SedeSector, T000N2_A280SedeSector[0]) != 0 )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"SedeSector");
               GXutil.writeLogRaw("Old: ",Z280SedeSector);
               GXutil.writeLogRaw("Current: ",T000N2_A280SedeSector[0]);
            }
            if ( Z28ClinicaId != T000N2_A28ClinicaId[0] )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"ClinicaId");
               GXutil.writeLogRaw("Old: ",Z28ClinicaId);
               GXutil.writeLogRaw("Current: ",T000N2_A28ClinicaId[0]);
            }
            if ( GXutil.strcmp(Z44UbigeoCode, T000N2_A44UbigeoCode[0]) != 0 )
            {
               GXutil.writeLogln("sede:[seudo value changed for attri]"+"UbigeoCode");
               GXutil.writeLogRaw("Old: ",Z44UbigeoCode);
               GXutil.writeLogRaw("Current: ",T000N2_A44UbigeoCode[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Sede"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0N44( )
   {
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0N44( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0N44( 0) ;
         checkOptimisticConcurrency0N44( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0N44( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0N44( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000N12 */
                  pr_default.execute(10, new Object[] {A75SedeNombre, A276SedeDireccion, A277SedeCorreo, A278SedeEstado, A279SedeTipo, A280SedeSector, Short.valueOf(A28ClinicaId), A44UbigeoCode});
                  A30SedeId = T000N12_A30SedeId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sede");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0N0( ) ;
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
            load0N44( ) ;
         }
         endLevel0N44( ) ;
      }
      closeExtendedTableCursors0N44( ) ;
   }

   public void update0N44( )
   {
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0N44( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0N44( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0N44( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0N44( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000N13 */
                  pr_default.execute(11, new Object[] {A75SedeNombre, A276SedeDireccion, A277SedeCorreo, A278SedeEstado, A279SedeTipo, A280SedeSector, Short.valueOf(A28ClinicaId), A44UbigeoCode, Short.valueOf(A30SedeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Sede");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Sede"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0N44( ) ;
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
         endLevel0N44( ) ;
      }
      closeExtendedTableCursors0N44( ) ;
   }

   public void deferredUpdate0N44( )
   {
   }

   public void delete( )
   {
      beforeValidate0N44( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0N44( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0N44( ) ;
         afterConfirm0N44( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0N44( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000N14 */
               pr_default.execute(12, new Object[] {Short.valueOf(A30SedeId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Sede");
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
      sMode44 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0N44( ) ;
      Gx_mode = sMode44 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0N44( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV28Pgmname = "Sede" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28Pgmname", AV28Pgmname);
         /* Using cursor T000N15 */
         pr_default.execute(13, new Object[] {Short.valueOf(A28ClinicaId)});
         A118ClinicaRUC = T000N15_A118ClinicaRUC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
         A116ClinicaNombreComercial = T000N15_A116ClinicaNombreComercial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
         pr_default.close(13);
         /* Using cursor T000N16 */
         pr_default.execute(14, new Object[] {A44UbigeoCode});
         A186UbigeoDepartamento = T000N16_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T000N16_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T000N16_A188UbigeoDistrito[0] ;
         pr_default.close(14);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000N17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sede"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T000N18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Disponibilidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T000N19 */
         pr_default.execute(17, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Conf Comision"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor T000N20 */
         pr_default.execute(18, new Object[] {Short.valueOf(A30SedeId)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sede"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
   }

   public void endLevel0N44( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0N44( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.commitDataStores(context, remoteHandle, pr_default, "sede");
         if ( AnyError == 0 )
         {
            confirmValues0N0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(13);
         pr_default.close(14);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "sede");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0N44( )
   {
      /* Scan By routine */
      /* Using cursor T000N21 */
      pr_default.execute(19);
      RcdFound44 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound44 = (short)(1) ;
         A30SedeId = T000N21_A30SedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0N44( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound44 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound44 = (short)(1) ;
         A30SedeId = T000N21_A30SedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
      }
   }

   public void scanEnd0N44( )
   {
      pr_default.close(19);
   }

   public void afterConfirm0N44( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0N44( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0N44( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0N44( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0N44( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0N44( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0N44( )
   {
      edtSedeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), true);
      edtSedeNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeNombre_Enabled), 5, 0), true);
      edtClinicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Enabled), 5, 0), true);
      edtClinicaRUC_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaRUC_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaRUC_Enabled), 5, 0), true);
      edtClinicaNombreComercial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreComercial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreComercial_Enabled), 5, 0), true);
      edtUbigeoCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      edtUbigeoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Enabled), 5, 0), true);
      edtSedeDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeDireccion_Enabled), 5, 0), true);
      edtSedeCorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeCorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeCorreo_Enabled), 5, 0), true);
      cmbSedeEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeEstado.getEnabled(), 5, 0), true);
      cmbSedeTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeTipo.getEnabled(), 5, 0), true);
      cmbSedeSector.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeSector.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeSector.getEnabled(), 5, 0), true);
      edtavComboclinicaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboclinicaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboclinicaid_Enabled), 5, 0), true);
      edtavComboubigeocode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboubigeocode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboubigeocode_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0N44( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0N0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325079", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.sede", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV27SedeId,4,0))}, new String[] {"Gx_mode","SedeId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Sede");
      forbiddenHiddens.add("SedeId", localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("sede:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z30SedeId", GXutil.ltrim( localUtil.ntoc( Z30SedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z75SedeNombre", Z75SedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z276SedeDireccion", Z276SedeDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z277SedeCorreo", Z277SedeCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z278SedeEstado", GXutil.rtrim( Z278SedeEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z279SedeTipo", GXutil.rtrim( Z279SedeTipo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z280SedeSector", GXutil.rtrim( Z280SedeSector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z28ClinicaId", GXutil.ltrim( localUtil.ntoc( Z28ClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z44UbigeoCode", GXutil.rtrim( Z44UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N28ClinicaId", GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N44UbigeoCode", GXutil.rtrim( A44UbigeoCode));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCLINICAID_DATA", AV23ClinicaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCLINICAID_DATA", AV23ClinicaId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vUBIGEOCODE_DATA", AV25UbigeoCode_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vUBIGEOCODE_DATA", AV25UbigeoCode_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODEPARTAMENTO", A186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEOPROVINCIA", A187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODISTRITO", A188UbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSEDEID", GXutil.ltrim( localUtil.ntoc( AV27SedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSEDEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27SedeId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CLINICAID", GXutil.ltrim( localUtil.ntoc( AV14Insert_ClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_UBIGEOCODE", GXutil.rtrim( AV12Insert_UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV28Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Objectcall", GXutil.rtrim( Combo_clinicaid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Cls", GXutil.rtrim( Combo_clinicaid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Selectedvalue_set", GXutil.rtrim( Combo_clinicaid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Selectedtext_set", GXutil.rtrim( Combo_clinicaid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Enabled", GXutil.booltostr( Combo_clinicaid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Datalistproc", GXutil.rtrim( Combo_clinicaid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_clinicaid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CLINICAID_Emptyitem", GXutil.booltostr( Combo_clinicaid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Objectcall", GXutil.rtrim( Combo_ubigeocode_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Cls", GXutil.rtrim( Combo_ubigeocode_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Selectedvalue_set", GXutil.rtrim( Combo_ubigeocode_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Selectedtext_set", GXutil.rtrim( Combo_ubigeocode_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Enabled", GXutil.booltostr( Combo_ubigeocode_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Datalistproc", GXutil.rtrim( Combo_ubigeocode_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Datalistprocparametersprefix", GXutil.rtrim( Combo_ubigeocode_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Emptyitem", GXutil.booltostr( Combo_ubigeocode_Emptyitem));
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
      return formatLink("com.projectthani.sede", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV27SedeId,4,0))}, new String[] {"Gx_mode","SedeId"})  ;
   }

   public String getPgmname( )
   {
      return "Sede" ;
   }

   public String getPgmdesc( )
   {
      return "Sede" ;
   }

   public void initializeNonKey0N44( )
   {
      A28ClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      A44UbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      A75SedeNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A75SedeNombre", A75SedeNombre);
      A118ClinicaRUC = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
      A116ClinicaNombreComercial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
      A185UbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      A276SedeDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A276SedeDireccion", A276SedeDireccion);
      A277SedeCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A277SedeCorreo", A277SedeCorreo);
      A278SedeEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A278SedeEstado", A278SedeEstado);
      A279SedeTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A279SedeTipo", A279SedeTipo);
      A280SedeSector = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A280SedeSector", A280SedeSector);
      A186UbigeoDepartamento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      A187UbigeoProvincia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      A188UbigeoDistrito = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      Z75SedeNombre = "" ;
      Z276SedeDireccion = "" ;
      Z277SedeCorreo = "" ;
      Z278SedeEstado = "" ;
      Z279SedeTipo = "" ;
      Z280SedeSector = "" ;
      Z28ClinicaId = (short)(0) ;
      Z44UbigeoCode = "" ;
   }

   public void initAll0N44( )
   {
      A30SedeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
      initializeNonKey0N44( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325110", true, true);
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
      httpContext.AddJavascriptSource("sede.js", "?20225110325111", false, true);
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
      edtSedeId_Internalname = "SEDEID" ;
      edtSedeNombre_Internalname = "SEDENOMBRE" ;
      lblTextblockclinicaid_Internalname = "TEXTBLOCKCLINICAID" ;
      Combo_clinicaid_Internalname = "COMBO_CLINICAID" ;
      edtClinicaId_Internalname = "CLINICAID" ;
      divTablesplittedclinicaid_Internalname = "TABLESPLITTEDCLINICAID" ;
      edtClinicaRUC_Internalname = "CLINICARUC" ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL" ;
      lblTextblockubigeocode_Internalname = "TEXTBLOCKUBIGEOCODE" ;
      Combo_ubigeocode_Internalname = "COMBO_UBIGEOCODE" ;
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      divTablesplittedubigeocode_Internalname = "TABLESPLITTEDUBIGEOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      edtSedeDireccion_Internalname = "SEDEDIRECCION" ;
      edtSedeCorreo_Internalname = "SEDECORREO" ;
      cmbSedeEstado.setInternalname( "SEDEESTADO" );
      cmbSedeTipo.setInternalname( "SEDETIPO" );
      cmbSedeSector.setInternalname( "SEDESECTOR" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboclinicaid_Internalname = "vCOMBOCLINICAID" ;
      divSectionattribute_clinicaid_Internalname = "SECTIONATTRIBUTE_CLINICAID" ;
      edtavComboubigeocode_Internalname = "vCOMBOUBIGEOCODE" ;
      divSectionattribute_ubigeocode_Internalname = "SECTIONATTRIBUTE_UBIGEOCODE" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_28_Internalname = "PROMPT_28" ;
      imgprompt_44_Internalname = "PROMPT_44" ;
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
      Form.setCaption( "Sede" );
      edtavComboubigeocode_Jsonclick = "" ;
      edtavComboubigeocode_Enabled = 0 ;
      edtavComboubigeocode_Visible = 1 ;
      edtavComboclinicaid_Jsonclick = "" ;
      edtavComboclinicaid_Enabled = 0 ;
      edtavComboclinicaid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbSedeSector.setJsonclick( "" );
      cmbSedeSector.setEnabled( 1 );
      cmbSedeTipo.setJsonclick( "" );
      cmbSedeTipo.setEnabled( 1 );
      cmbSedeEstado.setJsonclick( "" );
      cmbSedeEstado.setEnabled( 1 );
      edtSedeCorreo_Jsonclick = "" ;
      edtSedeCorreo_Enabled = 1 ;
      edtSedeDireccion_Jsonclick = "" ;
      edtSedeDireccion_Enabled = 1 ;
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoNombre_Enabled = 0 ;
      imgprompt_44_Visible = 1 ;
      imgprompt_44_Link = "" ;
      edtUbigeoCode_Jsonclick = "" ;
      edtUbigeoCode_Enabled = 1 ;
      edtUbigeoCode_Visible = 1 ;
      Combo_ubigeocode_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_ubigeocode_Datalistprocparametersprefix = " \"ComboName\": \"UbigeoCode\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"SedeId\": 0" ;
      Combo_ubigeocode_Datalistproc = "SedeLoadDVCombo" ;
      Combo_ubigeocode_Cls = "ExtendedCombo Attribute" ;
      Combo_ubigeocode_Caption = "" ;
      Combo_ubigeocode_Enabled = GXutil.toBoolean( -1) ;
      edtClinicaNombreComercial_Jsonclick = "" ;
      edtClinicaNombreComercial_Enabled = 0 ;
      edtClinicaRUC_Jsonclick = "" ;
      edtClinicaRUC_Enabled = 0 ;
      imgprompt_28_Visible = 1 ;
      imgprompt_28_Link = "" ;
      edtClinicaId_Jsonclick = "" ;
      edtClinicaId_Enabled = 1 ;
      edtClinicaId_Visible = 1 ;
      Combo_clinicaid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_clinicaid_Datalistprocparametersprefix = " \"ComboName\": \"ClinicaId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"SedeId\": 0" ;
      Combo_clinicaid_Datalistproc = "SedeLoadDVCombo" ;
      Combo_clinicaid_Cls = "ExtendedCombo Attribute" ;
      Combo_clinicaid_Caption = "" ;
      Combo_clinicaid_Enabled = GXutil.toBoolean( -1) ;
      edtSedeNombre_Jsonclick = "" ;
      edtSedeNombre_Enabled = 1 ;
      edtSedeId_Jsonclick = "" ;
      edtSedeId_Enabled = 0 ;
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
      cmbSedeEstado.setName( "SEDEESTADO" );
      cmbSedeEstado.setWebtags( "" );
      cmbSedeEstado.addItem("A", "Activo", (short)(0));
      cmbSedeEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbSedeEstado.getItemCount() > 0 )
      {
         A278SedeEstado = cmbSedeEstado.getValidValue(A278SedeEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A278SedeEstado", A278SedeEstado);
      }
      cmbSedeTipo.setName( "SEDETIPO" );
      cmbSedeTipo.setWebtags( "" );
      cmbSedeTipo.addItem("", "Seleccione", (short)(0));
      cmbSedeTipo.addItem("H", "Hospital", (short)(0));
      cmbSedeTipo.addItem("C", "Clínica", (short)(0));
      cmbSedeTipo.addItem("P", "Policlínico", (short)(0));
      cmbSedeTipo.addItem("I", "Independiente", (short)(0));
      if ( cmbSedeTipo.getItemCount() > 0 )
      {
         A279SedeTipo = cmbSedeTipo.getValidValue(A279SedeTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A279SedeTipo", A279SedeTipo);
      }
      cmbSedeSector.setName( "SEDESECTOR" );
      cmbSedeSector.setWebtags( "" );
      cmbSedeSector.addItem("", "Seleccione", (short)(0));
      cmbSedeSector.addItem("P", "Publico", (short)(0));
      cmbSedeSector.addItem("V", "Privado", (short)(0));
      if ( cmbSedeSector.getItemCount() > 0 )
      {
         A280SedeSector = cmbSedeSector.getValidValue(A280SedeSector) ;
         httpContext.ajax_rsp_assign_attri("", false, "A280SedeSector", A280SedeSector);
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

   public void valid_Clinicaid( )
   {
      /* Using cursor T000N15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaId_Internalname ;
      }
      A118ClinicaRUC = T000N15_A118ClinicaRUC[0] ;
      A116ClinicaNombreComercial = T000N15_A116ClinicaNombreComercial[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
   }

   public void valid_Ubigeocode( )
   {
      /* Using cursor T000N16 */
      pr_default.execute(14, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
      }
      A186UbigeoDepartamento = T000N16_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000N16_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000N16_A188UbigeoDistrito[0] ;
      pr_default.close(14);
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV27SedeId',fld:'vSEDEID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV27SedeId',fld:'vSEDEID',pic:'ZZZ9',hsh:true},{av:'A30SedeId',fld:'SEDEID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120N2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SEDEID","{handler:'valid_Sedeid',iparms:[]");
      setEventMetadata("VALID_SEDEID",",oparms:[]}");
      setEventMetadata("VALID_CLINICAID","{handler:'valid_Clinicaid',iparms:[{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'},{av:'A118ClinicaRUC',fld:'CLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'A116ClinicaNombreComercial',fld:'CLINICANOMBRECOMERCIAL',pic:''}]");
      setEventMetadata("VALID_CLINICAID",",oparms:[{av:'A118ClinicaRUC',fld:'CLINICARUC',pic:'ZZZZZZZZZZ9'},{av:'A116ClinicaNombreComercial',fld:'CLINICANOMBRECOMERCIAL',pic:''}]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:''},{av:'A186UbigeoDepartamento',fld:'UBIGEODEPARTAMENTO',pic:''},{av:'A187UbigeoProvincia',fld:'UBIGEOPROVINCIA',pic:''},{av:'A188UbigeoDistrito',fld:'UBIGEODISTRITO',pic:''},{av:'A185UbigeoNombre',fld:'UBIGEONOMBRE',pic:''}]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[{av:'A186UbigeoDepartamento',fld:'UBIGEODEPARTAMENTO',pic:''},{av:'A187UbigeoProvincia',fld:'UBIGEOPROVINCIA',pic:''},{av:'A188UbigeoDistrito',fld:'UBIGEODISTRITO',pic:''},{av:'A185UbigeoNombre',fld:'UBIGEONOMBRE',pic:''}]}");
      setEventMetadata("VALID_SEDECORREO","{handler:'valid_Sedecorreo',iparms:[]");
      setEventMetadata("VALID_SEDECORREO",",oparms:[]}");
      setEventMetadata("VALID_SEDEESTADO","{handler:'valid_Sedeestado',iparms:[]");
      setEventMetadata("VALID_SEDEESTADO",",oparms:[]}");
      setEventMetadata("VALID_SEDETIPO","{handler:'valid_Sedetipo',iparms:[]");
      setEventMetadata("VALID_SEDETIPO",",oparms:[]}");
      setEventMetadata("VALID_SEDESECTOR","{handler:'valid_Sedesector',iparms:[]");
      setEventMetadata("VALID_SEDESECTOR",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCLINICAID","{handler:'validv_Comboclinicaid',iparms:[]");
      setEventMetadata("VALIDV_COMBOCLINICAID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOUBIGEOCODE","{handler:'validv_Comboubigeocode',iparms:[]");
      setEventMetadata("VALIDV_COMBOUBIGEOCODE",",oparms:[]}");
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
      pr_default.close(13);
      pr_default.close(14);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z75SedeNombre = "" ;
      Z276SedeDireccion = "" ;
      Z277SedeCorreo = "" ;
      Z278SedeEstado = "" ;
      Z279SedeTipo = "" ;
      Z280SedeSector = "" ;
      Z44UbigeoCode = "" ;
      N44UbigeoCode = "" ;
      Combo_ubigeocode_Selectedvalue_get = "" ;
      Combo_clinicaid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A44UbigeoCode = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A278SedeEstado = "" ;
      A279SedeTipo = "" ;
      A280SedeSector = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A75SedeNombre = "" ;
      lblTextblockclinicaid_Jsonclick = "" ;
      ucCombo_clinicaid = new com.genexus.webpanels.GXUserControl();
      AV19DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV23ClinicaId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      sImgUrl = "" ;
      A116ClinicaNombreComercial = "" ;
      lblTextblockubigeocode_Jsonclick = "" ;
      ucCombo_ubigeocode = new com.genexus.webpanels.GXUserControl();
      AV25UbigeoCode_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A185UbigeoNombre = "" ;
      A276SedeDireccion = "" ;
      A277SedeCorreo = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV26ComboUbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      AV12Insert_UbigeoCode = "" ;
      AV28Pgmname = "" ;
      Combo_clinicaid_Objectcall = "" ;
      Combo_clinicaid_Class = "" ;
      Combo_clinicaid_Icontype = "" ;
      Combo_clinicaid_Icon = "" ;
      Combo_clinicaid_Tooltip = "" ;
      Combo_clinicaid_Selectedvalue_set = "" ;
      Combo_clinicaid_Selectedtext_set = "" ;
      Combo_clinicaid_Selectedtext_get = "" ;
      Combo_clinicaid_Gamoauthtoken = "" ;
      Combo_clinicaid_Ddointernalname = "" ;
      Combo_clinicaid_Titlecontrolalign = "" ;
      Combo_clinicaid_Dropdownoptionstype = "" ;
      Combo_clinicaid_Titlecontrolidtoreplace = "" ;
      Combo_clinicaid_Datalisttype = "" ;
      Combo_clinicaid_Datalistfixedvalues = "" ;
      Combo_clinicaid_Htmltemplate = "" ;
      Combo_clinicaid_Multiplevaluestype = "" ;
      Combo_clinicaid_Loadingdata = "" ;
      Combo_clinicaid_Noresultsfound = "" ;
      Combo_clinicaid_Emptyitemtext = "" ;
      Combo_clinicaid_Onlyselectedvalues = "" ;
      Combo_clinicaid_Selectalltext = "" ;
      Combo_clinicaid_Multiplevaluesseparator = "" ;
      Combo_clinicaid_Addnewoptiontext = "" ;
      Combo_ubigeocode_Objectcall = "" ;
      Combo_ubigeocode_Class = "" ;
      Combo_ubigeocode_Icontype = "" ;
      Combo_ubigeocode_Icon = "" ;
      Combo_ubigeocode_Tooltip = "" ;
      Combo_ubigeocode_Selectedvalue_set = "" ;
      Combo_ubigeocode_Selectedtext_set = "" ;
      Combo_ubigeocode_Selectedtext_get = "" ;
      Combo_ubigeocode_Gamoauthtoken = "" ;
      Combo_ubigeocode_Ddointernalname = "" ;
      Combo_ubigeocode_Titlecontrolalign = "" ;
      Combo_ubigeocode_Dropdownoptionstype = "" ;
      Combo_ubigeocode_Titlecontrolidtoreplace = "" ;
      Combo_ubigeocode_Datalisttype = "" ;
      Combo_ubigeocode_Datalistfixedvalues = "" ;
      Combo_ubigeocode_Htmltemplate = "" ;
      Combo_ubigeocode_Multiplevaluestype = "" ;
      Combo_ubigeocode_Loadingdata = "" ;
      Combo_ubigeocode_Noresultsfound = "" ;
      Combo_ubigeocode_Emptyitemtext = "" ;
      Combo_ubigeocode_Onlyselectedvalues = "" ;
      Combo_ubigeocode_Selectalltext = "" ;
      Combo_ubigeocode_Multiplevaluesseparator = "" ;
      Combo_ubigeocode_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode44 = "" ;
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
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV22Combo_DataJson = "" ;
      AV20ComboSelectedValue = "" ;
      AV21ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z116ClinicaNombreComercial = "" ;
      Z186UbigeoDepartamento = "" ;
      Z187UbigeoProvincia = "" ;
      Z188UbigeoDistrito = "" ;
      T000N4_A118ClinicaRUC = new long[1] ;
      T000N4_A116ClinicaNombreComercial = new String[] {""} ;
      T000N5_A186UbigeoDepartamento = new String[] {""} ;
      T000N5_A187UbigeoProvincia = new String[] {""} ;
      T000N5_A188UbigeoDistrito = new String[] {""} ;
      T000N6_A30SedeId = new short[1] ;
      T000N6_A75SedeNombre = new String[] {""} ;
      T000N6_A118ClinicaRUC = new long[1] ;
      T000N6_A116ClinicaNombreComercial = new String[] {""} ;
      T000N6_A276SedeDireccion = new String[] {""} ;
      T000N6_A277SedeCorreo = new String[] {""} ;
      T000N6_A278SedeEstado = new String[] {""} ;
      T000N6_A279SedeTipo = new String[] {""} ;
      T000N6_A280SedeSector = new String[] {""} ;
      T000N6_A186UbigeoDepartamento = new String[] {""} ;
      T000N6_A187UbigeoProvincia = new String[] {""} ;
      T000N6_A188UbigeoDistrito = new String[] {""} ;
      T000N6_A28ClinicaId = new short[1] ;
      T000N6_A44UbigeoCode = new String[] {""} ;
      T000N7_A118ClinicaRUC = new long[1] ;
      T000N7_A116ClinicaNombreComercial = new String[] {""} ;
      T000N8_A186UbigeoDepartamento = new String[] {""} ;
      T000N8_A187UbigeoProvincia = new String[] {""} ;
      T000N8_A188UbigeoDistrito = new String[] {""} ;
      T000N9_A30SedeId = new short[1] ;
      T000N3_A30SedeId = new short[1] ;
      T000N3_A75SedeNombre = new String[] {""} ;
      T000N3_A276SedeDireccion = new String[] {""} ;
      T000N3_A277SedeCorreo = new String[] {""} ;
      T000N3_A278SedeEstado = new String[] {""} ;
      T000N3_A279SedeTipo = new String[] {""} ;
      T000N3_A280SedeSector = new String[] {""} ;
      T000N3_A28ClinicaId = new short[1] ;
      T000N3_A44UbigeoCode = new String[] {""} ;
      T000N10_A30SedeId = new short[1] ;
      T000N11_A30SedeId = new short[1] ;
      T000N2_A30SedeId = new short[1] ;
      T000N2_A75SedeNombre = new String[] {""} ;
      T000N2_A276SedeDireccion = new String[] {""} ;
      T000N2_A277SedeCorreo = new String[] {""} ;
      T000N2_A278SedeEstado = new String[] {""} ;
      T000N2_A279SedeTipo = new String[] {""} ;
      T000N2_A280SedeSector = new String[] {""} ;
      T000N2_A28ClinicaId = new short[1] ;
      T000N2_A44UbigeoCode = new String[] {""} ;
      T000N12_A30SedeId = new short[1] ;
      T000N15_A118ClinicaRUC = new long[1] ;
      T000N15_A116ClinicaNombreComercial = new String[] {""} ;
      T000N16_A186UbigeoDepartamento = new String[] {""} ;
      T000N16_A187UbigeoProvincia = new String[] {""} ;
      T000N16_A188UbigeoDistrito = new String[] {""} ;
      T000N17_A32EspecialidadId = new short[1] ;
      T000N17_A38SGEspecialidadSedeId = new short[1] ;
      T000N18_A34DisponibilidadId = new int[1] ;
      T000N19_A29ConfComisionId = new short[1] ;
      T000N20_A31ProfesionalId = new int[1] ;
      T000N20_A32EspecialidadId = new short[1] ;
      T000N20_A30SedeId = new short[1] ;
      T000N20_A54SedeTipoConsulta = new String[] {""} ;
      T000N21_A30SedeId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Z185UbigeoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sede__default(),
         new Object[] {
             new Object[] {
            T000N2_A30SedeId, T000N2_A75SedeNombre, T000N2_A276SedeDireccion, T000N2_A277SedeCorreo, T000N2_A278SedeEstado, T000N2_A279SedeTipo, T000N2_A280SedeSector, T000N2_A28ClinicaId, T000N2_A44UbigeoCode
            }
            , new Object[] {
            T000N3_A30SedeId, T000N3_A75SedeNombre, T000N3_A276SedeDireccion, T000N3_A277SedeCorreo, T000N3_A278SedeEstado, T000N3_A279SedeTipo, T000N3_A280SedeSector, T000N3_A28ClinicaId, T000N3_A44UbigeoCode
            }
            , new Object[] {
            T000N4_A118ClinicaRUC, T000N4_A116ClinicaNombreComercial
            }
            , new Object[] {
            T000N5_A186UbigeoDepartamento, T000N5_A187UbigeoProvincia, T000N5_A188UbigeoDistrito
            }
            , new Object[] {
            T000N6_A30SedeId, T000N6_A75SedeNombre, T000N6_A118ClinicaRUC, T000N6_A116ClinicaNombreComercial, T000N6_A276SedeDireccion, T000N6_A277SedeCorreo, T000N6_A278SedeEstado, T000N6_A279SedeTipo, T000N6_A280SedeSector, T000N6_A186UbigeoDepartamento,
            T000N6_A187UbigeoProvincia, T000N6_A188UbigeoDistrito, T000N6_A28ClinicaId, T000N6_A44UbigeoCode
            }
            , new Object[] {
            T000N7_A118ClinicaRUC, T000N7_A116ClinicaNombreComercial
            }
            , new Object[] {
            T000N8_A186UbigeoDepartamento, T000N8_A187UbigeoProvincia, T000N8_A188UbigeoDistrito
            }
            , new Object[] {
            T000N9_A30SedeId
            }
            , new Object[] {
            T000N10_A30SedeId
            }
            , new Object[] {
            T000N11_A30SedeId
            }
            , new Object[] {
            T000N12_A30SedeId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000N15_A118ClinicaRUC, T000N15_A116ClinicaNombreComercial
            }
            , new Object[] {
            T000N16_A186UbigeoDepartamento, T000N16_A187UbigeoProvincia, T000N16_A188UbigeoDistrito
            }
            , new Object[] {
            T000N17_A32EspecialidadId, T000N17_A38SGEspecialidadSedeId
            }
            , new Object[] {
            T000N18_A34DisponibilidadId
            }
            , new Object[] {
            T000N19_A29ConfComisionId
            }
            , new Object[] {
            T000N20_A31ProfesionalId, T000N20_A32EspecialidadId, T000N20_A30SedeId, T000N20_A54SedeTipoConsulta
            }
            , new Object[] {
            T000N21_A30SedeId
            }
         }
      );
      AV28Pgmname = "Sede" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV27SedeId ;
   private short Z30SedeId ;
   private short Z28ClinicaId ;
   private short N28ClinicaId ;
   private short A28ClinicaId ;
   private short AV27SedeId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A30SedeId ;
   private short AV24ComboClinicaId ;
   private short AV14Insert_ClinicaId ;
   private short RcdFound44 ;
   private short nIsDirty_44 ;
   private int trnEnded ;
   private int edtSedeId_Enabled ;
   private int edtSedeNombre_Enabled ;
   private int edtClinicaId_Visible ;
   private int edtClinicaId_Enabled ;
   private int imgprompt_28_Visible ;
   private int edtClinicaRUC_Enabled ;
   private int edtClinicaNombreComercial_Enabled ;
   private int edtUbigeoCode_Visible ;
   private int edtUbigeoCode_Enabled ;
   private int imgprompt_44_Visible ;
   private int edtUbigeoNombre_Enabled ;
   private int edtSedeDireccion_Enabled ;
   private int edtSedeCorreo_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboclinicaid_Enabled ;
   private int edtavComboclinicaid_Visible ;
   private int edtavComboubigeocode_Visible ;
   private int edtavComboubigeocode_Enabled ;
   private int Combo_clinicaid_Datalistupdateminimumcharacters ;
   private int Combo_ubigeocode_Datalistupdateminimumcharacters ;
   private int AV29GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long A118ClinicaRUC ;
   private long Z118ClinicaRUC ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z278SedeEstado ;
   private String Z279SedeTipo ;
   private String Z280SedeSector ;
   private String Z44UbigeoCode ;
   private String N44UbigeoCode ;
   private String Combo_ubigeocode_Selectedvalue_get ;
   private String Combo_clinicaid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A44UbigeoCode ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSedeNombre_Internalname ;
   private String A278SedeEstado ;
   private String A279SedeTipo ;
   private String A280SedeSector ;
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
   private String edtSedeId_Internalname ;
   private String edtSedeId_Jsonclick ;
   private String TempTags ;
   private String edtSedeNombre_Jsonclick ;
   private String divTablesplittedclinicaid_Internalname ;
   private String lblTextblockclinicaid_Internalname ;
   private String lblTextblockclinicaid_Jsonclick ;
   private String Combo_clinicaid_Caption ;
   private String Combo_clinicaid_Cls ;
   private String Combo_clinicaid_Datalistproc ;
   private String Combo_clinicaid_Datalistprocparametersprefix ;
   private String Combo_clinicaid_Internalname ;
   private String edtClinicaId_Internalname ;
   private String edtClinicaId_Jsonclick ;
   private String sImgUrl ;
   private String imgprompt_28_Internalname ;
   private String imgprompt_28_Link ;
   private String edtClinicaRUC_Internalname ;
   private String edtClinicaRUC_Jsonclick ;
   private String edtClinicaNombreComercial_Internalname ;
   private String edtClinicaNombreComercial_Jsonclick ;
   private String divTablesplittedubigeocode_Internalname ;
   private String lblTextblockubigeocode_Internalname ;
   private String lblTextblockubigeocode_Jsonclick ;
   private String Combo_ubigeocode_Caption ;
   private String Combo_ubigeocode_Cls ;
   private String Combo_ubigeocode_Datalistproc ;
   private String Combo_ubigeocode_Datalistprocparametersprefix ;
   private String Combo_ubigeocode_Internalname ;
   private String edtUbigeoCode_Internalname ;
   private String edtUbigeoCode_Jsonclick ;
   private String imgprompt_44_Internalname ;
   private String imgprompt_44_Link ;
   private String edtUbigeoNombre_Internalname ;
   private String edtUbigeoNombre_Jsonclick ;
   private String edtSedeDireccion_Internalname ;
   private String edtSedeDireccion_Jsonclick ;
   private String edtSedeCorreo_Internalname ;
   private String edtSedeCorreo_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_clinicaid_Internalname ;
   private String edtavComboclinicaid_Internalname ;
   private String edtavComboclinicaid_Jsonclick ;
   private String divSectionattribute_ubigeocode_Internalname ;
   private String edtavComboubigeocode_Internalname ;
   private String AV26ComboUbigeoCode ;
   private String edtavComboubigeocode_Jsonclick ;
   private String AV12Insert_UbigeoCode ;
   private String AV28Pgmname ;
   private String Combo_clinicaid_Objectcall ;
   private String Combo_clinicaid_Class ;
   private String Combo_clinicaid_Icontype ;
   private String Combo_clinicaid_Icon ;
   private String Combo_clinicaid_Tooltip ;
   private String Combo_clinicaid_Selectedvalue_set ;
   private String Combo_clinicaid_Selectedtext_set ;
   private String Combo_clinicaid_Selectedtext_get ;
   private String Combo_clinicaid_Gamoauthtoken ;
   private String Combo_clinicaid_Ddointernalname ;
   private String Combo_clinicaid_Titlecontrolalign ;
   private String Combo_clinicaid_Dropdownoptionstype ;
   private String Combo_clinicaid_Titlecontrolidtoreplace ;
   private String Combo_clinicaid_Datalisttype ;
   private String Combo_clinicaid_Datalistfixedvalues ;
   private String Combo_clinicaid_Htmltemplate ;
   private String Combo_clinicaid_Multiplevaluestype ;
   private String Combo_clinicaid_Loadingdata ;
   private String Combo_clinicaid_Noresultsfound ;
   private String Combo_clinicaid_Emptyitemtext ;
   private String Combo_clinicaid_Onlyselectedvalues ;
   private String Combo_clinicaid_Selectalltext ;
   private String Combo_clinicaid_Multiplevaluesseparator ;
   private String Combo_clinicaid_Addnewoptiontext ;
   private String Combo_ubigeocode_Objectcall ;
   private String Combo_ubigeocode_Class ;
   private String Combo_ubigeocode_Icontype ;
   private String Combo_ubigeocode_Icon ;
   private String Combo_ubigeocode_Tooltip ;
   private String Combo_ubigeocode_Selectedvalue_set ;
   private String Combo_ubigeocode_Selectedtext_set ;
   private String Combo_ubigeocode_Selectedtext_get ;
   private String Combo_ubigeocode_Gamoauthtoken ;
   private String Combo_ubigeocode_Ddointernalname ;
   private String Combo_ubigeocode_Titlecontrolalign ;
   private String Combo_ubigeocode_Dropdownoptionstype ;
   private String Combo_ubigeocode_Titlecontrolidtoreplace ;
   private String Combo_ubigeocode_Datalisttype ;
   private String Combo_ubigeocode_Datalistfixedvalues ;
   private String Combo_ubigeocode_Htmltemplate ;
   private String Combo_ubigeocode_Multiplevaluestype ;
   private String Combo_ubigeocode_Loadingdata ;
   private String Combo_ubigeocode_Noresultsfound ;
   private String Combo_ubigeocode_Emptyitemtext ;
   private String Combo_ubigeocode_Onlyselectedvalues ;
   private String Combo_ubigeocode_Selectalltext ;
   private String Combo_ubigeocode_Multiplevaluesseparator ;
   private String Combo_ubigeocode_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode44 ;
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
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_clinicaid_Emptyitem ;
   private boolean Combo_ubigeocode_Emptyitem ;
   private boolean Combo_clinicaid_Enabled ;
   private boolean Combo_clinicaid_Visible ;
   private boolean Combo_clinicaid_Allowmultipleselection ;
   private boolean Combo_clinicaid_Isgriditem ;
   private boolean Combo_clinicaid_Hasdescription ;
   private boolean Combo_clinicaid_Includeonlyselectedoption ;
   private boolean Combo_clinicaid_Includeselectalloption ;
   private boolean Combo_clinicaid_Includeaddnewoption ;
   private boolean Combo_ubigeocode_Enabled ;
   private boolean Combo_ubigeocode_Visible ;
   private boolean Combo_ubigeocode_Allowmultipleselection ;
   private boolean Combo_ubigeocode_Isgriditem ;
   private boolean Combo_ubigeocode_Hasdescription ;
   private boolean Combo_ubigeocode_Includeonlyselectedoption ;
   private boolean Combo_ubigeocode_Includeselectalloption ;
   private boolean Combo_ubigeocode_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV22Combo_DataJson ;
   private String Z75SedeNombre ;
   private String Z276SedeDireccion ;
   private String Z277SedeCorreo ;
   private String A75SedeNombre ;
   private String A116ClinicaNombreComercial ;
   private String A185UbigeoNombre ;
   private String A276SedeDireccion ;
   private String A277SedeCorreo ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String AV20ComboSelectedValue ;
   private String AV21ComboSelectedText ;
   private String Z116ClinicaNombreComercial ;
   private String Z186UbigeoDepartamento ;
   private String Z187UbigeoProvincia ;
   private String Z188UbigeoDistrito ;
   private String Z185UbigeoNombre ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_clinicaid ;
   private com.genexus.webpanels.GXUserControl ucCombo_ubigeocode ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbSedeEstado ;
   private HTMLChoice cmbSedeTipo ;
   private HTMLChoice cmbSedeSector ;
   private IDataStoreProvider pr_default ;
   private long[] T000N4_A118ClinicaRUC ;
   private String[] T000N4_A116ClinicaNombreComercial ;
   private String[] T000N5_A186UbigeoDepartamento ;
   private String[] T000N5_A187UbigeoProvincia ;
   private String[] T000N5_A188UbigeoDistrito ;
   private short[] T000N6_A30SedeId ;
   private String[] T000N6_A75SedeNombre ;
   private long[] T000N6_A118ClinicaRUC ;
   private String[] T000N6_A116ClinicaNombreComercial ;
   private String[] T000N6_A276SedeDireccion ;
   private String[] T000N6_A277SedeCorreo ;
   private String[] T000N6_A278SedeEstado ;
   private String[] T000N6_A279SedeTipo ;
   private String[] T000N6_A280SedeSector ;
   private String[] T000N6_A186UbigeoDepartamento ;
   private String[] T000N6_A187UbigeoProvincia ;
   private String[] T000N6_A188UbigeoDistrito ;
   private short[] T000N6_A28ClinicaId ;
   private String[] T000N6_A44UbigeoCode ;
   private long[] T000N7_A118ClinicaRUC ;
   private String[] T000N7_A116ClinicaNombreComercial ;
   private String[] T000N8_A186UbigeoDepartamento ;
   private String[] T000N8_A187UbigeoProvincia ;
   private String[] T000N8_A188UbigeoDistrito ;
   private short[] T000N9_A30SedeId ;
   private short[] T000N3_A30SedeId ;
   private String[] T000N3_A75SedeNombre ;
   private String[] T000N3_A276SedeDireccion ;
   private String[] T000N3_A277SedeCorreo ;
   private String[] T000N3_A278SedeEstado ;
   private String[] T000N3_A279SedeTipo ;
   private String[] T000N3_A280SedeSector ;
   private short[] T000N3_A28ClinicaId ;
   private String[] T000N3_A44UbigeoCode ;
   private short[] T000N10_A30SedeId ;
   private short[] T000N11_A30SedeId ;
   private short[] T000N2_A30SedeId ;
   private String[] T000N2_A75SedeNombre ;
   private String[] T000N2_A276SedeDireccion ;
   private String[] T000N2_A277SedeCorreo ;
   private String[] T000N2_A278SedeEstado ;
   private String[] T000N2_A279SedeTipo ;
   private String[] T000N2_A280SedeSector ;
   private short[] T000N2_A28ClinicaId ;
   private String[] T000N2_A44UbigeoCode ;
   private short[] T000N12_A30SedeId ;
   private long[] T000N15_A118ClinicaRUC ;
   private String[] T000N15_A116ClinicaNombreComercial ;
   private String[] T000N16_A186UbigeoDepartamento ;
   private String[] T000N16_A187UbigeoProvincia ;
   private String[] T000N16_A188UbigeoDistrito ;
   private short[] T000N17_A32EspecialidadId ;
   private short[] T000N17_A38SGEspecialidadSedeId ;
   private int[] T000N18_A34DisponibilidadId ;
   private short[] T000N19_A29ConfComisionId ;
   private int[] T000N20_A31ProfesionalId ;
   private short[] T000N20_A32EspecialidadId ;
   private short[] T000N20_A30SedeId ;
   private String[] T000N20_A54SedeTipoConsulta ;
   private short[] T000N21_A30SedeId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV23ClinicaId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV25UbigeoCode_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class sede__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000N2", "SELECT [SedeId], [SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode] FROM [Sede] WITH (UPDLOCK) WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N3", "SELECT [SedeId], [SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N4", "SELECT [ClinicaRUC], [ClinicaNombreComercial] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N5", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N6", "SELECT TM1.[SedeId], TM1.[SedeNombre], T2.[ClinicaRUC], T2.[ClinicaNombreComercial], TM1.[SedeDireccion], TM1.[SedeCorreo], TM1.[SedeEstado], TM1.[SedeTipo], TM1.[SedeSector], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[ClinicaId], TM1.[UbigeoCode] FROM (([Sede] TM1 INNER JOIN [Clinica] T2 ON T2.[ClinicaId] = TM1.[ClinicaId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[SedeId] = ? ORDER BY TM1.[SedeId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N7", "SELECT [ClinicaRUC], [ClinicaNombreComercial] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N8", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N9", "SELECT [SedeId] FROM [Sede] WHERE [SedeId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N10", "SELECT TOP 1 [SedeId] FROM [Sede] WHERE ( [SedeId] > ?) ORDER BY [SedeId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000N11", "SELECT TOP 1 [SedeId] FROM [Sede] WHERE ( [SedeId] < ?) ORDER BY [SedeId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000N12", "INSERT INTO [Sede]([SedeNombre], [SedeDireccion], [SedeCorreo], [SedeEstado], [SedeTipo], [SedeSector], [ClinicaId], [UbigeoCode]) VALUES(?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000N13", "UPDATE [Sede] SET [SedeNombre]=?, [SedeDireccion]=?, [SedeCorreo]=?, [SedeEstado]=?, [SedeTipo]=?, [SedeSector]=?, [ClinicaId]=?, [UbigeoCode]=?  WHERE [SedeId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000N14", "DELETE FROM [Sede]  WHERE [SedeId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000N15", "SELECT [ClinicaRUC], [ClinicaNombreComercial] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N16", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000N17", "SELECT TOP 1 [EspecialidadId], [SGEspecialidadSedeId] FROM [EspecialidadSede] WHERE [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000N18", "SELECT TOP 1 [DisponibilidadId] FROM [Disponibilidad] WHERE [SGSedeDisponibilidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000N19", "SELECT TOP 1 [ConfComisionId] FROM [ConfComision] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000N20", "SELECT TOP 1 [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000N21", "SELECT [SedeId] FROM [Sede] ORDER BY [SedeId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 10);
               return;
            case 2 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((String[]) buf[13])[0] = rslt.getString(14, 10);
               return;
            case 5 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 19 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 10);
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
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 10);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 10);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

