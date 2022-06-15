package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class serviciocateg_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"LABORATORIOID") == 0 )
      {
         AV12Insert_LaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "Insert_LaboratorioId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_LaboratorioId), 4, 0));
         AV19ComboLaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "ComboLaboratorioId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19ComboLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboLaboratorioId), 4, 0));
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx6asalaboratorioid1147( AV12Insert_LaboratorioId, AV19ComboLaboratorioId, Gx_BScreen) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_10") == 0 )
      {
         A40LaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "LaboratorioId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_10( A40LaboratorioId) ;
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
            AV20ServicioCategId = (short)(GXutil.lval( httpContext.GetPar( "ServicioCategId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20ServicioCategId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSERVICIOCATEGID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20ServicioCategId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Servicio Categ", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLaboratorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public serviciocateg_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public serviciocateg_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( serviciocateg_impl.class ));
   }

   public serviciocateg_impl( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbServicioCategEstado = new HTMLChoice();
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
      if ( cmbServicioCategEstado.getItemCount() > 0 )
      {
         A290ServicioCategEstado = cmbServicioCategEstado.getValidValue(A290ServicioCategEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A290ServicioCategEstado", A290ServicioCategEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbServicioCategEstado.setValue( GXutil.rtrim( A290ServicioCategEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbServicioCategEstado.getInternalname(), "Values", cmbServicioCategEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioCategId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioCategId_Internalname, "Categ Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioCategId_Internalname, GXutil.ltrim( localUtil.ntoc( A52ServicioCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtServicioCategId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioCategId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtServicioCategId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_ServicioCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedlaboratorioid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklaboratorioid_Internalname, "Laboratorio Id", "", "", lblTextblocklaboratorioid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_ServicioCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_laboratorioid.setProperty("Caption", Combo_laboratorioid_Caption);
      ucCombo_laboratorioid.setProperty("Cls", Combo_laboratorioid_Cls);
      ucCombo_laboratorioid.setProperty("DataListProc", Combo_laboratorioid_Datalistproc);
      ucCombo_laboratorioid.setProperty("DataListProcParametersPrefix", Combo_laboratorioid_Datalistprocparametersprefix);
      ucCombo_laboratorioid.setProperty("EmptyItem", Combo_laboratorioid_Emptyitem);
      ucCombo_laboratorioid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_laboratorioid.setProperty("DropDownOptionsData", AV14LaboratorioId_Data);
      ucCombo_laboratorioid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_laboratorioid_Internalname, "COMBO_LABORATORIOIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioId_Internalname, "Laboratorio Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioId_Internalname, GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioId_Jsonclick, 0, "Attribute", "", "", "", "", edtLaboratorioId_Visible, edtLaboratorioId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_ServicioCateg.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioNombre_Internalname, "Laboratorio Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioNombre_Internalname, A165LaboratorioNombre, GXutil.rtrim( localUtil.format( A165LaboratorioNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtLaboratorioNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ServicioCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioCategNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioCategNombre_Internalname, "Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioCategNombre_Internalname, A287ServicioCategNombre, GXutil.rtrim( localUtil.format( A287ServicioCategNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioCategNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtServicioCategNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_ServicioCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioCategDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioCategDescripcion_Internalname, "Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtServicioCategDescripcion_Internalname, A288ServicioCategDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", (short)(0), 1, edtServicioCategDescripcion_Enabled, 0, 80, "chr", 7, "row", StyleString, ClassString, "", "", "500", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ServicioCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgServicioCategImagen_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Imagen", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A289ServicioCategImagen_IsBlob = (boolean)(((GXutil.strcmp("", A289ServicioCategImagen)==0)&&(GXutil.strcmp("", A40000ServicioCategImagen_GXI)==0))||!(GXutil.strcmp("", A289ServicioCategImagen)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.getResourceRelative(A289ServicioCategImagen)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgServicioCategImagen_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgServicioCategImagen_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", "", "", 0, A289ServicioCategImagen_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ServicioCateg.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "URL", ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.getResourceRelative(A289ServicioCategImagen)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "IsBlob", GXutil.booltostr( A289ServicioCategImagen_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbServicioCategEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbServicioCategEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbServicioCategEstado, cmbServicioCategEstado.getInternalname(), GXutil.rtrim( A290ServicioCategEstado), 1, cmbServicioCategEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbServicioCategEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(1), "HLP_ServicioCateg.htm");
      cmbServicioCategEstado.setValue( GXutil.rtrim( A290ServicioCategEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbServicioCategEstado.getInternalname(), "Values", cmbServicioCategEstado.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ServicioCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ServicioCateg.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ServicioCateg.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_laboratorioid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombolaboratorioid_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboLaboratorioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombolaboratorioid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboLaboratorioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboLaboratorioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombolaboratorioid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombolaboratorioid_Visible, edtavCombolaboratorioid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ServicioCateg.htm");
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
      e11112 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vLABORATORIOID_DATA"), AV14LaboratorioId_Data);
            /* Read saved values. */
            Z52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "Z52ServicioCategId"), ",", ".")) ;
            Z287ServicioCategNombre = httpContext.cgiGet( "Z287ServicioCategNombre") ;
            Z288ServicioCategDescripcion = httpContext.cgiGet( "Z288ServicioCategDescripcion") ;
            n288ServicioCategDescripcion = ((GXutil.strcmp("", A288ServicioCategDescripcion)==0) ? true : false) ;
            Z290ServicioCategEstado = httpContext.cgiGet( "Z290ServicioCategEstado") ;
            Z40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( "Z40LaboratorioId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( "N40LaboratorioId"), ",", ".")) ;
            AV20ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "vSERVICIOCATEGID"), ",", ".")) ;
            AV12Insert_LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_LABORATORIOID"), ",", ".")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            A40000ServicioCategImagen_GXI = httpContext.cgiGet( "SERVICIOCATEGIMAGEN_GXI") ;
            n40000ServicioCategImagen_GXI = ((GXutil.strcmp("", A40000ServicioCategImagen_GXI)==0)&&(GXutil.strcmp("", A289ServicioCategImagen)==0) ? true : false) ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_laboratorioid_Objectcall = httpContext.cgiGet( "COMBO_LABORATORIOID_Objectcall") ;
            Combo_laboratorioid_Class = httpContext.cgiGet( "COMBO_LABORATORIOID_Class") ;
            Combo_laboratorioid_Icontype = httpContext.cgiGet( "COMBO_LABORATORIOID_Icontype") ;
            Combo_laboratorioid_Icon = httpContext.cgiGet( "COMBO_LABORATORIOID_Icon") ;
            Combo_laboratorioid_Caption = httpContext.cgiGet( "COMBO_LABORATORIOID_Caption") ;
            Combo_laboratorioid_Tooltip = httpContext.cgiGet( "COMBO_LABORATORIOID_Tooltip") ;
            Combo_laboratorioid_Cls = httpContext.cgiGet( "COMBO_LABORATORIOID_Cls") ;
            Combo_laboratorioid_Selectedvalue_set = httpContext.cgiGet( "COMBO_LABORATORIOID_Selectedvalue_set") ;
            Combo_laboratorioid_Selectedvalue_get = httpContext.cgiGet( "COMBO_LABORATORIOID_Selectedvalue_get") ;
            Combo_laboratorioid_Selectedtext_set = httpContext.cgiGet( "COMBO_LABORATORIOID_Selectedtext_set") ;
            Combo_laboratorioid_Selectedtext_get = httpContext.cgiGet( "COMBO_LABORATORIOID_Selectedtext_get") ;
            Combo_laboratorioid_Gamoauthtoken = httpContext.cgiGet( "COMBO_LABORATORIOID_Gamoauthtoken") ;
            Combo_laboratorioid_Ddointernalname = httpContext.cgiGet( "COMBO_LABORATORIOID_Ddointernalname") ;
            Combo_laboratorioid_Titlecontrolalign = httpContext.cgiGet( "COMBO_LABORATORIOID_Titlecontrolalign") ;
            Combo_laboratorioid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_LABORATORIOID_Dropdownoptionstype") ;
            Combo_laboratorioid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Enabled")) ;
            Combo_laboratorioid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Visible")) ;
            Combo_laboratorioid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_LABORATORIOID_Titlecontrolidtoreplace") ;
            Combo_laboratorioid_Datalisttype = httpContext.cgiGet( "COMBO_LABORATORIOID_Datalisttype") ;
            Combo_laboratorioid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Allowmultipleselection")) ;
            Combo_laboratorioid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_LABORATORIOID_Datalistfixedvalues") ;
            Combo_laboratorioid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Isgriditem")) ;
            Combo_laboratorioid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Hasdescription")) ;
            Combo_laboratorioid_Datalistproc = httpContext.cgiGet( "COMBO_LABORATORIOID_Datalistproc") ;
            Combo_laboratorioid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_LABORATORIOID_Datalistprocparametersprefix") ;
            Combo_laboratorioid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_LABORATORIOID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_laboratorioid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Includeonlyselectedoption")) ;
            Combo_laboratorioid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Includeselectalloption")) ;
            Combo_laboratorioid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Emptyitem")) ;
            Combo_laboratorioid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_LABORATORIOID_Includeaddnewoption")) ;
            Combo_laboratorioid_Htmltemplate = httpContext.cgiGet( "COMBO_LABORATORIOID_Htmltemplate") ;
            Combo_laboratorioid_Multiplevaluestype = httpContext.cgiGet( "COMBO_LABORATORIOID_Multiplevaluestype") ;
            Combo_laboratorioid_Loadingdata = httpContext.cgiGet( "COMBO_LABORATORIOID_Loadingdata") ;
            Combo_laboratorioid_Noresultsfound = httpContext.cgiGet( "COMBO_LABORATORIOID_Noresultsfound") ;
            Combo_laboratorioid_Emptyitemtext = httpContext.cgiGet( "COMBO_LABORATORIOID_Emptyitemtext") ;
            Combo_laboratorioid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_LABORATORIOID_Onlyselectedvalues") ;
            Combo_laboratorioid_Selectalltext = httpContext.cgiGet( "COMBO_LABORATORIOID_Selectalltext") ;
            Combo_laboratorioid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_LABORATORIOID_Multiplevaluesseparator") ;
            Combo_laboratorioid_Addnewoptiontext = httpContext.cgiGet( "COMBO_LABORATORIOID_Addnewoptiontext") ;
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
            A52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioCategId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LABORATORIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLaboratorioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A40LaboratorioId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            }
            else
            {
               A40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            }
            A165LaboratorioNombre = httpContext.cgiGet( edtLaboratorioNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
            A287ServicioCategNombre = httpContext.cgiGet( edtServicioCategNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A287ServicioCategNombre", A287ServicioCategNombre);
            A288ServicioCategDescripcion = httpContext.cgiGet( edtServicioCategDescripcion_Internalname) ;
            n288ServicioCategDescripcion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A288ServicioCategDescripcion", A288ServicioCategDescripcion);
            n288ServicioCategDescripcion = ((GXutil.strcmp("", A288ServicioCategDescripcion)==0) ? true : false) ;
            A289ServicioCategImagen = httpContext.cgiGet( imgServicioCategImagen_Internalname) ;
            n289ServicioCategImagen = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A289ServicioCategImagen", A289ServicioCategImagen);
            n289ServicioCategImagen = ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? true : false) ;
            cmbServicioCategEstado.setValue( httpContext.cgiGet( cmbServicioCategEstado.getInternalname()) );
            A290ServicioCategEstado = httpContext.cgiGet( cmbServicioCategEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A290ServicioCategEstado", A290ServicioCategEstado);
            AV19ComboLaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombolaboratorioid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboLaboratorioId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A289ServicioCategImagen ;
            GXv_char2[0] = A40000ServicioCategImagen_GXI ;
            httpContext.getMultimediaValue(imgServicioCategImagen_Internalname, GXv_char1, GXv_char2);
            serviciocateg_impl.this.A289ServicioCategImagen = GXv_char1[0] ;
            n289ServicioCategImagen = ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? true : false) ;
            serviciocateg_impl.this.A40000ServicioCategImagen_GXI = GXv_char2[0] ;
            n40000ServicioCategImagen_GXI = ((GXutil.strcmp("", A40000ServicioCategImagen_GXI)==0)&&(GXutil.strcmp("", A289ServicioCategImagen)==0) ? true : false) ;
            n40000ServicioCategImagen_GXI = ((GXutil.strcmp("", A40000ServicioCategImagen_GXI)==0)&&(GXutil.strcmp("", A289ServicioCategImagen)==0) ? true : false) ;
            n289ServicioCategImagen = ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? true : false) ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"ServicioCateg");
            A52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioCategId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
            forbiddenHiddens.add("ServicioCategId", localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A52ServicioCategId != Z52ServicioCategId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("serviciocateg:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A52ServicioCategId = (short)(GXutil.lval( httpContext.GetPar( "ServicioCategId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
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
                  sMode47 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode47 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound47 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_110( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SERVICIOCATEGID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtServicioCategId_Internalname ;
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
                        e11112 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12112 ();
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
         e12112 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1147( ) ;
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
         disableAttributes1147( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolaboratorioid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolaboratorioid_Enabled), 5, 0), true);
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

   public void confirm_110( )
   {
      beforeValidate1147( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1147( ) ;
         }
         else
         {
            checkExtendedTable1147( ) ;
            closeExtendedTableCursors1147( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption110( )
   {
   }

   public void e11112( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV7WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      edtLaboratorioId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Visible), 5, 0), true);
      AV19ComboLaboratorioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboLaboratorioId), 4, 0));
      edtavCombolaboratorioid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolaboratorioid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolaboratorioid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOLABORATORIOID' */
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
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicioCateg_Insert", GXv_boolean7) ;
         serviciocateg_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicioCateg_Update", GXv_boolean7) ;
         serviciocateg_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicioCateg_Delete", GXv_boolean7) ;
         serviciocateg_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         while ( AV23GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LaboratorioId") == 0 )
            {
               AV12Insert_LaboratorioId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_LaboratorioId), 4, 0));
               if ( ! (0==AV12Insert_LaboratorioId) )
               {
                  AV19ComboLaboratorioId = AV12Insert_LaboratorioId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboLaboratorioId), 4, 0));
                  Combo_laboratorioid_Selectedvalue_set = GXutil.trim( GXutil.str( AV19ComboLaboratorioId, 4, 0)) ;
                  ucCombo_laboratorioid.sendProperty(context, "", false, Combo_laboratorioid_Internalname, "SelectedValue_set", Combo_laboratorioid_Selectedvalue_set);
                  GXt_char8 = AV18Combo_DataJson ;
                  GXv_char2[0] = AV16ComboSelectedValue ;
                  GXv_char1[0] = AV17ComboSelectedText ;
                  GXv_char9[0] = GXt_char8 ;
                  new com.projectthani.serviciocategloaddvcombo(remoteHandle, context).execute( "LaboratorioId", "GET", false, AV20ServicioCategId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char2, GXv_char1, GXv_char9) ;
                  serviciocateg_impl.this.AV16ComboSelectedValue = GXv_char2[0] ;
                  serviciocateg_impl.this.AV17ComboSelectedText = GXv_char1[0] ;
                  serviciocateg_impl.this.GXt_char8 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
                  AV18Combo_DataJson = GXt_char8 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
                  Combo_laboratorioid_Selectedtext_set = AV17ComboSelectedText ;
                  ucCombo_laboratorioid.sendProperty(context, "", false, Combo_laboratorioid_Internalname, "SelectedText_set", Combo_laboratorioid_Selectedtext_set);
                  Combo_laboratorioid_Enabled = false ;
                  ucCombo_laboratorioid.sendProperty(context, "", false, Combo_laboratorioid_Internalname, "Enabled", GXutil.booltostr( Combo_laboratorioid_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e12112( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.serviciocategww", new String[] {}, new String[] {}) );
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
      /* 'LOADCOMBOLABORATORIOID' Routine */
      returnInSub = false ;
      GXt_char8 = AV18Combo_DataJson ;
      GXv_char9[0] = AV16ComboSelectedValue ;
      GXv_char2[0] = AV17ComboSelectedText ;
      GXv_char1[0] = GXt_char8 ;
      new com.projectthani.serviciocategloaddvcombo(remoteHandle, context).execute( "LaboratorioId", Gx_mode, false, AV20ServicioCategId, "", GXv_char9, GXv_char2, GXv_char1) ;
      serviciocateg_impl.this.AV16ComboSelectedValue = GXv_char9[0] ;
      serviciocateg_impl.this.AV17ComboSelectedText = GXv_char2[0] ;
      serviciocateg_impl.this.GXt_char8 = GXv_char1[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
      AV18Combo_DataJson = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
      Combo_laboratorioid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_laboratorioid.sendProperty(context, "", false, Combo_laboratorioid_Internalname, "SelectedValue_set", Combo_laboratorioid_Selectedvalue_set);
      Combo_laboratorioid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_laboratorioid.sendProperty(context, "", false, Combo_laboratorioid_Internalname, "SelectedText_set", Combo_laboratorioid_Selectedtext_set);
      AV19ComboLaboratorioId = (short)(GXutil.lval( AV16ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboLaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboLaboratorioId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_laboratorioid_Enabled = false ;
         ucCombo_laboratorioid.sendProperty(context, "", false, Combo_laboratorioid_Internalname, "Enabled", GXutil.booltostr( Combo_laboratorioid_Enabled));
      }
   }

   public void zm1147( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z287ServicioCategNombre = T00113_A287ServicioCategNombre[0] ;
            Z288ServicioCategDescripcion = T00113_A288ServicioCategDescripcion[0] ;
            Z290ServicioCategEstado = T00113_A290ServicioCategEstado[0] ;
            Z40LaboratorioId = T00113_A40LaboratorioId[0] ;
         }
         else
         {
            Z287ServicioCategNombre = A287ServicioCategNombre ;
            Z288ServicioCategDescripcion = A288ServicioCategDescripcion ;
            Z290ServicioCategEstado = A290ServicioCategEstado ;
            Z40LaboratorioId = A40LaboratorioId ;
         }
      }
      if ( GX_JID == -9 )
      {
         Z52ServicioCategId = A52ServicioCategId ;
         Z287ServicioCategNombre = A287ServicioCategNombre ;
         Z288ServicioCategDescripcion = A288ServicioCategDescripcion ;
         Z289ServicioCategImagen = A289ServicioCategImagen ;
         Z40000ServicioCategImagen_GXI = A40000ServicioCategImagen_GXI ;
         Z290ServicioCategEstado = A290ServicioCategEstado ;
         Z40LaboratorioId = A40LaboratorioId ;
         Z165LaboratorioNombre = A165LaboratorioNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      edtServicioCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtServicioCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV20ServicioCategId) )
      {
         A52ServicioCategId = AV20ServicioCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_LaboratorioId) )
      {
         edtLaboratorioId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Enabled), 5, 0), true);
      }
      else
      {
         edtLaboratorioId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Enabled), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_LaboratorioId) )
      {
         A40LaboratorioId = AV12Insert_LaboratorioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      }
      else
      {
         if ( true )
         {
            A40LaboratorioId = AV19ComboLaboratorioId ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         }
         else
         {
            if ( isIns( )  && (0==A40LaboratorioId) && ( Gx_BScreen == 0 ) )
            {
               GXt_int10 = A40LaboratorioId ;
               GXv_int11[0] = GXt_int10 ;
               new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int11) ;
               serviciocateg_impl.this.GXt_int10 = GXv_int11[0] ;
               A40LaboratorioId = GXt_int10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV22Pgmname = "ServicioCateg" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T00114 */
         pr_default.execute(2, new Object[] {Short.valueOf(A40LaboratorioId)});
         A165LaboratorioNombre = T00114_A165LaboratorioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
         pr_default.close(2);
      }
   }

   public void load1147( )
   {
      /* Using cursor T00115 */
      pr_default.execute(3, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A165LaboratorioNombre = T00115_A165LaboratorioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
         A287ServicioCategNombre = T00115_A287ServicioCategNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A287ServicioCategNombre", A287ServicioCategNombre);
         A288ServicioCategDescripcion = T00115_A288ServicioCategDescripcion[0] ;
         n288ServicioCategDescripcion = T00115_n288ServicioCategDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A288ServicioCategDescripcion", A288ServicioCategDescripcion);
         A289ServicioCategImagen = T00115_A289ServicioCategImagen[0] ;
         n289ServicioCategImagen = T00115_n289ServicioCategImagen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A289ServicioCategImagen", A289ServicioCategImagen);
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A289ServicioCategImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A289ServicioCategImagen), true);
         A40000ServicioCategImagen_GXI = T00115_A40000ServicioCategImagen_GXI[0] ;
         n40000ServicioCategImagen_GXI = T00115_n40000ServicioCategImagen_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A289ServicioCategImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A289ServicioCategImagen), true);
         A290ServicioCategEstado = T00115_A290ServicioCategEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A290ServicioCategEstado", A290ServicioCategEstado);
         A40LaboratorioId = T00115_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         zm1147( -9) ;
      }
      pr_default.close(3);
      onLoadActions1147( ) ;
   }

   public void onLoadActions1147( )
   {
      AV22Pgmname = "ServicioCateg" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable1147( )
   {
      nIsDirty_47 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV22Pgmname = "ServicioCateg" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T00114 */
      pr_default.execute(2, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Laboratorio'.", "ForeignKeyNotFound", 1, "LABORATORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLaboratorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A165LaboratorioNombre = T00114_A165LaboratorioNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A290ServicioCategEstado, "A") == 0 ) || ( GXutil.strcmp(A290ServicioCategEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Categ Estado fuera de rango", "OutOfRange", 1, "SERVICIOCATEGESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbServicioCategEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1147( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_10( short A40LaboratorioId )
   {
      /* Using cursor T00116 */
      pr_default.execute(4, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Laboratorio'.", "ForeignKeyNotFound", 1, "LABORATORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLaboratorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A165LaboratorioNombre = T00116_A165LaboratorioNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A165LaboratorioNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey1147( )
   {
      /* Using cursor T00117 */
      pr_default.execute(5, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound47 = (short)(1) ;
      }
      else
      {
         RcdFound47 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00113 */
      pr_default.execute(1, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1147( 9) ;
         RcdFound47 = (short)(1) ;
         A52ServicioCategId = T00113_A52ServicioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
         A287ServicioCategNombre = T00113_A287ServicioCategNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A287ServicioCategNombre", A287ServicioCategNombre);
         A288ServicioCategDescripcion = T00113_A288ServicioCategDescripcion[0] ;
         n288ServicioCategDescripcion = T00113_n288ServicioCategDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A288ServicioCategDescripcion", A288ServicioCategDescripcion);
         A289ServicioCategImagen = T00113_A289ServicioCategImagen[0] ;
         n289ServicioCategImagen = T00113_n289ServicioCategImagen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A289ServicioCategImagen", A289ServicioCategImagen);
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A289ServicioCategImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A289ServicioCategImagen), true);
         A40000ServicioCategImagen_GXI = T00113_A40000ServicioCategImagen_GXI[0] ;
         n40000ServicioCategImagen_GXI = T00113_n40000ServicioCategImagen_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A289ServicioCategImagen))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A289ServicioCategImagen), true);
         A290ServicioCategEstado = T00113_A290ServicioCategEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A290ServicioCategEstado", A290ServicioCategEstado);
         A40LaboratorioId = T00113_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         Z52ServicioCategId = A52ServicioCategId ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1147( ) ;
         if ( AnyError == 1 )
         {
            RcdFound47 = (short)(0) ;
            initializeNonKey1147( ) ;
         }
         Gx_mode = sMode47 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound47 = (short)(0) ;
         initializeNonKey1147( ) ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode47 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1147( ) ;
      if ( RcdFound47 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound47 = (short)(0) ;
      /* Using cursor T00118 */
      pr_default.execute(6, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00118_A52ServicioCategId[0] < A52ServicioCategId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00118_A52ServicioCategId[0] > A52ServicioCategId ) ) )
         {
            A52ServicioCategId = T00118_A52ServicioCategId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
            RcdFound47 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound47 = (short)(0) ;
      /* Using cursor T00119 */
      pr_default.execute(7, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00119_A52ServicioCategId[0] > A52ServicioCategId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00119_A52ServicioCategId[0] < A52ServicioCategId ) ) )
         {
            A52ServicioCategId = T00119_A52ServicioCategId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
            RcdFound47 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1147( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLaboratorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1147( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound47 == 1 )
         {
            if ( A52ServicioCategId != Z52ServicioCategId )
            {
               A52ServicioCategId = Z52ServicioCategId ;
               httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SERVICIOCATEGID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtServicioCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLaboratorioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1147( ) ;
               GX_FocusControl = edtLaboratorioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A52ServicioCategId != Z52ServicioCategId )
            {
               /* Insert record */
               GX_FocusControl = edtLaboratorioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1147( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SERVICIOCATEGID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtServicioCategId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtLaboratorioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1147( ) ;
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
      if ( A52ServicioCategId != Z52ServicioCategId )
      {
         A52ServicioCategId = Z52ServicioCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SERVICIOCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLaboratorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1147( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00112 */
         pr_default.execute(0, new Object[] {Short.valueOf(A52ServicioCategId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ServicioCateg"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z287ServicioCategNombre, T00112_A287ServicioCategNombre[0]) != 0 ) || ( GXutil.strcmp(Z288ServicioCategDescripcion, T00112_A288ServicioCategDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z290ServicioCategEstado, T00112_A290ServicioCategEstado[0]) != 0 ) || ( Z40LaboratorioId != T00112_A40LaboratorioId[0] ) )
         {
            if ( GXutil.strcmp(Z287ServicioCategNombre, T00112_A287ServicioCategNombre[0]) != 0 )
            {
               GXutil.writeLogln("serviciocateg:[seudo value changed for attri]"+"ServicioCategNombre");
               GXutil.writeLogRaw("Old: ",Z287ServicioCategNombre);
               GXutil.writeLogRaw("Current: ",T00112_A287ServicioCategNombre[0]);
            }
            if ( GXutil.strcmp(Z288ServicioCategDescripcion, T00112_A288ServicioCategDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("serviciocateg:[seudo value changed for attri]"+"ServicioCategDescripcion");
               GXutil.writeLogRaw("Old: ",Z288ServicioCategDescripcion);
               GXutil.writeLogRaw("Current: ",T00112_A288ServicioCategDescripcion[0]);
            }
            if ( GXutil.strcmp(Z290ServicioCategEstado, T00112_A290ServicioCategEstado[0]) != 0 )
            {
               GXutil.writeLogln("serviciocateg:[seudo value changed for attri]"+"ServicioCategEstado");
               GXutil.writeLogRaw("Old: ",Z290ServicioCategEstado);
               GXutil.writeLogRaw("Current: ",T00112_A290ServicioCategEstado[0]);
            }
            if ( Z40LaboratorioId != T00112_A40LaboratorioId[0] )
            {
               GXutil.writeLogln("serviciocateg:[seudo value changed for attri]"+"LaboratorioId");
               GXutil.writeLogRaw("Old: ",Z40LaboratorioId);
               GXutil.writeLogRaw("Current: ",T00112_A40LaboratorioId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ServicioCateg"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1147( )
   {
      beforeValidate1147( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1147( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1147( 0) ;
         checkOptimisticConcurrency1147( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1147( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1147( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001110 */
                  pr_default.execute(8, new Object[] {A287ServicioCategNombre, Boolean.valueOf(n288ServicioCategDescripcion), A288ServicioCategDescripcion, Boolean.valueOf(n289ServicioCategImagen), A289ServicioCategImagen, Boolean.valueOf(n40000ServicioCategImagen_GXI), A40000ServicioCategImagen_GXI, A290ServicioCategEstado, Short.valueOf(A40LaboratorioId)});
                  A52ServicioCategId = T001110_A52ServicioCategId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ServicioCateg");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption110( ) ;
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
            load1147( ) ;
         }
         endLevel1147( ) ;
      }
      closeExtendedTableCursors1147( ) ;
   }

   public void update1147( )
   {
      beforeValidate1147( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1147( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1147( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1147( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1147( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001111 */
                  pr_default.execute(9, new Object[] {A287ServicioCategNombre, Boolean.valueOf(n288ServicioCategDescripcion), A288ServicioCategDescripcion, A290ServicioCategEstado, Short.valueOf(A40LaboratorioId), Short.valueOf(A52ServicioCategId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ServicioCateg");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ServicioCateg"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1147( ) ;
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
         endLevel1147( ) ;
      }
      closeExtendedTableCursors1147( ) ;
   }

   public void deferredUpdate1147( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T001112 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n289ServicioCategImagen), A289ServicioCategImagen, Boolean.valueOf(n40000ServicioCategImagen_GXI), A40000ServicioCategImagen_GXI, Short.valueOf(A52ServicioCategId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ServicioCateg");
      }
   }

   public void delete( )
   {
      beforeValidate1147( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1147( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1147( ) ;
         afterConfirm1147( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1147( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001113 */
               pr_default.execute(11, new Object[] {Short.valueOf(A52ServicioCategId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ServicioCateg");
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
      sMode47 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1147( ) ;
      Gx_mode = sMode47 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1147( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "ServicioCateg" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T001114 */
         pr_default.execute(12, new Object[] {Short.valueOf(A40LaboratorioId)});
         A165LaboratorioNombre = T001114_A165LaboratorioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
         pr_default.close(12);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001115 */
         pr_default.execute(13, new Object[] {Short.valueOf(A52ServicioCategId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Servicio"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel1147( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1147( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(12);
         Application.commitDataStores(context, remoteHandle, pr_default, "serviciocateg");
         if ( AnyError == 0 )
         {
            confirmValues110( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(12);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "serviciocateg");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1147( )
   {
      /* Scan By routine */
      /* Using cursor T001116 */
      pr_default.execute(14);
      RcdFound47 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A52ServicioCategId = T001116_A52ServicioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1147( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound47 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A52ServicioCategId = T001116_A52ServicioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
      }
   }

   public void scanEnd1147( )
   {
      pr_default.close(14);
   }

   public void afterConfirm1147( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1147( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1147( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1147( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1147( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1147( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1147( )
   {
      edtServicioCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Enabled), 5, 0), true);
      edtLaboratorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Enabled), 5, 0), true);
      edtLaboratorioNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioNombre_Enabled), 5, 0), true);
      edtServicioCategNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategNombre_Enabled), 5, 0), true);
      edtServicioCategDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategDescripcion_Enabled), 5, 0), true);
      imgServicioCategImagen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgServicioCategImagen_Enabled), 5, 0), true);
      cmbServicioCategEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbServicioCategEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbServicioCategEstado.getEnabled(), 5, 0), true);
      edtavCombolaboratorioid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombolaboratorioid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombolaboratorioid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1147( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues110( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033586", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.serviciocateg", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20ServicioCategId,4,0))}, new String[] {"Gx_mode","ServicioCategId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ServicioCateg");
      forbiddenHiddens.add("ServicioCategId", localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("serviciocateg:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z52ServicioCategId", GXutil.ltrim( localUtil.ntoc( Z52ServicioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z287ServicioCategNombre", Z287ServicioCategNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z288ServicioCategDescripcion", Z288ServicioCategDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z290ServicioCategEstado", GXutil.rtrim( Z290ServicioCategEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z40LaboratorioId", GXutil.ltrim( localUtil.ntoc( Z40LaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N40LaboratorioId", GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ",", "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vLABORATORIOID_DATA", AV14LaboratorioId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vLABORATORIOID_DATA", AV14LaboratorioId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSERVICIOCATEGID", GXutil.ltrim( localUtil.ntoc( AV20ServicioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSERVICIOCATEGID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20ServicioCategId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_LABORATORIOID", GXutil.ltrim( localUtil.ntoc( AV12Insert_LaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SERVICIOCATEGIMAGEN_GXI", A40000ServicioCategImagen_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      GXCCtlgxBlob = "SERVICIOCATEGIMAGEN" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A289ServicioCategImagen);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Objectcall", GXutil.rtrim( Combo_laboratorioid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Cls", GXutil.rtrim( Combo_laboratorioid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Selectedvalue_set", GXutil.rtrim( Combo_laboratorioid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Selectedtext_set", GXutil.rtrim( Combo_laboratorioid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Enabled", GXutil.booltostr( Combo_laboratorioid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Datalistproc", GXutil.rtrim( Combo_laboratorioid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Datalistprocparametersprefix", GXutil.rtrim( Combo_laboratorioid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_LABORATORIOID_Emptyitem", GXutil.booltostr( Combo_laboratorioid_Emptyitem));
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
      return formatLink("com.projectthani.serviciocateg", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20ServicioCategId,4,0))}, new String[] {"Gx_mode","ServicioCategId"})  ;
   }

   public String getPgmname( )
   {
      return "ServicioCateg" ;
   }

   public String getPgmdesc( )
   {
      return "Servicio Categ" ;
   }

   public void initializeNonKey1147( )
   {
      A165LaboratorioNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
      A287ServicioCategNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A287ServicioCategNombre", A287ServicioCategNombre);
      A288ServicioCategDescripcion = "" ;
      n288ServicioCategDescripcion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A288ServicioCategDescripcion", A288ServicioCategDescripcion);
      n288ServicioCategDescripcion = ((GXutil.strcmp("", A288ServicioCategDescripcion)==0) ? true : false) ;
      A289ServicioCategImagen = "" ;
      n289ServicioCategImagen = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A289ServicioCategImagen", A289ServicioCategImagen);
      httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A289ServicioCategImagen))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A289ServicioCategImagen), true);
      n289ServicioCategImagen = ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? true : false) ;
      A40000ServicioCategImagen_GXI = "" ;
      n40000ServicioCategImagen_GXI = false ;
      httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "Bitmap", ((GXutil.strcmp("", A289ServicioCategImagen)==0) ? A40000ServicioCategImagen_GXI : httpContext.convertURL( httpContext.getResourceRelative(A289ServicioCategImagen))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgServicioCategImagen_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A289ServicioCategImagen), true);
      A290ServicioCategEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A290ServicioCategEstado", A290ServicioCategEstado);
      A40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      Z287ServicioCategNombre = "" ;
      Z288ServicioCategDescripcion = "" ;
      Z290ServicioCategEstado = "" ;
      Z40LaboratorioId = (short)(0) ;
   }

   public void initAll1147( )
   {
      A52ServicioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
      initializeNonKey1147( ) ;
   }

   public void standaloneModalInsert( )
   {
      A40LaboratorioId = i40LaboratorioId ;
      httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202251103366", true, true);
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
      httpContext.AddJavascriptSource("serviciocateg.js", "?202251103366", false, true);
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
      edtServicioCategId_Internalname = "SERVICIOCATEGID" ;
      lblTextblocklaboratorioid_Internalname = "TEXTBLOCKLABORATORIOID" ;
      Combo_laboratorioid_Internalname = "COMBO_LABORATORIOID" ;
      edtLaboratorioId_Internalname = "LABORATORIOID" ;
      divTablesplittedlaboratorioid_Internalname = "TABLESPLITTEDLABORATORIOID" ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE" ;
      edtServicioCategNombre_Internalname = "SERVICIOCATEGNOMBRE" ;
      edtServicioCategDescripcion_Internalname = "SERVICIOCATEGDESCRIPCION" ;
      imgServicioCategImagen_Internalname = "SERVICIOCATEGIMAGEN" ;
      cmbServicioCategEstado.setInternalname( "SERVICIOCATEGESTADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombolaboratorioid_Internalname = "vCOMBOLABORATORIOID" ;
      divSectionattribute_laboratorioid_Internalname = "SECTIONATTRIBUTE_LABORATORIOID" ;
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
      Form.setCaption( "Servicio Categ" );
      edtavCombolaboratorioid_Jsonclick = "" ;
      edtavCombolaboratorioid_Enabled = 0 ;
      edtavCombolaboratorioid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbServicioCategEstado.setJsonclick( "" );
      cmbServicioCategEstado.setEnabled( 1 );
      imgServicioCategImagen_Enabled = 1 ;
      edtServicioCategDescripcion_Enabled = 1 ;
      edtServicioCategNombre_Jsonclick = "" ;
      edtServicioCategNombre_Enabled = 1 ;
      edtLaboratorioNombre_Jsonclick = "" ;
      edtLaboratorioNombre_Enabled = 0 ;
      edtLaboratorioId_Jsonclick = "" ;
      edtLaboratorioId_Enabled = 1 ;
      edtLaboratorioId_Visible = 1 ;
      Combo_laboratorioid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_laboratorioid_Datalistprocparametersprefix = " \"ComboName\": \"LaboratorioId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"ServicioCategId\": 0" ;
      Combo_laboratorioid_Datalistproc = "ServicioCategLoadDVCombo" ;
      Combo_laboratorioid_Cls = "ExtendedCombo Attribute" ;
      Combo_laboratorioid_Caption = "" ;
      Combo_laboratorioid_Enabled = GXutil.toBoolean( -1) ;
      edtServicioCategId_Jsonclick = "" ;
      edtServicioCategId_Enabled = 0 ;
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

   public void gx6asalaboratorioid1147( short AV12Insert_LaboratorioId ,
                                        short AV19ComboLaboratorioId ,
                                        byte Gx_BScreen )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_LaboratorioId) )
      {
         A40LaboratorioId = AV12Insert_LaboratorioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      }
      else
      {
         if ( true )
         {
            A40LaboratorioId = AV19ComboLaboratorioId ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         }
         else
         {
            if ( isIns( )  && (0==A40LaboratorioId) && ( Gx_BScreen == 0 ) )
            {
               GXt_int10 = A40LaboratorioId ;
               GXv_int11[0] = GXt_int10 ;
               new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int11) ;
               serviciocateg_impl.this.GXt_int10 = GXv_int11[0] ;
               A40LaboratorioId = GXt_int10 ;
               httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            }
         }
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
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
      cmbServicioCategEstado.setName( "SERVICIOCATEGESTADO" );
      cmbServicioCategEstado.setWebtags( "" );
      cmbServicioCategEstado.addItem("A", "Activo", (short)(0));
      cmbServicioCategEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbServicioCategEstado.getItemCount() > 0 )
      {
         A290ServicioCategEstado = cmbServicioCategEstado.getValidValue(A290ServicioCategEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A290ServicioCategEstado", A290ServicioCategEstado);
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

   public void valid_Laboratorioid( )
   {
      /* Using cursor T001114 */
      pr_default.execute(12, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Laboratorio'.", "ForeignKeyNotFound", 1, "LABORATORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLaboratorioId_Internalname ;
      }
      A165LaboratorioNombre = T001114_A165LaboratorioNombre[0] ;
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20ServicioCategId',fld:'vSERVICIOCATEGID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV20ServicioCategId',fld:'vSERVICIOCATEGID',pic:'ZZZ9',hsh:true},{av:'A52ServicioCategId',fld:'SERVICIOCATEGID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12112',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SERVICIOCATEGID","{handler:'valid_Serviciocategid',iparms:[]");
      setEventMetadata("VALID_SERVICIOCATEGID",",oparms:[]}");
      setEventMetadata("VALID_LABORATORIOID","{handler:'valid_Laboratorioid',iparms:[{av:'A40LaboratorioId',fld:'LABORATORIOID',pic:'ZZZ9'},{av:'A165LaboratorioNombre',fld:'LABORATORIONOMBRE',pic:''}]");
      setEventMetadata("VALID_LABORATORIOID",",oparms:[{av:'A165LaboratorioNombre',fld:'LABORATORIONOMBRE',pic:''}]}");
      setEventMetadata("VALID_SERVICIOCATEGESTADO","{handler:'valid_Serviciocategestado',iparms:[]");
      setEventMetadata("VALID_SERVICIOCATEGESTADO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOLABORATORIOID","{handler:'validv_Combolaboratorioid',iparms:[]");
      setEventMetadata("VALIDV_COMBOLABORATORIOID",",oparms:[]}");
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
      Z287ServicioCategNombre = "" ;
      Z288ServicioCategDescripcion = "" ;
      Z290ServicioCategEstado = "" ;
      Combo_laboratorioid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A290ServicioCategEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblocklaboratorioid_Jsonclick = "" ;
      ucCombo_laboratorioid = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14LaboratorioId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A165LaboratorioNombre = "" ;
      A287ServicioCategNombre = "" ;
      A288ServicioCategDescripcion = "" ;
      A289ServicioCategImagen = "" ;
      A40000ServicioCategImagen_GXI = "" ;
      sImgUrl = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV22Pgmname = "" ;
      Combo_laboratorioid_Objectcall = "" ;
      Combo_laboratorioid_Class = "" ;
      Combo_laboratorioid_Icontype = "" ;
      Combo_laboratorioid_Icon = "" ;
      Combo_laboratorioid_Tooltip = "" ;
      Combo_laboratorioid_Selectedvalue_set = "" ;
      Combo_laboratorioid_Selectedtext_set = "" ;
      Combo_laboratorioid_Selectedtext_get = "" ;
      Combo_laboratorioid_Gamoauthtoken = "" ;
      Combo_laboratorioid_Ddointernalname = "" ;
      Combo_laboratorioid_Titlecontrolalign = "" ;
      Combo_laboratorioid_Dropdownoptionstype = "" ;
      Combo_laboratorioid_Titlecontrolidtoreplace = "" ;
      Combo_laboratorioid_Datalisttype = "" ;
      Combo_laboratorioid_Datalistfixedvalues = "" ;
      Combo_laboratorioid_Htmltemplate = "" ;
      Combo_laboratorioid_Multiplevaluestype = "" ;
      Combo_laboratorioid_Loadingdata = "" ;
      Combo_laboratorioid_Noresultsfound = "" ;
      Combo_laboratorioid_Emptyitemtext = "" ;
      Combo_laboratorioid_Onlyselectedvalues = "" ;
      Combo_laboratorioid_Selectalltext = "" ;
      Combo_laboratorioid_Multiplevaluesseparator = "" ;
      Combo_laboratorioid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode47 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV18Combo_DataJson = "" ;
      AV16ComboSelectedValue = "" ;
      AV17ComboSelectedText = "" ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      Z289ServicioCategImagen = "" ;
      Z40000ServicioCategImagen_GXI = "" ;
      Z165LaboratorioNombre = "" ;
      T00114_A165LaboratorioNombre = new String[] {""} ;
      T00115_A52ServicioCategId = new short[1] ;
      T00115_A165LaboratorioNombre = new String[] {""} ;
      T00115_A287ServicioCategNombre = new String[] {""} ;
      T00115_A288ServicioCategDescripcion = new String[] {""} ;
      T00115_n288ServicioCategDescripcion = new boolean[] {false} ;
      T00115_A289ServicioCategImagen = new String[] {""} ;
      T00115_n289ServicioCategImagen = new boolean[] {false} ;
      T00115_A40000ServicioCategImagen_GXI = new String[] {""} ;
      T00115_n40000ServicioCategImagen_GXI = new boolean[] {false} ;
      T00115_A290ServicioCategEstado = new String[] {""} ;
      T00115_A40LaboratorioId = new short[1] ;
      T00116_A165LaboratorioNombre = new String[] {""} ;
      T00117_A52ServicioCategId = new short[1] ;
      T00113_A52ServicioCategId = new short[1] ;
      T00113_A287ServicioCategNombre = new String[] {""} ;
      T00113_A288ServicioCategDescripcion = new String[] {""} ;
      T00113_n288ServicioCategDescripcion = new boolean[] {false} ;
      T00113_A289ServicioCategImagen = new String[] {""} ;
      T00113_n289ServicioCategImagen = new boolean[] {false} ;
      T00113_A40000ServicioCategImagen_GXI = new String[] {""} ;
      T00113_n40000ServicioCategImagen_GXI = new boolean[] {false} ;
      T00113_A290ServicioCategEstado = new String[] {""} ;
      T00113_A40LaboratorioId = new short[1] ;
      T00118_A52ServicioCategId = new short[1] ;
      T00119_A52ServicioCategId = new short[1] ;
      T00112_A52ServicioCategId = new short[1] ;
      T00112_A287ServicioCategNombre = new String[] {""} ;
      T00112_A288ServicioCategDescripcion = new String[] {""} ;
      T00112_n288ServicioCategDescripcion = new boolean[] {false} ;
      T00112_A289ServicioCategImagen = new String[] {""} ;
      T00112_n289ServicioCategImagen = new boolean[] {false} ;
      T00112_A40000ServicioCategImagen_GXI = new String[] {""} ;
      T00112_n40000ServicioCategImagen_GXI = new boolean[] {false} ;
      T00112_A290ServicioCategEstado = new String[] {""} ;
      T00112_A40LaboratorioId = new short[1] ;
      T001110_A52ServicioCategId = new short[1] ;
      T001114_A165LaboratorioNombre = new String[] {""} ;
      T001115_A27ServicioId = new short[1] ;
      T001116_A52ServicioCategId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      GXv_int11 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.serviciocateg__default(),
         new Object[] {
             new Object[] {
            T00112_A52ServicioCategId, T00112_A287ServicioCategNombre, T00112_A288ServicioCategDescripcion, T00112_n288ServicioCategDescripcion, T00112_A289ServicioCategImagen, T00112_n289ServicioCategImagen, T00112_A40000ServicioCategImagen_GXI, T00112_n40000ServicioCategImagen_GXI, T00112_A290ServicioCategEstado, T00112_A40LaboratorioId
            }
            , new Object[] {
            T00113_A52ServicioCategId, T00113_A287ServicioCategNombre, T00113_A288ServicioCategDescripcion, T00113_n288ServicioCategDescripcion, T00113_A289ServicioCategImagen, T00113_n289ServicioCategImagen, T00113_A40000ServicioCategImagen_GXI, T00113_n40000ServicioCategImagen_GXI, T00113_A290ServicioCategEstado, T00113_A40LaboratorioId
            }
            , new Object[] {
            T00114_A165LaboratorioNombre
            }
            , new Object[] {
            T00115_A52ServicioCategId, T00115_A165LaboratorioNombre, T00115_A287ServicioCategNombre, T00115_A288ServicioCategDescripcion, T00115_n288ServicioCategDescripcion, T00115_A289ServicioCategImagen, T00115_n289ServicioCategImagen, T00115_A40000ServicioCategImagen_GXI, T00115_n40000ServicioCategImagen_GXI, T00115_A290ServicioCategEstado,
            T00115_A40LaboratorioId
            }
            , new Object[] {
            T00116_A165LaboratorioNombre
            }
            , new Object[] {
            T00117_A52ServicioCategId
            }
            , new Object[] {
            T00118_A52ServicioCategId
            }
            , new Object[] {
            T00119_A52ServicioCategId
            }
            , new Object[] {
            T001110_A52ServicioCategId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001114_A165LaboratorioNombre
            }
            , new Object[] {
            T001115_A27ServicioId
            }
            , new Object[] {
            T001116_A52ServicioCategId
            }
         }
      );
      AV22Pgmname = "ServicioCateg" ;
      Z40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
      N40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
      i40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
      A40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
   }

   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte gxajaxcallmode ;
   private short wcpOAV20ServicioCategId ;
   private short Z52ServicioCategId ;
   private short Z40LaboratorioId ;
   private short N40LaboratorioId ;
   private short AV12Insert_LaboratorioId ;
   private short AV19ComboLaboratorioId ;
   private short A40LaboratorioId ;
   private short AV20ServicioCategId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A52ServicioCategId ;
   private short RcdFound47 ;
   private short nIsDirty_47 ;
   private short i40LaboratorioId ;
   private short GXt_int10 ;
   private short GXv_int11[] ;
   private int trnEnded ;
   private int edtServicioCategId_Enabled ;
   private int edtLaboratorioId_Visible ;
   private int edtLaboratorioId_Enabled ;
   private int edtLaboratorioNombre_Enabled ;
   private int edtServicioCategNombre_Enabled ;
   private int edtServicioCategDescripcion_Enabled ;
   private int imgServicioCategImagen_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombolaboratorioid_Enabled ;
   private int edtavCombolaboratorioid_Visible ;
   private int Combo_laboratorioid_Datalistupdateminimumcharacters ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z290ServicioCategEstado ;
   private String Combo_laboratorioid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLaboratorioId_Internalname ;
   private String A290ServicioCategEstado ;
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
   private String edtServicioCategId_Internalname ;
   private String edtServicioCategId_Jsonclick ;
   private String divTablesplittedlaboratorioid_Internalname ;
   private String lblTextblocklaboratorioid_Internalname ;
   private String lblTextblocklaboratorioid_Jsonclick ;
   private String Combo_laboratorioid_Caption ;
   private String Combo_laboratorioid_Cls ;
   private String Combo_laboratorioid_Datalistproc ;
   private String Combo_laboratorioid_Datalistprocparametersprefix ;
   private String Combo_laboratorioid_Internalname ;
   private String TempTags ;
   private String edtLaboratorioId_Jsonclick ;
   private String edtLaboratorioNombre_Internalname ;
   private String edtLaboratorioNombre_Jsonclick ;
   private String edtServicioCategNombre_Internalname ;
   private String edtServicioCategNombre_Jsonclick ;
   private String edtServicioCategDescripcion_Internalname ;
   private String imgServicioCategImagen_Internalname ;
   private String sImgUrl ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_laboratorioid_Internalname ;
   private String edtavCombolaboratorioid_Internalname ;
   private String edtavCombolaboratorioid_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_laboratorioid_Objectcall ;
   private String Combo_laboratorioid_Class ;
   private String Combo_laboratorioid_Icontype ;
   private String Combo_laboratorioid_Icon ;
   private String Combo_laboratorioid_Tooltip ;
   private String Combo_laboratorioid_Selectedvalue_set ;
   private String Combo_laboratorioid_Selectedtext_set ;
   private String Combo_laboratorioid_Selectedtext_get ;
   private String Combo_laboratorioid_Gamoauthtoken ;
   private String Combo_laboratorioid_Ddointernalname ;
   private String Combo_laboratorioid_Titlecontrolalign ;
   private String Combo_laboratorioid_Dropdownoptionstype ;
   private String Combo_laboratorioid_Titlecontrolidtoreplace ;
   private String Combo_laboratorioid_Datalisttype ;
   private String Combo_laboratorioid_Datalistfixedvalues ;
   private String Combo_laboratorioid_Htmltemplate ;
   private String Combo_laboratorioid_Multiplevaluestype ;
   private String Combo_laboratorioid_Loadingdata ;
   private String Combo_laboratorioid_Noresultsfound ;
   private String Combo_laboratorioid_Emptyitemtext ;
   private String Combo_laboratorioid_Onlyselectedvalues ;
   private String Combo_laboratorioid_Selectalltext ;
   private String Combo_laboratorioid_Multiplevaluesseparator ;
   private String Combo_laboratorioid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode47 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_laboratorioid_Emptyitem ;
   private boolean A289ServicioCategImagen_IsBlob ;
   private boolean n288ServicioCategDescripcion ;
   private boolean n40000ServicioCategImagen_GXI ;
   private boolean Combo_laboratorioid_Enabled ;
   private boolean Combo_laboratorioid_Visible ;
   private boolean Combo_laboratorioid_Allowmultipleselection ;
   private boolean Combo_laboratorioid_Isgriditem ;
   private boolean Combo_laboratorioid_Hasdescription ;
   private boolean Combo_laboratorioid_Includeonlyselectedoption ;
   private boolean Combo_laboratorioid_Includeselectalloption ;
   private boolean Combo_laboratorioid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n289ServicioCategImagen ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private String AV18Combo_DataJson ;
   private String Z287ServicioCategNombre ;
   private String Z288ServicioCategDescripcion ;
   private String A165LaboratorioNombre ;
   private String A287ServicioCategNombre ;
   private String A288ServicioCategDescripcion ;
   private String A40000ServicioCategImagen_GXI ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private String Z40000ServicioCategImagen_GXI ;
   private String Z165LaboratorioNombre ;
   private String A289ServicioCategImagen ;
   private String Z289ServicioCategImagen ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_laboratorioid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbServicioCategEstado ;
   private IDataStoreProvider pr_default ;
   private String[] T00114_A165LaboratorioNombre ;
   private short[] T00115_A52ServicioCategId ;
   private String[] T00115_A165LaboratorioNombre ;
   private String[] T00115_A287ServicioCategNombre ;
   private String[] T00115_A288ServicioCategDescripcion ;
   private boolean[] T00115_n288ServicioCategDescripcion ;
   private String[] T00115_A289ServicioCategImagen ;
   private boolean[] T00115_n289ServicioCategImagen ;
   private String[] T00115_A40000ServicioCategImagen_GXI ;
   private boolean[] T00115_n40000ServicioCategImagen_GXI ;
   private String[] T00115_A290ServicioCategEstado ;
   private short[] T00115_A40LaboratorioId ;
   private String[] T00116_A165LaboratorioNombre ;
   private short[] T00117_A52ServicioCategId ;
   private short[] T00113_A52ServicioCategId ;
   private String[] T00113_A287ServicioCategNombre ;
   private String[] T00113_A288ServicioCategDescripcion ;
   private boolean[] T00113_n288ServicioCategDescripcion ;
   private String[] T00113_A289ServicioCategImagen ;
   private boolean[] T00113_n289ServicioCategImagen ;
   private String[] T00113_A40000ServicioCategImagen_GXI ;
   private boolean[] T00113_n40000ServicioCategImagen_GXI ;
   private String[] T00113_A290ServicioCategEstado ;
   private short[] T00113_A40LaboratorioId ;
   private short[] T00118_A52ServicioCategId ;
   private short[] T00119_A52ServicioCategId ;
   private short[] T00112_A52ServicioCategId ;
   private String[] T00112_A287ServicioCategNombre ;
   private String[] T00112_A288ServicioCategDescripcion ;
   private boolean[] T00112_n288ServicioCategDescripcion ;
   private String[] T00112_A289ServicioCategImagen ;
   private boolean[] T00112_n289ServicioCategImagen ;
   private String[] T00112_A40000ServicioCategImagen_GXI ;
   private boolean[] T00112_n40000ServicioCategImagen_GXI ;
   private String[] T00112_A290ServicioCategEstado ;
   private short[] T00112_A40LaboratorioId ;
   private short[] T001110_A52ServicioCategId ;
   private String[] T001114_A165LaboratorioNombre ;
   private short[] T001115_A27ServicioId ;
   private short[] T001116_A52ServicioCategId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14LaboratorioId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[] ;
}

final  class serviciocateg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00112", "SELECT [ServicioCategId], [ServicioCategNombre], [ServicioCategDescripcion], [ServicioCategImagen], [ServicioCategImagen_GXI], [ServicioCategEstado], [LaboratorioId] FROM [ServicioCateg] WITH (UPDLOCK) WHERE [ServicioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00113", "SELECT [ServicioCategId], [ServicioCategNombre], [ServicioCategDescripcion], [ServicioCategImagen], [ServicioCategImagen_GXI], [ServicioCategEstado], [LaboratorioId] FROM [ServicioCateg] WHERE [ServicioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00114", "SELECT [LaboratorioNombre] FROM [Laboratorio] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00115", "SELECT TM1.[ServicioCategId], T2.[LaboratorioNombre], TM1.[ServicioCategNombre], TM1.[ServicioCategDescripcion], TM1.[ServicioCategImagen], TM1.[ServicioCategImagen_GXI], TM1.[ServicioCategEstado], TM1.[LaboratorioId] FROM ([ServicioCateg] TM1 INNER JOIN [Laboratorio] T2 ON T2.[LaboratorioId] = TM1.[LaboratorioId]) WHERE TM1.[ServicioCategId] = ? ORDER BY TM1.[ServicioCategId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00116", "SELECT [LaboratorioNombre] FROM [Laboratorio] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00117", "SELECT [ServicioCategId] FROM [ServicioCateg] WHERE [ServicioCategId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00118", "SELECT TOP 1 [ServicioCategId] FROM [ServicioCateg] WHERE ( [ServicioCategId] > ?) ORDER BY [ServicioCategId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00119", "SELECT TOP 1 [ServicioCategId] FROM [ServicioCateg] WHERE ( [ServicioCategId] < ?) ORDER BY [ServicioCategId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001110", "INSERT INTO [ServicioCateg]([ServicioCategNombre], [ServicioCategDescripcion], [ServicioCategImagen], [ServicioCategImagen_GXI], [ServicioCategEstado], [LaboratorioId]) VALUES(?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T001111", "UPDATE [ServicioCateg] SET [ServicioCategNombre]=?, [ServicioCategDescripcion]=?, [ServicioCategEstado]=?, [LaboratorioId]=?  WHERE [ServicioCategId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001112", "UPDATE [ServicioCateg] SET [ServicioCategImagen]=?, [ServicioCategImagen_GXI]=?  WHERE [ServicioCategId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001113", "DELETE FROM [ServicioCateg]  WHERE [ServicioCategId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001114", "SELECT [LaboratorioNombre] FROM [Laboratorio] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001115", "SELECT TOP 1 [ServicioId] FROM [Servicio] WHERE [ServicioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001116", "SELECT [ServicioCategId] FROM [ServicioCateg] ORDER BY [ServicioCategId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(5));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(6, 1);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(5));
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(5);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(6, 1);
               ((short[]) buf[9])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getMultimediaUri(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(7, 1);
               ((short[]) buf[10])[0] = rslt.getShort(8);
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
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setVarchar(1, (String)parms[0], 100, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 500);
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(3, (String)parms[4], true);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(4, (String)parms[6], (String)parms[4], 2048,"ServicioCateg","ServicioCategImagen");
               }
               stmt.setString(5, (String)parms[7], 1);
               stmt.setShort(6, ((Number) parms[8]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[2], 500);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setShort(4, ((Number) parms[4]).shortValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1], true);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"ServicioCateg","ServicioCategImagen");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

