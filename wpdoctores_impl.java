package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpdoctores_impl extends GXDataArea
{
   public wpdoctores_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpdoctores_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpdoctores_impl.class ));
   }

   public wpdoctores_impl( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV21EspeciadadId = (short) GXutil.lval( args[0]);
         AV55TipoCita = (String) args[1];
         AV25Fecha = (java.util.Date) localUtil.ctod( args[2], 3);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      chkavGeneromasculino = UIFactory.getCheckbox(this);
      chkavGenerofemenino = UIFactory.getCheckbox(this);
      chkavCtlestado1 = UIFactory.getCheckbox(this);
      chkavCtlespecialidadcheck = UIFactory.getCheckbox(this);
      chkavAtencionvirtual = UIFactory.getCheckbox(this);
      chkavAtencionpresencial = UIFactory.getCheckbox(this);
      chkavAtenciondomicilio = UIFactory.getCheckbox(this);
      cmbavDepartamento = new HTMLChoice();
      dynavProvincia = new HTMLChoice();
      dynavDistrito = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "EspeciadadId") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vPROVINCIA") == 0 )
         {
            AV13Departamento = httpContext.GetPar( "Departamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13Departamento", AV13Departamento);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvprovincia2W2( AV13Departamento) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vDISTRITO") == 0 )
         {
            AV13Departamento = httpContext.GetPar( "Departamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13Departamento", AV13Departamento);
            AV53Provincia = httpContext.GetPar( "Provincia") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV53Provincia", AV53Provincia);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvdistrito2W2( AV13Departamento, AV53Provincia) ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "EspeciadadId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "EspeciadadId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid5") == 0 )
         {
            nRC_GXsfl_50 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_50"))) ;
            nGXsfl_50_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_50_idx"))) ;
            sGXsfl_50_idx = httpContext.GetPar( "sGXsfl_50_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgrid5_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid5") == 0 )
         {
            AV28GeneroMasculino = httpContext.GetPar( "GeneroMasculino") ;
            AV27GeneroFemenino = httpContext.GetPar( "GeneroFemenino") ;
            AV7AtencionVirtual = httpContext.GetPar( "AtencionVirtual") ;
            AV6AtencionPresencial = httpContext.GetPar( "AtencionPresencial") ;
            AV5AtencionDomicilio = httpContext.GetPar( "AtencionDomicilio") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23Especialidades);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV52Precios);
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid5_refresh( AV28GeneroMasculino, AV27GeneroFemenino, AV7AtencionVirtual, AV6AtencionPresencial, AV5AtencionDomicilio, AV23Especialidades, AV52Precios, Gx_date) ;
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid2") == 0 )
         {
            nRC_GXsfl_75 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_75"))) ;
            nGXsfl_75_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_75_idx"))) ;
            sGXsfl_75_idx = httpContext.GetPar( "sGXsfl_75_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgrid2_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid2") == 0 )
         {
            AV28GeneroMasculino = httpContext.GetPar( "GeneroMasculino") ;
            AV27GeneroFemenino = httpContext.GetPar( "GeneroFemenino") ;
            AV7AtencionVirtual = httpContext.GetPar( "AtencionVirtual") ;
            AV6AtencionPresencial = httpContext.GetPar( "AtencionPresencial") ;
            AV5AtencionDomicilio = httpContext.GetPar( "AtencionDomicilio") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23Especialidades);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV52Precios);
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid2_refresh( AV28GeneroMasculino, AV27GeneroFemenino, AV7AtencionVirtual, AV6AtencionPresencial, AV5AtencionDomicilio, AV23Especialidades, AV52Precios, Gx_date) ;
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlitadodoctores") == 0 )
         {
            nRC_GXsfl_163 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_163"))) ;
            nGXsfl_163_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_163_idx"))) ;
            sGXsfl_163_idx = httpContext.GetPar( "sGXsfl_163_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridlitadodoctores_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridlitadodoctores") == 0 )
         {
            AV28GeneroMasculino = httpContext.GetPar( "GeneroMasculino") ;
            AV27GeneroFemenino = httpContext.GetPar( "GeneroFemenino") ;
            AV7AtencionVirtual = httpContext.GetPar( "AtencionVirtual") ;
            AV6AtencionPresencial = httpContext.GetPar( "AtencionPresencial") ;
            AV5AtencionDomicilio = httpContext.GetPar( "AtencionDomicilio") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23Especialidades);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV52Precios);
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridlitadodoctores_refresh( AV28GeneroMasculino, AV27GeneroFemenino, AV7AtencionVirtual, AV6AtencionPresencial, AV5AtencionDomicilio, AV23Especialidades, AV52Precios, Gx_date) ;
            addString( httpContext.getJSONResponse( )) ;
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
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV21EspeciadadId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21EspeciadadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21EspeciadadId), 4, 0));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV55TipoCita = httpContext.GetPar( "TipoCita") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV55TipoCita", AV55TipoCita);
               AV25Fecha = localUtil.parseDateParm( httpContext.GetPar( "Fecha")) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV25Fecha", localUtil.format(AV25Fecha, "99/99/99"));
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.projectthani.mphomepage");
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

   public byte executeStartEvent( )
   {
      pa2W2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2W2( ) ;
      }
      return gxajaxcallmode ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334761", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal FormFondoGeneral\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoGeneral\" data-gx-class=\"form-horizontal FormFondoGeneral\" novalidate action=\""+formatLink("com.projectthani.wpdoctores", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV21EspeciadadId,4,0)),GXutil.URLEncode(GXutil.rtrim(AV55TipoCita)),GXutil.URLEncode(GXutil.formatDateParm(AV25Fecha))}, new String[] {"EspeciadadId","TipoCita","Fecha"}) +"\">") ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal FormFondoGeneral", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADES", getSecureSignedToken( "", AV23Especialidades));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRECIOS", getSecureSignedToken( "", AV52Precios));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Especialidades", AV23Especialidades);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Especialidades", AV23Especialidades);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Especialidades", getSecureSignedToken( "", AV23Especialidades));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Doctores", AV20Doctores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Doctores", AV20Doctores);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Precios", AV52Precios);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Precios", AV52Precios);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Precios", getSecureSignedToken( "", AV52Precios));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_50", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_50, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_75", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_75, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_163", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_163, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vESPECIALIDADES", AV23Especialidades);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vESPECIALIDADES", AV23Especialidades);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADES", getSecureSignedToken( "", AV23Especialidades));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPRECIOS", AV52Precios);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPRECIOS", AV52Precios);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRECIOS", getSecureSignedToken( "", AV52Precios));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDOCTORES", AV20Doctores);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDOCTORES", AV20Doctores);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vESPECIADADID", GXutil.ltrim( localUtil.ntoc( AV21EspeciadadId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTIPOCITA", GXutil.rtrim( AV55TipoCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFECHA", localUtil.dtoc( AV25Fecha, 0, "/"));
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal FormFondoGeneral" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we2W2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2W2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.projectthani.wpdoctores", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV21EspeciadadId,4,0)),GXutil.URLEncode(GXutil.rtrim(AV55TipoCita)),GXutil.URLEncode(GXutil.formatDateParm(AV25Fecha))}, new String[] {"EspeciadadId","TipoCita","Fecha"})  ;
   }

   public String getPgmname( )
   {
      return "WPDoctores" ;
   }

   public String getPgmdesc( )
   {
      return "Buscar Médico" ;
   }

   public void wb2W0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         com.projectthani.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "TablePrincipalDoctores", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-md-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablefiltromedicos_Internalname, 1, 0, "px", 0, "px", "TableFiltroMedicos", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock_Internalname, "Filtro de búsqueda", "", "", lblTextblock_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable10_Internalname, 1, 0, "px", 0, "px", "TableLimpiarFiltros", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         lblTextblocklimpiarfiltros_Link = "" ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblocklimpiarfiltros_Internalname, "Link", lblTextblocklimpiarfiltros_Link, true);
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblocklimpiarfiltros_Internalname, lblTextblocklimpiarfiltros_Caption, lblTextblocklimpiarfiltros_Link, "", lblTextblocklimpiarfiltros_Jsonclick, "'"+""+"'"+",false,"+"'"+"e112w1_client"+"'", "", "TextBlock", 7, "", 1, 1, 0, (short)(1), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "TableBuscadorTitleGeneral", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9 TableFiltroGenero", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockgenero_Internalname, "Genero", "", "", lblTextblockgenero_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbSubTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockiconoflecha_Internalname, lblTextblockiconoflecha_Caption, "", "", lblTextblockiconoflecha_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable6_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavGeneromasculino.getInternalname(), "Genero Masculino", "col-sm-3 tbCheckBoxFiltroLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         ClassString = "tbCheckBoxFiltro" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavGeneromasculino.getInternalname(), AV28GeneroMasculino, "", "Genero Masculino", 1, chkavGeneromasculino.getEnabled(), "M", "Masculino", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(32, this, 'M', 'S',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,32);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavGenerofemenino.getInternalname(), "Genero Femenino", "col-sm-3 tbCheckBoxFiltroLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         ClassString = "tbCheckBoxFiltro" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavGenerofemenino.getInternalname(), AV27GeneroFemenino, "", "Genero Femenino", 1, chkavGenerofemenino.getEnabled(), "F", "Femenino", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(36, this, 'F', 'S',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,36);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable7_Internalname, divTable7_Visible, 0, "px", 0, "px", "TableBuscadorTitleGeneral", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbrangoprecios_Internalname, "Rango de precios", "", "", lblTbrangoprecios_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbSubTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockrangprecicon_Internalname, lblTextblockrangprecicon_Caption, "", "", lblTextblockrangprecicon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable18_Internalname, divTable18_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid5Container.SetIsFreestyle(true);
         Grid5Container.SetWrapped(nGXWrapped);
         if ( Grid5Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"Grid5Container"+"DivS\" data-gxgridid=\"50\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGrid5_Internalname, subGrid5_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            Grid5Container.AddObjectProperty("GridName", "Grid5");
         }
         else
         {
            Grid5Container.AddObjectProperty("GridName", "Grid5");
            Grid5Container.AddObjectProperty("Header", subGrid5_Header);
            Grid5Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            Grid5Container.AddObjectProperty("Class", "FreeStyleGrid");
            Grid5Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid5_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("CmpContext", "");
            Grid5Container.AddObjectProperty("InMasterPage", "false");
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtldescripcion1_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlidprecio1_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid5_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid5_Allowselection, (byte)(1), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid5_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid5_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid5_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid5_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            Grid5Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid5_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 50 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_50 = (int)(nGXsfl_50_idx-1) ;
         if ( Grid5Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV62GXV1 = nGXsfl_50_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid5Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid5", Grid5Container);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid5ContainerData", Grid5Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid5ContainerData"+"V", Grid5Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid5ContainerData"+"V"+"\" value='"+Grid5Container.GridValuesHidden()+"'/>") ;
            }
         }
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable8_Internalname, 1, 0, "px", 0, "px", "TableBuscadorTitleGeneral", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9 TableFiltroTituloDoctores", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbespecialidades_Internalname, "Especialidades", "", "", lblTbespecialidades_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbSubTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockespecialicon_Internalname, lblTextblockespecialicon_Caption, "", "", lblTextblockespecialicon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable19_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid2Container.SetIsFreestyle(true);
         Grid2Container.SetWrapped(nGXWrapped);
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"Grid2Container"+"DivS\" data-gxgridid=\"75\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGrid2_Internalname, subGrid2_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            Grid2Container.AddObjectProperty("GridName", "Grid2");
         }
         else
         {
            Grid2Container.AddObjectProperty("GridName", "Grid2");
            Grid2Container.AddObjectProperty("Header", subGrid2_Header);
            Grid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            Grid2Container.AddObjectProperty("Class", "FreeStyleGrid");
            Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("CmpContext", "");
            Grid2Container.AddObjectProperty("InMasterPage", "false");
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlespecialidadnombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlespecialidadid_Enabled, (byte)(5), (byte)(0), ".", "")));
            Grid2Container.AddColumnProperties(Grid2Column);
            Grid2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowselection, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            Grid2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid2_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 75 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_75 = (int)(nGXsfl_75_idx-1) ;
         if ( Grid2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV66GXV5 = nGXsfl_75_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid2", Grid2Container);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData", Grid2Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData"+"V", Grid2Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid2ContainerData"+"V"+"\" value='"+Grid2Container.GridValuesHidden()+"'/>") ;
            }
         }
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable9_Internalname, 1, 0, "px", 0, "px", "TableBuscadorTitleGeneral", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-9 TableFiltroTituloDoctores", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbtipoatencion_Internalname, "Atención", "", "", lblTbtipoatencion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbSubTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-3", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockatencionicon_Internalname, lblTextblockatencionicon_Caption, "", "", lblTextblockatencionicon_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable11_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavAtencionvirtual.getInternalname(), "Atencion Virtual", "col-sm-3 tbCheckBoxFiltroLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 101,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         ClassString = "tbCheckBoxFiltro" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAtencionvirtual.getInternalname(), AV7AtencionVirtual, "", "Atencion Virtual", 1, chkavAtencionvirtual.getEnabled(), "V", "Virtual", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(101, this, 'V', 'N',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,101);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavAtencionpresencial.getInternalname(), "Atencion Presencial", "col-sm-3 tbCheckBoxFiltroLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 105,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         ClassString = "tbCheckBoxFiltro" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAtencionpresencial.getInternalname(), AV6AtencionPresencial, "", "Atencion Presencial", 1, chkavAtencionpresencial.getEnabled(), "P", "En consultorio", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(105, this, 'P', 'N',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,105);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavAtenciondomicilio.getInternalname(), "Atencion a domicilio", "col-sm-3 tbCheckBoxFiltroLabel", 0, true, "");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         ClassString = "tbCheckBoxFiltro" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavAtenciondomicilio.getInternalname(), AV5AtencionDomicilio, "", "Atencion a domicilio", 1, chkavAtenciondomicilio.getEnabled(), "D", "A domicilio", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(109, this, 'D', 'N',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,109);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable12_Internalname, divTable12_Visible, 0, "px", 0, "px", "TableBuscadorTitleGeneral", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbdepartamento_Internalname, "Departamento", "", "", lblTbdepartamento_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbSubTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable13_Internalname, divTable13_Visible, 0, "px", 0, "px", "Table ShowTable1", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableDPD", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavDepartamento.getInternalname(), "Departamento", "col-sm-3 AttrDPDLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDepartamento, cmbavDepartamento.getInternalname(), GXutil.rtrim( AV13Departamento), 1, cmbavDepartamento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavDepartamento.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttrDPD", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,122);\"", "", true, (byte)(1), "HLP_WPDoctores.htm");
         cmbavDepartamento.setValue( GXutil.rtrim( AV13Departamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDepartamento.getInternalname(), "Values", cmbavDepartamento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable14_Internalname, divTable14_Visible, 0, "px", 0, "px", "TableBuscadorTitleGeneral", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbprovincia_Internalname, "Provincia", "", "", lblTbprovincia_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbSubTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable17_Internalname, divTable17_Visible, 0, "px", 0, "px", "Table ShowTable2", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableDPD", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavProvincia.getInternalname(), "Provincia", "col-sm-3 AttrDPDLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 135,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavProvincia, dynavProvincia.getInternalname(), GXutil.rtrim( AV53Provincia), 1, dynavProvincia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavProvincia.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttrDPD", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,135);\"", "", true, (byte)(1), "HLP_WPDoctores.htm");
         dynavProvincia.setValue( GXutil.rtrim( AV53Provincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProvincia.getInternalname(), "Values", dynavProvincia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable16_Internalname, divTable16_Visible, 0, "px", 0, "px", "TableBuscadorTitleGeneral", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbdistrito_Internalname, "Distrito", "", "", lblTbdistrito_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "tbSubTituloFiltro", 0, "", 1, 1, 0, (short)(0), "HLP_WPDoctores.htm");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable15_Internalname, divTable15_Visible, 0, "px", 0, "px", "Table ShowTable3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableDPD", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavDistrito.getInternalname(), "Distrito", "col-sm-3 AttrDPDLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 148,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavDistrito, dynavDistrito.getInternalname(), GXutil.rtrim( AV18Distrito), 1, dynavDistrito.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavDistrito.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttrDPD", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,148);\"", "", true, (byte)(1), "HLP_WPDoctores.htm");
         dynavDistrito.setValue( GXutil.rtrim( AV18Distrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDistrito.getInternalname(), "Values", dynavDistrito.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableBuscarFitroDoctores", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 151,'',false,'',0)\"" ;
         ClassString = "btnBuscarFiltroDoctores" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBuscarfiltrodoctor_Internalname, "gx.evt.setGridEvt("+GXutil.str( 50, 2, 0)+","+"null"+");", "Buscar", bttBuscarfiltrodoctor_Jsonclick, 5, "Buscar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'BUSCARFILTRODOCTOR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPDoctores.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 col-md-9", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablelistadodoctores_Internalname, 1, 0, "px", 0, "px", "TableListadoDoctores", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row tbAlertaDoctores", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "TableBuscarDatosDoctor", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavNombresapellidosdoctor_Internalname, "Doctor :", "col-sm-3 AttributeBuscarDatosDoctorLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 160,'',false,'" + sGXsfl_50_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavNombresapellidosdoctor_Internalname, AV48NombresApellidosDoctor, GXutil.rtrim( localUtil.format( AV48NombresApellidosDoctor, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,160);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar por nombres y apellidos del médico", edtavNombresapellidosdoctor_Jsonclick, 0, "AttributeBuscarDatosDoctor", "", "", "", "", 1, edtavNombresapellidosdoctor_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPDoctores.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row tbAlertaDoctores", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridlitadodoctoresContainer.SetIsFreestyle(true);
         GridlitadodoctoresContainer.SetWrapped(nGXWrapped);
         if ( GridlitadodoctoresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridlitadodoctoresContainer"+"DivS\" data-gxgridid=\"163\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridlitadodoctores_Internalname, subGridlitadodoctores_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridlitadodoctoresContainer.AddObjectProperty("GridName", "Gridlitadodoctores");
         }
         else
         {
            GridlitadodoctoresContainer.AddObjectProperty("GridName", "Gridlitadodoctores");
            GridlitadodoctoresContainer.AddObjectProperty("Header", subGridlitadodoctores_Header);
            GridlitadodoctoresContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridlitadodoctoresContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridlitadodoctoresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("CmpContext", "");
            GridlitadodoctoresContainer.AddObjectProperty("InMasterPage", "false");
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlprofesionalid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlapellidosnombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Value", lblTxbiconespecialidad_Caption);
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlespecialidad_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlcalificacion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Value", lblTextblocklimpiarfiltros_Caption);
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtldireccion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Value", lblTxbicondisponible_Caption);
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Value", lblTextblock6_Caption);
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtldisponibilidad_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Value", lblTxbicontipocita_Caption);
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtltipocita_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Value", lblTxbiconprecioconsulta_Caption);
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlprecioconsulta_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridlitadodoctoresContainer.AddColumnProperties(GridlitadodoctoresColumn);
            GridlitadodoctoresContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridlitadodoctoresContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 163 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_163 = (int)(nGXsfl_163_idx-1) ;
         if ( GridlitadodoctoresContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV70GXV9 = nGXsfl_163_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridlitadodoctoresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridlitadodoctores", GridlitadodoctoresContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridlitadodoctoresContainerData", GridlitadodoctoresContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridlitadodoctoresContainerData"+"V", GridlitadodoctoresContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridlitadodoctoresContainerData"+"V"+"\" value='"+GridlitadodoctoresContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, "DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 50 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid5Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV62GXV1 = nGXsfl_50_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid5Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid5", Grid5Container);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid5ContainerData", Grid5Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid5ContainerData"+"V", Grid5Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid5ContainerData"+"V"+"\" value='"+Grid5Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 75 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid2Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV66GXV5 = nGXsfl_75_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid2Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid2", Grid2Container);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData", Grid2Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "Grid2ContainerData"+"V", Grid2Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid2ContainerData"+"V"+"\" value='"+Grid2Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 163 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridlitadodoctoresContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV70GXV9 = nGXsfl_163_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridlitadodoctoresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridlitadodoctores", GridlitadodoctoresContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridlitadodoctoresContainerData", GridlitadodoctoresContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridlitadodoctoresContainerData"+"V", GridlitadodoctoresContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridlitadodoctoresContainerData"+"V"+"\" value='"+GridlitadodoctoresContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start2W2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_7-156546", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Buscar Médico", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2W0( ) ;
   }

   public void ws2W2( )
   {
      start2W2( ) ;
      evt2W2( ) ;
   }

   public void evt2W2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "'BUSCARFILTRODOCTOR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'BuscarFiltroDoctor' */
                           e122W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VNOMBRESAPELLIDOSDOCTOR.CONTROLVALUECHANGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'BTNVERPERFIL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'BtnVerPerfil' */
                           e142W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'BTNAGENDARCITA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'BtnAgendarCita' */
                           e152W2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID2.LOAD") == 0 )
                        {
                           nGXsfl_75_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_755( ) ;
                           AV66GXV5 = nGXsfl_75_idx ;
                           if ( ( AV23Especialidades.size() >= AV66GXV5 ) && ( AV66GXV5 > 0 ) )
                           {
                              AV23Especialidades.currentItem( ((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRID2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e162W5 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 14), "'BTNVERPERFIL'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 16), "'BTNAGENDARCITA'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "GRIDLITADODOCTORES.LOAD") == 0 ) )
                        {
                           nGXsfl_163_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_163_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1634( ) ;
                           AV70GXV9 = nGXsfl_163_idx ;
                           if ( ( AV20Doctores.size() >= AV70GXV9 ) && ( AV70GXV9 > 0 ) )
                           {
                              AV20Doctores.currentItem( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "'BTNVERPERFIL'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'BtnVerPerfil' */
                                 e142W2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'BTNAGENDARCITA'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'BtnAgendarCita' */
                                 e152W2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDLITADODOCTORES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e172W4 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID5.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_50_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_50_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_50_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_502( ) ;
                           AV62GXV1 = nGXsfl_50_idx ;
                           if ( ( AV52Precios.size() >= AV62GXV1 ) && ( AV62GXV1 > 0 ) )
                           {
                              AV52Precios.currentItem( ((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e182W2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID5.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e192W2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we2W2( )
   {
      if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.projectthani.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa2W2( )
   {
      if ( nDonePA == 0 )
      {
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = chkavGeneromasculino.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvdistrito_html2W2( AV13Departamento, AV53Provincia) ;
      /* End function dynload_actions */
   }

   public void gxdlvvprovincia2W2( String AV13Departamento )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvprovincia_data2W2( AV13Departamento) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvprovincia_html2W2( String AV13Departamento )
   {
      String gxdynajaxvalue;
      gxdlvvprovincia_data2W2( AV13Departamento) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavProvincia.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavProvincia.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvprovincia_data2W2( String AV13Departamento )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H002W2 */
      pr_default.execute(0, new Object[] {AV13Departamento});
      while ( (pr_default.getStatus(0) != 101) )
      {
         if ( GXutil.strcmp(H002W2_A295UbigeoDepartamentoCode[0], AV13Departamento) == 0 )
         {
            gxdynajaxctrlcodr.add(H002W2_A296UbigeoProvinciaCode[0]);
            gxdynajaxctrldescr.add(H002W2_A187UbigeoProvincia[0]);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvdistrito2W2( String AV13Departamento ,
                                  String AV53Provincia )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvdistrito_data2W2( AV13Departamento, AV53Provincia) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvdistrito_html2W2( String AV13Departamento ,
                                     String AV53Provincia )
   {
      String gxdynajaxvalue;
      gxdlvvdistrito_data2W2( AV13Departamento, AV53Provincia) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavDistrito.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavDistrito.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvdistrito_data2W2( String AV13Departamento ,
                                          String AV53Provincia )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H002W3 */
      pr_default.execute(1, new Object[] {AV13Departamento, AV53Provincia});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(H002W3_A297UbigeoDistritoCode[0]);
         gxdynajaxctrldescr.add(H002W3_A188UbigeoDistrito[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxnrgrid5_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_502( ) ;
      while ( nGXsfl_50_idx <= nRC_GXsfl_50 )
      {
         sendrow_502( ) ;
         nGXsfl_50_idx = ((subGrid5_Islastpage==1)&&(nGXsfl_50_idx+1>subgrid5_fnc_recordsperpage( )) ? 1 : nGXsfl_50_idx+1) ;
         sGXsfl_50_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_50_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_502( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid5Container)) ;
      /* End function gxnrGrid5_newrow */
   }

   public void gxnrgridlitadodoctores_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1634( ) ;
      while ( nGXsfl_163_idx <= nRC_GXsfl_163 )
      {
         sendrow_1634( ) ;
         nGXsfl_163_idx = ((subGridlitadodoctores_Islastpage==1)&&(nGXsfl_163_idx+1>subgridlitadodoctores_fnc_recordsperpage( )) ? 1 : nGXsfl_163_idx+1) ;
         sGXsfl_163_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1634( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridlitadodoctoresContainer)) ;
      /* End function gxnrGridlitadodoctores_newrow */
   }

   public void gxnrgrid2_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_755( ) ;
      while ( nGXsfl_75_idx <= nRC_GXsfl_75 )
      {
         sendrow_755( ) ;
         nGXsfl_75_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_75_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_75_idx+1) ;
         sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_755( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid2Container)) ;
      /* End function gxnrGrid2_newrow */
   }

   public void gxgrgrid5_refresh( String AV28GeneroMasculino ,
                                  String AV27GeneroFemenino ,
                                  String AV7AtencionVirtual ,
                                  String AV6AtencionPresencial ,
                                  String AV5AtencionDomicilio ,
                                  GXBaseCollection<com.projectthani.SdtSDTEspecialidad> AV23Especialidades ,
                                  GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> AV52Precios ,
                                  java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID5_nCurrentRecord = 0 ;
      rf2W2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid5_refresh */
   }

   public void gxgrgrid2_refresh( String AV28GeneroMasculino ,
                                  String AV27GeneroFemenino ,
                                  String AV7AtencionVirtual ,
                                  String AV6AtencionPresencial ,
                                  String AV5AtencionDomicilio ,
                                  GXBaseCollection<com.projectthani.SdtSDTEspecialidad> AV23Especialidades ,
                                  GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> AV52Precios ,
                                  java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID2_nCurrentRecord = 0 ;
      rf2W5( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid2_refresh */
   }

   public void gxgrgridlitadodoctores_refresh( String AV28GeneroMasculino ,
                                               String AV27GeneroFemenino ,
                                               String AV7AtencionVirtual ,
                                               String AV6AtencionPresencial ,
                                               String AV5AtencionDomicilio ,
                                               GXBaseCollection<com.projectthani.SdtSDTEspecialidad> AV23Especialidades ,
                                               GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> AV52Precios ,
                                               java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDLITADODOCTORES_nCurrentRecord = 0 ;
      rf2W4( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridlitadodoctores_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      AV28GeneroMasculino = ((GXutil.strcmp(GXutil.rtrim( AV28GeneroMasculino), "M")==0) ? "M" : "S") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28GeneroMasculino", AV28GeneroMasculino);
      AV27GeneroFemenino = ((GXutil.strcmp(GXutil.rtrim( AV27GeneroFemenino), "F")==0) ? "F" : "S") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27GeneroFemenino", AV27GeneroFemenino);
      AV7AtencionVirtual = ((GXutil.strcmp(GXutil.rtrim( AV7AtencionVirtual), "V")==0) ? "V" : "N") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7AtencionVirtual", AV7AtencionVirtual);
      AV6AtencionPresencial = ((GXutil.strcmp(GXutil.rtrim( AV6AtencionPresencial), "P")==0) ? "P" : "N") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6AtencionPresencial", AV6AtencionPresencial);
      AV5AtencionDomicilio = ((GXutil.strcmp(GXutil.rtrim( AV5AtencionDomicilio), "D")==0) ? "D" : "N") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AtencionDomicilio", AV5AtencionDomicilio);
      if ( cmbavDepartamento.getItemCount() > 0 )
      {
         AV13Departamento = cmbavDepartamento.getValidValue(AV13Departamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Departamento", AV13Departamento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDepartamento.setValue( GXutil.rtrim( AV13Departamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDepartamento.getInternalname(), "Values", cmbavDepartamento.ToJavascriptSource(), true);
      }
      if ( dynavProvincia.getItemCount() > 0 )
      {
         AV53Provincia = dynavProvincia.getValidValue(AV53Provincia) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53Provincia", AV53Provincia);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProvincia.setValue( GXutil.rtrim( AV53Provincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavProvincia.getInternalname(), "Values", dynavProvincia.ToJavascriptSource(), true);
      }
      if ( dynavDistrito.getItemCount() > 0 )
      {
         AV18Distrito = dynavDistrito.getValidValue(AV18Distrito) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Distrito", AV18Distrito);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDistrito.setValue( GXutil.rtrim( AV18Distrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavDistrito.getInternalname(), "Values", dynavDistrito.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2W2( ) ;
      rf2W5( ) ;
      rf2W4( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavCtldescripcion1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldescripcion1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldescripcion1_Enabled), 5, 0), !bGXsfl_50_Refreshing);
      edtavCtlidprecio1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlidprecio1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlidprecio1_Enabled), 5, 0), !bGXsfl_50_Refreshing);
      edtavCtlespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidadnombre_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavCtlespecialidadid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidadid_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavCtlprofesionalid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprofesionalid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprofesionalid_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlapellidosnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidosnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidosnombres_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlespecialidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidad_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlcalificacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlcalificacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlcalificacion_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtldisponibilidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldisponibilidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldisponibilidad_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtltipocita_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtltipocita_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtltipocita_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlprecioconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprecioconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprecioconsulta_Enabled), 5, 0), !bGXsfl_163_Refreshing);
   }

   public void rf2W2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid5Container.ClearRows();
      }
      wbStart = (short)(50) ;
      nGXsfl_50_idx = 1 ;
      sGXsfl_50_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_50_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_502( ) ;
      bGXsfl_50_Refreshing = true ;
      Grid5Container.AddObjectProperty("GridName", "Grid5");
      Grid5Container.AddObjectProperty("CmpContext", "");
      Grid5Container.AddObjectProperty("InMasterPage", "false");
      Grid5Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Grid5Container.AddObjectProperty("Class", "FreeStyleGrid");
      Grid5Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid5Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid5Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid5_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid5Container.setPageSize( subgrid5_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_502( ) ;
         e192W2 ();
         wbEnd = (short)(50) ;
         wb2W0( ) ;
      }
      bGXsfl_50_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2W2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESPECIALIDADES", getSecureSignedToken( "", AV23Especialidades));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPRECIOS", AV52Precios);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPRECIOS", AV52Precios);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPRECIOS", getSecureSignedToken( "", AV52Precios));
   }

   public void rf2W4( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridlitadodoctoresContainer.ClearRows();
      }
      wbStart = (short)(163) ;
      nGXsfl_163_idx = 1 ;
      sGXsfl_163_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1634( ) ;
      bGXsfl_163_Refreshing = true ;
      GridlitadodoctoresContainer.AddObjectProperty("GridName", "Gridlitadodoctores");
      GridlitadodoctoresContainer.AddObjectProperty("CmpContext", "");
      GridlitadodoctoresContainer.AddObjectProperty("InMasterPage", "false");
      GridlitadodoctoresContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridlitadodoctoresContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridlitadodoctoresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridlitadodoctoresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridlitadodoctoresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlitadodoctores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridlitadodoctoresContainer.setPageSize( subgridlitadodoctores_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1634( ) ;
         e172W4 ();
         wbEnd = (short)(163) ;
         wb2W0( ) ;
      }
      bGXsfl_163_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2W4( )
   {
   }

   public void rf2W5( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid2Container.ClearRows();
      }
      wbStart = (short)(75) ;
      nGXsfl_75_idx = 1 ;
      sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_755( ) ;
      bGXsfl_75_Refreshing = true ;
      Grid2Container.AddObjectProperty("GridName", "Grid2");
      Grid2Container.AddObjectProperty("CmpContext", "");
      Grid2Container.AddObjectProperty("InMasterPage", "false");
      Grid2Container.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      Grid2Container.AddObjectProperty("Class", "FreeStyleGrid");
      Grid2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid2Container.setPageSize( subgrid2_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_755( ) ;
         e162W5 ();
         wbEnd = (short)(75) ;
         wb2W0( ) ;
      }
      bGXsfl_75_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2W5( )
   {
   }

   public int subgrid5_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid5_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgrid5_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgrid5_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridlitadodoctores_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridlitadodoctores_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridlitadodoctores_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridlitadodoctores_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgrid2_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavCtldescripcion1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldescripcion1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldescripcion1_Enabled), 5, 0), !bGXsfl_50_Refreshing);
      edtavCtlidprecio1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlidprecio1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlidprecio1_Enabled), 5, 0), !bGXsfl_50_Refreshing);
      edtavCtlespecialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidadnombre_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavCtlespecialidadid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidadid_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtavCtlprofesionalid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprofesionalid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprofesionalid_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlapellidosnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidosnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidosnombres_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlespecialidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlespecialidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlespecialidad_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlcalificacion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlcalificacion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlcalificacion_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldireccion_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtldisponibilidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtldisponibilidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtldisponibilidad_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtltipocita_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtltipocita_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtltipocita_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      edtavCtlprecioconsulta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlprecioconsulta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlprecioconsulta_Enabled), 5, 0), !bGXsfl_163_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2W0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e182W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvprovincia_html2W2( AV13Departamento) ;
      gxvvdistrito_html2W2( AV13Departamento, AV53Provincia) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Especialidades"), AV23Especialidades);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Doctores"), AV20Doctores);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Precios"), AV52Precios);
         /* Read saved values. */
         nRC_GXsfl_50 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_50"), ",", ".")) ;
         nRC_GXsfl_75 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_75"), ",", ".")) ;
         nRC_GXsfl_163 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_163"), ",", ".")) ;
         Gx_date = localUtil.ctod( httpContext.cgiGet( "vTODAY"), 0) ;
         AV25Fecha = localUtil.ctod( httpContext.cgiGet( "vFECHA"), 0) ;
         AV55TipoCita = httpContext.cgiGet( "vTIPOCITA") ;
         AV21EspeciadadId = (short)(localUtil.ctol( httpContext.cgiGet( "vESPECIADADID"), ",", ".")) ;
         nRC_GXsfl_50 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_50"), ",", ".")) ;
         nGXsfl_50_fel_idx = 0 ;
         while ( nGXsfl_50_fel_idx < nRC_GXsfl_50 )
         {
            nGXsfl_50_fel_idx = ((subGrid5_Islastpage==1)&&(nGXsfl_50_fel_idx+1>subgrid5_fnc_recordsperpage( )) ? 1 : nGXsfl_50_fel_idx+1) ;
            sGXsfl_50_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_50_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_502( ) ;
            AV62GXV1 = nGXsfl_50_fel_idx ;
            if ( ( AV52Precios.size() >= AV62GXV1 ) && ( AV62GXV1 > 0 ) )
            {
               AV52Precios.currentItem( ((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)) );
            }
         }
         if ( nGXsfl_50_fel_idx == 0 )
         {
            nGXsfl_50_idx = 1 ;
            sGXsfl_50_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_50_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_502( ) ;
         }
         nGXsfl_50_fel_idx = 1 ;
         nRC_GXsfl_75 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_75"), ",", ".")) ;
         nGXsfl_75_fel_idx = 0 ;
         while ( nGXsfl_75_fel_idx < nRC_GXsfl_75 )
         {
            nGXsfl_75_fel_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_75_fel_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_75_fel_idx+1) ;
            sGXsfl_75_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_755( ) ;
            AV66GXV5 = nGXsfl_75_fel_idx ;
            if ( ( AV23Especialidades.size() >= AV66GXV5 ) && ( AV66GXV5 > 0 ) )
            {
               AV23Especialidades.currentItem( ((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)) );
            }
         }
         if ( nGXsfl_75_fel_idx == 0 )
         {
            nGXsfl_75_idx = 1 ;
            sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_755( ) ;
         }
         nGXsfl_75_fel_idx = 1 ;
         nRC_GXsfl_163 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_163"), ",", ".")) ;
         nGXsfl_163_fel_idx = 0 ;
         while ( nGXsfl_163_fel_idx < nRC_GXsfl_163 )
         {
            nGXsfl_163_fel_idx = ((subGridlitadodoctores_Islastpage==1)&&(nGXsfl_163_fel_idx+1>subgridlitadodoctores_fnc_recordsperpage( )) ? 1 : nGXsfl_163_fel_idx+1) ;
            sGXsfl_163_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1634( ) ;
            AV70GXV9 = nGXsfl_163_fel_idx ;
            if ( ( AV20Doctores.size() >= AV70GXV9 ) && ( AV70GXV9 > 0 ) )
            {
               AV20Doctores.currentItem( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)) );
            }
         }
         if ( nGXsfl_163_fel_idx == 0 )
         {
            nGXsfl_163_idx = 1 ;
            sGXsfl_163_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1634( ) ;
         }
         nGXsfl_163_fel_idx = 1 ;
         /* Read variables values. */
         AV28GeneroMasculino = ((GXutil.strcmp(httpContext.cgiGet( chkavGeneromasculino.getInternalname()), "M")==0) ? "M" : "S") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV28GeneroMasculino", AV28GeneroMasculino);
         AV27GeneroFemenino = ((GXutil.strcmp(httpContext.cgiGet( chkavGenerofemenino.getInternalname()), "F")==0) ? "F" : "S") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GeneroFemenino", AV27GeneroFemenino);
         AV7AtencionVirtual = ((GXutil.strcmp(httpContext.cgiGet( chkavAtencionvirtual.getInternalname()), "V")==0) ? "V" : "N") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7AtencionVirtual", AV7AtencionVirtual);
         AV6AtencionPresencial = ((GXutil.strcmp(httpContext.cgiGet( chkavAtencionpresencial.getInternalname()), "P")==0) ? "P" : "N") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6AtencionPresencial", AV6AtencionPresencial);
         AV5AtencionDomicilio = ((GXutil.strcmp(httpContext.cgiGet( chkavAtenciondomicilio.getInternalname()), "D")==0) ? "D" : "N") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5AtencionDomicilio", AV5AtencionDomicilio);
         cmbavDepartamento.setName( cmbavDepartamento.getInternalname() );
         cmbavDepartamento.setValue( httpContext.cgiGet( cmbavDepartamento.getInternalname()) );
         AV13Departamento = httpContext.cgiGet( cmbavDepartamento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Departamento", AV13Departamento);
         dynavProvincia.setName( dynavProvincia.getInternalname() );
         dynavProvincia.setValue( httpContext.cgiGet( dynavProvincia.getInternalname()) );
         AV53Provincia = httpContext.cgiGet( dynavProvincia.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53Provincia", AV53Provincia);
         dynavDistrito.setName( dynavDistrito.getInternalname() );
         dynavDistrito.setValue( httpContext.cgiGet( dynavDistrito.getInternalname()) );
         AV18Distrito = httpContext.cgiGet( dynavDistrito.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Distrito", AV18Distrito);
         AV48NombresApellidosDoctor = httpContext.cgiGet( edtavNombresapellidosdoctor_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48NombresApellidosDoctor", AV48NombresApellidosDoctor);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e182W2 ();
      if (returnInSub) return;
   }

   public void e182W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/Doctores.css\">" );
      Form.getJscriptsrc().add("BuscadorOp.js") ;
      divTable7_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable7_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable7_Visible), 5, 0), true);
      divTable18_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable18_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable18_Visible), 5, 0), true);
      divTable12_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable12_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable12_Visible), 5, 0), true);
      divTable13_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable13_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable13_Visible), 5, 0), true);
      divTable14_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable14_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable14_Visible), 5, 0), true);
      divTable15_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable15_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable15_Visible), 5, 0), true);
      divTable16_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable16_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable16_Visible), 5, 0), true);
      divTable17_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTable17_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTable17_Visible), 5, 0), true);
      AV20Doctores = new GXBaseCollection<com.projectthani.SdtSDTDoctores>(com.projectthani.SdtSDTDoctores.class, "SDTDoctores", "ProjectThani", remoteHandle) ;
      gx_BV163 = true ;
      AV44htmlMensajeVisible += "<div class=\"alert alert-warning\" style=\"font-size:15px;\"role=\"alert\">No se encontro Medicos disponibles para la especialidad, el tipo de atencion y fecha seleccionada...!</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44htmlMensajeVisible", AV44htmlMensajeVisible);
      AV43htmlMensajeNoVisible += "<div class=\"alert alert-warning hidden\" style=\"font-size:15px;\"role=\"alert\">No se encontro Medicos disponibles para la especialidad, el tipo de atencion y fecha seleccionada...!</div>" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43htmlMensajeNoVisible", AV43htmlMensajeNoVisible);
      /* Execute user subroutine: 'ICON' */
      S112 ();
      if (returnInSub) return;
      if ( ( AV21EspeciadadId > 0 ) || ( GXutil.strcmp(AV55TipoCita, "V") == 0 ) || ( GXutil.strcmp(AV55TipoCita, "D") == 0 ) || ( GXutil.strcmp(AV55TipoCita, "P") == 0 ) && (( GXutil.resetTime(AV25Fecha).after( GXutil.resetTime( Gx_date )) ) || ( GXutil.dateCompare(GXutil.resetTime(AV25Fecha), GXutil.resetTime(Gx_date)) )) )
      {
         AV50OpListado = "FiltroHomePage" ;
         GXv_objcol_SdtSDTDoctores1[0] = AV20Doctores ;
         GXv_int2[0] = AV59NroItem ;
         new com.projectthani.prcmostrardoctoresporfiltro(remoteHandle, context).execute( AV50OpListado, AV21EspeciadadId, AV55TipoCita, AV25Fecha, "", "", "", "", "", "", AV23Especialidades, AV52Precios, "", "", "", GXv_objcol_SdtSDTDoctores1, GXv_int2) ;
         AV20Doctores = GXv_objcol_SdtSDTDoctores1[0] ;
         wpdoctores_impl.this.AV59NroItem = GXv_int2[0] ;
         gx_BV163 = true ;
      }
      else
      {
         AV50OpListado = "SinFiltros" ;
         GXv_objcol_SdtSDTDoctores1[0] = AV20Doctores ;
         GXv_int2[0] = AV59NroItem ;
         new com.projectthani.prcmostrardoctoresporfiltro(remoteHandle, context).execute( AV50OpListado, 0, "", Gx_date, "", "", "", "", "", "", AV23Especialidades, AV52Precios, "", "", "", GXv_objcol_SdtSDTDoctores1, GXv_int2) ;
         AV20Doctores = GXv_objcol_SdtSDTDoctores1[0] ;
         wpdoctores_impl.this.AV59NroItem = GXv_int2[0] ;
         gx_BV163 = true ;
      }
      /* Using cursor H002W4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A186UbigeoDepartamento = H002W4_A186UbigeoDepartamento[0] ;
         A295UbigeoDepartamentoCode = H002W4_A295UbigeoDepartamentoCode[0] ;
         A44UbigeoCode = H002W4_A44UbigeoCode[0] ;
         cmbavDepartamento.addItem(A295UbigeoDepartamentoCode, A186UbigeoDepartamento, (short)(0));
         pr_default.readNext(2);
      }
      pr_default.close(2);
      GXt_objcol_SdtSDTEspecialidad3 = AV23Especialidades ;
      GXv_objcol_SdtSDTEspecialidad4[0] = GXt_objcol_SdtSDTEspecialidad3 ;
      new com.projectthani.prcespecialidades(remoteHandle, context).execute( GXv_objcol_SdtSDTEspecialidad4) ;
      GXt_objcol_SdtSDTEspecialidad3 = GXv_objcol_SdtSDTEspecialidad4[0] ;
      AV23Especialidades = GXt_objcol_SdtSDTEspecialidad3 ;
      gx_BV75 = true ;
      GXt_objcol_SdtSDTRangoPrecios5 = AV52Precios ;
      GXv_objcol_SdtSDTRangoPrecios6[0] = GXt_objcol_SdtSDTRangoPrecios5 ;
      new com.projectthani.prcrangodeprecios(remoteHandle, context).execute( GXv_objcol_SdtSDTRangoPrecios6) ;
      GXt_objcol_SdtSDTRangoPrecios5 = GXv_objcol_SdtSDTRangoPrecios6[0] ;
      AV52Precios = GXt_objcol_SdtSDTRangoPrecios5 ;
      gx_BV50 = true ;
      /* Execute user subroutine: 'ICONBUSCADOR' */
      S122 ();
      if (returnInSub) return;
      this.executeExternalObjectMethod("", false, "AV49OpcionesBuscador", "showDepartamento", new Object[] {}, false);
      this.executeExternalObjectMethod("", false, "AV49OpcionesBuscador", "showGenero", new Object[] {}, false);
      this.executeExternalObjectMethod("", false, "AV49OpcionesBuscador", "showEspecialidades", new Object[] {}, false);
      this.executeExternalObjectMethod("", false, "AV49OpcionesBuscador", "showRangoPrecios", new Object[] {}, false);
      this.executeExternalObjectMethod("", false, "AV49OpcionesBuscador", "showTipoCita", new Object[] {}, false);
      this.executeExternalObjectMethod("", false, "AV49OpcionesBuscador", "showProvincia", new Object[] {}, false);
      this.executeExternalObjectMethod("", false, "AV49OpcionesBuscador", "showDistrito", new Object[] {}, false);
   }

   public void e122W2( )
   {
      AV70GXV9 = nGXsfl_163_idx ;
      if ( AV20Doctores.size() >= AV70GXV9 )
      {
         AV20Doctores.currentItem( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)) );
      }
      AV62GXV1 = nGXsfl_50_idx ;
      if ( AV52Precios.size() >= AV62GXV1 )
      {
         AV52Precios.currentItem( ((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)) );
      }
      AV66GXV5 = nGXsfl_75_idx ;
      if ( AV23Especialidades.size() >= AV66GXV5 )
      {
         AV23Especialidades.currentItem( ((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)) );
      }
      /* 'BuscarFiltroDoctor' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ICON' */
      S112 ();
      if (returnInSub) return;
      AV20Doctores.clear();
      gx_BV163 = true ;
      AV50OpListado = "FiltroGeneral" ;
      GXv_objcol_SdtSDTDoctores1[0] = AV20Doctores ;
      GXv_int2[0] = AV59NroItem ;
      new com.projectthani.prcmostrardoctoresporfiltro(remoteHandle, context).execute( AV50OpListado, 0, "", Gx_date, "", AV27GeneroFemenino, AV28GeneroMasculino, AV6AtencionPresencial, AV7AtencionVirtual, AV5AtencionDomicilio, AV23Especialidades, AV52Precios, AV13Departamento, AV53Provincia, AV18Distrito, GXv_objcol_SdtSDTDoctores1, GXv_int2) ;
      AV20Doctores = GXv_objcol_SdtSDTDoctores1[0] ;
      wpdoctores_impl.this.AV59NroItem = GXv_int2[0] ;
      gx_BV163 = true ;
      /*  Sending Event outputs  */
      if ( gx_BV163 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20Doctores", AV20Doctores);
         nGXsfl_163_bak_idx = nGXsfl_163_idx ;
         gxgrgridlitadodoctores_refresh( AV28GeneroMasculino, AV27GeneroFemenino, AV7AtencionVirtual, AV6AtencionPresencial, AV5AtencionDomicilio, AV23Especialidades, AV52Precios, Gx_date) ;
         nGXsfl_163_idx = nGXsfl_163_bak_idx ;
         sGXsfl_163_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1634( ) ;
      }
   }

   public void e142W2( )
   {
      AV70GXV9 = nGXsfl_163_idx ;
      if ( AV20Doctores.size() >= AV70GXV9 )
      {
         AV20Doctores.currentItem( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)) );
      }
      /* 'BtnVerPerfil' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wpprofesionalperfil", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.projectthani.SdtSDTDoctores)(AV20Doctores.currentItem())).getgxTv_SdtSDTDoctores_Profesionalid(),8,0))}, new String[] {"ProfesionalId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e152W2( )
   {
      AV70GXV9 = nGXsfl_163_idx ;
      if ( AV20Doctores.size() >= AV70GXV9 )
      {
         AV20Doctores.currentItem( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)) );
      }
      /* 'BtnAgendarCita' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wphorariodisponiblecitas", new String[] {GXutil.URLEncode(GXutil.ltrimstr(((com.projectthani.SdtSDTDoctores)(AV20Doctores.currentItem())).getgxTv_SdtSDTDoctores_Profesionalid(),8,0))}, new String[] {"ProfesionalId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void e132W2( )
   {
      AV70GXV9 = nGXsfl_163_idx ;
      if ( AV20Doctores.size() >= AV70GXV9 )
      {
         AV20Doctores.currentItem( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)) );
      }
      AV62GXV1 = nGXsfl_50_idx ;
      if ( AV52Precios.size() >= AV62GXV1 )
      {
         AV52Precios.currentItem( ((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)) );
      }
      AV66GXV5 = nGXsfl_75_idx ;
      if ( AV23Especialidades.size() >= AV66GXV5 )
      {
         AV23Especialidades.currentItem( ((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)) );
      }
      /* Nombresapellidosdoctor_Controlvaluechanging Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ICON' */
      S112 ();
      if (returnInSub) return;
      AV20Doctores.clear();
      gx_BV163 = true ;
      AV50OpListado = "FiltroNombresApellidos" ;
      GXv_objcol_SdtSDTDoctores1[0] = AV20Doctores ;
      GXv_int2[0] = AV59NroItem ;
      new com.projectthani.prcmostrardoctoresporfiltro(remoteHandle, context).execute( AV50OpListado, 0, "", Gx_date, AV48NombresApellidosDoctor, "", "", "", "", "", AV23Especialidades, AV52Precios, "", "", "", GXv_objcol_SdtSDTDoctores1, GXv_int2) ;
      AV20Doctores = GXv_objcol_SdtSDTDoctores1[0] ;
      wpdoctores_impl.this.AV59NroItem = GXv_int2[0] ;
      gx_BV163 = true ;
      /*  Sending Event outputs  */
      if ( gx_BV163 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV20Doctores", AV20Doctores);
         nGXsfl_163_bak_idx = nGXsfl_163_idx ;
         gxgrgridlitadodoctores_refresh( AV28GeneroMasculino, AV27GeneroFemenino, AV7AtencionVirtual, AV6AtencionPresencial, AV5AtencionDomicilio, AV23Especialidades, AV52Precios, Gx_date) ;
         nGXsfl_163_idx = nGXsfl_163_bak_idx ;
         sGXsfl_163_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1634( ) ;
      }
   }

   public void S112( )
   {
      /* 'ICON' Routine */
      returnInSub = false ;
      AV37HtmlIconDireccion = "<i class=\"fas fa-map-marker-alt\"></i>" ;
      lblTxbicondireccion_Caption = AV37HtmlIconDireccion ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxbicondireccion_Internalname, "Caption", lblTxbicondireccion_Caption, !bGXsfl_163_Refreshing);
      AV40HtmlIconPrecioConsulta = "<i class=\"far fa-money-bill-alt\"></i>" ;
      lblTxbiconprecioconsulta_Caption = AV40HtmlIconPrecioConsulta ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxbiconprecioconsulta_Internalname, "Caption", lblTxbiconprecioconsulta_Caption, !bGXsfl_163_Refreshing);
      AV41HtmlIconTipoConsulta = "<i class=\"fas fa-stethoscope\"></i>" ;
      lblTxbicontipocita_Caption = AV41HtmlIconTipoConsulta ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxbicontipocita_Internalname, "Caption", lblTxbicontipocita_Caption, !bGXsfl_163_Refreshing);
      AV38HtmlIconDisponible = "<i class=\"far fa-clock\"></i>" ;
      lblTxbicondisponible_Caption = AV38HtmlIconDisponible ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxbicondisponible_Internalname, "Caption", lblTxbicondisponible_Caption, !bGXsfl_163_Refreshing);
      AV39HtmlIconEspecialidad = "<i class=\"fas fa-briefcase-medical\"></i>" ;
      lblTxbiconespecialidad_Caption = AV39HtmlIconEspecialidad ;
      httpContext.ajax_rsp_assign_prop("", false, lblTxbiconespecialidad_Internalname, "Caption", lblTxbiconespecialidad_Caption, !bGXsfl_163_Refreshing);
   }

   public void S122( )
   {
      /* 'ICONBUSCADOR' Routine */
      returnInSub = false ;
      lblTextblocklimpiarfiltros_Caption = "<i class=\"fas fa-align-left\" style=\"font-size:16px;\"></i><font style=\"font-size:16px;font-weight:500;\"> Limpiar Filtros</font>" ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblocklimpiarfiltros_Internalname, "Caption", lblTextblocklimpiarfiltros_Caption, true);
      AV32HtmlAngleRight1 = "<i id=\"Angle\" class=\"fas fa-angle-right\" style=\"font-size: 20px;\"></i>" ;
      lblTextblockiconoflecha_Caption = AV32HtmlAngleRight1 ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockiconoflecha_Internalname, "Caption", lblTextblockiconoflecha_Caption, true);
      AV33HtmlAngleRight2 = "<i id=\"AngleA\" class=\"fas fa-angle-right\" style=\"font-size: 20px;\"></i>" ;
      lblTextblockatencionicon_Caption = AV33HtmlAngleRight2 ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockatencionicon_Internalname, "Caption", lblTextblockatencionicon_Caption, true);
      AV34HtmlAngleRight3 = "<i id=\"AngleE\" class=\"fas fa-angle-right\" style=\"font-size: 20px;\"></i>" ;
      lblTextblockespecialicon_Caption = AV34HtmlAngleRight3 ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockespecialicon_Internalname, "Caption", lblTextblockespecialicon_Caption, true);
      AV35HtmlAngleRight4 = "<i id=\"AngleRP\" class=\"fas fa-angle-right\" style=\"font-size: 20px;\"></i>" ;
      lblTextblockrangprecicon_Caption = AV35HtmlAngleRight4 ;
      httpContext.ajax_rsp_assign_prop("", false, lblTextblockrangprecicon_Internalname, "Caption", lblTextblockrangprecicon_Caption, true);
   }

   private void e192W2( )
   {
      /* Grid5_Load Routine */
      returnInSub = false ;
      AV62GXV1 = 1 ;
      while ( AV62GXV1 <= AV52Precios.size() )
      {
         AV52Precios.currentItem( ((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(50) ;
         }
         sendrow_502( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_50_Refreshing )
         {
            httpContext.doAjaxLoad(50, Grid5Row);
         }
         AV62GXV1 = (int)(AV62GXV1+1) ;
      }
   }

   private void e172W4( )
   {
      /* Gridlitadodoctores_Load Routine */
      returnInSub = false ;
      AV70GXV9 = 1 ;
      while ( AV70GXV9 <= AV20Doctores.size() )
      {
         AV20Doctores.currentItem( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(163) ;
         }
         sendrow_1634( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_163_Refreshing )
         {
            httpContext.doAjaxLoad(163, GridlitadodoctoresRow);
         }
         AV70GXV9 = (int)(AV70GXV9+1) ;
      }
   }

   private void e162W5( )
   {
      /* Grid2_Load Routine */
      returnInSub = false ;
      AV66GXV5 = 1 ;
      while ( AV66GXV5 <= AV23Especialidades.size() )
      {
         AV23Especialidades.currentItem( ((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(75) ;
         }
         sendrow_755( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_75_Refreshing )
         {
            httpContext.doAjaxLoad(75, Grid2Row);
         }
         AV66GXV5 = (int)(AV66GXV5+1) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV21EspeciadadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21EspeciadadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21EspeciadadId), 4, 0));
      AV55TipoCita = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55TipoCita", AV55TipoCita);
      AV25Fecha = (java.util.Date)getParm(obj,2) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25Fecha", localUtil.format(AV25Fecha, "99/99/99"));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa2W2( ) ;
      ws2W2( ) ;
      we2W2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVMessage/DVMessage.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110335050", true, true);
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
      httpContext.AddJavascriptSource("wpdoctores.js", "?20225110335050", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_502( )
   {
      chkavCtlestado1.setInternalname( "CTLESTADO1_"+sGXsfl_50_idx );
      edtavCtldescripcion1_Internalname = "CTLDESCRIPCION1_"+sGXsfl_50_idx ;
      edtavCtlidprecio1_Internalname = "CTLIDPRECIO1_"+sGXsfl_50_idx ;
   }

   public void subsflControlProps_fel_502( )
   {
      chkavCtlestado1.setInternalname( "CTLESTADO1_"+sGXsfl_50_fel_idx );
      edtavCtldescripcion1_Internalname = "CTLDESCRIPCION1_"+sGXsfl_50_fel_idx ;
      edtavCtlidprecio1_Internalname = "CTLIDPRECIO1_"+sGXsfl_50_fel_idx ;
   }

   public void sendrow_502( )
   {
      subsflControlProps_502( ) ;
      wb2W0( ) ;
      Grid5Row = GXWebRow.GetNew(context,Grid5Container) ;
      if ( subGrid5_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGrid5_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGrid5_Class, "") != 0 )
         {
            subGrid5_Linesclass = subGrid5_Class+"Odd" ;
         }
      }
      else if ( subGrid5_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGrid5_Backstyle = (byte)(0) ;
         subGrid5_Backcolor = subGrid5_Allbackcolor ;
         if ( GXutil.strcmp(subGrid5_Class, "") != 0 )
         {
            subGrid5_Linesclass = subGrid5_Class+"Uniform" ;
         }
      }
      else if ( subGrid5_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGrid5_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGrid5_Class, "") != 0 )
         {
            subGrid5_Linesclass = subGrid5_Class+"Odd" ;
         }
         subGrid5_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGrid5_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGrid5_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_50_idx) % (2))) == 0 )
         {
            subGrid5_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrid5_Class, "") != 0 )
            {
               subGrid5_Linesclass = subGrid5_Class+"Even" ;
            }
         }
         else
         {
            subGrid5_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGrid5_Class, "") != 0 )
            {
               subGrid5_Linesclass = subGrid5_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Grid5Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGrid5_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_50_idx+"\">") ;
      }
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid5table_Internalname+"_"+sGXsfl_50_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkavCtlestado1.getInternalname(),"Estado","col-sm-3 tbEspecialidadesCheckBoxLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Check box */
      TempTags = " " + ((chkavCtlestado1.getEnabled()!=0)&&(chkavCtlestado1.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 55,'',false,'"+sGXsfl_50_idx+"',50)\"" : " ") ;
      ClassString = "tbEspecialidadesCheckBox" ;
      StyleString = "" ;
      GXCCtl = "CTLESTADO1_" + sGXsfl_50_idx ;
      chkavCtlestado1.setName( GXCCtl );
      chkavCtlestado1.setWebtags( "" );
      chkavCtlestado1.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCtlestado1.getInternalname(), "TitleCaption", chkavCtlestado1.getCaption(), !bGXsfl_50_Refreshing);
      chkavCtlestado1.setCheckedValue( "false" );
      Grid5Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavCtlestado1.getInternalname(),GXutil.booltostr( ((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)).getgxTv_SdtSDTRangoPrecios_Estado()),"","Estado",Integer.valueOf(1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(55, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavCtlestado1.getEnabled()!=0)&&(chkavCtlestado1.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,55);\"" : " ")});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 tbEspecialidadesTitulo","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtldescripcion1_Internalname,"Descripcion","col-sm-3 ",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "" ;
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtldescripcion1_Internalname,((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)).getgxTv_SdtSDTRangoPrecios_Descripcion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtldescripcion1_Jsonclick,Integer.valueOf(0),"","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtldescripcion1_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlidprecio1_Internalname,"id Precio","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlidprecio1_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)).getgxTv_SdtSDTRangoPrecios_Idprecio(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlidprecio1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)).getgxTv_SdtSDTRangoPrecios_Idprecio()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTRangoPrecios)AV52Precios.elementAt(-1+AV62GXV1)).getgxTv_SdtSDTRangoPrecios_Idprecio()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlidprecio1_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlidprecio1_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(50),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes2W2( ) ;
      /* End of Columns property logic. */
      Grid5Container.AddRow(Grid5Row);
      nGXsfl_50_idx = ((subGrid5_Islastpage==1)&&(nGXsfl_50_idx+1>subgrid5_fnc_recordsperpage( )) ? 1 : nGXsfl_50_idx+1) ;
      sGXsfl_50_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_50_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_502( ) ;
      /* End function sendrow_502 */
   }

   public void subsflControlProps_755( )
   {
      chkavCtlespecialidadcheck.setInternalname( "CTLESPECIALIDADCHECK_"+sGXsfl_75_idx );
      edtavCtlespecialidadnombre_Internalname = "CTLESPECIALIDADNOMBRE_"+sGXsfl_75_idx ;
      edtavCtlespecialidadid_Internalname = "CTLESPECIALIDADID_"+sGXsfl_75_idx ;
   }

   public void subsflControlProps_fel_755( )
   {
      chkavCtlespecialidadcheck.setInternalname( "CTLESPECIALIDADCHECK_"+sGXsfl_75_fel_idx );
      edtavCtlespecialidadnombre_Internalname = "CTLESPECIALIDADNOMBRE_"+sGXsfl_75_fel_idx ;
      edtavCtlespecialidadid_Internalname = "CTLESPECIALIDADID_"+sGXsfl_75_fel_idx ;
   }

   public void sendrow_755( )
   {
      subsflControlProps_755( ) ;
      wb2W0( ) ;
      Grid2Row = GXWebRow.GetNew(context,Grid2Container) ;
      if ( subGrid2_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGrid2_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
         {
            subGrid2_Linesclass = subGrid2_Class+"Odd" ;
         }
      }
      else if ( subGrid2_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGrid2_Backstyle = (byte)(0) ;
         subGrid2_Backcolor = subGrid2_Allbackcolor ;
         if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
         {
            subGrid2_Linesclass = subGrid2_Class+"Uniform" ;
         }
      }
      else if ( subGrid2_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGrid2_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
         {
            subGrid2_Linesclass = subGrid2_Class+"Odd" ;
         }
         subGrid2_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGrid2_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGrid2_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_75_idx) % (2))) == 0 )
         {
            subGrid2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Even" ;
            }
         }
         else
         {
            subGrid2_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGrid2_Class, "") != 0 )
            {
               subGrid2_Linesclass = subGrid2_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( Grid2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGrid2_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_75_idx+"\">") ;
      }
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid2table_Internalname+"_"+sGXsfl_75_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {chkavCtlespecialidadcheck.getInternalname(),"Especialidad Check","col-sm-3 tbEspecialidadesCheckBoxLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Check box */
      TempTags = " " + ((chkavCtlespecialidadcheck.getEnabled()!=0)&&(chkavCtlespecialidadcheck.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 80,'',false,'"+sGXsfl_75_idx+"',75)\"" : " ") ;
      ClassString = "tbEspecialidadesCheckBox" ;
      StyleString = "" ;
      GXCCtl = "CTLESPECIALIDADCHECK_" + sGXsfl_75_idx ;
      chkavCtlespecialidadcheck.setName( GXCCtl );
      chkavCtlespecialidadcheck.setWebtags( "" );
      chkavCtlespecialidadcheck.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCtlespecialidadcheck.getInternalname(), "TitleCaption", chkavCtlespecialidadcheck.getCaption(), !bGXsfl_75_Refreshing);
      chkavCtlespecialidadcheck.setCheckedValue( "false" );
      Grid2Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkavCtlespecialidadcheck.getInternalname(),GXutil.booltostr( ((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)).getgxTv_SdtSDTEspecialidad_Especialidadcheck()),"","Especialidad Check",Integer.valueOf(1),Integer.valueOf(1),"true","",StyleString,ClassString,"","",TempTags+" onclick="+"\"gx.fn.checkboxClick(80, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+((chkavCtlespecialidadcheck.getEnabled()!=0)&&(chkavCtlespecialidadcheck.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,80);\"" : " ")});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 tbEspecialidadesTitulo","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidadnombre_Internalname,"Especialidad Nombre","col-sm-3 ",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "" ;
      Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidadnombre_Internalname,((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)).getgxTv_SdtSDTEspecialidad_Especialidadnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlespecialidadnombre_Jsonclick,Integer.valueOf(0),"","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlespecialidadnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      Grid2Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid2Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidadid_Internalname,"Especialidad Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidadid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)).getgxTv_SdtSDTEspecialidad_Especialidadid(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlespecialidadid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)).getgxTv_SdtSDTEspecialidad_Especialidadid()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTEspecialidad)AV23Especialidades.elementAt(-1+AV66GXV5)).getgxTv_SdtSDTEspecialidad_Especialidadid()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlespecialidadid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlespecialidadid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid2Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes2W5( ) ;
      /* End of Columns property logic. */
      Grid2Container.AddRow(Grid2Row);
      nGXsfl_75_idx = ((subGrid2_Islastpage==1)&&(nGXsfl_75_idx+1>subgrid2_fnc_recordsperpage( )) ? 1 : nGXsfl_75_idx+1) ;
      sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_755( ) ;
      /* End function sendrow_755 */
   }

   public void subsflControlProps_1634( )
   {
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA_"+sGXsfl_163_idx ;
      edtavCtlprofesionalid_Internalname = "CTLPROFESIONALID_"+sGXsfl_163_idx ;
      edtavCtlapellidosnombres_Internalname = "CTLAPELLIDOSNOMBRES_"+sGXsfl_163_idx ;
      lblTxbiconespecialidad_Internalname = "TXBICONESPECIALIDAD_"+sGXsfl_163_idx ;
      edtavCtlespecialidad_Internalname = "CTLESPECIALIDAD_"+sGXsfl_163_idx ;
      edtavCtlcalificacion_Internalname = "CTLCALIFICACION_"+sGXsfl_163_idx ;
      lblTxbicondireccion_Internalname = "TXBICONDIRECCION_"+sGXsfl_163_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_163_idx ;
      lblTxbicondisponible_Internalname = "TXBICONDISPONIBLE_"+sGXsfl_163_idx ;
      lblTextblock6_Internalname = "TEXTBLOCK6_"+sGXsfl_163_idx ;
      edtavCtldisponibilidad_Internalname = "CTLDISPONIBILIDAD_"+sGXsfl_163_idx ;
      lblTxbicontipocita_Internalname = "TXBICONTIPOCITA_"+sGXsfl_163_idx ;
      edtavCtltipocita_Internalname = "CTLTIPOCITA_"+sGXsfl_163_idx ;
      lblTxbiconprecioconsulta_Internalname = "TXBICONPRECIOCONSULTA_"+sGXsfl_163_idx ;
      edtavCtlprecioconsulta_Internalname = "CTLPRECIOCONSULTA_"+sGXsfl_163_idx ;
   }

   public void subsflControlProps_fel_1634( )
   {
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA_"+sGXsfl_163_fel_idx ;
      edtavCtlprofesionalid_Internalname = "CTLPROFESIONALID_"+sGXsfl_163_fel_idx ;
      edtavCtlapellidosnombres_Internalname = "CTLAPELLIDOSNOMBRES_"+sGXsfl_163_fel_idx ;
      lblTxbiconespecialidad_Internalname = "TXBICONESPECIALIDAD_"+sGXsfl_163_fel_idx ;
      edtavCtlespecialidad_Internalname = "CTLESPECIALIDAD_"+sGXsfl_163_fel_idx ;
      edtavCtlcalificacion_Internalname = "CTLCALIFICACION_"+sGXsfl_163_fel_idx ;
      lblTxbicondireccion_Internalname = "TXBICONDIRECCION_"+sGXsfl_163_fel_idx ;
      edtavCtldireccion_Internalname = "CTLDIRECCION_"+sGXsfl_163_fel_idx ;
      lblTxbicondisponible_Internalname = "TXBICONDISPONIBLE_"+sGXsfl_163_fel_idx ;
      lblTextblock6_Internalname = "TEXTBLOCK6_"+sGXsfl_163_fel_idx ;
      edtavCtldisponibilidad_Internalname = "CTLDISPONIBILIDAD_"+sGXsfl_163_fel_idx ;
      lblTxbicontipocita_Internalname = "TXBICONTIPOCITA_"+sGXsfl_163_fel_idx ;
      edtavCtltipocita_Internalname = "CTLTIPOCITA_"+sGXsfl_163_fel_idx ;
      lblTxbiconprecioconsulta_Internalname = "TXBICONPRECIOCONSULTA_"+sGXsfl_163_fel_idx ;
      edtavCtlprecioconsulta_Internalname = "CTLPRECIOCONSULTA_"+sGXsfl_163_fel_idx ;
   }

   public void sendrow_1634( )
   {
      subsflControlProps_1634( ) ;
      wb2W0( ) ;
      GridlitadodoctoresRow = GXWebRow.GetNew(context,GridlitadodoctoresContainer) ;
      if ( subGridlitadodoctores_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlitadodoctores_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlitadodoctores_Class, "") != 0 )
         {
            subGridlitadodoctores_Linesclass = subGridlitadodoctores_Class+"Odd" ;
         }
      }
      else if ( subGridlitadodoctores_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlitadodoctores_Backstyle = (byte)(0) ;
         subGridlitadodoctores_Backcolor = subGridlitadodoctores_Allbackcolor ;
         if ( GXutil.strcmp(subGridlitadodoctores_Class, "") != 0 )
         {
            subGridlitadodoctores_Linesclass = subGridlitadodoctores_Class+"Uniform" ;
         }
      }
      else if ( subGridlitadodoctores_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlitadodoctores_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlitadodoctores_Class, "") != 0 )
         {
            subGridlitadodoctores_Linesclass = subGridlitadodoctores_Class+"Odd" ;
         }
         subGridlitadodoctores_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridlitadodoctores_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlitadodoctores_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_163_idx) % (2))) == 0 )
         {
            subGridlitadodoctores_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlitadodoctores_Class, "") != 0 )
            {
               subGridlitadodoctores_Linesclass = subGridlitadodoctores_Class+"Even" ;
            }
         }
         else
         {
            subGridlitadodoctores_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridlitadodoctores_Class, "") != 0 )
            {
               subGridlitadodoctores_Linesclass = subGridlitadodoctores_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridlitadodoctoresContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridlitadodoctores_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_163_idx+"\">") ;
      }
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid3table_Internalname+"_"+sGXsfl_163_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableGridDoctoresBorder","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable20_Internalname+"_"+sGXsfl_163_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableGridDoctores","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable1_Internalname+"_"+sGXsfl_163_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"","Fotografia","col-sm-3 imgFotografiaPersonalLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Static Bitmap Variable */
      ClassString = "imgFotografiaPersonal" ;
      StyleString = "" ;
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Fotografia()) ;
      GridlitadodoctoresRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavCtlfotografia_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(3),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable3_Internalname+"_"+sGXsfl_163_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlprofesionalid_Internalname,"Profesional Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridlitadodoctoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlprofesionalid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Profesionalid(), (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlprofesionalid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Profesionalid()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Profesionalid()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlprofesionalid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlprofesionalid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(163),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row txbNombreDoctor","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlapellidosnombres_Internalname,"Apellidos Nombres","col-sm-3 AttNombreDoctorLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttNombreDoctor" ;
      GridlitadodoctoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlapellidosnombres_Internalname,((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Apellidosnombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlapellidosnombres_Jsonclick,Integer.valueOf(0),"AttNombreDoctor","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlapellidosnombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(163),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2 txbIconosDoctor","left","top","","","div"});
      /* Text block */
      GridlitadodoctoresRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTxbiconespecialidad_Internalname,lblTxbiconespecialidad_Caption,"","",lblTxbiconespecialidad_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 txbDoctorDescripcion","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidad_Internalname,"Especialidad","col-sm-3 AttDoctorDescripcionLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttDoctorDescripcion" ;
      GridlitadodoctoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlespecialidad_Internalname,((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Especialidad(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlespecialidad_Jsonclick,Integer.valueOf(0),"AttDoctorDescripcion","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlespecialidad_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(163),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_163430( ) ;
   }

   public void sendrow_163430( )
   {
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlcalificacion_Internalname,"Calificacion","col-sm-3 AttDoctorDescripcionLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "AttDoctorDescripcion" ;
      StyleString = "" ;
      ClassString = "AttDoctorDescripcion" ;
      StyleString = "" ;
      GridlitadodoctoresRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlcalificacion_Internalname,((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Calificacion(),"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(edtavCtlcalificacion_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","2097152",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2 txbIconosDoctor","left","top","","","div"});
      /* Text block */
      GridlitadodoctoresRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTxbicondireccion_Internalname,lblTxbicondireccion_Caption,"","",lblTxbicondireccion_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 txbDoctorDescripcion","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,"Direccion","col-sm-3 AttDoctorDescripcionLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttDoctorDescripcion" ;
      GridlitadodoctoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtldireccion_Internalname,((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Direccion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtldireccion_Jsonclick,Integer.valueOf(0),"AttDoctorDescripcion","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtldireccion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(163),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2 txbIconosDoctor","left","top","","","div"});
      /* Text block */
      GridlitadodoctoresRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTxbicondisponible_Internalname,lblTxbicondisponible_Caption,"","",lblTxbicondisponible_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-5 txbDoctorDescripcion","left","top","","","div"});
      /* Text block */
      GridlitadodoctoresRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblock6_Internalname,"Disponible el ","","",lblTextblock6_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","txbDisponibleEl",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-5 txbDoctorDescripcion","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtldisponibilidad_Internalname,"Disponibilidad","col-sm-3 AttFechaDoctorLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttFechaDoctor" ;
      GridlitadodoctoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtldisponibilidad_Internalname,localUtil.format(((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Disponibilidad(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Disponibilidad(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtldisponibilidad_Jsonclick,Integer.valueOf(0),"AttFechaDoctor","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtldisponibilidad_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(163),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2 txbIconosDoctor","left","top","","","div"});
      /* Text block */
      GridlitadodoctoresRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTxbicontipocita_Internalname,lblTxbicontipocita_Caption,"","",lblTxbicontipocita_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 txbDoctorDescripcion","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtltipocita_Internalname,"Tipo Cita","col-sm-3 AttDoctorDescripcionLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttDoctorDescripcion" ;
      GridlitadodoctoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtltipocita_Internalname,((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Tipocita(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtltipocita_Jsonclick,Integer.valueOf(0),"AttDoctorDescripcion","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtltipocita_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(163),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-2 txbIconosDoctor","left","top","","","div"});
      /* Text block */
      GridlitadodoctoresRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTxbiconprecioconsulta_Internalname,lblTxbiconprecioconsulta_Caption,"","",lblTxbiconprecioconsulta_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(2)});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-10 txbDoctorDescripcion","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridlitadodoctoresRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlprecioconsulta_Internalname,"Precio Consulta","col-sm-3 AttributePrecioLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "AttributePrecio" ;
      GridlitadodoctoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlprecioconsulta_Internalname,((com.projectthani.SdtSDTDoctores)AV20Doctores.elementAt(-1+AV70GXV9)).getgxTv_SdtSDTDoctores_Precioconsulta(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlprecioconsulta_Jsonclick,Integer.valueOf(0),"AttributePrecio","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlprecioconsulta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(50),"chr",Integer.valueOf(1),"row",Integer.valueOf(50),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(163),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable2_Internalname+"_"+sGXsfl_163_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","tbButton","left","top","","","div"});
      sendrow_163460( ) ;
   }

   public void sendrow_163460( )
   {
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-6","left","top","","","div"});
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 227,'',false,'',0)\"" ;
      ClassString = "btnDoctoresCita" ;
      StyleString = "" ;
      GridlitadodoctoresRow.AddColumnProperties("button", 2, isAjaxCallMode( ), new Object[] {bttBtnverperfil_Internalname+"_"+sGXsfl_163_idx,"gx.evt.setGridEvt("+GXutil.str( 163, 3, 0)+","+"null"+");","Ver perfil",bttBtnverperfil_Jsonclick,Integer.valueOf(5),"Ver perfil","",StyleString,ClassString,Integer.valueOf(1),Integer.valueOf(1),"standard","'"+""+"'"+",false,"+"'"+"E\\'BTNVERPERFIL\\'."+"'",TempTags,"",httpContext.getButtonType( )});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridlitadodoctoresRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-6","left","top","","","div"});
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 229,'',false,'',0)\"" ;
      ClassString = "btnDoctoresAgendarCita" ;
      StyleString = "" ;
      GridlitadodoctoresRow.AddColumnProperties("button", 2, isAjaxCallMode( ), new Object[] {bttBtnagendarcita_Internalname+"_"+sGXsfl_163_idx,"gx.evt.setGridEvt("+GXutil.str( 163, 3, 0)+","+"null"+");","Agendar cita",bttBtnagendarcita_Jsonclick,Integer.valueOf(5),"Agendar cita","",StyleString,ClassString,Integer.valueOf(1),Integer.valueOf(1),"standard","'"+""+"'"+",false,"+"'"+"E\\'BTNAGENDARCITA\\'."+"'",TempTags,"",httpContext.getButtonType( )});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridlitadodoctoresRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes2W4( ) ;
      /* End of Columns property logic. */
      GridlitadodoctoresContainer.AddRow(GridlitadodoctoresRow);
      nGXsfl_163_idx = ((subGridlitadodoctores_Islastpage==1)&&(nGXsfl_163_idx+1>subgridlitadodoctores_fnc_recordsperpage( )) ? 1 : nGXsfl_163_idx+1) ;
      sGXsfl_163_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_163_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1634( ) ;
      /* End function sendrow_1634 */
   }

   public void init_default_properties( )
   {
      lblTextblock_Internalname = "TEXTBLOCK" ;
      lblTextblocklimpiarfiltros_Internalname = "TEXTBLOCKLIMPIARFILTROS" ;
      divTable10_Internalname = "TABLE10" ;
      lblTextblockgenero_Internalname = "TEXTBLOCKGENERO" ;
      lblTextblockiconoflecha_Internalname = "TEXTBLOCKICONOFLECHA" ;
      divTable5_Internalname = "TABLE5" ;
      chkavGeneromasculino.setInternalname( "vGENEROMASCULINO" );
      chkavGenerofemenino.setInternalname( "vGENEROFEMENINO" );
      divTable6_Internalname = "TABLE6" ;
      lblTbrangoprecios_Internalname = "TBRANGOPRECIOS" ;
      lblTextblockrangprecicon_Internalname = "TEXTBLOCKRANGPRECICON" ;
      divTable7_Internalname = "TABLE7" ;
      chkavCtlestado1.setInternalname( "CTLESTADO1" );
      edtavCtldescripcion1_Internalname = "CTLDESCRIPCION1" ;
      edtavCtlidprecio1_Internalname = "CTLIDPRECIO1" ;
      divGrid5table_Internalname = "GRID5TABLE" ;
      divTable18_Internalname = "TABLE18" ;
      lblTbespecialidades_Internalname = "TBESPECIALIDADES" ;
      lblTextblockespecialicon_Internalname = "TEXTBLOCKESPECIALICON" ;
      divTable8_Internalname = "TABLE8" ;
      chkavCtlespecialidadcheck.setInternalname( "CTLESPECIALIDADCHECK" );
      edtavCtlespecialidadnombre_Internalname = "CTLESPECIALIDADNOMBRE" ;
      edtavCtlespecialidadid_Internalname = "CTLESPECIALIDADID" ;
      divGrid2table_Internalname = "GRID2TABLE" ;
      divTable19_Internalname = "TABLE19" ;
      lblTbtipoatencion_Internalname = "TBTIPOATENCION" ;
      lblTextblockatencionicon_Internalname = "TEXTBLOCKATENCIONICON" ;
      divTable9_Internalname = "TABLE9" ;
      chkavAtencionvirtual.setInternalname( "vATENCIONVIRTUAL" );
      chkavAtencionpresencial.setInternalname( "vATENCIONPRESENCIAL" );
      chkavAtenciondomicilio.setInternalname( "vATENCIONDOMICILIO" );
      divTable11_Internalname = "TABLE11" ;
      lblTbdepartamento_Internalname = "TBDEPARTAMENTO" ;
      divTable12_Internalname = "TABLE12" ;
      cmbavDepartamento.setInternalname( "vDEPARTAMENTO" );
      divTable13_Internalname = "TABLE13" ;
      lblTbprovincia_Internalname = "TBPROVINCIA" ;
      divTable14_Internalname = "TABLE14" ;
      dynavProvincia.setInternalname( "vPROVINCIA" );
      divTable17_Internalname = "TABLE17" ;
      lblTbdistrito_Internalname = "TBDISTRITO" ;
      divTable16_Internalname = "TABLE16" ;
      dynavDistrito.setInternalname( "vDISTRITO" );
      divTable15_Internalname = "TABLE15" ;
      bttBuscarfiltrodoctor_Internalname = "BUSCARFILTRODOCTOR" ;
      divTablefiltromedicos_Internalname = "TABLEFILTROMEDICOS" ;
      edtavNombresapellidosdoctor_Internalname = "vNOMBRESAPELLIDOSDOCTOR" ;
      divTable4_Internalname = "TABLE4" ;
      edtavCtlfotografia_Internalname = "CTLFOTOGRAFIA" ;
      divTable1_Internalname = "TABLE1" ;
      edtavCtlprofesionalid_Internalname = "CTLPROFESIONALID" ;
      edtavCtlapellidosnombres_Internalname = "CTLAPELLIDOSNOMBRES" ;
      lblTxbiconespecialidad_Internalname = "TXBICONESPECIALIDAD" ;
      edtavCtlespecialidad_Internalname = "CTLESPECIALIDAD" ;
      edtavCtlcalificacion_Internalname = "CTLCALIFICACION" ;
      lblTxbicondireccion_Internalname = "TXBICONDIRECCION" ;
      edtavCtldireccion_Internalname = "CTLDIRECCION" ;
      lblTxbicondisponible_Internalname = "TXBICONDISPONIBLE" ;
      lblTextblock6_Internalname = "TEXTBLOCK6" ;
      edtavCtldisponibilidad_Internalname = "CTLDISPONIBILIDAD" ;
      lblTxbicontipocita_Internalname = "TXBICONTIPOCITA" ;
      edtavCtltipocita_Internalname = "CTLTIPOCITA" ;
      lblTxbiconprecioconsulta_Internalname = "TXBICONPRECIOCONSULTA" ;
      edtavCtlprecioconsulta_Internalname = "CTLPRECIOCONSULTA" ;
      divTable3_Internalname = "TABLE3" ;
      bttBtnverperfil_Internalname = "BTNVERPERFIL" ;
      bttBtnagendarcita_Internalname = "BTNAGENDARCITA" ;
      divTable2_Internalname = "TABLE2" ;
      divTable20_Internalname = "TABLE20" ;
      divGrid3table_Internalname = "GRID3TABLE" ;
      divTablelistadodoctores_Internalname = "TABLELISTADODOCTORES" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid5_Internalname = "GRID5" ;
      subGrid2_Internalname = "GRID2" ;
      subGridlitadodoctores_Internalname = "GRIDLITADODOCTORES" ;
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
      edtavCtlprecioconsulta_Jsonclick = "" ;
      edtavCtltipocita_Jsonclick = "" ;
      edtavCtldisponibilidad_Jsonclick = "" ;
      edtavCtldireccion_Jsonclick = "" ;
      edtavCtlespecialidad_Jsonclick = "" ;
      edtavCtlapellidosnombres_Jsonclick = "" ;
      edtavCtlprofesionalid_Jsonclick = "" ;
      subGridlitadodoctores_Class = "FreeStyleGrid" ;
      edtavCtlespecialidadid_Jsonclick = "" ;
      edtavCtlespecialidadnombre_Jsonclick = "" ;
      chkavCtlespecialidadcheck.setCaption( "Especialidad Check" );
      chkavCtlespecialidadcheck.setVisible( 1 );
      chkavCtlespecialidadcheck.setEnabled( 1 );
      subGrid2_Class = "FreeStyleGrid" ;
      edtavCtlidprecio1_Jsonclick = "" ;
      edtavCtldescripcion1_Jsonclick = "" ;
      chkavCtlestado1.setCaption( "Estado" );
      chkavCtlestado1.setVisible( 1 );
      chkavCtlestado1.setEnabled( 1 );
      subGrid5_Class = "FreeStyleGrid" ;
      lblTxbiconespecialidad_Caption = "txbIconEspecialidad" ;
      lblTxbicondisponible_Caption = "txbIconDisponible" ;
      lblTxbicontipocita_Caption = "txbIconTipoCita" ;
      lblTxbiconprecioconsulta_Caption = "txbIconPrecioConsulta" ;
      lblTxbicondireccion_Caption = "Text Block" ;
      edtavCtlprecioconsulta_Enabled = -1 ;
      edtavCtltipocita_Enabled = -1 ;
      edtavCtldisponibilidad_Enabled = -1 ;
      edtavCtldireccion_Enabled = -1 ;
      edtavCtlcalificacion_Enabled = -1 ;
      edtavCtlespecialidad_Enabled = -1 ;
      edtavCtlapellidosnombres_Enabled = -1 ;
      edtavCtlprofesionalid_Enabled = -1 ;
      edtavCtlespecialidadid_Enabled = -1 ;
      edtavCtlespecialidadnombre_Enabled = -1 ;
      edtavCtlidprecio1_Enabled = -1 ;
      edtavCtldescripcion1_Enabled = -1 ;
      subGridlitadodoctores_Allowcollapsing = (byte)(0) ;
      edtavCtlprecioconsulta_Enabled = 0 ;
      lblTxbiconprecioconsulta_Caption = "txbIconPrecioConsulta" ;
      edtavCtltipocita_Enabled = 0 ;
      lblTxbicontipocita_Caption = "txbIconTipoCita" ;
      edtavCtldisponibilidad_Enabled = 0 ;
      lblTextblock6_Caption = "Disponible el " ;
      lblTxbicondisponible_Caption = "txbIconDisponible" ;
      edtavCtldireccion_Enabled = 0 ;
      lblTextblocklimpiarfiltros_Caption = "Text Block" ;
      edtavCtlcalificacion_Enabled = 0 ;
      edtavCtlespecialidad_Enabled = 0 ;
      lblTxbiconespecialidad_Caption = "txbIconEspecialidad" ;
      edtavCtlapellidosnombres_Enabled = 0 ;
      edtavCtlprofesionalid_Enabled = 0 ;
      subGridlitadodoctores_Backcolorstyle = (byte)(0) ;
      edtavNombresapellidosdoctor_Jsonclick = "" ;
      edtavNombresapellidosdoctor_Enabled = 1 ;
      dynavDistrito.setJsonclick( "" );
      dynavDistrito.setEnabled( 1 );
      divTable15_Visible = 1 ;
      divTable16_Visible = 1 ;
      dynavProvincia.setJsonclick( "" );
      dynavProvincia.setEnabled( 1 );
      divTable17_Visible = 1 ;
      divTable14_Visible = 1 ;
      cmbavDepartamento.setJsonclick( "" );
      cmbavDepartamento.setEnabled( 1 );
      divTable13_Visible = 1 ;
      divTable12_Visible = 1 ;
      chkavAtenciondomicilio.setEnabled( 1 );
      chkavAtencionpresencial.setEnabled( 1 );
      chkavAtencionvirtual.setEnabled( 1 );
      lblTextblockatencionicon_Caption = "Text Block" ;
      subGrid2_Allowcollapsing = (byte)(0) ;
      edtavCtlespecialidadid_Enabled = 0 ;
      edtavCtlespecialidadnombre_Enabled = 0 ;
      subGrid2_Backcolorstyle = (byte)(0) ;
      lblTextblockespecialicon_Caption = "Text Block" ;
      subGrid5_Allowcollapsing = (byte)(0) ;
      edtavCtlidprecio1_Enabled = 0 ;
      edtavCtldescripcion1_Enabled = 0 ;
      subGrid5_Backcolorstyle = (byte)(0) ;
      divTable18_Visible = 1 ;
      lblTextblockrangprecicon_Caption = "Text Block" ;
      divTable7_Visible = 1 ;
      chkavGenerofemenino.setEnabled( 1 );
      chkavGeneromasculino.setEnabled( 1 );
      lblTextblockiconoflecha_Caption = "Text Block" ;
      lblTextblocklimpiarfiltros_Link = "" ;
      lblTextblocklimpiarfiltros_Caption = "Text Block" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Buscar Médico" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      chkavGeneromasculino.setName( "vGENEROMASCULINO" );
      chkavGeneromasculino.setWebtags( "" );
      chkavGeneromasculino.setCaption( "Masculino" );
      httpContext.ajax_rsp_assign_prop("", false, chkavGeneromasculino.getInternalname(), "TitleCaption", chkavGeneromasculino.getCaption(), true);
      chkavGeneromasculino.setCheckedValue( "S" );
      AV28GeneroMasculino = ((GXutil.strcmp(GXutil.rtrim( AV28GeneroMasculino), "M")==0) ? "M" : "S") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28GeneroMasculino", AV28GeneroMasculino);
      chkavGenerofemenino.setName( "vGENEROFEMENINO" );
      chkavGenerofemenino.setWebtags( "" );
      chkavGenerofemenino.setCaption( "Femenino" );
      httpContext.ajax_rsp_assign_prop("", false, chkavGenerofemenino.getInternalname(), "TitleCaption", chkavGenerofemenino.getCaption(), true);
      chkavGenerofemenino.setCheckedValue( "S" );
      AV27GeneroFemenino = ((GXutil.strcmp(GXutil.rtrim( AV27GeneroFemenino), "F")==0) ? "F" : "S") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27GeneroFemenino", AV27GeneroFemenino);
      GXCCtl = "CTLESTADO1_" + sGXsfl_50_idx ;
      chkavCtlestado1.setName( GXCCtl );
      chkavCtlestado1.setWebtags( "" );
      chkavCtlestado1.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCtlestado1.getInternalname(), "TitleCaption", chkavCtlestado1.getCaption(), !bGXsfl_50_Refreshing);
      chkavCtlestado1.setCheckedValue( "false" );
      GXCCtl = "CTLESPECIALIDADCHECK_" + sGXsfl_75_idx ;
      chkavCtlespecialidadcheck.setName( GXCCtl );
      chkavCtlespecialidadcheck.setWebtags( "" );
      chkavCtlespecialidadcheck.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavCtlespecialidadcheck.getInternalname(), "TitleCaption", chkavCtlespecialidadcheck.getCaption(), !bGXsfl_75_Refreshing);
      chkavCtlespecialidadcheck.setCheckedValue( "false" );
      chkavAtencionvirtual.setName( "vATENCIONVIRTUAL" );
      chkavAtencionvirtual.setWebtags( "" );
      chkavAtencionvirtual.setCaption( "Virtual" );
      httpContext.ajax_rsp_assign_prop("", false, chkavAtencionvirtual.getInternalname(), "TitleCaption", chkavAtencionvirtual.getCaption(), true);
      chkavAtencionvirtual.setCheckedValue( "N" );
      AV7AtencionVirtual = ((GXutil.strcmp(GXutil.rtrim( AV7AtencionVirtual), "V")==0) ? "V" : "N") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7AtencionVirtual", AV7AtencionVirtual);
      chkavAtencionpresencial.setName( "vATENCIONPRESENCIAL" );
      chkavAtencionpresencial.setWebtags( "" );
      chkavAtencionpresencial.setCaption( "En consultorio" );
      httpContext.ajax_rsp_assign_prop("", false, chkavAtencionpresencial.getInternalname(), "TitleCaption", chkavAtencionpresencial.getCaption(), true);
      chkavAtencionpresencial.setCheckedValue( "N" );
      AV6AtencionPresencial = ((GXutil.strcmp(GXutil.rtrim( AV6AtencionPresencial), "P")==0) ? "P" : "N") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6AtencionPresencial", AV6AtencionPresencial);
      chkavAtenciondomicilio.setName( "vATENCIONDOMICILIO" );
      chkavAtenciondomicilio.setWebtags( "" );
      chkavAtenciondomicilio.setCaption( "A domicilio" );
      httpContext.ajax_rsp_assign_prop("", false, chkavAtenciondomicilio.getInternalname(), "TitleCaption", chkavAtenciondomicilio.getCaption(), true);
      chkavAtenciondomicilio.setCheckedValue( "N" );
      AV5AtencionDomicilio = ((GXutil.strcmp(GXutil.rtrim( AV5AtencionDomicilio), "D")==0) ? "D" : "N") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5AtencionDomicilio", AV5AtencionDomicilio);
      cmbavDepartamento.setName( "vDEPARTAMENTO" );
      cmbavDepartamento.setWebtags( "" );
      cmbavDepartamento.addItem("", "Seleccionar", (short)(0));
      if ( cmbavDepartamento.getItemCount() > 0 )
      {
         AV13Departamento = cmbavDepartamento.getValidValue(AV13Departamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Departamento", AV13Departamento);
      }
      dynavProvincia.setName( "vPROVINCIA" );
      dynavProvincia.setWebtags( "" );
      dynavDistrito.setName( "vDISTRITO" );
      dynavDistrito.setWebtags( "" );
      /* End function init_web_controls */
   }

   public void validv_Departamento( )
   {
      AV13Departamento = cmbavDepartamento.getValue() ;
      AV53Provincia = dynavProvincia.getValue() ;
      AV18Distrito = dynavDistrito.getValue() ;
      gxvvprovincia_html2W2( AV13Departamento) ;
      gxvvdistrito_html2W2( AV13Departamento, AV53Provincia) ;
      dynload_actions( ) ;
      if ( dynavProvincia.getItemCount() > 0 )
      {
         AV53Provincia = dynavProvincia.getValidValue(AV53Provincia) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavProvincia.setValue( GXutil.rtrim( AV53Provincia) );
      }
      if ( dynavDistrito.getItemCount() > 0 )
      {
         AV18Distrito = dynavDistrito.getValidValue(AV18Distrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDistrito.setValue( GXutil.rtrim( AV18Distrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV53Provincia", AV53Provincia);
      dynavProvincia.setValue( GXutil.rtrim( AV53Provincia) );
      httpContext.ajax_rsp_assign_prop("", false, dynavProvincia.getInternalname(), "Values", dynavProvincia.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV18Distrito", AV18Distrito);
      dynavDistrito.setValue( GXutil.rtrim( AV18Distrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavDistrito.getInternalname(), "Values", dynavDistrito.ToJavascriptSource(), true);
   }

   public void validv_Provincia( )
   {
      AV13Departamento = cmbavDepartamento.getValue() ;
      AV53Provincia = dynavProvincia.getValue() ;
      AV18Distrito = dynavDistrito.getValue() ;
      gxvvdistrito_html2W2( AV13Departamento, AV53Provincia) ;
      dynload_actions( ) ;
      if ( dynavDistrito.getItemCount() > 0 )
      {
         AV18Distrito = dynavDistrito.getValidValue(AV18Distrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavDistrito.setValue( GXutil.rtrim( AV18Distrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV18Distrito", AV18Distrito);
      dynavDistrito.setValue( GXutil.rtrim( AV18Distrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavDistrito.getInternalname(), "Values", dynavDistrito.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID5_nFirstRecordOnPage'},{av:'GRID5_nEOF'},{av:'GRIDLITADODOCTORES_nFirstRecordOnPage'},{av:'GRIDLITADODOCTORES_nEOF'},{av:'AV20Doctores',fld:'vDOCTORES',grid:163,pic:''},{av:'nRC_GXsfl_163',ctrl:'GRIDLITADODOCTORES',prop:'GridRC',grid:163},{av:'GRID2_nFirstRecordOnPage'},{av:'GRID2_nEOF'},{av:'AV23Especialidades',fld:'vESPECIALIDADES',grid:75,pic:'',hsh:true},{av:'nRC_GXsfl_75',ctrl:'GRID2',prop:'GridRC',grid:75},{av:'AV52Precios',fld:'vPRECIOS',grid:50,pic:'',hsh:true},{av:'nRC_GXsfl_50',ctrl:'GRID5',prop:'GridRC',grid:50},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("'BUSCARFILTRODOCTOR'","{handler:'e122W2',iparms:[{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV23Especialidades',fld:'vESPECIALIDADES',grid:75,pic:'',hsh:true},{av:'GRID2_nFirstRecordOnPage'},{av:'nRC_GXsfl_75',ctrl:'GRID2',prop:'GridRC',grid:75},{av:'AV52Precios',fld:'vPRECIOS',grid:50,pic:'',hsh:true},{av:'GRID5_nFirstRecordOnPage'},{av:'nRC_GXsfl_50',ctrl:'GRID5',prop:'GridRC',grid:50},{av:'cmbavDepartamento'},{av:'AV13Departamento',fld:'vDEPARTAMENTO',pic:''},{av:'dynavProvincia'},{av:'AV53Provincia',fld:'vPROVINCIA',pic:''},{av:'dynavDistrito'},{av:'AV18Distrito',fld:'vDISTRITO',pic:''},{av:'AV20Doctores',fld:'vDOCTORES',grid:163,pic:''},{av:'GRIDLITADODOCTORES_nFirstRecordOnPage'},{av:'nRC_GXsfl_163',ctrl:'GRIDLITADODOCTORES',prop:'GridRC',grid:163},{av:'GRID5_nEOF'},{av:'GRIDLITADODOCTORES_nEOF'},{av:'GRID2_nEOF'},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("'BUSCARFILTRODOCTOR'",",oparms:[{av:'AV20Doctores',fld:'vDOCTORES',grid:163,pic:''},{av:'GRIDLITADODOCTORES_nFirstRecordOnPage'},{av:'nRC_GXsfl_163',ctrl:'GRIDLITADODOCTORES',prop:'GridRC',grid:163},{av:'lblTxbicondireccion_Caption',ctrl:'TXBICONDIRECCION',prop:'Caption'},{av:'lblTxbiconprecioconsulta_Caption',ctrl:'TXBICONPRECIOCONSULTA',prop:'Caption'},{av:'lblTxbicontipocita_Caption',ctrl:'TXBICONTIPOCITA',prop:'Caption'},{av:'lblTxbicondisponible_Caption',ctrl:'TXBICONDISPONIBLE',prop:'Caption'},{av:'lblTxbiconespecialidad_Caption',ctrl:'TXBICONESPECIALIDAD',prop:'Caption'},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("'BTNVERPERFIL'","{handler:'e142W2',iparms:[{av:'AV20Doctores',fld:'vDOCTORES',grid:163,pic:''},{av:'GRIDLITADODOCTORES_nFirstRecordOnPage'},{av:'nRC_GXsfl_163',ctrl:'GRIDLITADODOCTORES',prop:'GridRC',grid:163},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("'BTNVERPERFIL'",",oparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("'BTNAGENDARCITA'","{handler:'e152W2',iparms:[{av:'AV20Doctores',fld:'vDOCTORES',grid:163,pic:''},{av:'GRIDLITADODOCTORES_nFirstRecordOnPage'},{av:'nRC_GXsfl_163',ctrl:'GRIDLITADODOCTORES',prop:'GridRC',grid:163},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("'BTNAGENDARCITA'",",oparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("'LIMPIARFILTROS'","{handler:'e112W1',iparms:[{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("'LIMPIARFILTROS'",",oparms:[{av:'AV21EspeciadadId',fld:'vESPECIADADID',pic:'ZZZ9'},{av:'AV55TipoCita',fld:'vTIPOCITA',pic:''},{av:'AV25Fecha',fld:'vFECHA',pic:''},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("VNOMBRESAPELLIDOSDOCTOR.CONTROLVALUECHANGING","{handler:'e132W2',iparms:[{av:'AV48NombresApellidosDoctor',fld:'vNOMBRESAPELLIDOSDOCTOR',pic:''},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV23Especialidades',fld:'vESPECIALIDADES',grid:75,pic:'',hsh:true},{av:'GRID2_nFirstRecordOnPage'},{av:'nRC_GXsfl_75',ctrl:'GRID2',prop:'GridRC',grid:75},{av:'AV52Precios',fld:'vPRECIOS',grid:50,pic:'',hsh:true},{av:'GRID5_nFirstRecordOnPage'},{av:'nRC_GXsfl_50',ctrl:'GRID5',prop:'GridRC',grid:50},{av:'AV20Doctores',fld:'vDOCTORES',grid:163,pic:''},{av:'GRIDLITADODOCTORES_nFirstRecordOnPage'},{av:'nRC_GXsfl_163',ctrl:'GRIDLITADODOCTORES',prop:'GridRC',grid:163},{av:'GRID5_nEOF'},{av:'GRIDLITADODOCTORES_nEOF'},{av:'GRID2_nEOF'},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("VNOMBRESAPELLIDOSDOCTOR.CONTROLVALUECHANGING",",oparms:[{av:'AV20Doctores',fld:'vDOCTORES',grid:163,pic:''},{av:'GRIDLITADODOCTORES_nFirstRecordOnPage'},{av:'nRC_GXsfl_163',ctrl:'GRIDLITADODOCTORES',prop:'GridRC',grid:163},{av:'lblTxbicondireccion_Caption',ctrl:'TXBICONDIRECCION',prop:'Caption'},{av:'lblTxbiconprecioconsulta_Caption',ctrl:'TXBICONPRECIOCONSULTA',prop:'Caption'},{av:'lblTxbicontipocita_Caption',ctrl:'TXBICONTIPOCITA',prop:'Caption'},{av:'lblTxbicondisponible_Caption',ctrl:'TXBICONDISPONIBLE',prop:'Caption'},{av:'lblTxbiconespecialidad_Caption',ctrl:'TXBICONESPECIALIDAD',prop:'Caption'},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("VALIDV_DEPARTAMENTO","{handler:'validv_Departamento',iparms:[{av:'cmbavDepartamento'},{av:'AV13Departamento',fld:'vDEPARTAMENTO',pic:''},{av:'dynavProvincia'},{av:'AV53Provincia',fld:'vPROVINCIA',pic:''},{av:'dynavDistrito'},{av:'AV18Distrito',fld:'vDISTRITO',pic:''},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("VALIDV_DEPARTAMENTO",",oparms:[{av:'dynavProvincia'},{av:'AV53Provincia',fld:'vPROVINCIA',pic:''},{av:'dynavDistrito'},{av:'AV18Distrito',fld:'vDISTRITO',pic:''},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("VALIDV_PROVINCIA","{handler:'validv_Provincia',iparms:[{av:'cmbavDepartamento'},{av:'AV13Departamento',fld:'vDEPARTAMENTO',pic:''},{av:'dynavProvincia'},{av:'AV53Provincia',fld:'vPROVINCIA',pic:''},{av:'dynavDistrito'},{av:'AV18Distrito',fld:'vDISTRITO',pic:''},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("VALIDV_PROVINCIA",",oparms:[{av:'dynavDistrito'},{av:'AV18Distrito',fld:'vDISTRITO',pic:''},{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv4',iparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv8',iparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv18',iparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV28GeneroMasculino',fld:'vGENEROMASCULINO',pic:''},{av:'AV27GeneroFemenino',fld:'vGENEROFEMENINO',pic:''},{av:'AV7AtencionVirtual',fld:'vATENCIONVIRTUAL',pic:''},{av:'AV6AtencionPresencial',fld:'vATENCIONPRESENCIAL',pic:''},{av:'AV5AtencionDomicilio',fld:'vATENCIONDOMICILIO',pic:''}]}");
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
      wcpOAV55TipoCita = "" ;
      wcpOAV25Fecha = GXutil.nullDate() ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV13Departamento = "" ;
      AV53Provincia = "" ;
      AV28GeneroMasculino = "" ;
      AV27GeneroFemenino = "" ;
      AV7AtencionVirtual = "" ;
      AV6AtencionPresencial = "" ;
      AV5AtencionDomicilio = "" ;
      AV23Especialidades = new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>(com.projectthani.SdtSDTEspecialidad.class, "SDTEspecialidad", "ProjectThani", remoteHandle);
      AV52Precios = new GXBaseCollection<com.projectthani.SdtSDTRangoPrecios>(com.projectthani.SdtSDTRangoPrecios.class, "SDTRangoPrecios", "ProjectThani", remoteHandle);
      Gx_date = GXutil.nullDate() ;
      AV55TipoCita = "" ;
      AV25Fecha = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV20Doctores = new GXBaseCollection<com.projectthani.SdtSDTDoctores>(com.projectthani.SdtSDTDoctores.class, "SDTDoctores", "ProjectThani", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblock_Jsonclick = "" ;
      lblTextblocklimpiarfiltros_Jsonclick = "" ;
      lblTextblockgenero_Jsonclick = "" ;
      lblTextblockiconoflecha_Jsonclick = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTbrangoprecios_Jsonclick = "" ;
      lblTextblockrangprecicon_Jsonclick = "" ;
      Grid5Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid5_Header = "" ;
      Grid5Column = new com.genexus.webpanels.GXWebColumn();
      lblTbespecialidades_Jsonclick = "" ;
      lblTextblockespecialicon_Jsonclick = "" ;
      Grid2Container = new com.genexus.webpanels.GXWebGrid(context);
      subGrid2_Header = "" ;
      Grid2Column = new com.genexus.webpanels.GXWebColumn();
      lblTbtipoatencion_Jsonclick = "" ;
      lblTextblockatencionicon_Jsonclick = "" ;
      lblTbdepartamento_Jsonclick = "" ;
      lblTbprovincia_Jsonclick = "" ;
      lblTbdistrito_Jsonclick = "" ;
      AV18Distrito = "" ;
      bttBuscarfiltrodoctor_Jsonclick = "" ;
      AV48NombresApellidosDoctor = "" ;
      GridlitadodoctoresContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridlitadodoctores_Header = "" ;
      GridlitadodoctoresColumn = new com.genexus.webpanels.GXWebColumn();
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H002W2_A44UbigeoCode = new String[] {""} ;
      H002W2_A187UbigeoProvincia = new String[] {""} ;
      H002W2_A296UbigeoProvinciaCode = new String[] {""} ;
      H002W2_A295UbigeoDepartamentoCode = new String[] {""} ;
      H002W3_A44UbigeoCode = new String[] {""} ;
      H002W3_A188UbigeoDistrito = new String[] {""} ;
      H002W3_A297UbigeoDistritoCode = new String[] {""} ;
      H002W3_A295UbigeoDepartamentoCode = new String[] {""} ;
      H002W3_A296UbigeoProvinciaCode = new String[] {""} ;
      AV44htmlMensajeVisible = "" ;
      AV43htmlMensajeNoVisible = "" ;
      AV50OpListado = "" ;
      H002W4_A186UbigeoDepartamento = new String[] {""} ;
      H002W4_A295UbigeoDepartamentoCode = new String[] {""} ;
      H002W4_A44UbigeoCode = new String[] {""} ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A44UbigeoCode = "" ;
      GXt_objcol_SdtSDTEspecialidad3 = new GXBaseCollection<com.projectthani.SdtSDTEspecialidad>(com.projectthani.SdtSDTEspecialidad.class, "SDTEspecialidad", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTEspecialidad4 = new GXBaseCollection[1] ;
      GXt_objcol_SdtSDTRangoPrecios5 = new GXBaseCollection<com.projectthani.SdtSDTRangoPrecios>(com.projectthani.SdtSDTRangoPrecios.class, "SDTRangoPrecios", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTRangoPrecios6 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTDoctores1 = new GXBaseCollection[1] ;
      GXv_int2 = new short[1] ;
      AV37HtmlIconDireccion = "" ;
      AV40HtmlIconPrecioConsulta = "" ;
      AV41HtmlIconTipoConsulta = "" ;
      AV38HtmlIconDisponible = "" ;
      AV39HtmlIconEspecialidad = "" ;
      AV32HtmlAngleRight1 = "" ;
      AV33HtmlAngleRight2 = "" ;
      AV34HtmlAngleRight3 = "" ;
      AV35HtmlAngleRight4 = "" ;
      Grid5Row = new com.genexus.webpanels.GXWebRow();
      GridlitadodoctoresRow = new com.genexus.webpanels.GXWebRow();
      Grid2Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid5_Linesclass = "" ;
      GXCCtl = "" ;
      ROClassString = "" ;
      subGrid2_Linesclass = "" ;
      subGridlitadodoctores_Linesclass = "" ;
      sImgUrl = "" ;
      lblTxbiconespecialidad_Jsonclick = "" ;
      lblTxbicondireccion_Jsonclick = "" ;
      lblTxbicondisponible_Jsonclick = "" ;
      lblTextblock6_Jsonclick = "" ;
      lblTxbicontipocita_Jsonclick = "" ;
      lblTxbiconprecioconsulta_Jsonclick = "" ;
      bttBtnverperfil_Jsonclick = "" ;
      bttBtnagendarcita_Jsonclick = "" ;
      ZV53Provincia = "" ;
      ZV18Distrito = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpdoctores__default(),
         new Object[] {
             new Object[] {
            H002W2_A44UbigeoCode, H002W2_A187UbigeoProvincia, H002W2_A296UbigeoProvinciaCode, H002W2_A295UbigeoDepartamentoCode
            }
            , new Object[] {
            H002W3_A44UbigeoCode, H002W3_A188UbigeoDistrito, H002W3_A297UbigeoDistritoCode, H002W3_A295UbigeoDepartamentoCode, H002W3_A296UbigeoProvinciaCode
            }
            , new Object[] {
            H002W4_A186UbigeoDepartamento, H002W4_A295UbigeoDepartamentoCode, H002W4_A44UbigeoCode
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavCtldescripcion1_Enabled = 0 ;
      edtavCtlidprecio1_Enabled = 0 ;
      edtavCtlespecialidadnombre_Enabled = 0 ;
      edtavCtlespecialidadid_Enabled = 0 ;
      edtavCtlprofesionalid_Enabled = 0 ;
      edtavCtlapellidosnombres_Enabled = 0 ;
      edtavCtlespecialidad_Enabled = 0 ;
      edtavCtlcalificacion_Enabled = 0 ;
      edtavCtldireccion_Enabled = 0 ;
      edtavCtldisponibilidad_Enabled = 0 ;
      edtavCtltipocita_Enabled = 0 ;
      edtavCtlprecioconsulta_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGrid5_Backcolorstyle ;
   private byte subGrid5_Allowselection ;
   private byte subGrid5_Allowhovering ;
   private byte subGrid5_Allowcollapsing ;
   private byte subGrid5_Collapsed ;
   private byte subGrid2_Backcolorstyle ;
   private byte subGrid2_Allowselection ;
   private byte subGrid2_Allowhovering ;
   private byte subGrid2_Allowcollapsing ;
   private byte subGrid2_Collapsed ;
   private byte subGridlitadodoctores_Backcolorstyle ;
   private byte subGridlitadodoctores_Allowselection ;
   private byte subGridlitadodoctores_Allowhovering ;
   private byte subGridlitadodoctores_Allowcollapsing ;
   private byte subGridlitadodoctores_Collapsed ;
   private byte nDonePA ;
   private byte GRID5_nEOF ;
   private byte GRIDLITADODOCTORES_nEOF ;
   private byte GRID2_nEOF ;
   private byte nGXWrapped ;
   private byte subGrid5_Backstyle ;
   private byte subGrid2_Backstyle ;
   private byte subGridlitadodoctores_Backstyle ;
   private short wcpOAV21EspeciadadId ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV21EspeciadadId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV59NroItem ;
   private short GXv_int2[] ;
   private int nRC_GXsfl_50 ;
   private int nRC_GXsfl_75 ;
   private int nRC_GXsfl_163 ;
   private int nGXsfl_50_idx=1 ;
   private int nGXsfl_75_idx=1 ;
   private int nGXsfl_163_idx=1 ;
   private int divTable7_Visible ;
   private int divTable18_Visible ;
   private int edtavCtldescripcion1_Enabled ;
   private int edtavCtlidprecio1_Enabled ;
   private int subGrid5_Selectedindex ;
   private int subGrid5_Selectioncolor ;
   private int subGrid5_Hoveringcolor ;
   private int AV62GXV1 ;
   private int edtavCtlespecialidadnombre_Enabled ;
   private int edtavCtlespecialidadid_Enabled ;
   private int subGrid2_Selectedindex ;
   private int subGrid2_Selectioncolor ;
   private int subGrid2_Hoveringcolor ;
   private int AV66GXV5 ;
   private int divTable12_Visible ;
   private int divTable13_Visible ;
   private int divTable14_Visible ;
   private int divTable17_Visible ;
   private int divTable16_Visible ;
   private int divTable15_Visible ;
   private int edtavNombresapellidosdoctor_Enabled ;
   private int edtavCtlprofesionalid_Enabled ;
   private int edtavCtlapellidosnombres_Enabled ;
   private int edtavCtlespecialidad_Enabled ;
   private int edtavCtlcalificacion_Enabled ;
   private int edtavCtldireccion_Enabled ;
   private int edtavCtldisponibilidad_Enabled ;
   private int edtavCtltipocita_Enabled ;
   private int edtavCtlprecioconsulta_Enabled ;
   private int subGridlitadodoctores_Selectedindex ;
   private int subGridlitadodoctores_Selectioncolor ;
   private int subGridlitadodoctores_Hoveringcolor ;
   private int AV70GXV9 ;
   private int gxdynajaxindex ;
   private int subGrid5_Islastpage ;
   private int subGridlitadodoctores_Islastpage ;
   private int subGrid2_Islastpage ;
   private int nGXsfl_50_fel_idx=1 ;
   private int nGXsfl_75_fel_idx=1 ;
   private int nGXsfl_163_fel_idx=1 ;
   private int nGXsfl_163_bak_idx=1 ;
   private int idxLst ;
   private int subGrid5_Backcolor ;
   private int subGrid5_Allbackcolor ;
   private int subGrid2_Backcolor ;
   private int subGrid2_Allbackcolor ;
   private int subGridlitadodoctores_Backcolor ;
   private int subGridlitadodoctores_Allbackcolor ;
   private long GRID5_nCurrentRecord ;
   private long GRID2_nCurrentRecord ;
   private long GRIDLITADODOCTORES_nCurrentRecord ;
   private long GRID5_nFirstRecordOnPage ;
   private long GRIDLITADODOCTORES_nFirstRecordOnPage ;
   private long GRID2_nFirstRecordOnPage ;
   private String wcpOAV55TipoCita ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_50_idx="0001" ;
   private String AV28GeneroMasculino ;
   private String AV27GeneroFemenino ;
   private String AV7AtencionVirtual ;
   private String AV6AtencionPresencial ;
   private String AV5AtencionDomicilio ;
   private String sGXsfl_75_idx="0001" ;
   private String sGXsfl_163_idx="0001" ;
   private String AV55TipoCita ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTablefiltromedicos_Internalname ;
   private String lblTextblock_Internalname ;
   private String lblTextblock_Jsonclick ;
   private String divTable10_Internalname ;
   private String lblTextblocklimpiarfiltros_Link ;
   private String lblTextblocklimpiarfiltros_Internalname ;
   private String lblTextblocklimpiarfiltros_Caption ;
   private String lblTextblocklimpiarfiltros_Jsonclick ;
   private String divTable5_Internalname ;
   private String lblTextblockgenero_Internalname ;
   private String lblTextblockgenero_Jsonclick ;
   private String lblTextblockiconoflecha_Internalname ;
   private String lblTextblockiconoflecha_Caption ;
   private String lblTextblockiconoflecha_Jsonclick ;
   private String divTable6_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String divTable7_Internalname ;
   private String lblTbrangoprecios_Internalname ;
   private String lblTbrangoprecios_Jsonclick ;
   private String lblTextblockrangprecicon_Internalname ;
   private String lblTextblockrangprecicon_Caption ;
   private String lblTextblockrangprecicon_Jsonclick ;
   private String divTable18_Internalname ;
   private String sStyleString ;
   private String subGrid5_Internalname ;
   private String subGrid5_Header ;
   private String divTable8_Internalname ;
   private String lblTbespecialidades_Internalname ;
   private String lblTbespecialidades_Jsonclick ;
   private String lblTextblockespecialicon_Internalname ;
   private String lblTextblockespecialicon_Caption ;
   private String lblTextblockespecialicon_Jsonclick ;
   private String divTable19_Internalname ;
   private String subGrid2_Internalname ;
   private String subGrid2_Header ;
   private String divTable9_Internalname ;
   private String lblTbtipoatencion_Internalname ;
   private String lblTbtipoatencion_Jsonclick ;
   private String lblTextblockatencionicon_Internalname ;
   private String lblTextblockatencionicon_Caption ;
   private String lblTextblockatencionicon_Jsonclick ;
   private String divTable11_Internalname ;
   private String divTable12_Internalname ;
   private String lblTbdepartamento_Internalname ;
   private String lblTbdepartamento_Jsonclick ;
   private String divTable13_Internalname ;
   private String divTable14_Internalname ;
   private String lblTbprovincia_Internalname ;
   private String lblTbprovincia_Jsonclick ;
   private String divTable17_Internalname ;
   private String divTable16_Internalname ;
   private String lblTbdistrito_Internalname ;
   private String lblTbdistrito_Jsonclick ;
   private String divTable15_Internalname ;
   private String bttBuscarfiltrodoctor_Internalname ;
   private String bttBuscarfiltrodoctor_Jsonclick ;
   private String divTablelistadodoctores_Internalname ;
   private String divTable4_Internalname ;
   private String edtavNombresapellidosdoctor_Internalname ;
   private String edtavNombresapellidosdoctor_Jsonclick ;
   private String subGridlitadodoctores_Internalname ;
   private String subGridlitadodoctores_Header ;
   private String lblTxbiconespecialidad_Caption ;
   private String lblTxbicondisponible_Caption ;
   private String lblTextblock6_Caption ;
   private String lblTxbicontipocita_Caption ;
   private String lblTxbiconprecioconsulta_Caption ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String edtavCtldescripcion1_Internalname ;
   private String edtavCtlidprecio1_Internalname ;
   private String edtavCtlespecialidadnombre_Internalname ;
   private String edtavCtlespecialidadid_Internalname ;
   private String edtavCtlprofesionalid_Internalname ;
   private String edtavCtlapellidosnombres_Internalname ;
   private String edtavCtlespecialidad_Internalname ;
   private String edtavCtlcalificacion_Internalname ;
   private String edtavCtldireccion_Internalname ;
   private String edtavCtldisponibilidad_Internalname ;
   private String edtavCtltipocita_Internalname ;
   private String edtavCtlprecioconsulta_Internalname ;
   private String sGXsfl_50_fel_idx="0001" ;
   private String sGXsfl_75_fel_idx="0001" ;
   private String sGXsfl_163_fel_idx="0001" ;
   private String AV50OpListado ;
   private String A44UbigeoCode ;
   private String lblTxbicondireccion_Caption ;
   private String lblTxbicondireccion_Internalname ;
   private String lblTxbiconprecioconsulta_Internalname ;
   private String lblTxbicontipocita_Internalname ;
   private String lblTxbicondisponible_Internalname ;
   private String lblTxbiconespecialidad_Internalname ;
   private String subGrid5_Class ;
   private String subGrid5_Linesclass ;
   private String divGrid5table_Internalname ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtavCtldescripcion1_Jsonclick ;
   private String edtavCtlidprecio1_Jsonclick ;
   private String subGrid2_Class ;
   private String subGrid2_Linesclass ;
   private String divGrid2table_Internalname ;
   private String edtavCtlespecialidadnombre_Jsonclick ;
   private String edtavCtlespecialidadid_Jsonclick ;
   private String edtavCtlfotografia_Internalname ;
   private String lblTextblock6_Internalname ;
   private String subGridlitadodoctores_Class ;
   private String subGridlitadodoctores_Linesclass ;
   private String divGrid3table_Internalname ;
   private String divTable20_Internalname ;
   private String divTable1_Internalname ;
   private String sImgUrl ;
   private String divTable3_Internalname ;
   private String edtavCtlprofesionalid_Jsonclick ;
   private String edtavCtlapellidosnombres_Jsonclick ;
   private String lblTxbiconespecialidad_Jsonclick ;
   private String edtavCtlespecialidad_Jsonclick ;
   private String lblTxbicondireccion_Jsonclick ;
   private String edtavCtldireccion_Jsonclick ;
   private String lblTxbicondisponible_Jsonclick ;
   private String lblTextblock6_Jsonclick ;
   private String edtavCtldisponibilidad_Jsonclick ;
   private String lblTxbicontipocita_Jsonclick ;
   private String edtavCtltipocita_Jsonclick ;
   private String lblTxbiconprecioconsulta_Jsonclick ;
   private String edtavCtlprecioconsulta_Jsonclick ;
   private String divTable2_Internalname ;
   private String bttBtnverperfil_Internalname ;
   private String bttBtnverperfil_Jsonclick ;
   private String bttBtnagendarcita_Internalname ;
   private String bttBtnagendarcita_Jsonclick ;
   private java.util.Date wcpOAV25Fecha ;
   private java.util.Date Gx_date ;
   private java.util.Date AV25Fecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_50_Refreshing=false ;
   private boolean bGXsfl_75_Refreshing=false ;
   private boolean bGXsfl_163_Refreshing=false ;
   private boolean returnInSub ;
   private boolean gx_BV163 ;
   private boolean gx_BV75 ;
   private boolean gx_BV50 ;
   private String AV44htmlMensajeVisible ;
   private String AV43htmlMensajeNoVisible ;
   private String AV37HtmlIconDireccion ;
   private String AV40HtmlIconPrecioConsulta ;
   private String AV41HtmlIconTipoConsulta ;
   private String AV38HtmlIconDisponible ;
   private String AV39HtmlIconEspecialidad ;
   private String AV32HtmlAngleRight1 ;
   private String AV33HtmlAngleRight2 ;
   private String AV34HtmlAngleRight3 ;
   private String AV35HtmlAngleRight4 ;
   private String AV13Departamento ;
   private String AV53Provincia ;
   private String AV18Distrito ;
   private String AV48NombresApellidosDoctor ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String ZV53Provincia ;
   private String ZV18Distrito ;
   private com.genexus.webpanels.GXWebGrid Grid5Container ;
   private com.genexus.webpanels.GXWebGrid Grid2Container ;
   private com.genexus.webpanels.GXWebGrid GridlitadodoctoresContainer ;
   private com.genexus.webpanels.GXWebRow Grid5Row ;
   private com.genexus.webpanels.GXWebRow GridlitadodoctoresRow ;
   private com.genexus.webpanels.GXWebRow Grid2Row ;
   private com.genexus.webpanels.GXWebColumn Grid5Column ;
   private com.genexus.webpanels.GXWebColumn Grid2Column ;
   private com.genexus.webpanels.GXWebColumn GridlitadodoctoresColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private ICheckbox chkavGeneromasculino ;
   private ICheckbox chkavGenerofemenino ;
   private ICheckbox chkavCtlestado1 ;
   private ICheckbox chkavCtlespecialidadcheck ;
   private ICheckbox chkavAtencionvirtual ;
   private ICheckbox chkavAtencionpresencial ;
   private ICheckbox chkavAtenciondomicilio ;
   private HTMLChoice cmbavDepartamento ;
   private HTMLChoice dynavProvincia ;
   private HTMLChoice dynavDistrito ;
   private IDataStoreProvider pr_default ;
   private String[] H002W2_A44UbigeoCode ;
   private String[] H002W2_A187UbigeoProvincia ;
   private String[] H002W2_A296UbigeoProvinciaCode ;
   private String[] H002W2_A295UbigeoDepartamentoCode ;
   private String[] H002W3_A44UbigeoCode ;
   private String[] H002W3_A188UbigeoDistrito ;
   private String[] H002W3_A297UbigeoDistritoCode ;
   private String[] H002W3_A295UbigeoDepartamentoCode ;
   private String[] H002W3_A296UbigeoProvinciaCode ;
   private String[] H002W4_A186UbigeoDepartamento ;
   private String[] H002W4_A295UbigeoDepartamentoCode ;
   private String[] H002W4_A44UbigeoCode ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctores> AV20Doctores ;
   private GXBaseCollection<com.projectthani.SdtSDTDoctores> GXv_objcol_SdtSDTDoctores1[] ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> AV23Especialidades ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> GXt_objcol_SdtSDTEspecialidad3 ;
   private GXBaseCollection<com.projectthani.SdtSDTEspecialidad> GXv_objcol_SdtSDTEspecialidad4[] ;
   private GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> AV52Precios ;
   private GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> GXt_objcol_SdtSDTRangoPrecios5 ;
   private GXBaseCollection<com.projectthani.SdtSDTRangoPrecios> GXv_objcol_SdtSDTRangoPrecios6[] ;
}

final  class wpdoctores__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002W2", "SELECT [UbigeoCode], [UbigeoProvincia], SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode FROM [Ubigeo] WHERE SUBSTRING([UbigeoCode], 1, 2) = ? ORDER BY [UbigeoProvincia] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002W3", "SELECT [UbigeoCode], [UbigeoDistrito], SUBSTRING([UbigeoCode], 5, 2) AS UbigeoDistritoCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode FROM [Ubigeo] WHERE (SUBSTRING([UbigeoCode], 1, 2) = ?) AND (SUBSTRING([UbigeoCode], 3, 2) = ?) ORDER BY [UbigeoDistrito] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002W4", "SELECT DISTINCT [UbigeoDepartamento], [UbigeoDepartamentoCode], NULL AS [UbigeoCode] FROM ( SELECT TOP(100) PERCENT [UbigeoDepartamento], SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, [UbigeoCode] FROM [Ubigeo] ORDER BY [UbigeoDepartamento]) DistinctT ORDER BY [UbigeoDepartamento] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
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
               stmt.setVarchar(1, (String)parms[0], 2);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 2);
               stmt.setVarchar(2, (String)parms[1], 2);
               return;
      }
   }

}

