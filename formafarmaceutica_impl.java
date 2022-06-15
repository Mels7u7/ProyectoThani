package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class formafarmaceutica_impl extends GXDataArea
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
            AV7FormaFarmaceuticaId = (short)(GXutil.lval( httpContext.GetPar( "FormaFarmaceuticaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7FormaFarmaceuticaId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFORMAFARMACEUTICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7FormaFarmaceuticaId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Forma Farmaceutica", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtFormaFarmaceuticaCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public formafarmaceutica_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public formafarmaceutica_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formafarmaceutica_impl.class ));
   }

   public formafarmaceutica_impl( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbFormaFarmaceuticaEstado = new HTMLChoice();
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
      if ( cmbFormaFarmaceuticaEstado.getItemCount() > 0 )
      {
         A163FormaFarmaceuticaEstado = cmbFormaFarmaceuticaEstado.getValidValue(A163FormaFarmaceuticaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A163FormaFarmaceuticaEstado", A163FormaFarmaceuticaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbFormaFarmaceuticaEstado.setValue( GXutil.rtrim( A163FormaFarmaceuticaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbFormaFarmaceuticaEstado.getInternalname(), "Values", cmbFormaFarmaceuticaEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFormaFarmaceuticaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtFormaFarmaceuticaId_Internalname, "Farmaceutica", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtFormaFarmaceuticaId_Internalname, GXutil.ltrim( localUtil.ntoc( A39FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtFormaFarmaceuticaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFormaFarmaceuticaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFormaFarmaceuticaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_FormaFarmaceutica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFormaFarmaceuticaCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtFormaFarmaceuticaCodigo_Internalname, "Farmaceutica Codigo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtFormaFarmaceuticaCodigo_Internalname, A161FormaFarmaceuticaCodigo, GXutil.rtrim( localUtil.format( A161FormaFarmaceuticaCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFormaFarmaceuticaCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFormaFarmaceuticaCodigo_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_FormaFarmaceutica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFormaFarmaceuticaDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtFormaFarmaceuticaDescripcion_Internalname, "Farmaceutica Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtFormaFarmaceuticaDescripcion_Internalname, A162FormaFarmaceuticaDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtFormaFarmaceuticaDescripcion_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_FormaFarmaceutica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbFormaFarmaceuticaEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbFormaFarmaceuticaEstado.getInternalname(), "Farmaceutica Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbFormaFarmaceuticaEstado, cmbFormaFarmaceuticaEstado.getInternalname(), GXutil.rtrim( A163FormaFarmaceuticaEstado), 1, cmbFormaFarmaceuticaEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbFormaFarmaceuticaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(1), "HLP_FormaFarmaceutica.htm");
      cmbFormaFarmaceuticaEstado.setValue( GXutil.rtrim( A163FormaFarmaceuticaEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbFormaFarmaceuticaEstado.getInternalname(), "Values", cmbFormaFarmaceuticaEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFormaFarmaceuticaDescripcion2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtFormaFarmaceuticaDescripcion2_Internalname, "Farmaceutica Descripcion2", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtFormaFarmaceuticaDescripcion2_Internalname, A164FormaFarmaceuticaDescripcion2, GXutil.rtrim( localUtil.format( A164FormaFarmaceuticaDescripcion2, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFormaFarmaceuticaDescripcion2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFormaFarmaceuticaDescripcion2_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_FormaFarmaceutica.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormaFarmaceutica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormaFarmaceutica.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormaFarmaceutica.htm");
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
      e110O2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z39FormaFarmaceuticaId"), ",", ".")) ;
            Z161FormaFarmaceuticaCodigo = httpContext.cgiGet( "Z161FormaFarmaceuticaCodigo") ;
            Z162FormaFarmaceuticaDescripcion = httpContext.cgiGet( "Z162FormaFarmaceuticaDescripcion") ;
            Z163FormaFarmaceuticaEstado = httpContext.cgiGet( "Z163FormaFarmaceuticaEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( "vFORMAFARMACEUTICAID"), ",", ".")) ;
            AV13Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( edtFormaFarmaceuticaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
            A161FormaFarmaceuticaCodigo = httpContext.cgiGet( edtFormaFarmaceuticaCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A161FormaFarmaceuticaCodigo", A161FormaFarmaceuticaCodigo);
            A162FormaFarmaceuticaDescripcion = httpContext.cgiGet( edtFormaFarmaceuticaDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A162FormaFarmaceuticaDescripcion", A162FormaFarmaceuticaDescripcion);
            cmbFormaFarmaceuticaEstado.setValue( httpContext.cgiGet( cmbFormaFarmaceuticaEstado.getInternalname()) );
            A163FormaFarmaceuticaEstado = httpContext.cgiGet( cmbFormaFarmaceuticaEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A163FormaFarmaceuticaEstado", A163FormaFarmaceuticaEstado);
            A164FormaFarmaceuticaDescripcion2 = httpContext.cgiGet( edtFormaFarmaceuticaDescripcion2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A164FormaFarmaceuticaDescripcion2", A164FormaFarmaceuticaDescripcion2);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"FormaFarmaceutica");
            A39FormaFarmaceuticaId = (short)(localUtil.ctol( httpContext.cgiGet( edtFormaFarmaceuticaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
            forbiddenHiddens.add("FormaFarmaceuticaId", localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A39FormaFarmaceuticaId != Z39FormaFarmaceuticaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("formafarmaceutica:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A39FormaFarmaceuticaId = (short)(GXutil.lval( httpContext.GetPar( "FormaFarmaceuticaId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
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
                  sMode32 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode32 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound32 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0O0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "FORMAFARMACEUTICAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
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
                        e110O2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120O2 ();
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
         e120O2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0O32( ) ;
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
         disableAttributes0O32( ) ;
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

   public void confirm_0O0( )
   {
      beforeValidate0O32( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0O32( ) ;
         }
         else
         {
            checkExtendedTable0O32( ) ;
            closeExtendedTableCursors0O32( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0O0( )
   {
   }

   public void e110O2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFormaFarmaceutica_Insert", GXv_boolean3) ;
         formafarmaceutica_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFormaFarmaceutica_Update", GXv_boolean3) ;
         formafarmaceutica_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWFormaFarmaceutica_Delete", GXv_boolean3) ;
         formafarmaceutica_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e120O2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV11TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.formafarmaceuticaww", new String[] {}, new String[] {}) );
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

   public void zm0O32( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z161FormaFarmaceuticaCodigo = T000O3_A161FormaFarmaceuticaCodigo[0] ;
            Z162FormaFarmaceuticaDescripcion = T000O3_A162FormaFarmaceuticaDescripcion[0] ;
            Z163FormaFarmaceuticaEstado = T000O3_A163FormaFarmaceuticaEstado[0] ;
         }
         else
         {
            Z161FormaFarmaceuticaCodigo = A161FormaFarmaceuticaCodigo ;
            Z162FormaFarmaceuticaDescripcion = A162FormaFarmaceuticaDescripcion ;
            Z163FormaFarmaceuticaEstado = A163FormaFarmaceuticaEstado ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z39FormaFarmaceuticaId = A39FormaFarmaceuticaId ;
         Z161FormaFarmaceuticaCodigo = A161FormaFarmaceuticaCodigo ;
         Z162FormaFarmaceuticaDescripcion = A162FormaFarmaceuticaDescripcion ;
         Z163FormaFarmaceuticaEstado = A163FormaFarmaceuticaEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      edtFormaFarmaceuticaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Enabled), 5, 0), true);
      edtFormaFarmaceuticaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7FormaFarmaceuticaId) )
      {
         A39FormaFarmaceuticaId = AV7FormaFarmaceuticaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
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

   public void load0O32( )
   {
      /* Using cursor T000O4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A161FormaFarmaceuticaCodigo = T000O4_A161FormaFarmaceuticaCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A161FormaFarmaceuticaCodigo", A161FormaFarmaceuticaCodigo);
         A162FormaFarmaceuticaDescripcion = T000O4_A162FormaFarmaceuticaDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162FormaFarmaceuticaDescripcion", A162FormaFarmaceuticaDescripcion);
         A163FormaFarmaceuticaEstado = T000O4_A163FormaFarmaceuticaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A163FormaFarmaceuticaEstado", A163FormaFarmaceuticaEstado);
         zm0O32( -5) ;
      }
      pr_default.close(2);
      onLoadActions0O32( ) ;
   }

   public void onLoadActions0O32( )
   {
      AV13Pgmname = "FormaFarmaceutica" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
      httpContext.ajax_rsp_assign_attri("", false, "A164FormaFarmaceuticaDescripcion2", A164FormaFarmaceuticaDescripcion2);
   }

   public void checkExtendedTable0O32( )
   {
      nIsDirty_32 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV13Pgmname = "FormaFarmaceutica" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      nIsDirty_32 = (short)(1) ;
      A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
      httpContext.ajax_rsp_assign_attri("", false, "A164FormaFarmaceuticaDescripcion2", A164FormaFarmaceuticaDescripcion2);
      if ( ! ( ( GXutil.strcmp(A163FormaFarmaceuticaEstado, "A") == 0 ) || ( GXutil.strcmp(A163FormaFarmaceuticaEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Forma Farmaceutica Estado fuera de rango", "OutOfRange", 1, "FORMAFARMACEUTICAESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbFormaFarmaceuticaEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0O32( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0O32( )
   {
      /* Using cursor T000O5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound32 = (short)(1) ;
      }
      else
      {
         RcdFound32 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000O3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0O32( 5) ;
         RcdFound32 = (short)(1) ;
         A39FormaFarmaceuticaId = T000O3_A39FormaFarmaceuticaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
         A161FormaFarmaceuticaCodigo = T000O3_A161FormaFarmaceuticaCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A161FormaFarmaceuticaCodigo", A161FormaFarmaceuticaCodigo);
         A162FormaFarmaceuticaDescripcion = T000O3_A162FormaFarmaceuticaDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A162FormaFarmaceuticaDescripcion", A162FormaFarmaceuticaDescripcion);
         A163FormaFarmaceuticaEstado = T000O3_A163FormaFarmaceuticaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A163FormaFarmaceuticaEstado", A163FormaFarmaceuticaEstado);
         Z39FormaFarmaceuticaId = A39FormaFarmaceuticaId ;
         sMode32 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0O32( ) ;
         if ( AnyError == 1 )
         {
            RcdFound32 = (short)(0) ;
            initializeNonKey0O32( ) ;
         }
         Gx_mode = sMode32 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound32 = (short)(0) ;
         initializeNonKey0O32( ) ;
         sMode32 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode32 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0O32( ) ;
      if ( RcdFound32 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound32 = (short)(0) ;
      /* Using cursor T000O6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T000O6_A39FormaFarmaceuticaId[0] < A39FormaFarmaceuticaId ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T000O6_A39FormaFarmaceuticaId[0] > A39FormaFarmaceuticaId ) ) )
         {
            A39FormaFarmaceuticaId = T000O6_A39FormaFarmaceuticaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
            RcdFound32 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound32 = (short)(0) ;
      /* Using cursor T000O7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T000O7_A39FormaFarmaceuticaId[0] > A39FormaFarmaceuticaId ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T000O7_A39FormaFarmaceuticaId[0] < A39FormaFarmaceuticaId ) ) )
         {
            A39FormaFarmaceuticaId = T000O7_A39FormaFarmaceuticaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
            RcdFound32 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0O32( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtFormaFarmaceuticaCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0O32( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound32 == 1 )
         {
            if ( A39FormaFarmaceuticaId != Z39FormaFarmaceuticaId )
            {
               A39FormaFarmaceuticaId = Z39FormaFarmaceuticaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "FORMAFARMACEUTICAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtFormaFarmaceuticaCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0O32( ) ;
               GX_FocusControl = edtFormaFarmaceuticaCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A39FormaFarmaceuticaId != Z39FormaFarmaceuticaId )
            {
               /* Insert record */
               GX_FocusControl = edtFormaFarmaceuticaCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0O32( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "FORMAFARMACEUTICAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtFormaFarmaceuticaCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0O32( ) ;
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
      if ( A39FormaFarmaceuticaId != Z39FormaFarmaceuticaId )
      {
         A39FormaFarmaceuticaId = Z39FormaFarmaceuticaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "FORMAFARMACEUTICAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFormaFarmaceuticaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtFormaFarmaceuticaCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0O32( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000O2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"FormaFarmaceutica"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z161FormaFarmaceuticaCodigo, T000O2_A161FormaFarmaceuticaCodigo[0]) != 0 ) || ( GXutil.strcmp(Z162FormaFarmaceuticaDescripcion, T000O2_A162FormaFarmaceuticaDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z163FormaFarmaceuticaEstado, T000O2_A163FormaFarmaceuticaEstado[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z161FormaFarmaceuticaCodigo, T000O2_A161FormaFarmaceuticaCodigo[0]) != 0 )
            {
               GXutil.writeLogln("formafarmaceutica:[seudo value changed for attri]"+"FormaFarmaceuticaCodigo");
               GXutil.writeLogRaw("Old: ",Z161FormaFarmaceuticaCodigo);
               GXutil.writeLogRaw("Current: ",T000O2_A161FormaFarmaceuticaCodigo[0]);
            }
            if ( GXutil.strcmp(Z162FormaFarmaceuticaDescripcion, T000O2_A162FormaFarmaceuticaDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("formafarmaceutica:[seudo value changed for attri]"+"FormaFarmaceuticaDescripcion");
               GXutil.writeLogRaw("Old: ",Z162FormaFarmaceuticaDescripcion);
               GXutil.writeLogRaw("Current: ",T000O2_A162FormaFarmaceuticaDescripcion[0]);
            }
            if ( GXutil.strcmp(Z163FormaFarmaceuticaEstado, T000O2_A163FormaFarmaceuticaEstado[0]) != 0 )
            {
               GXutil.writeLogln("formafarmaceutica:[seudo value changed for attri]"+"FormaFarmaceuticaEstado");
               GXutil.writeLogRaw("Old: ",Z163FormaFarmaceuticaEstado);
               GXutil.writeLogRaw("Current: ",T000O2_A163FormaFarmaceuticaEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"FormaFarmaceutica"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0O32( )
   {
      beforeValidate0O32( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0O32( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0O32( 0) ;
         checkOptimisticConcurrency0O32( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0O32( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0O32( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000O8 */
                  pr_default.execute(6, new Object[] {A161FormaFarmaceuticaCodigo, A162FormaFarmaceuticaDescripcion, A163FormaFarmaceuticaEstado});
                  A39FormaFarmaceuticaId = T000O8_A39FormaFarmaceuticaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("FormaFarmaceutica");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0O0( ) ;
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
            load0O32( ) ;
         }
         endLevel0O32( ) ;
      }
      closeExtendedTableCursors0O32( ) ;
   }

   public void update0O32( )
   {
      beforeValidate0O32( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0O32( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0O32( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0O32( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0O32( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000O9 */
                  pr_default.execute(7, new Object[] {A161FormaFarmaceuticaCodigo, A162FormaFarmaceuticaDescripcion, A163FormaFarmaceuticaEstado, Short.valueOf(A39FormaFarmaceuticaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("FormaFarmaceutica");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"FormaFarmaceutica"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0O32( ) ;
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
         endLevel0O32( ) ;
      }
      closeExtendedTableCursors0O32( ) ;
   }

   public void deferredUpdate0O32( )
   {
   }

   public void delete( )
   {
      beforeValidate0O32( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0O32( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0O32( ) ;
         afterConfirm0O32( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0O32( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000O10 */
               pr_default.execute(8, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("FormaFarmaceutica");
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
      sMode32 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0O32( ) ;
      Gx_mode = sMode32 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0O32( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "FormaFarmaceutica" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
         A164FormaFarmaceuticaDescripcion2 = A161FormaFarmaceuticaCodigo + " - " + A162FormaFarmaceuticaDescripcion ;
         httpContext.ajax_rsp_assign_attri("", false, "A164FormaFarmaceuticaDescripcion2", A164FormaFarmaceuticaDescripcion2);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000O11 */
         pr_default.execute(9, new Object[] {Short.valueOf(A39FormaFarmaceuticaId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Petitorio"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
      }
   }

   public void endLevel0O32( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0O32( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "formafarmaceutica");
         if ( AnyError == 0 )
         {
            confirmValues0O0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "formafarmaceutica");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0O32( )
   {
      /* Scan By routine */
      /* Using cursor T000O12 */
      pr_default.execute(10);
      RcdFound32 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A39FormaFarmaceuticaId = T000O12_A39FormaFarmaceuticaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0O32( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound32 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound32 = (short)(1) ;
         A39FormaFarmaceuticaId = T000O12_A39FormaFarmaceuticaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
      }
   }

   public void scanEnd0O32( )
   {
      pr_default.close(10);
   }

   public void afterConfirm0O32( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0O32( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0O32( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0O32( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0O32( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0O32( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0O32( )
   {
      edtFormaFarmaceuticaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaId_Enabled), 5, 0), true);
      edtFormaFarmaceuticaCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaCodigo_Enabled), 5, 0), true);
      edtFormaFarmaceuticaDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaDescripcion_Enabled), 5, 0), true);
      cmbFormaFarmaceuticaEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbFormaFarmaceuticaEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbFormaFarmaceuticaEstado.getEnabled(), 5, 0), true);
      edtFormaFarmaceuticaDescripcion2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFormaFarmaceuticaDescripcion2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFormaFarmaceuticaDescripcion2_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0O32( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0O0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325173", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.formafarmaceutica", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7FormaFarmaceuticaId,4,0))}, new String[] {"Gx_mode","FormaFarmaceuticaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"FormaFarmaceutica");
      forbiddenHiddens.add("FormaFarmaceuticaId", localUtil.format( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("formafarmaceutica:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z39FormaFarmaceuticaId", GXutil.ltrim( localUtil.ntoc( Z39FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z161FormaFarmaceuticaCodigo", Z161FormaFarmaceuticaCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z162FormaFarmaceuticaDescripcion", Z162FormaFarmaceuticaDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z163FormaFarmaceuticaEstado", GXutil.rtrim( Z163FormaFarmaceuticaEstado));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFORMAFARMACEUTICAID", GXutil.ltrim( localUtil.ntoc( AV7FormaFarmaceuticaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFORMAFARMACEUTICAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7FormaFarmaceuticaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV13Pgmname));
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
      return formatLink("com.projectthani.formafarmaceutica", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7FormaFarmaceuticaId,4,0))}, new String[] {"Gx_mode","FormaFarmaceuticaId"})  ;
   }

   public String getPgmname( )
   {
      return "FormaFarmaceutica" ;
   }

   public String getPgmdesc( )
   {
      return "Forma Farmaceutica" ;
   }

   public void initializeNonKey0O32( )
   {
      A164FormaFarmaceuticaDescripcion2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A164FormaFarmaceuticaDescripcion2", A164FormaFarmaceuticaDescripcion2);
      A161FormaFarmaceuticaCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A161FormaFarmaceuticaCodigo", A161FormaFarmaceuticaCodigo);
      A162FormaFarmaceuticaDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A162FormaFarmaceuticaDescripcion", A162FormaFarmaceuticaDescripcion);
      A163FormaFarmaceuticaEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A163FormaFarmaceuticaEstado", A163FormaFarmaceuticaEstado);
      Z161FormaFarmaceuticaCodigo = "" ;
      Z162FormaFarmaceuticaDescripcion = "" ;
      Z163FormaFarmaceuticaEstado = "" ;
   }

   public void initAll0O32( )
   {
      A39FormaFarmaceuticaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A39FormaFarmaceuticaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A39FormaFarmaceuticaId), 4, 0));
      initializeNonKey0O32( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325183", true, true);
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
      httpContext.AddJavascriptSource("formafarmaceutica.js", "?20225110325183", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtFormaFarmaceuticaId_Internalname = "FORMAFARMACEUTICAID" ;
      edtFormaFarmaceuticaCodigo_Internalname = "FORMAFARMACEUTICACODIGO" ;
      edtFormaFarmaceuticaDescripcion_Internalname = "FORMAFARMACEUTICADESCRIPCION" ;
      cmbFormaFarmaceuticaEstado.setInternalname( "FORMAFARMACEUTICAESTADO" );
      edtFormaFarmaceuticaDescripcion2_Internalname = "FORMAFARMACEUTICADESCRIPCION2" ;
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
      Form.setCaption( "Forma Farmaceutica" );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtFormaFarmaceuticaDescripcion2_Jsonclick = "" ;
      edtFormaFarmaceuticaDescripcion2_Enabled = 0 ;
      cmbFormaFarmaceuticaEstado.setJsonclick( "" );
      cmbFormaFarmaceuticaEstado.setEnabled( 1 );
      edtFormaFarmaceuticaDescripcion_Enabled = 1 ;
      edtFormaFarmaceuticaCodigo_Jsonclick = "" ;
      edtFormaFarmaceuticaCodigo_Enabled = 1 ;
      edtFormaFarmaceuticaId_Jsonclick = "" ;
      edtFormaFarmaceuticaId_Enabled = 0 ;
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
      cmbFormaFarmaceuticaEstado.setName( "FORMAFARMACEUTICAESTADO" );
      cmbFormaFarmaceuticaEstado.setWebtags( "" );
      cmbFormaFarmaceuticaEstado.addItem("A", "Activo", (short)(0));
      cmbFormaFarmaceuticaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbFormaFarmaceuticaEstado.getItemCount() > 0 )
      {
         A163FormaFarmaceuticaEstado = cmbFormaFarmaceuticaEstado.getValidValue(A163FormaFarmaceuticaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A163FormaFarmaceuticaEstado", A163FormaFarmaceuticaEstado);
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7FormaFarmaceuticaId',fld:'vFORMAFARMACEUTICAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7FormaFarmaceuticaId',fld:'vFORMAFARMACEUTICAID',pic:'ZZZ9',hsh:true},{av:'A39FormaFarmaceuticaId',fld:'FORMAFARMACEUTICAID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120O2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV11TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_FORMAFARMACEUTICAID","{handler:'valid_Formafarmaceuticaid',iparms:[]");
      setEventMetadata("VALID_FORMAFARMACEUTICAID",",oparms:[]}");
      setEventMetadata("VALID_FORMAFARMACEUTICACODIGO","{handler:'valid_Formafarmaceuticacodigo',iparms:[]");
      setEventMetadata("VALID_FORMAFARMACEUTICACODIGO",",oparms:[]}");
      setEventMetadata("VALID_FORMAFARMACEUTICADESCRIPCION","{handler:'valid_Formafarmaceuticadescripcion',iparms:[]");
      setEventMetadata("VALID_FORMAFARMACEUTICADESCRIPCION",",oparms:[]}");
      setEventMetadata("VALID_FORMAFARMACEUTICAESTADO","{handler:'valid_Formafarmaceuticaestado',iparms:[]");
      setEventMetadata("VALID_FORMAFARMACEUTICAESTADO",",oparms:[]}");
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
      Z161FormaFarmaceuticaCodigo = "" ;
      Z162FormaFarmaceuticaDescripcion = "" ;
      Z163FormaFarmaceuticaEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A163FormaFarmaceuticaEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A161FormaFarmaceuticaCodigo = "" ;
      A162FormaFarmaceuticaDescripcion = "" ;
      A164FormaFarmaceuticaDescripcion2 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV13Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode32 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV8WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV11TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      T000O4_A39FormaFarmaceuticaId = new short[1] ;
      T000O4_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      T000O4_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      T000O4_A163FormaFarmaceuticaEstado = new String[] {""} ;
      T000O5_A39FormaFarmaceuticaId = new short[1] ;
      T000O3_A39FormaFarmaceuticaId = new short[1] ;
      T000O3_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      T000O3_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      T000O3_A163FormaFarmaceuticaEstado = new String[] {""} ;
      T000O6_A39FormaFarmaceuticaId = new short[1] ;
      T000O7_A39FormaFarmaceuticaId = new short[1] ;
      T000O2_A39FormaFarmaceuticaId = new short[1] ;
      T000O2_A161FormaFarmaceuticaCodigo = new String[] {""} ;
      T000O2_A162FormaFarmaceuticaDescripcion = new String[] {""} ;
      T000O2_A163FormaFarmaceuticaEstado = new String[] {""} ;
      T000O8_A39FormaFarmaceuticaId = new short[1] ;
      T000O11_A25PetitorioId = new short[1] ;
      T000O12_A39FormaFarmaceuticaId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.formafarmaceutica__default(),
         new Object[] {
             new Object[] {
            T000O2_A39FormaFarmaceuticaId, T000O2_A161FormaFarmaceuticaCodigo, T000O2_A162FormaFarmaceuticaDescripcion, T000O2_A163FormaFarmaceuticaEstado
            }
            , new Object[] {
            T000O3_A39FormaFarmaceuticaId, T000O3_A161FormaFarmaceuticaCodigo, T000O3_A162FormaFarmaceuticaDescripcion, T000O3_A163FormaFarmaceuticaEstado
            }
            , new Object[] {
            T000O4_A39FormaFarmaceuticaId, T000O4_A161FormaFarmaceuticaCodigo, T000O4_A162FormaFarmaceuticaDescripcion, T000O4_A163FormaFarmaceuticaEstado
            }
            , new Object[] {
            T000O5_A39FormaFarmaceuticaId
            }
            , new Object[] {
            T000O6_A39FormaFarmaceuticaId
            }
            , new Object[] {
            T000O7_A39FormaFarmaceuticaId
            }
            , new Object[] {
            T000O8_A39FormaFarmaceuticaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000O11_A25PetitorioId
            }
            , new Object[] {
            T000O12_A39FormaFarmaceuticaId
            }
         }
      );
      AV13Pgmname = "FormaFarmaceutica" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7FormaFarmaceuticaId ;
   private short Z39FormaFarmaceuticaId ;
   private short AV7FormaFarmaceuticaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A39FormaFarmaceuticaId ;
   private short RcdFound32 ;
   private short nIsDirty_32 ;
   private int trnEnded ;
   private int edtFormaFarmaceuticaId_Enabled ;
   private int edtFormaFarmaceuticaCodigo_Enabled ;
   private int edtFormaFarmaceuticaDescripcion_Enabled ;
   private int edtFormaFarmaceuticaDescripcion2_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z163FormaFarmaceuticaEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtFormaFarmaceuticaCodigo_Internalname ;
   private String A163FormaFarmaceuticaEstado ;
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
   private String edtFormaFarmaceuticaId_Internalname ;
   private String edtFormaFarmaceuticaId_Jsonclick ;
   private String TempTags ;
   private String edtFormaFarmaceuticaCodigo_Jsonclick ;
   private String edtFormaFarmaceuticaDescripcion_Internalname ;
   private String edtFormaFarmaceuticaDescripcion2_Internalname ;
   private String edtFormaFarmaceuticaDescripcion2_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String AV13Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode32 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
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
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z161FormaFarmaceuticaCodigo ;
   private String Z162FormaFarmaceuticaDescripcion ;
   private String A161FormaFarmaceuticaCodigo ;
   private String A162FormaFarmaceuticaDescripcion ;
   private String A164FormaFarmaceuticaDescripcion2 ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbFormaFarmaceuticaEstado ;
   private IDataStoreProvider pr_default ;
   private short[] T000O4_A39FormaFarmaceuticaId ;
   private String[] T000O4_A161FormaFarmaceuticaCodigo ;
   private String[] T000O4_A162FormaFarmaceuticaDescripcion ;
   private String[] T000O4_A163FormaFarmaceuticaEstado ;
   private short[] T000O5_A39FormaFarmaceuticaId ;
   private short[] T000O3_A39FormaFarmaceuticaId ;
   private String[] T000O3_A161FormaFarmaceuticaCodigo ;
   private String[] T000O3_A162FormaFarmaceuticaDescripcion ;
   private String[] T000O3_A163FormaFarmaceuticaEstado ;
   private short[] T000O6_A39FormaFarmaceuticaId ;
   private short[] T000O7_A39FormaFarmaceuticaId ;
   private short[] T000O2_A39FormaFarmaceuticaId ;
   private String[] T000O2_A161FormaFarmaceuticaCodigo ;
   private String[] T000O2_A162FormaFarmaceuticaDescripcion ;
   private String[] T000O2_A163FormaFarmaceuticaEstado ;
   private short[] T000O8_A39FormaFarmaceuticaId ;
   private short[] T000O11_A25PetitorioId ;
   private short[] T000O12_A39FormaFarmaceuticaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class formafarmaceutica__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000O2", "SELECT [FormaFarmaceuticaId], [FormaFarmaceuticaCodigo], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaEstado] FROM [FormaFarmaceutica] WITH (UPDLOCK) WHERE [FormaFarmaceuticaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O3", "SELECT [FormaFarmaceuticaId], [FormaFarmaceuticaCodigo], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaEstado] FROM [FormaFarmaceutica] WHERE [FormaFarmaceuticaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O4", "SELECT TM1.[FormaFarmaceuticaId], TM1.[FormaFarmaceuticaCodigo], TM1.[FormaFarmaceuticaDescripcion], TM1.[FormaFarmaceuticaEstado] FROM [FormaFarmaceutica] TM1 WHERE TM1.[FormaFarmaceuticaId] = ? ORDER BY TM1.[FormaFarmaceuticaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O5", "SELECT [FormaFarmaceuticaId] FROM [FormaFarmaceutica] WHERE [FormaFarmaceuticaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000O6", "SELECT TOP 1 [FormaFarmaceuticaId] FROM [FormaFarmaceutica] WHERE ( [FormaFarmaceuticaId] > ?) ORDER BY [FormaFarmaceuticaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000O7", "SELECT TOP 1 [FormaFarmaceuticaId] FROM [FormaFarmaceutica] WHERE ( [FormaFarmaceuticaId] < ?) ORDER BY [FormaFarmaceuticaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000O8", "INSERT INTO [FormaFarmaceutica]([FormaFarmaceuticaCodigo], [FormaFarmaceuticaDescripcion], [FormaFarmaceuticaEstado]) VALUES(?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000O9", "UPDATE [FormaFarmaceutica] SET [FormaFarmaceuticaCodigo]=?, [FormaFarmaceuticaDescripcion]=?, [FormaFarmaceuticaEstado]=?  WHERE [FormaFarmaceuticaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000O10", "DELETE FROM [FormaFarmaceutica]  WHERE [FormaFarmaceuticaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000O11", "SELECT TOP 1 [PetitorioId] FROM [Petitorio] WHERE [FormaFarmaceuticaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000O12", "SELECT [FormaFarmaceuticaId] FROM [FormaFarmaceutica] ORDER BY [FormaFarmaceuticaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
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
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setString(3, (String)parms[2], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

