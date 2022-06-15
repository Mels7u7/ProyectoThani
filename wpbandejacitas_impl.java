package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpbandejacitas_impl extends GXDataArea
{
   public wpbandejacitas_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpbandejacitas_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpbandejacitas_impl.class ));
   }

   public wpbandejacitas_impl( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavActionscita = new HTMLChoice();
      cmbCitaEstadoCita = new HTMLChoice();
      cmbCitaEstadoPago = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            nRC_GXsfl_29 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_29"))) ;
            nGXsfl_29_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_29_idx"))) ;
            sGXsfl_29_idx = httpContext.GetPar( "sGXsfl_29_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgrid_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
            AV23FilterFullText = httpContext.GetPar( "FilterFullText") ;
            AV120SecRoleId = (short)(GXutil.lval( httpContext.GetPar( "SecRoleId"))) ;
            AV5ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            AV67TFCitaId = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId"))) ;
            AV68TFCitaId_To = (int)(GXutil.lval( httpContext.GetPar( "TFCitaId_To"))) ;
            AV51TFCitaCode = httpContext.GetPar( "TFCitaCode") ;
            AV52TFCitaCode_Sel = httpContext.GetPar( "TFCitaCode_Sel") ;
            AV89TFPacienteNroDocumento = httpContext.GetPar( "TFPacienteNroDocumento") ;
            AV90TFPacienteNroDocumento_Sel = httpContext.GetPar( "TFPacienteNroDocumento_Sel") ;
            AV83TFPacienteApellidoPaterno = httpContext.GetPar( "TFPacienteApellidoPaterno") ;
            AV84TFPacienteApellidoPaterno_Sel = httpContext.GetPar( "TFPacienteApellidoPaterno_Sel") ;
            AV81TFPacienteApellidoMaterno = httpContext.GetPar( "TFPacienteApellidoMaterno") ;
            AV82TFPacienteApellidoMaterno_Sel = httpContext.GetPar( "TFPacienteApellidoMaterno_Sel") ;
            AV87TFPacienteNombres = httpContext.GetPar( "TFPacienteNombres") ;
            AV88TFPacienteNombres_Sel = httpContext.GetPar( "TFPacienteNombres_Sel") ;
            AV99TFSGCitaDisponibilidadFecha = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha")) ;
            AV100TFSGCitaDisponibilidadFecha_To = localUtil.parseDateParm( httpContext.GetPar( "TFSGCitaDisponibilidadFecha_To")) ;
            AV101TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraInicio"))) ;
            AV102TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraInicio_To"))) ;
            AV97TFSGCitaDisponibilidadEspecialidadNombre = httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadNombre") ;
            AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadEspecialidadNombre_Sel") ;
            AV113TFSGCitaDisponibilidadSedeNombre = httpContext.GetPar( "TFSGCitaDisponibilidadSedeNombre") ;
            AV114TFSGCitaDisponibilidadSedeNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadSedeNombre_Sel") ;
            AV93TFSGCitaDisponibilidadClinicaNombre = httpContext.GetPar( "TFSGCitaDisponibilidadClinicaNombre") ;
            AV94TFSGCitaDisponibilidadClinicaNombre_Sel = httpContext.GetPar( "TFSGCitaDisponibilidadClinicaNombre_Sel") ;
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV58TFCitaEstadoCita_Sels);
            httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV60TFCitaEstadoPago_Sels);
            AV123TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraFin"))) ;
            AV124TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.parseDTimeParm( httpContext.GetPar( "TFSGCitaDisponibilidadHoraFin_To"))) ;
            AV128TFCitaArchivoExtencion = httpContext.GetPar( "TFCitaArchivoExtencion") ;
            AV129TFCitaArchivoExtencion_Sel = httpContext.GetPar( "TFCitaArchivoExtencion_Sel") ;
            AV164Pgmname = httpContext.GetPar( "Pgmname") ;
            AV39OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
            AV41OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgrid_refresh( subGrid_Rows, AV23FilterFullText, AV120SecRoleId, AV5ProfesionalId, AV67TFCitaId, AV68TFCitaId_To, AV51TFCitaCode, AV52TFCitaCode_Sel, AV89TFPacienteNroDocumento, AV90TFPacienteNroDocumento_Sel, AV83TFPacienteApellidoPaterno, AV84TFPacienteApellidoPaterno_Sel, AV81TFPacienteApellidoMaterno, AV82TFPacienteApellidoMaterno_Sel, AV87TFPacienteNombres, AV88TFPacienteNombres_Sel, AV99TFSGCitaDisponibilidadFecha, AV100TFSGCitaDisponibilidadFecha_To, AV101TFSGCitaDisponibilidadHoraInicio, AV102TFSGCitaDisponibilidadHoraInicio_To, AV97TFSGCitaDisponibilidadEspecialidadNombre, AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV113TFSGCitaDisponibilidadSedeNombre, AV114TFSGCitaDisponibilidadSedeNombre_Sel, AV93TFSGCitaDisponibilidadClinicaNombre, AV94TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFCitaEstadoCita_Sels, AV60TFCitaEstadoPago_Sels, AV123TFSGCitaDisponibilidadHoraFin, AV124TFSGCitaDisponibilidadHoraFin_To, AV128TFCitaArchivoExtencion, AV129TFCitaArchivoExtencion_Sel, AV164Pgmname, AV39OrderedBy, AV41OrderedDsc) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
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

   public byte executeStartEvent( )
   {
      pa2P2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2P2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511033438", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
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
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpbandejacitas", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV164Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXH_vFILTERFULLTEXT", AV23FilterFullText);
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_29", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_29, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV24GridCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV25GridPageCount, (byte)(10), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV19DDO_TitleSettingsIcons);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO", localUtil.dtoc( AV15DDO_SGCitaDisponibilidadFechaAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO", localUtil.dtoc( AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO", localUtil.dtoc( AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID", GXutil.ltrim( localUtil.ntoc( AV67TFCitaId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAID_TO", GXutil.ltrim( localUtil.ntoc( AV68TFCitaId_To, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITACODE", AV51TFCitaCode);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITACODE_SEL", AV52TFCitaCode_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENRODOCUMENTO", AV89TFPacienteNroDocumento);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENRODOCUMENTO_SEL", AV90TFPacienteNroDocumento_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO", AV83TFPacienteApellidoPaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOPATERNO_SEL", AV84TFPacienteApellidoPaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO", AV81TFPacienteApellidoMaterno);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTEAPELLIDOMATERNO_SEL", AV82TFPacienteApellidoMaterno_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES", AV87TFPacienteNombres);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFPACIENTENOMBRES_SEL", AV88TFPacienteNombres_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA", localUtil.dtoc( AV99TFSGCitaDisponibilidadFecha, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADFECHA_TO", localUtil.dtoc( AV100TFSGCitaDisponibilidadFecha_To, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAINICIO", localUtil.ttoc( AV101TFSGCitaDisponibilidadHoraInicio, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAINICIO_TO", localUtil.ttoc( AV102TFSGCitaDisponibilidadHoraInicio_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE", AV97TFSGCitaDisponibilidadEspecialidadNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL", AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADSEDENOMBRE", AV113TFSGCitaDisponibilidadSedeNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL", AV114TFSGCitaDisponibilidadSedeNombre_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICANOMBRE", AV93TFSGCitaDisponibilidadClinicaNombre);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL", AV94TFSGCitaDisponibilidadClinicaNombre_Sel);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCITAESTADOCITA_SELS", AV58TFCitaEstadoCita_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCITAESTADOCITA_SELS", AV58TFCitaEstadoCita_Sels);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFCITAESTADOPAGO_SELS", AV60TFCitaEstadoPago_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFCITAESTADOPAGO_SELS", AV60TFCitaEstadoPago_Sels);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAFIN", localUtil.ttoc( AV123TFSGCitaDisponibilidadHoraFin, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFSGCITADISPONIBILIDADHORAFIN_TO", localUtil.ttoc( AV124TFSGCitaDisponibilidadHoraFin_To, 10, 8, 0, 0, "/", ":", " "));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAARCHIVOEXTENCION", AV128TFCitaArchivoExtencion);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vTFCITAARCHIVOEXTENCION_SEL", AV129TFCitaArchivoExtencion_Sel);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV164Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV164Pgmname, ""))));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV39OrderedBy, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV41OrderedDsc);
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vSECROLEID", GXutil.ltrim( localUtil.ntoc( AV120SecRoleId, (byte)(4), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV5ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE", localUtil.dtoc( AV13DDO_SGCitaDisponibilidadFechaAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE", localUtil.dtoc( AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE", localUtil.dtoc( AV125DDO_SGCitaDisponibilidadHoraFinAuxDate, 0, "/"));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Width", GXutil.rtrim( Dvpanel_tableheader_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autowidth", GXutil.booltostr( Dvpanel_tableheader_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoheight", GXutil.booltostr( Dvpanel_tableheader_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Cls", GXutil.rtrim( Dvpanel_tableheader_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Title", GXutil.rtrim( Dvpanel_tableheader_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsible", GXutil.booltostr( Dvpanel_tableheader_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Collapsed", GXutil.booltostr( Dvpanel_tableheader_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Showcollapseicon", GXutil.booltostr( Dvpanel_tableheader_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Iconposition", GXutil.rtrim( Dvpanel_tableheader_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEHEADER_Autoscroll", GXutil.booltostr( Dvpanel_tableheader_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Class", GXutil.rtrim( Gridpaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridpaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridpaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Shownext", GXutil.booltostr( Gridpaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Showlast", GXutil.booltostr( Gridpaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridpaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridpaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridpaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridpaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridpaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Previous", GXutil.rtrim( Gridpaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Next", GXutil.rtrim( Gridpaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Caption", GXutil.rtrim( Gridpaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridpaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridpaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridpaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridpaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
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
         we2P2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2P2( ) ;
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
      return formatLink("com.projectthani.wpbandejacitas", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPBandejaCitas" ;
   }

   public String getPgmdesc( )
   {
      return " Cita" ;
   }

   public void wb2P0( )
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_tableheader.setProperty("Width", Dvpanel_tableheader_Width);
         ucDvpanel_tableheader.setProperty("AutoWidth", Dvpanel_tableheader_Autowidth);
         ucDvpanel_tableheader.setProperty("AutoHeight", Dvpanel_tableheader_Autoheight);
         ucDvpanel_tableheader.setProperty("Cls", Dvpanel_tableheader_Cls);
         ucDvpanel_tableheader.setProperty("Title", Dvpanel_tableheader_Title);
         ucDvpanel_tableheader.setProperty("Collapsible", Dvpanel_tableheader_Collapsible);
         ucDvpanel_tableheader.setProperty("Collapsed", Dvpanel_tableheader_Collapsed);
         ucDvpanel_tableheader.setProperty("ShowCollapseIcon", Dvpanel_tableheader_Showcollapseicon);
         ucDvpanel_tableheader.setProperty("IconPosition", Dvpanel_tableheader_Iconposition);
         ucDvpanel_tableheader.setProperty("AutoScroll", Dvpanel_tableheader_Autoscroll);
         ucDvpanel_tableheader.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableheader_Internalname, "DVPANEL_TABLEHEADERContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEHEADERContainer"+"TableHeader"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTableheader_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "flex-wrap:wrap;", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         wb_table1_13_2P2( true) ;
      }
      else
      {
         wb_table1_13_2P2( false) ;
      }
      return  ;
   }

   public void wb_table1_13_2P2e( boolean wbgen )
   {
      if ( wbgen )
      {
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridtablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"29\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGrid_Backcolorstyle == 0 )
            {
               subGrid_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
            else
            {
               subGrid_Titlebackstyle = (byte)(1) ;
               if ( subGrid_Backcolorstyle == 1 )
               {
                  subGrid_Titlebackcolor = subGrid_Allbackcolor ;
                  if ( GXutil.len( subGrid_Class) > 0 )
                  {
                     subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGrid_Class) > 0 )
                  {
                     subGrid_Linesclass = subGrid_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ConvertToDDO"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Codigo Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Nro Doc.") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Ap. Paterno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Ap. Materno") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Paciente Nombres") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hora Inicio") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Sede") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Clinica") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado Cita") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Estado Pago") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hora Fin") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Archivo Extencion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridContainer.AddObjectProperty("GridName", "Grid");
         }
         else
         {
            if ( isAjaxCallMode( ) )
            {
               GridContainer = new com.genexus.webpanels.GXWebGrid(context);
            }
            else
            {
               GridContainer.Clear();
            }
            GridContainer.SetWrapped(nGXWrapped);
            GridContainer.AddObjectProperty("GridName", "Grid");
            GridContainer.AddObjectProperty("Header", subGrid_Header);
            GridContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("CmpContext", "");
            GridContainer.AddObjectProperty("InMasterPage", "false");
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV6ActionsCita, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ".", "")));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A64CitaCode);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A106PacienteNroDocumento);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A103PacienteApellidoPaterno);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A104PacienteApellidoMaterno);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A105PacienteNombres);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A146SGCitaDisponibilidadEspecialidadNombre);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A73SGCitaDisponibilidadSedeNombre);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A78SGCitaDisponibilidadClinicaNombre);
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A89CitaEstadoCita));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", GXutil.rtrim( A102CitaEstadoPago));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "));
            GridContainer.AddColumnProperties(GridColumn);
            GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridColumn.AddObjectProperty("Value", A333CitaArchivoExtencion);
            GridContainer.AddColumnProperties(GridColumn);
            GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 29 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_29 = (int)(nGXsfl_29_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridpaginationbar.setProperty("Class", Gridpaginationbar_Class);
         ucGridpaginationbar.setProperty("ShowFirst", Gridpaginationbar_Showfirst);
         ucGridpaginationbar.setProperty("ShowPrevious", Gridpaginationbar_Showprevious);
         ucGridpaginationbar.setProperty("ShowNext", Gridpaginationbar_Shownext);
         ucGridpaginationbar.setProperty("ShowLast", Gridpaginationbar_Showlast);
         ucGridpaginationbar.setProperty("PagesToShow", Gridpaginationbar_Pagestoshow);
         ucGridpaginationbar.setProperty("PagingButtonsPosition", Gridpaginationbar_Pagingbuttonsposition);
         ucGridpaginationbar.setProperty("PagingCaptionPosition", Gridpaginationbar_Pagingcaptionposition);
         ucGridpaginationbar.setProperty("EmptyGridClass", Gridpaginationbar_Emptygridclass);
         ucGridpaginationbar.setProperty("RowsPerPageSelector", Gridpaginationbar_Rowsperpageselector);
         ucGridpaginationbar.setProperty("RowsPerPageOptions", Gridpaginationbar_Rowsperpageoptions);
         ucGridpaginationbar.setProperty("Previous", Gridpaginationbar_Previous);
         ucGridpaginationbar.setProperty("Next", Gridpaginationbar_Next);
         ucGridpaginationbar.setProperty("Caption", Gridpaginationbar_Caption);
         ucGridpaginationbar.setProperty("EmptyGridCaption", Gridpaginationbar_Emptygridcaption);
         ucGridpaginationbar.setProperty("RowsPerPageCaption", Gridpaginationbar_Rowsperpagecaption);
         ucGridpaginationbar.setProperty("CurrentPage", AV24GridCurrentPage);
         ucGridpaginationbar.setProperty("PageCount", AV25GridPageCount);
         ucGridpaginationbar.render(context, "dvelop.dvpaginationbar", Gridpaginationbar_Internalname, "GRIDPAGINATIONBARContainer");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV19DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_sgcitadisponibilidadfechaauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'" + sGXsfl_29_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname, AV14DDO_SGCitaDisponibilidadFechaAuxDateText, GXutil.rtrim( localUtil.format( AV14DDO_SGCitaDisponibilidadFechaAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,55);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPBandejaCitas.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("Start Date", AV13DDO_SGCitaDisponibilidadFechaAuxDate);
         ucTfsgcitadisponibilidadfecha_rangepicker.setProperty("End Date", AV15DDO_SGCitaDisponibilidadFechaAuxDateTo);
         ucTfsgcitadisponibilidadfecha_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadfecha_rangepicker_Internalname, "TFSGCITADISPONIBILIDADFECHA_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_sgcitadisponibilidadhorainicioauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'" + sGXsfl_29_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname, AV17DDO_SGCitaDisponibilidadHoraInicioAuxDateText, GXutil.rtrim( localUtil.format( AV17DDO_SGCitaDisponibilidadHoraInicioAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPBandejaCitas.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadhorainicio_rangepicker.setProperty("Start Date", AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate);
         ucTfsgcitadisponibilidadhorainicio_rangepicker.setProperty("End Date", AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo);
         ucTfsgcitadisponibilidadhorainicio_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadhorainicio_rangepicker_Internalname, "TFSGCITADISPONIBILIDADHORAINICIO_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divDdo_sgcitadisponibilidadhorafinauxdates_Internalname, 1, 0, "px", 0, "px", "Invisible", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'" + sGXsfl_29_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname, AV127DDO_SGCitaDisponibilidadHoraFinAuxDateText, GXutil.rtrim( localUtil.format( AV127DDO_SGCitaDisponibilidadHoraFinAuxDateText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Jsonclick, 0, "Attribute", "", "", "", "", 1, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPBandejaCitas.htm");
         /* User Defined Control */
         ucTfsgcitadisponibilidadhorafin_rangepicker.setProperty("Start Date", AV125DDO_SGCitaDisponibilidadHoraFinAuxDate);
         ucTfsgcitadisponibilidadhorafin_rangepicker.setProperty("End Date", AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo);
         ucTfsgcitadisponibilidadhorafin_rangepicker.render(context, "wwp.daterangepicker", Tfsgcitadisponibilidadhorafin_rangepicker_Internalname, "TFSGCITADISPONIBILIDADHORAFIN_RANGEPICKERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 29 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start2P2( )
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
         Form.getMeta().addItem("description", " Cita", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2P0( ) ;
   }

   public void ws2P2( )
   {
      start2P2( ) ;
      evt2P2( ) ;
   }

   public void evt2P2( )
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
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e112P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122P2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132P2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_29_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_292( ) ;
                           cmbavActionscita.setName( cmbavActionscita.getInternalname() );
                           cmbavActionscita.setValue( httpContext.cgiGet( cmbavActionscita.getInternalname()) );
                           AV6ActionsCita = (short)(GXutil.lval( httpContext.cgiGet( cmbavActionscita.getInternalname()))) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavActionscita.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ActionsCita), 4, 0));
                           A19CitaId = (int)(localUtil.ctol( httpContext.cgiGet( edtCitaId_Internalname), ",", ".")) ;
                           A64CitaCode = httpContext.cgiGet( edtCitaCode_Internalname) ;
                           A106PacienteNroDocumento = httpContext.cgiGet( edtPacienteNroDocumento_Internalname) ;
                           A103PacienteApellidoPaterno = httpContext.cgiGet( edtPacienteApellidoPaterno_Internalname) ;
                           A104PacienteApellidoMaterno = httpContext.cgiGet( edtPacienteApellidoMaterno_Internalname) ;
                           A105PacienteNombres = httpContext.cgiGet( edtPacienteNombres_Internalname) ;
                           A66SGCitaDisponibilidadFecha = GXutil.resetTime(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadFecha_Internalname), 0)) ;
                           n66SGCitaDisponibilidadFecha = false ;
                           A68SGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraInicio_Internalname), 0)) ;
                           n68SGCitaDisponibilidadHoraInicio = false ;
                           A146SGCitaDisponibilidadEspecialidadNombre = httpContext.cgiGet( edtSGCitaDisponibilidadEspecialidadNombre_Internalname) ;
                           A73SGCitaDisponibilidadSedeNombre = httpContext.cgiGet( edtSGCitaDisponibilidadSedeNombre_Internalname) ;
                           A78SGCitaDisponibilidadClinicaNombre = httpContext.cgiGet( edtSGCitaDisponibilidadClinicaNombre_Internalname) ;
                           cmbCitaEstadoCita.setName( cmbCitaEstadoCita.getInternalname() );
                           cmbCitaEstadoCita.setValue( httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) );
                           A89CitaEstadoCita = httpContext.cgiGet( cmbCitaEstadoCita.getInternalname()) ;
                           n89CitaEstadoCita = false ;
                           cmbCitaEstadoPago.setName( cmbCitaEstadoPago.getInternalname() );
                           cmbCitaEstadoPago.setValue( httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) );
                           A102CitaEstadoPago = httpContext.cgiGet( cmbCitaEstadoPago.getInternalname()) ;
                           n102CitaEstadoPago = false ;
                           A387SGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( httpContext.cgiGet( edtSGCitaDisponibilidadHoraFin_Internalname), 0)) ;
                           n387SGCitaDisponibilidadHoraFin = false ;
                           A333CitaArchivoExtencion = httpContext.cgiGet( edtCitaArchivoExtencion_Internalname) ;
                           n333CitaArchivoExtencion = false ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e142P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e152P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e162P2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Filterfulltext Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV23FilterFullText) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
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

   public void we2P2( )
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

   public void pa2P2( )
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
            GX_FocusControl = edtavFilterfulltext_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_292( ) ;
      while ( nGXsfl_29_idx <= nRC_GXsfl_29 )
      {
         sendrow_292( ) ;
         nGXsfl_29_idx = ((subGrid_Islastpage==1)&&(nGXsfl_29_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_29_idx+1) ;
         sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_292( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 String AV23FilterFullText ,
                                 short AV120SecRoleId ,
                                 int AV5ProfesionalId ,
                                 int AV67TFCitaId ,
                                 int AV68TFCitaId_To ,
                                 String AV51TFCitaCode ,
                                 String AV52TFCitaCode_Sel ,
                                 String AV89TFPacienteNroDocumento ,
                                 String AV90TFPacienteNroDocumento_Sel ,
                                 String AV83TFPacienteApellidoPaterno ,
                                 String AV84TFPacienteApellidoPaterno_Sel ,
                                 String AV81TFPacienteApellidoMaterno ,
                                 String AV82TFPacienteApellidoMaterno_Sel ,
                                 String AV87TFPacienteNombres ,
                                 String AV88TFPacienteNombres_Sel ,
                                 java.util.Date AV99TFSGCitaDisponibilidadFecha ,
                                 java.util.Date AV100TFSGCitaDisponibilidadFecha_To ,
                                 java.util.Date AV101TFSGCitaDisponibilidadHoraInicio ,
                                 java.util.Date AV102TFSGCitaDisponibilidadHoraInicio_To ,
                                 String AV97TFSGCitaDisponibilidadEspecialidadNombre ,
                                 String AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ,
                                 String AV113TFSGCitaDisponibilidadSedeNombre ,
                                 String AV114TFSGCitaDisponibilidadSedeNombre_Sel ,
                                 String AV93TFSGCitaDisponibilidadClinicaNombre ,
                                 String AV94TFSGCitaDisponibilidadClinicaNombre_Sel ,
                                 GXSimpleCollection<String> AV58TFCitaEstadoCita_Sels ,
                                 GXSimpleCollection<String> AV60TFCitaEstadoPago_Sels ,
                                 java.util.Date AV123TFSGCitaDisponibilidadHoraFin ,
                                 java.util.Date AV124TFSGCitaDisponibilidadHoraFin_To ,
                                 String AV128TFCitaArchivoExtencion ,
                                 String AV129TFCitaArchivoExtencion_Sel ,
                                 String AV164Pgmname ,
                                 short AV39OrderedBy ,
                                 boolean AV41OrderedDsc )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e152P2 ();
      GRID_nCurrentRecord = 0 ;
      rf2P2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
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
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2P2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV164Pgmname = "WPBandejaCitas" ;
      Gx_err = (short)(0) ;
   }

   public void rf2P2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(29) ;
      /* Execute user event: Refresh */
      e152P2 ();
      nGXsfl_29_idx = 1 ;
      sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_292( ) ;
      bGXsfl_29_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_292( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A89CitaEstadoCita ,
                                              AV158Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                              A102CitaEstadoPago ,
                                              AV159Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                              AV135Wpbandejacitasds_1_filterfulltext ,
                                              Integer.valueOf(AV136Wpbandejacitasds_2_tfcitaid) ,
                                              Integer.valueOf(AV137Wpbandejacitasds_3_tfcitaid_to) ,
                                              AV139Wpbandejacitasds_5_tfcitacode_sel ,
                                              AV138Wpbandejacitasds_4_tfcitacode ,
                                              AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                              AV140Wpbandejacitasds_6_tfpacientenrodocumento ,
                                              AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                              AV142Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                              AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                              AV144Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                              AV147Wpbandejacitasds_13_tfpacientenombres_sel ,
                                              AV146Wpbandejacitasds_12_tfpacientenombres ,
                                              AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                              AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                              AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                              AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                              AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                              AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                              AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                              AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                              AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                              AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                              Integer.valueOf(AV158Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                              Integer.valueOf(AV159Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                              AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                              AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                              AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                              AV162Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                              Short.valueOf(AV120SecRoleId) ,
                                              A64CitaCode ,
                                              A106PacienteNroDocumento ,
                                              A103PacienteApellidoPaterno ,
                                              A104PacienteApellidoMaterno ,
                                              A105PacienteNombres ,
                                              A146SGCitaDisponibilidadEspecialidadNombre ,
                                              A73SGCitaDisponibilidadSedeNombre ,
                                              A78SGCitaDisponibilidadClinicaNombre ,
                                              Integer.valueOf(A19CitaId) ,
                                              A66SGCitaDisponibilidadFecha ,
                                              A68SGCitaDisponibilidadHoraInicio ,
                                              A387SGCitaDisponibilidadHoraFin ,
                                              A333CitaArchivoExtencion ,
                                              Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                              Integer.valueOf(AV5ProfesionalId) ,
                                              Short.valueOf(AV39OrderedBy) ,
                                              Boolean.valueOf(AV41OrderedDsc) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                              TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                              }
         });
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
         lV138Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV138Wpbandejacitasds_4_tfcitacode), "%", "") ;
         lV140Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV140Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
         lV142Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV142Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
         lV144Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV144Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
         lV146Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV146Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
         lV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
         lV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
         lV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
         lV162Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV162Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
         /* Using cursor H002P2 */
         pr_default.execute(0, new Object[] {lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV136Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV137Wpbandejacitasds_3_tfcitaid_to), lV138Wpbandejacitasds_4_tfcitacode, AV139Wpbandejacitasds_5_tfcitacode_sel, lV140Wpbandejacitasds_6_tfpacientenrodocumento, AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV142Wpbandejacitasds_8_tfpacienteapellidopaterno, AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV144Wpbandejacitasds_10_tfpacienteapellidomaterno, AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV146Wpbandejacitasds_12_tfpacientenombres, AV147Wpbandejacitasds_13_tfpacientenombres_sel, AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV162Wpbandejacitasds_28_tfcitaarchivoextencion, AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV5ProfesionalId), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_29_idx = 1 ;
         sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_292( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A20PacienteId = H002P2_A20PacienteId[0] ;
            A21SGCitaDisponibilidadId = H002P2_A21SGCitaDisponibilidadId[0] ;
            A70SGCitaDisponibilidadEspecialidadId = H002P2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A72SGCitaDisponibilidadSedeId = H002P2_A72SGCitaDisponibilidadSedeId[0] ;
            A76SGCitaDisponibilidadClinicaId = H002P2_A76SGCitaDisponibilidadClinicaId[0] ;
            A81SGCitaDisponibilidadProfesionalId = H002P2_A81SGCitaDisponibilidadProfesionalId[0] ;
            A333CitaArchivoExtencion = H002P2_A333CitaArchivoExtencion[0] ;
            n333CitaArchivoExtencion = H002P2_n333CitaArchivoExtencion[0] ;
            A387SGCitaDisponibilidadHoraFin = H002P2_A387SGCitaDisponibilidadHoraFin[0] ;
            n387SGCitaDisponibilidadHoraFin = H002P2_n387SGCitaDisponibilidadHoraFin[0] ;
            A102CitaEstadoPago = H002P2_A102CitaEstadoPago[0] ;
            n102CitaEstadoPago = H002P2_n102CitaEstadoPago[0] ;
            A89CitaEstadoCita = H002P2_A89CitaEstadoCita[0] ;
            n89CitaEstadoCita = H002P2_n89CitaEstadoCita[0] ;
            A78SGCitaDisponibilidadClinicaNombre = H002P2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            A73SGCitaDisponibilidadSedeNombre = H002P2_A73SGCitaDisponibilidadSedeNombre[0] ;
            A146SGCitaDisponibilidadEspecialidadNombre = H002P2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            A68SGCitaDisponibilidadHoraInicio = H002P2_A68SGCitaDisponibilidadHoraInicio[0] ;
            n68SGCitaDisponibilidadHoraInicio = H002P2_n68SGCitaDisponibilidadHoraInicio[0] ;
            A66SGCitaDisponibilidadFecha = H002P2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H002P2_n66SGCitaDisponibilidadFecha[0] ;
            A105PacienteNombres = H002P2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H002P2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H002P2_A103PacienteApellidoPaterno[0] ;
            A106PacienteNroDocumento = H002P2_A106PacienteNroDocumento[0] ;
            A64CitaCode = H002P2_A64CitaCode[0] ;
            A19CitaId = H002P2_A19CitaId[0] ;
            A105PacienteNombres = H002P2_A105PacienteNombres[0] ;
            A104PacienteApellidoMaterno = H002P2_A104PacienteApellidoMaterno[0] ;
            A103PacienteApellidoPaterno = H002P2_A103PacienteApellidoPaterno[0] ;
            A106PacienteNroDocumento = H002P2_A106PacienteNroDocumento[0] ;
            A70SGCitaDisponibilidadEspecialidadId = H002P2_A70SGCitaDisponibilidadEspecialidadId[0] ;
            A72SGCitaDisponibilidadSedeId = H002P2_A72SGCitaDisponibilidadSedeId[0] ;
            A81SGCitaDisponibilidadProfesionalId = H002P2_A81SGCitaDisponibilidadProfesionalId[0] ;
            A387SGCitaDisponibilidadHoraFin = H002P2_A387SGCitaDisponibilidadHoraFin[0] ;
            n387SGCitaDisponibilidadHoraFin = H002P2_n387SGCitaDisponibilidadHoraFin[0] ;
            A68SGCitaDisponibilidadHoraInicio = H002P2_A68SGCitaDisponibilidadHoraInicio[0] ;
            n68SGCitaDisponibilidadHoraInicio = H002P2_n68SGCitaDisponibilidadHoraInicio[0] ;
            A66SGCitaDisponibilidadFecha = H002P2_A66SGCitaDisponibilidadFecha[0] ;
            n66SGCitaDisponibilidadFecha = H002P2_n66SGCitaDisponibilidadFecha[0] ;
            A146SGCitaDisponibilidadEspecialidadNombre = H002P2_A146SGCitaDisponibilidadEspecialidadNombre[0] ;
            A76SGCitaDisponibilidadClinicaId = H002P2_A76SGCitaDisponibilidadClinicaId[0] ;
            A73SGCitaDisponibilidadSedeNombre = H002P2_A73SGCitaDisponibilidadSedeNombre[0] ;
            A78SGCitaDisponibilidadClinicaNombre = H002P2_A78SGCitaDisponibilidadClinicaNombre[0] ;
            e162P2 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(29) ;
         wb2P0( ) ;
      }
      bGXsfl_29_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2P2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV164Pgmname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV164Pgmname, ""))));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      AV135Wpbandejacitasds_1_filterfulltext = AV23FilterFullText ;
      AV136Wpbandejacitasds_2_tfcitaid = AV67TFCitaId ;
      AV137Wpbandejacitasds_3_tfcitaid_to = AV68TFCitaId_To ;
      AV138Wpbandejacitasds_4_tfcitacode = AV51TFCitaCode ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = AV52TFCitaCode_Sel ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = AV89TFPacienteNroDocumento ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV90TFPacienteNroDocumento_Sel ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = AV83TFPacienteApellidoPaterno ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV84TFPacienteApellidoPaterno_Sel ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = AV81TFPacienteApellidoMaterno ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV82TFPacienteApellidoMaterno_Sel ;
      AV146Wpbandejacitasds_12_tfpacientenombres = AV87TFPacienteNombres ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = AV88TFPacienteNombres_Sel ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV99TFSGCitaDisponibilidadFecha ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV100TFSGCitaDisponibilidadFecha_To ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV101TFSGCitaDisponibilidadHoraInicio ;
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV102TFSGCitaDisponibilidadHoraInicio_To ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV97TFSGCitaDisponibilidadEspecialidadNombre ;
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV113TFSGCitaDisponibilidadSedeNombre ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV93TFSGCitaDisponibilidadClinicaNombre ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = AV58TFCitaEstadoCita_Sels ;
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = AV60TFCitaEstadoPago_Sels ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV123TFSGCitaDisponibilidadHoraFin ;
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV124TFSGCitaDisponibilidadHoraFin_To ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = AV128TFCitaArchivoExtencion ;
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV129TFCitaArchivoExtencion_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A89CitaEstadoCita ,
                                           AV158Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                           A102CitaEstadoPago ,
                                           AV159Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                           AV135Wpbandejacitasds_1_filterfulltext ,
                                           Integer.valueOf(AV136Wpbandejacitasds_2_tfcitaid) ,
                                           Integer.valueOf(AV137Wpbandejacitasds_3_tfcitaid_to) ,
                                           AV139Wpbandejacitasds_5_tfcitacode_sel ,
                                           AV138Wpbandejacitasds_4_tfcitacode ,
                                           AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                           AV140Wpbandejacitasds_6_tfpacientenrodocumento ,
                                           AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                           AV142Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                           AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                           AV144Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                           AV147Wpbandejacitasds_13_tfpacientenombres_sel ,
                                           AV146Wpbandejacitasds_12_tfpacientenombres ,
                                           AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                           AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                           AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                           AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                           AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                           AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                           AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                           AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                           AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                           AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                           Integer.valueOf(AV158Wpbandejacitasds_24_tfcitaestadocita_sels.size()) ,
                                           Integer.valueOf(AV159Wpbandejacitasds_25_tfcitaestadopago_sels.size()) ,
                                           AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                           AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                           AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                           AV162Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                           Short.valueOf(AV120SecRoleId) ,
                                           A64CitaCode ,
                                           A106PacienteNroDocumento ,
                                           A103PacienteApellidoPaterno ,
                                           A104PacienteApellidoMaterno ,
                                           A105PacienteNombres ,
                                           A146SGCitaDisponibilidadEspecialidadNombre ,
                                           A73SGCitaDisponibilidadSedeNombre ,
                                           A78SGCitaDisponibilidadClinicaNombre ,
                                           Integer.valueOf(A19CitaId) ,
                                           A66SGCitaDisponibilidadFecha ,
                                           A68SGCitaDisponibilidadHoraInicio ,
                                           A387SGCitaDisponibilidadHoraFin ,
                                           A333CitaArchivoExtencion ,
                                           Integer.valueOf(A81SGCitaDisponibilidadProfesionalId) ,
                                           Integer.valueOf(AV5ProfesionalId) ,
                                           Short.valueOf(AV39OrderedBy) ,
                                           Boolean.valueOf(AV41OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING,
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV135Wpbandejacitasds_1_filterfulltext = GXutil.concat( GXutil.rtrim( AV135Wpbandejacitasds_1_filterfulltext), "%", "") ;
      lV138Wpbandejacitasds_4_tfcitacode = GXutil.concat( GXutil.rtrim( AV138Wpbandejacitasds_4_tfcitacode), "%", "") ;
      lV140Wpbandejacitasds_6_tfpacientenrodocumento = GXutil.concat( GXutil.rtrim( AV140Wpbandejacitasds_6_tfpacientenrodocumento), "%", "") ;
      lV142Wpbandejacitasds_8_tfpacienteapellidopaterno = GXutil.concat( GXutil.rtrim( AV142Wpbandejacitasds_8_tfpacienteapellidopaterno), "%", "") ;
      lV144Wpbandejacitasds_10_tfpacienteapellidomaterno = GXutil.concat( GXutil.rtrim( AV144Wpbandejacitasds_10_tfpacienteapellidomaterno), "%", "") ;
      lV146Wpbandejacitasds_12_tfpacientenombres = GXutil.concat( GXutil.rtrim( AV146Wpbandejacitasds_12_tfpacientenombres), "%", "") ;
      lV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = GXutil.concat( GXutil.rtrim( AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre), "%", "") ;
      lV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = GXutil.concat( GXutil.rtrim( AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre), "%", "") ;
      lV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = GXutil.concat( GXutil.rtrim( AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre), "%", "") ;
      lV162Wpbandejacitasds_28_tfcitaarchivoextencion = GXutil.concat( GXutil.rtrim( AV162Wpbandejacitasds_28_tfcitaarchivoextencion), "%", "") ;
      /* Using cursor H002P3 */
      pr_default.execute(1, new Object[] {lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, lV135Wpbandejacitasds_1_filterfulltext, Integer.valueOf(AV136Wpbandejacitasds_2_tfcitaid), Integer.valueOf(AV137Wpbandejacitasds_3_tfcitaid_to), lV138Wpbandejacitasds_4_tfcitacode, AV139Wpbandejacitasds_5_tfcitacode_sel, lV140Wpbandejacitasds_6_tfpacientenrodocumento, AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel, lV142Wpbandejacitasds_8_tfpacienteapellidopaterno, AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel, lV144Wpbandejacitasds_10_tfpacienteapellidomaterno, AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel, lV146Wpbandejacitasds_12_tfpacientenombres, AV147Wpbandejacitasds_13_tfpacientenombres_sel, AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha, AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to, AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio, AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to, lV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre, AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel, lV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre, AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel, lV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre, AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel, AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin, AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to, lV162Wpbandejacitasds_28_tfcitaarchivoextencion, AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel, Integer.valueOf(AV5ProfesionalId)});
      GRID_nRecordCount = H002P3_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      AV135Wpbandejacitasds_1_filterfulltext = AV23FilterFullText ;
      AV136Wpbandejacitasds_2_tfcitaid = AV67TFCitaId ;
      AV137Wpbandejacitasds_3_tfcitaid_to = AV68TFCitaId_To ;
      AV138Wpbandejacitasds_4_tfcitacode = AV51TFCitaCode ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = AV52TFCitaCode_Sel ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = AV89TFPacienteNroDocumento ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV90TFPacienteNroDocumento_Sel ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = AV83TFPacienteApellidoPaterno ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV84TFPacienteApellidoPaterno_Sel ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = AV81TFPacienteApellidoMaterno ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV82TFPacienteApellidoMaterno_Sel ;
      AV146Wpbandejacitasds_12_tfpacientenombres = AV87TFPacienteNombres ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = AV88TFPacienteNombres_Sel ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV99TFSGCitaDisponibilidadFecha ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV100TFSGCitaDisponibilidadFecha_To ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV101TFSGCitaDisponibilidadHoraInicio ;
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV102TFSGCitaDisponibilidadHoraInicio_To ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV97TFSGCitaDisponibilidadEspecialidadNombre ;
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV113TFSGCitaDisponibilidadSedeNombre ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV93TFSGCitaDisponibilidadClinicaNombre ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = AV58TFCitaEstadoCita_Sels ;
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = AV60TFCitaEstadoPago_Sels ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV123TFSGCitaDisponibilidadHoraFin ;
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV124TFSGCitaDisponibilidadHoraFin_To ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = AV128TFCitaArchivoExtencion ;
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV129TFCitaArchivoExtencion_Sel ;
      GRID_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV23FilterFullText, AV120SecRoleId, AV5ProfesionalId, AV67TFCitaId, AV68TFCitaId_To, AV51TFCitaCode, AV52TFCitaCode_Sel, AV89TFPacienteNroDocumento, AV90TFPacienteNroDocumento_Sel, AV83TFPacienteApellidoPaterno, AV84TFPacienteApellidoPaterno_Sel, AV81TFPacienteApellidoMaterno, AV82TFPacienteApellidoMaterno_Sel, AV87TFPacienteNombres, AV88TFPacienteNombres_Sel, AV99TFSGCitaDisponibilidadFecha, AV100TFSGCitaDisponibilidadFecha_To, AV101TFSGCitaDisponibilidadHoraInicio, AV102TFSGCitaDisponibilidadHoraInicio_To, AV97TFSGCitaDisponibilidadEspecialidadNombre, AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV113TFSGCitaDisponibilidadSedeNombre, AV114TFSGCitaDisponibilidadSedeNombre_Sel, AV93TFSGCitaDisponibilidadClinicaNombre, AV94TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFCitaEstadoCita_Sels, AV60TFCitaEstadoPago_Sels, AV123TFSGCitaDisponibilidadHoraFin, AV124TFSGCitaDisponibilidadHoraFin_To, AV128TFCitaArchivoExtencion, AV129TFCitaArchivoExtencion_Sel, AV164Pgmname, AV39OrderedBy, AV41OrderedDsc) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV135Wpbandejacitasds_1_filterfulltext = AV23FilterFullText ;
      AV136Wpbandejacitasds_2_tfcitaid = AV67TFCitaId ;
      AV137Wpbandejacitasds_3_tfcitaid_to = AV68TFCitaId_To ;
      AV138Wpbandejacitasds_4_tfcitacode = AV51TFCitaCode ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = AV52TFCitaCode_Sel ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = AV89TFPacienteNroDocumento ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV90TFPacienteNroDocumento_Sel ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = AV83TFPacienteApellidoPaterno ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV84TFPacienteApellidoPaterno_Sel ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = AV81TFPacienteApellidoMaterno ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV82TFPacienteApellidoMaterno_Sel ;
      AV146Wpbandejacitasds_12_tfpacientenombres = AV87TFPacienteNombres ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = AV88TFPacienteNombres_Sel ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV99TFSGCitaDisponibilidadFecha ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV100TFSGCitaDisponibilidadFecha_To ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV101TFSGCitaDisponibilidadHoraInicio ;
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV102TFSGCitaDisponibilidadHoraInicio_To ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV97TFSGCitaDisponibilidadEspecialidadNombre ;
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV113TFSGCitaDisponibilidadSedeNombre ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV93TFSGCitaDisponibilidadClinicaNombre ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = AV58TFCitaEstadoCita_Sels ;
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = AV60TFCitaEstadoPago_Sels ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV123TFSGCitaDisponibilidadHoraFin ;
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV124TFSGCitaDisponibilidadHoraFin_To ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = AV128TFCitaArchivoExtencion ;
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV129TFCitaArchivoExtencion_Sel ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV23FilterFullText, AV120SecRoleId, AV5ProfesionalId, AV67TFCitaId, AV68TFCitaId_To, AV51TFCitaCode, AV52TFCitaCode_Sel, AV89TFPacienteNroDocumento, AV90TFPacienteNroDocumento_Sel, AV83TFPacienteApellidoPaterno, AV84TFPacienteApellidoPaterno_Sel, AV81TFPacienteApellidoMaterno, AV82TFPacienteApellidoMaterno_Sel, AV87TFPacienteNombres, AV88TFPacienteNombres_Sel, AV99TFSGCitaDisponibilidadFecha, AV100TFSGCitaDisponibilidadFecha_To, AV101TFSGCitaDisponibilidadHoraInicio, AV102TFSGCitaDisponibilidadHoraInicio_To, AV97TFSGCitaDisponibilidadEspecialidadNombre, AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV113TFSGCitaDisponibilidadSedeNombre, AV114TFSGCitaDisponibilidadSedeNombre_Sel, AV93TFSGCitaDisponibilidadClinicaNombre, AV94TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFCitaEstadoCita_Sels, AV60TFCitaEstadoPago_Sels, AV123TFSGCitaDisponibilidadHoraFin, AV124TFSGCitaDisponibilidadHoraFin_To, AV128TFCitaArchivoExtencion, AV129TFCitaArchivoExtencion_Sel, AV164Pgmname, AV39OrderedBy, AV41OrderedDsc) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV135Wpbandejacitasds_1_filterfulltext = AV23FilterFullText ;
      AV136Wpbandejacitasds_2_tfcitaid = AV67TFCitaId ;
      AV137Wpbandejacitasds_3_tfcitaid_to = AV68TFCitaId_To ;
      AV138Wpbandejacitasds_4_tfcitacode = AV51TFCitaCode ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = AV52TFCitaCode_Sel ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = AV89TFPacienteNroDocumento ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV90TFPacienteNroDocumento_Sel ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = AV83TFPacienteApellidoPaterno ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV84TFPacienteApellidoPaterno_Sel ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = AV81TFPacienteApellidoMaterno ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV82TFPacienteApellidoMaterno_Sel ;
      AV146Wpbandejacitasds_12_tfpacientenombres = AV87TFPacienteNombres ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = AV88TFPacienteNombres_Sel ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV99TFSGCitaDisponibilidadFecha ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV100TFSGCitaDisponibilidadFecha_To ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV101TFSGCitaDisponibilidadHoraInicio ;
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV102TFSGCitaDisponibilidadHoraInicio_To ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV97TFSGCitaDisponibilidadEspecialidadNombre ;
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV113TFSGCitaDisponibilidadSedeNombre ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV93TFSGCitaDisponibilidadClinicaNombre ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = AV58TFCitaEstadoCita_Sels ;
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = AV60TFCitaEstadoPago_Sels ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV123TFSGCitaDisponibilidadHoraFin ;
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV124TFSGCitaDisponibilidadHoraFin_To ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = AV128TFCitaArchivoExtencion ;
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV129TFCitaArchivoExtencion_Sel ;
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV23FilterFullText, AV120SecRoleId, AV5ProfesionalId, AV67TFCitaId, AV68TFCitaId_To, AV51TFCitaCode, AV52TFCitaCode_Sel, AV89TFPacienteNroDocumento, AV90TFPacienteNroDocumento_Sel, AV83TFPacienteApellidoPaterno, AV84TFPacienteApellidoPaterno_Sel, AV81TFPacienteApellidoMaterno, AV82TFPacienteApellidoMaterno_Sel, AV87TFPacienteNombres, AV88TFPacienteNombres_Sel, AV99TFSGCitaDisponibilidadFecha, AV100TFSGCitaDisponibilidadFecha_To, AV101TFSGCitaDisponibilidadHoraInicio, AV102TFSGCitaDisponibilidadHoraInicio_To, AV97TFSGCitaDisponibilidadEspecialidadNombre, AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV113TFSGCitaDisponibilidadSedeNombre, AV114TFSGCitaDisponibilidadSedeNombre_Sel, AV93TFSGCitaDisponibilidadClinicaNombre, AV94TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFCitaEstadoCita_Sels, AV60TFCitaEstadoPago_Sels, AV123TFSGCitaDisponibilidadHoraFin, AV124TFSGCitaDisponibilidadHoraFin_To, AV128TFCitaArchivoExtencion, AV129TFCitaArchivoExtencion_Sel, AV164Pgmname, AV39OrderedBy, AV41OrderedDsc) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV135Wpbandejacitasds_1_filterfulltext = AV23FilterFullText ;
      AV136Wpbandejacitasds_2_tfcitaid = AV67TFCitaId ;
      AV137Wpbandejacitasds_3_tfcitaid_to = AV68TFCitaId_To ;
      AV138Wpbandejacitasds_4_tfcitacode = AV51TFCitaCode ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = AV52TFCitaCode_Sel ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = AV89TFPacienteNroDocumento ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV90TFPacienteNroDocumento_Sel ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = AV83TFPacienteApellidoPaterno ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV84TFPacienteApellidoPaterno_Sel ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = AV81TFPacienteApellidoMaterno ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV82TFPacienteApellidoMaterno_Sel ;
      AV146Wpbandejacitasds_12_tfpacientenombres = AV87TFPacienteNombres ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = AV88TFPacienteNombres_Sel ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV99TFSGCitaDisponibilidadFecha ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV100TFSGCitaDisponibilidadFecha_To ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV101TFSGCitaDisponibilidadHoraInicio ;
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV102TFSGCitaDisponibilidadHoraInicio_To ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV97TFSGCitaDisponibilidadEspecialidadNombre ;
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV113TFSGCitaDisponibilidadSedeNombre ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV93TFSGCitaDisponibilidadClinicaNombre ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = AV58TFCitaEstadoCita_Sels ;
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = AV60TFCitaEstadoPago_Sels ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV123TFSGCitaDisponibilidadHoraFin ;
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV124TFSGCitaDisponibilidadHoraFin_To ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = AV128TFCitaArchivoExtencion ;
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV129TFCitaArchivoExtencion_Sel ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV23FilterFullText, AV120SecRoleId, AV5ProfesionalId, AV67TFCitaId, AV68TFCitaId_To, AV51TFCitaCode, AV52TFCitaCode_Sel, AV89TFPacienteNroDocumento, AV90TFPacienteNroDocumento_Sel, AV83TFPacienteApellidoPaterno, AV84TFPacienteApellidoPaterno_Sel, AV81TFPacienteApellidoMaterno, AV82TFPacienteApellidoMaterno_Sel, AV87TFPacienteNombres, AV88TFPacienteNombres_Sel, AV99TFSGCitaDisponibilidadFecha, AV100TFSGCitaDisponibilidadFecha_To, AV101TFSGCitaDisponibilidadHoraInicio, AV102TFSGCitaDisponibilidadHoraInicio_To, AV97TFSGCitaDisponibilidadEspecialidadNombre, AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV113TFSGCitaDisponibilidadSedeNombre, AV114TFSGCitaDisponibilidadSedeNombre_Sel, AV93TFSGCitaDisponibilidadClinicaNombre, AV94TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFCitaEstadoCita_Sels, AV60TFCitaEstadoPago_Sels, AV123TFSGCitaDisponibilidadHoraFin, AV124TFSGCitaDisponibilidadHoraFin_To, AV128TFCitaArchivoExtencion, AV129TFCitaArchivoExtencion_Sel, AV164Pgmname, AV39OrderedBy, AV41OrderedDsc) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV135Wpbandejacitasds_1_filterfulltext = AV23FilterFullText ;
      AV136Wpbandejacitasds_2_tfcitaid = AV67TFCitaId ;
      AV137Wpbandejacitasds_3_tfcitaid_to = AV68TFCitaId_To ;
      AV138Wpbandejacitasds_4_tfcitacode = AV51TFCitaCode ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = AV52TFCitaCode_Sel ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = AV89TFPacienteNroDocumento ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV90TFPacienteNroDocumento_Sel ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = AV83TFPacienteApellidoPaterno ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV84TFPacienteApellidoPaterno_Sel ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = AV81TFPacienteApellidoMaterno ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV82TFPacienteApellidoMaterno_Sel ;
      AV146Wpbandejacitasds_12_tfpacientenombres = AV87TFPacienteNombres ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = AV88TFPacienteNombres_Sel ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV99TFSGCitaDisponibilidadFecha ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV100TFSGCitaDisponibilidadFecha_To ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV101TFSGCitaDisponibilidadHoraInicio ;
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV102TFSGCitaDisponibilidadHoraInicio_To ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV97TFSGCitaDisponibilidadEspecialidadNombre ;
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV113TFSGCitaDisponibilidadSedeNombre ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV93TFSGCitaDisponibilidadClinicaNombre ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = AV58TFCitaEstadoCita_Sels ;
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = AV60TFCitaEstadoPago_Sels ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV123TFSGCitaDisponibilidadHoraFin ;
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV124TFSGCitaDisponibilidadHoraFin_To ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = AV128TFCitaArchivoExtencion ;
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV129TFCitaArchivoExtencion_Sel ;
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV23FilterFullText, AV120SecRoleId, AV5ProfesionalId, AV67TFCitaId, AV68TFCitaId_To, AV51TFCitaCode, AV52TFCitaCode_Sel, AV89TFPacienteNroDocumento, AV90TFPacienteNroDocumento_Sel, AV83TFPacienteApellidoPaterno, AV84TFPacienteApellidoPaterno_Sel, AV81TFPacienteApellidoMaterno, AV82TFPacienteApellidoMaterno_Sel, AV87TFPacienteNombres, AV88TFPacienteNombres_Sel, AV99TFSGCitaDisponibilidadFecha, AV100TFSGCitaDisponibilidadFecha_To, AV101TFSGCitaDisponibilidadHoraInicio, AV102TFSGCitaDisponibilidadHoraInicio_To, AV97TFSGCitaDisponibilidadEspecialidadNombre, AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, AV113TFSGCitaDisponibilidadSedeNombre, AV114TFSGCitaDisponibilidadSedeNombre_Sel, AV93TFSGCitaDisponibilidadClinicaNombre, AV94TFSGCitaDisponibilidadClinicaNombre_Sel, AV58TFCitaEstadoCita_Sels, AV60TFCitaEstadoPago_Sels, AV123TFSGCitaDisponibilidadHoraFin, AV124TFSGCitaDisponibilidadHoraFin_To, AV128TFCitaArchivoExtencion, AV129TFCitaArchivoExtencion_Sel, AV164Pgmname, AV39OrderedBy, AV41OrderedDsc) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV164Pgmname = "WPBandejaCitas" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2P0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e142P2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV19DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_29 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_29"), ",", ".")) ;
         AV24GridCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDCURRENTPAGE"), ",", ".") ;
         AV25GridPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDPAGECOUNT"), ",", ".") ;
         AV13DDO_SGCitaDisponibilidadFechaAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATE"), 0) ;
         AV15DDO_SGCitaDisponibilidadFechaAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETO"), 0) ;
         AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATE"), 0) ;
         AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETO"), 0) ;
         AV125DDO_SGCitaDisponibilidadHoraFinAuxDate = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATE"), 0) ;
         AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo = localUtil.ctod( httpContext.cgiGet( "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETO"), 0) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), ",", ".") ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), ",", ".")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Dvpanel_tableheader_Width = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Width") ;
         Dvpanel_tableheader_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autowidth")) ;
         Dvpanel_tableheader_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autoheight")) ;
         Dvpanel_tableheader_Cls = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Cls") ;
         Dvpanel_tableheader_Title = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Title") ;
         Dvpanel_tableheader_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Collapsible")) ;
         Dvpanel_tableheader_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Collapsed")) ;
         Dvpanel_tableheader_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Showcollapseicon")) ;
         Dvpanel_tableheader_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEHEADER_Iconposition") ;
         Dvpanel_tableheader_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEHEADER_Autoscroll")) ;
         Gridpaginationbar_Class = httpContext.cgiGet( "GRIDPAGINATIONBAR_Class") ;
         Gridpaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showfirst")) ;
         Gridpaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showprevious")) ;
         Gridpaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Shownext")) ;
         Gridpaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Showlast")) ;
         Gridpaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridpaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridpaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDPAGINATIONBAR_Pagingcaptionposition") ;
         Gridpaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridclass") ;
         Gridpaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselector")) ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridpaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageoptions") ;
         Gridpaginationbar_Previous = httpContext.cgiGet( "GRIDPAGINATIONBAR_Previous") ;
         Gridpaginationbar_Next = httpContext.cgiGet( "GRIDPAGINATIONBAR_Next") ;
         Gridpaginationbar_Caption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Caption") ;
         Gridpaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Emptygridcaption") ;
         Gridpaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpagecaption") ;
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( "DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Gridpaginationbar_Selectedpage = httpContext.cgiGet( "GRIDPAGINATIONBAR_Selectedpage") ;
         Gridpaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         /* Read variables values. */
         AV23FilterFullText = httpContext.cgiGet( edtavFilterfulltext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23FilterFullText", AV23FilterFullText);
         AV14DDO_SGCitaDisponibilidadFechaAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14DDO_SGCitaDisponibilidadFechaAuxDateText", AV14DDO_SGCitaDisponibilidadFechaAuxDateText);
         AV17DDO_SGCitaDisponibilidadHoraInicioAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17DDO_SGCitaDisponibilidadHoraInicioAuxDateText", AV17DDO_SGCitaDisponibilidadHoraInicioAuxDateText);
         AV127DDO_SGCitaDisponibilidadHoraFinAuxDateText = httpContext.cgiGet( edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV127DDO_SGCitaDisponibilidadHoraFinAuxDateText", AV127DDO_SGCitaDisponibilidadHoraFinAuxDateText);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vFILTERFULLTEXT"), AV23FilterFullText) != 0 )
         {
            GRID_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e142P2 ();
      if (returnInSub) return;
   }

   public void e142P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV119WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV119WWPContext = GXv_SdtWWPContext1[0] ;
      AV121SecUserId = AV119WWPContext.getgxTv_SdtWWPContext_Userid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV121SecUserId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV121SecUserId), 4, 0));
      /* Using cursor H002P4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV121SecUserId)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A6SecUserId = H002P4_A6SecUserId[0] ;
         A14SecUserName = H002P4_A14SecUserName[0] ;
         A122SecUserEmail = H002P4_A122SecUserEmail[0] ;
         AV43ProfesionalNroDocumento = A14SecUserName ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43ProfesionalNroDocumento", AV43ProfesionalNroDocumento);
         AV122ProfesionalCorreo = A122SecUserEmail ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      /* Using cursor H002P5 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV121SecUserId)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A6SecUserId = H002P5_A6SecUserId[0] ;
         A4SecRoleId = H002P5_A4SecRoleId[0] ;
         AV120SecRoleId = A4SecRoleId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV120SecRoleId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV120SecRoleId), 4, 0));
         pr_default.readNext(3);
      }
      pr_default.close(3);
      AV5ProfesionalId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5ProfesionalId), 8, 0));
      /* Using cursor H002P6 */
      pr_default.execute(4, new Object[] {AV43ProfesionalNroDocumento});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A174ProfesionalNroDocumento = H002P6_A174ProfesionalNroDocumento[0] ;
         A31ProfesionalId = H002P6_A31ProfesionalId[0] ;
         AV5ProfesionalId = A31ProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV5ProfesionalId), 8, 0));
         pr_default.readNext(4);
      }
      pr_default.close(4);
      this.executeUsercontrolMethod("", false, "TFSGCITADISPONIBILIDADHORAFIN_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFSGCITADISPONIBILIDADHORAINICIO_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname});
      this.executeUsercontrolMethod("", false, "TFSGCITADISPONIBILIDADFECHA_RANGEPICKERContainer", "Attach", "", new Object[] {edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname});
      subGrid_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( " Cita" );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S122 ();
      if (returnInSub) return;
      if ( AV39OrderedBy < 1 )
      {
         AV39OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV19DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new com.projectthani.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV19DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      Gridpaginationbar_Rowsperpageselectedvalue = subGrid_Rows ;
      ucGridpaginationbar.sendProperty(context, "", false, Gridpaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridpaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e152P2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV119WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV119WWPContext = GXv_SdtWWPContext1[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S142 ();
      if (returnInSub) return;
      AV24GridCurrentPage = subgrid_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24GridCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridCurrentPage), 10, 0));
      AV25GridPageCount = subgrid_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25GridPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GridPageCount), 10, 0));
      AV135Wpbandejacitasds_1_filterfulltext = AV23FilterFullText ;
      AV136Wpbandejacitasds_2_tfcitaid = AV67TFCitaId ;
      AV137Wpbandejacitasds_3_tfcitaid_to = AV68TFCitaId_To ;
      AV138Wpbandejacitasds_4_tfcitacode = AV51TFCitaCode ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = AV52TFCitaCode_Sel ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = AV89TFPacienteNroDocumento ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = AV90TFPacienteNroDocumento_Sel ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = AV83TFPacienteApellidoPaterno ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = AV84TFPacienteApellidoPaterno_Sel ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = AV81TFPacienteApellidoMaterno ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = AV82TFPacienteApellidoMaterno_Sel ;
      AV146Wpbandejacitasds_12_tfpacientenombres = AV87TFPacienteNombres ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = AV88TFPacienteNombres_Sel ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = AV99TFSGCitaDisponibilidadFecha ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = AV100TFSGCitaDisponibilidadFecha_To ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = AV101TFSGCitaDisponibilidadHoraInicio ;
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = AV102TFSGCitaDisponibilidadHoraInicio_To ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = AV97TFSGCitaDisponibilidadEspecialidadNombre ;
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = AV113TFSGCitaDisponibilidadSedeNombre ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = AV93TFSGCitaDisponibilidadClinicaNombre ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = AV58TFCitaEstadoCita_Sels ;
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = AV60TFCitaEstadoPago_Sels ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = AV123TFSGCitaDisponibilidadHoraFin ;
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = AV124TFSGCitaDisponibilidadHoraFin_To ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = AV128TFCitaArchivoExtencion ;
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = AV129TFCitaArchivoExtencion_Sel ;
      /*  Sending Event outputs  */
   }

   public void e112P2( )
   {
      /* Gridpaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgrid_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridpaginationbar_Selectedpage, "Next") == 0 )
      {
         subgrid_nextpage( ) ;
      }
      else
      {
         AV42PageToGo = (int)(GXutil.lval( Gridpaginationbar_Selectedpage)) ;
         subgrid_gotopage( AV42PageToGo) ;
      }
   }

   public void e122P2( )
   {
      /* Gridpaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid_Rows = Gridpaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      subgrid_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e132P2( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV39OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV39OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39OrderedBy), 4, 0));
         AV41OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41OrderedDsc", AV41OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S132 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaId") == 0 )
         {
            AV67TFCitaId = (int)(GXutil.lval( Ddo_grid_Filteredtext_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFCitaId), 8, 0));
            AV68TFCitaId_To = (int)(GXutil.lval( Ddo_grid_Filteredtextto_get)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaCode") == 0 )
         {
            AV51TFCitaCode = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFCitaCode", AV51TFCitaCode);
            AV52TFCitaCode_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFCitaCode_Sel", AV52TFCitaCode_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNroDocumento") == 0 )
         {
            AV89TFPacienteNroDocumento = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV89TFPacienteNroDocumento", AV89TFPacienteNroDocumento);
            AV90TFPacienteNroDocumento_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFPacienteNroDocumento_Sel", AV90TFPacienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoPaterno") == 0 )
         {
            AV83TFPacienteApellidoPaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFPacienteApellidoPaterno", AV83TFPacienteApellidoPaterno);
            AV84TFPacienteApellidoPaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84TFPacienteApellidoPaterno_Sel", AV84TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteApellidoMaterno") == 0 )
         {
            AV81TFPacienteApellidoMaterno = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFPacienteApellidoMaterno", AV81TFPacienteApellidoMaterno);
            AV82TFPacienteApellidoMaterno_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFPacienteApellidoMaterno_Sel", AV82TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "PacienteNombres") == 0 )
         {
            AV87TFPacienteNombres = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFPacienteNombres", AV87TFPacienteNombres);
            AV88TFPacienteNombres_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFPacienteNombres_Sel", AV88TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadFecha") == 0 )
         {
            AV99TFSGCitaDisponibilidadFecha = localUtil.ctod( Ddo_grid_Filteredtext_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFSGCitaDisponibilidadFecha", localUtil.format(AV99TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV100TFSGCitaDisponibilidadFecha_To = localUtil.ctod( Ddo_grid_Filteredtextto_get, 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFSGCitaDisponibilidadFecha_To", localUtil.format(AV100TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadHoraInicio") == 0 )
         {
            AV101TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101TFSGCitaDisponibilidadHoraInicio", localUtil.ttoc( AV101TFSGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV102TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102TFSGCitaDisponibilidadHoraInicio_To", localUtil.ttoc( AV102TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV102TFSGCitaDisponibilidadHoraInicio_To) )
            {
               AV102TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV102TFSGCitaDisponibilidadHoraInicio_To)), (byte)(GXutil.month( AV102TFSGCitaDisponibilidadHoraInicio_To)), (byte)(GXutil.day( AV102TFSGCitaDisponibilidadHoraInicio_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV102TFSGCitaDisponibilidadHoraInicio_To", localUtil.ttoc( AV102TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadEspecialidadNombre") == 0 )
         {
            AV97TFSGCitaDisponibilidadEspecialidadNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFSGCitaDisponibilidadEspecialidadNombre", AV97TFSGCitaDisponibilidadEspecialidadNombre);
            AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadSedeNombre") == 0 )
         {
            AV113TFSGCitaDisponibilidadSedeNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113TFSGCitaDisponibilidadSedeNombre", AV113TFSGCitaDisponibilidadSedeNombre);
            AV114TFSGCitaDisponibilidadSedeNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV114TFSGCitaDisponibilidadSedeNombre_Sel", AV114TFSGCitaDisponibilidadSedeNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadClinicaNombre") == 0 )
         {
            AV93TFSGCitaDisponibilidadClinicaNombre = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFSGCitaDisponibilidadClinicaNombre", AV93TFSGCitaDisponibilidadClinicaNombre);
            AV94TFSGCitaDisponibilidadClinicaNombre_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94TFSGCitaDisponibilidadClinicaNombre_Sel", AV94TFSGCitaDisponibilidadClinicaNombre_Sel);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaEstadoCita") == 0 )
         {
            AV59TFCitaEstadoCita_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFCitaEstadoCita_SelsJson", AV59TFCitaEstadoCita_SelsJson);
            AV58TFCitaEstadoCita_Sels.fromJSonString(AV59TFCitaEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaEstadoPago") == 0 )
         {
            AV61TFCitaEstadoPago_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFCitaEstadoPago_SelsJson", AV61TFCitaEstadoPago_SelsJson);
            AV60TFCitaEstadoPago_Sels.fromJSonString(AV61TFCitaEstadoPago_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "SGCitaDisponibilidadHoraFin") == 0 )
         {
            AV123TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtext_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123TFSGCitaDisponibilidadHoraFin", localUtil.ttoc( AV123TFSGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV124TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( Ddo_grid_Filteredtextto_get, 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV124TFSGCitaDisponibilidadHoraFin_To", localUtil.ttoc( AV124TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            if ( ! GXutil.dateCompare(GXutil.nullDate(), AV124TFSGCitaDisponibilidadHoraFin_To) )
            {
               AV124TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ymdhmsToT( (short)(GXutil.year( AV124TFSGCitaDisponibilidadHoraFin_To)), (byte)(GXutil.month( AV124TFSGCitaDisponibilidadHoraFin_To)), (byte)(GXutil.day( AV124TFSGCitaDisponibilidadHoraFin_To)), (byte)(23), (byte)(59), (byte)(59))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV124TFSGCitaDisponibilidadHoraFin_To", localUtil.ttoc( AV124TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            }
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "CitaArchivoExtencion") == 0 )
         {
            AV128TFCitaArchivoExtencion = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV128TFCitaArchivoExtencion", AV128TFCitaArchivoExtencion);
            AV129TFCitaArchivoExtencion_Sel = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFCitaArchivoExtencion_Sel", AV129TFCitaArchivoExtencion_Sel);
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV60TFCitaEstadoPago_Sels", AV60TFCitaEstadoPago_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV58TFCitaEstadoCita_Sels", AV58TFCitaEstadoCita_Sels);
   }

   private void e162P2( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      cmbavActionscita.removeAllItems();
      cmbavActionscita.addItem("0", ";fa fa-bars", (short)(0));
      cmbavActionscita.addItem("1", "Ver Informe Cita", (short)(0));
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(29) ;
      }
      sendrow_292( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_29_Refreshing )
      {
         httpContext.doAjaxLoad(29, GridRow);
      }
      /*  Sending Event outputs  */
      cmbavActionscita.setValue( GXutil.trim( GXutil.str( AV6ActionsCita, 4, 0)) );
   }

   public void S132( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV39OrderedBy, 4, 0))+":"+(AV41OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S152( )
   {
      /* 'DO INFORMECITA' Routine */
      returnInSub = false ;
      callWebObject(formatLink("com.projectthani.wpdetallecita", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A19CitaId,8,0))}, new String[] {"CitaId"}) );
      httpContext.wjLocDisableFrm = (byte)(1) ;
   }

   public void S122( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV45Session.getValue(AV164Pgmname+"GridState"), "") == 0 )
      {
         AV26GridState.fromxml(new com.projectthani.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV164Pgmname+"GridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV45Session.getValue(AV164Pgmname+"GridState"), null, null);
      }
      AV39OrderedBy = AV26GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV39OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV39OrderedBy), 4, 0));
      AV41OrderedDsc = AV26GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41OrderedDsc", AV41OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S132 ();
      if (returnInSub) return;
      AV165GXV1 = 1 ;
      while ( AV165GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)((com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV165GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") == 0 )
         {
            AV23FilterFullText = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23FilterFullText", AV23FilterFullText);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAID") == 0 )
         {
            AV67TFCitaId = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV67TFCitaId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV67TFCitaId), 8, 0));
            AV68TFCitaId_To = (int)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68TFCitaId_To", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV68TFCitaId_To), 8, 0));
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE") == 0 )
         {
            AV51TFCitaCode = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV51TFCitaCode", AV51TFCitaCode);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITACODE_SEL") == 0 )
         {
            AV52TFCitaCode_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV52TFCitaCode_Sel", AV52TFCitaCode_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO") == 0 )
         {
            AV89TFPacienteNroDocumento = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV89TFPacienteNroDocumento", AV89TFPacienteNroDocumento);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENRODOCUMENTO_SEL") == 0 )
         {
            AV90TFPacienteNroDocumento_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV90TFPacienteNroDocumento_Sel", AV90TFPacienteNroDocumento_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO") == 0 )
         {
            AV83TFPacienteApellidoPaterno = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV83TFPacienteApellidoPaterno", AV83TFPacienteApellidoPaterno);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOPATERNO_SEL") == 0 )
         {
            AV84TFPacienteApellidoPaterno_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV84TFPacienteApellidoPaterno_Sel", AV84TFPacienteApellidoPaterno_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO") == 0 )
         {
            AV81TFPacienteApellidoMaterno = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV81TFPacienteApellidoMaterno", AV81TFPacienteApellidoMaterno);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTEAPELLIDOMATERNO_SEL") == 0 )
         {
            AV82TFPacienteApellidoMaterno_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV82TFPacienteApellidoMaterno_Sel", AV82TFPacienteApellidoMaterno_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES") == 0 )
         {
            AV87TFPacienteNombres = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV87TFPacienteNombres", AV87TFPacienteNombres);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPACIENTENOMBRES_SEL") == 0 )
         {
            AV88TFPacienteNombres_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV88TFPacienteNombres_Sel", AV88TFPacienteNombres_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADFECHA") == 0 )
         {
            AV99TFSGCitaDisponibilidadFecha = localUtil.ctod( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV99TFSGCitaDisponibilidadFecha", localUtil.format(AV99TFSGCitaDisponibilidadFecha, "99/99/99"));
            AV100TFSGCitaDisponibilidadFecha_To = localUtil.ctod( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV100TFSGCitaDisponibilidadFecha_To", localUtil.format(AV100TFSGCitaDisponibilidadFecha_To, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAINICIO") == 0 )
         {
            AV101TFSGCitaDisponibilidadHoraInicio = GXutil.resetDate(localUtil.ctot( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV101TFSGCitaDisponibilidadHoraInicio", localUtil.ttoc( AV101TFSGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " "));
            AV102TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetDate(localUtil.ctot( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV102TFSGCitaDisponibilidadHoraInicio_To", localUtil.ttoc( AV102TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "));
            AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate = GXutil.resetTime(AV101TFSGCitaDisponibilidadHoraInicio) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate", localUtil.format(AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate, "99/99/99"));
            AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo = GXutil.resetTime(AV102TFSGCitaDisponibilidadHoraInicio_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo", localUtil.format(AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE") == 0 )
         {
            AV97TFSGCitaDisponibilidadEspecialidadNombre = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV97TFSGCitaDisponibilidadEspecialidadNombre", AV97TFSGCitaDisponibilidadEspecialidadNombre);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL") == 0 )
         {
            AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel", AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE") == 0 )
         {
            AV113TFSGCitaDisponibilidadSedeNombre = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV113TFSGCitaDisponibilidadSedeNombre", AV113TFSGCitaDisponibilidadSedeNombre);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADSEDENOMBRE_SEL") == 0 )
         {
            AV114TFSGCitaDisponibilidadSedeNombre_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV114TFSGCitaDisponibilidadSedeNombre_Sel", AV114TFSGCitaDisponibilidadSedeNombre_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE") == 0 )
         {
            AV93TFSGCitaDisponibilidadClinicaNombre = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV93TFSGCitaDisponibilidadClinicaNombre", AV93TFSGCitaDisponibilidadClinicaNombre);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADCLINICANOMBRE_SEL") == 0 )
         {
            AV94TFSGCitaDisponibilidadClinicaNombre_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV94TFSGCitaDisponibilidadClinicaNombre_Sel", AV94TFSGCitaDisponibilidadClinicaNombre_Sel);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAESTADOCITA_SEL") == 0 )
         {
            AV59TFCitaEstadoCita_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV59TFCitaEstadoCita_SelsJson", AV59TFCitaEstadoCita_SelsJson);
            AV58TFCitaEstadoCita_Sels.fromJSonString(AV59TFCitaEstadoCita_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAESTADOPAGO_SEL") == 0 )
         {
            AV61TFCitaEstadoPago_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV61TFCitaEstadoPago_SelsJson", AV61TFCitaEstadoPago_SelsJson);
            AV60TFCitaEstadoPago_Sels.fromJSonString(AV61TFCitaEstadoPago_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSGCITADISPONIBILIDADHORAFIN") == 0 )
         {
            AV123TFSGCitaDisponibilidadHoraFin = GXutil.resetDate(localUtil.ctot( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV123TFSGCitaDisponibilidadHoraFin", localUtil.ttoc( AV123TFSGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " "));
            AV124TFSGCitaDisponibilidadHoraFin_To = GXutil.resetDate(localUtil.ctot( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), 3)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV124TFSGCitaDisponibilidadHoraFin_To", localUtil.ttoc( AV124TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "));
            AV125DDO_SGCitaDisponibilidadHoraFinAuxDate = GXutil.resetTime(AV123TFSGCitaDisponibilidadHoraFin) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV125DDO_SGCitaDisponibilidadHoraFinAuxDate", localUtil.format(AV125DDO_SGCitaDisponibilidadHoraFinAuxDate, "99/99/99"));
            AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo = GXutil.resetTime(AV124TFSGCitaDisponibilidadHoraFin_To) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo", localUtil.format(AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo, "99/99/99"));
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAARCHIVOEXTENCION") == 0 )
         {
            AV128TFCitaArchivoExtencion = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV128TFCitaArchivoExtencion", AV128TFCitaArchivoExtencion);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCITAARCHIVOEXTENCION_SEL") == 0 )
         {
            AV129TFCitaArchivoExtencion_Sel = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV129TFCitaArchivoExtencion_Sel", AV129TFCitaArchivoExtencion_Sel);
         }
         AV165GXV1 = (int)(AV165GXV1+1) ;
      }
      GXt_char4 = "" ;
      GXv_char5[0] = GXt_char4 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV52TFCitaCode_Sel)==0), AV52TFCitaCode_Sel, GXv_char5) ;
      wpbandejacitas_impl.this.GXt_char4 = GXv_char5[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV90TFPacienteNroDocumento_Sel)==0), AV90TFPacienteNroDocumento_Sel, GXv_char7) ;
      wpbandejacitas_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV84TFPacienteApellidoPaterno_Sel)==0), AV84TFPacienteApellidoPaterno_Sel, GXv_char9) ;
      wpbandejacitas_impl.this.GXt_char8 = GXv_char9[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV82TFPacienteApellidoMaterno_Sel)==0), AV82TFPacienteApellidoMaterno_Sel, GXv_char11) ;
      wpbandejacitas_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV88TFPacienteNombres_Sel)==0), AV88TFPacienteNombres_Sel, GXv_char13) ;
      wpbandejacitas_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0), AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, GXv_char15) ;
      wpbandejacitas_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV114TFSGCitaDisponibilidadSedeNombre_Sel)==0), AV114TFSGCitaDisponibilidadSedeNombre_Sel, GXv_char17) ;
      wpbandejacitas_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV94TFSGCitaDisponibilidadClinicaNombre_Sel)==0), AV94TFSGCitaDisponibilidadClinicaNombre_Sel, GXv_char19) ;
      wpbandejacitas_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV58TFCitaEstadoCita_Sels.size()==0), AV59TFCitaEstadoCita_SelsJson, GXv_char21) ;
      wpbandejacitas_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV60TFCitaEstadoPago_Sels.size()==0), AV61TFCitaEstadoPago_SelsJson, GXv_char23) ;
      wpbandejacitas_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV129TFCitaArchivoExtencion_Sel)==0), AV129TFCitaArchivoExtencion_Sel, GXv_char25) ;
      wpbandejacitas_impl.this.GXt_char24 = GXv_char25[0] ;
      Ddo_grid_Selectedvalue_set = "|"+GXt_char4+"|"+GXt_char6+"|"+GXt_char8+"|"+GXt_char10+"|"+GXt_char12+"|||"+GXt_char14+"|"+GXt_char16+"|"+GXt_char18+"|"+GXt_char20+"|"+GXt_char22+"||"+GXt_char24 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char24 = "" ;
      GXv_char25[0] = GXt_char24 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV51TFCitaCode)==0), AV51TFCitaCode, GXv_char25) ;
      wpbandejacitas_impl.this.GXt_char24 = GXv_char25[0] ;
      GXt_char22 = "" ;
      GXv_char23[0] = GXt_char22 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV89TFPacienteNroDocumento)==0), AV89TFPacienteNroDocumento, GXv_char23) ;
      wpbandejacitas_impl.this.GXt_char22 = GXv_char23[0] ;
      GXt_char20 = "" ;
      GXv_char21[0] = GXt_char20 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV83TFPacienteApellidoPaterno)==0), AV83TFPacienteApellidoPaterno, GXv_char21) ;
      wpbandejacitas_impl.this.GXt_char20 = GXv_char21[0] ;
      GXt_char18 = "" ;
      GXv_char19[0] = GXt_char18 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV81TFPacienteApellidoMaterno)==0), AV81TFPacienteApellidoMaterno, GXv_char19) ;
      wpbandejacitas_impl.this.GXt_char18 = GXv_char19[0] ;
      GXt_char16 = "" ;
      GXv_char17[0] = GXt_char16 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV87TFPacienteNombres)==0), AV87TFPacienteNombres, GXv_char17) ;
      wpbandejacitas_impl.this.GXt_char16 = GXv_char17[0] ;
      GXt_char14 = "" ;
      GXv_char15[0] = GXt_char14 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV97TFSGCitaDisponibilidadEspecialidadNombre)==0), AV97TFSGCitaDisponibilidadEspecialidadNombre, GXv_char15) ;
      wpbandejacitas_impl.this.GXt_char14 = GXv_char15[0] ;
      GXt_char12 = "" ;
      GXv_char13[0] = GXt_char12 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV113TFSGCitaDisponibilidadSedeNombre)==0), AV113TFSGCitaDisponibilidadSedeNombre, GXv_char13) ;
      wpbandejacitas_impl.this.GXt_char12 = GXv_char13[0] ;
      GXt_char10 = "" ;
      GXv_char11[0] = GXt_char10 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV93TFSGCitaDisponibilidadClinicaNombre)==0), AV93TFSGCitaDisponibilidadClinicaNombre, GXv_char11) ;
      wpbandejacitas_impl.this.GXt_char10 = GXv_char11[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new com.projectthani.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV128TFCitaArchivoExtencion)==0), AV128TFCitaArchivoExtencion, GXv_char9) ;
      wpbandejacitas_impl.this.GXt_char8 = GXv_char9[0] ;
      Ddo_grid_Filteredtext_set = ((0==AV67TFCitaId) ? "" : GXutil.str( AV67TFCitaId, 8, 0))+"|"+GXt_char24+"|"+GXt_char22+"|"+GXt_char20+"|"+GXt_char18+"|"+GXt_char16+"|"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV99TFSGCitaDisponibilidadFecha)) ? "" : localUtil.dtoc( AV99TFSGCitaDisponibilidadFecha, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV101TFSGCitaDisponibilidadHoraInicio) ? "" : localUtil.dtoc( AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate, 3, "/"))+"|"+GXt_char14+"|"+GXt_char12+"|"+GXt_char10+"|||"+(GXutil.dateCompare(GXutil.nullDate(), AV123TFSGCitaDisponibilidadHoraFin) ? "" : localUtil.dtoc( AV125DDO_SGCitaDisponibilidadHoraFinAuxDate, 3, "/"))+"|"+GXt_char8 ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = ((0==AV68TFCitaId_To) ? "" : GXutil.str( AV68TFCitaId_To, 8, 0))+"||||||"+(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV100TFSGCitaDisponibilidadFecha_To)) ? "" : localUtil.dtoc( AV100TFSGCitaDisponibilidadFecha_To, 3, "/"))+"|"+(GXutil.dateCompare(GXutil.nullDate(), AV102TFSGCitaDisponibilidadHoraInicio_To) ? "" : localUtil.dtoc( AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo, 3, "/"))+"||||||"+(GXutil.dateCompare(GXutil.nullDate(), AV124TFSGCitaDisponibilidadHoraFin_To) ? "" : localUtil.dtoc( AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo, 3, "/"))+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV26GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV26GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV26GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S142( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV26GridState.fromxml(AV45Session.getValue(AV164Pgmname+"GridState"), null, null);
      AV26GridState.setgxTv_SdtWWPGridState_Orderedby( AV39OrderedBy );
      AV26GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV41OrderedDsc );
      AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState26, "FILTERFULLTEXT", !(GXutil.strcmp("", AV23FilterFullText)==0), (short)(0), AV23FilterFullText, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFCITAID", !((0==AV67TFCitaId)&&(0==AV68TFCitaId_To)), (short)(0), GXutil.trim( GXutil.str( AV67TFCitaId, 8, 0)), GXutil.trim( GXutil.str( AV68TFCitaId_To, 8, 0))) ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFCITACODE", !(GXutil.strcmp("", AV51TFCitaCode)==0), (short)(0), AV51TFCitaCode, "", !(GXutil.strcmp("", AV52TFCitaCode_Sel)==0), AV52TFCitaCode_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFPACIENTENRODOCUMENTO", !(GXutil.strcmp("", AV89TFPacienteNroDocumento)==0), (short)(0), AV89TFPacienteNroDocumento, "", !(GXutil.strcmp("", AV90TFPacienteNroDocumento_Sel)==0), AV90TFPacienteNroDocumento_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFPACIENTEAPELLIDOPATERNO", !(GXutil.strcmp("", AV83TFPacienteApellidoPaterno)==0), (short)(0), AV83TFPacienteApellidoPaterno, "", !(GXutil.strcmp("", AV84TFPacienteApellidoPaterno_Sel)==0), AV84TFPacienteApellidoPaterno_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFPACIENTEAPELLIDOMATERNO", !(GXutil.strcmp("", AV81TFPacienteApellidoMaterno)==0), (short)(0), AV81TFPacienteApellidoMaterno, "", !(GXutil.strcmp("", AV82TFPacienteApellidoMaterno_Sel)==0), AV82TFPacienteApellidoMaterno_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFPACIENTENOMBRES", !(GXutil.strcmp("", AV87TFPacienteNombres)==0), (short)(0), AV87TFPacienteNombres, "", !(GXutil.strcmp("", AV88TFPacienteNombres_Sel)==0), AV88TFPacienteNombres_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFSGCITADISPONIBILIDADFECHA", !(GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV99TFSGCitaDisponibilidadFecha))&&GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV100TFSGCitaDisponibilidadFecha_To))), (short)(0), GXutil.trim( localUtil.dtoc( AV99TFSGCitaDisponibilidadFecha, 3, "/")), GXutil.trim( localUtil.dtoc( AV100TFSGCitaDisponibilidadFecha_To, 3, "/"))) ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFSGCITADISPONIBILIDADHORAINICIO", !(GXutil.dateCompare(GXutil.nullDate(), AV101TFSGCitaDisponibilidadHoraInicio)&&GXutil.dateCompare(GXutil.nullDate(), AV102TFSGCitaDisponibilidadHoraInicio_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV101TFSGCitaDisponibilidadHoraInicio, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV102TFSGCitaDisponibilidadHoraInicio_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFSGCITADISPONIBILIDADESPECIALIDADNOMBRE", !(GXutil.strcmp("", AV97TFSGCitaDisponibilidadEspecialidadNombre)==0), (short)(0), AV97TFSGCitaDisponibilidadEspecialidadNombre, "", !(GXutil.strcmp("", AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel)==0), AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFSGCITADISPONIBILIDADSEDENOMBRE", !(GXutil.strcmp("", AV113TFSGCitaDisponibilidadSedeNombre)==0), (short)(0), AV113TFSGCitaDisponibilidadSedeNombre, "", !(GXutil.strcmp("", AV114TFSGCitaDisponibilidadSedeNombre_Sel)==0), AV114TFSGCitaDisponibilidadSedeNombre_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFSGCITADISPONIBILIDADCLINICANOMBRE", !(GXutil.strcmp("", AV93TFSGCitaDisponibilidadClinicaNombre)==0), (short)(0), AV93TFSGCitaDisponibilidadClinicaNombre, "", !(GXutil.strcmp("", AV94TFSGCitaDisponibilidadClinicaNombre_Sel)==0), AV94TFSGCitaDisponibilidadClinicaNombre_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFCITAESTADOCITA_SEL", !(AV58TFCitaEstadoCita_Sels.size()==0), (short)(0), AV58TFCitaEstadoCita_Sels.toJSonString(false), "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFCITAESTADOPAGO_SEL", !(AV60TFCitaEstadoPago_Sels.size()==0), (short)(0), AV60TFCitaEstadoPago_Sels.toJSonString(false), "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFSGCITADISPONIBILIDADHORAFIN", !(GXutil.dateCompare(GXutil.nullDate(), AV123TFSGCitaDisponibilidadHoraFin)&&GXutil.dateCompare(GXutil.nullDate(), AV124TFSGCitaDisponibilidadHoraFin_To)), (short)(0), GXutil.trim( localUtil.ttoc( AV123TFSGCitaDisponibilidadHoraFin, 0, 5, 0, 3, "/", ":", " ")), GXutil.trim( localUtil.ttoc( AV124TFSGCitaDisponibilidadHoraFin_To, 0, 5, 0, 3, "/", ":", " "))) ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      GXv_SdtWWPGridState26[0] = AV26GridState;
      new com.projectthani.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState26, "TFCITAARCHIVOEXTENCION", !(GXutil.strcmp("", AV128TFCitaArchivoExtencion)==0), (short)(0), AV128TFCitaArchivoExtencion, "", !(GXutil.strcmp("", AV129TFCitaArchivoExtencion_Sel)==0), AV129TFCitaArchivoExtencion_Sel, "") ;
      AV26GridState = GXv_SdtWWPGridState26[0] ;
      AV26GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV26GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new com.projectthani.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV164Pgmname+"GridState", AV26GridState.toxml(false, true, "WWPGridState", "ProjectThani")) ;
   }

   public void S112( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV115TrnContext = (com.projectthani.wwpbaseobjects.SdtWWPTransactionContext)new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV115TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV164Pgmname );
      AV115TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV115TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV28HTTPRequest.getScriptName()+"?"+AV28HTTPRequest.getQuerystring() );
      AV115TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "Cita" );
      AV45Session.setValue("TrnContext", AV115TrnContext.toxml(false, true, "WWPTransactionContext", "ProjectThani"));
   }

   public void wb_table1_13_2P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablerightheader_Internalname, tblTablerightheader_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table2_16_2P2( true) ;
      }
      else
      {
         wb_table2_16_2P2( false) ;
      }
      return  ;
   }

   public void wb_table2_16_2P2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_13_2P2e( true) ;
      }
      else
      {
         wb_table1_13_2P2e( false) ;
      }
   }

   public void wb_table2_16_2P2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblTablefilters_Internalname, tblTablefilters_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavFilterfulltext_Internalname, "Filter Full Text", "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 20,'',false,'" + sGXsfl_29_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavFilterfulltext_Internalname, AV23FilterFullText, GXutil.rtrim( localUtil.format( AV23FilterFullText, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,20);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "Buscar", edtavFilterfulltext_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavFilterfulltext_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "WWPFullTextFilter", "left", true, "", "HLP_WPBandejaCitas.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_16_2P2e( true) ;
      }
      else
      {
         wb_table2_16_2P2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
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
      pa2P2( ) ;
      ws2P2( ) ;
      we2P2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
      httpContext.AddStyleSheetFile("DVelop/Shared/daterangepicker/daterangepicker.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110334644", true, true);
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
      httpContext.AddJavascriptSource("wpbandejacitas.js", "?20225110334645", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/locales.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/wwp-daterangepicker.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/moment.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/daterangepicker/daterangepicker.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DateRangePicker/DateRangePickerRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_292( )
   {
      cmbavActionscita.setInternalname( "vACTIONSCITA_"+sGXsfl_29_idx );
      edtCitaId_Internalname = "CITAID_"+sGXsfl_29_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_29_idx ;
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_29_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_29_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_29_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_29_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_29_idx ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = "SGCITADISPONIBILIDADHORAINICIO_"+sGXsfl_29_idx ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE_"+sGXsfl_29_idx ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = "SGCITADISPONIBILIDADSEDENOMBRE_"+sGXsfl_29_idx ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE_"+sGXsfl_29_idx ;
      cmbCitaEstadoCita.setInternalname( "CITAESTADOCITA_"+sGXsfl_29_idx );
      cmbCitaEstadoPago.setInternalname( "CITAESTADOPAGO_"+sGXsfl_29_idx );
      edtSGCitaDisponibilidadHoraFin_Internalname = "SGCITADISPONIBILIDADHORAFIN_"+sGXsfl_29_idx ;
      edtCitaArchivoExtencion_Internalname = "CITAARCHIVOEXTENCION_"+sGXsfl_29_idx ;
   }

   public void subsflControlProps_fel_292( )
   {
      cmbavActionscita.setInternalname( "vACTIONSCITA_"+sGXsfl_29_fel_idx );
      edtCitaId_Internalname = "CITAID_"+sGXsfl_29_fel_idx ;
      edtCitaCode_Internalname = "CITACODE_"+sGXsfl_29_fel_idx ;
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO_"+sGXsfl_29_fel_idx ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO_"+sGXsfl_29_fel_idx ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO_"+sGXsfl_29_fel_idx ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES_"+sGXsfl_29_fel_idx ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA_"+sGXsfl_29_fel_idx ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = "SGCITADISPONIBILIDADHORAINICIO_"+sGXsfl_29_fel_idx ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE_"+sGXsfl_29_fel_idx ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = "SGCITADISPONIBILIDADSEDENOMBRE_"+sGXsfl_29_fel_idx ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE_"+sGXsfl_29_fel_idx ;
      cmbCitaEstadoCita.setInternalname( "CITAESTADOCITA_"+sGXsfl_29_fel_idx );
      cmbCitaEstadoPago.setInternalname( "CITAESTADOPAGO_"+sGXsfl_29_fel_idx );
      edtSGCitaDisponibilidadHoraFin_Internalname = "SGCITADISPONIBILIDADHORAFIN_"+sGXsfl_29_fel_idx ;
      edtCitaArchivoExtencion_Internalname = "CITAARCHIVOEXTENCION_"+sGXsfl_29_fel_idx ;
   }

   public void sendrow_292( )
   {
      subsflControlProps_292( ) ;
      wb2P0( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_29_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_29_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_29_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         TempTags = " " + ((cmbavActionscita.getEnabled()!=0)&&(cmbavActionscita.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 30,'',false,'"+sGXsfl_29_idx+"',29)\"" : " ") ;
         if ( ( cmbavActionscita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vACTIONSCITA_" + sGXsfl_29_idx ;
            cmbavActionscita.setName( GXCCtl );
            cmbavActionscita.setWebtags( "" );
            if ( cmbavActionscita.getItemCount() > 0 )
            {
               AV6ActionsCita = (short)(GXutil.lval( cmbavActionscita.getValidValue(GXutil.trim( GXutil.str( AV6ActionsCita, 4, 0))))) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavActionscita.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ActionsCita), 4, 0));
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavActionscita,cmbavActionscita.getInternalname(),GXutil.trim( GXutil.str( AV6ActionsCita, 4, 0)),Integer.valueOf(1),cmbavActionscita.getJsonclick(),Integer.valueOf(7),"'"+""+"'"+",false,"+"'"+"e172p2_client"+"'","int","",Integer.valueOf(-1),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","ConvertToDDO","WWActionGroupColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavActionscita.getEnabled()!=0)&&(cmbavActionscita.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,30);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavActionscita.setValue( GXutil.trim( GXutil.str( AV6ActionsCita, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavActionscita.getInternalname(), "Values", cmbavActionscita.ToJavascriptSource(), !bGXsfl_29_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaId_Internalname,GXutil.ltrim( localUtil.ntoc( A19CitaId, (byte)(8), (byte)(0), ",", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A19CitaId), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaCode_Internalname,A64CitaCode,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaCode_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNroDocumento_Internalname,A106PacienteNroDocumento,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNroDocumento_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(15),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoPaterno_Internalname,A103PacienteApellidoPaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoPaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteApellidoMaterno_Internalname,A104PacienteApellidoMaterno,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteApellidoMaterno_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtPacienteNombres_Internalname,A105PacienteNombres,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtPacienteNombres_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadFecha_Internalname,localUtil.format(A66SGCitaDisponibilidadFecha, "99/99/99"),localUtil.format( A66SGCitaDisponibilidadFecha, "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadHoraInicio_Internalname,localUtil.ttoc( A68SGCitaDisponibilidadHoraInicio, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A68SGCitaDisponibilidadHoraInicio, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadHoraInicio_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadEspecialidadNombre_Internalname,A146SGCitaDisponibilidadEspecialidadNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadSedeNombre_Internalname,A73SGCitaDisponibilidadSedeNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadSedeNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(80),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadClinicaNombre_Internalname,A78SGCitaDisponibilidadClinicaNombre,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadClinicaNombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbCitaEstadoCita.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITAESTADOCITA_" + sGXsfl_29_idx ;
            cmbCitaEstadoCita.setName( GXCCtl );
            cmbCitaEstadoCita.setWebtags( "" );
            cmbCitaEstadoCita.addItem("R", "Registrado", (short)(0));
            cmbCitaEstadoCita.addItem("C", "Confirmado", (short)(0));
            cmbCitaEstadoCita.addItem("A", "En Atención", (short)(0));
            cmbCitaEstadoCita.addItem("F", "Finalizado", (short)(0));
            cmbCitaEstadoCita.addItem("X", "Cancelado", (short)(0));
            cmbCitaEstadoCita.addItem("N", "No se presentó", (short)(0));
            if ( cmbCitaEstadoCita.getItemCount() > 0 )
            {
               A89CitaEstadoCita = cmbCitaEstadoCita.getValidValue(A89CitaEstadoCita) ;
               n89CitaEstadoCita = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaEstadoCita,cmbCitaEstadoCita.getInternalname(),GXutil.rtrim( A89CitaEstadoCita),Integer.valueOf(1),cmbCitaEstadoCita.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaEstadoCita.setValue( GXutil.rtrim( A89CitaEstadoCita) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoCita.getInternalname(), "Values", cmbCitaEstadoCita.ToJavascriptSource(), !bGXsfl_29_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbCitaEstadoPago.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "CITAESTADOPAGO_" + sGXsfl_29_idx ;
            cmbCitaEstadoPago.setName( GXCCtl );
            cmbCitaEstadoPago.setWebtags( "" );
            cmbCitaEstadoPago.addItem("S", "Sin Pago", (short)(0));
            cmbCitaEstadoPago.addItem("P", "Pendiente", (short)(0));
            cmbCitaEstadoPago.addItem("G", "Pagado", (short)(0));
            if ( cmbCitaEstadoPago.getItemCount() > 0 )
            {
               A102CitaEstadoPago = cmbCitaEstadoPago.getValidValue(A102CitaEstadoPago) ;
               n102CitaEstadoPago = false ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbCitaEstadoPago,cmbCitaEstadoPago.getInternalname(),GXutil.rtrim( A102CitaEstadoPago),Integer.valueOf(1),cmbCitaEstadoPago.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn hidden-xs","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbCitaEstadoPago.setValue( GXutil.rtrim( A102CitaEstadoPago) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCitaEstadoPago.getInternalname(), "Values", cmbCitaEstadoPago.ToJavascriptSource(), !bGXsfl_29_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtSGCitaDisponibilidadHoraFin_Internalname,localUtil.ttoc( A387SGCitaDisponibilidadHoraFin, 10, 8, 0, 3, "/", ":", " "),localUtil.format( A387SGCitaDisponibilidadHoraFin, "99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtSGCitaDisponibilidadHoraFin_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCitaArchivoExtencion_Internalname,A333CitaArchivoExtencion,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCitaArchivoExtencion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(29),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2P2( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_29_idx = ((subGrid_Islastpage==1)&&(nGXsfl_29_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_29_idx+1) ;
         sGXsfl_29_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_29_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_292( ) ;
      }
      /* End function sendrow_292 */
   }

   public void init_default_properties( )
   {
      edtavFilterfulltext_Internalname = "vFILTERFULLTEXT" ;
      tblTablefilters_Internalname = "TABLEFILTERS" ;
      tblTablerightheader_Internalname = "TABLERIGHTHEADER" ;
      divTableheader_Internalname = "TABLEHEADER" ;
      Dvpanel_tableheader_Internalname = "DVPANEL_TABLEHEADER" ;
      cmbavActionscita.setInternalname( "vACTIONSCITA" );
      edtCitaId_Internalname = "CITAID" ;
      edtCitaCode_Internalname = "CITACODE" ;
      edtPacienteNroDocumento_Internalname = "PACIENTENRODOCUMENTO" ;
      edtPacienteApellidoPaterno_Internalname = "PACIENTEAPELLIDOPATERNO" ;
      edtPacienteApellidoMaterno_Internalname = "PACIENTEAPELLIDOMATERNO" ;
      edtPacienteNombres_Internalname = "PACIENTENOMBRES" ;
      edtSGCitaDisponibilidadFecha_Internalname = "SGCITADISPONIBILIDADFECHA" ;
      edtSGCitaDisponibilidadHoraInicio_Internalname = "SGCITADISPONIBILIDADHORAINICIO" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Internalname = "SGCITADISPONIBILIDADESPECIALIDADNOMBRE" ;
      edtSGCitaDisponibilidadSedeNombre_Internalname = "SGCITADISPONIBILIDADSEDENOMBRE" ;
      edtSGCitaDisponibilidadClinicaNombre_Internalname = "SGCITADISPONIBILIDADCLINICANOMBRE" ;
      cmbCitaEstadoCita.setInternalname( "CITAESTADOCITA" );
      cmbCitaEstadoPago.setInternalname( "CITAESTADOPAGO" );
      edtSGCitaDisponibilidadHoraFin_Internalname = "SGCITADISPONIBILIDADHORAFIN" ;
      edtCitaArchivoExtencion_Internalname = "CITAARCHIVOEXTENCION" ;
      Gridpaginationbar_Internalname = "GRIDPAGINATIONBAR" ;
      divGridtablewithpaginationbar_Internalname = "GRIDTABLEWITHPAGINATIONBAR" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname = "vDDO_SGCITADISPONIBILIDADFECHAAUXDATETEXT" ;
      Tfsgcitadisponibilidadfecha_rangepicker_Internalname = "TFSGCITADISPONIBILIDADFECHA_RANGEPICKER" ;
      divDdo_sgcitadisponibilidadfechaauxdates_Internalname = "DDO_SGCITADISPONIBILIDADFECHAAUXDATES" ;
      edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname = "vDDO_SGCITADISPONIBILIDADHORAINICIOAUXDATETEXT" ;
      Tfsgcitadisponibilidadhorainicio_rangepicker_Internalname = "TFSGCITADISPONIBILIDADHORAINICIO_RANGEPICKER" ;
      divDdo_sgcitadisponibilidadhorainicioauxdates_Internalname = "DDO_SGCITADISPONIBILIDADHORAINICIOAUXDATES" ;
      edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname = "vDDO_SGCITADISPONIBILIDADHORAFINAUXDATETEXT" ;
      Tfsgcitadisponibilidadhorafin_rangepicker_Internalname = "TFSGCITADISPONIBILIDADHORAFIN_RANGEPICKER" ;
      divDdo_sgcitadisponibilidadhorafinauxdates_Internalname = "DDO_SGCITADISPONIBILIDADHORAFINAUXDATES" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      edtCitaArchivoExtencion_Jsonclick = "" ;
      edtSGCitaDisponibilidadHoraFin_Jsonclick = "" ;
      cmbCitaEstadoPago.setJsonclick( "" );
      cmbCitaEstadoCita.setJsonclick( "" );
      edtSGCitaDisponibilidadClinicaNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadSedeNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick = "" ;
      edtSGCitaDisponibilidadHoraInicio_Jsonclick = "" ;
      edtSGCitaDisponibilidadFecha_Jsonclick = "" ;
      edtPacienteNombres_Jsonclick = "" ;
      edtPacienteApellidoMaterno_Jsonclick = "" ;
      edtPacienteApellidoPaterno_Jsonclick = "" ;
      edtPacienteNroDocumento_Jsonclick = "" ;
      edtCitaCode_Jsonclick = "" ;
      edtCitaId_Jsonclick = "" ;
      cmbavActionscita.setJsonclick( "" );
      cmbavActionscita.setVisible( -1 );
      cmbavActionscita.setEnabled( 1 );
      edtavFilterfulltext_Jsonclick = "" ;
      edtavFilterfulltext_Enabled = 1 ;
      edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Jsonclick = "" ;
      edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Jsonclick = "" ;
      edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick = "" ;
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Sortable = (byte)(0) ;
      subGrid_Header = "" ;
      subGrid_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( " Cita" );
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Datalistproc = "WPBandejaCitasGetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "|||||||||||R:Registrado,C:Confirmado,A:En Atención,F:Finalizado,X:Cancelado,N:No se presentó|S:Sin Pago,P:Pendiente,G:Pagado||" ;
      Ddo_grid_Allowmultipleselection = "|||||||||||T|T||" ;
      Ddo_grid_Datalisttype = "|Dynamic|Dynamic|Dynamic|Dynamic|Dynamic|||Dynamic|Dynamic|Dynamic|FixedValues|FixedValues||Dynamic" ;
      Ddo_grid_Includedatalist = "|T|T|T|T|T|||T|T|T|T|T||T" ;
      Ddo_grid_Filterisrange = "T||||||P|P||||||P|" ;
      Ddo_grid_Filtertype = "Numeric|Character|Character|Character|Character|Character|Date|Date|Character|Character|Character|||Date|Character" ;
      Ddo_grid_Includefilter = "T|T|T|T|T|T|T|T|T|T|T|||T|T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|1|3|4|5|6|7|8|9|10|11|12|13|14|15" ;
      Ddo_grid_Columnids = "1:CitaId|2:CitaCode|3:PacienteNroDocumento|4:PacienteApellidoPaterno|5:PacienteApellidoMaterno|6:PacienteNombres|7:SGCitaDisponibilidadFecha|8:SGCitaDisponibilidadHoraInicio|9:SGCitaDisponibilidadEspecialidadNombre|10:SGCitaDisponibilidadSedeNombre|11:SGCitaDisponibilidadClinicaNombre|12:CitaEstadoCita|13:CitaEstadoPago|14:SGCitaDisponibilidadHoraFin|15:CitaArchivoExtencion" ;
      Ddo_grid_Gridinternalname = "" ;
      Gridpaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridpaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridpaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridpaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridpaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridpaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridpaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridpaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridpaginationbar_Pagingcaptionposition = "Left" ;
      Gridpaginationbar_Pagingbuttonsposition = "Right" ;
      Gridpaginationbar_Pagestoshow = 5 ;
      Gridpaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridpaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridpaginationbar_Class = "PaginationBar" ;
      Dvpanel_tableheader_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Iconposition = "Right" ;
      Dvpanel_tableheader_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_tableheader_Title = "Opciones" ;
      Dvpanel_tableheader_Cls = "PanelNoHeader" ;
      Dvpanel_tableheader_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableheader_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableheader_Width = "100%" ;
      subGrid_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "vACTIONSCITA_" + sGXsfl_29_idx ;
      cmbavActionscita.setName( GXCCtl );
      cmbavActionscita.setWebtags( "" );
      if ( cmbavActionscita.getItemCount() > 0 )
      {
         AV6ActionsCita = (short)(GXutil.lval( cmbavActionscita.getValidValue(GXutil.trim( GXutil.str( AV6ActionsCita, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavActionscita.getInternalname(), GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ActionsCita), 4, 0));
      }
      GXCCtl = "CITAESTADOCITA_" + sGXsfl_29_idx ;
      cmbCitaEstadoCita.setName( GXCCtl );
      cmbCitaEstadoCita.setWebtags( "" );
      cmbCitaEstadoCita.addItem("R", "Registrado", (short)(0));
      cmbCitaEstadoCita.addItem("C", "Confirmado", (short)(0));
      cmbCitaEstadoCita.addItem("A", "En Atención", (short)(0));
      cmbCitaEstadoCita.addItem("F", "Finalizado", (short)(0));
      cmbCitaEstadoCita.addItem("X", "Cancelado", (short)(0));
      cmbCitaEstadoCita.addItem("N", "No se presentó", (short)(0));
      if ( cmbCitaEstadoCita.getItemCount() > 0 )
      {
         A89CitaEstadoCita = cmbCitaEstadoCita.getValidValue(A89CitaEstadoCita) ;
         n89CitaEstadoCita = false ;
      }
      GXCCtl = "CITAESTADOPAGO_" + sGXsfl_29_idx ;
      cmbCitaEstadoPago.setName( GXCCtl );
      cmbCitaEstadoPago.setWebtags( "" );
      cmbCitaEstadoPago.addItem("S", "Sin Pago", (short)(0));
      cmbCitaEstadoPago.addItem("P", "Pendiente", (short)(0));
      cmbCitaEstadoPago.addItem("G", "Pagado", (short)(0));
      if ( cmbCitaEstadoPago.getItemCount() > 0 )
      {
         A102CitaEstadoPago = cmbCitaEstadoPago.getValidValue(A102CitaEstadoPago) ;
         n102CitaEstadoPago = false ;
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV120SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV5ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV67TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV68TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV52TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV89TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV90TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV83TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV84TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV81TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV82TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV87TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV88TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV99TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV100TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV101TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV102TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV97TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV113TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV114TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV93TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV94TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV60TFCitaEstadoPago_Sels',fld:'vTFCITAESTADOPAGO_SELS',pic:''},{av:'AV123TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV124TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV128TFCitaArchivoExtencion',fld:'vTFCITAARCHIVOEXTENCION',pic:''},{av:'AV129TFCitaArchivoExtencion_Sel',fld:'vTFCITAARCHIVOEXTENCION_SEL',pic:''},{av:'AV164Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV39OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV41OrderedDsc',fld:'vORDEREDDSC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV24GridCurrentPage',fld:'vGRIDCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV25GridPageCount',fld:'vGRIDPAGECOUNT',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE","{handler:'e112P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV120SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV5ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV67TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV68TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV52TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV89TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV90TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV83TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV84TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV81TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV82TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV87TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV88TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV99TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV100TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV101TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV102TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV97TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV113TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV114TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV93TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV94TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV60TFCitaEstadoPago_Sels',fld:'vTFCITAESTADOPAGO_SELS',pic:''},{av:'AV123TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV124TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV128TFCitaArchivoExtencion',fld:'vTFCITAARCHIVOEXTENCION',pic:''},{av:'AV129TFCitaArchivoExtencion_Sel',fld:'vTFCITAARCHIVOEXTENCION_SEL',pic:''},{av:'AV164Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV39OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV41OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Gridpaginationbar_Selectedpage',ctrl:'GRIDPAGINATIONBAR',prop:'SelectedPage'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEPAGE",",oparms:[]}");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e122P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV120SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV5ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV67TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV68TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV52TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV89TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV90TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV83TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV84TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV81TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV82TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV87TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV88TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV99TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV100TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV101TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV102TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV97TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV113TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV114TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV93TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV94TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV60TFCitaEstadoPago_Sels',fld:'vTFCITAESTADOPAGO_SELS',pic:''},{av:'AV123TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV124TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV128TFCitaArchivoExtencion',fld:'vTFCITAARCHIVOEXTENCION',pic:''},{av:'AV129TFCitaArchivoExtencion_Sel',fld:'vTFCITAARCHIVOEXTENCION_SEL',pic:''},{av:'AV164Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV39OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV41OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Gridpaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e132P2',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV23FilterFullText',fld:'vFILTERFULLTEXT',pic:''},{av:'AV120SecRoleId',fld:'vSECROLEID',pic:'ZZZ9'},{av:'AV5ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9'},{av:'AV67TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV68TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'AV51TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV52TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV89TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV90TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV83TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV84TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV81TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV82TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV87TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV88TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV99TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV100TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV101TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV102TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV97TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV113TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV114TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV93TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV94TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV58TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV60TFCitaEstadoPago_Sels',fld:'vTFCITAESTADOPAGO_SELS',pic:''},{av:'AV123TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV124TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV128TFCitaArchivoExtencion',fld:'vTFCITAARCHIVOEXTENCION',pic:''},{av:'AV129TFCitaArchivoExtencion_Sel',fld:'vTFCITAARCHIVOEXTENCION_SEL',pic:''},{av:'AV164Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV39OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV41OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV39OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV41OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV128TFCitaArchivoExtencion',fld:'vTFCITAARCHIVOEXTENCION',pic:''},{av:'AV129TFCitaArchivoExtencion_Sel',fld:'vTFCITAARCHIVOEXTENCION_SEL',pic:''},{av:'AV123TFSGCitaDisponibilidadHoraFin',fld:'vTFSGCITADISPONIBILIDADHORAFIN',pic:'99:99'},{av:'AV124TFSGCitaDisponibilidadHoraFin_To',fld:'vTFSGCITADISPONIBILIDADHORAFIN_TO',pic:'99:99'},{av:'AV61TFCitaEstadoPago_SelsJson',fld:'vTFCITAESTADOPAGO_SELSJSON',pic:''},{av:'AV60TFCitaEstadoPago_Sels',fld:'vTFCITAESTADOPAGO_SELS',pic:''},{av:'AV59TFCitaEstadoCita_SelsJson',fld:'vTFCITAESTADOCITA_SELSJSON',pic:''},{av:'AV58TFCitaEstadoCita_Sels',fld:'vTFCITAESTADOCITA_SELS',pic:''},{av:'AV93TFSGCitaDisponibilidadClinicaNombre',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE',pic:''},{av:'AV94TFSGCitaDisponibilidadClinicaNombre_Sel',fld:'vTFSGCITADISPONIBILIDADCLINICANOMBRE_SEL',pic:''},{av:'AV113TFSGCitaDisponibilidadSedeNombre',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE',pic:''},{av:'AV114TFSGCitaDisponibilidadSedeNombre_Sel',fld:'vTFSGCITADISPONIBILIDADSEDENOMBRE_SEL',pic:''},{av:'AV97TFSGCitaDisponibilidadEspecialidadNombre',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE',pic:''},{av:'AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel',fld:'vTFSGCITADISPONIBILIDADESPECIALIDADNOMBRE_SEL',pic:''},{av:'AV101TFSGCitaDisponibilidadHoraInicio',fld:'vTFSGCITADISPONIBILIDADHORAINICIO',pic:'99:99'},{av:'AV102TFSGCitaDisponibilidadHoraInicio_To',fld:'vTFSGCITADISPONIBILIDADHORAINICIO_TO',pic:'99:99'},{av:'AV99TFSGCitaDisponibilidadFecha',fld:'vTFSGCITADISPONIBILIDADFECHA',pic:''},{av:'AV100TFSGCitaDisponibilidadFecha_To',fld:'vTFSGCITADISPONIBILIDADFECHA_TO',pic:''},{av:'AV87TFPacienteNombres',fld:'vTFPACIENTENOMBRES',pic:''},{av:'AV88TFPacienteNombres_Sel',fld:'vTFPACIENTENOMBRES_SEL',pic:''},{av:'AV81TFPacienteApellidoMaterno',fld:'vTFPACIENTEAPELLIDOMATERNO',pic:''},{av:'AV82TFPacienteApellidoMaterno_Sel',fld:'vTFPACIENTEAPELLIDOMATERNO_SEL',pic:''},{av:'AV83TFPacienteApellidoPaterno',fld:'vTFPACIENTEAPELLIDOPATERNO',pic:''},{av:'AV84TFPacienteApellidoPaterno_Sel',fld:'vTFPACIENTEAPELLIDOPATERNO_SEL',pic:''},{av:'AV89TFPacienteNroDocumento',fld:'vTFPACIENTENRODOCUMENTO',pic:''},{av:'AV90TFPacienteNroDocumento_Sel',fld:'vTFPACIENTENRODOCUMENTO_SEL',pic:''},{av:'AV51TFCitaCode',fld:'vTFCITACODE',pic:''},{av:'AV52TFCitaCode_Sel',fld:'vTFCITACODE_SEL',pic:''},{av:'AV67TFCitaId',fld:'vTFCITAID',pic:'ZZZZZZZ9'},{av:'AV68TFCitaId_To',fld:'vTFCITAID_TO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e162P2',iparms:[]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'cmbavActionscita'},{av:'AV6ActionsCita',fld:'vACTIONSCITA',pic:'ZZZ9'}]}");
      setEventMetadata("VACTIONSCITA.CLICK","{handler:'e172P2',iparms:[{av:'cmbavActionscita'},{av:'AV6ActionsCita',fld:'vACTIONSCITA',pic:'ZZZ9'},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VACTIONSCITA.CLICK",",oparms:[{av:'cmbavActionscita'},{av:'AV6ActionsCita',fld:'vACTIONSCITA',pic:'ZZZ9'},{av:'A19CitaId',fld:'CITAID',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("NULL","{handler:'valid_Citaarchivoextencion',iparms:[]");
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
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gridpaginationbar_Selectedpage = "" ;
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV23FilterFullText = "" ;
      AV51TFCitaCode = "" ;
      AV52TFCitaCode_Sel = "" ;
      AV89TFPacienteNroDocumento = "" ;
      AV90TFPacienteNroDocumento_Sel = "" ;
      AV83TFPacienteApellidoPaterno = "" ;
      AV84TFPacienteApellidoPaterno_Sel = "" ;
      AV81TFPacienteApellidoMaterno = "" ;
      AV82TFPacienteApellidoMaterno_Sel = "" ;
      AV87TFPacienteNombres = "" ;
      AV88TFPacienteNombres_Sel = "" ;
      AV99TFSGCitaDisponibilidadFecha = GXutil.nullDate() ;
      AV100TFSGCitaDisponibilidadFecha_To = GXutil.nullDate() ;
      AV101TFSGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      AV102TFSGCitaDisponibilidadHoraInicio_To = GXutil.resetTime( GXutil.nullDate() );
      AV97TFSGCitaDisponibilidadEspecialidadNombre = "" ;
      AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel = "" ;
      AV113TFSGCitaDisponibilidadSedeNombre = "" ;
      AV114TFSGCitaDisponibilidadSedeNombre_Sel = "" ;
      AV93TFSGCitaDisponibilidadClinicaNombre = "" ;
      AV94TFSGCitaDisponibilidadClinicaNombre_Sel = "" ;
      AV58TFCitaEstadoCita_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60TFCitaEstadoPago_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV123TFSGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      AV124TFSGCitaDisponibilidadHoraFin_To = GXutil.resetTime( GXutil.nullDate() );
      AV128TFCitaArchivoExtencion = "" ;
      AV129TFCitaArchivoExtencion_Sel = "" ;
      AV164Pgmname = "" ;
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV19DDO_TitleSettingsIcons = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV15DDO_SGCitaDisponibilidadFechaAuxDateTo = GXutil.nullDate() ;
      AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo = GXutil.nullDate() ;
      AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo = GXutil.nullDate() ;
      AV13DDO_SGCitaDisponibilidadFechaAuxDate = GXutil.nullDate() ;
      AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate = GXutil.nullDate() ;
      AV125DDO_SGCitaDisponibilidadHoraFinAuxDate = GXutil.nullDate() ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ucDvpanel_tableheader = new com.genexus.webpanels.GXUserControl();
      ClassString = "" ;
      StyleString = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      subGrid_Linesclass = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      A64CitaCode = "" ;
      A106PacienteNroDocumento = "" ;
      A103PacienteApellidoPaterno = "" ;
      A104PacienteApellidoMaterno = "" ;
      A105PacienteNombres = "" ;
      A66SGCitaDisponibilidadFecha = GXutil.nullDate() ;
      A68SGCitaDisponibilidadHoraInicio = GXutil.resetTime( GXutil.nullDate() );
      A146SGCitaDisponibilidadEspecialidadNombre = "" ;
      A73SGCitaDisponibilidadSedeNombre = "" ;
      A78SGCitaDisponibilidadClinicaNombre = "" ;
      A89CitaEstadoCita = "" ;
      A102CitaEstadoPago = "" ;
      A387SGCitaDisponibilidadHoraFin = GXutil.resetTime( GXutil.nullDate() );
      A333CitaArchivoExtencion = "" ;
      ucGridpaginationbar = new com.genexus.webpanels.GXUserControl();
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      AV14DDO_SGCitaDisponibilidadFechaAuxDateText = "" ;
      ucTfsgcitadisponibilidadfecha_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV17DDO_SGCitaDisponibilidadHoraInicioAuxDateText = "" ;
      ucTfsgcitadisponibilidadhorainicio_rangepicker = new com.genexus.webpanels.GXUserControl();
      AV127DDO_SGCitaDisponibilidadHoraFinAuxDateText = "" ;
      ucTfsgcitadisponibilidadhorafin_rangepicker = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV158Wpbandejacitasds_24_tfcitaestadocita_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV159Wpbandejacitasds_25_tfcitaestadopago_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV135Wpbandejacitasds_1_filterfulltext = "" ;
      lV138Wpbandejacitasds_4_tfcitacode = "" ;
      lV140Wpbandejacitasds_6_tfpacientenrodocumento = "" ;
      lV142Wpbandejacitasds_8_tfpacienteapellidopaterno = "" ;
      lV144Wpbandejacitasds_10_tfpacienteapellidomaterno = "" ;
      lV146Wpbandejacitasds_12_tfpacientenombres = "" ;
      lV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = "" ;
      lV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = "" ;
      lV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = "" ;
      lV162Wpbandejacitasds_28_tfcitaarchivoextencion = "" ;
      AV135Wpbandejacitasds_1_filterfulltext = "" ;
      AV139Wpbandejacitasds_5_tfcitacode_sel = "" ;
      AV138Wpbandejacitasds_4_tfcitacode = "" ;
      AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel = "" ;
      AV140Wpbandejacitasds_6_tfpacientenrodocumento = "" ;
      AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel = "" ;
      AV142Wpbandejacitasds_8_tfpacienteapellidopaterno = "" ;
      AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel = "" ;
      AV144Wpbandejacitasds_10_tfpacienteapellidomaterno = "" ;
      AV147Wpbandejacitasds_13_tfpacientenombres_sel = "" ;
      AV146Wpbandejacitasds_12_tfpacientenombres = "" ;
      AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha = GXutil.nullDate() ;
      AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to = GXutil.nullDate() ;
      AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio = GXutil.resetTime( GXutil.nullDate() );
      AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to = GXutil.resetTime( GXutil.nullDate() );
      AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel = "" ;
      AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre = "" ;
      AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel = "" ;
      AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre = "" ;
      AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel = "" ;
      AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre = "" ;
      AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin = GXutil.resetTime( GXutil.nullDate() );
      AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to = GXutil.resetTime( GXutil.nullDate() );
      AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel = "" ;
      AV162Wpbandejacitasds_28_tfcitaarchivoextencion = "" ;
      H002P2_A20PacienteId = new int[1] ;
      H002P2_A21SGCitaDisponibilidadId = new int[1] ;
      H002P2_A70SGCitaDisponibilidadEspecialidadId = new short[1] ;
      H002P2_A72SGCitaDisponibilidadSedeId = new short[1] ;
      H002P2_A76SGCitaDisponibilidadClinicaId = new short[1] ;
      H002P2_A81SGCitaDisponibilidadProfesionalId = new int[1] ;
      H002P2_A333CitaArchivoExtencion = new String[] {""} ;
      H002P2_n333CitaArchivoExtencion = new boolean[] {false} ;
      H002P2_A387SGCitaDisponibilidadHoraFin = new java.util.Date[] {GXutil.nullDate()} ;
      H002P2_n387SGCitaDisponibilidadHoraFin = new boolean[] {false} ;
      H002P2_A102CitaEstadoPago = new String[] {""} ;
      H002P2_n102CitaEstadoPago = new boolean[] {false} ;
      H002P2_A89CitaEstadoCita = new String[] {""} ;
      H002P2_n89CitaEstadoCita = new boolean[] {false} ;
      H002P2_A78SGCitaDisponibilidadClinicaNombre = new String[] {""} ;
      H002P2_A73SGCitaDisponibilidadSedeNombre = new String[] {""} ;
      H002P2_A146SGCitaDisponibilidadEspecialidadNombre = new String[] {""} ;
      H002P2_A68SGCitaDisponibilidadHoraInicio = new java.util.Date[] {GXutil.nullDate()} ;
      H002P2_n68SGCitaDisponibilidadHoraInicio = new boolean[] {false} ;
      H002P2_A66SGCitaDisponibilidadFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H002P2_n66SGCitaDisponibilidadFecha = new boolean[] {false} ;
      H002P2_A105PacienteNombres = new String[] {""} ;
      H002P2_A104PacienteApellidoMaterno = new String[] {""} ;
      H002P2_A103PacienteApellidoPaterno = new String[] {""} ;
      H002P2_A106PacienteNroDocumento = new String[] {""} ;
      H002P2_A64CitaCode = new String[] {""} ;
      H002P2_A19CitaId = new int[1] ;
      H002P3_AGRID_nRecordCount = new long[1] ;
      AV119WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      H002P4_A6SecUserId = new short[1] ;
      H002P4_A14SecUserName = new String[] {""} ;
      H002P4_A122SecUserEmail = new String[] {""} ;
      A14SecUserName = "" ;
      A122SecUserEmail = "" ;
      AV43ProfesionalNroDocumento = "" ;
      AV122ProfesionalCorreo = "" ;
      H002P5_A6SecUserId = new short[1] ;
      H002P5_A4SecRoleId = new short[1] ;
      H002P6_A174ProfesionalNroDocumento = new String[] {""} ;
      H002P6_A31ProfesionalId = new int[1] ;
      A174ProfesionalNroDocumento = "" ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      AV59TFCitaEstadoCita_SelsJson = "" ;
      AV61TFCitaEstadoPago_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV45Session = httpContext.getWebSession();
      AV26GridState = new com.projectthani.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXt_char24 = "" ;
      GXv_char25 = new String[1] ;
      GXt_char22 = "" ;
      GXv_char23 = new String[1] ;
      GXt_char20 = "" ;
      GXv_char21 = new String[1] ;
      GXt_char18 = "" ;
      GXv_char19 = new String[1] ;
      GXt_char16 = "" ;
      GXv_char17 = new String[1] ;
      GXt_char14 = "" ;
      GXv_char15 = new String[1] ;
      GXt_char12 = "" ;
      GXv_char13 = new String[1] ;
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GXv_SdtWWPGridState26 = new com.projectthani.wwpbaseobjects.SdtWWPGridState[1] ;
      AV115TrnContext = new com.projectthani.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV28HTTPRequest = httpContext.getHttpRequest();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      GXCCtl = "" ;
      ROClassString = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpbandejacitas__default(),
         new Object[] {
             new Object[] {
            H002P2_A20PacienteId, H002P2_A21SGCitaDisponibilidadId, H002P2_A70SGCitaDisponibilidadEspecialidadId, H002P2_A72SGCitaDisponibilidadSedeId, H002P2_A76SGCitaDisponibilidadClinicaId, H002P2_A81SGCitaDisponibilidadProfesionalId, H002P2_A333CitaArchivoExtencion, H002P2_n333CitaArchivoExtencion, H002P2_A387SGCitaDisponibilidadHoraFin, H002P2_n387SGCitaDisponibilidadHoraFin,
            H002P2_A102CitaEstadoPago, H002P2_n102CitaEstadoPago, H002P2_A89CitaEstadoCita, H002P2_n89CitaEstadoCita, H002P2_A78SGCitaDisponibilidadClinicaNombre, H002P2_A73SGCitaDisponibilidadSedeNombre, H002P2_A146SGCitaDisponibilidadEspecialidadNombre, H002P2_A68SGCitaDisponibilidadHoraInicio, H002P2_n68SGCitaDisponibilidadHoraInicio, H002P2_A66SGCitaDisponibilidadFecha,
            H002P2_n66SGCitaDisponibilidadFecha, H002P2_A105PacienteNombres, H002P2_A104PacienteApellidoMaterno, H002P2_A103PacienteApellidoPaterno, H002P2_A106PacienteNroDocumento, H002P2_A64CitaCode, H002P2_A19CitaId
            }
            , new Object[] {
            H002P3_AGRID_nRecordCount
            }
            , new Object[] {
            H002P4_A6SecUserId, H002P4_A14SecUserName, H002P4_A122SecUserEmail
            }
            , new Object[] {
            H002P5_A6SecUserId, H002P5_A4SecRoleId
            }
            , new Object[] {
            H002P6_A174ProfesionalNroDocumento, H002P6_A31ProfesionalId
            }
         }
      );
      AV164Pgmname = "WPBandejaCitas" ;
      /* GeneXus formulas. */
      AV164Pgmname = "WPBandejaCitas" ;
      Gx_err = (short)(0) ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Sortable ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV120SecRoleId ;
   private short AV39OrderedBy ;
   private short wbEnd ;
   private short wbStart ;
   private short AV6ActionsCita ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A70SGCitaDisponibilidadEspecialidadId ;
   private short A72SGCitaDisponibilidadSedeId ;
   private short A76SGCitaDisponibilidadClinicaId ;
   private short AV121SecUserId ;
   private short A6SecUserId ;
   private short A4SecRoleId ;
   private int subGrid_Rows ;
   private int Gridpaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_29 ;
   private int nGXsfl_29_idx=1 ;
   private int AV5ProfesionalId ;
   private int AV67TFCitaId ;
   private int AV68TFCitaId_To ;
   private int Gridpaginationbar_Pagestoshow ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Allbackcolor ;
   private int A19CitaId ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV158Wpbandejacitasds_24_tfcitaestadocita_sels_size ;
   private int AV159Wpbandejacitasds_25_tfcitaestadopago_sels_size ;
   private int AV136Wpbandejacitasds_2_tfcitaid ;
   private int AV137Wpbandejacitasds_3_tfcitaid_to ;
   private int A81SGCitaDisponibilidadProfesionalId ;
   private int A20PacienteId ;
   private int A21SGCitaDisponibilidadId ;
   private int A31ProfesionalId ;
   private int AV42PageToGo ;
   private int AV165GXV1 ;
   private int edtavFilterfulltext_Enabled ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long AV24GridCurrentPage ;
   private long AV25GridPageCount ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private String Gridpaginationbar_Selectedpage ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_29_idx="0001" ;
   private String AV164Pgmname ;
   private String Dvpanel_tableheader_Width ;
   private String Dvpanel_tableheader_Cls ;
   private String Dvpanel_tableheader_Title ;
   private String Dvpanel_tableheader_Iconposition ;
   private String Gridpaginationbar_Class ;
   private String Gridpaginationbar_Pagingbuttonsposition ;
   private String Gridpaginationbar_Pagingcaptionposition ;
   private String Gridpaginationbar_Emptygridclass ;
   private String Gridpaginationbar_Rowsperpageoptions ;
   private String Gridpaginationbar_Previous ;
   private String Gridpaginationbar_Next ;
   private String Gridpaginationbar_Caption ;
   private String Gridpaginationbar_Emptygridcaption ;
   private String Gridpaginationbar_Rowsperpagecaption ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Filteredtextto_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Grid_empowerer_Gridinternalname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String Dvpanel_tableheader_Internalname ;
   private String divTableheader_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divGridtablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String subGrid_Header ;
   private String A89CitaEstadoCita ;
   private String A102CitaEstadoPago ;
   private String Gridpaginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String divDdo_sgcitadisponibilidadfechaauxdates_Internalname ;
   private String TempTags ;
   private String edtavDdo_sgcitadisponibilidadfechaauxdatetext_Internalname ;
   private String edtavDdo_sgcitadisponibilidadfechaauxdatetext_Jsonclick ;
   private String Tfsgcitadisponibilidadfecha_rangepicker_Internalname ;
   private String divDdo_sgcitadisponibilidadhorainicioauxdates_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorainicioauxdatetext_Jsonclick ;
   private String Tfsgcitadisponibilidadhorainicio_rangepicker_Internalname ;
   private String divDdo_sgcitadisponibilidadhorafinauxdates_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Internalname ;
   private String edtavDdo_sgcitadisponibilidadhorafinauxdatetext_Jsonclick ;
   private String Tfsgcitadisponibilidadhorafin_rangepicker_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCitaId_Internalname ;
   private String edtCitaCode_Internalname ;
   private String edtPacienteNroDocumento_Internalname ;
   private String edtPacienteApellidoPaterno_Internalname ;
   private String edtPacienteApellidoMaterno_Internalname ;
   private String edtPacienteNombres_Internalname ;
   private String edtSGCitaDisponibilidadFecha_Internalname ;
   private String edtSGCitaDisponibilidadHoraInicio_Internalname ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Internalname ;
   private String edtSGCitaDisponibilidadSedeNombre_Internalname ;
   private String edtSGCitaDisponibilidadClinicaNombre_Internalname ;
   private String edtSGCitaDisponibilidadHoraFin_Internalname ;
   private String edtCitaArchivoExtencion_Internalname ;
   private String edtavFilterfulltext_Internalname ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXt_char24 ;
   private String GXv_char25[] ;
   private String GXt_char22 ;
   private String GXv_char23[] ;
   private String GXt_char20 ;
   private String GXv_char21[] ;
   private String GXt_char18 ;
   private String GXv_char19[] ;
   private String GXt_char16 ;
   private String GXv_char17[] ;
   private String GXt_char14 ;
   private String GXv_char15[] ;
   private String GXt_char12 ;
   private String GXv_char13[] ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String tblTablerightheader_Internalname ;
   private String tblTablefilters_Internalname ;
   private String edtavFilterfulltext_Jsonclick ;
   private String sGXsfl_29_fel_idx="0001" ;
   private String GXCCtl ;
   private String ROClassString ;
   private String edtCitaId_Jsonclick ;
   private String edtCitaCode_Jsonclick ;
   private String edtPacienteNroDocumento_Jsonclick ;
   private String edtPacienteApellidoPaterno_Jsonclick ;
   private String edtPacienteApellidoMaterno_Jsonclick ;
   private String edtPacienteNombres_Jsonclick ;
   private String edtSGCitaDisponibilidadFecha_Jsonclick ;
   private String edtSGCitaDisponibilidadHoraInicio_Jsonclick ;
   private String edtSGCitaDisponibilidadEspecialidadNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadSedeNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadClinicaNombre_Jsonclick ;
   private String edtSGCitaDisponibilidadHoraFin_Jsonclick ;
   private String edtCitaArchivoExtencion_Jsonclick ;
   private java.util.Date AV101TFSGCitaDisponibilidadHoraInicio ;
   private java.util.Date AV102TFSGCitaDisponibilidadHoraInicio_To ;
   private java.util.Date AV123TFSGCitaDisponibilidadHoraFin ;
   private java.util.Date AV124TFSGCitaDisponibilidadHoraFin_To ;
   private java.util.Date A68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date A387SGCitaDisponibilidadHoraFin ;
   private java.util.Date AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ;
   private java.util.Date AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ;
   private java.util.Date AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ;
   private java.util.Date AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ;
   private java.util.Date AV99TFSGCitaDisponibilidadFecha ;
   private java.util.Date AV100TFSGCitaDisponibilidadFecha_To ;
   private java.util.Date AV15DDO_SGCitaDisponibilidadFechaAuxDateTo ;
   private java.util.Date AV18DDO_SGCitaDisponibilidadHoraInicioAuxDateTo ;
   private java.util.Date AV126DDO_SGCitaDisponibilidadHoraFinAuxDateTo ;
   private java.util.Date AV13DDO_SGCitaDisponibilidadFechaAuxDate ;
   private java.util.Date AV16DDO_SGCitaDisponibilidadHoraInicioAuxDate ;
   private java.util.Date AV125DDO_SGCitaDisponibilidadHoraFinAuxDate ;
   private java.util.Date A66SGCitaDisponibilidadFecha ;
   private java.util.Date AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ;
   private java.util.Date AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV41OrderedDsc ;
   private boolean Dvpanel_tableheader_Autowidth ;
   private boolean Dvpanel_tableheader_Autoheight ;
   private boolean Dvpanel_tableheader_Collapsible ;
   private boolean Dvpanel_tableheader_Collapsed ;
   private boolean Dvpanel_tableheader_Showcollapseicon ;
   private boolean Dvpanel_tableheader_Autoscroll ;
   private boolean Gridpaginationbar_Showfirst ;
   private boolean Gridpaginationbar_Showprevious ;
   private boolean Gridpaginationbar_Shownext ;
   private boolean Gridpaginationbar_Showlast ;
   private boolean Gridpaginationbar_Rowsperpageselector ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n66SGCitaDisponibilidadFecha ;
   private boolean n68SGCitaDisponibilidadHoraInicio ;
   private boolean n89CitaEstadoCita ;
   private boolean n102CitaEstadoPago ;
   private boolean n387SGCitaDisponibilidadHoraFin ;
   private boolean n333CitaArchivoExtencion ;
   private boolean bGXsfl_29_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String AV59TFCitaEstadoCita_SelsJson ;
   private String AV61TFCitaEstadoPago_SelsJson ;
   private String AV23FilterFullText ;
   private String AV51TFCitaCode ;
   private String AV52TFCitaCode_Sel ;
   private String AV89TFPacienteNroDocumento ;
   private String AV90TFPacienteNroDocumento_Sel ;
   private String AV83TFPacienteApellidoPaterno ;
   private String AV84TFPacienteApellidoPaterno_Sel ;
   private String AV81TFPacienteApellidoMaterno ;
   private String AV82TFPacienteApellidoMaterno_Sel ;
   private String AV87TFPacienteNombres ;
   private String AV88TFPacienteNombres_Sel ;
   private String AV97TFSGCitaDisponibilidadEspecialidadNombre ;
   private String AV98TFSGCitaDisponibilidadEspecialidadNombre_Sel ;
   private String AV113TFSGCitaDisponibilidadSedeNombre ;
   private String AV114TFSGCitaDisponibilidadSedeNombre_Sel ;
   private String AV93TFSGCitaDisponibilidadClinicaNombre ;
   private String AV94TFSGCitaDisponibilidadClinicaNombre_Sel ;
   private String AV128TFCitaArchivoExtencion ;
   private String AV129TFCitaArchivoExtencion_Sel ;
   private String A64CitaCode ;
   private String A106PacienteNroDocumento ;
   private String A103PacienteApellidoPaterno ;
   private String A104PacienteApellidoMaterno ;
   private String A105PacienteNombres ;
   private String A146SGCitaDisponibilidadEspecialidadNombre ;
   private String A73SGCitaDisponibilidadSedeNombre ;
   private String A78SGCitaDisponibilidadClinicaNombre ;
   private String A333CitaArchivoExtencion ;
   private String AV14DDO_SGCitaDisponibilidadFechaAuxDateText ;
   private String AV17DDO_SGCitaDisponibilidadHoraInicioAuxDateText ;
   private String AV127DDO_SGCitaDisponibilidadHoraFinAuxDateText ;
   private String lV135Wpbandejacitasds_1_filterfulltext ;
   private String lV138Wpbandejacitasds_4_tfcitacode ;
   private String lV140Wpbandejacitasds_6_tfpacientenrodocumento ;
   private String lV142Wpbandejacitasds_8_tfpacienteapellidopaterno ;
   private String lV144Wpbandejacitasds_10_tfpacienteapellidomaterno ;
   private String lV146Wpbandejacitasds_12_tfpacientenombres ;
   private String lV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ;
   private String lV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ;
   private String lV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ;
   private String lV162Wpbandejacitasds_28_tfcitaarchivoextencion ;
   private String AV135Wpbandejacitasds_1_filterfulltext ;
   private String AV139Wpbandejacitasds_5_tfcitacode_sel ;
   private String AV138Wpbandejacitasds_4_tfcitacode ;
   private String AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel ;
   private String AV140Wpbandejacitasds_6_tfpacientenrodocumento ;
   private String AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ;
   private String AV142Wpbandejacitasds_8_tfpacienteapellidopaterno ;
   private String AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ;
   private String AV144Wpbandejacitasds_10_tfpacienteapellidomaterno ;
   private String AV147Wpbandejacitasds_13_tfpacientenombres_sel ;
   private String AV146Wpbandejacitasds_12_tfpacientenombres ;
   private String AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ;
   private String AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ;
   private String AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ;
   private String AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ;
   private String AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ;
   private String AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ;
   private String AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel ;
   private String AV162Wpbandejacitasds_28_tfcitaarchivoextencion ;
   private String A14SecUserName ;
   private String A122SecUserEmail ;
   private String AV43ProfesionalNroDocumento ;
   private String AV122ProfesionalCorreo ;
   private String A174ProfesionalNroDocumento ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV28HTTPRequest ;
   private com.genexus.webpanels.WebSession AV45Session ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableheader ;
   private com.genexus.webpanels.GXUserControl ucGridpaginationbar ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private com.genexus.webpanels.GXUserControl ucTfsgcitadisponibilidadfecha_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfsgcitadisponibilidadhorainicio_rangepicker ;
   private com.genexus.webpanels.GXUserControl ucTfsgcitadisponibilidadhorafin_rangepicker ;
   private GXSimpleCollection<String> AV158Wpbandejacitasds_24_tfcitaestadocita_sels ;
   private GXSimpleCollection<String> AV159Wpbandejacitasds_25_tfcitaestadopago_sels ;
   private HTMLChoice cmbavActionscita ;
   private HTMLChoice cmbCitaEstadoCita ;
   private HTMLChoice cmbCitaEstadoPago ;
   private IDataStoreProvider pr_default ;
   private int[] H002P2_A20PacienteId ;
   private int[] H002P2_A21SGCitaDisponibilidadId ;
   private short[] H002P2_A70SGCitaDisponibilidadEspecialidadId ;
   private short[] H002P2_A72SGCitaDisponibilidadSedeId ;
   private short[] H002P2_A76SGCitaDisponibilidadClinicaId ;
   private int[] H002P2_A81SGCitaDisponibilidadProfesionalId ;
   private String[] H002P2_A333CitaArchivoExtencion ;
   private boolean[] H002P2_n333CitaArchivoExtencion ;
   private java.util.Date[] H002P2_A387SGCitaDisponibilidadHoraFin ;
   private boolean[] H002P2_n387SGCitaDisponibilidadHoraFin ;
   private String[] H002P2_A102CitaEstadoPago ;
   private boolean[] H002P2_n102CitaEstadoPago ;
   private String[] H002P2_A89CitaEstadoCita ;
   private boolean[] H002P2_n89CitaEstadoCita ;
   private String[] H002P2_A78SGCitaDisponibilidadClinicaNombre ;
   private String[] H002P2_A73SGCitaDisponibilidadSedeNombre ;
   private String[] H002P2_A146SGCitaDisponibilidadEspecialidadNombre ;
   private java.util.Date[] H002P2_A68SGCitaDisponibilidadHoraInicio ;
   private boolean[] H002P2_n68SGCitaDisponibilidadHoraInicio ;
   private java.util.Date[] H002P2_A66SGCitaDisponibilidadFecha ;
   private boolean[] H002P2_n66SGCitaDisponibilidadFecha ;
   private String[] H002P2_A105PacienteNombres ;
   private String[] H002P2_A104PacienteApellidoMaterno ;
   private String[] H002P2_A103PacienteApellidoPaterno ;
   private String[] H002P2_A106PacienteNroDocumento ;
   private String[] H002P2_A64CitaCode ;
   private int[] H002P2_A19CitaId ;
   private long[] H002P3_AGRID_nRecordCount ;
   private short[] H002P4_A6SecUserId ;
   private String[] H002P4_A14SecUserName ;
   private String[] H002P4_A122SecUserEmail ;
   private short[] H002P5_A6SecUserId ;
   private short[] H002P5_A4SecRoleId ;
   private String[] H002P6_A174ProfesionalNroDocumento ;
   private int[] H002P6_A31ProfesionalId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV58TFCitaEstadoCita_Sels ;
   private GXSimpleCollection<String> AV60TFCitaEstadoPago_Sels ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV19DDO_TitleSettingsIcons ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private com.projectthani.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState26[] ;
   private com.projectthani.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
   private com.projectthani.wwpbaseobjects.SdtWWPTransactionContext AV115TrnContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV119WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class wpbandejacitas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H002P2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV158Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV159Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV135Wpbandejacitasds_1_filterfulltext ,
                                          int AV136Wpbandejacitasds_2_tfcitaid ,
                                          int AV137Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV139Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV138Wpbandejacitasds_4_tfcitacode ,
                                          String AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV140Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV142Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV144Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV147Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV146Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV158Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV159Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV162Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV120SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV5ProfesionalId ,
                                          short AV39OrderedBy ,
                                          boolean AV41OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int27 = new byte[47];
      Object[] GXv_Object28 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " T1.[PacienteId], T1.[SGCitaDisponibilidadId] AS SGCitaDisponibilidadId, T3.[EspecialidadId] AS SGCitaDisponibilidadEspecialidadId, T3.[SGSedeDisponibilidadSedeId]" ;
      sSelectString += " AS SGCitaDisponibilidadSedeId, T5.[ClinicaId] AS SGCitaDisponibilidadClinicaId, T3.[ProfesionalId] AS SGCitaDisponibilidadProfesionalId, T1.[CitaArchivoExtencion]," ;
      sSelectString += " T3.[DisponibilidadHoraFin] AS SGCitaDisponibilidadHoraFin, T1.[CitaEstadoPago], T1.[CitaEstadoCita], T6.[ClinicaNombreAbreviado] AS SGCitaDisponibilidadClinicaNombre," ;
      sSelectString += " T5.[SedeNombre] AS SGCitaDisponibilidadSedeNombre, T4.[EspecialidadNombre] AS SGCitaDisponibilidadEspecialidadNombre, T3.[DisponibilidadHoraInicio] AS SGCitaDisponibilidadHoraInicio," ;
      sSelectString += " T3.[DisponibilidadFecha] AS SGCitaDisponibilidadFecha, T2.[PacienteNombres], T2.[PacienteApellidoMaterno], T2.[PacienteApellidoPaterno], T2.[PacienteNroDocumento]," ;
      sSelectString += " T1.[CitaCode], T1.[CitaId]" ;
      sFromString = " FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      sFromString += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      sFromString += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      sOrderString = "" ;
      if ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int27[0] = (byte)(1) ;
         GXv_int27[1] = (byte)(1) ;
         GXv_int27[2] = (byte)(1) ;
         GXv_int27[3] = (byte)(1) ;
         GXv_int27[4] = (byte)(1) ;
         GXv_int27[5] = (byte)(1) ;
         GXv_int27[6] = (byte)(1) ;
         GXv_int27[7] = (byte)(1) ;
         GXv_int27[8] = (byte)(1) ;
         GXv_int27[9] = (byte)(1) ;
         GXv_int27[10] = (byte)(1) ;
         GXv_int27[11] = (byte)(1) ;
         GXv_int27[12] = (byte)(1) ;
         GXv_int27[13] = (byte)(1) ;
         GXv_int27[14] = (byte)(1) ;
         GXv_int27[15] = (byte)(1) ;
         GXv_int27[16] = (byte)(1) ;
      }
      if ( ! (0==AV136Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int27[17] = (byte)(1) ;
      }
      if ( ! (0==AV137Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int27[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV139Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV138Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int27[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV139Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int27[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV140Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int27[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int27[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV142Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int27[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int27[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV144Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int27[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int27[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV147Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV146Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int27[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV147Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int27[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int27[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int27[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int27[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int27[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int27[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int27[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int27[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int27[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int27[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int27[38] = (byte)(1) ;
      }
      if ( AV158Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV158Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV159Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV159Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int27[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int27[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV162Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int27[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int27[42] = (byte)(1) ;
      }
      if ( AV120SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int27[43] = (byte)(1) ;
      }
      if ( ( AV39OrderedBy == 1 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaCode]" ;
      }
      else if ( ( AV39OrderedBy == 1 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaCode] DESC" ;
      }
      else if ( ( AV39OrderedBy == 2 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaId]" ;
      }
      else if ( ( AV39OrderedBy == 2 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaId] DESC" ;
      }
      else if ( ( AV39OrderedBy == 3 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[PacienteNroDocumento]" ;
      }
      else if ( ( AV39OrderedBy == 3 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[PacienteNroDocumento] DESC" ;
      }
      else if ( ( AV39OrderedBy == 4 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[PacienteApellidoPaterno]" ;
      }
      else if ( ( AV39OrderedBy == 4 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[PacienteApellidoPaterno] DESC" ;
      }
      else if ( ( AV39OrderedBy == 5 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[PacienteApellidoMaterno]" ;
      }
      else if ( ( AV39OrderedBy == 5 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[PacienteApellidoMaterno] DESC" ;
      }
      else if ( ( AV39OrderedBy == 6 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T2.[PacienteNombres]" ;
      }
      else if ( ( AV39OrderedBy == 6 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T2.[PacienteNombres] DESC" ;
      }
      else if ( ( AV39OrderedBy == 7 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadFecha]" ;
      }
      else if ( ( AV39OrderedBy == 7 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadFecha] DESC" ;
      }
      else if ( ( AV39OrderedBy == 8 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadHoraInicio]" ;
      }
      else if ( ( AV39OrderedBy == 8 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadHoraInicio] DESC" ;
      }
      else if ( ( AV39OrderedBy == 9 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T4.[EspecialidadNombre]" ;
      }
      else if ( ( AV39OrderedBy == 9 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T4.[EspecialidadNombre] DESC" ;
      }
      else if ( ( AV39OrderedBy == 10 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T5.[SedeNombre]" ;
      }
      else if ( ( AV39OrderedBy == 10 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T5.[SedeNombre] DESC" ;
      }
      else if ( ( AV39OrderedBy == 11 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T6.[ClinicaNombreAbreviado]" ;
      }
      else if ( ( AV39OrderedBy == 11 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T6.[ClinicaNombreAbreviado] DESC" ;
      }
      else if ( ( AV39OrderedBy == 12 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaEstadoCita]" ;
      }
      else if ( ( AV39OrderedBy == 12 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaEstadoCita] DESC" ;
      }
      else if ( ( AV39OrderedBy == 13 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaEstadoPago]" ;
      }
      else if ( ( AV39OrderedBy == 13 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaEstadoPago] DESC" ;
      }
      else if ( ( AV39OrderedBy == 14 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadHoraFin]" ;
      }
      else if ( ( AV39OrderedBy == 14 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T3.[DisponibilidadHoraFin] DESC" ;
      }
      else if ( ( AV39OrderedBy == 15 ) && ! AV41OrderedDsc )
      {
         sOrderString += " ORDER BY T1.[CitaArchivoExtencion]" ;
      }
      else if ( ( AV39OrderedBy == 15 ) && ( AV41OrderedDsc ) )
      {
         sOrderString += " ORDER BY T1.[CitaArchivoExtencion] DESC" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY T1.[CitaId]" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " ROWS FETCH NEXT CAST((SELECT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END) AS INTEGER) ROWS ONLY" ;
      GXv_Object28[0] = scmdbuf ;
      GXv_Object28[1] = GXv_int27 ;
      return GXv_Object28 ;
   }

   protected Object[] conditional_H002P3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A89CitaEstadoCita ,
                                          GXSimpleCollection<String> AV158Wpbandejacitasds_24_tfcitaestadocita_sels ,
                                          String A102CitaEstadoPago ,
                                          GXSimpleCollection<String> AV159Wpbandejacitasds_25_tfcitaestadopago_sels ,
                                          String AV135Wpbandejacitasds_1_filterfulltext ,
                                          int AV136Wpbandejacitasds_2_tfcitaid ,
                                          int AV137Wpbandejacitasds_3_tfcitaid_to ,
                                          String AV139Wpbandejacitasds_5_tfcitacode_sel ,
                                          String AV138Wpbandejacitasds_4_tfcitacode ,
                                          String AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel ,
                                          String AV140Wpbandejacitasds_6_tfpacientenrodocumento ,
                                          String AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel ,
                                          String AV142Wpbandejacitasds_8_tfpacienteapellidopaterno ,
                                          String AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel ,
                                          String AV144Wpbandejacitasds_10_tfpacienteapellidomaterno ,
                                          String AV147Wpbandejacitasds_13_tfpacientenombres_sel ,
                                          String AV146Wpbandejacitasds_12_tfpacientenombres ,
                                          java.util.Date AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha ,
                                          java.util.Date AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to ,
                                          java.util.Date AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio ,
                                          java.util.Date AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to ,
                                          String AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel ,
                                          String AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre ,
                                          String AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel ,
                                          String AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre ,
                                          String AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel ,
                                          String AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre ,
                                          int AV158Wpbandejacitasds_24_tfcitaestadocita_sels_size ,
                                          int AV159Wpbandejacitasds_25_tfcitaestadopago_sels_size ,
                                          java.util.Date AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin ,
                                          java.util.Date AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to ,
                                          String AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel ,
                                          String AV162Wpbandejacitasds_28_tfcitaarchivoextencion ,
                                          short AV120SecRoleId ,
                                          String A64CitaCode ,
                                          String A106PacienteNroDocumento ,
                                          String A103PacienteApellidoPaterno ,
                                          String A104PacienteApellidoMaterno ,
                                          String A105PacienteNombres ,
                                          String A146SGCitaDisponibilidadEspecialidadNombre ,
                                          String A73SGCitaDisponibilidadSedeNombre ,
                                          String A78SGCitaDisponibilidadClinicaNombre ,
                                          int A19CitaId ,
                                          java.util.Date A66SGCitaDisponibilidadFecha ,
                                          java.util.Date A68SGCitaDisponibilidadHoraInicio ,
                                          java.util.Date A387SGCitaDisponibilidadHoraFin ,
                                          String A333CitaArchivoExtencion ,
                                          int A81SGCitaDisponibilidadProfesionalId ,
                                          int AV5ProfesionalId ,
                                          short AV39OrderedBy ,
                                          boolean AV41OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int30 = new byte[44];
      Object[] GXv_Object31 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM ((((([Cita] T1 INNER JOIN [Paciente] T2 ON T2.[PacienteId] = T1.[PacienteId]) INNER JOIN [Disponibilidad] T3 ON T3.[DisponibilidadId] = T1.[SGCitaDisponibilidadId])" ;
      scmdbuf += " INNER JOIN [Especialidad] T4 ON T4.[EspecialidadId] = T3.[EspecialidadId]) INNER JOIN [Sede] T5 ON T5.[SedeId] = T3.[SGSedeDisponibilidadSedeId]) INNER JOIN [Clinica]" ;
      scmdbuf += " T6 ON T6.[ClinicaId] = T5.[ClinicaId])" ;
      if ( ! (GXutil.strcmp("", AV135Wpbandejacitasds_1_filterfulltext)==0) )
      {
         addWhere(sWhereString, "(( T1.[CitaCode] like '%' + ?) or ( T2.[PacienteNroDocumento] like '%' + ?) or ( T2.[PacienteApellidoPaterno] like '%' + ?) or ( T2.[PacienteApellidoMaterno] like '%' + ?) or ( T2.[PacienteNombres] like '%' + ?) or ( T4.[EspecialidadNombre] like '%' + ?) or ( T5.[SedeNombre] like '%' + ?) or ( T6.[ClinicaNombreAbreviado] like '%' + ?) or ( 'registrado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'R') or ( 'confirmado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'C') or ( 'en atención' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'A') or ( 'finalizado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'F') or ( 'cancelado' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'X') or ( 'no se presentó' like '%' + LOWER(?) and T1.[CitaEstadoCita] = 'N') or ( 'sin pago' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'S') or ( 'pendiente' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'P') or ( 'pagado' like '%' + LOWER(?) and T1.[CitaEstadoPago] = 'G'))");
      }
      else
      {
         GXv_int30[0] = (byte)(1) ;
         GXv_int30[1] = (byte)(1) ;
         GXv_int30[2] = (byte)(1) ;
         GXv_int30[3] = (byte)(1) ;
         GXv_int30[4] = (byte)(1) ;
         GXv_int30[5] = (byte)(1) ;
         GXv_int30[6] = (byte)(1) ;
         GXv_int30[7] = (byte)(1) ;
         GXv_int30[8] = (byte)(1) ;
         GXv_int30[9] = (byte)(1) ;
         GXv_int30[10] = (byte)(1) ;
         GXv_int30[11] = (byte)(1) ;
         GXv_int30[12] = (byte)(1) ;
         GXv_int30[13] = (byte)(1) ;
         GXv_int30[14] = (byte)(1) ;
         GXv_int30[15] = (byte)(1) ;
         GXv_int30[16] = (byte)(1) ;
      }
      if ( ! (0==AV136Wpbandejacitasds_2_tfcitaid) )
      {
         addWhere(sWhereString, "(T1.[CitaId] >= ?)");
      }
      else
      {
         GXv_int30[17] = (byte)(1) ;
      }
      if ( ! (0==AV137Wpbandejacitasds_3_tfcitaid_to) )
      {
         addWhere(sWhereString, "(T1.[CitaId] <= ?)");
      }
      else
      {
         GXv_int30[18] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV139Wpbandejacitasds_5_tfcitacode_sel)==0) && ( ! (GXutil.strcmp("", AV138Wpbandejacitasds_4_tfcitacode)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] like ?)");
      }
      else
      {
         GXv_int30[19] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV139Wpbandejacitasds_5_tfcitacode_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaCode] = ?)");
      }
      else
      {
         GXv_int30[20] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) && ( ! (GXutil.strcmp("", AV140Wpbandejacitasds_6_tfpacientenrodocumento)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] like ?)");
      }
      else
      {
         GXv_int30[21] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV141Wpbandejacitasds_7_tfpacientenrodocumento_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNroDocumento] = ?)");
      }
      else
      {
         GXv_int30[22] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) && ( ! (GXutil.strcmp("", AV142Wpbandejacitasds_8_tfpacienteapellidopaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] like ?)");
      }
      else
      {
         GXv_int30[23] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV143Wpbandejacitasds_9_tfpacienteapellidopaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoPaterno] = ?)");
      }
      else
      {
         GXv_int30[24] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) && ( ! (GXutil.strcmp("", AV144Wpbandejacitasds_10_tfpacienteapellidomaterno)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] like ?)");
      }
      else
      {
         GXv_int30[25] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV145Wpbandejacitasds_11_tfpacienteapellidomaterno_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteApellidoMaterno] = ?)");
      }
      else
      {
         GXv_int30[26] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV147Wpbandejacitasds_13_tfpacientenombres_sel)==0) && ( ! (GXutil.strcmp("", AV146Wpbandejacitasds_12_tfpacientenombres)==0) ) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] like ?)");
      }
      else
      {
         GXv_int30[27] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV147Wpbandejacitasds_13_tfpacientenombres_sel)==0) )
      {
         addWhere(sWhereString, "(T2.[PacienteNombres] = ?)");
      }
      else
      {
         GXv_int30[28] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV148Wpbandejacitasds_14_tfsgcitadisponibilidadfecha)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] >= ?)");
      }
      else
      {
         GXv_int30[29] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV149Wpbandejacitasds_15_tfsgcitadisponibilidadfecha_to)) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadFecha] <= ?)");
      }
      else
      {
         GXv_int30[30] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV150Wpbandejacitasds_16_tfsgcitadisponibilidadhorainicio) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] >= ?)");
      }
      else
      {
         GXv_int30[31] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV151Wpbandejacitasds_17_tfsgcitadisponibilidadhorainicio_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraInicio] <= ?)");
      }
      else
      {
         GXv_int30[32] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) && ( ! (GXutil.strcmp("", AV152Wpbandejacitasds_18_tfsgcitadisponibilidadespecialidadnombre)==0) ) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] like ?)");
      }
      else
      {
         GXv_int30[33] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV153Wpbandejacitasds_19_tfsgcitadisponibilidadespecialidadnombre_sel)==0) )
      {
         addWhere(sWhereString, "(T4.[EspecialidadNombre] = ?)");
      }
      else
      {
         GXv_int30[34] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) && ( ! (GXutil.strcmp("", AV154Wpbandejacitasds_20_tfsgcitadisponibilidadsedenombre)==0) ) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] like ?)");
      }
      else
      {
         GXv_int30[35] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV155Wpbandejacitasds_21_tfsgcitadisponibilidadsedenombre_sel)==0) )
      {
         addWhere(sWhereString, "(T5.[SedeNombre] = ?)");
      }
      else
      {
         GXv_int30[36] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) && ( ! (GXutil.strcmp("", AV156Wpbandejacitasds_22_tfsgcitadisponibilidadclinicanombre)==0) ) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] like ?)");
      }
      else
      {
         GXv_int30[37] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV157Wpbandejacitasds_23_tfsgcitadisponibilidadclinicanombre_sel)==0) )
      {
         addWhere(sWhereString, "(T6.[ClinicaNombreAbreviado] = ?)");
      }
      else
      {
         GXv_int30[38] = (byte)(1) ;
      }
      if ( AV158Wpbandejacitasds_24_tfcitaestadocita_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV158Wpbandejacitasds_24_tfcitaestadocita_sels, "T1.[CitaEstadoCita] IN (", ")")+")");
      }
      if ( AV159Wpbandejacitasds_25_tfcitaestadopago_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("sqlserver", AV159Wpbandejacitasds_25_tfcitaestadopago_sels, "T1.[CitaEstadoPago] IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV160Wpbandejacitasds_26_tfsgcitadisponibilidadhorafin) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] >= ?)");
      }
      else
      {
         GXv_int30[39] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV161Wpbandejacitasds_27_tfsgcitadisponibilidadhorafin_to) )
      {
         addWhere(sWhereString, "(T3.[DisponibilidadHoraFin] <= ?)");
      }
      else
      {
         GXv_int30[40] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) && ( ! (GXutil.strcmp("", AV162Wpbandejacitasds_28_tfcitaarchivoextencion)==0) ) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] like ?)");
      }
      else
      {
         GXv_int30[41] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV163Wpbandejacitasds_29_tfcitaarchivoextencion_sel)==0) )
      {
         addWhere(sWhereString, "(T1.[CitaArchivoExtencion] = ?)");
      }
      else
      {
         GXv_int30[42] = (byte)(1) ;
      }
      if ( AV120SecRoleId != 1 )
      {
         addWhere(sWhereString, "(T3.[ProfesionalId] = ?)");
      }
      else
      {
         GXv_int30[43] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ( AV39OrderedBy == 1 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 1 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 2 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 2 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 3 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 3 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 4 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 4 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 5 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 5 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 6 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 6 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 7 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 7 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 8 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 8 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 9 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 9 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 10 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 10 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 11 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 11 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 12 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 12 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 13 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 13 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 14 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 14 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 15 ) && ! AV41OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV39OrderedBy == 15 ) && ( AV41OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
      GXv_Object31[0] = scmdbuf ;
      GXv_Object31[1] = GXv_int30 ;
      return GXv_Object31 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H002P2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).shortValue() , ((Boolean) dynConstraints[50]).booleanValue() );
            case 1 :
                  return conditional_H002P3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , (String)dynConstraints[9] , (String)dynConstraints[10] , (String)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , (String)dynConstraints[14] , (String)dynConstraints[15] , (String)dynConstraints[16] , (java.util.Date)dynConstraints[17] , (java.util.Date)dynConstraints[18] , (java.util.Date)dynConstraints[19] , (java.util.Date)dynConstraints[20] , (String)dynConstraints[21] , (String)dynConstraints[22] , (String)dynConstraints[23] , (String)dynConstraints[24] , (String)dynConstraints[25] , (String)dynConstraints[26] , ((Number) dynConstraints[27]).intValue() , ((Number) dynConstraints[28]).intValue() , (java.util.Date)dynConstraints[29] , (java.util.Date)dynConstraints[30] , (String)dynConstraints[31] , (String)dynConstraints[32] , ((Number) dynConstraints[33]).shortValue() , (String)dynConstraints[34] , (String)dynConstraints[35] , (String)dynConstraints[36] , (String)dynConstraints[37] , (String)dynConstraints[38] , (String)dynConstraints[39] , (String)dynConstraints[40] , (String)dynConstraints[41] , ((Number) dynConstraints[42]).intValue() , (java.util.Date)dynConstraints[43] , (java.util.Date)dynConstraints[44] , (java.util.Date)dynConstraints[45] , (String)dynConstraints[46] , ((Number) dynConstraints[47]).intValue() , ((Number) dynConstraints[48]).intValue() , ((Number) dynConstraints[49]).shortValue() , ((Boolean) dynConstraints[50]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002P2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002P3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002P4", "SELECT [SecUserId], [SecUserName], [SecUserEmail] FROM [SecUser] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H002P5", "SELECT [SecUserId], [SecRoleId] FROM [SecUserRole] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002P6", "SELECT [ProfesionalNroDocumento], [ProfesionalId] FROM [Profesional] WHERE [ProfesionalNroDocumento] = ? ORDER BY [ProfesionalId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[8])[0] = GXutil.resetDate(rslt.getGXDateTime(8));
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(9, 1);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(10, 1);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getVarchar(11);
               ((String[]) buf[15])[0] = rslt.getVarchar(12);
               ((String[]) buf[16])[0] = rslt.getVarchar(13);
               ((java.util.Date[]) buf[17])[0] = GXutil.resetDate(rslt.getGXDateTime(14));
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[19])[0] = rslt.getGXDate(15);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((String[]) buf[21])[0] = rslt.getVarchar(16);
               ((String[]) buf[22])[0] = rslt.getVarchar(17);
               ((String[]) buf[23])[0] = rslt.getVarchar(18);
               ((String[]) buf[24])[0] = rslt.getVarchar(19);
               ((String[]) buf[25])[0] = rslt.getVarchar(20);
               ((int[]) buf[26])[0] = rslt.getInt(21);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[61], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[62], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[64]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[65]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[73], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[74], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[75], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[76]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[77]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[78], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[79], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[83], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[84], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[86], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[87], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[88], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[89], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[90]).intValue());
               }
               if ( ((Number) parms[44]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[91]).intValue());
               }
               if ( ((Number) parms[45]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[92]).intValue());
               }
               if ( ((Number) parms[46]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[93]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[44], 100);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[45], 100);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[46], 100);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[47], 100);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[48], 100);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[49], 100);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[50], 100);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[51], 100);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[52], 100);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[53], 100);
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[54], 100);
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[55], 100);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[56], 100);
               }
               if ( ((Number) parms[13]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[57], 100);
               }
               if ( ((Number) parms[14]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[58], 100);
               }
               if ( ((Number) parms[15]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[59], 100);
               }
               if ( ((Number) parms[16]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[60], 100);
               }
               if ( ((Number) parms[17]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[61]).intValue());
               }
               if ( ((Number) parms[18]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[62]).intValue());
               }
               if ( ((Number) parms[19]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[63], 100);
               }
               if ( ((Number) parms[20]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[64], 100);
               }
               if ( ((Number) parms[21]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[65], 15);
               }
               if ( ((Number) parms[22]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[66], 15);
               }
               if ( ((Number) parms[23]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[67], 100);
               }
               if ( ((Number) parms[24]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[68], 100);
               }
               if ( ((Number) parms[25]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[69], 100);
               }
               if ( ((Number) parms[26]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[70], 100);
               }
               if ( ((Number) parms[27]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[71], 100);
               }
               if ( ((Number) parms[28]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[72], 100);
               }
               if ( ((Number) parms[29]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[73]);
               }
               if ( ((Number) parms[30]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[74]);
               }
               if ( ((Number) parms[31]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[75], true);
               }
               if ( ((Number) parms[32]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[76], true);
               }
               if ( ((Number) parms[33]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[77], 40);
               }
               if ( ((Number) parms[34]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[78], 40);
               }
               if ( ((Number) parms[35]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[79], 80);
               }
               if ( ((Number) parms[36]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[80], 80);
               }
               if ( ((Number) parms[37]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[81], 100);
               }
               if ( ((Number) parms[38]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[82], 100);
               }
               if ( ((Number) parms[39]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[83], true);
               }
               if ( ((Number) parms[40]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[84], true);
               }
               if ( ((Number) parms[41]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[85], 30);
               }
               if ( ((Number) parms[42]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[86], 30);
               }
               if ( ((Number) parms[43]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[87]).intValue());
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 15);
               return;
      }
   }

}

