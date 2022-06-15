package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secuser_impl extends GXDataArea
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
            AV7SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7SecUserId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecUserId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "User", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public secuser_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secuser_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuser_impl.class ));
   }

   public secuser_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbSecUserEstadoR = new HTMLChoice();
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
      if ( cmbSecUserEstadoR.getItemCount() > 0 )
      {
         A211SecUserEstadoR = cmbSecUserEstadoR.getValidValue(A211SecUserEstadoR) ;
         httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSecUserEstadoR.setValue( GXutil.rtrim( A211SecUserEstadoR) );
         httpContext.ajax_rsp_assign_prop("", false, cmbSecUserEstadoR.getInternalname(), "Values", cmbSecUserEstadoR.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserId_Internalname, GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSecUserId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WWPBaseObjects\\SecUser.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserName_Internalname, A14SecUserName, GXutil.rtrim( localUtil.format( A14SecUserName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecUser.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserPassword_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserPassword_Internalname, "Password", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserPassword_Internalname, A15SecUserPassword, GXutil.rtrim( localUtil.format( A15SecUserPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserPassword_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserPassword_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(-1), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecUser.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserEmail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserEmail_Internalname, "Correo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserEmail_Internalname, A122SecUserEmail, GXutil.rtrim( localUtil.format( A122SecUserEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A122SecUserEmail, "", "", "", edtSecUserEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserEmail_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_WWPBaseObjects\\SecUser.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbSecUserEstadoR.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbSecUserEstadoR.getInternalname(), "Estado R", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbSecUserEstadoR, cmbSecUserEstadoR.getInternalname(), GXutil.rtrim( A211SecUserEstadoR), 1, cmbSecUserEstadoR.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbSecUserEstadoR.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(1), "HLP_WWPBaseObjects\\SecUser.htm");
      cmbSecUserEstadoR.setValue( GXutil.rtrim( A211SecUserEstadoR) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecUserEstadoR.getInternalname(), "Values", cmbSecUserEstadoR.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUser.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUser.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecUser.htm");
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
      e11052 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "Z6SecUserId"), ",", ".")) ;
            Z14SecUserName = httpContext.cgiGet( "Z14SecUserName") ;
            Z15SecUserPassword = httpContext.cgiGet( "Z15SecUserPassword") ;
            Z122SecUserEmail = httpContext.cgiGet( "Z122SecUserEmail") ;
            Z211SecUserEstadoR = httpContext.cgiGet( "Z211SecUserEstadoR") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "vSECUSERID"), ",", ".")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
            n6SecUserId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            A14SecUserName = httpContext.cgiGet( edtSecUserName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
            A15SecUserPassword = httpContext.cgiGet( edtSecUserPassword_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A15SecUserPassword", A15SecUserPassword);
            A122SecUserEmail = httpContext.cgiGet( edtSecUserEmail_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A122SecUserEmail", A122SecUserEmail);
            cmbSecUserEstadoR.setValue( httpContext.cgiGet( cmbSecUserEstadoR.getInternalname()) );
            A211SecUserEstadoR = httpContext.cgiGet( cmbSecUserEstadoR.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"SecUser");
            A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
            n6SecUserId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            forbiddenHiddens.add("SecUserId", localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A6SecUserId != Z6SecUserId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("wwpbaseobjects\\secuser:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A6SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
               n6SecUserId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
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
                  sMode6 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound6 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_050( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SECUSERID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecUserId_Internalname ;
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
                        e11052 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12052 ();
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
         e12052 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll056( ) ;
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
         disableAttributes056( ) ;
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

   public void confirm_050( )
   {
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls056( ) ;
         }
         else
         {
            checkExtendedTable056( ) ;
            closeExtendedTableCursors056( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption050( )
   {
   }

   public void e11052( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV15WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV15WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Insert", GXv_boolean3) ;
         secuser_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Update", GXv_boolean3) ;
         secuser_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser_Delete", GXv_boolean3) ;
         secuser_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e12052( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.secuserww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm056( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z14SecUserName = T00053_A14SecUserName[0] ;
            Z15SecUserPassword = T00053_A15SecUserPassword[0] ;
            Z122SecUserEmail = T00053_A122SecUserEmail[0] ;
            Z211SecUserEstadoR = T00053_A211SecUserEstadoR[0] ;
         }
         else
         {
            Z14SecUserName = A14SecUserName ;
            Z15SecUserPassword = A15SecUserPassword ;
            Z122SecUserEmail = A122SecUserEmail ;
            Z211SecUserEstadoR = A211SecUserEstadoR ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z6SecUserId = A6SecUserId ;
         Z14SecUserName = A14SecUserName ;
         Z15SecUserPassword = A15SecUserPassword ;
         Z122SecUserEmail = A122SecUserEmail ;
         Z211SecUserEstadoR = A211SecUserEstadoR ;
      }
   }

   public void standaloneNotModal( )
   {
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7SecUserId) )
      {
         A6SecUserId = AV7SecUserId ;
         n6SecUserId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      }
   }

   public void standaloneModal( )
   {
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
      if ( isIns( )  && (GXutil.strcmp("", A211SecUserEstadoR)==0) && ( Gx_BScreen == 0 ) )
      {
         A211SecUserEstadoR = "A" ;
         httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load056( )
   {
      /* Using cursor T00054 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A14SecUserName = T00054_A14SecUserName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
         A15SecUserPassword = T00054_A15SecUserPassword[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A15SecUserPassword", A15SecUserPassword);
         A122SecUserEmail = T00054_A122SecUserEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A122SecUserEmail", A122SecUserEmail);
         A211SecUserEstadoR = T00054_A211SecUserEstadoR[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
         zm056( -6) ;
      }
      pr_default.close(2);
      onLoadActions056( ) ;
   }

   public void onLoadActions056( )
   {
      AV16Pgmname = "WWPBaseObjects.SecUser" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
   }

   public void checkExtendedTable056( )
   {
      nIsDirty_6 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV16Pgmname = "WWPBaseObjects.SecUser" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      if ( ! ( GxRegex.IsMatch(A122SecUserEmail,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Sec User Email no coincide con el patrón especificado", "OutOfRange", 1, "SECUSEREMAIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserEmail_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A211SecUserEstadoR, "A") == 0 ) || ( GXutil.strcmp(A211SecUserEstadoR, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sec User Estado R fuera de rango", "OutOfRange", 1, "SECUSERESTADOR");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSecUserEstadoR.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors056( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey056( )
   {
      /* Using cursor T00055 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound6 = (short)(1) ;
      }
      else
      {
         RcdFound6 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00053 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm056( 6) ;
         RcdFound6 = (short)(1) ;
         A6SecUserId = T00053_A6SecUserId[0] ;
         n6SecUserId = T00053_n6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         A14SecUserName = T00053_A14SecUserName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
         A15SecUserPassword = T00053_A15SecUserPassword[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A15SecUserPassword", A15SecUserPassword);
         A122SecUserEmail = T00053_A122SecUserEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A122SecUserEmail", A122SecUserEmail);
         A211SecUserEstadoR = T00053_A211SecUserEstadoR[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
         Z6SecUserId = A6SecUserId ;
         sMode6 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load056( ) ;
         if ( AnyError == 1 )
         {
            RcdFound6 = (short)(0) ;
            initializeNonKey056( ) ;
         }
         Gx_mode = sMode6 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound6 = (short)(0) ;
         initializeNonKey056( ) ;
         sMode6 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode6 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey056( ) ;
      if ( RcdFound6 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound6 = (short)(0) ;
      /* Using cursor T00056 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T00056_A6SecUserId[0] < A6SecUserId ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T00056_A6SecUserId[0] > A6SecUserId ) ) )
         {
            A6SecUserId = T00056_A6SecUserId[0] ;
            n6SecUserId = T00056_n6SecUserId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            RcdFound6 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound6 = (short)(0) ;
      /* Using cursor T00057 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T00057_A6SecUserId[0] > A6SecUserId ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T00057_A6SecUserId[0] < A6SecUserId ) ) )
         {
            A6SecUserId = T00057_A6SecUserId[0] ;
            n6SecUserId = T00057_n6SecUserId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            RcdFound6 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey056( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert056( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound6 == 1 )
         {
            if ( A6SecUserId != Z6SecUserId )
            {
               A6SecUserId = Z6SecUserId ;
               n6SecUserId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SECUSERID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecUserName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update056( ) ;
               GX_FocusControl = edtSecUserName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A6SecUserId != Z6SecUserId )
            {
               /* Insert record */
               GX_FocusControl = edtSecUserName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert056( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SECUSERID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecUserId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtSecUserName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert056( ) ;
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
      if ( A6SecUserId != Z6SecUserId )
      {
         A6SecUserId = Z6SecUserId ;
         n6SecUserId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecUserName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency056( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00052 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z14SecUserName, T00052_A14SecUserName[0]) != 0 ) || ( GXutil.strcmp(Z15SecUserPassword, T00052_A15SecUserPassword[0]) != 0 ) || ( GXutil.strcmp(Z122SecUserEmail, T00052_A122SecUserEmail[0]) != 0 ) || ( GXutil.strcmp(Z211SecUserEstadoR, T00052_A211SecUserEstadoR[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z14SecUserName, T00052_A14SecUserName[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserName");
               GXutil.writeLogRaw("Old: ",Z14SecUserName);
               GXutil.writeLogRaw("Current: ",T00052_A14SecUserName[0]);
            }
            if ( GXutil.strcmp(Z15SecUserPassword, T00052_A15SecUserPassword[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserPassword");
               GXutil.writeLogRaw("Old: ",Z15SecUserPassword);
               GXutil.writeLogRaw("Current: ",T00052_A15SecUserPassword[0]);
            }
            if ( GXutil.strcmp(Z122SecUserEmail, T00052_A122SecUserEmail[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserEmail");
               GXutil.writeLogRaw("Old: ",Z122SecUserEmail);
               GXutil.writeLogRaw("Current: ",T00052_A122SecUserEmail[0]);
            }
            if ( GXutil.strcmp(Z211SecUserEstadoR, T00052_A211SecUserEstadoR[0]) != 0 )
            {
               GXutil.writeLogln("wwpbaseobjects.secuser:[seudo value changed for attri]"+"SecUserEstadoR");
               GXutil.writeLogRaw("Old: ",Z211SecUserEstadoR);
               GXutil.writeLogRaw("Current: ",T00052_A211SecUserEstadoR[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecUser"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert056( )
   {
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable056( ) ;
      }
      if ( AnyError == 0 )
      {
         zm056( 0) ;
         checkOptimisticConcurrency056( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm056( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert056( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00058 */
                  pr_default.execute(6, new Object[] {A14SecUserName, A15SecUserPassword, A122SecUserEmail, A211SecUserEstadoR});
                  A6SecUserId = T00058_A6SecUserId[0] ;
                  n6SecUserId = T00058_n6SecUserId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption050( ) ;
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
            load056( ) ;
         }
         endLevel056( ) ;
      }
      closeExtendedTableCursors056( ) ;
   }

   public void update056( )
   {
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable056( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency056( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm056( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate056( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T00059 */
                  pr_default.execute(7, new Object[] {A14SecUserName, A15SecUserPassword, A122SecUserEmail, A211SecUserEstadoR, Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecUser"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate056( ) ;
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
         endLevel056( ) ;
      }
      closeExtendedTableCursors056( ) ;
   }

   public void deferredUpdate056( )
   {
   }

   public void delete( )
   {
      beforeValidate056( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency056( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls056( ) ;
         afterConfirm056( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete056( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000510 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
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
      sMode6 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel056( ) ;
      Gx_mode = sMode6 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls056( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "WWPBaseObjects.SecUser" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000511 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor T000512 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
         /* Using cursor T000513 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Laboratorio Usuarios"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T000514 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Usuarios"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T000515 */
         pr_default.execute(13, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sec User Role"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel056( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete056( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secuser");
         if ( AnyError == 0 )
         {
            confirmValues050( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secuser");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart056( )
   {
      /* Scan By routine */
      /* Using cursor T000516 */
      pr_default.execute(14);
      RcdFound6 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A6SecUserId = T000516_A6SecUserId[0] ;
         n6SecUserId = T000516_n6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext056( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound6 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound6 = (short)(1) ;
         A6SecUserId = T000516_A6SecUserId[0] ;
         n6SecUserId = T000516_n6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      }
   }

   public void scanEnd056( )
   {
      pr_default.close(14);
   }

   public void afterConfirm056( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert056( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate056( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete056( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete056( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate056( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes056( )
   {
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      edtSecUserName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Enabled), 5, 0), true);
      edtSecUserPassword_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserPassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserPassword_Enabled), 5, 0), true);
      edtSecUserEmail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserEmail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserEmail_Enabled), 5, 0), true);
      cmbSecUserEstadoR.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSecUserEstadoR.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSecUserEstadoR.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes056( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues050( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110321832", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.secuser", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecUserId,4,0))}, new String[] {"Gx_mode","SecUserId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"SecUser");
      forbiddenHiddens.add("SecUserId", localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("wwpbaseobjects\\secuser:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z6SecUserId", GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z14SecUserName", Z14SecUserName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z15SecUserPassword", Z15SecUserPassword);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z122SecUserEmail", Z122SecUserEmail);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z211SecUserEstadoR", GXutil.rtrim( Z211SecUserEstadoR));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECUSERID", GXutil.ltrim( localUtil.ntoc( AV7SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSECUSERID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7SecUserId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
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
      return formatLink("com.projectthani.wwpbaseobjects.secuser", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7SecUserId,4,0))}, new String[] {"Gx_mode","SecUserId"})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecUser" ;
   }

   public String getPgmdesc( )
   {
      return "User" ;
   }

   public void initializeNonKey056( )
   {
      A14SecUserName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
      A15SecUserPassword = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A15SecUserPassword", A15SecUserPassword);
      A122SecUserEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A122SecUserEmail", A122SecUserEmail);
      A211SecUserEstadoR = "A" ;
      httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
      Z14SecUserName = "" ;
      Z15SecUserPassword = "" ;
      Z122SecUserEmail = "" ;
      Z211SecUserEstadoR = "" ;
   }

   public void initAll056( )
   {
      A6SecUserId = (short)(0) ;
      n6SecUserId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      initializeNonKey056( ) ;
   }

   public void standaloneModalInsert( )
   {
      A211SecUserEstadoR = i211SecUserEstadoR ;
      httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110321844", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secuser.js", "?20225110321844", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtSecUserId_Internalname = "SECUSERID" ;
      edtSecUserName_Internalname = "SECUSERNAME" ;
      edtSecUserPassword_Internalname = "SECUSERPASSWORD" ;
      edtSecUserEmail_Internalname = "SECUSEREMAIL" ;
      cmbSecUserEstadoR.setInternalname( "SECUSERESTADOR" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( "User" );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbSecUserEstadoR.setJsonclick( "" );
      cmbSecUserEstadoR.setEnabled( 1 );
      edtSecUserEmail_Jsonclick = "" ;
      edtSecUserEmail_Enabled = 1 ;
      edtSecUserPassword_Jsonclick = "" ;
      edtSecUserPassword_Enabled = 1 ;
      edtSecUserName_Jsonclick = "" ;
      edtSecUserName_Enabled = 1 ;
      edtSecUserId_Jsonclick = "" ;
      edtSecUserId_Enabled = 0 ;
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
      cmbSecUserEstadoR.setName( "SECUSERESTADOR" );
      cmbSecUserEstadoR.setWebtags( "" );
      cmbSecUserEstadoR.addItem("A", "Activo", (short)(0));
      cmbSecUserEstadoR.addItem("I", "Inactivo", (short)(0));
      if ( cmbSecUserEstadoR.getItemCount() > 0 )
      {
         if ( (GXutil.strcmp("", A211SecUserEstadoR)==0) )
         {
            A211SecUserEstadoR = "A" ;
            httpContext.ajax_rsp_assign_attri("", false, "A211SecUserEstadoR", A211SecUserEstadoR);
         }
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

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7SecUserId',fld:'vSECUSERID',pic:'ZZZ9',hsh:true},{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12052',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SECUSERID","{handler:'valid_Secuserid',iparms:[]");
      setEventMetadata("VALID_SECUSERID",",oparms:[]}");
      setEventMetadata("VALID_SECUSEREMAIL","{handler:'valid_Secuseremail',iparms:[]");
      setEventMetadata("VALID_SECUSEREMAIL",",oparms:[]}");
      setEventMetadata("VALID_SECUSERESTADOR","{handler:'valid_Secuserestador',iparms:[]");
      setEventMetadata("VALID_SECUSERESTADOR",",oparms:[]}");
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
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z14SecUserName = "" ;
      Z15SecUserPassword = "" ;
      Z122SecUserEmail = "" ;
      Z211SecUserEstadoR = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A211SecUserEstadoR = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A14SecUserName = "" ;
      A15SecUserPassword = "" ;
      A122SecUserEmail = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV16Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode6 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV15WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV11TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      T00054_A6SecUserId = new short[1] ;
      T00054_n6SecUserId = new boolean[] {false} ;
      T00054_A14SecUserName = new String[] {""} ;
      T00054_A15SecUserPassword = new String[] {""} ;
      T00054_A122SecUserEmail = new String[] {""} ;
      T00054_A211SecUserEstadoR = new String[] {""} ;
      T00055_A6SecUserId = new short[1] ;
      T00055_n6SecUserId = new boolean[] {false} ;
      T00053_A6SecUserId = new short[1] ;
      T00053_n6SecUserId = new boolean[] {false} ;
      T00053_A14SecUserName = new String[] {""} ;
      T00053_A15SecUserPassword = new String[] {""} ;
      T00053_A122SecUserEmail = new String[] {""} ;
      T00053_A211SecUserEstadoR = new String[] {""} ;
      T00056_A6SecUserId = new short[1] ;
      T00056_n6SecUserId = new boolean[] {false} ;
      T00057_A6SecUserId = new short[1] ;
      T00057_n6SecUserId = new boolean[] {false} ;
      T00052_A6SecUserId = new short[1] ;
      T00052_n6SecUserId = new boolean[] {false} ;
      T00052_A14SecUserName = new String[] {""} ;
      T00052_A15SecUserPassword = new String[] {""} ;
      T00052_A122SecUserEmail = new String[] {""} ;
      T00052_A211SecUserEstadoR = new String[] {""} ;
      T00058_A6SecUserId = new short[1] ;
      T00058_n6SecUserId = new boolean[] {false} ;
      T000511_A20PacienteId = new int[1] ;
      T000512_A31ProfesionalId = new int[1] ;
      T000513_A40LaboratorioId = new short[1] ;
      T000513_A6SecUserId = new short[1] ;
      T000513_n6SecUserId = new boolean[] {false} ;
      T000514_A36DrogueriaId = new short[1] ;
      T000514_A6SecUserId = new short[1] ;
      T000514_n6SecUserId = new boolean[] {false} ;
      T000515_A6SecUserId = new short[1] ;
      T000515_n6SecUserId = new boolean[] {false} ;
      T000515_A4SecRoleId = new short[1] ;
      T000516_A6SecUserId = new short[1] ;
      T000516_n6SecUserId = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i211SecUserEstadoR = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secuser__default(),
         new Object[] {
             new Object[] {
            T00052_A6SecUserId, T00052_A14SecUserName, T00052_A15SecUserPassword, T00052_A122SecUserEmail, T00052_A211SecUserEstadoR
            }
            , new Object[] {
            T00053_A6SecUserId, T00053_A14SecUserName, T00053_A15SecUserPassword, T00053_A122SecUserEmail, T00053_A211SecUserEstadoR
            }
            , new Object[] {
            T00054_A6SecUserId, T00054_A14SecUserName, T00054_A15SecUserPassword, T00054_A122SecUserEmail, T00054_A211SecUserEstadoR
            }
            , new Object[] {
            T00055_A6SecUserId
            }
            , new Object[] {
            T00056_A6SecUserId
            }
            , new Object[] {
            T00057_A6SecUserId
            }
            , new Object[] {
            T00058_A6SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000511_A20PacienteId
            }
            , new Object[] {
            T000512_A31ProfesionalId
            }
            , new Object[] {
            T000513_A40LaboratorioId, T000513_A6SecUserId
            }
            , new Object[] {
            T000514_A36DrogueriaId, T000514_A6SecUserId
            }
            , new Object[] {
            T000515_A6SecUserId, T000515_A4SecRoleId
            }
            , new Object[] {
            T000516_A6SecUserId
            }
         }
      );
      Z211SecUserEstadoR = "A" ;
      A211SecUserEstadoR = "A" ;
      i211SecUserEstadoR = "A" ;
      AV16Pgmname = "WWPBaseObjects.SecUser" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7SecUserId ;
   private short Z6SecUserId ;
   private short AV7SecUserId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A6SecUserId ;
   private short RcdFound6 ;
   private short nIsDirty_6 ;
   private int trnEnded ;
   private int edtSecUserId_Enabled ;
   private int edtSecUserName_Enabled ;
   private int edtSecUserPassword_Enabled ;
   private int edtSecUserEmail_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z211SecUserEstadoR ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecUserName_Internalname ;
   private String A211SecUserEstadoR ;
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
   private String edtSecUserId_Internalname ;
   private String edtSecUserId_Jsonclick ;
   private String TempTags ;
   private String edtSecUserName_Jsonclick ;
   private String edtSecUserPassword_Internalname ;
   private String edtSecUserPassword_Jsonclick ;
   private String edtSecUserEmail_Internalname ;
   private String edtSecUserEmail_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV16Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode6 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String i211SecUserEstadoR ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n6SecUserId ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z14SecUserName ;
   private String Z15SecUserPassword ;
   private String Z122SecUserEmail ;
   private String A14SecUserName ;
   private String A15SecUserPassword ;
   private String A122SecUserEmail ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbSecUserEstadoR ;
   private IDataStoreProvider pr_default ;
   private short[] T00054_A6SecUserId ;
   private boolean[] T00054_n6SecUserId ;
   private String[] T00054_A14SecUserName ;
   private String[] T00054_A15SecUserPassword ;
   private String[] T00054_A122SecUserEmail ;
   private String[] T00054_A211SecUserEstadoR ;
   private short[] T00055_A6SecUserId ;
   private boolean[] T00055_n6SecUserId ;
   private short[] T00053_A6SecUserId ;
   private boolean[] T00053_n6SecUserId ;
   private String[] T00053_A14SecUserName ;
   private String[] T00053_A15SecUserPassword ;
   private String[] T00053_A122SecUserEmail ;
   private String[] T00053_A211SecUserEstadoR ;
   private short[] T00056_A6SecUserId ;
   private boolean[] T00056_n6SecUserId ;
   private short[] T00057_A6SecUserId ;
   private boolean[] T00057_n6SecUserId ;
   private short[] T00052_A6SecUserId ;
   private boolean[] T00052_n6SecUserId ;
   private String[] T00052_A14SecUserName ;
   private String[] T00052_A15SecUserPassword ;
   private String[] T00052_A122SecUserEmail ;
   private String[] T00052_A211SecUserEstadoR ;
   private short[] T00058_A6SecUserId ;
   private boolean[] T00058_n6SecUserId ;
   private int[] T000511_A20PacienteId ;
   private int[] T000512_A31ProfesionalId ;
   private short[] T000513_A40LaboratorioId ;
   private short[] T000513_A6SecUserId ;
   private boolean[] T000513_n6SecUserId ;
   private short[] T000514_A36DrogueriaId ;
   private short[] T000514_A6SecUserId ;
   private boolean[] T000514_n6SecUserId ;
   private short[] T000515_A6SecUserId ;
   private boolean[] T000515_n6SecUserId ;
   private short[] T000515_A4SecRoleId ;
   private short[] T000516_A6SecUserId ;
   private boolean[] T000516_n6SecUserId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV15WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class secuser__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00052", "SELECT [SecUserId], [SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR] FROM [SecUser] WITH (UPDLOCK) WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00053", "SELECT [SecUserId], [SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00054", "SELECT TM1.[SecUserId], TM1.[SecUserName], TM1.[SecUserPassword], TM1.[SecUserEmail], TM1.[SecUserEstadoR] FROM [SecUser] TM1 WHERE TM1.[SecUserId] = ? ORDER BY TM1.[SecUserId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00055", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00056", "SELECT TOP 1 [SecUserId] FROM [SecUser] WHERE ( [SecUserId] > ?) ORDER BY [SecUserId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00057", "SELECT TOP 1 [SecUserId] FROM [SecUser] WHERE ( [SecUserId] < ?) ORDER BY [SecUserId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00058", "INSERT INTO [SecUser]([SecUserName], [SecUserPassword], [SecUserEmail], [SecUserEstadoR]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T00059", "UPDATE [SecUser] SET [SecUserName]=?, [SecUserPassword]=?, [SecUserEmail]=?, [SecUserEstadoR]=?  WHERE [SecUserId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000510", "DELETE FROM [SecUser]  WHERE [SecUserId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000511", "SELECT TOP 1 [PacienteId] FROM [Paciente] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000512", "SELECT TOP 1 [ProfesionalId] FROM [Profesional] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000513", "SELECT TOP 1 [LaboratorioId], [SecUserId] FROM [LaboratorioLaboratorioUsuarios] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000514", "SELECT TOP 1 [DrogueriaId], [SecUserId] FROM [DrogueriaUsuarios] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000515", "SELECT TOP 1 [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000516", "SELECT [SecUserId] FROM [SecUser] ORDER BY [SecUserId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(5, ((Number) parms[5]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 12 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 13 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

