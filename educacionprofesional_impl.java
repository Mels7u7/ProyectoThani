package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class educacionprofesional_impl extends GXDataArea
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
         A31ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_4( A31ProfesionalId) ;
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
         Form.getMeta().addItem("description", "Educacion Profesional", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtEducacionProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public educacionprofesional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public educacionprofesional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( educacionprofesional_impl.class ));
   }

   public educacionprofesional_impl( int remoteHandle ,
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Educacion Profesional", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_EducacionProfesional.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_EducacionProfesional.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEducacionProfesionalId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEducacionProfesionalId_Internalname, "Profesional Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEducacionProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A59EducacionProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtEducacionProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A59EducacionProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A59EducacionProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEducacionProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEducacionProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_EducacionProfesional.htm");
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
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEducacionProfesionalNombreInstitucion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEducacionProfesionalNombreInstitucion_Internalname, "Nombre Institucion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtEducacionProfesionalNombreInstitucion_Internalname, A334EducacionProfesionalNombreInstitucion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", (short)(0), 1, edtEducacionProfesionalNombreInstitucion_Enabled, 0, 80, "chr", 4, "row", StyleString, ClassString, "", "", "300", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEducacionProfesionalPais_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEducacionProfesionalPais_Internalname, "Profesional Pais", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEducacionProfesionalPais_Internalname, A335EducacionProfesionalPais, GXutil.rtrim( localUtil.format( A335EducacionProfesionalPais, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEducacionProfesionalPais_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEducacionProfesionalPais_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEducacionProfesionalDesde_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEducacionProfesionalDesde_Internalname, "Profesional Desde", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtEducacionProfesionalDesde_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEducacionProfesionalDesde_Internalname, localUtil.format(A336EducacionProfesionalDesde, "99/99/99"), localUtil.format( A336EducacionProfesionalDesde, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEducacionProfesionalDesde_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEducacionProfesionalDesde_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtEducacionProfesionalDesde_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtEducacionProfesionalDesde_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_EducacionProfesional.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEducacionProfesionalHasta_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtEducacionProfesionalHasta_Internalname, "Profesional Hasta", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtEducacionProfesionalHasta_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtEducacionProfesionalHasta_Internalname, localUtil.format(A337EducacionProfesionalHasta, "99/99/99"), localUtil.format( A337EducacionProfesionalHasta, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEducacionProfesionalHasta_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEducacionProfesionalHasta_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtEducacionProfesionalHasta_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtEducacionProfesionalHasta_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_EducacionProfesional.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EducacionProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EducacionProfesional.htm");
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
         Z59EducacionProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z59EducacionProfesionalId"), ",", ".")) ;
         Z334EducacionProfesionalNombreInstitucion = httpContext.cgiGet( "Z334EducacionProfesionalNombreInstitucion") ;
         Z335EducacionProfesionalPais = httpContext.cgiGet( "Z335EducacionProfesionalPais") ;
         Z336EducacionProfesionalDesde = localUtil.ctod( httpContext.cgiGet( "Z336EducacionProfesionalDesde"), 0) ;
         Z337EducacionProfesionalHasta = localUtil.ctod( httpContext.cgiGet( "Z337EducacionProfesionalHasta"), 0) ;
         Z31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z31ProfesionalId"), ",", ".")) ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEducacionProfesionalId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEducacionProfesionalId_Internalname), ",", ".") > 99999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EDUCACIONPROFESIONALID");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEducacionProfesionalId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A59EducacionProfesionalId = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
         }
         else
         {
            A59EducacionProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtEducacionProfesionalId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
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
         A334EducacionProfesionalNombreInstitucion = httpContext.cgiGet( edtEducacionProfesionalNombreInstitucion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A334EducacionProfesionalNombreInstitucion", A334EducacionProfesionalNombreInstitucion);
         A335EducacionProfesionalPais = httpContext.cgiGet( edtEducacionProfesionalPais_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A335EducacionProfesionalPais", A335EducacionProfesionalPais);
         if ( localUtil.vcdate( httpContext.cgiGet( edtEducacionProfesionalDesde_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "EDUCACIONPROFESIONALDESDE");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEducacionProfesionalDesde_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A336EducacionProfesionalDesde = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A336EducacionProfesionalDesde", localUtil.format(A336EducacionProfesionalDesde, "99/99/99"));
         }
         else
         {
            A336EducacionProfesionalDesde = localUtil.ctod( httpContext.cgiGet( edtEducacionProfesionalDesde_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A336EducacionProfesionalDesde", localUtil.format(A336EducacionProfesionalDesde, "99/99/99"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtEducacionProfesionalHasta_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "EDUCACIONPROFESIONALHASTA");
            AnyError = (short)(1) ;
            GX_FocusControl = edtEducacionProfesionalHasta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            A337EducacionProfesionalHasta = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "A337EducacionProfesionalHasta", localUtil.format(A337EducacionProfesionalHasta, "99/99/99"));
         }
         else
         {
            A337EducacionProfesionalHasta = localUtil.ctod( httpContext.cgiGet( edtEducacionProfesionalHasta_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "A337EducacionProfesionalHasta", localUtil.format(A337EducacionProfesionalHasta, "99/99/99"));
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
            A59EducacionProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "EducacionProfesionalId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
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
            initAll1349( ) ;
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
      disableAttributes1349( ) ;
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

   public void resetCaption130( )
   {
   }

   public void zm1349( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z334EducacionProfesionalNombreInstitucion = T00133_A334EducacionProfesionalNombreInstitucion[0] ;
            Z335EducacionProfesionalPais = T00133_A335EducacionProfesionalPais[0] ;
            Z336EducacionProfesionalDesde = T00133_A336EducacionProfesionalDesde[0] ;
            Z337EducacionProfesionalHasta = T00133_A337EducacionProfesionalHasta[0] ;
            Z31ProfesionalId = T00133_A31ProfesionalId[0] ;
         }
         else
         {
            Z334EducacionProfesionalNombreInstitucion = A334EducacionProfesionalNombreInstitucion ;
            Z335EducacionProfesionalPais = A335EducacionProfesionalPais ;
            Z336EducacionProfesionalDesde = A336EducacionProfesionalDesde ;
            Z337EducacionProfesionalHasta = A337EducacionProfesionalHasta ;
            Z31ProfesionalId = A31ProfesionalId ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z59EducacionProfesionalId = A59EducacionProfesionalId ;
         Z334EducacionProfesionalNombreInstitucion = A334EducacionProfesionalNombreInstitucion ;
         Z335EducacionProfesionalPais = A335EducacionProfesionalPais ;
         Z336EducacionProfesionalDesde = A336EducacionProfesionalDesde ;
         Z337EducacionProfesionalHasta = A337EducacionProfesionalHasta ;
         Z31ProfesionalId = A31ProfesionalId ;
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

   public void load1349( )
   {
      /* Using cursor T00135 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A334EducacionProfesionalNombreInstitucion = T00135_A334EducacionProfesionalNombreInstitucion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A334EducacionProfesionalNombreInstitucion", A334EducacionProfesionalNombreInstitucion);
         A335EducacionProfesionalPais = T00135_A335EducacionProfesionalPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A335EducacionProfesionalPais", A335EducacionProfesionalPais);
         A336EducacionProfesionalDesde = T00135_A336EducacionProfesionalDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A336EducacionProfesionalDesde", localUtil.format(A336EducacionProfesionalDesde, "99/99/99"));
         A337EducacionProfesionalHasta = T00135_A337EducacionProfesionalHasta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A337EducacionProfesionalHasta", localUtil.format(A337EducacionProfesionalHasta, "99/99/99"));
         A31ProfesionalId = T00135_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         zm1349( -3) ;
      }
      pr_default.close(3);
      onLoadActions1349( ) ;
   }

   public void onLoadActions1349( )
   {
   }

   public void checkExtendedTable1349( )
   {
      nIsDirty_49 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      /* Using cursor T00134 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A336EducacionProfesionalDesde)) || (( GXutil.resetTime(A336EducacionProfesionalDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A336EducacionProfesionalDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Educacion Profesional Desde fuera de rango", "OutOfRange", 1, "EDUCACIONPROFESIONALDESDE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionProfesionalDesde_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A337EducacionProfesionalHasta)) || (( GXutil.resetTime(A337EducacionProfesionalHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A337EducacionProfesionalHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Educacion Profesional Hasta fuera de rango", "OutOfRange", 1, "EDUCACIONPROFESIONALHASTA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionProfesionalHasta_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1349( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_4( int A31ProfesionalId )
   {
      /* Using cursor T00136 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
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

   public void getKey1349( )
   {
      /* Using cursor T00137 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound49 = (short)(1) ;
      }
      else
      {
         RcdFound49 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00133 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1349( 3) ;
         RcdFound49 = (short)(1) ;
         A59EducacionProfesionalId = T00133_A59EducacionProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
         A334EducacionProfesionalNombreInstitucion = T00133_A334EducacionProfesionalNombreInstitucion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A334EducacionProfesionalNombreInstitucion", A334EducacionProfesionalNombreInstitucion);
         A335EducacionProfesionalPais = T00133_A335EducacionProfesionalPais[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A335EducacionProfesionalPais", A335EducacionProfesionalPais);
         A336EducacionProfesionalDesde = T00133_A336EducacionProfesionalDesde[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A336EducacionProfesionalDesde", localUtil.format(A336EducacionProfesionalDesde, "99/99/99"));
         A337EducacionProfesionalHasta = T00133_A337EducacionProfesionalHasta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A337EducacionProfesionalHasta", localUtil.format(A337EducacionProfesionalHasta, "99/99/99"));
         A31ProfesionalId = T00133_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         Z59EducacionProfesionalId = A59EducacionProfesionalId ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1349( ) ;
         if ( AnyError == 1 )
         {
            RcdFound49 = (short)(0) ;
            initializeNonKey1349( ) ;
         }
         Gx_mode = sMode49 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound49 = (short)(0) ;
         initializeNonKey1349( ) ;
         sMode49 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode49 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1349( ) ;
      if ( RcdFound49 == 0 )
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
      RcdFound49 = (short)(0) ;
      /* Using cursor T00138 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00138_A59EducacionProfesionalId[0] < A59EducacionProfesionalId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00138_A59EducacionProfesionalId[0] > A59EducacionProfesionalId ) ) )
         {
            A59EducacionProfesionalId = T00138_A59EducacionProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
            RcdFound49 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound49 = (short)(0) ;
      /* Using cursor T00139 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00139_A59EducacionProfesionalId[0] > A59EducacionProfesionalId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00139_A59EducacionProfesionalId[0] < A59EducacionProfesionalId ) ) )
         {
            A59EducacionProfesionalId = T00139_A59EducacionProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
            RcdFound49 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1349( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtEducacionProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1349( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound49 == 1 )
         {
            if ( A59EducacionProfesionalId != Z59EducacionProfesionalId )
            {
               A59EducacionProfesionalId = Z59EducacionProfesionalId ;
               httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "EDUCACIONPROFESIONALID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEducacionProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtEducacionProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update1349( ) ;
               GX_FocusControl = edtEducacionProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A59EducacionProfesionalId != Z59EducacionProfesionalId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtEducacionProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1349( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "EDUCACIONPROFESIONALID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEducacionProfesionalId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtEducacionProfesionalId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1349( ) ;
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
      if ( A59EducacionProfesionalId != Z59EducacionProfesionalId )
      {
         A59EducacionProfesionalId = Z59EducacionProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "EDUCACIONPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtEducacionProfesionalId_Internalname ;
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
      if ( RcdFound49 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "EDUCACIONPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionProfesionalId_Internalname ;
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
      scanStart1349( ) ;
      if ( RcdFound49 == 0 )
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
      scanEnd1349( ) ;
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
      if ( RcdFound49 == 0 )
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
      if ( RcdFound49 == 0 )
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
      scanStart1349( ) ;
      if ( RcdFound49 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound49 != 0 )
         {
            scanNext1349( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtProfesionalId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1349( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1349( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00132 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EducacionProfesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z334EducacionProfesionalNombreInstitucion, T00132_A334EducacionProfesionalNombreInstitucion[0]) != 0 ) || ( GXutil.strcmp(Z335EducacionProfesionalPais, T00132_A335EducacionProfesionalPais[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z336EducacionProfesionalDesde), GXutil.resetTime(T00132_A336EducacionProfesionalDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z337EducacionProfesionalHasta), GXutil.resetTime(T00132_A337EducacionProfesionalHasta[0])) ) || ( Z31ProfesionalId != T00132_A31ProfesionalId[0] ) )
         {
            if ( GXutil.strcmp(Z334EducacionProfesionalNombreInstitucion, T00132_A334EducacionProfesionalNombreInstitucion[0]) != 0 )
            {
               GXutil.writeLogln("educacionprofesional:[seudo value changed for attri]"+"EducacionProfesionalNombreInstitucion");
               GXutil.writeLogRaw("Old: ",Z334EducacionProfesionalNombreInstitucion);
               GXutil.writeLogRaw("Current: ",T00132_A334EducacionProfesionalNombreInstitucion[0]);
            }
            if ( GXutil.strcmp(Z335EducacionProfesionalPais, T00132_A335EducacionProfesionalPais[0]) != 0 )
            {
               GXutil.writeLogln("educacionprofesional:[seudo value changed for attri]"+"EducacionProfesionalPais");
               GXutil.writeLogRaw("Old: ",Z335EducacionProfesionalPais);
               GXutil.writeLogRaw("Current: ",T00132_A335EducacionProfesionalPais[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z336EducacionProfesionalDesde), GXutil.resetTime(T00132_A336EducacionProfesionalDesde[0])) ) )
            {
               GXutil.writeLogln("educacionprofesional:[seudo value changed for attri]"+"EducacionProfesionalDesde");
               GXutil.writeLogRaw("Old: ",Z336EducacionProfesionalDesde);
               GXutil.writeLogRaw("Current: ",T00132_A336EducacionProfesionalDesde[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z337EducacionProfesionalHasta), GXutil.resetTime(T00132_A337EducacionProfesionalHasta[0])) ) )
            {
               GXutil.writeLogln("educacionprofesional:[seudo value changed for attri]"+"EducacionProfesionalHasta");
               GXutil.writeLogRaw("Old: ",Z337EducacionProfesionalHasta);
               GXutil.writeLogRaw("Current: ",T00132_A337EducacionProfesionalHasta[0]);
            }
            if ( Z31ProfesionalId != T00132_A31ProfesionalId[0] )
            {
               GXutil.writeLogln("educacionprofesional:[seudo value changed for attri]"+"ProfesionalId");
               GXutil.writeLogRaw("Old: ",Z31ProfesionalId);
               GXutil.writeLogRaw("Current: ",T00132_A31ProfesionalId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"EducacionProfesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1349( )
   {
      beforeValidate1349( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1349( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1349( 0) ;
         checkOptimisticConcurrency1349( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1349( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1349( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001310 */
                  pr_default.execute(8, new Object[] {A334EducacionProfesionalNombreInstitucion, A335EducacionProfesionalPais, A336EducacionProfesionalDesde, A337EducacionProfesionalHasta, Integer.valueOf(A31ProfesionalId)});
                  A59EducacionProfesionalId = T001310_A59EducacionProfesionalId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EducacionProfesional");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption130( ) ;
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
            load1349( ) ;
         }
         endLevel1349( ) ;
      }
      closeExtendedTableCursors1349( ) ;
   }

   public void update1349( )
   {
      beforeValidate1349( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1349( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1349( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1349( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1349( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001311 */
                  pr_default.execute(9, new Object[] {A334EducacionProfesionalNombreInstitucion, A335EducacionProfesionalPais, A336EducacionProfesionalDesde, A337EducacionProfesionalHasta, Integer.valueOf(A31ProfesionalId), Integer.valueOf(A59EducacionProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("EducacionProfesional");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"EducacionProfesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1349( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption130( ) ;
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
         endLevel1349( ) ;
      }
      closeExtendedTableCursors1349( ) ;
   }

   public void deferredUpdate1349( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1349( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1349( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1349( ) ;
         afterConfirm1349( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1349( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001312 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A59EducacionProfesionalId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("EducacionProfesional");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound49 == 0 )
                     {
                        initAll1349( ) ;
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
                     resetCaption130( ) ;
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
      sMode49 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1349( ) ;
      Gx_mode = sMode49 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1349( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1349( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1349( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "educacionprofesional");
         if ( AnyError == 0 )
         {
            confirmValues130( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "educacionprofesional");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1349( )
   {
      /* Using cursor T001313 */
      pr_default.execute(11);
      RcdFound49 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A59EducacionProfesionalId = T001313_A59EducacionProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1349( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound49 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound49 = (short)(1) ;
         A59EducacionProfesionalId = T001313_A59EducacionProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
      }
   }

   public void scanEnd1349( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1349( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1349( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1349( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1349( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1349( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1349( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1349( )
   {
      edtEducacionProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionProfesionalId_Enabled), 5, 0), true);
      edtProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
      edtEducacionProfesionalNombreInstitucion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionProfesionalNombreInstitucion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionProfesionalNombreInstitucion_Enabled), 5, 0), true);
      edtEducacionProfesionalPais_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionProfesionalPais_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionProfesionalPais_Enabled), 5, 0), true);
      edtEducacionProfesionalDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionProfesionalDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionProfesionalDesde_Enabled), 5, 0), true);
      edtEducacionProfesionalHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionProfesionalHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionProfesionalHasta_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1349( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues130( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033565", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.educacionprofesional", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z59EducacionProfesionalId", GXutil.ltrim( localUtil.ntoc( Z59EducacionProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z334EducacionProfesionalNombreInstitucion", Z334EducacionProfesionalNombreInstitucion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z335EducacionProfesionalPais", Z335EducacionProfesionalPais);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z336EducacionProfesionalDesde", localUtil.dtoc( Z336EducacionProfesionalDesde, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z337EducacionProfesionalHasta", localUtil.dtoc( Z337EducacionProfesionalHasta, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z31ProfesionalId", GXutil.ltrim( localUtil.ntoc( Z31ProfesionalId, (byte)(8), (byte)(0), ",", "")));
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
      return formatLink("com.projectthani.educacionprofesional", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "EducacionProfesional" ;
   }

   public String getPgmdesc( )
   {
      return "Educacion Profesional" ;
   }

   public void initializeNonKey1349( )
   {
      A31ProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      A334EducacionProfesionalNombreInstitucion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A334EducacionProfesionalNombreInstitucion", A334EducacionProfesionalNombreInstitucion);
      A335EducacionProfesionalPais = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A335EducacionProfesionalPais", A335EducacionProfesionalPais);
      A336EducacionProfesionalDesde = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A336EducacionProfesionalDesde", localUtil.format(A336EducacionProfesionalDesde, "99/99/99"));
      A337EducacionProfesionalHasta = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A337EducacionProfesionalHasta", localUtil.format(A337EducacionProfesionalHasta, "99/99/99"));
      Z334EducacionProfesionalNombreInstitucion = "" ;
      Z335EducacionProfesionalPais = "" ;
      Z336EducacionProfesionalDesde = GXutil.nullDate() ;
      Z337EducacionProfesionalHasta = GXutil.nullDate() ;
      Z31ProfesionalId = 0 ;
   }

   public void initAll1349( )
   {
      A59EducacionProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A59EducacionProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A59EducacionProfesionalId), 8, 0));
      initializeNonKey1349( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033569", true, true);
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
      httpContext.AddJavascriptSource("educacionprofesional.js", "?2022511033569", false, true);
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
      edtEducacionProfesionalId_Internalname = "EDUCACIONPROFESIONALID" ;
      edtProfesionalId_Internalname = "PROFESIONALID" ;
      edtEducacionProfesionalNombreInstitucion_Internalname = "EDUCACIONPROFESIONALNOMBREINSTITUCION" ;
      edtEducacionProfesionalPais_Internalname = "EDUCACIONPROFESIONALPAIS" ;
      edtEducacionProfesionalDesde_Internalname = "EDUCACIONPROFESIONALDESDE" ;
      edtEducacionProfesionalHasta_Internalname = "EDUCACIONPROFESIONALHASTA" ;
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
      Form.setCaption( "Educacion Profesional" );
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtEducacionProfesionalHasta_Jsonclick = "" ;
      edtEducacionProfesionalHasta_Enabled = 1 ;
      edtEducacionProfesionalDesde_Jsonclick = "" ;
      edtEducacionProfesionalDesde_Enabled = 1 ;
      edtEducacionProfesionalPais_Jsonclick = "" ;
      edtEducacionProfesionalPais_Enabled = 1 ;
      edtEducacionProfesionalNombreInstitucion_Enabled = 1 ;
      edtProfesionalId_Jsonclick = "" ;
      edtProfesionalId_Enabled = 1 ;
      edtEducacionProfesionalId_Jsonclick = "" ;
      edtEducacionProfesionalId_Enabled = 1 ;
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

   public void valid_Educacionprofesionalid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A334EducacionProfesionalNombreInstitucion", A334EducacionProfesionalNombreInstitucion);
      httpContext.ajax_rsp_assign_attri("", false, "A335EducacionProfesionalPais", A335EducacionProfesionalPais);
      httpContext.ajax_rsp_assign_attri("", false, "A336EducacionProfesionalDesde", localUtil.format(A336EducacionProfesionalDesde, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A337EducacionProfesionalHasta", localUtil.format(A337EducacionProfesionalHasta, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z59EducacionProfesionalId", GXutil.ltrim( localUtil.ntoc( Z59EducacionProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z31ProfesionalId", GXutil.ltrim( localUtil.ntoc( Z31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z334EducacionProfesionalNombreInstitucion", Z334EducacionProfesionalNombreInstitucion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z335EducacionProfesionalPais", Z335EducacionProfesionalPais);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z336EducacionProfesionalDesde", localUtil.format(Z336EducacionProfesionalDesde, "99/99/99"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z337EducacionProfesionalHasta", localUtil.format(Z337EducacionProfesionalHasta, "99/99/99"));
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Profesionalid( )
   {
      /* Using cursor T001314 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Profesional'.", "ForeignKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
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
      setEventMetadata("VALID_EDUCACIONPROFESIONALID","{handler:'valid_Educacionprofesionalid',iparms:[{av:'A59EducacionProfesionalId',fld:'EDUCACIONPROFESIONALID',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_EDUCACIONPROFESIONALID",",oparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'A334EducacionProfesionalNombreInstitucion',fld:'EDUCACIONPROFESIONALNOMBREINSTITUCION',pic:''},{av:'A335EducacionProfesionalPais',fld:'EDUCACIONPROFESIONALPAIS',pic:''},{av:'A336EducacionProfesionalDesde',fld:'EDUCACIONPROFESIONALDESDE',pic:''},{av:'A337EducacionProfesionalHasta',fld:'EDUCACIONPROFESIONALHASTA',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z59EducacionProfesionalId'},{av:'Z31ProfesionalId'},{av:'Z334EducacionProfesionalNombreInstitucion'},{av:'Z335EducacionProfesionalPais'},{av:'Z336EducacionProfesionalDesde'},{av:'Z337EducacionProfesionalHasta'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_PROFESIONALID","{handler:'valid_Profesionalid',iparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALID_PROFESIONALID",",oparms:[]}");
      setEventMetadata("VALID_EDUCACIONPROFESIONALDESDE","{handler:'valid_Educacionprofesionaldesde',iparms:[]");
      setEventMetadata("VALID_EDUCACIONPROFESIONALDESDE",",oparms:[]}");
      setEventMetadata("VALID_EDUCACIONPROFESIONALHASTA","{handler:'valid_Educacionprofesionalhasta',iparms:[]");
      setEventMetadata("VALID_EDUCACIONPROFESIONALHASTA",",oparms:[]}");
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
      Z334EducacionProfesionalNombreInstitucion = "" ;
      Z335EducacionProfesionalPais = "" ;
      Z336EducacionProfesionalDesde = GXutil.nullDate() ;
      Z337EducacionProfesionalHasta = GXutil.nullDate() ;
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
      A334EducacionProfesionalNombreInstitucion = "" ;
      A335EducacionProfesionalPais = "" ;
      A336EducacionProfesionalDesde = GXutil.nullDate() ;
      A337EducacionProfesionalHasta = GXutil.nullDate() ;
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
      T00135_A59EducacionProfesionalId = new int[1] ;
      T00135_A334EducacionProfesionalNombreInstitucion = new String[] {""} ;
      T00135_A335EducacionProfesionalPais = new String[] {""} ;
      T00135_A336EducacionProfesionalDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T00135_A337EducacionProfesionalHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T00135_A31ProfesionalId = new int[1] ;
      T00134_A31ProfesionalId = new int[1] ;
      T00136_A31ProfesionalId = new int[1] ;
      T00137_A59EducacionProfesionalId = new int[1] ;
      T00133_A59EducacionProfesionalId = new int[1] ;
      T00133_A334EducacionProfesionalNombreInstitucion = new String[] {""} ;
      T00133_A335EducacionProfesionalPais = new String[] {""} ;
      T00133_A336EducacionProfesionalDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T00133_A337EducacionProfesionalHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T00133_A31ProfesionalId = new int[1] ;
      sMode49 = "" ;
      T00138_A59EducacionProfesionalId = new int[1] ;
      T00139_A59EducacionProfesionalId = new int[1] ;
      T00132_A59EducacionProfesionalId = new int[1] ;
      T00132_A334EducacionProfesionalNombreInstitucion = new String[] {""} ;
      T00132_A335EducacionProfesionalPais = new String[] {""} ;
      T00132_A336EducacionProfesionalDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T00132_A337EducacionProfesionalHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T00132_A31ProfesionalId = new int[1] ;
      T001310_A59EducacionProfesionalId = new int[1] ;
      T001313_A59EducacionProfesionalId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ334EducacionProfesionalNombreInstitucion = "" ;
      ZZ335EducacionProfesionalPais = "" ;
      ZZ336EducacionProfesionalDesde = GXutil.nullDate() ;
      ZZ337EducacionProfesionalHasta = GXutil.nullDate() ;
      T001314_A31ProfesionalId = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.educacionprofesional__default(),
         new Object[] {
             new Object[] {
            T00132_A59EducacionProfesionalId, T00132_A334EducacionProfesionalNombreInstitucion, T00132_A335EducacionProfesionalPais, T00132_A336EducacionProfesionalDesde, T00132_A337EducacionProfesionalHasta, T00132_A31ProfesionalId
            }
            , new Object[] {
            T00133_A59EducacionProfesionalId, T00133_A334EducacionProfesionalNombreInstitucion, T00133_A335EducacionProfesionalPais, T00133_A336EducacionProfesionalDesde, T00133_A337EducacionProfesionalHasta, T00133_A31ProfesionalId
            }
            , new Object[] {
            T00134_A31ProfesionalId
            }
            , new Object[] {
            T00135_A59EducacionProfesionalId, T00135_A334EducacionProfesionalNombreInstitucion, T00135_A335EducacionProfesionalPais, T00135_A336EducacionProfesionalDesde, T00135_A337EducacionProfesionalHasta, T00135_A31ProfesionalId
            }
            , new Object[] {
            T00136_A31ProfesionalId
            }
            , new Object[] {
            T00137_A59EducacionProfesionalId
            }
            , new Object[] {
            T00138_A59EducacionProfesionalId
            }
            , new Object[] {
            T00139_A59EducacionProfesionalId
            }
            , new Object[] {
            T001310_A59EducacionProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001313_A59EducacionProfesionalId
            }
            , new Object[] {
            T001314_A31ProfesionalId
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
   private short RcdFound49 ;
   private short nIsDirty_49 ;
   private int Z59EducacionProfesionalId ;
   private int Z31ProfesionalId ;
   private int A31ProfesionalId ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int A59EducacionProfesionalId ;
   private int edtEducacionProfesionalId_Enabled ;
   private int edtProfesionalId_Enabled ;
   private int edtEducacionProfesionalNombreInstitucion_Enabled ;
   private int edtEducacionProfesionalPais_Enabled ;
   private int edtEducacionProfesionalDesde_Enabled ;
   private int edtEducacionProfesionalHasta_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ59EducacionProfesionalId ;
   private int ZZ31ProfesionalId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtEducacionProfesionalId_Internalname ;
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
   private String edtEducacionProfesionalId_Jsonclick ;
   private String edtProfesionalId_Internalname ;
   private String edtProfesionalId_Jsonclick ;
   private String edtEducacionProfesionalNombreInstitucion_Internalname ;
   private String edtEducacionProfesionalPais_Internalname ;
   private String edtEducacionProfesionalPais_Jsonclick ;
   private String edtEducacionProfesionalDesde_Internalname ;
   private String edtEducacionProfesionalDesde_Jsonclick ;
   private String edtEducacionProfesionalHasta_Internalname ;
   private String edtEducacionProfesionalHasta_Jsonclick ;
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
   private String sMode49 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z336EducacionProfesionalDesde ;
   private java.util.Date Z337EducacionProfesionalHasta ;
   private java.util.Date A336EducacionProfesionalDesde ;
   private java.util.Date A337EducacionProfesionalHasta ;
   private java.util.Date ZZ336EducacionProfesionalDesde ;
   private java.util.Date ZZ337EducacionProfesionalHasta ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private String Z334EducacionProfesionalNombreInstitucion ;
   private String Z335EducacionProfesionalPais ;
   private String A334EducacionProfesionalNombreInstitucion ;
   private String A335EducacionProfesionalPais ;
   private String ZZ334EducacionProfesionalNombreInstitucion ;
   private String ZZ335EducacionProfesionalPais ;
   private IDataStoreProvider pr_default ;
   private int[] T00135_A59EducacionProfesionalId ;
   private String[] T00135_A334EducacionProfesionalNombreInstitucion ;
   private String[] T00135_A335EducacionProfesionalPais ;
   private java.util.Date[] T00135_A336EducacionProfesionalDesde ;
   private java.util.Date[] T00135_A337EducacionProfesionalHasta ;
   private int[] T00135_A31ProfesionalId ;
   private int[] T00134_A31ProfesionalId ;
   private int[] T00136_A31ProfesionalId ;
   private int[] T00137_A59EducacionProfesionalId ;
   private int[] T00133_A59EducacionProfesionalId ;
   private String[] T00133_A334EducacionProfesionalNombreInstitucion ;
   private String[] T00133_A335EducacionProfesionalPais ;
   private java.util.Date[] T00133_A336EducacionProfesionalDesde ;
   private java.util.Date[] T00133_A337EducacionProfesionalHasta ;
   private int[] T00133_A31ProfesionalId ;
   private int[] T00138_A59EducacionProfesionalId ;
   private int[] T00139_A59EducacionProfesionalId ;
   private int[] T00132_A59EducacionProfesionalId ;
   private String[] T00132_A334EducacionProfesionalNombreInstitucion ;
   private String[] T00132_A335EducacionProfesionalPais ;
   private java.util.Date[] T00132_A336EducacionProfesionalDesde ;
   private java.util.Date[] T00132_A337EducacionProfesionalHasta ;
   private int[] T00132_A31ProfesionalId ;
   private int[] T001310_A59EducacionProfesionalId ;
   private int[] T001313_A59EducacionProfesionalId ;
   private int[] T001314_A31ProfesionalId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class educacionprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00132", "SELECT [EducacionProfesionalId], [EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId] FROM [EducacionProfesional] WITH (UPDLOCK) WHERE [EducacionProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00133", "SELECT [EducacionProfesionalId], [EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId] FROM [EducacionProfesional] WHERE [EducacionProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00134", "SELECT [ProfesionalId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00135", "SELECT TM1.[EducacionProfesionalId], TM1.[EducacionProfesionalNombreInstitucion], TM1.[EducacionProfesionalPais], TM1.[EducacionProfesionalDesde], TM1.[EducacionProfesionalHasta], TM1.[ProfesionalId] FROM [EducacionProfesional] TM1 WHERE TM1.[EducacionProfesionalId] = ? ORDER BY TM1.[EducacionProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00136", "SELECT [ProfesionalId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00137", "SELECT [EducacionProfesionalId] FROM [EducacionProfesional] WHERE [EducacionProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00138", "SELECT TOP 1 [EducacionProfesionalId] FROM [EducacionProfesional] WHERE ( [EducacionProfesionalId] > ?) ORDER BY [EducacionProfesionalId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00139", "SELECT TOP 1 [EducacionProfesionalId] FROM [EducacionProfesional] WHERE ( [EducacionProfesionalId] < ?) ORDER BY [EducacionProfesionalId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001310", "INSERT INTO [EducacionProfesional]([EducacionProfesionalNombreInstitucion], [EducacionProfesionalPais], [EducacionProfesionalDesde], [EducacionProfesionalHasta], [ProfesionalId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T001311", "UPDATE [EducacionProfesional] SET [EducacionProfesionalNombreInstitucion]=?, [EducacionProfesionalPais]=?, [EducacionProfesionalDesde]=?, [EducacionProfesionalHasta]=?, [ProfesionalId]=?  WHERE [EducacionProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001312", "DELETE FROM [EducacionProfesional]  WHERE [EducacionProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001313", "SELECT [EducacionProfesionalId] FROM [EducacionProfesional] ORDER BY [EducacionProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001314", "SELECT [ProfesionalId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setVarchar(2, (String)parms[1], 150, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setVarchar(2, (String)parms[1], 150, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
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

