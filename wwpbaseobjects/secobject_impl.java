package com.projectthani.wwpbaseobjects ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secobject_impl extends GXDataArea
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
         A1SecFunctionalityId = GXutil.lval( httpContext.GetPar( "SecFunctionalityId")) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_3( A1SecFunctionalityId) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsecobject_functionalities") == 0 )
      {
         nRC_GXsfl_34 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_34"))) ;
         nGXsfl_34_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_34_idx"))) ;
         sGXsfl_34_idx = httpContext.GetPar( "sGXsfl_34_idx") ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridsecobject_functionalities_newrow( ) ;
         return  ;
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
         Form.getMeta().addItem("description", "Sec Object", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtSecObjectName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public secobject_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secobject_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secobject_impl.class ));
   }

   public secobject_impl( int remoteHandle ,
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Sec Object", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecObject.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_WWPBaseObjects\\SecObject.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecObjectName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecObjectName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecObjectName_Internalname, A5SecObjectName, GXutil.rtrim( localUtil.format( A5SecObjectName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecObjectName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecObjectName_Enabled, 0, "text", "", 80, "chr", 1, "row", 120, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitlefunctionalities_Internalname, "Functionalities", "", "", lblTitlefunctionalities_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      gxdraw_gridsecobject_functionalities( ) ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 41,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WWPBaseObjects\\SecObject.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridsecobject_functionalities( )
   {
      /*  Grid Control  */
      Gridsecobject_functionalitiesContainer.AddObjectProperty("GridName", "Gridsecobject_functionalities");
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Header", subGridsecobject_functionalities_Header);
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Class", "Grid");
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("CmpContext", "");
      Gridsecobject_functionalitiesContainer.AddObjectProperty("InMasterPage", "false");
      Gridsecobject_functionalitiesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridsecobject_functionalitiesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddColumnProperties(Gridsecobject_functionalitiesColumn);
      Gridsecobject_functionalitiesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridsecobject_functionalitiesColumn.AddObjectProperty("Value", A8SecFunctionalityDescription);
      Gridsecobject_functionalitiesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityDescription_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddColumnProperties(Gridsecobject_functionalitiesColumn);
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridsecobject_functionalitiesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsecobject_functionalities_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_34_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount4 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_4 = (short)(1) ;
            scanStart034( ) ;
            while ( RcdFound4 != 0 )
            {
               init_level_properties4( ) ;
               getByPrimaryKey034( ) ;
               addRow034( ) ;
               scanNext034( ) ;
            }
            scanEnd034( ) ;
            nBlankRcdCount4 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal034( ) ;
         standaloneModal034( ) ;
         sMode4 = Gx_mode ;
         while ( nGXsfl_34_idx < nRC_GXsfl_34 )
         {
            bGXsfl_34_Refreshing = true ;
            readRow034( ) ;
            edtSecFunctionalityId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECFUNCTIONALITYID_"+sGXsfl_34_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), !bGXsfl_34_Refreshing);
            edtSecFunctionalityDescription_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_34_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityDescription_Enabled), 5, 0), !bGXsfl_34_Refreshing);
            if ( ( nRcdExists_4 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal034( ) ;
            }
            sendRow034( ) ;
            bGXsfl_34_Refreshing = false ;
         }
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount4 = (short)(5) ;
         nRcdExists_4 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart034( ) ;
            while ( RcdFound4 != 0 )
            {
               sGXsfl_34_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_34_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_344( ) ;
               init_level_properties4( ) ;
               standaloneNotModal034( ) ;
               getByPrimaryKey034( ) ;
               standaloneModal034( ) ;
               addRow034( ) ;
               scanNext034( ) ;
            }
            scanEnd034( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode4 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_34_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_34_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_344( ) ;
      initAll034( ) ;
      init_level_properties4( ) ;
      nRcdExists_4 = (short)(0) ;
      nIsMod_4 = (short)(0) ;
      nRcdDeleted_4 = (short)(0) ;
      nBlankRcdCount4 = (short)(nBlankRcdUsr4+nBlankRcdCount4) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount4 > 0 )
      {
         standaloneNotModal034( ) ;
         standaloneModal034( ) ;
         addRow034( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtSecFunctionalityId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount4 = (short)(nBlankRcdCount4-1) ;
      }
      Gx_mode = sMode4 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridsecobject_functionalitiesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridsecobject_functionalities", Gridsecobject_functionalitiesContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridsecobject_functionalitiesContainerData", Gridsecobject_functionalitiesContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridsecobject_functionalitiesContainerData"+"V", Gridsecobject_functionalitiesContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridsecobject_functionalitiesContainerData"+"V"+"\" value='"+Gridsecobject_functionalitiesContainer.GridValuesHidden()+"'/>") ;
      }
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
         Z5SecObjectName = httpContext.cgiGet( "Z5SecObjectName") ;
         IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
         IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
         Gx_mode = httpContext.cgiGet( "Mode") ;
         nRC_GXsfl_34 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_34"), ",", ".")) ;
         /* Read variables values. */
         A5SecObjectName = httpContext.cgiGet( edtSecObjectName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         standaloneNotModal( ) ;
      }
      else
      {
         standaloneNotModal( ) ;
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
         {
            Gx_mode = "DSP" ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            A5SecObjectName = httpContext.GetPar( "SecObjectName") ;
            httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
            initAll033( ) ;
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
      disableAttributes033( ) ;
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

   public void confirm_034( )
   {
      nGXsfl_34_idx = 0 ;
      while ( nGXsfl_34_idx < nRC_GXsfl_34 )
      {
         readRow034( ) ;
         if ( ( nRcdExists_4 != 0 ) || ( nIsMod_4 != 0 ) )
         {
            getKey034( ) ;
            if ( ( nRcdExists_4 == 0 ) && ( nRcdDeleted_4 == 0 ) )
            {
               if ( RcdFound4 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate034( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable034( ) ;
                     closeExtendedTableCursors034( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "SECFUNCTIONALITYID_" + sGXsfl_34_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecFunctionalityId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound4 != 0 )
               {
                  if ( nRcdDeleted_4 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey034( ) ;
                     load034( ) ;
                     beforeValidate034( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls034( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_4 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate034( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable034( ) ;
                           closeExtendedTableCursors034( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_4 == 0 )
                  {
                     GXCCtl = "SECFUNCTIONALITYID_" + sGXsfl_34_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecFunctionalityId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSecFunctionalityId_Internalname, GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSecFunctionalityDescription_Internalname, A8SecFunctionalityDescription) ;
         httpContext.changePostValue( "ZT_"+"Z1SecFunctionalityId_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( Z1SecFunctionalityId, (byte)(10), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_4_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_4, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_4_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_4, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_4_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_4, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_4 != 0 )
         {
            httpContext.changePostValue( "SECFUNCTIONALITYID_"+sGXsfl_34_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_34_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityDescription_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption030( )
   {
   }

   public void zm033( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -1 )
      {
         Z5SecObjectName = A5SecObjectName ;
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

   public void load033( )
   {
      /* Using cursor T00037 */
      pr_default.execute(5, new Object[] {A5SecObjectName});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound3 = (short)(1) ;
         zm033( -1) ;
      }
      pr_default.close(5);
      onLoadActions033( ) ;
   }

   public void onLoadActions033( )
   {
   }

   public void checkExtendedTable033( )
   {
      nIsDirty_3 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors033( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey033( )
   {
      /* Using cursor T00038 */
      pr_default.execute(6, new Object[] {A5SecObjectName});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00036 */
      pr_default.execute(4, new Object[] {A5SecObjectName});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm033( 1) ;
         RcdFound3 = (short)(1) ;
         A5SecObjectName = T00036_A5SecObjectName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
         Z5SecObjectName = A5SecObjectName ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load033( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey033( ) ;
         }
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey033( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey033( ) ;
      if ( RcdFound3 == 0 )
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
      RcdFound3 = (short)(0) ;
      /* Using cursor T00039 */
      pr_default.execute(7, new Object[] {A5SecObjectName});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( GXutil.strcmp(T00039_A5SecObjectName[0], A5SecObjectName) < 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( GXutil.strcmp(T00039_A5SecObjectName[0], A5SecObjectName) > 0 ) ) )
         {
            A5SecObjectName = T00039_A5SecObjectName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void move_previous( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T000310 */
      pr_default.execute(8, new Object[] {A5SecObjectName});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( GXutil.strcmp(T000310_A5SecObjectName[0], A5SecObjectName) > 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( GXutil.strcmp(T000310_A5SecObjectName[0], A5SecObjectName) < 0 ) ) )
         {
            A5SecObjectName = T000310_A5SecObjectName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey033( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtSecObjectName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert033( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( GXutil.strcmp(A5SecObjectName, Z5SecObjectName) != 0 )
            {
               A5SecObjectName = Z5SecObjectName ;
               httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "SECOBJECTNAME");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecObjectName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtSecObjectName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update033( ) ;
               GX_FocusControl = edtSecObjectName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( GXutil.strcmp(A5SecObjectName, Z5SecObjectName) != 0 )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtSecObjectName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert033( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "SECOBJECTNAME");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtSecObjectName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtSecObjectName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert033( ) ;
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
      if ( GXutil.strcmp(A5SecObjectName, Z5SecObjectName) != 0 )
      {
         A5SecObjectName = Z5SecObjectName ;
         httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "SECOBJECTNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecObjectName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtSecObjectName_Internalname ;
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
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "SECOBJECTNAME");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecObjectName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart033( ) ;
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      scanEnd033( ) ;
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
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
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
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart033( ) ;
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound3 != 0 )
         {
            scanNext033( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      scanEnd033( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency033( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00035 */
         pr_default.execute(3, new Object[] {A5SecObjectName});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecObject"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(3) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecObject"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         zm033( 0) ;
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000311 */
                  pr_default.execute(9, new Object[] {A5SecObjectName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObject");
                  if ( (pr_default.getStatus(9) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel033( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption030( ) ;
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
         else
         {
            load033( ) ;
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void update033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate033( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table [SecObject] */
                  deferredUpdate033( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel033( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                           resetCaption030( ) ;
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
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void deferredUpdate033( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls033( ) ;
         afterConfirm033( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete033( ) ;
            if ( AnyError == 0 )
            {
               scanStart034( ) ;
               while ( RcdFound4 != 0 )
               {
                  getByPrimaryKey034( ) ;
                  delete034( ) ;
                  scanNext034( ) ;
               }
               scanEnd034( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000312 */
                  pr_default.execute(10, new Object[] {A5SecObjectName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObject");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        move_next( ) ;
                        if ( RcdFound3 == 0 )
                        {
                           initAll033( ) ;
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
                        resetCaption030( ) ;
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
      }
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel033( ) ;
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls033( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void processNestedLevel034( )
   {
      nGXsfl_34_idx = 0 ;
      while ( nGXsfl_34_idx < nRC_GXsfl_34 )
      {
         readRow034( ) ;
         if ( ( nRcdExists_4 != 0 ) || ( nIsMod_4 != 0 ) )
         {
            standaloneNotModal034( ) ;
            getKey034( ) ;
            if ( ( nRcdExists_4 == 0 ) && ( nRcdDeleted_4 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert034( ) ;
            }
            else
            {
               if ( RcdFound4 != 0 )
               {
                  if ( ( nRcdDeleted_4 != 0 ) && ( nRcdExists_4 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete034( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_4 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update034( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_4 == 0 )
                  {
                     GXCCtl = "SECFUNCTIONALITYID_" + sGXsfl_34_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtSecFunctionalityId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSecFunctionalityId_Internalname, GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtSecFunctionalityDescription_Internalname, A8SecFunctionalityDescription) ;
         httpContext.changePostValue( "ZT_"+"Z1SecFunctionalityId_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( Z1SecFunctionalityId, (byte)(10), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_4_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_4, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_4_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_4, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_4_"+sGXsfl_34_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_4, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_4 != 0 )
         {
            httpContext.changePostValue( "SECFUNCTIONALITYID_"+sGXsfl_34_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_34_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityDescription_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll034( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_4 = (short)(0) ;
      nIsMod_4 = (short)(0) ;
      nRcdDeleted_4 = (short)(0) ;
   }

   public void processLevel033( )
   {
      /* Save parent mode. */
      sMode3 = Gx_mode ;
      processNestedLevel034( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel033( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete033( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secobject");
         if ( AnyError == 0 )
         {
            confirmValues030( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(2);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secobject");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart033( )
   {
      /* Using cursor T000313 */
      pr_default.execute(11);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A5SecObjectName = T000313_A5SecObjectName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext033( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A5SecObjectName = T000313_A5SecObjectName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
      }
   }

   public void scanEnd033( )
   {
      pr_default.close(11);
   }

   public void afterConfirm033( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert033( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate033( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete033( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete033( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate033( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes033( )
   {
      edtSecObjectName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecObjectName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecObjectName_Enabled), 5, 0), true);
   }

   public void zm034( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -2 )
      {
         Z5SecObjectName = A5SecObjectName ;
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         Z8SecFunctionalityDescription = A8SecFunctionalityDescription ;
      }
   }

   public void standaloneNotModal034( )
   {
   }

   public void standaloneModal034( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtSecFunctionalityId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), !bGXsfl_34_Refreshing);
      }
      else
      {
         edtSecFunctionalityId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), !bGXsfl_34_Refreshing);
      }
   }

   public void load034( )
   {
      /* Using cursor T000314 */
      pr_default.execute(12, new Object[] {A5SecObjectName, Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A8SecFunctionalityDescription = T000314_A8SecFunctionalityDescription[0] ;
         zm034( -2) ;
      }
      pr_default.close(12);
      onLoadActions034( ) ;
   }

   public void onLoadActions034( )
   {
   }

   public void checkExtendedTable034( )
   {
      nIsDirty_4 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal034( ) ;
      /* Using cursor T00034 */
      pr_default.execute(2, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "SECFUNCTIONALITYID_" + sGXsfl_34_idx ;
         httpContext.GX_msglist.addItem("No existe 'Functionality'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A8SecFunctionalityDescription = T00034_A8SecFunctionalityDescription[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors034( )
   {
      pr_default.close(2);
   }

   public void enableDisable034( )
   {
   }

   public void gxload_3( long A1SecFunctionalityId )
   {
      /* Using cursor T000315 */
      pr_default.execute(13, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         GXCCtl = "SECFUNCTIONALITYID_" + sGXsfl_34_idx ;
         httpContext.GX_msglist.addItem("No existe 'Functionality'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A8SecFunctionalityDescription = T000315_A8SecFunctionalityDescription[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A8SecFunctionalityDescription)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(13) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(13);
   }

   public void getKey034( )
   {
      /* Using cursor T000316 */
      pr_default.execute(14, new Object[] {A5SecObjectName, Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound4 = (short)(1) ;
      }
      else
      {
         RcdFound4 = (short)(0) ;
      }
      pr_default.close(14);
   }

   public void getByPrimaryKey034( )
   {
      /* Using cursor T00033 */
      pr_default.execute(1, new Object[] {A5SecObjectName, Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm034( 2) ;
         RcdFound4 = (short)(1) ;
         initializeNonKey034( ) ;
         A1SecFunctionalityId = T00033_A1SecFunctionalityId[0] ;
         Z5SecObjectName = A5SecObjectName ;
         Z1SecFunctionalityId = A1SecFunctionalityId ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal034( ) ;
         load034( ) ;
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound4 = (short)(0) ;
         initializeNonKey034( ) ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal034( ) ;
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes034( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency034( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00032 */
         pr_default.execute(0, new Object[] {A5SecObjectName, Long.valueOf(A1SecFunctionalityId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecObjectFunctionalities"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecObjectFunctionalities"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert034( )
   {
      beforeValidate034( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable034( ) ;
      }
      if ( AnyError == 0 )
      {
         zm034( 0) ;
         checkOptimisticConcurrency034( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm034( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert034( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000317 */
                  pr_default.execute(15, new Object[] {A5SecObjectName, Long.valueOf(A1SecFunctionalityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObjectFunctionalities");
                  if ( (pr_default.getStatus(15) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
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
            load034( ) ;
         }
         endLevel034( ) ;
      }
      closeExtendedTableCursors034( ) ;
   }

   public void update034( )
   {
      beforeValidate034( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable034( ) ;
      }
      if ( ( nIsMod_4 != 0 ) || ( nIsDirty_4 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency034( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm034( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate034( ) ;
                  if ( AnyError == 0 )
                  {
                     /* No attributes to update on table [SecObjectFunctionalities] */
                     deferredUpdate034( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey034( ) ;
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
            endLevel034( ) ;
         }
      }
      closeExtendedTableCursors034( ) ;
   }

   public void deferredUpdate034( )
   {
   }

   public void delete034( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate034( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency034( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls034( ) ;
         afterConfirm034( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete034( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000318 */
               pr_default.execute(16, new Object[] {A5SecObjectName, Long.valueOf(A1SecFunctionalityId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecObjectFunctionalities");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode4 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel034( ) ;
      Gx_mode = sMode4 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls034( )
   {
      standaloneModal034( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000319 */
         pr_default.execute(17, new Object[] {Long.valueOf(A1SecFunctionalityId)});
         A8SecFunctionalityDescription = T000319_A8SecFunctionalityDescription[0] ;
         pr_default.close(17);
      }
   }

   public void endLevel034( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart034( )
   {
      /* Scan By routine */
      /* Using cursor T000320 */
      pr_default.execute(18, new Object[] {A5SecObjectName});
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A1SecFunctionalityId = T000320_A1SecFunctionalityId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext034( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A1SecFunctionalityId = T000320_A1SecFunctionalityId[0] ;
      }
   }

   public void scanEnd034( )
   {
      pr_default.close(18);
   }

   public void afterConfirm034( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert034( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate034( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete034( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete034( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate034( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes034( )
   {
      edtSecFunctionalityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), !bGXsfl_34_Refreshing);
      edtSecFunctionalityDescription_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityDescription_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityDescription_Enabled), 5, 0), !bGXsfl_34_Refreshing);
   }

   public void send_integrity_lvl_hashes034( )
   {
   }

   public void send_integrity_lvl_hashes033( )
   {
   }

   public void subsflControlProps_344( )
   {
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_34_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_34_idx ;
   }

   public void subsflControlProps_fel_344( )
   {
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID_"+sGXsfl_34_fel_idx ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_34_fel_idx ;
   }

   public void addRow034( )
   {
      nGXsfl_34_idx = (int)(nGXsfl_34_idx+1) ;
      sGXsfl_34_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_34_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_344( ) ;
      sendRow034( ) ;
   }

   public void sendRow034( )
   {
      Gridsecobject_functionalitiesRow = GXWebRow.GetNew(context) ;
      if ( subGridsecobject_functionalities_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridsecobject_functionalities_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridsecobject_functionalities_Class, "") != 0 )
         {
            subGridsecobject_functionalities_Linesclass = subGridsecobject_functionalities_Class+"Odd" ;
         }
      }
      else if ( subGridsecobject_functionalities_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridsecobject_functionalities_Backstyle = (byte)(0) ;
         subGridsecobject_functionalities_Backcolor = subGridsecobject_functionalities_Allbackcolor ;
         if ( GXutil.strcmp(subGridsecobject_functionalities_Class, "") != 0 )
         {
            subGridsecobject_functionalities_Linesclass = subGridsecobject_functionalities_Class+"Uniform" ;
         }
      }
      else if ( subGridsecobject_functionalities_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridsecobject_functionalities_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridsecobject_functionalities_Class, "") != 0 )
         {
            subGridsecobject_functionalities_Linesclass = subGridsecobject_functionalities_Class+"Odd" ;
         }
         subGridsecobject_functionalities_Backcolor = (int)(0x0) ;
      }
      else if ( subGridsecobject_functionalities_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridsecobject_functionalities_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_34_idx) % (2))) == 0 )
         {
            subGridsecobject_functionalities_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridsecobject_functionalities_Class, "") != 0 )
            {
               subGridsecobject_functionalities_Linesclass = subGridsecobject_functionalities_Class+"Even" ;
            }
         }
         else
         {
            subGridsecobject_functionalities_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridsecobject_functionalities_Class, "") != 0 )
            {
               subGridsecobject_functionalities_Linesclass = subGridsecobject_functionalities_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_4_" + sGXsfl_34_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 35,'',false,'" + sGXsfl_34_idx + "',34)\"" ;
      ROClassString = "Attribute" ;
      Gridsecobject_functionalitiesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityId_Internalname,GXutil.ltrim( localUtil.ntoc( A1SecFunctionalityId, (byte)(10), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1SecFunctionalityId), "ZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,35);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtSecFunctionalityId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(34),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridsecobject_functionalitiesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSecFunctionalityDescription_Internalname,A8SecFunctionalityDescription,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSecFunctionalityDescription_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtSecFunctionalityDescription_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(34),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridsecobject_functionalitiesRow);
      send_integrity_lvl_hashes034( ) ;
      GXCCtl = "Z1SecFunctionalityId_" + sGXsfl_34_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1SecFunctionalityId, (byte)(10), (byte)(0), ",", "")));
      GXCCtl = "nRcdDeleted_4_" + sGXsfl_34_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_4, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_4_" + sGXsfl_34_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_4, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_4_" + sGXsfl_34_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_4, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECFUNCTIONALITYID_"+sGXsfl_34_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_34_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSecFunctionalityDescription_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridsecobject_functionalitiesContainer.AddRow(Gridsecobject_functionalitiesRow);
   }

   public void readRow034( )
   {
      nGXsfl_34_idx = (int)(nGXsfl_34_idx+1) ;
      sGXsfl_34_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_34_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_344( ) ;
      edtSecFunctionalityId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECFUNCTIONALITYID_"+sGXsfl_34_idx+"Enabled"), ",", ".")) ;
      edtSecFunctionalityDescription_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SECFUNCTIONALITYDESCRIPTION_"+sGXsfl_34_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") > 9999999999L ) ) )
      {
         GXCCtl = "SECFUNCTIONALITYID_" + sGXsfl_34_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityId_Internalname ;
         wbErr = true ;
         A1SecFunctionalityId = 0 ;
      }
      else
      {
         A1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( edtSecFunctionalityId_Internalname), ",", ".") ;
      }
      A8SecFunctionalityDescription = httpContext.cgiGet( edtSecFunctionalityDescription_Internalname) ;
      GXCCtl = "Z1SecFunctionalityId_" + sGXsfl_34_idx ;
      Z1SecFunctionalityId = localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".") ;
      GXCCtl = "nRcdDeleted_4_" + sGXsfl_34_idx ;
      nRcdDeleted_4 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_4_" + sGXsfl_34_idx ;
      nRcdExists_4 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_4_" + sGXsfl_34_idx ;
      nIsMod_4 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void assign_properties_default( )
   {
      defedtSecFunctionalityId_Enabled = edtSecFunctionalityId_Enabled ;
   }

   public void confirmValues030( )
   {
      nGXsfl_34_idx = 0 ;
      sGXsfl_34_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_34_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_344( ) ;
      while ( nGXsfl_34_idx < nRC_GXsfl_34 )
      {
         nGXsfl_34_idx = (int)(nGXsfl_34_idx+1) ;
         sGXsfl_34_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_34_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_344( ) ;
         httpContext.changePostValue( "Z1SecFunctionalityId_"+sGXsfl_34_idx, httpContext.cgiGet( "ZT_"+"Z1SecFunctionalityId_"+sGXsfl_34_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1SecFunctionalityId_"+sGXsfl_34_idx) ;
      }
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511032964", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wwpbaseobjects.secobject", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z5SecObjectName", Z5SecObjectName);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_34", GXutil.ltrim( localUtil.ntoc( nGXsfl_34_idx, (byte)(8), (byte)(0), ",", "")));
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
      return formatLink("com.projectthani.wwpbaseobjects.secobject", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WWPBaseObjects.SecObject" ;
   }

   public String getPgmdesc( )
   {
      return "Sec Object" ;
   }

   public void initializeNonKey033( )
   {
   }

   public void initAll033( )
   {
      A5SecObjectName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A5SecObjectName", A5SecObjectName);
      initializeNonKey033( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey034( )
   {
      A8SecFunctionalityDescription = "" ;
   }

   public void initAll034( )
   {
      A1SecFunctionalityId = 0 ;
      initializeNonKey034( ) ;
   }

   public void standaloneModalInsert034( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511032967", true, true);
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
      httpContext.AddJavascriptSource("wwpbaseobjects/secobject.js", "?2022511032967", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties4( )
   {
      edtSecFunctionalityId_Enabled = defedtSecFunctionalityId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecFunctionalityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecFunctionalityId_Enabled), 5, 0), !bGXsfl_34_Refreshing);
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      edtSecObjectName_Internalname = "SECOBJECTNAME" ;
      lblTitlefunctionalities_Internalname = "TITLEFUNCTIONALITIES" ;
      edtSecFunctionalityId_Internalname = "SECFUNCTIONALITYID" ;
      edtSecFunctionalityDescription_Internalname = "SECFUNCTIONALITYDESCRIPTION" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Form.setInternalname( "FORM" );
      subGridsecobject_functionalities_Internalname = "GRIDSECOBJECT_FUNCTIONALITIES" ;
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
      Form.setCaption( "Sec Object" );
      edtSecFunctionalityDescription_Jsonclick = "" ;
      edtSecFunctionalityId_Jsonclick = "" ;
      subGridsecobject_functionalities_Class = "Grid" ;
      subGridsecobject_functionalities_Backcolorstyle = (byte)(0) ;
      subGridsecobject_functionalities_Allowcollapsing = (byte)(0) ;
      subGridsecobject_functionalities_Allowselection = (byte)(0) ;
      edtSecFunctionalityDescription_Enabled = 0 ;
      edtSecFunctionalityId_Enabled = 1 ;
      subGridsecobject_functionalities_Header = "" ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtSecObjectName_Jsonclick = "" ;
      edtSecObjectName_Enabled = 1 ;
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

   public void gxnrgridsecobject_functionalities_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_344( ) ;
      while ( nGXsfl_34_idx <= nRC_GXsfl_34 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal034( ) ;
         standaloneModal034( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow034( ) ;
         nGXsfl_34_idx = (int)(nGXsfl_34_idx+1) ;
         sGXsfl_34_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_34_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_344( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridsecobject_functionalitiesContainer)) ;
      /* End function gxnrGridsecobject_functionalities_newrow */
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
      if ( AnyError == 0 )
      {
         GX_FocusControl = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
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

   public void valid_Secobjectname( )
   {
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z5SecObjectName", Z5SecObjectName);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Secfunctionalityid( )
   {
      /* Using cursor T000319 */
      pr_default.execute(17, new Object[] {Long.valueOf(A1SecFunctionalityId)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Functionality'.", "ForeignKeyNotFound", 1, "SECFUNCTIONALITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecFunctionalityId_Internalname ;
      }
      A8SecFunctionalityDescription = T000319_A8SecFunctionalityDescription[0] ;
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A8SecFunctionalityDescription", A8SecFunctionalityDescription);
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
      setEventMetadata("VALID_SECOBJECTNAME","{handler:'valid_Secobjectname',iparms:[{av:'A5SecObjectName',fld:'SECOBJECTNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'}]");
      setEventMetadata("VALID_SECOBJECTNAME",",oparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z5SecObjectName'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'}]}");
      setEventMetadata("VALID_SECFUNCTIONALITYID","{handler:'valid_Secfunctionalityid',iparms:[{av:'A1SecFunctionalityId',fld:'SECFUNCTIONALITYID',pic:'ZZZZZZZZZ9'},{av:'A8SecFunctionalityDescription',fld:'SECFUNCTIONALITYDESCRIPTION',pic:''}]");
      setEventMetadata("VALID_SECFUNCTIONALITYID",",oparms:[{av:'A8SecFunctionalityDescription',fld:'SECFUNCTIONALITYDESCRIPTION',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Secfunctionalitydescription',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      pr_default.close(17);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z5SecObjectName = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
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
      A5SecObjectName = "" ;
      lblTitlefunctionalities_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridsecobject_functionalitiesContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridsecobject_functionalitiesColumn = new com.genexus.webpanels.GXWebColumn();
      A8SecFunctionalityDescription = "" ;
      sMode4 = "" ;
      sStyleString = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      T00037_A5SecObjectName = new String[] {""} ;
      T00038_A5SecObjectName = new String[] {""} ;
      T00036_A5SecObjectName = new String[] {""} ;
      sMode3 = "" ;
      T00039_A5SecObjectName = new String[] {""} ;
      T000310_A5SecObjectName = new String[] {""} ;
      T00035_A5SecObjectName = new String[] {""} ;
      T000313_A5SecObjectName = new String[] {""} ;
      Z8SecFunctionalityDescription = "" ;
      T000314_A5SecObjectName = new String[] {""} ;
      T000314_A8SecFunctionalityDescription = new String[] {""} ;
      T000314_A1SecFunctionalityId = new long[1] ;
      T00034_A8SecFunctionalityDescription = new String[] {""} ;
      T000315_A8SecFunctionalityDescription = new String[] {""} ;
      T000316_A5SecObjectName = new String[] {""} ;
      T000316_A1SecFunctionalityId = new long[1] ;
      T00033_A5SecObjectName = new String[] {""} ;
      T00033_A1SecFunctionalityId = new long[1] ;
      T00032_A5SecObjectName = new String[] {""} ;
      T00032_A1SecFunctionalityId = new long[1] ;
      T000319_A8SecFunctionalityDescription = new String[] {""} ;
      T000320_A5SecObjectName = new String[] {""} ;
      T000320_A1SecFunctionalityId = new long[1] ;
      Gridsecobject_functionalitiesRow = new com.genexus.webpanels.GXWebRow();
      subGridsecobject_functionalities_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      ZZ5SecObjectName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wwpbaseobjects.secobject__default(),
         new Object[] {
             new Object[] {
            T00032_A5SecObjectName, T00032_A1SecFunctionalityId
            }
            , new Object[] {
            T00033_A5SecObjectName, T00033_A1SecFunctionalityId
            }
            , new Object[] {
            T00034_A8SecFunctionalityDescription
            }
            , new Object[] {
            T00035_A5SecObjectName
            }
            , new Object[] {
            T00036_A5SecObjectName
            }
            , new Object[] {
            T00037_A5SecObjectName
            }
            , new Object[] {
            T00038_A5SecObjectName
            }
            , new Object[] {
            T00039_A5SecObjectName
            }
            , new Object[] {
            T000310_A5SecObjectName
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000313_A5SecObjectName
            }
            , new Object[] {
            T000314_A5SecObjectName, T000314_A8SecFunctionalityDescription, T000314_A1SecFunctionalityId
            }
            , new Object[] {
            T000315_A8SecFunctionalityDescription
            }
            , new Object[] {
            T000316_A5SecObjectName, T000316_A1SecFunctionalityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000319_A8SecFunctionalityDescription
            }
            , new Object[] {
            T000320_A5SecObjectName, T000320_A1SecFunctionalityId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte subGridsecobject_functionalities_Backcolorstyle ;
   private byte subGridsecobject_functionalities_Allowselection ;
   private byte subGridsecobject_functionalities_Allowhovering ;
   private byte subGridsecobject_functionalities_Allowcollapsing ;
   private byte subGridsecobject_functionalities_Collapsed ;
   private byte Gx_BScreen ;
   private byte subGridsecobject_functionalities_Backstyle ;
   private byte gxajaxcallmode ;
   private short nRcdDeleted_4 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount4 ;
   private short RcdFound4 ;
   private short nBlankRcdUsr4 ;
   private short RcdFound3 ;
   private short nIsDirty_3 ;
   private short nIsDirty_4 ;
   private int nRC_GXsfl_34 ;
   private int nGXsfl_34_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtSecObjectName_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtSecFunctionalityId_Enabled ;
   private int edtSecFunctionalityDescription_Enabled ;
   private int subGridsecobject_functionalities_Selectedindex ;
   private int subGridsecobject_functionalities_Selectioncolor ;
   private int subGridsecobject_functionalities_Hoveringcolor ;
   private int fRowAdded ;
   private int GX_JID ;
   private int subGridsecobject_functionalities_Backcolor ;
   private int subGridsecobject_functionalities_Allbackcolor ;
   private int defedtSecFunctionalityId_Enabled ;
   private int idxLst ;
   private long Z1SecFunctionalityId ;
   private long A1SecFunctionalityId ;
   private long GRIDSECOBJECT_FUNCTIONALITIES_nFirstRecordOnPage ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_34_idx="0001" ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtSecObjectName_Internalname ;
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
   private String edtSecObjectName_Jsonclick ;
   private String lblTitlefunctionalities_Internalname ;
   private String lblTitlefunctionalities_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String subGridsecobject_functionalities_Header ;
   private String sMode4 ;
   private String edtSecFunctionalityId_Internalname ;
   private String edtSecFunctionalityDescription_Internalname ;
   private String sStyleString ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sMode3 ;
   private String sGXsfl_34_fel_idx="0001" ;
   private String subGridsecobject_functionalities_Class ;
   private String subGridsecobject_functionalities_Linesclass ;
   private String ROClassString ;
   private String edtSecFunctionalityId_Jsonclick ;
   private String edtSecFunctionalityDescription_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridsecobject_functionalities_Internalname ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_34_Refreshing=false ;
   private String Z5SecObjectName ;
   private String A5SecObjectName ;
   private String A8SecFunctionalityDescription ;
   private String Z8SecFunctionalityDescription ;
   private String ZZ5SecObjectName ;
   private com.genexus.webpanels.GXWebGrid Gridsecobject_functionalitiesContainer ;
   private com.genexus.webpanels.GXWebRow Gridsecobject_functionalitiesRow ;
   private com.genexus.webpanels.GXWebColumn Gridsecobject_functionalitiesColumn ;
   private IDataStoreProvider pr_default ;
   private String[] T00037_A5SecObjectName ;
   private String[] T00038_A5SecObjectName ;
   private String[] T00036_A5SecObjectName ;
   private String[] T00039_A5SecObjectName ;
   private String[] T000310_A5SecObjectName ;
   private String[] T00035_A5SecObjectName ;
   private String[] T000313_A5SecObjectName ;
   private String[] T000314_A5SecObjectName ;
   private String[] T000314_A8SecFunctionalityDescription ;
   private long[] T000314_A1SecFunctionalityId ;
   private String[] T00034_A8SecFunctionalityDescription ;
   private String[] T000315_A8SecFunctionalityDescription ;
   private String[] T000316_A5SecObjectName ;
   private long[] T000316_A1SecFunctionalityId ;
   private String[] T00033_A5SecObjectName ;
   private long[] T00033_A1SecFunctionalityId ;
   private String[] T00032_A5SecObjectName ;
   private long[] T00032_A1SecFunctionalityId ;
   private String[] T000319_A8SecFunctionalityDescription ;
   private String[] T000320_A5SecObjectName ;
   private long[] T000320_A1SecFunctionalityId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class secobject__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00032", "SELECT [SecObjectName], [SecFunctionalityId] FROM [SecObjectFunctionalities] WITH (UPDLOCK) WHERE [SecObjectName] = ? AND [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00033", "SELECT [SecObjectName], [SecFunctionalityId] FROM [SecObjectFunctionalities] WHERE [SecObjectName] = ? AND [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00034", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00035", "SELECT [SecObjectName] FROM [SecObject] WITH (UPDLOCK) WHERE [SecObjectName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00036", "SELECT [SecObjectName] FROM [SecObject] WHERE [SecObjectName] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00037", "SELECT TM1.[SecObjectName] FROM [SecObject] TM1 WHERE TM1.[SecObjectName] = ? ORDER BY TM1.[SecObjectName]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00038", "SELECT [SecObjectName] FROM [SecObject] WHERE [SecObjectName] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00039", "SELECT TOP 1 [SecObjectName] FROM [SecObject] WHERE ( [SecObjectName] > ?) ORDER BY [SecObjectName]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000310", "SELECT TOP 1 [SecObjectName] FROM [SecObject] WHERE ( [SecObjectName] < ?) ORDER BY [SecObjectName] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000311", "INSERT INTO [SecObject]([SecObjectName]) VALUES(?)", GX_NOMASK)
         ,new UpdateCursor("T000312", "DELETE FROM [SecObject]  WHERE [SecObjectName] = ?", GX_NOMASK)
         ,new ForEachCursor("T000313", "SELECT [SecObjectName] FROM [SecObject] ORDER BY [SecObjectName]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000314", "SELECT T1.[SecObjectName], T2.[SecFunctionalityDescription], T1.[SecFunctionalityId] FROM ([SecObjectFunctionalities] T1 INNER JOIN [SecFunctionality] T2 ON T2.[SecFunctionalityId] = T1.[SecFunctionalityId]) WHERE T1.[SecObjectName] = ? and T1.[SecFunctionalityId] = ? ORDER BY T1.[SecObjectName], T1.[SecFunctionalityId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000315", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000316", "SELECT [SecObjectName], [SecFunctionalityId] FROM [SecObjectFunctionalities] WHERE [SecObjectName] = ? AND [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000317", "INSERT INTO [SecObjectFunctionalities]([SecObjectName], [SecFunctionalityId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000318", "DELETE FROM [SecObjectFunctionalities]  WHERE [SecObjectName] = ? AND [SecFunctionalityId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000319", "SELECT [SecFunctionalityDescription] FROM [SecFunctionality] WHERE [SecFunctionalityId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000320", "SELECT [SecObjectName], [SecFunctionalityId] FROM [SecObjectFunctionalities] WHERE [SecObjectName] = ? ORDER BY [SecObjectName], [SecFunctionalityId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
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
               stmt.setVarchar(1, (String)parms[0], 120, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 14 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 15 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 16 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               return;
            case 17 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 18 :
               stmt.setVarchar(1, (String)parms[0], 120, false);
               return;
      }
   }

}

