package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class drogueria_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_usuarios") == 0 )
      {
         nRC_GXsfl_55 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_55"))) ;
         nGXsfl_55_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_55_idx"))) ;
         sGXsfl_55_idx = httpContext.GetPar( "sGXsfl_55_idx") ;
         edtSecUserId_Horizontalalignment = httpContext.GetNextPar( ) ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Horizontalalignment", edtSecUserId_Horizontalalignment, !bGXsfl_55_Refreshing);
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridlevel_usuarios_newrow( ) ;
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
            AV17DrogueriaId = (short)(GXutil.lval( httpContext.GetPar( "DrogueriaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17DrogueriaId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDROGUERIAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17DrogueriaId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Drogueria", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtDrogueriaNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public drogueria_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public drogueria_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( drogueria_impl.class ));
   }

   public drogueria_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbDrogueriaTipoDocumento = new HTMLChoice();
      cmbDrogueriaEstado = new HTMLChoice();
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
      if ( cmbDrogueriaTipoDocumento.getItemCount() > 0 )
      {
         A143DrogueriaTipoDocumento = cmbDrogueriaTipoDocumento.getValidValue(A143DrogueriaTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A143DrogueriaTipoDocumento", A143DrogueriaTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDrogueriaTipoDocumento.setValue( GXutil.rtrim( A143DrogueriaTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDrogueriaTipoDocumento.getInternalname(), "Values", cmbDrogueriaTipoDocumento.ToJavascriptSource(), true);
      }
      if ( cmbDrogueriaEstado.getItemCount() > 0 )
      {
         A147DrogueriaEstado = cmbDrogueriaEstado.getValidValue(A147DrogueriaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A147DrogueriaEstado", A147DrogueriaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDrogueriaEstado.setValue( GXutil.rtrim( A147DrogueriaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDrogueriaEstado.getInternalname(), "Values", cmbDrogueriaEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDrogueriaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDrogueriaId_Internalname, "Id", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDrogueriaId_Internalname, GXutil.ltrim( localUtil.ntoc( A36DrogueriaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtDrogueriaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDrogueriaId_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtDrogueriaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Drogueria.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDrogueriaNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDrogueriaNombre_Internalname, "Nombre", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDrogueriaNombre_Internalname, A141DrogueriaNombre, GXutil.rtrim( localUtil.format( A141DrogueriaNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDrogueriaNombre_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtDrogueriaNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Drogueria.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDrogueriaDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDrogueriaDescripcion_Internalname, "Descripcion", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 31,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDrogueriaDescripcion_Internalname, A142DrogueriaDescripcion, GXutil.rtrim( localUtil.format( A142DrogueriaDescripcion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,31);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDrogueriaDescripcion_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtDrogueriaDescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Drogueria.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDrogueriaTipoDocumento.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDrogueriaTipoDocumento.getInternalname(), "Tipo Documento", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDrogueriaTipoDocumento, cmbDrogueriaTipoDocumento.getInternalname(), GXutil.rtrim( A143DrogueriaTipoDocumento), 1, cmbDrogueriaTipoDocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDrogueriaTipoDocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute AttributeLabelSizeLarge", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "", true, (byte)(1), "HLP_Drogueria.htm");
      cmbDrogueriaTipoDocumento.setValue( GXutil.rtrim( A143DrogueriaTipoDocumento) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDrogueriaTipoDocumento.getInternalname(), "Values", cmbDrogueriaTipoDocumento.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDrogueriaNroDocumento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDrogueriaNroDocumento_Internalname, "Nro Documento", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 40,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDrogueriaNroDocumento_Internalname, A144DrogueriaNroDocumento, GXutil.rtrim( localUtil.format( A144DrogueriaNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,40);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDrogueriaNroDocumento_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtDrogueriaNroDocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Drogueria.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDrogueriaDireccion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDrogueriaDireccion_Internalname, "Direccion", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDrogueriaDireccion_Internalname, A145DrogueriaDireccion, GXutil.rtrim( localUtil.format( A145DrogueriaDireccion, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,44);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDrogueriaDireccion_Jsonclick, 0, "Attribute AttributeLabelSizeLarge", "", "", "", "", 1, edtDrogueriaDireccion_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Drogueria.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDrogueriaEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDrogueriaEstado.getInternalname(), "Estado", " AttributeLabel AttributeLabelSizeLargeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDrogueriaEstado, cmbDrogueriaEstado.getInternalname(), GXutil.rtrim( A147DrogueriaEstado), 1, cmbDrogueriaEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDrogueriaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute AttributeLabelSizeLarge", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,49);\"", "", true, (byte)(1), "HLP_Drogueria.htm");
      cmbDrogueriaEstado.setValue( GXutil.rtrim( A147DrogueriaEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDrogueriaEstado.getInternalname(), "Values", cmbDrogueriaEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTableleaflevel_usuarios_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      gxdraw_gridlevel_usuarios( ) ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Drogueria.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Drogueria.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Drogueria.htm");
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
      ucCombo_secuserid.setProperty("DropDownOptionsTitleSettingsIcons", AV13DDO_TitleSettingsIcons);
      ucCombo_secuserid.setProperty("DropDownOptionsData", AV12SecUserId_Data);
      ucCombo_secuserid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_secuserid_Internalname, "COMBO_SECUSERIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridlevel_usuarios( )
   {
      /*  Grid Control  */
      Gridlevel_usuariosContainer.AddObjectProperty("GridName", "Gridlevel_usuarios");
      Gridlevel_usuariosContainer.AddObjectProperty("Header", subGridlevel_usuarios_Header);
      Gridlevel_usuariosContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
      Gridlevel_usuariosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_usuariosContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_usuariosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_usuariosColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_usuariosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_usuariosColumn.AddObjectProperty("Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment));
      Gridlevel_usuariosContainer.AddColumnProperties(Gridlevel_usuariosColumn);
      Gridlevel_usuariosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_usuariosColumn.AddObjectProperty("Value", A14SecUserName);
      Gridlevel_usuariosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddColumnProperties(Gridlevel_usuariosColumn);
      Gridlevel_usuariosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_usuariosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_usuarios_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_55_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount28 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_28 = (short)(1) ;
            scanStart0K28( ) ;
            while ( RcdFound28 != 0 )
            {
               init_level_properties28( ) ;
               getByPrimaryKey0K28( ) ;
               addRow0K28( ) ;
               scanNext0K28( ) ;
            }
            scanEnd0K28( ) ;
            nBlankRcdCount28 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0K28( ) ;
         standaloneModal0K28( ) ;
         sMode28 = Gx_mode ;
         while ( nGXsfl_55_idx < nRC_GXsfl_55 )
         {
            bGXsfl_55_Refreshing = true ;
            readRow0K28( ) ;
            edtSecUserId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERID_"+sGXsfl_55_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_55_Refreshing);
            edtSecUserId_Horizontalalignment = httpContext.cgiGet( "SECUSERID_"+sGXsfl_55_idx+"Horizontalalignment") ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Horizontalalignment", edtSecUserId_Horizontalalignment, !bGXsfl_55_Refreshing);
            edtSecUserName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERNAME_"+sGXsfl_55_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Enabled), 5, 0), !bGXsfl_55_Refreshing);
            if ( ( nRcdExists_28 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0K28( ) ;
            }
            sendRow0K28( ) ;
            bGXsfl_55_Refreshing = false ;
         }
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount28 = (short)(5) ;
         nRcdExists_28 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0K28( ) ;
            while ( RcdFound28 != 0 )
            {
               sGXsfl_55_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_55_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_5528( ) ;
               init_level_properties28( ) ;
               standaloneNotModal0K28( ) ;
               getByPrimaryKey0K28( ) ;
               standaloneModal0K28( ) ;
               addRow0K28( ) ;
               scanNext0K28( ) ;
            }
            scanEnd0K28( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode28 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_55_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_55_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_5528( ) ;
         initAll0K28( ) ;
         init_level_properties28( ) ;
         nRcdExists_28 = (short)(0) ;
         nIsMod_28 = (short)(0) ;
         nRcdDeleted_28 = (short)(0) ;
         nBlankRcdCount28 = (short)(nBlankRcdUsr28+nBlankRcdCount28) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount28 > 0 )
         {
            standaloneNotModal0K28( ) ;
            standaloneModal0K28( ) ;
            addRow0K28( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount28 = (short)(nBlankRcdCount28-1) ;
         }
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_usuariosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_usuarios", Gridlevel_usuariosContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_usuariosContainerData", Gridlevel_usuariosContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_usuariosContainerData"+"V", Gridlevel_usuariosContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_usuariosContainerData"+"V"+"\" value='"+Gridlevel_usuariosContainer.GridValuesHidden()+"'/>") ;
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
      e110K2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV13DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECUSERID_DATA"), AV12SecUserId_Data);
            /* Read saved values. */
            Z36DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z36DrogueriaId"), ",", ".")) ;
            Z141DrogueriaNombre = httpContext.cgiGet( "Z141DrogueriaNombre") ;
            Z142DrogueriaDescripcion = httpContext.cgiGet( "Z142DrogueriaDescripcion") ;
            Z143DrogueriaTipoDocumento = httpContext.cgiGet( "Z143DrogueriaTipoDocumento") ;
            Z144DrogueriaNroDocumento = httpContext.cgiGet( "Z144DrogueriaNroDocumento") ;
            Z145DrogueriaDireccion = httpContext.cgiGet( "Z145DrogueriaDireccion") ;
            Z147DrogueriaEstado = httpContext.cgiGet( "Z147DrogueriaEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_55 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_55"), ",", ".")) ;
            AV17DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( "vDROGUERIAID"), ",", ".")) ;
            AV18Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A36DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( edtDrogueriaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
            A141DrogueriaNombre = httpContext.cgiGet( edtDrogueriaNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A141DrogueriaNombre", A141DrogueriaNombre);
            A142DrogueriaDescripcion = httpContext.cgiGet( edtDrogueriaDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A142DrogueriaDescripcion", A142DrogueriaDescripcion);
            cmbDrogueriaTipoDocumento.setName( cmbDrogueriaTipoDocumento.getInternalname() );
            cmbDrogueriaTipoDocumento.setValue( httpContext.cgiGet( cmbDrogueriaTipoDocumento.getInternalname()) );
            A143DrogueriaTipoDocumento = httpContext.cgiGet( cmbDrogueriaTipoDocumento.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A143DrogueriaTipoDocumento", A143DrogueriaTipoDocumento);
            A144DrogueriaNroDocumento = httpContext.cgiGet( edtDrogueriaNroDocumento_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A144DrogueriaNroDocumento", A144DrogueriaNroDocumento);
            A145DrogueriaDireccion = httpContext.cgiGet( edtDrogueriaDireccion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A145DrogueriaDireccion", A145DrogueriaDireccion);
            cmbDrogueriaEstado.setName( cmbDrogueriaEstado.getInternalname() );
            cmbDrogueriaEstado.setValue( httpContext.cgiGet( cmbDrogueriaEstado.getInternalname()) );
            A147DrogueriaEstado = httpContext.cgiGet( cmbDrogueriaEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A147DrogueriaEstado", A147DrogueriaEstado);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Drogueria");
            A36DrogueriaId = (short)(localUtil.ctol( httpContext.cgiGet( edtDrogueriaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
            forbiddenHiddens.add("DrogueriaId", localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A36DrogueriaId != Z36DrogueriaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("drogueria:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A36DrogueriaId = (short)(GXutil.lval( httpContext.GetPar( "DrogueriaId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
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
                  sMode27 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode27 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound27 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0K0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "DROGUERIAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtDrogueriaId_Internalname ;
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
                        e110K2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120K2 ();
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
         e120K2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0K27( ) ;
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
         disableAttributes0K27( ) ;
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

   public void confirm_0K0( )
   {
      beforeValidate0K27( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0K27( ) ;
         }
         else
         {
            checkExtendedTable0K27( ) ;
            closeExtendedTableCursors0K27( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode27 = Gx_mode ;
         confirm_0K28( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode27 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode27 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0K28( )
   {
      nGXsfl_55_idx = 0 ;
      while ( nGXsfl_55_idx < nRC_GXsfl_55 )
      {
         readRow0K28( ) ;
         if ( ( nRcdExists_28 != 0 ) || ( nIsMod_28 != 0 ) )
         {
            getKey0K28( ) ;
            if ( ( nRcdExists_28 == 0 ) && ( nRcdDeleted_28 == 0 ) )
            {
               if ( RcdFound28 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0K28( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0K28( ) ;
                     closeExtendedTableCursors0K28( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "SECUSERID_" + sGXsfl_55_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecUserId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound28 != 0 )
               {
                  if ( nRcdDeleted_28 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0K28( ) ;
                     load0K28( ) ;
                     beforeValidate0K28( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0K28( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_28 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0K28( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0K28( ) ;
                           closeExtendedTableCursors0K28( ) ;
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
                  if ( nRcdDeleted_28 == 0 )
                  {
                     GXCCtl = "SECUSERID_" + sGXsfl_55_idx ;
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
         httpContext.changePostValue( "ZT_"+"Z6SecUserId_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_28_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_28, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_28_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_28, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_28_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_28, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_28 != 0 )
         {
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_55_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_55_idx+"Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment)) ;
            httpContext.changePostValue( "SECUSERNAME_"+sGXsfl_55_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0K0( )
   {
   }

   public void e110K2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV13DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV13DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      Combo_secuserid_Titlecontrolidtoreplace = edtSecUserId_Internalname ;
      ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "TitleControlIdToReplace", Combo_secuserid_Titlecontrolidtoreplace);
      edtSecUserId_Horizontalalignment = "Left" ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Horizontalalignment", edtSecUserId_Horizontalalignment, !bGXsfl_55_Refreshing);
      AV8IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria_Insert", GXv_boolean5) ;
         drogueria_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria_Update", GXv_boolean5) ;
         drogueria_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDrogueria_Delete", GXv_boolean5) ;
         drogueria_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e120K2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.drogueriaww", new String[] {}, new String[] {}) );
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

   public void zm0K27( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z141DrogueriaNombre = T000K6_A141DrogueriaNombre[0] ;
            Z142DrogueriaDescripcion = T000K6_A142DrogueriaDescripcion[0] ;
            Z143DrogueriaTipoDocumento = T000K6_A143DrogueriaTipoDocumento[0] ;
            Z144DrogueriaNroDocumento = T000K6_A144DrogueriaNroDocumento[0] ;
            Z145DrogueriaDireccion = T000K6_A145DrogueriaDireccion[0] ;
            Z147DrogueriaEstado = T000K6_A147DrogueriaEstado[0] ;
         }
         else
         {
            Z141DrogueriaNombre = A141DrogueriaNombre ;
            Z142DrogueriaDescripcion = A142DrogueriaDescripcion ;
            Z143DrogueriaTipoDocumento = A143DrogueriaTipoDocumento ;
            Z144DrogueriaNroDocumento = A144DrogueriaNroDocumento ;
            Z145DrogueriaDireccion = A145DrogueriaDireccion ;
            Z147DrogueriaEstado = A147DrogueriaEstado ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z36DrogueriaId = A36DrogueriaId ;
         Z141DrogueriaNombre = A141DrogueriaNombre ;
         Z142DrogueriaDescripcion = A142DrogueriaDescripcion ;
         Z143DrogueriaTipoDocumento = A143DrogueriaTipoDocumento ;
         Z144DrogueriaNroDocumento = A144DrogueriaNroDocumento ;
         Z145DrogueriaDireccion = A145DrogueriaDireccion ;
         Z147DrogueriaEstado = A147DrogueriaEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      edtDrogueriaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Enabled), 5, 0), true);
      edtDrogueriaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV17DrogueriaId) )
      {
         A36DrogueriaId = AV17DrogueriaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
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

   public void load0K27( )
   {
      /* Using cursor T000K7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound27 = (short)(1) ;
         A141DrogueriaNombre = T000K7_A141DrogueriaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A141DrogueriaNombre", A141DrogueriaNombre);
         A142DrogueriaDescripcion = T000K7_A142DrogueriaDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A142DrogueriaDescripcion", A142DrogueriaDescripcion);
         A143DrogueriaTipoDocumento = T000K7_A143DrogueriaTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A143DrogueriaTipoDocumento", A143DrogueriaTipoDocumento);
         A144DrogueriaNroDocumento = T000K7_A144DrogueriaNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A144DrogueriaNroDocumento", A144DrogueriaNroDocumento);
         A145DrogueriaDireccion = T000K7_A145DrogueriaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A145DrogueriaDireccion", A145DrogueriaDireccion);
         A147DrogueriaEstado = T000K7_A147DrogueriaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A147DrogueriaEstado", A147DrogueriaEstado);
         zm0K27( -5) ;
      }
      pr_default.close(5);
      onLoadActions0K27( ) ;
   }

   public void onLoadActions0K27( )
   {
      AV18Pgmname = "Drogueria" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
   }

   public void checkExtendedTable0K27( )
   {
      nIsDirty_27 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV18Pgmname = "Drogueria" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      if ( ! ( ( GXutil.strcmp(A143DrogueriaTipoDocumento, "1") == 0 ) || ( GXutil.strcmp(A143DrogueriaTipoDocumento, "6") == 0 ) || ( GXutil.strcmp(A143DrogueriaTipoDocumento, "2") == 0 ) || ( GXutil.strcmp(A143DrogueriaTipoDocumento, "4") == 0 ) || ( GXutil.strcmp(A143DrogueriaTipoDocumento, "7") == 0 ) || ( GXutil.strcmp(A143DrogueriaTipoDocumento, "0") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Drogueria Tipo Documento fuera de rango", "OutOfRange", 1, "DROGUERIATIPODOCUMENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDrogueriaTipoDocumento.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A147DrogueriaEstado, "A") == 0 ) || ( GXutil.strcmp(A147DrogueriaEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Drogueria Estado fuera de rango", "OutOfRange", 1, "DROGUERIAESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDrogueriaEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0K27( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0K27( )
   {
      /* Using cursor T000K8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound27 = (short)(1) ;
      }
      else
      {
         RcdFound27 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000K6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0K27( 5) ;
         RcdFound27 = (short)(1) ;
         A36DrogueriaId = T000K6_A36DrogueriaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
         A141DrogueriaNombre = T000K6_A141DrogueriaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A141DrogueriaNombre", A141DrogueriaNombre);
         A142DrogueriaDescripcion = T000K6_A142DrogueriaDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A142DrogueriaDescripcion", A142DrogueriaDescripcion);
         A143DrogueriaTipoDocumento = T000K6_A143DrogueriaTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A143DrogueriaTipoDocumento", A143DrogueriaTipoDocumento);
         A144DrogueriaNroDocumento = T000K6_A144DrogueriaNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A144DrogueriaNroDocumento", A144DrogueriaNroDocumento);
         A145DrogueriaDireccion = T000K6_A145DrogueriaDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A145DrogueriaDireccion", A145DrogueriaDireccion);
         A147DrogueriaEstado = T000K6_A147DrogueriaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A147DrogueriaEstado", A147DrogueriaEstado);
         Z36DrogueriaId = A36DrogueriaId ;
         sMode27 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0K27( ) ;
         if ( AnyError == 1 )
         {
            RcdFound27 = (short)(0) ;
            initializeNonKey0K27( ) ;
         }
         Gx_mode = sMode27 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound27 = (short)(0) ;
         initializeNonKey0K27( ) ;
         sMode27 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode27 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0K27( ) ;
      if ( RcdFound27 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound27 = (short)(0) ;
      /* Using cursor T000K9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T000K9_A36DrogueriaId[0] < A36DrogueriaId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T000K9_A36DrogueriaId[0] > A36DrogueriaId ) ) )
         {
            A36DrogueriaId = T000K9_A36DrogueriaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
            RcdFound27 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound27 = (short)(0) ;
      /* Using cursor T000K10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A36DrogueriaId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000K10_A36DrogueriaId[0] > A36DrogueriaId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000K10_A36DrogueriaId[0] < A36DrogueriaId ) ) )
         {
            A36DrogueriaId = T000K10_A36DrogueriaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
            RcdFound27 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0K27( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtDrogueriaNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0K27( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound27 == 1 )
         {
            if ( A36DrogueriaId != Z36DrogueriaId )
            {
               A36DrogueriaId = Z36DrogueriaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "DROGUERIAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDrogueriaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtDrogueriaNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0K27( ) ;
               GX_FocusControl = edtDrogueriaNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A36DrogueriaId != Z36DrogueriaId )
            {
               /* Insert record */
               GX_FocusControl = edtDrogueriaNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0K27( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "DROGUERIAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtDrogueriaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtDrogueriaNombre_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0K27( ) ;
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
      if ( A36DrogueriaId != Z36DrogueriaId )
      {
         A36DrogueriaId = Z36DrogueriaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "DROGUERIAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDrogueriaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtDrogueriaNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0K27( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000K5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A36DrogueriaId)});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Drogueria"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || ( GXutil.strcmp(Z141DrogueriaNombre, T000K5_A141DrogueriaNombre[0]) != 0 ) || ( GXutil.strcmp(Z142DrogueriaDescripcion, T000K5_A142DrogueriaDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z143DrogueriaTipoDocumento, T000K5_A143DrogueriaTipoDocumento[0]) != 0 ) || ( GXutil.strcmp(Z144DrogueriaNroDocumento, T000K5_A144DrogueriaNroDocumento[0]) != 0 ) || ( GXutil.strcmp(Z145DrogueriaDireccion, T000K5_A145DrogueriaDireccion[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z147DrogueriaEstado, T000K5_A147DrogueriaEstado[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z141DrogueriaNombre, T000K5_A141DrogueriaNombre[0]) != 0 )
            {
               GXutil.writeLogln("drogueria:[seudo value changed for attri]"+"DrogueriaNombre");
               GXutil.writeLogRaw("Old: ",Z141DrogueriaNombre);
               GXutil.writeLogRaw("Current: ",T000K5_A141DrogueriaNombre[0]);
            }
            if ( GXutil.strcmp(Z142DrogueriaDescripcion, T000K5_A142DrogueriaDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("drogueria:[seudo value changed for attri]"+"DrogueriaDescripcion");
               GXutil.writeLogRaw("Old: ",Z142DrogueriaDescripcion);
               GXutil.writeLogRaw("Current: ",T000K5_A142DrogueriaDescripcion[0]);
            }
            if ( GXutil.strcmp(Z143DrogueriaTipoDocumento, T000K5_A143DrogueriaTipoDocumento[0]) != 0 )
            {
               GXutil.writeLogln("drogueria:[seudo value changed for attri]"+"DrogueriaTipoDocumento");
               GXutil.writeLogRaw("Old: ",Z143DrogueriaTipoDocumento);
               GXutil.writeLogRaw("Current: ",T000K5_A143DrogueriaTipoDocumento[0]);
            }
            if ( GXutil.strcmp(Z144DrogueriaNroDocumento, T000K5_A144DrogueriaNroDocumento[0]) != 0 )
            {
               GXutil.writeLogln("drogueria:[seudo value changed for attri]"+"DrogueriaNroDocumento");
               GXutil.writeLogRaw("Old: ",Z144DrogueriaNroDocumento);
               GXutil.writeLogRaw("Current: ",T000K5_A144DrogueriaNroDocumento[0]);
            }
            if ( GXutil.strcmp(Z145DrogueriaDireccion, T000K5_A145DrogueriaDireccion[0]) != 0 )
            {
               GXutil.writeLogln("drogueria:[seudo value changed for attri]"+"DrogueriaDireccion");
               GXutil.writeLogRaw("Old: ",Z145DrogueriaDireccion);
               GXutil.writeLogRaw("Current: ",T000K5_A145DrogueriaDireccion[0]);
            }
            if ( GXutil.strcmp(Z147DrogueriaEstado, T000K5_A147DrogueriaEstado[0]) != 0 )
            {
               GXutil.writeLogln("drogueria:[seudo value changed for attri]"+"DrogueriaEstado");
               GXutil.writeLogRaw("Old: ",Z147DrogueriaEstado);
               GXutil.writeLogRaw("Current: ",T000K5_A147DrogueriaEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Drogueria"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0K27( )
   {
      beforeValidate0K27( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0K27( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0K27( 0) ;
         checkOptimisticConcurrency0K27( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0K27( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0K27( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000K11 */
                  pr_default.execute(9, new Object[] {A141DrogueriaNombre, A142DrogueriaDescripcion, A143DrogueriaTipoDocumento, A144DrogueriaNroDocumento, A145DrogueriaDireccion, A147DrogueriaEstado});
                  A36DrogueriaId = T000K11_A36DrogueriaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Drogueria");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0K27( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0K0( ) ;
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
            load0K27( ) ;
         }
         endLevel0K27( ) ;
      }
      closeExtendedTableCursors0K27( ) ;
   }

   public void update0K27( )
   {
      beforeValidate0K27( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0K27( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0K27( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0K27( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0K27( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000K12 */
                  pr_default.execute(10, new Object[] {A141DrogueriaNombre, A142DrogueriaDescripcion, A143DrogueriaTipoDocumento, A144DrogueriaNroDocumento, A145DrogueriaDireccion, A147DrogueriaEstado, Short.valueOf(A36DrogueriaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Drogueria");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Drogueria"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0K27( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0K27( ) ;
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
         endLevel0K27( ) ;
      }
      closeExtendedTableCursors0K27( ) ;
   }

   public void deferredUpdate0K27( )
   {
   }

   public void delete( )
   {
      beforeValidate0K27( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0K27( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0K27( ) ;
         afterConfirm0K27( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0K27( ) ;
            if ( AnyError == 0 )
            {
               scanStart0K28( ) ;
               while ( RcdFound28 != 0 )
               {
                  getByPrimaryKey0K28( ) ;
                  delete0K28( ) ;
                  scanNext0K28( ) ;
               }
               scanEnd0K28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000K13 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A36DrogueriaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Drogueria");
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
      sMode27 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0K27( ) ;
      Gx_mode = sMode27 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0K27( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV18Pgmname = "Drogueria" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000K14 */
         pr_default.execute(12, new Object[] {Short.valueOf(A36DrogueriaId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Petitorio"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void processNestedLevel0K28( )
   {
      nGXsfl_55_idx = 0 ;
      while ( nGXsfl_55_idx < nRC_GXsfl_55 )
      {
         readRow0K28( ) ;
         if ( ( nRcdExists_28 != 0 ) || ( nIsMod_28 != 0 ) )
         {
            standaloneNotModal0K28( ) ;
            getKey0K28( ) ;
            if ( ( nRcdExists_28 == 0 ) && ( nRcdDeleted_28 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0K28( ) ;
            }
            else
            {
               if ( RcdFound28 != 0 )
               {
                  if ( ( nRcdDeleted_28 != 0 ) && ( nRcdExists_28 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0K28( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_28 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0K28( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_28 == 0 )
                  {
                     GXCCtl = "SECUSERID_" + sGXsfl_55_idx ;
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
         httpContext.changePostValue( "ZT_"+"Z6SecUserId_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_28_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_28, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_28_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_28, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_28_"+sGXsfl_55_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_28, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_28 != 0 )
         {
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_55_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SECUSERID_"+sGXsfl_55_idx+"Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment)) ;
            httpContext.changePostValue( "SECUSERNAME_"+sGXsfl_55_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0K28( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_28 = (short)(0) ;
      nIsMod_28 = (short)(0) ;
      nRcdDeleted_28 = (short)(0) ;
   }

   public void processLevel0K27( )
   {
      /* Save parent mode. */
      sMode27 = Gx_mode ;
      processNestedLevel0K28( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode27 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0K27( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0K27( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         Application.commitDataStores(context, remoteHandle, pr_default, "drogueria");
         if ( AnyError == 0 )
         {
            confirmValues0K0( ) ;
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
         Application.rollbackDataStores(context, remoteHandle, pr_default, "drogueria");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0K27( )
   {
      /* Scan By routine */
      /* Using cursor T000K15 */
      pr_default.execute(13);
      RcdFound27 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound27 = (short)(1) ;
         A36DrogueriaId = T000K15_A36DrogueriaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0K27( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound27 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound27 = (short)(1) ;
         A36DrogueriaId = T000K15_A36DrogueriaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
      }
   }

   public void scanEnd0K27( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0K27( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0K27( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0K27( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0K27( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0K27( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0K27( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0K27( )
   {
      edtDrogueriaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaId_Enabled), 5, 0), true);
      edtDrogueriaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaNombre_Enabled), 5, 0), true);
      edtDrogueriaDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaDescripcion_Enabled), 5, 0), true);
      cmbDrogueriaTipoDocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDrogueriaTipoDocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDrogueriaTipoDocumento.getEnabled(), 5, 0), true);
      edtDrogueriaNroDocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaNroDocumento_Enabled), 5, 0), true);
      edtDrogueriaDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDrogueriaDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDrogueriaDireccion_Enabled), 5, 0), true);
      cmbDrogueriaEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDrogueriaEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDrogueriaEstado.getEnabled(), 5, 0), true);
   }

   public void zm0K28( int GX_JID )
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
         Z36DrogueriaId = A36DrogueriaId ;
         Z6SecUserId = A6SecUserId ;
         Z14SecUserName = A14SecUserName ;
      }
   }

   public void standaloneNotModal0K28( )
   {
   }

   public void standaloneModal0K28( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtSecUserId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_55_Refreshing);
      }
      else
      {
         edtSecUserId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_55_Refreshing);
      }
   }

   public void load0K28( )
   {
      /* Using cursor T000K16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A36DrogueriaId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A14SecUserName = T000K16_A14SecUserName[0] ;
         zm0K28( -6) ;
      }
      pr_default.close(14);
      onLoadActions0K28( ) ;
   }

   public void onLoadActions0K28( )
   {
   }

   public void checkExtendedTable0K28( )
   {
      nIsDirty_28 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0K28( ) ;
      /* Using cursor T000K4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "SECUSERID_" + sGXsfl_55_idx ;
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A14SecUserName = T000K4_A14SecUserName[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors0K28( )
   {
      pr_default.close(2);
   }

   public void enableDisable0K28( )
   {
   }

   public void gxload_7( short A6SecUserId )
   {
      /* Using cursor T000K17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         GXCCtl = "SECUSERID_" + sGXsfl_55_idx ;
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A14SecUserName = T000K17_A14SecUserName[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A14SecUserName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(15) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(15);
   }

   public void getKey0K28( )
   {
      /* Using cursor T000K18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A36DrogueriaId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound28 = (short)(1) ;
      }
      else
      {
         RcdFound28 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey0K28( )
   {
      /* Using cursor T000K3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A36DrogueriaId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0K28( 6) ;
         RcdFound28 = (short)(1) ;
         initializeNonKey0K28( ) ;
         A6SecUserId = T000K3_A6SecUserId[0] ;
         Z36DrogueriaId = A36DrogueriaId ;
         Z6SecUserId = A6SecUserId ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0K28( ) ;
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound28 = (short)(0) ;
         initializeNonKey0K28( ) ;
         sMode28 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0K28( ) ;
         Gx_mode = sMode28 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0K28( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0K28( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000K2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A36DrogueriaId), Short.valueOf(A6SecUserId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"DrogueriaUsuarios"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"DrogueriaUsuarios"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0K28( )
   {
      beforeValidate0K28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0K28( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0K28( 0) ;
         checkOptimisticConcurrency0K28( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0K28( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0K28( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000K19 */
                  pr_default.execute(17, new Object[] {Short.valueOf(A36DrogueriaId), Short.valueOf(A6SecUserId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("DrogueriaUsuarios");
                  if ( (pr_default.getStatus(17) == 1) )
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
            load0K28( ) ;
         }
         endLevel0K28( ) ;
      }
      closeExtendedTableCursors0K28( ) ;
   }

   public void update0K28( )
   {
      beforeValidate0K28( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0K28( ) ;
      }
      if ( ( nIsMod_28 != 0 ) || ( nIsDirty_28 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0K28( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0K28( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0K28( ) ;
                  if ( AnyError == 0 )
                  {
                     /* No attributes to update on table [DrogueriaUsuarios] */
                     deferredUpdate0K28( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0K28( ) ;
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
            endLevel0K28( ) ;
         }
      }
      closeExtendedTableCursors0K28( ) ;
   }

   public void deferredUpdate0K28( )
   {
   }

   public void delete0K28( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0K28( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0K28( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0K28( ) ;
         afterConfirm0K28( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0K28( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000K20 */
               pr_default.execute(18, new Object[] {Short.valueOf(A36DrogueriaId), Short.valueOf(A6SecUserId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("DrogueriaUsuarios");
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
      sMode28 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0K28( ) ;
      Gx_mode = sMode28 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0K28( )
   {
      standaloneModal0K28( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000K21 */
         pr_default.execute(19, new Object[] {Short.valueOf(A6SecUserId)});
         A14SecUserName = T000K21_A14SecUserName[0] ;
         pr_default.close(19);
      }
   }

   public void endLevel0K28( )
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

   public void scanStart0K28( )
   {
      /* Scan By routine */
      /* Using cursor T000K22 */
      pr_default.execute(20, new Object[] {Short.valueOf(A36DrogueriaId)});
      RcdFound28 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A6SecUserId = T000K22_A6SecUserId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0K28( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound28 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound28 = (short)(1) ;
         A6SecUserId = T000K22_A6SecUserId[0] ;
      }
   }

   public void scanEnd0K28( )
   {
      pr_default.close(20);
   }

   public void afterConfirm0K28( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0K28( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0K28( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0K28( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0K28( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0K28( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0K28( )
   {
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_55_Refreshing);
      edtSecUserName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserName_Enabled), 5, 0), !bGXsfl_55_Refreshing);
   }

   public void send_integrity_lvl_hashes0K28( )
   {
   }

   public void send_integrity_lvl_hashes0K27( )
   {
   }

   public void subsflControlProps_5528( )
   {
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_55_idx ;
      edtSecUserName_Internalname = "SECUSERNAME_"+sGXsfl_55_idx ;
   }

   public void subsflControlProps_fel_5528( )
   {
      edtSecUserId_Internalname = "SECUSERID_"+sGXsfl_55_fel_idx ;
      edtSecUserName_Internalname = "SECUSERNAME_"+sGXsfl_55_fel_idx ;
   }

   public void addRow0K28( )
   {
      nGXsfl_55_idx = (int)(nGXsfl_55_idx+1) ;
      sGXsfl_55_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_55_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5528( ) ;
      sendRow0K28( ) ;
   }

   public void sendRow0K28( )
   {
      Gridlevel_usuariosRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_usuarios_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_usuarios_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_usuarios_Class, "") != 0 )
         {
            subGridlevel_usuarios_Linesclass = subGridlevel_usuarios_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_usuarios_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_usuarios_Backstyle = (byte)(0) ;
         subGridlevel_usuarios_Backcolor = subGridlevel_usuarios_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_usuarios_Class, "") != 0 )
         {
            subGridlevel_usuarios_Linesclass = subGridlevel_usuarios_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_usuarios_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_usuarios_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_usuarios_Class, "") != 0 )
         {
            subGridlevel_usuarios_Linesclass = subGridlevel_usuarios_Class+"Odd" ;
         }
         subGridlevel_usuarios_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_usuarios_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_usuarios_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_55_idx) % (2))) == 0 )
         {
            subGridlevel_usuarios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_usuarios_Class, "") != 0 )
            {
               subGridlevel_usuarios_Linesclass = subGridlevel_usuarios_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_usuarios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_usuarios_Class, "") != 0 )
            {
               subGridlevel_usuarios_Linesclass = subGridlevel_usuarios_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_28_" + sGXsfl_55_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 56,'',false,'" + sGXsfl_55_idx + "',55)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_usuariosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecUserId_Internalname,GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,56);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecUserId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSecUserId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(55),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"",edtSecUserId_Horizontalalignment,Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_usuariosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecUserName_Internalname,A14SecUserName,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecUserName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSecUserName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(55),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridlevel_usuariosRow);
      send_integrity_lvl_hashes0K28( ) ;
      GXCCtl = "Z6SecUserId_" + sGXsfl_55_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdDeleted_28_" + sGXsfl_55_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_28, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_28_" + sGXsfl_55_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_28, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_28_" + sGXsfl_55_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_28, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "vMODE_" + sGXsfl_55_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_55_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV10TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV10TrnContext);
      }
      GXCCtl = "vDROGUERIAID_" + sGXsfl_55_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV17DrogueriaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERID_"+sGXsfl_55_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERID_"+sGXsfl_55_idx+"Horizontalalignment", GXutil.rtrim( edtSecUserId_Horizontalalignment));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECUSERNAME_"+sGXsfl_55_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecUserName_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_usuariosContainer.AddRow(Gridlevel_usuariosRow);
   }

   public void readRow0K28( )
   {
      nGXsfl_55_idx = (int)(nGXsfl_55_idx+1) ;
      sGXsfl_55_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_55_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5528( ) ;
      edtSecUserId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERID_"+sGXsfl_55_idx+"Enabled"), ",", ".")) ;
      edtSecUserId_Horizontalalignment = httpContext.cgiGet( "SECUSERID_"+sGXsfl_55_idx+"Horizontalalignment") ;
      edtSecUserName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECUSERNAME_"+sGXsfl_55_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") > 9999 ) ) )
      {
         GXCCtl = "SECUSERID_" + sGXsfl_55_idx ;
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
      GXCCtl = "Z6SecUserId_" + sGXsfl_55_idx ;
      Z6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdDeleted_28_" + sGXsfl_55_idx ;
      nRcdDeleted_28 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_28_" + sGXsfl_55_idx ;
      nRcdExists_28 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_28_" + sGXsfl_55_idx ;
      nIsMod_28 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void assign_properties_default( )
   {
      defedtSecUserId_Enabled = edtSecUserId_Enabled ;
   }

   public void confirmValues0K0( )
   {
      nGXsfl_55_idx = 0 ;
      sGXsfl_55_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_55_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5528( ) ;
      while ( nGXsfl_55_idx < nRC_GXsfl_55 )
      {
         nGXsfl_55_idx = (int)(nGXsfl_55_idx+1) ;
         sGXsfl_55_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_55_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5528( ) ;
         httpContext.changePostValue( "Z6SecUserId_"+sGXsfl_55_idx, httpContext.cgiGet( "ZT_"+"Z6SecUserId_"+sGXsfl_55_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z6SecUserId_"+sGXsfl_55_idx) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110324380", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.drogueria", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV17DrogueriaId,4,0))}, new String[] {"Gx_mode","DrogueriaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Drogueria");
      forbiddenHiddens.add("DrogueriaId", localUtil.format( DecimalUtil.doubleToDec(A36DrogueriaId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("drogueria:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z36DrogueriaId", GXutil.ltrim( localUtil.ntoc( Z36DrogueriaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z141DrogueriaNombre", Z141DrogueriaNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z142DrogueriaDescripcion", Z142DrogueriaDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z143DrogueriaTipoDocumento", GXutil.rtrim( Z143DrogueriaTipoDocumento));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z144DrogueriaNroDocumento", Z144DrogueriaNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z145DrogueriaDireccion", Z145DrogueriaDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z147DrogueriaEstado", GXutil.rtrim( Z147DrogueriaEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_55", GXutil.ltrim( localUtil.ntoc( nGXsfl_55_idx, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV13DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV13DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSERID_DATA", AV12SecUserId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSERID_DATA", AV12SecUserId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDROGUERIAID", GXutil.ltrim( localUtil.ntoc( AV17DrogueriaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDROGUERIAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17DrogueriaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV18Pgmname));
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
      return formatLink("com.projectthani.drogueria", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV17DrogueriaId,4,0))}, new String[] {"Gx_mode","DrogueriaId"})  ;
   }

   public String getPgmname( )
   {
      return "Drogueria" ;
   }

   public String getPgmdesc( )
   {
      return "Drogueria" ;
   }

   public void initializeNonKey0K27( )
   {
      A141DrogueriaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A141DrogueriaNombre", A141DrogueriaNombre);
      A142DrogueriaDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A142DrogueriaDescripcion", A142DrogueriaDescripcion);
      A143DrogueriaTipoDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A143DrogueriaTipoDocumento", A143DrogueriaTipoDocumento);
      A144DrogueriaNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A144DrogueriaNroDocumento", A144DrogueriaNroDocumento);
      A145DrogueriaDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A145DrogueriaDireccion", A145DrogueriaDireccion);
      A147DrogueriaEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A147DrogueriaEstado", A147DrogueriaEstado);
      Z141DrogueriaNombre = "" ;
      Z142DrogueriaDescripcion = "" ;
      Z143DrogueriaTipoDocumento = "" ;
      Z144DrogueriaNroDocumento = "" ;
      Z145DrogueriaDireccion = "" ;
      Z147DrogueriaEstado = "" ;
   }

   public void initAll0K27( )
   {
      A36DrogueriaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A36DrogueriaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A36DrogueriaId), 4, 0));
      initializeNonKey0K27( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0K28( )
   {
      A14SecUserName = "" ;
   }

   public void initAll0K28( )
   {
      A6SecUserId = (short)(0) ;
      initializeNonKey0K28( ) ;
   }

   public void standaloneModalInsert0K28( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511032440", true, true);
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
      httpContext.AddJavascriptSource("drogueria.js", "?2022511032441", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties28( )
   {
      edtSecUserId_Enabled = defedtSecUserId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), !bGXsfl_55_Refreshing);
   }

   public void init_default_properties( )
   {
      edtDrogueriaId_Internalname = "DROGUERIAID" ;
      edtDrogueriaNombre_Internalname = "DROGUERIANOMBRE" ;
      edtDrogueriaDescripcion_Internalname = "DROGUERIADESCRIPCION" ;
      cmbDrogueriaTipoDocumento.setInternalname( "DROGUERIATIPODOCUMENTO" );
      edtDrogueriaNroDocumento_Internalname = "DROGUERIANRODOCUMENTO" ;
      edtDrogueriaDireccion_Internalname = "DROGUERIADIRECCION" ;
      cmbDrogueriaEstado.setInternalname( "DROGUERIAESTADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      edtSecUserName_Internalname = "SECUSERNAME" ;
      divTableleaflevel_usuarios_Internalname = "TABLELEAFLEVEL_USUARIOS" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_secuserid_Internalname = "COMBO_SECUSERID" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_usuarios_Internalname = "GRIDLEVEL_USUARIOS" ;
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
      Form.setCaption( "Drogueria" );
      edtSecUserName_Jsonclick = "" ;
      edtSecUserId_Jsonclick = "" ;
      subGridlevel_usuarios_Class = "GridNoBorder WorkWith" ;
      subGridlevel_usuarios_Backcolorstyle = (byte)(0) ;
      Combo_secuserid_Titlecontrolidtoreplace = "" ;
      subGridlevel_usuarios_Allowcollapsing = (byte)(0) ;
      subGridlevel_usuarios_Allowselection = (byte)(0) ;
      edtSecUserName_Enabled = 0 ;
      edtSecUserId_Enabled = 1 ;
      subGridlevel_usuarios_Header = "" ;
      Combo_secuserid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_secuserid_Datalistprocparametersprefix = " \"ComboName\": \"SecUserId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"DrogueriaId\": 0" ;
      Combo_secuserid_Datalistproc = "DrogueriaLoadDVCombo" ;
      Combo_secuserid_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_secuserid_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_secuserid_Cls = "ExtendedCombo" ;
      Combo_secuserid_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbDrogueriaEstado.setJsonclick( "" );
      cmbDrogueriaEstado.setEnabled( 1 );
      edtDrogueriaDireccion_Jsonclick = "" ;
      edtDrogueriaDireccion_Enabled = 1 ;
      edtDrogueriaNroDocumento_Jsonclick = "" ;
      edtDrogueriaNroDocumento_Enabled = 1 ;
      cmbDrogueriaTipoDocumento.setJsonclick( "" );
      cmbDrogueriaTipoDocumento.setEnabled( 1 );
      edtDrogueriaDescripcion_Jsonclick = "" ;
      edtDrogueriaDescripcion_Enabled = 1 ;
      edtDrogueriaNombre_Jsonclick = "" ;
      edtDrogueriaNombre_Enabled = 1 ;
      edtDrogueriaId_Jsonclick = "" ;
      edtDrogueriaId_Enabled = 0 ;
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

   public void gxnrgridlevel_usuarios_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_5528( ) ;
      while ( nGXsfl_55_idx <= nRC_GXsfl_55 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0K28( ) ;
         standaloneModal0K28( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0K28( ) ;
         nGXsfl_55_idx = (int)(nGXsfl_55_idx+1) ;
         sGXsfl_55_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_55_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5528( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_usuariosContainer)) ;
      /* End function gxnrGridlevel_usuarios_newrow */
   }

   public void init_web_controls( )
   {
      cmbDrogueriaTipoDocumento.setName( "DROGUERIATIPODOCUMENTO" );
      cmbDrogueriaTipoDocumento.setWebtags( "" );
      cmbDrogueriaTipoDocumento.addItem("1", "DNI", (short)(0));
      cmbDrogueriaTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbDrogueriaTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbDrogueriaTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbDrogueriaTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbDrogueriaTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbDrogueriaTipoDocumento.getItemCount() > 0 )
      {
         A143DrogueriaTipoDocumento = cmbDrogueriaTipoDocumento.getValidValue(A143DrogueriaTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A143DrogueriaTipoDocumento", A143DrogueriaTipoDocumento);
      }
      cmbDrogueriaEstado.setName( "DROGUERIAESTADO" );
      cmbDrogueriaEstado.setWebtags( "" );
      cmbDrogueriaEstado.addItem("A", "Activo", (short)(0));
      cmbDrogueriaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbDrogueriaEstado.getItemCount() > 0 )
      {
         A147DrogueriaEstado = cmbDrogueriaEstado.getValidValue(A147DrogueriaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A147DrogueriaEstado", A147DrogueriaEstado);
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
      /* Using cursor T000K21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
      }
      A14SecUserName = T000K21_A14SecUserName[0] ;
      pr_default.close(19);
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV17DrogueriaId',fld:'vDROGUERIAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV17DrogueriaId',fld:'vDROGUERIAID',pic:'ZZZ9',hsh:true},{av:'A36DrogueriaId',fld:'DROGUERIAID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120K2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_DROGUERIAID","{handler:'valid_Drogueriaid',iparms:[]");
      setEventMetadata("VALID_DROGUERIAID",",oparms:[]}");
      setEventMetadata("VALID_DROGUERIATIPODOCUMENTO","{handler:'valid_Drogueriatipodocumento',iparms:[]");
      setEventMetadata("VALID_DROGUERIATIPODOCUMENTO",",oparms:[]}");
      setEventMetadata("VALID_DROGUERIAESTADO","{handler:'valid_Drogueriaestado',iparms:[]");
      setEventMetadata("VALID_DROGUERIAESTADO",",oparms:[]}");
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
      pr_default.close(19);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z141DrogueriaNombre = "" ;
      Z142DrogueriaDescripcion = "" ;
      Z143DrogueriaTipoDocumento = "" ;
      Z144DrogueriaNroDocumento = "" ;
      Z145DrogueriaDireccion = "" ;
      Z147DrogueriaEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A143DrogueriaTipoDocumento = "" ;
      A147DrogueriaEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A141DrogueriaNombre = "" ;
      A142DrogueriaDescripcion = "" ;
      A144DrogueriaNroDocumento = "" ;
      A145DrogueriaDireccion = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_secuserid = new com.genexus.webpanels.GXUserControl();
      AV13DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV12SecUserId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      Gridlevel_usuariosContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_usuariosColumn = new com.genexus.webpanels.GXWebColumn();
      A14SecUserName = "" ;
      sMode28 = "" ;
      sStyleString = "" ;
      AV18Pgmname = "" ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode27 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      AV7WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV10TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      T000K7_A36DrogueriaId = new short[1] ;
      T000K7_A141DrogueriaNombre = new String[] {""} ;
      T000K7_A142DrogueriaDescripcion = new String[] {""} ;
      T000K7_A143DrogueriaTipoDocumento = new String[] {""} ;
      T000K7_A144DrogueriaNroDocumento = new String[] {""} ;
      T000K7_A145DrogueriaDireccion = new String[] {""} ;
      T000K7_A147DrogueriaEstado = new String[] {""} ;
      T000K8_A36DrogueriaId = new short[1] ;
      T000K6_A36DrogueriaId = new short[1] ;
      T000K6_A141DrogueriaNombre = new String[] {""} ;
      T000K6_A142DrogueriaDescripcion = new String[] {""} ;
      T000K6_A143DrogueriaTipoDocumento = new String[] {""} ;
      T000K6_A144DrogueriaNroDocumento = new String[] {""} ;
      T000K6_A145DrogueriaDireccion = new String[] {""} ;
      T000K6_A147DrogueriaEstado = new String[] {""} ;
      T000K9_A36DrogueriaId = new short[1] ;
      T000K10_A36DrogueriaId = new short[1] ;
      T000K5_A36DrogueriaId = new short[1] ;
      T000K5_A141DrogueriaNombre = new String[] {""} ;
      T000K5_A142DrogueriaDescripcion = new String[] {""} ;
      T000K5_A143DrogueriaTipoDocumento = new String[] {""} ;
      T000K5_A144DrogueriaNroDocumento = new String[] {""} ;
      T000K5_A145DrogueriaDireccion = new String[] {""} ;
      T000K5_A147DrogueriaEstado = new String[] {""} ;
      T000K11_A36DrogueriaId = new short[1] ;
      T000K14_A25PetitorioId = new short[1] ;
      T000K15_A36DrogueriaId = new short[1] ;
      Z14SecUserName = "" ;
      T000K16_A36DrogueriaId = new short[1] ;
      T000K16_A14SecUserName = new String[] {""} ;
      T000K16_A6SecUserId = new short[1] ;
      T000K4_A14SecUserName = new String[] {""} ;
      T000K17_A14SecUserName = new String[] {""} ;
      T000K18_A36DrogueriaId = new short[1] ;
      T000K18_A6SecUserId = new short[1] ;
      T000K3_A36DrogueriaId = new short[1] ;
      T000K3_A6SecUserId = new short[1] ;
      T000K2_A36DrogueriaId = new short[1] ;
      T000K2_A6SecUserId = new short[1] ;
      T000K21_A14SecUserName = new String[] {""} ;
      T000K22_A36DrogueriaId = new short[1] ;
      T000K22_A6SecUserId = new short[1] ;
      Gridlevel_usuariosRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_usuarios_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.drogueria__default(),
         new Object[] {
             new Object[] {
            T000K2_A36DrogueriaId, T000K2_A6SecUserId
            }
            , new Object[] {
            T000K3_A36DrogueriaId, T000K3_A6SecUserId
            }
            , new Object[] {
            T000K4_A14SecUserName
            }
            , new Object[] {
            T000K5_A36DrogueriaId, T000K5_A141DrogueriaNombre, T000K5_A142DrogueriaDescripcion, T000K5_A143DrogueriaTipoDocumento, T000K5_A144DrogueriaNroDocumento, T000K5_A145DrogueriaDireccion, T000K5_A147DrogueriaEstado
            }
            , new Object[] {
            T000K6_A36DrogueriaId, T000K6_A141DrogueriaNombre, T000K6_A142DrogueriaDescripcion, T000K6_A143DrogueriaTipoDocumento, T000K6_A144DrogueriaNroDocumento, T000K6_A145DrogueriaDireccion, T000K6_A147DrogueriaEstado
            }
            , new Object[] {
            T000K7_A36DrogueriaId, T000K7_A141DrogueriaNombre, T000K7_A142DrogueriaDescripcion, T000K7_A143DrogueriaTipoDocumento, T000K7_A144DrogueriaNroDocumento, T000K7_A145DrogueriaDireccion, T000K7_A147DrogueriaEstado
            }
            , new Object[] {
            T000K8_A36DrogueriaId
            }
            , new Object[] {
            T000K9_A36DrogueriaId
            }
            , new Object[] {
            T000K10_A36DrogueriaId
            }
            , new Object[] {
            T000K11_A36DrogueriaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000K14_A25PetitorioId
            }
            , new Object[] {
            T000K15_A36DrogueriaId
            }
            , new Object[] {
            T000K16_A36DrogueriaId, T000K16_A14SecUserName, T000K16_A6SecUserId
            }
            , new Object[] {
            T000K17_A14SecUserName
            }
            , new Object[] {
            T000K18_A36DrogueriaId, T000K18_A6SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000K21_A14SecUserName
            }
            , new Object[] {
            T000K22_A36DrogueriaId, T000K22_A6SecUserId
            }
         }
      );
      AV18Pgmname = "Drogueria" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte subGridlevel_usuarios_Backcolorstyle ;
   private byte subGridlevel_usuarios_Allowselection ;
   private byte subGridlevel_usuarios_Allowhovering ;
   private byte subGridlevel_usuarios_Allowcollapsing ;
   private byte subGridlevel_usuarios_Collapsed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_usuarios_Backstyle ;
   private byte gxajaxcallmode ;
   private short wcpOAV17DrogueriaId ;
   private short Z36DrogueriaId ;
   private short Z6SecUserId ;
   private short nRcdDeleted_28 ;
   private short nRcdExists_28 ;
   private short nIsMod_28 ;
   private short A6SecUserId ;
   private short AV17DrogueriaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A36DrogueriaId ;
   private short nBlankRcdCount28 ;
   private short RcdFound28 ;
   private short nBlankRcdUsr28 ;
   private short RcdFound27 ;
   private short nIsDirty_27 ;
   private short nIsDirty_28 ;
   private int nRC_GXsfl_55 ;
   private int nGXsfl_55_idx=1 ;
   private int trnEnded ;
   private int edtDrogueriaId_Enabled ;
   private int edtDrogueriaNombre_Enabled ;
   private int edtDrogueriaDescripcion_Enabled ;
   private int edtDrogueriaNroDocumento_Enabled ;
   private int edtDrogueriaDireccion_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtSecUserId_Enabled ;
   private int edtSecUserName_Enabled ;
   private int subGridlevel_usuarios_Selectedindex ;
   private int subGridlevel_usuarios_Selectioncolor ;
   private int subGridlevel_usuarios_Hoveringcolor ;
   private int fRowAdded ;
   private int Combo_secuserid_Datalistupdateminimumcharacters ;
   private int GX_JID ;
   private int subGridlevel_usuarios_Backcolor ;
   private int subGridlevel_usuarios_Allbackcolor ;
   private int defedtSecUserId_Enabled ;
   private int idxLst ;
   private long GRIDLEVEL_USUARIOS_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z143DrogueriaTipoDocumento ;
   private String Z147DrogueriaEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_55_idx="0001" ;
   private String edtSecUserId_Horizontalalignment ;
   private String edtSecUserId_Internalname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtDrogueriaNombre_Internalname ;
   private String A143DrogueriaTipoDocumento ;
   private String A147DrogueriaEstado ;
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
   private String edtDrogueriaId_Internalname ;
   private String edtDrogueriaId_Jsonclick ;
   private String TempTags ;
   private String edtDrogueriaNombre_Jsonclick ;
   private String edtDrogueriaDescripcion_Internalname ;
   private String edtDrogueriaDescripcion_Jsonclick ;
   private String edtDrogueriaNroDocumento_Internalname ;
   private String edtDrogueriaNroDocumento_Jsonclick ;
   private String edtDrogueriaDireccion_Internalname ;
   private String edtDrogueriaDireccion_Jsonclick ;
   private String divTableleaflevel_usuarios_Internalname ;
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
   private String subGridlevel_usuarios_Header ;
   private String sMode28 ;
   private String edtSecUserName_Internalname ;
   private String sStyleString ;
   private String AV18Pgmname ;
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
   private String hsh ;
   private String sMode27 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_55_fel_idx="0001" ;
   private String subGridlevel_usuarios_Class ;
   private String subGridlevel_usuarios_Linesclass ;
   private String ROClassString ;
   private String edtSecUserId_Jsonclick ;
   private String edtSecUserName_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_usuarios_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_55_Refreshing=false ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
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
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String Z141DrogueriaNombre ;
   private String Z142DrogueriaDescripcion ;
   private String Z144DrogueriaNroDocumento ;
   private String Z145DrogueriaDireccion ;
   private String A141DrogueriaNombre ;
   private String A142DrogueriaDescripcion ;
   private String A144DrogueriaNroDocumento ;
   private String A145DrogueriaDireccion ;
   private String A14SecUserName ;
   private String Z14SecUserName ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_usuariosContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_usuariosRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_usuariosColumn ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_secuserid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbDrogueriaTipoDocumento ;
   private HTMLChoice cmbDrogueriaEstado ;
   private IDataStoreProvider pr_default ;
   private short[] T000K7_A36DrogueriaId ;
   private String[] T000K7_A141DrogueriaNombre ;
   private String[] T000K7_A142DrogueriaDescripcion ;
   private String[] T000K7_A143DrogueriaTipoDocumento ;
   private String[] T000K7_A144DrogueriaNroDocumento ;
   private String[] T000K7_A145DrogueriaDireccion ;
   private String[] T000K7_A147DrogueriaEstado ;
   private short[] T000K8_A36DrogueriaId ;
   private short[] T000K6_A36DrogueriaId ;
   private String[] T000K6_A141DrogueriaNombre ;
   private String[] T000K6_A142DrogueriaDescripcion ;
   private String[] T000K6_A143DrogueriaTipoDocumento ;
   private String[] T000K6_A144DrogueriaNroDocumento ;
   private String[] T000K6_A145DrogueriaDireccion ;
   private String[] T000K6_A147DrogueriaEstado ;
   private short[] T000K9_A36DrogueriaId ;
   private short[] T000K10_A36DrogueriaId ;
   private short[] T000K5_A36DrogueriaId ;
   private String[] T000K5_A141DrogueriaNombre ;
   private String[] T000K5_A142DrogueriaDescripcion ;
   private String[] T000K5_A143DrogueriaTipoDocumento ;
   private String[] T000K5_A144DrogueriaNroDocumento ;
   private String[] T000K5_A145DrogueriaDireccion ;
   private String[] T000K5_A147DrogueriaEstado ;
   private short[] T000K11_A36DrogueriaId ;
   private short[] T000K14_A25PetitorioId ;
   private short[] T000K15_A36DrogueriaId ;
   private short[] T000K16_A36DrogueriaId ;
   private String[] T000K16_A14SecUserName ;
   private short[] T000K16_A6SecUserId ;
   private String[] T000K4_A14SecUserName ;
   private String[] T000K17_A14SecUserName ;
   private short[] T000K18_A36DrogueriaId ;
   private short[] T000K18_A6SecUserId ;
   private short[] T000K3_A36DrogueriaId ;
   private short[] T000K3_A6SecUserId ;
   private short[] T000K2_A36DrogueriaId ;
   private short[] T000K2_A6SecUserId ;
   private String[] T000K21_A14SecUserName ;
   private short[] T000K22_A36DrogueriaId ;
   private short[] T000K22_A6SecUserId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV12SecUserId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV13DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class drogueria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000K2", "SELECT [DrogueriaId], [SecUserId] FROM [DrogueriaUsuarios] WITH (UPDLOCK) WHERE [DrogueriaId] = ? AND [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K3", "SELECT [DrogueriaId], [SecUserId] FROM [DrogueriaUsuarios] WHERE [DrogueriaId] = ? AND [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K4", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K5", "SELECT [DrogueriaId], [DrogueriaNombre], [DrogueriaDescripcion], [DrogueriaTipoDocumento], [DrogueriaNroDocumento], [DrogueriaDireccion], [DrogueriaEstado] FROM [Drogueria] WITH (UPDLOCK) WHERE [DrogueriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K6", "SELECT [DrogueriaId], [DrogueriaNombre], [DrogueriaDescripcion], [DrogueriaTipoDocumento], [DrogueriaNroDocumento], [DrogueriaDireccion], [DrogueriaEstado] FROM [Drogueria] WHERE [DrogueriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K7", "SELECT TM1.[DrogueriaId], TM1.[DrogueriaNombre], TM1.[DrogueriaDescripcion], TM1.[DrogueriaTipoDocumento], TM1.[DrogueriaNroDocumento], TM1.[DrogueriaDireccion], TM1.[DrogueriaEstado] FROM [Drogueria] TM1 WHERE TM1.[DrogueriaId] = ? ORDER BY TM1.[DrogueriaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K8", "SELECT [DrogueriaId] FROM [Drogueria] WHERE [DrogueriaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K9", "SELECT TOP 1 [DrogueriaId] FROM [Drogueria] WHERE ( [DrogueriaId] > ?) ORDER BY [DrogueriaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000K10", "SELECT TOP 1 [DrogueriaId] FROM [Drogueria] WHERE ( [DrogueriaId] < ?) ORDER BY [DrogueriaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000K11", "INSERT INTO [Drogueria]([DrogueriaNombre], [DrogueriaDescripcion], [DrogueriaTipoDocumento], [DrogueriaNroDocumento], [DrogueriaDireccion], [DrogueriaEstado]) VALUES(?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000K12", "UPDATE [Drogueria] SET [DrogueriaNombre]=?, [DrogueriaDescripcion]=?, [DrogueriaTipoDocumento]=?, [DrogueriaNroDocumento]=?, [DrogueriaDireccion]=?, [DrogueriaEstado]=?  WHERE [DrogueriaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000K13", "DELETE FROM [Drogueria]  WHERE [DrogueriaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000K14", "SELECT TOP 1 [PetitorioId] FROM [Petitorio] WHERE [DrogueriaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000K15", "SELECT [DrogueriaId] FROM [Drogueria] ORDER BY [DrogueriaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K16", "SELECT T1.[DrogueriaId], T2.[SecUserName], T1.[SecUserId] FROM ([DrogueriaUsuarios] T1 INNER JOIN [SecUser] T2 ON T2.[SecUserId] = T1.[SecUserId]) WHERE T1.[DrogueriaId] = ? and T1.[SecUserId] = ? ORDER BY T1.[DrogueriaId], T1.[SecUserId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K17", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K18", "SELECT [DrogueriaId], [SecUserId] FROM [DrogueriaUsuarios] WHERE [DrogueriaId] = ? AND [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000K19", "INSERT INTO [DrogueriaUsuarios]([DrogueriaId], [SecUserId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000K20", "DELETE FROM [DrogueriaUsuarios]  WHERE [DrogueriaId] = ? AND [SecUserId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000K21", "SELECT [SecUserName] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000K22", "SELECT [DrogueriaId], [SecUserId] FROM [DrogueriaUsuarios] WHERE [DrogueriaId] = ? ORDER BY [DrogueriaId], [SecUserId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
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
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
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
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 15, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setString(6, (String)parms[5], 1);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 80, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setVarchar(4, (String)parms[3], 15, false);
               stmt.setVarchar(5, (String)parms[4], 100, false);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

