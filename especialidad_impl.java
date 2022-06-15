package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class especialidad_impl extends GXDataArea
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
         A38SGEspecialidadSedeId = (short)(GXutil.lval( httpContext.GetPar( "SGEspecialidadSedeId"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_7( A38SGEspecialidadSedeId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_8") == 0 )
      {
         A158SGEspecialidadSedeClinicaid = (short)(GXutil.lval( httpContext.GetPar( "SGEspecialidadSedeClinicaid"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_8( A158SGEspecialidadSedeClinicaid) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_sede") == 0 )
      {
         nRC_GXsfl_53 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_53"))) ;
         nGXsfl_53_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_53_idx"))) ;
         sGXsfl_53_idx = httpContext.GetPar( "sGXsfl_53_idx") ;
         edtSGEspecialidadSedeId_Horizontalalignment = httpContext.GetNextPar( ) ;
         httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Horizontalalignment", edtSGEspecialidadSedeId_Horizontalalignment, !bGXsfl_53_Refreshing);
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridlevel_sede_newrow( ) ;
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
            AV15EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EspecialidadId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EspecialidadId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Especialidad", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEspecialidadNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public especialidad_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public especialidad_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( especialidad_impl.class ));
   }

   public especialidad_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbEspecialidadEstado = new HTMLChoice();
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
      if ( cmbEspecialidadEstado.getItemCount() > 0 )
      {
         A156EspecialidadEstado = cmbEspecialidadEstado.getValidValue(A156EspecialidadEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A156EspecialidadEstado", A156EspecialidadEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEspecialidadEstado.setValue( GXutil.rtrim( A156EspecialidadEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEspecialidadEstado.getInternalname(), "Values", cmbEspecialidadEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtEspecialidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEspecialidadId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Especialidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadNombre_Internalname, "Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadNombre_Internalname, A71EspecialidadNombre, GXutil.rtrim( localUtil.format( A71EspecialidadNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEspecialidadNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Especialidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadDescripcion_Internalname, "Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtEspecialidadDescripcion_Internalname, A154EspecialidadDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtEspecialidadDescripcion_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Especialidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadCodigo_Internalname, "Codigo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadCodigo_Internalname, A140EspecialidadCodigo, GXutil.rtrim( localUtil.format( A140EspecialidadCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEspecialidadCodigo_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Especialidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgEspecialidadFoto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Foto", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      A155EspecialidadFoto_IsBlob = (boolean)(((GXutil.strcmp("", A155EspecialidadFoto)==0)&&(GXutil.strcmp("", A40000EspecialidadFoto_GXI)==0))||!(GXutil.strcmp("", A155EspecialidadFoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.getResourceRelative(A155EspecialidadFoto)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgEspecialidadFoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgEspecialidadFoto_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", "", "", 0, A155EspecialidadFoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Especialidad.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "URL", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.getResourceRelative(A155EspecialidadFoto)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "IsBlob", GXutil.booltostr( A155EspecialidadFoto_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEspecialidadEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEspecialidadEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEspecialidadEstado, cmbEspecialidadEstado.getInternalname(), GXutil.rtrim( A156EspecialidadEstado), 1, cmbEspecialidadEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEspecialidadEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(1), "HLP_Especialidad.htm");
      cmbEspecialidadEstado.setValue( GXutil.rtrim( A156EspecialidadEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEspecialidadEstado.getInternalname(), "Values", cmbEspecialidadEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTableleaflevel_sede_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      gxdraw_gridlevel_sede( ) ;
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Especialidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Especialidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Especialidad.htm");
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
      ucCombo_sgespecialidadsedeid.setProperty("Caption", Combo_sgespecialidadsedeid_Caption);
      ucCombo_sgespecialidadsedeid.setProperty("Cls", Combo_sgespecialidadsedeid_Cls);
      ucCombo_sgespecialidadsedeid.setProperty("IsGridItem", Combo_sgespecialidadsedeid_Isgriditem);
      ucCombo_sgespecialidadsedeid.setProperty("HasDescription", Combo_sgespecialidadsedeid_Hasdescription);
      ucCombo_sgespecialidadsedeid.setProperty("DataListProc", Combo_sgespecialidadsedeid_Datalistproc);
      ucCombo_sgespecialidadsedeid.setProperty("DataListProcParametersPrefix", Combo_sgespecialidadsedeid_Datalistprocparametersprefix);
      ucCombo_sgespecialidadsedeid.setProperty("EmptyItem", Combo_sgespecialidadsedeid_Emptyitem);
      ucCombo_sgespecialidadsedeid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_sgespecialidadsedeid.setProperty("DropDownOptionsData", AV16SGEspecialidadSedeId_Data);
      ucCombo_sgespecialidadsedeid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_sgespecialidadsedeid_Internalname, "COMBO_SGESPECIALIDADSEDEIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridlevel_sede( )
   {
      /*  Grid Control  */
      Gridlevel_sedeContainer.AddObjectProperty("GridName", "Gridlevel_sede");
      Gridlevel_sedeContainer.AddObjectProperty("Header", subGridlevel_sede_Header);
      Gridlevel_sedeContainer.AddObjectProperty("Class", "GridNoBorder WorkWith");
      Gridlevel_sedeContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_sedeContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_sedeColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A38SGEspecialidadSedeId, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_sedeColumn.AddObjectProperty("Horizontalalignment", GXutil.rtrim( edtSGEspecialidadSedeId_Horizontalalignment));
      Gridlevel_sedeContainer.AddColumnProperties(Gridlevel_sedeColumn);
      Gridlevel_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_sedeColumn.AddObjectProperty("Value", A157SGEspecialidadSedeNombre);
      Gridlevel_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddColumnProperties(Gridlevel_sedeColumn);
      Gridlevel_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_sedeColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A158SGEspecialidadSedeClinicaid, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaid_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddColumnProperties(Gridlevel_sedeColumn);
      Gridlevel_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_sedeColumn.AddObjectProperty("Value", A159SGEspecialidadSedeClinicaNombre);
      Gridlevel_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddColumnProperties(Gridlevel_sedeColumn);
      Gridlevel_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_sedeColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A160SedeCostoConsulta, (byte)(6), (byte)(2), ".", "")));
      Gridlevel_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddColumnProperties(Gridlevel_sedeColumn);
      Gridlevel_sedeContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_sedeContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_sede_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_53_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount31 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_31 = (short)(1) ;
            scanStart0M31( ) ;
            while ( RcdFound31 != 0 )
            {
               init_level_properties31( ) ;
               getByPrimaryKey0M31( ) ;
               addRow0M31( ) ;
               scanNext0M31( ) ;
            }
            scanEnd0M31( ) ;
            nBlankRcdCount31 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0M31( ) ;
         standaloneModal0M31( ) ;
         sMode31 = Gx_mode ;
         while ( nGXsfl_53_idx < nRC_GXsfl_53 )
         {
            bGXsfl_53_Refreshing = true ;
            readRow0M31( ) ;
            edtSGEspecialidadSedeId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
            edtSGEspecialidadSedeId_Horizontalalignment = httpContext.cgiGet( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Horizontalalignment") ;
            httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Horizontalalignment", edtSGEspecialidadSedeId_Horizontalalignment, !bGXsfl_53_Refreshing);
            edtSGEspecialidadSedeNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDENOMBRE_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeNombre_Enabled), 5, 0), !bGXsfl_53_Refreshing);
            edtSGEspecialidadSedeClinicaid_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDECLINICAID_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeClinicaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeClinicaid_Enabled), 5, 0), !bGXsfl_53_Refreshing);
            edtSGEspecialidadSedeClinicaNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDECLINICANOMBRE_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeClinicaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeClinicaNombre_Enabled), 5, 0), !bGXsfl_53_Refreshing);
            edtSedeCostoConsulta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SEDECOSTOCONSULTA_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSedeCostoConsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeCostoConsulta_Enabled), 5, 0), !bGXsfl_53_Refreshing);
            if ( ( nRcdExists_31 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0M31( ) ;
            }
            sendRow0M31( ) ;
            bGXsfl_53_Refreshing = false ;
         }
         Gx_mode = sMode31 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount31 = (short)(5) ;
         nRcdExists_31 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0M31( ) ;
            while ( RcdFound31 != 0 )
            {
               sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_5331( ) ;
               init_level_properties31( ) ;
               standaloneNotModal0M31( ) ;
               getByPrimaryKey0M31( ) ;
               standaloneModal0M31( ) ;
               addRow0M31( ) ;
               scanNext0M31( ) ;
            }
            scanEnd0M31( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode31 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_5331( ) ;
         initAll0M31( ) ;
         init_level_properties31( ) ;
         nRcdExists_31 = (short)(0) ;
         nIsMod_31 = (short)(0) ;
         nRcdDeleted_31 = (short)(0) ;
         nBlankRcdCount31 = (short)(nBlankRcdUsr31+nBlankRcdCount31) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount31 > 0 )
         {
            standaloneNotModal0M31( ) ;
            standaloneModal0M31( ) ;
            addRow0M31( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount31 = (short)(nBlankRcdCount31-1) ;
         }
         Gx_mode = sMode31 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_sedeContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_sede", Gridlevel_sedeContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_sedeContainerData", Gridlevel_sedeContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_sedeContainerData"+"V", Gridlevel_sedeContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_sedeContainerData"+"V"+"\" value='"+Gridlevel_sedeContainer.GridValuesHidden()+"'/>") ;
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
      e110M2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSGESPECIALIDADSEDEID_DATA"), AV16SGEspecialidadSedeId_Data);
            /* Read saved values. */
            Z32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( "Z32EspecialidadId"), ",", ".")) ;
            Z71EspecialidadNombre = httpContext.cgiGet( "Z71EspecialidadNombre") ;
            Z154EspecialidadDescripcion = httpContext.cgiGet( "Z154EspecialidadDescripcion") ;
            Z140EspecialidadCodigo = httpContext.cgiGet( "Z140EspecialidadCodigo") ;
            Z156EspecialidadEstado = httpContext.cgiGet( "Z156EspecialidadEstado") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_53 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_53"), ",", ".")) ;
            AV15EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( "vESPECIALIDADID"), ",", ".")) ;
            A40000EspecialidadFoto_GXI = httpContext.cgiGet( "ESPECIALIDADFOTO_GXI") ;
            AV21Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            Combo_sgespecialidadsedeid_Objectcall = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Objectcall") ;
            Combo_sgespecialidadsedeid_Class = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Class") ;
            Combo_sgespecialidadsedeid_Icontype = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Icontype") ;
            Combo_sgespecialidadsedeid_Icon = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Icon") ;
            Combo_sgespecialidadsedeid_Caption = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Caption") ;
            Combo_sgespecialidadsedeid_Tooltip = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Tooltip") ;
            Combo_sgespecialidadsedeid_Cls = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Cls") ;
            Combo_sgespecialidadsedeid_Selectedvalue_set = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Selectedvalue_set") ;
            Combo_sgespecialidadsedeid_Selectedvalue_get = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Selectedvalue_get") ;
            Combo_sgespecialidadsedeid_Selectedtext_set = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Selectedtext_set") ;
            Combo_sgespecialidadsedeid_Selectedtext_get = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Selectedtext_get") ;
            Combo_sgespecialidadsedeid_Gamoauthtoken = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Gamoauthtoken") ;
            Combo_sgespecialidadsedeid_Ddointernalname = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Ddointernalname") ;
            Combo_sgespecialidadsedeid_Titlecontrolalign = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Titlecontrolalign") ;
            Combo_sgespecialidadsedeid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Dropdownoptionstype") ;
            Combo_sgespecialidadsedeid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Enabled")) ;
            Combo_sgespecialidadsedeid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Visible")) ;
            Combo_sgespecialidadsedeid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Titlecontrolidtoreplace") ;
            Combo_sgespecialidadsedeid_Datalisttype = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Datalisttype") ;
            Combo_sgespecialidadsedeid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Allowmultipleselection")) ;
            Combo_sgespecialidadsedeid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Datalistfixedvalues") ;
            Combo_sgespecialidadsedeid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Isgriditem")) ;
            Combo_sgespecialidadsedeid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Hasdescription")) ;
            Combo_sgespecialidadsedeid_Datalistproc = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Datalistproc") ;
            Combo_sgespecialidadsedeid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Datalistprocparametersprefix") ;
            Combo_sgespecialidadsedeid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_sgespecialidadsedeid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Includeonlyselectedoption")) ;
            Combo_sgespecialidadsedeid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Includeselectalloption")) ;
            Combo_sgespecialidadsedeid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Emptyitem")) ;
            Combo_sgespecialidadsedeid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Includeaddnewoption")) ;
            Combo_sgespecialidadsedeid_Htmltemplate = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Htmltemplate") ;
            Combo_sgespecialidadsedeid_Multiplevaluestype = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Multiplevaluestype") ;
            Combo_sgespecialidadsedeid_Loadingdata = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Loadingdata") ;
            Combo_sgespecialidadsedeid_Noresultsfound = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Noresultsfound") ;
            Combo_sgespecialidadsedeid_Emptyitemtext = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Emptyitemtext") ;
            Combo_sgespecialidadsedeid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Onlyselectedvalues") ;
            Combo_sgespecialidadsedeid_Selectalltext = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Selectalltext") ;
            Combo_sgespecialidadsedeid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Multiplevaluesseparator") ;
            Combo_sgespecialidadsedeid_Addnewoptiontext = httpContext.cgiGet( "COMBO_SGESPECIALIDADSEDEID_Addnewoptiontext") ;
            /* Read variables values. */
            A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
            A71EspecialidadNombre = httpContext.cgiGet( edtEspecialidadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
            A154EspecialidadDescripcion = httpContext.cgiGet( edtEspecialidadDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A154EspecialidadDescripcion", A154EspecialidadDescripcion);
            A140EspecialidadCodigo = httpContext.cgiGet( edtEspecialidadCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
            A155EspecialidadFoto = httpContext.cgiGet( imgEspecialidadFoto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A155EspecialidadFoto", A155EspecialidadFoto);
            cmbEspecialidadEstado.setName( cmbEspecialidadEstado.getInternalname() );
            cmbEspecialidadEstado.setValue( httpContext.cgiGet( cmbEspecialidadEstado.getInternalname()) );
            A156EspecialidadEstado = httpContext.cgiGet( cmbEspecialidadEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A156EspecialidadEstado", A156EspecialidadEstado);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A155EspecialidadFoto ;
            GXv_char2[0] = A40000EspecialidadFoto_GXI ;
            httpContext.getMultimediaValue(imgEspecialidadFoto_Internalname, GXv_char1, GXv_char2);
            especialidad_impl.this.A155EspecialidadFoto = GXv_char1[0] ;
            especialidad_impl.this.A40000EspecialidadFoto_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Especialidad");
            A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
            forbiddenHiddens.add("EspecialidadId", localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A32EspecialidadId != Z32EspecialidadId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("especialidad:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A32EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
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
                  sMode30 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode30 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound30 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0M0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ESPECIALIDADID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEspecialidadId_Internalname ;
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
                        e110M2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120M2 ();
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
         e120M2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0M30( ) ;
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
         disableAttributes0M30( ) ;
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

   public void confirm_0M0( )
   {
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0M30( ) ;
         }
         else
         {
            checkExtendedTable0M30( ) ;
            closeExtendedTableCursors0M30( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode30 = Gx_mode ;
         confirm_0M31( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode30 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode30 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0M31( )
   {
      nGXsfl_53_idx = 0 ;
      while ( nGXsfl_53_idx < nRC_GXsfl_53 )
      {
         readRow0M31( ) ;
         if ( ( nRcdExists_31 != 0 ) || ( nIsMod_31 != 0 ) )
         {
            getKey0M31( ) ;
            if ( ( nRcdExists_31 == 0 ) && ( nRcdDeleted_31 == 0 ) )
            {
               if ( RcdFound31 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0M31( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0M31( ) ;
                     closeExtendedTableCursors0M31( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "SGESPECIALIDADSEDEID_" + sGXsfl_53_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound31 != 0 )
               {
                  if ( nRcdDeleted_31 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0M31( ) ;
                     load0M31( ) ;
                     beforeValidate0M31( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0M31( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_31 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0M31( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0M31( ) ;
                           closeExtendedTableCursors0M31( ) ;
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
                  if ( nRcdDeleted_31 == 0 )
                  {
                     GXCCtl = "SGESPECIALIDADSEDEID_" + sGXsfl_53_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSGEspecialidadSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A38SGEspecialidadSedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSGEspecialidadSedeNombre_Internalname, A157SGEspecialidadSedeNombre) ;
         httpContext.changePostValue( edtSGEspecialidadSedeClinicaid_Internalname, GXutil.ltrim( localUtil.ntoc( A158SGEspecialidadSedeClinicaid, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSGEspecialidadSedeClinicaNombre_Internalname, A159SGEspecialidadSedeClinicaNombre) ;
         httpContext.changePostValue( edtSedeCostoConsulta_Internalname, GXutil.ltrim( localUtil.ntoc( A160SedeCostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z38SGEspecialidadSedeId_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( Z38SGEspecialidadSedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z160SedeCostoConsulta_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( Z160SedeCostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_31_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_31, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_31_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_31, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_31_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_31, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_31 != 0 )
         {
            httpContext.changePostValue( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Horizontalalignment", GXutil.rtrim( edtSGEspecialidadSedeId_Horizontalalignment)) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDENOMBRE_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDECLINICAID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaid_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDECLINICANOMBRE_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SEDECOSTOCONSULTA_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0M0( )
   {
   }

   public void e110M2( )
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
      Combo_sgespecialidadsedeid_Titlecontrolidtoreplace = edtSGEspecialidadSedeId_Internalname ;
      ucCombo_sgespecialidadsedeid.sendProperty(context, "", false, Combo_sgespecialidadsedeid_Internalname, "TitleControlIdToReplace", Combo_sgespecialidadsedeid_Titlecontrolidtoreplace);
      edtSGEspecialidadSedeId_Horizontalalignment = "Left" ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Horizontalalignment", edtSGEspecialidadSedeId_Horizontalalignment, !bGXsfl_53_Refreshing);
      AV8IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad_Insert", GXv_boolean7) ;
         especialidad_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad_Update", GXv_boolean7) ;
         especialidad_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV8IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEspecialidad_Delete", GXv_boolean7) ;
         especialidad_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV8IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV21Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
   }

   public void e120M2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.especialidadww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(5);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0M30( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z71EspecialidadNombre = T000M7_A71EspecialidadNombre[0] ;
            Z154EspecialidadDescripcion = T000M7_A154EspecialidadDescripcion[0] ;
            Z140EspecialidadCodigo = T000M7_A140EspecialidadCodigo[0] ;
            Z156EspecialidadEstado = T000M7_A156EspecialidadEstado[0] ;
         }
         else
         {
            Z71EspecialidadNombre = A71EspecialidadNombre ;
            Z154EspecialidadDescripcion = A154EspecialidadDescripcion ;
            Z140EspecialidadCodigo = A140EspecialidadCodigo ;
            Z156EspecialidadEstado = A156EspecialidadEstado ;
         }
      }
      if ( GX_JID == -5 )
      {
         Z32EspecialidadId = A32EspecialidadId ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
         Z154EspecialidadDescripcion = A154EspecialidadDescripcion ;
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z155EspecialidadFoto = A155EspecialidadFoto ;
         Z40000EspecialidadFoto_GXI = A40000EspecialidadFoto_GXI ;
         Z156EspecialidadEstado = A156EspecialidadEstado ;
      }
   }

   public void standaloneNotModal( )
   {
      edtEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), true);
      edtEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV15EspecialidadId) )
      {
         A32EspecialidadId = AV15EspecialidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
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

   public void load0M30( )
   {
      /* Using cursor T000M8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A71EspecialidadNombre = T000M8_A71EspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
         A154EspecialidadDescripcion = T000M8_A154EspecialidadDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A154EspecialidadDescripcion", A154EspecialidadDescripcion);
         A140EspecialidadCodigo = T000M8_A140EspecialidadCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
         A155EspecialidadFoto = T000M8_A155EspecialidadFoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A155EspecialidadFoto", A155EspecialidadFoto);
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
         A40000EspecialidadFoto_GXI = T000M8_A40000EspecialidadFoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
         A156EspecialidadEstado = T000M8_A156EspecialidadEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A156EspecialidadEstado", A156EspecialidadEstado);
         zm0M30( -5) ;
      }
      pr_default.close(6);
      onLoadActions0M30( ) ;
   }

   public void onLoadActions0M30( )
   {
      AV21Pgmname = "Especialidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
   }

   public void checkExtendedTable0M30( )
   {
      nIsDirty_30 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV21Pgmname = "Especialidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      if ( ! ( ( GXutil.strcmp(A156EspecialidadEstado, "A") == 0 ) || ( GXutil.strcmp(A156EspecialidadEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Especialidad Estado fuera de rango", "OutOfRange", 1, "ESPECIALIDADESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbEspecialidadEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0M30( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0M30( )
   {
      /* Using cursor T000M9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound30 = (short)(1) ;
      }
      else
      {
         RcdFound30 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000M7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm0M30( 5) ;
         RcdFound30 = (short)(1) ;
         A32EspecialidadId = T000M7_A32EspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         A71EspecialidadNombre = T000M7_A71EspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
         A154EspecialidadDescripcion = T000M7_A154EspecialidadDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A154EspecialidadDescripcion", A154EspecialidadDescripcion);
         A140EspecialidadCodigo = T000M7_A140EspecialidadCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
         A155EspecialidadFoto = T000M7_A155EspecialidadFoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A155EspecialidadFoto", A155EspecialidadFoto);
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
         A40000EspecialidadFoto_GXI = T000M7_A40000EspecialidadFoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
         A156EspecialidadEstado = T000M7_A156EspecialidadEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A156EspecialidadEstado", A156EspecialidadEstado);
         Z32EspecialidadId = A32EspecialidadId ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0M30( ) ;
         if ( AnyError == 1 )
         {
            RcdFound30 = (short)(0) ;
            initializeNonKey0M30( ) ;
         }
         Gx_mode = sMode30 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound30 = (short)(0) ;
         initializeNonKey0M30( ) ;
         sMode30 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode30 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(5);
   }

   public void getEqualNoModal( )
   {
      getKey0M30( ) ;
      if ( RcdFound30 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound30 = (short)(0) ;
      /* Using cursor T000M10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000M10_A32EspecialidadId[0] < A32EspecialidadId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000M10_A32EspecialidadId[0] > A32EspecialidadId ) ) )
         {
            A32EspecialidadId = T000M10_A32EspecialidadId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
            RcdFound30 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound30 = (short)(0) ;
      /* Using cursor T000M11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000M11_A32EspecialidadId[0] > A32EspecialidadId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000M11_A32EspecialidadId[0] < A32EspecialidadId ) ) )
         {
            A32EspecialidadId = T000M11_A32EspecialidadId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
            RcdFound30 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0M30( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEspecialidadNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0M30( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound30 == 1 )
         {
            if ( A32EspecialidadId != Z32EspecialidadId )
            {
               A32EspecialidadId = Z32EspecialidadId ;
               httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ESPECIALIDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEspecialidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEspecialidadNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0M30( ) ;
               GX_FocusControl = edtEspecialidadNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A32EspecialidadId != Z32EspecialidadId )
            {
               /* Insert record */
               GX_FocusControl = edtEspecialidadNombre_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0M30( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ESPECIALIDADID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEspecialidadId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtEspecialidadNombre_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0M30( ) ;
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
      if ( A32EspecialidadId != Z32EspecialidadId )
      {
         A32EspecialidadId = Z32EspecialidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEspecialidadNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0M30( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000M6 */
         pr_default.execute(4, new Object[] {Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Especialidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(4) == 101) || ( GXutil.strcmp(Z71EspecialidadNombre, T000M6_A71EspecialidadNombre[0]) != 0 ) || ( GXutil.strcmp(Z154EspecialidadDescripcion, T000M6_A154EspecialidadDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z140EspecialidadCodigo, T000M6_A140EspecialidadCodigo[0]) != 0 ) || ( GXutil.strcmp(Z156EspecialidadEstado, T000M6_A156EspecialidadEstado[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z71EspecialidadNombre, T000M6_A71EspecialidadNombre[0]) != 0 )
            {
               GXutil.writeLogln("especialidad:[seudo value changed for attri]"+"EspecialidadNombre");
               GXutil.writeLogRaw("Old: ",Z71EspecialidadNombre);
               GXutil.writeLogRaw("Current: ",T000M6_A71EspecialidadNombre[0]);
            }
            if ( GXutil.strcmp(Z154EspecialidadDescripcion, T000M6_A154EspecialidadDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("especialidad:[seudo value changed for attri]"+"EspecialidadDescripcion");
               GXutil.writeLogRaw("Old: ",Z154EspecialidadDescripcion);
               GXutil.writeLogRaw("Current: ",T000M6_A154EspecialidadDescripcion[0]);
            }
            if ( GXutil.strcmp(Z140EspecialidadCodigo, T000M6_A140EspecialidadCodigo[0]) != 0 )
            {
               GXutil.writeLogln("especialidad:[seudo value changed for attri]"+"EspecialidadCodigo");
               GXutil.writeLogRaw("Old: ",Z140EspecialidadCodigo);
               GXutil.writeLogRaw("Current: ",T000M6_A140EspecialidadCodigo[0]);
            }
            if ( GXutil.strcmp(Z156EspecialidadEstado, T000M6_A156EspecialidadEstado[0]) != 0 )
            {
               GXutil.writeLogln("especialidad:[seudo value changed for attri]"+"EspecialidadEstado");
               GXutil.writeLogRaw("Old: ",Z156EspecialidadEstado);
               GXutil.writeLogRaw("Current: ",T000M6_A156EspecialidadEstado[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Especialidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0M30( )
   {
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M30( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0M30( 0) ;
         checkOptimisticConcurrency0M30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0M30( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0M30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000M12 */
                  pr_default.execute(10, new Object[] {A71EspecialidadNombre, A154EspecialidadDescripcion, A140EspecialidadCodigo, A155EspecialidadFoto, A40000EspecialidadFoto_GXI, A156EspecialidadEstado});
                  A32EspecialidadId = T000M12_A32EspecialidadId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0M30( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0M0( ) ;
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
            load0M30( ) ;
         }
         endLevel0M30( ) ;
      }
      closeExtendedTableCursors0M30( ) ;
   }

   public void update0M30( )
   {
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M30( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0M30( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0M30( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0M30( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000M13 */
                  pr_default.execute(11, new Object[] {A71EspecialidadNombre, A154EspecialidadDescripcion, A140EspecialidadCodigo, A156EspecialidadEstado, Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Especialidad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0M30( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0M30( ) ;
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
         endLevel0M30( ) ;
      }
      closeExtendedTableCursors0M30( ) ;
   }

   public void deferredUpdate0M30( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000M14 */
         pr_default.execute(12, new Object[] {A155EspecialidadFoto, A40000EspecialidadFoto_GXI, Short.valueOf(A32EspecialidadId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
      }
   }

   public void delete( )
   {
      beforeValidate0M30( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0M30( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0M30( ) ;
         afterConfirm0M30( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0M30( ) ;
            if ( AnyError == 0 )
            {
               scanStart0M31( ) ;
               while ( RcdFound31 != 0 )
               {
                  getByPrimaryKey0M31( ) ;
                  delete0M31( ) ;
                  scanNext0M31( ) ;
               }
               scanEnd0M31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000M15 */
                  pr_default.execute(13, new Object[] {Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Especialidad");
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
      sMode30 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0M30( ) ;
      Gx_mode = sMode30 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0M30( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV21Pgmname = "Especialidad" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21Pgmname", AV21Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000M16 */
         pr_default.execute(14, new Object[] {Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Especialidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void processNestedLevel0M31( )
   {
      nGXsfl_53_idx = 0 ;
      while ( nGXsfl_53_idx < nRC_GXsfl_53 )
      {
         readRow0M31( ) ;
         if ( ( nRcdExists_31 != 0 ) || ( nIsMod_31 != 0 ) )
         {
            standaloneNotModal0M31( ) ;
            getKey0M31( ) ;
            if ( ( nRcdExists_31 == 0 ) && ( nRcdDeleted_31 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0M31( ) ;
            }
            else
            {
               if ( RcdFound31 != 0 )
               {
                  if ( ( nRcdDeleted_31 != 0 ) && ( nRcdExists_31 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0M31( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_31 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0M31( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_31 == 0 )
                  {
                     GXCCtl = "SGESPECIALIDADSEDEID_" + sGXsfl_53_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSGEspecialidadSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A38SGEspecialidadSedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSGEspecialidadSedeNombre_Internalname, A157SGEspecialidadSedeNombre) ;
         httpContext.changePostValue( edtSGEspecialidadSedeClinicaid_Internalname, GXutil.ltrim( localUtil.ntoc( A158SGEspecialidadSedeClinicaid, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSGEspecialidadSedeClinicaNombre_Internalname, A159SGEspecialidadSedeClinicaNombre) ;
         httpContext.changePostValue( edtSedeCostoConsulta_Internalname, GXutil.ltrim( localUtil.ntoc( A160SedeCostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z38SGEspecialidadSedeId_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( Z38SGEspecialidadSedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z160SedeCostoConsulta_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( Z160SedeCostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_31_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_31, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_31_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_31, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_31_"+sGXsfl_53_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_31, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_31 != 0 )
         {
            httpContext.changePostValue( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Horizontalalignment", GXutil.rtrim( edtSGEspecialidadSedeId_Horizontalalignment)) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDENOMBRE_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDECLINICAID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaid_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SGESPECIALIDADSEDECLINICANOMBRE_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SEDECOSTOCONSULTA_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0M31( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_31 = (short)(0) ;
      nIsMod_31 = (short)(0) ;
      nRcdDeleted_31 = (short)(0) ;
   }

   public void processLevel0M30( )
   {
      /* Save parent mode. */
      sMode30 = Gx_mode ;
      processNestedLevel0M31( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode30 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0M30( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0M30( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         pr_default.close(3);
         Application.commitDataStores(context, remoteHandle, pr_default, "especialidad");
         if ( AnyError == 0 )
         {
            confirmValues0M0( ) ;
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
         pr_default.close(3);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "especialidad");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0M30( )
   {
      /* Scan By routine */
      /* Using cursor T000M17 */
      pr_default.execute(15);
      RcdFound30 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32EspecialidadId = T000M17_A32EspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0M30( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound30 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound30 = (short)(1) ;
         A32EspecialidadId = T000M17_A32EspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
      }
   }

   public void scanEnd0M30( )
   {
      pr_default.close(15);
   }

   public void afterConfirm0M30( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0M30( )
   {
      /* Before Insert Rules */
      if ( new com.projectthani.prcvalidarcodigoespecialidad(remoteHandle, context).executeUdp( A140EspecialidadCodigo) )
      {
         httpContext.GX_msglist.addItem("El código de especialidad ya existe", 1, "ESPECIALIDADCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void beforeUpdate0M30( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0M30( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0M30( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0M30( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0M30( )
   {
      edtEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), true);
      edtEspecialidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadNombre_Enabled), 5, 0), true);
      edtEspecialidadDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadDescripcion_Enabled), 5, 0), true);
      edtEspecialidadCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadCodigo_Enabled), 5, 0), true);
      imgEspecialidadFoto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgEspecialidadFoto_Enabled), 5, 0), true);
      cmbEspecialidadEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEspecialidadEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEspecialidadEstado.getEnabled(), 5, 0), true);
   }

   public void zm0M31( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z160SedeCostoConsulta = T000M3_A160SedeCostoConsulta[0] ;
         }
         else
         {
            Z160SedeCostoConsulta = A160SedeCostoConsulta ;
         }
      }
      if ( GX_JID == -6 )
      {
         Z32EspecialidadId = A32EspecialidadId ;
         Z160SedeCostoConsulta = A160SedeCostoConsulta ;
         Z38SGEspecialidadSedeId = A38SGEspecialidadSedeId ;
         Z157SGEspecialidadSedeNombre = A157SGEspecialidadSedeNombre ;
         Z158SGEspecialidadSedeClinicaid = A158SGEspecialidadSedeClinicaid ;
         Z159SGEspecialidadSedeClinicaNombre = A159SGEspecialidadSedeClinicaNombre ;
      }
   }

   public void standaloneNotModal0M31( )
   {
   }

   public void standaloneModal0M31( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtSGEspecialidadSedeId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      }
      else
      {
         edtSGEspecialidadSedeId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      }
   }

   public void load0M31( )
   {
      /* Using cursor T000M18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A157SGEspecialidadSedeNombre = T000M18_A157SGEspecialidadSedeNombre[0] ;
         A159SGEspecialidadSedeClinicaNombre = T000M18_A159SGEspecialidadSedeClinicaNombre[0] ;
         A160SedeCostoConsulta = T000M18_A160SedeCostoConsulta[0] ;
         A158SGEspecialidadSedeClinicaid = T000M18_A158SGEspecialidadSedeClinicaid[0] ;
         zm0M31( -6) ;
      }
      pr_default.close(16);
      onLoadActions0M31( ) ;
   }

   public void onLoadActions0M31( )
   {
   }

   public void checkExtendedTable0M31( )
   {
      nIsDirty_31 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0M31( ) ;
      /* Using cursor T000M4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "SGESPECIALIDADSEDEID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A157SGEspecialidadSedeNombre = T000M4_A157SGEspecialidadSedeNombre[0] ;
      A158SGEspecialidadSedeClinicaid = T000M4_A158SGEspecialidadSedeClinicaid[0] ;
      pr_default.close(2);
      /* Using cursor T000M5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A158SGEspecialidadSedeClinicaid)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         GXCCtl = "SGESPECIALIDADSEDECLINICAID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
      }
      A159SGEspecialidadSedeClinicaNombre = T000M5_A159SGEspecialidadSedeClinicaNombre[0] ;
      pr_default.close(3);
   }

   public void closeExtendedTableCursors0M31( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable0M31( )
   {
   }

   public void gxload_7( short A38SGEspecialidadSedeId )
   {
      /* Using cursor T000M19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         GXCCtl = "SGESPECIALIDADSEDEID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A157SGEspecialidadSedeNombre = T000M19_A157SGEspecialidadSedeNombre[0] ;
      A158SGEspecialidadSedeClinicaid = T000M19_A158SGEspecialidadSedeClinicaid[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A157SGEspecialidadSedeNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A158SGEspecialidadSedeClinicaid, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(17) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(17);
   }

   public void gxload_8( short A158SGEspecialidadSedeClinicaid )
   {
      /* Using cursor T000M20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A158SGEspecialidadSedeClinicaid)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         GXCCtl = "SGESPECIALIDADSEDECLINICAID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
      }
      A159SGEspecialidadSedeClinicaNombre = T000M20_A159SGEspecialidadSedeClinicaNombre[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A159SGEspecialidadSedeClinicaNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(18) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(18);
   }

   public void getKey0M31( )
   {
      /* Using cursor T000M21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound31 = (short)(1) ;
      }
      else
      {
         RcdFound31 = (short)(0) ;
      }
      pr_default.close(19);
   }

   public void getByPrimaryKey0M31( )
   {
      /* Using cursor T000M3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0M31( 6) ;
         RcdFound31 = (short)(1) ;
         initializeNonKey0M31( ) ;
         A160SedeCostoConsulta = T000M3_A160SedeCostoConsulta[0] ;
         A38SGEspecialidadSedeId = T000M3_A38SGEspecialidadSedeId[0] ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z38SGEspecialidadSedeId = A38SGEspecialidadSedeId ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0M31( ) ;
         Gx_mode = sMode31 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound31 = (short)(0) ;
         initializeNonKey0M31( ) ;
         sMode31 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0M31( ) ;
         Gx_mode = sMode31 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0M31( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0M31( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000M2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EspecialidadSede"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z160SedeCostoConsulta, T000M2_A160SedeCostoConsulta[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z160SedeCostoConsulta, T000M2_A160SedeCostoConsulta[0]) != 0 )
            {
               GXutil.writeLogln("especialidad:[seudo value changed for attri]"+"SedeCostoConsulta");
               GXutil.writeLogRaw("Old: ",Z160SedeCostoConsulta);
               GXutil.writeLogRaw("Current: ",T000M2_A160SedeCostoConsulta[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"EspecialidadSede"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0M31( )
   {
      beforeValidate0M31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M31( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0M31( 0) ;
         checkOptimisticConcurrency0M31( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0M31( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0M31( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000M22 */
                  pr_default.execute(20, new Object[] {Short.valueOf(A32EspecialidadId), A160SedeCostoConsulta, Short.valueOf(A38SGEspecialidadSedeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EspecialidadSede");
                  if ( (pr_default.getStatus(20) == 1) )
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
            load0M31( ) ;
         }
         endLevel0M31( ) ;
      }
      closeExtendedTableCursors0M31( ) ;
   }

   public void update0M31( )
   {
      beforeValidate0M31( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0M31( ) ;
      }
      if ( ( nIsMod_31 != 0 ) || ( nIsDirty_31 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0M31( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0M31( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0M31( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000M23 */
                     pr_default.execute(21, new Object[] {A160SedeCostoConsulta, Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("EspecialidadSede");
                     if ( (pr_default.getStatus(21) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EspecialidadSede"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0M31( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0M31( ) ;
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
            endLevel0M31( ) ;
         }
      }
      closeExtendedTableCursors0M31( ) ;
   }

   public void deferredUpdate0M31( )
   {
   }

   public void delete0M31( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0M31( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0M31( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0M31( ) ;
         afterConfirm0M31( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0M31( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000M24 */
               pr_default.execute(22, new Object[] {Short.valueOf(A32EspecialidadId), Short.valueOf(A38SGEspecialidadSedeId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("EspecialidadSede");
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
      sMode31 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0M31( ) ;
      Gx_mode = sMode31 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0M31( )
   {
      standaloneModal0M31( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000M25 */
         pr_default.execute(23, new Object[] {Short.valueOf(A38SGEspecialidadSedeId)});
         A157SGEspecialidadSedeNombre = T000M25_A157SGEspecialidadSedeNombre[0] ;
         A158SGEspecialidadSedeClinicaid = T000M25_A158SGEspecialidadSedeClinicaid[0] ;
         pr_default.close(23);
         /* Using cursor T000M26 */
         pr_default.execute(24, new Object[] {Short.valueOf(A158SGEspecialidadSedeClinicaid)});
         A159SGEspecialidadSedeClinicaNombre = T000M26_A159SGEspecialidadSedeClinicaNombre[0] ;
         pr_default.close(24);
      }
   }

   public void endLevel0M31( )
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

   public void scanStart0M31( )
   {
      /* Scan By routine */
      /* Using cursor T000M27 */
      pr_default.execute(25, new Object[] {Short.valueOf(A32EspecialidadId)});
      RcdFound31 = (short)(0) ;
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A38SGEspecialidadSedeId = T000M27_A38SGEspecialidadSedeId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0M31( )
   {
      /* Scan next routine */
      pr_default.readNext(25);
      RcdFound31 = (short)(0) ;
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound31 = (short)(1) ;
         A38SGEspecialidadSedeId = T000M27_A38SGEspecialidadSedeId[0] ;
      }
   }

   public void scanEnd0M31( )
   {
      pr_default.close(25);
   }

   public void afterConfirm0M31( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0M31( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0M31( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0M31( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0M31( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0M31( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0M31( )
   {
      edtSGEspecialidadSedeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      edtSGEspecialidadSedeNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeNombre_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      edtSGEspecialidadSedeClinicaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeClinicaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeClinicaid_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      edtSGEspecialidadSedeClinicaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeClinicaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeClinicaNombre_Enabled), 5, 0), !bGXsfl_53_Refreshing);
      edtSedeCostoConsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeCostoConsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeCostoConsulta_Enabled), 5, 0), !bGXsfl_53_Refreshing);
   }

   public void send_integrity_lvl_hashes0M31( )
   {
   }

   public void send_integrity_lvl_hashes0M30( )
   {
   }

   public void subsflControlProps_5331( )
   {
      edtSGEspecialidadSedeId_Internalname = "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx ;
      edtSGEspecialidadSedeNombre_Internalname = "SGESPECIALIDADSEDENOMBRE_"+sGXsfl_53_idx ;
      edtSGEspecialidadSedeClinicaid_Internalname = "SGESPECIALIDADSEDECLINICAID_"+sGXsfl_53_idx ;
      edtSGEspecialidadSedeClinicaNombre_Internalname = "SGESPECIALIDADSEDECLINICANOMBRE_"+sGXsfl_53_idx ;
      edtSedeCostoConsulta_Internalname = "SEDECOSTOCONSULTA_"+sGXsfl_53_idx ;
   }

   public void subsflControlProps_fel_5331( )
   {
      edtSGEspecialidadSedeId_Internalname = "SGESPECIALIDADSEDEID_"+sGXsfl_53_fel_idx ;
      edtSGEspecialidadSedeNombre_Internalname = "SGESPECIALIDADSEDENOMBRE_"+sGXsfl_53_fel_idx ;
      edtSGEspecialidadSedeClinicaid_Internalname = "SGESPECIALIDADSEDECLINICAID_"+sGXsfl_53_fel_idx ;
      edtSGEspecialidadSedeClinicaNombre_Internalname = "SGESPECIALIDADSEDECLINICANOMBRE_"+sGXsfl_53_fel_idx ;
      edtSedeCostoConsulta_Internalname = "SEDECOSTOCONSULTA_"+sGXsfl_53_fel_idx ;
   }

   public void addRow0M31( )
   {
      nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
      sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5331( ) ;
      sendRow0M31( ) ;
   }

   public void sendRow0M31( )
   {
      Gridlevel_sedeRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_sede_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_sede_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_sede_Class, "") != 0 )
         {
            subGridlevel_sede_Linesclass = subGridlevel_sede_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_sede_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_sede_Backstyle = (byte)(0) ;
         subGridlevel_sede_Backcolor = subGridlevel_sede_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_sede_Class, "") != 0 )
         {
            subGridlevel_sede_Linesclass = subGridlevel_sede_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_sede_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_sede_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_sede_Class, "") != 0 )
         {
            subGridlevel_sede_Linesclass = subGridlevel_sede_Class+"Odd" ;
         }
         subGridlevel_sede_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_sede_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_sede_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_53_idx) % (2))) == 0 )
         {
            subGridlevel_sede_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_sede_Class, "") != 0 )
            {
               subGridlevel_sede_Linesclass = subGridlevel_sede_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_sede_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_sede_Class, "") != 0 )
            {
               subGridlevel_sede_Linesclass = subGridlevel_sede_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_31_" + sGXsfl_53_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 54,'',false,'" + sGXsfl_53_idx + "',53)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGEspecialidadSedeId_Internalname,GXutil.ltrim( localUtil.ntoc( A38SGEspecialidadSedeId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A38SGEspecialidadSedeId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,54);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGEspecialidadSedeId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSGEspecialidadSedeId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(53),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4",edtSGEspecialidadSedeId_Horizontalalignment,Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGEspecialidadSedeNombre_Internalname,A157SGEspecialidadSedeNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGEspecialidadSedeNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSGEspecialidadSedeNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(53),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGEspecialidadSedeClinicaid_Internalname,GXutil.ltrim( localUtil.ntoc( A158SGEspecialidadSedeClinicaid, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtSGEspecialidadSedeClinicaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A158SGEspecialidadSedeClinicaid), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A158SGEspecialidadSedeClinicaid), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGEspecialidadSedeClinicaid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSGEspecialidadSedeClinicaid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(53),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGEspecialidadSedeClinicaNombre_Internalname,A159SGEspecialidadSedeClinicaNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGEspecialidadSedeClinicaNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSGEspecialidadSedeClinicaNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(53),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_31_" + sGXsfl_53_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 58,'',false,'" + sGXsfl_53_idx + "',53)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSedeCostoConsulta_Internalname,GXutil.ltrim( localUtil.ntoc( A160SedeCostoConsulta, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( ((edtSedeCostoConsulta_Enabled!=0) ? localUtil.format( A160SedeCostoConsulta, "ZZ9.99") : localUtil.format( A160SedeCostoConsulta, "ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,58);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSedeCostoConsulta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtSedeCostoConsulta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(53),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_sedeRow);
      send_integrity_lvl_hashes0M31( ) ;
      GXCCtl = "Z38SGEspecialidadSedeId_" + sGXsfl_53_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z38SGEspecialidadSedeId, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "Z160SedeCostoConsulta_" + sGXsfl_53_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z160SedeCostoConsulta, (byte)(6), (byte)(2), ",", "")));
      GXCCtl = "nRcdDeleted_31_" + sGXsfl_53_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_31, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_31_" + sGXsfl_53_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_31, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_31_" + sGXsfl_53_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_31, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "vMODE_" + sGXsfl_53_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_53_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV10TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV10TrnContext);
      }
      GXCCtl = "vESPECIALIDADID_" + sGXsfl_53_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV15EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Horizontalalignment", GXutil.rtrim( edtSGEspecialidadSedeId_Horizontalalignment));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGESPECIALIDADSEDENOMBRE_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGESPECIALIDADSEDECLINICAID_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaid_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGESPECIALIDADSEDECLINICANOMBRE_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSGEspecialidadSedeClinicaNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SEDECOSTOCONSULTA_"+sGXsfl_53_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_sedeContainer.AddRow(Gridlevel_sedeRow);
   }

   public void readRow0M31( )
   {
      nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
      sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5331( ) ;
      edtSGEspecialidadSedeId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
      edtSGEspecialidadSedeId_Horizontalalignment = httpContext.cgiGet( "SGESPECIALIDADSEDEID_"+sGXsfl_53_idx+"Horizontalalignment") ;
      edtSGEspecialidadSedeNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDENOMBRE_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
      edtSGEspecialidadSedeClinicaid_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDECLINICAID_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
      edtSGEspecialidadSedeClinicaNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SGESPECIALIDADSEDECLINICANOMBRE_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
      edtSedeCostoConsulta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SEDECOSTOCONSULTA_"+sGXsfl_53_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSGEspecialidadSedeId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSGEspecialidadSedeId_Internalname), ",", ".") > 9999 ) ) )
      {
         GXCCtl = "SGESPECIALIDADSEDEID_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
         wbErr = true ;
         A38SGEspecialidadSedeId = (short)(0) ;
      }
      else
      {
         A38SGEspecialidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGEspecialidadSedeId_Internalname), ",", ".")) ;
      }
      A157SGEspecialidadSedeNombre = httpContext.cgiGet( edtSGEspecialidadSedeNombre_Internalname) ;
      A158SGEspecialidadSedeClinicaid = (short)(localUtil.ctol( httpContext.cgiGet( edtSGEspecialidadSedeClinicaid_Internalname), ",", ".")) ;
      A159SGEspecialidadSedeClinicaNombre = httpContext.cgiGet( edtSGEspecialidadSedeClinicaNombre_Internalname) ;
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtSedeCostoConsulta_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtSedeCostoConsulta_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
      {
         GXCCtl = "SEDECOSTOCONSULTA_" + sGXsfl_53_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeCostoConsulta_Internalname ;
         wbErr = true ;
         A160SedeCostoConsulta = DecimalUtil.ZERO ;
      }
      else
      {
         A160SedeCostoConsulta = localUtil.ctond( httpContext.cgiGet( edtSedeCostoConsulta_Internalname)) ;
      }
      GXCCtl = "Z38SGEspecialidadSedeId_" + sGXsfl_53_idx ;
      Z38SGEspecialidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "Z160SedeCostoConsulta_" + sGXsfl_53_idx ;
      Z160SedeCostoConsulta = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_31_" + sGXsfl_53_idx ;
      nRcdDeleted_31 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_31_" + sGXsfl_53_idx ;
      nRcdExists_31 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_31_" + sGXsfl_53_idx ;
      nIsMod_31 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void assign_properties_default( )
   {
      defedtSGEspecialidadSedeId_Enabled = edtSGEspecialidadSedeId_Enabled ;
   }

   public void confirmValues0M0( )
   {
      nGXsfl_53_idx = 0 ;
      sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_5331( ) ;
      while ( nGXsfl_53_idx < nRC_GXsfl_53 )
      {
         nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
         sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5331( ) ;
         httpContext.changePostValue( "Z38SGEspecialidadSedeId_"+sGXsfl_53_idx, httpContext.cgiGet( "ZT_"+"Z38SGEspecialidadSedeId_"+sGXsfl_53_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z38SGEspecialidadSedeId_"+sGXsfl_53_idx) ;
         httpContext.changePostValue( "Z160SedeCostoConsulta_"+sGXsfl_53_idx, httpContext.cgiGet( "ZT_"+"Z160SedeCostoConsulta_"+sGXsfl_53_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z160SedeCostoConsulta_"+sGXsfl_53_idx) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511032478", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.especialidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV15EspecialidadId,4,0))}, new String[] {"Gx_mode","EspecialidadId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Especialidad");
      forbiddenHiddens.add("EspecialidadId", localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("especialidad:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z32EspecialidadId", GXutil.ltrim( localUtil.ntoc( Z32EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z71EspecialidadNombre", Z71EspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z154EspecialidadDescripcion", Z154EspecialidadDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z140EspecialidadCodigo", Z140EspecialidadCodigo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z156EspecialidadEstado", GXutil.rtrim( Z156EspecialidadEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_53", GXutil.ltrim( localUtil.ntoc( nGXsfl_53_idx, (byte)(8), (byte)(0), ",", "")));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSGESPECIALIDADSEDEID_DATA", AV16SGEspecialidadSedeId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSGESPECIALIDADSEDEID_DATA", AV16SGEspecialidadSedeId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV15EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15EspecialidadId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ESPECIALIDADFOTO_GXI", A40000EspecialidadFoto_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV21Pgmname));
      GXCCtlgxBlob = "ESPECIALIDADFOTO" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A155EspecialidadFoto);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Objectcall", GXutil.rtrim( Combo_sgespecialidadsedeid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Cls", GXutil.rtrim( Combo_sgespecialidadsedeid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Enabled", GXutil.booltostr( Combo_sgespecialidadsedeid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Titlecontrolidtoreplace", GXutil.rtrim( Combo_sgespecialidadsedeid_Titlecontrolidtoreplace));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Isgriditem", GXutil.booltostr( Combo_sgespecialidadsedeid_Isgriditem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Hasdescription", GXutil.booltostr( Combo_sgespecialidadsedeid_Hasdescription));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Datalistproc", GXutil.rtrim( Combo_sgespecialidadsedeid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Datalistprocparametersprefix", GXutil.rtrim( Combo_sgespecialidadsedeid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SGESPECIALIDADSEDEID_Emptyitem", GXutil.booltostr( Combo_sgespecialidadsedeid_Emptyitem));
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
      return formatLink("com.projectthani.especialidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV15EspecialidadId,4,0))}, new String[] {"Gx_mode","EspecialidadId"})  ;
   }

   public String getPgmname( )
   {
      return "Especialidad" ;
   }

   public String getPgmdesc( )
   {
      return "Especialidad" ;
   }

   public void initializeNonKey0M30( )
   {
      A71EspecialidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
      A154EspecialidadDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A154EspecialidadDescripcion", A154EspecialidadDescripcion);
      A140EspecialidadCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
      A155EspecialidadFoto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A155EspecialidadFoto", A155EspecialidadFoto);
      httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
      A40000EspecialidadFoto_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A155EspecialidadFoto)==0) ? A40000EspecialidadFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A155EspecialidadFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgEspecialidadFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A155EspecialidadFoto), true);
      A156EspecialidadEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A156EspecialidadEstado", A156EspecialidadEstado);
      Z71EspecialidadNombre = "" ;
      Z154EspecialidadDescripcion = "" ;
      Z140EspecialidadCodigo = "" ;
      Z156EspecialidadEstado = "" ;
   }

   public void initAll0M30( )
   {
      A32EspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
      initializeNonKey0M30( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0M31( )
   {
      A157SGEspecialidadSedeNombre = "" ;
      A158SGEspecialidadSedeClinicaid = (short)(0) ;
      A159SGEspecialidadSedeClinicaNombre = "" ;
      A160SedeCostoConsulta = DecimalUtil.ZERO ;
      Z160SedeCostoConsulta = DecimalUtil.ZERO ;
   }

   public void initAll0M31( )
   {
      A38SGEspecialidadSedeId = (short)(0) ;
      initializeNonKey0M31( ) ;
   }

   public void standaloneModalInsert0M31( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110324727", true, true);
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
      httpContext.AddJavascriptSource("especialidad.js", "?20225110324727", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties31( )
   {
      edtSGEspecialidadSedeId_Enabled = defedtSGEspecialidadSedeId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGEspecialidadSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGEspecialidadSedeId_Enabled), 5, 0), !bGXsfl_53_Refreshing);
   }

   public void init_default_properties( )
   {
      edtEspecialidadId_Internalname = "ESPECIALIDADID" ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE" ;
      edtEspecialidadDescripcion_Internalname = "ESPECIALIDADDESCRIPCION" ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO" ;
      imgEspecialidadFoto_Internalname = "ESPECIALIDADFOTO" ;
      cmbEspecialidadEstado.setInternalname( "ESPECIALIDADESTADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtSGEspecialidadSedeId_Internalname = "SGESPECIALIDADSEDEID" ;
      edtSGEspecialidadSedeNombre_Internalname = "SGESPECIALIDADSEDENOMBRE" ;
      edtSGEspecialidadSedeClinicaid_Internalname = "SGESPECIALIDADSEDECLINICAID" ;
      edtSGEspecialidadSedeClinicaNombre_Internalname = "SGESPECIALIDADSEDECLINICANOMBRE" ;
      edtSedeCostoConsulta_Internalname = "SEDECOSTOCONSULTA" ;
      divTableleaflevel_sede_Internalname = "TABLELEAFLEVEL_SEDE" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_sgespecialidadsedeid_Internalname = "COMBO_SGESPECIALIDADSEDEID" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_sede_Internalname = "GRIDLEVEL_SEDE" ;
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
      Combo_sgespecialidadsedeid_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Especialidad" );
      edtSedeCostoConsulta_Jsonclick = "" ;
      edtSGEspecialidadSedeClinicaNombre_Jsonclick = "" ;
      edtSGEspecialidadSedeClinicaid_Jsonclick = "" ;
      edtSGEspecialidadSedeNombre_Jsonclick = "" ;
      edtSGEspecialidadSedeId_Jsonclick = "" ;
      subGridlevel_sede_Class = "GridNoBorder WorkWith" ;
      subGridlevel_sede_Backcolorstyle = (byte)(0) ;
      Combo_sgespecialidadsedeid_Titlecontrolidtoreplace = "" ;
      subGridlevel_sede_Allowcollapsing = (byte)(0) ;
      subGridlevel_sede_Allowselection = (byte)(0) ;
      edtSedeCostoConsulta_Enabled = 1 ;
      edtSGEspecialidadSedeClinicaNombre_Enabled = 0 ;
      edtSGEspecialidadSedeClinicaid_Enabled = 0 ;
      edtSGEspecialidadSedeNombre_Enabled = 0 ;
      edtSGEspecialidadSedeId_Enabled = 1 ;
      subGridlevel_sede_Header = "" ;
      Combo_sgespecialidadsedeid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_sgespecialidadsedeid_Datalistprocparametersprefix = " \"ComboName\": \"SGEspecialidadSedeId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"EspecialidadId\": 0" ;
      Combo_sgespecialidadsedeid_Datalistproc = "EspecialidadLoadDVCombo" ;
      Combo_sgespecialidadsedeid_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_sgespecialidadsedeid_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_sgespecialidadsedeid_Cls = "ExtendedCombo" ;
      Combo_sgespecialidadsedeid_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbEspecialidadEstado.setJsonclick( "" );
      cmbEspecialidadEstado.setEnabled( 1 );
      imgEspecialidadFoto_Enabled = 1 ;
      edtEspecialidadCodigo_Jsonclick = "" ;
      edtEspecialidadCodigo_Enabled = 1 ;
      edtEspecialidadDescripcion_Enabled = 1 ;
      edtEspecialidadNombre_Jsonclick = "" ;
      edtEspecialidadNombre_Enabled = 1 ;
      edtEspecialidadId_Jsonclick = "" ;
      edtEspecialidadId_Enabled = 0 ;
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
      edtSGEspecialidadSedeId_Horizontalalignment = "right" ;
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

   public void gxnrgridlevel_sede_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_5331( ) ;
      while ( nGXsfl_53_idx <= nRC_GXsfl_53 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0M31( ) ;
         standaloneModal0M31( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0M31( ) ;
         nGXsfl_53_idx = (int)(nGXsfl_53_idx+1) ;
         sGXsfl_53_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_53_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_5331( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_sedeContainer)) ;
      /* End function gxnrGridlevel_sede_newrow */
   }

   public void init_web_controls( )
   {
      cmbEspecialidadEstado.setName( "ESPECIALIDADESTADO" );
      cmbEspecialidadEstado.setWebtags( "" );
      cmbEspecialidadEstado.addItem("A", "Activo", (short)(0));
      cmbEspecialidadEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbEspecialidadEstado.getItemCount() > 0 )
      {
         A156EspecialidadEstado = cmbEspecialidadEstado.getValidValue(A156EspecialidadEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A156EspecialidadEstado", A156EspecialidadEstado);
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

   public void valid_Sgespecialidadsedeid( )
   {
      /* Using cursor T000M25 */
      pr_default.execute(23, new Object[] {Short.valueOf(A38SGEspecialidadSedeId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, "SGESPECIALIDADSEDEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGEspecialidadSedeId_Internalname ;
      }
      A157SGEspecialidadSedeNombre = T000M25_A157SGEspecialidadSedeNombre[0] ;
      A158SGEspecialidadSedeClinicaid = T000M25_A158SGEspecialidadSedeClinicaid[0] ;
      pr_default.close(23);
      /* Using cursor T000M26 */
      pr_default.execute(24, new Object[] {Short.valueOf(A158SGEspecialidadSedeClinicaid)});
      if ( (pr_default.getStatus(24) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGEspecialidad Sede'.", "ForeignKeyNotFound", 1, "SGESPECIALIDADSEDECLINICAID");
         AnyError = (short)(1) ;
      }
      A159SGEspecialidadSedeClinicaNombre = T000M26_A159SGEspecialidadSedeClinicaNombre[0] ;
      pr_default.close(24);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A157SGEspecialidadSedeNombre", A157SGEspecialidadSedeNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A158SGEspecialidadSedeClinicaid", GXutil.ltrim( localUtil.ntoc( A158SGEspecialidadSedeClinicaid, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A159SGEspecialidadSedeClinicaNombre", A159SGEspecialidadSedeClinicaNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV15EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV15EspecialidadId',fld:'vESPECIALIDADID',pic:'ZZZ9',hsh:true},{av:'A32EspecialidadId',fld:'ESPECIALIDADID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120M2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_ESPECIALIDADID","{handler:'valid_Especialidadid',iparms:[]");
      setEventMetadata("VALID_ESPECIALIDADID",",oparms:[]}");
      setEventMetadata("VALID_ESPECIALIDADCODIGO","{handler:'valid_Especialidadcodigo',iparms:[]");
      setEventMetadata("VALID_ESPECIALIDADCODIGO",",oparms:[]}");
      setEventMetadata("VALID_ESPECIALIDADESTADO","{handler:'valid_Especialidadestado',iparms:[]");
      setEventMetadata("VALID_ESPECIALIDADESTADO",",oparms:[]}");
      setEventMetadata("VALID_SGESPECIALIDADSEDEID","{handler:'valid_Sgespecialidadsedeid',iparms:[{av:'A38SGEspecialidadSedeId',fld:'SGESPECIALIDADSEDEID',pic:'ZZZ9'},{av:'A158SGEspecialidadSedeClinicaid',fld:'SGESPECIALIDADSEDECLINICAID',pic:'ZZZ9'},{av:'A157SGEspecialidadSedeNombre',fld:'SGESPECIALIDADSEDENOMBRE',pic:''},{av:'A159SGEspecialidadSedeClinicaNombre',fld:'SGESPECIALIDADSEDECLINICANOMBRE',pic:''}]");
      setEventMetadata("VALID_SGESPECIALIDADSEDEID",",oparms:[{av:'A157SGEspecialidadSedeNombre',fld:'SGESPECIALIDADSEDENOMBRE',pic:''},{av:'A158SGEspecialidadSedeClinicaid',fld:'SGESPECIALIDADSEDECLINICAID',pic:'ZZZ9'},{av:'A159SGEspecialidadSedeClinicaNombre',fld:'SGESPECIALIDADSEDECLINICANOMBRE',pic:''}]}");
      setEventMetadata("VALID_SGESPECIALIDADSEDECLINICAID","{handler:'valid_Sgespecialidadsedeclinicaid',iparms:[]");
      setEventMetadata("VALID_SGESPECIALIDADSEDECLINICAID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Sedecostoconsulta',iparms:[]");
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
      pr_default.close(23);
      pr_default.close(24);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z71EspecialidadNombre = "" ;
      Z154EspecialidadDescripcion = "" ;
      Z140EspecialidadCodigo = "" ;
      Z156EspecialidadEstado = "" ;
      Z160SedeCostoConsulta = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A156EspecialidadEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A71EspecialidadNombre = "" ;
      A154EspecialidadDescripcion = "" ;
      A140EspecialidadCodigo = "" ;
      A155EspecialidadFoto = "" ;
      A40000EspecialidadFoto_GXI = "" ;
      sImgUrl = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_sgespecialidadsedeid = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16SGEspecialidadSedeId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      Gridlevel_sedeContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridlevel_sedeColumn = new com.genexus.webpanels.GXWebColumn();
      A157SGEspecialidadSedeNombre = "" ;
      A159SGEspecialidadSedeClinicaNombre = "" ;
      A160SedeCostoConsulta = DecimalUtil.ZERO ;
      sMode31 = "" ;
      sStyleString = "" ;
      AV21Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Combo_sgespecialidadsedeid_Objectcall = "" ;
      Combo_sgespecialidadsedeid_Class = "" ;
      Combo_sgespecialidadsedeid_Icontype = "" ;
      Combo_sgespecialidadsedeid_Icon = "" ;
      Combo_sgespecialidadsedeid_Tooltip = "" ;
      Combo_sgespecialidadsedeid_Selectedvalue_set = "" ;
      Combo_sgespecialidadsedeid_Selectedvalue_get = "" ;
      Combo_sgespecialidadsedeid_Selectedtext_set = "" ;
      Combo_sgespecialidadsedeid_Selectedtext_get = "" ;
      Combo_sgespecialidadsedeid_Gamoauthtoken = "" ;
      Combo_sgespecialidadsedeid_Ddointernalname = "" ;
      Combo_sgespecialidadsedeid_Titlecontrolalign = "" ;
      Combo_sgespecialidadsedeid_Dropdownoptionstype = "" ;
      Combo_sgespecialidadsedeid_Datalisttype = "" ;
      Combo_sgespecialidadsedeid_Datalistfixedvalues = "" ;
      Combo_sgespecialidadsedeid_Htmltemplate = "" ;
      Combo_sgespecialidadsedeid_Multiplevaluestype = "" ;
      Combo_sgespecialidadsedeid_Loadingdata = "" ;
      Combo_sgespecialidadsedeid_Noresultsfound = "" ;
      Combo_sgespecialidadsedeid_Emptyitemtext = "" ;
      Combo_sgespecialidadsedeid_Onlyselectedvalues = "" ;
      Combo_sgespecialidadsedeid_Selectalltext = "" ;
      Combo_sgespecialidadsedeid_Multiplevaluesseparator = "" ;
      Combo_sgespecialidadsedeid_Addnewoptiontext = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode30 = "" ;
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
      Z155EspecialidadFoto = "" ;
      Z40000EspecialidadFoto_GXI = "" ;
      T000M8_A32EspecialidadId = new short[1] ;
      T000M8_A71EspecialidadNombre = new String[] {""} ;
      T000M8_A154EspecialidadDescripcion = new String[] {""} ;
      T000M8_A140EspecialidadCodigo = new String[] {""} ;
      T000M8_A155EspecialidadFoto = new String[] {""} ;
      T000M8_A40000EspecialidadFoto_GXI = new String[] {""} ;
      T000M8_A156EspecialidadEstado = new String[] {""} ;
      T000M9_A32EspecialidadId = new short[1] ;
      T000M7_A32EspecialidadId = new short[1] ;
      T000M7_A71EspecialidadNombre = new String[] {""} ;
      T000M7_A154EspecialidadDescripcion = new String[] {""} ;
      T000M7_A140EspecialidadCodigo = new String[] {""} ;
      T000M7_A155EspecialidadFoto = new String[] {""} ;
      T000M7_A40000EspecialidadFoto_GXI = new String[] {""} ;
      T000M7_A156EspecialidadEstado = new String[] {""} ;
      T000M10_A32EspecialidadId = new short[1] ;
      T000M11_A32EspecialidadId = new short[1] ;
      T000M6_A32EspecialidadId = new short[1] ;
      T000M6_A71EspecialidadNombre = new String[] {""} ;
      T000M6_A154EspecialidadDescripcion = new String[] {""} ;
      T000M6_A140EspecialidadCodigo = new String[] {""} ;
      T000M6_A155EspecialidadFoto = new String[] {""} ;
      T000M6_A40000EspecialidadFoto_GXI = new String[] {""} ;
      T000M6_A156EspecialidadEstado = new String[] {""} ;
      T000M12_A32EspecialidadId = new short[1] ;
      T000M16_A31ProfesionalId = new int[1] ;
      T000M16_A32EspecialidadId = new short[1] ;
      T000M17_A32EspecialidadId = new short[1] ;
      Z157SGEspecialidadSedeNombre = "" ;
      Z159SGEspecialidadSedeClinicaNombre = "" ;
      T000M18_A32EspecialidadId = new short[1] ;
      T000M18_A157SGEspecialidadSedeNombre = new String[] {""} ;
      T000M18_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      T000M18_A160SedeCostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000M18_A38SGEspecialidadSedeId = new short[1] ;
      T000M18_A158SGEspecialidadSedeClinicaid = new short[1] ;
      T000M4_A157SGEspecialidadSedeNombre = new String[] {""} ;
      T000M4_A158SGEspecialidadSedeClinicaid = new short[1] ;
      T000M5_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      T000M19_A157SGEspecialidadSedeNombre = new String[] {""} ;
      T000M19_A158SGEspecialidadSedeClinicaid = new short[1] ;
      T000M20_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      T000M21_A32EspecialidadId = new short[1] ;
      T000M21_A38SGEspecialidadSedeId = new short[1] ;
      T000M3_A32EspecialidadId = new short[1] ;
      T000M3_A160SedeCostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000M3_A38SGEspecialidadSedeId = new short[1] ;
      T000M2_A32EspecialidadId = new short[1] ;
      T000M2_A160SedeCostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000M2_A38SGEspecialidadSedeId = new short[1] ;
      T000M25_A157SGEspecialidadSedeNombre = new String[] {""} ;
      T000M25_A158SGEspecialidadSedeClinicaid = new short[1] ;
      T000M26_A159SGEspecialidadSedeClinicaNombre = new String[] {""} ;
      T000M27_A32EspecialidadId = new short[1] ;
      T000M27_A38SGEspecialidadSedeId = new short[1] ;
      Gridlevel_sedeRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_sede_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.especialidad__default(),
         new Object[] {
             new Object[] {
            T000M2_A32EspecialidadId, T000M2_A160SedeCostoConsulta, T000M2_A38SGEspecialidadSedeId
            }
            , new Object[] {
            T000M3_A32EspecialidadId, T000M3_A160SedeCostoConsulta, T000M3_A38SGEspecialidadSedeId
            }
            , new Object[] {
            T000M4_A157SGEspecialidadSedeNombre, T000M4_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            T000M5_A159SGEspecialidadSedeClinicaNombre
            }
            , new Object[] {
            T000M6_A32EspecialidadId, T000M6_A71EspecialidadNombre, T000M6_A154EspecialidadDescripcion, T000M6_A140EspecialidadCodigo, T000M6_A155EspecialidadFoto, T000M6_A40000EspecialidadFoto_GXI, T000M6_A156EspecialidadEstado
            }
            , new Object[] {
            T000M7_A32EspecialidadId, T000M7_A71EspecialidadNombre, T000M7_A154EspecialidadDescripcion, T000M7_A140EspecialidadCodigo, T000M7_A155EspecialidadFoto, T000M7_A40000EspecialidadFoto_GXI, T000M7_A156EspecialidadEstado
            }
            , new Object[] {
            T000M8_A32EspecialidadId, T000M8_A71EspecialidadNombre, T000M8_A154EspecialidadDescripcion, T000M8_A140EspecialidadCodigo, T000M8_A155EspecialidadFoto, T000M8_A40000EspecialidadFoto_GXI, T000M8_A156EspecialidadEstado
            }
            , new Object[] {
            T000M9_A32EspecialidadId
            }
            , new Object[] {
            T000M10_A32EspecialidadId
            }
            , new Object[] {
            T000M11_A32EspecialidadId
            }
            , new Object[] {
            T000M12_A32EspecialidadId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000M16_A31ProfesionalId, T000M16_A32EspecialidadId
            }
            , new Object[] {
            T000M17_A32EspecialidadId
            }
            , new Object[] {
            T000M18_A32EspecialidadId, T000M18_A157SGEspecialidadSedeNombre, T000M18_A159SGEspecialidadSedeClinicaNombre, T000M18_A160SedeCostoConsulta, T000M18_A38SGEspecialidadSedeId, T000M18_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            T000M19_A157SGEspecialidadSedeNombre, T000M19_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            T000M20_A159SGEspecialidadSedeClinicaNombre
            }
            , new Object[] {
            T000M21_A32EspecialidadId, T000M21_A38SGEspecialidadSedeId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000M25_A157SGEspecialidadSedeNombre, T000M25_A158SGEspecialidadSedeClinicaid
            }
            , new Object[] {
            T000M26_A159SGEspecialidadSedeClinicaNombre
            }
            , new Object[] {
            T000M27_A32EspecialidadId, T000M27_A38SGEspecialidadSedeId
            }
         }
      );
      AV21Pgmname = "Especialidad" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte subGridlevel_sede_Backcolorstyle ;
   private byte subGridlevel_sede_Allowselection ;
   private byte subGridlevel_sede_Allowhovering ;
   private byte subGridlevel_sede_Allowcollapsing ;
   private byte subGridlevel_sede_Collapsed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_sede_Backstyle ;
   private byte gxajaxcallmode ;
   private short wcpOAV15EspecialidadId ;
   private short Z32EspecialidadId ;
   private short Z38SGEspecialidadSedeId ;
   private short nRcdDeleted_31 ;
   private short nRcdExists_31 ;
   private short nIsMod_31 ;
   private short A38SGEspecialidadSedeId ;
   private short A158SGEspecialidadSedeClinicaid ;
   private short AV15EspecialidadId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A32EspecialidadId ;
   private short nBlankRcdCount31 ;
   private short RcdFound31 ;
   private short nBlankRcdUsr31 ;
   private short RcdFound30 ;
   private short nIsDirty_30 ;
   private short Z158SGEspecialidadSedeClinicaid ;
   private short nIsDirty_31 ;
   private int nRC_GXsfl_53 ;
   private int nGXsfl_53_idx=1 ;
   private int trnEnded ;
   private int edtEspecialidadId_Enabled ;
   private int edtEspecialidadNombre_Enabled ;
   private int edtEspecialidadDescripcion_Enabled ;
   private int edtEspecialidadCodigo_Enabled ;
   private int imgEspecialidadFoto_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtSGEspecialidadSedeId_Enabled ;
   private int edtSGEspecialidadSedeNombre_Enabled ;
   private int edtSGEspecialidadSedeClinicaid_Enabled ;
   private int edtSGEspecialidadSedeClinicaNombre_Enabled ;
   private int edtSedeCostoConsulta_Enabled ;
   private int subGridlevel_sede_Selectedindex ;
   private int subGridlevel_sede_Selectioncolor ;
   private int subGridlevel_sede_Hoveringcolor ;
   private int fRowAdded ;
   private int Combo_sgespecialidadsedeid_Datalistupdateminimumcharacters ;
   private int GX_JID ;
   private int subGridlevel_sede_Backcolor ;
   private int subGridlevel_sede_Allbackcolor ;
   private int defedtSGEspecialidadSedeId_Enabled ;
   private int idxLst ;
   private long GRIDLEVEL_SEDE_nFirstRecordOnPage ;
   private java.math.BigDecimal Z160SedeCostoConsulta ;
   private java.math.BigDecimal A160SedeCostoConsulta ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z156EspecialidadEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_53_idx="0001" ;
   private String edtSGEspecialidadSedeId_Horizontalalignment ;
   private String edtSGEspecialidadSedeId_Internalname ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEspecialidadNombre_Internalname ;
   private String A156EspecialidadEstado ;
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
   private String edtEspecialidadId_Internalname ;
   private String edtEspecialidadId_Jsonclick ;
   private String TempTags ;
   private String edtEspecialidadNombre_Jsonclick ;
   private String edtEspecialidadDescripcion_Internalname ;
   private String edtEspecialidadCodigo_Internalname ;
   private String edtEspecialidadCodigo_Jsonclick ;
   private String imgEspecialidadFoto_Internalname ;
   private String sImgUrl ;
   private String divTableleaflevel_sede_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_sgespecialidadsedeid_Caption ;
   private String Combo_sgespecialidadsedeid_Cls ;
   private String Combo_sgespecialidadsedeid_Datalistproc ;
   private String Combo_sgespecialidadsedeid_Datalistprocparametersprefix ;
   private String Combo_sgespecialidadsedeid_Internalname ;
   private String subGridlevel_sede_Header ;
   private String sMode31 ;
   private String edtSGEspecialidadSedeNombre_Internalname ;
   private String edtSGEspecialidadSedeClinicaid_Internalname ;
   private String edtSGEspecialidadSedeClinicaNombre_Internalname ;
   private String edtSedeCostoConsulta_Internalname ;
   private String sStyleString ;
   private String AV21Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Combo_sgespecialidadsedeid_Objectcall ;
   private String Combo_sgespecialidadsedeid_Class ;
   private String Combo_sgespecialidadsedeid_Icontype ;
   private String Combo_sgespecialidadsedeid_Icon ;
   private String Combo_sgespecialidadsedeid_Tooltip ;
   private String Combo_sgespecialidadsedeid_Selectedvalue_set ;
   private String Combo_sgespecialidadsedeid_Selectedvalue_get ;
   private String Combo_sgespecialidadsedeid_Selectedtext_set ;
   private String Combo_sgespecialidadsedeid_Selectedtext_get ;
   private String Combo_sgespecialidadsedeid_Gamoauthtoken ;
   private String Combo_sgespecialidadsedeid_Ddointernalname ;
   private String Combo_sgespecialidadsedeid_Titlecontrolalign ;
   private String Combo_sgespecialidadsedeid_Dropdownoptionstype ;
   private String Combo_sgespecialidadsedeid_Titlecontrolidtoreplace ;
   private String Combo_sgespecialidadsedeid_Datalisttype ;
   private String Combo_sgespecialidadsedeid_Datalistfixedvalues ;
   private String Combo_sgespecialidadsedeid_Htmltemplate ;
   private String Combo_sgespecialidadsedeid_Multiplevaluestype ;
   private String Combo_sgespecialidadsedeid_Loadingdata ;
   private String Combo_sgespecialidadsedeid_Noresultsfound ;
   private String Combo_sgespecialidadsedeid_Emptyitemtext ;
   private String Combo_sgespecialidadsedeid_Onlyselectedvalues ;
   private String Combo_sgespecialidadsedeid_Selectalltext ;
   private String Combo_sgespecialidadsedeid_Multiplevaluesseparator ;
   private String Combo_sgespecialidadsedeid_Addnewoptiontext ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String hsh ;
   private String sMode30 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_53_fel_idx="0001" ;
   private String subGridlevel_sede_Class ;
   private String subGridlevel_sede_Linesclass ;
   private String ROClassString ;
   private String edtSGEspecialidadSedeId_Jsonclick ;
   private String edtSGEspecialidadSedeNombre_Jsonclick ;
   private String edtSGEspecialidadSedeClinicaid_Jsonclick ;
   private String edtSGEspecialidadSedeClinicaNombre_Jsonclick ;
   private String edtSedeCostoConsulta_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private String subGridlevel_sede_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean bGXsfl_53_Refreshing=false ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean A155EspecialidadFoto_IsBlob ;
   private boolean Combo_sgespecialidadsedeid_Isgriditem ;
   private boolean Combo_sgespecialidadsedeid_Hasdescription ;
   private boolean Combo_sgespecialidadsedeid_Emptyitem ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Combo_sgespecialidadsedeid_Enabled ;
   private boolean Combo_sgespecialidadsedeid_Visible ;
   private boolean Combo_sgespecialidadsedeid_Allowmultipleselection ;
   private boolean Combo_sgespecialidadsedeid_Includeonlyselectedoption ;
   private boolean Combo_sgespecialidadsedeid_Includeselectalloption ;
   private boolean Combo_sgespecialidadsedeid_Includeaddnewoption ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private String Z71EspecialidadNombre ;
   private String Z154EspecialidadDescripcion ;
   private String Z140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A154EspecialidadDescripcion ;
   private String A140EspecialidadCodigo ;
   private String A40000EspecialidadFoto_GXI ;
   private String A157SGEspecialidadSedeNombre ;
   private String A159SGEspecialidadSedeClinicaNombre ;
   private String Z40000EspecialidadFoto_GXI ;
   private String Z157SGEspecialidadSedeNombre ;
   private String Z159SGEspecialidadSedeClinicaNombre ;
   private String A155EspecialidadFoto ;
   private String Z155EspecialidadFoto ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_sedeContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_sedeRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_sedeColumn ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_sgespecialidadsedeid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbEspecialidadEstado ;
   private IDataStoreProvider pr_default ;
   private short[] T000M8_A32EspecialidadId ;
   private String[] T000M8_A71EspecialidadNombre ;
   private String[] T000M8_A154EspecialidadDescripcion ;
   private String[] T000M8_A140EspecialidadCodigo ;
   private String[] T000M8_A155EspecialidadFoto ;
   private String[] T000M8_A40000EspecialidadFoto_GXI ;
   private String[] T000M8_A156EspecialidadEstado ;
   private short[] T000M9_A32EspecialidadId ;
   private short[] T000M7_A32EspecialidadId ;
   private String[] T000M7_A71EspecialidadNombre ;
   private String[] T000M7_A154EspecialidadDescripcion ;
   private String[] T000M7_A140EspecialidadCodigo ;
   private String[] T000M7_A155EspecialidadFoto ;
   private String[] T000M7_A40000EspecialidadFoto_GXI ;
   private String[] T000M7_A156EspecialidadEstado ;
   private short[] T000M10_A32EspecialidadId ;
   private short[] T000M11_A32EspecialidadId ;
   private short[] T000M6_A32EspecialidadId ;
   private String[] T000M6_A71EspecialidadNombre ;
   private String[] T000M6_A154EspecialidadDescripcion ;
   private String[] T000M6_A140EspecialidadCodigo ;
   private String[] T000M6_A155EspecialidadFoto ;
   private String[] T000M6_A40000EspecialidadFoto_GXI ;
   private String[] T000M6_A156EspecialidadEstado ;
   private short[] T000M12_A32EspecialidadId ;
   private int[] T000M16_A31ProfesionalId ;
   private short[] T000M16_A32EspecialidadId ;
   private short[] T000M17_A32EspecialidadId ;
   private short[] T000M18_A32EspecialidadId ;
   private String[] T000M18_A157SGEspecialidadSedeNombre ;
   private String[] T000M18_A159SGEspecialidadSedeClinicaNombre ;
   private java.math.BigDecimal[] T000M18_A160SedeCostoConsulta ;
   private short[] T000M18_A38SGEspecialidadSedeId ;
   private short[] T000M18_A158SGEspecialidadSedeClinicaid ;
   private String[] T000M4_A157SGEspecialidadSedeNombre ;
   private short[] T000M4_A158SGEspecialidadSedeClinicaid ;
   private String[] T000M5_A159SGEspecialidadSedeClinicaNombre ;
   private String[] T000M19_A157SGEspecialidadSedeNombre ;
   private short[] T000M19_A158SGEspecialidadSedeClinicaid ;
   private String[] T000M20_A159SGEspecialidadSedeClinicaNombre ;
   private short[] T000M21_A32EspecialidadId ;
   private short[] T000M21_A38SGEspecialidadSedeId ;
   private short[] T000M3_A32EspecialidadId ;
   private java.math.BigDecimal[] T000M3_A160SedeCostoConsulta ;
   private short[] T000M3_A38SGEspecialidadSedeId ;
   private short[] T000M2_A32EspecialidadId ;
   private java.math.BigDecimal[] T000M2_A160SedeCostoConsulta ;
   private short[] T000M2_A38SGEspecialidadSedeId ;
   private String[] T000M25_A157SGEspecialidadSedeNombre ;
   private short[] T000M25_A158SGEspecialidadSedeClinicaid ;
   private String[] T000M26_A159SGEspecialidadSedeClinicaNombre ;
   private short[] T000M27_A32EspecialidadId ;
   private short[] T000M27_A38SGEspecialidadSedeId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16SGEspecialidadSedeId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[] ;
}

final  class especialidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000M2", "SELECT [EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WITH (UPDLOCK) WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M3", "SELECT [EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M4", "SELECT [SedeNombre] AS SGEspecialidadSedeNombre, [ClinicaId] AS SGEspecialidadSedeClinicaid FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M5", "SELECT [ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M6", "SELECT [EspecialidadId], [EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado] FROM [Especialidad] WITH (UPDLOCK) WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M7", "SELECT [EspecialidadId], [EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M8", "SELECT TM1.[EspecialidadId], TM1.[EspecialidadNombre], TM1.[EspecialidadDescripcion], TM1.[EspecialidadCodigo], TM1.[EspecialidadFoto], TM1.[EspecialidadFoto_GXI], TM1.[EspecialidadEstado] FROM [Especialidad] TM1 WHERE TM1.[EspecialidadId] = ? ORDER BY TM1.[EspecialidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M9", "SELECT [EspecialidadId] FROM [Especialidad] WHERE [EspecialidadId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M10", "SELECT TOP 1 [EspecialidadId] FROM [Especialidad] WHERE ( [EspecialidadId] > ?) ORDER BY [EspecialidadId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000M11", "SELECT TOP 1 [EspecialidadId] FROM [Especialidad] WHERE ( [EspecialidadId] < ?) ORDER BY [EspecialidadId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000M12", "INSERT INTO [Especialidad]([EspecialidadNombre], [EspecialidadDescripcion], [EspecialidadCodigo], [EspecialidadFoto], [EspecialidadFoto_GXI], [EspecialidadEstado]) VALUES(?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000M13", "UPDATE [Especialidad] SET [EspecialidadNombre]=?, [EspecialidadDescripcion]=?, [EspecialidadCodigo]=?, [EspecialidadEstado]=?  WHERE [EspecialidadId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000M14", "UPDATE [Especialidad] SET [EspecialidadFoto]=?, [EspecialidadFoto_GXI]=?  WHERE [EspecialidadId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000M15", "DELETE FROM [Especialidad]  WHERE [EspecialidadId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000M16", "SELECT TOP 1 [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000M17", "SELECT [EspecialidadId] FROM [Especialidad] ORDER BY [EspecialidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M18", "SELECT T1.[EspecialidadId], T2.[SedeNombre] AS SGEspecialidadSedeNombre, T3.[ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre, T1.[SedeCostoConsulta], T1.[SGEspecialidadSedeId] AS SGEspecialidadSedeId, T2.[ClinicaId] AS SGEspecialidadSedeClinicaid FROM (([EspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SGEspecialidadSedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) WHERE T1.[EspecialidadId] = ? and T1.[SGEspecialidadSedeId] = ? ORDER BY T1.[EspecialidadId], T1.[SGEspecialidadSedeId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M19", "SELECT [SedeNombre] AS SGEspecialidadSedeNombre, [ClinicaId] AS SGEspecialidadSedeClinicaid FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M20", "SELECT [ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M21", "SELECT [EspecialidadId], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000M22", "INSERT INTO [EspecialidadSede]([EspecialidadId], [SedeCostoConsulta], [SGEspecialidadSedeId]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000M23", "UPDATE [EspecialidadSede] SET [SedeCostoConsulta]=?  WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000M24", "DELETE FROM [EspecialidadSede]  WHERE [EspecialidadId] = ? AND [SGEspecialidadSedeId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000M25", "SELECT [SedeNombre] AS SGEspecialidadSedeNombre, [ClinicaId] AS SGEspecialidadSedeClinicaid FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M26", "SELECT [ClinicaNombreComercial] AS SGEspecialidadSedeClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000M27", "SELECT [EspecialidadId], [SGEspecialidadSedeId] AS SGEspecialidadSedeId FROM [EspecialidadSede] WHERE [EspecialidadId] = ? ORDER BY [EspecialidadId], [SGEspecialidadSedeId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 1);
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
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 25 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setVarchar(3, (String)parms[2], 4, false);
               stmt.setBLOBFile(4, (String)parms[3], true);
               stmt.setGXDbFileURI(5, (String)parms[4], (String)parms[3], 2048,"Especialidad","EspecialidadFoto");
               stmt.setString(6, (String)parms[5], 1);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setVarchar(3, (String)parms[2], 4, false);
               stmt.setString(4, (String)parms[3], 1);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 12 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Especialidad","EspecialidadFoto");
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 21 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 24 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

