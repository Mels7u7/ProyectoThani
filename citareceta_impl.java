package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class citareceta_impl extends GXDataArea
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
         A19CitaId = (int)(GXutil.lval( httpContext.GetPar( "CitaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_5( A19CitaId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_6") == 0 )
      {
         A25PetitorioId = (short)(GXutil.lval( httpContext.GetPar( "PetitorioId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_6( A25PetitorioId) ;
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
         Form.getMeta().addItem("description", "Cita Receta", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCitaRecetaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public citareceta_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public citareceta_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( citareceta_impl.class ));
   }

   public citareceta_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbCitaRecetaEstado = new HTMLChoice();
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
      if ( cmbCitaRecetaEstado.getItemCount() > 0 )
      {
         A111CitaRecetaEstado = cmbCitaRecetaEstado.getValidValue(A111CitaRecetaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A111CitaRecetaEstado", A111CitaRecetaEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaRecetaEstado.setValue( GXutil.rtrim( A111CitaRecetaEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaRecetaEstado.getInternalname(), "Values", cmbCitaRecetaEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Cita Receta", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_CitaReceta.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_CitaReceta.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaRecetaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaRecetaId_Internalname, "Receta Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaRecetaId_Internalname, GXutil.ltrim( localUtil.ntoc( A24CitaRecetaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaRecetaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A24CitaRecetaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A24CitaRecetaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaRecetaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaRecetaId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPetitorioId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPetitorioId_Internalname, "Petitorio Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPetitorioId_Internalname, GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPetitorioId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A25PetitorioId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPetitorioId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPetitorioId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaRecetaCantidad_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaRecetaCantidad_Internalname, "Receta Cantidad", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaRecetaCantidad_Internalname, GXutil.ltrim( localUtil.ntoc( A113CitaRecetaCantidad, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtCitaRecetaCantidad_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A113CitaRecetaCantidad), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A113CitaRecetaCantidad), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaRecetaCantidad_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaRecetaCantidad_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaRecetaIndicaciones_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaRecetaIndicaciones_Internalname, "Receta Indicaciones", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtCitaRecetaIndicaciones_Internalname, A110CitaRecetaIndicaciones, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", (short)(0), 1, edtCitaRecetaIndicaciones_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCitaRecetaEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbCitaRecetaEstado.getInternalname(), "Receta Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCitaRecetaEstado, cmbCitaRecetaEstado.getInternalname(), GXutil.rtrim( A111CitaRecetaEstado), 1, cmbCitaRecetaEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCitaRecetaEstado.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "", true, (byte)(1), "HLP_CitaReceta.htm");
      cmbCitaRecetaEstado.setValue( GXutil.rtrim( A111CitaRecetaEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaRecetaEstado.getInternalname(), "Values", cmbCitaRecetaEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCitaRecetaFecha_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtCitaRecetaFecha_Internalname, "Receta Fecha", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtCitaRecetaFecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtCitaRecetaFecha_Internalname, localUtil.ttoc( A112CitaRecetaFecha, 10, 8, 0, 3, "/", ":", " "), localUtil.format( A112CitaRecetaFecha, "99/99/99 99:99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',5,24,'spa',false,0);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCitaRecetaFecha_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCitaRecetaFecha_Enabled, 0, "text", "", 14, "chr", 1, "row", 14, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtCitaRecetaFecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtCitaRecetaFecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_CitaReceta.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 65,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaReceta.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_CitaReceta.htm");
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
         Z24CitaRecetaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z24CitaRecetaId"), ",", ".")) ;
         Z113CitaRecetaCantidad = (short)(localUtil.ctol( httpContext.cgiGet( "Z113CitaRecetaCantidad"), ",", ".")) ;
         Z110CitaRecetaIndicaciones = httpContext.cgiGet( "Z110CitaRecetaIndicaciones") ;
         Z111CitaRecetaEstado = httpContext.cgiGet( "Z111CitaRecetaEstado") ;
         Z112CitaRecetaFecha = localUtil.ctot( httpContext.cgiGet( "Z112CitaRecetaFecha"), 0) ;
         Z19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z19CitaId"), ",", ".")) ;
         Z25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( "Z25PetitorioId"), ",", ".")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCitaRecetaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCitaRecetaId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITARECETAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCitaRecetaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A24CitaRecetaId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
         }
         else
         {
            A24CitaRecetaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaRecetaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
         }
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPetitorioId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPetitorioId_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PETITORIOID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtPetitorioId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A25PetitorioId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
         }
         else
         {
            A25PetitorioId = (short)(localUtil.ctol( httpContext.cgiGet( edtPetitorioId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCitaRecetaCantidad_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCitaRecetaCantidad_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CITARECETACANTIDAD");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCitaRecetaCantidad_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A113CitaRecetaCantidad = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A113CitaRecetaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A113CitaRecetaCantidad), 4, 0));
         }
         else
         {
            A113CitaRecetaCantidad = (short)(localUtil.ctol( httpContext.cgiGet( edtCitaRecetaCantidad_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A113CitaRecetaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A113CitaRecetaCantidad), 4, 0));
         }
         A110CitaRecetaIndicaciones = httpContext.cgiGet( edtCitaRecetaIndicaciones_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A110CitaRecetaIndicaciones", A110CitaRecetaIndicaciones);
         cmbCitaRecetaEstado.setValue( httpContext.cgiGet( cmbCitaRecetaEstado.getInternalname()) );
         A111CitaRecetaEstado = httpContext.cgiGet( cmbCitaRecetaEstado.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "A111CitaRecetaEstado", A111CitaRecetaEstado);
         if ( localUtil.vcdtime( httpContext.cgiGet( edtCitaRecetaFecha_Internalname), (byte)(3), (byte)(0)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_baddatetime", new Object[] {}), 1, "CITARECETAFECHA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtCitaRecetaFecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A112CitaRecetaFecha = GXutil.resetTime( GXutil.nullDate() );
            httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 8, 5, 0, 3, "/", ":", " "));
         }
         else
         {
            A112CitaRecetaFecha = localUtil.ctot( httpContext.cgiGet( edtCitaRecetaFecha_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 8, 5, 0, 3, "/", ":", " "));
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
            A24CitaRecetaId = (int)(GXutil.lval( httpContext.GetPar( "CitaRecetaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
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
            initAll0C19( ) ;
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
      disableAttributes0C19( ) ;
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

   public void resetCaption0C0( )
   {
   }

   public void zm0C19( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z113CitaRecetaCantidad = T000C3_A113CitaRecetaCantidad[0] ;
            Z110CitaRecetaIndicaciones = T000C3_A110CitaRecetaIndicaciones[0] ;
            Z111CitaRecetaEstado = T000C3_A111CitaRecetaEstado[0] ;
            Z112CitaRecetaFecha = T000C3_A112CitaRecetaFecha[0] ;
            Z19CitaId = T000C3_A19CitaId[0] ;
            Z25PetitorioId = T000C3_A25PetitorioId[0] ;
         }
         else
         {
            Z113CitaRecetaCantidad = A113CitaRecetaCantidad ;
            Z110CitaRecetaIndicaciones = A110CitaRecetaIndicaciones ;
            Z111CitaRecetaEstado = A111CitaRecetaEstado ;
            Z112CitaRecetaFecha = A112CitaRecetaFecha ;
            Z19CitaId = A19CitaId ;
            Z25PetitorioId = A25PetitorioId ;
         }
      }
      if ( GX_JID == -4 )
      {
         Z24CitaRecetaId = A24CitaRecetaId ;
         Z113CitaRecetaCantidad = A113CitaRecetaCantidad ;
         Z110CitaRecetaIndicaciones = A110CitaRecetaIndicaciones ;
         Z111CitaRecetaEstado = A111CitaRecetaEstado ;
         Z112CitaRecetaFecha = A112CitaRecetaFecha ;
         Z19CitaId = A19CitaId ;
         Z25PetitorioId = A25PetitorioId ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && GXutil.dateCompare(GXutil.nullDate(), A112CitaRecetaFecha) && ( Gx_BScreen == 0 ) )
      {
         A112CitaRecetaFecha = GXutil.now( ) ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 8, 5, 0, 3, "/", ":", " "));
      }
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0C19( )
   {
      /* Using cursor T000C6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A24CitaRecetaId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound19 = (short)(1) ;
         A113CitaRecetaCantidad = T000C6_A113CitaRecetaCantidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A113CitaRecetaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A113CitaRecetaCantidad), 4, 0));
         A110CitaRecetaIndicaciones = T000C6_A110CitaRecetaIndicaciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A110CitaRecetaIndicaciones", A110CitaRecetaIndicaciones);
         A111CitaRecetaEstado = T000C6_A111CitaRecetaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A111CitaRecetaEstado", A111CitaRecetaEstado);
         A112CitaRecetaFecha = T000C6_A112CitaRecetaFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 8, 5, 0, 3, "/", ":", " "));
         A19CitaId = T000C6_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A25PetitorioId = T000C6_A25PetitorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
         zm0C19( -4) ;
      }
      pr_default.close(4);
      onLoadActions0C19( ) ;
   }

   public void onLoadActions0C19( )
   {
   }

   public void checkExtendedTable0C19( )
   {
      nIsDirty_19 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      /* Using cursor T000C4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      /* Using cursor T000C5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio'.", "ForeignKeyNotFound", 1, "PETITORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A111CitaRecetaEstado, "A") == 0 ) || ( GXutil.strcmp(A111CitaRecetaEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Receta Estado fuera de rango", "OutOfRange", 1, "CITARECETAESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCitaRecetaEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.nullDate(), A112CitaRecetaFecha) || (( A112CitaRecetaFecha.after( localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0)) ) ) || ( GXutil.dateCompare(A112CitaRecetaFecha, localUtil.ymdhmsToT( (short)(1753), (byte)(1), (byte)(1), (byte)(0), (byte)(0), (byte)(0))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Cita Receta Fecha fuera de rango", "OutOfRange", 1, "CITARECETAFECHA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaRecetaFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0C19( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_5( int A19CitaId )
   {
      /* Using cursor T000C7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
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

   public void gxload_6( short A25PetitorioId )
   {
      /* Using cursor T000C8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio'.", "ForeignKeyNotFound", 1, "PETITORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioId_Internalname ;
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

   public void getKey0C19( )
   {
      /* Using cursor T000C9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A24CitaRecetaId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound19 = (short)(1) ;
      }
      else
      {
         RcdFound19 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000C3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A24CitaRecetaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0C19( 4) ;
         RcdFound19 = (short)(1) ;
         A24CitaRecetaId = T000C3_A24CitaRecetaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
         A113CitaRecetaCantidad = T000C3_A113CitaRecetaCantidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A113CitaRecetaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A113CitaRecetaCantidad), 4, 0));
         A110CitaRecetaIndicaciones = T000C3_A110CitaRecetaIndicaciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A110CitaRecetaIndicaciones", A110CitaRecetaIndicaciones);
         A111CitaRecetaEstado = T000C3_A111CitaRecetaEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A111CitaRecetaEstado", A111CitaRecetaEstado);
         A112CitaRecetaFecha = T000C3_A112CitaRecetaFecha[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 8, 5, 0, 3, "/", ":", " "));
         A19CitaId = T000C3_A19CitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
         A25PetitorioId = T000C3_A25PetitorioId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
         Z24CitaRecetaId = A24CitaRecetaId ;
         sMode19 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load0C19( ) ;
         if ( AnyError == 1 )
         {
            RcdFound19 = (short)(0) ;
            initializeNonKey0C19( ) ;
         }
         Gx_mode = sMode19 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound19 = (short)(0) ;
         initializeNonKey0C19( ) ;
         sMode19 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode19 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey0C19( ) ;
      if ( RcdFound19 == 0 )
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
      RcdFound19 = (short)(0) ;
      /* Using cursor T000C10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A24CitaRecetaId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000C10_A24CitaRecetaId[0] < A24CitaRecetaId ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000C10_A24CitaRecetaId[0] > A24CitaRecetaId ) ) )
         {
            A24CitaRecetaId = T000C10_A24CitaRecetaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
            RcdFound19 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound19 = (short)(0) ;
      /* Using cursor T000C11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A24CitaRecetaId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000C11_A24CitaRecetaId[0] > A24CitaRecetaId ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000C11_A24CitaRecetaId[0] < A24CitaRecetaId ) ) )
         {
            A24CitaRecetaId = T000C11_A24CitaRecetaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
            RcdFound19 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0C19( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCitaRecetaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0C19( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound19 == 1 )
         {
            if ( A24CitaRecetaId != Z24CitaRecetaId )
            {
               A24CitaRecetaId = Z24CitaRecetaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CITARECETAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCitaRecetaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCitaRecetaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update0C19( ) ;
               GX_FocusControl = edtCitaRecetaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A24CitaRecetaId != Z24CitaRecetaId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCitaRecetaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0C19( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CITARECETAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCitaRecetaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtCitaRecetaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0C19( ) ;
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
      if ( A24CitaRecetaId != Z24CitaRecetaId )
      {
         A24CitaRecetaId = Z24CitaRecetaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CITARECETAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaRecetaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCitaRecetaId_Internalname ;
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
      if ( RcdFound19 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "CITARECETAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaRecetaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart0C19( ) ;
      if ( RcdFound19 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0C19( ) ;
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
      if ( RcdFound19 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
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
      if ( RcdFound19 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
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
      scanStart0C19( ) ;
      if ( RcdFound19 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound19 != 0 )
         {
            scanNext0C19( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd0C19( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency0C19( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000C2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A24CitaRecetaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaReceta"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( Z113CitaRecetaCantidad != T000C2_A113CitaRecetaCantidad[0] ) || ( GXutil.strcmp(Z110CitaRecetaIndicaciones, T000C2_A110CitaRecetaIndicaciones[0]) != 0 ) || ( GXutil.strcmp(Z111CitaRecetaEstado, T000C2_A111CitaRecetaEstado[0]) != 0 ) || !( GXutil.dateCompare(Z112CitaRecetaFecha, T000C2_A112CitaRecetaFecha[0]) ) || ( Z19CitaId != T000C2_A19CitaId[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z25PetitorioId != T000C2_A25PetitorioId[0] ) )
         {
            if ( Z113CitaRecetaCantidad != T000C2_A113CitaRecetaCantidad[0] )
            {
               GXutil.writeLogln("citareceta:[seudo value changed for attri]"+"CitaRecetaCantidad");
               GXutil.writeLogRaw("Old: ",Z113CitaRecetaCantidad);
               GXutil.writeLogRaw("Current: ",T000C2_A113CitaRecetaCantidad[0]);
            }
            if ( GXutil.strcmp(Z110CitaRecetaIndicaciones, T000C2_A110CitaRecetaIndicaciones[0]) != 0 )
            {
               GXutil.writeLogln("citareceta:[seudo value changed for attri]"+"CitaRecetaIndicaciones");
               GXutil.writeLogRaw("Old: ",Z110CitaRecetaIndicaciones);
               GXutil.writeLogRaw("Current: ",T000C2_A110CitaRecetaIndicaciones[0]);
            }
            if ( GXutil.strcmp(Z111CitaRecetaEstado, T000C2_A111CitaRecetaEstado[0]) != 0 )
            {
               GXutil.writeLogln("citareceta:[seudo value changed for attri]"+"CitaRecetaEstado");
               GXutil.writeLogRaw("Old: ",Z111CitaRecetaEstado);
               GXutil.writeLogRaw("Current: ",T000C2_A111CitaRecetaEstado[0]);
            }
            if ( !( GXutil.dateCompare(Z112CitaRecetaFecha, T000C2_A112CitaRecetaFecha[0]) ) )
            {
               GXutil.writeLogln("citareceta:[seudo value changed for attri]"+"CitaRecetaFecha");
               GXutil.writeLogRaw("Old: ",Z112CitaRecetaFecha);
               GXutil.writeLogRaw("Current: ",T000C2_A112CitaRecetaFecha[0]);
            }
            if ( Z19CitaId != T000C2_A19CitaId[0] )
            {
               GXutil.writeLogln("citareceta:[seudo value changed for attri]"+"CitaId");
               GXutil.writeLogRaw("Old: ",Z19CitaId);
               GXutil.writeLogRaw("Current: ",T000C2_A19CitaId[0]);
            }
            if ( Z25PetitorioId != T000C2_A25PetitorioId[0] )
            {
               GXutil.writeLogln("citareceta:[seudo value changed for attri]"+"PetitorioId");
               GXutil.writeLogRaw("Old: ",Z25PetitorioId);
               GXutil.writeLogRaw("Current: ",T000C2_A25PetitorioId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CitaReceta"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0C19( )
   {
      beforeValidate0C19( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C19( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0C19( 0) ;
         checkOptimisticConcurrency0C19( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0C19( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0C19( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000C12 */
                  pr_default.execute(10, new Object[] {Short.valueOf(A113CitaRecetaCantidad), A110CitaRecetaIndicaciones, A111CitaRecetaEstado, A112CitaRecetaFecha, Integer.valueOf(A19CitaId), Short.valueOf(A25PetitorioId)});
                  A24CitaRecetaId = T000C12_A24CitaRecetaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaReceta");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption0C0( ) ;
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
            load0C19( ) ;
         }
         endLevel0C19( ) ;
      }
      closeExtendedTableCursors0C19( ) ;
   }

   public void update0C19( )
   {
      beforeValidate0C19( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0C19( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0C19( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0C19( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0C19( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000C13 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A113CitaRecetaCantidad), A110CitaRecetaIndicaciones, A111CitaRecetaEstado, A112CitaRecetaFecha, Integer.valueOf(A19CitaId), Short.valueOf(A25PetitorioId), Integer.valueOf(A24CitaRecetaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaReceta");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CitaReceta"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0C19( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption0C0( ) ;
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
         endLevel0C19( ) ;
      }
      closeExtendedTableCursors0C19( ) ;
   }

   public void deferredUpdate0C19( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0C19( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0C19( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0C19( ) ;
         afterConfirm0C19( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0C19( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000C14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A24CitaRecetaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CitaReceta");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound19 == 0 )
                     {
                        initAll0C19( ) ;
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
                     resetCaption0C0( ) ;
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
      sMode19 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0C19( ) ;
      Gx_mode = sMode19 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0C19( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0C19( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0C19( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "citareceta");
         if ( AnyError == 0 )
         {
            confirmValues0C0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "citareceta");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0C19( )
   {
      /* Using cursor T000C15 */
      pr_default.execute(13);
      RcdFound19 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound19 = (short)(1) ;
         A24CitaRecetaId = T000C15_A24CitaRecetaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0C19( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound19 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound19 = (short)(1) ;
         A24CitaRecetaId = T000C15_A24CitaRecetaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
      }
   }

   public void scanEnd0C19( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0C19( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0C19( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0C19( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0C19( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0C19( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0C19( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0C19( )
   {
      edtCitaRecetaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaRecetaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaRecetaId_Enabled), 5, 0), true);
      edtCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaId_Enabled), 5, 0), true);
      edtPetitorioId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPetitorioId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPetitorioId_Enabled), 5, 0), true);
      edtCitaRecetaCantidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaRecetaCantidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaRecetaCantidad_Enabled), 5, 0), true);
      edtCitaRecetaIndicaciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaRecetaIndicaciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaRecetaIndicaciones_Enabled), 5, 0), true);
      cmbCitaRecetaEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaRecetaEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCitaRecetaEstado.getEnabled(), 5, 0), true);
      edtCitaRecetaFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCitaRecetaFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCitaRecetaFecha_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes0C19( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues0C0( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110323259", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.citareceta", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z24CitaRecetaId", GXutil.ltrim( localUtil.ntoc( Z24CitaRecetaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z113CitaRecetaCantidad", GXutil.ltrim( localUtil.ntoc( Z113CitaRecetaCantidad, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z110CitaRecetaIndicaciones", Z110CitaRecetaIndicaciones);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z111CitaRecetaEstado", GXutil.rtrim( Z111CitaRecetaEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z112CitaRecetaFecha", localUtil.ttoc( Z112CitaRecetaFecha, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z25PetitorioId", GXutil.ltrim( localUtil.ntoc( Z25PetitorioId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
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
      return formatLink("com.projectthani.citareceta", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "CitaReceta" ;
   }

   public String getPgmdesc( )
   {
      return "Cita Receta" ;
   }

   public void initializeNonKey0C19( )
   {
      A19CitaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A19CitaId), 8, 0));
      A25PetitorioId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A25PetitorioId), 4, 0));
      A113CitaRecetaCantidad = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A113CitaRecetaCantidad", GXutil.ltrimstr( DecimalUtil.doubleToDec(A113CitaRecetaCantidad), 4, 0));
      A110CitaRecetaIndicaciones = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A110CitaRecetaIndicaciones", A110CitaRecetaIndicaciones);
      A111CitaRecetaEstado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A111CitaRecetaEstado", A111CitaRecetaEstado);
      A112CitaRecetaFecha = GXutil.now( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 8, 5, 0, 3, "/", ":", " "));
      Z113CitaRecetaCantidad = (short)(0) ;
      Z110CitaRecetaIndicaciones = "" ;
      Z111CitaRecetaEstado = "" ;
      Z112CitaRecetaFecha = GXutil.resetTime( GXutil.nullDate() );
      Z19CitaId = 0 ;
      Z25PetitorioId = (short)(0) ;
   }

   public void initAll0C19( )
   {
      A24CitaRecetaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A24CitaRecetaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A24CitaRecetaId), 8, 0));
      initializeNonKey0C19( ) ;
   }

   public void standaloneModalInsert( )
   {
      A112CitaRecetaFecha = i112CitaRecetaFecha ;
      httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 8, 5, 0, 3, "/", ":", " "));
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323264", true, true);
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
      httpContext.AddJavascriptSource("citareceta.js", "?20225110323264", false, true);
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
      edtCitaRecetaId_Internalname = "CITARECETAID" ;
      edtCitaId_Internalname = "CITAID" ;
      edtPetitorioId_Internalname = "PETITORIOID" ;
      edtCitaRecetaCantidad_Internalname = "CITARECETACANTIDAD" ;
      edtCitaRecetaIndicaciones_Internalname = "CITARECETAINDICACIONES" ;
      cmbCitaRecetaEstado.setInternalname( "CITARECETAESTADO" );
      edtCitaRecetaFecha_Internalname = "CITARECETAFECHA" ;
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
      Form.setCaption( "Cita Receta" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtCitaRecetaFecha_Jsonclick = "" ;
      edtCitaRecetaFecha_Enabled = 1 ;
      cmbCitaRecetaEstado.setJsonclick( "" );
      cmbCitaRecetaEstado.setEnabled( 1 );
      edtCitaRecetaIndicaciones_Enabled = 1 ;
      edtCitaRecetaCantidad_Jsonclick = "" ;
      edtCitaRecetaCantidad_Enabled = 1 ;
      edtPetitorioId_Jsonclick = "" ;
      edtPetitorioId_Enabled = 1 ;
      edtCitaId_Jsonclick = "" ;
      edtCitaId_Enabled = 1 ;
      edtCitaRecetaId_Jsonclick = "" ;
      edtCitaRecetaId_Enabled = 1 ;
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
      cmbCitaRecetaEstado.setName( "CITARECETAESTADO" );
      cmbCitaRecetaEstado.setWebtags( "" );
      cmbCitaRecetaEstado.addItem("A", "Activo", (short)(0));
      cmbCitaRecetaEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbCitaRecetaEstado.getItemCount() > 0 )
      {
         A111CitaRecetaEstado = cmbCitaRecetaEstado.getValidValue(A111CitaRecetaEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A111CitaRecetaEstado", A111CitaRecetaEstado);
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtCitaId_Internalname ;
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

   public void valid_Citarecetaid( )
   {
      A111CitaRecetaEstado = cmbCitaRecetaEstado.getValue() ;
      cmbCitaRecetaEstado.setValue( A111CitaRecetaEstado );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbCitaRecetaEstado.getItemCount() > 0 )
      {
         A111CitaRecetaEstado = cmbCitaRecetaEstado.getValidValue(A111CitaRecetaEstado) ;
         cmbCitaRecetaEstado.setValue( A111CitaRecetaEstado );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCitaRecetaEstado.setValue( GXutil.rtrim( A111CitaRecetaEstado) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A19CitaId", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A25PetitorioId", GXutil.ltrim( localUtil.ntoc( A25PetitorioId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A113CitaRecetaCantidad", GXutil.ltrim( localUtil.ntoc( A113CitaRecetaCantidad, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A110CitaRecetaIndicaciones", A110CitaRecetaIndicaciones);
      httpContext.ajax_rsp_assign_attri("", false, "A111CitaRecetaEstado", GXutil.rtrim( A111CitaRecetaEstado));
      cmbCitaRecetaEstado.setValue( GXutil.rtrim( A111CitaRecetaEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCitaRecetaEstado.getInternalname(), "Values", cmbCitaRecetaEstado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A112CitaRecetaFecha", localUtil.ttoc( A112CitaRecetaFecha, 10, 8, 0, 3, "/", ":", " "));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z24CitaRecetaId", GXutil.ltrim( localUtil.ntoc( Z24CitaRecetaId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z19CitaId", GXutil.ltrim( localUtil.ntoc( Z19CitaId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z25PetitorioId", GXutil.ltrim( localUtil.ntoc( Z25PetitorioId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z113CitaRecetaCantidad", GXutil.ltrim( localUtil.ntoc( Z113CitaRecetaCantidad, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z110CitaRecetaIndicaciones", Z110CitaRecetaIndicaciones);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z111CitaRecetaEstado", GXutil.rtrim( Z111CitaRecetaEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z112CitaRecetaFecha", localUtil.ttoc( Z112CitaRecetaFecha, 10, 8, 0, 3, "/", ":", " "));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Citaid( )
   {
      /* Using cursor T000C16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A19CitaId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Cita'.", "ForeignKeyNotFound", 1, "CITAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCitaId_Internalname ;
      }
      pr_default.close(14);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Petitorioid( )
   {
      /* Using cursor T000C17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A25PetitorioId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Petitorio'.", "ForeignKeyNotFound", 1, "PETITORIOID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPetitorioId_Internalname ;
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
      setEventMetadata("VALID_CITARECETAID","{handler:'valid_Citarecetaid',iparms:[{av:'cmbCitaRecetaEstado'},{av:'A111CitaRecetaEstado',fld:'CITARECETAESTADO',pic:''},{av:'A24CitaRecetaId',fld:'CITARECETAID',pic:'ZZZZZZZ9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'A112CitaRecetaFecha',fld:'CITARECETAFECHA',pic:'99/99/99 99:99'}]");
      setEventMetadata("VALID_CITARECETAID",",oparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'},{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9'},{av:'A113CitaRecetaCantidad',fld:'CITARECETACANTIDAD',pic:'ZZZ9'},{av:'A110CitaRecetaIndicaciones',fld:'CITARECETAINDICACIONES',pic:''},{av:'cmbCitaRecetaEstado'},{av:'A111CitaRecetaEstado',fld:'CITARECETAESTADO',pic:''},{av:'A112CitaRecetaFecha',fld:'CITARECETAFECHA',pic:'99/99/99 99:99'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z24CitaRecetaId'},{av:'Z19CitaId'},{av:'Z25PetitorioId'},{av:'Z113CitaRecetaCantidad'},{av:'Z110CitaRecetaIndicaciones'},{av:'Z111CitaRecetaEstado'},{av:'Z112CitaRecetaFecha'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_CITAID","{handler:'valid_Citaid',iparms:[{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_CITAID",",oparms:[]}");
      setEventMetadata("VALID_PETITORIOID","{handler:'valid_Petitorioid',iparms:[{av:'A25PetitorioId',fld:'PETITORIOID',pic:'ZZZ9'}]");
      setEventMetadata("VALID_PETITORIOID",",oparms:[]}");
      setEventMetadata("VALID_CITARECETAESTADO","{handler:'valid_Citarecetaestado',iparms:[]");
      setEventMetadata("VALID_CITARECETAESTADO",",oparms:[]}");
      setEventMetadata("VALID_CITARECETAFECHA","{handler:'valid_Citarecetafecha',iparms:[]");
      setEventMetadata("VALID_CITARECETAFECHA",",oparms:[]}");
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
      Z110CitaRecetaIndicaciones = "" ;
      Z111CitaRecetaEstado = "" ;
      Z112CitaRecetaFecha = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A111CitaRecetaEstado = "" ;
      lblTitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A110CitaRecetaIndicaciones = "" ;
      A112CitaRecetaFecha = GXutil.resetTime( GXutil.nullDate() );
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
      T000C6_A24CitaRecetaId = new int[1] ;
      T000C6_A113CitaRecetaCantidad = new short[1] ;
      T000C6_A110CitaRecetaIndicaciones = new String[] {""} ;
      T000C6_A111CitaRecetaEstado = new String[] {""} ;
      T000C6_A112CitaRecetaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000C6_A19CitaId = new int[1] ;
      T000C6_A25PetitorioId = new short[1] ;
      T000C4_A19CitaId = new int[1] ;
      T000C5_A25PetitorioId = new short[1] ;
      T000C7_A19CitaId = new int[1] ;
      T000C8_A25PetitorioId = new short[1] ;
      T000C9_A24CitaRecetaId = new int[1] ;
      T000C3_A24CitaRecetaId = new int[1] ;
      T000C3_A113CitaRecetaCantidad = new short[1] ;
      T000C3_A110CitaRecetaIndicaciones = new String[] {""} ;
      T000C3_A111CitaRecetaEstado = new String[] {""} ;
      T000C3_A112CitaRecetaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000C3_A19CitaId = new int[1] ;
      T000C3_A25PetitorioId = new short[1] ;
      sMode19 = "" ;
      T000C10_A24CitaRecetaId = new int[1] ;
      T000C11_A24CitaRecetaId = new int[1] ;
      T000C2_A24CitaRecetaId = new int[1] ;
      T000C2_A113CitaRecetaCantidad = new short[1] ;
      T000C2_A110CitaRecetaIndicaciones = new String[] {""} ;
      T000C2_A111CitaRecetaEstado = new String[] {""} ;
      T000C2_A112CitaRecetaFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000C2_A19CitaId = new int[1] ;
      T000C2_A25PetitorioId = new short[1] ;
      T000C12_A24CitaRecetaId = new int[1] ;
      T000C15_A24CitaRecetaId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i112CitaRecetaFecha = GXutil.resetTime( GXutil.nullDate() );
      ZZ110CitaRecetaIndicaciones = "" ;
      ZZ111CitaRecetaEstado = "" ;
      ZZ112CitaRecetaFecha = GXutil.resetTime( GXutil.nullDate() );
      T000C16_A19CitaId = new int[1] ;
      T000C17_A25PetitorioId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.citareceta__default(),
         new Object[] {
             new Object[] {
            T000C2_A24CitaRecetaId, T000C2_A113CitaRecetaCantidad, T000C2_A110CitaRecetaIndicaciones, T000C2_A111CitaRecetaEstado, T000C2_A112CitaRecetaFecha, T000C2_A19CitaId, T000C2_A25PetitorioId
            }
            , new Object[] {
            T000C3_A24CitaRecetaId, T000C3_A113CitaRecetaCantidad, T000C3_A110CitaRecetaIndicaciones, T000C3_A111CitaRecetaEstado, T000C3_A112CitaRecetaFecha, T000C3_A19CitaId, T000C3_A25PetitorioId
            }
            , new Object[] {
            T000C4_A19CitaId
            }
            , new Object[] {
            T000C5_A25PetitorioId
            }
            , new Object[] {
            T000C6_A24CitaRecetaId, T000C6_A113CitaRecetaCantidad, T000C6_A110CitaRecetaIndicaciones, T000C6_A111CitaRecetaEstado, T000C6_A112CitaRecetaFecha, T000C6_A19CitaId, T000C6_A25PetitorioId
            }
            , new Object[] {
            T000C7_A19CitaId
            }
            , new Object[] {
            T000C8_A25PetitorioId
            }
            , new Object[] {
            T000C9_A24CitaRecetaId
            }
            , new Object[] {
            T000C10_A24CitaRecetaId
            }
            , new Object[] {
            T000C11_A24CitaRecetaId
            }
            , new Object[] {
            T000C12_A24CitaRecetaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000C15_A24CitaRecetaId
            }
            , new Object[] {
            T000C16_A19CitaId
            }
            , new Object[] {
            T000C17_A25PetitorioId
            }
         }
      );
      Z112CitaRecetaFecha = GXutil.now( ) ;
      A112CitaRecetaFecha = GXutil.now( ) ;
      i112CitaRecetaFecha = GXutil.now( ) ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z113CitaRecetaCantidad ;
   private short Z25PetitorioId ;
   private short A25PetitorioId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A113CitaRecetaCantidad ;
   private short RcdFound19 ;
   private short nIsDirty_19 ;
   private short ZZ25PetitorioId ;
   private short ZZ113CitaRecetaCantidad ;
   private int Z24CitaRecetaId ;
   private int Z19CitaId ;
   private int A19CitaId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int A24CitaRecetaId ;
   private int edtCitaRecetaId_Enabled ;
   private int edtCitaId_Enabled ;
   private int edtPetitorioId_Enabled ;
   private int edtCitaRecetaCantidad_Enabled ;
   private int edtCitaRecetaIndicaciones_Enabled ;
   private int edtCitaRecetaFecha_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ24CitaRecetaId ;
   private int ZZ19CitaId ;
   private String sPrefix ;
   private String Z111CitaRecetaEstado ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCitaRecetaId_Internalname ;
   private String A111CitaRecetaEstado ;
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
   private String edtCitaRecetaId_Jsonclick ;
   private String edtCitaId_Internalname ;
   private String edtCitaId_Jsonclick ;
   private String edtPetitorioId_Internalname ;
   private String edtPetitorioId_Jsonclick ;
   private String edtCitaRecetaCantidad_Internalname ;
   private String edtCitaRecetaCantidad_Jsonclick ;
   private String edtCitaRecetaIndicaciones_Internalname ;
   private String edtCitaRecetaFecha_Internalname ;
   private String edtCitaRecetaFecha_Jsonclick ;
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
   private String sMode19 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String ZZ111CitaRecetaEstado ;
   private java.util.Date Z112CitaRecetaFecha ;
   private java.util.Date A112CitaRecetaFecha ;
   private java.util.Date i112CitaRecetaFecha ;
   private java.util.Date ZZ112CitaRecetaFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Gx_longc ;
   private String Z110CitaRecetaIndicaciones ;
   private String A110CitaRecetaIndicaciones ;
   private String ZZ110CitaRecetaIndicaciones ;
   private HTMLChoice cmbCitaRecetaEstado ;
   private IDataStoreProvider pr_default ;
   private int[] T000C6_A24CitaRecetaId ;
   private short[] T000C6_A113CitaRecetaCantidad ;
   private String[] T000C6_A110CitaRecetaIndicaciones ;
   private String[] T000C6_A111CitaRecetaEstado ;
   private java.util.Date[] T000C6_A112CitaRecetaFecha ;
   private int[] T000C6_A19CitaId ;
   private short[] T000C6_A25PetitorioId ;
   private int[] T000C4_A19CitaId ;
   private short[] T000C5_A25PetitorioId ;
   private int[] T000C7_A19CitaId ;
   private short[] T000C8_A25PetitorioId ;
   private int[] T000C9_A24CitaRecetaId ;
   private int[] T000C3_A24CitaRecetaId ;
   private short[] T000C3_A113CitaRecetaCantidad ;
   private String[] T000C3_A110CitaRecetaIndicaciones ;
   private String[] T000C3_A111CitaRecetaEstado ;
   private java.util.Date[] T000C3_A112CitaRecetaFecha ;
   private int[] T000C3_A19CitaId ;
   private short[] T000C3_A25PetitorioId ;
   private int[] T000C10_A24CitaRecetaId ;
   private int[] T000C11_A24CitaRecetaId ;
   private int[] T000C2_A24CitaRecetaId ;
   private short[] T000C2_A113CitaRecetaCantidad ;
   private String[] T000C2_A110CitaRecetaIndicaciones ;
   private String[] T000C2_A111CitaRecetaEstado ;
   private java.util.Date[] T000C2_A112CitaRecetaFecha ;
   private int[] T000C2_A19CitaId ;
   private short[] T000C2_A25PetitorioId ;
   private int[] T000C12_A24CitaRecetaId ;
   private int[] T000C15_A24CitaRecetaId ;
   private int[] T000C16_A19CitaId ;
   private short[] T000C17_A25PetitorioId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class citareceta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000C2", "SELECT [CitaRecetaId], [CitaRecetaCantidad], [CitaRecetaIndicaciones], [CitaRecetaEstado], [CitaRecetaFecha], [CitaId], [PetitorioId] FROM [CitaReceta] WITH (UPDLOCK) WHERE [CitaRecetaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C3", "SELECT [CitaRecetaId], [CitaRecetaCantidad], [CitaRecetaIndicaciones], [CitaRecetaEstado], [CitaRecetaFecha], [CitaId], [PetitorioId] FROM [CitaReceta] WHERE [CitaRecetaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C4", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C5", "SELECT [PetitorioId] FROM [Petitorio] WHERE [PetitorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C6", "SELECT TM1.[CitaRecetaId], TM1.[CitaRecetaCantidad], TM1.[CitaRecetaIndicaciones], TM1.[CitaRecetaEstado], TM1.[CitaRecetaFecha], TM1.[CitaId], TM1.[PetitorioId] FROM [CitaReceta] TM1 WHERE TM1.[CitaRecetaId] = ? ORDER BY TM1.[CitaRecetaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C7", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C8", "SELECT [PetitorioId] FROM [Petitorio] WHERE [PetitorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C9", "SELECT [CitaRecetaId] FROM [CitaReceta] WHERE [CitaRecetaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C10", "SELECT TOP 1 [CitaRecetaId] FROM [CitaReceta] WHERE ( [CitaRecetaId] > ?) ORDER BY [CitaRecetaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C11", "SELECT TOP 1 [CitaRecetaId] FROM [CitaReceta] WHERE ( [CitaRecetaId] < ?) ORDER BY [CitaRecetaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000C12", "INSERT INTO [CitaReceta]([CitaRecetaCantidad], [CitaRecetaIndicaciones], [CitaRecetaEstado], [CitaRecetaFecha], [CitaId], [PetitorioId]) VALUES(?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000C13", "UPDATE [CitaReceta] SET [CitaRecetaCantidad]=?, [CitaRecetaIndicaciones]=?, [CitaRecetaEstado]=?, [CitaRecetaFecha]=?, [CitaId]=?, [PetitorioId]=?  WHERE [CitaRecetaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000C14", "DELETE FROM [CitaReceta]  WHERE [CitaRecetaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000C15", "SELECT [CitaRecetaId] FROM [CitaReceta] ORDER BY [CitaRecetaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C16", "SELECT [CitaId] FROM [Cita] WHERE [CitaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000C17", "SELECT [PetitorioId] FROM [Petitorio] WHERE [PetitorioId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
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
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setString(3, (String)parms[2], 1);
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

