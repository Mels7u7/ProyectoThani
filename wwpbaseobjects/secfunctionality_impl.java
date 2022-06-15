package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secfunctionality_impl extends GXDataArea
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
         A2SecParentFunctionalityId = GXutil.lval( httpContext.GetPar( "SecParentFunctionalityId")) ;
         n2SecParentFunctionalityId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), 10, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A2SecParentFunctionalityId) ;
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
            AV7SecFunctionalityId = GXutil.lval( httpContext.GetPar( "SecFunctionalityId")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7SecFunctionalityId), 10, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecFunctionalityId), "ZZZZZZZZZ9")));
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
         Form.getMeta().addItem("description", "Functionality", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecFunctionalityDescription_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public secfunctionality_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secfunctionality_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionality_impl.class ));
   }

   public secfunctionality_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSecFunctionalityType = new HTMLChoice();
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
      if ( cmbSecFunctionalityType.getItemCount() > 0 )
      {
         A9SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A9SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9SecFunctionalityType), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecFunctionalityId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecFunctionalityId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecFunctionalityId_Internalname, GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( ((edtSecFunctionalityId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecFunctionalityId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecFunctionalityId_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecFunctionalityKey_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecFunctionalityKey_Internalname, "Key", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecFunctionalityKey_Internalname, A3SecFunctionalityKey, GXutil.rtrim( localUtil.format( A3SecFunctionalityKey, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecFunctionalityKey_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecFunctionalityKey_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecFunctionalityDescription_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecFunctionalityDescription_Internalname, "Description", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecFunctionalityDescription_Internalname, A8SecFunctionalityDescription, GXutil.rtrim( localUtil.format( A8SecFunctionalityDescription, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecFunctionalityDescription_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecFunctionalityDescription_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSecFunctionalityType.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbSecFunctionalityType.getInternalname(), "Type", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSecFunctionalityType, cmbSecFunctionalityType.getInternalname(), GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)), 1, cmbSecFunctionalityType.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbSecFunctionalityType.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(1), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      cmbSecFunctionalityType.setValue( GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Values", cmbSecFunctionalityType.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecParentFunctionalityDescription_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecParentFunctionalityDescription_Internalname, "Parent Functionality", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecParentFunctionalityDescription_Internalname, A11SecParentFunctionalityDescription, GXutil.rtrim( localUtil.format( A11SecParentFunctionalityDescription, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecParentFunctionalityDescription_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecParentFunctionalityDescription_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionality.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecFunctionality.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecParentFunctionalityId_Internalname, GXutil.ltrim( localUtil.ntoc( A2SecParentFunctionalityId, (byte)(10), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), "ZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecParentFunctionalityId_Jsonclick, 0, "Attribute", "", "", "", "", edtSecParentFunctionalityId_Visible, edtSecParentFunctionalityId_Enabled, 1, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecFunctionalityActive_Internalname, GXutil.booltostr( A7SecFunctionalityActive), GXutil.booltostr( A7SecFunctionalityActive), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecFunctionalityActive_Jsonclick, 0, "Attribute", "", "", "", "", edtSecFunctionalityActive_Visible, edtSecFunctionalityActive_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecFunctionality.htm");
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
      e11012 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( "Z1SecFunctionalityId"), ",", ".") ;
            Z3SecFunctionalityKey = httpContext.cgiGet( "Z3SecFunctionalityKey") ;
            Z8SecFunctionalityDescription = httpContext.cgiGet( "Z8SecFunctionalityDescription") ;
            Z9SecFunctionalityType = (byte)(localUtil.ctol( httpContext.cgiGet( "Z9SecFunctionalityType"), ",", ".")) ;
            Z7SecFunctionalityActive = GXutil.strtobool( httpContext.cgiGet( "Z7SecFunctionalityActive")) ;
            Z2SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( "Z2SecParentFunctionalityId"), ",", ".") ;
            n2SecParentFunctionalityId = ((0==A2SecParentFunctionalityId) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N2SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( "N2SecParentFunctionalityId"), ",", ".") ;
            n2SecParentFunctionalityId = ((0==A2SecParentFunctionalityId) ? true : false) ;
            AV7SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( "vSECFUNCTIONALITYID"), ",", ".") ;
            AV12Insert_SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( "vINSERT_SECPARENTFUNCTIONALITYID"), ",", ".") ;
            AV19Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
            A3SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A3SecFunctionalityKey", A3SecFunctionalityKey);
            A8SecFunctionalityDescription = httpContext.cgiGet( edtSecFunctionalityDescription_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8SecFunctionalityDescription", A8SecFunctionalityDescription);
            cmbSecFunctionalityType.setValue( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()) );
            A9SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A9SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9SecFunctionalityType), 2, 0));
            A11SecParentFunctionalityDescription = httpContext.cgiGet( edtSecParentFunctionalityDescription_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), ",", ".") > 9999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECPARENTFUNCTIONALITYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2SecParentFunctionalityId = 0 ;
               n2SecParentFunctionalityId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A2SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), 10, 0));
            }
            else
            {
               A2SecParentFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecParentFunctionalityId_Internalname), ",", ".") ;
               n2SecParentFunctionalityId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A2SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), 10, 0));
            }
            n2SecParentFunctionalityId = ((0==A2SecParentFunctionalityId) ? true : false) ;
            A7SecFunctionalityActive = GXutil.strtobool( httpContext.cgiGet( edtSecFunctionalityActive_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A7SecFunctionalityActive", A7SecFunctionalityActive);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"SecFunctionality");
            A1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
            forbiddenHiddens.add("SecFunctionalityId", localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            A3SecFunctionalityKey = httpContext.cgiGet( edtSecFunctionalityKey_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A3SecFunctionalityKey", A3SecFunctionalityKey);
            forbiddenHiddens.add("SecFunctionalityKey", GXutil.rtrim( localUtil.format( A3SecFunctionalityKey, "")));
            A9SecFunctionalityType = (byte)(GXutil.lval( httpContext.cgiGet( cmbSecFunctionalityType.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A9SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9SecFunctionalityType), 2, 0));
            forbiddenHiddens.add("SecFunctionalityType", localUtil.format( DecimalUtil.doubleToDec(A9SecFunctionalityType), "Z9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A1SecFunctionalityId != Z1SecFunctionalityId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("wwpbaseobjects\\secfunctionality:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1SecFunctionalityId = GXutil.lval( httpContext.GetPar( "SecFunctionalityId")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
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
                  sMode1 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode1 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound1 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_010( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SECFUNCTIONALITYID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecFunctionalityId_Internalname ;
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
                        e11012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12012 ();
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
         e12012 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll011( ) ;
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
         disableAttributes011( ) ;
      }
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

   public void confirm_010( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls011( ) ;
         }
         else
         {
            checkExtendedTable011( ) ;
            closeExtendedTableCursors011( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption010( )
   {
   }

   public void e11012( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV18WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV18WWPContext = GXv_SdtWWPContext1[0] ;
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV19Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV20GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GXV1), 8, 0));
         while ( AV20GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV20GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecParentFunctionalityId") == 0 )
            {
               AV12Insert_SecParentFunctionalityId = GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue()) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_SecParentFunctionalityId), 10, 0));
            }
            AV20GXV1 = (int)(AV20GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20GXV1), 8, 0));
         }
      }
      edtSecParentFunctionalityId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Visible), 5, 0), true);
      edtSecFunctionalityActive_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityActive_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityActive_Visible), 5, 0), true);
   }

   public void e12012( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.secfunctionalityww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm011( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z3SecFunctionalityKey = T00013_A3SecFunctionalityKey[0] ;
            Z8SecFunctionalityDescription = T00013_A8SecFunctionalityDescription[0] ;
            Z9SecFunctionalityType = T00013_A9SecFunctionalityType[0] ;
            Z7SecFunctionalityActive = T00013_A7SecFunctionalityActive[0] ;
            Z2SecParentFunctionalityId = T00013_A2SecParentFunctionalityId[0] ;
         }
         else
         {
            Z3SecFunctionalityKey = A3SecFunctionalityKey ;
            Z8SecFunctionalityDescription = A8SecFunctionalityDescription ;
            Z9SecFunctionalityType = A9SecFunctionalityType ;
            Z7SecFunctionalityActive = A7SecFunctionalityActive ;
            Z2SecParentFunctionalityId = A2SecParentFunctionalityId ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         Z3SecFunctionalityKey = A3SecFunctionalityKey ;
         Z8SecFunctionalityDescription = A8SecFunctionalityDescription ;
         Z9SecFunctionalityType = A9SecFunctionalityType ;
         Z7SecFunctionalityActive = A7SecFunctionalityActive ;
         Z2SecParentFunctionalityId = A2SecParentFunctionalityId ;
         Z11SecParentFunctionalityDescription = A11SecParentFunctionalityDescription ;
      }
   }

   public void standaloneNotModal( )
   {
      edtSecFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityKey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Enabled), 5, 0), true);
      cmbSecFunctionalityType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSecFunctionalityType.getEnabled(), 5, 0), true);
      AV19Pgmname = "WWPBaseObjects.SecFunctionality" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19Pgmname", AV19Pgmname);
      edtSecFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityKey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Enabled), 5, 0), true);
      cmbSecFunctionalityType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSecFunctionalityType.getEnabled(), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7SecFunctionalityId) )
      {
         A1SecFunctionalityId = AV7SecFunctionalityId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_SecParentFunctionalityId) )
      {
         edtSecParentFunctionalityId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Enabled), 5, 0), true);
      }
      else
      {
         edtSecParentFunctionalityId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_SecParentFunctionalityId) )
      {
         A2SecParentFunctionalityId = AV12Insert_SecParentFunctionalityId ;
         n2SecParentFunctionalityId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A2SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), 10, 0));
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
         /* Using cursor T00014 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId)});
         A11SecParentFunctionalityDescription = T00014_A11SecParentFunctionalityDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
         pr_default.close(2);
      }
   }

   public void load011( )
   {
      /* Using cursor T00015 */
      pr_default.execute(3, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A3SecFunctionalityKey = T00015_A3SecFunctionalityKey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3SecFunctionalityKey", A3SecFunctionalityKey);
         A8SecFunctionalityDescription = T00015_A8SecFunctionalityDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8SecFunctionalityDescription", A8SecFunctionalityDescription);
         A9SecFunctionalityType = T00015_A9SecFunctionalityType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9SecFunctionalityType), 2, 0));
         A11SecParentFunctionalityDescription = T00015_A11SecParentFunctionalityDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
         A7SecFunctionalityActive = T00015_A7SecFunctionalityActive[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7SecFunctionalityActive", A7SecFunctionalityActive);
         A2SecParentFunctionalityId = T00015_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = T00015_n2SecParentFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), 10, 0));
         zm011( -10) ;
      }
      pr_default.close(3);
      onLoadActions011( ) ;
   }

   public void onLoadActions011( )
   {
   }

   public void checkExtendedTable011( )
   {
      nIsDirty_1 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00016 */
      pr_default.execute(4, new Object[] {A3SecFunctionalityKey, Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {"Functionality Key"}), 1, "SECFUNCTIONALITYKEY");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityKey_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      /* Using cursor T00014 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         if ( ! ( (0==A2SecParentFunctionalityId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Sec Functionality Functionality'.", "ForeignKeyNotFound", 1, "SECPARENTFUNCTIONALITYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A11SecParentFunctionalityDescription = T00014_A11SecParentFunctionalityDescription[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
      pr_default.close(2);
   }

   public void closeExtendedTableCursors011( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( long A2SecParentFunctionalityId )
   {
      /* Using cursor T00017 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         if ( ! ( (0==A2SecParentFunctionalityId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Sec Functionality Functionality'.", "ForeignKeyNotFound", 1, "SECPARENTFUNCTIONALITYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A11SecParentFunctionalityDescription = T00017_A11SecParentFunctionalityDescription[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A11SecParentFunctionalityDescription)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void getKey011( )
   {
      /* Using cursor T00018 */
      pr_default.execute(6, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound1 = (short)(1) ;
      }
      else
      {
         RcdFound1 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00013 */
      pr_default.execute(1, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm011( 10) ;
         RcdFound1 = (short)(1) ;
         A1SecFunctionalityId = T00013_A1SecFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
         A3SecFunctionalityKey = T00013_A3SecFunctionalityKey[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3SecFunctionalityKey", A3SecFunctionalityKey);
         A8SecFunctionalityDescription = T00013_A8SecFunctionalityDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8SecFunctionalityDescription", A8SecFunctionalityDescription);
         A9SecFunctionalityType = T00013_A9SecFunctionalityType[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9SecFunctionalityType), 2, 0));
         A7SecFunctionalityActive = T00013_A7SecFunctionalityActive[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7SecFunctionalityActive", A7SecFunctionalityActive);
         A2SecParentFunctionalityId = T00013_A2SecParentFunctionalityId[0] ;
         n2SecParentFunctionalityId = T00013_n2SecParentFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), 10, 0));
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load011( ) ;
         if ( AnyError == 1 )
         {
            RcdFound1 = (short)(0) ;
            initializeNonKey011( ) ;
         }
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound1 = (short)(0) ;
         initializeNonKey011( ) ;
         sMode1 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode1 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey011( ) ;
      if ( RcdFound1 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T00019 */
      pr_default.execute(7, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00019_A1SecFunctionalityId[0] < A1SecFunctionalityId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00019_A1SecFunctionalityId[0] > A1SecFunctionalityId ) ) )
         {
            A1SecFunctionalityId = T00019_A1SecFunctionalityId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound1 = (short)(0) ;
      /* Using cursor T000110 */
      pr_default.execute(8, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000110_A1SecFunctionalityId[0] > A1SecFunctionalityId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000110_A1SecFunctionalityId[0] < A1SecFunctionalityId ) ) )
         {
            A1SecFunctionalityId = T000110_A1SecFunctionalityId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
            RcdFound1 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey011( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecFunctionalityDescription_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert011( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound1 == 1 )
         {
            if ( A1SecFunctionalityId != Z1SecFunctionalityId )
            {
               A1SecFunctionalityId = Z1SecFunctionalityId ;
               httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SECFUNCTIONALITYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecFunctionalityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecFunctionalityDescription_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update011( ) ;
               GX_FocusControl = edtSecFunctionalityDescription_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A1SecFunctionalityId != Z1SecFunctionalityId )
            {
               /* Insert record */
               GX_FocusControl = edtSecFunctionalityDescription_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert011( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SECFUNCTIONALITYID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecFunctionalityId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSecFunctionalityDescription_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert011( ) ;
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
      if ( A1SecFunctionalityId != Z1SecFunctionalityId )
      {
         A1SecFunctionalityId = Z1SecFunctionalityId ;
         httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SECFUNCTIONALITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecFunctionalityDescription_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency011( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00012 */
         pr_default.execute(0, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecFunctionality"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z3SecFunctionalityKey, T00012_A3SecFunctionalityKey[0]) != 0 ) || ( GXutil.strcmp(Z8SecFunctionalityDescription, T00012_A8SecFunctionalityDescription[0]) != 0 ) || ( Z9SecFunctionalityType != T00012_A9SecFunctionalityType[0] ) || ( Z7SecFunctionalityActive != T00012_A7SecFunctionalityActive[0] ) || ( Z2SecParentFunctionalityId != T00012_A2SecParentFunctionalityId[0] ) )
         {
            if ( GXutil.strcmp(Z3SecFunctionalityKey, T00012_A3SecFunctionalityKey[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityKey");
               GXutil.writeLogRaw("Old: ",Z3SecFunctionalityKey);
               GXutil.writeLogRaw("Current: ",T00012_A3SecFunctionalityKey[0]);
            }
            if ( GXutil.strcmp(Z8SecFunctionalityDescription, T00012_A8SecFunctionalityDescription[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityDescription");
               GXutil.writeLogRaw("Old: ",Z8SecFunctionalityDescription);
               GXutil.writeLogRaw("Current: ",T00012_A8SecFunctionalityDescription[0]);
            }
            if ( Z9SecFunctionalityType != T00012_A9SecFunctionalityType[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityType");
               GXutil.writeLogRaw("Old: ",Z9SecFunctionalityType);
               GXutil.writeLogRaw("Current: ",T00012_A9SecFunctionalityType[0]);
            }
            if ( Z7SecFunctionalityActive != T00012_A7SecFunctionalityActive[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecFunctionalityActive");
               GXutil.writeLogRaw("Old: ",Z7SecFunctionalityActive);
               GXutil.writeLogRaw("Current: ",T00012_A7SecFunctionalityActive[0]);
            }
            if ( Z2SecParentFunctionalityId != T00012_A2SecParentFunctionalityId[0] )
            {
               GXutil.writeLogln("wwpbaseobjects.secfunctionality:[seudo value changed for attri]"+"SecParentFunctionalityId");
               GXutil.writeLogRaw("Old: ",Z2SecParentFunctionalityId);
               GXutil.writeLogRaw("Current: ",T00012_A2SecParentFunctionalityId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecFunctionality"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         zm011( 0) ;
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000111 */
                  pr_default.execute(9, new Object[] {A3SecFunctionalityKey, A8SecFunctionalityDescription, Byte.valueOf(A9SecFunctionalityType), Boolean.valueOf(A7SecFunctionalityActive), Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId)});
                  A1SecFunctionalityId = T000111_A1SecFunctionalityId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption010( ) ;
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
            load011( ) ;
         }
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void update011( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable011( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm011( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate011( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000112 */
                  pr_default.execute(10, new Object[] {A3SecFunctionalityKey, A8SecFunctionalityDescription, Byte.valueOf(A9SecFunctionalityType), Boolean.valueOf(A7SecFunctionalityActive), Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId), Long.valueOf(A1SecFunctionalityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecFunctionality"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate011( ) ;
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
         endLevel011( ) ;
      }
      closeExtendedTableCursors011( ) ;
   }

   public void deferredUpdate011( )
   {
   }

   public void delete( )
   {
      beforeValidate011( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency011( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls011( ) ;
         afterConfirm011( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete011( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000113 */
               pr_default.execute(11, new Object[] {Long.valueOf(A1SecFunctionalityId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionality");
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
      sMode1 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel011( ) ;
      Gx_mode = sMode1 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls011( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000114 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId)});
         A11SecParentFunctionalityDescription = T000114_A11SecParentFunctionalityDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
         pr_default.close(12);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000115 */
         pr_default.execute(13, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Functionality"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T000116 */
         pr_default.execute(14, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Functionalities"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T000117 */
         pr_default.execute(15, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Functionality Role"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void endLevel011( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete011( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(12);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secfunctionality");
         if ( AnyError == 0 )
         {
            confirmValues010( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(12);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secfunctionality");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart011( )
   {
      /* Scan By routine */
      /* Using cursor T000118 */
      pr_default.execute(16);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1SecFunctionalityId = T000118_A1SecFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext011( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound1 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound1 = (short)(1) ;
         A1SecFunctionalityId = T000118_A1SecFunctionalityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
      }
   }

   public void scanEnd011( )
   {
      pr_default.close(16);
   }

   public void afterConfirm011( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert011( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate011( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete011( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete011( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate011( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes011( )
   {
      edtSecFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityKey_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityKey_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityKey_Enabled), 5, 0), true);
      edtSecFunctionalityDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityDescription_Enabled), 5, 0), true);
      cmbSecFunctionalityType.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecFunctionalityType.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSecFunctionalityType.getEnabled(), 5, 0), true);
      edtSecParentFunctionalityDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityDescription_Enabled), 5, 0), true);
      edtSecParentFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecParentFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecParentFunctionalityId_Enabled), 5, 0), true);
      edtSecFunctionalityActive_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityActive_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityActive_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes011( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues010( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110321797", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecFunctionalityId,10,0))}, new String[] {"Gx_mode","SecFunctionalityId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"SecFunctionality");
      forbiddenHiddens.add("SecFunctionalityId", localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("SecFunctionalityKey", GXutil.rtrim( localUtil.format( A3SecFunctionalityKey, "")));
      forbiddenHiddens.add("SecFunctionalityType", localUtil.format( DecimalUtil.doubleToDec(A9SecFunctionalityType), "Z9"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wwpbaseobjects\\secfunctionality:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z1SecFunctionalityId", GXutil.ltrim( localUtil.ntoc( Z1SecFunctionalityId, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z3SecFunctionalityKey", Z3SecFunctionalityKey);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z8SecFunctionalityDescription", Z8SecFunctionalityDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z9SecFunctionalityType", GXutil.ltrim( localUtil.ntoc( Z9SecFunctionalityType, (byte)(2), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "Z7SecFunctionalityActive", Z7SecFunctionalityActive);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z2SecParentFunctionalityId", GXutil.ltrim( localUtil.ntoc( Z2SecParentFunctionalityId, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N2SecParentFunctionalityId", GXutil.ltrim( localUtil.ntoc( A2SecParentFunctionalityId, (byte)(10), (byte)(0), ",", "")));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( AV7SecFunctionalityId, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECFUNCTIONALITYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecFunctionalityId), "ZZZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SECPARENTFUNCTIONALITYID", GXutil.ltrim( localUtil.ntoc( AV12Insert_SecParentFunctionalityId, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV19Pgmname));
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
      return formatLink("com.projectthani.wwpbaseobjects.secfunctionality", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecFunctionalityId,10,0))}, new String[] {"Gx_mode","SecFunctionalityId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecFunctionality" ;
   }

   public String getPgmdesc( )
   {
      return "Functionality" ;
   }

   public void initializeNonKey011( )
   {
      A2SecParentFunctionalityId = 0 ;
      n2SecParentFunctionalityId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2SecParentFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2SecParentFunctionalityId), 10, 0));
      n2SecParentFunctionalityId = ((0==A2SecParentFunctionalityId) ? true : false) ;
      A3SecFunctionalityKey = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A3SecFunctionalityKey", A3SecFunctionalityKey);
      A8SecFunctionalityDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8SecFunctionalityDescription", A8SecFunctionalityDescription);
      A9SecFunctionalityType = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A9SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9SecFunctionalityType), 2, 0));
      A11SecParentFunctionalityDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
      A7SecFunctionalityActive = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A7SecFunctionalityActive", A7SecFunctionalityActive);
      Z3SecFunctionalityKey = "" ;
      Z8SecFunctionalityDescription = "" ;
      Z9SecFunctionalityType = (byte)(0) ;
      Z7SecFunctionalityActive = false ;
      Z2SecParentFunctionalityId = 0 ;
   }

   public void initAll011( )
   {
      A1SecFunctionalityId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1SecFunctionalityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1SecFunctionalityId), 10, 0));
      initializeNonKey011( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110321813", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secfunctionality.js", "?20225110321813", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID" ;
      edtSecFunctionalityKey_Internalname = "SECFUNCTIONALITYKEY" ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION" ;
      cmbSecFunctionalityType.setInternalname( "SECFUNCTIONALITYTYPE" );
      edtSecParentFunctionalityDescription_Internalname = "SECPARENTFUNCTIONALITYDESCRIPTION" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtSecParentFunctionalityId_Internalname = "SECPARENTFUNCTIONALITYID" ;
      edtSecFunctionalityActive_Internalname = "SECFUNCTIONALITYACTIVE" ;
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
      Form.setCaption( "Functionality" );
      edtSecFunctionalityActive_Jsonclick = "" ;
      edtSecFunctionalityActive_Enabled = 1 ;
      edtSecFunctionalityActive_Visible = 1 ;
      edtSecParentFunctionalityId_Jsonclick = "" ;
      edtSecParentFunctionalityId_Enabled = 1 ;
      edtSecParentFunctionalityId_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtSecParentFunctionalityDescription_Jsonclick = "" ;
      edtSecParentFunctionalityDescription_Enabled = 0 ;
      cmbSecFunctionalityType.setJsonclick( "" );
      cmbSecFunctionalityType.setEnabled( 0 );
      edtSecFunctionalityDescription_Jsonclick = "" ;
      edtSecFunctionalityDescription_Enabled = 1 ;
      edtSecFunctionalityKey_Jsonclick = "" ;
      edtSecFunctionalityKey_Enabled = 0 ;
      edtSecFunctionalityId_Jsonclick = "" ;
      edtSecFunctionalityId_Enabled = 0 ;
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
      cmbSecFunctionalityType.setName( "SECFUNCTIONALITYTYPE" );
      cmbSecFunctionalityType.setWebtags( "" );
      cmbSecFunctionalityType.addItem("1", "Mode", (short)(0));
      cmbSecFunctionalityType.addItem("2", "Action", (short)(0));
      cmbSecFunctionalityType.addItem("3", "Tab", (short)(0));
      cmbSecFunctionalityType.addItem("4", "Object", (short)(0));
      cmbSecFunctionalityType.addItem("5", "Attribute", (short)(0));
      if ( cmbSecFunctionalityType.getItemCount() > 0 )
      {
         A9SecFunctionalityType = (byte)(GXutil.lval( cmbSecFunctionalityType.getValidValue(GXutil.trim( GXutil.str( A9SecFunctionalityType, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A9SecFunctionalityType", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9SecFunctionalityType), 2, 0));
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

   public void valid_Secfunctionalitykey( )
   {
      /* Using cursor T000119 */
      pr_default.execute(17, new Object[] {A3SecFunctionalityKey, Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_1004", new Object[] {"Functionality Key"}), 1, "SECFUNCTIONALITYKEY");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityKey_Internalname ;
      }
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Secparentfunctionalityid( )
   {
      n2SecParentFunctionalityId = false ;
      /* Using cursor T000114 */
      pr_default.execute(12, new Object[] {Boolean.valueOf(n2SecParentFunctionalityId), Long.valueOf(A2SecParentFunctionalityId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A2SecParentFunctionalityId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Sec Functionality Functionality'.", "ForeignKeyNotFound", 1, "SECPARENTFUNCTIONALITYID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecParentFunctionalityId_Internalname ;
         }
      }
      A11SecParentFunctionalityDescription = T000114_A11SecParentFunctionalityDescription[0] ;
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A11SecParentFunctionalityDescription", A11SecParentFunctionalityDescription);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SecFunctionalityId',fld:'vSECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7SecFunctionalityId',fld:'vSECFUNCTIONALITYID',pic:'ZZZZZZZZZ9',hsh:true},{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'A3SecFunctionalityKey',fld:'SECFUNCTIONALITYKEY',pic:''},{av:'cmbSecFunctionalityType'},{av:'A9SecFunctionalityType',fld:'SECFUNCTIONALITYTYPE',pic:'Z9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12012',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SECFUNCTIONALITYID","{handler:'valid_Secfunctionalityid',iparms:[]");
      setEventMetadata("VALID_SECFUNCTIONALITYID",",oparms:[]}");
      setEventMetadata("VALID_SECFUNCTIONALITYKEY","{handler:'valid_Secfunctionalitykey',iparms:[{av:'A3SecFunctionalityKey',fld:'SECFUNCTIONALITYKEY',pic:''},{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("VALID_SECFUNCTIONALITYKEY",",oparms:[]}");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID","{handler:'valid_Secparentfunctionalityid',iparms:[{av:'A2SecParentFunctionalityId',fld:'SECPARENTFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'A11SecParentFunctionalityDescription',fld:'SECPARENTFUNCTIONALITYDESCRIPTION',pic:''}]");
      setEventMetadata("VALID_SECPARENTFUNCTIONALITYID",",oparms:[{av:'A11SecParentFunctionalityDescription',fld:'SECPARENTFUNCTIONALITYDESCRIPTION',pic:''}]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z3SecFunctionalityKey = "" ;
      Z8SecFunctionalityDescription = "" ;
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
      A3SecFunctionalityKey = "" ;
      TempTags = "" ;
      A8SecFunctionalityDescription = "" ;
      A11SecParentFunctionalityDescription = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV19Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode1 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV18WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z11SecParentFunctionalityDescription = "" ;
      T00014_A11SecParentFunctionalityDescription = new String[] {""} ;
      T00015_A1SecFunctionalityId = new long[1] ;
      T00015_A3SecFunctionalityKey = new String[] {""} ;
      T00015_A8SecFunctionalityDescription = new String[] {""} ;
      T00015_A9SecFunctionalityType = new byte[1] ;
      T00015_A11SecParentFunctionalityDescription = new String[] {""} ;
      T00015_A7SecFunctionalityActive = new boolean[] {false} ;
      T00015_A2SecParentFunctionalityId = new long[1] ;
      T00015_n2SecParentFunctionalityId = new boolean[] {false} ;
      T00016_A3SecFunctionalityKey = new String[] {""} ;
      T00017_A11SecParentFunctionalityDescription = new String[] {""} ;
      T00018_A1SecFunctionalityId = new long[1] ;
      T00013_A1SecFunctionalityId = new long[1] ;
      T00013_A3SecFunctionalityKey = new String[] {""} ;
      T00013_A8SecFunctionalityDescription = new String[] {""} ;
      T00013_A9SecFunctionalityType = new byte[1] ;
      T00013_A7SecFunctionalityActive = new boolean[] {false} ;
      T00013_A2SecParentFunctionalityId = new long[1] ;
      T00013_n2SecParentFunctionalityId = new boolean[] {false} ;
      T00019_A1SecFunctionalityId = new long[1] ;
      T000110_A1SecFunctionalityId = new long[1] ;
      T00012_A1SecFunctionalityId = new long[1] ;
      T00012_A3SecFunctionalityKey = new String[] {""} ;
      T00012_A8SecFunctionalityDescription = new String[] {""} ;
      T00012_A9SecFunctionalityType = new byte[1] ;
      T00012_A7SecFunctionalityActive = new boolean[] {false} ;
      T00012_A2SecParentFunctionalityId = new long[1] ;
      T00012_n2SecParentFunctionalityId = new boolean[] {false} ;
      T000111_A1SecFunctionalityId = new long[1] ;
      T000114_A11SecParentFunctionalityDescription = new String[] {""} ;
      T000115_A2SecParentFunctionalityId = new long[1] ;
      T000115_n2SecParentFunctionalityId = new boolean[] {false} ;
      T000116_A5SecObjectName = new String[] {""} ;
      T000116_A1SecFunctionalityId = new long[1] ;
      T000117_A1SecFunctionalityId = new long[1] ;
      T000117_A4SecRoleId = new short[1] ;
      T000118_A1SecFunctionalityId = new long[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000119_A3SecFunctionalityKey = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secfunctionality__default(),
         new Object[] {
             new Object[] {
            T00012_A1SecFunctionalityId, T00012_A3SecFunctionalityKey, T00012_A8SecFunctionalityDescription, T00012_A9SecFunctionalityType, T00012_A7SecFunctionalityActive, T00012_A2SecParentFunctionalityId, T00012_n2SecParentFunctionalityId
            }
            , new Object[] {
            T00013_A1SecFunctionalityId, T00013_A3SecFunctionalityKey, T00013_A8SecFunctionalityDescription, T00013_A9SecFunctionalityType, T00013_A7SecFunctionalityActive, T00013_A2SecParentFunctionalityId, T00013_n2SecParentFunctionalityId
            }
            , new Object[] {
            T00014_A11SecParentFunctionalityDescription
            }
            , new Object[] {
            T00015_A1SecFunctionalityId, T00015_A3SecFunctionalityKey, T00015_A8SecFunctionalityDescription, T00015_A9SecFunctionalityType, T00015_A11SecParentFunctionalityDescription, T00015_A7SecFunctionalityActive, T00015_A2SecParentFunctionalityId, T00015_n2SecParentFunctionalityId
            }
            , new Object[] {
            T00016_A3SecFunctionalityKey
            }
            , new Object[] {
            T00017_A11SecParentFunctionalityDescription
            }
            , new Object[] {
            T00018_A1SecFunctionalityId
            }
            , new Object[] {
            T00019_A1SecFunctionalityId
            }
            , new Object[] {
            T000110_A1SecFunctionalityId
            }
            , new Object[] {
            T000111_A1SecFunctionalityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000114_A11SecParentFunctionalityDescription
            }
            , new Object[] {
            T000115_A2SecParentFunctionalityId
            }
            , new Object[] {
            T000116_A5SecObjectName, T000116_A1SecFunctionalityId
            }
            , new Object[] {
            T000117_A1SecFunctionalityId, T000117_A4SecRoleId
            }
            , new Object[] {
            T000118_A1SecFunctionalityId
            }
            , new Object[] {
            T000119_A3SecFunctionalityKey
            }
         }
      );
      AV19Pgmname = "WWPBaseObjects.SecFunctionality" ;
   }

   private byte Z9SecFunctionalityType ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A9SecFunctionalityType ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound1 ;
   private short nIsDirty_1 ;
   private int trnEnded ;
   private int edtSecFunctionalityId_Enabled ;
   private int edtSecFunctionalityKey_Enabled ;
   private int edtSecFunctionalityDescription_Enabled ;
   private int edtSecParentFunctionalityDescription_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtSecParentFunctionalityId_Visible ;
   private int edtSecParentFunctionalityId_Enabled ;
   private int edtSecFunctionalityActive_Visible ;
   private int edtSecFunctionalityActive_Enabled ;
   private int AV20GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private long wcpOAV7SecFunctionalityId ;
   private long Z1SecFunctionalityId ;
   private long Z2SecParentFunctionalityId ;
   private long N2SecParentFunctionalityId ;
   private long A2SecParentFunctionalityId ;
   private long AV7SecFunctionalityId ;
   private long A1SecFunctionalityId ;
   private long AV12Insert_SecParentFunctionalityId ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecFunctionalityDescription_Internalname ;
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
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityKey_Internalname ;
   private String edtSecFunctionalityKey_Jsonclick ;
   private String TempTags ;
   private String edtSecFunctionalityDescription_Jsonclick ;
   private String edtSecParentFunctionalityDescription_Internalname ;
   private String edtSecParentFunctionalityDescription_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtSecParentFunctionalityId_Internalname ;
   private String edtSecParentFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityActive_Internalname ;
   private String edtSecFunctionalityActive_Jsonclick ;
   private String AV19Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode1 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private boolean Z7SecFunctionalityActive ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n2SecParentFunctionalityId ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A7SecFunctionalityActive ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private String Z3SecFunctionalityKey ;
   private String Z8SecFunctionalityDescription ;
   private String A3SecFunctionalityKey ;
   private String A8SecFunctionalityDescription ;
   private String A11SecParentFunctionalityDescription ;
   private String Z11SecParentFunctionalityDescription ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbSecFunctionalityType ;
   private IDataStoreProvider pr_default ;
   private String[] T00014_A11SecParentFunctionalityDescription ;
   private long[] T00015_A1SecFunctionalityId ;
   private String[] T00015_A3SecFunctionalityKey ;
   private String[] T00015_A8SecFunctionalityDescription ;
   private byte[] T00015_A9SecFunctionalityType ;
   private String[] T00015_A11SecParentFunctionalityDescription ;
   private boolean[] T00015_A7SecFunctionalityActive ;
   private long[] T00015_A2SecParentFunctionalityId ;
   private boolean[] T00015_n2SecParentFunctionalityId ;
   private String[] T00016_A3SecFunctionalityKey ;
   private String[] T00017_A11SecParentFunctionalityDescription ;
   private long[] T00018_A1SecFunctionalityId ;
   private long[] T00013_A1SecFunctionalityId ;
   private String[] T00013_A3SecFunctionalityKey ;
   private String[] T00013_A8SecFunctionalityDescription ;
   private byte[] T00013_A9SecFunctionalityType ;
   private boolean[] T00013_A7SecFunctionalityActive ;
   private long[] T00013_A2SecParentFunctionalityId ;
   private boolean[] T00013_n2SecParentFunctionalityId ;
   private long[] T00019_A1SecFunctionalityId ;
   private long[] T000110_A1SecFunctionalityId ;
   private long[] T00012_A1SecFunctionalityId ;
   private String[] T00012_A3SecFunctionalityKey ;
   private String[] T00012_A8SecFunctionalityDescription ;
   private byte[] T00012_A9SecFunctionalityType ;
   private boolean[] T00012_A7SecFunctionalityActive ;
   private long[] T00012_A2SecParentFunctionalityId ;
   private boolean[] T00012_n2SecParentFunctionalityId ;
   private long[] T000111_A1SecFunctionalityId ;
   private String[] T000114_A11SecParentFunctionalityDescription ;
   private long[] T000115_A2SecParentFunctionalityId ;
   private boolean[] T000115_n2SecParentFunctionalityId ;
   private String[] T000116_A5SecObjectName ;
   private long[] T000116_A1SecFunctionalityId ;
   private long[] T000117_A1SecFunctionalityId ;
   private short[] T000117_A4SecRoleId ;
   private long[] T000118_A1SecFunctionalityId ;
   private String[] T000119_A3SecFunctionalityKey ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV18WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class secfunctionality__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00012", "SELECT [SecFunctionalityId], [SecFunctionalityKey], [SecFunctionalityDescription], [SecFunctionalityType], [SecFunctionalityActive], [SecParentFunctionalityId] AS SecParentFunctionalityId FROM [SecFunctionality] WITH (UPDLOCK) WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00013", "SELECT [SecFunctionalityId], [SecFunctionalityKey], [SecFunctionalityDescription], [SecFunctionalityType], [SecFunctionalityActive], [SecParentFunctionalityId] AS SecParentFunctionalityId FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00014", "SELECT [SecFunctionalityDescription] AS SecParentFunctionalityDescription FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00015", "SELECT TM1.[SecFunctionalityId], TM1.[SecFunctionalityKey], TM1.[SecFunctionalityDescription], TM1.[SecFunctionalityType], T2.[SecFunctionalityDescription] AS SecParentFunctionalityDescription, TM1.[SecFunctionalityActive], TM1.[SecParentFunctionalityId] AS SecParentFunctionalityId FROM ([SecFunctionality] TM1 LEFT JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = TM1.[SecParentFunctionalityId]) WHERE TM1.[SecFunctionalityId] = ? ORDER BY TM1.[SecFunctionalityId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00016", "SELECT [SecFunctionalityKey] FROM [SecFunctionality] WHERE ([SecFunctionalityKey] = ?) AND (Not ( [SecFunctionalityId] = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00017", "SELECT [SecFunctionalityDescription] AS SecParentFunctionalityDescription FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00018", "SELECT [SecFunctionalityId] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00019", "SELECT TOP 1 [SecFunctionalityId] FROM [SecFunctionality] WHERE ( [SecFunctionalityId] > ?) ORDER BY [SecFunctionalityId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000110", "SELECT TOP 1 [SecFunctionalityId] FROM [SecFunctionality] WHERE ( [SecFunctionalityId] < ?) ORDER BY [SecFunctionalityId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000111", "INSERT INTO [SecFunctionality]([SecFunctionalityKey], [SecFunctionalityDescription], [SecFunctionalityType], [SecFunctionalityActive], [SecParentFunctionalityId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000112", "UPDATE [SecFunctionality] SET [SecFunctionalityKey]=?, [SecFunctionalityDescription]=?, [SecFunctionalityType]=?, [SecFunctionalityActive]=?, [SecParentFunctionalityId]=?  WHERE [SecFunctionalityId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000113", "DELETE FROM [SecFunctionality]  WHERE [SecFunctionalityId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000114", "SELECT [SecFunctionalityDescription] AS SecParentFunctionalityDescription FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000115", "SELECT TOP 1 [SecFunctionalityId] AS SecParentFunctionalityId FROM [SecFunctionality] WHERE [SecParentFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000116", "SELECT TOP 1 [SecObjectName], [SecFunctionalityId] FROM [SecObjectFunctionalities] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000117", "SELECT TOP 1 [SecFunctionalityId], [SecRoleId] FROM [SecFunctionalityRole] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000118", "SELECT [SecFunctionalityId] FROM [SecFunctionality] ORDER BY [SecFunctionalityId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000119", "SELECT [SecFunctionalityKey] FROM [SecFunctionality] WHERE ([SecFunctionalityKey] = ?) AND (Not ( [SecFunctionalityId] = ?)) ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((long[]) buf[6])[0] = rslt.getLong(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 15 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 16 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 3 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 6 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[5]).longValue());
               }
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[5]).longValue());
               }
               stmt.setLong(6, ((Number) parms[6]).longValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(1, ((Number) parms[1]).longValue());
               }
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
      }
   }

}

