package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class pacientefamiliar_impl extends GXDataArea
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
      gxfirstwebparm = httpContext.GetNextPar( ) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A20PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A20PacienteId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_5") == 0 )
      {
         A46SGPacienteHijoPacienteId = (int)(GXutil.lval( httpContext.GetPar( "SGPacienteHijoPacienteId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46SGPacienteHijoPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_5( A46SGPacienteHijoPacienteId) ;
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
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         Form.getMeta().addItem("description", "Paciente Familiar", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtPacienteFamiliarId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public pacientefamiliar_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public pacientefamiliar_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pacientefamiliar_impl.class ));
   }

   public pacientefamiliar_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbPacienteFamiliarParentesco = new HTMLChoice();
      cmbPacienteFamiliarEstado = new HTMLChoice();
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
      if ( cmbPacienteFamiliarParentesco.getItemCount() > 0 )
      {
         A235PacienteFamiliarParentesco = cmbPacienteFamiliarParentesco.getValidValue(A235PacienteFamiliarParentesco) ;
         httpContext.ajax_rsp_assign_attri("", false, "A235PacienteFamiliarParentesco", A235PacienteFamiliarParentesco);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteFamiliarParentesco.setValue( GXutil.rtrim( A235PacienteFamiliarParentesco) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarParentesco.getInternalname(), "Values", cmbPacienteFamiliarParentesco.ToJavascriptSource(), true);
      }
      if ( cmbPacienteFamiliarEstado.getItemCount() > 0 )
      {
         A236PacienteFamiliarEstado = cmbPacienteFamiliarEstado.getValidValue(A236PacienteFamiliarEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A236PacienteFamiliarEstado", A236PacienteFamiliarEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteFamiliarEstado.setValue( GXutil.rtrim( A236PacienteFamiliarEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarEstado.getInternalname(), "Values", cmbPacienteFamiliarEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "Container FormContainer", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Paciente Familiar", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 12,'',false,'',0)\"" ;
      ClassString = "BtnFirst" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteFamiliarId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteFamiliarId_Internalname, "Familiar Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteFamiliarId_Internalname, GXutil.ltrim( localUtil.ntoc( A45PacienteFamiliarId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPacienteFamiliarId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A45PacienteFamiliarId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A45PacienteFamiliarId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteFamiliarId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteFamiliarId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPacienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPacienteId_Internalname, "Paciente Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtPacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A20PacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPacienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGPacienteHijoPacienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGPacienteHijoPacienteId_Internalname, "Paciente Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGPacienteHijoPacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A46SGPacienteHijoPacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGPacienteHijoPacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGPacienteHijoPacienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGPacienteHijoPacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGPacienteHijoNombres_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGPacienteHijoNombres_Internalname, "Hijo Nombres", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGPacienteHijoNombres_Internalname, A232SGPacienteHijoNombres, GXutil.rtrim( localUtil.format( A232SGPacienteHijoNombres, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGPacienteHijoNombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGPacienteHijoNombres_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGPacienteHijoApellidoPaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGPacienteHijoApellidoPaterno_Internalname, "Apellido Paterno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGPacienteHijoApellidoPaterno_Internalname, A233SGPacienteHijoApellidoPaterno, GXutil.rtrim( localUtil.format( A233SGPacienteHijoApellidoPaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGPacienteHijoApellidoPaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGPacienteHijoApellidoPaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGPacienteHijoApellidoMaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGPacienteHijoApellidoMaterno_Internalname, "Apellido Materno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGPacienteHijoApellidoMaterno_Internalname, A234SGPacienteHijoApellidoMaterno, GXutil.rtrim( localUtil.format( A234SGPacienteHijoApellidoMaterno, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGPacienteHijoApellidoMaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGPacienteHijoApellidoMaterno_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteFamiliarParentesco.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteFamiliarParentesco.getInternalname(), "Familiar Parentesco", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteFamiliarParentesco, cmbPacienteFamiliarParentesco.getInternalname(), GXutil.rtrim( A235PacienteFamiliarParentesco), 1, cmbPacienteFamiliarParentesco.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteFamiliarParentesco.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "", true, (byte)(1), "HLP_PacienteFamiliar.htm");
      cmbPacienteFamiliarParentesco.setValue( GXutil.rtrim( A235PacienteFamiliarParentesco) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarParentesco.getInternalname(), "Values", cmbPacienteFamiliarParentesco.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbPacienteFamiliarEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbPacienteFamiliarEstado.getInternalname(), "Familiar Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbPacienteFamiliarEstado, cmbPacienteFamiliarEstado.getInternalname(), GXutil.rtrim( A236PacienteFamiliarEstado), 1, cmbPacienteFamiliarEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbPacienteFamiliarEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(1), "HLP_PacienteFamiliar.htm");
      cmbPacienteFamiliarEstado.setValue( GXutil.rtrim( A236PacienteFamiliarEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarEstado.getInternalname(), "Values", cmbPacienteFamiliarEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group Confirm", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteFamiliar.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_PacienteFamiliar.htm");
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
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         Z45PacienteFamiliarId = (int)(localUtil.ctol( httpContext.cgiGet( "Z45PacienteFamiliarId"), ",", ".")) ;
         Z235PacienteFamiliarParentesco = httpContext.cgiGet( "Z235PacienteFamiliarParentesco") ;
         Z236PacienteFamiliarEstado = httpContext.cgiGet( "Z236PacienteFamiliarEstado") ;
         Z20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z20PacienteId"), ",", ".")) ;
         Z46SGPacienteHijoPacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z46SGPacienteHijoPacienteId"), ",", ".")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPacienteFamiliarId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPacienteFamiliarId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PACIENTEFAMILIARID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPacienteFamiliarId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A45PacienteFamiliarId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
         }
         else
         {
            A45PacienteFamiliarId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteFamiliarId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PACIENTEID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPacienteId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A20PacienteId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         }
         else
         {
            A20PacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtPacienteId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSGPacienteHijoPacienteId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSGPacienteHijoPacienteId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SGPACIENTEHIJOPACIENTEID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSGPacienteHijoPacienteId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A46SGPacienteHijoPacienteId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A46SGPacienteHijoPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), 8, 0));
         }
         else
         {
            A46SGPacienteHijoPacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGPacienteHijoPacienteId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A46SGPacienteHijoPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), 8, 0));
         }
         A232SGPacienteHijoNombres = httpContext.cgiGet( edtSGPacienteHijoNombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
         A233SGPacienteHijoApellidoPaterno = httpContext.cgiGet( edtSGPacienteHijoApellidoPaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
         A234SGPacienteHijoApellidoMaterno = httpContext.cgiGet( edtSGPacienteHijoApellidoMaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
         cmbPacienteFamiliarParentesco.setValue( httpContext.cgiGet( cmbPacienteFamiliarParentesco.getInternalname()) );
         A235PacienteFamiliarParentesco = httpContext.cgiGet( cmbPacienteFamiliarParentesco.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "A235PacienteFamiliarParentesco", A235PacienteFamiliarParentesco);
         cmbPacienteFamiliarEstado.setValue( httpContext.cgiGet( cmbPacienteFamiliarEstado.getInternalname()) );
         A236PacienteFamiliarEstado = httpContext.cgiGet( cmbPacienteFamiliarEstado.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "A236PacienteFamiliarEstado", A236PacienteFamiliarEstado);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A45PacienteFamiliarId = (int)(GXutil.lval( httpContext.GetPar( "PacienteFamiliarId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
            getEqualNoModal( ) ;
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            disable_std_buttons_dsp( ) ;
            standaloneModal( ) ;
         }
         else
         {
            Gx_mode = "INS" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            standaloneModal( ) ;
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
                     if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0S37( ) ;
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
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes0S37( ) ;
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

   public void resetCaption0S0( )
   {
   }

   public void zm0S37( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z235PacienteFamiliarParentesco = T000S3_A235PacienteFamiliarParentesco[0] ;
            Z236PacienteFamiliarEstado = T000S3_A236PacienteFamiliarEstado[0] ;
            Z20PacienteId = T000S3_A20PacienteId[0] ;
            Z46SGPacienteHijoPacienteId = T000S3_A46SGPacienteHijoPacienteId[0] ;
         }
         else
         {
            Z235PacienteFamiliarParentesco = A235PacienteFamiliarParentesco ;
            Z236PacienteFamiliarEstado = A236PacienteFamiliarEstado ;
            Z20PacienteId = A20PacienteId ;
            Z46SGPacienteHijoPacienteId = A46SGPacienteHijoPacienteId ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z45PacienteFamiliarId = A45PacienteFamiliarId ;
         Z235PacienteFamiliarParentesco = A235PacienteFamiliarParentesco ;
         Z236PacienteFamiliarEstado = A236PacienteFamiliarEstado ;
         Z20PacienteId = A20PacienteId ;
         Z46SGPacienteHijoPacienteId = A46SGPacienteHijoPacienteId ;
         Z232SGPacienteHijoNombres = A232SGPacienteHijoNombres ;
         Z233SGPacienteHijoApellidoPaterno = A233SGPacienteHijoApellidoPaterno ;
         Z234SGPacienteHijoApellidoMaterno = A234SGPacienteHijoApellidoMaterno ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load0S37( )
   {
      /* Using cursor T000S6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A232SGPacienteHijoNombres = T000S6_A232SGPacienteHijoNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
         A233SGPacienteHijoApellidoPaterno = T000S6_A233SGPacienteHijoApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
         A234SGPacienteHijoApellidoMaterno = T000S6_A234SGPacienteHijoApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
         A235PacienteFamiliarParentesco = T000S6_A235PacienteFamiliarParentesco[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A235PacienteFamiliarParentesco", A235PacienteFamiliarParentesco);
         A236PacienteFamiliarEstado = T000S6_A236PacienteFamiliarEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A236PacienteFamiliarEstado", A236PacienteFamiliarEstado);
         A20PacienteId = T000S6_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A46SGPacienteHijoPacienteId = T000S6_A46SGPacienteHijoPacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46SGPacienteHijoPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), 8, 0));
         zm0S37( -3) ;
      }
      pr_default.close(4);
      onLoadActions0S37( ) ;
   }

   public void onLoadActions0S37( )
   {
   }

   public void checkExtendedTable0S37( )
   {
      nIsDirty_37 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000S4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T000S5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A46SGPacienteHijoPacienteId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente Hijo'.", "ForeignKeyNotFound", 1, "SGPACIENTEHIJOPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacienteHijoPacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A232SGPacienteHijoNombres = T000S5_A232SGPacienteHijoNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
      A233SGPacienteHijoApellidoPaterno = T000S5_A233SGPacienteHijoApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
      A234SGPacienteHijoApellidoMaterno = T000S5_A234SGPacienteHijoApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A235PacienteFamiliarParentesco, "H") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "P") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "M") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "HM") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "S") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "T") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "A") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "N") == 0 ) || ( GXutil.strcmp(A235PacienteFamiliarParentesco, "O") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Familiar Parentesco fuera de rango", "OutOfRange", 1, "PACIENTEFAMILIARPARENTESCO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPacienteFamiliarParentesco.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A236PacienteFamiliarEstado, "A") == 0 ) || ( GXutil.strcmp(A236PacienteFamiliarEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Paciente Familiar Estado fuera de rango", "OutOfRange", 1, "PACIENTEFAMILIARESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbPacienteFamiliarEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0S37( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_4( int A20PacienteId )
   {
      /* Using cursor T000S7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_5( int A46SGPacienteHijoPacienteId )
   {
      /* Using cursor T000S8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A46SGPacienteHijoPacienteId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente Hijo'.", "ForeignKeyNotFound", 1, "SGPACIENTEHIJOPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacienteHijoPacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A232SGPacienteHijoNombres = T000S8_A232SGPacienteHijoNombres[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
      A233SGPacienteHijoApellidoPaterno = T000S8_A233SGPacienteHijoApellidoPaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
      A234SGPacienteHijoApellidoMaterno = T000S8_A234SGPacienteHijoApellidoMaterno[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A232SGPacienteHijoNombres)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A233SGPacienteHijoApellidoPaterno)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A234SGPacienteHijoApellidoMaterno)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0S37( )
   {
      /* Using cursor T000S9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound37 = (short)(1) ;
      }
      else
      {
         RcdFound37 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000S3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0S37( 3) ;
         RcdFound37 = (short)(1) ;
         A45PacienteFamiliarId = T000S3_A45PacienteFamiliarId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
         A235PacienteFamiliarParentesco = T000S3_A235PacienteFamiliarParentesco[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A235PacienteFamiliarParentesco", A235PacienteFamiliarParentesco);
         A236PacienteFamiliarEstado = T000S3_A236PacienteFamiliarEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A236PacienteFamiliarEstado", A236PacienteFamiliarEstado);
         A20PacienteId = T000S3_A20PacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
         A46SGPacienteHijoPacienteId = T000S3_A46SGPacienteHijoPacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46SGPacienteHijoPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), 8, 0));
         Z45PacienteFamiliarId = A45PacienteFamiliarId ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0S37( ) ;
         if ( AnyError == 1 )
         {
            RcdFound37 = (short)(0) ;
            initializeNonKey0S37( ) ;
         }
         Gx_mode = sMode37 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound37 = (short)(0) ;
         initializeNonKey0S37( ) ;
         sMode37 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode37 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0S37( ) ;
      if ( RcdFound37 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound37 = (short)(0) ;
      /* Using cursor T000S10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000S10_A45PacienteFamiliarId[0] < A45PacienteFamiliarId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000S10_A45PacienteFamiliarId[0] > A45PacienteFamiliarId ) ) )
         {
            A45PacienteFamiliarId = T000S10_A45PacienteFamiliarId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
            RcdFound37 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound37 = (short)(0) ;
      /* Using cursor T000S11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000S11_A45PacienteFamiliarId[0] > A45PacienteFamiliarId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000S11_A45PacienteFamiliarId[0] < A45PacienteFamiliarId ) ) )
         {
            A45PacienteFamiliarId = T000S11_A45PacienteFamiliarId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
            RcdFound37 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0S37( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtPacienteFamiliarId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0S37( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound37 == 1 )
         {
            if ( A45PacienteFamiliarId != Z45PacienteFamiliarId )
            {
               A45PacienteFamiliarId = Z45PacienteFamiliarId ;
               httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PACIENTEFAMILIARID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPacienteFamiliarId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtPacienteFamiliarId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0S37( ) ;
               GX_FocusControl = edtPacienteFamiliarId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A45PacienteFamiliarId != Z45PacienteFamiliarId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtPacienteFamiliarId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0S37( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PACIENTEFAMILIARID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPacienteFamiliarId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtPacienteFamiliarId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0S37( ) ;
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
   }

   public void btn_delete( )
   {
      if ( A45PacienteFamiliarId != Z45PacienteFamiliarId )
      {
         A45PacienteFamiliarId = Z45PacienteFamiliarId ;
         httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PACIENTEFAMILIARID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteFamiliarId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtPacienteFamiliarId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "PACIENTEFAMILIARID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteFamiliarId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtPacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0S37( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0S37( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0S37( ) ;
      if ( RcdFound37 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound37 != 0 )
         {
            scanNext0S37( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtPacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0S37( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0S37( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000S2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PacienteFamiliar"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z235PacienteFamiliarParentesco, T000S2_A235PacienteFamiliarParentesco[0]) != 0 ) || ( GXutil.strcmp(Z236PacienteFamiliarEstado, T000S2_A236PacienteFamiliarEstado[0]) != 0 ) || ( Z20PacienteId != T000S2_A20PacienteId[0] ) || ( Z46SGPacienteHijoPacienteId != T000S2_A46SGPacienteHijoPacienteId[0] ) )
         {
            if ( GXutil.strcmp(Z235PacienteFamiliarParentesco, T000S2_A235PacienteFamiliarParentesco[0]) != 0 )
            {
               GXutil.writeLogln("pacientefamiliar:[seudo value changed for attri]"+"PacienteFamiliarParentesco");
               GXutil.writeLogRaw("Old: ",Z235PacienteFamiliarParentesco);
               GXutil.writeLogRaw("Current: ",T000S2_A235PacienteFamiliarParentesco[0]);
            }
            if ( GXutil.strcmp(Z236PacienteFamiliarEstado, T000S2_A236PacienteFamiliarEstado[0]) != 0 )
            {
               GXutil.writeLogln("pacientefamiliar:[seudo value changed for attri]"+"PacienteFamiliarEstado");
               GXutil.writeLogRaw("Old: ",Z236PacienteFamiliarEstado);
               GXutil.writeLogRaw("Current: ",T000S2_A236PacienteFamiliarEstado[0]);
            }
            if ( Z20PacienteId != T000S2_A20PacienteId[0] )
            {
               GXutil.writeLogln("pacientefamiliar:[seudo value changed for attri]"+"PacienteId");
               GXutil.writeLogRaw("Old: ",Z20PacienteId);
               GXutil.writeLogRaw("Current: ",T000S2_A20PacienteId[0]);
            }
            if ( Z46SGPacienteHijoPacienteId != T000S2_A46SGPacienteHijoPacienteId[0] )
            {
               GXutil.writeLogln("pacientefamiliar:[seudo value changed for attri]"+"SGPacienteHijoPacienteId");
               GXutil.writeLogRaw("Old: ",Z46SGPacienteHijoPacienteId);
               GXutil.writeLogRaw("Current: ",T000S2_A46SGPacienteHijoPacienteId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"PacienteFamiliar"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0S37( )
   {
      beforeValidate0S37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S37( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0S37( 0) ;
         checkOptimisticConcurrency0S37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S37( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0S37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000S12 */
                  pr_default.execute(10, new Object[] {A235PacienteFamiliarParentesco, A236PacienteFamiliarEstado, Integer.valueOf(A20PacienteId), Integer.valueOf(A46SGPacienteHijoPacienteId)});
                  A45PacienteFamiliarId = T000S12_A45PacienteFamiliarId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PacienteFamiliar");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0S0( ) ;
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
            load0S37( ) ;
         }
         endLevel0S37( ) ;
      }
      closeExtendedTableCursors0S37( ) ;
   }

   public void update0S37( )
   {
      beforeValidate0S37( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0S37( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S37( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0S37( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0S37( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000S13 */
                  pr_default.execute(11, new Object[] {A235PacienteFamiliarParentesco, A236PacienteFamiliarEstado, Integer.valueOf(A20PacienteId), Integer.valueOf(A46SGPacienteHijoPacienteId), Integer.valueOf(A45PacienteFamiliarId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("PacienteFamiliar");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"PacienteFamiliar"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0S37( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0S0( ) ;
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
         endLevel0S37( ) ;
      }
      closeExtendedTableCursors0S37( ) ;
   }

   public void deferredUpdate0S37( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0S37( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0S37( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0S37( ) ;
         afterConfirm0S37( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0S37( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000S14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A45PacienteFamiliarId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("PacienteFamiliar");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound37 == 0 )
                     {
                        initAll0S37( ) ;
                        Gx_mode = "INS" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     else
                     {
                        getByPrimaryKey( ) ;
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                     resetCaption0S0( ) ;
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
      sMode37 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0S37( ) ;
      Gx_mode = sMode37 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0S37( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000S15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A46SGPacienteHijoPacienteId)});
         A232SGPacienteHijoNombres = T000S15_A232SGPacienteHijoNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
         A233SGPacienteHijoApellidoPaterno = T000S15_A233SGPacienteHijoApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
         A234SGPacienteHijoApellidoMaterno = T000S15_A234SGPacienteHijoApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
         pr_default.close(13);
      }
   }

   public void endLevel0S37( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0S37( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(13);
         Application.commitDataStores(context, remoteHandle, pr_default, "pacientefamiliar");
         if ( AnyError == 0 )
         {
            confirmValues0S0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(13);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "pacientefamiliar");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0S37( )
   {
      /* Using cursor T000S16 */
      pr_default.execute(14);
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A45PacienteFamiliarId = T000S16_A45PacienteFamiliarId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0S37( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound37 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound37 = (short)(1) ;
         A45PacienteFamiliarId = T000S16_A45PacienteFamiliarId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
      }
   }

   public void scanEnd0S37( )
   {
      pr_default.close(14);
   }

   public void afterConfirm0S37( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0S37( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0S37( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0S37( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0S37( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0S37( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0S37( )
   {
      edtPacienteFamiliarId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteFamiliarId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteFamiliarId_Enabled), 5, 0), true);
      edtPacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPacienteId_Enabled), 5, 0), true);
      edtSGPacienteHijoPacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGPacienteHijoPacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGPacienteHijoPacienteId_Enabled), 5, 0), true);
      edtSGPacienteHijoNombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGPacienteHijoNombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGPacienteHijoNombres_Enabled), 5, 0), true);
      edtSGPacienteHijoApellidoPaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGPacienteHijoApellidoPaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGPacienteHijoApellidoPaterno_Enabled), 5, 0), true);
      edtSGPacienteHijoApellidoMaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGPacienteHijoApellidoMaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGPacienteHijoApellidoMaterno_Enabled), 5, 0), true);
      cmbPacienteFamiliarParentesco.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarParentesco.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPacienteFamiliarParentesco.getEnabled(), 5, 0), true);
      cmbPacienteFamiliarEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbPacienteFamiliarEstado.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0S37( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0S0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110325320", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.pacientefamiliar", new String[] {}, new String[] {}) +"\">") ;
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
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z45PacienteFamiliarId", GXutil.ltrim( localUtil.ntoc( Z45PacienteFamiliarId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z235PacienteFamiliarParentesco", GXutil.rtrim( Z235PacienteFamiliarParentesco));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z236PacienteFamiliarEstado", GXutil.rtrim( Z236PacienteFamiliarEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z20PacienteId", GXutil.ltrim( localUtil.ntoc( Z20PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z46SGPacienteHijoPacienteId", GXutil.ltrim( localUtil.ntoc( Z46SGPacienteHijoPacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
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
      return formatLink("com.projectthani.pacientefamiliar", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "PacienteFamiliar" ;
   }

   public String getPgmdesc( )
   {
      return "Paciente Familiar" ;
   }

   public void initializeNonKey0S37( )
   {
      A20PacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A20PacienteId), 8, 0));
      A46SGPacienteHijoPacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A46SGPacienteHijoPacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46SGPacienteHijoPacienteId), 8, 0));
      A232SGPacienteHijoNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
      A233SGPacienteHijoApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
      A234SGPacienteHijoApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
      A235PacienteFamiliarParentesco = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A235PacienteFamiliarParentesco", A235PacienteFamiliarParentesco);
      A236PacienteFamiliarEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A236PacienteFamiliarEstado", A236PacienteFamiliarEstado);
      Z235PacienteFamiliarParentesco = "" ;
      Z236PacienteFamiliarEstado = "" ;
      Z20PacienteId = 0 ;
      Z46SGPacienteHijoPacienteId = 0 ;
   }

   public void initAll0S37( )
   {
      A45PacienteFamiliarId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A45PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A45PacienteFamiliarId), 8, 0));
      initializeNonKey0S37( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110325324", true, true);
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
      httpContext.AddJavascriptSource("pacientefamiliar.js", "?20225110325324", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      edtPacienteFamiliarId_Internalname = "PACIENTEFAMILIARID" ;
      edtPacienteId_Internalname = "PACIENTEID" ;
      edtSGPacienteHijoPacienteId_Internalname = "SGPACIENTEHIJOPACIENTEID" ;
      edtSGPacienteHijoNombres_Internalname = "SGPACIENTEHIJONOMBRES" ;
      edtSGPacienteHijoApellidoPaterno_Internalname = "SGPACIENTEHIJOAPELLIDOPATERNO" ;
      edtSGPacienteHijoApellidoMaterno_Internalname = "SGPACIENTEHIJOAPELLIDOMATERNO" ;
      cmbPacienteFamiliarParentesco.setInternalname( "PACIENTEFAMILIARPARENTESCO" );
      cmbPacienteFamiliarEstado.setInternalname( "PACIENTEFAMILIARESTADO" );
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( "Paciente Familiar" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      cmbPacienteFamiliarEstado.setJsonclick( "" );
      cmbPacienteFamiliarEstado.setEnabled( 1 );
      cmbPacienteFamiliarParentesco.setJsonclick( "" );
      cmbPacienteFamiliarParentesco.setEnabled( 1 );
      edtSGPacienteHijoApellidoMaterno_Jsonclick = "" ;
      edtSGPacienteHijoApellidoMaterno_Enabled = 0 ;
      edtSGPacienteHijoApellidoPaterno_Jsonclick = "" ;
      edtSGPacienteHijoApellidoPaterno_Enabled = 0 ;
      edtSGPacienteHijoNombres_Jsonclick = "" ;
      edtSGPacienteHijoNombres_Enabled = 0 ;
      edtSGPacienteHijoPacienteId_Jsonclick = "" ;
      edtSGPacienteHijoPacienteId_Enabled = 1 ;
      edtPacienteId_Jsonclick = "" ;
      edtPacienteId_Enabled = 1 ;
      edtPacienteFamiliarId_Jsonclick = "" ;
      edtPacienteFamiliarId_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
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
      cmbPacienteFamiliarParentesco.setName( "PACIENTEFAMILIARPARENTESCO" );
      cmbPacienteFamiliarParentesco.setWebtags( "" );
      cmbPacienteFamiliarParentesco.addItem("H", "Hijo(a)", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("P", "Padre", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("M", "Madre", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("HM", "Hermano(a)", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("S", "Sobrino(a)", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("T", "Tio(a)", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("A", "Abuelo(a)", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("N", "Nieto(a)", (short)(0));
      cmbPacienteFamiliarParentesco.addItem("O", "Otro", (short)(0));
      if ( cmbPacienteFamiliarParentesco.getItemCount() > 0 )
      {
         A235PacienteFamiliarParentesco = cmbPacienteFamiliarParentesco.getValidValue(A235PacienteFamiliarParentesco) ;
         httpContext.ajax_rsp_assign_attri("", false, "A235PacienteFamiliarParentesco", A235PacienteFamiliarParentesco);
      }
      cmbPacienteFamiliarEstado.setName( "PACIENTEFAMILIARESTADO" );
      cmbPacienteFamiliarEstado.setWebtags( "" );
      cmbPacienteFamiliarEstado.addItem("A", "Activo", (short)(0));
      cmbPacienteFamiliarEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbPacienteFamiliarEstado.getItemCount() > 0 )
      {
         A236PacienteFamiliarEstado = cmbPacienteFamiliarEstado.getValidValue(A236PacienteFamiliarEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A236PacienteFamiliarEstado", A236PacienteFamiliarEstado);
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtPacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
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

   public void valid_Pacientefamiliarid( )
   {
      A236PacienteFamiliarEstado = cmbPacienteFamiliarEstado.getValue() ;
      cmbPacienteFamiliarEstado.setValue( A236PacienteFamiliarEstado );
      A235PacienteFamiliarParentesco = cmbPacienteFamiliarParentesco.getValue() ;
      cmbPacienteFamiliarParentesco.setValue( A235PacienteFamiliarParentesco );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbPacienteFamiliarParentesco.getItemCount() > 0 )
      {
         A235PacienteFamiliarParentesco = cmbPacienteFamiliarParentesco.getValidValue(A235PacienteFamiliarParentesco) ;
         cmbPacienteFamiliarParentesco.setValue( A235PacienteFamiliarParentesco );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteFamiliarParentesco.setValue( GXutil.rtrim( A235PacienteFamiliarParentesco) );
      }
      if ( cmbPacienteFamiliarEstado.getItemCount() > 0 )
      {
         A236PacienteFamiliarEstado = cmbPacienteFamiliarEstado.getValidValue(A236PacienteFamiliarEstado) ;
         cmbPacienteFamiliarEstado.setValue( A236PacienteFamiliarEstado );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbPacienteFamiliarEstado.setValue( GXutil.rtrim( A236PacienteFamiliarEstado) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A20PacienteId", GXutil.ltrim( localUtil.ntoc( A20PacienteId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A46SGPacienteHijoPacienteId", GXutil.ltrim( localUtil.ntoc( A46SGPacienteHijoPacienteId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A235PacienteFamiliarParentesco", GXutil.rtrim( A235PacienteFamiliarParentesco));
      cmbPacienteFamiliarParentesco.setValue( GXutil.rtrim( A235PacienteFamiliarParentesco) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarParentesco.getInternalname(), "Values", cmbPacienteFamiliarParentesco.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A236PacienteFamiliarEstado", GXutil.rtrim( A236PacienteFamiliarEstado));
      cmbPacienteFamiliarEstado.setValue( GXutil.rtrim( A236PacienteFamiliarEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbPacienteFamiliarEstado.getInternalname(), "Values", cmbPacienteFamiliarEstado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z45PacienteFamiliarId", GXutil.ltrim( localUtil.ntoc( Z45PacienteFamiliarId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z20PacienteId", GXutil.ltrim( localUtil.ntoc( Z20PacienteId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z46SGPacienteHijoPacienteId", GXutil.ltrim( localUtil.ntoc( Z46SGPacienteHijoPacienteId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z235PacienteFamiliarParentesco", GXutil.rtrim( Z235PacienteFamiliarParentesco));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z236PacienteFamiliarEstado", GXutil.rtrim( Z236PacienteFamiliarEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z232SGPacienteHijoNombres", Z232SGPacienteHijoNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z233SGPacienteHijoApellidoPaterno", Z233SGPacienteHijoApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z234SGPacienteHijoApellidoMaterno", Z234SGPacienteHijoApellidoMaterno);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Pacienteid( )
   {
      /* Using cursor T000S17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A20PacienteId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Paciente'.", "ForeignKeyNotFound", 1, "PACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPacienteId_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Sgpacientehijopacienteid( )
   {
      /* Using cursor T000S15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A46SGPacienteHijoPacienteId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente Hijo'.", "ForeignKeyNotFound", 1, "SGPACIENTEHIJOPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacienteHijoPacienteId_Internalname ;
      }
      A232SGPacienteHijoNombres = T000S15_A232SGPacienteHijoNombres[0] ;
      A233SGPacienteHijoApellidoPaterno = T000S15_A233SGPacienteHijoApellidoPaterno[0] ;
      A234SGPacienteHijoApellidoMaterno = T000S15_A234SGPacienteHijoApellidoMaterno[0] ;
      pr_default.close(13);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A232SGPacienteHijoNombres", A232SGPacienteHijoNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A233SGPacienteHijoApellidoPaterno", A233SGPacienteHijoApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A234SGPacienteHijoApellidoMaterno", A234SGPacienteHijoApellidoMaterno);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEFAMILIARID","{handler:'valid_Pacientefamiliarid',iparms:[{av:'cmbPacienteFamiliarEstado'},{av:'A236PacienteFamiliarEstado',fld:'PACIENTEFAMILIARESTADO',pic:''},{av:'cmbPacienteFamiliarParentesco'},{av:'A235PacienteFamiliarParentesco',fld:'PACIENTEFAMILIARPARENTESCO',pic:''},{av:'A45PacienteFamiliarId',fld:'PACIENTEFAMILIARID',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_PACIENTEFAMILIARID",",oparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'},{av:'A46SGPacienteHijoPacienteId',fld:'SGPACIENTEHIJOPACIENTEID',pic:'ZZZZZZZ9'},{av:'cmbPacienteFamiliarParentesco'},{av:'A235PacienteFamiliarParentesco',fld:'PACIENTEFAMILIARPARENTESCO',pic:''},{av:'cmbPacienteFamiliarEstado'},{av:'A236PacienteFamiliarEstado',fld:'PACIENTEFAMILIARESTADO',pic:''},{av:'A232SGPacienteHijoNombres',fld:'SGPACIENTEHIJONOMBRES',pic:''},{av:'A233SGPacienteHijoApellidoPaterno',fld:'SGPACIENTEHIJOAPELLIDOPATERNO',pic:''},{av:'A234SGPacienteHijoApellidoMaterno',fld:'SGPACIENTEHIJOAPELLIDOMATERNO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z45PacienteFamiliarId'},{av:'Z20PacienteId'},{av:'Z46SGPacienteHijoPacienteId'},{av:'Z235PacienteFamiliarParentesco'},{av:'Z236PacienteFamiliarEstado'},{av:'Z232SGPacienteHijoNombres'},{av:'Z233SGPacienteHijoApellidoPaterno'},{av:'Z234SGPacienteHijoApellidoMaterno'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_PACIENTEID","{handler:'valid_Pacienteid',iparms:[{av:'A20PacienteId',fld:'PACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_PACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_SGPACIENTEHIJOPACIENTEID","{handler:'valid_Sgpacientehijopacienteid',iparms:[{av:'A46SGPacienteHijoPacienteId',fld:'SGPACIENTEHIJOPACIENTEID',pic:'ZZZZZZZ9'},{av:'A232SGPacienteHijoNombres',fld:'SGPACIENTEHIJONOMBRES',pic:''},{av:'A233SGPacienteHijoApellidoPaterno',fld:'SGPACIENTEHIJOAPELLIDOPATERNO',pic:''},{av:'A234SGPacienteHijoApellidoMaterno',fld:'SGPACIENTEHIJOAPELLIDOMATERNO',pic:''}]");
      setEventMetadata("VALID_SGPACIENTEHIJOPACIENTEID",",oparms:[{av:'A232SGPacienteHijoNombres',fld:'SGPACIENTEHIJONOMBRES',pic:''},{av:'A233SGPacienteHijoApellidoPaterno',fld:'SGPACIENTEHIJOAPELLIDOPATERNO',pic:''},{av:'A234SGPacienteHijoApellidoMaterno',fld:'SGPACIENTEHIJOAPELLIDOMATERNO',pic:''}]}");
      setEventMetadata("VALID_PACIENTEFAMILIARPARENTESCO","{handler:'valid_Pacientefamiliarparentesco',iparms:[]");
      setEventMetadata("VALID_PACIENTEFAMILIARPARENTESCO",",oparms:[]}");
      setEventMetadata("VALID_PACIENTEFAMILIARESTADO","{handler:'valid_Pacientefamiliarestado',iparms:[]");
      setEventMetadata("VALID_PACIENTEFAMILIARESTADO",",oparms:[]}");
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
      pr_default.close(15);
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z235PacienteFamiliarParentesco = "" ;
      Z236PacienteFamiliarEstado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A235PacienteFamiliarParentesco = "" ;
      A236PacienteFamiliarEstado = "" ;
      lblTitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A232SGPacienteHijoNombres = "" ;
      A233SGPacienteHijoApellidoPaterno = "" ;
      A234SGPacienteHijoApellidoMaterno = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z232SGPacienteHijoNombres = "" ;
      Z233SGPacienteHijoApellidoPaterno = "" ;
      Z234SGPacienteHijoApellidoMaterno = "" ;
      T000S6_A45PacienteFamiliarId = new int[1] ;
      T000S6_A232SGPacienteHijoNombres = new String[] {""} ;
      T000S6_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      T000S6_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      T000S6_A235PacienteFamiliarParentesco = new String[] {""} ;
      T000S6_A236PacienteFamiliarEstado = new String[] {""} ;
      T000S6_A20PacienteId = new int[1] ;
      T000S6_A46SGPacienteHijoPacienteId = new int[1] ;
      T000S4_A20PacienteId = new int[1] ;
      T000S5_A232SGPacienteHijoNombres = new String[] {""} ;
      T000S5_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      T000S5_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      T000S7_A20PacienteId = new int[1] ;
      T000S8_A232SGPacienteHijoNombres = new String[] {""} ;
      T000S8_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      T000S8_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      T000S9_A45PacienteFamiliarId = new int[1] ;
      T000S3_A45PacienteFamiliarId = new int[1] ;
      T000S3_A235PacienteFamiliarParentesco = new String[] {""} ;
      T000S3_A236PacienteFamiliarEstado = new String[] {""} ;
      T000S3_A20PacienteId = new int[1] ;
      T000S3_A46SGPacienteHijoPacienteId = new int[1] ;
      sMode37 = "" ;
      T000S10_A45PacienteFamiliarId = new int[1] ;
      T000S11_A45PacienteFamiliarId = new int[1] ;
      T000S2_A45PacienteFamiliarId = new int[1] ;
      T000S2_A235PacienteFamiliarParentesco = new String[] {""} ;
      T000S2_A236PacienteFamiliarEstado = new String[] {""} ;
      T000S2_A20PacienteId = new int[1] ;
      T000S2_A46SGPacienteHijoPacienteId = new int[1] ;
      T000S12_A45PacienteFamiliarId = new int[1] ;
      T000S15_A232SGPacienteHijoNombres = new String[] {""} ;
      T000S15_A233SGPacienteHijoApellidoPaterno = new String[] {""} ;
      T000S15_A234SGPacienteHijoApellidoMaterno = new String[] {""} ;
      T000S16_A45PacienteFamiliarId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ235PacienteFamiliarParentesco = "" ;
      ZZ236PacienteFamiliarEstado = "" ;
      ZZ232SGPacienteHijoNombres = "" ;
      ZZ233SGPacienteHijoApellidoPaterno = "" ;
      ZZ234SGPacienteHijoApellidoMaterno = "" ;
      T000S17_A20PacienteId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.pacientefamiliar__default(),
         new Object[] {
             new Object[] {
            T000S2_A45PacienteFamiliarId, T000S2_A235PacienteFamiliarParentesco, T000S2_A236PacienteFamiliarEstado, T000S2_A20PacienteId, T000S2_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            T000S3_A45PacienteFamiliarId, T000S3_A235PacienteFamiliarParentesco, T000S3_A236PacienteFamiliarEstado, T000S3_A20PacienteId, T000S3_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            T000S4_A20PacienteId
            }
            , new Object[] {
            T000S5_A232SGPacienteHijoNombres, T000S5_A233SGPacienteHijoApellidoPaterno, T000S5_A234SGPacienteHijoApellidoMaterno
            }
            , new Object[] {
            T000S6_A45PacienteFamiliarId, T000S6_A232SGPacienteHijoNombres, T000S6_A233SGPacienteHijoApellidoPaterno, T000S6_A234SGPacienteHijoApellidoMaterno, T000S6_A235PacienteFamiliarParentesco, T000S6_A236PacienteFamiliarEstado, T000S6_A20PacienteId, T000S6_A46SGPacienteHijoPacienteId
            }
            , new Object[] {
            T000S7_A20PacienteId
            }
            , new Object[] {
            T000S8_A232SGPacienteHijoNombres, T000S8_A233SGPacienteHijoApellidoPaterno, T000S8_A234SGPacienteHijoApellidoMaterno
            }
            , new Object[] {
            T000S9_A45PacienteFamiliarId
            }
            , new Object[] {
            T000S10_A45PacienteFamiliarId
            }
            , new Object[] {
            T000S11_A45PacienteFamiliarId
            }
            , new Object[] {
            T000S12_A45PacienteFamiliarId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000S15_A232SGPacienteHijoNombres, T000S15_A233SGPacienteHijoApellidoPaterno, T000S15_A234SGPacienteHijoApellidoMaterno
            }
            , new Object[] {
            T000S16_A45PacienteFamiliarId
            }
            , new Object[] {
            T000S17_A20PacienteId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound37 ;
   private short nIsDirty_37 ;
   private int Z45PacienteFamiliarId ;
   private int Z20PacienteId ;
   private int Z46SGPacienteHijoPacienteId ;
   private int A20PacienteId ;
   private int A46SGPacienteHijoPacienteId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int A45PacienteFamiliarId ;
   private int edtPacienteFamiliarId_Enabled ;
   private int edtPacienteId_Enabled ;
   private int edtSGPacienteHijoPacienteId_Enabled ;
   private int edtSGPacienteHijoNombres_Enabled ;
   private int edtSGPacienteHijoApellidoPaterno_Enabled ;
   private int edtSGPacienteHijoApellidoMaterno_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ45PacienteFamiliarId ;
   private int ZZ20PacienteId ;
   private int ZZ46SGPacienteHijoPacienteId ;
   private String sPrefix ;
   private String Z235PacienteFamiliarParentesco ;
   private String Z236PacienteFamiliarEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtPacienteFamiliarId_Internalname ;
   private String A235PacienteFamiliarParentesco ;
   private String A236PacienteFamiliarEstado ;
   private String divTablemain_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String edtPacienteFamiliarId_Jsonclick ;
   private String edtPacienteId_Internalname ;
   private String edtPacienteId_Jsonclick ;
   private String edtSGPacienteHijoPacienteId_Internalname ;
   private String edtSGPacienteHijoPacienteId_Jsonclick ;
   private String edtSGPacienteHijoNombres_Internalname ;
   private String edtSGPacienteHijoNombres_Jsonclick ;
   private String edtSGPacienteHijoApellidoPaterno_Internalname ;
   private String edtSGPacienteHijoApellidoPaterno_Jsonclick ;
   private String edtSGPacienteHijoApellidoMaterno_Internalname ;
   private String edtSGPacienteHijoApellidoMaterno_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode37 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ235PacienteFamiliarParentesco ;
   private String ZZ236PacienteFamiliarEstado ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String A232SGPacienteHijoNombres ;
   private String A233SGPacienteHijoApellidoPaterno ;
   private String A234SGPacienteHijoApellidoMaterno ;
   private String Z232SGPacienteHijoNombres ;
   private String Z233SGPacienteHijoApellidoPaterno ;
   private String Z234SGPacienteHijoApellidoMaterno ;
   private String ZZ232SGPacienteHijoNombres ;
   private String ZZ233SGPacienteHijoApellidoPaterno ;
   private String ZZ234SGPacienteHijoApellidoMaterno ;
   private HTMLChoice cmbPacienteFamiliarParentesco ;
   private HTMLChoice cmbPacienteFamiliarEstado ;
   private IDataStoreProvider pr_default ;
   private int[] T000S6_A45PacienteFamiliarId ;
   private String[] T000S6_A232SGPacienteHijoNombres ;
   private String[] T000S6_A233SGPacienteHijoApellidoPaterno ;
   private String[] T000S6_A234SGPacienteHijoApellidoMaterno ;
   private String[] T000S6_A235PacienteFamiliarParentesco ;
   private String[] T000S6_A236PacienteFamiliarEstado ;
   private int[] T000S6_A20PacienteId ;
   private int[] T000S6_A46SGPacienteHijoPacienteId ;
   private int[] T000S4_A20PacienteId ;
   private String[] T000S5_A232SGPacienteHijoNombres ;
   private String[] T000S5_A233SGPacienteHijoApellidoPaterno ;
   private String[] T000S5_A234SGPacienteHijoApellidoMaterno ;
   private int[] T000S7_A20PacienteId ;
   private String[] T000S8_A232SGPacienteHijoNombres ;
   private String[] T000S8_A233SGPacienteHijoApellidoPaterno ;
   private String[] T000S8_A234SGPacienteHijoApellidoMaterno ;
   private int[] T000S9_A45PacienteFamiliarId ;
   private int[] T000S3_A45PacienteFamiliarId ;
   private String[] T000S3_A235PacienteFamiliarParentesco ;
   private String[] T000S3_A236PacienteFamiliarEstado ;
   private int[] T000S3_A20PacienteId ;
   private int[] T000S3_A46SGPacienteHijoPacienteId ;
   private int[] T000S10_A45PacienteFamiliarId ;
   private int[] T000S11_A45PacienteFamiliarId ;
   private int[] T000S2_A45PacienteFamiliarId ;
   private String[] T000S2_A235PacienteFamiliarParentesco ;
   private String[] T000S2_A236PacienteFamiliarEstado ;
   private int[] T000S2_A20PacienteId ;
   private int[] T000S2_A46SGPacienteHijoPacienteId ;
   private int[] T000S12_A45PacienteFamiliarId ;
   private String[] T000S15_A232SGPacienteHijoNombres ;
   private String[] T000S15_A233SGPacienteHijoApellidoPaterno ;
   private String[] T000S15_A234SGPacienteHijoApellidoMaterno ;
   private int[] T000S16_A45PacienteFamiliarId ;
   private int[] T000S17_A20PacienteId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class pacientefamiliar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000S2", "SELECT [PacienteFamiliarId], [PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM [PacienteFamiliar] WITH (UPDLOCK) WHERE [PacienteFamiliarId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S3", "SELECT [PacienteFamiliarId], [PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM [PacienteFamiliar] WHERE [PacienteFamiliarId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S4", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S5", "SELECT [PacienteNombres] AS SGPacienteHijoNombres, [PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, [PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S6", "SELECT TM1.[PacienteFamiliarId], T2.[PacienteNombres] AS SGPacienteHijoNombres, T2.[PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, T2.[PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno, TM1.[PacienteFamiliarParentesco], TM1.[PacienteFamiliarEstado], TM1.[PacienteId], TM1.[SGPacienteHijoPacienteId] AS SGPacienteHijoPacienteId FROM ([PacienteFamiliar] TM1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = TM1.[SGPacienteHijoPacienteId]) WHERE TM1.[PacienteFamiliarId] = ? ORDER BY TM1.[PacienteFamiliarId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S7", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S8", "SELECT [PacienteNombres] AS SGPacienteHijoNombres, [PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, [PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S9", "SELECT [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE [PacienteFamiliarId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S10", "SELECT TOP 1 [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE ( [PacienteFamiliarId] > ?) ORDER BY [PacienteFamiliarId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000S11", "SELECT TOP 1 [PacienteFamiliarId] FROM [PacienteFamiliar] WHERE ( [PacienteFamiliarId] < ?) ORDER BY [PacienteFamiliarId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000S12", "INSERT INTO [PacienteFamiliar]([PacienteFamiliarParentesco], [PacienteFamiliarEstado], [PacienteId], [SGPacienteHijoPacienteId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000S13", "UPDATE [PacienteFamiliar] SET [PacienteFamiliarParentesco]=?, [PacienteFamiliarEstado]=?, [PacienteId]=?, [SGPacienteHijoPacienteId]=?  WHERE [PacienteFamiliarId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000S14", "DELETE FROM [PacienteFamiliar]  WHERE [PacienteFamiliarId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000S15", "SELECT [PacienteNombres] AS SGPacienteHijoNombres, [PacienteApellidoPaterno] AS SGPacienteHijoApellidoPaterno, [PacienteApellidoMaterno] AS SGPacienteHijoApellidoMaterno FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S16", "SELECT [PacienteFamiliarId] FROM [PacienteFamiliar] ORDER BY [PacienteFamiliarId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000S17", "SELECT [PacienteId] FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 2);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 2);
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 2);
               stmt.setString(2, (String)parms[1], 1);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

