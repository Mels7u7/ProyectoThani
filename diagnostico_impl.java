package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class diagnostico_impl extends GXDataArea
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
            AV12DiagnosticoId = (int)(GXutil.lval( httpContext.GetPar( "DiagnosticoId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12DiagnosticoId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDIAGNOSTICOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12DiagnosticoId), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", "Diagnostico", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtDiagnosticoCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public diagnostico_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public diagnostico_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diagnostico_impl.class ));
   }

   public diagnostico_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbDiagnosticoTipoSexo = new HTMLChoice();
      cmbDiagnosticoEstado = new HTMLChoice();
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
      if ( cmbDiagnosticoTipoSexo.getItemCount() > 0 )
      {
         A130DiagnosticoTipoSexo = cmbDiagnosticoTipoSexo.getValidValue(A130DiagnosticoTipoSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A130DiagnosticoTipoSexo", A130DiagnosticoTipoSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDiagnosticoTipoSexo.setValue( GXutil.rtrim( A130DiagnosticoTipoSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDiagnosticoTipoSexo.getInternalname(), "Values", cmbDiagnosticoTipoSexo.ToJavascriptSource(), true);
      }
      if ( cmbDiagnosticoEstado.getItemCount() > 0 )
      {
         A131DiagnosticoEstado = cmbDiagnosticoEstado.getValidValue(A131DiagnosticoEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A131DiagnosticoEstado", A131DiagnosticoEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDiagnosticoEstado.setValue( GXutil.rtrim( A131DiagnosticoEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDiagnosticoEstado.getInternalname(), "Values", cmbDiagnosticoEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDiagnosticoId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDiagnosticoId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDiagnosticoId_Internalname, GXutil.ltrim( localUtil.ntoc( A23DiagnosticoId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtDiagnosticoId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A23DiagnosticoId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A23DiagnosticoId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDiagnosticoId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDiagnosticoId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Diagnostico.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDiagnosticoCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDiagnosticoCodigo_Internalname, "Codigo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDiagnosticoCodigo_Internalname, A107DiagnosticoCodigo, GXutil.rtrim( localUtil.format( A107DiagnosticoCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDiagnosticoCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDiagnosticoCodigo_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Diagnostico.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDiagnosticoDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDiagnosticoDescripcion_Internalname, "Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtDiagnosticoDescripcion_Internalname, A108DiagnosticoDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtDiagnosticoDescripcion_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "1000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Diagnostico.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDiagnosticoTipoSexo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDiagnosticoTipoSexo.getInternalname(), "Tipo Sexo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDiagnosticoTipoSexo, cmbDiagnosticoTipoSexo.getInternalname(), GXutil.rtrim( A130DiagnosticoTipoSexo), 1, cmbDiagnosticoTipoSexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDiagnosticoTipoSexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(1), "HLP_Diagnostico.htm");
      cmbDiagnosticoTipoSexo.setValue( GXutil.rtrim( A130DiagnosticoTipoSexo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDiagnosticoTipoSexo.getInternalname(), "Values", cmbDiagnosticoTipoSexo.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDiagnosticoEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDiagnosticoEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDiagnosticoEstado, cmbDiagnosticoEstado.getInternalname(), GXutil.rtrim( A131DiagnosticoEstado), 1, cmbDiagnosticoEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDiagnosticoEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(1), "HLP_Diagnostico.htm");
      cmbDiagnosticoEstado.setValue( GXutil.rtrim( A131DiagnosticoEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDiagnosticoEstado.getInternalname(), "Values", cmbDiagnosticoEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDiagnosticoLongDesc_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDiagnosticoLongDesc_Internalname, "Long Desc", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtDiagnosticoLongDesc_Internalname, A132DiagnosticoLongDesc, "", "", (short)(0), 1, edtDiagnosticoLongDesc_Enabled, 0, 80, "chr", 4, "row", StyleString, ClassString, "", "", "300", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Diagnostico.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Diagnostico.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Diagnostico.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Diagnostico.htm");
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
      e110I2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z23DiagnosticoId = (int)(localUtil.ctol( httpContext.cgiGet( "Z23DiagnosticoId"), ",", ".")) ;
            Z107DiagnosticoCodigo = httpContext.cgiGet( "Z107DiagnosticoCodigo") ;
            Z108DiagnosticoDescripcion = httpContext.cgiGet( "Z108DiagnosticoDescripcion") ;
            Z130DiagnosticoTipoSexo = httpContext.cgiGet( "Z130DiagnosticoTipoSexo") ;
            Z131DiagnosticoEstado = httpContext.cgiGet( "Z131DiagnosticoEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV12DiagnosticoId = (int)(localUtil.ctol( httpContext.cgiGet( "vDIAGNOSTICOID"), ",", ".")) ;
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
            A23DiagnosticoId = (int)(localUtil.ctol( httpContext.cgiGet( edtDiagnosticoId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
            A107DiagnosticoCodigo = httpContext.cgiGet( edtDiagnosticoCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A107DiagnosticoCodigo", A107DiagnosticoCodigo);
            A108DiagnosticoDescripcion = httpContext.cgiGet( edtDiagnosticoDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A108DiagnosticoDescripcion", A108DiagnosticoDescripcion);
            cmbDiagnosticoTipoSexo.setValue( httpContext.cgiGet( cmbDiagnosticoTipoSexo.getInternalname()) );
            A130DiagnosticoTipoSexo = httpContext.cgiGet( cmbDiagnosticoTipoSexo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A130DiagnosticoTipoSexo", A130DiagnosticoTipoSexo);
            cmbDiagnosticoEstado.setValue( httpContext.cgiGet( cmbDiagnosticoEstado.getInternalname()) );
            A131DiagnosticoEstado = httpContext.cgiGet( cmbDiagnosticoEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A131DiagnosticoEstado", A131DiagnosticoEstado);
            A132DiagnosticoLongDesc = httpContext.cgiGet( edtDiagnosticoLongDesc_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A132DiagnosticoLongDesc", A132DiagnosticoLongDesc);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Diagnostico");
            A23DiagnosticoId = (int)(localUtil.ctol( httpContext.cgiGet( edtDiagnosticoId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
            forbiddenHiddens.add("DiagnosticoId", localUtil.format( DecimalUtil.doubleToDec(A23DiagnosticoId), "ZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A23DiagnosticoId != Z23DiagnosticoId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("diagnostico:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A23DiagnosticoId = (int)(GXutil.lval( httpContext.GetPar( "DiagnosticoId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
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
                  sMode25 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode25 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound25 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0I0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "DIAGNOSTICOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtDiagnosticoId_Internalname ;
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
                        e110I2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120I2 ();
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
         e120I2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0I25( ) ;
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
         disableAttributes0I25( ) ;
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

   public void confirm_0I0( )
   {
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0I25( ) ;
         }
         else
         {
            checkExtendedTable0I25( ) ;
            closeExtendedTableCursors0I25( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0I0( )
   {
   }

   public void e110I2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      AV8IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico_Insert", GXv_boolean3) ;
         diagnostico_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico_Update", GXv_boolean3) ;
         diagnostico_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDiagnostico_Delete", GXv_boolean3) ;
         diagnostico_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e120I2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.diagnosticoww", new String[] {}, new String[] {}) );
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

   public void zm0I25( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z107DiagnosticoCodigo = T000I3_A107DiagnosticoCodigo[0] ;
            Z108DiagnosticoDescripcion = T000I3_A108DiagnosticoDescripcion[0] ;
            Z130DiagnosticoTipoSexo = T000I3_A130DiagnosticoTipoSexo[0] ;
            Z131DiagnosticoEstado = T000I3_A131DiagnosticoEstado[0] ;
         }
         else
         {
            Z107DiagnosticoCodigo = A107DiagnosticoCodigo ;
            Z108DiagnosticoDescripcion = A108DiagnosticoDescripcion ;
            Z130DiagnosticoTipoSexo = A130DiagnosticoTipoSexo ;
            Z131DiagnosticoEstado = A131DiagnosticoEstado ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z23DiagnosticoId = A23DiagnosticoId ;
         Z107DiagnosticoCodigo = A107DiagnosticoCodigo ;
         Z108DiagnosticoDescripcion = A108DiagnosticoDescripcion ;
         Z130DiagnosticoTipoSexo = A130DiagnosticoTipoSexo ;
         Z131DiagnosticoEstado = A131DiagnosticoEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      edtDiagnosticoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDiagnosticoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDiagnosticoId_Enabled), 5, 0), true);
      edtDiagnosticoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDiagnosticoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDiagnosticoId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV12DiagnosticoId) )
      {
         A23DiagnosticoId = AV12DiagnosticoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
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

   public void load0I25( )
   {
      /* Using cursor T000I4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A107DiagnosticoCodigo = T000I4_A107DiagnosticoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A107DiagnosticoCodigo", A107DiagnosticoCodigo);
         A108DiagnosticoDescripcion = T000I4_A108DiagnosticoDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A108DiagnosticoDescripcion", A108DiagnosticoDescripcion);
         A130DiagnosticoTipoSexo = T000I4_A130DiagnosticoTipoSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A130DiagnosticoTipoSexo", A130DiagnosticoTipoSexo);
         A131DiagnosticoEstado = T000I4_A131DiagnosticoEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A131DiagnosticoEstado", A131DiagnosticoEstado);
         zm0I25( -6) ;
      }
      pr_default.close(2);
      onLoadActions0I25( ) ;
   }

   public void onLoadActions0I25( )
   {
      AV13Pgmname = "Diagnostico" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
      httpContext.ajax_rsp_assign_attri("", false, "A132DiagnosticoLongDesc", A132DiagnosticoLongDesc);
   }

   public void checkExtendedTable0I25( )
   {
      nIsDirty_25 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV13Pgmname = "Diagnostico" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      nIsDirty_25 = (short)(1) ;
      A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
      httpContext.ajax_rsp_assign_attri("", false, "A132DiagnosticoLongDesc", A132DiagnosticoLongDesc);
      if ( ! ( ( GXutil.strcmp(A130DiagnosticoTipoSexo, "M") == 0 ) || ( GXutil.strcmp(A130DiagnosticoTipoSexo, "F") == 0 ) || ( GXutil.strcmp(A130DiagnosticoTipoSexo, "A") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Diagnostico Tipo Sexo fuera de rango", "OutOfRange", 1, "DIAGNOSTICOTIPOSEXO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDiagnosticoTipoSexo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A131DiagnosticoEstado, "A") == 0 ) || ( GXutil.strcmp(A131DiagnosticoEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Diagnostico Estado fuera de rango", "OutOfRange", 1, "DIAGNOSTICOESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDiagnosticoEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0I25( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0I25( )
   {
      /* Using cursor T000I5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound25 = (short)(1) ;
      }
      else
      {
         RcdFound25 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000I3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0I25( 6) ;
         RcdFound25 = (short)(1) ;
         A23DiagnosticoId = T000I3_A23DiagnosticoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
         A107DiagnosticoCodigo = T000I3_A107DiagnosticoCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A107DiagnosticoCodigo", A107DiagnosticoCodigo);
         A108DiagnosticoDescripcion = T000I3_A108DiagnosticoDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A108DiagnosticoDescripcion", A108DiagnosticoDescripcion);
         A130DiagnosticoTipoSexo = T000I3_A130DiagnosticoTipoSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A130DiagnosticoTipoSexo", A130DiagnosticoTipoSexo);
         A131DiagnosticoEstado = T000I3_A131DiagnosticoEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A131DiagnosticoEstado", A131DiagnosticoEstado);
         Z23DiagnosticoId = A23DiagnosticoId ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0I25( ) ;
         if ( AnyError == 1 )
         {
            RcdFound25 = (short)(0) ;
            initializeNonKey0I25( ) ;
         }
         Gx_mode = sMode25 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound25 = (short)(0) ;
         initializeNonKey0I25( ) ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode25 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0I25( ) ;
      if ( RcdFound25 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound25 = (short)(0) ;
      /* Using cursor T000I6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( T000I6_A23DiagnosticoId[0] < A23DiagnosticoId ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( T000I6_A23DiagnosticoId[0] > A23DiagnosticoId ) ) )
         {
            A23DiagnosticoId = T000I6_A23DiagnosticoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
            RcdFound25 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound25 = (short)(0) ;
      /* Using cursor T000I7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A23DiagnosticoId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( T000I7_A23DiagnosticoId[0] > A23DiagnosticoId ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( T000I7_A23DiagnosticoId[0] < A23DiagnosticoId ) ) )
         {
            A23DiagnosticoId = T000I7_A23DiagnosticoId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
            RcdFound25 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0I25( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtDiagnosticoCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0I25( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound25 == 1 )
         {
            if ( A23DiagnosticoId != Z23DiagnosticoId )
            {
               A23DiagnosticoId = Z23DiagnosticoId ;
               httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "DIAGNOSTICOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDiagnosticoId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtDiagnosticoCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0I25( ) ;
               GX_FocusControl = edtDiagnosticoCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A23DiagnosticoId != Z23DiagnosticoId )
            {
               /* Insert record */
               GX_FocusControl = edtDiagnosticoCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0I25( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "DIAGNOSTICOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtDiagnosticoId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtDiagnosticoCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0I25( ) ;
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
      if ( A23DiagnosticoId != Z23DiagnosticoId )
      {
         A23DiagnosticoId = Z23DiagnosticoId ;
         httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "DIAGNOSTICOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDiagnosticoId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtDiagnosticoCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0I25( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000I2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A23DiagnosticoId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Diagnostico"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z107DiagnosticoCodigo, T000I2_A107DiagnosticoCodigo[0]) != 0 ) || ( GXutil.strcmp(Z108DiagnosticoDescripcion, T000I2_A108DiagnosticoDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z130DiagnosticoTipoSexo, T000I2_A130DiagnosticoTipoSexo[0]) != 0 ) || ( GXutil.strcmp(Z131DiagnosticoEstado, T000I2_A131DiagnosticoEstado[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z107DiagnosticoCodigo, T000I2_A107DiagnosticoCodigo[0]) != 0 )
            {
               GXutil.writeLogln("diagnostico:[seudo value changed for attri]"+"DiagnosticoCodigo");
               GXutil.writeLogRaw("Old: ",Z107DiagnosticoCodigo);
               GXutil.writeLogRaw("Current: ",T000I2_A107DiagnosticoCodigo[0]);
            }
            if ( GXutil.strcmp(Z108DiagnosticoDescripcion, T000I2_A108DiagnosticoDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("diagnostico:[seudo value changed for attri]"+"DiagnosticoDescripcion");
               GXutil.writeLogRaw("Old: ",Z108DiagnosticoDescripcion);
               GXutil.writeLogRaw("Current: ",T000I2_A108DiagnosticoDescripcion[0]);
            }
            if ( GXutil.strcmp(Z130DiagnosticoTipoSexo, T000I2_A130DiagnosticoTipoSexo[0]) != 0 )
            {
               GXutil.writeLogln("diagnostico:[seudo value changed for attri]"+"DiagnosticoTipoSexo");
               GXutil.writeLogRaw("Old: ",Z130DiagnosticoTipoSexo);
               GXutil.writeLogRaw("Current: ",T000I2_A130DiagnosticoTipoSexo[0]);
            }
            if ( GXutil.strcmp(Z131DiagnosticoEstado, T000I2_A131DiagnosticoEstado[0]) != 0 )
            {
               GXutil.writeLogln("diagnostico:[seudo value changed for attri]"+"DiagnosticoEstado");
               GXutil.writeLogRaw("Old: ",Z131DiagnosticoEstado);
               GXutil.writeLogRaw("Current: ",T000I2_A131DiagnosticoEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Diagnostico"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0I25( )
   {
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0I25( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0I25( 0) ;
         checkOptimisticConcurrency0I25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0I25( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0I25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000I8 */
                  pr_default.execute(6, new Object[] {A107DiagnosticoCodigo, A108DiagnosticoDescripcion, A130DiagnosticoTipoSexo, A131DiagnosticoEstado});
                  A23DiagnosticoId = T000I8_A23DiagnosticoId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Diagnostico");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0I0( ) ;
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
            load0I25( ) ;
         }
         endLevel0I25( ) ;
      }
      closeExtendedTableCursors0I25( ) ;
   }

   public void update0I25( )
   {
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0I25( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0I25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0I25( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0I25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000I9 */
                  pr_default.execute(7, new Object[] {A107DiagnosticoCodigo, A108DiagnosticoDescripcion, A130DiagnosticoTipoSexo, A131DiagnosticoEstado, Integer.valueOf(A23DiagnosticoId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Diagnostico");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Diagnostico"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0I25( ) ;
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
         endLevel0I25( ) ;
      }
      closeExtendedTableCursors0I25( ) ;
   }

   public void deferredUpdate0I25( )
   {
   }

   public void delete( )
   {
      beforeValidate0I25( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0I25( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0I25( ) ;
         afterConfirm0I25( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0I25( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000I10 */
               pr_default.execute(8, new Object[] {Integer.valueOf(A23DiagnosticoId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Diagnostico");
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
      sMode25 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0I25( ) ;
      Gx_mode = sMode25 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0I25( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "Diagnostico" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
         A132DiagnosticoLongDesc = A107DiagnosticoCodigo + " - " + A108DiagnosticoDescripcion ;
         httpContext.ajax_rsp_assign_attri("", false, "A132DiagnosticoLongDesc", A132DiagnosticoLongDesc);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000I11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A23DiagnosticoId)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Diagnostico"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
      }
   }

   public void endLevel0I25( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0I25( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "diagnostico");
         if ( AnyError == 0 )
         {
            confirmValues0I0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "diagnostico");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0I25( )
   {
      /* Scan By routine */
      /* Using cursor T000I12 */
      pr_default.execute(10);
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A23DiagnosticoId = T000I12_A23DiagnosticoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0I25( )
   {
      /* Scan next routine */
      pr_default.readNext(10);
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A23DiagnosticoId = T000I12_A23DiagnosticoId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
      }
   }

   public void scanEnd0I25( )
   {
      pr_default.close(10);
   }

   public void afterConfirm0I25( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0I25( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0I25( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0I25( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0I25( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0I25( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0I25( )
   {
      edtDiagnosticoId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDiagnosticoId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDiagnosticoId_Enabled), 5, 0), true);
      edtDiagnosticoCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDiagnosticoCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDiagnosticoCodigo_Enabled), 5, 0), true);
      edtDiagnosticoDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDiagnosticoDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDiagnosticoDescripcion_Enabled), 5, 0), true);
      cmbDiagnosticoTipoSexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDiagnosticoTipoSexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDiagnosticoTipoSexo.getEnabled(), 5, 0), true);
      cmbDiagnosticoEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDiagnosticoEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDiagnosticoEstado.getEnabled(), 5, 0), true);
      edtDiagnosticoLongDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDiagnosticoLongDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDiagnosticoLongDesc_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0I25( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0I0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110323781", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.diagnostico", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV12DiagnosticoId,8,0))}, new String[] {"Gx_mode","DiagnosticoId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Diagnostico");
      forbiddenHiddens.add("DiagnosticoId", localUtil.format( DecimalUtil.doubleToDec(A23DiagnosticoId), "ZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("diagnostico:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z23DiagnosticoId", GXutil.ltrim( localUtil.ntoc( Z23DiagnosticoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z107DiagnosticoCodigo", Z107DiagnosticoCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z108DiagnosticoDescripcion", Z108DiagnosticoDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z130DiagnosticoTipoSexo", GXutil.rtrim( Z130DiagnosticoTipoSexo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z131DiagnosticoEstado", GXutil.rtrim( Z131DiagnosticoEstado));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDIAGNOSTICOID", GXutil.ltrim( localUtil.ntoc( AV12DiagnosticoId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDIAGNOSTICOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12DiagnosticoId), "ZZZZZZZ9")));
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
      return formatLink("com.projectthani.diagnostico", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV12DiagnosticoId,8,0))}, new String[] {"Gx_mode","DiagnosticoId"})  ;
   }

   public String getPgmname( )
   {
      return "Diagnostico" ;
   }

   public String getPgmdesc( )
   {
      return "Diagnostico" ;
   }

   public void initializeNonKey0I25( )
   {
      A132DiagnosticoLongDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A132DiagnosticoLongDesc", A132DiagnosticoLongDesc);
      A107DiagnosticoCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A107DiagnosticoCodigo", A107DiagnosticoCodigo);
      A108DiagnosticoDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A108DiagnosticoDescripcion", A108DiagnosticoDescripcion);
      A130DiagnosticoTipoSexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A130DiagnosticoTipoSexo", A130DiagnosticoTipoSexo);
      A131DiagnosticoEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A131DiagnosticoEstado", A131DiagnosticoEstado);
      Z107DiagnosticoCodigo = "" ;
      Z108DiagnosticoDescripcion = "" ;
      Z130DiagnosticoTipoSexo = "" ;
      Z131DiagnosticoEstado = "" ;
   }

   public void initAll0I25( )
   {
      A23DiagnosticoId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A23DiagnosticoId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A23DiagnosticoId), 8, 0));
      initializeNonKey0I25( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323791", true, true);
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
      httpContext.AddJavascriptSource("diagnostico.js", "?20225110323792", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtDiagnosticoId_Internalname = "DIAGNOSTICOID" ;
      edtDiagnosticoCodigo_Internalname = "DIAGNOSTICOCODIGO" ;
      edtDiagnosticoDescripcion_Internalname = "DIAGNOSTICODESCRIPCION" ;
      cmbDiagnosticoTipoSexo.setInternalname( "DIAGNOSTICOTIPOSEXO" );
      cmbDiagnosticoEstado.setInternalname( "DIAGNOSTICOESTADO" );
      edtDiagnosticoLongDesc_Internalname = "DIAGNOSTICOLONGDESC" ;
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
      Form.setCaption( "Diagnostico" );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtDiagnosticoLongDesc_Enabled = 0 ;
      cmbDiagnosticoEstado.setJsonclick( "" );
      cmbDiagnosticoEstado.setEnabled( 1 );
      cmbDiagnosticoTipoSexo.setJsonclick( "" );
      cmbDiagnosticoTipoSexo.setEnabled( 1 );
      edtDiagnosticoDescripcion_Enabled = 1 ;
      edtDiagnosticoCodigo_Jsonclick = "" ;
      edtDiagnosticoCodigo_Enabled = 1 ;
      edtDiagnosticoId_Jsonclick = "" ;
      edtDiagnosticoId_Enabled = 0 ;
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
      cmbDiagnosticoTipoSexo.setName( "DIAGNOSTICOTIPOSEXO" );
      cmbDiagnosticoTipoSexo.setWebtags( "" );
      cmbDiagnosticoTipoSexo.addItem("M", "Masculino", (short)(0));
      cmbDiagnosticoTipoSexo.addItem("F", "Femenino", (short)(0));
      cmbDiagnosticoTipoSexo.addItem("A", "Ambos", (short)(0));
      if ( cmbDiagnosticoTipoSexo.getItemCount() > 0 )
      {
         A130DiagnosticoTipoSexo = cmbDiagnosticoTipoSexo.getValidValue(A130DiagnosticoTipoSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A130DiagnosticoTipoSexo", A130DiagnosticoTipoSexo);
      }
      cmbDiagnosticoEstado.setName( "DIAGNOSTICOESTADO" );
      cmbDiagnosticoEstado.setWebtags( "" );
      cmbDiagnosticoEstado.addItem("A", "Activo", (short)(0));
      cmbDiagnosticoEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbDiagnosticoEstado.getItemCount() > 0 )
      {
         A131DiagnosticoEstado = cmbDiagnosticoEstado.getValidValue(A131DiagnosticoEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A131DiagnosticoEstado", A131DiagnosticoEstado);
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV12DiagnosticoId',fld:'vDIAGNOSTICOID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV12DiagnosticoId',fld:'vDIAGNOSTICOID',pic:'ZZZZZZZ9',hsh:true},{av:'A23DiagnosticoId',fld:'DIAGNOSTICOID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120I2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_DIAGNOSTICOID","{handler:'valid_Diagnosticoid',iparms:[]");
      setEventMetadata("VALID_DIAGNOSTICOID",",oparms:[]}");
      setEventMetadata("VALID_DIAGNOSTICOCODIGO","{handler:'valid_Diagnosticocodigo',iparms:[]");
      setEventMetadata("VALID_DIAGNOSTICOCODIGO",",oparms:[]}");
      setEventMetadata("VALID_DIAGNOSTICODESCRIPCION","{handler:'valid_Diagnosticodescripcion',iparms:[]");
      setEventMetadata("VALID_DIAGNOSTICODESCRIPCION",",oparms:[]}");
      setEventMetadata("VALID_DIAGNOSTICOTIPOSEXO","{handler:'valid_Diagnosticotiposexo',iparms:[]");
      setEventMetadata("VALID_DIAGNOSTICOTIPOSEXO",",oparms:[]}");
      setEventMetadata("VALID_DIAGNOSTICOESTADO","{handler:'valid_Diagnosticoestado',iparms:[]");
      setEventMetadata("VALID_DIAGNOSTICOESTADO",",oparms:[]}");
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
      Z107DiagnosticoCodigo = "" ;
      Z108DiagnosticoDescripcion = "" ;
      Z130DiagnosticoTipoSexo = "" ;
      Z131DiagnosticoEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A130DiagnosticoTipoSexo = "" ;
      A131DiagnosticoEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A107DiagnosticoCodigo = "" ;
      A108DiagnosticoDescripcion = "" ;
      A132DiagnosticoLongDesc = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV13Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode25 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      T000I4_A23DiagnosticoId = new int[1] ;
      T000I4_A107DiagnosticoCodigo = new String[] {""} ;
      T000I4_A108DiagnosticoDescripcion = new String[] {""} ;
      T000I4_A130DiagnosticoTipoSexo = new String[] {""} ;
      T000I4_A131DiagnosticoEstado = new String[] {""} ;
      T000I5_A23DiagnosticoId = new int[1] ;
      T000I3_A23DiagnosticoId = new int[1] ;
      T000I3_A107DiagnosticoCodigo = new String[] {""} ;
      T000I3_A108DiagnosticoDescripcion = new String[] {""} ;
      T000I3_A130DiagnosticoTipoSexo = new String[] {""} ;
      T000I3_A131DiagnosticoEstado = new String[] {""} ;
      T000I6_A23DiagnosticoId = new int[1] ;
      T000I7_A23DiagnosticoId = new int[1] ;
      T000I2_A23DiagnosticoId = new int[1] ;
      T000I2_A107DiagnosticoCodigo = new String[] {""} ;
      T000I2_A108DiagnosticoDescripcion = new String[] {""} ;
      T000I2_A130DiagnosticoTipoSexo = new String[] {""} ;
      T000I2_A131DiagnosticoEstado = new String[] {""} ;
      T000I8_A23DiagnosticoId = new int[1] ;
      T000I11_A22CitaDiagnosticoId = new int[1] ;
      T000I12_A23DiagnosticoId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.diagnostico__default(),
         new Object[] {
             new Object[] {
            T000I2_A23DiagnosticoId, T000I2_A107DiagnosticoCodigo, T000I2_A108DiagnosticoDescripcion, T000I2_A130DiagnosticoTipoSexo, T000I2_A131DiagnosticoEstado
            }
            , new Object[] {
            T000I3_A23DiagnosticoId, T000I3_A107DiagnosticoCodigo, T000I3_A108DiagnosticoDescripcion, T000I3_A130DiagnosticoTipoSexo, T000I3_A131DiagnosticoEstado
            }
            , new Object[] {
            T000I4_A23DiagnosticoId, T000I4_A107DiagnosticoCodigo, T000I4_A108DiagnosticoDescripcion, T000I4_A130DiagnosticoTipoSexo, T000I4_A131DiagnosticoEstado
            }
            , new Object[] {
            T000I5_A23DiagnosticoId
            }
            , new Object[] {
            T000I6_A23DiagnosticoId
            }
            , new Object[] {
            T000I7_A23DiagnosticoId
            }
            , new Object[] {
            T000I8_A23DiagnosticoId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000I11_A22CitaDiagnosticoId
            }
            , new Object[] {
            T000I12_A23DiagnosticoId
            }
         }
      );
      AV13Pgmname = "Diagnostico" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound25 ;
   private short nIsDirty_25 ;
   private int wcpOAV12DiagnosticoId ;
   private int Z23DiagnosticoId ;
   private int AV12DiagnosticoId ;
   private int trnEnded ;
   private int A23DiagnosticoId ;
   private int edtDiagnosticoId_Enabled ;
   private int edtDiagnosticoCodigo_Enabled ;
   private int edtDiagnosticoDescripcion_Enabled ;
   private int edtDiagnosticoLongDesc_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z130DiagnosticoTipoSexo ;
   private String Z131DiagnosticoEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtDiagnosticoCodigo_Internalname ;
   private String A130DiagnosticoTipoSexo ;
   private String A131DiagnosticoEstado ;
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
   private String edtDiagnosticoId_Internalname ;
   private String edtDiagnosticoId_Jsonclick ;
   private String TempTags ;
   private String edtDiagnosticoCodigo_Jsonclick ;
   private String edtDiagnosticoDescripcion_Internalname ;
   private String edtDiagnosticoLongDesc_Internalname ;
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
   private String sMode25 ;
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
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z107DiagnosticoCodigo ;
   private String Z108DiagnosticoDescripcion ;
   private String A107DiagnosticoCodigo ;
   private String A108DiagnosticoDescripcion ;
   private String A132DiagnosticoLongDesc ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbDiagnosticoTipoSexo ;
   private HTMLChoice cmbDiagnosticoEstado ;
   private IDataStoreProvider pr_default ;
   private int[] T000I4_A23DiagnosticoId ;
   private String[] T000I4_A107DiagnosticoCodigo ;
   private String[] T000I4_A108DiagnosticoDescripcion ;
   private String[] T000I4_A130DiagnosticoTipoSexo ;
   private String[] T000I4_A131DiagnosticoEstado ;
   private int[] T000I5_A23DiagnosticoId ;
   private int[] T000I3_A23DiagnosticoId ;
   private String[] T000I3_A107DiagnosticoCodigo ;
   private String[] T000I3_A108DiagnosticoDescripcion ;
   private String[] T000I3_A130DiagnosticoTipoSexo ;
   private String[] T000I3_A131DiagnosticoEstado ;
   private int[] T000I6_A23DiagnosticoId ;
   private int[] T000I7_A23DiagnosticoId ;
   private int[] T000I2_A23DiagnosticoId ;
   private String[] T000I2_A107DiagnosticoCodigo ;
   private String[] T000I2_A108DiagnosticoDescripcion ;
   private String[] T000I2_A130DiagnosticoTipoSexo ;
   private String[] T000I2_A131DiagnosticoEstado ;
   private int[] T000I8_A23DiagnosticoId ;
   private int[] T000I11_A22CitaDiagnosticoId ;
   private int[] T000I12_A23DiagnosticoId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
}

final  class diagnostico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000I2", "SELECT [DiagnosticoId], [DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado] FROM [Diagnostico] WITH (UPDLOCK) WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I3", "SELECT [DiagnosticoId], [DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado] FROM [Diagnostico] WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I4", "SELECT TM1.[DiagnosticoId], TM1.[DiagnosticoCodigo], TM1.[DiagnosticoDescripcion], TM1.[DiagnosticoTipoSexo], TM1.[DiagnosticoEstado] FROM [Diagnostico] TM1 WHERE TM1.[DiagnosticoId] = ? ORDER BY TM1.[DiagnosticoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I5", "SELECT [DiagnosticoId] FROM [Diagnostico] WHERE [DiagnosticoId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000I6", "SELECT TOP 1 [DiagnosticoId] FROM [Diagnostico] WHERE ( [DiagnosticoId] > ?) ORDER BY [DiagnosticoId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000I7", "SELECT TOP 1 [DiagnosticoId] FROM [Diagnostico] WHERE ( [DiagnosticoId] < ?) ORDER BY [DiagnosticoId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000I8", "INSERT INTO [Diagnostico]([DiagnosticoCodigo], [DiagnosticoDescripcion], [DiagnosticoTipoSexo], [DiagnosticoEstado]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000I9", "UPDATE [Diagnostico] SET [DiagnosticoCodigo]=?, [DiagnosticoDescripcion]=?, [DiagnosticoTipoSexo]=?, [DiagnosticoEstado]=?  WHERE [DiagnosticoId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000I10", "DELETE FROM [Diagnostico]  WHERE [DiagnosticoId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000I11", "SELECT TOP 1 [CitaDiagnosticoId] FROM [CitaDiagnostico] WHERE [DiagnosticoId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000I12", "SELECT [DiagnosticoId] FROM [Diagnostico] ORDER BY [DiagnosticoId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 1000, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

