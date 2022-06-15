package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wppagarcitaoriginal_impl extends GXDataArea
{
   public wppagarcitaoriginal_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wppagarcitaoriginal_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wppagarcitaoriginal_impl.class ));
   }

   public wppagarcitaoriginal_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavCtlsdtinformaciondelacitatipoconsulta = new HTMLChoice();
      cmbavCitafamiliar = new HTMLChoice();
      cmbavPacientefamiliarid = new HTMLChoice();
      chkavBoleta = UIFactory.getCheckbox(this);
      chkavFactura = UIFactory.getCheckbox(this);
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento = new HTMLChoice();
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento = new HTMLChoice();
      chkavTerminoscondiciones = UIFactory.getCheckbox(this);
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
            AV6Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV13Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV39TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30SDTFacturacionBoleta);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31SDTFacturacionFactura);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29SDTDetalleCita);
            AV25PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid5_refresh( AV6Boleta, AV13Factura, AV39TerminosCondiciones, AV32SDTPaciente, AV30SDTFacturacionBoleta, AV31SDTFacturacionFactura, AV29SDTDetalleCita, AV25PacienteId, AV11DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV35SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
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
            AV6Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV13Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV39TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30SDTFacturacionBoleta);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31SDTFacturacionFactura);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29SDTDetalleCita);
            AV25PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridpaciente_refresh( AV6Boleta, AV13Factura, AV39TerminosCondiciones, AV32SDTPaciente, AV30SDTFacturacionBoleta, AV31SDTFacturacionFactura, AV29SDTDetalleCita, AV25PacienteId, AV11DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV35SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridpacientefamiliar") == 0 )
         {
            nRC_GXsfl_157 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_157"))) ;
            nGXsfl_157_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_157_idx"))) ;
            sGXsfl_157_idx = httpContext.GetPar( "sGXsfl_157_idx") ;
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
            AV6Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV13Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV39TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30SDTFacturacionBoleta);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31SDTFacturacionFactura);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29SDTDetalleCita);
            AV25PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridpacientefamiliar_refresh( AV6Boleta, AV13Factura, AV39TerminosCondiciones, AV32SDTPaciente, AV30SDTFacturacionBoleta, AV31SDTFacturacionFactura, AV29SDTDetalleCita, AV25PacienteId, AV11DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV35SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridboleta") == 0 )
         {
            nRC_GXsfl_245 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_245"))) ;
            nGXsfl_245_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_245_idx"))) ;
            sGXsfl_245_idx = httpContext.GetPar( "sGXsfl_245_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridboleta_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridboleta") == 0 )
         {
            AV6Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV13Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV39TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30SDTFacturacionBoleta);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31SDTFacturacionFactura);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29SDTDetalleCita);
            AV25PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridboleta_refresh( AV6Boleta, AV13Factura, AV39TerminosCondiciones, AV32SDTPaciente, AV30SDTFacturacionBoleta, AV31SDTFacturacionFactura, AV29SDTDetalleCita, AV25PacienteId, AV11DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV35SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridfactura") == 0 )
         {
            nRC_GXsfl_281 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_281"))) ;
            nGXsfl_281_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_281_idx"))) ;
            sGXsfl_281_idx = httpContext.GetPar( "sGXsfl_281_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridfactura_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridfactura") == 0 )
         {
            AV6Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV13Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV39TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV32SDTPaciente);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV30SDTFacturacionBoleta);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV31SDTFacturacionFactura);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV29SDTDetalleCita);
            AV25PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV11DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridfactura_refresh( AV6Boleta, AV13Factura, AV39TerminosCondiciones, AV32SDTPaciente, AV30SDTFacturacionBoleta, AV31SDTFacturacionFactura, AV29SDTDetalleCita, AV25PacienteId, AV11DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV35SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
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
      pa6P2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start6P2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110341242", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal FormFondoGeneral\" data-gx-class=\"form-horizontal FormFondoGeneral\" novalidate action=\""+formatLink("com.projectthani.wppagarcitaoriginal", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTPACIENTE", getSecureSignedToken( "", AV32SDTPaciente));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTDETALLECITA", getSecureSignedToken( "", AV29SDTDetalleCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTFACTURACIONBOLETA", getSecureSignedToken( "", AV30SDTFacturacionBoleta));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTFACTURACIONFACTURA", getSecureSignedToken( "", AV31SDTFacturacionFactura));
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
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtpaciente", AV32SDTPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtpaciente", AV32SDTPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtpaciente", getSecureSignedToken( "", AV32SDTPaciente));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtpacientefamiliar", AV33SDTPacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtpacientefamiliar", AV33SDTPacienteFamiliar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtfacturacionboleta", AV30SDTFacturacionBoleta);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtfacturacionboleta", AV30SDTFacturacionBoleta);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtfacturacionboleta", getSecureSignedToken( "", AV30SDTFacturacionBoleta));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtfacturacionfactura", AV31SDTFacturacionFactura);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtfacturacionfactura", AV31SDTFacturacionFactura);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtfacturacionfactura", getSecureSignedToken( "", AV31SDTFacturacionFactura));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtdetallecita", AV29SDTDetalleCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtdetallecita", AV29SDTDetalleCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtdetallecita", getSecureSignedToken( "", AV29SDTDetalleCita));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_20", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_20, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_99", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_99, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_157", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_157, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_245", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_245, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_281", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_281, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV25PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25PacienteId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPACIENTE", AV32SDTPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPACIENTE", AV32SDTPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTPACIENTE", getSecureSignedToken( "", AV32SDTPaciente));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPACIENTEFAMILIAR", AV33SDTPacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPACIENTEFAMILIAR", AV33SDTPacienteFamiliar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTDETALLECITA", AV29SDTDetalleCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTDETALLECITA", AV29SDTDetalleCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTDETALLECITA", getSecureSignedToken( "", AV29SDTDetalleCita));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTREQUESTTOKENSESSION", AV34SDTRequestTokenSession);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTREQUESTTOKENSESSION", AV34SDTRequestTokenSession);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV11DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11DisponibilidadId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITA", AV8Cita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITA", AV8Cita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFILEUPLOADPACIENTEFAMILIAR", AV17FileUploadPacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFILEUPLOADPACIENTEFAMILIAR", AV17FileUploadPacienteFamiliar);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILEUPLOADPACIENTEFAMILIAR", getSecureSignedToken( "", AV17FileUploadPacienteFamiliar));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFILEUPLOADPACIENTE", AV16FileUploadPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFILEUPLOADPACIENTE", AV16FileUploadPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILEUPLOADPACIENTE", getSecureSignedToken( "", AV16FileUploadPaciente));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAGO", AV27Pago);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAGO", AV27Pago);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTFACTURACIONBOLETA", AV30SDTFacturacionBoleta);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTFACTURACIONBOLETA", AV30SDTFacturacionBoleta);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTFACTURACIONBOLETA", getSecureSignedToken( "", AV30SDTFacturacionBoleta));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTFACTURACIONFACTURA", AV31SDTFacturacionFactura);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTFACTURACIONFACTURA", AV31SDTFacturacionFactura);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTFACTURACIONFACTURA", getSecureSignedToken( "", AV31SDTFacturacionFactura));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTRESPONSETOKENSESSION200", AV35SDTResponseTokenSession200);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTRESPONSETOKENSESSION200", AV35SDTResponseTokenSession200);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPURCHASENUMBER", AV28purchaseNumber);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Pagecount", GXutil.ltrim( localUtil.ntoc( Tabrealizarpago_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Class", GXutil.rtrim( Tabrealizarpago_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "TABREALIZARPAGO_Historymanagement", GXutil.booltostr( Tabrealizarpago_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV35SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
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
         we6P2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt6P2( ) ;
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
      return formatLink("com.projectthani.wppagarcitaoriginal", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"})  ;
   }

   public String getPgmname( )
   {
      return "WPPagarCitaOriginal" ;
   }

   public String getPgmdesc( )
   {
      return "Pagar cita" ;
   }

   public void wb6P0( )
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockinfocita_Internalname, "Información de la cita", "", "", lblTextblockinfocita_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlockInfoCita", 0, "", 1, 1, 0, (short)(0), "HLP_WPPagarCitaOriginal.htm");
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
            AV46GXV1 = nGXsfl_20_idx ;
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
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpageinformacionpaciente_title_Internalname, "Información del paciente", "", "", lblTabpageinformacionpaciente_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPPagarCitaOriginal.htm");
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
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCitafamiliar, cmbavCitafamiliar.getInternalname(), GXutil.rtrim( AV9CitaFamiliar), 1, cmbavCitafamiliar.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavCitafamiliar.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeComboBoxPC", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "", true, (byte)(1), "HLP_WPPagarCitaOriginal.htm");
         cmbavCitafamiliar.setValue( GXutil.rtrim( AV9CitaFamiliar) );
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
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavPacientefamiliarid, cmbavPacientefamiliarid.getInternalname(), GXutil.trim( GXutil.str( AV24PacienteFamiliarId, 8, 0)), 1, cmbavPacientefamiliarid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavPacientefamiliarid.getVisible(), cmbavPacientefamiliarid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "AttributeComboBoxPC", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "", true, (byte)(1), "HLP_WPPagarCitaOriginal.htm");
         cmbavPacientefamiliarid.setValue( GXutil.trim( GXutil.str( AV24PacienteFamiliarId, 8, 0)) );
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
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteContainer.AddColumnProperties(GridpacienteColumn);
            GridpacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacienteColumn.AddObjectProperty("Value", lblTextblock2_Caption);
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
            AV57GXV12 = nGXsfl_99_idx ;
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
            httpContext.writeText( "<div id=\""+"GridpacientefamiliarContainer"+"DivS\" data-gxgridid=\"157\">") ;
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
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarContainer.AddColumnProperties(GridpacientefamiliarColumn);
            GridpacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridpacientefamiliarColumn.AddObjectProperty("Value", lblTextblock2_Caption);
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
      if ( wbEnd == 157 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_157 = (int)(nGXsfl_157_idx-1) ;
         if ( GridpacientefamiliarContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV69GXV24 = nGXsfl_157_idx ;
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
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 215,'',false,'',0)\"" ;
         ClassString = "ButtonCancelarP" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar1_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Cancelar", bttCancelar1_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116p1_client"+"'", TempTags, "", 2, "HLP_WPPagarCitaOriginal.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 217,'',false,'',0)\"" ;
         ClassString = "ButtonSiguiente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttSiguienteinfopaciente_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Siguiente", bttSiguienteinfopaciente_Jsonclick, 5, "Siguiente", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'SIGUIENTEINFORMACIONPACIENTE\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPPagarCitaOriginal.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpagefacturacion_title_Internalname, "Facturación", "", "", lblTabpagefacturacion_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPPagarCitaOriginal.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPageFacturacion") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTabpage2table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable8_Internalname, 1, 0, "px", 0, "px", "TableFactSelect", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpGroup1_Internalname, "Tipo de comprobante", 1, 0, "px", 0, "px", "GroupFacturacion", "", "HLP_WPPagarCitaOriginal.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGroup1table_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavBoleta.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavBoleta.getInternalname(), "Boleta", "col-sm-3 CheckboxTCLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 234,'',false,'" + sGXsfl_20_idx + "',0)\"" ;
         ClassString = "CheckboxTC" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavBoleta.getInternalname(), GXutil.booltostr( AV6Boleta), "", "Boleta", 1, chkavBoleta.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(234, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,234);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavFactura.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavFactura.getInternalname(), "Factura", "col-sm-3 CheckboxTCLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 238,'',false,'" + sGXsfl_20_idx + "',0)\"" ;
         ClassString = "CheckboxTC" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavFactura.getInternalname(), GXutil.booltostr( AV13Factura), "", "Factura", 1, chkavFactura.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(238, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,238);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTable7_Internalname, 1, 0, "px", 0, "px", "TableFactDetalle", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionboleta_Internalname, divSectionboleta_Visible, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridboletaContainer.SetIsFreestyle(true);
         GridboletaContainer.SetWrapped(nGXWrapped);
         if ( GridboletaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridboletaContainer"+"DivS\" data-gxgridid=\"245\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridboleta_Internalname, subGridboleta_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridboletaContainer.AddObjectProperty("GridName", "Gridboleta");
         }
         else
         {
            GridboletaContainer.AddObjectProperty("GridName", "Gridboleta");
            GridboletaContainer.AddObjectProperty("Header", subGridboleta_Header);
            GridboletaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridboletaContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridboletaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridboleta_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("CmpContext", "");
            GridboletaContainer.AddObjectProperty("InMasterPage", "false");
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridboletaContainer.AddColumnProperties(GridboletaColumn);
            GridboletaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridboleta_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridboleta_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridboleta_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridboleta_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridboleta_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridboleta_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridboletaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridboleta_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 245 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_245 = (int)(nGXsfl_245_idx-1) ;
         if ( GridboletaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV81GXV36 = nGXsfl_245_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridboletaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridboleta", GridboletaContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridboletaContainerData", GridboletaContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridboletaContainerData"+"V", GridboletaContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridboletaContainerData"+"V"+"\" value='"+GridboletaContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSectionfactura_Internalname, divSectionfactura_Visible, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridfacturaContainer.SetIsFreestyle(true);
         GridfacturaContainer.SetWrapped(nGXWrapped);
         if ( GridfacturaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridfacturaContainer"+"DivS\" data-gxgridid=\"281\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridfactura_Internalname, subGridfactura_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            GridfacturaContainer.AddObjectProperty("GridName", "Gridfactura");
         }
         else
         {
            GridfacturaContainer.AddObjectProperty("GridName", "Gridfactura");
            GridfacturaContainer.AddObjectProperty("Header", subGridfactura_Header);
            GridfacturaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            GridfacturaContainer.AddObjectProperty("Class", "FreeStyleGrid");
            GridfacturaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridfactura_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("CmpContext", "");
            GridfacturaContainer.AddObjectProperty("InMasterPage", "false");
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridfacturaContainer.AddColumnProperties(GridfacturaColumn);
            GridfacturaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridfactura_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridfactura_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridfactura_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridfactura_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridfactura_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridfactura_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridfactura_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 281 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_281 = (int)(nGXsfl_281_idx-1) ;
         if ( GridfacturaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV89GXV44 = nGXsfl_281_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridfacturaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridfactura", GridfacturaContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridfacturaContainerData", GridfacturaContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridfacturaContainerData"+"V", GridfacturaContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridfacturaContainerData"+"V"+"\" value='"+GridfacturaContainer.GridValuesHidden()+"'/>") ;
            }
         }
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 308,'',false,'',0)\"" ;
         ClassString = "ButtonCancelarP" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar2_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Cancelar", bttCancelar2_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116p1_client"+"'", TempTags, "", 2, "HLP_WPPagarCitaOriginal.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 310,'',false,'',0)\"" ;
         ClassString = "ButtonAnterior" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAnteriorinformacionpaciente_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Anterior ", bttAnteriorinformacionpaciente_Jsonclick, 7, "Anterior ", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e126p1_client"+"'", TempTags, "", 2, "HLP_WPPagarCitaOriginal.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 312,'',false,'',0)\"" ;
         ClassString = "ButtonSiguiente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttSiguientefacturacion_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Siguiente ", bttSiguientefacturacion_Jsonclick, 5, "Siguiente ", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'SIGUIENTEFACTURACION\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPPagarCitaOriginal.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpagerealizarpago_title_Internalname, "Realizar Pago", "", "", lblTabpagerealizarpago_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPPagarCitaOriginal.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPageRealizarPago") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABREALIZARPAGOContainer"+"panel3"+"\" style=\"display:none;\">") ;
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTerminoscondiciones.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavTerminoscondiciones.getInternalname(), "Terminos Condiciones", "col-sm-3 CheckboxTCLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 325,'',false,'" + sGXsfl_20_idx + "',0)\"" ;
         ClassString = "CheckboxTC" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTerminoscondiciones.getInternalname(), GXutil.booltostr( AV39TerminosCondiciones), "", "Terminos Condiciones", 1, chkavTerminoscondiciones.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(325, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,325);\"");
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
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 328,'',false,'',0)\"" ;
         ClassString = "ButtonCancelarP" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttCancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Cancelar", bttCancelar_Jsonclick, 7, "Cancelar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e116p1_client"+"'", TempTags, "", 2, "HLP_WPPagarCitaOriginal.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 330,'',false,'',0)\"" ;
         ClassString = "ButtonAnterior" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttAnteriorpagar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Anterior ", bttAnteriorpagar_Jsonclick, 7, "Anterior ", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e136p1_client"+"'", TempTags, "", 2, "HLP_WPPagarCitaOriginal.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 332,'',false,'',0)\"" ;
         ClassString = "ButtonSiguiente" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttPagar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 20, 2, 0)+","+"null"+");", "Pagar", bttPagar_Jsonclick, 5, "Pagar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'REALIZARPAGO\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPPagarCitaOriginal.htm");
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
               AV46GXV1 = nGXsfl_20_idx ;
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
               AV57GXV12 = nGXsfl_99_idx ;
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
      if ( wbEnd == 157 )
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
               AV69GXV24 = nGXsfl_157_idx ;
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
      if ( wbEnd == 245 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridboletaContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV81GXV36 = nGXsfl_245_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridboletaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridboleta", GridboletaContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridboletaContainerData", GridboletaContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridboletaContainerData"+"V", GridboletaContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridboletaContainerData"+"V"+"\" value='"+GridboletaContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 281 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridfacturaContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV89GXV44 = nGXsfl_281_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridfacturaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridfactura", GridfacturaContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridfacturaContainerData", GridfacturaContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridfacturaContainerData"+"V", GridfacturaContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridfacturaContainerData"+"V"+"\" value='"+GridfacturaContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start6P2( )
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
         Form.getMeta().addItem("description", "Pagar cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup6P0( ) ;
   }

   public void ws6P2( )
   {
      start6P2( ) ;
      evt6P2( ) ;
   }

   public void evt6P2( )
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
                           e146P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'SIGUIENTEINFORMACIONPACIENTE'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'SiguienteInformacionPaciente' */
                           e156P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'SIGUIENTEFACTURACION'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'SiguienteFacturacion' */
                           e166P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'REALIZARPAGO'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'RealizarPago' */
                           e176P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.OPENFORMNIUBIZ") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e186P2 ();
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
                           subsflControlProps_996( ) ;
                           GXCCtl = "FILEUPLOADPACIENTE_Autoupload_" + sGXsfl_99_idx ;
                           Fileuploadpaciente_Autoupload = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucFileuploadpaciente.sendProperty(context, "", false, Fileuploadpaciente_Internalname, "AutoUpload", GXutil.booltostr( Fileuploadpaciente_Autoupload));
                           GXCCtl = "FILEUPLOADPACIENTE_Hideadditionalbuttons_" + sGXsfl_99_idx ;
                           Fileuploadpaciente_Hideadditionalbuttons = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucFileuploadpaciente.sendProperty(context, "", false, Fileuploadpaciente_Internalname, "HideAdditionalButtons", GXutil.booltostr( Fileuploadpaciente_Hideadditionalbuttons));
                           GXCCtl = "FILEUPLOADPACIENTE_Enableuploadedfilecanceling_" + sGXsfl_99_idx ;
                           Fileuploadpaciente_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucFileuploadpaciente.sendProperty(context, "", false, Fileuploadpaciente_Internalname, "EnableUploadedFileCanceling", GXutil.booltostr( Fileuploadpaciente_Enableuploadedfilecanceling));
                           GXCCtl = "FILEUPLOADPACIENTE_Maxnumberoffiles_" + sGXsfl_99_idx ;
                           Fileuploadpaciente_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
                           ucFileuploadpaciente.sendProperty(context, "", false, Fileuploadpaciente_Internalname, "MaxNumberOfFiles", GXutil.ltrimstr( DecimalUtil.doubleToDec(Fileuploadpaciente_Maxnumberoffiles), 9, 0));
                           AV57GXV12 = nGXsfl_99_idx ;
                           if ( ( AV32SDTPaciente.size() >= AV57GXV12 ) && ( AV57GXV12 > 0 ) )
                           {
                              AV32SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)) );
                           }
                           GXCCtl = "vFILEUPLOADPACIENTE_" + sGXsfl_99_idx ;
                           httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV16FileUploadPaciente);
                           GXCCtl = "vFAILEDFILES_" + sGXsfl_99_idx ;
                           httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV42FailedFiles);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDPACIENTE.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e196P6 ();
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
                           nGXsfl_157_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_157_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_157_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1575( ) ;
                           GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Autoupload_" + sGXsfl_157_idx ;
                           Fileuploadpacientefamiliar_Autoupload = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucFileuploadpacientefamiliar.sendProperty(context, "", false, Fileuploadpacientefamiliar_Internalname, "AutoUpload", GXutil.booltostr( Fileuploadpacientefamiliar_Autoupload));
                           GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling_" + sGXsfl_157_idx ;
                           Fileuploadpacientefamiliar_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
                           ucFileuploadpacientefamiliar.sendProperty(context, "", false, Fileuploadpacientefamiliar_Internalname, "EnableUploadedFileCanceling", GXutil.booltostr( Fileuploadpacientefamiliar_Enableuploadedfilecanceling));
                           GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles_" + sGXsfl_157_idx ;
                           Fileuploadpacientefamiliar_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
                           ucFileuploadpacientefamiliar.sendProperty(context, "", false, Fileuploadpacientefamiliar_Internalname, "MaxNumberOfFiles", GXutil.ltrimstr( DecimalUtil.doubleToDec(Fileuploadpacientefamiliar_Maxnumberoffiles), 9, 0));
                           AV69GXV24 = nGXsfl_157_idx ;
                           if ( ( AV33SDTPacienteFamiliar.size() >= AV69GXV24 ) && ( AV69GXV24 > 0 ) )
                           {
                              AV33SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)) );
                           }
                           GXCCtl = "vFILEUPLOADPACIENTEFAMILIAR_" + sGXsfl_157_idx ;
                           httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV17FileUploadPacienteFamiliar);
                           GXCCtl = "vFAILEDFILES_" + sGXsfl_157_idx ;
                           httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV42FailedFiles);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDPACIENTEFAMILIAR.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e206P5 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 15), "GRIDBOLETA.LOAD") == 0 )
                        {
                           nGXsfl_245_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_245_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_245_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2454( ) ;
                           AV81GXV36 = nGXsfl_245_idx ;
                           if ( ( AV30SDTFacturacionBoleta.size() >= AV81GXV36 ) && ( AV81GXV36 > 0 ) )
                           {
                              AV30SDTFacturacionBoleta.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDBOLETA.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e216P4 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 16), "GRIDFACTURA.LOAD") == 0 )
                        {
                           nGXsfl_281_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_281_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_281_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2813( ) ;
                           AV89GXV44 = nGXsfl_281_idx ;
                           if ( ( AV31SDTFacturacionFactura.size() >= AV89GXV44 ) && ( AV89GXV44 > 0 ) )
                           {
                              AV31SDTFacturacionFactura.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDFACTURA.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e226P3 ();
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
                           AV46GXV1 = nGXsfl_20_idx ;
                           if ( ( AV29SDTDetalleCita.size() >= AV46GXV1 ) && ( AV46GXV1 > 0 ) )
                           {
                              AV29SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)) );
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
                                 e236P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID5.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e246P2 ();
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

   public void we6P2( )
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

   public void pa6P2( )
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

   public void gxnrgridfactura_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2813( ) ;
      while ( nGXsfl_281_idx <= nRC_GXsfl_281 )
      {
         sendrow_2813( ) ;
         nGXsfl_281_idx = ((subGridfactura_Islastpage==1)&&(nGXsfl_281_idx+1>subgridfactura_fnc_recordsperpage( )) ? 1 : nGXsfl_281_idx+1) ;
         sGXsfl_281_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_281_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2813( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridfacturaContainer)) ;
      /* End function gxnrGridfactura_newrow */
   }

   public void gxnrgridboleta_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2454( ) ;
      while ( nGXsfl_245_idx <= nRC_GXsfl_245 )
      {
         sendrow_2454( ) ;
         nGXsfl_245_idx = ((subGridboleta_Islastpage==1)&&(nGXsfl_245_idx+1>subgridboleta_fnc_recordsperpage( )) ? 1 : nGXsfl_245_idx+1) ;
         sGXsfl_245_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_245_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2454( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridboletaContainer)) ;
      /* End function gxnrGridboleta_newrow */
   }

   public void gxnrgridpacientefamiliar_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1575( ) ;
      while ( nGXsfl_157_idx <= nRC_GXsfl_157 )
      {
         sendrow_1575( ) ;
         nGXsfl_157_idx = ((subGridpacientefamiliar_Islastpage==1)&&(nGXsfl_157_idx+1>subgridpacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_157_idx+1) ;
         sGXsfl_157_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_157_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1575( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridpacientefamiliarContainer)) ;
      /* End function gxnrGridpacientefamiliar_newrow */
   }

   public void gxnrgridpaciente_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_996( ) ;
      while ( nGXsfl_99_idx <= nRC_GXsfl_99 )
      {
         sendrow_996( ) ;
         nGXsfl_99_idx = ((subGridpaciente_Islastpage==1)&&(nGXsfl_99_idx+1>subgridpaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_99_idx+1) ;
         sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_996( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridpacienteContainer)) ;
      /* End function gxnrGridpaciente_newrow */
   }

   public void gxgrgrid5_refresh( boolean AV6Boleta ,
                                  boolean AV13Factura ,
                                  boolean AV39TerminosCondiciones ,
                                  GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV32SDTPaciente ,
                                  GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV30SDTFacturacionBoleta ,
                                  GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV31SDTFacturacionFactura ,
                                  GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV29SDTDetalleCita ,
                                  int AV25PacienteId ,
                                  int AV11DisponibilidadId ,
                                  java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID5_nCurrentRecord = 0 ;
      rf6P2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid5_refresh */
   }

   public void gxgrgridpaciente_refresh( boolean AV6Boleta ,
                                         boolean AV13Factura ,
                                         boolean AV39TerminosCondiciones ,
                                         GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV32SDTPaciente ,
                                         GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV30SDTFacturacionBoleta ,
                                         GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV31SDTFacturacionFactura ,
                                         GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV29SDTDetalleCita ,
                                         int AV25PacienteId ,
                                         int AV11DisponibilidadId ,
                                         java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDPACIENTE_nCurrentRecord = 0 ;
      rf6P6( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridpaciente_refresh */
   }

   public void gxgrgridpacientefamiliar_refresh( boolean AV6Boleta ,
                                                 boolean AV13Factura ,
                                                 boolean AV39TerminosCondiciones ,
                                                 GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV32SDTPaciente ,
                                                 GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV30SDTFacturacionBoleta ,
                                                 GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV31SDTFacturacionFactura ,
                                                 GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV29SDTDetalleCita ,
                                                 int AV25PacienteId ,
                                                 int AV11DisponibilidadId ,
                                                 java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDPACIENTEFAMILIAR_nCurrentRecord = 0 ;
      rf6P5( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridpacientefamiliar_refresh */
   }

   public void gxgrgridboleta_refresh( boolean AV6Boleta ,
                                       boolean AV13Factura ,
                                       boolean AV39TerminosCondiciones ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV32SDTPaciente ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV30SDTFacturacionBoleta ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV31SDTFacturacionFactura ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV29SDTDetalleCita ,
                                       int AV25PacienteId ,
                                       int AV11DisponibilidadId ,
                                       java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDBOLETA_nCurrentRecord = 0 ;
      rf6P4( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridboleta_refresh */
   }

   public void gxgrgridfactura_refresh( boolean AV6Boleta ,
                                        boolean AV13Factura ,
                                        boolean AV39TerminosCondiciones ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV32SDTPaciente ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV30SDTFacturacionBoleta ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV31SDTFacturacionFactura ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV29SDTDetalleCita ,
                                        int AV25PacienteId ,
                                        int AV11DisponibilidadId ,
                                        java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDFACTURA_nCurrentRecord = 0 ;
      rf6P3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridfactura_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILEUPLOADPACIENTE", getSecureSignedToken( "", AV16FileUploadPaciente));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFILEUPLOADPACIENTE", PrivateUtilities.encodeString( AV16FileUploadPaciente.toxml(false, true, "FileUploadDataCollection", "ProjectThani")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vFILEUPLOADPACIENTEFAMILIAR", getSecureSignedToken( "", AV17FileUploadPacienteFamiliar));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vFILEUPLOADPACIENTEFAMILIAR", PrivateUtilities.encodeString( AV17FileUploadPacienteFamiliar.toxml(false, true, "FileUploadDataCollection", "ProjectThani")));
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
         AV9CitaFamiliar = cmbavCitafamiliar.getValidValue(AV9CitaFamiliar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CitaFamiliar", AV9CitaFamiliar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCitafamiliar.setValue( GXutil.rtrim( AV9CitaFamiliar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCitafamiliar.getInternalname(), "Values", cmbavCitafamiliar.ToJavascriptSource(), true);
      }
      if ( cmbavPacientefamiliarid.getItemCount() > 0 )
      {
         AV24PacienteFamiliarId = (int)(GXutil.lval( cmbavPacientefamiliarid.getValidValue(GXutil.trim( GXutil.str( AV24PacienteFamiliarId, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24PacienteFamiliarId), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavPacientefamiliarid.setValue( GXutil.trim( GXutil.str( AV24PacienteFamiliarId, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavPacientefamiliarid.getInternalname(), "Values", cmbavPacientefamiliarid.ToJavascriptSource(), true);
      }
      AV6Boleta = GXutil.strtobool( GXutil.booltostr( AV6Boleta)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6Boleta", AV6Boleta);
      AV13Factura = GXutil.strtobool( GXutil.booltostr( AV13Factura)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Factura", AV13Factura);
      AV39TerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV39TerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TerminosCondiciones", AV39TerminosCondiciones);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf6P2( ) ;
      rf6P6( ) ;
      rf6P5( ) ;
      rf6P4( ) ;
      rf6P3( ) ;
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
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlid_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombres_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidopaterno_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidomaterno_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtltipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtltipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtltipodocumento_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnrodocumento_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimiento_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlsexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsexo_Enabled), 5, 0), !bGXsfl_157_Refreshing);
   }

   public void rf6P2( )
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
         e246P2 ();
         wbEnd = (short)(20) ;
         wb6P0( ) ;
      }
      bGXsfl_20_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6P2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV25PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25PacienteId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPACIENTE", AV32SDTPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPACIENTE", AV32SDTPaciente);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTPACIENTE", getSecureSignedToken( "", AV32SDTPaciente));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTDETALLECITA", AV29SDTDetalleCita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTDETALLECITA", AV29SDTDetalleCita);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTDETALLECITA", getSecureSignedToken( "", AV29SDTDetalleCita));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTFACTURACIONBOLETA", AV30SDTFacturacionBoleta);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTFACTURACIONBOLETA", AV30SDTFacturacionBoleta);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTFACTURACIONBOLETA", getSecureSignedToken( "", AV30SDTFacturacionBoleta));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTFACTURACIONFACTURA", AV31SDTFacturacionFactura);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTFACTURACIONFACTURA", AV31SDTFacturacionFactura);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTFACTURACIONFACTURA", getSecureSignedToken( "", AV31SDTFacturacionFactura));
   }

   public void rf6P3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridfacturaContainer.ClearRows();
      }
      wbStart = (short)(281) ;
      nGXsfl_281_idx = 1 ;
      sGXsfl_281_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_281_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2813( ) ;
      bGXsfl_281_Refreshing = true ;
      GridfacturaContainer.AddObjectProperty("GridName", "Gridfactura");
      GridfacturaContainer.AddObjectProperty("CmpContext", "");
      GridfacturaContainer.AddObjectProperty("InMasterPage", "false");
      GridfacturaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridfacturaContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridfacturaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridfacturaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridfacturaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridfactura_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridfacturaContainer.setPageSize( subgridfactura_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2813( ) ;
         e226P3 ();
         wbEnd = (short)(281) ;
         wb6P0( ) ;
      }
      bGXsfl_281_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6P3( )
   {
   }

   public void rf6P4( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridboletaContainer.ClearRows();
      }
      wbStart = (short)(245) ;
      nGXsfl_245_idx = 1 ;
      sGXsfl_245_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_245_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2454( ) ;
      bGXsfl_245_Refreshing = true ;
      GridboletaContainer.AddObjectProperty("GridName", "Gridboleta");
      GridboletaContainer.AddObjectProperty("CmpContext", "");
      GridboletaContainer.AddObjectProperty("InMasterPage", "false");
      GridboletaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      GridboletaContainer.AddObjectProperty("Class", "FreeStyleGrid");
      GridboletaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridboletaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridboletaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridboleta_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridboletaContainer.setPageSize( subgridboleta_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2454( ) ;
         e216P4 ();
         wbEnd = (short)(245) ;
         wb6P0( ) ;
      }
      bGXsfl_245_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6P4( )
   {
   }

   public void rf6P5( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridpacientefamiliarContainer.ClearRows();
      }
      wbStart = (short)(157) ;
      nGXsfl_157_idx = 1 ;
      sGXsfl_157_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_157_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1575( ) ;
      bGXsfl_157_Refreshing = true ;
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
         subsflControlProps_1575( ) ;
         e206P5 ();
         wbEnd = (short)(157) ;
         wb6P0( ) ;
      }
      bGXsfl_157_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6P5( )
   {
   }

   public void rf6P6( )
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
      subsflControlProps_996( ) ;
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
         subsflControlProps_996( ) ;
         e196P6 ();
         wbEnd = (short)(99) ;
         wb6P0( ) ;
      }
      bGXsfl_99_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes6P6( )
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

   public int subgridfactura_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridfactura_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridfactura_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridfactura_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subgridboleta_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridboleta_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subgridboleta_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subgridboleta_fnc_currentpage( )
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
      Gx_date = GXutil.today( ) ;
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
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlid_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnombres_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidopaterno_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlapellidomaterno_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtltipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtltipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtltipodocumento_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlnrodocumento_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlfechanacimiento_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      edtavCtlsexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCtlsexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCtlsexo_Enabled), 5, 0), !bGXsfl_157_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup6P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e236P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtpaciente"), AV32SDTPaciente);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtpacientefamiliar"), AV33SDTPacienteFamiliar);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtfacturacionboleta"), AV30SDTFacturacionBoleta);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtfacturacionfactura"), AV31SDTFacturacionFactura);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtdetallecita"), AV29SDTDetalleCita);
         /* Read saved values. */
         nRC_GXsfl_20 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_20"), ",", ".")) ;
         nRC_GXsfl_99 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_99"), ",", ".")) ;
         nRC_GXsfl_157 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_157"), ",", ".")) ;
         nRC_GXsfl_245 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_245"), ",", ".")) ;
         nRC_GXsfl_281 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_281"), ",", ".")) ;
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
            AV46GXV1 = nGXsfl_20_fel_idx ;
            if ( ( AV29SDTDetalleCita.size() >= AV46GXV1 ) && ( AV46GXV1 > 0 ) )
            {
               AV29SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)) );
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
            subsflControlProps_fel_996( ) ;
            GXCCtl = "FILEUPLOADPACIENTE_Autoupload_" + sGXsfl_99_fel_idx ;
            Fileuploadpaciente_Autoupload = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
            GXCCtl = "FILEUPLOADPACIENTE_Hideadditionalbuttons_" + sGXsfl_99_fel_idx ;
            Fileuploadpaciente_Hideadditionalbuttons = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
            GXCCtl = "FILEUPLOADPACIENTE_Enableuploadedfilecanceling_" + sGXsfl_99_fel_idx ;
            Fileuploadpaciente_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
            GXCCtl = "FILEUPLOADPACIENTE_Maxnumberoffiles_" + sGXsfl_99_fel_idx ;
            Fileuploadpaciente_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
            AV57GXV12 = nGXsfl_99_fel_idx ;
            if ( ( AV32SDTPaciente.size() >= AV57GXV12 ) && ( AV57GXV12 > 0 ) )
            {
               AV32SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)) );
            }
            GXCCtl = "vFILEUPLOADPACIENTE_" + sGXsfl_99_fel_idx ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV16FileUploadPaciente);
            GXCCtl = "vFAILEDFILES_" + sGXsfl_99_fel_idx ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV42FailedFiles);
         }
         if ( nGXsfl_99_fel_idx == 0 )
         {
            nGXsfl_99_idx = 1 ;
            sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_996( ) ;
         }
         nGXsfl_99_fel_idx = 1 ;
         nRC_GXsfl_157 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_157"), ",", ".")) ;
         nGXsfl_157_fel_idx = 0 ;
         while ( nGXsfl_157_fel_idx < nRC_GXsfl_157 )
         {
            nGXsfl_157_fel_idx = ((subGridpacientefamiliar_Islastpage==1)&&(nGXsfl_157_fel_idx+1>subgridpacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_157_fel_idx+1) ;
            sGXsfl_157_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_157_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1575( ) ;
            GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Autoupload_" + sGXsfl_157_fel_idx ;
            Fileuploadpacientefamiliar_Autoupload = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
            GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling_" + sGXsfl_157_fel_idx ;
            Fileuploadpacientefamiliar_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
            GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles_" + sGXsfl_157_fel_idx ;
            Fileuploadpacientefamiliar_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ",", ".")) ;
            AV69GXV24 = nGXsfl_157_fel_idx ;
            if ( ( AV33SDTPacienteFamiliar.size() >= AV69GXV24 ) && ( AV69GXV24 > 0 ) )
            {
               AV33SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)) );
            }
            GXCCtl = "vFILEUPLOADPACIENTEFAMILIAR_" + sGXsfl_157_fel_idx ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV17FileUploadPacienteFamiliar);
            GXCCtl = "vFAILEDFILES_" + sGXsfl_157_fel_idx ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( GXCCtl), AV42FailedFiles);
         }
         if ( nGXsfl_157_fel_idx == 0 )
         {
            nGXsfl_157_idx = 1 ;
            sGXsfl_157_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_157_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1575( ) ;
         }
         nGXsfl_157_fel_idx = 1 ;
         nRC_GXsfl_245 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_245"), ",", ".")) ;
         nGXsfl_245_fel_idx = 0 ;
         while ( nGXsfl_245_fel_idx < nRC_GXsfl_245 )
         {
            nGXsfl_245_fel_idx = ((subGridboleta_Islastpage==1)&&(nGXsfl_245_fel_idx+1>subgridboleta_fnc_recordsperpage( )) ? 1 : nGXsfl_245_fel_idx+1) ;
            sGXsfl_245_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_245_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2454( ) ;
            AV81GXV36 = nGXsfl_245_fel_idx ;
            if ( ( AV30SDTFacturacionBoleta.size() >= AV81GXV36 ) && ( AV81GXV36 > 0 ) )
            {
               AV30SDTFacturacionBoleta.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)) );
            }
         }
         if ( nGXsfl_245_fel_idx == 0 )
         {
            nGXsfl_245_idx = 1 ;
            sGXsfl_245_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_245_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2454( ) ;
         }
         nGXsfl_245_fel_idx = 1 ;
         nRC_GXsfl_281 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_281"), ",", ".")) ;
         nGXsfl_281_fel_idx = 0 ;
         while ( nGXsfl_281_fel_idx < nRC_GXsfl_281 )
         {
            nGXsfl_281_fel_idx = ((subGridfactura_Islastpage==1)&&(nGXsfl_281_fel_idx+1>subgridfactura_fnc_recordsperpage( )) ? 1 : nGXsfl_281_fel_idx+1) ;
            sGXsfl_281_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_281_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2813( ) ;
            AV89GXV44 = nGXsfl_281_fel_idx ;
            if ( ( AV31SDTFacturacionFactura.size() >= AV89GXV44 ) && ( AV89GXV44 > 0 ) )
            {
               AV31SDTFacturacionFactura.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)) );
            }
         }
         if ( nGXsfl_281_fel_idx == 0 )
         {
            nGXsfl_281_idx = 1 ;
            sGXsfl_281_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_281_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2813( ) ;
         }
         nGXsfl_281_fel_idx = 1 ;
         /* Read variables values. */
         cmbavCitafamiliar.setName( cmbavCitafamiliar.getInternalname() );
         cmbavCitafamiliar.setValue( httpContext.cgiGet( cmbavCitafamiliar.getInternalname()) );
         AV9CitaFamiliar = httpContext.cgiGet( cmbavCitafamiliar.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CitaFamiliar", AV9CitaFamiliar);
         cmbavPacientefamiliarid.setName( cmbavPacientefamiliarid.getInternalname() );
         cmbavPacientefamiliarid.setValue( httpContext.cgiGet( cmbavPacientefamiliarid.getInternalname()) );
         AV24PacienteFamiliarId = (int)(GXutil.lval( httpContext.cgiGet( cmbavPacientefamiliarid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24PacienteFamiliarId), 8, 0));
         AV6Boleta = GXutil.strtobool( httpContext.cgiGet( chkavBoleta.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6Boleta", AV6Boleta);
         AV13Factura = GXutil.strtobool( httpContext.cgiGet( chkavFactura.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13Factura", AV13Factura);
         AV39TerminosCondiciones = GXutil.strtobool( httpContext.cgiGet( chkavTerminoscondiciones.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39TerminosCondiciones", AV39TerminosCondiciones);
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
      e236P2 ();
      if (returnInSub) return;
   }

   public void e236P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/PagarCita.css\">" );
      Form.getJscriptsrc().add(new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "urlOpenFormNiubiz")) ;
      Form.getJscriptsrc().add("./JSNiubiz.js") ;
      Form.getJscriptsrc().add("./JSUtils.js") ;
      if ( (GXutil.strcmp("", AV41WebSession.getValue("WSPacienteId"))==0) )
      {
         callWebObject(formatLink("com.projectthani.wploginpaciente", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "ShowTab", "", new Object[] {Integer.valueOf(1)});
      this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(2)});
      this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(3)});
      AV25PacienteId = (int)(GXutil.lval( AV41WebSession.getValue("WSPacienteId"))) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25PacienteId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV25PacienteId), "ZZZZZZZ9")));
      GXt_objcol_SdtSDTInformacionDeLaCita1 = AV29SDTDetalleCita ;
      GXv_objcol_SdtSDTInformacionDeLaCita2[0] = GXt_objcol_SdtSDTInformacionDeLaCita1 ;
      new com.projectthani.prcinformaciondelacita(remoteHandle, context).execute( AV11DisponibilidadId, GXv_objcol_SdtSDTInformacionDeLaCita2) ;
      GXt_objcol_SdtSDTInformacionDeLaCita1 = GXv_objcol_SdtSDTInformacionDeLaCita2[0] ;
      AV29SDTDetalleCita = GXt_objcol_SdtSDTInformacionDeLaCita1 ;
      gx_BV20 = true ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = AV32SDTPaciente ;
      GXv_objcol_SdtSDTInformacionDelPaciente4[0] = GXt_objcol_SdtSDTInformacionDelPaciente3 ;
      new com.projectthani.prcinformaciondelpaciente(remoteHandle, context).execute( AV25PacienteId, GXv_objcol_SdtSDTInformacionDelPaciente4) ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = GXv_objcol_SdtSDTInformacionDelPaciente4[0] ;
      AV32SDTPaciente = GXt_objcol_SdtSDTInformacionDelPaciente3 ;
      gx_BV99 = true ;
      subGridpaciente_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridpacienteContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridpaciente_Visible), 5, 0), true);
      subGridpacientefamiliar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, "GridpacientefamiliarContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subGridpacientefamiliar_Visible), 5, 0), true);
      cmbavPacientefamiliarid.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavPacientefamiliarid.getInternalname(), "Visible", GXutil.ltrimstr( cmbavPacientefamiliarid.getVisible(), 5, 0), true);
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[0] = AV15FamiliarList ;
      new com.projectthani.prcgetlistadopacientefamiliarcombobox(remoteHandle, context).execute( AV25PacienteId, GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5) ;
      AV15FamiliarList = GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[0] ;
      AV95GXV50 = 1 ;
      while ( AV95GXV50 <= AV15FamiliarList.size() )
      {
         AV14FamiliarItem = (com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)((com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)AV15FamiliarList.elementAt(-1+AV95GXV50));
         cmbavPacientefamiliarid.addItem(GXutil.trim( GXutil.str( AV14FamiliarItem.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid(), 8, 0)), AV14FamiliarItem.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos(), (short)(0));
         AV95GXV50 = (int)(AV95GXV50+1) ;
      }
      divSectionboleta_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divSectionboleta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divSectionboleta_Visible), 5, 0), true);
      divSectionfactura_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divSectionfactura_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divSectionfactura_Visible), 5, 0), true);
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 = AV30SDTFacturacionBoleta ;
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7[0] = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 ;
      new com.projectthani.prcinformaciondelpacienteboleta(remoteHandle, context).execute( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV41WebSession.getValue("WSPacienteId"), "."))), GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7) ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 = GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7[0] ;
      AV30SDTFacturacionBoleta = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 ;
      gx_BV245 = true ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 = AV31SDTFacturacionFactura ;
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9[0] = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 ;
      new com.projectthani.prcinformaciondelpacientefactura(remoteHandle, context).execute( GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9) ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 = GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9[0] ;
      AV31SDTFacturacionFactura = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 ;
      gx_BV281 = true ;
   }

   public void e146P2( )
   {
      AV69GXV24 = nGXsfl_157_idx ;
      if ( AV33SDTPacienteFamiliar.size() >= AV69GXV24 )
      {
         AV33SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)) );
      }
      /* Pacientefamiliarid_Controlvaluechanged Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10[0] = AV33SDTPacienteFamiliar ;
      new com.projectthani.prcgetpacientefamiliarporpaciente(remoteHandle, context).execute( AV25PacienteId, AV24PacienteFamiliarId, GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10) ;
      AV33SDTPacienteFamiliar = GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10[0] ;
      gx_BV157 = true ;
      /*  Sending Event outputs  */
      if ( gx_BV157 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV33SDTPacienteFamiliar", AV33SDTPacienteFamiliar);
         nGXsfl_157_bak_idx = nGXsfl_157_idx ;
         gxgrgridpacientefamiliar_refresh( AV6Boleta, AV13Factura, AV39TerminosCondiciones, AV32SDTPaciente, AV30SDTFacturacionBoleta, AV31SDTFacturacionFactura, AV29SDTDetalleCita, AV25PacienteId, AV11DisponibilidadId, Gx_date) ;
         nGXsfl_157_idx = nGXsfl_157_bak_idx ;
         sGXsfl_157_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_157_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1575( ) ;
      }
   }

   public void e156P2( )
   {
      AV69GXV24 = nGXsfl_157_idx ;
      if ( AV33SDTPacienteFamiliar.size() >= AV69GXV24 )
      {
         AV33SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)) );
      }
      AV57GXV12 = nGXsfl_99_idx ;
      if ( AV32SDTPaciente.size() >= AV57GXV12 )
      {
         AV32SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)) );
      }
      /* 'SiguienteInformacionPaciente' Routine */
      returnInSub = false ;
      AV7CheckResult = true ;
      if ( GXutil.strcmp(AV9CitaFamiliar, "No") == 0 )
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso())==0) )
         {
            AV7CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Peso no debe esta vacío.", "notice", "", "true"));
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura())==0) )
         {
            AV7CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Estatura no debe esta vacío.", "notice", "", "true"));
         }
         if ( (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta())==0) )
         {
            AV7CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Motivo consulta no debe esta vacío.", "notice", "", "true"));
         }
      }
      else if ( GXutil.strcmp(AV9CitaFamiliar, "Si") == 0 )
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso())==0) )
         {
            AV7CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Peso no debe esta vacío.", "notice", "", "true"));
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura())==0) )
         {
            AV7CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Estatura no debe esta vacío.", "notice", "", "true"));
         }
         if ( (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta())==0) )
         {
            AV7CheckResult = false ;
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Motivo consulta no debe esta vacío.", "notice", "", "true"));
         }
      }
      if ( AV7CheckResult )
      {
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "ShowTab", "", new Object[] {Integer.valueOf(2)});
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(1)});
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(3)});
      }
   }

   public void e166P2( )
   {
      /* 'SiguienteFacturacion' Routine */
      returnInSub = false ;
      AV7CheckResult = true ;
      if ( ! AV6Boleta && ! AV13Factura )
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "Debe seleccionar un comprobante de pago.", "notice", "", "true"));
         AV7CheckResult = false ;
      }
      if ( AV7CheckResult )
      {
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "ShowTab", "", new Object[] {Integer.valueOf(3)});
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(1)});
         this.executeUsercontrolMethod("", false, "TABREALIZARPAGOContainer", "HideTab", "", new Object[] {Integer.valueOf(2)});
      }
   }

   public void e176P2( )
   {
      AV69GXV24 = nGXsfl_157_idx ;
      if ( AV33SDTPacienteFamiliar.size() >= AV69GXV24 )
      {
         AV33SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)) );
      }
      AV57GXV12 = nGXsfl_99_idx ;
      if ( AV32SDTPaciente.size() >= AV57GXV12 )
      {
         AV32SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)) );
      }
      AV46GXV1 = nGXsfl_20_idx ;
      if ( AV29SDTDetalleCita.size() >= AV46GXV1 )
      {
         AV29SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)) );
      }
      AV81GXV36 = nGXsfl_245_idx ;
      if ( AV30SDTFacturacionBoleta.size() >= AV81GXV36 )
      {
         AV30SDTFacturacionBoleta.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)) );
      }
      AV89GXV44 = nGXsfl_281_idx ;
      if ( AV31SDTFacturacionFactura.size() >= AV89GXV44 )
      {
         AV31SDTFacturacionFactura.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)) );
      }
      /* 'RealizarPago' Routine */
      returnInSub = false ;
      if ( AV39TerminosCondiciones )
      {
         /* Execute user subroutine: 'CREATECITA' */
         S112 ();
         if (returnInSub) return;
         AV18hasErrors = false ;
         GXv_char11[0] = AV5accessToken ;
         GXv_char12[0] = AV12ErrorMessage ;
         GXv_int13[0] = AV20HttpStatus ;
         new com.projectthani.prccreaciontoken(remoteHandle, context).execute( GXv_char11, GXv_char12, GXv_int13) ;
         wppagarcitaoriginal_impl.this.AV5accessToken = GXv_char11[0] ;
         wppagarcitaoriginal_impl.this.AV12ErrorMessage = GXv_char12[0] ;
         wppagarcitaoriginal_impl.this.AV20HttpStatus = GXv_int13[0] ;
         if ( AV20HttpStatus != 201 )
         {
            httpContext.GX_msglist.addItem(AV12ErrorMessage);
            AV18hasErrors = true ;
         }
         if ( ! AV18hasErrors )
         {
            AV10clientIp = "190.237.7.159" ;
            GXv_char12[0] = AV40tokenSession ;
            GXv_char11[0] = AV12ErrorMessage ;
            GXv_int13[0] = AV20HttpStatus ;
            GXv_SdtSDTResponseTokenSession20014[0] = AV35SDTResponseTokenSession200;
            GXv_SdtSDTResponseTokenSession40015[0] = AV36SDTResponseTokenSession400;
            GXv_char16[0] = AV37temp ;
            new com.projectthani.prcwstokensession(remoteHandle, context).execute( new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "merchantId"), DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), AV5accessToken, AV25PacienteId, AV10clientIp, GXv_char12, GXv_char11, GXv_int13, GXv_SdtSDTResponseTokenSession20014, GXv_SdtSDTResponseTokenSession40015, GXv_char16) ;
            wppagarcitaoriginal_impl.this.AV40tokenSession = GXv_char12[0] ;
            wppagarcitaoriginal_impl.this.AV12ErrorMessage = GXv_char11[0] ;
            wppagarcitaoriginal_impl.this.AV20HttpStatus = GXv_int13[0] ;
            AV35SDTResponseTokenSession200 = GXv_SdtSDTResponseTokenSession20014[0] ;
            AV36SDTResponseTokenSession400 = GXv_SdtSDTResponseTokenSession40015[0] ;
            wppagarcitaoriginal_impl.this.AV37temp = GXv_char16[0] ;
            AV34SDTRequestTokenSession.setgxTv_SdtSDTRequestTokenSession_Amount( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()) );
            AV34SDTRequestTokenSession.setgxTv_SdtSDTRequestTokenSession_Channel( "web" );
            if ( AV20HttpStatus == 400 )
            {
               AV12ErrorMessage = AV36SDTResponseTokenSession400.getgxTv_SdtSDTResponseTokenSession400_Errormessage() ;
            }
            if ( AV20HttpStatus != 200 )
            {
               AV18hasErrors = true ;
               httpContext.GX_msglist.addItem(AV12ErrorMessage);
            }
            if ( ! AV18hasErrors )
            {
               AV28purchaseNumber = GXutil.trim( GXutil.str( AV11DisponibilidadId, 8, 0)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV28purchaseNumber", AV28purchaseNumber);
               AV41WebSession.setValue("accessTokenNiubiz", AV5accessToken);
               AV41WebSession.setValue("purchaseNumber", AV28purchaseNumber);
               AV41WebSession.setValue("monto", GXutil.str( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(), 4, 0));
               this.executeExternalObjectMethod("", false, "GlobalEvents", "openFormNiubiz", new Object[] {}, true);
            }
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "Debe aceptar los terminos y condiciones para realizar el pago.", "notice", "", "true"));
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV35SDTResponseTokenSession200", AV35SDTResponseTokenSession200);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV34SDTRequestTokenSession", AV34SDTRequestTokenSession);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV8Cita", AV8Cita);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV27Pago", AV27Pago);
   }

   public void e186P2( )
   {
      AV46GXV1 = nGXsfl_20_idx ;
      if ( AV29SDTDetalleCita.size() >= AV46GXV1 )
      {
         AV29SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)) );
      }
      AV89GXV44 = nGXsfl_281_idx ;
      if ( AV31SDTFacturacionFactura.size() >= AV89GXV44 )
      {
         AV31SDTFacturacionFactura.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)) );
      }
      AV81GXV36 = nGXsfl_245_idx ;
      if ( AV30SDTFacturacionBoleta.size() >= AV81GXV36 )
      {
         AV30SDTFacturacionBoleta.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)) );
      }
      /* GlobalEvents_Openformniubiz Routine */
      returnInSub = false ;
      if ( AV6Boleta )
      {
         AV96Dato1 = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres() ;
         AV97Dato2 = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos() ;
         AV98Correo = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail() ;
      }
      else
      {
         AV96Dato1 = "" ;
         AV97Dato2 = "" ;
         AV98Correo = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail() ;
      }
      this.executeExternalObjectMethod("", false, "AV22JSNiubiz", "openForm", new Object[] {AV96Dato1,AV97Dato2,AV98Correo,AV35SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey(),"web",new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "merchantId"),AV28purchaseNumber,((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(),Integer.valueOf(20),new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "ThaniMainUrl")+formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) ,new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "urlLogoThaniFormNiubiz"),"#000000",new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "ThaniMainUrl")+formatLink("com.projectthani.wprespuestaniubiz", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"}) }, false);
   }

   public void S112( )
   {
      /* 'CREATECITA' Routine */
      returnInSub = false ;
      if ( ( AV25PacienteId > 0 ) && ( AV11DisponibilidadId > 0 ) )
      {
         if ( GXutil.strcmp(AV9CitaFamiliar, "Si") == 0 )
         {
            AV8Cita.setgxTv_SdtCita_Pacienteid( AV24PacienteFamiliarId );
            AV8Cita.setgxTv_SdtCita_Citamotivoconsulta( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta() );
            AV8Cita.setgxTv_SdtCita_Citapeso( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso() );
            AV8Cita.setgxTv_SdtCita_Citaestatura( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura() );
            if ( AV17FileUploadPacienteFamiliar.size() > 0 )
            {
               AV8Cita.setgxTv_SdtCita_Citaarchivo( ((com.projectthani.SdtFileUploadData)AV17FileUploadPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
               AV8Cita.setgxTv_SdtCita_Citaarchivonombre( ((com.projectthani.SdtFileUploadData)AV17FileUploadPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtFileUploadData_Name() );
               AV8Cita.setgxTv_SdtCita_Citaarchivoextencion( ((com.projectthani.SdtFileUploadData)AV17FileUploadPacienteFamiliar.elementAt(-1+1)).getgxTv_SdtFileUploadData_Extension() );
            }
         }
         else
         {
            AV8Cita.setgxTv_SdtCita_Pacienteid( AV25PacienteId );
            AV8Cita.setgxTv_SdtCita_Citamotivoconsulta( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta() );
            AV8Cita.setgxTv_SdtCita_Citapeso( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso() );
            AV8Cita.setgxTv_SdtCita_Citaestatura( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura() );
            if ( AV16FileUploadPaciente.size() > 0 )
            {
               AV8Cita.setgxTv_SdtCita_Citaarchivo( ((com.projectthani.SdtFileUploadData)AV16FileUploadPaciente.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
               AV8Cita.setgxTv_SdtCita_Citaarchivonombre( ((com.projectthani.SdtFileUploadData)AV16FileUploadPaciente.elementAt(-1+1)).getgxTv_SdtFileUploadData_Name() );
               AV8Cita.setgxTv_SdtCita_Citaarchivoextencion( ((com.projectthani.SdtFileUploadData)AV16FileUploadPaciente.elementAt(-1+1)).getgxTv_SdtFileUploadData_Extension() );
            }
         }
         AV8Cita.setgxTv_SdtCita_Sgcitadisponibilidadid( AV11DisponibilidadId );
         AV8Cita.setgxTv_SdtCita_Citafechareserva( GXutil.now( ) );
         AV8Cita.setgxTv_SdtCita_Citaestado( "A" );
         AV8Cita.setgxTv_SdtCita_Citaestadopago( "G" );
         AV8Cita.setgxTv_SdtCita_Citaestadocita( "R" );
         GXt_char17 = "" ;
         GXv_char16[0] = GXt_char17 ;
         new com.projectthani.prcgenerarcodigocita(remoteHandle, context).execute( AV11DisponibilidadId, GXv_char16) ;
         wppagarcitaoriginal_impl.this.GXt_char17 = GXv_char16[0] ;
         AV8Cita.setgxTv_SdtCita_Citacode( GXt_char17 );
         AV41WebSession.setValue("CitaTemporal", AV8Cita.toJSonString(true, true));
         AV27Pago.setgxTv_SdtPago_Pagomonto( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()) );
         if ( AV6Boleta )
         {
            AV27Pago.setgxTv_SdtPago_Pagotipodocumentocliente( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento() );
            AV27Pago.setgxTv_SdtPago_Pagoclientenrodocumento( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento() );
            AV27Pago.setgxTv_SdtPago_Pagoclientedenominacion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres()+" "+((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos() );
            AV27Pago.setgxTv_SdtPago_Pagoclientedireccion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion() );
            AV27Pago.setgxTv_SdtPago_Pagoclienteemail( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail() );
            AV27Pago.setgxTv_SdtPago_Pagotipodocumento( (short)(2) );
            AV27Pago.setgxTv_SdtPago_Pagofechaemision( Gx_date );
         }
         else if ( AV13Factura )
         {
            AV27Pago.setgxTv_SdtPago_Pagotipodocumentocliente( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento() );
            AV27Pago.setgxTv_SdtPago_Pagoclientenrodocumento( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento() );
            AV27Pago.setgxTv_SdtPago_Pagoclientedenominacion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial() );
            AV27Pago.setgxTv_SdtPago_Pagoclientedireccion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion() );
            AV27Pago.setgxTv_SdtPago_Pagotipodocumento( (short)(1) );
            AV27Pago.setgxTv_SdtPago_Pagofechaemision( Gx_date );
         }
         AV41WebSession.setValue("PagoTemporal", AV27Pago.toJSonString(true, true));
         AV41WebSession.setValue("NombreDoctor", ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor());
         AV41WebSession.setValue("FechaCita", localUtil.dtoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), 3, "/"));
         AV41WebSession.setValue("HoraCita", ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora());
      }
      else
      {
         httpContext.GX_msglist.addItem("Error");
      }
   }

   private void e246P2( )
   {
      /* Grid5_Load Routine */
      returnInSub = false ;
      AV46GXV1 = 1 ;
      while ( AV46GXV1 <= AV29SDTDetalleCita.size() )
      {
         AV29SDTDetalleCita.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)) );
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
         AV46GXV1 = (int)(AV46GXV1+1) ;
      }
   }

   private void e226P3( )
   {
      /* Gridfactura_Load Routine */
      returnInSub = false ;
      AV89GXV44 = 1 ;
      while ( AV89GXV44 <= AV31SDTFacturacionFactura.size() )
      {
         AV31SDTFacturacionFactura.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(281) ;
         }
         sendrow_2813( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_281_Refreshing )
         {
            httpContext.doAjaxLoad(281, GridfacturaRow);
         }
         AV89GXV44 = (int)(AV89GXV44+1) ;
      }
   }

   private void e216P4( )
   {
      /* Gridboleta_Load Routine */
      returnInSub = false ;
      AV81GXV36 = 1 ;
      while ( AV81GXV36 <= AV30SDTFacturacionBoleta.size() )
      {
         AV30SDTFacturacionBoleta.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(245) ;
         }
         sendrow_2454( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_245_Refreshing )
         {
            httpContext.doAjaxLoad(245, GridboletaRow);
         }
         AV81GXV36 = (int)(AV81GXV36+1) ;
      }
   }

   private void e206P5( )
   {
      /* Gridpacientefamiliar_Load Routine */
      returnInSub = false ;
      AV69GXV24 = 1 ;
      while ( AV69GXV24 <= AV33SDTPacienteFamiliar.size() )
      {
         AV33SDTPacienteFamiliar.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(157) ;
         }
         sendrow_1575( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_157_Refreshing )
         {
            httpContext.doAjaxLoad(157, GridpacientefamiliarRow);
         }
         AV69GXV24 = (int)(AV69GXV24+1) ;
      }
   }

   private void e196P6( )
   {
      /* Gridpaciente_Load Routine */
      returnInSub = false ;
      AV57GXV12 = 1 ;
      while ( AV57GXV12 <= AV32SDTPaciente.size() )
      {
         AV32SDTPaciente.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(99) ;
         }
         sendrow_996( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_99_Refreshing )
         {
            httpContext.doAjaxLoad(99, GridpacienteRow);
         }
         AV57GXV12 = (int)(AV57GXV12+1) ;
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
      pa6P2( ) ;
      ws6P2( ) ;
      we6P2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110342058", true, true);
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
      httpContext.AddJavascriptSource("wppagarcitaoriginal.js", "?20225110342059", false, true);
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
      wb6P0( ) ;
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
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlsdtinformaciondelacitaid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitaid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitaid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor()) ;
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
      Grid5Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitanombresdoctor_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitanombresdoctor_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
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
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaespecialidaddoctor_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitaespecialidaddoctor_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitaespecialidaddoctor_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      Grid5Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitaclinica_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitaclinica_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
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
      Grid5Row.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitasede_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitasede_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
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
            if ( ( AV46GXV1 > 0 ) && ( AV29SDTDetalleCita.size() >= AV46GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta())==0) )
            {
               ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( cmbavCtlsdtinformaciondelacitatipoconsulta.getValidValue(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
            }
         }
      }
      /* ComboBox */
      Grid5Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavCtlsdtinformaciondelacitatipoconsulta,cmbavCtlsdtinformaciondelacitatipoconsulta.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()),Integer.valueOf(1),cmbavCtlsdtinformaciondelacitatipoconsulta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavCtlsdtinformaciondelacitatipoconsulta.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","AttDetalleCita","","","","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavCtlsdtinformaciondelacitatipoconsulta.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
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
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitafecha_Internalname,localUtil.format(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitafecha_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitafecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitahora_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitahora_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitahora_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      Grid5Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelacitacosto_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlsdtinformaciondelacitacosto_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelacitacosto_Jsonclick,Integer.valueOf(0),"AttDetalleCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelacitacosto_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(20),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      Grid5Row.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6P2( ) ;
      /* End of Columns property logic. */
      Grid5Container.AddRow(Grid5Row);
      nGXsfl_20_idx = ((subGrid5_Islastpage==1)&&(nGXsfl_20_idx+1>subgrid5_fnc_recordsperpage( )) ? 1 : nGXsfl_20_idx+1) ;
      sGXsfl_20_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_20_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_202( ) ;
      /* End function sendrow_202 */
   }

   public void subsflControlProps_996( )
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
      lblTextblock2_Internalname = "TEXTBLOCK2_"+sGXsfl_99_idx ;
      Fileuploadpaciente_Internalname = "FILEUPLOADPACIENTE_"+sGXsfl_99_idx ;
   }

   public void subsflControlProps_fel_996( )
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
      lblTextblock2_Internalname = "TEXTBLOCK2_"+sGXsfl_99_fel_idx ;
      Fileuploadpaciente_Internalname = "FILEUPLOADPACIENTE_"+sGXsfl_99_fel_idx ;
   }

   public void sendrow_996( )
   {
      subsflControlProps_996( ) ;
      wb6P0( ) ;
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid(), (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlsdtinformaciondelpacienteid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteid()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacienteid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacienteid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientenombres_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientenombres_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientenombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacienteRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteapellidos_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacienteapellidos_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(4),"row",StyleString,ClassString,"","","250",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientetipodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientetipodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientetipodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientenrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientenrodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientenrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefechanacimiento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefechanacimiento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientefechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientesexo_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientesexo_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacientesexo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      sendrow_99630( ) ;
   }

   public void sendrow_99630( )
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteemail_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacienteemail_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsdtinformaciondelpacienteemail_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientepeso_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso(), "ZZ9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientepeso_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientepeso_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,139);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientepeso_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacienteestatura_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura(), (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura(), "9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacienteestatura_Enabled!=0)&&(edtavCtlsdtinformaciondelpacienteestatura_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,143);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacienteestatura_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      GridpacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV32SDTPaciente.elementAt(-1+AV57GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientemotivoconsulta_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientemotivoconsulta_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,148);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientemotivoconsulta_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(99),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Text block */
      GridpacienteRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblock2_Internalname,"Si cuenta con una historia clínica externa puede adjuntarla, si es más de un archivo comprimirlo","","",lblTextblock2_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* User Defined Control */
      GridpacienteRow.AddColumnProperties("usercontrol", -1, isAjaxCallMode( ), new Object[] {"FILEUPLOADPACIENTEContainer"+"_"+sGXsfl_99_idx,Integer.valueOf(-1)});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6P6( ) ;
      GXCCtl = "vFILEUPLOADPACIENTE_" + sGXsfl_99_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV16FileUploadPaciente);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV16FileUploadPaciente);
      }
      GXCCtl = "vFAILEDFILES_" + sGXsfl_99_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV42FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV42FailedFiles);
      }
      GXCCtl = "FILEUPLOADPACIENTE_Autoupload_" + sGXsfl_99_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Fileuploadpaciente_Autoupload));
      GXCCtl = "FILEUPLOADPACIENTE_Hideadditionalbuttons_" + sGXsfl_99_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Fileuploadpaciente_Hideadditionalbuttons));
      GXCCtl = "FILEUPLOADPACIENTE_Enableuploadedfilecanceling_" + sGXsfl_99_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Fileuploadpaciente_Enableuploadedfilecanceling));
      GXCCtl = "FILEUPLOADPACIENTE_Maxnumberoffiles_" + sGXsfl_99_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Fileuploadpaciente_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      /* End of Columns property logic. */
      GridpacienteContainer.AddRow(GridpacienteRow);
      nGXsfl_99_idx = ((subGridpaciente_Islastpage==1)&&(nGXsfl_99_idx+1>subgridpaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_99_idx+1) ;
      sGXsfl_99_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_99_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_996( ) ;
      /* End function sendrow_996 */
   }

   public void subsflControlProps_1575( )
   {
      edtavCtlid_Internalname = "CTLID_"+sGXsfl_157_idx ;
      edtavCtlnombres_Internalname = "CTLNOMBRES_"+sGXsfl_157_idx ;
      edtavCtlapellidopaterno_Internalname = "CTLAPELLIDOPATERNO_"+sGXsfl_157_idx ;
      edtavCtlapellidomaterno_Internalname = "CTLAPELLIDOMATERNO_"+sGXsfl_157_idx ;
      edtavCtltipodocumento_Internalname = "CTLTIPODOCUMENTO_"+sGXsfl_157_idx ;
      edtavCtlnrodocumento_Internalname = "CTLNRODOCUMENTO_"+sGXsfl_157_idx ;
      edtavCtlfechanacimiento_Internalname = "CTLFECHANACIMIENTO_"+sGXsfl_157_idx ;
      edtavCtlsexo_Internalname = "CTLSEXO_"+sGXsfl_157_idx ;
      edtavCtlestatura_Internalname = "CTLESTATURA_"+sGXsfl_157_idx ;
      edtavCtlpeso_Internalname = "CTLPESO_"+sGXsfl_157_idx ;
      edtavCtlmotivoconsulta_Internalname = "CTLMOTIVOCONSULTA_"+sGXsfl_157_idx ;
      lblTextblock3_Internalname = "TEXTBLOCK3_"+sGXsfl_157_idx ;
      Fileuploadpacientefamiliar_Internalname = "FILEUPLOADPACIENTEFAMILIAR_"+sGXsfl_157_idx ;
   }

   public void subsflControlProps_fel_1575( )
   {
      edtavCtlid_Internalname = "CTLID_"+sGXsfl_157_fel_idx ;
      edtavCtlnombres_Internalname = "CTLNOMBRES_"+sGXsfl_157_fel_idx ;
      edtavCtlapellidopaterno_Internalname = "CTLAPELLIDOPATERNO_"+sGXsfl_157_fel_idx ;
      edtavCtlapellidomaterno_Internalname = "CTLAPELLIDOMATERNO_"+sGXsfl_157_fel_idx ;
      edtavCtltipodocumento_Internalname = "CTLTIPODOCUMENTO_"+sGXsfl_157_fel_idx ;
      edtavCtlnrodocumento_Internalname = "CTLNRODOCUMENTO_"+sGXsfl_157_fel_idx ;
      edtavCtlfechanacimiento_Internalname = "CTLFECHANACIMIENTO_"+sGXsfl_157_fel_idx ;
      edtavCtlsexo_Internalname = "CTLSEXO_"+sGXsfl_157_fel_idx ;
      edtavCtlestatura_Internalname = "CTLESTATURA_"+sGXsfl_157_fel_idx ;
      edtavCtlpeso_Internalname = "CTLPESO_"+sGXsfl_157_fel_idx ;
      edtavCtlmotivoconsulta_Internalname = "CTLMOTIVOCONSULTA_"+sGXsfl_157_fel_idx ;
      lblTextblock3_Internalname = "TEXTBLOCK3_"+sGXsfl_157_fel_idx ;
      Fileuploadpacientefamiliar_Internalname = "FILEUPLOADPACIENTEFAMILIAR_"+sGXsfl_157_fel_idx ;
   }

   public void sendrow_1575( )
   {
      subsflControlProps_1575( ) ;
      wb6P0( ) ;
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
         if ( ((int)((nGXsfl_157_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subGridpacientefamiliar_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_157_idx+"\">") ;
      }
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid3table_Internalname+"_"+sGXsfl_157_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id(), (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( ((edtavCtlid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id()), "ZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Id()), "ZZZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlnombres_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlnombres_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlnombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlapellidopaterno_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlapellidopaterno_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlapellidopaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlapellidomaterno_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlapellidomaterno_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlapellidomaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtltipodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtltipodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtltipodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlnrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlnrodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlnrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlfechanacimiento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlfechanacimiento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlfechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      sendrow_157530( ) ;
   }

   public void sendrow_157530( )
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
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsexo_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsexo_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavCtlsexo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
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
      TempTags = " " + ((edtavCtlestatura_Enabled!=0)&&(edtavCtlestatura_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 197,'',false,'"+sGXsfl_157_idx+"',157)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlestatura_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura(), (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura(), "9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlestatura_Enabled!=0)&&(edtavCtlestatura_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,197);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlestatura_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      TempTags = " " + ((edtavCtlpeso_Enabled!=0)&&(edtavCtlpeso_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 201,'',false,'"+sGXsfl_157_idx+"',157)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlpeso_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso(), "ZZ9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavCtlpeso_Enabled!=0)&&(edtavCtlpeso_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,201);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlpeso_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
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
      TempTags = " " + ((edtavCtlmotivoconsulta_Enabled!=0)&&(edtavCtlmotivoconsulta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 206,'',false,'"+sGXsfl_157_idx+"',157)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridpacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlmotivoconsulta_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV33SDTPacienteFamiliar.elementAt(-1+AV69GXV24)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlmotivoconsulta_Enabled!=0)&&(edtavCtlmotivoconsulta_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,206);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlmotivoconsulta_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(4000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(157),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Text block */
      GridpacientefamiliarRow.AddColumnProperties("label", 1, isAjaxCallMode( ), new Object[] {lblTextblock3_Internalname,"Si cuenta con una historia clínica externa puede adjuntarla, si es más de un archivo comprimirlo","","",lblTextblock3_Jsonclick,"'"+""+"'"+",false,"+"'"+""+"'","","TextBlock",Integer.valueOf(0),"",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0)});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridpacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* User Defined Control */
      GridpacientefamiliarRow.AddColumnProperties("usercontrol", -1, isAjaxCallMode( ), new Object[] {"FILEUPLOADPACIENTEFAMILIARContainer"+"_"+sGXsfl_157_idx,Integer.valueOf(-1)});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridpacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6P5( ) ;
      GXCCtl = "vFILEUPLOADPACIENTEFAMILIAR_" + sGXsfl_157_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV17FileUploadPacienteFamiliar);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV17FileUploadPacienteFamiliar);
      }
      GXCCtl = "vFAILEDFILES_" + sGXsfl_157_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV42FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV42FailedFiles);
      }
      GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Autoupload_" + sGXsfl_157_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Fileuploadpacientefamiliar_Autoupload));
      GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Enableuploadedfilecanceling_" + sGXsfl_157_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.booltostr( Fileuploadpacientefamiliar_Enableuploadedfilecanceling));
      GXCCtl = "FILEUPLOADPACIENTEFAMILIAR_Maxnumberoffiles_" + sGXsfl_157_idx ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Fileuploadpacientefamiliar_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      /* End of Columns property logic. */
      GridpacientefamiliarContainer.AddRow(GridpacientefamiliarRow);
      nGXsfl_157_idx = ((subGridpacientefamiliar_Islastpage==1)&&(nGXsfl_157_idx+1>subgridpacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_157_idx+1) ;
      sGXsfl_157_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_157_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1575( ) ;
      /* End function sendrow_1575 */
   }

   public void subsflControlProps_2454( )
   {
      edtavCtlsdtinformaciondelpacientefacturacionbnombres_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBNOMBRES_"+sGXsfl_245_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBAPELLIDOS_"+sGXsfl_245_idx ;
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setInternalname( "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_"+sGXsfl_245_idx );
      edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBNRODOCUMENTO_"+sGXsfl_245_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTELEFONO_"+sGXsfl_245_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBEMAIL_"+sGXsfl_245_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBDIRECCION_"+sGXsfl_245_idx ;
   }

   public void subsflControlProps_fel_2454( )
   {
      edtavCtlsdtinformaciondelpacientefacturacionbnombres_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBNOMBRES_"+sGXsfl_245_fel_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBAPELLIDOS_"+sGXsfl_245_fel_idx ;
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setInternalname( "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_"+sGXsfl_245_fel_idx );
      edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBNRODOCUMENTO_"+sGXsfl_245_fel_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTELEFONO_"+sGXsfl_245_fel_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBEMAIL_"+sGXsfl_245_fel_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBDIRECCION_"+sGXsfl_245_fel_idx ;
   }

   public void sendrow_2454( )
   {
      subsflControlProps_2454( ) ;
      wb6P0( ) ;
      GridboletaRow = GXWebRow.GetNew(context,GridboletaContainer) ;
      if ( subGridboleta_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridboleta_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridboleta_Class, "") != 0 )
         {
            subGridboleta_Linesclass = subGridboleta_Class+"Odd" ;
         }
      }
      else if ( subGridboleta_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridboleta_Backstyle = (byte)(0) ;
         subGridboleta_Backcolor = subGridboleta_Allbackcolor ;
         if ( GXutil.strcmp(subGridboleta_Class, "") != 0 )
         {
            subGridboleta_Linesclass = subGridboleta_Class+"Uniform" ;
         }
      }
      else if ( subGridboleta_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridboleta_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridboleta_Class, "") != 0 )
         {
            subGridboleta_Linesclass = subGridboleta_Class+"Odd" ;
         }
         subGridboleta_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridboleta_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridboleta_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_245_idx) % (2))) == 0 )
         {
            subGridboleta_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridboleta_Class, "") != 0 )
            {
               subGridboleta_Linesclass = subGridboleta_Class+"Even" ;
            }
         }
         else
         {
            subGridboleta_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridboleta_Class, "") != 0 )
            {
               subGridboleta_Linesclass = subGridboleta_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridboletaContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridboleta_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_245_idx+"\">") ;
      }
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid4table_Internalname+"_"+sGXsfl_245_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionbnombres_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbnombres_Internalname,"Nombres","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionbnombres_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbnombres_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 251,'',false,'"+sGXsfl_245_idx+"',245)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbnombres_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionbnombres_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbnombres_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,251);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionbnombres_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(245),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Internalname,"Apellido Paterno","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 255,'',false,'"+sGXsfl_245_idx+"',245)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,255);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(245),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getInternalname(),"Tipo Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      TempTags = " " + ((cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getEnabled()!=0)&&(cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 259,'',false,'"+sGXsfl_245_idx+"',245)\"" : " ") ;
      if ( ( cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_" + sGXsfl_245_idx ;
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setName( GXCCtl );
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setWebtags( "" );
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("6", "RUC", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("1", "DNI", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("7", "PASAPORTE", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("A", "CDI", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
         if ( cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getItemCount() > 0 )
         {
            if ( ( AV81GXV36 > 0 ) && ( AV30SDTFacturacionBoleta.size() >= AV81GXV36 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento())==0) )
            {
               ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento( cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()) );
            }
         }
      }
      /* ComboBox */
      GridboletaRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento,cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()),Integer.valueOf(1),cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","AttributePagarCita","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getEnabled()!=0)&&(cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,259);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getInternalname(), "Values", cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.ToJavascriptSource(), !bGXsfl_245_Refreshing);
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Internalname,"Nro Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 264,'',false,'"+sGXsfl_245_idx+"',245)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,264);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(245),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Internalname,"Telefono","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 268,'',false,'"+sGXsfl_245_idx+"',245)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Internalname,GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono()),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,268);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(20),"chr",Integer.valueOf(1),"row",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(245),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionbemail_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbemail_Internalname,"Correo","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionbemail_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbemail_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 272,'',false,'"+sGXsfl_245_idx+"',245)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbemail_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionbemail_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbemail_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,272);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionbemail_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(245),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Internalname,"Direccion","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      sendrow_245430( ) ;
   }

   public void sendrow_245430( )
   {
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 277,'',false,'"+sGXsfl_245_idx+"',245)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,277);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(245),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6P4( ) ;
      /* End of Columns property logic. */
      GridboletaContainer.AddRow(GridboletaRow);
      nGXsfl_245_idx = ((subGridboleta_Islastpage==1)&&(nGXsfl_245_idx+1>subgridboleta_fnc_recordsperpage( )) ? 1 : nGXsfl_245_idx+1) ;
      sGXsfl_245_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_245_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2454( ) ;
      /* End function sendrow_2454 */
   }

   public void subsflControlProps_2813( )
   {
      edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFRAZONSOCIAL_"+sGXsfl_281_idx ;
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setInternalname( "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_"+sGXsfl_281_idx );
      edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFNRODOCUMENTO_"+sGXsfl_281_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionfemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFEMAIL_"+sGXsfl_281_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFDIRECCION_"+sGXsfl_281_idx ;
   }

   public void subsflControlProps_fel_2813( )
   {
      edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFRAZONSOCIAL_"+sGXsfl_281_fel_idx ;
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setInternalname( "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_"+sGXsfl_281_fel_idx );
      edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFNRODOCUMENTO_"+sGXsfl_281_fel_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionfemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFEMAIL_"+sGXsfl_281_fel_idx ;
      edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFDIRECCION_"+sGXsfl_281_fel_idx ;
   }

   public void sendrow_2813( )
   {
      subsflControlProps_2813( ) ;
      wb6P0( ) ;
      GridfacturaRow = GXWebRow.GetNew(context,GridfacturaContainer) ;
      if ( subGridfactura_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridfactura_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridfactura_Class, "") != 0 )
         {
            subGridfactura_Linesclass = subGridfactura_Class+"Odd" ;
         }
      }
      else if ( subGridfactura_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridfactura_Backstyle = (byte)(0) ;
         subGridfactura_Backcolor = subGridfactura_Allbackcolor ;
         if ( GXutil.strcmp(subGridfactura_Class, "") != 0 )
         {
            subGridfactura_Linesclass = subGridfactura_Class+"Uniform" ;
         }
      }
      else if ( subGridfactura_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridfactura_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridfactura_Class, "") != 0 )
         {
            subGridfactura_Linesclass = subGridfactura_Class+"Odd" ;
         }
         subGridfactura_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subGridfactura_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridfactura_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_281_idx) % (2))) == 0 )
         {
            subGridfactura_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridfactura_Class, "") != 0 )
            {
               subGridfactura_Linesclass = subGridfactura_Class+"Even" ;
            }
         }
         else
         {
            subGridfactura_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subGridfactura_Class, "") != 0 )
            {
               subGridfactura_Linesclass = subGridfactura_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( GridfacturaContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subGridfactura_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_281_idx+"\">") ;
      }
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divGrid6table_Internalname+"_"+sGXsfl_281_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Internalname,"Razon Social","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 287,'',false,'"+sGXsfl_281_idx+"',281)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,287);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(150),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(281),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getInternalname(),"Tipo Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      TempTags = " " + ((cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getEnabled()!=0)&&(cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 292,'',false,'"+sGXsfl_281_idx+"',281)\"" : " ") ;
      if ( ( cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_" + sGXsfl_281_idx ;
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setName( GXCCtl );
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setWebtags( "" );
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("6", "RUC", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("1", "DNI", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("7", "PASAPORTE", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("A", "CDI", (short)(0));
         cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
         if ( cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getItemCount() > 0 )
         {
            if ( ( AV89GXV44 > 0 ) && ( AV31SDTFacturacionFactura.size() >= AV89GXV44 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento())==0) )
            {
               ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento( cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()) );
            }
         }
      }
      /* ComboBox */
      GridfacturaRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento,cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()),Integer.valueOf(1),cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","AttributePagarCita","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getEnabled()!=0)&&(cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,292);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getInternalname(), "Values", cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.ToJavascriptSource(), !bGXsfl_281_Refreshing);
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Internalname,"Nro Documento","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 296,'',false,'"+sGXsfl_281_idx+"',281)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,296);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(281),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-4","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionfemail_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfemail_Internalname,"Correo","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionfemail_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfemail_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 300,'',false,'"+sGXsfl_281_idx+"',281)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfemail_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionfemail_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfemail_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,300);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionfemail_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(281),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Internalname,"Direccion","col-xs-12 AttributePagarCitaLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 305,'',false,'"+sGXsfl_281_idx+"',281)\"" : " ") ;
      ROClassString = "AttributePagarCita" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Enabled!=0)&&(edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,305);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Jsonclick,Integer.valueOf(0),"AttributePagarCita","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(150),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(281),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes6P3( ) ;
      /* End of Columns property logic. */
      GridfacturaContainer.AddRow(GridfacturaRow);
      nGXsfl_281_idx = ((subGridfactura_Islastpage==1)&&(nGXsfl_281_idx+1>subgridfactura_fnc_recordsperpage( )) ? 1 : nGXsfl_281_idx+1) ;
      sGXsfl_281_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_281_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2813( ) ;
      /* End function sendrow_2813 */
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
      lblTextblock2_Internalname = "TEXTBLOCK2" ;
      Fileuploadpaciente_Internalname = "FILEUPLOADPACIENTE" ;
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
      lblTextblock3_Internalname = "TEXTBLOCK3" ;
      Fileuploadpacientefamiliar_Internalname = "FILEUPLOADPACIENTEFAMILIAR" ;
      divGrid3table_Internalname = "GRID3TABLE" ;
      divTable6_Internalname = "TABLE6" ;
      bttCancelar1_Internalname = "CANCELAR1" ;
      bttSiguienteinfopaciente_Internalname = "SIGUIENTEINFOPACIENTE" ;
      divTabpage1table_Internalname = "TABPAGE1TABLE" ;
      lblTabpagefacturacion_title_Internalname = "TABPAGEFACTURACION_TITLE" ;
      chkavBoleta.setInternalname( "vBOLETA" );
      chkavFactura.setInternalname( "vFACTURA" );
      divGroup1table_Internalname = "GROUP1TABLE" ;
      grpGroup1_Internalname = "GROUP1" ;
      divTable8_Internalname = "TABLE8" ;
      edtavCtlsdtinformaciondelpacientefacturacionbnombres_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBNOMBRES" ;
      edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBAPELLIDOS" ;
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setInternalname( "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO" );
      edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBNRODOCUMENTO" ;
      edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTELEFONO" ;
      edtavCtlsdtinformaciondelpacientefacturacionbemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBEMAIL" ;
      edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBDIRECCION" ;
      divGrid4table_Internalname = "GRID4TABLE" ;
      divSectionboleta_Internalname = "SECTIONBOLETA" ;
      edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFRAZONSOCIAL" ;
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setInternalname( "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO" );
      edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFNRODOCUMENTO" ;
      edtavCtlsdtinformaciondelpacientefacturacionfemail_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFEMAIL" ;
      edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Internalname = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFDIRECCION" ;
      divGrid6table_Internalname = "GRID6TABLE" ;
      divSectionfactura_Internalname = "SECTIONFACTURA" ;
      divTable7_Internalname = "TABLE7" ;
      bttCancelar2_Internalname = "CANCELAR2" ;
      bttAnteriorinformacionpaciente_Internalname = "ANTERIORINFORMACIONPACIENTE" ;
      bttSiguientefacturacion_Internalname = "SIGUIENTEFACTURACION" ;
      divTabpage2table_Internalname = "TABPAGE2TABLE" ;
      lblTabpagerealizarpago_title_Internalname = "TABPAGEREALIZARPAGO_TITLE" ;
      chkavTerminoscondiciones.setInternalname( "vTERMINOSCONDICIONES" );
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
      subGridboleta_Internalname = "GRIDBOLETA" ;
      subGridfactura_Internalname = "GRIDFACTURA" ;
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
      edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionfemail_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionfemail_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionfemail_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Enabled = 1 ;
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setJsonclick( "" );
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setVisible( 1 );
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setEnabled( 1 );
      edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Enabled = 1 ;
      subGridfactura_Class = "FreeStyleGrid" ;
      edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbemail_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionbemail_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbemail_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Enabled = 1 ;
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setJsonclick( "" );
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setVisible( 1 );
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setEnabled( 1 );
      edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Enabled = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbnombres_Jsonclick = "" ;
      edtavCtlsdtinformaciondelpacientefacturacionbnombres_Visible = 1 ;
      edtavCtlsdtinformaciondelpacientefacturacionbnombres_Enabled = 1 ;
      subGridboleta_Class = "FreeStyleGrid" ;
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
      Fileuploadpacientefamiliar_Maxnumberoffiles = 1 ;
      Fileuploadpacientefamiliar_Enableuploadedfilecanceling = GXutil.toBoolean( 0) ;
      Fileuploadpacientefamiliar_Autoupload = GXutil.toBoolean( -1) ;
      Fileuploadpaciente_Maxnumberoffiles = 1 ;
      Fileuploadpaciente_Enableuploadedfilecanceling = GXutil.toBoolean( -1) ;
      Fileuploadpaciente_Hideadditionalbuttons = GXutil.toBoolean( 0) ;
      Fileuploadpaciente_Autoupload = GXutil.toBoolean( -1) ;
      chkavTerminoscondiciones.setEnabled( 1 );
      subGridfactura_Allowcollapsing = (byte)(0) ;
      subGridfactura_Backcolorstyle = (byte)(0) ;
      divSectionfactura_Visible = 1 ;
      subGridboleta_Allowcollapsing = (byte)(0) ;
      subGridboleta_Backcolorstyle = (byte)(0) ;
      divSectionboleta_Visible = 1 ;
      chkavFactura.setEnabled( 1 );
      chkavBoleta.setEnabled( 1 );
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
      lblTextblock2_Caption = "Si cuenta con una historia clínica externa puede adjuntarla, si es más de un archivo comprimirlo" ;
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
      Form.setCaption( "Pagar cita" );
      Tabrealizarpago_Historymanagement = GXutil.toBoolean( 0) ;
      Tabrealizarpago_Class = "TabPagarCita" ;
      Tabrealizarpago_Pagecount = 3 ;
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
         if ( ( AV46GXV1 > 0 ) && ( AV29SDTDetalleCita.size() >= AV46GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta())==0) )
         {
            ((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( cmbavCtlsdtinformaciondelacitatipoconsulta.getValidValue(((com.projectthani.SdtSDTInformacionDeLaCita)AV29SDTDetalleCita.elementAt(-1+AV46GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
         }
      }
      cmbavCitafamiliar.setName( "vCITAFAMILIAR" );
      cmbavCitafamiliar.setWebtags( "" );
      cmbavCitafamiliar.addItem("No", "No", (short)(0));
      cmbavCitafamiliar.addItem("Si", "Si", (short)(0));
      if ( cmbavCitafamiliar.getItemCount() > 0 )
      {
         AV9CitaFamiliar = cmbavCitafamiliar.getValidValue(AV9CitaFamiliar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV9CitaFamiliar", AV9CitaFamiliar);
      }
      cmbavPacientefamiliarid.setName( "vPACIENTEFAMILIARID" );
      cmbavPacientefamiliarid.setWebtags( "" );
      cmbavPacientefamiliarid.addItem(GXutil.trim( GXutil.str( 0, 8, 0)), "Seleccionar:", (short)(0));
      if ( cmbavPacientefamiliarid.getItemCount() > 0 )
      {
         AV24PacienteFamiliarId = (int)(GXutil.lval( cmbavPacientefamiliarid.getValidValue(GXutil.trim( GXutil.str( AV24PacienteFamiliarId, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24PacienteFamiliarId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24PacienteFamiliarId), 8, 0));
      }
      chkavBoleta.setName( "vBOLETA" );
      chkavBoleta.setWebtags( "" );
      chkavBoleta.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavBoleta.getInternalname(), "TitleCaption", chkavBoleta.getCaption(), true);
      chkavBoleta.setCheckedValue( "false" );
      AV6Boleta = GXutil.strtobool( GXutil.booltostr( AV6Boleta)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6Boleta", AV6Boleta);
      chkavFactura.setName( "vFACTURA" );
      chkavFactura.setWebtags( "" );
      chkavFactura.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavFactura.getInternalname(), "TitleCaption", chkavFactura.getCaption(), true);
      chkavFactura.setCheckedValue( "false" );
      AV13Factura = GXutil.strtobool( GXutil.booltostr( AV13Factura)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Factura", AV13Factura);
      GXCCtl = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_" + sGXsfl_245_idx ;
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setName( GXCCtl );
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.setWebtags( "" );
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("6", "RUC", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("1", "DNI", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("A", "CDI", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
      if ( cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getItemCount() > 0 )
      {
         if ( ( AV81GXV36 > 0 ) && ( AV30SDTFacturacionBoleta.size() >= AV81GXV36 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento())==0) )
         {
            ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento( cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV30SDTFacturacionBoleta.elementAt(-1+AV81GXV36)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()) );
         }
      }
      GXCCtl = "CTLSDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_" + sGXsfl_281_idx ;
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setName( GXCCtl );
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.setWebtags( "" );
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("6", "RUC", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("1", "DNI", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("A", "CDI", (short)(0));
      cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
      if ( cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getItemCount() > 0 )
      {
         if ( ( AV89GXV44 > 0 ) && ( AV31SDTFacturacionFactura.size() >= AV89GXV44 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento())==0) )
         {
            ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento( cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV31SDTFacturacionFactura.elementAt(-1+AV89GXV44)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()) );
         }
      }
      chkavTerminoscondiciones.setName( "vTERMINOSCONDICIONES" );
      chkavTerminoscondiciones.setWebtags( "" );
      chkavTerminoscondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTerminoscondiciones.getInternalname(), "TitleCaption", chkavTerminoscondiciones.getCaption(), true);
      chkavTerminoscondiciones.setCheckedValue( "false" );
      AV39TerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV39TerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39TerminosCondiciones", AV39TerminosCondiciones);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID5_nFirstRecordOnPage'},{av:'GRID5_nEOF'},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'GRIDFACTURA_nEOF'},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'GRIDBOLETA_nEOF'},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'GRIDPACIENTEFAMILIAR_nEOF'},{av:'AV33SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:157,pic:''},{av:'nRC_GXsfl_157',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:157},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'GRIDPACIENTE_nEOF'},{av:'AV32SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV30SDTFacturacionBoleta',fld:'vSDTFACTURACIONBOLETA',grid:245,pic:'',hsh:true},{av:'nRC_GXsfl_245',ctrl:'GRIDBOLETA',prop:'GridRC',grid:245},{av:'AV31SDTFacturacionFactura',fld:'vSDTFACTURACIONFACTURA',grid:281,pic:'',hsh:true},{av:'nRC_GXsfl_281',ctrl:'GRIDFACTURA',prop:'GridRC',grid:281},{av:'AV29SDTDetalleCita',fld:'vSDTDETALLECITA',grid:20,pic:'',hsh:true},{av:'nRC_GXsfl_20',ctrl:'GRID5',prop:'GridRC',grid:20},{av:'AV25PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV11DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VPACIENTEFAMILIARID.CONTROLVALUECHANGED","{handler:'e146P2',iparms:[{av:'AV25PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavPacientefamiliarid'},{av:'AV24PacienteFamiliarId',fld:'vPACIENTEFAMILIARID',pic:'ZZZZZZZ9'},{av:'AV33SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:157,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_157',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:157},{av:'GRID5_nFirstRecordOnPage'},{av:'GRID5_nEOF'},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'GRIDFACTURA_nEOF'},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'GRIDBOLETA_nEOF'},{av:'GRIDPACIENTEFAMILIAR_nEOF'},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'GRIDPACIENTE_nEOF'},{av:'AV32SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV30SDTFacturacionBoleta',fld:'vSDTFACTURACIONBOLETA',grid:245,pic:'',hsh:true},{av:'nRC_GXsfl_245',ctrl:'GRIDBOLETA',prop:'GridRC',grid:245},{av:'AV31SDTFacturacionFactura',fld:'vSDTFACTURACIONFACTURA',grid:281,pic:'',hsh:true},{av:'nRC_GXsfl_281',ctrl:'GRIDFACTURA',prop:'GridRC',grid:281},{av:'AV29SDTDetalleCita',fld:'vSDTDETALLECITA',grid:20,pic:'',hsh:true},{av:'nRC_GXsfl_20',ctrl:'GRID5',prop:'GridRC',grid:20},{av:'AV11DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VPACIENTEFAMILIARID.CONTROLVALUECHANGED",",oparms:[{av:'AV33SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:157,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_157',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:157},{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'CANCELAR'","{handler:'e116P1',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'CANCELAR'",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'SIGUIENTEINFORMACIONPACIENTE'","{handler:'e156P2',iparms:[{av:'cmbavCitafamiliar'},{av:'AV9CitaFamiliar',fld:'vCITAFAMILIAR',pic:''},{av:'AV32SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV33SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:157,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_157',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:157},{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'SIGUIENTEINFORMACIONPACIENTE'",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'ANTERIORINFORMACIONPACIENTE'","{handler:'e126P1',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'ANTERIORINFORMACIONPACIENTE'",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'SIGUIENTEFACTURACION'","{handler:'e166P2',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'SIGUIENTEFACTURACION'",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'ANTERIORPAGAR'","{handler:'e136P1',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'ANTERIORPAGAR'",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'REALIZARPAGO'","{handler:'e176P2',iparms:[{av:'AV29SDTDetalleCita',fld:'vSDTDETALLECITA',grid:20,pic:'',hsh:true},{av:'GRID5_nFirstRecordOnPage'},{av:'nRC_GXsfl_20',ctrl:'GRID5',prop:'GridRC',grid:20},{av:'AV25PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV34SDTRequestTokenSession',fld:'vSDTREQUESTTOKENSESSION',pic:''},{av:'AV11DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavCitafamiliar'},{av:'AV9CitaFamiliar',fld:'vCITAFAMILIAR',pic:''},{av:'cmbavPacientefamiliarid'},{av:'AV24PacienteFamiliarId',fld:'vPACIENTEFAMILIARID',pic:'ZZZZZZZ9'},{av:'AV8Cita',fld:'vCITA',pic:''},{av:'AV33SDTPacienteFamiliar',fld:'vSDTPACIENTEFAMILIAR',grid:157,pic:''},{av:'GRIDPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_157',ctrl:'GRIDPACIENTEFAMILIAR',prop:'GridRC',grid:157},{av:'AV17FileUploadPacienteFamiliar',fld:'vFILEUPLOADPACIENTEFAMILIAR',pic:'',hsh:true},{av:'AV32SDTPaciente',fld:'vSDTPACIENTE',grid:99,pic:'',hsh:true},{av:'GRIDPACIENTE_nFirstRecordOnPage'},{av:'nRC_GXsfl_99',ctrl:'GRIDPACIENTE',prop:'GridRC',grid:99},{av:'AV16FileUploadPaciente',fld:'vFILEUPLOADPACIENTE',pic:'',hsh:true},{av:'AV27Pago',fld:'vPAGO',pic:''},{av:'AV30SDTFacturacionBoleta',fld:'vSDTFACTURACIONBOLETA',grid:245,pic:'',hsh:true},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'nRC_GXsfl_245',ctrl:'GRIDBOLETA',prop:'GridRC',grid:245},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV31SDTFacturacionFactura',fld:'vSDTFACTURACIONFACTURA',grid:281,pic:'',hsh:true},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'nRC_GXsfl_281',ctrl:'GRIDFACTURA',prop:'GridRC',grid:281},{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'REALIZARPAGO'",",oparms:[{av:'AV35SDTResponseTokenSession200',fld:'vSDTRESPONSETOKENSESSION200',pic:''},{av:'AV34SDTRequestTokenSession',fld:'vSDTREQUESTTOKENSESSION',pic:''},{av:'AV28purchaseNumber',fld:'vPURCHASENUMBER',pic:''},{av:'AV8Cita',fld:'vCITA',pic:''},{av:'AV27Pago',fld:'vPAGO',pic:''},{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("GLOBALEVENTS.OPENFORMNIUBIZ","{handler:'e186P2',iparms:[{av:'AV30SDTFacturacionBoleta',fld:'vSDTFACTURACIONBOLETA',grid:245,pic:'',hsh:true},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'nRC_GXsfl_245',ctrl:'GRIDBOLETA',prop:'GridRC',grid:245},{av:'AV31SDTFacturacionFactura',fld:'vSDTFACTURACIONFACTURA',grid:281,pic:'',hsh:true},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'nRC_GXsfl_281',ctrl:'GRIDFACTURA',prop:'GridRC',grid:281},{av:'AV35SDTResponseTokenSession200',fld:'vSDTRESPONSETOKENSESSION200',pic:''},{av:'AV28purchaseNumber',fld:'vPURCHASENUMBER',pic:''},{av:'AV29SDTDetalleCita',fld:'vSDTDETALLECITA',grid:20,pic:'',hsh:true},{av:'GRID5_nFirstRecordOnPage'},{av:'nRC_GXsfl_20',ctrl:'GRID5',prop:'GridRC',grid:20},{av:'AV11DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("GLOBALEVENTS.OPENFORMNIUBIZ",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV8","{handler:'validv_Gxv8',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV8",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv11',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV20","{handler:'validv_Gxv20',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV20",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv23',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv35',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV39","{handler:'validv_Gxv39',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV39",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV42","{handler:'validv_Gxv42',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV42",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv43',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV46","{handler:'validv_Gxv46',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV46",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV48","{handler:'validv_Gxv48',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV48",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv49',iparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV6Boleta',fld:'vBOLETA',pic:''},{av:'AV13Factura',fld:'vFACTURA',pic:''},{av:'AV39TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
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
      AV35SDTResponseTokenSession200 = new com.projectthani.SdtSDTResponseTokenSession200(remoteHandle, context);
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV32SDTPaciente = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>(com.projectthani.SdtSDTInformacionDelPaciente.class, "SDTInformacionDelPaciente", "ProjectThani", remoteHandle);
      AV30SDTFacturacionBoleta = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionB.class, "SDTInformacionDelPacienteFacturacionB", "ProjectThani", remoteHandle);
      AV31SDTFacturacionFactura = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionF.class, "SDTInformacionDelPacienteFacturacionF", "ProjectThani", remoteHandle);
      AV29SDTDetalleCita = new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>(com.projectthani.SdtSDTInformacionDeLaCita.class, "SDTInformacionDeLaCita", "ProjectThani", remoteHandle);
      Gx_date = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV33SDTPacienteFamiliar = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>(com.projectthani.SdtSDTInformacionDelPacienteFamiliar.class, "SDTInformacionDelPacienteFamiliar", "ProjectThani", remoteHandle);
      AV34SDTRequestTokenSession = new com.projectthani.SdtSDTRequestTokenSession(remoteHandle, context);
      AV8Cita = new com.projectthani.SdtCita(remoteHandle);
      AV17FileUploadPacienteFamiliar = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV16FileUploadPaciente = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV27Pago = new com.projectthani.SdtPago(remoteHandle);
      AV28purchaseNumber = "" ;
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
      AV9CitaFamiliar = "" ;
      GridpacienteContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridpaciente_Header = "" ;
      GridpacienteColumn = new com.genexus.webpanels.GXWebColumn();
      GridpacientefamiliarContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridpacientefamiliar_Header = "" ;
      GridpacientefamiliarColumn = new com.genexus.webpanels.GXWebColumn();
      ClassString = "" ;
      StyleString = "" ;
      bttCancelar1_Jsonclick = "" ;
      bttSiguienteinfopaciente_Jsonclick = "" ;
      lblTabpagefacturacion_title_Jsonclick = "" ;
      GridboletaContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridboleta_Header = "" ;
      GridboletaColumn = new com.genexus.webpanels.GXWebColumn();
      GridfacturaContainer = new com.genexus.webpanels.GXWebGrid(context);
      subGridfactura_Header = "" ;
      GridfacturaColumn = new com.genexus.webpanels.GXWebColumn();
      bttCancelar2_Jsonclick = "" ;
      bttAnteriorinformacionpaciente_Jsonclick = "" ;
      bttSiguientefacturacion_Jsonclick = "" ;
      lblTabpagerealizarpago_title_Jsonclick = "" ;
      bttCancelar_Jsonclick = "" ;
      bttAnteriorpagar_Jsonclick = "" ;
      bttPagar_Jsonclick = "" ;
      ucDvmessage1 = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      GXCCtl = "" ;
      ucFileuploadpaciente = new com.genexus.webpanels.GXUserControl();
      AV42FailedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      ucFileuploadpacientefamiliar = new com.genexus.webpanels.GXUserControl();
      AV41WebSession = httpContext.getWebSession();
      GXt_objcol_SdtSDTInformacionDeLaCita1 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>(com.projectthani.SdtSDTInformacionDeLaCita.class, "SDTInformacionDeLaCita", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDeLaCita2 = new GXBaseCollection[1] ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>(com.projectthani.SdtSDTInformacionDelPaciente.class, "SDTInformacionDelPaciente", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDelPaciente4 = new GXBaseCollection[1] ;
      AV15FamiliarList = new GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>(com.projectthani.SdtSDTListadoPacienteFamiliarComboBox.class, "SDTListadoPacienteFamiliarComboBox", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5 = new GXBaseCollection[1] ;
      AV14FamiliarItem = new com.projectthani.SdtSDTListadoPacienteFamiliarComboBox(remoteHandle, context);
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionB.class, "SDTInformacionDelPacienteFacturacionB", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7 = new GXBaseCollection[1] ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionF.class, "SDTInformacionDelPacienteFacturacionF", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10 = new GXBaseCollection[1] ;
      AV5accessToken = "" ;
      AV12ErrorMessage = "" ;
      AV10clientIp = "" ;
      AV40tokenSession = "" ;
      GXv_char12 = new String[1] ;
      GXv_char11 = new String[1] ;
      GXv_int13 = new short[1] ;
      GXv_SdtSDTResponseTokenSession20014 = new com.projectthani.SdtSDTResponseTokenSession200[1] ;
      AV36SDTResponseTokenSession400 = new com.projectthani.SdtSDTResponseTokenSession400(remoteHandle, context);
      GXv_SdtSDTResponseTokenSession40015 = new com.projectthani.SdtSDTResponseTokenSession400[1] ;
      AV37temp = "" ;
      AV96Dato1 = "" ;
      AV97Dato2 = "" ;
      AV98Correo = "" ;
      GXt_char17 = "" ;
      GXv_char16 = new String[1] ;
      Grid5Row = new com.genexus.webpanels.GXWebRow();
      GridfacturaRow = new com.genexus.webpanels.GXWebRow();
      GridboletaRow = new com.genexus.webpanels.GXWebRow();
      GridpacientefamiliarRow = new com.genexus.webpanels.GXWebRow();
      GridpacienteRow = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid5_Linesclass = "" ;
      ROClassString = "" ;
      sImgUrl = "" ;
      subGridpaciente_Linesclass = "" ;
      lblTextblock2_Jsonclick = "" ;
      subGridpacientefamiliar_Linesclass = "" ;
      lblTextblock3_Jsonclick = "" ;
      subGridboleta_Linesclass = "" ;
      subGridfactura_Linesclass = "" ;
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
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
   private byte subGridboleta_Backcolorstyle ;
   private byte subGridboleta_Allowselection ;
   private byte subGridboleta_Allowhovering ;
   private byte subGridboleta_Allowcollapsing ;
   private byte subGridboleta_Collapsed ;
   private byte subGridfactura_Backcolorstyle ;
   private byte subGridfactura_Allowselection ;
   private byte subGridfactura_Allowhovering ;
   private byte subGridfactura_Allowcollapsing ;
   private byte subGridfactura_Collapsed ;
   private byte nDonePA ;
   private byte GRID5_nEOF ;
   private byte GRIDFACTURA_nEOF ;
   private byte GRIDBOLETA_nEOF ;
   private byte GRIDPACIENTEFAMILIAR_nEOF ;
   private byte GRIDPACIENTE_nEOF ;
   private byte nGXWrapped ;
   private byte subGrid5_Backstyle ;
   private byte subGridpaciente_Backstyle ;
   private byte subGridpacientefamiliar_Backstyle ;
   private byte subGridboleta_Backstyle ;
   private byte subGridfactura_Backstyle ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV20HttpStatus ;
   private short GXv_int13[] ;
   private int wcpOAV11DisponibilidadId ;
   private int nRC_GXsfl_20 ;
   private int nRC_GXsfl_99 ;
   private int nRC_GXsfl_157 ;
   private int nRC_GXsfl_245 ;
   private int nRC_GXsfl_281 ;
   private int nGXsfl_20_idx=1 ;
   private int AV25PacienteId ;
   private int AV11DisponibilidadId ;
   private int Tabrealizarpago_Pagecount ;
   private int nGXsfl_99_idx=1 ;
   private int nGXsfl_157_idx=1 ;
   private int nGXsfl_245_idx=1 ;
   private int nGXsfl_281_idx=1 ;
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
   private int AV46GXV1 ;
   private int AV24PacienteFamiliarId ;
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
   private int AV57GXV12 ;
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
   private int AV69GXV24 ;
   private int divSectionboleta_Visible ;
   private int subGridboleta_Selectedindex ;
   private int subGridboleta_Selectioncolor ;
   private int subGridboleta_Hoveringcolor ;
   private int AV81GXV36 ;
   private int divSectionfactura_Visible ;
   private int subGridfactura_Selectedindex ;
   private int subGridfactura_Selectioncolor ;
   private int subGridfactura_Hoveringcolor ;
   private int AV89GXV44 ;
   private int Fileuploadpaciente_Maxnumberoffiles ;
   private int Fileuploadpacientefamiliar_Maxnumberoffiles ;
   private int subGrid5_Islastpage ;
   private int subGridfactura_Islastpage ;
   private int subGridboleta_Islastpage ;
   private int subGridpacientefamiliar_Islastpage ;
   private int subGridpaciente_Islastpage ;
   private int nGXsfl_20_fel_idx=1 ;
   private int nGXsfl_99_fel_idx=1 ;
   private int nGXsfl_157_fel_idx=1 ;
   private int nGXsfl_245_fel_idx=1 ;
   private int nGXsfl_281_fel_idx=1 ;
   private int AV95GXV50 ;
   private int nGXsfl_157_bak_idx=1 ;
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
   private int subGridboleta_Backcolor ;
   private int subGridboleta_Allbackcolor ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbnombres_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbnombres_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbemail_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbemail_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Visible ;
   private int subGridfactura_Backcolor ;
   private int subGridfactura_Allbackcolor ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfemail_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfemail_Visible ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Enabled ;
   private int edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Visible ;
   private long GRID5_nCurrentRecord ;
   private long GRIDPACIENTE_nCurrentRecord ;
   private long GRIDPACIENTEFAMILIAR_nCurrentRecord ;
   private long GRIDBOLETA_nCurrentRecord ;
   private long GRIDFACTURA_nCurrentRecord ;
   private long GRID5_nFirstRecordOnPage ;
   private long GRIDFACTURA_nFirstRecordOnPage ;
   private long GRIDBOLETA_nFirstRecordOnPage ;
   private long GRIDPACIENTEFAMILIAR_nFirstRecordOnPage ;
   private long GRIDPACIENTE_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_20_idx="0001" ;
   private String Tabrealizarpago_Class ;
   private String sGXsfl_99_idx="0001" ;
   private String sGXsfl_157_idx="0001" ;
   private String sGXsfl_245_idx="0001" ;
   private String sGXsfl_281_idx="0001" ;
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
   private String AV9CitaFamiliar ;
   private String divTable6_Internalname ;
   private String subGridpaciente_Internalname ;
   private String subGridpaciente_Header ;
   private String lblTextblock2_Caption ;
   private String subGridpacientefamiliar_Internalname ;
   private String subGridpacientefamiliar_Header ;
   private String ClassString ;
   private String StyleString ;
   private String bttCancelar1_Internalname ;
   private String bttCancelar1_Jsonclick ;
   private String bttSiguienteinfopaciente_Internalname ;
   private String bttSiguienteinfopaciente_Jsonclick ;
   private String lblTabpagefacturacion_title_Internalname ;
   private String lblTabpagefacturacion_title_Jsonclick ;
   private String divTabpage2table_Internalname ;
   private String divTable8_Internalname ;
   private String grpGroup1_Internalname ;
   private String divGroup1table_Internalname ;
   private String divTable7_Internalname ;
   private String divSectionboleta_Internalname ;
   private String subGridboleta_Internalname ;
   private String subGridboleta_Header ;
   private String divSectionfactura_Internalname ;
   private String subGridfactura_Internalname ;
   private String subGridfactura_Header ;
   private String bttCancelar2_Internalname ;
   private String bttCancelar2_Jsonclick ;
   private String bttAnteriorinformacionpaciente_Internalname ;
   private String bttAnteriorinformacionpaciente_Jsonclick ;
   private String bttSiguientefacturacion_Internalname ;
   private String bttSiguientefacturacion_Jsonclick ;
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
   private String GXCCtl ;
   private String Fileuploadpaciente_Internalname ;
   private String Fileuploadpacientefamiliar_Internalname ;
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
   private String sGXsfl_157_fel_idx="0001" ;
   private String sGXsfl_245_fel_idx="0001" ;
   private String sGXsfl_281_fel_idx="0001" ;
   private String GXv_char12[] ;
   private String GXv_char11[] ;
   private String GXt_char17 ;
   private String GXv_char16[] ;
   private String edtavCtlsdtinformaciondelacitafotografiadoctor_Internalname ;
   private String subGrid5_Class ;
   private String subGrid5_Linesclass ;
   private String divGrid5table_Internalname ;
   private String ROClassString ;
   private String edtavCtlsdtinformaciondelacitaid_Jsonclick ;
   private String divTable1_Internalname ;
   private String sImgUrl ;
   private String edtavCtlsdtinformaciondelacitaespecialidaddoctor_Jsonclick ;
   private String edtavCtlsdtinformaciondelacitafecha_Jsonclick ;
   private String edtavCtlsdtinformaciondelacitahora_Jsonclick ;
   private String edtavCtlsdtinformaciondelacitacosto_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientepeso_Internalname ;
   private String edtavCtlsdtinformaciondelpacienteestatura_Internalname ;
   private String edtavCtlsdtinformaciondelpacientemotivoconsulta_Internalname ;
   private String lblTextblock2_Internalname ;
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
   private String lblTextblock2_Jsonclick ;
   private String edtavCtlestatura_Internalname ;
   private String edtavCtlpeso_Internalname ;
   private String edtavCtlmotivoconsulta_Internalname ;
   private String lblTextblock3_Internalname ;
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
   private String lblTextblock3_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbnombres_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbemail_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Internalname ;
   private String subGridboleta_Class ;
   private String subGridboleta_Linesclass ;
   private String divGrid4table_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbnombres_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbapellidos_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbnrodocumento_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbtelefono_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbemail_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionbdireccion_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfemail_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Internalname ;
   private String subGridfactura_Class ;
   private String subGridfactura_Linesclass ;
   private String divGrid6table_Internalname ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfrazonsocial_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfnrodocumento_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfemail_Jsonclick ;
   private String edtavCtlsdtinformaciondelpacientefacturacionfdireccion_Jsonclick ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV6Boleta ;
   private boolean AV13Factura ;
   private boolean AV39TerminosCondiciones ;
   private boolean Tabrealizarpago_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean Fileuploadpaciente_Autoupload ;
   private boolean Fileuploadpaciente_Hideadditionalbuttons ;
   private boolean Fileuploadpaciente_Enableuploadedfilecanceling ;
   private boolean Fileuploadpacientefamiliar_Autoupload ;
   private boolean Fileuploadpacientefamiliar_Enableuploadedfilecanceling ;
   private boolean bGXsfl_20_Refreshing=false ;
   private boolean bGXsfl_99_Refreshing=false ;
   private boolean bGXsfl_157_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_281_Refreshing=false ;
   private boolean bGXsfl_245_Refreshing=false ;
   private boolean returnInSub ;
   private boolean gx_BV20 ;
   private boolean gx_BV99 ;
   private boolean gx_BV245 ;
   private boolean gx_BV281 ;
   private boolean gx_BV157 ;
   private boolean AV7CheckResult ;
   private boolean AV18hasErrors ;
   private String AV37temp ;
   private String AV28purchaseNumber ;
   private String AV5accessToken ;
   private String AV12ErrorMessage ;
   private String AV10clientIp ;
   private String AV40tokenSession ;
   private String AV96Dato1 ;
   private String AV97Dato2 ;
   private String AV98Correo ;
   private com.genexus.webpanels.GXWebGrid Grid5Container ;
   private com.genexus.webpanels.GXWebGrid GridpacienteContainer ;
   private com.genexus.webpanels.GXWebGrid GridpacientefamiliarContainer ;
   private com.genexus.webpanels.GXWebGrid GridboletaContainer ;
   private com.genexus.webpanels.GXWebGrid GridfacturaContainer ;
   private com.genexus.webpanels.GXWebRow Grid5Row ;
   private com.genexus.webpanels.GXWebRow GridfacturaRow ;
   private com.genexus.webpanels.GXWebRow GridboletaRow ;
   private com.genexus.webpanels.GXWebRow GridpacientefamiliarRow ;
   private com.genexus.webpanels.GXWebRow GridpacienteRow ;
   private com.genexus.webpanels.GXWebColumn Grid5Column ;
   private com.genexus.webpanels.GXWebColumn GridpacienteColumn ;
   private com.genexus.webpanels.GXWebColumn GridpacientefamiliarColumn ;
   private com.genexus.webpanels.GXWebColumn GridboletaColumn ;
   private com.genexus.webpanels.GXWebColumn GridfacturaColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV41WebSession ;
   private com.genexus.webpanels.GXUserControl ucTabrealizarpago ;
   private com.genexus.webpanels.GXUserControl ucDvmessage1 ;
   private com.genexus.webpanels.GXUserControl ucFileuploadpaciente ;
   private com.genexus.webpanels.GXUserControl ucFileuploadpacientefamiliar ;
   private com.projectthani.SdtSDTResponseTokenSession200 AV35SDTResponseTokenSession200 ;
   private HTMLChoice cmbavCtlsdtinformaciondelacitatipoconsulta ;
   private HTMLChoice cmbavCitafamiliar ;
   private HTMLChoice cmbavPacientefamiliarid ;
   private ICheckbox chkavBoleta ;
   private ICheckbox chkavFactura ;
   private HTMLChoice cmbavCtlsdtinformaciondelpacientefacturacionbtipodocumento ;
   private HTMLChoice cmbavCtlsdtinformaciondelpacientefacturacionftipodocumento ;
   private ICheckbox chkavTerminoscondiciones ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> AV15FamiliarList ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[] ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV17FileUploadPacienteFamiliar ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV16FileUploadPaciente ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV42FailedFiles ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV29SDTDetalleCita ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> GXt_objcol_SdtSDTInformacionDeLaCita1 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> GXv_objcol_SdtSDTInformacionDeLaCita2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV30SDTFacturacionBoleta ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV31SDTFacturacionFactura ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV32SDTPaciente ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> GXt_objcol_SdtSDTInformacionDelPaciente3 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> GXv_objcol_SdtSDTInformacionDelPaciente4[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> AV33SDTPacienteFamiliar ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10[] ;
   private com.projectthani.SdtCita AV8Cita ;
   private com.projectthani.SdtSDTListadoPacienteFamiliarComboBox AV14FamiliarItem ;
   private com.projectthani.SdtPago AV27Pago ;
   private com.projectthani.SdtSDTRequestTokenSession AV34SDTRequestTokenSession ;
   private com.projectthani.SdtSDTResponseTokenSession200 GXv_SdtSDTResponseTokenSession20014[] ;
   private com.projectthani.SdtSDTResponseTokenSession400 AV36SDTResponseTokenSession400 ;
   private com.projectthani.SdtSDTResponseTokenSession400 GXv_SdtSDTResponseTokenSession40015[] ;
}

