package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class petitorio_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_15") == 0 )
      {
         A36DrogueriaId = (short)(GXutil.lval( httpContext.GetPar( "DrogueriaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_15( A36DrogueriaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A48PetitorioSubCategId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioSubCategId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A48PetitorioSubCategId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A39FormaFarmaceuticaId = (short)(GXutil.lval( httpContext.GetPar( "FormaFarmaceuticaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A39FormaFarmaceuticaId) ;
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
            AV26PetitorioId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26PetitorioId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPETITORIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26PetitorioId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Petitorio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtDrogueriaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public petitorio_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public petitorio_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( petitorio_impl.class ));
   }

   public petitorio_impl( int remoteHandle ,
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioId_Internalname, GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPetitorioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplitteddrogueriaid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockdrogueriaid_Internalname, "Drogueria Id", "", "", lblTextblockdrogueriaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_drogueriaid.setProperty("Caption", Combo_drogueriaid_Caption);
      ucCombo_drogueriaid.setProperty("Cls", Combo_drogueriaid_Cls);
      ucCombo_drogueriaid.setProperty("DataListProc", Combo_drogueriaid_Datalistproc);
      ucCombo_drogueriaid.setProperty("DataListProcParametersPrefix", Combo_drogueriaid_Datalistprocparametersprefix);
      ucCombo_drogueriaid.setProperty("EmptyItem", Combo_drogueriaid_Emptyitem);
      ucCombo_drogueriaid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_drogueriaid.setProperty("DropDownOptionsData", AV16DrogueriaId_Data);
      ucCombo_drogueriaid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_drogueriaid_Internalname, "COMBO_DROGUERIAIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDrogueriaId_Internalname, "Drogueria Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDrogueriaId_Internalname, GXutil.ltrim( localUtil.ntoc( A36DrogueriaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDrogueriaId_Jsonclick, 0, "Attribute", "", "", "", "", edtDrogueriaId_Visible, edtDrogueriaId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Petitorio.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioPrincipioActivo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioPrincipioActivo_Internalname, "Principio Activo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPetitorioPrincipioActivo_Internalname, A262PetitorioPrincipioActivo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtPetitorioPrincipioActivo_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioProducto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioProducto_Internalname, "Producto", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioProducto_Internalname, A263PetitorioProducto, GXutil.rtrim( localUtil.format( A263PetitorioProducto, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioProducto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioProducto_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioCategId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioCategId_Internalname, "Petitorio Categ Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioCategId_Internalname, GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPetitorioCategId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A49PetitorioCategId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioCategId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioCategId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedpetitoriosubcategid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpetitoriosubcategid_Internalname, "Sub Categoría", "", "", lblTextblockpetitoriosubcategid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_petitoriosubcategid.setProperty("Caption", Combo_petitoriosubcategid_Caption);
      ucCombo_petitoriosubcategid.setProperty("Cls", Combo_petitoriosubcategid_Cls);
      ucCombo_petitoriosubcategid.setProperty("DataListProc", Combo_petitoriosubcategid_Datalistproc);
      ucCombo_petitoriosubcategid.setProperty("DataListProcParametersPrefix", Combo_petitoriosubcategid_Datalistprocparametersprefix);
      ucCombo_petitoriosubcategid.setProperty("EmptyItem", Combo_petitoriosubcategid_Emptyitem);
      ucCombo_petitoriosubcategid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_petitoriosubcategid.setProperty("DropDownOptionsData", AV22PetitorioSubCategId_Data);
      ucCombo_petitoriosubcategid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_petitoriosubcategid_Internalname, "COMBO_PETITORIOSUBCATEGIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioSubCategId_Internalname, "Sub Categoría", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioSubCategId_Internalname, GXutil.ltrim( localUtil.ntoc( A48PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A48PetitorioSubCategId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioSubCategId_Jsonclick, 0, "Attribute", "", "", "", "", edtPetitorioSubCategId_Visible, edtPetitorioSubCategId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Petitorio.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioConcentracion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioConcentracion_Internalname, "Concentracion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioConcentracion_Internalname, A260PetitorioConcentracion, GXutil.rtrim( localUtil.format( A260PetitorioConcentracion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioConcentracion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioConcentracion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedformafarmaceuticaid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockformafarmaceuticaid_Internalname, "Forma Farmaceutica", "", "", lblTextblockformafarmaceuticaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_formafarmaceuticaid.setProperty("Caption", Combo_formafarmaceuticaid_Caption);
      ucCombo_formafarmaceuticaid.setProperty("Cls", Combo_formafarmaceuticaid_Cls);
      ucCombo_formafarmaceuticaid.setProperty("DataListProc", Combo_formafarmaceuticaid_Datalistproc);
      ucCombo_formafarmaceuticaid.setProperty("DataListProcParametersPrefix", Combo_formafarmaceuticaid_Datalistprocparametersprefix);
      ucCombo_formafarmaceuticaid.setProperty("EmptyItem", Combo_formafarmaceuticaid_Emptyitem);
      ucCombo_formafarmaceuticaid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_formafarmaceuticaid.setProperty("DropDownOptionsData", AV24FormaFarmaceuticaId_Data);
      ucCombo_formafarmaceuticaid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_formafarmaceuticaid_Internalname, "COMBO_FORMAFARMACEUTICAIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtFormaFarmaceuticaId_Internalname, "Forma Farmaceutica", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtFormaFarmaceuticaId_Internalname, GXutil.ltrim( localUtil.ntoc( A39FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,75);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFormaFarmaceuticaId_Jsonclick, 0, "Attribute", "", "", "", "", edtFormaFarmaceuticaId_Visible, edtFormaFarmaceuticaId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Petitorio.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioPresentacion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioPresentacion_Internalname, "Presentacion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioPresentacion_Internalname, A261PetitorioPresentacion, GXutil.rtrim( localUtil.format( A261PetitorioPresentacion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,80);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioPresentacion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioPresentacion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioPrecio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioPrecio_Internalname, "Precio", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioPrecio_Internalname, GXutil.ltrim( localUtil.ntoc( A264PetitorioPrecio, (byte)(7), (byte)(2), ",", "")), GXutil.ltrim( ((edtPetitorioPrecio_Enabled!=0) ? localUtil.format( A264PetitorioPrecio, "ZZZ9.99") : localUtil.format( A264PetitorioPrecio, "ZZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,85);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioPrecio_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioPrecio_Enabled, 0, "text", "", 7, "chr", 1, "row", 7, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Petitorio.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Petitorio.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_drogueriaid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombodrogueriaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboDrogueriaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombodrogueriaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboDrogueriaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboDrogueriaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombodrogueriaid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombodrogueriaid_Visible, edtavCombodrogueriaid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_petitoriosubcategid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombopetitoriosubcategid_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboPetitorioSubCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombopetitoriosubcategid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboPetitorioSubCategId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboPetitorioSubCategId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopetitoriosubcategid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopetitoriosubcategid_Visible, edtavCombopetitoriosubcategid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Petitorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_formafarmaceuticaid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboformafarmaceuticaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV25ComboFormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavComboformafarmaceuticaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV25ComboFormaFarmaceuticaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV25ComboFormaFarmaceuticaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboformafarmaceuticaid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboformafarmaceuticaid_Visible, edtavComboformafarmaceuticaid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Petitorio.htm");
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
      e110V2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDROGUERIAID_DATA"), AV16DrogueriaId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPETITORIOSUBCATEGID_DATA"), AV22PetitorioSubCategId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFORMAFARMACEUTICAID_DATA"), AV24FormaFarmaceuticaId_Data);
            /* Read saved values. */
            Z25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( "Z25PetitorioId"), ",", ".")) ;
            Z262PetitorioPrincipioActivo = httpContext.cgiGet( "Z262PetitorioPrincipioActivo") ;
            Z263PetitorioProducto = httpContext.cgiGet( "Z263PetitorioProducto") ;
            Z260PetitorioConcentracion = httpContext.cgiGet( "Z260PetitorioConcentracion") ;
            Z261PetitorioPresentacion = httpContext.cgiGet( "Z261PetitorioPresentacion") ;
            Z264PetitorioPrecio = localUtil.ctond( httpContext.cgiGet( "Z264PetitorioPrecio")) ;
            Z36DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z36DrogueriaId"), ",", ".")) ;
            Z48PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( "Z48PetitorioSubCategId"), ",", ".")) ;
            Z39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z39FormaFarmaceuticaId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N36DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( "N36DrogueriaId"), ",", ".")) ;
            N48PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( "N48PetitorioSubCategId"), ",", ".")) ;
            N39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( "N39FormaFarmaceuticaId"), ",", ".")) ;
            AV26PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( "vPETITORIOID"), ",", ".")) ;
            AV12Insert_DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_DROGUERIAID"), ",", ".")) ;
            AV13Insert_PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PETITORIOSUBCATEGID"), ",", ".")) ;
            AV14Insert_FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_FORMAFARMACEUTICAID"), ",", ".")) ;
            AV27Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_drogueriaid_Objectcall = httpContext.cgiGet( "COMBO_DROGUERIAID_Objectcall") ;
            Combo_drogueriaid_Class = httpContext.cgiGet( "COMBO_DROGUERIAID_Class") ;
            Combo_drogueriaid_Icontype = httpContext.cgiGet( "COMBO_DROGUERIAID_Icontype") ;
            Combo_drogueriaid_Icon = httpContext.cgiGet( "COMBO_DROGUERIAID_Icon") ;
            Combo_drogueriaid_Caption = httpContext.cgiGet( "COMBO_DROGUERIAID_Caption") ;
            Combo_drogueriaid_Tooltip = httpContext.cgiGet( "COMBO_DROGUERIAID_Tooltip") ;
            Combo_drogueriaid_Cls = httpContext.cgiGet( "COMBO_DROGUERIAID_Cls") ;
            Combo_drogueriaid_Selectedvalue_set = httpContext.cgiGet( "COMBO_DROGUERIAID_Selectedvalue_set") ;
            Combo_drogueriaid_Selectedvalue_get = httpContext.cgiGet( "COMBO_DROGUERIAID_Selectedvalue_get") ;
            Combo_drogueriaid_Selectedtext_set = httpContext.cgiGet( "COMBO_DROGUERIAID_Selectedtext_set") ;
            Combo_drogueriaid_Selectedtext_get = httpContext.cgiGet( "COMBO_DROGUERIAID_Selectedtext_get") ;
            Combo_drogueriaid_Gamoauthtoken = httpContext.cgiGet( "COMBO_DROGUERIAID_Gamoauthtoken") ;
            Combo_drogueriaid_Ddointernalname = httpContext.cgiGet( "COMBO_DROGUERIAID_Ddointernalname") ;
            Combo_drogueriaid_Titlecontrolalign = httpContext.cgiGet( "COMBO_DROGUERIAID_Titlecontrolalign") ;
            Combo_drogueriaid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_DROGUERIAID_Dropdownoptionstype") ;
            Combo_drogueriaid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Enabled")) ;
            Combo_drogueriaid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Visible")) ;
            Combo_drogueriaid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_DROGUERIAID_Titlecontrolidtoreplace") ;
            Combo_drogueriaid_Datalisttype = httpContext.cgiGet( "COMBO_DROGUERIAID_Datalisttype") ;
            Combo_drogueriaid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Allowmultipleselection")) ;
            Combo_drogueriaid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_DROGUERIAID_Datalistfixedvalues") ;
            Combo_drogueriaid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Isgriditem")) ;
            Combo_drogueriaid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Hasdescription")) ;
            Combo_drogueriaid_Datalistproc = httpContext.cgiGet( "COMBO_DROGUERIAID_Datalistproc") ;
            Combo_drogueriaid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_DROGUERIAID_Datalistprocparametersprefix") ;
            Combo_drogueriaid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_DROGUERIAID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_drogueriaid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Includeonlyselectedoption")) ;
            Combo_drogueriaid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Includeselectalloption")) ;
            Combo_drogueriaid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Emptyitem")) ;
            Combo_drogueriaid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_DROGUERIAID_Includeaddnewoption")) ;
            Combo_drogueriaid_Htmltemplate = httpContext.cgiGet( "COMBO_DROGUERIAID_Htmltemplate") ;
            Combo_drogueriaid_Multiplevaluestype = httpContext.cgiGet( "COMBO_DROGUERIAID_Multiplevaluestype") ;
            Combo_drogueriaid_Loadingdata = httpContext.cgiGet( "COMBO_DROGUERIAID_Loadingdata") ;
            Combo_drogueriaid_Noresultsfound = httpContext.cgiGet( "COMBO_DROGUERIAID_Noresultsfound") ;
            Combo_drogueriaid_Emptyitemtext = httpContext.cgiGet( "COMBO_DROGUERIAID_Emptyitemtext") ;
            Combo_drogueriaid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_DROGUERIAID_Onlyselectedvalues") ;
            Combo_drogueriaid_Selectalltext = httpContext.cgiGet( "COMBO_DROGUERIAID_Selectalltext") ;
            Combo_drogueriaid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_DROGUERIAID_Multiplevaluesseparator") ;
            Combo_drogueriaid_Addnewoptiontext = httpContext.cgiGet( "COMBO_DROGUERIAID_Addnewoptiontext") ;
            Combo_petitoriosubcategid_Objectcall = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Objectcall") ;
            Combo_petitoriosubcategid_Class = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Class") ;
            Combo_petitoriosubcategid_Icontype = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Icontype") ;
            Combo_petitoriosubcategid_Icon = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Icon") ;
            Combo_petitoriosubcategid_Caption = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Caption") ;
            Combo_petitoriosubcategid_Tooltip = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Tooltip") ;
            Combo_petitoriosubcategid_Cls = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Cls") ;
            Combo_petitoriosubcategid_Selectedvalue_set = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Selectedvalue_set") ;
            Combo_petitoriosubcategid_Selectedvalue_get = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Selectedvalue_get") ;
            Combo_petitoriosubcategid_Selectedtext_set = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Selectedtext_set") ;
            Combo_petitoriosubcategid_Selectedtext_get = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Selectedtext_get") ;
            Combo_petitoriosubcategid_Gamoauthtoken = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Gamoauthtoken") ;
            Combo_petitoriosubcategid_Ddointernalname = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Ddointernalname") ;
            Combo_petitoriosubcategid_Titlecontrolalign = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Titlecontrolalign") ;
            Combo_petitoriosubcategid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Dropdownoptionstype") ;
            Combo_petitoriosubcategid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Enabled")) ;
            Combo_petitoriosubcategid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Visible")) ;
            Combo_petitoriosubcategid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Titlecontrolidtoreplace") ;
            Combo_petitoriosubcategid_Datalisttype = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Datalisttype") ;
            Combo_petitoriosubcategid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Allowmultipleselection")) ;
            Combo_petitoriosubcategid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Datalistfixedvalues") ;
            Combo_petitoriosubcategid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Isgriditem")) ;
            Combo_petitoriosubcategid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Hasdescription")) ;
            Combo_petitoriosubcategid_Datalistproc = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Datalistproc") ;
            Combo_petitoriosubcategid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Datalistprocparametersprefix") ;
            Combo_petitoriosubcategid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_petitoriosubcategid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Includeonlyselectedoption")) ;
            Combo_petitoriosubcategid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Includeselectalloption")) ;
            Combo_petitoriosubcategid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Emptyitem")) ;
            Combo_petitoriosubcategid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Includeaddnewoption")) ;
            Combo_petitoriosubcategid_Htmltemplate = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Htmltemplate") ;
            Combo_petitoriosubcategid_Multiplevaluestype = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Multiplevaluestype") ;
            Combo_petitoriosubcategid_Loadingdata = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Loadingdata") ;
            Combo_petitoriosubcategid_Noresultsfound = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Noresultsfound") ;
            Combo_petitoriosubcategid_Emptyitemtext = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Emptyitemtext") ;
            Combo_petitoriosubcategid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Onlyselectedvalues") ;
            Combo_petitoriosubcategid_Selectalltext = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Selectalltext") ;
            Combo_petitoriosubcategid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Multiplevaluesseparator") ;
            Combo_petitoriosubcategid_Addnewoptiontext = httpContext.cgiGet( "COMBO_PETITORIOSUBCATEGID_Addnewoptiontext") ;
            Combo_formafarmaceuticaid_Objectcall = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Objectcall") ;
            Combo_formafarmaceuticaid_Class = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Class") ;
            Combo_formafarmaceuticaid_Icontype = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Icontype") ;
            Combo_formafarmaceuticaid_Icon = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Icon") ;
            Combo_formafarmaceuticaid_Caption = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Caption") ;
            Combo_formafarmaceuticaid_Tooltip = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Tooltip") ;
            Combo_formafarmaceuticaid_Cls = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Cls") ;
            Combo_formafarmaceuticaid_Selectedvalue_set = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Selectedvalue_set") ;
            Combo_formafarmaceuticaid_Selectedvalue_get = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Selectedvalue_get") ;
            Combo_formafarmaceuticaid_Selectedtext_set = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Selectedtext_set") ;
            Combo_formafarmaceuticaid_Selectedtext_get = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Selectedtext_get") ;
            Combo_formafarmaceuticaid_Gamoauthtoken = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Gamoauthtoken") ;
            Combo_formafarmaceuticaid_Ddointernalname = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Ddointernalname") ;
            Combo_formafarmaceuticaid_Titlecontrolalign = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Titlecontrolalign") ;
            Combo_formafarmaceuticaid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Dropdownoptionstype") ;
            Combo_formafarmaceuticaid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Enabled")) ;
            Combo_formafarmaceuticaid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Visible")) ;
            Combo_formafarmaceuticaid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Titlecontrolidtoreplace") ;
            Combo_formafarmaceuticaid_Datalisttype = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Datalisttype") ;
            Combo_formafarmaceuticaid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Allowmultipleselection")) ;
            Combo_formafarmaceuticaid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Datalistfixedvalues") ;
            Combo_formafarmaceuticaid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Isgriditem")) ;
            Combo_formafarmaceuticaid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Hasdescription")) ;
            Combo_formafarmaceuticaid_Datalistproc = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Datalistproc") ;
            Combo_formafarmaceuticaid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Datalistprocparametersprefix") ;
            Combo_formafarmaceuticaid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_formafarmaceuticaid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Includeonlyselectedoption")) ;
            Combo_formafarmaceuticaid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Includeselectalloption")) ;
            Combo_formafarmaceuticaid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Emptyitem")) ;
            Combo_formafarmaceuticaid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Includeaddnewoption")) ;
            Combo_formafarmaceuticaid_Htmltemplate = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Htmltemplate") ;
            Combo_formafarmaceuticaid_Multiplevaluestype = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Multiplevaluestype") ;
            Combo_formafarmaceuticaid_Loadingdata = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Loadingdata") ;
            Combo_formafarmaceuticaid_Noresultsfound = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Noresultsfound") ;
            Combo_formafarmaceuticaid_Emptyitemtext = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Emptyitemtext") ;
            Combo_formafarmaceuticaid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Onlyselectedvalues") ;
            Combo_formafarmaceuticaid_Selectalltext = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Selectalltext") ;
            Combo_formafarmaceuticaid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Multiplevaluesseparator") ;
            Combo_formafarmaceuticaid_Addnewoptiontext = httpContext.cgiGet( "COMBO_FORMAFARMACEUTICAID_Addnewoptiontext") ;
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
            A25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDrogueriaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDrogueriaId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "DROGUERIAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDrogueriaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A36DrogueriaId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
            }
            else
            {
               A36DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( edtDrogueriaId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
            }
            A262PetitorioPrincipioActivo = httpContext.cgiGet( edtPetitorioPrincipioActivo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A262PetitorioPrincipioActivo", A262PetitorioPrincipioActivo);
            A263PetitorioProducto = httpContext.cgiGet( edtPetitorioProducto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A263PetitorioProducto", A263PetitorioProducto);
            A49PetitorioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioCategId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPetitorioSubCategId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPetitorioSubCategId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PETITORIOSUBCATEGID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPetitorioSubCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A48PetitorioSubCategId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
            }
            else
            {
               A48PetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioSubCategId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
            }
            A260PetitorioConcentracion = httpContext.cgiGet( edtPetitorioConcentracion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A260PetitorioConcentracion", A260PetitorioConcentracion);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtFormaFarmaceuticaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtFormaFarmaceuticaId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "FORMAFARMACEUTICAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A39FormaFarmaceuticaId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
            }
            else
            {
               A39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( edtFormaFarmaceuticaId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
            }
            A261PetitorioPresentacion = httpContext.cgiGet( edtPetitorioPresentacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A261PetitorioPresentacion", A261PetitorioPresentacion);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPetitorioPrecio_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPetitorioPrecio_Internalname)), DecimalUtil.stringToDec("9999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PETITORIOPRECIO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPetitorioPrecio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A264PetitorioPrecio = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A264PetitorioPrecio", GXutil.ltrimstr( A264PetitorioPrecio, 7, 2));
            }
            else
            {
               A264PetitorioPrecio = localUtil.ctond( httpContext.cgiGet( edtPetitorioPrecio_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A264PetitorioPrecio", GXutil.ltrimstr( A264PetitorioPrecio, 7, 2));
            }
            AV21ComboDrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombodrogueriaid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboDrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboDrogueriaId), 4, 0));
            AV23ComboPetitorioSubCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombopetitoriosubcategid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboPetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboPetitorioSubCategId), 4, 0));
            AV25ComboFormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboformafarmaceuticaid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboFormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboFormaFarmaceuticaId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Petitorio");
            A25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
            forbiddenHiddens.add("PetitorioId", localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A25PetitorioId != Z25PetitorioId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("petitorio:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A25PetitorioId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
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
                  sMode40 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode40 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound40 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0V0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PETITORIOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPetitorioId_Internalname ;
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
                        e110V2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120V2 ();
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
         e120V2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0V40( ) ;
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
         disableAttributes0V40( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombodrogueriaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombodrogueriaid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopetitoriosubcategid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopetitoriosubcategid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboformafarmaceuticaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboformafarmaceuticaid_Enabled), 5, 0), true);
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

   public void confirm_0V0( )
   {
      beforeValidate0V40( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0V40( ) ;
         }
         else
         {
            checkExtendedTable0V40( ) ;
            closeExtendedTableCursors0V40( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0V0( )
   {
   }

   public void e110V2( )
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
      edtFormaFarmaceuticaId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Visible), 5, 0), true);
      AV25ComboFormaFarmaceuticaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboFormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboFormaFarmaceuticaId), 4, 0));
      edtavComboformafarmaceuticaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboformafarmaceuticaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboformafarmaceuticaid_Visible), 5, 0), true);
      edtPetitorioSubCategId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Visible), 5, 0), true);
      AV23ComboPetitorioSubCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboPetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboPetitorioSubCategId), 4, 0));
      edtavCombopetitoriosubcategid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopetitoriosubcategid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopetitoriosubcategid_Visible), 5, 0), true);
      edtDrogueriaId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Visible), 5, 0), true);
      AV21ComboDrogueriaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboDrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboDrogueriaId), 4, 0));
      edtavCombodrogueriaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombodrogueriaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombodrogueriaid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBODROGUERIAID' */
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
      /* Execute user subroutine: 'LOADCOMBOPETITORIOSUBCATEGID' */
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
      /* Execute user subroutine: 'LOADCOMBOFORMAFARMACEUTICAID' */
      S132 ();
      if ( returnInSub )
      {
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Insert", GXv_boolean5) ;
         petitorio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Update", GXv_boolean5) ;
         petitorio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPetitorio_Delete", GXv_boolean5) ;
         petitorio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV27Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV28GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GXV1), 8, 0));
         while ( AV28GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV28GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "DrogueriaId") == 0 )
            {
               AV12Insert_DrogueriaId = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_DrogueriaId), 4, 0));
               if ( ! (0==AV12Insert_DrogueriaId) )
               {
                  AV21ComboDrogueriaId = AV12Insert_DrogueriaId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboDrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboDrogueriaId), 4, 0));
                  Combo_drogueriaid_Selectedvalue_set = GXutil.trim( GXutil.str( AV21ComboDrogueriaId, 4, 0)) ;
                  ucCombo_drogueriaid.sendProperty(context, "", false, Combo_drogueriaid_Internalname, "SelectedValue_set", Combo_drogueriaid_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char7[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.petitorioloaddvcombo(remoteHandle, context).execute( "DrogueriaId", "GET", false, AV26PetitorioId, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  petitorio_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
                  petitorio_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  petitorio_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_drogueriaid_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_drogueriaid.sendProperty(context, "", false, Combo_drogueriaid_Internalname, "SelectedText_set", Combo_drogueriaid_Selectedtext_set);
                  Combo_drogueriaid_Enabled = false ;
                  ucCombo_drogueriaid.sendProperty(context, "", false, Combo_drogueriaid_Internalname, "Enabled", GXutil.booltostr( Combo_drogueriaid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PetitorioSubCategId") == 0 )
            {
               AV13Insert_PetitorioSubCategId = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_PetitorioSubCategId), 4, 0));
               if ( ! (0==AV13Insert_PetitorioSubCategId) )
               {
                  AV23ComboPetitorioSubCategId = AV13Insert_PetitorioSubCategId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboPetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboPetitorioSubCategId), 4, 0));
                  Combo_petitoriosubcategid_Selectedvalue_set = GXutil.trim( GXutil.str( AV23ComboPetitorioSubCategId, 4, 0)) ;
                  ucCombo_petitoriosubcategid.sendProperty(context, "", false, Combo_petitoriosubcategid_Internalname, "SelectedValue_set", Combo_petitoriosubcategid_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new com.projectthani.petitorioloaddvcombo(remoteHandle, context).execute( "PetitorioSubCategId", "GET", false, AV26PetitorioId, AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  petitorio_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  petitorio_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  petitorio_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_petitoriosubcategid_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_petitoriosubcategid.sendProperty(context, "", false, Combo_petitoriosubcategid_Internalname, "SelectedText_set", Combo_petitoriosubcategid_Selectedtext_set);
                  Combo_petitoriosubcategid_Enabled = false ;
                  ucCombo_petitoriosubcategid.sendProperty(context, "", false, Combo_petitoriosubcategid_Internalname, "Enabled", GXutil.booltostr( Combo_petitoriosubcategid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "FormaFarmaceuticaId") == 0 )
            {
               AV14Insert_FormaFarmaceuticaId = (short)(GXutil.lval( AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_FormaFarmaceuticaId), 4, 0));
               if ( ! (0==AV14Insert_FormaFarmaceuticaId) )
               {
                  AV25ComboFormaFarmaceuticaId = AV14Insert_FormaFarmaceuticaId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25ComboFormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboFormaFarmaceuticaId), 4, 0));
                  Combo_formafarmaceuticaid_Selectedvalue_set = GXutil.trim( GXutil.str( AV25ComboFormaFarmaceuticaId, 4, 0)) ;
                  ucCombo_formafarmaceuticaid.sendProperty(context, "", false, Combo_formafarmaceuticaid_Internalname, "SelectedValue_set", Combo_formafarmaceuticaid_Selectedvalue_set);
                  Combo_formafarmaceuticaid_Enabled = false ;
                  ucCombo_formafarmaceuticaid.sendProperty(context, "", false, Combo_formafarmaceuticaid_Internalname, "Enabled", GXutil.booltostr( Combo_formafarmaceuticaid_Enabled));
               }
            }
            AV28GXV1 = (int)(AV28GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GXV1), 8, 0));
         }
      }
   }

   public void e120V2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.petitorioww", new String[] {}, new String[] {}) );
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

   public void S132( )
   {
      /* 'LOADCOMBOFORMAFARMACEUTICAID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.petitorioloaddvcombo(remoteHandle, context).execute( "FormaFarmaceuticaId", Gx_mode, false, AV26PetitorioId, "", GXv_char9, GXv_char8, GXv_char7) ;
      petitorio_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      petitorio_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      petitorio_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_formafarmaceuticaid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_formafarmaceuticaid.sendProperty(context, "", false, Combo_formafarmaceuticaid_Internalname, "SelectedValue_set", Combo_formafarmaceuticaid_Selectedvalue_set);
      Combo_formafarmaceuticaid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_formafarmaceuticaid.sendProperty(context, "", false, Combo_formafarmaceuticaid_Internalname, "SelectedText_set", Combo_formafarmaceuticaid_Selectedtext_set);
      AV25ComboFormaFarmaceuticaId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboFormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboFormaFarmaceuticaId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_formafarmaceuticaid_Enabled = false ;
         ucCombo_formafarmaceuticaid.sendProperty(context, "", false, Combo_formafarmaceuticaid_Internalname, "Enabled", GXutil.booltostr( Combo_formafarmaceuticaid_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOPETITORIOSUBCATEGID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.petitorioloaddvcombo(remoteHandle, context).execute( "PetitorioSubCategId", Gx_mode, false, AV26PetitorioId, "", GXv_char9, GXv_char8, GXv_char7) ;
      petitorio_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      petitorio_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      petitorio_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_petitoriosubcategid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_petitoriosubcategid.sendProperty(context, "", false, Combo_petitoriosubcategid_Internalname, "SelectedValue_set", Combo_petitoriosubcategid_Selectedvalue_set);
      Combo_petitoriosubcategid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_petitoriosubcategid.sendProperty(context, "", false, Combo_petitoriosubcategid_Internalname, "SelectedText_set", Combo_petitoriosubcategid_Selectedtext_set);
      AV23ComboPetitorioSubCategId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboPetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboPetitorioSubCategId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_petitoriosubcategid_Enabled = false ;
         ucCombo_petitoriosubcategid.sendProperty(context, "", false, Combo_petitoriosubcategid_Internalname, "Enabled", GXutil.booltostr( Combo_petitoriosubcategid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBODROGUERIAID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.petitorioloaddvcombo(remoteHandle, context).execute( "DrogueriaId", Gx_mode, false, AV26PetitorioId, "", GXv_char9, GXv_char8, GXv_char7) ;
      petitorio_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      petitorio_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      petitorio_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_drogueriaid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_drogueriaid.sendProperty(context, "", false, Combo_drogueriaid_Internalname, "SelectedValue_set", Combo_drogueriaid_Selectedvalue_set);
      Combo_drogueriaid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_drogueriaid.sendProperty(context, "", false, Combo_drogueriaid_Internalname, "SelectedText_set", Combo_drogueriaid_Selectedtext_set);
      AV21ComboDrogueriaId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboDrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboDrogueriaId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_drogueriaid_Enabled = false ;
         ucCombo_drogueriaid.sendProperty(context, "", false, Combo_drogueriaid_Internalname, "Enabled", GXutil.booltostr( Combo_drogueriaid_Enabled));
      }
   }

   public void zm0V40( int GX_JID )
   {
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z262PetitorioPrincipioActivo = T000V3_A262PetitorioPrincipioActivo[0] ;
            Z263PetitorioProducto = T000V3_A263PetitorioProducto[0] ;
            Z260PetitorioConcentracion = T000V3_A260PetitorioConcentracion[0] ;
            Z261PetitorioPresentacion = T000V3_A261PetitorioPresentacion[0] ;
            Z264PetitorioPrecio = T000V3_A264PetitorioPrecio[0] ;
            Z36DrogueriaId = T000V3_A36DrogueriaId[0] ;
            Z48PetitorioSubCategId = T000V3_A48PetitorioSubCategId[0] ;
            Z39FormaFarmaceuticaId = T000V3_A39FormaFarmaceuticaId[0] ;
         }
         else
         {
            Z262PetitorioPrincipioActivo = A262PetitorioPrincipioActivo ;
            Z263PetitorioProducto = A263PetitorioProducto ;
            Z260PetitorioConcentracion = A260PetitorioConcentracion ;
            Z261PetitorioPresentacion = A261PetitorioPresentacion ;
            Z264PetitorioPrecio = A264PetitorioPrecio ;
            Z36DrogueriaId = A36DrogueriaId ;
            Z48PetitorioSubCategId = A48PetitorioSubCategId ;
            Z39FormaFarmaceuticaId = A39FormaFarmaceuticaId ;
         }
      }
      if ( GX_JID == -14 )
      {
         Z25PetitorioId = A25PetitorioId ;
         Z262PetitorioPrincipioActivo = A262PetitorioPrincipioActivo ;
         Z263PetitorioProducto = A263PetitorioProducto ;
         Z260PetitorioConcentracion = A260PetitorioConcentracion ;
         Z261PetitorioPresentacion = A261PetitorioPresentacion ;
         Z264PetitorioPrecio = A264PetitorioPrecio ;
         Z36DrogueriaId = A36DrogueriaId ;
         Z48PetitorioSubCategId = A48PetitorioSubCategId ;
         Z39FormaFarmaceuticaId = A39FormaFarmaceuticaId ;
         Z49PetitorioCategId = A49PetitorioCategId ;
      }
   }

   public void standaloneNotModal( )
   {
      edtPetitorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioId_Enabled), 5, 0), true);
      edtPetitorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV26PetitorioId) )
      {
         A25PetitorioId = AV26PetitorioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_DrogueriaId) )
      {
         edtDrogueriaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Enabled), 5, 0), true);
      }
      else
      {
         edtDrogueriaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_PetitorioSubCategId) )
      {
         edtPetitorioSubCategId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Enabled), 5, 0), true);
      }
      else
      {
         edtPetitorioSubCategId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_FormaFarmaceuticaId) )
      {
         edtFormaFarmaceuticaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Enabled), 5, 0), true);
      }
      else
      {
         edtFormaFarmaceuticaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_DrogueriaId) )
      {
         A36DrogueriaId = AV12Insert_DrogueriaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
      }
      else
      {
         A36DrogueriaId = AV21ComboDrogueriaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_PetitorioSubCategId) )
      {
         A48PetitorioSubCategId = AV13Insert_PetitorioSubCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
      }
      else
      {
         A48PetitorioSubCategId = AV23ComboPetitorioSubCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_FormaFarmaceuticaId) )
      {
         A39FormaFarmaceuticaId = AV14Insert_FormaFarmaceuticaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
      }
      else
      {
         A39FormaFarmaceuticaId = AV25ComboFormaFarmaceuticaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
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
         AV27Pgmname = "Petitorio" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
         /* Using cursor T000V5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
         A49PetitorioCategId = T000V5_A49PetitorioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
         pr_default.close(3);
      }
   }

   public void load0V40( )
   {
      /* Using cursor T000V7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A262PetitorioPrincipioActivo = T000V7_A262PetitorioPrincipioActivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A262PetitorioPrincipioActivo", A262PetitorioPrincipioActivo);
         A263PetitorioProducto = T000V7_A263PetitorioProducto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A263PetitorioProducto", A263PetitorioProducto);
         A260PetitorioConcentracion = T000V7_A260PetitorioConcentracion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A260PetitorioConcentracion", A260PetitorioConcentracion);
         A261PetitorioPresentacion = T000V7_A261PetitorioPresentacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A261PetitorioPresentacion", A261PetitorioPresentacion);
         A264PetitorioPrecio = T000V7_A264PetitorioPrecio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A264PetitorioPrecio", GXutil.ltrimstr( A264PetitorioPrecio, 7, 2));
         A36DrogueriaId = T000V7_A36DrogueriaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
         A48PetitorioSubCategId = T000V7_A48PetitorioSubCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
         A39FormaFarmaceuticaId = T000V7_A39FormaFarmaceuticaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
         A49PetitorioCategId = T000V7_A49PetitorioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
         zm0V40( -14) ;
      }
      pr_default.close(5);
      onLoadActions0V40( ) ;
   }

   public void onLoadActions0V40( )
   {
      AV27Pgmname = "Petitorio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
   }

   public void checkExtendedTable0V40( )
   {
      nIsDirty_40 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV27Pgmname = "Petitorio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      /* Using cursor T000V4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Drogueria'.", "ForeignKeyNotFound", 1, "DROGUERIAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDrogueriaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T000V5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio Sub Categ'.", "ForeignKeyNotFound", 1, "PETITORIOSUBCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioSubCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A49PetitorioCategId = T000V5_A49PetitorioCategId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
      pr_default.close(3);
      /* Using cursor T000V6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Forma Farmaceutica'.", "ForeignKeyNotFound", 1, "FORMAFARMACEUTICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
   }

   public void closeExtendedTableCursors0V40( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_15( short A36DrogueriaId )
   {
      /* Using cursor T000V8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Drogueria'.", "ForeignKeyNotFound", 1, "DROGUERIAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDrogueriaId_Internalname ;
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

   public void gxload_16( short A48PetitorioSubCategId )
   {
      /* Using cursor T000V9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio Sub Categ'.", "ForeignKeyNotFound", 1, "PETITORIOSUBCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioSubCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A49PetitorioCategId = T000V9_A49PetitorioCategId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_17( short A39FormaFarmaceuticaId )
   {
      /* Using cursor T000V10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Forma Farmaceutica'.", "ForeignKeyNotFound", 1, "FORMAFARMACEUTICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
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

   public void getKey0V40( )
   {
      /* Using cursor T000V11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound40 = (short)(1) ;
      }
      else
      {
         RcdFound40 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000V3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0V40( 14) ;
         RcdFound40 = (short)(1) ;
         A25PetitorioId = T000V3_A25PetitorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
         A262PetitorioPrincipioActivo = T000V3_A262PetitorioPrincipioActivo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A262PetitorioPrincipioActivo", A262PetitorioPrincipioActivo);
         A263PetitorioProducto = T000V3_A263PetitorioProducto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A263PetitorioProducto", A263PetitorioProducto);
         A260PetitorioConcentracion = T000V3_A260PetitorioConcentracion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A260PetitorioConcentracion", A260PetitorioConcentracion);
         A261PetitorioPresentacion = T000V3_A261PetitorioPresentacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A261PetitorioPresentacion", A261PetitorioPresentacion);
         A264PetitorioPrecio = T000V3_A264PetitorioPrecio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A264PetitorioPrecio", GXutil.ltrimstr( A264PetitorioPrecio, 7, 2));
         A36DrogueriaId = T000V3_A36DrogueriaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
         A48PetitorioSubCategId = T000V3_A48PetitorioSubCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
         A39FormaFarmaceuticaId = T000V3_A39FormaFarmaceuticaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
         Z25PetitorioId = A25PetitorioId ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0V40( ) ;
         if ( AnyError == 1 )
         {
            RcdFound40 = (short)(0) ;
            initializeNonKey0V40( ) ;
         }
         Gx_mode = sMode40 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound40 = (short)(0) ;
         initializeNonKey0V40( ) ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode40 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0V40( ) ;
      if ( RcdFound40 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound40 = (short)(0) ;
      /* Using cursor T000V12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000V12_A25PetitorioId[0] < A25PetitorioId ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000V12_A25PetitorioId[0] > A25PetitorioId ) ) )
         {
            A25PetitorioId = T000V12_A25PetitorioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
            RcdFound40 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound40 = (short)(0) ;
      /* Using cursor T000V13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000V13_A25PetitorioId[0] > A25PetitorioId ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000V13_A25PetitorioId[0] < A25PetitorioId ) ) )
         {
            A25PetitorioId = T000V13_A25PetitorioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
            RcdFound40 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0V40( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtDrogueriaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0V40( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound40 == 1 )
         {
            if ( A25PetitorioId != Z25PetitorioId )
            {
               A25PetitorioId = Z25PetitorioId ;
               httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PETITORIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPetitorioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtDrogueriaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0V40( ) ;
               GX_FocusControl = edtDrogueriaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A25PetitorioId != Z25PetitorioId )
            {
               /* Insert record */
               GX_FocusControl = edtDrogueriaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0V40( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PETITORIOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPetitorioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtDrogueriaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0V40( ) ;
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
      if ( A25PetitorioId != Z25PetitorioId )
      {
         A25PetitorioId = Z25PetitorioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PETITORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtDrogueriaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0V40( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000V2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A25PetitorioId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Petitorio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z262PetitorioPrincipioActivo, T000V2_A262PetitorioPrincipioActivo[0]) != 0 ) || ( GXutil.strcmp(Z263PetitorioProducto, T000V2_A263PetitorioProducto[0]) != 0 ) || ( GXutil.strcmp(Z260PetitorioConcentracion, T000V2_A260PetitorioConcentracion[0]) != 0 ) || ( GXutil.strcmp(Z261PetitorioPresentacion, T000V2_A261PetitorioPresentacion[0]) != 0 ) || ( DecimalUtil.compareTo(Z264PetitorioPrecio, T000V2_A264PetitorioPrecio[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z36DrogueriaId != T000V2_A36DrogueriaId[0] ) || ( Z48PetitorioSubCategId != T000V2_A48PetitorioSubCategId[0] ) || ( Z39FormaFarmaceuticaId != T000V2_A39FormaFarmaceuticaId[0] ) )
         {
            if ( GXutil.strcmp(Z262PetitorioPrincipioActivo, T000V2_A262PetitorioPrincipioActivo[0]) != 0 )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"PetitorioPrincipioActivo");
               GXutil.writeLogRaw("Old: ",Z262PetitorioPrincipioActivo);
               GXutil.writeLogRaw("Current: ",T000V2_A262PetitorioPrincipioActivo[0]);
            }
            if ( GXutil.strcmp(Z263PetitorioProducto, T000V2_A263PetitorioProducto[0]) != 0 )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"PetitorioProducto");
               GXutil.writeLogRaw("Old: ",Z263PetitorioProducto);
               GXutil.writeLogRaw("Current: ",T000V2_A263PetitorioProducto[0]);
            }
            if ( GXutil.strcmp(Z260PetitorioConcentracion, T000V2_A260PetitorioConcentracion[0]) != 0 )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"PetitorioConcentracion");
               GXutil.writeLogRaw("Old: ",Z260PetitorioConcentracion);
               GXutil.writeLogRaw("Current: ",T000V2_A260PetitorioConcentracion[0]);
            }
            if ( GXutil.strcmp(Z261PetitorioPresentacion, T000V2_A261PetitorioPresentacion[0]) != 0 )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"PetitorioPresentacion");
               GXutil.writeLogRaw("Old: ",Z261PetitorioPresentacion);
               GXutil.writeLogRaw("Current: ",T000V2_A261PetitorioPresentacion[0]);
            }
            if ( DecimalUtil.compareTo(Z264PetitorioPrecio, T000V2_A264PetitorioPrecio[0]) != 0 )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"PetitorioPrecio");
               GXutil.writeLogRaw("Old: ",Z264PetitorioPrecio);
               GXutil.writeLogRaw("Current: ",T000V2_A264PetitorioPrecio[0]);
            }
            if ( Z36DrogueriaId != T000V2_A36DrogueriaId[0] )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"DrogueriaId");
               GXutil.writeLogRaw("Old: ",Z36DrogueriaId);
               GXutil.writeLogRaw("Current: ",T000V2_A36DrogueriaId[0]);
            }
            if ( Z48PetitorioSubCategId != T000V2_A48PetitorioSubCategId[0] )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"PetitorioSubCategId");
               GXutil.writeLogRaw("Old: ",Z48PetitorioSubCategId);
               GXutil.writeLogRaw("Current: ",T000V2_A48PetitorioSubCategId[0]);
            }
            if ( Z39FormaFarmaceuticaId != T000V2_A39FormaFarmaceuticaId[0] )
            {
               GXutil.writeLogln("petitorio:[seudo value changed for attri]"+"FormaFarmaceuticaId");
               GXutil.writeLogRaw("Old: ",Z39FormaFarmaceuticaId);
               GXutil.writeLogRaw("Current: ",T000V2_A39FormaFarmaceuticaId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Petitorio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0V40( )
   {
      beforeValidate0V40( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V40( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0V40( 0) ;
         checkOptimisticConcurrency0V40( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V40( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0V40( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000V14 */
                  pr_default.execute(12, new Object[] {A262PetitorioPrincipioActivo, A263PetitorioProducto, A260PetitorioConcentracion, A261PetitorioPresentacion, A264PetitorioPrecio, Short.valueOf(A36DrogueriaId), Short.valueOf(A48PetitorioSubCategId), Short.valueOf(A39FormaFarmaceuticaId)});
                  A25PetitorioId = T000V14_A25PetitorioId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Petitorio");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0V0( ) ;
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
            load0V40( ) ;
         }
         endLevel0V40( ) ;
      }
      closeExtendedTableCursors0V40( ) ;
   }

   public void update0V40( )
   {
      beforeValidate0V40( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0V40( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V40( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0V40( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0V40( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000V15 */
                  pr_default.execute(13, new Object[] {A262PetitorioPrincipioActivo, A263PetitorioProducto, A260PetitorioConcentracion, A261PetitorioPresentacion, A264PetitorioPrecio, Short.valueOf(A36DrogueriaId), Short.valueOf(A48PetitorioSubCategId), Short.valueOf(A39FormaFarmaceuticaId), Short.valueOf(A25PetitorioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Petitorio");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Petitorio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0V40( ) ;
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
         endLevel0V40( ) ;
      }
      closeExtendedTableCursors0V40( ) ;
   }

   public void deferredUpdate0V40( )
   {
   }

   public void delete( )
   {
      beforeValidate0V40( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0V40( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0V40( ) ;
         afterConfirm0V40( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0V40( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000V16 */
               pr_default.execute(14, new Object[] {Short.valueOf(A25PetitorioId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Petitorio");
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
      sMode40 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0V40( ) ;
      Gx_mode = sMode40 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0V40( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV27Pgmname = "Petitorio" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
         /* Using cursor T000V17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
         A49PetitorioCategId = T000V17_A49PetitorioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
         pr_default.close(15);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000V18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A25PetitorioId)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Receta"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void endLevel0V40( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0V40( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(15);
         Application.commitDataStores(context, remoteHandle, pr_default, "petitorio");
         if ( AnyError == 0 )
         {
            confirmValues0V0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(15);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "petitorio");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0V40( )
   {
      /* Scan By routine */
      /* Using cursor T000V19 */
      pr_default.execute(17);
      RcdFound40 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A25PetitorioId = T000V19_A25PetitorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0V40( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound40 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A25PetitorioId = T000V19_A25PetitorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
      }
   }

   public void scanEnd0V40( )
   {
      pr_default.close(17);
   }

   public void afterConfirm0V40( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0V40( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0V40( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0V40( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0V40( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0V40( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0V40( )
   {
      edtPetitorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioId_Enabled), 5, 0), true);
      edtDrogueriaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Enabled), 5, 0), true);
      edtPetitorioPrincipioActivo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioPrincipioActivo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioPrincipioActivo_Enabled), 5, 0), true);
      edtPetitorioProducto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioProducto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioProducto_Enabled), 5, 0), true);
      edtPetitorioCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioCategId_Enabled), 5, 0), true);
      edtPetitorioSubCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioSubCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioSubCategId_Enabled), 5, 0), true);
      edtPetitorioConcentracion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioConcentracion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioConcentracion_Enabled), 5, 0), true);
      edtFormaFarmaceuticaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Enabled), 5, 0), true);
      edtPetitorioPresentacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioPresentacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioPresentacion_Enabled), 5, 0), true);
      edtPetitorioPrecio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioPrecio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioPrecio_Enabled), 5, 0), true);
      edtavCombodrogueriaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombodrogueriaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombodrogueriaid_Enabled), 5, 0), true);
      edtavCombopetitoriosubcategid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopetitoriosubcategid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopetitoriosubcategid_Enabled), 5, 0), true);
      edtavComboformafarmaceuticaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboformafarmaceuticaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboformafarmaceuticaid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0V40( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0V0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033026", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.petitorio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV26PetitorioId,4,0))}, new String[] {"Gx_mode","PetitorioId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Petitorio");
      forbiddenHiddens.add("PetitorioId", localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("petitorio:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z25PetitorioId", GXutil.ltrim( localUtil.ntoc( Z25PetitorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z262PetitorioPrincipioActivo", Z262PetitorioPrincipioActivo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z263PetitorioProducto", Z263PetitorioProducto);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z260PetitorioConcentracion", Z260PetitorioConcentracion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z261PetitorioPresentacion", Z261PetitorioPresentacion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z264PetitorioPrecio", GXutil.ltrim( localUtil.ntoc( Z264PetitorioPrecio, (byte)(7), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z36DrogueriaId", GXutil.ltrim( localUtil.ntoc( Z36DrogueriaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z48PetitorioSubCategId", GXutil.ltrim( localUtil.ntoc( Z48PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z39FormaFarmaceuticaId", GXutil.ltrim( localUtil.ntoc( Z39FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N36DrogueriaId", GXutil.ltrim( localUtil.ntoc( A36DrogueriaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N48PetitorioSubCategId", GXutil.ltrim( localUtil.ntoc( A48PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N39FormaFarmaceuticaId", GXutil.ltrim( localUtil.ntoc( A39FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDROGUERIAID_DATA", AV16DrogueriaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDROGUERIAID_DATA", AV16DrogueriaId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPETITORIOSUBCATEGID_DATA", AV22PetitorioSubCategId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPETITORIOSUBCATEGID_DATA", AV22PetitorioSubCategId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFORMAFARMACEUTICAID_DATA", AV24FormaFarmaceuticaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFORMAFARMACEUTICAID_DATA", AV24FormaFarmaceuticaId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPETITORIOID", GXutil.ltrim( localUtil.ntoc( AV26PetitorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPETITORIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26PetitorioId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_DROGUERIAID", GXutil.ltrim( localUtil.ntoc( AV12Insert_DrogueriaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PETITORIOSUBCATEGID", GXutil.ltrim( localUtil.ntoc( AV13Insert_PetitorioSubCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_FORMAFARMACEUTICAID", GXutil.ltrim( localUtil.ntoc( AV14Insert_FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV27Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Objectcall", GXutil.rtrim( Combo_drogueriaid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Cls", GXutil.rtrim( Combo_drogueriaid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Selectedvalue_set", GXutil.rtrim( Combo_drogueriaid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Selectedtext_set", GXutil.rtrim( Combo_drogueriaid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Enabled", GXutil.booltostr( Combo_drogueriaid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Datalistproc", GXutil.rtrim( Combo_drogueriaid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_drogueriaid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_DROGUERIAID_Emptyitem", GXutil.booltostr( Combo_drogueriaid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Objectcall", GXutil.rtrim( Combo_petitoriosubcategid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Cls", GXutil.rtrim( Combo_petitoriosubcategid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Selectedvalue_set", GXutil.rtrim( Combo_petitoriosubcategid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Selectedtext_set", GXutil.rtrim( Combo_petitoriosubcategid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Enabled", GXutil.booltostr( Combo_petitoriosubcategid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Datalistproc", GXutil.rtrim( Combo_petitoriosubcategid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Datalistprocparametersprefix", GXutil.rtrim( Combo_petitoriosubcategid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PETITORIOSUBCATEGID_Emptyitem", GXutil.booltostr( Combo_petitoriosubcategid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Objectcall", GXutil.rtrim( Combo_formafarmaceuticaid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Cls", GXutil.rtrim( Combo_formafarmaceuticaid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Selectedvalue_set", GXutil.rtrim( Combo_formafarmaceuticaid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Selectedtext_set", GXutil.rtrim( Combo_formafarmaceuticaid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Enabled", GXutil.booltostr( Combo_formafarmaceuticaid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Datalistproc", GXutil.rtrim( Combo_formafarmaceuticaid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_formafarmaceuticaid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_FORMAFARMACEUTICAID_Emptyitem", GXutil.booltostr( Combo_formafarmaceuticaid_Emptyitem));
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
      return formatLink("com.projectthani.petitorio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV26PetitorioId,4,0))}, new String[] {"Gx_mode","PetitorioId"})  ;
   }

   public String getPgmname( )
   {
      return "Petitorio" ;
   }

   public String getPgmdesc( )
   {
      return "Petitorio" ;
   }

   public void initializeNonKey0V40( )
   {
      A36DrogueriaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
      A48PetitorioSubCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A48PetitorioSubCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A48PetitorioSubCategId), 4, 0));
      A39FormaFarmaceuticaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
      A262PetitorioPrincipioActivo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A262PetitorioPrincipioActivo", A262PetitorioPrincipioActivo);
      A263PetitorioProducto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A263PetitorioProducto", A263PetitorioProducto);
      A49PetitorioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A49PetitorioCategId), 4, 0));
      A260PetitorioConcentracion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A260PetitorioConcentracion", A260PetitorioConcentracion);
      A261PetitorioPresentacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A261PetitorioPresentacion", A261PetitorioPresentacion);
      A264PetitorioPrecio = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A264PetitorioPrecio", GXutil.ltrimstr( A264PetitorioPrecio, 7, 2));
      Z262PetitorioPrincipioActivo = "" ;
      Z263PetitorioProducto = "" ;
      Z260PetitorioConcentracion = "" ;
      Z261PetitorioPresentacion = "" ;
      Z264PetitorioPrecio = DecimalUtil.ZERO ;
      Z36DrogueriaId = (short)(0) ;
      Z48PetitorioSubCategId = (short)(0) ;
      Z39FormaFarmaceuticaId = (short)(0) ;
   }

   public void initAll0V40( )
   {
      A25PetitorioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
      initializeNonKey0V40( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033058", true, true);
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
      httpContext.AddJavascriptSource("petitorio.js", "?2022511033058", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      edtPetitorioId_Internalname = "PETITORIOID" ;
      lblTextblockdrogueriaid_Internalname = "TEXTBLOCKDROGUERIAID" ;
      Combo_drogueriaid_Internalname = "COMBO_DROGUERIAID" ;
      edtDrogueriaId_Internalname = "DROGUERIAID" ;
      divTablesplitteddrogueriaid_Internalname = "TABLESPLITTEDDROGUERIAID" ;
      edtPetitorioPrincipioActivo_Internalname = "PETITORIOPRINCIPIOACTIVO" ;
      edtPetitorioProducto_Internalname = "PETITORIOPRODUCTO" ;
      edtPetitorioCategId_Internalname = "PETITORIOCATEGID" ;
      lblTextblockpetitoriosubcategid_Internalname = "TEXTBLOCKPETITORIOSUBCATEGID" ;
      Combo_petitoriosubcategid_Internalname = "COMBO_PETITORIOSUBCATEGID" ;
      edtPetitorioSubCategId_Internalname = "PETITORIOSUBCATEGID" ;
      divTablesplittedpetitoriosubcategid_Internalname = "TABLESPLITTEDPETITORIOSUBCATEGID" ;
      edtPetitorioConcentracion_Internalname = "PETITORIOCONCENTRACION" ;
      lblTextblockformafarmaceuticaid_Internalname = "TEXTBLOCKFORMAFARMACEUTICAID" ;
      Combo_formafarmaceuticaid_Internalname = "COMBO_FORMAFARMACEUTICAID" ;
      edtFormaFarmaceuticaId_Internalname = "FORMAFARMACEUTICAID" ;
      divTablesplittedformafarmaceuticaid_Internalname = "TABLESPLITTEDFORMAFARMACEUTICAID" ;
      edtPetitorioPresentacion_Internalname = "PETITORIOPRESENTACION" ;
      edtPetitorioPrecio_Internalname = "PETITORIOPRECIO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombodrogueriaid_Internalname = "vCOMBODROGUERIAID" ;
      divSectionattribute_drogueriaid_Internalname = "SECTIONATTRIBUTE_DROGUERIAID" ;
      edtavCombopetitoriosubcategid_Internalname = "vCOMBOPETITORIOSUBCATEGID" ;
      divSectionattribute_petitoriosubcategid_Internalname = "SECTIONATTRIBUTE_PETITORIOSUBCATEGID" ;
      edtavComboformafarmaceuticaid_Internalname = "vCOMBOFORMAFARMACEUTICAID" ;
      divSectionattribute_formafarmaceuticaid_Internalname = "SECTIONATTRIBUTE_FORMAFARMACEUTICAID" ;
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
      Form.setCaption( "Petitorio" );
      edtavComboformafarmaceuticaid_Jsonclick = "" ;
      edtavComboformafarmaceuticaid_Enabled = 0 ;
      edtavComboformafarmaceuticaid_Visible = 1 ;
      edtavCombopetitoriosubcategid_Jsonclick = "" ;
      edtavCombopetitoriosubcategid_Enabled = 0 ;
      edtavCombopetitoriosubcategid_Visible = 1 ;
      edtavCombodrogueriaid_Jsonclick = "" ;
      edtavCombodrogueriaid_Enabled = 0 ;
      edtavCombodrogueriaid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPetitorioPrecio_Jsonclick = "" ;
      edtPetitorioPrecio_Enabled = 1 ;
      edtPetitorioPresentacion_Jsonclick = "" ;
      edtPetitorioPresentacion_Enabled = 1 ;
      edtFormaFarmaceuticaId_Jsonclick = "" ;
      edtFormaFarmaceuticaId_Enabled = 1 ;
      edtFormaFarmaceuticaId_Visible = 1 ;
      Combo_formafarmaceuticaid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_formafarmaceuticaid_Datalistprocparametersprefix = " \"ComboName\": \"FormaFarmaceuticaId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PetitorioId\": 0" ;
      Combo_formafarmaceuticaid_Datalistproc = "PetitorioLoadDVCombo" ;
      Combo_formafarmaceuticaid_Cls = "ExtendedCombo Attribute" ;
      Combo_formafarmaceuticaid_Caption = "" ;
      Combo_formafarmaceuticaid_Enabled = GXutil.toBoolean( -1) ;
      edtPetitorioConcentracion_Jsonclick = "" ;
      edtPetitorioConcentracion_Enabled = 1 ;
      edtPetitorioSubCategId_Jsonclick = "" ;
      edtPetitorioSubCategId_Enabled = 1 ;
      edtPetitorioSubCategId_Visible = 1 ;
      Combo_petitoriosubcategid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_petitoriosubcategid_Datalistprocparametersprefix = " \"ComboName\": \"PetitorioSubCategId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PetitorioId\": 0" ;
      Combo_petitoriosubcategid_Datalistproc = "PetitorioLoadDVCombo" ;
      Combo_petitoriosubcategid_Cls = "ExtendedCombo Attribute" ;
      Combo_petitoriosubcategid_Caption = "" ;
      Combo_petitoriosubcategid_Enabled = GXutil.toBoolean( -1) ;
      edtPetitorioCategId_Jsonclick = "" ;
      edtPetitorioCategId_Enabled = 0 ;
      edtPetitorioProducto_Jsonclick = "" ;
      edtPetitorioProducto_Enabled = 1 ;
      edtPetitorioPrincipioActivo_Enabled = 1 ;
      edtDrogueriaId_Jsonclick = "" ;
      edtDrogueriaId_Enabled = 1 ;
      edtDrogueriaId_Visible = 1 ;
      Combo_drogueriaid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_drogueriaid_Datalistprocparametersprefix = " \"ComboName\": \"DrogueriaId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PetitorioId\": 0" ;
      Combo_drogueriaid_Datalistproc = "PetitorioLoadDVCombo" ;
      Combo_drogueriaid_Cls = "ExtendedCombo Attribute" ;
      Combo_drogueriaid_Caption = "" ;
      Combo_drogueriaid_Enabled = GXutil.toBoolean( -1) ;
      edtPetitorioId_Jsonclick = "" ;
      edtPetitorioId_Enabled = 0 ;
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

   public void valid_Drogueriaid( )
   {
      /* Using cursor T000V20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Drogueria'.", "ForeignKeyNotFound", 1, "DROGUERIAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDrogueriaId_Internalname ;
      }
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Petitoriosubcategid( )
   {
      /* Using cursor T000V17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A48PetitorioSubCategId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio Sub Categ'.", "ForeignKeyNotFound", 1, "PETITORIOSUBCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioSubCategId_Internalname ;
      }
      A49PetitorioCategId = T000V17_A49PetitorioCategId[0] ;
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A49PetitorioCategId", GXutil.ltrim( localUtil.ntoc( A49PetitorioCategId, (byte)(4), (byte)(0), ".", "")));
   }

   public void valid_Formafarmaceuticaid( )
   {
      /* Using cursor T000V21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Forma Farmaceutica'.", "ForeignKeyNotFound", 1, "FORMAFARMACEUTICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
      }
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26PetitorioId',fld:'vPETITORIOID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV26PetitorioId',fld:'vPETITORIOID',pic:'ZZZ9',hsh:true},{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120V2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PETITORIOID","{handler:'valid_Petitorioid',iparms:[]");
      setEventMetadata("VALID_PETITORIOID",",oparms:[]}");
      setEventMetadata("VALID_DROGUERIAID","{handler:'valid_Drogueriaid',iparms:[{av:'A36DrogueriaId',fld:'DROGUERIAID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_DROGUERIAID",",oparms:[]}");
      setEventMetadata("VALID_PETITORIOSUBCATEGID","{handler:'valid_Petitoriosubcategid',iparms:[{av:'A48PetitorioSubCategId',fld:'PETITORIOSUBCATEGID',pic:'ZZZ9'},{av:'A49PetitorioCategId',fld:'PETITORIOCATEGID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_PETITORIOSUBCATEGID",",oparms:[{av:'A49PetitorioCategId',fld:'PETITORIOCATEGID',pic:'ZZZ9'}]}");
      setEventMetadata("VALID_FORMAFARMACEUTICAID","{handler:'valid_Formafarmaceuticaid',iparms:[{av:'A39FormaFarmaceuticaId',fld:'FORMAFARMACEUTICAID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_FORMAFARMACEUTICAID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBODROGUERIAID","{handler:'validv_Combodrogueriaid',iparms:[]");
      setEventMetadata("VALIDV_COMBODROGUERIAID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOPETITORIOSUBCATEGID","{handler:'validv_Combopetitoriosubcategid',iparms:[]");
      setEventMetadata("VALIDV_COMBOPETITORIOSUBCATEGID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOFORMAFARMACEUTICAID","{handler:'validv_Comboformafarmaceuticaid',iparms:[]");
      setEventMetadata("VALIDV_COMBOFORMAFARMACEUTICAID",",oparms:[]}");
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
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z262PetitorioPrincipioActivo = "" ;
      Z263PetitorioProducto = "" ;
      Z260PetitorioConcentracion = "" ;
      Z261PetitorioPresentacion = "" ;
      Z264PetitorioPrecio = DecimalUtil.ZERO ;
      Combo_formafarmaceuticaid_Selectedvalue_get = "" ;
      Combo_petitoriosubcategid_Selectedvalue_get = "" ;
      Combo_drogueriaid_Selectedvalue_get = "" ;
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
      lblTextblockdrogueriaid_Jsonclick = "" ;
      ucCombo_drogueriaid = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16DrogueriaId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A262PetitorioPrincipioActivo = "" ;
      A263PetitorioProducto = "" ;
      lblTextblockpetitoriosubcategid_Jsonclick = "" ;
      ucCombo_petitoriosubcategid = new com.genexus.webpanels.GXUserControl();
      AV22PetitorioSubCategId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A260PetitorioConcentracion = "" ;
      lblTextblockformafarmaceuticaid_Jsonclick = "" ;
      ucCombo_formafarmaceuticaid = new com.genexus.webpanels.GXUserControl();
      AV24FormaFarmaceuticaId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A261PetitorioPresentacion = "" ;
      A264PetitorioPrecio = DecimalUtil.ZERO ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV27Pgmname = "" ;
      Combo_drogueriaid_Objectcall = "" ;
      Combo_drogueriaid_Class = "" ;
      Combo_drogueriaid_Icontype = "" ;
      Combo_drogueriaid_Icon = "" ;
      Combo_drogueriaid_Tooltip = "" ;
      Combo_drogueriaid_Selectedvalue_set = "" ;
      Combo_drogueriaid_Selectedtext_set = "" ;
      Combo_drogueriaid_Selectedtext_get = "" ;
      Combo_drogueriaid_Gamoauthtoken = "" ;
      Combo_drogueriaid_Ddointernalname = "" ;
      Combo_drogueriaid_Titlecontrolalign = "" ;
      Combo_drogueriaid_Dropdownoptionstype = "" ;
      Combo_drogueriaid_Titlecontrolidtoreplace = "" ;
      Combo_drogueriaid_Datalisttype = "" ;
      Combo_drogueriaid_Datalistfixedvalues = "" ;
      Combo_drogueriaid_Htmltemplate = "" ;
      Combo_drogueriaid_Multiplevaluestype = "" ;
      Combo_drogueriaid_Loadingdata = "" ;
      Combo_drogueriaid_Noresultsfound = "" ;
      Combo_drogueriaid_Emptyitemtext = "" ;
      Combo_drogueriaid_Onlyselectedvalues = "" ;
      Combo_drogueriaid_Selectalltext = "" ;
      Combo_drogueriaid_Multiplevaluesseparator = "" ;
      Combo_drogueriaid_Addnewoptiontext = "" ;
      Combo_petitoriosubcategid_Objectcall = "" ;
      Combo_petitoriosubcategid_Class = "" ;
      Combo_petitoriosubcategid_Icontype = "" ;
      Combo_petitoriosubcategid_Icon = "" ;
      Combo_petitoriosubcategid_Tooltip = "" ;
      Combo_petitoriosubcategid_Selectedvalue_set = "" ;
      Combo_petitoriosubcategid_Selectedtext_set = "" ;
      Combo_petitoriosubcategid_Selectedtext_get = "" ;
      Combo_petitoriosubcategid_Gamoauthtoken = "" ;
      Combo_petitoriosubcategid_Ddointernalname = "" ;
      Combo_petitoriosubcategid_Titlecontrolalign = "" ;
      Combo_petitoriosubcategid_Dropdownoptionstype = "" ;
      Combo_petitoriosubcategid_Titlecontrolidtoreplace = "" ;
      Combo_petitoriosubcategid_Datalisttype = "" ;
      Combo_petitoriosubcategid_Datalistfixedvalues = "" ;
      Combo_petitoriosubcategid_Htmltemplate = "" ;
      Combo_petitoriosubcategid_Multiplevaluestype = "" ;
      Combo_petitoriosubcategid_Loadingdata = "" ;
      Combo_petitoriosubcategid_Noresultsfound = "" ;
      Combo_petitoriosubcategid_Emptyitemtext = "" ;
      Combo_petitoriosubcategid_Onlyselectedvalues = "" ;
      Combo_petitoriosubcategid_Selectalltext = "" ;
      Combo_petitoriosubcategid_Multiplevaluesseparator = "" ;
      Combo_petitoriosubcategid_Addnewoptiontext = "" ;
      Combo_formafarmaceuticaid_Objectcall = "" ;
      Combo_formafarmaceuticaid_Class = "" ;
      Combo_formafarmaceuticaid_Icontype = "" ;
      Combo_formafarmaceuticaid_Icon = "" ;
      Combo_formafarmaceuticaid_Tooltip = "" ;
      Combo_formafarmaceuticaid_Selectedvalue_set = "" ;
      Combo_formafarmaceuticaid_Selectedtext_set = "" ;
      Combo_formafarmaceuticaid_Selectedtext_get = "" ;
      Combo_formafarmaceuticaid_Gamoauthtoken = "" ;
      Combo_formafarmaceuticaid_Ddointernalname = "" ;
      Combo_formafarmaceuticaid_Titlecontrolalign = "" ;
      Combo_formafarmaceuticaid_Dropdownoptionstype = "" ;
      Combo_formafarmaceuticaid_Titlecontrolidtoreplace = "" ;
      Combo_formafarmaceuticaid_Datalisttype = "" ;
      Combo_formafarmaceuticaid_Datalistfixedvalues = "" ;
      Combo_formafarmaceuticaid_Htmltemplate = "" ;
      Combo_formafarmaceuticaid_Multiplevaluestype = "" ;
      Combo_formafarmaceuticaid_Loadingdata = "" ;
      Combo_formafarmaceuticaid_Noresultsfound = "" ;
      Combo_formafarmaceuticaid_Emptyitemtext = "" ;
      Combo_formafarmaceuticaid_Onlyselectedvalues = "" ;
      Combo_formafarmaceuticaid_Selectalltext = "" ;
      Combo_formafarmaceuticaid_Multiplevaluesseparator = "" ;
      Combo_formafarmaceuticaid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode40 = "" ;
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
      AV15TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV20Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      AV19ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      T000V5_A49PetitorioCategId = new short[1] ;
      T000V7_A25PetitorioId = new short[1] ;
      T000V7_A262PetitorioPrincipioActivo = new String[] {""} ;
      T000V7_A263PetitorioProducto = new String[] {""} ;
      T000V7_A260PetitorioConcentracion = new String[] {""} ;
      T000V7_A261PetitorioPresentacion = new String[] {""} ;
      T000V7_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V7_A36DrogueriaId = new short[1] ;
      T000V7_A48PetitorioSubCategId = new short[1] ;
      T000V7_A39FormaFarmaceuticaId = new short[1] ;
      T000V7_A49PetitorioCategId = new short[1] ;
      T000V4_A36DrogueriaId = new short[1] ;
      T000V6_A39FormaFarmaceuticaId = new short[1] ;
      T000V8_A36DrogueriaId = new short[1] ;
      T000V9_A49PetitorioCategId = new short[1] ;
      T000V10_A39FormaFarmaceuticaId = new short[1] ;
      T000V11_A25PetitorioId = new short[1] ;
      T000V3_A25PetitorioId = new short[1] ;
      T000V3_A262PetitorioPrincipioActivo = new String[] {""} ;
      T000V3_A263PetitorioProducto = new String[] {""} ;
      T000V3_A260PetitorioConcentracion = new String[] {""} ;
      T000V3_A261PetitorioPresentacion = new String[] {""} ;
      T000V3_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V3_A36DrogueriaId = new short[1] ;
      T000V3_A48PetitorioSubCategId = new short[1] ;
      T000V3_A39FormaFarmaceuticaId = new short[1] ;
      T000V12_A25PetitorioId = new short[1] ;
      T000V13_A25PetitorioId = new short[1] ;
      T000V2_A25PetitorioId = new short[1] ;
      T000V2_A262PetitorioPrincipioActivo = new String[] {""} ;
      T000V2_A263PetitorioProducto = new String[] {""} ;
      T000V2_A260PetitorioConcentracion = new String[] {""} ;
      T000V2_A261PetitorioPresentacion = new String[] {""} ;
      T000V2_A264PetitorioPrecio = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000V2_A36DrogueriaId = new short[1] ;
      T000V2_A48PetitorioSubCategId = new short[1] ;
      T000V2_A39FormaFarmaceuticaId = new short[1] ;
      T000V14_A25PetitorioId = new short[1] ;
      T000V17_A49PetitorioCategId = new short[1] ;
      T000V18_A24CitaRecetaId = new int[1] ;
      T000V19_A25PetitorioId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      T000V20_A36DrogueriaId = new short[1] ;
      T000V21_A39FormaFarmaceuticaId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.petitorio__default(),
         new Object[] {
             new Object[] {
            T000V2_A25PetitorioId, T000V2_A262PetitorioPrincipioActivo, T000V2_A263PetitorioProducto, T000V2_A260PetitorioConcentracion, T000V2_A261PetitorioPresentacion, T000V2_A264PetitorioPrecio, T000V2_A36DrogueriaId, T000V2_A48PetitorioSubCategId, T000V2_A39FormaFarmaceuticaId
            }
            , new Object[] {
            T000V3_A25PetitorioId, T000V3_A262PetitorioPrincipioActivo, T000V3_A263PetitorioProducto, T000V3_A260PetitorioConcentracion, T000V3_A261PetitorioPresentacion, T000V3_A264PetitorioPrecio, T000V3_A36DrogueriaId, T000V3_A48PetitorioSubCategId, T000V3_A39FormaFarmaceuticaId
            }
            , new Object[] {
            T000V4_A36DrogueriaId
            }
            , new Object[] {
            T000V5_A49PetitorioCategId
            }
            , new Object[] {
            T000V6_A39FormaFarmaceuticaId
            }
            , new Object[] {
            T000V7_A25PetitorioId, T000V7_A262PetitorioPrincipioActivo, T000V7_A263PetitorioProducto, T000V7_A260PetitorioConcentracion, T000V7_A261PetitorioPresentacion, T000V7_A264PetitorioPrecio, T000V7_A36DrogueriaId, T000V7_A48PetitorioSubCategId, T000V7_A39FormaFarmaceuticaId, T000V7_A49PetitorioCategId
            }
            , new Object[] {
            T000V8_A36DrogueriaId
            }
            , new Object[] {
            T000V9_A49PetitorioCategId
            }
            , new Object[] {
            T000V10_A39FormaFarmaceuticaId
            }
            , new Object[] {
            T000V11_A25PetitorioId
            }
            , new Object[] {
            T000V12_A25PetitorioId
            }
            , new Object[] {
            T000V13_A25PetitorioId
            }
            , new Object[] {
            T000V14_A25PetitorioId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000V17_A49PetitorioCategId
            }
            , new Object[] {
            T000V18_A24CitaRecetaId
            }
            , new Object[] {
            T000V19_A25PetitorioId
            }
            , new Object[] {
            T000V20_A36DrogueriaId
            }
            , new Object[] {
            T000V21_A39FormaFarmaceuticaId
            }
         }
      );
      AV27Pgmname = "Petitorio" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV26PetitorioId ;
   private short Z25PetitorioId ;
   private short Z36DrogueriaId ;
   private short Z48PetitorioSubCategId ;
   private short Z39FormaFarmaceuticaId ;
   private short N36DrogueriaId ;
   private short N48PetitorioSubCategId ;
   private short N39FormaFarmaceuticaId ;
   private short A36DrogueriaId ;
   private short A48PetitorioSubCategId ;
   private short A39FormaFarmaceuticaId ;
   private short AV26PetitorioId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A25PetitorioId ;
   private short A49PetitorioCategId ;
   private short AV21ComboDrogueriaId ;
   private short AV23ComboPetitorioSubCategId ;
   private short AV25ComboFormaFarmaceuticaId ;
   private short AV12Insert_DrogueriaId ;
   private short AV13Insert_PetitorioSubCategId ;
   private short AV14Insert_FormaFarmaceuticaId ;
   private short RcdFound40 ;
   private short Z49PetitorioCategId ;
   private short nIsDirty_40 ;
   private int trnEnded ;
   private int edtPetitorioId_Enabled ;
   private int edtDrogueriaId_Visible ;
   private int edtDrogueriaId_Enabled ;
   private int edtPetitorioPrincipioActivo_Enabled ;
   private int edtPetitorioProducto_Enabled ;
   private int edtPetitorioCategId_Enabled ;
   private int edtPetitorioSubCategId_Visible ;
   private int edtPetitorioSubCategId_Enabled ;
   private int edtPetitorioConcentracion_Enabled ;
   private int edtFormaFarmaceuticaId_Visible ;
   private int edtFormaFarmaceuticaId_Enabled ;
   private int edtPetitorioPresentacion_Enabled ;
   private int edtPetitorioPrecio_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombodrogueriaid_Enabled ;
   private int edtavCombodrogueriaid_Visible ;
   private int edtavCombopetitoriosubcategid_Enabled ;
   private int edtavCombopetitoriosubcategid_Visible ;
   private int edtavComboformafarmaceuticaid_Enabled ;
   private int edtavComboformafarmaceuticaid_Visible ;
   private int Combo_drogueriaid_Datalistupdateminimumcharacters ;
   private int Combo_petitoriosubcategid_Datalistupdateminimumcharacters ;
   private int Combo_formafarmaceuticaid_Datalistupdateminimumcharacters ;
   private int AV28GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z264PetitorioPrecio ;
   private java.math.BigDecimal A264PetitorioPrecio ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Combo_formafarmaceuticaid_Selectedvalue_get ;
   private String Combo_petitoriosubcategid_Selectedvalue_get ;
   private String Combo_drogueriaid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtDrogueriaId_Internalname ;
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
   private String edtPetitorioId_Internalname ;
   private String edtPetitorioId_Jsonclick ;
   private String divTablesplitteddrogueriaid_Internalname ;
   private String lblTextblockdrogueriaid_Internalname ;
   private String lblTextblockdrogueriaid_Jsonclick ;
   private String Combo_drogueriaid_Caption ;
   private String Combo_drogueriaid_Cls ;
   private String Combo_drogueriaid_Datalistproc ;
   private String Combo_drogueriaid_Datalistprocparametersprefix ;
   private String Combo_drogueriaid_Internalname ;
   private String TempTags ;
   private String edtDrogueriaId_Jsonclick ;
   private String edtPetitorioPrincipioActivo_Internalname ;
   private String edtPetitorioProducto_Internalname ;
   private String edtPetitorioProducto_Jsonclick ;
   private String edtPetitorioCategId_Internalname ;
   private String edtPetitorioCategId_Jsonclick ;
   private String divTablesplittedpetitoriosubcategid_Internalname ;
   private String lblTextblockpetitoriosubcategid_Internalname ;
   private String lblTextblockpetitoriosubcategid_Jsonclick ;
   private String Combo_petitoriosubcategid_Caption ;
   private String Combo_petitoriosubcategid_Cls ;
   private String Combo_petitoriosubcategid_Datalistproc ;
   private String Combo_petitoriosubcategid_Datalistprocparametersprefix ;
   private String Combo_petitoriosubcategid_Internalname ;
   private String edtPetitorioSubCategId_Internalname ;
   private String edtPetitorioSubCategId_Jsonclick ;
   private String edtPetitorioConcentracion_Internalname ;
   private String edtPetitorioConcentracion_Jsonclick ;
   private String divTablesplittedformafarmaceuticaid_Internalname ;
   private String lblTextblockformafarmaceuticaid_Internalname ;
   private String lblTextblockformafarmaceuticaid_Jsonclick ;
   private String Combo_formafarmaceuticaid_Caption ;
   private String Combo_formafarmaceuticaid_Cls ;
   private String Combo_formafarmaceuticaid_Datalistproc ;
   private String Combo_formafarmaceuticaid_Datalistprocparametersprefix ;
   private String Combo_formafarmaceuticaid_Internalname ;
   private String edtFormaFarmaceuticaId_Internalname ;
   private String edtFormaFarmaceuticaId_Jsonclick ;
   private String edtPetitorioPresentacion_Internalname ;
   private String edtPetitorioPresentacion_Jsonclick ;
   private String edtPetitorioPrecio_Internalname ;
   private String edtPetitorioPrecio_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_drogueriaid_Internalname ;
   private String edtavCombodrogueriaid_Internalname ;
   private String edtavCombodrogueriaid_Jsonclick ;
   private String divSectionattribute_petitoriosubcategid_Internalname ;
   private String edtavCombopetitoriosubcategid_Internalname ;
   private String edtavCombopetitoriosubcategid_Jsonclick ;
   private String divSectionattribute_formafarmaceuticaid_Internalname ;
   private String edtavComboformafarmaceuticaid_Internalname ;
   private String edtavComboformafarmaceuticaid_Jsonclick ;
   private String AV27Pgmname ;
   private String Combo_drogueriaid_Objectcall ;
   private String Combo_drogueriaid_Class ;
   private String Combo_drogueriaid_Icontype ;
   private String Combo_drogueriaid_Icon ;
   private String Combo_drogueriaid_Tooltip ;
   private String Combo_drogueriaid_Selectedvalue_set ;
   private String Combo_drogueriaid_Selectedtext_set ;
   private String Combo_drogueriaid_Selectedtext_get ;
   private String Combo_drogueriaid_Gamoauthtoken ;
   private String Combo_drogueriaid_Ddointernalname ;
   private String Combo_drogueriaid_Titlecontrolalign ;
   private String Combo_drogueriaid_Dropdownoptionstype ;
   private String Combo_drogueriaid_Titlecontrolidtoreplace ;
   private String Combo_drogueriaid_Datalisttype ;
   private String Combo_drogueriaid_Datalistfixedvalues ;
   private String Combo_drogueriaid_Htmltemplate ;
   private String Combo_drogueriaid_Multiplevaluestype ;
   private String Combo_drogueriaid_Loadingdata ;
   private String Combo_drogueriaid_Noresultsfound ;
   private String Combo_drogueriaid_Emptyitemtext ;
   private String Combo_drogueriaid_Onlyselectedvalues ;
   private String Combo_drogueriaid_Selectalltext ;
   private String Combo_drogueriaid_Multiplevaluesseparator ;
   private String Combo_drogueriaid_Addnewoptiontext ;
   private String Combo_petitoriosubcategid_Objectcall ;
   private String Combo_petitoriosubcategid_Class ;
   private String Combo_petitoriosubcategid_Icontype ;
   private String Combo_petitoriosubcategid_Icon ;
   private String Combo_petitoriosubcategid_Tooltip ;
   private String Combo_petitoriosubcategid_Selectedvalue_set ;
   private String Combo_petitoriosubcategid_Selectedtext_set ;
   private String Combo_petitoriosubcategid_Selectedtext_get ;
   private String Combo_petitoriosubcategid_Gamoauthtoken ;
   private String Combo_petitoriosubcategid_Ddointernalname ;
   private String Combo_petitoriosubcategid_Titlecontrolalign ;
   private String Combo_petitoriosubcategid_Dropdownoptionstype ;
   private String Combo_petitoriosubcategid_Titlecontrolidtoreplace ;
   private String Combo_petitoriosubcategid_Datalisttype ;
   private String Combo_petitoriosubcategid_Datalistfixedvalues ;
   private String Combo_petitoriosubcategid_Htmltemplate ;
   private String Combo_petitoriosubcategid_Multiplevaluestype ;
   private String Combo_petitoriosubcategid_Loadingdata ;
   private String Combo_petitoriosubcategid_Noresultsfound ;
   private String Combo_petitoriosubcategid_Emptyitemtext ;
   private String Combo_petitoriosubcategid_Onlyselectedvalues ;
   private String Combo_petitoriosubcategid_Selectalltext ;
   private String Combo_petitoriosubcategid_Multiplevaluesseparator ;
   private String Combo_petitoriosubcategid_Addnewoptiontext ;
   private String Combo_formafarmaceuticaid_Objectcall ;
   private String Combo_formafarmaceuticaid_Class ;
   private String Combo_formafarmaceuticaid_Icontype ;
   private String Combo_formafarmaceuticaid_Icon ;
   private String Combo_formafarmaceuticaid_Tooltip ;
   private String Combo_formafarmaceuticaid_Selectedvalue_set ;
   private String Combo_formafarmaceuticaid_Selectedtext_set ;
   private String Combo_formafarmaceuticaid_Selectedtext_get ;
   private String Combo_formafarmaceuticaid_Gamoauthtoken ;
   private String Combo_formafarmaceuticaid_Ddointernalname ;
   private String Combo_formafarmaceuticaid_Titlecontrolalign ;
   private String Combo_formafarmaceuticaid_Dropdownoptionstype ;
   private String Combo_formafarmaceuticaid_Titlecontrolidtoreplace ;
   private String Combo_formafarmaceuticaid_Datalisttype ;
   private String Combo_formafarmaceuticaid_Datalistfixedvalues ;
   private String Combo_formafarmaceuticaid_Htmltemplate ;
   private String Combo_formafarmaceuticaid_Multiplevaluestype ;
   private String Combo_formafarmaceuticaid_Loadingdata ;
   private String Combo_formafarmaceuticaid_Noresultsfound ;
   private String Combo_formafarmaceuticaid_Emptyitemtext ;
   private String Combo_formafarmaceuticaid_Onlyselectedvalues ;
   private String Combo_formafarmaceuticaid_Selectalltext ;
   private String Combo_formafarmaceuticaid_Multiplevaluesseparator ;
   private String Combo_formafarmaceuticaid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode40 ;
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
   private boolean Combo_drogueriaid_Emptyitem ;
   private boolean Combo_petitoriosubcategid_Emptyitem ;
   private boolean Combo_formafarmaceuticaid_Emptyitem ;
   private boolean Combo_drogueriaid_Enabled ;
   private boolean Combo_drogueriaid_Visible ;
   private boolean Combo_drogueriaid_Allowmultipleselection ;
   private boolean Combo_drogueriaid_Isgriditem ;
   private boolean Combo_drogueriaid_Hasdescription ;
   private boolean Combo_drogueriaid_Includeonlyselectedoption ;
   private boolean Combo_drogueriaid_Includeselectalloption ;
   private boolean Combo_drogueriaid_Includeaddnewoption ;
   private boolean Combo_petitoriosubcategid_Enabled ;
   private boolean Combo_petitoriosubcategid_Visible ;
   private boolean Combo_petitoriosubcategid_Allowmultipleselection ;
   private boolean Combo_petitoriosubcategid_Isgriditem ;
   private boolean Combo_petitoriosubcategid_Hasdescription ;
   private boolean Combo_petitoriosubcategid_Includeonlyselectedoption ;
   private boolean Combo_petitoriosubcategid_Includeselectalloption ;
   private boolean Combo_petitoriosubcategid_Includeaddnewoption ;
   private boolean Combo_formafarmaceuticaid_Enabled ;
   private boolean Combo_formafarmaceuticaid_Visible ;
   private boolean Combo_formafarmaceuticaid_Allowmultipleselection ;
   private boolean Combo_formafarmaceuticaid_Isgriditem ;
   private boolean Combo_formafarmaceuticaid_Hasdescription ;
   private boolean Combo_formafarmaceuticaid_Includeonlyselectedoption ;
   private boolean Combo_formafarmaceuticaid_Includeselectalloption ;
   private boolean Combo_formafarmaceuticaid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV20Combo_DataJson ;
   private String Z262PetitorioPrincipioActivo ;
   private String Z263PetitorioProducto ;
   private String Z260PetitorioConcentracion ;
   private String Z261PetitorioPresentacion ;
   private String A262PetitorioPrincipioActivo ;
   private String A263PetitorioProducto ;
   private String A260PetitorioConcentracion ;
   private String A261PetitorioPresentacion ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_drogueriaid ;
   private com.genexus.webpanels.GXUserControl ucCombo_petitoriosubcategid ;
   private com.genexus.webpanels.GXUserControl ucCombo_formafarmaceuticaid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T000V5_A49PetitorioCategId ;
   private short[] T000V7_A25PetitorioId ;
   private String[] T000V7_A262PetitorioPrincipioActivo ;
   private String[] T000V7_A263PetitorioProducto ;
   private String[] T000V7_A260PetitorioConcentracion ;
   private String[] T000V7_A261PetitorioPresentacion ;
   private java.math.BigDecimal[] T000V7_A264PetitorioPrecio ;
   private short[] T000V7_A36DrogueriaId ;
   private short[] T000V7_A48PetitorioSubCategId ;
   private short[] T000V7_A39FormaFarmaceuticaId ;
   private short[] T000V7_A49PetitorioCategId ;
   private short[] T000V4_A36DrogueriaId ;
   private short[] T000V6_A39FormaFarmaceuticaId ;
   private short[] T000V8_A36DrogueriaId ;
   private short[] T000V9_A49PetitorioCategId ;
   private short[] T000V10_A39FormaFarmaceuticaId ;
   private short[] T000V11_A25PetitorioId ;
   private short[] T000V3_A25PetitorioId ;
   private String[] T000V3_A262PetitorioPrincipioActivo ;
   private String[] T000V3_A263PetitorioProducto ;
   private String[] T000V3_A260PetitorioConcentracion ;
   private String[] T000V3_A261PetitorioPresentacion ;
   private java.math.BigDecimal[] T000V3_A264PetitorioPrecio ;
   private short[] T000V3_A36DrogueriaId ;
   private short[] T000V3_A48PetitorioSubCategId ;
   private short[] T000V3_A39FormaFarmaceuticaId ;
   private short[] T000V12_A25PetitorioId ;
   private short[] T000V13_A25PetitorioId ;
   private short[] T000V2_A25PetitorioId ;
   private String[] T000V2_A262PetitorioPrincipioActivo ;
   private String[] T000V2_A263PetitorioProducto ;
   private String[] T000V2_A260PetitorioConcentracion ;
   private String[] T000V2_A261PetitorioPresentacion ;
   private java.math.BigDecimal[] T000V2_A264PetitorioPrecio ;
   private short[] T000V2_A36DrogueriaId ;
   private short[] T000V2_A48PetitorioSubCategId ;
   private short[] T000V2_A39FormaFarmaceuticaId ;
   private short[] T000V14_A25PetitorioId ;
   private short[] T000V17_A49PetitorioCategId ;
   private int[] T000V18_A24CitaRecetaId ;
   private short[] T000V19_A25PetitorioId ;
   private short[] T000V20_A36DrogueriaId ;
   private short[] T000V21_A39FormaFarmaceuticaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16DrogueriaId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22PetitorioSubCategId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV24FormaFarmaceuticaId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class petitorio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000V2", "SELECT [PetitorioId], [PetitorioPrincipioActivo], [PetitorioProducto], [PetitorioConcentracion], [PetitorioPresentacion], [PetitorioPrecio], [DrogueriaId], [PetitorioSubCategId], [FormaFarmaceuticaId] FROM [Petitorio] WITH (UPDLOCK) WHERE [PetitorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V3", "SELECT [PetitorioId], [PetitorioPrincipioActivo], [PetitorioProducto], [PetitorioConcentracion], [PetitorioPresentacion], [PetitorioPrecio], [DrogueriaId], [PetitorioSubCategId], [FormaFarmaceuticaId] FROM [Petitorio] WHERE [PetitorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V4", "SELECT [DrogueriaId] FROM [Drogueria] WHERE [DrogueriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V5", "SELECT [PetitorioCategId] FROM [PetitorioSubCateg] WHERE [PetitorioSubCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V6", "SELECT [FormaFarmaceuticaId] FROM [FormaFarmaceutica] WHERE [FormaFarmaceuticaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V7", "SELECT TM1.[PetitorioId], TM1.[PetitorioPrincipioActivo], TM1.[PetitorioProducto], TM1.[PetitorioConcentracion], TM1.[PetitorioPresentacion], TM1.[PetitorioPrecio], TM1.[DrogueriaId], TM1.[PetitorioSubCategId], TM1.[FormaFarmaceuticaId], T2.[PetitorioCategId] FROM ([Petitorio] TM1 INNER JOIN [PetitorioSubCateg] T2 ON T2.[PetitorioSubCategId] = TM1.[PetitorioSubCategId]) WHERE TM1.[PetitorioId] = ? ORDER BY TM1.[PetitorioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V8", "SELECT [DrogueriaId] FROM [Drogueria] WHERE [DrogueriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V9", "SELECT [PetitorioCategId] FROM [PetitorioSubCateg] WHERE [PetitorioSubCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V10", "SELECT [FormaFarmaceuticaId] FROM [FormaFarmaceutica] WHERE [FormaFarmaceuticaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V11", "SELECT [PetitorioId] FROM [Petitorio] WHERE [PetitorioId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V12", "SELECT TOP 1 [PetitorioId] FROM [Petitorio] WHERE ( [PetitorioId] > ?) ORDER BY [PetitorioId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V13", "SELECT TOP 1 [PetitorioId] FROM [Petitorio] WHERE ( [PetitorioId] < ?) ORDER BY [PetitorioId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V14", "INSERT INTO [Petitorio]([PetitorioPrincipioActivo], [PetitorioProducto], [PetitorioConcentracion], [PetitorioPresentacion], [PetitorioPrecio], [DrogueriaId], [PetitorioSubCategId], [FormaFarmaceuticaId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000V15", "UPDATE [Petitorio] SET [PetitorioPrincipioActivo]=?, [PetitorioProducto]=?, [PetitorioConcentracion]=?, [PetitorioPresentacion]=?, [PetitorioPrecio]=?, [DrogueriaId]=?, [PetitorioSubCategId]=?, [FormaFarmaceuticaId]=?  WHERE [PetitorioId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000V16", "DELETE FROM [Petitorio]  WHERE [PetitorioId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000V17", "SELECT [PetitorioCategId] FROM [PetitorioSubCateg] WHERE [PetitorioSubCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V18", "SELECT TOP 1 [CitaRecetaId] FROM [CitaReceta] WHERE [PetitorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000V19", "SELECT [PetitorioId] FROM [Petitorio] ORDER BY [PetitorioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V20", "SELECT [DrogueriaId] FROM [Drogueria] WHERE [DrogueriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000V21", "SELECT [FormaFarmaceuticaId] FROM [FormaFarmaceutica] WHERE [FormaFarmaceuticaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setVarchar(1, (String)parms[0], 200, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 200, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
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
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

