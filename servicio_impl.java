package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class servicio_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"LABORATORIOID") == 0 )
      {
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         A40LaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "LaboratorioId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx8asalaboratorioid1046( Gx_BScreen, A40LaboratorioId, Gx_mode) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A52ServicioCategId = (short)(GXutil.lval( httpContext.GetPar( "ServicioCategId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A52ServicioCategId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A40LaboratorioId = (short)(GXutil.lval( httpContext.GetPar( "LaboratorioId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A40LaboratorioId) ;
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
            AV23ServicioId = (short)(GXutil.lval( httpContext.GetPar( "ServicioId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ServicioId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSERVICIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23ServicioId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Servicio", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtServicioNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public servicio_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public servicio_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( servicio_impl.class ));
   }

   public servicio_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbServicioEstado = new HTMLChoice();
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
      if ( cmbServicioEstado.getItemCount() > 0 )
      {
         A286ServicioEstado = cmbServicioEstado.getValidValue(A286ServicioEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A286ServicioEstado", A286ServicioEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbServicioEstado.setValue( GXutil.rtrim( A286ServicioEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbServicioEstado.getInternalname(), "Values", cmbServicioEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioId_Internalname, "Id", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioId_Internalname, GXutil.ltrim( localUtil.ntoc( A27ServicioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtServicioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioId_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtServicioId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioNombre_Internalname, "Nombre", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioNombre_Internalname, A281ServicioNombre, GXutil.rtrim( localUtil.format( A281ServicioNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioNombre_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtServicioNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioDescripcion_Internalname, "Descripcion", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioDescripcion_Internalname, A282ServicioDescripcion, GXutil.rtrim( localUtil.format( A282ServicioDescripcion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioDescripcion_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtServicioDescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioCosto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioCosto_Internalname, "Costo", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioCosto_Internalname, GXutil.ltrim( localUtil.ntoc( A283ServicioCosto, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtServicioCosto_Enabled!=0) ? localUtil.format( A283ServicioCosto, "ZZ9.99") : localUtil.format( A283ServicioCosto, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,35);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioCosto_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtServicioCosto_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedserviciocategid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockserviciocategid_Internalname, "Servicio Categ Id", "", "", lblTextblockserviciocategid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_serviciocategid.setProperty("Caption", Combo_serviciocategid_Caption);
      ucCombo_serviciocategid.setProperty("Cls", Combo_serviciocategid_Cls);
      ucCombo_serviciocategid.setProperty("DataListProc", Combo_serviciocategid_Datalistproc);
      ucCombo_serviciocategid.setProperty("DataListProcParametersPrefix", Combo_serviciocategid_Datalistprocparametersprefix);
      ucCombo_serviciocategid.setProperty("EmptyItem", Combo_serviciocategid_Emptyitem);
      ucCombo_serviciocategid.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_serviciocategid.setProperty("DropDownOptionsData", AV17ServicioCategId_Data);
      ucCombo_serviciocategid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_serviciocategid_Internalname, "COMBO_SERVICIOCATEGIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioCategId_Internalname, "Servicio Categ Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioCategId_Internalname, GXutil.ltrim( localUtil.ntoc( A52ServicioCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,46);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioCategId_Jsonclick, 0, "Attribute", "", "", "", "", edtServicioCategId_Visible, edtServicioCategId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioId_Internalname, "Laboratorio Id", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioId_Internalname, GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtLaboratorioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A40LaboratorioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioId_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtLaboratorioId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtLaboratorioNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtLaboratorioNombre_Internalname, "Laboratorio Nombre", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtLaboratorioNombre_Internalname, A165LaboratorioNombre, GXutil.rtrim( localUtil.format( A165LaboratorioNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtLaboratorioNombre_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtLaboratorioNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioComision_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioComision_Internalname, "Comision", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioComision_Internalname, GXutil.ltrim( localUtil.ntoc( A284ServicioComision, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtServicioComision_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A284ServicioComision), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A284ServicioComision), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioComision_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtServicioComision_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtServicioObservacion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtServicioObservacion_Internalname, "Observacion", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtServicioObservacion_Internalname, A285ServicioObservacion, GXutil.rtrim( localUtil.format( A285ServicioObservacion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtServicioObservacion_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtServicioObservacion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbServicioEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbServicioEstado.getInternalname(), "Estado", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbServicioEstado, cmbServicioEstado.getInternalname(), GXutil.rtrim( A286ServicioEstado), 1, cmbServicioEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbServicioEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute AttributeLabelSizeLarge", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "", true, (byte)(1), "HLP_Servicio.htm");
      cmbServicioEstado.setValue( GXutil.rtrim( A286ServicioEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbServicioEstado.getInternalname(), "Values", cmbServicioEstado.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 75,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Servicio.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Servicio.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_serviciocategid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboserviciocategid_Internalname, GXutil.ltrim( localUtil.ntoc( AV22ComboServicioCategId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavComboserviciocategid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV22ComboServicioCategId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV22ComboServicioCategId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboserviciocategid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboserviciocategid_Visible, edtavComboserviciocategid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Servicio.htm");
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
      e11102 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSERVICIOCATEGID_DATA"), AV17ServicioCategId_Data);
            /* Read saved values. */
            Z27ServicioId = (short)(localUtil.ctol( httpContext.cgiGet( "Z27ServicioId"), ",", ".")) ;
            Z281ServicioNombre = httpContext.cgiGet( "Z281ServicioNombre") ;
            Z282ServicioDescripcion = httpContext.cgiGet( "Z282ServicioDescripcion") ;
            Z283ServicioCosto = localUtil.ctond( httpContext.cgiGet( "Z283ServicioCosto")) ;
            Z284ServicioComision = (short)(localUtil.ctol( httpContext.cgiGet( "Z284ServicioComision"), ",", ".")) ;
            Z285ServicioObservacion = httpContext.cgiGet( "Z285ServicioObservacion") ;
            Z286ServicioEstado = httpContext.cgiGet( "Z286ServicioEstado") ;
            Z52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "Z52ServicioCategId"), ",", ".")) ;
            Z40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( "Z40LaboratorioId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "N52ServicioCategId"), ",", ".")) ;
            AV23ServicioId = (short)(localUtil.ctol( httpContext.cgiGet( "vSERVICIOID"), ",", ".")) ;
            AV8Insert_ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SERVICIOCATEGID"), ",", ".")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            AV25Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_serviciocategid_Objectcall = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Objectcall") ;
            Combo_serviciocategid_Class = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Class") ;
            Combo_serviciocategid_Icontype = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Icontype") ;
            Combo_serviciocategid_Icon = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Icon") ;
            Combo_serviciocategid_Caption = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Caption") ;
            Combo_serviciocategid_Tooltip = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Tooltip") ;
            Combo_serviciocategid_Cls = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Cls") ;
            Combo_serviciocategid_Selectedvalue_set = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Selectedvalue_set") ;
            Combo_serviciocategid_Selectedvalue_get = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Selectedvalue_get") ;
            Combo_serviciocategid_Selectedtext_set = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Selectedtext_set") ;
            Combo_serviciocategid_Selectedtext_get = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Selectedtext_get") ;
            Combo_serviciocategid_Gamoauthtoken = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Gamoauthtoken") ;
            Combo_serviciocategid_Ddointernalname = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Ddointernalname") ;
            Combo_serviciocategid_Titlecontrolalign = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Titlecontrolalign") ;
            Combo_serviciocategid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Dropdownoptionstype") ;
            Combo_serviciocategid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Enabled")) ;
            Combo_serviciocategid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Visible")) ;
            Combo_serviciocategid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Titlecontrolidtoreplace") ;
            Combo_serviciocategid_Datalisttype = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Datalisttype") ;
            Combo_serviciocategid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Allowmultipleselection")) ;
            Combo_serviciocategid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Datalistfixedvalues") ;
            Combo_serviciocategid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Isgriditem")) ;
            Combo_serviciocategid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Hasdescription")) ;
            Combo_serviciocategid_Datalistproc = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Datalistproc") ;
            Combo_serviciocategid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Datalistprocparametersprefix") ;
            Combo_serviciocategid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_serviciocategid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Includeonlyselectedoption")) ;
            Combo_serviciocategid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Includeselectalloption")) ;
            Combo_serviciocategid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Emptyitem")) ;
            Combo_serviciocategid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Includeaddnewoption")) ;
            Combo_serviciocategid_Htmltemplate = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Htmltemplate") ;
            Combo_serviciocategid_Multiplevaluestype = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Multiplevaluestype") ;
            Combo_serviciocategid_Loadingdata = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Loadingdata") ;
            Combo_serviciocategid_Noresultsfound = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Noresultsfound") ;
            Combo_serviciocategid_Emptyitemtext = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Emptyitemtext") ;
            Combo_serviciocategid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Onlyselectedvalues") ;
            Combo_serviciocategid_Selectalltext = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Selectalltext") ;
            Combo_serviciocategid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Multiplevaluesseparator") ;
            Combo_serviciocategid_Addnewoptiontext = httpContext.cgiGet( "COMBO_SERVICIOCATEGID_Addnewoptiontext") ;
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
            A27ServicioId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
            A281ServicioNombre = httpContext.cgiGet( edtServicioNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A281ServicioNombre", A281ServicioNombre);
            A282ServicioDescripcion = httpContext.cgiGet( edtServicioDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A282ServicioDescripcion", A282ServicioDescripcion);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtServicioCosto_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtServicioCosto_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SERVICIOCOSTO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtServicioCosto_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A283ServicioCosto = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A283ServicioCosto", GXutil.ltrimstr( A283ServicioCosto, 6, 2));
            }
            else
            {
               A283ServicioCosto = localUtil.ctond( httpContext.cgiGet( edtServicioCosto_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A283ServicioCosto", GXutil.ltrimstr( A283ServicioCosto, 6, 2));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtServicioCategId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtServicioCategId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SERVICIOCATEGID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtServicioCategId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A52ServicioCategId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
            }
            else
            {
               A52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioCategId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
            }
            A40LaboratorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtLaboratorioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
            A165LaboratorioNombre = httpContext.cgiGet( edtLaboratorioNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtServicioComision_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtServicioComision_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SERVICIOCOMISION");
               AnyError = (short)(1) ;
               GX_FocusControl = edtServicioComision_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A284ServicioComision = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A284ServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A284ServicioComision), 4, 0));
            }
            else
            {
               A284ServicioComision = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioComision_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A284ServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A284ServicioComision), 4, 0));
            }
            A285ServicioObservacion = httpContext.cgiGet( edtServicioObservacion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A285ServicioObservacion", A285ServicioObservacion);
            cmbServicioEstado.setValue( httpContext.cgiGet( cmbServicioEstado.getInternalname()) );
            A286ServicioEstado = httpContext.cgiGet( cmbServicioEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A286ServicioEstado", A286ServicioEstado);
            AV22ComboServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboserviciocategid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22ComboServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboServicioCategId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Servicio");
            A27ServicioId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
            forbiddenHiddens.add("ServicioId", localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A27ServicioId != Z27ServicioId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("servicio:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            forbiddenHiddens2 = new com.genexus.util.GXProperties() ;
            if ( isUpd( )  )
            {
               A52ServicioCategId = (short)(localUtil.ctol( httpContext.cgiGet( edtServicioCategId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
               forbiddenHiddens2.add("ServicioCategId", localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9"));
            }
            hsh2 = httpContext.cgiGet( "hsh2") ;
            if ( ( ! ( ( A27ServicioId != Z27ServicioId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens2.toString(), hsh2, GXKey) )
            {
               GXutil.writeLogError("servicio:[ CondSecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens2.toJSonString());
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
               A27ServicioId = (short)(GXutil.lval( httpContext.GetPar( "ServicioId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
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
                  sMode46 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode46 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound46 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_100( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "SERVICIOID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtServicioId_Internalname ;
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
                        e11102 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12102 ();
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
         e12102 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1046( ) ;
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
         disableAttributes1046( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboserviciocategid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboserviciocategid_Enabled), 5, 0), true);
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

   public void confirm_100( )
   {
      beforeValidate1046( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1046( ) ;
         }
         else
         {
            checkExtendedTable1046( ) ;
            closeExtendedTableCursors1046( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption100( )
   {
   }

   public void e11102( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV16LabId ;
      GXv_int2[0] = GXt_int1 ;
      new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int2) ;
      servicio_impl.this.GXt_int1 = GXv_int2[0] ;
      AV16LabId = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16LabId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16LabId), 4, 0));
      GXv_SdtWWPContext3[0] = AV15WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV15WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] ;
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      edtServicioCategId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Visible), 5, 0), true);
      AV22ComboServicioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboServicioCategId), 4, 0));
      edtavComboserviciocategid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboserviciocategid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboserviciocategid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOSERVICIOCATEGID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV9IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio_Insert", GXv_boolean7) ;
         servicio_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV9IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV9IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio_Update", GXv_boolean7) ;
         servicio_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV9IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV9IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWServicio_Delete", GXv_boolean7) ;
         servicio_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV9IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9IsAuthorized", AV9IsAuthorized);
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV25Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV25Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV26GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         while ( AV26GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV26GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ServicioCategId") == 0 )
            {
               AV8Insert_ServicioCategId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV8Insert_ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8Insert_ServicioCategId), 4, 0));
               if ( ! (0==AV8Insert_ServicioCategId) )
               {
                  AV22ComboServicioCategId = AV8Insert_ServicioCategId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV22ComboServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboServicioCategId), 4, 0));
                  Combo_serviciocategid_Selectedvalue_set = GXutil.trim( GXutil.str( AV22ComboServicioCategId, 4, 0)) ;
                  ucCombo_serviciocategid.sendProperty(context, "", false, Combo_serviciocategid_Internalname, "SelectedValue_set", Combo_serviciocategid_Selectedvalue_set);
                  GXt_char8 = AV21Combo_DataJson ;
                  GXv_char9[0] = AV19ComboSelectedValue ;
                  GXv_char10[0] = AV20ComboSelectedText ;
                  GXv_char11[0] = GXt_char8 ;
                  new com.projectthani.servicioloaddvcombo(remoteHandle, context).execute( "ServicioCategId", "GET", false, AV23ServicioId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char10, GXv_char11) ;
                  servicio_impl.this.AV19ComboSelectedValue = GXv_char9[0] ;
                  servicio_impl.this.AV20ComboSelectedText = GXv_char10[0] ;
                  servicio_impl.this.GXt_char8 = GXv_char11[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
                  AV21Combo_DataJson = GXt_char8 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
                  Combo_serviciocategid_Selectedtext_set = AV20ComboSelectedText ;
                  ucCombo_serviciocategid.sendProperty(context, "", false, Combo_serviciocategid_Internalname, "SelectedText_set", Combo_serviciocategid_Selectedtext_set);
                  Combo_serviciocategid_Enabled = false ;
                  ucCombo_serviciocategid.sendProperty(context, "", false, Combo_serviciocategid_Internalname, "Enabled", GXutil.booltostr( Combo_serviciocategid_Enabled));
               }
            }
            AV26GXV1 = (int)(AV26GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GXV1), 8, 0));
         }
      }
   }

   public void e12102( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV12TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.servicioww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOSERVICIOCATEGID' Routine */
      returnInSub = false ;
      GXt_char8 = AV21Combo_DataJson ;
      GXv_char11[0] = AV19ComboSelectedValue ;
      GXv_char10[0] = AV20ComboSelectedText ;
      GXv_char9[0] = GXt_char8 ;
      new com.projectthani.servicioloaddvcombo(remoteHandle, context).execute( "ServicioCategId", Gx_mode, false, AV23ServicioId, "", GXv_char11, GXv_char10, GXv_char9) ;
      servicio_impl.this.AV19ComboSelectedValue = GXv_char11[0] ;
      servicio_impl.this.AV20ComboSelectedText = GXv_char10[0] ;
      servicio_impl.this.GXt_char8 = GXv_char9[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedValue", AV19ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV20ComboSelectedText", AV20ComboSelectedText);
      AV21Combo_DataJson = GXt_char8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Combo_DataJson", AV21Combo_DataJson);
      Combo_serviciocategid_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_serviciocategid.sendProperty(context, "", false, Combo_serviciocategid_Internalname, "SelectedValue_set", Combo_serviciocategid_Selectedvalue_set);
      Combo_serviciocategid_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_serviciocategid.sendProperty(context, "", false, Combo_serviciocategid_Internalname, "SelectedText_set", Combo_serviciocategid_Selectedtext_set);
      AV22ComboServicioCategId = (short)(GXutil.lval( AV19ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22ComboServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22ComboServicioCategId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_serviciocategid_Enabled = false ;
         ucCombo_serviciocategid.sendProperty(context, "", false, Combo_serviciocategid_Internalname, "Enabled", GXutil.booltostr( Combo_serviciocategid_Enabled));
      }
   }

   public void zm1046( int GX_JID )
   {
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z281ServicioNombre = T00103_A281ServicioNombre[0] ;
            Z282ServicioDescripcion = T00103_A282ServicioDescripcion[0] ;
            Z283ServicioCosto = T00103_A283ServicioCosto[0] ;
            Z284ServicioComision = T00103_A284ServicioComision[0] ;
            Z285ServicioObservacion = T00103_A285ServicioObservacion[0] ;
            Z286ServicioEstado = T00103_A286ServicioEstado[0] ;
            Z52ServicioCategId = T00103_A52ServicioCategId[0] ;
         }
         else
         {
            Z281ServicioNombre = A281ServicioNombre ;
            Z282ServicioDescripcion = A282ServicioDescripcion ;
            Z283ServicioCosto = A283ServicioCosto ;
            Z284ServicioComision = A284ServicioComision ;
            Z285ServicioObservacion = A285ServicioObservacion ;
            Z286ServicioEstado = A286ServicioEstado ;
            Z52ServicioCategId = A52ServicioCategId ;
         }
      }
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z40LaboratorioId = T00105_A40LaboratorioId[0] ;
      }
      if ( GX_JID == -11 )
      {
         Z27ServicioId = A27ServicioId ;
         Z281ServicioNombre = A281ServicioNombre ;
         Z282ServicioDescripcion = A282ServicioDescripcion ;
         Z283ServicioCosto = A283ServicioCosto ;
         Z284ServicioComision = A284ServicioComision ;
         Z285ServicioObservacion = A285ServicioObservacion ;
         Z286ServicioEstado = A286ServicioEstado ;
         Z52ServicioCategId = A52ServicioCategId ;
         Z40LaboratorioId = A40LaboratorioId ;
         Z165LaboratorioNombre = A165LaboratorioNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      edtServicioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioId_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtServicioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV23ServicioId) )
      {
         A27ServicioId = AV23ServicioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV8Insert_ServicioCategId) )
      {
         edtServicioCategId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Enabled), 5, 0), true);
      }
      else
      {
         edtServicioCategId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( isUpd( )  )
      {
         edtServicioCategId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV8Insert_ServicioCategId) )
      {
         A52ServicioCategId = AV8Insert_ServicioCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
      }
      else
      {
         A52ServicioCategId = AV22ComboServicioCategId ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
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
         AV25Pgmname = "Servicio" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T00105 */
         pr_default.execute(3, new Object[] {Short.valueOf(A52ServicioCategId)});
         zm1046( 12) ;
         A40LaboratorioId = T00105_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         pr_default.close(3);
      }
   }

   public void load1046( )
   {
      /* Using cursor T00107 */
      pr_default.execute(5, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A281ServicioNombre = T00107_A281ServicioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A281ServicioNombre", A281ServicioNombre);
         A282ServicioDescripcion = T00107_A282ServicioDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A282ServicioDescripcion", A282ServicioDescripcion);
         A283ServicioCosto = T00107_A283ServicioCosto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A283ServicioCosto", GXutil.ltrimstr( A283ServicioCosto, 6, 2));
         A165LaboratorioNombre = T00107_A165LaboratorioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
         A284ServicioComision = T00107_A284ServicioComision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A284ServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A284ServicioComision), 4, 0));
         A285ServicioObservacion = T00107_A285ServicioObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A285ServicioObservacion", A285ServicioObservacion);
         A286ServicioEstado = T00107_A286ServicioEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A286ServicioEstado", A286ServicioEstado);
         A52ServicioCategId = T00107_A52ServicioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
         A40LaboratorioId = T00107_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         zm1046( -11) ;
      }
      pr_default.close(5);
      onLoadActions1046( ) ;
   }

   public void onLoadActions1046( )
   {
      AV25Pgmname = "Servicio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      if ( isIns( )  && (0==A40LaboratorioId) && ( Gx_BScreen == 0 ) )
      {
         GXt_int1 = A40LaboratorioId ;
         GXv_int2[0] = GXt_int1 ;
         new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int2) ;
         servicio_impl.this.GXt_int1 = GXv_int2[0] ;
         A40LaboratorioId = GXt_int1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      }
   }

   public void checkExtendedTable1046( )
   {
      nIsDirty_46 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV25Pgmname = "Servicio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
      /* Using cursor T00105 */
      pr_default.execute(3, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Servicio Categ'.", "ForeignKeyNotFound", 1, "SERVICIOCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A40LaboratorioId = T00105_A40LaboratorioId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A286ServicioEstado, "A") == 0 ) || ( GXutil.strcmp(A286ServicioEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Servicio Estado fuera de rango", "OutOfRange", 1, "SERVICIOESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbServicioEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( isIns( )  && (0==A40LaboratorioId) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_46 = (short)(1) ;
         GXt_int1 = A40LaboratorioId ;
         GXv_int2[0] = GXt_int1 ;
         new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int2) ;
         servicio_impl.this.GXt_int1 = GXv_int2[0] ;
         A40LaboratorioId = GXt_int1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      }
      /* Using cursor T00106 */
      pr_default.execute(4, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Laboratorio'.", "ForeignKeyNotFound", 1, "LABORATORIOID");
         AnyError = (short)(1) ;
      }
      A165LaboratorioNombre = T00106_A165LaboratorioNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
      pr_default.close(4);
   }

   public void closeExtendedTableCursors1046( )
   {
      pr_default.close(2);
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_12( short A52ServicioCategId )
   {
      /* Using cursor T00105 */
      pr_default.execute(3, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Servicio Categ'.", "ForeignKeyNotFound", 1, "SERVICIOCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioCategId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A40LaboratorioId = T00105_A40LaboratorioId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(3) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(3);
   }

   public void gxload_13( short A40LaboratorioId )
   {
      /* Using cursor T00108 */
      pr_default.execute(6, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Laboratorio'.", "ForeignKeyNotFound", 1, "LABORATORIOID");
         AnyError = (short)(1) ;
      }
      A165LaboratorioNombre = T00108_A165LaboratorioNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A165LaboratorioNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey1046( )
   {
      /* Using cursor T00109 */
      pr_default.execute(7, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound46 = (short)(1) ;
      }
      else
      {
         RcdFound46 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00103 */
      pr_default.execute(1, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1046( 11) ;
         RcdFound46 = (short)(1) ;
         A27ServicioId = T00103_A27ServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
         A281ServicioNombre = T00103_A281ServicioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A281ServicioNombre", A281ServicioNombre);
         A282ServicioDescripcion = T00103_A282ServicioDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A282ServicioDescripcion", A282ServicioDescripcion);
         A283ServicioCosto = T00103_A283ServicioCosto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A283ServicioCosto", GXutil.ltrimstr( A283ServicioCosto, 6, 2));
         A284ServicioComision = T00103_A284ServicioComision[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A284ServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A284ServicioComision), 4, 0));
         A285ServicioObservacion = T00103_A285ServicioObservacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A285ServicioObservacion", A285ServicioObservacion);
         A286ServicioEstado = T00103_A286ServicioEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A286ServicioEstado", A286ServicioEstado);
         A52ServicioCategId = T00103_A52ServicioCategId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
         Z27ServicioId = A27ServicioId ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1046( ) ;
         if ( AnyError == 1 )
         {
            RcdFound46 = (short)(0) ;
            initializeNonKey1046( ) ;
         }
         Gx_mode = sMode46 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound46 = (short)(0) ;
         initializeNonKey1046( ) ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode46 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1046( ) ;
      if ( RcdFound46 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound46 = (short)(0) ;
      /* Using cursor T001010 */
      pr_default.execute(8, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001010_A27ServicioId[0] < A27ServicioId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001010_A27ServicioId[0] > A27ServicioId ) ) )
         {
            A27ServicioId = T001010_A27ServicioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
            RcdFound46 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound46 = (short)(0) ;
      /* Using cursor T001011 */
      pr_default.execute(9, new Object[] {Short.valueOf(A27ServicioId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001011_A27ServicioId[0] > A27ServicioId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001011_A27ServicioId[0] < A27ServicioId ) ) )
         {
            A27ServicioId = T001011_A27ServicioId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
            RcdFound46 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1046( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtServicioNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1046( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound46 == 1 )
         {
            if ( A27ServicioId != Z27ServicioId )
            {
               A27ServicioId = Z27ServicioId ;
               httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SERVICIOID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtServicioId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtServicioNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1046( ) ;
               GX_FocusControl = edtServicioNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A27ServicioId != Z27ServicioId )
            {
               /* Insert record */
               GX_FocusControl = edtServicioNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1046( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SERVICIOID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtServicioId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtServicioNombre_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1046( ) ;
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
      if ( A27ServicioId != Z27ServicioId )
      {
         A27ServicioId = Z27ServicioId ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SERVICIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtServicioNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1046( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00102 */
         pr_default.execute(0, new Object[] {Short.valueOf(A27ServicioId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Servicio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z281ServicioNombre, T00102_A281ServicioNombre[0]) != 0 ) || ( GXutil.strcmp(Z282ServicioDescripcion, T00102_A282ServicioDescripcion[0]) != 0 ) || ( DecimalUtil.compareTo(Z283ServicioCosto, T00102_A283ServicioCosto[0]) != 0 ) || ( Z284ServicioComision != T00102_A284ServicioComision[0] ) || ( GXutil.strcmp(Z285ServicioObservacion, T00102_A285ServicioObservacion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z286ServicioEstado, T00102_A286ServicioEstado[0]) != 0 ) || ( Z52ServicioCategId != T00102_A52ServicioCategId[0] ) )
         {
            if ( GXutil.strcmp(Z281ServicioNombre, T00102_A281ServicioNombre[0]) != 0 )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"ServicioNombre");
               GXutil.writeLogRaw("Old: ",Z281ServicioNombre);
               GXutil.writeLogRaw("Current: ",T00102_A281ServicioNombre[0]);
            }
            if ( GXutil.strcmp(Z282ServicioDescripcion, T00102_A282ServicioDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"ServicioDescripcion");
               GXutil.writeLogRaw("Old: ",Z282ServicioDescripcion);
               GXutil.writeLogRaw("Current: ",T00102_A282ServicioDescripcion[0]);
            }
            if ( DecimalUtil.compareTo(Z283ServicioCosto, T00102_A283ServicioCosto[0]) != 0 )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"ServicioCosto");
               GXutil.writeLogRaw("Old: ",Z283ServicioCosto);
               GXutil.writeLogRaw("Current: ",T00102_A283ServicioCosto[0]);
            }
            if ( Z284ServicioComision != T00102_A284ServicioComision[0] )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"ServicioComision");
               GXutil.writeLogRaw("Old: ",Z284ServicioComision);
               GXutil.writeLogRaw("Current: ",T00102_A284ServicioComision[0]);
            }
            if ( GXutil.strcmp(Z285ServicioObservacion, T00102_A285ServicioObservacion[0]) != 0 )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"ServicioObservacion");
               GXutil.writeLogRaw("Old: ",Z285ServicioObservacion);
               GXutil.writeLogRaw("Current: ",T00102_A285ServicioObservacion[0]);
            }
            if ( GXutil.strcmp(Z286ServicioEstado, T00102_A286ServicioEstado[0]) != 0 )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"ServicioEstado");
               GXutil.writeLogRaw("Old: ",Z286ServicioEstado);
               GXutil.writeLogRaw("Current: ",T00102_A286ServicioEstado[0]);
            }
            if ( Z52ServicioCategId != T00102_A52ServicioCategId[0] )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"ServicioCategId");
               GXutil.writeLogRaw("Old: ",Z52ServicioCategId);
               GXutil.writeLogRaw("Current: ",T00102_A52ServicioCategId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Servicio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
      /* Using cursor T001012 */
      pr_default.execute(10, new Object[] {Short.valueOf(A52ServicioCategId)});
      if ( (pr_default.getStatus(10) == 103) )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ServicioCateg"}), "RecordIsLocked", 1, "");
         AnyError = (short)(1) ;
         return  ;
      }
      if ( ! isIns( ) )
      {
         if ( false || ( Z40LaboratorioId != T001012_A40LaboratorioId[0] ) )
         {
            if ( Z40LaboratorioId != T001012_A40LaboratorioId[0] )
            {
               GXutil.writeLogln("servicio:[seudo value changed for attri]"+"LaboratorioId");
               GXutil.writeLogRaw("Old: ",Z40LaboratorioId);
               GXutil.writeLogRaw("Current: ",T001012_A40LaboratorioId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ServicioCateg"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1046( )
   {
      beforeValidate1046( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1046( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1046( 0) ;
         checkOptimisticConcurrency1046( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1046( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1046( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001013 */
                  pr_default.execute(11, new Object[] {A281ServicioNombre, A282ServicioDescripcion, A283ServicioCosto, Short.valueOf(A284ServicioComision), A285ServicioObservacion, A286ServicioEstado, Short.valueOf(A52ServicioCategId)});
                  A27ServicioId = T001013_A27ServicioId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Servicio");
                  if ( AnyError == 0 )
                  {
                     updateTablesN11046( ) ;
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption100( ) ;
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
            load1046( ) ;
         }
         endLevel1046( ) ;
      }
      closeExtendedTableCursors1046( ) ;
   }

   public void update1046( )
   {
      beforeValidate1046( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1046( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1046( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1046( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1046( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001014 */
                  pr_default.execute(12, new Object[] {A281ServicioNombre, A282ServicioDescripcion, A283ServicioCosto, Short.valueOf(A284ServicioComision), A285ServicioObservacion, A286ServicioEstado, Short.valueOf(A52ServicioCategId), Short.valueOf(A27ServicioId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Servicio");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Servicio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1046( ) ;
                  if ( AnyError == 0 )
                  {
                     updateTablesN11046( ) ;
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
         endLevel1046( ) ;
      }
      closeExtendedTableCursors1046( ) ;
   }

   public void deferredUpdate1046( )
   {
   }

   public void delete( )
   {
      beforeValidate1046( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1046( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1046( ) ;
         afterConfirm1046( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1046( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001015 */
               pr_default.execute(13, new Object[] {Short.valueOf(A27ServicioId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Servicio");
               if ( AnyError == 0 )
               {
                  updateTablesN11046( ) ;
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
      sMode46 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1046( ) ;
      Gx_mode = sMode46 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1046( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV25Pgmname = "Servicio" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25Pgmname", AV25Pgmname);
         /* Using cursor T001016 */
         pr_default.execute(14, new Object[] {Short.valueOf(A52ServicioCategId)});
         Z40LaboratorioId = T001016_A40LaboratorioId[0] ;
         A40LaboratorioId = T001016_A40LaboratorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         pr_default.close(14);
         if ( isIns( )  && (0==A40LaboratorioId) && ( Gx_BScreen == 0 ) )
         {
            GXt_int1 = A40LaboratorioId ;
            GXv_int2[0] = GXt_int1 ;
            new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int2) ;
            servicio_impl.this.GXt_int1 = GXv_int2[0] ;
            A40LaboratorioId = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
         }
         /* Using cursor T001017 */
         pr_default.execute(15, new Object[] {Short.valueOf(A40LaboratorioId)});
         A165LaboratorioNombre = T001017_A165LaboratorioNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
         pr_default.close(15);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001018 */
         pr_default.execute(16, new Object[] {Short.valueOf(A27ServicioId)});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita Servicio"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void updateTablesN11046( )
   {
      /* Using cursor T001019 */
      pr_default.execute(17, new Object[] {Short.valueOf(A40LaboratorioId), Short.valueOf(A52ServicioCategId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ServicioCateg");
   }

   public void endLevel1046( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      pr_default.close(10);
      if ( AnyError == 0 )
      {
         beforeComplete1046( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(14);
         pr_default.close(15);
         Application.commitDataStores(context, remoteHandle, pr_default, "servicio");
         if ( AnyError == 0 )
         {
            confirmValues100( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(14);
         pr_default.close(15);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "servicio");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1046( )
   {
      /* Scan By routine */
      /* Using cursor T001020 */
      pr_default.execute(18);
      RcdFound46 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A27ServicioId = T001020_A27ServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1046( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound46 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A27ServicioId = T001020_A27ServicioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
      }
   }

   public void scanEnd1046( )
   {
      pr_default.close(18);
   }

   public void afterConfirm1046( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1046( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1046( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1046( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1046( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1046( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1046( )
   {
      edtServicioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioId_Enabled), 5, 0), true);
      edtServicioNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioNombre_Enabled), 5, 0), true);
      edtServicioDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioDescripcion_Enabled), 5, 0), true);
      edtServicioCosto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCosto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCosto_Enabled), 5, 0), true);
      edtServicioCategId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioCategId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioCategId_Enabled), 5, 0), true);
      edtLaboratorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioId_Enabled), 5, 0), true);
      edtLaboratorioNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtLaboratorioNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtLaboratorioNombre_Enabled), 5, 0), true);
      edtServicioComision_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioComision_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioComision_Enabled), 5, 0), true);
      edtServicioObservacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServicioObservacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServicioObservacion_Enabled), 5, 0), true);
      cmbServicioEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbServicioEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbServicioEstado.getEnabled(), 5, 0), true);
      edtavComboserviciocategid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboserviciocategid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboserviciocategid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1046( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues100( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033560", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.servicio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV23ServicioId,4,0))}, new String[] {"Gx_mode","ServicioId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Servicio");
      forbiddenHiddens.add("ServicioId", localUtil.format( DecimalUtil.doubleToDec(A27ServicioId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("servicio:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
      forbiddenHiddens2 = new com.genexus.util.GXProperties() ;
      if ( isUpd( )  )
      {
         forbiddenHiddens2.add("ServicioCategId", localUtil.format( DecimalUtil.doubleToDec(A52ServicioCategId), "ZZZ9"));
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh2", httpContext.getEncryptedSignature( forbiddenHiddens2.toString(), GXKey));
      GXutil.writeLogInfo("servicio:[ SendCondSecurityCheck value for]"+forbiddenHiddens2.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z27ServicioId", GXutil.ltrim( localUtil.ntoc( Z27ServicioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z281ServicioNombre", Z281ServicioNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z282ServicioDescripcion", Z282ServicioDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z283ServicioCosto", GXutil.ltrim( localUtil.ntoc( Z283ServicioCosto, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z284ServicioComision", GXutil.ltrim( localUtil.ntoc( Z284ServicioComision, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z285ServicioObservacion", Z285ServicioObservacion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z286ServicioEstado", GXutil.rtrim( Z286ServicioEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z52ServicioCategId", GXutil.ltrim( localUtil.ntoc( Z52ServicioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z40LaboratorioId", GXutil.ltrim( localUtil.ntoc( Z40LaboratorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N52ServicioCategId", GXutil.ltrim( localUtil.ntoc( A52ServicioCategId, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSERVICIOCATEGID_DATA", AV17ServicioCategId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSERVICIOCATEGID_DATA", AV17ServicioCategId_Data);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV12TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV12TrnContext);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV12TrnContext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSERVICIOID", GXutil.ltrim( localUtil.ntoc( AV23ServicioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSERVICIOID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV23ServicioId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SERVICIOCATEGID", GXutil.ltrim( localUtil.ntoc( AV8Insert_ServicioCategId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV25Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Objectcall", GXutil.rtrim( Combo_serviciocategid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Cls", GXutil.rtrim( Combo_serviciocategid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Selectedvalue_set", GXutil.rtrim( Combo_serviciocategid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Selectedtext_set", GXutil.rtrim( Combo_serviciocategid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Enabled", GXutil.booltostr( Combo_serviciocategid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Datalistproc", GXutil.rtrim( Combo_serviciocategid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Datalistprocparametersprefix", GXutil.rtrim( Combo_serviciocategid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SERVICIOCATEGID_Emptyitem", GXutil.booltostr( Combo_serviciocategid_Emptyitem));
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
      return formatLink("com.projectthani.servicio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV23ServicioId,4,0))}, new String[] {"Gx_mode","ServicioId"})  ;
   }

   public String getPgmname( )
   {
      return "Servicio" ;
   }

   public String getPgmdesc( )
   {
      return "Servicio" ;
   }

   public void initializeNonKey1046( )
   {
      A52ServicioCategId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A52ServicioCategId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A52ServicioCategId), 4, 0));
      A281ServicioNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A281ServicioNombre", A281ServicioNombre);
      A282ServicioDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A282ServicioDescripcion", A282ServicioDescripcion);
      A283ServicioCosto = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A283ServicioCosto", GXutil.ltrimstr( A283ServicioCosto, 6, 2));
      A165LaboratorioNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
      A284ServicioComision = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A284ServicioComision", GXutil.ltrimstr( DecimalUtil.doubleToDec(A284ServicioComision), 4, 0));
      A285ServicioObservacion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A285ServicioObservacion", A285ServicioObservacion);
      A286ServicioEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A286ServicioEstado", A286ServicioEstado);
      A40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
      Z281ServicioNombre = "" ;
      Z282ServicioDescripcion = "" ;
      Z283ServicioCosto = DecimalUtil.ZERO ;
      Z284ServicioComision = (short)(0) ;
      Z285ServicioObservacion = "" ;
      Z286ServicioEstado = "" ;
      Z52ServicioCategId = (short)(0) ;
      Z40LaboratorioId = (short)(0) ;
   }

   public void initAll1046( )
   {
      A27ServicioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A27ServicioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A27ServicioId), 4, 0));
      initializeNonKey1046( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033583", true, true);
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
      httpContext.AddJavascriptSource("servicio.js", "?2022511033583", false, true);
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
      edtServicioId_Internalname = "SERVICIOID" ;
      edtServicioNombre_Internalname = "SERVICIONOMBRE" ;
      edtServicioDescripcion_Internalname = "SERVICIODESCRIPCION" ;
      edtServicioCosto_Internalname = "SERVICIOCOSTO" ;
      lblTextblockserviciocategid_Internalname = "TEXTBLOCKSERVICIOCATEGID" ;
      Combo_serviciocategid_Internalname = "COMBO_SERVICIOCATEGID" ;
      edtServicioCategId_Internalname = "SERVICIOCATEGID" ;
      divTablesplittedserviciocategid_Internalname = "TABLESPLITTEDSERVICIOCATEGID" ;
      edtLaboratorioId_Internalname = "LABORATORIOID" ;
      edtLaboratorioNombre_Internalname = "LABORATORIONOMBRE" ;
      edtServicioComision_Internalname = "SERVICIOCOMISION" ;
      edtServicioObservacion_Internalname = "SERVICIOOBSERVACION" ;
      cmbServicioEstado.setInternalname( "SERVICIOESTADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboserviciocategid_Internalname = "vCOMBOSERVICIOCATEGID" ;
      divSectionattribute_serviciocategid_Internalname = "SECTIONATTRIBUTE_SERVICIOCATEGID" ;
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
      Form.setCaption( "Servicio" );
      edtavComboserviciocategid_Jsonclick = "" ;
      edtavComboserviciocategid_Enabled = 0 ;
      edtavComboserviciocategid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbServicioEstado.setJsonclick( "" );
      cmbServicioEstado.setEnabled( 1 );
      edtServicioObservacion_Jsonclick = "" ;
      edtServicioObservacion_Enabled = 1 ;
      edtServicioComision_Jsonclick = "" ;
      edtServicioComision_Enabled = 1 ;
      edtLaboratorioNombre_Jsonclick = "" ;
      edtLaboratorioNombre_Enabled = 0 ;
      edtLaboratorioId_Jsonclick = "" ;
      edtLaboratorioId_Enabled = 0 ;
      edtServicioCategId_Jsonclick = "" ;
      edtServicioCategId_Enabled = 1 ;
      edtServicioCategId_Visible = 1 ;
      Combo_serviciocategid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_serviciocategid_Datalistprocparametersprefix = " \"ComboName\": \"ServicioCategId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"ServicioId\": 0" ;
      Combo_serviciocategid_Datalistproc = "ServicioLoadDVCombo" ;
      Combo_serviciocategid_Cls = "ExtendedCombo Attribute AttributeLabelSizeLarge" ;
      Combo_serviciocategid_Caption = "" ;
      Combo_serviciocategid_Enabled = GXutil.toBoolean( -1) ;
      edtServicioCosto_Jsonclick = "" ;
      edtServicioCosto_Enabled = 1 ;
      edtServicioDescripcion_Jsonclick = "" ;
      edtServicioDescripcion_Enabled = 1 ;
      edtServicioNombre_Jsonclick = "" ;
      edtServicioNombre_Enabled = 1 ;
      edtServicioId_Jsonclick = "" ;
      edtServicioId_Enabled = 0 ;
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

   public void gx8asalaboratorioid1046( byte Gx_BScreen ,
                                        short A40LaboratorioId ,
                                        String Gx_mode )
   {
      if ( isIns( )  && (0==A40LaboratorioId) && ( Gx_BScreen == 0 ) )
      {
         GXt_int1 = A40LaboratorioId ;
         GXv_int2[0] = GXt_int1 ;
         new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int2) ;
         servicio_impl.this.GXt_int1 = GXv_int2[0] ;
         A40LaboratorioId = GXt_int1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40LaboratorioId), 4, 0));
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
      cmbServicioEstado.setName( "SERVICIOESTADO" );
      cmbServicioEstado.setWebtags( "" );
      cmbServicioEstado.addItem("A", "Activo", (short)(0));
      cmbServicioEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbServicioEstado.getItemCount() > 0 )
      {
         A286ServicioEstado = cmbServicioEstado.getValidValue(A286ServicioEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A286ServicioEstado", A286ServicioEstado);
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

   public void valid_Serviciocategid( )
   {
      /* Using cursor T001016 */
      pr_default.execute(14, new Object[] {Short.valueOf(A52ServicioCategId)});
      Z40LaboratorioId = T001016_A40LaboratorioId[0] ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Servicio Categ'.", "ForeignKeyNotFound", 1, "SERVICIOCATEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtServicioCategId_Internalname ;
      }
      A40LaboratorioId = T001016_A40LaboratorioId[0] ;
      pr_default.close(14);
      if ( isIns( )  && (0==A40LaboratorioId) && ( Gx_BScreen == 0 ) )
      {
         GXt_int1 = A40LaboratorioId ;
         GXv_int2[0] = GXt_int1 ;
         new com.projectthani.prcgetlabbyuser(remoteHandle, context).execute( GXv_int2) ;
         servicio_impl.this.GXt_int1 = GXv_int2[0] ;
         A40LaboratorioId = GXt_int1 ;
      }
      /* Using cursor T001017 */
      pr_default.execute(15, new Object[] {Short.valueOf(A40LaboratorioId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Laboratorio'.", "ForeignKeyNotFound", 1, "LABORATORIOID");
         AnyError = (short)(1) ;
      }
      A165LaboratorioNombre = T001017_A165LaboratorioNombre[0] ;
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A40LaboratorioId", GXutil.ltrim( localUtil.ntoc( A40LaboratorioId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A165LaboratorioNombre", A165LaboratorioNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV23ServicioId',fld:'vSERVICIOID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV12TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV23ServicioId',fld:'vSERVICIOID',pic:'ZZZ9',hsh:true},{av:'A27ServicioId',fld:'SERVICIOID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12102',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV12TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_SERVICIOID","{handler:'valid_Servicioid',iparms:[]");
      setEventMetadata("VALID_SERVICIOID",",oparms:[]}");
      setEventMetadata("VALID_SERVICIOCATEGID","{handler:'valid_Serviciocategid',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A52ServicioCategId',fld:'SERVICIOCATEGID',pic:'ZZZ9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'A40LaboratorioId',fld:'LABORATORIOID',pic:'ZZZ9'},{av:'A165LaboratorioNombre',fld:'LABORATORIONOMBRE',pic:''}]");
      setEventMetadata("VALID_SERVICIOCATEGID",",oparms:[{av:'A40LaboratorioId',fld:'LABORATORIOID',pic:'ZZZ9'},{av:'A165LaboratorioNombre',fld:'LABORATORIONOMBRE',pic:''}]}");
      setEventMetadata("VALID_LABORATORIOID","{handler:'valid_Laboratorioid',iparms:[]");
      setEventMetadata("VALID_LABORATORIOID",",oparms:[]}");
      setEventMetadata("VALID_SERVICIOESTADO","{handler:'valid_Servicioestado',iparms:[]");
      setEventMetadata("VALID_SERVICIOESTADO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOSERVICIOCATEGID","{handler:'validv_Comboserviciocategid',iparms:[]");
      setEventMetadata("VALIDV_COMBOSERVICIOCATEGID",",oparms:[]}");
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
      pr_default.close(14);
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z281ServicioNombre = "" ;
      Z282ServicioDescripcion = "" ;
      Z283ServicioCosto = DecimalUtil.ZERO ;
      Z285ServicioObservacion = "" ;
      Z286ServicioEstado = "" ;
      Combo_serviciocategid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A286ServicioEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A281ServicioNombre = "" ;
      A282ServicioDescripcion = "" ;
      A283ServicioCosto = DecimalUtil.ZERO ;
      lblTextblockserviciocategid_Jsonclick = "" ;
      ucCombo_serviciocategid = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV17ServicioCategId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A165LaboratorioNombre = "" ;
      A285ServicioObservacion = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV25Pgmname = "" ;
      Combo_serviciocategid_Objectcall = "" ;
      Combo_serviciocategid_Class = "" ;
      Combo_serviciocategid_Icontype = "" ;
      Combo_serviciocategid_Icon = "" ;
      Combo_serviciocategid_Tooltip = "" ;
      Combo_serviciocategid_Selectedvalue_set = "" ;
      Combo_serviciocategid_Selectedtext_set = "" ;
      Combo_serviciocategid_Selectedtext_get = "" ;
      Combo_serviciocategid_Gamoauthtoken = "" ;
      Combo_serviciocategid_Ddointernalname = "" ;
      Combo_serviciocategid_Titlecontrolalign = "" ;
      Combo_serviciocategid_Dropdownoptionstype = "" ;
      Combo_serviciocategid_Titlecontrolidtoreplace = "" ;
      Combo_serviciocategid_Datalisttype = "" ;
      Combo_serviciocategid_Datalistfixedvalues = "" ;
      Combo_serviciocategid_Htmltemplate = "" ;
      Combo_serviciocategid_Multiplevaluestype = "" ;
      Combo_serviciocategid_Loadingdata = "" ;
      Combo_serviciocategid_Noresultsfound = "" ;
      Combo_serviciocategid_Emptyitemtext = "" ;
      Combo_serviciocategid_Onlyselectedvalues = "" ;
      Combo_serviciocategid_Selectalltext = "" ;
      Combo_serviciocategid_Multiplevaluesseparator = "" ;
      Combo_serviciocategid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      forbiddenHiddens2 = new com.genexus.util.GXProperties();
      hsh2 = "" ;
      sMode46 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV15WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV12TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV21Combo_DataJson = "" ;
      AV19ComboSelectedValue = "" ;
      AV20ComboSelectedText = "" ;
      GXt_char8 = "" ;
      GXv_char11 = new String[1] ;
      GXv_char10 = new String[1] ;
      GXv_char9 = new String[1] ;
      Z165LaboratorioNombre = "" ;
      T00105_A40LaboratorioId = new short[1] ;
      T00107_A27ServicioId = new short[1] ;
      T00107_A281ServicioNombre = new String[] {""} ;
      T00107_A282ServicioDescripcion = new String[] {""} ;
      T00107_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00107_A165LaboratorioNombre = new String[] {""} ;
      T00107_A284ServicioComision = new short[1] ;
      T00107_A285ServicioObservacion = new String[] {""} ;
      T00107_A286ServicioEstado = new String[] {""} ;
      T00107_A52ServicioCategId = new short[1] ;
      T00107_A40LaboratorioId = new short[1] ;
      T00106_A165LaboratorioNombre = new String[] {""} ;
      T00108_A165LaboratorioNombre = new String[] {""} ;
      T00109_A27ServicioId = new short[1] ;
      T00103_A27ServicioId = new short[1] ;
      T00103_A281ServicioNombre = new String[] {""} ;
      T00103_A282ServicioDescripcion = new String[] {""} ;
      T00103_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00103_A284ServicioComision = new short[1] ;
      T00103_A285ServicioObservacion = new String[] {""} ;
      T00103_A286ServicioEstado = new String[] {""} ;
      T00103_A52ServicioCategId = new short[1] ;
      T001010_A27ServicioId = new short[1] ;
      T001011_A27ServicioId = new short[1] ;
      T00102_A27ServicioId = new short[1] ;
      T00102_A281ServicioNombre = new String[] {""} ;
      T00102_A282ServicioDescripcion = new String[] {""} ;
      T00102_A283ServicioCosto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00102_A284ServicioComision = new short[1] ;
      T00102_A285ServicioObservacion = new String[] {""} ;
      T00102_A286ServicioEstado = new String[] {""} ;
      T00102_A52ServicioCategId = new short[1] ;
      T001012_A40LaboratorioId = new short[1] ;
      T001013_A27ServicioId = new short[1] ;
      T001016_A40LaboratorioId = new short[1] ;
      T001017_A165LaboratorioNombre = new String[] {""} ;
      T001018_A26CitaServicioId = new int[1] ;
      T001020_A27ServicioId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_int2 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.servicio__default(),
         new Object[] {
             new Object[] {
            T00102_A27ServicioId, T00102_A281ServicioNombre, T00102_A282ServicioDescripcion, T00102_A283ServicioCosto, T00102_A284ServicioComision, T00102_A285ServicioObservacion, T00102_A286ServicioEstado, T00102_A52ServicioCategId
            }
            , new Object[] {
            T00103_A27ServicioId, T00103_A281ServicioNombre, T00103_A282ServicioDescripcion, T00103_A283ServicioCosto, T00103_A284ServicioComision, T00103_A285ServicioObservacion, T00103_A286ServicioEstado, T00103_A52ServicioCategId
            }
            , new Object[] {
            T00104_A40LaboratorioId
            }
            , new Object[] {
            T00105_A40LaboratorioId
            }
            , new Object[] {
            T00106_A165LaboratorioNombre
            }
            , new Object[] {
            T00107_A27ServicioId, T00107_A281ServicioNombre, T00107_A282ServicioDescripcion, T00107_A283ServicioCosto, T00107_A165LaboratorioNombre, T00107_A284ServicioComision, T00107_A285ServicioObservacion, T00107_A286ServicioEstado, T00107_A52ServicioCategId, T00107_A40LaboratorioId
            }
            , new Object[] {
            T00108_A165LaboratorioNombre
            }
            , new Object[] {
            T00109_A27ServicioId
            }
            , new Object[] {
            T001010_A27ServicioId
            }
            , new Object[] {
            T001011_A27ServicioId
            }
            , new Object[] {
            T001012_A40LaboratorioId
            }
            , new Object[] {
            T001013_A27ServicioId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001016_A40LaboratorioId
            }
            , new Object[] {
            T001017_A165LaboratorioNombre
            }
            , new Object[] {
            T001018_A26CitaServicioId
            }
            , new Object[] {
            }
            , new Object[] {
            T001020_A27ServicioId
            }
         }
      );
      AV25Pgmname = "Servicio" ;
      Z40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
      A40LaboratorioId = new com.projectthani.prcgetlabbyuser(remoteHandle, context).executeUdp( ) ;
   }

   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte gxajaxcallmode ;
   private short wcpOAV23ServicioId ;
   private short Z27ServicioId ;
   private short Z284ServicioComision ;
   private short Z52ServicioCategId ;
   private short Z40LaboratorioId ;
   private short N52ServicioCategId ;
   private short A40LaboratorioId ;
   private short A52ServicioCategId ;
   private short AV23ServicioId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A27ServicioId ;
   private short A284ServicioComision ;
   private short AV22ComboServicioCategId ;
   private short AV8Insert_ServicioCategId ;
   private short RcdFound46 ;
   private short AV16LabId ;
   private short nIsDirty_46 ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private int trnEnded ;
   private int edtServicioId_Enabled ;
   private int edtServicioNombre_Enabled ;
   private int edtServicioDescripcion_Enabled ;
   private int edtServicioCosto_Enabled ;
   private int edtServicioCategId_Visible ;
   private int edtServicioCategId_Enabled ;
   private int edtLaboratorioId_Enabled ;
   private int edtLaboratorioNombre_Enabled ;
   private int edtServicioComision_Enabled ;
   private int edtServicioObservacion_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboserviciocategid_Enabled ;
   private int edtavComboserviciocategid_Visible ;
   private int Combo_serviciocategid_Datalistupdateminimumcharacters ;
   private int AV26GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z283ServicioCosto ;
   private java.math.BigDecimal A283ServicioCosto ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z286ServicioEstado ;
   private String Combo_serviciocategid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtServicioNombre_Internalname ;
   private String A286ServicioEstado ;
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
   private String edtServicioId_Internalname ;
   private String edtServicioId_Jsonclick ;
   private String TempTags ;
   private String edtServicioNombre_Jsonclick ;
   private String edtServicioDescripcion_Internalname ;
   private String edtServicioDescripcion_Jsonclick ;
   private String edtServicioCosto_Internalname ;
   private String edtServicioCosto_Jsonclick ;
   private String divTablesplittedserviciocategid_Internalname ;
   private String lblTextblockserviciocategid_Internalname ;
   private String lblTextblockserviciocategid_Jsonclick ;
   private String Combo_serviciocategid_Caption ;
   private String Combo_serviciocategid_Cls ;
   private String Combo_serviciocategid_Datalistproc ;
   private String Combo_serviciocategid_Datalistprocparametersprefix ;
   private String Combo_serviciocategid_Internalname ;
   private String edtServicioCategId_Internalname ;
   private String edtServicioCategId_Jsonclick ;
   private String edtLaboratorioId_Internalname ;
   private String edtLaboratorioId_Jsonclick ;
   private String edtLaboratorioNombre_Internalname ;
   private String edtLaboratorioNombre_Jsonclick ;
   private String edtServicioComision_Internalname ;
   private String edtServicioComision_Jsonclick ;
   private String edtServicioObservacion_Internalname ;
   private String edtServicioObservacion_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_serviciocategid_Internalname ;
   private String edtavComboserviciocategid_Internalname ;
   private String edtavComboserviciocategid_Jsonclick ;
   private String AV25Pgmname ;
   private String Combo_serviciocategid_Objectcall ;
   private String Combo_serviciocategid_Class ;
   private String Combo_serviciocategid_Icontype ;
   private String Combo_serviciocategid_Icon ;
   private String Combo_serviciocategid_Tooltip ;
   private String Combo_serviciocategid_Selectedvalue_set ;
   private String Combo_serviciocategid_Selectedtext_set ;
   private String Combo_serviciocategid_Selectedtext_get ;
   private String Combo_serviciocategid_Gamoauthtoken ;
   private String Combo_serviciocategid_Ddointernalname ;
   private String Combo_serviciocategid_Titlecontrolalign ;
   private String Combo_serviciocategid_Dropdownoptionstype ;
   private String Combo_serviciocategid_Titlecontrolidtoreplace ;
   private String Combo_serviciocategid_Datalisttype ;
   private String Combo_serviciocategid_Datalistfixedvalues ;
   private String Combo_serviciocategid_Htmltemplate ;
   private String Combo_serviciocategid_Multiplevaluestype ;
   private String Combo_serviciocategid_Loadingdata ;
   private String Combo_serviciocategid_Noresultsfound ;
   private String Combo_serviciocategid_Emptyitemtext ;
   private String Combo_serviciocategid_Onlyselectedvalues ;
   private String Combo_serviciocategid_Selectalltext ;
   private String Combo_serviciocategid_Multiplevaluesseparator ;
   private String Combo_serviciocategid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String hsh2 ;
   private String sMode46 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char8 ;
   private String GXv_char11[] ;
   private String GXv_char10[] ;
   private String GXv_char9[] ;
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
   private boolean Combo_serviciocategid_Emptyitem ;
   private boolean Combo_serviciocategid_Enabled ;
   private boolean Combo_serviciocategid_Visible ;
   private boolean Combo_serviciocategid_Allowmultipleselection ;
   private boolean Combo_serviciocategid_Isgriditem ;
   private boolean Combo_serviciocategid_Hasdescription ;
   private boolean Combo_serviciocategid_Includeonlyselectedoption ;
   private boolean Combo_serviciocategid_Includeselectalloption ;
   private boolean Combo_serviciocategid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean Gx_longc ;
   private String AV21Combo_DataJson ;
   private String Z281ServicioNombre ;
   private String Z282ServicioDescripcion ;
   private String Z285ServicioObservacion ;
   private String A281ServicioNombre ;
   private String A282ServicioDescripcion ;
   private String A165LaboratorioNombre ;
   private String A285ServicioObservacion ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private String Z165LaboratorioNombre ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_serviciocategid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private com.genexus.util.GXProperties forbiddenHiddens2 ;
   private HTMLChoice cmbServicioEstado ;
   private IDataStoreProvider pr_default ;
   private short[] T00105_A40LaboratorioId ;
   private short[] T00107_A27ServicioId ;
   private String[] T00107_A281ServicioNombre ;
   private String[] T00107_A282ServicioDescripcion ;
   private java.math.BigDecimal[] T00107_A283ServicioCosto ;
   private String[] T00107_A165LaboratorioNombre ;
   private short[] T00107_A284ServicioComision ;
   private String[] T00107_A285ServicioObservacion ;
   private String[] T00107_A286ServicioEstado ;
   private short[] T00107_A52ServicioCategId ;
   private short[] T00107_A40LaboratorioId ;
   private String[] T00106_A165LaboratorioNombre ;
   private String[] T00108_A165LaboratorioNombre ;
   private short[] T00109_A27ServicioId ;
   private short[] T00103_A27ServicioId ;
   private String[] T00103_A281ServicioNombre ;
   private String[] T00103_A282ServicioDescripcion ;
   private java.math.BigDecimal[] T00103_A283ServicioCosto ;
   private short[] T00103_A284ServicioComision ;
   private String[] T00103_A285ServicioObservacion ;
   private String[] T00103_A286ServicioEstado ;
   private short[] T00103_A52ServicioCategId ;
   private short[] T001010_A27ServicioId ;
   private short[] T001011_A27ServicioId ;
   private short[] T00102_A27ServicioId ;
   private String[] T00102_A281ServicioNombre ;
   private String[] T00102_A282ServicioDescripcion ;
   private java.math.BigDecimal[] T00102_A283ServicioCosto ;
   private short[] T00102_A284ServicioComision ;
   private String[] T00102_A285ServicioObservacion ;
   private String[] T00102_A286ServicioEstado ;
   private short[] T00102_A52ServicioCategId ;
   private short[] T001012_A40LaboratorioId ;
   private short[] T001013_A27ServicioId ;
   private short[] T001016_A40LaboratorioId ;
   private String[] T001017_A165LaboratorioNombre ;
   private int[] T001018_A26CitaServicioId ;
   private short[] T001020_A27ServicioId ;
   private short[] T00104_A40LaboratorioId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV17ServicioCategId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV15WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[] ;
}

final  class servicio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00102", "SELECT [ServicioId], [ServicioNombre], [ServicioDescripcion], [ServicioCosto], [ServicioComision], [ServicioObservacion], [ServicioEstado], [ServicioCategId] FROM [Servicio] WITH (UPDLOCK) WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00103", "SELECT [ServicioId], [ServicioNombre], [ServicioDescripcion], [ServicioCosto], [ServicioComision], [ServicioObservacion], [ServicioEstado], [ServicioCategId] FROM [Servicio] WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00104", "SELECT [LaboratorioId] FROM [ServicioCateg] WITH (UPDLOCK) WHERE [ServicioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00105", "SELECT [LaboratorioId] FROM [ServicioCateg] WHERE [ServicioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00106", "SELECT [LaboratorioNombre] FROM [Laboratorio] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00107", "SELECT TM1.[ServicioId], TM1.[ServicioNombre], TM1.[ServicioDescripcion], TM1.[ServicioCosto], T3.[LaboratorioNombre], TM1.[ServicioComision], TM1.[ServicioObservacion], TM1.[ServicioEstado], TM1.[ServicioCategId], T2.[LaboratorioId] FROM (([Servicio] TM1 INNER JOIN [ServicioCateg] T2 ON T2.[ServicioCategId] = TM1.[ServicioCategId]) INNER JOIN [Laboratorio] T3 ON T3.[LaboratorioId] = T2.[LaboratorioId]) WHERE TM1.[ServicioId] = ? ORDER BY TM1.[ServicioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00108", "SELECT [LaboratorioNombre] FROM [Laboratorio] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00109", "SELECT [ServicioId] FROM [Servicio] WHERE [ServicioId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001010", "SELECT TOP 1 [ServicioId] FROM [Servicio] WHERE ( [ServicioId] > ?) ORDER BY [ServicioId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001011", "SELECT TOP 1 [ServicioId] FROM [Servicio] WHERE ( [ServicioId] < ?) ORDER BY [ServicioId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001012", "SELECT [LaboratorioId] FROM [ServicioCateg] WITH (UPDLOCK) WHERE [ServicioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001013", "INSERT INTO [Servicio]([ServicioNombre], [ServicioDescripcion], [ServicioCosto], [ServicioComision], [ServicioObservacion], [ServicioEstado], [ServicioCategId]) VALUES(?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T001014", "UPDATE [Servicio] SET [ServicioNombre]=?, [ServicioDescripcion]=?, [ServicioCosto]=?, [ServicioComision]=?, [ServicioObservacion]=?, [ServicioEstado]=?, [ServicioCategId]=?  WHERE [ServicioId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001015", "DELETE FROM [Servicio]  WHERE [ServicioId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001016", "SELECT [LaboratorioId] FROM [ServicioCateg] WHERE [ServicioCategId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001017", "SELECT [LaboratorioNombre] FROM [Laboratorio] WHERE [LaboratorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001018", "SELECT TOP 1 [CitaServicioId] FROM [CitaServicio] WHERE [ServicioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001019", "UPDATE [ServicioCateg] SET [LaboratorioId]=?  WHERE [ServicioCategId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001020", "SELECT [ServicioId] FROM [Servicio] ORDER BY [ServicioId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
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
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

