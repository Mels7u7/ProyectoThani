package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class workwithplusmasterpagev2_impl extends GXMasterPage
{
   public workwithplusmasterpagev2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public workwithplusmasterpagev2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( workwithplusmasterpagev2_impl.class ));
   }

   public workwithplusmasterpagev2_impl( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         pa382( ) ;
         if ( ! isAjaxCallMode( ) )
         {
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            ws382( ) ;
            if ( ! isAjaxCallMode( ) )
            {
               we382( ) ;
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         GXWebForm.addResponsiveMetaHeaders((getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getMeta());
         getDataAreaObject().renderHtmlHeaders();
      }
   }

   public void renderHtmlOpenForm( )
   {
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlOpenForm();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV16ProgramDescription, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINDEXTOADDITEMS_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV15IndexToAddItems), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vBOOKMARKSDATA_MPAGE", AV10BookmarksData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vBOOKMARKSDATA_MPAGE", AV10BookmarksData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vADMINAGDATA_MPAGE", AV18AdminAGData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vADMINAGDATA_MPAGE", AV18AdminAGData);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vDVELOP_MENU_MPAGE", AV23DVelop_Menu);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_MENU_MPAGE", AV23DVelop_Menu);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", true, "vDVELOP_MENU_USERDATA_MPAGE", AV6DVelop_Menu_UserData);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDVELOP_MENU_USERDATA_MPAGE", AV6DVelop_Menu_UserData);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROGRAMDESCRIPTION_MPAGE", AV16ProgramDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV16ProgramDescription, ""))));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vDOREFRESH_MPAGE", AV20DoRefresh);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vWCTABLENAME_MPAGE", AV21WCTableName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINDEXTOADDITEMS_MPAGE", GXutil.ltrim( localUtil.ntoc( AV15IndexToAddItems, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINDEXTOADDITEMS_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV15IndexToAddItems), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Icontype", GXutil.rtrim( Ddo_bookmarks_Icontype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Icon", GXutil.rtrim( Ddo_bookmarks_Icon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Tooltip", GXutil.rtrim( Ddo_bookmarks_Tooltip));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Cls", GXutil.rtrim( Ddo_bookmarks_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Titlecontrolalign", GXutil.rtrim( Ddo_bookmarks_Titlecontrolalign));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_ADMINAG_MPAGE_Caption", GXutil.rtrim( Ddo_adminag_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_ADMINAG_MPAGE_Cls", GXutil.rtrim( Ddo_adminag_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_ADMINAG_MPAGE_Titlecontrolalign", GXutil.rtrim( Ddo_adminag_Titlecontrolalign));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Searchserviceurl", GXutil.rtrim( Ucmenu_Searchserviceurl));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Searchminchars", GXutil.ltrim( localUtil.ntoc( Ucmenu_Searchminchars, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Searchhelperdescription", GXutil.rtrim( Ucmenu_Searchhelperdescription));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Sidebarmainclass", GXutil.rtrim( Ucmenu_Sidebarmainclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Scrollwidth", GXutil.ltrim( localUtil.ntoc( Ucmenu_Scrollwidth, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Scrollalwaysvisible", GXutil.booltostr( Ucmenu_Scrollalwaysvisible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENU_MPAGE_Hidescrollincompactmenu", GXutil.booltostr( Ucmenu_Hidescrollincompactmenu));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enablefixobjectfitcover", GXutil.booltostr( Wwputilities_Enablefixobjectfitcover));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus", GXutil.booltostr( Wwputilities_Enableupdaterowselectionstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect", GXutil.booltostr( Wwputilities_Enableconvertcombotobootstrapselect));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnresizing", GXutil.booltostr( Wwputilities_Allowcolumnresizing));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnreordering", GXutil.booltostr( Wwputilities_Allowcolumnreordering));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumndragging", GXutil.booltostr( Wwputilities_Allowcolumndragging));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WWPUTILITIES_MPAGE_Allowcolumnsrestore", GXutil.booltostr( Wwputilities_Allowcolumnsrestore));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_bookmarks_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vHTTPREQUEST_MPAGE_Baseurl", GXutil.rtrim( AV31Httprequest.getBaseURL()));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_ADMINAG_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_adminag_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FORM_MPAGE_Caption", GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_BOOKMARKS_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_bookmarks_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_ADMINAG_MPAGE_Activeeventkey", GXutil.rtrim( Ddo_adminag_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FORM_MPAGE_Caption", GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption()));
   }

   public void renderHtmlCloseForm382( )
   {
      sendCloseFormHiddens( ) ;
      sendSecurityToken(sPrefix);
      if ( ! isFullAjaxMode( ) )
      {
         getDataAreaObject().renderHtmlCloseForm();
      }
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/slimscroll/jquery.slimscroll.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/SidebarMenu/BootstrapSidebarMenuRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpagev2.js", "?20225110334784", false, true);
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.WorkWithPlusMasterPageV2" ;
   }

   public String getPgmdesc( )
   {
      return "Work With Plus Master Page V2" ;
   }

   public void wb380( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         renderHtmlHeaders( ) ;
         renderHtmlOpenForm( ) ;
         if ( ! ShowMPWhenPopUp( ) && httpContext.isPopUpObject( ) )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            /* Content placeholder */
            httpContext.writeText( "<div") ;
            com.projectthani.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
            httpContext.writeText( ">") ;
            if ( ! isFullAjaxMode( ) )
            {
               getDataAreaObject().renderHtmlContent();
            }
            httpContext.writeText( "</div>") ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
            wbLoad = true ;
            return  ;
         }
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainWhiteHeader", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "TableHeaderSidebarImage", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_11_382( true) ;
      }
      else
      {
         wb_table1_11_382( false) ;
      }
      return  ;
   }

   public void wb_table1_11_382e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "ShowMenuImageCellNotFixedRight page-content", "left", "top", "", "flex-grow:1;", "div");
         wb_table2_16_382( true) ;
      }
      else
      {
         wb_table2_16_382( false) ;
      }
      return  ;
   }

   public void wb_table2_16_382e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "CellHeaderBar hidden-xs", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableuserrole_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',true,'',0)\"" ;
         ClassString = bttBtnspanishlink_Class ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnspanishlink_Internalname, "", "ES", bttBtnspanishlink_Jsonclick, 5, "ES", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",true,"+"'"+"EDOSPANISHLINK_MPAGE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WorkWithPlusMasterPageV2.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',true,'',0)\"" ;
         ClassString = bttBtnenglishlink_Class ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnenglishlink_Internalname, "", "EN", bttBtnenglishlink_Jsonclick, 5, "EN", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",true,"+"'"+"EDOENGLISHLINK_MPAGE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\WorkWithPlusMasterPageV2.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_bookmarks.setProperty("IconType", Ddo_bookmarks_Icontype);
         ucDdo_bookmarks.setProperty("Icon", Ddo_bookmarks_Icon);
         ucDdo_bookmarks.setProperty("Caption", Ddo_bookmarks_Caption);
         ucDdo_bookmarks.setProperty("Cls", Ddo_bookmarks_Cls);
         ucDdo_bookmarks.setProperty("DropDownOptionsData", AV10BookmarksData);
         ucDdo_bookmarks.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_bookmarks_Internalname, "DDO_BOOKMARKS_MPAGEContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "MasterTopIconsCell", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_adminag.setProperty("Caption", Ddo_adminag_Caption);
         ucDdo_adminag.setProperty("Cls", Ddo_adminag_Cls);
         ucDdo_adminag.setProperty("DropDownOptionsData", AV18AdminAGData);
         ucDdo_adminag.render(context, "dvelop.gxbootstrap.ddoregular", Ddo_adminag_Internalname, "DDO_ADMINAG_MPAGEContainer");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcmenu.setProperty("SearchServiceUrl", Ucmenu_Searchserviceurl);
         ucUcmenu.setProperty("SearchMinChars", Ucmenu_Searchminchars);
         ucUcmenu.setProperty("SearchHelperDescription", Ucmenu_Searchhelperdescription);
         ucUcmenu.setProperty("SidebarMainClass", Ucmenu_Sidebarmainclass);
         ucUcmenu.setProperty("ScrollWidth", Ucmenu_Scrollwidth);
         ucUcmenu.setProperty("ScrollAlwaysVisible", Ucmenu_Scrollalwaysvisible);
         ucUcmenu.setProperty("HideScrollInCompactMenu", Ucmenu_Hidescrollincompactmenu);
         ucUcmenu.setProperty("SidebarMenuOptionsData", AV23DVelop_Menu);
         ucUcmenu.setProperty("SidebarMenuUserData", AV6DVelop_Menu_UserData);
         ucUcmenu.render(context, "dvelop.gxbootstrap.sidebarmenu", Ucmenu_Internalname, "UCMENU_MPAGEContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 page-content page-content-back-image CellTableContentWithFooter", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         /* Content placeholder */
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-content-placeholder");
         httpContext.writeText( ">") ;
         if ( ! isFullAjaxMode( ) )
         {
            getDataAreaObject().renderHtmlContent();
         }
         httpContext.writeText( "</div>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MasterFooterCellVMSidebarImage page-content", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablefooter_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "justify-content:flex-end;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockfooter_Internalname, "Thani - copyright", "", "", lblTextblockfooter_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "FooterText", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPageV2.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcmessage.render(context, "dvelop.dvmessage", Ucmessage_Internalname, "UCMESSAGE_MPAGEContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUctooltip.render(context, "dvelop.gxbootstrap.tooltip", Uctooltip_Internalname, "UCTOOLTIP_MPAGEContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucWwputilities.setProperty("EnableFixObjectFitCover", Wwputilities_Enablefixobjectfitcover);
         ucWwputilities.setProperty("EnableUpdateRowSelectionStatus", Wwputilities_Enableupdaterowselectionstatus);
         ucWwputilities.setProperty("EnableConvertComboToBootstrapSelect", Wwputilities_Enableconvertcombotobootstrapselect);
         ucWwputilities.setProperty("AllowColumnResizing", Wwputilities_Allowcolumnresizing);
         ucWwputilities.setProperty("AllowColumnReordering", Wwputilities_Allowcolumnreordering);
         ucWwputilities.setProperty("AllowColumnDragging", Wwputilities_Allowcolumndragging);
         ucWwputilities.setProperty("AllowColumnsRestore", Wwputilities_Allowcolumnsrestore);
         ucWwputilities.render(context, "dvelop.workwithplusutilities_f5", Wwputilities_Internalname, "WWPUTILITIES_MPAGEContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucWwpdatepicker.render(context, "wwp.datepicker", Wwpdatepicker_Internalname, "WWPDATEPICKER_MPAGEContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start382( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup380( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( getDataAreaObject().executeStartEvent() != 0 )
         {
            httpContext.setAjaxCallMode();
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void ws382( )
   {
      start382( ) ;
      evt382( ) ;
   }

   public void evt382( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
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
                     if ( GXutil.strcmp(sEvt, "RFR_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DDO_BOOKMARKS_MPAGE.ONOPTIONCLICKED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e11382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "DDO_ADMINAG_MPAGE.ONOPTIONCLICKED_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e12382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "START_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e13382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "DOSPANISHLINK_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoSpanishLink' */
                        e14382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "DOENGLISHLINK_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: 'DoEnglishLink' */
                        e15382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "REFRESH_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Refresh */
                        e16382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS_MPAGE.MASTER_REFRESHHEADER_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        e17382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "LOAD_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Load */
                        e18382 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER_MPAGE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! wbErr )
                        {
                           Rfr0gs = false ;
                           if ( ! Rfr0gs )
                           {
                           }
                           dynload_actions( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        dynload_actions( ) ;
                     }
                  }
                  else
                  {
                  }
               }
               if ( httpContext.wbHandled == 0 )
               {
                  getDataAreaObject().dispatchEvents();
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void we382( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseForm382( ) ;
         }
      }
   }

   public void pa382( )
   {
      if ( nDonePA == 0 )
      {
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf382( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rf382( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ShowMPWhenPopUp( ) || ! httpContext.isPopUpObject( ) )
      {
         /* Execute user event: Refresh */
         e16382 ();
         gxdyncontrolsrefreshing = true ;
         fix_multi_value_controls( ) ;
         gxdyncontrolsrefreshing = false ;
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Execute user event: Load */
         e18382 ();
         wb380( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
   }

   public void send_integrity_lvl_hashes382( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup380( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13382 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vBOOKMARKSDATA_MPAGE"), AV10BookmarksData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vADMINAGDATA_MPAGE"), AV18AdminAGData);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDVELOP_MENU_MPAGE"), AV23DVelop_Menu);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDVELOP_MENU_USERDATA_MPAGE"), AV6DVelop_Menu_UserData);
         /* Read saved values. */
         AV20DoRefresh = GXutil.strtobool( httpContext.cgiGet( "vDOREFRESH_MPAGE")) ;
         AV21WCTableName = httpContext.cgiGet( "vWCTABLENAME_MPAGE") ;
         Ddo_bookmarks_Icontype = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Icontype") ;
         Ddo_bookmarks_Icon = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Icon") ;
         Ddo_bookmarks_Tooltip = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Tooltip") ;
         Ddo_bookmarks_Cls = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Cls") ;
         Ddo_bookmarks_Titlecontrolalign = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Titlecontrolalign") ;
         Ddo_adminag_Caption = httpContext.cgiGet( "DDO_ADMINAG_MPAGE_Caption") ;
         Ddo_adminag_Cls = httpContext.cgiGet( "DDO_ADMINAG_MPAGE_Cls") ;
         Ddo_adminag_Titlecontrolalign = httpContext.cgiGet( "DDO_ADMINAG_MPAGE_Titlecontrolalign") ;
         Ucmenu_Searchserviceurl = httpContext.cgiGet( "UCMENU_MPAGE_Searchserviceurl") ;
         Ucmenu_Searchminchars = (int)(localUtil.ctol( httpContext.cgiGet( "UCMENU_MPAGE_Searchminchars"), ",", ".")) ;
         Ucmenu_Searchhelperdescription = httpContext.cgiGet( "UCMENU_MPAGE_Searchhelperdescription") ;
         Ucmenu_Sidebarmainclass = httpContext.cgiGet( "UCMENU_MPAGE_Sidebarmainclass") ;
         Ucmenu_Scrollwidth = (int)(localUtil.ctol( httpContext.cgiGet( "UCMENU_MPAGE_Scrollwidth"), ",", ".")) ;
         Ucmenu_Scrollalwaysvisible = GXutil.strtobool( httpContext.cgiGet( "UCMENU_MPAGE_Scrollalwaysvisible")) ;
         Ucmenu_Hidescrollincompactmenu = GXutil.strtobool( httpContext.cgiGet( "UCMENU_MPAGE_Hidescrollincompactmenu")) ;
         Wwputilities_Enablefixobjectfitcover = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enablefixobjectfitcover")) ;
         Wwputilities_Enableupdaterowselectionstatus = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableupdaterowselectionstatus")) ;
         Wwputilities_Enableconvertcombotobootstrapselect = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Enableconvertcombotobootstrapselect")) ;
         Wwputilities_Allowcolumnresizing = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnresizing")) ;
         Wwputilities_Allowcolumnreordering = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnreordering")) ;
         Wwputilities_Allowcolumndragging = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumndragging")) ;
         Wwputilities_Allowcolumnsrestore = GXutil.strtobool( httpContext.cgiGet( "WWPUTILITIES_MPAGE_Allowcolumnsrestore")) ;
         Ddo_bookmarks_Activeeventkey = httpContext.cgiGet( "DDO_BOOKMARKS_MPAGE_Activeeventkey") ;
         Ddo_adminag_Activeeventkey = httpContext.cgiGet( "DDO_ADMINAG_MPAGE_Activeeventkey") ;
         (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setCaption( httpContext.cgiGet( "FORM_MPAGE_Caption") );
         /* Read variables values. */
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
      e13382 ();
      if (returnInSub) return;
   }

   public void e13382( )
   {
      /* Start Routine */
      returnInSub = false ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setHeaderrawhtml( "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\""+httpContext.convertURL( context.getHttpContext().getImagePath( "cceab8ff-208f-4395-99fd-7fe799e0d69c", "", context.getHttpContext().getTheme( )))+"\">" );
      divLayoutmaintable_Class = "MainContainerWithFooter" ;
      httpContext.ajax_rsp_assign_prop("", true, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV5WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV5WWPContext = GXv_SdtWWPContext1[0] ;
      /* Using cursor H00382 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV5WWPContext.getgxTv_SdtWWPContext_Userid())});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6SecUserId = H00382_A6SecUserId[0] ;
         A4SecRoleId = H00382_A4SecRoleId[0] ;
         AV8SecRoleId = A4SecRoleId ;
         httpContext.ajax_rsp_assign_attri("", true, "AV8SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecRoleId), 4, 0));
         pr_default.readNext(0);
      }
      pr_default.close(0);
      GXt_objcol_SdtDVelop_Menu_Item2 = AV23DVelop_Menu ;
      GXv_objcol_SdtDVelop_Menu_Item3[0] = GXt_objcol_SdtDVelop_Menu_Item2 ;
      new com.projectthani.wwpbaseobjects.menuoptionsdata(remoteHandle, context).execute( AV8SecRoleId, GXv_objcol_SdtDVelop_Menu_Item3) ;
      GXt_objcol_SdtDVelop_Menu_Item2 = GXv_objcol_SdtDVelop_Menu_Item3[0] ;
      AV23DVelop_Menu = GXt_objcol_SdtDVelop_Menu_Item2 ;
      GXv_objcol_SdtDVelop_Menu_Item3[0] = AV23DVelop_Menu ;
      new com.projectthani.wwpbaseobjects.getmenuauthorizedoptions(remoteHandle, context).execute( GXv_objcol_SdtDVelop_Menu_Item3) ;
      AV23DVelop_Menu = GXv_objcol_SdtDVelop_Menu_Item3[0] ;
      AV10BookmarksData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV11BookmarksDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Bookmark Page" );
      AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-star FontIconTopRightActions" );
      AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "Dummy" );
      AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV10BookmarksData.add(AV11BookmarksDataItem, 0);
      AV18AdminAGData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV19AdminAGDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Cambiar contraseña" );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fa fa-lock FontIconTopRightActions" );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Link( formatLink("com.projectthani.wwpbaseobjects.secchangepassword", new String[] {}, new String[] {})  );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV18AdminAGData.add(AV19AdminAGDataItem, 0);
      AV19AdminAGDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Salir" );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-sign-out-alt FontIconTopRightActions" );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "ActionLogOut" );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV18AdminAGData.add(AV19AdminAGDataItem, 0);
      GXv_SdtWWPContext1[0] = AV5WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV5WWPContext = GXv_SdtWWPContext1[0] ;
      AV24UserName = AV5WWPContext.getgxTv_SdtWWPContext_Username() ;
      AV26RolesDescriptions = "" ;
      GXt_objcol_int4 = AV7SecRoleIdCollection ;
      GXv_objcol_int5[0] = GXt_objcol_int4 ;
      new com.projectthani.wwpbaseobjects.secgetrolesfromloggeduser(remoteHandle, context).execute( GXv_objcol_int5) ;
      GXt_objcol_int4 = GXv_objcol_int5[0] ;
      AV7SecRoleIdCollection = GXt_objcol_int4 ;
      AV38GXV1 = 1 ;
      while ( AV38GXV1 <= AV7SecRoleIdCollection.size() )
      {
         AV8SecRoleId = ((Number) AV7SecRoleIdCollection.elementAt(-1+AV38GXV1)).shortValue() ;
         httpContext.ajax_rsp_assign_attri("", true, "AV8SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8SecRoleId), 4, 0));
         if ( ! (GXutil.strcmp("", AV26RolesDescriptions)==0) )
         {
            AV26RolesDescriptions += ", " ;
         }
         /* Using cursor H00383 */
         pr_default.execute(1, new Object[] {Short.valueOf(AV8SecRoleId)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A4SecRoleId = H00383_A4SecRoleId[0] ;
            A13SecRoleName = H00383_A13SecRoleName[0] ;
            AV26RolesDescriptions += A13SecRoleName ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         AV38GXV1 = (int)(AV38GXV1+1) ;
      }
      AV6DVelop_Menu_UserData.setgxTv_SdtDVelop_Menu_UserData_Firstline( AV24UserName );
      AV6DVelop_Menu_UserData.setgxTv_SdtDVelop_Menu_UserData_Secondline( AV26RolesDescriptions );
      AV6DVelop_Menu_UserData.setgxTv_SdtDVelop_Menu_UserData_Photouri( httpContext.convertURL( context.getHttpContext().getImagePath( "3a2bb037-746f-4ca9-85b6-8a9333319398", "", context.getHttpContext().getTheme( ))) );
      Ddo_adminag_Titlecontrolalign = "Left" ;
      ucDdo_adminag.sendProperty(context, "", true, Ddo_adminag_Internalname, "TitleControlAlign", Ddo_adminag_Titlecontrolalign);
      AV25AdminAGDataIndex = (short)(1) ;
      AV19AdminAGDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( GXutil.format( "<li><div class=\"ddoMenuUserInfo\"><div class=\"UserImageCell\" style=\"\"><img src=\"%3\"></div><div class=\"UserInfoNameCell\"><span class=\"UserInfoName\">%1</span></div><div class=\"UserInfoRoleCell\"><span class=\"UserInfoRole\">%2</span></div></div></li>", AV24UserName, AV26RolesDescriptions, httpContext.convertURL( context.getHttpContext().getImagePath( "3a2bb037-746f-4ca9-85b6-8a9333319398", "", context.getHttpContext().getTheme( ))), "", "", "", "", "", "") );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "<#RawHTML#>" );
      AV19AdminAGDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV18AdminAGData.add(AV19AdminAGDataItem, AV25AdminAGDataIndex);
      GXv_char6[0] = AV27Language ;
      if ( new com.projectthani.wwpbaseobjects.wwp_loadlanguageandtheme(remoteHandle, context).executeUdp( GXv_char6) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      workwithplusmasterpagev2_impl.this.AV27Language = GXv_char6[0] ;
      if ( Cond_result )
      {
         httpContext.doAjaxRefresh();
      }
      bttBtnspanishlink_Class = "ButtonAsLink" ;
      httpContext.ajax_rsp_assign_prop("", true, bttBtnspanishlink_Internalname, "Class", bttBtnspanishlink_Class, true);
      bttBtnenglishlink_Class = "ButtonAsLink" ;
      httpContext.ajax_rsp_assign_prop("", true, bttBtnenglishlink_Internalname, "Class", bttBtnenglishlink_Class, true);
      if ( GXutil.strcmp(AV27Language, "Spanish") == 0 )
      {
         bttBtnspanishlink_Class = "ButtonAsLinkBold" ;
         httpContext.ajax_rsp_assign_prop("", true, bttBtnspanishlink_Internalname, "Class", bttBtnspanishlink_Class, true);
      }
      else if ( GXutil.strcmp(AV27Language, "English") == 0 )
      {
         bttBtnenglishlink_Class = "ButtonAsLinkBold" ;
         httpContext.ajax_rsp_assign_prop("", true, bttBtnenglishlink_Internalname, "Class", bttBtnenglishlink_Class, true);
      }
      Ddo_bookmarks_Tooltip = "Marcadores" ;
      ucDdo_bookmarks.sendProperty(context, "", true, Ddo_bookmarks_Internalname, "Tooltip", Ddo_bookmarks_Tooltip);
      Ddo_bookmarks_Titlecontrolalign = "Left" ;
      ucDdo_bookmarks.sendProperty(context, "", true, Ddo_bookmarks_Internalname, "TitleControlAlign", Ddo_bookmarks_Titlecontrolalign);
      if ( GXutil.strcmp(GXutil.lower( Contentholder.getPgmname()), "wwpbaseobjects.notauthorized") != 0 )
      {
         GXv_boolean7[0] = AV32IsAuthorized ;
         new com.projectthani.wwpbaseobjects.secisauthbyobjectname(remoteHandle, context).execute( Contentholder.getPgmname(), GXv_boolean7) ;
         workwithplusmasterpagev2_impl.this.AV32IsAuthorized = GXv_boolean7[0] ;
         if ( ! AV32IsAuthorized )
         {
            callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(Contentholder.getPgmname()))}, new String[] {"GxObject"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
   }

   public void e14382( )
   {
      /* 'DoSpanishLink' Routine */
      returnInSub = false ;
      if ( setLanguage( "Spanish") == 0 )
      {
         AV28WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
   }

   public void e15382( )
   {
      /* 'DoEnglishLink' Routine */
      returnInSub = false ;
      if ( setLanguage( "English") == 0 )
      {
         AV28WebSession.setValue("isLangLoaded", "true");
         httpContext.doAjaxRefresh();
      }
      /*  Sending Event outputs  */
   }

   public void e11382( )
   {
      /* Ddo_bookmarks_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_bookmarks_Activeeventkey, "Dummy") == 0 )
      {
         /* Execute user subroutine: 'DO DUMMY' */
         S112 ();
         if (returnInSub) return;
      }
      if ( GXutil.strcmp(Ddo_bookmarks_Activeeventkey, "AddBookmark") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.editbookmark", new String[] {GXutil.URLEncode(GXutil.rtrim(AV31Httprequest.getBaseURL()+AV31Httprequest.getScriptName())),GXutil.URLEncode(GXutil.rtrim(AV16ProgramDescription))}, new String[] {"InBookmarkURL","BookmarkPageDescription"}) , new Object[] {"","",});
      }
      else if ( GXutil.strcmp(Ddo_bookmarks_Activeeventkey, "ManageBookmarks") == 0 )
      {
         httpContext.popup(formatLink("com.projectthani.wwpbaseobjects.managefilters", new String[] {GXutil.URLEncode(GXutil.rtrim("AppBookmarks"))}, new String[] {"UserKey"}) , new Object[] {});
      }
      /*  Sending Event outputs  */
   }

   public void e12382( )
   {
      /* Ddo_adminag_Onoptionclicked Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Ddo_adminag_Activeeventkey, "ActionLogOut") == 0 )
      {
         /* Execute user subroutine: 'DO ACTIONLOGOUT' */
         S122 ();
         if (returnInSub) return;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", true, "AV5WWPContext", AV5WWPContext);
   }

   public void e16382( )
   {
      /* Refresh Routine */
      returnInSub = false ;
      lblTextblocktitle_Caption = (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getCaption() ;
      httpContext.ajax_rsp_assign_prop("", true, lblTextblocktitle_Internalname, "Caption", lblTextblocktitle_Caption, true);
      /* Execute user subroutine: 'LOADBOOKMARKS' */
      S132 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", true, "AV10BookmarksData", AV10BookmarksData);
   }

   public void e17382( )
   {
      /* GlobalEvents_Master_refreshheader Routine */
      returnInSub = false ;
      httpContext.doAjaxRefresh();
   }

   public void S112( )
   {
      /* 'DO DUMMY' Routine */
      returnInSub = false ;
   }

   public void S122( )
   {
      /* 'DO ACTIONLOGOUT' Routine */
      returnInSub = false ;
      AV5WWPContext = (com.projectthani.wwpbaseobjects.SdtWWPContext)new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      new com.projectthani.wwpbaseobjects.setwwpcontext(remoteHandle, context).execute( AV5WWPContext) ;
      AV28WebSession.clear();
      callWebObject(formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S132( )
   {
      /* 'LOADBOOKMARKS' Routine */
      returnInSub = false ;
      AV10BookmarksData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle) ;
      AV11BookmarksDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "AddBookmark" );
      AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
      AV10BookmarksData.add(AV11BookmarksDataItem, 0);
      AV16ProgramDescription = Contentholder.getPgmdesc() ;
      httpContext.ajax_rsp_assign_attri("", true, "AV16ProgramDescription", AV16ProgramDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV16ProgramDescription, ""))));
      AV12CurrentURL = AV31Httprequest.getBaseURL() + AV31Httprequest.getScriptName() ;
      AV13GridStateCollection.fromxml(new com.projectthani.wwpbaseobjects.loadmanagefiltersstate(remoteHandle, context).executeUdp( "AppBookmarks"), null, null);
      AV9BookmarkFound = false ;
      AV40GXV2 = 1 ;
      while ( AV40GXV2 <= AV13GridStateCollection.size() )
      {
         AV14GridStateCollectionItem = (com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)((com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV40GXV2));
         if ( GXutil.strcmp(AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV12CurrentURL) == 0 )
         {
            AV16ProgramDescription = AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title() ;
            httpContext.ajax_rsp_assign_attri("", true, "AV16ProgramDescription", AV16ProgramDescription);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROGRAMDESCRIPTION_MPAGE", getSecureSignedToken( "gxmpage_", GXutil.rtrim( localUtil.format( AV16ProgramDescription, ""))));
            AV9BookmarkFound = true ;
            if (true) break;
         }
         AV40GXV2 = (int)(AV40GXV2+1) ;
      }
      if ( AV9BookmarkFound )
      {
         this.executeUsercontrolMethod("", true, "DDO_BOOKMARKS_MPAGEContainer", "Update", "", new Object[] {"","fas fa-star "+"FontColorIconBookmarkTitleAdded"});
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Edit bookmark for this page" );
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-star "+"FontColorIconBookmarkAdded" );
      }
      else
      {
         this.executeUsercontrolMethod("", true, "DDO_BOOKMARKS_MPAGEContainer", "Update", "", new Object[] {"","far fa-star "+"FontColorIconBookmarkTitle"});
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Bookmark this page" );
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "far fa-star "+"FontColorIconBookmark" );
      }
      if ( AV13GridStateCollection.size() > 0 )
      {
         AV11BookmarksDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( true );
         AV10BookmarksData.add(AV11BookmarksDataItem, 0);
         AV41GXV3 = 1 ;
         while ( AV41GXV3 <= AV13GridStateCollection.size() )
         {
            AV14GridStateCollectionItem = (com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)((com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item)AV13GridStateCollection.elementAt(-1+AV41GXV3));
            AV11BookmarksDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
            AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Title() );
            AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Link( AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml() );
            GXt_char8 = AV17FontIcon ;
            GXv_char6[0] = GXt_char8 ;
            new com.projectthani.wwpbaseobjects.getbookmarkfonticon(remoteHandle, context).execute( GXutil.strReplace( AV14GridStateCollectionItem.getgxTv_SdtGridStateCollection_Item_Gridstatexml(), AV31Httprequest.getBaseURL(), ""), AV23DVelop_Menu, GXv_char6) ;
            workwithplusmasterpagev2_impl.this.GXt_char8 = GXv_char6[0] ;
            AV17FontIcon = GXt_char8 ;
            AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( ((GXutil.strcmp(AV17FontIcon, "")==0) ? "FontColorIconBookmark fas fa-link" : "FontColorIconBookmark"+" "+AV17FontIcon) );
            AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
            AV10BookmarksData.add(AV11BookmarksDataItem, 0);
            AV15IndexToAddItems = (short)(AV15IndexToAddItems+1) ;
            httpContext.ajax_rsp_assign_attri("", true, "AV15IndexToAddItems", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15IndexToAddItems), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vINDEXTOADDITEMS_MPAGE", getSecureSignedToken( "gxmpage_", localUtil.format( DecimalUtil.doubleToDec(AV15IndexToAddItems), "ZZZ9")));
            AV41GXV3 = (int)(AV41GXV3+1) ;
         }
         AV11BookmarksDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( true );
         AV10BookmarksData.add(AV11BookmarksDataItem, 0);
         AV11BookmarksDataItem = (com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item)new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Title( "Bookmark manager" );
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Fonticon( "fas fa-cog "+"FontColorIconBookmark" );
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Eventkey( "ManageBookmarks" );
         AV11BookmarksDataItem.setgxTv_SdtDVB_SDTDropDownOptionsData_Item_Isdivider( false );
         AV10BookmarksData.add(AV11BookmarksDataItem, 0);
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e18382( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   public void wb_table2_16_382( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUnnamedtable3_Internalname, tblUnnamedtable3_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblShowmenu_Internalname, "<i class=\"fas fa-bars FontIconMenu\"></i>", "", "", lblShowmenu_Jsonclick, "'"+""+"'"+",true,"+"'"+"e19381_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_WWPBaseObjects\\WorkWithPlusMasterPageV2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocktitle_Internalname, lblTextblocktitle_Caption, "", "", lblTextblocktitle_Jsonclick, "'"+""+"'"+",true,"+"'"+"E_MPAGE."+"'", "", "TextBlockTitleMaterial", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\WorkWithPlusMasterPageV2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_16_382e( true) ;
      }
      else
      {
         wb_table2_16_382e( false) ;
      }
   }

   public void wb_table1_11_382( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblUnnamedtable2_Internalname, tblUnnamedtable2_Internalname, "", "TableLogo page-content", 0, "", "", 0, 0, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td data-align=\"Center\"  style=\""+GXutil.CssPrettify( "text-align:-khtml-Center;text-align:-moz-Center;text-align:-webkit-Center")+"\">") ;
         /* Static images/pictures */
         ClassString = "ImageTopHeader" ;
         StyleString = "" ;
         sImgUrl = context.getHttpContext().getImagePath( "ded4713b-2c88-41c7-a077-c77fd296ec29", "", context.getHttpContext().getTheme( )) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgHeader_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 1, "", "", 0, 0, 0, "px", 0, "px", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", " "+"data-gx-image"+" ", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WWPBaseObjects\\WorkWithPlusMasterPageV2.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_11_382e( true) ;
      }
      else
      {
         wb_table1_11_382e( false) ;
      }
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
      pa382( ) ;
      ws382( ) ;
      we382( ) ;
      httpContext.setWrapped(false);
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

   public void master_styles( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/fontawesome_v5/css/fontawesome.min.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/fontawesome_v5/css/all.min.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).getJscriptsrc().item(idxLst)), "?20225110334931", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/workwithplusmasterpagev2.js", "?20225110334931", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/slimscroll/jquery.slimscroll.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/SidebarMenu/BootstrapSidebarMenuRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Tooltip/BootstrapTooltipRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Mask/jquery.mask.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/BootstrapSelect.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/WorkWithPlusUtilities/WorkWithPlusUtilitiesRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DatePicker/DatePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      imgHeader_Internalname = "HEADER_MPAGE" ;
      tblUnnamedtable2_Internalname = "UNNAMEDTABLE2_MPAGE" ;
      lblShowmenu_Internalname = "SHOWMENU_MPAGE" ;
      lblTextblocktitle_Internalname = "TEXTBLOCKTITLE_MPAGE" ;
      tblUnnamedtable3_Internalname = "UNNAMEDTABLE3_MPAGE" ;
      bttBtnspanishlink_Internalname = "BTNSPANISHLINK_MPAGE" ;
      bttBtnenglishlink_Internalname = "BTNENGLISHLINK_MPAGE" ;
      Ddo_bookmarks_Internalname = "DDO_BOOKMARKS_MPAGE" ;
      Ddo_adminag_Internalname = "DDO_ADMINAG_MPAGE" ;
      divTableuserrole_Internalname = "TABLEUSERROLE_MPAGE" ;
      divTableheader_Internalname = "TABLEHEADER_MPAGE" ;
      Ucmenu_Internalname = "UCMENU_MPAGE" ;
      divTablecontent_Internalname = "TABLECONTENT_MPAGE" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1_MPAGE" ;
      lblTextblockfooter_Internalname = "TEXTBLOCKFOOTER_MPAGE" ;
      divTablefooter_Internalname = "TABLEFOOTER_MPAGE" ;
      Ucmessage_Internalname = "UCMESSAGE_MPAGE" ;
      Uctooltip_Internalname = "UCTOOLTIP_MPAGE" ;
      Wwputilities_Internalname = "WWPUTILITIES_MPAGE" ;
      Wwpdatepicker_Internalname = "WWPDATEPICKER_MPAGE" ;
      divTablemain_Internalname = "TABLEMAIN_MPAGE" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE_MPAGE" ;
      (getDataAreaObject() == null ? Form : getDataAreaObject().getForm()).setInternalname( "FORM_MPAGE" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      lblTextblocktitle_Caption = " Title" ;
      bttBtnenglishlink_Class = "ButtonAsLink" ;
      bttBtnspanishlink_Class = "ButtonAsLink" ;
      divLayoutmaintable_Class = "Table" ;
      Wwputilities_Allowcolumnsrestore = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumndragging = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnreordering = GXutil.toBoolean( -1) ;
      Wwputilities_Allowcolumnresizing = GXutil.toBoolean( -1) ;
      Wwputilities_Enableconvertcombotobootstrapselect = GXutil.toBoolean( -1) ;
      Wwputilities_Enableupdaterowselectionstatus = GXutil.toBoolean( -1) ;
      Wwputilities_Enablefixobjectfitcover = GXutil.toBoolean( -1) ;
      Ucmenu_Hidescrollincompactmenu = GXutil.toBoolean( 0) ;
      Ucmenu_Scrollalwaysvisible = GXutil.toBoolean( -1) ;
      Ucmenu_Scrollwidth = 5 ;
      Ucmenu_Sidebarmainclass = "page-sidebar sidebar-fixed sidebar-back-image" ;
      Ucmenu_Searchhelperdescription = "WWP_SearchMenuOption" ;
      Ucmenu_Searchminchars = 0 ;
      Ucmenu_Searchserviceurl = "xxx" ;
      Ddo_adminag_Titlecontrolalign = "Automatic" ;
      Ddo_adminag_Cls = "DropDownOptionsNoBackHover" ;
      Ddo_bookmarks_Titlecontrolalign = "Automatic" ;
      Ddo_bookmarks_Cls = "DropDownOptionsNoBackHover" ;
      Ddo_bookmarks_Tooltip = "" ;
      Ddo_bookmarks_Icon = "far fa-star" ;
      Ddo_bookmarks_Icontype = "FontIcon" ;
      Contentholder.setDataArea(getDataAreaObject());
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH_MPAGE","{handler:'refresh',iparms:[{ctrl:'FORM_MPAGE',prop:'Caption'},{av:'AV31Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'},{av:'AV23DVelop_Menu',fld:'vDVELOP_MENU_MPAGE',pic:''},{av:'AV16ProgramDescription',fld:'vPROGRAMDESCRIPTION_MPAGE',pic:'',hsh:true},{av:'AV15IndexToAddItems',fld:'vINDEXTOADDITEMS_MPAGE',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH_MPAGE",",oparms:[{av:'lblTextblocktitle_Caption',ctrl:'TEXTBLOCKTITLE_MPAGE',prop:'Caption'},{av:'AV10BookmarksData',fld:'vBOOKMARKSDATA_MPAGE',pic:''},{av:'AV16ProgramDescription',fld:'vPROGRAMDESCRIPTION_MPAGE',pic:'',hsh:true},{av:'AV15IndexToAddItems',fld:'vINDEXTOADDITEMS_MPAGE',pic:'ZZZ9',hsh:true}]}");
      setEventMetadata("DOSPANISHLINK_MPAGE","{handler:'e14382',iparms:[]");
      setEventMetadata("DOSPANISHLINK_MPAGE",",oparms:[]}");
      setEventMetadata("DOENGLISHLINK_MPAGE","{handler:'e15382',iparms:[]");
      setEventMetadata("DOENGLISHLINK_MPAGE",",oparms:[]}");
      setEventMetadata("DDO_BOOKMARKS_MPAGE.ONOPTIONCLICKED_MPAGE","{handler:'e11382',iparms:[{av:'Ddo_bookmarks_Activeeventkey',ctrl:'DDO_BOOKMARKS_MPAGE',prop:'ActiveEventKey'},{av:'AV31Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'},{av:'AV16ProgramDescription',fld:'vPROGRAMDESCRIPTION_MPAGE',pic:'',hsh:true}]");
      setEventMetadata("DDO_BOOKMARKS_MPAGE.ONOPTIONCLICKED_MPAGE",",oparms:[{av:'AV31Httprequest.getBaseURL()',ctrl:'vHTTPREQUEST_MPAGE',prop:'Baseurl'}]}");
      setEventMetadata("DDO_ADMINAG_MPAGE.ONOPTIONCLICKED_MPAGE","{handler:'e12382',iparms:[{av:'Ddo_adminag_Activeeventkey',ctrl:'DDO_ADMINAG_MPAGE',prop:'ActiveEventKey'}]");
      setEventMetadata("DDO_ADMINAG_MPAGE.ONOPTIONCLICKED_MPAGE",",oparms:[{av:'AV5WWPContext',fld:'vWWPCONTEXT_MPAGE',pic:''}]}");
      setEventMetadata("DOSHOWMENU_MPAGE","{handler:'e19381',iparms:[]");
      setEventMetadata("DOSHOWMENU_MPAGE",",oparms:[]}");
      setEventMetadata("GLOBALEVENTS_MPAGE.MASTER_REFRESHHEADER_MPAGE","{handler:'e17382',iparms:[]");
      setEventMetadata("GLOBALEVENTS_MPAGE.MASTER_REFRESHHEADER_MPAGE",",oparms:[]}");
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
      Contentholder = new com.genexus.webpanels.GXDataAreaControl();
      Ddo_bookmarks_Activeeventkey = "" ;
      AV31Httprequest = httpContext.getHttpRequest();
      Ddo_adminag_Activeeventkey = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      AV16ProgramDescription = "" ;
      GXKey = "" ;
      AV10BookmarksData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV18AdminAGData = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item.class, "Item", "", remoteHandle);
      AV23DVelop_Menu = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item>(com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "ProjectThani", remoteHandle);
      AV6DVelop_Menu_UserData = new com.projectthani.wwpbaseobjects.SdtDVelop_Menu_UserData(remoteHandle, context);
      AV21WCTableName = "" ;
      Ddo_adminag_Caption = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnspanishlink_Jsonclick = "" ;
      bttBtnenglishlink_Jsonclick = "" ;
      ucDdo_bookmarks = new com.genexus.webpanels.GXUserControl();
      Ddo_bookmarks_Caption = "" ;
      ucDdo_adminag = new com.genexus.webpanels.GXUserControl();
      ucUcmenu = new com.genexus.webpanels.GXUserControl();
      lblTextblockfooter_Jsonclick = "" ;
      ucUcmessage = new com.genexus.webpanels.GXUserControl();
      ucUctooltip = new com.genexus.webpanels.GXUserControl();
      ucWwputilities = new com.genexus.webpanels.GXUserControl();
      ucWwpdatepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV5WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      scmdbuf = "" ;
      H00382_A6SecUserId = new short[1] ;
      H00382_A4SecRoleId = new short[1] ;
      GXt_objcol_SdtDVelop_Menu_Item2 = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item>(com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item.class, "Item", "ProjectThani", remoteHandle);
      GXv_objcol_SdtDVelop_Menu_Item3 = new GXBaseCollection[1] ;
      AV11BookmarksDataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      AV19AdminAGDataItem = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV24UserName = "" ;
      AV26RolesDescriptions = "" ;
      AV7SecRoleIdCollection = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXt_objcol_int4 = new GXSimpleCollection<Short>(Short.class, "internal", "");
      GXv_objcol_int5 = new GXSimpleCollection[1] ;
      H00383_A4SecRoleId = new short[1] ;
      H00383_A13SecRoleName = new String[] {""} ;
      A13SecRoleName = "" ;
      AV27Language = "" ;
      GXv_boolean7 = new boolean[1] ;
      AV28WebSession = httpContext.getWebSession();
      AV12CurrentURL = "" ;
      AV13GridStateCollection = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item>(com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item.class, "Item", "", remoteHandle);
      AV14GridStateCollectionItem = new com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item(remoteHandle, context);
      AV17FontIcon = "" ;
      GXt_char8 = "" ;
      GXv_char6 = new String[1] ;
      sStyleString = "" ;
      lblShowmenu_Jsonclick = "" ;
      lblTextblocktitle_Jsonclick = "" ;
      sImgUrl = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sDynURL = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.workwithplusmasterpagev2__default(),
         new Object[] {
             new Object[] {
            H00382_A6SecUserId, H00382_A4SecRoleId
            }
            , new Object[] {
            H00383_A4SecRoleId, H00383_A13SecRoleName
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GxWebError ;
   private byte nDonePA ;
   private byte nGotPars ;
   private byte nGXWrapped ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV15IndexToAddItems ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private short AV8SecRoleId ;
   private short AV25AdminAGDataIndex ;
   private int Ucmenu_Searchminchars ;
   private int Ucmenu_Scrollwidth ;
   private int AV38GXV1 ;
   private int AV40GXV2 ;
   private int AV41GXV3 ;
   private int idxLst ;
   private String Ddo_bookmarks_Activeeventkey ;
   private String Ddo_adminag_Activeeventkey ;
   private String GXKey ;
   private String Ddo_bookmarks_Icontype ;
   private String Ddo_bookmarks_Icon ;
   private String Ddo_bookmarks_Tooltip ;
   private String Ddo_bookmarks_Cls ;
   private String Ddo_bookmarks_Titlecontrolalign ;
   private String Ddo_adminag_Caption ;
   private String Ddo_adminag_Cls ;
   private String Ddo_adminag_Titlecontrolalign ;
   private String Ucmenu_Searchserviceurl ;
   private String Ucmenu_Searchhelperdescription ;
   private String Ucmenu_Sidebarmainclass ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTableheader_Internalname ;
   private String divTableuserrole_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String bttBtnspanishlink_Class ;
   private String StyleString ;
   private String bttBtnspanishlink_Internalname ;
   private String bttBtnspanishlink_Jsonclick ;
   private String bttBtnenglishlink_Class ;
   private String bttBtnenglishlink_Internalname ;
   private String bttBtnenglishlink_Jsonclick ;
   private String Ddo_bookmarks_Caption ;
   private String Ddo_bookmarks_Internalname ;
   private String Ddo_adminag_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String Ucmenu_Internalname ;
   private String divTablecontent_Internalname ;
   private String divTablefooter_Internalname ;
   private String lblTextblockfooter_Internalname ;
   private String lblTextblockfooter_Jsonclick ;
   private String Ucmessage_Internalname ;
   private String Uctooltip_Internalname ;
   private String Wwputilities_Internalname ;
   private String Wwpdatepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private String lblTextblocktitle_Caption ;
   private String lblTextblocktitle_Internalname ;
   private String GXt_char8 ;
   private String GXv_char6[] ;
   private String sStyleString ;
   private String tblUnnamedtable3_Internalname ;
   private String lblShowmenu_Internalname ;
   private String lblShowmenu_Jsonclick ;
   private String lblTextblocktitle_Jsonclick ;
   private String tblUnnamedtable2_Internalname ;
   private String sImgUrl ;
   private String imgHeader_Internalname ;
   private String sDynURL ;
   private boolean AV20DoRefresh ;
   private boolean Ucmenu_Scrollalwaysvisible ;
   private boolean Ucmenu_Hidescrollincompactmenu ;
   private boolean Wwputilities_Enablefixobjectfitcover ;
   private boolean Wwputilities_Enableupdaterowselectionstatus ;
   private boolean Wwputilities_Enableconvertcombotobootstrapselect ;
   private boolean Wwputilities_Allowcolumnresizing ;
   private boolean Wwputilities_Allowcolumnreordering ;
   private boolean Wwputilities_Allowcolumndragging ;
   private boolean Wwputilities_Allowcolumnsrestore ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean toggleJsOutput ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean AV32IsAuthorized ;
   private boolean GXv_boolean7[] ;
   private boolean AV9BookmarkFound ;
   private String AV16ProgramDescription ;
   private String AV21WCTableName ;
   private String AV24UserName ;
   private String AV26RolesDescriptions ;
   private String A13SecRoleName ;
   private String AV27Language ;
   private String AV12CurrentURL ;
   private String AV17FontIcon ;
   private GXSimpleCollection<Short> AV7SecRoleIdCollection ;
   private GXSimpleCollection<Short> GXt_objcol_int4 ;
   private GXSimpleCollection<Short> GXv_objcol_int5[] ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV31Httprequest ;
   private com.genexus.webpanels.GXUserControl ucDdo_bookmarks ;
   private com.genexus.webpanels.GXUserControl ucDdo_adminag ;
   private com.genexus.webpanels.GXUserControl ucUcmenu ;
   private com.genexus.webpanels.GXUserControl ucUcmessage ;
   private com.genexus.webpanels.GXUserControl ucUctooltip ;
   private com.genexus.webpanels.GXUserControl ucWwputilities ;
   private com.genexus.webpanels.GXUserControl ucWwpdatepicker ;
   private com.genexus.webpanels.GXDataAreaControl Contentholder ;
   private IDataStoreProvider pr_default ;
   private short[] H00382_A6SecUserId ;
   private short[] H00382_A4SecRoleId ;
   private short[] H00383_A4SecRoleId ;
   private String[] H00383_A13SecRoleName ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV28WebSession ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV10BookmarksData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item> AV18AdminAGData ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item> AV13GridStateCollection ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> AV23DVelop_Menu ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> GXt_objcol_SdtDVelop_Menu_Item2 ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVelop_Menu_Item> GXv_objcol_SdtDVelop_Menu_Item3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV5WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtDVelop_Menu_UserData AV6DVelop_Menu_UserData ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV11BookmarksDataItem ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsData_Item AV19AdminAGDataItem ;
   private com.projectthani.wwpbaseobjects.SdtGridStateCollection_Item AV14GridStateCollectionItem ;
}

final  class workwithplusmasterpagev2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00382", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00383", "SELECT [SecRoleId], [SecRoleName] FROM [SecRole] WHERE [SecRoleId] = ? ORDER BY [SecRoleId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
      }
   }

}

