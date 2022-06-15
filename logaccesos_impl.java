package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class logaccesos_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"LOGACCESOSFULLNAME") == 0 )
      {
         A14SecUserName = httpContext.GetPar( "SecUserName") ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
         A4SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asalogaccesosfullname0Q35( A14SecUserName, A4SecRoleId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_15") == 0 )
      {
         A6SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_15( A6SecUserId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A6SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         A4SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A6SecUserId, A4SecRoleId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A4SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A4SecRoleId) ;
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
            AV7LogAccesosId = (short)(GXutil.lval( httpContext.GetPar( "LogAccesosId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7LogAccesosId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLOGACCESOSID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LogAccesosId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Log Accesos", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public logaccesos_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public logaccesos_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( logaccesos_impl.class ));
   }

   public logaccesos_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbLogAccesosTipo = new HTMLChoice();
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
      if ( cmbLogAccesosTipo.getItemCount() > 0 )
      {
         A227LogAccesosTipo = cmbLogAccesosTipo.getValidValue(A227LogAccesosTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A227LogAccesosTipo", A227LogAccesosTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLogAccesosTipo.setValue( GXutil.rtrim( A227LogAccesosTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLogAccesosTipo.getInternalname(), "Values", cmbLogAccesosTipo.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLogAccesosId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLogAccesosId_Internalname, "Log Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLogAccesosId_Internalname, GXutil.ltrim( localUtil.ntoc( A41LogAccesosId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtLogAccesosId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLogAccesosId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLogAccesosId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedsecuserid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksecuserid_Internalname, "User Id", "", "", lblTextblocksecuserid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_secuserid.setProperty("Caption", Combo_secuserid_Caption);
      ucCombo_secuserid.setProperty("Cls", Combo_secuserid_Cls);
      ucCombo_secuserid.setProperty("DataListProc", Combo_secuserid_Datalistproc);
      ucCombo_secuserid.setProperty("DataListProcParametersPrefix", Combo_secuserid_Datalistprocparametersprefix);
      ucCombo_secuserid.setProperty("EmptyItem", Combo_secuserid_Emptyitem);
      ucCombo_secuserid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_secuserid.setProperty("DropDownOptionsData", AV16SecUserId_Data);
      ucCombo_secuserid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_secuserid_Internalname, "COMBO_SECUSERIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserId_Internalname, "User Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserId_Internalname, GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserId_Jsonclick, 0, "Attribute", "", "", "", "", edtSecUserId_Visible, edtSecUserId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LogAccesos.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserName_Internalname, "User Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserName_Internalname, A14SecUserName, GXutil.rtrim( localUtil.format( A14SecUserName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedsecroleid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksecroleid_Internalname, "Role Id", "", "", lblTextblocksecroleid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_secroleid.setProperty("Caption", Combo_secroleid_Caption);
      ucCombo_secroleid.setProperty("Cls", Combo_secroleid_Cls);
      ucCombo_secroleid.setProperty("DataListProc", Combo_secroleid_Datalistproc);
      ucCombo_secroleid.setProperty("EmptyItem", Combo_secroleid_Emptyitem);
      ucCombo_secroleid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_secroleid.setProperty("DropDownOptionsData", AV22SecRoleId_Data);
      ucCombo_secroleid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_secroleid_Internalname, "COMBO_SECROLEIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecRoleId_Internalname, "Role Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecRoleId_Internalname, GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A4SecRoleId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecRoleId_Jsonclick, 0, "Attribute", "", "", "", "", edtSecRoleId_Visible, edtSecRoleId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LogAccesos.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecRoleDescription_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecRoleDescription_Internalname, "Role Description", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecRoleDescription_Internalname, A12SecRoleDescription, GXutil.rtrim( localUtil.format( A12SecRoleDescription, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecRoleDescription_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecRoleDescription_Enabled, 0, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLogAccesosFullName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLogAccesosFullName_Internalname, "Nombres Completos", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLogAccesosFullName_Internalname, A172LogAccesosFullName, GXutil.rtrim( localUtil.format( A172LogAccesosFullName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLogAccesosFullName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLogAccesosFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLogAccesosTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbLogAccesosTipo.getInternalname(), "Tipo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLogAccesosTipo, cmbLogAccesosTipo.getInternalname(), GXutil.rtrim( A227LogAccesosTipo), 1, cmbLogAccesosTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbLogAccesosTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "", true, (byte)(1), "HLP_LogAccesos.htm");
      cmbLogAccesosTipo.setValue( GXutil.rtrim( A227LogAccesosTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLogAccesosTipo.getInternalname(), "Values", cmbLogAccesosTipo.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLogAccesosFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLogAccesosFecha_Internalname, "Fecha", "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtLogAccesosFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLogAccesosFecha_Internalname, localUtil.ttoc( A228LogAccesosFecha, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A228LogAccesosFecha, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onblur(this,69);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLogAccesosFecha_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtLogAccesosFecha_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtLogAccesosFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtLogAccesosFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_LogAccesos.htm");
      httpContext.writeTextNL( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_LogAccesos.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_secuserid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombosecuserid_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboSecUserId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombosecuserid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboSecUserId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboSecUserId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosecuserid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosecuserid_Visible, edtavCombosecuserid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LogAccesos.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_secroleid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombosecroleid_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboSecRoleId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombosecroleid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboSecRoleId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboSecRoleId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosecroleid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosecroleid_Visible, edtavCombosecroleid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_LogAccesos.htm");
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
      e110Q2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECUSERID_DATA"), AV16SecUserId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECROLEID_DATA"), AV22SecRoleId_Data);
            /* Read saved values. */
            Z41LogAccesosId = (short)(localUtil.ctol( httpContext.cgiGet( "Z41LogAccesosId"), ",", ".")) ;
            Z227LogAccesosTipo = httpContext.cgiGet( "Z227LogAccesosTipo") ;
            Z228LogAccesosFecha = localUtil.ctot( httpContext.cgiGet( "Z228LogAccesosFecha"), 0) ;
            Z6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "Z6SecUserId"), ",", ".")) ;
            Z4SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( "Z4SecRoleId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "N6SecUserId"), ",", ".")) ;
            N4SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( "N4SecRoleId"), ",", ".")) ;
            AV24Cond_SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "vCOND_SECUSERID"), ",", ".")) ;
            AV7LogAccesosId = (short)(localUtil.ctol( httpContext.cgiGet( "vLOGACCESOSID"), ",", ".")) ;
            AV13Insert_SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SECUSERID"), ",", ".")) ;
            AV15Insert_SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SECROLEID"), ",", ".")) ;
            AV25Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_secuserid_Objectcall = httpContext.cgiGet( "COMBO_SECUSERID_Objectcall") ;
            Combo_secuserid_Class = httpContext.cgiGet( "COMBO_SECUSERID_Class") ;
            Combo_secuserid_Icontype = httpContext.cgiGet( "COMBO_SECUSERID_Icontype") ;
            Combo_secuserid_Icon = httpContext.cgiGet( "COMBO_SECUSERID_Icon") ;
            Combo_secuserid_Caption = httpContext.cgiGet( "COMBO_SECUSERID_Caption") ;
            Combo_secuserid_Tooltip = httpContext.cgiGet( "COMBO_SECUSERID_Tooltip") ;
            Combo_secuserid_Cls = httpContext.cgiGet( "COMBO_SECUSERID_Cls") ;
            Combo_secuserid_Selectedvalue_set = httpContext.cgiGet( "COMBO_SECUSERID_Selectedvalue_set") ;
            Combo_secuserid_Selectedvalue_get = httpContext.cgiGet( "COMBO_SECUSERID_Selectedvalue_get") ;
            Combo_secuserid_Selectedtext_set = httpContext.cgiGet( "COMBO_SECUSERID_Selectedtext_set") ;
            Combo_secuserid_Selectedtext_get = httpContext.cgiGet( "COMBO_SECUSERID_Selectedtext_get") ;
            Combo_secuserid_Gamoauthtoken = httpContext.cgiGet( "COMBO_SECUSERID_Gamoauthtoken") ;
            Combo_secuserid_Ddointernalname = httpContext.cgiGet( "COMBO_SECUSERID_Ddointernalname") ;
            Combo_secuserid_Titlecontrolalign = httpContext.cgiGet( "COMBO_SECUSERID_Titlecontrolalign") ;
            Combo_secuserid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SECUSERID_Dropdownoptionstype") ;
            Combo_secuserid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Enabled")) ;
            Combo_secuserid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Visible")) ;
            Combo_secuserid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SECUSERID_Titlecontrolidtoreplace") ;
            Combo_secuserid_Datalisttype = httpContext.cgiGet( "COMBO_SECUSERID_Datalisttype") ;
            Combo_secuserid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Allowmultipleselection")) ;
            Combo_secuserid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SECUSERID_Datalistfixedvalues") ;
            Combo_secuserid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Isgriditem")) ;
            Combo_secuserid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Hasdescription")) ;
            Combo_secuserid_Datalistproc = httpContext.cgiGet( "COMBO_SECUSERID_Datalistproc") ;
            Combo_secuserid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SECUSERID_Datalistprocparametersprefix") ;
            Combo_secuserid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SECUSERID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_secuserid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Includeonlyselectedoption")) ;
            Combo_secuserid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Includeselectalloption")) ;
            Combo_secuserid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Emptyitem")) ;
            Combo_secuserid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Includeaddnewoption")) ;
            Combo_secuserid_Htmltemplate = httpContext.cgiGet( "COMBO_SECUSERID_Htmltemplate") ;
            Combo_secuserid_Multiplevaluestype = httpContext.cgiGet( "COMBO_SECUSERID_Multiplevaluestype") ;
            Combo_secuserid_Loadingdata = httpContext.cgiGet( "COMBO_SECUSERID_Loadingdata") ;
            Combo_secuserid_Noresultsfound = httpContext.cgiGet( "COMBO_SECUSERID_Noresultsfound") ;
            Combo_secuserid_Emptyitemtext = httpContext.cgiGet( "COMBO_SECUSERID_Emptyitemtext") ;
            Combo_secuserid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SECUSERID_Onlyselectedvalues") ;
            Combo_secuserid_Selectalltext = httpContext.cgiGet( "COMBO_SECUSERID_Selectalltext") ;
            Combo_secuserid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SECUSERID_Multiplevaluesseparator") ;
            Combo_secuserid_Addnewoptiontext = httpContext.cgiGet( "COMBO_SECUSERID_Addnewoptiontext") ;
            Combo_secroleid_Objectcall = httpContext.cgiGet( "COMBO_SECROLEID_Objectcall") ;
            Combo_secroleid_Class = httpContext.cgiGet( "COMBO_SECROLEID_Class") ;
            Combo_secroleid_Icontype = httpContext.cgiGet( "COMBO_SECROLEID_Icontype") ;
            Combo_secroleid_Icon = httpContext.cgiGet( "COMBO_SECROLEID_Icon") ;
            Combo_secroleid_Caption = httpContext.cgiGet( "COMBO_SECROLEID_Caption") ;
            Combo_secroleid_Tooltip = httpContext.cgiGet( "COMBO_SECROLEID_Tooltip") ;
            Combo_secroleid_Cls = httpContext.cgiGet( "COMBO_SECROLEID_Cls") ;
            Combo_secroleid_Selectedvalue_set = httpContext.cgiGet( "COMBO_SECROLEID_Selectedvalue_set") ;
            Combo_secroleid_Selectedvalue_get = httpContext.cgiGet( "COMBO_SECROLEID_Selectedvalue_get") ;
            Combo_secroleid_Selectedtext_set = httpContext.cgiGet( "COMBO_SECROLEID_Selectedtext_set") ;
            Combo_secroleid_Selectedtext_get = httpContext.cgiGet( "COMBO_SECROLEID_Selectedtext_get") ;
            Combo_secroleid_Gamoauthtoken = httpContext.cgiGet( "COMBO_SECROLEID_Gamoauthtoken") ;
            Combo_secroleid_Ddointernalname = httpContext.cgiGet( "COMBO_SECROLEID_Ddointernalname") ;
            Combo_secroleid_Titlecontrolalign = httpContext.cgiGet( "COMBO_SECROLEID_Titlecontrolalign") ;
            Combo_secroleid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SECROLEID_Dropdownoptionstype") ;
            Combo_secroleid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Enabled")) ;
            Combo_secroleid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Visible")) ;
            Combo_secroleid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SECROLEID_Titlecontrolidtoreplace") ;
            Combo_secroleid_Datalisttype = httpContext.cgiGet( "COMBO_SECROLEID_Datalisttype") ;
            Combo_secroleid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Allowmultipleselection")) ;
            Combo_secroleid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SECROLEID_Datalistfixedvalues") ;
            Combo_secroleid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Isgriditem")) ;
            Combo_secroleid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Hasdescription")) ;
            Combo_secroleid_Datalistproc = httpContext.cgiGet( "COMBO_SECROLEID_Datalistproc") ;
            Combo_secroleid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SECROLEID_Datalistprocparametersprefix") ;
            Combo_secroleid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SECROLEID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_secroleid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Includeonlyselectedoption")) ;
            Combo_secroleid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Includeselectalloption")) ;
            Combo_secroleid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Emptyitem")) ;
            Combo_secroleid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECROLEID_Includeaddnewoption")) ;
            Combo_secroleid_Htmltemplate = httpContext.cgiGet( "COMBO_SECROLEID_Htmltemplate") ;
            Combo_secroleid_Multiplevaluestype = httpContext.cgiGet( "COMBO_SECROLEID_Multiplevaluestype") ;
            Combo_secroleid_Loadingdata = httpContext.cgiGet( "COMBO_SECROLEID_Loadingdata") ;
            Combo_secroleid_Noresultsfound = httpContext.cgiGet( "COMBO_SECROLEID_Noresultsfound") ;
            Combo_secroleid_Emptyitemtext = httpContext.cgiGet( "COMBO_SECROLEID_Emptyitemtext") ;
            Combo_secroleid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SECROLEID_Onlyselectedvalues") ;
            Combo_secroleid_Selectalltext = httpContext.cgiGet( "COMBO_SECROLEID_Selectalltext") ;
            Combo_secroleid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SECROLEID_Multiplevaluesseparator") ;
            Combo_secroleid_Addnewoptiontext = httpContext.cgiGet( "COMBO_SECROLEID_Addnewoptiontext") ;
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
            A41LogAccesosId = (short)(localUtil.ctol( httpContext.cgiGet( edtLogAccesosId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECUSERID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A6SecUserId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            }
            else
            {
               A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            }
            A14SecUserName = httpContext.cgiGet( edtSecUserName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecRoleId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecRoleId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECROLEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecRoleId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A4SecRoleId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
            }
            else
            {
               A4SecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecRoleId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
            }
            A12SecRoleDescription = httpContext.cgiGet( edtSecRoleDescription_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
            A172LogAccesosFullName = httpContext.cgiGet( edtLogAccesosFullName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
            cmbLogAccesosTipo.setValue( httpContext.cgiGet( cmbLogAccesosTipo.getInternalname()) );
            A227LogAccesosTipo = httpContext.cgiGet( cmbLogAccesosTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A227LogAccesosTipo", A227LogAccesosTipo);
            if ( localUtil.vcdtime( httpContext.cgiGet( edtLogAccesosFecha_Internalname), (byte)(3), (byte)(0)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "LOGACCESOSFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLogAccesosFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
               httpContext.ajax_rsp_assign_attri("", false, "A228LogAccesosFecha", localUtil.ttoc( A228LogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
            }
            else
            {
               A228LogAccesosFecha = localUtil.ctot( httpContext.cgiGet( edtLogAccesosFecha_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A228LogAccesosFecha", localUtil.ttoc( A228LogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
            }
            AV21ComboSecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombosecuserid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboSecUserId), 4, 0));
            AV23ComboSecRoleId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombosecroleid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecRoleId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"LogAccesos");
            A41LogAccesosId = (short)(localUtil.ctol( httpContext.cgiGet( edtLogAccesosId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
            forbiddenHiddens.add("LogAccesosId", localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A41LogAccesosId != Z41LogAccesosId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("logaccesos:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A41LogAccesosId = (short)(GXutil.lval( httpContext.GetPar( "LogAccesosId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
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
                  sMode35 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode35 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound35 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0Q0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "LOGACCESOSID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLogAccesosId_Internalname ;
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
                        e110Q2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120Q2 ();
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
         e120Q2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0Q35( ) ;
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
         disableAttributes0Q35( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecuserid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecuserid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecroleid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecroleid_Enabled), 5, 0), true);
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

   public void confirm_0Q0( )
   {
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Q35( ) ;
         }
         else
         {
            checkExtendedTable0Q35( ) ;
            closeExtendedTableCursors0Q35( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0Q0( )
   {
   }

   public void e110Q2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtSecRoleId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecRoleId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleId_Visible), 5, 0), true);
      AV23ComboSecRoleId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecRoleId), 4, 0));
      edtavCombosecroleid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecroleid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecroleid_Visible), 5, 0), true);
      edtSecUserId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Visible), 5, 0), true);
      AV21ComboSecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboSecUserId), 4, 0));
      edtavCombosecuserid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecuserid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecuserid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOSECUSERID' */
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
      /* Execute user subroutine: 'LOADCOMBOSECROLEID' */
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
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Insert", GXv_boolean5) ;
         logaccesos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Update", GXv_boolean5) ;
         logaccesos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV9IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLogAccesos_Delete", GXv_boolean5) ;
         logaccesos_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV9IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV11TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV25Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV26GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         while ( AV26GXV1 <= AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV11TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV26GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecUserId") == 0 )
            {
               AV13Insert_SecUserId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_SecUserId), 4, 0));
               if ( ! (0==AV13Insert_SecUserId) )
               {
                  AV21ComboSecUserId = AV13Insert_SecUserId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboSecUserId), 4, 0));
                  Combo_secuserid_Selectedvalue_set = GXutil.trim( GXutil.str( AV21ComboSecUserId, 4, 0)) ;
                  ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedValue_set", Combo_secuserid_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char7[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.logaccesosloaddvcombo(remoteHandle, context).execute( "SecUserId", "GET", false, AV7LogAccesosId, A6SecUserId, AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  logaccesos_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
                  logaccesos_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  logaccesos_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_secuserid_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedText_set", Combo_secuserid_Selectedtext_set);
                  Combo_secuserid_Enabled = false ;
                  ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "Enabled", GXutil.booltostr( Combo_secuserid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecRoleId") == 0 )
            {
               AV15Insert_SecRoleId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15Insert_SecRoleId), 4, 0));
               if ( ! (0==AV15Insert_SecRoleId) )
               {
                  AV23ComboSecRoleId = AV15Insert_SecRoleId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecRoleId), 4, 0));
                  Combo_secroleid_Selectedvalue_set = GXutil.trim( GXutil.str( AV23ComboSecRoleId, 4, 0)) ;
                  ucCombo_secroleid.sendProperty(context, "", false, Combo_secroleid_Internalname, "SelectedValue_set", Combo_secroleid_Selectedvalue_set);
                  Combo_secroleid_Enabled = false ;
                  ucCombo_secroleid.sendProperty(context, "", false, Combo_secroleid_Internalname, "Enabled", GXutil.booltostr( Combo_secroleid_Enabled));
               }
            }
            AV26GXV1 = (int)(AV26GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         }
      }
   }

   public void e120Q2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.logaccesosww", new String[] {}, new String[] {}) );
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
      /* 'LOADCOMBOSECROLEID' Routine */
      returnInSub = false ;
      Combo_secroleid_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"SecRoleId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"LogAccesosId\": 0, \"Cond_SecUserId\": \"#%1#\"", edtSecUserId_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_secroleid.sendProperty(context, "", false, Combo_secroleid_Internalname, "DataListProcParametersPrefix", Combo_secroleid_Datalistprocparametersprefix);
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.logaccesosloaddvcombo(remoteHandle, context).execute( "SecRoleId", Gx_mode, false, AV7LogAccesosId, A6SecUserId, "", GXv_char9, GXv_char8, GXv_char7) ;
      logaccesos_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      logaccesos_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      logaccesos_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_secroleid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_secroleid.sendProperty(context, "", false, Combo_secroleid_Internalname, "SelectedValue_set", Combo_secroleid_Selectedvalue_set);
      Combo_secroleid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_secroleid.sendProperty(context, "", false, Combo_secroleid_Internalname, "SelectedText_set", Combo_secroleid_Selectedtext_set);
      AV23ComboSecRoleId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecRoleId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_secroleid_Enabled = false ;
         ucCombo_secroleid.sendProperty(context, "", false, Combo_secroleid_Internalname, "Enabled", GXutil.booltostr( Combo_secroleid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOSECUSERID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.logaccesosloaddvcombo(remoteHandle, context).execute( "SecUserId", Gx_mode, false, AV7LogAccesosId, A6SecUserId, "", GXv_char9, GXv_char8, GXv_char7) ;
      logaccesos_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      logaccesos_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      logaccesos_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_secuserid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedValue_set", Combo_secuserid_Selectedvalue_set);
      Combo_secuserid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedText_set", Combo_secuserid_Selectedtext_set);
      AV21ComboSecUserId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboSecUserId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_secuserid_Enabled = false ;
         ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "Enabled", GXutil.booltostr( Combo_secuserid_Enabled));
      }
   }

   public void zm0Q35( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z227LogAccesosTipo = T000Q3_A227LogAccesosTipo[0] ;
            Z228LogAccesosFecha = T000Q3_A228LogAccesosFecha[0] ;
            Z6SecUserId = T000Q3_A6SecUserId[0] ;
            Z4SecRoleId = T000Q3_A4SecRoleId[0] ;
         }
         else
         {
            Z227LogAccesosTipo = A227LogAccesosTipo ;
            Z228LogAccesosFecha = A228LogAccesosFecha ;
            Z6SecUserId = A6SecUserId ;
            Z4SecRoleId = A4SecRoleId ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z41LogAccesosId = A41LogAccesosId ;
         Z227LogAccesosTipo = A227LogAccesosTipo ;
         Z228LogAccesosFecha = A228LogAccesosFecha ;
         Z6SecUserId = A6SecUserId ;
         Z4SecRoleId = A4SecRoleId ;
         Z14SecUserName = A14SecUserName ;
         Z12SecRoleDescription = A12SecRoleDescription ;
      }
   }

   public void standaloneNotModal( )
   {
      edtLogAccesosId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosId_Enabled), 5, 0), true);
      edtLogAccesosId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7LogAccesosId) )
      {
         A41LogAccesosId = AV7LogAccesosId ;
         httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_SecUserId) )
      {
         edtSecUserId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      }
      else
      {
         edtSecUserId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_SecRoleId) )
      {
         edtSecRoleId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecRoleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleId_Enabled), 5, 0), true);
      }
      else
      {
         edtSecRoleId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecRoleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_SecUserId) )
      {
         A6SecUserId = AV13Insert_SecUserId ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      }
      else
      {
         A6SecUserId = AV21ComboSecUserId ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV15Insert_SecRoleId) )
      {
         A4SecRoleId = AV15Insert_SecRoleId ;
         httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
      }
      else
      {
         A4SecRoleId = AV23ComboSecRoleId ;
         httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
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
         AV25Pgmname = "LogAccesos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T000Q4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A6SecUserId)});
         A14SecUserName = T000Q4_A14SecUserName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
         pr_default.close(2);
         /* Using cursor T000Q5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A4SecRoleId)});
         A12SecRoleDescription = T000Q5_A12SecRoleDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
         pr_default.close(3);
         GXt_char6 = A172LogAccesosFullName ;
         GXv_char9[0] = GXt_char6 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char9) ;
         logaccesos_impl.this.GXt_char6 = GXv_char9[0] ;
         A172LogAccesosFullName = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
      }
   }

   public void load0Q35( )
   {
      /* Using cursor T000Q7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A14SecUserName = T000Q7_A14SecUserName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
         A12SecRoleDescription = T000Q7_A12SecRoleDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
         A227LogAccesosTipo = T000Q7_A227LogAccesosTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A227LogAccesosTipo", A227LogAccesosTipo);
         A228LogAccesosFecha = T000Q7_A228LogAccesosFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A228LogAccesosFecha", localUtil.ttoc( A228LogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
         A6SecUserId = T000Q7_A6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         A4SecRoleId = T000Q7_A4SecRoleId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
         zm0Q35( -14) ;
      }
      pr_default.close(5);
      onLoadActions0Q35( ) ;
   }

   public void onLoadActions0Q35( )
   {
      AV25Pgmname = "LogAccesos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      GXt_char6 = A172LogAccesosFullName ;
      GXv_char9[0] = GXt_char6 ;
      new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char9) ;
      logaccesos_impl.this.GXt_char6 = GXv_char9[0] ;
      A172LogAccesosFullName = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
   }

   public void checkExtendedTable0Q35( )
   {
      nIsDirty_35 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV25Pgmname = "LogAccesos" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      /* Using cursor T000Q4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A14SecUserName = T000Q4_A14SecUserName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
      pr_default.close(2);
      nIsDirty_35 = (short)(1) ;
      GXt_char6 = A172LogAccesosFullName ;
      GXv_char9[0] = GXt_char6 ;
      new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char9) ;
      logaccesos_impl.this.GXt_char6 = GXv_char9[0] ;
      A172LogAccesosFullName = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
      /* Using cursor T000Q6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sec User Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T000Q5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecRoleId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A12SecRoleDescription = T000Q5_A12SecRoleDescription[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A227LogAccesosTipo, "I") == 0 ) || ( GXutil.strcmp(A227LogAccesosTipo, "S") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Tipo fuera de rango", "OutOfRange", 1, "LOGACCESOSTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLogAccesosTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A228LogAccesosFecha) || (( A228LogAccesosFecha.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A228LogAccesosFecha, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha fuera de rango", "OutOfRange", 1, "LOGACCESOSFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLogAccesosFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0Q35( )
   {
      pr_default.close(2);
      pr_default.close(4);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_15( short A6SecUserId )
   {
      /* Using cursor T000Q8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A14SecUserName = T000Q8_A14SecUserName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A14SecUserName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_17( short A6SecUserId ,
                          short A4SecRoleId )
   {
      /* Using cursor T000Q9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sec User Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_16( short A4SecRoleId )
   {
      /* Using cursor T000Q10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecRoleId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A12SecRoleDescription = T000Q10_A12SecRoleDescription[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A12SecRoleDescription)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey0Q35( )
   {
      /* Using cursor T000Q11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound35 = (short)(1) ;
      }
      else
      {
         RcdFound35 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Q3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Q35( 14) ;
         RcdFound35 = (short)(1) ;
         A41LogAccesosId = T000Q3_A41LogAccesosId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
         A227LogAccesosTipo = T000Q3_A227LogAccesosTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A227LogAccesosTipo", A227LogAccesosTipo);
         A228LogAccesosFecha = T000Q3_A228LogAccesosFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A228LogAccesosFecha", localUtil.ttoc( A228LogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
         A6SecUserId = T000Q3_A6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         A4SecRoleId = T000Q3_A4SecRoleId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
         Z41LogAccesosId = A41LogAccesosId ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0Q35( ) ;
         if ( AnyError == 1 )
         {
            RcdFound35 = (short)(0) ;
            initializeNonKey0Q35( ) ;
         }
         Gx_mode = sMode35 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound35 = (short)(0) ;
         initializeNonKey0Q35( ) ;
         sMode35 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode35 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Q35( ) ;
      if ( RcdFound35 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound35 = (short)(0) ;
      /* Using cursor T000Q12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000Q12_A41LogAccesosId[0] < A41LogAccesosId ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000Q12_A41LogAccesosId[0] > A41LogAccesosId ) ) )
         {
            A41LogAccesosId = T000Q12_A41LogAccesosId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
            RcdFound35 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound35 = (short)(0) ;
      /* Using cursor T000Q13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A41LogAccesosId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000Q13_A41LogAccesosId[0] > A41LogAccesosId ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000Q13_A41LogAccesosId[0] < A41LogAccesosId ) ) )
         {
            A41LogAccesosId = T000Q13_A41LogAccesosId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
            RcdFound35 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Q35( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Q35( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound35 == 1 )
         {
            if ( A41LogAccesosId != Z41LogAccesosId )
            {
               A41LogAccesosId = Z41LogAccesosId ;
               httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "LOGACCESOSID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLogAccesosId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0Q35( ) ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A41LogAccesosId != Z41LogAccesosId )
            {
               /* Insert record */
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Q35( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "LOGACCESOSID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtLogAccesosId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSecUserId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Q35( ) ;
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
      if ( A41LogAccesosId != Z41LogAccesosId )
      {
         A41LogAccesosId = Z41LogAccesosId ;
         httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "LOGACCESOSID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLogAccesosId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0Q35( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Q2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A41LogAccesosId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LogAccesos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z227LogAccesosTipo, T000Q2_A227LogAccesosTipo[0]) != 0 ) || !( GXutil.dateCompare(Z228LogAccesosFecha, T000Q2_A228LogAccesosFecha[0]) ) || ( Z6SecUserId != T000Q2_A6SecUserId[0] ) || ( Z4SecRoleId != T000Q2_A4SecRoleId[0] ) )
         {
            if ( GXutil.strcmp(Z227LogAccesosTipo, T000Q2_A227LogAccesosTipo[0]) != 0 )
            {
               GXutil.writeLogln("logaccesos:[seudo value changed for attri]"+"LogAccesosTipo");
               GXutil.writeLogRaw("Old: ",Z227LogAccesosTipo);
               GXutil.writeLogRaw("Current: ",T000Q2_A227LogAccesosTipo[0]);
            }
            if ( !( GXutil.dateCompare(Z228LogAccesosFecha, T000Q2_A228LogAccesosFecha[0]) ) )
            {
               GXutil.writeLogln("logaccesos:[seudo value changed for attri]"+"LogAccesosFecha");
               GXutil.writeLogRaw("Old: ",Z228LogAccesosFecha);
               GXutil.writeLogRaw("Current: ",T000Q2_A228LogAccesosFecha[0]);
            }
            if ( Z6SecUserId != T000Q2_A6SecUserId[0] )
            {
               GXutil.writeLogln("logaccesos:[seudo value changed for attri]"+"SecUserId");
               GXutil.writeLogRaw("Old: ",Z6SecUserId);
               GXutil.writeLogRaw("Current: ",T000Q2_A6SecUserId[0]);
            }
            if ( Z4SecRoleId != T000Q2_A4SecRoleId[0] )
            {
               GXutil.writeLogln("logaccesos:[seudo value changed for attri]"+"SecRoleId");
               GXutil.writeLogRaw("Old: ",Z4SecRoleId);
               GXutil.writeLogRaw("Current: ",T000Q2_A4SecRoleId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LogAccesos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Q35( )
   {
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q35( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Q35( 0) ;
         checkOptimisticConcurrency0Q35( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q35( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Q35( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Q14 */
                  pr_default.execute(12, new Object[] {A227LogAccesosTipo, A228LogAccesosFecha, Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
                  A41LogAccesosId = T000Q14_A41LogAccesosId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LogAccesos");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0Q0( ) ;
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
            load0Q35( ) ;
         }
         endLevel0Q35( ) ;
      }
      closeExtendedTableCursors0Q35( ) ;
   }

   public void update0Q35( )
   {
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Q35( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q35( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Q35( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Q35( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Q15 */
                  pr_default.execute(13, new Object[] {A227LogAccesosTipo, A228LogAccesosFecha, Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId), Short.valueOf(A41LogAccesosId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LogAccesos");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LogAccesos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Q35( ) ;
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
         endLevel0Q35( ) ;
      }
      closeExtendedTableCursors0Q35( ) ;
   }

   public void deferredUpdate0Q35( )
   {
   }

   public void delete( )
   {
      beforeValidate0Q35( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Q35( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Q35( ) ;
         afterConfirm0Q35( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Q35( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Q16 */
               pr_default.execute(14, new Object[] {Short.valueOf(A41LogAccesosId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LogAccesos");
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
      sMode35 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Q35( ) ;
      Gx_mode = sMode35 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Q35( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV25Pgmname = "LogAccesos" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T000Q17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A6SecUserId)});
         A14SecUserName = T000Q17_A14SecUserName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
         pr_default.close(15);
         /* Using cursor T000Q18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A4SecRoleId)});
         A12SecRoleDescription = T000Q18_A12SecRoleDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
         pr_default.close(16);
         GXt_char6 = A172LogAccesosFullName ;
         GXv_char9[0] = GXt_char6 ;
         new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char9) ;
         logaccesos_impl.this.GXt_char6 = GXv_char9[0] ;
         A172LogAccesosFullName = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
      }
   }

   public void endLevel0Q35( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Q35( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(15);
         pr_default.close(16);
         Application.commitDataStores(context, remoteHandle, pr_default, "logaccesos");
         if ( AnyError == 0 )
         {
            confirmValues0Q0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(15);
         pr_default.close(16);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "logaccesos");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Q35( )
   {
      /* Scan By routine */
      /* Using cursor T000Q19 */
      pr_default.execute(17);
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A41LogAccesosId = T000Q19_A41LogAccesosId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Q35( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound35 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound35 = (short)(1) ;
         A41LogAccesosId = T000Q19_A41LogAccesosId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
      }
   }

   public void scanEnd0Q35( )
   {
      pr_default.close(17);
   }

   public void afterConfirm0Q35( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Q35( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Q35( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Q35( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Q35( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Q35( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Q35( )
   {
      edtLogAccesosId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosId_Enabled), 5, 0), true);
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      edtSecUserName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Enabled), 5, 0), true);
      edtSecRoleId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecRoleId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleId_Enabled), 5, 0), true);
      edtSecRoleDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecRoleDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecRoleDescription_Enabled), 5, 0), true);
      edtLogAccesosFullName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosFullName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosFullName_Enabled), 5, 0), true);
      cmbLogAccesosTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLogAccesosTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLogAccesosTipo.getEnabled(), 5, 0), true);
      edtLogAccesosFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLogAccesosFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLogAccesosFecha_Enabled), 5, 0), true);
      edtavCombosecuserid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecuserid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecuserid_Enabled), 5, 0), true);
      edtavCombosecroleid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecroleid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecroleid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Q35( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Q0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511032553", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.logaccesos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7LogAccesosId,4,0))}, new String[] {"Gx_mode","LogAccesosId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"LogAccesos");
      forbiddenHiddens.add("LogAccesosId", localUtil.format( DecimalUtil.doubleToDec(A41LogAccesosId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("logaccesos:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z41LogAccesosId", GXutil.ltrim( localUtil.ntoc( Z41LogAccesosId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z227LogAccesosTipo", GXutil.rtrim( Z227LogAccesosTipo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z228LogAccesosFecha", localUtil.ttoc( Z228LogAccesosFecha, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z6SecUserId", GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z4SecRoleId", GXutil.ltrim( localUtil.ntoc( Z4SecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N6SecUserId", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N4SecRoleId", GXutil.ltrim( localUtil.ntoc( A4SecRoleId, (byte)(4), (byte)(0), ",", "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSERID_DATA", AV16SecUserId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSERID_DATA", AV16SecUserId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECROLEID_DATA", AV22SecRoleId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECROLEID_DATA", AV22SecRoleId_Data);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV11TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV11TrnContext);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV11TrnContext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCOND_SECUSERID", GXutil.ltrim( localUtil.ntoc( AV24Cond_SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vLOGACCESOSID", GXutil.ltrim( localUtil.ntoc( AV7LogAccesosId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLOGACCESOSID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7LogAccesosId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SECUSERID", GXutil.ltrim( localUtil.ntoc( AV13Insert_SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SECROLEID", GXutil.ltrim( localUtil.ntoc( AV15Insert_SecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV25Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Objectcall", GXutil.rtrim( Combo_secuserid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Cls", GXutil.rtrim( Combo_secuserid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Selectedvalue_set", GXutil.rtrim( Combo_secuserid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Selectedtext_set", GXutil.rtrim( Combo_secuserid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Enabled", GXutil.booltostr( Combo_secuserid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Datalistproc", GXutil.rtrim( Combo_secuserid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Datalistprocparametersprefix", GXutil.rtrim( Combo_secuserid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Emptyitem", GXutil.booltostr( Combo_secuserid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Objectcall", GXutil.rtrim( Combo_secroleid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Cls", GXutil.rtrim( Combo_secroleid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Selectedvalue_set", GXutil.rtrim( Combo_secroleid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Selectedtext_set", GXutil.rtrim( Combo_secroleid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Enabled", GXutil.booltostr( Combo_secroleid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Datalistproc", GXutil.rtrim( Combo_secroleid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Datalistprocparametersprefix", GXutil.rtrim( Combo_secroleid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECROLEID_Emptyitem", GXutil.booltostr( Combo_secroleid_Emptyitem));
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
      return formatLink("com.projectthani.logaccesos", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7LogAccesosId,4,0))}, new String[] {"Gx_mode","LogAccesosId"})  ;
   }

   public String getPgmname( )
   {
      return "LogAccesos" ;
   }

   public String getPgmdesc( )
   {
      return "Log Accesos" ;
   }

   public void initializeNonKey0Q35( )
   {
      A6SecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      A4SecRoleId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A4SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A4SecRoleId), 4, 0));
      A172LogAccesosFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
      A14SecUserName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
      A12SecRoleDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
      A227LogAccesosTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A227LogAccesosTipo", A227LogAccesosTipo);
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      httpContext.ajax_rsp_assign_attri("", false, "A228LogAccesosFecha", localUtil.ttoc( A228LogAccesosFecha, 8, 5, 0, 3, "/", ":", " "));
      Z227LogAccesosTipo = "" ;
      Z228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      Z6SecUserId = (short)(0) ;
      Z4SecRoleId = (short)(0) ;
   }

   public void initAll0Q35( )
   {
      A41LogAccesosId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A41LogAccesosId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A41LogAccesosId), 4, 0));
      initializeNonKey0Q35( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325529", true, true);
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
      httpContext.AddJavascriptSource("logaccesos.js", "?20225110325529", false, true);
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
      edtLogAccesosId_Internalname = "LOGACCESOSID" ;
      lblTextblocksecuserid_Internalname = "TEXTBLOCKSECUSERID" ;
      Combo_secuserid_Internalname = "COMBO_SECUSERID" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      divTablesplittedsecuserid_Internalname = "TABLESPLITTEDSECUSERID" ;
      edtSecUserName_Internalname = "SECUSERNAME" ;
      lblTextblocksecroleid_Internalname = "TEXTBLOCKSECROLEID" ;
      Combo_secroleid_Internalname = "COMBO_SECROLEID" ;
      edtSecRoleId_Internalname = "SECROLEID" ;
      divTablesplittedsecroleid_Internalname = "TABLESPLITTEDSECROLEID" ;
      edtSecRoleDescription_Internalname = "SECROLEDESCRIPTION" ;
      edtLogAccesosFullName_Internalname = "LOGACCESOSFULLNAME" ;
      cmbLogAccesosTipo.setInternalname( "LOGACCESOSTIPO" );
      edtLogAccesosFecha_Internalname = "LOGACCESOSFECHA" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombosecuserid_Internalname = "vCOMBOSECUSERID" ;
      divSectionattribute_secuserid_Internalname = "SECTIONATTRIBUTE_SECUSERID" ;
      edtavCombosecroleid_Internalname = "vCOMBOSECROLEID" ;
      divSectionattribute_secroleid_Internalname = "SECTIONATTRIBUTE_SECROLEID" ;
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
      Form.setCaption( "Log Accesos" );
      Combo_secroleid_Datalistprocparametersprefix = "" ;
      edtavCombosecroleid_Jsonclick = "" ;
      edtavCombosecroleid_Enabled = 0 ;
      edtavCombosecroleid_Visible = 1 ;
      edtavCombosecuserid_Jsonclick = "" ;
      edtavCombosecuserid_Enabled = 0 ;
      edtavCombosecuserid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtLogAccesosFecha_Jsonclick = "" ;
      edtLogAccesosFecha_Enabled = 1 ;
      cmbLogAccesosTipo.setJsonclick( "" );
      cmbLogAccesosTipo.setEnabled( 1 );
      edtLogAccesosFullName_Jsonclick = "" ;
      edtLogAccesosFullName_Enabled = 0 ;
      edtSecRoleDescription_Jsonclick = "" ;
      edtSecRoleDescription_Enabled = 0 ;
      edtSecRoleId_Jsonclick = "" ;
      edtSecRoleId_Enabled = 1 ;
      edtSecRoleId_Visible = 1 ;
      Combo_secroleid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_secroleid_Datalistproc = "LogAccesosLoadDVCombo" ;
      Combo_secroleid_Cls = "ExtendedCombo Attribute" ;
      Combo_secroleid_Caption = "" ;
      Combo_secroleid_Enabled = GXutil.toBoolean( -1) ;
      edtSecUserName_Jsonclick = "" ;
      edtSecUserName_Enabled = 0 ;
      edtSecUserId_Jsonclick = "" ;
      edtSecUserId_Enabled = 1 ;
      edtSecUserId_Visible = 1 ;
      Combo_secuserid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_secuserid_Datalistprocparametersprefix = " \"ComboName\": \"SecUserId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"LogAccesosId\": 0" ;
      Combo_secuserid_Datalistproc = "LogAccesosLoadDVCombo" ;
      Combo_secuserid_Cls = "ExtendedCombo Attribute" ;
      Combo_secuserid_Caption = "" ;
      Combo_secuserid_Enabled = GXutil.toBoolean( -1) ;
      edtLogAccesosId_Jsonclick = "" ;
      edtLogAccesosId_Enabled = 0 ;
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

   public void gx5asalogaccesosfullname0Q35( String A14SecUserName ,
                                             short A4SecRoleId )
   {
      GXt_char6 = A172LogAccesosFullName ;
      GXv_char9[0] = GXt_char6 ;
      new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char9) ;
      logaccesos_impl.this.GXt_char6 = GXv_char9[0] ;
      A172LogAccesosFullName = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A172LogAccesosFullName)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      cmbLogAccesosTipo.setName( "LOGACCESOSTIPO" );
      cmbLogAccesosTipo.setWebtags( "" );
      cmbLogAccesosTipo.addItem("I", "Ingreso", (short)(0));
      cmbLogAccesosTipo.addItem("S", "Salida", (short)(0));
      if ( cmbLogAccesosTipo.getItemCount() > 0 )
      {
         A227LogAccesosTipo = cmbLogAccesosTipo.getValidValue(A227LogAccesosTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A227LogAccesosTipo", A227LogAccesosTipo);
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

   public void valid_Secuserid( )
   {
      /* Using cursor T000Q17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
      }
      A14SecUserName = T000Q17_A14SecUserName[0] ;
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
   }

   public void valid_Secroleid( )
   {
      /* Using cursor T000Q18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecRoleId_Internalname ;
      }
      A12SecRoleDescription = T000Q18_A12SecRoleDescription[0] ;
      pr_default.close(16);
      /* Using cursor T000Q20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A6SecUserId), Short.valueOf(A4SecRoleId)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sec User Role'.", "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
      }
      pr_default.close(18);
      GXt_char6 = A172LogAccesosFullName ;
      GXv_char9[0] = GXt_char6 ;
      new com.projectthani.prcgetnombreuser(remoteHandle, context).execute( A14SecUserName, A4SecRoleId, GXv_char9) ;
      logaccesos_impl.this.GXt_char6 = GXv_char9[0] ;
      A172LogAccesosFullName = GXt_char6 ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A12SecRoleDescription", A12SecRoleDescription);
      httpContext.ajax_rsp_assign_attri("", false, "A172LogAccesosFullName", A172LogAccesosFullName);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7LogAccesosId',fld:'vLOGACCESOSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7LogAccesosId',fld:'vLOGACCESOSID',pic:'ZZZ9',hsh:true},{av:'A41LogAccesosId',fld:'LOGACCESOSID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120Q2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_LOGACCESOSID","{handler:'valid_Logaccesosid',iparms:[]");
      setEventMetadata("VALID_LOGACCESOSID",",oparms:[]}");
      setEventMetadata("VALID_SECUSERID","{handler:'valid_Secuserid',iparms:[{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'A14SecUserName',fld:'SECUSERNAME',pic:''}]");
      setEventMetadata("VALID_SECUSERID",",oparms:[{av:'A14SecUserName',fld:'SECUSERNAME',pic:''}]}");
      setEventMetadata("VALID_SECUSERNAME","{handler:'valid_Secusername',iparms:[]");
      setEventMetadata("VALID_SECUSERNAME",",oparms:[]}");
      setEventMetadata("VALID_SECROLEID","{handler:'valid_Secroleid',iparms:[{av:'A4SecRoleId',fld:'SECROLEID',pic:'ZZZ9'},{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'A14SecUserName',fld:'SECUSERNAME',pic:''},{av:'A12SecRoleDescription',fld:'SECROLEDESCRIPTION',pic:''},{av:'A172LogAccesosFullName',fld:'LOGACCESOSFULLNAME',pic:''}]");
      setEventMetadata("VALID_SECROLEID",",oparms:[{av:'A12SecRoleDescription',fld:'SECROLEDESCRIPTION',pic:''},{av:'A172LogAccesosFullName',fld:'LOGACCESOSFULLNAME',pic:''}]}");
      setEventMetadata("VALID_LOGACCESOSTIPO","{handler:'valid_Logaccesostipo',iparms:[]");
      setEventMetadata("VALID_LOGACCESOSTIPO",",oparms:[]}");
      setEventMetadata("VALID_LOGACCESOSFECHA","{handler:'valid_Logaccesosfecha',iparms:[]");
      setEventMetadata("VALID_LOGACCESOSFECHA",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOSECUSERID","{handler:'validv_Combosecuserid',iparms:[]");
      setEventMetadata("VALIDV_COMBOSECUSERID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOSECROLEID","{handler:'validv_Combosecroleid',iparms:[]");
      setEventMetadata("VALIDV_COMBOSECROLEID",",oparms:[]}");
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
      pr_default.close(15);
      pr_default.close(18);
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z227LogAccesosTipo = "" ;
      Z228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      Combo_secroleid_Selectedvalue_get = "" ;
      Combo_secuserid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A14SecUserName = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A227LogAccesosTipo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblocksecuserid_Jsonclick = "" ;
      ucCombo_secuserid = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16SecUserId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      lblTextblocksecroleid_Jsonclick = "" ;
      ucCombo_secroleid = new com.genexus.webpanels.GXUserControl();
      AV22SecRoleId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A12SecRoleDescription = "" ;
      A172LogAccesosFullName = "" ;
      A228LogAccesosFecha = GXutil.resetTime( GXutil.nullDate() );
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV25Pgmname = "" ;
      Combo_secuserid_Objectcall = "" ;
      Combo_secuserid_Class = "" ;
      Combo_secuserid_Icontype = "" ;
      Combo_secuserid_Icon = "" ;
      Combo_secuserid_Tooltip = "" ;
      Combo_secuserid_Selectedvalue_set = "" ;
      Combo_secuserid_Selectedtext_set = "" ;
      Combo_secuserid_Selectedtext_get = "" ;
      Combo_secuserid_Gamoauthtoken = "" ;
      Combo_secuserid_Ddointernalname = "" ;
      Combo_secuserid_Titlecontrolalign = "" ;
      Combo_secuserid_Dropdownoptionstype = "" ;
      Combo_secuserid_Titlecontrolidtoreplace = "" ;
      Combo_secuserid_Datalisttype = "" ;
      Combo_secuserid_Datalistfixedvalues = "" ;
      Combo_secuserid_Htmltemplate = "" ;
      Combo_secuserid_Multiplevaluestype = "" ;
      Combo_secuserid_Loadingdata = "" ;
      Combo_secuserid_Noresultsfound = "" ;
      Combo_secuserid_Emptyitemtext = "" ;
      Combo_secuserid_Onlyselectedvalues = "" ;
      Combo_secuserid_Selectalltext = "" ;
      Combo_secuserid_Multiplevaluesseparator = "" ;
      Combo_secuserid_Addnewoptiontext = "" ;
      Combo_secroleid_Objectcall = "" ;
      Combo_secroleid_Class = "" ;
      Combo_secroleid_Icontype = "" ;
      Combo_secroleid_Icon = "" ;
      Combo_secroleid_Tooltip = "" ;
      Combo_secroleid_Selectedvalue_set = "" ;
      Combo_secroleid_Selectedtext_set = "" ;
      Combo_secroleid_Selectedtext_get = "" ;
      Combo_secroleid_Gamoauthtoken = "" ;
      Combo_secroleid_Ddointernalname = "" ;
      Combo_secroleid_Titlecontrolalign = "" ;
      Combo_secroleid_Dropdownoptionstype = "" ;
      Combo_secroleid_Titlecontrolidtoreplace = "" ;
      Combo_secroleid_Datalisttype = "" ;
      Combo_secroleid_Datalistfixedvalues = "" ;
      Combo_secroleid_Htmltemplate = "" ;
      Combo_secroleid_Multiplevaluestype = "" ;
      Combo_secroleid_Loadingdata = "" ;
      Combo_secroleid_Noresultsfound = "" ;
      Combo_secroleid_Emptyitemtext = "" ;
      Combo_secroleid_Onlyselectedvalues = "" ;
      Combo_secroleid_Selectalltext = "" ;
      Combo_secroleid_Multiplevaluesseparator = "" ;
      Combo_secroleid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode35 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV11TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV20Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      AV19ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z14SecUserName = "" ;
      Z12SecRoleDescription = "" ;
      T000Q4_A14SecUserName = new String[] {""} ;
      T000Q5_A12SecRoleDescription = new String[] {""} ;
      T000Q7_A41LogAccesosId = new short[1] ;
      T000Q7_A14SecUserName = new String[] {""} ;
      T000Q7_A12SecRoleDescription = new String[] {""} ;
      T000Q7_A227LogAccesosTipo = new String[] {""} ;
      T000Q7_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q7_A6SecUserId = new short[1] ;
      T000Q7_A4SecRoleId = new short[1] ;
      T000Q6_A6SecUserId = new short[1] ;
      T000Q8_A14SecUserName = new String[] {""} ;
      T000Q9_A6SecUserId = new short[1] ;
      T000Q10_A12SecRoleDescription = new String[] {""} ;
      T000Q11_A41LogAccesosId = new short[1] ;
      T000Q3_A41LogAccesosId = new short[1] ;
      T000Q3_A227LogAccesosTipo = new String[] {""} ;
      T000Q3_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q3_A6SecUserId = new short[1] ;
      T000Q3_A4SecRoleId = new short[1] ;
      T000Q12_A41LogAccesosId = new short[1] ;
      T000Q13_A41LogAccesosId = new short[1] ;
      T000Q2_A41LogAccesosId = new short[1] ;
      T000Q2_A227LogAccesosTipo = new String[] {""} ;
      T000Q2_A228LogAccesosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000Q2_A6SecUserId = new short[1] ;
      T000Q2_A4SecRoleId = new short[1] ;
      T000Q14_A41LogAccesosId = new short[1] ;
      T000Q17_A14SecUserName = new String[] {""} ;
      T000Q18_A12SecRoleDescription = new String[] {""} ;
      T000Q19_A41LogAccesosId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000Q20_A6SecUserId = new short[1] ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      Z172LogAccesosFullName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.logaccesos__default(),
         new Object[] {
             new Object[] {
            T000Q2_A41LogAccesosId, T000Q2_A227LogAccesosTipo, T000Q2_A228LogAccesosFecha, T000Q2_A6SecUserId, T000Q2_A4SecRoleId
            }
            , new Object[] {
            T000Q3_A41LogAccesosId, T000Q3_A227LogAccesosTipo, T000Q3_A228LogAccesosFecha, T000Q3_A6SecUserId, T000Q3_A4SecRoleId
            }
            , new Object[] {
            T000Q4_A14SecUserName
            }
            , new Object[] {
            T000Q5_A12SecRoleDescription
            }
            , new Object[] {
            T000Q6_A6SecUserId
            }
            , new Object[] {
            T000Q7_A41LogAccesosId, T000Q7_A14SecUserName, T000Q7_A12SecRoleDescription, T000Q7_A227LogAccesosTipo, T000Q7_A228LogAccesosFecha, T000Q7_A6SecUserId, T000Q7_A4SecRoleId
            }
            , new Object[] {
            T000Q8_A14SecUserName
            }
            , new Object[] {
            T000Q9_A6SecUserId
            }
            , new Object[] {
            T000Q10_A12SecRoleDescription
            }
            , new Object[] {
            T000Q11_A41LogAccesosId
            }
            , new Object[] {
            T000Q12_A41LogAccesosId
            }
            , new Object[] {
            T000Q13_A41LogAccesosId
            }
            , new Object[] {
            T000Q14_A41LogAccesosId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Q17_A14SecUserName
            }
            , new Object[] {
            T000Q18_A12SecRoleDescription
            }
            , new Object[] {
            T000Q19_A41LogAccesosId
            }
            , new Object[] {
            T000Q20_A6SecUserId
            }
         }
      );
      AV25Pgmname = "LogAccesos" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7LogAccesosId ;
   private short Z41LogAccesosId ;
   private short Z6SecUserId ;
   private short Z4SecRoleId ;
   private short N6SecUserId ;
   private short N4SecRoleId ;
   private short A4SecRoleId ;
   private short A6SecUserId ;
   private short AV7LogAccesosId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A41LogAccesosId ;
   private short AV21ComboSecUserId ;
   private short AV23ComboSecRoleId ;
   private short AV24Cond_SecUserId ;
   private short AV13Insert_SecUserId ;
   private short AV15Insert_SecRoleId ;
   private short RcdFound35 ;
   private short nIsDirty_35 ;
   private int trnEnded ;
   private int edtLogAccesosId_Enabled ;
   private int edtSecUserId_Visible ;
   private int edtSecUserId_Enabled ;
   private int edtSecUserName_Enabled ;
   private int edtSecRoleId_Visible ;
   private int edtSecRoleId_Enabled ;
   private int edtSecRoleDescription_Enabled ;
   private int edtLogAccesosFullName_Enabled ;
   private int edtLogAccesosFecha_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombosecuserid_Enabled ;
   private int edtavCombosecuserid_Visible ;
   private int edtavCombosecroleid_Enabled ;
   private int edtavCombosecroleid_Visible ;
   private int Combo_secuserid_Datalistupdateminimumcharacters ;
   private int Combo_secroleid_Datalistupdateminimumcharacters ;
   private int AV26GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z227LogAccesosTipo ;
   private String Combo_secroleid_Selectedvalue_get ;
   private String Combo_secuserid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecUserId_Internalname ;
   private String A227LogAccesosTipo ;
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
   private String edtLogAccesosId_Internalname ;
   private String edtLogAccesosId_Jsonclick ;
   private String divTablesplittedsecuserid_Internalname ;
   private String lblTextblocksecuserid_Internalname ;
   private String lblTextblocksecuserid_Jsonclick ;
   private String Combo_secuserid_Caption ;
   private String Combo_secuserid_Cls ;
   private String Combo_secuserid_Datalistproc ;
   private String Combo_secuserid_Datalistprocparametersprefix ;
   private String Combo_secuserid_Internalname ;
   private String TempTags ;
   private String edtSecUserId_Jsonclick ;
   private String edtSecUserName_Internalname ;
   private String edtSecUserName_Jsonclick ;
   private String divTablesplittedsecroleid_Internalname ;
   private String lblTextblocksecroleid_Internalname ;
   private String lblTextblocksecroleid_Jsonclick ;
   private String Combo_secroleid_Caption ;
   private String Combo_secroleid_Cls ;
   private String Combo_secroleid_Datalistproc ;
   private String Combo_secroleid_Internalname ;
   private String edtSecRoleId_Internalname ;
   private String edtSecRoleId_Jsonclick ;
   private String edtSecRoleDescription_Internalname ;
   private String edtSecRoleDescription_Jsonclick ;
   private String edtLogAccesosFullName_Internalname ;
   private String edtLogAccesosFullName_Jsonclick ;
   private String edtLogAccesosFecha_Internalname ;
   private String edtLogAccesosFecha_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_secuserid_Internalname ;
   private String edtavCombosecuserid_Internalname ;
   private String edtavCombosecuserid_Jsonclick ;
   private String divSectionattribute_secroleid_Internalname ;
   private String edtavCombosecroleid_Internalname ;
   private String edtavCombosecroleid_Jsonclick ;
   private String AV25Pgmname ;
   private String Combo_secuserid_Objectcall ;
   private String Combo_secuserid_Class ;
   private String Combo_secuserid_Icontype ;
   private String Combo_secuserid_Icon ;
   private String Combo_secuserid_Tooltip ;
   private String Combo_secuserid_Selectedvalue_set ;
   private String Combo_secuserid_Selectedtext_set ;
   private String Combo_secuserid_Selectedtext_get ;
   private String Combo_secuserid_Gamoauthtoken ;
   private String Combo_secuserid_Ddointernalname ;
   private String Combo_secuserid_Titlecontrolalign ;
   private String Combo_secuserid_Dropdownoptionstype ;
   private String Combo_secuserid_Titlecontrolidtoreplace ;
   private String Combo_secuserid_Datalisttype ;
   private String Combo_secuserid_Datalistfixedvalues ;
   private String Combo_secuserid_Htmltemplate ;
   private String Combo_secuserid_Multiplevaluestype ;
   private String Combo_secuserid_Loadingdata ;
   private String Combo_secuserid_Noresultsfound ;
   private String Combo_secuserid_Emptyitemtext ;
   private String Combo_secuserid_Onlyselectedvalues ;
   private String Combo_secuserid_Selectalltext ;
   private String Combo_secuserid_Multiplevaluesseparator ;
   private String Combo_secuserid_Addnewoptiontext ;
   private String Combo_secroleid_Objectcall ;
   private String Combo_secroleid_Class ;
   private String Combo_secroleid_Icontype ;
   private String Combo_secroleid_Icon ;
   private String Combo_secroleid_Tooltip ;
   private String Combo_secroleid_Selectedvalue_set ;
   private String Combo_secroleid_Selectedtext_set ;
   private String Combo_secroleid_Selectedtext_get ;
   private String Combo_secroleid_Gamoauthtoken ;
   private String Combo_secroleid_Ddointernalname ;
   private String Combo_secroleid_Titlecontrolalign ;
   private String Combo_secroleid_Dropdownoptionstype ;
   private String Combo_secroleid_Titlecontrolidtoreplace ;
   private String Combo_secroleid_Datalisttype ;
   private String Combo_secroleid_Datalistfixedvalues ;
   private String Combo_secroleid_Datalistprocparametersprefix ;
   private String Combo_secroleid_Htmltemplate ;
   private String Combo_secroleid_Multiplevaluestype ;
   private String Combo_secroleid_Loadingdata ;
   private String Combo_secroleid_Noresultsfound ;
   private String Combo_secroleid_Emptyitemtext ;
   private String Combo_secroleid_Onlyselectedvalues ;
   private String Combo_secroleid_Selectalltext ;
   private String Combo_secroleid_Multiplevaluesseparator ;
   private String Combo_secroleid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode35 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXt_char6 ;
   private String GXv_char9[] ;
   private java.util.Date Z228LogAccesosFecha ;
   private java.util.Date A228LogAccesosFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_secuserid_Emptyitem ;
   private boolean Combo_secroleid_Emptyitem ;
   private boolean Combo_secuserid_Enabled ;
   private boolean Combo_secuserid_Visible ;
   private boolean Combo_secuserid_Allowmultipleselection ;
   private boolean Combo_secuserid_Isgriditem ;
   private boolean Combo_secuserid_Hasdescription ;
   private boolean Combo_secuserid_Includeonlyselectedoption ;
   private boolean Combo_secuserid_Includeselectalloption ;
   private boolean Combo_secuserid_Includeaddnewoption ;
   private boolean Combo_secroleid_Enabled ;
   private boolean Combo_secroleid_Visible ;
   private boolean Combo_secroleid_Allowmultipleselection ;
   private boolean Combo_secroleid_Isgriditem ;
   private boolean Combo_secroleid_Hasdescription ;
   private boolean Combo_secroleid_Includeonlyselectedoption ;
   private boolean Combo_secroleid_Includeselectalloption ;
   private boolean Combo_secroleid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV20Combo_DataJson ;
   private String A14SecUserName ;
   private String A12SecRoleDescription ;
   private String A172LogAccesosFullName ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private String Z14SecUserName ;
   private String Z12SecRoleDescription ;
   private String Z172LogAccesosFullName ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_secuserid ;
   private com.genexus.webpanels.GXUserControl ucCombo_secroleid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbLogAccesosTipo ;
   private IDataStoreProvider pr_default ;
   private String[] T000Q4_A14SecUserName ;
   private String[] T000Q5_A12SecRoleDescription ;
   private short[] T000Q7_A41LogAccesosId ;
   private String[] T000Q7_A14SecUserName ;
   private String[] T000Q7_A12SecRoleDescription ;
   private String[] T000Q7_A227LogAccesosTipo ;
   private java.util.Date[] T000Q7_A228LogAccesosFecha ;
   private short[] T000Q7_A6SecUserId ;
   private short[] T000Q7_A4SecRoleId ;
   private short[] T000Q6_A6SecUserId ;
   private String[] T000Q8_A14SecUserName ;
   private short[] T000Q9_A6SecUserId ;
   private String[] T000Q10_A12SecRoleDescription ;
   private short[] T000Q11_A41LogAccesosId ;
   private short[] T000Q3_A41LogAccesosId ;
   private String[] T000Q3_A227LogAccesosTipo ;
   private java.util.Date[] T000Q3_A228LogAccesosFecha ;
   private short[] T000Q3_A6SecUserId ;
   private short[] T000Q3_A4SecRoleId ;
   private short[] T000Q12_A41LogAccesosId ;
   private short[] T000Q13_A41LogAccesosId ;
   private short[] T000Q2_A41LogAccesosId ;
   private String[] T000Q2_A227LogAccesosTipo ;
   private java.util.Date[] T000Q2_A228LogAccesosFecha ;
   private short[] T000Q2_A6SecUserId ;
   private short[] T000Q2_A4SecRoleId ;
   private short[] T000Q14_A41LogAccesosId ;
   private String[] T000Q17_A14SecUserName ;
   private String[] T000Q18_A12SecRoleDescription ;
   private short[] T000Q19_A41LogAccesosId ;
   private short[] T000Q20_A6SecUserId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16SecUserId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22SecRoleId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class logaccesos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Q2", "SELECT [LogAccesosId], [LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId] FROM [LogAccesos] WITH (UPDLOCK) WHERE [LogAccesosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q3", "SELECT [LogAccesosId], [LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId] FROM [LogAccesos] WHERE [LogAccesosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q4", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q5", "SELECT [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q6", "SELECT [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q7", "SELECT TM1.[LogAccesosId], T2.[SecUserName], T3.[SecRoleDescription], TM1.[LogAccesosTipo], TM1.[LogAccesosFecha], TM1.[SecUserId], TM1.[SecRoleId] FROM (([LogAccesos] TM1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = TM1.[SecUserId]) INNER JOIN [SecRole] T3 ON T3.[SecRoleId] = TM1.[SecRoleId]) WHERE TM1.[LogAccesosId] = ? ORDER BY TM1.[LogAccesosId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q8", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q9", "SELECT [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q10", "SELECT [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q11", "SELECT [LogAccesosId] FROM [LogAccesos] WHERE [LogAccesosId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q12", "SELECT TOP 1 [LogAccesosId] FROM [LogAccesos] WHERE ( [LogAccesosId] > ?) ORDER BY [LogAccesosId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Q13", "SELECT TOP 1 [LogAccesosId] FROM [LogAccesos] WHERE ( [LogAccesosId] < ?) ORDER BY [LogAccesosId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Q14", "INSERT INTO [LogAccesos]([LogAccesosTipo], [LogAccesosFecha], [SecUserId], [SecRoleId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000Q15", "UPDATE [LogAccesos] SET [LogAccesosTipo]=?, [LogAccesosFecha]=?, [SecUserId]=?, [SecRoleId]=?  WHERE [LogAccesosId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000Q16", "DELETE FROM [LogAccesos]  WHERE [LogAccesosId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000Q17", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q18", "SELECT [SecRoleDescription] FROM [SecRole] WHERE [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q19", "SELECT [LogAccesosId] FROM [LogAccesos] ORDER BY [LogAccesosId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Q20", "SELECT [SecUserId] FROM [SecUserRole] WHERE [SecUserId] = ? AND [SecRoleId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

