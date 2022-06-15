package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class laboratorio_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_7") == 0 )
      {
         A6SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_7( A6SecUserId) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_laboratoriousuarios") == 0 )
      {
         nRC_GXsfl_59 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_59"))) ;
         nGXsfl_59_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_59_idx"))) ;
         sGXsfl_59_idx = httpContext.GetPar( "sGXsfl_59_idx") ;
         edtSecUserId_Horizontalalignment = httpContext.GetNextPar( ) ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Horizontalalignment", edtSecUserId_Horizontalalignment, !bGXsfl_59_Refreshing);
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridlevel_laboratoriousuarios_newrow( ) ;
         return  ;
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
            AV21LaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "LaboratorioId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21LaboratorioId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLABORATORIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21LaboratorioId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Laboratorio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtLaboratorioNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public laboratorio_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public laboratorio_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( laboratorio_impl.class ));
   }

   public laboratorio_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbLaboratorioTipoDocumento = new HTMLChoice();
      cmbLaboratorioEstado = new HTMLChoice();
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
      if ( cmbLaboratorioTipoDocumento.getItemCount() > 0 )
      {
         A167LaboratorioTipoDocumento = cmbLaboratorioTipoDocumento.getValidValue(A167LaboratorioTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A167LaboratorioTipoDocumento", A167LaboratorioTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLaboratorioTipoDocumento.setValue( GXutil.rtrim( A167LaboratorioTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioTipoDocumento.getInternalname(), "Values", cmbLaboratorioTipoDocumento.ToJavascriptSource(), true);
      }
      if ( cmbLaboratorioEstado.getItemCount() > 0 )
      {
         A171LaboratorioEstado = cmbLaboratorioEstado.getValidValue(A171LaboratorioEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A171LaboratorioEstado", A171LaboratorioEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbLaboratorioEstado.setValue( GXutil.rtrim( A171LaboratorioEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioEstado.getInternalname(), "Values", cmbLaboratorioEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioId_Internalname, "Id", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioId_Internalname, GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtLaboratorioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioId_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtLaboratorioId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Laboratorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioNombre_Internalname, "Nombre", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioNombre_Internalname, A165LaboratorioNombre, GXutil.rtrim( localUtil.format( A165LaboratorioNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioNombre_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtLaboratorioNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Laboratorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLaboratorioTipoDocumento.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbLaboratorioTipoDocumento.getInternalname(), "Tipo Documento", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLaboratorioTipoDocumento, cmbLaboratorioTipoDocumento.getInternalname(), GXutil.rtrim( A167LaboratorioTipoDocumento), 1, cmbLaboratorioTipoDocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbLaboratorioTipoDocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute AttributeLabelSizeLarge", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "", true, (byte)(1), "HLP_Laboratorio.htm");
      cmbLaboratorioTipoDocumento.setValue( GXutil.rtrim( A167LaboratorioTipoDocumento) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioTipoDocumento.getInternalname(), "Values", cmbLaboratorioTipoDocumento.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioNroDocumento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioNroDocumento_Internalname, "Nro Documento", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioNroDocumento_Internalname, A168LaboratorioNroDocumento, GXutil.rtrim( localUtil.format( A168LaboratorioNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioNroDocumento_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtLaboratorioNroDocumento_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Laboratorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgLaboratorioPhoto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Imagen", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      ClassString = "Attribute AttributeLabelSizeLarge" ;
      StyleString = "" ;
      A169LaboratorioPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A169LaboratorioPhoto)==0)&&(GXutil.strcmp("", A40000LaboratorioPhoto_GXI)==0))||!(GXutil.strcmp("", A169LaboratorioPhoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.getResourceRelative(A169LaboratorioPhoto)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgLaboratorioPhoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgLaboratorioPhoto_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "", "", "", 0, A169LaboratorioPhoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Laboratorio.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "URL", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.getResourceRelative(A169LaboratorioPhoto)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "IsBlob", GXutil.booltostr( A169LaboratorioPhoto_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioDescripcion_Internalname, "Descripcion", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "Attribute AttributeLabelSizeLarge" ;
      StyleString = "" ;
      ClassString = "Attribute AttributeLabelSizeLarge" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtLaboratorioDescripcion_Internalname, A166LaboratorioDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", (short)(0), 1, edtLaboratorioDescripcion_Enabled, 0, 80, "chr", 7, "row", StyleString, ClassString, "", "", "500", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Laboratorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioComision_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioComision_Internalname, "Comision", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioComision_Internalname, GXutil.ltrim( localUtil.ntoc( A170LaboratorioComision, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtLaboratorioComision_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A170LaboratorioComision), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A170LaboratorioComision), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioComision_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtLaboratorioComision_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Laboratorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbLaboratorioEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbLaboratorioEstado.getInternalname(), "Estado", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbLaboratorioEstado, cmbLaboratorioEstado.getInternalname(), GXutil.rtrim( A171LaboratorioEstado), 1, cmbLaboratorioEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbLaboratorioEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute AttributeLabelSizeLarge", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(1), "HLP_Laboratorio.htm");
      cmbLaboratorioEstado.setValue( GXutil.rtrim( A171LaboratorioEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioEstado.getInternalname(), "Values", cmbLaboratorioEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTableleaflevel_laboratoriousuarios_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      gxdraw_gridlevel_laboratoriousuarios( ) ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Laboratorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Laboratorio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Laboratorio.htm");
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
      /* User Defined Control */
      ucCombo_secuserid.setProperty("Caption", Combo_secuserid_Caption);
      ucCombo_secuserid.setProperty("Cls", Combo_secuserid_Cls);
      ucCombo_secuserid.setProperty("IsGridItem", Combo_secuserid_Isgriditem);
      ucCombo_secuserid.setProperty("HasDescription", Combo_secuserid_Hasdescription);
      ucCombo_secuserid.setProperty("DataListProc", Combo_secuserid_Datalistproc);
      ucCombo_secuserid.setProperty("DataListProcParametersPrefix", Combo_secuserid_Datalistprocparametersprefix);
      ucCombo_secuserid.setProperty("EmptyItem", Combo_secuserid_Emptyitem);
      ucCombo_secuserid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_secuserid.setProperty("DropDownOptionsData", AV16SecUserId_Data);
      ucCombo_secuserid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_secuserid_Internalname, "COMBO_SECUSERIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridlevel_laboratoriousuarios( )
   {
      /*  Grid Control  */
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("GridName", "Gridlevel_laboratoriousuarios");
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Header", subGridlevel_laboratoriousuarios_Header);
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_laboratoriousuariosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_laboratoriousuariosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosColumn.AddObjectProperty("Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment));
      Gridlevel_laboratoriousuariosContainer.AddColumnProperties(Gridlevel_laboratoriousuariosColumn);
      Gridlevel_laboratoriousuariosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_laboratoriousuariosColumn.AddObjectProperty("Value", A14SecUserName);
      Gridlevel_laboratoriousuariosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddColumnProperties(Gridlevel_laboratoriousuariosColumn);
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_laboratoriousuariosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_laboratoriousuarios_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_59_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount34 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_34 = (short)(1) ;
            scanStart0P34( ) ;
            while ( RcdFound34 != 0 )
            {
               init_level_properties34( ) ;
               getByPrimaryKey0P34( ) ;
               addRow0P34( ) ;
               scanNext0P34( ) ;
            }
            scanEnd0P34( ) ;
            nBlankRcdCount34 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0P34( ) ;
         standaloneModal0P34( ) ;
         sMode34 = Gx_mode ;
         while ( nGXsfl_59_idx < nRC_GXsfl_59 )
         {
            bGXsfl_59_Refreshing = true ;
            readRow0P34( ) ;
            edtSecUserId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERID_"+sGXsfl_59_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_59_Refreshing);
            edtSecUserId_Horizontalalignment = httpContext.cgiGet( "SECUSERID_"+sGXsfl_59_idx+"Horizontalalignment") ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Horizontalalignment", edtSecUserId_Horizontalalignment, !bGXsfl_59_Refreshing);
            edtSecUserName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERNAME_"+sGXsfl_59_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Enabled), 5, 0), !bGXsfl_59_Refreshing);
            if ( ( nRcdExists_34 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0P34( ) ;
            }
            sendRow0P34( ) ;
            bGXsfl_59_Refreshing = false ;
         }
         Gx_mode = sMode34 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount34 = (short)(5) ;
         nRcdExists_34 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0P34( ) ;
            while ( RcdFound34 != 0 )
            {
               sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_5934( ) ;
               init_level_properties34( ) ;
               standaloneNotModal0P34( ) ;
               getByPrimaryKey0P34( ) ;
               standaloneModal0P34( ) ;
               addRow0P34( ) ;
               scanNext0P34( ) ;
            }
            scanEnd0P34( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode34 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_5934( ) ;
         initAll0P34( ) ;
         init_level_properties34( ) ;
         nRcdExists_34 = (short)(0) ;
         nIsMod_34 = (short)(0) ;
         nRcdDeleted_34 = (short)(0) ;
         nBlankRcdCount34 = (short)(nBlankRcdUsr34+nBlankRcdCount34) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount34 > 0 )
         {
            standaloneNotModal0P34( ) ;
            standaloneModal0P34( ) ;
            addRow0P34( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount34 = (short)(nBlankRcdCount34-1) ;
         }
         Gx_mode = sMode34 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_laboratoriousuariosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_laboratoriousuarios", Gridlevel_laboratoriousuariosContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_laboratoriousuariosContainerData", Gridlevel_laboratoriousuariosContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_laboratoriousuariosContainerData"+"V", Gridlevel_laboratoriousuariosContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_laboratoriousuariosContainerData"+"V"+"\" value='"+Gridlevel_laboratoriousuariosContainer.GridValuesHidden()+"'/>") ;
      }
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
      e110P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECUSERID_DATA"), AV16SecUserId_Data);
            /* Read saved values. */
            Z40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( "Z40LaboratorioId"), ",", ".")) ;
            Z165LaboratorioNombre = httpContext.cgiGet( "Z165LaboratorioNombre") ;
            Z166LaboratorioDescripcion = httpContext.cgiGet( "Z166LaboratorioDescripcion") ;
            Z167LaboratorioTipoDocumento = httpContext.cgiGet( "Z167LaboratorioTipoDocumento") ;
            Z168LaboratorioNroDocumento = httpContext.cgiGet( "Z168LaboratorioNroDocumento") ;
            Z170LaboratorioComision = (short)(localUtil.ctol( httpContext.cgiGet( "Z170LaboratorioComision"), ",", ".")) ;
            Z171LaboratorioEstado = httpContext.cgiGet( "Z171LaboratorioEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_59 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_59"), ",", ".")) ;
            AV21LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( "vLABORATORIOID"), ",", ".")) ;
            A40000LaboratorioPhoto_GXI = httpContext.cgiGet( "LABORATORIOPHOTO_GXI") ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Combo_secuserid_Objectcall = httpContext.cgiGet( "COMBO_SECUSERID_Objectcall") ;
            Combo_secuserid_Class = httpContext.cgiGet( "COMBO_SECUSERID_Class") ;
            Combo_secuserid_Icontype = httpContext.cgiGet( "COMBO_SECUSERID_Icontype") ;
            Combo_secuserid_Icon = httpContext.cgiGet( "COMBO_SECUSERID_Icon") ;
            Combo_secuserid_Caption = httpContext.cgiGet( "COMBO_SECUSERID_Caption") ;
            Combo_secuserid_Tooltip = httpContext.cgiGet( "COMBO_SECUSERID_Tooltip") ;
            Combo_secuserid_Cls = httpContext.cgiGet( "COMBO_SECUSERID_Cls") ;
            Combo_secuserid_Selectedvalue_set = httpContext.cgiGet( "COMBO_SECUSERID_Selectedvalue_set") ;
            Combo_secuserid_Selectedvalue_get = httpContext.cgiGet( "COMBO_SECUSERID_Selectedvalue_get") ;
            Combo_secuserid_Selectedtext_set = httpContext.cgiGet( "COMBO_SECUSERID_Selectedtext_set") ;
            Combo_secuserid_Selectedtext_get = httpContext.cgiGet( "COMBO_SECUSERID_Selectedtext_get") ;
            Combo_secuserid_Gamoauthtoken = httpContext.cgiGet( "COMBO_SECUSERID_Gamoauthtoken") ;
            Combo_secuserid_Ddointernalname = httpContext.cgiGet( "COMBO_SECUSERID_Ddointernalname") ;
            Combo_secuserid_Titlecontrolalign = httpContext.cgiGet( "COMBO_SECUSERID_Titlecontrolalign") ;
            Combo_secuserid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SECUSERID_Dropdownoptionstype") ;
            Combo_secuserid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Enabled")) ;
            Combo_secuserid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Visible")) ;
            Combo_secuserid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SECUSERID_Titlecontrolidtoreplace") ;
            Combo_secuserid_Datalisttype = httpContext.cgiGet( "COMBO_SECUSERID_Datalisttype") ;
            Combo_secuserid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Allowmultipleselection")) ;
            Combo_secuserid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SECUSERID_Datalistfixedvalues") ;
            Combo_secuserid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Isgriditem")) ;
            Combo_secuserid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Hasdescription")) ;
            Combo_secuserid_Datalistproc = httpContext.cgiGet( "COMBO_SECUSERID_Datalistproc") ;
            Combo_secuserid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SECUSERID_Datalistprocparametersprefix") ;
            Combo_secuserid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SECUSERID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_secuserid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Includeonlyselectedoption")) ;
            Combo_secuserid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Includeselectalloption")) ;
            Combo_secuserid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Emptyitem")) ;
            Combo_secuserid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SECUSERID_Includeaddnewoption")) ;
            Combo_secuserid_Htmltemplate = httpContext.cgiGet( "COMBO_SECUSERID_Htmltemplate") ;
            Combo_secuserid_Multiplevaluestype = httpContext.cgiGet( "COMBO_SECUSERID_Multiplevaluestype") ;
            Combo_secuserid_Loadingdata = httpContext.cgiGet( "COMBO_SECUSERID_Loadingdata") ;
            Combo_secuserid_Noresultsfound = httpContext.cgiGet( "COMBO_SECUSERID_Noresultsfound") ;
            Combo_secuserid_Emptyitemtext = httpContext.cgiGet( "COMBO_SECUSERID_Emptyitemtext") ;
            Combo_secuserid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SECUSERID_Onlyselectedvalues") ;
            Combo_secuserid_Selectalltext = httpContext.cgiGet( "COMBO_SECUSERID_Selectalltext") ;
            Combo_secuserid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SECUSERID_Multiplevaluesseparator") ;
            Combo_secuserid_Addnewoptiontext = httpContext.cgiGet( "COMBO_SECUSERID_Addnewoptiontext") ;
            /* Read variables values. */
            A40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            A165LaboratorioNombre = httpContext.cgiGet( edtLaboratorioNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
            cmbLaboratorioTipoDocumento.setName( cmbLaboratorioTipoDocumento.getInternalname() );
            cmbLaboratorioTipoDocumento.setValue( httpContext.cgiGet( cmbLaboratorioTipoDocumento.getInternalname()) );
            A167LaboratorioTipoDocumento = httpContext.cgiGet( cmbLaboratorioTipoDocumento.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A167LaboratorioTipoDocumento", A167LaboratorioTipoDocumento);
            A168LaboratorioNroDocumento = httpContext.cgiGet( edtLaboratorioNroDocumento_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A168LaboratorioNroDocumento", A168LaboratorioNroDocumento);
            A169LaboratorioPhoto = httpContext.cgiGet( imgLaboratorioPhoto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A169LaboratorioPhoto", A169LaboratorioPhoto);
            A166LaboratorioDescripcion = httpContext.cgiGet( edtLaboratorioDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A166LaboratorioDescripcion", A166LaboratorioDescripcion);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtLaboratorioComision_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtLaboratorioComision_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "LABORATORIOCOMISION");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLaboratorioComision_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A170LaboratorioComision = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A170LaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A170LaboratorioComision), 4, 0));
            }
            else
            {
               A170LaboratorioComision = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioComision_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A170LaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A170LaboratorioComision), 4, 0));
            }
            cmbLaboratorioEstado.setName( cmbLaboratorioEstado.getInternalname() );
            cmbLaboratorioEstado.setValue( httpContext.cgiGet( cmbLaboratorioEstado.getInternalname()) );
            A171LaboratorioEstado = httpContext.cgiGet( cmbLaboratorioEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A171LaboratorioEstado", A171LaboratorioEstado);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A169LaboratorioPhoto ;
            GXv_char2[0] = A40000LaboratorioPhoto_GXI ;
            httpContext.getMultimediaValue(imgLaboratorioPhoto_Internalname, GXv_char1, GXv_char2);
            laboratorio_impl.this.A169LaboratorioPhoto = GXv_char1[0] ;
            laboratorio_impl.this.A40000LaboratorioPhoto_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Laboratorio");
            A40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            forbiddenHiddens.add("LaboratorioId", localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A40LaboratorioId != Z40LaboratorioId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("laboratorio:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A40LaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "LaboratorioId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
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
                  sMode33 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode33 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound33 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0P0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "LABORATORIOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtLaboratorioId_Internalname ;
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
                        e110P2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120P2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e120P2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0P33( ) ;
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
         disableAttributes0P33( ) ;
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

   public void confirm_0P0( )
   {
      beforeValidate0P33( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0P33( ) ;
         }
         else
         {
            checkExtendedTable0P33( ) ;
            closeExtendedTableCursors0P33( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode33 = Gx_mode ;
         confirm_0P34( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode33 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode33 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0P34( )
   {
      nGXsfl_59_idx = 0 ;
      while ( nGXsfl_59_idx < nRC_GXsfl_59 )
      {
         readRow0P34( ) ;
         if ( ( nRcdExists_34 != 0 ) || ( nIsMod_34 != 0 ) )
         {
            getKey0P34( ) ;
            if ( ( nRcdExists_34 == 0 ) && ( nRcdDeleted_34 == 0 ) )
            {
               if ( RcdFound34 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0P34( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0P34( ) ;
                     closeExtendedTableCursors0P34( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "SECUSERID_" + sGXsfl_59_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecUserId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound34 != 0 )
               {
                  if ( nRcdDeleted_34 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0P34( ) ;
                     load0P34( ) ;
                     beforeValidate0P34( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0P34( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_34 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0P34( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0P34( ) ;
                           closeExtendedTableCursors0P34( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_34 == 0 )
                  {
                     GXCCtl = "SECUSERID_" + sGXsfl_59_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecUserId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSecUserId_Internalname, GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSecUserName_Internalname, A14SecUserName) ;
         httpContext.changePostValue( "ZT_"+"Z6SecUserId_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_34_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_34, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_34_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_34, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_34_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_34, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_34 != 0 )
         {
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_59_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_59_idx+"Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment)) ;
            httpContext.changePostValue( "SECUSERNAME_"+sGXsfl_59_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0P0( )
   {
   }

   public void e110P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV7WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      Combo_secuserid_Titlecontrolidtoreplace = edtSecUserId_Internalname ;
      ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "TitleControlIdToReplace", Combo_secuserid_Titlecontrolidtoreplace);
      edtSecUserId_Horizontalalignment = "Left" ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Horizontalalignment", edtSecUserId_Horizontalalignment, !bGXsfl_59_Refreshing);
      AV8IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio_Insert", GXv_boolean7) ;
         laboratorio_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio_Update", GXv_boolean7) ;
         laboratorio_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLaboratorio_Delete", GXv_boolean7) ;
         laboratorio_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e120P2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.laboratorioww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0P33( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z165LaboratorioNombre = T000P6_A165LaboratorioNombre[0] ;
            Z166LaboratorioDescripcion = T000P6_A166LaboratorioDescripcion[0] ;
            Z167LaboratorioTipoDocumento = T000P6_A167LaboratorioTipoDocumento[0] ;
            Z168LaboratorioNroDocumento = T000P6_A168LaboratorioNroDocumento[0] ;
            Z170LaboratorioComision = T000P6_A170LaboratorioComision[0] ;
            Z171LaboratorioEstado = T000P6_A171LaboratorioEstado[0] ;
         }
         else
         {
            Z165LaboratorioNombre = A165LaboratorioNombre ;
            Z166LaboratorioDescripcion = A166LaboratorioDescripcion ;
            Z167LaboratorioTipoDocumento = A167LaboratorioTipoDocumento ;
            Z168LaboratorioNroDocumento = A168LaboratorioNroDocumento ;
            Z170LaboratorioComision = A170LaboratorioComision ;
            Z171LaboratorioEstado = A171LaboratorioEstado ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z40LaboratorioId = A40LaboratorioId ;
         Z165LaboratorioNombre = A165LaboratorioNombre ;
         Z166LaboratorioDescripcion = A166LaboratorioDescripcion ;
         Z167LaboratorioTipoDocumento = A167LaboratorioTipoDocumento ;
         Z168LaboratorioNroDocumento = A168LaboratorioNroDocumento ;
         Z169LaboratorioPhoto = A169LaboratorioPhoto ;
         Z40000LaboratorioPhoto_GXI = A40000LaboratorioPhoto_GXI ;
         Z170LaboratorioComision = A170LaboratorioComision ;
         Z171LaboratorioEstado = A171LaboratorioEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      edtLaboratorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Enabled), 5, 0), true);
      edtLaboratorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV21LaboratorioId) )
      {
         A40LaboratorioId = AV21LaboratorioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
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

   public void load0P33( )
   {
      /* Using cursor T000P7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A165LaboratorioNombre = T000P7_A165LaboratorioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
         A166LaboratorioDescripcion = T000P7_A166LaboratorioDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A166LaboratorioDescripcion", A166LaboratorioDescripcion);
         A167LaboratorioTipoDocumento = T000P7_A167LaboratorioTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A167LaboratorioTipoDocumento", A167LaboratorioTipoDocumento);
         A168LaboratorioNroDocumento = T000P7_A168LaboratorioNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A168LaboratorioNroDocumento", A168LaboratorioNroDocumento);
         A169LaboratorioPhoto = T000P7_A169LaboratorioPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A169LaboratorioPhoto", A169LaboratorioPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
         A40000LaboratorioPhoto_GXI = T000P7_A40000LaboratorioPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
         A170LaboratorioComision = T000P7_A170LaboratorioComision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A170LaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A170LaboratorioComision), 4, 0));
         A171LaboratorioEstado = T000P7_A171LaboratorioEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A171LaboratorioEstado", A171LaboratorioEstado);
         zm0P33( -5) ;
      }
      pr_default.close(5);
      onLoadActions0P33( ) ;
   }

   public void onLoadActions0P33( )
   {
      AV22Pgmname = "Laboratorio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
   }

   public void checkExtendedTable0P33( )
   {
      nIsDirty_33 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV22Pgmname = "Laboratorio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      if ( ! ( ( GXutil.strcmp(A167LaboratorioTipoDocumento, "6") == 0 ) || ( GXutil.strcmp(A167LaboratorioTipoDocumento, "1") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Laboratorio Tipo Documento fuera de rango", "OutOfRange", 1, "LABORATORIOTIPODOCUMENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLaboratorioTipoDocumento.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A171LaboratorioEstado, "A") == 0 ) || ( GXutil.strcmp(A171LaboratorioEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Laboratorio Estado fuera de rango", "OutOfRange", 1, "LABORATORIOESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbLaboratorioEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0P33( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0P33( )
   {
      /* Using cursor T000P8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound33 = (short)(1) ;
      }
      else
      {
         RcdFound33 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000P6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0P33( 5) ;
         RcdFound33 = (short)(1) ;
         A40LaboratorioId = T000P6_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         A165LaboratorioNombre = T000P6_A165LaboratorioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
         A166LaboratorioDescripcion = T000P6_A166LaboratorioDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A166LaboratorioDescripcion", A166LaboratorioDescripcion);
         A167LaboratorioTipoDocumento = T000P6_A167LaboratorioTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A167LaboratorioTipoDocumento", A167LaboratorioTipoDocumento);
         A168LaboratorioNroDocumento = T000P6_A168LaboratorioNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A168LaboratorioNroDocumento", A168LaboratorioNroDocumento);
         A169LaboratorioPhoto = T000P6_A169LaboratorioPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A169LaboratorioPhoto", A169LaboratorioPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
         A40000LaboratorioPhoto_GXI = T000P6_A40000LaboratorioPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
         A170LaboratorioComision = T000P6_A170LaboratorioComision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A170LaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A170LaboratorioComision), 4, 0));
         A171LaboratorioEstado = T000P6_A171LaboratorioEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A171LaboratorioEstado", A171LaboratorioEstado);
         Z40LaboratorioId = A40LaboratorioId ;
         sMode33 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0P33( ) ;
         if ( AnyError == 1 )
         {
            RcdFound33 = (short)(0) ;
            initializeNonKey0P33( ) ;
         }
         Gx_mode = sMode33 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound33 = (short)(0) ;
         initializeNonKey0P33( ) ;
         sMode33 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode33 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0P33( ) ;
      if ( RcdFound33 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound33 = (short)(0) ;
      /* Using cursor T000P9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000P9_A40LaboratorioId[0] < A40LaboratorioId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000P9_A40LaboratorioId[0] > A40LaboratorioId ) ) )
         {
            A40LaboratorioId = T000P9_A40LaboratorioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            RcdFound33 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound33 = (short)(0) ;
      /* Using cursor T000P10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000P10_A40LaboratorioId[0] > A40LaboratorioId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000P10_A40LaboratorioId[0] < A40LaboratorioId ) ) )
         {
            A40LaboratorioId = T000P10_A40LaboratorioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            RcdFound33 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0P33( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtLaboratorioNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0P33( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound33 == 1 )
         {
            if ( A40LaboratorioId != Z40LaboratorioId )
            {
               A40LaboratorioId = Z40LaboratorioId ;
               httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "LABORATORIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtLaboratorioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtLaboratorioNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0P33( ) ;
               GX_FocusControl = edtLaboratorioNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A40LaboratorioId != Z40LaboratorioId )
            {
               /* Insert record */
               GX_FocusControl = edtLaboratorioNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0P33( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "LABORATORIOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtLaboratorioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtLaboratorioNombre_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0P33( ) ;
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
      if ( A40LaboratorioId != Z40LaboratorioId )
      {
         A40LaboratorioId = Z40LaboratorioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "LABORATORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtLaboratorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtLaboratorioNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0P33( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000P5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A40LaboratorioId)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Laboratorio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || ( GXutil.strcmp(Z165LaboratorioNombre, T000P5_A165LaboratorioNombre[0]) != 0 ) || ( GXutil.strcmp(Z166LaboratorioDescripcion, T000P5_A166LaboratorioDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z167LaboratorioTipoDocumento, T000P5_A167LaboratorioTipoDocumento[0]) != 0 ) || ( GXutil.strcmp(Z168LaboratorioNroDocumento, T000P5_A168LaboratorioNroDocumento[0]) != 0 ) || ( Z170LaboratorioComision != T000P5_A170LaboratorioComision[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z171LaboratorioEstado, T000P5_A171LaboratorioEstado[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z165LaboratorioNombre, T000P5_A165LaboratorioNombre[0]) != 0 )
            {
               GXutil.writeLogln("laboratorio:[seudo value changed for attri]"+"LaboratorioNombre");
               GXutil.writeLogRaw("Old: ",Z165LaboratorioNombre);
               GXutil.writeLogRaw("Current: ",T000P5_A165LaboratorioNombre[0]);
            }
            if ( GXutil.strcmp(Z166LaboratorioDescripcion, T000P5_A166LaboratorioDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("laboratorio:[seudo value changed for attri]"+"LaboratorioDescripcion");
               GXutil.writeLogRaw("Old: ",Z166LaboratorioDescripcion);
               GXutil.writeLogRaw("Current: ",T000P5_A166LaboratorioDescripcion[0]);
            }
            if ( GXutil.strcmp(Z167LaboratorioTipoDocumento, T000P5_A167LaboratorioTipoDocumento[0]) != 0 )
            {
               GXutil.writeLogln("laboratorio:[seudo value changed for attri]"+"LaboratorioTipoDocumento");
               GXutil.writeLogRaw("Old: ",Z167LaboratorioTipoDocumento);
               GXutil.writeLogRaw("Current: ",T000P5_A167LaboratorioTipoDocumento[0]);
            }
            if ( GXutil.strcmp(Z168LaboratorioNroDocumento, T000P5_A168LaboratorioNroDocumento[0]) != 0 )
            {
               GXutil.writeLogln("laboratorio:[seudo value changed for attri]"+"LaboratorioNroDocumento");
               GXutil.writeLogRaw("Old: ",Z168LaboratorioNroDocumento);
               GXutil.writeLogRaw("Current: ",T000P5_A168LaboratorioNroDocumento[0]);
            }
            if ( Z170LaboratorioComision != T000P5_A170LaboratorioComision[0] )
            {
               GXutil.writeLogln("laboratorio:[seudo value changed for attri]"+"LaboratorioComision");
               GXutil.writeLogRaw("Old: ",Z170LaboratorioComision);
               GXutil.writeLogRaw("Current: ",T000P5_A170LaboratorioComision[0]);
            }
            if ( GXutil.strcmp(Z171LaboratorioEstado, T000P5_A171LaboratorioEstado[0]) != 0 )
            {
               GXutil.writeLogln("laboratorio:[seudo value changed for attri]"+"LaboratorioEstado");
               GXutil.writeLogRaw("Old: ",Z171LaboratorioEstado);
               GXutil.writeLogRaw("Current: ",T000P5_A171LaboratorioEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Laboratorio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P33( )
   {
      beforeValidate0P33( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P33( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P33( 0) ;
         checkOptimisticConcurrency0P33( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P33( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P33( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000P11 */
                  pr_default.execute(9, new Object[] {A165LaboratorioNombre, A166LaboratorioDescripcion, A167LaboratorioTipoDocumento, A168LaboratorioNroDocumento, A169LaboratorioPhoto, A40000LaboratorioPhoto_GXI, Short.valueOf(A170LaboratorioComision), A171LaboratorioEstado});
                  A40LaboratorioId = T000P11_A40LaboratorioId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Laboratorio");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0P33( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0P0( ) ;
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
         else
         {
            load0P33( ) ;
         }
         endLevel0P33( ) ;
      }
      closeExtendedTableCursors0P33( ) ;
   }

   public void update0P33( )
   {
      beforeValidate0P33( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P33( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P33( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P33( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0P33( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000P12 */
                  pr_default.execute(10, new Object[] {A165LaboratorioNombre, A166LaboratorioDescripcion, A167LaboratorioTipoDocumento, A168LaboratorioNroDocumento, Short.valueOf(A170LaboratorioComision), A171LaboratorioEstado, Short.valueOf(A40LaboratorioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Laboratorio");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Laboratorio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0P33( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0P33( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0P33( ) ;
      }
      closeExtendedTableCursors0P33( ) ;
   }

   public void deferredUpdate0P33( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000P13 */
         pr_default.execute(11, new Object[] {A169LaboratorioPhoto, A40000LaboratorioPhoto_GXI, Short.valueOf(A40LaboratorioId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Laboratorio");
      }
   }

   public void delete( )
   {
      beforeValidate0P33( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P33( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P33( ) ;
         afterConfirm0P33( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P33( ) ;
            if ( AnyError == 0 )
            {
               scanStart0P34( ) ;
               while ( RcdFound34 != 0 )
               {
                  getByPrimaryKey0P34( ) ;
                  delete0P34( ) ;
                  scanNext0P34( ) ;
               }
               scanEnd0P34( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000P14 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A40LaboratorioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Laboratorio");
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
      }
      sMode33 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0P33( ) ;
      Gx_mode = sMode33 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0P33( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "Laboratorio" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000P15 */
         pr_default.execute(13, new Object[] {Short.valueOf(A40LaboratorioId)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Servicio Categ"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void processNestedLevel0P34( )
   {
      nGXsfl_59_idx = 0 ;
      while ( nGXsfl_59_idx < nRC_GXsfl_59 )
      {
         readRow0P34( ) ;
         if ( ( nRcdExists_34 != 0 ) || ( nIsMod_34 != 0 ) )
         {
            standaloneNotModal0P34( ) ;
            getKey0P34( ) ;
            if ( ( nRcdExists_34 == 0 ) && ( nRcdDeleted_34 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0P34( ) ;
            }
            else
            {
               if ( RcdFound34 != 0 )
               {
                  if ( ( nRcdDeleted_34 != 0 ) && ( nRcdExists_34 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0P34( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_34 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0P34( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_34 == 0 )
                  {
                     GXCCtl = "SECUSERID_" + sGXsfl_59_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecUserId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSecUserId_Internalname, GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSecUserName_Internalname, A14SecUserName) ;
         httpContext.changePostValue( "ZT_"+"Z6SecUserId_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_34_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_34, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_34_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_34, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_34_"+sGXsfl_59_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_34, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_34 != 0 )
         {
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_59_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_59_idx+"Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment)) ;
            httpContext.changePostValue( "SECUSERNAME_"+sGXsfl_59_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0P34( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_34 = (short)(0) ;
      nIsMod_34 = (short)(0) ;
      nRcdDeleted_34 = (short)(0) ;
   }

   public void processLevel0P33( )
   {
      /* Save parent mode. */
      sMode33 = Gx_mode ;
      processNestedLevel0P34( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode33 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0P33( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0P33( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         Application.commitDataStores(context, remoteHandle, pr_default, "laboratorio");
         if ( AnyError == 0 )
         {
            confirmValues0P0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "laboratorio");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0P33( )
   {
      /* Scan By routine */
      /* Using cursor T000P16 */
      pr_default.execute(14);
      RcdFound33 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A40LaboratorioId = T000P16_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0P33( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound33 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound33 = (short)(1) ;
         A40LaboratorioId = T000P16_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      }
   }

   public void scanEnd0P33( )
   {
      pr_default.close(14);
   }

   public void afterConfirm0P33( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P33( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P33( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P33( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P33( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P33( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P33( )
   {
      edtLaboratorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Enabled), 5, 0), true);
      edtLaboratorioNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioNombre_Enabled), 5, 0), true);
      cmbLaboratorioTipoDocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioTipoDocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLaboratorioTipoDocumento.getEnabled(), 5, 0), true);
      edtLaboratorioNroDocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioNroDocumento_Enabled), 5, 0), true);
      imgLaboratorioPhoto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgLaboratorioPhoto_Enabled), 5, 0), true);
      edtLaboratorioDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioDescripcion_Enabled), 5, 0), true);
      edtLaboratorioComision_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioComision_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioComision_Enabled), 5, 0), true);
      cmbLaboratorioEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbLaboratorioEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbLaboratorioEstado.getEnabled(), 5, 0), true);
   }

   public void zm0P34( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -6 )
      {
         Z40LaboratorioId = A40LaboratorioId ;
         Z6SecUserId = A6SecUserId ;
         Z14SecUserName = A14SecUserName ;
      }
   }

   public void standaloneNotModal0P34( )
   {
   }

   public void standaloneModal0P34( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtSecUserId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_59_Refreshing);
      }
      else
      {
         edtSecUserId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_59_Refreshing);
      }
   }

   public void load0P34( )
   {
      /* Using cursor T000P17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A40LaboratorioId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A14SecUserName = T000P17_A14SecUserName[0] ;
         zm0P34( -6) ;
      }
      pr_default.close(15);
      onLoadActions0P34( ) ;
   }

   public void onLoadActions0P34( )
   {
   }

   public void checkExtendedTable0P34( )
   {
      nIsDirty_34 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0P34( ) ;
      /* Using cursor T000P4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "SECUSERID_" + sGXsfl_59_idx ;
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A14SecUserName = T000P4_A14SecUserName[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors0P34( )
   {
      pr_default.close(2);
   }

   public void enableDisable0P34( )
   {
   }

   public void gxload_7( short A6SecUserId )
   {
      /* Using cursor T000P18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         GXCCtl = "SECUSERID_" + sGXsfl_59_idx ;
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A14SecUserName = T000P18_A14SecUserName[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A14SecUserName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(16) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(16);
   }

   public void getKey0P34( )
   {
      /* Using cursor T000P19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A40LaboratorioId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound34 = (short)(1) ;
      }
      else
      {
         RcdFound34 = (short)(0) ;
      }
      pr_default.close(17);
   }

   public void getByPrimaryKey0P34( )
   {
      /* Using cursor T000P3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A40LaboratorioId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0P34( 6) ;
         RcdFound34 = (short)(1) ;
         initializeNonKey0P34( ) ;
         A6SecUserId = T000P3_A6SecUserId[0] ;
         Z40LaboratorioId = A40LaboratorioId ;
         Z6SecUserId = A6SecUserId ;
         sMode34 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0P34( ) ;
         Gx_mode = sMode34 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound34 = (short)(0) ;
         initializeNonKey0P34( ) ;
         sMode34 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0P34( ) ;
         Gx_mode = sMode34 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0P34( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0P34( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000P2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A40LaboratorioId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LaboratorioLaboratorioUsuarios"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LaboratorioLaboratorioUsuarios"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0P34( )
   {
      beforeValidate0P34( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P34( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0P34( 0) ;
         checkOptimisticConcurrency0P34( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0P34( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0P34( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000P20 */
                  pr_default.execute(18, new Object[] {Short.valueOf(A40LaboratorioId), Short.valueOf(A6SecUserId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LaboratorioLaboratorioUsuarios");
                  if ( (pr_default.getStatus(18) == 1) )
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
            load0P34( ) ;
         }
         endLevel0P34( ) ;
      }
      closeExtendedTableCursors0P34( ) ;
   }

   public void update0P34( )
   {
      beforeValidate0P34( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0P34( ) ;
      }
      if ( ( nIsMod_34 != 0 ) || ( nIsDirty_34 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0P34( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0P34( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0P34( ) ;
                  if ( AnyError == 0 )
                  {
                     /* No attributes to update on table [LaboratorioLaboratorioUsuarios] */
                     deferredUpdate0P34( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0P34( ) ;
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
            endLevel0P34( ) ;
         }
      }
      closeExtendedTableCursors0P34( ) ;
   }

   public void deferredUpdate0P34( )
   {
   }

   public void delete0P34( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0P34( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0P34( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0P34( ) ;
         afterConfirm0P34( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0P34( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000P21 */
               pr_default.execute(19, new Object[] {Short.valueOf(A40LaboratorioId), Short.valueOf(A6SecUserId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LaboratorioLaboratorioUsuarios");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode34 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0P34( ) ;
      Gx_mode = sMode34 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0P34( )
   {
      standaloneModal0P34( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000P22 */
         pr_default.execute(20, new Object[] {Short.valueOf(A6SecUserId)});
         A14SecUserName = T000P22_A14SecUserName[0] ;
         pr_default.close(20);
      }
   }

   public void endLevel0P34( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0P34( )
   {
      /* Scan By routine */
      /* Using cursor T000P23 */
      pr_default.execute(21, new Object[] {Short.valueOf(A40LaboratorioId)});
      RcdFound34 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A6SecUserId = T000P23_A6SecUserId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0P34( )
   {
      /* Scan next routine */
      pr_default.readNext(21);
      RcdFound34 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound34 = (short)(1) ;
         A6SecUserId = T000P23_A6SecUserId[0] ;
      }
   }

   public void scanEnd0P34( )
   {
      pr_default.close(21);
   }

   public void afterConfirm0P34( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0P34( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0P34( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0P34( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0P34( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0P34( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0P34( )
   {
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_59_Refreshing);
      edtSecUserName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Enabled), 5, 0), !bGXsfl_59_Refreshing);
   }

   public void send_integrity_lvl_hashes0P34( )
   {
   }

   public void send_integrity_lvl_hashes0P33( )
   {
   }

   public void subsflControlProps_5934( )
   {
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_59_idx ;
      edtSecUserName_Internalname = "SECUSERNAME_"+sGXsfl_59_idx ;
   }

   public void subsflControlProps_fel_5934( )
   {
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_59_fel_idx ;
      edtSecUserName_Internalname = "SECUSERNAME_"+sGXsfl_59_fel_idx ;
   }

   public void addRow0P34( )
   {
      nGXsfl_59_idx = (int)(nGXsfl_59_idx+1) ;
      sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5934( ) ;
      sendRow0P34( ) ;
   }

   public void sendRow0P34( )
   {
      Gridlevel_laboratoriousuariosRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_laboratoriousuarios_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_laboratoriousuarios_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_laboratoriousuarios_Class, "") != 0 )
         {
            subGridlevel_laboratoriousuarios_Linesclass = subGridlevel_laboratoriousuarios_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_laboratoriousuarios_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_laboratoriousuarios_Backstyle = (byte)(0) ;
         subGridlevel_laboratoriousuarios_Backcolor = subGridlevel_laboratoriousuarios_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_laboratoriousuarios_Class, "") != 0 )
         {
            subGridlevel_laboratoriousuarios_Linesclass = subGridlevel_laboratoriousuarios_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_laboratoriousuarios_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_laboratoriousuarios_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_laboratoriousuarios_Class, "") != 0 )
         {
            subGridlevel_laboratoriousuarios_Linesclass = subGridlevel_laboratoriousuarios_Class+"Odd" ;
         }
         subGridlevel_laboratoriousuarios_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_laboratoriousuarios_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_laboratoriousuarios_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_59_idx) % (2))) == 0 )
         {
            subGridlevel_laboratoriousuarios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_laboratoriousuarios_Class, "") != 0 )
            {
               subGridlevel_laboratoriousuarios_Linesclass = subGridlevel_laboratoriousuarios_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_laboratoriousuarios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_laboratoriousuarios_Class, "") != 0 )
            {
               subGridlevel_laboratoriousuarios_Linesclass = subGridlevel_laboratoriousuarios_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_34_" + sGXsfl_59_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 60,'',false,'" + sGXsfl_59_idx + "',59)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_laboratoriousuariosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecUserId_Internalname,GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,60);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecUserId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSecUserId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(59),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"",edtSecUserId_Horizontalalignment,Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_laboratoriousuariosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecUserName_Internalname,A14SecUserName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecUserName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSecUserName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(59),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridlevel_laboratoriousuariosRow);
      send_integrity_lvl_hashes0P34( ) ;
      GXCCtl = "Z6SecUserId_" + sGXsfl_59_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdDeleted_34_" + sGXsfl_59_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_34, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_34_" + sGXsfl_59_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_34, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_34_" + sGXsfl_59_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_34, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "vMODE_" + sGXsfl_59_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_59_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV10TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV10TrnContext);
      }
      GXCCtl = "vLABORATORIOID_" + sGXsfl_59_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV21LaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERID_"+sGXsfl_59_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERID_"+sGXsfl_59_idx+"Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERNAME_"+sGXsfl_59_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_laboratoriousuariosContainer.AddRow(Gridlevel_laboratoriousuariosRow);
   }

   public void readRow0P34( )
   {
      nGXsfl_59_idx = (int)(nGXsfl_59_idx+1) ;
      sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5934( ) ;
      edtSecUserId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERID_"+sGXsfl_59_idx+"Enabled"), ",", ".")) ;
      edtSecUserId_Horizontalalignment = httpContext.cgiGet( "SECUSERID_"+sGXsfl_59_idx+"Horizontalalignment") ;
      edtSecUserName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERNAME_"+sGXsfl_59_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") > 9999 ) ) )
      {
         GXCCtl = "SECUSERID_" + sGXsfl_59_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         wbErr = true ;
         A6SecUserId = (short)(0) ;
      }
      else
      {
         A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
      }
      A14SecUserName = httpContext.cgiGet( edtSecUserName_Internalname) ;
      GXCCtl = "Z6SecUserId_" + sGXsfl_59_idx ;
      Z6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdDeleted_34_" + sGXsfl_59_idx ;
      nRcdDeleted_34 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_34_" + sGXsfl_59_idx ;
      nRcdExists_34 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_34_" + sGXsfl_59_idx ;
      nIsMod_34 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void assign_properties_default( )
   {
      defedtSecUserId_Enabled = edtSecUserId_Enabled ;
   }

   public void confirmValues0P0( )
   {
      nGXsfl_59_idx = 0 ;
      sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5934( ) ;
      while ( nGXsfl_59_idx < nRC_GXsfl_59 )
      {
         nGXsfl_59_idx = (int)(nGXsfl_59_idx+1) ;
         sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5934( ) ;
         httpContext.changePostValue( "Z6SecUserId_"+sGXsfl_59_idx, httpContext.cgiGet( "ZT_"+"Z6SecUserId_"+sGXsfl_59_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z6SecUserId_"+sGXsfl_59_idx) ;
      }
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325350", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.laboratorio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV21LaboratorioId,4,0))}, new String[] {"Gx_mode","LaboratorioId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Laboratorio");
      forbiddenHiddens.add("LaboratorioId", localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("laboratorio:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z40LaboratorioId", GXutil.ltrim( localUtil.ntoc( Z40LaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z165LaboratorioNombre", Z165LaboratorioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z166LaboratorioDescripcion", Z166LaboratorioDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z167LaboratorioTipoDocumento", GXutil.rtrim( Z167LaboratorioTipoDocumento));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z168LaboratorioNroDocumento", Z168LaboratorioNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z170LaboratorioComision", GXutil.ltrim( localUtil.ntoc( Z170LaboratorioComision, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z171LaboratorioEstado", GXutil.rtrim( Z171LaboratorioEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_59", GXutil.ltrim( localUtil.ntoc( nGXsfl_59_idx, (byte)(8), (byte)(0), ",", "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSERID_DATA", AV16SecUserId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSERID_DATA", AV16SecUserId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vLABORATORIOID", GXutil.ltrim( localUtil.ntoc( AV21LaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLABORATORIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21LaboratorioId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "LABORATORIOPHOTO_GXI", A40000LaboratorioPhoto_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      GXCCtlgxBlob = "LABORATORIOPHOTO" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A169LaboratorioPhoto);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Objectcall", GXutil.rtrim( Combo_secuserid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Cls", GXutil.rtrim( Combo_secuserid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Enabled", GXutil.booltostr( Combo_secuserid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Titlecontrolidtoreplace", GXutil.rtrim( Combo_secuserid_Titlecontrolidtoreplace));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Isgriditem", GXutil.booltostr( Combo_secuserid_Isgriditem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Hasdescription", GXutil.booltostr( Combo_secuserid_Hasdescription));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Datalistproc", GXutil.rtrim( Combo_secuserid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Datalistprocparametersprefix", GXutil.rtrim( Combo_secuserid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Emptyitem", GXutil.booltostr( Combo_secuserid_Emptyitem));
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
      return formatLink("com.projectthani.laboratorio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV21LaboratorioId,4,0))}, new String[] {"Gx_mode","LaboratorioId"})  ;
   }

   public String getPgmname( )
   {
      return "Laboratorio" ;
   }

   public String getPgmdesc( )
   {
      return "Laboratorio" ;
   }

   public void initializeNonKey0P33( )
   {
      A165LaboratorioNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
      A166LaboratorioDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A166LaboratorioDescripcion", A166LaboratorioDescripcion);
      A167LaboratorioTipoDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A167LaboratorioTipoDocumento", A167LaboratorioTipoDocumento);
      A168LaboratorioNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A168LaboratorioNroDocumento", A168LaboratorioNroDocumento);
      A169LaboratorioPhoto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A169LaboratorioPhoto", A169LaboratorioPhoto);
      httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
      A40000LaboratorioPhoto_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A169LaboratorioPhoto)==0) ? A40000LaboratorioPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A169LaboratorioPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgLaboratorioPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A169LaboratorioPhoto), true);
      A170LaboratorioComision = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A170LaboratorioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A170LaboratorioComision), 4, 0));
      A171LaboratorioEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A171LaboratorioEstado", A171LaboratorioEstado);
      Z165LaboratorioNombre = "" ;
      Z166LaboratorioDescripcion = "" ;
      Z167LaboratorioTipoDocumento = "" ;
      Z168LaboratorioNroDocumento = "" ;
      Z170LaboratorioComision = (short)(0) ;
      Z171LaboratorioEstado = "" ;
   }

   public void initAll0P33( )
   {
      A40LaboratorioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      initializeNonKey0P33( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0P34( )
   {
      A14SecUserName = "" ;
   }

   public void initAll0P34( )
   {
      A6SecUserId = (short)(0) ;
      initializeNonKey0P34( ) ;
   }

   public void standaloneModalInsert0P34( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325372", true, true);
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
      httpContext.AddJavascriptSource("laboratorio.js", "?20225110325372", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties34( )
   {
      edtSecUserId_Enabled = defedtSecUserId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_59_Refreshing);
   }

   public void init_default_properties( )
   {
      edtLaboratorioId_Internalname = "LABORATORIOID" ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE" ;
      cmbLaboratorioTipoDocumento.setInternalname( "LABORATORIOTIPODOCUMENTO" );
      edtLaboratorioNroDocumento_Internalname = "LABORATORIONRODOCUMENTO" ;
      imgLaboratorioPhoto_Internalname = "LABORATORIOPHOTO" ;
      edtLaboratorioDescripcion_Internalname = "LABORATORIODESCRIPCION" ;
      edtLaboratorioComision_Internalname = "LABORATORIOCOMISION" ;
      cmbLaboratorioEstado.setInternalname( "LABORATORIOESTADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      edtSecUserName_Internalname = "SECUSERNAME" ;
      divTableleaflevel_laboratoriousuarios_Internalname = "TABLELEAFLEVEL_LABORATORIOUSUARIOS" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_secuserid_Internalname = "COMBO_SECUSERID" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_laboratoriousuarios_Internalname = "GRIDLEVEL_LABORATORIOUSUARIOS" ;
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
      Combo_secuserid_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Laboratorio" );
      edtSecUserName_Jsonclick = "" ;
      edtSecUserId_Jsonclick = "" ;
      subGridlevel_laboratoriousuarios_Class = "GridNoBorder WorkWith" ;
      subGridlevel_laboratoriousuarios_Backcolorstyle = (byte)(0) ;
      Combo_secuserid_Titlecontrolidtoreplace = "" ;
      subGridlevel_laboratoriousuarios_Allowcollapsing = (byte)(0) ;
      subGridlevel_laboratoriousuarios_Allowselection = (byte)(0) ;
      edtSecUserName_Enabled = 0 ;
      edtSecUserId_Enabled = 1 ;
      subGridlevel_laboratoriousuarios_Header = "" ;
      Combo_secuserid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_secuserid_Datalistprocparametersprefix = " \"ComboName\": \"SecUserId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"LaboratorioId\": 0" ;
      Combo_secuserid_Datalistproc = "LaboratorioLoadDVCombo" ;
      Combo_secuserid_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_secuserid_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_secuserid_Cls = "ExtendedCombo" ;
      Combo_secuserid_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbLaboratorioEstado.setJsonclick( "" );
      cmbLaboratorioEstado.setEnabled( 1 );
      edtLaboratorioComision_Jsonclick = "" ;
      edtLaboratorioComision_Enabled = 1 ;
      edtLaboratorioDescripcion_Enabled = 1 ;
      imgLaboratorioPhoto_Enabled = 1 ;
      edtLaboratorioNroDocumento_Jsonclick = "" ;
      edtLaboratorioNroDocumento_Enabled = 1 ;
      cmbLaboratorioTipoDocumento.setJsonclick( "" );
      cmbLaboratorioTipoDocumento.setEnabled( 1 );
      edtLaboratorioNombre_Jsonclick = "" ;
      edtLaboratorioNombre_Enabled = 1 ;
      edtLaboratorioId_Jsonclick = "" ;
      edtLaboratorioId_Enabled = 0 ;
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
      edtSecUserId_Horizontalalignment = "right" ;
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

   public void gxnrgridlevel_laboratoriousuarios_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_5934( ) ;
      while ( nGXsfl_59_idx <= nRC_GXsfl_59 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0P34( ) ;
         standaloneModal0P34( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0P34( ) ;
         nGXsfl_59_idx = (int)(nGXsfl_59_idx+1) ;
         sGXsfl_59_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_59_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5934( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_laboratoriousuariosContainer)) ;
      /* End function gxnrGridlevel_laboratoriousuarios_newrow */
   }

   public void init_web_controls( )
   {
      cmbLaboratorioTipoDocumento.setName( "LABORATORIOTIPODOCUMENTO" );
      cmbLaboratorioTipoDocumento.setWebtags( "" );
      cmbLaboratorioTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbLaboratorioTipoDocumento.addItem("1", "DNI", (short)(0));
      if ( cmbLaboratorioTipoDocumento.getItemCount() > 0 )
      {
         A167LaboratorioTipoDocumento = cmbLaboratorioTipoDocumento.getValidValue(A167LaboratorioTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A167LaboratorioTipoDocumento", A167LaboratorioTipoDocumento);
      }
      cmbLaboratorioEstado.setName( "LABORATORIOESTADO" );
      cmbLaboratorioEstado.setWebtags( "" );
      cmbLaboratorioEstado.addItem("A", "Activo", (short)(0));
      cmbLaboratorioEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbLaboratorioEstado.getItemCount() > 0 )
      {
         A171LaboratorioEstado = cmbLaboratorioEstado.getValidValue(A171LaboratorioEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A171LaboratorioEstado", A171LaboratorioEstado);
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

   public void valid_Secuserid( )
   {
      /* Using cursor T000P22 */
      pr_default.execute(20, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
      }
      A14SecUserName = T000P22_A14SecUserName[0] ;
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A14SecUserName", A14SecUserName);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV21LaboratorioId',fld:'vLABORATORIOID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV21LaboratorioId',fld:'vLABORATORIOID',pic:'ZZZ9',hsh:true},{av:'A40LaboratorioId',fld:'LABORATORIOID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120P2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_LABORATORIOID","{handler:'valid_Laboratorioid',iparms:[]");
      setEventMetadata("VALID_LABORATORIOID",",oparms:[]}");
      setEventMetadata("VALID_LABORATORIOTIPODOCUMENTO","{handler:'valid_Laboratoriotipodocumento',iparms:[]");
      setEventMetadata("VALID_LABORATORIOTIPODOCUMENTO",",oparms:[]}");
      setEventMetadata("VALID_LABORATORIOESTADO","{handler:'valid_Laboratorioestado',iparms:[]");
      setEventMetadata("VALID_LABORATORIOESTADO",",oparms:[]}");
      setEventMetadata("VALID_SECUSERID","{handler:'valid_Secuserid',iparms:[{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'A14SecUserName',fld:'SECUSERNAME',pic:''}]");
      setEventMetadata("VALID_SECUSERID",",oparms:[{av:'A14SecUserName',fld:'SECUSERNAME',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Secusername',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z165LaboratorioNombre = "" ;
      Z166LaboratorioDescripcion = "" ;
      Z167LaboratorioTipoDocumento = "" ;
      Z168LaboratorioNroDocumento = "" ;
      Z171LaboratorioEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A167LaboratorioTipoDocumento = "" ;
      A171LaboratorioEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A165LaboratorioNombre = "" ;
      A168LaboratorioNroDocumento = "" ;
      A169LaboratorioPhoto = "" ;
      A40000LaboratorioPhoto_GXI = "" ;
      sImgUrl = "" ;
      A166LaboratorioDescripcion = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_secuserid = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16SecUserId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      Gridlevel_laboratoriousuariosContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_laboratoriousuariosColumn = new com.genexus.webpanels.GXWebColumn();
      A14SecUserName = "" ;
      sMode34 = "" ;
      sStyleString = "" ;
      AV22Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Combo_secuserid_Objectcall = "" ;
      Combo_secuserid_Class = "" ;
      Combo_secuserid_Icontype = "" ;
      Combo_secuserid_Icon = "" ;
      Combo_secuserid_Tooltip = "" ;
      Combo_secuserid_Selectedvalue_set = "" ;
      Combo_secuserid_Selectedvalue_get = "" ;
      Combo_secuserid_Selectedtext_set = "" ;
      Combo_secuserid_Selectedtext_get = "" ;
      Combo_secuserid_Gamoauthtoken = "" ;
      Combo_secuserid_Ddointernalname = "" ;
      Combo_secuserid_Titlecontrolalign = "" ;
      Combo_secuserid_Dropdownoptionstype = "" ;
      Combo_secuserid_Datalisttype = "" ;
      Combo_secuserid_Datalistfixedvalues = "" ;
      Combo_secuserid_Htmltemplate = "" ;
      Combo_secuserid_Multiplevaluestype = "" ;
      Combo_secuserid_Loadingdata = "" ;
      Combo_secuserid_Noresultsfound = "" ;
      Combo_secuserid_Emptyitemtext = "" ;
      Combo_secuserid_Onlyselectedvalues = "" ;
      Combo_secuserid_Selectalltext = "" ;
      Combo_secuserid_Multiplevaluesseparator = "" ;
      Combo_secuserid_Addnewoptiontext = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode33 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      Z169LaboratorioPhoto = "" ;
      Z40000LaboratorioPhoto_GXI = "" ;
      T000P7_A40LaboratorioId = new short[1] ;
      T000P7_A165LaboratorioNombre = new String[] {""} ;
      T000P7_A166LaboratorioDescripcion = new String[] {""} ;
      T000P7_A167LaboratorioTipoDocumento = new String[] {""} ;
      T000P7_A168LaboratorioNroDocumento = new String[] {""} ;
      T000P7_A169LaboratorioPhoto = new String[] {""} ;
      T000P7_A40000LaboratorioPhoto_GXI = new String[] {""} ;
      T000P7_A170LaboratorioComision = new short[1] ;
      T000P7_A171LaboratorioEstado = new String[] {""} ;
      T000P8_A40LaboratorioId = new short[1] ;
      T000P6_A40LaboratorioId = new short[1] ;
      T000P6_A165LaboratorioNombre = new String[] {""} ;
      T000P6_A166LaboratorioDescripcion = new String[] {""} ;
      T000P6_A167LaboratorioTipoDocumento = new String[] {""} ;
      T000P6_A168LaboratorioNroDocumento = new String[] {""} ;
      T000P6_A169LaboratorioPhoto = new String[] {""} ;
      T000P6_A40000LaboratorioPhoto_GXI = new String[] {""} ;
      T000P6_A170LaboratorioComision = new short[1] ;
      T000P6_A171LaboratorioEstado = new String[] {""} ;
      T000P9_A40LaboratorioId = new short[1] ;
      T000P10_A40LaboratorioId = new short[1] ;
      T000P5_A40LaboratorioId = new short[1] ;
      T000P5_A165LaboratorioNombre = new String[] {""} ;
      T000P5_A166LaboratorioDescripcion = new String[] {""} ;
      T000P5_A167LaboratorioTipoDocumento = new String[] {""} ;
      T000P5_A168LaboratorioNroDocumento = new String[] {""} ;
      T000P5_A169LaboratorioPhoto = new String[] {""} ;
      T000P5_A40000LaboratorioPhoto_GXI = new String[] {""} ;
      T000P5_A170LaboratorioComision = new short[1] ;
      T000P5_A171LaboratorioEstado = new String[] {""} ;
      T000P11_A40LaboratorioId = new short[1] ;
      T000P15_A52ServicioCategId = new short[1] ;
      T000P16_A40LaboratorioId = new short[1] ;
      Z14SecUserName = "" ;
      T000P17_A40LaboratorioId = new short[1] ;
      T000P17_A14SecUserName = new String[] {""} ;
      T000P17_A6SecUserId = new short[1] ;
      T000P4_A14SecUserName = new String[] {""} ;
      T000P18_A14SecUserName = new String[] {""} ;
      T000P19_A40LaboratorioId = new short[1] ;
      T000P19_A6SecUserId = new short[1] ;
      T000P3_A40LaboratorioId = new short[1] ;
      T000P3_A6SecUserId = new short[1] ;
      T000P2_A40LaboratorioId = new short[1] ;
      T000P2_A6SecUserId = new short[1] ;
      T000P22_A14SecUserName = new String[] {""} ;
      T000P23_A40LaboratorioId = new short[1] ;
      T000P23_A6SecUserId = new short[1] ;
      Gridlevel_laboratoriousuariosRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_laboratoriousuarios_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.laboratorio__default(),
         new Object[] {
             new Object[] {
            T000P2_A40LaboratorioId, T000P2_A6SecUserId
            }
            , new Object[] {
            T000P3_A40LaboratorioId, T000P3_A6SecUserId
            }
            , new Object[] {
            T000P4_A14SecUserName
            }
            , new Object[] {
            T000P5_A40LaboratorioId, T000P5_A165LaboratorioNombre, T000P5_A166LaboratorioDescripcion, T000P5_A167LaboratorioTipoDocumento, T000P5_A168LaboratorioNroDocumento, T000P5_A169LaboratorioPhoto, T000P5_A40000LaboratorioPhoto_GXI, T000P5_A170LaboratorioComision, T000P5_A171LaboratorioEstado
            }
            , new Object[] {
            T000P6_A40LaboratorioId, T000P6_A165LaboratorioNombre, T000P6_A166LaboratorioDescripcion, T000P6_A167LaboratorioTipoDocumento, T000P6_A168LaboratorioNroDocumento, T000P6_A169LaboratorioPhoto, T000P6_A40000LaboratorioPhoto_GXI, T000P6_A170LaboratorioComision, T000P6_A171LaboratorioEstado
            }
            , new Object[] {
            T000P7_A40LaboratorioId, T000P7_A165LaboratorioNombre, T000P7_A166LaboratorioDescripcion, T000P7_A167LaboratorioTipoDocumento, T000P7_A168LaboratorioNroDocumento, T000P7_A169LaboratorioPhoto, T000P7_A40000LaboratorioPhoto_GXI, T000P7_A170LaboratorioComision, T000P7_A171LaboratorioEstado
            }
            , new Object[] {
            T000P8_A40LaboratorioId
            }
            , new Object[] {
            T000P9_A40LaboratorioId
            }
            , new Object[] {
            T000P10_A40LaboratorioId
            }
            , new Object[] {
            T000P11_A40LaboratorioId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000P15_A52ServicioCategId
            }
            , new Object[] {
            T000P16_A40LaboratorioId
            }
            , new Object[] {
            T000P17_A40LaboratorioId, T000P17_A14SecUserName, T000P17_A6SecUserId
            }
            , new Object[] {
            T000P18_A14SecUserName
            }
            , new Object[] {
            T000P19_A40LaboratorioId, T000P19_A6SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000P22_A14SecUserName
            }
            , new Object[] {
            T000P23_A40LaboratorioId, T000P23_A6SecUserId
            }
         }
      );
      AV22Pgmname = "Laboratorio" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte subGridlevel_laboratoriousuarios_Backcolorstyle ;
   private byte subGridlevel_laboratoriousuarios_Allowselection ;
   private byte subGridlevel_laboratoriousuarios_Allowhovering ;
   private byte subGridlevel_laboratoriousuarios_Allowcollapsing ;
   private byte subGridlevel_laboratoriousuarios_Collapsed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_laboratoriousuarios_Backstyle ;
   private byte gxajaxcallmode ;
   private short wcpOAV21LaboratorioId ;
   private short Z40LaboratorioId ;
   private short Z170LaboratorioComision ;
   private short Z6SecUserId ;
   private short nRcdDeleted_34 ;
   private short nRcdExists_34 ;
   private short nIsMod_34 ;
   private short A6SecUserId ;
   private short AV21LaboratorioId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A40LaboratorioId ;
   private short A170LaboratorioComision ;
   private short nBlankRcdCount34 ;
   private short RcdFound34 ;
   private short nBlankRcdUsr34 ;
   private short RcdFound33 ;
   private short nIsDirty_33 ;
   private short nIsDirty_34 ;
   private int nRC_GXsfl_59 ;
   private int nGXsfl_59_idx=1 ;
   private int trnEnded ;
   private int edtLaboratorioId_Enabled ;
   private int edtLaboratorioNombre_Enabled ;
   private int edtLaboratorioNroDocumento_Enabled ;
   private int imgLaboratorioPhoto_Enabled ;
   private int edtLaboratorioDescripcion_Enabled ;
   private int edtLaboratorioComision_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtSecUserId_Enabled ;
   private int edtSecUserName_Enabled ;
   private int subGridlevel_laboratoriousuarios_Selectedindex ;
   private int subGridlevel_laboratoriousuarios_Selectioncolor ;
   private int subGridlevel_laboratoriousuarios_Hoveringcolor ;
   private int fRowAdded ;
   private int Combo_secuserid_Datalistupdateminimumcharacters ;
   private int GX_JID ;
   private int subGridlevel_laboratoriousuarios_Backcolor ;
   private int subGridlevel_laboratoriousuarios_Allbackcolor ;
   private int defedtSecUserId_Enabled ;
   private int idxLst ;
   private long GRIDLEVEL_LABORATORIOUSUARIOS_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z167LaboratorioTipoDocumento ;
   private String Z171LaboratorioEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_59_idx="0001" ;
   private String edtSecUserId_Horizontalalignment ;
   private String edtSecUserId_Internalname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtLaboratorioNombre_Internalname ;
   private String A167LaboratorioTipoDocumento ;
   private String A171LaboratorioEstado ;
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
   private String edtLaboratorioId_Internalname ;
   private String edtLaboratorioId_Jsonclick ;
   private String TempTags ;
   private String edtLaboratorioNombre_Jsonclick ;
   private String edtLaboratorioNroDocumento_Internalname ;
   private String edtLaboratorioNroDocumento_Jsonclick ;
   private String imgLaboratorioPhoto_Internalname ;
   private String sImgUrl ;
   private String edtLaboratorioDescripcion_Internalname ;
   private String edtLaboratorioComision_Internalname ;
   private String edtLaboratorioComision_Jsonclick ;
   private String divTableleaflevel_laboratoriousuarios_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_secuserid_Caption ;
   private String Combo_secuserid_Cls ;
   private String Combo_secuserid_Datalistproc ;
   private String Combo_secuserid_Datalistprocparametersprefix ;
   private String Combo_secuserid_Internalname ;
   private String subGridlevel_laboratoriousuarios_Header ;
   private String sMode34 ;
   private String edtSecUserName_Internalname ;
   private String sStyleString ;
   private String AV22Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Combo_secuserid_Objectcall ;
   private String Combo_secuserid_Class ;
   private String Combo_secuserid_Icontype ;
   private String Combo_secuserid_Icon ;
   private String Combo_secuserid_Tooltip ;
   private String Combo_secuserid_Selectedvalue_set ;
   private String Combo_secuserid_Selectedvalue_get ;
   private String Combo_secuserid_Selectedtext_set ;
   private String Combo_secuserid_Selectedtext_get ;
   private String Combo_secuserid_Gamoauthtoken ;
   private String Combo_secuserid_Ddointernalname ;
   private String Combo_secuserid_Titlecontrolalign ;
   private String Combo_secuserid_Dropdownoptionstype ;
   private String Combo_secuserid_Titlecontrolidtoreplace ;
   private String Combo_secuserid_Datalisttype ;
   private String Combo_secuserid_Datalistfixedvalues ;
   private String Combo_secuserid_Htmltemplate ;
   private String Combo_secuserid_Multiplevaluestype ;
   private String Combo_secuserid_Loadingdata ;
   private String Combo_secuserid_Noresultsfound ;
   private String Combo_secuserid_Emptyitemtext ;
   private String Combo_secuserid_Onlyselectedvalues ;
   private String Combo_secuserid_Selectalltext ;
   private String Combo_secuserid_Multiplevaluesseparator ;
   private String Combo_secuserid_Addnewoptiontext ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String hsh ;
   private String sMode33 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_59_fel_idx="0001" ;
   private String subGridlevel_laboratoriousuarios_Class ;
   private String subGridlevel_laboratoriousuarios_Linesclass ;
   private String ROClassString ;
   private String edtSecUserId_Jsonclick ;
   private String edtSecUserName_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private String subGridlevel_laboratoriousuarios_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_59_Refreshing=false ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A169LaboratorioPhoto_IsBlob ;
   private boolean Combo_secuserid_Isgriditem ;
   private boolean Combo_secuserid_Hasdescription ;
   private boolean Combo_secuserid_Emptyitem ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Combo_secuserid_Enabled ;
   private boolean Combo_secuserid_Visible ;
   private boolean Combo_secuserid_Allowmultipleselection ;
   private boolean Combo_secuserid_Includeonlyselectedoption ;
   private boolean Combo_secuserid_Includeselectalloption ;
   private boolean Combo_secuserid_Includeaddnewoption ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean Gx_longc ;
   private String Z165LaboratorioNombre ;
   private String Z166LaboratorioDescripcion ;
   private String Z168LaboratorioNroDocumento ;
   private String A165LaboratorioNombre ;
   private String A168LaboratorioNroDocumento ;
   private String A40000LaboratorioPhoto_GXI ;
   private String A166LaboratorioDescripcion ;
   private String A14SecUserName ;
   private String Z40000LaboratorioPhoto_GXI ;
   private String Z14SecUserName ;
   private String A169LaboratorioPhoto ;
   private String Z169LaboratorioPhoto ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_laboratoriousuariosContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_laboratoriousuariosRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_laboratoriousuariosColumn ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_secuserid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbLaboratorioTipoDocumento ;
   private HTMLChoice cmbLaboratorioEstado ;
   private IDataStoreProvider pr_default ;
   private short[] T000P7_A40LaboratorioId ;
   private String[] T000P7_A165LaboratorioNombre ;
   private String[] T000P7_A166LaboratorioDescripcion ;
   private String[] T000P7_A167LaboratorioTipoDocumento ;
   private String[] T000P7_A168LaboratorioNroDocumento ;
   private String[] T000P7_A169LaboratorioPhoto ;
   private String[] T000P7_A40000LaboratorioPhoto_GXI ;
   private short[] T000P7_A170LaboratorioComision ;
   private String[] T000P7_A171LaboratorioEstado ;
   private short[] T000P8_A40LaboratorioId ;
   private short[] T000P6_A40LaboratorioId ;
   private String[] T000P6_A165LaboratorioNombre ;
   private String[] T000P6_A166LaboratorioDescripcion ;
   private String[] T000P6_A167LaboratorioTipoDocumento ;
   private String[] T000P6_A168LaboratorioNroDocumento ;
   private String[] T000P6_A169LaboratorioPhoto ;
   private String[] T000P6_A40000LaboratorioPhoto_GXI ;
   private short[] T000P6_A170LaboratorioComision ;
   private String[] T000P6_A171LaboratorioEstado ;
   private short[] T000P9_A40LaboratorioId ;
   private short[] T000P10_A40LaboratorioId ;
   private short[] T000P5_A40LaboratorioId ;
   private String[] T000P5_A165LaboratorioNombre ;
   private String[] T000P5_A166LaboratorioDescripcion ;
   private String[] T000P5_A167LaboratorioTipoDocumento ;
   private String[] T000P5_A168LaboratorioNroDocumento ;
   private String[] T000P5_A169LaboratorioPhoto ;
   private String[] T000P5_A40000LaboratorioPhoto_GXI ;
   private short[] T000P5_A170LaboratorioComision ;
   private String[] T000P5_A171LaboratorioEstado ;
   private short[] T000P11_A40LaboratorioId ;
   private short[] T000P15_A52ServicioCategId ;
   private short[] T000P16_A40LaboratorioId ;
   private short[] T000P17_A40LaboratorioId ;
   private String[] T000P17_A14SecUserName ;
   private short[] T000P17_A6SecUserId ;
   private String[] T000P4_A14SecUserName ;
   private String[] T000P18_A14SecUserName ;
   private short[] T000P19_A40LaboratorioId ;
   private short[] T000P19_A6SecUserId ;
   private short[] T000P3_A40LaboratorioId ;
   private short[] T000P3_A6SecUserId ;
   private short[] T000P2_A40LaboratorioId ;
   private short[] T000P2_A6SecUserId ;
   private String[] T000P22_A14SecUserName ;
   private short[] T000P23_A40LaboratorioId ;
   private short[] T000P23_A6SecUserId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16SecUserId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[] ;
}

final  class laboratorio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000P2", "SELECT [LaboratorioId], [SecUserId] FROM [LaboratorioLaboratorioUsuarios] WITH (UPDLOCK) WHERE [LaboratorioId] = ? AND [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P3", "SELECT [LaboratorioId], [SecUserId] FROM [LaboratorioLaboratorioUsuarios] WHERE [LaboratorioId] = ? AND [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P4", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P5", "SELECT [LaboratorioId], [LaboratorioNombre], [LaboratorioDescripcion], [LaboratorioTipoDocumento], [LaboratorioNroDocumento], [LaboratorioPhoto], [LaboratorioPhoto_GXI], [LaboratorioComision], [LaboratorioEstado] FROM [Laboratorio] WITH (UPDLOCK) WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P6", "SELECT [LaboratorioId], [LaboratorioNombre], [LaboratorioDescripcion], [LaboratorioTipoDocumento], [LaboratorioNroDocumento], [LaboratorioPhoto], [LaboratorioPhoto_GXI], [LaboratorioComision], [LaboratorioEstado] FROM [Laboratorio] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P7", "SELECT TM1.[LaboratorioId], TM1.[LaboratorioNombre], TM1.[LaboratorioDescripcion], TM1.[LaboratorioTipoDocumento], TM1.[LaboratorioNroDocumento], TM1.[LaboratorioPhoto], TM1.[LaboratorioPhoto_GXI], TM1.[LaboratorioComision], TM1.[LaboratorioEstado] FROM [Laboratorio] TM1 WHERE TM1.[LaboratorioId] = ? ORDER BY TM1.[LaboratorioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P8", "SELECT [LaboratorioId] FROM [Laboratorio] WHERE [LaboratorioId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P9", "SELECT TOP 1 [LaboratorioId] FROM [Laboratorio] WHERE ( [LaboratorioId] > ?) ORDER BY [LaboratorioId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000P10", "SELECT TOP 1 [LaboratorioId] FROM [Laboratorio] WHERE ( [LaboratorioId] < ?) ORDER BY [LaboratorioId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000P11", "INSERT INTO [Laboratorio]([LaboratorioNombre], [LaboratorioDescripcion], [LaboratorioTipoDocumento], [LaboratorioNroDocumento], [LaboratorioPhoto], [LaboratorioPhoto_GXI], [LaboratorioComision], [LaboratorioEstado]) VALUES(?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000P12", "UPDATE [Laboratorio] SET [LaboratorioNombre]=?, [LaboratorioDescripcion]=?, [LaboratorioTipoDocumento]=?, [LaboratorioNroDocumento]=?, [LaboratorioComision]=?, [LaboratorioEstado]=?  WHERE [LaboratorioId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000P13", "UPDATE [Laboratorio] SET [LaboratorioPhoto]=?, [LaboratorioPhoto_GXI]=?  WHERE [LaboratorioId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000P14", "DELETE FROM [Laboratorio]  WHERE [LaboratorioId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000P15", "SELECT TOP 1 [ServicioCategId] FROM [ServicioCateg] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000P16", "SELECT [LaboratorioId] FROM [Laboratorio] ORDER BY [LaboratorioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P17", "SELECT T1.[LaboratorioId], T2.[SecUserName], T1.[SecUserId] FROM ([LaboratorioLaboratorioUsuarios] T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) WHERE T1.[LaboratorioId] = ? and T1.[SecUserId] = ? ORDER BY T1.[LaboratorioId], T1.[SecUserId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P18", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P19", "SELECT [LaboratorioId], [SecUserId] FROM [LaboratorioLaboratorioUsuarios] WHERE [LaboratorioId] = ? AND [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000P20", "INSERT INTO [LaboratorioLaboratorioUsuarios]([LaboratorioId], [SecUserId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000P21", "DELETE FROM [LaboratorioLaboratorioUsuarios]  WHERE [LaboratorioId] = ? AND [SecUserId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000P22", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000P23", "SELECT [LaboratorioId], [SecUserId] FROM [LaboratorioLaboratorioUsuarios] WHERE [LaboratorioId] = ? ORDER BY [LaboratorioId], [SecUserId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getMultimediaFile(6, rslt.getVarchar(7));
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getMultimediaFile(6, rslt.getVarchar(7));
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getMultimediaFile(6, rslt.getVarchar(7));
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
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
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 500, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 20, false);
               stmt.setBLOBFile(5, (String)parms[4], true);
               stmt.setGXDbFileURI(6, (String)parms[5], (String)parms[4], 2048,"Laboratorio","LaboratorioPhoto");
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 1);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 500, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 20, false);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 11 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Laboratorio","LaboratorioPhoto");
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

