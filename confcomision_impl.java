package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class confcomision_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_5") == 0 )
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
         gxload_5( A31ProfesionalId, A32EspecialidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_6") == 0 )
      {
         A30SedeId = (short)(GXutil.lval( httpContext.GetPar( "SedeId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_6( A30SedeId) ;
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
         Form.getMeta().addItem("description", "Conf Comision", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtConfComisionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public confcomision_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public confcomision_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( confcomision_impl.class ));
   }

   public confcomision_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbEstado = new HTMLChoice();
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
      if ( cmbEstado.getItemCount() > 0 )
      {
         A126Estado = cmbEstado.getValidValue(A126Estado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A126Estado", A126Estado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEstado.setValue( GXutil.rtrim( A126Estado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEstado.getInternalname(), "Values", cmbEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Conf Comision", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_ConfComision.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_ConfComision.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConfComisionId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtConfComisionId_Internalname, "Comision Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtConfComisionId_Internalname, GXutil.ltrim( localUtil.ntoc( A29ConfComisionId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtConfComisionId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A29ConfComisionId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A29ConfComisionId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConfComisionId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConfComisionId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalId_Internalname, "Profesional Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEspecialidadId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEspecialidadId_Internalname, "Especialidad Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtEspecialidadId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEspecialidadId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEspecialidadId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSedeId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSedeId_Internalname, "Sede Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSedeId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSedeId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSedeId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFechaDesde_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtFechaDesde_Internalname, "Desde", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtFechaDesde_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtFechaDesde_Internalname, localUtil.format(A123FechaDesde, "99/99/99"), localUtil.format( A123FechaDesde, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFechaDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFechaDesde_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtFechaDesde_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtFechaDesde_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ConfComision.htm");
      httpContext.writeTextNL( "</div>") ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtFechaHasta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtFechaHasta_Internalname, "Hasta", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtFechaHasta_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtFechaHasta_Internalname, localUtil.format(A124FechaHasta, "99/99/99"), localUtil.format( A124FechaHasta, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtFechaHasta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtFechaHasta_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtFechaHasta_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtFechaHasta_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_ConfComision.htm");
      httpContext.writeTextNL( "</div>") ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPorcentaje_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPorcentaje_Internalname, "Porcentaje", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPorcentaje_Internalname, GXutil.ltrim( localUtil.ntoc( A125Porcentaje, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPorcentaje_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A125Porcentaje), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A125Porcentaje), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPorcentaje_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPorcentaje_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEstado, cmbEstado.getInternalname(), GXutil.rtrim( A126Estado), 1, cmbEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "", true, (byte)(1), "HLP_ConfComision.htm");
      cmbEstado.setValue( GXutil.rtrim( A126Estado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEstado.getInternalname(), "Values", cmbEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 70,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfComision.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ConfComision.htm");
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
         Z29ConfComisionId = (short)(localUtil.ctol( httpContext.cgiGet( "Z29ConfComisionId"), ",", ".")) ;
         Z123FechaDesde = localUtil.ctod( httpContext.cgiGet( "Z123FechaDesde"), 0) ;
         Z124FechaHasta = localUtil.ctod( httpContext.cgiGet( "Z124FechaHasta"), 0) ;
         Z125Porcentaje = (short)(localUtil.ctol( httpContext.cgiGet( "Z125Porcentaje"), ",", ".")) ;
         Z126Estado = httpContext.cgiGet( "Z126Estado") ;
         Z31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z31ProfesionalId"), ",", ".")) ;
         Z32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( "Z32EspecialidadId"), ",", ".")) ;
         Z30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( "Z30SedeId"), ",", ".")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConfComisionId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConfComisionId_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONFCOMISIONID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtConfComisionId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A29ConfComisionId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
         }
         else
         {
            A29ConfComisionId = (short)(localUtil.ctol( httpContext.cgiGet( edtConfComisionId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
         }
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SEDEID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtSedeId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A30SedeId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
         }
         else
         {
            A30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtFechaDesde_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "FECHADESDE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtFechaDesde_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A123FechaDesde = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A123FechaDesde", localUtil.format(A123FechaDesde, "99/99/99"));
         }
         else
         {
            A123FechaDesde = localUtil.ctod( httpContext.cgiGet( edtFechaDesde_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A123FechaDesde", localUtil.format(A123FechaDesde, "99/99/99"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtFechaHasta_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "FECHAHASTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtFechaHasta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A124FechaHasta = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A124FechaHasta", localUtil.format(A124FechaHasta, "99/99/99"));
         }
         else
         {
            A124FechaHasta = localUtil.ctod( httpContext.cgiGet( edtFechaHasta_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A124FechaHasta", localUtil.format(A124FechaHasta, "99/99/99"));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPorcentaje_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPorcentaje_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PORCENTAJE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPorcentaje_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A125Porcentaje = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A125Porcentaje", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125Porcentaje), 4, 0));
         }
         else
         {
            A125Porcentaje = (short)(localUtil.ctol( httpContext.cgiGet( edtPorcentaje_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A125Porcentaje", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125Porcentaje), 4, 0));
         }
         cmbEstado.setValue( httpContext.cgiGet( cmbEstado.getInternalname()) );
         A126Estado = httpContext.cgiGet( cmbEstado.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "A126Estado", A126Estado);
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
            A29ConfComisionId = (short)(GXutil.lval( httpContext.GetPar( "ConfComisionId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
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
            initAll0F22( ) ;
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
      disableAttributes0F22( ) ;
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

   public void resetCaption0F0( )
   {
   }

   public void zm0F22( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z123FechaDesde = T000F3_A123FechaDesde[0] ;
            Z124FechaHasta = T000F3_A124FechaHasta[0] ;
            Z125Porcentaje = T000F3_A125Porcentaje[0] ;
            Z126Estado = T000F3_A126Estado[0] ;
            Z31ProfesionalId = T000F3_A31ProfesionalId[0] ;
            Z32EspecialidadId = T000F3_A32EspecialidadId[0] ;
            Z30SedeId = T000F3_A30SedeId[0] ;
         }
         else
         {
            Z123FechaDesde = A123FechaDesde ;
            Z124FechaHasta = A124FechaHasta ;
            Z125Porcentaje = A125Porcentaje ;
            Z126Estado = A126Estado ;
            Z31ProfesionalId = A31ProfesionalId ;
            Z32EspecialidadId = A32EspecialidadId ;
            Z30SedeId = A30SedeId ;
         }
      }
      if ( GX_JID == -4 )
      {
         Z29ConfComisionId = A29ConfComisionId ;
         Z123FechaDesde = A123FechaDesde ;
         Z124FechaHasta = A124FechaHasta ;
         Z125Porcentaje = A125Porcentaje ;
         Z126Estado = A126Estado ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z30SedeId = A30SedeId ;
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

   public void load0F22( )
   {
      /* Using cursor T000F6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound22 = (short)(1) ;
         A123FechaDesde = T000F6_A123FechaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123FechaDesde", localUtil.format(A123FechaDesde, "99/99/99"));
         A124FechaHasta = T000F6_A124FechaHasta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A124FechaHasta", localUtil.format(A124FechaHasta, "99/99/99"));
         A125Porcentaje = T000F6_A125Porcentaje[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125Porcentaje", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125Porcentaje), 4, 0));
         A126Estado = T000F6_A126Estado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A126Estado", A126Estado);
         A31ProfesionalId = T000F6_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         A32EspecialidadId = T000F6_A32EspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         A30SedeId = T000F6_A30SedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
         zm0F22( -4) ;
      }
      pr_default.close(4);
      onLoadActions0F22( ) ;
   }

   public void onLoadActions0F22( )
   {
   }

   public void checkExtendedTable0F22( )
   {
      nIsDirty_22 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T000F4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T000F5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SEDEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A123FechaDesde)) || (( GXutil.resetTime(A123FechaDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A123FechaDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha Desde fuera de rango", "OutOfRange", 1, "FECHADESDE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFechaDesde_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A124FechaHasta)) || (( GXutil.resetTime(A124FechaHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A124FechaHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha Hasta fuera de rango", "OutOfRange", 1, "FECHAHASTA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtFechaHasta_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A126Estado, "A") == 0 ) || ( GXutil.strcmp(A126Estado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Estado fuera de rango", "OutOfRange", 1, "ESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0F22( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_5( int A31ProfesionalId ,
                         short A32EspecialidadId )
   {
      /* Using cursor T000F7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
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

   public void gxload_6( short A30SedeId )
   {
      /* Using cursor T000F8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SEDEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
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

   public void getKey0F22( )
   {
      /* Using cursor T000F9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound22 = (short)(1) ;
      }
      else
      {
         RcdFound22 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000F3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0F22( 4) ;
         RcdFound22 = (short)(1) ;
         A29ConfComisionId = T000F3_A29ConfComisionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
         A123FechaDesde = T000F3_A123FechaDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123FechaDesde", localUtil.format(A123FechaDesde, "99/99/99"));
         A124FechaHasta = T000F3_A124FechaHasta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A124FechaHasta", localUtil.format(A124FechaHasta, "99/99/99"));
         A125Porcentaje = T000F3_A125Porcentaje[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A125Porcentaje", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125Porcentaje), 4, 0));
         A126Estado = T000F3_A126Estado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A126Estado", A126Estado);
         A31ProfesionalId = T000F3_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         A32EspecialidadId = T000F3_A32EspecialidadId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
         A30SedeId = T000F3_A30SedeId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
         Z29ConfComisionId = A29ConfComisionId ;
         sMode22 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0F22( ) ;
         if ( AnyError == 1 )
         {
            RcdFound22 = (short)(0) ;
            initializeNonKey0F22( ) ;
         }
         Gx_mode = sMode22 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound22 = (short)(0) ;
         initializeNonKey0F22( ) ;
         sMode22 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode22 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0F22( ) ;
      if ( RcdFound22 == 0 )
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
      RcdFound22 = (short)(0) ;
      /* Using cursor T000F10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000F10_A29ConfComisionId[0] < A29ConfComisionId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000F10_A29ConfComisionId[0] > A29ConfComisionId ) ) )
         {
            A29ConfComisionId = T000F10_A29ConfComisionId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
            RcdFound22 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound22 = (short)(0) ;
      /* Using cursor T000F11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A29ConfComisionId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000F11_A29ConfComisionId[0] > A29ConfComisionId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000F11_A29ConfComisionId[0] < A29ConfComisionId ) ) )
         {
            A29ConfComisionId = T000F11_A29ConfComisionId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
            RcdFound22 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0F22( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtConfComisionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0F22( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound22 == 1 )
         {
            if ( A29ConfComisionId != Z29ConfComisionId )
            {
               A29ConfComisionId = Z29ConfComisionId ;
               httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CONFCOMISIONID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConfComisionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtConfComisionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0F22( ) ;
               GX_FocusControl = edtConfComisionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A29ConfComisionId != Z29ConfComisionId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtConfComisionId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0F22( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CONFCOMISIONID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtConfComisionId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtConfComisionId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0F22( ) ;
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
      if ( A29ConfComisionId != Z29ConfComisionId )
      {
         A29ConfComisionId = Z29ConfComisionId ;
         httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CONFCOMISIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConfComisionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtConfComisionId_Internalname ;
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
      if ( RcdFound22 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CONFCOMISIONID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConfComisionId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtProfesionalId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0F22( ) ;
      if ( RcdFound22 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtProfesionalId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0F22( ) ;
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
      if ( RcdFound22 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtProfesionalId_Internalname ;
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
      if ( RcdFound22 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtProfesionalId_Internalname ;
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
      scanStart0F22( ) ;
      if ( RcdFound22 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound22 != 0 )
         {
            scanNext0F22( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtProfesionalId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0F22( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0F22( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000F2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A29ConfComisionId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConfComision"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z123FechaDesde), GXutil.resetTime(T000F2_A123FechaDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z124FechaHasta), GXutil.resetTime(T000F2_A124FechaHasta[0])) ) || ( Z125Porcentaje != T000F2_A125Porcentaje[0] ) || ( GXutil.strcmp(Z126Estado, T000F2_A126Estado[0]) != 0 ) || ( Z31ProfesionalId != T000F2_A31ProfesionalId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z32EspecialidadId != T000F2_A32EspecialidadId[0] ) || ( Z30SedeId != T000F2_A30SedeId[0] ) )
         {
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z123FechaDesde), GXutil.resetTime(T000F2_A123FechaDesde[0])) ) )
            {
               GXutil.writeLogln("confcomision:[seudo value changed for attri]"+"FechaDesde");
               GXutil.writeLogRaw("Old: ",Z123FechaDesde);
               GXutil.writeLogRaw("Current: ",T000F2_A123FechaDesde[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z124FechaHasta), GXutil.resetTime(T000F2_A124FechaHasta[0])) ) )
            {
               GXutil.writeLogln("confcomision:[seudo value changed for attri]"+"FechaHasta");
               GXutil.writeLogRaw("Old: ",Z124FechaHasta);
               GXutil.writeLogRaw("Current: ",T000F2_A124FechaHasta[0]);
            }
            if ( Z125Porcentaje != T000F2_A125Porcentaje[0] )
            {
               GXutil.writeLogln("confcomision:[seudo value changed for attri]"+"Porcentaje");
               GXutil.writeLogRaw("Old: ",Z125Porcentaje);
               GXutil.writeLogRaw("Current: ",T000F2_A125Porcentaje[0]);
            }
            if ( GXutil.strcmp(Z126Estado, T000F2_A126Estado[0]) != 0 )
            {
               GXutil.writeLogln("confcomision:[seudo value changed for attri]"+"Estado");
               GXutil.writeLogRaw("Old: ",Z126Estado);
               GXutil.writeLogRaw("Current: ",T000F2_A126Estado[0]);
            }
            if ( Z31ProfesionalId != T000F2_A31ProfesionalId[0] )
            {
               GXutil.writeLogln("confcomision:[seudo value changed for attri]"+"ProfesionalId");
               GXutil.writeLogRaw("Old: ",Z31ProfesionalId);
               GXutil.writeLogRaw("Current: ",T000F2_A31ProfesionalId[0]);
            }
            if ( Z32EspecialidadId != T000F2_A32EspecialidadId[0] )
            {
               GXutil.writeLogln("confcomision:[seudo value changed for attri]"+"EspecialidadId");
               GXutil.writeLogRaw("Old: ",Z32EspecialidadId);
               GXutil.writeLogRaw("Current: ",T000F2_A32EspecialidadId[0]);
            }
            if ( Z30SedeId != T000F2_A30SedeId[0] )
            {
               GXutil.writeLogln("confcomision:[seudo value changed for attri]"+"SedeId");
               GXutil.writeLogRaw("Old: ",Z30SedeId);
               GXutil.writeLogRaw("Current: ",T000F2_A30SedeId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConfComision"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0F22( )
   {
      beforeValidate0F22( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F22( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0F22( 0) ;
         checkOptimisticConcurrency0F22( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F22( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0F22( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000F12 */
                  pr_default.execute(10, new Object[] {A123FechaDesde, A124FechaHasta, Short.valueOf(A125Porcentaje), A126Estado, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId)});
                  A29ConfComisionId = T000F12_A29ConfComisionId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConfComision");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0F0( ) ;
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
            load0F22( ) ;
         }
         endLevel0F22( ) ;
      }
      closeExtendedTableCursors0F22( ) ;
   }

   public void update0F22( )
   {
      beforeValidate0F22( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0F22( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F22( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0F22( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0F22( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000F13 */
                  pr_default.execute(11, new Object[] {A123FechaDesde, A124FechaHasta, Short.valueOf(A125Porcentaje), A126Estado, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), Short.valueOf(A29ConfComisionId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConfComision");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConfComision"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0F22( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0F0( ) ;
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
         endLevel0F22( ) ;
      }
      closeExtendedTableCursors0F22( ) ;
   }

   public void deferredUpdate0F22( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0F22( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0F22( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0F22( ) ;
         afterConfirm0F22( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0F22( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000F14 */
               pr_default.execute(12, new Object[] {Short.valueOf(A29ConfComisionId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConfComision");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound22 == 0 )
                     {
                        initAll0F22( ) ;
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
                     resetCaption0F0( ) ;
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
      sMode22 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0F22( ) ;
      Gx_mode = sMode22 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0F22( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0F22( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0F22( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "confcomision");
         if ( AnyError == 0 )
         {
            confirmValues0F0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "confcomision");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0F22( )
   {
      /* Using cursor T000F15 */
      pr_default.execute(13);
      RcdFound22 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound22 = (short)(1) ;
         A29ConfComisionId = T000F15_A29ConfComisionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0F22( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound22 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound22 = (short)(1) ;
         A29ConfComisionId = T000F15_A29ConfComisionId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
      }
   }

   public void scanEnd0F22( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0F22( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0F22( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0F22( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0F22( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0F22( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0F22( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0F22( )
   {
      edtConfComisionId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConfComisionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConfComisionId_Enabled), 5, 0), true);
      edtProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
      edtEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), true);
      edtSedeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), true);
      edtFechaDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFechaDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFechaDesde_Enabled), 5, 0), true);
      edtFechaHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtFechaHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtFechaHasta_Enabled), 5, 0), true);
      edtPorcentaje_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPorcentaje_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPorcentaje_Enabled), 5, 0), true);
      cmbEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEstado.getEnabled(), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0F22( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0F0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110323552", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.confcomision", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z29ConfComisionId", GXutil.ltrim( localUtil.ntoc( Z29ConfComisionId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z123FechaDesde", localUtil.dtoc( Z123FechaDesde, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z124FechaHasta", localUtil.dtoc( Z124FechaHasta, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z125Porcentaje", GXutil.ltrim( localUtil.ntoc( Z125Porcentaje, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z126Estado", GXutil.rtrim( Z126Estado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z31ProfesionalId", GXutil.ltrim( localUtil.ntoc( Z31ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z32EspecialidadId", GXutil.ltrim( localUtil.ntoc( Z32EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z30SedeId", GXutil.ltrim( localUtil.ntoc( Z30SedeId, (byte)(4), (byte)(0), ",", "")));
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
      return formatLink("com.projectthani.confcomision", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "ConfComision" ;
   }

   public String getPgmdesc( )
   {
      return "Conf Comision" ;
   }

   public void initializeNonKey0F22( )
   {
      A31ProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      A32EspecialidadId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A32EspecialidadId), 4, 0));
      A30SedeId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A30SedeId), 4, 0));
      A123FechaDesde = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A123FechaDesde", localUtil.format(A123FechaDesde, "99/99/99"));
      A124FechaHasta = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A124FechaHasta", localUtil.format(A124FechaHasta, "99/99/99"));
      A125Porcentaje = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A125Porcentaje", GXutil.ltrimstr( DecimalUtil.doubleToDec(A125Porcentaje), 4, 0));
      A126Estado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A126Estado", A126Estado);
      Z123FechaDesde = GXutil.nullDate() ;
      Z124FechaHasta = GXutil.nullDate() ;
      Z125Porcentaje = (short)(0) ;
      Z126Estado = "" ;
      Z31ProfesionalId = 0 ;
      Z32EspecialidadId = (short)(0) ;
      Z30SedeId = (short)(0) ;
   }

   public void initAll0F22( )
   {
      A29ConfComisionId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A29ConfComisionId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A29ConfComisionId), 4, 0));
      initializeNonKey0F22( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323557", true, true);
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
      httpContext.AddJavascriptSource("confcomision.js", "?20225110323557", false, true);
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
      edtConfComisionId_Internalname = "CONFCOMISIONID" ;
      edtProfesionalId_Internalname = "PROFESIONALID" ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID" ;
      edtSedeId_Internalname = "SEDEID" ;
      edtFechaDesde_Internalname = "FECHADESDE" ;
      edtFechaHasta_Internalname = "FECHAHASTA" ;
      edtPorcentaje_Internalname = "PORCENTAJE" ;
      cmbEstado.setInternalname( "ESTADO" );
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
      Form.setCaption( "Conf Comision" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      cmbEstado.setJsonclick( "" );
      cmbEstado.setEnabled( 1 );
      edtPorcentaje_Jsonclick = "" ;
      edtPorcentaje_Enabled = 1 ;
      edtFechaHasta_Jsonclick = "" ;
      edtFechaHasta_Enabled = 1 ;
      edtFechaDesde_Jsonclick = "" ;
      edtFechaDesde_Enabled = 1 ;
      edtSedeId_Jsonclick = "" ;
      edtSedeId_Enabled = 1 ;
      edtEspecialidadId_Jsonclick = "" ;
      edtEspecialidadId_Enabled = 1 ;
      edtProfesionalId_Jsonclick = "" ;
      edtProfesionalId_Enabled = 1 ;
      edtConfComisionId_Jsonclick = "" ;
      edtConfComisionId_Enabled = 1 ;
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
      cmbEstado.setName( "ESTADO" );
      cmbEstado.setWebtags( "" );
      cmbEstado.addItem("A", "Activo", (short)(0));
      cmbEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbEstado.getItemCount() > 0 )
      {
         A126Estado = cmbEstado.getValidValue(A126Estado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A126Estado", A126Estado);
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtProfesionalId_Internalname ;
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

   public void valid_Confcomisionid( )
   {
      A126Estado = cmbEstado.getValue() ;
      cmbEstado.setValue( A126Estado );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbEstado.getItemCount() > 0 )
      {
         A126Estado = cmbEstado.getValidValue(A126Estado) ;
         cmbEstado.setValue( A126Estado );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEstado.setValue( GXutil.rtrim( A126Estado) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A32EspecialidadId", GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A30SedeId", GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A123FechaDesde", localUtil.format(A123FechaDesde, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A124FechaHasta", localUtil.format(A124FechaHasta, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A125Porcentaje", GXutil.ltrim( localUtil.ntoc( A125Porcentaje, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A126Estado", GXutil.rtrim( A126Estado));
      cmbEstado.setValue( GXutil.rtrim( A126Estado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEstado.getInternalname(), "Values", cmbEstado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z29ConfComisionId", GXutil.ltrim( localUtil.ntoc( Z29ConfComisionId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z31ProfesionalId", GXutil.ltrim( localUtil.ntoc( Z31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z32EspecialidadId", GXutil.ltrim( localUtil.ntoc( Z32EspecialidadId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z30SedeId", GXutil.ltrim( localUtil.ntoc( Z30SedeId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z123FechaDesde", localUtil.format(Z123FechaDesde, "99/99/99"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z124FechaHasta", localUtil.format(Z124FechaHasta, "99/99/99"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z125Porcentaje", GXutil.ltrim( localUtil.ntoc( Z125Porcentaje, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z126Estado", GXutil.rtrim( Z126Estado));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Especialidadid( )
   {
      /* Using cursor T000F16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Sedeid( )
   {
      /* Using cursor T000F17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SEDEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
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
      setEventMetadata("VALID_CONFCOMISIONID","{handler:'valid_Confcomisionid',iparms:[{av:'cmbEstado'},{av:'A126Estado',fld:'ESTADO',pic:''},{av:'A29ConfComisionId',fld:'CONFCOMISIONID',pic:'ZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_CONFCOMISIONID",",oparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'A32EspecialidadId',fld:'ESPECIALIDADID',pic:'ZZZ9'},{av:'A30SedeId',fld:'SEDEID',pic:'ZZZ9'},{av:'A123FechaDesde',fld:'FECHADESDE',pic:''},{av:'A124FechaHasta',fld:'FECHAHASTA',pic:''},{av:'A125Porcentaje',fld:'PORCENTAJE',pic:'ZZZ9'},{av:'cmbEstado'},{av:'A126Estado',fld:'ESTADO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z29ConfComisionId'},{av:'Z31ProfesionalId'},{av:'Z32EspecialidadId'},{av:'Z30SedeId'},{av:'Z123FechaDesde'},{av:'Z124FechaHasta'},{av:'Z125Porcentaje'},{av:'Z126Estado'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_PROFESIONALID","{handler:'valid_Profesionalid',iparms:[]");
      setEventMetadata("VALID_PROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_ESPECIALIDADID","{handler:'valid_Especialidadid',iparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'A32EspecialidadId',fld:'ESPECIALIDADID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_ESPECIALIDADID",",oparms:[]}");
      setEventMetadata("VALID_SEDEID","{handler:'valid_Sedeid',iparms:[{av:'A30SedeId',fld:'SEDEID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_SEDEID",",oparms:[]}");
      setEventMetadata("VALID_FECHADESDE","{handler:'valid_Fechadesde',iparms:[]");
      setEventMetadata("VALID_FECHADESDE",",oparms:[]}");
      setEventMetadata("VALID_FECHAHASTA","{handler:'valid_Fechahasta',iparms:[]");
      setEventMetadata("VALID_FECHAHASTA",",oparms:[]}");
      setEventMetadata("VALID_ESTADO","{handler:'valid_Estado',iparms:[]");
      setEventMetadata("VALID_ESTADO",",oparms:[]}");
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
      Z123FechaDesde = GXutil.nullDate() ;
      Z124FechaHasta = GXutil.nullDate() ;
      Z126Estado = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A126Estado = "" ;
      lblTitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A123FechaDesde = GXutil.nullDate() ;
      A124FechaHasta = GXutil.nullDate() ;
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
      T000F6_A29ConfComisionId = new short[1] ;
      T000F6_A123FechaDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T000F6_A124FechaHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T000F6_A125Porcentaje = new short[1] ;
      T000F6_A126Estado = new String[] {""} ;
      T000F6_A31ProfesionalId = new int[1] ;
      T000F6_A32EspecialidadId = new short[1] ;
      T000F6_A30SedeId = new short[1] ;
      T000F4_A31ProfesionalId = new int[1] ;
      T000F5_A30SedeId = new short[1] ;
      T000F7_A31ProfesionalId = new int[1] ;
      T000F8_A30SedeId = new short[1] ;
      T000F9_A29ConfComisionId = new short[1] ;
      T000F3_A29ConfComisionId = new short[1] ;
      T000F3_A123FechaDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T000F3_A124FechaHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T000F3_A125Porcentaje = new short[1] ;
      T000F3_A126Estado = new String[] {""} ;
      T000F3_A31ProfesionalId = new int[1] ;
      T000F3_A32EspecialidadId = new short[1] ;
      T000F3_A30SedeId = new short[1] ;
      sMode22 = "" ;
      T000F10_A29ConfComisionId = new short[1] ;
      T000F11_A29ConfComisionId = new short[1] ;
      T000F2_A29ConfComisionId = new short[1] ;
      T000F2_A123FechaDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T000F2_A124FechaHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T000F2_A125Porcentaje = new short[1] ;
      T000F2_A126Estado = new String[] {""} ;
      T000F2_A31ProfesionalId = new int[1] ;
      T000F2_A32EspecialidadId = new short[1] ;
      T000F2_A30SedeId = new short[1] ;
      T000F12_A29ConfComisionId = new short[1] ;
      T000F15_A29ConfComisionId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ123FechaDesde = GXutil.nullDate() ;
      ZZ124FechaHasta = GXutil.nullDate() ;
      ZZ126Estado = "" ;
      T000F16_A31ProfesionalId = new int[1] ;
      T000F17_A30SedeId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.confcomision__default(),
         new Object[] {
             new Object[] {
            T000F2_A29ConfComisionId, T000F2_A123FechaDesde, T000F2_A124FechaHasta, T000F2_A125Porcentaje, T000F2_A126Estado, T000F2_A31ProfesionalId, T000F2_A32EspecialidadId, T000F2_A30SedeId
            }
            , new Object[] {
            T000F3_A29ConfComisionId, T000F3_A123FechaDesde, T000F3_A124FechaHasta, T000F3_A125Porcentaje, T000F3_A126Estado, T000F3_A31ProfesionalId, T000F3_A32EspecialidadId, T000F3_A30SedeId
            }
            , new Object[] {
            T000F4_A31ProfesionalId
            }
            , new Object[] {
            T000F5_A30SedeId
            }
            , new Object[] {
            T000F6_A29ConfComisionId, T000F6_A123FechaDesde, T000F6_A124FechaHasta, T000F6_A125Porcentaje, T000F6_A126Estado, T000F6_A31ProfesionalId, T000F6_A32EspecialidadId, T000F6_A30SedeId
            }
            , new Object[] {
            T000F7_A31ProfesionalId
            }
            , new Object[] {
            T000F8_A30SedeId
            }
            , new Object[] {
            T000F9_A29ConfComisionId
            }
            , new Object[] {
            T000F10_A29ConfComisionId
            }
            , new Object[] {
            T000F11_A29ConfComisionId
            }
            , new Object[] {
            T000F12_A29ConfComisionId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000F15_A29ConfComisionId
            }
            , new Object[] {
            T000F16_A31ProfesionalId
            }
            , new Object[] {
            T000F17_A30SedeId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z29ConfComisionId ;
   private short Z125Porcentaje ;
   private short Z32EspecialidadId ;
   private short Z30SedeId ;
   private short A32EspecialidadId ;
   private short A30SedeId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A29ConfComisionId ;
   private short A125Porcentaje ;
   private short RcdFound22 ;
   private short nIsDirty_22 ;
   private short ZZ29ConfComisionId ;
   private short ZZ32EspecialidadId ;
   private short ZZ30SedeId ;
   private short ZZ125Porcentaje ;
   private int Z31ProfesionalId ;
   private int A31ProfesionalId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtConfComisionId_Enabled ;
   private int edtProfesionalId_Enabled ;
   private int edtEspecialidadId_Enabled ;
   private int edtSedeId_Enabled ;
   private int edtFechaDesde_Enabled ;
   private int edtFechaHasta_Enabled ;
   private int edtPorcentaje_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ31ProfesionalId ;
   private String sPrefix ;
   private String Z126Estado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtConfComisionId_Internalname ;
   private String A126Estado ;
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
   private String edtConfComisionId_Jsonclick ;
   private String edtProfesionalId_Internalname ;
   private String edtProfesionalId_Jsonclick ;
   private String edtEspecialidadId_Internalname ;
   private String edtEspecialidadId_Jsonclick ;
   private String edtSedeId_Internalname ;
   private String edtSedeId_Jsonclick ;
   private String edtFechaDesde_Internalname ;
   private String edtFechaDesde_Jsonclick ;
   private String edtFechaHasta_Internalname ;
   private String edtFechaHasta_Jsonclick ;
   private String edtPorcentaje_Internalname ;
   private String edtPorcentaje_Jsonclick ;
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
   private String sMode22 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ126Estado ;
   private java.util.Date Z123FechaDesde ;
   private java.util.Date Z124FechaHasta ;
   private java.util.Date A123FechaDesde ;
   private java.util.Date A124FechaHasta ;
   private java.util.Date ZZ123FechaDesde ;
   private java.util.Date ZZ124FechaHasta ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Gx_longc ;
   private HTMLChoice cmbEstado ;
   private IDataStoreProvider pr_default ;
   private short[] T000F6_A29ConfComisionId ;
   private java.util.Date[] T000F6_A123FechaDesde ;
   private java.util.Date[] T000F6_A124FechaHasta ;
   private short[] T000F6_A125Porcentaje ;
   private String[] T000F6_A126Estado ;
   private int[] T000F6_A31ProfesionalId ;
   private short[] T000F6_A32EspecialidadId ;
   private short[] T000F6_A30SedeId ;
   private int[] T000F4_A31ProfesionalId ;
   private short[] T000F5_A30SedeId ;
   private int[] T000F7_A31ProfesionalId ;
   private short[] T000F8_A30SedeId ;
   private short[] T000F9_A29ConfComisionId ;
   private short[] T000F3_A29ConfComisionId ;
   private java.util.Date[] T000F3_A123FechaDesde ;
   private java.util.Date[] T000F3_A124FechaHasta ;
   private short[] T000F3_A125Porcentaje ;
   private String[] T000F3_A126Estado ;
   private int[] T000F3_A31ProfesionalId ;
   private short[] T000F3_A32EspecialidadId ;
   private short[] T000F3_A30SedeId ;
   private short[] T000F10_A29ConfComisionId ;
   private short[] T000F11_A29ConfComisionId ;
   private short[] T000F2_A29ConfComisionId ;
   private java.util.Date[] T000F2_A123FechaDesde ;
   private java.util.Date[] T000F2_A124FechaHasta ;
   private short[] T000F2_A125Porcentaje ;
   private String[] T000F2_A126Estado ;
   private int[] T000F2_A31ProfesionalId ;
   private short[] T000F2_A32EspecialidadId ;
   private short[] T000F2_A30SedeId ;
   private short[] T000F12_A29ConfComisionId ;
   private short[] T000F15_A29ConfComisionId ;
   private int[] T000F16_A31ProfesionalId ;
   private short[] T000F17_A30SedeId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class confcomision__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000F2", "SELECT [ConfComisionId], [FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId] FROM [ConfComision] WITH (UPDLOCK) WHERE [ConfComisionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F3", "SELECT [ConfComisionId], [FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId] FROM [ConfComision] WHERE [ConfComisionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F4", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F5", "SELECT [SedeId] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F6", "SELECT TM1.[ConfComisionId], TM1.[FechaDesde], TM1.[FechaHasta], TM1.[Porcentaje], TM1.[Estado], TM1.[ProfesionalId], TM1.[EspecialidadId], TM1.[SedeId] FROM [ConfComision] TM1 WHERE TM1.[ConfComisionId] = ? ORDER BY TM1.[ConfComisionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F7", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F8", "SELECT [SedeId] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F9", "SELECT [ConfComisionId] FROM [ConfComision] WHERE [ConfComisionId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F10", "SELECT TOP 1 [ConfComisionId] FROM [ConfComision] WHERE ( [ConfComisionId] > ?) ORDER BY [ConfComisionId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000F11", "SELECT TOP 1 [ConfComisionId] FROM [ConfComision] WHERE ( [ConfComisionId] < ?) ORDER BY [ConfComisionId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000F12", "INSERT INTO [ConfComision]([FechaDesde], [FechaHasta], [Porcentaje], [Estado], [ProfesionalId], [EspecialidadId], [SedeId]) VALUES(?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000F13", "UPDATE [ConfComision] SET [FechaDesde]=?, [FechaHasta]=?, [Porcentaje]=?, [Estado]=?, [ProfesionalId]=?, [EspecialidadId]=?, [SedeId]=?  WHERE [ConfComisionId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000F14", "DELETE FROM [ConfComision]  WHERE [ConfComisionId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000F15", "SELECT [ConfComisionId] FROM [ConfComision] ORDER BY [ConfComisionId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F16", "SELECT [ProfesionalId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000F17", "SELECT [SedeId] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
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
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 11 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

