package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class ratingprofesional_impl extends GXDataArea
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
         Form.getMeta().addItem("description", "Rating Profesional", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtRatingProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public ratingprofesional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public ratingprofesional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ratingprofesional_impl.class ));
   }

   public ratingprofesional_impl( int remoteHandle ,
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRatingProfesionalId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRatingProfesionalId_Internalname, "Profesional Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRatingProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A60RatingProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtRatingProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A60RatingProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A60RatingProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRatingProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRatingProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_RatingProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRatingProfesionalCitaId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRatingProfesionalCitaId_Internalname, "Cita Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRatingProfesionalCitaId_Internalname, GXutil.ltrim( localUtil.ntoc( A366RatingProfesionalCitaId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtRatingProfesionalCitaId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A366RatingProfesionalCitaId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A366RatingProfesionalCitaId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRatingProfesionalCitaId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtRatingProfesionalCitaId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RatingProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", -1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+Ratingprofesionalrating_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, Ratingprofesionalrating_Internalname, "Profesional Rating", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* User Defined Control */
      ucRatingprofesionalrating.setProperty("Attribute", RatingProfesionalRating);
      ucRatingprofesionalrating.setProperty("CaptionClass", Ratingprofesionalrating_Captionclass);
      ucRatingprofesionalrating.setProperty("CaptionStyle", Ratingprofesionalrating_Captionstyle);
      ucRatingprofesionalrating.setProperty("CaptionPosition", Ratingprofesionalrating_Captionposition);
      ucRatingprofesionalrating.render(context, "rating", Ratingprofesionalrating_Internalname, "RATINGPROFESIONALRATINGContainer");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtRatingProfesionalFechaRegistro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtRatingProfesionalFechaRegistro_Internalname, "Fecha Registro", "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtRatingProfesionalFechaRegistro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtRatingProfesionalFechaRegistro_Internalname, localUtil.format(A353RatingProfesionalFechaRegistro, "99/99/99"), localUtil.format( A353RatingProfesionalFechaRegistro, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtRatingProfesionalFechaRegistro_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtRatingProfesionalFechaRegistro_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_RatingProfesional.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtRatingProfesionalFechaRegistro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtRatingProfesionalFechaRegistro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_RatingProfesional.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "ButtonMaterial" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", "Confirmar", bttBtntrn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 44,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", "Cancelar", bttBtntrn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'',0)\"" ;
      ClassString = "ButtonMaterialDefault" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", "Eliminar", bttBtntrn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_RatingProfesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      e11142 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z60RatingProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z60RatingProfesionalId"), ",", ".")) ;
            Z366RatingProfesionalCitaId = (short)(localUtil.ctol( httpContext.cgiGet( "Z366RatingProfesionalCitaId"), ",", ".")) ;
            Z352RatingProfesionalRating = (short)(localUtil.ctol( httpContext.cgiGet( "Z352RatingProfesionalRating"), ",", ".")) ;
            Z353RatingProfesionalFechaRegistro = localUtil.ctod( httpContext.cgiGet( "Z353RatingProfesionalFechaRegistro"), 0) ;
            Z62SGProfesionalProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z62SGProfesionalProfesionalId"), ",", ".")) ;
            Z61SGPacientePacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z61SGPacientePacienteId"), ",", ".")) ;
            A352RatingProfesionalRating = (short)(localUtil.ctol( httpContext.cgiGet( "Z352RatingProfesionalRating"), ",", ".")) ;
            A62SGProfesionalProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z62SGProfesionalProfesionalId"), ",", ".")) ;
            A61SGPacientePacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "Z61SGPacientePacienteId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A352RatingProfesionalRating = (short)(localUtil.ctol( httpContext.cgiGet( "RATINGPROFESIONALRATING"), ",", ".")) ;
            A62SGProfesionalProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "SGPROFESIONALPROFESIONALID"), ",", ".")) ;
            A61SGPacientePacienteId = (int)(localUtil.ctol( httpContext.cgiGet( "SGPACIENTEPACIENTEID"), ",", ".")) ;
            Ratingprofesionalrating_Objectcall = httpContext.cgiGet( "RATINGPROFESIONALRATING_Objectcall") ;
            Ratingprofesionalrating_Class = httpContext.cgiGet( "RATINGPROFESIONALRATING_Class") ;
            Ratingprofesionalrating_Enabled = GXutil.strtobool( httpContext.cgiGet( "RATINGPROFESIONALRATING_Enabled")) ;
            Ratingprofesionalrating_Maxvalue = (int)(localUtil.ctol( httpContext.cgiGet( "RATINGPROFESIONALRATING_Maxvalue"), ",", ".")) ;
            Ratingprofesionalrating_Step = (int)(localUtil.ctol( httpContext.cgiGet( "RATINGPROFESIONALRATING_Step"), ",", ".")) ;
            Ratingprofesionalrating_Ratingclass = httpContext.cgiGet( "RATINGPROFESIONALRATING_Ratingclass") ;
            Ratingprofesionalrating_Captionvalue = httpContext.cgiGet( "RATINGPROFESIONALRATING_Captionvalue") ;
            Ratingprofesionalrating_Captionclass = httpContext.cgiGet( "RATINGPROFESIONALRATING_Captionclass") ;
            Ratingprofesionalrating_Captionstyle = httpContext.cgiGet( "RATINGPROFESIONALRATING_Captionstyle") ;
            Ratingprofesionalrating_Captionposition = httpContext.cgiGet( "RATINGPROFESIONALRATING_Captionposition") ;
            Ratingprofesionalrating_Isabstractlayoutcontrol = GXutil.strtobool( httpContext.cgiGet( "RATINGPROFESIONALRATING_Isabstractlayoutcontrol")) ;
            Ratingprofesionalrating_Coltitle = httpContext.cgiGet( "RATINGPROFESIONALRATING_Coltitle") ;
            Ratingprofesionalrating_Coltitlefont = httpContext.cgiGet( "RATINGPROFESIONALRATING_Coltitlefont") ;
            Ratingprofesionalrating_Coltitlecolor = (int)(localUtil.ctol( httpContext.cgiGet( "RATINGPROFESIONALRATING_Coltitlecolor"), ",", ".")) ;
            Ratingprofesionalrating_Usercontroliscolumn = GXutil.strtobool( httpContext.cgiGet( "RATINGPROFESIONALRATING_Usercontroliscolumn")) ;
            Ratingprofesionalrating_Visible = GXutil.strtobool( httpContext.cgiGet( "RATINGPROFESIONALRATING_Visible")) ;
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRatingProfesionalId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRatingProfesionalId_Internalname), ",", ".") > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RATINGPROFESIONALID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRatingProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A60RatingProfesionalId = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
            }
            else
            {
               A60RatingProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtRatingProfesionalId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtRatingProfesionalCitaId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtRatingProfesionalCitaId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "RATINGPROFESIONALCITAID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRatingProfesionalCitaId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A366RatingProfesionalCitaId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A366RatingProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A366RatingProfesionalCitaId), 4, 0));
            }
            else
            {
               A366RatingProfesionalCitaId = (short)(localUtil.ctol( httpContext.cgiGet( edtRatingProfesionalCitaId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A366RatingProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A366RatingProfesionalCitaId), 4, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtRatingProfesionalFechaRegistro_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "RATINGPROFESIONALFECHAREGISTRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRatingProfesionalFechaRegistro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A353RatingProfesionalFechaRegistro", localUtil.format(A353RatingProfesionalFechaRegistro, "99/99/99"));
            }
            else
            {
               A353RatingProfesionalFechaRegistro = localUtil.ctod( httpContext.cgiGet( edtRatingProfesionalFechaRegistro_Internalname), 3) ;
               httpContext.ajax_rsp_assign_attri("", false, "A353RatingProfesionalFechaRegistro", localUtil.format(A353RatingProfesionalFechaRegistro, "99/99/99"));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"RatingProfesional");
            forbiddenHiddens.add("SGProfesionalProfesionalId", localUtil.format( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), "ZZZZZZZ9"));
            forbiddenHiddens.add("SGPacientePacienteId", localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A60RatingProfesionalId != Z60RatingProfesionalId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("ratingprofesional:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A60RatingProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "RatingProfesionalId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
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
                        e11142 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12142 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
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
         /* Execute user event: After Trn */
         e12142 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1450( ) ;
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
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtntrn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
      }
      disableAttributes1450( ) ;
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

   public void resetCaption140( )
   {
   }

   public void e11142( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e12142( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1450( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z366RatingProfesionalCitaId = T00143_A366RatingProfesionalCitaId[0] ;
            Z352RatingProfesionalRating = T00143_A352RatingProfesionalRating[0] ;
            Z353RatingProfesionalFechaRegistro = T00143_A353RatingProfesionalFechaRegistro[0] ;
            Z62SGProfesionalProfesionalId = T00143_A62SGProfesionalProfesionalId[0] ;
            Z61SGPacientePacienteId = T00143_A61SGPacientePacienteId[0] ;
         }
         else
         {
            Z366RatingProfesionalCitaId = A366RatingProfesionalCitaId ;
            Z352RatingProfesionalRating = A352RatingProfesionalRating ;
            Z353RatingProfesionalFechaRegistro = A353RatingProfesionalFechaRegistro ;
            Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
            Z61SGPacientePacienteId = A61SGPacientePacienteId ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z60RatingProfesionalId = A60RatingProfesionalId ;
         Z366RatingProfesionalCitaId = A366RatingProfesionalCitaId ;
         Z352RatingProfesionalRating = A352RatingProfesionalRating ;
         Z353RatingProfesionalFechaRegistro = A353RatingProfesionalFechaRegistro ;
         Z62SGProfesionalProfesionalId = A62SGProfesionalProfesionalId ;
         Z61SGPacientePacienteId = A61SGPacientePacienteId ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      /* Using cursor T00144 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A62SGProfesionalProfesionalId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGProfesional'.", "ForeignKeyNotFound", 1, "SGPROFESIONALPROFESIONALID");
         AnyError = (short)(1) ;
      }
      pr_default.close(2);
      /* Using cursor T00145 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A61SGPacientePacienteId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'SGPaciente'.", "ForeignKeyNotFound", 1, "SGPACIENTEPACIENTEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(3);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtntrn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
   }

   public void load1450( )
   {
      /* Using cursor T00146 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A366RatingProfesionalCitaId = T00146_A366RatingProfesionalCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A366RatingProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A366RatingProfesionalCitaId), 4, 0));
         A352RatingProfesionalRating = T00146_A352RatingProfesionalRating[0] ;
         A353RatingProfesionalFechaRegistro = T00146_A353RatingProfesionalFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A353RatingProfesionalFechaRegistro", localUtil.format(A353RatingProfesionalFechaRegistro, "99/99/99"));
         A62SGProfesionalProfesionalId = T00146_A62SGProfesionalProfesionalId[0] ;
         A61SGPacientePacienteId = T00146_A61SGPacientePacienteId[0] ;
         zm1450( -2) ;
      }
      pr_default.close(4);
      onLoadActions1450( ) ;
   }

   public void onLoadActions1450( )
   {
   }

   public void checkExtendedTable1450( )
   {
      nIsDirty_50 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A353RatingProfesionalFechaRegistro)) || (( GXutil.resetTime(A353RatingProfesionalFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A353RatingProfesionalFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Rating Profesional Fecha Registro fuera de rango", "OutOfRange", 1, "RATINGPROFESIONALFECHAREGISTRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRatingProfesionalFechaRegistro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1450( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey1450( )
   {
      /* Using cursor T00147 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound50 = (short)(1) ;
      }
      else
      {
         RcdFound50 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00143 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1450( 2) ;
         RcdFound50 = (short)(1) ;
         A60RatingProfesionalId = T00143_A60RatingProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
         A366RatingProfesionalCitaId = T00143_A366RatingProfesionalCitaId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A366RatingProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A366RatingProfesionalCitaId), 4, 0));
         A352RatingProfesionalRating = T00143_A352RatingProfesionalRating[0] ;
         A353RatingProfesionalFechaRegistro = T00143_A353RatingProfesionalFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A353RatingProfesionalFechaRegistro", localUtil.format(A353RatingProfesionalFechaRegistro, "99/99/99"));
         A62SGProfesionalProfesionalId = T00143_A62SGProfesionalProfesionalId[0] ;
         A61SGPacientePacienteId = T00143_A61SGPacientePacienteId[0] ;
         Z60RatingProfesionalId = A60RatingProfesionalId ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load1450( ) ;
         if ( AnyError == 1 )
         {
            RcdFound50 = (short)(0) ;
            initializeNonKey1450( ) ;
         }
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound50 = (short)(0) ;
         initializeNonKey1450( ) ;
         sMode50 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode50 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1450( ) ;
      if ( RcdFound50 == 0 )
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
      RcdFound50 = (short)(0) ;
      /* Using cursor T00148 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00148_A60RatingProfesionalId[0] < A60RatingProfesionalId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00148_A60RatingProfesionalId[0] > A60RatingProfesionalId ) ) )
         {
            A60RatingProfesionalId = T00148_A60RatingProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
            RcdFound50 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound50 = (short)(0) ;
      /* Using cursor T00149 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00149_A60RatingProfesionalId[0] > A60RatingProfesionalId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00149_A60RatingProfesionalId[0] < A60RatingProfesionalId ) ) )
         {
            A60RatingProfesionalId = T00149_A60RatingProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
            RcdFound50 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1450( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtRatingProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1450( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound50 == 1 )
         {
            if ( A60RatingProfesionalId != Z60RatingProfesionalId )
            {
               A60RatingProfesionalId = Z60RatingProfesionalId ;
               httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "RATINGPROFESIONALID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtRatingProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtRatingProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update1450( ) ;
               GX_FocusControl = edtRatingProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A60RatingProfesionalId != Z60RatingProfesionalId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtRatingProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1450( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "RATINGPROFESIONALID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtRatingProfesionalId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtRatingProfesionalId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1450( ) ;
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
      if ( A60RatingProfesionalId != Z60RatingProfesionalId )
      {
         A60RatingProfesionalId = Z60RatingProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "RATINGPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRatingProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtRatingProfesionalId_Internalname ;
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
      if ( RcdFound50 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "RATINGPROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtRatingProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = edtRatingProfesionalCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart1450( ) ;
      if ( RcdFound50 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtRatingProfesionalCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1450( ) ;
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
      if ( RcdFound50 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtRatingProfesionalCitaId_Internalname ;
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
      if ( RcdFound50 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtRatingProfesionalCitaId_Internalname ;
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
      scanStart1450( ) ;
      if ( RcdFound50 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound50 != 0 )
         {
            scanNext1450( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtRatingProfesionalCitaId_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd1450( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency1450( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00142 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingProfesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z366RatingProfesionalCitaId != T00142_A366RatingProfesionalCitaId[0] ) || ( Z352RatingProfesionalRating != T00142_A352RatingProfesionalRating[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z353RatingProfesionalFechaRegistro), GXutil.resetTime(T00142_A353RatingProfesionalFechaRegistro[0])) ) || ( Z62SGProfesionalProfesionalId != T00142_A62SGProfesionalProfesionalId[0] ) || ( Z61SGPacientePacienteId != T00142_A61SGPacientePacienteId[0] ) )
         {
            if ( Z366RatingProfesionalCitaId != T00142_A366RatingProfesionalCitaId[0] )
            {
               GXutil.writeLogln("ratingprofesional:[seudo value changed for attri]"+"RatingProfesionalCitaId");
               GXutil.writeLogRaw("Old: ",Z366RatingProfesionalCitaId);
               GXutil.writeLogRaw("Current: ",T00142_A366RatingProfesionalCitaId[0]);
            }
            if ( Z352RatingProfesionalRating != T00142_A352RatingProfesionalRating[0] )
            {
               GXutil.writeLogln("ratingprofesional:[seudo value changed for attri]"+"RatingProfesionalRating");
               GXutil.writeLogRaw("Old: ",Z352RatingProfesionalRating);
               GXutil.writeLogRaw("Current: ",T00142_A352RatingProfesionalRating[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z353RatingProfesionalFechaRegistro), GXutil.resetTime(T00142_A353RatingProfesionalFechaRegistro[0])) ) )
            {
               GXutil.writeLogln("ratingprofesional:[seudo value changed for attri]"+"RatingProfesionalFechaRegistro");
               GXutil.writeLogRaw("Old: ",Z353RatingProfesionalFechaRegistro);
               GXutil.writeLogRaw("Current: ",T00142_A353RatingProfesionalFechaRegistro[0]);
            }
            if ( Z62SGProfesionalProfesionalId != T00142_A62SGProfesionalProfesionalId[0] )
            {
               GXutil.writeLogln("ratingprofesional:[seudo value changed for attri]"+"SGProfesionalProfesionalId");
               GXutil.writeLogRaw("Old: ",Z62SGProfesionalProfesionalId);
               GXutil.writeLogRaw("Current: ",T00142_A62SGProfesionalProfesionalId[0]);
            }
            if ( Z61SGPacientePacienteId != T00142_A61SGPacientePacienteId[0] )
            {
               GXutil.writeLogln("ratingprofesional:[seudo value changed for attri]"+"SGPacientePacienteId");
               GXutil.writeLogRaw("Old: ",Z61SGPacientePacienteId);
               GXutil.writeLogRaw("Current: ",T00142_A61SGPacientePacienteId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"RatingProfesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1450( )
   {
      beforeValidate1450( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1450( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1450( 0) ;
         checkOptimisticConcurrency1450( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1450( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1450( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001410 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A366RatingProfesionalCitaId), Short.valueOf(A352RatingProfesionalRating), A353RatingProfesionalFechaRegistro, Integer.valueOf(A62SGProfesionalProfesionalId), Integer.valueOf(A61SGPacientePacienteId)});
                  A60RatingProfesionalId = T001410_A60RatingProfesionalId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingProfesional");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption140( ) ;
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
            load1450( ) ;
         }
         endLevel1450( ) ;
      }
      closeExtendedTableCursors1450( ) ;
   }

   public void update1450( )
   {
      beforeValidate1450( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1450( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1450( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1450( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1450( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001411 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A366RatingProfesionalCitaId), Short.valueOf(A352RatingProfesionalRating), A353RatingProfesionalFechaRegistro, Integer.valueOf(A62SGProfesionalProfesionalId), Integer.valueOf(A61SGPacientePacienteId), Integer.valueOf(A60RatingProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingProfesional");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"RatingProfesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1450( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                        resetCaption140( ) ;
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
         endLevel1450( ) ;
      }
      closeExtendedTableCursors1450( ) ;
   }

   public void deferredUpdate1450( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate1450( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1450( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1450( ) ;
         afterConfirm1450( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1450( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001412 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A60RatingProfesionalId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("RatingProfesional");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     move_next( ) ;
                     if ( RcdFound50 == 0 )
                     {
                        initAll1450( ) ;
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
                     resetCaption140( ) ;
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
      sMode50 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1450( ) ;
      Gx_mode = sMode50 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1450( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1450( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1450( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "ratingprofesional");
         if ( AnyError == 0 )
         {
            confirmValues140( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "ratingprofesional");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1450( )
   {
      /* Scan By routine */
      /* Using cursor T001413 */
      pr_default.execute(11);
      RcdFound50 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A60RatingProfesionalId = T001413_A60RatingProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1450( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound50 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound50 = (short)(1) ;
         A60RatingProfesionalId = T001413_A60RatingProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
      }
   }

   public void scanEnd1450( )
   {
      pr_default.close(11);
   }

   public void afterConfirm1450( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1450( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1450( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1450( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1450( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1450( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1450( )
   {
      edtRatingProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRatingProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRatingProfesionalId_Enabled), 5, 0), true);
      edtRatingProfesionalCitaId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRatingProfesionalCitaId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRatingProfesionalCitaId_Enabled), 5, 0), true);
      edtRatingProfesionalFechaRegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtRatingProfesionalFechaRegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtRatingProfesionalFechaRegistro_Enabled), 5, 0), true);
      Ratingprofesionalrating_Enabled = GXutil.toBoolean( 0) ;
      httpContext.ajax_rsp_assign_prop("", false, Ratingprofesionalrating_Internalname, "Enabled", GXutil.booltostr( Ratingprofesionalrating_Enabled), true);
   }

   public void send_integrity_lvl_hashes1450( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues140( )
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033728", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.ratingprofesional", new String[] {}, new String[] {}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"RatingProfesional");
      forbiddenHiddens.add("SGProfesionalProfesionalId", localUtil.format( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), "ZZZZZZZ9"));
      forbiddenHiddens.add("SGPacientePacienteId", localUtil.format( DecimalUtil.doubleToDec(A61SGPacientePacienteId), "ZZZZZZZ9"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("ratingprofesional:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z60RatingProfesionalId", GXutil.ltrim( localUtil.ntoc( Z60RatingProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z366RatingProfesionalCitaId", GXutil.ltrim( localUtil.ntoc( Z366RatingProfesionalCitaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z352RatingProfesionalRating", GXutil.ltrim( localUtil.ntoc( Z352RatingProfesionalRating, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z353RatingProfesionalFechaRegistro", localUtil.dtoc( Z353RatingProfesionalFechaRegistro, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z62SGProfesionalProfesionalId", GXutil.ltrim( localUtil.ntoc( Z62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPROFESIONALRATING", GXutil.ltrim( localUtil.ntoc( A352RatingProfesionalRating, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGPROFESIONALPROFESIONALID", GXutil.ltrim( localUtil.ntoc( A62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SGPACIENTEPACIENTEID", GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPROFESIONALRATING_Objectcall", GXutil.rtrim( Ratingprofesionalrating_Objectcall));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPROFESIONALRATING_Enabled", GXutil.booltostr( Ratingprofesionalrating_Enabled));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPROFESIONALRATING_Captionclass", GXutil.rtrim( Ratingprofesionalrating_Captionclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPROFESIONALRATING_Captionstyle", GXutil.rtrim( Ratingprofesionalrating_Captionstyle));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "RATINGPROFESIONALRATING_Captionposition", GXutil.rtrim( Ratingprofesionalrating_Captionposition));
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
      return formatLink("com.projectthani.ratingprofesional", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "RatingProfesional" ;
   }

   public String getPgmdesc( )
   {
      return "Rating Profesional" ;
   }

   public void initializeNonKey1450( )
   {
      A62SGProfesionalProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A62SGProfesionalProfesionalId), 8, 0));
      A61SGPacientePacienteId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A61SGPacientePacienteId), 8, 0));
      A366RatingProfesionalCitaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A366RatingProfesionalCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A366RatingProfesionalCitaId), 4, 0));
      A352RatingProfesionalRating = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A352RatingProfesionalRating", GXutil.ltrimstr( DecimalUtil.doubleToDec(A352RatingProfesionalRating), 4, 0));
      A353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A353RatingProfesionalFechaRegistro", localUtil.format(A353RatingProfesionalFechaRegistro, "99/99/99"));
      Z366RatingProfesionalCitaId = (short)(0) ;
      Z352RatingProfesionalRating = (short)(0) ;
      Z353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      Z62SGProfesionalProfesionalId = 0 ;
      Z61SGPacientePacienteId = 0 ;
   }

   public void initAll1450( )
   {
      A60RatingProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A60RatingProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A60RatingProfesionalId), 8, 0));
      initializeNonKey1450( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511033741", true, true);
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
      httpContext.AddJavascriptSource("ratingprofesional.js", "?2022511033741", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("Rating/rating.min.js", "", false, true);
      httpContext.AddJavascriptSource("Rating/RatingRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtRatingProfesionalId_Internalname = "RATINGPROFESIONALID" ;
      edtRatingProfesionalCitaId_Internalname = "RATINGPROFESIONALCITAID" ;
      Ratingprofesionalrating_Internalname = "RATINGPROFESIONALRATING" ;
      edtRatingProfesionalFechaRegistro_Internalname = "RATINGPROFESIONALFECHAREGISTRO" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
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
      Form.setCaption( "Rating Profesional" );
      bttBtntrn_delete_Enabled = 1 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtRatingProfesionalFechaRegistro_Jsonclick = "" ;
      edtRatingProfesionalFechaRegistro_Enabled = 1 ;
      Ratingprofesionalrating_Captionposition = "Left" ;
      Ratingprofesionalrating_Captionstyle = "" ;
      Ratingprofesionalrating_Captionclass = "col-sm-3 AttributeLabel" ;
      Ratingprofesionalrating_Enabled = GXutil.toBoolean( 1) ;
      edtRatingProfesionalCitaId_Jsonclick = "" ;
      edtRatingProfesionalCitaId_Enabled = 1 ;
      edtRatingProfesionalId_Jsonclick = "" ;
      edtRatingProfesionalId_Enabled = 1 ;
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
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtRatingProfesionalCitaId_Internalname ;
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

   public void valid_Ratingprofesionalid( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A62SGProfesionalProfesionalId", GXutil.ltrim( localUtil.ntoc( A62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( A61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A366RatingProfesionalCitaId", GXutil.ltrim( localUtil.ntoc( A366RatingProfesionalCitaId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A352RatingProfesionalRating", GXutil.ltrim( localUtil.ntoc( A352RatingProfesionalRating, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A353RatingProfesionalFechaRegistro", localUtil.format(A353RatingProfesionalFechaRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z60RatingProfesionalId", GXutil.ltrim( localUtil.ntoc( Z60RatingProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z62SGProfesionalProfesionalId", GXutil.ltrim( localUtil.ntoc( Z62SGProfesionalProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z61SGPacientePacienteId", GXutil.ltrim( localUtil.ntoc( Z61SGPacientePacienteId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z366RatingProfesionalCitaId", GXutil.ltrim( localUtil.ntoc( Z366RatingProfesionalCitaId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z352RatingProfesionalRating", GXutil.ltrim( localUtil.ntoc( Z352RatingProfesionalRating, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z353RatingProfesionalFechaRegistro", localUtil.format(Z353RatingProfesionalFechaRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A62SGProfesionalProfesionalId',fld:'SGPROFESIONALPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12142',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_RATINGPROFESIONALID","{handler:'valid_Ratingprofesionalid',iparms:[{av:'A60RatingProfesionalId',fld:'RATINGPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A62SGProfesionalProfesionalId',fld:'SGPROFESIONALPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_RATINGPROFESIONALID",",oparms:[{av:'A62SGProfesionalProfesionalId',fld:'SGPROFESIONALPROFESIONALID',pic:'ZZZZZZZ9'},{av:'A61SGPacientePacienteId',fld:'SGPACIENTEPACIENTEID',pic:'ZZZZZZZ9'},{av:'A366RatingProfesionalCitaId',fld:'RATINGPROFESIONALCITAID',pic:'ZZZ9'},{av:'A352RatingProfesionalRating',fld:'RATINGPROFESIONALRATING',pic:'ZZZ9'},{av:'A353RatingProfesionalFechaRegistro',fld:'RATINGPROFESIONALFECHAREGISTRO',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z60RatingProfesionalId'},{av:'Z62SGProfesionalProfesionalId'},{av:'Z61SGPacientePacienteId'},{av:'Z366RatingProfesionalCitaId'},{av:'Z352RatingProfesionalRating'},{av:'Z353RatingProfesionalFechaRegistro'},{ctrl:'BTNTRN_DELETE',prop:'Enabled'},{ctrl:'BTNTRN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_RATINGPROFESIONALFECHAREGISTRO","{handler:'valid_Ratingprofesionalfecharegistro',iparms:[]");
      setEventMetadata("VALID_RATINGPROFESIONALFECHAREGISTRO",",oparms:[]}");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ucRatingprofesionalrating = new com.genexus.webpanels.GXUserControl();
      A353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      Gx_mode = "" ;
      Ratingprofesionalrating_Objectcall = "" ;
      Ratingprofesionalrating_Class = "" ;
      Ratingprofesionalrating_Ratingclass = "" ;
      Ratingprofesionalrating_Captionvalue = "" ;
      Ratingprofesionalrating_Coltitle = "" ;
      Ratingprofesionalrating_Coltitlefont = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      T00144_A62SGProfesionalProfesionalId = new int[1] ;
      T00145_A61SGPacientePacienteId = new int[1] ;
      T00146_A60RatingProfesionalId = new int[1] ;
      T00146_A366RatingProfesionalCitaId = new short[1] ;
      T00146_A352RatingProfesionalRating = new short[1] ;
      T00146_A353RatingProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00146_A62SGProfesionalProfesionalId = new int[1] ;
      T00146_A61SGPacientePacienteId = new int[1] ;
      T00147_A60RatingProfesionalId = new int[1] ;
      T00143_A60RatingProfesionalId = new int[1] ;
      T00143_A366RatingProfesionalCitaId = new short[1] ;
      T00143_A352RatingProfesionalRating = new short[1] ;
      T00143_A353RatingProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00143_A62SGProfesionalProfesionalId = new int[1] ;
      T00143_A61SGPacientePacienteId = new int[1] ;
      sMode50 = "" ;
      T00148_A60RatingProfesionalId = new int[1] ;
      T00149_A60RatingProfesionalId = new int[1] ;
      T00142_A60RatingProfesionalId = new int[1] ;
      T00142_A366RatingProfesionalCitaId = new short[1] ;
      T00142_A352RatingProfesionalRating = new short[1] ;
      T00142_A353RatingProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T00142_A62SGProfesionalProfesionalId = new int[1] ;
      T00142_A61SGPacientePacienteId = new int[1] ;
      T001410_A60RatingProfesionalId = new int[1] ;
      T001413_A60RatingProfesionalId = new int[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ353RatingProfesionalFechaRegistro = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.ratingprofesional__default(),
         new Object[] {
             new Object[] {
            T00142_A60RatingProfesionalId, T00142_A366RatingProfesionalCitaId, T00142_A352RatingProfesionalRating, T00142_A353RatingProfesionalFechaRegistro, T00142_A62SGProfesionalProfesionalId, T00142_A61SGPacientePacienteId
            }
            , new Object[] {
            T00143_A60RatingProfesionalId, T00143_A366RatingProfesionalCitaId, T00143_A352RatingProfesionalRating, T00143_A353RatingProfesionalFechaRegistro, T00143_A62SGProfesionalProfesionalId, T00143_A61SGPacientePacienteId
            }
            , new Object[] {
            T00144_A62SGProfesionalProfesionalId
            }
            , new Object[] {
            T00145_A61SGPacientePacienteId
            }
            , new Object[] {
            T00146_A60RatingProfesionalId, T00146_A366RatingProfesionalCitaId, T00146_A352RatingProfesionalRating, T00146_A353RatingProfesionalFechaRegistro, T00146_A62SGProfesionalProfesionalId, T00146_A61SGPacientePacienteId
            }
            , new Object[] {
            T00147_A60RatingProfesionalId
            }
            , new Object[] {
            T00148_A60RatingProfesionalId
            }
            , new Object[] {
            T00149_A60RatingProfesionalId
            }
            , new Object[] {
            T001410_A60RatingProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001413_A60RatingProfesionalId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short Z366RatingProfesionalCitaId ;
   private short Z352RatingProfesionalRating ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A366RatingProfesionalCitaId ;
   private short RatingProfesionalRating ;
   private short A352RatingProfesionalRating ;
   private short RcdFound50 ;
   private short nIsDirty_50 ;
   private short ZZ366RatingProfesionalCitaId ;
   private short ZZ352RatingProfesionalRating ;
   private int Z60RatingProfesionalId ;
   private int Z62SGProfesionalProfesionalId ;
   private int Z61SGPacientePacienteId ;
   private int trnEnded ;
   private int A60RatingProfesionalId ;
   private int edtRatingProfesionalId_Enabled ;
   private int edtRatingProfesionalCitaId_Enabled ;
   private int edtRatingProfesionalFechaRegistro_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int A62SGProfesionalProfesionalId ;
   private int A61SGPacientePacienteId ;
   private int Ratingprofesionalrating_Maxvalue ;
   private int Ratingprofesionalrating_Step ;
   private int Ratingprofesionalrating_Coltitlecolor ;
   private int GX_JID ;
   private int idxLst ;
   private int ZZ60RatingProfesionalId ;
   private int ZZ62SGProfesionalProfesionalId ;
   private int ZZ61SGPacientePacienteId ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtRatingProfesionalId_Internalname ;
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
   private String TempTags ;
   private String edtRatingProfesionalId_Jsonclick ;
   private String edtRatingProfesionalCitaId_Internalname ;
   private String edtRatingProfesionalCitaId_Jsonclick ;
   private String Ratingprofesionalrating_Internalname ;
   private String Ratingprofesionalrating_Captionclass ;
   private String Ratingprofesionalrating_Captionstyle ;
   private String Ratingprofesionalrating_Captionposition ;
   private String edtRatingProfesionalFechaRegistro_Internalname ;
   private String edtRatingProfesionalFechaRegistro_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String Gx_mode ;
   private String Ratingprofesionalrating_Objectcall ;
   private String Ratingprofesionalrating_Class ;
   private String Ratingprofesionalrating_Ratingclass ;
   private String Ratingprofesionalrating_Captionvalue ;
   private String Ratingprofesionalrating_Coltitle ;
   private String Ratingprofesionalrating_Coltitlefont ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode50 ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private java.util.Date Z353RatingProfesionalFechaRegistro ;
   private java.util.Date A353RatingProfesionalFechaRegistro ;
   private java.util.Date ZZ353RatingProfesionalFechaRegistro ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Ratingprofesionalrating_Enabled ;
   private boolean Ratingprofesionalrating_Isabstractlayoutcontrol ;
   private boolean Ratingprofesionalrating_Usercontroliscolumn ;
   private boolean Ratingprofesionalrating_Visible ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucRatingprofesionalrating ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private int[] T00144_A62SGProfesionalProfesionalId ;
   private int[] T00145_A61SGPacientePacienteId ;
   private int[] T00146_A60RatingProfesionalId ;
   private short[] T00146_A366RatingProfesionalCitaId ;
   private short[] T00146_A352RatingProfesionalRating ;
   private java.util.Date[] T00146_A353RatingProfesionalFechaRegistro ;
   private int[] T00146_A62SGProfesionalProfesionalId ;
   private int[] T00146_A61SGPacientePacienteId ;
   private int[] T00147_A60RatingProfesionalId ;
   private int[] T00143_A60RatingProfesionalId ;
   private short[] T00143_A366RatingProfesionalCitaId ;
   private short[] T00143_A352RatingProfesionalRating ;
   private java.util.Date[] T00143_A353RatingProfesionalFechaRegistro ;
   private int[] T00143_A62SGProfesionalProfesionalId ;
   private int[] T00143_A61SGPacientePacienteId ;
   private int[] T00148_A60RatingProfesionalId ;
   private int[] T00149_A60RatingProfesionalId ;
   private int[] T00142_A60RatingProfesionalId ;
   private short[] T00142_A366RatingProfesionalCitaId ;
   private short[] T00142_A352RatingProfesionalRating ;
   private java.util.Date[] T00142_A353RatingProfesionalFechaRegistro ;
   private int[] T00142_A62SGProfesionalProfesionalId ;
   private int[] T00142_A61SGPacientePacienteId ;
   private int[] T001410_A60RatingProfesionalId ;
   private int[] T001413_A60RatingProfesionalId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class ratingprofesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00142", "SELECT [RatingProfesionalId], [RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] WITH (UPDLOCK) WHERE [RatingProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00143", "SELECT [RatingProfesionalId], [RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, [SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] WHERE [RatingProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00144", "SELECT [ProfesionalId] AS SGProfesionalProfesionalId FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00145", "SELECT [PacienteId] AS SGPacientePacienteId FROM [Paciente] WHERE [PacienteId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00146", "SELECT TM1.[RatingProfesionalId], TM1.[RatingProfesionalCitaId], TM1.[RatingProfesionalRating], TM1.[RatingProfesionalFechaRegistro], TM1.[SGProfesionalProfesionalId] AS SGProfesionalProfesionalId, TM1.[SGPacientePacienteId] AS SGPacientePacienteId FROM [RatingProfesional] TM1 WHERE TM1.[RatingProfesionalId] = ? ORDER BY TM1.[RatingProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00147", "SELECT [RatingProfesionalId] FROM [RatingProfesional] WHERE [RatingProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00148", "SELECT TOP 1 [RatingProfesionalId] FROM [RatingProfesional] WHERE ( [RatingProfesionalId] > ?) ORDER BY [RatingProfesionalId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00149", "SELECT TOP 1 [RatingProfesionalId] FROM [RatingProfesional] WHERE ( [RatingProfesionalId] < ?) ORDER BY [RatingProfesionalId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001410", "INSERT INTO [RatingProfesional]([RatingProfesionalCitaId], [RatingProfesionalRating], [RatingProfesionalFechaRegistro], [SGProfesionalProfesionalId], [SGPacientePacienteId]) VALUES(?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T001411", "UPDATE [RatingProfesional] SET [RatingProfesionalCitaId]=?, [RatingProfesionalRating]=?, [RatingProfesionalFechaRegistro]=?, [SGProfesionalProfesionalId]=?, [SGPacientePacienteId]=?  WHERE [RatingProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("T001412", "DELETE FROM [RatingProfesional]  WHERE [RatingProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("T001413", "SELECT [RatingProfesionalId] FROM [RatingProfesional] ORDER BY [RatingProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
            case 11 :
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

