package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class sugerenciasmejorasplataforma_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_3") == 0 )
      {
         A61SGPacientePacienteId = (int)(GXutil.lval( httpContext.GetPar( "SGPacientePacienteId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A61SGPacientePacienteId) ;
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
         Form.getMeta().addItem("description", "Sugerencias Mejoras Plataforma", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public sugerenciasmejorasplataforma_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public sugerenciasmejorasplataforma_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sugerenciasmejorasplataforma_impl.class ));
   }

   public sugerenciasmejorasplataforma_impl( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Sugerencias Mejoras Plataforma", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_SugerenciasMejorasPlataforma.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_SugerenciasMejorasPlataforma.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSugerenciasMejorasPlataformaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSugerenciasMejorasPlataformaId_Internalname, "Plataforma Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSugerenciasMejorasPlataformaId_Internalname, GXutil.ltrim( localUtil.ntoc( A397SugerenciasMejorasPlataformaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSugerenciasMejorasPlataformaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSugerenciasMejorasPlataformaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSugerenciasMejorasPlataformaId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGPacientePacienteId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGPacientePacienteId_Internalname, "Paciente Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGPacientePacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGPacientePacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGPacientePacienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGPacientePacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSugerenciasMejorasPlataformaCitaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSugerenciasMejorasPlataformaCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSugerenciasMejorasPlataformaCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A403SugerenciasMejorasPlataformaCitaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSugerenciasMejorasPlataformaCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A403SugerenciasMejorasPlataformaCitaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A403SugerenciasMejorasPlataformaCitaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSugerenciasMejorasPlataformaCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSugerenciasMejorasPlataformaCitaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSugerenciasMejorasPlataformaOp_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSugerenciasMejorasPlataformaOp_Internalname, "Plataforma Op", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtSugerenciasMejorasPlataformaOp_Internalname, A400SugerenciasMejorasPlataformaOp, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", (short)(0), 1, edtSugerenciasMejorasPlataformaOp_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSugerenciasMejorasPlataformaMej_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSugerenciasMejorasPlataformaMej_Internalname, "Plataforma Mej", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtSugerenciasMejorasPlataformaMej_Internalname, A402SugerenciasMejorasPlataformaMej, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", (short)(0), 1, edtSugerenciasMejorasPlataformaMej_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSugerenciasMejorasPlataformaFecRegistro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSugerenciasMejorasPlataformaFecRegistro_Internalname, "Fec Registro", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtSugerenciasMejorasPlataformaFecRegistro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSugerenciasMejorasPlataformaFecRegistro_Internalname, localUtil.format(A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"), localUtil.format( A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSugerenciasMejorasPlataformaFecRegistro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSugerenciasMejorasPlataformaFecRegistro_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtSugerenciasMejorasPlataformaFecRegistro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtSugerenciasMejorasPlataformaFecRegistro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_SugerenciasMejorasPlataforma.htm");
      httpContext.writeTextNL( "</div>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SugerenciasMejorasPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_SugerenciasMejorasPlataforma.htm");
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
         Z397SugerenciasMejorasPlataformaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z397SugerenciasMejorasPlataformaId"), ",", ".")) ;
         Z403SugerenciasMejorasPlataformaCitaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z403SugerenciasMejorasPlataformaCitaId"), ",", ".")) ;
         Z399SugerenciasMejorasPlataformaFecRegistro = localUtil.ctod( httpContext.cgiGet( "Z399SugerenciasMejorasPlataformaFecRegistro"), 0) ;
         Z61SGPacientePacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z61SGPacientePacienteId"), ",", ".")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSugerenciasMejorasPlataformaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSugerenciasMejorasPlataformaId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SUGERENCIASMEJORASPLATAFORMAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A397SugerenciasMejorasPlataformaId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
         }
         else
         {
            A397SugerenciasMejorasPlataformaId = (int)(localUtil.ctol( httpContext.cgiGet( edtSugerenciasMejorasPlataformaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSGPacientePacienteId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSGPacientePacienteId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SGPACIENTEPACIENTEID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSGPacientePacienteId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A61SGPacientePacienteId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         }
         else
         {
            A61SGPacientePacienteId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGPacientePacienteId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSugerenciasMejorasPlataformaCitaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSugerenciasMejorasPlataformaCitaId_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SUGERENCIASMEJORASPLATAFORMACITAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSugerenciasMejorasPlataformaCitaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A403SugerenciasMejorasPlataformaCitaId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A403SugerenciasMejorasPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A403SugerenciasMejorasPlataformaCitaId), 4, 0));
         }
         else
         {
            A403SugerenciasMejorasPlataformaCitaId = (short)(localUtil.ctol( httpContext.cgiGet( edtSugerenciasMejorasPlataformaCitaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A403SugerenciasMejorasPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A403SugerenciasMejorasPlataformaCitaId), 4, 0));
         }
         A400SugerenciasMejorasPlataformaOp = httpContext.cgiGet( edtSugerenciasMejorasPlataformaOp_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A400SugerenciasMejorasPlataformaOp", A400SugerenciasMejorasPlataformaOp);
         A402SugerenciasMejorasPlataformaMej = httpContext.cgiGet( edtSugerenciasMejorasPlataformaMej_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A402SugerenciasMejorasPlataformaMej", A402SugerenciasMejorasPlataformaMej);
         if ( localUtil.vcdate( httpContext.cgiGet( edtSugerenciasMejorasPlataformaFecRegistro_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "SUGERENCIASMEJORASPLATAFORMAFECREGISTRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSugerenciasMejorasPlataformaFecRegistro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A399SugerenciasMejorasPlataformaFecRegistro", localUtil.format(A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"));
         }
         else
         {
            A399SugerenciasMejorasPlataformaFecRegistro = localUtil.ctod( httpContext.cgiGet( edtSugerenciasMejorasPlataformaFecRegistro_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A399SugerenciasMejorasPlataformaFecRegistro", localUtil.format(A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"));
         }
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
            A397SugerenciasMejorasPlataformaId = (int)(GXutil.lval( httpContext.GetPar( "SugerenciasMejorasPlataformaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
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
            initAll1652( ) ;
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
      disableAttributes1652( ) ;
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

   public void resetCaption160( )
   {
   }

   public void zm1652( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z403SugerenciasMejorasPlataformaCitaId = T00163_A403SugerenciasMejorasPlataformaCitaId[0] ;
            Z399SugerenciasMejorasPlataformaFecRegistro = T00163_A399SugerenciasMejorasPlataformaFecRegistro[0] ;
            Z61SGPacientePacienteId = T00163_A61SGPacientePacienteId[0] ;
         }
         else
         {
            Z403SugerenciasMejorasPlataformaCitaId = A403SugerenciasMejorasPlataformaCitaId ;
            Z399SugerenciasMejorasPlataformaFecRegistro = A399SugerenciasMejorasPlataformaFecRegistro ;
            Z61SGPacientePacienteId = A61SGPacientePacienteId ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z397SugerenciasMejorasPlataformaId = A397SugerenciasMejorasPlataformaId ;
         Z403SugerenciasMejorasPlataformaCitaId = A403SugerenciasMejorasPlataformaCitaId ;
         Z400SugerenciasMejorasPlataformaOp = A400SugerenciasMejorasPlataformaOp ;
         Z402SugerenciasMejorasPlataformaMej = A402SugerenciasMejorasPlataformaMej ;
         Z399SugerenciasMejorasPlataformaFecRegistro = A399SugerenciasMejorasPlataformaFecRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
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

   public void load1652( )
   {
      /* Using cursor T00165 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A403SugerenciasMejorasPlataformaCitaId = T00165_A403SugerenciasMejorasPlataformaCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A403SugerenciasMejorasPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A403SugerenciasMejorasPlataformaCitaId), 4, 0));
         A400SugerenciasMejorasPlataformaOp = T00165_A400SugerenciasMejorasPlataformaOp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A400SugerenciasMejorasPlataformaOp", A400SugerenciasMejorasPlataformaOp);
         A402SugerenciasMejorasPlataformaMej = T00165_A402SugerenciasMejorasPlataformaMej[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A402SugerenciasMejorasPlataformaMej", A402SugerenciasMejorasPlataformaMej);
         A399SugerenciasMejorasPlataformaFecRegistro = T00165_A399SugerenciasMejorasPlataformaFecRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A399SugerenciasMejorasPlataformaFecRegistro", localUtil.format(A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"));
         A61SGPacientePacienteId = T00165_A61SGPacientePacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         zm1652( -2) ;
      }
      pr_default.close(3);
      onLoadActions1652( ) ;
   }

   public void onLoadActions1652( )
   {
   }

   public void checkExtendedTable1652( )
   {
      nIsDirty_52 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00164 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacientePacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A399SugerenciasMejorasPlataformaFecRegistro)) || (( GXutil.resetTime(A399SugerenciasMejorasPlataformaFecRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A399SugerenciasMejorasPlataformaFecRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Sugerencias Mejoras Plataforma Fec Registro fuera de rango", "OutOfRange", 1, "SUGERENCIASMEJORASPLATAFORMAFECREGISTRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSugerenciasMejorasPlataformaFecRegistro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1652( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( int A61SGPacientePacienteId )
   {
      /* Using cursor T00166 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacientePacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey1652( )
   {
      /* Using cursor T00167 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound52 = (short)(1) ;
      }
      else
      {
         RcdFound52 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00163 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1652( 2) ;
         RcdFound52 = (short)(1) ;
         A397SugerenciasMejorasPlataformaId = T00163_A397SugerenciasMejorasPlataformaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
         A403SugerenciasMejorasPlataformaCitaId = T00163_A403SugerenciasMejorasPlataformaCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A403SugerenciasMejorasPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A403SugerenciasMejorasPlataformaCitaId), 4, 0));
         A400SugerenciasMejorasPlataformaOp = T00163_A400SugerenciasMejorasPlataformaOp[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A400SugerenciasMejorasPlataformaOp", A400SugerenciasMejorasPlataformaOp);
         A402SugerenciasMejorasPlataformaMej = T00163_A402SugerenciasMejorasPlataformaMej[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A402SugerenciasMejorasPlataformaMej", A402SugerenciasMejorasPlataformaMej);
         A399SugerenciasMejorasPlataformaFecRegistro = T00163_A399SugerenciasMejorasPlataformaFecRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A399SugerenciasMejorasPlataformaFecRegistro", localUtil.format(A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"));
         A61SGPacientePacienteId = T00163_A61SGPacientePacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         Z397SugerenciasMejorasPlataformaId = A397SugerenciasMejorasPlataformaId ;
         sMode52 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1652( ) ;
         if ( AnyError == 1 )
         {
            RcdFound52 = (short)(0) ;
            initializeNonKey1652( ) ;
         }
         Gx_mode = sMode52 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound52 = (short)(0) ;
         initializeNonKey1652( ) ;
         sMode52 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode52 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1652( ) ;
      if ( RcdFound52 == 0 )
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
      RcdFound52 = (short)(0) ;
      /* Using cursor T00168 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00168_A397SugerenciasMejorasPlataformaId[0] < A397SugerenciasMejorasPlataformaId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00168_A397SugerenciasMejorasPlataformaId[0] > A397SugerenciasMejorasPlataformaId ) ) )
         {
            A397SugerenciasMejorasPlataformaId = T00168_A397SugerenciasMejorasPlataformaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
            RcdFound52 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound52 = (short)(0) ;
      /* Using cursor T00169 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00169_A397SugerenciasMejorasPlataformaId[0] > A397SugerenciasMejorasPlataformaId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00169_A397SugerenciasMejorasPlataformaId[0] < A397SugerenciasMejorasPlataformaId ) ) )
         {
            A397SugerenciasMejorasPlataformaId = T00169_A397SugerenciasMejorasPlataformaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
            RcdFound52 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1652( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1652( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound52 == 1 )
         {
            if ( A397SugerenciasMejorasPlataformaId != Z397SugerenciasMejorasPlataformaId )
            {
               A397SugerenciasMejorasPlataformaId = Z397SugerenciasMejorasPlataformaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SUGERENCIASMEJORASPLATAFORMAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update1652( ) ;
               GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A397SugerenciasMejorasPlataformaId != Z397SugerenciasMejorasPlataformaId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1652( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SUGERENCIASMEJORASPLATAFORMAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1652( ) ;
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
      if ( A397SugerenciasMejorasPlataformaId != Z397SugerenciasMejorasPlataformaId )
      {
         A397SugerenciasMejorasPlataformaId = Z397SugerenciasMejorasPlataformaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SUGERENCIASMEJORASPLATAFORMAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
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
      if ( RcdFound52 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "SUGERENCIASMEJORASPLATAFORMAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSugerenciasMejorasPlataformaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart1652( ) ;
      if ( RcdFound52 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1652( ) ;
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
      if ( RcdFound52 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
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
      if ( RcdFound52 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
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
      scanStart1652( ) ;
      if ( RcdFound52 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound52 != 0 )
         {
            scanNext1652( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1652( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1652( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00162 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SugerenciasMejorasPlataforma"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z403SugerenciasMejorasPlataformaCitaId != T00162_A403SugerenciasMejorasPlataformaCitaId[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z399SugerenciasMejorasPlataformaFecRegistro), GXutil.resetTime(T00162_A399SugerenciasMejorasPlataformaFecRegistro[0])) ) || ( Z61SGPacientePacienteId != T00162_A61SGPacientePacienteId[0] ) )
         {
            if ( Z403SugerenciasMejorasPlataformaCitaId != T00162_A403SugerenciasMejorasPlataformaCitaId[0] )
            {
               GXutil.writeLogln("sugerenciasmejorasplataforma:[seudo value changed for attri]"+"SugerenciasMejorasPlataformaCitaId");
               GXutil.writeLogRaw("Old: ",Z403SugerenciasMejorasPlataformaCitaId);
               GXutil.writeLogRaw("Current: ",T00162_A403SugerenciasMejorasPlataformaCitaId[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z399SugerenciasMejorasPlataformaFecRegistro), GXutil.resetTime(T00162_A399SugerenciasMejorasPlataformaFecRegistro[0])) ) )
            {
               GXutil.writeLogln("sugerenciasmejorasplataforma:[seudo value changed for attri]"+"SugerenciasMejorasPlataformaFecRegistro");
               GXutil.writeLogRaw("Old: ",Z399SugerenciasMejorasPlataformaFecRegistro);
               GXutil.writeLogRaw("Current: ",T00162_A399SugerenciasMejorasPlataformaFecRegistro[0]);
            }
            if ( Z61SGPacientePacienteId != T00162_A61SGPacientePacienteId[0] )
            {
               GXutil.writeLogln("sugerenciasmejorasplataforma:[seudo value changed for attri]"+"SGPacientePacienteId");
               GXutil.writeLogRaw("Old: ",Z61SGPacientePacienteId);
               GXutil.writeLogRaw("Current: ",T00162_A61SGPacientePacienteId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SugerenciasMejorasPlataforma"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1652( )
   {
      beforeValidate1652( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1652( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1652( 0) ;
         checkOptimisticConcurrency1652( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1652( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1652( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001610 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A403SugerenciasMejorasPlataformaCitaId), A400SugerenciasMejorasPlataformaOp, A402SugerenciasMejorasPlataformaMej, A399SugerenciasMejorasPlataformaFecRegistro, Integer.valueOf(A61SGPacientePacienteId)});
                  A397SugerenciasMejorasPlataformaId = T001610_A397SugerenciasMejorasPlataformaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SugerenciasMejorasPlataforma");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption160( ) ;
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
            load1652( ) ;
         }
         endLevel1652( ) ;
      }
      closeExtendedTableCursors1652( ) ;
   }

   public void update1652( )
   {
      beforeValidate1652( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1652( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1652( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1652( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1652( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001611 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A403SugerenciasMejorasPlataformaCitaId), A400SugerenciasMejorasPlataformaOp, A402SugerenciasMejorasPlataformaMej, A399SugerenciasMejorasPlataformaFecRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SugerenciasMejorasPlataforma");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SugerenciasMejorasPlataforma"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1652( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption160( ) ;
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
         endLevel1652( ) ;
      }
      closeExtendedTableCursors1652( ) ;
   }

   public void deferredUpdate1652( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1652( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1652( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1652( ) ;
         afterConfirm1652( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1652( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001612 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A397SugerenciasMejorasPlataformaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SugerenciasMejorasPlataforma");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound52 == 0 )
                     {
                        initAll1652( ) ;
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
                     resetCaption160( ) ;
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
      sMode52 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1652( ) ;
      Gx_mode = sMode52 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1652( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1652( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1652( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "sugerenciasmejorasplataforma");
         if ( AnyError == 0 )
         {
            confirmValues160( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "sugerenciasmejorasplataforma");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1652( )
   {
      /* Using cursor T001613 */
      pr_default.execute(11);
      RcdFound52 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A397SugerenciasMejorasPlataformaId = T001613_A397SugerenciasMejorasPlataformaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1652( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound52 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound52 = (short)(1) ;
         A397SugerenciasMejorasPlataformaId = T001613_A397SugerenciasMejorasPlataformaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
      }
   }

   public void scanEnd1652( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1652( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1652( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1652( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1652( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1652( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1652( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1652( )
   {
      edtSugerenciasMejorasPlataformaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSugerenciasMejorasPlataformaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSugerenciasMejorasPlataformaId_Enabled), 5, 0), true);
      edtSGPacientePacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGPacientePacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGPacientePacienteId_Enabled), 5, 0), true);
      edtSugerenciasMejorasPlataformaCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSugerenciasMejorasPlataformaCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSugerenciasMejorasPlataformaCitaId_Enabled), 5, 0), true);
      edtSugerenciasMejorasPlataformaOp_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSugerenciasMejorasPlataformaOp_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSugerenciasMejorasPlataformaOp_Enabled), 5, 0), true);
      edtSugerenciasMejorasPlataformaMej_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSugerenciasMejorasPlataformaMej_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSugerenciasMejorasPlataformaMej_Enabled), 5, 0), true);
      edtSugerenciasMejorasPlataformaFecRegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSugerenciasMejorasPlataformaFecRegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSugerenciasMejorasPlataformaFecRegistro_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1652( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues160( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033726", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.sugerenciasmejorasplataforma", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z397SugerenciasMejorasPlataformaId", GXutil.ltrim( localUtil.ntoc( Z397SugerenciasMejorasPlataformaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z403SugerenciasMejorasPlataformaCitaId", GXutil.ltrim( localUtil.ntoc( Z403SugerenciasMejorasPlataformaCitaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z399SugerenciasMejorasPlataformaFecRegistro", localUtil.dtoc( Z399SugerenciasMejorasPlataformaFecRegistro, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")));
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
      return formatLink("com.projectthani.sugerenciasmejorasplataforma", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "SugerenciasMejorasPlataforma" ;
   }

   public String getPgmdesc( )
   {
      return "Sugerencias Mejoras Plataforma" ;
   }

   public void initializeNonKey1652( )
   {
      A61SGPacientePacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
      A403SugerenciasMejorasPlataformaCitaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A403SugerenciasMejorasPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A403SugerenciasMejorasPlataformaCitaId), 4, 0));
      A400SugerenciasMejorasPlataformaOp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A400SugerenciasMejorasPlataformaOp", A400SugerenciasMejorasPlataformaOp);
      A402SugerenciasMejorasPlataformaMej = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A402SugerenciasMejorasPlataformaMej", A402SugerenciasMejorasPlataformaMej);
      A399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A399SugerenciasMejorasPlataformaFecRegistro", localUtil.format(A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"));
      Z403SugerenciasMejorasPlataformaCitaId = (short)(0) ;
      Z399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      Z61SGPacientePacienteId = 0 ;
   }

   public void initAll1652( )
   {
      A397SugerenciasMejorasPlataformaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A397SugerenciasMejorasPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A397SugerenciasMejorasPlataformaId), 8, 0));
      initializeNonKey1652( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033730", true, true);
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
      httpContext.AddJavascriptSource("sugerenciasmejorasplataforma.js", "?2022511033730", false, true);
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
      edtSugerenciasMejorasPlataformaId_Internalname = "SUGERENCIASMEJORASPLATAFORMAID" ;
      edtSGPacientePacienteId_Internalname = "SGPACIENTEPACIENTEID" ;
      edtSugerenciasMejorasPlataformaCitaId_Internalname = "SUGERENCIASMEJORASPLATAFORMACITAID" ;
      edtSugerenciasMejorasPlataformaOp_Internalname = "SUGERENCIASMEJORASPLATAFORMAOP" ;
      edtSugerenciasMejorasPlataformaMej_Internalname = "SUGERENCIASMEJORASPLATAFORMAMEJ" ;
      edtSugerenciasMejorasPlataformaFecRegistro_Internalname = "SUGERENCIASMEJORASPLATAFORMAFECREGISTRO" ;
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
      Form.setCaption( "Sugerencias Mejoras Plataforma" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtSugerenciasMejorasPlataformaFecRegistro_Jsonclick = "" ;
      edtSugerenciasMejorasPlataformaFecRegistro_Enabled = 1 ;
      edtSugerenciasMejorasPlataformaMej_Enabled = 1 ;
      edtSugerenciasMejorasPlataformaOp_Enabled = 1 ;
      edtSugerenciasMejorasPlataformaCitaId_Jsonclick = "" ;
      edtSugerenciasMejorasPlataformaCitaId_Enabled = 1 ;
      edtSGPacientePacienteId_Jsonclick = "" ;
      edtSGPacientePacienteId_Enabled = 1 ;
      edtSugerenciasMejorasPlataformaId_Jsonclick = "" ;
      edtSugerenciasMejorasPlataformaId_Enabled = 1 ;
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
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
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

   public void valid_Sugerenciasmejorasplataformaid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A403SugerenciasMejorasPlataformaCitaId", GXutil.ltrim( localUtil.ntoc( A403SugerenciasMejorasPlataformaCitaId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A400SugerenciasMejorasPlataformaOp", A400SugerenciasMejorasPlataformaOp);
      httpContext.ajax_rsp_assign_attri("", false, "A402SugerenciasMejorasPlataformaMej", A402SugerenciasMejorasPlataformaMej);
      httpContext.ajax_rsp_assign_attri("", false, "A399SugerenciasMejorasPlataformaFecRegistro", localUtil.format(A399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z397SugerenciasMejorasPlataformaId", GXutil.ltrim( localUtil.ntoc( Z397SugerenciasMejorasPlataformaId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z403SugerenciasMejorasPlataformaCitaId", GXutil.ltrim( localUtil.ntoc( Z403SugerenciasMejorasPlataformaCitaId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z400SugerenciasMejorasPlataformaOp", Z400SugerenciasMejorasPlataformaOp);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z402SugerenciasMejorasPlataformaMej", Z402SugerenciasMejorasPlataformaMej);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z399SugerenciasMejorasPlataformaFecRegistro", localUtil.format(Z399SugerenciasMejorasPlataformaFecRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Sgpacientepacienteid( )
   {
      /* Using cursor T001614 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacientePacienteId_Internalname ;
      }
      pr_default.close(12);
      dynload_actions( ) ;
      /*  Sending validation outputs */
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
      setEventMetadata("VALID_SUGERENCIASMEJORASPLATAFORMAID","{handler:'valid_Sugerenciasmejorasplataformaid',iparms:[{av:'A397SugerenciasMejorasPlataformaId',fld:'SUGERENCIASMEJORASPLATAFORMAID',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_SUGERENCIASMEJORASPLATAFORMAID",",oparms:[{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'},{av:'A403SugerenciasMejorasPlataformaCitaId',fld:'SUGERENCIASMEJORASPLATAFORMACITAID',pic:'ZZZ9'},{av:'A400SugerenciasMejorasPlataformaOp',fld:'SUGERENCIASMEJORASPLATAFORMAOP',pic:''},{av:'A402SugerenciasMejorasPlataformaMej',fld:'SUGERENCIASMEJORASPLATAFORMAMEJ',pic:''},{av:'A399SugerenciasMejorasPlataformaFecRegistro',fld:'SUGERENCIASMEJORASPLATAFORMAFECREGISTRO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z397SugerenciasMejorasPlataformaId'},{av:'Z61SGPacientePacienteId'},{av:'Z403SugerenciasMejorasPlataformaCitaId'},{av:'Z400SugerenciasMejorasPlataformaOp'},{av:'Z402SugerenciasMejorasPlataformaMej'},{av:'Z399SugerenciasMejorasPlataformaFecRegistro'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_SGPACIENTEPACIENTEID","{handler:'valid_Sgpacientepacienteid',iparms:[{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_SGPACIENTEPACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_SUGERENCIASMEJORASPLATAFORMAFECREGISTRO","{handler:'valid_Sugerenciasmejorasplataformafecregistro',iparms:[]");
      setEventMetadata("VALID_SUGERENCIASMEJORASPLATAFORMAFECREGISTRO",",oparms:[]}");
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
      pr_default.close(12);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A400SugerenciasMejorasPlataformaOp = "" ;
      A402SugerenciasMejorasPlataformaMej = "" ;
      A399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
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
      Z400SugerenciasMejorasPlataformaOp = "" ;
      Z402SugerenciasMejorasPlataformaMej = "" ;
      T00165_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T00165_A403SugerenciasMejorasPlataformaCitaId = new short[1] ;
      T00165_A400SugerenciasMejorasPlataformaOp = new String[] {""} ;
      T00165_A402SugerenciasMejorasPlataformaMej = new String[] {""} ;
      T00165_A399SugerenciasMejorasPlataformaFecRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00165_A61SGPacientePacienteId = new int[1] ;
      T00164_A61SGPacientePacienteId = new int[1] ;
      T00166_A61SGPacientePacienteId = new int[1] ;
      T00167_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T00163_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T00163_A403SugerenciasMejorasPlataformaCitaId = new short[1] ;
      T00163_A400SugerenciasMejorasPlataformaOp = new String[] {""} ;
      T00163_A402SugerenciasMejorasPlataformaMej = new String[] {""} ;
      T00163_A399SugerenciasMejorasPlataformaFecRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00163_A61SGPacientePacienteId = new int[1] ;
      sMode52 = "" ;
      T00168_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T00169_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T00162_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T00162_A403SugerenciasMejorasPlataformaCitaId = new short[1] ;
      T00162_A400SugerenciasMejorasPlataformaOp = new String[] {""} ;
      T00162_A402SugerenciasMejorasPlataformaMej = new String[] {""} ;
      T00162_A399SugerenciasMejorasPlataformaFecRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00162_A61SGPacientePacienteId = new int[1] ;
      T001610_A397SugerenciasMejorasPlataformaId = new int[1] ;
      T001613_A397SugerenciasMejorasPlataformaId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ400SugerenciasMejorasPlataformaOp = "" ;
      ZZ402SugerenciasMejorasPlataformaMej = "" ;
      ZZ399SugerenciasMejorasPlataformaFecRegistro = GXutil.nullDate() ;
      T001614_A61SGPacientePacienteId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.sugerenciasmejorasplataforma__default(),
         new Object[] {
             new Object[] {
            T00162_A397SugerenciasMejorasPlataformaId, T00162_A403SugerenciasMejorasPlataformaCitaId, T00162_A400SugerenciasMejorasPlataformaOp, T00162_A402SugerenciasMejorasPlataformaMej, T00162_A399SugerenciasMejorasPlataformaFecRegistro, T00162_A61SGPacientePacienteId
            }
            , new Object[] {
            T00163_A397SugerenciasMejorasPlataformaId, T00163_A403SugerenciasMejorasPlataformaCitaId, T00163_A400SugerenciasMejorasPlataformaOp, T00163_A402SugerenciasMejorasPlataformaMej, T00163_A399SugerenciasMejorasPlataformaFecRegistro, T00163_A61SGPacientePacienteId
            }
            , new Object[] {
            T00164_A61SGPacientePacienteId
            }
            , new Object[] {
            T00165_A397SugerenciasMejorasPlataformaId, T00165_A403SugerenciasMejorasPlataformaCitaId, T00165_A400SugerenciasMejorasPlataformaOp, T00165_A402SugerenciasMejorasPlataformaMej, T00165_A399SugerenciasMejorasPlataformaFecRegistro, T00165_A61SGPacientePacienteId
            }
            , new Object[] {
            T00166_A61SGPacientePacienteId
            }
            , new Object[] {
            T00167_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            T00168_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            T00169_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            T001610_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001613_A397SugerenciasMejorasPlataformaId
            }
            , new Object[] {
            T001614_A61SGPacientePacienteId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z403SugerenciasMejorasPlataformaCitaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A403SugerenciasMejorasPlataformaCitaId ;
   private short RcdFound52 ;
   private short nIsDirty_52 ;
   private short ZZ403SugerenciasMejorasPlataformaCitaId ;
   private int Z397SugerenciasMejorasPlataformaId ;
   private int Z61SGPacientePacienteId ;
   private int A61SGPacientePacienteId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int A397SugerenciasMejorasPlataformaId ;
   private int edtSugerenciasMejorasPlataformaId_Enabled ;
   private int edtSGPacientePacienteId_Enabled ;
   private int edtSugerenciasMejorasPlataformaCitaId_Enabled ;
   private int edtSugerenciasMejorasPlataformaOp_Enabled ;
   private int edtSugerenciasMejorasPlataformaMej_Enabled ;
   private int edtSugerenciasMejorasPlataformaFecRegistro_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ397SugerenciasMejorasPlataformaId ;
   private int ZZ61SGPacientePacienteId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSugerenciasMejorasPlataformaId_Internalname ;
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
   private String edtSugerenciasMejorasPlataformaId_Jsonclick ;
   private String edtSGPacientePacienteId_Internalname ;
   private String edtSGPacientePacienteId_Jsonclick ;
   private String edtSugerenciasMejorasPlataformaCitaId_Internalname ;
   private String edtSugerenciasMejorasPlataformaCitaId_Jsonclick ;
   private String edtSugerenciasMejorasPlataformaOp_Internalname ;
   private String edtSugerenciasMejorasPlataformaMej_Internalname ;
   private String edtSugerenciasMejorasPlataformaFecRegistro_Internalname ;
   private String edtSugerenciasMejorasPlataformaFecRegistro_Jsonclick ;
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
   private String sMode52 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z399SugerenciasMejorasPlataformaFecRegistro ;
   private java.util.Date A399SugerenciasMejorasPlataformaFecRegistro ;
   private java.util.Date ZZ399SugerenciasMejorasPlataformaFecRegistro ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String A400SugerenciasMejorasPlataformaOp ;
   private String A402SugerenciasMejorasPlataformaMej ;
   private String Z400SugerenciasMejorasPlataformaOp ;
   private String Z402SugerenciasMejorasPlataformaMej ;
   private String ZZ400SugerenciasMejorasPlataformaOp ;
   private String ZZ402SugerenciasMejorasPlataformaMej ;
   private IDataStoreProvider pr_default ;
   private int[] T00165_A397SugerenciasMejorasPlataformaId ;
   private short[] T00165_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] T00165_A400SugerenciasMejorasPlataformaOp ;
   private String[] T00165_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] T00165_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] T00165_A61SGPacientePacienteId ;
   private int[] T00164_A61SGPacientePacienteId ;
   private int[] T00166_A61SGPacientePacienteId ;
   private int[] T00167_A397SugerenciasMejorasPlataformaId ;
   private int[] T00163_A397SugerenciasMejorasPlataformaId ;
   private short[] T00163_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] T00163_A400SugerenciasMejorasPlataformaOp ;
   private String[] T00163_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] T00163_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] T00163_A61SGPacientePacienteId ;
   private int[] T00168_A397SugerenciasMejorasPlataformaId ;
   private int[] T00169_A397SugerenciasMejorasPlataformaId ;
   private int[] T00162_A397SugerenciasMejorasPlataformaId ;
   private short[] T00162_A403SugerenciasMejorasPlataformaCitaId ;
   private String[] T00162_A400SugerenciasMejorasPlataformaOp ;
   private String[] T00162_A402SugerenciasMejorasPlataformaMej ;
   private java.util.Date[] T00162_A399SugerenciasMejorasPlataformaFecRegistro ;
   private int[] T00162_A61SGPacientePacienteId ;
   private int[] T001610_A397SugerenciasMejorasPlataformaId ;
   private int[] T001613_A397SugerenciasMejorasPlataformaId ;
   private int[] T001614_A61SGPacientePacienteId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class sugerenciasmejorasplataforma__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00162", "SELECT [SugerenciasMejorasPlataformaId], [SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] WITH (UPDLOCK) WHERE [SugerenciasMejorasPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00163", "SELECT [SugerenciasMejorasPlataformaId], [SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] WHERE [SugerenciasMejorasPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00164", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00165", "SELECT TM1.[SugerenciasMejorasPlataformaId], TM1.[SugerenciasMejorasPlataformaCitaId], TM1.[SugerenciasMejorasPlataformaOp], TM1.[SugerenciasMejorasPlataformaMej], TM1.[SugerenciasMejorasPlataformaFecRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [SugerenciasMejorasPlataforma] TM1 WHERE TM1.[SugerenciasMejorasPlataformaId] = ? ORDER BY TM1.[SugerenciasMejorasPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00166", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00167", "SELECT [SugerenciasMejorasPlataformaId] FROM [SugerenciasMejorasPlataforma] WHERE [SugerenciasMejorasPlataformaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00168", "SELECT TOP 1 [SugerenciasMejorasPlataformaId] FROM [SugerenciasMejorasPlataforma] WHERE ( [SugerenciasMejorasPlataformaId] > ?) ORDER BY [SugerenciasMejorasPlataformaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00169", "SELECT TOP 1 [SugerenciasMejorasPlataformaId] FROM [SugerenciasMejorasPlataforma] WHERE ( [SugerenciasMejorasPlataformaId] < ?) ORDER BY [SugerenciasMejorasPlataformaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001610", "INSERT INTO [SugerenciasMejorasPlataforma]([SugerenciasMejorasPlataformaCitaId], [SugerenciasMejorasPlataformaOp], [SugerenciasMejorasPlataformaMej], [SugerenciasMejorasPlataformaFecRegistro], [SGPacientePacienteId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T001611", "UPDATE [SugerenciasMejorasPlataforma] SET [SugerenciasMejorasPlataformaCitaId]=?, [SugerenciasMejorasPlataformaOp]=?, [SugerenciasMejorasPlataformaMej]=?, [SugerenciasMejorasPlataformaFecRegistro]=?, [SGPacientePacienteId]=?  WHERE [SugerenciasMejorasPlataformaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001612", "DELETE FROM [SugerenciasMejorasPlataforma]  WHERE [SugerenciasMejorasPlataformaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001613", "SELECT [SugerenciasMejorasPlataformaId] FROM [SugerenciasMejorasPlataforma] ORDER BY [SugerenciasMejorasPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001614", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

