package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class petitoriosubcateg_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_9") == 0 )
      {
         A49PetitorioCategId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioCategId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_9( A49PetitorioCategId) ;
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
            AV20PetitorioSubCategId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioSubCategId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20PetitorioSubCategId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPETITORIOSUBCATEGID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20PetitorioSubCategId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Petitorio Sub Categ", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPetitorioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public petitoriosubcateg_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public petitoriosubcateg_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitoriosubcateg_impl.class ));
   }

   public petitoriosubcateg_impl( int remoteHandle ,
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioSubCategId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioSubCategId_Internalname, "Categoría", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioSubCategId_Internalname, GXutil.ltrim( localUtil.ntoc( A48PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPetitorioSubCategId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioSubCategId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioSubCategId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_PetitorioSubCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedpetitoriocategid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpetitoriocategid_Internalname, "Petitorio Categ Id", "", "", lblTextblockpetitoriocategid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_PetitorioSubCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_petitoriocategid.setProperty("Caption", Combo_petitoriocategid_Caption);
      ucCombo_petitoriocategid.setProperty("Cls", Combo_petitoriocategid_Cls);
      ucCombo_petitoriocategid.setProperty("DataListProc", Combo_petitoriocategid_Datalistproc);
      ucCombo_petitoriocategid.setProperty("DataListProcParametersPrefix", Combo_petitoriocategid_Datalistprocparametersprefix);
      ucCombo_petitoriocategid.setProperty("EmptyItem", Combo_petitoriocategid_Emptyitem);
      ucCombo_petitoriocategid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_petitoriocategid.setProperty("DropDownOptionsData", AV14PetitorioCategId_Data);
      ucCombo_petitoriocategid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_petitoriocategid_Internalname, "COMBO_PETITORIOCATEGIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioCategId_Internalname, "Petitorio Categ Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioCategId_Internalname, GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioCategId_Jsonclick, 0, "Attribute", "", "", "", "", edtPetitorioCategId_Visible, edtPetitorioCategId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_PetitorioSubCateg.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioCategNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioCategNombre_Internalname, "Petitorio Categ Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPetitorioCategNombre_Internalname, A266PetitorioCategNombre, "", "", (short)(0), 1, edtPetitorioCategNombre_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_PetitorioSubCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioSubCategNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioSubCategNombre_Internalname, "Categ Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPetitorioSubCategNombre_Internalname, A265PetitorioSubCategNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", (short)(0), 1, edtPetitorioSubCategNombre_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_PetitorioSubCateg.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PetitorioSubCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PetitorioSubCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PetitorioSubCateg.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_petitoriocategid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombopetitoriocategid_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboPetitorioCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombopetitoriocategid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboPetitorioCategId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboPetitorioCategId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopetitoriocategid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopetitoriocategid_Visible, edtavCombopetitoriocategid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_PetitorioSubCateg.htm");
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
      e110X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPETITORIOCATEGID_DATA"), AV14PetitorioCategId_Data);
            /* Read saved values. */
            Z48PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( "Z48PetitorioSubCategId"), ",", ".")) ;
            Z265PetitorioSubCategNombre = httpContext.cgiGet( "Z265PetitorioSubCategNombre") ;
            Z49PetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "Z49PetitorioCategId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N49PetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "N49PetitorioCategId"), ",", ".")) ;
            AV20PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( "vPETITORIOSUBCATEGID"), ",", ".")) ;
            AV12Insert_PetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PETITORIOCATEGID"), ",", ".")) ;
            AV21Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_petitoriocategid_Objectcall = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Objectcall") ;
            Combo_petitoriocategid_Class = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Class") ;
            Combo_petitoriocategid_Icontype = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Icontype") ;
            Combo_petitoriocategid_Icon = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Icon") ;
            Combo_petitoriocategid_Caption = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Caption") ;
            Combo_petitoriocategid_Tooltip = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Tooltip") ;
            Combo_petitoriocategid_Cls = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Cls") ;
            Combo_petitoriocategid_Selectedvalue_set = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Selectedvalue_set") ;
            Combo_petitoriocategid_Selectedvalue_get = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Selectedvalue_get") ;
            Combo_petitoriocategid_Selectedtext_set = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Selectedtext_set") ;
            Combo_petitoriocategid_Selectedtext_get = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Selectedtext_get") ;
            Combo_petitoriocategid_Gamoauthtoken = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Gamoauthtoken") ;
            Combo_petitoriocategid_Ddointernalname = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Ddointernalname") ;
            Combo_petitoriocategid_Titlecontrolalign = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Titlecontrolalign") ;
            Combo_petitoriocategid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Dropdownoptionstype") ;
            Combo_petitoriocategid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Enabled")) ;
            Combo_petitoriocategid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Visible")) ;
            Combo_petitoriocategid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Titlecontrolidtoreplace") ;
            Combo_petitoriocategid_Datalisttype = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Datalisttype") ;
            Combo_petitoriocategid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Allowmultipleselection")) ;
            Combo_petitoriocategid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Datalistfixedvalues") ;
            Combo_petitoriocategid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Isgriditem")) ;
            Combo_petitoriocategid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Hasdescription")) ;
            Combo_petitoriocategid_Datalistproc = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Datalistproc") ;
            Combo_petitoriocategid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Datalistprocparametersprefix") ;
            Combo_petitoriocategid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_petitoriocategid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Includeonlyselectedoption")) ;
            Combo_petitoriocategid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Includeselectalloption")) ;
            Combo_petitoriocategid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Emptyitem")) ;
            Combo_petitoriocategid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Includeaddnewoption")) ;
            Combo_petitoriocategid_Htmltemplate = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Htmltemplate") ;
            Combo_petitoriocategid_Multiplevaluestype = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Multiplevaluestype") ;
            Combo_petitoriocategid_Loadingdata = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Loadingdata") ;
            Combo_petitoriocategid_Noresultsfound = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Noresultsfound") ;
            Combo_petitoriocategid_Emptyitemtext = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Emptyitemtext") ;
            Combo_petitoriocategid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Onlyselectedvalues") ;
            Combo_petitoriocategid_Selectalltext = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Selectalltext") ;
            Combo_petitoriocategid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Multiplevaluesseparator") ;
            Combo_petitoriocategid_Addnewoptiontext = httpContext.cgiGet( "COMBO_PETITORIOCATEGID_Addnewoptiontext") ;
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
            A48PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioSubCategId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPetitorioCategId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPetitorioCategId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PETITORIOCATEGID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPetitorioCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A49PetitorioCategId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
            }
            else
            {
               A49PetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioCategId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
            }
            A266PetitorioCategNombre = httpContext.cgiGet( edtPetitorioCategNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
            A265PetitorioSubCategNombre = httpContext.cgiGet( edtPetitorioSubCategNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A265PetitorioSubCategNombre", A265PetitorioSubCategNombre);
            AV19ComboPetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombopetitoriocategid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPetitorioCategId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"PetitorioSubCateg");
            A48PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioSubCategId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
            forbiddenHiddens.add("PetitorioSubCategId", localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A48PetitorioSubCategId != Z48PetitorioSubCategId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("petitoriosubcateg:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A48PetitorioSubCategId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioSubCategId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
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
                  sMode42 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode42 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound42 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0X0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PETITORIOSUBCATEGID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPetitorioSubCategId_Internalname ;
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
                        e110X2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120X2 ();
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
         e120X2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0X42( ) ;
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
         disableAttributes0X42( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopetitoriocategid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopetitoriocategid_Enabled), 5, 0), true);
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

   public void confirm_0X0( )
   {
      beforeValidate0X42( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0X42( ) ;
         }
         else
         {
            checkExtendedTable0X42( ) ;
            closeExtendedTableCursors0X42( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0X0( )
   {
   }

   public void e110X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtPetitorioCategId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioCategId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioCategId_Visible), 5, 0), true);
      AV19ComboPetitorioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPetitorioCategId), 4, 0));
      edtavCombopetitoriocategid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopetitoriocategid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopetitoriocategid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPETITORIOCATEGID' */
      S112 ();
      if ( returnInSub )
      {
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioSubCateg_Insert", GXv_boolean5) ;
         petitoriosubcateg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioSubCateg_Update", GXv_boolean5) ;
         petitoriosubcateg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorioSubCateg_Delete", GXv_boolean5) ;
         petitoriosubcateg_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV21Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV21Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV22GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GXV1), 8, 0));
         while ( AV22GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV22GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PetitorioCategId") == 0 )
            {
               AV12Insert_PetitorioCategId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_PetitorioCategId), 4, 0));
               if ( ! (0==AV12Insert_PetitorioCategId) )
               {
                  AV19ComboPetitorioCategId = AV12Insert_PetitorioCategId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPetitorioCategId), 4, 0));
                  Combo_petitoriocategid_Selectedvalue_set = GXutil.trim( GXutil.str( AV19ComboPetitorioCategId, 4, 0)) ;
                  ucCombo_petitoriocategid.sendProperty(context, "", false, Combo_petitoriocategid_Internalname, "SelectedValue_set", Combo_petitoriocategid_Selectedvalue_set);
                  GXt_char6 = AV18Combo_DataJson ;
                  GXv_char7[0] = AV16ComboSelectedValue ;
                  GXv_char8[0] = AV17ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.petitoriosubcategloaddvcombo(remoteHandle, context).execute( "PetitorioCategId", "GET", false, AV20PetitorioSubCategId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  petitoriosubcateg_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
                  petitoriosubcateg_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
                  petitoriosubcateg_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
                  AV18Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
                  Combo_petitoriocategid_Selectedtext_set = AV17ComboSelectedText ;
                  ucCombo_petitoriocategid.sendProperty(context, "", false, Combo_petitoriocategid_Internalname, "SelectedText_set", Combo_petitoriocategid_Selectedtext_set);
                  Combo_petitoriocategid_Enabled = false ;
                  ucCombo_petitoriocategid.sendProperty(context, "", false, Combo_petitoriocategid_Internalname, "Enabled", GXutil.booltostr( Combo_petitoriocategid_Enabled));
               }
            }
            AV22GXV1 = (int)(AV22GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22GXV1), 8, 0));
         }
      }
   }

   public void e120X2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.petitoriosubcategww", new String[] {}, new String[] {}) );
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

   public void S112( )
   {
      /* 'LOADCOMBOPETITORIOCATEGID' Routine */
      returnInSub = false ;
      GXt_char6 = AV18Combo_DataJson ;
      GXv_char9[0] = AV16ComboSelectedValue ;
      GXv_char8[0] = AV17ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.petitoriosubcategloaddvcombo(remoteHandle, context).execute( "PetitorioCategId", Gx_mode, false, AV20PetitorioSubCategId, "", GXv_char9, GXv_char8, GXv_char7) ;
      petitoriosubcateg_impl.this.AV16ComboSelectedValue = GXv_char9[0] ;
      petitoriosubcateg_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
      petitoriosubcateg_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
      AV18Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
      Combo_petitoriocategid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_petitoriocategid.sendProperty(context, "", false, Combo_petitoriocategid_Internalname, "SelectedValue_set", Combo_petitoriocategid_Selectedvalue_set);
      Combo_petitoriocategid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_petitoriocategid.sendProperty(context, "", false, Combo_petitoriocategid_Internalname, "SelectedText_set", Combo_petitoriocategid_Selectedtext_set);
      AV19ComboPetitorioCategId = (short)(GXutil.lval( AV16ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboPetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboPetitorioCategId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_petitoriocategid_Enabled = false ;
         ucCombo_petitoriocategid.sendProperty(context, "", false, Combo_petitoriocategid_Internalname, "Enabled", GXutil.booltostr( Combo_petitoriocategid_Enabled));
      }
   }

   public void zm0X42( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z265PetitorioSubCategNombre = T000X3_A265PetitorioSubCategNombre[0] ;
            Z49PetitorioCategId = T000X3_A49PetitorioCategId[0] ;
         }
         else
         {
            Z265PetitorioSubCategNombre = A265PetitorioSubCategNombre ;
            Z49PetitorioCategId = A49PetitorioCategId ;
         }
      }
      if ( GX_JID == -8 )
      {
         Z48PetitorioSubCategId = A48PetitorioSubCategId ;
         Z265PetitorioSubCategNombre = A265PetitorioSubCategNombre ;
         Z49PetitorioCategId = A49PetitorioCategId ;
         Z266PetitorioCategNombre = A266PetitorioCategNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      edtPetitorioSubCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Enabled), 5, 0), true);
      edtPetitorioSubCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV20PetitorioSubCategId) )
      {
         A48PetitorioSubCategId = AV20PetitorioSubCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_PetitorioCategId) )
      {
         edtPetitorioCategId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPetitorioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioCategId_Enabled), 5, 0), true);
      }
      else
      {
         edtPetitorioCategId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPetitorioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioCategId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_PetitorioCategId) )
      {
         A49PetitorioCategId = AV12Insert_PetitorioCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
      }
      else
      {
         A49PetitorioCategId = AV19ComboPetitorioCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
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
         AV21Pgmname = "PetitorioSubCateg" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
         /* Using cursor T000X4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A49PetitorioCategId)});
         A266PetitorioCategNombre = T000X4_A266PetitorioCategNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
         pr_default.close(2);
      }
   }

   public void load0X42( )
   {
      /* Using cursor T000X5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A266PetitorioCategNombre = T000X5_A266PetitorioCategNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
         A265PetitorioSubCategNombre = T000X5_A265PetitorioSubCategNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A265PetitorioSubCategNombre", A265PetitorioSubCategNombre);
         A49PetitorioCategId = T000X5_A49PetitorioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
         zm0X42( -8) ;
      }
      pr_default.close(3);
      onLoadActions0X42( ) ;
   }

   public void onLoadActions0X42( )
   {
      AV21Pgmname = "PetitorioSubCateg" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
   }

   public void checkExtendedTable0X42( )
   {
      nIsDirty_42 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV21Pgmname = "PetitorioSubCateg" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      /* Using cursor T000X4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A49PetitorioCategId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio Categ'.", "ForeignKeyNotFound", 1, "PETITORIOCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A266PetitorioCategNombre = T000X4_A266PetitorioCategNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
      pr_default.close(2);
   }

   public void closeExtendedTableCursors0X42( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_9( short A49PetitorioCategId )
   {
      /* Using cursor T000X6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A49PetitorioCategId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio Categ'.", "ForeignKeyNotFound", 1, "PETITORIOCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A266PetitorioCategNombre = T000X6_A266PetitorioCategNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A266PetitorioCategNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey0X42( )
   {
      /* Using cursor T000X7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound42 = (short)(1) ;
      }
      else
      {
         RcdFound42 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000X3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0X42( 8) ;
         RcdFound42 = (short)(1) ;
         A48PetitorioSubCategId = T000X3_A48PetitorioSubCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
         A265PetitorioSubCategNombre = T000X3_A265PetitorioSubCategNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A265PetitorioSubCategNombre", A265PetitorioSubCategNombre);
         A49PetitorioCategId = T000X3_A49PetitorioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
         Z48PetitorioSubCategId = A48PetitorioSubCategId ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0X42( ) ;
         if ( AnyError == 1 )
         {
            RcdFound42 = (short)(0) ;
            initializeNonKey0X42( ) ;
         }
         Gx_mode = sMode42 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound42 = (short)(0) ;
         initializeNonKey0X42( ) ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode42 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0X42( ) ;
      if ( RcdFound42 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound42 = (short)(0) ;
      /* Using cursor T000X8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T000X8_A48PetitorioSubCategId[0] < A48PetitorioSubCategId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T000X8_A48PetitorioSubCategId[0] > A48PetitorioSubCategId ) ) )
         {
            A48PetitorioSubCategId = T000X8_A48PetitorioSubCategId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
            RcdFound42 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound42 = (short)(0) ;
      /* Using cursor T000X9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000X9_A48PetitorioSubCategId[0] > A48PetitorioSubCategId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000X9_A48PetitorioSubCategId[0] < A48PetitorioSubCategId ) ) )
         {
            A48PetitorioSubCategId = T000X9_A48PetitorioSubCategId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
            RcdFound42 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0X42( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPetitorioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0X42( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound42 == 1 )
         {
            if ( A48PetitorioSubCategId != Z48PetitorioSubCategId )
            {
               A48PetitorioSubCategId = Z48PetitorioSubCategId ;
               httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PETITORIOSUBCATEGID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPetitorioSubCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPetitorioCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0X42( ) ;
               GX_FocusControl = edtPetitorioCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A48PetitorioSubCategId != Z48PetitorioSubCategId )
            {
               /* Insert record */
               GX_FocusControl = edtPetitorioCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0X42( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PETITORIOSUBCATEGID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPetitorioSubCategId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtPetitorioCategId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0X42( ) ;
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
      if ( A48PetitorioSubCategId != Z48PetitorioSubCategId )
      {
         A48PetitorioSubCategId = Z48PetitorioSubCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PETITORIOSUBCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioSubCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPetitorioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0X42( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000X2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PetitorioSubCateg"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z265PetitorioSubCategNombre, T000X2_A265PetitorioSubCategNombre[0]) != 0 ) || ( Z49PetitorioCategId != T000X2_A49PetitorioCategId[0] ) )
         {
            if ( GXutil.strcmp(Z265PetitorioSubCategNombre, T000X2_A265PetitorioSubCategNombre[0]) != 0 )
            {
               GXutil.writeLogln("petitoriosubcateg:[seudo value changed for attri]"+"PetitorioSubCategNombre");
               GXutil.writeLogRaw("Old: ",Z265PetitorioSubCategNombre);
               GXutil.writeLogRaw("Current: ",T000X2_A265PetitorioSubCategNombre[0]);
            }
            if ( Z49PetitorioCategId != T000X2_A49PetitorioCategId[0] )
            {
               GXutil.writeLogln("petitoriosubcateg:[seudo value changed for attri]"+"PetitorioCategId");
               GXutil.writeLogRaw("Old: ",Z49PetitorioCategId);
               GXutil.writeLogRaw("Current: ",T000X2_A49PetitorioCategId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PetitorioSubCateg"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0X42( )
   {
      beforeValidate0X42( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0X42( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0X42( 0) ;
         checkOptimisticConcurrency0X42( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0X42( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0X42( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000X10 */
                  pr_default.execute(8, new Object[] {A265PetitorioSubCategNombre, Short.valueOf(A49PetitorioCategId)});
                  A48PetitorioSubCategId = T000X10_A48PetitorioSubCategId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PetitorioSubCateg");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0X0( ) ;
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
            load0X42( ) ;
         }
         endLevel0X42( ) ;
      }
      closeExtendedTableCursors0X42( ) ;
   }

   public void update0X42( )
   {
      beforeValidate0X42( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0X42( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0X42( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0X42( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0X42( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000X11 */
                  pr_default.execute(9, new Object[] {A265PetitorioSubCategNombre, Short.valueOf(A49PetitorioCategId), Short.valueOf(A48PetitorioSubCategId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PetitorioSubCateg");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PetitorioSubCateg"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0X42( ) ;
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
         endLevel0X42( ) ;
      }
      closeExtendedTableCursors0X42( ) ;
   }

   public void deferredUpdate0X42( )
   {
   }

   public void delete( )
   {
      beforeValidate0X42( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0X42( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0X42( ) ;
         afterConfirm0X42( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0X42( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000X12 */
               pr_default.execute(10, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PetitorioSubCateg");
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
      sMode42 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0X42( ) ;
      Gx_mode = sMode42 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0X42( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV21Pgmname = "PetitorioSubCateg" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
         /* Using cursor T000X13 */
         pr_default.execute(11, new Object[] {Short.valueOf(A49PetitorioCategId)});
         A266PetitorioCategNombre = T000X13_A266PetitorioCategNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000X14 */
         pr_default.execute(12, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Petitorio"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void endLevel0X42( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0X42( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(11);
         Application.commitDataStores(context, remoteHandle, pr_default, "petitoriosubcateg");
         if ( AnyError == 0 )
         {
            confirmValues0X0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(11);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "petitoriosubcateg");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0X42( )
   {
      /* Scan By routine */
      /* Using cursor T000X15 */
      pr_default.execute(13);
      RcdFound42 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A48PetitorioSubCategId = T000X15_A48PetitorioSubCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0X42( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound42 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A48PetitorioSubCategId = T000X15_A48PetitorioSubCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
      }
   }

   public void scanEnd0X42( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0X42( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0X42( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0X42( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0X42( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0X42( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0X42( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0X42( )
   {
      edtPetitorioSubCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Enabled), 5, 0), true);
      edtPetitorioCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioCategId_Enabled), 5, 0), true);
      edtPetitorioCategNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioCategNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioCategNombre_Enabled), 5, 0), true);
      edtPetitorioSubCategNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategNombre_Enabled), 5, 0), true);
      edtavCombopetitoriocategid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopetitoriocategid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopetitoriocategid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0X42( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0X0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033359", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.petitoriosubcateg", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20PetitorioSubCategId,4,0))}, new String[] {"Gx_mode","PetitorioSubCategId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"PetitorioSubCateg");
      forbiddenHiddens.add("PetitorioSubCategId", localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("petitoriosubcateg:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z48PetitorioSubCategId", GXutil.ltrim( localUtil.ntoc( Z48PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z265PetitorioSubCategNombre", Z265PetitorioSubCategNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z49PetitorioCategId", GXutil.ltrim( localUtil.ntoc( Z49PetitorioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N49PetitorioCategId", GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ",", "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPETITORIOCATEGID_DATA", AV14PetitorioCategId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPETITORIOCATEGID_DATA", AV14PetitorioCategId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPETITORIOSUBCATEGID", GXutil.ltrim( localUtil.ntoc( AV20PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPETITORIOSUBCATEGID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20PetitorioSubCategId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PETITORIOCATEGID", GXutil.ltrim( localUtil.ntoc( AV12Insert_PetitorioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV21Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Objectcall", GXutil.rtrim( Combo_petitoriocategid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Cls", GXutil.rtrim( Combo_petitoriocategid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Selectedvalue_set", GXutil.rtrim( Combo_petitoriocategid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Selectedtext_set", GXutil.rtrim( Combo_petitoriocategid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Enabled", GXutil.booltostr( Combo_petitoriocategid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Datalistproc", GXutil.rtrim( Combo_petitoriocategid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Datalistprocparametersprefix", GXutil.rtrim( Combo_petitoriocategid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOCATEGID_Emptyitem", GXutil.booltostr( Combo_petitoriocategid_Emptyitem));
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
      return formatLink("com.projectthani.petitoriosubcateg", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20PetitorioSubCategId,4,0))}, new String[] {"Gx_mode","PetitorioSubCategId"})  ;
   }

   public String getPgmname( )
   {
      return "PetitorioSubCateg" ;
   }

   public String getPgmdesc( )
   {
      return "Petitorio Sub Categ" ;
   }

   public void initializeNonKey0X42( )
   {
      A49PetitorioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
      A266PetitorioCategNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
      A265PetitorioSubCategNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A265PetitorioSubCategNombre", A265PetitorioSubCategNombre);
      Z265PetitorioSubCategNombre = "" ;
      Z49PetitorioCategId = (short)(0) ;
   }

   public void initAll0X42( )
   {
      A48PetitorioSubCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
      initializeNonKey0X42( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033375", true, true);
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
      httpContext.AddJavascriptSource("petitoriosubcateg.js", "?2022511033376", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtPetitorioSubCategId_Internalname = "PETITORIOSUBCATEGID" ;
      lblTextblockpetitoriocategid_Internalname = "TEXTBLOCKPETITORIOCATEGID" ;
      Combo_petitoriocategid_Internalname = "COMBO_PETITORIOCATEGID" ;
      edtPetitorioCategId_Internalname = "PETITORIOCATEGID" ;
      divTablesplittedpetitoriocategid_Internalname = "TABLESPLITTEDPETITORIOCATEGID" ;
      edtPetitorioCategNombre_Internalname = "PETITORIOCATEGNOMBRE" ;
      edtPetitorioSubCategNombre_Internalname = "PETITORIOSUBCATEGNOMBRE" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombopetitoriocategid_Internalname = "vCOMBOPETITORIOCATEGID" ;
      divSectionattribute_petitoriocategid_Internalname = "SECTIONATTRIBUTE_PETITORIOCATEGID" ;
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
      Form.setCaption( "Petitorio Sub Categ" );
      edtavCombopetitoriocategid_Jsonclick = "" ;
      edtavCombopetitoriocategid_Enabled = 0 ;
      edtavCombopetitoriocategid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPetitorioSubCategNombre_Enabled = 1 ;
      edtPetitorioCategNombre_Enabled = 0 ;
      edtPetitorioCategId_Jsonclick = "" ;
      edtPetitorioCategId_Enabled = 1 ;
      edtPetitorioCategId_Visible = 1 ;
      Combo_petitoriocategid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_petitoriocategid_Datalistprocparametersprefix = " \"ComboName\": \"PetitorioCategId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PetitorioSubCategId\": 0" ;
      Combo_petitoriocategid_Datalistproc = "PetitorioSubCategLoadDVCombo" ;
      Combo_petitoriocategid_Cls = "ExtendedCombo Attribute" ;
      Combo_petitoriocategid_Caption = "" ;
      Combo_petitoriocategid_Enabled = GXutil.toBoolean( -1) ;
      edtPetitorioSubCategId_Jsonclick = "" ;
      edtPetitorioSubCategId_Enabled = 0 ;
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

   public void valid_Petitoriocategid( )
   {
      /* Using cursor T000X13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A49PetitorioCategId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio Categ'.", "ForeignKeyNotFound", 1, "PETITORIOCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioCategId_Internalname ;
      }
      A266PetitorioCategNombre = T000X13_A266PetitorioCategNombre[0] ;
      pr_default.close(11);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A266PetitorioCategNombre", A266PetitorioCategNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20PetitorioSubCategId',fld:'vPETITORIOSUBCATEGID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV20PetitorioSubCategId',fld:'vPETITORIOSUBCATEGID',pic:'ZZZ9',hsh:true},{av:'A48PetitorioSubCategId',fld:'PETITORIOSUBCATEGID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120X2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PETITORIOSUBCATEGID","{handler:'valid_Petitoriosubcategid',iparms:[]");
      setEventMetadata("VALID_PETITORIOSUBCATEGID",",oparms:[]}");
      setEventMetadata("VALID_PETITORIOCATEGID","{handler:'valid_Petitoriocategid',iparms:[{av:'A49PetitorioCategId',fld:'PETITORIOCATEGID',pic:'ZZZ9'},{av:'A266PetitorioCategNombre',fld:'PETITORIOCATEGNOMBRE',pic:''}]");
      setEventMetadata("VALID_PETITORIOCATEGID",",oparms:[{av:'A266PetitorioCategNombre',fld:'PETITORIOCATEGNOMBRE',pic:''}]}");
      setEventMetadata("VALIDV_COMBOPETITORIOCATEGID","{handler:'validv_Combopetitoriocategid',iparms:[]");
      setEventMetadata("VALIDV_COMBOPETITORIOCATEGID",",oparms:[]}");
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
      pr_default.close(11);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z265PetitorioSubCategNombre = "" ;
      Combo_petitoriocategid_Selectedvalue_get = "" ;
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
      lblTextblockpetitoriocategid_Jsonclick = "" ;
      ucCombo_petitoriocategid = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14PetitorioCategId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A266PetitorioCategNombre = "" ;
      A265PetitorioSubCategNombre = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV21Pgmname = "" ;
      Combo_petitoriocategid_Objectcall = "" ;
      Combo_petitoriocategid_Class = "" ;
      Combo_petitoriocategid_Icontype = "" ;
      Combo_petitoriocategid_Icon = "" ;
      Combo_petitoriocategid_Tooltip = "" ;
      Combo_petitoriocategid_Selectedvalue_set = "" ;
      Combo_petitoriocategid_Selectedtext_set = "" ;
      Combo_petitoriocategid_Selectedtext_get = "" ;
      Combo_petitoriocategid_Gamoauthtoken = "" ;
      Combo_petitoriocategid_Ddointernalname = "" ;
      Combo_petitoriocategid_Titlecontrolalign = "" ;
      Combo_petitoriocategid_Dropdownoptionstype = "" ;
      Combo_petitoriocategid_Titlecontrolidtoreplace = "" ;
      Combo_petitoriocategid_Datalisttype = "" ;
      Combo_petitoriocategid_Datalistfixedvalues = "" ;
      Combo_petitoriocategid_Htmltemplate = "" ;
      Combo_petitoriocategid_Multiplevaluestype = "" ;
      Combo_petitoriocategid_Loadingdata = "" ;
      Combo_petitoriocategid_Noresultsfound = "" ;
      Combo_petitoriocategid_Emptyitemtext = "" ;
      Combo_petitoriocategid_Onlyselectedvalues = "" ;
      Combo_petitoriocategid_Selectalltext = "" ;
      Combo_petitoriocategid_Multiplevaluesseparator = "" ;
      Combo_petitoriocategid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode42 = "" ;
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
      AV18Combo_DataJson = "" ;
      AV16ComboSelectedValue = "" ;
      AV17ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z266PetitorioCategNombre = "" ;
      T000X4_A266PetitorioCategNombre = new String[] {""} ;
      T000X5_A48PetitorioSubCategId = new short[1] ;
      T000X5_A266PetitorioCategNombre = new String[] {""} ;
      T000X5_A265PetitorioSubCategNombre = new String[] {""} ;
      T000X5_A49PetitorioCategId = new short[1] ;
      T000X6_A266PetitorioCategNombre = new String[] {""} ;
      T000X7_A48PetitorioSubCategId = new short[1] ;
      T000X3_A48PetitorioSubCategId = new short[1] ;
      T000X3_A265PetitorioSubCategNombre = new String[] {""} ;
      T000X3_A49PetitorioCategId = new short[1] ;
      T000X8_A48PetitorioSubCategId = new short[1] ;
      T000X9_A48PetitorioSubCategId = new short[1] ;
      T000X2_A48PetitorioSubCategId = new short[1] ;
      T000X2_A265PetitorioSubCategNombre = new String[] {""} ;
      T000X2_A49PetitorioCategId = new short[1] ;
      T000X10_A48PetitorioSubCategId = new short[1] ;
      T000X13_A266PetitorioCategNombre = new String[] {""} ;
      T000X14_A25PetitorioId = new short[1] ;
      T000X15_A48PetitorioSubCategId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitoriosubcateg__default(),
         new Object[] {
             new Object[] {
            T000X2_A48PetitorioSubCategId, T000X2_A265PetitorioSubCategNombre, T000X2_A49PetitorioCategId
            }
            , new Object[] {
            T000X3_A48PetitorioSubCategId, T000X3_A265PetitorioSubCategNombre, T000X3_A49PetitorioCategId
            }
            , new Object[] {
            T000X4_A266PetitorioCategNombre
            }
            , new Object[] {
            T000X5_A48PetitorioSubCategId, T000X5_A266PetitorioCategNombre, T000X5_A265PetitorioSubCategNombre, T000X5_A49PetitorioCategId
            }
            , new Object[] {
            T000X6_A266PetitorioCategNombre
            }
            , new Object[] {
            T000X7_A48PetitorioSubCategId
            }
            , new Object[] {
            T000X8_A48PetitorioSubCategId
            }
            , new Object[] {
            T000X9_A48PetitorioSubCategId
            }
            , new Object[] {
            T000X10_A48PetitorioSubCategId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000X13_A266PetitorioCategNombre
            }
            , new Object[] {
            T000X14_A25PetitorioId
            }
            , new Object[] {
            T000X15_A48PetitorioSubCategId
            }
         }
      );
      AV21Pgmname = "PetitorioSubCateg" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV20PetitorioSubCategId ;
   private short Z48PetitorioSubCategId ;
   private short Z49PetitorioCategId ;
   private short N49PetitorioCategId ;
   private short A49PetitorioCategId ;
   private short AV20PetitorioSubCategId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A48PetitorioSubCategId ;
   private short AV19ComboPetitorioCategId ;
   private short AV12Insert_PetitorioCategId ;
   private short RcdFound42 ;
   private short nIsDirty_42 ;
   private int trnEnded ;
   private int edtPetitorioSubCategId_Enabled ;
   private int edtPetitorioCategId_Visible ;
   private int edtPetitorioCategId_Enabled ;
   private int edtPetitorioCategNombre_Enabled ;
   private int edtPetitorioSubCategNombre_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombopetitoriocategid_Enabled ;
   private int edtavCombopetitoriocategid_Visible ;
   private int Combo_petitoriocategid_Datalistupdateminimumcharacters ;
   private int AV22GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_petitoriocategid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPetitorioCategId_Internalname ;
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
   private String edtPetitorioSubCategId_Internalname ;
   private String edtPetitorioSubCategId_Jsonclick ;
   private String divTablesplittedpetitoriocategid_Internalname ;
   private String lblTextblockpetitoriocategid_Internalname ;
   private String lblTextblockpetitoriocategid_Jsonclick ;
   private String Combo_petitoriocategid_Caption ;
   private String Combo_petitoriocategid_Cls ;
   private String Combo_petitoriocategid_Datalistproc ;
   private String Combo_petitoriocategid_Datalistprocparametersprefix ;
   private String Combo_petitoriocategid_Internalname ;
   private String TempTags ;
   private String edtPetitorioCategId_Jsonclick ;
   private String edtPetitorioCategNombre_Internalname ;
   private String edtPetitorioSubCategNombre_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_petitoriocategid_Internalname ;
   private String edtavCombopetitoriocategid_Internalname ;
   private String edtavCombopetitoriocategid_Jsonclick ;
   private String AV21Pgmname ;
   private String Combo_petitoriocategid_Objectcall ;
   private String Combo_petitoriocategid_Class ;
   private String Combo_petitoriocategid_Icontype ;
   private String Combo_petitoriocategid_Icon ;
   private String Combo_petitoriocategid_Tooltip ;
   private String Combo_petitoriocategid_Selectedvalue_set ;
   private String Combo_petitoriocategid_Selectedtext_set ;
   private String Combo_petitoriocategid_Selectedtext_get ;
   private String Combo_petitoriocategid_Gamoauthtoken ;
   private String Combo_petitoriocategid_Ddointernalname ;
   private String Combo_petitoriocategid_Titlecontrolalign ;
   private String Combo_petitoriocategid_Dropdownoptionstype ;
   private String Combo_petitoriocategid_Titlecontrolidtoreplace ;
   private String Combo_petitoriocategid_Datalisttype ;
   private String Combo_petitoriocategid_Datalistfixedvalues ;
   private String Combo_petitoriocategid_Htmltemplate ;
   private String Combo_petitoriocategid_Multiplevaluestype ;
   private String Combo_petitoriocategid_Loadingdata ;
   private String Combo_petitoriocategid_Noresultsfound ;
   private String Combo_petitoriocategid_Emptyitemtext ;
   private String Combo_petitoriocategid_Onlyselectedvalues ;
   private String Combo_petitoriocategid_Selectalltext ;
   private String Combo_petitoriocategid_Multiplevaluesseparator ;
   private String Combo_petitoriocategid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode42 ;
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
   private boolean Combo_petitoriocategid_Emptyitem ;
   private boolean Combo_petitoriocategid_Enabled ;
   private boolean Combo_petitoriocategid_Visible ;
   private boolean Combo_petitoriocategid_Allowmultipleselection ;
   private boolean Combo_petitoriocategid_Isgriditem ;
   private boolean Combo_petitoriocategid_Hasdescription ;
   private boolean Combo_petitoriocategid_Includeonlyselectedoption ;
   private boolean Combo_petitoriocategid_Includeselectalloption ;
   private boolean Combo_petitoriocategid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private String AV18Combo_DataJson ;
   private String Z265PetitorioSubCategNombre ;
   private String A266PetitorioCategNombre ;
   private String A265PetitorioSubCategNombre ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private String Z266PetitorioCategNombre ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_petitoriocategid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T000X4_A266PetitorioCategNombre ;
   private short[] T000X5_A48PetitorioSubCategId ;
   private String[] T000X5_A266PetitorioCategNombre ;
   private String[] T000X5_A265PetitorioSubCategNombre ;
   private short[] T000X5_A49PetitorioCategId ;
   private String[] T000X6_A266PetitorioCategNombre ;
   private short[] T000X7_A48PetitorioSubCategId ;
   private short[] T000X3_A48PetitorioSubCategId ;
   private String[] T000X3_A265PetitorioSubCategNombre ;
   private short[] T000X3_A49PetitorioCategId ;
   private short[] T000X8_A48PetitorioSubCategId ;
   private short[] T000X9_A48PetitorioSubCategId ;
   private short[] T000X2_A48PetitorioSubCategId ;
   private String[] T000X2_A265PetitorioSubCategNombre ;
   private short[] T000X2_A49PetitorioCategId ;
   private short[] T000X10_A48PetitorioSubCategId ;
   private String[] T000X13_A266PetitorioCategNombre ;
   private short[] T000X14_A25PetitorioId ;
   private short[] T000X15_A48PetitorioSubCategId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14PetitorioCategId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class petitoriosubcateg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000X2", "SELECT [PetitorioSubCategId], [PetitorioSubCategNombre], [PetitorioCategId] FROM [PetitorioSubCateg] WITH (UPDLOCK) WHERE [PetitorioSubCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X3", "SELECT [PetitorioSubCategId], [PetitorioSubCategNombre], [PetitorioCategId] FROM [PetitorioSubCateg] WHERE [PetitorioSubCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X4", "SELECT [PetitorioCategNombre] FROM [PetitorioCateg] WHERE [PetitorioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X5", "SELECT TM1.[PetitorioSubCategId], T2.[PetitorioCategNombre], TM1.[PetitorioSubCategNombre], TM1.[PetitorioCategId] FROM ([PetitorioSubCateg] TM1 INNER JOIN [PetitorioCateg] T2 ON T2.[PetitorioCategId] = TM1.[PetitorioCategId]) WHERE TM1.[PetitorioSubCategId] = ? ORDER BY TM1.[PetitorioSubCategId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X6", "SELECT [PetitorioCategNombre] FROM [PetitorioCateg] WHERE [PetitorioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X7", "SELECT [PetitorioSubCategId] FROM [PetitorioSubCateg] WHERE [PetitorioSubCategId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X8", "SELECT TOP 1 [PetitorioSubCategId] FROM [PetitorioSubCateg] WHERE ( [PetitorioSubCategId] > ?) ORDER BY [PetitorioSubCategId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000X9", "SELECT TOP 1 [PetitorioSubCategId] FROM [PetitorioSubCateg] WHERE ( [PetitorioSubCategId] < ?) ORDER BY [PetitorioSubCategId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000X10", "INSERT INTO [PetitorioSubCateg]([PetitorioSubCategNombre], [PetitorioCategId]) VALUES(?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000X11", "UPDATE [PetitorioSubCateg] SET [PetitorioSubCategNombre]=?, [PetitorioCategId]=?  WHERE [PetitorioSubCategId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000X12", "DELETE FROM [PetitorioSubCateg]  WHERE [PetitorioSubCategId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000X13", "SELECT [PetitorioCategNombre] FROM [PetitorioCateg] WHERE [PetitorioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000X14", "SELECT TOP 1 [PetitorioId] FROM [Petitorio] WHERE [PetitorioSubCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000X15", "SELECT [PetitorioSubCategId] FROM [PetitorioSubCateg] ORDER BY [PetitorioSubCategId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
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
               stmt.setVarchar(1, (String)parms[0], 200, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 200, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

