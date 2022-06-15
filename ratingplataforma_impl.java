package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ratingplataforma_impl extends GXDataArea
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
         Form.getMeta().addItem("description", "Rating Plataforma", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtRatingPlataformaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public ratingplataforma_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ratingplataforma_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ratingplataforma_impl.class ));
   }

   public ratingplataforma_impl( int remoteHandle ,
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Rating Plataforma", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_RatingPlataforma.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_RatingPlataforma.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRatingPlataformaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRatingPlataformaId_Internalname, "Plataforma Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRatingPlataformaId_Internalname, GXutil.ltrim( localUtil.ntoc( A398RatingPlataformaId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtRatingPlataformaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A398RatingPlataformaId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A398RatingPlataformaId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRatingPlataformaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRatingPlataformaId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RatingPlataforma.htm");
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
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSGPacientePacienteId_Internalname, GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtSGPacientePacienteId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSGPacientePacienteId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSGPacientePacienteId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRatingPlataformaCitaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRatingPlataformaCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRatingPlataformaCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A405RatingPlataformaCitaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtRatingPlataformaCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A405RatingPlataformaCitaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A405RatingPlataformaCitaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRatingPlataformaCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRatingPlataformaCitaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", -1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+Ratingplataformarating_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, Ratingplataformarating_Internalname, "Plataforma Rating", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* User Defined Control */
      ucRatingplataformarating.setProperty("Attribute", RatingPlataformaRating);
      ucRatingplataformarating.setProperty("CaptionClass", Ratingplataformarating_Captionclass);
      ucRatingplataformarating.setProperty("CaptionStyle", Ratingplataformarating_Captionstyle);
      ucRatingplataformarating.setProperty("CaptionPosition", Ratingplataformarating_Captionposition);
      ucRatingplataformarating.render(context, "rating", Ratingplataformarating_Internalname, "RATINGPLATAFORMARATINGContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRatingPlataformaFechaRegistro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRatingPlataformaFechaRegistro_Internalname, "Fecha Registro", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtRatingPlataformaFechaRegistro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRatingPlataformaFechaRegistro_Internalname, localUtil.format(A406RatingPlataformaFechaRegistro, "99/99/99"), localUtil.format( A406RatingPlataformaFechaRegistro, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRatingPlataformaFechaRegistro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRatingPlataformaFechaRegistro_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtRatingPlataformaFechaRegistro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtRatingPlataformaFechaRegistro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_RatingPlataforma.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingPlataforma.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingPlataforma.htm");
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
         Z398RatingPlataformaId = (int)(localUtil.ctol( httpContext.cgiGet( "Z398RatingPlataformaId"), ",", ".")) ;
         Z405RatingPlataformaCitaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z405RatingPlataformaCitaId"), ",", ".")) ;
         Z401RatingPlataformaRating = (short)(localUtil.ctol( httpContext.cgiGet( "Z401RatingPlataformaRating"), ",", ".")) ;
         Z406RatingPlataformaFechaRegistro = localUtil.ctod( httpContext.cgiGet( "Z406RatingPlataformaFechaRegistro"), 0) ;
         Z61SGPacientePacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z61SGPacientePacienteId"), ",", ".")) ;
         A401RatingPlataformaRating = (short)(localUtil.ctol( httpContext.cgiGet( "Z401RatingPlataformaRating"), ",", ".")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         A401RatingPlataformaRating = (short)(localUtil.ctol( httpContext.cgiGet( "RATINGPLATAFORMARATING"), ",", ".")) ;
         Ratingplataformarating_Objectcall = httpContext.cgiGet( "RATINGPLATAFORMARATING_Objectcall") ;
         Ratingplataformarating_Class = httpContext.cgiGet( "RATINGPLATAFORMARATING_Class") ;
         Ratingplataformarating_Enabled = GXutil.strtobool( httpContext.cgiGet( "RATINGPLATAFORMARATING_Enabled")) ;
         Ratingplataformarating_Maxvalue = (int)(localUtil.ctol( httpContext.cgiGet( "RATINGPLATAFORMARATING_Maxvalue"), ",", ".")) ;
         Ratingplataformarating_Step = (int)(localUtil.ctol( httpContext.cgiGet( "RATINGPLATAFORMARATING_Step"), ",", ".")) ;
         Ratingplataformarating_Ratingclass = httpContext.cgiGet( "RATINGPLATAFORMARATING_Ratingclass") ;
         Ratingplataformarating_Captionvalue = httpContext.cgiGet( "RATINGPLATAFORMARATING_Captionvalue") ;
         Ratingplataformarating_Captionclass = httpContext.cgiGet( "RATINGPLATAFORMARATING_Captionclass") ;
         Ratingplataformarating_Captionstyle = httpContext.cgiGet( "RATINGPLATAFORMARATING_Captionstyle") ;
         Ratingplataformarating_Captionposition = httpContext.cgiGet( "RATINGPLATAFORMARATING_Captionposition") ;
         Ratingplataformarating_Isabstractlayoutcontrol = GXutil.strtobool( httpContext.cgiGet( "RATINGPLATAFORMARATING_Isabstractlayoutcontrol")) ;
         Ratingplataformarating_Coltitle = httpContext.cgiGet( "RATINGPLATAFORMARATING_Coltitle") ;
         Ratingplataformarating_Coltitlefont = httpContext.cgiGet( "RATINGPLATAFORMARATING_Coltitlefont") ;
         Ratingplataformarating_Coltitlecolor = (int)(localUtil.ctol( httpContext.cgiGet( "RATINGPLATAFORMARATING_Coltitlecolor"), ",", ".")) ;
         Ratingplataformarating_Usercontroliscolumn = GXutil.strtobool( httpContext.cgiGet( "RATINGPLATAFORMARATING_Usercontroliscolumn")) ;
         Ratingplataformarating_Visible = GXutil.strtobool( httpContext.cgiGet( "RATINGPLATAFORMARATING_Visible")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRatingPlataformaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRatingPlataformaId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RATINGPLATAFORMAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtRatingPlataformaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A398RatingPlataformaId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
         }
         else
         {
            A398RatingPlataformaId = (int)(localUtil.ctol( httpContext.cgiGet( edtRatingPlataformaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
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
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRatingPlataformaCitaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRatingPlataformaCitaId_Internalname), ",", ".") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RATINGPLATAFORMACITAID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtRatingPlataformaCitaId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A405RatingPlataformaCitaId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A405RatingPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A405RatingPlataformaCitaId), 4, 0));
         }
         else
         {
            A405RatingPlataformaCitaId = (short)(localUtil.ctol( httpContext.cgiGet( edtRatingPlataformaCitaId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A405RatingPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A405RatingPlataformaCitaId), 4, 0));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtRatingPlataformaFechaRegistro_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "RATINGPLATAFORMAFECHAREGISTRO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtRatingPlataformaFechaRegistro_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A406RatingPlataformaFechaRegistro", localUtil.format(A406RatingPlataformaFechaRegistro, "99/99/99"));
         }
         else
         {
            A406RatingPlataformaFechaRegistro = localUtil.ctod( httpContext.cgiGet( edtRatingPlataformaFechaRegistro_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A406RatingPlataformaFechaRegistro", localUtil.format(A406RatingPlataformaFechaRegistro, "99/99/99"));
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
            A398RatingPlataformaId = (int)(GXutil.lval( httpContext.GetPar( "RatingPlataformaId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
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
            initAll1753( ) ;
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
      disableAttributes1753( ) ;
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

   public void resetCaption170( )
   {
   }

   public void zm1753( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z405RatingPlataformaCitaId = T00173_A405RatingPlataformaCitaId[0] ;
            Z401RatingPlataformaRating = T00173_A401RatingPlataformaRating[0] ;
            Z406RatingPlataformaFechaRegistro = T00173_A406RatingPlataformaFechaRegistro[0] ;
            Z61SGPacientePacienteId = T00173_A61SGPacientePacienteId[0] ;
         }
         else
         {
            Z405RatingPlataformaCitaId = A405RatingPlataformaCitaId ;
            Z401RatingPlataformaRating = A401RatingPlataformaRating ;
            Z406RatingPlataformaFechaRegistro = A406RatingPlataformaFechaRegistro ;
            Z61SGPacientePacienteId = A61SGPacientePacienteId ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z398RatingPlataformaId = A398RatingPlataformaId ;
         Z405RatingPlataformaCitaId = A405RatingPlataformaCitaId ;
         Z401RatingPlataformaRating = A401RatingPlataformaRating ;
         Z406RatingPlataformaFechaRegistro = A406RatingPlataformaFechaRegistro ;
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

   public void load1753( )
   {
      /* Using cursor T00175 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A405RatingPlataformaCitaId = T00175_A405RatingPlataformaCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A405RatingPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A405RatingPlataformaCitaId), 4, 0));
         A401RatingPlataformaRating = T00175_A401RatingPlataformaRating[0] ;
         A406RatingPlataformaFechaRegistro = T00175_A406RatingPlataformaFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A406RatingPlataformaFechaRegistro", localUtil.format(A406RatingPlataformaFechaRegistro, "99/99/99"));
         A61SGPacientePacienteId = T00175_A61SGPacientePacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         zm1753( -2) ;
      }
      pr_default.close(3);
      onLoadActions1753( ) ;
   }

   public void onLoadActions1753( )
   {
   }

   public void checkExtendedTable1753( )
   {
      nIsDirty_53 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00174 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSGPacientePacienteId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A406RatingPlataformaFechaRegistro)) || (( GXutil.resetTime(A406RatingPlataformaFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A406RatingPlataformaFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Rating Plataforma Fecha Registro fuera de rango", "OutOfRange", 1, "RATINGPLATAFORMAFECHAREGISTRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRatingPlataformaFechaRegistro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1753( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_3( int A61SGPacientePacienteId )
   {
      /* Using cursor T00176 */
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

   public void getKey1753( )
   {
      /* Using cursor T00177 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound53 = (short)(1) ;
      }
      else
      {
         RcdFound53 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00173 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1753( 2) ;
         RcdFound53 = (short)(1) ;
         A398RatingPlataformaId = T00173_A398RatingPlataformaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
         A405RatingPlataformaCitaId = T00173_A405RatingPlataformaCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A405RatingPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A405RatingPlataformaCitaId), 4, 0));
         A401RatingPlataformaRating = T00173_A401RatingPlataformaRating[0] ;
         A406RatingPlataformaFechaRegistro = T00173_A406RatingPlataformaFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A406RatingPlataformaFechaRegistro", localUtil.format(A406RatingPlataformaFechaRegistro, "99/99/99"));
         A61SGPacientePacienteId = T00173_A61SGPacientePacienteId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
         Z398RatingPlataformaId = A398RatingPlataformaId ;
         sMode53 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1753( ) ;
         if ( AnyError == 1 )
         {
            RcdFound53 = (short)(0) ;
            initializeNonKey1753( ) ;
         }
         Gx_mode = sMode53 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound53 = (short)(0) ;
         initializeNonKey1753( ) ;
         sMode53 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode53 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1753( ) ;
      if ( RcdFound53 == 0 )
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
      RcdFound53 = (short)(0) ;
      /* Using cursor T00178 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00178_A398RatingPlataformaId[0] < A398RatingPlataformaId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00178_A398RatingPlataformaId[0] > A398RatingPlataformaId ) ) )
         {
            A398RatingPlataformaId = T00178_A398RatingPlataformaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
            RcdFound53 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound53 = (short)(0) ;
      /* Using cursor T00179 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00179_A398RatingPlataformaId[0] > A398RatingPlataformaId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00179_A398RatingPlataformaId[0] < A398RatingPlataformaId ) ) )
         {
            A398RatingPlataformaId = T00179_A398RatingPlataformaId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
            RcdFound53 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1753( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtRatingPlataformaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1753( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound53 == 1 )
         {
            if ( A398RatingPlataformaId != Z398RatingPlataformaId )
            {
               A398RatingPlataformaId = Z398RatingPlataformaId ;
               httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "RATINGPLATAFORMAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRatingPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtRatingPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update1753( ) ;
               GX_FocusControl = edtRatingPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A398RatingPlataformaId != Z398RatingPlataformaId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtRatingPlataformaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1753( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "RATINGPLATAFORMAID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtRatingPlataformaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtRatingPlataformaId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1753( ) ;
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
      if ( A398RatingPlataformaId != Z398RatingPlataformaId )
      {
         A398RatingPlataformaId = Z398RatingPlataformaId ;
         httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "RATINGPLATAFORMAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRatingPlataformaId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtRatingPlataformaId_Internalname ;
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
      if ( RcdFound53 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "RATINGPLATAFORMAID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRatingPlataformaId_Internalname ;
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
      scanStart1753( ) ;
      if ( RcdFound53 == 0 )
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
      scanEnd1753( ) ;
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
      if ( RcdFound53 == 0 )
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
      if ( RcdFound53 == 0 )
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
      scanStart1753( ) ;
      if ( RcdFound53 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound53 != 0 )
         {
            scanNext1753( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtSGPacientePacienteId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1753( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1753( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00172 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingPlataforma"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z405RatingPlataformaCitaId != T00172_A405RatingPlataformaCitaId[0] ) || ( Z401RatingPlataformaRating != T00172_A401RatingPlataformaRating[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z406RatingPlataformaFechaRegistro), GXutil.resetTime(T00172_A406RatingPlataformaFechaRegistro[0])) ) || ( Z61SGPacientePacienteId != T00172_A61SGPacientePacienteId[0] ) )
         {
            if ( Z405RatingPlataformaCitaId != T00172_A405RatingPlataformaCitaId[0] )
            {
               GXutil.writeLogln("ratingplataforma:[seudo value changed for attri]"+"RatingPlataformaCitaId");
               GXutil.writeLogRaw("Old: ",Z405RatingPlataformaCitaId);
               GXutil.writeLogRaw("Current: ",T00172_A405RatingPlataformaCitaId[0]);
            }
            if ( Z401RatingPlataformaRating != T00172_A401RatingPlataformaRating[0] )
            {
               GXutil.writeLogln("ratingplataforma:[seudo value changed for attri]"+"RatingPlataformaRating");
               GXutil.writeLogRaw("Old: ",Z401RatingPlataformaRating);
               GXutil.writeLogRaw("Current: ",T00172_A401RatingPlataformaRating[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z406RatingPlataformaFechaRegistro), GXutil.resetTime(T00172_A406RatingPlataformaFechaRegistro[0])) ) )
            {
               GXutil.writeLogln("ratingplataforma:[seudo value changed for attri]"+"RatingPlataformaFechaRegistro");
               GXutil.writeLogRaw("Old: ",Z406RatingPlataformaFechaRegistro);
               GXutil.writeLogRaw("Current: ",T00172_A406RatingPlataformaFechaRegistro[0]);
            }
            if ( Z61SGPacientePacienteId != T00172_A61SGPacientePacienteId[0] )
            {
               GXutil.writeLogln("ratingplataforma:[seudo value changed for attri]"+"SGPacientePacienteId");
               GXutil.writeLogRaw("Old: ",Z61SGPacientePacienteId);
               GXutil.writeLogRaw("Current: ",T00172_A61SGPacientePacienteId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"RatingPlataforma"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1753( )
   {
      beforeValidate1753( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1753( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1753( 0) ;
         checkOptimisticConcurrency1753( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1753( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1753( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001710 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A405RatingPlataformaCitaId), Short.valueOf(A401RatingPlataformaRating), A406RatingPlataformaFechaRegistro, Integer.valueOf(A61SGPacientePacienteId)});
                  A398RatingPlataformaId = T001710_A398RatingPlataformaId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingPlataforma");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption170( ) ;
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
            load1753( ) ;
         }
         endLevel1753( ) ;
      }
      closeExtendedTableCursors1753( ) ;
   }

   public void update1753( )
   {
      beforeValidate1753( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1753( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1753( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1753( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1753( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001711 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A405RatingPlataformaCitaId), Short.valueOf(A401RatingPlataformaRating), A406RatingPlataformaFechaRegistro, Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A398RatingPlataformaId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingPlataforma");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingPlataforma"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1753( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption170( ) ;
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
         endLevel1753( ) ;
      }
      closeExtendedTableCursors1753( ) ;
   }

   public void deferredUpdate1753( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1753( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1753( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1753( ) ;
         afterConfirm1753( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1753( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001712 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A398RatingPlataformaId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingPlataforma");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound53 == 0 )
                     {
                        initAll1753( ) ;
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
                     resetCaption170( ) ;
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
      sMode53 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1753( ) ;
      Gx_mode = sMode53 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1753( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1753( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1753( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "ratingplataforma");
         if ( AnyError == 0 )
         {
            confirmValues170( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "ratingplataforma");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1753( )
   {
      /* Using cursor T001713 */
      pr_default.execute(11);
      RcdFound53 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A398RatingPlataformaId = T001713_A398RatingPlataformaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1753( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound53 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound53 = (short)(1) ;
         A398RatingPlataformaId = T001713_A398RatingPlataformaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
      }
   }

   public void scanEnd1753( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1753( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1753( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1753( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1753( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1753( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1753( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1753( )
   {
      edtRatingPlataformaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRatingPlataformaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRatingPlataformaId_Enabled), 5, 0), true);
      edtSGPacientePacienteId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSGPacientePacienteId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSGPacientePacienteId_Enabled), 5, 0), true);
      edtRatingPlataformaCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRatingPlataformaCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRatingPlataformaCitaId_Enabled), 5, 0), true);
      edtRatingPlataformaFechaRegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRatingPlataformaFechaRegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRatingPlataformaFechaRegistro_Enabled), 5, 0), true);
      Ratingplataformarating_Enabled = GXutil.toBoolean( 0) ;
      httpContext.ajax_rsp_assign_prop("", false, Ratingplataformarating_Internalname, "Enabled", GXutil.booltostr( Ratingplataformarating_Enabled), true);
   }

   public void send_integrity_lvl_hashes1753( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues170( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033781", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("Rating/rating.min.js", "", false, true);
      httpContext.AddJavascriptSource("Rating/RatingRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.ratingplataforma", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z398RatingPlataformaId", GXutil.ltrim( localUtil.ntoc( Z398RatingPlataformaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z405RatingPlataformaCitaId", GXutil.ltrim( localUtil.ntoc( Z405RatingPlataformaCitaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z401RatingPlataformaRating", GXutil.ltrim( localUtil.ntoc( Z401RatingPlataformaRating, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z406RatingPlataformaFechaRegistro", localUtil.dtoc( Z406RatingPlataformaFechaRegistro, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMARATING", GXutil.ltrim( localUtil.ntoc( A401RatingPlataformaRating, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMARATING_Objectcall", GXutil.rtrim( Ratingplataformarating_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMARATING_Enabled", GXutil.booltostr( Ratingplataformarating_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMARATING_Captionclass", GXutil.rtrim( Ratingplataformarating_Captionclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMARATING_Captionstyle", GXutil.rtrim( Ratingplataformarating_Captionstyle));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPLATAFORMARATING_Captionposition", GXutil.rtrim( Ratingplataformarating_Captionposition));
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
      return formatLink("com.projectthani.ratingplataforma", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "RatingPlataforma" ;
   }

   public String getPgmdesc( )
   {
      return "Rating Plataforma" ;
   }

   public void initializeNonKey1753( )
   {
      A61SGPacientePacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
      A405RatingPlataformaCitaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A405RatingPlataformaCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A405RatingPlataformaCitaId), 4, 0));
      A401RatingPlataformaRating = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A401RatingPlataformaRating", GXutil.ltrimstr( DecimalUtil.doubleToDec(A401RatingPlataformaRating), 4, 0));
      A406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A406RatingPlataformaFechaRegistro", localUtil.format(A406RatingPlataformaFechaRegistro, "99/99/99"));
      Z405RatingPlataformaCitaId = (short)(0) ;
      Z401RatingPlataformaRating = (short)(0) ;
      Z406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      Z61SGPacientePacienteId = 0 ;
   }

   public void initAll1753( )
   {
      A398RatingPlataformaId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A398RatingPlataformaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A398RatingPlataformaId), 8, 0));
      initializeNonKey1753( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("Rating/rating.min.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033786", true, true);
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
      httpContext.AddJavascriptSource("ratingplataforma.js", "?2022511033786", false, true);
      httpContext.AddJavascriptSource("Rating/rating.min.js", "", false, true);
      httpContext.AddJavascriptSource("Rating/RatingRender.js", "", false, true);
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
      edtRatingPlataformaId_Internalname = "RATINGPLATAFORMAID" ;
      edtSGPacientePacienteId_Internalname = "SGPACIENTEPACIENTEID" ;
      edtRatingPlataformaCitaId_Internalname = "RATINGPLATAFORMACITAID" ;
      Ratingplataformarating_Internalname = "RATINGPLATAFORMARATING" ;
      edtRatingPlataformaFechaRegistro_Internalname = "RATINGPLATAFORMAFECHAREGISTRO" ;
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
      Form.setCaption( "Rating Plataforma" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtRatingPlataformaFechaRegistro_Jsonclick = "" ;
      edtRatingPlataformaFechaRegistro_Enabled = 1 ;
      Ratingplataformarating_Captionposition = "Left" ;
      Ratingplataformarating_Captionstyle = "" ;
      Ratingplataformarating_Captionclass = "col-sm-3 AttributeLabel" ;
      Ratingplataformarating_Enabled = GXutil.toBoolean( 1) ;
      edtRatingPlataformaCitaId_Jsonclick = "" ;
      edtRatingPlataformaCitaId_Enabled = 1 ;
      edtSGPacientePacienteId_Jsonclick = "" ;
      edtSGPacientePacienteId_Enabled = 1 ;
      edtRatingPlataformaId_Jsonclick = "" ;
      edtRatingPlataformaId_Enabled = 1 ;
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

   public void valid_Ratingplataformaid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A405RatingPlataformaCitaId", GXutil.ltrim( localUtil.ntoc( A405RatingPlataformaCitaId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A401RatingPlataformaRating", GXutil.ltrim( localUtil.ntoc( A401RatingPlataformaRating, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A406RatingPlataformaFechaRegistro", localUtil.format(A406RatingPlataformaFechaRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z398RatingPlataformaId", GXutil.ltrim( localUtil.ntoc( Z398RatingPlataformaId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z405RatingPlataformaCitaId", GXutil.ltrim( localUtil.ntoc( Z405RatingPlataformaCitaId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z401RatingPlataformaRating", GXutil.ltrim( localUtil.ntoc( Z401RatingPlataformaRating, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z406RatingPlataformaFechaRegistro", localUtil.format(Z406RatingPlataformaFechaRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Sgpacientepacienteid( )
   {
      /* Using cursor T001714 */
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
      setEventMetadata("VALID_RATINGPLATAFORMAID","{handler:'valid_Ratingplataformaid',iparms:[{av:'A398RatingPlataformaId',fld:'RATINGPLATAFORMAID',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_RATINGPLATAFORMAID",",oparms:[{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'},{av:'A405RatingPlataformaCitaId',fld:'RATINGPLATAFORMACITAID',pic:'ZZZ9'},{av:'A401RatingPlataformaRating',fld:'RATINGPLATAFORMARATING',pic:'ZZZ9'},{av:'A406RatingPlataformaFechaRegistro',fld:'RATINGPLATAFORMAFECHAREGISTRO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z398RatingPlataformaId'},{av:'Z61SGPacientePacienteId'},{av:'Z405RatingPlataformaCitaId'},{av:'Z401RatingPlataformaRating'},{av:'Z406RatingPlataformaFechaRegistro'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_SGPACIENTEPACIENTEID","{handler:'valid_Sgpacientepacienteid',iparms:[{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_SGPACIENTEPACIENTEID",",oparms:[]}");
      setEventMetadata("VALID_RATINGPLATAFORMAFECHAREGISTRO","{handler:'valid_Ratingplataformafecharegistro',iparms:[]");
      setEventMetadata("VALID_RATINGPLATAFORMAFECHAREGISTRO",",oparms:[]}");
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
      Z406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
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
      ucRatingplataformarating = new com.genexus.webpanels.GXUserControl();
      A406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      Ratingplataformarating_Objectcall = "" ;
      Ratingplataformarating_Class = "" ;
      Ratingplataformarating_Ratingclass = "" ;
      Ratingplataformarating_Captionvalue = "" ;
      Ratingplataformarating_Coltitle = "" ;
      Ratingplataformarating_Coltitlefont = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      T00175_A398RatingPlataformaId = new int[1] ;
      T00175_A405RatingPlataformaCitaId = new short[1] ;
      T00175_A401RatingPlataformaRating = new short[1] ;
      T00175_A406RatingPlataformaFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00175_A61SGPacientePacienteId = new int[1] ;
      T00174_A61SGPacientePacienteId = new int[1] ;
      T00176_A61SGPacientePacienteId = new int[1] ;
      T00177_A398RatingPlataformaId = new int[1] ;
      T00173_A398RatingPlataformaId = new int[1] ;
      T00173_A405RatingPlataformaCitaId = new short[1] ;
      T00173_A401RatingPlataformaRating = new short[1] ;
      T00173_A406RatingPlataformaFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00173_A61SGPacientePacienteId = new int[1] ;
      sMode53 = "" ;
      T00178_A398RatingPlataformaId = new int[1] ;
      T00179_A398RatingPlataformaId = new int[1] ;
      T00172_A398RatingPlataformaId = new int[1] ;
      T00172_A405RatingPlataformaCitaId = new short[1] ;
      T00172_A401RatingPlataformaRating = new short[1] ;
      T00172_A406RatingPlataformaFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00172_A61SGPacientePacienteId = new int[1] ;
      T001710_A398RatingPlataformaId = new int[1] ;
      T001713_A398RatingPlataformaId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ406RatingPlataformaFechaRegistro = GXutil.nullDate() ;
      T001714_A61SGPacientePacienteId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ratingplataforma__default(),
         new Object[] {
             new Object[] {
            T00172_A398RatingPlataformaId, T00172_A405RatingPlataformaCitaId, T00172_A401RatingPlataformaRating, T00172_A406RatingPlataformaFechaRegistro, T00172_A61SGPacientePacienteId
            }
            , new Object[] {
            T00173_A398RatingPlataformaId, T00173_A405RatingPlataformaCitaId, T00173_A401RatingPlataformaRating, T00173_A406RatingPlataformaFechaRegistro, T00173_A61SGPacientePacienteId
            }
            , new Object[] {
            T00174_A61SGPacientePacienteId
            }
            , new Object[] {
            T00175_A398RatingPlataformaId, T00175_A405RatingPlataformaCitaId, T00175_A401RatingPlataformaRating, T00175_A406RatingPlataformaFechaRegistro, T00175_A61SGPacientePacienteId
            }
            , new Object[] {
            T00176_A61SGPacientePacienteId
            }
            , new Object[] {
            T00177_A398RatingPlataformaId
            }
            , new Object[] {
            T00178_A398RatingPlataformaId
            }
            , new Object[] {
            T00179_A398RatingPlataformaId
            }
            , new Object[] {
            T001710_A398RatingPlataformaId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001713_A398RatingPlataformaId
            }
            , new Object[] {
            T001714_A61SGPacientePacienteId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z405RatingPlataformaCitaId ;
   private short Z401RatingPlataformaRating ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A405RatingPlataformaCitaId ;
   private short RatingPlataformaRating ;
   private short A401RatingPlataformaRating ;
   private short RcdFound53 ;
   private short nIsDirty_53 ;
   private short ZZ405RatingPlataformaCitaId ;
   private short ZZ401RatingPlataformaRating ;
   private int Z398RatingPlataformaId ;
   private int Z61SGPacientePacienteId ;
   private int A61SGPacientePacienteId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int A398RatingPlataformaId ;
   private int edtRatingPlataformaId_Enabled ;
   private int edtSGPacientePacienteId_Enabled ;
   private int edtRatingPlataformaCitaId_Enabled ;
   private int edtRatingPlataformaFechaRegistro_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int Ratingplataformarating_Maxvalue ;
   private int Ratingplataformarating_Step ;
   private int Ratingplataformarating_Coltitlecolor ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ398RatingPlataformaId ;
   private int ZZ61SGPacientePacienteId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtRatingPlataformaId_Internalname ;
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
   private String edtRatingPlataformaId_Jsonclick ;
   private String edtSGPacientePacienteId_Internalname ;
   private String edtSGPacientePacienteId_Jsonclick ;
   private String edtRatingPlataformaCitaId_Internalname ;
   private String edtRatingPlataformaCitaId_Jsonclick ;
   private String Ratingplataformarating_Internalname ;
   private String Ratingplataformarating_Captionclass ;
   private String Ratingplataformarating_Captionstyle ;
   private String Ratingplataformarating_Captionposition ;
   private String edtRatingPlataformaFechaRegistro_Internalname ;
   private String edtRatingPlataformaFechaRegistro_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String Gx_mode ;
   private String Ratingplataformarating_Objectcall ;
   private String Ratingplataformarating_Class ;
   private String Ratingplataformarating_Ratingclass ;
   private String Ratingplataformarating_Captionvalue ;
   private String Ratingplataformarating_Coltitle ;
   private String Ratingplataformarating_Coltitlefont ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode53 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z406RatingPlataformaFechaRegistro ;
   private java.util.Date A406RatingPlataformaFechaRegistro ;
   private java.util.Date ZZ406RatingPlataformaFechaRegistro ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Ratingplataformarating_Enabled ;
   private boolean Ratingplataformarating_Isabstractlayoutcontrol ;
   private boolean Ratingplataformarating_Usercontroliscolumn ;
   private boolean Ratingplataformarating_Visible ;
   private com.genexus.webpanels.GXUserControl ucRatingplataformarating ;
   private IDataStoreProvider pr_default ;
   private int[] T00175_A398RatingPlataformaId ;
   private short[] T00175_A405RatingPlataformaCitaId ;
   private short[] T00175_A401RatingPlataformaRating ;
   private java.util.Date[] T00175_A406RatingPlataformaFechaRegistro ;
   private int[] T00175_A61SGPacientePacienteId ;
   private int[] T00174_A61SGPacientePacienteId ;
   private int[] T00176_A61SGPacientePacienteId ;
   private int[] T00177_A398RatingPlataformaId ;
   private int[] T00173_A398RatingPlataformaId ;
   private short[] T00173_A405RatingPlataformaCitaId ;
   private short[] T00173_A401RatingPlataformaRating ;
   private java.util.Date[] T00173_A406RatingPlataformaFechaRegistro ;
   private int[] T00173_A61SGPacientePacienteId ;
   private int[] T00178_A398RatingPlataformaId ;
   private int[] T00179_A398RatingPlataformaId ;
   private int[] T00172_A398RatingPlataformaId ;
   private short[] T00172_A405RatingPlataformaCitaId ;
   private short[] T00172_A401RatingPlataformaRating ;
   private java.util.Date[] T00172_A406RatingPlataformaFechaRegistro ;
   private int[] T00172_A61SGPacientePacienteId ;
   private int[] T001710_A398RatingPlataformaId ;
   private int[] T001713_A398RatingPlataformaId ;
   private int[] T001714_A61SGPacientePacienteId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class ratingplataforma__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00172", "SELECT [RatingPlataformaId], [RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] WITH (UPDLOCK) WHERE [RatingPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00173", "SELECT [RatingPlataformaId], [RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] WHERE [RatingPlataformaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00174", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00175", "SELECT TM1.[RatingPlataformaId], TM1.[RatingPlataformaCitaId], TM1.[RatingPlataformaRating], TM1.[RatingPlataformaFechaRegistro], TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingPlataforma] TM1 WHERE TM1.[RatingPlataformaId] = ? ORDER BY TM1.[RatingPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00176", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00177", "SELECT [RatingPlataformaId] FROM [RatingPlataforma] WHERE [RatingPlataformaId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00178", "SELECT TOP 1 [RatingPlataformaId] FROM [RatingPlataforma] WHERE ( [RatingPlataformaId] > ?) ORDER BY [RatingPlataformaId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00179", "SELECT TOP 1 [RatingPlataformaId] FROM [RatingPlataforma] WHERE ( [RatingPlataformaId] < ?) ORDER BY [RatingPlataformaId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001710", "INSERT INTO [RatingPlataforma]([RatingPlataformaCitaId], [RatingPlataformaRating], [RatingPlataformaFechaRegistro], [SGPacientePacienteId]) VALUES(?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T001711", "UPDATE [RatingPlataforma] SET [RatingPlataformaCitaId]=?, [RatingPlataformaRating]=?, [RatingPlataformaFechaRegistro]=?, [SGPacientePacienteId]=?  WHERE [RatingPlataformaId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001712", "DELETE FROM [RatingPlataforma]  WHERE [RatingPlataformaId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001713", "SELECT [RatingPlataformaId] FROM [RatingPlataforma] ORDER BY [RatingPlataformaId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001714", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
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

