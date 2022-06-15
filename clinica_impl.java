package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clinica_impl extends GXDataArea
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
            AV15ClinicaId = (short)(GXutil.lval( httpContext.GetPar( "ClinicaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15ClinicaId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLINICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15ClinicaId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Clinica", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtClinicaRUC_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public clinica_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clinica_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clinica_impl.class ));
   }

   public clinica_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbClinicaMoneda = new HTMLChoice();
      cmbClinicaTiempoDeCita = new HTMLChoice();
      cmbClinicaEstado = new HTMLChoice();
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
      if ( cmbClinicaMoneda.getItemCount() > 0 )
      {
         A341ClinicaMoneda = (short)(GXutil.lval( cmbClinicaMoneda.getValidValue(GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbClinicaMoneda.setValue( GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbClinicaMoneda.getInternalname(), "Values", cmbClinicaMoneda.ToJavascriptSource(), true);
      }
      if ( cmbClinicaTiempoDeCita.getItemCount() > 0 )
      {
         A120ClinicaTiempoDeCita = (byte)(GXutil.lval( cmbClinicaTiempoDeCita.getValidValue(GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbClinicaTiempoDeCita.setValue( GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbClinicaTiempoDeCita.getInternalname(), "Values", cmbClinicaTiempoDeCita.ToJavascriptSource(), true);
      }
      if ( cmbClinicaEstado.getItemCount() > 0 )
      {
         A121ClinicaEstado = cmbClinicaEstado.getValidValue(A121ClinicaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A121ClinicaEstado", A121ClinicaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbClinicaEstado.setValue( GXutil.rtrim( A121ClinicaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbClinicaEstado.getInternalname(), "Values", cmbClinicaEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtClinicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Clinica.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaRUC_Internalname, "RUC", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaRUC_Internalname, GXutil.ltrim( localUtil.ntoc( A118ClinicaRUC, (byte)(11), (byte)(0), ",", "")), GXutil.ltrim( ((edtClinicaRUC_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A118ClinicaRUC), "ZZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaRUC_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaRUC_Enabled, 0, "text", "1", 11, "chr", 1, "row", 11, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Clinica.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaNombreComercial_Internalname, A116ClinicaNombreComercial, GXutil.rtrim( localUtil.format( A116ClinicaNombreComercial, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaNombreComercial_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaNombreComercial_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaNombreAbreviado_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaNombreAbreviado_Internalname, "Nombre Abrev.", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaNombreAbreviado_Internalname, A80ClinicaNombreAbreviado, GXutil.rtrim( localUtil.format( A80ClinicaNombreAbreviado, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaNombreAbreviado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaNombreAbreviado_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaDireccionComercial_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaDireccionComercial_Internalname, "Direccion Comercial", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtClinicaDireccionComercial_Internalname, A119ClinicaDireccionComercial, "http://maps.google.com/maps?q="+PrivateUtilities.encodeURL( A119ClinicaDireccionComercial), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", (short)(0), 1, edtClinicaDireccionComercial_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "1024", -1, 0, "_blank", "", (byte)(0), true, "GeneXus\\Address", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaCorreo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaCorreo_Internalname, "Correo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaCorreo_Internalname, A340ClinicaCorreo, GXutil.rtrim( localUtil.format( A340ClinicaCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A340ClinicaCorreo, "", "", "", edtClinicaCorreo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbClinicaMoneda.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbClinicaMoneda.getInternalname(), "Moneda", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbClinicaMoneda, cmbClinicaMoneda.getInternalname(), GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)), 1, cmbClinicaMoneda.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbClinicaMoneda.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "", true, (byte)(1), "HLP_Clinica.htm");
      cmbClinicaMoneda.setValue( GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaMoneda.getInternalname(), "Values", cmbClinicaMoneda.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A117ClinicaLogo_IsBlob = (boolean)(((GXutil.strcmp("", A117ClinicaLogo)==0)&&(GXutil.strcmp("", A40000ClinicaLogo_GXI)==0))||!(GXutil.strcmp("", A117ClinicaLogo)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.getResourceRelative(A117ClinicaLogo)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogo_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgClinicaLogo_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", "", "", 0, A117ClinicaLogo_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Clinica.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "URL", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.getResourceRelative(A117ClinicaLogo)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "IsBlob", GXutil.booltostr( A117ClinicaLogo_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoHeader_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Header", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A342ClinicaLogoHeader_IsBlob = (boolean)(((GXutil.strcmp("", A342ClinicaLogoHeader)==0)&&(GXutil.strcmp("", A40001ClinicaLogoHeader_GXI)==0))||!(GXutil.strcmp("", A342ClinicaLogoHeader)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.getResourceRelative(A342ClinicaLogoHeader)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoHeader_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgClinicaLogoHeader_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", "", "", 0, A342ClinicaLogoHeader_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Clinica.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "URL", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.getResourceRelative(A342ClinicaLogoHeader)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "IsBlob", GXutil.booltostr( A342ClinicaLogoHeader_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoFactura_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Factura", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A343ClinicaLogoFactura_IsBlob = (boolean)(((GXutil.strcmp("", A343ClinicaLogoFactura)==0)&&(GXutil.strcmp("", A40002ClinicaLogoFactura_GXI)==0))||!(GXutil.strcmp("", A343ClinicaLogoFactura)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.getResourceRelative(A343ClinicaLogoFactura)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoFactura_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgClinicaLogoFactura_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "", "", "", 0, A343ClinicaLogoFactura_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Clinica.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "URL", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.getResourceRelative(A343ClinicaLogoFactura)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "IsBlob", GXutil.booltostr( A343ClinicaLogoFactura_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoBoleta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Boleta", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A344ClinicaLogoBoleta_IsBlob = (boolean)(((GXutil.strcmp("", A344ClinicaLogoBoleta)==0)&&(GXutil.strcmp("", A40003ClinicaLogoBoleta_GXI)==0))||!(GXutil.strcmp("", A344ClinicaLogoBoleta)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.getResourceRelative(A344ClinicaLogoBoleta)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoBoleta_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgClinicaLogoBoleta_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "", "", "", 0, A344ClinicaLogoBoleta_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Clinica.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "URL", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.getResourceRelative(A344ClinicaLogoBoleta)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "IsBlob", GXutil.booltostr( A344ClinicaLogoBoleta_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgClinicaLogoPago_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Logo Pago", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A345ClinicaLogoPago_IsBlob = (boolean)(((GXutil.strcmp("", A345ClinicaLogoPago)==0)&&(GXutil.strcmp("", A40004ClinicaLogoPago_GXI)==0))||!(GXutil.strcmp("", A345ClinicaLogoPago)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.getResourceRelative(A345ClinicaLogoPago)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgClinicaLogoPago_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgClinicaLogoPago_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "", "", "", 0, A345ClinicaLogoPago_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Clinica.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "URL", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.getResourceRelative(A345ClinicaLogoPago)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "IsBlob", GXutil.booltostr( A345ClinicaLogoPago_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaTelefono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaTelefono_Internalname, "Telefono", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaTelefono_Internalname, GXutil.rtrim( A346ClinicaTelefono), GXutil.rtrim( localUtil.format( A346ClinicaTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaTelefono_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaTelefono_Enabled, 0, "text", "", 12, "chr", 1, "row", 12, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaWhatsApp_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaWhatsApp_Internalname, "Whats App", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaWhatsApp_Internalname, GXutil.rtrim( A347ClinicaWhatsApp), GXutil.rtrim( localUtil.format( A347ClinicaWhatsApp, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtClinicaWhatsApp_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaWhatsApp_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaFacebook_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaFacebook_Internalname, "Facebook", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaFacebook_Internalname, A348ClinicaFacebook, GXutil.rtrim( localUtil.format( A348ClinicaFacebook, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", "'"+""+"'"+",false,"+"'"+""+"'", A348ClinicaFacebook, "_blank", "", "", edtClinicaFacebook_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaFacebook_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaTwiter_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaTwiter_Internalname, "Twiter", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaTwiter_Internalname, A349ClinicaTwiter, GXutil.rtrim( localUtil.format( A349ClinicaTwiter, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,97);\"", "'"+""+"'"+",false,"+"'"+""+"'", A349ClinicaTwiter, "_blank", "", "", edtClinicaTwiter_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaTwiter_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaInstagram_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaInstagram_Internalname, "Instagram", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaInstagram_Internalname, A350ClinicaInstagram, GXutil.rtrim( localUtil.format( A350ClinicaInstagram, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,102);\"", "'"+""+"'"+",false,"+"'"+""+"'", A350ClinicaInstagram, "_blank", "", "", edtClinicaInstagram_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaInstagram_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtClinicaLinkedin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtClinicaLinkedin_Internalname, "Linkedin", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtClinicaLinkedin_Internalname, A351ClinicaLinkedin, GXutil.rtrim( localUtil.format( A351ClinicaLinkedin, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", A351ClinicaLinkedin, "_blank", "", "", edtClinicaLinkedin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtClinicaLinkedin_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbClinicaTiempoDeCita.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbClinicaTiempoDeCita.getInternalname(), "Tiempo De Cita", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbClinicaTiempoDeCita, cmbClinicaTiempoDeCita.getInternalname(), GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)), 1, cmbClinicaTiempoDeCita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbClinicaTiempoDeCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", "", true, (byte)(1), "HLP_Clinica.htm");
      cmbClinicaTiempoDeCita.setValue( GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaTiempoDeCita.getInternalname(), "Values", cmbClinicaTiempoDeCita.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbClinicaEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbClinicaEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbClinicaEstado, cmbClinicaEstado.getInternalname(), GXutil.rtrim( A121ClinicaEstado), 1, cmbClinicaEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbClinicaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "", true, (byte)(1), "HLP_Clinica.htm");
      cmbClinicaEstado.setValue( GXutil.rtrim( A121ClinicaEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaEstado.getInternalname(), "Values", cmbClinicaEstado.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clinica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 126,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Clinica.htm");
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
      e110E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z28ClinicaId"), ",", ".")) ;
            Z118ClinicaRUC = localUtil.ctol( httpContext.cgiGet( "Z118ClinicaRUC"), ",", ".") ;
            Z116ClinicaNombreComercial = httpContext.cgiGet( "Z116ClinicaNombreComercial") ;
            Z80ClinicaNombreAbreviado = httpContext.cgiGet( "Z80ClinicaNombreAbreviado") ;
            Z119ClinicaDireccionComercial = httpContext.cgiGet( "Z119ClinicaDireccionComercial") ;
            Z340ClinicaCorreo = httpContext.cgiGet( "Z340ClinicaCorreo") ;
            Z341ClinicaMoneda = (short)(localUtil.ctol( httpContext.cgiGet( "Z341ClinicaMoneda"), ",", ".")) ;
            Z346ClinicaTelefono = httpContext.cgiGet( "Z346ClinicaTelefono") ;
            Z347ClinicaWhatsApp = httpContext.cgiGet( "Z347ClinicaWhatsApp") ;
            Z348ClinicaFacebook = httpContext.cgiGet( "Z348ClinicaFacebook") ;
            Z349ClinicaTwiter = httpContext.cgiGet( "Z349ClinicaTwiter") ;
            Z350ClinicaInstagram = httpContext.cgiGet( "Z350ClinicaInstagram") ;
            Z351ClinicaLinkedin = httpContext.cgiGet( "Z351ClinicaLinkedin") ;
            Z120ClinicaTiempoDeCita = (byte)(localUtil.ctol( httpContext.cgiGet( "Z120ClinicaTiempoDeCita"), ",", ".")) ;
            Z121ClinicaEstado = httpContext.cgiGet( "Z121ClinicaEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV15ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( "vCLINICAID"), ",", ".")) ;
            A40000ClinicaLogo_GXI = httpContext.cgiGet( "CLINICALOGO_GXI") ;
            A40001ClinicaLogoHeader_GXI = httpContext.cgiGet( "CLINICALOGOHEADER_GXI") ;
            n40001ClinicaLogoHeader_GXI = ((GXutil.strcmp("", A40001ClinicaLogoHeader_GXI)==0)&&(GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? true : false) ;
            A40002ClinicaLogoFactura_GXI = httpContext.cgiGet( "CLINICALOGOFACTURA_GXI") ;
            n40002ClinicaLogoFactura_GXI = ((GXutil.strcmp("", A40002ClinicaLogoFactura_GXI)==0)&&(GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? true : false) ;
            A40003ClinicaLogoBoleta_GXI = httpContext.cgiGet( "CLINICALOGOBOLETA_GXI") ;
            n40003ClinicaLogoBoleta_GXI = ((GXutil.strcmp("", A40003ClinicaLogoBoleta_GXI)==0)&&(GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? true : false) ;
            A40004ClinicaLogoPago_GXI = httpContext.cgiGet( "CLINICALOGOPAGO_GXI") ;
            n40004ClinicaLogoPago_GXI = ((GXutil.strcmp("", A40004ClinicaLogoPago_GXI)==0)&&(GXutil.strcmp("", A345ClinicaLogoPago)==0) ? true : false) ;
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
            A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtClinicaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtClinicaRUC_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtClinicaRUC_Internalname), ",", ".") > 99999999999L ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLINICARUC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtClinicaRUC_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A118ClinicaRUC = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
            }
            else
            {
               A118ClinicaRUC = localUtil.ctol( httpContext.cgiGet( edtClinicaRUC_Internalname), ",", ".") ;
               httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
            }
            A116ClinicaNombreComercial = httpContext.cgiGet( edtClinicaNombreComercial_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
            A80ClinicaNombreAbreviado = httpContext.cgiGet( edtClinicaNombreAbreviado_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A80ClinicaNombreAbreviado", A80ClinicaNombreAbreviado);
            A119ClinicaDireccionComercial = httpContext.cgiGet( edtClinicaDireccionComercial_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A119ClinicaDireccionComercial", A119ClinicaDireccionComercial);
            A340ClinicaCorreo = httpContext.cgiGet( edtClinicaCorreo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A340ClinicaCorreo", A340ClinicaCorreo);
            cmbClinicaMoneda.setValue( httpContext.cgiGet( cmbClinicaMoneda.getInternalname()) );
            A341ClinicaMoneda = (short)(GXutil.lval( httpContext.cgiGet( cmbClinicaMoneda.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
            A117ClinicaLogo = httpContext.cgiGet( imgClinicaLogo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A117ClinicaLogo", A117ClinicaLogo);
            A342ClinicaLogoHeader = httpContext.cgiGet( imgClinicaLogoHeader_Internalname) ;
            n342ClinicaLogoHeader = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A342ClinicaLogoHeader", A342ClinicaLogoHeader);
            n342ClinicaLogoHeader = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? true : false) ;
            A343ClinicaLogoFactura = httpContext.cgiGet( imgClinicaLogoFactura_Internalname) ;
            n343ClinicaLogoFactura = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A343ClinicaLogoFactura", A343ClinicaLogoFactura);
            n343ClinicaLogoFactura = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? true : false) ;
            A344ClinicaLogoBoleta = httpContext.cgiGet( imgClinicaLogoBoleta_Internalname) ;
            n344ClinicaLogoBoleta = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A344ClinicaLogoBoleta", A344ClinicaLogoBoleta);
            n344ClinicaLogoBoleta = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? true : false) ;
            A345ClinicaLogoPago = httpContext.cgiGet( imgClinicaLogoPago_Internalname) ;
            n345ClinicaLogoPago = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A345ClinicaLogoPago", A345ClinicaLogoPago);
            n345ClinicaLogoPago = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? true : false) ;
            A346ClinicaTelefono = httpContext.cgiGet( edtClinicaTelefono_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A346ClinicaTelefono", A346ClinicaTelefono);
            A347ClinicaWhatsApp = httpContext.cgiGet( edtClinicaWhatsApp_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A347ClinicaWhatsApp", A347ClinicaWhatsApp);
            A348ClinicaFacebook = httpContext.cgiGet( edtClinicaFacebook_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A348ClinicaFacebook", A348ClinicaFacebook);
            A349ClinicaTwiter = httpContext.cgiGet( edtClinicaTwiter_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A349ClinicaTwiter", A349ClinicaTwiter);
            A350ClinicaInstagram = httpContext.cgiGet( edtClinicaInstagram_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A350ClinicaInstagram", A350ClinicaInstagram);
            A351ClinicaLinkedin = httpContext.cgiGet( edtClinicaLinkedin_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A351ClinicaLinkedin", A351ClinicaLinkedin);
            cmbClinicaTiempoDeCita.setValue( httpContext.cgiGet( cmbClinicaTiempoDeCita.getInternalname()) );
            A120ClinicaTiempoDeCita = (byte)(GXutil.lval( httpContext.cgiGet( cmbClinicaTiempoDeCita.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
            cmbClinicaEstado.setValue( httpContext.cgiGet( cmbClinicaEstado.getInternalname()) );
            A121ClinicaEstado = httpContext.cgiGet( cmbClinicaEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A121ClinicaEstado", A121ClinicaEstado);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A117ClinicaLogo ;
            GXv_char2[0] = A40000ClinicaLogo_GXI ;
            httpContext.getMultimediaValue(imgClinicaLogo_Internalname, GXv_char1, GXv_char2);
            clinica_impl.this.A117ClinicaLogo = GXv_char1[0] ;
            clinica_impl.this.A40000ClinicaLogo_GXI = GXv_char2[0] ;
            GXv_char3[0] = A342ClinicaLogoHeader ;
            GXv_char4[0] = A40001ClinicaLogoHeader_GXI ;
            httpContext.getMultimediaValue(imgClinicaLogoHeader_Internalname, GXv_char3, GXv_char4);
            clinica_impl.this.A342ClinicaLogoHeader = GXv_char3[0] ;
            n342ClinicaLogoHeader = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? true : false) ;
            clinica_impl.this.A40001ClinicaLogoHeader_GXI = GXv_char4[0] ;
            n40001ClinicaLogoHeader_GXI = ((GXutil.strcmp("", A40001ClinicaLogoHeader_GXI)==0)&&(GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? true : false) ;
            n40001ClinicaLogoHeader_GXI = ((GXutil.strcmp("", A40001ClinicaLogoHeader_GXI)==0)&&(GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? true : false) ;
            n342ClinicaLogoHeader = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? true : false) ;
            GXv_char4[0] = A343ClinicaLogoFactura ;
            GXv_char3[0] = A40002ClinicaLogoFactura_GXI ;
            httpContext.getMultimediaValue(imgClinicaLogoFactura_Internalname, GXv_char4, GXv_char3);
            clinica_impl.this.A343ClinicaLogoFactura = GXv_char4[0] ;
            n343ClinicaLogoFactura = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? true : false) ;
            clinica_impl.this.A40002ClinicaLogoFactura_GXI = GXv_char3[0] ;
            n40002ClinicaLogoFactura_GXI = ((GXutil.strcmp("", A40002ClinicaLogoFactura_GXI)==0)&&(GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? true : false) ;
            n40002ClinicaLogoFactura_GXI = ((GXutil.strcmp("", A40002ClinicaLogoFactura_GXI)==0)&&(GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? true : false) ;
            n343ClinicaLogoFactura = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? true : false) ;
            GXv_char4[0] = A344ClinicaLogoBoleta ;
            GXv_char3[0] = A40003ClinicaLogoBoleta_GXI ;
            httpContext.getMultimediaValue(imgClinicaLogoBoleta_Internalname, GXv_char4, GXv_char3);
            clinica_impl.this.A344ClinicaLogoBoleta = GXv_char4[0] ;
            n344ClinicaLogoBoleta = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? true : false) ;
            clinica_impl.this.A40003ClinicaLogoBoleta_GXI = GXv_char3[0] ;
            n40003ClinicaLogoBoleta_GXI = ((GXutil.strcmp("", A40003ClinicaLogoBoleta_GXI)==0)&&(GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? true : false) ;
            n40003ClinicaLogoBoleta_GXI = ((GXutil.strcmp("", A40003ClinicaLogoBoleta_GXI)==0)&&(GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? true : false) ;
            n344ClinicaLogoBoleta = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? true : false) ;
            GXv_char4[0] = A345ClinicaLogoPago ;
            GXv_char3[0] = A40004ClinicaLogoPago_GXI ;
            httpContext.getMultimediaValue(imgClinicaLogoPago_Internalname, GXv_char4, GXv_char3);
            clinica_impl.this.A345ClinicaLogoPago = GXv_char4[0] ;
            n345ClinicaLogoPago = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? true : false) ;
            clinica_impl.this.A40004ClinicaLogoPago_GXI = GXv_char3[0] ;
            n40004ClinicaLogoPago_GXI = ((GXutil.strcmp("", A40004ClinicaLogoPago_GXI)==0)&&(GXutil.strcmp("", A345ClinicaLogoPago)==0) ? true : false) ;
            n40004ClinicaLogoPago_GXI = ((GXutil.strcmp("", A40004ClinicaLogoPago_GXI)==0)&&(GXutil.strcmp("", A345ClinicaLogoPago)==0) ? true : false) ;
            n345ClinicaLogoPago = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? true : false) ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Clinica");
            A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtClinicaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
            forbiddenHiddens.add("ClinicaId", localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A28ClinicaId != Z28ClinicaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("clinica:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A28ClinicaId = (short)(GXutil.lval( httpContext.GetPar( "ClinicaId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
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
                  sMode21 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode21 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound21 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0E0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLINICAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtClinicaId_Internalname ;
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
                        e110E2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120E2 ();
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
         e120E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0E21( ) ;
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
         disableAttributes0E21( ) ;
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

   public void confirm_0E0( )
   {
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0E21( ) ;
         }
         else
         {
            checkExtendedTable0E21( ) ;
            closeExtendedTableCursors0E21( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0E0( )
   {
   }

   public void e110E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext5[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV7WWPContext = GXv_SdtWWPContext5[0] ;
      AV8IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Insert", GXv_boolean7) ;
         clinica_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Update", GXv_boolean7) ;
         clinica_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClinica_Delete", GXv_boolean7) ;
         clinica_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e120E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.clinicaww", new String[] {}, new String[] {}) );
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

   public void zm0E21( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z118ClinicaRUC = T000E3_A118ClinicaRUC[0] ;
            Z116ClinicaNombreComercial = T000E3_A116ClinicaNombreComercial[0] ;
            Z80ClinicaNombreAbreviado = T000E3_A80ClinicaNombreAbreviado[0] ;
            Z119ClinicaDireccionComercial = T000E3_A119ClinicaDireccionComercial[0] ;
            Z340ClinicaCorreo = T000E3_A340ClinicaCorreo[0] ;
            Z341ClinicaMoneda = T000E3_A341ClinicaMoneda[0] ;
            Z346ClinicaTelefono = T000E3_A346ClinicaTelefono[0] ;
            Z347ClinicaWhatsApp = T000E3_A347ClinicaWhatsApp[0] ;
            Z348ClinicaFacebook = T000E3_A348ClinicaFacebook[0] ;
            Z349ClinicaTwiter = T000E3_A349ClinicaTwiter[0] ;
            Z350ClinicaInstagram = T000E3_A350ClinicaInstagram[0] ;
            Z351ClinicaLinkedin = T000E3_A351ClinicaLinkedin[0] ;
            Z120ClinicaTiempoDeCita = T000E3_A120ClinicaTiempoDeCita[0] ;
            Z121ClinicaEstado = T000E3_A121ClinicaEstado[0] ;
         }
         else
         {
            Z118ClinicaRUC = A118ClinicaRUC ;
            Z116ClinicaNombreComercial = A116ClinicaNombreComercial ;
            Z80ClinicaNombreAbreviado = A80ClinicaNombreAbreviado ;
            Z119ClinicaDireccionComercial = A119ClinicaDireccionComercial ;
            Z340ClinicaCorreo = A340ClinicaCorreo ;
            Z341ClinicaMoneda = A341ClinicaMoneda ;
            Z346ClinicaTelefono = A346ClinicaTelefono ;
            Z347ClinicaWhatsApp = A347ClinicaWhatsApp ;
            Z348ClinicaFacebook = A348ClinicaFacebook ;
            Z349ClinicaTwiter = A349ClinicaTwiter ;
            Z350ClinicaInstagram = A350ClinicaInstagram ;
            Z351ClinicaLinkedin = A351ClinicaLinkedin ;
            Z120ClinicaTiempoDeCita = A120ClinicaTiempoDeCita ;
            Z121ClinicaEstado = A121ClinicaEstado ;
         }
      }
      if ( GX_JID == -11 )
      {
         Z28ClinicaId = A28ClinicaId ;
         Z118ClinicaRUC = A118ClinicaRUC ;
         Z116ClinicaNombreComercial = A116ClinicaNombreComercial ;
         Z80ClinicaNombreAbreviado = A80ClinicaNombreAbreviado ;
         Z119ClinicaDireccionComercial = A119ClinicaDireccionComercial ;
         Z340ClinicaCorreo = A340ClinicaCorreo ;
         Z341ClinicaMoneda = A341ClinicaMoneda ;
         Z117ClinicaLogo = A117ClinicaLogo ;
         Z40000ClinicaLogo_GXI = A40000ClinicaLogo_GXI ;
         Z342ClinicaLogoHeader = A342ClinicaLogoHeader ;
         Z40001ClinicaLogoHeader_GXI = A40001ClinicaLogoHeader_GXI ;
         Z343ClinicaLogoFactura = A343ClinicaLogoFactura ;
         Z40002ClinicaLogoFactura_GXI = A40002ClinicaLogoFactura_GXI ;
         Z344ClinicaLogoBoleta = A344ClinicaLogoBoleta ;
         Z40003ClinicaLogoBoleta_GXI = A40003ClinicaLogoBoleta_GXI ;
         Z345ClinicaLogoPago = A345ClinicaLogoPago ;
         Z40004ClinicaLogoPago_GXI = A40004ClinicaLogoPago_GXI ;
         Z346ClinicaTelefono = A346ClinicaTelefono ;
         Z347ClinicaWhatsApp = A347ClinicaWhatsApp ;
         Z348ClinicaFacebook = A348ClinicaFacebook ;
         Z349ClinicaTwiter = A349ClinicaTwiter ;
         Z350ClinicaInstagram = A350ClinicaInstagram ;
         Z351ClinicaLinkedin = A351ClinicaLinkedin ;
         Z120ClinicaTiempoDeCita = A120ClinicaTiempoDeCita ;
         Z121ClinicaEstado = A121ClinicaEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      edtClinicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Enabled), 5, 0), true);
      edtClinicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV15ClinicaId) )
      {
         A28ClinicaId = AV15ClinicaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
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
   }

   public void load0E21( )
   {
      /* Using cursor T000E4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound21 = (short)(1) ;
         A118ClinicaRUC = T000E4_A118ClinicaRUC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
         A116ClinicaNombreComercial = T000E4_A116ClinicaNombreComercial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
         A80ClinicaNombreAbreviado = T000E4_A80ClinicaNombreAbreviado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A80ClinicaNombreAbreviado", A80ClinicaNombreAbreviado);
         A119ClinicaDireccionComercial = T000E4_A119ClinicaDireccionComercial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A119ClinicaDireccionComercial", A119ClinicaDireccionComercial);
         A340ClinicaCorreo = T000E4_A340ClinicaCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A340ClinicaCorreo", A340ClinicaCorreo);
         A341ClinicaMoneda = T000E4_A341ClinicaMoneda[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
         A117ClinicaLogo = T000E4_A117ClinicaLogo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A117ClinicaLogo", A117ClinicaLogo);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
         A40000ClinicaLogo_GXI = T000E4_A40000ClinicaLogo_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
         A342ClinicaLogoHeader = T000E4_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = T000E4_n342ClinicaLogoHeader[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A342ClinicaLogoHeader", A342ClinicaLogoHeader);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
         A40001ClinicaLogoHeader_GXI = T000E4_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = T000E4_n40001ClinicaLogoHeader_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
         A343ClinicaLogoFactura = T000E4_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = T000E4_n343ClinicaLogoFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A343ClinicaLogoFactura", A343ClinicaLogoFactura);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
         A40002ClinicaLogoFactura_GXI = T000E4_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = T000E4_n40002ClinicaLogoFactura_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
         A344ClinicaLogoBoleta = T000E4_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = T000E4_n344ClinicaLogoBoleta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A344ClinicaLogoBoleta", A344ClinicaLogoBoleta);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
         A40003ClinicaLogoBoleta_GXI = T000E4_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = T000E4_n40003ClinicaLogoBoleta_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
         A345ClinicaLogoPago = T000E4_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = T000E4_n345ClinicaLogoPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A345ClinicaLogoPago", A345ClinicaLogoPago);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
         A40004ClinicaLogoPago_GXI = T000E4_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = T000E4_n40004ClinicaLogoPago_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
         A346ClinicaTelefono = T000E4_A346ClinicaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A346ClinicaTelefono", A346ClinicaTelefono);
         A347ClinicaWhatsApp = T000E4_A347ClinicaWhatsApp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A347ClinicaWhatsApp", A347ClinicaWhatsApp);
         A348ClinicaFacebook = T000E4_A348ClinicaFacebook[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A348ClinicaFacebook", A348ClinicaFacebook);
         A349ClinicaTwiter = T000E4_A349ClinicaTwiter[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A349ClinicaTwiter", A349ClinicaTwiter);
         A350ClinicaInstagram = T000E4_A350ClinicaInstagram[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A350ClinicaInstagram", A350ClinicaInstagram);
         A351ClinicaLinkedin = T000E4_A351ClinicaLinkedin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A351ClinicaLinkedin", A351ClinicaLinkedin);
         A120ClinicaTiempoDeCita = T000E4_A120ClinicaTiempoDeCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
         A121ClinicaEstado = T000E4_A121ClinicaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A121ClinicaEstado", A121ClinicaEstado);
         zm0E21( -11) ;
      }
      pr_default.close(2);
      onLoadActions0E21( ) ;
   }

   public void onLoadActions0E21( )
   {
      AV16Pgmname = "Clinica" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
   }

   public void checkExtendedTable0E21( )
   {
      nIsDirty_21 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV16Pgmname = "Clinica" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      if ( ! ( GxRegex.IsMatch(A340ClinicaCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Correo no coincide con el patrón especificado", "OutOfRange", 1, "CLINICACORREO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaCorreo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A341ClinicaMoneda == 1 ) || ( A341ClinicaMoneda == 2 ) || ( A341ClinicaMoneda == 3 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Clinica Moneda fuera de rango", "OutOfRange", 1, "CLINICAMONEDA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbClinicaMoneda.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A348ClinicaFacebook,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Facebook no coincide con el patrón especificado", "OutOfRange", 1, "CLINICAFACEBOOK");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaFacebook_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A349ClinicaTwiter,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Twiter no coincide con el patrón especificado", "OutOfRange", 1, "CLINICATWITER");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaTwiter_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A350ClinicaInstagram,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Instagram no coincide con el patrón especificado", "OutOfRange", 1, "CLINICAINSTAGRAM");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaInstagram_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A351ClinicaLinkedin,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Clinica Linkedin no coincide con el patrón especificado", "OutOfRange", 1, "CLINICALINKEDIN");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaLinkedin_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A120ClinicaTiempoDeCita == 30 ) || ( A120ClinicaTiempoDeCita == 60 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Tiempo De Cita fuera de rango", "OutOfRange", 1, "CLINICATIEMPODECITA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbClinicaTiempoDeCita.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A121ClinicaEstado, "A") == 0 ) || ( GXutil.strcmp(A121ClinicaEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Clinica Estado fuera de rango", "OutOfRange", 1, "CLINICAESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbClinicaEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0E21( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0E21( )
   {
      /* Using cursor T000E5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound21 = (short)(1) ;
      }
      else
      {
         RcdFound21 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000E3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0E21( 11) ;
         RcdFound21 = (short)(1) ;
         A28ClinicaId = T000E3_A28ClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
         A118ClinicaRUC = T000E3_A118ClinicaRUC[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
         A116ClinicaNombreComercial = T000E3_A116ClinicaNombreComercial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
         A80ClinicaNombreAbreviado = T000E3_A80ClinicaNombreAbreviado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A80ClinicaNombreAbreviado", A80ClinicaNombreAbreviado);
         A119ClinicaDireccionComercial = T000E3_A119ClinicaDireccionComercial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A119ClinicaDireccionComercial", A119ClinicaDireccionComercial);
         A340ClinicaCorreo = T000E3_A340ClinicaCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A340ClinicaCorreo", A340ClinicaCorreo);
         A341ClinicaMoneda = T000E3_A341ClinicaMoneda[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
         A117ClinicaLogo = T000E3_A117ClinicaLogo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A117ClinicaLogo", A117ClinicaLogo);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
         A40000ClinicaLogo_GXI = T000E3_A40000ClinicaLogo_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
         A342ClinicaLogoHeader = T000E3_A342ClinicaLogoHeader[0] ;
         n342ClinicaLogoHeader = T000E3_n342ClinicaLogoHeader[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A342ClinicaLogoHeader", A342ClinicaLogoHeader);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
         A40001ClinicaLogoHeader_GXI = T000E3_A40001ClinicaLogoHeader_GXI[0] ;
         n40001ClinicaLogoHeader_GXI = T000E3_n40001ClinicaLogoHeader_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
         A343ClinicaLogoFactura = T000E3_A343ClinicaLogoFactura[0] ;
         n343ClinicaLogoFactura = T000E3_n343ClinicaLogoFactura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A343ClinicaLogoFactura", A343ClinicaLogoFactura);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
         A40002ClinicaLogoFactura_GXI = T000E3_A40002ClinicaLogoFactura_GXI[0] ;
         n40002ClinicaLogoFactura_GXI = T000E3_n40002ClinicaLogoFactura_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
         A344ClinicaLogoBoleta = T000E3_A344ClinicaLogoBoleta[0] ;
         n344ClinicaLogoBoleta = T000E3_n344ClinicaLogoBoleta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A344ClinicaLogoBoleta", A344ClinicaLogoBoleta);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
         A40003ClinicaLogoBoleta_GXI = T000E3_A40003ClinicaLogoBoleta_GXI[0] ;
         n40003ClinicaLogoBoleta_GXI = T000E3_n40003ClinicaLogoBoleta_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
         A345ClinicaLogoPago = T000E3_A345ClinicaLogoPago[0] ;
         n345ClinicaLogoPago = T000E3_n345ClinicaLogoPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A345ClinicaLogoPago", A345ClinicaLogoPago);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
         A40004ClinicaLogoPago_GXI = T000E3_A40004ClinicaLogoPago_GXI[0] ;
         n40004ClinicaLogoPago_GXI = T000E3_n40004ClinicaLogoPago_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
         A346ClinicaTelefono = T000E3_A346ClinicaTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A346ClinicaTelefono", A346ClinicaTelefono);
         A347ClinicaWhatsApp = T000E3_A347ClinicaWhatsApp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A347ClinicaWhatsApp", A347ClinicaWhatsApp);
         A348ClinicaFacebook = T000E3_A348ClinicaFacebook[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A348ClinicaFacebook", A348ClinicaFacebook);
         A349ClinicaTwiter = T000E3_A349ClinicaTwiter[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A349ClinicaTwiter", A349ClinicaTwiter);
         A350ClinicaInstagram = T000E3_A350ClinicaInstagram[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A350ClinicaInstagram", A350ClinicaInstagram);
         A351ClinicaLinkedin = T000E3_A351ClinicaLinkedin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A351ClinicaLinkedin", A351ClinicaLinkedin);
         A120ClinicaTiempoDeCita = T000E3_A120ClinicaTiempoDeCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
         A121ClinicaEstado = T000E3_A121ClinicaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A121ClinicaEstado", A121ClinicaEstado);
         Z28ClinicaId = A28ClinicaId ;
         sMode21 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0E21( ) ;
         if ( AnyError == 1 )
         {
            RcdFound21 = (short)(0) ;
            initializeNonKey0E21( ) ;
         }
         Gx_mode = sMode21 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound21 = (short)(0) ;
         initializeNonKey0E21( ) ;
         sMode21 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode21 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0E21( ) ;
      if ( RcdFound21 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound21 = (short)(0) ;
      /* Using cursor T000E6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T000E6_A28ClinicaId[0] < A28ClinicaId ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T000E6_A28ClinicaId[0] > A28ClinicaId ) ) )
         {
            A28ClinicaId = T000E6_A28ClinicaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
            RcdFound21 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound21 = (short)(0) ;
      /* Using cursor T000E7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T000E7_A28ClinicaId[0] > A28ClinicaId ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T000E7_A28ClinicaId[0] < A28ClinicaId ) ) )
         {
            A28ClinicaId = T000E7_A28ClinicaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
            RcdFound21 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0E21( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtClinicaRUC_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0E21( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound21 == 1 )
         {
            if ( A28ClinicaId != Z28ClinicaId )
            {
               A28ClinicaId = Z28ClinicaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLINICAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtClinicaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtClinicaRUC_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0E21( ) ;
               GX_FocusControl = edtClinicaRUC_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A28ClinicaId != Z28ClinicaId )
            {
               /* Insert record */
               GX_FocusControl = edtClinicaRUC_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0E21( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLINICAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtClinicaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtClinicaRUC_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0E21( ) ;
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
      if ( A28ClinicaId != Z28ClinicaId )
      {
         A28ClinicaId = Z28ClinicaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLINICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtClinicaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtClinicaRUC_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0E21( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000E2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A28ClinicaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Clinica"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z118ClinicaRUC != T000E2_A118ClinicaRUC[0] ) || ( GXutil.strcmp(Z116ClinicaNombreComercial, T000E2_A116ClinicaNombreComercial[0]) != 0 ) || ( GXutil.strcmp(Z80ClinicaNombreAbreviado, T000E2_A80ClinicaNombreAbreviado[0]) != 0 ) || ( GXutil.strcmp(Z119ClinicaDireccionComercial, T000E2_A119ClinicaDireccionComercial[0]) != 0 ) || ( GXutil.strcmp(Z340ClinicaCorreo, T000E2_A340ClinicaCorreo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z341ClinicaMoneda != T000E2_A341ClinicaMoneda[0] ) || ( GXutil.strcmp(Z346ClinicaTelefono, T000E2_A346ClinicaTelefono[0]) != 0 ) || ( GXutil.strcmp(Z347ClinicaWhatsApp, T000E2_A347ClinicaWhatsApp[0]) != 0 ) || ( GXutil.strcmp(Z348ClinicaFacebook, T000E2_A348ClinicaFacebook[0]) != 0 ) || ( GXutil.strcmp(Z349ClinicaTwiter, T000E2_A349ClinicaTwiter[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z350ClinicaInstagram, T000E2_A350ClinicaInstagram[0]) != 0 ) || ( GXutil.strcmp(Z351ClinicaLinkedin, T000E2_A351ClinicaLinkedin[0]) != 0 ) || ( Z120ClinicaTiempoDeCita != T000E2_A120ClinicaTiempoDeCita[0] ) || ( GXutil.strcmp(Z121ClinicaEstado, T000E2_A121ClinicaEstado[0]) != 0 ) )
         {
            if ( Z118ClinicaRUC != T000E2_A118ClinicaRUC[0] )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaRUC");
               GXutil.writeLogRaw("Old: ",Z118ClinicaRUC);
               GXutil.writeLogRaw("Current: ",T000E2_A118ClinicaRUC[0]);
            }
            if ( GXutil.strcmp(Z116ClinicaNombreComercial, T000E2_A116ClinicaNombreComercial[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaNombreComercial");
               GXutil.writeLogRaw("Old: ",Z116ClinicaNombreComercial);
               GXutil.writeLogRaw("Current: ",T000E2_A116ClinicaNombreComercial[0]);
            }
            if ( GXutil.strcmp(Z80ClinicaNombreAbreviado, T000E2_A80ClinicaNombreAbreviado[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaNombreAbreviado");
               GXutil.writeLogRaw("Old: ",Z80ClinicaNombreAbreviado);
               GXutil.writeLogRaw("Current: ",T000E2_A80ClinicaNombreAbreviado[0]);
            }
            if ( GXutil.strcmp(Z119ClinicaDireccionComercial, T000E2_A119ClinicaDireccionComercial[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaDireccionComercial");
               GXutil.writeLogRaw("Old: ",Z119ClinicaDireccionComercial);
               GXutil.writeLogRaw("Current: ",T000E2_A119ClinicaDireccionComercial[0]);
            }
            if ( GXutil.strcmp(Z340ClinicaCorreo, T000E2_A340ClinicaCorreo[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaCorreo");
               GXutil.writeLogRaw("Old: ",Z340ClinicaCorreo);
               GXutil.writeLogRaw("Current: ",T000E2_A340ClinicaCorreo[0]);
            }
            if ( Z341ClinicaMoneda != T000E2_A341ClinicaMoneda[0] )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaMoneda");
               GXutil.writeLogRaw("Old: ",Z341ClinicaMoneda);
               GXutil.writeLogRaw("Current: ",T000E2_A341ClinicaMoneda[0]);
            }
            if ( GXutil.strcmp(Z346ClinicaTelefono, T000E2_A346ClinicaTelefono[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaTelefono");
               GXutil.writeLogRaw("Old: ",Z346ClinicaTelefono);
               GXutil.writeLogRaw("Current: ",T000E2_A346ClinicaTelefono[0]);
            }
            if ( GXutil.strcmp(Z347ClinicaWhatsApp, T000E2_A347ClinicaWhatsApp[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaWhatsApp");
               GXutil.writeLogRaw("Old: ",Z347ClinicaWhatsApp);
               GXutil.writeLogRaw("Current: ",T000E2_A347ClinicaWhatsApp[0]);
            }
            if ( GXutil.strcmp(Z348ClinicaFacebook, T000E2_A348ClinicaFacebook[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaFacebook");
               GXutil.writeLogRaw("Old: ",Z348ClinicaFacebook);
               GXutil.writeLogRaw("Current: ",T000E2_A348ClinicaFacebook[0]);
            }
            if ( GXutil.strcmp(Z349ClinicaTwiter, T000E2_A349ClinicaTwiter[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaTwiter");
               GXutil.writeLogRaw("Old: ",Z349ClinicaTwiter);
               GXutil.writeLogRaw("Current: ",T000E2_A349ClinicaTwiter[0]);
            }
            if ( GXutil.strcmp(Z350ClinicaInstagram, T000E2_A350ClinicaInstagram[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaInstagram");
               GXutil.writeLogRaw("Old: ",Z350ClinicaInstagram);
               GXutil.writeLogRaw("Current: ",T000E2_A350ClinicaInstagram[0]);
            }
            if ( GXutil.strcmp(Z351ClinicaLinkedin, T000E2_A351ClinicaLinkedin[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaLinkedin");
               GXutil.writeLogRaw("Old: ",Z351ClinicaLinkedin);
               GXutil.writeLogRaw("Current: ",T000E2_A351ClinicaLinkedin[0]);
            }
            if ( Z120ClinicaTiempoDeCita != T000E2_A120ClinicaTiempoDeCita[0] )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaTiempoDeCita");
               GXutil.writeLogRaw("Old: ",Z120ClinicaTiempoDeCita);
               GXutil.writeLogRaw("Current: ",T000E2_A120ClinicaTiempoDeCita[0]);
            }
            if ( GXutil.strcmp(Z121ClinicaEstado, T000E2_A121ClinicaEstado[0]) != 0 )
            {
               GXutil.writeLogln("clinica:[seudo value changed for attri]"+"ClinicaEstado");
               GXutil.writeLogRaw("Old: ",Z121ClinicaEstado);
               GXutil.writeLogRaw("Current: ",T000E2_A121ClinicaEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Clinica"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0E21( )
   {
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0E21( 0) ;
         checkOptimisticConcurrency0E21( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E21( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0E21( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000E8 */
                  pr_default.execute(6, new Object[] {Long.valueOf(A118ClinicaRUC), A116ClinicaNombreComercial, A80ClinicaNombreAbreviado, A119ClinicaDireccionComercial, A340ClinicaCorreo, Short.valueOf(A341ClinicaMoneda), A117ClinicaLogo, A40000ClinicaLogo_GXI, Boolean.valueOf(n342ClinicaLogoHeader), A342ClinicaLogoHeader, Boolean.valueOf(n40001ClinicaLogoHeader_GXI), A40001ClinicaLogoHeader_GXI, Boolean.valueOf(n343ClinicaLogoFactura), A343ClinicaLogoFactura, Boolean.valueOf(n40002ClinicaLogoFactura_GXI), A40002ClinicaLogoFactura_GXI, Boolean.valueOf(n344ClinicaLogoBoleta), A344ClinicaLogoBoleta, Boolean.valueOf(n40003ClinicaLogoBoleta_GXI), A40003ClinicaLogoBoleta_GXI, Boolean.valueOf(n345ClinicaLogoPago), A345ClinicaLogoPago, Boolean.valueOf(n40004ClinicaLogoPago_GXI), A40004ClinicaLogoPago_GXI, A346ClinicaTelefono, A347ClinicaWhatsApp, A348ClinicaFacebook, A349ClinicaTwiter, A350ClinicaInstagram, A351ClinicaLinkedin, Byte.valueOf(A120ClinicaTiempoDeCita), A121ClinicaEstado});
                  A28ClinicaId = T000E8_A28ClinicaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0E0( ) ;
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
            load0E21( ) ;
         }
         endLevel0E21( ) ;
      }
      closeExtendedTableCursors0E21( ) ;
   }

   public void update0E21( )
   {
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E21( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E21( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0E21( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000E9 */
                  pr_default.execute(7, new Object[] {Long.valueOf(A118ClinicaRUC), A116ClinicaNombreComercial, A80ClinicaNombreAbreviado, A119ClinicaDireccionComercial, A340ClinicaCorreo, Short.valueOf(A341ClinicaMoneda), A346ClinicaTelefono, A347ClinicaWhatsApp, A348ClinicaFacebook, A349ClinicaTwiter, A350ClinicaInstagram, A351ClinicaLinkedin, Byte.valueOf(A120ClinicaTiempoDeCita), A121ClinicaEstado, Short.valueOf(A28ClinicaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Clinica"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0E21( ) ;
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
         endLevel0E21( ) ;
      }
      closeExtendedTableCursors0E21( ) ;
   }

   public void deferredUpdate0E21( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000E10 */
         pr_default.execute(8, new Object[] {A117ClinicaLogo, A40000ClinicaLogo_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000E11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n342ClinicaLogoHeader), A342ClinicaLogoHeader, Boolean.valueOf(n40001ClinicaLogoHeader_GXI), A40001ClinicaLogoHeader_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000E12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n343ClinicaLogoFactura), A343ClinicaLogoFactura, Boolean.valueOf(n40002ClinicaLogoFactura_GXI), A40002ClinicaLogoFactura_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000E13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n344ClinicaLogoBoleta), A344ClinicaLogoBoleta, Boolean.valueOf(n40003ClinicaLogoBoleta_GXI), A40003ClinicaLogoBoleta_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000E14 */
         pr_default.execute(12, new Object[] {Boolean.valueOf(n345ClinicaLogoPago), A345ClinicaLogoPago, Boolean.valueOf(n40004ClinicaLogoPago_GXI), A40004ClinicaLogoPago_GXI, Short.valueOf(A28ClinicaId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
      }
   }

   public void delete( )
   {
      beforeValidate0E21( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0E21( ) ;
         afterConfirm0E21( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0E21( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000E15 */
               pr_default.execute(13, new Object[] {Short.valueOf(A28ClinicaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Clinica");
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
      sMode21 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0E21( ) ;
      Gx_mode = sMode21 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0E21( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "Clinica" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000E16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A28ClinicaId)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sede"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void endLevel0E21( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0E21( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "clinica");
         if ( AnyError == 0 )
         {
            confirmValues0E0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "clinica");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0E21( )
   {
      /* Scan By routine */
      /* Using cursor T000E17 */
      pr_default.execute(15);
      RcdFound21 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound21 = (short)(1) ;
         A28ClinicaId = T000E17_A28ClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0E21( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound21 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound21 = (short)(1) ;
         A28ClinicaId = T000E17_A28ClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      }
   }

   public void scanEnd0E21( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0E21( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0E21( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0E21( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0E21( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0E21( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0E21( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0E21( )
   {
      edtClinicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaId_Enabled), 5, 0), true);
      edtClinicaRUC_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaRUC_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaRUC_Enabled), 5, 0), true);
      edtClinicaNombreComercial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreComercial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreComercial_Enabled), 5, 0), true);
      edtClinicaNombreAbreviado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreAbreviado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreAbreviado_Enabled), 5, 0), true);
      edtClinicaDireccionComercial_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaDireccionComercial_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaDireccionComercial_Enabled), 5, 0), true);
      edtClinicaCorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaCorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaCorreo_Enabled), 5, 0), true);
      cmbClinicaMoneda.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaMoneda.getInternalname(), "Enabled", GXutil.ltrimstr( cmbClinicaMoneda.getEnabled(), 5, 0), true);
      imgClinicaLogo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgClinicaLogo_Enabled), 5, 0), true);
      imgClinicaLogoHeader_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgClinicaLogoHeader_Enabled), 5, 0), true);
      imgClinicaLogoFactura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgClinicaLogoFactura_Enabled), 5, 0), true);
      imgClinicaLogoBoleta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgClinicaLogoBoleta_Enabled), 5, 0), true);
      imgClinicaLogoPago_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgClinicaLogoPago_Enabled), 5, 0), true);
      edtClinicaTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaTelefono_Enabled), 5, 0), true);
      edtClinicaWhatsApp_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaWhatsApp_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaWhatsApp_Enabled), 5, 0), true);
      edtClinicaFacebook_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaFacebook_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaFacebook_Enabled), 5, 0), true);
      edtClinicaTwiter_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaTwiter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaTwiter_Enabled), 5, 0), true);
      edtClinicaInstagram_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaInstagram_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaInstagram_Enabled), 5, 0), true);
      edtClinicaLinkedin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaLinkedin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaLinkedin_Enabled), 5, 0), true);
      cmbClinicaTiempoDeCita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaTiempoDeCita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbClinicaTiempoDeCita.getEnabled(), 5, 0), true);
      cmbClinicaEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbClinicaEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbClinicaEstado.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0E21( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0E0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110324027", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.clinica", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV15ClinicaId,4,0))}, new String[] {"Gx_mode","ClinicaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Clinica");
      forbiddenHiddens.add("ClinicaId", localUtil.format( DecimalUtil.doubleToDec(A28ClinicaId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("clinica:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z28ClinicaId", GXutil.ltrim( localUtil.ntoc( Z28ClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z118ClinicaRUC", GXutil.ltrim( localUtil.ntoc( Z118ClinicaRUC, (byte)(11), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z116ClinicaNombreComercial", Z116ClinicaNombreComercial);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z80ClinicaNombreAbreviado", Z80ClinicaNombreAbreviado);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z119ClinicaDireccionComercial", Z119ClinicaDireccionComercial);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z340ClinicaCorreo", Z340ClinicaCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z341ClinicaMoneda", GXutil.ltrim( localUtil.ntoc( Z341ClinicaMoneda, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z346ClinicaTelefono", GXutil.rtrim( Z346ClinicaTelefono));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z347ClinicaWhatsApp", GXutil.rtrim( Z347ClinicaWhatsApp));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z348ClinicaFacebook", Z348ClinicaFacebook);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z349ClinicaTwiter", Z349ClinicaTwiter);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z350ClinicaInstagram", Z350ClinicaInstagram);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z351ClinicaLinkedin", Z351ClinicaLinkedin);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z120ClinicaTiempoDeCita", GXutil.ltrim( localUtil.ntoc( Z120ClinicaTiempoDeCita, (byte)(2), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z121ClinicaEstado", GXutil.rtrim( Z121ClinicaEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCLINICAID", GXutil.ltrim( localUtil.ntoc( AV15ClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLINICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15ClinicaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CLINICALOGO_GXI", A40000ClinicaLogo_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CLINICALOGOHEADER_GXI", A40001ClinicaLogoHeader_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CLINICALOGOFACTURA_GXI", A40002ClinicaLogoFactura_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CLINICALOGOBOLETA_GXI", A40003ClinicaLogoBoleta_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CLINICALOGOPAGO_GXI", A40004ClinicaLogoPago_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
      GXCCtlgxBlob = "CLINICALOGO" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A117ClinicaLogo);
      GXCCtlgxBlob = "CLINICALOGOHEADER" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A342ClinicaLogoHeader);
      GXCCtlgxBlob = "CLINICALOGOFACTURA" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A343ClinicaLogoFactura);
      GXCCtlgxBlob = "CLINICALOGOBOLETA" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A344ClinicaLogoBoleta);
      GXCCtlgxBlob = "CLINICALOGOPAGO" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A345ClinicaLogoPago);
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
      return formatLink("com.projectthani.clinica", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV15ClinicaId,4,0))}, new String[] {"Gx_mode","ClinicaId"})  ;
   }

   public String getPgmname( )
   {
      return "Clinica" ;
   }

   public String getPgmdesc( )
   {
      return "Clinica" ;
   }

   public void initializeNonKey0E21( )
   {
      A118ClinicaRUC = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A118ClinicaRUC", GXutil.ltrimstr( DecimalUtil.doubleToDec(A118ClinicaRUC), 11, 0));
      A116ClinicaNombreComercial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A116ClinicaNombreComercial", A116ClinicaNombreComercial);
      A80ClinicaNombreAbreviado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A80ClinicaNombreAbreviado", A80ClinicaNombreAbreviado);
      A119ClinicaDireccionComercial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A119ClinicaDireccionComercial", A119ClinicaDireccionComercial);
      A340ClinicaCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A340ClinicaCorreo", A340ClinicaCorreo);
      A341ClinicaMoneda = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
      A117ClinicaLogo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A117ClinicaLogo", A117ClinicaLogo);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
      A40000ClinicaLogo_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "Bitmap", ((GXutil.strcmp("", A117ClinicaLogo)==0) ? A40000ClinicaLogo_GXI : httpContext.convertURL( httpContext.getResourceRelative(A117ClinicaLogo))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogo_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A117ClinicaLogo), true);
      A342ClinicaLogoHeader = "" ;
      n342ClinicaLogoHeader = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A342ClinicaLogoHeader", A342ClinicaLogoHeader);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
      n342ClinicaLogoHeader = ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? true : false) ;
      A40001ClinicaLogoHeader_GXI = "" ;
      n40001ClinicaLogoHeader_GXI = false ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "Bitmap", ((GXutil.strcmp("", A342ClinicaLogoHeader)==0) ? A40001ClinicaLogoHeader_GXI : httpContext.convertURL( httpContext.getResourceRelative(A342ClinicaLogoHeader))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoHeader_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A342ClinicaLogoHeader), true);
      A343ClinicaLogoFactura = "" ;
      n343ClinicaLogoFactura = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A343ClinicaLogoFactura", A343ClinicaLogoFactura);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
      n343ClinicaLogoFactura = ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? true : false) ;
      A40002ClinicaLogoFactura_GXI = "" ;
      n40002ClinicaLogoFactura_GXI = false ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "Bitmap", ((GXutil.strcmp("", A343ClinicaLogoFactura)==0) ? A40002ClinicaLogoFactura_GXI : httpContext.convertURL( httpContext.getResourceRelative(A343ClinicaLogoFactura))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoFactura_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A343ClinicaLogoFactura), true);
      A344ClinicaLogoBoleta = "" ;
      n344ClinicaLogoBoleta = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A344ClinicaLogoBoleta", A344ClinicaLogoBoleta);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
      n344ClinicaLogoBoleta = ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? true : false) ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      n40003ClinicaLogoBoleta_GXI = false ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "Bitmap", ((GXutil.strcmp("", A344ClinicaLogoBoleta)==0) ? A40003ClinicaLogoBoleta_GXI : httpContext.convertURL( httpContext.getResourceRelative(A344ClinicaLogoBoleta))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoBoleta_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A344ClinicaLogoBoleta), true);
      A345ClinicaLogoPago = "" ;
      n345ClinicaLogoPago = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A345ClinicaLogoPago", A345ClinicaLogoPago);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
      n345ClinicaLogoPago = ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? true : false) ;
      A40004ClinicaLogoPago_GXI = "" ;
      n40004ClinicaLogoPago_GXI = false ;
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "Bitmap", ((GXutil.strcmp("", A345ClinicaLogoPago)==0) ? A40004ClinicaLogoPago_GXI : httpContext.convertURL( httpContext.getResourceRelative(A345ClinicaLogoPago))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgClinicaLogoPago_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A345ClinicaLogoPago), true);
      A346ClinicaTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A346ClinicaTelefono", A346ClinicaTelefono);
      A347ClinicaWhatsApp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A347ClinicaWhatsApp", A347ClinicaWhatsApp);
      A348ClinicaFacebook = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A348ClinicaFacebook", A348ClinicaFacebook);
      A349ClinicaTwiter = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A349ClinicaTwiter", A349ClinicaTwiter);
      A350ClinicaInstagram = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A350ClinicaInstagram", A350ClinicaInstagram);
      A351ClinicaLinkedin = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A351ClinicaLinkedin", A351ClinicaLinkedin);
      A120ClinicaTiempoDeCita = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
      A121ClinicaEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A121ClinicaEstado", A121ClinicaEstado);
      Z118ClinicaRUC = 0 ;
      Z116ClinicaNombreComercial = "" ;
      Z80ClinicaNombreAbreviado = "" ;
      Z119ClinicaDireccionComercial = "" ;
      Z340ClinicaCorreo = "" ;
      Z341ClinicaMoneda = (short)(0) ;
      Z346ClinicaTelefono = "" ;
      Z347ClinicaWhatsApp = "" ;
      Z348ClinicaFacebook = "" ;
      Z349ClinicaTwiter = "" ;
      Z350ClinicaInstagram = "" ;
      Z351ClinicaLinkedin = "" ;
      Z120ClinicaTiempoDeCita = (byte)(0) ;
      Z121ClinicaEstado = "" ;
   }

   public void initAll0E21( )
   {
      A28ClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      initializeNonKey0E21( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110324050", true, true);
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
      httpContext.AddJavascriptSource("clinica.js", "?20225110324050", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtClinicaId_Internalname = "CLINICAID" ;
      edtClinicaRUC_Internalname = "CLINICARUC" ;
      edtClinicaNombreComercial_Internalname = "CLINICANOMBRECOMERCIAL" ;
      edtClinicaNombreAbreviado_Internalname = "CLINICANOMBREABREVIADO" ;
      edtClinicaDireccionComercial_Internalname = "CLINICADIRECCIONCOMERCIAL" ;
      edtClinicaCorreo_Internalname = "CLINICACORREO" ;
      cmbClinicaMoneda.setInternalname( "CLINICAMONEDA" );
      imgClinicaLogo_Internalname = "CLINICALOGO" ;
      imgClinicaLogoHeader_Internalname = "CLINICALOGOHEADER" ;
      imgClinicaLogoFactura_Internalname = "CLINICALOGOFACTURA" ;
      imgClinicaLogoBoleta_Internalname = "CLINICALOGOBOLETA" ;
      imgClinicaLogoPago_Internalname = "CLINICALOGOPAGO" ;
      edtClinicaTelefono_Internalname = "CLINICATELEFONO" ;
      edtClinicaWhatsApp_Internalname = "CLINICAWHATSAPP" ;
      edtClinicaFacebook_Internalname = "CLINICAFACEBOOK" ;
      edtClinicaTwiter_Internalname = "CLINICATWITER" ;
      edtClinicaInstagram_Internalname = "CLINICAINSTAGRAM" ;
      edtClinicaLinkedin_Internalname = "CLINICALINKEDIN" ;
      cmbClinicaTiempoDeCita.setInternalname( "CLINICATIEMPODECITA" );
      cmbClinicaEstado.setInternalname( "CLINICAESTADO" );
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
      Form.setCaption( "Clinica" );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbClinicaEstado.setJsonclick( "" );
      cmbClinicaEstado.setEnabled( 1 );
      cmbClinicaTiempoDeCita.setJsonclick( "" );
      cmbClinicaTiempoDeCita.setEnabled( 1 );
      edtClinicaLinkedin_Jsonclick = "" ;
      edtClinicaLinkedin_Enabled = 1 ;
      edtClinicaInstagram_Jsonclick = "" ;
      edtClinicaInstagram_Enabled = 1 ;
      edtClinicaTwiter_Jsonclick = "" ;
      edtClinicaTwiter_Enabled = 1 ;
      edtClinicaFacebook_Jsonclick = "" ;
      edtClinicaFacebook_Enabled = 1 ;
      edtClinicaWhatsApp_Jsonclick = "" ;
      edtClinicaWhatsApp_Enabled = 1 ;
      edtClinicaTelefono_Jsonclick = "" ;
      edtClinicaTelefono_Enabled = 1 ;
      imgClinicaLogoPago_Enabled = 1 ;
      imgClinicaLogoBoleta_Enabled = 1 ;
      imgClinicaLogoFactura_Enabled = 1 ;
      imgClinicaLogoHeader_Enabled = 1 ;
      imgClinicaLogo_Enabled = 1 ;
      cmbClinicaMoneda.setJsonclick( "" );
      cmbClinicaMoneda.setEnabled( 1 );
      edtClinicaCorreo_Jsonclick = "" ;
      edtClinicaCorreo_Enabled = 1 ;
      edtClinicaDireccionComercial_Enabled = 1 ;
      edtClinicaNombreAbreviado_Jsonclick = "" ;
      edtClinicaNombreAbreviado_Enabled = 1 ;
      edtClinicaNombreComercial_Jsonclick = "" ;
      edtClinicaNombreComercial_Enabled = 1 ;
      edtClinicaRUC_Jsonclick = "" ;
      edtClinicaRUC_Enabled = 1 ;
      edtClinicaId_Jsonclick = "" ;
      edtClinicaId_Enabled = 0 ;
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
      cmbClinicaMoneda.setName( "CLINICAMONEDA" );
      cmbClinicaMoneda.setWebtags( "" );
      cmbClinicaMoneda.addItem("1", "Soles", (short)(0));
      cmbClinicaMoneda.addItem("2", "Dólares", (short)(0));
      cmbClinicaMoneda.addItem("3", "Euros", (short)(0));
      if ( cmbClinicaMoneda.getItemCount() > 0 )
      {
         A341ClinicaMoneda = (short)(GXutil.lval( cmbClinicaMoneda.getValidValue(GXutil.trim( GXutil.str( A341ClinicaMoneda, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A341ClinicaMoneda", GXutil.ltrimstr( DecimalUtil.doubleToDec(A341ClinicaMoneda), 4, 0));
      }
      cmbClinicaTiempoDeCita.setName( "CLINICATIEMPODECITA" );
      cmbClinicaTiempoDeCita.setWebtags( "" );
      cmbClinicaTiempoDeCita.addItem("30", "30 minutos", (short)(0));
      cmbClinicaTiempoDeCita.addItem("60", "1 hora", (short)(0));
      if ( cmbClinicaTiempoDeCita.getItemCount() > 0 )
      {
         A120ClinicaTiempoDeCita = (byte)(GXutil.lval( cmbClinicaTiempoDeCita.getValidValue(GXutil.trim( GXutil.str( A120ClinicaTiempoDeCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A120ClinicaTiempoDeCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A120ClinicaTiempoDeCita), 2, 0));
      }
      cmbClinicaEstado.setName( "CLINICAESTADO" );
      cmbClinicaEstado.setWebtags( "" );
      cmbClinicaEstado.addItem("A", "Activo", (short)(0));
      cmbClinicaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbClinicaEstado.getItemCount() > 0 )
      {
         A121ClinicaEstado = cmbClinicaEstado.getValidValue(A121ClinicaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A121ClinicaEstado", A121ClinicaEstado);
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV15ClinicaId',fld:'vCLINICAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV15ClinicaId',fld:'vCLINICAID',pic:'ZZZ9',hsh:true},{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120E2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CLINICAID","{handler:'valid_Clinicaid',iparms:[]");
      setEventMetadata("VALID_CLINICAID",",oparms:[]}");
      setEventMetadata("VALID_CLINICACORREO","{handler:'valid_Clinicacorreo',iparms:[]");
      setEventMetadata("VALID_CLINICACORREO",",oparms:[]}");
      setEventMetadata("VALID_CLINICAMONEDA","{handler:'valid_Clinicamoneda',iparms:[]");
      setEventMetadata("VALID_CLINICAMONEDA",",oparms:[]}");
      setEventMetadata("VALID_CLINICAFACEBOOK","{handler:'valid_Clinicafacebook',iparms:[]");
      setEventMetadata("VALID_CLINICAFACEBOOK",",oparms:[]}");
      setEventMetadata("VALID_CLINICATWITER","{handler:'valid_Clinicatwiter',iparms:[]");
      setEventMetadata("VALID_CLINICATWITER",",oparms:[]}");
      setEventMetadata("VALID_CLINICAINSTAGRAM","{handler:'valid_Clinicainstagram',iparms:[]");
      setEventMetadata("VALID_CLINICAINSTAGRAM",",oparms:[]}");
      setEventMetadata("VALID_CLINICALINKEDIN","{handler:'valid_Clinicalinkedin',iparms:[]");
      setEventMetadata("VALID_CLINICALINKEDIN",",oparms:[]}");
      setEventMetadata("VALID_CLINICATIEMPODECITA","{handler:'valid_Clinicatiempodecita',iparms:[]");
      setEventMetadata("VALID_CLINICATIEMPODECITA",",oparms:[]}");
      setEventMetadata("VALID_CLINICAESTADO","{handler:'valid_Clinicaestado',iparms:[]");
      setEventMetadata("VALID_CLINICAESTADO",",oparms:[]}");
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
      Z116ClinicaNombreComercial = "" ;
      Z80ClinicaNombreAbreviado = "" ;
      Z119ClinicaDireccionComercial = "" ;
      Z340ClinicaCorreo = "" ;
      Z346ClinicaTelefono = "" ;
      Z347ClinicaWhatsApp = "" ;
      Z348ClinicaFacebook = "" ;
      Z349ClinicaTwiter = "" ;
      Z350ClinicaInstagram = "" ;
      Z351ClinicaLinkedin = "" ;
      Z121ClinicaEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A121ClinicaEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A116ClinicaNombreComercial = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A119ClinicaDireccionComercial = "" ;
      A340ClinicaCorreo = "" ;
      A117ClinicaLogo = "" ;
      A40000ClinicaLogo_GXI = "" ;
      sImgUrl = "" ;
      A342ClinicaLogoHeader = "" ;
      A40001ClinicaLogoHeader_GXI = "" ;
      A343ClinicaLogoFactura = "" ;
      A40002ClinicaLogoFactura_GXI = "" ;
      A344ClinicaLogoBoleta = "" ;
      A40003ClinicaLogoBoleta_GXI = "" ;
      A345ClinicaLogoPago = "" ;
      A40004ClinicaLogoPago_GXI = "" ;
      A346ClinicaTelefono = "" ;
      A347ClinicaWhatsApp = "" ;
      A348ClinicaFacebook = "" ;
      A349ClinicaTwiter = "" ;
      A350ClinicaInstagram = "" ;
      A351ClinicaLinkedin = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV16Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode21 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      Z117ClinicaLogo = "" ;
      Z40000ClinicaLogo_GXI = "" ;
      Z342ClinicaLogoHeader = "" ;
      Z40001ClinicaLogoHeader_GXI = "" ;
      Z343ClinicaLogoFactura = "" ;
      Z40002ClinicaLogoFactura_GXI = "" ;
      Z344ClinicaLogoBoleta = "" ;
      Z40003ClinicaLogoBoleta_GXI = "" ;
      Z345ClinicaLogoPago = "" ;
      Z40004ClinicaLogoPago_GXI = "" ;
      T000E4_A28ClinicaId = new short[1] ;
      T000E4_A118ClinicaRUC = new long[1] ;
      T000E4_A116ClinicaNombreComercial = new String[] {""} ;
      T000E4_A80ClinicaNombreAbreviado = new String[] {""} ;
      T000E4_A119ClinicaDireccionComercial = new String[] {""} ;
      T000E4_A340ClinicaCorreo = new String[] {""} ;
      T000E4_A341ClinicaMoneda = new short[1] ;
      T000E4_A117ClinicaLogo = new String[] {""} ;
      T000E4_A40000ClinicaLogo_GXI = new String[] {""} ;
      T000E4_A342ClinicaLogoHeader = new String[] {""} ;
      T000E4_n342ClinicaLogoHeader = new boolean[] {false} ;
      T000E4_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      T000E4_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      T000E4_A343ClinicaLogoFactura = new String[] {""} ;
      T000E4_n343ClinicaLogoFactura = new boolean[] {false} ;
      T000E4_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      T000E4_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      T000E4_A344ClinicaLogoBoleta = new String[] {""} ;
      T000E4_n344ClinicaLogoBoleta = new boolean[] {false} ;
      T000E4_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      T000E4_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      T000E4_A345ClinicaLogoPago = new String[] {""} ;
      T000E4_n345ClinicaLogoPago = new boolean[] {false} ;
      T000E4_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      T000E4_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      T000E4_A346ClinicaTelefono = new String[] {""} ;
      T000E4_A347ClinicaWhatsApp = new String[] {""} ;
      T000E4_A348ClinicaFacebook = new String[] {""} ;
      T000E4_A349ClinicaTwiter = new String[] {""} ;
      T000E4_A350ClinicaInstagram = new String[] {""} ;
      T000E4_A351ClinicaLinkedin = new String[] {""} ;
      T000E4_A120ClinicaTiempoDeCita = new byte[1] ;
      T000E4_A121ClinicaEstado = new String[] {""} ;
      T000E5_A28ClinicaId = new short[1] ;
      T000E3_A28ClinicaId = new short[1] ;
      T000E3_A118ClinicaRUC = new long[1] ;
      T000E3_A116ClinicaNombreComercial = new String[] {""} ;
      T000E3_A80ClinicaNombreAbreviado = new String[] {""} ;
      T000E3_A119ClinicaDireccionComercial = new String[] {""} ;
      T000E3_A340ClinicaCorreo = new String[] {""} ;
      T000E3_A341ClinicaMoneda = new short[1] ;
      T000E3_A117ClinicaLogo = new String[] {""} ;
      T000E3_A40000ClinicaLogo_GXI = new String[] {""} ;
      T000E3_A342ClinicaLogoHeader = new String[] {""} ;
      T000E3_n342ClinicaLogoHeader = new boolean[] {false} ;
      T000E3_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      T000E3_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      T000E3_A343ClinicaLogoFactura = new String[] {""} ;
      T000E3_n343ClinicaLogoFactura = new boolean[] {false} ;
      T000E3_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      T000E3_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      T000E3_A344ClinicaLogoBoleta = new String[] {""} ;
      T000E3_n344ClinicaLogoBoleta = new boolean[] {false} ;
      T000E3_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      T000E3_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      T000E3_A345ClinicaLogoPago = new String[] {""} ;
      T000E3_n345ClinicaLogoPago = new boolean[] {false} ;
      T000E3_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      T000E3_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      T000E3_A346ClinicaTelefono = new String[] {""} ;
      T000E3_A347ClinicaWhatsApp = new String[] {""} ;
      T000E3_A348ClinicaFacebook = new String[] {""} ;
      T000E3_A349ClinicaTwiter = new String[] {""} ;
      T000E3_A350ClinicaInstagram = new String[] {""} ;
      T000E3_A351ClinicaLinkedin = new String[] {""} ;
      T000E3_A120ClinicaTiempoDeCita = new byte[1] ;
      T000E3_A121ClinicaEstado = new String[] {""} ;
      T000E6_A28ClinicaId = new short[1] ;
      T000E7_A28ClinicaId = new short[1] ;
      T000E2_A28ClinicaId = new short[1] ;
      T000E2_A118ClinicaRUC = new long[1] ;
      T000E2_A116ClinicaNombreComercial = new String[] {""} ;
      T000E2_A80ClinicaNombreAbreviado = new String[] {""} ;
      T000E2_A119ClinicaDireccionComercial = new String[] {""} ;
      T000E2_A340ClinicaCorreo = new String[] {""} ;
      T000E2_A341ClinicaMoneda = new short[1] ;
      T000E2_A117ClinicaLogo = new String[] {""} ;
      T000E2_A40000ClinicaLogo_GXI = new String[] {""} ;
      T000E2_A342ClinicaLogoHeader = new String[] {""} ;
      T000E2_n342ClinicaLogoHeader = new boolean[] {false} ;
      T000E2_A40001ClinicaLogoHeader_GXI = new String[] {""} ;
      T000E2_n40001ClinicaLogoHeader_GXI = new boolean[] {false} ;
      T000E2_A343ClinicaLogoFactura = new String[] {""} ;
      T000E2_n343ClinicaLogoFactura = new boolean[] {false} ;
      T000E2_A40002ClinicaLogoFactura_GXI = new String[] {""} ;
      T000E2_n40002ClinicaLogoFactura_GXI = new boolean[] {false} ;
      T000E2_A344ClinicaLogoBoleta = new String[] {""} ;
      T000E2_n344ClinicaLogoBoleta = new boolean[] {false} ;
      T000E2_A40003ClinicaLogoBoleta_GXI = new String[] {""} ;
      T000E2_n40003ClinicaLogoBoleta_GXI = new boolean[] {false} ;
      T000E2_A345ClinicaLogoPago = new String[] {""} ;
      T000E2_n345ClinicaLogoPago = new boolean[] {false} ;
      T000E2_A40004ClinicaLogoPago_GXI = new String[] {""} ;
      T000E2_n40004ClinicaLogoPago_GXI = new boolean[] {false} ;
      T000E2_A346ClinicaTelefono = new String[] {""} ;
      T000E2_A347ClinicaWhatsApp = new String[] {""} ;
      T000E2_A348ClinicaFacebook = new String[] {""} ;
      T000E2_A349ClinicaTwiter = new String[] {""} ;
      T000E2_A350ClinicaInstagram = new String[] {""} ;
      T000E2_A351ClinicaLinkedin = new String[] {""} ;
      T000E2_A120ClinicaTiempoDeCita = new byte[1] ;
      T000E2_A121ClinicaEstado = new String[] {""} ;
      T000E8_A28ClinicaId = new short[1] ;
      T000E16_A30SedeId = new short[1] ;
      T000E17_A28ClinicaId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.clinica__default(),
         new Object[] {
             new Object[] {
            T000E2_A28ClinicaId, T000E2_A118ClinicaRUC, T000E2_A116ClinicaNombreComercial, T000E2_A80ClinicaNombreAbreviado, T000E2_A119ClinicaDireccionComercial, T000E2_A340ClinicaCorreo, T000E2_A341ClinicaMoneda, T000E2_A117ClinicaLogo, T000E2_A40000ClinicaLogo_GXI, T000E2_A342ClinicaLogoHeader,
            T000E2_n342ClinicaLogoHeader, T000E2_A40001ClinicaLogoHeader_GXI, T000E2_n40001ClinicaLogoHeader_GXI, T000E2_A343ClinicaLogoFactura, T000E2_n343ClinicaLogoFactura, T000E2_A40002ClinicaLogoFactura_GXI, T000E2_n40002ClinicaLogoFactura_GXI, T000E2_A344ClinicaLogoBoleta, T000E2_n344ClinicaLogoBoleta, T000E2_A40003ClinicaLogoBoleta_GXI,
            T000E2_n40003ClinicaLogoBoleta_GXI, T000E2_A345ClinicaLogoPago, T000E2_n345ClinicaLogoPago, T000E2_A40004ClinicaLogoPago_GXI, T000E2_n40004ClinicaLogoPago_GXI, T000E2_A346ClinicaTelefono, T000E2_A347ClinicaWhatsApp, T000E2_A348ClinicaFacebook, T000E2_A349ClinicaTwiter, T000E2_A350ClinicaInstagram,
            T000E2_A351ClinicaLinkedin, T000E2_A120ClinicaTiempoDeCita, T000E2_A121ClinicaEstado
            }
            , new Object[] {
            T000E3_A28ClinicaId, T000E3_A118ClinicaRUC, T000E3_A116ClinicaNombreComercial, T000E3_A80ClinicaNombreAbreviado, T000E3_A119ClinicaDireccionComercial, T000E3_A340ClinicaCorreo, T000E3_A341ClinicaMoneda, T000E3_A117ClinicaLogo, T000E3_A40000ClinicaLogo_GXI, T000E3_A342ClinicaLogoHeader,
            T000E3_n342ClinicaLogoHeader, T000E3_A40001ClinicaLogoHeader_GXI, T000E3_n40001ClinicaLogoHeader_GXI, T000E3_A343ClinicaLogoFactura, T000E3_n343ClinicaLogoFactura, T000E3_A40002ClinicaLogoFactura_GXI, T000E3_n40002ClinicaLogoFactura_GXI, T000E3_A344ClinicaLogoBoleta, T000E3_n344ClinicaLogoBoleta, T000E3_A40003ClinicaLogoBoleta_GXI,
            T000E3_n40003ClinicaLogoBoleta_GXI, T000E3_A345ClinicaLogoPago, T000E3_n345ClinicaLogoPago, T000E3_A40004ClinicaLogoPago_GXI, T000E3_n40004ClinicaLogoPago_GXI, T000E3_A346ClinicaTelefono, T000E3_A347ClinicaWhatsApp, T000E3_A348ClinicaFacebook, T000E3_A349ClinicaTwiter, T000E3_A350ClinicaInstagram,
            T000E3_A351ClinicaLinkedin, T000E3_A120ClinicaTiempoDeCita, T000E3_A121ClinicaEstado
            }
            , new Object[] {
            T000E4_A28ClinicaId, T000E4_A118ClinicaRUC, T000E4_A116ClinicaNombreComercial, T000E4_A80ClinicaNombreAbreviado, T000E4_A119ClinicaDireccionComercial, T000E4_A340ClinicaCorreo, T000E4_A341ClinicaMoneda, T000E4_A117ClinicaLogo, T000E4_A40000ClinicaLogo_GXI, T000E4_A342ClinicaLogoHeader,
            T000E4_n342ClinicaLogoHeader, T000E4_A40001ClinicaLogoHeader_GXI, T000E4_n40001ClinicaLogoHeader_GXI, T000E4_A343ClinicaLogoFactura, T000E4_n343ClinicaLogoFactura, T000E4_A40002ClinicaLogoFactura_GXI, T000E4_n40002ClinicaLogoFactura_GXI, T000E4_A344ClinicaLogoBoleta, T000E4_n344ClinicaLogoBoleta, T000E4_A40003ClinicaLogoBoleta_GXI,
            T000E4_n40003ClinicaLogoBoleta_GXI, T000E4_A345ClinicaLogoPago, T000E4_n345ClinicaLogoPago, T000E4_A40004ClinicaLogoPago_GXI, T000E4_n40004ClinicaLogoPago_GXI, T000E4_A346ClinicaTelefono, T000E4_A347ClinicaWhatsApp, T000E4_A348ClinicaFacebook, T000E4_A349ClinicaTwiter, T000E4_A350ClinicaInstagram,
            T000E4_A351ClinicaLinkedin, T000E4_A120ClinicaTiempoDeCita, T000E4_A121ClinicaEstado
            }
            , new Object[] {
            T000E5_A28ClinicaId
            }
            , new Object[] {
            T000E6_A28ClinicaId
            }
            , new Object[] {
            T000E7_A28ClinicaId
            }
            , new Object[] {
            T000E8_A28ClinicaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000E16_A30SedeId
            }
            , new Object[] {
            T000E17_A28ClinicaId
            }
         }
      );
      AV16Pgmname = "Clinica" ;
   }

   private byte Z120ClinicaTiempoDeCita ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A120ClinicaTiempoDeCita ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV15ClinicaId ;
   private short Z28ClinicaId ;
   private short Z341ClinicaMoneda ;
   private short AV15ClinicaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A341ClinicaMoneda ;
   private short A28ClinicaId ;
   private short RcdFound21 ;
   private short nIsDirty_21 ;
   private int trnEnded ;
   private int edtClinicaId_Enabled ;
   private int edtClinicaRUC_Enabled ;
   private int edtClinicaNombreComercial_Enabled ;
   private int edtClinicaNombreAbreviado_Enabled ;
   private int edtClinicaDireccionComercial_Enabled ;
   private int edtClinicaCorreo_Enabled ;
   private int imgClinicaLogo_Enabled ;
   private int imgClinicaLogoHeader_Enabled ;
   private int imgClinicaLogoFactura_Enabled ;
   private int imgClinicaLogoBoleta_Enabled ;
   private int imgClinicaLogoPago_Enabled ;
   private int edtClinicaTelefono_Enabled ;
   private int edtClinicaWhatsApp_Enabled ;
   private int edtClinicaFacebook_Enabled ;
   private int edtClinicaTwiter_Enabled ;
   private int edtClinicaInstagram_Enabled ;
   private int edtClinicaLinkedin_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private long Z118ClinicaRUC ;
   private long A118ClinicaRUC ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z346ClinicaTelefono ;
   private String Z347ClinicaWhatsApp ;
   private String Z121ClinicaEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtClinicaRUC_Internalname ;
   private String A121ClinicaEstado ;
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
   private String edtClinicaId_Internalname ;
   private String edtClinicaId_Jsonclick ;
   private String TempTags ;
   private String edtClinicaRUC_Jsonclick ;
   private String edtClinicaNombreComercial_Internalname ;
   private String edtClinicaNombreComercial_Jsonclick ;
   private String edtClinicaNombreAbreviado_Internalname ;
   private String edtClinicaNombreAbreviado_Jsonclick ;
   private String edtClinicaDireccionComercial_Internalname ;
   private String edtClinicaCorreo_Internalname ;
   private String edtClinicaCorreo_Jsonclick ;
   private String imgClinicaLogo_Internalname ;
   private String sImgUrl ;
   private String imgClinicaLogoHeader_Internalname ;
   private String imgClinicaLogoFactura_Internalname ;
   private String imgClinicaLogoBoleta_Internalname ;
   private String imgClinicaLogoPago_Internalname ;
   private String edtClinicaTelefono_Internalname ;
   private String A346ClinicaTelefono ;
   private String edtClinicaTelefono_Jsonclick ;
   private String edtClinicaWhatsApp_Internalname ;
   private String A347ClinicaWhatsApp ;
   private String edtClinicaWhatsApp_Jsonclick ;
   private String edtClinicaFacebook_Internalname ;
   private String edtClinicaFacebook_Jsonclick ;
   private String edtClinicaTwiter_Internalname ;
   private String edtClinicaTwiter_Jsonclick ;
   private String edtClinicaInstagram_Internalname ;
   private String edtClinicaInstagram_Jsonclick ;
   private String edtClinicaLinkedin_Internalname ;
   private String edtClinicaLinkedin_Jsonclick ;
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
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String hsh ;
   private String sMode21 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
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
   private boolean A117ClinicaLogo_IsBlob ;
   private boolean A342ClinicaLogoHeader_IsBlob ;
   private boolean A343ClinicaLogoFactura_IsBlob ;
   private boolean A344ClinicaLogoBoleta_IsBlob ;
   private boolean A345ClinicaLogoPago_IsBlob ;
   private boolean n40001ClinicaLogoHeader_GXI ;
   private boolean n40002ClinicaLogoFactura_GXI ;
   private boolean n40003ClinicaLogoBoleta_GXI ;
   private boolean n40004ClinicaLogoPago_GXI ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n342ClinicaLogoHeader ;
   private boolean n343ClinicaLogoFactura ;
   private boolean n344ClinicaLogoBoleta ;
   private boolean n345ClinicaLogoPago ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean Gx_longc ;
   private String Z116ClinicaNombreComercial ;
   private String Z80ClinicaNombreAbreviado ;
   private String Z119ClinicaDireccionComercial ;
   private String Z340ClinicaCorreo ;
   private String Z348ClinicaFacebook ;
   private String Z349ClinicaTwiter ;
   private String Z350ClinicaInstagram ;
   private String Z351ClinicaLinkedin ;
   private String A116ClinicaNombreComercial ;
   private String A80ClinicaNombreAbreviado ;
   private String A119ClinicaDireccionComercial ;
   private String A340ClinicaCorreo ;
   private String A40000ClinicaLogo_GXI ;
   private String A40001ClinicaLogoHeader_GXI ;
   private String A40002ClinicaLogoFactura_GXI ;
   private String A40003ClinicaLogoBoleta_GXI ;
   private String A40004ClinicaLogoPago_GXI ;
   private String A348ClinicaFacebook ;
   private String A349ClinicaTwiter ;
   private String A350ClinicaInstagram ;
   private String A351ClinicaLinkedin ;
   private String Z40000ClinicaLogo_GXI ;
   private String Z40001ClinicaLogoHeader_GXI ;
   private String Z40002ClinicaLogoFactura_GXI ;
   private String Z40003ClinicaLogoBoleta_GXI ;
   private String Z40004ClinicaLogoPago_GXI ;
   private String A117ClinicaLogo ;
   private String A342ClinicaLogoHeader ;
   private String A343ClinicaLogoFactura ;
   private String A344ClinicaLogoBoleta ;
   private String A345ClinicaLogoPago ;
   private String Z117ClinicaLogo ;
   private String Z342ClinicaLogoHeader ;
   private String Z343ClinicaLogoFactura ;
   private String Z344ClinicaLogoBoleta ;
   private String Z345ClinicaLogoPago ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbClinicaMoneda ;
   private HTMLChoice cmbClinicaTiempoDeCita ;
   private HTMLChoice cmbClinicaEstado ;
   private IDataStoreProvider pr_default ;
   private short[] T000E4_A28ClinicaId ;
   private long[] T000E4_A118ClinicaRUC ;
   private String[] T000E4_A116ClinicaNombreComercial ;
   private String[] T000E4_A80ClinicaNombreAbreviado ;
   private String[] T000E4_A119ClinicaDireccionComercial ;
   private String[] T000E4_A340ClinicaCorreo ;
   private short[] T000E4_A341ClinicaMoneda ;
   private String[] T000E4_A117ClinicaLogo ;
   private String[] T000E4_A40000ClinicaLogo_GXI ;
   private String[] T000E4_A342ClinicaLogoHeader ;
   private boolean[] T000E4_n342ClinicaLogoHeader ;
   private String[] T000E4_A40001ClinicaLogoHeader_GXI ;
   private boolean[] T000E4_n40001ClinicaLogoHeader_GXI ;
   private String[] T000E4_A343ClinicaLogoFactura ;
   private boolean[] T000E4_n343ClinicaLogoFactura ;
   private String[] T000E4_A40002ClinicaLogoFactura_GXI ;
   private boolean[] T000E4_n40002ClinicaLogoFactura_GXI ;
   private String[] T000E4_A344ClinicaLogoBoleta ;
   private boolean[] T000E4_n344ClinicaLogoBoleta ;
   private String[] T000E4_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] T000E4_n40003ClinicaLogoBoleta_GXI ;
   private String[] T000E4_A345ClinicaLogoPago ;
   private boolean[] T000E4_n345ClinicaLogoPago ;
   private String[] T000E4_A40004ClinicaLogoPago_GXI ;
   private boolean[] T000E4_n40004ClinicaLogoPago_GXI ;
   private String[] T000E4_A346ClinicaTelefono ;
   private String[] T000E4_A347ClinicaWhatsApp ;
   private String[] T000E4_A348ClinicaFacebook ;
   private String[] T000E4_A349ClinicaTwiter ;
   private String[] T000E4_A350ClinicaInstagram ;
   private String[] T000E4_A351ClinicaLinkedin ;
   private byte[] T000E4_A120ClinicaTiempoDeCita ;
   private String[] T000E4_A121ClinicaEstado ;
   private short[] T000E5_A28ClinicaId ;
   private short[] T000E3_A28ClinicaId ;
   private long[] T000E3_A118ClinicaRUC ;
   private String[] T000E3_A116ClinicaNombreComercial ;
   private String[] T000E3_A80ClinicaNombreAbreviado ;
   private String[] T000E3_A119ClinicaDireccionComercial ;
   private String[] T000E3_A340ClinicaCorreo ;
   private short[] T000E3_A341ClinicaMoneda ;
   private String[] T000E3_A117ClinicaLogo ;
   private String[] T000E3_A40000ClinicaLogo_GXI ;
   private String[] T000E3_A342ClinicaLogoHeader ;
   private boolean[] T000E3_n342ClinicaLogoHeader ;
   private String[] T000E3_A40001ClinicaLogoHeader_GXI ;
   private boolean[] T000E3_n40001ClinicaLogoHeader_GXI ;
   private String[] T000E3_A343ClinicaLogoFactura ;
   private boolean[] T000E3_n343ClinicaLogoFactura ;
   private String[] T000E3_A40002ClinicaLogoFactura_GXI ;
   private boolean[] T000E3_n40002ClinicaLogoFactura_GXI ;
   private String[] T000E3_A344ClinicaLogoBoleta ;
   private boolean[] T000E3_n344ClinicaLogoBoleta ;
   private String[] T000E3_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] T000E3_n40003ClinicaLogoBoleta_GXI ;
   private String[] T000E3_A345ClinicaLogoPago ;
   private boolean[] T000E3_n345ClinicaLogoPago ;
   private String[] T000E3_A40004ClinicaLogoPago_GXI ;
   private boolean[] T000E3_n40004ClinicaLogoPago_GXI ;
   private String[] T000E3_A346ClinicaTelefono ;
   private String[] T000E3_A347ClinicaWhatsApp ;
   private String[] T000E3_A348ClinicaFacebook ;
   private String[] T000E3_A349ClinicaTwiter ;
   private String[] T000E3_A350ClinicaInstagram ;
   private String[] T000E3_A351ClinicaLinkedin ;
   private byte[] T000E3_A120ClinicaTiempoDeCita ;
   private String[] T000E3_A121ClinicaEstado ;
   private short[] T000E6_A28ClinicaId ;
   private short[] T000E7_A28ClinicaId ;
   private short[] T000E2_A28ClinicaId ;
   private long[] T000E2_A118ClinicaRUC ;
   private String[] T000E2_A116ClinicaNombreComercial ;
   private String[] T000E2_A80ClinicaNombreAbreviado ;
   private String[] T000E2_A119ClinicaDireccionComercial ;
   private String[] T000E2_A340ClinicaCorreo ;
   private short[] T000E2_A341ClinicaMoneda ;
   private String[] T000E2_A117ClinicaLogo ;
   private String[] T000E2_A40000ClinicaLogo_GXI ;
   private String[] T000E2_A342ClinicaLogoHeader ;
   private boolean[] T000E2_n342ClinicaLogoHeader ;
   private String[] T000E2_A40001ClinicaLogoHeader_GXI ;
   private boolean[] T000E2_n40001ClinicaLogoHeader_GXI ;
   private String[] T000E2_A343ClinicaLogoFactura ;
   private boolean[] T000E2_n343ClinicaLogoFactura ;
   private String[] T000E2_A40002ClinicaLogoFactura_GXI ;
   private boolean[] T000E2_n40002ClinicaLogoFactura_GXI ;
   private String[] T000E2_A344ClinicaLogoBoleta ;
   private boolean[] T000E2_n344ClinicaLogoBoleta ;
   private String[] T000E2_A40003ClinicaLogoBoleta_GXI ;
   private boolean[] T000E2_n40003ClinicaLogoBoleta_GXI ;
   private String[] T000E2_A345ClinicaLogoPago ;
   private boolean[] T000E2_n345ClinicaLogoPago ;
   private String[] T000E2_A40004ClinicaLogoPago_GXI ;
   private boolean[] T000E2_n40004ClinicaLogoPago_GXI ;
   private String[] T000E2_A346ClinicaTelefono ;
   private String[] T000E2_A347ClinicaWhatsApp ;
   private String[] T000E2_A348ClinicaFacebook ;
   private String[] T000E2_A349ClinicaTwiter ;
   private String[] T000E2_A350ClinicaInstagram ;
   private String[] T000E2_A351ClinicaLinkedin ;
   private byte[] T000E2_A120ClinicaTiempoDeCita ;
   private String[] T000E2_A121ClinicaEstado ;
   private short[] T000E8_A28ClinicaId ;
   private short[] T000E16_A30SedeId ;
   private short[] T000E17_A28ClinicaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
}

final  class clinica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000E2", "SELECT [ClinicaId], [ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado] FROM [Clinica] WITH (UPDLOCK) WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E3", "SELECT [ClinicaId], [ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E4", "SELECT TM1.[ClinicaId], TM1.[ClinicaRUC], TM1.[ClinicaNombreComercial], TM1.[ClinicaNombreAbreviado], TM1.[ClinicaDireccionComercial], TM1.[ClinicaCorreo], TM1.[ClinicaMoneda], TM1.[ClinicaLogo], TM1.[ClinicaLogo_GXI], TM1.[ClinicaLogoHeader], TM1.[ClinicaLogoHeader_GXI], TM1.[ClinicaLogoFactura], TM1.[ClinicaLogoFactura_GXI], TM1.[ClinicaLogoBoleta], TM1.[ClinicaLogoBoleta_GXI], TM1.[ClinicaLogoPago], TM1.[ClinicaLogoPago_GXI], TM1.[ClinicaTelefono], TM1.[ClinicaWhatsApp], TM1.[ClinicaFacebook], TM1.[ClinicaTwiter], TM1.[ClinicaInstagram], TM1.[ClinicaLinkedin], TM1.[ClinicaTiempoDeCita], TM1.[ClinicaEstado] FROM [Clinica] TM1 WHERE TM1.[ClinicaId] = ? ORDER BY TM1.[ClinicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E5", "SELECT [ClinicaId] FROM [Clinica] WHERE [ClinicaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E6", "SELECT TOP 1 [ClinicaId] FROM [Clinica] WHERE ( [ClinicaId] > ?) ORDER BY [ClinicaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E7", "SELECT TOP 1 [ClinicaId] FROM [Clinica] WHERE ( [ClinicaId] < ?) ORDER BY [ClinicaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E8", "INSERT INTO [Clinica]([ClinicaRUC], [ClinicaNombreComercial], [ClinicaNombreAbreviado], [ClinicaDireccionComercial], [ClinicaCorreo], [ClinicaMoneda], [ClinicaLogo], [ClinicaLogo_GXI], [ClinicaLogoHeader], [ClinicaLogoHeader_GXI], [ClinicaLogoFactura], [ClinicaLogoFactura_GXI], [ClinicaLogoBoleta], [ClinicaLogoBoleta_GXI], [ClinicaLogoPago], [ClinicaLogoPago_GXI], [ClinicaTelefono], [ClinicaWhatsApp], [ClinicaFacebook], [ClinicaTwiter], [ClinicaInstagram], [ClinicaLinkedin], [ClinicaTiempoDeCita], [ClinicaEstado]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000E9", "UPDATE [Clinica] SET [ClinicaRUC]=?, [ClinicaNombreComercial]=?, [ClinicaNombreAbreviado]=?, [ClinicaDireccionComercial]=?, [ClinicaCorreo]=?, [ClinicaMoneda]=?, [ClinicaTelefono]=?, [ClinicaWhatsApp]=?, [ClinicaFacebook]=?, [ClinicaTwiter]=?, [ClinicaInstagram]=?, [ClinicaLinkedin]=?, [ClinicaTiempoDeCita]=?, [ClinicaEstado]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000E10", "UPDATE [Clinica] SET [ClinicaLogo]=?, [ClinicaLogo_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000E11", "UPDATE [Clinica] SET [ClinicaLogoHeader]=?, [ClinicaLogoHeader_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000E12", "UPDATE [Clinica] SET [ClinicaLogoFactura]=?, [ClinicaLogoFactura_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000E13", "UPDATE [Clinica] SET [ClinicaLogoBoleta]=?, [ClinicaLogoBoleta_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000E14", "UPDATE [Clinica] SET [ClinicaLogoPago]=?, [ClinicaLogoPago_GXI]=?  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000E15", "DELETE FROM [Clinica]  WHERE [ClinicaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000E16", "SELECT TOP 1 [SedeId] FROM [Sede] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E17", "SELECT [ClinicaId] FROM [Clinica] ORDER BY [ClinicaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getMultimediaFile(8, rslt.getVarchar(9));
               ((String[]) buf[8])[0] = rslt.getMultimediaUri(9);
               ((String[]) buf[9])[0] = rslt.getMultimediaFile(10, rslt.getVarchar(11));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getMultimediaUri(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getMultimediaFile(12, rslt.getVarchar(13));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getMultimediaUri(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getMultimediaFile(14, rslt.getVarchar(15));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getMultimediaUri(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((String[]) buf[23])[0] = rslt.getMultimediaUri(17);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((String[]) buf[25])[0] = rslt.getString(18, 12);
               ((String[]) buf[26])[0] = rslt.getString(19, 15);
               ((String[]) buf[27])[0] = rslt.getVarchar(20);
               ((String[]) buf[28])[0] = rslt.getVarchar(21);
               ((String[]) buf[29])[0] = rslt.getVarchar(22);
               ((String[]) buf[30])[0] = rslt.getVarchar(23);
               ((byte[]) buf[31])[0] = rslt.getByte(24);
               ((String[]) buf[32])[0] = rslt.getString(25, 1);
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
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setVarchar(4, (String)parms[3], 1024, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBLOBFile(7, (String)parms[6], true);
               stmt.setGXDbFileURI(8, (String)parms[7], (String)parms[6], 2048,"Clinica","ClinicaLogo");
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(9, (String)parms[9], true);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(10, (String)parms[11], (String)parms[9], 2048,"Clinica","ClinicaLogoHeader");
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(11, (String)parms[13], true);
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(12, (String)parms[15], (String)parms[13], 2048,"Clinica","ClinicaLogoFactura");
               }
               if ( ((Boolean) parms[16]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(13, (String)parms[17], true);
               }
               if ( ((Boolean) parms[18]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(14, (String)parms[19], (String)parms[17], 2048,"Clinica","ClinicaLogoBoleta");
               }
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(15, (String)parms[21], true);
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setGXDbFileURI(16, (String)parms[23], (String)parms[21], 2048,"Clinica","ClinicaLogoPago");
               }
               stmt.setString(17, (String)parms[24], 12);
               stmt.setString(18, (String)parms[25], 15);
               stmt.setVarchar(19, (String)parms[26], 1000, false);
               stmt.setVarchar(20, (String)parms[27], 1000, false);
               stmt.setVarchar(21, (String)parms[28], 1000, false);
               stmt.setVarchar(22, (String)parms[29], 1000, false);
               stmt.setByte(23, ((Number) parms[30]).byteValue());
               stmt.setString(24, (String)parms[31], 1);
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setVarchar(4, (String)parms[3], 1024, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setString(7, (String)parms[6], 12);
               stmt.setString(8, (String)parms[7], 15);
               stmt.setVarchar(9, (String)parms[8], 1000, false);
               stmt.setVarchar(10, (String)parms[9], 1000, false);
               stmt.setVarchar(11, (String)parms[10], 1000, false);
               stmt.setVarchar(12, (String)parms[11], 1000, false);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setString(14, (String)parms[13], 1);
               stmt.setShort(15, ((Number) parms[14]).shortValue());
               return;
            case 8 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Clinica","ClinicaLogo");
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 9 :
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
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoHeader");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
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
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoFactura");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 11 :
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
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoBoleta");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 12 :
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
                  stmt.setGXDbFileURI(2, (String)parms[3], (String)parms[1], 2048,"Clinica","ClinicaLogoPago");
               }
               stmt.setShort(3, ((Number) parms[4]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

