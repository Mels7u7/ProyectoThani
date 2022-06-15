package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpregistrarcita_impl extends GXDataArea
{
   public wpregistrarcita_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpregistrarcita_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpregistrarcita_impl.class ));
   }

   public wpregistrarcita_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void executeCmdLine( String args[] )
   {
      try
      {
         AV14DisponibilidadId = (int) GXutil.lval( args[0]);
      }
      catch ( ArrayIndexOutOfBoundsException e )
      {
      }

      nGotPars = 1 ;
      webExecute();
   }

   protected void createObjects( )
   {
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta = new HTMLChoice();
      cmbavCitafamiliar = new HTMLChoice();
      cmbavSeleccionarfamiliar = new HTMLChoice();
      chkavBoleta = UIFactory.getCheckbox(this);
      chkavFactura = UIFactory.getCheckbox(this);
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento = new HTMLChoice();
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Detallecita") == 0 )
         {
            nRC_GXsfl_16 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_16"))) ;
            nGXsfl_16_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_16_idx"))) ;
            sGXsfl_16_idx = httpContext.GetPar( "sGXsfl_16_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrdetallecita_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Detallecita") == 0 )
         {
            AV8Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV16Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV49TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34SDTInformacionDeLaCitas);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38SDTInformacionDelPacientes);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35SDTInformacionDelPacienteFacturacionBs);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV36SDTInformacionDelPacienteFacturacionFs);
            AV29PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV14DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrdetallecita_refresh( AV8Boleta, AV16Factura, AV49TerminosCondiciones, AV34SDTInformacionDeLaCitas, AV38SDTInformacionDelPacientes, AV35SDTInformacionDelPacienteFacturacionBs, AV36SDTInformacionDelPacienteFacturacionFs, AV29PacienteId, AV14DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Class", GXutil.rtrim( Ucsubirarchivo_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Autoupload", GXutil.booltostr( Ucsubirarchivo_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Ucsubirarchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Class", GXutil.rtrim( Gxuitabspanel_steps_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Historymanagement", GXutil.booltostr( Gxuitabspanel_steps_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENSAJE_Stylingtype", GXutil.rtrim( Ucmensaje_Stylingtype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_STEPS_Tabsinternalname", GXutil.rtrim( Wizard_steps_Tabsinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV41SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Detallepaciente") == 0 )
         {
            nRC_GXsfl_98 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_98"))) ;
            nGXsfl_98_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_98_idx"))) ;
            sGXsfl_98_idx = httpContext.GetPar( "sGXsfl_98_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrdetallepaciente_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Detallepaciente") == 0 )
         {
            AV8Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV16Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV49TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34SDTInformacionDeLaCitas);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38SDTInformacionDelPacientes);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35SDTInformacionDelPacienteFacturacionBs);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV36SDTInformacionDelPacienteFacturacionFs);
            AV29PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV14DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrdetallepaciente_refresh( AV8Boleta, AV16Factura, AV49TerminosCondiciones, AV34SDTInformacionDeLaCitas, AV38SDTInformacionDelPacientes, AV35SDTInformacionDelPacienteFacturacionBs, AV36SDTInformacionDelPacienteFacturacionFs, AV29PacienteId, AV14DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Class", GXutil.rtrim( Ucsubirarchivo_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Autoupload", GXutil.booltostr( Ucsubirarchivo_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Ucsubirarchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Class", GXutil.rtrim( Gxuitabspanel_steps_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Historymanagement", GXutil.booltostr( Gxuitabspanel_steps_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENSAJE_Stylingtype", GXutil.rtrim( Ucmensaje_Stylingtype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_STEPS_Tabsinternalname", GXutil.rtrim( Wizard_steps_Tabsinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV41SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Detallepacientefamiliar") == 0 )
         {
            nRC_GXsfl_146 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_146"))) ;
            nGXsfl_146_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_146_idx"))) ;
            sGXsfl_146_idx = httpContext.GetPar( "sGXsfl_146_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrdetallepacientefamiliar_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Detallepacientefamiliar") == 0 )
         {
            AV8Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV16Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV49TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34SDTInformacionDeLaCitas);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38SDTInformacionDelPacientes);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35SDTInformacionDelPacienteFacturacionBs);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV36SDTInformacionDelPacienteFacturacionFs);
            AV29PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV14DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrdetallepacientefamiliar_refresh( AV8Boleta, AV16Factura, AV49TerminosCondiciones, AV34SDTInformacionDeLaCitas, AV38SDTInformacionDelPacientes, AV35SDTInformacionDelPacienteFacturacionBs, AV36SDTInformacionDelPacienteFacturacionFs, AV29PacienteId, AV14DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Class", GXutil.rtrim( Ucsubirarchivo_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Autoupload", GXutil.booltostr( Ucsubirarchivo_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Ucsubirarchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Class", GXutil.rtrim( Gxuitabspanel_steps_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Historymanagement", GXutil.booltostr( Gxuitabspanel_steps_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENSAJE_Stylingtype", GXutil.rtrim( Ucmensaje_Stylingtype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_STEPS_Tabsinternalname", GXutil.rtrim( Wizard_steps_Tabsinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV41SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridboleta") == 0 )
         {
            nRC_GXsfl_235 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_235"))) ;
            nGXsfl_235_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_235_idx"))) ;
            sGXsfl_235_idx = httpContext.GetPar( "sGXsfl_235_idx") ;
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
            AV8Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV16Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV49TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34SDTInformacionDeLaCitas);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38SDTInformacionDelPacientes);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35SDTInformacionDelPacienteFacturacionBs);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV36SDTInformacionDelPacienteFacturacionFs);
            AV29PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV14DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridboleta_refresh( AV8Boleta, AV16Factura, AV49TerminosCondiciones, AV34SDTInformacionDeLaCitas, AV38SDTInformacionDelPacientes, AV35SDTInformacionDelPacienteFacturacionBs, AV36SDTInformacionDelPacienteFacturacionFs, AV29PacienteId, AV14DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Class", GXutil.rtrim( Ucsubirarchivo_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Autoupload", GXutil.booltostr( Ucsubirarchivo_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Ucsubirarchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Class", GXutil.rtrim( Gxuitabspanel_steps_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Historymanagement", GXutil.booltostr( Gxuitabspanel_steps_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENSAJE_Stylingtype", GXutil.rtrim( Ucmensaje_Stylingtype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_STEPS_Tabsinternalname", GXutil.rtrim( Wizard_steps_Tabsinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV41SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridfactura") == 0 )
         {
            nRC_GXsfl_276 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_276"))) ;
            nGXsfl_276_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_276_idx"))) ;
            sGXsfl_276_idx = httpContext.GetPar( "sGXsfl_276_idx") ;
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
            AV8Boleta = GXutil.strtobool( httpContext.GetPar( "Boleta")) ;
            AV16Factura = GXutil.strtobool( httpContext.GetPar( "Factura")) ;
            AV49TerminosCondiciones = GXutil.strtobool( httpContext.GetPar( "TerminosCondiciones")) ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV34SDTInformacionDeLaCitas);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV38SDTInformacionDelPacientes);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV35SDTInformacionDelPacienteFacturacionBs);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV36SDTInformacionDelPacienteFacturacionFs);
            AV29PacienteId = (int)(GXutil.lval( httpContext.GetPar( "PacienteId"))) ;
            AV14DisponibilidadId = (int)(GXutil.lval( httpContext.GetPar( "DisponibilidadId"))) ;
            Gx_date = localUtil.parseDateParm( httpContext.GetPar( "Gx_date")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridfactura_refresh( AV8Boleta, AV16Factura, AV49TerminosCondiciones, AV34SDTInformacionDeLaCitas, AV38SDTInformacionDelPacientes, AV35SDTInformacionDelPacienteFacturacionBs, AV36SDTInformacionDelPacienteFacturacionFs, AV29PacienteId, AV14DisponibilidadId, Gx_date) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Class", GXutil.rtrim( Ucsubirarchivo_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Autoupload", GXutil.booltostr( Ucsubirarchivo_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Ucsubirarchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Class", GXutil.rtrim( Gxuitabspanel_steps_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Historymanagement", GXutil.booltostr( Gxuitabspanel_steps_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENSAJE_Stylingtype", GXutil.rtrim( Ucmensaje_Stylingtype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_STEPS_Tabsinternalname", GXutil.rtrim( Wizard_steps_Tabsinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV41SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
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
            AV14DisponibilidadId = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14DisponibilidadId), 8, 0));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14DisponibilidadId), "ZZZZZZZ9")));
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
      pa702( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start702( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?20225110341340", false, true);
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
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVTabsTransform/DVTabsTransformRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpregistrarcita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTES", getSecureSignedToken( "", AV38SDTInformacionDelPacientes));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29PacienteId), "ZZZZZZZ9")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTEFACTURACIONBS", getSecureSignedToken( "", AV35SDTInformacionDelPacienteFacturacionBs));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTEFACTURACIONFS", getSecureSignedToken( "", AV36SDTInformacionDelPacienteFacturacionFs));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELACITAS", getSecureSignedToken( "", AV34SDTInformacionDeLaCitas));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14DisponibilidadId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtinformaciondelacitas", AV34SDTInformacionDeLaCitas);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtinformaciondelacitas", AV34SDTInformacionDeLaCitas);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtinformaciondelacitas", getSecureSignedToken( "", AV34SDTInformacionDeLaCitas));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtinformaciondelpacientefamiliars", AV37SDTInformacionDelPacienteFamiliars);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtinformaciondelpacientefamiliars", AV37SDTInformacionDelPacienteFamiliars);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtinformaciondelpacientes", AV38SDTInformacionDelPacientes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtinformaciondelpacientes", AV38SDTInformacionDelPacientes);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtinformaciondelpacientes", getSecureSignedToken( "", AV38SDTInformacionDelPacientes));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtinformaciondelpacientefacturacionbs", AV35SDTInformacionDelPacienteFacturacionBs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtinformaciondelpacientefacturacionbs", AV35SDTInformacionDelPacienteFacturacionBs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtinformaciondelpacientefacturacionbs", getSecureSignedToken( "", AV35SDTInformacionDelPacienteFacturacionBs));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtinformaciondelpacientefacturacionfs", AV36SDTInformacionDelPacienteFacturacionFs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtinformaciondelpacientefacturacionfs", AV36SDTInformacionDelPacienteFacturacionFs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdtinformaciondelpacientefacturacionfs", getSecureSignedToken( "", AV36SDTInformacionDelPacienteFacturacionFs));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_16", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_16, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_98", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_98, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_146", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_146, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_235", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_235, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_276", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_276, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vUPLOADEDFILES", AV52UploadedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vUPLOADEDFILES", AV52UploadedFiles);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFAILEDFILES", AV53FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFAILEDFILES", AV53FailedFiles);
      }
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vCHECKREQUIREDFIELDSRESULT", AV10CheckRequiredFieldsResult);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELPACIENTES", AV38SDTInformacionDelPacientes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELPACIENTES", AV38SDTInformacionDelPacientes);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTES", getSecureSignedToken( "", AV38SDTInformacionDelPacientes));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELPACIENTEFAMILIARS", AV37SDTInformacionDelPacienteFamiliars);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELPACIENTEFAMILIARS", AV37SDTInformacionDelPacienteFamiliars);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV29PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29PacienteId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELPACIENTEFACTURACIONBS", AV35SDTInformacionDelPacienteFacturacionBs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELPACIENTEFACTURACIONBS", AV35SDTInformacionDelPacienteFacturacionBs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTEFACTURACIONBS", getSecureSignedToken( "", AV35SDTInformacionDelPacienteFacturacionBs));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELPACIENTEFACTURACIONFS", AV36SDTInformacionDelPacienteFacturacionFs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELPACIENTEFACTURACIONFS", AV36SDTInformacionDelPacienteFacturacionFs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTEFACTURACIONFS", getSecureSignedToken( "", AV36SDTInformacionDelPacienteFacturacionFs));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTRESPONSETOKENSESSION200", AV41SDTResponseTokenSession200);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTRESPONSETOKENSESSION200", AV41SDTResponseTokenSession200);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPURCHASENUMBER", AV33purchaseNumber);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELACITAS", AV34SDTInformacionDeLaCitas);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELACITAS", AV34SDTInformacionDeLaCitas);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELACITAS", getSecureSignedToken( "", AV34SDTInformacionDeLaCitas));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDISPONIBILIDADID", GXutil.ltrim( localUtil.ntoc( AV14DisponibilidadId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14DisponibilidadId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTREQUESTTOKENSESSION", AV40SDTRequestTokenSession);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTREQUESTTOKENSESSION", AV40SDTRequestTokenSession);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCITA", AV5Cita);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCITA", AV5Cita);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPAGO", AV32Pago);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPAGO", AV32Pago);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTABSACTIVEPAGE", GXutil.ltrim( localUtil.ntoc( AV46TabsActivePage, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Class", GXutil.rtrim( Ucsubirarchivo_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Autoupload", GXutil.booltostr( Ucsubirarchivo_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCSUBIRARCHIVO_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Ucsubirarchivo_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Class", GXutil.rtrim( Gxuitabspanel_steps_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Historymanagement", GXutil.booltostr( Gxuitabspanel_steps_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "UCMENSAJE_Stylingtype", GXutil.rtrim( Ucmensaje_Stylingtype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "WIZARD_STEPS_Tabsinternalname", GXutil.rtrim( Wizard_steps_Tabsinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSDTRESPONSETOKENSESSION200_Sessionkey", GXutil.rtrim( AV41SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey()));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_STEPS_Activepage", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_steps_Activepage, (byte)(9), (byte)(0), ".", "")));
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
         com.projectthani.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we702( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt702( ) ;
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
      return formatLink("com.projectthani.wpregistrarcita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"})  ;
   }

   public String getPgmname( )
   {
      return "WPRegistrarCita" ;
   }

   public String getPgmdesc( )
   {
      return "WPRegistrar Cita" ;
   }

   public void wb700( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table TableTransactionTemplate", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 col-md-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecita_Internalname, 1, 0, "px", 0, "px", "TableReservarCita", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSecciontitle_Internalname, 1, 0, "px", 0, "px", "TableReservarCitaTitulo", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbtituloinfocita_Internalname, "Informacion de la cita", "", "", lblTbtituloinfocita_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRegistrarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         DetallecitaContainer.SetIsFreestyle(true);
         DetallecitaContainer.SetWrapped(nGXWrapped);
         if ( DetallecitaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"DetallecitaContainer"+"DivS\" data-gxgridid=\"16\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subDetallecita_Internalname, subDetallecita_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            DetallecitaContainer.AddObjectProperty("GridName", "Detallecita");
         }
         else
         {
            DetallecitaContainer.AddObjectProperty("GridName", "Detallecita");
            DetallecitaContainer.AddObjectProperty("Header", subDetallecita_Header);
            DetallecitaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            DetallecitaContainer.AddObjectProperty("Class", "FreeStyleGrid");
            DetallecitaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subDetallecita_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("CmpContext", "");
            DetallecitaContainer.AddObjectProperty("InMasterPage", "false");
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallecitaColumn.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible, (byte)(5), (byte)(0), ".", "")));
            DetallecitaContainer.AddColumnProperties(DetallecitaColumn);
            DetallecitaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subDetallecita_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subDetallecita_Allowselection, (byte)(1), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subDetallecita_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subDetallecita_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subDetallecita_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subDetallecita_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            DetallecitaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subDetallecita_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 16 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_16 = (int)(nGXsfl_16_idx-1) ;
         if ( DetallecitaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV59GXV1 = nGXsfl_16_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"DetallecitaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Detallecita", DetallecitaContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallecitaContainerData", DetallecitaContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallecitaContainerData"+"V", DetallecitaContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"DetallecitaContainerData"+"V"+"\" value='"+DetallecitaContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablepaciente_Internalname, 1, 0, "px", 0, "px", "TableWizardMainWithShadow", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSecciontitulo2_Internalname, 1, 0, "px", 0, "px", "TableTituloPaciente", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTitle2_Internalname, "Informacion general", "", "", lblTitle2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(2), "HLP_WPRegistrarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGxuitabspanel_steps.setProperty("PageCount", Gxuitabspanel_steps_Pagecount);
         ucGxuitabspanel_steps.setProperty("Class", Gxuitabspanel_steps_Class);
         ucGxuitabspanel_steps.setProperty("HistoryManagement", Gxuitabspanel_steps_Historymanagement);
         ucGxuitabspanel_steps.render(context, "tab", Gxuitabspanel_steps_Internalname, "GXUITABSPANEL_STEPSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabgeneral_title_Internalname, "Datos Personales", "", "", lblTabgeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "tabGeneral") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "TableData", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableseleccionarcita_Internalname, 1, 0, "px", 0, "px", "SectionElegirCita", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavCitafamiliar.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavCitafamiliar.getInternalname(), "¿Cita para un familiar?", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 91,'',false,'" + sGXsfl_16_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavCitafamiliar, cmbavCitafamiliar.getInternalname(), GXutil.rtrim( AV12CitaFamiliar), 1, cmbavCitafamiliar.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavCitafamiliar.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,91);\"", "", true, (byte)(1), "HLP_WPRegistrarCita.htm");
         cmbavCitafamiliar.setValue( GXutil.rtrim( AV12CitaFamiliar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCitafamiliar.getInternalname(), "Values", cmbavCitafamiliar.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", cmbavSeleccionarfamiliar.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavSeleccionarfamiliar.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavSeleccionarfamiliar.getInternalname(), "Seleccionar Familiar", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 95,'',false,'" + sGXsfl_16_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavSeleccionarfamiliar, cmbavSeleccionarfamiliar.getInternalname(), GXutil.trim( GXutil.str( AV44SeleccionarFamiliar, 4, 0)), 1, cmbavSeleccionarfamiliar.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavSeleccionarfamiliar.getVisible(), cmbavSeleccionarfamiliar.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,95);\"", "", true, (byte)(1), "HLP_WPRegistrarCita.htm");
         cmbavSeleccionarfamiliar.setValue( GXutil.trim( GXutil.str( AV44SeleccionarFamiliar, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSeleccionarfamiliar.getInternalname(), "Values", cmbavSeleccionarfamiliar.ToJavascriptSource(), true);
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
         /*  Grid Control  */
         DetallepacienteContainer.SetIsFreestyle(true);
         DetallepacienteContainer.SetWrapped(nGXWrapped);
         if ( DetallepacienteContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"DetallepacienteContainer"+"DivS\" data-gxgridid=\"98\">") ;
            sStyleString = "" ;
            if ( subDetallepaciente_Visible == 0 )
            {
               sStyleString += "display:none;" ;
            }
            com.projectthani.GxWebStd.gx_table_start( httpContext, subDetallepaciente_Internalname, subDetallepaciente_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            DetallepacienteContainer.AddObjectProperty("GridName", "Detallepaciente");
         }
         else
         {
            DetallepacienteContainer.AddObjectProperty("GridName", "Detallepaciente");
            DetallepacienteContainer.AddObjectProperty("Header", subDetallepaciente_Header);
            DetallepacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Visible, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            DetallepacienteContainer.AddObjectProperty("Class", "FreeStyleGrid");
            DetallepacienteContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Visible, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("CmpContext", "");
            DetallepacienteContainer.AddObjectProperty("InMasterPage", "false");
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacienteContainer.AddColumnProperties(DetallepacienteColumn);
            DetallepacienteContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Allowselection, (byte)(1), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            DetallepacienteContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 98 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_98 = (int)(nGXsfl_98_idx-1) ;
         if ( DetallepacienteContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV70GXV12 = nGXsfl_98_idx ;
            if ( subDetallepaciente_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"DetallepacienteContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Detallepaciente", DetallepacienteContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacienteContainerData", DetallepacienteContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacienteContainerData"+"V", DetallepacienteContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"DetallepacienteContainerData"+"V"+"\" value='"+DetallepacienteContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         DetallepacientefamiliarContainer.SetIsFreestyle(true);
         DetallepacientefamiliarContainer.SetWrapped(nGXWrapped);
         if ( DetallepacientefamiliarContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"DetallepacientefamiliarContainer"+"DivS\" data-gxgridid=\"146\">") ;
            sStyleString = "" ;
            if ( subDetallepacientefamiliar_Visible == 0 )
            {
               sStyleString += "display:none;" ;
            }
            com.projectthani.GxWebStd.gx_table_start( httpContext, subDetallepacientefamiliar_Internalname, subDetallepacientefamiliar_Internalname, "", "FreeStyleGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
            DetallepacientefamiliarContainer.AddObjectProperty("GridName", "Detallepacientefamiliar");
         }
         else
         {
            DetallepacientefamiliarContainer.AddObjectProperty("GridName", "Detallepacientefamiliar");
            DetallepacientefamiliarContainer.AddObjectProperty("Header", subDetallepacientefamiliar_Header);
            DetallepacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
            DetallepacientefamiliarContainer.AddObjectProperty("Class", "FreeStyleGrid");
            DetallepacientefamiliarContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("CmpContext", "");
            DetallepacientefamiliarContainer.AddObjectProperty("InMasterPage", "false");
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientefamiliars__nombres_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtinformaciondelpacientefamiliars__sexo_Enabled, (byte)(5), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            DetallepacientefamiliarContainer.AddColumnProperties(DetallepacientefamiliarColumn);
            DetallepacientefamiliarContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Allowselection, (byte)(1), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            DetallepacientefamiliarContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 146 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_146 = (int)(nGXsfl_146_idx-1) ;
         if ( DetallepacientefamiliarContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV81GXV23 = nGXsfl_146_idx ;
            if ( subDetallepacientefamiliar_Visible != 0 )
            {
               sStyleString = "" ;
            }
            else
            {
               sStyleString = " style=\"display:none;\"" ;
            }
            httpContext.writeText( "<div id=\""+"DetallepacientefamiliarContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Detallepacientefamiliar", DetallepacientefamiliarContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacientefamiliarContainerData", DetallepacientefamiliarContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacientefamiliarContainerData"+"V", DetallepacientefamiliarContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"DetallepacientefamiliarContainerData"+"V"+"\" value='"+DetallepacientefamiliarContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTaparchivos_title_Internalname, "Informacion Adicional", "", "", lblTaparchivos_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TapArchivos") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable6_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSecciontitle2_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSec2_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSecciontitlearchivo_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTbinfoarchivo_Internalname, "Si cuenta con una historia clínica externa puede adjuntarla, si es más de un archivo comprimirlo", "", "", lblTbinfoarchivo_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup8_Internalname, "Subir archivos", 1, 0, "px", 0, "px", "Group", "", "HLP_WPRegistrarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable7_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucUcsubirarchivo.setProperty("Class", Ucsubirarchivo_Class);
         ucUcsubirarchivo.setProperty("AutoUpload", Ucsubirarchivo_Autoupload);
         ucUcsubirarchivo.setProperty("TooltipText", Ucsubirarchivo_Tooltiptext);
         ucUcsubirarchivo.setProperty("MaxNumberOfFiles", Ucsubirarchivo_Maxnumberoffiles);
         ucUcsubirarchivo.setProperty("UploadedFiles", AV52UploadedFiles);
         ucUcsubirarchivo.setProperty("FailedFiles", AV53FailedFiles);
         ucUcsubirarchivo.render(context, "fileupload", Ucsubirarchivo_Internalname, "UCSUBIRARCHIVOContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTapfacturacion_title_Internalname, "Facturacion", "", "", lblTapfacturacion_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TapFacturacion") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSecfacturacion_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup3_Internalname, "Tipo de comprobante", 1, 0, "px", 0, "px", "Group", "", "HLP_WPRegistrarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGruptc_Internalname, 1, 0, "px", 0, "px", "MT25PX", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 DataContentCellCita", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavBoleta.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavBoleta.getInternalname(), "Boleta", "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 222,'',false,'" + sGXsfl_16_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavBoleta.getInternalname(), GXutil.booltostr( AV8Boleta), "", "Boleta", 1, chkavBoleta.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(222, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,222);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-6 DataContentCellCita", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavFactura.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavFactura.getInternalname(), "Factura", "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 226,'',false,'" + sGXsfl_16_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavFactura.getInternalname(), GXutil.booltostr( AV16Factura), "", "Factura", 1, chkavFactura.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(226, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,226);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSeccionboleta_Internalname, divSeccionboleta_Visible, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup5_Internalname, "Informacion Personal", 1, 0, "px", 0, "px", "Group", "", "HLP_WPRegistrarCita.htm");
         wb_table1_229_702( true) ;
      }
      else
      {
         wb_table1_229_702( false) ;
      }
      return  ;
   }

   public void wb_table1_229_702e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divSeccionfactura_Internalname, divSeccionfactura_Visible, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup4_Internalname, "Informacion de la factura", 1, 0, "px", 0, "px", "Group", "", "HLP_WPRegistrarCita.htm");
         wb_table2_270_702( true) ;
      }
      else
      {
         wb_table2_270_702( false) ;
      }
      return  ;
   }

   public void wb_table2_270_702e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTaprealizarpago1_title_Internalname, "Realizar Pago", "", "", lblTaprealizarpago1_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPRegistrarCita.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TapRealizarPago1") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_STEPSContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkavTerminoscondiciones.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, chkavTerminoscondiciones.getInternalname(), "Terminos y condiciones.", "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Check box */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 309,'',false,'" + sGXsfl_16_idx + "',0)\"" ;
         ClassString = "AttributeCheckBox" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_checkbox_ctrl( httpContext, chkavTerminoscondiciones.getInternalname(), GXutil.booltostr( AV49TerminosCondiciones), "", "Terminos y condiciones.", 1, chkavTerminoscondiciones.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(309, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,309);\"");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group WizardTrnActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 314,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault ButtonWizard" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardprevious_Internalname, "gx.evt.setGridEvt("+GXutil.str( 16, 2, 0)+","+"null"+");", "Anterior", bttBtnwizardprevious_Jsonclick, 7, "Anterior", "", StyleString, ClassString, bttBtnwizardprevious_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e11701_client"+"'", TempTags, "", 2, "HLP_WPRegistrarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 316,'',false,'',0)\"" ;
         ClassString = "ButtonMaterialDefault" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtncancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 16, 2, 0)+","+"null"+");", "Cancelar", bttBtncancel_Jsonclick, 1, "Cancelar", "", StyleString, ClassString, bttBtncancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 318,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial ButtonWizard" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnwizardnext_Internalname, "gx.evt.setGridEvt("+GXutil.str( 16, 2, 0)+","+"null"+");", "Siguiente", bttBtnwizardnext_Jsonclick, 5, "Siguiente", "", StyleString, ClassString, bttBtnwizardnext_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'WIZARDNEXT\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarCita.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 320,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnenter_Internalname, "gx.evt.setGridEvt("+GXutil.str( 16, 2, 0)+","+"null"+");", bttBtnenter_Caption, bttBtnenter_Jsonclick, 5, "Confirmar", "", StyleString, ClassString, bttBtnenter_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPRegistrarCita.htm");
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
         ucUcmensaje.setProperty("StylingType", Ucmensaje_Stylingtype);
         ucUcmensaje.render(context, "dvelop.dvmessage", Ucmensaje_Internalname, "UCMENSAJEContainer");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucWizard_steps.render(context, "dvelop.dvtabstransform", Wizard_steps_Internalname, "WIZARD_STEPSContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 16 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( DetallecitaContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV59GXV1 = nGXsfl_16_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"DetallecitaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Detallecita", DetallecitaContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallecitaContainerData", DetallecitaContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallecitaContainerData"+"V", DetallecitaContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"DetallecitaContainerData"+"V"+"\" value='"+DetallecitaContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 98 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( DetallepacienteContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV70GXV12 = nGXsfl_98_idx ;
               if ( subDetallepaciente_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"DetallepacienteContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Detallepaciente", DetallepacienteContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacienteContainerData", DetallepacienteContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacienteContainerData"+"V", DetallepacienteContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"DetallepacienteContainerData"+"V"+"\" value='"+DetallepacienteContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 146 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( DetallepacientefamiliarContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV81GXV23 = nGXsfl_146_idx ;
               if ( subDetallepacientefamiliar_Visible != 0 )
               {
                  sStyleString = "" ;
               }
               else
               {
                  sStyleString = " style=\"display:none;\"" ;
               }
               httpContext.writeText( "<div id=\""+"DetallepacientefamiliarContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Detallepacientefamiliar", DetallepacientefamiliarContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacientefamiliarContainerData", DetallepacientefamiliarContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DetallepacientefamiliarContainerData"+"V", DetallepacientefamiliarContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"DetallepacientefamiliarContainerData"+"V"+"\" value='"+DetallepacientefamiliarContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 235 )
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
               AV92GXV34 = nGXsfl_235_idx ;
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
      if ( wbEnd == 276 )
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
               AV100GXV42 = nGXsfl_276_idx ;
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

   public void start702( )
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
         Form.getMeta().addItem("description", "WPRegistrar Cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup700( ) ;
   }

   public void ws702( )
   {
      start702( ) ;
      evt702( ) ;
   }

   public void evt702( )
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
                        else if ( GXutil.strcmp(sEvt, "'WIZARDNEXT'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'WizardNext' */
                           e12702 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VSELECCIONARFAMILIAR.CONTROLVALUECHANGED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e13702 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GLOBALEVENTS.OPENFORMNIUBIZ") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e14702 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                                 /* Execute user event: Enter */
                                 e15702 ();
                              }
                              dynload_actions( ) ;
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 16), "DETALLECITA.LOAD") == 0 ) )
                        {
                           nGXsfl_16_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_16_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_16_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_162( ) ;
                           AV59GXV1 = nGXsfl_16_idx ;
                           if ( ( AV34SDTInformacionDeLaCitas.size() >= AV59GXV1 ) && ( AV59GXV1 > 0 ) )
                           {
                              AV34SDTInformacionDeLaCitas.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)) );
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
                                 e16702 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "DETALLECITA.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e17702 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 28), "DETALLEPACIENTEFAMILIAR.LOAD") == 0 )
                        {
                           nGXsfl_146_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_146_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_146_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1466( ) ;
                           AV81GXV23 = nGXsfl_146_idx ;
                           if ( ( AV37SDTInformacionDelPacienteFamiliars.size() >= AV81GXV23 ) && ( AV81GXV23 > 0 ) )
                           {
                              AV37SDTInformacionDelPacienteFamiliars.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "DETALLEPACIENTEFAMILIAR.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e18706 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 20), "DETALLEPACIENTE.LOAD") == 0 )
                        {
                           nGXsfl_98_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_98_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_98_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_985( ) ;
                           AV70GXV12 = nGXsfl_98_idx ;
                           if ( ( AV38SDTInformacionDelPacientes.size() >= AV70GXV12 ) && ( AV70GXV12 > 0 ) )
                           {
                              AV38SDTInformacionDelPacientes.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "DETALLEPACIENTE.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e19705 ();
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
                           nGXsfl_235_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2354( ) ;
                           AV92GXV34 = nGXsfl_235_idx ;
                           if ( ( AV35SDTInformacionDelPacienteFacturacionBs.size() >= AV92GXV34 ) && ( AV92GXV34 > 0 ) )
                           {
                              AV35SDTInformacionDelPacienteFacturacionBs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDBOLETA.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e20704 ();
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
                           nGXsfl_276_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_276_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_276_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2763( ) ;
                           AV100GXV42 = nGXsfl_276_idx ;
                           if ( ( AV36SDTInformacionDelPacienteFacturacionFs.size() >= AV100GXV42 ) && ( AV100GXV42 > 0 ) )
                           {
                              AV36SDTInformacionDelPacienteFacturacionFs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDFACTURA.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e21703 ();
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

   public void we702( )
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

   public void pa702( )
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

   public void gxnrdetallecita_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_162( ) ;
      while ( nGXsfl_16_idx <= nRC_GXsfl_16 )
      {
         sendrow_162( ) ;
         nGXsfl_16_idx = ((subDetallecita_Islastpage==1)&&(nGXsfl_16_idx+1>subdetallecita_fnc_recordsperpage( )) ? 1 : nGXsfl_16_idx+1) ;
         sGXsfl_16_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_16_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_162( ) ;
      }
      addString( httpContext.getJSONContainerResponse( DetallecitaContainer)) ;
      /* End function gxnrDetallecita_newrow */
   }

   public void gxnrgridfactura_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2763( ) ;
      while ( nGXsfl_276_idx <= nRC_GXsfl_276 )
      {
         sendrow_2763( ) ;
         nGXsfl_276_idx = ((subGridfactura_Islastpage==1)&&(nGXsfl_276_idx+1>subgridfactura_fnc_recordsperpage( )) ? 1 : nGXsfl_276_idx+1) ;
         sGXsfl_276_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_276_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2763( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridfacturaContainer)) ;
      /* End function gxnrGridfactura_newrow */
   }

   public void gxnrgridboleta_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2354( ) ;
      while ( nGXsfl_235_idx <= nRC_GXsfl_235 )
      {
         sendrow_2354( ) ;
         nGXsfl_235_idx = ((subGridboleta_Islastpage==1)&&(nGXsfl_235_idx+1>subgridboleta_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
         sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2354( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridboletaContainer)) ;
      /* End function gxnrGridboleta_newrow */
   }

   public void gxnrdetallepaciente_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_985( ) ;
      while ( nGXsfl_98_idx <= nRC_GXsfl_98 )
      {
         sendrow_985( ) ;
         nGXsfl_98_idx = ((subDetallepaciente_Islastpage==1)&&(nGXsfl_98_idx+1>subdetallepaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_98_idx+1) ;
         sGXsfl_98_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_98_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_985( ) ;
      }
      addString( httpContext.getJSONContainerResponse( DetallepacienteContainer)) ;
      /* End function gxnrDetallepaciente_newrow */
   }

   public void gxnrdetallepacientefamiliar_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1466( ) ;
      while ( nGXsfl_146_idx <= nRC_GXsfl_146 )
      {
         sendrow_1466( ) ;
         nGXsfl_146_idx = ((subDetallepacientefamiliar_Islastpage==1)&&(nGXsfl_146_idx+1>subdetallepacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_146_idx+1) ;
         sGXsfl_146_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_146_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1466( ) ;
      }
      addString( httpContext.getJSONContainerResponse( DetallepacientefamiliarContainer)) ;
      /* End function gxnrDetallepacientefamiliar_newrow */
   }

   public void gxgrdetallecita_refresh( boolean AV8Boleta ,
                                        boolean AV16Factura ,
                                        boolean AV49TerminosCondiciones ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV34SDTInformacionDeLaCitas ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV38SDTInformacionDelPacientes ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV35SDTInformacionDelPacienteFacturacionBs ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV36SDTInformacionDelPacienteFacturacionFs ,
                                        int AV29PacienteId ,
                                        int AV14DisponibilidadId ,
                                        java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      DETALLECITA_nCurrentRecord = 0 ;
      rf702( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrDetallecita_refresh */
   }

   public void gxgrdetallepaciente_refresh( boolean AV8Boleta ,
                                            boolean AV16Factura ,
                                            boolean AV49TerminosCondiciones ,
                                            GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV34SDTInformacionDeLaCitas ,
                                            GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV38SDTInformacionDelPacientes ,
                                            GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV35SDTInformacionDelPacienteFacturacionBs ,
                                            GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV36SDTInformacionDelPacienteFacturacionFs ,
                                            int AV29PacienteId ,
                                            int AV14DisponibilidadId ,
                                            java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      DETALLEPACIENTE_nCurrentRecord = 0 ;
      rf705( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrDetallepaciente_refresh */
   }

   public void gxgrdetallepacientefamiliar_refresh( boolean AV8Boleta ,
                                                    boolean AV16Factura ,
                                                    boolean AV49TerminosCondiciones ,
                                                    GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV34SDTInformacionDeLaCitas ,
                                                    GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV38SDTInformacionDelPacientes ,
                                                    GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV35SDTInformacionDelPacienteFacturacionBs ,
                                                    GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV36SDTInformacionDelPacienteFacturacionFs ,
                                                    int AV29PacienteId ,
                                                    int AV14DisponibilidadId ,
                                                    java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      DETALLEPACIENTEFAMILIAR_nCurrentRecord = 0 ;
      rf706( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrDetallepacientefamiliar_refresh */
   }

   public void gxgrgridboleta_refresh( boolean AV8Boleta ,
                                       boolean AV16Factura ,
                                       boolean AV49TerminosCondiciones ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV34SDTInformacionDeLaCitas ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV38SDTInformacionDelPacientes ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV35SDTInformacionDelPacienteFacturacionBs ,
                                       GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV36SDTInformacionDelPacienteFacturacionFs ,
                                       int AV29PacienteId ,
                                       int AV14DisponibilidadId ,
                                       java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDBOLETA_nCurrentRecord = 0 ;
      rf704( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridboleta_refresh */
   }

   public void gxgrgridfactura_refresh( boolean AV8Boleta ,
                                        boolean AV16Factura ,
                                        boolean AV49TerminosCondiciones ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV34SDTInformacionDeLaCitas ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV38SDTInformacionDelPacientes ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV35SDTInformacionDelPacienteFacturacionBs ,
                                        GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV36SDTInformacionDelPacienteFacturacionFs ,
                                        int AV29PacienteId ,
                                        int AV14DisponibilidadId ,
                                        java.util.Date Gx_date )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRIDFACTURA_nCurrentRecord = 0 ;
      rf703( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridfactura_refresh */
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
         AV12CitaFamiliar = cmbavCitafamiliar.getValidValue(AV12CitaFamiliar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12CitaFamiliar", AV12CitaFamiliar);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavCitafamiliar.setValue( GXutil.rtrim( AV12CitaFamiliar) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavCitafamiliar.getInternalname(), "Values", cmbavCitafamiliar.ToJavascriptSource(), true);
      }
      if ( cmbavSeleccionarfamiliar.getItemCount() > 0 )
      {
         AV44SeleccionarFamiliar = (short)(GXutil.lval( cmbavSeleccionarfamiliar.getValidValue(GXutil.trim( GXutil.str( AV44SeleccionarFamiliar, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44SeleccionarFamiliar", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44SeleccionarFamiliar), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavSeleccionarfamiliar.setValue( GXutil.trim( GXutil.str( AV44SeleccionarFamiliar, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSeleccionarfamiliar.getInternalname(), "Values", cmbavSeleccionarfamiliar.ToJavascriptSource(), true);
      }
      AV8Boleta = GXutil.strtobool( GXutil.booltostr( AV8Boleta)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8Boleta", AV8Boleta);
      AV16Factura = GXutil.strtobool( GXutil.booltostr( AV16Factura)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Factura", AV16Factura);
      AV49TerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV49TerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TerminosCondiciones", AV49TerminosCondiciones);
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf702( ) ;
      rf705( ) ;
      rf706( ) ;
      rf704( ) ;
      rf703( ) ;
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
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getEnabled(), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__nombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__nombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__nombres_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__sexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__sexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__sexo_Enabled), 5, 0), !bGXsfl_146_Refreshing);
   }

   public void rf702( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         DetallecitaContainer.ClearRows();
      }
      wbStart = (short)(16) ;
      nGXsfl_16_idx = 1 ;
      sGXsfl_16_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_16_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_162( ) ;
      bGXsfl_16_Refreshing = true ;
      DetallecitaContainer.AddObjectProperty("GridName", "Detallecita");
      DetallecitaContainer.AddObjectProperty("CmpContext", "");
      DetallecitaContainer.AddObjectProperty("InMasterPage", "false");
      DetallecitaContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      DetallecitaContainer.AddObjectProperty("Class", "FreeStyleGrid");
      DetallecitaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      DetallecitaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      DetallecitaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subDetallecita_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      DetallecitaContainer.setPageSize( subdetallecita_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_162( ) ;
         e17702 ();
         wbEnd = (short)(16) ;
         wb700( ) ;
      }
      bGXsfl_16_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes702( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELPACIENTES", AV38SDTInformacionDelPacientes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELPACIENTES", AV38SDTInformacionDelPacientes);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTES", getSecureSignedToken( "", AV38SDTInformacionDelPacientes));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPACIENTEID", GXutil.ltrim( localUtil.ntoc( AV29PacienteId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29PacienteId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELPACIENTEFACTURACIONBS", AV35SDTInformacionDelPacienteFacturacionBs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELPACIENTEFACTURACIONBS", AV35SDTInformacionDelPacienteFacturacionBs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTEFACTURACIONBS", getSecureSignedToken( "", AV35SDTInformacionDelPacienteFacturacionBs));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELPACIENTEFACTURACIONFS", AV36SDTInformacionDelPacienteFacturacionFs);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELPACIENTEFACTURACIONFS", AV36SDTInformacionDelPacienteFacturacionFs);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELPACIENTEFACTURACIONFS", getSecureSignedToken( "", AV36SDTInformacionDelPacienteFacturacionFs));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTINFORMACIONDELACITAS", AV34SDTInformacionDeLaCitas);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTINFORMACIONDELACITAS", AV34SDTInformacionDeLaCitas);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDTINFORMACIONDELACITAS", getSecureSignedToken( "", AV34SDTInformacionDeLaCitas));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTODAY", localUtil.dtoc( Gx_date, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTODAY", getSecureSignedToken( "", Gx_date));
   }

   public void rf703( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridfacturaContainer.ClearRows();
      }
      wbStart = (short)(276) ;
      nGXsfl_276_idx = 1 ;
      sGXsfl_276_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_276_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2763( ) ;
      bGXsfl_276_Refreshing = true ;
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
         subsflControlProps_2763( ) ;
         e21703 ();
         wbEnd = (short)(276) ;
         wb700( ) ;
      }
      bGXsfl_276_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes703( )
   {
   }

   public void rf704( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridboletaContainer.ClearRows();
      }
      wbStart = (short)(235) ;
      nGXsfl_235_idx = 1 ;
      sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2354( ) ;
      bGXsfl_235_Refreshing = true ;
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
         subsflControlProps_2354( ) ;
         e20704 ();
         wbEnd = (short)(235) ;
         wb700( ) ;
      }
      bGXsfl_235_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes704( )
   {
   }

   public void rf705( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         DetallepacienteContainer.ClearRows();
      }
      wbStart = (short)(98) ;
      nGXsfl_98_idx = 1 ;
      sGXsfl_98_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_98_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_985( ) ;
      bGXsfl_98_Refreshing = true ;
      DetallepacienteContainer.AddObjectProperty("GridName", "Detallepaciente");
      DetallepacienteContainer.AddObjectProperty("CmpContext", "");
      DetallepacienteContainer.AddObjectProperty("InMasterPage", "false");
      DetallepacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Visible, (byte)(5), (byte)(0), ".", "")));
      DetallepacienteContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      DetallepacienteContainer.AddObjectProperty("Class", "FreeStyleGrid");
      DetallepacienteContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      DetallepacienteContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      DetallepacienteContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      DetallepacienteContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepaciente_Visible, (byte)(5), (byte)(0), ".", "")));
      DetallepacienteContainer.setPageSize( subdetallepaciente_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_985( ) ;
         e19705 ();
         wbEnd = (short)(98) ;
         wb700( ) ;
      }
      bGXsfl_98_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes705( )
   {
   }

   public void rf706( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         DetallepacientefamiliarContainer.ClearRows();
      }
      wbStart = (short)(146) ;
      nGXsfl_146_idx = 1 ;
      sGXsfl_146_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_146_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1466( ) ;
      bGXsfl_146_Refreshing = true ;
      DetallepacientefamiliarContainer.AddObjectProperty("GridName", "Detallepacientefamiliar");
      DetallepacientefamiliarContainer.AddObjectProperty("CmpContext", "");
      DetallepacientefamiliarContainer.AddObjectProperty("InMasterPage", "false");
      DetallepacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
      DetallepacientefamiliarContainer.AddObjectProperty("Class", GXutil.rtrim( "FreeStyleGrid"));
      DetallepacientefamiliarContainer.AddObjectProperty("Class", "FreeStyleGrid");
      DetallepacientefamiliarContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      DetallepacientefamiliarContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      DetallepacientefamiliarContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      DetallepacientefamiliarContainer.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( subDetallepacientefamiliar_Visible, (byte)(5), (byte)(0), ".", "")));
      DetallepacientefamiliarContainer.setPageSize( subdetallepacientefamiliar_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1466( ) ;
         e18706 ();
         wbEnd = (short)(146) ;
         wb700( ) ;
      }
      bGXsfl_146_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes706( )
   {
   }

   public int subdetallecita_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subdetallecita_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subdetallecita_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subdetallecita_fnc_currentpage( )
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

   public int subdetallepaciente_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subdetallepaciente_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subdetallepaciente_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subdetallepaciente_fnc_currentpage( )
   {
      return -1 ;
   }

   public int subdetallepacientefamiliar_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subdetallepacientefamiliar_fnc_recordcount( )
   {
      return -1 ;
   }

   public int subdetallepacientefamiliar_fnc_recordsperpage( )
   {
      return -1 ;
   }

   public int subdetallepacientefamiliar_fnc_currentpage( )
   {
      return -1 ;
   }

   public void before_start_formulas( )
   {
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getEnabled(), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled), 5, 0), !bGXsfl_16_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled), 5, 0), !bGXsfl_98_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__nombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__nombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__nombres_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      edtavSdtinformaciondelpacientefamiliars__sexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelpacientefamiliars__sexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelpacientefamiliars__sexo_Enabled), 5, 0), !bGXsfl_146_Refreshing);
      fix_multi_value_controls( ) ;
   }

   public void strup700( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e16702 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtinformaciondelacitas"), AV34SDTInformacionDeLaCitas);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtinformaciondelpacientefamiliars"), AV37SDTInformacionDelPacienteFamiliars);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtinformaciondelpacientes"), AV38SDTInformacionDelPacientes);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtinformaciondelpacientefacturacionbs"), AV35SDTInformacionDelPacienteFacturacionBs);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtinformaciondelpacientefacturacionfs"), AV36SDTInformacionDelPacienteFacturacionFs);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUPLOADEDFILES"), AV52UploadedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFAILEDFILES"), AV53FailedFiles);
         /* Read saved values. */
         nRC_GXsfl_16 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_16"), ",", ".")) ;
         nRC_GXsfl_98 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_98"), ",", ".")) ;
         nRC_GXsfl_146 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_146"), ",", ".")) ;
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_235"), ",", ".")) ;
         nRC_GXsfl_276 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_276"), ",", ".")) ;
         AV46TabsActivePage = (short)(localUtil.ctol( httpContext.cgiGet( "vTABSACTIVEPAGE"), ",", ".")) ;
         Ucsubirarchivo_Class = httpContext.cgiGet( "UCSUBIRARCHIVO_Class") ;
         Ucsubirarchivo_Autoupload = GXutil.strtobool( httpContext.cgiGet( "UCSUBIRARCHIVO_Autoupload")) ;
         Ucsubirarchivo_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "UCSUBIRARCHIVO_Maxnumberoffiles"), ",", ".")) ;
         Gxuitabspanel_steps_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_STEPS_Pagecount"), ",", ".")) ;
         Gxuitabspanel_steps_Class = httpContext.cgiGet( "GXUITABSPANEL_STEPS_Class") ;
         Gxuitabspanel_steps_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_STEPS_Historymanagement")) ;
         Ucmensaje_Stylingtype = httpContext.cgiGet( "UCMENSAJE_Stylingtype") ;
         Wizard_steps_Tabsinternalname = httpContext.cgiGet( "WIZARD_STEPS_Tabsinternalname") ;
         Gxuitabspanel_steps_Activepage = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_STEPS_Activepage"), ",", ".")) ;
         nRC_GXsfl_16 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_16"), ",", ".")) ;
         nGXsfl_16_fel_idx = 0 ;
         while ( nGXsfl_16_fel_idx < nRC_GXsfl_16 )
         {
            nGXsfl_16_fel_idx = ((subDetallecita_Islastpage==1)&&(nGXsfl_16_fel_idx+1>subdetallecita_fnc_recordsperpage( )) ? 1 : nGXsfl_16_fel_idx+1) ;
            sGXsfl_16_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_16_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_162( ) ;
            AV59GXV1 = nGXsfl_16_fel_idx ;
            if ( ( AV34SDTInformacionDeLaCitas.size() >= AV59GXV1 ) && ( AV59GXV1 > 0 ) )
            {
               AV34SDTInformacionDeLaCitas.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)) );
            }
         }
         if ( nGXsfl_16_fel_idx == 0 )
         {
            nGXsfl_16_idx = 1 ;
            sGXsfl_16_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_16_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_162( ) ;
         }
         nGXsfl_16_fel_idx = 1 ;
         nRC_GXsfl_98 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_98"), ",", ".")) ;
         nGXsfl_98_fel_idx = 0 ;
         while ( nGXsfl_98_fel_idx < nRC_GXsfl_98 )
         {
            nGXsfl_98_fel_idx = ((subDetallepaciente_Islastpage==1)&&(nGXsfl_98_fel_idx+1>subdetallepaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_98_fel_idx+1) ;
            sGXsfl_98_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_98_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_985( ) ;
            AV70GXV12 = nGXsfl_98_fel_idx ;
            if ( ( AV38SDTInformacionDelPacientes.size() >= AV70GXV12 ) && ( AV70GXV12 > 0 ) )
            {
               AV38SDTInformacionDelPacientes.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)) );
            }
         }
         if ( nGXsfl_98_fel_idx == 0 )
         {
            nGXsfl_98_idx = 1 ;
            sGXsfl_98_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_98_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_985( ) ;
         }
         nGXsfl_98_fel_idx = 1 ;
         nRC_GXsfl_146 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_146"), ",", ".")) ;
         nGXsfl_146_fel_idx = 0 ;
         while ( nGXsfl_146_fel_idx < nRC_GXsfl_146 )
         {
            nGXsfl_146_fel_idx = ((subDetallepacientefamiliar_Islastpage==1)&&(nGXsfl_146_fel_idx+1>subdetallepacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_146_fel_idx+1) ;
            sGXsfl_146_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_146_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1466( ) ;
            AV81GXV23 = nGXsfl_146_fel_idx ;
            if ( ( AV37SDTInformacionDelPacienteFamiliars.size() >= AV81GXV23 ) && ( AV81GXV23 > 0 ) )
            {
               AV37SDTInformacionDelPacienteFamiliars.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)) );
            }
         }
         if ( nGXsfl_146_fel_idx == 0 )
         {
            nGXsfl_146_idx = 1 ;
            sGXsfl_146_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_146_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1466( ) ;
         }
         nGXsfl_146_fel_idx = 1 ;
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_235"), ",", ".")) ;
         nGXsfl_235_fel_idx = 0 ;
         while ( nGXsfl_235_fel_idx < nRC_GXsfl_235 )
         {
            nGXsfl_235_fel_idx = ((subGridboleta_Islastpage==1)&&(nGXsfl_235_fel_idx+1>subgridboleta_fnc_recordsperpage( )) ? 1 : nGXsfl_235_fel_idx+1) ;
            sGXsfl_235_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2354( ) ;
            AV92GXV34 = nGXsfl_235_fel_idx ;
            if ( ( AV35SDTInformacionDelPacienteFacturacionBs.size() >= AV92GXV34 ) && ( AV92GXV34 > 0 ) )
            {
               AV35SDTInformacionDelPacienteFacturacionBs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)) );
            }
         }
         if ( nGXsfl_235_fel_idx == 0 )
         {
            nGXsfl_235_idx = 1 ;
            sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2354( ) ;
         }
         nGXsfl_235_fel_idx = 1 ;
         nRC_GXsfl_276 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_276"), ",", ".")) ;
         nGXsfl_276_fel_idx = 0 ;
         while ( nGXsfl_276_fel_idx < nRC_GXsfl_276 )
         {
            nGXsfl_276_fel_idx = ((subGridfactura_Islastpage==1)&&(nGXsfl_276_fel_idx+1>subgridfactura_fnc_recordsperpage( )) ? 1 : nGXsfl_276_fel_idx+1) ;
            sGXsfl_276_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_276_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2763( ) ;
            AV100GXV42 = nGXsfl_276_fel_idx ;
            if ( ( AV36SDTInformacionDelPacienteFacturacionFs.size() >= AV100GXV42 ) && ( AV100GXV42 > 0 ) )
            {
               AV36SDTInformacionDelPacienteFacturacionFs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)) );
            }
         }
         if ( nGXsfl_276_fel_idx == 0 )
         {
            nGXsfl_276_idx = 1 ;
            sGXsfl_276_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_276_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2763( ) ;
         }
         nGXsfl_276_fel_idx = 1 ;
         /* Read variables values. */
         cmbavCitafamiliar.setName( cmbavCitafamiliar.getInternalname() );
         cmbavCitafamiliar.setValue( httpContext.cgiGet( cmbavCitafamiliar.getInternalname()) );
         AV12CitaFamiliar = httpContext.cgiGet( cmbavCitafamiliar.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12CitaFamiliar", AV12CitaFamiliar);
         cmbavSeleccionarfamiliar.setName( cmbavSeleccionarfamiliar.getInternalname() );
         cmbavSeleccionarfamiliar.setValue( httpContext.cgiGet( cmbavSeleccionarfamiliar.getInternalname()) );
         AV44SeleccionarFamiliar = (short)(GXutil.lval( httpContext.cgiGet( cmbavSeleccionarfamiliar.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44SeleccionarFamiliar", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44SeleccionarFamiliar), 4, 0));
         AV8Boleta = GXutil.strtobool( httpContext.cgiGet( chkavBoleta.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Boleta", AV8Boleta);
         AV16Factura = GXutil.strtobool( httpContext.cgiGet( chkavFactura.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Factura", AV16Factura);
         AV49TerminosCondiciones = GXutil.strtobool( httpContext.cgiGet( chkavTerminoscondiciones.getInternalname())) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV49TerminosCondiciones", AV49TerminosCondiciones);
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
      e16702 ();
      if (returnInSub) return;
   }

   public void e16702( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setHeaderrawhtml( Form.getHeaderrawhtml()+"<link rel=\"stylesheet\" type=\"text/css\" href=\"./static/StyleReservarCita.css\">" );
      Form.getJscriptsrc().add(new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "urlOpenFormNiubiz")) ;
      Form.getJscriptsrc().add("./JSNiubiz.js") ;
      Form.getJscriptsrc().add("./JSUtils.js") ;
      if ( (GXutil.strcmp("", AV51WebSession.getValue("WSPacienteId"))==0) )
      {
         callWebObject(formatLink("com.projectthani.wploginpaciente", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV29PacienteId = (int)(GXutil.lval( AV51WebSession.getValue("WSPacienteId"))) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29PacienteId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29PacienteId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPACIENTEID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29PacienteId), "ZZZZZZZ9")));
      GXt_objcol_SdtSDTInformacionDeLaCita1 = AV34SDTInformacionDeLaCitas ;
      GXv_objcol_SdtSDTInformacionDeLaCita2[0] = GXt_objcol_SdtSDTInformacionDeLaCita1 ;
      new com.projectthani.prcinformaciondelacita(remoteHandle, context).execute( AV14DisponibilidadId, GXv_objcol_SdtSDTInformacionDeLaCita2) ;
      GXt_objcol_SdtSDTInformacionDeLaCita1 = GXv_objcol_SdtSDTInformacionDeLaCita2[0] ;
      AV34SDTInformacionDeLaCitas = GXt_objcol_SdtSDTInformacionDeLaCita1 ;
      gx_BV16 = true ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = AV38SDTInformacionDelPacientes ;
      GXv_objcol_SdtSDTInformacionDelPaciente4[0] = GXt_objcol_SdtSDTInformacionDelPaciente3 ;
      new com.projectthani.prcinformaciondelpaciente(remoteHandle, context).execute( AV29PacienteId, GXv_objcol_SdtSDTInformacionDelPaciente4) ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = GXv_objcol_SdtSDTInformacionDelPaciente4[0] ;
      AV38SDTInformacionDelPacientes = GXt_objcol_SdtSDTInformacionDelPaciente3 ;
      gx_BV98 = true ;
      subDetallepaciente_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, "DetallepacienteContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subDetallepaciente_Visible), 5, 0), true);
      subDetallepacientefamiliar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, "DetallepacientefamiliarContainerDiv", "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(subDetallepacientefamiliar_Visible), 5, 0), true);
      cmbavSeleccionarfamiliar.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSeleccionarfamiliar.getInternalname(), "Visible", GXutil.ltrimstr( cmbavSeleccionarfamiliar.getVisible(), 5, 0), true);
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[0] = AV28ListFamiliar ;
      new com.projectthani.prcgetlistadopacientefamiliarcombobox(remoteHandle, context).execute( AV29PacienteId, GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5) ;
      AV28ListFamiliar = GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[0] ;
      AV106GXV48 = 1 ;
      while ( AV106GXV48 <= AV28ListFamiliar.size() )
      {
         AV17FamiliarList = (com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)((com.projectthani.SdtSDTListadoPacienteFamiliarComboBox)AV28ListFamiliar.elementAt(-1+AV106GXV48));
         cmbavSeleccionarfamiliar.addItem(GXutil.trim( GXutil.str( AV17FamiliarList.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Pacientefamiliarid(), 4, 0)), AV17FamiliarList.getgxTv_SdtSDTListadoPacienteFamiliarComboBox_Nombresapellidos(), (short)(0));
         AV106GXV48 = (int)(AV106GXV48+1) ;
      }
      divSeccionboleta_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divSeccionboleta_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divSeccionboleta_Visible), 5, 0), true);
      divSeccionfactura_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, divSeccionfactura_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(divSeccionfactura_Visible), 5, 0), true);
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 = AV35SDTInformacionDelPacienteFacturacionBs ;
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7[0] = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 ;
      new com.projectthani.prcinformaciondelpacienteboleta(remoteHandle, context).execute( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( AV51WebSession.getValue("WSPacienteId"), "."))), GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7) ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 = GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7[0] ;
      AV35SDTInformacionDelPacienteFacturacionBs = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 ;
      gx_BV235 = true ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 = AV36SDTInformacionDelPacienteFacturacionFs ;
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9[0] = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 ;
      new com.projectthani.prcinformaciondelpacientefactura(remoteHandle, context).execute( GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9) ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 = GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9[0] ;
      AV36SDTInformacionDelPacienteFacturacionFs = GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 ;
      gx_BV276 = true ;
      Wizard_steps_Tabsinternalname = "GXUITabsPanel_Steps" ;
      ucWizard_steps.sendProperty(context, "", false, Wizard_steps_Internalname, "TabsInternalName", Wizard_steps_Tabsinternalname);
      bttBtnenter_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
      bttBtnwizardprevious_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnwizardprevious_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnwizardprevious_Visible), 5, 0), true);
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible), 5, 0), !bGXsfl_16_Refreshing);
   }

   private void e17702( )
   {
      /* Detallecita_Load Routine */
      returnInSub = false ;
      AV59GXV1 = 1 ;
      while ( AV59GXV1 <= AV34SDTInformacionDeLaCitas.size() )
      {
         AV34SDTInformacionDeLaCitas.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(16) ;
         }
         sendrow_162( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_16_Refreshing )
         {
            httpContext.doAjaxLoad(16, DetallecitaRow);
         }
         AV59GXV1 = (int)(AV59GXV1+1) ;
      }
   }

   public void e12702( )
   {
      AV70GXV12 = nGXsfl_98_idx ;
      if ( AV38SDTInformacionDelPacientes.size() >= AV70GXV12 )
      {
         AV38SDTInformacionDelPacientes.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)) );
      }
      AV81GXV23 = nGXsfl_146_idx ;
      if ( AV37SDTInformacionDelPacienteFamiliars.size() >= AV81GXV23 )
      {
         AV37SDTInformacionDelPacienteFamiliars.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)) );
      }
      /* 'WizardNext' Routine */
      returnInSub = false ;
      AV46TabsActivePage = (short)(Gxuitabspanel_steps_Activepage) ;
      if ( AV46TabsActivePage == 1 )
      {
         /* Execute user subroutine: 'CHECKREQUIREDFIELDS_TABGENERAL' */
         S112 ();
         if (returnInSub) return;
      }
      else if ( AV46TabsActivePage == 2 )
      {
         /* Execute user subroutine: 'CHECKREQUIREDFIELDS_TAPARCHIVOS' */
         S122 ();
         if (returnInSub) return;
      }
      else if ( AV46TabsActivePage == 3 )
      {
         /* Execute user subroutine: 'CHECKREQUIREDFIELDS_TAPFACTURACION' */
         S132 ();
         if (returnInSub) return;
      }
      if ( AV10CheckRequiredFieldsResult )
      {
         AV46TabsActivePage = (short)(AV46TabsActivePage+1) ;
         this.executeUsercontrolMethod("", false, "GXUITABSPANEL_STEPSContainer", "SelectTab", "", new Object[] {Short.valueOf(AV46TabsActivePage)});
      }
      if ( AV46TabsActivePage == 3 )
      {
         bttBtnenter_Caption = "Pagar" ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Caption", bttBtnenter_Caption, true);
      }
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'UPDATE WIZARD STEPS BUTTONS VISIBILITY' Routine */
      returnInSub = false ;
      bttBtnwizardprevious_Visible = (((Gxuitabspanel_steps_Activepage!=1)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnwizardprevious_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnwizardprevious_Visible), 5, 0), true);
      bttBtncancel_Visible = (((Gxuitabspanel_steps_Activepage==1)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtncancel_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtncancel_Visible), 5, 0), true);
      bttBtnwizardnext_Visible = (((Gxuitabspanel_steps_Activepage!=4)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnwizardnext_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnwizardnext_Visible), 5, 0), true);
      bttBtnenter_Visible = (((Gxuitabspanel_steps_Activepage==4)) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnenter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnenter_Visible), 5, 0), true);
   }

   public void S112( )
   {
      /* 'CHECKREQUIREDFIELDS_TABGENERAL' Routine */
      returnInSub = false ;
      AV10CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
      if ( GXutil.strcmp(AV12CitaFamiliar, "No") == 0 )
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso())==0) )
         {
            AV10CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Peso no debe esta vacío.", "notice", "", "true"));
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura())==0) )
         {
            AV10CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Estatura no debe esta vacío.", "notice", "", "true"));
         }
         if ( (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta())==0) )
         {
            AV10CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Motivo consulta no debe esta vacío.", "notice", "", "true"));
         }
      }
      else if ( GXutil.strcmp(AV12CitaFamiliar, "Si") == 0 )
      {
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso())==0) )
         {
            AV10CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Peso no debe esta vacío.", "notice", "", "true"));
         }
         if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura())==0) )
         {
            AV10CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Estatura no debe esta vacío.", "notice", "", "true"));
         }
         if ( (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta())==0) )
         {
            AV10CheckRequiredFieldsResult = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
            httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "El campo Motivo consulta no debe esta vacío.", "notice", "", "true"));
         }
      }
   }

   public void S122( )
   {
      /* 'CHECKREQUIREDFIELDS_TAPARCHIVOS' Routine */
      returnInSub = false ;
      AV10CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
   }

   public void S132( )
   {
      /* 'CHECKREQUIREDFIELDS_TAPFACTURACION' Routine */
      returnInSub = false ;
      AV10CheckRequiredFieldsResult = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
      if ( ! AV8Boleta && ! AV16Factura )
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "Debe seleccionar un comprobante de pago.", "notice", "", "true"));
         AV10CheckRequiredFieldsResult = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10CheckRequiredFieldsResult", AV10CheckRequiredFieldsResult);
      }
   }

   public void e13702( )
   {
      AV81GXV23 = nGXsfl_146_idx ;
      if ( AV37SDTInformacionDelPacienteFamiliars.size() >= AV81GXV23 )
      {
         AV37SDTInformacionDelPacienteFamiliars.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)) );
      }
      /* Seleccionarfamiliar_Controlvaluechanged Routine */
      returnInSub = false ;
      GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10[0] = AV37SDTInformacionDelPacienteFamiliars ;
      new com.projectthani.prcgetpacientefamiliarporpaciente(remoteHandle, context).execute( AV29PacienteId, AV44SeleccionarFamiliar, GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10) ;
      AV37SDTInformacionDelPacienteFamiliars = GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10[0] ;
      gx_BV146 = true ;
      /*  Sending Event outputs  */
      if ( gx_BV146 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV37SDTInformacionDelPacienteFamiliars", AV37SDTInformacionDelPacienteFamiliars);
         nGXsfl_146_bak_idx = nGXsfl_146_idx ;
         gxgrdetallepacientefamiliar_refresh( AV8Boleta, AV16Factura, AV49TerminosCondiciones, AV34SDTInformacionDeLaCitas, AV38SDTInformacionDelPacientes, AV35SDTInformacionDelPacienteFacturacionBs, AV36SDTInformacionDelPacienteFacturacionFs, AV29PacienteId, AV14DisponibilidadId, Gx_date) ;
         nGXsfl_146_idx = nGXsfl_146_bak_idx ;
         sGXsfl_146_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_146_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1466( ) ;
      }
   }

   public void e14702( )
   {
      AV59GXV1 = nGXsfl_16_idx ;
      if ( AV34SDTInformacionDeLaCitas.size() >= AV59GXV1 )
      {
         AV34SDTInformacionDeLaCitas.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)) );
      }
      AV100GXV42 = nGXsfl_276_idx ;
      if ( AV36SDTInformacionDelPacienteFacturacionFs.size() >= AV100GXV42 )
      {
         AV36SDTInformacionDelPacienteFacturacionFs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)) );
      }
      AV92GXV34 = nGXsfl_235_idx ;
      if ( AV35SDTInformacionDelPacienteFacturacionBs.size() >= AV92GXV34 )
      {
         AV35SDTInformacionDelPacienteFacturacionBs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)) );
      }
      /* GlobalEvents_Openformniubiz Routine */
      returnInSub = false ;
      if ( AV8Boleta )
      {
         AV107Dato1 = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres() ;
         AV108Dato2 = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos() ;
         AV109Correo = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail() ;
      }
      else
      {
         AV107Dato1 = "" ;
         AV108Dato2 = "" ;
         AV109Correo = ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail() ;
      }
      this.executeExternalObjectMethod("", false, "AV25JSNiubiz", "openForm", new Object[] {AV107Dato1,AV108Dato2,AV109Correo,AV41SDTResponseTokenSession200.getgxTv_SdtSDTResponseTokenSession200_Sessionkey(),"web",new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "merchantId"),AV33purchaseNumber,((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(),Integer.valueOf(20),new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "ThaniMainUrl")+formatLink("com.projectthani.wphomepage", new String[] {}, new String[] {}) ,new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "urlLogoThaniFormNiubiz"),"#000000",new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "ThaniMainUrl")+formatLink("com.projectthani.wprespuestaniubiz", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV14DisponibilidadId,8,0))}, new String[] {"DisponibilidadId"}) }, false);
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e15702 ();
      if (returnInSub) return;
   }

   public void e15702( )
   {
      AV81GXV23 = nGXsfl_146_idx ;
      if ( AV37SDTInformacionDelPacienteFamiliars.size() >= AV81GXV23 )
      {
         AV37SDTInformacionDelPacienteFamiliars.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)) );
      }
      AV70GXV12 = nGXsfl_98_idx ;
      if ( AV38SDTInformacionDelPacientes.size() >= AV70GXV12 )
      {
         AV38SDTInformacionDelPacientes.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)) );
      }
      AV59GXV1 = nGXsfl_16_idx ;
      if ( AV34SDTInformacionDeLaCitas.size() >= AV59GXV1 )
      {
         AV34SDTInformacionDeLaCitas.currentItem( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)) );
      }
      AV92GXV34 = nGXsfl_235_idx ;
      if ( AV35SDTInformacionDelPacienteFacturacionBs.size() >= AV92GXV34 )
      {
         AV35SDTInformacionDelPacienteFacturacionBs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)) );
      }
      AV100GXV42 = nGXsfl_276_idx ;
      if ( AV36SDTInformacionDelPacienteFacturacionFs.size() >= AV100GXV42 )
      {
         AV36SDTInformacionDelPacienteFacturacionFs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)) );
      }
      /* Enter Routine */
      returnInSub = false ;
      if ( AV49TerminosCondiciones )
      {
         /* Execute user subroutine: 'CREATECITA' */
         S152 ();
         if (returnInSub) return;
         AV20hasErrors = false ;
         GXv_char11[0] = AV6accessToken ;
         GXv_char12[0] = AV15ErrorMessage ;
         GXv_int13[0] = AV23HttpStatus ;
         new com.projectthani.prccreaciontoken(remoteHandle, context).execute( GXv_char11, GXv_char12, GXv_int13) ;
         wpregistrarcita_impl.this.AV6accessToken = GXv_char11[0] ;
         wpregistrarcita_impl.this.AV15ErrorMessage = GXv_char12[0] ;
         wpregistrarcita_impl.this.AV23HttpStatus = GXv_int13[0] ;
         if ( AV23HttpStatus != 201 )
         {
            httpContext.GX_msglist.addItem(AV15ErrorMessage);
            AV20hasErrors = true ;
         }
         if ( ! AV20hasErrors )
         {
            AV13clientIp = "190.237.7.159" ;
            GXv_char12[0] = AV50tokenSession ;
            GXv_char11[0] = AV15ErrorMessage ;
            GXv_int13[0] = AV23HttpStatus ;
            GXv_SdtSDTResponseTokenSession20014[0] = AV41SDTResponseTokenSession200;
            GXv_SdtSDTResponseTokenSession40015[0] = AV42SDTResponseTokenSession400;
            GXv_char16[0] = AV47temp ;
            new com.projectthani.prcwstokensession(remoteHandle, context).execute( new com.projectthani.prcgetconfigvalue(remoteHandle, context).executeUdp( "merchantId"), DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), AV6accessToken, AV29PacienteId, AV13clientIp, GXv_char12, GXv_char11, GXv_int13, GXv_SdtSDTResponseTokenSession20014, GXv_SdtSDTResponseTokenSession40015, GXv_char16) ;
            wpregistrarcita_impl.this.AV50tokenSession = GXv_char12[0] ;
            wpregistrarcita_impl.this.AV15ErrorMessage = GXv_char11[0] ;
            wpregistrarcita_impl.this.AV23HttpStatus = GXv_int13[0] ;
            AV41SDTResponseTokenSession200 = GXv_SdtSDTResponseTokenSession20014[0] ;
            AV42SDTResponseTokenSession400 = GXv_SdtSDTResponseTokenSession40015[0] ;
            wpregistrarcita_impl.this.AV47temp = GXv_char16[0] ;
            AV40SDTRequestTokenSession.setgxTv_SdtSDTRequestTokenSession_Amount( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()) );
            AV40SDTRequestTokenSession.setgxTv_SdtSDTRequestTokenSession_Channel( "web" );
            if ( AV23HttpStatus == 400 )
            {
               AV15ErrorMessage = AV42SDTResponseTokenSession400.getgxTv_SdtSDTResponseTokenSession400_Errormessage() ;
            }
            if ( AV23HttpStatus != 200 )
            {
               AV20hasErrors = true ;
               httpContext.GX_msglist.addItem(AV15ErrorMessage);
            }
            if ( ! AV20hasErrors )
            {
               AV33purchaseNumber = GXutil.trim( GXutil.str( AV14DisponibilidadId, 8, 0)) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV33purchaseNumber", AV33purchaseNumber);
               AV51WebSession.setValue("accessTokenNiubiz", AV6accessToken);
               AV51WebSession.setValue("purchaseNumber", AV33purchaseNumber);
               AV51WebSession.setValue("monto", GXutil.str( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(), 4, 0));
               this.executeExternalObjectMethod("", false, "GlobalEvents", "openFormNiubiz", new Object[] {}, true);
            }
         }
      }
      else
      {
         httpContext.GX_msglist.addItem(new com.projectthani.wwpbaseobjects.dvmessagebasicnotification(remoteHandle, context).executeUdp( "Advertencia", "Debe aceptar los terminos y condiciones para realizar el pago.", "notice", "", "true"));
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41SDTResponseTokenSession200", AV41SDTResponseTokenSession200);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV40SDTRequestTokenSession", AV40SDTRequestTokenSession);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV5Cita", AV5Cita);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV32Pago", AV32Pago);
   }

   public void S152( )
   {
      /* 'CREATECITA' Routine */
      returnInSub = false ;
      if ( ( AV29PacienteId > 0 ) && ( AV14DisponibilidadId > 0 ) )
      {
         if ( GXutil.strcmp(AV12CitaFamiliar, "Si") == 0 )
         {
            AV5Cita.setgxTv_SdtCita_Pacienteid( AV44SeleccionarFamiliar );
            AV5Cita.setgxTv_SdtCita_Citamotivoconsulta( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta() );
            AV5Cita.setgxTv_SdtCita_Citapeso( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso() );
            AV5Cita.setgxTv_SdtCita_Citaestatura( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura() );
         }
         else
         {
            AV5Cita.setgxTv_SdtCita_Pacienteid( AV29PacienteId );
            AV5Cita.setgxTv_SdtCita_Citamotivoconsulta( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta() );
            AV5Cita.setgxTv_SdtCita_Citapeso( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso() );
            AV5Cita.setgxTv_SdtCita_Citaestatura( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura() );
         }
         AV5Cita.setgxTv_SdtCita_Sgcitadisponibilidadid( AV14DisponibilidadId );
         AV5Cita.setgxTv_SdtCita_Citafechareserva( GXutil.now( ) );
         AV5Cita.setgxTv_SdtCita_Citaestado( "A" );
         AV5Cita.setgxTv_SdtCita_Citaestadopago( "G" );
         AV5Cita.setgxTv_SdtCita_Citaestadocita( "R" );
         GXt_char17 = "" ;
         GXv_char16[0] = GXt_char17 ;
         new com.projectthani.prcgenerarcodigocita(remoteHandle, context).execute( AV14DisponibilidadId, GXv_char16) ;
         wpregistrarcita_impl.this.GXt_char17 = GXv_char16[0] ;
         AV5Cita.setgxTv_SdtCita_Citacode( GXt_char17 );
         if ( AV52UploadedFiles.size() > 0 )
         {
            AV5Cita.setgxTv_SdtCita_Citaarchivo( ((com.projectthani.SdtFileUploadData)AV52UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
            AV5Cita.setgxTv_SdtCita_Citaarchivonombre( ((com.projectthani.SdtFileUploadData)AV52UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_Name() );
            AV5Cita.setgxTv_SdtCita_Citaarchivoextencion( ((com.projectthani.SdtFileUploadData)AV52UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_Extension() );
         }
         AV51WebSession.setValue("CitaTemporal", AV5Cita.toJSonString(true, true));
         AV32Pago.setgxTv_SdtPago_Pagomonto( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()) );
         if ( AV8Boleta )
         {
            AV32Pago.setgxTv_SdtPago_Pagotipodocumentocliente( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento() );
            AV32Pago.setgxTv_SdtPago_Pagoclientenrodocumento( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento() );
            AV32Pago.setgxTv_SdtPago_Pagoclientedenominacion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres()+" "+((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos() );
            AV32Pago.setgxTv_SdtPago_Pagoclientedireccion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion() );
            AV32Pago.setgxTv_SdtPago_Pagoclienteemail( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail() );
            AV32Pago.setgxTv_SdtPago_Pagotipodocumento( (short)(2) );
            AV32Pago.setgxTv_SdtPago_Pagofechaemision( Gx_date );
         }
         else if ( AV16Factura )
         {
            AV32Pago.setgxTv_SdtPago_Pagotipodocumentocliente( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento() );
            AV32Pago.setgxTv_SdtPago_Pagoclientenrodocumento( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento() );
            AV32Pago.setgxTv_SdtPago_Pagoclientedenominacion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial() );
            AV32Pago.setgxTv_SdtPago_Pagoclientedireccion( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+1)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion() );
            AV32Pago.setgxTv_SdtPago_Pagotipodocumento( (short)(1) );
            AV32Pago.setgxTv_SdtPago_Pagofechaemision( Gx_date );
         }
         AV51WebSession.setValue("PagoTemporal", AV32Pago.toJSonString(true, true));
         AV51WebSession.setValue("NombreDoctor", ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor());
         AV51WebSession.setValue("FechaCita", localUtil.dtoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), 3, "/"));
         AV51WebSession.setValue("HoraCita", ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora());
      }
      else
      {
         httpContext.GX_msglist.addItem("Error");
      }
   }

   private void e21703( )
   {
      /* Gridfactura_Load Routine */
      returnInSub = false ;
      AV100GXV42 = 1 ;
      while ( AV100GXV42 <= AV36SDTInformacionDelPacienteFacturacionFs.size() )
      {
         AV36SDTInformacionDelPacienteFacturacionFs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(276) ;
         }
         sendrow_2763( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_276_Refreshing )
         {
            httpContext.doAjaxLoad(276, GridfacturaRow);
         }
         AV100GXV42 = (int)(AV100GXV42+1) ;
      }
   }

   private void e20704( )
   {
      /* Gridboleta_Load Routine */
      returnInSub = false ;
      AV92GXV34 = 1 ;
      while ( AV92GXV34 <= AV35SDTInformacionDelPacienteFacturacionBs.size() )
      {
         AV35SDTInformacionDelPacienteFacturacionBs.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(235) ;
         }
         sendrow_2354( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_235_Refreshing )
         {
            httpContext.doAjaxLoad(235, GridboletaRow);
         }
         AV92GXV34 = (int)(AV92GXV34+1) ;
      }
   }

   private void e19705( )
   {
      /* Detallepaciente_Load Routine */
      returnInSub = false ;
      AV70GXV12 = 1 ;
      while ( AV70GXV12 <= AV38SDTInformacionDelPacientes.size() )
      {
         AV38SDTInformacionDelPacientes.currentItem( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(98) ;
         }
         sendrow_985( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_98_Refreshing )
         {
            httpContext.doAjaxLoad(98, DetallepacienteRow);
         }
         AV70GXV12 = (int)(AV70GXV12+1) ;
      }
   }

   private void e18706( )
   {
      /* Detallepacientefamiliar_Load Routine */
      returnInSub = false ;
      AV81GXV23 = 1 ;
      while ( AV81GXV23 <= AV37SDTInformacionDelPacienteFamiliars.size() )
      {
         AV37SDTInformacionDelPacienteFamiliars.currentItem( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(146) ;
         }
         sendrow_1466( ) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_146_Refreshing )
         {
            httpContext.doAjaxLoad(146, DetallepacientefamiliarRow);
         }
         AV81GXV23 = (int)(AV81GXV23+1) ;
      }
   }

   public void wb_table2_270_702( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblGrupdc_Internalname, tblGrupdc_Internalname, "", "MB85PX", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablefactura_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridfacturaContainer.SetIsFreestyle(true);
         GridfacturaContainer.SetWrapped(nGXWrapped);
         if ( GridfacturaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridfacturaContainer"+"DivS\" data-gxgridid=\"276\">") ;
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
            GridfacturaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridfactura_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridfactura_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridfactura_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridfactura_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridfactura_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridfactura_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridfacturaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridfactura_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 276 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_276 = (int)(nGXsfl_276_idx-1) ;
         if ( GridfacturaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV100GXV42 = nGXsfl_276_idx ;
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
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_270_702e( true) ;
      }
      else
      {
         wb_table2_270_702e( false) ;
      }
   }

   public void wb_table1_229_702( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblGrupdp_Internalname, tblGrupdp_Internalname, "", "MB85PX", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableboleta_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridboletaContainer.SetIsFreestyle(true);
         GridboletaContainer.SetWrapped(nGXWrapped);
         if ( GridboletaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridboletaContainer"+"DivS\" data-gxgridid=\"235\">") ;
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
      if ( wbEnd == 235 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_235 = (int)(nGXsfl_235_idx-1) ;
         if ( GridboletaContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV92GXV34 = nGXsfl_235_idx ;
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
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_229_702e( true) ;
      }
      else
      {
         wb_table1_229_702e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV14DisponibilidadId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14DisponibilidadId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV14DisponibilidadId), 8, 0));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDISPONIBILIDADID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV14DisponibilidadId), "ZZZZZZZ9")));
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
      pa702( ) ;
      ws702( ) ;
      we702( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2022511034220", true, true);
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
      httpContext.AddJavascriptSource("wpregistrarcita.js", "?2022511034221", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/pnotify.custom.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVMessage/DVMessageRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVTabsTransform/DVTabsTransformRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_162( )
   {
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafotografiadoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAFOTOGRAFIADOCTOR_"+sGXsfl_16_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITANOMBRESDOCTOR_"+sGXsfl_16_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAESPECIALIDADDOCTOR_"+sGXsfl_16_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITACLINICA_"+sGXsfl_16_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITASEDE_"+sGXsfl_16_idx ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setInternalname( "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITATIPOCONSULTA_"+sGXsfl_16_idx );
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAFECHA_"+sGXsfl_16_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAHORA_"+sGXsfl_16_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITACOSTO_"+sGXsfl_16_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAID_"+sGXsfl_16_idx ;
   }

   public void subsflControlProps_fel_162( )
   {
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafotografiadoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAFOTOGRAFIADOCTOR_"+sGXsfl_16_fel_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITANOMBRESDOCTOR_"+sGXsfl_16_fel_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAESPECIALIDADDOCTOR_"+sGXsfl_16_fel_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITACLINICA_"+sGXsfl_16_fel_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITASEDE_"+sGXsfl_16_fel_idx ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setInternalname( "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITATIPOCONSULTA_"+sGXsfl_16_fel_idx );
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAFECHA_"+sGXsfl_16_fel_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAHORA_"+sGXsfl_16_fel_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITACOSTO_"+sGXsfl_16_fel_idx ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAID_"+sGXsfl_16_fel_idx ;
   }

   public void sendrow_162( )
   {
      subsflControlProps_162( ) ;
      wb700( ) ;
      DetallecitaRow = GXWebRow.GetNew(context,DetallecitaContainer) ;
      if ( subDetallecita_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subDetallecita_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subDetallecita_Class, "") != 0 )
         {
            subDetallecita_Linesclass = subDetallecita_Class+"Odd" ;
         }
      }
      else if ( subDetallecita_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subDetallecita_Backstyle = (byte)(0) ;
         subDetallecita_Backcolor = subDetallecita_Allbackcolor ;
         if ( GXutil.strcmp(subDetallecita_Class, "") != 0 )
         {
            subDetallecita_Linesclass = subDetallecita_Class+"Uniform" ;
         }
      }
      else if ( subDetallecita_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subDetallecita_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subDetallecita_Class, "") != 0 )
         {
            subDetallecita_Linesclass = subDetallecita_Class+"Odd" ;
         }
         subDetallecita_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subDetallecita_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subDetallecita_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_16_idx) % (2))) == 0 )
         {
            subDetallecita_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subDetallecita_Class, "") != 0 )
            {
               subDetallecita_Linesclass = subDetallecita_Class+"Even" ;
            }
         }
         else
         {
            subDetallecita_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subDetallecita_Class, "") != 0 )
            {
               subDetallecita_Linesclass = subDetallecita_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( DetallecitaContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subDetallecita_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_16_idx+"\">") ;
      }
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsdetallecita_Internalname+"_"+sGXsfl_16_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitafotografiadoctor_Internalname+"\"","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Static Bitmap Variable */
      ClassString = "ImageDoctorCita" ;
      StyleString = "" ;
      sImgUrl = httpContext.getResourceRelative(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafotografiadoctor()) ;
      DetallecitaRow.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitafotografiadoctor_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(1),Integer.valueOf(0),"","",Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),"",Integer.valueOf(0),"",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"","","","","","","",Integer.valueOf(1),Boolean.valueOf(false),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita2","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname+"\"","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "tbNombresApellidosDoctor" ;
      StyleString = "" ;
      ClassString = "tbNombresApellidosDoctor" ;
      StyleString = "" ;
      DetallecitaRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitanombresdoctor(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname,"Especialidad:","col-sm-4 ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallecitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaespecialidaddoctor(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(16),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname,"Clinica:","col-sm-4 ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      DetallecitaRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaclinica(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname,"Sede:","col-sm-4 ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      DetallecitaRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitasede(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(3),"row",StyleString,ClassString,"","","200",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getInternalname(),"Tipo Consulta:","col-sm-4 ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      if ( ( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITATIPOCONSULTA_" + sGXsfl_16_idx ;
         cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setName( GXCCtl );
         cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setWebtags( "" );
         cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.addItem("V", "Virtual", (short)(0));
         cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.addItem("P", "En consultorio", (short)(0));
         cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
         if ( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getItemCount() > 0 )
         {
            if ( ( AV59GXV1 > 0 ) && ( AV34SDTInformacionDeLaCitas.size() >= AV59GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta())==0) )
            {
               ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getValidValue(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
            }
         }
      }
      /* ComboBox */
      DetallecitaRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta,cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()),Integer.valueOf(1),cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","ReadonlyAttribute","","","","",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getInternalname(), "Values", cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.ToJavascriptSource(), !bGXsfl_16_Refreshing);
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      sendrow_16230( ) ;
   }

   public void sendrow_16230( )
   {
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname,"Fecha:","col-sm-4 ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallecitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname,localUtil.format(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitafecha(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(8),"chr",Integer.valueOf(1),"row",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(16),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname,"Hora:","col-sm-4 ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallecitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname,((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitahora(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(16),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 TableDetalleCita","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname,"Costo cita:","col-sm-4 ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-sm-8 gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallecitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitacosto()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(16),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 Invisible","left","top","","","div"});
      /* Table start */
      DetallecitaRow.AddColumnProperties("table", -1, isAjaxCallMode( ), new Object[] {tblUnnamedtablecontentfsdetallecita_Internalname+"_"+sGXsfl_16_idx,Integer.valueOf(1),"Table","","","","","","",Integer.valueOf(1),Integer.valueOf(2),"","","","px","px",""});
      DetallecitaRow.AddColumnProperties("row", -1, isAjaxCallMode( ), new Object[] {"","",""});
      DetallecitaRow.AddColumnProperties("cell", -1, isAjaxCallMode( ), new Object[] {"","",""});
      /* Div Control */
      DetallecitaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Attribute/Variable Label */
      DetallecitaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Internalname,"SDTInformacion De La Cita Id","gx-form-item AttributeLabel",Integer.valueOf(0),Boolean.valueOf(true),"width: 25%;"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Enabled!=0)&&(edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 69,'',false,'"+sGXsfl_16_idx+"',16)\"" : " ") ;
      ROClassString = "Attribute" ;
      DetallecitaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitaid()), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Enabled!=0)&&(edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,'.');"+";gx.evt.onblur(this,69);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible),Integer.valueOf(1),Integer.valueOf(0),"text","1",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(16),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      if ( DetallecitaContainer.GetWrapped() == 1 )
      {
         DetallecitaContainer.CloseTag("cell");
      }
      if ( DetallecitaContainer.GetWrapped() == 1 )
      {
         DetallecitaContainer.CloseTag("row");
      }
      if ( DetallecitaContainer.GetWrapped() == 1 )
      {
         DetallecitaContainer.CloseTag("table");
      }
      /* End of table */
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallecitaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes702( ) ;
      /* End of Columns property logic. */
      DetallecitaContainer.AddRow(DetallecitaRow);
      nGXsfl_16_idx = ((subDetallecita_Islastpage==1)&&(nGXsfl_16_idx+1>subdetallecita_fnc_recordsperpage( )) ? 1 : nGXsfl_16_idx+1) ;
      sGXsfl_16_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_16_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_162( ) ;
      /* End function sendrow_162 */
   }

   public void subsflControlProps_985( )
   {
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTENOMBRES_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEAPELLIDOS_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTETIPODOCUMENTO_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTENRODOCUMENTO_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEFECHANACIMIENTO_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTESEXO_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEEMAIL_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEPESO_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEESTATURA_"+sGXsfl_98_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEMOTIVOCONSULTA_"+sGXsfl_98_idx ;
   }

   public void subsflControlProps_fel_985( )
   {
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTENOMBRES_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEAPELLIDOS_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTETIPODOCUMENTO_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTENRODOCUMENTO_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEFECHANACIMIENTO_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTESEXO_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEEMAIL_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEPESO_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEESTATURA_"+sGXsfl_98_fel_idx ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEMOTIVOCONSULTA_"+sGXsfl_98_fel_idx ;
   }

   public void sendrow_985( )
   {
      subsflControlProps_985( ) ;
      wb700( ) ;
      DetallepacienteRow = GXWebRow.GetNew(context,DetallepacienteContainer) ;
      if ( subDetallepaciente_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subDetallepaciente_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subDetallepaciente_Class, "") != 0 )
         {
            subDetallepaciente_Linesclass = subDetallepaciente_Class+"Odd" ;
         }
      }
      else if ( subDetallepaciente_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subDetallepaciente_Backstyle = (byte)(0) ;
         subDetallepaciente_Backcolor = subDetallepaciente_Allbackcolor ;
         if ( GXutil.strcmp(subDetallepaciente_Class, "") != 0 )
         {
            subDetallepaciente_Linesclass = subDetallepaciente_Class+"Uniform" ;
         }
      }
      else if ( subDetallepaciente_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subDetallepaciente_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subDetallepaciente_Class, "") != 0 )
         {
            subDetallepaciente_Linesclass = subDetallepaciente_Class+"Odd" ;
         }
         subDetallepaciente_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subDetallepaciente_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subDetallepaciente_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_98_idx) % (2))) == 0 )
         {
            subDetallepaciente_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subDetallepaciente_Class, "") != 0 )
            {
               subDetallepaciente_Linesclass = subDetallepaciente_Class+"Even" ;
            }
         }
         else
         {
            subDetallepaciente_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subDetallepaciente_Class, "") != 0 )
            {
               subDetallepaciente_Linesclass = subDetallepaciente_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( DetallepacienteContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subDetallepaciente_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_98_idx+"\">") ;
      }
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsdetallepaciente_Internalname+"_"+sGXsfl_98_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname,"Nombres:"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname,"Apellidos:"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      ClassString = "ReadonlyAttribute" ;
      StyleString = "" ;
      DetallepacienteRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteapellidos(),"","",Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(4),"row",StyleString,ClassString,"","","250",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname,"Tipo Documento:"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientetipodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname,"Nro Documento:"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientenrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname,"Fecha Nacimiento:"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientefechanacimiento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname,"Sexo:"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientesexo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname,"Email:"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_98530( ) ;
   }

   public void sendrow_98530( )
   {
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteemail(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Internalname,"Peso:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Enabled!=0)&&(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 134,'',false,'"+sGXsfl_98_idx+"',98)\"" : " ") ;
      ROClassString = "Attribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientepeso(), "ZZ9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Enabled!=0)&&(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,134);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Internalname,"Estatura:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Enabled!=0)&&(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 138,'',false,'"+sGXsfl_98_idx+"',98)\"" : " ") ;
      ROClassString = "Attribute" ;
      DetallepacienteRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura(), (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacienteestatura(), "9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Enabled!=0)&&(edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,138);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(98),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-12 TableMotivoConsulta DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacienteRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Internalname,"Motivo Consulta:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacienteRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Enabled!=0)&&(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 143,'',false,'"+sGXsfl_98_idx+"',98)\"" : " ") ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      DetallepacienteRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Internalname,((com.projectthani.SdtSDTInformacionDelPaciente)AV38SDTInformacionDelPacientes.elementAt(-1+AV70GXV12)).getgxTv_SdtSDTInformacionDelPaciente_Sdtinformaciondelpacientemotivoconsulta(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Enabled!=0)&&(edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,143);\"" : " "),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","4000",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacienteRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes705( ) ;
      /* End of Columns property logic. */
      DetallepacienteContainer.AddRow(DetallepacienteRow);
      nGXsfl_98_idx = ((subDetallepaciente_Islastpage==1)&&(nGXsfl_98_idx+1>subdetallepaciente_fnc_recordsperpage( )) ? 1 : nGXsfl_98_idx+1) ;
      sGXsfl_98_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_98_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_985( ) ;
      /* End function sendrow_985 */
   }

   public void subsflControlProps_1466( )
   {
      edtavSdtinformaciondelpacientefamiliars__nombres_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__NOMBRES_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__APELLIDOPATERNO_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__APELLIDOMATERNO_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__TIPODOCUMENTO_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__NRODOCUMENTO_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__FECHANACIMIENTO_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__sexo_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__SEXO_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__peso_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__PESO_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__estatura_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__ESTATURA_"+sGXsfl_146_idx ;
      edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__MOTIVOCONSULTA_"+sGXsfl_146_idx ;
   }

   public void subsflControlProps_fel_1466( )
   {
      edtavSdtinformaciondelpacientefamiliars__nombres_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__NOMBRES_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__APELLIDOPATERNO_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__APELLIDOMATERNO_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__TIPODOCUMENTO_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__NRODOCUMENTO_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__FECHANACIMIENTO_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__sexo_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__SEXO_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__peso_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__PESO_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__estatura_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__ESTATURA_"+sGXsfl_146_fel_idx ;
      edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__MOTIVOCONSULTA_"+sGXsfl_146_fel_idx ;
   }

   public void sendrow_1466( )
   {
      subsflControlProps_1466( ) ;
      wb700( ) ;
      DetallepacientefamiliarRow = GXWebRow.GetNew(context,DetallepacientefamiliarContainer) ;
      if ( subDetallepacientefamiliar_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subDetallepacientefamiliar_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subDetallepacientefamiliar_Class, "") != 0 )
         {
            subDetallepacientefamiliar_Linesclass = subDetallepacientefamiliar_Class+"Odd" ;
         }
      }
      else if ( subDetallepacientefamiliar_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subDetallepacientefamiliar_Backstyle = (byte)(0) ;
         subDetallepacientefamiliar_Backcolor = subDetallepacientefamiliar_Allbackcolor ;
         if ( GXutil.strcmp(subDetallepacientefamiliar_Class, "") != 0 )
         {
            subDetallepacientefamiliar_Linesclass = subDetallepacientefamiliar_Class+"Uniform" ;
         }
      }
      else if ( subDetallepacientefamiliar_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subDetallepacientefamiliar_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subDetallepacientefamiliar_Class, "") != 0 )
         {
            subDetallepacientefamiliar_Linesclass = subDetallepacientefamiliar_Class+"Odd" ;
         }
         subDetallepacientefamiliar_Backcolor = (int)(0xFFFFFF) ;
      }
      else if ( subDetallepacientefamiliar_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subDetallepacientefamiliar_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_146_idx) % (2))) == 0 )
         {
            subDetallepacientefamiliar_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subDetallepacientefamiliar_Class, "") != 0 )
            {
               subDetallepacientefamiliar_Linesclass = subDetallepacientefamiliar_Class+"Even" ;
            }
         }
         else
         {
            subDetallepacientefamiliar_Backcolor = (int)(0xFFFFFF) ;
            if ( GXutil.strcmp(subDetallepacientefamiliar_Class, "") != 0 )
            {
               subDetallepacientefamiliar_Linesclass = subDetallepacientefamiliar_Class+"Odd" ;
            }
         }
      }
      /* Start of Columns property logic. */
      if ( DetallepacientefamiliarContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<tr"+" class=\""+subDetallepacientefamiliar_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_146_idx+"\">") ;
      }
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsdetallepacientefamiliar_Internalname+"_"+sGXsfl_146_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__nombres_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__nombres_Internalname,"Nombres"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__nombres_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nombres(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__nombres_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientefamiliars__nombres_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname,"Apellido Paterno"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidopaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname,"Apellido Materno"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Apellidomaterno(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname,"Tipo Documento"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Tipodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__tipodocumento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname,"Nro Documento"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Nrodocumento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__nrodocumento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname,"Fecha Nacimiento"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Fechanacimiento(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__sexo_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__sexo_Internalname,"Sexo"," ReadonlyAttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_146630( ) ;
   }

   public void sendrow_146630( )
   {
      /* Single line edit */
      ROClassString = "ReadonlyAttribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__sexo_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Sexo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__sexo_Jsonclick,Integer.valueOf(0),"ReadonlyAttribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(edtavSdtinformaciondelpacientefamiliars__sexo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(40),"chr",Integer.valueOf(1),"row",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__peso_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__peso_Internalname,"Peso"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefamiliars__peso_Enabled!=0)&&(edtavSdtinformaciondelpacientefamiliars__peso_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 182,'',false,'"+sGXsfl_146_idx+"',146)\"" : " ") ;
      ROClassString = "Attribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__peso_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso(), (byte)(6), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Peso(), "ZZ9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefamiliars__peso_Enabled!=0)&&(edtavSdtinformaciondelpacientefamiliars__peso_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,182);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__peso_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(6),"chr",Integer.valueOf(1),"row",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 DataContentCell DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__estatura_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__estatura_Internalname,"Estatura"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefamiliars__estatura_Enabled!=0)&&(edtavSdtinformaciondelpacientefamiliars__estatura_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 186,'',false,'"+sGXsfl_146_idx+"',146)\"" : " ") ;
      ROClassString = "Attribute" ;
      DetallepacientefamiliarRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__estatura_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura(), (byte)(4), (byte)(2), ",", "")),GXutil.ltrim( localUtil.format( ((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Estatura(), "9.99")),TempTags+" onchange=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefamiliars__estatura_Enabled!=0)&&(edtavSdtinformaciondelpacientefamiliars__estatura_Visible!=0) ? " onblur=\""+"gx.num.valid_decimal( this, '.',',','2');"+";gx.evt.onblur(this,186);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefamiliars__estatura_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(4),"chr",Integer.valueOf(1),"row",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(146),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-12 TableMotivoConsulta DscTop","left","top","","","div"});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      DetallepacientefamiliarRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Internalname,"Motivo Consulta"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      DetallepacientefamiliarRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Multiple line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Enabled!=0)&&(edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 191,'',false,'"+sGXsfl_146_idx+"',146)\"" : " ") ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      DetallepacientefamiliarRow.AddColumnProperties("html_textarea", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFamiliar)AV37SDTInformacionDelPacienteFamiliars.elementAt(-1+AV81GXV23)).getgxTv_SdtSDTInformacionDelPacienteFamiliar_Motivoconsulta(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Enabled!=0)&&(edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,191);\"" : " "),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(80),"chr",Integer.valueOf(10),"row",StyleString,ClassString,"","","4000",Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(-1),Boolean.valueOf(true),"","'"+""+"'"+",false,"+"'"+""+"'",Integer.valueOf(0)});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      DetallepacientefamiliarRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes706( ) ;
      /* End of Columns property logic. */
      DetallepacientefamiliarContainer.AddRow(DetallepacientefamiliarRow);
      nGXsfl_146_idx = ((subDetallepacientefamiliar_Islastpage==1)&&(nGXsfl_146_idx+1>subdetallepacientefamiliar_fnc_recordsperpage( )) ? 1 : nGXsfl_146_idx+1) ;
      sGXsfl_146_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_146_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1466( ) ;
      /* End function sendrow_1466 */
   }

   public void subsflControlProps_2354( )
   {
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBNOMBRES_"+sGXsfl_235_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBAPELLIDOS_"+sGXsfl_235_idx ;
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setInternalname( "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_"+sGXsfl_235_idx );
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBNRODOCUMENTO_"+sGXsfl_235_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBEMAIL_"+sGXsfl_235_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTELEFONO_"+sGXsfl_235_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBDIRECCION_"+sGXsfl_235_idx ;
   }

   public void subsflControlProps_fel_2354( )
   {
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBNOMBRES_"+sGXsfl_235_fel_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBAPELLIDOS_"+sGXsfl_235_fel_idx ;
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setInternalname( "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_"+sGXsfl_235_fel_idx );
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBNRODOCUMENTO_"+sGXsfl_235_fel_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBEMAIL_"+sGXsfl_235_fel_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTELEFONO_"+sGXsfl_235_fel_idx ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBDIRECCION_"+sGXsfl_235_fel_idx ;
   }

   public void sendrow_2354( )
   {
      subsflControlProps_2354( ) ;
      wb700( ) ;
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
         if ( ((int)((nGXsfl_235_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subGridboleta_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_235_idx+"\">") ;
      }
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgridboleta_Internalname+"_"+sGXsfl_235_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion DscTop","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Internalname,"Nombres:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 241,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnombres(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,241);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion DscTop","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Internalname,"Apellidos:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 245,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbapellidos(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,245);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion DscTop","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getInternalname(),"Tipo Documento:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      TempTags = " " + ((cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getEnabled()!=0)&&(cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 249,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      if ( ( cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_" + sGXsfl_235_idx ;
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setName( GXCCtl );
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setWebtags( "" );
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("6", "RUC", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("1", "DNI", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("7", "PASAPORTE", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("A", "CDI", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
         if ( cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getItemCount() > 0 )
         {
            if ( ( AV92GXV34 > 0 ) && ( AV35SDTInformacionDelPacienteFacturacionBs.size() >= AV92GXV34 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento())==0) )
            {
               ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento( cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()) );
            }
         }
      }
      /* ComboBox */
      GridboletaRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento,cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()),Integer.valueOf(1),cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getEnabled()!=0)&&(cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,249);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getInternalname(), "Values", cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.ToJavascriptSource(), !bGXsfl_235_Refreshing);
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion2 DscTop","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Internalname,"Nro Documento:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 254,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbnrodocumento(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,254);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion2 DscTop","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Internalname,"Email:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 258,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbemail(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,258);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion2 DscTop","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Internalname,"Telefono:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 262,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Internalname,GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtelefono()),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,262);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(20),"chr",Integer.valueOf(1),"row",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 AttributeFacturacion2 DscTop","left","top","","","div"});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridboletaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Internalname,"Direccion:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridboletaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      sendrow_235430( ) ;
   }

   public void sendrow_235430( )
   {
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 267,'',false,'"+sGXsfl_235_idx+"',235)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridboletaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbdireccion(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,267);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridboletaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes704( ) ;
      /* End of Columns property logic. */
      GridboletaContainer.AddRow(GridboletaRow);
      nGXsfl_235_idx = ((subGridboleta_Islastpage==1)&&(nGXsfl_235_idx+1>subgridboleta_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
      sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2354( ) ;
      /* End function sendrow_2354 */
   }

   public void subsflControlProps_2763( )
   {
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setInternalname( "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_"+sGXsfl_276_idx );
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFNRODOCUMENTO_"+sGXsfl_276_idx ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFRAZONSOCIAL_"+sGXsfl_276_idx ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFEMAIL_"+sGXsfl_276_idx ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFDIRECCION_"+sGXsfl_276_idx ;
   }

   public void subsflControlProps_fel_2763( )
   {
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setInternalname( "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_"+sGXsfl_276_fel_idx );
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFNRODOCUMENTO_"+sGXsfl_276_fel_idx ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFRAZONSOCIAL_"+sGXsfl_276_fel_idx ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFEMAIL_"+sGXsfl_276_fel_idx ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFDIRECCION_"+sGXsfl_276_fel_idx ;
   }

   public void sendrow_2763( )
   {
      subsflControlProps_2763( ) ;
      wb700( ) ;
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
         if ( ((int)((nGXsfl_276_idx) % (2))) == 0 )
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
         httpContext.writeText( "<tr"+" class=\""+subGridfactura_Linesclass+"\" style=\""+""+"\""+" data-gxrow=\""+sGXsfl_276_idx+"\">") ;
      }
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {divUnnamedtablefsgridfactura_Internalname+"_"+sGXsfl_276_idx,Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","Table","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion DscTop","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getInternalname()+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getInternalname(),"Tipo Documento:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      TempTags = " " + ((cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getEnabled()!=0)&&(cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 282,'',false,'"+sGXsfl_276_idx+"',276)\"" : " ") ;
      if ( ( cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getItemCount() == 0 ) && isAjaxCallMode( ) )
      {
         GXCCtl = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_" + sGXsfl_276_idx ;
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setName( GXCCtl );
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setWebtags( "" );
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("6", "RUC", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("1", "DNI", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("7", "PASAPORTE", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("A", "CDI", (short)(0));
         cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
         if ( cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getItemCount() > 0 )
         {
            if ( ( AV100GXV42 > 0 ) && ( AV36SDTInformacionDelPacienteFacturacionFs.size() >= AV100GXV42 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento())==0) )
            {
               ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento( cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()) );
            }
         }
      }
      /* ComboBox */
      GridfacturaRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento,cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()),Integer.valueOf(1),cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"em",Integer.valueOf(0),"","","Attribute","","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getEnabled()!=0)&&(cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,282);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(1)});
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getInternalname(), "Values", cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.ToJavascriptSource(), !bGXsfl_276_Refreshing);
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion DscTop","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Internalname,"Nro Documento:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 286,'',false,'"+sGXsfl_276_idx+"',276)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfnrodocumento(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,286);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(15),"chr",Integer.valueOf(1),"row",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(276),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 col-md-4 AttributeFacturacion DscTop","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Internalname,"Razon Social:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 290,'',false,'"+sGXsfl_276_idx+"',276)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfrazonsocial(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,290);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(150),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(276),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","row","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-sm-6 AttributeFacturacion2 DscTop","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Internalname,"Email:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 295,'',false,'"+sGXsfl_276_idx+"',276)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfemail(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,295);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(276),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","col-xs-12 col-md-6 AttributeFacturacion2 DscTop","left","top","","","div"});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px","form-group gx-form-group","left","top",""+" data-gx-for=\""+edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Internalname+"\"","","div"});
      /* Attribute/Variable Label */
      GridfacturaRow.AddColumnProperties("html_label", -1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Internalname,"Direccion:"," AttributeLabel",Integer.valueOf(1),Boolean.valueOf(true),""});
      /* Div Control */
      GridfacturaRow.AddColumnProperties("div_start", -1, isAjaxCallMode( ), new Object[] {"",Integer.valueOf(1),Integer.valueOf(0),"px",Integer.valueOf(0),"px"," gx-attribute","left","top","","","div"});
      /* Single line edit */
      TempTags = " " + ((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 299,'',false,'"+sGXsfl_276_idx+"',276)\"" : " ") ;
      ROClassString = "Attribute" ;
      GridfacturaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Internalname,((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionfdireccion(),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Enabled!=0)&&(edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,299);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(1),Integer.valueOf(1),Integer.valueOf(0),"text","",Integer.valueOf(80),"chr",Integer.valueOf(1),"row",Integer.valueOf(150),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(276),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      GridfacturaRow.AddColumnProperties("div_end", -1, isAjaxCallMode( ), new Object[] {"left","top","div"});
      send_integrity_lvl_hashes703( ) ;
      /* End of Columns property logic. */
      GridfacturaContainer.AddRow(GridfacturaRow);
      nGXsfl_276_idx = ((subGridfactura_Islastpage==1)&&(nGXsfl_276_idx+1>subgridfactura_fnc_recordsperpage( )) ? 1 : nGXsfl_276_idx+1) ;
      sGXsfl_276_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_276_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2763( ) ;
      /* End function sendrow_2763 */
   }

   public void init_default_properties( )
   {
      lblTbtituloinfocita_Internalname = "TBTITULOINFOCITA" ;
      divSecciontitle_Internalname = "SECCIONTITLE" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafotografiadoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAFOTOGRAFIADOCTOR" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITANOMBRESDOCTOR" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAESPECIALIDADDOCTOR" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITACLINICA" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITASEDE" ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setInternalname( "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITATIPOCONSULTA" );
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAFECHA" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAHORA" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITACOSTO" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Internalname = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITAID" ;
      tblUnnamedtablecontentfsdetallecita_Internalname = "UNNAMEDTABLECONTENTFSDETALLECITA" ;
      divUnnamedtablefsdetallecita_Internalname = "UNNAMEDTABLEFSDETALLECITA" ;
      divTablecita_Internalname = "TABLECITA" ;
      lblTitle2_Internalname = "TITLE2" ;
      divSecciontitulo2_Internalname = "SECCIONTITULO2" ;
      lblTabgeneral_title_Internalname = "TABGENERAL_TITLE" ;
      cmbavCitafamiliar.setInternalname( "vCITAFAMILIAR" );
      cmbavSeleccionarfamiliar.setInternalname( "vSELECCIONARFAMILIAR" );
      divTableseleccionarcita_Internalname = "TABLESELECCIONARCITA" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTENOMBRES" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEAPELLIDOS" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTETIPODOCUMENTO" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTENRODOCUMENTO" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEFECHANACIMIENTO" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTESEXO" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEEMAIL" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEPESO" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEESTATURA" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Internalname = "SDTINFORMACIONDELPACIENTES__SDTINFORMACIONDELPACIENTEMOTIVOCONSULTA" ;
      divUnnamedtablefsdetallepaciente_Internalname = "UNNAMEDTABLEFSDETALLEPACIENTE" ;
      edtavSdtinformaciondelpacientefamiliars__nombres_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__NOMBRES" ;
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__APELLIDOPATERNO" ;
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__APELLIDOMATERNO" ;
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__TIPODOCUMENTO" ;
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__NRODOCUMENTO" ;
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__FECHANACIMIENTO" ;
      edtavSdtinformaciondelpacientefamiliars__sexo_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__SEXO" ;
      edtavSdtinformaciondelpacientefamiliars__peso_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__PESO" ;
      edtavSdtinformaciondelpacientefamiliars__estatura_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__ESTATURA" ;
      edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Internalname = "SDTINFORMACIONDELPACIENTEFAMILIARS__MOTIVOCONSULTA" ;
      divUnnamedtablefsdetallepacientefamiliar_Internalname = "UNNAMEDTABLEFSDETALLEPACIENTEFAMILIAR" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      lblTaparchivos_title_Internalname = "TAPARCHIVOS_TITLE" ;
      lblTbinfoarchivo_Internalname = "TBINFOARCHIVO" ;
      divSecciontitlearchivo_Internalname = "SECCIONTITLEARCHIVO" ;
      Ucsubirarchivo_Internalname = "UCSUBIRARCHIVO" ;
      divUnnamedtable7_Internalname = "UNNAMEDTABLE7" ;
      grpUnnamedgroup8_Internalname = "UNNAMEDGROUP8" ;
      divSec2_Internalname = "SEC2" ;
      divSecciontitle2_Internalname = "SECCIONTITLE2" ;
      divUnnamedtable6_Internalname = "UNNAMEDTABLE6" ;
      lblTapfacturacion_title_Internalname = "TAPFACTURACION_TITLE" ;
      chkavBoleta.setInternalname( "vBOLETA" );
      chkavFactura.setInternalname( "vFACTURA" );
      divGruptc_Internalname = "GRUPTC" ;
      grpUnnamedgroup3_Internalname = "UNNAMEDGROUP3" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBNOMBRES" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBAPELLIDOS" ;
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setInternalname( "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO" );
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBNRODOCUMENTO" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBEMAIL" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTELEFONO" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBDIRECCION" ;
      divUnnamedtablefsgridboleta_Internalname = "UNNAMEDTABLEFSGRIDBOLETA" ;
      divTableboleta_Internalname = "TABLEBOLETA" ;
      tblGrupdp_Internalname = "GRUPDP" ;
      grpUnnamedgroup5_Internalname = "UNNAMEDGROUP5" ;
      divSeccionboleta_Internalname = "SECCIONBOLETA" ;
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setInternalname( "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO" );
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFNRODOCUMENTO" ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFRAZONSOCIAL" ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFEMAIL" ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Internalname = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFDIRECCION" ;
      divUnnamedtablefsgridfactura_Internalname = "UNNAMEDTABLEFSGRIDFACTURA" ;
      divTablefactura_Internalname = "TABLEFACTURA" ;
      tblGrupdc_Internalname = "GRUPDC" ;
      grpUnnamedgroup4_Internalname = "UNNAMEDGROUP4" ;
      divSeccionfactura_Internalname = "SECCIONFACTURA" ;
      divSecfacturacion_Internalname = "SECFACTURACION" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      lblTaprealizarpago1_title_Internalname = "TAPREALIZARPAGO1_TITLE" ;
      chkavTerminoscondiciones.setInternalname( "vTERMINOSCONDICIONES" );
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Gxuitabspanel_steps_Internalname = "GXUITABSPANEL_STEPS" ;
      bttBtnwizardprevious_Internalname = "BTNWIZARDPREVIOUS" ;
      bttBtncancel_Internalname = "BTNCANCEL" ;
      bttBtnwizardnext_Internalname = "BTNWIZARDNEXT" ;
      bttBtnenter_Internalname = "BTNENTER" ;
      divTablepaciente_Internalname = "TABLEPACIENTE" ;
      Ucmensaje_Internalname = "UCMENSAJE" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Wizard_steps_Internalname = "WIZARD_STEPS" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subDetallecita_Internalname = "DETALLECITA" ;
      subDetallepaciente_Internalname = "DETALLEPACIENTE" ;
      subDetallepacientefamiliar_Internalname = "DETALLEPACIENTEFAMILIAR" ;
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
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Enabled = 1 ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Enabled = 1 ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Enabled = 1 ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Enabled = 1 ;
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setJsonclick( "" );
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setVisible( 1 );
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setEnabled( 1 );
      subGridfactura_Class = "FreeStyleGrid" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Enabled = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Enabled = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Enabled = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Enabled = 1 ;
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setJsonclick( "" );
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setVisible( 1 );
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setEnabled( 1 );
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Enabled = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Visible = 1 ;
      edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Enabled = 1 ;
      subGridboleta_Class = "FreeStyleGrid" ;
      edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Visible = 1 ;
      edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Enabled = 1 ;
      edtavSdtinformaciondelpacientefamiliars__estatura_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__estatura_Visible = 1 ;
      edtavSdtinformaciondelpacientefamiliars__estatura_Enabled = 1 ;
      edtavSdtinformaciondelpacientefamiliars__peso_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__peso_Visible = 1 ;
      edtavSdtinformaciondelpacientefamiliars__peso_Enabled = 1 ;
      edtavSdtinformaciondelpacientefamiliars__sexo_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Jsonclick = "" ;
      edtavSdtinformaciondelpacientefamiliars__nombres_Jsonclick = "" ;
      subDetallepacientefamiliar_Class = "FreeStyleGrid" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Visible = 1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Enabled = 1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Jsonclick = "" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Visible = 1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Enabled = 1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Jsonclick = "" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Visible = 1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Enabled = 1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Jsonclick = "" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Jsonclick = "" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Jsonclick = "" ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Jsonclick = "" ;
      subDetallepaciente_Class = "FreeStyleGrid" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Jsonclick = "" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Enabled = 1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Jsonclick = "" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Jsonclick = "" ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Jsonclick = "" ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setJsonclick( "" );
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Jsonclick = "" ;
      subDetallecita_Class = "FreeStyleGrid" ;
      subGridboleta_Allowcollapsing = (byte)(0) ;
      subGridfactura_Allowcollapsing = (byte)(0) ;
      subGridboleta_Backcolorstyle = (byte)(0) ;
      subGridfactura_Backcolorstyle = (byte)(0) ;
      edtavSdtinformaciondelpacientefamiliars__sexo_Enabled = -1 ;
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled = -1 ;
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled = -1 ;
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled = -1 ;
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled = -1 ;
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled = -1 ;
      edtavSdtinformaciondelpacientefamiliars__nombres_Enabled = -1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled = -1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled = -1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled = -1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled = -1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled = -1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled = -1 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled = -1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled = -1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled = -1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled = -1 ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setEnabled( -1 );
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled = -1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled = -1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled = -1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled = -1 ;
      bttBtnenter_Caption = "Confirmar" ;
      bttBtnenter_Visible = 1 ;
      bttBtnwizardnext_Visible = 1 ;
      bttBtncancel_Visible = 1 ;
      bttBtnwizardprevious_Visible = 1 ;
      chkavTerminoscondiciones.setEnabled( 1 );
      divSeccionfactura_Visible = 1 ;
      divSeccionboleta_Visible = 1 ;
      chkavFactura.setEnabled( 1 );
      chkavBoleta.setEnabled( 1 );
      Ucsubirarchivo_Tooltiptext = "" ;
      subDetallepacientefamiliar_Allowcollapsing = (byte)(0) ;
      edtavSdtinformaciondelpacientefamiliars__sexo_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__nombres_Enabled = 0 ;
      subDetallepacientefamiliar_Backcolorstyle = (byte)(0) ;
      subDetallepacientefamiliar_Visible = 1 ;
      subDetallepaciente_Allowcollapsing = (byte)(0) ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled = 0 ;
      subDetallepaciente_Backcolorstyle = (byte)(0) ;
      subDetallepaciente_Visible = 1 ;
      cmbavSeleccionarfamiliar.setJsonclick( "" );
      cmbavSeleccionarfamiliar.setEnabled( 1 );
      cmbavSeleccionarfamiliar.setVisible( 1 );
      cmbavCitafamiliar.setJsonclick( "" );
      cmbavCitafamiliar.setEnabled( 1 );
      subDetallecita_Allowcollapsing = (byte)(0) ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible = 1 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled = 0 ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      subDetallecita_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "WPRegistrar Cita" );
      Wizard_steps_Tabsinternalname = "" ;
      Ucmensaje_Stylingtype = "brighttheme" ;
      Gxuitabspanel_steps_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_steps_Class = "" ;
      Gxuitabspanel_steps_Pagecount = 4 ;
      Ucsubirarchivo_Maxnumberoffiles = 1 ;
      Ucsubirarchivo_Autoupload = GXutil.toBoolean( -1) ;
      Ucsubirarchivo_Class = "" ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "SDTINFORMACIONDELACITAS__SDTINFORMACIONDELACITATIPOCONSULTA_" + sGXsfl_16_idx ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setName( GXCCtl );
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setWebtags( "" );
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.addItem("V", "Virtual", (short)(0));
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.addItem("P", "En consultorio", (short)(0));
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getItemCount() > 0 )
      {
         if ( ( AV59GXV1 > 0 ) && ( AV34SDTInformacionDeLaCitas.size() >= AV59GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta())==0) )
         {
            ((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).setgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta( cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.getValidValue(((com.projectthani.SdtSDTInformacionDeLaCita)AV34SDTInformacionDeLaCitas.elementAt(-1+AV59GXV1)).getgxTv_SdtSDTInformacionDeLaCita_Sdtinformaciondelacitatipoconsulta()) );
         }
      }
      cmbavCitafamiliar.setName( "vCITAFAMILIAR" );
      cmbavCitafamiliar.setWebtags( "" );
      cmbavCitafamiliar.addItem("No", "No", (short)(0));
      cmbavCitafamiliar.addItem("Si", "Si", (short)(0));
      if ( cmbavCitafamiliar.getItemCount() > 0 )
      {
         AV12CitaFamiliar = cmbavCitafamiliar.getValidValue(AV12CitaFamiliar) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12CitaFamiliar", AV12CitaFamiliar);
      }
      cmbavSeleccionarfamiliar.setName( "vSELECCIONARFAMILIAR" );
      cmbavSeleccionarfamiliar.setWebtags( "" );
      cmbavSeleccionarfamiliar.addItem(GXutil.trim( GXutil.str( 0, 4, 0)), "Seleccionar", (short)(0));
      if ( cmbavSeleccionarfamiliar.getItemCount() > 0 )
      {
         AV44SeleccionarFamiliar = (short)(GXutil.lval( cmbavSeleccionarfamiliar.getValidValue(GXutil.trim( GXutil.str( AV44SeleccionarFamiliar, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44SeleccionarFamiliar", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV44SeleccionarFamiliar), 4, 0));
      }
      chkavBoleta.setName( "vBOLETA" );
      chkavBoleta.setWebtags( "" );
      chkavBoleta.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavBoleta.getInternalname(), "TitleCaption", chkavBoleta.getCaption(), true);
      chkavBoleta.setCheckedValue( "false" );
      AV8Boleta = GXutil.strtobool( GXutil.booltostr( AV8Boleta)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8Boleta", AV8Boleta);
      chkavFactura.setName( "vFACTURA" );
      chkavFactura.setWebtags( "" );
      chkavFactura.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavFactura.getInternalname(), "TitleCaption", chkavFactura.getCaption(), true);
      chkavFactura.setCheckedValue( "false" );
      AV16Factura = GXutil.strtobool( GXutil.booltostr( AV16Factura)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Factura", AV16Factura);
      GXCCtl = "SDTINFORMACIONDELPACIENTEFACTURACIONBS__SDTINFORMACIONDELPACIENTEFACTURACIONBTIPODOCUMENTO_" + sGXsfl_235_idx ;
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setName( GXCCtl );
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.setWebtags( "" );
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("6", "RUC", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("1", "DNI", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("A", "CDI", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
      if ( cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getItemCount() > 0 )
      {
         if ( ( AV92GXV34 > 0 ) && ( AV35SDTInformacionDelPacienteFacturacionBs.size() >= AV92GXV34 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento())==0) )
         {
            ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).setgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento( cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionB)AV35SDTInformacionDelPacienteFacturacionBs.elementAt(-1+AV92GXV34)).getgxTv_SdtSDTInformacionDelPacienteFacturacionB_Sdtinformaciondelpacientefacturacionbtipodocumento()) );
         }
      }
      GXCCtl = "SDTINFORMACIONDELPACIENTEFACTURACIONFS__SDTINFORMACIONDELPACIENTEFACTURACIONFTIPODOCUMENTO_" + sGXsfl_276_idx ;
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setName( GXCCtl );
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.setWebtags( "" );
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("6", "RUC", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("1", "DNI", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("4", "CARNET DE EXT.", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("A", "CDI", (short)(0));
      cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.addItem("0", "NO DOMICILIADO", (short)(0));
      if ( cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getItemCount() > 0 )
      {
         if ( ( AV100GXV42 > 0 ) && ( AV36SDTInformacionDelPacienteFacturacionFs.size() >= AV100GXV42 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento())==0) )
         {
            ((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).setgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento( cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento.getValidValue(((com.projectthani.SdtSDTInformacionDelPacienteFacturacionF)AV36SDTInformacionDelPacienteFacturacionFs.elementAt(-1+AV100GXV42)).getgxTv_SdtSDTInformacionDelPacienteFacturacionF_Sdtinformaciondelpacientefacturacionftipodocumento()) );
         }
      }
      chkavTerminoscondiciones.setName( "vTERMINOSCONDICIONES" );
      chkavTerminoscondiciones.setWebtags( "" );
      chkavTerminoscondiciones.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkavTerminoscondiciones.getInternalname(), "TitleCaption", chkavTerminoscondiciones.getCaption(), true);
      chkavTerminoscondiciones.setCheckedValue( "false" );
      AV49TerminosCondiciones = GXutil.strtobool( GXutil.booltostr( AV49TerminosCondiciones)) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV49TerminosCondiciones", AV49TerminosCondiciones);
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'DETALLECITA_nFirstRecordOnPage'},{av:'DETALLECITA_nEOF'},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'GRIDFACTURA_nEOF'},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'GRIDBOLETA_nEOF'},{av:'DETALLEPACIENTE_nFirstRecordOnPage'},{av:'DETALLEPACIENTE_nEOF'},{av:'DETALLEPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'DETALLEPACIENTEFAMILIAR_nEOF'},{av:'AV37SDTInformacionDelPacienteFamiliars',fld:'vSDTINFORMACIONDELPACIENTEFAMILIARS',grid:146,pic:''},{av:'nRC_GXsfl_146',ctrl:'DETALLEPACIENTEFAMILIAR',prop:'GridRC',grid:146},{av:'AV34SDTInformacionDeLaCitas',fld:'vSDTINFORMACIONDELACITAS',grid:16,pic:'',hsh:true},{av:'nRC_GXsfl_16',ctrl:'DETALLECITA',prop:'GridRC',grid:16},{av:'AV38SDTInformacionDelPacientes',fld:'vSDTINFORMACIONDELPACIENTES',grid:98,pic:'',hsh:true},{av:'nRC_GXsfl_98',ctrl:'DETALLEPACIENTE',prop:'GridRC',grid:98},{av:'AV35SDTInformacionDelPacienteFacturacionBs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONBS',grid:235,pic:'',hsh:true},{av:'nRC_GXsfl_235',ctrl:'GRIDBOLETA',prop:'GridRC',grid:235},{av:'AV36SDTInformacionDelPacienteFacturacionFs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONFS',grid:276,pic:'',hsh:true},{av:'nRC_GXsfl_276',ctrl:'GRIDFACTURA',prop:'GridRC',grid:276},{av:'AV29PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV14DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("GRIDFACTURA.LOAD","{handler:'e21703',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("GRIDFACTURA.LOAD",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("GRIDBOLETA.LOAD","{handler:'e20704',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("GRIDBOLETA.LOAD",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("DETALLEPACIENTE.LOAD","{handler:'e19705',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("DETALLEPACIENTE.LOAD",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("DETALLEPACIENTEFAMILIAR.LOAD","{handler:'e18706',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("DETALLEPACIENTEFAMILIAR.LOAD",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("DETALLECITA.LOAD","{handler:'e17702',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("DETALLECITA.LOAD",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'WIZARDNEXT'","{handler:'e12702',iparms:[{av:'Gxuitabspanel_steps_Activepage',ctrl:'GXUITABSPANEL_STEPS',prop:'ActivePage'},{av:'AV10CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'cmbavCitafamiliar'},{av:'AV12CitaFamiliar',fld:'vCITAFAMILIAR',pic:''},{av:'AV38SDTInformacionDelPacientes',fld:'vSDTINFORMACIONDELPACIENTES',grid:98,pic:'',hsh:true},{av:'DETALLEPACIENTE_nFirstRecordOnPage'},{av:'nRC_GXsfl_98',ctrl:'DETALLEPACIENTE',prop:'GridRC',grid:98},{av:'AV37SDTInformacionDelPacienteFamiliars',fld:'vSDTINFORMACIONDELPACIENTEFAMILIARS',grid:146,pic:''},{av:'DETALLEPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_146',ctrl:'DETALLEPACIENTEFAMILIAR',prop:'GridRC',grid:146},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'WIZARDNEXT'",",oparms:[{ctrl:'BTNENTER',prop:'Caption'},{av:'AV10CheckRequiredFieldsResult',fld:'vCHECKREQUIREDFIELDSRESULT',pic:''},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("'WIZARDPREVIOUS'","{handler:'e11701',iparms:[{av:'Gxuitabspanel_steps_Activepage',ctrl:'GXUITABSPANEL_STEPS',prop:'ActivePage'},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("'WIZARDPREVIOUS'",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VSELECCIONARFAMILIAR.CONTROLVALUECHANGED","{handler:'e13702',iparms:[{av:'AV29PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavSeleccionarfamiliar'},{av:'AV44SeleccionarFamiliar',fld:'vSELECCIONARFAMILIAR',pic:'ZZZ9'},{av:'AV37SDTInformacionDelPacienteFamiliars',fld:'vSDTINFORMACIONDELPACIENTEFAMILIARS',grid:146,pic:''},{av:'DETALLEPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_146',ctrl:'DETALLEPACIENTEFAMILIAR',prop:'GridRC',grid:146},{av:'DETALLECITA_nFirstRecordOnPage'},{av:'DETALLECITA_nEOF'},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'GRIDFACTURA_nEOF'},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'GRIDBOLETA_nEOF'},{av:'DETALLEPACIENTE_nFirstRecordOnPage'},{av:'DETALLEPACIENTE_nEOF'},{av:'DETALLEPACIENTEFAMILIAR_nEOF'},{av:'AV34SDTInformacionDeLaCitas',fld:'vSDTINFORMACIONDELACITAS',grid:16,pic:'',hsh:true},{av:'nRC_GXsfl_16',ctrl:'DETALLECITA',prop:'GridRC',grid:16},{av:'AV38SDTInformacionDelPacientes',fld:'vSDTINFORMACIONDELPACIENTES',grid:98,pic:'',hsh:true},{av:'nRC_GXsfl_98',ctrl:'DETALLEPACIENTE',prop:'GridRC',grid:98},{av:'AV35SDTInformacionDelPacienteFacturacionBs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONBS',grid:235,pic:'',hsh:true},{av:'nRC_GXsfl_235',ctrl:'GRIDBOLETA',prop:'GridRC',grid:235},{av:'AV36SDTInformacionDelPacienteFacturacionFs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONFS',grid:276,pic:'',hsh:true},{av:'nRC_GXsfl_276',ctrl:'GRIDFACTURA',prop:'GridRC',grid:276},{av:'AV14DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VSELECCIONARFAMILIAR.CONTROLVALUECHANGED",",oparms:[{av:'AV37SDTInformacionDelPacienteFamiliars',fld:'vSDTINFORMACIONDELPACIENTEFAMILIARS',grid:146,pic:''},{av:'DETALLEPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_146',ctrl:'DETALLEPACIENTEFAMILIAR',prop:'GridRC',grid:146},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("GLOBALEVENTS.OPENFORMNIUBIZ","{handler:'e14702',iparms:[{av:'AV35SDTInformacionDelPacienteFacturacionBs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONBS',grid:235,pic:'',hsh:true},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'nRC_GXsfl_235',ctrl:'GRIDBOLETA',prop:'GridRC',grid:235},{av:'AV36SDTInformacionDelPacienteFacturacionFs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONFS',grid:276,pic:'',hsh:true},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'nRC_GXsfl_276',ctrl:'GRIDFACTURA',prop:'GridRC',grid:276},{av:'AV41SDTResponseTokenSession200',fld:'vSDTRESPONSETOKENSESSION200',pic:''},{av:'AV33purchaseNumber',fld:'vPURCHASENUMBER',pic:''},{av:'AV34SDTInformacionDeLaCitas',fld:'vSDTINFORMACIONDELACITAS',grid:16,pic:'',hsh:true},{av:'DETALLECITA_nFirstRecordOnPage'},{av:'nRC_GXsfl_16',ctrl:'DETALLECITA',prop:'GridRC',grid:16},{av:'AV14DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("GLOBALEVENTS.OPENFORMNIUBIZ",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("ENTER","{handler:'e15702',iparms:[{av:'AV34SDTInformacionDeLaCitas',fld:'vSDTINFORMACIONDELACITAS',grid:16,pic:'',hsh:true},{av:'DETALLECITA_nFirstRecordOnPage'},{av:'nRC_GXsfl_16',ctrl:'DETALLECITA',prop:'GridRC',grid:16},{av:'AV29PacienteId',fld:'vPACIENTEID',pic:'ZZZZZZZ9',hsh:true},{av:'AV40SDTRequestTokenSession',fld:'vSDTREQUESTTOKENSESSION',pic:''},{av:'AV14DisponibilidadId',fld:'vDISPONIBILIDADID',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavCitafamiliar'},{av:'AV12CitaFamiliar',fld:'vCITAFAMILIAR',pic:''},{av:'cmbavSeleccionarfamiliar'},{av:'AV44SeleccionarFamiliar',fld:'vSELECCIONARFAMILIAR',pic:'ZZZ9'},{av:'AV5Cita',fld:'vCITA',pic:''},{av:'AV37SDTInformacionDelPacienteFamiliars',fld:'vSDTINFORMACIONDELPACIENTEFAMILIARS',grid:146,pic:''},{av:'DETALLEPACIENTEFAMILIAR_nFirstRecordOnPage'},{av:'nRC_GXsfl_146',ctrl:'DETALLEPACIENTEFAMILIAR',prop:'GridRC',grid:146},{av:'AV38SDTInformacionDelPacientes',fld:'vSDTINFORMACIONDELPACIENTES',grid:98,pic:'',hsh:true},{av:'DETALLEPACIENTE_nFirstRecordOnPage'},{av:'nRC_GXsfl_98',ctrl:'DETALLEPACIENTE',prop:'GridRC',grid:98},{av:'AV52UploadedFiles',fld:'vUPLOADEDFILES',pic:''},{av:'AV32Pago',fld:'vPAGO',pic:''},{av:'AV35SDTInformacionDelPacienteFacturacionBs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONBS',grid:235,pic:'',hsh:true},{av:'GRIDBOLETA_nFirstRecordOnPage'},{av:'nRC_GXsfl_235',ctrl:'GRIDBOLETA',prop:'GridRC',grid:235},{av:'Gx_date',fld:'vTODAY',pic:'',hsh:true},{av:'AV36SDTInformacionDelPacienteFacturacionFs',fld:'vSDTINFORMACIONDELPACIENTEFACTURACIONFS',grid:276,pic:'',hsh:true},{av:'GRIDFACTURA_nFirstRecordOnPage'},{av:'nRC_GXsfl_276',ctrl:'GRIDFACTURA',prop:'GridRC',grid:276},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV41SDTResponseTokenSession200',fld:'vSDTRESPONSETOKENSESSION200',pic:''},{av:'AV40SDTRequestTokenSession',fld:'vSDTREQUESTTOKENSESSION',pic:''},{av:'AV33purchaseNumber',fld:'vPURCHASENUMBER',pic:''},{av:'AV5Cita',fld:'vCITA',pic:''},{av:'AV32Pago',fld:'vPAGO',pic:''},{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV7","{handler:'validv_Gxv7',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV7",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv11',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV19","{handler:'validv_Gxv19',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV19",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv22',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv33',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV37","{handler:'validv_Gxv37',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV37",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV39","{handler:'validv_Gxv39',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV39",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv41',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV43","{handler:'validv_Gxv43',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV43",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("VALIDV_GXV46","{handler:'validv_Gxv46',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("VALIDV_GXV46",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv47',iparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV8Boleta',fld:'vBOLETA',pic:''},{av:'AV16Factura',fld:'vFACTURA',pic:''},{av:'AV49TerminosCondiciones',fld:'vTERMINOSCONDICIONES',pic:''}]}");
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
      AV41SDTResponseTokenSession200 = new com.projectthani.SdtSDTResponseTokenSession200(remoteHandle, context);
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV8Boleta = false ;
      AV16Factura = false ;
      AV34SDTInformacionDeLaCitas = new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>(com.projectthani.SdtSDTInformacionDeLaCita.class, "SDTInformacionDeLaCita", "ProjectThani", remoteHandle);
      AV38SDTInformacionDelPacientes = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>(com.projectthani.SdtSDTInformacionDelPaciente.class, "SDTInformacionDelPaciente", "ProjectThani", remoteHandle);
      AV35SDTInformacionDelPacienteFacturacionBs = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionB.class, "SDTInformacionDelPacienteFacturacionB", "ProjectThani", remoteHandle);
      AV36SDTInformacionDelPacienteFacturacionFs = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionF.class, "SDTInformacionDelPacienteFacturacionF", "ProjectThani", remoteHandle);
      Gx_date = GXutil.nullDate() ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV37SDTInformacionDelPacienteFamiliars = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar>(com.projectthani.SdtSDTInformacionDelPacienteFamiliar.class, "SDTInformacionDelPacienteFamiliar", "ProjectThani", remoteHandle);
      AV52UploadedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV53FailedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV33purchaseNumber = "" ;
      AV40SDTRequestTokenSession = new com.projectthani.SdtSDTRequestTokenSession(remoteHandle, context);
      AV5Cita = new com.projectthani.SdtCita(remoteHandle);
      AV32Pago = new com.projectthani.SdtPago(remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblTbtituloinfocita_Jsonclick = "" ;
      DetallecitaContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subDetallecita_Header = "" ;
      DetallecitaColumn = new com.genexus.webpanels.GXWebColumn();
      lblTitle2_Jsonclick = "" ;
      ucGxuitabspanel_steps = new com.genexus.webpanels.GXUserControl();
      lblTabgeneral_title_Jsonclick = "" ;
      TempTags = "" ;
      AV12CitaFamiliar = "" ;
      DetallepacienteContainer = new com.genexus.webpanels.GXWebGrid(context);
      subDetallepaciente_Header = "" ;
      DetallepacienteColumn = new com.genexus.webpanels.GXWebColumn();
      DetallepacientefamiliarContainer = new com.genexus.webpanels.GXWebGrid(context);
      subDetallepacientefamiliar_Header = "" ;
      DetallepacientefamiliarColumn = new com.genexus.webpanels.GXWebColumn();
      lblTaparchivos_title_Jsonclick = "" ;
      lblTbinfoarchivo_Jsonclick = "" ;
      ucUcsubirarchivo = new com.genexus.webpanels.GXUserControl();
      lblTapfacturacion_title_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      lblTaprealizarpago1_title_Jsonclick = "" ;
      bttBtnwizardprevious_Jsonclick = "" ;
      bttBtncancel_Jsonclick = "" ;
      bttBtnwizardnext_Jsonclick = "" ;
      bttBtnenter_Jsonclick = "" ;
      ucUcmensaje = new com.genexus.webpanels.GXUserControl();
      ucWizard_steps = new com.genexus.webpanels.GXUserControl();
      GridboletaContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridfacturaContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV51WebSession = httpContext.getWebSession();
      GXt_objcol_SdtSDTInformacionDeLaCita1 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita>(com.projectthani.SdtSDTInformacionDeLaCita.class, "SDTInformacionDeLaCita", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDeLaCita2 = new GXBaseCollection[1] ;
      GXt_objcol_SdtSDTInformacionDelPaciente3 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente>(com.projectthani.SdtSDTInformacionDelPaciente.class, "SDTInformacionDelPaciente", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDelPaciente4 = new GXBaseCollection[1] ;
      AV28ListFamiliar = new GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox>(com.projectthani.SdtSDTListadoPacienteFamiliarComboBox.class, "SDTListadoPacienteFamiliarComboBox", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5 = new GXBaseCollection[1] ;
      AV17FamiliarList = new com.projectthani.SdtSDTListadoPacienteFamiliarComboBox(remoteHandle, context);
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionB.class, "SDTInformacionDelPacienteFacturacionB", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7 = new GXBaseCollection[1] ;
      GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 = new GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF>(com.projectthani.SdtSDTInformacionDelPacienteFacturacionF.class, "SDTInformacionDelPacienteFacturacionF", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9 = new GXBaseCollection[1] ;
      DetallecitaRow = new com.genexus.webpanels.GXWebRow();
      GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10 = new GXBaseCollection[1] ;
      AV107Dato1 = "" ;
      AV108Dato2 = "" ;
      AV109Correo = "" ;
      AV6accessToken = "" ;
      AV15ErrorMessage = "" ;
      AV13clientIp = "" ;
      AV50tokenSession = "" ;
      GXv_char12 = new String[1] ;
      GXv_char11 = new String[1] ;
      GXv_int13 = new short[1] ;
      GXv_SdtSDTResponseTokenSession20014 = new com.projectthani.SdtSDTResponseTokenSession200[1] ;
      AV42SDTResponseTokenSession400 = new com.projectthani.SdtSDTResponseTokenSession400(remoteHandle, context);
      GXv_SdtSDTResponseTokenSession40015 = new com.projectthani.SdtSDTResponseTokenSession400[1] ;
      AV47temp = "" ;
      GXt_char17 = "" ;
      GXv_char16 = new String[1] ;
      GridfacturaRow = new com.genexus.webpanels.GXWebRow();
      GridboletaRow = new com.genexus.webpanels.GXWebRow();
      DetallepacienteRow = new com.genexus.webpanels.GXWebRow();
      DetallepacientefamiliarRow = new com.genexus.webpanels.GXWebRow();
      subGridfactura_Header = "" ;
      GridfacturaColumn = new com.genexus.webpanels.GXWebColumn();
      subGridboleta_Header = "" ;
      GridboletaColumn = new com.genexus.webpanels.GXWebColumn();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subDetallecita_Linesclass = "" ;
      sImgUrl = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      subDetallepaciente_Linesclass = "" ;
      subDetallepacientefamiliar_Linesclass = "" ;
      subGridboleta_Linesclass = "" ;
      subGridfactura_Linesclass = "" ;
      Gx_date = GXutil.today( ) ;
      /* GeneXus formulas. */
      Gx_date = GXutil.today( ) ;
      Gx_err = (short)(0) ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled = 0 ;
      cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta.setEnabled( 0 );
      edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled = 0 ;
      edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled = 0 ;
      edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__nombres_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled = 0 ;
      edtavSdtinformaciondelpacientefamiliars__sexo_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subDetallecita_Backcolorstyle ;
   private byte subDetallecita_Allowselection ;
   private byte subDetallecita_Allowhovering ;
   private byte subDetallecita_Allowcollapsing ;
   private byte subDetallecita_Collapsed ;
   private byte subDetallepaciente_Backcolorstyle ;
   private byte subDetallepaciente_Allowselection ;
   private byte subDetallepaciente_Allowhovering ;
   private byte subDetallepaciente_Allowcollapsing ;
   private byte subDetallepaciente_Collapsed ;
   private byte subDetallepacientefamiliar_Backcolorstyle ;
   private byte subDetallepacientefamiliar_Allowselection ;
   private byte subDetallepacientefamiliar_Allowhovering ;
   private byte subDetallepacientefamiliar_Allowcollapsing ;
   private byte subDetallepacientefamiliar_Collapsed ;
   private byte nDonePA ;
   private byte subGridfactura_Backcolorstyle ;
   private byte subGridboleta_Backcolorstyle ;
   private byte DETALLECITA_nEOF ;
   private byte GRIDFACTURA_nEOF ;
   private byte GRIDBOLETA_nEOF ;
   private byte DETALLEPACIENTE_nEOF ;
   private byte DETALLEPACIENTEFAMILIAR_nEOF ;
   private byte subGridfactura_Allowselection ;
   private byte subGridfactura_Allowhovering ;
   private byte subGridfactura_Allowcollapsing ;
   private byte subGridfactura_Collapsed ;
   private byte subGridboleta_Allowselection ;
   private byte subGridboleta_Allowhovering ;
   private byte subGridboleta_Allowcollapsing ;
   private byte subGridboleta_Collapsed ;
   private byte nGXWrapped ;
   private byte subDetallecita_Backstyle ;
   private byte subDetallepaciente_Backstyle ;
   private byte subDetallepacientefamiliar_Backstyle ;
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
   private short AV46TabsActivePage ;
   private short wbEnd ;
   private short wbStart ;
   private short AV44SeleccionarFamiliar ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV23HttpStatus ;
   private short GXv_int13[] ;
   private int wcpOAV14DisponibilidadId ;
   private int Gxuitabspanel_steps_Activepage ;
   private int nRC_GXsfl_16 ;
   private int nRC_GXsfl_98 ;
   private int nRC_GXsfl_146 ;
   private int nRC_GXsfl_235 ;
   private int nRC_GXsfl_276 ;
   private int nGXsfl_16_idx=1 ;
   private int AV29PacienteId ;
   private int AV14DisponibilidadId ;
   private int Ucsubirarchivo_Maxnumberoffiles ;
   private int Gxuitabspanel_steps_Pagecount ;
   private int nGXsfl_98_idx=1 ;
   private int nGXsfl_146_idx=1 ;
   private int nGXsfl_235_idx=1 ;
   private int nGXsfl_276_idx=1 ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Enabled ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Enabled ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Enabled ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Enabled ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Enabled ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Enabled ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Enabled ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Visible ;
   private int subDetallecita_Selectedindex ;
   private int subDetallecita_Selectioncolor ;
   private int subDetallecita_Hoveringcolor ;
   private int AV59GXV1 ;
   private int subDetallepaciente_Visible ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Enabled ;
   private int subDetallepaciente_Selectedindex ;
   private int subDetallepaciente_Selectioncolor ;
   private int subDetallepaciente_Hoveringcolor ;
   private int AV70GXV12 ;
   private int subDetallepacientefamiliar_Visible ;
   private int edtavSdtinformaciondelpacientefamiliars__nombres_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__tipodocumento_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__nrodocumento_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__sexo_Enabled ;
   private int subDetallepacientefamiliar_Selectedindex ;
   private int subDetallepacientefamiliar_Selectioncolor ;
   private int subDetallepacientefamiliar_Hoveringcolor ;
   private int AV81GXV23 ;
   private int divSeccionboleta_Visible ;
   private int divSeccionfactura_Visible ;
   private int bttBtnwizardprevious_Visible ;
   private int bttBtncancel_Visible ;
   private int bttBtnwizardnext_Visible ;
   private int bttBtnenter_Visible ;
   private int AV92GXV34 ;
   private int AV100GXV42 ;
   private int subDetallecita_Islastpage ;
   private int subGridfactura_Islastpage ;
   private int subGridboleta_Islastpage ;
   private int subDetallepaciente_Islastpage ;
   private int subDetallepacientefamiliar_Islastpage ;
   private int nGXsfl_16_fel_idx=1 ;
   private int nGXsfl_98_fel_idx=1 ;
   private int nGXsfl_146_fel_idx=1 ;
   private int nGXsfl_235_fel_idx=1 ;
   private int nGXsfl_276_fel_idx=1 ;
   private int AV106GXV48 ;
   private int nGXsfl_146_bak_idx=1 ;
   private int subGridfactura_Selectedindex ;
   private int subGridfactura_Selectioncolor ;
   private int subGridfactura_Hoveringcolor ;
   private int subGridboleta_Selectedindex ;
   private int subGridboleta_Selectioncolor ;
   private int subGridboleta_Hoveringcolor ;
   private int idxLst ;
   private int subDetallecita_Backcolor ;
   private int subDetallecita_Allbackcolor ;
   private int edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Enabled ;
   private int subDetallepaciente_Backcolor ;
   private int subDetallepaciente_Allbackcolor ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Visible ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Visible ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Enabled ;
   private int edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Visible ;
   private int subDetallepacientefamiliar_Backcolor ;
   private int subDetallepacientefamiliar_Allbackcolor ;
   private int edtavSdtinformaciondelpacientefamiliars__peso_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__peso_Visible ;
   private int edtavSdtinformaciondelpacientefamiliars__estatura_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__estatura_Visible ;
   private int edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Enabled ;
   private int edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Visible ;
   private int subGridboleta_Backcolor ;
   private int subGridboleta_Allbackcolor ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Visible ;
   private int subGridfactura_Backcolor ;
   private int subGridfactura_Allbackcolor ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Visible ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Enabled ;
   private int edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Visible ;
   private long DETALLECITA_nCurrentRecord ;
   private long DETALLEPACIENTE_nCurrentRecord ;
   private long DETALLEPACIENTEFAMILIAR_nCurrentRecord ;
   private long GRIDBOLETA_nCurrentRecord ;
   private long GRIDFACTURA_nCurrentRecord ;
   private long DETALLECITA_nFirstRecordOnPage ;
   private long GRIDFACTURA_nFirstRecordOnPage ;
   private long GRIDBOLETA_nFirstRecordOnPage ;
   private long DETALLEPACIENTE_nFirstRecordOnPage ;
   private long DETALLEPACIENTEFAMILIAR_nFirstRecordOnPage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_16_idx="0001" ;
   private String Ucsubirarchivo_Class ;
   private String Gxuitabspanel_steps_Class ;
   private String Ucmensaje_Stylingtype ;
   private String Wizard_steps_Tabsinternalname ;
   private String sGXsfl_98_idx="0001" ;
   private String sGXsfl_146_idx="0001" ;
   private String sGXsfl_235_idx="0001" ;
   private String sGXsfl_276_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String divTablecita_Internalname ;
   private String divSecciontitle_Internalname ;
   private String lblTbtituloinfocita_Internalname ;
   private String lblTbtituloinfocita_Jsonclick ;
   private String sStyleString ;
   private String subDetallecita_Internalname ;
   private String subDetallecita_Header ;
   private String divTablepaciente_Internalname ;
   private String divSecciontitulo2_Internalname ;
   private String lblTitle2_Internalname ;
   private String lblTitle2_Jsonclick ;
   private String Gxuitabspanel_steps_Internalname ;
   private String lblTabgeneral_title_Internalname ;
   private String lblTabgeneral_title_Jsonclick ;
   private String divTableattributes_Internalname ;
   private String divTableseleccionarcita_Internalname ;
   private String TempTags ;
   private String AV12CitaFamiliar ;
   private String subDetallepaciente_Internalname ;
   private String subDetallepaciente_Header ;
   private String subDetallepacientefamiliar_Internalname ;
   private String subDetallepacientefamiliar_Header ;
   private String lblTaparchivos_title_Internalname ;
   private String lblTaparchivos_title_Jsonclick ;
   private String divUnnamedtable6_Internalname ;
   private String divSecciontitle2_Internalname ;
   private String divSec2_Internalname ;
   private String divSecciontitlearchivo_Internalname ;
   private String lblTbinfoarchivo_Internalname ;
   private String lblTbinfoarchivo_Jsonclick ;
   private String grpUnnamedgroup8_Internalname ;
   private String divUnnamedtable7_Internalname ;
   private String Ucsubirarchivo_Tooltiptext ;
   private String Ucsubirarchivo_Internalname ;
   private String lblTapfacturacion_title_Internalname ;
   private String lblTapfacturacion_title_Jsonclick ;
   private String divUnnamedtable2_Internalname ;
   private String divSecfacturacion_Internalname ;
   private String grpUnnamedgroup3_Internalname ;
   private String divGruptc_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divSeccionboleta_Internalname ;
   private String grpUnnamedgroup5_Internalname ;
   private String divSeccionfactura_Internalname ;
   private String grpUnnamedgroup4_Internalname ;
   private String lblTaprealizarpago1_title_Internalname ;
   private String lblTaprealizarpago1_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String bttBtnwizardprevious_Internalname ;
   private String bttBtnwizardprevious_Jsonclick ;
   private String bttBtncancel_Internalname ;
   private String bttBtncancel_Jsonclick ;
   private String bttBtnwizardnext_Internalname ;
   private String bttBtnwizardnext_Jsonclick ;
   private String bttBtnenter_Internalname ;
   private String bttBtnenter_Caption ;
   private String bttBtnenter_Jsonclick ;
   private String Ucmensaje_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Wizard_steps_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitanombresdoctor_Internalname ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Internalname ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitaclinica_Internalname ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitasede_Internalname ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Internalname ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Internalname ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteapellidos_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__nombres_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__tipodocumento_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__nrodocumento_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__sexo_Internalname ;
   private String sGXsfl_16_fel_idx="0001" ;
   private String sGXsfl_98_fel_idx="0001" ;
   private String sGXsfl_146_fel_idx="0001" ;
   private String sGXsfl_235_fel_idx="0001" ;
   private String sGXsfl_276_fel_idx="0001" ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Internalname ;
   private String GXv_char12[] ;
   private String GXv_char11[] ;
   private String GXt_char17 ;
   private String GXv_char16[] ;
   private String tblGrupdc_Internalname ;
   private String divTablefactura_Internalname ;
   private String subGridfactura_Internalname ;
   private String subGridfactura_Header ;
   private String tblGrupdp_Internalname ;
   private String divTableboleta_Internalname ;
   private String subGridboleta_Internalname ;
   private String subGridboleta_Header ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitafotografiadoctor_Internalname ;
   private String subDetallecita_Class ;
   private String subDetallecita_Linesclass ;
   private String divUnnamedtablefsdetallecita_Internalname ;
   private String sImgUrl ;
   private String ROClassString ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitaespecialidaddoctor_Jsonclick ;
   private String GXCCtl ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitafecha_Jsonclick ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitahora_Jsonclick ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitacosto_Jsonclick ;
   private String tblUnnamedtablecontentfsdetallecita_Internalname ;
   private String edtavSdtinformaciondelacitas__sdtinformaciondelacitaid_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientemotivoconsulta_Internalname ;
   private String subDetallepaciente_Class ;
   private String subDetallepaciente_Linesclass ;
   private String divUnnamedtablefsdetallepaciente_Internalname ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenombres_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientetipodocumento_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientenrodocumento_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientefechanacimiento_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientesexo_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteemail_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacientepeso_Jsonclick ;
   private String edtavSdtinformaciondelpacientes__sdtinformaciondelpacienteestatura_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__peso_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__estatura_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__motivoconsulta_Internalname ;
   private String subDetallepacientefamiliar_Class ;
   private String subDetallepacientefamiliar_Linesclass ;
   private String divUnnamedtablefsdetallepacientefamiliar_Internalname ;
   private String edtavSdtinformaciondelpacientefamiliars__nombres_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__apellidopaterno_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__apellidomaterno_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__tipodocumento_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__nrodocumento_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__fechanacimiento_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__sexo_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__peso_Jsonclick ;
   private String edtavSdtinformaciondelpacientefamiliars__estatura_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Internalname ;
   private String subGridboleta_Class ;
   private String subGridboleta_Linesclass ;
   private String divUnnamedtablefsgridboleta_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnombres_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbapellidos_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbnrodocumento_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbemail_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtelefono_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbdireccion_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Internalname ;
   private String subGridfactura_Class ;
   private String subGridfactura_Linesclass ;
   private String divUnnamedtablefsgridfactura_Internalname ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfnrodocumento_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfrazonsocial_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfemail_Jsonclick ;
   private String edtavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionfdireccion_Jsonclick ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8Boleta ;
   private boolean AV16Factura ;
   private boolean AV49TerminosCondiciones ;
   private boolean Ucsubirarchivo_Autoupload ;
   private boolean Gxuitabspanel_steps_Historymanagement ;
   private boolean AV10CheckRequiredFieldsResult ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_16_Refreshing=false ;
   private boolean bGXsfl_98_Refreshing=false ;
   private boolean bGXsfl_146_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_276_Refreshing=false ;
   private boolean bGXsfl_235_Refreshing=false ;
   private boolean returnInSub ;
   private boolean gx_BV16 ;
   private boolean gx_BV98 ;
   private boolean gx_BV235 ;
   private boolean gx_BV276 ;
   private boolean gx_BV146 ;
   private boolean AV20hasErrors ;
   private String AV47temp ;
   private String AV33purchaseNumber ;
   private String AV107Dato1 ;
   private String AV108Dato2 ;
   private String AV109Correo ;
   private String AV6accessToken ;
   private String AV15ErrorMessage ;
   private String AV13clientIp ;
   private String AV50tokenSession ;
   private com.genexus.webpanels.GXWebGrid DetallecitaContainer ;
   private com.genexus.webpanels.GXWebGrid DetallepacienteContainer ;
   private com.genexus.webpanels.GXWebGrid DetallepacientefamiliarContainer ;
   private com.genexus.webpanels.GXWebGrid GridboletaContainer ;
   private com.genexus.webpanels.GXWebGrid GridfacturaContainer ;
   private com.genexus.webpanels.GXWebRow DetallecitaRow ;
   private com.genexus.webpanels.GXWebRow GridfacturaRow ;
   private com.genexus.webpanels.GXWebRow GridboletaRow ;
   private com.genexus.webpanels.GXWebRow DetallepacienteRow ;
   private com.genexus.webpanels.GXWebRow DetallepacientefamiliarRow ;
   private com.genexus.webpanels.GXWebColumn DetallecitaColumn ;
   private com.genexus.webpanels.GXWebColumn DetallepacienteColumn ;
   private com.genexus.webpanels.GXWebColumn DetallepacientefamiliarColumn ;
   private com.genexus.webpanels.GXWebColumn GridfacturaColumn ;
   private com.genexus.webpanels.GXWebColumn GridboletaColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV51WebSession ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_steps ;
   private com.genexus.webpanels.GXUserControl ucUcsubirarchivo ;
   private com.genexus.webpanels.GXUserControl ucUcmensaje ;
   private com.genexus.webpanels.GXUserControl ucWizard_steps ;
   private com.projectthani.SdtSDTResponseTokenSession200 AV41SDTResponseTokenSession200 ;
   private HTMLChoice cmbavSdtinformaciondelacitas__sdtinformaciondelacitatipoconsulta ;
   private HTMLChoice cmbavCitafamiliar ;
   private HTMLChoice cmbavSeleccionarfamiliar ;
   private ICheckbox chkavBoleta ;
   private ICheckbox chkavFactura ;
   private HTMLChoice cmbavSdtinformaciondelpacientefacturacionbs__sdtinformaciondelpacientefacturacionbtipodocumento ;
   private HTMLChoice cmbavSdtinformaciondelpacientefacturacionfs__sdtinformaciondelpacientefacturacionftipodocumento ;
   private ICheckbox chkavTerminoscondiciones ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> AV28ListFamiliar ;
   private GXBaseCollection<com.projectthani.SdtSDTListadoPacienteFamiliarComboBox> GXv_objcol_SdtSDTListadoPacienteFamiliarComboBox5[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> AV37SDTInformacionDelPacienteFamiliars ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFamiliar> GXv_objcol_SdtSDTInformacionDelPacienteFamiliar10[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> AV34SDTInformacionDeLaCitas ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> GXt_objcol_SdtSDTInformacionDeLaCita1 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDeLaCita> GXv_objcol_SdtSDTInformacionDeLaCita2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> AV35SDTInformacionDelPacienteFacturacionBs ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> GXt_objcol_SdtSDTInformacionDelPacienteFacturacionB6 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionB> GXv_objcol_SdtSDTInformacionDelPacienteFacturacionB7[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> AV36SDTInformacionDelPacienteFacturacionFs ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> GXt_objcol_SdtSDTInformacionDelPacienteFacturacionF8 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPacienteFacturacionF> GXv_objcol_SdtSDTInformacionDelPacienteFacturacionF9[] ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> AV38SDTInformacionDelPacientes ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> GXt_objcol_SdtSDTInformacionDelPaciente3 ;
   private GXBaseCollection<com.projectthani.SdtSDTInformacionDelPaciente> GXv_objcol_SdtSDTInformacionDelPaciente4[] ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV52UploadedFiles ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV53FailedFiles ;
   private com.projectthani.SdtCita AV5Cita ;
   private com.projectthani.SdtSDTListadoPacienteFamiliarComboBox AV17FamiliarList ;
   private com.projectthani.SdtPago AV32Pago ;
   private com.projectthani.SdtSDTRequestTokenSession AV40SDTRequestTokenSession ;
   private com.projectthani.SdtSDTResponseTokenSession200 GXv_SdtSDTResponseTokenSession20014[] ;
   private com.projectthani.SdtSDTResponseTokenSession400 AV42SDTResponseTokenSession400 ;
   private com.projectthani.SdtSDTResponseTokenSession400 GXv_SdtSDTResponseTokenSession40015[] ;
}

