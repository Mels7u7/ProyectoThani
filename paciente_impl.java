package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class paciente_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
      {
         A43PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_25( A43PaisId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_26") == 0 )
      {
         A6SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
         n6SecUserId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_26( A6SecUserId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_27") == 0 )
      {
         A44UbigeoCode = httpContext.GetPar( "UbigeoCode") ;
         n44UbigeoCode = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A44UbigeoCode) ;
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
            AV26PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26PacienteId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26PacienteId), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", "Paciente", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPacienteApellidoPaterno_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public paciente_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public paciente_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paciente_impl.class ));
   }

   public paciente_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPacienteTipoDocumento = new HTMLChoice();
      cmbPacienteSexo = new HTMLChoice();
      cmbPacienteEstado = new HTMLChoice();
      cmbPacienteEnterarse = new HTMLChoice();
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
      if ( cmbPacienteTipoDocumento.getItemCount() > 0 )
      {
         A214PacienteTipoDocumento = cmbPacienteTipoDocumento.getValidValue(A214PacienteTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteTipoDocumento.setValue( GXutil.rtrim( A214PacienteTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteTipoDocumento.getInternalname(), "Values", cmbPacienteTipoDocumento.ToJavascriptSource(), true);
      }
      if ( cmbPacienteSexo.getItemCount() > 0 )
      {
         A216PacienteSexo = cmbPacienteSexo.getValidValue(A216PacienteSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A216PacienteSexo", A216PacienteSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteSexo.setValue( GXutil.rtrim( A216PacienteSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteSexo.getInternalname(), "Values", cmbPacienteSexo.ToJavascriptSource(), true);
      }
      if ( cmbPacienteEstado.getItemCount() > 0 )
      {
         A219PacienteEstado = cmbPacienteEstado.getValidValue(A219PacienteEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A219PacienteEstado", A219PacienteEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteEstado.setValue( GXutil.rtrim( A219PacienteEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEstado.getInternalname(), "Values", cmbPacienteEstado.ToJavascriptSource(), true);
      }
      if ( cmbPacienteEnterarse.getItemCount() > 0 )
      {
         A224PacienteEnterarse = cmbPacienteEnterarse.getValidValue(A224PacienteEnterarse) ;
         n224PacienteEnterarse = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A224PacienteEnterarse", A224PacienteEnterarse);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteEnterarse.setValue( GXutil.rtrim( A224PacienteEnterarse) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEnterarse.getInternalname(), "Values", cmbPacienteEnterarse.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoPaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoPaterno_Internalname, "Apellido Paterno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoPaterno_Internalname, A103PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoPaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteApellidoPaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoMaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoMaterno_Internalname, "Apellido Materno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoMaterno_Internalname, A104PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoMaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteApellidoMaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombres_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombres_Internalname, "Nombres", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombres_Internalname, A105PacienteNombres, GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteNombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombreCompleto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombreCompleto_Internalname, "Nombre Completo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombreCompleto_Internalname, A212PacienteNombreCompleto, GXutil.rtrim( localUtil.format( A212PacienteNombreCompleto, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombreCompleto_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteNombreCompleto_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteFechaNacimiento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteFechaNacimiento_Internalname, "Fecha Nacimiento", "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtPacienteFechaNacimiento_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteFechaNacimiento_Internalname, localUtil.format(A213PacienteFechaNacimiento, "99/99/99"), localUtil.format( A213PacienteFechaNacimiento, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteFechaNacimiento_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtPacienteFechaNacimiento_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtPacienteFechaNacimiento_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtPacienteFechaNacimiento_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Paciente.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteTipoDocumento.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteTipoDocumento.getInternalname(), "Tipo Documento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteTipoDocumento, cmbPacienteTipoDocumento.getInternalname(), GXutil.rtrim( A214PacienteTipoDocumento), 1, cmbPacienteTipoDocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteTipoDocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "", true, (byte)(1), "HLP_Paciente.htm");
      cmbPacienteTipoDocumento.setValue( GXutil.rtrim( A214PacienteTipoDocumento) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteTipoDocumento.getInternalname(), "Values", cmbPacienteTipoDocumento.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNroDocumento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNroDocumento_Internalname, "Nro Documento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNroDocumento_Internalname, A106PacienteNroDocumento, GXutil.rtrim( localUtil.format( A106PacienteNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNroDocumento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteNroDocumento_Enabled, 0, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteDireccion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteDireccion_Internalname, "Direccion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPacienteDireccion_Internalname, A215PacienteDireccion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", (short)(0), 1, edtPacienteDireccion_Enabled, 0, 80, "chr", 7, "row", StyleString, ClassString, "", "", "500", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteSexo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteSexo.getInternalname(), "Sexo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteSexo, cmbPacienteSexo.getInternalname(), GXutil.rtrim( A216PacienteSexo), 1, cmbPacienteSexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteSexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "", true, (byte)(1), "HLP_Paciente.htm");
      cmbPacienteSexo.setValue( GXutil.rtrim( A216PacienteSexo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteSexo.getInternalname(), "Values", cmbPacienteSexo.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteCorreo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteCorreo_Internalname, "Correo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteCorreo_Internalname, A217PacienteCorreo, GXutil.rtrim( localUtil.format( A217PacienteCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A217PacienteCorreo, "", "", "", edtPacienteCorreo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteTelefono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteTelefono_Internalname, "Telefono", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      if ( httpContext.isSmartDevice( ) )
      {
         gxphoneLink = "tel:" + GXutil.rtrim( A218PacienteTelefono) ;
      }
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteTelefono_Internalname, GXutil.rtrim( A218PacienteTelefono), GXutil.rtrim( localUtil.format( A218PacienteTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", gxphoneLink, "", "", "", edtPacienteTelefono_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteTelefono_Enabled, 0, "tel", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Phone", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedpaisid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpaisid_Internalname, "Pais Id", "", "", lblTextblockpaisid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_paisid.setProperty("Caption", Combo_paisid_Caption);
      ucCombo_paisid.setProperty("Cls", Combo_paisid_Cls);
      ucCombo_paisid.setProperty("DataListProc", Combo_paisid_Datalistproc);
      ucCombo_paisid.setProperty("DataListProcParametersPrefix", Combo_paisid_Datalistprocparametersprefix);
      ucCombo_paisid.setProperty("EmptyItem", Combo_paisid_Emptyitem);
      ucCombo_paisid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_paisid.setProperty("DropDownOptionsData", AV16PaisId_Data);
      ucCombo_paisid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_paisid_Internalname, "COMBO_PAISIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPaisId_Internalname, "Pais Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPaisId_Internalname, GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A43PaisId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaisId_Jsonclick, 0, "Attribute", "", "", "", "", edtPaisId_Visible, edtPaisId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Paciente.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaisDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPaisDescripcion_Internalname, "Pais Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPaisDescripcion_Internalname, A184PaisDescripcion, GXutil.rtrim( localUtil.format( A184PaisDescripcion, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaisDescripcion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaisDescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteEstado, cmbPacienteEstado.getInternalname(), GXutil.rtrim( A219PacienteEstado), 1, cmbPacienteEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(1), "HLP_Paciente.htm");
      cmbPacienteEstado.setValue( GXutil.rtrim( A219PacienteEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEstado.getInternalname(), "Values", cmbPacienteEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedsecuserid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocksecuserid_Internalname, "User Id", "", "", lblTextblocksecuserid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_secuserid.setProperty("Caption", Combo_secuserid_Caption);
      ucCombo_secuserid.setProperty("Cls", Combo_secuserid_Cls);
      ucCombo_secuserid.setProperty("DataListProc", Combo_secuserid_Datalistproc);
      ucCombo_secuserid.setProperty("DataListProcParametersPrefix", Combo_secuserid_Datalistprocparametersprefix);
      ucCombo_secuserid.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_secuserid.setProperty("DropDownOptionsData", AV22SecUserId_Data);
      ucCombo_secuserid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_secuserid_Internalname, "COMBO_SECUSERIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserId_Internalname, "User Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserId_Internalname, GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserId_Jsonclick, 0, "Attribute", "", "", "", "", edtSecUserId_Visible, edtSecUserId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedubigeocode_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockubigeocode_Internalname, "Ubigeo Code", "", "", lblTextblockubigeocode_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_ubigeocode.setProperty("Caption", Combo_ubigeocode_Caption);
      ucCombo_ubigeocode.setProperty("Cls", Combo_ubigeocode_Cls);
      ucCombo_ubigeocode.setProperty("DataListProc", Combo_ubigeocode_Datalistproc);
      ucCombo_ubigeocode.setProperty("DataListProcParametersPrefix", Combo_ubigeocode_Datalistprocparametersprefix);
      ucCombo_ubigeocode.setProperty("DropDownOptionsTitleSettingsIcons", AV17DDO_TitleSettingsIcons);
      ucCombo_ubigeocode.setProperty("DropDownOptionsData", AV24UbigeoCode_Data);
      ucCombo_ubigeocode.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_ubigeocode_Internalname, "COMBO_UBIGEOCODEContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoCode_Internalname, "Ubigeo Code", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoCode_Internalname, GXutil.rtrim( A44UbigeoCode), GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,120);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoCode_Jsonclick, 0, "Attribute", "", "", "", "", edtUbigeoCode_Visible, edtUbigeoCode_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoNombre_Internalname, "Ubigeo Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoNombre_Internalname, A185UbigeoNombre, GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteEstatura_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteEstatura_Internalname, "Estatura", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 130,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteEstatura_Internalname, GXutil.ltrim( localUtil.ntoc( A220PacienteEstatura, (byte)(4), (byte)(2), ",", "")), GXutil.ltrim( ((edtPacienteEstatura_Enabled!=0) ? localUtil.format( A220PacienteEstatura, "9.99") : localUtil.format( A220PacienteEstatura, "9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,130);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteEstatura_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteEstatura_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacientePeso_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacientePeso_Internalname, "Peso", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacientePeso_Internalname, GXutil.ltrim( localUtil.ntoc( A221PacientePeso, (byte)(6), (byte)(2), ",", "")), GXutil.ltrim( ((edtPacientePeso_Enabled!=0) ? localUtil.format( A221PacientePeso, "ZZ9.99") : localUtil.format( A221PacientePeso, "ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,135);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacientePeso_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacientePeso_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombreAnexo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombreAnexo_Internalname, "Nombre Anexo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 140,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombreAnexo_Internalname, A222PacienteNombreAnexo, GXutil.rtrim( localUtil.format( A222PacienteNombreAnexo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,140);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombreAnexo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteNombreAnexo_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteAnexos_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteAnexos_Internalname, "Anexos", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      ClassString = "Attribute" ;
      StyleString = "" ;
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 145,'',false,'',0)\"" ;
      edtPacienteAnexos_Filetype = "tmp" ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, true);
      if ( ! (GXutil.strcmp("", A223PacienteAnexos)==0) )
      {
         gxblobfileaux.setSource( A223PacienteAnexos );
         if ( ! gxblobfileaux.hasExtension() || ( GXutil.strcmp(edtPacienteAnexos_Filetype, "tmp") != 0 ) )
         {
            gxblobfileaux.setExt(GXutil.trim( edtPacienteAnexos_Filetype));
         }
         if ( gxblobfileaux.getErrCode() == 0 )
         {
            A223PacienteAnexos = gxblobfileaux.getURI() ;
            n223PacienteAnexos = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A223PacienteAnexos", A223PacienteAnexos);
            httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
            edtPacienteAnexos_Filetype = gxblobfileaux.getExtension() ;
            httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Filetype", edtPacienteAnexos_Filetype, true);
            gxblobfileaux.setBlobToDelete();
         }
         httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
      }
      com.projectthani.GxWebStd.gx_blob_field( httpContext, edtPacienteAnexos_Internalname, GXutil.rtrim( A223PacienteAnexos), httpContext.getResourceRelative(A223PacienteAnexos), ((GXutil.strcmp("", edtPacienteAnexos_Contenttype)==0) ? com.genexus.internet.HttpResponse.getContentType(((GXutil.strcmp("", edtPacienteAnexos_Filetype)==0) ? A223PacienteAnexos : edtPacienteAnexos_Filetype)) : edtPacienteAnexos_Contenttype), false, "", edtPacienteAnexos_Parameters, 0, edtPacienteAnexos_Enabled, 1, "", "", 0, -1, 250, "px", 60, "px", 0, 0, 0, edtPacienteAnexos_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", StyleString, ClassString, "", "", ""+TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,145);\"", "", "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteEnterarse.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteEnterarse.getInternalname(), "Enterarse", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 150,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteEnterarse, cmbPacienteEnterarse.getInternalname(), GXutil.rtrim( A224PacienteEnterarse), 1, cmbPacienteEnterarse.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbPacienteEnterarse.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,150);\"", "", true, (byte)(1), "HLP_Paciente.htm");
      cmbPacienteEnterarse.setValue( GXutil.rtrim( A224PacienteEnterarse) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEnterarse.getInternalname(), "Values", cmbPacienteEnterarse.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteEspecifique_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteEspecifique_Internalname, "Especifique", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 155,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtPacienteEspecifique_Internalname, A225PacienteEspecifique, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,155);\"", (short)(0), 1, edtPacienteEspecifique_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteFechaRegistro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteFechaRegistro_Internalname, "Fecha Registro", "col-sm-3 AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtPacienteFechaRegistro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteFechaRegistro_Internalname, localUtil.ttoc( A226PacienteFechaRegistro, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A226PacienteFechaRegistro, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onblur(this,160);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteFechaRegistro_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtPacienteFechaRegistro_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtPacienteFechaRegistro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtPacienteFechaRegistro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Paciente.htm");
      httpContext.writeTextNL( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 165,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 167,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 169,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Paciente.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_paisid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombopaisid_Internalname, GXutil.ltrim( localUtil.ntoc( AV21ComboPaisId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombopaisid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV21ComboPaisId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV21ComboPaisId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombopaisid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombopaisid_Visible, edtavCombopaisid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_secuserid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombosecuserid_Internalname, GXutil.ltrim( localUtil.ntoc( AV23ComboSecUserId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombosecuserid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV23ComboSecUserId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV23ComboSecUserId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombosecuserid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombosecuserid_Visible, edtavCombosecuserid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Paciente.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_ubigeocode_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavComboubigeocode_Internalname, GXutil.rtrim( AV25ComboUbigeoCode), GXutil.rtrim( localUtil.format( AV25ComboUbigeoCode, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboubigeocode_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboubigeocode_Visible, edtavComboubigeocode_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Paciente.htm");
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
      e11092 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV17DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPAISID_DATA"), AV16PaisId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSECUSERID_DATA"), AV22SecUserId_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUBIGEOCODE_DATA"), AV24UbigeoCode_Data);
            /* Read saved values. */
            Z20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z20PacienteId"), ",", ".")) ;
            Z103PacienteApellidoPaterno = httpContext.cgiGet( "Z103PacienteApellidoPaterno") ;
            Z104PacienteApellidoMaterno = httpContext.cgiGet( "Z104PacienteApellidoMaterno") ;
            Z105PacienteNombres = httpContext.cgiGet( "Z105PacienteNombres") ;
            Z213PacienteFechaNacimiento = localUtil.ctod( httpContext.cgiGet( "Z213PacienteFechaNacimiento"), 0) ;
            Z214PacienteTipoDocumento = httpContext.cgiGet( "Z214PacienteTipoDocumento") ;
            Z106PacienteNroDocumento = httpContext.cgiGet( "Z106PacienteNroDocumento") ;
            Z215PacienteDireccion = httpContext.cgiGet( "Z215PacienteDireccion") ;
            Z216PacienteSexo = httpContext.cgiGet( "Z216PacienteSexo") ;
            Z217PacienteCorreo = httpContext.cgiGet( "Z217PacienteCorreo") ;
            Z218PacienteTelefono = httpContext.cgiGet( "Z218PacienteTelefono") ;
            Z219PacienteEstado = httpContext.cgiGet( "Z219PacienteEstado") ;
            Z220PacienteEstatura = localUtil.ctond( httpContext.cgiGet( "Z220PacienteEstatura")) ;
            Z221PacientePeso = localUtil.ctond( httpContext.cgiGet( "Z221PacientePeso")) ;
            Z222PacienteNombreAnexo = httpContext.cgiGet( "Z222PacienteNombreAnexo") ;
            n222PacienteNombreAnexo = ((GXutil.strcmp("", A222PacienteNombreAnexo)==0) ? true : false) ;
            Z224PacienteEnterarse = httpContext.cgiGet( "Z224PacienteEnterarse") ;
            n224PacienteEnterarse = ((GXutil.strcmp("", A224PacienteEnterarse)==0) ? true : false) ;
            Z226PacienteFechaRegistro = localUtil.ctot( httpContext.cgiGet( "Z226PacienteFechaRegistro"), 0) ;
            Z43PaisId = (short)(localUtil.ctol( httpContext.cgiGet( "Z43PaisId"), ",", ".")) ;
            Z6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "Z6SecUserId"), ",", ".")) ;
            n6SecUserId = ((0==A6SecUserId) ? true : false) ;
            Z44UbigeoCode = httpContext.cgiGet( "Z44UbigeoCode") ;
            n44UbigeoCode = ((GXutil.strcmp("", A44UbigeoCode)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N43PaisId = (short)(localUtil.ctol( httpContext.cgiGet( "N43PaisId"), ",", ".")) ;
            N6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "N6SecUserId"), ",", ".")) ;
            n6SecUserId = ((0==A6SecUserId) ? true : false) ;
            N44UbigeoCode = httpContext.cgiGet( "N44UbigeoCode") ;
            n44UbigeoCode = ((GXutil.strcmp("", A44UbigeoCode)==0) ? true : false) ;
            A186UbigeoDepartamento = httpContext.cgiGet( "UBIGEODEPARTAMENTO") ;
            A187UbigeoProvincia = httpContext.cgiGet( "UBIGEOPROVINCIA") ;
            A188UbigeoDistrito = httpContext.cgiGet( "UBIGEODISTRITO") ;
            AV26PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "vPACIENTEID"), ",", ".")) ;
            AV14Insert_PaisId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_PAISID"), ",", ".")) ;
            AV12Insert_SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_SECUSERID"), ",", ".")) ;
            AV15Insert_UbigeoCode = httpContext.cgiGet( "vINSERT_UBIGEOCODE") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            AV27Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_paisid_Objectcall = httpContext.cgiGet( "COMBO_PAISID_Objectcall") ;
            Combo_paisid_Class = httpContext.cgiGet( "COMBO_PAISID_Class") ;
            Combo_paisid_Icontype = httpContext.cgiGet( "COMBO_PAISID_Icontype") ;
            Combo_paisid_Icon = httpContext.cgiGet( "COMBO_PAISID_Icon") ;
            Combo_paisid_Caption = httpContext.cgiGet( "COMBO_PAISID_Caption") ;
            Combo_paisid_Tooltip = httpContext.cgiGet( "COMBO_PAISID_Tooltip") ;
            Combo_paisid_Cls = httpContext.cgiGet( "COMBO_PAISID_Cls") ;
            Combo_paisid_Selectedvalue_set = httpContext.cgiGet( "COMBO_PAISID_Selectedvalue_set") ;
            Combo_paisid_Selectedvalue_get = httpContext.cgiGet( "COMBO_PAISID_Selectedvalue_get") ;
            Combo_paisid_Selectedtext_set = httpContext.cgiGet( "COMBO_PAISID_Selectedtext_set") ;
            Combo_paisid_Selectedtext_get = httpContext.cgiGet( "COMBO_PAISID_Selectedtext_get") ;
            Combo_paisid_Gamoauthtoken = httpContext.cgiGet( "COMBO_PAISID_Gamoauthtoken") ;
            Combo_paisid_Ddointernalname = httpContext.cgiGet( "COMBO_PAISID_Ddointernalname") ;
            Combo_paisid_Titlecontrolalign = httpContext.cgiGet( "COMBO_PAISID_Titlecontrolalign") ;
            Combo_paisid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PAISID_Dropdownoptionstype") ;
            Combo_paisid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Enabled")) ;
            Combo_paisid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Visible")) ;
            Combo_paisid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PAISID_Titlecontrolidtoreplace") ;
            Combo_paisid_Datalisttype = httpContext.cgiGet( "COMBO_PAISID_Datalisttype") ;
            Combo_paisid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Allowmultipleselection")) ;
            Combo_paisid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PAISID_Datalistfixedvalues") ;
            Combo_paisid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Isgriditem")) ;
            Combo_paisid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Hasdescription")) ;
            Combo_paisid_Datalistproc = httpContext.cgiGet( "COMBO_PAISID_Datalistproc") ;
            Combo_paisid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PAISID_Datalistprocparametersprefix") ;
            Combo_paisid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PAISID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_paisid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Includeonlyselectedoption")) ;
            Combo_paisid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Includeselectalloption")) ;
            Combo_paisid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Emptyitem")) ;
            Combo_paisid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PAISID_Includeaddnewoption")) ;
            Combo_paisid_Htmltemplate = httpContext.cgiGet( "COMBO_PAISID_Htmltemplate") ;
            Combo_paisid_Multiplevaluestype = httpContext.cgiGet( "COMBO_PAISID_Multiplevaluestype") ;
            Combo_paisid_Loadingdata = httpContext.cgiGet( "COMBO_PAISID_Loadingdata") ;
            Combo_paisid_Noresultsfound = httpContext.cgiGet( "COMBO_PAISID_Noresultsfound") ;
            Combo_paisid_Emptyitemtext = httpContext.cgiGet( "COMBO_PAISID_Emptyitemtext") ;
            Combo_paisid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PAISID_Onlyselectedvalues") ;
            Combo_paisid_Selectalltext = httpContext.cgiGet( "COMBO_PAISID_Selectalltext") ;
            Combo_paisid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PAISID_Multiplevaluesseparator") ;
            Combo_paisid_Addnewoptiontext = httpContext.cgiGet( "COMBO_PAISID_Addnewoptiontext") ;
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
            Combo_ubigeocode_Objectcall = httpContext.cgiGet( "COMBO_UBIGEOCODE_Objectcall") ;
            Combo_ubigeocode_Class = httpContext.cgiGet( "COMBO_UBIGEOCODE_Class") ;
            Combo_ubigeocode_Icontype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Icontype") ;
            Combo_ubigeocode_Icon = httpContext.cgiGet( "COMBO_UBIGEOCODE_Icon") ;
            Combo_ubigeocode_Caption = httpContext.cgiGet( "COMBO_UBIGEOCODE_Caption") ;
            Combo_ubigeocode_Tooltip = httpContext.cgiGet( "COMBO_UBIGEOCODE_Tooltip") ;
            Combo_ubigeocode_Cls = httpContext.cgiGet( "COMBO_UBIGEOCODE_Cls") ;
            Combo_ubigeocode_Selectedvalue_set = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedvalue_set") ;
            Combo_ubigeocode_Selectedvalue_get = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedvalue_get") ;
            Combo_ubigeocode_Selectedtext_set = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedtext_set") ;
            Combo_ubigeocode_Selectedtext_get = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectedtext_get") ;
            Combo_ubigeocode_Gamoauthtoken = httpContext.cgiGet( "COMBO_UBIGEOCODE_Gamoauthtoken") ;
            Combo_ubigeocode_Ddointernalname = httpContext.cgiGet( "COMBO_UBIGEOCODE_Ddointernalname") ;
            Combo_ubigeocode_Titlecontrolalign = httpContext.cgiGet( "COMBO_UBIGEOCODE_Titlecontrolalign") ;
            Combo_ubigeocode_Dropdownoptionstype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Dropdownoptionstype") ;
            Combo_ubigeocode_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Enabled")) ;
            Combo_ubigeocode_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Visible")) ;
            Combo_ubigeocode_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_UBIGEOCODE_Titlecontrolidtoreplace") ;
            Combo_ubigeocode_Datalisttype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalisttype") ;
            Combo_ubigeocode_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Allowmultipleselection")) ;
            Combo_ubigeocode_Datalistfixedvalues = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistfixedvalues") ;
            Combo_ubigeocode_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Isgriditem")) ;
            Combo_ubigeocode_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Hasdescription")) ;
            Combo_ubigeocode_Datalistproc = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistproc") ;
            Combo_ubigeocode_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistprocparametersprefix") ;
            Combo_ubigeocode_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_UBIGEOCODE_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_ubigeocode_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Includeonlyselectedoption")) ;
            Combo_ubigeocode_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Includeselectalloption")) ;
            Combo_ubigeocode_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Emptyitem")) ;
            Combo_ubigeocode_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_UBIGEOCODE_Includeaddnewoption")) ;
            Combo_ubigeocode_Htmltemplate = httpContext.cgiGet( "COMBO_UBIGEOCODE_Htmltemplate") ;
            Combo_ubigeocode_Multiplevaluestype = httpContext.cgiGet( "COMBO_UBIGEOCODE_Multiplevaluestype") ;
            Combo_ubigeocode_Loadingdata = httpContext.cgiGet( "COMBO_UBIGEOCODE_Loadingdata") ;
            Combo_ubigeocode_Noresultsfound = httpContext.cgiGet( "COMBO_UBIGEOCODE_Noresultsfound") ;
            Combo_ubigeocode_Emptyitemtext = httpContext.cgiGet( "COMBO_UBIGEOCODE_Emptyitemtext") ;
            Combo_ubigeocode_Onlyselectedvalues = httpContext.cgiGet( "COMBO_UBIGEOCODE_Onlyselectedvalues") ;
            Combo_ubigeocode_Selectalltext = httpContext.cgiGet( "COMBO_UBIGEOCODE_Selectalltext") ;
            Combo_ubigeocode_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_UBIGEOCODE_Multiplevaluesseparator") ;
            Combo_ubigeocode_Addnewoptiontext = httpContext.cgiGet( "COMBO_UBIGEOCODE_Addnewoptiontext") ;
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
            edtPacienteAnexos_Filename = httpContext.cgiGet( "PACIENTEANEXOS_Filename") ;
            edtPacienteAnexos_Filetype = httpContext.cgiGet( "PACIENTEANEXOS_Filetype") ;
            /* Read variables values. */
            A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
            A212PacienteNombreCompleto = httpContext.cgiGet( edtPacienteNombreCompleto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A212PacienteNombreCompleto", A212PacienteNombreCompleto);
            if ( localUtil.vcdate( httpContext.cgiGet( edtPacienteFechaNacimiento_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "PACIENTEFECHANACIMIENTO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPacienteFechaNacimiento_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A213PacienteFechaNacimiento = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A213PacienteFechaNacimiento", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
            }
            else
            {
               A213PacienteFechaNacimiento = localUtil.ctod( httpContext.cgiGet( edtPacienteFechaNacimiento_Internalname), 3) ;
               httpContext.ajax_rsp_assign_attri("", false, "A213PacienteFechaNacimiento", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
            }
            cmbPacienteTipoDocumento.setValue( httpContext.cgiGet( cmbPacienteTipoDocumento.getInternalname()) );
            A214PacienteTipoDocumento = httpContext.cgiGet( cmbPacienteTipoDocumento.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
            A106PacienteNroDocumento = httpContext.cgiGet( edtPacienteNroDocumento_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
            A215PacienteDireccion = httpContext.cgiGet( edtPacienteDireccion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A215PacienteDireccion", A215PacienteDireccion);
            cmbPacienteSexo.setValue( httpContext.cgiGet( cmbPacienteSexo.getInternalname()) );
            A216PacienteSexo = httpContext.cgiGet( cmbPacienteSexo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A216PacienteSexo", A216PacienteSexo);
            A217PacienteCorreo = httpContext.cgiGet( edtPacienteCorreo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A217PacienteCorreo", A217PacienteCorreo);
            A218PacienteTelefono = httpContext.cgiGet( edtPacienteTelefono_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A218PacienteTelefono", A218PacienteTelefono);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAISID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaisId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A43PaisId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
            }
            else
            {
               A43PaisId = (short)(localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
            }
            A184PaisDescripcion = httpContext.cgiGet( edtPaisDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
            cmbPacienteEstado.setValue( httpContext.cgiGet( cmbPacienteEstado.getInternalname()) );
            A219PacienteEstado = httpContext.cgiGet( cmbPacienteEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A219PacienteEstado", A219PacienteEstado);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECUSERID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A6SecUserId = (short)(0) ;
               n6SecUserId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            }
            else
            {
               A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
               n6SecUserId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            }
            n6SecUserId = ((0==A6SecUserId) ? true : false) ;
            A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
            n44UbigeoCode = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            n44UbigeoCode = ((GXutil.strcmp("", A44UbigeoCode)==0) ? true : false) ;
            A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPacienteEstatura_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPacienteEstatura_Internalname)), DecimalUtil.stringToDec("9.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PACIENTEESTATURA");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPacienteEstatura_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A220PacienteEstatura = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A220PacienteEstatura", GXutil.ltrimstr( A220PacienteEstatura, 4, 2));
            }
            else
            {
               A220PacienteEstatura = localUtil.ctond( httpContext.cgiGet( edtPacienteEstatura_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A220PacienteEstatura", GXutil.ltrimstr( A220PacienteEstatura, 4, 2));
            }
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtPacientePeso_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtPacientePeso_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PACIENTEPESO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPacientePeso_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A221PacientePeso = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A221PacientePeso", GXutil.ltrimstr( A221PacientePeso, 6, 2));
            }
            else
            {
               A221PacientePeso = localUtil.ctond( httpContext.cgiGet( edtPacientePeso_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A221PacientePeso", GXutil.ltrimstr( A221PacientePeso, 6, 2));
            }
            A222PacienteNombreAnexo = httpContext.cgiGet( edtPacienteNombreAnexo_Internalname) ;
            n222PacienteNombreAnexo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A222PacienteNombreAnexo", A222PacienteNombreAnexo);
            n222PacienteNombreAnexo = ((GXutil.strcmp("", A222PacienteNombreAnexo)==0) ? true : false) ;
            A223PacienteAnexos = httpContext.cgiGet( edtPacienteAnexos_Internalname) ;
            n223PacienteAnexos = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A223PacienteAnexos", A223PacienteAnexos);
            n223PacienteAnexos = ((GXutil.strcmp("", A223PacienteAnexos)==0) ? true : false) ;
            cmbPacienteEnterarse.setValue( httpContext.cgiGet( cmbPacienteEnterarse.getInternalname()) );
            A224PacienteEnterarse = httpContext.cgiGet( cmbPacienteEnterarse.getInternalname()) ;
            n224PacienteEnterarse = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A224PacienteEnterarse", A224PacienteEnterarse);
            n224PacienteEnterarse = ((GXutil.strcmp("", A224PacienteEnterarse)==0) ? true : false) ;
            A225PacienteEspecifique = httpContext.cgiGet( edtPacienteEspecifique_Internalname) ;
            n225PacienteEspecifique = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A225PacienteEspecifique", A225PacienteEspecifique);
            n225PacienteEspecifique = ((GXutil.strcmp("", A225PacienteEspecifique)==0) ? true : false) ;
            if ( localUtil.vcdtime( httpContext.cgiGet( edtPacienteFechaRegistro_Internalname), (byte)(3), (byte)(0)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "PACIENTEFECHAREGISTRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPacienteFechaRegistro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
               httpContext.ajax_rsp_assign_attri("", false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
            }
            else
            {
               A226PacienteFechaRegistro = localUtil.ctot( httpContext.cgiGet( edtPacienteFechaRegistro_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
            }
            AV21ComboPaisId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombopaisid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaisId), 4, 0));
            AV23ComboSecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCombosecuserid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecUserId), 4, 0));
            AV25ComboUbigeoCode = httpContext.cgiGet( edtavComboubigeocode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25ComboUbigeoCode", AV25ComboUbigeoCode);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            if ( ! (GXutil.strcmp("", A223PacienteAnexos)==0) )
            {
               edtPacienteAnexos_Filename = httpContext.cgiGetFileName( edtPacienteAnexos_Internalname) ;
               edtPacienteAnexos_Filetype = httpContext.cgiGetFileType( edtPacienteAnexos_Internalname) ;
            }
            if ( (GXutil.strcmp("", A223PacienteAnexos)==0) )
            {
               GXCCtlgxBlob = "PACIENTEANEXOS" + "_gxBlob" ;
               A223PacienteAnexos = httpContext.cgiGet( GXCCtlgxBlob) ;
               n223PacienteAnexos = false ;
               n223PacienteAnexos = ((GXutil.strcmp("", A223PacienteAnexos)==0) ? true : false) ;
            }
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Paciente");
            A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            forbiddenHiddens.add("PacienteId", localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A20PacienteId != Z20PacienteId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("paciente:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A20PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
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
                  sMode16 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode16 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound16 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_090( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PACIENTEID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPacienteId_Internalname ;
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
                        e11092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12092 ();
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
         e12092 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0916( ) ;
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
         disableAttributes0916( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaisid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaisid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecuserid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecuserid_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, edtavComboubigeocode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboubigeocode_Enabled), 5, 0), true);
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

   public void confirm_090( )
   {
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0916( ) ;
         }
         else
         {
            checkExtendedTable0916( ) ;
            closeExtendedTableCursors0916( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption090( )
   {
   }

   public void e11092( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV17DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV17DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtUbigeoCode_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Visible), 5, 0), true);
      AV25ComboUbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboUbigeoCode", AV25ComboUbigeoCode);
      edtavComboubigeocode_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboubigeocode_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboubigeocode_Visible), 5, 0), true);
      edtSecUserId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Visible), 5, 0), true);
      AV23ComboSecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecUserId), 4, 0));
      edtavCombosecuserid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecuserid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecuserid_Visible), 5, 0), true);
      edtPaisId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisId_Visible), 5, 0), true);
      AV21ComboPaisId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaisId), 4, 0));
      edtavCombopaisid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaisid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaisid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOPAISID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOSECUSERID' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      /* Execute user subroutine: 'LOADCOMBOUBIGEOCODE' */
      S132 ();
      if ( returnInSub )
      {
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Insert", GXv_boolean5) ;
         paciente_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Update", GXv_boolean5) ;
         paciente_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaciente_Delete", GXv_boolean5) ;
         paciente_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV27Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV28GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GXV1), 8, 0));
         while ( AV28GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV28GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PaisId") == 0 )
            {
               AV14Insert_PaisId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV14Insert_PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14Insert_PaisId), 4, 0));
               if ( ! (0==AV14Insert_PaisId) )
               {
                  AV21ComboPaisId = AV14Insert_PaisId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaisId), 4, 0));
                  Combo_paisid_Selectedvalue_set = GXutil.trim( GXutil.str( AV21ComboPaisId, 4, 0)) ;
                  ucCombo_paisid.sendProperty(context, "", false, Combo_paisid_Internalname, "SelectedValue_set", Combo_paisid_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char7[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.pacienteloaddvcombo(remoteHandle, context).execute( "PaisId", "GET", false, AV26PacienteId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  paciente_impl.this.AV18ComboSelectedValue = GXv_char7[0] ;
                  paciente_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  paciente_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_paisid_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_paisid.sendProperty(context, "", false, Combo_paisid_Internalname, "SelectedText_set", Combo_paisid_Selectedtext_set);
                  Combo_paisid_Enabled = false ;
                  ucCombo_paisid.sendProperty(context, "", false, Combo_paisid_Internalname, "Enabled", GXutil.booltostr( Combo_paisid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SecUserId") == 0 )
            {
               AV12Insert_SecUserId = (short)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_SecUserId), 4, 0));
               if ( ! (0==AV12Insert_SecUserId) )
               {
                  AV23ComboSecUserId = AV12Insert_SecUserId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecUserId), 4, 0));
                  Combo_secuserid_Selectedvalue_set = GXutil.trim( GXutil.str( AV23ComboSecUserId, 4, 0)) ;
                  ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedValue_set", Combo_secuserid_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new com.projectthani.pacienteloaddvcombo(remoteHandle, context).execute( "SecUserId", "GET", false, AV26PacienteId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  paciente_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  paciente_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  paciente_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_secuserid_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedText_set", Combo_secuserid_Selectedtext_set);
                  Combo_secuserid_Enabled = false ;
                  ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "Enabled", GXutil.booltostr( Combo_secuserid_Enabled));
               }
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "UbigeoCode") == 0 )
            {
               AV15Insert_UbigeoCode = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV15Insert_UbigeoCode", AV15Insert_UbigeoCode);
               if ( ! (GXutil.strcmp("", AV15Insert_UbigeoCode)==0) )
               {
                  AV25ComboUbigeoCode = AV15Insert_UbigeoCode ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV25ComboUbigeoCode", AV25ComboUbigeoCode);
                  Combo_ubigeocode_Selectedvalue_set = AV25ComboUbigeoCode ;
                  ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedValue_set", Combo_ubigeocode_Selectedvalue_set);
                  GXt_char6 = AV20Combo_DataJson ;
                  GXv_char9[0] = AV18ComboSelectedValue ;
                  GXv_char8[0] = AV19ComboSelectedText ;
                  GXv_char7[0] = GXt_char6 ;
                  new com.projectthani.pacienteloaddvcombo(remoteHandle, context).execute( "UbigeoCode", "GET", false, AV26PacienteId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char9, GXv_char8, GXv_char7) ;
                  paciente_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
                  paciente_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
                  paciente_impl.this.GXt_char6 = GXv_char7[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
                  AV20Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
                  Combo_ubigeocode_Selectedtext_set = AV19ComboSelectedText ;
                  ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedText_set", Combo_ubigeocode_Selectedtext_set);
                  Combo_ubigeocode_Enabled = false ;
                  ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "Enabled", GXutil.booltostr( Combo_ubigeocode_Enabled));
               }
            }
            AV28GXV1 = (int)(AV28GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV28GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GXV1), 8, 0));
         }
      }
   }

   public void e12092( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.pacienteww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S132( )
   {
      /* 'LOADCOMBOUBIGEOCODE' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.pacienteloaddvcombo(remoteHandle, context).execute( "UbigeoCode", Gx_mode, false, AV26PacienteId, "", GXv_char9, GXv_char8, GXv_char7) ;
      paciente_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      paciente_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      paciente_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_ubigeocode_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedValue_set", Combo_ubigeocode_Selectedvalue_set);
      Combo_ubigeocode_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "SelectedText_set", Combo_ubigeocode_Selectedtext_set);
      AV25ComboUbigeoCode = AV18ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25ComboUbigeoCode", AV25ComboUbigeoCode);
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_ubigeocode_Enabled = false ;
         ucCombo_ubigeocode.sendProperty(context, "", false, Combo_ubigeocode_Internalname, "Enabled", GXutil.booltostr( Combo_ubigeocode_Enabled));
      }
   }

   public void S122( )
   {
      /* 'LOADCOMBOSECUSERID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.pacienteloaddvcombo(remoteHandle, context).execute( "SecUserId", Gx_mode, false, AV26PacienteId, "", GXv_char9, GXv_char8, GXv_char7) ;
      paciente_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      paciente_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      paciente_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_secuserid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedValue_set", Combo_secuserid_Selectedvalue_set);
      Combo_secuserid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "SelectedText_set", Combo_secuserid_Selectedtext_set);
      AV23ComboSecUserId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23ComboSecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23ComboSecUserId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_secuserid_Enabled = false ;
         ucCombo_secuserid.sendProperty(context, "", false, Combo_secuserid_Internalname, "Enabled", GXutil.booltostr( Combo_secuserid_Enabled));
      }
   }

   public void S112( )
   {
      /* 'LOADCOMBOPAISID' Routine */
      returnInSub = false ;
      GXt_char6 = AV20Combo_DataJson ;
      GXv_char9[0] = AV18ComboSelectedValue ;
      GXv_char8[0] = AV19ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.pacienteloaddvcombo(remoteHandle, context).execute( "PaisId", Gx_mode, false, AV26PacienteId, "", GXv_char9, GXv_char8, GXv_char7) ;
      paciente_impl.this.AV18ComboSelectedValue = GXv_char9[0] ;
      paciente_impl.this.AV19ComboSelectedText = GXv_char8[0] ;
      paciente_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ComboSelectedValue", AV18ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboSelectedText", AV19ComboSelectedText);
      AV20Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Combo_DataJson", AV20Combo_DataJson);
      Combo_paisid_Selectedvalue_set = AV18ComboSelectedValue ;
      ucCombo_paisid.sendProperty(context, "", false, Combo_paisid_Internalname, "SelectedValue_set", Combo_paisid_Selectedvalue_set);
      Combo_paisid_Selectedtext_set = AV19ComboSelectedText ;
      ucCombo_paisid.sendProperty(context, "", false, Combo_paisid_Internalname, "SelectedText_set", Combo_paisid_Selectedtext_set);
      AV21ComboPaisId = (short)(GXutil.lval( AV18ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21ComboPaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21ComboPaisId), 4, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_paisid_Enabled = false ;
         ucCombo_paisid.sendProperty(context, "", false, Combo_paisid_Internalname, "Enabled", GXutil.booltostr( Combo_paisid_Enabled));
      }
   }

   public void zm0916( int GX_JID )
   {
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z103PacienteApellidoPaterno = T00093_A103PacienteApellidoPaterno[0] ;
            Z104PacienteApellidoMaterno = T00093_A104PacienteApellidoMaterno[0] ;
            Z105PacienteNombres = T00093_A105PacienteNombres[0] ;
            Z213PacienteFechaNacimiento = T00093_A213PacienteFechaNacimiento[0] ;
            Z214PacienteTipoDocumento = T00093_A214PacienteTipoDocumento[0] ;
            Z106PacienteNroDocumento = T00093_A106PacienteNroDocumento[0] ;
            Z215PacienteDireccion = T00093_A215PacienteDireccion[0] ;
            Z216PacienteSexo = T00093_A216PacienteSexo[0] ;
            Z217PacienteCorreo = T00093_A217PacienteCorreo[0] ;
            Z218PacienteTelefono = T00093_A218PacienteTelefono[0] ;
            Z219PacienteEstado = T00093_A219PacienteEstado[0] ;
            Z220PacienteEstatura = T00093_A220PacienteEstatura[0] ;
            Z221PacientePeso = T00093_A221PacientePeso[0] ;
            Z222PacienteNombreAnexo = T00093_A222PacienteNombreAnexo[0] ;
            Z224PacienteEnterarse = T00093_A224PacienteEnterarse[0] ;
            Z226PacienteFechaRegistro = T00093_A226PacienteFechaRegistro[0] ;
            Z43PaisId = T00093_A43PaisId[0] ;
            Z6SecUserId = T00093_A6SecUserId[0] ;
            Z44UbigeoCode = T00093_A44UbigeoCode[0] ;
         }
         else
         {
            Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
            Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
            Z105PacienteNombres = A105PacienteNombres ;
            Z213PacienteFechaNacimiento = A213PacienteFechaNacimiento ;
            Z214PacienteTipoDocumento = A214PacienteTipoDocumento ;
            Z106PacienteNroDocumento = A106PacienteNroDocumento ;
            Z215PacienteDireccion = A215PacienteDireccion ;
            Z216PacienteSexo = A216PacienteSexo ;
            Z217PacienteCorreo = A217PacienteCorreo ;
            Z218PacienteTelefono = A218PacienteTelefono ;
            Z219PacienteEstado = A219PacienteEstado ;
            Z220PacienteEstatura = A220PacienteEstatura ;
            Z221PacientePeso = A221PacientePeso ;
            Z222PacienteNombreAnexo = A222PacienteNombreAnexo ;
            Z224PacienteEnterarse = A224PacienteEnterarse ;
            Z226PacienteFechaRegistro = A226PacienteFechaRegistro ;
            Z43PaisId = A43PaisId ;
            Z6SecUserId = A6SecUserId ;
            Z44UbigeoCode = A44UbigeoCode ;
         }
      }
      if ( GX_JID == -24 )
      {
         Z20PacienteId = A20PacienteId ;
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z213PacienteFechaNacimiento = A213PacienteFechaNacimiento ;
         Z214PacienteTipoDocumento = A214PacienteTipoDocumento ;
         Z106PacienteNroDocumento = A106PacienteNroDocumento ;
         Z215PacienteDireccion = A215PacienteDireccion ;
         Z216PacienteSexo = A216PacienteSexo ;
         Z217PacienteCorreo = A217PacienteCorreo ;
         Z218PacienteTelefono = A218PacienteTelefono ;
         Z219PacienteEstado = A219PacienteEstado ;
         Z220PacienteEstatura = A220PacienteEstatura ;
         Z221PacientePeso = A221PacientePeso ;
         Z222PacienteNombreAnexo = A222PacienteNombreAnexo ;
         Z223PacienteAnexos = A223PacienteAnexos ;
         Z224PacienteEnterarse = A224PacienteEnterarse ;
         Z225PacienteEspecifique = A225PacienteEspecifique ;
         Z226PacienteFechaRegistro = A226PacienteFechaRegistro ;
         Z43PaisId = A43PaisId ;
         Z6SecUserId = A6SecUserId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z184PaisDescripcion = A184PaisDescripcion ;
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
      }
   }

   public void standaloneNotModal( )
   {
      edtPacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtPacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV26PacienteId) )
      {
         A20PacienteId = AV26PacienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_PaisId) )
      {
         edtPaisId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaisId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisId_Enabled), 5, 0), true);
      }
      else
      {
         edtPaisId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaisId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_SecUserId) )
      {
         edtSecUserId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      }
      else
      {
         edtSecUserId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_UbigeoCode)==0) )
      {
         edtUbigeoCode_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      }
      else
      {
         edtUbigeoCode_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV14Insert_PaisId) )
      {
         A43PaisId = AV14Insert_PaisId ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
      }
      else
      {
         A43PaisId = AV21ComboPaisId ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_SecUserId) )
      {
         A6SecUserId = AV12Insert_SecUserId ;
         n6SecUserId = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      }
      else
      {
         if ( (0==AV23ComboSecUserId) )
         {
            A6SecUserId = (short)(0) ;
            n6SecUserId = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            n6SecUserId = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         }
         else
         {
            if ( ! (0==AV23ComboSecUserId) )
            {
               A6SecUserId = AV23ComboSecUserId ;
               n6SecUserId = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            }
         }
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV15Insert_UbigeoCode)==0) )
      {
         A44UbigeoCode = AV15Insert_UbigeoCode ;
         n44UbigeoCode = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      }
      else
      {
         if ( (GXutil.strcmp("", AV25ComboUbigeoCode)==0) )
         {
            A44UbigeoCode = "" ;
            n44UbigeoCode = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            n44UbigeoCode = true ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV25ComboUbigeoCode)==0) )
            {
               A44UbigeoCode = AV25ComboUbigeoCode ;
               n44UbigeoCode = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            }
         }
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
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A226PacienteFechaRegistro) && ( Gx_BScreen == 0 ) )
      {
         A226PacienteFechaRegistro = GXutil.now( ) ;
         httpContext.ajax_rsp_assign_attri("", false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV27Pgmname = "Paciente" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
         /* Using cursor T00094 */
         pr_default.execute(2, new Object[] {Short.valueOf(A43PaisId)});
         A184PaisDescripcion = T00094_A184PaisDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
         pr_default.close(2);
         /* Using cursor T00096 */
         pr_default.execute(4, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
         A186UbigeoDepartamento = T00096_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T00096_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T00096_A188UbigeoDistrito[0] ;
         pr_default.close(4);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      }
   }

   public void load0916( )
   {
      /* Using cursor T00097 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A103PacienteApellidoPaterno = T00097_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T00097_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T00097_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         A213PacienteFechaNacimiento = T00097_A213PacienteFechaNacimiento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A213PacienteFechaNacimiento", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
         A214PacienteTipoDocumento = T00097_A214PacienteTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
         A106PacienteNroDocumento = T00097_A106PacienteNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
         A215PacienteDireccion = T00097_A215PacienteDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A215PacienteDireccion", A215PacienteDireccion);
         A216PacienteSexo = T00097_A216PacienteSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A216PacienteSexo", A216PacienteSexo);
         A217PacienteCorreo = T00097_A217PacienteCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A217PacienteCorreo", A217PacienteCorreo);
         A218PacienteTelefono = T00097_A218PacienteTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A218PacienteTelefono", A218PacienteTelefono);
         A184PaisDescripcion = T00097_A184PaisDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
         A219PacienteEstado = T00097_A219PacienteEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A219PacienteEstado", A219PacienteEstado);
         A220PacienteEstatura = T00097_A220PacienteEstatura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A220PacienteEstatura", GXutil.ltrimstr( A220PacienteEstatura, 4, 2));
         A221PacientePeso = T00097_A221PacientePeso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A221PacientePeso", GXutil.ltrimstr( A221PacientePeso, 6, 2));
         A222PacienteNombreAnexo = T00097_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = T00097_n222PacienteNombreAnexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A222PacienteNombreAnexo", A222PacienteNombreAnexo);
         A223PacienteAnexos = T00097_A223PacienteAnexos[0] ;
         n223PacienteAnexos = T00097_n223PacienteAnexos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A223PacienteAnexos", A223PacienteAnexos);
         httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
         A224PacienteEnterarse = T00097_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = T00097_n224PacienteEnterarse[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A224PacienteEnterarse", A224PacienteEnterarse);
         A225PacienteEspecifique = T00097_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = T00097_n225PacienteEspecifique[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A225PacienteEspecifique", A225PacienteEspecifique);
         A226PacienteFechaRegistro = T00097_A226PacienteFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
         A186UbigeoDepartamento = T00097_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T00097_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T00097_A188UbigeoDistrito[0] ;
         A43PaisId = T00097_A43PaisId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
         A6SecUserId = T00097_A6SecUserId[0] ;
         n6SecUserId = T00097_n6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         A44UbigeoCode = T00097_A44UbigeoCode[0] ;
         n44UbigeoCode = T00097_n44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         zm0916( -24) ;
      }
      pr_default.close(5);
      onLoadActions0916( ) ;
   }

   public void onLoadActions0916( )
   {
      AV27Pgmname = "Paciente" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
      httpContext.ajax_rsp_assign_attri("", false, "A212PacienteNombreCompleto", A212PacienteNombreCompleto);
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
   }

   public void checkExtendedTable0916( )
   {
      nIsDirty_16 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV27Pgmname = "Paciente" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
      nIsDirty_16 = (short)(1) ;
      A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
      httpContext.ajax_rsp_assign_attri("", false, "A212PacienteNombreCompleto", A212PacienteNombreCompleto);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A213PacienteFechaNacimiento)) || (( GXutil.resetTime(A213PacienteFechaNacimiento).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A213PacienteFechaNacimiento), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Fecha Nacimiento fuera de rango", "OutOfRange", 1, "PACIENTEFECHANACIMIENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteFechaNacimiento_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A214PacienteTipoDocumento, "1") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "6") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "2") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "4") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "7") == 0 ) || ( GXutil.strcmp(A214PacienteTipoDocumento, "0") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Tipo Documento fuera de rango", "OutOfRange", 1, "PACIENTETIPODOCUMENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPacienteTipoDocumento.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A216PacienteSexo, "M") == 0 ) || ( GXutil.strcmp(A216PacienteSexo, "F") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Sexo fuera de rango", "OutOfRange", 1, "PACIENTESEXO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPacienteSexo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A217PacienteCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Paciente Correo no coincide con el patrón especificado", "OutOfRange", 1, "PACIENTECORREO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteCorreo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00094 */
      pr_default.execute(2, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaisId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A184PaisDescripcion = T00094_A184PaisDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A219PacienteEstado, "A") == 0 ) || ( GXutil.strcmp(A219PacienteEstado, "P") == 0 ) || ( GXutil.strcmp(A219PacienteEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Estado fuera de rango", "OutOfRange", 1, "PACIENTEESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPacienteEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T00095 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         if ( ! ( (0==A6SecUserId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecUserId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      pr_default.close(3);
      /* Using cursor T00096 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(4) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44UbigeoCode)==0) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtUbigeoCode_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A186UbigeoDepartamento = T00096_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T00096_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T00096_A188UbigeoDistrito[0] ;
      pr_default.close(4);
      nIsDirty_16 = (short)(1) ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      if ( ! ( ( GXutil.strcmp(A224PacienteEnterarse, "F") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "G") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "T") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "I") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "L") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "C") == 0 ) || ( GXutil.strcmp(A224PacienteEnterarse, "O") == 0 ) || (GXutil.strcmp("", A224PacienteEnterarse)==0) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Enterarse fuera de rango", "OutOfRange", 1, "PACIENTEENTERARSE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPacienteEnterarse.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A226PacienteFechaRegistro) || (( A226PacienteFechaRegistro.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A226PacienteFechaRegistro, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Fecha Registro fuera de rango", "OutOfRange", 1, "PACIENTEFECHAREGISTRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteFechaRegistro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0916( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_25( short A43PaisId )
   {
      /* Using cursor T00098 */
      pr_default.execute(6, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaisId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A184PaisDescripcion = T00098_A184PaisDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A184PaisDescripcion)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_26( short A6SecUserId )
   {
      /* Using cursor T00099 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A6SecUserId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecUserId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_27( String A44UbigeoCode )
   {
      /* Using cursor T000910 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44UbigeoCode)==0) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtUbigeoCode_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A186UbigeoDepartamento = T000910_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000910_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000910_A188UbigeoDistrito[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A186UbigeoDepartamento)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A187UbigeoProvincia)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A188UbigeoDistrito)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey0916( )
   {
      /* Using cursor T000911 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound16 = (short)(1) ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00093 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0916( 24) ;
         RcdFound16 = (short)(1) ;
         A20PacienteId = T00093_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A103PacienteApellidoPaterno = T00093_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T00093_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T00093_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         A213PacienteFechaNacimiento = T00093_A213PacienteFechaNacimiento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A213PacienteFechaNacimiento", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
         A214PacienteTipoDocumento = T00093_A214PacienteTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
         A106PacienteNroDocumento = T00093_A106PacienteNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
         A215PacienteDireccion = T00093_A215PacienteDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A215PacienteDireccion", A215PacienteDireccion);
         A216PacienteSexo = T00093_A216PacienteSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A216PacienteSexo", A216PacienteSexo);
         A217PacienteCorreo = T00093_A217PacienteCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A217PacienteCorreo", A217PacienteCorreo);
         A218PacienteTelefono = T00093_A218PacienteTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A218PacienteTelefono", A218PacienteTelefono);
         A219PacienteEstado = T00093_A219PacienteEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A219PacienteEstado", A219PacienteEstado);
         A220PacienteEstatura = T00093_A220PacienteEstatura[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A220PacienteEstatura", GXutil.ltrimstr( A220PacienteEstatura, 4, 2));
         A221PacientePeso = T00093_A221PacientePeso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A221PacientePeso", GXutil.ltrimstr( A221PacientePeso, 6, 2));
         A222PacienteNombreAnexo = T00093_A222PacienteNombreAnexo[0] ;
         n222PacienteNombreAnexo = T00093_n222PacienteNombreAnexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A222PacienteNombreAnexo", A222PacienteNombreAnexo);
         A223PacienteAnexos = T00093_A223PacienteAnexos[0] ;
         n223PacienteAnexos = T00093_n223PacienteAnexos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A223PacienteAnexos", A223PacienteAnexos);
         httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
         A224PacienteEnterarse = T00093_A224PacienteEnterarse[0] ;
         n224PacienteEnterarse = T00093_n224PacienteEnterarse[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A224PacienteEnterarse", A224PacienteEnterarse);
         A225PacienteEspecifique = T00093_A225PacienteEspecifique[0] ;
         n225PacienteEspecifique = T00093_n225PacienteEspecifique[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A225PacienteEspecifique", A225PacienteEspecifique);
         A226PacienteFechaRegistro = T00093_A226PacienteFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
         A43PaisId = T00093_A43PaisId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
         A6SecUserId = T00093_A6SecUserId[0] ;
         n6SecUserId = T00093_n6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         A44UbigeoCode = T00093_A44UbigeoCode[0] ;
         n44UbigeoCode = T00093_n44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         Z20PacienteId = A20PacienteId ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0916( ) ;
         if ( AnyError == 1 )
         {
            RcdFound16 = (short)(0) ;
            initializeNonKey0916( ) ;
         }
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound16 = (short)(0) ;
         initializeNonKey0916( ) ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode16 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0916( ) ;
      if ( RcdFound16 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound16 = (short)(0) ;
      /* Using cursor T000912 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000912_A20PacienteId[0] < A20PacienteId ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000912_A20PacienteId[0] > A20PacienteId ) ) )
         {
            A20PacienteId = T000912_A20PacienteId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            RcdFound16 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound16 = (short)(0) ;
      /* Using cursor T000913 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000913_A20PacienteId[0] > A20PacienteId ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000913_A20PacienteId[0] < A20PacienteId ) ) )
         {
            A20PacienteId = T000913_A20PacienteId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            RcdFound16 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0916( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPacienteApellidoPaterno_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0916( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound16 == 1 )
         {
            if ( A20PacienteId != Z20PacienteId )
            {
               A20PacienteId = Z20PacienteId ;
               httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PACIENTEID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPacienteId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPacienteApellidoPaterno_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0916( ) ;
               GX_FocusControl = edtPacienteApellidoPaterno_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A20PacienteId != Z20PacienteId )
            {
               /* Insert record */
               GX_FocusControl = edtPacienteApellidoPaterno_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0916( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PACIENTEID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPacienteId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtPacienteApellidoPaterno_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0916( ) ;
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
      if ( A20PacienteId != Z20PacienteId )
      {
         A20PacienteId = Z20PacienteId ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPacienteApellidoPaterno_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0916( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00092 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paciente"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z103PacienteApellidoPaterno, T00092_A103PacienteApellidoPaterno[0]) != 0 ) || ( GXutil.strcmp(Z104PacienteApellidoMaterno, T00092_A104PacienteApellidoMaterno[0]) != 0 ) || ( GXutil.strcmp(Z105PacienteNombres, T00092_A105PacienteNombres[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z213PacienteFechaNacimiento), GXutil.resetTime(T00092_A213PacienteFechaNacimiento[0])) ) || ( GXutil.strcmp(Z214PacienteTipoDocumento, T00092_A214PacienteTipoDocumento[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z106PacienteNroDocumento, T00092_A106PacienteNroDocumento[0]) != 0 ) || ( GXutil.strcmp(Z215PacienteDireccion, T00092_A215PacienteDireccion[0]) != 0 ) || ( GXutil.strcmp(Z216PacienteSexo, T00092_A216PacienteSexo[0]) != 0 ) || ( GXutil.strcmp(Z217PacienteCorreo, T00092_A217PacienteCorreo[0]) != 0 ) || ( GXutil.strcmp(Z218PacienteTelefono, T00092_A218PacienteTelefono[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z219PacienteEstado, T00092_A219PacienteEstado[0]) != 0 ) || ( DecimalUtil.compareTo(Z220PacienteEstatura, T00092_A220PacienteEstatura[0]) != 0 ) || ( DecimalUtil.compareTo(Z221PacientePeso, T00092_A221PacientePeso[0]) != 0 ) || ( GXutil.strcmp(Z222PacienteNombreAnexo, T00092_A222PacienteNombreAnexo[0]) != 0 ) || ( GXutil.strcmp(Z224PacienteEnterarse, T00092_A224PacienteEnterarse[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(Z226PacienteFechaRegistro, T00092_A226PacienteFechaRegistro[0]) ) || ( Z43PaisId != T00092_A43PaisId[0] ) || ( Z6SecUserId != T00092_A6SecUserId[0] ) || ( GXutil.strcmp(Z44UbigeoCode, T00092_A44UbigeoCode[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z103PacienteApellidoPaterno, T00092_A103PacienteApellidoPaterno[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteApellidoPaterno");
               GXutil.writeLogRaw("Old: ",Z103PacienteApellidoPaterno);
               GXutil.writeLogRaw("Current: ",T00092_A103PacienteApellidoPaterno[0]);
            }
            if ( GXutil.strcmp(Z104PacienteApellidoMaterno, T00092_A104PacienteApellidoMaterno[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteApellidoMaterno");
               GXutil.writeLogRaw("Old: ",Z104PacienteApellidoMaterno);
               GXutil.writeLogRaw("Current: ",T00092_A104PacienteApellidoMaterno[0]);
            }
            if ( GXutil.strcmp(Z105PacienteNombres, T00092_A105PacienteNombres[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteNombres");
               GXutil.writeLogRaw("Old: ",Z105PacienteNombres);
               GXutil.writeLogRaw("Current: ",T00092_A105PacienteNombres[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z213PacienteFechaNacimiento), GXutil.resetTime(T00092_A213PacienteFechaNacimiento[0])) ) )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteFechaNacimiento");
               GXutil.writeLogRaw("Old: ",Z213PacienteFechaNacimiento);
               GXutil.writeLogRaw("Current: ",T00092_A213PacienteFechaNacimiento[0]);
            }
            if ( GXutil.strcmp(Z214PacienteTipoDocumento, T00092_A214PacienteTipoDocumento[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteTipoDocumento");
               GXutil.writeLogRaw("Old: ",Z214PacienteTipoDocumento);
               GXutil.writeLogRaw("Current: ",T00092_A214PacienteTipoDocumento[0]);
            }
            if ( GXutil.strcmp(Z106PacienteNroDocumento, T00092_A106PacienteNroDocumento[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteNroDocumento");
               GXutil.writeLogRaw("Old: ",Z106PacienteNroDocumento);
               GXutil.writeLogRaw("Current: ",T00092_A106PacienteNroDocumento[0]);
            }
            if ( GXutil.strcmp(Z215PacienteDireccion, T00092_A215PacienteDireccion[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteDireccion");
               GXutil.writeLogRaw("Old: ",Z215PacienteDireccion);
               GXutil.writeLogRaw("Current: ",T00092_A215PacienteDireccion[0]);
            }
            if ( GXutil.strcmp(Z216PacienteSexo, T00092_A216PacienteSexo[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteSexo");
               GXutil.writeLogRaw("Old: ",Z216PacienteSexo);
               GXutil.writeLogRaw("Current: ",T00092_A216PacienteSexo[0]);
            }
            if ( GXutil.strcmp(Z217PacienteCorreo, T00092_A217PacienteCorreo[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteCorreo");
               GXutil.writeLogRaw("Old: ",Z217PacienteCorreo);
               GXutil.writeLogRaw("Current: ",T00092_A217PacienteCorreo[0]);
            }
            if ( GXutil.strcmp(Z218PacienteTelefono, T00092_A218PacienteTelefono[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteTelefono");
               GXutil.writeLogRaw("Old: ",Z218PacienteTelefono);
               GXutil.writeLogRaw("Current: ",T00092_A218PacienteTelefono[0]);
            }
            if ( GXutil.strcmp(Z219PacienteEstado, T00092_A219PacienteEstado[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteEstado");
               GXutil.writeLogRaw("Old: ",Z219PacienteEstado);
               GXutil.writeLogRaw("Current: ",T00092_A219PacienteEstado[0]);
            }
            if ( DecimalUtil.compareTo(Z220PacienteEstatura, T00092_A220PacienteEstatura[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteEstatura");
               GXutil.writeLogRaw("Old: ",Z220PacienteEstatura);
               GXutil.writeLogRaw("Current: ",T00092_A220PacienteEstatura[0]);
            }
            if ( DecimalUtil.compareTo(Z221PacientePeso, T00092_A221PacientePeso[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacientePeso");
               GXutil.writeLogRaw("Old: ",Z221PacientePeso);
               GXutil.writeLogRaw("Current: ",T00092_A221PacientePeso[0]);
            }
            if ( GXutil.strcmp(Z222PacienteNombreAnexo, T00092_A222PacienteNombreAnexo[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteNombreAnexo");
               GXutil.writeLogRaw("Old: ",Z222PacienteNombreAnexo);
               GXutil.writeLogRaw("Current: ",T00092_A222PacienteNombreAnexo[0]);
            }
            if ( GXutil.strcmp(Z224PacienteEnterarse, T00092_A224PacienteEnterarse[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteEnterarse");
               GXutil.writeLogRaw("Old: ",Z224PacienteEnterarse);
               GXutil.writeLogRaw("Current: ",T00092_A224PacienteEnterarse[0]);
            }
            if ( !( GXutil.dateCompare(Z226PacienteFechaRegistro, T00092_A226PacienteFechaRegistro[0]) ) )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PacienteFechaRegistro");
               GXutil.writeLogRaw("Old: ",Z226PacienteFechaRegistro);
               GXutil.writeLogRaw("Current: ",T00092_A226PacienteFechaRegistro[0]);
            }
            if ( Z43PaisId != T00092_A43PaisId[0] )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"PaisId");
               GXutil.writeLogRaw("Old: ",Z43PaisId);
               GXutil.writeLogRaw("Current: ",T00092_A43PaisId[0]);
            }
            if ( Z6SecUserId != T00092_A6SecUserId[0] )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"SecUserId");
               GXutil.writeLogRaw("Old: ",Z6SecUserId);
               GXutil.writeLogRaw("Current: ",T00092_A6SecUserId[0]);
            }
            if ( GXutil.strcmp(Z44UbigeoCode, T00092_A44UbigeoCode[0]) != 0 )
            {
               GXutil.writeLogln("paciente:[seudo value changed for attri]"+"UbigeoCode");
               GXutil.writeLogRaw("Old: ",Z44UbigeoCode);
               GXutil.writeLogRaw("Current: ",T00092_A44UbigeoCode[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Paciente"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0916( )
   {
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0916( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0916( 0) ;
         checkOptimisticConcurrency0916( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0916( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0916( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000914 */
                  pr_default.execute(12, new Object[] {A103PacienteApellidoPaterno, A104PacienteApellidoMaterno, A105PacienteNombres, A213PacienteFechaNacimiento, A214PacienteTipoDocumento, A106PacienteNroDocumento, A215PacienteDireccion, A216PacienteSexo, A217PacienteCorreo, A218PacienteTelefono, A219PacienteEstado, A220PacienteEstatura, A221PacientePeso, Boolean.valueOf(n222PacienteNombreAnexo), A222PacienteNombreAnexo, Boolean.valueOf(n223PacienteAnexos), A223PacienteAnexos, Boolean.valueOf(n224PacienteEnterarse), A224PacienteEnterarse, Boolean.valueOf(n225PacienteEspecifique), A225PacienteEspecifique, A226PacienteFechaRegistro, Short.valueOf(A43PaisId), Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId), Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
                  A20PacienteId = T000914_A20PacienteId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption090( ) ;
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
            load0916( ) ;
         }
         endLevel0916( ) ;
      }
      closeExtendedTableCursors0916( ) ;
   }

   public void update0916( )
   {
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0916( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0916( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0916( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0916( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000915 */
                  pr_default.execute(13, new Object[] {A103PacienteApellidoPaterno, A104PacienteApellidoMaterno, A105PacienteNombres, A213PacienteFechaNacimiento, A214PacienteTipoDocumento, A106PacienteNroDocumento, A215PacienteDireccion, A216PacienteSexo, A217PacienteCorreo, A218PacienteTelefono, A219PacienteEstado, A220PacienteEstatura, A221PacientePeso, Boolean.valueOf(n222PacienteNombreAnexo), A222PacienteNombreAnexo, Boolean.valueOf(n224PacienteEnterarse), A224PacienteEnterarse, Boolean.valueOf(n225PacienteEspecifique), A225PacienteEspecifique, A226PacienteFechaRegistro, Short.valueOf(A43PaisId), Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId), Boolean.valueOf(n44UbigeoCode), A44UbigeoCode, Integer.valueOf(A20PacienteId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Paciente"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0916( ) ;
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
         endLevel0916( ) ;
      }
      closeExtendedTableCursors0916( ) ;
   }

   public void deferredUpdate0916( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000916 */
         pr_default.execute(14, new Object[] {Boolean.valueOf(n223PacienteAnexos), A223PacienteAnexos, Integer.valueOf(A20PacienteId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
      }
   }

   public void delete( )
   {
      beforeValidate0916( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0916( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0916( ) ;
         afterConfirm0916( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0916( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000917 */
               pr_default.execute(15, new Object[] {Integer.valueOf(A20PacienteId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Paciente");
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
      sMode16 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0916( ) ;
      Gx_mode = sMode16 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0916( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV27Pgmname = "Paciente" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27Pgmname", AV27Pgmname);
         A212PacienteNombreCompleto = A103PacienteApellidoPaterno + " " + A104PacienteApellidoMaterno + ", " + A105PacienteNombres ;
         httpContext.ajax_rsp_assign_attri("", false, "A212PacienteNombreCompleto", A212PacienteNombreCompleto);
         /* Using cursor T000918 */
         pr_default.execute(16, new Object[] {Short.valueOf(A43PaisId)});
         A184PaisDescripcion = T000918_A184PaisDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
         pr_default.close(16);
         /* Using cursor T000919 */
         pr_default.execute(17, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
         A186UbigeoDepartamento = T000919_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T000919_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T000919_A188UbigeoDistrito[0] ;
         pr_default.close(17);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000920 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Rating Plataforma"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
         /* Using cursor T000921 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Sugerencias Mejoras Plataforma"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor T000922 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Comentario Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor T000923 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Rating Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
         /* Using cursor T000924 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente Familiar"+" ("+"SGPaciente Hijo"+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor T000925 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Paciente Familiar"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor T000926 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Reclamo"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor T000927 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A20PacienteId)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Cita"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
      }
   }

   public void endLevel0916( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0916( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(16);
         pr_default.close(17);
         Application.commitDataStores(context, remoteHandle, pr_default, "paciente");
         if ( AnyError == 0 )
         {
            confirmValues090( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(16);
         pr_default.close(17);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "paciente");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0916( )
   {
      /* Scan By routine */
      /* Using cursor T000928 */
      pr_default.execute(26);
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A20PacienteId = T000928_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0916( )
   {
      /* Scan next routine */
      pr_default.readNext(26);
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A20PacienteId = T000928_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      }
   }

   public void scanEnd0916( )
   {
      pr_default.close(26);
   }

   public void afterConfirm0916( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0916( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0916( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0916( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0916( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0916( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0916( )
   {
      edtPacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      edtPacienteApellidoPaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoPaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoPaterno_Enabled), 5, 0), true);
      edtPacienteApellidoMaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoMaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoMaterno_Enabled), 5, 0), true);
      edtPacienteNombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombres_Enabled), 5, 0), true);
      edtPacienteNombreCompleto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombreCompleto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombreCompleto_Enabled), 5, 0), true);
      edtPacienteFechaNacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteFechaNacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteFechaNacimiento_Enabled), 5, 0), true);
      cmbPacienteTipoDocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteTipoDocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPacienteTipoDocumento.getEnabled(), 5, 0), true);
      edtPacienteNroDocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNroDocumento_Enabled), 5, 0), true);
      edtPacienteDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteDireccion_Enabled), 5, 0), true);
      cmbPacienteSexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteSexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPacienteSexo.getEnabled(), 5, 0), true);
      edtPacienteCorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteCorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteCorreo_Enabled), 5, 0), true);
      edtPacienteTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteTelefono_Enabled), 5, 0), true);
      edtPaisId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisId_Enabled), 5, 0), true);
      edtPaisDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisDescripcion_Enabled), 5, 0), true);
      cmbPacienteEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPacienteEstado.getEnabled(), 5, 0), true);
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      edtUbigeoCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      edtUbigeoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Enabled), 5, 0), true);
      edtPacienteEstatura_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteEstatura_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteEstatura_Enabled), 5, 0), true);
      edtPacientePeso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacientePeso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacientePeso_Enabled), 5, 0), true);
      edtPacienteNombreAnexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombreAnexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombreAnexo_Enabled), 5, 0), true);
      edtPacienteAnexos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteAnexos_Enabled), 5, 0), true);
      cmbPacienteEnterarse.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteEnterarse.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPacienteEnterarse.getEnabled(), 5, 0), true);
      edtPacienteEspecifique_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteEspecifique_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteEspecifique_Enabled), 5, 0), true);
      edtPacienteFechaRegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteFechaRegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteFechaRegistro_Enabled), 5, 0), true);
      edtavCombopaisid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombopaisid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombopaisid_Enabled), 5, 0), true);
      edtavCombosecuserid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombosecuserid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombosecuserid_Enabled), 5, 0), true);
      edtavComboubigeocode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboubigeocode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboubigeocode_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0916( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues090( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110322938", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.paciente", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV26PacienteId,8,0))}, new String[] {"Gx_mode","PacienteId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Paciente");
      forbiddenHiddens.add("PacienteId", localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("paciente:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z20PacienteId", GXutil.ltrim( localUtil.ntoc( Z20PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z103PacienteApellidoPaterno", Z103PacienteApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z104PacienteApellidoMaterno", Z104PacienteApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z105PacienteNombres", Z105PacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z213PacienteFechaNacimiento", localUtil.dtoc( Z213PacienteFechaNacimiento, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z214PacienteTipoDocumento", GXutil.rtrim( Z214PacienteTipoDocumento));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z106PacienteNroDocumento", Z106PacienteNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z215PacienteDireccion", Z215PacienteDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z216PacienteSexo", GXutil.rtrim( Z216PacienteSexo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z217PacienteCorreo", Z217PacienteCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z218PacienteTelefono", GXutil.rtrim( Z218PacienteTelefono));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z219PacienteEstado", GXutil.rtrim( Z219PacienteEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z220PacienteEstatura", GXutil.ltrim( localUtil.ntoc( Z220PacienteEstatura, (byte)(4), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z221PacientePeso", GXutil.ltrim( localUtil.ntoc( Z221PacientePeso, (byte)(6), (byte)(2), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z222PacienteNombreAnexo", Z222PacienteNombreAnexo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z224PacienteEnterarse", Z224PacienteEnterarse);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z226PacienteFechaRegistro", localUtil.ttoc( Z226PacienteFechaRegistro, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z43PaisId", GXutil.ltrim( localUtil.ntoc( Z43PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z6SecUserId", GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z44UbigeoCode", GXutil.rtrim( Z44UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N43PaisId", GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N6SecUserId", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N44UbigeoCode", GXutil.rtrim( A44UbigeoCode));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAISID_DATA", AV16PaisId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAISID_DATA", AV16PaisId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSECUSERID_DATA", AV22SecUserId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSECUSERID_DATA", AV22SecUserId_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vUBIGEOCODE_DATA", AV24UbigeoCode_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vUBIGEOCODE_DATA", AV24UbigeoCode_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODEPARTAMENTO", A186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEOPROVINCIA", A187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODISTRITO", A188UbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV26PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV26PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_PAISID", GXutil.ltrim( localUtil.ntoc( AV14Insert_PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_SECUSERID", GXutil.ltrim( localUtil.ntoc( AV12Insert_SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_UBIGEOCODE", GXutil.rtrim( AV15Insert_UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV27Pgmname));
      GXCCtlgxBlob = "PACIENTEANEXOS" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A223PacienteAnexos);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Objectcall", GXutil.rtrim( Combo_paisid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Cls", GXutil.rtrim( Combo_paisid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Selectedvalue_set", GXutil.rtrim( Combo_paisid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Selectedtext_set", GXutil.rtrim( Combo_paisid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Enabled", GXutil.booltostr( Combo_paisid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Datalistproc", GXutil.rtrim( Combo_paisid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Datalistprocparametersprefix", GXutil.rtrim( Combo_paisid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_PAISID_Emptyitem", GXutil.booltostr( Combo_paisid_Emptyitem));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Objectcall", GXutil.rtrim( Combo_secuserid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Cls", GXutil.rtrim( Combo_secuserid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Selectedvalue_set", GXutil.rtrim( Combo_secuserid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Selectedtext_set", GXutil.rtrim( Combo_secuserid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Enabled", GXutil.booltostr( Combo_secuserid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Datalistproc", GXutil.rtrim( Combo_secuserid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_SECUSERID_Datalistprocparametersprefix", GXutil.rtrim( Combo_secuserid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Objectcall", GXutil.rtrim( Combo_ubigeocode_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Cls", GXutil.rtrim( Combo_ubigeocode_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Selectedvalue_set", GXutil.rtrim( Combo_ubigeocode_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Selectedtext_set", GXutil.rtrim( Combo_ubigeocode_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Enabled", GXutil.booltostr( Combo_ubigeocode_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Datalistproc", GXutil.rtrim( Combo_ubigeocode_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_UBIGEOCODE_Datalistprocparametersprefix", GXutil.rtrim( Combo_ubigeocode_Datalistprocparametersprefix));
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEANEXOS_Filename", GXutil.rtrim( edtPacienteAnexos_Filename));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PACIENTEANEXOS_Filetype", GXutil.rtrim( edtPacienteAnexos_Filetype));
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
      return formatLink("com.projectthani.paciente", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV26PacienteId,8,0))}, new String[] {"Gx_mode","PacienteId"})  ;
   }

   public String getPgmname( )
   {
      return "Paciente" ;
   }

   public String getPgmdesc( )
   {
      return "Paciente" ;
   }

   public void initializeNonKey0916( )
   {
      A43PaisId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
      A6SecUserId = (short)(0) ;
      n6SecUserId = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      n6SecUserId = ((0==A6SecUserId) ? true : false) ;
      A44UbigeoCode = "" ;
      n44UbigeoCode = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      n44UbigeoCode = ((GXutil.strcmp("", A44UbigeoCode)==0) ? true : false) ;
      A212PacienteNombreCompleto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A212PacienteNombreCompleto", A212PacienteNombreCompleto);
      A103PacienteApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      A104PacienteApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      A105PacienteNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A213PacienteFechaNacimiento", localUtil.format(A213PacienteFechaNacimiento, "99/99/99"));
      A214PacienteTipoDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
      A106PacienteNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A106PacienteNroDocumento", A106PacienteNroDocumento);
      A215PacienteDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A215PacienteDireccion", A215PacienteDireccion);
      A216PacienteSexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A216PacienteSexo", A216PacienteSexo);
      A217PacienteCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A217PacienteCorreo", A217PacienteCorreo);
      A218PacienteTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A218PacienteTelefono", A218PacienteTelefono);
      A184PaisDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
      A219PacienteEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A219PacienteEstado", A219PacienteEstado);
      A185UbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      A220PacienteEstatura = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A220PacienteEstatura", GXutil.ltrimstr( A220PacienteEstatura, 4, 2));
      A221PacientePeso = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A221PacientePeso", GXutil.ltrimstr( A221PacientePeso, 6, 2));
      A222PacienteNombreAnexo = "" ;
      n222PacienteNombreAnexo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A222PacienteNombreAnexo", A222PacienteNombreAnexo);
      n222PacienteNombreAnexo = ((GXutil.strcmp("", A222PacienteNombreAnexo)==0) ? true : false) ;
      A223PacienteAnexos = "" ;
      n223PacienteAnexos = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A223PacienteAnexos", A223PacienteAnexos);
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteAnexos_Internalname, "URL", httpContext.getResourceRelative(A223PacienteAnexos), true);
      n223PacienteAnexos = ((GXutil.strcmp("", A223PacienteAnexos)==0) ? true : false) ;
      A224PacienteEnterarse = "" ;
      n224PacienteEnterarse = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A224PacienteEnterarse", A224PacienteEnterarse);
      n224PacienteEnterarse = ((GXutil.strcmp("", A224PacienteEnterarse)==0) ? true : false) ;
      A225PacienteEspecifique = "" ;
      n225PacienteEspecifique = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A225PacienteEspecifique", A225PacienteEspecifique);
      n225PacienteEspecifique = ((GXutil.strcmp("", A225PacienteEspecifique)==0) ? true : false) ;
      A186UbigeoDepartamento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      A187UbigeoProvincia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      A188UbigeoDistrito = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      A226PacienteFechaRegistro = GXutil.now( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
      Z103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      Z213PacienteFechaNacimiento = GXutil.nullDate() ;
      Z214PacienteTipoDocumento = "" ;
      Z106PacienteNroDocumento = "" ;
      Z215PacienteDireccion = "" ;
      Z216PacienteSexo = "" ;
      Z217PacienteCorreo = "" ;
      Z218PacienteTelefono = "" ;
      Z219PacienteEstado = "" ;
      Z220PacienteEstatura = DecimalUtil.ZERO ;
      Z221PacientePeso = DecimalUtil.ZERO ;
      Z222PacienteNombreAnexo = "" ;
      Z224PacienteEnterarse = "" ;
      Z226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      Z43PaisId = (short)(0) ;
      Z6SecUserId = (short)(0) ;
      Z44UbigeoCode = "" ;
   }

   public void initAll0916( )
   {
      A20PacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      initializeNonKey0916( ) ;
   }

   public void standaloneModalInsert( )
   {
      A226PacienteFechaRegistro = i226PacienteFechaRegistro ;
      httpContext.ajax_rsp_assign_attri("", false, "A226PacienteFechaRegistro", localUtil.ttoc( A226PacienteFechaRegistro, 8, 5, 0, 3, "/", ":", " "));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110322988", true, true);
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
      httpContext.AddJavascriptSource("paciente.js", "?20225110322989", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      edtPacienteId_Internalname = "PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES" ;
      edtPacienteNombreCompleto_Internalname = "PACIENTENOMBRECOMPLETO" ;
      edtPacienteFechaNacimiento_Internalname = "PACIENTEFECHANACIMIENTO" ;
      cmbPacienteTipoDocumento.setInternalname( "PACIENTETIPODOCUMENTO" );
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO" ;
      edtPacienteDireccion_Internalname = "PACIENTEDIRECCION" ;
      cmbPacienteSexo.setInternalname( "PACIENTESEXO" );
      edtPacienteCorreo_Internalname = "PACIENTECORREO" ;
      edtPacienteTelefono_Internalname = "PACIENTETELEFONO" ;
      lblTextblockpaisid_Internalname = "TEXTBLOCKPAISID" ;
      Combo_paisid_Internalname = "COMBO_PAISID" ;
      edtPaisId_Internalname = "PAISID" ;
      divTablesplittedpaisid_Internalname = "TABLESPLITTEDPAISID" ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION" ;
      cmbPacienteEstado.setInternalname( "PACIENTEESTADO" );
      lblTextblocksecuserid_Internalname = "TEXTBLOCKSECUSERID" ;
      Combo_secuserid_Internalname = "COMBO_SECUSERID" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      divTablesplittedsecuserid_Internalname = "TABLESPLITTEDSECUSERID" ;
      lblTextblockubigeocode_Internalname = "TEXTBLOCKUBIGEOCODE" ;
      Combo_ubigeocode_Internalname = "COMBO_UBIGEOCODE" ;
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      divTablesplittedubigeocode_Internalname = "TABLESPLITTEDUBIGEOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      edtPacienteEstatura_Internalname = "PACIENTEESTATURA" ;
      edtPacientePeso_Internalname = "PACIENTEPESO" ;
      edtPacienteNombreAnexo_Internalname = "PACIENTENOMBREANEXO" ;
      edtPacienteAnexos_Internalname = "PACIENTEANEXOS" ;
      cmbPacienteEnterarse.setInternalname( "PACIENTEENTERARSE" );
      edtPacienteEspecifique_Internalname = "PACIENTEESPECIFIQUE" ;
      edtPacienteFechaRegistro_Internalname = "PACIENTEFECHAREGISTRO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombopaisid_Internalname = "vCOMBOPAISID" ;
      divSectionattribute_paisid_Internalname = "SECTIONATTRIBUTE_PAISID" ;
      edtavCombosecuserid_Internalname = "vCOMBOSECUSERID" ;
      divSectionattribute_secuserid_Internalname = "SECTIONATTRIBUTE_SECUSERID" ;
      edtavComboubigeocode_Internalname = "vCOMBOUBIGEOCODE" ;
      divSectionattribute_ubigeocode_Internalname = "SECTIONATTRIBUTE_UBIGEOCODE" ;
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
      edtPacienteAnexos_Filename = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Paciente" );
      edtavComboubigeocode_Jsonclick = "" ;
      edtavComboubigeocode_Enabled = 0 ;
      edtavComboubigeocode_Visible = 1 ;
      edtavCombosecuserid_Jsonclick = "" ;
      edtavCombosecuserid_Enabled = 0 ;
      edtavCombosecuserid_Visible = 1 ;
      edtavCombopaisid_Jsonclick = "" ;
      edtavCombopaisid_Enabled = 0 ;
      edtavCombopaisid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtPacienteFechaRegistro_Jsonclick = "" ;
      edtPacienteFechaRegistro_Enabled = 1 ;
      edtPacienteEspecifique_Enabled = 1 ;
      cmbPacienteEnterarse.setJsonclick( "" );
      cmbPacienteEnterarse.setEnabled( 1 );
      edtPacienteAnexos_Jsonclick = "" ;
      edtPacienteAnexos_Parameters = "" ;
      edtPacienteAnexos_Contenttype = "" ;
      edtPacienteAnexos_Filetype = "" ;
      edtPacienteAnexos_Enabled = 1 ;
      edtPacienteNombreAnexo_Jsonclick = "" ;
      edtPacienteNombreAnexo_Enabled = 1 ;
      edtPacientePeso_Jsonclick = "" ;
      edtPacientePeso_Enabled = 1 ;
      edtPacienteEstatura_Jsonclick = "" ;
      edtPacienteEstatura_Enabled = 1 ;
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoNombre_Enabled = 0 ;
      edtUbigeoCode_Jsonclick = "" ;
      edtUbigeoCode_Enabled = 1 ;
      edtUbigeoCode_Visible = 1 ;
      Combo_ubigeocode_Datalistprocparametersprefix = " \"ComboName\": \"UbigeoCode\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PacienteId\": 0" ;
      Combo_ubigeocode_Datalistproc = "PacienteLoadDVCombo" ;
      Combo_ubigeocode_Cls = "ExtendedCombo Attribute" ;
      Combo_ubigeocode_Caption = "" ;
      Combo_ubigeocode_Enabled = GXutil.toBoolean( -1) ;
      edtSecUserId_Jsonclick = "" ;
      edtSecUserId_Enabled = 1 ;
      edtSecUserId_Visible = 1 ;
      Combo_secuserid_Datalistprocparametersprefix = " \"ComboName\": \"SecUserId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PacienteId\": 0" ;
      Combo_secuserid_Datalistproc = "PacienteLoadDVCombo" ;
      Combo_secuserid_Cls = "ExtendedCombo Attribute" ;
      Combo_secuserid_Caption = "" ;
      Combo_secuserid_Enabled = GXutil.toBoolean( -1) ;
      cmbPacienteEstado.setJsonclick( "" );
      cmbPacienteEstado.setEnabled( 1 );
      edtPaisDescripcion_Jsonclick = "" ;
      edtPaisDescripcion_Enabled = 0 ;
      edtPaisId_Jsonclick = "" ;
      edtPaisId_Enabled = 1 ;
      edtPaisId_Visible = 1 ;
      Combo_paisid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_paisid_Datalistprocparametersprefix = " \"ComboName\": \"PaisId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PacienteId\": 0" ;
      Combo_paisid_Datalistproc = "PacienteLoadDVCombo" ;
      Combo_paisid_Cls = "ExtendedCombo Attribute" ;
      Combo_paisid_Caption = "" ;
      Combo_paisid_Enabled = GXutil.toBoolean( -1) ;
      edtPacienteTelefono_Jsonclick = "" ;
      edtPacienteTelefono_Enabled = 1 ;
      edtPacienteCorreo_Jsonclick = "" ;
      edtPacienteCorreo_Enabled = 1 ;
      cmbPacienteSexo.setJsonclick( "" );
      cmbPacienteSexo.setEnabled( 1 );
      edtPacienteDireccion_Enabled = 1 ;
      edtPacienteNroDocumento_Jsonclick = "" ;
      edtPacienteNroDocumento_Enabled = 1 ;
      cmbPacienteTipoDocumento.setJsonclick( "" );
      cmbPacienteTipoDocumento.setEnabled( 1 );
      edtPacienteFechaNacimiento_Jsonclick = "" ;
      edtPacienteFechaNacimiento_Enabled = 1 ;
      edtPacienteNombreCompleto_Jsonclick = "" ;
      edtPacienteNombreCompleto_Enabled = 0 ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteNombres_Enabled = 1 ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Enabled = 1 ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Enabled = 1 ;
      edtPacienteId_Jsonclick = "" ;
      edtPacienteId_Enabled = 0 ;
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
      cmbPacienteTipoDocumento.setName( "PACIENTETIPODOCUMENTO" );
      cmbPacienteTipoDocumento.setWebtags( "" );
      cmbPacienteTipoDocumento.addItem("1", "DNI", (short)(0));
      cmbPacienteTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbPacienteTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbPacienteTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbPacienteTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbPacienteTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbPacienteTipoDocumento.getItemCount() > 0 )
      {
         A214PacienteTipoDocumento = cmbPacienteTipoDocumento.getValidValue(A214PacienteTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A214PacienteTipoDocumento", A214PacienteTipoDocumento);
      }
      cmbPacienteSexo.setName( "PACIENTESEXO" );
      cmbPacienteSexo.setWebtags( "" );
      cmbPacienteSexo.addItem("M", "Masculino", (short)(0));
      cmbPacienteSexo.addItem("F", "Femenino", (short)(0));
      if ( cmbPacienteSexo.getItemCount() > 0 )
      {
         A216PacienteSexo = cmbPacienteSexo.getValidValue(A216PacienteSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A216PacienteSexo", A216PacienteSexo);
      }
      cmbPacienteEstado.setName( "PACIENTEESTADO" );
      cmbPacienteEstado.setWebtags( "" );
      cmbPacienteEstado.addItem("A", "Activo", (short)(0));
      cmbPacienteEstado.addItem("P", "Pendiente", (short)(0));
      cmbPacienteEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbPacienteEstado.getItemCount() > 0 )
      {
         A219PacienteEstado = cmbPacienteEstado.getValidValue(A219PacienteEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A219PacienteEstado", A219PacienteEstado);
      }
      cmbPacienteEnterarse.setName( "PACIENTEENTERARSE" );
      cmbPacienteEnterarse.setWebtags( "" );
      cmbPacienteEnterarse.addItem("F", "Facebook", (short)(0));
      cmbPacienteEnterarse.addItem("G", "Búsqueda en Google", (short)(0));
      cmbPacienteEnterarse.addItem("T", "Twitter", (short)(0));
      cmbPacienteEnterarse.addItem("I", "Instagram", (short)(0));
      cmbPacienteEnterarse.addItem("L", "Linked In", (short)(0));
      cmbPacienteEnterarse.addItem("C", "Mediante conocido o familiar", (short)(0));
      cmbPacienteEnterarse.addItem("O", "Otros", (short)(0));
      if ( cmbPacienteEnterarse.getItemCount() > 0 )
      {
         A224PacienteEnterarse = cmbPacienteEnterarse.getValidValue(A224PacienteEnterarse) ;
         n224PacienteEnterarse = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A224PacienteEnterarse", A224PacienteEnterarse);
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

   public void valid_Paisid( )
   {
      /* Using cursor T000918 */
      pr_default.execute(16, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaisId_Internalname ;
      }
      A184PaisDescripcion = T000918_A184PaisDescripcion[0] ;
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
   }

   public void valid_Secuserid( )
   {
      n6SecUserId = false ;
      /* Using cursor T000929 */
      pr_default.execute(27, new Object[] {Boolean.valueOf(n6SecUserId), Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(27) == 101) )
      {
         if ( ! ( (0==A6SecUserId) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSecUserId_Internalname ;
         }
      }
      pr_default.close(27);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Ubigeocode( )
   {
      n44UbigeoCode = false ;
      /* Using cursor T000919 */
      pr_default.execute(17, new Object[] {Boolean.valueOf(n44UbigeoCode), A44UbigeoCode});
      if ( (pr_default.getStatus(17) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A44UbigeoCode)==0) ) )
         {
            httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtUbigeoCode_Internalname ;
         }
      }
      A186UbigeoDepartamento = T000919_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000919_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000919_A188UbigeoDistrito[0] ;
      pr_default.close(17);
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV26PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV26PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12092',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEAPELLIDOPATERNO","{handler:'valid_Pacienteapellidopaterno',iparms:[]");
      setEventMetadata("VALID_PACIENTEAPELLIDOPATERNO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEAPELLIDOMATERNO","{handler:'valid_Pacienteapellidomaterno',iparms:[]");
      setEventMetadata("VALID_PACIENTEAPELLIDOMATERNO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTENOMBRES","{handler:'valid_Pacientenombres',iparms:[]");
      setEventMetadata("VALID_PACIENTENOMBRES",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEFECHANACIMIENTO","{handler:'valid_Pacientefechanacimiento',iparms:[]");
      setEventMetadata("VALID_PACIENTEFECHANACIMIENTO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTETIPODOCUMENTO","{handler:'valid_Pacientetipodocumento',iparms:[]");
      setEventMetadata("VALID_PACIENTETIPODOCUMENTO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTESEXO","{handler:'valid_Pacientesexo',iparms:[]");
      setEventMetadata("VALID_PACIENTESEXO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTECORREO","{handler:'valid_Pacientecorreo',iparms:[]");
      setEventMetadata("VALID_PACIENTECORREO",",oparms:[]}");
      setEventMetadata("VALID_PAISID","{handler:'valid_Paisid',iparms:[{av:'A43PaisId',fld:'PAISID',pic:'ZZZ9'},{av:'A184PaisDescripcion',fld:'PAISDESCRIPCION',pic:''}]");
      setEventMetadata("VALID_PAISID",",oparms:[{av:'A184PaisDescripcion',fld:'PAISDESCRIPCION',pic:''}]}");
      setEventMetadata("VALID_PACIENTEESTADO","{handler:'valid_Pacienteestado',iparms:[]");
      setEventMetadata("VALID_PACIENTEESTADO",",oparms:[]}");
      setEventMetadata("VALID_SECUSERID","{handler:'valid_Secuserid',iparms:[{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_SECUSERID",",oparms:[]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:''},{av:'A186UbigeoDepartamento',fld:'UBIGEODEPARTAMENTO',pic:''},{av:'A187UbigeoProvincia',fld:'UBIGEOPROVINCIA',pic:''},{av:'A188UbigeoDistrito',fld:'UBIGEODISTRITO',pic:''},{av:'A185UbigeoNombre',fld:'UBIGEONOMBRE',pic:''}]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[{av:'A186UbigeoDepartamento',fld:'UBIGEODEPARTAMENTO',pic:''},{av:'A187UbigeoProvincia',fld:'UBIGEOPROVINCIA',pic:''},{av:'A188UbigeoDistrito',fld:'UBIGEODISTRITO',pic:''},{av:'A185UbigeoNombre',fld:'UBIGEONOMBRE',pic:''}]}");
      setEventMetadata("VALID_PACIENTEENTERARSE","{handler:'valid_Pacienteenterarse',iparms:[]");
      setEventMetadata("VALID_PACIENTEENTERARSE",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEFECHAREGISTRO","{handler:'valid_Pacientefecharegistro',iparms:[]");
      setEventMetadata("VALID_PACIENTEFECHAREGISTRO",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOPAISID","{handler:'validv_Combopaisid',iparms:[]");
      setEventMetadata("VALIDV_COMBOPAISID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOSECUSERID","{handler:'validv_Combosecuserid',iparms:[]");
      setEventMetadata("VALIDV_COMBOSECUSERID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOUBIGEOCODE","{handler:'validv_Comboubigeocode',iparms:[]");
      setEventMetadata("VALIDV_COMBOUBIGEOCODE",",oparms:[]}");
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
      pr_default.close(16);
      pr_default.close(27);
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      Z213PacienteFechaNacimiento = GXutil.nullDate() ;
      Z214PacienteTipoDocumento = "" ;
      Z106PacienteNroDocumento = "" ;
      Z215PacienteDireccion = "" ;
      Z216PacienteSexo = "" ;
      Z217PacienteCorreo = "" ;
      Z218PacienteTelefono = "" ;
      Z219PacienteEstado = "" ;
      Z220PacienteEstatura = DecimalUtil.ZERO ;
      Z221PacientePeso = DecimalUtil.ZERO ;
      Z222PacienteNombreAnexo = "" ;
      Z224PacienteEnterarse = "" ;
      Z226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      Z44UbigeoCode = "" ;
      N44UbigeoCode = "" ;
      Combo_ubigeocode_Selectedvalue_get = "" ;
      Combo_secuserid_Selectedvalue_get = "" ;
      Combo_paisid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A44UbigeoCode = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A214PacienteTipoDocumento = "" ;
      A216PacienteSexo = "" ;
      A219PacienteEstado = "" ;
      A224PacienteEnterarse = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A212PacienteNombreCompleto = "" ;
      A213PacienteFechaNacimiento = GXutil.nullDate() ;
      A106PacienteNroDocumento = "" ;
      A215PacienteDireccion = "" ;
      A217PacienteCorreo = "" ;
      gxphoneLink = "" ;
      A218PacienteTelefono = "" ;
      lblTextblockpaisid_Jsonclick = "" ;
      ucCombo_paisid = new com.genexus.webpanels.GXUserControl();
      AV17DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV16PaisId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A184PaisDescripcion = "" ;
      lblTextblocksecuserid_Jsonclick = "" ;
      ucCombo_secuserid = new com.genexus.webpanels.GXUserControl();
      AV22SecUserId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      lblTextblockubigeocode_Jsonclick = "" ;
      ucCombo_ubigeocode = new com.genexus.webpanels.GXUserControl();
      AV24UbigeoCode_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A185UbigeoNombre = "" ;
      A220PacienteEstatura = DecimalUtil.ZERO ;
      A221PacientePeso = DecimalUtil.ZERO ;
      A222PacienteNombreAnexo = "" ;
      gxblobfileaux = new com.genexus.util.GXFile();
      A223PacienteAnexos = "" ;
      A225PacienteEspecifique = "" ;
      A226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV25ComboUbigeoCode = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      AV15Insert_UbigeoCode = "" ;
      AV27Pgmname = "" ;
      Combo_paisid_Objectcall = "" ;
      Combo_paisid_Class = "" ;
      Combo_paisid_Icontype = "" ;
      Combo_paisid_Icon = "" ;
      Combo_paisid_Tooltip = "" ;
      Combo_paisid_Selectedvalue_set = "" ;
      Combo_paisid_Selectedtext_set = "" ;
      Combo_paisid_Selectedtext_get = "" ;
      Combo_paisid_Gamoauthtoken = "" ;
      Combo_paisid_Ddointernalname = "" ;
      Combo_paisid_Titlecontrolalign = "" ;
      Combo_paisid_Dropdownoptionstype = "" ;
      Combo_paisid_Titlecontrolidtoreplace = "" ;
      Combo_paisid_Datalisttype = "" ;
      Combo_paisid_Datalistfixedvalues = "" ;
      Combo_paisid_Htmltemplate = "" ;
      Combo_paisid_Multiplevaluestype = "" ;
      Combo_paisid_Loadingdata = "" ;
      Combo_paisid_Noresultsfound = "" ;
      Combo_paisid_Emptyitemtext = "" ;
      Combo_paisid_Onlyselectedvalues = "" ;
      Combo_paisid_Selectalltext = "" ;
      Combo_paisid_Multiplevaluesseparator = "" ;
      Combo_paisid_Addnewoptiontext = "" ;
      Combo_secuserid_Objectcall = "" ;
      Combo_secuserid_Class = "" ;
      Combo_secuserid_Icontype = "" ;
      Combo_secuserid_Icon = "" ;
      Combo_secuserid_Tooltip = "" ;
      Combo_secuserid_Selectedvalue_set = "" ;
      Combo_secuserid_Selectedtext_set = "" ;
      Combo_secuserid_Selectedtext_get = "" ;
      Combo_secuserid_Gamoauthtoken = "" ;
      Combo_secuserid_Ddointernalname = "" ;
      Combo_secuserid_Titlecontrolalign = "" ;
      Combo_secuserid_Dropdownoptionstype = "" ;
      Combo_secuserid_Titlecontrolidtoreplace = "" ;
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
      Combo_ubigeocode_Objectcall = "" ;
      Combo_ubigeocode_Class = "" ;
      Combo_ubigeocode_Icontype = "" ;
      Combo_ubigeocode_Icon = "" ;
      Combo_ubigeocode_Tooltip = "" ;
      Combo_ubigeocode_Selectedvalue_set = "" ;
      Combo_ubigeocode_Selectedtext_set = "" ;
      Combo_ubigeocode_Selectedtext_get = "" ;
      Combo_ubigeocode_Gamoauthtoken = "" ;
      Combo_ubigeocode_Ddointernalname = "" ;
      Combo_ubigeocode_Titlecontrolalign = "" ;
      Combo_ubigeocode_Dropdownoptionstype = "" ;
      Combo_ubigeocode_Titlecontrolidtoreplace = "" ;
      Combo_ubigeocode_Datalisttype = "" ;
      Combo_ubigeocode_Datalistfixedvalues = "" ;
      Combo_ubigeocode_Htmltemplate = "" ;
      Combo_ubigeocode_Multiplevaluestype = "" ;
      Combo_ubigeocode_Loadingdata = "" ;
      Combo_ubigeocode_Noresultsfound = "" ;
      Combo_ubigeocode_Emptyitemtext = "" ;
      Combo_ubigeocode_Onlyselectedvalues = "" ;
      Combo_ubigeocode_Selectalltext = "" ;
      Combo_ubigeocode_Multiplevaluesseparator = "" ;
      Combo_ubigeocode_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      GXCCtlgxBlob = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode16 = "" ;
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
      AV13TrnContextAtt = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV20Combo_DataJson = "" ;
      AV18ComboSelectedValue = "" ;
      AV19ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z223PacienteAnexos = "" ;
      Z225PacienteEspecifique = "" ;
      Z184PaisDescripcion = "" ;
      Z186UbigeoDepartamento = "" ;
      Z187UbigeoProvincia = "" ;
      Z188UbigeoDistrito = "" ;
      T00094_A184PaisDescripcion = new String[] {""} ;
      T00096_A186UbigeoDepartamento = new String[] {""} ;
      T00096_A187UbigeoProvincia = new String[] {""} ;
      T00096_A188UbigeoDistrito = new String[] {""} ;
      T00097_A20PacienteId = new int[1] ;
      T00097_A103PacienteApellidoPaterno = new String[] {""} ;
      T00097_A104PacienteApellidoMaterno = new String[] {""} ;
      T00097_A105PacienteNombres = new String[] {""} ;
      T00097_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      T00097_A214PacienteTipoDocumento = new String[] {""} ;
      T00097_A106PacienteNroDocumento = new String[] {""} ;
      T00097_A215PacienteDireccion = new String[] {""} ;
      T00097_A216PacienteSexo = new String[] {""} ;
      T00097_A217PacienteCorreo = new String[] {""} ;
      T00097_A218PacienteTelefono = new String[] {""} ;
      T00097_A184PaisDescripcion = new String[] {""} ;
      T00097_A219PacienteEstado = new String[] {""} ;
      T00097_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00097_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00097_A222PacienteNombreAnexo = new String[] {""} ;
      T00097_n222PacienteNombreAnexo = new boolean[] {false} ;
      T00097_A223PacienteAnexos = new String[] {""} ;
      T00097_n223PacienteAnexos = new boolean[] {false} ;
      T00097_A224PacienteEnterarse = new String[] {""} ;
      T00097_n224PacienteEnterarse = new boolean[] {false} ;
      T00097_A225PacienteEspecifique = new String[] {""} ;
      T00097_n225PacienteEspecifique = new boolean[] {false} ;
      T00097_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00097_A186UbigeoDepartamento = new String[] {""} ;
      T00097_A187UbigeoProvincia = new String[] {""} ;
      T00097_A188UbigeoDistrito = new String[] {""} ;
      T00097_A43PaisId = new short[1] ;
      T00097_A6SecUserId = new short[1] ;
      T00097_n6SecUserId = new boolean[] {false} ;
      T00097_A44UbigeoCode = new String[] {""} ;
      T00097_n44UbigeoCode = new boolean[] {false} ;
      T00095_A6SecUserId = new short[1] ;
      T00095_n6SecUserId = new boolean[] {false} ;
      T00098_A184PaisDescripcion = new String[] {""} ;
      T00099_A6SecUserId = new short[1] ;
      T00099_n6SecUserId = new boolean[] {false} ;
      T000910_A186UbigeoDepartamento = new String[] {""} ;
      T000910_A187UbigeoProvincia = new String[] {""} ;
      T000910_A188UbigeoDistrito = new String[] {""} ;
      T000911_A20PacienteId = new int[1] ;
      T00093_A20PacienteId = new int[1] ;
      T00093_A103PacienteApellidoPaterno = new String[] {""} ;
      T00093_A104PacienteApellidoMaterno = new String[] {""} ;
      T00093_A105PacienteNombres = new String[] {""} ;
      T00093_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      T00093_A214PacienteTipoDocumento = new String[] {""} ;
      T00093_A106PacienteNroDocumento = new String[] {""} ;
      T00093_A215PacienteDireccion = new String[] {""} ;
      T00093_A216PacienteSexo = new String[] {""} ;
      T00093_A217PacienteCorreo = new String[] {""} ;
      T00093_A218PacienteTelefono = new String[] {""} ;
      T00093_A219PacienteEstado = new String[] {""} ;
      T00093_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_A222PacienteNombreAnexo = new String[] {""} ;
      T00093_n222PacienteNombreAnexo = new boolean[] {false} ;
      T00093_A223PacienteAnexos = new String[] {""} ;
      T00093_n223PacienteAnexos = new boolean[] {false} ;
      T00093_A224PacienteEnterarse = new String[] {""} ;
      T00093_n224PacienteEnterarse = new boolean[] {false} ;
      T00093_A225PacienteEspecifique = new String[] {""} ;
      T00093_n225PacienteEspecifique = new boolean[] {false} ;
      T00093_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00093_A43PaisId = new short[1] ;
      T00093_A6SecUserId = new short[1] ;
      T00093_n6SecUserId = new boolean[] {false} ;
      T00093_A44UbigeoCode = new String[] {""} ;
      T00093_n44UbigeoCode = new boolean[] {false} ;
      T000912_A20PacienteId = new int[1] ;
      T000913_A20PacienteId = new int[1] ;
      T00092_A20PacienteId = new int[1] ;
      T00092_A103PacienteApellidoPaterno = new String[] {""} ;
      T00092_A104PacienteApellidoMaterno = new String[] {""} ;
      T00092_A105PacienteNombres = new String[] {""} ;
      T00092_A213PacienteFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      T00092_A214PacienteTipoDocumento = new String[] {""} ;
      T00092_A106PacienteNroDocumento = new String[] {""} ;
      T00092_A215PacienteDireccion = new String[] {""} ;
      T00092_A216PacienteSexo = new String[] {""} ;
      T00092_A217PacienteCorreo = new String[] {""} ;
      T00092_A218PacienteTelefono = new String[] {""} ;
      T00092_A219PacienteEstado = new String[] {""} ;
      T00092_A220PacienteEstatura = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_A221PacientePeso = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_A222PacienteNombreAnexo = new String[] {""} ;
      T00092_n222PacienteNombreAnexo = new boolean[] {false} ;
      T00092_A223PacienteAnexos = new String[] {""} ;
      T00092_n223PacienteAnexos = new boolean[] {false} ;
      T00092_A224PacienteEnterarse = new String[] {""} ;
      T00092_n224PacienteEnterarse = new boolean[] {false} ;
      T00092_A225PacienteEspecifique = new String[] {""} ;
      T00092_n225PacienteEspecifique = new boolean[] {false} ;
      T00092_A226PacienteFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00092_A43PaisId = new short[1] ;
      T00092_A6SecUserId = new short[1] ;
      T00092_n6SecUserId = new boolean[] {false} ;
      T00092_A44UbigeoCode = new String[] {""} ;
      T00092_n44UbigeoCode = new boolean[] {false} ;
      T000914_A20PacienteId = new int[1] ;
      T000918_A184PaisDescripcion = new String[] {""} ;
      T000919_A186UbigeoDepartamento = new String[] {""} ;
      T000919_A187UbigeoProvincia = new String[] {""} ;
      T000919_A188UbigeoDistrito = new String[] {""} ;
      T000920_A398RatingPlataformaId = new int[1] ;
      T000921_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T000922_A63ComentarioProfesionalId = new int[1] ;
      T000923_A60RatingProfesionalId = new int[1] ;
      T000924_A45PacienteFamiliarId = new int[1] ;
      T000925_A45PacienteFamiliarId = new int[1] ;
      T000926_A51ReclamoId = new int[1] ;
      T000927_A19CitaId = new int[1] ;
      T000928_A20PacienteId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i226PacienteFechaRegistro = GXutil.resetTime( GXutil.nullDate() );
      T000929_A6SecUserId = new short[1] ;
      T000929_n6SecUserId = new boolean[] {false} ;
      Z185UbigeoNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.paciente__default(),
         new Object[] {
             new Object[] {
            T00092_A20PacienteId, T00092_A103PacienteApellidoPaterno, T00092_A104PacienteApellidoMaterno, T00092_A105PacienteNombres, T00092_A213PacienteFechaNacimiento, T00092_A214PacienteTipoDocumento, T00092_A106PacienteNroDocumento, T00092_A215PacienteDireccion, T00092_A216PacienteSexo, T00092_A217PacienteCorreo,
            T00092_A218PacienteTelefono, T00092_A219PacienteEstado, T00092_A220PacienteEstatura, T00092_A221PacientePeso, T00092_A222PacienteNombreAnexo, T00092_n222PacienteNombreAnexo, T00092_A223PacienteAnexos, T00092_n223PacienteAnexos, T00092_A224PacienteEnterarse, T00092_n224PacienteEnterarse,
            T00092_A225PacienteEspecifique, T00092_n225PacienteEspecifique, T00092_A226PacienteFechaRegistro, T00092_A43PaisId, T00092_A6SecUserId, T00092_n6SecUserId, T00092_A44UbigeoCode, T00092_n44UbigeoCode
            }
            , new Object[] {
            T00093_A20PacienteId, T00093_A103PacienteApellidoPaterno, T00093_A104PacienteApellidoMaterno, T00093_A105PacienteNombres, T00093_A213PacienteFechaNacimiento, T00093_A214PacienteTipoDocumento, T00093_A106PacienteNroDocumento, T00093_A215PacienteDireccion, T00093_A216PacienteSexo, T00093_A217PacienteCorreo,
            T00093_A218PacienteTelefono, T00093_A219PacienteEstado, T00093_A220PacienteEstatura, T00093_A221PacientePeso, T00093_A222PacienteNombreAnexo, T00093_n222PacienteNombreAnexo, T00093_A223PacienteAnexos, T00093_n223PacienteAnexos, T00093_A224PacienteEnterarse, T00093_n224PacienteEnterarse,
            T00093_A225PacienteEspecifique, T00093_n225PacienteEspecifique, T00093_A226PacienteFechaRegistro, T00093_A43PaisId, T00093_A6SecUserId, T00093_n6SecUserId, T00093_A44UbigeoCode, T00093_n44UbigeoCode
            }
            , new Object[] {
            T00094_A184PaisDescripcion
            }
            , new Object[] {
            T00095_A6SecUserId
            }
            , new Object[] {
            T00096_A186UbigeoDepartamento, T00096_A187UbigeoProvincia, T00096_A188UbigeoDistrito
            }
            , new Object[] {
            T00097_A20PacienteId, T00097_A103PacienteApellidoPaterno, T00097_A104PacienteApellidoMaterno, T00097_A105PacienteNombres, T00097_A213PacienteFechaNacimiento, T00097_A214PacienteTipoDocumento, T00097_A106PacienteNroDocumento, T00097_A215PacienteDireccion, T00097_A216PacienteSexo, T00097_A217PacienteCorreo,
            T00097_A218PacienteTelefono, T00097_A184PaisDescripcion, T00097_A219PacienteEstado, T00097_A220PacienteEstatura, T00097_A221PacientePeso, T00097_A222PacienteNombreAnexo, T00097_n222PacienteNombreAnexo, T00097_A223PacienteAnexos, T00097_n223PacienteAnexos, T00097_A224PacienteEnterarse,
            T00097_n224PacienteEnterarse, T00097_A225PacienteEspecifique, T00097_n225PacienteEspecifique, T00097_A226PacienteFechaRegistro, T00097_A186UbigeoDepartamento, T00097_A187UbigeoProvincia, T00097_A188UbigeoDistrito, T00097_A43PaisId, T00097_A6SecUserId, T00097_n6SecUserId,
            T00097_A44UbigeoCode, T00097_n44UbigeoCode
            }
            , new Object[] {
            T00098_A184PaisDescripcion
            }
            , new Object[] {
            T00099_A6SecUserId
            }
            , new Object[] {
            T000910_A186UbigeoDepartamento, T000910_A187UbigeoProvincia, T000910_A188UbigeoDistrito
            }
            , new Object[] {
            T000911_A20PacienteId
            }
            , new Object[] {
            T000912_A20PacienteId
            }
            , new Object[] {
            T000913_A20PacienteId
            }
            , new Object[] {
            T000914_A20PacienteId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000918_A184PaisDescripcion
            }
            , new Object[] {
            T000919_A186UbigeoDepartamento, T000919_A187UbigeoProvincia, T000919_A188UbigeoDistrito
            }
            , new Object[] {
            T000920_A398RatingPlataformaId
            }
            , new Object[] {
            T000921_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            T000922_A63ComentarioProfesionalId
            }
            , new Object[] {
            T000923_A60RatingProfesionalId
            }
            , new Object[] {
            T000924_A45PacienteFamiliarId
            }
            , new Object[] {
            T000925_A45PacienteFamiliarId
            }
            , new Object[] {
            T000926_A51ReclamoId
            }
            , new Object[] {
            T000927_A19CitaId
            }
            , new Object[] {
            T000928_A20PacienteId
            }
            , new Object[] {
            T000929_A6SecUserId
            }
         }
      );
      Z226PacienteFechaRegistro = GXutil.now( ) ;
      A226PacienteFechaRegistro = GXutil.now( ) ;
      i226PacienteFechaRegistro = GXutil.now( ) ;
      AV27Pgmname = "Paciente" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z43PaisId ;
   private short Z6SecUserId ;
   private short N43PaisId ;
   private short N6SecUserId ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV21ComboPaisId ;
   private short AV23ComboSecUserId ;
   private short AV14Insert_PaisId ;
   private short AV12Insert_SecUserId ;
   private short RcdFound16 ;
   private short nIsDirty_16 ;
   private int wcpOAV26PacienteId ;
   private int Z20PacienteId ;
   private int AV26PacienteId ;
   private int trnEnded ;
   private int A20PacienteId ;
   private int edtPacienteId_Enabled ;
   private int edtPacienteApellidoPaterno_Enabled ;
   private int edtPacienteApellidoMaterno_Enabled ;
   private int edtPacienteNombres_Enabled ;
   private int edtPacienteNombreCompleto_Enabled ;
   private int edtPacienteFechaNacimiento_Enabled ;
   private int edtPacienteNroDocumento_Enabled ;
   private int edtPacienteDireccion_Enabled ;
   private int edtPacienteCorreo_Enabled ;
   private int edtPacienteTelefono_Enabled ;
   private int edtPaisId_Visible ;
   private int edtPaisId_Enabled ;
   private int edtPaisDescripcion_Enabled ;
   private int edtSecUserId_Visible ;
   private int edtSecUserId_Enabled ;
   private int edtUbigeoCode_Visible ;
   private int edtUbigeoCode_Enabled ;
   private int edtUbigeoNombre_Enabled ;
   private int edtPacienteEstatura_Enabled ;
   private int edtPacientePeso_Enabled ;
   private int edtPacienteNombreAnexo_Enabled ;
   private int edtPacienteAnexos_Enabled ;
   private int edtPacienteEspecifique_Enabled ;
   private int edtPacienteFechaRegistro_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavCombopaisid_Enabled ;
   private int edtavCombopaisid_Visible ;
   private int edtavCombosecuserid_Enabled ;
   private int edtavCombosecuserid_Visible ;
   private int edtavComboubigeocode_Visible ;
   private int edtavComboubigeocode_Enabled ;
   private int Combo_paisid_Datalistupdateminimumcharacters ;
   private int Combo_secuserid_Datalistupdateminimumcharacters ;
   private int Combo_ubigeocode_Datalistupdateminimumcharacters ;
   private int AV28GXV1 ;
   private int GX_JID ;
   private int idxLst ;
   private java.math.BigDecimal Z220PacienteEstatura ;
   private java.math.BigDecimal Z221PacientePeso ;
   private java.math.BigDecimal A220PacienteEstatura ;
   private java.math.BigDecimal A221PacientePeso ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z214PacienteTipoDocumento ;
   private String Z216PacienteSexo ;
   private String Z218PacienteTelefono ;
   private String Z219PacienteEstado ;
   private String Z44UbigeoCode ;
   private String N44UbigeoCode ;
   private String Combo_ubigeocode_Selectedvalue_get ;
   private String Combo_secuserid_Selectedvalue_get ;
   private String Combo_paisid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A44UbigeoCode ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String A214PacienteTipoDocumento ;
   private String A216PacienteSexo ;
   private String A219PacienteEstado ;
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
   private String edtPacienteId_Internalname ;
   private String edtPacienteId_Jsonclick ;
   private String TempTags ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtPacienteNombreCompleto_Internalname ;
   private String edtPacienteNombreCompleto_Jsonclick ;
   private String edtPacienteFechaNacimiento_Internalname ;
   private String edtPacienteFechaNacimiento_Jsonclick ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtPacienteNroDocumento_Jsonclick ;
   private String edtPacienteDireccion_Internalname ;
   private String edtPacienteCorreo_Internalname ;
   private String edtPacienteCorreo_Jsonclick ;
   private String edtPacienteTelefono_Internalname ;
   private String gxphoneLink ;
   private String A218PacienteTelefono ;
   private String edtPacienteTelefono_Jsonclick ;
   private String divTablesplittedpaisid_Internalname ;
   private String lblTextblockpaisid_Internalname ;
   private String lblTextblockpaisid_Jsonclick ;
   private String Combo_paisid_Caption ;
   private String Combo_paisid_Cls ;
   private String Combo_paisid_Datalistproc ;
   private String Combo_paisid_Datalistprocparametersprefix ;
   private String Combo_paisid_Internalname ;
   private String edtPaisId_Internalname ;
   private String edtPaisId_Jsonclick ;
   private String edtPaisDescripcion_Internalname ;
   private String edtPaisDescripcion_Jsonclick ;
   private String divTablesplittedsecuserid_Internalname ;
   private String lblTextblocksecuserid_Internalname ;
   private String lblTextblocksecuserid_Jsonclick ;
   private String Combo_secuserid_Caption ;
   private String Combo_secuserid_Cls ;
   private String Combo_secuserid_Datalistproc ;
   private String Combo_secuserid_Datalistprocparametersprefix ;
   private String Combo_secuserid_Internalname ;
   private String edtSecUserId_Internalname ;
   private String edtSecUserId_Jsonclick ;
   private String divTablesplittedubigeocode_Internalname ;
   private String lblTextblockubigeocode_Internalname ;
   private String lblTextblockubigeocode_Jsonclick ;
   private String Combo_ubigeocode_Caption ;
   private String Combo_ubigeocode_Cls ;
   private String Combo_ubigeocode_Datalistproc ;
   private String Combo_ubigeocode_Datalistprocparametersprefix ;
   private String Combo_ubigeocode_Internalname ;
   private String edtUbigeoCode_Internalname ;
   private String edtUbigeoCode_Jsonclick ;
   private String edtUbigeoNombre_Internalname ;
   private String edtUbigeoNombre_Jsonclick ;
   private String edtPacienteEstatura_Internalname ;
   private String edtPacienteEstatura_Jsonclick ;
   private String edtPacientePeso_Internalname ;
   private String edtPacientePeso_Jsonclick ;
   private String edtPacienteNombreAnexo_Internalname ;
   private String edtPacienteNombreAnexo_Jsonclick ;
   private String edtPacienteAnexos_Internalname ;
   private String edtPacienteAnexos_Filetype ;
   private String edtPacienteAnexos_Contenttype ;
   private String edtPacienteAnexos_Parameters ;
   private String edtPacienteAnexos_Jsonclick ;
   private String edtPacienteEspecifique_Internalname ;
   private String edtPacienteFechaRegistro_Internalname ;
   private String edtPacienteFechaRegistro_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_paisid_Internalname ;
   private String edtavCombopaisid_Internalname ;
   private String edtavCombopaisid_Jsonclick ;
   private String divSectionattribute_secuserid_Internalname ;
   private String edtavCombosecuserid_Internalname ;
   private String edtavCombosecuserid_Jsonclick ;
   private String divSectionattribute_ubigeocode_Internalname ;
   private String edtavComboubigeocode_Internalname ;
   private String AV25ComboUbigeoCode ;
   private String edtavComboubigeocode_Jsonclick ;
   private String AV15Insert_UbigeoCode ;
   private String AV27Pgmname ;
   private String Combo_paisid_Objectcall ;
   private String Combo_paisid_Class ;
   private String Combo_paisid_Icontype ;
   private String Combo_paisid_Icon ;
   private String Combo_paisid_Tooltip ;
   private String Combo_paisid_Selectedvalue_set ;
   private String Combo_paisid_Selectedtext_set ;
   private String Combo_paisid_Selectedtext_get ;
   private String Combo_paisid_Gamoauthtoken ;
   private String Combo_paisid_Ddointernalname ;
   private String Combo_paisid_Titlecontrolalign ;
   private String Combo_paisid_Dropdownoptionstype ;
   private String Combo_paisid_Titlecontrolidtoreplace ;
   private String Combo_paisid_Datalisttype ;
   private String Combo_paisid_Datalistfixedvalues ;
   private String Combo_paisid_Htmltemplate ;
   private String Combo_paisid_Multiplevaluestype ;
   private String Combo_paisid_Loadingdata ;
   private String Combo_paisid_Noresultsfound ;
   private String Combo_paisid_Emptyitemtext ;
   private String Combo_paisid_Onlyselectedvalues ;
   private String Combo_paisid_Selectalltext ;
   private String Combo_paisid_Multiplevaluesseparator ;
   private String Combo_paisid_Addnewoptiontext ;
   private String Combo_secuserid_Objectcall ;
   private String Combo_secuserid_Class ;
   private String Combo_secuserid_Icontype ;
   private String Combo_secuserid_Icon ;
   private String Combo_secuserid_Tooltip ;
   private String Combo_secuserid_Selectedvalue_set ;
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
   private String Combo_ubigeocode_Objectcall ;
   private String Combo_ubigeocode_Class ;
   private String Combo_ubigeocode_Icontype ;
   private String Combo_ubigeocode_Icon ;
   private String Combo_ubigeocode_Tooltip ;
   private String Combo_ubigeocode_Selectedvalue_set ;
   private String Combo_ubigeocode_Selectedtext_set ;
   private String Combo_ubigeocode_Selectedtext_get ;
   private String Combo_ubigeocode_Gamoauthtoken ;
   private String Combo_ubigeocode_Ddointernalname ;
   private String Combo_ubigeocode_Titlecontrolalign ;
   private String Combo_ubigeocode_Dropdownoptionstype ;
   private String Combo_ubigeocode_Titlecontrolidtoreplace ;
   private String Combo_ubigeocode_Datalisttype ;
   private String Combo_ubigeocode_Datalistfixedvalues ;
   private String Combo_ubigeocode_Htmltemplate ;
   private String Combo_ubigeocode_Multiplevaluestype ;
   private String Combo_ubigeocode_Loadingdata ;
   private String Combo_ubigeocode_Noresultsfound ;
   private String Combo_ubigeocode_Emptyitemtext ;
   private String Combo_ubigeocode_Onlyselectedvalues ;
   private String Combo_ubigeocode_Selectalltext ;
   private String Combo_ubigeocode_Multiplevaluesseparator ;
   private String Combo_ubigeocode_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String edtPacienteAnexos_Filename ;
   private String GXCCtlgxBlob ;
   private String hsh ;
   private String sMode16 ;
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
   private java.util.Date Z226PacienteFechaRegistro ;
   private java.util.Date A226PacienteFechaRegistro ;
   private java.util.Date i226PacienteFechaRegistro ;
   private java.util.Date Z213PacienteFechaNacimiento ;
   private java.util.Date A213PacienteFechaNacimiento ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n6SecUserId ;
   private boolean n44UbigeoCode ;
   private boolean wbErr ;
   private boolean n224PacienteEnterarse ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_paisid_Emptyitem ;
   private boolean n223PacienteAnexos ;
   private boolean n222PacienteNombreAnexo ;
   private boolean Combo_paisid_Enabled ;
   private boolean Combo_paisid_Visible ;
   private boolean Combo_paisid_Allowmultipleselection ;
   private boolean Combo_paisid_Isgriditem ;
   private boolean Combo_paisid_Hasdescription ;
   private boolean Combo_paisid_Includeonlyselectedoption ;
   private boolean Combo_paisid_Includeselectalloption ;
   private boolean Combo_paisid_Includeaddnewoption ;
   private boolean Combo_secuserid_Enabled ;
   private boolean Combo_secuserid_Visible ;
   private boolean Combo_secuserid_Allowmultipleselection ;
   private boolean Combo_secuserid_Isgriditem ;
   private boolean Combo_secuserid_Hasdescription ;
   private boolean Combo_secuserid_Includeonlyselectedoption ;
   private boolean Combo_secuserid_Includeselectalloption ;
   private boolean Combo_secuserid_Emptyitem ;
   private boolean Combo_secuserid_Includeaddnewoption ;
   private boolean Combo_ubigeocode_Enabled ;
   private boolean Combo_ubigeocode_Visible ;
   private boolean Combo_ubigeocode_Allowmultipleselection ;
   private boolean Combo_ubigeocode_Isgriditem ;
   private boolean Combo_ubigeocode_Hasdescription ;
   private boolean Combo_ubigeocode_Includeonlyselectedoption ;
   private boolean Combo_ubigeocode_Includeselectalloption ;
   private boolean Combo_ubigeocode_Emptyitem ;
   private boolean Combo_ubigeocode_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n225PacienteEspecifique ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String A225PacienteEspecifique ;
   private String AV20Combo_DataJson ;
   private String Z225PacienteEspecifique ;
   private String A223PacienteAnexos ;
   private String Z223PacienteAnexos ;
   private String Z103PacienteApellidoPaterno ;
   private String Z104PacienteApellidoMaterno ;
   private String Z105PacienteNombres ;
   private String Z106PacienteNroDocumento ;
   private String Z215PacienteDireccion ;
   private String Z217PacienteCorreo ;
   private String Z222PacienteNombreAnexo ;
   private String Z224PacienteEnterarse ;
   private String A224PacienteEnterarse ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A212PacienteNombreCompleto ;
   private String A106PacienteNroDocumento ;
   private String A215PacienteDireccion ;
   private String A217PacienteCorreo ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A222PacienteNombreAnexo ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String AV18ComboSelectedValue ;
   private String AV19ComboSelectedText ;
   private String Z184PaisDescripcion ;
   private String Z186UbigeoDepartamento ;
   private String Z187UbigeoProvincia ;
   private String Z188UbigeoDistrito ;
   private String Z185UbigeoNombre ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_paisid ;
   private com.genexus.webpanels.GXUserControl ucCombo_secuserid ;
   private com.genexus.webpanels.GXUserControl ucCombo_ubigeocode ;
   private com.genexus.util.GXFile gxblobfileaux ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbPacienteTipoDocumento ;
   private HTMLChoice cmbPacienteSexo ;
   private HTMLChoice cmbPacienteEstado ;
   private HTMLChoice cmbPacienteEnterarse ;
   private IDataStoreProvider pr_default ;
   private String[] T00094_A184PaisDescripcion ;
   private String[] T00096_A186UbigeoDepartamento ;
   private String[] T00096_A187UbigeoProvincia ;
   private String[] T00096_A188UbigeoDistrito ;
   private int[] T00097_A20PacienteId ;
   private String[] T00097_A103PacienteApellidoPaterno ;
   private String[] T00097_A104PacienteApellidoMaterno ;
   private String[] T00097_A105PacienteNombres ;
   private java.util.Date[] T00097_A213PacienteFechaNacimiento ;
   private String[] T00097_A214PacienteTipoDocumento ;
   private String[] T00097_A106PacienteNroDocumento ;
   private String[] T00097_A215PacienteDireccion ;
   private String[] T00097_A216PacienteSexo ;
   private String[] T00097_A217PacienteCorreo ;
   private String[] T00097_A218PacienteTelefono ;
   private String[] T00097_A184PaisDescripcion ;
   private String[] T00097_A219PacienteEstado ;
   private java.math.BigDecimal[] T00097_A220PacienteEstatura ;
   private java.math.BigDecimal[] T00097_A221PacientePeso ;
   private String[] T00097_A222PacienteNombreAnexo ;
   private boolean[] T00097_n222PacienteNombreAnexo ;
   private String[] T00097_A223PacienteAnexos ;
   private boolean[] T00097_n223PacienteAnexos ;
   private String[] T00097_A224PacienteEnterarse ;
   private boolean[] T00097_n224PacienteEnterarse ;
   private String[] T00097_A225PacienteEspecifique ;
   private boolean[] T00097_n225PacienteEspecifique ;
   private java.util.Date[] T00097_A226PacienteFechaRegistro ;
   private String[] T00097_A186UbigeoDepartamento ;
   private String[] T00097_A187UbigeoProvincia ;
   private String[] T00097_A188UbigeoDistrito ;
   private short[] T00097_A43PaisId ;
   private short[] T00097_A6SecUserId ;
   private boolean[] T00097_n6SecUserId ;
   private String[] T00097_A44UbigeoCode ;
   private boolean[] T00097_n44UbigeoCode ;
   private short[] T00095_A6SecUserId ;
   private boolean[] T00095_n6SecUserId ;
   private String[] T00098_A184PaisDescripcion ;
   private short[] T00099_A6SecUserId ;
   private boolean[] T00099_n6SecUserId ;
   private String[] T000910_A186UbigeoDepartamento ;
   private String[] T000910_A187UbigeoProvincia ;
   private String[] T000910_A188UbigeoDistrito ;
   private int[] T000911_A20PacienteId ;
   private int[] T00093_A20PacienteId ;
   private String[] T00093_A103PacienteApellidoPaterno ;
   private String[] T00093_A104PacienteApellidoMaterno ;
   private String[] T00093_A105PacienteNombres ;
   private java.util.Date[] T00093_A213PacienteFechaNacimiento ;
   private String[] T00093_A214PacienteTipoDocumento ;
   private String[] T00093_A106PacienteNroDocumento ;
   private String[] T00093_A215PacienteDireccion ;
   private String[] T00093_A216PacienteSexo ;
   private String[] T00093_A217PacienteCorreo ;
   private String[] T00093_A218PacienteTelefono ;
   private String[] T00093_A219PacienteEstado ;
   private java.math.BigDecimal[] T00093_A220PacienteEstatura ;
   private java.math.BigDecimal[] T00093_A221PacientePeso ;
   private String[] T00093_A222PacienteNombreAnexo ;
   private boolean[] T00093_n222PacienteNombreAnexo ;
   private String[] T00093_A223PacienteAnexos ;
   private boolean[] T00093_n223PacienteAnexos ;
   private String[] T00093_A224PacienteEnterarse ;
   private boolean[] T00093_n224PacienteEnterarse ;
   private String[] T00093_A225PacienteEspecifique ;
   private boolean[] T00093_n225PacienteEspecifique ;
   private java.util.Date[] T00093_A226PacienteFechaRegistro ;
   private short[] T00093_A43PaisId ;
   private short[] T00093_A6SecUserId ;
   private boolean[] T00093_n6SecUserId ;
   private String[] T00093_A44UbigeoCode ;
   private boolean[] T00093_n44UbigeoCode ;
   private int[] T000912_A20PacienteId ;
   private int[] T000913_A20PacienteId ;
   private int[] T00092_A20PacienteId ;
   private String[] T00092_A103PacienteApellidoPaterno ;
   private String[] T00092_A104PacienteApellidoMaterno ;
   private String[] T00092_A105PacienteNombres ;
   private java.util.Date[] T00092_A213PacienteFechaNacimiento ;
   private String[] T00092_A214PacienteTipoDocumento ;
   private String[] T00092_A106PacienteNroDocumento ;
   private String[] T00092_A215PacienteDireccion ;
   private String[] T00092_A216PacienteSexo ;
   private String[] T00092_A217PacienteCorreo ;
   private String[] T00092_A218PacienteTelefono ;
   private String[] T00092_A219PacienteEstado ;
   private java.math.BigDecimal[] T00092_A220PacienteEstatura ;
   private java.math.BigDecimal[] T00092_A221PacientePeso ;
   private String[] T00092_A222PacienteNombreAnexo ;
   private boolean[] T00092_n222PacienteNombreAnexo ;
   private String[] T00092_A223PacienteAnexos ;
   private boolean[] T00092_n223PacienteAnexos ;
   private String[] T00092_A224PacienteEnterarse ;
   private boolean[] T00092_n224PacienteEnterarse ;
   private String[] T00092_A225PacienteEspecifique ;
   private boolean[] T00092_n225PacienteEspecifique ;
   private java.util.Date[] T00092_A226PacienteFechaRegistro ;
   private short[] T00092_A43PaisId ;
   private short[] T00092_A6SecUserId ;
   private boolean[] T00092_n6SecUserId ;
   private String[] T00092_A44UbigeoCode ;
   private boolean[] T00092_n44UbigeoCode ;
   private int[] T000914_A20PacienteId ;
   private String[] T000918_A184PaisDescripcion ;
   private String[] T000919_A186UbigeoDepartamento ;
   private String[] T000919_A187UbigeoProvincia ;
   private String[] T000919_A188UbigeoDistrito ;
   private int[] T000920_A398RatingPlataformaId ;
   private int[] T000921_A397SugerenciasMejorasPlataformaId ;
   private int[] T000922_A63ComentarioProfesionalId ;
   private int[] T000923_A60RatingProfesionalId ;
   private int[] T000924_A45PacienteFamiliarId ;
   private int[] T000925_A45PacienteFamiliarId ;
   private int[] T000926_A51ReclamoId ;
   private int[] T000927_A19CitaId ;
   private int[] T000928_A20PacienteId ;
   private short[] T000929_A6SecUserId ;
   private boolean[] T000929_n6SecUserId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV16PaisId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV22SecUserId_Data ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV24UbigeoCode_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV17DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class paciente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00092", "SELECT [PacienteId], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode] FROM [Paciente] WITH (UPDLOCK) WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00093", "SELECT [PacienteId], [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00094", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00095", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00096", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00097", "SELECT TM1.[PacienteId], TM1.[PacienteApellidoPaterno], TM1.[PacienteApellidoMaterno], TM1.[PacienteNombres], TM1.[PacienteFechaNacimiento], TM1.[PacienteTipoDocumento], TM1.[PacienteNroDocumento], TM1.[PacienteDireccion], TM1.[PacienteSexo], TM1.[PacienteCorreo], TM1.[PacienteTelefono], T2.[PaisDescripcion], TM1.[PacienteEstado], TM1.[PacienteEstatura], TM1.[PacientePeso], TM1.[PacienteNombreAnexo], TM1.[PacienteAnexos], TM1.[PacienteEnterarse], TM1.[PacienteEspecifique], TM1.[PacienteFechaRegistro], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[PaisId], TM1.[SecUserId], TM1.[UbigeoCode] FROM (([Paciente] TM1 INNER JOIN [Pais] T2 ON T2.[PaisId] = TM1.[PaisId]) LEFT JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[PacienteId] = ? ORDER BY TM1.[PacienteId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00098", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00099", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000910", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000911", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000912", "SELECT TOP 1 [PacienteId] FROM [Paciente] WHERE ( [PacienteId] > ?) ORDER BY [PacienteId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000913", "SELECT TOP 1 [PacienteId] FROM [Paciente] WHERE ( [PacienteId] < ?) ORDER BY [PacienteId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000914", "INSERT INTO [Paciente]([PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres], [PacienteFechaNacimiento], [PacienteTipoDocumento], [PacienteNroDocumento], [PacienteDireccion], [PacienteSexo], [PacienteCorreo], [PacienteTelefono], [PacienteEstado], [PacienteEstatura], [PacientePeso], [PacienteNombreAnexo], [PacienteAnexos], [PacienteEnterarse], [PacienteEspecifique], [PacienteFechaRegistro], [PaisId], [SecUserId], [UbigeoCode]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000915", "UPDATE [Paciente] SET [PacienteApellidoPaterno]=?, [PacienteApellidoMaterno]=?, [PacienteNombres]=?, [PacienteFechaNacimiento]=?, [PacienteTipoDocumento]=?, [PacienteNroDocumento]=?, [PacienteDireccion]=?, [PacienteSexo]=?, [PacienteCorreo]=?, [PacienteTelefono]=?, [PacienteEstado]=?, [PacienteEstatura]=?, [PacientePeso]=?, [PacienteNombreAnexo]=?, [PacienteEnterarse]=?, [PacienteEspecifique]=?, [PacienteFechaRegistro]=?, [PaisId]=?, [SecUserId]=?, [UbigeoCode]=?  WHERE [PacienteId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000916", "UPDATE [Paciente] SET [PacienteAnexos]=?  WHERE [PacienteId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000917", "DELETE FROM [Paciente]  WHERE [PacienteId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000918", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000919", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000920", "SELECT TOP 1 [RatingPlataformaId] FROM [RatingPlataforma] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000921", "SELECT TOP 1 [SugerenciasMejorasPlataformaId] FROM [SugerenciasMejorasPlataforma] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000922", "SELECT TOP 1 [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000923", "SELECT TOP 1 [RatingProfesionalId] FROM [RatingProfesional] WHERE [SGPacientePacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000924", "SELECT TOP 1 [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [SGPacienteHijoPacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000925", "SELECT TOP 1 [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000926", "SELECT TOP 1 [ReclamoId] FROM [Reclamo] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000927", "SELECT TOP 1 [CitaId] FROM [Cita] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000928", "SELECT [PacienteId] FROM [Paciente] ORDER BY [PacienteId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000929", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getBLOBFile(16, "tmp", "");
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((short[]) buf[23])[0] = rslt.getShort(20);
               ((short[]) buf[24])[0] = rslt.getShort(21);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(22, 10);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getBLOBFile(16, "tmp", "");
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getLongVarchar(18);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDateTime(19);
               ((short[]) buf[23])[0] = rslt.getShort(20);
               ((short[]) buf[24])[0] = rslt.getShort(21);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(22, 10);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(14,2);
               ((java.math.BigDecimal[]) buf[14])[0] = rslt.getBigDecimal(15,2);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((String[]) buf[17])[0] = rslt.getBLOBFile(17, "tmp", "");
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getLongVarchar(19);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDateTime(20);
               ((String[]) buf[24])[0] = rslt.getVarchar(21);
               ((String[]) buf[25])[0] = rslt.getVarchar(22);
               ((String[]) buf[26])[0] = rslt.getVarchar(23);
               ((short[]) buf[27])[0] = rslt.getShort(24);
               ((short[]) buf[28])[0] = rslt.getShort(25);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getString(26, 10);
               ((boolean[]) buf[31])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 27 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setVarchar(6, (String)parms[5], 15, false);
               stmt.setVarchar(7, (String)parms[6], 500, false);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[14], 100);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(15, (String)parms[16]);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(16, (String)parms[18], 2);
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(17, (String)parms[20]);
               }
               stmt.setDateTime(18, (java.util.Date)parms[21], false);
               stmt.setShort(19, ((Number) parms[22]).shortValue());
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(20, ((Number) parms[24]).shortValue());
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(21, (String)parms[26], 10);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 100, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setVarchar(6, (String)parms[5], 15, false);
               stmt.setVarchar(7, (String)parms[6], 500, false);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(14, (String)parms[14], 100);
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(15, (String)parms[16], 2);
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(16, (String)parms[18]);
               }
               stmt.setDateTime(17, (java.util.Date)parms[19], false);
               stmt.setShort(18, ((Number) parms[20]).shortValue());
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(19, ((Number) parms[22]).shortValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(20, (String)parms[24], 10);
               }
               stmt.setInt(21, ((Number) parms[25]).intValue());
               return;
            case 14 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 10);
               }
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

