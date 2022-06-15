package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class disponibilidad_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_24") == 0 )
      {
         A34DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
         n34DisponibilidadId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_24( A34DisponibilidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_19") == 0 )
      {
         A31ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_19( A31ProfesionalId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_21") == 0 )
      {
         A31ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         A32EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_21( A31ProfesionalId, A32EspecialidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A32EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A32EspecialidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A35SGSedeDisponibilidadSedeId = (short)(GXutil.lval( httpContext.GetPar( "SGSedeDisponibilidadSedeId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A35SGSedeDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35SGSedeDisponibilidadSedeId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A35SGSedeDisponibilidadSedeId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A77SGSedeDisponibilidadClinicaId = (short)(GXutil.lval( httpContext.GetPar( "SGSedeDisponibilidadClinicaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A77SGSedeDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A77SGSedeDisponibilidadClinicaId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A77SGSedeDisponibilidadClinicaId) ;
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
            AV27DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27DisponibilidadId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27DisponibilidadId), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", "Disponibilidad", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEventId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public disponibilidad_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public disponibilidad_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( disponibilidad_impl.class ));
   }

   public disponibilidad_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbDisponibilidadEstado = new HTMLChoice();
      cmbDisponibilidadEstadoCita = new HTMLChoice();
      cmbDisponibilidadTipoCita = new HTMLChoice();
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
      if ( cmbDisponibilidadEstado.getItemCount() > 0 )
      {
         A136DisponibilidadEstado = cmbDisponibilidadEstado.getValidValue(A136DisponibilidadEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDisponibilidadEstado.setValue( GXutil.rtrim( A136DisponibilidadEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstado.getInternalname(), "Values", cmbDisponibilidadEstado.ToJavascriptSource(), true);
      }
      if ( cmbDisponibilidadEstadoCita.getItemCount() > 0 )
      {
         A139DisponibilidadEstadoCita = cmbDisponibilidadEstadoCita.getValidValue(A139DisponibilidadEstadoCita) ;
         httpContext.ajax_rsp_assign_attri("", false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDisponibilidadEstadoCita.setValue( GXutil.rtrim( A139DisponibilidadEstadoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstadoCita.getInternalname(), "Values", cmbDisponibilidadEstadoCita.ToJavascriptSource(), true);
      }
      if ( cmbDisponibilidadTipoCita.getItemCount() > 0 )
      {
         A298DisponibilidadTipoCita = cmbDisponibilidadTipoCita.getValidValue(A298DisponibilidadTipoCita) ;
         httpContext.ajax_rsp_assign_attri("", false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbDisponibilidadTipoCita.setValue( GXutil.rtrim( A298DisponibilidadTipoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadTipoCita.getInternalname(), "Values", cmbDisponibilidadTipoCita.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A34DisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtDisponibilidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDisponibilidadId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEventId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEventId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEventId_Internalname, GXutil.rtrim( A133EventId), GXutil.rtrim( localUtil.format( A133EventId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEventId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEventId_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadDescription_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadDescription_Internalname, "Description", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadDescription_Internalname, A134DisponibilidadDescription, GXutil.rtrim( localUtil.format( A134DisponibilidadDescription, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadDescription_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDisponibilidadDescription_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPBaseObjects\\WWP_Description", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedprofesionalid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockprofesionalid_Internalname, "Profesional Id", "", "", lblTextblockprofesionalid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_profesionalid.setProperty("Caption", Combo_profesionalid_Caption);
      ucCombo_profesionalid.setProperty("Cls", Combo_profesionalid_Cls);
      ucCombo_profesionalid.setProperty("DataListProc", Combo_profesionalid_Datalistproc);
      ucCombo_profesionalid.setProperty("DataListProcParametersPrefix", Combo_profesionalid_Datalistprocparametersprefix);
      ucCombo_profesionalid.setProperty("EmptyItem", Combo_profesionalid_Emptyitem);
      ucCombo_profesionalid.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_profesionalid.setProperty("DropDownOptionsData", AV18ProfesionalId_Data);
      ucCombo_profesionalid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_profesionalid_Internalname, "COMBO_PROFESIONALIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalId_Internalname, "Profesional Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", edtProfesionalId_Visible, edtProfesionalId_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Disponibilidad.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalApellidoPaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalApellidoPaterno_Internalname, "Apellido Paterno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalApellidoPaterno_Internalname, A85ProfesionalApellidoPaterno, GXutil.rtrim( localUtil.format( A85ProfesionalApellidoPaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalApellidoPaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalApellidoPaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalApellidoMaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalApellidoMaterno_Internalname, "Apellido Materno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalApellidoMaterno_Internalname, A86ProfesionalApellidoMaterno, GXutil.rtrim( localUtil.format( A86ProfesionalApellidoMaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalApellidoMaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalApellidoMaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalNombres_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalNombres_Internalname, "Nombres", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalNombres_Internalname, A84ProfesionalNombres, GXutil.rtrim( localUtil.format( A84ProfesionalNombres, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalNombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalNombres_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalNombreCompleto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalNombreCompleto_Internalname, "Nombre Completo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalNombreCompleto_Internalname, A83ProfesionalNombreCompleto, GXutil.rtrim( localUtil.format( A83ProfesionalNombreCompleto, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalNombreCompleto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalNombreCompleto_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalCOP_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalCOP_Internalname, "CMP", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalCOP_Internalname, A88ProfesionalCOP, GXutil.rtrim( localUtil.format( A88ProfesionalCOP, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalCOP_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalCOP_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadFecha_Internalname, "Fecha", "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadFecha_Internalname, localUtil.format(A67DisponibilidadFecha, "99/99/99"), localUtil.format( A67DisponibilidadFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,73);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadFecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Disponibilidad.htm");
      httpContext.writeTextNL( "</div>") ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadHoraInicio_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadHoraInicio_Internalname, "Hora Inicio", "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtDisponibilidadHoraInicio_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadHoraInicio_Internalname, localUtil.ttoc( A69DisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A69DisponibilidadHoraInicio, "99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 0,'DMY',5,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 0,'DMY',5,24,'spa',false,0);"+";gx.evt.onblur(this,78);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadHoraInicio_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtDisponibilidadHoraInicio_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtDisponibilidadHoraInicio_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDisponibilidadHoraInicio_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Disponibilidad.htm");
      httpContext.writeTextNL( "</div>") ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadHoraFin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadHoraFin_Internalname, "Hora Fin", "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtDisponibilidadHoraFin_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadHoraFin_Internalname, localUtil.ttoc( A135DisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A135DisponibilidadHoraFin, "99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 0,'DMY',5,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 0,'DMY',5,24,'spa',false,0);"+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadHoraFin_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtDisponibilidadHoraFin_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtDisponibilidadHoraFin_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtDisponibilidadHoraFin_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Disponibilidad.htm");
      httpContext.writeTextNL( "</div>") ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedespecialidadid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockespecialidadid_Internalname, "Especialidad Id", "", "", lblTextblockespecialidadid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_especialidadid.setProperty("Caption", Combo_especialidadid_Caption);
      ucCombo_especialidadid.setProperty("Cls", Combo_especialidadid_Cls);
      ucCombo_especialidadid.setProperty("DataListProc", Combo_especialidadid_Datalistproc);
      ucCombo_especialidadid.setProperty("EmptyItem", Combo_especialidadid_Emptyitem);
      ucCombo_especialidadid.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
      ucCombo_especialidadid.setProperty("DropDownOptionsData", AV24EspecialidadId_Data);
      ucCombo_especialidadid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_especialidadid_Internalname, "COMBO_ESPECIALIDADIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadId_Internalname, "Especialidad Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 94,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,94);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadId_Jsonclick, 0, "Attribute", "", "", "", "", edtEspecialidadId_Visible, edtEspecialidadId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Disponibilidad.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadCodigo_Internalname, "Especialidad Codigo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadCodigo_Internalname, A140EspecialidadCodigo, GXutil.rtrim( localUtil.format( A140EspecialidadCodigo, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEspecialidadCodigo_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
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
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadNombre_Internalname, "Especialidad Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadNombre_Internalname, A71EspecialidadNombre, GXutil.rtrim( localUtil.format( A71EspecialidadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEspecialidadNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDisponibilidadUser_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDisponibilidadUser_Internalname, "User", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDisponibilidadUser_Internalname, GXutil.ltrim( localUtil.ntoc( A137DisponibilidadUser, (byte)(6), (byte)(0), ",", "")), GXutil.ltrim( ((edtDisponibilidadUser_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A137DisponibilidadUser), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A137DisponibilidadUser), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDisponibilidadUser_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDisponibilidadUser_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDisponibilidadEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDisponibilidadEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 114,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDisponibilidadEstado, cmbDisponibilidadEstado.getInternalname(), GXutil.rtrim( A136DisponibilidadEstado), 1, cmbDisponibilidadEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDisponibilidadEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,114);\"", "", true, (byte)(1), "HLP_Disponibilidad.htm");
      cmbDisponibilidadEstado.setValue( GXutil.rtrim( A136DisponibilidadEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstado.getInternalname(), "Values", cmbDisponibilidadEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDisponibilidadEstadoCita.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDisponibilidadEstadoCita.getInternalname(), "Estado Cita", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 119,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDisponibilidadEstadoCita, cmbDisponibilidadEstadoCita.getInternalname(), GXutil.rtrim( A139DisponibilidadEstadoCita), 1, cmbDisponibilidadEstadoCita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbDisponibilidadEstadoCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,119);\"", "", true, (byte)(1), "HLP_Disponibilidad.htm");
      cmbDisponibilidadEstadoCita.setValue( GXutil.rtrim( A139DisponibilidadEstadoCita) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstadoCita.getInternalname(), "Values", cmbDisponibilidadEstadoCita.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbDisponibilidadTipoCita.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbDisponibilidadTipoCita.getInternalname(), "Tipo Cita", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbDisponibilidadTipoCita, cmbDisponibilidadTipoCita.getInternalname(), GXutil.rtrim( A298DisponibilidadTipoCita), 1, cmbDisponibilidadTipoCita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbDisponibilidadTipoCita.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,124);\"", "", true, (byte)(1), "HLP_Disponibilidad.htm");
      cmbDisponibilidadTipoCita.setValue( GXutil.rtrim( A298DisponibilidadTipoCita) );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadTipoCita.getInternalname(), "Values", cmbDisponibilidadTipoCita.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtDCitaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtDCitaId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtDCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ",", "")), GXutil.ltrim( ((edtDCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A138DCitaId), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A138DCitaId), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtDCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtDCitaId_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Disponibilidad.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 136,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 138,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Disponibilidad.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_profesionalid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboprofesionalid_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavComboprofesionalid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboprofesionalid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboprofesionalid_Visible, edtavComboprofesionalid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Disponibilidad.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_especialidadid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboespecialidadid_Internalname, GXutil.ltrim( localUtil.ntoc( AV25ComboEspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavComboespecialidadid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV25ComboEspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV25ComboEspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboespecialidadid_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboespecialidadid_Visible, edtavComboespecialidadid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Disponibilidad.htm");
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
      e110J2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPROFESIONALID_DATA"), AV18ProfesionalId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vESPECIALIDADID_DATA"), AV24EspecialidadId_Data);
            /* Read saved values. */
            Z34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "Z34DisponibilidadId"), ",", ".")) ;
            Z133EventId = httpContext.cgiGet( "Z133EventId") ;
            Z134DisponibilidadDescription = httpContext.cgiGet( "Z134DisponibilidadDescription") ;
            Z67DisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( "Z67DisponibilidadFecha"), 0) ;
            n67DisponibilidadFecha = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A67DisponibilidadFecha)) ? true : false) ;
            Z69DisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( "Z69DisponibilidadHoraInicio"), 0)) ;
            n69DisponibilidadHoraInicio = (GXutil.dateCompare(GXutil.nullDate(), A69DisponibilidadHoraInicio) ? true : false) ;
            Z135DisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( "Z135DisponibilidadHoraFin"), 0)) ;
            n135DisponibilidadHoraFin = (GXutil.dateCompare(GXutil.nullDate(), A135DisponibilidadHoraFin) ? true : false) ;
            Z137DisponibilidadUser = (int)(localUtil.ctol( httpContext.cgiGet( "Z137DisponibilidadUser"), ",", ".")) ;
            Z136DisponibilidadEstado = httpContext.cgiGet( "Z136DisponibilidadEstado") ;
            Z139DisponibilidadEstadoCita = httpContext.cgiGet( "Z139DisponibilidadEstadoCita") ;
            Z298DisponibilidadTipoCita = httpContext.cgiGet( "Z298DisponibilidadTipoCita") ;
            Z31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z31ProfesionalId"), ",", ".")) ;
            Z32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( "Z32EspecialidadId"), ",", ".")) ;
            Z35SGSedeDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( "Z35SGSedeDisponibilidadSedeId"), ",", ".")) ;
            A35SGSedeDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( "Z35SGSedeDisponibilidadSedeId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "N31ProfesionalId"), ",", ".")) ;
            N32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( "N32EspecialidadId"), ",", ".")) ;
            N35SGSedeDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( "N35SGSedeDisponibilidadSedeId"), ",", ".")) ;
            AV26Cond_ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "vCOND_PROFESIONALID"), ",", ".")) ;
            AV27DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( "vDISPONIBILIDADID"), ",", ".")) ;
            AV12Insert_ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PROFESIONALID"), ",", ".")) ;
            AV13Insert_EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_ESPECIALIDADID"), ",", ".")) ;
            AV16Insert_SGSedeDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SGSEDEDISPONIBILIDADSEDEID"), ",", ".")) ;
            A35SGSedeDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( "SGSEDEDISPONIBILIDADSEDEID"), ",", ".")) ;
            A74SGSedeDisponibilidadSedeNombre = httpContext.cgiGet( "SGSEDEDISPONIBILIDADSEDENOMBRE") ;
            A77SGSedeDisponibilidadClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( "SGSEDEDISPONIBILIDADCLINICAID"), ",", ".")) ;
            A79SGSedeDisponibilidadClinicaAbreviado = httpContext.cgiGet( "SGSEDEDISPONIBILIDADCLINICAABREVIADO") ;
            AV29Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_profesionalid_Objectcall = httpContext.cgiGet( "COMBO_PROFESIONALID_Objectcall") ;
            Combo_profesionalid_Class = httpContext.cgiGet( "COMBO_PROFESIONALID_Class") ;
            Combo_profesionalid_Icontype = httpContext.cgiGet( "COMBO_PROFESIONALID_Icontype") ;
            Combo_profesionalid_Icon = httpContext.cgiGet( "COMBO_PROFESIONALID_Icon") ;
            Combo_profesionalid_Caption = httpContext.cgiGet( "COMBO_PROFESIONALID_Caption") ;
            Combo_profesionalid_Tooltip = httpContext.cgiGet( "COMBO_PROFESIONALID_Tooltip") ;
            Combo_profesionalid_Cls = httpContext.cgiGet( "COMBO_PROFESIONALID_Cls") ;
            Combo_profesionalid_Selectedvalue_set = httpContext.cgiGet( "COMBO_PROFESIONALID_Selectedvalue_set") ;
            Combo_profesionalid_Selectedvalue_get = httpContext.cgiGet( "COMBO_PROFESIONALID_Selectedvalue_get") ;
            Combo_profesionalid_Selectedtext_set = httpContext.cgiGet( "COMBO_PROFESIONALID_Selectedtext_set") ;
            Combo_profesionalid_Selectedtext_get = httpContext.cgiGet( "COMBO_PROFESIONALID_Selectedtext_get") ;
            Combo_profesionalid_Gamoauthtoken = httpContext.cgiGet( "COMBO_PROFESIONALID_Gamoauthtoken") ;
            Combo_profesionalid_Ddointernalname = httpContext.cgiGet( "COMBO_PROFESIONALID_Ddointernalname") ;
            Combo_profesionalid_Titlecontrolalign = httpContext.cgiGet( "COMBO_PROFESIONALID_Titlecontrolalign") ;
            Combo_profesionalid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PROFESIONALID_Dropdownoptionstype") ;
            Combo_profesionalid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Enabled")) ;
            Combo_profesionalid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Visible")) ;
            Combo_profesionalid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PROFESIONALID_Titlecontrolidtoreplace") ;
            Combo_profesionalid_Datalisttype = httpContext.cgiGet( "COMBO_PROFESIONALID_Datalisttype") ;
            Combo_profesionalid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Allowmultipleselection")) ;
            Combo_profesionalid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PROFESIONALID_Datalistfixedvalues") ;
            Combo_profesionalid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Isgriditem")) ;
            Combo_profesionalid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Hasdescription")) ;
            Combo_profesionalid_Datalistproc = httpContext.cgiGet( "COMBO_PROFESIONALID_Datalistproc") ;
            Combo_profesionalid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PROFESIONALID_Datalistprocparametersprefix") ;
            Combo_profesionalid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PROFESIONALID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_profesionalid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Includeonlyselectedoption")) ;
            Combo_profesionalid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Includeselectalloption")) ;
            Combo_profesionalid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Emptyitem")) ;
            Combo_profesionalid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROFESIONALID_Includeaddnewoption")) ;
            Combo_profesionalid_Htmltemplate = httpContext.cgiGet( "COMBO_PROFESIONALID_Htmltemplate") ;
            Combo_profesionalid_Multiplevaluestype = httpContext.cgiGet( "COMBO_PROFESIONALID_Multiplevaluestype") ;
            Combo_profesionalid_Loadingdata = httpContext.cgiGet( "COMBO_PROFESIONALID_Loadingdata") ;
            Combo_profesionalid_Noresultsfound = httpContext.cgiGet( "COMBO_PROFESIONALID_Noresultsfound") ;
            Combo_profesionalid_Emptyitemtext = httpContext.cgiGet( "COMBO_PROFESIONALID_Emptyitemtext") ;
            Combo_profesionalid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PROFESIONALID_Onlyselectedvalues") ;
            Combo_profesionalid_Selectalltext = httpContext.cgiGet( "COMBO_PROFESIONALID_Selectalltext") ;
            Combo_profesionalid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PROFESIONALID_Multiplevaluesseparator") ;
            Combo_profesionalid_Addnewoptiontext = httpContext.cgiGet( "COMBO_PROFESIONALID_Addnewoptiontext") ;
            Combo_especialidadid_Objectcall = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Objectcall") ;
            Combo_especialidadid_Class = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Class") ;
            Combo_especialidadid_Icontype = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Icontype") ;
            Combo_especialidadid_Icon = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Icon") ;
            Combo_especialidadid_Caption = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Caption") ;
            Combo_especialidadid_Tooltip = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Tooltip") ;
            Combo_especialidadid_Cls = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Cls") ;
            Combo_especialidadid_Selectedvalue_set = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Selectedvalue_set") ;
            Combo_especialidadid_Selectedvalue_get = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Selectedvalue_get") ;
            Combo_especialidadid_Selectedtext_set = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Selectedtext_set") ;
            Combo_especialidadid_Selectedtext_get = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Selectedtext_get") ;
            Combo_especialidadid_Gamoauthtoken = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Gamoauthtoken") ;
            Combo_especialidadid_Ddointernalname = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Ddointernalname") ;
            Combo_especialidadid_Titlecontrolalign = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Titlecontrolalign") ;
            Combo_especialidadid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Dropdownoptionstype") ;
            Combo_especialidadid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Enabled")) ;
            Combo_especialidadid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Visible")) ;
            Combo_especialidadid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Titlecontrolidtoreplace") ;
            Combo_especialidadid_Datalisttype = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Datalisttype") ;
            Combo_especialidadid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Allowmultipleselection")) ;
            Combo_especialidadid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Datalistfixedvalues") ;
            Combo_especialidadid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Isgriditem")) ;
            Combo_especialidadid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Hasdescription")) ;
            Combo_especialidadid_Datalistproc = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Datalistproc") ;
            Combo_especialidadid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Datalistprocparametersprefix") ;
            Combo_especialidadid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_especialidadid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Includeonlyselectedoption")) ;
            Combo_especialidadid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Includeselectalloption")) ;
            Combo_especialidadid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Emptyitem")) ;
            Combo_especialidadid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_ESPECIALIDADID_Includeaddnewoption")) ;
            Combo_especialidadid_Htmltemplate = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Htmltemplate") ;
            Combo_especialidadid_Multiplevaluestype = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Multiplevaluestype") ;
            Combo_especialidadid_Loadingdata = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Loadingdata") ;
            Combo_especialidadid_Noresultsfound = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Noresultsfound") ;
            Combo_especialidadid_Emptyitemtext = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Emptyitemtext") ;
            Combo_especialidadid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Onlyselectedvalues") ;
            Combo_especialidadid_Selectalltext = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Selectalltext") ;
            Combo_especialidadid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Multiplevaluesseparator") ;
            Combo_especialidadid_Addnewoptiontext = httpContext.cgiGet( "COMBO_ESPECIALIDADID_Addnewoptiontext") ;
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
            A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".")) ;
            n34DisponibilidadId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            A133EventId = httpContext.cgiGet( edtEventId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A133EventId", A133EventId);
            A134DisponibilidadDescription = httpContext.cgiGet( edtDisponibilidadDescription_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A134DisponibilidadDescription", A134DisponibilidadDescription);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PROFESIONALID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A31ProfesionalId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
            }
            else
            {
               A31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
            }
            A85ProfesionalApellidoPaterno = httpContext.cgiGet( edtProfesionalApellidoPaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
            A86ProfesionalApellidoMaterno = httpContext.cgiGet( edtProfesionalApellidoMaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
            A84ProfesionalNombres = httpContext.cgiGet( edtProfesionalNombres_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
            A83ProfesionalNombreCompleto = httpContext.cgiGet( edtProfesionalNombreCompleto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
            A88ProfesionalCOP = httpContext.cgiGet( edtProfesionalCOP_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
            if ( localUtil.vcdate( httpContext.cgiGet( edtDisponibilidadFecha_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "DISPONIBILIDADFECHA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDisponibilidadFecha_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A67DisponibilidadFecha = GXutil.nullDate() ;
               n67DisponibilidadFecha = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A67DisponibilidadFecha", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
            }
            else
            {
               A67DisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtDisponibilidadFecha_Internalname), 3) ;
               n67DisponibilidadFecha = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A67DisponibilidadFecha", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
            }
            n67DisponibilidadFecha = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A67DisponibilidadFecha)) ? true : false) ;
            if ( localUtil.vcdate( httpContext.cgiGet( edtDisponibilidadHoraInicio_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badtime", new Object[] {}), 1, "DISPONIBILIDADHORAINICIO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDisponibilidadHoraInicio_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
               n69DisponibilidadHoraInicio = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A69DisponibilidadHoraInicio", localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            }
            else
            {
               A69DisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraInicio_Internalname))) ;
               n69DisponibilidadHoraInicio = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A69DisponibilidadHoraInicio", localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            }
            n69DisponibilidadHoraInicio = (GXutil.dateCompare(GXutil.nullDate(), A69DisponibilidadHoraInicio) ? true : false) ;
            if ( localUtil.vcdate( httpContext.cgiGet( edtDisponibilidadHoraFin_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badtime", new Object[] {}), 1, "DISPONIBILIDADHORAFIN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDisponibilidadHoraFin_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
               n135DisponibilidadHoraFin = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A135DisponibilidadHoraFin", localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            }
            else
            {
               A135DisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtDisponibilidadHoraFin_Internalname))) ;
               n135DisponibilidadHoraFin = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A135DisponibilidadHoraFin", localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            }
            n135DisponibilidadHoraFin = (GXutil.dateCompare(GXutil.nullDate(), A135DisponibilidadHoraFin) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ESPECIALIDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEspecialidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A32EspecialidadId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
            }
            else
            {
               A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
            }
            A140EspecialidadCodigo = httpContext.cgiGet( edtEspecialidadCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
            A71EspecialidadNombre = httpContext.cgiGet( edtEspecialidadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtDisponibilidadUser_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtDisponibilidadUser_Internalname), ",", ".") > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "DISPONIBILIDADUSER");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDisponibilidadUser_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A137DisponibilidadUser = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A137DisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(A137DisponibilidadUser), 6, 0));
            }
            else
            {
               A137DisponibilidadUser = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadUser_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A137DisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(A137DisponibilidadUser), 6, 0));
            }
            cmbDisponibilidadEstado.setValue( httpContext.cgiGet( cmbDisponibilidadEstado.getInternalname()) );
            A136DisponibilidadEstado = httpContext.cgiGet( cmbDisponibilidadEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
            cmbDisponibilidadEstadoCita.setValue( httpContext.cgiGet( cmbDisponibilidadEstadoCita.getInternalname()) );
            A139DisponibilidadEstadoCita = httpContext.cgiGet( cmbDisponibilidadEstadoCita.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
            cmbDisponibilidadTipoCita.setValue( httpContext.cgiGet( cmbDisponibilidadTipoCita.getInternalname()) );
            A298DisponibilidadTipoCita = httpContext.cgiGet( cmbDisponibilidadTipoCita.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
            A138DCitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtDCitaId_Internalname), ",", ".")) ;
            n138DCitaId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
            AV23ComboProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtavComboprofesionalid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProfesionalId), 8, 0));
            AV25ComboEspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtavComboespecialidadid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEspecialidadId), 4, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Disponibilidad");
            A34DisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtDisponibilidadId_Internalname), ",", ".")) ;
            n34DisponibilidadId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            forbiddenHiddens.add("DisponibilidadId", localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A34DisponibilidadId != Z34DisponibilidadId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("disponibilidad:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A34DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
               n34DisponibilidadId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
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
                  sMode26 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode26 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound26 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0J0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "DISPONIBILIDADID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtDisponibilidadId_Internalname ;
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
                        e110J2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120J2 ();
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
         e120J2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0J26( ) ;
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
         disableAttributes0J26( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprofesionalid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprofesionalid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboespecialidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboespecialidadid_Enabled), 5, 0), true);
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

   public void confirm_0J0( )
   {
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0J26( ) ;
         }
         else
         {
            checkExtendedTable0J26( ) ;
            closeExtendedTableCursors0J26( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0J0( )
   {
   }

   public void e110J2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV19DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV19DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtEspecialidadId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Visible), 5, 0), true);
      AV25ComboEspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEspecialidadId), 4, 0));
      edtavComboespecialidadid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboespecialidadid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboespecialidadid_Visible), 5, 0), true);
      edtProfesionalId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Visible), 5, 0), true);
      AV23ComboProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProfesionalId), 8, 0));
      edtavComboprofesionalid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprofesionalid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprofesionalid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPROFESIONALID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOESPECIALIDADID' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Insert", GXv_boolean5) ;
         disponibilidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Update", GXv_boolean5) ;
         disponibilidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWDisponibilidad_Delete", GXv_boolean5) ;
         disponibilidad_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         while ( AV30GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ProfesionalId") == 0 )
            {
               AV12Insert_ProfesionalId = (int)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_ProfesionalId), 8, 0));
               if ( ! (0==AV12Insert_ProfesionalId) )
               {
                  AV23ComboProfesionalId = AV12Insert_ProfesionalId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProfesionalId), 8, 0));
                  Combo_profesionalid_Selectedvalue_set = GXutil.trim( GXutil.str( AV23ComboProfesionalId, 8, 0)) ;
                  ucCombo_profesionalid.sendProperty(context, "", false, Combo_profesionalid_Internalname, "SelectedValue_set", Combo_profesionalid_Selectedvalue_set);
                  Combo_profesionalid_Enabled = false ;
                  ucCombo_profesionalid.sendProperty(context, "", false, Combo_profesionalid_Internalname, "Enabled", GXutil.booltostr( Combo_profesionalid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EspecialidadId") == 0 )
            {
               AV13Insert_EspecialidadId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_EspecialidadId), 4, 0));
               if ( ! (0==AV13Insert_EspecialidadId) )
               {
                  AV25ComboEspecialidadId = AV13Insert_EspecialidadId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEspecialidadId), 4, 0));
                  Combo_especialidadid_Selectedvalue_set = GXutil.trim( GXutil.str( AV25ComboEspecialidadId, 4, 0)) ;
                  ucCombo_especialidadid.sendProperty(context, "", false, Combo_especialidadid_Internalname, "SelectedValue_set", Combo_especialidadid_Selectedvalue_set);
                  Combo_especialidadid_Enabled = false ;
                  ucCombo_especialidadid.sendProperty(context, "", false, Combo_especialidadid_Internalname, "Enabled", GXutil.booltostr( Combo_especialidadid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SGSedeDisponibilidadSedeId") == 0 )
            {
               AV16Insert_SGSedeDisponibilidadSedeId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_SGSedeDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_SGSedeDisponibilidadSedeId), 4, 0));
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GXV1), 8, 0));
         }
      }
   }

   public void e120J2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.disponibilidadww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'LOADCOMBOESPECIALIDADID' Routine */
      returnInSub = false ;
      Combo_especialidadid_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"EspecialidadId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"DisponibilidadId\": 0, \"Cond_ProfesionalId\": \"#%1#\"", edtProfesionalId_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_especialidadid.sendProperty(context, "", false, Combo_especialidadid_Internalname, "DataListProcParametersPrefix", Combo_especialidadid_Datalistprocparametersprefix);
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char7[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new com.projectthani.disponibilidadloaddvcombo(remoteHandle, context).execute( "EspecialidadId", Gx_mode, false, AV27DisponibilidadId, A31ProfesionalId, "", GXv_char7, GXv_char8, GXv_char9) ;
      disponibilidad_impl.this.AV20ComboSelectedValue = GXv_char7[0] ;
      disponibilidad_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      disponibilidad_impl.this.GXt_char6 = GXv_char9[0] ;
      AV22Combo_DataJson = GXt_char6 ;
      Combo_especialidadid_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_especialidadid.sendProperty(context, "", false, Combo_especialidadid_Internalname, "SelectedValue_set", Combo_especialidadid_Selectedvalue_set);
      Combo_especialidadid_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_especialidadid.sendProperty(context, "", false, Combo_especialidadid_Internalname, "SelectedText_set", Combo_especialidadid_Selectedtext_set);
      AV25ComboEspecialidadId = (short)(GXutil.lval( AV20ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25ComboEspecialidadId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_especialidadid_Enabled = false ;
         ucCombo_especialidadid.sendProperty(context, "", false, Combo_especialidadid_Internalname, "Enabled", GXutil.booltostr( Combo_especialidadid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOPROFESIONALID' Routine */
      returnInSub = false ;
      GXt_char6 = AV22Combo_DataJson ;
      GXv_char9[0] = AV20ComboSelectedValue ;
      GXv_char8[0] = AV21ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.disponibilidadloaddvcombo(remoteHandle, context).execute( "ProfesionalId", Gx_mode, false, AV27DisponibilidadId, A31ProfesionalId, "", GXv_char9, GXv_char8, GXv_char7) ;
      disponibilidad_impl.this.AV20ComboSelectedValue = GXv_char9[0] ;
      disponibilidad_impl.this.AV21ComboSelectedText = GXv_char8[0] ;
      disponibilidad_impl.this.GXt_char6 = GXv_char7[0] ;
      AV22Combo_DataJson = GXt_char6 ;
      Combo_profesionalid_Selectedvalue_set = AV20ComboSelectedValue ;
      ucCombo_profesionalid.sendProperty(context, "", false, Combo_profesionalid_Internalname, "SelectedValue_set", Combo_profesionalid_Selectedvalue_set);
      Combo_profesionalid_Selectedtext_set = AV21ComboSelectedText ;
      ucCombo_profesionalid.sendProperty(context, "", false, Combo_profesionalid_Internalname, "SelectedText_set", Combo_profesionalid_Selectedtext_set);
      AV23ComboProfesionalId = (int)(GXutil.lval( AV20ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboProfesionalId), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_profesionalid_Enabled = false ;
         ucCombo_profesionalid.sendProperty(context, "", false, Combo_profesionalid_Internalname, "Enabled", GXutil.booltostr( Combo_profesionalid_Enabled));
      }
   }

   public void zm0J26( int GX_JID )
   {
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z133EventId = T000J3_A133EventId[0] ;
            Z134DisponibilidadDescription = T000J3_A134DisponibilidadDescription[0] ;
            Z67DisponibilidadFecha = T000J3_A67DisponibilidadFecha[0] ;
            Z69DisponibilidadHoraInicio = T000J3_A69DisponibilidadHoraInicio[0] ;
            Z135DisponibilidadHoraFin = T000J3_A135DisponibilidadHoraFin[0] ;
            Z137DisponibilidadUser = T000J3_A137DisponibilidadUser[0] ;
            Z136DisponibilidadEstado = T000J3_A136DisponibilidadEstado[0] ;
            Z139DisponibilidadEstadoCita = T000J3_A139DisponibilidadEstadoCita[0] ;
            Z298DisponibilidadTipoCita = T000J3_A298DisponibilidadTipoCita[0] ;
            Z31ProfesionalId = T000J3_A31ProfesionalId[0] ;
            Z32EspecialidadId = T000J3_A32EspecialidadId[0] ;
            Z35SGSedeDisponibilidadSedeId = T000J3_A35SGSedeDisponibilidadSedeId[0] ;
         }
         else
         {
            Z133EventId = A133EventId ;
            Z134DisponibilidadDescription = A134DisponibilidadDescription ;
            Z67DisponibilidadFecha = A67DisponibilidadFecha ;
            Z69DisponibilidadHoraInicio = A69DisponibilidadHoraInicio ;
            Z135DisponibilidadHoraFin = A135DisponibilidadHoraFin ;
            Z137DisponibilidadUser = A137DisponibilidadUser ;
            Z136DisponibilidadEstado = A136DisponibilidadEstado ;
            Z139DisponibilidadEstadoCita = A139DisponibilidadEstadoCita ;
            Z298DisponibilidadTipoCita = A298DisponibilidadTipoCita ;
            Z31ProfesionalId = A31ProfesionalId ;
            Z32EspecialidadId = A32EspecialidadId ;
            Z35SGSedeDisponibilidadSedeId = A35SGSedeDisponibilidadSedeId ;
         }
      }
      if ( GX_JID == -18 )
      {
         Z34DisponibilidadId = A34DisponibilidadId ;
         Z133EventId = A133EventId ;
         Z134DisponibilidadDescription = A134DisponibilidadDescription ;
         Z67DisponibilidadFecha = A67DisponibilidadFecha ;
         Z69DisponibilidadHoraInicio = A69DisponibilidadHoraInicio ;
         Z135DisponibilidadHoraFin = A135DisponibilidadHoraFin ;
         Z137DisponibilidadUser = A137DisponibilidadUser ;
         Z136DisponibilidadEstado = A136DisponibilidadEstado ;
         Z139DisponibilidadEstadoCita = A139DisponibilidadEstadoCita ;
         Z298DisponibilidadTipoCita = A298DisponibilidadTipoCita ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z35SGSedeDisponibilidadSedeId = A35SGSedeDisponibilidadSedeId ;
         Z74SGSedeDisponibilidadSedeNombre = A74SGSedeDisponibilidadSedeNombre ;
         Z77SGSedeDisponibilidadClinicaId = A77SGSedeDisponibilidadClinicaId ;
         Z79SGSedeDisponibilidadClinicaAbreviado = A79SGSedeDisponibilidadClinicaAbreviado ;
         Z138DCitaId = A138DCitaId ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z88ProfesionalCOP = A88ProfesionalCOP ;
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      edtDisponibilidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Enabled), 5, 0), true);
      edtDisponibilidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV27DisponibilidadId) )
      {
         A34DisponibilidadId = AV27DisponibilidadId ;
         n34DisponibilidadId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_ProfesionalId) )
      {
         edtProfesionalId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
      }
      else
      {
         edtProfesionalId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_EspecialidadId) )
      {
         edtEspecialidadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), true);
      }
      else
      {
         edtEspecialidadId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_SGSedeDisponibilidadSedeId) )
      {
         A35SGSedeDisponibilidadSedeId = AV16Insert_SGSedeDisponibilidadSedeId ;
         httpContext.ajax_rsp_assign_attri("", false, "A35SGSedeDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35SGSedeDisponibilidadSedeId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_ProfesionalId) )
      {
         A31ProfesionalId = AV12Insert_ProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      }
      else
      {
         A31ProfesionalId = AV23ComboProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_EspecialidadId) )
      {
         A32EspecialidadId = AV13Insert_EspecialidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
      }
      else
      {
         A32EspecialidadId = AV25ComboEspecialidadId ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
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
         /* Using cursor T000J10 */
         pr_default.execute(7, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(7) != 101) )
         {
            A138DCitaId = T000J10_A138DCitaId[0] ;
            n138DCitaId = T000J10_n138DCitaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
         }
         else
         {
            A138DCitaId = 0 ;
            n138DCitaId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
         }
         pr_default.close(7);
         AV29Pgmname = "Disponibilidad" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
         /* Using cursor T000J7 */
         pr_default.execute(5, new Object[] {Short.valueOf(A35SGSedeDisponibilidadSedeId)});
         A74SGSedeDisponibilidadSedeNombre = T000J7_A74SGSedeDisponibilidadSedeNombre[0] ;
         A77SGSedeDisponibilidadClinicaId = T000J7_A77SGSedeDisponibilidadClinicaId[0] ;
         pr_default.close(5);
         /* Using cursor T000J8 */
         pr_default.execute(6, new Object[] {Short.valueOf(A77SGSedeDisponibilidadClinicaId)});
         A79SGSedeDisponibilidadClinicaAbreviado = T000J8_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         pr_default.close(6);
         /* Using cursor T000J4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A31ProfesionalId)});
         A85ProfesionalApellidoPaterno = T000J4_A85ProfesionalApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
         A86ProfesionalApellidoMaterno = T000J4_A86ProfesionalApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
         A84ProfesionalNombres = T000J4_A84ProfesionalNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
         A88ProfesionalCOP = T000J4_A88ProfesionalCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
         pr_default.close(2);
         A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         httpContext.ajax_rsp_assign_attri("", false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
         /* Using cursor T000J5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A32EspecialidadId)});
         A140EspecialidadCodigo = T000J5_A140EspecialidadCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
         A71EspecialidadNombre = T000J5_A71EspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
         pr_default.close(3);
      }
   }

   public void load0J26( )
   {
      /* Using cursor T000J12 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A133EventId = T000J12_A133EventId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A133EventId", A133EventId);
         A134DisponibilidadDescription = T000J12_A134DisponibilidadDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A134DisponibilidadDescription", A134DisponibilidadDescription);
         A85ProfesionalApellidoPaterno = T000J12_A85ProfesionalApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
         A86ProfesionalApellidoMaterno = T000J12_A86ProfesionalApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
         A84ProfesionalNombres = T000J12_A84ProfesionalNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
         A88ProfesionalCOP = T000J12_A88ProfesionalCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
         A67DisponibilidadFecha = T000J12_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = T000J12_n67DisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A67DisponibilidadFecha", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
         A69DisponibilidadHoraInicio = T000J12_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = T000J12_n69DisponibilidadHoraInicio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A69DisponibilidadHoraInicio", localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
         A135DisponibilidadHoraFin = T000J12_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = T000J12_n135DisponibilidadHoraFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A135DisponibilidadHoraFin", localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
         A140EspecialidadCodigo = T000J12_A140EspecialidadCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
         A71EspecialidadNombre = T000J12_A71EspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
         A74SGSedeDisponibilidadSedeNombre = T000J12_A74SGSedeDisponibilidadSedeNombre[0] ;
         A79SGSedeDisponibilidadClinicaAbreviado = T000J12_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         A137DisponibilidadUser = T000J12_A137DisponibilidadUser[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A137DisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(A137DisponibilidadUser), 6, 0));
         A136DisponibilidadEstado = T000J12_A136DisponibilidadEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
         A139DisponibilidadEstadoCita = T000J12_A139DisponibilidadEstadoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
         A298DisponibilidadTipoCita = T000J12_A298DisponibilidadTipoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
         A31ProfesionalId = T000J12_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         A32EspecialidadId = T000J12_A32EspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         A35SGSedeDisponibilidadSedeId = T000J12_A35SGSedeDisponibilidadSedeId[0] ;
         A77SGSedeDisponibilidadClinicaId = T000J12_A77SGSedeDisponibilidadClinicaId[0] ;
         A138DCitaId = T000J12_A138DCitaId[0] ;
         n138DCitaId = T000J12_n138DCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
         zm0J26( -18) ;
      }
      pr_default.close(8);
      onLoadActions0J26( ) ;
   }

   public void onLoadActions0J26( )
   {
      AV29Pgmname = "Disponibilidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      httpContext.ajax_rsp_assign_attri("", false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
   }

   public void checkExtendedTable0J26( )
   {
      nIsDirty_26 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV29Pgmname = "Disponibilidad" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
      /* Using cursor T000J10 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         A138DCitaId = T000J10_A138DCitaId[0] ;
         n138DCitaId = T000J10_n138DCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
      }
      else
      {
         nIsDirty_26 = (short)(1) ;
         A138DCitaId = 0 ;
         n138DCitaId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
      }
      pr_default.close(7);
      /* Using cursor T000J4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A85ProfesionalApellidoPaterno = T000J4_A85ProfesionalApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      A86ProfesionalApellidoMaterno = T000J4_A86ProfesionalApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      A84ProfesionalNombres = T000J4_A84ProfesionalNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      A88ProfesionalCOP = T000J4_A88ProfesionalCOP[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
      pr_default.close(2);
      nIsDirty_26 = (short)(1) ;
      A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      httpContext.ajax_rsp_assign_attri("", false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
      /* Using cursor T000J6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A67DisponibilidadFecha)) || (( GXutil.resetTime(A67DisponibilidadFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A67DisponibilidadFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Fecha fuera de rango", "OutOfRange", 1, "DISPONIBILIDADFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDisponibilidadFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000J5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A140EspecialidadCodigo = T000J5_A140EspecialidadCodigo[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
      A71EspecialidadNombre = T000J5_A71EspecialidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A136DisponibilidadEstado, "A") == 0 ) || ( GXutil.strcmp(A136DisponibilidadEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Estado fuera de rango", "OutOfRange", 1, "DISPONIBILIDADESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDisponibilidadEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A139DisponibilidadEstadoCita, "L") == 0 ) || ( GXutil.strcmp(A139DisponibilidadEstadoCita, "O") == 0 ) || ( GXutil.strcmp(A139DisponibilidadEstadoCita, "E") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Estado Cita fuera de rango", "OutOfRange", 1, "DISPONIBILIDADESTADOCITA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDisponibilidadEstadoCita.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A298DisponibilidadTipoCita, "V") == 0 ) || ( GXutil.strcmp(A298DisponibilidadTipoCita, "P") == 0 ) || ( GXutil.strcmp(A298DisponibilidadTipoCita, "D") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Disponibilidad Tipo Cita fuera de rango", "OutOfRange", 1, "DISPONIBILIDADTIPOCITA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbDisponibilidadTipoCita.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000J7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A35SGSedeDisponibilidadSedeId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGSede Disponibilidad'.", "ForeignKeyNotFound", 1, "SGSEDEDISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A74SGSedeDisponibilidadSedeNombre = T000J7_A74SGSedeDisponibilidadSedeNombre[0] ;
      A77SGSedeDisponibilidadClinicaId = T000J7_A77SGSedeDisponibilidadClinicaId[0] ;
      pr_default.close(5);
      /* Using cursor T000J8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A77SGSedeDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGSede Disponibilidad'.", "ForeignKeyNotFound", 1, "SGSEDEDISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A79SGSedeDisponibilidadClinicaAbreviado = T000J8_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0J26( )
   {
      pr_default.close(7);
      pr_default.close(2);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_24( int A34DisponibilidadId )
   {
      /* Using cursor T000J14 */
      pr_default.execute(9, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         A138DCitaId = T000J14_A138DCitaId[0] ;
         n138DCitaId = T000J14_n138DCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
      }
      else
      {
         A138DCitaId = 0 ;
         n138DCitaId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(9) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(9);
   }

   public void gxload_19( int A31ProfesionalId )
   {
      /* Using cursor T000J15 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A85ProfesionalApellidoPaterno = T000J15_A85ProfesionalApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      A86ProfesionalApellidoMaterno = T000J15_A86ProfesionalApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      A84ProfesionalNombres = T000J15_A84ProfesionalNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      A88ProfesionalCOP = T000J15_A88ProfesionalCOP[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A85ProfesionalApellidoPaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A86ProfesionalApellidoMaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A84ProfesionalNombres)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A88ProfesionalCOP)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_21( int A31ProfesionalId ,
                          short A32EspecialidadId )
   {
      /* Using cursor T000J16 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_20( short A32EspecialidadId )
   {
      /* Using cursor T000J17 */
      pr_default.execute(12, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A140EspecialidadCodigo = T000J17_A140EspecialidadCodigo[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
      A71EspecialidadNombre = T000J17_A71EspecialidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A140EspecialidadCodigo)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A71EspecialidadNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_22( short A35SGSedeDisponibilidadSedeId )
   {
      /* Using cursor T000J18 */
      pr_default.execute(13, new Object[] {Short.valueOf(A35SGSedeDisponibilidadSedeId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGSede Disponibilidad'.", "ForeignKeyNotFound", 1, "SGSEDEDISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A74SGSedeDisponibilidadSedeNombre = T000J18_A74SGSedeDisponibilidadSedeNombre[0] ;
      A77SGSedeDisponibilidadClinicaId = T000J18_A77SGSedeDisponibilidadClinicaId[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A74SGSedeDisponibilidadSedeNombre)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A77SGSedeDisponibilidadClinicaId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_23( short A77SGSedeDisponibilidadClinicaId )
   {
      /* Using cursor T000J19 */
      pr_default.execute(14, new Object[] {Short.valueOf(A77SGSedeDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGSede Disponibilidad'.", "ForeignKeyNotFound", 1, "SGSEDEDISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A79SGSedeDisponibilidadClinicaAbreviado = T000J19_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A79SGSedeDisponibilidadClinicaAbreviado)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void getKey0J26( )
   {
      /* Using cursor T000J20 */
      pr_default.execute(15, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound26 = (short)(1) ;
      }
      else
      {
         RcdFound26 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000J3 */
      pr_default.execute(1, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0J26( 18) ;
         RcdFound26 = (short)(1) ;
         A34DisponibilidadId = T000J3_A34DisponibilidadId[0] ;
         n34DisponibilidadId = T000J3_n34DisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         A133EventId = T000J3_A133EventId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A133EventId", A133EventId);
         A134DisponibilidadDescription = T000J3_A134DisponibilidadDescription[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A134DisponibilidadDescription", A134DisponibilidadDescription);
         A67DisponibilidadFecha = T000J3_A67DisponibilidadFecha[0] ;
         n67DisponibilidadFecha = T000J3_n67DisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A67DisponibilidadFecha", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
         A69DisponibilidadHoraInicio = T000J3_A69DisponibilidadHoraInicio[0] ;
         n69DisponibilidadHoraInicio = T000J3_n69DisponibilidadHoraInicio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A69DisponibilidadHoraInicio", localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
         A135DisponibilidadHoraFin = T000J3_A135DisponibilidadHoraFin[0] ;
         n135DisponibilidadHoraFin = T000J3_n135DisponibilidadHoraFin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A135DisponibilidadHoraFin", localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
         A137DisponibilidadUser = T000J3_A137DisponibilidadUser[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A137DisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(A137DisponibilidadUser), 6, 0));
         A136DisponibilidadEstado = T000J3_A136DisponibilidadEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
         A139DisponibilidadEstadoCita = T000J3_A139DisponibilidadEstadoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
         A298DisponibilidadTipoCita = T000J3_A298DisponibilidadTipoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
         A31ProfesionalId = T000J3_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         A32EspecialidadId = T000J3_A32EspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         A35SGSedeDisponibilidadSedeId = T000J3_A35SGSedeDisponibilidadSedeId[0] ;
         Z34DisponibilidadId = A34DisponibilidadId ;
         sMode26 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0J26( ) ;
         if ( AnyError == 1 )
         {
            RcdFound26 = (short)(0) ;
            initializeNonKey0J26( ) ;
         }
         Gx_mode = sMode26 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound26 = (short)(0) ;
         initializeNonKey0J26( ) ;
         sMode26 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode26 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0J26( ) ;
      if ( RcdFound26 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound26 = (short)(0) ;
      /* Using cursor T000J21 */
      pr_default.execute(16, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         while ( (pr_default.getStatus(16) != 101) && ( ( T000J21_A34DisponibilidadId[0] < A34DisponibilidadId ) ) )
         {
            pr_default.readNext(16);
         }
         if ( (pr_default.getStatus(16) != 101) && ( ( T000J21_A34DisponibilidadId[0] > A34DisponibilidadId ) ) )
         {
            A34DisponibilidadId = T000J21_A34DisponibilidadId[0] ;
            n34DisponibilidadId = T000J21_n34DisponibilidadId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            RcdFound26 = (short)(1) ;
         }
      }
      pr_default.close(16);
   }

   public void move_previous( )
   {
      RcdFound26 = (short)(0) ;
      /* Using cursor T000J22 */
      pr_default.execute(17, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         while ( (pr_default.getStatus(17) != 101) && ( ( T000J22_A34DisponibilidadId[0] > A34DisponibilidadId ) ) )
         {
            pr_default.readNext(17);
         }
         if ( (pr_default.getStatus(17) != 101) && ( ( T000J22_A34DisponibilidadId[0] < A34DisponibilidadId ) ) )
         {
            A34DisponibilidadId = T000J22_A34DisponibilidadId[0] ;
            n34DisponibilidadId = T000J22_n34DisponibilidadId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
            RcdFound26 = (short)(1) ;
         }
      }
      pr_default.close(17);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0J26( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEventId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0J26( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound26 == 1 )
         {
            if ( A34DisponibilidadId != Z34DisponibilidadId )
            {
               A34DisponibilidadId = Z34DisponibilidadId ;
               n34DisponibilidadId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "DISPONIBILIDADID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtDisponibilidadId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEventId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0J26( ) ;
               GX_FocusControl = edtEventId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A34DisponibilidadId != Z34DisponibilidadId )
            {
               /* Insert record */
               GX_FocusControl = edtEventId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0J26( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "DISPONIBILIDADID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtDisponibilidadId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtEventId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0J26( ) ;
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
      if ( A34DisponibilidadId != Z34DisponibilidadId )
      {
         A34DisponibilidadId = Z34DisponibilidadId ;
         n34DisponibilidadId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "DISPONIBILIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtDisponibilidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEventId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0J26( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000J2 */
         pr_default.execute(0, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Disponibilidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z133EventId, T000J2_A133EventId[0]) != 0 ) || ( GXutil.strcmp(Z134DisponibilidadDescription, T000J2_A134DisponibilidadDescription[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z67DisponibilidadFecha), GXutil.resetTime(T000J2_A67DisponibilidadFecha[0])) ) || !( GXutil.dateCompare(Z69DisponibilidadHoraInicio, T000J2_A69DisponibilidadHoraInicio[0]) ) || !( GXutil.dateCompare(Z135DisponibilidadHoraFin, T000J2_A135DisponibilidadHoraFin[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z137DisponibilidadUser != T000J2_A137DisponibilidadUser[0] ) || ( GXutil.strcmp(Z136DisponibilidadEstado, T000J2_A136DisponibilidadEstado[0]) != 0 ) || ( GXutil.strcmp(Z139DisponibilidadEstadoCita, T000J2_A139DisponibilidadEstadoCita[0]) != 0 ) || ( GXutil.strcmp(Z298DisponibilidadTipoCita, T000J2_A298DisponibilidadTipoCita[0]) != 0 ) || ( Z31ProfesionalId != T000J2_A31ProfesionalId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z32EspecialidadId != T000J2_A32EspecialidadId[0] ) || ( Z35SGSedeDisponibilidadSedeId != T000J2_A35SGSedeDisponibilidadSedeId[0] ) )
         {
            if ( GXutil.strcmp(Z133EventId, T000J2_A133EventId[0]) != 0 )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"EventId");
               GXutil.writeLogRaw("Old: ",Z133EventId);
               GXutil.writeLogRaw("Current: ",T000J2_A133EventId[0]);
            }
            if ( GXutil.strcmp(Z134DisponibilidadDescription, T000J2_A134DisponibilidadDescription[0]) != 0 )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadDescription");
               GXutil.writeLogRaw("Old: ",Z134DisponibilidadDescription);
               GXutil.writeLogRaw("Current: ",T000J2_A134DisponibilidadDescription[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z67DisponibilidadFecha), GXutil.resetTime(T000J2_A67DisponibilidadFecha[0])) ) )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadFecha");
               GXutil.writeLogRaw("Old: ",Z67DisponibilidadFecha);
               GXutil.writeLogRaw("Current: ",T000J2_A67DisponibilidadFecha[0]);
            }
            if ( !( GXutil.dateCompare(Z69DisponibilidadHoraInicio, T000J2_A69DisponibilidadHoraInicio[0]) ) )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadHoraInicio");
               GXutil.writeLogRaw("Old: ",Z69DisponibilidadHoraInicio);
               GXutil.writeLogRaw("Current: ",T000J2_A69DisponibilidadHoraInicio[0]);
            }
            if ( !( GXutil.dateCompare(Z135DisponibilidadHoraFin, T000J2_A135DisponibilidadHoraFin[0]) ) )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadHoraFin");
               GXutil.writeLogRaw("Old: ",Z135DisponibilidadHoraFin);
               GXutil.writeLogRaw("Current: ",T000J2_A135DisponibilidadHoraFin[0]);
            }
            if ( Z137DisponibilidadUser != T000J2_A137DisponibilidadUser[0] )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadUser");
               GXutil.writeLogRaw("Old: ",Z137DisponibilidadUser);
               GXutil.writeLogRaw("Current: ",T000J2_A137DisponibilidadUser[0]);
            }
            if ( GXutil.strcmp(Z136DisponibilidadEstado, T000J2_A136DisponibilidadEstado[0]) != 0 )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadEstado");
               GXutil.writeLogRaw("Old: ",Z136DisponibilidadEstado);
               GXutil.writeLogRaw("Current: ",T000J2_A136DisponibilidadEstado[0]);
            }
            if ( GXutil.strcmp(Z139DisponibilidadEstadoCita, T000J2_A139DisponibilidadEstadoCita[0]) != 0 )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadEstadoCita");
               GXutil.writeLogRaw("Old: ",Z139DisponibilidadEstadoCita);
               GXutil.writeLogRaw("Current: ",T000J2_A139DisponibilidadEstadoCita[0]);
            }
            if ( GXutil.strcmp(Z298DisponibilidadTipoCita, T000J2_A298DisponibilidadTipoCita[0]) != 0 )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"DisponibilidadTipoCita");
               GXutil.writeLogRaw("Old: ",Z298DisponibilidadTipoCita);
               GXutil.writeLogRaw("Current: ",T000J2_A298DisponibilidadTipoCita[0]);
            }
            if ( Z31ProfesionalId != T000J2_A31ProfesionalId[0] )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"ProfesionalId");
               GXutil.writeLogRaw("Old: ",Z31ProfesionalId);
               GXutil.writeLogRaw("Current: ",T000J2_A31ProfesionalId[0]);
            }
            if ( Z32EspecialidadId != T000J2_A32EspecialidadId[0] )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"EspecialidadId");
               GXutil.writeLogRaw("Old: ",Z32EspecialidadId);
               GXutil.writeLogRaw("Current: ",T000J2_A32EspecialidadId[0]);
            }
            if ( Z35SGSedeDisponibilidadSedeId != T000J2_A35SGSedeDisponibilidadSedeId[0] )
            {
               GXutil.writeLogln("disponibilidad:[seudo value changed for attri]"+"SGSedeDisponibilidadSedeId");
               GXutil.writeLogRaw("Old: ",Z35SGSedeDisponibilidadSedeId);
               GXutil.writeLogRaw("Current: ",T000J2_A35SGSedeDisponibilidadSedeId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Disponibilidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0J26( )
   {
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0J26( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0J26( 0) ;
         checkOptimisticConcurrency0J26( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0J26( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0J26( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000J23 */
                  pr_default.execute(18, new Object[] {A133EventId, A134DisponibilidadDescription, Boolean.valueOf(n67DisponibilidadFecha), A67DisponibilidadFecha, Boolean.valueOf(n69DisponibilidadHoraInicio), A69DisponibilidadHoraInicio, Boolean.valueOf(n135DisponibilidadHoraFin), A135DisponibilidadHoraFin, Integer.valueOf(A137DisponibilidadUser), A136DisponibilidadEstado, A139DisponibilidadEstadoCita, A298DisponibilidadTipoCita, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A35SGSedeDisponibilidadSedeId)});
                  A34DisponibilidadId = T000J23_A34DisponibilidadId[0] ;
                  n34DisponibilidadId = T000J23_n34DisponibilidadId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Disponibilidad");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0J0( ) ;
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
            load0J26( ) ;
         }
         endLevel0J26( ) ;
      }
      closeExtendedTableCursors0J26( ) ;
   }

   public void update0J26( )
   {
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0J26( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0J26( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0J26( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0J26( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000J24 */
                  pr_default.execute(19, new Object[] {A133EventId, A134DisponibilidadDescription, Boolean.valueOf(n67DisponibilidadFecha), A67DisponibilidadFecha, Boolean.valueOf(n69DisponibilidadHoraInicio), A69DisponibilidadHoraInicio, Boolean.valueOf(n135DisponibilidadHoraFin), A135DisponibilidadHoraFin, Integer.valueOf(A137DisponibilidadUser), A136DisponibilidadEstado, A139DisponibilidadEstadoCita, A298DisponibilidadTipoCita, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A35SGSedeDisponibilidadSedeId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Disponibilidad");
                  if ( (pr_default.getStatus(19) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Disponibilidad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0J26( ) ;
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
         endLevel0J26( ) ;
      }
      closeExtendedTableCursors0J26( ) ;
   }

   public void deferredUpdate0J26( )
   {
   }

   public void delete( )
   {
      beforeValidate0J26( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0J26( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0J26( ) ;
         afterConfirm0J26( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0J26( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000J25 */
               pr_default.execute(20, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Disponibilidad");
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
      sMode26 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0J26( ) ;
      Gx_mode = sMode26 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0J26( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "Disponibilidad" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29Pgmname", AV29Pgmname);
         /* Using cursor T000J27 */
         pr_default.execute(21, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            A138DCitaId = T000J27_A138DCitaId[0] ;
            n138DCitaId = T000J27_n138DCitaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
         }
         else
         {
            A138DCitaId = 0 ;
            n138DCitaId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
         }
         pr_default.close(21);
         /* Using cursor T000J28 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A31ProfesionalId)});
         A85ProfesionalApellidoPaterno = T000J28_A85ProfesionalApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
         A86ProfesionalApellidoMaterno = T000J28_A86ProfesionalApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
         A84ProfesionalNombres = T000J28_A84ProfesionalNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
         A88ProfesionalCOP = T000J28_A88ProfesionalCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
         pr_default.close(22);
         A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         httpContext.ajax_rsp_assign_attri("", false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
         /* Using cursor T000J29 */
         pr_default.execute(23, new Object[] {Short.valueOf(A32EspecialidadId)});
         A140EspecialidadCodigo = T000J29_A140EspecialidadCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
         A71EspecialidadNombre = T000J29_A71EspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
         pr_default.close(23);
         /* Using cursor T000J30 */
         pr_default.execute(24, new Object[] {Short.valueOf(A35SGSedeDisponibilidadSedeId)});
         A74SGSedeDisponibilidadSedeNombre = T000J30_A74SGSedeDisponibilidadSedeNombre[0] ;
         A77SGSedeDisponibilidadClinicaId = T000J30_A77SGSedeDisponibilidadClinicaId[0] ;
         pr_default.close(24);
         /* Using cursor T000J31 */
         pr_default.execute(25, new Object[] {Short.valueOf(A77SGSedeDisponibilidadClinicaId)});
         A79SGSedeDisponibilidadClinicaAbreviado = T000J31_A79SGSedeDisponibilidadClinicaAbreviado[0] ;
         pr_default.close(25);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000J32 */
         pr_default.execute(26, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Pago"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor T000J33 */
         pr_default.execute(27, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
      }
   }

   public void endLevel0J26( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0J26( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(22);
         pr_default.close(23);
         pr_default.close(24);
         pr_default.close(25);
         pr_default.close(21);
         Application.commitDataStores(context, remoteHandle, pr_default, "disponibilidad");
         if ( AnyError == 0 )
         {
            confirmValues0J0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(22);
         pr_default.close(23);
         pr_default.close(24);
         pr_default.close(25);
         pr_default.close(21);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "disponibilidad");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0J26( )
   {
      /* Scan By routine */
      /* Using cursor T000J34 */
      pr_default.execute(28);
      RcdFound26 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A34DisponibilidadId = T000J34_A34DisponibilidadId[0] ;
         n34DisponibilidadId = T000J34_n34DisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0J26( )
   {
      /* Scan next routine */
      pr_default.readNext(28);
      RcdFound26 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound26 = (short)(1) ;
         A34DisponibilidadId = T000J34_A34DisponibilidadId[0] ;
         n34DisponibilidadId = T000J34_n34DisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      }
   }

   public void scanEnd0J26( )
   {
      pr_default.close(28);
   }

   public void afterConfirm0J26( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0J26( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0J26( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0J26( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0J26( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0J26( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0J26( )
   {
      edtDisponibilidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadId_Enabled), 5, 0), true);
      edtEventId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEventId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEventId_Enabled), 5, 0), true);
      edtDisponibilidadDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadDescription_Enabled), 5, 0), true);
      edtProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
      edtProfesionalApellidoPaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoPaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoPaterno_Enabled), 5, 0), true);
      edtProfesionalApellidoMaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoMaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoMaterno_Enabled), 5, 0), true);
      edtProfesionalNombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombres_Enabled), 5, 0), true);
      edtProfesionalNombreCompleto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombreCompleto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombreCompleto_Enabled), 5, 0), true);
      edtProfesionalCOP_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalCOP_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalCOP_Enabled), 5, 0), true);
      edtDisponibilidadFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadFecha_Enabled), 5, 0), true);
      edtDisponibilidadHoraInicio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadHoraInicio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadHoraInicio_Enabled), 5, 0), true);
      edtDisponibilidadHoraFin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadHoraFin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadHoraFin_Enabled), 5, 0), true);
      edtEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), true);
      edtEspecialidadCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadCodigo_Enabled), 5, 0), true);
      edtEspecialidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadNombre_Enabled), 5, 0), true);
      edtDisponibilidadUser_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDisponibilidadUser_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDisponibilidadUser_Enabled), 5, 0), true);
      cmbDisponibilidadEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDisponibilidadEstado.getEnabled(), 5, 0), true);
      cmbDisponibilidadEstadoCita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadEstadoCita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDisponibilidadEstadoCita.getEnabled(), 5, 0), true);
      cmbDisponibilidadTipoCita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbDisponibilidadTipoCita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbDisponibilidadTipoCita.getEnabled(), 5, 0), true);
      edtDCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtDCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtDCitaId_Enabled), 5, 0), true);
      edtavComboprofesionalid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboprofesionalid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboprofesionalid_Enabled), 5, 0), true);
      edtavComboespecialidadid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboespecialidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboespecialidadid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0J26( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0J0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110324713", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.disponibilidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV27DisponibilidadId,8,0))}, new String[] {"Gx_mode","DisponibilidadId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Disponibilidad");
      forbiddenHiddens.add("DisponibilidadId", localUtil.format( DecimalUtil.doubleToDec(A34DisponibilidadId), "ZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("disponibilidad:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z34DisponibilidadId", GXutil.ltrim( localUtil.ntoc( Z34DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z133EventId", GXutil.rtrim( Z133EventId));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z134DisponibilidadDescription", Z134DisponibilidadDescription);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z67DisponibilidadFecha", localUtil.dtoc( Z67DisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z69DisponibilidadHoraInicio", localUtil.ttoc( Z69DisponibilidadHoraInicio, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z135DisponibilidadHoraFin", localUtil.ttoc( Z135DisponibilidadHoraFin, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z137DisponibilidadUser", GXutil.ltrim( localUtil.ntoc( Z137DisponibilidadUser, (byte)(6), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z136DisponibilidadEstado", GXutil.rtrim( Z136DisponibilidadEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z139DisponibilidadEstadoCita", Z139DisponibilidadEstadoCita);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z298DisponibilidadTipoCita", GXutil.rtrim( Z298DisponibilidadTipoCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z31ProfesionalId", GXutil.ltrim( localUtil.ntoc( Z31ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z32EspecialidadId", GXutil.ltrim( localUtil.ntoc( Z32EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z35SGSedeDisponibilidadSedeId", GXutil.ltrim( localUtil.ntoc( Z35SGSedeDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N31ProfesionalId", GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N32EspecialidadId", GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N35SGSedeDisponibilidadSedeId", GXutil.ltrim( localUtil.ntoc( A35SGSedeDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPROFESIONALID_DATA", AV18ProfesionalId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPROFESIONALID_DATA", AV18ProfesionalId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vESPECIALIDADID_DATA", AV24EspecialidadId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vESPECIALIDADID_DATA", AV24EspecialidadId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vCOND_PROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV26Cond_ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV27DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV27DisponibilidadId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV12Insert_ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_ESPECIALIDADID", GXutil.ltrim( localUtil.ntoc( AV13Insert_EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SGSEDEDISPONIBILIDADSEDEID", GXutil.ltrim( localUtil.ntoc( AV16Insert_SGSedeDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGSEDEDISPONIBILIDADSEDEID", GXutil.ltrim( localUtil.ntoc( A35SGSedeDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGSEDEDISPONIBILIDADSEDENOMBRE", A74SGSedeDisponibilidadSedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGSEDEDISPONIBILIDADCLINICAID", GXutil.ltrim( localUtil.ntoc( A77SGSedeDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGSEDEDISPONIBILIDADCLINICAABREVIADO", A79SGSedeDisponibilidadClinicaAbreviado);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV29Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Objectcall", GXutil.rtrim( Combo_profesionalid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Cls", GXutil.rtrim( Combo_profesionalid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Selectedvalue_set", GXutil.rtrim( Combo_profesionalid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Selectedtext_set", GXutil.rtrim( Combo_profesionalid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Enabled", GXutil.booltostr( Combo_profesionalid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Datalistproc", GXutil.rtrim( Combo_profesionalid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Datalistprocparametersprefix", GXutil.rtrim( Combo_profesionalid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROFESIONALID_Emptyitem", GXutil.booltostr( Combo_profesionalid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Objectcall", GXutil.rtrim( Combo_especialidadid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Cls", GXutil.rtrim( Combo_especialidadid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Selectedvalue_set", GXutil.rtrim( Combo_especialidadid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Selectedtext_set", GXutil.rtrim( Combo_especialidadid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Enabled", GXutil.booltostr( Combo_especialidadid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Datalistproc", GXutil.rtrim( Combo_especialidadid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Datalistprocparametersprefix", GXutil.rtrim( Combo_especialidadid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_ESPECIALIDADID_Emptyitem", GXutil.booltostr( Combo_especialidadid_Emptyitem));
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
      return formatLink("com.projectthani.disponibilidad", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV27DisponibilidadId,8,0))}, new String[] {"Gx_mode","DisponibilidadId"})  ;
   }

   public String getPgmname( )
   {
      return "Disponibilidad" ;
   }

   public String getPgmdesc( )
   {
      return "Disponibilidad" ;
   }

   public void initializeNonKey0J26( )
   {
      A31ProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      A32EspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
      A35SGSedeDisponibilidadSedeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A35SGSedeDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A35SGSedeDisponibilidadSedeId), 4, 0));
      A83ProfesionalNombreCompleto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
      A138DCitaId = 0 ;
      n138DCitaId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A138DCitaId), 6, 0));
      A133EventId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A133EventId", A133EventId);
      A134DisponibilidadDescription = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A134DisponibilidadDescription", A134DisponibilidadDescription);
      A85ProfesionalApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      A86ProfesionalApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      A84ProfesionalNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      A88ProfesionalCOP = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
      A67DisponibilidadFecha = GXutil.nullDate() ;
      n67DisponibilidadFecha = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A67DisponibilidadFecha", localUtil.format(A67DisponibilidadFecha, "99/99/99"));
      n67DisponibilidadFecha = (GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A67DisponibilidadFecha)) ? true : false) ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      n69DisponibilidadHoraInicio = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A69DisponibilidadHoraInicio", localUtil.ttoc( A69DisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
      n69DisponibilidadHoraInicio = (GXutil.dateCompare(GXutil.nullDate(), A69DisponibilidadHoraInicio) ? true : false) ;
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      n135DisponibilidadHoraFin = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A135DisponibilidadHoraFin", localUtil.ttoc( A135DisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
      n135DisponibilidadHoraFin = (GXutil.dateCompare(GXutil.nullDate(), A135DisponibilidadHoraFin) ? true : false) ;
      A140EspecialidadCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
      A71EspecialidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
      A74SGSedeDisponibilidadSedeNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A74SGSedeDisponibilidadSedeNombre", A74SGSedeDisponibilidadSedeNombre);
      A77SGSedeDisponibilidadClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A77SGSedeDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A77SGSedeDisponibilidadClinicaId), 4, 0));
      A79SGSedeDisponibilidadClinicaAbreviado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A79SGSedeDisponibilidadClinicaAbreviado", A79SGSedeDisponibilidadClinicaAbreviado);
      A137DisponibilidadUser = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A137DisponibilidadUser", GXutil.ltrimstr( DecimalUtil.doubleToDec(A137DisponibilidadUser), 6, 0));
      A136DisponibilidadEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
      A139DisponibilidadEstadoCita = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
      A298DisponibilidadTipoCita = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
      Z133EventId = "" ;
      Z134DisponibilidadDescription = "" ;
      Z67DisponibilidadFecha = GXutil.nullDate() ;
      Z69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      Z135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      Z137DisponibilidadUser = 0 ;
      Z136DisponibilidadEstado = "" ;
      Z139DisponibilidadEstadoCita = "" ;
      Z298DisponibilidadTipoCita = "" ;
      Z31ProfesionalId = 0 ;
      Z32EspecialidadId = (short)(0) ;
      Z35SGSedeDisponibilidadSedeId = (short)(0) ;
   }

   public void initAll0J26( )
   {
      A34DisponibilidadId = 0 ;
      n34DisponibilidadId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A34DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A34DisponibilidadId), 8, 0));
      initializeNonKey0J26( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110324748", true, true);
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
      httpContext.AddJavascriptSource("disponibilidad.js", "?20225110324748", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
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
      edtDisponibilidadId_Internalname = "DISPONIBILIDADID" ;
      edtEventId_Internalname = "EVENTID" ;
      edtDisponibilidadDescription_Internalname = "DISPONIBILIDADDESCRIPTION" ;
      lblTextblockprofesionalid_Internalname = "TEXTBLOCKPROFESIONALID" ;
      Combo_profesionalid_Internalname = "COMBO_PROFESIONALID" ;
      edtProfesionalId_Internalname = "PROFESIONALID" ;
      divTablesplittedprofesionalid_Internalname = "TABLESPLITTEDPROFESIONALID" ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO" ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO" ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES" ;
      edtProfesionalNombreCompleto_Internalname = "PROFESIONALNOMBRECOMPLETO" ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP" ;
      edtDisponibilidadFecha_Internalname = "DISPONIBILIDADFECHA" ;
      edtDisponibilidadHoraInicio_Internalname = "DISPONIBILIDADHORAINICIO" ;
      edtDisponibilidadHoraFin_Internalname = "DISPONIBILIDADHORAFIN" ;
      lblTextblockespecialidadid_Internalname = "TEXTBLOCKESPECIALIDADID" ;
      Combo_especialidadid_Internalname = "COMBO_ESPECIALIDADID" ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID" ;
      divTablesplittedespecialidadid_Internalname = "TABLESPLITTEDESPECIALIDADID" ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO" ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE" ;
      edtDisponibilidadUser_Internalname = "DISPONIBILIDADUSER" ;
      cmbDisponibilidadEstado.setInternalname( "DISPONIBILIDADESTADO" );
      cmbDisponibilidadEstadoCita.setInternalname( "DISPONIBILIDADESTADOCITA" );
      cmbDisponibilidadTipoCita.setInternalname( "DISPONIBILIDADTIPOCITA" );
      edtDCitaId_Internalname = "DCITAID" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboprofesionalid_Internalname = "vCOMBOPROFESIONALID" ;
      divSectionattribute_profesionalid_Internalname = "SECTIONATTRIBUTE_PROFESIONALID" ;
      edtavComboespecialidadid_Internalname = "vCOMBOESPECIALIDADID" ;
      divSectionattribute_especialidadid_Internalname = "SECTIONATTRIBUTE_ESPECIALIDADID" ;
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
      Form.setCaption( "Disponibilidad" );
      Combo_especialidadid_Datalistprocparametersprefix = "" ;
      edtavComboespecialidadid_Jsonclick = "" ;
      edtavComboespecialidadid_Enabled = 0 ;
      edtavComboespecialidadid_Visible = 1 ;
      edtavComboprofesionalid_Jsonclick = "" ;
      edtavComboprofesionalid_Enabled = 0 ;
      edtavComboprofesionalid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtDCitaId_Jsonclick = "" ;
      edtDCitaId_Enabled = 0 ;
      cmbDisponibilidadTipoCita.setJsonclick( "" );
      cmbDisponibilidadTipoCita.setEnabled( 1 );
      cmbDisponibilidadEstadoCita.setJsonclick( "" );
      cmbDisponibilidadEstadoCita.setEnabled( 1 );
      cmbDisponibilidadEstado.setJsonclick( "" );
      cmbDisponibilidadEstado.setEnabled( 1 );
      edtDisponibilidadUser_Jsonclick = "" ;
      edtDisponibilidadUser_Enabled = 1 ;
      edtEspecialidadNombre_Jsonclick = "" ;
      edtEspecialidadNombre_Enabled = 0 ;
      edtEspecialidadCodigo_Jsonclick = "" ;
      edtEspecialidadCodigo_Enabled = 0 ;
      edtEspecialidadId_Jsonclick = "" ;
      edtEspecialidadId_Enabled = 1 ;
      edtEspecialidadId_Visible = 1 ;
      Combo_especialidadid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_especialidadid_Datalistproc = "DisponibilidadLoadDVCombo" ;
      Combo_especialidadid_Cls = "ExtendedCombo Attribute" ;
      Combo_especialidadid_Caption = "" ;
      Combo_especialidadid_Enabled = GXutil.toBoolean( -1) ;
      edtDisponibilidadHoraFin_Jsonclick = "" ;
      edtDisponibilidadHoraFin_Enabled = 1 ;
      edtDisponibilidadHoraInicio_Jsonclick = "" ;
      edtDisponibilidadHoraInicio_Enabled = 1 ;
      edtDisponibilidadFecha_Jsonclick = "" ;
      edtDisponibilidadFecha_Enabled = 1 ;
      edtProfesionalCOP_Jsonclick = "" ;
      edtProfesionalCOP_Enabled = 0 ;
      edtProfesionalNombreCompleto_Jsonclick = "" ;
      edtProfesionalNombreCompleto_Enabled = 0 ;
      edtProfesionalNombres_Jsonclick = "" ;
      edtProfesionalNombres_Enabled = 0 ;
      edtProfesionalApellidoMaterno_Jsonclick = "" ;
      edtProfesionalApellidoMaterno_Enabled = 0 ;
      edtProfesionalApellidoPaterno_Jsonclick = "" ;
      edtProfesionalApellidoPaterno_Enabled = 0 ;
      edtProfesionalId_Jsonclick = "" ;
      edtProfesionalId_Enabled = 1 ;
      edtProfesionalId_Visible = 1 ;
      Combo_profesionalid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_profesionalid_Datalistprocparametersprefix = " \"ComboName\": \"ProfesionalId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"DisponibilidadId\": 0" ;
      Combo_profesionalid_Datalistproc = "DisponibilidadLoadDVCombo" ;
      Combo_profesionalid_Cls = "ExtendedCombo Attribute" ;
      Combo_profesionalid_Caption = "" ;
      Combo_profesionalid_Enabled = GXutil.toBoolean( -1) ;
      edtDisponibilidadDescription_Jsonclick = "" ;
      edtDisponibilidadDescription_Enabled = 1 ;
      edtEventId_Jsonclick = "" ;
      edtEventId_Enabled = 1 ;
      edtDisponibilidadId_Jsonclick = "" ;
      edtDisponibilidadId_Enabled = 0 ;
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
      cmbDisponibilidadEstado.setName( "DISPONIBILIDADESTADO" );
      cmbDisponibilidadEstado.setWebtags( "" );
      cmbDisponibilidadEstado.addItem("A", "Activo", (short)(0));
      cmbDisponibilidadEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbDisponibilidadEstado.getItemCount() > 0 )
      {
         A136DisponibilidadEstado = cmbDisponibilidadEstado.getValidValue(A136DisponibilidadEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A136DisponibilidadEstado", A136DisponibilidadEstado);
      }
      cmbDisponibilidadEstadoCita.setName( "DISPONIBILIDADESTADOCITA" );
      cmbDisponibilidadEstadoCita.setWebtags( "" );
      cmbDisponibilidadEstadoCita.addItem("L", "Libre", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("O", "Ocupado", (short)(0));
      cmbDisponibilidadEstadoCita.addItem("E", "Expiró", (short)(0));
      if ( cmbDisponibilidadEstadoCita.getItemCount() > 0 )
      {
         A139DisponibilidadEstadoCita = cmbDisponibilidadEstadoCita.getValidValue(A139DisponibilidadEstadoCita) ;
         httpContext.ajax_rsp_assign_attri("", false, "A139DisponibilidadEstadoCita", A139DisponibilidadEstadoCita);
      }
      cmbDisponibilidadTipoCita.setName( "DISPONIBILIDADTIPOCITA" );
      cmbDisponibilidadTipoCita.setWebtags( "" );
      cmbDisponibilidadTipoCita.addItem("V", "Virtual", (short)(0));
      cmbDisponibilidadTipoCita.addItem("P", "En consultorio", (short)(0));
      cmbDisponibilidadTipoCita.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbDisponibilidadTipoCita.getItemCount() > 0 )
      {
         A298DisponibilidadTipoCita = cmbDisponibilidadTipoCita.getValidValue(A298DisponibilidadTipoCita) ;
         httpContext.ajax_rsp_assign_attri("", false, "A298DisponibilidadTipoCita", A298DisponibilidadTipoCita);
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

   public void valid_Disponibilidadid( )
   {
      n34DisponibilidadId = false ;
      n138DCitaId = false ;
      /* Using cursor T000J27 */
      pr_default.execute(21, new Object[] {Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId), Boolean.valueOf(n34DisponibilidadId), Integer.valueOf(A34DisponibilidadId)});
      if ( (pr_default.getStatus(21) != 101) )
      {
         A138DCitaId = T000J27_A138DCitaId[0] ;
         n138DCitaId = T000J27_n138DCitaId[0] ;
      }
      else
      {
         A138DCitaId = 0 ;
         n138DCitaId = false ;
      }
      pr_default.close(21);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A138DCitaId", GXutil.ltrim( localUtil.ntoc( A138DCitaId, (byte)(6), (byte)(0), ".", "")));
   }

   public void valid_Profesionalid( )
   {
      /* Using cursor T000J28 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
      }
      A85ProfesionalApellidoPaterno = T000J28_A85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = T000J28_A86ProfesionalApellidoMaterno[0] ;
      A84ProfesionalNombres = T000J28_A84ProfesionalNombres[0] ;
      A88ProfesionalCOP = T000J28_A88ProfesionalCOP[0] ;
      pr_default.close(22);
      A83ProfesionalNombreCompleto = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
      httpContext.ajax_rsp_assign_attri("", false, "A83ProfesionalNombreCompleto", A83ProfesionalNombreCompleto);
   }

   public void valid_Especialidadid( )
   {
      /* Using cursor T000J29 */
      pr_default.execute(23, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
      }
      A140EspecialidadCodigo = T000J29_A140EspecialidadCodigo[0] ;
      A71EspecialidadNombre = T000J29_A71EspecialidadNombre[0] ;
      pr_default.close(23);
      /* Using cursor T000J35 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(29) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
      }
      pr_default.close(29);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
      httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV27DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV27DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120J2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_DISPONIBILIDADID","{handler:'valid_Disponibilidadid',iparms:[{av:'A34DisponibilidadId',fld:'DISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A138DCitaId',fld:'DCITAID',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_DISPONIBILIDADID",",oparms:[{av:'A138DCitaId',fld:'DCITAID',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_PROFESIONALID","{handler:'valid_Profesionalid',iparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'A84ProfesionalNombres',fld:'PROFESIONALNOMBRES',pic:''},{av:'A85ProfesionalApellidoPaterno',fld:'PROFESIONALAPELLIDOPATERNO',pic:''},{av:'A86ProfesionalApellidoMaterno',fld:'PROFESIONALAPELLIDOMATERNO',pic:''},{av:'A88ProfesionalCOP',fld:'PROFESIONALCOP',pic:''},{av:'A83ProfesionalNombreCompleto',fld:'PROFESIONALNOMBRECOMPLETO',pic:''}]");
      setEventMetadata("VALID_PROFESIONALID",",oparms:[{av:'A85ProfesionalApellidoPaterno',fld:'PROFESIONALAPELLIDOPATERNO',pic:''},{av:'A86ProfesionalApellidoMaterno',fld:'PROFESIONALAPELLIDOMATERNO',pic:''},{av:'A84ProfesionalNombres',fld:'PROFESIONALNOMBRES',pic:''},{av:'A88ProfesionalCOP',fld:'PROFESIONALCOP',pic:''},{av:'A83ProfesionalNombreCompleto',fld:'PROFESIONALNOMBRECOMPLETO',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO","{handler:'valid_Profesionalapellidopaterno',iparms:[]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO","{handler:'valid_Profesionalapellidomaterno',iparms:[]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO",",oparms:[]}");
      setEventMetadata("VALID_PROFESIONALNOMBRES","{handler:'valid_Profesionalnombres',iparms:[]");
      setEventMetadata("VALID_PROFESIONALNOMBRES",",oparms:[]}");
      setEventMetadata("VALID_DISPONIBILIDADFECHA","{handler:'valid_Disponibilidadfecha',iparms:[]");
      setEventMetadata("VALID_DISPONIBILIDADFECHA",",oparms:[]}");
      setEventMetadata("VALID_ESPECIALIDADID","{handler:'valid_Especialidadid',iparms:[{av:'A32EspecialidadId',fld:'ESPECIALIDADID',pic:'ZZZ9'},{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'A140EspecialidadCodigo',fld:'ESPECIALIDADCODIGO',pic:''},{av:'A71EspecialidadNombre',fld:'ESPECIALIDADNOMBRE',pic:''}]");
      setEventMetadata("VALID_ESPECIALIDADID",",oparms:[{av:'A140EspecialidadCodigo',fld:'ESPECIALIDADCODIGO',pic:''},{av:'A71EspecialidadNombre',fld:'ESPECIALIDADNOMBRE',pic:''}]}");
      setEventMetadata("VALID_DISPONIBILIDADESTADO","{handler:'valid_Disponibilidadestado',iparms:[]");
      setEventMetadata("VALID_DISPONIBILIDADESTADO",",oparms:[]}");
      setEventMetadata("VALID_DISPONIBILIDADESTADOCITA","{handler:'valid_Disponibilidadestadocita',iparms:[]");
      setEventMetadata("VALID_DISPONIBILIDADESTADOCITA",",oparms:[]}");
      setEventMetadata("VALID_DISPONIBILIDADTIPOCITA","{handler:'valid_Disponibilidadtipocita',iparms:[]");
      setEventMetadata("VALID_DISPONIBILIDADTIPOCITA",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOPROFESIONALID","{handler:'validv_Comboprofesionalid',iparms:[]");
      setEventMetadata("VALIDV_COMBOPROFESIONALID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOESPECIALIDADID","{handler:'validv_Comboespecialidadid',iparms:[]");
      setEventMetadata("VALIDV_COMBOESPECIALIDADID",",oparms:[]}");
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
      pr_default.close(22);
      pr_default.close(29);
      pr_default.close(23);
      pr_default.close(24);
      pr_default.close(25);
      pr_default.close(21);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z133EventId = "" ;
      Z134DisponibilidadDescription = "" ;
      Z67DisponibilidadFecha = GXutil.nullDate() ;
      Z69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      Z135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      Z136DisponibilidadEstado = "" ;
      Z139DisponibilidadEstadoCita = "" ;
      Z298DisponibilidadTipoCita = "" ;
      Combo_especialidadid_Selectedvalue_get = "" ;
      Combo_profesionalid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A136DisponibilidadEstado = "" ;
      A139DisponibilidadEstadoCita = "" ;
      A298DisponibilidadTipoCita = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A133EventId = "" ;
      A134DisponibilidadDescription = "" ;
      lblTextblockprofesionalid_Jsonclick = "" ;
      ucCombo_profesionalid = new com.genexus.webpanels.GXUserControl();
      AV19DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV18ProfesionalId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A83ProfesionalNombreCompleto = "" ;
      A88ProfesionalCOP = "" ;
      A67DisponibilidadFecha = GXutil.nullDate() ;
      A69DisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A135DisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      lblTextblockespecialidadid_Jsonclick = "" ;
      ucCombo_especialidadid = new com.genexus.webpanels.GXUserControl();
      AV24EspecialidadId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A74SGSedeDisponibilidadSedeNombre = "" ;
      A79SGSedeDisponibilidadClinicaAbreviado = "" ;
      AV29Pgmname = "" ;
      Combo_profesionalid_Objectcall = "" ;
      Combo_profesionalid_Class = "" ;
      Combo_profesionalid_Icontype = "" ;
      Combo_profesionalid_Icon = "" ;
      Combo_profesionalid_Tooltip = "" ;
      Combo_profesionalid_Selectedvalue_set = "" ;
      Combo_profesionalid_Selectedtext_set = "" ;
      Combo_profesionalid_Selectedtext_get = "" ;
      Combo_profesionalid_Gamoauthtoken = "" ;
      Combo_profesionalid_Ddointernalname = "" ;
      Combo_profesionalid_Titlecontrolalign = "" ;
      Combo_profesionalid_Dropdownoptionstype = "" ;
      Combo_profesionalid_Titlecontrolidtoreplace = "" ;
      Combo_profesionalid_Datalisttype = "" ;
      Combo_profesionalid_Datalistfixedvalues = "" ;
      Combo_profesionalid_Htmltemplate = "" ;
      Combo_profesionalid_Multiplevaluestype = "" ;
      Combo_profesionalid_Loadingdata = "" ;
      Combo_profesionalid_Noresultsfound = "" ;
      Combo_profesionalid_Emptyitemtext = "" ;
      Combo_profesionalid_Onlyselectedvalues = "" ;
      Combo_profesionalid_Selectalltext = "" ;
      Combo_profesionalid_Multiplevaluesseparator = "" ;
      Combo_profesionalid_Addnewoptiontext = "" ;
      Combo_especialidadid_Objectcall = "" ;
      Combo_especialidadid_Class = "" ;
      Combo_especialidadid_Icontype = "" ;
      Combo_especialidadid_Icon = "" ;
      Combo_especialidadid_Tooltip = "" ;
      Combo_especialidadid_Selectedvalue_set = "" ;
      Combo_especialidadid_Selectedtext_set = "" ;
      Combo_especialidadid_Selectedtext_get = "" ;
      Combo_especialidadid_Gamoauthtoken = "" ;
      Combo_especialidadid_Ddointernalname = "" ;
      Combo_especialidadid_Titlecontrolalign = "" ;
      Combo_especialidadid_Dropdownoptionstype = "" ;
      Combo_especialidadid_Titlecontrolidtoreplace = "" ;
      Combo_especialidadid_Datalisttype = "" ;
      Combo_especialidadid_Datalistfixedvalues = "" ;
      Combo_especialidadid_Htmltemplate = "" ;
      Combo_especialidadid_Multiplevaluestype = "" ;
      Combo_especialidadid_Loadingdata = "" ;
      Combo_especialidadid_Noresultsfound = "" ;
      Combo_especialidadid_Emptyitemtext = "" ;
      Combo_especialidadid_Onlyselectedvalues = "" ;
      Combo_especialidadid_Selectalltext = "" ;
      Combo_especialidadid_Multiplevaluesseparator = "" ;
      Combo_especialidadid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode26 = "" ;
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
      AV14TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV22Combo_DataJson = "" ;
      AV20ComboSelectedValue = "" ;
      AV21ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z74SGSedeDisponibilidadSedeNombre = "" ;
      Z79SGSedeDisponibilidadClinicaAbreviado = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      Z84ProfesionalNombres = "" ;
      Z88ProfesionalCOP = "" ;
      Z140EspecialidadCodigo = "" ;
      Z71EspecialidadNombre = "" ;
      T000J10_A138DCitaId = new int[1] ;
      T000J10_n138DCitaId = new boolean[] {false} ;
      T000J7_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      T000J7_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      T000J8_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      T000J4_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000J4_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000J4_A84ProfesionalNombres = new String[] {""} ;
      T000J4_A88ProfesionalCOP = new String[] {""} ;
      T000J5_A140EspecialidadCodigo = new String[] {""} ;
      T000J5_A71EspecialidadNombre = new String[] {""} ;
      T000J12_A34DisponibilidadId = new int[1] ;
      T000J12_n34DisponibilidadId = new boolean[] {false} ;
      T000J12_A133EventId = new String[] {""} ;
      T000J12_A134DisponibilidadDescription = new String[] {""} ;
      T000J12_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000J12_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000J12_A84ProfesionalNombres = new String[] {""} ;
      T000J12_A88ProfesionalCOP = new String[] {""} ;
      T000J12_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000J12_n67DisponibilidadFecha = new boolean[] {false} ;
      T000J12_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T000J12_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      T000J12_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      T000J12_n135DisponibilidadHoraFin = new boolean[] {false} ;
      T000J12_A140EspecialidadCodigo = new String[] {""} ;
      T000J12_A71EspecialidadNombre = new String[] {""} ;
      T000J12_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      T000J12_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      T000J12_A137DisponibilidadUser = new int[1] ;
      T000J12_A136DisponibilidadEstado = new String[] {""} ;
      T000J12_A139DisponibilidadEstadoCita = new String[] {""} ;
      T000J12_A298DisponibilidadTipoCita = new String[] {""} ;
      T000J12_A31ProfesionalId = new int[1] ;
      T000J12_A32EspecialidadId = new short[1] ;
      T000J12_A35SGSedeDisponibilidadSedeId = new short[1] ;
      T000J12_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      T000J12_A138DCitaId = new int[1] ;
      T000J12_n138DCitaId = new boolean[] {false} ;
      T000J6_A31ProfesionalId = new int[1] ;
      T000J14_A138DCitaId = new int[1] ;
      T000J14_n138DCitaId = new boolean[] {false} ;
      T000J15_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000J15_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000J15_A84ProfesionalNombres = new String[] {""} ;
      T000J15_A88ProfesionalCOP = new String[] {""} ;
      T000J16_A31ProfesionalId = new int[1] ;
      T000J17_A140EspecialidadCodigo = new String[] {""} ;
      T000J17_A71EspecialidadNombre = new String[] {""} ;
      T000J18_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      T000J18_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      T000J19_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      T000J20_A34DisponibilidadId = new int[1] ;
      T000J20_n34DisponibilidadId = new boolean[] {false} ;
      T000J3_A34DisponibilidadId = new int[1] ;
      T000J3_n34DisponibilidadId = new boolean[] {false} ;
      T000J3_A133EventId = new String[] {""} ;
      T000J3_A134DisponibilidadDescription = new String[] {""} ;
      T000J3_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000J3_n67DisponibilidadFecha = new boolean[] {false} ;
      T000J3_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T000J3_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      T000J3_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      T000J3_n135DisponibilidadHoraFin = new boolean[] {false} ;
      T000J3_A137DisponibilidadUser = new int[1] ;
      T000J3_A136DisponibilidadEstado = new String[] {""} ;
      T000J3_A139DisponibilidadEstadoCita = new String[] {""} ;
      T000J3_A298DisponibilidadTipoCita = new String[] {""} ;
      T000J3_A31ProfesionalId = new int[1] ;
      T000J3_A32EspecialidadId = new short[1] ;
      T000J3_A35SGSedeDisponibilidadSedeId = new short[1] ;
      T000J21_A34DisponibilidadId = new int[1] ;
      T000J21_n34DisponibilidadId = new boolean[] {false} ;
      T000J22_A34DisponibilidadId = new int[1] ;
      T000J22_n34DisponibilidadId = new boolean[] {false} ;
      T000J2_A34DisponibilidadId = new int[1] ;
      T000J2_n34DisponibilidadId = new boolean[] {false} ;
      T000J2_A133EventId = new String[] {""} ;
      T000J2_A134DisponibilidadDescription = new String[] {""} ;
      T000J2_A67DisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000J2_n67DisponibilidadFecha = new boolean[] {false} ;
      T000J2_A69DisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      T000J2_n69DisponibilidadHoraInicio = new boolean[] {false} ;
      T000J2_A135DisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      T000J2_n135DisponibilidadHoraFin = new boolean[] {false} ;
      T000J2_A137DisponibilidadUser = new int[1] ;
      T000J2_A136DisponibilidadEstado = new String[] {""} ;
      T000J2_A139DisponibilidadEstadoCita = new String[] {""} ;
      T000J2_A298DisponibilidadTipoCita = new String[] {""} ;
      T000J2_A31ProfesionalId = new int[1] ;
      T000J2_A32EspecialidadId = new short[1] ;
      T000J2_A35SGSedeDisponibilidadSedeId = new short[1] ;
      T000J23_A34DisponibilidadId = new int[1] ;
      T000J23_n34DisponibilidadId = new boolean[] {false} ;
      T000J27_A138DCitaId = new int[1] ;
      T000J27_n138DCitaId = new boolean[] {false} ;
      T000J28_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000J28_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000J28_A84ProfesionalNombres = new String[] {""} ;
      T000J28_A88ProfesionalCOP = new String[] {""} ;
      T000J29_A140EspecialidadCodigo = new String[] {""} ;
      T000J29_A71EspecialidadNombre = new String[] {""} ;
      T000J30_A74SGSedeDisponibilidadSedeNombre = new String[] {""} ;
      T000J30_A77SGSedeDisponibilidadClinicaId = new short[1] ;
      T000J31_A79SGSedeDisponibilidadClinicaAbreviado = new String[] {""} ;
      T000J32_A47PagoId = new int[1] ;
      T000J33_A19CitaId = new int[1] ;
      T000J34_A34DisponibilidadId = new int[1] ;
      T000J34_n34DisponibilidadId = new boolean[] {false} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Z83ProfesionalNombreCompleto = "" ;
      T000J35_A31ProfesionalId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.disponibilidad__default(),
         new Object[] {
             new Object[] {
            T000J2_A34DisponibilidadId, T000J2_A133EventId, T000J2_A134DisponibilidadDescription, T000J2_A67DisponibilidadFecha, T000J2_n67DisponibilidadFecha, T000J2_A69DisponibilidadHoraInicio, T000J2_n69DisponibilidadHoraInicio, T000J2_A135DisponibilidadHoraFin, T000J2_n135DisponibilidadHoraFin, T000J2_A137DisponibilidadUser,
            T000J2_A136DisponibilidadEstado, T000J2_A139DisponibilidadEstadoCita, T000J2_A298DisponibilidadTipoCita, T000J2_A31ProfesionalId, T000J2_A32EspecialidadId, T000J2_A35SGSedeDisponibilidadSedeId
            }
            , new Object[] {
            T000J3_A34DisponibilidadId, T000J3_A133EventId, T000J3_A134DisponibilidadDescription, T000J3_A67DisponibilidadFecha, T000J3_n67DisponibilidadFecha, T000J3_A69DisponibilidadHoraInicio, T000J3_n69DisponibilidadHoraInicio, T000J3_A135DisponibilidadHoraFin, T000J3_n135DisponibilidadHoraFin, T000J3_A137DisponibilidadUser,
            T000J3_A136DisponibilidadEstado, T000J3_A139DisponibilidadEstadoCita, T000J3_A298DisponibilidadTipoCita, T000J3_A31ProfesionalId, T000J3_A32EspecialidadId, T000J3_A35SGSedeDisponibilidadSedeId
            }
            , new Object[] {
            T000J4_A85ProfesionalApellidoPaterno, T000J4_A86ProfesionalApellidoMaterno, T000J4_A84ProfesionalNombres, T000J4_A88ProfesionalCOP
            }
            , new Object[] {
            T000J5_A140EspecialidadCodigo, T000J5_A71EspecialidadNombre
            }
            , new Object[] {
            T000J6_A31ProfesionalId
            }
            , new Object[] {
            T000J7_A74SGSedeDisponibilidadSedeNombre, T000J7_A77SGSedeDisponibilidadClinicaId
            }
            , new Object[] {
            T000J8_A79SGSedeDisponibilidadClinicaAbreviado
            }
            , new Object[] {
            T000J10_A138DCitaId, T000J10_n138DCitaId
            }
            , new Object[] {
            T000J12_A34DisponibilidadId, T000J12_A133EventId, T000J12_A134DisponibilidadDescription, T000J12_A85ProfesionalApellidoPaterno, T000J12_A86ProfesionalApellidoMaterno, T000J12_A84ProfesionalNombres, T000J12_A88ProfesionalCOP, T000J12_A67DisponibilidadFecha, T000J12_n67DisponibilidadFecha, T000J12_A69DisponibilidadHoraInicio,
            T000J12_n69DisponibilidadHoraInicio, T000J12_A135DisponibilidadHoraFin, T000J12_n135DisponibilidadHoraFin, T000J12_A140EspecialidadCodigo, T000J12_A71EspecialidadNombre, T000J12_A74SGSedeDisponibilidadSedeNombre, T000J12_A79SGSedeDisponibilidadClinicaAbreviado, T000J12_A137DisponibilidadUser, T000J12_A136DisponibilidadEstado, T000J12_A139DisponibilidadEstadoCita,
            T000J12_A298DisponibilidadTipoCita, T000J12_A31ProfesionalId, T000J12_A32EspecialidadId, T000J12_A35SGSedeDisponibilidadSedeId, T000J12_A77SGSedeDisponibilidadClinicaId, T000J12_A138DCitaId, T000J12_n138DCitaId
            }
            , new Object[] {
            T000J14_A138DCitaId, T000J14_n138DCitaId
            }
            , new Object[] {
            T000J15_A85ProfesionalApellidoPaterno, T000J15_A86ProfesionalApellidoMaterno, T000J15_A84ProfesionalNombres, T000J15_A88ProfesionalCOP
            }
            , new Object[] {
            T000J16_A31ProfesionalId
            }
            , new Object[] {
            T000J17_A140EspecialidadCodigo, T000J17_A71EspecialidadNombre
            }
            , new Object[] {
            T000J18_A74SGSedeDisponibilidadSedeNombre, T000J18_A77SGSedeDisponibilidadClinicaId
            }
            , new Object[] {
            T000J19_A79SGSedeDisponibilidadClinicaAbreviado
            }
            , new Object[] {
            T000J20_A34DisponibilidadId
            }
            , new Object[] {
            T000J21_A34DisponibilidadId
            }
            , new Object[] {
            T000J22_A34DisponibilidadId
            }
            , new Object[] {
            T000J23_A34DisponibilidadId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000J27_A138DCitaId, T000J27_n138DCitaId
            }
            , new Object[] {
            T000J28_A85ProfesionalApellidoPaterno, T000J28_A86ProfesionalApellidoMaterno, T000J28_A84ProfesionalNombres, T000J28_A88ProfesionalCOP
            }
            , new Object[] {
            T000J29_A140EspecialidadCodigo, T000J29_A71EspecialidadNombre
            }
            , new Object[] {
            T000J30_A74SGSedeDisponibilidadSedeNombre, T000J30_A77SGSedeDisponibilidadClinicaId
            }
            , new Object[] {
            T000J31_A79SGSedeDisponibilidadClinicaAbreviado
            }
            , new Object[] {
            T000J32_A47PagoId
            }
            , new Object[] {
            T000J33_A19CitaId
            }
            , new Object[] {
            T000J34_A34DisponibilidadId
            }
            , new Object[] {
            T000J35_A31ProfesionalId
            }
         }
      );
      AV29Pgmname = "Disponibilidad" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z32EspecialidadId ;
   private short Z35SGSedeDisponibilidadSedeId ;
   private short N32EspecialidadId ;
   private short N35SGSedeDisponibilidadSedeId ;
   private short A32EspecialidadId ;
   private short A35SGSedeDisponibilidadSedeId ;
   private short A77SGSedeDisponibilidadClinicaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV25ComboEspecialidadId ;
   private short AV13Insert_EspecialidadId ;
   private short AV16Insert_SGSedeDisponibilidadSedeId ;
   private short RcdFound26 ;
   private short Z77SGSedeDisponibilidadClinicaId ;
   private short nIsDirty_26 ;
   private int wcpOAV27DisponibilidadId ;
   private int Z34DisponibilidadId ;
   private int Z137DisponibilidadUser ;
   private int Z31ProfesionalId ;
   private int N31ProfesionalId ;
   private int A34DisponibilidadId ;
   private int A31ProfesionalId ;
   private int AV27DisponibilidadId ;
   private int trnEnded ;
   private int edtDisponibilidadId_Enabled ;
   private int edtEventId_Enabled ;
   private int edtDisponibilidadDescription_Enabled ;
   private int edtProfesionalId_Visible ;
   private int edtProfesionalId_Enabled ;
   private int edtProfesionalApellidoPaterno_Enabled ;
   private int edtProfesionalApellidoMaterno_Enabled ;
   private int edtProfesionalNombres_Enabled ;
   private int edtProfesionalNombreCompleto_Enabled ;
   private int edtProfesionalCOP_Enabled ;
   private int edtDisponibilidadFecha_Enabled ;
   private int edtDisponibilidadHoraInicio_Enabled ;
   private int edtDisponibilidadHoraFin_Enabled ;
   private int edtEspecialidadId_Visible ;
   private int edtEspecialidadId_Enabled ;
   private int edtEspecialidadCodigo_Enabled ;
   private int edtEspecialidadNombre_Enabled ;
   private int A137DisponibilidadUser ;
   private int edtDisponibilidadUser_Enabled ;
   private int A138DCitaId ;
   private int edtDCitaId_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV23ComboProfesionalId ;
   private int edtavComboprofesionalid_Enabled ;
   private int edtavComboprofesionalid_Visible ;
   private int edtavComboespecialidadid_Enabled ;
   private int edtavComboespecialidadid_Visible ;
   private int AV26Cond_ProfesionalId ;
   private int AV12Insert_ProfesionalId ;
   private int Combo_profesionalid_Datalistupdateminimumcharacters ;
   private int Combo_especialidadid_Datalistupdateminimumcharacters ;
   private int AV30GXV1 ;
   private int GX_JID ;
   private int Z138DCitaId ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z133EventId ;
   private String Z136DisponibilidadEstado ;
   private String Z298DisponibilidadTipoCita ;
   private String Combo_especialidadid_Selectedvalue_get ;
   private String Combo_profesionalid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEventId_Internalname ;
   private String A136DisponibilidadEstado ;
   private String A298DisponibilidadTipoCita ;
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
   private String edtDisponibilidadId_Internalname ;
   private String edtDisponibilidadId_Jsonclick ;
   private String TempTags ;
   private String A133EventId ;
   private String edtEventId_Jsonclick ;
   private String edtDisponibilidadDescription_Internalname ;
   private String edtDisponibilidadDescription_Jsonclick ;
   private String divTablesplittedprofesionalid_Internalname ;
   private String lblTextblockprofesionalid_Internalname ;
   private String lblTextblockprofesionalid_Jsonclick ;
   private String Combo_profesionalid_Caption ;
   private String Combo_profesionalid_Cls ;
   private String Combo_profesionalid_Datalistproc ;
   private String Combo_profesionalid_Datalistprocparametersprefix ;
   private String Combo_profesionalid_Internalname ;
   private String edtProfesionalId_Internalname ;
   private String edtProfesionalId_Jsonclick ;
   private String edtProfesionalApellidoPaterno_Internalname ;
   private String edtProfesionalApellidoPaterno_Jsonclick ;
   private String edtProfesionalApellidoMaterno_Internalname ;
   private String edtProfesionalApellidoMaterno_Jsonclick ;
   private String edtProfesionalNombres_Internalname ;
   private String edtProfesionalNombres_Jsonclick ;
   private String edtProfesionalNombreCompleto_Internalname ;
   private String edtProfesionalNombreCompleto_Jsonclick ;
   private String edtProfesionalCOP_Internalname ;
   private String edtProfesionalCOP_Jsonclick ;
   private String edtDisponibilidadFecha_Internalname ;
   private String edtDisponibilidadFecha_Jsonclick ;
   private String edtDisponibilidadHoraInicio_Internalname ;
   private String edtDisponibilidadHoraInicio_Jsonclick ;
   private String edtDisponibilidadHoraFin_Internalname ;
   private String edtDisponibilidadHoraFin_Jsonclick ;
   private String divTablesplittedespecialidadid_Internalname ;
   private String lblTextblockespecialidadid_Internalname ;
   private String lblTextblockespecialidadid_Jsonclick ;
   private String Combo_especialidadid_Caption ;
   private String Combo_especialidadid_Cls ;
   private String Combo_especialidadid_Datalistproc ;
   private String Combo_especialidadid_Internalname ;
   private String edtEspecialidadId_Internalname ;
   private String edtEspecialidadId_Jsonclick ;
   private String edtEspecialidadCodigo_Internalname ;
   private String edtEspecialidadCodigo_Jsonclick ;
   private String edtEspecialidadNombre_Internalname ;
   private String edtEspecialidadNombre_Jsonclick ;
   private String edtDisponibilidadUser_Internalname ;
   private String edtDisponibilidadUser_Jsonclick ;
   private String edtDCitaId_Internalname ;
   private String edtDCitaId_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_profesionalid_Internalname ;
   private String edtavComboprofesionalid_Internalname ;
   private String edtavComboprofesionalid_Jsonclick ;
   private String divSectionattribute_especialidadid_Internalname ;
   private String edtavComboespecialidadid_Internalname ;
   private String edtavComboespecialidadid_Jsonclick ;
   private String AV29Pgmname ;
   private String Combo_profesionalid_Objectcall ;
   private String Combo_profesionalid_Class ;
   private String Combo_profesionalid_Icontype ;
   private String Combo_profesionalid_Icon ;
   private String Combo_profesionalid_Tooltip ;
   private String Combo_profesionalid_Selectedvalue_set ;
   private String Combo_profesionalid_Selectedtext_set ;
   private String Combo_profesionalid_Selectedtext_get ;
   private String Combo_profesionalid_Gamoauthtoken ;
   private String Combo_profesionalid_Ddointernalname ;
   private String Combo_profesionalid_Titlecontrolalign ;
   private String Combo_profesionalid_Dropdownoptionstype ;
   private String Combo_profesionalid_Titlecontrolidtoreplace ;
   private String Combo_profesionalid_Datalisttype ;
   private String Combo_profesionalid_Datalistfixedvalues ;
   private String Combo_profesionalid_Htmltemplate ;
   private String Combo_profesionalid_Multiplevaluestype ;
   private String Combo_profesionalid_Loadingdata ;
   private String Combo_profesionalid_Noresultsfound ;
   private String Combo_profesionalid_Emptyitemtext ;
   private String Combo_profesionalid_Onlyselectedvalues ;
   private String Combo_profesionalid_Selectalltext ;
   private String Combo_profesionalid_Multiplevaluesseparator ;
   private String Combo_profesionalid_Addnewoptiontext ;
   private String Combo_especialidadid_Objectcall ;
   private String Combo_especialidadid_Class ;
   private String Combo_especialidadid_Icontype ;
   private String Combo_especialidadid_Icon ;
   private String Combo_especialidadid_Tooltip ;
   private String Combo_especialidadid_Selectedvalue_set ;
   private String Combo_especialidadid_Selectedtext_set ;
   private String Combo_especialidadid_Selectedtext_get ;
   private String Combo_especialidadid_Gamoauthtoken ;
   private String Combo_especialidadid_Ddointernalname ;
   private String Combo_especialidadid_Titlecontrolalign ;
   private String Combo_especialidadid_Dropdownoptionstype ;
   private String Combo_especialidadid_Titlecontrolidtoreplace ;
   private String Combo_especialidadid_Datalisttype ;
   private String Combo_especialidadid_Datalistfixedvalues ;
   private String Combo_especialidadid_Datalistprocparametersprefix ;
   private String Combo_especialidadid_Htmltemplate ;
   private String Combo_especialidadid_Multiplevaluestype ;
   private String Combo_especialidadid_Loadingdata ;
   private String Combo_especialidadid_Noresultsfound ;
   private String Combo_especialidadid_Emptyitemtext ;
   private String Combo_especialidadid_Onlyselectedvalues ;
   private String Combo_especialidadid_Selectalltext ;
   private String Combo_especialidadid_Multiplevaluesseparator ;
   private String Combo_especialidadid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode26 ;
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
   private java.util.Date Z69DisponibilidadHoraInicio ;
   private java.util.Date Z135DisponibilidadHoraFin ;
   private java.util.Date A69DisponibilidadHoraInicio ;
   private java.util.Date A135DisponibilidadHoraFin ;
   private java.util.Date Z67DisponibilidadFecha ;
   private java.util.Date A67DisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n34DisponibilidadId ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_profesionalid_Emptyitem ;
   private boolean Combo_especialidadid_Emptyitem ;
   private boolean n67DisponibilidadFecha ;
   private boolean n69DisponibilidadHoraInicio ;
   private boolean n135DisponibilidadHoraFin ;
   private boolean Combo_profesionalid_Enabled ;
   private boolean Combo_profesionalid_Visible ;
   private boolean Combo_profesionalid_Allowmultipleselection ;
   private boolean Combo_profesionalid_Isgriditem ;
   private boolean Combo_profesionalid_Hasdescription ;
   private boolean Combo_profesionalid_Includeonlyselectedoption ;
   private boolean Combo_profesionalid_Includeselectalloption ;
   private boolean Combo_profesionalid_Includeaddnewoption ;
   private boolean Combo_especialidadid_Enabled ;
   private boolean Combo_especialidadid_Visible ;
   private boolean Combo_especialidadid_Allowmultipleselection ;
   private boolean Combo_especialidadid_Isgriditem ;
   private boolean Combo_especialidadid_Hasdescription ;
   private boolean Combo_especialidadid_Includeonlyselectedoption ;
   private boolean Combo_especialidadid_Includeselectalloption ;
   private boolean Combo_especialidadid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n138DCitaId ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String AV22Combo_DataJson ;
   private String Z134DisponibilidadDescription ;
   private String Z139DisponibilidadEstadoCita ;
   private String A139DisponibilidadEstadoCita ;
   private String A134DisponibilidadDescription ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A83ProfesionalNombreCompleto ;
   private String A88ProfesionalCOP ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A74SGSedeDisponibilidadSedeNombre ;
   private String A79SGSedeDisponibilidadClinicaAbreviado ;
   private String AV20ComboSelectedValue ;
   private String AV21ComboSelectedText ;
   private String Z74SGSedeDisponibilidadSedeNombre ;
   private String Z79SGSedeDisponibilidadClinicaAbreviado ;
   private String Z85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String Z84ProfesionalNombres ;
   private String Z88ProfesionalCOP ;
   private String Z140EspecialidadCodigo ;
   private String Z71EspecialidadNombre ;
   private String Z83ProfesionalNombreCompleto ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_profesionalid ;
   private com.genexus.webpanels.GXUserControl ucCombo_especialidadid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbDisponibilidadEstado ;
   private HTMLChoice cmbDisponibilidadEstadoCita ;
   private HTMLChoice cmbDisponibilidadTipoCita ;
   private IDataStoreProvider pr_default ;
   private int[] T000J10_A138DCitaId ;
   private boolean[] T000J10_n138DCitaId ;
   private String[] T000J7_A74SGSedeDisponibilidadSedeNombre ;
   private short[] T000J7_A77SGSedeDisponibilidadClinicaId ;
   private String[] T000J8_A79SGSedeDisponibilidadClinicaAbreviado ;
   private String[] T000J4_A85ProfesionalApellidoPaterno ;
   private String[] T000J4_A86ProfesionalApellidoMaterno ;
   private String[] T000J4_A84ProfesionalNombres ;
   private String[] T000J4_A88ProfesionalCOP ;
   private String[] T000J5_A140EspecialidadCodigo ;
   private String[] T000J5_A71EspecialidadNombre ;
   private int[] T000J12_A34DisponibilidadId ;
   private boolean[] T000J12_n34DisponibilidadId ;
   private String[] T000J12_A133EventId ;
   private String[] T000J12_A134DisponibilidadDescription ;
   private String[] T000J12_A85ProfesionalApellidoPaterno ;
   private String[] T000J12_A86ProfesionalApellidoMaterno ;
   private String[] T000J12_A84ProfesionalNombres ;
   private String[] T000J12_A88ProfesionalCOP ;
   private java.util.Date[] T000J12_A67DisponibilidadFecha ;
   private boolean[] T000J12_n67DisponibilidadFecha ;
   private java.util.Date[] T000J12_A69DisponibilidadHoraInicio ;
   private boolean[] T000J12_n69DisponibilidadHoraInicio ;
   private java.util.Date[] T000J12_A135DisponibilidadHoraFin ;
   private boolean[] T000J12_n135DisponibilidadHoraFin ;
   private String[] T000J12_A140EspecialidadCodigo ;
   private String[] T000J12_A71EspecialidadNombre ;
   private String[] T000J12_A74SGSedeDisponibilidadSedeNombre ;
   private String[] T000J12_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] T000J12_A137DisponibilidadUser ;
   private String[] T000J12_A136DisponibilidadEstado ;
   private String[] T000J12_A139DisponibilidadEstadoCita ;
   private String[] T000J12_A298DisponibilidadTipoCita ;
   private int[] T000J12_A31ProfesionalId ;
   private short[] T000J12_A32EspecialidadId ;
   private short[] T000J12_A35SGSedeDisponibilidadSedeId ;
   private short[] T000J12_A77SGSedeDisponibilidadClinicaId ;
   private int[] T000J12_A138DCitaId ;
   private boolean[] T000J12_n138DCitaId ;
   private int[] T000J6_A31ProfesionalId ;
   private int[] T000J14_A138DCitaId ;
   private boolean[] T000J14_n138DCitaId ;
   private String[] T000J15_A85ProfesionalApellidoPaterno ;
   private String[] T000J15_A86ProfesionalApellidoMaterno ;
   private String[] T000J15_A84ProfesionalNombres ;
   private String[] T000J15_A88ProfesionalCOP ;
   private int[] T000J16_A31ProfesionalId ;
   private String[] T000J17_A140EspecialidadCodigo ;
   private String[] T000J17_A71EspecialidadNombre ;
   private String[] T000J18_A74SGSedeDisponibilidadSedeNombre ;
   private short[] T000J18_A77SGSedeDisponibilidadClinicaId ;
   private String[] T000J19_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] T000J20_A34DisponibilidadId ;
   private boolean[] T000J20_n34DisponibilidadId ;
   private int[] T000J3_A34DisponibilidadId ;
   private boolean[] T000J3_n34DisponibilidadId ;
   private String[] T000J3_A133EventId ;
   private String[] T000J3_A134DisponibilidadDescription ;
   private java.util.Date[] T000J3_A67DisponibilidadFecha ;
   private boolean[] T000J3_n67DisponibilidadFecha ;
   private java.util.Date[] T000J3_A69DisponibilidadHoraInicio ;
   private boolean[] T000J3_n69DisponibilidadHoraInicio ;
   private java.util.Date[] T000J3_A135DisponibilidadHoraFin ;
   private boolean[] T000J3_n135DisponibilidadHoraFin ;
   private int[] T000J3_A137DisponibilidadUser ;
   private String[] T000J3_A136DisponibilidadEstado ;
   private String[] T000J3_A139DisponibilidadEstadoCita ;
   private String[] T000J3_A298DisponibilidadTipoCita ;
   private int[] T000J3_A31ProfesionalId ;
   private short[] T000J3_A32EspecialidadId ;
   private short[] T000J3_A35SGSedeDisponibilidadSedeId ;
   private int[] T000J21_A34DisponibilidadId ;
   private boolean[] T000J21_n34DisponibilidadId ;
   private int[] T000J22_A34DisponibilidadId ;
   private boolean[] T000J22_n34DisponibilidadId ;
   private int[] T000J2_A34DisponibilidadId ;
   private boolean[] T000J2_n34DisponibilidadId ;
   private String[] T000J2_A133EventId ;
   private String[] T000J2_A134DisponibilidadDescription ;
   private java.util.Date[] T000J2_A67DisponibilidadFecha ;
   private boolean[] T000J2_n67DisponibilidadFecha ;
   private java.util.Date[] T000J2_A69DisponibilidadHoraInicio ;
   private boolean[] T000J2_n69DisponibilidadHoraInicio ;
   private java.util.Date[] T000J2_A135DisponibilidadHoraFin ;
   private boolean[] T000J2_n135DisponibilidadHoraFin ;
   private int[] T000J2_A137DisponibilidadUser ;
   private String[] T000J2_A136DisponibilidadEstado ;
   private String[] T000J2_A139DisponibilidadEstadoCita ;
   private String[] T000J2_A298DisponibilidadTipoCita ;
   private int[] T000J2_A31ProfesionalId ;
   private short[] T000J2_A32EspecialidadId ;
   private short[] T000J2_A35SGSedeDisponibilidadSedeId ;
   private int[] T000J23_A34DisponibilidadId ;
   private boolean[] T000J23_n34DisponibilidadId ;
   private int[] T000J27_A138DCitaId ;
   private boolean[] T000J27_n138DCitaId ;
   private String[] T000J28_A85ProfesionalApellidoPaterno ;
   private String[] T000J28_A86ProfesionalApellidoMaterno ;
   private String[] T000J28_A84ProfesionalNombres ;
   private String[] T000J28_A88ProfesionalCOP ;
   private String[] T000J29_A140EspecialidadCodigo ;
   private String[] T000J29_A71EspecialidadNombre ;
   private String[] T000J30_A74SGSedeDisponibilidadSedeNombre ;
   private short[] T000J30_A77SGSedeDisponibilidadClinicaId ;
   private String[] T000J31_A79SGSedeDisponibilidadClinicaAbreviado ;
   private int[] T000J32_A47PagoId ;
   private int[] T000J33_A19CitaId ;
   private int[] T000J34_A34DisponibilidadId ;
   private boolean[] T000J34_n34DisponibilidadId ;
   private int[] T000J35_A31ProfesionalId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV18ProfesionalId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV24EspecialidadId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV14TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class disponibilidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000J2", "SELECT [DisponibilidadId], [EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId FROM [Disponibilidad] WITH (UPDLOCK) WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J3", "SELECT [DisponibilidadId], [EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J4", "SELECT [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalCOP] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J5", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J6", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J7", "SELECT [SedeNombre] AS SGSedeDisponibilidadSedeNombre, [ClinicaId] AS SGSedeDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J8", "SELECT [ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J10", "SELECT COALESCE( T1.[DCitaId], 0) AS DCitaId FROM (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T1 WHERE T1.[SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J12", "SELECT TM1.[DisponibilidadId], TM1.[EventId], TM1.[DisponibilidadDescription], T5.[ProfesionalApellidoPaterno], T5.[ProfesionalApellidoMaterno], T5.[ProfesionalNombres], T5.[ProfesionalCOP], TM1.[DisponibilidadFecha], TM1.[DisponibilidadHoraInicio], TM1.[DisponibilidadHoraFin], T6.[EspecialidadCodigo], T6.[EspecialidadNombre], T2.[SedeNombre] AS SGSedeDisponibilidadSedeNombre, T3.[ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado, TM1.[DisponibilidadUser], TM1.[DisponibilidadEstado], TM1.[DisponibilidadEstadoCita], TM1.[DisponibilidadTipoCita], TM1.[ProfesionalId], TM1.[EspecialidadId], TM1.[SGSedeDisponibilidadSedeId] AS SGSedeDisponibilidadSedeId, T2.[ClinicaId] AS SGSedeDisponibilidadClinicaId, COALESCE( T4.[DCitaId], 0) AS DCitaId FROM ((((([Disponibilidad] TM1 INNER JOIN [Sede] T2 ON T2.[SedeId] = TM1.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) LEFT JOIN (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T4 ON T4.[SGCitaDisponibilidadId] = TM1.[DisponibilidadId]) INNER JOIN [Profesional] T5 ON T5.[ProfesionalId] = TM1.[ProfesionalId]) INNER JOIN [Especialidad] T6 ON T6.[EspecialidadId] = TM1.[EspecialidadId]) WHERE TM1.[DisponibilidadId] = ? ORDER BY TM1.[DisponibilidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J14", "SELECT COALESCE( T1.[DCitaId], 0) AS DCitaId FROM (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T1 WHERE T1.[SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J15", "SELECT [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalCOP] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J16", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J17", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J18", "SELECT [SedeNombre] AS SGSedeDisponibilidadSedeNombre, [ClinicaId] AS SGSedeDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J19", "SELECT [ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J20", "SELECT [DisponibilidadId] FROM [Disponibilidad] WHERE [DisponibilidadId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J21", "SELECT TOP 1 [DisponibilidadId] FROM [Disponibilidad] WHERE ( [DisponibilidadId] > ?) ORDER BY [DisponibilidadId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000J22", "SELECT TOP 1 [DisponibilidadId] FROM [Disponibilidad] WHERE ( [DisponibilidadId] < ?) ORDER BY [DisponibilidadId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000J23", "INSERT INTO [Disponibilidad]([EventId], [DisponibilidadDescription], [DisponibilidadFecha], [DisponibilidadHoraInicio], [DisponibilidadHoraFin], [DisponibilidadUser], [DisponibilidadEstado], [DisponibilidadEstadoCita], [DisponibilidadTipoCita], [ProfesionalId], [EspecialidadId], [SGSedeDisponibilidadSedeId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000J24", "UPDATE [Disponibilidad] SET [EventId]=?, [DisponibilidadDescription]=?, [DisponibilidadFecha]=?, [DisponibilidadHoraInicio]=?, [DisponibilidadHoraFin]=?, [DisponibilidadUser]=?, [DisponibilidadEstado]=?, [DisponibilidadEstadoCita]=?, [DisponibilidadTipoCita]=?, [ProfesionalId]=?, [EspecialidadId]=?, [SGSedeDisponibilidadSedeId]=?  WHERE [DisponibilidadId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000J25", "DELETE FROM [Disponibilidad]  WHERE [DisponibilidadId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000J27", "SELECT COALESCE( T1.[DCitaId], 0) AS DCitaId FROM (SELECT MIN([CitaId]) AS DCitaId, [SGCitaDisponibilidadId] FROM [Cita] WHERE ([SGCitaDisponibilidadId] = ?) AND ([CitaEstado] = 'A') GROUP BY [SGCitaDisponibilidadId] ) T1 WHERE T1.[SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J28", "SELECT [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalCOP] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J29", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J30", "SELECT [SedeNombre] AS SGSedeDisponibilidadSedeNombre, [ClinicaId] AS SGSedeDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J31", "SELECT [ClinicaNombreAbreviado] AS SGSedeDisponibilidadClinicaAbreviado FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J32", "SELECT TOP 1 [PagoId] FROM [Pago] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000J33", "SELECT TOP 1 [CitaId] FROM [Cita] WHERE [SGCitaDisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000J34", "SELECT [DisponibilidadId] FROM [Disponibilidad] ORDER BY [DisponibilidadId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000J35", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((short[]) buf[15])[0] = rslt.getShort(13);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(5));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = GXutil.resetDate(rslt.getGXDateTime(6));
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((int[]) buf[9])[0] = rslt.getInt(7);
               ((String[]) buf[10])[0] = rslt.getString(8, 1);
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((int[]) buf[13])[0] = rslt.getInt(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((short[]) buf[15])[0] = rslt.getShort(13);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[9])[0] = GXutil.resetDate(rslt.getGXDateTime(9));
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[11])[0] = GXutil.resetDate(rslt.getGXDateTime(10));
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((String[]) buf[15])[0] = rslt.getVarchar(13);
               ((String[]) buf[16])[0] = rslt.getVarchar(14);
               ((int[]) buf[17])[0] = rslt.getInt(15);
               ((String[]) buf[18])[0] = rslt.getString(16, 1);
               ((String[]) buf[19])[0] = rslt.getVarchar(17);
               ((String[]) buf[20])[0] = rslt.getString(18, 1);
               ((int[]) buf[21])[0] = rslt.getInt(19);
               ((short[]) buf[22])[0] = rslt.getShort(20);
               ((short[]) buf[23])[0] = rslt.getShort(21);
               ((short[]) buf[24])[0] = rslt.getShort(22);
               ((int[]) buf[25])[0] = rslt.getInt(23);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 23 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 29 :
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 16 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[3]);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(4, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(5, (java.util.Date)parms[7], true);
               }
               stmt.setInt(6, ((Number) parms[8]).intValue());
               stmt.setString(7, (String)parms[9], 1);
               stmt.setVarchar(8, (String)parms[10], 2, false);
               stmt.setString(9, (String)parms[11], 1);
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setShort(11, ((Number) parms[13]).shortValue());
               stmt.setShort(12, ((Number) parms[14]).shortValue());
               return;
            case 19 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[3]);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(4, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(5, (java.util.Date)parms[7], true);
               }
               stmt.setInt(6, ((Number) parms[8]).intValue());
               stmt.setString(7, (String)parms[9], 1);
               stmt.setVarchar(8, (String)parms[10], 2, false);
               stmt.setString(9, (String)parms[11], 1);
               stmt.setInt(10, ((Number) parms[12]).intValue());
               stmt.setShort(11, ((Number) parms[13]).shortValue());
               stmt.setShort(12, ((Number) parms[14]).shortValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(13, ((Number) parms[16]).intValue());
               }
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(2, ((Number) parms[3]).intValue());
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
            case 26 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

