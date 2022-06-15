package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class comentarioprofesional_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_4") == 0 )
      {
         A62SGProfesionalProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "SGProfesionalProfesionalId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A62SGProfesionalProfesionalId) ;
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
         Form.getMeta().addItem("description", "Comentario Profesional", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtComentarioProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public comentarioprofesional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public comentarioprofesional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( comentarioprofesional_impl.class ));
   }

   public comentarioprofesional_impl( int remoteHandle ,
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Comentario Profesional", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_ComentarioProfesional.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_ComentarioProfesional.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComentarioProfesionalId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtComentarioProfesionalId_Internalname, "Profesional Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtComentarioProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A63ComentarioProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtComentarioProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComentarioProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComentarioProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_ComentarioProfesional.htm");
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
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGPacientePacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGPacientePacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGPacientePacienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGPacientePacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSGProfesionalProfesionalId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSGProfesionalProfesionalId_Internalname, "Profesional Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGProfesionalProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGProfesionalProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGProfesionalProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGProfesionalProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComentarioProfesionalCitaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtComentarioProfesionalCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtComentarioProfesionalCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A384ComentarioProfesionalCitaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtComentarioProfesionalCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A384ComentarioProfesionalCitaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A384ComentarioProfesionalCitaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComentarioProfesionalCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComentarioProfesionalCitaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComentarioProfesionalComentario_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtComentarioProfesionalComentario_Internalname, "Profesional Comentario", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtComentarioProfesionalComentario_Internalname, A385ComentarioProfesionalComentario, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", (short)(0), 1, edtComentarioProfesionalComentario_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtComentarioProfesionalFechaRegistro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtComentarioProfesionalFechaRegistro_Internalname, "Fecha Registro", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtComentarioProfesionalFechaRegistro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtComentarioProfesionalFechaRegistro_Internalname, localUtil.format(A386ComentarioProfesionalFechaRegistro, "99/99/99"), localUtil.format( A386ComentarioProfesionalFechaRegistro, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtComentarioProfesionalFechaRegistro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtComentarioProfesionalFechaRegistro_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtComentarioProfesionalFechaRegistro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtComentarioProfesionalFechaRegistro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ComentarioProfesional.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ComentarioProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ComentarioProfesional.htm");
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
         Z63ComentarioProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z63ComentarioProfesionalId"), ",", ".")) ;
         Z384ComentarioProfesionalCitaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z384ComentarioProfesionalCitaId"), ",", ".")) ;
         Z386ComentarioProfesionalFechaRegistro = localUtil.ctod( httpContext.cgiGet( "Z386ComentarioProfesionalFechaRegistro"), 0) ;
         Z61SGPacientePacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z61SGPacientePacienteId"), ",", ".")) ;
         Z62SGProfesionalProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z62SGProfesionalProfesionalId"), ",", ".")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtComentarioProfesionalId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtComentarioProfesionalId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "COMENTARIOPROFESIONALID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtComentarioProfesionalId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A63ComentarioProfesionalId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
         }
         else
         {
            A63ComentarioProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtComentarioProfesionalId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSGProfesionalProfesionalId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSGProfesionalProfesionalId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SGPROFESIONALPROFESIONALID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSGProfesionalProfesionalId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A62SGProfesionalProfesionalId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), 8, 0));
         }
         else
         {
            A62SGProfesionalProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtSGProfesionalProfesionalId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), 8, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtComentarioProfesionalCitaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtComentarioProfesionalCitaId_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "COMENTARIOPROFESIONALCITAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtComentarioProfesionalCitaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A384ComentarioProfesionalCitaId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A384ComentarioProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384ComentarioProfesionalCitaId), 4, 0));
         }
         else
         {
            A384ComentarioProfesionalCitaId = (short)(localUtil.ctol( httpContext.cgiGet( edtComentarioProfesionalCitaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A384ComentarioProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384ComentarioProfesionalCitaId), 4, 0));
         }
         A385ComentarioProfesionalComentario = httpContext.cgiGet( edtComentarioProfesionalComentario_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A385ComentarioProfesionalComentario", A385ComentarioProfesionalComentario);
         if ( localUtil.vcdate( httpContext.cgiGet( edtComentarioProfesionalFechaRegistro_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "COMENTARIOPROFESIONALFECHAREGISTRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtComentarioProfesionalFechaRegistro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A386ComentarioProfesionalFechaRegistro", localUtil.format(A386ComentarioProfesionalFechaRegistro, "99/99/99"));
         }
         else
         {
            A386ComentarioProfesionalFechaRegistro = localUtil.ctod( httpContext.cgiGet( edtComentarioProfesionalFechaRegistro_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A386ComentarioProfesionalFechaRegistro", localUtil.format(A386ComentarioProfesionalFechaRegistro, "99/99/99"));
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
            A63ComentarioProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ComentarioProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
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
            initAll1551( ) ;
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
      disableAttributes1551( ) ;
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

   public void resetCaption150( )
   {
   }

   public void zm1551( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z384ComentarioProfesionalCitaId = T00153_A384ComentarioProfesionalCitaId[0] ;
            Z386ComentarioProfesionalFechaRegistro = T00153_A386ComentarioProfesionalFechaRegistro[0] ;
            Z61SGPacientePacienteId = T00153_A61SGPacientePacienteId[0] ;
            Z62SGProfesionalProfesionalId = T00153_A62SGProfesionalProfesionalId[0] ;
         }
         else
         {
            Z384ComentarioProfesionalCitaId = A384ComentarioProfesionalCitaId ;
            Z386ComentarioProfesionalFechaRegistro = A386ComentarioProfesionalFechaRegistro ;
            Z61SGPacientePacienteId = A61SGPacientePacienteId ;
            Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z63ComentarioProfesionalId = A63ComentarioProfesionalId ;
         Z384ComentarioProfesionalCitaId = A384ComentarioProfesionalCitaId ;
         Z385ComentarioProfesionalComentario = A385ComentarioProfesionalComentario ;
         Z386ComentarioProfesionalFechaRegistro = A386ComentarioProfesionalFechaRegistro ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
         Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
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

   public void load1551( )
   {
      /* Using cursor T00156 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A384ComentarioProfesionalCitaId = T00156_A384ComentarioProfesionalCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A384ComentarioProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384ComentarioProfesionalCitaId), 4, 0));
         A385ComentarioProfesionalComentario = T00156_A385ComentarioProfesionalComentario[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A385ComentarioProfesionalComentario", A385ComentarioProfesionalComentario);
         A386ComentarioProfesionalFechaRegistro = T00156_A386ComentarioProfesionalFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A386ComentarioProfesionalFechaRegistro", localUtil.format(A386ComentarioProfesionalFechaRegistro, "99/99/99"));
         A61SGPacientePacienteId = T00156_A61SGPacientePacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         A62SGProfesionalProfesionalId = T00156_A62SGProfesionalProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), 8, 0));
         zm1551( -2) ;
      }
      pr_default.close(4);
      onLoadActions1551( ) ;
   }

   public void onLoadActions1551( )
   {
   }

   public void checkExtendedTable1551( )
   {
      nIsDirty_51 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00154 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacientePacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T00155 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A62SGProfesionalProfesionalId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGProfesional'.", "ForeignKeyNotFound", 1, "SGPROFESIONALPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGProfesionalProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A386ComentarioProfesionalFechaRegistro)) || (( GXutil.resetTime(A386ComentarioProfesionalFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A386ComentarioProfesionalFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Comentario Profesional Fecha Registro fuera de rango", "OutOfRange", 1, "COMENTARIOPROFESIONALFECHAREGISTRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtComentarioProfesionalFechaRegistro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1551( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( int A61SGPacientePacienteId )
   {
      /* Using cursor T00157 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacientePacienteId_Internalname ;
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

   public void gxload_4( int A62SGProfesionalProfesionalId )
   {
      /* Using cursor T00158 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A62SGProfesionalProfesionalId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGProfesional'.", "ForeignKeyNotFound", 1, "SGPROFESIONALPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGProfesionalProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey1551( )
   {
      /* Using cursor T00159 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound51 = (short)(1) ;
      }
      else
      {
         RcdFound51 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00153 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1551( 2) ;
         RcdFound51 = (short)(1) ;
         A63ComentarioProfesionalId = T00153_A63ComentarioProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
         A384ComentarioProfesionalCitaId = T00153_A384ComentarioProfesionalCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A384ComentarioProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384ComentarioProfesionalCitaId), 4, 0));
         A385ComentarioProfesionalComentario = T00153_A385ComentarioProfesionalComentario[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A385ComentarioProfesionalComentario", A385ComentarioProfesionalComentario);
         A386ComentarioProfesionalFechaRegistro = T00153_A386ComentarioProfesionalFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A386ComentarioProfesionalFechaRegistro", localUtil.format(A386ComentarioProfesionalFechaRegistro, "99/99/99"));
         A61SGPacientePacienteId = T00153_A61SGPacientePacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         A62SGProfesionalProfesionalId = T00153_A62SGProfesionalProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), 8, 0));
         Z63ComentarioProfesionalId = A63ComentarioProfesionalId ;
         sMode51 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1551( ) ;
         if ( AnyError == 1 )
         {
            RcdFound51 = (short)(0) ;
            initializeNonKey1551( ) ;
         }
         Gx_mode = sMode51 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound51 = (short)(0) ;
         initializeNonKey1551( ) ;
         sMode51 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode51 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1551( ) ;
      if ( RcdFound51 == 0 )
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
      RcdFound51 = (short)(0) ;
      /* Using cursor T001510 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T001510_A63ComentarioProfesionalId[0] < A63ComentarioProfesionalId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T001510_A63ComentarioProfesionalId[0] > A63ComentarioProfesionalId ) ) )
         {
            A63ComentarioProfesionalId = T001510_A63ComentarioProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
            RcdFound51 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound51 = (short)(0) ;
      /* Using cursor T001511 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001511_A63ComentarioProfesionalId[0] > A63ComentarioProfesionalId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001511_A63ComentarioProfesionalId[0] < A63ComentarioProfesionalId ) ) )
         {
            A63ComentarioProfesionalId = T001511_A63ComentarioProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
            RcdFound51 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1551( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtComentarioProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1551( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound51 == 1 )
         {
            if ( A63ComentarioProfesionalId != Z63ComentarioProfesionalId )
            {
               A63ComentarioProfesionalId = Z63ComentarioProfesionalId ;
               httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "COMENTARIOPROFESIONALID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtComentarioProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtComentarioProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update1551( ) ;
               GX_FocusControl = edtComentarioProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A63ComentarioProfesionalId != Z63ComentarioProfesionalId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtComentarioProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1551( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "COMENTARIOPROFESIONALID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtComentarioProfesionalId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtComentarioProfesionalId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1551( ) ;
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
      if ( A63ComentarioProfesionalId != Z63ComentarioProfesionalId )
      {
         A63ComentarioProfesionalId = Z63ComentarioProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "COMENTARIOPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtComentarioProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtComentarioProfesionalId_Internalname ;
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
      if ( RcdFound51 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "COMENTARIOPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtComentarioProfesionalId_Internalname ;
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
      scanStart1551( ) ;
      if ( RcdFound51 == 0 )
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
      scanEnd1551( ) ;
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
      if ( RcdFound51 == 0 )
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
      if ( RcdFound51 == 0 )
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
      scanStart1551( ) ;
      if ( RcdFound51 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound51 != 0 )
         {
            scanNext1551( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1551( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1551( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00152 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ComentarioProfesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z384ComentarioProfesionalCitaId != T00152_A384ComentarioProfesionalCitaId[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z386ComentarioProfesionalFechaRegistro), GXutil.resetTime(T00152_A386ComentarioProfesionalFechaRegistro[0])) ) || ( Z61SGPacientePacienteId != T00152_A61SGPacientePacienteId[0] ) || ( Z62SGProfesionalProfesionalId != T00152_A62SGProfesionalProfesionalId[0] ) )
         {
            if ( Z384ComentarioProfesionalCitaId != T00152_A384ComentarioProfesionalCitaId[0] )
            {
               GXutil.writeLogln("comentarioprofesional:[seudo value changed for attri]"+"ComentarioProfesionalCitaId");
               GXutil.writeLogRaw("Old: ",Z384ComentarioProfesionalCitaId);
               GXutil.writeLogRaw("Current: ",T00152_A384ComentarioProfesionalCitaId[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z386ComentarioProfesionalFechaRegistro), GXutil.resetTime(T00152_A386ComentarioProfesionalFechaRegistro[0])) ) )
            {
               GXutil.writeLogln("comentarioprofesional:[seudo value changed for attri]"+"ComentarioProfesionalFechaRegistro");
               GXutil.writeLogRaw("Old: ",Z386ComentarioProfesionalFechaRegistro);
               GXutil.writeLogRaw("Current: ",T00152_A386ComentarioProfesionalFechaRegistro[0]);
            }
            if ( Z61SGPacientePacienteId != T00152_A61SGPacientePacienteId[0] )
            {
               GXutil.writeLogln("comentarioprofesional:[seudo value changed for attri]"+"SGPacientePacienteId");
               GXutil.writeLogRaw("Old: ",Z61SGPacientePacienteId);
               GXutil.writeLogRaw("Current: ",T00152_A61SGPacientePacienteId[0]);
            }
            if ( Z62SGProfesionalProfesionalId != T00152_A62SGProfesionalProfesionalId[0] )
            {
               GXutil.writeLogln("comentarioprofesional:[seudo value changed for attri]"+"SGProfesionalProfesionalId");
               GXutil.writeLogRaw("Old: ",Z62SGProfesionalProfesionalId);
               GXutil.writeLogRaw("Current: ",T00152_A62SGProfesionalProfesionalId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ComentarioProfesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1551( )
   {
      beforeValidate1551( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1551( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1551( 0) ;
         checkOptimisticConcurrency1551( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1551( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1551( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001512 */
                  pr_default.execute(10, new Object[] {Short.valueOf(A384ComentarioProfesionalCitaId), A385ComentarioProfesionalComentario, A386ComentarioProfesionalFechaRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A62SGProfesionalProfesionalId)});
                  A63ComentarioProfesionalId = T001512_A63ComentarioProfesionalId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ComentarioProfesional");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption150( ) ;
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
            load1551( ) ;
         }
         endLevel1551( ) ;
      }
      closeExtendedTableCursors1551( ) ;
   }

   public void update1551( )
   {
      beforeValidate1551( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1551( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1551( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1551( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1551( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001513 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A384ComentarioProfesionalCitaId), A385ComentarioProfesionalComentario, A386ComentarioProfesionalFechaRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A62SGProfesionalProfesionalId), Integer.valueOf(A63ComentarioProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ComentarioProfesional");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ComentarioProfesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1551( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption150( ) ;
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
         endLevel1551( ) ;
      }
      closeExtendedTableCursors1551( ) ;
   }

   public void deferredUpdate1551( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1551( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1551( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1551( ) ;
         afterConfirm1551( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1551( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001514 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A63ComentarioProfesionalId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ComentarioProfesional");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound51 == 0 )
                     {
                        initAll1551( ) ;
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
                     resetCaption150( ) ;
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
      sMode51 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1551( ) ;
      Gx_mode = sMode51 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1551( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1551( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1551( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "comentarioprofesional");
         if ( AnyError == 0 )
         {
            confirmValues150( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "comentarioprofesional");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1551( )
   {
      /* Using cursor T001515 */
      pr_default.execute(13);
      RcdFound51 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A63ComentarioProfesionalId = T001515_A63ComentarioProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1551( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound51 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A63ComentarioProfesionalId = T001515_A63ComentarioProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
      }
   }

   public void scanEnd1551( )
   {
      pr_default.close(13);
   }

   public void afterConfirm1551( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1551( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1551( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1551( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1551( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1551( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1551( )
   {
      edtComentarioProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComentarioProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComentarioProfesionalId_Enabled), 5, 0), true);
      edtSGPacientePacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGPacientePacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGPacientePacienteId_Enabled), 5, 0), true);
      edtSGProfesionalProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGProfesionalProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGProfesionalProfesionalId_Enabled), 5, 0), true);
      edtComentarioProfesionalCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComentarioProfesionalCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComentarioProfesionalCitaId_Enabled), 5, 0), true);
      edtComentarioProfesionalComentario_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComentarioProfesionalComentario_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComentarioProfesionalComentario_Enabled), 5, 0), true);
      edtComentarioProfesionalFechaRegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtComentarioProfesionalFechaRegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtComentarioProfesionalFechaRegistro_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1551( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues150( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033927", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.comentarioprofesional", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z63ComentarioProfesionalId", GXutil.ltrim( localUtil.ntoc( Z63ComentarioProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z384ComentarioProfesionalCitaId", GXutil.ltrim( localUtil.ntoc( Z384ComentarioProfesionalCitaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z386ComentarioProfesionalFechaRegistro", localUtil.dtoc( Z386ComentarioProfesionalFechaRegistro, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z62SGProfesionalProfesionalId", GXutil.ltrim( localUtil.ntoc( Z62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ",", "")));
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
      return formatLink("com.projectthani.comentarioprofesional", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "ComentarioProfesional" ;
   }

   public String getPgmdesc( )
   {
      return "Comentario Profesional" ;
   }

   public void initializeNonKey1551( )
   {
      A61SGPacientePacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
      A62SGProfesionalProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), 8, 0));
      A384ComentarioProfesionalCitaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A384ComentarioProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A384ComentarioProfesionalCitaId), 4, 0));
      A385ComentarioProfesionalComentario = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A385ComentarioProfesionalComentario", A385ComentarioProfesionalComentario);
      A386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A386ComentarioProfesionalFechaRegistro", localUtil.format(A386ComentarioProfesionalFechaRegistro, "99/99/99"));
      Z384ComentarioProfesionalCitaId = (short)(0) ;
      Z386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      Z61SGPacientePacienteId = 0 ;
      Z62SGProfesionalProfesionalId = 0 ;
   }

   public void initAll1551( )
   {
      A63ComentarioProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A63ComentarioProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A63ComentarioProfesionalId), 8, 0));
      initializeNonKey1551( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033931", true, true);
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
      httpContext.AddJavascriptSource("comentarioprofesional.js", "?2022511033931", false, true);
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
      edtComentarioProfesionalId_Internalname = "COMENTARIOPROFESIONALID" ;
      edtSGPacientePacienteId_Internalname = "SGPACIENTEPACIENTEID" ;
      edtSGProfesionalProfesionalId_Internalname = "SGPROFESIONALPROFESIONALID" ;
      edtComentarioProfesionalCitaId_Internalname = "COMENTARIOPROFESIONALCITAID" ;
      edtComentarioProfesionalComentario_Internalname = "COMENTARIOPROFESIONALCOMENTARIO" ;
      edtComentarioProfesionalFechaRegistro_Internalname = "COMENTARIOPROFESIONALFECHAREGISTRO" ;
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
      Form.setCaption( "Comentario Profesional" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtComentarioProfesionalFechaRegistro_Jsonclick = "" ;
      edtComentarioProfesionalFechaRegistro_Enabled = 1 ;
      edtComentarioProfesionalComentario_Enabled = 1 ;
      edtComentarioProfesionalCitaId_Jsonclick = "" ;
      edtComentarioProfesionalCitaId_Enabled = 1 ;
      edtSGProfesionalProfesionalId_Jsonclick = "" ;
      edtSGProfesionalProfesionalId_Enabled = 1 ;
      edtSGPacientePacienteId_Jsonclick = "" ;
      edtSGPacientePacienteId_Enabled = 1 ;
      edtComentarioProfesionalId_Jsonclick = "" ;
      edtComentarioProfesionalId_Enabled = 1 ;
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

   public void valid_Comentarioprofesionalid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrim( localUtil.ntoc( A62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A384ComentarioProfesionalCitaId", GXutil.ltrim( localUtil.ntoc( A384ComentarioProfesionalCitaId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A385ComentarioProfesionalComentario", A385ComentarioProfesionalComentario);
      httpContext.ajax_rsp_assign_attri("", false, "A386ComentarioProfesionalFechaRegistro", localUtil.format(A386ComentarioProfesionalFechaRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z63ComentarioProfesionalId", GXutil.ltrim( localUtil.ntoc( Z63ComentarioProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z62SGProfesionalProfesionalId", GXutil.ltrim( localUtil.ntoc( Z62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z384ComentarioProfesionalCitaId", GXutil.ltrim( localUtil.ntoc( Z384ComentarioProfesionalCitaId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z385ComentarioProfesionalComentario", Z385ComentarioProfesionalComentario);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z386ComentarioProfesionalFechaRegistro", localUtil.format(Z386ComentarioProfesionalFechaRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Sgpacientepacienteid( )
   {
      /* Using cursor T001516 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacientePacienteId_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Sgprofesionalprofesionalid( )
   {
      /* Using cursor T001517 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A62SGProfesionalProfesionalId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGProfesional'.", "ForeignKeyNotFound", 1, "SGPROFESIONALPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGProfesionalProfesionalId_Internalname ;
      }
      pr_default.close(15);
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
      setEventMetadata("VALID_COMENTARIOPROFESIONALID","{handler:'valid_Comentarioprofesionalid',iparms:[{av:'A63ComentarioProfesionalId',fld:'COMENTARIOPROFESIONALID',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_COMENTARIOPROFESIONALID",",oparms:[{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'},{av:'A62SGProfesionalProfesionalId',fld:'SGPROFESIONALPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A384ComentarioProfesionalCitaId',fld:'COMENTARIOPROFESIONALCITAID',pic:'ZZZ9'},{av:'A385ComentarioProfesionalComentario',fld:'COMENTARIOPROFESIONALCOMENTARIO',pic:''},{av:'A386ComentarioProfesionalFechaRegistro',fld:'COMENTARIOPROFESIONALFECHAREGISTRO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z63ComentarioProfesionalId'},{av:'Z61SGPacientePacienteId'},{av:'Z62SGProfesionalProfesionalId'},{av:'Z384ComentarioProfesionalCitaId'},{av:'Z385ComentarioProfesionalComentario'},{av:'Z386ComentarioProfesionalFechaRegistro'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_SGPACIENTEPACIENTEID","{handler:'valid_Sgpacientepacienteid',iparms:[{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_SGPACIENTEPACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_SGPROFESIONALPROFESIONALID","{handler:'valid_Sgprofesionalprofesionalid',iparms:[{av:'A62SGProfesionalProfesionalId',fld:'SGPROFESIONALPROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_SGPROFESIONALPROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_COMENTARIOPROFESIONALFECHAREGISTRO","{handler:'valid_Comentarioprofesionalfecharegistro',iparms:[]");
      setEventMetadata("VALID_COMENTARIOPROFESIONALFECHAREGISTRO",",oparms:[]}");
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
      Z386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
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
      A385ComentarioProfesionalComentario = "" ;
      A386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
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
      Z385ComentarioProfesionalComentario = "" ;
      T00156_A63ComentarioProfesionalId = new int[1] ;
      T00156_A384ComentarioProfesionalCitaId = new short[1] ;
      T00156_A385ComentarioProfesionalComentario = new String[] {""} ;
      T00156_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00156_A61SGPacientePacienteId = new int[1] ;
      T00156_A62SGProfesionalProfesionalId = new int[1] ;
      T00154_A61SGPacientePacienteId = new int[1] ;
      T00155_A62SGProfesionalProfesionalId = new int[1] ;
      T00157_A61SGPacientePacienteId = new int[1] ;
      T00158_A62SGProfesionalProfesionalId = new int[1] ;
      T00159_A63ComentarioProfesionalId = new int[1] ;
      T00153_A63ComentarioProfesionalId = new int[1] ;
      T00153_A384ComentarioProfesionalCitaId = new short[1] ;
      T00153_A385ComentarioProfesionalComentario = new String[] {""} ;
      T00153_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00153_A61SGPacientePacienteId = new int[1] ;
      T00153_A62SGProfesionalProfesionalId = new int[1] ;
      sMode51 = "" ;
      T001510_A63ComentarioProfesionalId = new int[1] ;
      T001511_A63ComentarioProfesionalId = new int[1] ;
      T00152_A63ComentarioProfesionalId = new int[1] ;
      T00152_A384ComentarioProfesionalCitaId = new short[1] ;
      T00152_A385ComentarioProfesionalComentario = new String[] {""} ;
      T00152_A386ComentarioProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00152_A61SGPacientePacienteId = new int[1] ;
      T00152_A62SGProfesionalProfesionalId = new int[1] ;
      T001512_A63ComentarioProfesionalId = new int[1] ;
      T001515_A63ComentarioProfesionalId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ385ComentarioProfesionalComentario = "" ;
      ZZ386ComentarioProfesionalFechaRegistro = GXutil.nullDate() ;
      T001516_A61SGPacientePacienteId = new int[1] ;
      T001517_A62SGProfesionalProfesionalId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.comentarioprofesional__default(),
         new Object[] {
             new Object[] {
            T00152_A63ComentarioProfesionalId, T00152_A384ComentarioProfesionalCitaId, T00152_A385ComentarioProfesionalComentario, T00152_A386ComentarioProfesionalFechaRegistro, T00152_A61SGPacientePacienteId, T00152_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            T00153_A63ComentarioProfesionalId, T00153_A384ComentarioProfesionalCitaId, T00153_A385ComentarioProfesionalComentario, T00153_A386ComentarioProfesionalFechaRegistro, T00153_A61SGPacientePacienteId, T00153_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            T00154_A61SGPacientePacienteId
            }
            , new Object[] {
            T00155_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            T00156_A63ComentarioProfesionalId, T00156_A384ComentarioProfesionalCitaId, T00156_A385ComentarioProfesionalComentario, T00156_A386ComentarioProfesionalFechaRegistro, T00156_A61SGPacientePacienteId, T00156_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            T00157_A61SGPacientePacienteId
            }
            , new Object[] {
            T00158_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            T00159_A63ComentarioProfesionalId
            }
            , new Object[] {
            T001510_A63ComentarioProfesionalId
            }
            , new Object[] {
            T001511_A63ComentarioProfesionalId
            }
            , new Object[] {
            T001512_A63ComentarioProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001515_A63ComentarioProfesionalId
            }
            , new Object[] {
            T001516_A61SGPacientePacienteId
            }
            , new Object[] {
            T001517_A62SGProfesionalProfesionalId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z384ComentarioProfesionalCitaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A384ComentarioProfesionalCitaId ;
   private short RcdFound51 ;
   private short nIsDirty_51 ;
   private short ZZ384ComentarioProfesionalCitaId ;
   private int Z63ComentarioProfesionalId ;
   private int Z61SGPacientePacienteId ;
   private int Z62SGProfesionalProfesionalId ;
   private int A61SGPacientePacienteId ;
   private int A62SGProfesionalProfesionalId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int A63ComentarioProfesionalId ;
   private int edtComentarioProfesionalId_Enabled ;
   private int edtSGPacientePacienteId_Enabled ;
   private int edtSGProfesionalProfesionalId_Enabled ;
   private int edtComentarioProfesionalCitaId_Enabled ;
   private int edtComentarioProfesionalComentario_Enabled ;
   private int edtComentarioProfesionalFechaRegistro_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ63ComentarioProfesionalId ;
   private int ZZ61SGPacientePacienteId ;
   private int ZZ62SGProfesionalProfesionalId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtComentarioProfesionalId_Internalname ;
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
   private String edtComentarioProfesionalId_Jsonclick ;
   private String edtSGPacientePacienteId_Internalname ;
   private String edtSGPacientePacienteId_Jsonclick ;
   private String edtSGProfesionalProfesionalId_Internalname ;
   private String edtSGProfesionalProfesionalId_Jsonclick ;
   private String edtComentarioProfesionalCitaId_Internalname ;
   private String edtComentarioProfesionalCitaId_Jsonclick ;
   private String edtComentarioProfesionalComentario_Internalname ;
   private String edtComentarioProfesionalFechaRegistro_Internalname ;
   private String edtComentarioProfesionalFechaRegistro_Jsonclick ;
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
   private String sMode51 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z386ComentarioProfesionalFechaRegistro ;
   private java.util.Date A386ComentarioProfesionalFechaRegistro ;
   private java.util.Date ZZ386ComentarioProfesionalFechaRegistro ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String A385ComentarioProfesionalComentario ;
   private String Z385ComentarioProfesionalComentario ;
   private String ZZ385ComentarioProfesionalComentario ;
   private IDataStoreProvider pr_default ;
   private int[] T00156_A63ComentarioProfesionalId ;
   private short[] T00156_A384ComentarioProfesionalCitaId ;
   private String[] T00156_A385ComentarioProfesionalComentario ;
   private java.util.Date[] T00156_A386ComentarioProfesionalFechaRegistro ;
   private int[] T00156_A61SGPacientePacienteId ;
   private int[] T00156_A62SGProfesionalProfesionalId ;
   private int[] T00154_A61SGPacientePacienteId ;
   private int[] T00155_A62SGProfesionalProfesionalId ;
   private int[] T00157_A61SGPacientePacienteId ;
   private int[] T00158_A62SGProfesionalProfesionalId ;
   private int[] T00159_A63ComentarioProfesionalId ;
   private int[] T00153_A63ComentarioProfesionalId ;
   private short[] T00153_A384ComentarioProfesionalCitaId ;
   private String[] T00153_A385ComentarioProfesionalComentario ;
   private java.util.Date[] T00153_A386ComentarioProfesionalFechaRegistro ;
   private int[] T00153_A61SGPacientePacienteId ;
   private int[] T00153_A62SGProfesionalProfesionalId ;
   private int[] T001510_A63ComentarioProfesionalId ;
   private int[] T001511_A63ComentarioProfesionalId ;
   private int[] T00152_A63ComentarioProfesionalId ;
   private short[] T00152_A384ComentarioProfesionalCitaId ;
   private String[] T00152_A385ComentarioProfesionalComentario ;
   private java.util.Date[] T00152_A386ComentarioProfesionalFechaRegistro ;
   private int[] T00152_A61SGPacientePacienteId ;
   private int[] T00152_A62SGProfesionalProfesionalId ;
   private int[] T001512_A63ComentarioProfesionalId ;
   private int[] T001515_A63ComentarioProfesionalId ;
   private int[] T001516_A61SGPacientePacienteId ;
   private int[] T001517_A62SGProfesionalProfesionalId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class comentarioprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00152", "SELECT [ComentarioProfesionalId], [ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId, [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] WITH (UPDLOCK) WHERE [ComentarioProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00153", "SELECT [ComentarioProfesionalId], [ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId, [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] WHERE [ComentarioProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00154", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00155", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00156", "SELECT TM1.[ComentarioProfesionalId], TM1.[ComentarioProfesionalCitaId], TM1.[ComentarioProfesionalComentario], TM1.[ComentarioProfesionalFechaRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId, TM1.[SGProfesionalProfesionalId] AS SGProfesionalProfesionalId FROM [ComentarioProfesional] TM1 WHERE TM1.[ComentarioProfesionalId] = ? ORDER BY TM1.[ComentarioProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00157", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00158", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00159", "SELECT [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE [ComentarioProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001510", "SELECT TOP 1 [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE ( [ComentarioProfesionalId] > ?) ORDER BY [ComentarioProfesionalId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001511", "SELECT TOP 1 [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE ( [ComentarioProfesionalId] < ?) ORDER BY [ComentarioProfesionalId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001512", "INSERT INTO [ComentarioProfesional]([ComentarioProfesionalCitaId], [ComentarioProfesionalComentario], [ComentarioProfesionalFechaRegistro], [SGPacientePacienteId], [SGProfesionalProfesionalId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T001513", "UPDATE [ComentarioProfesional] SET [ComentarioProfesionalCitaId]=?, [ComentarioProfesionalComentario]=?, [ComentarioProfesionalFechaRegistro]=?, [SGPacientePacienteId]=?, [SGProfesionalProfesionalId]=?  WHERE [ComentarioProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001514", "DELETE FROM [ComentarioProfesional]  WHERE [ComentarioProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001515", "SELECT [ComentarioProfesionalId] FROM [ComentarioProfesional] ORDER BY [ComentarioProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001516", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001517", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setNLongVarchar(2, (String)parms[1], false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

