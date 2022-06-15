package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class encuesta_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_11") == 0 )
      {
         A19CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_11( A19CitaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_12") == 0 )
      {
         A20PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_12( A20PacienteId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_13") == 0 )
      {
         A21SGCitaDisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_13( A21SGCitaDisponibilidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A72SGCitaDisponibilidadSedeId = (short)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadSedeId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A72SGCitaDisponibilidadSedeId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_17") == 0 )
      {
         A76SGCitaDisponibilidadClinicaId = (short)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadClinicaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_17( A76SGCitaDisponibilidadClinicaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
      {
         A81SGCitaDisponibilidadProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadProfesionalId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_14( A81SGCitaDisponibilidadProfesionalId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_15") == 0 )
      {
         A70SGCitaDisponibilidadEspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "SGCitaDisponibilidadEspecialidadId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_15( A70SGCitaDisponibilidadEspecialidadId) ;
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
            AV20EncuestaId = (short)(GXutil.lval( httpContext.GetPar( "EncuestaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20EncuestaId), 4, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vENCUESTAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20EncuestaId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Encuesta", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public encuesta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public encuesta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( encuesta_impl.class ));
   }

   public encuesta_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbEncuestaAtencion = new HTMLChoice();
      cmbEncuestaAtendido = new HTMLChoice();
      cmbEncuestaEstado = new HTMLChoice();
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
      if ( cmbEncuestaAtencion.getItemCount() > 0 )
      {
         A148EncuestaAtencion = cmbEncuestaAtencion.getValidValue(A148EncuestaAtencion) ;
         n148EncuestaAtencion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A148EncuestaAtencion", A148EncuestaAtencion);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEncuestaAtencion.setValue( GXutil.rtrim( A148EncuestaAtencion) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtencion.getInternalname(), "Values", cmbEncuestaAtencion.ToJavascriptSource(), true);
      }
      if ( cmbEncuestaAtendido.getItemCount() > 0 )
      {
         A149EncuestaAtendido = cmbEncuestaAtendido.getValidValue(A149EncuestaAtendido) ;
         n149EncuestaAtendido = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A149EncuestaAtendido", A149EncuestaAtendido);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEncuestaAtendido.setValue( GXutil.rtrim( A149EncuestaAtendido) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtendido.getInternalname(), "Values", cmbEncuestaAtendido.ToJavascriptSource(), true);
      }
      if ( cmbEncuestaEstado.getItemCount() > 0 )
      {
         A153EncuestaEstado = cmbEncuestaEstado.getValidValue(A153EncuestaEstado) ;
         n153EncuestaEstado = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A153EncuestaEstado", A153EncuestaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEncuestaEstado.setValue( GXutil.rtrim( A153EncuestaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaEstado.getInternalname(), "Values", cmbEncuestaEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaId_Internalname, "Id", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEncuestaId_Internalname, GXutil.ltrim( localUtil.ntoc( A37EncuestaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtEncuestaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEncuestaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEncuestaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablesplittedcitaid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcitaid_Internalname, "Cita Id", "", "", lblTextblockcitaid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_citaid.setProperty("Caption", Combo_citaid_Caption);
      ucCombo_citaid.setProperty("Cls", Combo_citaid_Cls);
      ucCombo_citaid.setProperty("DataListProc", Combo_citaid_Datalistproc);
      ucCombo_citaid.setProperty("DataListProcParametersPrefix", Combo_citaid_Datalistprocparametersprefix);
      ucCombo_citaid.setProperty("EmptyItem", Combo_citaid_Emptyitem);
      ucCombo_citaid.setProperty("DropDownOptionsTitleSettingsIcons", AV15DDO_TitleSettingsIcons);
      ucCombo_citaid.setProperty("DropDownOptionsData", AV14CitaId_Data);
      ucCombo_citaid.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_citaid_Internalname, "COMBO_CITAIDContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaId_Jsonclick, 0, "Attribute", "", "", "", "", edtCitaId_Visible, edtCitaId_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadProfesionalId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, "Profesional Id", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadProFullName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, "Profesional", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadProFullName_Internalname, A82SGCitaDisponibilidadProFullName, GXutil.rtrim( localUtil.format( A82SGCitaDisponibilidadProFullName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadProFullName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadProFullName_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadEspecialidadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Especialidad Id", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadEspecialidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadEspecialidadId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadEspecialidadNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Especialidad", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, A146SGCitaDisponibilidadEspecialidadNombre, GXutil.rtrim( localUtil.format( A146SGCitaDisponibilidadEspecialidadNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadEspecialidadNombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadId_Internalname, "Disponibilidad Id", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadFecha_Internalname, "Disponibilidad Fecha", " AttributeDateLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      httpContext.writeText( "<div id=\""+edtSGCitaDisponibilidadFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadFecha_Internalname, localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"), localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadFecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtSGCitaDisponibilidadFecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSGCitaDisponibilidadFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSGCitaDisponibilidadFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Encuesta.htm");
      httpContext.writeTextNL( "</div>") ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteId_Internalname, "Paciente Id", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoPaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoPaterno_Internalname, "Paciente Ap. Paterno", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoPaterno_Internalname, A103PacienteApellidoPaterno, GXutil.rtrim( localUtil.format( A103PacienteApellidoPaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoPaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteApellidoPaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteApellidoMaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteApellidoMaterno_Internalname, "Paciente Ap. Materno", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteApellidoMaterno_Internalname, A104PacienteApellidoMaterno, GXutil.rtrim( localUtil.format( A104PacienteApellidoMaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteApellidoMaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteApellidoMaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteNombres_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteNombres_Internalname, "Paciente Nombres", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteNombres_Internalname, A105PacienteNombres, GXutil.rtrim( localUtil.format( A105PacienteNombres, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteNombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteNombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadClinicaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, "Clinica Id", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaId_Internalname, GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGCitaDisponibilidadClinicaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGCitaDisponibilidadClinicaNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Clinica", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGCitaDisponibilidadClinicaNombre_Internalname, A78SGCitaDisponibilidadClinicaNombre, GXutil.rtrim( localUtil.format( A78SGCitaDisponibilidadClinicaNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGCitaDisponibilidadClinicaNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGCitaDisponibilidadClinicaNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEncuestaAtencion.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEncuestaAtencion.getInternalname(), "Atencion", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEncuestaAtencion, cmbEncuestaAtencion.getInternalname(), GXutil.rtrim( A148EncuestaAtencion), 1, cmbEncuestaAtencion.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEncuestaAtencion.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,91);\"", "", true, (byte)(1), "HLP_Encuesta.htm");
      cmbEncuestaAtencion.setValue( GXutil.rtrim( A148EncuestaAtencion) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtencion.getInternalname(), "Values", cmbEncuestaAtencion.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEncuestaAtendido.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEncuestaAtendido.getInternalname(), "Atendido", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEncuestaAtendido, cmbEncuestaAtendido.getInternalname(), GXutil.rtrim( A149EncuestaAtendido), 1, cmbEncuestaAtendido.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEncuestaAtendido.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,95);\"", "", true, (byte)(1), "HLP_Encuesta.htm");
      cmbEncuestaAtendido.setValue( GXutil.rtrim( A149EncuestaAtendido) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtendido.getInternalname(), "Values", cmbEncuestaAtendido.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaHoraAtencion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaHoraAtencion_Internalname, "Hora Atencion", " AttributeDateTimeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtEncuestaHoraAtencion_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEncuestaHoraAtencion_Internalname, localUtil.ttoc( A150EncuestaHoraAtencion, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A150EncuestaHoraAtencion, "99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 0,'DMY',5,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 0,'DMY',5,24,'spa',false,0);"+";gx.evt.onblur(this,100);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEncuestaHoraAtencion_Jsonclick, 0, "AttributeDateTime", "", "", "", "", 1, edtEncuestaHoraAtencion_Enabled, 0, "text", "", 5, "chr", 1, "row", 5, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtEncuestaHoraAtencion_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtEncuestaHoraAtencion_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Encuesta.htm");
      httpContext.writeTextNL( "</div>") ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaComentarios_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaComentarios_Internalname, "Comentarios", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtEncuestaComentarios_Internalname, A151EncuestaComentarios, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,104);\"", (short)(0), 1, edtEncuestaComentarios_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEncuestaRecomendacion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEncuestaRecomendacion_Internalname, "Recomendacion", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEncuestaRecomendacion_Internalname, GXutil.ltrim( localUtil.ntoc( A152EncuestaRecomendacion, (byte)(2), (byte)(0), ",", "")), GXutil.ltrim( ((edtEncuestaRecomendacion_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEncuestaRecomendacion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEncuestaRecomendacion_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEncuestaEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEncuestaEstado.getInternalname(), "Estado", " AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 113,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEncuestaEstado, cmbEncuestaEstado.getInternalname(), GXutil.rtrim( A153EncuestaEstado), 1, cmbEncuestaEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEncuestaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,113);\"", "", true, (byte)(1), "HLP_Encuesta.htm");
      cmbEncuestaEstado.setValue( GXutil.rtrim( A153EncuestaEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaEstado.getInternalname(), "Values", cmbEncuestaEstado.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Encuesta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Encuesta.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionattribute_citaid_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavCombocitaid_Internalname, GXutil.ltrim( localUtil.ntoc( AV19ComboCitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtavCombocitaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV19ComboCitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV19ComboCitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCombocitaid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCombocitaid_Visible, edtavCombocitaid_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Encuesta.htm");
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
      e110L2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV15DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCITAID_DATA"), AV14CitaId_Data);
            /* Read saved values. */
            Z37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z37EncuestaId"), ",", ".")) ;
            Z148EncuestaAtencion = httpContext.cgiGet( "Z148EncuestaAtencion") ;
            n148EncuestaAtencion = ((GXutil.strcmp("", A148EncuestaAtencion)==0) ? true : false) ;
            Z149EncuestaAtendido = httpContext.cgiGet( "Z149EncuestaAtendido") ;
            n149EncuestaAtendido = ((GXutil.strcmp("", A149EncuestaAtendido)==0) ? true : false) ;
            Z150EncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( "Z150EncuestaHoraAtencion"), 0)) ;
            n150EncuestaHoraAtencion = (GXutil.dateCompare(GXutil.nullDate(), A150EncuestaHoraAtencion) ? true : false) ;
            Z152EncuestaRecomendacion = (byte)(localUtil.ctol( httpContext.cgiGet( "Z152EncuestaRecomendacion"), ",", ".")) ;
            Z153EncuestaEstado = httpContext.cgiGet( "Z153EncuestaEstado") ;
            n153EncuestaEstado = ((GXutil.strcmp("", A153EncuestaEstado)==0) ? true : false) ;
            Z19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z19CitaId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "N19CitaId"), ",", ".")) ;
            A84ProfesionalNombres = httpContext.cgiGet( "PROFESIONALNOMBRES") ;
            n84ProfesionalNombres = false ;
            A85ProfesionalApellidoPaterno = httpContext.cgiGet( "PROFESIONALAPELLIDOPATERNO") ;
            n85ProfesionalApellidoPaterno = false ;
            A86ProfesionalApellidoMaterno = httpContext.cgiGet( "PROFESIONALAPELLIDOMATERNO") ;
            n86ProfesionalApellidoMaterno = false ;
            AV20EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( "vENCUESTAID"), ",", ".")) ;
            AV12Insert_CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CITAID"), ",", ".")) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            A72SGCitaDisponibilidadSedeId = (short)(localUtil.ctol( httpContext.cgiGet( "SGCITADISPONIBILIDADSEDEID"), ",", ".")) ;
            AV22Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_citaid_Objectcall = httpContext.cgiGet( "COMBO_CITAID_Objectcall") ;
            Combo_citaid_Class = httpContext.cgiGet( "COMBO_CITAID_Class") ;
            Combo_citaid_Icontype = httpContext.cgiGet( "COMBO_CITAID_Icontype") ;
            Combo_citaid_Icon = httpContext.cgiGet( "COMBO_CITAID_Icon") ;
            Combo_citaid_Caption = httpContext.cgiGet( "COMBO_CITAID_Caption") ;
            Combo_citaid_Tooltip = httpContext.cgiGet( "COMBO_CITAID_Tooltip") ;
            Combo_citaid_Cls = httpContext.cgiGet( "COMBO_CITAID_Cls") ;
            Combo_citaid_Selectedvalue_set = httpContext.cgiGet( "COMBO_CITAID_Selectedvalue_set") ;
            Combo_citaid_Selectedvalue_get = httpContext.cgiGet( "COMBO_CITAID_Selectedvalue_get") ;
            Combo_citaid_Selectedtext_set = httpContext.cgiGet( "COMBO_CITAID_Selectedtext_set") ;
            Combo_citaid_Selectedtext_get = httpContext.cgiGet( "COMBO_CITAID_Selectedtext_get") ;
            Combo_citaid_Gamoauthtoken = httpContext.cgiGet( "COMBO_CITAID_Gamoauthtoken") ;
            Combo_citaid_Ddointernalname = httpContext.cgiGet( "COMBO_CITAID_Ddointernalname") ;
            Combo_citaid_Titlecontrolalign = httpContext.cgiGet( "COMBO_CITAID_Titlecontrolalign") ;
            Combo_citaid_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CITAID_Dropdownoptionstype") ;
            Combo_citaid_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Enabled")) ;
            Combo_citaid_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Visible")) ;
            Combo_citaid_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CITAID_Titlecontrolidtoreplace") ;
            Combo_citaid_Datalisttype = httpContext.cgiGet( "COMBO_CITAID_Datalisttype") ;
            Combo_citaid_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Allowmultipleselection")) ;
            Combo_citaid_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CITAID_Datalistfixedvalues") ;
            Combo_citaid_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Isgriditem")) ;
            Combo_citaid_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Hasdescription")) ;
            Combo_citaid_Datalistproc = httpContext.cgiGet( "COMBO_CITAID_Datalistproc") ;
            Combo_citaid_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CITAID_Datalistprocparametersprefix") ;
            Combo_citaid_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CITAID_Datalistupdateminimumcharacters"), ",", ".")) ;
            Combo_citaid_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Includeonlyselectedoption")) ;
            Combo_citaid_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Includeselectalloption")) ;
            Combo_citaid_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Emptyitem")) ;
            Combo_citaid_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CITAID_Includeaddnewoption")) ;
            Combo_citaid_Htmltemplate = httpContext.cgiGet( "COMBO_CITAID_Htmltemplate") ;
            Combo_citaid_Multiplevaluestype = httpContext.cgiGet( "COMBO_CITAID_Multiplevaluestype") ;
            Combo_citaid_Loadingdata = httpContext.cgiGet( "COMBO_CITAID_Loadingdata") ;
            Combo_citaid_Noresultsfound = httpContext.cgiGet( "COMBO_CITAID_Noresultsfound") ;
            Combo_citaid_Emptyitemtext = httpContext.cgiGet( "COMBO_CITAID_Emptyitemtext") ;
            Combo_citaid_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CITAID_Onlyselectedvalues") ;
            Combo_citaid_Selectalltext = httpContext.cgiGet( "COMBO_CITAID_Selectalltext") ;
            Combo_citaid_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CITAID_Multiplevaluesseparator") ;
            Combo_citaid_Addnewoptiontext = httpContext.cgiGet( "COMBO_CITAID_Addnewoptiontext") ;
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
            A37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( edtEncuestaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A19CitaId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            }
            else
            {
               A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
            }
            A81SGCitaDisponibilidadProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadProfesionalId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
            A82SGCitaDisponibilidadProFullName = httpContext.cgiGet( edtSGCitaDisponibilidadProFullName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
            A70SGCitaDisponibilidadEspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
            A146SGCitaDisponibilidadEspecialidadNombre = httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
            A21SGCitaDisponibilidadId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
            A66SGCitaDisponibilidadFecha = localUtil.ctod( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 3) ;
            n66SGCitaDisponibilidadFecha = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
            A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
            A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
            A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
            A76SGCitaDisponibilidadClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( edtSGCitaDisponibilidadClinicaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
            A78SGCitaDisponibilidadClinicaNombre = httpContext.cgiGet( edtSGCitaDisponibilidadClinicaNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
            cmbEncuestaAtencion.setValue( httpContext.cgiGet( cmbEncuestaAtencion.getInternalname()) );
            A148EncuestaAtencion = httpContext.cgiGet( cmbEncuestaAtencion.getInternalname()) ;
            n148EncuestaAtencion = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A148EncuestaAtencion", A148EncuestaAtencion);
            n148EncuestaAtencion = ((GXutil.strcmp("", A148EncuestaAtencion)==0) ? true : false) ;
            cmbEncuestaAtendido.setValue( httpContext.cgiGet( cmbEncuestaAtendido.getInternalname()) );
            A149EncuestaAtendido = httpContext.cgiGet( cmbEncuestaAtendido.getInternalname()) ;
            n149EncuestaAtendido = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A149EncuestaAtendido", A149EncuestaAtendido);
            n149EncuestaAtendido = ((GXutil.strcmp("", A149EncuestaAtendido)==0) ? true : false) ;
            if ( localUtil.vcdate( httpContext.cgiGet( edtEncuestaHoraAtencion_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badtime", new Object[] {}), 1, "ENCUESTAHORAATENCION");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEncuestaHoraAtencion_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
               n150EncuestaHoraAtencion = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
            }
            else
            {
               A150EncuestaHoraAtencion = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtEncuestaHoraAtencion_Internalname))) ;
               n150EncuestaHoraAtencion = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
            }
            n150EncuestaHoraAtencion = (GXutil.dateCompare(GXutil.nullDate(), A150EncuestaHoraAtencion) ? true : false) ;
            A151EncuestaComentarios = httpContext.cgiGet( edtEncuestaComentarios_Internalname) ;
            n151EncuestaComentarios = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A151EncuestaComentarios", A151EncuestaComentarios);
            n151EncuestaComentarios = ((GXutil.strcmp("", A151EncuestaComentarios)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEncuestaRecomendacion_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEncuestaRecomendacion_Internalname), ",", ".") > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "ENCUESTARECOMENDACION");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEncuestaRecomendacion_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A152EncuestaRecomendacion = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A152EncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), 2, 0));
            }
            else
            {
               A152EncuestaRecomendacion = (byte)(localUtil.ctol( httpContext.cgiGet( edtEncuestaRecomendacion_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A152EncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), 2, 0));
            }
            cmbEncuestaEstado.setValue( httpContext.cgiGet( cmbEncuestaEstado.getInternalname()) );
            A153EncuestaEstado = httpContext.cgiGet( cmbEncuestaEstado.getInternalname()) ;
            n153EncuestaEstado = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A153EncuestaEstado", A153EncuestaEstado);
            n153EncuestaEstado = ((GXutil.strcmp("", A153EncuestaEstado)==0) ? true : false) ;
            AV19ComboCitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtavCombocitaid_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Encuesta");
            A37EncuestaId = (short)(localUtil.ctol( httpContext.cgiGet( edtEncuestaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
            forbiddenHiddens.add("EncuestaId", localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A37EncuestaId != Z37EncuestaId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("encuesta:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A37EncuestaId = (short)(GXutil.lval( httpContext.GetPar( "EncuestaId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
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
                  sMode29 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode29 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound29 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0L0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "ENCUESTAID");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEncuestaId_Internalname ;
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
                        e110L2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120L2 ();
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
         e120L2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0L29( ) ;
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
         disableAttributes0L29( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Enabled), 5, 0), true);
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

   public void confirm_0L0( )
   {
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0L29( ) ;
         }
         else
         {
            checkExtendedTable0L29( ) ;
            closeExtendedTableCursors0L29( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption0L0( )
   {
   }

   public void e110L2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV7WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV7WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV15DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV15DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtCitaId_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Visible), 5, 0), true);
      AV19ComboCitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
      edtavCombocitaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCITAID' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(8);
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
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Insert", GXv_boolean5) ;
         encuesta_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Update", GXv_boolean5) ;
         encuesta_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV8IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new com.projectthani.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEncuesta_Delete", GXv_boolean5) ;
         encuesta_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV8IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8IsAuthorized", AV8IsAuthorized);
      }
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("com.projectthani.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         while ( AV23GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "CitaId") == 0 )
            {
               AV12Insert_CitaId = (int)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV12Insert_CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Insert_CitaId), 8, 0));
               if ( ! (0==AV12Insert_CitaId) )
               {
                  AV19ComboCitaId = AV12Insert_CitaId ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
                  Combo_citaid_Selectedvalue_set = GXutil.trim( GXutil.str( AV19ComboCitaId, 8, 0)) ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedValue_set", Combo_citaid_Selectedvalue_set);
                  GXt_char6 = AV18Combo_DataJson ;
                  GXv_char7[0] = AV16ComboSelectedValue ;
                  GXv_char8[0] = AV17ComboSelectedText ;
                  GXv_char9[0] = GXt_char6 ;
                  new com.projectthani.encuestaloaddvcombo(remoteHandle, context).execute( "CitaId", "GET", false, AV20EncuestaId, AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), GXv_char7, GXv_char8, GXv_char9) ;
                  encuesta_impl.this.AV16ComboSelectedValue = GXv_char7[0] ;
                  encuesta_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
                  encuesta_impl.this.GXt_char6 = GXv_char9[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
                  httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
                  AV18Combo_DataJson = GXt_char6 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
                  Combo_citaid_Selectedtext_set = AV17ComboSelectedText ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedText_set", Combo_citaid_Selectedtext_set);
                  Combo_citaid_Enabled = false ;
                  ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "Enabled", GXutil.booltostr( Combo_citaid_Enabled));
               }
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GXV1), 8, 0));
         }
      }
   }

   public void e120L2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV10TrnContext.getgxTv_SdtWWPTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.projectthani.encuestaww", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(8);
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

   public void S112( )
   {
      /* 'LOADCOMBOCITAID' Routine */
      returnInSub = false ;
      GXt_char6 = AV18Combo_DataJson ;
      GXv_char9[0] = AV16ComboSelectedValue ;
      GXv_char8[0] = AV17ComboSelectedText ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.encuestaloaddvcombo(remoteHandle, context).execute( "CitaId", Gx_mode, false, AV20EncuestaId, "", GXv_char9, GXv_char8, GXv_char7) ;
      encuesta_impl.this.AV16ComboSelectedValue = GXv_char9[0] ;
      encuesta_impl.this.AV17ComboSelectedText = GXv_char8[0] ;
      encuesta_impl.this.GXt_char6 = GXv_char7[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16ComboSelectedValue", AV16ComboSelectedValue);
      httpContext.ajax_rsp_assign_attri("", false, "AV17ComboSelectedText", AV17ComboSelectedText);
      AV18Combo_DataJson = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Combo_DataJson", AV18Combo_DataJson);
      Combo_citaid_Selectedvalue_set = AV16ComboSelectedValue ;
      ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedValue_set", Combo_citaid_Selectedvalue_set);
      Combo_citaid_Selectedtext_set = AV17ComboSelectedText ;
      ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "SelectedText_set", Combo_citaid_Selectedtext_set);
      AV19ComboCitaId = (int)(GXutil.lval( AV16ComboSelectedValue)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19ComboCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19ComboCitaId), 8, 0));
      if ( ( GXutil.strcmp(Gx_mode, "DSP") == 0 ) || ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) )
      {
         Combo_citaid_Enabled = false ;
         ucCombo_citaid.sendProperty(context, "", false, Combo_citaid_Internalname, "Enabled", GXutil.booltostr( Combo_citaid_Enabled));
      }
   }

   public void zm0L29( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z148EncuestaAtencion = T000L3_A148EncuestaAtencion[0] ;
            Z149EncuestaAtendido = T000L3_A149EncuestaAtendido[0] ;
            Z150EncuestaHoraAtencion = T000L3_A150EncuestaHoraAtencion[0] ;
            Z152EncuestaRecomendacion = T000L3_A152EncuestaRecomendacion[0] ;
            Z153EncuestaEstado = T000L3_A153EncuestaEstado[0] ;
            Z19CitaId = T000L3_A19CitaId[0] ;
         }
         else
         {
            Z148EncuestaAtencion = A148EncuestaAtencion ;
            Z149EncuestaAtendido = A149EncuestaAtendido ;
            Z150EncuestaHoraAtencion = A150EncuestaHoraAtencion ;
            Z152EncuestaRecomendacion = A152EncuestaRecomendacion ;
            Z153EncuestaEstado = A153EncuestaEstado ;
            Z19CitaId = A19CitaId ;
         }
      }
      if ( GX_JID == -10 )
      {
         Z37EncuestaId = A37EncuestaId ;
         Z148EncuestaAtencion = A148EncuestaAtencion ;
         Z149EncuestaAtendido = A149EncuestaAtendido ;
         Z150EncuestaHoraAtencion = A150EncuestaHoraAtencion ;
         Z151EncuestaComentarios = A151EncuestaComentarios ;
         Z152EncuestaRecomendacion = A152EncuestaRecomendacion ;
         Z153EncuestaEstado = A153EncuestaEstado ;
         Z19CitaId = A19CitaId ;
         Z20PacienteId = A20PacienteId ;
         Z21SGCitaDisponibilidadId = A21SGCitaDisponibilidadId ;
         Z103PacienteApellidoPaterno = A103PacienteApellidoPaterno ;
         Z104PacienteApellidoMaterno = A104PacienteApellidoMaterno ;
         Z105PacienteNombres = A105PacienteNombres ;
         Z72SGCitaDisponibilidadSedeId = A72SGCitaDisponibilidadSedeId ;
         Z66SGCitaDisponibilidadFecha = A66SGCitaDisponibilidadFecha ;
         Z81SGCitaDisponibilidadProfesionalId = A81SGCitaDisponibilidadProfesionalId ;
         Z70SGCitaDisponibilidadEspecialidadId = A70SGCitaDisponibilidadEspecialidadId ;
         Z76SGCitaDisponibilidadClinicaId = A76SGCitaDisponibilidadClinicaId ;
         Z78SGCitaDisponibilidadClinicaNombre = A78SGCitaDisponibilidadClinicaNombre ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z146SGCitaDisponibilidadEspecialidadNombre = A146SGCitaDisponibilidadEspecialidadNombre ;
      }
   }

   public void standaloneNotModal( )
   {
      edtEncuestaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaId_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtEncuestaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaId_Enabled), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV20EncuestaId) )
      {
         A37EncuestaId = AV20EncuestaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CitaId) )
      {
         edtCitaId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      }
      else
      {
         edtCitaId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV12Insert_CitaId) )
      {
         A19CitaId = AV12Insert_CitaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      }
      else
      {
         A19CitaId = AV19ComboCitaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
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
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A150EncuestaHoraAtencion) && ( Gx_BScreen == 0 ) )
      {
         A150EncuestaHoraAtencion = GXutil.resetDate(GXutil.now( )) ;
         n150EncuestaHoraAtencion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV22Pgmname = "Encuesta" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T000L4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A19CitaId)});
         A20PacienteId = T000L4_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A21SGCitaDisponibilidadId = T000L4_A21SGCitaDisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         pr_default.close(2);
         /* Using cursor T000L5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A20PacienteId)});
         A103PacienteApellidoPaterno = T000L5_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T000L5_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T000L5_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         pr_default.close(3);
         /* Using cursor T000L6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A72SGCitaDisponibilidadSedeId = T000L6_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = T000L6_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000L6_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A81SGCitaDisponibilidadProfesionalId = T000L6_A81SGCitaDisponibilidadProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A70SGCitaDisponibilidadEspecialidadId = T000L6_A70SGCitaDisponibilidadEspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         pr_default.close(4);
         /* Using cursor T000L9 */
         pr_default.execute(7, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
         A76SGCitaDisponibilidadClinicaId = T000L9_A76SGCitaDisponibilidadClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         pr_default.close(7);
         /* Using cursor T000L10 */
         pr_default.execute(8, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
         A78SGCitaDisponibilidadClinicaNombre = T000L10_A78SGCitaDisponibilidadClinicaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         pr_default.close(8);
         /* Using cursor T000L7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
         A84ProfesionalNombres = T000L7_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = T000L7_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = T000L7_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = T000L7_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = T000L7_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = T000L7_n86ProfesionalApellidoMaterno[0] ;
         pr_default.close(5);
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
         /* Using cursor T000L8 */
         pr_default.execute(6, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
         A146SGCitaDisponibilidadEspecialidadNombre = T000L8_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         pr_default.close(6);
      }
   }

   public void load0L29( )
   {
      /* Using cursor T000L11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A72SGCitaDisponibilidadSedeId = T000L11_A72SGCitaDisponibilidadSedeId[0] ;
         A146SGCitaDisponibilidadEspecialidadNombre = T000L11_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         A66SGCitaDisponibilidadFecha = T000L11_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000L11_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A103PacienteApellidoPaterno = T000L11_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T000L11_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T000L11_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         A78SGCitaDisponibilidadClinicaNombre = T000L11_A78SGCitaDisponibilidadClinicaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         A148EncuestaAtencion = T000L11_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = T000L11_n148EncuestaAtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148EncuestaAtencion", A148EncuestaAtencion);
         A149EncuestaAtendido = T000L11_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = T000L11_n149EncuestaAtendido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A149EncuestaAtendido", A149EncuestaAtendido);
         A150EncuestaHoraAtencion = T000L11_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = T000L11_n150EncuestaHoraAtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
         A151EncuestaComentarios = T000L11_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = T000L11_n151EncuestaComentarios[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A151EncuestaComentarios", A151EncuestaComentarios);
         A152EncuestaRecomendacion = T000L11_A152EncuestaRecomendacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A152EncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), 2, 0));
         A153EncuestaEstado = T000L11_A153EncuestaEstado[0] ;
         n153EncuestaEstado = T000L11_n153EncuestaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153EncuestaEstado", A153EncuestaEstado);
         A84ProfesionalNombres = T000L11_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = T000L11_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = T000L11_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = T000L11_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = T000L11_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = T000L11_n86ProfesionalApellidoMaterno[0] ;
         A19CitaId = T000L11_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A20PacienteId = T000L11_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A21SGCitaDisponibilidadId = T000L11_A21SGCitaDisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         A81SGCitaDisponibilidadProfesionalId = T000L11_A81SGCitaDisponibilidadProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A70SGCitaDisponibilidadEspecialidadId = T000L11_A70SGCitaDisponibilidadEspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         A76SGCitaDisponibilidadClinicaId = T000L11_A76SGCitaDisponibilidadClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         zm0L29( -10) ;
      }
      pr_default.close(9);
      onLoadActions0L29( ) ;
   }

   public void onLoadActions0L29( )
   {
      AV22Pgmname = "Encuesta" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
   }

   public void checkExtendedTable0L29( )
   {
      nIsDirty_29 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV22Pgmname = "Encuesta" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
      /* Using cursor T000L4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A20PacienteId = T000L4_A20PacienteId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      A21SGCitaDisponibilidadId = T000L4_A21SGCitaDisponibilidadId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
      pr_default.close(2);
      /* Using cursor T000L5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
      }
      A103PacienteApellidoPaterno = T000L5_A103PacienteApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      A104PacienteApellidoMaterno = T000L5_A104PacienteApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      A105PacienteNombres = T000L5_A105PacienteNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      pr_default.close(3);
      /* Using cursor T000L6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
      }
      A72SGCitaDisponibilidadSedeId = T000L6_A72SGCitaDisponibilidadSedeId[0] ;
      A66SGCitaDisponibilidadFecha = T000L6_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000L6_n66SGCitaDisponibilidadFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      A81SGCitaDisponibilidadProfesionalId = T000L6_A81SGCitaDisponibilidadProfesionalId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
      A70SGCitaDisponibilidadEspecialidadId = T000L6_A70SGCitaDisponibilidadEspecialidadId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
      pr_default.close(4);
      /* Using cursor T000L9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A76SGCitaDisponibilidadClinicaId = T000L9_A76SGCitaDisponibilidadClinicaId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
      pr_default.close(7);
      /* Using cursor T000L10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = T000L10_A78SGCitaDisponibilidadClinicaNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
      pr_default.close(8);
      /* Using cursor T000L7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A84ProfesionalNombres = T000L7_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = T000L7_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = T000L7_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = T000L7_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = T000L7_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = T000L7_n86ProfesionalApellidoMaterno[0] ;
      pr_default.close(5);
      nIsDirty_29 = (short)(1) ;
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
      /* Using cursor T000L8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = T000L8_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0L29( )
   {
      pr_default.close(2);
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(7);
      pr_default.close(8);
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_11( int A19CitaId )
   {
      /* Using cursor T000L12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A20PacienteId = T000L12_A20PacienteId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      A21SGCitaDisponibilidadId = T000L12_A21SGCitaDisponibilidadId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(10) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(10);
   }

   public void gxload_12( int A20PacienteId )
   {
      /* Using cursor T000L13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
      }
      A103PacienteApellidoPaterno = T000L13_A103PacienteApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      A104PacienteApellidoMaterno = T000L13_A104PacienteApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      A105PacienteNombres = T000L13_A105PacienteNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A103PacienteApellidoPaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A104PacienteApellidoMaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A105PacienteNombres)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void gxload_13( int A21SGCitaDisponibilidadId )
   {
      /* Using cursor T000L14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
      }
      A72SGCitaDisponibilidadSedeId = T000L14_A72SGCitaDisponibilidadSedeId[0] ;
      A66SGCitaDisponibilidadFecha = T000L14_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000L14_n66SGCitaDisponibilidadFecha[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      A81SGCitaDisponibilidadProfesionalId = T000L14_A81SGCitaDisponibilidadProfesionalId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
      A70SGCitaDisponibilidadEspecialidadId = T000L14_A70SGCitaDisponibilidadEspecialidadId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(12) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(12);
   }

   public void gxload_16( short A72SGCitaDisponibilidadSedeId )
   {
      /* Using cursor T000L15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A76SGCitaDisponibilidadClinicaId = T000L15_A76SGCitaDisponibilidadClinicaId[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void gxload_17( short A76SGCitaDisponibilidadClinicaId )
   {
      /* Using cursor T000L16 */
      pr_default.execute(14, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = T000L16_A78SGCitaDisponibilidadClinicaNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A78SGCitaDisponibilidadClinicaNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(14) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(14);
   }

   public void gxload_14( int A81SGCitaDisponibilidadProfesionalId )
   {
      /* Using cursor T000L17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A84ProfesionalNombres = T000L17_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = T000L17_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = T000L17_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = T000L17_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = T000L17_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = T000L17_n86ProfesionalApellidoMaterno[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A84ProfesionalNombres)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A85ProfesionalApellidoPaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A86ProfesionalApellidoMaterno)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(15) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(15);
   }

   public void gxload_15( short A70SGCitaDisponibilidadEspecialidadId )
   {
      /* Using cursor T000L18 */
      pr_default.execute(16, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = T000L18_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A146SGCitaDisponibilidadEspecialidadNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(16) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(16);
   }

   public void getKey0L29( )
   {
      /* Using cursor T000L19 */
      pr_default.execute(17, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound29 = (short)(1) ;
      }
      else
      {
         RcdFound29 = (short)(0) ;
      }
      pr_default.close(17);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000L3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0L29( 10) ;
         RcdFound29 = (short)(1) ;
         A37EncuestaId = T000L3_A37EncuestaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
         A148EncuestaAtencion = T000L3_A148EncuestaAtencion[0] ;
         n148EncuestaAtencion = T000L3_n148EncuestaAtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A148EncuestaAtencion", A148EncuestaAtencion);
         A149EncuestaAtendido = T000L3_A149EncuestaAtendido[0] ;
         n149EncuestaAtendido = T000L3_n149EncuestaAtendido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A149EncuestaAtendido", A149EncuestaAtendido);
         A150EncuestaHoraAtencion = T000L3_A150EncuestaHoraAtencion[0] ;
         n150EncuestaHoraAtencion = T000L3_n150EncuestaHoraAtencion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
         A151EncuestaComentarios = T000L3_A151EncuestaComentarios[0] ;
         n151EncuestaComentarios = T000L3_n151EncuestaComentarios[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A151EncuestaComentarios", A151EncuestaComentarios);
         A152EncuestaRecomendacion = T000L3_A152EncuestaRecomendacion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A152EncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), 2, 0));
         A153EncuestaEstado = T000L3_A153EncuestaEstado[0] ;
         n153EncuestaEstado = T000L3_n153EncuestaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A153EncuestaEstado", A153EncuestaEstado);
         A19CitaId = T000L3_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         Z37EncuestaId = A37EncuestaId ;
         sMode29 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0L29( ) ;
         if ( AnyError == 1 )
         {
            RcdFound29 = (short)(0) ;
            initializeNonKey0L29( ) ;
         }
         Gx_mode = sMode29 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound29 = (short)(0) ;
         initializeNonKey0L29( ) ;
         sMode29 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode29 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0L29( ) ;
      if ( RcdFound29 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound29 = (short)(0) ;
      /* Using cursor T000L20 */
      pr_default.execute(18, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         while ( (pr_default.getStatus(18) != 101) && ( ( T000L20_A37EncuestaId[0] < A37EncuestaId ) ) )
         {
            pr_default.readNext(18);
         }
         if ( (pr_default.getStatus(18) != 101) && ( ( T000L20_A37EncuestaId[0] > A37EncuestaId ) ) )
         {
            A37EncuestaId = T000L20_A37EncuestaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
            RcdFound29 = (short)(1) ;
         }
      }
      pr_default.close(18);
   }

   public void move_previous( )
   {
      RcdFound29 = (short)(0) ;
      /* Using cursor T000L21 */
      pr_default.execute(19, new Object[] {Short.valueOf(A37EncuestaId)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         while ( (pr_default.getStatus(19) != 101) && ( ( T000L21_A37EncuestaId[0] > A37EncuestaId ) ) )
         {
            pr_default.readNext(19);
         }
         if ( (pr_default.getStatus(19) != 101) && ( ( T000L21_A37EncuestaId[0] < A37EncuestaId ) ) )
         {
            A37EncuestaId = T000L21_A37EncuestaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
            RcdFound29 = (short)(1) ;
         }
      }
      pr_default.close(19);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0L29( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0L29( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound29 == 1 )
         {
            if ( A37EncuestaId != Z37EncuestaId )
            {
               A37EncuestaId = Z37EncuestaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "ENCUESTAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEncuestaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0L29( ) ;
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A37EncuestaId != Z37EncuestaId )
            {
               /* Insert record */
               GX_FocusControl = edtCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0L29( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "ENCUESTAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEncuestaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCitaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0L29( ) ;
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
      if ( A37EncuestaId != Z37EncuestaId )
      {
         A37EncuestaId = Z37EncuestaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "ENCUESTAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEncuestaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0L29( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000L2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A37EncuestaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Encuesta"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z148EncuestaAtencion, T000L2_A148EncuestaAtencion[0]) != 0 ) || ( GXutil.strcmp(Z149EncuestaAtendido, T000L2_A149EncuestaAtendido[0]) != 0 ) || !( GXutil.dateCompare(Z150EncuestaHoraAtencion, T000L2_A150EncuestaHoraAtencion[0]) ) || ( Z152EncuestaRecomendacion != T000L2_A152EncuestaRecomendacion[0] ) || ( GXutil.strcmp(Z153EncuestaEstado, T000L2_A153EncuestaEstado[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z19CitaId != T000L2_A19CitaId[0] ) )
         {
            if ( GXutil.strcmp(Z148EncuestaAtencion, T000L2_A148EncuestaAtencion[0]) != 0 )
            {
               GXutil.writeLogln("encuesta:[seudo value changed for attri]"+"EncuestaAtencion");
               GXutil.writeLogRaw("Old: ",Z148EncuestaAtencion);
               GXutil.writeLogRaw("Current: ",T000L2_A148EncuestaAtencion[0]);
            }
            if ( GXutil.strcmp(Z149EncuestaAtendido, T000L2_A149EncuestaAtendido[0]) != 0 )
            {
               GXutil.writeLogln("encuesta:[seudo value changed for attri]"+"EncuestaAtendido");
               GXutil.writeLogRaw("Old: ",Z149EncuestaAtendido);
               GXutil.writeLogRaw("Current: ",T000L2_A149EncuestaAtendido[0]);
            }
            if ( !( GXutil.dateCompare(Z150EncuestaHoraAtencion, T000L2_A150EncuestaHoraAtencion[0]) ) )
            {
               GXutil.writeLogln("encuesta:[seudo value changed for attri]"+"EncuestaHoraAtencion");
               GXutil.writeLogRaw("Old: ",Z150EncuestaHoraAtencion);
               GXutil.writeLogRaw("Current: ",T000L2_A150EncuestaHoraAtencion[0]);
            }
            if ( Z152EncuestaRecomendacion != T000L2_A152EncuestaRecomendacion[0] )
            {
               GXutil.writeLogln("encuesta:[seudo value changed for attri]"+"EncuestaRecomendacion");
               GXutil.writeLogRaw("Old: ",Z152EncuestaRecomendacion);
               GXutil.writeLogRaw("Current: ",T000L2_A152EncuestaRecomendacion[0]);
            }
            if ( GXutil.strcmp(Z153EncuestaEstado, T000L2_A153EncuestaEstado[0]) != 0 )
            {
               GXutil.writeLogln("encuesta:[seudo value changed for attri]"+"EncuestaEstado");
               GXutil.writeLogRaw("Old: ",Z153EncuestaEstado);
               GXutil.writeLogRaw("Current: ",T000L2_A153EncuestaEstado[0]);
            }
            if ( Z19CitaId != T000L2_A19CitaId[0] )
            {
               GXutil.writeLogln("encuesta:[seudo value changed for attri]"+"CitaId");
               GXutil.writeLogRaw("Old: ",Z19CitaId);
               GXutil.writeLogRaw("Current: ",T000L2_A19CitaId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Encuesta"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0L29( )
   {
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0L29( 0) ;
         checkOptimisticConcurrency0L29( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0L29( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0L29( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000L22 */
                  pr_default.execute(20, new Object[] {Boolean.valueOf(n148EncuestaAtencion), A148EncuestaAtencion, Boolean.valueOf(n149EncuestaAtendido), A149EncuestaAtendido, Boolean.valueOf(n150EncuestaHoraAtencion), A150EncuestaHoraAtencion, Boolean.valueOf(n151EncuestaComentarios), A151EncuestaComentarios, Byte.valueOf(A152EncuestaRecomendacion), Boolean.valueOf(n153EncuestaEstado), A153EncuestaEstado, Integer.valueOf(A19CitaId)});
                  A37EncuestaId = T000L22_A37EncuestaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Encuesta");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0L0( ) ;
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
            load0L29( ) ;
         }
         endLevel0L29( ) ;
      }
      closeExtendedTableCursors0L29( ) ;
   }

   public void update0L29( )
   {
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0L29( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0L29( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0L29( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000L23 */
                  pr_default.execute(21, new Object[] {Boolean.valueOf(n148EncuestaAtencion), A148EncuestaAtencion, Boolean.valueOf(n149EncuestaAtendido), A149EncuestaAtendido, Boolean.valueOf(n150EncuestaHoraAtencion), A150EncuestaHoraAtencion, Boolean.valueOf(n151EncuestaComentarios), A151EncuestaComentarios, Byte.valueOf(A152EncuestaRecomendacion), Boolean.valueOf(n153EncuestaEstado), A153EncuestaEstado, Integer.valueOf(A19CitaId), Short.valueOf(A37EncuestaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Encuesta");
                  if ( (pr_default.getStatus(21) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Encuesta"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0L29( ) ;
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
         endLevel0L29( ) ;
      }
      closeExtendedTableCursors0L29( ) ;
   }

   public void deferredUpdate0L29( )
   {
   }

   public void delete( )
   {
      beforeValidate0L29( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0L29( ) ;
         afterConfirm0L29( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0L29( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000L24 */
               pr_default.execute(22, new Object[] {Short.valueOf(A37EncuestaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Encuesta");
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
      sMode29 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0L29( ) ;
      Gx_mode = sMode29 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0L29( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "Encuesta" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22Pgmname", AV22Pgmname);
         /* Using cursor T000L25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A19CitaId)});
         A20PacienteId = T000L25_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A21SGCitaDisponibilidadId = T000L25_A21SGCitaDisponibilidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
         pr_default.close(23);
         /* Using cursor T000L26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A20PacienteId)});
         A103PacienteApellidoPaterno = T000L26_A103PacienteApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
         A104PacienteApellidoMaterno = T000L26_A104PacienteApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
         A105PacienteNombres = T000L26_A105PacienteNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
         pr_default.close(24);
         /* Using cursor T000L27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
         A72SGCitaDisponibilidadSedeId = T000L27_A72SGCitaDisponibilidadSedeId[0] ;
         A66SGCitaDisponibilidadFecha = T000L27_A66SGCitaDisponibilidadFecha[0] ;
         n66SGCitaDisponibilidadFecha = T000L27_n66SGCitaDisponibilidadFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
         A81SGCitaDisponibilidadProfesionalId = T000L27_A81SGCitaDisponibilidadProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
         A70SGCitaDisponibilidadEspecialidadId = T000L27_A70SGCitaDisponibilidadEspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
         pr_default.close(25);
         /* Using cursor T000L28 */
         pr_default.execute(26, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
         A76SGCitaDisponibilidadClinicaId = T000L28_A76SGCitaDisponibilidadClinicaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
         pr_default.close(26);
         /* Using cursor T000L29 */
         pr_default.execute(27, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
         A78SGCitaDisponibilidadClinicaNombre = T000L29_A78SGCitaDisponibilidadClinicaNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
         pr_default.close(27);
         /* Using cursor T000L30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
         A84ProfesionalNombres = T000L30_A84ProfesionalNombres[0] ;
         n84ProfesionalNombres = T000L30_n84ProfesionalNombres[0] ;
         A85ProfesionalApellidoPaterno = T000L30_A85ProfesionalApellidoPaterno[0] ;
         n85ProfesionalApellidoPaterno = T000L30_n85ProfesionalApellidoPaterno[0] ;
         A86ProfesionalApellidoMaterno = T000L30_A86ProfesionalApellidoMaterno[0] ;
         n86ProfesionalApellidoMaterno = T000L30_n86ProfesionalApellidoMaterno[0] ;
         pr_default.close(28);
         A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
         httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
         /* Using cursor T000L31 */
         pr_default.execute(29, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
         A146SGCitaDisponibilidadEspecialidadNombre = T000L31_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
         pr_default.close(29);
      }
   }

   public void endLevel0L29( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0L29( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(23);
         pr_default.close(24);
         pr_default.close(25);
         pr_default.close(28);
         pr_default.close(29);
         pr_default.close(26);
         pr_default.close(27);
         Application.commitDataStores(context, remoteHandle, pr_default, "encuesta");
         if ( AnyError == 0 )
         {
            confirmValues0L0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(23);
         pr_default.close(24);
         pr_default.close(25);
         pr_default.close(28);
         pr_default.close(29);
         pr_default.close(26);
         pr_default.close(27);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "encuesta");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0L29( )
   {
      /* Scan By routine */
      /* Using cursor T000L32 */
      pr_default.execute(30);
      RcdFound29 = (short)(0) ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A37EncuestaId = T000L32_A37EncuestaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0L29( )
   {
      /* Scan next routine */
      pr_default.readNext(30);
      RcdFound29 = (short)(0) ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound29 = (short)(1) ;
         A37EncuestaId = T000L32_A37EncuestaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
      }
   }

   public void scanEnd0L29( )
   {
      pr_default.close(30);
   }

   public void afterConfirm0L29( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0L29( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0L29( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0L29( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0L29( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0L29( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0L29( )
   {
      edtEncuestaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaId_Enabled), 5, 0), true);
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProfesionalId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadProFullName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadProFullName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadProFullName_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadEspecialidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadEspecialidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadEspecialidadNombre_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadFecha_Enabled), 5, 0), true);
      edtPacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      edtPacienteApellidoPaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoPaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoPaterno_Enabled), 5, 0), true);
      edtPacienteApellidoMaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteApellidoMaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteApellidoMaterno_Enabled), 5, 0), true);
      edtPacienteNombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteNombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteNombres_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadClinicaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaId_Enabled), 5, 0), true);
      edtSGCitaDisponibilidadClinicaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGCitaDisponibilidadClinicaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGCitaDisponibilidadClinicaNombre_Enabled), 5, 0), true);
      cmbEncuestaAtencion.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtencion.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEncuestaAtencion.getEnabled(), 5, 0), true);
      cmbEncuestaAtendido.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaAtendido.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEncuestaAtendido.getEnabled(), 5, 0), true);
      edtEncuestaHoraAtencion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaHoraAtencion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaHoraAtencion_Enabled), 5, 0), true);
      edtEncuestaComentarios_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaComentarios_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaComentarios_Enabled), 5, 0), true);
      edtEncuestaRecomendacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEncuestaRecomendacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEncuestaRecomendacion_Enabled), 5, 0), true);
      cmbEncuestaEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEncuestaEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEncuestaEstado.getEnabled(), 5, 0), true);
      edtavCombocitaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCombocitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCombocitaid_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0L29( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0L0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110324949", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.encuesta", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20EncuestaId,4,0))}, new String[] {"Gx_mode","EncuestaId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Encuesta");
      forbiddenHiddens.add("EncuestaId", localUtil.format( DecimalUtil.doubleToDec(A37EncuestaId), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("encuesta:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z37EncuestaId", GXutil.ltrim( localUtil.ntoc( Z37EncuestaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z148EncuestaAtencion", GXutil.rtrim( Z148EncuestaAtencion));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z149EncuestaAtendido", GXutil.rtrim( Z149EncuestaAtendido));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z150EncuestaHoraAtencion", localUtil.ttoc( Z150EncuestaHoraAtencion, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z152EncuestaRecomendacion", GXutil.ltrim( localUtil.ntoc( Z152EncuestaRecomendacion, (byte)(2), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z153EncuestaEstado", GXutil.rtrim( Z153EncuestaEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N19CitaId", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV15DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITAID_DATA", AV14CitaId_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITAID_DATA", AV14CitaId_Data);
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALNOMBRES", A84ProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALAPELLIDOPATERNO", A85ProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALAPELLIDOMATERNO", A86ProfesionalApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vENCUESTAID", GXutil.ltrim( localUtil.ntoc( AV20EncuestaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vENCUESTAID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV20EncuestaId), "ZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CITAID", GXutil.ltrim( localUtil.ntoc( AV12Insert_CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGCITADISPONIBILIDADSEDEID", GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV22Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Objectcall", GXutil.rtrim( Combo_citaid_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Cls", GXutil.rtrim( Combo_citaid_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Selectedvalue_set", GXutil.rtrim( Combo_citaid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Selectedtext_set", GXutil.rtrim( Combo_citaid_Selectedtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Enabled", GXutil.booltostr( Combo_citaid_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistproc", GXutil.rtrim( Combo_citaid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Datalistprocparametersprefix", GXutil.rtrim( Combo_citaid_Datalistprocparametersprefix));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COMBO_CITAID_Emptyitem", GXutil.booltostr( Combo_citaid_Emptyitem));
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
      return formatLink("com.projectthani.encuesta", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV20EncuestaId,4,0))}, new String[] {"Gx_mode","EncuestaId"})  ;
   }

   public String getPgmname( )
   {
      return "Encuesta" ;
   }

   public String getPgmdesc( )
   {
      return "Encuesta" ;
   }

   public void initializeNonKey0L29( )
   {
      A72SGCitaDisponibilidadSedeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A72SGCitaDisponibilidadSedeId), 4, 0));
      A19CitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      A81SGCitaDisponibilidadProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A81SGCitaDisponibilidadProfesionalId), 8, 0));
      A82SGCitaDisponibilidadProFullName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
      A70SGCitaDisponibilidadEspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A70SGCitaDisponibilidadEspecialidadId), 4, 0));
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
      A21SGCitaDisponibilidadId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A21SGCitaDisponibilidadId), 8, 0));
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      n66SGCitaDisponibilidadFecha = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      A20PacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      A103PacienteApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      A104PacienteApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      A105PacienteNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      A76SGCitaDisponibilidadClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A76SGCitaDisponibilidadClinicaId), 4, 0));
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
      A148EncuestaAtencion = "" ;
      n148EncuestaAtencion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A148EncuestaAtencion", A148EncuestaAtencion);
      n148EncuestaAtencion = ((GXutil.strcmp("", A148EncuestaAtencion)==0) ? true : false) ;
      A149EncuestaAtendido = "" ;
      n149EncuestaAtendido = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A149EncuestaAtendido", A149EncuestaAtendido);
      n149EncuestaAtendido = ((GXutil.strcmp("", A149EncuestaAtendido)==0) ? true : false) ;
      A151EncuestaComentarios = "" ;
      n151EncuestaComentarios = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A151EncuestaComentarios", A151EncuestaComentarios);
      n151EncuestaComentarios = ((GXutil.strcmp("", A151EncuestaComentarios)==0) ? true : false) ;
      A152EncuestaRecomendacion = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A152EncuestaRecomendacion", GXutil.ltrimstr( DecimalUtil.doubleToDec(A152EncuestaRecomendacion), 2, 0));
      A153EncuestaEstado = "" ;
      n153EncuestaEstado = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A153EncuestaEstado", A153EncuestaEstado);
      n153EncuestaEstado = ((GXutil.strcmp("", A153EncuestaEstado)==0) ? true : false) ;
      A84ProfesionalNombres = "" ;
      n84ProfesionalNombres = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      A85ProfesionalApellidoPaterno = "" ;
      n85ProfesionalApellidoPaterno = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      A86ProfesionalApellidoMaterno = "" ;
      n86ProfesionalApellidoMaterno = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      A150EncuestaHoraAtencion = GXutil.resetDate(GXutil.now( )) ;
      n150EncuestaHoraAtencion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
      Z148EncuestaAtencion = "" ;
      Z149EncuestaAtendido = "" ;
      Z150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      Z152EncuestaRecomendacion = (byte)(0) ;
      Z153EncuestaEstado = "" ;
      Z19CitaId = 0 ;
   }

   public void initAll0L29( )
   {
      A37EncuestaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A37EncuestaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A37EncuestaId), 4, 0));
      initializeNonKey0L29( ) ;
   }

   public void standaloneModalInsert( )
   {
      A150EncuestaHoraAtencion = i150EncuestaHoraAtencion ;
      n150EncuestaHoraAtencion = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A150EncuestaHoraAtencion", localUtil.ttoc( A150EncuestaHoraAtencion, 0, 5, 0, 3, "/", ":", " "));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110324978", true, true);
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
      httpContext.AddJavascriptSource("encuesta.js", "?20225110324978", false, true);
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
      edtEncuestaId_Internalname = "ENCUESTAID" ;
      lblTextblockcitaid_Internalname = "TEXTBLOCKCITAID" ;
      Combo_citaid_Internalname = "COMBO_CITAID" ;
      edtCitaId_Internalname = "CITAID" ;
      divTablesplittedcitaid_Internalname = "TABLESPLITTEDCITAID" ;
      edtSGCitaDisponibilidadProfesionalId_Internalname = "SGCITADISPONIBILIDADPROFESIONALID" ;
      edtSGCitaDisponibilidadProFullName_Internalname = "SGCITADISPONIBILIDADPROFULLNAME" ;
      edtSGCitaDisponibilidadEspecialidadId_Internalname = "SGCITADISPONIBILIDADESPECIALIDADID" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtSGCitaDisponibilidadId_Internalname = "SGCITADISPONIBILIDADID" ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA" ;
      edtPacienteId_Internalname = "PACIENTEID" ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES" ;
      edtSGCitaDisponibilidadClinicaId_Internalname = "SGCITADISPONIBILIDADCLINICAID" ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE" ;
      cmbEncuestaAtencion.setInternalname( "ENCUESTAATENCION" );
      cmbEncuestaAtendido.setInternalname( "ENCUESTAATENDIDO" );
      edtEncuestaHoraAtencion_Internalname = "ENCUESTAHORAATENCION" ;
      edtEncuestaComentarios_Internalname = "ENCUESTACOMENTARIOS" ;
      edtEncuestaRecomendacion_Internalname = "ENCUESTARECOMENDACION" ;
      cmbEncuestaEstado.setInternalname( "ENCUESTAESTADO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavCombocitaid_Internalname = "vCOMBOCITAID" ;
      divSectionattribute_citaid_Internalname = "SECTIONATTRIBUTE_CITAID" ;
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
      Form.setCaption( "Encuesta" );
      edtavCombocitaid_Jsonclick = "" ;
      edtavCombocitaid_Enabled = 0 ;
      edtavCombocitaid_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbEncuestaEstado.setJsonclick( "" );
      cmbEncuestaEstado.setEnabled( 1 );
      edtEncuestaRecomendacion_Jsonclick = "" ;
      edtEncuestaRecomendacion_Enabled = 1 ;
      edtEncuestaComentarios_Enabled = 1 ;
      edtEncuestaHoraAtencion_Jsonclick = "" ;
      edtEncuestaHoraAtencion_Enabled = 1 ;
      cmbEncuestaAtendido.setJsonclick( "" );
      cmbEncuestaAtendido.setEnabled( 1 );
      cmbEncuestaAtencion.setJsonclick( "" );
      cmbEncuestaAtencion.setEnabled( 1 );
      edtSGCitaDisponibilidadClinicaNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadClinicaId_Jsonclick = "" ;
      edtSGCitaDisponibilidadClinicaId_Enabled = 0 ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteNombres_Enabled = 0 ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Enabled = 0 ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Enabled = 0 ;
      edtPacienteId_Jsonclick = "" ;
      edtPacienteId_Enabled = 0 ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Enabled = 0 ;
      edtSGCitaDisponibilidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadId_Enabled = 0 ;
      edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Enabled = 0 ;
      edtSGCitaDisponibilidadEspecialidadId_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadId_Enabled = 0 ;
      edtSGCitaDisponibilidadProFullName_Jsonclick = "" ;
      edtSGCitaDisponibilidadProFullName_Enabled = 0 ;
      edtSGCitaDisponibilidadProfesionalId_Jsonclick = "" ;
      edtSGCitaDisponibilidadProfesionalId_Enabled = 0 ;
      edtCitaId_Jsonclick = "" ;
      edtCitaId_Enabled = 1 ;
      edtCitaId_Visible = 1 ;
      Combo_citaid_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_citaid_Datalistprocparametersprefix = " \"ComboName\": \"CitaId\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"EncuestaId\": 0" ;
      Combo_citaid_Datalistproc = "EncuestaLoadDVCombo" ;
      Combo_citaid_Cls = "ExtendedCombo Attribute" ;
      Combo_citaid_Caption = "" ;
      Combo_citaid_Enabled = GXutil.toBoolean( -1) ;
      edtEncuestaId_Jsonclick = "" ;
      edtEncuestaId_Enabled = 0 ;
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
      cmbEncuestaAtencion.setName( "ENCUESTAATENCION" );
      cmbEncuestaAtencion.setWebtags( "" );
      cmbEncuestaAtencion.addItem("B", "Buena", (short)(0));
      cmbEncuestaAtencion.addItem("R", "Regular", (short)(0));
      cmbEncuestaAtencion.addItem("M", "Mala", (short)(0));
      if ( cmbEncuestaAtencion.getItemCount() > 0 )
      {
         A148EncuestaAtencion = cmbEncuestaAtencion.getValidValue(A148EncuestaAtencion) ;
         n148EncuestaAtencion = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A148EncuestaAtencion", A148EncuestaAtencion);
      }
      cmbEncuestaAtendido.setName( "ENCUESTAATENDIDO" );
      cmbEncuestaAtendido.setWebtags( "" );
      cmbEncuestaAtendido.addItem("S", "Si", (short)(0));
      cmbEncuestaAtendido.addItem("N", "No", (short)(0));
      if ( cmbEncuestaAtendido.getItemCount() > 0 )
      {
         A149EncuestaAtendido = cmbEncuestaAtendido.getValidValue(A149EncuestaAtendido) ;
         n149EncuestaAtendido = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A149EncuestaAtendido", A149EncuestaAtendido);
      }
      cmbEncuestaEstado.setName( "ENCUESTAESTADO" );
      cmbEncuestaEstado.setWebtags( "" );
      cmbEncuestaEstado.addItem("P", "Pendiente", (short)(0));
      cmbEncuestaEstado.addItem("R", "Realizada", (short)(0));
      cmbEncuestaEstado.addItem("", "", (short)(0));
      if ( cmbEncuestaEstado.getItemCount() > 0 )
      {
         A153EncuestaEstado = cmbEncuestaEstado.getValidValue(A153EncuestaEstado) ;
         n153EncuestaEstado = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A153EncuestaEstado", A153EncuestaEstado);
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

   public void valid_Citaid( )
   {
      n84ProfesionalNombres = false ;
      n85ProfesionalApellidoPaterno = false ;
      n86ProfesionalApellidoMaterno = false ;
      n66SGCitaDisponibilidadFecha = false ;
      /* Using cursor T000L25 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
      }
      A20PacienteId = T000L25_A20PacienteId[0] ;
      A21SGCitaDisponibilidadId = T000L25_A21SGCitaDisponibilidadId[0] ;
      pr_default.close(23);
      /* Using cursor T000L26 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(24) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
      }
      A103PacienteApellidoPaterno = T000L26_A103PacienteApellidoPaterno[0] ;
      A104PacienteApellidoMaterno = T000L26_A104PacienteApellidoMaterno[0] ;
      A105PacienteNombres = T000L26_A105PacienteNombres[0] ;
      pr_default.close(24);
      /* Using cursor T000L27 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A21SGCitaDisponibilidadId)});
      if ( (pr_default.getStatus(25) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADID");
         AnyError = (short)(1) ;
      }
      A72SGCitaDisponibilidadSedeId = T000L27_A72SGCitaDisponibilidadSedeId[0] ;
      A66SGCitaDisponibilidadFecha = T000L27_A66SGCitaDisponibilidadFecha[0] ;
      n66SGCitaDisponibilidadFecha = T000L27_n66SGCitaDisponibilidadFecha[0] ;
      A81SGCitaDisponibilidadProfesionalId = T000L27_A81SGCitaDisponibilidadProfesionalId[0] ;
      A70SGCitaDisponibilidadEspecialidadId = T000L27_A70SGCitaDisponibilidadEspecialidadId[0] ;
      pr_default.close(25);
      /* Using cursor T000L28 */
      pr_default.execute(26, new Object[] {Short.valueOf(A72SGCitaDisponibilidadSedeId)});
      if ( (pr_default.getStatus(26) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADSEDEID");
         AnyError = (short)(1) ;
      }
      A76SGCitaDisponibilidadClinicaId = T000L28_A76SGCitaDisponibilidadClinicaId[0] ;
      pr_default.close(26);
      /* Using cursor T000L29 */
      pr_default.execute(27, new Object[] {Short.valueOf(A76SGCitaDisponibilidadClinicaId)});
      if ( (pr_default.getStatus(27) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADCLINICAID");
         AnyError = (short)(1) ;
      }
      A78SGCitaDisponibilidadClinicaNombre = T000L29_A78SGCitaDisponibilidadClinicaNombre[0] ;
      pr_default.close(27);
      /* Using cursor T000L30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A81SGCitaDisponibilidadProfesionalId)});
      if ( (pr_default.getStatus(28) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADPROFESIONALID");
         AnyError = (short)(1) ;
      }
      A84ProfesionalNombres = T000L30_A84ProfesionalNombres[0] ;
      n84ProfesionalNombres = T000L30_n84ProfesionalNombres[0] ;
      A85ProfesionalApellidoPaterno = T000L30_A85ProfesionalApellidoPaterno[0] ;
      n85ProfesionalApellidoPaterno = T000L30_n85ProfesionalApellidoPaterno[0] ;
      A86ProfesionalApellidoMaterno = T000L30_A86ProfesionalApellidoMaterno[0] ;
      n86ProfesionalApellidoMaterno = T000L30_n86ProfesionalApellidoMaterno[0] ;
      pr_default.close(28);
      A82SGCitaDisponibilidadProFullName = A84ProfesionalNombres + " " + A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno ;
      /* Using cursor T000L31 */
      pr_default.execute(29, new Object[] {Short.valueOf(A70SGCitaDisponibilidadEspecialidadId)});
      if ( (pr_default.getStatus(29) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGCita Disponibilidad'.", "ForeignKeyNotFound", 1, "SGCITADISPONIBILIDADESPECIALIDADID");
         AnyError = (short)(1) ;
      }
      A146SGCitaDisponibilidadEspecialidadNombre = T000L31_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
      pr_default.close(29);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A21SGCitaDisponibilidadId", GXutil.ltrim( localUtil.ntoc( A21SGCitaDisponibilidadId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A103PacienteApellidoPaterno", A103PacienteApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A104PacienteApellidoMaterno", A104PacienteApellidoMaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A105PacienteNombres", A105PacienteNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A72SGCitaDisponibilidadSedeId", GXutil.ltrim( localUtil.ntoc( A72SGCitaDisponibilidadSedeId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A66SGCitaDisponibilidadFecha", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A81SGCitaDisponibilidadProfesionalId", GXutil.ltrim( localUtil.ntoc( A81SGCitaDisponibilidadProfesionalId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A70SGCitaDisponibilidadEspecialidadId", GXutil.ltrim( localUtil.ntoc( A70SGCitaDisponibilidadEspecialidadId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A76SGCitaDisponibilidadClinicaId", GXutil.ltrim( localUtil.ntoc( A76SGCitaDisponibilidadClinicaId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A78SGCitaDisponibilidadClinicaNombre", A78SGCitaDisponibilidadClinicaNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A82SGCitaDisponibilidadProFullName", A82SGCitaDisponibilidadProFullName);
      httpContext.ajax_rsp_assign_attri("", false, "A146SGCitaDisponibilidadEspecialidadNombre", A146SGCitaDisponibilidadEspecialidadNombre);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV20EncuestaId',fld:'vENCUESTAID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV20EncuestaId',fld:'vENCUESTAID',pic:'ZZZ9',hsh:true},{av:'A37EncuestaId',fld:'ENCUESTAID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e120L2',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_ENCUESTAID","{handler:'valid_Encuestaid',iparms:[]");
      setEventMetadata("VALID_ENCUESTAID",",oparms:[]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'A21SGCitaDisponibilidadId',fld:'SGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A72SGCitaDisponibilidadSedeId',fld:'SGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'A76SGCitaDisponibilidadClinicaId',fld:'SGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'A81SGCitaDisponibilidadProfesionalId',fld:'SGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A84ProfesionalNombres',fld:'PROFESIONALNOMBRES',pic:''},{av:'A85ProfesionalApellidoPaterno',fld:'PROFESIONALAPELLIDOPATERNO',pic:''},{av:'A86ProfesionalApellidoMaterno',fld:'PROFESIONALAPELLIDOMATERNO',pic:''},{av:'A70SGCitaDisponibilidadEspecialidadId',fld:'SGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'A103PacienteApellidoPaterno',fld:'PACIENTEAPELLIDOPATERNO',pic:''},{av:'A104PacienteApellidoMaterno',fld:'PACIENTEAPELLIDOMATERNO',pic:''},{av:'A105PacienteNombres',fld:'PACIENTENOMBRES',pic:''},{av:'A66SGCitaDisponibilidadFecha',fld:'SGCITADISPONIBILIDADFECHA',pic:''},{av:'A78SGCitaDisponibilidadClinicaNombre',fld:'SGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'A82SGCitaDisponibilidadProFullName',fld:'SGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'A146SGCitaDisponibilidadEspecialidadNombre',fld:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''}]");
      setEventMetadata("VALID_CITAID",",oparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'A21SGCitaDisponibilidadId',fld:'SGCITADISPONIBILIDADID',pic:'ZZZZZZZ9'},{av:'A103PacienteApellidoPaterno',fld:'PACIENTEAPELLIDOPATERNO',pic:''},{av:'A104PacienteApellidoMaterno',fld:'PACIENTEAPELLIDOMATERNO',pic:''},{av:'A105PacienteNombres',fld:'PACIENTENOMBRES',pic:''},{av:'A72SGCitaDisponibilidadSedeId',fld:'SGCITADISPONIBILIDADSEDEID',pic:'ZZZ9'},{av:'A66SGCitaDisponibilidadFecha',fld:'SGCITADISPONIBILIDADFECHA',pic:''},{av:'A81SGCitaDisponibilidadProfesionalId',fld:'SGCITADISPONIBILIDADPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A70SGCitaDisponibilidadEspecialidadId',fld:'SGCITADISPONIBILIDADESPECIALIDADID',pic:'ZZZ9'},{av:'A76SGCitaDisponibilidadClinicaId',fld:'SGCITADISPONIBILIDADCLINICAID',pic:'ZZZ9'},{av:'A78SGCitaDisponibilidadClinicaNombre',fld:'SGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'A84ProfesionalNombres',fld:'PROFESIONALNOMBRES',pic:''},{av:'A85ProfesionalApellidoPaterno',fld:'PROFESIONALAPELLIDOPATERNO',pic:''},{av:'A86ProfesionalApellidoMaterno',fld:'PROFESIONALAPELLIDOMATERNO',pic:''},{av:'A82SGCitaDisponibilidadProFullName',fld:'SGCITADISPONIBILIDADPROFULLNAME',pic:''},{av:'A146SGCitaDisponibilidadEspecialidadNombre',fld:'SGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''}]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID","{handler:'valid_Sgcitadisponibilidadprofesionalid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADPROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID","{handler:'valid_Sgcitadisponibilidadespecialidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADESPECIALIDADID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID","{handler:'valid_Sgcitadisponibilidadid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADID",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID","{handler:'valid_Sgcitadisponibilidadclinicaid',iparms:[]");
      setEventMetadata("VALID_SGCITADISPONIBILIDADCLINICAID",",oparms:[]}");
      setEventMetadata("VALIDV_COMBOCITAID","{handler:'validv_Combocitaid',iparms:[]");
      setEventMetadata("VALIDV_COMBOCITAID",",oparms:[]}");
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
      pr_default.close(25);
      pr_default.close(28);
      pr_default.close(29);
      pr_default.close(26);
      pr_default.close(27);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z148EncuestaAtencion = "" ;
      Z149EncuestaAtendido = "" ;
      Z150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      Z153EncuestaEstado = "" ;
      Combo_citaid_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A148EncuestaAtencion = "" ;
      A149EncuestaAtendido = "" ;
      A153EncuestaEstado = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      lblTextblockcitaid_Jsonclick = "" ;
      ucCombo_citaid = new com.genexus.webpanels.GXUserControl();
      AV15DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV14CitaId_Data = new GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item>(com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      TempTags = "" ;
      A82SGCitaDisponibilidadProFullName = "" ;
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      A151EncuestaComentarios = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A84ProfesionalNombres = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      AV22Pgmname = "" ;
      Combo_citaid_Objectcall = "" ;
      Combo_citaid_Class = "" ;
      Combo_citaid_Icontype = "" ;
      Combo_citaid_Icon = "" ;
      Combo_citaid_Tooltip = "" ;
      Combo_citaid_Selectedvalue_set = "" ;
      Combo_citaid_Selectedtext_set = "" ;
      Combo_citaid_Selectedtext_get = "" ;
      Combo_citaid_Gamoauthtoken = "" ;
      Combo_citaid_Ddointernalname = "" ;
      Combo_citaid_Titlecontrolalign = "" ;
      Combo_citaid_Dropdownoptionstype = "" ;
      Combo_citaid_Titlecontrolidtoreplace = "" ;
      Combo_citaid_Datalisttype = "" ;
      Combo_citaid_Datalistfixedvalues = "" ;
      Combo_citaid_Htmltemplate = "" ;
      Combo_citaid_Multiplevaluestype = "" ;
      Combo_citaid_Loadingdata = "" ;
      Combo_citaid_Noresultsfound = "" ;
      Combo_citaid_Emptyitemtext = "" ;
      Combo_citaid_Onlyselectedvalues = "" ;
      Combo_citaid_Selectalltext = "" ;
      Combo_citaid_Multiplevaluesseparator = "" ;
      Combo_citaid_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode29 = "" ;
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
      AV18Combo_DataJson = "" ;
      AV16ComboSelectedValue = "" ;
      AV17ComboSelectedText = "" ;
      GXt_char6 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      Z151EncuestaComentarios = "" ;
      Z103PacienteApellidoPaterno = "" ;
      Z104PacienteApellidoMaterno = "" ;
      Z105PacienteNombres = "" ;
      Z66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      Z78SGCitaDisponibilidadClinicaNombre = "" ;
      Z84ProfesionalNombres = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      Z146SGCitaDisponibilidadEspecialidadNombre = "" ;
      T000L4_A20PacienteId = new int[1] ;
      T000L4_A21SGCitaDisponibilidadId = new int[1] ;
      T000L5_A103PacienteApellidoPaterno = new String[] {""} ;
      T000L5_A104PacienteApellidoMaterno = new String[] {""} ;
      T000L5_A105PacienteNombres = new String[] {""} ;
      T000L6_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000L6_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000L6_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000L6_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000L6_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000L9_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000L10_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000L7_A84ProfesionalNombres = new String[] {""} ;
      T000L7_n84ProfesionalNombres = new boolean[] {false} ;
      T000L7_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000L7_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000L7_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000L7_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000L8_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000L11_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000L11_A37EncuestaId = new short[1] ;
      T000L11_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000L11_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000L11_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000L11_A103PacienteApellidoPaterno = new String[] {""} ;
      T000L11_A104PacienteApellidoMaterno = new String[] {""} ;
      T000L11_A105PacienteNombres = new String[] {""} ;
      T000L11_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000L11_A148EncuestaAtencion = new String[] {""} ;
      T000L11_n148EncuestaAtencion = new boolean[] {false} ;
      T000L11_A149EncuestaAtendido = new String[] {""} ;
      T000L11_n149EncuestaAtendido = new boolean[] {false} ;
      T000L11_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      T000L11_n150EncuestaHoraAtencion = new boolean[] {false} ;
      T000L11_A151EncuestaComentarios = new String[] {""} ;
      T000L11_n151EncuestaComentarios = new boolean[] {false} ;
      T000L11_A152EncuestaRecomendacion = new byte[1] ;
      T000L11_A153EncuestaEstado = new String[] {""} ;
      T000L11_n153EncuestaEstado = new boolean[] {false} ;
      T000L11_A84ProfesionalNombres = new String[] {""} ;
      T000L11_n84ProfesionalNombres = new boolean[] {false} ;
      T000L11_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000L11_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000L11_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000L11_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000L11_A19CitaId = new int[1] ;
      T000L11_A20PacienteId = new int[1] ;
      T000L11_A21SGCitaDisponibilidadId = new int[1] ;
      T000L11_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000L11_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000L11_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000L12_A20PacienteId = new int[1] ;
      T000L12_A21SGCitaDisponibilidadId = new int[1] ;
      T000L13_A103PacienteApellidoPaterno = new String[] {""} ;
      T000L13_A104PacienteApellidoMaterno = new String[] {""} ;
      T000L13_A105PacienteNombres = new String[] {""} ;
      T000L14_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000L14_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000L14_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000L14_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000L14_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000L15_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000L16_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000L17_A84ProfesionalNombres = new String[] {""} ;
      T000L17_n84ProfesionalNombres = new boolean[] {false} ;
      T000L17_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000L17_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000L17_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000L17_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000L18_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000L19_A37EncuestaId = new short[1] ;
      T000L3_A37EncuestaId = new short[1] ;
      T000L3_A148EncuestaAtencion = new String[] {""} ;
      T000L3_n148EncuestaAtencion = new boolean[] {false} ;
      T000L3_A149EncuestaAtendido = new String[] {""} ;
      T000L3_n149EncuestaAtendido = new boolean[] {false} ;
      T000L3_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      T000L3_n150EncuestaHoraAtencion = new boolean[] {false} ;
      T000L3_A151EncuestaComentarios = new String[] {""} ;
      T000L3_n151EncuestaComentarios = new boolean[] {false} ;
      T000L3_A152EncuestaRecomendacion = new byte[1] ;
      T000L3_A153EncuestaEstado = new String[] {""} ;
      T000L3_n153EncuestaEstado = new boolean[] {false} ;
      T000L3_A19CitaId = new int[1] ;
      T000L20_A37EncuestaId = new short[1] ;
      T000L21_A37EncuestaId = new short[1] ;
      T000L2_A37EncuestaId = new short[1] ;
      T000L2_A148EncuestaAtencion = new String[] {""} ;
      T000L2_n148EncuestaAtencion = new boolean[] {false} ;
      T000L2_A149EncuestaAtendido = new String[] {""} ;
      T000L2_n149EncuestaAtendido = new boolean[] {false} ;
      T000L2_A150EncuestaHoraAtencion = new java.util.Date[] {GXutil.nullDate()} ;
      T000L2_n150EncuestaHoraAtencion = new boolean[] {false} ;
      T000L2_A151EncuestaComentarios = new String[] {""} ;
      T000L2_n151EncuestaComentarios = new boolean[] {false} ;
      T000L2_A152EncuestaRecomendacion = new byte[1] ;
      T000L2_A153EncuestaEstado = new String[] {""} ;
      T000L2_n153EncuestaEstado = new boolean[] {false} ;
      T000L2_A19CitaId = new int[1] ;
      T000L22_A37EncuestaId = new short[1] ;
      T000L25_A20PacienteId = new int[1] ;
      T000L25_A21SGCitaDisponibilidadId = new int[1] ;
      T000L26_A103PacienteApellidoPaterno = new String[] {""} ;
      T000L26_A104PacienteApellidoMaterno = new String[] {""} ;
      T000L26_A105PacienteNombres = new String[] {""} ;
      T000L27_A72SGCitaDisponibilidadSedeId = new short[1] ;
      T000L27_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000L27_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      T000L27_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      T000L27_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      T000L28_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      T000L29_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      T000L30_A84ProfesionalNombres = new String[] {""} ;
      T000L30_n84ProfesionalNombres = new boolean[] {false} ;
      T000L30_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000L30_n85ProfesionalApellidoPaterno = new boolean[] {false} ;
      T000L30_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000L30_n86ProfesionalApellidoMaterno = new boolean[] {false} ;
      T000L31_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      T000L32_A37EncuestaId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i150EncuestaHoraAtencion = GXutil.resetTime( GXutil.nullDate() );
      Z82SGCitaDisponibilidadProFullName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.encuesta__default(),
         new Object[] {
             new Object[] {
            T000L2_A37EncuestaId, T000L2_A148EncuestaAtencion, T000L2_n148EncuestaAtencion, T000L2_A149EncuestaAtendido, T000L2_n149EncuestaAtendido, T000L2_A150EncuestaHoraAtencion, T000L2_n150EncuestaHoraAtencion, T000L2_A151EncuestaComentarios, T000L2_n151EncuestaComentarios, T000L2_A152EncuestaRecomendacion,
            T000L2_A153EncuestaEstado, T000L2_n153EncuestaEstado, T000L2_A19CitaId
            }
            , new Object[] {
            T000L3_A37EncuestaId, T000L3_A148EncuestaAtencion, T000L3_n148EncuestaAtencion, T000L3_A149EncuestaAtendido, T000L3_n149EncuestaAtendido, T000L3_A150EncuestaHoraAtencion, T000L3_n150EncuestaHoraAtencion, T000L3_A151EncuestaComentarios, T000L3_n151EncuestaComentarios, T000L3_A152EncuestaRecomendacion,
            T000L3_A153EncuestaEstado, T000L3_n153EncuestaEstado, T000L3_A19CitaId
            }
            , new Object[] {
            T000L4_A20PacienteId, T000L4_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            T000L5_A103PacienteApellidoPaterno, T000L5_A104PacienteApellidoMaterno, T000L5_A105PacienteNombres
            }
            , new Object[] {
            T000L6_A72SGCitaDisponibilidadSedeId, T000L6_A66SGCitaDisponibilidadFecha, T000L6_n66SGCitaDisponibilidadFecha, T000L6_A81SGCitaDisponibilidadProfesionalId, T000L6_A70SGCitaDisponibilidadEspecialidadId
            }
            , new Object[] {
            T000L7_A84ProfesionalNombres, T000L7_n84ProfesionalNombres, T000L7_A85ProfesionalApellidoPaterno, T000L7_n85ProfesionalApellidoPaterno, T000L7_A86ProfesionalApellidoMaterno, T000L7_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            T000L8_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            T000L9_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000L10_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            T000L11_A72SGCitaDisponibilidadSedeId, T000L11_A37EncuestaId, T000L11_A146SGCitaDisponibilidadEspecialidadNombre, T000L11_A66SGCitaDisponibilidadFecha, T000L11_n66SGCitaDisponibilidadFecha, T000L11_A103PacienteApellidoPaterno, T000L11_A104PacienteApellidoMaterno, T000L11_A105PacienteNombres, T000L11_A78SGCitaDisponibilidadClinicaNombre, T000L11_A148EncuestaAtencion,
            T000L11_n148EncuestaAtencion, T000L11_A149EncuestaAtendido, T000L11_n149EncuestaAtendido, T000L11_A150EncuestaHoraAtencion, T000L11_n150EncuestaHoraAtencion, T000L11_A151EncuestaComentarios, T000L11_n151EncuestaComentarios, T000L11_A152EncuestaRecomendacion, T000L11_A153EncuestaEstado, T000L11_n153EncuestaEstado,
            T000L11_A84ProfesionalNombres, T000L11_n84ProfesionalNombres, T000L11_A85ProfesionalApellidoPaterno, T000L11_n85ProfesionalApellidoPaterno, T000L11_A86ProfesionalApellidoMaterno, T000L11_n86ProfesionalApellidoMaterno, T000L11_A19CitaId, T000L11_A20PacienteId, T000L11_A21SGCitaDisponibilidadId, T000L11_A81SGCitaDisponibilidadProfesionalId,
            T000L11_A70SGCitaDisponibilidadEspecialidadId, T000L11_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000L12_A20PacienteId, T000L12_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            T000L13_A103PacienteApellidoPaterno, T000L13_A104PacienteApellidoMaterno, T000L13_A105PacienteNombres
            }
            , new Object[] {
            T000L14_A72SGCitaDisponibilidadSedeId, T000L14_A66SGCitaDisponibilidadFecha, T000L14_n66SGCitaDisponibilidadFecha, T000L14_A81SGCitaDisponibilidadProfesionalId, T000L14_A70SGCitaDisponibilidadEspecialidadId
            }
            , new Object[] {
            T000L15_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000L16_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            T000L17_A84ProfesionalNombres, T000L17_n84ProfesionalNombres, T000L17_A85ProfesionalApellidoPaterno, T000L17_n85ProfesionalApellidoPaterno, T000L17_A86ProfesionalApellidoMaterno, T000L17_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            T000L18_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            T000L19_A37EncuestaId
            }
            , new Object[] {
            T000L20_A37EncuestaId
            }
            , new Object[] {
            T000L21_A37EncuestaId
            }
            , new Object[] {
            T000L22_A37EncuestaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000L25_A20PacienteId, T000L25_A21SGCitaDisponibilidadId
            }
            , new Object[] {
            T000L26_A103PacienteApellidoPaterno, T000L26_A104PacienteApellidoMaterno, T000L26_A105PacienteNombres
            }
            , new Object[] {
            T000L27_A72SGCitaDisponibilidadSedeId, T000L27_A66SGCitaDisponibilidadFecha, T000L27_n66SGCitaDisponibilidadFecha, T000L27_A81SGCitaDisponibilidadProfesionalId, T000L27_A70SGCitaDisponibilidadEspecialidadId
            }
            , new Object[] {
            T000L28_A76SGCitaDisponibilidadClinicaId
            }
            , new Object[] {
            T000L29_A78SGCitaDisponibilidadClinicaNombre
            }
            , new Object[] {
            T000L30_A84ProfesionalNombres, T000L30_n84ProfesionalNombres, T000L30_A85ProfesionalApellidoPaterno, T000L30_n85ProfesionalApellidoPaterno, T000L30_A86ProfesionalApellidoMaterno, T000L30_n86ProfesionalApellidoMaterno
            }
            , new Object[] {
            T000L31_A146SGCitaDisponibilidadEspecialidadNombre
            }
            , new Object[] {
            T000L32_A37EncuestaId
            }
         }
      );
      AV22Pgmname = "Encuesta" ;
      Z150EncuestaHoraAtencion = GXutil.resetDate(GXutil.now( )) ;
      n150EncuestaHoraAtencion = false ;
      A150EncuestaHoraAtencion = GXutil.resetDate(GXutil.now( )) ;
      n150EncuestaHoraAtencion = false ;
      i150EncuestaHoraAtencion = GXutil.resetDate(GXutil.now( )) ;
      n150EncuestaHoraAtencion = false ;
   }

   private byte Z152EncuestaRecomendacion ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A152EncuestaRecomendacion ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV20EncuestaId ;
   private short Z37EncuestaId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short AV20EncuestaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A37EncuestaId ;
   private short RcdFound29 ;
   private short Z72SGCitaDisponibilidadSedeId ;
   private short Z70SGCitaDisponibilidadEspecialidadId ;
   private short Z76SGCitaDisponibilidadClinicaId ;
   private short nIsDirty_29 ;
   private int Z19CitaId ;
   private int N19CitaId ;
   private int A19CitaId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int trnEnded ;
   private int edtEncuestaId_Enabled ;
   private int edtCitaId_Visible ;
   private int edtCitaId_Enabled ;
   private int edtSGCitaDisponibilidadProfesionalId_Enabled ;
   private int edtSGCitaDisponibilidadProFullName_Enabled ;
   private int edtSGCitaDisponibilidadEspecialidadId_Enabled ;
   private int edtSGCitaDisponibilidadEspecialidadNombre_Enabled ;
   private int edtSGCitaDisponibilidadId_Enabled ;
   private int edtSGCitaDisponibilidadFecha_Enabled ;
   private int edtPacienteId_Enabled ;
   private int edtPacienteApellidoPaterno_Enabled ;
   private int edtPacienteApellidoMaterno_Enabled ;
   private int edtPacienteNombres_Enabled ;
   private int edtSGCitaDisponibilidadClinicaId_Enabled ;
   private int edtSGCitaDisponibilidadClinicaNombre_Enabled ;
   private int edtEncuestaHoraAtencion_Enabled ;
   private int edtEncuestaComentarios_Enabled ;
   private int edtEncuestaRecomendacion_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int AV19ComboCitaId ;
   private int edtavCombocitaid_Enabled ;
   private int edtavCombocitaid_Visible ;
   private int AV12Insert_CitaId ;
   private int Combo_citaid_Datalistupdateminimumcharacters ;
   private int AV23GXV1 ;
   private int GX_JID ;
   private int Z20PacienteId ;
   private int Z21SGCitaDisponibilidadId ;
   private int Z81SGCitaDisponibilidadProfesionalId ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z148EncuestaAtencion ;
   private String Z149EncuestaAtendido ;
   private String Z153EncuestaEstado ;
   private String Combo_citaid_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCitaId_Internalname ;
   private String A148EncuestaAtencion ;
   private String A149EncuestaAtendido ;
   private String A153EncuestaEstado ;
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
   private String edtEncuestaId_Internalname ;
   private String edtEncuestaId_Jsonclick ;
   private String divTablesplittedcitaid_Internalname ;
   private String lblTextblockcitaid_Internalname ;
   private String lblTextblockcitaid_Jsonclick ;
   private String Combo_citaid_Caption ;
   private String Combo_citaid_Cls ;
   private String Combo_citaid_Datalistproc ;
   private String Combo_citaid_Datalistprocparametersprefix ;
   private String Combo_citaid_Internalname ;
   private String TempTags ;
   private String edtCitaId_Jsonclick ;
   private String edtSGCitaDisponibilidadProfesionalId_Internalname ;
   private String edtSGCitaDisponibilidadProfesionalId_Jsonclick ;
   private String edtSGCitaDisponibilidadProFullName_Internalname ;
   private String edtSGCitaDisponibilidadProFullName_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadId_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadId_Internalname ;
   private String edtSGCitaDisponibilidadId_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteId_Jsonclick ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Internalname ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaId_Internalname ;
   private String edtSGCitaDisponibilidadClinicaId_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaNombre_Internalname ;
   private String edtSGCitaDisponibilidadClinicaNombre_Jsonclick ;
   private String edtEncuestaHoraAtencion_Internalname ;
   private String edtEncuestaHoraAtencion_Jsonclick ;
   private String edtEncuestaComentarios_Internalname ;
   private String edtEncuestaRecomendacion_Internalname ;
   private String edtEncuestaRecomendacion_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_citaid_Internalname ;
   private String edtavCombocitaid_Internalname ;
   private String edtavCombocitaid_Jsonclick ;
   private String AV22Pgmname ;
   private String Combo_citaid_Objectcall ;
   private String Combo_citaid_Class ;
   private String Combo_citaid_Icontype ;
   private String Combo_citaid_Icon ;
   private String Combo_citaid_Tooltip ;
   private String Combo_citaid_Selectedvalue_set ;
   private String Combo_citaid_Selectedtext_set ;
   private String Combo_citaid_Selectedtext_get ;
   private String Combo_citaid_Gamoauthtoken ;
   private String Combo_citaid_Ddointernalname ;
   private String Combo_citaid_Titlecontrolalign ;
   private String Combo_citaid_Dropdownoptionstype ;
   private String Combo_citaid_Titlecontrolidtoreplace ;
   private String Combo_citaid_Datalisttype ;
   private String Combo_citaid_Datalistfixedvalues ;
   private String Combo_citaid_Htmltemplate ;
   private String Combo_citaid_Multiplevaluestype ;
   private String Combo_citaid_Loadingdata ;
   private String Combo_citaid_Noresultsfound ;
   private String Combo_citaid_Emptyitemtext ;
   private String Combo_citaid_Onlyselectedvalues ;
   private String Combo_citaid_Selectalltext ;
   private String Combo_citaid_Multiplevaluesseparator ;
   private String Combo_citaid_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode29 ;
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
   private java.util.Date Z150EncuestaHoraAtencion ;
   private java.util.Date A150EncuestaHoraAtencion ;
   private java.util.Date i150EncuestaHoraAtencion ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date Z66SGCitaDisponibilidadFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n148EncuestaAtencion ;
   private boolean n149EncuestaAtendido ;
   private boolean n153EncuestaEstado ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_citaid_Emptyitem ;
   private boolean n150EncuestaHoraAtencion ;
   private boolean n84ProfesionalNombres ;
   private boolean n85ProfesionalApellidoPaterno ;
   private boolean n86ProfesionalApellidoMaterno ;
   private boolean Combo_citaid_Enabled ;
   private boolean Combo_citaid_Visible ;
   private boolean Combo_citaid_Allowmultipleselection ;
   private boolean Combo_citaid_Isgriditem ;
   private boolean Combo_citaid_Hasdescription ;
   private boolean Combo_citaid_Includeonlyselectedoption ;
   private boolean Combo_citaid_Includeselectalloption ;
   private boolean Combo_citaid_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n151EncuestaComentarios ;
   private boolean returnInSub ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private String A151EncuestaComentarios ;
   private String AV18Combo_DataJson ;
   private String Z151EncuestaComentarios ;
   private String A82SGCitaDisponibilidadProFullName ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A84ProfesionalNombres ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String AV16ComboSelectedValue ;
   private String AV17ComboSelectedText ;
   private String Z103PacienteApellidoPaterno ;
   private String Z104PacienteApellidoMaterno ;
   private String Z105PacienteNombres ;
   private String Z78SGCitaDisponibilidadClinicaNombre ;
   private String Z84ProfesionalNombres ;
   private String Z85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String Z146SGCitaDisponibilidadEspecialidadNombre ;
   private String Z82SGCitaDisponibilidadProFullName ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_citaid ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbEncuestaAtencion ;
   private HTMLChoice cmbEncuestaAtendido ;
   private HTMLChoice cmbEncuestaEstado ;
   private IDataStoreProvider pr_default ;
   private int[] T000L4_A20PacienteId ;
   private int[] T000L4_A21SGCitaDisponibilidadId ;
   private String[] T000L5_A103PacienteApellidoPaterno ;
   private String[] T000L5_A104PacienteApellidoMaterno ;
   private String[] T000L5_A105PacienteNombres ;
   private short[] T000L6_A72SGCitaDisponibilidadSedeId ;
   private java.util.Date[] T000L6_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000L6_n66SGCitaDisponibilidadFecha ;
   private int[] T000L6_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000L6_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000L9_A76SGCitaDisponibilidadClinicaId ;
   private String[] T000L10_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] T000L7_A84ProfesionalNombres ;
   private boolean[] T000L7_n84ProfesionalNombres ;
   private String[] T000L7_A85ProfesionalApellidoPaterno ;
   private boolean[] T000L7_n85ProfesionalApellidoPaterno ;
   private String[] T000L7_A86ProfesionalApellidoMaterno ;
   private boolean[] T000L7_n86ProfesionalApellidoMaterno ;
   private String[] T000L8_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] T000L11_A72SGCitaDisponibilidadSedeId ;
   private short[] T000L11_A37EncuestaId ;
   private String[] T000L11_A146SGCitaDisponibilidadEspecialidadNombre ;
   private java.util.Date[] T000L11_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000L11_n66SGCitaDisponibilidadFecha ;
   private String[] T000L11_A103PacienteApellidoPaterno ;
   private String[] T000L11_A104PacienteApellidoMaterno ;
   private String[] T000L11_A105PacienteNombres ;
   private String[] T000L11_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] T000L11_A148EncuestaAtencion ;
   private boolean[] T000L11_n148EncuestaAtencion ;
   private String[] T000L11_A149EncuestaAtendido ;
   private boolean[] T000L11_n149EncuestaAtendido ;
   private java.util.Date[] T000L11_A150EncuestaHoraAtencion ;
   private boolean[] T000L11_n150EncuestaHoraAtencion ;
   private String[] T000L11_A151EncuestaComentarios ;
   private boolean[] T000L11_n151EncuestaComentarios ;
   private byte[] T000L11_A152EncuestaRecomendacion ;
   private String[] T000L11_A153EncuestaEstado ;
   private boolean[] T000L11_n153EncuestaEstado ;
   private String[] T000L11_A84ProfesionalNombres ;
   private boolean[] T000L11_n84ProfesionalNombres ;
   private String[] T000L11_A85ProfesionalApellidoPaterno ;
   private boolean[] T000L11_n85ProfesionalApellidoPaterno ;
   private String[] T000L11_A86ProfesionalApellidoMaterno ;
   private boolean[] T000L11_n86ProfesionalApellidoMaterno ;
   private int[] T000L11_A19CitaId ;
   private int[] T000L11_A20PacienteId ;
   private int[] T000L11_A21SGCitaDisponibilidadId ;
   private int[] T000L11_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000L11_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000L11_A76SGCitaDisponibilidadClinicaId ;
   private int[] T000L12_A20PacienteId ;
   private int[] T000L12_A21SGCitaDisponibilidadId ;
   private String[] T000L13_A103PacienteApellidoPaterno ;
   private String[] T000L13_A104PacienteApellidoMaterno ;
   private String[] T000L13_A105PacienteNombres ;
   private short[] T000L14_A72SGCitaDisponibilidadSedeId ;
   private java.util.Date[] T000L14_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000L14_n66SGCitaDisponibilidadFecha ;
   private int[] T000L14_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000L14_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000L15_A76SGCitaDisponibilidadClinicaId ;
   private String[] T000L16_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] T000L17_A84ProfesionalNombres ;
   private boolean[] T000L17_n84ProfesionalNombres ;
   private String[] T000L17_A85ProfesionalApellidoPaterno ;
   private boolean[] T000L17_n85ProfesionalApellidoPaterno ;
   private String[] T000L17_A86ProfesionalApellidoMaterno ;
   private boolean[] T000L17_n86ProfesionalApellidoMaterno ;
   private String[] T000L18_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] T000L19_A37EncuestaId ;
   private short[] T000L3_A37EncuestaId ;
   private String[] T000L3_A148EncuestaAtencion ;
   private boolean[] T000L3_n148EncuestaAtencion ;
   private String[] T000L3_A149EncuestaAtendido ;
   private boolean[] T000L3_n149EncuestaAtendido ;
   private java.util.Date[] T000L3_A150EncuestaHoraAtencion ;
   private boolean[] T000L3_n150EncuestaHoraAtencion ;
   private String[] T000L3_A151EncuestaComentarios ;
   private boolean[] T000L3_n151EncuestaComentarios ;
   private byte[] T000L3_A152EncuestaRecomendacion ;
   private String[] T000L3_A153EncuestaEstado ;
   private boolean[] T000L3_n153EncuestaEstado ;
   private int[] T000L3_A19CitaId ;
   private short[] T000L20_A37EncuestaId ;
   private short[] T000L21_A37EncuestaId ;
   private short[] T000L2_A37EncuestaId ;
   private String[] T000L2_A148EncuestaAtencion ;
   private boolean[] T000L2_n148EncuestaAtencion ;
   private String[] T000L2_A149EncuestaAtendido ;
   private boolean[] T000L2_n149EncuestaAtendido ;
   private java.util.Date[] T000L2_A150EncuestaHoraAtencion ;
   private boolean[] T000L2_n150EncuestaHoraAtencion ;
   private String[] T000L2_A151EncuestaComentarios ;
   private boolean[] T000L2_n151EncuestaComentarios ;
   private byte[] T000L2_A152EncuestaRecomendacion ;
   private String[] T000L2_A153EncuestaEstado ;
   private boolean[] T000L2_n153EncuestaEstado ;
   private int[] T000L2_A19CitaId ;
   private short[] T000L22_A37EncuestaId ;
   private int[] T000L25_A20PacienteId ;
   private int[] T000L25_A21SGCitaDisponibilidadId ;
   private String[] T000L26_A103PacienteApellidoPaterno ;
   private String[] T000L26_A104PacienteApellidoMaterno ;
   private String[] T000L26_A105PacienteNombres ;
   private short[] T000L27_A72SGCitaDisponibilidadSedeId ;
   private java.util.Date[] T000L27_A66SGCitaDisponibilidadFecha ;
   private boolean[] T000L27_n66SGCitaDisponibilidadFecha ;
   private int[] T000L27_A81SGCitaDisponibilidadProfesionalId ;
   private short[] T000L27_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] T000L28_A76SGCitaDisponibilidadClinicaId ;
   private String[] T000L29_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] T000L30_A84ProfesionalNombres ;
   private boolean[] T000L30_n84ProfesionalNombres ;
   private String[] T000L30_A85ProfesionalApellidoPaterno ;
   private boolean[] T000L30_n85ProfesionalApellidoPaterno ;
   private String[] T000L30_A86ProfesionalApellidoMaterno ;
   private boolean[] T000L30_n86ProfesionalApellidoMaterno ;
   private String[] T000L31_A146SGCitaDisponibilidadEspecialidadNombre ;
   private short[] T000L32_A37EncuestaId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14CitaId_Data ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV7WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV15DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class encuesta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000L2", "SELECT [EncuestaId], [EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId] FROM [Encuesta] WITH (UPDLOCK) WHERE [EncuestaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L3", "SELECT [EncuestaId], [EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId] FROM [Encuesta] WHERE [EncuestaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L4", "SELECT [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L5", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L6", "SELECT [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L7", "SELECT [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L8", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L9", "SELECT [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L10", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L11", "SELECT T4.[SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, TM1.[EncuestaId], T8.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T4.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T3.[PacienteApellidoPaterno], T3.[PacienteApellidoMaterno], T3.[PacienteNombres], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre, TM1.[EncuestaAtencion], TM1.[EncuestaAtendido], TM1.[EncuestaHoraAtencion], TM1.[EncuestaComentarios], TM1.[EncuestaRecomendacion], TM1.[EncuestaEstado], T7.[ProfesionalNombres], T7.[ProfesionalApellidoPaterno], T7.[ProfesionalApellidoMaterno], TM1.[CitaId], T2.[PacienteId], T2.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T4.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T4.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId FROM ((((((([Encuesta] TM1 INNER JOIN [Cita] T2 ON T2.[CitaId] = TM1.[CitaId]) INNER JOIN [Paciente] T3 ON T3.[PacienteId] = T2.[PacienteId]) INNER JOIN [Disponibilidad] T4 ON T4.[DisponibilidadId] = T2.[SGCitaDisponibilidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T4.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica] T6 ON T6.[ClinicaId] = T5.[ClinicaId]) INNER JOIN [Profesional] T7 ON T7.[ProfesionalId] = T4.[ProfesionalId]) INNER JOIN [Especialidad] T8 ON T8.[EspecialidadId] = T4.[EspecialidadId]) WHERE TM1.[EncuestaId] = ? ORDER BY TM1.[EncuestaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L12", "SELECT [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L13", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L14", "SELECT [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L15", "SELECT [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L16", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L17", "SELECT [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L18", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L19", "SELECT [EncuestaId] FROM [Encuesta] WHERE [EncuestaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L20", "SELECT TOP 1 [EncuestaId] FROM [Encuesta] WHERE ( [EncuestaId] > ?) ORDER BY [EncuestaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000L21", "SELECT TOP 1 [EncuestaId] FROM [Encuesta] WHERE ( [EncuestaId] < ?) ORDER BY [EncuestaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000L22", "INSERT INTO [Encuesta]([EncuestaAtencion], [EncuestaAtendido], [EncuestaHoraAtencion], [EncuestaComentarios], [EncuestaRecomendacion], [EncuestaEstado], [CitaId]) VALUES(?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000L23", "UPDATE [Encuesta] SET [EncuestaAtencion]=?, [EncuestaAtendido]=?, [EncuestaHoraAtencion]=?, [EncuestaComentarios]=?, [EncuestaRecomendacion]=?, [EncuestaEstado]=?, [CitaId]=?  WHERE [EncuestaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000L24", "DELETE FROM [Encuesta]  WHERE [EncuestaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000L25", "SELECT [PacienteId], [SGCitaDisponibilidadId] AS SGCitaDisponibilidadId FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L26", "SELECT [PacienteApellidoPaterno], [PacienteApellidoMaterno], [PacienteNombres] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L27", "SELECT [SGSedeDisponibilidadSedeId] AS SGCitaDisponibilidadSedeId, [DisponibilidadFecha] AS SGCitaDisponibilidadFecha, [ProfesionalId] AS SGCitaDisponibilidadProfesionalId, [EspecialidadId] AS SGCitaDisponibilidadEspecialidadId FROM [Disponibilidad] WHERE [DisponibilidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L28", "SELECT [ClinicaId] AS SGCitaDisponibilidadClinicaId FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L29", "SELECT [ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L30", "SELECT [ProfesionalNombres], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L31", "SELECT [EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000L32", "SELECT [EncuestaId] FROM [Encuesta] ORDER BY [EncuestaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((String[]) buf[10])[0] = rslt.getString(7, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 1);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[5])[0] = GXutil.resetDate(rslt.getGXDateTime(4));
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(6);
               ((String[]) buf[10])[0] = rslt.getString(7, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(10, 1);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[13])[0] = GXutil.resetDate(rslt.getGXDateTime(11));
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((String[]) buf[15])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((byte[]) buf[17])[0] = rslt.getByte(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 1);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(15);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((String[]) buf[22])[0] = rslt.getVarchar(16);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getVarchar(17);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((int[]) buf[26])[0] = rslt.getInt(18);
               ((int[]) buf[27])[0] = rslt.getInt(19);
               ((int[]) buf[28])[0] = rslt.getInt(20);
               ((int[]) buf[29])[0] = rslt.getInt(21);
               ((short[]) buf[30])[0] = rslt.getShort(22);
               ((short[]) buf[31])[0] = rslt.getShort(23);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               return;
            case 26 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 1);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 1);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(3, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[7]);
               }
               stmt.setByte(5, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[10], 1);
               }
               stmt.setInt(7, ((Number) parms[11]).intValue());
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 1);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[3], 1);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.TIMESTAMP );
               }
               else
               {
                  stmt.setDateTime(3, (java.util.Date)parms[5], true);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[7]);
               }
               stmt.setByte(5, ((Number) parms[8]).byteValue());
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[10], 1);
               }
               stmt.setInt(7, ((Number) parms[11]).intValue());
               stmt.setShort(8, ((Number) parms[12]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 29 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

