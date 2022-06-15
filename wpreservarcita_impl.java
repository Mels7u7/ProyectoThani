package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpreservarcita_impl extends GXDataArea
{
   public wpreservarcita_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpreservarcita_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpreservarcita_impl.class ));
   }

   public wpreservarcita_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV11DisponibilidadId = (int) GXutil.lval( args[0]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      cmbavCtlsdtinformaciondelacitatipoconsulta = new HTMLChoice();
      cmbavCitafamiliar = new HTMLChoice();
      cmbavPacientefamiliarid = new HTMLChoice();
      chkavTerminosycondiciones = UIFactory.getCheckbox(this);
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "DisponibilidadId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "DisponibilidadId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "DisponibilidadId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid5") == 0 )
         {
            nRC_GXsfl_20 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_20"))) ;
            nGXsfl_20_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_20_idx"))) ;
            sGXsfl_20_idx = httpContext.GetPar( "sGXsfl_20_idx") ;
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
            AV34TerminosYCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosYCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV24SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23SDTDetalleCita);
            AV21PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid5_refresh( AV34TerminosYCondiciones, AV24SDTPaciente, AV23SDTDetalleCita, AV21PacienteId, AV11DisponibilidadId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Autoupload", GXutil.booltostr( Fileuploadpaciente_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpaciente_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpaciente_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpaciente_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Acceptedfiletypes", GXutil.rtrim( Fileuploadpaciente_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Autoupload", GXutil.booltostr( Fileuploadpacientefamiliar_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpacientefamiliar_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpacientefamiliar_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpacientefamiliar_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridpaciente") == 0 )
         {
            nRC_GXsfl_99 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_99"))) ;
            nGXsfl_99_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_99_idx"))) ;
            sGXsfl_99_idx = httpContext.GetPar( "sGXsfl_99_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridpaciente_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridpaciente") == 0 )
         {
            AV34TerminosYCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosYCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV24SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23SDTDetalleCita);
            AV21PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridpaciente_refresh( AV34TerminosYCondiciones, AV24SDTPaciente, AV23SDTDetalleCita, AV21PacienteId, AV11DisponibilidadId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Autoupload", GXutil.booltostr( Fileuploadpaciente_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpaciente_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpaciente_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpaciente_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Acceptedfiletypes", GXutil.rtrim( Fileuploadpaciente_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Autoupload", GXutil.booltostr( Fileuploadpacientefamiliar_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpacientefamiliar_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpacientefamiliar_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpacientefamiliar_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridpacientefamiliar") == 0 )
         {
            nRC_GXsfl_151 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_151"))) ;
            nGXsfl_151_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_151_idx"))) ;
            sGXsfl_151_idx = httpContext.GetPar( "sGXsfl_151_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridpacientefamiliar_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridpacientefamiliar") == 0 )
         {
            AV34TerminosYCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosYCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV24SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV23SDTDetalleCita);
            AV21PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridpacientefamiliar_refresh( AV34TerminosYCondiciones, AV24SDTPaciente, AV23SDTDetalleCita, AV21PacienteId, AV11DisponibilidadId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Autoupload", GXutil.booltostr( Fileuploadpaciente_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpaciente_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpaciente_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpaciente_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Acceptedfiletypes", GXutil.rtrim( Fileuploadpaciente_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Autoupload", GXutil.booltostr( Fileuploadpacientefamiliar_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpacientefamiliar_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpacientefamiliar_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpacientefamiliar_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
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
            AV11DisponibilidadId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DisponibilidadId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11DisponibilidadId), "ZZZZZZZ9")));
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
         MasterPageObj.setDataArea(this,true);
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
      pa2X2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2X2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110334760", false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("calendar-es.js", "?"+httpContext.getBuildNumber( 1346400), false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoGeneral\" data-gx-class=\"form-horizontal FormFondoGeneral\" novalidate action=\""+formatLink("com.projectthani.wpreservarcita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTPACIENTE", getSecureSignedToken( "", AV24SDTPaciente));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTDETALLECITA", getSecureSignedToken( "", AV23SDTDetalleCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11DisponibilidadId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtpaciente", AV24SDTPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtpaciente", AV24SDTPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtpaciente", getSecureSignedToken( "", AV24SDTPaciente));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtpacientefamiliar", AV25SDTPacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtpacientefamiliar", AV25SDTPacienteFamiliar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtdetallecita", AV23SDTDetalleCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtdetallecita", AV23SDTDetalleCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtdetallecita", getSecureSignedToken( "", AV23SDTDetalleCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_20", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_20, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_99", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_99, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_151", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_151, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFILEUPLOADPACIENTE", AV16FileUploadPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFILEUPLOADPACIENTE", AV16FileUploadPaciente);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFAILEDFILES", AV12FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFAILEDFILES", AV12FailedFiles);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFILEUPLOADPACIENTEFAMILIAR", AV17FileUploadPacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFILEUPLOADPACIENTEFAMILIAR", AV17FileUploadPacienteFamiliar);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV21PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21PacienteId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPACIENTE", AV24SDTPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPACIENTE", AV24SDTPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTPACIENTE", getSecureSignedToken( "", AV24SDTPaciente));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPACIENTEFAMILIAR", AV25SDTPacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPACIENTEFAMILIAR", AV25SDTPacienteFamiliar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTDETALLECITA", AV23SDTDetalleCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTDETALLECITA", AV23SDTDetalleCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTDETALLECITA", getSecureSignedToken( "", AV23SDTDetalleCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV11DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11DisponibilidadId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITA", AV7Cita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITA", AV7Cita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Autoupload", GXutil.booltostr( Fileuploadpaciente_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpaciente_Hideadditionalbuttons));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpaciente_Enableuploadedfilecanceling));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpaciente_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTE_Acceptedfiletypes", GXutil.rtrim( Fileuploadpaciente_Acceptedfiletypes));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Autoupload", GXutil.booltostr( Fileuploadpacientefamiliar_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Hideadditionalbuttons", GXutil.booltostr( Fileuploadpacientefamiliar_Hideadditionalbuttons));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling", GXutil.booltostr( Fileuploadpacientefamiliar_Enableuploadedfilecanceling));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Fileuploadpacientefamiliar_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
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
         we2X2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2X2( ) ;
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
      return formatLink("com.projectthani.wpreservarcita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"})  ;
   }

   public String getPgmname( )
   {
      return "WPReservarCita" ;
   }

   public String getPgmdesc( )
   {
      return "Reservar Cita" ;
   }

   public void wb2X0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablegeneralpagarcita_Internalname, 1, 0, "px", 0, "px", "TableMainPagarCita", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "TableReservarCita", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable4_Internalname, 1, 0, "px", 0, "px", "TableBorderDetalleCita", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableMT4PC", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockinfocita_Internalname, "Información de la cita", "", "", lblTextblockinfocita_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockInfoCita", 0, "", 1, 1, 0, (short)(0), "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSeparador_Internalname, 1, 0, "px", 0, "px", "col-xs-12 TableSeparadorPC", "left", "top", "", "", "div");
         httpContext.writeText( "<hr/>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid5Container.SetIsFreestyle(true);
         Grid5Container.SetWrapped(nGXWrapped);
         if ( Grid5Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"Grid5Container"+"DivS\" data-gxgridid=\"20\">") ;
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitaid_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Container.AddColumnProperties(Grid5Column);
            Grid5Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitanombresdoctor_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitaclinica_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitasede_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavCtlsdtinformaciondelacitatipoconsulta.getEnabled(), (byte)(5), (byte)(0), ".", "")));
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitafecha_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitahora_Enabled, (byte)(5), (byte)(0), ".", "")));
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
            Grid5Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelacitacosto_Enabled, (byte)(5), (byte)(0), ".", "")));
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
      if ( wbEnd == 20 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_20 = (int)(nGXsfl_20_idx-1) ;
         if ( Grid5Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV37GXV1 = nGXsfl_20_idx ;
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
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable3_Internalname, 1, 0, "px", 0, "px", "TableContenedorPC", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTabrealizarpago.setProperty("PageCount", Tabrealizarpago_Pagecount);
         ucTabrealizarpago.setProperty("Class", Tabrealizarpago_Class);
         ucTabrealizarpago.setProperty("HistoryManagement", Tabrealizarpago_Historymanagement);
         ucTabrealizarpago.render(context, "tab", Tabrealizarpago_Internalname, "TABREALIZARPAGOContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpageinformacionpaciente_title_Internalname, "Información del paciente", "", "", lblTabpageinformacionpaciente_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPReservarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPageInformacionPaciente") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable5_Internalname, 1, 0, "px", 0, "px", "TableSeleccionarFamiliar", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavCitafamiliar.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavCitafamiliar.getInternalname(), "¿Cita para un familiar?", "col-xs-12 AttributeComboBoxPCLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'" + sGXsfl_20_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCitafamiliar, cmbavCitafamiliar.getInternalname(), GXutil.rtrim( AV8CitaFamiliar), 1, cmbavCitafamiliar.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavCitafamiliar.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeComboBoxPC", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "", true, (byte)(1), "HLP_WPReservarCita.htm");
         cmbavCitafamiliar.setValue( GXutil.rtrim( AV8CitaFamiliar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCitafamiliar.getInternalname(), "Values", cmbavCitafamiliar.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", cmbavPacientefamiliarid.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavPacientefamiliarid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavPacientefamiliarid.getInternalname(), "Seleccionar Familiar:", "col-xs-12 AttributeComboBoxPCLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'" + sGXsfl_20_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientefamiliarid, cmbavPacientefamiliarid.getInternalname(), GXutil.trim( GXutil.str( AV20PacienteFamiliarId, 8, 0)), 1, cmbavPacientefamiliarid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavPacientefamiliarid.getVisible(), cmbavPacientefamiliarid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeComboBoxPC", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "", true, (byte)(1), "HLP_WPReservarCita.htm");
         cmbavPacientefamiliarid.setValue( GXutil.trim( GXutil.str( AV20PacienteFamiliarId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientefamiliarid.getInternalname(), "Values", cmbavPacientefamiliarid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable6_Internalname, 1, 0, "px", 0, "px", "TableInfomacionPaciente", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridpacienteContainer.SetIsFreestyle(true);
         GridpacienteContainer.SetWrapped(nGXWrapped);
         if ( GridpacienteContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridpacienteContainer"+"DivS\" data-gxgridid=\"99\">") ;
            sStyleString = "" ;
            if ( subGridpaciente_Visible == 0 )
            {
               sStyleString += "display:none;" ;
            }
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridpaciente_Internalname, subGridpaciente_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridpacienteContainer.AddObjectProperty("GridName", "Gridpaciente");
         }
         else
         {
            GridpacienteContainer.AddObjectProperty("GridName", "Gridpaciente");
            GridpacienteContainer.AddObjectProperty("Header", subGridpaciente_Header);
            GridpacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Visible, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridpacienteContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridpacienteContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Visible, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("CmpContext", "");
            GridpacienteContainer.AddObjectProperty("InMasterPage", "false");
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacienteid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacientenombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacienteapellidos_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacientetipodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacientenrodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacientesexo_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsdtinformaciondelpacienteemail_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridpacienteContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 99 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_99 = (int)(nGXsfl_99_idx-1) ;
         if ( GridpacienteContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV48GXV12 = nGXsfl_99_idx ;
            if ( subGridpaciente_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"GridpacienteContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridpaciente", GridpacienteContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacienteContainerData", GridpacienteContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacienteContainerData"+"V", GridpacienteContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridpacienteContainerData"+"V"+"\" value='"+GridpacienteContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridpacientefamiliarContainer.SetIsFreestyle(true);
         GridpacientefamiliarContainer.SetWrapped(nGXWrapped);
         if ( GridpacientefamiliarContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridpacientefamiliarContainer"+"DivS\" data-gxgridid=\"151\">") ;
            sStyleString = "" ;
            if ( subGridpacientefamiliar_Visible == 0 )
            {
               sStyleString += "display:none;" ;
            }
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridpacientefamiliar_Internalname, subGridpacientefamiliar_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridpacientefamiliarContainer.AddObjectProperty("GridName", "Gridpacientefamiliar");
         }
         else
         {
            GridpacientefamiliarContainer.AddObjectProperty("GridName", "Gridpacientefamiliar");
            GridpacientefamiliarContainer.AddObjectProperty("Header", subGridpacientefamiliar_Header);
            GridpacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridpacientefamiliarContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridpacientefamiliarContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("CmpContext", "");
            GridpacientefamiliarContainer.AddObjectProperty("InMasterPage", "false");
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlnombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlapellidopaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlapellidomaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtltipodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlnrodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlfechanacimiento_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCtlsexo_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridpacientefamiliarContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 151 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_151 = (int)(nGXsfl_151_idx-1) ;
         if ( GridpacientefamiliarContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV60GXV24 = nGXsfl_151_idx ;
            if ( subGridpacientefamiliar_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"GridpacientefamiliarContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridpacientefamiliar", GridpacientefamiliarContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacientefamiliarContainerData", GridpacientefamiliarContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacientefamiliarContainerData"+"V", GridpacientefamiliarContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridpacientefamiliarContainerData"+"V"+"\" value='"+GridpacientefamiliarContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablearcchivoprincipal_Internalname, divTablearcchivoprincipal_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, "Si cuenta con una historia clínica externa puede adjuntarla, si es más de un archivo comprimirlo", "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucFileuploadpaciente.setProperty("AutoUpload", Fileuploadpaciente_Autoupload);
         ucFileuploadpaciente.setProperty("HideAdditionalButtons", Fileuploadpaciente_Hideadditionalbuttons);
         ucFileuploadpaciente.setProperty("TooltipText", Fileuploadpaciente_Tooltiptext);
         ucFileuploadpaciente.setProperty("EnableUploadedFileCanceling", Fileuploadpaciente_Enableuploadedfilecanceling);
         ucFileuploadpaciente.setProperty("MaxNumberOfFiles", Fileuploadpaciente_Maxnumberoffiles);
         ucFileuploadpaciente.setProperty("AcceptedFileTypes", Fileuploadpaciente_Acceptedfiletypes);
         ucFileuploadpaciente.setProperty("UploadedFiles", AV16FileUploadPaciente);
         ucFileuploadpaciente.setProperty("FailedFiles", AV12FailedFiles);
         ucFileuploadpaciente.render(context, "fileupload", Fileuploadpaciente_Internalname, "FILEUPLOADPACIENTEContainer");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablearchivofamiliar_Internalname, divTablearchivofamiliar_Visible, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblock4_Internalname, "Si cuenta con una historia clínica externa puede adjuntarla, si es más de un archivo comprimirlo", "", "", lblTextblock4_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucFileuploadpacientefamiliar.setProperty("AutoUpload", Fileuploadpacientefamiliar_Autoupload);
         ucFileuploadpacientefamiliar.setProperty("HideAdditionalButtons", Fileuploadpacientefamiliar_Hideadditionalbuttons);
         ucFileuploadpacientefamiliar.setProperty("TooltipText", Fileuploadpacientefamiliar_Tooltiptext);
         ucFileuploadpacientefamiliar.setProperty("EnableUploadedFileCanceling", Fileuploadpacientefamiliar_Enableuploadedfilecanceling);
         ucFileuploadpacientefamiliar.setProperty("MaxNumberOfFiles", Fileuploadpacientefamiliar_Maxnumberoffiles);
         ucFileuploadpacientefamiliar.setProperty("UploadedFiles", AV17FileUploadPacienteFamiliar);
         ucFileuploadpacientefamiliar.setProperty("FailedFiles", AV12FailedFiles);
         ucFileuploadpacientefamiliar.render(context, "fileupload", Fileuploadpacientefamiliar_Internalname, "FILEUPLOADPACIENTEFAMILIARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 221,'',false,'',0)\"" ;
         ClassString = "ButtonCancelarP" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar1_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Cancelar", bttCancelar1_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e112x1_client"+"'", TempTags, "", 2, "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 223,'',false,'',0)\"" ;
         ClassString = "ButtonSiguiente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttSiguienteinfopaciente_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Siguiente", bttSiguienteinfopaciente_Jsonclick, 5, "Siguiente", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'SIGUIENTEINFORMACIONPACIENTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpagerealizarpago_title_Internalname, "Confirmar reserva de su cita", "", "", lblTabpagerealizarpago_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPReservarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPageRealizarPago") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage3table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable9_Internalname, 1, 0, "px", 0, "px", "TableTerminosCond", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTerminosycondiciones.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavTerminosycondiciones.getInternalname(), "Términos y Condiciones", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 236,'',false,'" + sGXsfl_20_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTerminosycondiciones.getInternalname(), GXutil.booltostr( AV34TerminosYCondiciones), "", "Términos y Condiciones", 1, chkavTerminosycondiciones.getEnabled(), "True", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(236, this, 'True', 'False',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,236);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 239,'',false,'',0)\"" ;
         ClassString = "ButtonCancelarP" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Cancelar", bttCancelar_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e112x1_client"+"'", TempTags, "", 2, "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 241,'',false,'',0)\"" ;
         ClassString = "ButtonAnterior" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAnteriorpagar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Anterior ", bttAnteriorpagar_Jsonclick, 7, "Anterior ", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e122x1_client"+"'", TempTags, "", 2, "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 243,'',false,'',0)\"" ;
         ClassString = "ButtonSiguiente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttPagar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Reservar Cita", bttPagar_Jsonclick, 5, "Reservar Cita", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'REALIZARPAGO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPReservarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         /* User Defined Control */
         ucDvmessage1.render(context, "dvelop.dvmessage", Dvmessage1_Internalname, "DVMESSAGE1Container");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 20 )
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
               AV37GXV1 = nGXsfl_20_idx ;
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
      if ( wbEnd == 99 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridpacienteContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV48GXV12 = nGXsfl_99_idx ;
               if ( subGridpaciente_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"GridpacienteContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridpaciente", GridpacienteContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacienteContainerData", GridpacienteContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacienteContainerData"+"V", GridpacienteContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridpacienteContainerData"+"V"+"\" value='"+GridpacienteContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 151 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridpacientefamiliarContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV60GXV24 = nGXsfl_151_idx ;
               if ( subGridpacientefamiliar_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"GridpacientefamiliarContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridpacientefamiliar", GridpacientefamiliarContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacientefamiliarContainerData", GridpacientefamiliarContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridpacientefamiliarContainerData"+"V", GridpacientefamiliarContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridpacientefamiliarContainerData"+"V"+"\" value='"+GridpacientefamiliarContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start2X2( )
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
         Form.getMeta().addItem("description", "Reservar Cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2X0( ) ;
   }

   public void ws2X2( )
   {
      start2X2( ) ;
      evt2X2( ) ;
   }

   public void evt2X2( )
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
                        else if ( GXutil.strcmp(sEvt, "VPACIENTEFAMILIARID.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132X2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'SIGUIENTEINFORMACIONPACIENTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'SiguienteInformacionPaciente' */
                           e142X2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'REALIZARPAGO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RealizarPago' */
                           e152X2 ();
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
                        if ( GXutil.strcmp(GXutil.left( sEvt, 17), "GRIDPACIENTE.LOAD") == 0 )
                        {
                           nGXsfl_99_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_994( ) ;
                           AV48GXV12 = nGXsfl_99_idx ;
                           if ( ( AV24SDTPaciente.size() >= AV48GXV12 ) && ( AV48GXV12 > 0 ) )
                           {
                              AV24SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDPACIENTE.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e162X4 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 25), "GRIDPACIENTEFAMILIAR.LOAD") == 0 )
                        {
                           nGXsfl_151_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_151_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_151_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1513( ) ;
                           AV60GXV24 = nGXsfl_151_idx ;
                           if ( ( AV25SDTPacienteFamiliar.size() >= AV60GXV24 ) && ( AV60GXV24 > 0 ) )
                           {
                              AV25SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDPACIENTEFAMILIAR.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e172X3 ();
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
                           nGXsfl_20_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_202( ) ;
                           AV37GXV1 = nGXsfl_20_idx ;
                           if ( ( AV23SDTDetalleCita.size() >= AV37GXV1 ) && ( AV37GXV1 > 0 ) )
                           {
                              AV23SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)) );
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
                                 e182X2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID5.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e192X2 ();
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

   public void we2X2( )
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

   public void pa2X2( )
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
            GX_FocusControl = cmbavCitafamiliar.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid5_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_202( ) ;
      while ( nGXsfl_20_idx <= nRC_GXsfl_20 )
      {
         sendrow_202( ) ;
         nGXsfl_20_idx = ((subGrid5_Islastpage==1)&&(nGXsfl_20_idx+1>subgrid5_fnc_recordsperpage( )) ? 1 : nGXsfl_20_idx+1) ;
         sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_202( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid5Container)) ;
      /* End function gxnrGrid5_newrow */
   }

   public void gxnrgridpacientefamiliar_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1513( ) ;
      while ( nGXsfl_151_idx <= nRC_GXsfl_151 )
      {
         sendrow_1513( ) ;
         nGXsfl_151_idx = ((subGridpacientefamiliar_Islastpage==1)&&(nGXsfl_151_idx+1>subgridpacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_151_idx+1) ;
         sGXsfl_151_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_151_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1513( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridpacientefamiliarContainer)) ;
      /* End function gxnrGridpacientefamiliar_newrow */
   }

   public void gxnrgridpaciente_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_994( ) ;
      while ( nGXsfl_99_idx <= nRC_GXsfl_99 )
      {
         sendrow_994( ) ;
         nGXsfl_99_idx = ((subGridpaciente_Islastpage==1)&&(nGXsfl_99_idx+1>subgridpaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_99_idx+1) ;
         sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_994( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridpacienteContainer)) ;
      /* End function gxnrGridpaciente_newrow */
   }

   public void gxgrgrid5_refresh( boolean AV34TerminosYCondiciones ,
                                  GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV24SDTPaciente ,
                                  GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV23SDTDetalleCita ,
                                  int AV21PacienteId ,
                                  int AV11DisponibilidadId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID5_nCurrentRecord = 0 ;
      rf2X2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid5_refresh */
   }

   public void gxgrgridpaciente_refresh( boolean AV34TerminosYCondiciones ,
                                         GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV24SDTPaciente ,
                                         GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV23SDTDetalleCita ,
                                         int AV21PacienteId ,
                                         int AV11DisponibilidadId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDPACIENTE_nCurrentRecord = 0 ;
      rf2X4( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridpaciente_refresh */
   }

   public void gxgrgridpacientefamiliar_refresh( boolean AV34TerminosYCondiciones ,
                                                 GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV24SDTPaciente ,
                                                 GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV23SDTDetalleCita ,
                                                 int AV21PacienteId ,
                                                 int AV11DisponibilidadId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDPACIENTEFAMILIAR_nCurrentRecord = 0 ;
      rf2X3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridpacientefamiliar_refresh */
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
      if ( cmbavCitafamiliar.getItemCount() > 0 )
      {
         AV8CitaFamiliar = cmbavCitafamiliar.getValidValue(AV8CitaFamiliar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CitaFamiliar", AV8CitaFamiliar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCitafamiliar.setValue( GXutil.rtrim( AV8CitaFamiliar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCitafamiliar.getInternalname(), "Values", cmbavCitafamiliar.ToJavascriptSource(), true);
      }
      if ( cmbavPacientefamiliarid.getItemCount() > 0 )
      {
         AV20PacienteFamiliarId = (int)(GXutil.lval( cmbavPacientefamiliarid.getValidValue(GXutil.trim( GXutil.str( AV20PacienteFamiliarId, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20PacienteFamiliarId), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientefamiliarid.setValue( GXutil.trim( GXutil.str( AV20PacienteFamiliarId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientefamiliarid.getInternalname(), "Values", cmbavPacientefamiliarid.ToJavascriptSource(), true);
      }
      AV34TerminosYCondiciones = GXutil.strtobool( GXutil.booltostr( AV34TerminosYCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TerminosYCondiciones", AV34TerminosYCondiciones);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2X2( ) ;
      rf2X4( ) ;
      rf2X3( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavCtlsdtinformaciondelacitaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitaid_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitanombresdoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitanombresdoctor_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitaclinica_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitaclinica_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitaclinica_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitasede_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitasede_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitasede_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      cmbavCtlsdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCtlsdtinformaciondelacitatipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCtlsdtinformaciondelacitatipoconsulta.getEnabled(), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitafecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitafecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitafecha_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitahora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitahora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitahora_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitacosto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitacosto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitacosto_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelpacienteid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacienteid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacienteid_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientenombres_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacienteapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacienteapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacienteapellidos_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientetipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientetipodocumento_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientenrodocumento_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientesexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientesexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientesexo_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacienteemail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacienteemail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacienteemail_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlid_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombres_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidopaterno_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidomaterno_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtltipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtltipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtltipodocumento_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnrodocumento_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimiento_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlsexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsexo_Enabled), 5, 0), !bGXsfl_151_Refreshing);
   }

   public void rf2X2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid5Container.ClearRows();
      }
      wbStart = (short)(20) ;
      nGXsfl_20_idx = 1 ;
      sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_202( ) ;
      bGXsfl_20_Refreshing = true ;
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
         subsflControlProps_202( ) ;
         e192X2 ();
         wbEnd = (short)(20) ;
         wb2X0( ) ;
      }
      bGXsfl_20_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2X2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV21PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21PacienteId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPACIENTE", AV24SDTPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPACIENTE", AV24SDTPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTPACIENTE", getSecureSignedToken( "", AV24SDTPaciente));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTDETALLECITA", AV23SDTDetalleCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTDETALLECITA", AV23SDTDetalleCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTDETALLECITA", getSecureSignedToken( "", AV23SDTDetalleCita));
   }

   public void rf2X3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridpacientefamiliarContainer.ClearRows();
      }
      wbStart = (short)(151) ;
      nGXsfl_151_idx = 1 ;
      sGXsfl_151_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_151_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1513( ) ;
      bGXsfl_151_Refreshing = true ;
      GridpacientefamiliarContainer.AddObjectProperty("GridName", "Gridpacientefamiliar");
      GridpacientefamiliarContainer.AddObjectProperty("CmpContext", "");
      GridpacientefamiliarContainer.AddObjectProperty("InMasterPage", "false");
      GridpacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
      GridpacientefamiliarContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridpacientefamiliarContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridpacientefamiliarContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridpacientefamiliarContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridpacientefamiliarContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridpacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
      GridpacientefamiliarContainer.setPageSize( subgridpacientefamiliar_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1513( ) ;
         e172X3 ();
         wbEnd = (short)(151) ;
         wb2X0( ) ;
      }
      bGXsfl_151_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2X3( )
   {
   }

   public void rf2X4( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridpacienteContainer.ClearRows();
      }
      wbStart = (short)(99) ;
      nGXsfl_99_idx = 1 ;
      sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_994( ) ;
      bGXsfl_99_Refreshing = true ;
      GridpacienteContainer.AddObjectProperty("GridName", "Gridpaciente");
      GridpacienteContainer.AddObjectProperty("CmpContext", "");
      GridpacienteContainer.AddObjectProperty("InMasterPage", "false");
      GridpacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Visible, (byte)(5), (byte)(0), ".", "")));
      GridpacienteContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridpacienteContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridpacienteContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridpacienteContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridpacienteContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridpacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subGridpaciente_Visible, (byte)(5), (byte)(0), ".", "")));
      GridpacienteContainer.setPageSize( subgridpaciente_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_994( ) ;
         e162X4 ();
         wbEnd = (short)(99) ;
         wb2X0( ) ;
      }
      bGXsfl_99_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2X4( )
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

   public int subgridpacientefamiliar_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridpacientefamiliar_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridpacientefamiliar_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridpacientefamiliar_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridpaciente_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridpaciente_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridpaciente_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridpaciente_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavCtlsdtinformaciondelacitaid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitaid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitaid_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitanombresdoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitanombresdoctor_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitaclinica_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitaclinica_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitaclinica_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitasede_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitasede_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitasede_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      cmbavCtlsdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCtlsdtinformaciondelacitatipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavCtlsdtinformaciondelacitatipoconsulta.getEnabled(), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitafecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitafecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitafecha_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitahora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitahora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitahora_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelacitacosto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelacitacosto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelacitacosto_Enabled), 5, 0), !bGXsfl_20_Refreshing);
      edtavCtlsdtinformaciondelpacienteid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacienteid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacienteid_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientenombres_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacienteapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacienteapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacienteapellidos_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientetipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientetipodocumento_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientenrodocumento_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacientesexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacientesexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacientesexo_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlsdtinformaciondelpacienteemail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsdtinformaciondelpacienteemail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsdtinformaciondelpacienteemail_Enabled), 5, 0), !bGXsfl_99_Refreshing);
      edtavCtlid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlid_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombres_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidopaterno_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidomaterno_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtltipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtltipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtltipodocumento_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnrodocumento_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimiento_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      edtavCtlsexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsexo_Enabled), 5, 0), !bGXsfl_151_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup2X0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e182X2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtpaciente"), AV24SDTPaciente);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtpacientefamiliar"), AV25SDTPacienteFamiliar);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtdetallecita"), AV23SDTDetalleCita);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFILEUPLOADPACIENTE"), AV16FileUploadPaciente);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFAILEDFILES"), AV12FailedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFILEUPLOADPACIENTEFAMILIAR"), AV17FileUploadPacienteFamiliar);
         /* Read saved values. */
         nRC_GXsfl_20 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_20"), ",", ".")) ;
         nRC_GXsfl_99 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_99"), ",", ".")) ;
         nRC_GXsfl_151 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_151"), ",", ".")) ;
         Fileuploadpaciente_Autoupload = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADPACIENTE_Autoupload")) ;
         Fileuploadpaciente_Hideadditionalbuttons = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADPACIENTE_Hideadditionalbuttons")) ;
         Fileuploadpaciente_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADPACIENTE_Enableuploadedfilecanceling")) ;
         Fileuploadpaciente_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "FILEUPLOADPACIENTE_Maxnumberoffiles"), ",", ".")) ;
         Fileuploadpaciente_Acceptedfiletypes = httpContext.cgiGet( "FILEUPLOADPACIENTE_Acceptedfiletypes") ;
         Fileuploadpacientefamiliar_Autoupload = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADPACIENTEFAMILIAR_Autoupload")) ;
         Fileuploadpacientefamiliar_Hideadditionalbuttons = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADPACIENTEFAMILIAR_Hideadditionalbuttons")) ;
         Fileuploadpacientefamiliar_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling")) ;
         Fileuploadpacientefamiliar_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles"), ",", ".")) ;
         Tabrealizarpago_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TABREALIZARPAGO_Pagecount"), ",", ".")) ;
         Tabrealizarpago_Class = httpContext.cgiGet( "TABREALIZARPAGO_Class") ;
         Tabrealizarpago_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TABREALIZARPAGO_Historymanagement")) ;
         nRC_GXsfl_20 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_20"), ",", ".")) ;
         nGXsfl_20_fel_idx = 0 ;
         while ( nGXsfl_20_fel_idx < nRC_GXsfl_20 )
         {
            nGXsfl_20_fel_idx = ((subGrid5_Islastpage==1)&&(nGXsfl_20_fel_idx+1>subgrid5_fnc_recordsperpage( )) ? 1 : nGXsfl_20_fel_idx+1) ;
            sGXsfl_20_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_202( ) ;
            AV37GXV1 = nGXsfl_20_fel_idx ;
            if ( ( AV23SDTDetalleCita.size() >= AV37GXV1 ) && ( AV37GXV1 > 0 ) )
            {
               AV23SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)) );
            }
         }
         if ( nGXsfl_20_fel_idx == 0 )
         {
            nGXsfl_20_idx = 1 ;
            sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_202( ) ;
         }
         nGXsfl_20_fel_idx = 1 ;
         nRC_GXsfl_99 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_99"), ",", ".")) ;
         nGXsfl_99_fel_idx = 0 ;
         while ( nGXsfl_99_fel_idx < nRC_GXsfl_99 )
         {
            nGXsfl_99_fel_idx = ((subGridpaciente_Islastpage==1)&&(nGXsfl_99_fel_idx+1>subgridpaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_99_fel_idx+1) ;
            sGXsfl_99_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_994( ) ;
            AV48GXV12 = nGXsfl_99_fel_idx ;
            if ( ( AV24SDTPaciente.size() >= AV48GXV12 ) && ( AV48GXV12 > 0 ) )
            {
               AV24SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)) );
            }
         }
         if ( nGXsfl_99_fel_idx == 0 )
         {
            nGXsfl_99_idx = 1 ;
            sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_994( ) ;
         }
         nGXsfl_99_fel_idx = 1 ;
         nRC_GXsfl_151 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_151"), ",", ".")) ;
         nGXsfl_151_fel_idx = 0 ;
         while ( nGXsfl_151_fel_idx < nRC_GXsfl_151 )
         {
            nGXsfl_151_fel_idx = ((subGridpacientefamiliar_Islastpage==1)&&(nGXsfl_151_fel_idx+1>subgridpacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_151_fel_idx+1) ;
            sGXsfl_151_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_151_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1513( ) ;
            AV60GXV24 = nGXsfl_151_fel_idx ;
            if ( ( AV25SDTPacienteFamiliar.size() >= AV60GXV24 ) && ( AV60GXV24 > 0 ) )
            {
               AV25SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)) );
            }
         }
         if ( nGXsfl_151_fel_idx == 0 )
         {
            nGXsfl_151_idx = 1 ;
            sGXsfl_151_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_151_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1513( ) ;
         }
         nGXsfl_151_fel_idx = 1 ;
         /* Read variables values. */
         cmbavCitafamiliar.setName( cmbavCitafamiliar.getInternalname() );
         cmbavCitafamiliar.setValue( httpContext.cgiGet( cmbavCitafamiliar.getInternalname()) );
         AV8CitaFamiliar = httpContext.cgiGet( cmbavCitafamiliar.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CitaFamiliar", AV8CitaFamiliar);
         cmbavPacientefamiliarid.setName( cmbavPacientefamiliarid.getInternalname() );
         cmbavPacientefamiliarid.setValue( httpContext.cgiGet( cmbavPacientefamiliarid.getInternalname()) );
         AV20PacienteFamiliarId = (int)(GXutil.lval( httpContext.cgiGet( cmbavPacientefamiliarid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20PacienteFamiliarId), 8, 0));
         AV34TerminosYCondiciones = GXutil.strtobool( httpContext.cgiGet( chkavTerminosycondiciones.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV34TerminosYCondiciones", AV34TerminosYCondiciones);
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
      e182X2 ();
      if (returnInSub) return;
   }

   public void e182X2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/PagarCita.css\">" );
      this.executeExternalObjectMethod("", false, "AV32ActualizarPagina", "ActualizarPaginaV4", new Object[] {Integer.valueOf(1)}, false);
      if ( (GXutil.strcmp("", AV31WebSession.getValue("WSPacienteId"))==0) )
      {
         callWebObject(formatLink("com.projectthani.wploginpaciente", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "ShowTab", "", new Object[] {Integer.valueOf(1)});
      this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(2)});
      AV21PacienteId = (int)(GXutil.lval( AV31WebSession.getValue("WSPacienteId"))) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21PacienteId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV21PacienteId), "ZZZZZZZ9")));
      GXt_objcol_SdtSDTInformacionDeLaCita1 = AV23SDTDetalleCita ;
      GXv_objcol_SdtSDTInformacionDeLaCita2[0] = GXt_objcol_SdtSDTInformacionDeLaCita1 ;
      new com.projectthani.prcinformaciondelacita(remoteHandle, context).execute( AV11DisponibilidadId, GXv_objcol_SdtSDTInformacionDeLaCita2) ;
      GXt_objcol_SdtSDTInformacionDeLaCita1 = GXv_objcol_SdtSDTInformacionDeLaCita2[0] ;
      AV23SDTDetalleCita = GXt_objcol_SdtSDTInformacionDeLaCita1 ;
      gx_BV20 = true ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = AV24SDTPaciente ;
      GXv_objcol_SdtSDTInformacionDelPaciente4[0] = GXt_objcol_SdtSDTInformacionDelPaciente3 ;
      new com.projectthani.prcinformaciondelpaciente(remoteHandle, context).execute( AV21PacienteId, GXv_objcol_SdtSDTInformacionDelPaciente4) ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = GXv_objcol_SdtSDTInformacionDelPaciente4[0] ;
      AV24SDTPaciente = GXt_objcol_SdtSDTInformacionDelPaciente3 ;
      gx_BV99 = true ;
      subGridpaciente_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridpacienteContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridpaciente_Visible), 5, 0), true);
      subGridpacientefamiliar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridpacientefamiliarContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridpacientefamiliar_Visible), 5, 0), true);
      cmbavPacientefamiliarid.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPacientefamiliarid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavPacientefamiliarid.getVisible(), 5, 0), true);
      divTablearcchivoprincipal_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablearcchivoprincipal_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablearcchivoprincipal_Visible), 5, 0), true);
      divTablearchivofamiliar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divTablearchivofamiliar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divTablearchivofamiliar_Visible), 5, 0), true);
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[0] = AV14FamiliarList ;
      new com.projectthani.prcgetlistadopacientefamiliarcombobox(remoteHandle, context).execute( AV21PacienteId, GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5) ;
      AV14FamiliarList = GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[0] ;
      AV72GXV36 = 1 ;
      while ( AV72GXV36 <= AV14FamiliarList.size() )
      {
         AV13FamiliarItem = (com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)((com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)AV14FamiliarList.elementAt(-1+AV72GXV36));
         cmbavPacientefamiliarid.addItem(GXutil.trim( GXutil.str( AV13FamiliarItem.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid(), 8, 0)), AV13FamiliarItem.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos(), (short)(0));
         AV72GXV36 = (int)(AV72GXV36+1) ;
      }
   }

   public void e132X2( )
   {
      AV60GXV24 = nGXsfl_151_idx ;
      if ( AV25SDTPacienteFamiliar.size() >= AV60GXV24 )
      {
         AV25SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)) );
      }
      /* Pacientefamiliarid_Controlvaluechanged Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTInformacionDelPacienteFamiliar6[0] = AV25SDTPacienteFamiliar ;
      new com.projectthani.prcgetpacientefamiliarporpaciente(remoteHandle, context).execute( AV21PacienteId, AV20PacienteFamiliarId, GXv_objcol_SdtSDTInformacionDelPacienteFamiliar6) ;
      AV25SDTPacienteFamiliar = GXv_objcol_SdtSDTInformacionDelPacienteFamiliar6[0] ;
      gx_BV151 = true ;
      /*  Sending Event outputs  */
      if ( gx_BV151 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV25SDTPacienteFamiliar", AV25SDTPacienteFamiliar);
         nGXsfl_151_bak_idx = nGXsfl_151_idx ;
         gxgrgridpacientefamiliar_refresh( AV34TerminosYCondiciones, AV24SDTPaciente, AV23SDTDetalleCita, AV21PacienteId, AV11DisponibilidadId) ;
         nGXsfl_151_idx = nGXsfl_151_bak_idx ;
         sGXsfl_151_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_151_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1513( ) ;
      }
   }

   public void e142X2( )
   {
      AV60GXV24 = nGXsfl_151_idx ;
      if ( AV25SDTPacienteFamiliar.size() >= AV60GXV24 )
      {
         AV25SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)) );
      }
      AV48GXV12 = nGXsfl_99_idx ;
      if ( AV24SDTPaciente.size() >= AV48GXV12 )
      {
         AV24SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)) );
      }
      /* 'SiguienteInformacionPaciente' Routine */
      returnInSub = false ;
      AV6CheckResult = true ;
      if ( GXutil.strcmp(AV8CitaFamiliar, "No") == 0 )
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso())==0) )
         {
            AV6CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Peso no debe esta vacío.", "notice", "", "true"));
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura())==0) )
         {
            AV6CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Estatura no debe esta vacío.", "notice", "", "true"));
         }
         if ( (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta())==0) )
         {
            AV6CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Motivo consulta no debe esta vacío.", "notice", "", "true"));
         }
      }
      else if ( GXutil.strcmp(AV8CitaFamiliar, "Si") == 0 )
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso())==0) )
         {
            AV6CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Peso no debe esta vacío.", "notice", "", "true"));
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura())==0) )
         {
            AV6CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Estatura no debe esta vacío.", "notice", "", "true"));
         }
         if ( (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta())==0) )
         {
            AV6CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Motivo consulta no debe esta vacío.", "notice", "", "true"));
         }
      }
      if ( AV6CheckResult )
      {
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "ShowTab", "", new Object[] {Integer.valueOf(2)});
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(1)});
      }
   }

   public void e152X2( )
   {
      AV37GXV1 = nGXsfl_20_idx ;
      if ( AV23SDTDetalleCita.size() >= AV37GXV1 )
      {
         AV23SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)) );
      }
      AV60GXV24 = nGXsfl_151_idx ;
      if ( AV25SDTPacienteFamiliar.size() >= AV60GXV24 )
      {
         AV25SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)) );
      }
      AV48GXV12 = nGXsfl_99_idx ;
      if ( AV24SDTPaciente.size() >= AV48GXV12 )
      {
         AV24SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)) );
      }
      /* 'RealizarPago' Routine */
      returnInSub = false ;
      httpContext.GX_msglist.addItem(GXutil.booltostr( AV34TerminosYCondiciones));
      if ( AV34TerminosYCondiciones )
      {
         /* Execute user subroutine: 'CREATECITA' */
         S112 ();
         if (returnInSub) return;
         this.executeExternalObjectMethod("", false, "AV32ActualizarPagina", "ActualizarPaginaV4", new Object[] {Integer.valueOf(2)}, false);
      }
      else
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "Debe aceptar los términos y condiciones para reservar su cita.", "notice", "", "true"));
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV7Cita", AV7Cita);
   }

   public void S112( )
   {
      /* 'CREATECITA' Routine */
      returnInSub = false ;
      AV28TempNombreDoctor = ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor() ;
      AV26TempFechaCita = localUtil.dtoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), 3, "/") ;
      AV27TempHoraCita = ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora() ;
      AV19isEstadoMensaje = (short)(0) ;
      if ( ( AV21PacienteId > 0 ) && ( AV11DisponibilidadId > 0 ) )
      {
         if ( new com.projectthani.prcvalidardisponibilidadcita(remoteHandle, context).executeUdp( AV11DisponibilidadId) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            if ( GXutil.strcmp(AV8CitaFamiliar, "Si") == 0 )
            {
               AV7Cita.setgxTv_SdtCita_Pacienteid( AV20PacienteFamiliarId );
               AV7Cita.setgxTv_SdtCita_Citamotivoconsulta( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta() );
               AV7Cita.setgxTv_SdtCita_Citapeso( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso() );
               AV7Cita.setgxTv_SdtCita_Citaestatura( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura() );
               if ( AV17FileUploadPacienteFamiliar.size() > 0 )
               {
                  AV7Cita.setgxTv_SdtCita_Citaarchivo( ((com.projectthani.SdtFileUploadData)AV17FileUploadPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
                  AV7Cita.setgxTv_SdtCita_Citaarchivonombre( ((com.projectthani.SdtFileUploadData)AV17FileUploadPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtFileUploadData_Name() );
                  AV7Cita.setgxTv_SdtCita_Citaarchivoextencion( ((com.projectthani.SdtFileUploadData)AV17FileUploadPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtFileUploadData_Extension() );
               }
            }
            else
            {
               AV7Cita.setgxTv_SdtCita_Pacienteid( AV21PacienteId );
               AV7Cita.setgxTv_SdtCita_Citamotivoconsulta( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta() );
               AV7Cita.setgxTv_SdtCita_Citapeso( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso() );
               AV7Cita.setgxTv_SdtCita_Citaestatura( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura() );
               if ( AV16FileUploadPaciente.size() > 0 )
               {
                  AV7Cita.setgxTv_SdtCita_Citaarchivo( ((com.projectthani.SdtFileUploadData)AV16FileUploadPaciente.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
                  AV7Cita.setgxTv_SdtCita_Citaarchivonombre( ((com.projectthani.SdtFileUploadData)AV16FileUploadPaciente.elementAt(-1+1)).getgxTv_SdtFileUploadData_Name() );
                  AV7Cita.setgxTv_SdtCita_Citaarchivoextencion( ((com.projectthani.SdtFileUploadData)AV16FileUploadPaciente.elementAt(-1+1)).getgxTv_SdtFileUploadData_Extension() );
               }
            }
            AV7Cita.setgxTv_SdtCita_Sgcitadisponibilidadid( AV11DisponibilidadId );
            AV7Cita.setgxTv_SdtCita_Citafechareserva( GXutil.now( ) );
            AV7Cita.setgxTv_SdtCita_Citaestado( "A" );
            AV7Cita.setgxTv_SdtCita_Citaestadopago( "G" );
            AV7Cita.setgxTv_SdtCita_Citaestadocita( "R" );
            GXt_char7 = AV30Valor ;
            GXv_char8[0] = GXt_char7 ;
            new com.projectthani.prcgenerarcodigocita(remoteHandle, context).execute( AV11DisponibilidadId, GXv_char8) ;
            wpreservarcita_impl.this.GXt_char7 = GXv_char8[0] ;
            AV30Valor = GXt_char7 ;
            GXt_char7 = AV10CodigoCita ;
            GXv_char8[0] = GXt_char7 ;
            new com.projectthani.prcgenerarcodigocitavideo(remoteHandle, context).execute( AV30Valor, GXv_char8) ;
            wpreservarcita_impl.this.GXt_char7 = GXv_char8[0] ;
            AV10CodigoCita = GXt_char7 ;
            AV7Cita.setgxTv_SdtCita_Citacode( AV10CodigoCita );
            AV7Cita.Save();
            if ( AV7Cita.Success() )
            {
               AV5Disponibilidad.Load(AV11DisponibilidadId);
               AV5Disponibilidad.setgxTv_SdtDisponibilidad_Disponibilidadestadocita( "O" );
               AV5Disponibilidad.Save();
               new com.projectthani.prcinformecitacorreo(remoteHandle, context).execute( AV7Cita.getgxTv_SdtCita_Citaid()) ;
               AV19isEstadoMensaje = (short)(1) ;
               callWebObject(formatLink("com.projectthani.wpmensajeestadoreserva", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV19isEstadoMensaje,4,0)),GXutil.URLEncode(GXutil.rtrim(AV28TempNombreDoctor)),GXutil.URLEncode(GXutil.rtrim(AV26TempFechaCita)),GXutil.URLEncode(GXutil.rtrim(AV27TempHoraCita)),GXutil.URLEncode(GXutil.ltrimstr(AV7Cita.getgxTv_SdtCita_Citaid(),8,0))}, new String[] {"EstadoReservaCita","NombresDoctor","TempFechaCita","HoraCita","CitaId"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
               Application.commitDataStores(context, remoteHandle, pr_default, "wpreservarcita");
            }
            else
            {
               Application.rollbackDataStores(context, remoteHandle, pr_default, "wpreservarcita");
               AV19isEstadoMensaje = (short)(2) ;
               callWebObject(formatLink("com.projectthani.wpmensajeestadoreserva", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV19isEstadoMensaje,4,0)),GXutil.URLEncode(GXutil.rtrim(AV28TempNombreDoctor)),GXutil.URLEncode(GXutil.rtrim(AV26TempFechaCita)),GXutil.URLEncode(GXutil.rtrim(AV27TempHoraCita)),GXutil.URLEncode(GXutil.ltrimstr(AV7Cita.getgxTv_SdtCita_Citaid(),8,0))}, new String[] {"EstadoReservaCita","NombresDoctor","TempFechaCita","HoraCita","CitaId"}) );
               httpContext.wjLocDisableFrm = (byte)(1) ;
            }
         }
         else
         {
            AV19isEstadoMensaje = (short)(3) ;
            callWebObject(formatLink("com.projectthani.wpmensajeestadoreserva", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV19isEstadoMensaje,4,0)),GXutil.URLEncode(GXutil.rtrim(AV28TempNombreDoctor)),GXutil.URLEncode(GXutil.rtrim(AV26TempFechaCita)),GXutil.URLEncode(GXutil.rtrim(AV27TempHoraCita)),GXutil.URLEncode(GXutil.ltrimstr(AV7Cita.getgxTv_SdtCita_Citaid(),8,0))}, new String[] {"EstadoReservaCita","NombresDoctor","TempFechaCita","HoraCita","CitaId"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      else
      {
         AV19isEstadoMensaje = (short)(3) ;
         callWebObject(formatLink("com.projectthani.wpmensajeestadoreserva", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV19isEstadoMensaje,4,0)),GXutil.URLEncode(GXutil.rtrim(AV28TempNombreDoctor)),GXutil.URLEncode(GXutil.rtrim(AV26TempFechaCita)),GXutil.URLEncode(GXutil.rtrim(AV27TempHoraCita)),GXutil.URLEncode(GXutil.ltrimstr(AV7Cita.getgxTv_SdtCita_Citaid(),8,0))}, new String[] {"EstadoReservaCita","NombresDoctor","TempFechaCita","HoraCita","CitaId"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
   }

   private void e192X2( )
   {
      /* Grid5_Load Routine */
      returnInSub = false ;
      AV37GXV1 = 1 ;
      while ( AV37GXV1 <= AV23SDTDetalleCita.size() )
      {
         AV23SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(20) ;
         }
         sendrow_202( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_20_Refreshing )
         {
            httpContext.doAjaxLoad(20, Grid5Row);
         }
         AV37GXV1 = (int)(AV37GXV1+1) ;
      }
   }

   private void e172X3( )
   {
      /* Gridpacientefamiliar_Load Routine */
      returnInSub = false ;
      AV60GXV24 = 1 ;
      while ( AV60GXV24 <= AV25SDTPacienteFamiliar.size() )
      {
         AV25SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(151) ;
         }
         sendrow_1513( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_151_Refreshing )
         {
            httpContext.doAjaxLoad(151, GridpacientefamiliarRow);
         }
         AV60GXV24 = (int)(AV60GXV24+1) ;
      }
   }

   private void e162X4( )
   {
      /* Gridpaciente_Load Routine */
      returnInSub = false ;
      AV48GXV12 = 1 ;
      while ( AV48GXV12 <= AV24SDTPaciente.size() )
      {
         AV24SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(99) ;
         }
         sendrow_994( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_99_Refreshing )
         {
            httpContext.doAjaxLoad(99, GridpacienteRow);
         }
         AV48GXV12 = (int)(AV48GXV12+1) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV11DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11DisponibilidadId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11DisponibilidadId), "ZZZZZZZ9")));
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
      pa2X2( ) ;
      ws2X2( ) ;
      we2X2( ) ;
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
      httpContext.AddStyleSheetFile("FileUpload/fileupload.min.css", "");
      httpContext.AddStyleSheetFile("FileUpload/fileupload.min.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110335237", true, true);
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
      httpContext.AddJavascriptSource("wpreservarcita.js", "?20225110335238", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_202( )
   {
      edtavCtlsdtinformaciondelacitaid_Internalname = "CTLSDTINFORMACIONDELACITAID_"+sGXsfl_20_idx ;
      edtavCtlsdtinformaciondelacitafotografiadoctor_Internalname = "CTLSDTINFORMACIONDELACITAFOTOGRAFIADOCTOR_"+sGXsfl_20_idx ;
      edtavCtlsdtinformaciondelacitanombresdoctor_Internalname = "CTLSDTINFORMACIONDELACITANOMBRESDOCTOR_"+sGXsfl_20_idx ;
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname = "CTLSDTINFORMACIONDELACITAESPECIALIDADDOCTOR_"+sGXsfl_20_idx ;
      edtavCtlsdtinformaciondelacitaclinica_Internalname = "CTLSDTINFORMACIONDELACITACLINICA_"+sGXsfl_20_idx ;
      edtavCtlsdtinformaciondelacitasede_Internalname = "CTLSDTINFORMACIONDELACITASEDE_"+sGXsfl_20_idx ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setInternalname( "CTLSDTINFORMACIONDELACITATIPOCONSULTA_"+sGXsfl_20_idx );
      edtavCtlsdtinformaciondelacitafecha_Internalname = "CTLSDTINFORMACIONDELACITAFECHA_"+sGXsfl_20_idx ;
      edtavCtlsdtinformaciondelacitahora_Internalname = "CTLSDTINFORMACIONDELACITAHORA_"+sGXsfl_20_idx ;
      edtavCtlsdtinformaciondelacitacosto_Internalname = "CTLSDTINFORMACIONDELACITACOSTO_"+sGXsfl_20_idx ;
   }

   public void subsflControlProps_fel_202( )
   {
      edtavCtlsdtinformaciondelacitaid_Internalname = "CTLSDTINFORMACIONDELACITAID_"+sGXsfl_20_fel_idx ;
      edtavCtlsdtinformaciondelacitafotografiadoctor_Internalname = "CTLSDTINFORMACIONDELACITAFOTOGRAFIADOCTOR_"+sGXsfl_20_fel_idx ;
      edtavCtlsdtinformaciondelacitanombresdoctor_Internalname = "CTLSDTINFORMACIONDELACITANOMBRESDOCTOR_"+sGXsfl_20_fel_idx ;
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname = "CTLSDTINFORMACIONDELACITAESPECIALIDADDOCTOR_"+sGXsfl_20_fel_idx ;
      edtavCtlsdtinformaciondelacitaclinica_Internalname = "CTLSDTINFORMACIONDELACITACLINICA_"+sGXsfl_20_fel_idx ;
      edtavCtlsdtinformaciondelacitasede_Internalname = "CTLSDTINFORMACIONDELACITASEDE_"+sGXsfl_20_fel_idx ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setInternalname( "CTLSDTINFORMACIONDELACITATIPOCONSULTA_"+sGXsfl_20_fel_idx );
      edtavCtlsdtinformaciondelacitafecha_Internalname = "CTLSDTINFORMACIONDELACITAFECHA_"+sGXsfl_20_fel_idx ;
      edtavCtlsdtinformaciondelacitahora_Internalname = "CTLSDTINFORMACIONDELACITAHORA_"+sGXsfl_20_fel_idx ;
      edtavCtlsdtinformaciondelacitacosto_Internalname = "CTLSDTINFORMACIONDELACITACOSTO_"+sGXsfl_20_fel_idx ;
   }

   public void sendrow_202( )
   {
      subsflControlProps_202( ) ;
      wb2X0( ) ;
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
         if ( ((int)((nGXsfl_20_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subGrid5_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_20_idx+"\">") ;
      }
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid5table_Internalname+"_"+sGXsfl_20_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaid_Internalname,"SDTInformacion De La Cita Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlsdtinformaciondelacitaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitaid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitaid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","Center","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divTable1_Internalname+"_"+sGXsfl_20_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","TableBorderImgenMedico","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {"","SDTInformacion De La Cita Fotografia Doctor","col-sm-3 ImageDoctorPCLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Static Bitmap Variable */
      ClassString = "ImageDoctorPC" ;
      StyleString = "" ;
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor()) ;
      Grid5Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitafotografiadoctor_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"Center","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitanombresdoctor_Internalname,"SDTInformacion De La Cita Nombres Doctor","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Multiple line edit */
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      Grid5Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitanombresdoctor_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitanombresdoctor_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableRowDC","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname,"Especialidad:","col-sm-3 col-lg-6 AttDetalleCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 col-lg-6 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttDetalleCita" ;
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitaespecialidaddoctor_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableRowDC","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelacitaclinica_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaclinica_Internalname,"Clinica:","col-sm-3 col-lg-6 AttDetalleCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 col-lg-6 gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "AttDetalleCita" ;
      StyleString = "" ;
      ClassString = "AttDetalleCita" ;
      StyleString = "" ;
      Grid5Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaclinica_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitaclinica_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableRowDC","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelacitasede_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitasede_Internalname,"Sede:","col-sm-3 col-lg-6 AttDetalleCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 col-lg-6 gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "AttDetalleCita" ;
      StyleString = "" ;
      ClassString = "AttDetalleCita" ;
      StyleString = "" ;
      Grid5Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitasede_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitasede_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      sendrow_20230( ) ;
   }

   public void sendrow_20230( )
   {
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableRowDC","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavCtlsdtinformaciondelacitatipoconsulta.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavCtlsdtinformaciondelacitatipoconsulta.getInternalname(),"Tipo Consulta:","col-sm-3 col-lg-6 AttDetalleCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 col-lg-6 gx-attribute","left","top","","","div"});
      if ( ( cmbavCtlsdtinformaciondelacitatipoconsulta.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CTLSDTINFORMACIONDELACITATIPOCONSULTA_" + sGXsfl_20_idx ;
         cmbavCtlsdtinformaciondelacitatipoconsulta.setName( GXCCtl );
         cmbavCtlsdtinformaciondelacitatipoconsulta.setWebtags( "" );
         cmbavCtlsdtinformaciondelacitatipoconsulta.addItem("V", "Virtual", (short)(0));
         cmbavCtlsdtinformaciondelacitatipoconsulta.addItem("P", "En consultorio", (short)(0));
         cmbavCtlsdtinformaciondelacitatipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
         if ( cmbavCtlsdtinformaciondelacitatipoconsulta.getItemCount() > 0 )
         {
            if ( ( AV37GXV1 > 0 ) && ( AV23SDTDetalleCita.size() >= AV37GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta())==0) )
            {
               ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( cmbavCtlsdtinformaciondelacitatipoconsulta.getValidValue(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
            }
         }
      }
      /* ComboBox */
      Grid5Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavCtlsdtinformaciondelacitatipoconsulta,cmbavCtlsdtinformaciondelacitatipoconsulta.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()),Integer.valueOf(1),cmbavCtlsdtinformaciondelacitatipoconsulta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavCtlsdtinformaciondelacitatipoconsulta.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","AttDetalleCita","","","","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavCtlsdtinformaciondelacitatipoconsulta.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCtlsdtinformaciondelacitatipoconsulta.getInternalname(), "Values", cmbavCtlsdtinformaciondelacitatipoconsulta.ToJavascriptSource(), !bGXsfl_20_Refreshing);
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableRowDC","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelacitafecha_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitafecha_Internalname,"Fecha:","col-sm-3 col-lg-6 AttDetalleCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 col-lg-6 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttDetalleCita" ;
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitafecha_Internalname,localUtil.format(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitafecha_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitafecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableRowDC","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelacitahora_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitahora_Internalname,"Hora:","col-sm-3 col-lg-6 AttDetalleCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 col-lg-6 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttDetalleCita" ;
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitahora_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitahora_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitahora_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableRowDC","left","top","","","div"});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelacitacosto_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      Grid5Row.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitacosto_Internalname,"Costo Cita:","col-sm-3 col-lg-6 AttDetalleCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      Grid5Row.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-9 col-lg-6 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttDetalleCita" ;
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitacosto_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlsdtinformaciondelacitacosto_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitacosto_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitacosto_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes2X2( ) ;
      /* End of Columns property logic. */
      Grid5Container.AddRow(Grid5Row);
      nGXsfl_20_idx = ((subGrid5_Islastpage==1)&&(nGXsfl_20_idx+1>subgrid5_fnc_recordsperpage( )) ? 1 : nGXsfl_20_idx+1) ;
      sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_202( ) ;
      /* End function sendrow_202 */
   }

   public void subsflControlProps_994( )
   {
      edtavCtlsdtinformaciondelpacienteid_Internalname = "CTLSDTINFORMACIONDELPACIENTEID_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacientenombres_Internalname = "CTLSDTINFORMACIONDELPACIENTENOMBRES_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacienteapellidos_Internalname = "CTLSDTINFORMACIONDELPACIENTEAPELLIDOS_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacientetipodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTETIPODOCUMENTO_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacientenrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTENRODOCUMENTO_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFECHANACIMIENTO_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacientesexo_Internalname = "CTLSDTINFORMACIONDELPACIENTESEXO_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacienteemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEEMAIL_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacientepeso_Internalname = "CTLSDTINFORMACIONDELPACIENTEPESO_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacienteestatura_Internalname = "CTLSDTINFORMACIONDELPACIENTEESTATURA_"+sGXsfl_99_idx ;
      edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname = "CTLSDTINFORMACIONDELPACIENTEMOTIVOCONSULTA_"+sGXsfl_99_idx ;
   }

   public void subsflControlProps_fel_994( )
   {
      edtavCtlsdtinformaciondelpacienteid_Internalname = "CTLSDTINFORMACIONDELPACIENTEID_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacientenombres_Internalname = "CTLSDTINFORMACIONDELPACIENTENOMBRES_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacienteapellidos_Internalname = "CTLSDTINFORMACIONDELPACIENTEAPELLIDOS_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacientetipodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTETIPODOCUMENTO_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacientenrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTENRODOCUMENTO_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFECHANACIMIENTO_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacientesexo_Internalname = "CTLSDTINFORMACIONDELPACIENTESEXO_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacienteemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEEMAIL_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacientepeso_Internalname = "CTLSDTINFORMACIONDELPACIENTEPESO_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacienteestatura_Internalname = "CTLSDTINFORMACIONDELPACIENTEESTATURA_"+sGXsfl_99_fel_idx ;
      edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname = "CTLSDTINFORMACIONDELPACIENTEMOTIVOCONSULTA_"+sGXsfl_99_fel_idx ;
   }

   public void sendrow_994( )
   {
      subsflControlProps_994( ) ;
      wb2X0( ) ;
      GridpacienteRow = GXWebRow.GetNew(context,GridpacienteContainer) ;
      if ( subGridpaciente_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridpaciente_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridpaciente_Class, "") != 0 )
         {
            subGridpaciente_Linesclass = subGridpaciente_Class+"Odd" ;
         }
      }
      else if ( subGridpaciente_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridpaciente_Backstyle = (byte)(0) ;
         subGridpaciente_Backcolor = subGridpaciente_Allbackcolor ;
         if ( GXutil.strcmp(subGridpaciente_Class, "") != 0 )
         {
            subGridpaciente_Linesclass = subGridpaciente_Class+"Uniform" ;
         }
      }
      else if ( subGridpaciente_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridpaciente_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridpaciente_Class, "") != 0 )
         {
            subGridpaciente_Linesclass = subGridpaciente_Class+"Odd" ;
         }
         subGridpaciente_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridpaciente_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridpaciente_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_99_idx) % (2))) == 0 )
         {
            subGridpaciente_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridpaciente_Class, "") != 0 )
            {
               subGridpaciente_Linesclass = subGridpaciente_Class+"Even" ;
            }
         }
         else
         {
            subGridpaciente_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridpaciente_Class, "") != 0 )
            {
               subGridpaciente_Linesclass = subGridpaciente_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridpacienteContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridpaciente_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_99_idx+"\">") ;
      }
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid2table_Internalname+"_"+sGXsfl_99_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteid_Internalname,"Paciente Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid(), (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlsdtinformaciondelpacienteid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacienteid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacienteid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientenombres_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientenombres_Internalname,"Nombres","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientenombres_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientenombres_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientenombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacienteapellidos_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteapellidos_Internalname,"Apellidos","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "AttributePagarCita" ;
      StyleString = "" ;
      ClassString = "AttributePagarCita" ;
      StyleString = "" ;
      GridpacienteRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteapellidos_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacienteapellidos_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(4),"row",StyleString,ClassString,"","","250",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientetipodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientetipodocumento_Internalname,"Tipo Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientetipodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientetipodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientetipodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientenrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientenrodocumento_Internalname,"Nro Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientenrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientenrodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientenrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname,"Fecha Nacimiento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefechanacimiento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientesexo_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientesexo_Internalname,"Sexo","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientesexo_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientesexo_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientesexo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      sendrow_99430( ) ;
   }

   public void sendrow_99430( )
   {
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacienteemail_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteemail_Internalname,"Correo","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteemail_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacienteemail_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacienteemail_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientepeso_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientepeso_Internalname,"Peso","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientepeso_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientepeso_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 139,'',false,'"+sGXsfl_99_idx+"',99)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientepeso_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso(), "ZZ9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientepeso_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientepeso_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,139);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientepeso_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacienteestatura_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteestatura_Internalname,"Estatura","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacienteestatura_Enabled!=0)&&(edtavCtlsdtinformaciondelpacienteestatura_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 143,'',false,'"+sGXsfl_99_idx+"',99)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteestatura_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura(), (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura(), "9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacienteestatura_Enabled!=0)&&(edtavCtlsdtinformaciondelpacienteestatura_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,143);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacienteestatura_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname,"Motivo Consulta","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientemotivoconsulta_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientemotivoconsulta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 148,'',false,'"+sGXsfl_99_idx+"',99)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV24SDTPaciente.elementAt(-1+AV48GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientemotivoconsulta_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientemotivoconsulta_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,148);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientemotivoconsulta_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes2X4( ) ;
      /* End of Columns property logic. */
      GridpacienteContainer.AddRow(GridpacienteRow);
      nGXsfl_99_idx = ((subGridpaciente_Islastpage==1)&&(nGXsfl_99_idx+1>subgridpaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_99_idx+1) ;
      sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_994( ) ;
      /* End function sendrow_994 */
   }

   public void subsflControlProps_1513( )
   {
      edtavCtlid_Internalname = "CTLID_"+sGXsfl_151_idx ;
      edtavCtlnombres_Internalname = "CTLNOMBRES_"+sGXsfl_151_idx ;
      edtavCtlapellidopaterno_Internalname = "CTLAPELLIDOPATERNO_"+sGXsfl_151_idx ;
      edtavCtlapellidomaterno_Internalname = "CTLAPELLIDOMATERNO_"+sGXsfl_151_idx ;
      edtavCtltipodocumento_Internalname = "CTLTIPODOCUMENTO_"+sGXsfl_151_idx ;
      edtavCtlnrodocumento_Internalname = "CTLNRODOCUMENTO_"+sGXsfl_151_idx ;
      edtavCtlfechanacimiento_Internalname = "CTLFECHANACIMIENTO_"+sGXsfl_151_idx ;
      edtavCtlsexo_Internalname = "CTLSEXO_"+sGXsfl_151_idx ;
      edtavCtlestatura_Internalname = "CTLESTATURA_"+sGXsfl_151_idx ;
      edtavCtlpeso_Internalname = "CTLPESO_"+sGXsfl_151_idx ;
      edtavCtlmotivoconsulta_Internalname = "CTLMOTIVOCONSULTA_"+sGXsfl_151_idx ;
   }

   public void subsflControlProps_fel_1513( )
   {
      edtavCtlid_Internalname = "CTLID_"+sGXsfl_151_fel_idx ;
      edtavCtlnombres_Internalname = "CTLNOMBRES_"+sGXsfl_151_fel_idx ;
      edtavCtlapellidopaterno_Internalname = "CTLAPELLIDOPATERNO_"+sGXsfl_151_fel_idx ;
      edtavCtlapellidomaterno_Internalname = "CTLAPELLIDOMATERNO_"+sGXsfl_151_fel_idx ;
      edtavCtltipodocumento_Internalname = "CTLTIPODOCUMENTO_"+sGXsfl_151_fel_idx ;
      edtavCtlnrodocumento_Internalname = "CTLNRODOCUMENTO_"+sGXsfl_151_fel_idx ;
      edtavCtlfechanacimiento_Internalname = "CTLFECHANACIMIENTO_"+sGXsfl_151_fel_idx ;
      edtavCtlsexo_Internalname = "CTLSEXO_"+sGXsfl_151_fel_idx ;
      edtavCtlestatura_Internalname = "CTLESTATURA_"+sGXsfl_151_fel_idx ;
      edtavCtlpeso_Internalname = "CTLPESO_"+sGXsfl_151_fel_idx ;
      edtavCtlmotivoconsulta_Internalname = "CTLMOTIVOCONSULTA_"+sGXsfl_151_fel_idx ;
   }

   public void sendrow_1513( )
   {
      subsflControlProps_1513( ) ;
      wb2X0( ) ;
      GridpacientefamiliarRow = GXWebRow.GetNew(context,GridpacientefamiliarContainer) ;
      if ( subGridpacientefamiliar_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridpacientefamiliar_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridpacientefamiliar_Class, "") != 0 )
         {
            subGridpacientefamiliar_Linesclass = subGridpacientefamiliar_Class+"Odd" ;
         }
      }
      else if ( subGridpacientefamiliar_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridpacientefamiliar_Backstyle = (byte)(0) ;
         subGridpacientefamiliar_Backcolor = subGridpacientefamiliar_Allbackcolor ;
         if ( GXutil.strcmp(subGridpacientefamiliar_Class, "") != 0 )
         {
            subGridpacientefamiliar_Linesclass = subGridpacientefamiliar_Class+"Uniform" ;
         }
      }
      else if ( subGridpacientefamiliar_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridpacientefamiliar_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridpacientefamiliar_Class, "") != 0 )
         {
            subGridpacientefamiliar_Linesclass = subGridpacientefamiliar_Class+"Odd" ;
         }
         subGridpacientefamiliar_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridpacientefamiliar_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridpacientefamiliar_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_151_idx) % (2))) == 0 )
         {
            subGridpacientefamiliar_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridpacientefamiliar_Class, "") != 0 )
            {
               subGridpacientefamiliar_Linesclass = subGridpacientefamiliar_Class+"Even" ;
            }
         }
         else
         {
            subGridpacientefamiliar_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridpacientefamiliar_Class, "") != 0 )
            {
               subGridpacientefamiliar_Linesclass = subGridpacientefamiliar_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridpacientefamiliarContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridpacientefamiliar_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_151_idx+"\">") ;
      }
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid3table_Internalname+"_"+sGXsfl_151_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 hidden-xs hidden-sm hidden-md hidden-lg","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlid_Internalname,"Paciente Id","col-sm-3 AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),""});
      /* Single line edit */
      ROClassString = "Attribute" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id(), (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlnombres_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlnombres_Internalname,"Nombres","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlnombres_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlnombres_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlnombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlapellidopaterno_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlapellidopaterno_Internalname,"Apellido Paterno","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlapellidopaterno_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlapellidopaterno_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlapellidopaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlapellidomaterno_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlapellidomaterno_Internalname,"Apellido Materno","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlapellidomaterno_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlapellidomaterno_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlapellidomaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtltipodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtltipodocumento_Internalname,"Tipo Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtltipodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtltipodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtltipodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlnrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlnrodocumento_Internalname,"Nro Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlnrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlnrodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlnrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlfechanacimiento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlfechanacimiento_Internalname,"Fecha Nacimiento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlfechanacimiento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlfechanacimiento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlfechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      sendrow_151330( ) ;
   }

   public void sendrow_151330( )
   {
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsexo_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsexo_Internalname,"Sexo","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsexo_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsexo_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsexo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlestatura_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlestatura_Internalname,"Estatura","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlestatura_Enabled!=0)&&(edtavCtlestatura_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 191,'',false,'"+sGXsfl_151_idx+"',151)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlestatura_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura(), (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura(), "9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlestatura_Enabled!=0)&&(edtavCtlestatura_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,191);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlestatura_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlpeso_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlpeso_Internalname,"Peso","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlpeso_Enabled!=0)&&(edtavCtlpeso_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 195,'',false,'"+sGXsfl_151_idx+"',151)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlpeso_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso(), "ZZ9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlpeso_Enabled!=0)&&(edtavCtlpeso_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,195);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlpeso_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlmotivoconsulta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridpacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlmotivoconsulta_Internalname,"Motivo Consulta","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlmotivoconsulta_Enabled!=0)&&(edtavCtlmotivoconsulta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 200,'',false,'"+sGXsfl_151_idx+"',151)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlmotivoconsulta_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV25SDTPacienteFamiliar.elementAt(-1+AV60GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlmotivoconsulta_Enabled!=0)&&(edtavCtlmotivoconsulta_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,200);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlmotivoconsulta_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(151),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes2X3( ) ;
      /* End of Columns property logic. */
      GridpacientefamiliarContainer.AddRow(GridpacientefamiliarRow);
      nGXsfl_151_idx = ((subGridpacientefamiliar_Islastpage==1)&&(nGXsfl_151_idx+1>subgridpacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_151_idx+1) ;
      sGXsfl_151_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_151_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1513( ) ;
      /* End function sendrow_1513 */
   }

   public void init_default_properties( )
   {
      lblTextblockinfocita_Internalname = "TEXTBLOCKINFOCITA" ;
      divSeparador_Internalname = "SEPARADOR" ;
      edtavCtlsdtinformaciondelacitaid_Internalname = "CTLSDTINFORMACIONDELACITAID" ;
      edtavCtlsdtinformaciondelacitafotografiadoctor_Internalname = "CTLSDTINFORMACIONDELACITAFOTOGRAFIADOCTOR" ;
      divTable1_Internalname = "TABLE1" ;
      edtavCtlsdtinformaciondelacitanombresdoctor_Internalname = "CTLSDTINFORMACIONDELACITANOMBRESDOCTOR" ;
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname = "CTLSDTINFORMACIONDELACITAESPECIALIDADDOCTOR" ;
      edtavCtlsdtinformaciondelacitaclinica_Internalname = "CTLSDTINFORMACIONDELACITACLINICA" ;
      edtavCtlsdtinformaciondelacitasede_Internalname = "CTLSDTINFORMACIONDELACITASEDE" ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setInternalname( "CTLSDTINFORMACIONDELACITATIPOCONSULTA" );
      edtavCtlsdtinformaciondelacitafecha_Internalname = "CTLSDTINFORMACIONDELACITAFECHA" ;
      edtavCtlsdtinformaciondelacitahora_Internalname = "CTLSDTINFORMACIONDELACITAHORA" ;
      edtavCtlsdtinformaciondelacitacosto_Internalname = "CTLSDTINFORMACIONDELACITACOSTO" ;
      divGrid5table_Internalname = "GRID5TABLE" ;
      divTable4_Internalname = "TABLE4" ;
      divTable2_Internalname = "TABLE2" ;
      lblTabpageinformacionpaciente_title_Internalname = "TABPAGEINFORMACIONPACIENTE_TITLE" ;
      cmbavCitafamiliar.setInternalname( "vCITAFAMILIAR" );
      cmbavPacientefamiliarid.setInternalname( "vPACIENTEFAMILIARID" );
      divTable5_Internalname = "TABLE5" ;
      edtavCtlsdtinformaciondelpacienteid_Internalname = "CTLSDTINFORMACIONDELPACIENTEID" ;
      edtavCtlsdtinformaciondelpacientenombres_Internalname = "CTLSDTINFORMACIONDELPACIENTENOMBRES" ;
      edtavCtlsdtinformaciondelpacienteapellidos_Internalname = "CTLSDTINFORMACIONDELPACIENTEAPELLIDOS" ;
      edtavCtlsdtinformaciondelpacientetipodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTETIPODOCUMENTO" ;
      edtavCtlsdtinformaciondelpacientenrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTENRODOCUMENTO" ;
      edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFECHANACIMIENTO" ;
      edtavCtlsdtinformaciondelpacientesexo_Internalname = "CTLSDTINFORMACIONDELPACIENTESEXO" ;
      edtavCtlsdtinformaciondelpacienteemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEEMAIL" ;
      edtavCtlsdtinformaciondelpacientepeso_Internalname = "CTLSDTINFORMACIONDELPACIENTEPESO" ;
      edtavCtlsdtinformaciondelpacienteestatura_Internalname = "CTLSDTINFORMACIONDELPACIENTEESTATURA" ;
      edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname = "CTLSDTINFORMACIONDELPACIENTEMOTIVOCONSULTA" ;
      divGrid2table_Internalname = "GRID2TABLE" ;
      edtavCtlid_Internalname = "CTLID" ;
      edtavCtlnombres_Internalname = "CTLNOMBRES" ;
      edtavCtlapellidopaterno_Internalname = "CTLAPELLIDOPATERNO" ;
      edtavCtlapellidomaterno_Internalname = "CTLAPELLIDOMATERNO" ;
      edtavCtltipodocumento_Internalname = "CTLTIPODOCUMENTO" ;
      edtavCtlnrodocumento_Internalname = "CTLNRODOCUMENTO" ;
      edtavCtlfechanacimiento_Internalname = "CTLFECHANACIMIENTO" ;
      edtavCtlsexo_Internalname = "CTLSEXO" ;
      edtavCtlestatura_Internalname = "CTLESTATURA" ;
      edtavCtlpeso_Internalname = "CTLPESO" ;
      edtavCtlmotivoconsulta_Internalname = "CTLMOTIVOCONSULTA" ;
      divGrid3table_Internalname = "GRID3TABLE" ;
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      Fileuploadpaciente_Internalname = "FILEUPLOADPACIENTE" ;
      divTablearcchivoprincipal_Internalname = "TABLEARCCHIVOPRINCIPAL" ;
      lblTextblock4_Internalname = "TEXTBLOCK4" ;
      Fileuploadpacientefamiliar_Internalname = "FILEUPLOADPACIENTEFAMILIAR" ;
      divTablearchivofamiliar_Internalname = "TABLEARCHIVOFAMILIAR" ;
      divTable6_Internalname = "TABLE6" ;
      bttCancelar1_Internalname = "CANCELAR1" ;
      bttSiguienteinfopaciente_Internalname = "SIGUIENTEINFOPACIENTE" ;
      divTabpage1table_Internalname = "TABPAGE1TABLE" ;
      lblTabpagerealizarpago_title_Internalname = "TABPAGEREALIZARPAGO_TITLE" ;
      chkavTerminosycondiciones.setInternalname( "vTERMINOSYCONDICIONES" );
      divTable9_Internalname = "TABLE9" ;
      bttCancelar_Internalname = "CANCELAR" ;
      bttAnteriorpagar_Internalname = "ANTERIORPAGAR" ;
      bttPagar_Internalname = "PAGAR" ;
      divTabpage3table_Internalname = "TABPAGE3TABLE" ;
      Tabrealizarpago_Internalname = "TABREALIZARPAGO" ;
      divTable3_Internalname = "TABLE3" ;
      divTablegeneralpagarcita_Internalname = "TABLEGENERALPAGARCITA" ;
      Dvmessage1_Internalname = "DVMESSAGE1" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid5_Internalname = "GRID5" ;
      subGridpaciente_Internalname = "GRIDPACIENTE" ;
      subGridpacientefamiliar_Internalname = "GRIDPACIENTEFAMILIAR" ;
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
      edtavCtlmotivoconsulta_Jsonclick = "" ;
      edtavCtlmotivoconsulta_Visible = 1 ;
      edtavCtlmotivoconsulta_Enabled = 1 ;
      edtavCtlpeso_Jsonclick = "" ;
      edtavCtlpeso_Visible = 1 ;
      edtavCtlpeso_Enabled = 1 ;
      edtavCtlestatura_Jsonclick = "" ;
      edtavCtlestatura_Visible = 1 ;
      edtavCtlestatura_Enabled = 1 ;
      edtavCtlsexo_Jsonclick = "" ;
      edtavCtlfechanacimiento_Jsonclick = "" ;
      edtavCtlnrodocumento_Jsonclick = "" ;
      edtavCtltipodocumento_Jsonclick = "" ;
      edtavCtlapellidomaterno_Jsonclick = "" ;
      edtavCtlapellidopaterno_Jsonclick = "" ;
      edtavCtlnombres_Jsonclick = "" ;
      edtavCtlid_Jsonclick = "" ;
      subGridpacientefamiliar_Class = "FreeStyleGrid" ;
      edtavCtlsdtinformaciondelpacientemotivoconsulta_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientemotivoconsulta_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientemotivoconsulta_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacienteestatura_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacienteestatura_Visible = 1 ;
      edtavCtlsdtinformaciondelpacienteestatura_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacientepeso_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientepeso_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientepeso_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacienteemail_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientesexo_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefechanacimiento_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientenrodocumento_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientetipodocumento_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientenombres_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacienteid_Jsonclick = "" ;
      subGridpaciente_Class = "FreeStyleGrid" ;
      edtavCtlsdtinformaciondelacitacosto_Jsonclick = "" ;
      edtavCtlsdtinformaciondelacitahora_Jsonclick = "" ;
      edtavCtlsdtinformaciondelacitafecha_Jsonclick = "" ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setJsonclick( "" );
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Jsonclick = "" ;
      edtavCtlsdtinformaciondelacitaid_Jsonclick = "" ;
      subGrid5_Class = "FreeStyleGrid" ;
      edtavCtlsexo_Enabled = -1 ;
      edtavCtlfechanacimiento_Enabled = -1 ;
      edtavCtlnrodocumento_Enabled = -1 ;
      edtavCtltipodocumento_Enabled = -1 ;
      edtavCtlapellidomaterno_Enabled = -1 ;
      edtavCtlapellidopaterno_Enabled = -1 ;
      edtavCtlnombres_Enabled = -1 ;
      edtavCtlid_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacienteemail_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacientesexo_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacientenrodocumento_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacientetipodocumento_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacienteapellidos_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacientenombres_Enabled = -1 ;
      edtavCtlsdtinformaciondelpacienteid_Enabled = -1 ;
      edtavCtlsdtinformaciondelacitacosto_Enabled = -1 ;
      edtavCtlsdtinformaciondelacitahora_Enabled = -1 ;
      edtavCtlsdtinformaciondelacitafecha_Enabled = -1 ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setEnabled( -1 );
      edtavCtlsdtinformaciondelacitasede_Enabled = -1 ;
      edtavCtlsdtinformaciondelacitaclinica_Enabled = -1 ;
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled = -1 ;
      edtavCtlsdtinformaciondelacitanombresdoctor_Enabled = -1 ;
      edtavCtlsdtinformaciondelacitaid_Enabled = -1 ;
      chkavTerminosycondiciones.setEnabled( 1 );
      Fileuploadpacientefamiliar_Tooltiptext = "" ;
      divTablearchivofamiliar_Visible = 1 ;
      Fileuploadpaciente_Tooltiptext = "" ;
      divTablearcchivoprincipal_Visible = 1 ;
      subGridpacientefamiliar_Allowcollapsing = (byte)(0) ;
      edtavCtlsexo_Enabled = 0 ;
      edtavCtlfechanacimiento_Enabled = 0 ;
      edtavCtlnrodocumento_Enabled = 0 ;
      edtavCtltipodocumento_Enabled = 0 ;
      edtavCtlapellidomaterno_Enabled = 0 ;
      edtavCtlapellidopaterno_Enabled = 0 ;
      edtavCtlnombres_Enabled = 0 ;
      edtavCtlid_Enabled = 0 ;
      subGridpacientefamiliar_Backcolorstyle = (byte)(0) ;
      subGridpacientefamiliar_Visible = 1 ;
      subGridpaciente_Allowcollapsing = (byte)(0) ;
      edtavCtlsdtinformaciondelpacienteemail_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientesexo_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacienteapellidos_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientenombres_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacienteid_Enabled = 0 ;
      subGridpaciente_Backcolorstyle = (byte)(0) ;
      subGridpaciente_Visible = 1 ;
      cmbavPacientefamiliarid.setJsonclick( "" );
      cmbavPacientefamiliarid.setEnabled( 1 );
      cmbavPacientefamiliarid.setVisible( 1 );
      cmbavCitafamiliar.setJsonclick( "" );
      cmbavCitafamiliar.setEnabled( 1 );
      subGrid5_Allowcollapsing = (byte)(0) ;
      edtavCtlsdtinformaciondelacitacosto_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitahora_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitafecha_Enabled = 0 ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      edtavCtlsdtinformaciondelacitasede_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitaclinica_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitaid_Enabled = 0 ;
      subGrid5_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Reservar Cita" );
      Tabrealizarpago_Historymanagement = GXutil.toBoolean( 0) ;
      Tabrealizarpago_Class = "TabPagarCita" ;
      Tabrealizarpago_Pagecount = 2 ;
      Fileuploadpacientefamiliar_Maxnumberoffiles = 1 ;
      Fileuploadpacientefamiliar_Enableuploadedfilecanceling = GXutil.toBoolean( 0) ;
      Fileuploadpacientefamiliar_Hideadditionalbuttons = GXutil.toBoolean( -1) ;
      Fileuploadpacientefamiliar_Autoupload = GXutil.toBoolean( -1) ;
      Fileuploadpaciente_Acceptedfiletypes = "any" ;
      Fileuploadpaciente_Maxnumberoffiles = 1 ;
      Fileuploadpaciente_Enableuploadedfilecanceling = GXutil.toBoolean( -1) ;
      Fileuploadpaciente_Hideadditionalbuttons = GXutil.toBoolean( -1) ;
      Fileuploadpaciente_Autoupload = GXutil.toBoolean( -1) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "CTLSDTINFORMACIONDELACITATIPOCONSULTA_" + sGXsfl_20_idx ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setName( GXCCtl );
      cmbavCtlsdtinformaciondelacitatipoconsulta.setWebtags( "" );
      cmbavCtlsdtinformaciondelacitatipoconsulta.addItem("V", "Virtual", (short)(0));
      cmbavCtlsdtinformaciondelacitatipoconsulta.addItem("P", "En consultorio", (short)(0));
      cmbavCtlsdtinformaciondelacitatipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbavCtlsdtinformaciondelacitatipoconsulta.getItemCount() > 0 )
      {
         if ( ( AV37GXV1 > 0 ) && ( AV23SDTDetalleCita.size() >= AV37GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta())==0) )
         {
            ((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( cmbavCtlsdtinformaciondelacitatipoconsulta.getValidValue(((com.projectthani.SdtSDTInformacionDeLaCita)AV23SDTDetalleCita.elementAt(-1+AV37GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
         }
      }
      cmbavCitafamiliar.setName( "vCITAFAMILIAR" );
      cmbavCitafamiliar.setWebtags( "" );
      cmbavCitafamiliar.addItem("No", "No", (short)(0));
      cmbavCitafamiliar.addItem("Si", "Si", (short)(0));
      if ( cmbavCitafamiliar.getItemCount() > 0 )
      {
         AV8CitaFamiliar = cmbavCitafamiliar.getValidValue(AV8CitaFamiliar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CitaFamiliar", AV8CitaFamiliar);
      }
      cmbavPacientefamiliarid.setName( "vPACIENTEFAMILIARID" );
      cmbavPacientefamiliarid.setWebtags( "" );
      cmbavPacientefamiliarid.addItem(GXutil.trim( GXutil.str( 0, 8, 0)), "Seleccionar:", (short)(0));
      if ( cmbavPacientefamiliarid.getItemCount() > 0 )
      {
         AV20PacienteFamiliarId = (int)(GXutil.lval( cmbavPacientefamiliarid.getValidValue(GXutil.trim( GXutil.str( AV20PacienteFamiliarId, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20PacienteFamiliarId), 8, 0));
      }
      chkavTerminosycondiciones.setName( "vTERMINOSYCONDICIONES" );
      chkavTerminosycondiciones.setWebtags( "" );
      chkavTerminosycondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTerminosycondiciones.getInternalname(), "TitleCaption", chkavTerminosycondiciones.getCaption(), true);
      chkavTerminosycondiciones.setCheckedValue( "False" );
      AV34TerminosYCondiciones = GXutil.strtobool( GXutil.booltostr( AV34TerminosYCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV34TerminosYCondiciones", AV34TerminosYCondiciones);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID5_nFirstRecordOnPage'},{av:'GRID5_nEOF'},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'GRIDPACIENTEFAMILIAR_nEOF'},{av:'AV25SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:151,pic:''},{av:'nRC_GXsfl_151',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:151},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'GRIDPACIENTE_nEOF'},{av:'AV24SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV23SDTDetalleCita',fld:'vSDTDETALLECITA',grid:20,pic:'',hsh:true},{av:'nRC_GXsfl_20',ctrl:'GRID5',prop:'GridRC',grid:20},{av:'AV21PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV11DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("VPACIENTEFAMILIARID.CONTROLVALUECHANGED","{handler:'e132X2',iparms:[{av:'AV21PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavPacientefamiliarid'},{av:'AV20PacienteFamiliarId',fld:'vPACIENTEFAMILIARID',pic:'ZZZZZZZ9'},{av:'AV25SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:151,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_151',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:151},{av:'GRID5_nFirstRecordOnPage'},{av:'GRID5_nEOF'},{av:'GRIDPACIENTEFAMILIAR_nEOF'},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'GRIDPACIENTE_nEOF'},{av:'AV24SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV23SDTDetalleCita',fld:'vSDTDETALLECITA',grid:20,pic:'',hsh:true},{av:'nRC_GXsfl_20',ctrl:'GRID5',prop:'GridRC',grid:20},{av:'AV11DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("VPACIENTEFAMILIARID.CONTROLVALUECHANGED",",oparms:[{av:'AV25SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:151,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_151',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:151},{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("'CANCELAR'","{handler:'e112X1',iparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("'CANCELAR'",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("'SIGUIENTEINFORMACIONPACIENTE'","{handler:'e142X2',iparms:[{av:'cmbavCitafamiliar'},{av:'AV8CitaFamiliar',fld:'vCITAFAMILIAR',pic:''},{av:'AV24SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV25SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:151,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_151',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:151},{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("'SIGUIENTEINFORMACIONPACIENTE'",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("'ANTERIORPAGAR'","{handler:'e122X1',iparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("'ANTERIORPAGAR'",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("'REALIZARPAGO'","{handler:'e152X2',iparms:[{av:'AV23SDTDetalleCita',fld:'vSDTDETALLECITA',grid:20,pic:'',hsh:true},{av:'GRID5_nFirstRecordOnPage'},{av:'nRC_GXsfl_20',ctrl:'GRID5',prop:'GridRC',grid:20},{av:'AV21PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV11DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavCitafamiliar'},{av:'AV8CitaFamiliar',fld:'vCITAFAMILIAR',pic:''},{av:'cmbavPacientefamiliarid'},{av:'AV20PacienteFamiliarId',fld:'vPACIENTEFAMILIARID',pic:'ZZZZZZZ9'},{av:'AV7Cita',fld:'vCITA',pic:''},{av:'AV25SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:151,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_151',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:151},{av:'AV17FileUploadPacienteFamiliar',fld:'vFILEUPLOADPACIENTEFAMILIAR',pic:''},{av:'AV24SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV16FileUploadPaciente',fld:'vFILEUPLOADPACIENTE',pic:''},{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("'REALIZARPAGO'",",oparms:[{av:'AV7Cita',fld:'vCITA',pic:''},{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV8","{handler:'validv_Gxv8',iparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV8",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv11',iparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV20","{handler:'validv_Gxv20',iparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV20",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv23',iparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv35',iparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV34TerminosYCondiciones',fld:'vTERMINOSYCONDICIONES',pic:''}]}");
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
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV24SDTPaciente = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>(com.projectthani.SdtSDTInformacionDelPaciente.class, "SDTInformacionDelPaciente", "ProjectThani", remoteHandle);
      AV23SDTDetalleCita = new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>(com.projectthani.SdtSDTInformacionDeLaCita.class, "SDTInformacionDeLaCita", "ProjectThani", remoteHandle);
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV25SDTPacienteFamiliar = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>(com.projectthani.SdtSDTInformacionDelPacienteFamiliar.class, "SDTInformacionDelPacienteFamiliar", "ProjectThani", remoteHandle);
      AV16FileUploadPaciente = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV12FailedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV17FileUploadPacienteFamiliar = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV7Cita = new com.projectthani.SdtCita(remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTextblockinfocita_Jsonclick = "" ;
      Grid5Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid5_Header = "" ;
      Grid5Column = new com.genexus.webpanels.GXWebColumn();
      ucTabrealizarpago = new com.genexus.webpanels.GXUserControl();
      lblTabpageinformacionpaciente_title_Jsonclick = "" ;
      TempTags = "" ;
      AV8CitaFamiliar = "" ;
      GridpacienteContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridpaciente_Header = "" ;
      GridpacienteColumn = new com.genexus.webpanels.GXWebColumn();
      GridpacientefamiliarContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridpacientefamiliar_Header = "" ;
      GridpacientefamiliarColumn = new com.genexus.webpanels.GXWebColumn();
      lblTextblock1_Jsonclick = "" ;
      ucFileuploadpaciente = new com.genexus.webpanels.GXUserControl();
      lblTextblock4_Jsonclick = "" ;
      ucFileuploadpacientefamiliar = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      bttCancelar1_Jsonclick = "" ;
      bttSiguienteinfopaciente_Jsonclick = "" ;
      lblTabpagerealizarpago_title_Jsonclick = "" ;
      bttCancelar_Jsonclick = "" ;
      bttAnteriorpagar_Jsonclick = "" ;
      bttPagar_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV31WebSession = httpContext.getWebSession();
      GXt_objcol_SdtSDTInformacionDeLaCita1 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>(com.projectthani.SdtSDTInformacionDeLaCita.class, "SDTInformacionDeLaCita", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDeLaCita2 = new GXBaseCollection[1] ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>(com.projectthani.SdtSDTInformacionDelPaciente.class, "SDTInformacionDelPaciente", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDelPaciente4 = new GXBaseCollection[1] ;
      AV14FamiliarList = new GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>(com.projectthani.SdtSDTListadoPacienteFamiliarComboBox.class, "SDTListadoPacienteFamiliarComboBox", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5 = new GXBaseCollection[1] ;
      AV13FamiliarItem = new com.projectthani.SdtSDTListadoPacienteFamiliarComboBox(remoteHandle, context);
      GXv_objcol_SdtSDTInformacionDelPacienteFamiliar6 = new GXBaseCollection[1] ;
      AV28TempNombreDoctor = "" ;
      AV26TempFechaCita = "" ;
      AV27TempHoraCita = "" ;
      AV30Valor = "" ;
      AV10CodigoCita = "" ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV5Disponibilidad = new com.projectthani.SdtDisponibilidad(remoteHandle);
      Grid5Row = new com.genexus.webpanels.GXWebRow();
      GridpacientefamiliarRow = new com.genexus.webpanels.GXWebRow();
      GridpacienteRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid5_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      GXCCtl = "" ;
      subGridpaciente_Linesclass = "" ;
      subGridpacientefamiliar_Linesclass = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpreservarcita__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavCtlsdtinformaciondelacitaid_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitaclinica_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitasede_Enabled = 0 ;
      cmbavCtlsdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      edtavCtlsdtinformaciondelacitafecha_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitahora_Enabled = 0 ;
      edtavCtlsdtinformaciondelacitacosto_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacienteid_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientenombres_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacienteapellidos_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacientesexo_Enabled = 0 ;
      edtavCtlsdtinformaciondelpacienteemail_Enabled = 0 ;
      edtavCtlid_Enabled = 0 ;
      edtavCtlnombres_Enabled = 0 ;
      edtavCtlapellidopaterno_Enabled = 0 ;
      edtavCtlapellidomaterno_Enabled = 0 ;
      edtavCtltipodocumento_Enabled = 0 ;
      edtavCtlnrodocumento_Enabled = 0 ;
      edtavCtlfechanacimiento_Enabled = 0 ;
      edtavCtlsexo_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGrid5_Backcolorstyle ;
   private byte subGrid5_Allowselection ;
   private byte subGrid5_Allowhovering ;
   private byte subGrid5_Allowcollapsing ;
   private byte subGrid5_Collapsed ;
   private byte subGridpaciente_Backcolorstyle ;
   private byte subGridpaciente_Allowselection ;
   private byte subGridpaciente_Allowhovering ;
   private byte subGridpaciente_Allowcollapsing ;
   private byte subGridpaciente_Collapsed ;
   private byte subGridpacientefamiliar_Backcolorstyle ;
   private byte subGridpacientefamiliar_Allowselection ;
   private byte subGridpacientefamiliar_Allowhovering ;
   private byte subGridpacientefamiliar_Allowcollapsing ;
   private byte subGridpacientefamiliar_Collapsed ;
   private byte nDonePA ;
   private byte GRID5_nEOF ;
   private byte GRIDPACIENTEFAMILIAR_nEOF ;
   private byte GRIDPACIENTE_nEOF ;
   private byte nGXWrapped ;
   private byte subGrid5_Backstyle ;
   private byte subGridpaciente_Backstyle ;
   private byte subGridpacientefamiliar_Backstyle ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV19isEstadoMensaje ;
   private int wcpOAV11DisponibilidadId ;
   private int nRC_GXsfl_20 ;
   private int nRC_GXsfl_99 ;
   private int nRC_GXsfl_151 ;
   private int nGXsfl_20_idx=1 ;
   private int AV21PacienteId ;
   private int AV11DisponibilidadId ;
   private int Fileuploadpaciente_Maxnumberoffiles ;
   private int Fileuploadpacientefamiliar_Maxnumberoffiles ;
   private int Tabrealizarpago_Pagecount ;
   private int nGXsfl_99_idx=1 ;
   private int nGXsfl_151_idx=1 ;
   private int edtavCtlsdtinformaciondelacitaid_Enabled ;
   private int edtavCtlsdtinformaciondelacitanombresdoctor_Enabled ;
   private int edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled ;
   private int edtavCtlsdtinformaciondelacitaclinica_Enabled ;
   private int edtavCtlsdtinformaciondelacitasede_Enabled ;
   private int edtavCtlsdtinformaciondelacitafecha_Enabled ;
   private int edtavCtlsdtinformaciondelacitahora_Enabled ;
   private int edtavCtlsdtinformaciondelacitacosto_Enabled ;
   private int subGrid5_Selectedindex ;
   private int subGrid5_Selectioncolor ;
   private int subGrid5_Hoveringcolor ;
   private int AV37GXV1 ;
   private int AV20PacienteFamiliarId ;
   private int subGridpaciente_Visible ;
   private int edtavCtlsdtinformaciondelpacienteid_Enabled ;
   private int edtavCtlsdtinformaciondelpacientenombres_Enabled ;
   private int edtavCtlsdtinformaciondelpacienteapellidos_Enabled ;
   private int edtavCtlsdtinformaciondelpacientetipodocumento_Enabled ;
   private int edtavCtlsdtinformaciondelpacientenrodocumento_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled ;
   private int edtavCtlsdtinformaciondelpacientesexo_Enabled ;
   private int edtavCtlsdtinformaciondelpacienteemail_Enabled ;
   private int subGridpaciente_Selectedindex ;
   private int subGridpaciente_Selectioncolor ;
   private int subGridpaciente_Hoveringcolor ;
   private int AV48GXV12 ;
   private int subGridpacientefamiliar_Visible ;
   private int edtavCtlid_Enabled ;
   private int edtavCtlnombres_Enabled ;
   private int edtavCtlapellidopaterno_Enabled ;
   private int edtavCtlapellidomaterno_Enabled ;
   private int edtavCtltipodocumento_Enabled ;
   private int edtavCtlnrodocumento_Enabled ;
   private int edtavCtlfechanacimiento_Enabled ;
   private int edtavCtlsexo_Enabled ;
   private int subGridpacientefamiliar_Selectedindex ;
   private int subGridpacientefamiliar_Selectioncolor ;
   private int subGridpacientefamiliar_Hoveringcolor ;
   private int AV60GXV24 ;
   private int divTablearcchivoprincipal_Visible ;
   private int divTablearchivofamiliar_Visible ;
   private int subGrid5_Islastpage ;
   private int subGridpacientefamiliar_Islastpage ;
   private int subGridpaciente_Islastpage ;
   private int nGXsfl_20_fel_idx=1 ;
   private int nGXsfl_99_fel_idx=1 ;
   private int nGXsfl_151_fel_idx=1 ;
   private int AV72GXV36 ;
   private int nGXsfl_151_bak_idx=1 ;
   private int idxLst ;
   private int subGrid5_Backcolor ;
   private int subGrid5_Allbackcolor ;
   private int subGridpaciente_Backcolor ;
   private int subGridpaciente_Allbackcolor ;
   private int edtavCtlsdtinformaciondelpacientepeso_Enabled ;
   private int edtavCtlsdtinformaciondelpacientepeso_Visible ;
   private int edtavCtlsdtinformaciondelpacienteestatura_Enabled ;
   private int edtavCtlsdtinformaciondelpacienteestatura_Visible ;
   private int edtavCtlsdtinformaciondelpacientemotivoconsulta_Enabled ;
   private int edtavCtlsdtinformaciondelpacientemotivoconsulta_Visible ;
   private int subGridpacientefamiliar_Backcolor ;
   private int subGridpacientefamiliar_Allbackcolor ;
   private int edtavCtlestatura_Enabled ;
   private int edtavCtlestatura_Visible ;
   private int edtavCtlpeso_Enabled ;
   private int edtavCtlpeso_Visible ;
   private int edtavCtlmotivoconsulta_Enabled ;
   private int edtavCtlmotivoconsulta_Visible ;
   private long GRID5_nCurrentRecord ;
   private long GRIDPACIENTE_nCurrentRecord ;
   private long GRIDPACIENTEFAMILIAR_nCurrentRecord ;
   private long GRID5_nFirstRecordOnPage ;
   private long GRIDPACIENTEFAMILIAR_nFirstRecordOnPage ;
   private long GRIDPACIENTE_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_20_idx="0001" ;
   private String Fileuploadpaciente_Acceptedfiletypes ;
   private String Tabrealizarpago_Class ;
   private String sGXsfl_99_idx="0001" ;
   private String sGXsfl_151_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTablegeneralpagarcita_Internalname ;
   private String divTable2_Internalname ;
   private String divTable4_Internalname ;
   private String lblTextblockinfocita_Internalname ;
   private String lblTextblockinfocita_Jsonclick ;
   private String divSeparador_Internalname ;
   private String sStyleString ;
   private String subGrid5_Internalname ;
   private String subGrid5_Header ;
   private String divTable3_Internalname ;
   private String Tabrealizarpago_Internalname ;
   private String lblTabpageinformacionpaciente_title_Internalname ;
   private String lblTabpageinformacionpaciente_title_Jsonclick ;
   private String divTabpage1table_Internalname ;
   private String divTable5_Internalname ;
   private String TempTags ;
   private String AV8CitaFamiliar ;
   private String divTable6_Internalname ;
   private String subGridpaciente_Internalname ;
   private String subGridpaciente_Header ;
   private String subGridpacientefamiliar_Internalname ;
   private String subGridpacientefamiliar_Header ;
   private String divTablearcchivoprincipal_Internalname ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String Fileuploadpaciente_Tooltiptext ;
   private String Fileuploadpaciente_Internalname ;
   private String divTablearchivofamiliar_Internalname ;
   private String lblTextblock4_Internalname ;
   private String lblTextblock4_Jsonclick ;
   private String Fileuploadpacientefamiliar_Tooltiptext ;
   private String Fileuploadpacientefamiliar_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttCancelar1_Internalname ;
   private String bttCancelar1_Jsonclick ;
   private String bttSiguienteinfopaciente_Internalname ;
   private String bttSiguienteinfopaciente_Jsonclick ;
   private String lblTabpagerealizarpago_title_Internalname ;
   private String lblTabpagerealizarpago_title_Jsonclick ;
   private String divTabpage3table_Internalname ;
   private String divTable9_Internalname ;
   private String bttCancelar_Internalname ;
   private String bttCancelar_Jsonclick ;
   private String bttAnteriorpagar_Internalname ;
   private String bttAnteriorpagar_Jsonclick ;
   private String bttPagar_Internalname ;
   private String bttPagar_Jsonclick ;
   private String Dvmessage1_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavCtlsdtinformaciondelacitaid_Internalname ;
   private String edtavCtlsdtinformaciondelacitanombresdoctor_Internalname ;
   private String edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname ;
   private String edtavCtlsdtinformaciondelacitaclinica_Internalname ;
   private String edtavCtlsdtinformaciondelacitasede_Internalname ;
   private String edtavCtlsdtinformaciondelacitafecha_Internalname ;
   private String edtavCtlsdtinformaciondelacitahora_Internalname ;
   private String edtavCtlsdtinformaciondelacitacosto_Internalname ;
   private String edtavCtlsdtinformaciondelpacienteid_Internalname ;
   private String edtavCtlsdtinformaciondelpacientenombres_Internalname ;
   private String edtavCtlsdtinformaciondelpacienteapellidos_Internalname ;
   private String edtavCtlsdtinformaciondelpacientetipodocumento_Internalname ;
   private String edtavCtlsdtinformaciondelpacientenrodocumento_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname ;
   private String edtavCtlsdtinformaciondelpacientesexo_Internalname ;
   private String edtavCtlsdtinformaciondelpacienteemail_Internalname ;
   private String edtavCtlid_Internalname ;
   private String edtavCtlnombres_Internalname ;
   private String edtavCtlapellidopaterno_Internalname ;
   private String edtavCtlapellidomaterno_Internalname ;
   private String edtavCtltipodocumento_Internalname ;
   private String edtavCtlnrodocumento_Internalname ;
   private String edtavCtlfechanacimiento_Internalname ;
   private String edtavCtlsexo_Internalname ;
   private String sGXsfl_20_fel_idx="0001" ;
   private String sGXsfl_99_fel_idx="0001" ;
   private String sGXsfl_151_fel_idx="0001" ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private String edtavCtlsdtinformaciondelacitafotografiadoctor_Internalname ;
   private String subGrid5_Class ;
   private String subGrid5_Linesclass ;
   private String divGrid5table_Internalname ;
   private String ROClassString ;
   private String edtavCtlsdtinformaciondelacitaid_Jsonclick ;
   private String divTable1_Internalname ;
   private String sImgUrl ;
   private String edtavCtlsdtinformaciondelacitaespecialidaddoctor_Jsonclick ;
   private String GXCCtl ;
   private String edtavCtlsdtinformaciondelacitafecha_Jsonclick ;
   private String edtavCtlsdtinformaciondelacitahora_Jsonclick ;
   private String edtavCtlsdtinformaciondelacitacosto_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientepeso_Internalname ;
   private String edtavCtlsdtinformaciondelpacienteestatura_Internalname ;
   private String edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname ;
   private String subGridpaciente_Class ;
   private String subGridpaciente_Linesclass ;
   private String divGrid2table_Internalname ;
   private String edtavCtlsdtinformaciondelpacienteid_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientenombres_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientetipodocumento_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientenrodocumento_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefechanacimiento_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientesexo_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacienteemail_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientepeso_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacienteestatura_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientemotivoconsulta_Jsonclick ;
   private String edtavCtlestatura_Internalname ;
   private String edtavCtlpeso_Internalname ;
   private String edtavCtlmotivoconsulta_Internalname ;
   private String subGridpacientefamiliar_Class ;
   private String subGridpacientefamiliar_Linesclass ;
   private String divGrid3table_Internalname ;
   private String edtavCtlid_Jsonclick ;
   private String edtavCtlnombres_Jsonclick ;
   private String edtavCtlapellidopaterno_Jsonclick ;
   private String edtavCtlapellidomaterno_Jsonclick ;
   private String edtavCtltipodocumento_Jsonclick ;
   private String edtavCtlnrodocumento_Jsonclick ;
   private String edtavCtlfechanacimiento_Jsonclick ;
   private String edtavCtlsexo_Jsonclick ;
   private String edtavCtlestatura_Jsonclick ;
   private String edtavCtlpeso_Jsonclick ;
   private String edtavCtlmotivoconsulta_Jsonclick ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV34TerminosYCondiciones ;
   private boolean Fileuploadpaciente_Autoupload ;
   private boolean Fileuploadpaciente_Hideadditionalbuttons ;
   private boolean Fileuploadpaciente_Enableuploadedfilecanceling ;
   private boolean Fileuploadpacientefamiliar_Autoupload ;
   private boolean Fileuploadpacientefamiliar_Hideadditionalbuttons ;
   private boolean Fileuploadpacientefamiliar_Enableuploadedfilecanceling ;
   private boolean Tabrealizarpago_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_20_Refreshing=false ;
   private boolean bGXsfl_99_Refreshing=false ;
   private boolean bGXsfl_151_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_BV20 ;
   private boolean gx_BV99 ;
   private boolean gx_BV151 ;
   private boolean AV6CheckResult ;
   private boolean Cond_result ;
   private String AV28TempNombreDoctor ;
   private String AV26TempFechaCita ;
   private String AV27TempHoraCita ;
   private String AV30Valor ;
   private String AV10CodigoCita ;
   private com.genexus.webpanels.GXWebGrid Grid5Container ;
   private com.genexus.webpanels.GXWebGrid GridpacienteContainer ;
   private com.genexus.webpanels.GXWebGrid GridpacientefamiliarContainer ;
   private com.genexus.webpanels.GXWebRow Grid5Row ;
   private com.genexus.webpanels.GXWebRow GridpacientefamiliarRow ;
   private com.genexus.webpanels.GXWebRow GridpacienteRow ;
   private com.genexus.webpanels.GXWebColumn Grid5Column ;
   private com.genexus.webpanels.GXWebColumn GridpacienteColumn ;
   private com.genexus.webpanels.GXWebColumn GridpacientefamiliarColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV31WebSession ;
   private com.genexus.webpanels.GXUserControl ucTabrealizarpago ;
   private com.genexus.webpanels.GXUserControl ucFileuploadpaciente ;
   private com.genexus.webpanels.GXUserControl ucFileuploadpacientefamiliar ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private HTMLChoice cmbavCtlsdtinformaciondelacitatipoconsulta ;
   private HTMLChoice cmbavCitafamiliar ;
   private HTMLChoice cmbavPacientefamiliarid ;
   private ICheckbox chkavTerminosycondiciones ;
   private IDataStoreProvider pr_default ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV16FileUploadPaciente ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV12FailedFiles ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV17FileUploadPacienteFamiliar ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> AV14FamiliarList ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV23SDTDetalleCita ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> GXt_objcol_SdtSDTInformacionDeLaCita1 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> GXv_objcol_SdtSDTInformacionDeLaCita2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV24SDTPaciente ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> GXt_objcol_SdtSDTInformacionDelPaciente3 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> GXv_objcol_SdtSDTInformacionDelPaciente4[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> AV25SDTPacienteFamiliar ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> GXv_objcol_SdtSDTInformacionDelPacienteFamiliar6[] ;
   private com.projectthani.SdtDisponibilidad AV5Disponibilidad ;
   private com.projectthani.SdtCita AV7Cita ;
   private com.projectthani.SdtSDTListadoPacienteFamiliarComboBox AV13FamiliarItem ;
}

final  class wpreservarcita__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

