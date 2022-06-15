package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class profesional_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action26") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV15ProfesionalNroDocumento = httpContext.GetPar( "ProfesionalNroDocumento") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15ProfesionalNroDocumento", AV15ProfesionalNroDocumento);
         AV14ProfesionalCorreo = httpContext.GetPar( "ProfesionalCorreo") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalCorreo", AV14ProfesionalCorreo);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_26_089( Gx_mode, AV15ProfesionalNroDocumento, AV14ProfesionalCorreo) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_44") == 0 )
      {
         A43PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_44( A43PaisId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_45") == 0 )
      {
         A44UbigeoCode = httpContext.GetPar( "UbigeoCode") ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_45( A44UbigeoCode) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_46") == 0 )
      {
         A6SecUserId = (short)(GXutil.lval( httpContext.GetPar( "SecUserId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_46( A6SecUserId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_48") == 0 )
      {
         A32EspecialidadId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadId"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_48( A32EspecialidadId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_50") == 0 )
      {
         A30SedeId = (short)(GXutil.lval( httpContext.GetPar( "SedeId"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_50( A30SedeId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_51") == 0 )
      {
         A28ClinicaId = (short)(GXutil.lval( httpContext.GetPar( "ClinicaId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_51( A28ClinicaId) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridprofesional_especialidad_sede") == 0 )
      {
         nRC_GXsfl_209 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_209"))) ;
         nGXsfl_209_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_209_idx"))) ;
         sGXsfl_209_idx = httpContext.GetPar( "sGXsfl_209_idx") ;
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridprofesional_especialidad_sede_newrow( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
      {
         nRC_GXsfl_184 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_184"))) ;
         nGXsfl_184_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_184_idx"))) ;
         sGXsfl_184_idx = httpContext.GetPar( "sGXsfl_184_idx") ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgrid1_newrow( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridprofesional_educacion") == 0 )
      {
         nRC_GXsfl_220 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_220"))) ;
         nGXsfl_220_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_220_idx"))) ;
         sGXsfl_220_idx = httpContext.GetPar( "sGXsfl_220_idx") ;
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridprofesional_educacion_newrow( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridprofesional_experiencialaboral") == 0 )
      {
         nRC_GXsfl_231 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_231"))) ;
         nGXsfl_231_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_231_idx"))) ;
         sGXsfl_231_idx = httpContext.GetPar( "sGXsfl_231_idx") ;
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridprofesional_experiencialaboral_newrow( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridprofesional_premios") == 0 )
      {
         nRC_GXsfl_241 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_241"))) ;
         nGXsfl_241_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_241_idx"))) ;
         sGXsfl_241_idx = httpContext.GetPar( "sGXsfl_241_idx") ;
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridprofesional_premios_newrow( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridprofesional_servicios") == 0 )
      {
         nRC_GXsfl_251 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_251"))) ;
         nGXsfl_251_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_251_idx"))) ;
         sGXsfl_251_idx = httpContext.GetPar( "sGXsfl_251_idx") ;
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxnrgridprofesional_servicios_newrow( ) ;
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
         Form.getMeta().addItem("description", "Profesional", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusTheme");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public profesional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public profesional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( profesional_impl.class ));
   }

   public profesional_impl( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbProfesionalTipoDocumento = new HTMLChoice();
      cmbProfesionalSexo = new HTMLChoice();
      cmbProfesionalTiempoCita = new HTMLChoice();
      chkProfesionalTerminosCondiciones = UIFactory.getCheckbox(this);
      cmbProfesionalEstadoCuenta = new HTMLChoice();
      cmbProfesionalEstado = new HTMLChoice();
      cmbSedeTipoConsulta = new HTMLChoice();
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
      if ( cmbProfesionalTipoDocumento.getItemCount() > 0 )
      {
         A173ProfesionalTipoDocumento = cmbProfesionalTipoDocumento.getValidValue(A173ProfesionalTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A173ProfesionalTipoDocumento", A173ProfesionalTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalTipoDocumento.setValue( GXutil.rtrim( A173ProfesionalTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTipoDocumento.getInternalname(), "Values", cmbProfesionalTipoDocumento.ToJavascriptSource(), true);
      }
      if ( cmbProfesionalSexo.getItemCount() > 0 )
      {
         A177ProfesionalSexo = cmbProfesionalSexo.getValidValue(A177ProfesionalSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A177ProfesionalSexo", A177ProfesionalSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalSexo.setValue( GXutil.rtrim( A177ProfesionalSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalSexo.getInternalname(), "Values", cmbProfesionalSexo.ToJavascriptSource(), true);
      }
      if ( cmbProfesionalTiempoCita.getItemCount() > 0 )
      {
         A182ProfesionalTiempoCita = (byte)(GXutil.lval( cmbProfesionalTiempoCita.getValidValue(GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalTiempoCita.setValue( GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTiempoCita.getInternalname(), "Values", cmbProfesionalTiempoCita.ToJavascriptSource(), true);
      }
      A196ProfesionalTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( A196ProfesionalTerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A196ProfesionalTerminosCondiciones", A196ProfesionalTerminosCondiciones);
      if ( cmbProfesionalEstadoCuenta.getItemCount() > 0 )
      {
         A197ProfesionalEstadoCuenta = cmbProfesionalEstadoCuenta.getValidValue(A197ProfesionalEstadoCuenta) ;
         httpContext.ajax_rsp_assign_attri("", false, "A197ProfesionalEstadoCuenta", A197ProfesionalEstadoCuenta);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalEstadoCuenta.setValue( GXutil.rtrim( A197ProfesionalEstadoCuenta) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstadoCuenta.getInternalname(), "Values", cmbProfesionalEstadoCuenta.ToJavascriptSource(), true);
      }
      if ( cmbProfesionalEstado.getItemCount() > 0 )
      {
         A198ProfesionalEstado = cmbProfesionalEstado.getValidValue(A198ProfesionalEstado) ;
         httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalEstado.setValue( GXutil.rtrim( A198ProfesionalEstado) );
         httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstado.getInternalname(), "Values", cmbProfesionalEstado.ToJavascriptSource(), true);
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
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Profesional", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Profesional.htm");
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
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "|<", bttBtn_first_Jsonclick, 5, "|<", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 14,'',false,'',0)\"" ;
      ClassString = "BtnPrevious" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "<", bttBtn_previous_Jsonclick, 5, "<", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'',0)\"" ;
      ClassString = "BtnNext" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", ">", bttBtn_next_Jsonclick, 5, ">", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 18,'',false,'',0)\"" ;
      ClassString = "BtnLast" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", ">|", bttBtn_last_Jsonclick, 5, ">|", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'',0)\"" ;
      ClassString = "BtnSelect" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Seleccionar", bttBtn_select_Jsonclick, 5, "Seleccionar", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Profesional.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalId_Internalname, GXutil.ltrim( localUtil.ntoc( A31ProfesionalId, (byte)(8), (byte)(0), ",", "")), GXutil.ltrim( ((edtProfesionalId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalId_Enabled, 0, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbProfesionalTipoDocumento.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbProfesionalTipoDocumento.getInternalname(), "Tipo Documento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbProfesionalTipoDocumento, cmbProfesionalTipoDocumento.getInternalname(), GXutil.rtrim( A173ProfesionalTipoDocumento), 1, cmbProfesionalTipoDocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbProfesionalTipoDocumento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "", true, (byte)(1), "HLP_Profesional.htm");
      cmbProfesionalTipoDocumento.setValue( GXutil.rtrim( A173ProfesionalTipoDocumento) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTipoDocumento.getInternalname(), "Values", cmbProfesionalTipoDocumento.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalNroDocumento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalNroDocumento_Internalname, "Nro Documento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalNroDocumento_Internalname, A174ProfesionalNroDocumento, GXutil.rtrim( localUtil.format( A174ProfesionalNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalNroDocumento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalNroDocumento_Enabled, 1, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalApellidoPaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalApellidoPaterno_Internalname, "Apellido Paterno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalApellidoPaterno_Internalname, A85ProfesionalApellidoPaterno, GXutil.rtrim( localUtil.format( A85ProfesionalApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalApellidoPaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalApellidoPaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalApellidoMaterno_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalApellidoMaterno_Internalname, "Apellido Materno", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalApellidoMaterno_Internalname, A86ProfesionalApellidoMaterno, GXutil.rtrim( localUtil.format( A86ProfesionalApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalApellidoMaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalApellidoMaterno_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalNombres_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalNombres_Internalname, "Nombres", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalNombres_Internalname, A84ProfesionalNombres, GXutil.rtrim( localUtil.format( A84ProfesionalNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalNombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalNombres_Enabled, 0, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalNombreCompleto2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalNombreCompleto2_Internalname, "Nombre Completo2", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalNombreCompleto2_Internalname, A175ProfesionalNombreCompleto2, GXutil.rtrim( localUtil.format( A175ProfesionalNombreCompleto2, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalNombreCompleto2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalNombreCompleto2_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalFechaNacimiento_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalFechaNacimiento_Internalname, "Fecha Nacimiento", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtProfesionalFechaNacimiento_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalFechaNacimiento_Internalname, localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"), localUtil.format( A176ProfesionalFechaNacimiento, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalFechaNacimiento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalFechaNacimiento_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtProfesionalFechaNacimiento_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtProfesionalFechaNacimiento_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Profesional.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbProfesionalSexo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbProfesionalSexo.getInternalname(), "Sexo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbProfesionalSexo, cmbProfesionalSexo.getInternalname(), GXutil.rtrim( A177ProfesionalSexo), 1, cmbProfesionalSexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbProfesionalSexo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "", true, (byte)(1), "HLP_Profesional.htm");
      cmbProfesionalSexo.setValue( GXutil.rtrim( A177ProfesionalSexo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalSexo.getInternalname(), "Values", cmbProfesionalSexo.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalDescripcion_Internalname, "Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 73,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtProfesionalDescripcion_Internalname, A178ProfesionalDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,73);\"", (short)(0), 1, edtProfesionalDescripcion_Enabled, 0, 80, "chr", 10, "row", StyleString, ClassString, "", "", "5000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalCorreo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalCorreo_Internalname, "Correo", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalCorreo_Internalname, A179ProfesionalCorreo, GXutil.rtrim( localUtil.format( A179ProfesionalCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "'"+""+"'"+",false,"+"'"+""+"'", "mailto:"+A179ProfesionalCorreo, "", "", "", edtProfesionalCorreo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalCorreo_Enabled, 0, "email", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Email", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalCOP_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalCOP_Internalname, "CMP", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalCOP_Internalname, A88ProfesionalCOP, GXutil.rtrim( localUtil.format( A88ProfesionalCOP, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalCOP_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalCOP_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalColorDisponible_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalColorDisponible_Internalname, "Color Disponible", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 88,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalColorDisponible_Internalname, GXutil.rtrim( A180ProfesionalColorDisponible), GXutil.rtrim( localUtil.format( A180ProfesionalColorDisponible, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,88);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalColorDisponible_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalColorDisponible_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalColorCita_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalColorCita_Internalname, "Color Cita", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalColorCita_Internalname, GXutil.rtrim( A181ProfesionalColorCita), GXutil.rtrim( localUtil.format( A181ProfesionalColorCita, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalColorCita_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalColorCita_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbProfesionalTiempoCita.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbProfesionalTiempoCita.getInternalname(), "Tiempo Cita", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbProfesionalTiempoCita, cmbProfesionalTiempoCita.getInternalname(), GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0)), 1, cmbProfesionalTiempoCita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbProfesionalTiempoCita.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", "", true, (byte)(1), "HLP_Profesional.htm");
      cmbProfesionalTiempoCita.setValue( GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTiempoCita.getInternalname(), "Values", cmbProfesionalTiempoCita.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalDireccion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalDireccion_Internalname, "Direccion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 103,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtProfesionalDireccion_Internalname, A183ProfesionalDireccion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,103);\"", (short)(0), 1, edtProfesionalDireccion_Enabled, 0, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaisId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPaisId_Internalname, "Pais Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPaisId_Internalname, GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtPaisId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A43PaisId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A43PaisId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,108);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaisId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaisId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "Id4", "right", false, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtPaisDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtPaisDescripcion_Internalname, "Pais Descripcion", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtPaisDescripcion_Internalname, A184PaisDescripcion, GXutil.rtrim( localUtil.format( A184PaisDescripcion, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaisDescripcion_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtPaisDescripcion_Enabled, 0, "text", "", 80, "chr", 1, "row", 80, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoCode_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoCode_Internalname, "Ubigeo Code", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoCode_Internalname, GXutil.rtrim( A44UbigeoCode), GXutil.rtrim( localUtil.format( A44UbigeoCode, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoCode_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoCode_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtUbigeoNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtUbigeoNombre_Internalname, "Ubigeo Nombre", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtUbigeoNombre_Internalname, A185UbigeoNombre, GXutil.rtrim( localUtil.format( A185UbigeoNombre, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtUbigeoNombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtUbigeoNombre_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgProfesionalFoto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Foto", "col-sm-3 ImageAttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
      ClassString = "ImageAttribute" ;
      StyleString = "" ;
      A189ProfesionalFoto_IsBlob = (boolean)(((GXutil.strcmp("", A189ProfesionalFoto)==0)&&(GXutil.strcmp("", A40000ProfesionalFoto_GXI)==0))||!(GXutil.strcmp("", A189ProfesionalFoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.getResourceRelative(A189ProfesionalFoto)) ;
      com.projectthani.GxWebStd.gx_bitmap( httpContext, imgProfesionalFoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgProfesionalFoto_Enabled, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,128);\"", "", "", "", 0, A189ProfesionalFoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Profesional.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "URL", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.getResourceRelative(A189ProfesionalFoto)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "IsBlob", GXutil.booltostr( A189ProfesionalFoto_IsBlob), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalTwitter_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalTwitter_Internalname, "Twitter", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalTwitter_Internalname, A190ProfesionalTwitter, GXutil.rtrim( localUtil.format( A190ProfesionalTwitter, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,133);\"", "'"+""+"'"+",false,"+"'"+""+"'", A190ProfesionalTwitter, "_blank", "", "", edtProfesionalTwitter_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalTwitter_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalFacebook_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalFacebook_Internalname, "Facebook", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 138,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalFacebook_Internalname, A191ProfesionalFacebook, GXutil.rtrim( localUtil.format( A191ProfesionalFacebook, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,138);\"", "'"+""+"'"+",false,"+"'"+""+"'", A191ProfesionalFacebook, "_blank", "", "", edtProfesionalFacebook_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalFacebook_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalInstagram_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalInstagram_Internalname, "Instagram", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 143,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalInstagram_Internalname, A192ProfesionalInstagram, GXutil.rtrim( localUtil.format( A192ProfesionalInstagram, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,143);\"", "'"+""+"'"+",false,"+"'"+""+"'", A192ProfesionalInstagram, "_blank", "", "", edtProfesionalInstagram_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalInstagram_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalLinkedin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalLinkedin_Internalname, "Linkedin", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 148,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalLinkedin_Internalname, A193ProfesionalLinkedin, GXutil.rtrim( localUtil.format( A193ProfesionalLinkedin, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,148);\"", "'"+""+"'"+",false,"+"'"+""+"'", A193ProfesionalLinkedin, "_blank", "", "", edtProfesionalLinkedin_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalLinkedin_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalTelefono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalTelefono_Internalname, "Telefono", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      if ( httpContext.isSmartDevice( ) )
      {
         gxphoneLink = "tel:" + GXutil.rtrim( A194ProfesionalTelefono) ;
      }
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalTelefono_Internalname, GXutil.rtrim( A194ProfesionalTelefono), GXutil.rtrim( localUtil.format( A194ProfesionalTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,153);\"", "'"+""+"'"+",false,"+"'"+""+"'", gxphoneLink, "", "", "", edtProfesionalTelefono_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalTelefono_Enabled, 0, "tel", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "GeneXus\\Phone", "left", true, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtSecUserId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtSecUserId_Internalname, "User Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 158,'',false,'',0)\"" ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtSecUserId_Internalname, GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ",", "")), GXutil.ltrim( ((edtSecUserId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A6SecUserId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,158);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtSecUserId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtSecUserId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtProfesionalFechaRegistro_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, edtProfesionalFechaRegistro_Internalname, "Fecha Registro", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 163,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtProfesionalFechaRegistro_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtProfesionalFechaRegistro_Internalname, localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"), localUtil.format( A195ProfesionalFechaRegistro, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,163);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtProfesionalFechaRegistro_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtProfesionalFechaRegistro_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_bitmap( httpContext, edtProfesionalFechaRegistro_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtProfesionalFechaRegistro_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_Profesional.htm");
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
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkProfesionalTerminosCondiciones.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, chkProfesionalTerminosCondiciones.getInternalname(), "Terminos Condiciones", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 168,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkProfesionalTerminosCondiciones.getInternalname(), GXutil.booltostr( A196ProfesionalTerminosCondiciones), "", "Terminos Condiciones", 1, chkProfesionalTerminosCondiciones.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(168, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,168);\"");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbProfesionalEstadoCuenta.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbProfesionalEstadoCuenta.getInternalname(), "Estado Cuenta", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 173,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbProfesionalEstadoCuenta, cmbProfesionalEstadoCuenta.getInternalname(), GXutil.rtrim( A197ProfesionalEstadoCuenta), 1, cmbProfesionalEstadoCuenta.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbProfesionalEstadoCuenta.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,173);\"", "", true, (byte)(1), "HLP_Profesional.htm");
      cmbProfesionalEstadoCuenta.setValue( GXutil.rtrim( A197ProfesionalEstadoCuenta) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstadoCuenta.getInternalname(), "Values", cmbProfesionalEstadoCuenta.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbProfesionalEstado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      com.projectthani.GxWebStd.gx_label_element( httpContext, cmbProfesionalEstado.getInternalname(), "Estado", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 178,'',false,'',0)\"" ;
      /* ComboBox */
      com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbProfesionalEstado, cmbProfesionalEstado.getInternalname(), GXutil.rtrim( A198ProfesionalEstado), 1, cmbProfesionalEstado.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbProfesionalEstado.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,178);\"", "", true, (byte)(1), "HLP_Profesional.htm");
      cmbProfesionalEstado.setValue( GXutil.rtrim( A198ProfesionalEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstado.getInternalname(), "Values", cmbProfesionalEstado.ToJavascriptSource(), true);
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitleespecialidad_Internalname, "Especialidad", "", "", lblTitleespecialidad_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      gxdraw_grid1( ) ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitleeducacion_Internalname, "Educacion", "", "", lblTitleeducacion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      gxdraw_gridprofesional_educacion( ) ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitleexperiencialaboral_Internalname, "Experiencia Laboral", "", "", lblTitleexperiencialaboral_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      gxdraw_gridprofesional_experiencialaboral( ) ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitlepremios_Internalname, "Premios", "", "", lblTitlepremios_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      drawcontrols1( ) ;
   }

   public void drawcontrols1( )
   {
      gxdraw_gridprofesional_premios( ) ;
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      /* Text block */
      com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitleservicios_Internalname, "Servicios", "", "", lblTitleservicios_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Title", 0, "", 1, 1, 0, (short)(0), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3", "left", "top", "", "", "div");
      gxdraw_gridprofesional_servicios( ) ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 258,'',false,'',0)\"" ;
      ClassString = "BtnEnter" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirmar", bttBtn_enter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 260,'',false,'',0)\"" ;
      ClassString = "BtnCancel" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancelar", bttBtn_cancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 262,'',false,'',0)\"" ;
      ClassString = "BtnDelete" ;
      StyleString = "" ;
      com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Eliminar", bttBtn_delete_Jsonclick, 5, "Eliminar", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Profesional.htm");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_grid1( )
   {
      /*  Grid Control  */
      Grid1Container.AddObjectProperty("GridName", "Grid1");
      Grid1Container.AddObjectProperty("Header", subGrid1_Header);
      Grid1Container.AddObjectProperty("Class", GXutil.rtrim( "TrnSublevelGrid"));
      Grid1Container.AddObjectProperty("Class", "TrnSublevelGrid");
      Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("CmpContext", "");
      Grid1Container.AddObjectProperty("InMasterPage", "false");
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ".", "")));
      Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Column.AddObjectProperty("Value", A140EspecialidadCodigo);
      Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadCodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Column.AddObjectProperty("Value", A71EspecialidadNombre);
      Grid1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Column.AddObjectProperty("Value", lblTitlesede_Caption);
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Grid1Container.AddColumnProperties(Grid1Column);
      Grid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
      /* Save parent mode. */
      sMode10 = Gx_mode ;
      nGXsfl_184_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount10 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_10 = (short)(1) ;
            scanStart0810( ) ;
            while ( RcdFound10 != 0 )
            {
               init_level_properties10( ) ;
               getByPrimaryKey0810( ) ;
               addRow0810( ) ;
               scanNext0810( ) ;
            }
            scanEnd0810( ) ;
            nBlankRcdCount10 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0810( ) ;
         standaloneModal0810( ) ;
         sMode10 = Gx_mode ;
         while ( nGXsfl_184_idx < nRC_GXsfl_184 )
         {
            bGXsfl_184_Refreshing = true ;
            readRow0810( ) ;
            edtEspecialidadId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESPECIALIDADID_"+sGXsfl_184_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), !bGXsfl_184_Refreshing);
            edtEspecialidadCodigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESPECIALIDADCODIGO_"+sGXsfl_184_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadCodigo_Enabled), 5, 0), !bGXsfl_184_Refreshing);
            edtEspecialidadNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESPECIALIDADNOMBRE_"+sGXsfl_184_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadNombre_Enabled), 5, 0), !bGXsfl_184_Refreshing);
            if ( ( nRcdExists_10 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0810( ) ;
            }
            sendRow0810( ) ;
            bGXsfl_184_Refreshing = false ;
         }
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount10 = (short)(5) ;
         nRcdExists_10 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0810( ) ;
            while ( RcdFound10 != 0 )
            {
               sGXsfl_184_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_184_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_18410( ) ;
               init_level_properties10( ) ;
               standaloneNotModal0810( ) ;
               getByPrimaryKey0810( ) ;
               standaloneModal0810( ) ;
               addRow0810( ) ;
               scanNext0810( ) ;
            }
            scanEnd0810( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode10 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_184_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_184_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_18410( ) ;
      initAll0810( ) ;
      init_level_properties10( ) ;
      nRcdExists_10 = (short)(0) ;
      nIsMod_10 = (short)(0) ;
      nRcdDeleted_10 = (short)(0) ;
      nBlankRcdCount10 = (short)(nBlankRcdUsr10+nBlankRcdCount10) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount10 > 0 )
      {
         standaloneNotModal0810( ) ;
         standaloneModal0810( ) ;
         addRow0810( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtEspecialidadId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount10 = (short)(nBlankRcdCount10-1) ;
      }
      Gx_mode = sMode10 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* Restore parent mode. */
      Gx_mode = sMode10 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
      }
   }

   public void gxdraw_gridprofesional_educacion( )
   {
      /*  Grid Control  */
      Gridprofesional_educacionContainer.AddObjectProperty("GridName", "Gridprofesional_educacion");
      Gridprofesional_educacionContainer.AddObjectProperty("Header", subGridprofesional_educacion_Header);
      Gridprofesional_educacionContainer.AddObjectProperty("Class", "Grid");
      Gridprofesional_educacionContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("CmpContext", "");
      Gridprofesional_educacionContainer.AddObjectProperty("InMasterPage", "false");
      Gridprofesional_educacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_educacionColumn.AddObjectProperty("Value", A55EducacionId.toString());
      Gridprofesional_educacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddColumnProperties(Gridprofesional_educacionColumn);
      Gridprofesional_educacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_educacionColumn.AddObjectProperty("Value", A200EducacionNombreInstitucion);
      Gridprofesional_educacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionNombreInstitucion_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddColumnProperties(Gridprofesional_educacionColumn);
      Gridprofesional_educacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_educacionColumn.AddObjectProperty("Value", localUtil.format(A201EducacionDesde, "99/99/99"));
      Gridprofesional_educacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddColumnProperties(Gridprofesional_educacionColumn);
      Gridprofesional_educacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_educacionColumn.AddObjectProperty("Value", localUtil.format(A202EducacionHasta, "99/99/99"));
      Gridprofesional_educacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddColumnProperties(Gridprofesional_educacionColumn);
      Gridprofesional_educacionColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_educacionColumn.AddObjectProperty("Value", A203EducacionPaisDescripcion);
      Gridprofesional_educacionColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionPaisDescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddColumnProperties(Gridprofesional_educacionColumn);
      Gridprofesional_educacionContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_educacionContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridprofesional_educacion_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_220_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount12 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_12 = (short)(1) ;
            scanStart0812( ) ;
            while ( RcdFound12 != 0 )
            {
               init_level_properties12( ) ;
               getByPrimaryKey0812( ) ;
               addRow0812( ) ;
               scanNext0812( ) ;
            }
            scanEnd0812( ) ;
            nBlankRcdCount12 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0812( ) ;
         standaloneModal0812( ) ;
         sMode12 = Gx_mode ;
         while ( nGXsfl_220_idx < nRC_GXsfl_220 )
         {
            bGXsfl_220_Refreshing = true ;
            readRow0812( ) ;
            edtEducacionId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONID_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEducacionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionId_Enabled), 5, 0), !bGXsfl_220_Refreshing);
            edtEducacionNombreInstitucion_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONNOMBREINSTITUCION_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEducacionNombreInstitucion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionNombreInstitucion_Enabled), 5, 0), !bGXsfl_220_Refreshing);
            edtEducacionDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONDESDE_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEducacionDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionDesde_Enabled), 5, 0), !bGXsfl_220_Refreshing);
            edtEducacionHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONHASTA_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEducacionHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionHasta_Enabled), 5, 0), !bGXsfl_220_Refreshing);
            edtEducacionPaisDescripcion_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONPAISDESCRIPCION_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEducacionPaisDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionPaisDescripcion_Enabled), 5, 0), !bGXsfl_220_Refreshing);
            if ( ( nRcdExists_12 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0812( ) ;
            }
            sendRow0812( ) ;
            bGXsfl_220_Refreshing = false ;
         }
         Gx_mode = sMode12 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount12 = (short)(5) ;
         nRcdExists_12 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0812( ) ;
            while ( RcdFound12 != 0 )
            {
               sGXsfl_220_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_220_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_22012( ) ;
               init_level_properties12( ) ;
               standaloneNotModal0812( ) ;
               getByPrimaryKey0812( ) ;
               standaloneModal0812( ) ;
               addRow0812( ) ;
               scanNext0812( ) ;
            }
            scanEnd0812( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode12 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_220_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_220_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_22012( ) ;
      initAll0812( ) ;
      init_level_properties12( ) ;
      nRcdExists_12 = (short)(0) ;
      nIsMod_12 = (short)(0) ;
      nRcdDeleted_12 = (short)(0) ;
      nBlankRcdCount12 = (short)(nBlankRcdUsr12+nBlankRcdCount12) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount12 > 0 )
      {
         A55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
         standaloneNotModal0812( ) ;
         standaloneModal0812( ) ;
         addRow0812( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtEducacionId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount12 = (short)(nBlankRcdCount12-1) ;
      }
      Gx_mode = sMode12 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridprofesional_educacionContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridprofesional_educacion", Gridprofesional_educacionContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_educacionContainerData", Gridprofesional_educacionContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_educacionContainerData"+"V", Gridprofesional_educacionContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridprofesional_educacionContainerData"+"V"+"\" value='"+Gridprofesional_educacionContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void gxdraw_gridprofesional_experiencialaboral( )
   {
      /*  Grid Control  */
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("GridName", "Gridprofesional_experiencialaboral");
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Header", subGridprofesional_experiencialaboral_Header);
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Class", "Grid");
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("CmpContext", "");
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("InMasterPage", "false");
      Gridprofesional_experiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Value", A56ExperienciaLaboralId.toString());
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddColumnProperties(Gridprofesional_experiencialaboralColumn);
      Gridprofesional_experiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Value", A204ExperienciaLaboralEmpresaNombre);
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralEmpresaNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddColumnProperties(Gridprofesional_experiencialaboralColumn);
      Gridprofesional_experiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Value", localUtil.format(A205ExperienciaLaboralDesde, "99/99/9999"));
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddColumnProperties(Gridprofesional_experiencialaboralColumn);
      Gridprofesional_experiencialaboralColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Value", localUtil.format(A206ExperienciaLaboralHasta, "99/99/9999"));
      Gridprofesional_experiencialaboralColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddColumnProperties(Gridprofesional_experiencialaboralColumn);
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_experiencialaboralContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridprofesional_experiencialaboral_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_231_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount13 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_13 = (short)(1) ;
            scanStart0813( ) ;
            while ( RcdFound13 != 0 )
            {
               init_level_properties13( ) ;
               getByPrimaryKey0813( ) ;
               addRow0813( ) ;
               scanNext0813( ) ;
            }
            scanEnd0813( ) ;
            nBlankRcdCount13 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0813( ) ;
         standaloneModal0813( ) ;
         sMode13 = Gx_mode ;
         while ( nGXsfl_231_idx < nRC_GXsfl_231 )
         {
            bGXsfl_231_Refreshing = true ;
            readRow0813( ) ;
            edtExperienciaLaboralId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALID_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralId_Enabled), 5, 0), !bGXsfl_231_Refreshing);
            edtExperienciaLaboralEmpresaNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralEmpresaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralEmpresaNombre_Enabled), 5, 0), !bGXsfl_231_Refreshing);
            edtExperienciaLaboralDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALDESDE_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralDesde_Enabled), 5, 0), !bGXsfl_231_Refreshing);
            edtExperienciaLaboralHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALHASTA_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralHasta_Enabled), 5, 0), !bGXsfl_231_Refreshing);
            if ( ( nRcdExists_13 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0813( ) ;
            }
            sendRow0813( ) ;
            bGXsfl_231_Refreshing = false ;
         }
         Gx_mode = sMode13 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount13 = (short)(5) ;
         nRcdExists_13 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0813( ) ;
            while ( RcdFound13 != 0 )
            {
               sGXsfl_231_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_231_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_23113( ) ;
               init_level_properties13( ) ;
               standaloneNotModal0813( ) ;
               getByPrimaryKey0813( ) ;
               standaloneModal0813( ) ;
               addRow0813( ) ;
               scanNext0813( ) ;
            }
            scanEnd0813( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode13 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_231_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_231_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_23113( ) ;
      initAll0813( ) ;
      init_level_properties13( ) ;
      nRcdExists_13 = (short)(0) ;
      nIsMod_13 = (short)(0) ;
      nRcdDeleted_13 = (short)(0) ;
      nBlankRcdCount13 = (short)(nBlankRcdUsr13+nBlankRcdCount13) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount13 > 0 )
      {
         A56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
         standaloneNotModal0813( ) ;
         standaloneModal0813( ) ;
         addRow0813( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtExperienciaLaboralId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount13 = (short)(nBlankRcdCount13-1) ;
      }
      Gx_mode = sMode13 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridprofesional_experiencialaboralContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridprofesional_experiencialaboral", Gridprofesional_experiencialaboralContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_experiencialaboralContainerData", Gridprofesional_experiencialaboralContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_experiencialaboralContainerData"+"V", Gridprofesional_experiencialaboralContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridprofesional_experiencialaboralContainerData"+"V"+"\" value='"+Gridprofesional_experiencialaboralContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void gxdraw_gridprofesional_premios( )
   {
      /*  Grid Control  */
      Gridprofesional_premiosContainer.AddObjectProperty("GridName", "Gridprofesional_premios");
      Gridprofesional_premiosContainer.AddObjectProperty("Header", subGridprofesional_premios_Header);
      Gridprofesional_premiosContainer.AddObjectProperty("Class", "Grid");
      Gridprofesional_premiosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("CmpContext", "");
      Gridprofesional_premiosContainer.AddObjectProperty("InMasterPage", "false");
      Gridprofesional_premiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_premiosColumn.AddObjectProperty("Value", A57PremiosId.toString());
      Gridprofesional_premiosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddColumnProperties(Gridprofesional_premiosColumn);
      Gridprofesional_premiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_premiosColumn.AddObjectProperty("Value", A207PremiosNombre);
      Gridprofesional_premiosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddColumnProperties(Gridprofesional_premiosColumn);
      Gridprofesional_premiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_premiosColumn.AddObjectProperty("Value", localUtil.format(A208PremiosFecha, "99/99/99"));
      Gridprofesional_premiosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosFecha_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddColumnProperties(Gridprofesional_premiosColumn);
      Gridprofesional_premiosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_premiosColumn.AddObjectProperty("Value", A209PremiosDescripcion);
      Gridprofesional_premiosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosDescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddColumnProperties(Gridprofesional_premiosColumn);
      Gridprofesional_premiosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_premiosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridprofesional_premios_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_241_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount14 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_14 = (short)(1) ;
            scanStart0814( ) ;
            while ( RcdFound14 != 0 )
            {
               init_level_properties14( ) ;
               getByPrimaryKey0814( ) ;
               addRow0814( ) ;
               scanNext0814( ) ;
            }
            scanEnd0814( ) ;
            nBlankRcdCount14 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0814( ) ;
         standaloneModal0814( ) ;
         sMode14 = Gx_mode ;
         while ( nGXsfl_241_idx < nRC_GXsfl_241 )
         {
            bGXsfl_241_Refreshing = true ;
            readRow0814( ) ;
            edtPremiosId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSID_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPremiosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosId_Enabled), 5, 0), !bGXsfl_241_Refreshing);
            edtPremiosNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSNOMBRE_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPremiosNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosNombre_Enabled), 5, 0), !bGXsfl_241_Refreshing);
            edtPremiosFecha_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSFECHA_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPremiosFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosFecha_Enabled), 5, 0), !bGXsfl_241_Refreshing);
            edtPremiosDescripcion_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSDESCRIPCION_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtPremiosDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosDescripcion_Enabled), 5, 0), !bGXsfl_241_Refreshing);
            if ( ( nRcdExists_14 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0814( ) ;
            }
            sendRow0814( ) ;
            bGXsfl_241_Refreshing = false ;
         }
         Gx_mode = sMode14 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount14 = (short)(5) ;
         nRcdExists_14 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0814( ) ;
            while ( RcdFound14 != 0 )
            {
               sGXsfl_241_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_241_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_24114( ) ;
               init_level_properties14( ) ;
               standaloneNotModal0814( ) ;
               getByPrimaryKey0814( ) ;
               standaloneModal0814( ) ;
               addRow0814( ) ;
               scanNext0814( ) ;
            }
            scanEnd0814( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode14 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_241_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_241_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_24114( ) ;
      initAll0814( ) ;
      init_level_properties14( ) ;
      nRcdExists_14 = (short)(0) ;
      nIsMod_14 = (short)(0) ;
      nRcdDeleted_14 = (short)(0) ;
      nBlankRcdCount14 = (short)(nBlankRcdUsr14+nBlankRcdCount14) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount14 > 0 )
      {
         A57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
         standaloneNotModal0814( ) ;
         standaloneModal0814( ) ;
         addRow0814( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtPremiosId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount14 = (short)(nBlankRcdCount14-1) ;
      }
      Gx_mode = sMode14 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridprofesional_premiosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridprofesional_premios", Gridprofesional_premiosContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_premiosContainerData", Gridprofesional_premiosContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_premiosContainerData"+"V", Gridprofesional_premiosContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridprofesional_premiosContainerData"+"V"+"\" value='"+Gridprofesional_premiosContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void gxdraw_gridprofesional_servicios( )
   {
      /*  Grid Control  */
      Gridprofesional_serviciosContainer.AddObjectProperty("GridName", "Gridprofesional_servicios");
      Gridprofesional_serviciosContainer.AddObjectProperty("Header", subGridprofesional_servicios_Header);
      Gridprofesional_serviciosContainer.AddObjectProperty("Class", "Grid");
      Gridprofesional_serviciosContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("CmpContext", "");
      Gridprofesional_serviciosContainer.AddObjectProperty("InMasterPage", "false");
      Gridprofesional_serviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_serviciosColumn.AddObjectProperty("Value", A58ServiciosId.toString());
      Gridprofesional_serviciosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddColumnProperties(Gridprofesional_serviciosColumn);
      Gridprofesional_serviciosColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_serviciosColumn.AddObjectProperty("Value", A210ServiciosNombre);
      Gridprofesional_serviciosColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddColumnProperties(Gridprofesional_serviciosColumn);
      Gridprofesional_serviciosContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_serviciosContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridprofesional_servicios_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_251_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount15 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_15 = (short)(1) ;
            scanStart0815( ) ;
            while ( RcdFound15 != 0 )
            {
               init_level_properties15( ) ;
               getByPrimaryKey0815( ) ;
               addRow0815( ) ;
               scanNext0815( ) ;
            }
            scanEnd0815( ) ;
            nBlankRcdCount15 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0815( ) ;
         standaloneModal0815( ) ;
         sMode15 = Gx_mode ;
         while ( nGXsfl_251_idx < nRC_GXsfl_251 )
         {
            bGXsfl_251_Refreshing = true ;
            readRow0815( ) ;
            edtServiciosId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SERVICIOSID_"+sGXsfl_251_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtServiciosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServiciosId_Enabled), 5, 0), !bGXsfl_251_Refreshing);
            edtServiciosNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SERVICIOSNOMBRE_"+sGXsfl_251_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtServiciosNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServiciosNombre_Enabled), 5, 0), !bGXsfl_251_Refreshing);
            if ( ( nRcdExists_15 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0815( ) ;
            }
            sendRow0815( ) ;
            bGXsfl_251_Refreshing = false ;
         }
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount15 = (short)(5) ;
         nRcdExists_15 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0815( ) ;
            while ( RcdFound15 != 0 )
            {
               sGXsfl_251_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_251_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_25115( ) ;
               init_level_properties15( ) ;
               standaloneNotModal0815( ) ;
               getByPrimaryKey0815( ) ;
               standaloneModal0815( ) ;
               addRow0815( ) ;
               scanNext0815( ) ;
            }
            scanEnd0815( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode15 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_251_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_251_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_25115( ) ;
      initAll0815( ) ;
      init_level_properties15( ) ;
      nRcdExists_15 = (short)(0) ;
      nIsMod_15 = (short)(0) ;
      nRcdDeleted_15 = (short)(0) ;
      nBlankRcdCount15 = (short)(nBlankRcdUsr15+nBlankRcdCount15) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount15 > 0 )
      {
         A58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
         standaloneNotModal0815( ) ;
         standaloneModal0815( ) ;
         addRow0815( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtServiciosId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount15 = (short)(nBlankRcdCount15-1) ;
      }
      Gx_mode = sMode15 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridprofesional_serviciosContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridprofesional_servicios", Gridprofesional_serviciosContainer);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_serviciosContainerData", Gridprofesional_serviciosContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_serviciosContainerData"+"V", Gridprofesional_serviciosContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridprofesional_serviciosContainerData"+"V"+"\" value='"+Gridprofesional_serviciosContainer.GridValuesHidden()+"'/>") ;
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
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11082 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( "Z31ProfesionalId"), ",", ".")) ;
            Z173ProfesionalTipoDocumento = httpContext.cgiGet( "Z173ProfesionalTipoDocumento") ;
            Z174ProfesionalNroDocumento = httpContext.cgiGet( "Z174ProfesionalNroDocumento") ;
            Z85ProfesionalApellidoPaterno = httpContext.cgiGet( "Z85ProfesionalApellidoPaterno") ;
            Z86ProfesionalApellidoMaterno = httpContext.cgiGet( "Z86ProfesionalApellidoMaterno") ;
            Z84ProfesionalNombres = httpContext.cgiGet( "Z84ProfesionalNombres") ;
            Z176ProfesionalFechaNacimiento = localUtil.ctod( httpContext.cgiGet( "Z176ProfesionalFechaNacimiento"), 0) ;
            Z177ProfesionalSexo = httpContext.cgiGet( "Z177ProfesionalSexo") ;
            Z178ProfesionalDescripcion = httpContext.cgiGet( "Z178ProfesionalDescripcion") ;
            Z179ProfesionalCorreo = httpContext.cgiGet( "Z179ProfesionalCorreo") ;
            Z88ProfesionalCOP = httpContext.cgiGet( "Z88ProfesionalCOP") ;
            Z180ProfesionalColorDisponible = httpContext.cgiGet( "Z180ProfesionalColorDisponible") ;
            Z181ProfesionalColorCita = httpContext.cgiGet( "Z181ProfesionalColorCita") ;
            Z182ProfesionalTiempoCita = (byte)(localUtil.ctol( httpContext.cgiGet( "Z182ProfesionalTiempoCita"), ",", ".")) ;
            Z183ProfesionalDireccion = httpContext.cgiGet( "Z183ProfesionalDireccion") ;
            Z190ProfesionalTwitter = httpContext.cgiGet( "Z190ProfesionalTwitter") ;
            Z191ProfesionalFacebook = httpContext.cgiGet( "Z191ProfesionalFacebook") ;
            Z192ProfesionalInstagram = httpContext.cgiGet( "Z192ProfesionalInstagram") ;
            Z193ProfesionalLinkedin = httpContext.cgiGet( "Z193ProfesionalLinkedin") ;
            Z194ProfesionalTelefono = httpContext.cgiGet( "Z194ProfesionalTelefono") ;
            Z195ProfesionalFechaRegistro = localUtil.ctod( httpContext.cgiGet( "Z195ProfesionalFechaRegistro"), 0) ;
            Z196ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.cgiGet( "Z196ProfesionalTerminosCondiciones")) ;
            Z197ProfesionalEstadoCuenta = httpContext.cgiGet( "Z197ProfesionalEstadoCuenta") ;
            Z198ProfesionalEstado = httpContext.cgiGet( "Z198ProfesionalEstado") ;
            Z43PaisId = (short)(localUtil.ctol( httpContext.cgiGet( "Z43PaisId"), ",", ".")) ;
            Z44UbigeoCode = httpContext.cgiGet( "Z44UbigeoCode") ;
            Z6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( "Z6SecUserId"), ",", ".")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ",", ".")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ",", ".")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_184 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_184"), ",", ".")) ;
            nRC_GXsfl_220 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_220"), ",", ".")) ;
            nRC_GXsfl_231 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_231"), ",", ".")) ;
            nRC_GXsfl_241 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_241"), ",", ".")) ;
            nRC_GXsfl_251 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_251"), ",", ".")) ;
            N174ProfesionalNroDocumento = httpContext.cgiGet( "N174ProfesionalNroDocumento") ;
            A186UbigeoDepartamento = httpContext.cgiGet( "UBIGEODEPARTAMENTO") ;
            A187UbigeoProvincia = httpContext.cgiGet( "UBIGEOPROVINCIA") ;
            A188UbigeoDistrito = httpContext.cgiGet( "UBIGEODISTRITO") ;
            AV15ProfesionalNroDocumento = httpContext.cgiGet( "vPROFESIONALNRODOCUMENTO") ;
            AV14ProfesionalCorreo = httpContext.cgiGet( "vPROFESIONALCORREO") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), ",", ".")) ;
            A40000ProfesionalFoto_GXI = httpContext.cgiGet( "PROFESIONALFOTO_GXI") ;
            /* Read variables values. */
            A31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
            cmbProfesionalTipoDocumento.setName( cmbProfesionalTipoDocumento.getInternalname() );
            cmbProfesionalTipoDocumento.setValue( httpContext.cgiGet( cmbProfesionalTipoDocumento.getInternalname()) );
            A173ProfesionalTipoDocumento = httpContext.cgiGet( cmbProfesionalTipoDocumento.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A173ProfesionalTipoDocumento", A173ProfesionalTipoDocumento);
            A174ProfesionalNroDocumento = httpContext.cgiGet( edtProfesionalNroDocumento_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
            A85ProfesionalApellidoPaterno = httpContext.cgiGet( edtProfesionalApellidoPaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
            A86ProfesionalApellidoMaterno = httpContext.cgiGet( edtProfesionalApellidoMaterno_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
            A84ProfesionalNombres = httpContext.cgiGet( edtProfesionalNombres_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
            A175ProfesionalNombreCompleto2 = httpContext.cgiGet( edtProfesionalNombreCompleto2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A175ProfesionalNombreCompleto2", A175ProfesionalNombreCompleto2);
            if ( localUtil.vcdate( httpContext.cgiGet( edtProfesionalFechaNacimiento_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "PROFESIONALFECHANACIMIENTO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProfesionalFechaNacimiento_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A176ProfesionalFechaNacimiento", localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"));
            }
            else
            {
               A176ProfesionalFechaNacimiento = localUtil.ctod( httpContext.cgiGet( edtProfesionalFechaNacimiento_Internalname), 3) ;
               httpContext.ajax_rsp_assign_attri("", false, "A176ProfesionalFechaNacimiento", localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"));
            }
            cmbProfesionalSexo.setName( cmbProfesionalSexo.getInternalname() );
            cmbProfesionalSexo.setValue( httpContext.cgiGet( cmbProfesionalSexo.getInternalname()) );
            A177ProfesionalSexo = httpContext.cgiGet( cmbProfesionalSexo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A177ProfesionalSexo", A177ProfesionalSexo);
            A178ProfesionalDescripcion = httpContext.cgiGet( edtProfesionalDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A178ProfesionalDescripcion", A178ProfesionalDescripcion);
            A179ProfesionalCorreo = httpContext.cgiGet( edtProfesionalCorreo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A179ProfesionalCorreo", A179ProfesionalCorreo);
            A88ProfesionalCOP = httpContext.cgiGet( edtProfesionalCOP_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
            A180ProfesionalColorDisponible = httpContext.cgiGet( edtProfesionalColorDisponible_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A180ProfesionalColorDisponible", A180ProfesionalColorDisponible);
            A181ProfesionalColorCita = httpContext.cgiGet( edtProfesionalColorCita_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A181ProfesionalColorCita", A181ProfesionalColorCita);
            cmbProfesionalTiempoCita.setName( cmbProfesionalTiempoCita.getInternalname() );
            cmbProfesionalTiempoCita.setValue( httpContext.cgiGet( cmbProfesionalTiempoCita.getInternalname()) );
            A182ProfesionalTiempoCita = (byte)(GXutil.lval( httpContext.cgiGet( cmbProfesionalTiempoCita.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
            A183ProfesionalDireccion = httpContext.cgiGet( edtProfesionalDireccion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A183ProfesionalDireccion", A183ProfesionalDireccion);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAISID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaisId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A43PaisId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
            }
            else
            {
               A43PaisId = (short)(localUtil.ctol( httpContext.cgiGet( edtPaisId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
            }
            A184PaisDescripcion = httpContext.cgiGet( edtPaisDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
            A44UbigeoCode = httpContext.cgiGet( edtUbigeoCode_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
            A185UbigeoNombre = httpContext.cgiGet( edtUbigeoNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
            A189ProfesionalFoto = httpContext.cgiGet( imgProfesionalFoto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A189ProfesionalFoto", A189ProfesionalFoto);
            A190ProfesionalTwitter = httpContext.cgiGet( edtProfesionalTwitter_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A190ProfesionalTwitter", A190ProfesionalTwitter);
            A191ProfesionalFacebook = httpContext.cgiGet( edtProfesionalFacebook_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A191ProfesionalFacebook", A191ProfesionalFacebook);
            A192ProfesionalInstagram = httpContext.cgiGet( edtProfesionalInstagram_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A192ProfesionalInstagram", A192ProfesionalInstagram);
            A193ProfesionalLinkedin = httpContext.cgiGet( edtProfesionalLinkedin_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A193ProfesionalLinkedin", A193ProfesionalLinkedin);
            A194ProfesionalTelefono = httpContext.cgiGet( edtProfesionalTelefono_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A194ProfesionalTelefono", A194ProfesionalTelefono);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "SECUSERID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtSecUserId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A6SecUserId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            }
            else
            {
               A6SecUserId = (short)(localUtil.ctol( httpContext.cgiGet( edtSecUserId_Internalname), ",", ".")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtProfesionalFechaRegistro_Internalname), (byte)(3)) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "PROFESIONALFECHAREGISTRO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProfesionalFechaRegistro_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A195ProfesionalFechaRegistro = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A195ProfesionalFechaRegistro", localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"));
            }
            else
            {
               A195ProfesionalFechaRegistro = localUtil.ctod( httpContext.cgiGet( edtProfesionalFechaRegistro_Internalname), 3) ;
               httpContext.ajax_rsp_assign_attri("", false, "A195ProfesionalFechaRegistro", localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"));
            }
            A196ProfesionalTerminosCondiciones = GXutil.strtobool( httpContext.cgiGet( chkProfesionalTerminosCondiciones.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A196ProfesionalTerminosCondiciones", A196ProfesionalTerminosCondiciones);
            cmbProfesionalEstadoCuenta.setName( cmbProfesionalEstadoCuenta.getInternalname() );
            cmbProfesionalEstadoCuenta.setValue( httpContext.cgiGet( cmbProfesionalEstadoCuenta.getInternalname()) );
            A197ProfesionalEstadoCuenta = httpContext.cgiGet( cmbProfesionalEstadoCuenta.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A197ProfesionalEstadoCuenta", A197ProfesionalEstadoCuenta);
            cmbProfesionalEstado.setName( cmbProfesionalEstado.getInternalname() );
            cmbProfesionalEstado.setValue( httpContext.cgiGet( cmbProfesionalEstado.getInternalname()) );
            A198ProfesionalEstado = httpContext.cgiGet( cmbProfesionalEstado.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A189ProfesionalFoto ;
            GXv_char2[0] = A40000ProfesionalFoto_GXI ;
            httpContext.getMultimediaValue(imgProfesionalFoto_Internalname, GXv_char1, GXv_char2);
            profesional_impl.this.A189ProfesionalFoto = GXv_char1[0] ;
            profesional_impl.this.A40000ProfesionalFoto_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Profesional");
            A31ProfesionalId = (int)(localUtil.ctol( httpContext.cgiGet( edtProfesionalId_Internalname), ",", ".")) ;
            httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
            forbiddenHiddens.add("ProfesionalId", localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A31ProfesionalId != Z31ProfesionalId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("profesional:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            forbiddenHiddens2 = new com.genexus.util.GXProperties() ;
            if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
            {
               A174ProfesionalNroDocumento = httpContext.cgiGet( edtProfesionalNroDocumento_Internalname) ;
               httpContext.ajax_rsp_assign_attri("", false, "A174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
               forbiddenHiddens2.add("ProfesionalNroDocumento", GXutil.rtrim( localUtil.format( A174ProfesionalNroDocumento, "")));
            }
            if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
            {
               A174ProfesionalNroDocumento = httpContext.cgiGet( edtProfesionalNroDocumento_Internalname) ;
               httpContext.ajax_rsp_assign_attri("", false, "A174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
               forbiddenHiddens2.add("ProfesionalNroDocumento", GXutil.rtrim( localUtil.format( A174ProfesionalNroDocumento, "")));
            }
            hsh2 = httpContext.cgiGet( "hsh2") ;
            if ( ( ! ( ( A31ProfesionalId != Z31ProfesionalId ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens2.toString(), hsh2, GXKey) )
            {
               GXutil.writeLogError("profesional:[ CondSecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens2.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
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
               A31ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
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
                        e11082 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
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
            initAll089( ) ;
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
      disableAttributes089( ) ;
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

   public void confirm_0815( )
   {
      nGXsfl_251_idx = 0 ;
      while ( nGXsfl_251_idx < nRC_GXsfl_251 )
      {
         readRow0815( ) ;
         if ( ( nRcdExists_15 != 0 ) || ( nIsMod_15 != 0 ) )
         {
            getKey0815( ) ;
            if ( ( nRcdExists_15 == 0 ) && ( nRcdDeleted_15 == 0 ) )
            {
               if ( RcdFound15 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0815( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0815( ) ;
                     closeExtendedTableCursors0815( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "SERVICIOSID_" + sGXsfl_251_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtServiciosId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound15 != 0 )
               {
                  if ( nRcdDeleted_15 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0815( ) ;
                     load0815( ) ;
                     beforeValidate0815( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0815( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_15 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0815( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0815( ) ;
                           closeExtendedTableCursors0815( ) ;
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
                  if ( nRcdDeleted_15 == 0 )
                  {
                     GXCCtl = "SERVICIOSID_" + sGXsfl_251_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtServiciosId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtServiciosId_Internalname, A58ServiciosId.toString()) ;
         httpContext.changePostValue( edtServiciosNombre_Internalname, A210ServiciosNombre) ;
         httpContext.changePostValue( "ZT_"+"Z58ServiciosId_"+sGXsfl_251_idx, Z58ServiciosId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z210ServiciosNombre_"+sGXsfl_251_idx, Z210ServiciosNombre) ;
         httpContext.changePostValue( "nRcdDeleted_15_"+sGXsfl_251_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_15, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_15_"+sGXsfl_251_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_15, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_15_"+sGXsfl_251_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_15, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_15 != 0 )
         {
            httpContext.changePostValue( "SERVICIOSID_"+sGXsfl_251_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SERVICIOSNOMBRE_"+sGXsfl_251_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0814( )
   {
      nGXsfl_241_idx = 0 ;
      while ( nGXsfl_241_idx < nRC_GXsfl_241 )
      {
         readRow0814( ) ;
         if ( ( nRcdExists_14 != 0 ) || ( nIsMod_14 != 0 ) )
         {
            getKey0814( ) ;
            if ( ( nRcdExists_14 == 0 ) && ( nRcdDeleted_14 == 0 ) )
            {
               if ( RcdFound14 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0814( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0814( ) ;
                     closeExtendedTableCursors0814( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "PREMIOSID_" + sGXsfl_241_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPremiosId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound14 != 0 )
               {
                  if ( nRcdDeleted_14 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0814( ) ;
                     load0814( ) ;
                     beforeValidate0814( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0814( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_14 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0814( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0814( ) ;
                           closeExtendedTableCursors0814( ) ;
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
                  if ( nRcdDeleted_14 == 0 )
                  {
                     GXCCtl = "PREMIOSID_" + sGXsfl_241_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPremiosId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtPremiosId_Internalname, A57PremiosId.toString()) ;
         httpContext.changePostValue( edtPremiosNombre_Internalname, A207PremiosNombre) ;
         httpContext.changePostValue( edtPremiosFecha_Internalname, localUtil.format(A208PremiosFecha, "99/99/99")) ;
         httpContext.changePostValue( edtPremiosDescripcion_Internalname, A209PremiosDescripcion) ;
         httpContext.changePostValue( "ZT_"+"Z57PremiosId_"+sGXsfl_241_idx, Z57PremiosId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z207PremiosNombre_"+sGXsfl_241_idx, Z207PremiosNombre) ;
         httpContext.changePostValue( "ZT_"+"Z208PremiosFecha_"+sGXsfl_241_idx, localUtil.dtoc( Z208PremiosFecha, 0, "/")) ;
         httpContext.changePostValue( "nRcdDeleted_14_"+sGXsfl_241_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_14, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_14_"+sGXsfl_241_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_14, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_14_"+sGXsfl_241_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_14, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_14 != 0 )
         {
            httpContext.changePostValue( "PREMIOSID_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PREMIOSNOMBRE_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PREMIOSFECHA_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosFecha_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PREMIOSDESCRIPCION_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosDescripcion_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0813( )
   {
      nGXsfl_231_idx = 0 ;
      while ( nGXsfl_231_idx < nRC_GXsfl_231 )
      {
         readRow0813( ) ;
         if ( ( nRcdExists_13 != 0 ) || ( nIsMod_13 != 0 ) )
         {
            getKey0813( ) ;
            if ( ( nRcdExists_13 == 0 ) && ( nRcdDeleted_13 == 0 ) )
            {
               if ( RcdFound13 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0813( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0813( ) ;
                     closeExtendedTableCursors0813( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "EXPERIENCIALABORALID_" + sGXsfl_231_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtExperienciaLaboralId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound13 != 0 )
               {
                  if ( nRcdDeleted_13 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0813( ) ;
                     load0813( ) ;
                     beforeValidate0813( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0813( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_13 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0813( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0813( ) ;
                           closeExtendedTableCursors0813( ) ;
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
                  if ( nRcdDeleted_13 == 0 )
                  {
                     GXCCtl = "EXPERIENCIALABORALID_" + sGXsfl_231_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtExperienciaLaboralId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtExperienciaLaboralId_Internalname, A56ExperienciaLaboralId.toString()) ;
         httpContext.changePostValue( edtExperienciaLaboralEmpresaNombre_Internalname, A204ExperienciaLaboralEmpresaNombre) ;
         httpContext.changePostValue( edtExperienciaLaboralDesde_Internalname, localUtil.format(A205ExperienciaLaboralDesde, "99/99/9999")) ;
         httpContext.changePostValue( edtExperienciaLaboralHasta_Internalname, localUtil.format(A206ExperienciaLaboralHasta, "99/99/9999")) ;
         httpContext.changePostValue( "ZT_"+"Z56ExperienciaLaboralId_"+sGXsfl_231_idx, Z56ExperienciaLaboralId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z204ExperienciaLaboralEmpresaNombre_"+sGXsfl_231_idx, Z204ExperienciaLaboralEmpresaNombre) ;
         httpContext.changePostValue( "ZT_"+"Z205ExperienciaLaboralDesde_"+sGXsfl_231_idx, localUtil.dtoc( Z205ExperienciaLaboralDesde, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z206ExperienciaLaboralHasta_"+sGXsfl_231_idx, localUtil.dtoc( Z206ExperienciaLaboralHasta, 0, "/")) ;
         httpContext.changePostValue( "nRcdDeleted_13_"+sGXsfl_231_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_13, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_13_"+sGXsfl_231_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_13, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_13_"+sGXsfl_231_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_13, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_13 != 0 )
         {
            httpContext.changePostValue( "EXPERIENCIALABORALID_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralEmpresaNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EXPERIENCIALABORALDESDE_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EXPERIENCIALABORALHASTA_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0812( )
   {
      nGXsfl_220_idx = 0 ;
      while ( nGXsfl_220_idx < nRC_GXsfl_220 )
      {
         readRow0812( ) ;
         if ( ( nRcdExists_12 != 0 ) || ( nIsMod_12 != 0 ) )
         {
            getKey0812( ) ;
            if ( ( nRcdExists_12 == 0 ) && ( nRcdDeleted_12 == 0 ) )
            {
               if ( RcdFound12 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0812( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0812( ) ;
                     closeExtendedTableCursors0812( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "EDUCACIONID_" + sGXsfl_220_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEducacionId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound12 != 0 )
               {
                  if ( nRcdDeleted_12 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0812( ) ;
                     load0812( ) ;
                     beforeValidate0812( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0812( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_12 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0812( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0812( ) ;
                           closeExtendedTableCursors0812( ) ;
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
                  if ( nRcdDeleted_12 == 0 )
                  {
                     GXCCtl = "EDUCACIONID_" + sGXsfl_220_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEducacionId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtEducacionId_Internalname, A55EducacionId.toString()) ;
         httpContext.changePostValue( edtEducacionNombreInstitucion_Internalname, A200EducacionNombreInstitucion) ;
         httpContext.changePostValue( edtEducacionDesde_Internalname, localUtil.format(A201EducacionDesde, "99/99/99")) ;
         httpContext.changePostValue( edtEducacionHasta_Internalname, localUtil.format(A202EducacionHasta, "99/99/99")) ;
         httpContext.changePostValue( edtEducacionPaisDescripcion_Internalname, A203EducacionPaisDescripcion) ;
         httpContext.changePostValue( "ZT_"+"Z55EducacionId_"+sGXsfl_220_idx, Z55EducacionId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z200EducacionNombreInstitucion_"+sGXsfl_220_idx, Z200EducacionNombreInstitucion) ;
         httpContext.changePostValue( "ZT_"+"Z201EducacionDesde_"+sGXsfl_220_idx, localUtil.dtoc( Z201EducacionDesde, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z202EducacionHasta_"+sGXsfl_220_idx, localUtil.dtoc( Z202EducacionHasta, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z203EducacionPaisDescripcion_"+sGXsfl_220_idx, Z203EducacionPaisDescripcion) ;
         httpContext.changePostValue( "nRcdDeleted_12_"+sGXsfl_220_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_12, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_12_"+sGXsfl_220_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_12, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_12_"+sGXsfl_220_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_12, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_12 != 0 )
         {
            httpContext.changePostValue( "EDUCACIONID_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONNOMBREINSTITUCION_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionNombreInstitucion_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONDESDE_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONHASTA_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONPAISDESCRIPCION_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionPaisDescripcion_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0811( )
   {
      nGXsfl_209_idx = 0 ;
      while ( nGXsfl_209_idx < nRC_GXsfl_209 )
      {
         readRow0811( ) ;
         if ( ( nRcdExists_11 != 0 ) || ( nIsMod_11 != 0 ) )
         {
            getKey0811( ) ;
            if ( ( nRcdExists_11 == 0 ) && ( nRcdDeleted_11 == 0 ) )
            {
               if ( RcdFound11 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0811( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0811( ) ;
                     closeExtendedTableCursors0811( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEspecialidadId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound11 != 0 )
               {
                  if ( nRcdDeleted_11 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0811( ) ;
                     load0811( ) ;
                     beforeValidate0811( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0811( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_11 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0811( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0811( ) ;
                           closeExtendedTableCursors0811( ) ;
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
                  if ( nRcdDeleted_11 == 0 )
                  {
                     GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEspecialidadId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( cmbSedeTipoConsulta.getInternalname(), GXutil.rtrim( A54SedeTipoConsulta)) ;
         httpContext.changePostValue( edtSedeNombre_Internalname, A75SedeNombre) ;
         httpContext.changePostValue( edtClinicaNombreAbreviado_Internalname, A80ClinicaNombreAbreviado) ;
         httpContext.changePostValue( edtCostoConsulta_Internalname, GXutil.ltrim( localUtil.ntoc( A199CostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z30SedeId_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( Z30SedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z54SedeTipoConsulta_"+sGXsfl_209_idx, GXutil.rtrim( Z54SedeTipoConsulta)) ;
         httpContext.changePostValue( "ZT_"+"Z199CostoConsulta_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( Z199CostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_11_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_11, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_11_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_11, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_11_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_11, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_11 != 0 )
         {
            httpContext.changePostValue( "SEDEID_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SEDETIPOCONSULTA_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbSedeTipoConsulta.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SEDENOMBRE_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CLINICANOMBREABREVIADO_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtClinicaNombreAbreviado_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COSTOCONSULTA_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_0810( )
   {
      nGXsfl_184_idx = 0 ;
      while ( nGXsfl_184_idx < nRC_GXsfl_184 )
      {
         readRow0810( ) ;
         if ( ( nRcdExists_10 != 0 ) || ( nIsMod_10 != 0 ) )
         {
            getKey0810( ) ;
            if ( ( nRcdExists_10 == 0 ) && ( nRcdDeleted_10 == 0 ) )
            {
               if ( RcdFound10 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0810( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0810( ) ;
                     closeExtendedTableCursors0810( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Save parent mode. */
                        sMode10 = Gx_mode ;
                        confirm_0811( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Restore parent mode. */
                           Gx_mode = sMode10 ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                           IsConfirmed = (short)(1) ;
                           httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                        }
                        /* Restore parent mode. */
                        Gx_mode = sMode10 ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     }
                  }
               }
               else
               {
                  GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtEspecialidadId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound10 != 0 )
               {
                  if ( nRcdDeleted_10 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0810( ) ;
                     load0810( ) ;
                     beforeValidate0810( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0810( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_10 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0810( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0810( ) ;
                           closeExtendedTableCursors0810( ) ;
                           if ( AnyError == 0 )
                           {
                              /* Save parent mode. */
                              sMode10 = Gx_mode ;
                              confirm_0811( ) ;
                              if ( AnyError == 0 )
                              {
                                 /* Restore parent mode. */
                                 Gx_mode = sMode10 ;
                                 httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                                 IsConfirmed = (short)(1) ;
                                 httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                              }
                              /* Restore parent mode. */
                              Gx_mode = sMode10 ;
                              httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_10 == 0 )
                  {
                     GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEspecialidadId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtEspecialidadCodigo_Internalname, A140EspecialidadCodigo) ;
         httpContext.changePostValue( edtEspecialidadNombre_Internalname, A71EspecialidadNombre) ;
         httpContext.changePostValue( "ZT_"+"Z32EspecialidadId_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( Z32EspecialidadId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRC_GXsfl_209_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_209, (byte)(8), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_10_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_10_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_10_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_10 != 0 )
         {
            httpContext.changePostValue( "ESPECIALIDADID_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESPECIALIDADCODIGO_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadCodigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESPECIALIDADNOMBRE_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption080( )
   {
   }

   public void e11082( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void zm089( int GX_JID )
   {
      if ( ( GX_JID == 43 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z173ProfesionalTipoDocumento = T000818_A173ProfesionalTipoDocumento[0] ;
            Z174ProfesionalNroDocumento = T000818_A174ProfesionalNroDocumento[0] ;
            Z85ProfesionalApellidoPaterno = T000818_A85ProfesionalApellidoPaterno[0] ;
            Z86ProfesionalApellidoMaterno = T000818_A86ProfesionalApellidoMaterno[0] ;
            Z84ProfesionalNombres = T000818_A84ProfesionalNombres[0] ;
            Z176ProfesionalFechaNacimiento = T000818_A176ProfesionalFechaNacimiento[0] ;
            Z177ProfesionalSexo = T000818_A177ProfesionalSexo[0] ;
            Z178ProfesionalDescripcion = T000818_A178ProfesionalDescripcion[0] ;
            Z179ProfesionalCorreo = T000818_A179ProfesionalCorreo[0] ;
            Z88ProfesionalCOP = T000818_A88ProfesionalCOP[0] ;
            Z180ProfesionalColorDisponible = T000818_A180ProfesionalColorDisponible[0] ;
            Z181ProfesionalColorCita = T000818_A181ProfesionalColorCita[0] ;
            Z182ProfesionalTiempoCita = T000818_A182ProfesionalTiempoCita[0] ;
            Z183ProfesionalDireccion = T000818_A183ProfesionalDireccion[0] ;
            Z190ProfesionalTwitter = T000818_A190ProfesionalTwitter[0] ;
            Z191ProfesionalFacebook = T000818_A191ProfesionalFacebook[0] ;
            Z192ProfesionalInstagram = T000818_A192ProfesionalInstagram[0] ;
            Z193ProfesionalLinkedin = T000818_A193ProfesionalLinkedin[0] ;
            Z194ProfesionalTelefono = T000818_A194ProfesionalTelefono[0] ;
            Z195ProfesionalFechaRegistro = T000818_A195ProfesionalFechaRegistro[0] ;
            Z196ProfesionalTerminosCondiciones = T000818_A196ProfesionalTerminosCondiciones[0] ;
            Z197ProfesionalEstadoCuenta = T000818_A197ProfesionalEstadoCuenta[0] ;
            Z198ProfesionalEstado = T000818_A198ProfesionalEstado[0] ;
            Z43PaisId = T000818_A43PaisId[0] ;
            Z44UbigeoCode = T000818_A44UbigeoCode[0] ;
            Z6SecUserId = T000818_A6SecUserId[0] ;
         }
         else
         {
            Z173ProfesionalTipoDocumento = A173ProfesionalTipoDocumento ;
            Z174ProfesionalNroDocumento = A174ProfesionalNroDocumento ;
            Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
            Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
            Z84ProfesionalNombres = A84ProfesionalNombres ;
            Z176ProfesionalFechaNacimiento = A176ProfesionalFechaNacimiento ;
            Z177ProfesionalSexo = A177ProfesionalSexo ;
            Z178ProfesionalDescripcion = A178ProfesionalDescripcion ;
            Z179ProfesionalCorreo = A179ProfesionalCorreo ;
            Z88ProfesionalCOP = A88ProfesionalCOP ;
            Z180ProfesionalColorDisponible = A180ProfesionalColorDisponible ;
            Z181ProfesionalColorCita = A181ProfesionalColorCita ;
            Z182ProfesionalTiempoCita = A182ProfesionalTiempoCita ;
            Z183ProfesionalDireccion = A183ProfesionalDireccion ;
            Z190ProfesionalTwitter = A190ProfesionalTwitter ;
            Z191ProfesionalFacebook = A191ProfesionalFacebook ;
            Z192ProfesionalInstagram = A192ProfesionalInstagram ;
            Z193ProfesionalLinkedin = A193ProfesionalLinkedin ;
            Z194ProfesionalTelefono = A194ProfesionalTelefono ;
            Z195ProfesionalFechaRegistro = A195ProfesionalFechaRegistro ;
            Z196ProfesionalTerminosCondiciones = A196ProfesionalTerminosCondiciones ;
            Z197ProfesionalEstadoCuenta = A197ProfesionalEstadoCuenta ;
            Z198ProfesionalEstado = A198ProfesionalEstado ;
            Z43PaisId = A43PaisId ;
            Z44UbigeoCode = A44UbigeoCode ;
            Z6SecUserId = A6SecUserId ;
         }
      }
      if ( GX_JID == -43 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z173ProfesionalTipoDocumento = A173ProfesionalTipoDocumento ;
         Z174ProfesionalNroDocumento = A174ProfesionalNroDocumento ;
         Z85ProfesionalApellidoPaterno = A85ProfesionalApellidoPaterno ;
         Z86ProfesionalApellidoMaterno = A86ProfesionalApellidoMaterno ;
         Z84ProfesionalNombres = A84ProfesionalNombres ;
         Z176ProfesionalFechaNacimiento = A176ProfesionalFechaNacimiento ;
         Z177ProfesionalSexo = A177ProfesionalSexo ;
         Z178ProfesionalDescripcion = A178ProfesionalDescripcion ;
         Z179ProfesionalCorreo = A179ProfesionalCorreo ;
         Z88ProfesionalCOP = A88ProfesionalCOP ;
         Z180ProfesionalColorDisponible = A180ProfesionalColorDisponible ;
         Z181ProfesionalColorCita = A181ProfesionalColorCita ;
         Z182ProfesionalTiempoCita = A182ProfesionalTiempoCita ;
         Z183ProfesionalDireccion = A183ProfesionalDireccion ;
         Z189ProfesionalFoto = A189ProfesionalFoto ;
         Z40000ProfesionalFoto_GXI = A40000ProfesionalFoto_GXI ;
         Z190ProfesionalTwitter = A190ProfesionalTwitter ;
         Z191ProfesionalFacebook = A191ProfesionalFacebook ;
         Z192ProfesionalInstagram = A192ProfesionalInstagram ;
         Z193ProfesionalLinkedin = A193ProfesionalLinkedin ;
         Z194ProfesionalTelefono = A194ProfesionalTelefono ;
         Z195ProfesionalFechaRegistro = A195ProfesionalFechaRegistro ;
         Z196ProfesionalTerminosCondiciones = A196ProfesionalTerminosCondiciones ;
         Z197ProfesionalEstadoCuenta = A197ProfesionalEstadoCuenta ;
         Z198ProfesionalEstado = A198ProfesionalEstado ;
         Z43PaisId = A43PaisId ;
         Z44UbigeoCode = A44UbigeoCode ;
         Z6SecUserId = A6SecUserId ;
         Z184PaisDescripcion = A184PaisDescripcion ;
         Z186UbigeoDepartamento = A186UbigeoDepartamento ;
         Z187UbigeoProvincia = A187UbigeoProvincia ;
         Z188UbigeoDistrito = A188UbigeoDistrito ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         edtProfesionalNroDocumento_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNroDocumento_Enabled), 5, 0), true);
      }
      else
      {
         edtProfesionalNroDocumento_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNroDocumento_Enabled), 5, 0), true);
      }
      edtProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      edtProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (0==A182ProfesionalTiempoCita) && ( Gx_BScreen == 0 ) )
      {
         A182ProfesionalTiempoCita = (byte)(30) ;
         httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
      }
      if ( isIns( )  && (GXutil.strcmp("", A180ProfesionalColorDisponible)==0) && ( Gx_BScreen == 0 ) )
      {
         A180ProfesionalColorDisponible = "#8CE1B3" ;
         httpContext.ajax_rsp_assign_attri("", false, "A180ProfesionalColorDisponible", A180ProfesionalColorDisponible);
      }
      if ( isIns( )  && (GXutil.strcmp("", A181ProfesionalColorCita)==0) && ( Gx_BScreen == 0 ) )
      {
         A181ProfesionalColorCita = "#376A4A" ;
         httpContext.ajax_rsp_assign_attri("", false, "A181ProfesionalColorCita", A181ProfesionalColorCita);
      }
      if ( isIns( )  && (GXutil.strcmp("", A198ProfesionalEstado)==0) && ( Gx_BScreen == 0 ) )
      {
         A198ProfesionalEstado = "A" ;
         httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
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

   public void load089( )
   {
      /* Using cursor T000822 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A173ProfesionalTipoDocumento = T000822_A173ProfesionalTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A173ProfesionalTipoDocumento", A173ProfesionalTipoDocumento);
         A174ProfesionalNroDocumento = T000822_A174ProfesionalNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
         A85ProfesionalApellidoPaterno = T000822_A85ProfesionalApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
         A86ProfesionalApellidoMaterno = T000822_A86ProfesionalApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
         A84ProfesionalNombres = T000822_A84ProfesionalNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
         A176ProfesionalFechaNacimiento = T000822_A176ProfesionalFechaNacimiento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A176ProfesionalFechaNacimiento", localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"));
         A177ProfesionalSexo = T000822_A177ProfesionalSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A177ProfesionalSexo", A177ProfesionalSexo);
         A178ProfesionalDescripcion = T000822_A178ProfesionalDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A178ProfesionalDescripcion", A178ProfesionalDescripcion);
         A179ProfesionalCorreo = T000822_A179ProfesionalCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A179ProfesionalCorreo", A179ProfesionalCorreo);
         A88ProfesionalCOP = T000822_A88ProfesionalCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
         A180ProfesionalColorDisponible = T000822_A180ProfesionalColorDisponible[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A180ProfesionalColorDisponible", A180ProfesionalColorDisponible);
         A181ProfesionalColorCita = T000822_A181ProfesionalColorCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181ProfesionalColorCita", A181ProfesionalColorCita);
         A182ProfesionalTiempoCita = T000822_A182ProfesionalTiempoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
         A183ProfesionalDireccion = T000822_A183ProfesionalDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A183ProfesionalDireccion", A183ProfesionalDireccion);
         A184PaisDescripcion = T000822_A184PaisDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
         A189ProfesionalFoto = T000822_A189ProfesionalFoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A189ProfesionalFoto", A189ProfesionalFoto);
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
         A40000ProfesionalFoto_GXI = T000822_A40000ProfesionalFoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
         A190ProfesionalTwitter = T000822_A190ProfesionalTwitter[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A190ProfesionalTwitter", A190ProfesionalTwitter);
         A191ProfesionalFacebook = T000822_A191ProfesionalFacebook[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A191ProfesionalFacebook", A191ProfesionalFacebook);
         A192ProfesionalInstagram = T000822_A192ProfesionalInstagram[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A192ProfesionalInstagram", A192ProfesionalInstagram);
         A193ProfesionalLinkedin = T000822_A193ProfesionalLinkedin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A193ProfesionalLinkedin", A193ProfesionalLinkedin);
         A194ProfesionalTelefono = T000822_A194ProfesionalTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A194ProfesionalTelefono", A194ProfesionalTelefono);
         A195ProfesionalFechaRegistro = T000822_A195ProfesionalFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A195ProfesionalFechaRegistro", localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"));
         A196ProfesionalTerminosCondiciones = T000822_A196ProfesionalTerminosCondiciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A196ProfesionalTerminosCondiciones", A196ProfesionalTerminosCondiciones);
         A197ProfesionalEstadoCuenta = T000822_A197ProfesionalEstadoCuenta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A197ProfesionalEstadoCuenta", A197ProfesionalEstadoCuenta);
         A198ProfesionalEstado = T000822_A198ProfesionalEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
         A186UbigeoDepartamento = T000822_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T000822_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T000822_A188UbigeoDistrito[0] ;
         A43PaisId = T000822_A43PaisId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
         A44UbigeoCode = T000822_A44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         A6SecUserId = T000822_A6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         zm089( -43) ;
      }
      pr_default.close(20);
      onLoadActions089( ) ;
   }

   public void onLoadActions089( )
   {
      A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
      httpContext.ajax_rsp_assign_attri("", false, "A175ProfesionalNombreCompleto2", A175ProfesionalNombreCompleto2);
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
   }

   public void checkExtendedTable089( )
   {
      nIsDirty_9 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      if ( ! ( ( GXutil.strcmp(A173ProfesionalTipoDocumento, "1") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "6") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "2") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "4") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "7") == 0 ) || ( GXutil.strcmp(A173ProfesionalTipoDocumento, "0") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Tipo Documento fuera de rango", "OutOfRange", 1, "PROFESIONALTIPODOCUMENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( new com.projectthani.prcvalidarexisteprofesional(remoteHandle, context).executeUdp( GXutil.trim( A174ProfesionalNroDocumento)) && isIns( )  )
      {
         httpContext.GX_msglist.addItem("Ya existe un profesional con el nro de documento ingresado", 1, "PROFESIONALNRODOCUMENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalNroDocumento_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_9 = (short)(1) ;
      A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
      httpContext.ajax_rsp_assign_attri("", false, "A175ProfesionalNombreCompleto2", A175ProfesionalNombreCompleto2);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A176ProfesionalFechaNacimiento)) || (( GXutil.resetTime(A176ProfesionalFechaNacimiento).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A176ProfesionalFechaNacimiento), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha Nacimiento fuera de rango", "OutOfRange", 1, "PROFESIONALFECHANACIMIENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalFechaNacimiento_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_dtime3 = GXutil.resetTime( A176ProfesionalFechaNacimiento );
      if ( GXutil.age( GXt_dtime3, GXutil.now( )) < 18 )
      {
         httpContext.GX_msglist.addItem("La edad del profesional debe ser mayor a 18 años", 1, "PROFESIONALFECHANACIMIENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalFechaNacimiento_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A177ProfesionalSexo, "M") == 0 ) || ( GXutil.strcmp(A177ProfesionalSexo, "F") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Sexo fuera de rango", "OutOfRange", 1, "PROFESIONALSEXO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbProfesionalSexo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A179ProfesionalCorreo,"^((\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)|(\\s*))$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Correo no coincide con el patrón especificado", "OutOfRange", 1, "PROFESIONALCORREO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalCorreo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( A182ProfesionalTiempoCita == 30 ) || ( A182ProfesionalTiempoCita == 60 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Tiempo Cita fuera de rango", "OutOfRange", 1, "PROFESIONALTIEMPOCITA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbProfesionalTiempoCita.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000819 */
      pr_default.execute(17, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaisId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A184PaisDescripcion = T000819_A184PaisDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
      pr_default.close(17);
      /* Using cursor T000820 */
      pr_default.execute(18, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A186UbigeoDepartamento = T000820_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000820_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000820_A188UbigeoDistrito[0] ;
      pr_default.close(18);
      nIsDirty_9 = (short)(1) ;
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      if ( ! ( GxRegex.IsMatch(A190ProfesionalTwitter,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Twitter no coincide con el patrón especificado", "OutOfRange", 1, "PROFESIONALTWITTER");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalTwitter_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A191ProfesionalFacebook,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Facebook no coincide con el patrón especificado", "OutOfRange", 1, "PROFESIONALFACEBOOK");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalFacebook_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A192ProfesionalInstagram,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Instagram no coincide con el patrón especificado", "OutOfRange", 1, "PROFESIONALINSTAGRAM");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalInstagram_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A193ProfesionalLinkedin,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") ) )
      {
         httpContext.GX_msglist.addItem("El valor de Profesional Linkedin no coincide con el patrón especificado", "OutOfRange", 1, "PROFESIONALLINKEDIN");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalLinkedin_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000821 */
      pr_default.execute(19, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(19);
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A195ProfesionalFechaRegistro)) || (( GXutil.resetTime(A195ProfesionalFechaRegistro).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A195ProfesionalFechaRegistro), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Fecha Registro fuera de rango", "OutOfRange", 1, "PROFESIONALFECHAREGISTRO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalFechaRegistro_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A197ProfesionalEstadoCuenta, "CV") == 0 ) || ( GXutil.strcmp(A197ProfesionalEstadoCuenta, "CP") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Estado Cuenta fuera de rango", "OutOfRange", 1, "PROFESIONALESTADOCUENTA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbProfesionalEstadoCuenta.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A198ProfesionalEstado, "A") == 0 ) || ( GXutil.strcmp(A198ProfesionalEstado, "P") == 0 ) || ( GXutil.strcmp(A198ProfesionalEstado, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem("Campo Profesional Estado fuera de rango", "OutOfRange", 1, "PROFESIONALESTADO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbProfesionalEstado.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors089( )
   {
      pr_default.close(17);
      pr_default.close(18);
      pr_default.close(19);
   }

   public void enableDisable( )
   {
   }

   public void gxload_44( short A43PaisId )
   {
      /* Using cursor T000823 */
      pr_default.execute(21, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(21) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaisId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A184PaisDescripcion = T000823_A184PaisDescripcion[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A184PaisDescripcion)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(21) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(21);
   }

   public void gxload_45( String A44UbigeoCode )
   {
      /* Using cursor T000824 */
      pr_default.execute(22, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A186UbigeoDepartamento = T000824_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000824_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000824_A188UbigeoDistrito[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A186UbigeoDepartamento)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A187UbigeoProvincia)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A188UbigeoDistrito)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(22) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(22);
   }

   public void gxload_46( short A6SecUserId )
   {
      /* Using cursor T000825 */
      pr_default.execute(23, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(23) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(23) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(23);
   }

   public void getKey089( )
   {
      /* Using cursor T000826 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound9 = (short)(1) ;
      }
      else
      {
         RcdFound9 = (short)(0) ;
      }
      pr_default.close(24);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000818 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         zm089( 43) ;
         RcdFound9 = (short)(1) ;
         A31ProfesionalId = T000818_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         A173ProfesionalTipoDocumento = T000818_A173ProfesionalTipoDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A173ProfesionalTipoDocumento", A173ProfesionalTipoDocumento);
         A174ProfesionalNroDocumento = T000818_A174ProfesionalNroDocumento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
         A85ProfesionalApellidoPaterno = T000818_A85ProfesionalApellidoPaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
         A86ProfesionalApellidoMaterno = T000818_A86ProfesionalApellidoMaterno[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
         A84ProfesionalNombres = T000818_A84ProfesionalNombres[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
         A176ProfesionalFechaNacimiento = T000818_A176ProfesionalFechaNacimiento[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A176ProfesionalFechaNacimiento", localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"));
         A177ProfesionalSexo = T000818_A177ProfesionalSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A177ProfesionalSexo", A177ProfesionalSexo);
         A178ProfesionalDescripcion = T000818_A178ProfesionalDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A178ProfesionalDescripcion", A178ProfesionalDescripcion);
         A179ProfesionalCorreo = T000818_A179ProfesionalCorreo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A179ProfesionalCorreo", A179ProfesionalCorreo);
         A88ProfesionalCOP = T000818_A88ProfesionalCOP[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
         A180ProfesionalColorDisponible = T000818_A180ProfesionalColorDisponible[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A180ProfesionalColorDisponible", A180ProfesionalColorDisponible);
         A181ProfesionalColorCita = T000818_A181ProfesionalColorCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A181ProfesionalColorCita", A181ProfesionalColorCita);
         A182ProfesionalTiempoCita = T000818_A182ProfesionalTiempoCita[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
         A183ProfesionalDireccion = T000818_A183ProfesionalDireccion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A183ProfesionalDireccion", A183ProfesionalDireccion);
         A189ProfesionalFoto = T000818_A189ProfesionalFoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A189ProfesionalFoto", A189ProfesionalFoto);
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
         A40000ProfesionalFoto_GXI = T000818_A40000ProfesionalFoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
         A190ProfesionalTwitter = T000818_A190ProfesionalTwitter[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A190ProfesionalTwitter", A190ProfesionalTwitter);
         A191ProfesionalFacebook = T000818_A191ProfesionalFacebook[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A191ProfesionalFacebook", A191ProfesionalFacebook);
         A192ProfesionalInstagram = T000818_A192ProfesionalInstagram[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A192ProfesionalInstagram", A192ProfesionalInstagram);
         A193ProfesionalLinkedin = T000818_A193ProfesionalLinkedin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A193ProfesionalLinkedin", A193ProfesionalLinkedin);
         A194ProfesionalTelefono = T000818_A194ProfesionalTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A194ProfesionalTelefono", A194ProfesionalTelefono);
         A195ProfesionalFechaRegistro = T000818_A195ProfesionalFechaRegistro[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A195ProfesionalFechaRegistro", localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"));
         A196ProfesionalTerminosCondiciones = T000818_A196ProfesionalTerminosCondiciones[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A196ProfesionalTerminosCondiciones", A196ProfesionalTerminosCondiciones);
         A197ProfesionalEstadoCuenta = T000818_A197ProfesionalEstadoCuenta[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A197ProfesionalEstadoCuenta", A197ProfesionalEstadoCuenta);
         A198ProfesionalEstado = T000818_A198ProfesionalEstado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
         A43PaisId = T000818_A43PaisId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
         A44UbigeoCode = T000818_A44UbigeoCode[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
         A6SecUserId = T000818_A6SecUserId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
         Z31ProfesionalId = A31ProfesionalId ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load089( ) ;
         if ( AnyError == 1 )
         {
            RcdFound9 = (short)(0) ;
            initializeNonKey089( ) ;
         }
         Gx_mode = sMode9 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound9 = (short)(0) ;
         initializeNonKey089( ) ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode9 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(16);
   }

   public void getEqualNoModal( )
   {
      getKey089( ) ;
      if ( RcdFound9 == 0 )
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
      RcdFound9 = (short)(0) ;
      /* Using cursor T000827 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(25) != 101) )
      {
         while ( (pr_default.getStatus(25) != 101) && ( ( T000827_A31ProfesionalId[0] < A31ProfesionalId ) ) )
         {
            pr_default.readNext(25);
         }
         if ( (pr_default.getStatus(25) != 101) && ( ( T000827_A31ProfesionalId[0] > A31ProfesionalId ) ) )
         {
            A31ProfesionalId = T000827_A31ProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
            RcdFound9 = (short)(1) ;
         }
      }
      pr_default.close(25);
   }

   public void move_previous( )
   {
      RcdFound9 = (short)(0) ;
      /* Using cursor T000828 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A31ProfesionalId)});
      if ( (pr_default.getStatus(26) != 101) )
      {
         while ( (pr_default.getStatus(26) != 101) && ( ( T000828_A31ProfesionalId[0] > A31ProfesionalId ) ) )
         {
            pr_default.readNext(26);
         }
         if ( (pr_default.getStatus(26) != 101) && ( ( T000828_A31ProfesionalId[0] < A31ProfesionalId ) ) )
         {
            A31ProfesionalId = T000828_A31ProfesionalId[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
            RcdFound9 = (short)(1) ;
         }
      }
      pr_default.close(26);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey089( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert089( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound9 == 1 )
         {
            if ( A31ProfesionalId != Z31ProfesionalId )
            {
               A31ProfesionalId = Z31ProfesionalId ;
               httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PROFESIONALID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtProfesionalId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update089( ) ;
               GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A31ProfesionalId != Z31ProfesionalId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert089( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PROFESIONALID");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtProfesionalId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert089( ) ;
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
      if ( A31ProfesionalId != Z31ProfesionalId )
      {
         A31ProfesionalId = Z31ProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
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
      if ( RcdFound9 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "PROFESIONALID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart089( ) ;
      if ( RcdFound9 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd089( ) ;
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
      if ( RcdFound9 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
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
      if ( RcdFound9 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
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
      scanStart089( ) ;
      if ( RcdFound9 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound9 != 0 )
         {
            scanNext089( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd089( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency089( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000817 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(15) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Profesional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(15) == 101) || ( GXutil.strcmp(Z173ProfesionalTipoDocumento, T000817_A173ProfesionalTipoDocumento[0]) != 0 ) || ( GXutil.strcmp(Z174ProfesionalNroDocumento, T000817_A174ProfesionalNroDocumento[0]) != 0 ) || ( GXutil.strcmp(Z85ProfesionalApellidoPaterno, T000817_A85ProfesionalApellidoPaterno[0]) != 0 ) || ( GXutil.strcmp(Z86ProfesionalApellidoMaterno, T000817_A86ProfesionalApellidoMaterno[0]) != 0 ) || ( GXutil.strcmp(Z84ProfesionalNombres, T000817_A84ProfesionalNombres[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z176ProfesionalFechaNacimiento), GXutil.resetTime(T000817_A176ProfesionalFechaNacimiento[0])) ) || ( GXutil.strcmp(Z177ProfesionalSexo, T000817_A177ProfesionalSexo[0]) != 0 ) || ( GXutil.strcmp(Z178ProfesionalDescripcion, T000817_A178ProfesionalDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z179ProfesionalCorreo, T000817_A179ProfesionalCorreo[0]) != 0 ) || ( GXutil.strcmp(Z88ProfesionalCOP, T000817_A88ProfesionalCOP[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z180ProfesionalColorDisponible, T000817_A180ProfesionalColorDisponible[0]) != 0 ) || ( GXutil.strcmp(Z181ProfesionalColorCita, T000817_A181ProfesionalColorCita[0]) != 0 ) || ( Z182ProfesionalTiempoCita != T000817_A182ProfesionalTiempoCita[0] ) || ( GXutil.strcmp(Z183ProfesionalDireccion, T000817_A183ProfesionalDireccion[0]) != 0 ) || ( GXutil.strcmp(Z190ProfesionalTwitter, T000817_A190ProfesionalTwitter[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z191ProfesionalFacebook, T000817_A191ProfesionalFacebook[0]) != 0 ) || ( GXutil.strcmp(Z192ProfesionalInstagram, T000817_A192ProfesionalInstagram[0]) != 0 ) || ( GXutil.strcmp(Z193ProfesionalLinkedin, T000817_A193ProfesionalLinkedin[0]) != 0 ) || ( GXutil.strcmp(Z194ProfesionalTelefono, T000817_A194ProfesionalTelefono[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z195ProfesionalFechaRegistro), GXutil.resetTime(T000817_A195ProfesionalFechaRegistro[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z196ProfesionalTerminosCondiciones != T000817_A196ProfesionalTerminosCondiciones[0] ) || ( GXutil.strcmp(Z197ProfesionalEstadoCuenta, T000817_A197ProfesionalEstadoCuenta[0]) != 0 ) || ( GXutil.strcmp(Z198ProfesionalEstado, T000817_A198ProfesionalEstado[0]) != 0 ) || ( Z43PaisId != T000817_A43PaisId[0] ) || ( GXutil.strcmp(Z44UbigeoCode, T000817_A44UbigeoCode[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z6SecUserId != T000817_A6SecUserId[0] ) )
         {
            if ( GXutil.strcmp(Z173ProfesionalTipoDocumento, T000817_A173ProfesionalTipoDocumento[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalTipoDocumento");
               GXutil.writeLogRaw("Old: ",Z173ProfesionalTipoDocumento);
               GXutil.writeLogRaw("Current: ",T000817_A173ProfesionalTipoDocumento[0]);
            }
            if ( GXutil.strcmp(Z174ProfesionalNroDocumento, T000817_A174ProfesionalNroDocumento[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalNroDocumento");
               GXutil.writeLogRaw("Old: ",Z174ProfesionalNroDocumento);
               GXutil.writeLogRaw("Current: ",T000817_A174ProfesionalNroDocumento[0]);
            }
            if ( GXutil.strcmp(Z85ProfesionalApellidoPaterno, T000817_A85ProfesionalApellidoPaterno[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalApellidoPaterno");
               GXutil.writeLogRaw("Old: ",Z85ProfesionalApellidoPaterno);
               GXutil.writeLogRaw("Current: ",T000817_A85ProfesionalApellidoPaterno[0]);
            }
            if ( GXutil.strcmp(Z86ProfesionalApellidoMaterno, T000817_A86ProfesionalApellidoMaterno[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalApellidoMaterno");
               GXutil.writeLogRaw("Old: ",Z86ProfesionalApellidoMaterno);
               GXutil.writeLogRaw("Current: ",T000817_A86ProfesionalApellidoMaterno[0]);
            }
            if ( GXutil.strcmp(Z84ProfesionalNombres, T000817_A84ProfesionalNombres[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalNombres");
               GXutil.writeLogRaw("Old: ",Z84ProfesionalNombres);
               GXutil.writeLogRaw("Current: ",T000817_A84ProfesionalNombres[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z176ProfesionalFechaNacimiento), GXutil.resetTime(T000817_A176ProfesionalFechaNacimiento[0])) ) )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalFechaNacimiento");
               GXutil.writeLogRaw("Old: ",Z176ProfesionalFechaNacimiento);
               GXutil.writeLogRaw("Current: ",T000817_A176ProfesionalFechaNacimiento[0]);
            }
            if ( GXutil.strcmp(Z177ProfesionalSexo, T000817_A177ProfesionalSexo[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalSexo");
               GXutil.writeLogRaw("Old: ",Z177ProfesionalSexo);
               GXutil.writeLogRaw("Current: ",T000817_A177ProfesionalSexo[0]);
            }
            if ( GXutil.strcmp(Z178ProfesionalDescripcion, T000817_A178ProfesionalDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalDescripcion");
               GXutil.writeLogRaw("Old: ",Z178ProfesionalDescripcion);
               GXutil.writeLogRaw("Current: ",T000817_A178ProfesionalDescripcion[0]);
            }
            if ( GXutil.strcmp(Z179ProfesionalCorreo, T000817_A179ProfesionalCorreo[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalCorreo");
               GXutil.writeLogRaw("Old: ",Z179ProfesionalCorreo);
               GXutil.writeLogRaw("Current: ",T000817_A179ProfesionalCorreo[0]);
            }
            if ( GXutil.strcmp(Z88ProfesionalCOP, T000817_A88ProfesionalCOP[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalCOP");
               GXutil.writeLogRaw("Old: ",Z88ProfesionalCOP);
               GXutil.writeLogRaw("Current: ",T000817_A88ProfesionalCOP[0]);
            }
            if ( GXutil.strcmp(Z180ProfesionalColorDisponible, T000817_A180ProfesionalColorDisponible[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalColorDisponible");
               GXutil.writeLogRaw("Old: ",Z180ProfesionalColorDisponible);
               GXutil.writeLogRaw("Current: ",T000817_A180ProfesionalColorDisponible[0]);
            }
            if ( GXutil.strcmp(Z181ProfesionalColorCita, T000817_A181ProfesionalColorCita[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalColorCita");
               GXutil.writeLogRaw("Old: ",Z181ProfesionalColorCita);
               GXutil.writeLogRaw("Current: ",T000817_A181ProfesionalColorCita[0]);
            }
            if ( Z182ProfesionalTiempoCita != T000817_A182ProfesionalTiempoCita[0] )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalTiempoCita");
               GXutil.writeLogRaw("Old: ",Z182ProfesionalTiempoCita);
               GXutil.writeLogRaw("Current: ",T000817_A182ProfesionalTiempoCita[0]);
            }
            if ( GXutil.strcmp(Z183ProfesionalDireccion, T000817_A183ProfesionalDireccion[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalDireccion");
               GXutil.writeLogRaw("Old: ",Z183ProfesionalDireccion);
               GXutil.writeLogRaw("Current: ",T000817_A183ProfesionalDireccion[0]);
            }
            if ( GXutil.strcmp(Z190ProfesionalTwitter, T000817_A190ProfesionalTwitter[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalTwitter");
               GXutil.writeLogRaw("Old: ",Z190ProfesionalTwitter);
               GXutil.writeLogRaw("Current: ",T000817_A190ProfesionalTwitter[0]);
            }
            if ( GXutil.strcmp(Z191ProfesionalFacebook, T000817_A191ProfesionalFacebook[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalFacebook");
               GXutil.writeLogRaw("Old: ",Z191ProfesionalFacebook);
               GXutil.writeLogRaw("Current: ",T000817_A191ProfesionalFacebook[0]);
            }
            if ( GXutil.strcmp(Z192ProfesionalInstagram, T000817_A192ProfesionalInstagram[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalInstagram");
               GXutil.writeLogRaw("Old: ",Z192ProfesionalInstagram);
               GXutil.writeLogRaw("Current: ",T000817_A192ProfesionalInstagram[0]);
            }
            if ( GXutil.strcmp(Z193ProfesionalLinkedin, T000817_A193ProfesionalLinkedin[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalLinkedin");
               GXutil.writeLogRaw("Old: ",Z193ProfesionalLinkedin);
               GXutil.writeLogRaw("Current: ",T000817_A193ProfesionalLinkedin[0]);
            }
            if ( GXutil.strcmp(Z194ProfesionalTelefono, T000817_A194ProfesionalTelefono[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalTelefono");
               GXutil.writeLogRaw("Old: ",Z194ProfesionalTelefono);
               GXutil.writeLogRaw("Current: ",T000817_A194ProfesionalTelefono[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z195ProfesionalFechaRegistro), GXutil.resetTime(T000817_A195ProfesionalFechaRegistro[0])) ) )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalFechaRegistro");
               GXutil.writeLogRaw("Old: ",Z195ProfesionalFechaRegistro);
               GXutil.writeLogRaw("Current: ",T000817_A195ProfesionalFechaRegistro[0]);
            }
            if ( Z196ProfesionalTerminosCondiciones != T000817_A196ProfesionalTerminosCondiciones[0] )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalTerminosCondiciones");
               GXutil.writeLogRaw("Old: ",Z196ProfesionalTerminosCondiciones);
               GXutil.writeLogRaw("Current: ",T000817_A196ProfesionalTerminosCondiciones[0]);
            }
            if ( GXutil.strcmp(Z197ProfesionalEstadoCuenta, T000817_A197ProfesionalEstadoCuenta[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalEstadoCuenta");
               GXutil.writeLogRaw("Old: ",Z197ProfesionalEstadoCuenta);
               GXutil.writeLogRaw("Current: ",T000817_A197ProfesionalEstadoCuenta[0]);
            }
            if ( GXutil.strcmp(Z198ProfesionalEstado, T000817_A198ProfesionalEstado[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ProfesionalEstado");
               GXutil.writeLogRaw("Old: ",Z198ProfesionalEstado);
               GXutil.writeLogRaw("Current: ",T000817_A198ProfesionalEstado[0]);
            }
            if ( Z43PaisId != T000817_A43PaisId[0] )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"PaisId");
               GXutil.writeLogRaw("Old: ",Z43PaisId);
               GXutil.writeLogRaw("Current: ",T000817_A43PaisId[0]);
            }
            if ( GXutil.strcmp(Z44UbigeoCode, T000817_A44UbigeoCode[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"UbigeoCode");
               GXutil.writeLogRaw("Old: ",Z44UbigeoCode);
               GXutil.writeLogRaw("Current: ",T000817_A44UbigeoCode[0]);
            }
            if ( Z6SecUserId != T000817_A6SecUserId[0] )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"SecUserId");
               GXutil.writeLogRaw("Old: ",Z6SecUserId);
               GXutil.writeLogRaw("Current: ",T000817_A6SecUserId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Profesional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert089( )
   {
      beforeValidate089( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable089( ) ;
      }
      if ( AnyError == 0 )
      {
         zm089( 0) ;
         checkOptimisticConcurrency089( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm089( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert089( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000829 */
                  pr_default.execute(27, new Object[] {A173ProfesionalTipoDocumento, A174ProfesionalNroDocumento, A85ProfesionalApellidoPaterno, A86ProfesionalApellidoMaterno, A84ProfesionalNombres, A176ProfesionalFechaNacimiento, A177ProfesionalSexo, A178ProfesionalDescripcion, A179ProfesionalCorreo, A88ProfesionalCOP, A180ProfesionalColorDisponible, A181ProfesionalColorCita, Byte.valueOf(A182ProfesionalTiempoCita), A183ProfesionalDireccion, A189ProfesionalFoto, A40000ProfesionalFoto_GXI, A190ProfesionalTwitter, A191ProfesionalFacebook, A192ProfesionalInstagram, A193ProfesionalLinkedin, A194ProfesionalTelefono, A195ProfesionalFechaRegistro, Boolean.valueOf(A196ProfesionalTerminosCondiciones), A197ProfesionalEstadoCuenta, A198ProfesionalEstado, Short.valueOf(A43PaisId), A44UbigeoCode, Short.valueOf(A6SecUserId)});
                  A31ProfesionalId = T000829_A31ProfesionalId[0] ;
                  httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel089( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption080( ) ;
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
            load089( ) ;
         }
         endLevel089( ) ;
      }
      closeExtendedTableCursors089( ) ;
   }

   public void update089( )
   {
      beforeValidate089( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable089( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency089( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm089( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate089( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000830 */
                  pr_default.execute(28, new Object[] {A173ProfesionalTipoDocumento, A174ProfesionalNroDocumento, A85ProfesionalApellidoPaterno, A86ProfesionalApellidoMaterno, A84ProfesionalNombres, A176ProfesionalFechaNacimiento, A177ProfesionalSexo, A178ProfesionalDescripcion, A179ProfesionalCorreo, A88ProfesionalCOP, A180ProfesionalColorDisponible, A181ProfesionalColorCita, Byte.valueOf(A182ProfesionalTiempoCita), A183ProfesionalDireccion, A190ProfesionalTwitter, A191ProfesionalFacebook, A192ProfesionalInstagram, A193ProfesionalLinkedin, A194ProfesionalTelefono, A195ProfesionalFechaRegistro, Boolean.valueOf(A196ProfesionalTerminosCondiciones), A197ProfesionalEstadoCuenta, A198ProfesionalEstado, Short.valueOf(A43PaisId), A44UbigeoCode, Short.valueOf(A6SecUserId), Integer.valueOf(A31ProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
                  if ( (pr_default.getStatus(28) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Profesional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate089( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel089( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                           resetCaption080( ) ;
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
         endLevel089( ) ;
      }
      closeExtendedTableCursors089( ) ;
   }

   public void deferredUpdate089( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000831 */
         pr_default.execute(29, new Object[] {A189ProfesionalFoto, A40000ProfesionalFoto_GXI, Integer.valueOf(A31ProfesionalId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate089( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency089( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls089( ) ;
         afterConfirm089( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete089( ) ;
            if ( AnyError == 0 )
            {
               scanStart0815( ) ;
               while ( RcdFound15 != 0 )
               {
                  getByPrimaryKey0815( ) ;
                  delete0815( ) ;
                  scanNext0815( ) ;
               }
               scanEnd0815( ) ;
               scanStart0814( ) ;
               while ( RcdFound14 != 0 )
               {
                  getByPrimaryKey0814( ) ;
                  delete0814( ) ;
                  scanNext0814( ) ;
               }
               scanEnd0814( ) ;
               scanStart0813( ) ;
               while ( RcdFound13 != 0 )
               {
                  getByPrimaryKey0813( ) ;
                  delete0813( ) ;
                  scanNext0813( ) ;
               }
               scanEnd0813( ) ;
               scanStart0812( ) ;
               while ( RcdFound12 != 0 )
               {
                  getByPrimaryKey0812( ) ;
                  delete0812( ) ;
                  scanNext0812( ) ;
               }
               scanEnd0812( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000832 */
                  pr_default.execute(30, new Object[] {Integer.valueOf(A31ProfesionalId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Profesional");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        move_next( ) ;
                        if ( RcdFound9 == 0 )
                        {
                           initAll089( ) ;
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
                        resetCaption080( ) ;
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
      sMode9 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel089( ) ;
      Gx_mode = sMode9 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls089( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( new com.projectthani.prcvalidarexisteprofesional(remoteHandle, context).executeUdp( GXutil.trim( A174ProfesionalNroDocumento)) && isIns( )  )
         {
            httpContext.GX_msglist.addItem("Ya existe un profesional con el nro de documento ingresado", 1, "PROFESIONALNRODOCUMENTO");
            AnyError = (short)(1) ;
            GX_FocusControl = edtProfesionalNroDocumento_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         A175ProfesionalNombreCompleto2 = A85ProfesionalApellidoPaterno + " " + A86ProfesionalApellidoMaterno + ", " + A84ProfesionalNombres ;
         httpContext.ajax_rsp_assign_attri("", false, "A175ProfesionalNombreCompleto2", A175ProfesionalNombreCompleto2);
         /* Using cursor T000833 */
         pr_default.execute(31, new Object[] {Short.valueOf(A43PaisId)});
         A184PaisDescripcion = T000833_A184PaisDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
         pr_default.close(31);
         /* Using cursor T000834 */
         pr_default.execute(32, new Object[] {A44UbigeoCode});
         A186UbigeoDepartamento = T000834_A186UbigeoDepartamento[0] ;
         A187UbigeoProvincia = T000834_A187UbigeoProvincia[0] ;
         A188UbigeoDistrito = T000834_A188UbigeoDistrito[0] ;
         pr_default.close(32);
         A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
         httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000835 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Comentario Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor T000836 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Rating Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor T000837 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Educacion Profesional"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor T000838 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A31ProfesionalId)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Especialidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
      }
   }

   public void processNestedLevel0810( )
   {
      nGXsfl_184_idx = 0 ;
      while ( nGXsfl_184_idx < nRC_GXsfl_184 )
      {
         readRow0810( ) ;
         if ( ( nRcdExists_10 != 0 ) || ( nIsMod_10 != 0 ) )
         {
            standaloneNotModal0810( ) ;
            getKey0810( ) ;
            if ( ( nRcdExists_10 == 0 ) && ( nRcdDeleted_10 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0810( ) ;
            }
            else
            {
               if ( RcdFound10 != 0 )
               {
                  if ( ( nRcdDeleted_10 != 0 ) && ( nRcdExists_10 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0810( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_10 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0810( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_10 == 0 )
                  {
                     GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEspecialidadId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtEspecialidadId_Internalname, GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( edtEspecialidadCodigo_Internalname, A140EspecialidadCodigo) ;
         httpContext.changePostValue( edtEspecialidadNombre_Internalname, A71EspecialidadNombre) ;
         httpContext.changePostValue( "ZT_"+"Z32EspecialidadId_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( Z32EspecialidadId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRC_GXsfl_209_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_209, (byte)(8), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_10_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_10_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_10_"+sGXsfl_184_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_10 != 0 )
         {
            httpContext.changePostValue( "ESPECIALIDADID_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESPECIALIDADCODIGO_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadCodigo_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESPECIALIDADNOMBRE_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0810( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_10 = (short)(0) ;
      nIsMod_10 = (short)(0) ;
      nRcdDeleted_10 = (short)(0) ;
   }

   public void processNestedLevel0812( )
   {
      nGXsfl_220_idx = 0 ;
      while ( nGXsfl_220_idx < nRC_GXsfl_220 )
      {
         readRow0812( ) ;
         if ( ( nRcdExists_12 != 0 ) || ( nIsMod_12 != 0 ) )
         {
            standaloneNotModal0812( ) ;
            getKey0812( ) ;
            if ( ( nRcdExists_12 == 0 ) && ( nRcdDeleted_12 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0812( ) ;
            }
            else
            {
               if ( RcdFound12 != 0 )
               {
                  if ( ( nRcdDeleted_12 != 0 ) && ( nRcdExists_12 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0812( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_12 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0812( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_12 == 0 )
                  {
                     GXCCtl = "EDUCACIONID_" + sGXsfl_220_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEducacionId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtEducacionId_Internalname, A55EducacionId.toString()) ;
         httpContext.changePostValue( edtEducacionNombreInstitucion_Internalname, A200EducacionNombreInstitucion) ;
         httpContext.changePostValue( edtEducacionDesde_Internalname, localUtil.format(A201EducacionDesde, "99/99/99")) ;
         httpContext.changePostValue( edtEducacionHasta_Internalname, localUtil.format(A202EducacionHasta, "99/99/99")) ;
         httpContext.changePostValue( edtEducacionPaisDescripcion_Internalname, A203EducacionPaisDescripcion) ;
         httpContext.changePostValue( "ZT_"+"Z55EducacionId_"+sGXsfl_220_idx, Z55EducacionId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z200EducacionNombreInstitucion_"+sGXsfl_220_idx, Z200EducacionNombreInstitucion) ;
         httpContext.changePostValue( "ZT_"+"Z201EducacionDesde_"+sGXsfl_220_idx, localUtil.dtoc( Z201EducacionDesde, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z202EducacionHasta_"+sGXsfl_220_idx, localUtil.dtoc( Z202EducacionHasta, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z203EducacionPaisDescripcion_"+sGXsfl_220_idx, Z203EducacionPaisDescripcion) ;
         httpContext.changePostValue( "nRcdDeleted_12_"+sGXsfl_220_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_12, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_12_"+sGXsfl_220_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_12, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_12_"+sGXsfl_220_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_12, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_12 != 0 )
         {
            httpContext.changePostValue( "EDUCACIONID_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONNOMBREINSTITUCION_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionNombreInstitucion_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONDESDE_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONHASTA_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EDUCACIONPAISDESCRIPCION_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionPaisDescripcion_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0812( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_12 = (short)(0) ;
      nIsMod_12 = (short)(0) ;
      nRcdDeleted_12 = (short)(0) ;
   }

   public void processNestedLevel0813( )
   {
      nGXsfl_231_idx = 0 ;
      while ( nGXsfl_231_idx < nRC_GXsfl_231 )
      {
         readRow0813( ) ;
         if ( ( nRcdExists_13 != 0 ) || ( nIsMod_13 != 0 ) )
         {
            standaloneNotModal0813( ) ;
            getKey0813( ) ;
            if ( ( nRcdExists_13 == 0 ) && ( nRcdDeleted_13 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0813( ) ;
            }
            else
            {
               if ( RcdFound13 != 0 )
               {
                  if ( ( nRcdDeleted_13 != 0 ) && ( nRcdExists_13 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0813( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_13 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0813( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_13 == 0 )
                  {
                     GXCCtl = "EXPERIENCIALABORALID_" + sGXsfl_231_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtExperienciaLaboralId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtExperienciaLaboralId_Internalname, A56ExperienciaLaboralId.toString()) ;
         httpContext.changePostValue( edtExperienciaLaboralEmpresaNombre_Internalname, A204ExperienciaLaboralEmpresaNombre) ;
         httpContext.changePostValue( edtExperienciaLaboralDesde_Internalname, localUtil.format(A205ExperienciaLaboralDesde, "99/99/9999")) ;
         httpContext.changePostValue( edtExperienciaLaboralHasta_Internalname, localUtil.format(A206ExperienciaLaboralHasta, "99/99/9999")) ;
         httpContext.changePostValue( "ZT_"+"Z56ExperienciaLaboralId_"+sGXsfl_231_idx, Z56ExperienciaLaboralId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z204ExperienciaLaboralEmpresaNombre_"+sGXsfl_231_idx, Z204ExperienciaLaboralEmpresaNombre) ;
         httpContext.changePostValue( "ZT_"+"Z205ExperienciaLaboralDesde_"+sGXsfl_231_idx, localUtil.dtoc( Z205ExperienciaLaboralDesde, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z206ExperienciaLaboralHasta_"+sGXsfl_231_idx, localUtil.dtoc( Z206ExperienciaLaboralHasta, 0, "/")) ;
         httpContext.changePostValue( "nRcdDeleted_13_"+sGXsfl_231_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_13, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_13_"+sGXsfl_231_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_13, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_13_"+sGXsfl_231_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_13, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_13 != 0 )
         {
            httpContext.changePostValue( "EXPERIENCIALABORALID_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralEmpresaNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EXPERIENCIALABORALDESDE_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralDesde_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "EXPERIENCIALABORALHASTA_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralHasta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0813( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_13 = (short)(0) ;
      nIsMod_13 = (short)(0) ;
      nRcdDeleted_13 = (short)(0) ;
   }

   public void processNestedLevel0814( )
   {
      nGXsfl_241_idx = 0 ;
      while ( nGXsfl_241_idx < nRC_GXsfl_241 )
      {
         readRow0814( ) ;
         if ( ( nRcdExists_14 != 0 ) || ( nIsMod_14 != 0 ) )
         {
            standaloneNotModal0814( ) ;
            getKey0814( ) ;
            if ( ( nRcdExists_14 == 0 ) && ( nRcdDeleted_14 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0814( ) ;
            }
            else
            {
               if ( RcdFound14 != 0 )
               {
                  if ( ( nRcdDeleted_14 != 0 ) && ( nRcdExists_14 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0814( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_14 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0814( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_14 == 0 )
                  {
                     GXCCtl = "PREMIOSID_" + sGXsfl_241_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPremiosId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtPremiosId_Internalname, A57PremiosId.toString()) ;
         httpContext.changePostValue( edtPremiosNombre_Internalname, A207PremiosNombre) ;
         httpContext.changePostValue( edtPremiosFecha_Internalname, localUtil.format(A208PremiosFecha, "99/99/99")) ;
         httpContext.changePostValue( edtPremiosDescripcion_Internalname, A209PremiosDescripcion) ;
         httpContext.changePostValue( "ZT_"+"Z57PremiosId_"+sGXsfl_241_idx, Z57PremiosId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z207PremiosNombre_"+sGXsfl_241_idx, Z207PremiosNombre) ;
         httpContext.changePostValue( "ZT_"+"Z208PremiosFecha_"+sGXsfl_241_idx, localUtil.dtoc( Z208PremiosFecha, 0, "/")) ;
         httpContext.changePostValue( "nRcdDeleted_14_"+sGXsfl_241_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_14, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_14_"+sGXsfl_241_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_14, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_14_"+sGXsfl_241_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_14, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_14 != 0 )
         {
            httpContext.changePostValue( "PREMIOSID_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PREMIOSNOMBRE_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PREMIOSFECHA_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosFecha_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PREMIOSDESCRIPCION_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosDescripcion_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0814( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_14 = (short)(0) ;
      nIsMod_14 = (short)(0) ;
      nRcdDeleted_14 = (short)(0) ;
   }

   public void processNestedLevel0815( )
   {
      nGXsfl_251_idx = 0 ;
      while ( nGXsfl_251_idx < nRC_GXsfl_251 )
      {
         readRow0815( ) ;
         if ( ( nRcdExists_15 != 0 ) || ( nIsMod_15 != 0 ) )
         {
            standaloneNotModal0815( ) ;
            getKey0815( ) ;
            if ( ( nRcdExists_15 == 0 ) && ( nRcdDeleted_15 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0815( ) ;
            }
            else
            {
               if ( RcdFound15 != 0 )
               {
                  if ( ( nRcdDeleted_15 != 0 ) && ( nRcdExists_15 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0815( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_15 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0815( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_15 == 0 )
                  {
                     GXCCtl = "SERVICIOSID_" + sGXsfl_251_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtServiciosId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtServiciosId_Internalname, A58ServiciosId.toString()) ;
         httpContext.changePostValue( edtServiciosNombre_Internalname, A210ServiciosNombre) ;
         httpContext.changePostValue( "ZT_"+"Z58ServiciosId_"+sGXsfl_251_idx, Z58ServiciosId.toString()) ;
         httpContext.changePostValue( "ZT_"+"Z210ServiciosNombre_"+sGXsfl_251_idx, Z210ServiciosNombre) ;
         httpContext.changePostValue( "nRcdDeleted_15_"+sGXsfl_251_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_15, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_15_"+sGXsfl_251_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_15, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_15_"+sGXsfl_251_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_15, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_15 != 0 )
         {
            httpContext.changePostValue( "SERVICIOSID_"+sGXsfl_251_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SERVICIOSNOMBRE_"+sGXsfl_251_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0815( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_15 = (short)(0) ;
      nIsMod_15 = (short)(0) ;
      nRcdDeleted_15 = (short)(0) ;
   }

   public void processLevel089( )
   {
      /* Save parent mode. */
      sMode9 = Gx_mode ;
      processNestedLevel0810( ) ;
      processNestedLevel0812( ) ;
      processNestedLevel0813( ) ;
      processNestedLevel0814( ) ;
      processNestedLevel0815( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode9 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel089( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(15);
      }
      if ( AnyError == 0 )
      {
         beforeComplete089( ) ;
      }
      if ( AnyError == 0 )
      {
         pr_default.close(13);
         pr_default.close(12);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(31);
         pr_default.close(32);
         pr_default.close(14);
         pr_default.close(10);
         pr_default.close(11);
         Application.commitDataStores(context, remoteHandle, pr_default, "profesional");
         if ( AnyError == 0 )
         {
            confirmValues080( ) ;
         }
         /* After transaction rules */
         if ( isIns( )  )
         {
            new com.projectthani.prccrearusuariodoctor(remoteHandle, context).execute( AV15ProfesionalNroDocumento, AV14ProfesionalCorreo) ;
         }
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         pr_default.close(13);
         pr_default.close(12);
         pr_default.close(9);
         pr_default.close(8);
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         pr_default.close(0);
         pr_default.close(31);
         pr_default.close(32);
         pr_default.close(14);
         pr_default.close(10);
         pr_default.close(11);
         Application.rollbackDataStores(context, remoteHandle, pr_default, "profesional");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart089( )
   {
      /* Scan By routine */
      /* Using cursor T000839 */
      pr_default.execute(37);
      RcdFound9 = (short)(0) ;
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A31ProfesionalId = T000839_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext089( )
   {
      /* Scan next routine */
      pr_default.readNext(37);
      RcdFound9 = (short)(0) ;
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A31ProfesionalId = T000839_A31ProfesionalId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      }
   }

   public void scanEnd089( )
   {
      pr_default.close(37);
   }

   public void afterConfirm089( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert089( )
   {
      /* Before Insert Rules */
      AV15ProfesionalNroDocumento = A174ProfesionalNroDocumento ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15ProfesionalNroDocumento", AV15ProfesionalNroDocumento);
      AV14ProfesionalCorreo = A179ProfesionalCorreo ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalCorreo", AV14ProfesionalCorreo);
   }

   public void beforeUpdate089( )
   {
      /* Before Update Rules */
      AV15ProfesionalNroDocumento = A174ProfesionalNroDocumento ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15ProfesionalNroDocumento", AV15ProfesionalNroDocumento);
      AV14ProfesionalCorreo = A179ProfesionalCorreo ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalCorreo", AV14ProfesionalCorreo);
   }

   public void beforeDelete089( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete089( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate089( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes089( )
   {
      edtProfesionalId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalId_Enabled), 5, 0), true);
      cmbProfesionalTipoDocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTipoDocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbProfesionalTipoDocumento.getEnabled(), 5, 0), true);
      edtProfesionalNroDocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNroDocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNroDocumento_Enabled), 5, 0), true);
      edtProfesionalApellidoPaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoPaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoPaterno_Enabled), 5, 0), true);
      edtProfesionalApellidoMaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalApellidoMaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalApellidoMaterno_Enabled), 5, 0), true);
      edtProfesionalNombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombres_Enabled), 5, 0), true);
      edtProfesionalNombreCompleto2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalNombreCompleto2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalNombreCompleto2_Enabled), 5, 0), true);
      edtProfesionalFechaNacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFechaNacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalFechaNacimiento_Enabled), 5, 0), true);
      cmbProfesionalSexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalSexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbProfesionalSexo.getEnabled(), 5, 0), true);
      edtProfesionalDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalDescripcion_Enabled), 5, 0), true);
      edtProfesionalCorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalCorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalCorreo_Enabled), 5, 0), true);
      edtProfesionalCOP_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalCOP_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalCOP_Enabled), 5, 0), true);
      edtProfesionalColorDisponible_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalColorDisponible_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalColorDisponible_Enabled), 5, 0), true);
      edtProfesionalColorCita_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalColorCita_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalColorCita_Enabled), 5, 0), true);
      cmbProfesionalTiempoCita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTiempoCita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbProfesionalTiempoCita.getEnabled(), 5, 0), true);
      edtProfesionalDireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalDireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalDireccion_Enabled), 5, 0), true);
      edtPaisId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisId_Enabled), 5, 0), true);
      edtPaisDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaisDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaisDescripcion_Enabled), 5, 0), true);
      edtUbigeoCode_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoCode_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoCode_Enabled), 5, 0), true);
      edtUbigeoNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtUbigeoNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtUbigeoNombre_Enabled), 5, 0), true);
      imgProfesionalFoto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgProfesionalFoto_Enabled), 5, 0), true);
      edtProfesionalTwitter_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalTwitter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalTwitter_Enabled), 5, 0), true);
      edtProfesionalFacebook_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFacebook_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalFacebook_Enabled), 5, 0), true);
      edtProfesionalInstagram_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalInstagram_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalInstagram_Enabled), 5, 0), true);
      edtProfesionalLinkedin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalLinkedin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalLinkedin_Enabled), 5, 0), true);
      edtProfesionalTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalTelefono_Enabled), 5, 0), true);
      edtSecUserId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSecUserId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSecUserId_Enabled), 5, 0), true);
      edtProfesionalFechaRegistro_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtProfesionalFechaRegistro_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtProfesionalFechaRegistro_Enabled), 5, 0), true);
      chkProfesionalTerminosCondiciones.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkProfesionalTerminosCondiciones.getInternalname(), "Enabled", GXutil.ltrimstr( chkProfesionalTerminosCondiciones.getEnabled(), 5, 0), true);
      cmbProfesionalEstadoCuenta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstadoCuenta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbProfesionalEstadoCuenta.getEnabled(), 5, 0), true);
      cmbProfesionalEstado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstado.getInternalname(), "Enabled", GXutil.ltrimstr( cmbProfesionalEstado.getEnabled(), 5, 0), true);
   }

   public void zm0810( int GX_JID )
   {
      if ( ( GX_JID == 47 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
         }
         else
         {
         }
      }
      if ( GX_JID == -47 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z140EspecialidadCodigo = A140EspecialidadCodigo ;
         Z71EspecialidadNombre = A71EspecialidadNombre ;
      }
   }

   public void standaloneNotModal0810( )
   {
   }

   public void standaloneModal0810( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtEspecialidadId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), !bGXsfl_184_Refreshing);
      }
      else
      {
         edtEspecialidadId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), !bGXsfl_184_Refreshing);
      }
   }

   public void load0810( )
   {
      /* Using cursor T000840 */
      pr_default.execute(38, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(38) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A140EspecialidadCodigo = T000840_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = T000840_A71EspecialidadNombre[0] ;
         zm0810( -47) ;
      }
      pr_default.close(38);
      onLoadActions0810( ) ;
   }

   public void onLoadActions0810( )
   {
   }

   public void checkExtendedTable0810( )
   {
      nIsDirty_10 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0810( ) ;
      /* Using cursor T000816 */
      pr_default.execute(14, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(14) == 101) )
      {
         GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A140EspecialidadCodigo = T000816_A140EspecialidadCodigo[0] ;
      A71EspecialidadNombre = T000816_A71EspecialidadNombre[0] ;
      pr_default.close(14);
   }

   public void closeExtendedTableCursors0810( )
   {
      pr_default.close(14);
   }

   public void enableDisable0810( )
   {
   }

   public void gxload_48( short A32EspecialidadId )
   {
      /* Using cursor T000841 */
      pr_default.execute(39, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(39) == 101) )
      {
         GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A140EspecialidadCodigo = T000841_A140EspecialidadCodigo[0] ;
      A71EspecialidadNombre = T000841_A71EspecialidadNombre[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A140EspecialidadCodigo)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A71EspecialidadNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(39) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(39);
   }

   public void getKey0810( )
   {
      /* Using cursor T000842 */
      pr_default.execute(40, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(40) != 101) )
      {
         RcdFound10 = (short)(1) ;
      }
      else
      {
         RcdFound10 = (short)(0) ;
      }
      pr_default.close(40);
   }

   public void getByPrimaryKey0810( )
   {
      /* Using cursor T000815 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         zm0810( 47) ;
         RcdFound10 = (short)(1) ;
         initializeNonKey0810( ) ;
         A32EspecialidadId = T000815_A32EspecialidadId[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0810( ) ;
         load0810( ) ;
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound10 = (short)(0) ;
         initializeNonKey0810( ) ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0810( ) ;
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0810( ) ;
      }
      pr_default.close(13);
   }

   public void checkOptimisticConcurrency0810( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000814 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(12) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEspecialidad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(12) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalEspecialidad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0810( )
   {
      beforeValidate0810( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0810( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0810( 0) ;
         checkOptimisticConcurrency0810( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0810( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0810( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000843 */
                  pr_default.execute(41, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidad");
                  if ( (pr_default.getStatus(41) == 1) )
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
                        processLevel0810( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
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
            load0810( ) ;
         }
         endLevel0810( ) ;
      }
      closeExtendedTableCursors0810( ) ;
   }

   public void update0810( )
   {
      beforeValidate0810( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0810( ) ;
      }
      if ( ( nIsMod_10 != 0 ) || ( nIsDirty_10 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0810( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0810( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0810( ) ;
                  if ( AnyError == 0 )
                  {
                     /* No attributes to update on table [ProfesionalEspecialidad] */
                     deferredUpdate0810( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           processLevel0810( ) ;
                           if ( AnyError == 0 )
                           {
                              getByPrimaryKey0810( ) ;
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
            endLevel0810( ) ;
         }
      }
      closeExtendedTableCursors0810( ) ;
   }

   public void deferredUpdate0810( )
   {
   }

   public void delete0810( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0810( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0810( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0810( ) ;
         afterConfirm0810( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0810( ) ;
            if ( AnyError == 0 )
            {
               scanStart0811( ) ;
               while ( RcdFound11 != 0 )
               {
                  getByPrimaryKey0811( ) ;
                  delete0811( ) ;
                  scanNext0811( ) ;
               }
               scanEnd0811( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000844 */
                  pr_default.execute(42, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidad");
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
      }
      sMode10 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0810( ) ;
      Gx_mode = sMode10 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0810( )
   {
      standaloneModal0810( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000845 */
         pr_default.execute(43, new Object[] {Short.valueOf(A32EspecialidadId)});
         A140EspecialidadCodigo = T000845_A140EspecialidadCodigo[0] ;
         A71EspecialidadNombre = T000845_A71EspecialidadNombre[0] ;
         pr_default.close(43);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000846 */
         pr_default.execute(44, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(44) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Disponibilidad"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(44);
         /* Using cursor T000847 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
         if ( (pr_default.getStatus(45) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Conf Comision"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
      }
   }

   public void processNestedLevel0811( )
   {
      nGXsfl_209_idx = 0 ;
      while ( nGXsfl_209_idx < nRC_GXsfl_209 )
      {
         readRow0811( ) ;
         if ( ( nRcdExists_11 != 0 ) || ( nIsMod_11 != 0 ) )
         {
            standaloneNotModal0811( ) ;
            getKey0811( ) ;
            if ( ( nRcdExists_11 == 0 ) && ( nRcdDeleted_11 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0811( ) ;
            }
            else
            {
               if ( RcdFound11 != 0 )
               {
                  if ( ( nRcdDeleted_11 != 0 ) && ( nRcdExists_11 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0811( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_11 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0811( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_11 == 0 )
                  {
                     GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtEspecialidadId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtSedeId_Internalname, GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( cmbSedeTipoConsulta.getInternalname(), GXutil.rtrim( A54SedeTipoConsulta)) ;
         httpContext.changePostValue( edtSedeNombre_Internalname, A75SedeNombre) ;
         httpContext.changePostValue( edtClinicaNombreAbreviado_Internalname, A80ClinicaNombreAbreviado) ;
         httpContext.changePostValue( edtCostoConsulta_Internalname, GXutil.ltrim( localUtil.ntoc( A199CostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z30SedeId_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( Z30SedeId, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z54SedeTipoConsulta_"+sGXsfl_209_idx, GXutil.rtrim( Z54SedeTipoConsulta)) ;
         httpContext.changePostValue( "ZT_"+"Z199CostoConsulta_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( Z199CostoConsulta, (byte)(6), (byte)(2), ",", ""))) ;
         httpContext.changePostValue( "nRcdDeleted_11_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_11, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nRcdExists_11_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_11, (byte)(4), (byte)(0), ",", ""))) ;
         httpContext.changePostValue( "nIsMod_11_"+sGXsfl_209_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_11, (byte)(4), (byte)(0), ",", ""))) ;
         if ( nIsMod_11 != 0 )
         {
            httpContext.changePostValue( "SEDEID_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SEDETIPOCONSULTA_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbSedeTipoConsulta.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "SEDENOMBRE_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeNombre_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CLINICANOMBREABREVIADO_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtClinicaNombreAbreviado_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COSTOCONSULTA_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0811( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_11 = (short)(0) ;
      nIsMod_11 = (short)(0) ;
      nRcdDeleted_11 = (short)(0) ;
   }

   public void processLevel0810( )
   {
      /* Save parent mode. */
      sMode10 = Gx_mode ;
      processNestedLevel0811( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode10 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0810( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(12);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0810( )
   {
      /* Scan By routine */
      /* Using cursor T000848 */
      pr_default.execute(46, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(46) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A32EspecialidadId = T000848_A32EspecialidadId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0810( )
   {
      /* Scan next routine */
      pr_default.readNext(46);
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(46) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A32EspecialidadId = T000848_A32EspecialidadId[0] ;
      }
   }

   public void scanEnd0810( )
   {
      pr_default.close(46);
   }

   public void afterConfirm0810( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0810( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0810( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0810( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0810( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0810( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0810( )
   {
      edtEspecialidadId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), !bGXsfl_184_Refreshing);
      edtEspecialidadCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadCodigo_Enabled), 5, 0), !bGXsfl_184_Refreshing);
      edtEspecialidadNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadNombre_Enabled), 5, 0), !bGXsfl_184_Refreshing);
   }

   public void zm0811( int GX_JID )
   {
      if ( ( GX_JID == 49 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z199CostoConsulta = T000811_A199CostoConsulta[0] ;
         }
         else
         {
            Z199CostoConsulta = A199CostoConsulta ;
         }
      }
      if ( GX_JID == -49 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z54SedeTipoConsulta = A54SedeTipoConsulta ;
         Z199CostoConsulta = A199CostoConsulta ;
         Z30SedeId = A30SedeId ;
         Z28ClinicaId = A28ClinicaId ;
         Z75SedeNombre = A75SedeNombre ;
         Z80ClinicaNombreAbreviado = A80ClinicaNombreAbreviado ;
      }
   }

   public void standaloneNotModal0811( )
   {
   }

   public void standaloneModal0811( )
   {
      if ( isIns( )  && (DecimalUtil.compareTo(DecimalUtil.ZERO, A199CostoConsulta)==0) && ( Gx_BScreen == 0 ) )
      {
         A199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      }
      if ( isIns( )  && (GXutil.strcmp("", A54SedeTipoConsulta)==0) && ( Gx_BScreen == 0 ) )
      {
         A54SedeTipoConsulta = "V" ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtSedeId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), !bGXsfl_209_Refreshing);
      }
      else
      {
         edtSedeId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), !bGXsfl_209_Refreshing);
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         cmbSedeTipoConsulta.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipoConsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeTipoConsulta.getEnabled(), 5, 0), !bGXsfl_209_Refreshing);
      }
      else
      {
         cmbSedeTipoConsulta.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipoConsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeTipoConsulta.getEnabled(), 5, 0), !bGXsfl_209_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0811( )
   {
      /* Using cursor T000849 */
      pr_default.execute(47, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), A54SedeTipoConsulta, Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(47) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A28ClinicaId = T000849_A28ClinicaId[0] ;
         A199CostoConsulta = T000849_A199CostoConsulta[0] ;
         A75SedeNombre = T000849_A75SedeNombre[0] ;
         A80ClinicaNombreAbreviado = T000849_A80ClinicaNombreAbreviado[0] ;
         zm0811( -49) ;
      }
      pr_default.close(47);
      onLoadActions0811( ) ;
   }

   public void onLoadActions0811( )
   {
   }

   public void checkExtendedTable0811( )
   {
      nIsDirty_11 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0811( ) ;
      /* Using cursor T000812 */
      pr_default.execute(10, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         GXCCtl = "SEDEID_" + sGXsfl_209_idx ;
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A28ClinicaId = T000812_A28ClinicaId[0] ;
      A75SedeNombre = T000812_A75SedeNombre[0] ;
      pr_default.close(10);
      /* Using cursor T000813 */
      pr_default.execute(11, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
      }
      A80ClinicaNombreAbreviado = T000813_A80ClinicaNombreAbreviado[0] ;
      pr_default.close(11);
      if ( ! ( ( GXutil.strcmp(A54SedeTipoConsulta, "V") == 0 ) || ( GXutil.strcmp(A54SedeTipoConsulta, "P") == 0 ) || ( GXutil.strcmp(A54SedeTipoConsulta, "D") == 0 ) ) )
      {
         GXCCtl = "SEDETIPOCONSULTA_" + sGXsfl_209_idx ;
         httpContext.GX_msglist.addItem("Tipo Consulta fuera del rango", "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = cmbSedeTipoConsulta.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0811( )
   {
      pr_default.close(10);
      pr_default.close(11);
   }

   public void enableDisable0811( )
   {
   }

   public void gxload_50( short A30SedeId )
   {
      /* Using cursor T000850 */
      pr_default.execute(48, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(48) == 101) )
      {
         GXCCtl = "SEDEID_" + sGXsfl_209_idx ;
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A28ClinicaId = T000850_A28ClinicaId[0] ;
      A75SedeNombre = T000850_A75SedeNombre[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( A75SedeNombre)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(48) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(48);
   }

   public void gxload_51( short A28ClinicaId )
   {
      /* Using cursor T000851 */
      pr_default.execute(49, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(49) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
      }
      A80ClinicaNombreAbreviado = T000851_A80ClinicaNombreAbreviado[0] ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A80ClinicaNombreAbreviado)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(49) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(49);
   }

   public void getKey0811( )
   {
      /* Using cursor T000852 */
      pr_default.execute(50, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
      if ( (pr_default.getStatus(50) != 101) )
      {
         RcdFound11 = (short)(1) ;
      }
      else
      {
         RcdFound11 = (short)(0) ;
      }
      pr_default.close(50);
   }

   public void getByPrimaryKey0811( )
   {
      /* Using cursor T000811 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
      if ( (pr_default.getStatus(9) != 101) )
      {
         zm0811( 49) ;
         RcdFound11 = (short)(1) ;
         initializeNonKey0811( ) ;
         A54SedeTipoConsulta = T000811_A54SedeTipoConsulta[0] ;
         A199CostoConsulta = T000811_A199CostoConsulta[0] ;
         A30SedeId = T000811_A30SedeId[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z32EspecialidadId = A32EspecialidadId ;
         Z30SedeId = A30SedeId ;
         Z54SedeTipoConsulta = A54SedeTipoConsulta ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0811( ) ;
         load0811( ) ;
         Gx_mode = sMode11 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound11 = (short)(0) ;
         initializeNonKey0811( ) ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0811( ) ;
         Gx_mode = sMode11 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0811( ) ;
      }
      pr_default.close(9);
   }

   public void checkOptimisticConcurrency0811( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000810 */
         pr_default.execute(8, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
         if ( (pr_default.getStatus(8) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEspecialidadSede"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(8) == 101) || ( DecimalUtil.compareTo(Z199CostoConsulta, T000810_A199CostoConsulta[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z199CostoConsulta, T000810_A199CostoConsulta[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"CostoConsulta");
               GXutil.writeLogRaw("Old: ",Z199CostoConsulta);
               GXutil.writeLogRaw("Current: ",T000810_A199CostoConsulta[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalEspecialidadSede"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0811( )
   {
      beforeValidate0811( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0811( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0811( 0) ;
         checkOptimisticConcurrency0811( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0811( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0811( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000853 */
                  pr_default.execute(51, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), A54SedeTipoConsulta, A199CostoConsulta, Short.valueOf(A30SedeId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
                  if ( (pr_default.getStatus(51) == 1) )
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
            load0811( ) ;
         }
         endLevel0811( ) ;
      }
      closeExtendedTableCursors0811( ) ;
   }

   public void update0811( )
   {
      beforeValidate0811( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0811( ) ;
      }
      if ( ( nIsMod_11 != 0 ) || ( nIsDirty_11 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0811( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0811( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0811( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000854 */
                     pr_default.execute(52, new Object[] {A199CostoConsulta, Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
                     if ( (pr_default.getStatus(52) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEspecialidadSede"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0811( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0811( ) ;
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
            endLevel0811( ) ;
         }
      }
      closeExtendedTableCursors0811( ) ;
   }

   public void deferredUpdate0811( )
   {
   }

   public void delete0811( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0811( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0811( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0811( ) ;
         afterConfirm0811( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0811( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000855 */
               pr_default.execute(53, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId), Short.valueOf(A30SedeId), A54SedeTipoConsulta});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEspecialidadSede");
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
      sMode11 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0811( ) ;
      Gx_mode = sMode11 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0811( )
   {
      standaloneModal0811( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000856 */
         pr_default.execute(54, new Object[] {Short.valueOf(A30SedeId)});
         A28ClinicaId = T000856_A28ClinicaId[0] ;
         A75SedeNombre = T000856_A75SedeNombre[0] ;
         pr_default.close(54);
         /* Using cursor T000857 */
         pr_default.execute(55, new Object[] {Short.valueOf(A28ClinicaId)});
         A80ClinicaNombreAbreviado = T000857_A80ClinicaNombreAbreviado[0] ;
         pr_default.close(55);
      }
   }

   public void endLevel0811( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(8);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0811( )
   {
      /* Scan By routine */
      /* Using cursor T000858 */
      pr_default.execute(56, new Object[] {Integer.valueOf(A31ProfesionalId), Short.valueOf(A32EspecialidadId)});
      RcdFound11 = (short)(0) ;
      if ( (pr_default.getStatus(56) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A30SedeId = T000858_A30SedeId[0] ;
         A54SedeTipoConsulta = T000858_A54SedeTipoConsulta[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0811( )
   {
      /* Scan next routine */
      pr_default.readNext(56);
      RcdFound11 = (short)(0) ;
      if ( (pr_default.getStatus(56) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A30SedeId = T000858_A30SedeId[0] ;
         A54SedeTipoConsulta = T000858_A54SedeTipoConsulta[0] ;
      }
   }

   public void scanEnd0811( )
   {
      pr_default.close(56);
   }

   public void afterConfirm0811( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0811( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0811( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0811( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0811( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0811( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0811( )
   {
      edtSedeId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), !bGXsfl_209_Refreshing);
      cmbSedeTipoConsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipoConsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeTipoConsulta.getEnabled(), 5, 0), !bGXsfl_209_Refreshing);
      edtSedeNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeNombre_Enabled), 5, 0), !bGXsfl_209_Refreshing);
      edtClinicaNombreAbreviado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreAbreviado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreAbreviado_Enabled), 5, 0), !bGXsfl_209_Refreshing);
      edtCostoConsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCostoConsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCostoConsulta_Enabled), 5, 0), !bGXsfl_209_Refreshing);
   }

   public void send_integrity_lvl_hashes0811( )
   {
   }

   public void send_integrity_lvl_hashes0810( )
   {
   }

   public void zm0812( int GX_JID )
   {
      if ( ( GX_JID == 52 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z200EducacionNombreInstitucion = T00089_A200EducacionNombreInstitucion[0] ;
            Z201EducacionDesde = T00089_A201EducacionDesde[0] ;
            Z202EducacionHasta = T00089_A202EducacionHasta[0] ;
            Z203EducacionPaisDescripcion = T00089_A203EducacionPaisDescripcion[0] ;
         }
         else
         {
            Z200EducacionNombreInstitucion = A200EducacionNombreInstitucion ;
            Z201EducacionDesde = A201EducacionDesde ;
            Z202EducacionHasta = A202EducacionHasta ;
            Z203EducacionPaisDescripcion = A203EducacionPaisDescripcion ;
         }
      }
      if ( GX_JID == -52 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z55EducacionId = A55EducacionId ;
         Z200EducacionNombreInstitucion = A200EducacionNombreInstitucion ;
         Z201EducacionDesde = A201EducacionDesde ;
         Z202EducacionHasta = A202EducacionHasta ;
         Z203EducacionPaisDescripcion = A203EducacionPaisDescripcion ;
      }
   }

   public void standaloneNotModal0812( )
   {
   }

   public void standaloneModal0812( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A55EducacionId) && ( Gx_BScreen == 0 ) )
      {
         A55EducacionId = java.util.UUID.randomUUID( ) ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtEducacionId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEducacionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionId_Enabled), 5, 0), !bGXsfl_220_Refreshing);
      }
      else
      {
         edtEducacionId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEducacionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionId_Enabled), 5, 0), !bGXsfl_220_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0812( )
   {
      /* Using cursor T000859 */
      pr_default.execute(57, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
      if ( (pr_default.getStatus(57) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A200EducacionNombreInstitucion = T000859_A200EducacionNombreInstitucion[0] ;
         A201EducacionDesde = T000859_A201EducacionDesde[0] ;
         A202EducacionHasta = T000859_A202EducacionHasta[0] ;
         A203EducacionPaisDescripcion = T000859_A203EducacionPaisDescripcion[0] ;
         zm0812( -52) ;
      }
      pr_default.close(57);
      onLoadActions0812( ) ;
   }

   public void onLoadActions0812( )
   {
   }

   public void checkExtendedTable0812( )
   {
      nIsDirty_12 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0812( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A201EducacionDesde)) || (( GXutil.resetTime(A201EducacionDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A201EducacionDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         GXCCtl = "EDUCACIONDESDE_" + sGXsfl_220_idx ;
         httpContext.GX_msglist.addItem("Campo Educacion Desde fuera de rango", "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionDesde_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A202EducacionHasta)) || (( GXutil.resetTime(A202EducacionHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A202EducacionHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         GXCCtl = "EDUCACIONHASTA_" + sGXsfl_220_idx ;
         httpContext.GX_msglist.addItem("Campo Educacion Hasta fuera de rango", "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionHasta_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0812( )
   {
   }

   public void enableDisable0812( )
   {
   }

   public void getKey0812( )
   {
      /* Using cursor T000860 */
      pr_default.execute(58, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
      if ( (pr_default.getStatus(58) != 101) )
      {
         RcdFound12 = (short)(1) ;
      }
      else
      {
         RcdFound12 = (short)(0) ;
      }
      pr_default.close(58);
   }

   public void getByPrimaryKey0812( )
   {
      /* Using cursor T00089 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
      if ( (pr_default.getStatus(7) != 101) )
      {
         zm0812( 52) ;
         RcdFound12 = (short)(1) ;
         initializeNonKey0812( ) ;
         A55EducacionId = T00089_A55EducacionId[0] ;
         A200EducacionNombreInstitucion = T00089_A200EducacionNombreInstitucion[0] ;
         A201EducacionDesde = T00089_A201EducacionDesde[0] ;
         A202EducacionHasta = T00089_A202EducacionHasta[0] ;
         A203EducacionPaisDescripcion = T00089_A203EducacionPaisDescripcion[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z55EducacionId = A55EducacionId ;
         sMode12 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0812( ) ;
         load0812( ) ;
         Gx_mode = sMode12 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound12 = (short)(0) ;
         initializeNonKey0812( ) ;
         sMode12 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0812( ) ;
         Gx_mode = sMode12 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0812( ) ;
      }
      pr_default.close(7);
   }

   public void checkOptimisticConcurrency0812( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00088 */
         pr_default.execute(6, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
         if ( (pr_default.getStatus(6) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEducacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(6) == 101) || ( GXutil.strcmp(Z200EducacionNombreInstitucion, T00088_A200EducacionNombreInstitucion[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z201EducacionDesde), GXutil.resetTime(T00088_A201EducacionDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z202EducacionHasta), GXutil.resetTime(T00088_A202EducacionHasta[0])) ) || ( GXutil.strcmp(Z203EducacionPaisDescripcion, T00088_A203EducacionPaisDescripcion[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z200EducacionNombreInstitucion, T00088_A200EducacionNombreInstitucion[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"EducacionNombreInstitucion");
               GXutil.writeLogRaw("Old: ",Z200EducacionNombreInstitucion);
               GXutil.writeLogRaw("Current: ",T00088_A200EducacionNombreInstitucion[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z201EducacionDesde), GXutil.resetTime(T00088_A201EducacionDesde[0])) ) )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"EducacionDesde");
               GXutil.writeLogRaw("Old: ",Z201EducacionDesde);
               GXutil.writeLogRaw("Current: ",T00088_A201EducacionDesde[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z202EducacionHasta), GXutil.resetTime(T00088_A202EducacionHasta[0])) ) )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"EducacionHasta");
               GXutil.writeLogRaw("Old: ",Z202EducacionHasta);
               GXutil.writeLogRaw("Current: ",T00088_A202EducacionHasta[0]);
            }
            if ( GXutil.strcmp(Z203EducacionPaisDescripcion, T00088_A203EducacionPaisDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"EducacionPaisDescripcion");
               GXutil.writeLogRaw("Old: ",Z203EducacionPaisDescripcion);
               GXutil.writeLogRaw("Current: ",T00088_A203EducacionPaisDescripcion[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalEducacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0812( )
   {
      beforeValidate0812( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0812( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0812( 0) ;
         checkOptimisticConcurrency0812( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0812( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0812( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000861 */
                  pr_default.execute(59, new Object[] {Integer.valueOf(A31ProfesionalId), A200EducacionNombreInstitucion, A201EducacionDesde, A202EducacionHasta, A203EducacionPaisDescripcion, A55EducacionId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEducacion");
                  if ( (pr_default.getStatus(59) == 1) )
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
            load0812( ) ;
         }
         endLevel0812( ) ;
      }
      closeExtendedTableCursors0812( ) ;
   }

   public void update0812( )
   {
      beforeValidate0812( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0812( ) ;
      }
      if ( ( nIsMod_12 != 0 ) || ( nIsDirty_12 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0812( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0812( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0812( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000862 */
                     pr_default.execute(60, new Object[] {A200EducacionNombreInstitucion, A201EducacionDesde, A202EducacionHasta, A203EducacionPaisDescripcion, Integer.valueOf(A31ProfesionalId), A55EducacionId});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEducacion");
                     if ( (pr_default.getStatus(60) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalEducacion"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0812( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0812( ) ;
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
            endLevel0812( ) ;
         }
      }
      closeExtendedTableCursors0812( ) ;
   }

   public void deferredUpdate0812( )
   {
   }

   public void delete0812( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0812( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0812( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0812( ) ;
         afterConfirm0812( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0812( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000863 */
               pr_default.execute(61, new Object[] {Integer.valueOf(A31ProfesionalId), A55EducacionId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalEducacion");
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
      sMode12 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0812( ) ;
      Gx_mode = sMode12 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0812( )
   {
      standaloneModal0812( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0812( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(6);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0812( )
   {
      /* Scan By routine */
      /* Using cursor T000864 */
      pr_default.execute(62, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound12 = (short)(0) ;
      if ( (pr_default.getStatus(62) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A55EducacionId = T000864_A55EducacionId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0812( )
   {
      /* Scan next routine */
      pr_default.readNext(62);
      RcdFound12 = (short)(0) ;
      if ( (pr_default.getStatus(62) != 101) )
      {
         RcdFound12 = (short)(1) ;
         A55EducacionId = T000864_A55EducacionId[0] ;
      }
   }

   public void scanEnd0812( )
   {
      pr_default.close(62);
   }

   public void afterConfirm0812( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0812( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0812( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0812( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0812( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0812( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0812( )
   {
      edtEducacionId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionId_Enabled), 5, 0), !bGXsfl_220_Refreshing);
      edtEducacionNombreInstitucion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionNombreInstitucion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionNombreInstitucion_Enabled), 5, 0), !bGXsfl_220_Refreshing);
      edtEducacionDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionDesde_Enabled), 5, 0), !bGXsfl_220_Refreshing);
      edtEducacionHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionHasta_Enabled), 5, 0), !bGXsfl_220_Refreshing);
      edtEducacionPaisDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionPaisDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionPaisDescripcion_Enabled), 5, 0), !bGXsfl_220_Refreshing);
   }

   public void send_integrity_lvl_hashes0812( )
   {
   }

   public void zm0813( int GX_JID )
   {
      if ( ( GX_JID == 53 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z204ExperienciaLaboralEmpresaNombre = T00087_A204ExperienciaLaboralEmpresaNombre[0] ;
            Z205ExperienciaLaboralDesde = T00087_A205ExperienciaLaboralDesde[0] ;
            Z206ExperienciaLaboralHasta = T00087_A206ExperienciaLaboralHasta[0] ;
         }
         else
         {
            Z204ExperienciaLaboralEmpresaNombre = A204ExperienciaLaboralEmpresaNombre ;
            Z205ExperienciaLaboralDesde = A205ExperienciaLaboralDesde ;
            Z206ExperienciaLaboralHasta = A206ExperienciaLaboralHasta ;
         }
      }
      if ( GX_JID == -53 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z56ExperienciaLaboralId = A56ExperienciaLaboralId ;
         Z204ExperienciaLaboralEmpresaNombre = A204ExperienciaLaboralEmpresaNombre ;
         Z205ExperienciaLaboralDesde = A205ExperienciaLaboralDesde ;
         Z206ExperienciaLaboralHasta = A206ExperienciaLaboralHasta ;
      }
   }

   public void standaloneNotModal0813( )
   {
   }

   public void standaloneModal0813( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A56ExperienciaLaboralId) && ( Gx_BScreen == 0 ) )
      {
         A56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtExperienciaLaboralId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralId_Enabled), 5, 0), !bGXsfl_231_Refreshing);
      }
      else
      {
         edtExperienciaLaboralId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralId_Enabled), 5, 0), !bGXsfl_231_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0813( )
   {
      /* Using cursor T000865 */
      pr_default.execute(63, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
      if ( (pr_default.getStatus(63) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A204ExperienciaLaboralEmpresaNombre = T000865_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = T000865_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = T000865_A206ExperienciaLaboralHasta[0] ;
         zm0813( -53) ;
      }
      pr_default.close(63);
      onLoadActions0813( ) ;
   }

   public void onLoadActions0813( )
   {
   }

   public void checkExtendedTable0813( )
   {
      nIsDirty_13 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0813( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A205ExperienciaLaboralDesde)) || (( GXutil.resetTime(A205ExperienciaLaboralDesde).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A205ExperienciaLaboralDesde), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         GXCCtl = "EXPERIENCIALABORALDESDE_" + sGXsfl_231_idx ;
         httpContext.GX_msglist.addItem("Campo Experiencia Laboral Desde fuera de rango", "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtExperienciaLaboralDesde_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A206ExperienciaLaboralHasta)) || (( GXutil.resetTime(A206ExperienciaLaboralHasta).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A206ExperienciaLaboralHasta), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         GXCCtl = "EXPERIENCIALABORALHASTA_" + sGXsfl_231_idx ;
         httpContext.GX_msglist.addItem("Campo Experiencia Laboral Hasta fuera de rango", "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtExperienciaLaboralHasta_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0813( )
   {
   }

   public void enableDisable0813( )
   {
   }

   public void getKey0813( )
   {
      /* Using cursor T000866 */
      pr_default.execute(64, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
      if ( (pr_default.getStatus(64) != 101) )
      {
         RcdFound13 = (short)(1) ;
      }
      else
      {
         RcdFound13 = (short)(0) ;
      }
      pr_default.close(64);
   }

   public void getByPrimaryKey0813( )
   {
      /* Using cursor T00087 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm0813( 53) ;
         RcdFound13 = (short)(1) ;
         initializeNonKey0813( ) ;
         A56ExperienciaLaboralId = T00087_A56ExperienciaLaboralId[0] ;
         A204ExperienciaLaboralEmpresaNombre = T00087_A204ExperienciaLaboralEmpresaNombre[0] ;
         A205ExperienciaLaboralDesde = T00087_A205ExperienciaLaboralDesde[0] ;
         A206ExperienciaLaboralHasta = T00087_A206ExperienciaLaboralHasta[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z56ExperienciaLaboralId = A56ExperienciaLaboralId ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0813( ) ;
         load0813( ) ;
         Gx_mode = sMode13 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound13 = (short)(0) ;
         initializeNonKey0813( ) ;
         sMode13 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0813( ) ;
         Gx_mode = sMode13 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0813( ) ;
      }
      pr_default.close(5);
   }

   public void checkOptimisticConcurrency0813( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00086 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalExperienciaLaboral"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(4) == 101) || ( GXutil.strcmp(Z204ExperienciaLaboralEmpresaNombre, T00086_A204ExperienciaLaboralEmpresaNombre[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z205ExperienciaLaboralDesde), GXutil.resetTime(T00086_A205ExperienciaLaboralDesde[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z206ExperienciaLaboralHasta), GXutil.resetTime(T00086_A206ExperienciaLaboralHasta[0])) ) )
         {
            if ( GXutil.strcmp(Z204ExperienciaLaboralEmpresaNombre, T00086_A204ExperienciaLaboralEmpresaNombre[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ExperienciaLaboralEmpresaNombre");
               GXutil.writeLogRaw("Old: ",Z204ExperienciaLaboralEmpresaNombre);
               GXutil.writeLogRaw("Current: ",T00086_A204ExperienciaLaboralEmpresaNombre[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z205ExperienciaLaboralDesde), GXutil.resetTime(T00086_A205ExperienciaLaboralDesde[0])) ) )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ExperienciaLaboralDesde");
               GXutil.writeLogRaw("Old: ",Z205ExperienciaLaboralDesde);
               GXutil.writeLogRaw("Current: ",T00086_A205ExperienciaLaboralDesde[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z206ExperienciaLaboralHasta), GXutil.resetTime(T00086_A206ExperienciaLaboralHasta[0])) ) )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ExperienciaLaboralHasta");
               GXutil.writeLogRaw("Old: ",Z206ExperienciaLaboralHasta);
               GXutil.writeLogRaw("Current: ",T00086_A206ExperienciaLaboralHasta[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalExperienciaLaboral"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0813( )
   {
      beforeValidate0813( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0813( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0813( 0) ;
         checkOptimisticConcurrency0813( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0813( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0813( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000867 */
                  pr_default.execute(65, new Object[] {Integer.valueOf(A31ProfesionalId), A204ExperienciaLaboralEmpresaNombre, A205ExperienciaLaboralDesde, A206ExperienciaLaboralHasta, A56ExperienciaLaboralId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalExperienciaLaboral");
                  if ( (pr_default.getStatus(65) == 1) )
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
            load0813( ) ;
         }
         endLevel0813( ) ;
      }
      closeExtendedTableCursors0813( ) ;
   }

   public void update0813( )
   {
      beforeValidate0813( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0813( ) ;
      }
      if ( ( nIsMod_13 != 0 ) || ( nIsDirty_13 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0813( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0813( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0813( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000868 */
                     pr_default.execute(66, new Object[] {A204ExperienciaLaboralEmpresaNombre, A205ExperienciaLaboralDesde, A206ExperienciaLaboralHasta, Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalExperienciaLaboral");
                     if ( (pr_default.getStatus(66) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalExperienciaLaboral"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0813( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0813( ) ;
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
            endLevel0813( ) ;
         }
      }
      closeExtendedTableCursors0813( ) ;
   }

   public void deferredUpdate0813( )
   {
   }

   public void delete0813( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0813( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0813( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0813( ) ;
         afterConfirm0813( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0813( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000869 */
               pr_default.execute(67, new Object[] {Integer.valueOf(A31ProfesionalId), A56ExperienciaLaboralId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalExperienciaLaboral");
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
      sMode13 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0813( ) ;
      Gx_mode = sMode13 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0813( )
   {
      standaloneModal0813( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0813( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0813( )
   {
      /* Scan By routine */
      /* Using cursor T000870 */
      pr_default.execute(68, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(68) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A56ExperienciaLaboralId = T000870_A56ExperienciaLaboralId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0813( )
   {
      /* Scan next routine */
      pr_default.readNext(68);
      RcdFound13 = (short)(0) ;
      if ( (pr_default.getStatus(68) != 101) )
      {
         RcdFound13 = (short)(1) ;
         A56ExperienciaLaboralId = T000870_A56ExperienciaLaboralId[0] ;
      }
   }

   public void scanEnd0813( )
   {
      pr_default.close(68);
   }

   public void afterConfirm0813( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0813( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0813( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0813( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0813( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0813( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0813( )
   {
      edtExperienciaLaboralId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralId_Enabled), 5, 0), !bGXsfl_231_Refreshing);
      edtExperienciaLaboralEmpresaNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralEmpresaNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralEmpresaNombre_Enabled), 5, 0), !bGXsfl_231_Refreshing);
      edtExperienciaLaboralDesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralDesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralDesde_Enabled), 5, 0), !bGXsfl_231_Refreshing);
      edtExperienciaLaboralHasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralHasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralHasta_Enabled), 5, 0), !bGXsfl_231_Refreshing);
   }

   public void send_integrity_lvl_hashes0813( )
   {
   }

   public void zm0814( int GX_JID )
   {
      if ( ( GX_JID == 54 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z207PremiosNombre = T00085_A207PremiosNombre[0] ;
            Z208PremiosFecha = T00085_A208PremiosFecha[0] ;
         }
         else
         {
            Z207PremiosNombre = A207PremiosNombre ;
            Z208PremiosFecha = A208PremiosFecha ;
         }
      }
      if ( GX_JID == -54 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z57PremiosId = A57PremiosId ;
         Z207PremiosNombre = A207PremiosNombre ;
         Z208PremiosFecha = A208PremiosFecha ;
         Z209PremiosDescripcion = A209PremiosDescripcion ;
      }
   }

   public void standaloneNotModal0814( )
   {
   }

   public void standaloneModal0814( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A57PremiosId) && ( Gx_BScreen == 0 ) )
      {
         A57PremiosId = java.util.UUID.randomUUID( ) ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtPremiosId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPremiosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosId_Enabled), 5, 0), !bGXsfl_241_Refreshing);
      }
      else
      {
         edtPremiosId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPremiosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosId_Enabled), 5, 0), !bGXsfl_241_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0814( )
   {
      /* Using cursor T000871 */
      pr_default.execute(69, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
      if ( (pr_default.getStatus(69) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A207PremiosNombre = T000871_A207PremiosNombre[0] ;
         A208PremiosFecha = T000871_A208PremiosFecha[0] ;
         A209PremiosDescripcion = T000871_A209PremiosDescripcion[0] ;
         zm0814( -54) ;
      }
      pr_default.close(69);
      onLoadActions0814( ) ;
   }

   public void onLoadActions0814( )
   {
   }

   public void checkExtendedTable0814( )
   {
      nIsDirty_14 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0814( ) ;
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A208PremiosFecha)) || (( GXutil.resetTime(A208PremiosFecha).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A208PremiosFecha), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         GXCCtl = "PREMIOSFECHA_" + sGXsfl_241_idx ;
         httpContext.GX_msglist.addItem("Campo Premios Fecha fuera de rango", "OutOfRange", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtPremiosFecha_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors0814( )
   {
   }

   public void enableDisable0814( )
   {
   }

   public void getKey0814( )
   {
      /* Using cursor T000872 */
      pr_default.execute(70, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
      if ( (pr_default.getStatus(70) != 101) )
      {
         RcdFound14 = (short)(1) ;
      }
      else
      {
         RcdFound14 = (short)(0) ;
      }
      pr_default.close(70);
   }

   public void getByPrimaryKey0814( )
   {
      /* Using cursor T00085 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm0814( 54) ;
         RcdFound14 = (short)(1) ;
         initializeNonKey0814( ) ;
         A57PremiosId = T00085_A57PremiosId[0] ;
         A207PremiosNombre = T00085_A207PremiosNombre[0] ;
         A208PremiosFecha = T00085_A208PremiosFecha[0] ;
         A209PremiosDescripcion = T00085_A209PremiosDescripcion[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z57PremiosId = A57PremiosId ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0814( ) ;
         load0814( ) ;
         Gx_mode = sMode14 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound14 = (short)(0) ;
         initializeNonKey0814( ) ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0814( ) ;
         Gx_mode = sMode14 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0814( ) ;
      }
      pr_default.close(3);
   }

   public void checkOptimisticConcurrency0814( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00084 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalPremios"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z207PremiosNombre, T00084_A207PremiosNombre[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z208PremiosFecha), GXutil.resetTime(T00084_A208PremiosFecha[0])) ) )
         {
            if ( GXutil.strcmp(Z207PremiosNombre, T00084_A207PremiosNombre[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"PremiosNombre");
               GXutil.writeLogRaw("Old: ",Z207PremiosNombre);
               GXutil.writeLogRaw("Current: ",T00084_A207PremiosNombre[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z208PremiosFecha), GXutil.resetTime(T00084_A208PremiosFecha[0])) ) )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"PremiosFecha");
               GXutil.writeLogRaw("Old: ",Z208PremiosFecha);
               GXutil.writeLogRaw("Current: ",T00084_A208PremiosFecha[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalPremios"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0814( )
   {
      beforeValidate0814( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0814( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0814( 0) ;
         checkOptimisticConcurrency0814( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0814( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0814( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000873 */
                  pr_default.execute(71, new Object[] {Integer.valueOf(A31ProfesionalId), A207PremiosNombre, A208PremiosFecha, A209PremiosDescripcion, A57PremiosId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalPremios");
                  if ( (pr_default.getStatus(71) == 1) )
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
            load0814( ) ;
         }
         endLevel0814( ) ;
      }
      closeExtendedTableCursors0814( ) ;
   }

   public void update0814( )
   {
      beforeValidate0814( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0814( ) ;
      }
      if ( ( nIsMod_14 != 0 ) || ( nIsDirty_14 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0814( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0814( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0814( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000874 */
                     pr_default.execute(72, new Object[] {A207PremiosNombre, A208PremiosFecha, A209PremiosDescripcion, Integer.valueOf(A31ProfesionalId), A57PremiosId});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalPremios");
                     if ( (pr_default.getStatus(72) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalPremios"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0814( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0814( ) ;
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
            endLevel0814( ) ;
         }
      }
      closeExtendedTableCursors0814( ) ;
   }

   public void deferredUpdate0814( )
   {
   }

   public void delete0814( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0814( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0814( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0814( ) ;
         afterConfirm0814( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0814( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000875 */
               pr_default.execute(73, new Object[] {Integer.valueOf(A31ProfesionalId), A57PremiosId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalPremios");
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
      sMode14 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0814( ) ;
      Gx_mode = sMode14 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0814( )
   {
      standaloneModal0814( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0814( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0814( )
   {
      /* Scan By routine */
      /* Using cursor T000876 */
      pr_default.execute(74, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound14 = (short)(0) ;
      if ( (pr_default.getStatus(74) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A57PremiosId = T000876_A57PremiosId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0814( )
   {
      /* Scan next routine */
      pr_default.readNext(74);
      RcdFound14 = (short)(0) ;
      if ( (pr_default.getStatus(74) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A57PremiosId = T000876_A57PremiosId[0] ;
      }
   }

   public void scanEnd0814( )
   {
      pr_default.close(74);
   }

   public void afterConfirm0814( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0814( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0814( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0814( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0814( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0814( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0814( )
   {
      edtPremiosId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPremiosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosId_Enabled), 5, 0), !bGXsfl_241_Refreshing);
      edtPremiosNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPremiosNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosNombre_Enabled), 5, 0), !bGXsfl_241_Refreshing);
      edtPremiosFecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPremiosFecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosFecha_Enabled), 5, 0), !bGXsfl_241_Refreshing);
      edtPremiosDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPremiosDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosDescripcion_Enabled), 5, 0), !bGXsfl_241_Refreshing);
   }

   public void send_integrity_lvl_hashes0814( )
   {
   }

   public void zm0815( int GX_JID )
   {
      if ( ( GX_JID == 55 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z210ServiciosNombre = T00083_A210ServiciosNombre[0] ;
         }
         else
         {
            Z210ServiciosNombre = A210ServiciosNombre ;
         }
      }
      if ( GX_JID == -55 )
      {
         Z31ProfesionalId = A31ProfesionalId ;
         Z58ServiciosId = A58ServiciosId ;
         Z210ServiciosNombre = A210ServiciosNombre ;
      }
   }

   public void standaloneNotModal0815( )
   {
   }

   public void standaloneModal0815( )
   {
      if ( isIns( )  && java.util.UUID.fromString("00000000-0000-0000-0000-000000000000").equals(A58ServiciosId) && ( Gx_BScreen == 0 ) )
      {
         A58ServiciosId = java.util.UUID.randomUUID( ) ;
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtServiciosId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtServiciosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServiciosId_Enabled), 5, 0), !bGXsfl_251_Refreshing);
      }
      else
      {
         edtServiciosId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtServiciosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServiciosId_Enabled), 5, 0), !bGXsfl_251_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0815( )
   {
      /* Using cursor T000877 */
      pr_default.execute(75, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
      if ( (pr_default.getStatus(75) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A210ServiciosNombre = T000877_A210ServiciosNombre[0] ;
         zm0815( -55) ;
      }
      pr_default.close(75);
      onLoadActions0815( ) ;
   }

   public void onLoadActions0815( )
   {
   }

   public void checkExtendedTable0815( )
   {
      nIsDirty_15 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0815( ) ;
   }

   public void closeExtendedTableCursors0815( )
   {
   }

   public void enableDisable0815( )
   {
   }

   public void getKey0815( )
   {
      /* Using cursor T000878 */
      pr_default.execute(76, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
      if ( (pr_default.getStatus(76) != 101) )
      {
         RcdFound15 = (short)(1) ;
      }
      else
      {
         RcdFound15 = (short)(0) ;
      }
      pr_default.close(76);
   }

   public void getByPrimaryKey0815( )
   {
      /* Using cursor T00083 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0815( 55) ;
         RcdFound15 = (short)(1) ;
         initializeNonKey0815( ) ;
         A58ServiciosId = T00083_A58ServiciosId[0] ;
         A210ServiciosNombre = T00083_A210ServiciosNombre[0] ;
         Z31ProfesionalId = A31ProfesionalId ;
         Z58ServiciosId = A58ServiciosId ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0815( ) ;
         load0815( ) ;
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound15 = (short)(0) ;
         initializeNonKey0815( ) ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0815( ) ;
         Gx_mode = sMode15 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0815( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0815( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00082 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalServicios"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z210ServiciosNombre, T00082_A210ServiciosNombre[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z210ServiciosNombre, T00082_A210ServiciosNombre[0]) != 0 )
            {
               GXutil.writeLogln("profesional:[seudo value changed for attri]"+"ServiciosNombre");
               GXutil.writeLogRaw("Old: ",Z210ServiciosNombre);
               GXutil.writeLogRaw("Current: ",T00082_A210ServiciosNombre[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ProfesionalServicios"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0815( 0) ;
         checkOptimisticConcurrency0815( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0815( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0815( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000879 */
                  pr_default.execute(77, new Object[] {Integer.valueOf(A31ProfesionalId), A210ServiciosNombre, A58ServiciosId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalServicios");
                  if ( (pr_default.getStatus(77) == 1) )
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
            load0815( ) ;
         }
         endLevel0815( ) ;
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void update0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( ( nIsMod_15 != 0 ) || ( nIsDirty_15 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0815( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0815( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0815( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000880 */
                     pr_default.execute(78, new Object[] {A210ServiciosNombre, Integer.valueOf(A31ProfesionalId), A58ServiciosId});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalServicios");
                     if ( (pr_default.getStatus(78) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ProfesionalServicios"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0815( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0815( ) ;
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
            endLevel0815( ) ;
         }
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void deferredUpdate0815( )
   {
   }

   public void delete0815( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0815( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0815( ) ;
         afterConfirm0815( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0815( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000881 */
               pr_default.execute(79, new Object[] {Integer.valueOf(A31ProfesionalId), A58ServiciosId});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ProfesionalServicios");
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
      sMode15 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0815( ) ;
      Gx_mode = sMode15 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0815( )
   {
      standaloneModal0815( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0815( )
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

   public void scanStart0815( )
   {
      /* Scan By routine */
      /* Using cursor T000882 */
      pr_default.execute(80, new Object[] {Integer.valueOf(A31ProfesionalId)});
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(80) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A58ServiciosId = T000882_A58ServiciosId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0815( )
   {
      /* Scan next routine */
      pr_default.readNext(80);
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(80) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A58ServiciosId = T000882_A58ServiciosId[0] ;
      }
   }

   public void scanEnd0815( )
   {
      pr_default.close(80);
   }

   public void afterConfirm0815( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0815( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0815( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0815( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0815( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0815( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0815( )
   {
      edtServiciosId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServiciosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServiciosId_Enabled), 5, 0), !bGXsfl_251_Refreshing);
      edtServiciosNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtServiciosNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServiciosNombre_Enabled), 5, 0), !bGXsfl_251_Refreshing);
   }

   public void send_integrity_lvl_hashes0815( )
   {
   }

   public void send_integrity_lvl_hashes089( )
   {
   }

   public void subsflControlProps_18410( )
   {
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_184_idx ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO_"+sGXsfl_184_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_184_idx ;
      lblTitlesede_Internalname = "TITLESEDE_"+sGXsfl_184_idx ;
      subGridprofesional_especialidad_sede_Internalname = "GRIDPROFESIONAL_ESPECIALIDAD_SEDE_"+sGXsfl_184_idx ;
   }

   public void subsflControlProps_fel_18410( )
   {
      edtEspecialidadId_Internalname = "ESPECIALIDADID_"+sGXsfl_184_fel_idx ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO_"+sGXsfl_184_fel_idx ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE_"+sGXsfl_184_fel_idx ;
      lblTitlesede_Internalname = "TITLESEDE_"+sGXsfl_184_fel_idx ;
      subGridprofesional_especialidad_sede_Internalname = "GRIDPROFESIONAL_ESPECIALIDAD_SEDE_"+sGXsfl_184_fel_idx ;
   }

   public void addRow0810( )
   {
      nRC_GXsfl_209 = 0 ;
      nGXsfl_184_idx = (int)(nGXsfl_184_idx+1) ;
      sGXsfl_184_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_184_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_18410( ) ;
      sendRow0810( ) ;
   }

   public void sendRow0810( )
   {
      Grid1Row = GXWebRow.GetNew(context) ;
      if ( subGrid1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGrid1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
         {
            subGrid1_Linesclass = subGrid1_Class+"Odd" ;
         }
      }
      else if ( subGrid1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGrid1_Backstyle = (byte)(0) ;
         subGrid1_Backcolor = subGrid1_Allbackcolor ;
         if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
         {
            subGrid1_Linesclass = subGrid1_Class+"Uniform" ;
         }
      }
      else if ( subGrid1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGrid1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
         {
            subGrid1_Linesclass = subGrid1_Class+"Odd" ;
         }
         subGrid1_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGrid1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGrid1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_184_idx) % (2))) == 0 )
         {
            subGrid1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Even" ;
            }
         }
         else
         {
            subGrid1_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGrid1_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_184_idx+"\">") ;
      }
      if ( GRID1_IsPaging == 0 )
      {
         GXCCtl = "GRIDPROFESIONAL_ESPECIALIDAD_SEDE_nFirstRecordOnPage_" + sGXsfl_184_idx ;
         GRIDPROFESIONAL_ESPECIALIDAD_SEDE_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".") ;
      }
      else
      {
         GRIDPROFESIONAL_ESPECIALIDAD_SEDE_nFirstRecordOnPage = 0 ;
      }
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid1table_Internalname+"_"+sGXsfl_184_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable2_Internalname+"_"+sGXsfl_184_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","LevelTable","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtEspecialidadId_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtEspecialidadId_Internalname,"Especialidad Id","col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_10_" + sGXsfl_184_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 193,'',false,'" + sGXsfl_184_idx + "',184)\"" ;
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadId_Internalname,GXutil.ltrim( localUtil.ntoc( A32EspecialidadId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A32EspecialidadId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,193);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtEspecialidadId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(184),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtEspecialidadCodigo_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtEspecialidadCodigo_Internalname,"Especialidad Codigo","col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadCodigo_Internalname,A140EspecialidadCodigo,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtEspecialidadCodigo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(184),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtEspecialidadNombre_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid1Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtEspecialidadNombre_Internalname,"Especialidad Nombre","col-sm-3 AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEspecialidadNombre_Internalname,A71EspecialidadNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEspecialidadNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtEspecialidadNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(184),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9 col-sm-offset-3","left","top","","","div"});
      /* Text block */
      Grid1Row.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTitlesede_Internalname,"Sede","","",lblTitlesede_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","Title",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid1Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-9 col-sm-offset-3","left","top","","","div"});
      /*  Child Grid Control  */
      Grid1Row.AddColumnProperties("subfile", -1, isAjaxCallMode( ), new Object[] {"Gridprofesional_especialidad_sedeContainer"});
      if ( isAjaxCallMode( ) )
      {
         Gridprofesional_especialidad_sedeContainer = new com.genexus.webpanels.GXWebGrid(context);
      }
      else
      {
         Gridprofesional_especialidad_sedeContainer.Clear();
      }
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("GridName", "Gridprofesional_especialidad_sede");
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Header", subGridprofesional_especialidad_sede_Header);
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Class", "Grid");
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("CmpContext", "");
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("InMasterPage", "false");
      Gridprofesional_especialidad_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddColumnProperties(Gridprofesional_especialidad_sedeColumn);
      Gridprofesional_especialidad_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Value", GXutil.rtrim( A54SedeTipoConsulta));
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbSedeTipoConsulta.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddColumnProperties(Gridprofesional_especialidad_sedeColumn);
      Gridprofesional_especialidad_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Value", A75SedeNombre);
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddColumnProperties(Gridprofesional_especialidad_sedeColumn);
      Gridprofesional_especialidad_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Value", A80ClinicaNombreAbreviado);
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtClinicaNombreAbreviado_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddColumnProperties(Gridprofesional_especialidad_sedeColumn);
      Gridprofesional_especialidad_sedeColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A199CostoConsulta, (byte)(6), (byte)(2), ".", "")));
      Gridprofesional_especialidad_sedeColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddColumnProperties(Gridprofesional_especialidad_sedeColumn);
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridprofesional_especialidad_sedeContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridprofesional_especialidad_sede_Collapsed, (byte)(1), (byte)(0), ".", "")));
      nGXsfl_209_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount11 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_11 = (short)(1) ;
            scanStart0811( ) ;
            while ( RcdFound11 != 0 )
            {
               init_level_properties11( ) ;
               getByPrimaryKey0811( ) ;
               addRow0811( ) ;
               scanNext0811( ) ;
            }
            scanEnd0811( ) ;
            nBlankRcdCount11 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0811( ) ;
         standaloneModal0811( ) ;
         sMode11 = Gx_mode ;
         while ( nGXsfl_209_idx < nRC_GXsfl_209 )
         {
            bGXsfl_209_Refreshing = true ;
            readRow0811( ) ;
            edtSedeId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SEDEID_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), !bGXsfl_209_Refreshing);
            cmbSedeTipoConsulta.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SEDETIPOCONSULTA_"+sGXsfl_209_idx+"Enabled"), ",", ".")) );
            httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipoConsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeTipoConsulta.getEnabled(), 5, 0), !bGXsfl_209_Refreshing);
            edtSedeNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SEDENOMBRE_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtSedeNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeNombre_Enabled), 5, 0), !bGXsfl_209_Refreshing);
            edtClinicaNombreAbreviado_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLINICANOMBREABREVIADO_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtClinicaNombreAbreviado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtClinicaNombreAbreviado_Enabled), 5, 0), !bGXsfl_209_Refreshing);
            edtCostoConsulta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COSTOCONSULTA_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCostoConsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCostoConsulta_Enabled), 5, 0), !bGXsfl_209_Refreshing);
            if ( ( nRcdExists_11 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0811( ) ;
            }
            sendRow0811( ) ;
            bGXsfl_209_Refreshing = false ;
         }
         Gx_mode = sMode11 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount11 = (short)(5) ;
         nRcdExists_11 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0811( ) ;
            while ( RcdFound11 != 0 )
            {
               sGXsfl_209_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_209_idx+1), 4, 0), (short)(4), "0") + sGXsfl_184_idx ;
               subsflControlProps_20911( ) ;
               init_level_properties11( ) ;
               standaloneNotModal0811( ) ;
               getByPrimaryKey0811( ) ;
               standaloneModal0811( ) ;
               addRow0811( ) ;
               scanNext0811( ) ;
            }
            scanEnd0811( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode11 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_209_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_209_idx+1), 4, 0), (short)(4), "0") + sGXsfl_184_idx ;
      subsflControlProps_20911( ) ;
      initAll0811( ) ;
      init_level_properties11( ) ;
      nRcdExists_11 = (short)(0) ;
      nIsMod_11 = (short)(0) ;
      nRcdDeleted_11 = (short)(0) ;
      if ( ( CommonUtil.decimalVal( EvtGridId, ".").add(CommonUtil.decimalVal( EvtRowId, ".")).doubleValue() == 0 ) || ( 184 == CommonUtil.decimalVal( EvtGridId, ".").doubleValue() ) && ( DecimalUtil.compareTo(CommonUtil.decimalVal( EvtRowId, "."), CommonUtil.decimalVal( sGXsfl_184_idx, ".")) == 0 ) )
      {
         nBlankRcdCount11 = (short)(nBlankRcdUsr11+nBlankRcdCount11) ;
      }
      fRowAdded = 0 ;
      while ( nBlankRcdCount11 > 0 )
      {
         standaloneNotModal0811( ) ;
         standaloneModal0811( ) ;
         addRow0811( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtSedeId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount11 = (short)(nBlankRcdCount11-1) ;
      }
      Gx_mode = sMode11 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      if ( ! isAjaxCallMode( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_especialidad_sedeContainerData"+"_"+sGXsfl_184_idx, Gridprofesional_especialidad_sedeContainer.ToJavascriptSource());
      }
      if ( isAjaxCallMode( ) )
      {
         Grid1Row.AddGrid("Gridprofesional_especialidad_sede", Gridprofesional_especialidad_sedeContainer);
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Gridprofesional_especialidad_sedeContainerData"+"V_"+sGXsfl_184_idx, Gridprofesional_especialidad_sedeContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridprofesional_especialidad_sedeContainerData"+"V_"+sGXsfl_184_idx+"\" value='"+Gridprofesional_especialidad_sedeContainer.GridValuesHidden()+"'/>") ;
      }
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid1Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      httpContext.ajax_sending_grid_row(Grid1Row);
      send_integrity_lvl_hashes0810( ) ;
      GXCCtl = "Z32EspecialidadId_" + sGXsfl_184_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z32EspecialidadId, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRC_GXsfl_209_" + sGXsfl_184_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nGXsfl_209_idx, (byte)(8), (byte)(0), ",", "")));
      GXCCtl = "nRcdDeleted_10_" + sGXsfl_184_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_10_" + sGXsfl_184_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_10_" + sGXsfl_184_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "vGXBSCREEN_" + sGXsfl_184_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      GXCCtl = "CLINICAID_" + sGXsfl_184_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ESPECIALIDADID_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ESPECIALIDADCODIGO_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadCodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "ESPECIALIDADNOMBRE_"+sGXsfl_184_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEspecialidadNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      GRIDPROFESIONAL_ESPECIALIDAD_SEDE_nFirstRecordOnPage = 0 ;
      GRIDPROFESIONAL_ESPECIALIDAD_SEDE_nCurrentRecord = 0 ;
      /* End of Columns property logic. */
      Grid1Container.AddRow(Grid1Row);
   }

   public void readRow0810( )
   {
      nGXsfl_184_idx = (int)(nGXsfl_184_idx+1) ;
      sGXsfl_184_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_184_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_18410( ) ;
      edtEspecialidadId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESPECIALIDADID_"+sGXsfl_184_idx+"Enabled"), ",", ".")) ;
      edtEspecialidadCodigo_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESPECIALIDADCODIGO_"+sGXsfl_184_idx+"Enabled"), ",", ".")) ;
      edtEspecialidadNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESPECIALIDADNOMBRE_"+sGXsfl_184_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".") > 9999 ) ) )
      {
         GXCCtl = "ESPECIALIDADID_" + sGXsfl_184_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
         wbErr = true ;
         A32EspecialidadId = (short)(0) ;
      }
      else
      {
         A32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( edtEspecialidadId_Internalname), ",", ".")) ;
      }
      A140EspecialidadCodigo = httpContext.cgiGet( edtEspecialidadCodigo_Internalname) ;
      A71EspecialidadNombre = httpContext.cgiGet( edtEspecialidadNombre_Internalname) ;
      GXCCtl = "Z32EspecialidadId_" + sGXsfl_184_idx ;
      Z32EspecialidadId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRC_GXsfl_209_" + sGXsfl_184_idx ;
      nRC_GXsfl_209 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdDeleted_10_" + sGXsfl_184_idx ;
      nRcdDeleted_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_10_" + sGXsfl_184_idx ;
      nRcdExists_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_10_" + sGXsfl_184_idx ;
      nIsMod_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "vGXBSCREEN_" + sGXsfl_184_idx ;
      Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "CLINICAID_" + sGXsfl_184_idx ;
      A28ClinicaId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRC_GXsfl_209_" + sGXsfl_184_idx ;
      nRC_GXsfl_209 = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void subsflControlProps_20911( )
   {
      edtSedeId_Internalname = "SEDEID_"+sGXsfl_209_idx ;
      cmbSedeTipoConsulta.setInternalname( "SEDETIPOCONSULTA_"+sGXsfl_209_idx );
      edtSedeNombre_Internalname = "SEDENOMBRE_"+sGXsfl_209_idx ;
      edtClinicaNombreAbreviado_Internalname = "CLINICANOMBREABREVIADO_"+sGXsfl_209_idx ;
      edtCostoConsulta_Internalname = "COSTOCONSULTA_"+sGXsfl_209_idx ;
   }

   public void subsflControlProps_fel_20911( )
   {
      edtSedeId_Internalname = "SEDEID_"+sGXsfl_209_fel_idx ;
      cmbSedeTipoConsulta.setInternalname( "SEDETIPOCONSULTA_"+sGXsfl_209_fel_idx );
      edtSedeNombre_Internalname = "SEDENOMBRE_"+sGXsfl_209_fel_idx ;
      edtClinicaNombreAbreviado_Internalname = "CLINICANOMBREABREVIADO_"+sGXsfl_209_fel_idx ;
      edtCostoConsulta_Internalname = "COSTOCONSULTA_"+sGXsfl_209_fel_idx ;
   }

   public void addRow0811( )
   {
      nGXsfl_209_idx = (int)(nGXsfl_209_idx+1) ;
      sGXsfl_209_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_209_idx), 4, 0), (short)(4), "0") + sGXsfl_184_idx ;
      subsflControlProps_20911( ) ;
      sendRow0811( ) ;
   }

   public void sendRow0811( )
   {
      Gridprofesional_especialidad_sedeRow = GXWebRow.GetNew(context) ;
      if ( subGridprofesional_especialidad_sede_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridprofesional_especialidad_sede_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridprofesional_especialidad_sede_Class, "") != 0 )
         {
            subGridprofesional_especialidad_sede_Linesclass = subGridprofesional_especialidad_sede_Class+"Odd" ;
         }
      }
      else if ( subGridprofesional_especialidad_sede_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridprofesional_especialidad_sede_Backstyle = (byte)(0) ;
         subGridprofesional_especialidad_sede_Backcolor = subGridprofesional_especialidad_sede_Allbackcolor ;
         if ( GXutil.strcmp(subGridprofesional_especialidad_sede_Class, "") != 0 )
         {
            subGridprofesional_especialidad_sede_Linesclass = subGridprofesional_especialidad_sede_Class+"Uniform" ;
         }
      }
      else if ( subGridprofesional_especialidad_sede_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridprofesional_especialidad_sede_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridprofesional_especialidad_sede_Class, "") != 0 )
         {
            subGridprofesional_especialidad_sede_Linesclass = subGridprofesional_especialidad_sede_Class+"Odd" ;
         }
         subGridprofesional_especialidad_sede_Backcolor = (int)(0x0) ;
      }
      else if ( subGridprofesional_especialidad_sede_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridprofesional_especialidad_sede_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_209_idx) % (2))) == 0 )
         {
            subGridprofesional_especialidad_sede_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_especialidad_sede_Class, "") != 0 )
            {
               subGridprofesional_especialidad_sede_Linesclass = subGridprofesional_especialidad_sede_Class+"Even" ;
            }
         }
         else
         {
            subGridprofesional_especialidad_sede_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_especialidad_sede_Class, "") != 0 )
            {
               subGridprofesional_especialidad_sede_Linesclass = subGridprofesional_especialidad_sede_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_11_" + sGXsfl_209_idx + "',1);gx.fn.setControlValue('nIsMod_10_" + sGXsfl_184_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 210,'',false,'" + sGXsfl_209_idx + "',209)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_especialidad_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSedeId_Internalname,GXutil.ltrim( localUtil.ntoc( A30SedeId, (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A30SedeId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,210);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSedeId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtSedeId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(209),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id4","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_11_" + sGXsfl_209_idx + "',1);gx.fn.setControlValue('nIsMod_10_" + sGXsfl_184_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 211,'',false,'" + sGXsfl_209_idx + "',209)\"" ;
      GXCCtl = "SEDETIPOCONSULTA_" + sGXsfl_209_idx ;
      cmbSedeTipoConsulta.setName( GXCCtl );
      cmbSedeTipoConsulta.setWebtags( "" );
      cmbSedeTipoConsulta.addItem("", "Seleccione tipo de consulta", (short)(0));
      cmbSedeTipoConsulta.addItem("V", "Virtual", (short)(0));
      cmbSedeTipoConsulta.addItem("P", "En consultorio", (short)(0));
      cmbSedeTipoConsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbSedeTipoConsulta.getItemCount() > 0 )
      {
         if ( (GXutil.strcmp("", A54SedeTipoConsulta)==0) )
         {
            A54SedeTipoConsulta = "V" ;
         }
      }
      /* ComboBox */
      Gridprofesional_especialidad_sedeRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbSedeTipoConsulta,cmbSedeTipoConsulta.getInternalname(),GXutil.rtrim( A54SedeTipoConsulta),Integer.valueOf(1),cmbSedeTipoConsulta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbSedeTipoConsulta.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,211);\"","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbSedeTipoConsulta.setValue( GXutil.rtrim( A54SedeTipoConsulta) );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipoConsulta.getInternalname(), "Values", cmbSedeTipoConsulta.ToJavascriptSource(), !bGXsfl_209_Refreshing);
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridprofesional_especialidad_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSedeNombre_Internalname,A75SedeNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSedeNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtSedeNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(209),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridprofesional_especialidad_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtClinicaNombreAbreviado_Internalname,A80ClinicaNombreAbreviado,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtClinicaNombreAbreviado_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtClinicaNombreAbreviado_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(209),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_11_" + sGXsfl_209_idx + "',1);gx.fn.setControlValue('nIsMod_10_" + sGXsfl_184_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 214,'',false,'" + sGXsfl_209_idx + "',209)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_especialidad_sedeRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCostoConsulta_Internalname,GXutil.ltrim( localUtil.ntoc( A199CostoConsulta, (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( ((edtCostoConsulta_Enabled!=0) ? localUtil.format( A199CostoConsulta, "ZZ9.99") : localUtil.format( A199CostoConsulta, "ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,214);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCostoConsulta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCostoConsulta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(209),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridprofesional_especialidad_sedeRow);
      send_integrity_lvl_hashes0811( ) ;
      GXCCtl = "Z30SedeId_" + sGXsfl_209_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z30SedeId, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "Z54SedeTipoConsulta_" + sGXsfl_209_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z54SedeTipoConsulta));
      GXCCtl = "Z199CostoConsulta_" + sGXsfl_209_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z199CostoConsulta, (byte)(6), (byte)(2), ",", "")));
      GXCCtl = "nRcdDeleted_11_" + sGXsfl_209_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_11, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_11_" + sGXsfl_209_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_11, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_11_" + sGXsfl_209_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_11, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SEDEID_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SEDETIPOCONSULTA_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbSedeTipoConsulta.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SEDENOMBRE_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtSedeNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "CLINICANOMBREABREVIADO_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtClinicaNombreAbreviado_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "COSTOCONSULTA_"+sGXsfl_209_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCostoConsulta_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridprofesional_especialidad_sedeContainer.AddRow(Gridprofesional_especialidad_sedeRow);
   }

   public void readRow0811( )
   {
      nGXsfl_209_idx = (int)(nGXsfl_209_idx+1) ;
      sGXsfl_209_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_209_idx), 4, 0), (short)(4), "0") + sGXsfl_184_idx ;
      subsflControlProps_20911( ) ;
      edtSedeId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SEDEID_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
      cmbSedeTipoConsulta.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "SEDETIPOCONSULTA_"+sGXsfl_209_idx+"Enabled"), ",", ".")) );
      edtSedeNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SEDENOMBRE_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
      edtClinicaNombreAbreviado_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CLINICANOMBREABREVIADO_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
      edtCostoConsulta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COSTOCONSULTA_"+sGXsfl_209_idx+"Enabled"), ",", ".")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".") > 9999 ) ) )
      {
         GXCCtl = "SEDEID_" + sGXsfl_209_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
         wbErr = true ;
         A30SedeId = (short)(0) ;
      }
      else
      {
         A30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( edtSedeId_Internalname), ",", ".")) ;
      }
      cmbSedeTipoConsulta.setName( cmbSedeTipoConsulta.getInternalname() );
      cmbSedeTipoConsulta.setValue( httpContext.cgiGet( cmbSedeTipoConsulta.getInternalname()) );
      A54SedeTipoConsulta = httpContext.cgiGet( cmbSedeTipoConsulta.getInternalname()) ;
      A75SedeNombre = httpContext.cgiGet( edtSedeNombre_Internalname) ;
      A80ClinicaNombreAbreviado = httpContext.cgiGet( edtClinicaNombreAbreviado_Internalname) ;
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtCostoConsulta_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtCostoConsulta_Internalname)), DecimalUtil.stringToDec("999.99")) > 0 ) ) )
      {
         GXCCtl = "COSTOCONSULTA_" + sGXsfl_209_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCostoConsulta_Internalname ;
         wbErr = true ;
         A199CostoConsulta = DecimalUtil.ZERO ;
      }
      else
      {
         A199CostoConsulta = localUtil.ctond( httpContext.cgiGet( edtCostoConsulta_Internalname)) ;
      }
      GXCCtl = "Z30SedeId_" + sGXsfl_209_idx ;
      Z30SedeId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "Z54SedeTipoConsulta_" + sGXsfl_209_idx ;
      Z54SedeTipoConsulta = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z199CostoConsulta_" + sGXsfl_209_idx ;
      Z199CostoConsulta = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_11_" + sGXsfl_209_idx ;
      nRcdDeleted_11 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_11_" + sGXsfl_209_idx ;
      nRcdExists_11 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_11_" + sGXsfl_209_idx ;
      nIsMod_11 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void subsflControlProps_22012( )
   {
      edtEducacionId_Internalname = "EDUCACIONID_"+sGXsfl_220_idx ;
      edtEducacionNombreInstitucion_Internalname = "EDUCACIONNOMBREINSTITUCION_"+sGXsfl_220_idx ;
      edtEducacionDesde_Internalname = "EDUCACIONDESDE_"+sGXsfl_220_idx ;
      edtEducacionHasta_Internalname = "EDUCACIONHASTA_"+sGXsfl_220_idx ;
      edtEducacionPaisDescripcion_Internalname = "EDUCACIONPAISDESCRIPCION_"+sGXsfl_220_idx ;
   }

   public void subsflControlProps_fel_22012( )
   {
      edtEducacionId_Internalname = "EDUCACIONID_"+sGXsfl_220_fel_idx ;
      edtEducacionNombreInstitucion_Internalname = "EDUCACIONNOMBREINSTITUCION_"+sGXsfl_220_fel_idx ;
      edtEducacionDesde_Internalname = "EDUCACIONDESDE_"+sGXsfl_220_fel_idx ;
      edtEducacionHasta_Internalname = "EDUCACIONHASTA_"+sGXsfl_220_fel_idx ;
      edtEducacionPaisDescripcion_Internalname = "EDUCACIONPAISDESCRIPCION_"+sGXsfl_220_fel_idx ;
   }

   public void addRow0812( )
   {
      nGXsfl_220_idx = (int)(nGXsfl_220_idx+1) ;
      sGXsfl_220_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_220_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_22012( ) ;
      sendRow0812( ) ;
   }

   public void sendRow0812( )
   {
      Gridprofesional_educacionRow = GXWebRow.GetNew(context) ;
      if ( subGridprofesional_educacion_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridprofesional_educacion_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridprofesional_educacion_Class, "") != 0 )
         {
            subGridprofesional_educacion_Linesclass = subGridprofesional_educacion_Class+"Odd" ;
         }
      }
      else if ( subGridprofesional_educacion_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridprofesional_educacion_Backstyle = (byte)(0) ;
         subGridprofesional_educacion_Backcolor = subGridprofesional_educacion_Allbackcolor ;
         if ( GXutil.strcmp(subGridprofesional_educacion_Class, "") != 0 )
         {
            subGridprofesional_educacion_Linesclass = subGridprofesional_educacion_Class+"Uniform" ;
         }
      }
      else if ( subGridprofesional_educacion_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridprofesional_educacion_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridprofesional_educacion_Class, "") != 0 )
         {
            subGridprofesional_educacion_Linesclass = subGridprofesional_educacion_Class+"Odd" ;
         }
         subGridprofesional_educacion_Backcolor = (int)(0x0) ;
      }
      else if ( subGridprofesional_educacion_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridprofesional_educacion_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_220_idx) % (2))) == 0 )
         {
            subGridprofesional_educacion_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_educacion_Class, "") != 0 )
            {
               subGridprofesional_educacion_Linesclass = subGridprofesional_educacion_Class+"Even" ;
            }
         }
         else
         {
            subGridprofesional_educacion_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_educacion_Class, "") != 0 )
            {
               subGridprofesional_educacion_Linesclass = subGridprofesional_educacion_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_220_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 221,'',false,'" + sGXsfl_220_idx + "',220)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_educacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEducacionId_Internalname,A55EducacionId.toString(),A55EducacionId.toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,221);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEducacionId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtEducacionId_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(220),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_220_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 222,'',false,'" + sGXsfl_220_idx + "',220)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_educacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEducacionNombreInstitucion_Internalname,A200EducacionNombreInstitucion,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,222);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEducacionNombreInstitucion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtEducacionNombreInstitucion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(220),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_220_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 223,'',false,'" + sGXsfl_220_idx + "',220)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_educacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEducacionDesde_Internalname,localUtil.format(A201EducacionDesde, "99/99/99"),localUtil.format( A201EducacionDesde, "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,223);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEducacionDesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtEducacionDesde_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(220),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_220_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 224,'',false,'" + sGXsfl_220_idx + "',220)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_educacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEducacionHasta_Internalname,localUtil.format(A202EducacionHasta, "99/99/99"),localUtil.format( A202EducacionHasta, "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,224);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEducacionHasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtEducacionHasta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(220),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_12_" + sGXsfl_220_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 225,'',false,'" + sGXsfl_220_idx + "',220)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_educacionRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEducacionPaisDescripcion_Internalname,A203EducacionPaisDescripcion,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,225);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEducacionPaisDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtEducacionPaisDescripcion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(220),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridprofesional_educacionRow);
      send_integrity_lvl_hashes0812( ) ;
      GXCCtl = "Z55EducacionId_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z55EducacionId.toString());
      GXCCtl = "Z200EducacionNombreInstitucion_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z200EducacionNombreInstitucion);
      GXCCtl = "Z201EducacionDesde_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z201EducacionDesde, 0, "/"));
      GXCCtl = "Z202EducacionHasta_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z202EducacionHasta, 0, "/"));
      GXCCtl = "Z203EducacionPaisDescripcion_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z203EducacionPaisDescripcion);
      GXCCtl = "nRcdDeleted_12_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_12, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_12_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_12, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_12_" + sGXsfl_220_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_12, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EDUCACIONID_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EDUCACIONNOMBREINSTITUCION_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionNombreInstitucion_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EDUCACIONDESDE_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EDUCACIONHASTA_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EDUCACIONPAISDESCRIPCION_"+sGXsfl_220_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEducacionPaisDescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridprofesional_educacionContainer.AddRow(Gridprofesional_educacionRow);
   }

   public void readRow0812( )
   {
      nGXsfl_220_idx = (int)(nGXsfl_220_idx+1) ;
      sGXsfl_220_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_220_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_22012( ) ;
      edtEducacionId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONID_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
      edtEducacionNombreInstitucion_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONNOMBREINSTITUCION_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
      edtEducacionDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONDESDE_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
      edtEducacionHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONHASTA_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
      edtEducacionPaisDescripcion_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EDUCACIONPAISDESCRIPCION_"+sGXsfl_220_idx+"Enabled"), ",", ".")) ;
      if ( GXutil.strcmp(httpContext.cgiGet( edtEducacionId_Internalname), "") == 0 )
      {
         A55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      }
      else
      {
         try
         {
            A55EducacionId = GXutil.strToGuid(httpContext.cgiGet( edtEducacionId_Internalname)) ;
         }
         catch ( IllegalArgumentException  e)
         {
            GXCCtl = "EDUCACIONID_" + sGXsfl_220_idx ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_invalidguid"), 1, GXCCtl);
            AnyError = (short)(1) ;
            GX_FocusControl = edtEducacionId_Internalname ;
            wbErr = true ;
         }
      }
      A200EducacionNombreInstitucion = httpContext.cgiGet( edtEducacionNombreInstitucion_Internalname) ;
      if ( localUtil.vcdate( httpContext.cgiGet( edtEducacionDesde_Internalname), (byte)(3)) == 0 )
      {
         GXCCtl = "EDUCACIONDESDE_" + sGXsfl_220_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionDesde_Internalname ;
         wbErr = true ;
         A201EducacionDesde = GXutil.nullDate() ;
      }
      else
      {
         A201EducacionDesde = localUtil.ctod( httpContext.cgiGet( edtEducacionDesde_Internalname), 3) ;
      }
      if ( localUtil.vcdate( httpContext.cgiGet( edtEducacionHasta_Internalname), (byte)(3)) == 0 )
      {
         GXCCtl = "EDUCACIONHASTA_" + sGXsfl_220_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEducacionHasta_Internalname ;
         wbErr = true ;
         A202EducacionHasta = GXutil.nullDate() ;
      }
      else
      {
         A202EducacionHasta = localUtil.ctod( httpContext.cgiGet( edtEducacionHasta_Internalname), 3) ;
      }
      A203EducacionPaisDescripcion = httpContext.cgiGet( edtEducacionPaisDescripcion_Internalname) ;
      GXCCtl = "Z55EducacionId_" + sGXsfl_220_idx ;
      Z55EducacionId = GXutil.strToGuid(httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z200EducacionNombreInstitucion_" + sGXsfl_220_idx ;
      Z200EducacionNombreInstitucion = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z201EducacionDesde_" + sGXsfl_220_idx ;
      Z201EducacionDesde = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z202EducacionHasta_" + sGXsfl_220_idx ;
      Z202EducacionHasta = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z203EducacionPaisDescripcion_" + sGXsfl_220_idx ;
      Z203EducacionPaisDescripcion = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_12_" + sGXsfl_220_idx ;
      nRcdDeleted_12 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_12_" + sGXsfl_220_idx ;
      nRcdExists_12 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_12_" + sGXsfl_220_idx ;
      nIsMod_12 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void subsflControlProps_23113( )
   {
      edtExperienciaLaboralId_Internalname = "EXPERIENCIALABORALID_"+sGXsfl_231_idx ;
      edtExperienciaLaboralEmpresaNombre_Internalname = "EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_231_idx ;
      edtExperienciaLaboralDesde_Internalname = "EXPERIENCIALABORALDESDE_"+sGXsfl_231_idx ;
      edtExperienciaLaboralHasta_Internalname = "EXPERIENCIALABORALHASTA_"+sGXsfl_231_idx ;
   }

   public void subsflControlProps_fel_23113( )
   {
      edtExperienciaLaboralId_Internalname = "EXPERIENCIALABORALID_"+sGXsfl_231_fel_idx ;
      edtExperienciaLaboralEmpresaNombre_Internalname = "EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_231_fel_idx ;
      edtExperienciaLaboralDesde_Internalname = "EXPERIENCIALABORALDESDE_"+sGXsfl_231_fel_idx ;
      edtExperienciaLaboralHasta_Internalname = "EXPERIENCIALABORALHASTA_"+sGXsfl_231_fel_idx ;
   }

   public void addRow0813( )
   {
      nGXsfl_231_idx = (int)(nGXsfl_231_idx+1) ;
      sGXsfl_231_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_231_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_23113( ) ;
      sendRow0813( ) ;
   }

   public void sendRow0813( )
   {
      Gridprofesional_experiencialaboralRow = GXWebRow.GetNew(context) ;
      if ( subGridprofesional_experiencialaboral_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridprofesional_experiencialaboral_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridprofesional_experiencialaboral_Class, "") != 0 )
         {
            subGridprofesional_experiencialaboral_Linesclass = subGridprofesional_experiencialaboral_Class+"Odd" ;
         }
      }
      else if ( subGridprofesional_experiencialaboral_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridprofesional_experiencialaboral_Backstyle = (byte)(0) ;
         subGridprofesional_experiencialaboral_Backcolor = subGridprofesional_experiencialaboral_Allbackcolor ;
         if ( GXutil.strcmp(subGridprofesional_experiencialaboral_Class, "") != 0 )
         {
            subGridprofesional_experiencialaboral_Linesclass = subGridprofesional_experiencialaboral_Class+"Uniform" ;
         }
      }
      else if ( subGridprofesional_experiencialaboral_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridprofesional_experiencialaboral_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridprofesional_experiencialaboral_Class, "") != 0 )
         {
            subGridprofesional_experiencialaboral_Linesclass = subGridprofesional_experiencialaboral_Class+"Odd" ;
         }
         subGridprofesional_experiencialaboral_Backcolor = (int)(0x0) ;
      }
      else if ( subGridprofesional_experiencialaboral_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridprofesional_experiencialaboral_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_231_idx) % (2))) == 0 )
         {
            subGridprofesional_experiencialaboral_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_experiencialaboral_Class, "") != 0 )
            {
               subGridprofesional_experiencialaboral_Linesclass = subGridprofesional_experiencialaboral_Class+"Even" ;
            }
         }
         else
         {
            subGridprofesional_experiencialaboral_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_experiencialaboral_Class, "") != 0 )
            {
               subGridprofesional_experiencialaboral_Linesclass = subGridprofesional_experiencialaboral_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_13_" + sGXsfl_231_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 232,'',false,'" + sGXsfl_231_idx + "',231)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_experiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtExperienciaLaboralId_Internalname,A56ExperienciaLaboralId.toString(),A56ExperienciaLaboralId.toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,232);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtExperienciaLaboralId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtExperienciaLaboralId_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(231),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_13_" + sGXsfl_231_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 233,'',false,'" + sGXsfl_231_idx + "',231)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_experiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtExperienciaLaboralEmpresaNombre_Internalname,A204ExperienciaLaboralEmpresaNombre,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,233);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtExperienciaLaboralEmpresaNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtExperienciaLaboralEmpresaNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(231),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_13_" + sGXsfl_231_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 234,'',false,'" + sGXsfl_231_idx + "',231)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_experiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtExperienciaLaboralDesde_Internalname,localUtil.format(A205ExperienciaLaboralDesde, "99/99/9999"),localUtil.format( A205ExperienciaLaboralDesde, "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,234);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtExperienciaLaboralDesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtExperienciaLaboralDesde_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(231),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_13_" + sGXsfl_231_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 235,'',false,'" + sGXsfl_231_idx + "',231)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_experiencialaboralRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtExperienciaLaboralHasta_Internalname,localUtil.format(A206ExperienciaLaboralHasta, "99/99/9999"),localUtil.format( A206ExperienciaLaboralHasta, "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,235);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtExperienciaLaboralHasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtExperienciaLaboralHasta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(231),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridprofesional_experiencialaboralRow);
      send_integrity_lvl_hashes0813( ) ;
      GXCCtl = "Z56ExperienciaLaboralId_" + sGXsfl_231_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z56ExperienciaLaboralId.toString());
      GXCCtl = "Z204ExperienciaLaboralEmpresaNombre_" + sGXsfl_231_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z204ExperienciaLaboralEmpresaNombre);
      GXCCtl = "Z205ExperienciaLaboralDesde_" + sGXsfl_231_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z205ExperienciaLaboralDesde, 0, "/"));
      GXCCtl = "Z206ExperienciaLaboralHasta_" + sGXsfl_231_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z206ExperienciaLaboralHasta, 0, "/"));
      GXCCtl = "nRcdDeleted_13_" + sGXsfl_231_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_13, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_13_" + sGXsfl_231_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_13, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_13_" + sGXsfl_231_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_13, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EXPERIENCIALABORALID_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralEmpresaNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EXPERIENCIALABORALDESDE_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralDesde_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "EXPERIENCIALABORALHASTA_"+sGXsfl_231_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtExperienciaLaboralHasta_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridprofesional_experiencialaboralContainer.AddRow(Gridprofesional_experiencialaboralRow);
   }

   public void readRow0813( )
   {
      nGXsfl_231_idx = (int)(nGXsfl_231_idx+1) ;
      sGXsfl_231_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_231_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_23113( ) ;
      edtExperienciaLaboralId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALID_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
      edtExperienciaLaboralEmpresaNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
      edtExperienciaLaboralDesde_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALDESDE_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
      edtExperienciaLaboralHasta_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "EXPERIENCIALABORALHASTA_"+sGXsfl_231_idx+"Enabled"), ",", ".")) ;
      if ( GXutil.strcmp(httpContext.cgiGet( edtExperienciaLaboralId_Internalname), "") == 0 )
      {
         A56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      }
      else
      {
         try
         {
            A56ExperienciaLaboralId = GXutil.strToGuid(httpContext.cgiGet( edtExperienciaLaboralId_Internalname)) ;
         }
         catch ( IllegalArgumentException  e)
         {
            GXCCtl = "EXPERIENCIALABORALID_" + sGXsfl_231_idx ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_invalidguid"), 1, GXCCtl);
            AnyError = (short)(1) ;
            GX_FocusControl = edtExperienciaLaboralId_Internalname ;
            wbErr = true ;
         }
      }
      A204ExperienciaLaboralEmpresaNombre = httpContext.cgiGet( edtExperienciaLaboralEmpresaNombre_Internalname) ;
      if ( localUtil.vcdate( httpContext.cgiGet( edtExperienciaLaboralDesde_Internalname), (byte)(3)) == 0 )
      {
         GXCCtl = "EXPERIENCIALABORALDESDE_" + sGXsfl_231_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtExperienciaLaboralDesde_Internalname ;
         wbErr = true ;
         A205ExperienciaLaboralDesde = GXutil.nullDate() ;
      }
      else
      {
         A205ExperienciaLaboralDesde = localUtil.ctod( httpContext.cgiGet( edtExperienciaLaboralDesde_Internalname), 3) ;
      }
      if ( localUtil.vcdate( httpContext.cgiGet( edtExperienciaLaboralHasta_Internalname), (byte)(3)) == 0 )
      {
         GXCCtl = "EXPERIENCIALABORALHASTA_" + sGXsfl_231_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtExperienciaLaboralHasta_Internalname ;
         wbErr = true ;
         A206ExperienciaLaboralHasta = GXutil.nullDate() ;
      }
      else
      {
         A206ExperienciaLaboralHasta = localUtil.ctod( httpContext.cgiGet( edtExperienciaLaboralHasta_Internalname), 3) ;
      }
      GXCCtl = "Z56ExperienciaLaboralId_" + sGXsfl_231_idx ;
      Z56ExperienciaLaboralId = GXutil.strToGuid(httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z204ExperienciaLaboralEmpresaNombre_" + sGXsfl_231_idx ;
      Z204ExperienciaLaboralEmpresaNombre = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z205ExperienciaLaboralDesde_" + sGXsfl_231_idx ;
      Z205ExperienciaLaboralDesde = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z206ExperienciaLaboralHasta_" + sGXsfl_231_idx ;
      Z206ExperienciaLaboralHasta = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "nRcdDeleted_13_" + sGXsfl_231_idx ;
      nRcdDeleted_13 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_13_" + sGXsfl_231_idx ;
      nRcdExists_13 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_13_" + sGXsfl_231_idx ;
      nIsMod_13 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void subsflControlProps_24114( )
   {
      edtPremiosId_Internalname = "PREMIOSID_"+sGXsfl_241_idx ;
      edtPremiosNombre_Internalname = "PREMIOSNOMBRE_"+sGXsfl_241_idx ;
      edtPremiosFecha_Internalname = "PREMIOSFECHA_"+sGXsfl_241_idx ;
      edtPremiosDescripcion_Internalname = "PREMIOSDESCRIPCION_"+sGXsfl_241_idx ;
   }

   public void subsflControlProps_fel_24114( )
   {
      edtPremiosId_Internalname = "PREMIOSID_"+sGXsfl_241_fel_idx ;
      edtPremiosNombre_Internalname = "PREMIOSNOMBRE_"+sGXsfl_241_fel_idx ;
      edtPremiosFecha_Internalname = "PREMIOSFECHA_"+sGXsfl_241_fel_idx ;
      edtPremiosDescripcion_Internalname = "PREMIOSDESCRIPCION_"+sGXsfl_241_fel_idx ;
   }

   public void addRow0814( )
   {
      nGXsfl_241_idx = (int)(nGXsfl_241_idx+1) ;
      sGXsfl_241_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_241_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_24114( ) ;
      sendRow0814( ) ;
   }

   public void sendRow0814( )
   {
      Gridprofesional_premiosRow = GXWebRow.GetNew(context) ;
      if ( subGridprofesional_premios_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridprofesional_premios_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridprofesional_premios_Class, "") != 0 )
         {
            subGridprofesional_premios_Linesclass = subGridprofesional_premios_Class+"Odd" ;
         }
      }
      else if ( subGridprofesional_premios_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridprofesional_premios_Backstyle = (byte)(0) ;
         subGridprofesional_premios_Backcolor = subGridprofesional_premios_Allbackcolor ;
         if ( GXutil.strcmp(subGridprofesional_premios_Class, "") != 0 )
         {
            subGridprofesional_premios_Linesclass = subGridprofesional_premios_Class+"Uniform" ;
         }
      }
      else if ( subGridprofesional_premios_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridprofesional_premios_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridprofesional_premios_Class, "") != 0 )
         {
            subGridprofesional_premios_Linesclass = subGridprofesional_premios_Class+"Odd" ;
         }
         subGridprofesional_premios_Backcolor = (int)(0x0) ;
      }
      else if ( subGridprofesional_premios_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridprofesional_premios_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_241_idx) % (2))) == 0 )
         {
            subGridprofesional_premios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_premios_Class, "") != 0 )
            {
               subGridprofesional_premios_Linesclass = subGridprofesional_premios_Class+"Even" ;
            }
         }
         else
         {
            subGridprofesional_premios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_premios_Class, "") != 0 )
            {
               subGridprofesional_premios_Linesclass = subGridprofesional_premios_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_14_" + sGXsfl_241_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 242,'',false,'" + sGXsfl_241_idx + "',241)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_premiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPremiosId_Internalname,A57PremiosId.toString(),A57PremiosId.toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,242);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPremiosId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtPremiosId_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(241),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_14_" + sGXsfl_241_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 243,'',false,'" + sGXsfl_241_idx + "',241)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_premiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPremiosNombre_Internalname,A207PremiosNombre,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,243);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPremiosNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtPremiosNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(241),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_14_" + sGXsfl_241_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 244,'',false,'" + sGXsfl_241_idx + "',241)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_premiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPremiosFecha_Internalname,localUtil.format(A208PremiosFecha, "99/99/99"),localUtil.format( A208PremiosFecha, "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,244);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPremiosFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtPremiosFecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(241),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_14_" + sGXsfl_241_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 245,'',false,'" + sGXsfl_241_idx + "',241)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_premiosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPremiosDescripcion_Internalname,A209PremiosDescripcion,A209PremiosDescripcion,TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,245);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPremiosDescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtPremiosDescripcion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(241),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridprofesional_premiosRow);
      send_integrity_lvl_hashes0814( ) ;
      GXCCtl = "Z57PremiosId_" + sGXsfl_241_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z57PremiosId.toString());
      GXCCtl = "Z207PremiosNombre_" + sGXsfl_241_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z207PremiosNombre);
      GXCCtl = "Z208PremiosFecha_" + sGXsfl_241_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z208PremiosFecha, 0, "/"));
      GXCCtl = "nRcdDeleted_14_" + sGXsfl_241_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_14, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_14_" + sGXsfl_241_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_14, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_14_" + sGXsfl_241_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_14, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PREMIOSID_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PREMIOSNOMBRE_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PREMIOSFECHA_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosFecha_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PREMIOSDESCRIPCION_"+sGXsfl_241_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtPremiosDescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridprofesional_premiosContainer.AddRow(Gridprofesional_premiosRow);
   }

   public void readRow0814( )
   {
      nGXsfl_241_idx = (int)(nGXsfl_241_idx+1) ;
      sGXsfl_241_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_241_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_24114( ) ;
      edtPremiosId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSID_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
      edtPremiosNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSNOMBRE_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
      edtPremiosFecha_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSFECHA_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
      edtPremiosDescripcion_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PREMIOSDESCRIPCION_"+sGXsfl_241_idx+"Enabled"), ",", ".")) ;
      if ( GXutil.strcmp(httpContext.cgiGet( edtPremiosId_Internalname), "") == 0 )
      {
         A57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      }
      else
      {
         try
         {
            A57PremiosId = GXutil.strToGuid(httpContext.cgiGet( edtPremiosId_Internalname)) ;
         }
         catch ( IllegalArgumentException  e)
         {
            GXCCtl = "PREMIOSID_" + sGXsfl_241_idx ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_invalidguid"), 1, GXCCtl);
            AnyError = (short)(1) ;
            GX_FocusControl = edtPremiosId_Internalname ;
            wbErr = true ;
         }
      }
      A207PremiosNombre = httpContext.cgiGet( edtPremiosNombre_Internalname) ;
      if ( localUtil.vcdate( httpContext.cgiGet( edtPremiosFecha_Internalname), (byte)(3)) == 0 )
      {
         GXCCtl = "PREMIOSFECHA_" + sGXsfl_241_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtPremiosFecha_Internalname ;
         wbErr = true ;
         A208PremiosFecha = GXutil.nullDate() ;
      }
      else
      {
         A208PremiosFecha = localUtil.ctod( httpContext.cgiGet( edtPremiosFecha_Internalname), 3) ;
      }
      A209PremiosDescripcion = httpContext.cgiGet( edtPremiosDescripcion_Internalname) ;
      GXCCtl = "Z57PremiosId_" + sGXsfl_241_idx ;
      Z57PremiosId = GXutil.strToGuid(httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z207PremiosNombre_" + sGXsfl_241_idx ;
      Z207PremiosNombre = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z208PremiosFecha_" + sGXsfl_241_idx ;
      Z208PremiosFecha = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "nRcdDeleted_14_" + sGXsfl_241_idx ;
      nRcdDeleted_14 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_14_" + sGXsfl_241_idx ;
      nRcdExists_14 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_14_" + sGXsfl_241_idx ;
      nIsMod_14 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void subsflControlProps_25115( )
   {
      edtServiciosId_Internalname = "SERVICIOSID_"+sGXsfl_251_idx ;
      edtServiciosNombre_Internalname = "SERVICIOSNOMBRE_"+sGXsfl_251_idx ;
   }

   public void subsflControlProps_fel_25115( )
   {
      edtServiciosId_Internalname = "SERVICIOSID_"+sGXsfl_251_fel_idx ;
      edtServiciosNombre_Internalname = "SERVICIOSNOMBRE_"+sGXsfl_251_fel_idx ;
   }

   public void addRow0815( )
   {
      nGXsfl_251_idx = (int)(nGXsfl_251_idx+1) ;
      sGXsfl_251_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_251_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_25115( ) ;
      sendRow0815( ) ;
   }

   public void sendRow0815( )
   {
      Gridprofesional_serviciosRow = GXWebRow.GetNew(context) ;
      if ( subGridprofesional_servicios_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridprofesional_servicios_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridprofesional_servicios_Class, "") != 0 )
         {
            subGridprofesional_servicios_Linesclass = subGridprofesional_servicios_Class+"Odd" ;
         }
      }
      else if ( subGridprofesional_servicios_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridprofesional_servicios_Backstyle = (byte)(0) ;
         subGridprofesional_servicios_Backcolor = subGridprofesional_servicios_Allbackcolor ;
         if ( GXutil.strcmp(subGridprofesional_servicios_Class, "") != 0 )
         {
            subGridprofesional_servicios_Linesclass = subGridprofesional_servicios_Class+"Uniform" ;
         }
      }
      else if ( subGridprofesional_servicios_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridprofesional_servicios_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridprofesional_servicios_Class, "") != 0 )
         {
            subGridprofesional_servicios_Linesclass = subGridprofesional_servicios_Class+"Odd" ;
         }
         subGridprofesional_servicios_Backcolor = (int)(0x0) ;
      }
      else if ( subGridprofesional_servicios_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridprofesional_servicios_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_251_idx) % (2))) == 0 )
         {
            subGridprofesional_servicios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_servicios_Class, "") != 0 )
            {
               subGridprofesional_servicios_Linesclass = subGridprofesional_servicios_Class+"Even" ;
            }
         }
         else
         {
            subGridprofesional_servicios_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridprofesional_servicios_Class, "") != 0 )
            {
               subGridprofesional_servicios_Linesclass = subGridprofesional_servicios_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_15_" + sGXsfl_251_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 252,'',false,'" + sGXsfl_251_idx + "',251)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_serviciosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServiciosId_Internalname,A58ServiciosId.toString(),A58ServiciosId.toString(),TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,252);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServiciosId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtServiciosId_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(36),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(251),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Boolean.valueOf(true),"","",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_15_" + sGXsfl_251_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 253,'',false,'" + sGXsfl_251_idx + "',251)\"" ;
      ROClassString = "Attribute" ;
      Gridprofesional_serviciosRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtServiciosNombre_Internalname,A210ServiciosNombre,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,253);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtServiciosNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtServiciosNombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(251),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridprofesional_serviciosRow);
      send_integrity_lvl_hashes0815( ) ;
      GXCCtl = "Z58ServiciosId_" + sGXsfl_251_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z58ServiciosId.toString());
      GXCCtl = "Z210ServiciosNombre_" + sGXsfl_251_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z210ServiciosNombre);
      GXCCtl = "nRcdDeleted_15_" + sGXsfl_251_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_15, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nRcdExists_15_" + sGXsfl_251_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_15, (byte)(4), (byte)(0), ",", "")));
      GXCCtl = "nIsMod_15_" + sGXsfl_251_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_15, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SERVICIOSID_"+sGXsfl_251_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SERVICIOSNOMBRE_"+sGXsfl_251_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtServiciosNombre_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridprofesional_serviciosContainer.AddRow(Gridprofesional_serviciosRow);
   }

   public void readRow0815( )
   {
      nGXsfl_251_idx = (int)(nGXsfl_251_idx+1) ;
      sGXsfl_251_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_251_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_25115( ) ;
      edtServiciosId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SERVICIOSID_"+sGXsfl_251_idx+"Enabled"), ",", ".")) ;
      edtServiciosNombre_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "SERVICIOSNOMBRE_"+sGXsfl_251_idx+"Enabled"), ",", ".")) ;
      if ( GXutil.strcmp(httpContext.cgiGet( edtServiciosId_Internalname), "") == 0 )
      {
         A58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      }
      else
      {
         try
         {
            A58ServiciosId = GXutil.strToGuid(httpContext.cgiGet( edtServiciosId_Internalname)) ;
         }
         catch ( IllegalArgumentException  e)
         {
            GXCCtl = "SERVICIOSID_" + sGXsfl_251_idx ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_invalidguid"), 1, GXCCtl);
            AnyError = (short)(1) ;
            GX_FocusControl = edtServiciosId_Internalname ;
            wbErr = true ;
         }
      }
      A210ServiciosNombre = httpContext.cgiGet( edtServiciosNombre_Internalname) ;
      GXCCtl = "Z58ServiciosId_" + sGXsfl_251_idx ;
      Z58ServiciosId = GXutil.strToGuid(httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z210ServiciosNombre_" + sGXsfl_251_idx ;
      Z210ServiciosNombre = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_15_" + sGXsfl_251_idx ;
      nRcdDeleted_15 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nRcdExists_15_" + sGXsfl_251_idx ;
      nRcdExists_15 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
      GXCCtl = "nIsMod_15_" + sGXsfl_251_idx ;
      nIsMod_15 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
   }

   public void assign_properties_default( )
   {
      defcmbSedeTipoConsulta_Enabled = cmbSedeTipoConsulta.getEnabled() ;
      defedtSedeId_Enabled = edtSedeId_Enabled ;
      defedtServiciosId_Enabled = edtServiciosId_Enabled ;
      defedtPremiosId_Enabled = edtPremiosId_Enabled ;
      defedtExperienciaLaboralId_Enabled = edtExperienciaLaboralId_Enabled ;
      defedtEducacionId_Enabled = edtEducacionId_Enabled ;
      defedtEspecialidadId_Enabled = edtEspecialidadId_Enabled ;
   }

   public void confirmValues080( )
   {
      nGXsfl_209_idx = 0 ;
      sGXsfl_209_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_209_idx), 4, 0), (short)(4), "0") + sGXsfl_184_idx ;
      subsflControlProps_20911( ) ;
      while ( nGXsfl_209_idx < nRC_GXsfl_209 )
      {
         nGXsfl_209_idx = (int)(nGXsfl_209_idx+1) ;
         sGXsfl_209_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_209_idx), 4, 0), (short)(4), "0") + sGXsfl_184_idx ;
         subsflControlProps_20911( ) ;
         httpContext.changePostValue( "Z30SedeId_"+sGXsfl_209_idx, httpContext.cgiGet( "ZT_"+"Z30SedeId_"+sGXsfl_209_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z30SedeId_"+sGXsfl_209_idx) ;
         httpContext.changePostValue( "Z54SedeTipoConsulta_"+sGXsfl_209_idx, httpContext.cgiGet( "ZT_"+"Z54SedeTipoConsulta_"+sGXsfl_209_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z54SedeTipoConsulta_"+sGXsfl_209_idx) ;
         httpContext.changePostValue( "Z199CostoConsulta_"+sGXsfl_209_idx, httpContext.cgiGet( "ZT_"+"Z199CostoConsulta_"+sGXsfl_209_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z199CostoConsulta_"+sGXsfl_209_idx) ;
      }
      nGXsfl_184_idx = 0 ;
      sGXsfl_184_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_184_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_18410( ) ;
      while ( nGXsfl_184_idx < nRC_GXsfl_184 )
      {
         nGXsfl_184_idx = (int)(nGXsfl_184_idx+1) ;
         sGXsfl_184_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_184_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_18410( ) ;
         httpContext.changePostValue( "Z32EspecialidadId_"+sGXsfl_184_idx, httpContext.cgiGet( "ZT_"+"Z32EspecialidadId_"+sGXsfl_184_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z32EspecialidadId_"+sGXsfl_184_idx) ;
      }
      nGXsfl_220_idx = 0 ;
      sGXsfl_220_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_220_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_22012( ) ;
      while ( nGXsfl_220_idx < nRC_GXsfl_220 )
      {
         nGXsfl_220_idx = (int)(nGXsfl_220_idx+1) ;
         sGXsfl_220_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_220_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_22012( ) ;
         httpContext.changePostValue( "Z55EducacionId_"+sGXsfl_220_idx, httpContext.cgiGet( "ZT_"+"Z55EducacionId_"+sGXsfl_220_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z55EducacionId_"+sGXsfl_220_idx) ;
         httpContext.changePostValue( "Z200EducacionNombreInstitucion_"+sGXsfl_220_idx, httpContext.cgiGet( "ZT_"+"Z200EducacionNombreInstitucion_"+sGXsfl_220_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z200EducacionNombreInstitucion_"+sGXsfl_220_idx) ;
         httpContext.changePostValue( "Z201EducacionDesde_"+sGXsfl_220_idx, httpContext.cgiGet( "ZT_"+"Z201EducacionDesde_"+sGXsfl_220_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z201EducacionDesde_"+sGXsfl_220_idx) ;
         httpContext.changePostValue( "Z202EducacionHasta_"+sGXsfl_220_idx, httpContext.cgiGet( "ZT_"+"Z202EducacionHasta_"+sGXsfl_220_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z202EducacionHasta_"+sGXsfl_220_idx) ;
         httpContext.changePostValue( "Z203EducacionPaisDescripcion_"+sGXsfl_220_idx, httpContext.cgiGet( "ZT_"+"Z203EducacionPaisDescripcion_"+sGXsfl_220_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z203EducacionPaisDescripcion_"+sGXsfl_220_idx) ;
      }
      nGXsfl_231_idx = 0 ;
      sGXsfl_231_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_231_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_23113( ) ;
      while ( nGXsfl_231_idx < nRC_GXsfl_231 )
      {
         nGXsfl_231_idx = (int)(nGXsfl_231_idx+1) ;
         sGXsfl_231_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_231_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_23113( ) ;
         httpContext.changePostValue( "Z56ExperienciaLaboralId_"+sGXsfl_231_idx, httpContext.cgiGet( "ZT_"+"Z56ExperienciaLaboralId_"+sGXsfl_231_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z56ExperienciaLaboralId_"+sGXsfl_231_idx) ;
         httpContext.changePostValue( "Z204ExperienciaLaboralEmpresaNombre_"+sGXsfl_231_idx, httpContext.cgiGet( "ZT_"+"Z204ExperienciaLaboralEmpresaNombre_"+sGXsfl_231_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z204ExperienciaLaboralEmpresaNombre_"+sGXsfl_231_idx) ;
         httpContext.changePostValue( "Z205ExperienciaLaboralDesde_"+sGXsfl_231_idx, httpContext.cgiGet( "ZT_"+"Z205ExperienciaLaboralDesde_"+sGXsfl_231_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z205ExperienciaLaboralDesde_"+sGXsfl_231_idx) ;
         httpContext.changePostValue( "Z206ExperienciaLaboralHasta_"+sGXsfl_231_idx, httpContext.cgiGet( "ZT_"+"Z206ExperienciaLaboralHasta_"+sGXsfl_231_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z206ExperienciaLaboralHasta_"+sGXsfl_231_idx) ;
      }
      nGXsfl_241_idx = 0 ;
      sGXsfl_241_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_241_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_24114( ) ;
      while ( nGXsfl_241_idx < nRC_GXsfl_241 )
      {
         nGXsfl_241_idx = (int)(nGXsfl_241_idx+1) ;
         sGXsfl_241_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_241_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_24114( ) ;
         httpContext.changePostValue( "Z57PremiosId_"+sGXsfl_241_idx, httpContext.cgiGet( "ZT_"+"Z57PremiosId_"+sGXsfl_241_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z57PremiosId_"+sGXsfl_241_idx) ;
         httpContext.changePostValue( "Z207PremiosNombre_"+sGXsfl_241_idx, httpContext.cgiGet( "ZT_"+"Z207PremiosNombre_"+sGXsfl_241_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z207PremiosNombre_"+sGXsfl_241_idx) ;
         httpContext.changePostValue( "Z208PremiosFecha_"+sGXsfl_241_idx, httpContext.cgiGet( "ZT_"+"Z208PremiosFecha_"+sGXsfl_241_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z208PremiosFecha_"+sGXsfl_241_idx) ;
      }
      nGXsfl_251_idx = 0 ;
      sGXsfl_251_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_251_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_25115( ) ;
      while ( nGXsfl_251_idx < nRC_GXsfl_251 )
      {
         nGXsfl_251_idx = (int)(nGXsfl_251_idx+1) ;
         sGXsfl_251_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_251_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_25115( ) ;
         httpContext.changePostValue( "Z58ServiciosId_"+sGXsfl_251_idx, httpContext.cgiGet( "ZT_"+"Z58ServiciosId_"+sGXsfl_251_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z58ServiciosId_"+sGXsfl_251_idx) ;
         httpContext.changePostValue( "Z210ServiciosNombre_"+sGXsfl_251_idx, httpContext.cgiGet( "ZT_"+"Z210ServiciosNombre_"+sGXsfl_251_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z210ServiciosNombre_"+sGXsfl_251_idx) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110323639", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.profesional", new String[] {}, new String[] {}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Profesional");
      forbiddenHiddens.add("ProfesionalId", localUtil.format( DecimalUtil.doubleToDec(A31ProfesionalId), "ZZZZZZZ9"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("profesional:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
      forbiddenHiddens2 = new com.genexus.util.GXProperties() ;
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         forbiddenHiddens2.add("ProfesionalNroDocumento", GXutil.rtrim( localUtil.format( A174ProfesionalNroDocumento, "")));
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         forbiddenHiddens2.add("ProfesionalNroDocumento", GXutil.rtrim( localUtil.format( A174ProfesionalNroDocumento, "")));
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "hsh2", httpContext.getEncryptedSignature( forbiddenHiddens2.toString(), GXKey));
      GXutil.writeLogInfo("profesional:[ SendCondSecurityCheck value for]"+forbiddenHiddens2.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z31ProfesionalId", GXutil.ltrim( localUtil.ntoc( Z31ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z173ProfesionalTipoDocumento", GXutil.rtrim( Z173ProfesionalTipoDocumento));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z174ProfesionalNroDocumento", Z174ProfesionalNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z85ProfesionalApellidoPaterno", Z85ProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z86ProfesionalApellidoMaterno", Z86ProfesionalApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z84ProfesionalNombres", Z84ProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z176ProfesionalFechaNacimiento", localUtil.dtoc( Z176ProfesionalFechaNacimiento, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z177ProfesionalSexo", GXutil.rtrim( Z177ProfesionalSexo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z178ProfesionalDescripcion", Z178ProfesionalDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z179ProfesionalCorreo", Z179ProfesionalCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z88ProfesionalCOP", Z88ProfesionalCOP);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z180ProfesionalColorDisponible", GXutil.rtrim( Z180ProfesionalColorDisponible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z181ProfesionalColorCita", GXutil.rtrim( Z181ProfesionalColorCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z182ProfesionalTiempoCita", GXutil.ltrim( localUtil.ntoc( Z182ProfesionalTiempoCita, (byte)(2), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z183ProfesionalDireccion", Z183ProfesionalDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z190ProfesionalTwitter", Z190ProfesionalTwitter);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z191ProfesionalFacebook", Z191ProfesionalFacebook);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z192ProfesionalInstagram", Z192ProfesionalInstagram);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z193ProfesionalLinkedin", Z193ProfesionalLinkedin);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z194ProfesionalTelefono", GXutil.rtrim( Z194ProfesionalTelefono));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z195ProfesionalFechaRegistro", localUtil.dtoc( Z195ProfesionalFechaRegistro, 0, "/"));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "Z196ProfesionalTerminosCondiciones", Z196ProfesionalTerminosCondiciones);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z197ProfesionalEstadoCuenta", GXutil.rtrim( Z197ProfesionalEstadoCuenta));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z198ProfesionalEstado", GXutil.rtrim( Z198ProfesionalEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z43PaisId", GXutil.ltrim( localUtil.ntoc( Z43PaisId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z44UbigeoCode", GXutil.rtrim( Z44UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z6SecUserId", GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_184", GXutil.ltrim( localUtil.ntoc( nGXsfl_184_idx, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_220", GXutil.ltrim( localUtil.ntoc( nGXsfl_220_idx, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_231", GXutil.ltrim( localUtil.ntoc( nGXsfl_231_idx, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_241", GXutil.ltrim( localUtil.ntoc( nGXsfl_241_idx, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_251", GXutil.ltrim( localUtil.ntoc( nGXsfl_251_idx, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "N174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODEPARTAMENTO", A186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEOPROVINCIA", A187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UBIGEODISTRITO", A188UbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALNRODOCUMENTO", AV15ProfesionalNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALCORREO", AV14ProfesionalCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "PROFESIONALFOTO_GXI", A40000ProfesionalFoto_GXI);
      GXCCtlgxBlob = "PROFESIONALFOTO" + "_gxBlob" ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A189ProfesionalFoto);
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
      return formatLink("com.projectthani.profesional", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "Profesional" ;
   }

   public String getPgmdesc( )
   {
      return "Profesional" ;
   }

   public void initializeNonKey089( )
   {
      AV15ProfesionalNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15ProfesionalNroDocumento", AV15ProfesionalNroDocumento);
      AV14ProfesionalCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14ProfesionalCorreo", AV14ProfesionalCorreo);
      A175ProfesionalNombreCompleto2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A175ProfesionalNombreCompleto2", A175ProfesionalNombreCompleto2);
      A173ProfesionalTipoDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A173ProfesionalTipoDocumento", A173ProfesionalTipoDocumento);
      A174ProfesionalNroDocumento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
      A85ProfesionalApellidoPaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      A86ProfesionalApellidoMaterno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      A84ProfesionalNombres = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A176ProfesionalFechaNacimiento", localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"));
      A177ProfesionalSexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A177ProfesionalSexo", A177ProfesionalSexo);
      A178ProfesionalDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A178ProfesionalDescripcion", A178ProfesionalDescripcion);
      A179ProfesionalCorreo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A179ProfesionalCorreo", A179ProfesionalCorreo);
      A88ProfesionalCOP = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
      A183ProfesionalDireccion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A183ProfesionalDireccion", A183ProfesionalDireccion);
      A43PaisId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A43PaisId), 4, 0));
      A184PaisDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
      A44UbigeoCode = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", A44UbigeoCode);
      A185UbigeoNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      A189ProfesionalFoto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A189ProfesionalFoto", A189ProfesionalFoto);
      httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
      A40000ProfesionalFoto_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "Bitmap", ((GXutil.strcmp("", A189ProfesionalFoto)==0) ? A40000ProfesionalFoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A189ProfesionalFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgProfesionalFoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A189ProfesionalFoto), true);
      A190ProfesionalTwitter = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A190ProfesionalTwitter", A190ProfesionalTwitter);
      A191ProfesionalFacebook = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A191ProfesionalFacebook", A191ProfesionalFacebook);
      A192ProfesionalInstagram = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A192ProfesionalInstagram", A192ProfesionalInstagram);
      A193ProfesionalLinkedin = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A193ProfesionalLinkedin", A193ProfesionalLinkedin);
      A194ProfesionalTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A194ProfesionalTelefono", A194ProfesionalTelefono);
      A6SecUserId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6SecUserId), 4, 0));
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A195ProfesionalFechaRegistro", localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"));
      A196ProfesionalTerminosCondiciones = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A196ProfesionalTerminosCondiciones", A196ProfesionalTerminosCondiciones);
      A197ProfesionalEstadoCuenta = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A197ProfesionalEstadoCuenta", A197ProfesionalEstadoCuenta);
      A186UbigeoDepartamento = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      A187UbigeoProvincia = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      A188UbigeoDistrito = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      A180ProfesionalColorDisponible = "#8CE1B3" ;
      httpContext.ajax_rsp_assign_attri("", false, "A180ProfesionalColorDisponible", A180ProfesionalColorDisponible);
      A181ProfesionalColorCita = "#376A4A" ;
      httpContext.ajax_rsp_assign_attri("", false, "A181ProfesionalColorCita", A181ProfesionalColorCita);
      A182ProfesionalTiempoCita = (byte)(30) ;
      httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
      A198ProfesionalEstado = "A" ;
      httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
      Z173ProfesionalTipoDocumento = "" ;
      Z174ProfesionalNroDocumento = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      Z84ProfesionalNombres = "" ;
      Z176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      Z177ProfesionalSexo = "" ;
      Z178ProfesionalDescripcion = "" ;
      Z179ProfesionalCorreo = "" ;
      Z88ProfesionalCOP = "" ;
      Z180ProfesionalColorDisponible = "" ;
      Z181ProfesionalColorCita = "" ;
      Z182ProfesionalTiempoCita = (byte)(0) ;
      Z183ProfesionalDireccion = "" ;
      Z190ProfesionalTwitter = "" ;
      Z191ProfesionalFacebook = "" ;
      Z192ProfesionalInstagram = "" ;
      Z193ProfesionalLinkedin = "" ;
      Z194ProfesionalTelefono = "" ;
      Z195ProfesionalFechaRegistro = GXutil.nullDate() ;
      Z196ProfesionalTerminosCondiciones = false ;
      Z197ProfesionalEstadoCuenta = "" ;
      Z198ProfesionalEstado = "" ;
      Z43PaisId = (short)(0) ;
      Z44UbigeoCode = "" ;
      Z6SecUserId = (short)(0) ;
   }

   public void initAll089( )
   {
      A31ProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A31ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A31ProfesionalId), 8, 0));
      initializeNonKey089( ) ;
   }

   public void standaloneModalInsert( )
   {
      A182ProfesionalTiempoCita = i182ProfesionalTiempoCita ;
      httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
      A180ProfesionalColorDisponible = i180ProfesionalColorDisponible ;
      httpContext.ajax_rsp_assign_attri("", false, "A180ProfesionalColorDisponible", A180ProfesionalColorDisponible);
      A181ProfesionalColorCita = i181ProfesionalColorCita ;
      httpContext.ajax_rsp_assign_attri("", false, "A181ProfesionalColorCita", A181ProfesionalColorCita);
      A198ProfesionalEstado = i198ProfesionalEstado ;
      httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
   }

   public void initializeNonKey0810( )
   {
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
   }

   public void initAll0810( )
   {
      A32EspecialidadId = (short)(0) ;
      initializeNonKey0810( ) ;
   }

   public void standaloneModalInsert0810( )
   {
   }

   public void initializeNonKey0811( )
   {
      A28ClinicaId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A28ClinicaId), 4, 0));
      A75SedeNombre = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      Z199CostoConsulta = DecimalUtil.ZERO ;
   }

   public void initAll0811( )
   {
      A30SedeId = (short)(0) ;
      A54SedeTipoConsulta = "V" ;
      initializeNonKey0811( ) ;
   }

   public void standaloneModalInsert0811( )
   {
      A199CostoConsulta = i199CostoConsulta ;
   }

   public void initializeNonKey0812( )
   {
      A200EducacionNombreInstitucion = "" ;
      A201EducacionDesde = GXutil.nullDate() ;
      A202EducacionHasta = GXutil.nullDate() ;
      A203EducacionPaisDescripcion = "" ;
      Z200EducacionNombreInstitucion = "" ;
      Z201EducacionDesde = GXutil.nullDate() ;
      Z202EducacionHasta = GXutil.nullDate() ;
      Z203EducacionPaisDescripcion = "" ;
   }

   public void initAll0812( )
   {
      A55EducacionId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0812( ) ;
   }

   public void standaloneModalInsert0812( )
   {
   }

   public void initializeNonKey0813( )
   {
      A204ExperienciaLaboralEmpresaNombre = "" ;
      A205ExperienciaLaboralDesde = GXutil.nullDate() ;
      A206ExperienciaLaboralHasta = GXutil.nullDate() ;
      Z204ExperienciaLaboralEmpresaNombre = "" ;
      Z205ExperienciaLaboralDesde = GXutil.nullDate() ;
      Z206ExperienciaLaboralHasta = GXutil.nullDate() ;
   }

   public void initAll0813( )
   {
      A56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0813( ) ;
   }

   public void standaloneModalInsert0813( )
   {
   }

   public void initializeNonKey0814( )
   {
      A207PremiosNombre = "" ;
      A208PremiosFecha = GXutil.nullDate() ;
      A209PremiosDescripcion = "" ;
      Z207PremiosNombre = "" ;
      Z208PremiosFecha = GXutil.nullDate() ;
   }

   public void initAll0814( )
   {
      A57PremiosId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0814( ) ;
   }

   public void standaloneModalInsert0814( )
   {
   }

   public void initializeNonKey0815( )
   {
      A210ServiciosNombre = "" ;
      Z210ServiciosNombre = "" ;
   }

   public void initAll0815( )
   {
      A58ServiciosId = java.util.UUID.randomUUID( ) ;
      initializeNonKey0815( ) ;
   }

   public void standaloneModalInsert0815( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110323680", true, true);
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
      httpContext.AddJavascriptSource("profesional.js", "?20225110323680", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties10( )
   {
      edtEspecialidadId_Enabled = defedtEspecialidadId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtEspecialidadId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEspecialidadId_Enabled), 5, 0), !bGXsfl_184_Refreshing);
   }

   public void init_level_properties11( )
   {
      cmbSedeTipoConsulta.setEnabled( defcmbSedeTipoConsulta_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, cmbSedeTipoConsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbSedeTipoConsulta.getEnabled(), 5, 0), !bGXsfl_209_Refreshing);
      edtSedeId_Enabled = defedtSedeId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtSedeId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtSedeId_Enabled), 5, 0), !bGXsfl_209_Refreshing);
   }

   public void init_level_properties12( )
   {
      edtEducacionId_Enabled = defedtEducacionId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtEducacionId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEducacionId_Enabled), 5, 0), !bGXsfl_220_Refreshing);
   }

   public void init_level_properties13( )
   {
      edtExperienciaLaboralId_Enabled = defedtExperienciaLaboralId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtExperienciaLaboralId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtExperienciaLaboralId_Enabled), 5, 0), !bGXsfl_231_Refreshing);
   }

   public void init_level_properties14( )
   {
      edtPremiosId_Enabled = defedtPremiosId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtPremiosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPremiosId_Enabled), 5, 0), !bGXsfl_241_Refreshing);
   }

   public void init_level_properties15( )
   {
      edtServiciosId_Enabled = defedtServiciosId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtServiciosId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtServiciosId_Enabled), 5, 0), !bGXsfl_251_Refreshing);
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      edtProfesionalId_Internalname = "PROFESIONALID" ;
      cmbProfesionalTipoDocumento.setInternalname( "PROFESIONALTIPODOCUMENTO" );
      edtProfesionalNroDocumento_Internalname = "PROFESIONALNRODOCUMENTO" ;
      edtProfesionalApellidoPaterno_Internalname = "PROFESIONALAPELLIDOPATERNO" ;
      edtProfesionalApellidoMaterno_Internalname = "PROFESIONALAPELLIDOMATERNO" ;
      edtProfesionalNombres_Internalname = "PROFESIONALNOMBRES" ;
      edtProfesionalNombreCompleto2_Internalname = "PROFESIONALNOMBRECOMPLETO2" ;
      edtProfesionalFechaNacimiento_Internalname = "PROFESIONALFECHANACIMIENTO" ;
      cmbProfesionalSexo.setInternalname( "PROFESIONALSEXO" );
      edtProfesionalDescripcion_Internalname = "PROFESIONALDESCRIPCION" ;
      edtProfesionalCorreo_Internalname = "PROFESIONALCORREO" ;
      edtProfesionalCOP_Internalname = "PROFESIONALCOP" ;
      edtProfesionalColorDisponible_Internalname = "PROFESIONALCOLORDISPONIBLE" ;
      edtProfesionalColorCita_Internalname = "PROFESIONALCOLORCITA" ;
      cmbProfesionalTiempoCita.setInternalname( "PROFESIONALTIEMPOCITA" );
      edtProfesionalDireccion_Internalname = "PROFESIONALDIRECCION" ;
      edtPaisId_Internalname = "PAISID" ;
      edtPaisDescripcion_Internalname = "PAISDESCRIPCION" ;
      edtUbigeoCode_Internalname = "UBIGEOCODE" ;
      edtUbigeoNombre_Internalname = "UBIGEONOMBRE" ;
      imgProfesionalFoto_Internalname = "PROFESIONALFOTO" ;
      edtProfesionalTwitter_Internalname = "PROFESIONALTWITTER" ;
      edtProfesionalFacebook_Internalname = "PROFESIONALFACEBOOK" ;
      edtProfesionalInstagram_Internalname = "PROFESIONALINSTAGRAM" ;
      edtProfesionalLinkedin_Internalname = "PROFESIONALLINKEDIN" ;
      edtProfesionalTelefono_Internalname = "PROFESIONALTELEFONO" ;
      edtSecUserId_Internalname = "SECUSERID" ;
      edtProfesionalFechaRegistro_Internalname = "PROFESIONALFECHAREGISTRO" ;
      chkProfesionalTerminosCondiciones.setInternalname( "PROFESIONALTERMINOSCONDICIONES" );
      cmbProfesionalEstadoCuenta.setInternalname( "PROFESIONALESTADOCUENTA" );
      cmbProfesionalEstado.setInternalname( "PROFESIONALESTADO" );
      lblTitleespecialidad_Internalname = "TITLEESPECIALIDAD" ;
      edtEspecialidadId_Internalname = "ESPECIALIDADID" ;
      edtEspecialidadCodigo_Internalname = "ESPECIALIDADCODIGO" ;
      edtEspecialidadNombre_Internalname = "ESPECIALIDADNOMBRE" ;
      lblTitlesede_Internalname = "TITLESEDE" ;
      edtSedeId_Internalname = "SEDEID" ;
      cmbSedeTipoConsulta.setInternalname( "SEDETIPOCONSULTA" );
      edtSedeNombre_Internalname = "SEDENOMBRE" ;
      edtClinicaNombreAbreviado_Internalname = "CLINICANOMBREABREVIADO" ;
      edtCostoConsulta_Internalname = "COSTOCONSULTA" ;
      divTable2_Internalname = "TABLE2" ;
      divGrid1table_Internalname = "GRID1TABLE" ;
      lblTitleeducacion_Internalname = "TITLEEDUCACION" ;
      edtEducacionId_Internalname = "EDUCACIONID" ;
      edtEducacionNombreInstitucion_Internalname = "EDUCACIONNOMBREINSTITUCION" ;
      edtEducacionDesde_Internalname = "EDUCACIONDESDE" ;
      edtEducacionHasta_Internalname = "EDUCACIONHASTA" ;
      edtEducacionPaisDescripcion_Internalname = "EDUCACIONPAISDESCRIPCION" ;
      lblTitleexperiencialaboral_Internalname = "TITLEEXPERIENCIALABORAL" ;
      edtExperienciaLaboralId_Internalname = "EXPERIENCIALABORALID" ;
      edtExperienciaLaboralEmpresaNombre_Internalname = "EXPERIENCIALABORALEMPRESANOMBRE" ;
      edtExperienciaLaboralDesde_Internalname = "EXPERIENCIALABORALDESDE" ;
      edtExperienciaLaboralHasta_Internalname = "EXPERIENCIALABORALHASTA" ;
      lblTitlepremios_Internalname = "TITLEPREMIOS" ;
      edtPremiosId_Internalname = "PREMIOSID" ;
      edtPremiosNombre_Internalname = "PREMIOSNOMBRE" ;
      edtPremiosFecha_Internalname = "PREMIOSFECHA" ;
      edtPremiosDescripcion_Internalname = "PREMIOSDESCRIPCION" ;
      lblTitleservicios_Internalname = "TITLESERVICIOS" ;
      edtServiciosId_Internalname = "SERVICIOSID" ;
      edtServiciosNombre_Internalname = "SERVICIOSNOMBRE" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Form.setInternalname( "FORM" );
      subGridprofesional_especialidad_sede_Internalname = "GRIDPROFESIONAL_ESPECIALIDAD_SEDE" ;
      subGrid1_Internalname = "GRID1" ;
      subGridprofesional_educacion_Internalname = "GRIDPROFESIONAL_EDUCACION" ;
      subGridprofesional_experiencialaboral_Internalname = "GRIDPROFESIONAL_EXPERIENCIALABORAL" ;
      subGridprofesional_premios_Internalname = "GRIDPROFESIONAL_PREMIOS" ;
      subGridprofesional_servicios_Internalname = "GRIDPROFESIONAL_SERVICIOS" ;
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
      Form.setCaption( "Profesional" );
      edtServiciosNombre_Jsonclick = "" ;
      edtServiciosId_Jsonclick = "" ;
      subGridprofesional_servicios_Class = "Grid" ;
      subGridprofesional_servicios_Backcolorstyle = (byte)(0) ;
      edtPremiosDescripcion_Jsonclick = "" ;
      edtPremiosFecha_Jsonclick = "" ;
      edtPremiosNombre_Jsonclick = "" ;
      edtPremiosId_Jsonclick = "" ;
      subGridprofesional_premios_Class = "Grid" ;
      subGridprofesional_premios_Backcolorstyle = (byte)(0) ;
      edtExperienciaLaboralHasta_Jsonclick = "" ;
      edtExperienciaLaboralDesde_Jsonclick = "" ;
      edtExperienciaLaboralEmpresaNombre_Jsonclick = "" ;
      edtExperienciaLaboralId_Jsonclick = "" ;
      subGridprofesional_experiencialaboral_Class = "Grid" ;
      subGridprofesional_experiencialaboral_Backcolorstyle = (byte)(0) ;
      edtEducacionPaisDescripcion_Jsonclick = "" ;
      edtEducacionHasta_Jsonclick = "" ;
      edtEducacionDesde_Jsonclick = "" ;
      edtEducacionNombreInstitucion_Jsonclick = "" ;
      edtEducacionId_Jsonclick = "" ;
      subGridprofesional_educacion_Class = "Grid" ;
      subGridprofesional_educacion_Backcolorstyle = (byte)(0) ;
      edtCostoConsulta_Jsonclick = "" ;
      edtClinicaNombreAbreviado_Jsonclick = "" ;
      edtSedeNombre_Jsonclick = "" ;
      cmbSedeTipoConsulta.setJsonclick( "" );
      edtSedeId_Jsonclick = "" ;
      subGridprofesional_especialidad_sede_Class = "Grid" ;
      subGridprofesional_especialidad_sede_Backcolorstyle = (byte)(0) ;
      subGridprofesional_especialidad_sede_Allowcollapsing = (byte)(0) ;
      subGridprofesional_especialidad_sede_Allowselection = (byte)(0) ;
      subGridprofesional_especialidad_sede_Header = "" ;
      edtEspecialidadNombre_Jsonclick = "" ;
      edtEspecialidadCodigo_Jsonclick = "" ;
      edtEspecialidadId_Jsonclick = "" ;
      subGrid1_Class = "TrnSublevelGrid" ;
      edtCostoConsulta_Enabled = 1 ;
      edtClinicaNombreAbreviado_Enabled = 0 ;
      edtSedeNombre_Enabled = 0 ;
      cmbSedeTipoConsulta.setEnabled( 1 );
      edtSedeId_Enabled = 1 ;
      subGridprofesional_servicios_Allowcollapsing = (byte)(0) ;
      subGridprofesional_servicios_Allowselection = (byte)(0) ;
      edtServiciosNombre_Enabled = 1 ;
      edtServiciosId_Enabled = 1 ;
      subGridprofesional_servicios_Header = "" ;
      subGridprofesional_premios_Allowcollapsing = (byte)(0) ;
      subGridprofesional_premios_Allowselection = (byte)(0) ;
      edtPremiosDescripcion_Enabled = 1 ;
      edtPremiosFecha_Enabled = 1 ;
      edtPremiosNombre_Enabled = 1 ;
      edtPremiosId_Enabled = 1 ;
      subGridprofesional_premios_Header = "" ;
      subGridprofesional_experiencialaboral_Allowcollapsing = (byte)(0) ;
      subGridprofesional_experiencialaboral_Allowselection = (byte)(0) ;
      edtExperienciaLaboralHasta_Enabled = 1 ;
      edtExperienciaLaboralDesde_Enabled = 1 ;
      edtExperienciaLaboralEmpresaNombre_Enabled = 1 ;
      edtExperienciaLaboralId_Enabled = 1 ;
      subGridprofesional_experiencialaboral_Header = "" ;
      subGridprofesional_educacion_Allowcollapsing = (byte)(0) ;
      subGridprofesional_educacion_Allowselection = (byte)(0) ;
      edtEducacionPaisDescripcion_Enabled = 1 ;
      edtEducacionHasta_Enabled = 1 ;
      edtEducacionDesde_Enabled = 1 ;
      edtEducacionNombreInstitucion_Enabled = 1 ;
      edtEducacionId_Enabled = 1 ;
      subGridprofesional_educacion_Header = "" ;
      subGrid1_Allowcollapsing = (byte)(0) ;
      lblTitlesede_Caption = "Sede" ;
      edtEspecialidadNombre_Enabled = 0 ;
      edtEspecialidadCodigo_Enabled = 0 ;
      edtEspecialidadId_Enabled = 1 ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      cmbProfesionalEstado.setJsonclick( "" );
      cmbProfesionalEstado.setEnabled( 1 );
      cmbProfesionalEstadoCuenta.setJsonclick( "" );
      cmbProfesionalEstadoCuenta.setEnabled( 1 );
      chkProfesionalTerminosCondiciones.setEnabled( 1 );
      edtProfesionalFechaRegistro_Jsonclick = "" ;
      edtProfesionalFechaRegistro_Enabled = 1 ;
      edtSecUserId_Jsonclick = "" ;
      edtSecUserId_Enabled = 1 ;
      edtProfesionalTelefono_Jsonclick = "" ;
      edtProfesionalTelefono_Enabled = 1 ;
      edtProfesionalLinkedin_Jsonclick = "" ;
      edtProfesionalLinkedin_Enabled = 1 ;
      edtProfesionalInstagram_Jsonclick = "" ;
      edtProfesionalInstagram_Enabled = 1 ;
      edtProfesionalFacebook_Jsonclick = "" ;
      edtProfesionalFacebook_Enabled = 1 ;
      edtProfesionalTwitter_Jsonclick = "" ;
      edtProfesionalTwitter_Enabled = 1 ;
      imgProfesionalFoto_Enabled = 1 ;
      edtUbigeoNombre_Jsonclick = "" ;
      edtUbigeoNombre_Enabled = 0 ;
      edtUbigeoCode_Jsonclick = "" ;
      edtUbigeoCode_Enabled = 1 ;
      edtPaisDescripcion_Jsonclick = "" ;
      edtPaisDescripcion_Enabled = 0 ;
      edtPaisId_Jsonclick = "" ;
      edtPaisId_Enabled = 1 ;
      edtProfesionalDireccion_Enabled = 1 ;
      cmbProfesionalTiempoCita.setJsonclick( "" );
      cmbProfesionalTiempoCita.setEnabled( 1 );
      edtProfesionalColorCita_Jsonclick = "" ;
      edtProfesionalColorCita_Enabled = 1 ;
      edtProfesionalColorDisponible_Jsonclick = "" ;
      edtProfesionalColorDisponible_Enabled = 1 ;
      edtProfesionalCOP_Jsonclick = "" ;
      edtProfesionalCOP_Enabled = 1 ;
      edtProfesionalCorreo_Jsonclick = "" ;
      edtProfesionalCorreo_Enabled = 1 ;
      edtProfesionalDescripcion_Enabled = 1 ;
      cmbProfesionalSexo.setJsonclick( "" );
      cmbProfesionalSexo.setEnabled( 1 );
      edtProfesionalFechaNacimiento_Jsonclick = "" ;
      edtProfesionalFechaNacimiento_Enabled = 1 ;
      edtProfesionalNombreCompleto2_Jsonclick = "" ;
      edtProfesionalNombreCompleto2_Enabled = 0 ;
      edtProfesionalNombres_Jsonclick = "" ;
      edtProfesionalNombres_Enabled = 1 ;
      edtProfesionalApellidoMaterno_Jsonclick = "" ;
      edtProfesionalApellidoMaterno_Enabled = 1 ;
      edtProfesionalApellidoPaterno_Jsonclick = "" ;
      edtProfesionalApellidoPaterno_Enabled = 1 ;
      edtProfesionalNroDocumento_Jsonclick = "" ;
      edtProfesionalNroDocumento_Enabled = 1 ;
      cmbProfesionalTipoDocumento.setJsonclick( "" );
      cmbProfesionalTipoDocumento.setEnabled( 1 );
      edtProfesionalId_Jsonclick = "" ;
      edtProfesionalId_Enabled = 0 ;
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

   public void xc_26_089( String Gx_mode ,
                          String AV15ProfesionalNroDocumento ,
                          String AV14ProfesionalCorreo )
   {
      if ( isIns( )  )
      {
         new com.projectthani.prccrearusuariodoctor(remoteHandle, context).execute( AV15ProfesionalNroDocumento, AV14ProfesionalCorreo) ;
      }
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgrid1_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_18410( ) ;
      while ( nGXsfl_184_idx <= nRC_GXsfl_184 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0810( ) ;
         standaloneModal0810( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0810( ) ;
         Grid1Row.AddGrid("Gridprofesional_especialidad_sede", Gridprofesional_especialidad_sedeContainer);
         nGXsfl_184_idx = (int)(nGXsfl_184_idx+1) ;
         sGXsfl_184_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_184_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_18410( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxnrgridprofesional_especialidad_sede_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_20911( ) ;
      while ( nGXsfl_209_idx <= nRC_GXsfl_209 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0810( ) ;
         standaloneModal0810( ) ;
         standaloneNotModal0811( ) ;
         standaloneModal0811( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0811( ) ;
         nGXsfl_209_idx = (int)(nGXsfl_209_idx+1) ;
         sGXsfl_209_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_209_idx), 4, 0), (short)(4), "0") + sGXsfl_184_idx ;
         subsflControlProps_20911( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridprofesional_especialidad_sedeContainer)) ;
      /* End function gxnrGridprofesional_especialidad_sede_newrow */
   }

   public void gxnrgridprofesional_educacion_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_22012( ) ;
      while ( nGXsfl_220_idx <= nRC_GXsfl_220 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0812( ) ;
         standaloneModal0812( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0812( ) ;
         nGXsfl_220_idx = (int)(nGXsfl_220_idx+1) ;
         sGXsfl_220_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_220_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_22012( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridprofesional_educacionContainer)) ;
      /* End function gxnrGridprofesional_educacion_newrow */
   }

   public void gxnrgridprofesional_experiencialaboral_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_23113( ) ;
      while ( nGXsfl_231_idx <= nRC_GXsfl_231 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0813( ) ;
         standaloneModal0813( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0813( ) ;
         nGXsfl_231_idx = (int)(nGXsfl_231_idx+1) ;
         sGXsfl_231_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_231_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_23113( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridprofesional_experiencialaboralContainer)) ;
      /* End function gxnrGridprofesional_experiencialaboral_newrow */
   }

   public void gxnrgridprofesional_premios_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_24114( ) ;
      while ( nGXsfl_241_idx <= nRC_GXsfl_241 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0814( ) ;
         standaloneModal0814( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0814( ) ;
         nGXsfl_241_idx = (int)(nGXsfl_241_idx+1) ;
         sGXsfl_241_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_241_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_24114( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridprofesional_premiosContainer)) ;
      /* End function gxnrGridprofesional_premios_newrow */
   }

   public void gxnrgridprofesional_servicios_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_25115( ) ;
      while ( nGXsfl_251_idx <= nRC_GXsfl_251 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0815( ) ;
         standaloneModal0815( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0815( ) ;
         nGXsfl_251_idx = (int)(nGXsfl_251_idx+1) ;
         sGXsfl_251_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_251_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_25115( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridprofesional_serviciosContainer)) ;
      /* End function gxnrGridprofesional_servicios_newrow */
   }

   public void init_web_controls( )
   {
      cmbProfesionalTipoDocumento.setName( "PROFESIONALTIPODOCUMENTO" );
      cmbProfesionalTipoDocumento.setWebtags( "" );
      cmbProfesionalTipoDocumento.addItem("1", "DNI", (short)(0));
      cmbProfesionalTipoDocumento.addItem("6", "RUC", (short)(0));
      cmbProfesionalTipoDocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbProfesionalTipoDocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbProfesionalTipoDocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbProfesionalTipoDocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbProfesionalTipoDocumento.getItemCount() > 0 )
      {
         A173ProfesionalTipoDocumento = cmbProfesionalTipoDocumento.getValidValue(A173ProfesionalTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "A173ProfesionalTipoDocumento", A173ProfesionalTipoDocumento);
      }
      cmbProfesionalSexo.setName( "PROFESIONALSEXO" );
      cmbProfesionalSexo.setWebtags( "" );
      cmbProfesionalSexo.addItem("M", "Masculino", (short)(0));
      cmbProfesionalSexo.addItem("F", "Femenino", (short)(0));
      if ( cmbProfesionalSexo.getItemCount() > 0 )
      {
         A177ProfesionalSexo = cmbProfesionalSexo.getValidValue(A177ProfesionalSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A177ProfesionalSexo", A177ProfesionalSexo);
      }
      cmbProfesionalTiempoCita.setName( "PROFESIONALTIEMPOCITA" );
      cmbProfesionalTiempoCita.setWebtags( "" );
      cmbProfesionalTiempoCita.addItem("30", "30 minutos", (short)(0));
      cmbProfesionalTiempoCita.addItem("60", "1 hora", (short)(0));
      if ( cmbProfesionalTiempoCita.getItemCount() > 0 )
      {
         if ( (0==A182ProfesionalTiempoCita) )
         {
            A182ProfesionalTiempoCita = (byte)(30) ;
            httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0));
         }
      }
      chkProfesionalTerminosCondiciones.setName( "PROFESIONALTERMINOSCONDICIONES" );
      chkProfesionalTerminosCondiciones.setWebtags( "" );
      chkProfesionalTerminosCondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkProfesionalTerminosCondiciones.getInternalname(), "TitleCaption", chkProfesionalTerminosCondiciones.getCaption(), true);
      chkProfesionalTerminosCondiciones.setCheckedValue( "false" );
      A196ProfesionalTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( A196ProfesionalTerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A196ProfesionalTerminosCondiciones", A196ProfesionalTerminosCondiciones);
      cmbProfesionalEstadoCuenta.setName( "PROFESIONALESTADOCUENTA" );
      cmbProfesionalEstadoCuenta.setWebtags( "" );
      cmbProfesionalEstadoCuenta.addItem("CV", "Cuenta Verificada", (short)(0));
      cmbProfesionalEstadoCuenta.addItem("CP", "Cuenta Por Verificar", (short)(0));
      if ( cmbProfesionalEstadoCuenta.getItemCount() > 0 )
      {
         A197ProfesionalEstadoCuenta = cmbProfesionalEstadoCuenta.getValidValue(A197ProfesionalEstadoCuenta) ;
         httpContext.ajax_rsp_assign_attri("", false, "A197ProfesionalEstadoCuenta", A197ProfesionalEstadoCuenta);
      }
      cmbProfesionalEstado.setName( "PROFESIONALESTADO" );
      cmbProfesionalEstado.setWebtags( "" );
      cmbProfesionalEstado.addItem("A", "Activo", (short)(0));
      cmbProfesionalEstado.addItem("P", "Pendiente", (short)(0));
      cmbProfesionalEstado.addItem("I", "Inactivo", (short)(0));
      if ( cmbProfesionalEstado.getItemCount() > 0 )
      {
         if ( (GXutil.strcmp("", A198ProfesionalEstado)==0) )
         {
            A198ProfesionalEstado = "A" ;
            httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", A198ProfesionalEstado);
         }
      }
      GXCCtl = "SEDETIPOCONSULTA_" + sGXsfl_209_idx ;
      cmbSedeTipoConsulta.setName( GXCCtl );
      cmbSedeTipoConsulta.setWebtags( "" );
      cmbSedeTipoConsulta.addItem("", "Seleccione tipo de consulta", (short)(0));
      cmbSedeTipoConsulta.addItem("V", "Virtual", (short)(0));
      cmbSedeTipoConsulta.addItem("P", "En consultorio", (short)(0));
      cmbSedeTipoConsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbSedeTipoConsulta.getItemCount() > 0 )
      {
         if ( (GXutil.strcmp("", A54SedeTipoConsulta)==0) )
         {
            A54SedeTipoConsulta = "V" ;
         }
      }
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = cmbProfesionalTipoDocumento.getInternalname() ;
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

   public void valid_Profesionalid( )
   {
      A197ProfesionalEstadoCuenta = cmbProfesionalEstadoCuenta.getValue() ;
      cmbProfesionalEstadoCuenta.setValue( A197ProfesionalEstadoCuenta );
      A177ProfesionalSexo = cmbProfesionalSexo.getValue() ;
      cmbProfesionalSexo.setValue( A177ProfesionalSexo );
      A173ProfesionalTipoDocumento = cmbProfesionalTipoDocumento.getValue() ;
      cmbProfesionalTipoDocumento.setValue( A173ProfesionalTipoDocumento );
      A182ProfesionalTiempoCita = (byte)(GXutil.lval( cmbProfesionalTiempoCita.getValue())) ;
      cmbProfesionalTiempoCita.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0) );
      A198ProfesionalEstado = cmbProfesionalEstado.getValue() ;
      cmbProfesionalEstado.setValue( A198ProfesionalEstado );
      httpContext.wbHandled = (byte)(1) ;
      afterkeyloadscreen( ) ;
      draw( ) ;
      send_integrity_footer_hashes( ) ;
      dynload_actions( ) ;
      if ( cmbProfesionalTipoDocumento.getItemCount() > 0 )
      {
         A173ProfesionalTipoDocumento = cmbProfesionalTipoDocumento.getValidValue(A173ProfesionalTipoDocumento) ;
         cmbProfesionalTipoDocumento.setValue( A173ProfesionalTipoDocumento );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalTipoDocumento.setValue( GXutil.rtrim( A173ProfesionalTipoDocumento) );
      }
      if ( cmbProfesionalSexo.getItemCount() > 0 )
      {
         A177ProfesionalSexo = cmbProfesionalSexo.getValidValue(A177ProfesionalSexo) ;
         cmbProfesionalSexo.setValue( A177ProfesionalSexo );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalSexo.setValue( GXutil.rtrim( A177ProfesionalSexo) );
      }
      if ( cmbProfesionalTiempoCita.getItemCount() > 0 )
      {
         A182ProfesionalTiempoCita = (byte)(GXutil.lval( cmbProfesionalTiempoCita.getValidValue(GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0))))) ;
         cmbProfesionalTiempoCita.setValue( GXutil.ltrimstr( DecimalUtil.doubleToDec(A182ProfesionalTiempoCita), 2, 0) );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalTiempoCita.setValue( GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0)) );
      }
      A196ProfesionalTerminosCondiciones = GXutil.strtobool( GXutil.booltostr( A196ProfesionalTerminosCondiciones)) ;
      if ( cmbProfesionalEstadoCuenta.getItemCount() > 0 )
      {
         A197ProfesionalEstadoCuenta = cmbProfesionalEstadoCuenta.getValidValue(A197ProfesionalEstadoCuenta) ;
         cmbProfesionalEstadoCuenta.setValue( A197ProfesionalEstadoCuenta );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalEstadoCuenta.setValue( GXutil.rtrim( A197ProfesionalEstadoCuenta) );
      }
      if ( cmbProfesionalEstado.getItemCount() > 0 )
      {
         A198ProfesionalEstado = cmbProfesionalEstado.getValidValue(A198ProfesionalEstado) ;
         cmbProfesionalEstado.setValue( A198ProfesionalEstado );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbProfesionalEstado.setValue( GXutil.rtrim( A198ProfesionalEstado) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A173ProfesionalTipoDocumento", GXutil.rtrim( A173ProfesionalTipoDocumento));
      cmbProfesionalTipoDocumento.setValue( GXutil.rtrim( A173ProfesionalTipoDocumento) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTipoDocumento.getInternalname(), "Values", cmbProfesionalTipoDocumento.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A174ProfesionalNroDocumento", A174ProfesionalNroDocumento);
      httpContext.ajax_rsp_assign_attri("", false, "A85ProfesionalApellidoPaterno", A85ProfesionalApellidoPaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A86ProfesionalApellidoMaterno", A86ProfesionalApellidoMaterno);
      httpContext.ajax_rsp_assign_attri("", false, "A84ProfesionalNombres", A84ProfesionalNombres);
      httpContext.ajax_rsp_assign_attri("", false, "A176ProfesionalFechaNacimiento", localUtil.format(A176ProfesionalFechaNacimiento, "99/99/9999"));
      httpContext.ajax_rsp_assign_attri("", false, "A177ProfesionalSexo", GXutil.rtrim( A177ProfesionalSexo));
      cmbProfesionalSexo.setValue( GXutil.rtrim( A177ProfesionalSexo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalSexo.getInternalname(), "Values", cmbProfesionalSexo.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A178ProfesionalDescripcion", A178ProfesionalDescripcion);
      httpContext.ajax_rsp_assign_attri("", false, "A179ProfesionalCorreo", A179ProfesionalCorreo);
      httpContext.ajax_rsp_assign_attri("", false, "A88ProfesionalCOP", A88ProfesionalCOP);
      httpContext.ajax_rsp_assign_attri("", false, "A180ProfesionalColorDisponible", GXutil.rtrim( A180ProfesionalColorDisponible));
      httpContext.ajax_rsp_assign_attri("", false, "A181ProfesionalColorCita", GXutil.rtrim( A181ProfesionalColorCita));
      httpContext.ajax_rsp_assign_attri("", false, "A182ProfesionalTiempoCita", GXutil.ltrim( localUtil.ntoc( A182ProfesionalTiempoCita, (byte)(2), (byte)(0), ".", "")));
      cmbProfesionalTiempoCita.setValue( GXutil.trim( GXutil.str( A182ProfesionalTiempoCita, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalTiempoCita.getInternalname(), "Values", cmbProfesionalTiempoCita.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A183ProfesionalDireccion", A183ProfesionalDireccion);
      httpContext.ajax_rsp_assign_attri("", false, "A43PaisId", GXutil.ltrim( localUtil.ntoc( A43PaisId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A44UbigeoCode", GXutil.rtrim( A44UbigeoCode));
      httpContext.ajax_rsp_assign_attri("", false, "A189ProfesionalFoto", httpContext.getResourceRelative(A189ProfesionalFoto));
      GXCCtlgxBlob = "PROFESIONALFOTO" + "_gxBlob" ;
      httpContext.ajax_rsp_assign_attri("", false, "GXCCtlgxBlob", GXCCtlgxBlob);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, httpContext.getResourceRelative(A189ProfesionalFoto));
      httpContext.ajax_rsp_assign_attri("", false, "A40000ProfesionalFoto_GXI", A40000ProfesionalFoto_GXI);
      httpContext.ajax_rsp_assign_attri("", false, "A190ProfesionalTwitter", A190ProfesionalTwitter);
      httpContext.ajax_rsp_assign_attri("", false, "A191ProfesionalFacebook", A191ProfesionalFacebook);
      httpContext.ajax_rsp_assign_attri("", false, "A192ProfesionalInstagram", A192ProfesionalInstagram);
      httpContext.ajax_rsp_assign_attri("", false, "A193ProfesionalLinkedin", A193ProfesionalLinkedin);
      httpContext.ajax_rsp_assign_attri("", false, "A194ProfesionalTelefono", GXutil.rtrim( A194ProfesionalTelefono));
      httpContext.ajax_rsp_assign_attri("", false, "A6SecUserId", GXutil.ltrim( localUtil.ntoc( A6SecUserId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A195ProfesionalFechaRegistro", localUtil.format(A195ProfesionalFechaRegistro, "99/99/99"));
      httpContext.ajax_rsp_assign_attri("", false, "A196ProfesionalTerminosCondiciones", A196ProfesionalTerminosCondiciones);
      httpContext.ajax_rsp_assign_attri("", false, "A197ProfesionalEstadoCuenta", GXutil.rtrim( A197ProfesionalEstadoCuenta));
      cmbProfesionalEstadoCuenta.setValue( GXutil.rtrim( A197ProfesionalEstadoCuenta) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstadoCuenta.getInternalname(), "Values", cmbProfesionalEstadoCuenta.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A198ProfesionalEstado", GXutil.rtrim( A198ProfesionalEstado));
      cmbProfesionalEstado.setValue( GXutil.rtrim( A198ProfesionalEstado) );
      httpContext.ajax_rsp_assign_prop("", false, cmbProfesionalEstado.getInternalname(), "Values", cmbProfesionalEstado.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "A175ProfesionalNombreCompleto2", A175ProfesionalNombreCompleto2);
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", GXutil.rtrim( Gx_mode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z31ProfesionalId", GXutil.ltrim( localUtil.ntoc( Z31ProfesionalId, (byte)(8), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z173ProfesionalTipoDocumento", GXutil.rtrim( Z173ProfesionalTipoDocumento));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z174ProfesionalNroDocumento", Z174ProfesionalNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z85ProfesionalApellidoPaterno", Z85ProfesionalApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z86ProfesionalApellidoMaterno", Z86ProfesionalApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z84ProfesionalNombres", Z84ProfesionalNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z176ProfesionalFechaNacimiento", localUtil.format(Z176ProfesionalFechaNacimiento, "99/99/9999"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z177ProfesionalSexo", GXutil.rtrim( Z177ProfesionalSexo));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z178ProfesionalDescripcion", Z178ProfesionalDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z179ProfesionalCorreo", Z179ProfesionalCorreo);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z88ProfesionalCOP", Z88ProfesionalCOP);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z180ProfesionalColorDisponible", GXutil.rtrim( Z180ProfesionalColorDisponible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z181ProfesionalColorCita", GXutil.rtrim( Z181ProfesionalColorCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z182ProfesionalTiempoCita", GXutil.ltrim( localUtil.ntoc( Z182ProfesionalTiempoCita, (byte)(2), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z183ProfesionalDireccion", Z183ProfesionalDireccion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z43PaisId", GXutil.ltrim( localUtil.ntoc( Z43PaisId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z44UbigeoCode", GXutil.rtrim( Z44UbigeoCode));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z189ProfesionalFoto", httpContext.getResourceRelative(Z189ProfesionalFoto));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z40000ProfesionalFoto_GXI", Z40000ProfesionalFoto_GXI);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z190ProfesionalTwitter", Z190ProfesionalTwitter);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z191ProfesionalFacebook", Z191ProfesionalFacebook);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z192ProfesionalInstagram", Z192ProfesionalInstagram);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z193ProfesionalLinkedin", Z193ProfesionalLinkedin);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z194ProfesionalTelefono", GXutil.rtrim( Z194ProfesionalTelefono));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z6SecUserId", GXutil.ltrim( localUtil.ntoc( Z6SecUserId, (byte)(4), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z195ProfesionalFechaRegistro", localUtil.format(Z195ProfesionalFechaRegistro, "99/99/99"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z196ProfesionalTerminosCondiciones", GXutil.booltostr( Z196ProfesionalTerminosCondiciones));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z197ProfesionalEstadoCuenta", GXutil.rtrim( Z197ProfesionalEstadoCuenta));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z198ProfesionalEstado", GXutil.rtrim( Z198ProfesionalEstado));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z175ProfesionalNombreCompleto2", Z175ProfesionalNombreCompleto2);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z184PaisDescripcion", Z184PaisDescripcion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z186UbigeoDepartamento", Z186UbigeoDepartamento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z187UbigeoProvincia", Z187UbigeoProvincia);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z188UbigeoDistrito", Z188UbigeoDistrito);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Z185UbigeoNombre", Z185UbigeoNombre);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      sendCloseFormHiddens( ) ;
   }

   public void valid_Profesionalnrodocumento( )
   {
      if ( new com.projectthani.prcvalidarexisteprofesional(remoteHandle, context).executeUdp( GXutil.trim( A174ProfesionalNroDocumento)) && isIns( )  )
      {
         httpContext.GX_msglist.addItem("Ya existe un profesional con el nro de documento ingresado", 1, "PROFESIONALNRODOCUMENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalNroDocumento_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Profesionalfechanacimiento( )
   {
      if ( ! ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A176ProfesionalFechaNacimiento)) || (( GXutil.resetTime(A176ProfesionalFechaNacimiento).after( GXutil.resetTime( localUtil.ymdtod( 1753, 1, 1) )) ) || ( GXutil.dateCompare(GXutil.resetTime(A176ProfesionalFechaNacimiento), GXutil.resetTime(localUtil.ymdtod( 1753, 1, 1))) )) ) )
      {
         httpContext.GX_msglist.addItem("Campo Fecha Nacimiento fuera de rango", "OutOfRange", 1, "PROFESIONALFECHANACIMIENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalFechaNacimiento_Internalname ;
      }
      GXt_dtime3 = GXutil.resetTime( A176ProfesionalFechaNacimiento );
      if ( GXutil.age( GXt_dtime3, GXutil.now( )) < 18 )
      {
         httpContext.GX_msglist.addItem("La edad del profesional debe ser mayor a 18 años", 1, "PROFESIONALFECHANACIMIENTO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtProfesionalFechaNacimiento_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Paisid( )
   {
      /* Using cursor T000833 */
      pr_default.execute(31, new Object[] {Short.valueOf(A43PaisId)});
      if ( (pr_default.getStatus(31) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Pais'.", "ForeignKeyNotFound", 1, "PAISID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaisId_Internalname ;
      }
      A184PaisDescripcion = T000833_A184PaisDescripcion[0] ;
      pr_default.close(31);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A184PaisDescripcion", A184PaisDescripcion);
   }

   public void valid_Ubigeocode( )
   {
      /* Using cursor T000834 */
      pr_default.execute(32, new Object[] {A44UbigeoCode});
      if ( (pr_default.getStatus(32) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Ubigeo'.", "ForeignKeyNotFound", 1, "UBIGEOCODE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtUbigeoCode_Internalname ;
      }
      A186UbigeoDepartamento = T000834_A186UbigeoDepartamento[0] ;
      A187UbigeoProvincia = T000834_A187UbigeoProvincia[0] ;
      A188UbigeoDistrito = T000834_A188UbigeoDistrito[0] ;
      pr_default.close(32);
      A185UbigeoNombre = A186UbigeoDepartamento + " / " + A187UbigeoProvincia + " / " + A188UbigeoDistrito ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A186UbigeoDepartamento", A186UbigeoDepartamento);
      httpContext.ajax_rsp_assign_attri("", false, "A187UbigeoProvincia", A187UbigeoProvincia);
      httpContext.ajax_rsp_assign_attri("", false, "A188UbigeoDistrito", A188UbigeoDistrito);
      httpContext.ajax_rsp_assign_attri("", false, "A185UbigeoNombre", A185UbigeoNombre);
   }

   public void valid_Secuserid( )
   {
      /* Using cursor T000883 */
      pr_default.execute(81, new Object[] {Short.valueOf(A6SecUserId)});
      if ( (pr_default.getStatus(81) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'User'.", "ForeignKeyNotFound", 1, "SECUSERID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSecUserId_Internalname ;
      }
      pr_default.close(81);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Especialidadid( )
   {
      /* Using cursor T000845 */
      pr_default.execute(43, new Object[] {Short.valueOf(A32EspecialidadId)});
      if ( (pr_default.getStatus(43) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Especialidad'.", "ForeignKeyNotFound", 1, "ESPECIALIDADID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtEspecialidadId_Internalname ;
      }
      A140EspecialidadCodigo = T000845_A140EspecialidadCodigo[0] ;
      A71EspecialidadNombre = T000845_A71EspecialidadNombre[0] ;
      pr_default.close(43);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A140EspecialidadCodigo", A140EspecialidadCodigo);
      httpContext.ajax_rsp_assign_attri("", false, "A71EspecialidadNombre", A71EspecialidadNombre);
   }

   public void valid_Sedeid( )
   {
      /* Using cursor T000856 */
      pr_default.execute(54, new Object[] {Short.valueOf(A30SedeId)});
      if ( (pr_default.getStatus(54) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Sede'.", "ForeignKeyNotFound", 1, "SEDEID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtSedeId_Internalname ;
      }
      A28ClinicaId = T000856_A28ClinicaId[0] ;
      A75SedeNombre = T000856_A75SedeNombre[0] ;
      pr_default.close(54);
      /* Using cursor T000857 */
      pr_default.execute(55, new Object[] {Short.valueOf(A28ClinicaId)});
      if ( (pr_default.getStatus(55) == 101) )
      {
         httpContext.GX_msglist.addItem("No existe 'Clinica'.", "ForeignKeyNotFound", 1, "CLINICAID");
         AnyError = (short)(1) ;
      }
      A80ClinicaNombreAbreviado = T000857_A80ClinicaNombreAbreviado[0] ;
      pr_default.close(55);
      dynload_actions( ) ;
      if ( cmbSedeTipoConsulta.getItemCount() > 0 )
      {
         A54SedeTipoConsulta = cmbSedeTipoConsulta.getValidValue(A54SedeTipoConsulta) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbSedeTipoConsulta.setValue( GXutil.rtrim( A54SedeTipoConsulta) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A28ClinicaId", GXutil.ltrim( localUtil.ntoc( A28ClinicaId, (byte)(4), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "A75SedeNombre", A75SedeNombre);
      httpContext.ajax_rsp_assign_attri("", false, "A80ClinicaNombreAbreviado", A80ClinicaNombreAbreviado);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALID","{handler:'valid_Profesionalid',iparms:[{av:'cmbProfesionalEstadoCuenta'},{av:'A197ProfesionalEstadoCuenta',fld:'PROFESIONALESTADOCUENTA',pic:''},{av:'cmbProfesionalSexo'},{av:'A177ProfesionalSexo',fld:'PROFESIONALSEXO',pic:''},{av:'cmbProfesionalTipoDocumento'},{av:'A173ProfesionalTipoDocumento',fld:'PROFESIONALTIPODOCUMENTO',pic:''},{av:'A31ProfesionalId',fld:'PROFESIONALID',pic:'ZZZZZZZ9'},{av:'Gx_BScreen',fld:'vGXBSCREEN',pic:'9'},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'cmbProfesionalTiempoCita'},{av:'A182ProfesionalTiempoCita',fld:'PROFESIONALTIEMPOCITA',pic:'Z9'},{av:'A180ProfesionalColorDisponible',fld:'PROFESIONALCOLORDISPONIBLE',pic:''},{av:'A181ProfesionalColorCita',fld:'PROFESIONALCOLORCITA',pic:''},{av:'cmbProfesionalEstado'},{av:'A198ProfesionalEstado',fld:'PROFESIONALESTADO',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALID",",oparms:[{av:'cmbProfesionalTipoDocumento'},{av:'A173ProfesionalTipoDocumento',fld:'PROFESIONALTIPODOCUMENTO',pic:''},{av:'A174ProfesionalNroDocumento',fld:'PROFESIONALNRODOCUMENTO',pic:''},{av:'A85ProfesionalApellidoPaterno',fld:'PROFESIONALAPELLIDOPATERNO',pic:''},{av:'A86ProfesionalApellidoMaterno',fld:'PROFESIONALAPELLIDOMATERNO',pic:''},{av:'A84ProfesionalNombres',fld:'PROFESIONALNOMBRES',pic:''},{av:'A176ProfesionalFechaNacimiento',fld:'PROFESIONALFECHANACIMIENTO',pic:''},{av:'cmbProfesionalSexo'},{av:'A177ProfesionalSexo',fld:'PROFESIONALSEXO',pic:''},{av:'A178ProfesionalDescripcion',fld:'PROFESIONALDESCRIPCION',pic:''},{av:'A179ProfesionalCorreo',fld:'PROFESIONALCORREO',pic:''},{av:'A88ProfesionalCOP',fld:'PROFESIONALCOP',pic:''},{av:'A180ProfesionalColorDisponible',fld:'PROFESIONALCOLORDISPONIBLE',pic:''},{av:'A181ProfesionalColorCita',fld:'PROFESIONALCOLORCITA',pic:''},{av:'cmbProfesionalTiempoCita'},{av:'A182ProfesionalTiempoCita',fld:'PROFESIONALTIEMPOCITA',pic:'Z9'},{av:'A183ProfesionalDireccion',fld:'PROFESIONALDIRECCION',pic:''},{av:'A43PaisId',fld:'PAISID',pic:'ZZZ9'},{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:''},{av:'A189ProfesionalFoto',fld:'PROFESIONALFOTO',pic:''},{av:'A40000ProfesionalFoto_GXI',fld:'PROFESIONALFOTO_GXI',pic:''},{av:'A190ProfesionalTwitter',fld:'PROFESIONALTWITTER',pic:''},{av:'A191ProfesionalFacebook',fld:'PROFESIONALFACEBOOK',pic:''},{av:'A192ProfesionalInstagram',fld:'PROFESIONALINSTAGRAM',pic:''},{av:'A193ProfesionalLinkedin',fld:'PROFESIONALLINKEDIN',pic:''},{av:'A194ProfesionalTelefono',fld:'PROFESIONALTELEFONO',pic:''},{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'A195ProfesionalFechaRegistro',fld:'PROFESIONALFECHAREGISTRO',pic:''},{av:'cmbProfesionalEstadoCuenta'},{av:'A197ProfesionalEstadoCuenta',fld:'PROFESIONALESTADOCUENTA',pic:''},{av:'cmbProfesionalEstado'},{av:'A198ProfesionalEstado',fld:'PROFESIONALESTADO',pic:''},{av:'A175ProfesionalNombreCompleto2',fld:'PROFESIONALNOMBRECOMPLETO2',pic:''},{av:'A184PaisDescripcion',fld:'PAISDESCRIPCION',pic:''},{av:'A186UbigeoDepartamento',fld:'UBIGEODEPARTAMENTO',pic:''},{av:'A187UbigeoProvincia',fld:'UBIGEOPROVINCIA',pic:''},{av:'A188UbigeoDistrito',fld:'UBIGEODISTRITO',pic:''},{av:'A185UbigeoNombre',fld:'UBIGEONOMBRE',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'Z31ProfesionalId'},{av:'Z173ProfesionalTipoDocumento'},{av:'Z174ProfesionalNroDocumento'},{av:'Z85ProfesionalApellidoPaterno'},{av:'Z86ProfesionalApellidoMaterno'},{av:'Z84ProfesionalNombres'},{av:'Z176ProfesionalFechaNacimiento'},{av:'Z177ProfesionalSexo'},{av:'Z178ProfesionalDescripcion'},{av:'Z179ProfesionalCorreo'},{av:'Z88ProfesionalCOP'},{av:'Z180ProfesionalColorDisponible'},{av:'Z181ProfesionalColorCita'},{av:'Z182ProfesionalTiempoCita'},{av:'Z183ProfesionalDireccion'},{av:'Z43PaisId'},{av:'Z44UbigeoCode'},{av:'Z189ProfesionalFoto'},{av:'Z40000ProfesionalFoto_GXI'},{av:'Z190ProfesionalTwitter'},{av:'Z191ProfesionalFacebook'},{av:'Z192ProfesionalInstagram'},{av:'Z193ProfesionalLinkedin'},{av:'Z194ProfesionalTelefono'},{av:'Z6SecUserId'},{av:'Z195ProfesionalFechaRegistro'},{av:'Z196ProfesionalTerminosCondiciones'},{av:'Z197ProfesionalEstadoCuenta'},{av:'Z198ProfesionalEstado'},{av:'Z175ProfesionalNombreCompleto2'},{av:'Z184PaisDescripcion'},{av:'Z186UbigeoDepartamento'},{av:'Z187UbigeoProvincia'},{av:'Z188UbigeoDistrito'},{av:'Z185UbigeoNombre'},{ctrl:'BTN_DELETE',prop:'Enabled'},{ctrl:'BTN_ENTER',prop:'Enabled'},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALTIPODOCUMENTO","{handler:'valid_Profesionaltipodocumento',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALTIPODOCUMENTO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALNRODOCUMENTO","{handler:'valid_Profesionalnrodocumento',iparms:[{av:'A174ProfesionalNroDocumento',fld:'PROFESIONALNRODOCUMENTO',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALNRODOCUMENTO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO","{handler:'valid_Profesionalapellidopaterno',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOPATERNO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO","{handler:'valid_Profesionalapellidomaterno',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALAPELLIDOMATERNO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALNOMBRES","{handler:'valid_Profesionalnombres',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALNOMBRES",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALFECHANACIMIENTO","{handler:'valid_Profesionalfechanacimiento',iparms:[{av:'A176ProfesionalFechaNacimiento',fld:'PROFESIONALFECHANACIMIENTO',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALFECHANACIMIENTO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALSEXO","{handler:'valid_Profesionalsexo',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALSEXO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALCORREO","{handler:'valid_Profesionalcorreo',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALCORREO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALTIEMPOCITA","{handler:'valid_Profesionaltiempocita',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALTIEMPOCITA",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PAISID","{handler:'valid_Paisid',iparms:[{av:'A43PaisId',fld:'PAISID',pic:'ZZZ9'},{av:'A184PaisDescripcion',fld:'PAISDESCRIPCION',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PAISID",",oparms:[{av:'A184PaisDescripcion',fld:'PAISDESCRIPCION',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_UBIGEOCODE","{handler:'valid_Ubigeocode',iparms:[{av:'A44UbigeoCode',fld:'UBIGEOCODE',pic:''},{av:'A186UbigeoDepartamento',fld:'UBIGEODEPARTAMENTO',pic:''},{av:'A187UbigeoProvincia',fld:'UBIGEOPROVINCIA',pic:''},{av:'A188UbigeoDistrito',fld:'UBIGEODISTRITO',pic:''},{av:'A185UbigeoNombre',fld:'UBIGEONOMBRE',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_UBIGEOCODE",",oparms:[{av:'A186UbigeoDepartamento',fld:'UBIGEODEPARTAMENTO',pic:''},{av:'A187UbigeoProvincia',fld:'UBIGEOPROVINCIA',pic:''},{av:'A188UbigeoDistrito',fld:'UBIGEODISTRITO',pic:''},{av:'A185UbigeoNombre',fld:'UBIGEONOMBRE',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALTWITTER","{handler:'valid_Profesionaltwitter',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALTWITTER",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALFACEBOOK","{handler:'valid_Profesionalfacebook',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALFACEBOOK",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALINSTAGRAM","{handler:'valid_Profesionalinstagram',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALINSTAGRAM",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALLINKEDIN","{handler:'valid_Profesionallinkedin',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALLINKEDIN",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_SECUSERID","{handler:'valid_Secuserid',iparms:[{av:'A6SecUserId',fld:'SECUSERID',pic:'ZZZ9'},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_SECUSERID",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALFECHAREGISTRO","{handler:'valid_Profesionalfecharegistro',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALFECHAREGISTRO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALESTADOCUENTA","{handler:'valid_Profesionalestadocuenta',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALESTADOCUENTA",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PROFESIONALESTADO","{handler:'valid_Profesionalestado',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PROFESIONALESTADO",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_ESPECIALIDADID","{handler:'valid_Especialidadid',iparms:[{av:'A32EspecialidadId',fld:'ESPECIALIDADID',pic:'ZZZ9'},{av:'A140EspecialidadCodigo',fld:'ESPECIALIDADCODIGO',pic:''},{av:'A71EspecialidadNombre',fld:'ESPECIALIDADNOMBRE',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_ESPECIALIDADID",",oparms:[{av:'A140EspecialidadCodigo',fld:'ESPECIALIDADCODIGO',pic:''},{av:'A71EspecialidadNombre',fld:'ESPECIALIDADNOMBRE',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Especialidadnombre',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_SEDEID","{handler:'valid_Sedeid',iparms:[{av:'A30SedeId',fld:'SEDEID',pic:'ZZZ9'},{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'},{av:'A75SedeNombre',fld:'SEDENOMBRE',pic:''},{av:'A80ClinicaNombreAbreviado',fld:'CLINICANOMBREABREVIADO',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_SEDEID",",oparms:[{av:'A28ClinicaId',fld:'CLINICAID',pic:'ZZZ9'},{av:'A75SedeNombre',fld:'SEDENOMBRE',pic:''},{av:'A80ClinicaNombreAbreviado',fld:'CLINICANOMBREABREVIADO',pic:''},{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_SEDETIPOCONSULTA","{handler:'valid_Sedetipoconsulta',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_SEDETIPOCONSULTA",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Costoconsulta',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_EDUCACIONID","{handler:'valid_Educacionid',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_EDUCACIONID",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_EDUCACIONDESDE","{handler:'valid_Educaciondesde',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_EDUCACIONDESDE",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_EDUCACIONHASTA","{handler:'valid_Educacionhasta',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_EDUCACIONHASTA",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Educacionpaisdescripcion',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_EXPERIENCIALABORALID","{handler:'valid_Experiencialaboralid',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_EXPERIENCIALABORALID",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_EXPERIENCIALABORALDESDE","{handler:'valid_Experiencialaboraldesde',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_EXPERIENCIALABORALDESDE",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_EXPERIENCIALABORALHASTA","{handler:'valid_Experiencialaboralhasta',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_EXPERIENCIALABORALHASTA",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PREMIOSID","{handler:'valid_Premiosid',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PREMIOSID",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_PREMIOSFECHA","{handler:'valid_Premiosfecha',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_PREMIOSFECHA",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Premiosdescripcion',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALID_SERVICIOSID","{handler:'valid_Serviciosid',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALID_SERVICIOSID",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Serviciosnombre',iparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'A196ProfesionalTerminosCondiciones',fld:'PROFESIONALTERMINOSCONDICIONES',pic:''}]}");
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
      pr_default.close(54);
      pr_default.close(55);
      pr_default.close(43);
      pr_default.close(31);
      pr_default.close(32);
      pr_default.close(81);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      Z173ProfesionalTipoDocumento = "" ;
      Z174ProfesionalNroDocumento = "" ;
      Z85ProfesionalApellidoPaterno = "" ;
      Z86ProfesionalApellidoMaterno = "" ;
      Z84ProfesionalNombres = "" ;
      Z176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      Z177ProfesionalSexo = "" ;
      Z178ProfesionalDescripcion = "" ;
      Z179ProfesionalCorreo = "" ;
      Z88ProfesionalCOP = "" ;
      Z180ProfesionalColorDisponible = "" ;
      Z181ProfesionalColorCita = "" ;
      Z183ProfesionalDireccion = "" ;
      Z190ProfesionalTwitter = "" ;
      Z191ProfesionalFacebook = "" ;
      Z192ProfesionalInstagram = "" ;
      Z193ProfesionalLinkedin = "" ;
      Z194ProfesionalTelefono = "" ;
      Z195ProfesionalFechaRegistro = GXutil.nullDate() ;
      Z197ProfesionalEstadoCuenta = "" ;
      Z198ProfesionalEstado = "" ;
      Z44UbigeoCode = "" ;
      N174ProfesionalNroDocumento = "" ;
      Z54SedeTipoConsulta = "" ;
      Z199CostoConsulta = DecimalUtil.ZERO ;
      Z55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      Z200EducacionNombreInstitucion = "" ;
      Z201EducacionDesde = GXutil.nullDate() ;
      Z202EducacionHasta = GXutil.nullDate() ;
      Z203EducacionPaisDescripcion = "" ;
      Z56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      Z204ExperienciaLaboralEmpresaNombre = "" ;
      Z205ExperienciaLaboralDesde = GXutil.nullDate() ;
      Z206ExperienciaLaboralHasta = GXutil.nullDate() ;
      Z57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      Z207PremiosNombre = "" ;
      Z208PremiosFecha = GXutil.nullDate() ;
      Z58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      Z210ServiciosNombre = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV15ProfesionalNroDocumento = "" ;
      AV14ProfesionalCorreo = "" ;
      A44UbigeoCode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A173ProfesionalTipoDocumento = "" ;
      A177ProfesionalSexo = "" ;
      A197ProfesionalEstadoCuenta = "" ;
      A198ProfesionalEstado = "" ;
      lblTitle_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A174ProfesionalNroDocumento = "" ;
      A85ProfesionalApellidoPaterno = "" ;
      A86ProfesionalApellidoMaterno = "" ;
      A84ProfesionalNombres = "" ;
      A175ProfesionalNombreCompleto2 = "" ;
      A176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      A178ProfesionalDescripcion = "" ;
      A179ProfesionalCorreo = "" ;
      A88ProfesionalCOP = "" ;
      A180ProfesionalColorDisponible = "" ;
      A181ProfesionalColorCita = "" ;
      A183ProfesionalDireccion = "" ;
      A184PaisDescripcion = "" ;
      A185UbigeoNombre = "" ;
      A189ProfesionalFoto = "" ;
      A40000ProfesionalFoto_GXI = "" ;
      sImgUrl = "" ;
      A190ProfesionalTwitter = "" ;
      A191ProfesionalFacebook = "" ;
      A192ProfesionalInstagram = "" ;
      A193ProfesionalLinkedin = "" ;
      gxphoneLink = "" ;
      A194ProfesionalTelefono = "" ;
      A195ProfesionalFechaRegistro = GXutil.nullDate() ;
      lblTitleespecialidad_Jsonclick = "" ;
      lblTitleeducacion_Jsonclick = "" ;
      lblTitleexperiencialaboral_Jsonclick = "" ;
      lblTitlepremios_Jsonclick = "" ;
      lblTitleservicios_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      subGrid1_Header = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      A140EspecialidadCodigo = "" ;
      A71EspecialidadNombre = "" ;
      sMode10 = "" ;
      sStyleString = "" ;
      Gridprofesional_educacionContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridprofesional_educacionColumn = new com.genexus.webpanels.GXWebColumn();
      A55EducacionId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A200EducacionNombreInstitucion = "" ;
      A201EducacionDesde = GXutil.nullDate() ;
      A202EducacionHasta = GXutil.nullDate() ;
      A203EducacionPaisDescripcion = "" ;
      sMode12 = "" ;
      Gridprofesional_experiencialaboralContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridprofesional_experiencialaboralColumn = new com.genexus.webpanels.GXWebColumn();
      A56ExperienciaLaboralId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A204ExperienciaLaboralEmpresaNombre = "" ;
      A205ExperienciaLaboralDesde = GXutil.nullDate() ;
      A206ExperienciaLaboralHasta = GXutil.nullDate() ;
      sMode13 = "" ;
      Gridprofesional_premiosContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridprofesional_premiosColumn = new com.genexus.webpanels.GXWebColumn();
      A57PremiosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A207PremiosNombre = "" ;
      A208PremiosFecha = GXutil.nullDate() ;
      A209PremiosDescripcion = "" ;
      sMode14 = "" ;
      Gridprofesional_serviciosContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridprofesional_serviciosColumn = new com.genexus.webpanels.GXWebColumn();
      A58ServiciosId = java.util.UUID.fromString("00000000-0000-0000-0000-000000000000") ;
      A210ServiciosNombre = "" ;
      sMode15 = "" ;
      A186UbigeoDepartamento = "" ;
      A187UbigeoProvincia = "" ;
      A188UbigeoDistrito = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      forbiddenHiddens2 = new com.genexus.util.GXProperties();
      hsh2 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A54SedeTipoConsulta = "" ;
      A75SedeNombre = "" ;
      A80ClinicaNombreAbreviado = "" ;
      A199CostoConsulta = DecimalUtil.ZERO ;
      Z189ProfesionalFoto = "" ;
      Z40000ProfesionalFoto_GXI = "" ;
      Z184PaisDescripcion = "" ;
      Z186UbigeoDepartamento = "" ;
      Z187UbigeoProvincia = "" ;
      Z188UbigeoDistrito = "" ;
      T000822_A31ProfesionalId = new int[1] ;
      T000822_A173ProfesionalTipoDocumento = new String[] {""} ;
      T000822_A174ProfesionalNroDocumento = new String[] {""} ;
      T000822_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000822_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000822_A84ProfesionalNombres = new String[] {""} ;
      T000822_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      T000822_A177ProfesionalSexo = new String[] {""} ;
      T000822_A178ProfesionalDescripcion = new String[] {""} ;
      T000822_A179ProfesionalCorreo = new String[] {""} ;
      T000822_A88ProfesionalCOP = new String[] {""} ;
      T000822_A180ProfesionalColorDisponible = new String[] {""} ;
      T000822_A181ProfesionalColorCita = new String[] {""} ;
      T000822_A182ProfesionalTiempoCita = new byte[1] ;
      T000822_A183ProfesionalDireccion = new String[] {""} ;
      T000822_A184PaisDescripcion = new String[] {""} ;
      T000822_A189ProfesionalFoto = new String[] {""} ;
      T000822_A40000ProfesionalFoto_GXI = new String[] {""} ;
      T000822_A190ProfesionalTwitter = new String[] {""} ;
      T000822_A191ProfesionalFacebook = new String[] {""} ;
      T000822_A192ProfesionalInstagram = new String[] {""} ;
      T000822_A193ProfesionalLinkedin = new String[] {""} ;
      T000822_A194ProfesionalTelefono = new String[] {""} ;
      T000822_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T000822_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      T000822_A197ProfesionalEstadoCuenta = new String[] {""} ;
      T000822_A198ProfesionalEstado = new String[] {""} ;
      T000822_A186UbigeoDepartamento = new String[] {""} ;
      T000822_A187UbigeoProvincia = new String[] {""} ;
      T000822_A188UbigeoDistrito = new String[] {""} ;
      T000822_A43PaisId = new short[1] ;
      T000822_A44UbigeoCode = new String[] {""} ;
      T000822_A6SecUserId = new short[1] ;
      T000819_A184PaisDescripcion = new String[] {""} ;
      T000820_A186UbigeoDepartamento = new String[] {""} ;
      T000820_A187UbigeoProvincia = new String[] {""} ;
      T000820_A188UbigeoDistrito = new String[] {""} ;
      T000821_A6SecUserId = new short[1] ;
      T000823_A184PaisDescripcion = new String[] {""} ;
      T000824_A186UbigeoDepartamento = new String[] {""} ;
      T000824_A187UbigeoProvincia = new String[] {""} ;
      T000824_A188UbigeoDistrito = new String[] {""} ;
      T000825_A6SecUserId = new short[1] ;
      T000826_A31ProfesionalId = new int[1] ;
      T000818_A31ProfesionalId = new int[1] ;
      T000818_A173ProfesionalTipoDocumento = new String[] {""} ;
      T000818_A174ProfesionalNroDocumento = new String[] {""} ;
      T000818_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000818_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000818_A84ProfesionalNombres = new String[] {""} ;
      T000818_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      T000818_A177ProfesionalSexo = new String[] {""} ;
      T000818_A178ProfesionalDescripcion = new String[] {""} ;
      T000818_A179ProfesionalCorreo = new String[] {""} ;
      T000818_A88ProfesionalCOP = new String[] {""} ;
      T000818_A180ProfesionalColorDisponible = new String[] {""} ;
      T000818_A181ProfesionalColorCita = new String[] {""} ;
      T000818_A182ProfesionalTiempoCita = new byte[1] ;
      T000818_A183ProfesionalDireccion = new String[] {""} ;
      T000818_A189ProfesionalFoto = new String[] {""} ;
      T000818_A40000ProfesionalFoto_GXI = new String[] {""} ;
      T000818_A190ProfesionalTwitter = new String[] {""} ;
      T000818_A191ProfesionalFacebook = new String[] {""} ;
      T000818_A192ProfesionalInstagram = new String[] {""} ;
      T000818_A193ProfesionalLinkedin = new String[] {""} ;
      T000818_A194ProfesionalTelefono = new String[] {""} ;
      T000818_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T000818_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      T000818_A197ProfesionalEstadoCuenta = new String[] {""} ;
      T000818_A198ProfesionalEstado = new String[] {""} ;
      T000818_A43PaisId = new short[1] ;
      T000818_A44UbigeoCode = new String[] {""} ;
      T000818_A6SecUserId = new short[1] ;
      sMode9 = "" ;
      T000827_A31ProfesionalId = new int[1] ;
      T000828_A31ProfesionalId = new int[1] ;
      T000817_A31ProfesionalId = new int[1] ;
      T000817_A173ProfesionalTipoDocumento = new String[] {""} ;
      T000817_A174ProfesionalNroDocumento = new String[] {""} ;
      T000817_A85ProfesionalApellidoPaterno = new String[] {""} ;
      T000817_A86ProfesionalApellidoMaterno = new String[] {""} ;
      T000817_A84ProfesionalNombres = new String[] {""} ;
      T000817_A176ProfesionalFechaNacimiento = new java.util.Date[] {GXutil.nullDate()} ;
      T000817_A177ProfesionalSexo = new String[] {""} ;
      T000817_A178ProfesionalDescripcion = new String[] {""} ;
      T000817_A179ProfesionalCorreo = new String[] {""} ;
      T000817_A88ProfesionalCOP = new String[] {""} ;
      T000817_A180ProfesionalColorDisponible = new String[] {""} ;
      T000817_A181ProfesionalColorCita = new String[] {""} ;
      T000817_A182ProfesionalTiempoCita = new byte[1] ;
      T000817_A183ProfesionalDireccion = new String[] {""} ;
      T000817_A189ProfesionalFoto = new String[] {""} ;
      T000817_A40000ProfesionalFoto_GXI = new String[] {""} ;
      T000817_A190ProfesionalTwitter = new String[] {""} ;
      T000817_A191ProfesionalFacebook = new String[] {""} ;
      T000817_A192ProfesionalInstagram = new String[] {""} ;
      T000817_A193ProfesionalLinkedin = new String[] {""} ;
      T000817_A194ProfesionalTelefono = new String[] {""} ;
      T000817_A195ProfesionalFechaRegistro = new java.util.Date[] {GXutil.nullDate()} ;
      T000817_A196ProfesionalTerminosCondiciones = new boolean[] {false} ;
      T000817_A197ProfesionalEstadoCuenta = new String[] {""} ;
      T000817_A198ProfesionalEstado = new String[] {""} ;
      T000817_A43PaisId = new short[1] ;
      T000817_A44UbigeoCode = new String[] {""} ;
      T000817_A6SecUserId = new short[1] ;
      T000829_A31ProfesionalId = new int[1] ;
      T000833_A184PaisDescripcion = new String[] {""} ;
      T000834_A186UbigeoDepartamento = new String[] {""} ;
      T000834_A187UbigeoProvincia = new String[] {""} ;
      T000834_A188UbigeoDistrito = new String[] {""} ;
      T000835_A63ComentarioProfesionalId = new int[1] ;
      T000836_A60RatingProfesionalId = new int[1] ;
      T000837_A59EducacionProfesionalId = new int[1] ;
      T000838_A31ProfesionalId = new int[1] ;
      T000838_A32EspecialidadId = new short[1] ;
      T000839_A31ProfesionalId = new int[1] ;
      Z140EspecialidadCodigo = "" ;
      Z71EspecialidadNombre = "" ;
      T000840_A31ProfesionalId = new int[1] ;
      T000840_A140EspecialidadCodigo = new String[] {""} ;
      T000840_A71EspecialidadNombre = new String[] {""} ;
      T000840_A32EspecialidadId = new short[1] ;
      T000816_A140EspecialidadCodigo = new String[] {""} ;
      T000816_A71EspecialidadNombre = new String[] {""} ;
      T000841_A140EspecialidadCodigo = new String[] {""} ;
      T000841_A71EspecialidadNombre = new String[] {""} ;
      T000842_A31ProfesionalId = new int[1] ;
      T000842_A32EspecialidadId = new short[1] ;
      T000815_A31ProfesionalId = new int[1] ;
      T000815_A32EspecialidadId = new short[1] ;
      T000814_A31ProfesionalId = new int[1] ;
      T000814_A32EspecialidadId = new short[1] ;
      T000845_A140EspecialidadCodigo = new String[] {""} ;
      T000845_A71EspecialidadNombre = new String[] {""} ;
      T000846_A34DisponibilidadId = new int[1] ;
      T000847_A29ConfComisionId = new short[1] ;
      T000848_A31ProfesionalId = new int[1] ;
      T000848_A32EspecialidadId = new short[1] ;
      Z75SedeNombre = "" ;
      Z80ClinicaNombreAbreviado = "" ;
      T000849_A28ClinicaId = new short[1] ;
      T000849_A31ProfesionalId = new int[1] ;
      T000849_A32EspecialidadId = new short[1] ;
      T000849_A54SedeTipoConsulta = new String[] {""} ;
      T000849_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000849_A75SedeNombre = new String[] {""} ;
      T000849_A80ClinicaNombreAbreviado = new String[] {""} ;
      T000849_A30SedeId = new short[1] ;
      T000812_A28ClinicaId = new short[1] ;
      T000812_A75SedeNombre = new String[] {""} ;
      T000813_A80ClinicaNombreAbreviado = new String[] {""} ;
      T000850_A28ClinicaId = new short[1] ;
      T000850_A75SedeNombre = new String[] {""} ;
      T000851_A80ClinicaNombreAbreviado = new String[] {""} ;
      T000852_A31ProfesionalId = new int[1] ;
      T000852_A32EspecialidadId = new short[1] ;
      T000852_A30SedeId = new short[1] ;
      T000852_A54SedeTipoConsulta = new String[] {""} ;
      T000811_A31ProfesionalId = new int[1] ;
      T000811_A32EspecialidadId = new short[1] ;
      T000811_A54SedeTipoConsulta = new String[] {""} ;
      T000811_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000811_A30SedeId = new short[1] ;
      sMode11 = "" ;
      T000810_A31ProfesionalId = new int[1] ;
      T000810_A32EspecialidadId = new short[1] ;
      T000810_A54SedeTipoConsulta = new String[] {""} ;
      T000810_A199CostoConsulta = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000810_A30SedeId = new short[1] ;
      T000856_A28ClinicaId = new short[1] ;
      T000856_A75SedeNombre = new String[] {""} ;
      T000857_A80ClinicaNombreAbreviado = new String[] {""} ;
      T000858_A31ProfesionalId = new int[1] ;
      T000858_A32EspecialidadId = new short[1] ;
      T000858_A30SedeId = new short[1] ;
      T000858_A54SedeTipoConsulta = new String[] {""} ;
      T000859_A31ProfesionalId = new int[1] ;
      T000859_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T000859_A200EducacionNombreInstitucion = new String[] {""} ;
      T000859_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T000859_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T000859_A203EducacionPaisDescripcion = new String[] {""} ;
      T000860_A31ProfesionalId = new int[1] ;
      T000860_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00089_A31ProfesionalId = new int[1] ;
      T00089_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00089_A200EducacionNombreInstitucion = new String[] {""} ;
      T00089_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T00089_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T00089_A203EducacionPaisDescripcion = new String[] {""} ;
      T00088_A31ProfesionalId = new int[1] ;
      T00088_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00088_A200EducacionNombreInstitucion = new String[] {""} ;
      T00088_A201EducacionDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T00088_A202EducacionHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T00088_A203EducacionPaisDescripcion = new String[] {""} ;
      T000864_A31ProfesionalId = new int[1] ;
      T000864_A55EducacionId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T000865_A31ProfesionalId = new int[1] ;
      T000865_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T000865_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      T000865_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T000865_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T000866_A31ProfesionalId = new int[1] ;
      T000866_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00087_A31ProfesionalId = new int[1] ;
      T00087_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00087_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      T00087_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T00087_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T00086_A31ProfesionalId = new int[1] ;
      T00086_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00086_A204ExperienciaLaboralEmpresaNombre = new String[] {""} ;
      T00086_A205ExperienciaLaboralDesde = new java.util.Date[] {GXutil.nullDate()} ;
      T00086_A206ExperienciaLaboralHasta = new java.util.Date[] {GXutil.nullDate()} ;
      T000870_A31ProfesionalId = new int[1] ;
      T000870_A56ExperienciaLaboralId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      Z209PremiosDescripcion = "" ;
      T000871_A31ProfesionalId = new int[1] ;
      T000871_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T000871_A207PremiosNombre = new String[] {""} ;
      T000871_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T000871_A209PremiosDescripcion = new String[] {""} ;
      T000872_A31ProfesionalId = new int[1] ;
      T000872_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00085_A31ProfesionalId = new int[1] ;
      T00085_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00085_A207PremiosNombre = new String[] {""} ;
      T00085_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00085_A209PremiosDescripcion = new String[] {""} ;
      T00084_A31ProfesionalId = new int[1] ;
      T00084_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00084_A207PremiosNombre = new String[] {""} ;
      T00084_A208PremiosFecha = new java.util.Date[] {GXutil.nullDate()} ;
      T00084_A209PremiosDescripcion = new String[] {""} ;
      T000876_A31ProfesionalId = new int[1] ;
      T000876_A57PremiosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T000877_A31ProfesionalId = new int[1] ;
      T000877_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T000877_A210ServiciosNombre = new String[] {""} ;
      T000878_A31ProfesionalId = new int[1] ;
      T000878_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00083_A31ProfesionalId = new int[1] ;
      T00083_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00083_A210ServiciosNombre = new String[] {""} ;
      T00082_A31ProfesionalId = new int[1] ;
      T00082_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      T00082_A210ServiciosNombre = new String[] {""} ;
      T000882_A31ProfesionalId = new int[1] ;
      T000882_A58ServiciosId = new java.util.UUID[] {java.util.UUID.fromString("00000000-0000-0000-0000-000000000000")} ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      subGrid1_Linesclass = "" ;
      ROClassString = "" ;
      lblTitlesede_Jsonclick = "" ;
      Gridprofesional_especialidad_sedeContainer = new com.genexus.webpanels.GXWebGrid(context);
      Gridprofesional_especialidad_sedeColumn = new com.genexus.webpanels.GXWebColumn();
      Gridprofesional_especialidad_sedeRow = new com.genexus.webpanels.GXWebRow();
      subGridprofesional_especialidad_sede_Linesclass = "" ;
      Gridprofesional_educacionRow = new com.genexus.webpanels.GXWebRow();
      subGridprofesional_educacion_Linesclass = "" ;
      Gridprofesional_experiencialaboralRow = new com.genexus.webpanels.GXWebRow();
      subGridprofesional_experiencialaboral_Linesclass = "" ;
      Gridprofesional_premiosRow = new com.genexus.webpanels.GXWebRow();
      subGridprofesional_premios_Linesclass = "" ;
      Gridprofesional_serviciosRow = new com.genexus.webpanels.GXWebRow();
      subGridprofesional_servicios_Linesclass = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      i180ProfesionalColorDisponible = "" ;
      i181ProfesionalColorCita = "" ;
      i198ProfesionalEstado = "" ;
      i199CostoConsulta = DecimalUtil.ZERO ;
      Z175ProfesionalNombreCompleto2 = "" ;
      Z185UbigeoNombre = "" ;
      ZZ173ProfesionalTipoDocumento = "" ;
      ZZ174ProfesionalNroDocumento = "" ;
      ZZ85ProfesionalApellidoPaterno = "" ;
      ZZ86ProfesionalApellidoMaterno = "" ;
      ZZ84ProfesionalNombres = "" ;
      ZZ176ProfesionalFechaNacimiento = GXutil.nullDate() ;
      ZZ177ProfesionalSexo = "" ;
      ZZ178ProfesionalDescripcion = "" ;
      ZZ179ProfesionalCorreo = "" ;
      ZZ88ProfesionalCOP = "" ;
      ZZ180ProfesionalColorDisponible = "" ;
      ZZ181ProfesionalColorCita = "" ;
      ZZ183ProfesionalDireccion = "" ;
      ZZ44UbigeoCode = "" ;
      ZZ189ProfesionalFoto = "" ;
      ZZ40000ProfesionalFoto_GXI = "" ;
      ZZ190ProfesionalTwitter = "" ;
      ZZ191ProfesionalFacebook = "" ;
      ZZ192ProfesionalInstagram = "" ;
      ZZ193ProfesionalLinkedin = "" ;
      ZZ194ProfesionalTelefono = "" ;
      ZZ195ProfesionalFechaRegistro = GXutil.nullDate() ;
      ZZ197ProfesionalEstadoCuenta = "" ;
      ZZ198ProfesionalEstado = "" ;
      ZZ175ProfesionalNombreCompleto2 = "" ;
      ZZ184PaisDescripcion = "" ;
      ZZ186UbigeoDepartamento = "" ;
      ZZ187UbigeoProvincia = "" ;
      ZZ188UbigeoDistrito = "" ;
      ZZ185UbigeoNombre = "" ;
      GXt_dtime3 = GXutil.resetTime( GXutil.nullDate() );
      T000883_A6SecUserId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.profesional__default(),
         new Object[] {
             new Object[] {
            T00082_A31ProfesionalId, T00082_A58ServiciosId, T00082_A210ServiciosNombre
            }
            , new Object[] {
            T00083_A31ProfesionalId, T00083_A58ServiciosId, T00083_A210ServiciosNombre
            }
            , new Object[] {
            T00084_A31ProfesionalId, T00084_A57PremiosId, T00084_A207PremiosNombre, T00084_A208PremiosFecha, T00084_A209PremiosDescripcion
            }
            , new Object[] {
            T00085_A31ProfesionalId, T00085_A57PremiosId, T00085_A207PremiosNombre, T00085_A208PremiosFecha, T00085_A209PremiosDescripcion
            }
            , new Object[] {
            T00086_A31ProfesionalId, T00086_A56ExperienciaLaboralId, T00086_A204ExperienciaLaboralEmpresaNombre, T00086_A205ExperienciaLaboralDesde, T00086_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            T00087_A31ProfesionalId, T00087_A56ExperienciaLaboralId, T00087_A204ExperienciaLaboralEmpresaNombre, T00087_A205ExperienciaLaboralDesde, T00087_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            T00088_A31ProfesionalId, T00088_A55EducacionId, T00088_A200EducacionNombreInstitucion, T00088_A201EducacionDesde, T00088_A202EducacionHasta, T00088_A203EducacionPaisDescripcion
            }
            , new Object[] {
            T00089_A31ProfesionalId, T00089_A55EducacionId, T00089_A200EducacionNombreInstitucion, T00089_A201EducacionDesde, T00089_A202EducacionHasta, T00089_A203EducacionPaisDescripcion
            }
            , new Object[] {
            T000810_A31ProfesionalId, T000810_A32EspecialidadId, T000810_A54SedeTipoConsulta, T000810_A199CostoConsulta, T000810_A30SedeId
            }
            , new Object[] {
            T000811_A31ProfesionalId, T000811_A32EspecialidadId, T000811_A54SedeTipoConsulta, T000811_A199CostoConsulta, T000811_A30SedeId
            }
            , new Object[] {
            T000812_A28ClinicaId, T000812_A75SedeNombre
            }
            , new Object[] {
            T000813_A80ClinicaNombreAbreviado
            }
            , new Object[] {
            T000814_A31ProfesionalId, T000814_A32EspecialidadId
            }
            , new Object[] {
            T000815_A31ProfesionalId, T000815_A32EspecialidadId
            }
            , new Object[] {
            T000816_A140EspecialidadCodigo, T000816_A71EspecialidadNombre
            }
            , new Object[] {
            T000817_A31ProfesionalId, T000817_A173ProfesionalTipoDocumento, T000817_A174ProfesionalNroDocumento, T000817_A85ProfesionalApellidoPaterno, T000817_A86ProfesionalApellidoMaterno, T000817_A84ProfesionalNombres, T000817_A176ProfesionalFechaNacimiento, T000817_A177ProfesionalSexo, T000817_A178ProfesionalDescripcion, T000817_A179ProfesionalCorreo,
            T000817_A88ProfesionalCOP, T000817_A180ProfesionalColorDisponible, T000817_A181ProfesionalColorCita, T000817_A182ProfesionalTiempoCita, T000817_A183ProfesionalDireccion, T000817_A189ProfesionalFoto, T000817_A40000ProfesionalFoto_GXI, T000817_A190ProfesionalTwitter, T000817_A191ProfesionalFacebook, T000817_A192ProfesionalInstagram,
            T000817_A193ProfesionalLinkedin, T000817_A194ProfesionalTelefono, T000817_A195ProfesionalFechaRegistro, T000817_A196ProfesionalTerminosCondiciones, T000817_A197ProfesionalEstadoCuenta, T000817_A198ProfesionalEstado, T000817_A43PaisId, T000817_A44UbigeoCode, T000817_A6SecUserId
            }
            , new Object[] {
            T000818_A31ProfesionalId, T000818_A173ProfesionalTipoDocumento, T000818_A174ProfesionalNroDocumento, T000818_A85ProfesionalApellidoPaterno, T000818_A86ProfesionalApellidoMaterno, T000818_A84ProfesionalNombres, T000818_A176ProfesionalFechaNacimiento, T000818_A177ProfesionalSexo, T000818_A178ProfesionalDescripcion, T000818_A179ProfesionalCorreo,
            T000818_A88ProfesionalCOP, T000818_A180ProfesionalColorDisponible, T000818_A181ProfesionalColorCita, T000818_A182ProfesionalTiempoCita, T000818_A183ProfesionalDireccion, T000818_A189ProfesionalFoto, T000818_A40000ProfesionalFoto_GXI, T000818_A190ProfesionalTwitter, T000818_A191ProfesionalFacebook, T000818_A192ProfesionalInstagram,
            T000818_A193ProfesionalLinkedin, T000818_A194ProfesionalTelefono, T000818_A195ProfesionalFechaRegistro, T000818_A196ProfesionalTerminosCondiciones, T000818_A197ProfesionalEstadoCuenta, T000818_A198ProfesionalEstado, T000818_A43PaisId, T000818_A44UbigeoCode, T000818_A6SecUserId
            }
            , new Object[] {
            T000819_A184PaisDescripcion
            }
            , new Object[] {
            T000820_A186UbigeoDepartamento, T000820_A187UbigeoProvincia, T000820_A188UbigeoDistrito
            }
            , new Object[] {
            T000821_A6SecUserId
            }
            , new Object[] {
            T000822_A31ProfesionalId, T000822_A173ProfesionalTipoDocumento, T000822_A174ProfesionalNroDocumento, T000822_A85ProfesionalApellidoPaterno, T000822_A86ProfesionalApellidoMaterno, T000822_A84ProfesionalNombres, T000822_A176ProfesionalFechaNacimiento, T000822_A177ProfesionalSexo, T000822_A178ProfesionalDescripcion, T000822_A179ProfesionalCorreo,
            T000822_A88ProfesionalCOP, T000822_A180ProfesionalColorDisponible, T000822_A181ProfesionalColorCita, T000822_A182ProfesionalTiempoCita, T000822_A183ProfesionalDireccion, T000822_A184PaisDescripcion, T000822_A189ProfesionalFoto, T000822_A40000ProfesionalFoto_GXI, T000822_A190ProfesionalTwitter, T000822_A191ProfesionalFacebook,
            T000822_A192ProfesionalInstagram, T000822_A193ProfesionalLinkedin, T000822_A194ProfesionalTelefono, T000822_A195ProfesionalFechaRegistro, T000822_A196ProfesionalTerminosCondiciones, T000822_A197ProfesionalEstadoCuenta, T000822_A198ProfesionalEstado, T000822_A186UbigeoDepartamento, T000822_A187UbigeoProvincia, T000822_A188UbigeoDistrito,
            T000822_A43PaisId, T000822_A44UbigeoCode, T000822_A6SecUserId
            }
            , new Object[] {
            T000823_A184PaisDescripcion
            }
            , new Object[] {
            T000824_A186UbigeoDepartamento, T000824_A187UbigeoProvincia, T000824_A188UbigeoDistrito
            }
            , new Object[] {
            T000825_A6SecUserId
            }
            , new Object[] {
            T000826_A31ProfesionalId
            }
            , new Object[] {
            T000827_A31ProfesionalId
            }
            , new Object[] {
            T000828_A31ProfesionalId
            }
            , new Object[] {
            T000829_A31ProfesionalId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000833_A184PaisDescripcion
            }
            , new Object[] {
            T000834_A186UbigeoDepartamento, T000834_A187UbigeoProvincia, T000834_A188UbigeoDistrito
            }
            , new Object[] {
            T000835_A63ComentarioProfesionalId
            }
            , new Object[] {
            T000836_A60RatingProfesionalId
            }
            , new Object[] {
            T000837_A59EducacionProfesionalId
            }
            , new Object[] {
            T000838_A31ProfesionalId, T000838_A32EspecialidadId
            }
            , new Object[] {
            T000839_A31ProfesionalId
            }
            , new Object[] {
            T000840_A31ProfesionalId, T000840_A140EspecialidadCodigo, T000840_A71EspecialidadNombre, T000840_A32EspecialidadId
            }
            , new Object[] {
            T000841_A140EspecialidadCodigo, T000841_A71EspecialidadNombre
            }
            , new Object[] {
            T000842_A31ProfesionalId, T000842_A32EspecialidadId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000845_A140EspecialidadCodigo, T000845_A71EspecialidadNombre
            }
            , new Object[] {
            T000846_A34DisponibilidadId
            }
            , new Object[] {
            T000847_A29ConfComisionId
            }
            , new Object[] {
            T000848_A31ProfesionalId, T000848_A32EspecialidadId
            }
            , new Object[] {
            T000849_A28ClinicaId, T000849_A31ProfesionalId, T000849_A32EspecialidadId, T000849_A54SedeTipoConsulta, T000849_A199CostoConsulta, T000849_A75SedeNombre, T000849_A80ClinicaNombreAbreviado, T000849_A30SedeId
            }
            , new Object[] {
            T000850_A28ClinicaId, T000850_A75SedeNombre
            }
            , new Object[] {
            T000851_A80ClinicaNombreAbreviado
            }
            , new Object[] {
            T000852_A31ProfesionalId, T000852_A32EspecialidadId, T000852_A30SedeId, T000852_A54SedeTipoConsulta
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000856_A28ClinicaId, T000856_A75SedeNombre
            }
            , new Object[] {
            T000857_A80ClinicaNombreAbreviado
            }
            , new Object[] {
            T000858_A31ProfesionalId, T000858_A32EspecialidadId, T000858_A30SedeId, T000858_A54SedeTipoConsulta
            }
            , new Object[] {
            T000859_A31ProfesionalId, T000859_A55EducacionId, T000859_A200EducacionNombreInstitucion, T000859_A201EducacionDesde, T000859_A202EducacionHasta, T000859_A203EducacionPaisDescripcion
            }
            , new Object[] {
            T000860_A31ProfesionalId, T000860_A55EducacionId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000864_A31ProfesionalId, T000864_A55EducacionId
            }
            , new Object[] {
            T000865_A31ProfesionalId, T000865_A56ExperienciaLaboralId, T000865_A204ExperienciaLaboralEmpresaNombre, T000865_A205ExperienciaLaboralDesde, T000865_A206ExperienciaLaboralHasta
            }
            , new Object[] {
            T000866_A31ProfesionalId, T000866_A56ExperienciaLaboralId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000870_A31ProfesionalId, T000870_A56ExperienciaLaboralId
            }
            , new Object[] {
            T000871_A31ProfesionalId, T000871_A57PremiosId, T000871_A207PremiosNombre, T000871_A208PremiosFecha, T000871_A209PremiosDescripcion
            }
            , new Object[] {
            T000872_A31ProfesionalId, T000872_A57PremiosId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000876_A31ProfesionalId, T000876_A57PremiosId
            }
            , new Object[] {
            T000877_A31ProfesionalId, T000877_A58ServiciosId, T000877_A210ServiciosNombre
            }
            , new Object[] {
            T000878_A31ProfesionalId, T000878_A58ServiciosId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000882_A31ProfesionalId, T000882_A58ServiciosId
            }
            , new Object[] {
            T000883_A6SecUserId
            }
         }
      );
      Z58ServiciosId = java.util.UUID.randomUUID( ) ;
      A58ServiciosId = java.util.UUID.randomUUID( ) ;
      Z57PremiosId = java.util.UUID.randomUUID( ) ;
      A57PremiosId = java.util.UUID.randomUUID( ) ;
      Z56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      A56ExperienciaLaboralId = java.util.UUID.randomUUID( ) ;
      Z55EducacionId = java.util.UUID.randomUUID( ) ;
      A55EducacionId = java.util.UUID.randomUUID( ) ;
      Z199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      A199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      i199CostoConsulta = DecimalUtil.stringToDec("0.00") ;
      Z182ProfesionalTiempoCita = (byte)(30) ;
      A182ProfesionalTiempoCita = (byte)(30) ;
      i182ProfesionalTiempoCita = (byte)(30) ;
      Z54SedeTipoConsulta = "V" ;
      A54SedeTipoConsulta = "V" ;
      Z198ProfesionalEstado = "A" ;
      A198ProfesionalEstado = "A" ;
      i198ProfesionalEstado = "A" ;
      Z181ProfesionalColorCita = "#376A4A" ;
      A181ProfesionalColorCita = "#376A4A" ;
      i181ProfesionalColorCita = "#376A4A" ;
      Z180ProfesionalColorDisponible = "#8CE1B3" ;
      A180ProfesionalColorDisponible = "#8CE1B3" ;
      i180ProfesionalColorDisponible = "#8CE1B3" ;
   }

   private byte Z182ProfesionalTiempoCita ;
   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte A182ProfesionalTiempoCita ;
   private byte subGrid1_Backcolorstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private byte subGridprofesional_educacion_Backcolorstyle ;
   private byte subGridprofesional_educacion_Allowselection ;
   private byte subGridprofesional_educacion_Allowhovering ;
   private byte subGridprofesional_educacion_Allowcollapsing ;
   private byte subGridprofesional_educacion_Collapsed ;
   private byte subGridprofesional_experiencialaboral_Backcolorstyle ;
   private byte subGridprofesional_experiencialaboral_Allowselection ;
   private byte subGridprofesional_experiencialaboral_Allowhovering ;
   private byte subGridprofesional_experiencialaboral_Allowcollapsing ;
   private byte subGridprofesional_experiencialaboral_Collapsed ;
   private byte subGridprofesional_premios_Backcolorstyle ;
   private byte subGridprofesional_premios_Allowselection ;
   private byte subGridprofesional_premios_Allowhovering ;
   private byte subGridprofesional_premios_Allowcollapsing ;
   private byte subGridprofesional_premios_Collapsed ;
   private byte subGridprofesional_servicios_Backcolorstyle ;
   private byte subGridprofesional_servicios_Allowselection ;
   private byte subGridprofesional_servicios_Allowhovering ;
   private byte subGridprofesional_servicios_Allowcollapsing ;
   private byte subGridprofesional_servicios_Collapsed ;
   private byte subGrid1_Backstyle ;
   private byte subGridprofesional_especialidad_sede_Backcolorstyle ;
   private byte subGridprofesional_especialidad_sede_Allowselection ;
   private byte subGridprofesional_especialidad_sede_Allowhovering ;
   private byte subGridprofesional_especialidad_sede_Allowcollapsing ;
   private byte subGridprofesional_especialidad_sede_Collapsed ;
   private byte subGridprofesional_especialidad_sede_Backstyle ;
   private byte subGridprofesional_educacion_Backstyle ;
   private byte subGridprofesional_experiencialaboral_Backstyle ;
   private byte subGridprofesional_premios_Backstyle ;
   private byte subGridprofesional_servicios_Backstyle ;
   private byte gxajaxcallmode ;
   private byte i182ProfesionalTiempoCita ;
   private byte ZZ182ProfesionalTiempoCita ;
   private short Z43PaisId ;
   private short Z6SecUserId ;
   private short Z32EspecialidadId ;
   private short nRcdDeleted_10 ;
   private short nRcdExists_10 ;
   private short nIsMod_10 ;
   private short Z30SedeId ;
   private short nRcdDeleted_11 ;
   private short nRcdExists_11 ;
   private short nIsMod_11 ;
   private short nRcdDeleted_12 ;
   private short nRcdExists_12 ;
   private short nIsMod_12 ;
   private short nRcdDeleted_13 ;
   private short nRcdExists_13 ;
   private short nIsMod_13 ;
   private short nRcdDeleted_14 ;
   private short nRcdExists_14 ;
   private short nIsMod_14 ;
   private short nRcdDeleted_15 ;
   private short nRcdExists_15 ;
   private short nIsMod_15 ;
   private short A43PaisId ;
   private short A6SecUserId ;
   private short A32EspecialidadId ;
   private short A30SedeId ;
   private short A28ClinicaId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount10 ;
   private short RcdFound10 ;
   private short nBlankRcdUsr10 ;
   private short nBlankRcdCount12 ;
   private short RcdFound12 ;
   private short nBlankRcdUsr12 ;
   private short nBlankRcdCount13 ;
   private short RcdFound13 ;
   private short nBlankRcdUsr13 ;
   private short nBlankRcdCount14 ;
   private short RcdFound14 ;
   private short nBlankRcdUsr14 ;
   private short nBlankRcdCount15 ;
   private short RcdFound15 ;
   private short nBlankRcdUsr15 ;
   private short RcdFound11 ;
   private short RcdFound9 ;
   private short nIsDirty_9 ;
   private short nIsDirty_10 ;
   private short Z28ClinicaId ;
   private short nIsDirty_11 ;
   private short nIsDirty_12 ;
   private short nIsDirty_13 ;
   private short nIsDirty_14 ;
   private short nIsDirty_15 ;
   private short nBlankRcdCount11 ;
   private short nBlankRcdUsr11 ;
   private short ZZ43PaisId ;
   private short ZZ6SecUserId ;
   private int Z31ProfesionalId ;
   private int nRC_GXsfl_184 ;
   private int nGXsfl_184_idx=1 ;
   private int nRC_GXsfl_220 ;
   private int nGXsfl_220_idx=1 ;
   private int nRC_GXsfl_231 ;
   private int nGXsfl_231_idx=1 ;
   private int nRC_GXsfl_241 ;
   private int nGXsfl_241_idx=1 ;
   private int nRC_GXsfl_251 ;
   private int nGXsfl_251_idx=1 ;
   private int nRC_GXsfl_209 ;
   private int nGXsfl_209_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int A31ProfesionalId ;
   private int edtProfesionalId_Enabled ;
   private int edtProfesionalNroDocumento_Enabled ;
   private int edtProfesionalApellidoPaterno_Enabled ;
   private int edtProfesionalApellidoMaterno_Enabled ;
   private int edtProfesionalNombres_Enabled ;
   private int edtProfesionalNombreCompleto2_Enabled ;
   private int edtProfesionalFechaNacimiento_Enabled ;
   private int edtProfesionalDescripcion_Enabled ;
   private int edtProfesionalCorreo_Enabled ;
   private int edtProfesionalCOP_Enabled ;
   private int edtProfesionalColorDisponible_Enabled ;
   private int edtProfesionalColorCita_Enabled ;
   private int edtProfesionalDireccion_Enabled ;
   private int edtPaisId_Enabled ;
   private int edtPaisDescripcion_Enabled ;
   private int edtUbigeoCode_Enabled ;
   private int edtUbigeoNombre_Enabled ;
   private int imgProfesionalFoto_Enabled ;
   private int edtProfesionalTwitter_Enabled ;
   private int edtProfesionalFacebook_Enabled ;
   private int edtProfesionalInstagram_Enabled ;
   private int edtProfesionalLinkedin_Enabled ;
   private int edtProfesionalTelefono_Enabled ;
   private int edtSecUserId_Enabled ;
   private int edtProfesionalFechaRegistro_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtEspecialidadId_Enabled ;
   private int edtEspecialidadCodigo_Enabled ;
   private int edtEspecialidadNombre_Enabled ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private int fRowAdded ;
   private int edtEducacionId_Enabled ;
   private int edtEducacionNombreInstitucion_Enabled ;
   private int edtEducacionDesde_Enabled ;
   private int edtEducacionHasta_Enabled ;
   private int edtEducacionPaisDescripcion_Enabled ;
   private int subGridprofesional_educacion_Selectedindex ;
   private int subGridprofesional_educacion_Selectioncolor ;
   private int subGridprofesional_educacion_Hoveringcolor ;
   private int edtExperienciaLaboralId_Enabled ;
   private int edtExperienciaLaboralEmpresaNombre_Enabled ;
   private int edtExperienciaLaboralDesde_Enabled ;
   private int edtExperienciaLaboralHasta_Enabled ;
   private int subGridprofesional_experiencialaboral_Selectedindex ;
   private int subGridprofesional_experiencialaboral_Selectioncolor ;
   private int subGridprofesional_experiencialaboral_Hoveringcolor ;
   private int edtPremiosId_Enabled ;
   private int edtPremiosNombre_Enabled ;
   private int edtPremiosFecha_Enabled ;
   private int edtPremiosDescripcion_Enabled ;
   private int subGridprofesional_premios_Selectedindex ;
   private int subGridprofesional_premios_Selectioncolor ;
   private int subGridprofesional_premios_Hoveringcolor ;
   private int edtServiciosId_Enabled ;
   private int edtServiciosNombre_Enabled ;
   private int subGridprofesional_servicios_Selectedindex ;
   private int subGridprofesional_servicios_Selectioncolor ;
   private int subGridprofesional_servicios_Hoveringcolor ;
   private int edtSedeId_Enabled ;
   private int edtSedeNombre_Enabled ;
   private int edtClinicaNombreAbreviado_Enabled ;
   private int edtCostoConsulta_Enabled ;
   private int GX_JID ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int GRID1_IsPaging ;
   private int subGridprofesional_especialidad_sede_Selectedindex ;
   private int subGridprofesional_especialidad_sede_Selectioncolor ;
   private int subGridprofesional_especialidad_sede_Hoveringcolor ;
   private int subGridprofesional_especialidad_sede_Backcolor ;
   private int subGridprofesional_especialidad_sede_Allbackcolor ;
   private int subGridprofesional_educacion_Backcolor ;
   private int subGridprofesional_educacion_Allbackcolor ;
   private int subGridprofesional_experiencialaboral_Backcolor ;
   private int subGridprofesional_experiencialaboral_Allbackcolor ;
   private int subGridprofesional_premios_Backcolor ;
   private int subGridprofesional_premios_Allbackcolor ;
   private int subGridprofesional_servicios_Backcolor ;
   private int subGridprofesional_servicios_Allbackcolor ;
   private int defcmbSedeTipoConsulta_Enabled ;
   private int defedtSedeId_Enabled ;
   private int defedtServiciosId_Enabled ;
   private int defedtPremiosId_Enabled ;
   private int defedtExperienciaLaboralId_Enabled ;
   private int defedtEducacionId_Enabled ;
   private int defedtEspecialidadId_Enabled ;
   private int idxLst ;
   private int ZZ31ProfesionalId ;
   private long GRID1_nFirstRecordOnPage ;
   private long GRIDPROFESIONAL_ESPECIALIDAD_SEDE_nFirstRecordOnPage ;
   private long GRIDPROFESIONAL_EDUCACION_nFirstRecordOnPage ;
   private long GRIDPROFESIONAL_EXPERIENCIALABORAL_nFirstRecordOnPage ;
   private long GRIDPROFESIONAL_PREMIOS_nFirstRecordOnPage ;
   private long GRIDPROFESIONAL_SERVICIOS_nFirstRecordOnPage ;
   private long GRIDPROFESIONAL_ESPECIALIDAD_SEDE_nCurrentRecord ;
   private java.math.BigDecimal Z199CostoConsulta ;
   private java.math.BigDecimal A199CostoConsulta ;
   private java.math.BigDecimal i199CostoConsulta ;
   private String sPrefix ;
   private String Z173ProfesionalTipoDocumento ;
   private String Z177ProfesionalSexo ;
   private String Z180ProfesionalColorDisponible ;
   private String Z181ProfesionalColorCita ;
   private String Z194ProfesionalTelefono ;
   private String Z197ProfesionalEstadoCuenta ;
   private String Z198ProfesionalEstado ;
   private String Z44UbigeoCode ;
   private String Z54SedeTipoConsulta ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A44UbigeoCode ;
   private String sGXsfl_209_idx="0001" ;
   private String sGXsfl_184_idx="0001" ;
   private String sGXsfl_220_idx="0001" ;
   private String sGXsfl_231_idx="0001" ;
   private String sGXsfl_241_idx="0001" ;
   private String sGXsfl_251_idx="0001" ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String A173ProfesionalTipoDocumento ;
   private String A177ProfesionalSexo ;
   private String A197ProfesionalEstadoCuenta ;
   private String A198ProfesionalEstado ;
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
   private String edtProfesionalId_Internalname ;
   private String edtProfesionalId_Jsonclick ;
   private String edtProfesionalNroDocumento_Internalname ;
   private String edtProfesionalNroDocumento_Jsonclick ;
   private String edtProfesionalApellidoPaterno_Internalname ;
   private String edtProfesionalApellidoPaterno_Jsonclick ;
   private String edtProfesionalApellidoMaterno_Internalname ;
   private String edtProfesionalApellidoMaterno_Jsonclick ;
   private String edtProfesionalNombres_Internalname ;
   private String edtProfesionalNombres_Jsonclick ;
   private String edtProfesionalNombreCompleto2_Internalname ;
   private String edtProfesionalNombreCompleto2_Jsonclick ;
   private String edtProfesionalFechaNacimiento_Internalname ;
   private String edtProfesionalFechaNacimiento_Jsonclick ;
   private String edtProfesionalDescripcion_Internalname ;
   private String edtProfesionalCorreo_Internalname ;
   private String edtProfesionalCorreo_Jsonclick ;
   private String edtProfesionalCOP_Internalname ;
   private String edtProfesionalCOP_Jsonclick ;
   private String edtProfesionalColorDisponible_Internalname ;
   private String A180ProfesionalColorDisponible ;
   private String edtProfesionalColorDisponible_Jsonclick ;
   private String edtProfesionalColorCita_Internalname ;
   private String A181ProfesionalColorCita ;
   private String edtProfesionalColorCita_Jsonclick ;
   private String edtProfesionalDireccion_Internalname ;
   private String edtPaisId_Internalname ;
   private String edtPaisId_Jsonclick ;
   private String edtPaisDescripcion_Internalname ;
   private String edtPaisDescripcion_Jsonclick ;
   private String edtUbigeoCode_Internalname ;
   private String edtUbigeoCode_Jsonclick ;
   private String edtUbigeoNombre_Internalname ;
   private String edtUbigeoNombre_Jsonclick ;
   private String imgProfesionalFoto_Internalname ;
   private String sImgUrl ;
   private String edtProfesionalTwitter_Internalname ;
   private String edtProfesionalTwitter_Jsonclick ;
   private String edtProfesionalFacebook_Internalname ;
   private String edtProfesionalFacebook_Jsonclick ;
   private String edtProfesionalInstagram_Internalname ;
   private String edtProfesionalInstagram_Jsonclick ;
   private String edtProfesionalLinkedin_Internalname ;
   private String edtProfesionalLinkedin_Jsonclick ;
   private String edtProfesionalTelefono_Internalname ;
   private String gxphoneLink ;
   private String A194ProfesionalTelefono ;
   private String edtProfesionalTelefono_Jsonclick ;
   private String edtSecUserId_Internalname ;
   private String edtSecUserId_Jsonclick ;
   private String edtProfesionalFechaRegistro_Internalname ;
   private String edtProfesionalFechaRegistro_Jsonclick ;
   private String lblTitleespecialidad_Internalname ;
   private String lblTitleespecialidad_Jsonclick ;
   private String lblTitleeducacion_Internalname ;
   private String lblTitleeducacion_Jsonclick ;
   private String lblTitleexperiencialaboral_Internalname ;
   private String lblTitleexperiencialaboral_Jsonclick ;
   private String lblTitlepremios_Internalname ;
   private String lblTitlepremios_Jsonclick ;
   private String lblTitleservicios_Internalname ;
   private String lblTitleservicios_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String subGrid1_Header ;
   private String lblTitlesede_Caption ;
   private String sMode10 ;
   private String edtEspecialidadId_Internalname ;
   private String edtEspecialidadCodigo_Internalname ;
   private String edtEspecialidadNombre_Internalname ;
   private String sStyleString ;
   private String subGridprofesional_educacion_Header ;
   private String sMode12 ;
   private String edtEducacionId_Internalname ;
   private String edtEducacionNombreInstitucion_Internalname ;
   private String edtEducacionDesde_Internalname ;
   private String edtEducacionHasta_Internalname ;
   private String edtEducacionPaisDescripcion_Internalname ;
   private String subGridprofesional_experiencialaboral_Header ;
   private String sMode13 ;
   private String edtExperienciaLaboralId_Internalname ;
   private String edtExperienciaLaboralEmpresaNombre_Internalname ;
   private String edtExperienciaLaboralDesde_Internalname ;
   private String edtExperienciaLaboralHasta_Internalname ;
   private String subGridprofesional_premios_Header ;
   private String sMode14 ;
   private String edtPremiosId_Internalname ;
   private String edtPremiosNombre_Internalname ;
   private String edtPremiosFecha_Internalname ;
   private String edtPremiosDescripcion_Internalname ;
   private String subGridprofesional_servicios_Header ;
   private String sMode15 ;
   private String edtServiciosId_Internalname ;
   private String edtServiciosNombre_Internalname ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String hsh ;
   private String hsh2 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String edtSedeId_Internalname ;
   private String A54SedeTipoConsulta ;
   private String edtSedeNombre_Internalname ;
   private String edtClinicaNombreAbreviado_Internalname ;
   private String edtCostoConsulta_Internalname ;
   private String sMode9 ;
   private String sMode11 ;
   private String lblTitlesede_Internalname ;
   private String subGridprofesional_especialidad_sede_Internalname ;
   private String sGXsfl_184_fel_idx="0001" ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String divGrid1table_Internalname ;
   private String divTable2_Internalname ;
   private String ROClassString ;
   private String edtEspecialidadId_Jsonclick ;
   private String edtEspecialidadCodigo_Jsonclick ;
   private String edtEspecialidadNombre_Jsonclick ;
   private String lblTitlesede_Jsonclick ;
   private String subGridprofesional_especialidad_sede_Header ;
   private String sGXsfl_209_fel_idx="0001" ;
   private String subGridprofesional_especialidad_sede_Class ;
   private String subGridprofesional_especialidad_sede_Linesclass ;
   private String edtSedeId_Jsonclick ;
   private String edtSedeNombre_Jsonclick ;
   private String edtClinicaNombreAbreviado_Jsonclick ;
   private String edtCostoConsulta_Jsonclick ;
   private String sGXsfl_220_fel_idx="0001" ;
   private String subGridprofesional_educacion_Class ;
   private String subGridprofesional_educacion_Linesclass ;
   private String edtEducacionId_Jsonclick ;
   private String edtEducacionNombreInstitucion_Jsonclick ;
   private String edtEducacionDesde_Jsonclick ;
   private String edtEducacionHasta_Jsonclick ;
   private String edtEducacionPaisDescripcion_Jsonclick ;
   private String sGXsfl_231_fel_idx="0001" ;
   private String subGridprofesional_experiencialaboral_Class ;
   private String subGridprofesional_experiencialaboral_Linesclass ;
   private String edtExperienciaLaboralId_Jsonclick ;
   private String edtExperienciaLaboralEmpresaNombre_Jsonclick ;
   private String edtExperienciaLaboralDesde_Jsonclick ;
   private String edtExperienciaLaboralHasta_Jsonclick ;
   private String sGXsfl_241_fel_idx="0001" ;
   private String subGridprofesional_premios_Class ;
   private String subGridprofesional_premios_Linesclass ;
   private String edtPremiosId_Jsonclick ;
   private String edtPremiosNombre_Jsonclick ;
   private String edtPremiosFecha_Jsonclick ;
   private String edtPremiosDescripcion_Jsonclick ;
   private String sGXsfl_251_fel_idx="0001" ;
   private String subGridprofesional_servicios_Class ;
   private String subGridprofesional_servicios_Linesclass ;
   private String edtServiciosId_Jsonclick ;
   private String edtServiciosNombre_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private String i180ProfesionalColorDisponible ;
   private String i181ProfesionalColorCita ;
   private String i198ProfesionalEstado ;
   private String subGrid1_Internalname ;
   private String subGridprofesional_educacion_Internalname ;
   private String subGridprofesional_experiencialaboral_Internalname ;
   private String subGridprofesional_premios_Internalname ;
   private String subGridprofesional_servicios_Internalname ;
   private String ZZ173ProfesionalTipoDocumento ;
   private String ZZ177ProfesionalSexo ;
   private String ZZ180ProfesionalColorDisponible ;
   private String ZZ181ProfesionalColorCita ;
   private String ZZ44UbigeoCode ;
   private String ZZ194ProfesionalTelefono ;
   private String ZZ197ProfesionalEstadoCuenta ;
   private String ZZ198ProfesionalEstado ;
   private java.util.Date GXt_dtime3 ;
   private java.util.Date Z176ProfesionalFechaNacimiento ;
   private java.util.Date Z195ProfesionalFechaRegistro ;
   private java.util.Date Z201EducacionDesde ;
   private java.util.Date Z202EducacionHasta ;
   private java.util.Date Z205ExperienciaLaboralDesde ;
   private java.util.Date Z206ExperienciaLaboralHasta ;
   private java.util.Date Z208PremiosFecha ;
   private java.util.Date A176ProfesionalFechaNacimiento ;
   private java.util.Date A195ProfesionalFechaRegistro ;
   private java.util.Date A201EducacionDesde ;
   private java.util.Date A202EducacionHasta ;
   private java.util.Date A205ExperienciaLaboralDesde ;
   private java.util.Date A206ExperienciaLaboralHasta ;
   private java.util.Date A208PremiosFecha ;
   private java.util.Date ZZ176ProfesionalFechaNacimiento ;
   private java.util.Date ZZ195ProfesionalFechaRegistro ;
   private boolean Z196ProfesionalTerminosCondiciones ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A196ProfesionalTerminosCondiciones ;
   private boolean A189ProfesionalFoto_IsBlob ;
   private boolean bGXsfl_184_Refreshing=false ;
   private boolean bGXsfl_220_Refreshing=false ;
   private boolean bGXsfl_231_Refreshing=false ;
   private boolean bGXsfl_241_Refreshing=false ;
   private boolean bGXsfl_251_Refreshing=false ;
   private boolean returnInSub ;
   private boolean Gx_longc ;
   private boolean bGXsfl_209_Refreshing=false ;
   private boolean ZZ196ProfesionalTerminosCondiciones ;
   private String A209PremiosDescripcion ;
   private String Z209PremiosDescripcion ;
   private String Z174ProfesionalNroDocumento ;
   private String Z85ProfesionalApellidoPaterno ;
   private String Z86ProfesionalApellidoMaterno ;
   private String Z84ProfesionalNombres ;
   private String Z178ProfesionalDescripcion ;
   private String Z179ProfesionalCorreo ;
   private String Z88ProfesionalCOP ;
   private String Z183ProfesionalDireccion ;
   private String Z190ProfesionalTwitter ;
   private String Z191ProfesionalFacebook ;
   private String Z192ProfesionalInstagram ;
   private String Z193ProfesionalLinkedin ;
   private String N174ProfesionalNroDocumento ;
   private String Z200EducacionNombreInstitucion ;
   private String Z203EducacionPaisDescripcion ;
   private String Z204ExperienciaLaboralEmpresaNombre ;
   private String Z207PremiosNombre ;
   private String Z210ServiciosNombre ;
   private String AV15ProfesionalNroDocumento ;
   private String AV14ProfesionalCorreo ;
   private String A174ProfesionalNroDocumento ;
   private String A85ProfesionalApellidoPaterno ;
   private String A86ProfesionalApellidoMaterno ;
   private String A84ProfesionalNombres ;
   private String A175ProfesionalNombreCompleto2 ;
   private String A178ProfesionalDescripcion ;
   private String A179ProfesionalCorreo ;
   private String A88ProfesionalCOP ;
   private String A183ProfesionalDireccion ;
   private String A184PaisDescripcion ;
   private String A185UbigeoNombre ;
   private String A40000ProfesionalFoto_GXI ;
   private String A190ProfesionalTwitter ;
   private String A191ProfesionalFacebook ;
   private String A192ProfesionalInstagram ;
   private String A193ProfesionalLinkedin ;
   private String A140EspecialidadCodigo ;
   private String A71EspecialidadNombre ;
   private String A200EducacionNombreInstitucion ;
   private String A203EducacionPaisDescripcion ;
   private String A204ExperienciaLaboralEmpresaNombre ;
   private String A207PremiosNombre ;
   private String A210ServiciosNombre ;
   private String A186UbigeoDepartamento ;
   private String A187UbigeoProvincia ;
   private String A188UbigeoDistrito ;
   private String A75SedeNombre ;
   private String A80ClinicaNombreAbreviado ;
   private String Z40000ProfesionalFoto_GXI ;
   private String Z184PaisDescripcion ;
   private String Z186UbigeoDepartamento ;
   private String Z187UbigeoProvincia ;
   private String Z188UbigeoDistrito ;
   private String Z140EspecialidadCodigo ;
   private String Z71EspecialidadNombre ;
   private String Z75SedeNombre ;
   private String Z80ClinicaNombreAbreviado ;
   private String Z175ProfesionalNombreCompleto2 ;
   private String Z185UbigeoNombre ;
   private String ZZ174ProfesionalNroDocumento ;
   private String ZZ85ProfesionalApellidoPaterno ;
   private String ZZ86ProfesionalApellidoMaterno ;
   private String ZZ84ProfesionalNombres ;
   private String ZZ178ProfesionalDescripcion ;
   private String ZZ179ProfesionalCorreo ;
   private String ZZ88ProfesionalCOP ;
   private String ZZ183ProfesionalDireccion ;
   private String ZZ40000ProfesionalFoto_GXI ;
   private String ZZ190ProfesionalTwitter ;
   private String ZZ191ProfesionalFacebook ;
   private String ZZ192ProfesionalInstagram ;
   private String ZZ193ProfesionalLinkedin ;
   private String ZZ175ProfesionalNombreCompleto2 ;
   private String ZZ184PaisDescripcion ;
   private String ZZ186UbigeoDepartamento ;
   private String ZZ187UbigeoProvincia ;
   private String ZZ188UbigeoDistrito ;
   private String ZZ185UbigeoNombre ;
   private String A189ProfesionalFoto ;
   private String Z189ProfesionalFoto ;
   private String ZZ189ProfesionalFoto ;
   private java.util.UUID Z55EducacionId ;
   private java.util.UUID Z56ExperienciaLaboralId ;
   private java.util.UUID Z57PremiosId ;
   private java.util.UUID Z58ServiciosId ;
   private java.util.UUID A55EducacionId ;
   private java.util.UUID A56ExperienciaLaboralId ;
   private java.util.UUID A57PremiosId ;
   private java.util.UUID A58ServiciosId ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebGrid Gridprofesional_educacionContainer ;
   private com.genexus.webpanels.GXWebGrid Gridprofesional_experiencialaboralContainer ;
   private com.genexus.webpanels.GXWebGrid Gridprofesional_premiosContainer ;
   private com.genexus.webpanels.GXWebGrid Gridprofesional_serviciosContainer ;
   private com.genexus.webpanels.GXWebGrid Gridprofesional_especialidad_sedeContainer ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebRow Gridprofesional_especialidad_sedeRow ;
   private com.genexus.webpanels.GXWebRow Gridprofesional_educacionRow ;
   private com.genexus.webpanels.GXWebRow Gridprofesional_experiencialaboralRow ;
   private com.genexus.webpanels.GXWebRow Gridprofesional_premiosRow ;
   private com.genexus.webpanels.GXWebRow Gridprofesional_serviciosRow ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.webpanels.GXWebColumn Gridprofesional_educacionColumn ;
   private com.genexus.webpanels.GXWebColumn Gridprofesional_experiencialaboralColumn ;
   private com.genexus.webpanels.GXWebColumn Gridprofesional_premiosColumn ;
   private com.genexus.webpanels.GXWebColumn Gridprofesional_serviciosColumn ;
   private com.genexus.webpanels.GXWebColumn Gridprofesional_especialidad_sedeColumn ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private com.genexus.util.GXProperties forbiddenHiddens2 ;
   private HTMLChoice cmbProfesionalTipoDocumento ;
   private HTMLChoice cmbProfesionalSexo ;
   private HTMLChoice cmbProfesionalTiempoCita ;
   private ICheckbox chkProfesionalTerminosCondiciones ;
   private HTMLChoice cmbProfesionalEstadoCuenta ;
   private HTMLChoice cmbProfesionalEstado ;
   private HTMLChoice cmbSedeTipoConsulta ;
   private IDataStoreProvider pr_default ;
   private int[] T000822_A31ProfesionalId ;
   private String[] T000822_A173ProfesionalTipoDocumento ;
   private String[] T000822_A174ProfesionalNroDocumento ;
   private String[] T000822_A85ProfesionalApellidoPaterno ;
   private String[] T000822_A86ProfesionalApellidoMaterno ;
   private String[] T000822_A84ProfesionalNombres ;
   private java.util.Date[] T000822_A176ProfesionalFechaNacimiento ;
   private String[] T000822_A177ProfesionalSexo ;
   private String[] T000822_A178ProfesionalDescripcion ;
   private String[] T000822_A179ProfesionalCorreo ;
   private String[] T000822_A88ProfesionalCOP ;
   private String[] T000822_A180ProfesionalColorDisponible ;
   private String[] T000822_A181ProfesionalColorCita ;
   private byte[] T000822_A182ProfesionalTiempoCita ;
   private String[] T000822_A183ProfesionalDireccion ;
   private String[] T000822_A184PaisDescripcion ;
   private String[] T000822_A189ProfesionalFoto ;
   private String[] T000822_A40000ProfesionalFoto_GXI ;
   private String[] T000822_A190ProfesionalTwitter ;
   private String[] T000822_A191ProfesionalFacebook ;
   private String[] T000822_A192ProfesionalInstagram ;
   private String[] T000822_A193ProfesionalLinkedin ;
   private String[] T000822_A194ProfesionalTelefono ;
   private java.util.Date[] T000822_A195ProfesionalFechaRegistro ;
   private boolean[] T000822_A196ProfesionalTerminosCondiciones ;
   private String[] T000822_A197ProfesionalEstadoCuenta ;
   private String[] T000822_A198ProfesionalEstado ;
   private String[] T000822_A186UbigeoDepartamento ;
   private String[] T000822_A187UbigeoProvincia ;
   private String[] T000822_A188UbigeoDistrito ;
   private short[] T000822_A43PaisId ;
   private String[] T000822_A44UbigeoCode ;
   private short[] T000822_A6SecUserId ;
   private String[] T000819_A184PaisDescripcion ;
   private String[] T000820_A186UbigeoDepartamento ;
   private String[] T000820_A187UbigeoProvincia ;
   private String[] T000820_A188UbigeoDistrito ;
   private short[] T000821_A6SecUserId ;
   private String[] T000823_A184PaisDescripcion ;
   private String[] T000824_A186UbigeoDepartamento ;
   private String[] T000824_A187UbigeoProvincia ;
   private String[] T000824_A188UbigeoDistrito ;
   private short[] T000825_A6SecUserId ;
   private int[] T000826_A31ProfesionalId ;
   private int[] T000818_A31ProfesionalId ;
   private String[] T000818_A173ProfesionalTipoDocumento ;
   private String[] T000818_A174ProfesionalNroDocumento ;
   private String[] T000818_A85ProfesionalApellidoPaterno ;
   private String[] T000818_A86ProfesionalApellidoMaterno ;
   private String[] T000818_A84ProfesionalNombres ;
   private java.util.Date[] T000818_A176ProfesionalFechaNacimiento ;
   private String[] T000818_A177ProfesionalSexo ;
   private String[] T000818_A178ProfesionalDescripcion ;
   private String[] T000818_A179ProfesionalCorreo ;
   private String[] T000818_A88ProfesionalCOP ;
   private String[] T000818_A180ProfesionalColorDisponible ;
   private String[] T000818_A181ProfesionalColorCita ;
   private byte[] T000818_A182ProfesionalTiempoCita ;
   private String[] T000818_A183ProfesionalDireccion ;
   private String[] T000818_A189ProfesionalFoto ;
   private String[] T000818_A40000ProfesionalFoto_GXI ;
   private String[] T000818_A190ProfesionalTwitter ;
   private String[] T000818_A191ProfesionalFacebook ;
   private String[] T000818_A192ProfesionalInstagram ;
   private String[] T000818_A193ProfesionalLinkedin ;
   private String[] T000818_A194ProfesionalTelefono ;
   private java.util.Date[] T000818_A195ProfesionalFechaRegistro ;
   private boolean[] T000818_A196ProfesionalTerminosCondiciones ;
   private String[] T000818_A197ProfesionalEstadoCuenta ;
   private String[] T000818_A198ProfesionalEstado ;
   private short[] T000818_A43PaisId ;
   private String[] T000818_A44UbigeoCode ;
   private short[] T000818_A6SecUserId ;
   private int[] T000827_A31ProfesionalId ;
   private int[] T000828_A31ProfesionalId ;
   private int[] T000817_A31ProfesionalId ;
   private String[] T000817_A173ProfesionalTipoDocumento ;
   private String[] T000817_A174ProfesionalNroDocumento ;
   private String[] T000817_A85ProfesionalApellidoPaterno ;
   private String[] T000817_A86ProfesionalApellidoMaterno ;
   private String[] T000817_A84ProfesionalNombres ;
   private java.util.Date[] T000817_A176ProfesionalFechaNacimiento ;
   private String[] T000817_A177ProfesionalSexo ;
   private String[] T000817_A178ProfesionalDescripcion ;
   private String[] T000817_A179ProfesionalCorreo ;
   private String[] T000817_A88ProfesionalCOP ;
   private String[] T000817_A180ProfesionalColorDisponible ;
   private String[] T000817_A181ProfesionalColorCita ;
   private byte[] T000817_A182ProfesionalTiempoCita ;
   private String[] T000817_A183ProfesionalDireccion ;
   private String[] T000817_A189ProfesionalFoto ;
   private String[] T000817_A40000ProfesionalFoto_GXI ;
   private String[] T000817_A190ProfesionalTwitter ;
   private String[] T000817_A191ProfesionalFacebook ;
   private String[] T000817_A192ProfesionalInstagram ;
   private String[] T000817_A193ProfesionalLinkedin ;
   private String[] T000817_A194ProfesionalTelefono ;
   private java.util.Date[] T000817_A195ProfesionalFechaRegistro ;
   private boolean[] T000817_A196ProfesionalTerminosCondiciones ;
   private String[] T000817_A197ProfesionalEstadoCuenta ;
   private String[] T000817_A198ProfesionalEstado ;
   private short[] T000817_A43PaisId ;
   private String[] T000817_A44UbigeoCode ;
   private short[] T000817_A6SecUserId ;
   private int[] T000829_A31ProfesionalId ;
   private String[] T000833_A184PaisDescripcion ;
   private String[] T000834_A186UbigeoDepartamento ;
   private String[] T000834_A187UbigeoProvincia ;
   private String[] T000834_A188UbigeoDistrito ;
   private int[] T000835_A63ComentarioProfesionalId ;
   private int[] T000836_A60RatingProfesionalId ;
   private int[] T000837_A59EducacionProfesionalId ;
   private int[] T000838_A31ProfesionalId ;
   private short[] T000838_A32EspecialidadId ;
   private int[] T000839_A31ProfesionalId ;
   private int[] T000840_A31ProfesionalId ;
   private String[] T000840_A140EspecialidadCodigo ;
   private String[] T000840_A71EspecialidadNombre ;
   private short[] T000840_A32EspecialidadId ;
   private String[] T000816_A140EspecialidadCodigo ;
   private String[] T000816_A71EspecialidadNombre ;
   private String[] T000841_A140EspecialidadCodigo ;
   private String[] T000841_A71EspecialidadNombre ;
   private int[] T000842_A31ProfesionalId ;
   private short[] T000842_A32EspecialidadId ;
   private int[] T000815_A31ProfesionalId ;
   private short[] T000815_A32EspecialidadId ;
   private int[] T000814_A31ProfesionalId ;
   private short[] T000814_A32EspecialidadId ;
   private String[] T000845_A140EspecialidadCodigo ;
   private String[] T000845_A71EspecialidadNombre ;
   private int[] T000846_A34DisponibilidadId ;
   private short[] T000847_A29ConfComisionId ;
   private int[] T000848_A31ProfesionalId ;
   private short[] T000848_A32EspecialidadId ;
   private short[] T000849_A28ClinicaId ;
   private int[] T000849_A31ProfesionalId ;
   private short[] T000849_A32EspecialidadId ;
   private String[] T000849_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] T000849_A199CostoConsulta ;
   private String[] T000849_A75SedeNombre ;
   private String[] T000849_A80ClinicaNombreAbreviado ;
   private short[] T000849_A30SedeId ;
   private short[] T000812_A28ClinicaId ;
   private String[] T000812_A75SedeNombre ;
   private String[] T000813_A80ClinicaNombreAbreviado ;
   private short[] T000850_A28ClinicaId ;
   private String[] T000850_A75SedeNombre ;
   private String[] T000851_A80ClinicaNombreAbreviado ;
   private int[] T000852_A31ProfesionalId ;
   private short[] T000852_A32EspecialidadId ;
   private short[] T000852_A30SedeId ;
   private String[] T000852_A54SedeTipoConsulta ;
   private int[] T000811_A31ProfesionalId ;
   private short[] T000811_A32EspecialidadId ;
   private String[] T000811_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] T000811_A199CostoConsulta ;
   private short[] T000811_A30SedeId ;
   private int[] T000810_A31ProfesionalId ;
   private short[] T000810_A32EspecialidadId ;
   private String[] T000810_A54SedeTipoConsulta ;
   private java.math.BigDecimal[] T000810_A199CostoConsulta ;
   private short[] T000810_A30SedeId ;
   private short[] T000856_A28ClinicaId ;
   private String[] T000856_A75SedeNombre ;
   private String[] T000857_A80ClinicaNombreAbreviado ;
   private int[] T000858_A31ProfesionalId ;
   private short[] T000858_A32EspecialidadId ;
   private short[] T000858_A30SedeId ;
   private String[] T000858_A54SedeTipoConsulta ;
   private int[] T000859_A31ProfesionalId ;
   private java.util.UUID[] T000859_A55EducacionId ;
   private String[] T000859_A200EducacionNombreInstitucion ;
   private java.util.Date[] T000859_A201EducacionDesde ;
   private java.util.Date[] T000859_A202EducacionHasta ;
   private String[] T000859_A203EducacionPaisDescripcion ;
   private int[] T000860_A31ProfesionalId ;
   private java.util.UUID[] T000860_A55EducacionId ;
   private int[] T00089_A31ProfesionalId ;
   private java.util.UUID[] T00089_A55EducacionId ;
   private String[] T00089_A200EducacionNombreInstitucion ;
   private java.util.Date[] T00089_A201EducacionDesde ;
   private java.util.Date[] T00089_A202EducacionHasta ;
   private String[] T00089_A203EducacionPaisDescripcion ;
   private int[] T00088_A31ProfesionalId ;
   private java.util.UUID[] T00088_A55EducacionId ;
   private String[] T00088_A200EducacionNombreInstitucion ;
   private java.util.Date[] T00088_A201EducacionDesde ;
   private java.util.Date[] T00088_A202EducacionHasta ;
   private String[] T00088_A203EducacionPaisDescripcion ;
   private int[] T000864_A31ProfesionalId ;
   private java.util.UUID[] T000864_A55EducacionId ;
   private int[] T000865_A31ProfesionalId ;
   private java.util.UUID[] T000865_A56ExperienciaLaboralId ;
   private String[] T000865_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] T000865_A205ExperienciaLaboralDesde ;
   private java.util.Date[] T000865_A206ExperienciaLaboralHasta ;
   private int[] T000866_A31ProfesionalId ;
   private java.util.UUID[] T000866_A56ExperienciaLaboralId ;
   private int[] T00087_A31ProfesionalId ;
   private java.util.UUID[] T00087_A56ExperienciaLaboralId ;
   private String[] T00087_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] T00087_A205ExperienciaLaboralDesde ;
   private java.util.Date[] T00087_A206ExperienciaLaboralHasta ;
   private int[] T00086_A31ProfesionalId ;
   private java.util.UUID[] T00086_A56ExperienciaLaboralId ;
   private String[] T00086_A204ExperienciaLaboralEmpresaNombre ;
   private java.util.Date[] T00086_A205ExperienciaLaboralDesde ;
   private java.util.Date[] T00086_A206ExperienciaLaboralHasta ;
   private int[] T000870_A31ProfesionalId ;
   private java.util.UUID[] T000870_A56ExperienciaLaboralId ;
   private int[] T000871_A31ProfesionalId ;
   private java.util.UUID[] T000871_A57PremiosId ;
   private String[] T000871_A207PremiosNombre ;
   private java.util.Date[] T000871_A208PremiosFecha ;
   private String[] T000871_A209PremiosDescripcion ;
   private int[] T000872_A31ProfesionalId ;
   private java.util.UUID[] T000872_A57PremiosId ;
   private int[] T00085_A31ProfesionalId ;
   private java.util.UUID[] T00085_A57PremiosId ;
   private String[] T00085_A207PremiosNombre ;
   private java.util.Date[] T00085_A208PremiosFecha ;
   private String[] T00085_A209PremiosDescripcion ;
   private int[] T00084_A31ProfesionalId ;
   private java.util.UUID[] T00084_A57PremiosId ;
   private String[] T00084_A207PremiosNombre ;
   private java.util.Date[] T00084_A208PremiosFecha ;
   private String[] T00084_A209PremiosDescripcion ;
   private int[] T000876_A31ProfesionalId ;
   private java.util.UUID[] T000876_A57PremiosId ;
   private int[] T000877_A31ProfesionalId ;
   private java.util.UUID[] T000877_A58ServiciosId ;
   private String[] T000877_A210ServiciosNombre ;
   private int[] T000878_A31ProfesionalId ;
   private java.util.UUID[] T000878_A58ServiciosId ;
   private int[] T00083_A31ProfesionalId ;
   private java.util.UUID[] T00083_A58ServiciosId ;
   private String[] T00083_A210ServiciosNombre ;
   private int[] T00082_A31ProfesionalId ;
   private java.util.UUID[] T00082_A58ServiciosId ;
   private String[] T00082_A210ServiciosNombre ;
   private int[] T000882_A31ProfesionalId ;
   private java.util.UUID[] T000882_A58ServiciosId ;
   private short[] T000883_A6SecUserId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class profesional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00082", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [ServiciosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00083", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? AND [ServiciosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00084", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [PremiosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00085", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? AND [PremiosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00086", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00087", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00088", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EducacionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00089", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? AND [EducacionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000810", "SELECT [ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId] FROM [ProfesionalEspecialidadSede] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000811", "SELECT [ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000812", "SELECT [ClinicaId], [SedeNombre] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000813", "SELECT [ClinicaNombreAbreviado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000814", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WITH (UPDLOCK) WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000815", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000816", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000817", "SELECT [ProfesionalId], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId] FROM [Profesional] WITH (UPDLOCK) WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000818", "SELECT [ProfesionalId], [ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId] FROM [Profesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000819", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000820", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000821", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000822", "SELECT TM1.[ProfesionalId], TM1.[ProfesionalTipoDocumento], TM1.[ProfesionalNroDocumento], TM1.[ProfesionalApellidoPaterno], TM1.[ProfesionalApellidoMaterno], TM1.[ProfesionalNombres], TM1.[ProfesionalFechaNacimiento], TM1.[ProfesionalSexo], TM1.[ProfesionalDescripcion], TM1.[ProfesionalCorreo], TM1.[ProfesionalCOP], TM1.[ProfesionalColorDisponible], TM1.[ProfesionalColorCita], TM1.[ProfesionalTiempoCita], TM1.[ProfesionalDireccion], T2.[PaisDescripcion], TM1.[ProfesionalFoto], TM1.[ProfesionalFoto_GXI], TM1.[ProfesionalTwitter], TM1.[ProfesionalFacebook], TM1.[ProfesionalInstagram], TM1.[ProfesionalLinkedin], TM1.[ProfesionalTelefono], TM1.[ProfesionalFechaRegistro], TM1.[ProfesionalTerminosCondiciones], TM1.[ProfesionalEstadoCuenta], TM1.[ProfesionalEstado], T3.[UbigeoDepartamento], T3.[UbigeoProvincia], T3.[UbigeoDistrito], TM1.[PaisId], TM1.[UbigeoCode], TM1.[SecUserId] FROM (([Profesional] TM1 INNER JOIN [Pais] T2 ON T2.[PaisId] = TM1.[PaisId]) INNER JOIN [Ubigeo] T3 ON T3.[UbigeoCode] = TM1.[UbigeoCode]) WHERE TM1.[ProfesionalId] = ? ORDER BY TM1.[ProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000823", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000824", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000825", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000826", "SELECT [ProfesionalId] FROM [Profesional] WHERE [ProfesionalId] = ?  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000827", "SELECT TOP 1 [ProfesionalId] FROM [Profesional] WHERE ( [ProfesionalId] > ?) ORDER BY [ProfesionalId]  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000828", "SELECT TOP 1 [ProfesionalId] FROM [Profesional] WHERE ( [ProfesionalId] < ?) ORDER BY [ProfesionalId] DESC  OPTION (FAST 1)",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000829", "INSERT INTO [Profesional]([ProfesionalTipoDocumento], [ProfesionalNroDocumento], [ProfesionalApellidoPaterno], [ProfesionalApellidoMaterno], [ProfesionalNombres], [ProfesionalFechaNacimiento], [ProfesionalSexo], [ProfesionalDescripcion], [ProfesionalCorreo], [ProfesionalCOP], [ProfesionalColorDisponible], [ProfesionalColorCita], [ProfesionalTiempoCita], [ProfesionalDireccion], [ProfesionalFoto], [ProfesionalFoto_GXI], [ProfesionalTwitter], [ProfesionalFacebook], [ProfesionalInstagram], [ProfesionalLinkedin], [ProfesionalTelefono], [ProfesionalFechaRegistro], [ProfesionalTerminosCondiciones], [ProfesionalEstadoCuenta], [ProfesionalEstado], [PaisId], [UbigeoCode], [SecUserId]) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); SELECT SCOPE_IDENTITY()", GX_NOMASK)
         ,new UpdateCursor("T000830", "UPDATE [Profesional] SET [ProfesionalTipoDocumento]=?, [ProfesionalNroDocumento]=?, [ProfesionalApellidoPaterno]=?, [ProfesionalApellidoMaterno]=?, [ProfesionalNombres]=?, [ProfesionalFechaNacimiento]=?, [ProfesionalSexo]=?, [ProfesionalDescripcion]=?, [ProfesionalCorreo]=?, [ProfesionalCOP]=?, [ProfesionalColorDisponible]=?, [ProfesionalColorCita]=?, [ProfesionalTiempoCita]=?, [ProfesionalDireccion]=?, [ProfesionalTwitter]=?, [ProfesionalFacebook]=?, [ProfesionalInstagram]=?, [ProfesionalLinkedin]=?, [ProfesionalTelefono]=?, [ProfesionalFechaRegistro]=?, [ProfesionalTerminosCondiciones]=?, [ProfesionalEstadoCuenta]=?, [ProfesionalEstado]=?, [PaisId]=?, [UbigeoCode]=?, [SecUserId]=?  WHERE [ProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000831", "UPDATE [Profesional] SET [ProfesionalFoto]=?, [ProfesionalFoto_GXI]=?  WHERE [ProfesionalId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000832", "DELETE FROM [Profesional]  WHERE [ProfesionalId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000833", "SELECT [PaisDescripcion] FROM [Pais] WHERE [PaisId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000834", "SELECT [UbigeoDepartamento], [UbigeoProvincia], [UbigeoDistrito] FROM [Ubigeo] WHERE [UbigeoCode] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000835", "SELECT TOP 1 [ComentarioProfesionalId] FROM [ComentarioProfesional] WHERE [SGProfesionalProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000836", "SELECT TOP 1 [RatingProfesionalId] FROM [RatingProfesional] WHERE [SGProfesionalProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000837", "SELECT TOP 1 [EducacionProfesionalId] FROM [EducacionProfesional] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000838", "SELECT TOP 1 [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000839", "SELECT [ProfesionalId] FROM [Profesional] ORDER BY [ProfesionalId]  OPTION (FAST 100)",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000840", "SELECT T1.[ProfesionalId], T2.[EspecialidadCodigo], T2.[EspecialidadNombre], T1.[EspecialidadId] FROM ([ProfesionalEspecialidad] T1 INNER JOIN [Especialidad] T2 ON T2.[EspecialidadId] = T1.[EspecialidadId]) WHERE T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ? ORDER BY T1.[ProfesionalId], T1.[EspecialidadId] ",true, GX_NOMASK, false, this,6, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000841", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000842", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000843", "INSERT INTO [ProfesionalEspecialidad]([ProfesionalId], [EspecialidadId]) VALUES(?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000844", "DELETE FROM [ProfesionalEspecialidad]  WHERE [ProfesionalId] = ? AND [EspecialidadId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000845", "SELECT [EspecialidadCodigo], [EspecialidadNombre] FROM [Especialidad] WHERE [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000846", "SELECT TOP 1 [DisponibilidadId] FROM [Disponibilidad] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000847", "SELECT TOP 1 [ConfComisionId] FROM [ConfComision] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000848", "SELECT [ProfesionalId], [EspecialidadId] FROM [ProfesionalEspecialidad] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [EspecialidadId] ",true, GX_NOMASK, false, this,6, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000849", "SELECT T2.[ClinicaId], T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeTipoConsulta], T1.[CostoConsulta], T2.[SedeNombre], T3.[ClinicaNombreAbreviado], T1.[SedeId] FROM (([ProfesionalEspecialidadSede] T1 INNER JOIN [Sede] T2 ON T2.[SedeId] = T1.[SedeId]) INNER JOIN [Clinica] T3 ON T3.[ClinicaId] = T2.[ClinicaId]) WHERE T1.[ProfesionalId] = ? and T1.[EspecialidadId] = ? and T1.[SedeTipoConsulta] = ? and T1.[SedeId] = ? ORDER BY T1.[ProfesionalId], T1.[EspecialidadId], T1.[SedeId], T1.[SedeTipoConsulta] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000850", "SELECT [ClinicaId], [SedeNombre] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000851", "SELECT [ClinicaNombreAbreviado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000852", "SELECT [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000853", "INSERT INTO [ProfesionalEspecialidadSede]([ProfesionalId], [EspecialidadId], [SedeTipoConsulta], [CostoConsulta], [SedeId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000854", "UPDATE [ProfesionalEspecialidadSede] SET [CostoConsulta]=?  WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ?", GX_NOMASK)
         ,new UpdateCursor("T000855", "DELETE FROM [ProfesionalEspecialidadSede]  WHERE [ProfesionalId] = ? AND [EspecialidadId] = ? AND [SedeId] = ? AND [SedeTipoConsulta] = ?", GX_NOMASK)
         ,new ForEachCursor("T000856", "SELECT [ClinicaId], [SedeNombre] FROM [Sede] WHERE [SedeId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000857", "SELECT [ClinicaNombreAbreviado] FROM [Clinica] WHERE [ClinicaId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000858", "SELECT [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] FROM [ProfesionalEspecialidadSede] WHERE [ProfesionalId] = ? and [EspecialidadId] = ? ORDER BY [ProfesionalId], [EspecialidadId], [SedeId], [SedeTipoConsulta] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000859", "SELECT [ProfesionalId], [EducacionId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? and [EducacionId] = ? ORDER BY [ProfesionalId], [EducacionId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000860", "SELECT [ProfesionalId], [EducacionId] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? AND [EducacionId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000861", "INSERT INTO [ProfesionalEducacion]([ProfesionalId], [EducacionNombreInstitucion], [EducacionDesde], [EducacionHasta], [EducacionPaisDescripcion], [EducacionId]) VALUES(?, ?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000862", "UPDATE [ProfesionalEducacion] SET [EducacionNombreInstitucion]=?, [EducacionDesde]=?, [EducacionHasta]=?, [EducacionPaisDescripcion]=?  WHERE [ProfesionalId] = ? AND [EducacionId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000863", "DELETE FROM [ProfesionalEducacion]  WHERE [ProfesionalId] = ? AND [EducacionId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000864", "SELECT [ProfesionalId], [EducacionId] FROM [ProfesionalEducacion] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [EducacionId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000865", "SELECT [ProfesionalId], [ExperienciaLaboralId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? and [ExperienciaLaboralId] = ? ORDER BY [ProfesionalId], [ExperienciaLaboralId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000866", "SELECT [ProfesionalId], [ExperienciaLaboralId] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000867", "INSERT INTO [ProfesionalExperienciaLaboral]([ProfesionalId], [ExperienciaLaboralEmpresaNombre], [ExperienciaLaboralDesde], [ExperienciaLaboralHasta], [ExperienciaLaboralId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000868", "UPDATE [ProfesionalExperienciaLaboral] SET [ExperienciaLaboralEmpresaNombre]=?, [ExperienciaLaboralDesde]=?, [ExperienciaLaboralHasta]=?  WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000869", "DELETE FROM [ProfesionalExperienciaLaboral]  WHERE [ProfesionalId] = ? AND [ExperienciaLaboralId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000870", "SELECT [ProfesionalId], [ExperienciaLaboralId] FROM [ProfesionalExperienciaLaboral] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [ExperienciaLaboralId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000871", "SELECT [ProfesionalId], [PremiosId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? and [PremiosId] = ? ORDER BY [ProfesionalId], [PremiosId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000872", "SELECT [ProfesionalId], [PremiosId] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? AND [PremiosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000873", "INSERT INTO [ProfesionalPremios]([ProfesionalId], [PremiosNombre], [PremiosFecha], [PremiosDescripcion], [PremiosId]) VALUES(?, ?, ?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000874", "UPDATE [ProfesionalPremios] SET [PremiosNombre]=?, [PremiosFecha]=?, [PremiosDescripcion]=?  WHERE [ProfesionalId] = ? AND [PremiosId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000875", "DELETE FROM [ProfesionalPremios]  WHERE [ProfesionalId] = ? AND [PremiosId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000876", "SELECT [ProfesionalId], [PremiosId] FROM [ProfesionalPremios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [PremiosId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000877", "SELECT [ProfesionalId], [ServiciosId], [ServiciosNombre] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? and [ServiciosId] = ? ORDER BY [ProfesionalId], [ServiciosId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000878", "SELECT [ProfesionalId], [ServiciosId] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? AND [ServiciosId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000879", "INSERT INTO [ProfesionalServicios]([ProfesionalId], [ServiciosNombre], [ServiciosId]) VALUES(?, ?, ?)", GX_NOMASK)
         ,new UpdateCursor("T000880", "UPDATE [ProfesionalServicios] SET [ServiciosNombre]=?  WHERE [ProfesionalId] = ? AND [ServiciosId] = ?", GX_NOMASK)
         ,new UpdateCursor("T000881", "DELETE FROM [ProfesionalServicios]  WHERE [ProfesionalId] = ? AND [ServiciosId] = ?", GX_NOMASK)
         ,new ForEachCursor("T000882", "SELECT [ProfesionalId], [ServiciosId] FROM [ProfesionalServicios] WHERE [ProfesionalId] = ? ORDER BY [ProfesionalId], [ServiciosId] ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000883", "SELECT [SecUserId] FROM [SecUser] WHERE [SecUserId] = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((String[]) buf[16])[0] = rslt.getMultimediaUri(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 10);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getMultimediaFile(16, rslt.getVarchar(17));
               ((String[]) buf[16])[0] = rslt.getMultimediaUri(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getString(22, 20);
               ((java.util.Date[]) buf[22])[0] = rslt.getGXDate(23);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(24);
               ((String[]) buf[24])[0] = rslt.getString(25, 2);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((short[]) buf[26])[0] = rslt.getShort(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 10);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 20);
               ((String[]) buf[12])[0] = rslt.getString(13, 20);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getMultimediaFile(17, rslt.getVarchar(18));
               ((String[]) buf[17])[0] = rslt.getMultimediaUri(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((String[]) buf[21])[0] = rslt.getVarchar(22);
               ((String[]) buf[22])[0] = rslt.getString(23, 20);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(24);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 2);
               ((String[]) buf[26])[0] = rslt.getString(27, 2);
               ((String[]) buf[27])[0] = rslt.getVarchar(28);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((short[]) buf[30])[0] = rslt.getShort(31);
               ((String[]) buf[31])[0] = rslt.getString(32, 10);
               ((short[]) buf[32])[0] = rslt.getShort(33);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 31 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 32 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 39 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 43 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 45 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 46 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 47 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 48 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 49 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 50 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 54 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 55 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 56 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               return;
            case 57 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 58 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 62 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 63 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 64 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 68 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 69 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               return;
            case 70 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 74 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 75 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 76 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 80 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.UUID[]) buf[1])[0] = rslt.getGUID(2);
               return;
            case 81 :
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
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 22 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 27 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setVarchar(2, (String)parms[1], 15, false);
               stmt.setVarchar(3, (String)parms[2], 50, false);
               stmt.setVarchar(4, (String)parms[3], 50, false);
               stmt.setVarchar(5, (String)parms[4], 50, false);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setVarchar(8, (String)parms[7], 5000, false);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setVarchar(14, (String)parms[13], 200, false);
               stmt.setBLOBFile(15, (String)parms[14], true);
               stmt.setGXDbFileURI(16, (String)parms[15], (String)parms[14], 2048,"Profesional","ProfesionalFoto");
               stmt.setVarchar(17, (String)parms[16], 1000, false);
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setVarchar(19, (String)parms[18], 1000, false);
               stmt.setVarchar(20, (String)parms[19], 1000, false);
               stmt.setString(21, (String)parms[20], 20);
               stmt.setDate(22, (java.util.Date)parms[21]);
               stmt.setBoolean(23, ((Boolean) parms[22]).booleanValue());
               stmt.setString(24, (String)parms[23], 2);
               stmt.setString(25, (String)parms[24], 2);
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setString(27, (String)parms[26], 10);
               stmt.setShort(28, ((Number) parms[27]).shortValue());
               return;
            case 28 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setVarchar(2, (String)parms[1], 15, false);
               stmt.setVarchar(3, (String)parms[2], 50, false);
               stmt.setVarchar(4, (String)parms[3], 50, false);
               stmt.setVarchar(5, (String)parms[4], 50, false);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setString(7, (String)parms[6], 1);
               stmt.setVarchar(8, (String)parms[7], 5000, false);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setVarchar(14, (String)parms[13], 200, false);
               stmt.setVarchar(15, (String)parms[14], 1000, false);
               stmt.setVarchar(16, (String)parms[15], 1000, false);
               stmt.setVarchar(17, (String)parms[16], 1000, false);
               stmt.setVarchar(18, (String)parms[17], 1000, false);
               stmt.setString(19, (String)parms[18], 20);
               stmt.setDate(20, (java.util.Date)parms[19]);
               stmt.setBoolean(21, ((Boolean) parms[20]).booleanValue());
               stmt.setString(22, (String)parms[21], 2);
               stmt.setString(23, (String)parms[22], 2);
               stmt.setShort(24, ((Number) parms[23]).shortValue());
               stmt.setString(25, (String)parms[24], 10);
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setInt(27, ((Number) parms[26]).intValue());
               return;
            case 29 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Profesional","ProfesionalFoto");
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 31 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 32 :
               stmt.setString(1, (String)parms[0], 10);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 39 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 42 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 43 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 47 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 1);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 48 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 49 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 50 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 51 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 1);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 2);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 52 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 1);
               return;
            case 53 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 1);
               return;
            case 54 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 55 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 56 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 57 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 58 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 59 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 300, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setVarchar(5, (String)parms[4], 200, false);
               stmt.setGUID(6, (java.util.UUID)parms[5]);
               return;
      }
      setparameters60( cursor, stmt, parms) ;
   }

   public void setparameters60( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 60 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setVarchar(4, (String)parms[3], 200, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setGUID(6, (java.util.UUID)parms[5]);
               return;
            case 61 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 62 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 63 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 64 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 65 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 300, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 66 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 67 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 68 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 69 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 70 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 71 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 500, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setNLongVarchar(4, (String)parms[3], false);
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 72 :
               stmt.setVarchar(1, (String)parms[0], 500, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setGUID(5, (java.util.UUID)parms[4]);
               return;
            case 73 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 74 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 75 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 76 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 77 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 300, false);
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 78 :
               stmt.setVarchar(1, (String)parms[0], 300, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setGUID(3, (java.util.UUID)parms[2]);
               return;
            case 79 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setGUID(2, (java.util.UUID)parms[1]);
               return;
            case 80 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 81 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

