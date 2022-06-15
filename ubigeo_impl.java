package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ubigeo_impl extends GXDataArea
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
            AV12UbigeoCode = httpContext.GetPar( "UbigeoCode") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12UbigeoCode", AV12UbigeoCode);
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUBIGEOCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12UbigeoCode, ""))));
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
         Form.getMeta().addItem("description", "Ubigeo", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public ubigeo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ubigeo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ubigeo_impl.class ));
   }

   public ubigeo_impl( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbUbigeoEstado = new HTMLChoice();
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
      if ( cmbUbigeoEstado.getItemCount() > 0 )
      {
         A294UbigeoEstado = cmbUbigeoEstado.getValidValue(A294UbigeoEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A294UbigeoEstado", A294UbigeoEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbUbigeoEstado.setValue( GXutil.rtrim( A294UbigeoEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbUbigeoEstado.getInternalname(), "Values", cmbUbigeoEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoCode_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoCode_Internalname, "Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoCode_Internalname, GXutil.rtrim( A44UbigeoCode), GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoCode_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoDepartamento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoDepartamento_Internalname, "Departamento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoDepartamento_Internalname, A186UbigeoDepartamento, GXutil.rtrim( localUtil.format( A186UbigeoDepartamento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoDepartamento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoDepartamento_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoDepartamentoCode_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoDepartamentoCode_Internalname, "Departamento Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoDepartamentoCode_Internalname, A295UbigeoDepartamentoCode, GXutil.rtrim( localUtil.format( A295UbigeoDepartamentoCode, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoDepartamentoCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoDepartamentoCode_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoProvincia_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoProvincia_Internalname, "Provincia", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoProvincia_Internalname, A187UbigeoProvincia, GXutil.rtrim( localUtil.format( A187UbigeoProvincia, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoProvincia_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoProvincia_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoProvinciaCode_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoProvinciaCode_Internalname, "Provincia Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoProvinciaCode_Internalname, A296UbigeoProvinciaCode, GXutil.rtrim( localUtil.format( A296UbigeoProvinciaCode, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoProvinciaCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoProvinciaCode_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoDistrito_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoDistrito_Internalname, "Distrito", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoDistrito_Internalname, A188UbigeoDistrito, GXutil.rtrim( localUtil.format( A188UbigeoDistrito, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoDistrito_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoDistrito_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoDistritoCode_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoDistritoCode_Internalname, "Distrito Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoDistritoCode_Internalname, A297UbigeoDistritoCode, GXutil.rtrim( localUtil.format( A297UbigeoDistritoCode, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoDistritoCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoDistritoCode_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoNombre_Internalname, "Ubigeo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoNombre_Internalname, A185UbigeoNombre, GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbUbigeoEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbUbigeoEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbUbigeoEstado, cmbUbigeoEstado.getInternalname(), GXutil.rtrim( A294UbigeoEstado), 1, cmbUbigeoEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbUbigeoEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", true, (byte)(1), "HLP_Ubigeo.htm");
      cmbUbigeoEstado.setValue( GXutil.rtrim( A294UbigeoEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbUbigeoEstado.getInternalname(), "Values", cmbUbigeoEstado.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Ubigeo.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 71,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Ubigeo.htm");
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
      e110Z2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z44UbigeoCode = httpContext.cgiGet( "Z44UbigeoCode") ;
            Z186UbigeoDepartamento = httpContext.cgiGet( "Z186UbigeoDepartamento") ;
            Z187UbigeoProvincia = httpContext.cgiGet( "Z187UbigeoProvincia") ;
            Z188UbigeoDistrito = httpContext.cgiGet( "Z188UbigeoDistrito") ;
            Z294UbigeoEstado = httpContext.cgiGet( "Z294UbigeoEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV12UbigeoCode = httpContext.cgiGet( "vUBIGEOCODE") ;
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
            A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
            n44UbigeoCode = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            A186UbigeoDepartamento = httpContext.cgiGet( edtUbigeoDepartamento_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
            A295UbigeoDepartamentoCode = httpContext.cgiGet( edtUbigeoDepartamentoCode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
            A187UbigeoProvincia = httpContext.cgiGet( edtUbigeoProvincia_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
            A296UbigeoProvinciaCode = httpContext.cgiGet( edtUbigeoProvinciaCode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
            A188UbigeoDistrito = httpContext.cgiGet( edtUbigeoDistrito_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
            A297UbigeoDistritoCode = httpContext.cgiGet( edtUbigeoDistritoCode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
            A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
            cmbUbigeoEstado.setValue( httpContext.cgiGet( cmbUbigeoEstado.getInternalname()) );
            A294UbigeoEstado = httpContext.cgiGet( cmbUbigeoEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A294UbigeoEstado", A294UbigeoEstado);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Ubigeo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A44UbigeoCode, Z44UbigeoCode) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("ubigeo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A44UbigeoCode = httpContext.GetPar( "UbigeoCode") ;
               n44UbigeoCode = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
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
                  sMode45 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode45 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound45 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0Z0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "UBIGEOCODE");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtUbigeoCode_Internalname ;
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
                        e110Z2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120Z2 ();
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
         e120Z2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0Z45( ) ;
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
         disableAttributes0Z45( ) ;
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

   public void confirm_0Z0( )
   {
      beforeValidate0Z45( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0Z45( ) ;
         }
         else
         {
            checkExtendedTable0Z45( ) ;
            closeExtendedTableCursors0Z45( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0Z0( )
   {
   }

   public void e110Z2( )
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo_Insert", GXv_boolean3) ;
         ubigeo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo_Update", GXv_boolean3) ;
         ubigeo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV8IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV8IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWUbigeo_Delete", GXv_boolean3) ;
         ubigeo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
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

   public void e120Z2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.ubigeoww", new String[] {}, new String[] {}) );
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

   public void zm0Z45( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z186UbigeoDepartamento = T000Z3_A186UbigeoDepartamento[0] ;
            Z187UbigeoProvincia = T000Z3_A187UbigeoProvincia[0] ;
            Z188UbigeoDistrito = T000Z3_A188UbigeoDistrito[0] ;
            Z294UbigeoEstado = T000Z3_A294UbigeoEstado[0] ;
         }
         else
         {
            Z186UbigeoDepartamento = A186UbigeoDepartamento ;
            Z187UbigeoProvincia = A187UbigeoProvincia ;
            Z188UbigeoDistrito = A188UbigeoDistrito ;
            Z294UbigeoEstado = A294UbigeoEstado ;
         }
      }
      if ( GX_JID == -9 )
      {
         Z44UbigeoCode = A44UbigeoCode ;
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
         Z294UbigeoEstado = A294UbigeoEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (GXutil.strcmp("", AV12UbigeoCode)==0) )
      {
         A44UbigeoCode = AV12UbigeoCode ;
         n44UbigeoCode = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      }
      if ( ! (GXutil.strcmp("", AV12UbigeoCode)==0) )
      {
         edtUbigeoCode_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      }
      else
      {
         edtUbigeoCode_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV12UbigeoCode)==0) )
      {
         edtUbigeoCode_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
         AV13Pgmname = "Ubigeo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      }
   }

   public void load0Z45( )
   {
      /* Using cursor T000Z4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound45 = (short)(1) ;
         A186UbigeoDepartamento = T000Z4_A186UbigeoDepartamento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
         A187UbigeoProvincia = T000Z4_A187UbigeoProvincia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
         A188UbigeoDistrito = T000Z4_A188UbigeoDistrito[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
         A294UbigeoEstado = T000Z4_A294UbigeoEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A294UbigeoEstado", A294UbigeoEstado);
         zm0Z45( -9) ;
      }
      pr_default.close(2);
      onLoadActions0Z45( ) ;
   }

   public void onLoadActions0Z45( )
   {
      AV13Pgmname = "Ubigeo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
      httpContext.ajax_rsp_assign_attri("", false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
      A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
      httpContext.ajax_rsp_assign_attri("", false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
      A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
      httpContext.ajax_rsp_assign_attri("", false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
   }

   public void checkExtendedTable0Z45( )
   {
      nIsDirty_45 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV13Pgmname = "Ubigeo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
      nIsDirty_45 = (short)(1) ;
      A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
      httpContext.ajax_rsp_assign_attri("", false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
      nIsDirty_45 = (short)(1) ;
      A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
      httpContext.ajax_rsp_assign_attri("", false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
      nIsDirty_45 = (short)(1) ;
      A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
      httpContext.ajax_rsp_assign_attri("", false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
      nIsDirty_45 = (short)(1) ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      if ( ! ( ( GXutil.strcmp(A294UbigeoEstado, "A") == 0 ) || ( GXutil.strcmp(A294UbigeoEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Ubigeo Estado fuera de rango", "OutOfRange", 1, "UBIGEOESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbUbigeoEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0Z45( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0Z45( )
   {
      /* Using cursor T000Z5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound45 = (short)(1) ;
      }
      else
      {
         RcdFound45 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000Z3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0Z45( 9) ;
         RcdFound45 = (short)(1) ;
         A44UbigeoCode = T000Z3_A44UbigeoCode[0] ;
         n44UbigeoCode = T000Z3_n44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         A186UbigeoDepartamento = T000Z3_A186UbigeoDepartamento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
         A187UbigeoProvincia = T000Z3_A187UbigeoProvincia[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
         A188UbigeoDistrito = T000Z3_A188UbigeoDistrito[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
         A294UbigeoEstado = T000Z3_A294UbigeoEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A294UbigeoEstado", A294UbigeoEstado);
         Z44UbigeoCode = A44UbigeoCode ;
         sMode45 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0Z45( ) ;
         if ( AnyError == 1 )
         {
            RcdFound45 = (short)(0) ;
            initializeNonKey0Z45( ) ;
         }
         Gx_mode = sMode45 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound45 = (short)(0) ;
         initializeNonKey0Z45( ) ;
         sMode45 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode45 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0Z45( ) ;
      if ( RcdFound45 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound45 = (short)(0) ;
      /* Using cursor T000Z6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(4) != 101) )
      {
         while ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T000Z6_A44UbigeoCode[0], A44UbigeoCode) < 0 ) ) )
         {
            pr_default.readNext(4);
         }
         if ( (pr_default.getStatus(4) != 101) && ( ( GXutil.strcmp(T000Z6_A44UbigeoCode[0], A44UbigeoCode) > 0 ) ) )
         {
            A44UbigeoCode = T000Z6_A44UbigeoCode[0] ;
            n44UbigeoCode = T000Z6_n44UbigeoCode[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            RcdFound45 = (short)(1) ;
         }
      }
      pr_default.close(4);
   }

   public void move_previous( )
   {
      RcdFound45 = (short)(0) ;
      /* Using cursor T000Z7 */
      pr_default.execute(5, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(5) != 101) )
      {
         while ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T000Z7_A44UbigeoCode[0], A44UbigeoCode) > 0 ) ) )
         {
            pr_default.readNext(5);
         }
         if ( (pr_default.getStatus(5) != 101) && ( ( GXutil.strcmp(T000Z7_A44UbigeoCode[0], A44UbigeoCode) < 0 ) ) )
         {
            A44UbigeoCode = T000Z7_A44UbigeoCode[0] ;
            n44UbigeoCode = T000Z7_n44UbigeoCode[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            RcdFound45 = (short)(1) ;
         }
      }
      pr_default.close(5);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0Z45( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0Z45( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound45 == 1 )
         {
            if ( GXutil.strcmp(A44UbigeoCode, Z44UbigeoCode) != 0 )
            {
               A44UbigeoCode = Z44UbigeoCode ;
               n44UbigeoCode = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "UBIGEOCODE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtUbigeoCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtUbigeoCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0Z45( ) ;
               GX_FocusControl = edtUbigeoCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A44UbigeoCode, Z44UbigeoCode) != 0 )
            {
               /* Insert record */
               GX_FocusControl = edtUbigeoCode_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0Z45( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "UBIGEOCODE");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtUbigeoCode_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtUbigeoCode_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0Z45( ) ;
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
      if ( GXutil.strcmp(A44UbigeoCode, Z44UbigeoCode) != 0 )
      {
         A44UbigeoCode = Z44UbigeoCode ;
         n44UbigeoCode = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0Z45( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000Z2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Ubigeo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z186UbigeoDepartamento, T000Z2_A186UbigeoDepartamento[0]) != 0 ) || ( GXutil.strcmp(Z187UbigeoProvincia, T000Z2_A187UbigeoProvincia[0]) != 0 ) || ( GXutil.strcmp(Z188UbigeoDistrito, T000Z2_A188UbigeoDistrito[0]) != 0 ) || ( GXutil.strcmp(Z294UbigeoEstado, T000Z2_A294UbigeoEstado[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z186UbigeoDepartamento, T000Z2_A186UbigeoDepartamento[0]) != 0 )
            {
               GXutil.writeLogln("ubigeo:[seudo value changed for attri]"+"UbigeoDepartamento");
               GXutil.writeLogRaw("Old: ",Z186UbigeoDepartamento);
               GXutil.writeLogRaw("Current: ",T000Z2_A186UbigeoDepartamento[0]);
            }
            if ( GXutil.strcmp(Z187UbigeoProvincia, T000Z2_A187UbigeoProvincia[0]) != 0 )
            {
               GXutil.writeLogln("ubigeo:[seudo value changed for attri]"+"UbigeoProvincia");
               GXutil.writeLogRaw("Old: ",Z187UbigeoProvincia);
               GXutil.writeLogRaw("Current: ",T000Z2_A187UbigeoProvincia[0]);
            }
            if ( GXutil.strcmp(Z188UbigeoDistrito, T000Z2_A188UbigeoDistrito[0]) != 0 )
            {
               GXutil.writeLogln("ubigeo:[seudo value changed for attri]"+"UbigeoDistrito");
               GXutil.writeLogRaw("Old: ",Z188UbigeoDistrito);
               GXutil.writeLogRaw("Current: ",T000Z2_A188UbigeoDistrito[0]);
            }
            if ( GXutil.strcmp(Z294UbigeoEstado, T000Z2_A294UbigeoEstado[0]) != 0 )
            {
               GXutil.writeLogln("ubigeo:[seudo value changed for attri]"+"UbigeoEstado");
               GXutil.writeLogRaw("Old: ",Z294UbigeoEstado);
               GXutil.writeLogRaw("Current: ",T000Z2_A294UbigeoEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Ubigeo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0Z45( )
   {
      beforeValidate0Z45( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Z45( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0Z45( 0) ;
         checkOptimisticConcurrency0Z45( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Z45( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0Z45( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Z8 */
                  pr_default.execute(6, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode, A186UbigeoDepartamento, A187UbigeoProvincia, A188UbigeoDistrito, A294UbigeoEstado});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Ubigeo");
                  if ( (pr_default.getStatus(6) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0Z0( ) ;
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
            load0Z45( ) ;
         }
         endLevel0Z45( ) ;
      }
      closeExtendedTableCursors0Z45( ) ;
   }

   public void update0Z45( )
   {
      beforeValidate0Z45( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0Z45( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Z45( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0Z45( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0Z45( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000Z9 */
                  pr_default.execute(7, new Object[] {A186UbigeoDepartamento, A187UbigeoProvincia, A188UbigeoDistrito, A294UbigeoEstado, Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Ubigeo");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Ubigeo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0Z45( ) ;
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
         endLevel0Z45( ) ;
      }
      closeExtendedTableCursors0Z45( ) ;
   }

   public void deferredUpdate0Z45( )
   {
   }

   public void delete( )
   {
      beforeValidate0Z45( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0Z45( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0Z45( ) ;
         afterConfirm0Z45( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0Z45( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000Z10 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Ubigeo");
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
      sMode45 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0Z45( ) ;
      Gx_mode = sMode45 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0Z45( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "Ubigeo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Pgmname", AV13Pgmname);
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000Z11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sede"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor T000Z12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
         /* Using cursor T000Z13 */
         pr_default.execute(11, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
      }
   }

   public void endLevel0Z45( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0Z45( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "ubigeo");
         if ( AnyError == 0 )
         {
            confirmValues0Z0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "ubigeo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0Z45( )
   {
      /* Scan By routine */
      /* Using cursor T000Z14 */
      pr_default.execute(12);
      RcdFound45 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound45 = (short)(1) ;
         A44UbigeoCode = T000Z14_A44UbigeoCode[0] ;
         n44UbigeoCode = T000Z14_n44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0Z45( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound45 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound45 = (short)(1) ;
         A44UbigeoCode = T000Z14_A44UbigeoCode[0] ;
         n44UbigeoCode = T000Z14_n44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      }
   }

   public void scanEnd0Z45( )
   {
      pr_default.close(12);
   }

   public void afterConfirm0Z45( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0Z45( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0Z45( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0Z45( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0Z45( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0Z45( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0Z45( )
   {
      edtUbigeoCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      edtUbigeoDepartamento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDepartamento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDepartamento_Enabled), 5, 0), true);
      edtUbigeoDepartamentoCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDepartamentoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDepartamentoCode_Enabled), 5, 0), true);
      edtUbigeoProvincia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoProvincia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoProvincia_Enabled), 5, 0), true);
      edtUbigeoProvinciaCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoProvinciaCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoProvinciaCode_Enabled), 5, 0), true);
      edtUbigeoDistrito_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDistrito_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDistrito_Enabled), 5, 0), true);
      edtUbigeoDistritoCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoDistritoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoDistritoCode_Enabled), 5, 0), true);
      edtUbigeoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Enabled), 5, 0), true);
      cmbUbigeoEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbUbigeoEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbUbigeoEstado.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0Z45( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0Z0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033266", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.ubigeo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV12UbigeoCode))}, new String[] {"Gx_mode","UbigeoCode"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Ubigeo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("ubigeo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z44UbigeoCode", GXutil.rtrim( Z44UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z186UbigeoDepartamento", Z186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z187UbigeoProvincia", Z187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z188UbigeoDistrito", Z188UbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z294UbigeoEstado", GXutil.rtrim( Z294UbigeoEstado));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vUBIGEOCODE", GXutil.rtrim( AV12UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vUBIGEOCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12UbigeoCode, ""))));
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
      return formatLink("com.projectthani.ubigeo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.rtrim(AV12UbigeoCode))}, new String[] {"Gx_mode","UbigeoCode"})  ;
   }

   public String getPgmname( )
   {
      return "Ubigeo" ;
   }

   public String getPgmdesc( )
   {
      return "Ubigeo" ;
   }

   public void initializeNonKey0Z45( )
   {
      A185UbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      A295UbigeoDepartamentoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
      A296UbigeoProvinciaCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
      A297UbigeoDistritoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
      A186UbigeoDepartamento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      A187UbigeoProvincia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      A188UbigeoDistrito = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      A294UbigeoEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A294UbigeoEstado", A294UbigeoEstado);
      Z186UbigeoDepartamento = "" ;
      Z187UbigeoProvincia = "" ;
      Z188UbigeoDistrito = "" ;
      Z294UbigeoEstado = "" ;
   }

   public void initAll0Z45( )
   {
      A44UbigeoCode = "" ;
      n44UbigeoCode = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      initializeNonKey0Z45( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033277", true, true);
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
      httpContext.AddJavascriptSource("ubigeo.js", "?2022511033278", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      edtUbigeoDepartamento_Internalname = "UBIGEODEPARTAMENTO" ;
      edtUbigeoDepartamentoCode_Internalname = "UBIGEODEPARTAMENTOCODE" ;
      edtUbigeoProvincia_Internalname = "UBIGEOPROVINCIA" ;
      edtUbigeoProvinciaCode_Internalname = "UBIGEOPROVINCIACODE" ;
      edtUbigeoDistrito_Internalname = "UBIGEODISTRITO" ;
      edtUbigeoDistritoCode_Internalname = "UBIGEODISTRITOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      cmbUbigeoEstado.setInternalname( "UBIGEOESTADO" );
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
      Form.setCaption( "Ubigeo" );
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbUbigeoEstado.setJsonclick( "" );
      cmbUbigeoEstado.setEnabled( 1 );
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoNombre_Enabled = 0 ;
      edtUbigeoDistritoCode_Jsonclick = "" ;
      edtUbigeoDistritoCode_Enabled = 0 ;
      edtUbigeoDistrito_Jsonclick = "" ;
      edtUbigeoDistrito_Enabled = 1 ;
      edtUbigeoProvinciaCode_Jsonclick = "" ;
      edtUbigeoProvinciaCode_Enabled = 0 ;
      edtUbigeoProvincia_Jsonclick = "" ;
      edtUbigeoProvincia_Enabled = 1 ;
      edtUbigeoDepartamentoCode_Jsonclick = "" ;
      edtUbigeoDepartamentoCode_Enabled = 0 ;
      edtUbigeoDepartamento_Jsonclick = "" ;
      edtUbigeoDepartamento_Enabled = 1 ;
      edtUbigeoCode_Jsonclick = "" ;
      edtUbigeoCode_Enabled = 1 ;
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
      cmbUbigeoEstado.setName( "UBIGEOESTADO" );
      cmbUbigeoEstado.setWebtags( "" );
      cmbUbigeoEstado.addItem("A", "Activo", (short)(0));
      cmbUbigeoEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbUbigeoEstado.getItemCount() > 0 )
      {
         A294UbigeoEstado = cmbUbigeoEstado.getValidValue(A294UbigeoEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A294UbigeoEstado", A294UbigeoEstado);
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV12UbigeoCode',fld:'vUBIGEOCODE',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV12UbigeoCode',fld:'vUBIGEOCODE',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120Z2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[]}");
      setEventMetadata("VALID_UBIGEODEPARTAMENTO","{handler:'valid_Ubigeodepartamento',iparms:[]");
      setEventMetadata("VALID_UBIGEODEPARTAMENTO",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOPROVINCIA","{handler:'valid_Ubigeoprovincia',iparms:[]");
      setEventMetadata("VALID_UBIGEOPROVINCIA",",oparms:[]}");
      setEventMetadata("VALID_UBIGEODISTRITO","{handler:'valid_Ubigeodistrito',iparms:[]");
      setEventMetadata("VALID_UBIGEODISTRITO",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOESTADO","{handler:'valid_Ubigeoestado',iparms:[]");
      setEventMetadata("VALID_UBIGEOESTADO",",oparms:[]}");
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
      wcpOAV12UbigeoCode = "" ;
      Z44UbigeoCode = "" ;
      Z186UbigeoDepartamento = "" ;
      Z187UbigeoProvincia = "" ;
      Z188UbigeoDistrito = "" ;
      Z294UbigeoEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV12UbigeoCode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A294UbigeoEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A44UbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A187UbigeoProvincia = "" ;
      A296UbigeoProvinciaCode = "" ;
      A188UbigeoDistrito = "" ;
      A297UbigeoDistritoCode = "" ;
      A185UbigeoNombre = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV13Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode45 = "" ;
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
      T000Z4_A44UbigeoCode = new String[] {""} ;
      T000Z4_n44UbigeoCode = new boolean[] {false} ;
      T000Z4_A186UbigeoDepartamento = new String[] {""} ;
      T000Z4_A187UbigeoProvincia = new String[] {""} ;
      T000Z4_A188UbigeoDistrito = new String[] {""} ;
      T000Z4_A294UbigeoEstado = new String[] {""} ;
      T000Z5_A44UbigeoCode = new String[] {""} ;
      T000Z5_n44UbigeoCode = new boolean[] {false} ;
      T000Z3_A44UbigeoCode = new String[] {""} ;
      T000Z3_n44UbigeoCode = new boolean[] {false} ;
      T000Z3_A186UbigeoDepartamento = new String[] {""} ;
      T000Z3_A187UbigeoProvincia = new String[] {""} ;
      T000Z3_A188UbigeoDistrito = new String[] {""} ;
      T000Z3_A294UbigeoEstado = new String[] {""} ;
      T000Z6_A44UbigeoCode = new String[] {""} ;
      T000Z6_n44UbigeoCode = new boolean[] {false} ;
      T000Z7_A44UbigeoCode = new String[] {""} ;
      T000Z7_n44UbigeoCode = new boolean[] {false} ;
      T000Z2_A44UbigeoCode = new String[] {""} ;
      T000Z2_n44UbigeoCode = new boolean[] {false} ;
      T000Z2_A186UbigeoDepartamento = new String[] {""} ;
      T000Z2_A187UbigeoProvincia = new String[] {""} ;
      T000Z2_A188UbigeoDistrito = new String[] {""} ;
      T000Z2_A294UbigeoEstado = new String[] {""} ;
      T000Z11_A30SedeId = new short[1] ;
      T000Z12_A20PacienteId = new int[1] ;
      T000Z13_A31ProfesionalId = new int[1] ;
      T000Z14_A44UbigeoCode = new String[] {""} ;
      T000Z14_n44UbigeoCode = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ubigeo__default(),
         new Object[] {
             new Object[] {
            T000Z2_A44UbigeoCode, T000Z2_A186UbigeoDepartamento, T000Z2_A187UbigeoProvincia, T000Z2_A188UbigeoDistrito, T000Z2_A294UbigeoEstado
            }
            , new Object[] {
            T000Z3_A44UbigeoCode, T000Z3_A186UbigeoDepartamento, T000Z3_A187UbigeoProvincia, T000Z3_A188UbigeoDistrito, T000Z3_A294UbigeoEstado
            }
            , new Object[] {
            T000Z4_A44UbigeoCode, T000Z4_A186UbigeoDepartamento, T000Z4_A187UbigeoProvincia, T000Z4_A188UbigeoDistrito, T000Z4_A294UbigeoEstado
            }
            , new Object[] {
            T000Z5_A44UbigeoCode
            }
            , new Object[] {
            T000Z6_A44UbigeoCode
            }
            , new Object[] {
            T000Z7_A44UbigeoCode
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000Z11_A30SedeId
            }
            , new Object[] {
            T000Z12_A20PacienteId
            }
            , new Object[] {
            T000Z13_A31ProfesionalId
            }
            , new Object[] {
            T000Z14_A44UbigeoCode
            }
         }
      );
      AV13Pgmname = "Ubigeo" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound45 ;
   private short nIsDirty_45 ;
   private int trnEnded ;
   private int edtUbigeoCode_Enabled ;
   private int edtUbigeoDepartamento_Enabled ;
   private int edtUbigeoDepartamentoCode_Enabled ;
   private int edtUbigeoProvincia_Enabled ;
   private int edtUbigeoProvinciaCode_Enabled ;
   private int edtUbigeoDistrito_Enabled ;
   private int edtUbigeoDistritoCode_Enabled ;
   private int edtUbigeoNombre_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV12UbigeoCode ;
   private String Z44UbigeoCode ;
   private String Z294UbigeoEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV12UbigeoCode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtUbigeoCode_Internalname ;
   private String A294UbigeoEstado ;
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
   private String TempTags ;
   private String A44UbigeoCode ;
   private String edtUbigeoCode_Jsonclick ;
   private String edtUbigeoDepartamento_Internalname ;
   private String edtUbigeoDepartamento_Jsonclick ;
   private String edtUbigeoDepartamentoCode_Internalname ;
   private String edtUbigeoDepartamentoCode_Jsonclick ;
   private String edtUbigeoProvincia_Internalname ;
   private String edtUbigeoProvincia_Jsonclick ;
   private String edtUbigeoProvinciaCode_Internalname ;
   private String edtUbigeoProvinciaCode_Jsonclick ;
   private String edtUbigeoDistrito_Internalname ;
   private String edtUbigeoDistrito_Jsonclick ;
   private String edtUbigeoDistritoCode_Internalname ;
   private String edtUbigeoDistritoCode_Jsonclick ;
   private String edtUbigeoNombre_Internalname ;
   private String edtUbigeoNombre_Jsonclick ;
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
   private String sMode45 ;
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
   private boolean n44UbigeoCode ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z186UbigeoDepartamento ;
   private String Z187UbigeoProvincia ;
   private String Z188UbigeoDistrito ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String A187UbigeoProvincia ;
   private String A296UbigeoProvinciaCode ;
   private String A188UbigeoDistrito ;
   private String A297UbigeoDistritoCode ;
   private String A185UbigeoNombre ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbUbigeoEstado ;
   private IDataStoreProvider pr_default ;
   private String[] T000Z4_A44UbigeoCode ;
   private boolean[] T000Z4_n44UbigeoCode ;
   private String[] T000Z4_A186UbigeoDepartamento ;
   private String[] T000Z4_A187UbigeoProvincia ;
   private String[] T000Z4_A188UbigeoDistrito ;
   private String[] T000Z4_A294UbigeoEstado ;
   private String[] T000Z5_A44UbigeoCode ;
   private boolean[] T000Z5_n44UbigeoCode ;
   private String[] T000Z3_A44UbigeoCode ;
   private boolean[] T000Z3_n44UbigeoCode ;
   private String[] T000Z3_A186UbigeoDepartamento ;
   private String[] T000Z3_A187UbigeoProvincia ;
   private String[] T000Z3_A188UbigeoDistrito ;
   private String[] T000Z3_A294UbigeoEstado ;
   private String[] T000Z6_A44UbigeoCode ;
   private boolean[] T000Z6_n44UbigeoCode ;
   private String[] T000Z7_A44UbigeoCode ;
   private boolean[] T000Z7_n44UbigeoCode ;
   private String[] T000Z2_A44UbigeoCode ;
   private boolean[] T000Z2_n44UbigeoCode ;
   private String[] T000Z2_A186UbigeoDepartamento ;
   private String[] T000Z2_A187UbigeoProvincia ;
   private String[] T000Z2_A188UbigeoDistrito ;
   private String[] T000Z2_A294UbigeoEstado ;
   private short[] T000Z11_A30SedeId ;
   private int[] T000Z12_A20PacienteId ;
   private int[] T000Z13_A31ProfesionalId ;
   private String[] T000Z14_A44UbigeoCode ;
   private boolean[] T000Z14_n44UbigeoCode ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
}

final  class ubigeo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000Z2", "SELECT [UbigeoCode], [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito], [UbigeoEstado] FROM [Ubigeo] WITH (UPDLOCK) WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z3", "SELECT [UbigeoCode], [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito], [UbigeoEstado] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z4", "SELECT TM1.[UbigeoCode], TM1.[UbigeoDepartamento], TM1.[UbigeoProvincia], TM1.[UbigeoDistrito], TM1.[UbigeoEstado] FROM [Ubigeo] TM1 WHERE TM1.[UbigeoCode] = ? ORDER BY TM1.[UbigeoCode]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z5", "SELECT [UbigeoCode] FROM [Ubigeo] WHERE [UbigeoCode] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000Z6", "SELECT TOP 1 [UbigeoCode] FROM [Ubigeo] WHERE ( [UbigeoCode] > ?) ORDER BY [UbigeoCode]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z7", "SELECT TOP 1 [UbigeoCode] FROM [Ubigeo] WHERE ( [UbigeoCode] < ?) ORDER BY [UbigeoCode] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000Z8", "INSERT INTO [Ubigeo]([UbigeoCode], [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito], [UbigeoEstado]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000Z9", "UPDATE [Ubigeo] SET [UbigeoDepartamento]=?, [UbigeoProvincia]=?, [UbigeoDistrito]=?, [UbigeoEstado]=?  WHERE [UbigeoCode] = ?", GX_NOMASK)
         ,new UpdateCursor("T000Z10", "DELETE FROM [Ubigeo]  WHERE [UbigeoCode] = ?", GX_NOMASK)
         ,new ForEachCursor("T000Z11", "SELECT TOP 1 [SedeId] FROM [Sede] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z12", "SELECT TOP 1 [PacienteId] FROM [Paciente] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z13", "SELECT TOP 1 [ProfesionalId] FROM [Profesional] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000Z14", "SELECT [UbigeoCode] FROM [Ubigeo] ORDER BY [UbigeoCode]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
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
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               stmt.setVarchar(2, (String)parms[2], 100, false);
               stmt.setVarchar(3, (String)parms[3], 100, false);
               stmt.setVarchar(4, (String)parms[4], 100, false);
               stmt.setString(5, (String)parms[5], 1);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setString(4, (String)parms[3], 1);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 10);
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
      }
   }

}

