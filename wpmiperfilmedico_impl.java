package com.projectthani ;
import com.projectthani.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class wpmiperfilmedico_impl extends GXDataArea
{
   public wpmiperfilmedico_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public wpmiperfilmedico_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wpmiperfilmedico_impl.class ));
   }

   public wpmiperfilmedico_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavProfesionaltipodocumento = new HTMLChoice();
      cmbavProfesionalsexo = new HTMLChoice();
      cmbavProfesionaltiempocita = new HTMLChoice();
      dynavPaisid = new HTMLChoice();
      cmbavUbigeodepartamento = new HTMLChoice();
      dynavUbigeoprovincia = new HTMLChoice();
      dynavUbigeodistrito = new HTMLChoice();
      dynavEspecialidadnombreid = new HTMLChoice();
      cmbavEspecialidadtipoconsulta = new HTMLChoice();
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta = new HTMLChoice();
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vUBIGEOPROVINCIA") == 0 )
         {
            AV70UbigeoDepartamento = httpContext.GetPar( "UbigeoDepartamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70UbigeoDepartamento", AV70UbigeoDepartamento);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvubigeoprovincia2Z2( AV70UbigeoDepartamento) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vUBIGEODISTRITO") == 0 )
         {
            AV70UbigeoDepartamento = httpContext.GetPar( "UbigeoDepartamento") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV70UbigeoDepartamento", AV70UbigeoDepartamento);
            AV72UbigeoProvincia = httpContext.GetPar( "UbigeoProvincia") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV72UbigeoProvincia", AV72UbigeoProvincia);
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvubigeodistrito2Z2( AV70UbigeoDepartamento, AV72UbigeoProvincia) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vESPECIALIDADNOMBREID") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvespecialidadnombreid2Z2( ) ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtprofesionalespecialidadsedes") == 0 )
         {
            nRC_GXsfl_169 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_169"))) ;
            nGXsfl_169_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_169_idx"))) ;
            sGXsfl_169_idx = httpContext.GetPar( "sGXsfl_169_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridsdtprofesionalespecialidadsedes_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtprofesionalespecialidadsedes") == 0 )
         {
            subGridsdtprofesionalespecialidadsedes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalespecialidadsedes_Rows"))) ;
            subGridsdtprofesionaleducacions_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionaleducacions_Rows"))) ;
            subGridsdtprofesionalexperiencialaborals_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalexperiencialaborals_Rows"))) ;
            subGridsdtprofesionalpremioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalpremioss_Rows"))) ;
            subGridsdtprofesionalservicioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalservicioss_Rows"))) ;
            dynavEspecialidadnombreid.fromJSonString( httpContext.GetNextPar( ));
            AV15EspecialidadNombreId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadNombreId"))) ;
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV36PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV6ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Class", GXutil.rtrim( Subirfotografia_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autoupload", GXutil.booltostr( Subirfotografia_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Hideadditionalbuttons", GXutil.booltostr( Subirfotografia_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Enableuploadedfilecanceling", GXutil.booltostr( Subirfotografia_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Subirfotografia_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autodisableaddingfiles", GXutil.booltostr( Subirfotografia_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Acceptedfiletypes", GXutil.rtrim( Subirfotografia_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Visible", GXutil.booltostr( Subirfotografia_Visible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Width", GXutil.rtrim( Dvpanel_panelregespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autowidth", GXutil.booltostr( Dvpanel_panelregespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoheight", GXutil.booltostr( Dvpanel_panelregespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Cls", GXutil.rtrim( Dvpanel_panelregespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Title", GXutil.rtrim( Dvpanel_panelregespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsible", GXutil.booltostr( Dvpanel_panelregespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsed", GXutil.booltostr( Dvpanel_panelregespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panelregespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Iconposition", GXutil.rtrim( Dvpanel_panelregespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoscroll", GXutil.booltostr( Dvpanel_panelregespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Width", GXutil.rtrim( Dvpanel_panellistespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autowidth", GXutil.booltostr( Dvpanel_panellistespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoheight", GXutil.booltostr( Dvpanel_panellistespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Cls", GXutil.rtrim( Dvpanel_panellistespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Title", GXutil.rtrim( Dvpanel_panellistespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsible", GXutil.booltostr( Dvpanel_panellistespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsed", GXutil.booltostr( Dvpanel_panellistespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panellistespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Iconposition", GXutil.rtrim( Dvpanel_panellistespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoscroll", GXutil.booltostr( Dvpanel_panellistespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Width", GXutil.rtrim( Dvpanel_paneleducacion_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autowidth", GXutil.booltostr( Dvpanel_paneleducacion_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoheight", GXutil.booltostr( Dvpanel_paneleducacion_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Cls", GXutil.rtrim( Dvpanel_paneleducacion_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Title", GXutil.rtrim( Dvpanel_paneleducacion_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsible", GXutil.booltostr( Dvpanel_paneleducacion_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsed", GXutil.booltostr( Dvpanel_paneleducacion_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacion_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Iconposition", GXutil.rtrim( Dvpanel_paneleducacion_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacion_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Width", GXutil.rtrim( Dvpanel_paneleducacionlist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autowidth", GXutil.booltostr( Dvpanel_paneleducacionlist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoheight", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Cls", GXutil.rtrim( Dvpanel_paneleducacionlist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Title", GXutil.rtrim( Dvpanel_paneleducacionlist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsible", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsed", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacionlist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Iconposition", GXutil.rtrim( Dvpanel_paneleducacionlist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Width", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Title", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Width", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Title", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Width", GXutil.rtrim( Dvpanel_panelpremioslogros_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogros_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Cls", GXutil.rtrim( Dvpanel_panelpremioslogros_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Title", GXutil.rtrim( Dvpanel_panelpremioslogros_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogros_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogros_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Width", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Cls", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Title", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Width", GXutil.rtrim( Dvpanel_panelservicios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autowidth", GXutil.booltostr( Dvpanel_panelservicios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoheight", GXutil.booltostr( Dvpanel_panelservicios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Cls", GXutil.rtrim( Dvpanel_panelservicios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Title", GXutil.rtrim( Dvpanel_panelservicios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsible", GXutil.booltostr( Dvpanel_panelservicios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsed", GXutil.booltostr( Dvpanel_panelservicios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Iconposition", GXutil.rtrim( Dvpanel_panelservicios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelservicios_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Width", GXutil.rtrim( Dvpanel_panelservicioslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelservicioslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelservicioslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Cls", GXutil.rtrim( Dvpanel_panelservicioslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Title", GXutil.rtrim( Dvpanel_panelservicioslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicioslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelservicioslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelservicioslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabinformacionpaciente_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Class", GXutil.rtrim( Gxuitabspanel_tabinformacionpaciente_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabinformacionpaciente_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtprofesionaleducacions") == 0 )
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
            gxnrgridsdtprofesionaleducacions_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtprofesionaleducacions") == 0 )
         {
            subGridsdtprofesionalespecialidadsedes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalespecialidadsedes_Rows"))) ;
            subGridsdtprofesionaleducacions_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionaleducacions_Rows"))) ;
            subGridsdtprofesionalexperiencialaborals_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalexperiencialaborals_Rows"))) ;
            subGridsdtprofesionalpremioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalpremioss_Rows"))) ;
            subGridsdtprofesionalservicioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalservicioss_Rows"))) ;
            dynavEspecialidadnombreid.fromJSonString( httpContext.GetNextPar( ));
            AV15EspecialidadNombreId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadNombreId"))) ;
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV36PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV6ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Class", GXutil.rtrim( Subirfotografia_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autoupload", GXutil.booltostr( Subirfotografia_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Hideadditionalbuttons", GXutil.booltostr( Subirfotografia_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Enableuploadedfilecanceling", GXutil.booltostr( Subirfotografia_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Subirfotografia_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autodisableaddingfiles", GXutil.booltostr( Subirfotografia_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Acceptedfiletypes", GXutil.rtrim( Subirfotografia_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Visible", GXutil.booltostr( Subirfotografia_Visible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Width", GXutil.rtrim( Dvpanel_panelregespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autowidth", GXutil.booltostr( Dvpanel_panelregespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoheight", GXutil.booltostr( Dvpanel_panelregespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Cls", GXutil.rtrim( Dvpanel_panelregespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Title", GXutil.rtrim( Dvpanel_panelregespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsible", GXutil.booltostr( Dvpanel_panelregespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsed", GXutil.booltostr( Dvpanel_panelregespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panelregespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Iconposition", GXutil.rtrim( Dvpanel_panelregespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoscroll", GXutil.booltostr( Dvpanel_panelregespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Width", GXutil.rtrim( Dvpanel_panellistespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autowidth", GXutil.booltostr( Dvpanel_panellistespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoheight", GXutil.booltostr( Dvpanel_panellistespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Cls", GXutil.rtrim( Dvpanel_panellistespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Title", GXutil.rtrim( Dvpanel_panellistespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsible", GXutil.booltostr( Dvpanel_panellistespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsed", GXutil.booltostr( Dvpanel_panellistespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panellistespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Iconposition", GXutil.rtrim( Dvpanel_panellistespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoscroll", GXutil.booltostr( Dvpanel_panellistespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Width", GXutil.rtrim( Dvpanel_paneleducacion_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autowidth", GXutil.booltostr( Dvpanel_paneleducacion_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoheight", GXutil.booltostr( Dvpanel_paneleducacion_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Cls", GXutil.rtrim( Dvpanel_paneleducacion_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Title", GXutil.rtrim( Dvpanel_paneleducacion_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsible", GXutil.booltostr( Dvpanel_paneleducacion_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsed", GXutil.booltostr( Dvpanel_paneleducacion_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacion_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Iconposition", GXutil.rtrim( Dvpanel_paneleducacion_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacion_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Width", GXutil.rtrim( Dvpanel_paneleducacionlist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autowidth", GXutil.booltostr( Dvpanel_paneleducacionlist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoheight", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Cls", GXutil.rtrim( Dvpanel_paneleducacionlist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Title", GXutil.rtrim( Dvpanel_paneleducacionlist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsible", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsed", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacionlist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Iconposition", GXutil.rtrim( Dvpanel_paneleducacionlist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Width", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Title", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Width", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Title", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Width", GXutil.rtrim( Dvpanel_panelpremioslogros_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogros_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Cls", GXutil.rtrim( Dvpanel_panelpremioslogros_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Title", GXutil.rtrim( Dvpanel_panelpremioslogros_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogros_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogros_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Width", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Cls", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Title", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Width", GXutil.rtrim( Dvpanel_panelservicios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autowidth", GXutil.booltostr( Dvpanel_panelservicios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoheight", GXutil.booltostr( Dvpanel_panelservicios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Cls", GXutil.rtrim( Dvpanel_panelservicios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Title", GXutil.rtrim( Dvpanel_panelservicios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsible", GXutil.booltostr( Dvpanel_panelservicios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsed", GXutil.booltostr( Dvpanel_panelservicios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Iconposition", GXutil.rtrim( Dvpanel_panelservicios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelservicios_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Width", GXutil.rtrim( Dvpanel_panelservicioslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelservicioslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelservicioslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Cls", GXutil.rtrim( Dvpanel_panelservicioslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Title", GXutil.rtrim( Dvpanel_panelservicioslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicioslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelservicioslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelservicioslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabinformacionpaciente_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Class", GXutil.rtrim( Gxuitabspanel_tabinformacionpaciente_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabinformacionpaciente_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtprofesionalexperiencialaborals") == 0 )
         {
            nRC_GXsfl_292 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_292"))) ;
            nGXsfl_292_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_292_idx"))) ;
            sGXsfl_292_idx = httpContext.GetPar( "sGXsfl_292_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridsdtprofesionalexperiencialaborals_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtprofesionalexperiencialaborals") == 0 )
         {
            subGridsdtprofesionalespecialidadsedes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalespecialidadsedes_Rows"))) ;
            subGridsdtprofesionaleducacions_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionaleducacions_Rows"))) ;
            subGridsdtprofesionalexperiencialaborals_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalexperiencialaborals_Rows"))) ;
            subGridsdtprofesionalpremioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalpremioss_Rows"))) ;
            subGridsdtprofesionalservicioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalservicioss_Rows"))) ;
            dynavEspecialidadnombreid.fromJSonString( httpContext.GetNextPar( ));
            AV15EspecialidadNombreId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadNombreId"))) ;
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV36PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV6ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Class", GXutil.rtrim( Subirfotografia_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autoupload", GXutil.booltostr( Subirfotografia_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Hideadditionalbuttons", GXutil.booltostr( Subirfotografia_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Enableuploadedfilecanceling", GXutil.booltostr( Subirfotografia_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Subirfotografia_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autodisableaddingfiles", GXutil.booltostr( Subirfotografia_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Acceptedfiletypes", GXutil.rtrim( Subirfotografia_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Visible", GXutil.booltostr( Subirfotografia_Visible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Width", GXutil.rtrim( Dvpanel_panelregespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autowidth", GXutil.booltostr( Dvpanel_panelregespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoheight", GXutil.booltostr( Dvpanel_panelregespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Cls", GXutil.rtrim( Dvpanel_panelregespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Title", GXutil.rtrim( Dvpanel_panelregespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsible", GXutil.booltostr( Dvpanel_panelregespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsed", GXutil.booltostr( Dvpanel_panelregespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panelregespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Iconposition", GXutil.rtrim( Dvpanel_panelregespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoscroll", GXutil.booltostr( Dvpanel_panelregespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Width", GXutil.rtrim( Dvpanel_panellistespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autowidth", GXutil.booltostr( Dvpanel_panellistespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoheight", GXutil.booltostr( Dvpanel_panellistespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Cls", GXutil.rtrim( Dvpanel_panellistespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Title", GXutil.rtrim( Dvpanel_panellistespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsible", GXutil.booltostr( Dvpanel_panellistespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsed", GXutil.booltostr( Dvpanel_panellistespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panellistespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Iconposition", GXutil.rtrim( Dvpanel_panellistespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoscroll", GXutil.booltostr( Dvpanel_panellistespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Width", GXutil.rtrim( Dvpanel_paneleducacion_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autowidth", GXutil.booltostr( Dvpanel_paneleducacion_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoheight", GXutil.booltostr( Dvpanel_paneleducacion_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Cls", GXutil.rtrim( Dvpanel_paneleducacion_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Title", GXutil.rtrim( Dvpanel_paneleducacion_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsible", GXutil.booltostr( Dvpanel_paneleducacion_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsed", GXutil.booltostr( Dvpanel_paneleducacion_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacion_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Iconposition", GXutil.rtrim( Dvpanel_paneleducacion_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacion_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Width", GXutil.rtrim( Dvpanel_paneleducacionlist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autowidth", GXutil.booltostr( Dvpanel_paneleducacionlist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoheight", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Cls", GXutil.rtrim( Dvpanel_paneleducacionlist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Title", GXutil.rtrim( Dvpanel_paneleducacionlist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsible", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsed", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacionlist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Iconposition", GXutil.rtrim( Dvpanel_paneleducacionlist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Width", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Title", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Width", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Title", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Width", GXutil.rtrim( Dvpanel_panelpremioslogros_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogros_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Cls", GXutil.rtrim( Dvpanel_panelpremioslogros_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Title", GXutil.rtrim( Dvpanel_panelpremioslogros_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogros_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogros_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Width", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Cls", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Title", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Width", GXutil.rtrim( Dvpanel_panelservicios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autowidth", GXutil.booltostr( Dvpanel_panelservicios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoheight", GXutil.booltostr( Dvpanel_panelservicios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Cls", GXutil.rtrim( Dvpanel_panelservicios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Title", GXutil.rtrim( Dvpanel_panelservicios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsible", GXutil.booltostr( Dvpanel_panelservicios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsed", GXutil.booltostr( Dvpanel_panelservicios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Iconposition", GXutil.rtrim( Dvpanel_panelservicios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelservicios_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Width", GXutil.rtrim( Dvpanel_panelservicioslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelservicioslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelservicioslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Cls", GXutil.rtrim( Dvpanel_panelservicioslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Title", GXutil.rtrim( Dvpanel_panelservicioslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicioslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelservicioslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelservicioslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabinformacionpaciente_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Class", GXutil.rtrim( Gxuitabspanel_tabinformacionpaciente_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabinformacionpaciente_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtprofesionalpremioss") == 0 )
         {
            nRC_GXsfl_348 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_348"))) ;
            nGXsfl_348_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_348_idx"))) ;
            sGXsfl_348_idx = httpContext.GetPar( "sGXsfl_348_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridsdtprofesionalpremioss_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtprofesionalpremioss") == 0 )
         {
            subGridsdtprofesionalespecialidadsedes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalespecialidadsedes_Rows"))) ;
            subGridsdtprofesionaleducacions_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionaleducacions_Rows"))) ;
            subGridsdtprofesionalexperiencialaborals_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalexperiencialaborals_Rows"))) ;
            subGridsdtprofesionalpremioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalpremioss_Rows"))) ;
            subGridsdtprofesionalservicioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalservicioss_Rows"))) ;
            dynavEspecialidadnombreid.fromJSonString( httpContext.GetNextPar( ));
            AV15EspecialidadNombreId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadNombreId"))) ;
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV36PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV6ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Class", GXutil.rtrim( Subirfotografia_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autoupload", GXutil.booltostr( Subirfotografia_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Hideadditionalbuttons", GXutil.booltostr( Subirfotografia_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Enableuploadedfilecanceling", GXutil.booltostr( Subirfotografia_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Subirfotografia_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autodisableaddingfiles", GXutil.booltostr( Subirfotografia_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Acceptedfiletypes", GXutil.rtrim( Subirfotografia_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Visible", GXutil.booltostr( Subirfotografia_Visible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Width", GXutil.rtrim( Dvpanel_panelregespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autowidth", GXutil.booltostr( Dvpanel_panelregespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoheight", GXutil.booltostr( Dvpanel_panelregespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Cls", GXutil.rtrim( Dvpanel_panelregespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Title", GXutil.rtrim( Dvpanel_panelregespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsible", GXutil.booltostr( Dvpanel_panelregespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsed", GXutil.booltostr( Dvpanel_panelregespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panelregespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Iconposition", GXutil.rtrim( Dvpanel_panelregespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoscroll", GXutil.booltostr( Dvpanel_panelregespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Width", GXutil.rtrim( Dvpanel_panellistespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autowidth", GXutil.booltostr( Dvpanel_panellistespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoheight", GXutil.booltostr( Dvpanel_panellistespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Cls", GXutil.rtrim( Dvpanel_panellistespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Title", GXutil.rtrim( Dvpanel_panellistespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsible", GXutil.booltostr( Dvpanel_panellistespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsed", GXutil.booltostr( Dvpanel_panellistespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panellistespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Iconposition", GXutil.rtrim( Dvpanel_panellistespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoscroll", GXutil.booltostr( Dvpanel_panellistespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Width", GXutil.rtrim( Dvpanel_paneleducacion_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autowidth", GXutil.booltostr( Dvpanel_paneleducacion_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoheight", GXutil.booltostr( Dvpanel_paneleducacion_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Cls", GXutil.rtrim( Dvpanel_paneleducacion_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Title", GXutil.rtrim( Dvpanel_paneleducacion_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsible", GXutil.booltostr( Dvpanel_paneleducacion_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsed", GXutil.booltostr( Dvpanel_paneleducacion_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacion_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Iconposition", GXutil.rtrim( Dvpanel_paneleducacion_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacion_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Width", GXutil.rtrim( Dvpanel_paneleducacionlist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autowidth", GXutil.booltostr( Dvpanel_paneleducacionlist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoheight", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Cls", GXutil.rtrim( Dvpanel_paneleducacionlist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Title", GXutil.rtrim( Dvpanel_paneleducacionlist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsible", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsed", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacionlist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Iconposition", GXutil.rtrim( Dvpanel_paneleducacionlist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Width", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Title", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Width", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Title", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Width", GXutil.rtrim( Dvpanel_panelpremioslogros_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogros_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Cls", GXutil.rtrim( Dvpanel_panelpremioslogros_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Title", GXutil.rtrim( Dvpanel_panelpremioslogros_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogros_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogros_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Width", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Cls", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Title", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Width", GXutil.rtrim( Dvpanel_panelservicios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autowidth", GXutil.booltostr( Dvpanel_panelservicios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoheight", GXutil.booltostr( Dvpanel_panelservicios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Cls", GXutil.rtrim( Dvpanel_panelservicios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Title", GXutil.rtrim( Dvpanel_panelservicios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsible", GXutil.booltostr( Dvpanel_panelservicios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsed", GXutil.booltostr( Dvpanel_panelservicios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Iconposition", GXutil.rtrim( Dvpanel_panelservicios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelservicios_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Width", GXutil.rtrim( Dvpanel_panelservicioslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelservicioslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelservicioslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Cls", GXutil.rtrim( Dvpanel_panelservicioslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Title", GXutil.rtrim( Dvpanel_panelservicioslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicioslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelservicioslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelservicioslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabinformacionpaciente_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Class", GXutil.rtrim( Gxuitabspanel_tabinformacionpaciente_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabinformacionpaciente_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            addString( httpContext.getJSONResponse( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdtprofesionalservicioss") == 0 )
         {
            nRC_GXsfl_386 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_386"))) ;
            nGXsfl_386_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_386_idx"))) ;
            sGXsfl_386_idx = httpContext.GetPar( "sGXsfl_386_idx") ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxnrgridsdtprofesionalservicioss_newrow( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdtprofesionalservicioss") == 0 )
         {
            subGridsdtprofesionalespecialidadsedes_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalespecialidadsedes_Rows"))) ;
            subGridsdtprofesionaleducacions_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionaleducacions_Rows"))) ;
            subGridsdtprofesionalexperiencialaborals_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalexperiencialaborals_Rows"))) ;
            subGridsdtprofesionalpremioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalpremioss_Rows"))) ;
            subGridsdtprofesionalservicioss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdtprofesionalservicioss_Rows"))) ;
            dynavEspecialidadnombreid.fromJSonString( httpContext.GetNextPar( ));
            AV15EspecialidadNombreId = (short)(GXutil.lval( httpContext.GetPar( "EspecialidadNombreId"))) ;
            dynavPaisid.fromJSonString( httpContext.GetNextPar( ));
            AV36PaisId = (short)(GXutil.lval( httpContext.GetPar( "PaisId"))) ;
            AV6ProfesionalId = (int)(GXutil.lval( httpContext.GetPar( "ProfesionalId"))) ;
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Class", GXutil.rtrim( Subirfotografia_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autoupload", GXutil.booltostr( Subirfotografia_Autoupload));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Hideadditionalbuttons", GXutil.booltostr( Subirfotografia_Hideadditionalbuttons));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Enableuploadedfilecanceling", GXutil.booltostr( Subirfotografia_Enableuploadedfilecanceling));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Subirfotografia_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autodisableaddingfiles", GXutil.booltostr( Subirfotografia_Autodisableaddingfiles));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Acceptedfiletypes", GXutil.rtrim( Subirfotografia_Acceptedfiletypes));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Visible", GXutil.booltostr( Subirfotografia_Visible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Width", GXutil.rtrim( Dvpanel_panelregespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autowidth", GXutil.booltostr( Dvpanel_panelregespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoheight", GXutil.booltostr( Dvpanel_panelregespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Cls", GXutil.rtrim( Dvpanel_panelregespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Title", GXutil.rtrim( Dvpanel_panelregespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsible", GXutil.booltostr( Dvpanel_panelregespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsed", GXutil.booltostr( Dvpanel_panelregespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panelregespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Iconposition", GXutil.rtrim( Dvpanel_panelregespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoscroll", GXutil.booltostr( Dvpanel_panelregespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Width", GXutil.rtrim( Dvpanel_panellistespe_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autowidth", GXutil.booltostr( Dvpanel_panellistespe_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoheight", GXutil.booltostr( Dvpanel_panellistespe_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Cls", GXutil.rtrim( Dvpanel_panellistespe_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Title", GXutil.rtrim( Dvpanel_panellistespe_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsible", GXutil.booltostr( Dvpanel_panellistespe_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsed", GXutil.booltostr( Dvpanel_panellistespe_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panellistespe_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Iconposition", GXutil.rtrim( Dvpanel_panellistespe_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoscroll", GXutil.booltostr( Dvpanel_panellistespe_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Width", GXutil.rtrim( Dvpanel_paneleducacion_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autowidth", GXutil.booltostr( Dvpanel_paneleducacion_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoheight", GXutil.booltostr( Dvpanel_paneleducacion_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Cls", GXutil.rtrim( Dvpanel_paneleducacion_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Title", GXutil.rtrim( Dvpanel_paneleducacion_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsible", GXutil.booltostr( Dvpanel_paneleducacion_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsed", GXutil.booltostr( Dvpanel_paneleducacion_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacion_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Iconposition", GXutil.rtrim( Dvpanel_paneleducacion_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacion_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Width", GXutil.rtrim( Dvpanel_paneleducacionlist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autowidth", GXutil.booltostr( Dvpanel_paneleducacionlist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoheight", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Cls", GXutil.rtrim( Dvpanel_paneleducacionlist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Title", GXutil.rtrim( Dvpanel_paneleducacionlist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsible", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsed", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacionlist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Iconposition", GXutil.rtrim( Dvpanel_paneleducacionlist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Width", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Title", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Width", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Title", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Width", GXutil.rtrim( Dvpanel_panelpremioslogros_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogros_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Cls", GXutil.rtrim( Dvpanel_panelpremioslogros_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Title", GXutil.rtrim( Dvpanel_panelpremioslogros_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogros_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogros_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Width", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Cls", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Title", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Width", GXutil.rtrim( Dvpanel_panelservicios_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autowidth", GXutil.booltostr( Dvpanel_panelservicios_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoheight", GXutil.booltostr( Dvpanel_panelservicios_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Cls", GXutil.rtrim( Dvpanel_panelservicios_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Title", GXutil.rtrim( Dvpanel_panelservicios_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsible", GXutil.booltostr( Dvpanel_panelservicios_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsed", GXutil.booltostr( Dvpanel_panelservicios_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicios_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Iconposition", GXutil.rtrim( Dvpanel_panelservicios_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelservicios_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showfirst));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showprevious));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Shownext));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showlast));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridclass));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Previous));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Next));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Caption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Width", GXutil.rtrim( Dvpanel_panelservicioslist_Width));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelservicioslist_Autowidth));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelservicioslist_Autoheight));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Cls", GXutil.rtrim( Dvpanel_panelservicioslist_Cls));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Title", GXutil.rtrim( Dvpanel_panelservicioslist_Title));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsible));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsed));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicioslist_Showcollapseicon));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelservicioslist_Iconposition));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelservicioslist_Autoscroll));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabinformacionpaciente_Pagecount, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Class", GXutil.rtrim( Gxuitabspanel_tabinformacionpaciente_Class));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabinformacionpaciente_Historymanagement));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
      pa2Z2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start2Z2( ) ;
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
      httpContext.AddJavascriptSource("gxcfg.js", "?2022511034140", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.projectthani.wpmiperfilmedico", new String[] {}, new String[] {}) +"\">") ;
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
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6ProfesionalId), "ZZZZZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalespecialidadsedes", AV59SDTProfesionalEspecialidadSedes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalespecialidadsedes", AV59SDTProfesionalEspecialidadSedes);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionaleducacions", AV58SDTProfesionalEducacions);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionaleducacions", AV58SDTProfesionalEducacions);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalexperiencialaborals", AV60SDTProfesionalExperienciaLaborals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalexperiencialaborals", AV60SDTProfesionalExperienciaLaborals);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalpremioss", AV62SDTProfesionalPremioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalpremioss", AV62SDTProfesionalPremioss);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdtprofesionalservicioss", AV63SDTProfesionalServicioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdtprofesionalservicioss", AV63SDTProfesionalServicioss);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_169", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_169, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_235", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_235, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_292", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_292, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_348", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_348, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_386", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_386, (byte)(8), (byte)(0), ",", "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vUPLOADEDFILES", AV73UploadedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vUPLOADEDFILES", AV73UploadedFiles);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vFAILEDFILES", AV21FailedFiles);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vFAILEDFILES", AV21FailedFiles);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALESPECIALIDADSEDESCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV25GridSDTProfesionalEspecialidadSedesCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALESPECIALIDADSEDESPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV26GridSDTProfesionalEspecialidadSedesPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEDUCACIONSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV23GridSDTProfesionalEducacionsCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEDUCACIONSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV24GridSDTProfesionalEducacionsPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEXPERIENCIALABORALSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV27GridSDTProfesionalExperienciaLaboralsCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALEXPERIENCIALABORALSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV28GridSDTProfesionalExperienciaLaboralsPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALPREMIOSSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV29GridSDTProfesionalPremiossCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALPREMIOSSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV30GridSDTProfesionalPremiossPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALSERVICIOSSCURRENTPAGE", GXutil.ltrim( localUtil.ntoc( AV31GridSDTProfesionalServiciossCurrentPage, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vGRIDSDTPROFESIONALSERVICIOSSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV32GridSDTProfesionalServiciossPageCount, (byte)(10), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV6ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6ProfesionalId), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALESPECIALIDADSEDES", AV59SDTProfesionalEspecialidadSedes);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALESPECIALIDADSEDES", AV59SDTProfesionalEspecialidadSedes);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALEDUCACIONS", AV58SDTProfesionalEducacions);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALEDUCACIONS", AV58SDTProfesionalEducacions);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALEXPERIENCIALABORALS", AV60SDTProfesionalExperienciaLaborals);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALEXPERIENCIALABORALS", AV60SDTProfesionalExperienciaLaborals);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALPREMIOSS", AV62SDTProfesionalPremioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALPREMIOSS", AV62SDTProfesionalPremioss);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDTPROFESIONALSERVICIOSS", AV63SDTProfesionalServicioss);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDTPROFESIONALSERVICIOSS", AV63SDTProfesionalServicioss);
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nEOF, (byte)(1), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Class", GXutil.rtrim( Subirfotografia_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autoupload", GXutil.booltostr( Subirfotografia_Autoupload));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Hideadditionalbuttons", GXutil.booltostr( Subirfotografia_Hideadditionalbuttons));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Enableuploadedfilecanceling", GXutil.booltostr( Subirfotografia_Enableuploadedfilecanceling));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Maxnumberoffiles", GXutil.ltrim( localUtil.ntoc( Subirfotografia_Maxnumberoffiles, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Autodisableaddingfiles", GXutil.booltostr( Subirfotografia_Autodisableaddingfiles));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Acceptedfiletypes", GXutil.rtrim( Subirfotografia_Acceptedfiletypes));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "SUBIRFOTOGRAFIA_Visible", GXutil.booltostr( Subirfotografia_Visible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Width", GXutil.rtrim( Dvpanel_panelregespe_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autowidth", GXutil.booltostr( Dvpanel_panelregespe_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoheight", GXutil.booltostr( Dvpanel_panelregespe_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Cls", GXutil.rtrim( Dvpanel_panelregespe_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Title", GXutil.rtrim( Dvpanel_panelregespe_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsible", GXutil.booltostr( Dvpanel_panelregespe_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Collapsed", GXutil.booltostr( Dvpanel_panelregespe_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panelregespe_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Iconposition", GXutil.rtrim( Dvpanel_panelregespe_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELREGESPE_Autoscroll", GXutil.booltostr( Dvpanel_panelregespe_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Width", GXutil.rtrim( Dvpanel_panellistespe_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autowidth", GXutil.booltostr( Dvpanel_panellistespe_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoheight", GXutil.booltostr( Dvpanel_panellistespe_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Cls", GXutil.rtrim( Dvpanel_panellistespe_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Title", GXutil.rtrim( Dvpanel_panellistespe_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsible", GXutil.booltostr( Dvpanel_panellistespe_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Collapsed", GXutil.booltostr( Dvpanel_panellistespe_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Showcollapseicon", GXutil.booltostr( Dvpanel_panellistespe_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Iconposition", GXutil.rtrim( Dvpanel_panellistespe_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELLISTESPE_Autoscroll", GXutil.booltostr( Dvpanel_panellistespe_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Width", GXutil.rtrim( Dvpanel_paneleducacion_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autowidth", GXutil.booltostr( Dvpanel_paneleducacion_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoheight", GXutil.booltostr( Dvpanel_paneleducacion_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Cls", GXutil.rtrim( Dvpanel_paneleducacion_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Title", GXutil.rtrim( Dvpanel_paneleducacion_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsible", GXutil.booltostr( Dvpanel_paneleducacion_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Collapsed", GXutil.booltostr( Dvpanel_paneleducacion_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacion_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Iconposition", GXutil.rtrim( Dvpanel_paneleducacion_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACION_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacion_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Width", GXutil.rtrim( Dvpanel_paneleducacionlist_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autowidth", GXutil.booltostr( Dvpanel_paneleducacionlist_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoheight", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Cls", GXutil.rtrim( Dvpanel_paneleducacionlist_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Title", GXutil.rtrim( Dvpanel_paneleducacionlist_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsible", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Collapsed", GXutil.booltostr( Dvpanel_paneleducacionlist_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_paneleducacionlist_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Iconposition", GXutil.rtrim( Dvpanel_paneleducacionlist_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEDUCACIONLIST_Autoscroll", GXutil.booltostr( Dvpanel_paneleducacionlist_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Width", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Title", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaboral_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORAL_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaboral_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Width", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autowidth", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoheight", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Cls", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Title", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsible", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsed", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Iconposition", GXutil.rtrim( Dvpanel_panelexperiencialaborallist_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelexperiencialaborallist_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Width", GXutil.rtrim( Dvpanel_panelpremioslogros_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogros_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Cls", GXutil.rtrim( Dvpanel_panelpremioslogros_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Title", GXutil.rtrim( Dvpanel_panelpremioslogros_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogros_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogros_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogros_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROS_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogros_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Width", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Cls", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Title", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelpremioslogroslist_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPREMIOSLOGROSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelpremioslogroslist_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Width", GXutil.rtrim( Dvpanel_panelservicios_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autowidth", GXutil.booltostr( Dvpanel_panelservicios_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoheight", GXutil.booltostr( Dvpanel_panelservicios_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Cls", GXutil.rtrim( Dvpanel_panelservicios_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Title", GXutil.rtrim( Dvpanel_panelservicios_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsible", GXutil.booltostr( Dvpanel_panelservicios_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Collapsed", GXutil.booltostr( Dvpanel_panelservicios_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicios_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Iconposition", GXutil.rtrim( Dvpanel_panelservicios_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOS_Autoscroll", GXutil.booltostr( Dvpanel_panelservicios_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Class", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showfirst));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showprevious));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Shownext));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Showlast));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridclass));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Previous));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Next", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Next));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Caption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Width", GXutil.rtrim( Dvpanel_panelservicioslist_Width));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autowidth", GXutil.booltostr( Dvpanel_panelservicioslist_Autowidth));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoheight", GXutil.booltostr( Dvpanel_panelservicioslist_Autoheight));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Cls", GXutil.rtrim( Dvpanel_panelservicioslist_Cls));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Title", GXutil.rtrim( Dvpanel_panelservicioslist_Title));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsible", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsible));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Collapsed", GXutil.booltostr( Dvpanel_panelservicioslist_Collapsed));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Showcollapseicon", GXutil.booltostr( Dvpanel_panelservicioslist_Showcollapseicon));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Iconposition", GXutil.rtrim( Dvpanel_panelservicioslist_Iconposition));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSERVICIOSLIST_Autoscroll", GXutil.booltostr( Dvpanel_panelservicioslist_Autoscroll));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Pagecount", GXutil.ltrim( localUtil.ntoc( Gxuitabspanel_tabinformacionpaciente_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Class", GXutil.rtrim( Gxuitabspanel_tabinformacionpaciente_Class));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GXUITABSPANEL_TABINFORMACIONPACIENTE_Historymanagement", GXutil.booltostr( Gxuitabspanel_tabinformacionpaciente_Historymanagement));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalservicioss_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalpremioss_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionaleducacions_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalserviciosspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalpremiosspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionaleducacionspaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
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
         we2Z2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt2Z2( ) ;
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
      return formatLink("com.projectthani.wpmiperfilmedico", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "WPMiPerfilMedico" ;
   }

   public String getPgmdesc( )
   {
      return "Mi Perfil " ;
   }

   public void wb2Z0( )
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
         com.projectthani.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGxuitabspanel_tabinformacionpaciente.setProperty("PageCount", Gxuitabspanel_tabinformacionpaciente_Pagecount);
         ucGxuitabspanel_tabinformacionpaciente.setProperty("Class", Gxuitabspanel_tabinformacionpaciente_Class);
         ucGxuitabspanel_tabinformacionpaciente.setProperty("HistoryManagement", Gxuitabspanel_tabinformacionpaciente_Historymanagement);
         ucGxuitabspanel_tabinformacionpaciente.render(context, "tab", Gxuitabspanel_tabinformacionpaciente_Internalname, "GXUITABSPANEL_TABINFORMACIONPACIENTEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabgeneral_title_Internalname, "INFORMACIÓN GENERAL", "", "", lblTabgeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabGeneral") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable6_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableMarginTop20px", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup7_Internalname, "INFORMACIÓN GENERAL", 1, 0, "px", 0, "px", "GroupPerfilMedico", "", "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divInformaciongeneral_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionaltipodocumento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionaltipodocumento.getInternalname(), "Tipo Documento", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionaltipodocumento, cmbavProfesionaltipodocumento.getInternalname(), GXutil.rtrim( AV56ProfesionalTipoDocumento), 1, cmbavProfesionaltipodocumento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavProfesionaltipodocumento.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,29);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         cmbavProfesionaltipodocumento.setValue( GXutil.rtrim( AV56ProfesionalTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltipodocumento.getInternalname(), "Values", cmbavProfesionaltipodocumento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalnrodocumento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalnrodocumento_Internalname, "Nro Documento", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 33,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalnrodocumento_Internalname, AV51ProfesionalNroDocumento, GXutil.rtrim( localUtil.format( AV51ProfesionalNroDocumento, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,33);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalnrodocumento_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionalnrodocumento_Enabled, 1, "text", "", 15, "chr", 1, "row", 15, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalnombres_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalnombres_Internalname, "Nombres", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalnombres_Internalname, AV50ProfesionalNombres, GXutil.rtrim( localUtil.format( AV50ProfesionalNombres, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalnombres_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionalnombres_Enabled, 1, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalapellidomaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalapellidomaterno_Internalname, "Apellido Materno", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalapellidomaterno_Internalname, AV42ProfesionalApellidoMaterno, GXutil.rtrim( localUtil.format( AV42ProfesionalApellidoMaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalapellidomaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionalapellidomaterno_Enabled, 1, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalapellidopaterno_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalapellidopaterno_Internalname, "Apellido Paterno", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalapellidopaterno_Internalname, AV43ProfesionalApellidoPaterno, GXutil.rtrim( localUtil.format( AV43ProfesionalApellidoPaterno, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,46);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalapellidopaterno_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionalapellidopaterno_Enabled, 1, "text", "", 50, "chr", 1, "row", 50, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalfechanacimiento_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalfechanacimiento_Internalname, "Fecha Nacimiento", " AttributeDateLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavProfesionalfechanacimiento_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalfechanacimiento_Internalname, localUtil.format(AV48ProfesionalFechaNacimiento, "99/99/9999"), localUtil.format( AV48ProfesionalFechaNacimiento, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,50);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalfechanacimiento_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavProfesionalfechanacimiento_Enabled, 1, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavProfesionalfechanacimiento_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavProfesionalfechanacimiento_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPMiPerfilMedico.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionalsexo.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionalsexo.getInternalname(), "Sexo", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionalsexo, cmbavProfesionalsexo.getInternalname(), GXutil.rtrim( AV53ProfesionalSexo), 1, cmbavProfesionalsexo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavProfesionalsexo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,55);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         cmbavProfesionalsexo.setValue( GXutil.rtrim( AV53ProfesionalSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalsexo.getInternalname(), "Values", cmbavProfesionalsexo.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalcop_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalcop_Internalname, "CMP", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalcop_Internalname, AV44ProfesionalCOP, GXutil.rtrim( localUtil.format( AV44ProfesionalCOP, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalcop_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionalcop_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionaltelefono_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionaltelefono_Internalname, "Teléfono", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionaltelefono_Internalname, GXutil.rtrim( AV54ProfesionalTelefono), GXutil.rtrim( localUtil.format( AV54ProfesionalTelefono, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionaltelefono_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionaltelefono_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionaldescripcion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionaldescripcion_Internalname, "Acerca de ti", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavProfesionaldescripcion_Internalname, AV46ProfesionalDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", (short)(0), 1, edtavProfesionaldescripcion_Enabled, 1, 40, "chr", 2, "row", StyleString, ClassString, "", "", "5000", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavProfesionaltiempocita.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavProfesionaltiempocita.getInternalname(), "Tiempo Cita", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavProfesionaltiempocita, cmbavProfesionaltiempocita.getInternalname(), GXutil.trim( GXutil.str( AV55ProfesionalTiempoCita, 2, 0)), 1, cmbavProfesionaltiempocita.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbavProfesionaltiempocita.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         cmbavProfesionaltiempocita.setValue( GXutil.trim( GXutil.str( AV55ProfesionalTiempoCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltiempocita.getInternalname(), "Values", cmbavProfesionaltiempocita.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavPaisid.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavPaisid.getInternalname(), "Nacionalidad", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavPaisid, dynavPaisid.getInternalname(), GXutil.trim( GXutil.str( AV36PaisId, 4, 0)), 1, dynavPaisid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavPaisid.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,76);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         dynavPaisid.setValue( GXutil.trim( GXutil.str( AV36PaisId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Values", dynavPaisid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup8_Internalname, "UBICACIÓN DE RESIDENCIA", 1, 0, "px", 0, "px", "GroupPerfilMedico", "", "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUbicacion_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavUbigeodepartamento.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavUbigeodepartamento.getInternalname(), "Departamento", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 85,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavUbigeodepartamento, cmbavUbigeodepartamento.getInternalname(), GXutil.rtrim( AV70UbigeoDepartamento), 1, cmbavUbigeodepartamento.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbavUbigeodepartamento.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,85);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         cmbavUbigeodepartamento.setValue( GXutil.rtrim( AV70UbigeoDepartamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUbigeodepartamento.getInternalname(), "Values", cmbavUbigeodepartamento.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavUbigeoprovincia.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavUbigeoprovincia.getInternalname(), "Provincia", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 89,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavUbigeoprovincia, dynavUbigeoprovincia.getInternalname(), GXutil.rtrim( AV72UbigeoProvincia), 1, dynavUbigeoprovincia.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavUbigeoprovincia.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,89);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         dynavUbigeoprovincia.setValue( GXutil.rtrim( AV72UbigeoProvincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavUbigeoprovincia.getInternalname(), "Values", dynavUbigeoprovincia.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavUbigeodistrito.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavUbigeodistrito.getInternalname(), "Distrito", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 93,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavUbigeodistrito, dynavUbigeodistrito.getInternalname(), GXutil.rtrim( AV71UbigeoDistrito), 1, dynavUbigeodistrito.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, dynavUbigeodistrito.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,93);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         dynavUbigeodistrito.setValue( GXutil.rtrim( AV71UbigeoDistrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavUbigeodistrito.getInternalname(), "Values", dynavUbigeodistrito.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionaldireccion_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionaldireccion_Internalname, "Dirección", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavProfesionaldireccion_Internalname, AV47ProfesionalDireccion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,98);\"", (short)(0), 1, edtavProfesionaldireccion_Enabled, 1, 80, "chr", 3, "row", StyleString, ClassString, "", "", "200", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup9_Internalname, "IMAGEN DE PERFIL", 1, 0, "px", 0, "px", "GroupPerfilMedico", "", "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divImagenperfil_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgavProfesionalfoto_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, "", "Fotografía", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "Attribute" ;
         StyleString = "" ;
         AV49ProfesionalFoto_IsBlob = (boolean)(((GXutil.strcmp("", AV49ProfesionalFoto)==0)&&(GXutil.strcmp("", AV99Profesionalfoto_GXI)==0))||!(GXutil.strcmp("", AV49ProfesionalFoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV49ProfesionalFoto)==0) ? AV99Profesionalfoto_GXI : httpContext.getResourceRelative(AV49ProfesionalFoto)) ;
         com.projectthani.GxWebStd.gx_bitmap( httpContext, imgavProfesionalfoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 1, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, AV49ProfesionalFoto_IsBlob, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 TableMarginTop25px", "left", "top", "", "", "div");
         /* User Defined Control */
         ucSubirfotografia.setProperty("Class", Subirfotografia_Class);
         ucSubirfotografia.setProperty("AutoUpload", Subirfotografia_Autoupload);
         ucSubirfotografia.setProperty("HideAdditionalButtons", Subirfotografia_Hideadditionalbuttons);
         ucSubirfotografia.setProperty("TooltipText", Subirfotografia_Tooltiptext);
         ucSubirfotografia.setProperty("EnableUploadedFileCanceling", Subirfotografia_Enableuploadedfilecanceling);
         ucSubirfotografia.setProperty("MaxNumberOfFiles", Subirfotografia_Maxnumberoffiles);
         ucSubirfotografia.setProperty("AutoDisableAddingFiles", Subirfotografia_Autodisableaddingfiles);
         ucSubirfotografia.setProperty("AcceptedFileTypes", Subirfotografia_Acceptedfiletypes);
         ucSubirfotografia.setProperty("UploadedFiles", AV73UploadedFiles);
         ucSubirfotografia.setProperty("FailedFiles", AV21FailedFiles);
         ucSubirfotografia.render(context, "fileupload", Subirfotografia_Internalname, "SUBIRFOTOGRAFIAContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Control Group */
         com.projectthani.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup10_Internalname, "INFORMACIÓN DE CUENTA", 1, 0, "px", 0, "px", "GroupPerfilMedico", "", "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divInfocuenta_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalcorreo_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalcorreo_Internalname, "Correo", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalcorreo_Internalname, AV45ProfesionalCorreo, GXutil.rtrim( localUtil.format( AV45ProfesionalCorreo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalcorreo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionalcorreo_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 TableMarginTop25px DscTop", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavProfesionalpassword_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavProfesionalpassword_Internalname, "Contraseña", " AttributeLabel", 1, true, "");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavProfesionalpassword_Internalname, AV52ProfesionalPassword, GXutil.rtrim( localUtil.format( AV52ProfesionalPassword, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,122);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavProfesionalpassword_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavProfesionalpassword_Enabled, 1, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(1), (byte)(0), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</fieldset>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnactualizarregistro_Internalname, "gx.evt.setGridEvt("+GXutil.str( 169, 3, 0)+","+"null"+");", "Actualizar Mis Datos", bttBtnbtnactualizarregistro_Jsonclick, 7, "Actualizar Mis Datos", "", StyleString, ClassString, bttBtnbtnactualizarregistro_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"e112z1_client"+"'", TempTags, "", 2, "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "Center", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnguardardatosactualizados_Internalname, "gx.evt.setGridEvt("+GXutil.str( 169, 3, 0)+","+"null"+");", "Guardar", bttBtnbtnguardardatosactualizados_Jsonclick, 5, "Guardar", "", StyleString, ClassString, bttBtnbtnguardardatosactualizados_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNGUARDARDATOSACTUALIZADOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "Center", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabespecialidad_title_Internalname, "ESPECIALIDAD", "", "", lblTabespecialidad_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabEspecialidad") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable5_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelregespe.setProperty("Width", Dvpanel_panelregespe_Width);
         ucDvpanel_panelregespe.setProperty("AutoWidth", Dvpanel_panelregespe_Autowidth);
         ucDvpanel_panelregespe.setProperty("AutoHeight", Dvpanel_panelregespe_Autoheight);
         ucDvpanel_panelregespe.setProperty("Cls", Dvpanel_panelregespe_Cls);
         ucDvpanel_panelregespe.setProperty("Title", Dvpanel_panelregespe_Title);
         ucDvpanel_panelregespe.setProperty("Collapsible", Dvpanel_panelregespe_Collapsible);
         ucDvpanel_panelregespe.setProperty("Collapsed", Dvpanel_panelregespe_Collapsed);
         ucDvpanel_panelregespe.setProperty("ShowCollapseIcon", Dvpanel_panelregespe_Showcollapseicon);
         ucDvpanel_panelregespe.setProperty("IconPosition", Dvpanel_panelregespe_Iconposition);
         ucDvpanel_panelregespe.setProperty("AutoScroll", Dvpanel_panelregespe_Autoscroll);
         ucDvpanel_panelregespe.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelregespe_Internalname, "DVPANEL_PANELREGESPEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELREGESPEContainer"+"PanelRegEspe"+"\" style=\"display:none;\">") ;
         wb_table1_138_2Z2( true) ;
      }
      else
      {
         wb_table1_138_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table1_138_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panellistespe.setProperty("Width", Dvpanel_panellistespe_Width);
         ucDvpanel_panellistespe.setProperty("AutoWidth", Dvpanel_panellistespe_Autowidth);
         ucDvpanel_panellistespe.setProperty("AutoHeight", Dvpanel_panellistespe_Autoheight);
         ucDvpanel_panellistespe.setProperty("Cls", Dvpanel_panellistespe_Cls);
         ucDvpanel_panellistespe.setProperty("Title", Dvpanel_panellistespe_Title);
         ucDvpanel_panellistespe.setProperty("Collapsible", Dvpanel_panellistespe_Collapsible);
         ucDvpanel_panellistespe.setProperty("Collapsed", Dvpanel_panellistespe_Collapsed);
         ucDvpanel_panellistespe.setProperty("ShowCollapseIcon", Dvpanel_panellistespe_Showcollapseicon);
         ucDvpanel_panellistespe.setProperty("IconPosition", Dvpanel_panellistespe_Iconposition);
         ucDvpanel_panellistespe.setProperty("AutoScroll", Dvpanel_panellistespe_Autoscroll);
         ucDvpanel_panellistespe.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panellistespe_Internalname, "DVPANEL_PANELLISTESPEContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELLISTESPEContainer"+"PanelListEspe"+"\" style=\"display:none;\">") ;
         wb_table2_163_2Z2( true) ;
      }
      else
      {
         wb_table2_163_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table2_163_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"title3"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabeducacion_title_Internalname, "EDUCACIÓN", "", "", lblTabeducacion_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabEducacion") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"panel3"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable4_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_paneleducacion.setProperty("Width", Dvpanel_paneleducacion_Width);
         ucDvpanel_paneleducacion.setProperty("AutoWidth", Dvpanel_paneleducacion_Autowidth);
         ucDvpanel_paneleducacion.setProperty("AutoHeight", Dvpanel_paneleducacion_Autoheight);
         ucDvpanel_paneleducacion.setProperty("Cls", Dvpanel_paneleducacion_Cls);
         ucDvpanel_paneleducacion.setProperty("Title", Dvpanel_paneleducacion_Title);
         ucDvpanel_paneleducacion.setProperty("Collapsible", Dvpanel_paneleducacion_Collapsible);
         ucDvpanel_paneleducacion.setProperty("Collapsed", Dvpanel_paneleducacion_Collapsed);
         ucDvpanel_paneleducacion.setProperty("ShowCollapseIcon", Dvpanel_paneleducacion_Showcollapseicon);
         ucDvpanel_paneleducacion.setProperty("IconPosition", Dvpanel_paneleducacion_Iconposition);
         ucDvpanel_paneleducacion.setProperty("AutoScroll", Dvpanel_paneleducacion_Autoscroll);
         ucDvpanel_paneleducacion.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_paneleducacion_Internalname, "DVPANEL_PANELEDUCACIONContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELEDUCACIONContainer"+"PanelEducacion"+"\" style=\"display:none;\">") ;
         wb_table3_186_2Z2( true) ;
      }
      else
      {
         wb_table3_186_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table3_186_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_paneleducacionlist.setProperty("Width", Dvpanel_paneleducacionlist_Width);
         ucDvpanel_paneleducacionlist.setProperty("AutoWidth", Dvpanel_paneleducacionlist_Autowidth);
         ucDvpanel_paneleducacionlist.setProperty("AutoHeight", Dvpanel_paneleducacionlist_Autoheight);
         ucDvpanel_paneleducacionlist.setProperty("Cls", Dvpanel_paneleducacionlist_Cls);
         ucDvpanel_paneleducacionlist.setProperty("Title", Dvpanel_paneleducacionlist_Title);
         ucDvpanel_paneleducacionlist.setProperty("Collapsible", Dvpanel_paneleducacionlist_Collapsible);
         ucDvpanel_paneleducacionlist.setProperty("Collapsed", Dvpanel_paneleducacionlist_Collapsed);
         ucDvpanel_paneleducacionlist.setProperty("ShowCollapseIcon", Dvpanel_paneleducacionlist_Showcollapseicon);
         ucDvpanel_paneleducacionlist.setProperty("IconPosition", Dvpanel_paneleducacionlist_Iconposition);
         ucDvpanel_paneleducacionlist.setProperty("AutoScroll", Dvpanel_paneleducacionlist_Autoscroll);
         ucDvpanel_paneleducacionlist.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_paneleducacionlist_Internalname, "DVPANEL_PANELEDUCACIONLISTContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELEDUCACIONLISTContainer"+"PanelEducacionList"+"\" style=\"display:none;\">") ;
         wb_table4_229_2Z2( true) ;
      }
      else
      {
         wb_table4_229_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table4_229_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"title4"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabexperiencialaboral_title_Internalname, "EXPERIENCIA LABORAL", "", "", lblTabexperiencialaboral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabExperienciaLaboral") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"panel4"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelexperiencialaboral.setProperty("Width", Dvpanel_panelexperiencialaboral_Width);
         ucDvpanel_panelexperiencialaboral.setProperty("AutoWidth", Dvpanel_panelexperiencialaboral_Autowidth);
         ucDvpanel_panelexperiencialaboral.setProperty("AutoHeight", Dvpanel_panelexperiencialaboral_Autoheight);
         ucDvpanel_panelexperiencialaboral.setProperty("Cls", Dvpanel_panelexperiencialaboral_Cls);
         ucDvpanel_panelexperiencialaboral.setProperty("Title", Dvpanel_panelexperiencialaboral_Title);
         ucDvpanel_panelexperiencialaboral.setProperty("Collapsible", Dvpanel_panelexperiencialaboral_Collapsible);
         ucDvpanel_panelexperiencialaboral.setProperty("Collapsed", Dvpanel_panelexperiencialaboral_Collapsed);
         ucDvpanel_panelexperiencialaboral.setProperty("ShowCollapseIcon", Dvpanel_panelexperiencialaboral_Showcollapseicon);
         ucDvpanel_panelexperiencialaboral.setProperty("IconPosition", Dvpanel_panelexperiencialaboral_Iconposition);
         ucDvpanel_panelexperiencialaboral.setProperty("AutoScroll", Dvpanel_panelexperiencialaboral_Autoscroll);
         ucDvpanel_panelexperiencialaboral.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelexperiencialaboral_Internalname, "DVPANEL_PANELEXPERIENCIALABORALContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELEXPERIENCIALABORALContainer"+"PanelExperienciaLaboral"+"\" style=\"display:none;\">") ;
         wb_table5_252_2Z2( true) ;
      }
      else
      {
         wb_table5_252_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table5_252_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelexperiencialaborallist.setProperty("Width", Dvpanel_panelexperiencialaborallist_Width);
         ucDvpanel_panelexperiencialaborallist.setProperty("AutoWidth", Dvpanel_panelexperiencialaborallist_Autowidth);
         ucDvpanel_panelexperiencialaborallist.setProperty("AutoHeight", Dvpanel_panelexperiencialaborallist_Autoheight);
         ucDvpanel_panelexperiencialaborallist.setProperty("Cls", Dvpanel_panelexperiencialaborallist_Cls);
         ucDvpanel_panelexperiencialaborallist.setProperty("Title", Dvpanel_panelexperiencialaborallist_Title);
         ucDvpanel_panelexperiencialaborallist.setProperty("Collapsible", Dvpanel_panelexperiencialaborallist_Collapsible);
         ucDvpanel_panelexperiencialaborallist.setProperty("Collapsed", Dvpanel_panelexperiencialaborallist_Collapsed);
         ucDvpanel_panelexperiencialaborallist.setProperty("ShowCollapseIcon", Dvpanel_panelexperiencialaborallist_Showcollapseicon);
         ucDvpanel_panelexperiencialaborallist.setProperty("IconPosition", Dvpanel_panelexperiencialaborallist_Iconposition);
         ucDvpanel_panelexperiencialaborallist.setProperty("AutoScroll", Dvpanel_panelexperiencialaborallist_Autoscroll);
         ucDvpanel_panelexperiencialaborallist.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelexperiencialaborallist_Internalname, "DVPANEL_PANELEXPERIENCIALABORALLISTContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELEXPERIENCIALABORALLISTContainer"+"PanelExperienciaLaboralList"+"\" style=\"display:none;\">") ;
         wb_table6_286_2Z2( true) ;
      }
      else
      {
         wb_table6_286_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table6_286_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"title5"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabpremioslogros_title_Internalname, "PREMIOS Y LOGROS", "", "", lblTabpremioslogros_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabPremiosLogros") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"panel5"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelpremioslogros.setProperty("Width", Dvpanel_panelpremioslogros_Width);
         ucDvpanel_panelpremioslogros.setProperty("AutoWidth", Dvpanel_panelpremioslogros_Autowidth);
         ucDvpanel_panelpremioslogros.setProperty("AutoHeight", Dvpanel_panelpremioslogros_Autoheight);
         ucDvpanel_panelpremioslogros.setProperty("Cls", Dvpanel_panelpremioslogros_Cls);
         ucDvpanel_panelpremioslogros.setProperty("Title", Dvpanel_panelpremioslogros_Title);
         ucDvpanel_panelpremioslogros.setProperty("Collapsible", Dvpanel_panelpremioslogros_Collapsible);
         ucDvpanel_panelpremioslogros.setProperty("Collapsed", Dvpanel_panelpremioslogros_Collapsed);
         ucDvpanel_panelpremioslogros.setProperty("ShowCollapseIcon", Dvpanel_panelpremioslogros_Showcollapseicon);
         ucDvpanel_panelpremioslogros.setProperty("IconPosition", Dvpanel_panelpremioslogros_Iconposition);
         ucDvpanel_panelpremioslogros.setProperty("AutoScroll", Dvpanel_panelpremioslogros_Autoscroll);
         ucDvpanel_panelpremioslogros.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelpremioslogros_Internalname, "DVPANEL_PANELPREMIOSLOGROSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELPREMIOSLOGROSContainer"+"PanelPremiosLogros"+"\" style=\"display:none;\">") ;
         wb_table7_308_2Z2( true) ;
      }
      else
      {
         wb_table7_308_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table7_308_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelpremioslogroslist.setProperty("Width", Dvpanel_panelpremioslogroslist_Width);
         ucDvpanel_panelpremioslogroslist.setProperty("AutoWidth", Dvpanel_panelpremioslogroslist_Autowidth);
         ucDvpanel_panelpremioslogroslist.setProperty("AutoHeight", Dvpanel_panelpremioslogroslist_Autoheight);
         ucDvpanel_panelpremioslogroslist.setProperty("Cls", Dvpanel_panelpremioslogroslist_Cls);
         ucDvpanel_panelpremioslogroslist.setProperty("Title", Dvpanel_panelpremioslogroslist_Title);
         ucDvpanel_panelpremioslogroslist.setProperty("Collapsible", Dvpanel_panelpremioslogroslist_Collapsible);
         ucDvpanel_panelpremioslogroslist.setProperty("Collapsed", Dvpanel_panelpremioslogroslist_Collapsed);
         ucDvpanel_panelpremioslogroslist.setProperty("ShowCollapseIcon", Dvpanel_panelpremioslogroslist_Showcollapseicon);
         ucDvpanel_panelpremioslogroslist.setProperty("IconPosition", Dvpanel_panelpremioslogroslist_Iconposition);
         ucDvpanel_panelpremioslogroslist.setProperty("AutoScroll", Dvpanel_panelpremioslogroslist_Autoscroll);
         ucDvpanel_panelpremioslogroslist.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelpremioslogroslist_Internalname, "DVPANEL_PANELPREMIOSLOGROSLISTContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELPREMIOSLOGROSLISTContainer"+"PanelPremiosLogrosList"+"\" style=\"display:none;\">") ;
         wb_table8_342_2Z2( true) ;
      }
      else
      {
         wb_table8_342_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table8_342_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"title6"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTabservicios_title_Internalname, "SERVICIOS", "", "", lblTabservicios_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "TabServicios") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"GXUITABSPANEL_TABINFORMACIONPACIENTEContainer"+"panel6"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-4", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelservicios.setProperty("Width", Dvpanel_panelservicios_Width);
         ucDvpanel_panelservicios.setProperty("AutoWidth", Dvpanel_panelservicios_Autowidth);
         ucDvpanel_panelservicios.setProperty("AutoHeight", Dvpanel_panelservicios_Autoheight);
         ucDvpanel_panelservicios.setProperty("Cls", Dvpanel_panelservicios_Cls);
         ucDvpanel_panelservicios.setProperty("Title", Dvpanel_panelservicios_Title);
         ucDvpanel_panelservicios.setProperty("Collapsible", Dvpanel_panelservicios_Collapsible);
         ucDvpanel_panelservicios.setProperty("Collapsed", Dvpanel_panelservicios_Collapsed);
         ucDvpanel_panelservicios.setProperty("ShowCollapseIcon", Dvpanel_panelservicios_Showcollapseicon);
         ucDvpanel_panelservicios.setProperty("IconPosition", Dvpanel_panelservicios_Iconposition);
         ucDvpanel_panelservicios.setProperty("AutoScroll", Dvpanel_panelservicios_Autoscroll);
         ucDvpanel_panelservicios.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelservicios_Internalname, "DVPANEL_PANELSERVICIOSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELSERVICIOSContainer"+"PanelServicios"+"\" style=\"display:none;\">") ;
         wb_table9_364_2Z2( true) ;
      }
      else
      {
         wb_table9_364_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table9_364_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-8", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelservicioslist.setProperty("Width", Dvpanel_panelservicioslist_Width);
         ucDvpanel_panelservicioslist.setProperty("AutoWidth", Dvpanel_panelservicioslist_Autowidth);
         ucDvpanel_panelservicioslist.setProperty("AutoHeight", Dvpanel_panelservicioslist_Autoheight);
         ucDvpanel_panelservicioslist.setProperty("Cls", Dvpanel_panelservicioslist_Cls);
         ucDvpanel_panelservicioslist.setProperty("Title", Dvpanel_panelservicioslist_Title);
         ucDvpanel_panelservicioslist.setProperty("Collapsible", Dvpanel_panelservicioslist_Collapsible);
         ucDvpanel_panelservicioslist.setProperty("Collapsed", Dvpanel_panelservicioslist_Collapsed);
         ucDvpanel_panelservicioslist.setProperty("ShowCollapseIcon", Dvpanel_panelservicioslist_Showcollapseicon);
         ucDvpanel_panelservicioslist.setProperty("IconPosition", Dvpanel_panelservicioslist_Iconposition);
         ucDvpanel_panelservicioslist.setProperty("AutoScroll", Dvpanel_panelservicioslist_Autoscroll);
         ucDvpanel_panelservicioslist.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelservicioslist_Internalname, "DVPANEL_PANELSERVICIOSLISTContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELSERVICIOSLISTContainer"+"PanelServiciosList"+"\" style=\"display:none;\">") ;
         wb_table10_380_2Z2( true) ;
      }
      else
      {
         wb_table10_380_2Z2( false) ;
      }
      return  ;
   }

   public void wb_table10_380_2Z2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtprofesionalservicioss_empowerer.render(context, "wwp.gridempowerer", Gridsdtprofesionalservicioss_empowerer_Internalname, "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERERContainer");
         /* User Defined Control */
         ucGridsdtprofesionalpremioss_empowerer.render(context, "wwp.gridempowerer", Gridsdtprofesionalpremioss_empowerer_Internalname, "GRIDSDTPROFESIONALPREMIOSS_EMPOWERERContainer");
         /* User Defined Control */
         ucGridsdtprofesionalexperiencialaborals_empowerer.render(context, "wwp.gridempowerer", Gridsdtprofesionalexperiencialaborals_empowerer_Internalname, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERERContainer");
         /* User Defined Control */
         ucGridsdtprofesionaleducacions_empowerer.render(context, "wwp.gridempowerer", Gridsdtprofesionaleducacions_empowerer_Internalname, "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERERContainer");
         /* User Defined Control */
         ucGridsdtprofesionalespecialidadsedes_empowerer.render(context, "wwp.gridempowerer", Gridsdtprofesionalespecialidadsedes_empowerer_Internalname, "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERERContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 169 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV77GXV1 = nGXsfl_169_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtprofesionalespecialidadsedesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalespecialidadsedes", GridsdtprofesionalespecialidadsedesContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalespecialidadsedesContainerData", GridsdtprofesionalespecialidadsedesContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalespecialidadsedesContainerData"+"V", GridsdtprofesionalespecialidadsedesContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalespecialidadsedesContainerData"+"V"+"\" value='"+GridsdtprofesionalespecialidadsedesContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 235 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV82GXV6 = nGXsfl_235_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtprofesionaleducacionsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionaleducacions", GridsdtprofesionaleducacionsContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionaleducacionsContainerData", GridsdtprofesionaleducacionsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionaleducacionsContainerData"+"V", GridsdtprofesionaleducacionsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionaleducacionsContainerData"+"V"+"\" value='"+GridsdtprofesionaleducacionsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 292 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV87GXV11 = nGXsfl_292_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtprofesionalexperiencialaboralsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalexperiencialaborals", GridsdtprofesionalexperiencialaboralsContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalexperiencialaboralsContainerData", GridsdtprofesionalexperiencialaboralsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalexperiencialaboralsContainerData"+"V", GridsdtprofesionalexperiencialaboralsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalexperiencialaboralsContainerData"+"V"+"\" value='"+GridsdtprofesionalexperiencialaboralsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 348 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV91GXV15 = nGXsfl_348_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtprofesionalpremiossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalpremioss", GridsdtprofesionalpremiossContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalpremiossContainerData", GridsdtprofesionalpremiossContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalpremiossContainerData"+"V", GridsdtprofesionalpremiossContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalpremiossContainerData"+"V"+"\" value='"+GridsdtprofesionalpremiossContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 386 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               AV95GXV19 = nGXsfl_386_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsdtprofesionalserviciossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalservicioss", GridsdtprofesionalserviciossContainer);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalserviciossContainerData", GridsdtprofesionalserviciossContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalserviciossContainerData"+"V", GridsdtprofesionalserviciossContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalserviciossContainerData"+"V"+"\" value='"+GridsdtprofesionalserviciossContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start2Z2( )
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
         Form.getMeta().addItem("description", "Mi Perfil ", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup2Z0( ) ;
   }

   public void ws2Z2( )
   {
      start2Z2( ) ;
      evt2Z2( ) ;
   }

   public void evt2Z2( )
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
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e122Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e132Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e142Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e152Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e162Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e172Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e182Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e192Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e202Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e212Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNADDSERVICIOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DobtnAddServicios' */
                           e222Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNADDPREMIOSLOGROS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DobtnAddPremiosLogros' */
                           e232Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNADDEXPERIENCIALABORAL'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DobtnAddExperienciaLaboral' */
                           e242Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNADDEDUCACION'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBtnAddEducacion' */
                           e252Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNADDESPECIALIDAD'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DobtnAddEspecialidad' */
                           e262Z2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOBTNGUARDARDATOSACTUALIZADOS'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoBtnGuardarDatosActualizados' */
                           e272Z2 ();
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
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 40), "GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_169_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_169_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_169_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1692( ) ;
                           AV77GXV1 = (int)(nGXsfl_169_idx+GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage) ;
                           if ( ( AV59SDTProfesionalEspecialidadSedes.size() >= AV77GXV1 ) && ( AV77GXV1 > 0 ) )
                           {
                              AV59SDTProfesionalEspecialidadSedes.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)) );
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
                                 e282Z2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e292Z2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e302Z2 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 33), "GRIDSDTPROFESIONALEDUCACIONS.LOAD") == 0 )
                        {
                           nGXsfl_235_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2358( ) ;
                           AV82GXV6 = (int)(nGXsfl_235_idx+GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage) ;
                           if ( ( AV58SDTProfesionalEducacions.size() >= AV82GXV6 ) && ( AV82GXV6 > 0 ) )
                           {
                              AV58SDTProfesionalEducacions.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEDUCACIONS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e312Z8 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 42), "GRIDSDTPROFESIONALEXPERIENCIALABORALS.LOAD") == 0 )
                        {
                           nGXsfl_292_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_292_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_292_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_2927( ) ;
                           AV87GXV11 = (int)(nGXsfl_292_idx+GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage) ;
                           if ( ( AV60SDTProfesionalExperienciaLaborals.size() >= AV87GXV11 ) && ( AV87GXV11 > 0 ) )
                           {
                              AV60SDTProfesionalExperienciaLaborals.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALEXPERIENCIALABORALS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e322Z7 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 31), "GRIDSDTPROFESIONALPREMIOSS.LOAD") == 0 )
                        {
                           nGXsfl_348_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_348_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_348_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_3486( ) ;
                           AV91GXV15 = (int)(nGXsfl_348_idx+GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage) ;
                           if ( ( AV62SDTProfesionalPremioss.size() >= AV91GXV15 ) && ( AV91GXV15 > 0 ) )
                           {
                              AV62SDTProfesionalPremioss.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALPREMIOSS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e332Z6 ();
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
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 33), "GRIDSDTPROFESIONALSERVICIOSS.LOAD") == 0 )
                        {
                           nGXsfl_386_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_386_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_386_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_3865( ) ;
                           AV95GXV19 = (int)(nGXsfl_386_idx+GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage) ;
                           if ( ( AV63SDTProfesionalServicioss.size() >= AV95GXV19 ) && ( AV95GXV19 > 0 ) )
                           {
                              AV63SDTProfesionalServicioss.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV63SDTProfesionalServicioss.elementAt(-1+AV95GXV19)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDTPROFESIONALSERVICIOSS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e342Z5 ();
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

   public void we2Z2( )
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

   public void pa2Z2( )
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
            GX_FocusControl = cmbavProfesionaltipodocumento.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvubigeodistrito_html2Z2( AV70UbigeoDepartamento, AV72UbigeoProvincia) ;
      /* End function dynload_actions */
   }

   public void gxdlvvpaisid2Z1( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvpaisid_data2Z1( ) ;
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

   public void gxvvpaisid_html2Z1( )
   {
      short gxdynajaxvalue;
      gxdlvvpaisid_data2Z1( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavPaisid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavPaisid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvpaisid_data2Z1( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H002Z2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H002Z2_A43PaisId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H002Z2_A184PaisDescripcion[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvubigeoprovincia2Z2( String AV70UbigeoDepartamento )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvubigeoprovincia_data2Z2( AV70UbigeoDepartamento) ;
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

   public void gxvvubigeoprovincia_html2Z2( String AV70UbigeoDepartamento )
   {
      String gxdynajaxvalue;
      gxdlvvubigeoprovincia_data2Z2( AV70UbigeoDepartamento) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavUbigeoprovincia.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavUbigeoprovincia.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvubigeoprovincia_data2Z2( String AV70UbigeoDepartamento )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H002Z3 */
      pr_default.execute(1, new Object[] {AV70UbigeoDepartamento});
      while ( (pr_default.getStatus(1) != 101) )
      {
         if ( GXutil.strcmp(H002Z3_A295UbigeoDepartamentoCode[0], AV70UbigeoDepartamento) == 0 )
         {
            gxdynajaxctrlcodr.add(H002Z3_A296UbigeoProvinciaCode[0]);
            gxdynajaxctrldescr.add(H002Z3_A187UbigeoProvincia[0]);
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxdlvvubigeodistrito2Z2( String AV70UbigeoDepartamento ,
                                        String AV72UbigeoProvincia )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvubigeodistrito_data2Z2( AV70UbigeoDepartamento, AV72UbigeoProvincia) ;
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

   public void gxvvubigeodistrito_html2Z2( String AV70UbigeoDepartamento ,
                                           String AV72UbigeoProvincia )
   {
      String gxdynajaxvalue;
      gxdlvvubigeodistrito_data2Z2( AV70UbigeoDepartamento, AV72UbigeoProvincia) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavUbigeodistrito.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynavUbigeodistrito.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvubigeodistrito_data2Z2( String AV70UbigeoDepartamento ,
                                                String AV72UbigeoProvincia )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add("");
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H002Z4 */
      pr_default.execute(2, new Object[] {AV70UbigeoDepartamento, AV72UbigeoProvincia});
      while ( (pr_default.getStatus(2) != 101) )
      {
         gxdynajaxctrlcodr.add(H002Z4_A297UbigeoDistritoCode[0]);
         gxdynajaxctrldescr.add(H002Z4_A188UbigeoDistrito[0]);
         pr_default.readNext(2);
      }
      pr_default.close(2);
   }

   public void gxdlvvespecialidadnombreid2Z2( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvespecialidadnombreid_data2Z2( ) ;
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

   public void gxvvespecialidadnombreid_html2Z2( )
   {
      short gxdynajaxvalue;
      gxdlvvespecialidadnombreid_data2Z2( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavEspecialidadnombreid.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavEspecialidadnombreid.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvespecialidadnombreid_data2Z2( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add("Seleccionar");
      /* Using cursor H002Z5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H002Z5_A32EspecialidadId[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H002Z5_A71EspecialidadNombre[0]);
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   public void gxnrgridsdtprofesionalespecialidadsedes_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1692( ) ;
      while ( nGXsfl_169_idx <= nRC_GXsfl_169 )
      {
         sendrow_1692( ) ;
         nGXsfl_169_idx = ((subGridsdtprofesionalespecialidadsedes_Islastpage==1)&&(nGXsfl_169_idx+1>subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ? 1 : nGXsfl_169_idx+1) ;
         sGXsfl_169_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_169_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1692( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalespecialidadsedesContainer)) ;
      /* End function gxnrGridsdtprofesionalespecialidadsedes_newrow */
   }

   public void gxnrgridsdtprofesionalservicioss_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_3865( ) ;
      while ( nGXsfl_386_idx <= nRC_GXsfl_386 )
      {
         sendrow_3865( ) ;
         nGXsfl_386_idx = ((subGridsdtprofesionalservicioss_Islastpage==1)&&(nGXsfl_386_idx+1>subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ? 1 : nGXsfl_386_idx+1) ;
         sGXsfl_386_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_386_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_3865( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalserviciossContainer)) ;
      /* End function gxnrGridsdtprofesionalservicioss_newrow */
   }

   public void gxnrgridsdtprofesionalpremioss_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_3486( ) ;
      while ( nGXsfl_348_idx <= nRC_GXsfl_348 )
      {
         sendrow_3486( ) ;
         nGXsfl_348_idx = ((subGridsdtprofesionalpremioss_Islastpage==1)&&(nGXsfl_348_idx+1>subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ? 1 : nGXsfl_348_idx+1) ;
         sGXsfl_348_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_348_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_3486( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalpremiossContainer)) ;
      /* End function gxnrGridsdtprofesionalpremioss_newrow */
   }

   public void gxnrgridsdtprofesionalexperiencialaborals_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2927( ) ;
      while ( nGXsfl_292_idx <= nRC_GXsfl_292 )
      {
         sendrow_2927( ) ;
         nGXsfl_292_idx = ((subGridsdtprofesionalexperiencialaborals_Islastpage==1)&&(nGXsfl_292_idx+1>subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ? 1 : nGXsfl_292_idx+1) ;
         sGXsfl_292_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_292_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2927( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionalexperiencialaboralsContainer)) ;
      /* End function gxnrGridsdtprofesionalexperiencialaborals_newrow */
   }

   public void gxnrgridsdtprofesionaleducacions_newrow( )
   {
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_2358( ) ;
      while ( nGXsfl_235_idx <= nRC_GXsfl_235 )
      {
         sendrow_2358( ) ;
         nGXsfl_235_idx = ((subGridsdtprofesionaleducacions_Islastpage==1)&&(nGXsfl_235_idx+1>subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
         sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2358( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsdtprofesionaleducacionsContainer)) ;
      /* End function gxnrGridsdtprofesionaleducacions_newrow */
   }

   public void gxgrgridsdtprofesionalespecialidadsedes_refresh( int subGridsdtprofesionalespecialidadsedes_Rows ,
                                                                int subGridsdtprofesionaleducacions_Rows ,
                                                                int subGridsdtprofesionalexperiencialaborals_Rows ,
                                                                int subGridsdtprofesionalpremioss_Rows ,
                                                                int subGridsdtprofesionalservicioss_Rows ,
                                                                short AV15EspecialidadNombreId ,
                                                                short AV36PaisId ,
                                                                int AV6ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e292Z2 ();
      GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord = 0 ;
      rf2Z2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtprofesionalespecialidadsedes_refresh */
   }

   public void gxgrgridsdtprofesionaleducacions_refresh( int subGridsdtprofesionalespecialidadsedes_Rows ,
                                                         int subGridsdtprofesionaleducacions_Rows ,
                                                         int subGridsdtprofesionalexperiencialaborals_Rows ,
                                                         int subGridsdtprofesionalpremioss_Rows ,
                                                         int subGridsdtprofesionalservicioss_Rows ,
                                                         short AV15EspecialidadNombreId ,
                                                         short AV36PaisId ,
                                                         int AV6ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e292Z2 ();
      GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord = 0 ;
      rf2Z8( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtprofesionaleducacions_refresh */
   }

   public void gxgrgridsdtprofesionalexperiencialaborals_refresh( int subGridsdtprofesionalespecialidadsedes_Rows ,
                                                                  int subGridsdtprofesionaleducacions_Rows ,
                                                                  int subGridsdtprofesionalexperiencialaborals_Rows ,
                                                                  int subGridsdtprofesionalpremioss_Rows ,
                                                                  int subGridsdtprofesionalservicioss_Rows ,
                                                                  short AV15EspecialidadNombreId ,
                                                                  short AV36PaisId ,
                                                                  int AV6ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e292Z2 ();
      GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord = 0 ;
      rf2Z7( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtprofesionalexperiencialaborals_refresh */
   }

   public void gxgrgridsdtprofesionalpremioss_refresh( int subGridsdtprofesionalespecialidadsedes_Rows ,
                                                       int subGridsdtprofesionaleducacions_Rows ,
                                                       int subGridsdtprofesionalexperiencialaborals_Rows ,
                                                       int subGridsdtprofesionalpremioss_Rows ,
                                                       int subGridsdtprofesionalservicioss_Rows ,
                                                       short AV15EspecialidadNombreId ,
                                                       short AV36PaisId ,
                                                       int AV6ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e292Z2 ();
      GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord = 0 ;
      rf2Z6( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtprofesionalpremioss_refresh */
   }

   public void gxgrgridsdtprofesionalservicioss_refresh( int subGridsdtprofesionalespecialidadsedes_Rows ,
                                                         int subGridsdtprofesionaleducacions_Rows ,
                                                         int subGridsdtprofesionalexperiencialaborals_Rows ,
                                                         int subGridsdtprofesionalpremioss_Rows ,
                                                         int subGridsdtprofesionalservicioss_Rows ,
                                                         short AV15EspecialidadNombreId ,
                                                         short AV36PaisId ,
                                                         int AV6ProfesionalId )
   {
      initialize_formulas( ) ;
      com.projectthani.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e292Z2 ();
      GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord = 0 ;
      rf2Z5( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdtprofesionalservicioss_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         gxvvespecialidadnombreid_html2Z2( ) ;
         dynavPaisid.setName( "vPAISID" );
         dynavPaisid.setWebtags( "" );
         dynavPaisid.removeAllItems();
         /* Using cursor H002Z6 */
         pr_default.execute(4);
         while ( (pr_default.getStatus(4) != 101) )
         {
            dynavPaisid.addItem(GXutil.trim( GXutil.str( H002Z6_A43PaisId[0], 4, 0)), H002Z6_A184PaisDescripcion[0], (short)(0));
            pr_default.readNext(4);
         }
         pr_default.close(4);
         if ( dynavPaisid.getItemCount() > 0 )
         {
            AV36PaisId = (short)(GXutil.lval( dynavPaisid.getValidValue(GXutil.trim( GXutil.str( AV36PaisId, 4, 0))))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36PaisId), 4, 0));
         }
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavProfesionaltipodocumento.getItemCount() > 0 )
      {
         AV56ProfesionalTipoDocumento = cmbavProfesionaltipodocumento.getValidValue(AV56ProfesionalTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56ProfesionalTipoDocumento", AV56ProfesionalTipoDocumento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionaltipodocumento.setValue( GXutil.rtrim( AV56ProfesionalTipoDocumento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltipodocumento.getInternalname(), "Values", cmbavProfesionaltipodocumento.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionalsexo.getItemCount() > 0 )
      {
         AV53ProfesionalSexo = cmbavProfesionalsexo.getValidValue(AV53ProfesionalSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53ProfesionalSexo", AV53ProfesionalSexo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionalsexo.setValue( GXutil.rtrim( AV53ProfesionalSexo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalsexo.getInternalname(), "Values", cmbavProfesionalsexo.ToJavascriptSource(), true);
      }
      if ( cmbavProfesionaltiempocita.getItemCount() > 0 )
      {
         AV55ProfesionalTiempoCita = (byte)(GXutil.lval( cmbavProfesionaltiempocita.getValidValue(GXutil.trim( GXutil.str( AV55ProfesionalTiempoCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55ProfesionalTiempoCita), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavProfesionaltiempocita.setValue( GXutil.trim( GXutil.str( AV55ProfesionalTiempoCita, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltiempocita.getInternalname(), "Values", cmbavProfesionaltiempocita.ToJavascriptSource(), true);
      }
      if ( dynavPaisid.getItemCount() > 0 )
      {
         AV36PaisId = (short)(GXutil.lval( dynavPaisid.getValidValue(GXutil.trim( GXutil.str( AV36PaisId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36PaisId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavPaisid.setValue( GXutil.trim( GXutil.str( AV36PaisId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Values", dynavPaisid.ToJavascriptSource(), true);
      }
      if ( cmbavUbigeodepartamento.getItemCount() > 0 )
      {
         AV70UbigeoDepartamento = cmbavUbigeodepartamento.getValidValue(AV70UbigeoDepartamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70UbigeoDepartamento", AV70UbigeoDepartamento);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavUbigeodepartamento.setValue( GXutil.rtrim( AV70UbigeoDepartamento) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavUbigeodepartamento.getInternalname(), "Values", cmbavUbigeodepartamento.ToJavascriptSource(), true);
      }
      if ( dynavUbigeoprovincia.getItemCount() > 0 )
      {
         AV72UbigeoProvincia = dynavUbigeoprovincia.getValidValue(AV72UbigeoProvincia) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV72UbigeoProvincia", AV72UbigeoProvincia);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavUbigeoprovincia.setValue( GXutil.rtrim( AV72UbigeoProvincia) );
         httpContext.ajax_rsp_assign_prop("", false, dynavUbigeoprovincia.getInternalname(), "Values", dynavUbigeoprovincia.ToJavascriptSource(), true);
      }
      if ( dynavUbigeodistrito.getItemCount() > 0 )
      {
         AV71UbigeoDistrito = dynavUbigeodistrito.getValidValue(AV71UbigeoDistrito) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71UbigeoDistrito", AV71UbigeoDistrito);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavUbigeodistrito.setValue( GXutil.rtrim( AV71UbigeoDistrito) );
         httpContext.ajax_rsp_assign_prop("", false, dynavUbigeodistrito.getInternalname(), "Values", dynavUbigeodistrito.ToJavascriptSource(), true);
      }
      if ( dynavEspecialidadnombreid.getItemCount() > 0 )
      {
         AV15EspecialidadNombreId = (short)(GXutil.lval( dynavEspecialidadnombreid.getValidValue(GXutil.trim( GXutil.str( AV15EspecialidadNombreId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15EspecialidadNombreId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EspecialidadNombreId), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavEspecialidadnombreid.setValue( GXutil.trim( GXutil.str( AV15EspecialidadNombreId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadnombreid.getInternalname(), "Values", dynavEspecialidadnombreid.ToJavascriptSource(), true);
      }
      if ( cmbavEspecialidadtipoconsulta.getItemCount() > 0 )
      {
         AV16EspecialidadTipoConsulta = cmbavEspecialidadtipoconsulta.getValidValue(AV16EspecialidadTipoConsulta) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16EspecialidadTipoConsulta", AV16EspecialidadTipoConsulta);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavEspecialidadtipoconsulta.setValue( GXutil.rtrim( AV16EspecialidadTipoConsulta) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEspecialidadtipoconsulta.getInternalname(), "Values", cmbavEspecialidadtipoconsulta.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf2Z2( ) ;
      rf2Z8( ) ;
      rf2Z7( ) ;
      rf2Z6( ) ;
      rf2Z5( ) ;
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
      edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled), 5, 0), !bGXsfl_169_Refreshing);
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled), 5, 0), !bGXsfl_169_Refreshing);
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled), 5, 0), !bGXsfl_169_Refreshing);
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled(), 5, 0), !bGXsfl_169_Refreshing);
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educaciondesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educaciondesde_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionhasta_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled), 5, 0), !bGXsfl_292_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled), 5, 0), !bGXsfl_292_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled), 5, 0), !bGXsfl_292_Refreshing);
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosnombre_Enabled), 5, 0), !bGXsfl_348_Refreshing);
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosfecha_Enabled), 5, 0), !bGXsfl_348_Refreshing);
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosdescripcion_Enabled), 5, 0), !bGXsfl_348_Refreshing);
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalservicioss__serviciosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalservicioss__serviciosnombre_Enabled), 5, 0), !bGXsfl_386_Refreshing);
   }

   public void rf2Z2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalespecialidadsedesContainer.ClearRows();
      }
      wbStart = (short)(169) ;
      /* Execute user event: Refresh */
      e292Z2 ();
      nGXsfl_169_idx = 1 ;
      sGXsfl_169_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_169_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1692( ) ;
      bGXsfl_169_Refreshing = true ;
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("GridName", "Gridsdtprofesionalespecialidadsedes");
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("CmpContext", "");
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtprofesionalespecialidadsedesContainer.setPageSize( subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1692( ) ;
         e302Z2 ();
         if ( ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nGridOutOfScope == 0 ) && ( nGXsfl_169_idx == 1 ) )
         {
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nGridOutOfScope = 1 ;
            subgridsdtprofesionalespecialidadsedes_firstpage( ) ;
            e302Z2 ();
         }
         wbEnd = (short)(169) ;
         wb2Z0( ) ;
      }
      bGXsfl_169_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2Z2( )
   {
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "vPROFESIONALID", GXutil.ltrim( localUtil.ntoc( AV6ProfesionalId, (byte)(8), (byte)(0), ",", "")));
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6ProfesionalId), "ZZZZZZZ9")));
   }

   public void rf2Z5( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalserviciossContainer.ClearRows();
      }
      wbStart = (short)(386) ;
      nGXsfl_386_idx = 1 ;
      sGXsfl_386_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_386_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_3865( ) ;
      bGXsfl_386_Refreshing = true ;
      GridsdtprofesionalserviciossContainer.AddObjectProperty("GridName", "Gridsdtprofesionalservicioss");
      GridsdtprofesionalserviciossContainer.AddObjectProperty("CmpContext", "");
      GridsdtprofesionalserviciossContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtprofesionalserviciossContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridsdtprofesionalserviciossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalserviciossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalserviciossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtprofesionalserviciossContainer.setPageSize( subgridsdtprofesionalservicioss_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_3865( ) ;
         e342Z5 ();
         if ( ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALSERVICIOSS_nGridOutOfScope == 0 ) && ( nGXsfl_386_idx == 1 ) )
         {
            GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALSERVICIOSS_nGridOutOfScope = 1 ;
            subgridsdtprofesionalservicioss_firstpage( ) ;
            e342Z5 ();
         }
         wbEnd = (short)(386) ;
         wb2Z0( ) ;
      }
      bGXsfl_386_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2Z5( )
   {
   }

   public void rf2Z6( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalpremiossContainer.ClearRows();
      }
      wbStart = (short)(348) ;
      nGXsfl_348_idx = 1 ;
      sGXsfl_348_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_348_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_3486( ) ;
      bGXsfl_348_Refreshing = true ;
      GridsdtprofesionalpremiossContainer.AddObjectProperty("GridName", "Gridsdtprofesionalpremioss");
      GridsdtprofesionalpremiossContainer.AddObjectProperty("CmpContext", "");
      GridsdtprofesionalpremiossContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtprofesionalpremiossContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridsdtprofesionalpremiossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalpremiossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalpremiossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtprofesionalpremiossContainer.setPageSize( subgridsdtprofesionalpremioss_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_3486( ) ;
         e332Z6 ();
         if ( ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALPREMIOSS_nGridOutOfScope == 0 ) && ( nGXsfl_348_idx == 1 ) )
         {
            GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALPREMIOSS_nGridOutOfScope = 1 ;
            subgridsdtprofesionalpremioss_firstpage( ) ;
            e332Z6 ();
         }
         wbEnd = (short)(348) ;
         wb2Z0( ) ;
      }
      bGXsfl_348_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2Z6( )
   {
   }

   public void rf2Z7( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionalexperiencialaboralsContainer.ClearRows();
      }
      wbStart = (short)(292) ;
      nGXsfl_292_idx = 1 ;
      sGXsfl_292_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_292_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2927( ) ;
      bGXsfl_292_Refreshing = true ;
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("GridName", "Gridsdtprofesionalexperiencialaborals");
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("CmpContext", "");
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtprofesionalexperiencialaboralsContainer.setPageSize( subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2927( ) ;
         e322Z7 ();
         if ( ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nGridOutOfScope == 0 ) && ( nGXsfl_292_idx == 1 ) )
         {
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nGridOutOfScope = 1 ;
            subgridsdtprofesionalexperiencialaborals_firstpage( ) ;
            e322Z7 ();
         }
         wbEnd = (short)(292) ;
         wb2Z0( ) ;
      }
      bGXsfl_292_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2Z7( )
   {
   }

   public void rf2Z8( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsdtprofesionaleducacionsContainer.ClearRows();
      }
      wbStart = (short)(235) ;
      nGXsfl_235_idx = 1 ;
      sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_2358( ) ;
      bGXsfl_235_Refreshing = true ;
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("GridName", "Gridsdtprofesionaleducacions");
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("CmpContext", "");
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("InMasterPage", "false");
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsdtprofesionaleducacionsContainer.setPageSize( subgridsdtprofesionaleducacions_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_2358( ) ;
         e312Z8 ();
         if ( ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord > 0 ) && ( GRIDSDTPROFESIONALEDUCACIONS_nGridOutOfScope == 0 ) && ( nGXsfl_235_idx == 1 ) )
         {
            GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord = 0 ;
            GRIDSDTPROFESIONALEDUCACIONS_nGridOutOfScope = 1 ;
            subgridsdtprofesionaleducacions_firstpage( ) ;
            e312Z8 ();
         }
         wbEnd = (short)(235) ;
         wb2Z0( ) ;
      }
      bGXsfl_235_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes2Z8( )
   {
   }

   public int subgridsdtprofesionalespecialidadsedes_fnc_pagecount( )
   {
      GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount = subgridsdtprofesionalespecialidadsedes_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount) % (subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount/ (double) (subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount/ (double) (subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtprofesionalespecialidadsedes_fnc_recordcount( )
   {
      return AV59SDTProfesionalEspecialidadSedes.size() ;
   }

   public int subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )
   {
      if ( subGridsdtprofesionalespecialidadsedes_Rows > 0 )
      {
         return subGridsdtprofesionalespecialidadsedes_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtprofesionalespecialidadsedes_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage/ (double) (subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtprofesionalespecialidadsedes_firstpage( )
   {
      GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalespecialidadsedes_nextpage( )
   {
      GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount = subgridsdtprofesionalespecialidadsedes_fnc_recordcount( ) ;
      if ( ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount >= subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) ) && ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF == 0 ) )
      {
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage+subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage", GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtprofesionalespecialidadsedes_previouspage( )
   {
      if ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage >= subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) )
      {
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage-subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalespecialidadsedes_lastpage( )
   {
      GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount = subgridsdtprofesionalespecialidadsedes_fnc_recordcount( ) ;
      if ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount > subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount) % (subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount-subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount-((int)((GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount) % (subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtprofesionalespecialidadsedes_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = (long)(subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalespecialidadsedes_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridsdtprofesionalservicioss_fnc_pagecount( )
   {
      GRIDSDTPROFESIONALSERVICIOSS_nRecordCount = subgridsdtprofesionalservicioss_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTPROFESIONALSERVICIOSS_nRecordCount) % (subgridsdtprofesionalservicioss_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTPROFESIONALSERVICIOSS_nRecordCount/ (double) (subgridsdtprofesionalservicioss_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTPROFESIONALSERVICIOSS_nRecordCount/ (double) (subgridsdtprofesionalservicioss_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtprofesionalservicioss_fnc_recordcount( )
   {
      return AV63SDTProfesionalServicioss.size() ;
   }

   public int subgridsdtprofesionalservicioss_fnc_recordsperpage( )
   {
      if ( subGridsdtprofesionalservicioss_Rows > 0 )
      {
         return subGridsdtprofesionalservicioss_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtprofesionalservicioss_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage/ (double) (subgridsdtprofesionalservicioss_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtprofesionalservicioss_firstpage( )
   {
      GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalservicioss_nextpage( )
   {
      GRIDSDTPROFESIONALSERVICIOSS_nRecordCount = subgridsdtprofesionalservicioss_fnc_recordcount( ) ;
      if ( ( GRIDSDTPROFESIONALSERVICIOSS_nRecordCount >= subgridsdtprofesionalservicioss_fnc_recordsperpage( ) ) && ( GRIDSDTPROFESIONALSERVICIOSS_nEOF == 0 ) )
      {
         GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage+subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtprofesionalserviciossContainer.AddObjectProperty("GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage", GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTPROFESIONALSERVICIOSS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtprofesionalservicioss_previouspage( )
   {
      if ( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage >= subgridsdtprofesionalservicioss_fnc_recordsperpage( ) )
      {
         GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage-subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalservicioss_lastpage( )
   {
      GRIDSDTPROFESIONALSERVICIOSS_nRecordCount = subgridsdtprofesionalservicioss_fnc_recordcount( ) ;
      if ( GRIDSDTPROFESIONALSERVICIOSS_nRecordCount > subgridsdtprofesionalservicioss_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTPROFESIONALSERVICIOSS_nRecordCount) % (subgridsdtprofesionalservicioss_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALSERVICIOSS_nRecordCount-subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALSERVICIOSS_nRecordCount-((int)((GRIDSDTPROFESIONALSERVICIOSS_nRecordCount) % (subgridsdtprofesionalservicioss_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtprofesionalservicioss_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = (long)(subgridsdtprofesionalservicioss_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalservicioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridsdtprofesionalpremioss_fnc_pagecount( )
   {
      GRIDSDTPROFESIONALPREMIOSS_nRecordCount = subgridsdtprofesionalpremioss_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTPROFESIONALPREMIOSS_nRecordCount) % (subgridsdtprofesionalpremioss_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTPROFESIONALPREMIOSS_nRecordCount/ (double) (subgridsdtprofesionalpremioss_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTPROFESIONALPREMIOSS_nRecordCount/ (double) (subgridsdtprofesionalpremioss_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtprofesionalpremioss_fnc_recordcount( )
   {
      return AV62SDTProfesionalPremioss.size() ;
   }

   public int subgridsdtprofesionalpremioss_fnc_recordsperpage( )
   {
      if ( subGridsdtprofesionalpremioss_Rows > 0 )
      {
         return subGridsdtprofesionalpremioss_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtprofesionalpremioss_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage/ (double) (subgridsdtprofesionalpremioss_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtprofesionalpremioss_firstpage( )
   {
      GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalpremioss_nextpage( )
   {
      GRIDSDTPROFESIONALPREMIOSS_nRecordCount = subgridsdtprofesionalpremioss_fnc_recordcount( ) ;
      if ( ( GRIDSDTPROFESIONALPREMIOSS_nRecordCount >= subgridsdtprofesionalpremioss_fnc_recordsperpage( ) ) && ( GRIDSDTPROFESIONALPREMIOSS_nEOF == 0 ) )
      {
         GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage+subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtprofesionalpremiossContainer.AddObjectProperty("GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage", GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTPROFESIONALPREMIOSS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtprofesionalpremioss_previouspage( )
   {
      if ( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage >= subgridsdtprofesionalpremioss_fnc_recordsperpage( ) )
      {
         GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage-subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalpremioss_lastpage( )
   {
      GRIDSDTPROFESIONALPREMIOSS_nRecordCount = subgridsdtprofesionalpremioss_fnc_recordcount( ) ;
      if ( GRIDSDTPROFESIONALPREMIOSS_nRecordCount > subgridsdtprofesionalpremioss_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTPROFESIONALPREMIOSS_nRecordCount) % (subgridsdtprofesionalpremioss_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALPREMIOSS_nRecordCount-subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALPREMIOSS_nRecordCount-((int)((GRIDSDTPROFESIONALPREMIOSS_nRecordCount) % (subgridsdtprofesionalpremioss_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtprofesionalpremioss_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = (long)(subgridsdtprofesionalpremioss_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalpremioss_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridsdtprofesionalexperiencialaborals_fnc_pagecount( )
   {
      GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount = subgridsdtprofesionalexperiencialaborals_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount) % (subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount/ (double) (subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount/ (double) (subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtprofesionalexperiencialaborals_fnc_recordcount( )
   {
      return AV60SDTProfesionalExperienciaLaborals.size() ;
   }

   public int subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )
   {
      if ( subGridsdtprofesionalexperiencialaborals_Rows > 0 )
      {
         return subGridsdtprofesionalexperiencialaborals_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtprofesionalexperiencialaborals_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage/ (double) (subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtprofesionalexperiencialaborals_firstpage( )
   {
      GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalexperiencialaborals_nextpage( )
   {
      GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount = subgridsdtprofesionalexperiencialaborals_fnc_recordcount( ) ;
      if ( ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount >= subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) ) && ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF == 0 ) )
      {
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage+subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage", GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtprofesionalexperiencialaborals_previouspage( )
   {
      if ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage >= subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) )
      {
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage-subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionalexperiencialaborals_lastpage( )
   {
      GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount = subgridsdtprofesionalexperiencialaborals_fnc_recordcount( ) ;
      if ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount > subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount) % (subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount-subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount-((int)((GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount) % (subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtprofesionalexperiencialaborals_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = (long)(subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionalexperiencialaborals_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridsdtprofesionaleducacions_fnc_pagecount( )
   {
      GRIDSDTPROFESIONALEDUCACIONS_nRecordCount = subgridsdtprofesionaleducacions_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDTPROFESIONALEDUCACIONS_nRecordCount) % (subgridsdtprofesionaleducacions_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDTPROFESIONALEDUCACIONS_nRecordCount/ (double) (subgridsdtprofesionaleducacions_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDTPROFESIONALEDUCACIONS_nRecordCount/ (double) (subgridsdtprofesionaleducacions_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdtprofesionaleducacions_fnc_recordcount( )
   {
      return AV58SDTProfesionalEducacions.size() ;
   }

   public int subgridsdtprofesionaleducacions_fnc_recordsperpage( )
   {
      if ( subGridsdtprofesionaleducacions_Rows > 0 )
      {
         return subGridsdtprofesionaleducacions_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdtprofesionaleducacions_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage/ (double) (subgridsdtprofesionaleducacions_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdtprofesionaleducacions_firstpage( )
   {
      GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = 0 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionaleducacions_nextpage( )
   {
      GRIDSDTPROFESIONALEDUCACIONS_nRecordCount = subgridsdtprofesionaleducacions_fnc_recordcount( ) ;
      if ( ( GRIDSDTPROFESIONALEDUCACIONS_nRecordCount >= subgridsdtprofesionaleducacions_fnc_recordsperpage( ) ) && ( GRIDSDTPROFESIONALEDUCACIONS_nEOF == 0 ) )
      {
         GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage+subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsdtprofesionaleducacionsContainer.AddObjectProperty("GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage", GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDTPROFESIONALEDUCACIONS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdtprofesionaleducacions_previouspage( )
   {
      if ( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage >= subgridsdtprofesionaleducacions_fnc_recordsperpage( ) )
      {
         GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage-subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdtprofesionaleducacions_lastpage( )
   {
      GRIDSDTPROFESIONALEDUCACIONS_nRecordCount = subgridsdtprofesionaleducacions_fnc_recordcount( ) ;
      if ( GRIDSDTPROFESIONALEDUCACIONS_nRecordCount > subgridsdtprofesionaleducacions_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDTPROFESIONALEDUCACIONS_nRecordCount) % (subgridsdtprofesionaleducacions_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEDUCACIONS_nRecordCount-subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = (long)(GRIDSDTPROFESIONALEDUCACIONS_nRecordCount-((int)((GRIDSDTPROFESIONALEDUCACIONS_nRecordCount) % (subgridsdtprofesionaleducacions_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdtprofesionaleducacions_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = (long)(subgridsdtprofesionaleducacions_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = 0 ;
      }
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdtprofesionaleducacions_refresh( subGridsdtprofesionalespecialidadsedes_Rows, subGridsdtprofesionaleducacions_Rows, subGridsdtprofesionalexperiencialaborals_Rows, subGridsdtprofesionalpremioss_Rows, subGridsdtprofesionalservicioss_Rows, AV15EspecialidadNombreId, AV36PaisId, AV6ProfesionalId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled), 5, 0), !bGXsfl_169_Refreshing);
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled), 5, 0), !bGXsfl_169_Refreshing);
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled), 5, 0), !bGXsfl_169_Refreshing);
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled(), 5, 0), !bGXsfl_169_Refreshing);
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educaciondesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educaciondesde_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionaleducacions__educacionhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionaleducacions__educacionhasta_Enabled), 5, 0), !bGXsfl_235_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled), 5, 0), !bGXsfl_292_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled), 5, 0), !bGXsfl_292_Refreshing);
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled), 5, 0), !bGXsfl_292_Refreshing);
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosnombre_Enabled), 5, 0), !bGXsfl_348_Refreshing);
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosfecha_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosfecha_Enabled), 5, 0), !bGXsfl_348_Refreshing);
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalpremioss__premiosdescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalpremioss__premiosdescripcion_Enabled), 5, 0), !bGXsfl_348_Refreshing);
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdtprofesionalservicioss__serviciosnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdtprofesionalservicioss__serviciosnombre_Enabled), 5, 0), !bGXsfl_386_Refreshing);
      gxvvespecialidadnombreid_html2Z2( ) ;
      fix_multi_value_controls( ) ;
   }

   public void strup2Z0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e282Z2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      gxvvubigeoprovincia_html2Z2( AV70UbigeoDepartamento) ;
      gxvvubigeodistrito_html2Z2( AV70UbigeoDepartamento, AV72UbigeoProvincia) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalespecialidadsedes"), AV59SDTProfesionalEspecialidadSedes);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionaleducacions"), AV58SDTProfesionalEducacions);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalexperiencialaborals"), AV60SDTProfesionalExperienciaLaborals);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalpremioss"), AV62SDTProfesionalPremioss);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdtprofesionalservicioss"), AV63SDTProfesionalServicioss);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vUPLOADEDFILES"), AV73UploadedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vFAILEDFILES"), AV21FailedFiles);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALESPECIALIDADSEDES"), AV59SDTProfesionalEspecialidadSedes);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALEDUCACIONS"), AV58SDTProfesionalEducacions);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALEXPERIENCIALABORALS"), AV60SDTProfesionalExperienciaLaborals);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALPREMIOSS"), AV62SDTProfesionalPremioss);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDTPROFESIONALSERVICIOSS"), AV63SDTProfesionalServicioss);
         /* Read saved values. */
         nRC_GXsfl_169 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_169"), ",", ".")) ;
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_235"), ",", ".")) ;
         nRC_GXsfl_292 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_292"), ",", ".")) ;
         nRC_GXsfl_348 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_348"), ",", ".")) ;
         nRC_GXsfl_386 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_386"), ",", ".")) ;
         AV25GridSDTProfesionalEspecialidadSedesCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALESPECIALIDADSEDESCURRENTPAGE"), ",", ".") ;
         AV26GridSDTProfesionalEspecialidadSedesPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALESPECIALIDADSEDESPAGECOUNT"), ",", ".") ;
         AV23GridSDTProfesionalEducacionsCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEDUCACIONSCURRENTPAGE"), ",", ".") ;
         AV24GridSDTProfesionalEducacionsPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEDUCACIONSPAGECOUNT"), ",", ".") ;
         AV27GridSDTProfesionalExperienciaLaboralsCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEXPERIENCIALABORALSCURRENTPAGE"), ",", ".") ;
         AV28GridSDTProfesionalExperienciaLaboralsPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALEXPERIENCIALABORALSPAGECOUNT"), ",", ".") ;
         AV29GridSDTProfesionalPremiossCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALPREMIOSSCURRENTPAGE"), ",", ".") ;
         AV30GridSDTProfesionalPremiossPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALPREMIOSSPAGECOUNT"), ",", ".") ;
         AV31GridSDTProfesionalServiciossCurrentPage = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALSERVICIOSSCURRENTPAGE"), ",", ".") ;
         AV32GridSDTProfesionalServiciossPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSDTPROFESIONALSERVICIOSSPAGECOUNT"), ",", ".") ;
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage"), ",", ".") ;
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF"), ",", ".")) ;
         GRIDSDTPROFESIONALEDUCACIONS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONS_nEOF"), ",", ".")) ;
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF"), ",", ".")) ;
         GRIDSDTPROFESIONALPREMIOSS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSS_nEOF"), ",", ".")) ;
         GRIDSDTPROFESIONALSERVICIOSS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSS_nEOF"), ",", ".")) ;
         subGridsdtprofesionalespecialidadsedes_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridsdtprofesionaleducacions_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridsdtprofesionalexperiencialaborals_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridsdtprofesionalpremioss_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridsdtprofesionalservicioss_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSS_Rows"), ",", ".")) ;
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
         Subirfotografia_Class = httpContext.cgiGet( "SUBIRFOTOGRAFIA_Class") ;
         Subirfotografia_Autoupload = GXutil.strtobool( httpContext.cgiGet( "SUBIRFOTOGRAFIA_Autoupload")) ;
         Subirfotografia_Hideadditionalbuttons = GXutil.strtobool( httpContext.cgiGet( "SUBIRFOTOGRAFIA_Hideadditionalbuttons")) ;
         Subirfotografia_Enableuploadedfilecanceling = GXutil.strtobool( httpContext.cgiGet( "SUBIRFOTOGRAFIA_Enableuploadedfilecanceling")) ;
         Subirfotografia_Maxnumberoffiles = (int)(localUtil.ctol( httpContext.cgiGet( "SUBIRFOTOGRAFIA_Maxnumberoffiles"), ",", ".")) ;
         Subirfotografia_Autodisableaddingfiles = GXutil.strtobool( httpContext.cgiGet( "SUBIRFOTOGRAFIA_Autodisableaddingfiles")) ;
         Subirfotografia_Acceptedfiletypes = httpContext.cgiGet( "SUBIRFOTOGRAFIA_Acceptedfiletypes") ;
         Subirfotografia_Visible = GXutil.strtobool( httpContext.cgiGet( "SUBIRFOTOGRAFIA_Visible")) ;
         Dvpanel_panelregespe_Width = httpContext.cgiGet( "DVPANEL_PANELREGESPE_Width") ;
         Dvpanel_panelregespe_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELREGESPE_Autowidth")) ;
         Dvpanel_panelregespe_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELREGESPE_Autoheight")) ;
         Dvpanel_panelregespe_Cls = httpContext.cgiGet( "DVPANEL_PANELREGESPE_Cls") ;
         Dvpanel_panelregespe_Title = httpContext.cgiGet( "DVPANEL_PANELREGESPE_Title") ;
         Dvpanel_panelregespe_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELREGESPE_Collapsible")) ;
         Dvpanel_panelregespe_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELREGESPE_Collapsed")) ;
         Dvpanel_panelregespe_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELREGESPE_Showcollapseicon")) ;
         Dvpanel_panelregespe_Iconposition = httpContext.cgiGet( "DVPANEL_PANELREGESPE_Iconposition") ;
         Dvpanel_panelregespe_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELREGESPE_Autoscroll")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Class = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Class") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showfirst")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showprevious")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Shownext")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Showlast")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridclass") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Previous = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Previous") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Next = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Next") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Caption = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Caption") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Emptygridcaption") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpagecaption") ;
         Dvpanel_panellistespe_Width = httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Width") ;
         Dvpanel_panellistespe_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Autowidth")) ;
         Dvpanel_panellistespe_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Autoheight")) ;
         Dvpanel_panellistespe_Cls = httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Cls") ;
         Dvpanel_panellistespe_Title = httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Title") ;
         Dvpanel_panellistespe_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Collapsible")) ;
         Dvpanel_panellistespe_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Collapsed")) ;
         Dvpanel_panellistespe_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Showcollapseicon")) ;
         Dvpanel_panellistespe_Iconposition = httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Iconposition") ;
         Dvpanel_panellistespe_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELLISTESPE_Autoscroll")) ;
         Dvpanel_paneleducacion_Width = httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Width") ;
         Dvpanel_paneleducacion_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Autowidth")) ;
         Dvpanel_paneleducacion_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Autoheight")) ;
         Dvpanel_paneleducacion_Cls = httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Cls") ;
         Dvpanel_paneleducacion_Title = httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Title") ;
         Dvpanel_paneleducacion_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Collapsible")) ;
         Dvpanel_paneleducacion_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Collapsed")) ;
         Dvpanel_paneleducacion_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Showcollapseicon")) ;
         Dvpanel_paneleducacion_Iconposition = httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Iconposition") ;
         Dvpanel_paneleducacion_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACION_Autoscroll")) ;
         Gridsdtprofesionaleducacionspaginationbar_Class = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Class") ;
         Gridsdtprofesionaleducacionspaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showfirst")) ;
         Gridsdtprofesionaleducacionspaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showprevious")) ;
         Gridsdtprofesionaleducacionspaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Shownext")) ;
         Gridsdtprofesionaleducacionspaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Showlast")) ;
         Gridsdtprofesionaleducacionspaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsdtprofesionaleducacionspaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridclass") ;
         Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsdtprofesionaleducacionspaginationbar_Previous = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Previous") ;
         Gridsdtprofesionaleducacionspaginationbar_Next = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Next") ;
         Gridsdtprofesionaleducacionspaginationbar_Caption = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Caption") ;
         Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Emptygridcaption") ;
         Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpagecaption") ;
         Dvpanel_paneleducacionlist_Width = httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Width") ;
         Dvpanel_paneleducacionlist_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Autowidth")) ;
         Dvpanel_paneleducacionlist_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Autoheight")) ;
         Dvpanel_paneleducacionlist_Cls = httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Cls") ;
         Dvpanel_paneleducacionlist_Title = httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Title") ;
         Dvpanel_paneleducacionlist_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Collapsible")) ;
         Dvpanel_paneleducacionlist_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Collapsed")) ;
         Dvpanel_paneleducacionlist_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Showcollapseicon")) ;
         Dvpanel_paneleducacionlist_Iconposition = httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Iconposition") ;
         Dvpanel_paneleducacionlist_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEDUCACIONLIST_Autoscroll")) ;
         Dvpanel_panelexperiencialaboral_Width = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Width") ;
         Dvpanel_panelexperiencialaboral_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Autowidth")) ;
         Dvpanel_panelexperiencialaboral_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Autoheight")) ;
         Dvpanel_panelexperiencialaboral_Cls = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Cls") ;
         Dvpanel_panelexperiencialaboral_Title = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Title") ;
         Dvpanel_panelexperiencialaboral_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Collapsible")) ;
         Dvpanel_panelexperiencialaboral_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Collapsed")) ;
         Dvpanel_panelexperiencialaboral_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Showcollapseicon")) ;
         Dvpanel_panelexperiencialaboral_Iconposition = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Iconposition") ;
         Dvpanel_panelexperiencialaboral_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORAL_Autoscroll")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Class = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Class") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showfirst")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showprevious")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Shownext")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Showlast")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridclass") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Previous = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Previous") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Next = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Next") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Caption = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Caption") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Emptygridcaption") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpagecaption") ;
         Dvpanel_panelexperiencialaborallist_Width = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Width") ;
         Dvpanel_panelexperiencialaborallist_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Autowidth")) ;
         Dvpanel_panelexperiencialaborallist_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoheight")) ;
         Dvpanel_panelexperiencialaborallist_Cls = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Cls") ;
         Dvpanel_panelexperiencialaborallist_Title = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Title") ;
         Dvpanel_panelexperiencialaborallist_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsible")) ;
         Dvpanel_panelexperiencialaborallist_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Collapsed")) ;
         Dvpanel_panelexperiencialaborallist_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Showcollapseicon")) ;
         Dvpanel_panelexperiencialaborallist_Iconposition = httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Iconposition") ;
         Dvpanel_panelexperiencialaborallist_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELEXPERIENCIALABORALLIST_Autoscroll")) ;
         Dvpanel_panelpremioslogros_Width = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Width") ;
         Dvpanel_panelpremioslogros_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Autowidth")) ;
         Dvpanel_panelpremioslogros_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Autoheight")) ;
         Dvpanel_panelpremioslogros_Cls = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Cls") ;
         Dvpanel_panelpremioslogros_Title = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Title") ;
         Dvpanel_panelpremioslogros_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Collapsible")) ;
         Dvpanel_panelpremioslogros_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Collapsed")) ;
         Dvpanel_panelpremioslogros_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Showcollapseicon")) ;
         Dvpanel_panelpremioslogros_Iconposition = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Iconposition") ;
         Dvpanel_panelpremioslogros_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROS_Autoscroll")) ;
         Gridsdtprofesionalpremiosspaginationbar_Class = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Class") ;
         Gridsdtprofesionalpremiosspaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showfirst")) ;
         Gridsdtprofesionalpremiosspaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showprevious")) ;
         Gridsdtprofesionalpremiosspaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Shownext")) ;
         Gridsdtprofesionalpremiosspaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Showlast")) ;
         Gridsdtprofesionalpremiosspaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsdtprofesionalpremiosspaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridclass") ;
         Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsdtprofesionalpremiosspaginationbar_Previous = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Previous") ;
         Gridsdtprofesionalpremiosspaginationbar_Next = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Next") ;
         Gridsdtprofesionalpremiosspaginationbar_Caption = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Caption") ;
         Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Emptygridcaption") ;
         Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpagecaption") ;
         Dvpanel_panelpremioslogroslist_Width = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Width") ;
         Dvpanel_panelpremioslogroslist_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Autowidth")) ;
         Dvpanel_panelpremioslogroslist_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Autoheight")) ;
         Dvpanel_panelpremioslogroslist_Cls = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Cls") ;
         Dvpanel_panelpremioslogroslist_Title = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Title") ;
         Dvpanel_panelpremioslogroslist_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsible")) ;
         Dvpanel_panelpremioslogroslist_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Collapsed")) ;
         Dvpanel_panelpremioslogroslist_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Showcollapseicon")) ;
         Dvpanel_panelpremioslogroslist_Iconposition = httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Iconposition") ;
         Dvpanel_panelpremioslogroslist_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPREMIOSLOGROSLIST_Autoscroll")) ;
         Dvpanel_panelservicios_Width = httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Width") ;
         Dvpanel_panelservicios_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Autowidth")) ;
         Dvpanel_panelservicios_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Autoheight")) ;
         Dvpanel_panelservicios_Cls = httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Cls") ;
         Dvpanel_panelservicios_Title = httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Title") ;
         Dvpanel_panelservicios_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Collapsible")) ;
         Dvpanel_panelservicios_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Collapsed")) ;
         Dvpanel_panelservicios_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Showcollapseicon")) ;
         Dvpanel_panelservicios_Iconposition = httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Iconposition") ;
         Dvpanel_panelservicios_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOS_Autoscroll")) ;
         Gridsdtprofesionalserviciosspaginationbar_Class = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Class") ;
         Gridsdtprofesionalserviciosspaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showfirst")) ;
         Gridsdtprofesionalserviciosspaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showprevious")) ;
         Gridsdtprofesionalserviciosspaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Shownext")) ;
         Gridsdtprofesionalserviciosspaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Showlast")) ;
         Gridsdtprofesionalserviciosspaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagestoshow"), ",", ".")) ;
         Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsdtprofesionalserviciosspaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridclass") ;
         Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsdtprofesionalserviciosspaginationbar_Previous = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Previous") ;
         Gridsdtprofesionalserviciosspaginationbar_Next = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Next") ;
         Gridsdtprofesionalserviciosspaginationbar_Caption = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Caption") ;
         Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Emptygridcaption") ;
         Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpagecaption") ;
         Dvpanel_panelservicioslist_Width = httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Width") ;
         Dvpanel_panelservicioslist_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Autowidth")) ;
         Dvpanel_panelservicioslist_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Autoheight")) ;
         Dvpanel_panelservicioslist_Cls = httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Cls") ;
         Dvpanel_panelservicioslist_Title = httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Title") ;
         Dvpanel_panelservicioslist_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Collapsible")) ;
         Dvpanel_panelservicioslist_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Collapsed")) ;
         Dvpanel_panelservicioslist_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Showcollapseicon")) ;
         Dvpanel_panelservicioslist_Iconposition = httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Iconposition") ;
         Dvpanel_panelservicioslist_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSERVICIOSLIST_Autoscroll")) ;
         Gxuitabspanel_tabinformacionpaciente_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "GXUITABSPANEL_TABINFORMACIONPACIENTE_Pagecount"), ",", ".")) ;
         Gxuitabspanel_tabinformacionpaciente_Class = httpContext.cgiGet( "GXUITABSPANEL_TABINFORMACIONPACIENTE_Class") ;
         Gxuitabspanel_tabinformacionpaciente_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "GXUITABSPANEL_TABINFORMACIONPACIENTE_Historymanagement")) ;
         Gridsdtprofesionalservicioss_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionalpremioss_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionaleducacions_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER_Gridinternalname") ;
         Gridsdtprofesionalserviciosspaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Selectedpage") ;
         Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionalpremiosspaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Selectedpage") ;
         Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Selectedpage") ;
         Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionaleducacionspaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Selectedpage") ;
         Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Selectedpage") ;
         Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR_Rowsperpageselectedvalue"), ",", ".")) ;
         nRC_GXsfl_169 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_169"), ",", ".")) ;
         nGXsfl_169_fel_idx = 0 ;
         while ( nGXsfl_169_fel_idx < nRC_GXsfl_169 )
         {
            nGXsfl_169_fel_idx = ((subGridsdtprofesionalespecialidadsedes_Islastpage==1)&&(nGXsfl_169_fel_idx+1>subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ? 1 : nGXsfl_169_fel_idx+1) ;
            sGXsfl_169_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_169_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1692( ) ;
            AV77GXV1 = (int)(nGXsfl_169_fel_idx+GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage) ;
            if ( ( AV59SDTProfesionalEspecialidadSedes.size() >= AV77GXV1 ) && ( AV77GXV1 > 0 ) )
            {
               AV59SDTProfesionalEspecialidadSedes.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)) );
            }
         }
         if ( nGXsfl_169_fel_idx == 0 )
         {
            nGXsfl_169_idx = 1 ;
            sGXsfl_169_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_169_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1692( ) ;
         }
         nGXsfl_169_fel_idx = 1 ;
         nRC_GXsfl_235 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_235"), ",", ".")) ;
         nGXsfl_235_fel_idx = 0 ;
         while ( nGXsfl_235_fel_idx < nRC_GXsfl_235 )
         {
            nGXsfl_235_fel_idx = ((subGridsdtprofesionaleducacions_Islastpage==1)&&(nGXsfl_235_fel_idx+1>subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ? 1 : nGXsfl_235_fel_idx+1) ;
            sGXsfl_235_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2358( ) ;
            AV82GXV6 = (int)(nGXsfl_235_fel_idx+GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage) ;
            if ( ( AV58SDTProfesionalEducacions.size() >= AV82GXV6 ) && ( AV82GXV6 > 0 ) )
            {
               AV58SDTProfesionalEducacions.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)) );
            }
         }
         if ( nGXsfl_235_fel_idx == 0 )
         {
            nGXsfl_235_idx = 1 ;
            sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2358( ) ;
         }
         nGXsfl_235_fel_idx = 1 ;
         nRC_GXsfl_292 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_292"), ",", ".")) ;
         nGXsfl_292_fel_idx = 0 ;
         while ( nGXsfl_292_fel_idx < nRC_GXsfl_292 )
         {
            nGXsfl_292_fel_idx = ((subGridsdtprofesionalexperiencialaborals_Islastpage==1)&&(nGXsfl_292_fel_idx+1>subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ? 1 : nGXsfl_292_fel_idx+1) ;
            sGXsfl_292_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_292_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_2927( ) ;
            AV87GXV11 = (int)(nGXsfl_292_fel_idx+GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage) ;
            if ( ( AV60SDTProfesionalExperienciaLaborals.size() >= AV87GXV11 ) && ( AV87GXV11 > 0 ) )
            {
               AV60SDTProfesionalExperienciaLaborals.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)) );
            }
         }
         if ( nGXsfl_292_fel_idx == 0 )
         {
            nGXsfl_292_idx = 1 ;
            sGXsfl_292_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_292_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_2927( ) ;
         }
         nGXsfl_292_fel_idx = 1 ;
         nRC_GXsfl_348 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_348"), ",", ".")) ;
         nGXsfl_348_fel_idx = 0 ;
         while ( nGXsfl_348_fel_idx < nRC_GXsfl_348 )
         {
            nGXsfl_348_fel_idx = ((subGridsdtprofesionalpremioss_Islastpage==1)&&(nGXsfl_348_fel_idx+1>subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ? 1 : nGXsfl_348_fel_idx+1) ;
            sGXsfl_348_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_348_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_3486( ) ;
            AV91GXV15 = (int)(nGXsfl_348_fel_idx+GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage) ;
            if ( ( AV62SDTProfesionalPremioss.size() >= AV91GXV15 ) && ( AV91GXV15 > 0 ) )
            {
               AV62SDTProfesionalPremioss.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)) );
            }
         }
         if ( nGXsfl_348_fel_idx == 0 )
         {
            nGXsfl_348_idx = 1 ;
            sGXsfl_348_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_348_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_3486( ) ;
         }
         nGXsfl_348_fel_idx = 1 ;
         nRC_GXsfl_386 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_386"), ",", ".")) ;
         nGXsfl_386_fel_idx = 0 ;
         while ( nGXsfl_386_fel_idx < nRC_GXsfl_386 )
         {
            nGXsfl_386_fel_idx = ((subGridsdtprofesionalservicioss_Islastpage==1)&&(nGXsfl_386_fel_idx+1>subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ? 1 : nGXsfl_386_fel_idx+1) ;
            sGXsfl_386_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_386_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_3865( ) ;
            AV95GXV19 = (int)(nGXsfl_386_fel_idx+GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage) ;
            if ( ( AV63SDTProfesionalServicioss.size() >= AV95GXV19 ) && ( AV95GXV19 > 0 ) )
            {
               AV63SDTProfesionalServicioss.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV63SDTProfesionalServicioss.elementAt(-1+AV95GXV19)) );
            }
         }
         if ( nGXsfl_386_fel_idx == 0 )
         {
            nGXsfl_386_idx = 1 ;
            sGXsfl_386_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_386_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_3865( ) ;
         }
         nGXsfl_386_fel_idx = 1 ;
         /* Read variables values. */
         cmbavProfesionaltipodocumento.setName( cmbavProfesionaltipodocumento.getInternalname() );
         cmbavProfesionaltipodocumento.setValue( httpContext.cgiGet( cmbavProfesionaltipodocumento.getInternalname()) );
         AV56ProfesionalTipoDocumento = httpContext.cgiGet( cmbavProfesionaltipodocumento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56ProfesionalTipoDocumento", AV56ProfesionalTipoDocumento);
         AV51ProfesionalNroDocumento = httpContext.cgiGet( edtavProfesionalnrodocumento_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalNroDocumento", AV51ProfesionalNroDocumento);
         AV50ProfesionalNombres = httpContext.cgiGet( edtavProfesionalnombres_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV50ProfesionalNombres", AV50ProfesionalNombres);
         AV42ProfesionalApellidoMaterno = httpContext.cgiGet( edtavProfesionalapellidomaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV42ProfesionalApellidoMaterno", AV42ProfesionalApellidoMaterno);
         AV43ProfesionalApellidoPaterno = httpContext.cgiGet( edtavProfesionalapellidopaterno_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV43ProfesionalApellidoPaterno", AV43ProfesionalApellidoPaterno);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavProfesionalfechanacimiento_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vPROFESIONALFECHANACIMIENTO");
            GX_FocusControl = edtavProfesionalfechanacimiento_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV48ProfesionalFechaNacimiento = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48ProfesionalFechaNacimiento", localUtil.format(AV48ProfesionalFechaNacimiento, "99/99/9999"));
         }
         else
         {
            AV48ProfesionalFechaNacimiento = localUtil.ctod( httpContext.cgiGet( edtavProfesionalfechanacimiento_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV48ProfesionalFechaNacimiento", localUtil.format(AV48ProfesionalFechaNacimiento, "99/99/9999"));
         }
         cmbavProfesionalsexo.setName( cmbavProfesionalsexo.getInternalname() );
         cmbavProfesionalsexo.setValue( httpContext.cgiGet( cmbavProfesionalsexo.getInternalname()) );
         AV53ProfesionalSexo = httpContext.cgiGet( cmbavProfesionalsexo.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53ProfesionalSexo", AV53ProfesionalSexo);
         AV44ProfesionalCOP = httpContext.cgiGet( edtavProfesionalcop_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV44ProfesionalCOP", AV44ProfesionalCOP);
         AV54ProfesionalTelefono = httpContext.cgiGet( edtavProfesionaltelefono_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV54ProfesionalTelefono", AV54ProfesionalTelefono);
         AV46ProfesionalDescripcion = httpContext.cgiGet( edtavProfesionaldescripcion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV46ProfesionalDescripcion", AV46ProfesionalDescripcion);
         cmbavProfesionaltiempocita.setName( cmbavProfesionaltiempocita.getInternalname() );
         cmbavProfesionaltiempocita.setValue( httpContext.cgiGet( cmbavProfesionaltiempocita.getInternalname()) );
         AV55ProfesionalTiempoCita = (byte)(GXutil.lval( httpContext.cgiGet( cmbavProfesionaltiempocita.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55ProfesionalTiempoCita), 2, 0));
         dynavPaisid.setName( dynavPaisid.getInternalname() );
         dynavPaisid.setValue( httpContext.cgiGet( dynavPaisid.getInternalname()) );
         AV36PaisId = (short)(GXutil.lval( httpContext.cgiGet( dynavPaisid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36PaisId), 4, 0));
         cmbavUbigeodepartamento.setName( cmbavUbigeodepartamento.getInternalname() );
         cmbavUbigeodepartamento.setValue( httpContext.cgiGet( cmbavUbigeodepartamento.getInternalname()) );
         AV70UbigeoDepartamento = httpContext.cgiGet( cmbavUbigeodepartamento.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70UbigeoDepartamento", AV70UbigeoDepartamento);
         dynavUbigeoprovincia.setName( dynavUbigeoprovincia.getInternalname() );
         dynavUbigeoprovincia.setValue( httpContext.cgiGet( dynavUbigeoprovincia.getInternalname()) );
         AV72UbigeoProvincia = httpContext.cgiGet( dynavUbigeoprovincia.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV72UbigeoProvincia", AV72UbigeoProvincia);
         dynavUbigeodistrito.setName( dynavUbigeodistrito.getInternalname() );
         dynavUbigeodistrito.setValue( httpContext.cgiGet( dynavUbigeodistrito.getInternalname()) );
         AV71UbigeoDistrito = httpContext.cgiGet( dynavUbigeodistrito.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV71UbigeoDistrito", AV71UbigeoDistrito);
         AV47ProfesionalDireccion = httpContext.cgiGet( edtavProfesionaldireccion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV47ProfesionalDireccion", AV47ProfesionalDireccion);
         AV49ProfesionalFoto = httpContext.cgiGet( imgavProfesionalfoto_Internalname) ;
         AV45ProfesionalCorreo = httpContext.cgiGet( edtavProfesionalcorreo_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV45ProfesionalCorreo", AV45ProfesionalCorreo);
         AV52ProfesionalPassword = httpContext.cgiGet( edtavProfesionalpassword_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV52ProfesionalPassword", AV52ProfesionalPassword);
         dynavEspecialidadnombreid.setName( dynavEspecialidadnombreid.getInternalname() );
         dynavEspecialidadnombreid.setValue( httpContext.cgiGet( dynavEspecialidadnombreid.getInternalname()) );
         AV15EspecialidadNombreId = (short)(GXutil.lval( httpContext.cgiGet( dynavEspecialidadnombreid.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15EspecialidadNombreId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EspecialidadNombreId), 4, 0));
         cmbavEspecialidadtipoconsulta.setName( cmbavEspecialidadtipoconsulta.getInternalname() );
         cmbavEspecialidadtipoconsulta.setValue( httpContext.cgiGet( cmbavEspecialidadtipoconsulta.getInternalname()) );
         AV16EspecialidadTipoConsulta = httpContext.cgiGet( cmbavEspecialidadtipoconsulta.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16EspecialidadTipoConsulta", AV16EspecialidadTipoConsulta);
         AV13EducacionProfesionalNombreInstitucion = httpContext.cgiGet( edtavEducacionprofesionalnombreinstitucion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13EducacionProfesionalNombreInstitucion", AV13EducacionProfesionalNombreInstitucion);
         AV14EducacionProfesionalPais = httpContext.cgiGet( edtavEducacionprofesionalpais_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14EducacionProfesionalPais", AV14EducacionProfesionalPais);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavEducacionprofesionaldesde_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vEDUCACIONPROFESIONALDESDE");
            GX_FocusControl = edtavEducacionprofesionaldesde_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV11EducacionProfesionalDesde = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11EducacionProfesionalDesde", localUtil.format(AV11EducacionProfesionalDesde, "99/99/99"));
         }
         else
         {
            AV11EducacionProfesionalDesde = localUtil.ctod( httpContext.cgiGet( edtavEducacionprofesionaldesde_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11EducacionProfesionalDesde", localUtil.format(AV11EducacionProfesionalDesde, "99/99/99"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavEducacionprofesionalhasta_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vEDUCACIONPROFESIONALHASTA");
            GX_FocusControl = edtavEducacionprofesionalhasta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12EducacionProfesionalHasta = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12EducacionProfesionalHasta", localUtil.format(AV12EducacionProfesionalHasta, "99/99/99"));
         }
         else
         {
            AV12EducacionProfesionalHasta = localUtil.ctod( httpContext.cgiGet( edtavEducacionprofesionalhasta_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12EducacionProfesionalHasta", localUtil.format(AV12EducacionProfesionalHasta, "99/99/99"));
         }
         AV19ExperienciaLaboralEmpresaNombre = httpContext.cgiGet( edtavExperiencialaboralempresanombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19ExperienciaLaboralEmpresaNombre", AV19ExperienciaLaboralEmpresaNombre);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavExperiencialaboraldesde_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vEXPERIENCIALABORALDESDE");
            GX_FocusControl = edtavExperiencialaboraldesde_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV18ExperienciaLaboralDesde = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18ExperienciaLaboralDesde", localUtil.format(AV18ExperienciaLaboralDesde, "99/99/9999"));
         }
         else
         {
            AV18ExperienciaLaboralDesde = localUtil.ctod( httpContext.cgiGet( edtavExperiencialaboraldesde_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18ExperienciaLaboralDesde", localUtil.format(AV18ExperienciaLaboralDesde, "99/99/9999"));
         }
         if ( localUtil.vcdate( httpContext.cgiGet( edtavExperiencialaboralhasta_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vEXPERIENCIALABORALHASTA");
            GX_FocusControl = edtavExperiencialaboralhasta_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV20ExperienciaLaboralHasta = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ExperienciaLaboralHasta", localUtil.format(AV20ExperienciaLaboralHasta, "99/99/9999"));
         }
         else
         {
            AV20ExperienciaLaboralHasta = localUtil.ctod( httpContext.cgiGet( edtavExperiencialaboralhasta_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ExperienciaLaboralHasta", localUtil.format(AV20ExperienciaLaboralHasta, "99/99/9999"));
         }
         AV40PremiosNombre = httpContext.cgiGet( edtavPremiosnombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV40PremiosNombre", AV40PremiosNombre);
         AV38PremiosDescripcion = httpContext.cgiGet( edtavPremiosdescripcion_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38PremiosDescripcion", AV38PremiosDescripcion);
         if ( localUtil.vcdate( httpContext.cgiGet( edtavPremiosfecha_Internalname), (byte)(3)) == 0 )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "vPREMIOSFECHA");
            GX_FocusControl = edtavPremiosfecha_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV39PremiosFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39PremiosFecha", localUtil.format(AV39PremiosFecha, "99/99/99"));
         }
         else
         {
            AV39PremiosFecha = localUtil.ctod( httpContext.cgiGet( edtavPremiosfecha_Internalname), 3) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39PremiosFecha", localUtil.format(AV39PremiosFecha, "99/99/99"));
         }
         AV68ServiciosNombre = httpContext.cgiGet( edtavServiciosnombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV68ServiciosNombre", AV68ServiciosNombre);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e282Z2 ();
      if (returnInSub) return;
   }

   public void e282Z2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV74WWPContext;
      new com.projectthani.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV74WWPContext = GXv_SdtWWPContext1[0] ;
      /* Using cursor H002Z7 */
      pr_default.execute(5, new Object[] {Short.valueOf(AV74WWPContext.getgxTv_SdtWWPContext_Userid())});
      while ( (pr_default.getStatus(5) != 101) )
      {
         A6SecUserId = H002Z7_A6SecUserId[0] ;
         A31ProfesionalId = H002Z7_A31ProfesionalId[0] ;
         AV6ProfesionalId = A31ProfesionalId ;
         httpContext.ajax_rsp_assign_attri("", false, "AV6ProfesionalId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6ProfesionalId), 8, 0));
         com.projectthani.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPROFESIONALID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV6ProfesionalId), "ZZZZZZZ9")));
         pr_default.readNext(5);
      }
      pr_default.close(5);
      /* Execute user subroutine: 'CARGARDATAPROFESIONAL' */
      S112 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ENABLEDCAMPOSTART' */
      S122 ();
      if (returnInSub) return;
      bttBtnbtnactualizarregistro_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnactualizarregistro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnactualizarregistro_Visible), 5, 0), true);
      bttBtnbtnguardardatosactualizados_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnguardardatosactualizados_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnguardardatosactualizados_Visible), 5, 0), true);
      GXv_objcol_SdtSDTProfesionalEspecialidadSede2[0] = AV59SDTProfesionalEspecialidadSedes ;
      GXv_objcol_SdtSDTProfesionalInformacionGeneral3[0] = AV61SDTProfesionalInformacionGeneral ;
      GXv_objcol_SdtSDTProfesionalEducacion4[0] = AV58SDTProfesionalEducacions ;
      GXv_objcol_SdtSDTProfesionalExperienciaLaboral5[0] = AV60SDTProfesionalExperienciaLaborals ;
      GXv_objcol_SdtSDTProfesionalPremios6[0] = AV62SDTProfesionalPremioss ;
      GXv_objcol_SdtSDTProfesionalServicios7[0] = AV63SDTProfesionalServicioss ;
      new com.projectthani.prcprofesionalinformaciondetallada(remoteHandle, context).execute( AV6ProfesionalId, GXv_objcol_SdtSDTProfesionalEspecialidadSede2, GXv_objcol_SdtSDTProfesionalInformacionGeneral3, GXv_objcol_SdtSDTProfesionalEducacion4, GXv_objcol_SdtSDTProfesionalExperienciaLaboral5, GXv_objcol_SdtSDTProfesionalPremios6, GXv_objcol_SdtSDTProfesionalServicios7) ;
      AV59SDTProfesionalEspecialidadSedes = GXv_objcol_SdtSDTProfesionalEspecialidadSede2[0] ;
      AV61SDTProfesionalInformacionGeneral = GXv_objcol_SdtSDTProfesionalInformacionGeneral3[0] ;
      AV58SDTProfesionalEducacions = GXv_objcol_SdtSDTProfesionalEducacion4[0] ;
      AV60SDTProfesionalExperienciaLaborals = GXv_objcol_SdtSDTProfesionalExperienciaLaboral5[0] ;
      AV62SDTProfesionalPremioss = GXv_objcol_SdtSDTProfesionalPremios6[0] ;
      AV63SDTProfesionalServicioss = GXv_objcol_SdtSDTProfesionalServicios7[0] ;
      gx_BV169 = true ;
      gx_BV235 = true ;
      gx_BV292 = true ;
      gx_BV348 = true ;
      gx_BV386 = true ;
      /* Using cursor H002Z8 */
      pr_default.execute(6);
      while ( (pr_default.getStatus(6) != 101) )
      {
         A186UbigeoDepartamento = H002Z8_A186UbigeoDepartamento[0] ;
         A295UbigeoDepartamentoCode = H002Z8_A295UbigeoDepartamentoCode[0] ;
         A44UbigeoCode = H002Z8_A44UbigeoCode[0] ;
         cmbavUbigeodepartamento.addItem(A295UbigeoDepartamentoCode, A186UbigeoDepartamento, (short)(0));
         pr_default.readNext(6);
      }
      pr_default.close(6);
      Gridsdtprofesionalservicioss_empowerer_Gridinternalname = subGridsdtprofesionalservicioss_Internalname ;
      ucGridsdtprofesionalservicioss_empowerer.sendProperty(context, "", false, Gridsdtprofesionalservicioss_empowerer_Internalname, "GridInternalName", Gridsdtprofesionalservicioss_empowerer_Gridinternalname);
      subGridsdtprofesionalservicioss_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdtprofesionalpremioss_empowerer_Gridinternalname = subGridsdtprofesionalpremioss_Internalname ;
      ucGridsdtprofesionalpremioss_empowerer.sendProperty(context, "", false, Gridsdtprofesionalpremioss_empowerer_Internalname, "GridInternalName", Gridsdtprofesionalpremioss_empowerer_Gridinternalname);
      subGridsdtprofesionalpremioss_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname = subGridsdtprofesionalexperiencialaborals_Internalname ;
      ucGridsdtprofesionalexperiencialaborals_empowerer.sendProperty(context, "", false, Gridsdtprofesionalexperiencialaborals_empowerer_Internalname, "GridInternalName", Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname);
      subGridsdtprofesionalexperiencialaborals_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdtprofesionaleducacions_empowerer_Gridinternalname = subGridsdtprofesionaleducacions_Internalname ;
      ucGridsdtprofesionaleducacions_empowerer.sendProperty(context, "", false, Gridsdtprofesionaleducacions_empowerer_Internalname, "GridInternalName", Gridsdtprofesionaleducacions_empowerer_Gridinternalname);
      subGridsdtprofesionaleducacions_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname = subGridsdtprofesionalespecialidadsedes_Internalname ;
      ucGridsdtprofesionalespecialidadsedes_empowerer.sendProperty(context, "", false, Gridsdtprofesionalespecialidadsedes_empowerer_Internalname, "GridInternalName", Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname);
      subGridsdtprofesionalespecialidadsedes_Rows = 10 ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue = subGridsdtprofesionalservicioss_Rows ;
      ucGridsdtprofesionalserviciosspaginationbar.sendProperty(context, "", false, Gridsdtprofesionalserviciosspaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue), 9, 0));
      Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue = subGridsdtprofesionalpremioss_Rows ;
      ucGridsdtprofesionalpremiosspaginationbar.sendProperty(context, "", false, Gridsdtprofesionalpremiosspaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue), 9, 0));
      Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue = subGridsdtprofesionalexperiencialaborals_Rows ;
      ucGridsdtprofesionalexperiencialaboralspaginationbar.sendProperty(context, "", false, Gridsdtprofesionalexperiencialaboralspaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue), 9, 0));
      Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue = subGridsdtprofesionaleducacions_Rows ;
      ucGridsdtprofesionaleducacionspaginationbar.sendProperty(context, "", false, Gridsdtprofesionaleducacionspaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue), 9, 0));
      Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue = subGridsdtprofesionalespecialidadsedes_Rows ;
      ucGridsdtprofesionalespecialidadsedespaginationbar.sendProperty(context, "", false, Gridsdtprofesionalespecialidadsedespaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e292Z2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      AV31GridSDTProfesionalServiciossCurrentPage = subgridsdtprofesionalservicioss_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV31GridSDTProfesionalServiciossCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31GridSDTProfesionalServiciossCurrentPage), 10, 0));
      AV32GridSDTProfesionalServiciossPageCount = subgridsdtprofesionalservicioss_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV32GridSDTProfesionalServiciossPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV32GridSDTProfesionalServiciossPageCount), 10, 0));
      AV29GridSDTProfesionalPremiossCurrentPage = subgridsdtprofesionalpremioss_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29GridSDTProfesionalPremiossCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29GridSDTProfesionalPremiossCurrentPage), 10, 0));
      AV30GridSDTProfesionalPremiossPageCount = subgridsdtprofesionalpremioss_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30GridSDTProfesionalPremiossPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30GridSDTProfesionalPremiossPageCount), 10, 0));
      AV27GridSDTProfesionalExperienciaLaboralsCurrentPage = subgridsdtprofesionalexperiencialaborals_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27GridSDTProfesionalExperienciaLaboralsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GridSDTProfesionalExperienciaLaboralsCurrentPage), 10, 0));
      AV28GridSDTProfesionalExperienciaLaboralsPageCount = subgridsdtprofesionalexperiencialaborals_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV28GridSDTProfesionalExperienciaLaboralsPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV28GridSDTProfesionalExperienciaLaboralsPageCount), 10, 0));
      AV23GridSDTProfesionalEducacionsCurrentPage = subgridsdtprofesionaleducacions_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23GridSDTProfesionalEducacionsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV23GridSDTProfesionalEducacionsCurrentPage), 10, 0));
      AV24GridSDTProfesionalEducacionsPageCount = subgridsdtprofesionaleducacions_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24GridSDTProfesionalEducacionsPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV24GridSDTProfesionalEducacionsPageCount), 10, 0));
      AV25GridSDTProfesionalEspecialidadSedesCurrentPage = subgridsdtprofesionalespecialidadsedes_fnc_currentpage( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25GridSDTProfesionalEspecialidadSedesCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV25GridSDTProfesionalEspecialidadSedesCurrentPage), 10, 0));
      AV26GridSDTProfesionalEspecialidadSedesPageCount = subgridsdtprofesionalespecialidadsedes_fnc_pagecount( ) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26GridSDTProfesionalEspecialidadSedesPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV26GridSDTProfesionalEspecialidadSedesPageCount), 10, 0));
      /*  Sending Event outputs  */
   }

   private void e302Z2( )
   {
      /* Gridsdtprofesionalespecialidadsedes_Load Routine */
      returnInSub = false ;
      AV77GXV1 = 1 ;
      while ( AV77GXV1 <= AV59SDTProfesionalEspecialidadSedes.size() )
      {
         AV59SDTProfesionalEspecialidadSedes.currentItem( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(169) ;
         }
         if ( ( subGridsdtprofesionalespecialidadsedes_Islastpage == 1 ) || ( subGridsdtprofesionalespecialidadsedes_Rows == 0 ) || ( ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord >= GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord < GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage + subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1692( ) ;
            GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord + 1 >= subgridsdtprofesionalespecialidadsedes_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord = (long)(GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_169_Refreshing )
         {
            httpContext.doAjaxLoad(169, GridsdtprofesionalespecialidadsedesRow);
         }
         AV77GXV1 = (int)(AV77GXV1+1) ;
      }
   }

   public void e202Z2( )
   {
      /* Gridsdtprofesionalserviciosspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalserviciosspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalservicioss_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalserviciosspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV35PageToGo = subgridsdtprofesionalservicioss_fnc_currentpage( ) ;
         AV35PageToGo = (int)(AV35PageToGo+1) ;
         subgridsdtprofesionalservicioss_gotopage( AV35PageToGo) ;
      }
      else
      {
         AV35PageToGo = (int)(GXutil.lval( Gridsdtprofesionalserviciosspaginationbar_Selectedpage)) ;
         subgridsdtprofesionalservicioss_gotopage( AV35PageToGo) ;
      }
   }

   public void e212Z2( )
   {
      /* Gridsdtprofesionalserviciosspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalservicioss_Rows = Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalservicioss_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e182Z2( )
   {
      /* Gridsdtprofesionalpremiosspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalpremiosspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalpremioss_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalpremiosspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV35PageToGo = subgridsdtprofesionalpremioss_fnc_currentpage( ) ;
         AV35PageToGo = (int)(AV35PageToGo+1) ;
         subgridsdtprofesionalpremioss_gotopage( AV35PageToGo) ;
      }
      else
      {
         AV35PageToGo = (int)(GXutil.lval( Gridsdtprofesionalpremiosspaginationbar_Selectedpage)) ;
         subgridsdtprofesionalpremioss_gotopage( AV35PageToGo) ;
      }
   }

   public void e192Z2( )
   {
      /* Gridsdtprofesionalpremiosspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalpremioss_Rows = Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalpremioss_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e162Z2( )
   {
      /* Gridsdtprofesionalexperiencialaboralspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalexperiencialaborals_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV35PageToGo = subgridsdtprofesionalexperiencialaborals_fnc_currentpage( ) ;
         AV35PageToGo = (int)(AV35PageToGo+1) ;
         subgridsdtprofesionalexperiencialaborals_gotopage( AV35PageToGo) ;
      }
      else
      {
         AV35PageToGo = (int)(GXutil.lval( Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage)) ;
         subgridsdtprofesionalexperiencialaborals_gotopage( AV35PageToGo) ;
      }
   }

   public void e172Z2( )
   {
      /* Gridsdtprofesionalexperiencialaboralspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalexperiencialaborals_Rows = Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalexperiencialaborals_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e142Z2( )
   {
      /* Gridsdtprofesionaleducacionspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionaleducacionspaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionaleducacions_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionaleducacionspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV35PageToGo = subgridsdtprofesionaleducacions_fnc_currentpage( ) ;
         AV35PageToGo = (int)(AV35PageToGo+1) ;
         subgridsdtprofesionaleducacions_gotopage( AV35PageToGo) ;
      }
      else
      {
         AV35PageToGo = (int)(GXutil.lval( Gridsdtprofesionaleducacionspaginationbar_Selectedpage)) ;
         subgridsdtprofesionaleducacions_gotopage( AV35PageToGo) ;
      }
   }

   public void e152Z2( )
   {
      /* Gridsdtprofesionaleducacionspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionaleducacions_Rows = Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionaleducacions_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e122Z2( )
   {
      /* Gridsdtprofesionalespecialidadsedespaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage, "Previous") == 0 )
      {
         subgridsdtprofesionalespecialidadsedes_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage, "Next") == 0 )
      {
         AV35PageToGo = subgridsdtprofesionalespecialidadsedes_fnc_currentpage( ) ;
         AV35PageToGo = (int)(AV35PageToGo+1) ;
         subgridsdtprofesionalespecialidadsedes_gotopage( AV35PageToGo) ;
      }
      else
      {
         AV35PageToGo = (int)(GXutil.lval( Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage)) ;
         subgridsdtprofesionalespecialidadsedes_gotopage( AV35PageToGo) ;
      }
   }

   public void e132Z2( )
   {
      /* Gridsdtprofesionalespecialidadsedespaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsdtprofesionalespecialidadsedes_Rows = Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue ;
      com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALESPECIALIDADSEDES_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Rows, (byte)(6), (byte)(0), ".", "")));
      subgridsdtprofesionalespecialidadsedes_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e222Z2( )
   {
      /* 'DobtnAddServicios' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV68ServiciosNombre)==0) )
      {
         AV41Profesional.Load(AV6ProfesionalId);
         AV67Servicios = (com.projectthani.SdtProfesional_Servicios)new com.projectthani.SdtProfesional_Servicios( remoteHandle, context);
         AV67Servicios.setgxTv_SdtProfesional_Servicios_Serviciosid( java.util.UUID.randomUUID( ) );
         AV67Servicios.setgxTv_SdtProfesional_Servicios_Serviciosnombre( AV68ServiciosNombre );
         AV41Profesional.getgxTv_SdtProfesional_Servicios().add(AV67Servicios, 0);
         AV41Profesional.Update();
         if ( AV41Profesional.Success() )
         {
            httpContext.GX_msglist.addItem("se guardo correctamente el servicio");
            Application.commitDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            AV68ServiciosNombre = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV68ServiciosNombre", AV68ServiciosNombre);
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            httpContext.GX_msglist.addItem("Error al guardar el servicio");
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("Debe llenar todos los campos");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41Profesional", AV41Profesional);
   }

   public void e232Z2( )
   {
      /* 'DobtnAddPremiosLogros' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV38PremiosDescripcion)==0) && ! (GXutil.strcmp("", AV40PremiosNombre)==0) )
      {
         AV41Profesional.Load(AV6ProfesionalId);
         AV37Premios = (com.projectthani.SdtProfesional_Premios)new com.projectthani.SdtProfesional_Premios( remoteHandle, context);
         AV37Premios.setgxTv_SdtProfesional_Premios_Premiosid( java.util.UUID.randomUUID( ) );
         AV37Premios.setgxTv_SdtProfesional_Premios_Premiosnombre( AV40PremiosNombre );
         AV37Premios.setgxTv_SdtProfesional_Premios_Premiosdescripcion( AV38PremiosDescripcion );
         AV37Premios.setgxTv_SdtProfesional_Premios_Premiosfecha( AV39PremiosFecha );
         AV41Profesional.getgxTv_SdtProfesional_Premios().add(AV37Premios, 0);
         AV41Profesional.Update();
         if ( AV41Profesional.Success() )
         {
            httpContext.GX_msglist.addItem("se guardo correctamente el premio");
            Application.commitDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            AV40PremiosNombre = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40PremiosNombre", AV40PremiosNombre);
            AV38PremiosDescripcion = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38PremiosDescripcion", AV38PremiosDescripcion);
            AV39PremiosFecha = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV39PremiosFecha", localUtil.format(AV39PremiosFecha, "99/99/99"));
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            httpContext.GX_msglist.addItem("Error al guardar el premio");
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("Debe llenar todos los campos");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41Profesional", AV41Profesional);
   }

   public void e242Z2( )
   {
      /* 'DobtnAddExperienciaLaboral' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV19ExperienciaLaboralEmpresaNombre)==0) )
      {
         AV41Profesional.Load(AV6ProfesionalId);
         AV17ExperienciaLaboral = (com.projectthani.SdtProfesional_ExperienciaLaboral)new com.projectthani.SdtProfesional_ExperienciaLaboral( remoteHandle, context);
         AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralid( java.util.UUID.randomUUID( ) );
         AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralempresanombre( AV19ExperienciaLaboralEmpresaNombre );
         AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboraldesde( AV18ExperienciaLaboralDesde );
         AV17ExperienciaLaboral.setgxTv_SdtProfesional_ExperienciaLaboral_Experiencialaboralhasta( AV20ExperienciaLaboralHasta );
         AV41Profesional.getgxTv_SdtProfesional_Experiencialaboral().add(AV17ExperienciaLaboral, 0);
         AV41Profesional.Update();
         if ( AV41Profesional.Success() )
         {
            httpContext.GX_msglist.addItem("se guardo correctamente la experiencia laboral");
            Application.commitDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            AV19ExperienciaLaboralEmpresaNombre = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19ExperienciaLaboralEmpresaNombre", AV19ExperienciaLaboralEmpresaNombre);
            AV18ExperienciaLaboralDesde = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18ExperienciaLaboralDesde", localUtil.format(AV18ExperienciaLaboralDesde, "99/99/9999"));
            AV20ExperienciaLaboralHasta = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20ExperienciaLaboralHasta", localUtil.format(AV20ExperienciaLaboralHasta, "99/99/9999"));
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            httpContext.GX_msglist.addItem("Error al guardar la experiencia laboral");
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("Debe llenar todos los campos");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41Profesional", AV41Profesional);
   }

   public void e252Z2( )
   {
      /* 'DoBtnAddEducacion' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV13EducacionProfesionalNombreInstitucion)==0) )
      {
         AV41Profesional.Load(AV6ProfesionalId);
         AV10Educacion = (com.projectthani.SdtProfesional_Educacion)new com.projectthani.SdtProfesional_Educacion( remoteHandle, context);
         AV10Educacion.setgxTv_SdtProfesional_Educacion_Educacionid( java.util.UUID.randomUUID( ) );
         AV10Educacion.setgxTv_SdtProfesional_Educacion_Educacionnombreinstitucion( AV13EducacionProfesionalNombreInstitucion );
         AV10Educacion.setgxTv_SdtProfesional_Educacion_Educacionpaisdescripcion( AV14EducacionProfesionalPais );
         AV10Educacion.setgxTv_SdtProfesional_Educacion_Educaciondesde( AV11EducacionProfesionalDesde );
         AV10Educacion.setgxTv_SdtProfesional_Educacion_Educacionhasta( AV12EducacionProfesionalHasta );
         AV41Profesional.getgxTv_SdtProfesional_Educacion().add(AV10Educacion, 0);
         AV41Profesional.Update();
         if ( AV41Profesional.Success() )
         {
            httpContext.GX_msglist.addItem("se guardo correctamente su educaccion");
            Application.commitDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            AV13EducacionProfesionalNombreInstitucion = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13EducacionProfesionalNombreInstitucion", AV13EducacionProfesionalNombreInstitucion);
            AV14EducacionProfesionalPais = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14EducacionProfesionalPais", AV14EducacionProfesionalPais);
            AV11EducacionProfesionalDesde = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11EducacionProfesionalDesde", localUtil.format(AV11EducacionProfesionalDesde, "99/99/99"));
            AV12EducacionProfesionalHasta = GXutil.nullDate() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12EducacionProfesionalHasta", localUtil.format(AV12EducacionProfesionalHasta, "99/99/99"));
         }
         else
         {
            Application.rollbackDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
            httpContext.GX_msglist.addItem("Error al guardar su educaccion");
         }
      }
      else
      {
         httpContext.GX_msglist.addItem("Debe completar todos los campos");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41Profesional", AV41Profesional);
   }

   public void e262Z2( )
   {
      /* 'DobtnAddEspecialidad' Routine */
      returnInSub = false ;
      if ( ! (0==AV15EspecialidadNombreId) && ! (GXutil.strcmp("", AV16EspecialidadTipoConsulta)==0) )
      {
         AV66SedeId = (short)(1) ;
         new com.projectthani.prcinsertprofesionalespecialidad(remoteHandle, context).execute( AV6ProfesionalId, AV15EspecialidadNombreId, AV66SedeId, AV16EspecialidadTipoConsulta, DecimalUtil.doubleToDec(0)) ;
         httpContext.GX_msglist.addItem("Se guardo correctamente su especialidad");
         AV15EspecialidadNombreId = (short)(0) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15EspecialidadNombreId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15EspecialidadNombreId), 4, 0));
         AV16EspecialidadTipoConsulta = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16EspecialidadTipoConsulta", AV16EspecialidadTipoConsulta);
      }
      else
      {
         httpContext.GX_msglist.addItem("Debe llenar todos los campos");
      }
      /*  Sending Event outputs  */
      dynavEspecialidadnombreid.setValue( GXutil.trim( GXutil.str( AV15EspecialidadNombreId, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadnombreid.getInternalname(), "Values", dynavEspecialidadnombreid.ToJavascriptSource(), true);
      cmbavEspecialidadtipoconsulta.setValue( GXutil.rtrim( AV16EspecialidadTipoConsulta) );
      httpContext.ajax_rsp_assign_prop("", false, cmbavEspecialidadtipoconsulta.getInternalname(), "Values", cmbavEspecialidadtipoconsulta.ToJavascriptSource(), true);
   }

   public void e272Z2( )
   {
      /* 'DoBtnGuardarDatosActualizados' Routine */
      returnInSub = false ;
      AV69UbigeoCode = AV70UbigeoDepartamento + AV72UbigeoProvincia + AV71UbigeoDistrito ;
      AV41Profesional.Load(AV6ProfesionalId);
      AV41Profesional.setgxTv_SdtProfesional_Profesionalcop( AV44ProfesionalCOP );
      AV41Profesional.setgxTv_SdtProfesional_Profesionaltelefono( AV54ProfesionalTelefono );
      AV41Profesional.setgxTv_SdtProfesional_Profesionaldescripcion( AV46ProfesionalDescripcion );
      AV41Profesional.setgxTv_SdtProfesional_Profesionaltiempocita( AV55ProfesionalTiempoCita );
      AV41Profesional.setgxTv_SdtProfesional_Paisid( AV36PaisId );
      AV41Profesional.setgxTv_SdtProfesional_Profesionaldireccion( AV47ProfesionalDireccion );
      AV41Profesional.setgxTv_SdtProfesional_Ubigeocode( AV69UbigeoCode );
      if ( AV73UploadedFiles.size() > 0 )
      {
         AV41Profesional.setgxTv_SdtProfesional_Profesionalfoto( ((com.projectthani.SdtFileUploadData)AV73UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_File() );
         AV41Profesional.setgxTv_SdtProfesional_Profesionalfoto_gxi( com.genexus.GXDbFile.getUriFromFile( "", "", ((com.projectthani.SdtFileUploadData)AV73UploadedFiles.elementAt(-1+1)).getgxTv_SdtFileUploadData_File()) );
      }
      AV41Profesional.Save();
      if ( AV41Profesional.Success() )
      {
         /* Execute user subroutine: 'ENABLEDCAMPOSTART' */
         S122 ();
         if (returnInSub) return;
         bttBtnbtnactualizarregistro_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnactualizarregistro_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnactualizarregistro_Visible), 5, 0), true);
         bttBtnbtnguardardatosactualizados_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnbtnguardardatosactualizados_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnbtnguardardatosactualizados_Visible), 5, 0), true);
         httpContext.GX_msglist.addItem("Se actualizó correctamente su información general");
         Application.commitDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "wpmiperfilmedico");
         httpContext.GX_msglist.addItem("Error al actualizar su información general");
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV41Profesional", AV41Profesional);
   }

   public void S122( )
   {
      /* 'ENABLEDCAMPOSTART' Routine */
      returnInSub = false ;
      Subirfotografia_Visible = false ;
      ucSubirfotografia.sendProperty(context, "", false, Subirfotografia_Internalname, "Visible", GXutil.booltostr( Subirfotografia_Visible));
      cmbavProfesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavProfesionaltipodocumento.getEnabled(), 5, 0), true);
      edtavProfesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalnrodocumento_Enabled), 5, 0), true);
      edtavProfesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalnombres_Enabled), 5, 0), true);
      edtavProfesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalapellidomaterno_Enabled), 5, 0), true);
      edtavProfesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalapellidopaterno_Enabled), 5, 0), true);
      edtavProfesionalfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalfechanacimiento_Enabled), 5, 0), true);
      cmbavProfesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavProfesionalsexo.getEnabled(), 5, 0), true);
      edtavProfesionalcop_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalcop_Enabled), 5, 0), true);
      edtavProfesionaltelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionaltelefono_Enabled), 5, 0), true);
      edtavProfesionaldescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionaldescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionaldescripcion_Enabled), 5, 0), true);
      cmbavProfesionaltiempocita.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltiempocita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavProfesionaltiempocita.getEnabled(), 5, 0), true);
      dynavPaisid.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPaisid.getEnabled(), 5, 0), true);
      edtavProfesionaldireccion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionaldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionaldireccion_Enabled), 5, 0), true);
      cmbavUbigeodepartamento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavUbigeodepartamento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavUbigeodepartamento.getEnabled(), 5, 0), true);
      dynavUbigeodistrito.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynavUbigeodistrito.getInternalname(), "Enabled", GXutil.ltrimstr( dynavUbigeodistrito.getEnabled(), 5, 0), true);
      dynavUbigeoprovincia.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynavUbigeoprovincia.getInternalname(), "Enabled", GXutil.ltrimstr( dynavUbigeoprovincia.getEnabled(), 5, 0), true);
      edtavProfesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalcorreo_Enabled), 5, 0), true);
      edtavProfesionalpassword_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalpassword_Enabled), 5, 0), true);
   }

   public void S132( )
   {
      /* 'ENABLEDCAMPOACTUALIZAR' Routine */
      returnInSub = false ;
      Subirfotografia_Visible = true ;
      ucSubirfotografia.sendProperty(context, "", false, Subirfotografia_Internalname, "Visible", GXutil.booltostr( Subirfotografia_Visible));
      cmbavProfesionaltipodocumento.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltipodocumento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavProfesionaltipodocumento.getEnabled(), 5, 0), true);
      edtavProfesionalnrodocumento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalnrodocumento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalnrodocumento_Enabled), 5, 0), true);
      edtavProfesionalnombres_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalnombres_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalnombres_Enabled), 5, 0), true);
      edtavProfesionalapellidomaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalapellidomaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalapellidomaterno_Enabled), 5, 0), true);
      edtavProfesionalapellidopaterno_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalapellidopaterno_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalapellidopaterno_Enabled), 5, 0), true);
      edtavProfesionalfechanacimiento_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalfechanacimiento_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalfechanacimiento_Enabled), 5, 0), true);
      cmbavProfesionalsexo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionalsexo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavProfesionalsexo.getEnabled(), 5, 0), true);
      edtavProfesionalcop_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalcop_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalcop_Enabled), 5, 0), true);
      edtavProfesionaltelefono_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionaltelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionaltelefono_Enabled), 5, 0), true);
      edtavProfesionaldescripcion_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionaldescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionaldescripcion_Enabled), 5, 0), true);
      cmbavProfesionaltiempocita.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavProfesionaltiempocita.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavProfesionaltiempocita.getEnabled(), 5, 0), true);
      dynavPaisid.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop("", false, dynavPaisid.getInternalname(), "Enabled", GXutil.ltrimstr( dynavPaisid.getEnabled(), 5, 0), true);
      edtavProfesionaldireccion_Enabled = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionaldireccion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionaldireccion_Enabled), 5, 0), true);
      cmbavUbigeodepartamento.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavUbigeodepartamento.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavUbigeodepartamento.getEnabled(), 5, 0), true);
      dynavUbigeodistrito.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop("", false, dynavUbigeodistrito.getInternalname(), "Enabled", GXutil.ltrimstr( dynavUbigeodistrito.getEnabled(), 5, 0), true);
      dynavUbigeoprovincia.setEnabled( 1 );
      httpContext.ajax_rsp_assign_prop("", false, dynavUbigeoprovincia.getInternalname(), "Enabled", GXutil.ltrimstr( dynavUbigeoprovincia.getEnabled(), 5, 0), true);
      edtavProfesionalcorreo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalcorreo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalcorreo_Enabled), 5, 0), true);
      edtavProfesionalpassword_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavProfesionalpassword_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavProfesionalpassword_Enabled), 5, 0), true);
   }

   public void S112( )
   {
      /* 'CARGARDATAPROFESIONAL' Routine */
      returnInSub = false ;
      AV41Profesional.Load(AV6ProfesionalId);
      AV56ProfesionalTipoDocumento = AV41Profesional.getgxTv_SdtProfesional_Profesionaltipodocumento() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV56ProfesionalTipoDocumento", AV56ProfesionalTipoDocumento);
      AV51ProfesionalNroDocumento = AV41Profesional.getgxTv_SdtProfesional_Profesionalnrodocumento() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV51ProfesionalNroDocumento", AV51ProfesionalNroDocumento);
      AV50ProfesionalNombres = AV41Profesional.getgxTv_SdtProfesional_Profesionalnombres() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV50ProfesionalNombres", AV50ProfesionalNombres);
      AV43ProfesionalApellidoPaterno = AV41Profesional.getgxTv_SdtProfesional_Profesionalapellidopaterno() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV43ProfesionalApellidoPaterno", AV43ProfesionalApellidoPaterno);
      AV42ProfesionalApellidoMaterno = AV41Profesional.getgxTv_SdtProfesional_Profesionalapellidomaterno() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42ProfesionalApellidoMaterno", AV42ProfesionalApellidoMaterno);
      AV44ProfesionalCOP = AV41Profesional.getgxTv_SdtProfesional_Profesionalcop() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV44ProfesionalCOP", AV44ProfesionalCOP);
      AV45ProfesionalCorreo = AV41Profesional.getgxTv_SdtProfesional_Profesionalcorreo() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV45ProfesionalCorreo", AV45ProfesionalCorreo);
      AV46ProfesionalDescripcion = AV41Profesional.getgxTv_SdtProfesional_Profesionaldescripcion() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV46ProfesionalDescripcion", AV46ProfesionalDescripcion);
      AV47ProfesionalDireccion = AV41Profesional.getgxTv_SdtProfesional_Profesionaldireccion() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV47ProfesionalDireccion", AV47ProfesionalDireccion);
      AV48ProfesionalFechaNacimiento = AV41Profesional.getgxTv_SdtProfesional_Profesionalfechanacimiento() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV48ProfesionalFechaNacimiento", localUtil.format(AV48ProfesionalFechaNacimiento, "99/99/9999"));
      AV49ProfesionalFoto = AV41Profesional.getgxTv_SdtProfesional_Profesionalfoto() ;
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "Bitmap", ((GXutil.strcmp("", AV49ProfesionalFoto)==0) ? AV99Profesionalfoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV49ProfesionalFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV49ProfesionalFoto), true);
      AV99Profesionalfoto_GXI = AV41Profesional.getgxTv_SdtProfesional_Profesionalfoto_gxi() ;
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "Bitmap", ((GXutil.strcmp("", AV49ProfesionalFoto)==0) ? AV99Profesionalfoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV49ProfesionalFoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgavProfesionalfoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV49ProfesionalFoto), true);
      AV7SecUser.Load(AV41Profesional.getgxTv_SdtProfesional_Secuserid());
      AV52ProfesionalPassword = AV7SecUser.getgxTv_SdtSecUser_Secuserpassword() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV52ProfesionalPassword", AV52ProfesionalPassword);
      AV53ProfesionalSexo = AV41Profesional.getgxTv_SdtProfesional_Profesionalsexo() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV53ProfesionalSexo", AV53ProfesionalSexo);
      AV54ProfesionalTelefono = AV41Profesional.getgxTv_SdtProfesional_Profesionaltelefono() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV54ProfesionalTelefono", AV54ProfesionalTelefono);
      AV55ProfesionalTiempoCita = AV41Profesional.getgxTv_SdtProfesional_Profesionaltiempocita() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV55ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55ProfesionalTiempoCita), 2, 0));
      AV36PaisId = AV41Profesional.getgxTv_SdtProfesional_Paisid() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36PaisId), 4, 0));
      /* Using cursor H002Z9 */
      pr_default.execute(7, new Object[] {AV41Profesional.getgxTv_SdtProfesional_Ubigeocode()});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A44UbigeoCode = H002Z9_A44UbigeoCode[0] ;
         A295UbigeoDepartamentoCode = GXutil.substring( A44UbigeoCode, 1, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A295UbigeoDepartamentoCode", A295UbigeoDepartamentoCode);
         A297UbigeoDistritoCode = GXutil.substring( A44UbigeoCode, 5, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A297UbigeoDistritoCode", A297UbigeoDistritoCode);
         A296UbigeoProvinciaCode = GXutil.substring( A44UbigeoCode, 3, 2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A296UbigeoProvinciaCode", A296UbigeoProvinciaCode);
         AV57Provincia = A296UbigeoProvinciaCode ;
         AV9Distrito = A297UbigeoDistritoCode ;
         AV8Departamento = A295UbigeoDepartamentoCode ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(7);
      AV70UbigeoDepartamento = AV8Departamento ;
      httpContext.ajax_rsp_assign_attri("", false, "AV70UbigeoDepartamento", AV70UbigeoDepartamento);
      AV71UbigeoDistrito = AV9Distrito ;
      httpContext.ajax_rsp_assign_attri("", false, "AV71UbigeoDistrito", AV71UbigeoDistrito);
      AV72UbigeoProvincia = AV57Provincia ;
      httpContext.ajax_rsp_assign_attri("", false, "AV72UbigeoProvincia", AV72UbigeoProvincia);
   }

   private void e342Z5( )
   {
      /* Gridsdtprofesionalservicioss_Load Routine */
      returnInSub = false ;
      AV95GXV19 = 1 ;
      while ( AV95GXV19 <= AV63SDTProfesionalServicioss.size() )
      {
         AV63SDTProfesionalServicioss.currentItem( ((com.projectthani.SdtSDTProfesionalServicios)AV63SDTProfesionalServicioss.elementAt(-1+AV95GXV19)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(386) ;
         }
         if ( ( subGridsdtprofesionalservicioss_Islastpage == 1 ) || ( subGridsdtprofesionalservicioss_Rows == 0 ) || ( ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord >= GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord < GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage + subgridsdtprofesionalservicioss_fnc_recordsperpage( ) ) ) )
         {
            sendrow_3865( ) ;
            GRIDSDTPROFESIONALSERVICIOSS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord + 1 >= subgridsdtprofesionalservicioss_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALSERVICIOSS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALSERVICIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALSERVICIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord = (long)(GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_386_Refreshing )
         {
            httpContext.doAjaxLoad(386, GridsdtprofesionalserviciossRow);
         }
         AV95GXV19 = (int)(AV95GXV19+1) ;
      }
   }

   private void e332Z6( )
   {
      /* Gridsdtprofesionalpremioss_Load Routine */
      returnInSub = false ;
      AV91GXV15 = 1 ;
      while ( AV91GXV15 <= AV62SDTProfesionalPremioss.size() )
      {
         AV62SDTProfesionalPremioss.currentItem( ((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(348) ;
         }
         if ( ( subGridsdtprofesionalpremioss_Islastpage == 1 ) || ( subGridsdtprofesionalpremioss_Rows == 0 ) || ( ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord >= GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord < GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage + subgridsdtprofesionalpremioss_fnc_recordsperpage( ) ) ) )
         {
            sendrow_3486( ) ;
            GRIDSDTPROFESIONALPREMIOSS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord + 1 >= subgridsdtprofesionalpremioss_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALPREMIOSS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALPREMIOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALPREMIOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord = (long)(GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_348_Refreshing )
         {
            httpContext.doAjaxLoad(348, GridsdtprofesionalpremiossRow);
         }
         AV91GXV15 = (int)(AV91GXV15+1) ;
      }
   }

   private void e322Z7( )
   {
      /* Gridsdtprofesionalexperiencialaborals_Load Routine */
      returnInSub = false ;
      AV87GXV11 = 1 ;
      while ( AV87GXV11 <= AV60SDTProfesionalExperienciaLaborals.size() )
      {
         AV60SDTProfesionalExperienciaLaborals.currentItem( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(292) ;
         }
         if ( ( subGridsdtprofesionalexperiencialaborals_Islastpage == 1 ) || ( subGridsdtprofesionalexperiencialaborals_Rows == 0 ) || ( ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord >= GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord < GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage + subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2927( ) ;
            GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord + 1 >= subgridsdtprofesionalexperiencialaborals_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord = (long)(GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_292_Refreshing )
         {
            httpContext.doAjaxLoad(292, GridsdtprofesionalexperiencialaboralsRow);
         }
         AV87GXV11 = (int)(AV87GXV11+1) ;
      }
   }

   private void e312Z8( )
   {
      /* Gridsdtprofesionaleducacions_Load Routine */
      returnInSub = false ;
      AV82GXV6 = 1 ;
      while ( AV82GXV6 <= AV58SDTProfesionalEducacions.size() )
      {
         AV58SDTProfesionalEducacions.currentItem( ((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)) );
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(235) ;
         }
         if ( ( subGridsdtprofesionaleducacions_Islastpage == 1 ) || ( subGridsdtprofesionaleducacions_Rows == 0 ) || ( ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord >= GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage ) && ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord < GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage + subgridsdtprofesionaleducacions_fnc_recordsperpage( ) ) ) )
         {
            sendrow_2358( ) ;
            GRIDSDTPROFESIONALEDUCACIONS_nEOF = (byte)(0) ;
            com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord + 1 >= subgridsdtprofesionaleducacions_fnc_recordcount( ) )
            {
               GRIDSDTPROFESIONALEDUCACIONS_nEOF = (byte)(1) ;
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GRIDSDTPROFESIONALEDUCACIONS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDTPROFESIONALEDUCACIONS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord = (long)(GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_235_Refreshing )
         {
            httpContext.doAjaxLoad(235, GridsdtprofesionaleducacionsRow);
         }
         AV82GXV6 = (int)(AV82GXV6+1) ;
      }
   }

   public void wb_table10_380_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelservicioslist_Internalname, tblPanelservicioslist_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridsdtprofesionalserviciosstablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtprofesionalserviciossContainer.SetWrapped(nGXWrapped);
         if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalserviciossContainer"+"DivS\" data-gxgridid=\"386\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtprofesionalservicioss_Internalname, subGridsdtprofesionalservicioss_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtprofesionalservicioss_Backcolorstyle == 0 )
            {
               subGridsdtprofesionalservicioss_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtprofesionalservicioss_Class) > 0 )
               {
                  subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtprofesionalservicioss_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtprofesionalservicioss_Backcolorstyle == 1 )
               {
                  subGridsdtprofesionalservicioss_Titlebackcolor = subGridsdtprofesionalservicioss_Allbackcolor ;
                  if ( GXutil.len( subGridsdtprofesionalservicioss_Class) > 0 )
                  {
                     subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtprofesionalservicioss_Class) > 0 )
                  {
                     subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Servicios Nombre") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtprofesionalserviciossContainer.AddObjectProperty("GridName", "Gridsdtprofesionalservicioss");
         }
         else
         {
            GridsdtprofesionalserviciossContainer.AddObjectProperty("GridName", "Gridsdtprofesionalservicioss");
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Header", subGridsdtprofesionalservicioss_Header);
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("CmpContext", "");
            GridsdtprofesionalserviciossContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtprofesionalserviciossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalserviciossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalservicioss__serviciosnombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddColumnProperties(GridsdtprofesionalserviciossColumn);
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalserviciossContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalservicioss_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 386 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_386 = (int)(nGXsfl_386_idx-1) ;
         if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV95GXV19 = nGXsfl_386_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalserviciossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalservicioss", GridsdtprofesionalserviciossContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalserviciossContainerData", GridsdtprofesionalserviciossContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalserviciossContainerData"+"V", GridsdtprofesionalserviciossContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalserviciossContainerData"+"V"+"\" value='"+GridsdtprofesionalserviciossContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("Class", Gridsdtprofesionalserviciosspaginationbar_Class);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("ShowFirst", Gridsdtprofesionalserviciosspaginationbar_Showfirst);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("ShowPrevious", Gridsdtprofesionalserviciosspaginationbar_Showprevious);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("ShowNext", Gridsdtprofesionalserviciosspaginationbar_Shownext);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("ShowLast", Gridsdtprofesionalserviciosspaginationbar_Showlast);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("PagesToShow", Gridsdtprofesionalserviciosspaginationbar_Pagestoshow);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("PagingButtonsPosition", Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("PagingCaptionPosition", Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("EmptyGridClass", Gridsdtprofesionalserviciosspaginationbar_Emptygridclass);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("RowsPerPageSelector", Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("RowsPerPageOptions", Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("Previous", Gridsdtprofesionalserviciosspaginationbar_Previous);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("Next", Gridsdtprofesionalserviciosspaginationbar_Next);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("Caption", Gridsdtprofesionalserviciosspaginationbar_Caption);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("EmptyGridCaption", Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("RowsPerPageCaption", Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("CurrentPage", AV31GridSDTProfesionalServiciossCurrentPage);
         ucGridsdtprofesionalserviciosspaginationbar.setProperty("PageCount", AV32GridSDTProfesionalServiciossPageCount);
         ucGridsdtprofesionalserviciosspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalserviciosspaginationbar_Internalname, "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table10_380_2Z2e( true) ;
      }
      else
      {
         wb_table10_380_2Z2e( false) ;
      }
   }

   public void wb_table9_364_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelservicios_Internalname, tblPanelservicios_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableserviciosnombre_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockserviciosnombre_Internalname, "Servicio", "", "", lblTextblockserviciosnombre_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavServiciosnombre_Internalname, "Servicios Nombre", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 373,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavServiciosnombre_Internalname, AV68ServiciosNombre, GXutil.rtrim( localUtil.format( AV68ServiciosNombre, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,373);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavServiciosnombre_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavServiciosnombre_Enabled, 0, "text", "", 40, "chr", 1, "row", 300, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 376,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnaddservicios_Internalname, "gx.evt.setGridEvt("+GXutil.str( 169, 3, 0)+","+"null"+");", "Guardar", bttBtnbtnaddservicios_Jsonclick, 5, "Guardar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNADDSERVICIOS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilMedico.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_364_2Z2e( true) ;
      }
      else
      {
         wb_table9_364_2Z2e( false) ;
      }
   }

   public void wb_table8_342_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelpremioslogroslist_Internalname, tblPanelpremioslogroslist_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridsdtprofesionalpremiosstablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtprofesionalpremiossContainer.SetWrapped(nGXWrapped);
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalpremiossContainer"+"DivS\" data-gxgridid=\"348\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtprofesionalpremioss_Internalname, subGridsdtprofesionalpremioss_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtprofesionalpremioss_Backcolorstyle == 0 )
            {
               subGridsdtprofesionalpremioss_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtprofesionalpremioss_Class) > 0 )
               {
                  subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtprofesionalpremioss_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtprofesionalpremioss_Backcolorstyle == 1 )
               {
                  subGridsdtprofesionalpremioss_Titlebackcolor = subGridsdtprofesionalpremioss_Allbackcolor ;
                  if ( GXutil.len( subGridsdtprofesionalpremioss_Class) > 0 )
                  {
                     subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtprofesionalpremioss_Class) > 0 )
                  {
                     subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Premio") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Fecha") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Descripcion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtprofesionalpremiossContainer.AddObjectProperty("GridName", "Gridsdtprofesionalpremioss");
         }
         else
         {
            GridsdtprofesionalpremiossContainer.AddObjectProperty("GridName", "Gridsdtprofesionalpremioss");
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Header", subGridsdtprofesionalpremioss_Header);
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("CmpContext", "");
            GridsdtprofesionalpremiossContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtprofesionalpremiossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalpremiossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalpremioss__premiosnombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddColumnProperties(GridsdtprofesionalpremiossColumn);
            GridsdtprofesionalpremiossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalpremiossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalpremioss__premiosfecha_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddColumnProperties(GridsdtprofesionalpremiossColumn);
            GridsdtprofesionalpremiossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalpremiossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalpremioss__premiosdescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddColumnProperties(GridsdtprofesionalpremiossColumn);
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalpremiossContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalpremioss_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 348 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_348 = (int)(nGXsfl_348_idx-1) ;
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV91GXV15 = nGXsfl_348_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalpremiossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalpremioss", GridsdtprofesionalpremiossContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalpremiossContainerData", GridsdtprofesionalpremiossContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalpremiossContainerData"+"V", GridsdtprofesionalpremiossContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalpremiossContainerData"+"V"+"\" value='"+GridsdtprofesionalpremiossContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("Class", Gridsdtprofesionalpremiosspaginationbar_Class);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("ShowFirst", Gridsdtprofesionalpremiosspaginationbar_Showfirst);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("ShowPrevious", Gridsdtprofesionalpremiosspaginationbar_Showprevious);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("ShowNext", Gridsdtprofesionalpremiosspaginationbar_Shownext);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("ShowLast", Gridsdtprofesionalpremiosspaginationbar_Showlast);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("PagesToShow", Gridsdtprofesionalpremiosspaginationbar_Pagestoshow);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("PagingButtonsPosition", Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("PagingCaptionPosition", Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("EmptyGridClass", Gridsdtprofesionalpremiosspaginationbar_Emptygridclass);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("RowsPerPageSelector", Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("RowsPerPageOptions", Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("Previous", Gridsdtprofesionalpremiosspaginationbar_Previous);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("Next", Gridsdtprofesionalpremiosspaginationbar_Next);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("Caption", Gridsdtprofesionalpremiosspaginationbar_Caption);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("EmptyGridCaption", Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("RowsPerPageCaption", Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("CurrentPage", AV29GridSDTProfesionalPremiossCurrentPage);
         ucGridsdtprofesionalpremiosspaginationbar.setProperty("PageCount", AV30GridSDTProfesionalPremiossPageCount);
         ucGridsdtprofesionalpremiosspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalpremiosspaginationbar_Internalname, "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_342_2Z2e( true) ;
      }
      else
      {
         wb_table8_342_2Z2e( false) ;
      }
   }

   public void wb_table7_308_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelpremioslogros_Internalname, tblPanelpremioslogros_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablepremiosnombre_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpremiosnombre_Internalname, "Premios Nombre", "", "", lblTextblockpremiosnombre_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPremiosnombre_Internalname, "Premios Nombre", "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 317,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavPremiosnombre_Internalname, AV40PremiosNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,317);\"", (short)(0), 1, edtavPremiosnombre_Enabled, 0, 40, "chr", 2, "row", StyleString, ClassString, "", "", "500", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablepremiosdescripcion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpremiosdescripcion_Internalname, "Premios Descripcion", "", "", lblTextblockpremiosdescripcion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPremiosdescripcion_Internalname, "Premios Descripcion", "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 326,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavPremiosdescripcion_Internalname, AV38PremiosDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,326);\"", (short)(0), 1, edtavPremiosdescripcion_Enabled, 0, 40, "chr", 2, "row", StyleString, ClassString, "", "", "2097152", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtablepremiosfecha_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockpremiosfecha_Internalname, "Premios Fecha", "", "", lblTextblockpremiosfecha_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavPremiosfecha_Internalname, "Premios Fecha", "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 335,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavPremiosfecha_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavPremiosfecha_Internalname, localUtil.format(AV39PremiosFecha, "99/99/99"), localUtil.format( AV39PremiosFecha, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,335);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavPremiosfecha_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavPremiosfecha_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavPremiosfecha_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavPremiosfecha_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPMiPerfilMedico.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 338,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnaddpremioslogros_Internalname, "gx.evt.setGridEvt("+GXutil.str( 169, 3, 0)+","+"null"+");", "Guardar", bttBtnbtnaddpremioslogros_Jsonclick, 5, "Guardar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNADDPREMIOSLOGROS\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilMedico.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_308_2Z2e( true) ;
      }
      else
      {
         wb_table7_308_2Z2e( false) ;
      }
   }

   public void wb_table6_286_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelexperiencialaborallist_Internalname, tblPanelexperiencialaborallist_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridsdtprofesionalexperiencialaboralstablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtprofesionalexperiencialaboralsContainer.SetWrapped(nGXWrapped);
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalexperiencialaboralsContainer"+"DivS\" data-gxgridid=\"292\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtprofesionalexperiencialaborals_Internalname, subGridsdtprofesionalexperiencialaborals_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtprofesionalexperiencialaborals_Backcolorstyle == 0 )
            {
               subGridsdtprofesionalexperiencialaborals_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtprofesionalexperiencialaborals_Class) > 0 )
               {
                  subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtprofesionalexperiencialaborals_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtprofesionalexperiencialaborals_Backcolorstyle == 1 )
               {
                  subGridsdtprofesionalexperiencialaborals_Titlebackcolor = subGridsdtprofesionalexperiencialaborals_Allbackcolor ;
                  if ( GXutil.len( subGridsdtprofesionalexperiencialaborals_Class) > 0 )
                  {
                     subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtprofesionalexperiencialaborals_Class) > 0 )
                  {
                     subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Empresa") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Desde") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hasta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("GridName", "Gridsdtprofesionalexperiencialaborals");
         }
         else
         {
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("GridName", "Gridsdtprofesionalexperiencialaborals");
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Header", subGridsdtprofesionalexperiencialaborals_Header);
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("CmpContext", "");
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtprofesionalexperiencialaboralsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalexperiencialaboralsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddColumnProperties(GridsdtprofesionalexperiencialaboralsColumn);
            GridsdtprofesionalexperiencialaboralsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalexperiencialaboralsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddColumnProperties(GridsdtprofesionalexperiencialaboralsColumn);
            GridsdtprofesionalexperiencialaboralsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalexperiencialaboralsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddColumnProperties(GridsdtprofesionalexperiencialaboralsColumn);
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalexperiencialaboralsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalexperiencialaborals_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 292 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_292 = (int)(nGXsfl_292_idx-1) ;
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV87GXV11 = nGXsfl_292_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalexperiencialaboralsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalexperiencialaborals", GridsdtprofesionalexperiencialaboralsContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalexperiencialaboralsContainerData", GridsdtprofesionalexperiencialaboralsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalexperiencialaboralsContainerData"+"V", GridsdtprofesionalexperiencialaboralsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalexperiencialaboralsContainerData"+"V"+"\" value='"+GridsdtprofesionalexperiencialaboralsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("Class", Gridsdtprofesionalexperiencialaboralspaginationbar_Class);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("ShowFirst", Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("ShowPrevious", Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("ShowNext", Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("ShowLast", Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("PagesToShow", Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("PagingButtonsPosition", Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("PagingCaptionPosition", Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("EmptyGridClass", Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("RowsPerPageSelector", Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("RowsPerPageOptions", Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("Previous", Gridsdtprofesionalexperiencialaboralspaginationbar_Previous);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("Next", Gridsdtprofesionalexperiencialaboralspaginationbar_Next);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("Caption", Gridsdtprofesionalexperiencialaboralspaginationbar_Caption);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("EmptyGridCaption", Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("RowsPerPageCaption", Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("CurrentPage", AV27GridSDTProfesionalExperienciaLaboralsCurrentPage);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.setProperty("PageCount", AV28GridSDTProfesionalExperienciaLaboralsPageCount);
         ucGridsdtprofesionalexperiencialaboralspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalexperiencialaboralspaginationbar_Internalname, "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_286_2Z2e( true) ;
      }
      else
      {
         wb_table6_286_2Z2e( false) ;
      }
   }

   public void wb_table5_252_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelexperiencialaboral_Internalname, tblPanelexperiencialaboral_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableexperiencialaboralempresanombre_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockexperiencialaboralempresanombre_Internalname, "Nombre Empresa", "", "", lblTextblockexperiencialaboralempresanombre_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavExperiencialaboralempresanombre_Internalname, "Experiencia Laboral Empresa Nombre", "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 261,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavExperiencialaboralempresanombre_Internalname, AV19ExperienciaLaboralEmpresaNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,261);\"", (short)(0), 1, edtavExperiencialaboralempresanombre_Enabled, 0, 40, "chr", 2, "row", StyleString, ClassString, "", "", "300", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableexperiencialaboraldesde_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockexperiencialaboraldesde_Internalname, "Desde", "", "", lblTextblockexperiencialaboraldesde_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavExperiencialaboraldesde_Internalname, "Experiencia Laboral Desde", "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 270,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavExperiencialaboraldesde_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavExperiencialaboraldesde_Internalname, localUtil.format(AV18ExperienciaLaboralDesde, "99/99/9999"), localUtil.format( AV18ExperienciaLaboralDesde, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,270);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavExperiencialaboraldesde_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavExperiencialaboraldesde_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavExperiencialaboraldesde_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavExperiencialaboraldesde_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPMiPerfilMedico.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableexperiencialaboralhasta_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockexperiencialaboralhasta_Internalname, "Hasta", "", "", lblTextblockexperiencialaboralhasta_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavExperiencialaboralhasta_Internalname, "Experiencia Laboral Hasta", "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 279,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavExperiencialaboralhasta_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavExperiencialaboralhasta_Internalname, localUtil.format(AV20ExperienciaLaboralHasta, "99/99/9999"), localUtil.format( AV20ExperienciaLaboralHasta, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,279);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavExperiencialaboralhasta_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavExperiencialaboralhasta_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavExperiencialaboralhasta_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavExperiencialaboralhasta_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPMiPerfilMedico.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 282,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnaddexperiencialaboral_Internalname, "gx.evt.setGridEvt("+GXutil.str( 169, 3, 0)+","+"null"+");", "Guardar", bttBtnbtnaddexperiencialaboral_Jsonclick, 5, "Guardar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNADDEXPERIENCIALABORAL\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilMedico.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_252_2Z2e( true) ;
      }
      else
      {
         wb_table5_252_2Z2e( false) ;
      }
   }

   public void wb_table4_229_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPaneleducacionlist_Internalname, tblPaneleducacionlist_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridsdtprofesionaleducacionstablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtprofesionaleducacionsContainer.SetWrapped(nGXWrapped);
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtprofesionaleducacionsContainer"+"DivS\" data-gxgridid=\"235\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtprofesionaleducacions_Internalname, subGridsdtprofesionaleducacions_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtprofesionaleducacions_Backcolorstyle == 0 )
            {
               subGridsdtprofesionaleducacions_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtprofesionaleducacions_Class) > 0 )
               {
                  subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtprofesionaleducacions_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtprofesionaleducacions_Backcolorstyle == 1 )
               {
                  subGridsdtprofesionaleducacions_Titlebackcolor = subGridsdtprofesionaleducacions_Allbackcolor ;
                  if ( GXutil.len( subGridsdtprofesionaleducacions_Class) > 0 )
                  {
                     subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtprofesionaleducacions_Class) > 0 )
                  {
                     subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Nombre Institucion") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Pais") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Desde") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Hasta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("GridName", "Gridsdtprofesionaleducacions");
         }
         else
         {
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("GridName", "Gridsdtprofesionaleducacions");
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Header", subGridsdtprofesionaleducacions_Header);
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("CmpContext", "");
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtprofesionaleducacionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionaleducacionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddColumnProperties(GridsdtprofesionaleducacionsColumn);
            GridsdtprofesionaleducacionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionaleducacionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddColumnProperties(GridsdtprofesionaleducacionsColumn);
            GridsdtprofesionaleducacionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionaleducacionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionaleducacions__educaciondesde_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddColumnProperties(GridsdtprofesionaleducacionsColumn);
            GridsdtprofesionaleducacionsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionaleducacionsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionaleducacions__educacionhasta_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddColumnProperties(GridsdtprofesionaleducacionsColumn);
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionaleducacionsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionaleducacions_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 235 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_235 = (int)(nGXsfl_235_idx-1) ;
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV82GXV6 = nGXsfl_235_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtprofesionaleducacionsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionaleducacions", GridsdtprofesionaleducacionsContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionaleducacionsContainerData", GridsdtprofesionaleducacionsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionaleducacionsContainerData"+"V", GridsdtprofesionaleducacionsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionaleducacionsContainerData"+"V"+"\" value='"+GridsdtprofesionaleducacionsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("Class", Gridsdtprofesionaleducacionspaginationbar_Class);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("ShowFirst", Gridsdtprofesionaleducacionspaginationbar_Showfirst);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("ShowPrevious", Gridsdtprofesionaleducacionspaginationbar_Showprevious);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("ShowNext", Gridsdtprofesionaleducacionspaginationbar_Shownext);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("ShowLast", Gridsdtprofesionaleducacionspaginationbar_Showlast);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("PagesToShow", Gridsdtprofesionaleducacionspaginationbar_Pagestoshow);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("PagingButtonsPosition", Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("PagingCaptionPosition", Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("EmptyGridClass", Gridsdtprofesionaleducacionspaginationbar_Emptygridclass);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("RowsPerPageSelector", Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("RowsPerPageOptions", Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("Previous", Gridsdtprofesionaleducacionspaginationbar_Previous);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("Next", Gridsdtprofesionaleducacionspaginationbar_Next);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("Caption", Gridsdtprofesionaleducacionspaginationbar_Caption);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("EmptyGridCaption", Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("RowsPerPageCaption", Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("CurrentPage", AV23GridSDTProfesionalEducacionsCurrentPage);
         ucGridsdtprofesionaleducacionspaginationbar.setProperty("PageCount", AV24GridSDTProfesionalEducacionsPageCount);
         ucGridsdtprofesionaleducacionspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionaleducacionspaginationbar_Internalname, "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_229_2Z2e( true) ;
      }
      else
      {
         wb_table4_229_2Z2e( false) ;
      }
   }

   public void wb_table3_186_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPaneleducacion_Internalname, tblPaneleducacion_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableeducacionprofesionalnombreinstitucion_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockeducacionprofesionalnombreinstitucion_Internalname, "Nombre Institucion", "", "", lblTextblockeducacionprofesionalnombreinstitucion_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavEducacionprofesionalnombreinstitucion_Internalname, "Educacion Profesional Nombre Institucion", "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 195,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_html_textarea( httpContext, edtavEducacionprofesionalnombreinstitucion_Internalname, AV13EducacionProfesionalNombreInstitucion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,195);\"", (short)(0), 1, edtavEducacionprofesionalnombreinstitucion_Enabled, 0, 40, "chr", 2, "row", StyleString, ClassString, "", "", "400", 1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableeducacionprofesionalpais_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockeducacionprofesionalpais_Internalname, "Pais", "", "", lblTextblockeducacionprofesionalpais_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavEducacionprofesionalpais_Internalname, "Educacion Profesional Pais", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 204,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavEducacionprofesionalpais_Internalname, AV14EducacionProfesionalPais, GXutil.rtrim( localUtil.format( AV14EducacionProfesionalPais, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,204);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEducacionprofesionalpais_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavEducacionprofesionalpais_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableeducacionprofesionaldesde_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockeducacionprofesionaldesde_Internalname, "Desde", "", "", lblTextblockeducacionprofesionaldesde_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavEducacionprofesionaldesde_Internalname, "Educacion Profesional Desde", "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 213,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavEducacionprofesionaldesde_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavEducacionprofesionaldesde_Internalname, localUtil.format(AV11EducacionProfesionalDesde, "99/99/99"), localUtil.format( AV11EducacionProfesionalDesde, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,213);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEducacionprofesionaldesde_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavEducacionprofesionaldesde_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavEducacionprofesionaldesde_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavEducacionprofesionaldesde_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPMiPerfilMedico.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableeducacionprofesionalhasta_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockeducacionprofesionalhasta_Internalname, "Hasta", "", "", lblTextblockeducacionprofesionalhasta_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, edtavEducacionprofesionalhasta_Internalname, "Educacion Profesional Hasta", "col-sm-3 AttributeDateLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 222,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         httpContext.writeText( "<div id=\""+edtavEducacionprofesionalhasta_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
         com.projectthani.GxWebStd.gx_single_line_edit( httpContext, edtavEducacionprofesionalhasta_Internalname, localUtil.format(AV12EducacionProfesionalHasta, "99/99/99"), localUtil.format( AV12EducacionProfesionalHasta, "99/99/99"), TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'DMY',0,24,'spa',false,0);"+";gx.evt.onblur(this,222);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEducacionprofesionalhasta_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtavEducacionprofesionalhasta_Enabled, 0, "text", "", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(1), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_bitmap( httpContext, edtavEducacionprofesionalhasta_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtavEducacionprofesionalhasta_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_WPMiPerfilMedico.htm");
         httpContext.writeTextNL( "</div>") ;
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 225,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnaddeducacion_Internalname, "gx.evt.setGridEvt("+GXutil.str( 169, 3, 0)+","+"null"+");", "Guardar", bttBtnbtnaddeducacion_Jsonclick, 5, "Guardar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNADDEDUCACION\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilMedico.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_186_2Z2e( true) ;
      }
      else
      {
         wb_table3_186_2Z2e( false) ;
      }
   }

   public void wb_table2_163_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanellistespe_Internalname, tblPanellistespe_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='HasGridEmpowerer'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divGridsdtprofesionalespecialidadsedestablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsdtprofesionalespecialidadsedesContainer.SetWrapped(nGXWrapped);
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalespecialidadsedesContainer"+"DivS\" data-gxgridid=\"169\">") ;
            sStyleString = "" ;
            com.projectthani.GxWebStd.gx_table_start( httpContext, subGridsdtprofesionalespecialidadsedes_Internalname, subGridsdtprofesionalespecialidadsedes_Internalname, "", "GridWithPaginationBar GridNoBorder WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
            /* Subfile titles */
            httpContext.writeText( "<tr") ;
            httpContext.writeTextNL( ">") ;
            if ( subGridsdtprofesionalespecialidadsedes_Backcolorstyle == 0 )
            {
               subGridsdtprofesionalespecialidadsedes_Titlebackstyle = (byte)(0) ;
               if ( GXutil.len( subGridsdtprofesionalespecialidadsedes_Class) > 0 )
               {
                  subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"Title" ;
               }
            }
            else
            {
               subGridsdtprofesionalespecialidadsedes_Titlebackstyle = (byte)(1) ;
               if ( subGridsdtprofesionalespecialidadsedes_Backcolorstyle == 1 )
               {
                  subGridsdtprofesionalespecialidadsedes_Titlebackcolor = subGridsdtprofesionalespecialidadsedes_Allbackcolor ;
                  if ( GXutil.len( subGridsdtprofesionalespecialidadsedes_Class) > 0 )
                  {
                     subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"UniformTitle" ;
                  }
               }
               else
               {
                  if ( GXutil.len( subGridsdtprofesionalespecialidadsedes_Class) > 0 )
                  {
                     subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"Title" ;
                  }
               }
            }
            httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Id") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Codigo") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Especialidad") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
            httpContext.writeValue( "Tipo Consulta") ;
            httpContext.writeTextNL( "</th>") ;
            httpContext.writeTextNL( "</tr>") ;
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("GridName", "Gridsdtprofesionalespecialidadsedes");
         }
         else
         {
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("GridName", "Gridsdtprofesionalespecialidadsedes");
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Header", subGridsdtprofesionalespecialidadsedes_Header);
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Class", "GridWithPaginationBar GridNoBorder WorkWith");
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("CmpContext", "");
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("InMasterPage", "false");
            GridsdtprofesionalespecialidadsedesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalespecialidadsedesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddColumnProperties(GridsdtprofesionalespecialidadsedesColumn);
            GridsdtprofesionalespecialidadsedesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalespecialidadsedesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddColumnProperties(GridsdtprofesionalespecialidadsedesColumn);
            GridsdtprofesionalespecialidadsedesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalespecialidadsedesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled, (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddColumnProperties(GridsdtprofesionalespecialidadsedesColumn);
            GridsdtprofesionalespecialidadsedesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
            GridsdtprofesionalespecialidadsedesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled(), (byte)(5), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddColumnProperties(GridsdtprofesionalespecialidadsedesColumn);
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Selectedindex, (byte)(4), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Allowselection, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Allowhovering, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
            GridsdtprofesionalespecialidadsedesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdtprofesionalespecialidadsedes_Collapsed, (byte)(1), (byte)(0), ".", "")));
         }
      }
      if ( wbEnd == 169 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_169 = (int)(nGXsfl_169_idx-1) ;
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            AV77GXV1 = nGXsfl_169_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsdtprofesionalespecialidadsedesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdtprofesionalespecialidadsedes", GridsdtprofesionalespecialidadsedesContainer);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalespecialidadsedesContainerData", GridsdtprofesionalespecialidadsedesContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.projectthani.GxWebStd.gx_hidden_field( httpContext, "GridsdtprofesionalespecialidadsedesContainerData"+"V", GridsdtprofesionalespecialidadsedesContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsdtprofesionalespecialidadsedesContainerData"+"V"+"\" value='"+GridsdtprofesionalespecialidadsedesContainer.GridValuesHidden()+"'/>") ;
            }
         }
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("Class", Gridsdtprofesionalespecialidadsedespaginationbar_Class);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("ShowFirst", Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("ShowPrevious", Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("ShowNext", Gridsdtprofesionalespecialidadsedespaginationbar_Shownext);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("ShowLast", Gridsdtprofesionalespecialidadsedespaginationbar_Showlast);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("PagesToShow", Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("PagingButtonsPosition", Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("PagingCaptionPosition", Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("EmptyGridClass", Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("RowsPerPageSelector", Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("RowsPerPageOptions", Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("Previous", Gridsdtprofesionalespecialidadsedespaginationbar_Previous);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("Next", Gridsdtprofesionalespecialidadsedespaginationbar_Next);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("Caption", Gridsdtprofesionalespecialidadsedespaginationbar_Caption);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("EmptyGridCaption", Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("RowsPerPageCaption", Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("CurrentPage", AV25GridSDTProfesionalEspecialidadSedesCurrentPage);
         ucGridsdtprofesionalespecialidadsedespaginationbar.setProperty("PageCount", AV26GridSDTProfesionalEspecialidadSedesPageCount);
         ucGridsdtprofesionalespecialidadsedespaginationbar.render(context, "dvelop.dvpaginationbar", Gridsdtprofesionalespecialidadsedespaginationbar_Internalname, "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBARContainer");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_163_2Z2e( true) ;
      }
      else
      {
         wb_table2_163_2Z2e( false) ;
      }
   }

   public void wb_table1_138_2Z2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         com.projectthani.GxWebStd.gx_table_start( httpContext, tblPanelregespe_Internalname, tblPanelregespe_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableespecialidadnombreid_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockespecialidadnombreid_Internalname, "Especialidad", "", "", lblTextblockespecialidadnombreid_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, dynavEspecialidadnombreid.getInternalname(), "Especialidad Nombre Id", "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 147,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, dynavEspecialidadnombreid, dynavEspecialidadnombreid.getInternalname(), GXutil.trim( GXutil.str( AV15EspecialidadNombreId, 4, 0)), 1, dynavEspecialidadnombreid.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynavEspecialidadnombreid.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,147);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         dynavEspecialidadnombreid.setValue( GXutil.trim( GXutil.str( AV15EspecialidadNombreId, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavEspecialidadnombreid.getInternalname(), "Values", dynavEspecialidadnombreid.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='TableMarginTop25px DscTop'>") ;
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, divUnnamedtableespecialidadtipoconsulta_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         com.projectthani.GxWebStd.gx_label_ctrl( httpContext, lblTextblockespecialidadtipoconsulta_Internalname, "Tipo Consulta", "", "", lblTextblockespecialidadtipoconsulta_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_WPMiPerfilMedico.htm");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.projectthani.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.projectthani.GxWebStd.gx_label_element( httpContext, cmbavEspecialidadtipoconsulta.getInternalname(), "Especialidad Tipo Consulta", "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 156,'',false,'" + sGXsfl_169_idx + "',0)\"" ;
         /* ComboBox */
         com.projectthani.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavEspecialidadtipoconsulta, cmbavEspecialidadtipoconsulta.getInternalname(), GXutil.rtrim( AV16EspecialidadTipoConsulta), 1, cmbavEspecialidadtipoconsulta.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbavEspecialidadtipoconsulta.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,156);\"", "", true, (byte)(1), "HLP_WPMiPerfilMedico.htm");
         cmbavEspecialidadtipoconsulta.setValue( GXutil.rtrim( AV16EspecialidadTipoConsulta) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavEspecialidadtipoconsulta.getInternalname(), "Values", cmbavEspecialidadtipoconsulta.ToJavascriptSource(), true);
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.projectthani.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 159,'',false,'',0)\"" ;
         ClassString = "ButtonMaterial" ;
         StyleString = "" ;
         com.projectthani.GxWebStd.gx_button_ctrl( httpContext, bttBtnbtnaddespecialidad_Internalname, "gx.evt.setGridEvt("+GXutil.str( 169, 3, 0)+","+"null"+");", "Guardar", bttBtnbtnaddespecialidad_Jsonclick, 5, "Guardar", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOBTNADDESPECIALIDAD\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_WPMiPerfilMedico.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_138_2Z2e( true) ;
      }
      else
      {
         wb_table1_138_2Z2e( false) ;
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
      pa2Z2( ) ;
      ws2Z2( ) ;
      we2Z2( ) ;
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
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20225110342230", true, true);
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
      httpContext.AddJavascriptSource("wpmiperfilmedico.js", "?20225110342230", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("Shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/TabRender.js", "", false, true);
      httpContext.AddJavascriptSource("FileUpload/fileupload.min.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1692( )
   {
      edtavSdtprofesionalespecialidadsedes__especialidadid_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADID_"+sGXsfl_169_idx ;
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADCODIGO_"+sGXsfl_169_idx ;
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADNOMBRE_"+sGXsfl_169_idx ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setInternalname( "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_"+sGXsfl_169_idx );
   }

   public void subsflControlProps_fel_1692( )
   {
      edtavSdtprofesionalespecialidadsedes__especialidadid_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADID_"+sGXsfl_169_fel_idx ;
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADCODIGO_"+sGXsfl_169_fel_idx ;
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADNOMBRE_"+sGXsfl_169_fel_idx ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setInternalname( "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_"+sGXsfl_169_fel_idx );
   }

   public void sendrow_1692( )
   {
      subsflControlProps_1692( ) ;
      wb2Z0( ) ;
      if ( ( subGridsdtprofesionalespecialidadsedes_Rows * 1 == 0 ) || ( nGXsfl_169_idx <= subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtprofesionalespecialidadsedesRow = GXWebRow.GetNew(context,GridsdtprofesionalespecialidadsedesContainer) ;
         if ( subGridsdtprofesionalespecialidadsedes_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtprofesionalespecialidadsedes_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtprofesionalespecialidadsedes_Class, "") != 0 )
            {
               subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"Odd" ;
            }
         }
         else if ( subGridsdtprofesionalespecialidadsedes_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtprofesionalespecialidadsedes_Backstyle = (byte)(0) ;
            subGridsdtprofesionalespecialidadsedes_Backcolor = subGridsdtprofesionalespecialidadsedes_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtprofesionalespecialidadsedes_Class, "") != 0 )
            {
               subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtprofesionalespecialidadsedes_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtprofesionalespecialidadsedes_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtprofesionalespecialidadsedes_Class, "") != 0 )
            {
               subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"Odd" ;
            }
            subGridsdtprofesionalespecialidadsedes_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtprofesionalespecialidadsedes_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtprofesionalespecialidadsedes_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_169_idx) % (2))) == 0 )
            {
               subGridsdtprofesionalespecialidadsedes_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalespecialidadsedes_Class, "") != 0 )
               {
                  subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtprofesionalespecialidadsedes_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalespecialidadsedes_Class, "") != 0 )
               {
                  subGridsdtprofesionalespecialidadsedes_Linesclass = subGridsdtprofesionalespecialidadsedes_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_169_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalespecialidadsedesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalespecialidadsedes__especialidadid_Internalname,GXutil.ltrim( localUtil.ntoc( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid(), (byte)(4), (byte)(0), ",", "")),GXutil.ltrim( ((edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid()), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadid()), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalespecialidadsedes__especialidadid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(169),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalespecialidadsedesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Internalname,((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadcodigo(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(169),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalespecialidadsedesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname,((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Especialidadnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalespecialidadsedes__especialidadnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(169),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionalespecialidadsedesContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_" + sGXsfl_169_idx ;
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setName( GXCCtl );
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setWebtags( "" );
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("", "Seleccione tipo de consulta", (short)(0));
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("V", "Virtual", (short)(0));
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("P", "En consultorio", (short)(0));
            cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
            if ( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getItemCount() > 0 )
            {
               if ( ( AV77GXV1 > 0 ) && ( AV59SDTProfesionalEspecialidadSedes.size() >= AV77GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta())==0) )
               {
                  ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getValidValue(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
               }
            }
         }
         /* ComboBox */
         GridsdtprofesionalespecialidadsedesRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta,cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(),GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()),Integer.valueOf(1),cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(1)});
         cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setValue( GXutil.rtrim( ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getInternalname(), "Values", cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.ToJavascriptSource(), !bGXsfl_169_Refreshing);
         send_integrity_lvl_hashes2Z2( ) ;
         GridsdtprofesionalespecialidadsedesContainer.AddRow(GridsdtprofesionalespecialidadsedesRow);
         nGXsfl_169_idx = ((subGridsdtprofesionalespecialidadsedes_Islastpage==1)&&(nGXsfl_169_idx+1>subgridsdtprofesionalespecialidadsedes_fnc_recordsperpage( )) ? 1 : nGXsfl_169_idx+1) ;
         sGXsfl_169_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_169_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1692( ) ;
      }
      /* End function sendrow_1692 */
   }

   public void subsflControlProps_2358( )
   {
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONNOMBREINSTITUCION_"+sGXsfl_235_idx ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONPAISDESCRIPCION_"+sGXsfl_235_idx ;
      edtavSdtprofesionaleducacions__educaciondesde_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONDESDE_"+sGXsfl_235_idx ;
      edtavSdtprofesionaleducacions__educacionhasta_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONHASTA_"+sGXsfl_235_idx ;
   }

   public void subsflControlProps_fel_2358( )
   {
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONNOMBREINSTITUCION_"+sGXsfl_235_fel_idx ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONPAISDESCRIPCION_"+sGXsfl_235_fel_idx ;
      edtavSdtprofesionaleducacions__educaciondesde_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONDESDE_"+sGXsfl_235_fel_idx ;
      edtavSdtprofesionaleducacions__educacionhasta_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONHASTA_"+sGXsfl_235_fel_idx ;
   }

   public void sendrow_2358( )
   {
      subsflControlProps_2358( ) ;
      wb2Z0( ) ;
      if ( ( subGridsdtprofesionaleducacions_Rows * 1 == 0 ) || ( nGXsfl_235_idx <= subgridsdtprofesionaleducacions_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtprofesionaleducacionsRow = GXWebRow.GetNew(context,GridsdtprofesionaleducacionsContainer) ;
         if ( subGridsdtprofesionaleducacions_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtprofesionaleducacions_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtprofesionaleducacions_Class, "") != 0 )
            {
               subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"Odd" ;
            }
         }
         else if ( subGridsdtprofesionaleducacions_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtprofesionaleducacions_Backstyle = (byte)(0) ;
            subGridsdtprofesionaleducacions_Backcolor = subGridsdtprofesionaleducacions_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtprofesionaleducacions_Class, "") != 0 )
            {
               subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtprofesionaleducacions_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtprofesionaleducacions_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtprofesionaleducacions_Class, "") != 0 )
            {
               subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"Odd" ;
            }
            subGridsdtprofesionaleducacions_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtprofesionaleducacions_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtprofesionaleducacions_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_235_idx) % (2))) == 0 )
            {
               subGridsdtprofesionaleducacions_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionaleducacions_Class, "") != 0 )
               {
                  subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtprofesionaleducacions_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionaleducacions_Class, "") != 0 )
               {
                  subGridsdtprofesionaleducacions_Linesclass = subGridsdtprofesionaleducacions_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_235_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)).getgxTv_SdtSDTProfesionalEducacion_Educacionnombreinstitucion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educacionnombreinstitucion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname,((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)).getgxTv_SdtSDTProfesionalEducacion_Educacionpaisdescripcion(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educacionpaisdescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(200),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educaciondesde_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)).getgxTv_SdtSDTProfesionalEducacion_Educaciondesde(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)).getgxTv_SdtSDTProfesionalEducacion_Educaciondesde(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educaciondesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educaciondesde_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionaleducacionsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionaleducacionsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionaleducacions__educacionhasta_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)).getgxTv_SdtSDTProfesionalEducacion_Educacionhasta(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalEducacion)AV58SDTProfesionalEducacions.elementAt(-1+AV82GXV6)).getgxTv_SdtSDTProfesionalEducacion_Educacionhasta(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionaleducacions__educacionhasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionaleducacions__educacionhasta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(235),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2Z8( ) ;
         GridsdtprofesionaleducacionsContainer.AddRow(GridsdtprofesionaleducacionsRow);
         nGXsfl_235_idx = ((subGridsdtprofesionaleducacions_Islastpage==1)&&(nGXsfl_235_idx+1>subgridsdtprofesionaleducacions_fnc_recordsperpage( )) ? 1 : nGXsfl_235_idx+1) ;
         sGXsfl_235_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_235_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2358( ) ;
      }
      /* End function sendrow_2358 */
   }

   public void subsflControlProps_2927( )
   {
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_292_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALDESDE_"+sGXsfl_292_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALHASTA_"+sGXsfl_292_idx ;
   }

   public void subsflControlProps_fel_2927( )
   {
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALEMPRESANOMBRE_"+sGXsfl_292_fel_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALDESDE_"+sGXsfl_292_fel_idx ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALHASTA_"+sGXsfl_292_fel_idx ;
   }

   public void sendrow_2927( )
   {
      subsflControlProps_2927( ) ;
      wb2Z0( ) ;
      if ( ( subGridsdtprofesionalexperiencialaborals_Rows * 1 == 0 ) || ( nGXsfl_292_idx <= subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtprofesionalexperiencialaboralsRow = GXWebRow.GetNew(context,GridsdtprofesionalexperiencialaboralsContainer) ;
         if ( subGridsdtprofesionalexperiencialaborals_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtprofesionalexperiencialaborals_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtprofesionalexperiencialaborals_Class, "") != 0 )
            {
               subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"Odd" ;
            }
         }
         else if ( subGridsdtprofesionalexperiencialaborals_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtprofesionalexperiencialaborals_Backstyle = (byte)(0) ;
            subGridsdtprofesionalexperiencialaborals_Backcolor = subGridsdtprofesionalexperiencialaborals_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtprofesionalexperiencialaborals_Class, "") != 0 )
            {
               subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtprofesionalexperiencialaborals_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtprofesionalexperiencialaborals_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtprofesionalexperiencialaborals_Class, "") != 0 )
            {
               subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"Odd" ;
            }
            subGridsdtprofesionalexperiencialaborals_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtprofesionalexperiencialaborals_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtprofesionalexperiencialaborals_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_292_idx) % (2))) == 0 )
            {
               subGridsdtprofesionalexperiencialaborals_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalexperiencialaborals_Class, "") != 0 )
               {
                  subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtprofesionalexperiencialaborals_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalexperiencialaborals_Class, "") != 0 )
               {
                  subGridsdtprofesionalexperiencialaborals_Linesclass = subGridsdtprofesionalexperiencialaborals_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_292_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalexperiencialaboralsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname,((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralempresanombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(292),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalexperiencialaboralsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboraldesde(), "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(292),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalexperiencialaboralsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalexperiencialaboralsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta(), "99/99/9999"),localUtil.format( ((com.projectthani.SdtSDTProfesionalExperienciaLaboral)AV60SDTProfesionalExperienciaLaborals.elementAt(-1+AV87GXV11)).getgxTv_SdtSDTProfesionalExperienciaLaboral_Experiencialaboralhasta(), "99/99/9999"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(292),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2Z7( ) ;
         GridsdtprofesionalexperiencialaboralsContainer.AddRow(GridsdtprofesionalexperiencialaboralsRow);
         nGXsfl_292_idx = ((subGridsdtprofesionalexperiencialaborals_Islastpage==1)&&(nGXsfl_292_idx+1>subgridsdtprofesionalexperiencialaborals_fnc_recordsperpage( )) ? 1 : nGXsfl_292_idx+1) ;
         sGXsfl_292_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_292_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_2927( ) ;
      }
      /* End function sendrow_2927 */
   }

   public void subsflControlProps_3486( )
   {
      edtavSdtprofesionalpremioss__premiosnombre_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSNOMBRE_"+sGXsfl_348_idx ;
      edtavSdtprofesionalpremioss__premiosfecha_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSFECHA_"+sGXsfl_348_idx ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSDESCRIPCION_"+sGXsfl_348_idx ;
   }

   public void subsflControlProps_fel_3486( )
   {
      edtavSdtprofesionalpremioss__premiosnombre_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSNOMBRE_"+sGXsfl_348_fel_idx ;
      edtavSdtprofesionalpremioss__premiosfecha_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSFECHA_"+sGXsfl_348_fel_idx ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSDESCRIPCION_"+sGXsfl_348_fel_idx ;
   }

   public void sendrow_3486( )
   {
      subsflControlProps_3486( ) ;
      wb2Z0( ) ;
      if ( ( subGridsdtprofesionalpremioss_Rows * 1 == 0 ) || ( nGXsfl_348_idx <= subgridsdtprofesionalpremioss_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtprofesionalpremiossRow = GXWebRow.GetNew(context,GridsdtprofesionalpremiossContainer) ;
         if ( subGridsdtprofesionalpremioss_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtprofesionalpremioss_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtprofesionalpremioss_Class, "") != 0 )
            {
               subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"Odd" ;
            }
         }
         else if ( subGridsdtprofesionalpremioss_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtprofesionalpremioss_Backstyle = (byte)(0) ;
            subGridsdtprofesionalpremioss_Backcolor = subGridsdtprofesionalpremioss_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtprofesionalpremioss_Class, "") != 0 )
            {
               subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtprofesionalpremioss_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtprofesionalpremioss_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtprofesionalpremioss_Class, "") != 0 )
            {
               subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"Odd" ;
            }
            subGridsdtprofesionalpremioss_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtprofesionalpremioss_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtprofesionalpremioss_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_348_idx) % (2))) == 0 )
            {
               subGridsdtprofesionalpremioss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalpremioss_Class, "") != 0 )
               {
                  subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtprofesionalpremioss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalpremioss_Class, "") != 0 )
               {
                  subGridsdtprofesionalpremioss_Linesclass = subGridsdtprofesionalpremioss_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_348_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalpremiossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalpremioss__premiosnombre_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)).getgxTv_SdtSDTProfesionalPremios_Premiosnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalpremioss__premiosnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalpremioss__premiosnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(500),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(348),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalpremiossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalpremioss__premiosfecha_Internalname,localUtil.format(((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)).getgxTv_SdtSDTProfesionalPremios_Premiosfecha(), "99/99/99"),localUtil.format( ((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)).getgxTv_SdtSDTProfesionalPremios_Premiosfecha(), "99/99/99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalpremioss__premiosfecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalpremioss__premiosfecha_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(348),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsdtprofesionalpremiossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalpremiossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalpremioss__premiosdescripcion_Internalname,((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)).getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion(),((com.projectthani.SdtSDTProfesionalPremios)AV62SDTProfesionalPremioss.elementAt(-1+AV91GXV15)).getgxTv_SdtSDTProfesionalPremios_Premiosdescripcion(),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalpremioss__premiosdescripcion_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalpremioss__premiosdescripcion_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(348),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes2Z6( ) ;
         GridsdtprofesionalpremiossContainer.AddRow(GridsdtprofesionalpremiossRow);
         nGXsfl_348_idx = ((subGridsdtprofesionalpremioss_Islastpage==1)&&(nGXsfl_348_idx+1>subgridsdtprofesionalpremioss_fnc_recordsperpage( )) ? 1 : nGXsfl_348_idx+1) ;
         sGXsfl_348_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_348_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_3486( ) ;
      }
      /* End function sendrow_3486 */
   }

   public void subsflControlProps_3865( )
   {
      edtavSdtprofesionalservicioss__serviciosnombre_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSNOMBRE_"+sGXsfl_386_idx ;
   }

   public void subsflControlProps_fel_3865( )
   {
      edtavSdtprofesionalservicioss__serviciosnombre_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSNOMBRE_"+sGXsfl_386_fel_idx ;
   }

   public void sendrow_3865( )
   {
      subsflControlProps_3865( ) ;
      wb2Z0( ) ;
      if ( ( subGridsdtprofesionalservicioss_Rows * 1 == 0 ) || ( nGXsfl_386_idx <= subgridsdtprofesionalservicioss_fnc_recordsperpage( ) * 1 ) )
      {
         GridsdtprofesionalserviciossRow = GXWebRow.GetNew(context,GridsdtprofesionalserviciossContainer) ;
         if ( subGridsdtprofesionalservicioss_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdtprofesionalservicioss_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdtprofesionalservicioss_Class, "") != 0 )
            {
               subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"Odd" ;
            }
         }
         else if ( subGridsdtprofesionalservicioss_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdtprofesionalservicioss_Backstyle = (byte)(0) ;
            subGridsdtprofesionalservicioss_Backcolor = subGridsdtprofesionalservicioss_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdtprofesionalservicioss_Class, "") != 0 )
            {
               subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"Uniform" ;
            }
         }
         else if ( subGridsdtprofesionalservicioss_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdtprofesionalservicioss_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdtprofesionalservicioss_Class, "") != 0 )
            {
               subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"Odd" ;
            }
            subGridsdtprofesionalservicioss_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdtprofesionalservicioss_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdtprofesionalservicioss_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_386_idx) % (2))) == 0 )
            {
               subGridsdtprofesionalservicioss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalservicioss_Class, "") != 0 )
               {
                  subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"Even" ;
               }
            }
            else
            {
               subGridsdtprofesionalservicioss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdtprofesionalservicioss_Class, "") != 0 )
               {
                  subGridsdtprofesionalservicioss_Linesclass = subGridsdtprofesionalservicioss_Class+"Odd" ;
               }
            }
         }
         if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar GridNoBorder WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_386_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsdtprofesionalserviciossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridsdtprofesionalserviciossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdtprofesionalservicioss__serviciosnombre_Internalname,((com.projectthani.SdtSDTProfesionalServicios)AV63SDTProfesionalServicioss.elementAt(-1+AV95GXV19)).getgxTv_SdtSDTProfesionalServicios_Serviciosnombre(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdtprofesionalservicioss__serviciosnombre_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdtprofesionalservicioss__serviciosnombre_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(300),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(386),Integer.valueOf(1),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes2Z5( ) ;
         GridsdtprofesionalserviciossContainer.AddRow(GridsdtprofesionalserviciossRow);
         nGXsfl_386_idx = ((subGridsdtprofesionalservicioss_Islastpage==1)&&(nGXsfl_386_idx+1>subgridsdtprofesionalservicioss_fnc_recordsperpage( )) ? 1 : nGXsfl_386_idx+1) ;
         sGXsfl_386_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_386_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_3865( ) ;
      }
      /* End function sendrow_3865 */
   }

   public void init_default_properties( )
   {
      lblTabgeneral_title_Internalname = "TABGENERAL_TITLE" ;
      cmbavProfesionaltipodocumento.setInternalname( "vPROFESIONALTIPODOCUMENTO" );
      edtavProfesionalnrodocumento_Internalname = "vPROFESIONALNRODOCUMENTO" ;
      edtavProfesionalnombres_Internalname = "vPROFESIONALNOMBRES" ;
      edtavProfesionalapellidomaterno_Internalname = "vPROFESIONALAPELLIDOMATERNO" ;
      edtavProfesionalapellidopaterno_Internalname = "vPROFESIONALAPELLIDOPATERNO" ;
      edtavProfesionalfechanacimiento_Internalname = "vPROFESIONALFECHANACIMIENTO" ;
      cmbavProfesionalsexo.setInternalname( "vPROFESIONALSEXO" );
      edtavProfesionalcop_Internalname = "vPROFESIONALCOP" ;
      edtavProfesionaltelefono_Internalname = "vPROFESIONALTELEFONO" ;
      edtavProfesionaldescripcion_Internalname = "vPROFESIONALDESCRIPCION" ;
      cmbavProfesionaltiempocita.setInternalname( "vPROFESIONALTIEMPOCITA" );
      dynavPaisid.setInternalname( "vPAISID" );
      divInformaciongeneral_Internalname = "INFORMACIONGENERAL" ;
      grpUnnamedgroup7_Internalname = "UNNAMEDGROUP7" ;
      cmbavUbigeodepartamento.setInternalname( "vUBIGEODEPARTAMENTO" );
      dynavUbigeoprovincia.setInternalname( "vUBIGEOPROVINCIA" );
      dynavUbigeodistrito.setInternalname( "vUBIGEODISTRITO" );
      edtavProfesionaldireccion_Internalname = "vPROFESIONALDIRECCION" ;
      divUbicacion_Internalname = "UBICACION" ;
      grpUnnamedgroup8_Internalname = "UNNAMEDGROUP8" ;
      imgavProfesionalfoto_Internalname = "vPROFESIONALFOTO" ;
      Subirfotografia_Internalname = "SUBIRFOTOGRAFIA" ;
      divImagenperfil_Internalname = "IMAGENPERFIL" ;
      grpUnnamedgroup9_Internalname = "UNNAMEDGROUP9" ;
      edtavProfesionalcorreo_Internalname = "vPROFESIONALCORREO" ;
      edtavProfesionalpassword_Internalname = "vPROFESIONALPASSWORD" ;
      divInfocuenta_Internalname = "INFOCUENTA" ;
      grpUnnamedgroup10_Internalname = "UNNAMEDGROUP10" ;
      bttBtnbtnactualizarregistro_Internalname = "BTNBTNACTUALIZARREGISTRO" ;
      bttBtnbtnguardardatosactualizados_Internalname = "BTNBTNGUARDARDATOSACTUALIZADOS" ;
      divUnnamedtable6_Internalname = "UNNAMEDTABLE6" ;
      lblTabespecialidad_title_Internalname = "TABESPECIALIDAD_TITLE" ;
      lblTextblockespecialidadnombreid_Internalname = "TEXTBLOCKESPECIALIDADNOMBREID" ;
      dynavEspecialidadnombreid.setInternalname( "vESPECIALIDADNOMBREID" );
      divUnnamedtableespecialidadnombreid_Internalname = "UNNAMEDTABLEESPECIALIDADNOMBREID" ;
      lblTextblockespecialidadtipoconsulta_Internalname = "TEXTBLOCKESPECIALIDADTIPOCONSULTA" ;
      cmbavEspecialidadtipoconsulta.setInternalname( "vESPECIALIDADTIPOCONSULTA" );
      divUnnamedtableespecialidadtipoconsulta_Internalname = "UNNAMEDTABLEESPECIALIDADTIPOCONSULTA" ;
      bttBtnbtnaddespecialidad_Internalname = "BTNBTNADDESPECIALIDAD" ;
      tblPanelregespe_Internalname = "PANELREGESPE" ;
      Dvpanel_panelregespe_Internalname = "DVPANEL_PANELREGESPE" ;
      edtavSdtprofesionalespecialidadsedes__especialidadid_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADID" ;
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADCODIGO" ;
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname = "SDTPROFESIONALESPECIALIDADSEDES__ESPECIALIDADNOMBRE" ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setInternalname( "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA" );
      Gridsdtprofesionalespecialidadsedespaginationbar_Internalname = "GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR" ;
      divGridsdtprofesionalespecialidadsedestablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALESPECIALIDADSEDESTABLEWITHPAGINATIONBAR" ;
      tblPanellistespe_Internalname = "PANELLISTESPE" ;
      Dvpanel_panellistespe_Internalname = "DVPANEL_PANELLISTESPE" ;
      divUnnamedtable5_Internalname = "UNNAMEDTABLE5" ;
      lblTabeducacion_title_Internalname = "TABEDUCACION_TITLE" ;
      lblTextblockeducacionprofesionalnombreinstitucion_Internalname = "TEXTBLOCKEDUCACIONPROFESIONALNOMBREINSTITUCION" ;
      edtavEducacionprofesionalnombreinstitucion_Internalname = "vEDUCACIONPROFESIONALNOMBREINSTITUCION" ;
      divUnnamedtableeducacionprofesionalnombreinstitucion_Internalname = "UNNAMEDTABLEEDUCACIONPROFESIONALNOMBREINSTITUCION" ;
      lblTextblockeducacionprofesionalpais_Internalname = "TEXTBLOCKEDUCACIONPROFESIONALPAIS" ;
      edtavEducacionprofesionalpais_Internalname = "vEDUCACIONPROFESIONALPAIS" ;
      divUnnamedtableeducacionprofesionalpais_Internalname = "UNNAMEDTABLEEDUCACIONPROFESIONALPAIS" ;
      lblTextblockeducacionprofesionaldesde_Internalname = "TEXTBLOCKEDUCACIONPROFESIONALDESDE" ;
      edtavEducacionprofesionaldesde_Internalname = "vEDUCACIONPROFESIONALDESDE" ;
      divUnnamedtableeducacionprofesionaldesde_Internalname = "UNNAMEDTABLEEDUCACIONPROFESIONALDESDE" ;
      lblTextblockeducacionprofesionalhasta_Internalname = "TEXTBLOCKEDUCACIONPROFESIONALHASTA" ;
      edtavEducacionprofesionalhasta_Internalname = "vEDUCACIONPROFESIONALHASTA" ;
      divUnnamedtableeducacionprofesionalhasta_Internalname = "UNNAMEDTABLEEDUCACIONPROFESIONALHASTA" ;
      bttBtnbtnaddeducacion_Internalname = "BTNBTNADDEDUCACION" ;
      tblPaneleducacion_Internalname = "PANELEDUCACION" ;
      Dvpanel_paneleducacion_Internalname = "DVPANEL_PANELEDUCACION" ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONNOMBREINSTITUCION" ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONPAISDESCRIPCION" ;
      edtavSdtprofesionaleducacions__educaciondesde_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONDESDE" ;
      edtavSdtprofesionaleducacions__educacionhasta_Internalname = "SDTPROFESIONALEDUCACIONS__EDUCACIONHASTA" ;
      Gridsdtprofesionaleducacionspaginationbar_Internalname = "GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR" ;
      divGridsdtprofesionaleducacionstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALEDUCACIONSTABLEWITHPAGINATIONBAR" ;
      tblPaneleducacionlist_Internalname = "PANELEDUCACIONLIST" ;
      Dvpanel_paneleducacionlist_Internalname = "DVPANEL_PANELEDUCACIONLIST" ;
      divUnnamedtable4_Internalname = "UNNAMEDTABLE4" ;
      lblTabexperiencialaboral_title_Internalname = "TABEXPERIENCIALABORAL_TITLE" ;
      lblTextblockexperiencialaboralempresanombre_Internalname = "TEXTBLOCKEXPERIENCIALABORALEMPRESANOMBRE" ;
      edtavExperiencialaboralempresanombre_Internalname = "vEXPERIENCIALABORALEMPRESANOMBRE" ;
      divUnnamedtableexperiencialaboralempresanombre_Internalname = "UNNAMEDTABLEEXPERIENCIALABORALEMPRESANOMBRE" ;
      lblTextblockexperiencialaboraldesde_Internalname = "TEXTBLOCKEXPERIENCIALABORALDESDE" ;
      edtavExperiencialaboraldesde_Internalname = "vEXPERIENCIALABORALDESDE" ;
      divUnnamedtableexperiencialaboraldesde_Internalname = "UNNAMEDTABLEEXPERIENCIALABORALDESDE" ;
      lblTextblockexperiencialaboralhasta_Internalname = "TEXTBLOCKEXPERIENCIALABORALHASTA" ;
      edtavExperiencialaboralhasta_Internalname = "vEXPERIENCIALABORALHASTA" ;
      divUnnamedtableexperiencialaboralhasta_Internalname = "UNNAMEDTABLEEXPERIENCIALABORALHASTA" ;
      bttBtnbtnaddexperiencialaboral_Internalname = "BTNBTNADDEXPERIENCIALABORAL" ;
      tblPanelexperiencialaboral_Internalname = "PANELEXPERIENCIALABORAL" ;
      Dvpanel_panelexperiencialaboral_Internalname = "DVPANEL_PANELEXPERIENCIALABORAL" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALEMPRESANOMBRE" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALDESDE" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname = "SDTPROFESIONALEXPERIENCIALABORALS__EXPERIENCIALABORALHASTA" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Internalname = "GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR" ;
      divGridsdtprofesionalexperiencialaboralstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALEXPERIENCIALABORALSTABLEWITHPAGINATIONBAR" ;
      tblPanelexperiencialaborallist_Internalname = "PANELEXPERIENCIALABORALLIST" ;
      Dvpanel_panelexperiencialaborallist_Internalname = "DVPANEL_PANELEXPERIENCIALABORALLIST" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      lblTabpremioslogros_title_Internalname = "TABPREMIOSLOGROS_TITLE" ;
      lblTextblockpremiosnombre_Internalname = "TEXTBLOCKPREMIOSNOMBRE" ;
      edtavPremiosnombre_Internalname = "vPREMIOSNOMBRE" ;
      divUnnamedtablepremiosnombre_Internalname = "UNNAMEDTABLEPREMIOSNOMBRE" ;
      lblTextblockpremiosdescripcion_Internalname = "TEXTBLOCKPREMIOSDESCRIPCION" ;
      edtavPremiosdescripcion_Internalname = "vPREMIOSDESCRIPCION" ;
      divUnnamedtablepremiosdescripcion_Internalname = "UNNAMEDTABLEPREMIOSDESCRIPCION" ;
      lblTextblockpremiosfecha_Internalname = "TEXTBLOCKPREMIOSFECHA" ;
      edtavPremiosfecha_Internalname = "vPREMIOSFECHA" ;
      divUnnamedtablepremiosfecha_Internalname = "UNNAMEDTABLEPREMIOSFECHA" ;
      bttBtnbtnaddpremioslogros_Internalname = "BTNBTNADDPREMIOSLOGROS" ;
      tblPanelpremioslogros_Internalname = "PANELPREMIOSLOGROS" ;
      Dvpanel_panelpremioslogros_Internalname = "DVPANEL_PANELPREMIOSLOGROS" ;
      edtavSdtprofesionalpremioss__premiosnombre_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSNOMBRE" ;
      edtavSdtprofesionalpremioss__premiosfecha_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSFECHA" ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Internalname = "SDTPROFESIONALPREMIOSS__PREMIOSDESCRIPCION" ;
      Gridsdtprofesionalpremiosspaginationbar_Internalname = "GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR" ;
      divGridsdtprofesionalpremiosstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALPREMIOSSTABLEWITHPAGINATIONBAR" ;
      tblPanelpremioslogroslist_Internalname = "PANELPREMIOSLOGROSLIST" ;
      Dvpanel_panelpremioslogroslist_Internalname = "DVPANEL_PANELPREMIOSLOGROSLIST" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      lblTabservicios_title_Internalname = "TABSERVICIOS_TITLE" ;
      lblTextblockserviciosnombre_Internalname = "TEXTBLOCKSERVICIOSNOMBRE" ;
      edtavServiciosnombre_Internalname = "vSERVICIOSNOMBRE" ;
      divUnnamedtableserviciosnombre_Internalname = "UNNAMEDTABLESERVICIOSNOMBRE" ;
      bttBtnbtnaddservicios_Internalname = "BTNBTNADDSERVICIOS" ;
      tblPanelservicios_Internalname = "PANELSERVICIOS" ;
      Dvpanel_panelservicios_Internalname = "DVPANEL_PANELSERVICIOS" ;
      edtavSdtprofesionalservicioss__serviciosnombre_Internalname = "SDTPROFESIONALSERVICIOSS__SERVICIOSNOMBRE" ;
      Gridsdtprofesionalserviciosspaginationbar_Internalname = "GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR" ;
      divGridsdtprofesionalserviciosstablewithpaginationbar_Internalname = "GRIDSDTPROFESIONALSERVICIOSSTABLEWITHPAGINATIONBAR" ;
      tblPanelservicioslist_Internalname = "PANELSERVICIOSLIST" ;
      Dvpanel_panelservicioslist_Internalname = "DVPANEL_PANELSERVICIOSLIST" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Gxuitabspanel_tabinformacionpaciente_Internalname = "GXUITABSPANEL_TABINFORMACIONPACIENTE" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Gridsdtprofesionalservicioss_empowerer_Internalname = "GRIDSDTPROFESIONALSERVICIOSS_EMPOWERER" ;
      Gridsdtprofesionalpremioss_empowerer_Internalname = "GRIDSDTPROFESIONALPREMIOSS_EMPOWERER" ;
      Gridsdtprofesionalexperiencialaborals_empowerer_Internalname = "GRIDSDTPROFESIONALEXPERIENCIALABORALS_EMPOWERER" ;
      Gridsdtprofesionaleducacions_empowerer_Internalname = "GRIDSDTPROFESIONALEDUCACIONS_EMPOWERER" ;
      Gridsdtprofesionalespecialidadsedes_empowerer_Internalname = "GRIDSDTPROFESIONALESPECIALIDADSEDES_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridsdtprofesionalespecialidadsedes_Internalname = "GRIDSDTPROFESIONALESPECIALIDADSEDES" ;
      subGridsdtprofesionaleducacions_Internalname = "GRIDSDTPROFESIONALEDUCACIONS" ;
      subGridsdtprofesionalexperiencialaborals_Internalname = "GRIDSDTPROFESIONALEXPERIENCIALABORALS" ;
      subGridsdtprofesionalpremioss_Internalname = "GRIDSDTPROFESIONALPREMIOSS" ;
      subGridsdtprofesionalservicioss_Internalname = "GRIDSDTPROFESIONALSERVICIOSS" ;
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
      edtavSdtprofesionalservicioss__serviciosnombre_Jsonclick = "" ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Jsonclick = "" ;
      edtavSdtprofesionalpremioss__premiosfecha_Jsonclick = "" ;
      edtavSdtprofesionalpremioss__premiosnombre_Jsonclick = "" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Jsonclick = "" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Jsonclick = "" ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educacionhasta_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educaciondesde_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Jsonclick = "" ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Jsonclick = "" ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setJsonclick( "" );
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Jsonclick = "" ;
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Jsonclick = "" ;
      edtavSdtprofesionalespecialidadsedes__especialidadid_Jsonclick = "" ;
      cmbavEspecialidadtipoconsulta.setJsonclick( "" );
      cmbavEspecialidadtipoconsulta.setEnabled( 1 );
      dynavEspecialidadnombreid.setJsonclick( "" );
      dynavEspecialidadnombreid.setEnabled( 1 );
      subGridsdtprofesionalespecialidadsedes_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalespecialidadsedes_Allowselection = (byte)(0) ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled = 0 ;
      edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled = 0 ;
      subGridsdtprofesionalespecialidadsedes_Header = "" ;
      subGridsdtprofesionalespecialidadsedes_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalespecialidadsedes_Backcolorstyle = (byte)(0) ;
      edtavEducacionprofesionalhasta_Jsonclick = "" ;
      edtavEducacionprofesionalhasta_Enabled = 1 ;
      edtavEducacionprofesionaldesde_Jsonclick = "" ;
      edtavEducacionprofesionaldesde_Enabled = 1 ;
      edtavEducacionprofesionalpais_Jsonclick = "" ;
      edtavEducacionprofesionalpais_Enabled = 1 ;
      edtavEducacionprofesionalnombreinstitucion_Enabled = 1 ;
      subGridsdtprofesionaleducacions_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionaleducacions_Allowselection = (byte)(0) ;
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      subGridsdtprofesionaleducacions_Header = "" ;
      subGridsdtprofesionaleducacions_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionaleducacions_Backcolorstyle = (byte)(0) ;
      edtavExperiencialaboralhasta_Jsonclick = "" ;
      edtavExperiencialaboralhasta_Enabled = 1 ;
      edtavExperiencialaboraldesde_Jsonclick = "" ;
      edtavExperiencialaboraldesde_Enabled = 1 ;
      edtavExperiencialaboralempresanombre_Enabled = 1 ;
      subGridsdtprofesionalexperiencialaborals_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalexperiencialaborals_Allowselection = (byte)(0) ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      subGridsdtprofesionalexperiencialaborals_Header = "" ;
      subGridsdtprofesionalexperiencialaborals_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalexperiencialaborals_Backcolorstyle = (byte)(0) ;
      edtavPremiosfecha_Jsonclick = "" ;
      edtavPremiosfecha_Enabled = 1 ;
      edtavPremiosdescripcion_Enabled = 1 ;
      edtavPremiosnombre_Enabled = 1 ;
      subGridsdtprofesionalpremioss_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalpremioss_Allowselection = (byte)(0) ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      subGridsdtprofesionalpremioss_Header = "" ;
      subGridsdtprofesionalpremioss_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalpremioss_Backcolorstyle = (byte)(0) ;
      edtavServiciosnombre_Jsonclick = "" ;
      edtavServiciosnombre_Enabled = 1 ;
      subGridsdtprofesionalservicioss_Allowcollapsing = (byte)(0) ;
      subGridsdtprofesionalservicioss_Allowselection = (byte)(0) ;
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = 0 ;
      subGridsdtprofesionalservicioss_Header = "" ;
      subGridsdtprofesionalservicioss_Class = "GridWithPaginationBar GridNoBorder WorkWith" ;
      subGridsdtprofesionalservicioss_Backcolorstyle = (byte)(0) ;
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = -1 ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = -1 ;
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = -1 ;
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = -1 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = -1 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = -1 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = -1 ;
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = -1 ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( -1 );
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = -1 ;
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled = -1 ;
      edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled = -1 ;
      bttBtnbtnguardardatosactualizados_Visible = 1 ;
      bttBtnbtnactualizarregistro_Visible = 1 ;
      edtavProfesionalpassword_Jsonclick = "" ;
      edtavProfesionalpassword_Enabled = 1 ;
      edtavProfesionalcorreo_Jsonclick = "" ;
      edtavProfesionalcorreo_Enabled = 1 ;
      Subirfotografia_Tooltiptext = "" ;
      edtavProfesionaldireccion_Enabled = 1 ;
      dynavUbigeodistrito.setJsonclick( "" );
      dynavUbigeodistrito.setEnabled( 1 );
      dynavUbigeoprovincia.setJsonclick( "" );
      dynavUbigeoprovincia.setEnabled( 1 );
      cmbavUbigeodepartamento.setJsonclick( "" );
      cmbavUbigeodepartamento.setEnabled( 1 );
      dynavPaisid.setJsonclick( "" );
      dynavPaisid.setEnabled( 1 );
      cmbavProfesionaltiempocita.setJsonclick( "" );
      cmbavProfesionaltiempocita.setEnabled( 1 );
      edtavProfesionaldescripcion_Enabled = 1 ;
      edtavProfesionaltelefono_Jsonclick = "" ;
      edtavProfesionaltelefono_Enabled = 1 ;
      edtavProfesionalcop_Jsonclick = "" ;
      edtavProfesionalcop_Enabled = 1 ;
      cmbavProfesionalsexo.setJsonclick( "" );
      cmbavProfesionalsexo.setEnabled( 1 );
      edtavProfesionalfechanacimiento_Jsonclick = "" ;
      edtavProfesionalfechanacimiento_Enabled = 1 ;
      edtavProfesionalapellidopaterno_Jsonclick = "" ;
      edtavProfesionalapellidopaterno_Enabled = 1 ;
      edtavProfesionalapellidomaterno_Jsonclick = "" ;
      edtavProfesionalapellidomaterno_Enabled = 1 ;
      edtavProfesionalnombres_Jsonclick = "" ;
      edtavProfesionalnombres_Enabled = 1 ;
      edtavProfesionalnrodocumento_Jsonclick = "" ;
      edtavProfesionalnrodocumento_Enabled = 1 ;
      cmbavProfesionaltipodocumento.setJsonclick( "" );
      cmbavProfesionaltipodocumento.setEnabled( 1 );
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Mi Perfil " );
      Gxuitabspanel_tabinformacionpaciente_Historymanagement = GXutil.toBoolean( 0) ;
      Gxuitabspanel_tabinformacionpaciente_Class = "" ;
      Gxuitabspanel_tabinformacionpaciente_Pagecount = 6 ;
      Dvpanel_panelservicioslist_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicioslist_Iconposition = "Right" ;
      Dvpanel_panelservicioslist_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicioslist_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicioslist_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelservicioslist_Title = "" ;
      Dvpanel_panelservicioslist_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelservicioslist_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelservicioslist_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicioslist_Width = "100%" ;
      Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsdtprofesionalserviciosspaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridsdtprofesionalserviciosspaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsdtprofesionalserviciosspaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalserviciosspaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition = "Left" ;
      Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsdtprofesionalserviciosspaginationbar_Pagestoshow = 5 ;
      Gridsdtprofesionalserviciosspaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalserviciosspaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalserviciosspaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalserviciosspaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalserviciosspaginationbar_Class = "PaginationBar" ;
      Dvpanel_panelservicios_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicios_Iconposition = "Right" ;
      Dvpanel_panelservicios_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicios_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicios_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelservicios_Title = "" ;
      Dvpanel_panelservicios_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelservicios_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelservicios_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelservicios_Width = "100%" ;
      Dvpanel_panelpremioslogroslist_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogroslist_Iconposition = "Right" ;
      Dvpanel_panelpremioslogroslist_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogroslist_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogroslist_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelpremioslogroslist_Title = "" ;
      Dvpanel_panelpremioslogroslist_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelpremioslogroslist_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelpremioslogroslist_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogroslist_Width = "100%" ;
      Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsdtprofesionalpremiosspaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridsdtprofesionalpremiosspaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsdtprofesionalpremiosspaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalpremiosspaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition = "Left" ;
      Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsdtprofesionalpremiosspaginationbar_Pagestoshow = 5 ;
      Gridsdtprofesionalpremiosspaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalpremiosspaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalpremiosspaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalpremiosspaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalpremiosspaginationbar_Class = "PaginationBar" ;
      Dvpanel_panelpremioslogros_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogros_Iconposition = "Right" ;
      Dvpanel_panelpremioslogros_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogros_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogros_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelpremioslogros_Title = "" ;
      Dvpanel_panelpremioslogros_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelpremioslogros_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelpremioslogros_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelpremioslogros_Width = "100%" ;
      Dvpanel_panelexperiencialaborallist_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaborallist_Iconposition = "Right" ;
      Dvpanel_panelexperiencialaborallist_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaborallist_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaborallist_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelexperiencialaborallist_Title = "" ;
      Dvpanel_panelexperiencialaborallist_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelexperiencialaborallist_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelexperiencialaborallist_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaborallist_Width = "100%" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition = "Left" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow = 5 ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Class = "PaginationBar" ;
      Dvpanel_panelexperiencialaboral_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaboral_Iconposition = "Right" ;
      Dvpanel_panelexperiencialaboral_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaboral_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaboral_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelexperiencialaboral_Title = "" ;
      Dvpanel_panelexperiencialaboral_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelexperiencialaboral_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelexperiencialaboral_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelexperiencialaboral_Width = "100%" ;
      Dvpanel_paneleducacionlist_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacionlist_Iconposition = "Right" ;
      Dvpanel_paneleducacionlist_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacionlist_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacionlist_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_paneleducacionlist_Title = "" ;
      Dvpanel_paneleducacionlist_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_paneleducacionlist_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_paneleducacionlist_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacionlist_Width = "100%" ;
      Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsdtprofesionaleducacionspaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridsdtprofesionaleducacionspaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsdtprofesionaleducacionspaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsdtprofesionaleducacionspaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition = "Left" ;
      Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsdtprofesionaleducacionspaginationbar_Pagestoshow = 5 ;
      Gridsdtprofesionaleducacionspaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsdtprofesionaleducacionspaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsdtprofesionaleducacionspaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsdtprofesionaleducacionspaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsdtprofesionaleducacionspaginationbar_Class = "PaginationBar" ;
      Dvpanel_paneleducacion_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacion_Iconposition = "Right" ;
      Dvpanel_paneleducacion_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacion_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacion_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_paneleducacion_Title = "" ;
      Dvpanel_paneleducacion_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_paneleducacion_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_paneleducacion_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_paneleducacion_Width = "100%" ;
      Dvpanel_panellistespe_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panellistespe_Iconposition = "Right" ;
      Dvpanel_panellistespe_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panellistespe_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panellistespe_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panellistespe_Title = "" ;
      Dvpanel_panellistespe_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panellistespe_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panellistespe_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panellistespe_Width = "100%" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Caption = "Página <CURRENT_PAGE> de <TOTAL_PAGES>" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition = "Left" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow = 5 ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Class = "PaginationBar" ;
      Dvpanel_panelregespe_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelregespe_Iconposition = "Right" ;
      Dvpanel_panelregespe_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelregespe_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelregespe_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelregespe_Title = "" ;
      Dvpanel_panelregespe_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelregespe_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelregespe_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelregespe_Width = "100%" ;
      Subirfotografia_Visible = GXutil.toBoolean( -1) ;
      Subirfotografia_Acceptedfiletypes = "image" ;
      Subirfotografia_Autodisableaddingfiles = GXutil.toBoolean( 0) ;
      Subirfotografia_Maxnumberoffiles = 1 ;
      Subirfotografia_Enableuploadedfilecanceling = GXutil.toBoolean( -1) ;
      Subirfotografia_Hideadditionalbuttons = GXutil.toBoolean( -1) ;
      Subirfotografia_Autoupload = GXutil.toBoolean( -1) ;
      Subirfotografia_Class = "" ;
      subGridsdtprofesionalservicioss_Rows = 0 ;
      subGridsdtprofesionalpremioss_Rows = 0 ;
      subGridsdtprofesionalexperiencialaborals_Rows = 0 ;
      subGridsdtprofesionaleducacions_Rows = 0 ;
      subGridsdtprofesionalespecialidadsedes_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavProfesionaltipodocumento.setName( "vPROFESIONALTIPODOCUMENTO" );
      cmbavProfesionaltipodocumento.setWebtags( "" );
      cmbavProfesionaltipodocumento.addItem("1", "DNI", (short)(0));
      cmbavProfesionaltipodocumento.addItem("6", "RUC", (short)(0));
      cmbavProfesionaltipodocumento.addItem("2", "LIBRETA ELECTORAL", (short)(0));
      cmbavProfesionaltipodocumento.addItem("4", "CARNET DE EXTRANJERIA", (short)(0));
      cmbavProfesionaltipodocumento.addItem("7", "PASAPORTE", (short)(0));
      cmbavProfesionaltipodocumento.addItem("0", "SIN DOCUMENTO", (short)(0));
      if ( cmbavProfesionaltipodocumento.getItemCount() > 0 )
      {
         AV56ProfesionalTipoDocumento = cmbavProfesionaltipodocumento.getValidValue(AV56ProfesionalTipoDocumento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV56ProfesionalTipoDocumento", AV56ProfesionalTipoDocumento);
      }
      cmbavProfesionalsexo.setName( "vPROFESIONALSEXO" );
      cmbavProfesionalsexo.setWebtags( "" );
      cmbavProfesionalsexo.addItem("M", "Masculino", (short)(0));
      cmbavProfesionalsexo.addItem("F", "Femenino", (short)(0));
      if ( cmbavProfesionalsexo.getItemCount() > 0 )
      {
         AV53ProfesionalSexo = cmbavProfesionalsexo.getValidValue(AV53ProfesionalSexo) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV53ProfesionalSexo", AV53ProfesionalSexo);
      }
      cmbavProfesionaltiempocita.setName( "vPROFESIONALTIEMPOCITA" );
      cmbavProfesionaltiempocita.setWebtags( "" );
      cmbavProfesionaltiempocita.addItem("30", "30 minutos", (short)(0));
      cmbavProfesionaltiempocita.addItem("60", "1 hora", (short)(0));
      if ( cmbavProfesionaltiempocita.getItemCount() > 0 )
      {
         AV55ProfesionalTiempoCita = (byte)(GXutil.lval( cmbavProfesionaltiempocita.getValidValue(GXutil.trim( GXutil.str( AV55ProfesionalTiempoCita, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV55ProfesionalTiempoCita", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV55ProfesionalTiempoCita), 2, 0));
      }
      dynavPaisid.setName( "vPAISID" );
      dynavPaisid.setWebtags( "" );
      dynavPaisid.removeAllItems();
      /* Using cursor H002Z10 */
      pr_default.execute(8);
      while ( (pr_default.getStatus(8) != 101) )
      {
         dynavPaisid.addItem(GXutil.trim( GXutil.str( H002Z10_A43PaisId[0], 4, 0)), H002Z10_A184PaisDescripcion[0], (short)(0));
         pr_default.readNext(8);
      }
      pr_default.close(8);
      if ( dynavPaisid.getItemCount() > 0 )
      {
         AV36PaisId = (short)(GXutil.lval( dynavPaisid.getValidValue(GXutil.trim( GXutil.str( AV36PaisId, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36PaisId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36PaisId), 4, 0));
      }
      cmbavUbigeodepartamento.setName( "vUBIGEODEPARTAMENTO" );
      cmbavUbigeodepartamento.setWebtags( "" );
      cmbavUbigeodepartamento.addItem("", "Seleccionar", (short)(0));
      if ( cmbavUbigeodepartamento.getItemCount() > 0 )
      {
         AV70UbigeoDepartamento = cmbavUbigeodepartamento.getValidValue(AV70UbigeoDepartamento) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV70UbigeoDepartamento", AV70UbigeoDepartamento);
      }
      dynavUbigeoprovincia.setName( "vUBIGEOPROVINCIA" );
      dynavUbigeoprovincia.setWebtags( "" );
      dynavUbigeodistrito.setName( "vUBIGEODISTRITO" );
      dynavUbigeodistrito.setWebtags( "" );
      dynavEspecialidadnombreid.setName( "vESPECIALIDADNOMBREID" );
      dynavEspecialidadnombreid.setWebtags( "" );
      cmbavEspecialidadtipoconsulta.setName( "vESPECIALIDADTIPOCONSULTA" );
      cmbavEspecialidadtipoconsulta.setWebtags( "" );
      cmbavEspecialidadtipoconsulta.addItem("", "Seleccione tipo de consulta", (short)(0));
      cmbavEspecialidadtipoconsulta.addItem("V", "Virtual", (short)(0));
      cmbavEspecialidadtipoconsulta.addItem("P", "En consultorio", (short)(0));
      cmbavEspecialidadtipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbavEspecialidadtipoconsulta.getItemCount() > 0 )
      {
         AV16EspecialidadTipoConsulta = cmbavEspecialidadtipoconsulta.getValidValue(AV16EspecialidadTipoConsulta) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16EspecialidadTipoConsulta", AV16EspecialidadTipoConsulta);
      }
      GXCCtl = "SDTPROFESIONALESPECIALIDADSEDES__SEDETIPOCONSULTA_" + sGXsfl_169_idx ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setName( GXCCtl );
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setWebtags( "" );
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("", "Seleccione tipo de consulta", (short)(0));
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("V", "Virtual", (short)(0));
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("P", "En consultorio", (short)(0));
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.addItem("D", "Visita a domicilio", (short)(0));
      if ( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getItemCount() > 0 )
      {
         if ( ( AV77GXV1 > 0 ) && ( AV59SDTProfesionalEspecialidadSedes.size() >= AV77GXV1 ) && (GXutil.strcmp("", ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta())==0) )
         {
            ((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).setgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta( cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.getValidValue(((com.projectthani.SdtSDTProfesionalEspecialidadSede)AV59SDTProfesionalEspecialidadSedes.elementAt(-1+AV77GXV1)).getgxTv_SdtSDTProfesionalEspecialidadSede_Sedetipoconsulta()) );
         }
      }
      /* End function init_web_controls */
   }

   public void validv_Ubigeodepartamento( )
   {
      AV70UbigeoDepartamento = cmbavUbigeodepartamento.getValue() ;
      AV72UbigeoProvincia = dynavUbigeoprovincia.getValue() ;
      AV71UbigeoDistrito = dynavUbigeodistrito.getValue() ;
      AV15EspecialidadNombreId = (short)(GXutil.lval( dynavEspecialidadnombreid.getValue())) ;
      AV36PaisId = (short)(GXutil.lval( dynavPaisid.getValue())) ;
      gxvvubigeoprovincia_html2Z2( AV70UbigeoDepartamento) ;
      gxvvubigeodistrito_html2Z2( AV70UbigeoDepartamento, AV72UbigeoProvincia) ;
      dynload_actions( ) ;
      if ( dynavUbigeoprovincia.getItemCount() > 0 )
      {
         AV72UbigeoProvincia = dynavUbigeoprovincia.getValidValue(AV72UbigeoProvincia) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavUbigeoprovincia.setValue( GXutil.rtrim( AV72UbigeoProvincia) );
      }
      if ( dynavUbigeodistrito.getItemCount() > 0 )
      {
         AV71UbigeoDistrito = dynavUbigeodistrito.getValidValue(AV71UbigeoDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavUbigeodistrito.setValue( GXutil.rtrim( AV71UbigeoDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV72UbigeoProvincia", AV72UbigeoProvincia);
      dynavUbigeoprovincia.setValue( GXutil.rtrim( AV72UbigeoProvincia) );
      httpContext.ajax_rsp_assign_prop("", false, dynavUbigeoprovincia.getInternalname(), "Values", dynavUbigeoprovincia.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV71UbigeoDistrito", AV71UbigeoDistrito);
      dynavUbigeodistrito.setValue( GXutil.rtrim( AV71UbigeoDistrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavUbigeodistrito.getInternalname(), "Values", dynavUbigeodistrito.ToJavascriptSource(), true);
   }

   public void validv_Ubigeoprovincia( )
   {
      AV70UbigeoDepartamento = cmbavUbigeodepartamento.getValue() ;
      AV72UbigeoProvincia = dynavUbigeoprovincia.getValue() ;
      AV71UbigeoDistrito = dynavUbigeodistrito.getValue() ;
      AV15EspecialidadNombreId = (short)(GXutil.lval( dynavEspecialidadnombreid.getValue())) ;
      AV36PaisId = (short)(GXutil.lval( dynavPaisid.getValue())) ;
      gxvvubigeodistrito_html2Z2( AV70UbigeoDepartamento, AV72UbigeoProvincia) ;
      dynload_actions( ) ;
      if ( dynavUbigeodistrito.getItemCount() > 0 )
      {
         AV71UbigeoDistrito = dynavUbigeodistrito.getValidValue(AV71UbigeoDistrito) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavUbigeodistrito.setValue( GXutil.rtrim( AV71UbigeoDistrito) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV71UbigeoDistrito", AV71UbigeoDistrito);
      dynavUbigeodistrito.setValue( GXutil.rtrim( AV71UbigeoDistrito) );
      httpContext.ajax_rsp_assign_prop("", false, dynavUbigeodistrito.getInternalname(), "Values", dynavUbigeodistrito.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF'},{av:'AV59SDTProfesionalEspecialidadSedes',fld:'vSDTPROFESIONALESPECIALIDADSEDES',grid:169,pic:''},{av:'nRC_GXsfl_169',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'GridRC',grid:169},{av:'GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALSERVICIOSS_nEOF'},{av:'AV63SDTProfesionalServicioss',fld:'vSDTPROFESIONALSERVICIOSS',grid:386,pic:''},{av:'nRC_GXsfl_386',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'GridRC',grid:386},{av:'GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALPREMIOSS_nEOF'},{av:'AV62SDTProfesionalPremioss',fld:'vSDTPROFESIONALPREMIOSS',grid:348,pic:''},{av:'nRC_GXsfl_348',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'GridRC',grid:348},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF'},{av:'AV60SDTProfesionalExperienciaLaborals',fld:'vSDTPROFESIONALEXPERIENCIALABORALS',grid:292,pic:''},{av:'nRC_GXsfl_292',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'GridRC',grid:292},{av:'GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEDUCACIONS_nEOF'},{av:'AV58SDTProfesionalEducacions',fld:'vSDTPROFESIONALEDUCACIONS',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'GridRC',grid:235},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV31GridSDTProfesionalServiciossCurrentPage',fld:'vGRIDSDTPROFESIONALSERVICIOSSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV32GridSDTProfesionalServiciossPageCount',fld:'vGRIDSDTPROFESIONALSERVICIOSSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV29GridSDTProfesionalPremiossCurrentPage',fld:'vGRIDSDTPROFESIONALPREMIOSSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV30GridSDTProfesionalPremiossPageCount',fld:'vGRIDSDTPROFESIONALPREMIOSSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV27GridSDTProfesionalExperienciaLaboralsCurrentPage',fld:'vGRIDSDTPROFESIONALEXPERIENCIALABORALSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV28GridSDTProfesionalExperienciaLaboralsPageCount',fld:'vGRIDSDTPROFESIONALEXPERIENCIALABORALSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV23GridSDTProfesionalEducacionsCurrentPage',fld:'vGRIDSDTPROFESIONALEDUCACIONSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV24GridSDTProfesionalEducacionsPageCount',fld:'vGRIDSDTPROFESIONALEDUCACIONSPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'AV25GridSDTProfesionalEspecialidadSedesCurrentPage',fld:'vGRIDSDTPROFESIONALESPECIALIDADSEDESCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV26GridSDTProfesionalEspecialidadSedesPageCount',fld:'vGRIDSDTPROFESIONALESPECIALIDADSEDESPAGECOUNT',pic:'ZZZZZZZZZ9'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSS.LOAD","{handler:'e342Z5',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSS.LOAD",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSS.LOAD","{handler:'e332Z6',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSS.LOAD",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALS.LOAD","{handler:'e322Z7',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALS.LOAD",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONS.LOAD","{handler:'e312Z8',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONS.LOAD",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD","{handler:'e302Z2',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDES.LOAD",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEPAGE","{handler:'e202Z2',iparms:[{av:'GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALSERVICIOSS_nEOF'},{av:'AV63SDTProfesionalServicioss',fld:'vSDTPROFESIONALSERVICIOSS',grid:386,pic:''},{av:'nRC_GXsfl_386',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'GridRC',grid:386},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalserviciosspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR',prop:'SelectedPage'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e212Z2',iparms:[{av:'GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALSERVICIOSS_nEOF'},{av:'AV63SDTProfesionalServicioss',fld:'vSDTPROFESIONALSERVICIOSS',grid:386,pic:''},{av:'nRC_GXsfl_386',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'GridRC',grid:386},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALSERVICIOSSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEPAGE","{handler:'e182Z2',iparms:[{av:'GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALPREMIOSS_nEOF'},{av:'AV62SDTProfesionalPremioss',fld:'vSDTPROFESIONALPREMIOSS',grid:348,pic:''},{av:'nRC_GXsfl_348',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'GridRC',grid:348},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalpremiosspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR',prop:'SelectedPage'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e192Z2',iparms:[{av:'GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALPREMIOSS_nEOF'},{av:'AV62SDTProfesionalPremioss',fld:'vSDTPROFESIONALPREMIOSS',grid:348,pic:''},{av:'nRC_GXsfl_348',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'GridRC',grid:348},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALPREMIOSSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEPAGE","{handler:'e162Z2',iparms:[{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF'},{av:'AV60SDTProfesionalExperienciaLaborals',fld:'vSDTPROFESIONALEXPERIENCIALABORALS',grid:292,pic:''},{av:'nRC_GXsfl_292',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'GridRC',grid:292},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR',prop:'SelectedPage'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e172Z2',iparms:[{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF'},{av:'AV60SDTProfesionalExperienciaLaborals',fld:'vSDTPROFESIONALEXPERIENCIALABORALS',grid:292,pic:''},{av:'nRC_GXsfl_292',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'GridRC',grid:292},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALEXPERIENCIALABORALSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEPAGE","{handler:'e142Z2',iparms:[{av:'GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEDUCACIONS_nEOF'},{av:'AV58SDTProfesionalEducacions',fld:'vSDTPROFESIONALEDUCACIONS',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'GridRC',grid:235},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionaleducacionspaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR',prop:'SelectedPage'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e152Z2',iparms:[{av:'GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALEDUCACIONS_nEOF'},{av:'AV58SDTProfesionalEducacions',fld:'vSDTPROFESIONALEDUCACIONS',grid:235,pic:''},{av:'nRC_GXsfl_235',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'GridRC',grid:235},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALEDUCACIONSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEPAGE","{handler:'e122Z2',iparms:[{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF'},{av:'AV59SDTProfesionalEspecialidadSedes',fld:'vSDTPROFESIONALESPECIALIDADSEDES',grid:169,pic:''},{av:'nRC_GXsfl_169',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'GridRC',grid:169},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR',prop:'SelectedPage'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e132Z2',iparms:[{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage'},{av:'GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF'},{av:'AV59SDTProfesionalEspecialidadSedes',fld:'vSDTPROFESIONALESPECIALIDADSEDES',grid:169,pic:''},{av:'nRC_GXsfl_169',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'GridRC',grid:169},{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'subGridsdtprofesionaleducacions_Rows',ctrl:'GRIDSDTPROFESIONALEDUCACIONS',prop:'Rows'},{av:'subGridsdtprofesionalexperiencialaborals_Rows',ctrl:'GRIDSDTPROFESIONALEXPERIENCIALABORALS',prop:'Rows'},{av:'subGridsdtprofesionalpremioss_Rows',ctrl:'GRIDSDTPROFESIONALPREMIOSS',prop:'Rows'},{av:'subGridsdtprofesionalservicioss_Rows',ctrl:'GRIDSDTPROFESIONALSERVICIOSS',prop:'Rows'},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR',prop:'RowsPerPageSelectedValue'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("GRIDSDTPROFESIONALESPECIALIDADSEDESPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsdtprofesionalespecialidadsedes_Rows',ctrl:'GRIDSDTPROFESIONALESPECIALIDADSEDES',prop:'Rows'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("'DOBTNADDSERVICIOS'","{handler:'e222Z2',iparms:[{av:'AV68ServiciosNombre',fld:'vSERVICIOSNOMBRE',pic:''},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("'DOBTNADDSERVICIOS'",",oparms:[{av:'AV41Profesional',fld:'vPROFESIONAL',pic:''},{av:'AV68ServiciosNombre',fld:'vSERVICIOSNOMBRE',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("'DOBTNADDPREMIOSLOGROS'","{handler:'e232Z2',iparms:[{av:'AV38PremiosDescripcion',fld:'vPREMIOSDESCRIPCION',pic:''},{av:'AV40PremiosNombre',fld:'vPREMIOSNOMBRE',pic:''},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'AV39PremiosFecha',fld:'vPREMIOSFECHA',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("'DOBTNADDPREMIOSLOGROS'",",oparms:[{av:'AV41Profesional',fld:'vPROFESIONAL',pic:''},{av:'AV40PremiosNombre',fld:'vPREMIOSNOMBRE',pic:''},{av:'AV38PremiosDescripcion',fld:'vPREMIOSDESCRIPCION',pic:''},{av:'AV39PremiosFecha',fld:'vPREMIOSFECHA',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("'DOBTNADDEXPERIENCIALABORAL'","{handler:'e242Z2',iparms:[{av:'AV19ExperienciaLaboralEmpresaNombre',fld:'vEXPERIENCIALABORALEMPRESANOMBRE',pic:''},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'AV18ExperienciaLaboralDesde',fld:'vEXPERIENCIALABORALDESDE',pic:''},{av:'AV20ExperienciaLaboralHasta',fld:'vEXPERIENCIALABORALHASTA',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("'DOBTNADDEXPERIENCIALABORAL'",",oparms:[{av:'AV41Profesional',fld:'vPROFESIONAL',pic:''},{av:'AV19ExperienciaLaboralEmpresaNombre',fld:'vEXPERIENCIALABORALEMPRESANOMBRE',pic:''},{av:'AV18ExperienciaLaboralDesde',fld:'vEXPERIENCIALABORALDESDE',pic:''},{av:'AV20ExperienciaLaboralHasta',fld:'vEXPERIENCIALABORALHASTA',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("'DOBTNADDEDUCACION'","{handler:'e252Z2',iparms:[{av:'AV13EducacionProfesionalNombreInstitucion',fld:'vEDUCACIONPROFESIONALNOMBREINSTITUCION',pic:''},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'AV14EducacionProfesionalPais',fld:'vEDUCACIONPROFESIONALPAIS',pic:''},{av:'AV11EducacionProfesionalDesde',fld:'vEDUCACIONPROFESIONALDESDE',pic:''},{av:'AV12EducacionProfesionalHasta',fld:'vEDUCACIONPROFESIONALHASTA',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("'DOBTNADDEDUCACION'",",oparms:[{av:'AV41Profesional',fld:'vPROFESIONAL',pic:''},{av:'AV13EducacionProfesionalNombreInstitucion',fld:'vEDUCACIONPROFESIONALNOMBREINSTITUCION',pic:''},{av:'AV14EducacionProfesionalPais',fld:'vEDUCACIONPROFESIONALPAIS',pic:''},{av:'AV11EducacionProfesionalDesde',fld:'vEDUCACIONPROFESIONALDESDE',pic:''},{av:'AV12EducacionProfesionalHasta',fld:'vEDUCACIONPROFESIONALHASTA',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("'DOBTNADDESPECIALIDAD'","{handler:'e262Z2',iparms:[{av:'cmbavEspecialidadtipoconsulta'},{av:'AV16EspecialidadTipoConsulta',fld:'vESPECIALIDADTIPOCONSULTA',pic:''},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("'DOBTNADDESPECIALIDAD'",",oparms:[{av:'cmbavEspecialidadtipoconsulta'},{av:'AV16EspecialidadTipoConsulta',fld:'vESPECIALIDADTIPOCONSULTA',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("'DOBTNACTUALIZARREGISTRO'","{handler:'e112Z1',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("'DOBTNACTUALIZARREGISTRO'",",oparms:[{ctrl:'BTNBTNACTUALIZARREGISTRO',prop:'Visible'},{ctrl:'BTNBTNGUARDARDATOSACTUALIZADOS',prop:'Visible'},{av:'Subirfotografia_Visible',ctrl:'SUBIRFOTOGRAFIA',prop:'Visible'},{av:'cmbavProfesionaltipodocumento'},{av:'edtavProfesionalnrodocumento_Enabled',ctrl:'vPROFESIONALNRODOCUMENTO',prop:'Enabled'},{av:'edtavProfesionalnombres_Enabled',ctrl:'vPROFESIONALNOMBRES',prop:'Enabled'},{av:'edtavProfesionalapellidomaterno_Enabled',ctrl:'vPROFESIONALAPELLIDOMATERNO',prop:'Enabled'},{av:'edtavProfesionalapellidopaterno_Enabled',ctrl:'vPROFESIONALAPELLIDOPATERNO',prop:'Enabled'},{av:'edtavProfesionalfechanacimiento_Enabled',ctrl:'vPROFESIONALFECHANACIMIENTO',prop:'Enabled'},{av:'cmbavProfesionalsexo'},{av:'edtavProfesionalcop_Enabled',ctrl:'vPROFESIONALCOP',prop:'Enabled'},{av:'edtavProfesionaltelefono_Enabled',ctrl:'vPROFESIONALTELEFONO',prop:'Enabled'},{av:'edtavProfesionaldescripcion_Enabled',ctrl:'vPROFESIONALDESCRIPCION',prop:'Enabled'},{av:'cmbavProfesionaltiempocita'},{av:'edtavProfesionaldireccion_Enabled',ctrl:'vPROFESIONALDIRECCION',prop:'Enabled'},{av:'cmbavUbigeodepartamento'},{av:'dynavUbigeodistrito'},{av:'dynavUbigeoprovincia'},{av:'edtavProfesionalcorreo_Enabled',ctrl:'vPROFESIONALCORREO',prop:'Enabled'},{av:'edtavProfesionalpassword_Enabled',ctrl:'vPROFESIONALPASSWORD',prop:'Enabled'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("'DOBTNGUARDARDATOSACTUALIZADOS'","{handler:'e272Z2',iparms:[{av:'cmbavUbigeodepartamento'},{av:'AV70UbigeoDepartamento',fld:'vUBIGEODEPARTAMENTO',pic:''},{av:'dynavUbigeoprovincia'},{av:'AV72UbigeoProvincia',fld:'vUBIGEOPROVINCIA',pic:''},{av:'dynavUbigeodistrito'},{av:'AV71UbigeoDistrito',fld:'vUBIGEODISTRITO',pic:''},{av:'AV6ProfesionalId',fld:'vPROFESIONALID',pic:'ZZZZZZZ9',hsh:true},{av:'AV44ProfesionalCOP',fld:'vPROFESIONALCOP',pic:''},{av:'AV54ProfesionalTelefono',fld:'vPROFESIONALTELEFONO',pic:''},{av:'AV46ProfesionalDescripcion',fld:'vPROFESIONALDESCRIPCION',pic:''},{av:'cmbavProfesionaltiempocita'},{av:'AV55ProfesionalTiempoCita',fld:'vPROFESIONALTIEMPOCITA',pic:'Z9'},{av:'AV47ProfesionalDireccion',fld:'vPROFESIONALDIRECCION',pic:''},{av:'AV73UploadedFiles',fld:'vUPLOADEDFILES',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("'DOBTNGUARDARDATOSACTUALIZADOS'",",oparms:[{av:'AV41Profesional',fld:'vPROFESIONAL',pic:''},{ctrl:'BTNBTNACTUALIZARREGISTRO',prop:'Visible'},{ctrl:'BTNBTNGUARDARDATOSACTUALIZADOS',prop:'Visible'},{av:'Subirfotografia_Visible',ctrl:'SUBIRFOTOGRAFIA',prop:'Visible'},{av:'cmbavProfesionaltipodocumento'},{av:'edtavProfesionalnrodocumento_Enabled',ctrl:'vPROFESIONALNRODOCUMENTO',prop:'Enabled'},{av:'edtavProfesionalnombres_Enabled',ctrl:'vPROFESIONALNOMBRES',prop:'Enabled'},{av:'edtavProfesionalapellidomaterno_Enabled',ctrl:'vPROFESIONALAPELLIDOMATERNO',prop:'Enabled'},{av:'edtavProfesionalapellidopaterno_Enabled',ctrl:'vPROFESIONALAPELLIDOPATERNO',prop:'Enabled'},{av:'edtavProfesionalfechanacimiento_Enabled',ctrl:'vPROFESIONALFECHANACIMIENTO',prop:'Enabled'},{av:'cmbavProfesionalsexo'},{av:'edtavProfesionalcop_Enabled',ctrl:'vPROFESIONALCOP',prop:'Enabled'},{av:'edtavProfesionaltelefono_Enabled',ctrl:'vPROFESIONALTELEFONO',prop:'Enabled'},{av:'edtavProfesionaldescripcion_Enabled',ctrl:'vPROFESIONALDESCRIPCION',prop:'Enabled'},{av:'cmbavProfesionaltiempocita'},{av:'edtavProfesionaldireccion_Enabled',ctrl:'vPROFESIONALDIRECCION',prop:'Enabled'},{av:'cmbavUbigeodepartamento'},{av:'dynavUbigeodistrito'},{av:'dynavUbigeoprovincia'},{av:'edtavProfesionalcorreo_Enabled',ctrl:'vPROFESIONALCORREO',prop:'Enabled'},{av:'edtavProfesionalpassword_Enabled',ctrl:'vPROFESIONALPASSWORD',prop:'Enabled'},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PROFESIONALTIPODOCUMENTO","{handler:'validv_Profesionaltipodocumento',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PROFESIONALTIPODOCUMENTO",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PROFESIONALFECHANACIMIENTO","{handler:'validv_Profesionalfechanacimiento',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PROFESIONALFECHANACIMIENTO",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PROFESIONALSEXO","{handler:'validv_Profesionalsexo',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PROFESIONALSEXO",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PROFESIONALTIEMPOCITA","{handler:'validv_Profesionaltiempocita',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PROFESIONALTIEMPOCITA",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_UBIGEODEPARTAMENTO","{handler:'validv_Ubigeodepartamento',iparms:[{av:'cmbavUbigeodepartamento'},{av:'AV70UbigeoDepartamento',fld:'vUBIGEODEPARTAMENTO',pic:''},{av:'dynavUbigeoprovincia'},{av:'AV72UbigeoProvincia',fld:'vUBIGEOPROVINCIA',pic:''},{av:'dynavUbigeodistrito'},{av:'AV71UbigeoDistrito',fld:'vUBIGEODISTRITO',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_UBIGEODEPARTAMENTO",",oparms:[{av:'dynavUbigeoprovincia'},{av:'AV72UbigeoProvincia',fld:'vUBIGEOPROVINCIA',pic:''},{av:'dynavUbigeodistrito'},{av:'AV71UbigeoDistrito',fld:'vUBIGEODISTRITO',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_UBIGEOPROVINCIA","{handler:'validv_Ubigeoprovincia',iparms:[{av:'cmbavUbigeodepartamento'},{av:'AV70UbigeoDepartamento',fld:'vUBIGEODEPARTAMENTO',pic:''},{av:'dynavUbigeoprovincia'},{av:'AV72UbigeoProvincia',fld:'vUBIGEOPROVINCIA',pic:''},{av:'dynavUbigeodistrito'},{av:'AV71UbigeoDistrito',fld:'vUBIGEODISTRITO',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_UBIGEOPROVINCIA",",oparms:[{av:'dynavUbigeodistrito'},{av:'AV71UbigeoDistrito',fld:'vUBIGEODISTRITO',pic:''},{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PROFESIONALCORREO","{handler:'validv_Profesionalcorreo',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PROFESIONALCORREO",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_ESPECIALIDADTIPOCONSULTA","{handler:'validv_Especialidadtipoconsulta',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_ESPECIALIDADTIPOCONSULTA",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_EDUCACIONPROFESIONALDESDE","{handler:'validv_Educacionprofesionaldesde',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_EDUCACIONPROFESIONALDESDE",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_EDUCACIONPROFESIONALHASTA","{handler:'validv_Educacionprofesionalhasta',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_EDUCACIONPROFESIONALHASTA",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_EXPERIENCIALABORALDESDE","{handler:'validv_Experiencialaboraldesde',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_EXPERIENCIALABORALDESDE",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_EXPERIENCIALABORALHASTA","{handler:'validv_Experiencialaboralhasta',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_EXPERIENCIALABORALHASTA",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_PREMIOSFECHA","{handler:'validv_Premiosfecha',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_PREMIOSFECHA",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("VALIDV_GXV5","{handler:'validv_Gxv5',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("VALIDV_GXV5",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv10',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv14',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv18',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv20',iparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]");
      setEventMetadata("NULL",",oparms:[{av:'dynavEspecialidadnombreid'},{av:'AV15EspecialidadNombreId',fld:'vESPECIALIDADNOMBREID',pic:'ZZZ9'},{av:'dynavPaisid'},{av:'AV36PaisId',fld:'vPAISID',pic:'ZZZ9'}]}");
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
      Gridsdtprofesionalserviciosspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionalpremiosspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionaleducacionspaginationbar_Selectedpage = "" ;
      Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV70UbigeoDepartamento = "" ;
      AV72UbigeoProvincia = "" ;
      Gridsdtprofesionalservicioss_empowerer_Gridinternalname = "" ;
      Gridsdtprofesionalpremioss_empowerer_Gridinternalname = "" ;
      Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname = "" ;
      Gridsdtprofesionaleducacions_empowerer_Gridinternalname = "" ;
      Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV59SDTProfesionalEspecialidadSedes = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede>(com.projectthani.SdtSDTProfesionalEspecialidadSede.class, "SDTProfesionalEspecialidadSede", "ProjectThani", remoteHandle);
      AV58SDTProfesionalEducacions = new GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion>(com.projectthani.SdtSDTProfesionalEducacion.class, "SDTProfesionalEducacion", "ProjectThani", remoteHandle);
      AV60SDTProfesionalExperienciaLaborals = new GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral>(com.projectthani.SdtSDTProfesionalExperienciaLaboral.class, "SDTProfesionalExperienciaLaboral", "ProjectThani", remoteHandle);
      AV62SDTProfesionalPremioss = new GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios>(com.projectthani.SdtSDTProfesionalPremios.class, "SDTProfesionalPremios", "ProjectThani", remoteHandle);
      AV63SDTProfesionalServicioss = new GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios>(com.projectthani.SdtSDTProfesionalServicios.class, "SDTProfesionalServicios", "ProjectThani", remoteHandle);
      AV73UploadedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      AV21FailedFiles = new GXBaseCollection<com.projectthani.SdtFileUploadData>(com.projectthani.SdtFileUploadData.class, "FileUploadData", "ProjectThani", remoteHandle);
      GX_FocusControl = "" ;
      sPrefix = "" ;
      ClassString = "" ;
      StyleString = "" ;
      ucGxuitabspanel_tabinformacionpaciente = new com.genexus.webpanels.GXUserControl();
      lblTabgeneral_title_Jsonclick = "" ;
      TempTags = "" ;
      AV56ProfesionalTipoDocumento = "" ;
      AV51ProfesionalNroDocumento = "" ;
      AV50ProfesionalNombres = "" ;
      AV42ProfesionalApellidoMaterno = "" ;
      AV43ProfesionalApellidoPaterno = "" ;
      AV48ProfesionalFechaNacimiento = GXutil.nullDate() ;
      AV53ProfesionalSexo = "" ;
      AV44ProfesionalCOP = "" ;
      AV54ProfesionalTelefono = "" ;
      AV46ProfesionalDescripcion = "" ;
      AV55ProfesionalTiempoCita = (byte)(30) ;
      AV71UbigeoDistrito = "" ;
      AV47ProfesionalDireccion = "" ;
      AV49ProfesionalFoto = "" ;
      AV99Profesionalfoto_GXI = "" ;
      sImgUrl = "" ;
      ucSubirfotografia = new com.genexus.webpanels.GXUserControl();
      AV45ProfesionalCorreo = "" ;
      AV52ProfesionalPassword = "" ;
      bttBtnbtnactualizarregistro_Jsonclick = "" ;
      bttBtnbtnguardardatosactualizados_Jsonclick = "" ;
      lblTabespecialidad_title_Jsonclick = "" ;
      ucDvpanel_panelregespe = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panellistespe = new com.genexus.webpanels.GXUserControl();
      lblTabeducacion_title_Jsonclick = "" ;
      ucDvpanel_paneleducacion = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_paneleducacionlist = new com.genexus.webpanels.GXUserControl();
      lblTabexperiencialaboral_title_Jsonclick = "" ;
      ucDvpanel_panelexperiencialaboral = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelexperiencialaborallist = new com.genexus.webpanels.GXUserControl();
      lblTabpremioslogros_title_Jsonclick = "" ;
      ucDvpanel_panelpremioslogros = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelpremioslogroslist = new com.genexus.webpanels.GXUserControl();
      lblTabservicios_title_Jsonclick = "" ;
      ucDvpanel_panelservicios = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelservicioslist = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalservicioss_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalpremioss_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalexperiencialaborals_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionaleducacions_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalespecialidadsedes_empowerer = new com.genexus.webpanels.GXUserControl();
      GridsdtprofesionalespecialidadsedesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      GridsdtprofesionaleducacionsContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridsdtprofesionalexperiencialaboralsContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridsdtprofesionalpremiossContainer = new com.genexus.webpanels.GXWebGrid(context);
      GridsdtprofesionalserviciossContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H002Z2_A43PaisId = new short[1] ;
      H002Z2_A184PaisDescripcion = new String[] {""} ;
      H002Z3_A44UbigeoCode = new String[] {""} ;
      H002Z3_A187UbigeoProvincia = new String[] {""} ;
      H002Z3_A296UbigeoProvinciaCode = new String[] {""} ;
      H002Z3_A295UbigeoDepartamentoCode = new String[] {""} ;
      H002Z4_A44UbigeoCode = new String[] {""} ;
      H002Z4_A188UbigeoDistrito = new String[] {""} ;
      H002Z4_A297UbigeoDistritoCode = new String[] {""} ;
      H002Z4_A295UbigeoDepartamentoCode = new String[] {""} ;
      H002Z4_A296UbigeoProvinciaCode = new String[] {""} ;
      H002Z5_A32EspecialidadId = new short[1] ;
      H002Z5_A71EspecialidadNombre = new String[] {""} ;
      H002Z6_A43PaisId = new short[1] ;
      H002Z6_A184PaisDescripcion = new String[] {""} ;
      AV16EspecialidadTipoConsulta = "" ;
      AV13EducacionProfesionalNombreInstitucion = "" ;
      AV14EducacionProfesionalPais = "" ;
      AV11EducacionProfesionalDesde = GXutil.nullDate() ;
      AV12EducacionProfesionalHasta = GXutil.nullDate() ;
      AV19ExperienciaLaboralEmpresaNombre = "" ;
      AV18ExperienciaLaboralDesde = GXutil.nullDate() ;
      AV20ExperienciaLaboralHasta = GXutil.nullDate() ;
      AV40PremiosNombre = "" ;
      AV38PremiosDescripcion = "" ;
      AV39PremiosFecha = GXutil.nullDate() ;
      AV68ServiciosNombre = "" ;
      AV74WWPContext = new com.projectthani.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new com.projectthani.wwpbaseobjects.SdtWWPContext[1] ;
      H002Z7_A6SecUserId = new short[1] ;
      H002Z7_A31ProfesionalId = new int[1] ;
      GXv_objcol_SdtSDTProfesionalEspecialidadSede2 = new GXBaseCollection[1] ;
      AV61SDTProfesionalInformacionGeneral = new GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral>(com.projectthani.SdtSDTProfesionalInformacionGeneral.class, "SDTProfesionalInformacionGeneral", "ProjectThani", remoteHandle);
      GXv_objcol_SdtSDTProfesionalInformacionGeneral3 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalEducacion4 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalExperienciaLaboral5 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalPremios6 = new GXBaseCollection[1] ;
      GXv_objcol_SdtSDTProfesionalServicios7 = new GXBaseCollection[1] ;
      H002Z8_A186UbigeoDepartamento = new String[] {""} ;
      H002Z8_A295UbigeoDepartamentoCode = new String[] {""} ;
      H002Z8_A44UbigeoCode = new String[] {""} ;
      A186UbigeoDepartamento = "" ;
      A295UbigeoDepartamentoCode = "" ;
      A44UbigeoCode = "" ;
      ucGridsdtprofesionalserviciosspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalpremiosspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalexperiencialaboralspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionaleducacionspaginationbar = new com.genexus.webpanels.GXUserControl();
      ucGridsdtprofesionalespecialidadsedespaginationbar = new com.genexus.webpanels.GXUserControl();
      GridsdtprofesionalespecialidadsedesRow = new com.genexus.webpanels.GXWebRow();
      AV41Profesional = new com.projectthani.SdtProfesional(remoteHandle);
      AV67Servicios = new com.projectthani.SdtProfesional_Servicios(remoteHandle);
      AV37Premios = new com.projectthani.SdtProfesional_Premios(remoteHandle);
      AV17ExperienciaLaboral = new com.projectthani.SdtProfesional_ExperienciaLaboral(remoteHandle);
      AV10Educacion = new com.projectthani.SdtProfesional_Educacion(remoteHandle);
      AV69UbigeoCode = "" ;
      AV7SecUser = new com.projectthani.wwpbaseobjects.SdtSecUser(remoteHandle);
      H002Z9_A44UbigeoCode = new String[] {""} ;
      A297UbigeoDistritoCode = "" ;
      A296UbigeoProvinciaCode = "" ;
      AV57Provincia = "" ;
      AV9Distrito = "" ;
      AV8Departamento = "" ;
      GridsdtprofesionalserviciossRow = new com.genexus.webpanels.GXWebRow();
      GridsdtprofesionalpremiossRow = new com.genexus.webpanels.GXWebRow();
      GridsdtprofesionalexperiencialaboralsRow = new com.genexus.webpanels.GXWebRow();
      GridsdtprofesionaleducacionsRow = new com.genexus.webpanels.GXWebRow();
      subGridsdtprofesionalservicioss_Linesclass = "" ;
      GridsdtprofesionalserviciossColumn = new com.genexus.webpanels.GXWebColumn();
      lblTextblockserviciosnombre_Jsonclick = "" ;
      bttBtnbtnaddservicios_Jsonclick = "" ;
      subGridsdtprofesionalpremioss_Linesclass = "" ;
      GridsdtprofesionalpremiossColumn = new com.genexus.webpanels.GXWebColumn();
      lblTextblockpremiosnombre_Jsonclick = "" ;
      lblTextblockpremiosdescripcion_Jsonclick = "" ;
      lblTextblockpremiosfecha_Jsonclick = "" ;
      bttBtnbtnaddpremioslogros_Jsonclick = "" ;
      subGridsdtprofesionalexperiencialaborals_Linesclass = "" ;
      GridsdtprofesionalexperiencialaboralsColumn = new com.genexus.webpanels.GXWebColumn();
      lblTextblockexperiencialaboralempresanombre_Jsonclick = "" ;
      lblTextblockexperiencialaboraldesde_Jsonclick = "" ;
      lblTextblockexperiencialaboralhasta_Jsonclick = "" ;
      bttBtnbtnaddexperiencialaboral_Jsonclick = "" ;
      subGridsdtprofesionaleducacions_Linesclass = "" ;
      GridsdtprofesionaleducacionsColumn = new com.genexus.webpanels.GXWebColumn();
      lblTextblockeducacionprofesionalnombreinstitucion_Jsonclick = "" ;
      lblTextblockeducacionprofesionalpais_Jsonclick = "" ;
      lblTextblockeducacionprofesionaldesde_Jsonclick = "" ;
      lblTextblockeducacionprofesionalhasta_Jsonclick = "" ;
      bttBtnbtnaddeducacion_Jsonclick = "" ;
      subGridsdtprofesionalespecialidadsedes_Linesclass = "" ;
      GridsdtprofesionalespecialidadsedesColumn = new com.genexus.webpanels.GXWebColumn();
      lblTextblockespecialidadnombreid_Jsonclick = "" ;
      lblTextblockespecialidadtipoconsulta_Jsonclick = "" ;
      bttBtnbtnaddespecialidad_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      ROClassString = "" ;
      GXCCtl = "" ;
      H002Z10_A43PaisId = new short[1] ;
      H002Z10_A184PaisDescripcion = new String[] {""} ;
      ZV72UbigeoProvincia = "" ;
      ZV71UbigeoDistrito = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.projectthani.wpmiperfilmedico__default(),
         new Object[] {
             new Object[] {
            H002Z2_A43PaisId, H002Z2_A184PaisDescripcion
            }
            , new Object[] {
            H002Z3_A44UbigeoCode, H002Z3_A187UbigeoProvincia, H002Z3_A296UbigeoProvinciaCode, H002Z3_A295UbigeoDepartamentoCode
            }
            , new Object[] {
            H002Z4_A44UbigeoCode, H002Z4_A188UbigeoDistrito, H002Z4_A297UbigeoDistritoCode, H002Z4_A295UbigeoDepartamentoCode, H002Z4_A296UbigeoProvinciaCode
            }
            , new Object[] {
            H002Z5_A32EspecialidadId, H002Z5_A71EspecialidadNombre
            }
            , new Object[] {
            H002Z6_A43PaisId, H002Z6_A184PaisDescripcion
            }
            , new Object[] {
            H002Z7_A6SecUserId, H002Z7_A31ProfesionalId
            }
            , new Object[] {
            H002Z8_A186UbigeoDepartamento, H002Z8_A295UbigeoDepartamentoCode, H002Z8_A44UbigeoCode
            }
            , new Object[] {
            H002Z9_A44UbigeoCode
            }
            , new Object[] {
            H002Z10_A43PaisId, H002Z10_A184PaisDescripcion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled = 0 ;
      edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled = 0 ;
      edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled = 0 ;
      cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta.setEnabled( 0 );
      edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educaciondesde_Enabled = 0 ;
      edtavSdtprofesionaleducacions__educacionhasta_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled = 0 ;
      edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosnombre_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosfecha_Enabled = 0 ;
      edtavSdtprofesionalpremioss__premiosdescripcion_Enabled = 0 ;
      edtavSdtprofesionalservicioss__serviciosnombre_Enabled = 0 ;
   }

   private byte GRIDSDTPROFESIONALESPECIALIDADSEDES_nEOF ;
   private byte GRIDSDTPROFESIONALEDUCACIONS_nEOF ;
   private byte GRIDSDTPROFESIONALEXPERIENCIALABORALS_nEOF ;
   private byte GRIDSDTPROFESIONALPREMIOSS_nEOF ;
   private byte GRIDSDTPROFESIONALSERVICIOSS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte AV55ProfesionalTiempoCita ;
   private byte nDonePA ;
   private byte subGridsdtprofesionalespecialidadsedes_Backcolorstyle ;
   private byte subGridsdtprofesionalservicioss_Backcolorstyle ;
   private byte subGridsdtprofesionalpremioss_Backcolorstyle ;
   private byte subGridsdtprofesionalexperiencialaborals_Backcolorstyle ;
   private byte subGridsdtprofesionaleducacions_Backcolorstyle ;
   private byte subGridsdtprofesionalservicioss_Titlebackstyle ;
   private byte subGridsdtprofesionalservicioss_Allowselection ;
   private byte subGridsdtprofesionalservicioss_Allowhovering ;
   private byte subGridsdtprofesionalservicioss_Allowcollapsing ;
   private byte subGridsdtprofesionalservicioss_Collapsed ;
   private byte subGridsdtprofesionalpremioss_Titlebackstyle ;
   private byte subGridsdtprofesionalpremioss_Allowselection ;
   private byte subGridsdtprofesionalpremioss_Allowhovering ;
   private byte subGridsdtprofesionalpremioss_Allowcollapsing ;
   private byte subGridsdtprofesionalpremioss_Collapsed ;
   private byte subGridsdtprofesionalexperiencialaborals_Titlebackstyle ;
   private byte subGridsdtprofesionalexperiencialaborals_Allowselection ;
   private byte subGridsdtprofesionalexperiencialaborals_Allowhovering ;
   private byte subGridsdtprofesionalexperiencialaborals_Allowcollapsing ;
   private byte subGridsdtprofesionalexperiencialaborals_Collapsed ;
   private byte subGridsdtprofesionaleducacions_Titlebackstyle ;
   private byte subGridsdtprofesionaleducacions_Allowselection ;
   private byte subGridsdtprofesionaleducacions_Allowhovering ;
   private byte subGridsdtprofesionaleducacions_Allowcollapsing ;
   private byte subGridsdtprofesionaleducacions_Collapsed ;
   private byte subGridsdtprofesionalespecialidadsedes_Titlebackstyle ;
   private byte subGridsdtprofesionalespecialidadsedes_Allowselection ;
   private byte subGridsdtprofesionalespecialidadsedes_Allowhovering ;
   private byte subGridsdtprofesionalespecialidadsedes_Allowcollapsing ;
   private byte subGridsdtprofesionalespecialidadsedes_Collapsed ;
   private byte nGXWrapped ;
   private byte subGridsdtprofesionalespecialidadsedes_Backstyle ;
   private byte subGridsdtprofesionaleducacions_Backstyle ;
   private byte subGridsdtprofesionalexperiencialaborals_Backstyle ;
   private byte subGridsdtprofesionalpremioss_Backstyle ;
   private byte subGridsdtprofesionalservicioss_Backstyle ;
   private short nRcdExists_9 ;
   private short nIsMod_9 ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short AV15EspecialidadNombreId ;
   private short AV36PaisId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A6SecUserId ;
   private short AV66SedeId ;
   private int Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselectedvalue ;
   private int Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_169 ;
   private int nRC_GXsfl_235 ;
   private int nRC_GXsfl_292 ;
   private int nRC_GXsfl_348 ;
   private int nRC_GXsfl_386 ;
   private int nGXsfl_169_idx=1 ;
   private int subGridsdtprofesionalespecialidadsedes_Rows ;
   private int subGridsdtprofesionaleducacions_Rows ;
   private int subGridsdtprofesionalexperiencialaborals_Rows ;
   private int subGridsdtprofesionalpremioss_Rows ;
   private int subGridsdtprofesionalservicioss_Rows ;
   private int AV6ProfesionalId ;
   private int Subirfotografia_Maxnumberoffiles ;
   private int Gridsdtprofesionalespecialidadsedespaginationbar_Pagestoshow ;
   private int Gridsdtprofesionaleducacionspaginationbar_Pagestoshow ;
   private int Gridsdtprofesionalexperiencialaboralspaginationbar_Pagestoshow ;
   private int Gridsdtprofesionalpremiosspaginationbar_Pagestoshow ;
   private int Gridsdtprofesionalserviciosspaginationbar_Pagestoshow ;
   private int Gxuitabspanel_tabinformacionpaciente_Pagecount ;
   private int nGXsfl_235_idx=1 ;
   private int nGXsfl_292_idx=1 ;
   private int nGXsfl_348_idx=1 ;
   private int nGXsfl_386_idx=1 ;
   private int edtavProfesionalnrodocumento_Enabled ;
   private int edtavProfesionalnombres_Enabled ;
   private int edtavProfesionalapellidomaterno_Enabled ;
   private int edtavProfesionalapellidopaterno_Enabled ;
   private int edtavProfesionalfechanacimiento_Enabled ;
   private int edtavProfesionalcop_Enabled ;
   private int edtavProfesionaltelefono_Enabled ;
   private int edtavProfesionaldescripcion_Enabled ;
   private int edtavProfesionaldireccion_Enabled ;
   private int edtavProfesionalcorreo_Enabled ;
   private int edtavProfesionalpassword_Enabled ;
   private int bttBtnbtnactualizarregistro_Visible ;
   private int bttBtnbtnguardardatosactualizados_Visible ;
   private int AV77GXV1 ;
   private int AV82GXV6 ;
   private int AV87GXV11 ;
   private int AV91GXV15 ;
   private int AV95GXV19 ;
   private int gxdynajaxindex ;
   private int subGridsdtprofesionalespecialidadsedes_Islastpage ;
   private int subGridsdtprofesionalservicioss_Islastpage ;
   private int subGridsdtprofesionalpremioss_Islastpage ;
   private int subGridsdtprofesionalexperiencialaborals_Islastpage ;
   private int subGridsdtprofesionaleducacions_Islastpage ;
   private int edtavSdtprofesionalespecialidadsedes__especialidadid_Enabled ;
   private int edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Enabled ;
   private int edtavSdtprofesionalespecialidadsedes__especialidadnombre_Enabled ;
   private int edtavSdtprofesionaleducacions__educacionnombreinstitucion_Enabled ;
   private int edtavSdtprofesionaleducacions__educacionpaisdescripcion_Enabled ;
   private int edtavSdtprofesionaleducacions__educaciondesde_Enabled ;
   private int edtavSdtprofesionaleducacions__educacionhasta_Enabled ;
   private int edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Enabled ;
   private int edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Enabled ;
   private int edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Enabled ;
   private int edtavSdtprofesionalpremioss__premiosnombre_Enabled ;
   private int edtavSdtprofesionalpremioss__premiosfecha_Enabled ;
   private int edtavSdtprofesionalpremioss__premiosdescripcion_Enabled ;
   private int edtavSdtprofesionalservicioss__serviciosnombre_Enabled ;
   private int GRIDSDTPROFESIONALESPECIALIDADSEDES_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALSERVICIOSS_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALPREMIOSS_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALEXPERIENCIALABORALS_nGridOutOfScope ;
   private int GRIDSDTPROFESIONALEDUCACIONS_nGridOutOfScope ;
   private int nGXsfl_169_fel_idx=1 ;
   private int nGXsfl_235_fel_idx=1 ;
   private int nGXsfl_292_fel_idx=1 ;
   private int nGXsfl_348_fel_idx=1 ;
   private int nGXsfl_386_fel_idx=1 ;
   private int A31ProfesionalId ;
   private int AV35PageToGo ;
   private int subGridsdtprofesionalservicioss_Titlebackcolor ;
   private int subGridsdtprofesionalservicioss_Allbackcolor ;
   private int subGridsdtprofesionalservicioss_Selectedindex ;
   private int subGridsdtprofesionalservicioss_Selectioncolor ;
   private int subGridsdtprofesionalservicioss_Hoveringcolor ;
   private int edtavServiciosnombre_Enabled ;
   private int subGridsdtprofesionalpremioss_Titlebackcolor ;
   private int subGridsdtprofesionalpremioss_Allbackcolor ;
   private int subGridsdtprofesionalpremioss_Selectedindex ;
   private int subGridsdtprofesionalpremioss_Selectioncolor ;
   private int subGridsdtprofesionalpremioss_Hoveringcolor ;
   private int edtavPremiosnombre_Enabled ;
   private int edtavPremiosdescripcion_Enabled ;
   private int edtavPremiosfecha_Enabled ;
   private int subGridsdtprofesionalexperiencialaborals_Titlebackcolor ;
   private int subGridsdtprofesionalexperiencialaborals_Allbackcolor ;
   private int subGridsdtprofesionalexperiencialaborals_Selectedindex ;
   private int subGridsdtprofesionalexperiencialaborals_Selectioncolor ;
   private int subGridsdtprofesionalexperiencialaborals_Hoveringcolor ;
   private int edtavExperiencialaboralempresanombre_Enabled ;
   private int edtavExperiencialaboraldesde_Enabled ;
   private int edtavExperiencialaboralhasta_Enabled ;
   private int subGridsdtprofesionaleducacions_Titlebackcolor ;
   private int subGridsdtprofesionaleducacions_Allbackcolor ;
   private int subGridsdtprofesionaleducacions_Selectedindex ;
   private int subGridsdtprofesionaleducacions_Selectioncolor ;
   private int subGridsdtprofesionaleducacions_Hoveringcolor ;
   private int edtavEducacionprofesionalnombreinstitucion_Enabled ;
   private int edtavEducacionprofesionalpais_Enabled ;
   private int edtavEducacionprofesionaldesde_Enabled ;
   private int edtavEducacionprofesionalhasta_Enabled ;
   private int subGridsdtprofesionalespecialidadsedes_Titlebackcolor ;
   private int subGridsdtprofesionalespecialidadsedes_Allbackcolor ;
   private int subGridsdtprofesionalespecialidadsedes_Selectedindex ;
   private int subGridsdtprofesionalespecialidadsedes_Selectioncolor ;
   private int subGridsdtprofesionalespecialidadsedes_Hoveringcolor ;
   private int idxLst ;
   private int subGridsdtprofesionalespecialidadsedes_Backcolor ;
   private int subGridsdtprofesionaleducacions_Backcolor ;
   private int subGridsdtprofesionalexperiencialaborals_Backcolor ;
   private int subGridsdtprofesionalpremioss_Backcolor ;
   private int subGridsdtprofesionalservicioss_Backcolor ;
   private long GRIDSDTPROFESIONALESPECIALIDADSEDES_nFirstRecordOnPage ;
   private long GRIDSDTPROFESIONALEDUCACIONS_nFirstRecordOnPage ;
   private long GRIDSDTPROFESIONALEXPERIENCIALABORALS_nFirstRecordOnPage ;
   private long GRIDSDTPROFESIONALPREMIOSS_nFirstRecordOnPage ;
   private long GRIDSDTPROFESIONALSERVICIOSS_nFirstRecordOnPage ;
   private long AV25GridSDTProfesionalEspecialidadSedesCurrentPage ;
   private long AV26GridSDTProfesionalEspecialidadSedesPageCount ;
   private long AV23GridSDTProfesionalEducacionsCurrentPage ;
   private long AV24GridSDTProfesionalEducacionsPageCount ;
   private long AV27GridSDTProfesionalExperienciaLaboralsCurrentPage ;
   private long AV28GridSDTProfesionalExperienciaLaboralsPageCount ;
   private long AV29GridSDTProfesionalPremiossCurrentPage ;
   private long AV30GridSDTProfesionalPremiossPageCount ;
   private long AV31GridSDTProfesionalServiciossCurrentPage ;
   private long AV32GridSDTProfesionalServiciossPageCount ;
   private long GRIDSDTPROFESIONALESPECIALIDADSEDES_nCurrentRecord ;
   private long GRIDSDTPROFESIONALEDUCACIONS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALEXPERIENCIALABORALS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALPREMIOSS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALSERVICIOSS_nCurrentRecord ;
   private long GRIDSDTPROFESIONALESPECIALIDADSEDES_nRecordCount ;
   private long GRIDSDTPROFESIONALSERVICIOSS_nRecordCount ;
   private long GRIDSDTPROFESIONALPREMIOSS_nRecordCount ;
   private long GRIDSDTPROFESIONALEXPERIENCIALABORALS_nRecordCount ;
   private long GRIDSDTPROFESIONALEDUCACIONS_nRecordCount ;
   private String Gridsdtprofesionalserviciosspaginationbar_Selectedpage ;
   private String Gridsdtprofesionalpremiosspaginationbar_Selectedpage ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Selectedpage ;
   private String Gridsdtprofesionaleducacionspaginationbar_Selectedpage ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_169_idx="0001" ;
   private String Subirfotografia_Class ;
   private String Subirfotografia_Acceptedfiletypes ;
   private String Dvpanel_panelregespe_Width ;
   private String Dvpanel_panelregespe_Cls ;
   private String Dvpanel_panelregespe_Title ;
   private String Dvpanel_panelregespe_Iconposition ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Class ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Pagingbuttonsposition ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Pagingcaptionposition ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridclass ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageoptions ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Previous ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Next ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Caption ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Emptygridcaption ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpagecaption ;
   private String Dvpanel_panellistespe_Width ;
   private String Dvpanel_panellistespe_Cls ;
   private String Dvpanel_panellistespe_Title ;
   private String Dvpanel_panellistespe_Iconposition ;
   private String Dvpanel_paneleducacion_Width ;
   private String Dvpanel_paneleducacion_Cls ;
   private String Dvpanel_paneleducacion_Title ;
   private String Dvpanel_paneleducacion_Iconposition ;
   private String Gridsdtprofesionaleducacionspaginationbar_Class ;
   private String Gridsdtprofesionaleducacionspaginationbar_Pagingbuttonsposition ;
   private String Gridsdtprofesionaleducacionspaginationbar_Pagingcaptionposition ;
   private String Gridsdtprofesionaleducacionspaginationbar_Emptygridclass ;
   private String Gridsdtprofesionaleducacionspaginationbar_Rowsperpageoptions ;
   private String Gridsdtprofesionaleducacionspaginationbar_Previous ;
   private String Gridsdtprofesionaleducacionspaginationbar_Next ;
   private String Gridsdtprofesionaleducacionspaginationbar_Caption ;
   private String Gridsdtprofesionaleducacionspaginationbar_Emptygridcaption ;
   private String Gridsdtprofesionaleducacionspaginationbar_Rowsperpagecaption ;
   private String Dvpanel_paneleducacionlist_Width ;
   private String Dvpanel_paneleducacionlist_Cls ;
   private String Dvpanel_paneleducacionlist_Title ;
   private String Dvpanel_paneleducacionlist_Iconposition ;
   private String Dvpanel_panelexperiencialaboral_Width ;
   private String Dvpanel_panelexperiencialaboral_Cls ;
   private String Dvpanel_panelexperiencialaboral_Title ;
   private String Dvpanel_panelexperiencialaboral_Iconposition ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Class ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingbuttonsposition ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Pagingcaptionposition ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridclass ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageoptions ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Previous ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Next ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Caption ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Emptygridcaption ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpagecaption ;
   private String Dvpanel_panelexperiencialaborallist_Width ;
   private String Dvpanel_panelexperiencialaborallist_Cls ;
   private String Dvpanel_panelexperiencialaborallist_Title ;
   private String Dvpanel_panelexperiencialaborallist_Iconposition ;
   private String Dvpanel_panelpremioslogros_Width ;
   private String Dvpanel_panelpremioslogros_Cls ;
   private String Dvpanel_panelpremioslogros_Title ;
   private String Dvpanel_panelpremioslogros_Iconposition ;
   private String Gridsdtprofesionalpremiosspaginationbar_Class ;
   private String Gridsdtprofesionalpremiosspaginationbar_Pagingbuttonsposition ;
   private String Gridsdtprofesionalpremiosspaginationbar_Pagingcaptionposition ;
   private String Gridsdtprofesionalpremiosspaginationbar_Emptygridclass ;
   private String Gridsdtprofesionalpremiosspaginationbar_Rowsperpageoptions ;
   private String Gridsdtprofesionalpremiosspaginationbar_Previous ;
   private String Gridsdtprofesionalpremiosspaginationbar_Next ;
   private String Gridsdtprofesionalpremiosspaginationbar_Caption ;
   private String Gridsdtprofesionalpremiosspaginationbar_Emptygridcaption ;
   private String Gridsdtprofesionalpremiosspaginationbar_Rowsperpagecaption ;
   private String Dvpanel_panelpremioslogroslist_Width ;
   private String Dvpanel_panelpremioslogroslist_Cls ;
   private String Dvpanel_panelpremioslogroslist_Title ;
   private String Dvpanel_panelpremioslogroslist_Iconposition ;
   private String Dvpanel_panelservicios_Width ;
   private String Dvpanel_panelservicios_Cls ;
   private String Dvpanel_panelservicios_Title ;
   private String Dvpanel_panelservicios_Iconposition ;
   private String Gridsdtprofesionalserviciosspaginationbar_Class ;
   private String Gridsdtprofesionalserviciosspaginationbar_Pagingbuttonsposition ;
   private String Gridsdtprofesionalserviciosspaginationbar_Pagingcaptionposition ;
   private String Gridsdtprofesionalserviciosspaginationbar_Emptygridclass ;
   private String Gridsdtprofesionalserviciosspaginationbar_Rowsperpageoptions ;
   private String Gridsdtprofesionalserviciosspaginationbar_Previous ;
   private String Gridsdtprofesionalserviciosspaginationbar_Next ;
   private String Gridsdtprofesionalserviciosspaginationbar_Caption ;
   private String Gridsdtprofesionalserviciosspaginationbar_Emptygridcaption ;
   private String Gridsdtprofesionalserviciosspaginationbar_Rowsperpagecaption ;
   private String Dvpanel_panelservicioslist_Width ;
   private String Dvpanel_panelservicioslist_Cls ;
   private String Dvpanel_panelservicioslist_Title ;
   private String Dvpanel_panelservicioslist_Iconposition ;
   private String Gxuitabspanel_tabinformacionpaciente_Class ;
   private String Gridsdtprofesionalservicioss_empowerer_Gridinternalname ;
   private String Gridsdtprofesionalpremioss_empowerer_Gridinternalname ;
   private String Gridsdtprofesionalexperiencialaborals_empowerer_Gridinternalname ;
   private String Gridsdtprofesionaleducacions_empowerer_Gridinternalname ;
   private String Gridsdtprofesionalespecialidadsedes_empowerer_Gridinternalname ;
   private String sGXsfl_235_idx="0001" ;
   private String sGXsfl_292_idx="0001" ;
   private String sGXsfl_348_idx="0001" ;
   private String sGXsfl_386_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String Gxuitabspanel_tabinformacionpaciente_Internalname ;
   private String lblTabgeneral_title_Internalname ;
   private String lblTabgeneral_title_Jsonclick ;
   private String divUnnamedtable6_Internalname ;
   private String grpUnnamedgroup7_Internalname ;
   private String divInformaciongeneral_Internalname ;
   private String TempTags ;
   private String AV56ProfesionalTipoDocumento ;
   private String edtavProfesionalnrodocumento_Internalname ;
   private String edtavProfesionalnrodocumento_Jsonclick ;
   private String edtavProfesionalnombres_Internalname ;
   private String edtavProfesionalnombres_Jsonclick ;
   private String edtavProfesionalapellidomaterno_Internalname ;
   private String edtavProfesionalapellidomaterno_Jsonclick ;
   private String edtavProfesionalapellidopaterno_Internalname ;
   private String edtavProfesionalapellidopaterno_Jsonclick ;
   private String edtavProfesionalfechanacimiento_Internalname ;
   private String edtavProfesionalfechanacimiento_Jsonclick ;
   private String AV53ProfesionalSexo ;
   private String edtavProfesionalcop_Internalname ;
   private String edtavProfesionalcop_Jsonclick ;
   private String edtavProfesionaltelefono_Internalname ;
   private String AV54ProfesionalTelefono ;
   private String edtavProfesionaltelefono_Jsonclick ;
   private String edtavProfesionaldescripcion_Internalname ;
   private String grpUnnamedgroup8_Internalname ;
   private String divUbicacion_Internalname ;
   private String edtavProfesionaldireccion_Internalname ;
   private String grpUnnamedgroup9_Internalname ;
   private String divImagenperfil_Internalname ;
   private String imgavProfesionalfoto_Internalname ;
   private String sImgUrl ;
   private String Subirfotografia_Tooltiptext ;
   private String Subirfotografia_Internalname ;
   private String grpUnnamedgroup10_Internalname ;
   private String divInfocuenta_Internalname ;
   private String edtavProfesionalcorreo_Internalname ;
   private String edtavProfesionalcorreo_Jsonclick ;
   private String edtavProfesionalpassword_Internalname ;
   private String edtavProfesionalpassword_Jsonclick ;
   private String bttBtnbtnactualizarregistro_Internalname ;
   private String bttBtnbtnactualizarregistro_Jsonclick ;
   private String bttBtnbtnguardardatosactualizados_Internalname ;
   private String bttBtnbtnguardardatosactualizados_Jsonclick ;
   private String lblTabespecialidad_title_Internalname ;
   private String lblTabespecialidad_title_Jsonclick ;
   private String divUnnamedtable5_Internalname ;
   private String Dvpanel_panelregespe_Internalname ;
   private String Dvpanel_panellistespe_Internalname ;
   private String lblTabeducacion_title_Internalname ;
   private String lblTabeducacion_title_Jsonclick ;
   private String divUnnamedtable4_Internalname ;
   private String Dvpanel_paneleducacion_Internalname ;
   private String Dvpanel_paneleducacionlist_Internalname ;
   private String lblTabexperiencialaboral_title_Internalname ;
   private String lblTabexperiencialaboral_title_Jsonclick ;
   private String divUnnamedtable3_Internalname ;
   private String Dvpanel_panelexperiencialaboral_Internalname ;
   private String Dvpanel_panelexperiencialaborallist_Internalname ;
   private String lblTabpremioslogros_title_Internalname ;
   private String lblTabpremioslogros_title_Jsonclick ;
   private String divUnnamedtable2_Internalname ;
   private String Dvpanel_panelpremioslogros_Internalname ;
   private String Dvpanel_panelpremioslogroslist_Internalname ;
   private String lblTabservicios_title_Internalname ;
   private String lblTabservicios_title_Jsonclick ;
   private String divUnnamedtable1_Internalname ;
   private String Dvpanel_panelservicios_Internalname ;
   private String Dvpanel_panelservicioslist_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Gridsdtprofesionalservicioss_empowerer_Internalname ;
   private String Gridsdtprofesionalpremioss_empowerer_Internalname ;
   private String Gridsdtprofesionalexperiencialaborals_empowerer_Internalname ;
   private String Gridsdtprofesionaleducacions_empowerer_Internalname ;
   private String Gridsdtprofesionalespecialidadsedes_empowerer_Internalname ;
   private String sStyleString ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String AV16EspecialidadTipoConsulta ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadid_Internalname ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Internalname ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadnombre_Internalname ;
   private String edtavSdtprofesionaleducacions__educacionnombreinstitucion_Internalname ;
   private String edtavSdtprofesionaleducacions__educacionpaisdescripcion_Internalname ;
   private String edtavSdtprofesionaleducacions__educaciondesde_Internalname ;
   private String edtavSdtprofesionaleducacions__educacionhasta_Internalname ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Internalname ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Internalname ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Internalname ;
   private String edtavSdtprofesionalpremioss__premiosnombre_Internalname ;
   private String edtavSdtprofesionalpremioss__premiosfecha_Internalname ;
   private String edtavSdtprofesionalpremioss__premiosdescripcion_Internalname ;
   private String edtavSdtprofesionalservicioss__serviciosnombre_Internalname ;
   private String sGXsfl_169_fel_idx="0001" ;
   private String sGXsfl_235_fel_idx="0001" ;
   private String sGXsfl_292_fel_idx="0001" ;
   private String sGXsfl_348_fel_idx="0001" ;
   private String sGXsfl_386_fel_idx="0001" ;
   private String edtavEducacionprofesionalnombreinstitucion_Internalname ;
   private String edtavEducacionprofesionalpais_Internalname ;
   private String edtavEducacionprofesionaldesde_Internalname ;
   private String edtavEducacionprofesionalhasta_Internalname ;
   private String edtavExperiencialaboralempresanombre_Internalname ;
   private String edtavExperiencialaboraldesde_Internalname ;
   private String edtavExperiencialaboralhasta_Internalname ;
   private String edtavPremiosnombre_Internalname ;
   private String edtavPremiosdescripcion_Internalname ;
   private String edtavPremiosfecha_Internalname ;
   private String edtavServiciosnombre_Internalname ;
   private String A44UbigeoCode ;
   private String subGridsdtprofesionalservicioss_Internalname ;
   private String subGridsdtprofesionalpremioss_Internalname ;
   private String subGridsdtprofesionalexperiencialaborals_Internalname ;
   private String subGridsdtprofesionaleducacions_Internalname ;
   private String subGridsdtprofesionalespecialidadsedes_Internalname ;
   private String Gridsdtprofesionalserviciosspaginationbar_Internalname ;
   private String Gridsdtprofesionalpremiosspaginationbar_Internalname ;
   private String Gridsdtprofesionalexperiencialaboralspaginationbar_Internalname ;
   private String Gridsdtprofesionaleducacionspaginationbar_Internalname ;
   private String Gridsdtprofesionalespecialidadsedespaginationbar_Internalname ;
   private String AV69UbigeoCode ;
   private String tblPanelservicioslist_Internalname ;
   private String divGridsdtprofesionalserviciosstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalservicioss_Class ;
   private String subGridsdtprofesionalservicioss_Linesclass ;
   private String subGridsdtprofesionalservicioss_Header ;
   private String tblPanelservicios_Internalname ;
   private String divUnnamedtableserviciosnombre_Internalname ;
   private String lblTextblockserviciosnombre_Internalname ;
   private String lblTextblockserviciosnombre_Jsonclick ;
   private String edtavServiciosnombre_Jsonclick ;
   private String bttBtnbtnaddservicios_Internalname ;
   private String bttBtnbtnaddservicios_Jsonclick ;
   private String tblPanelpremioslogroslist_Internalname ;
   private String divGridsdtprofesionalpremiosstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalpremioss_Class ;
   private String subGridsdtprofesionalpremioss_Linesclass ;
   private String subGridsdtprofesionalpremioss_Header ;
   private String tblPanelpremioslogros_Internalname ;
   private String divUnnamedtablepremiosnombre_Internalname ;
   private String lblTextblockpremiosnombre_Internalname ;
   private String lblTextblockpremiosnombre_Jsonclick ;
   private String divUnnamedtablepremiosdescripcion_Internalname ;
   private String lblTextblockpremiosdescripcion_Internalname ;
   private String lblTextblockpremiosdescripcion_Jsonclick ;
   private String divUnnamedtablepremiosfecha_Internalname ;
   private String lblTextblockpremiosfecha_Internalname ;
   private String lblTextblockpremiosfecha_Jsonclick ;
   private String edtavPremiosfecha_Jsonclick ;
   private String bttBtnbtnaddpremioslogros_Internalname ;
   private String bttBtnbtnaddpremioslogros_Jsonclick ;
   private String tblPanelexperiencialaborallist_Internalname ;
   private String divGridsdtprofesionalexperiencialaboralstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalexperiencialaborals_Class ;
   private String subGridsdtprofesionalexperiencialaborals_Linesclass ;
   private String subGridsdtprofesionalexperiencialaborals_Header ;
   private String tblPanelexperiencialaboral_Internalname ;
   private String divUnnamedtableexperiencialaboralempresanombre_Internalname ;
   private String lblTextblockexperiencialaboralempresanombre_Internalname ;
   private String lblTextblockexperiencialaboralempresanombre_Jsonclick ;
   private String divUnnamedtableexperiencialaboraldesde_Internalname ;
   private String lblTextblockexperiencialaboraldesde_Internalname ;
   private String lblTextblockexperiencialaboraldesde_Jsonclick ;
   private String edtavExperiencialaboraldesde_Jsonclick ;
   private String divUnnamedtableexperiencialaboralhasta_Internalname ;
   private String lblTextblockexperiencialaboralhasta_Internalname ;
   private String lblTextblockexperiencialaboralhasta_Jsonclick ;
   private String edtavExperiencialaboralhasta_Jsonclick ;
   private String bttBtnbtnaddexperiencialaboral_Internalname ;
   private String bttBtnbtnaddexperiencialaboral_Jsonclick ;
   private String tblPaneleducacionlist_Internalname ;
   private String divGridsdtprofesionaleducacionstablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionaleducacions_Class ;
   private String subGridsdtprofesionaleducacions_Linesclass ;
   private String subGridsdtprofesionaleducacions_Header ;
   private String tblPaneleducacion_Internalname ;
   private String divUnnamedtableeducacionprofesionalnombreinstitucion_Internalname ;
   private String lblTextblockeducacionprofesionalnombreinstitucion_Internalname ;
   private String lblTextblockeducacionprofesionalnombreinstitucion_Jsonclick ;
   private String divUnnamedtableeducacionprofesionalpais_Internalname ;
   private String lblTextblockeducacionprofesionalpais_Internalname ;
   private String lblTextblockeducacionprofesionalpais_Jsonclick ;
   private String edtavEducacionprofesionalpais_Jsonclick ;
   private String divUnnamedtableeducacionprofesionaldesde_Internalname ;
   private String lblTextblockeducacionprofesionaldesde_Internalname ;
   private String lblTextblockeducacionprofesionaldesde_Jsonclick ;
   private String edtavEducacionprofesionaldesde_Jsonclick ;
   private String divUnnamedtableeducacionprofesionalhasta_Internalname ;
   private String lblTextblockeducacionprofesionalhasta_Internalname ;
   private String lblTextblockeducacionprofesionalhasta_Jsonclick ;
   private String edtavEducacionprofesionalhasta_Jsonclick ;
   private String bttBtnbtnaddeducacion_Internalname ;
   private String bttBtnbtnaddeducacion_Jsonclick ;
   private String tblPanellistespe_Internalname ;
   private String divGridsdtprofesionalespecialidadsedestablewithpaginationbar_Internalname ;
   private String subGridsdtprofesionalespecialidadsedes_Class ;
   private String subGridsdtprofesionalespecialidadsedes_Linesclass ;
   private String subGridsdtprofesionalespecialidadsedes_Header ;
   private String tblPanelregespe_Internalname ;
   private String divUnnamedtableespecialidadnombreid_Internalname ;
   private String lblTextblockespecialidadnombreid_Internalname ;
   private String lblTextblockespecialidadnombreid_Jsonclick ;
   private String divUnnamedtableespecialidadtipoconsulta_Internalname ;
   private String lblTextblockespecialidadtipoconsulta_Internalname ;
   private String lblTextblockespecialidadtipoconsulta_Jsonclick ;
   private String bttBtnbtnaddespecialidad_Internalname ;
   private String bttBtnbtnaddespecialidad_Jsonclick ;
   private String ROClassString ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadid_Jsonclick ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadcodigo_Jsonclick ;
   private String edtavSdtprofesionalespecialidadsedes__especialidadnombre_Jsonclick ;
   private String GXCCtl ;
   private String edtavSdtprofesionaleducacions__educacionnombreinstitucion_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educacionpaisdescripcion_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educaciondesde_Jsonclick ;
   private String edtavSdtprofesionaleducacions__educacionhasta_Jsonclick ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralempresanombre_Jsonclick ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboraldesde_Jsonclick ;
   private String edtavSdtprofesionalexperiencialaborals__experiencialaboralhasta_Jsonclick ;
   private String edtavSdtprofesionalpremioss__premiosnombre_Jsonclick ;
   private String edtavSdtprofesionalpremioss__premiosfecha_Jsonclick ;
   private String edtavSdtprofesionalpremioss__premiosdescripcion_Jsonclick ;
   private String edtavSdtprofesionalservicioss__serviciosnombre_Jsonclick ;
   private java.util.Date AV48ProfesionalFechaNacimiento ;
   private java.util.Date AV11EducacionProfesionalDesde ;
   private java.util.Date AV12EducacionProfesionalHasta ;
   private java.util.Date AV18ExperienciaLaboralDesde ;
   private java.util.Date AV20ExperienciaLaboralHasta ;
   private java.util.Date AV39PremiosFecha ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Subirfotografia_Autoupload ;
   private boolean Subirfotografia_Hideadditionalbuttons ;
   private boolean Subirfotografia_Enableuploadedfilecanceling ;
   private boolean Subirfotografia_Autodisableaddingfiles ;
   private boolean Subirfotografia_Visible ;
   private boolean Dvpanel_panelregespe_Autowidth ;
   private boolean Dvpanel_panelregespe_Autoheight ;
   private boolean Dvpanel_panelregespe_Collapsible ;
   private boolean Dvpanel_panelregespe_Collapsed ;
   private boolean Dvpanel_panelregespe_Showcollapseicon ;
   private boolean Dvpanel_panelregespe_Autoscroll ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Shownext ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Showlast ;
   private boolean Gridsdtprofesionalespecialidadsedespaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panellistespe_Autowidth ;
   private boolean Dvpanel_panellistespe_Autoheight ;
   private boolean Dvpanel_panellistespe_Collapsible ;
   private boolean Dvpanel_panellistespe_Collapsed ;
   private boolean Dvpanel_panellistespe_Showcollapseicon ;
   private boolean Dvpanel_panellistespe_Autoscroll ;
   private boolean Dvpanel_paneleducacion_Autowidth ;
   private boolean Dvpanel_paneleducacion_Autoheight ;
   private boolean Dvpanel_paneleducacion_Collapsible ;
   private boolean Dvpanel_paneleducacion_Collapsed ;
   private boolean Dvpanel_paneleducacion_Showcollapseicon ;
   private boolean Dvpanel_paneleducacion_Autoscroll ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Shownext ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Showlast ;
   private boolean Gridsdtprofesionaleducacionspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_paneleducacionlist_Autowidth ;
   private boolean Dvpanel_paneleducacionlist_Autoheight ;
   private boolean Dvpanel_paneleducacionlist_Collapsible ;
   private boolean Dvpanel_paneleducacionlist_Collapsed ;
   private boolean Dvpanel_paneleducacionlist_Showcollapseicon ;
   private boolean Dvpanel_paneleducacionlist_Autoscroll ;
   private boolean Dvpanel_panelexperiencialaboral_Autowidth ;
   private boolean Dvpanel_panelexperiencialaboral_Autoheight ;
   private boolean Dvpanel_panelexperiencialaboral_Collapsible ;
   private boolean Dvpanel_panelexperiencialaboral_Collapsed ;
   private boolean Dvpanel_panelexperiencialaboral_Showcollapseicon ;
   private boolean Dvpanel_panelexperiencialaboral_Autoscroll ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Shownext ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Showlast ;
   private boolean Gridsdtprofesionalexperiencialaboralspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelexperiencialaborallist_Autowidth ;
   private boolean Dvpanel_panelexperiencialaborallist_Autoheight ;
   private boolean Dvpanel_panelexperiencialaborallist_Collapsible ;
   private boolean Dvpanel_panelexperiencialaborallist_Collapsed ;
   private boolean Dvpanel_panelexperiencialaborallist_Showcollapseicon ;
   private boolean Dvpanel_panelexperiencialaborallist_Autoscroll ;
   private boolean Dvpanel_panelpremioslogros_Autowidth ;
   private boolean Dvpanel_panelpremioslogros_Autoheight ;
   private boolean Dvpanel_panelpremioslogros_Collapsible ;
   private boolean Dvpanel_panelpremioslogros_Collapsed ;
   private boolean Dvpanel_panelpremioslogros_Showcollapseicon ;
   private boolean Dvpanel_panelpremioslogros_Autoscroll ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Shownext ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Showlast ;
   private boolean Gridsdtprofesionalpremiosspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelpremioslogroslist_Autowidth ;
   private boolean Dvpanel_panelpremioslogroslist_Autoheight ;
   private boolean Dvpanel_panelpremioslogroslist_Collapsible ;
   private boolean Dvpanel_panelpremioslogroslist_Collapsed ;
   private boolean Dvpanel_panelpremioslogroslist_Showcollapseicon ;
   private boolean Dvpanel_panelpremioslogroslist_Autoscroll ;
   private boolean Dvpanel_panelservicios_Autowidth ;
   private boolean Dvpanel_panelservicios_Autoheight ;
   private boolean Dvpanel_panelservicios_Collapsible ;
   private boolean Dvpanel_panelservicios_Collapsed ;
   private boolean Dvpanel_panelservicios_Showcollapseicon ;
   private boolean Dvpanel_panelservicios_Autoscroll ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Showfirst ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Showprevious ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Shownext ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Showlast ;
   private boolean Gridsdtprofesionalserviciosspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelservicioslist_Autowidth ;
   private boolean Dvpanel_panelservicioslist_Autoheight ;
   private boolean Dvpanel_panelservicioslist_Collapsible ;
   private boolean Dvpanel_panelservicioslist_Collapsed ;
   private boolean Dvpanel_panelservicioslist_Showcollapseicon ;
   private boolean Dvpanel_panelservicioslist_Autoscroll ;
   private boolean Gxuitabspanel_tabinformacionpaciente_Historymanagement ;
   private boolean wbLoad ;
   private boolean AV49ProfesionalFoto_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_169_Refreshing=false ;
   private boolean bGXsfl_235_Refreshing=false ;
   private boolean bGXsfl_292_Refreshing=false ;
   private boolean bGXsfl_348_Refreshing=false ;
   private boolean bGXsfl_386_Refreshing=false ;
   private boolean returnInSub ;
   private boolean gx_BV169 ;
   private boolean gx_BV235 ;
   private boolean gx_BV292 ;
   private boolean gx_BV348 ;
   private boolean gx_BV386 ;
   private boolean gx_refresh_fired ;
   private String AV38PremiosDescripcion ;
   private String AV70UbigeoDepartamento ;
   private String AV72UbigeoProvincia ;
   private String AV51ProfesionalNroDocumento ;
   private String AV50ProfesionalNombres ;
   private String AV42ProfesionalApellidoMaterno ;
   private String AV43ProfesionalApellidoPaterno ;
   private String AV44ProfesionalCOP ;
   private String AV46ProfesionalDescripcion ;
   private String AV71UbigeoDistrito ;
   private String AV47ProfesionalDireccion ;
   private String AV99Profesionalfoto_GXI ;
   private String AV45ProfesionalCorreo ;
   private String AV52ProfesionalPassword ;
   private String AV13EducacionProfesionalNombreInstitucion ;
   private String AV14EducacionProfesionalPais ;
   private String AV19ExperienciaLaboralEmpresaNombre ;
   private String AV40PremiosNombre ;
   private String AV68ServiciosNombre ;
   private String A186UbigeoDepartamento ;
   private String A295UbigeoDepartamentoCode ;
   private String A297UbigeoDistritoCode ;
   private String A296UbigeoProvinciaCode ;
   private String AV57Provincia ;
   private String AV9Distrito ;
   private String AV8Departamento ;
   private String ZV72UbigeoProvincia ;
   private String ZV71UbigeoDistrito ;
   private String AV49ProfesionalFoto ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalespecialidadsedesContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionaleducacionsContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalexperiencialaboralsContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalpremiossContainer ;
   private com.genexus.webpanels.GXWebGrid GridsdtprofesionalserviciossContainer ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalespecialidadsedesRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalserviciossRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalpremiossRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionalexperiencialaboralsRow ;
   private com.genexus.webpanels.GXWebRow GridsdtprofesionaleducacionsRow ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalserviciossColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalpremiossColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalexperiencialaboralsColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionaleducacionsColumn ;
   private com.genexus.webpanels.GXWebColumn GridsdtprofesionalespecialidadsedesColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucGxuitabspanel_tabinformacionpaciente ;
   private com.genexus.webpanels.GXUserControl ucSubirfotografia ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelregespe ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panellistespe ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneleducacion ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneleducacionlist ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelexperiencialaboral ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelexperiencialaborallist ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelpremioslogros ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelpremioslogroslist ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelservicios ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelservicioslist ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalservicioss_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalpremioss_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalexperiencialaborals_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionaleducacions_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalespecialidadsedes_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalserviciosspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalpremiosspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalexperiencialaboralspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionaleducacionspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucGridsdtprofesionalespecialidadsedespaginationbar ;
   private HTMLChoice cmbavProfesionaltipodocumento ;
   private HTMLChoice cmbavProfesionalsexo ;
   private HTMLChoice cmbavProfesionaltiempocita ;
   private HTMLChoice dynavPaisid ;
   private HTMLChoice cmbavUbigeodepartamento ;
   private HTMLChoice dynavUbigeoprovincia ;
   private HTMLChoice dynavUbigeodistrito ;
   private HTMLChoice dynavEspecialidadnombreid ;
   private HTMLChoice cmbavEspecialidadtipoconsulta ;
   private HTMLChoice cmbavSdtprofesionalespecialidadsedes__sedetipoconsulta ;
   private IDataStoreProvider pr_default ;
   private short[] H002Z2_A43PaisId ;
   private String[] H002Z2_A184PaisDescripcion ;
   private String[] H002Z3_A44UbigeoCode ;
   private String[] H002Z3_A187UbigeoProvincia ;
   private String[] H002Z3_A296UbigeoProvinciaCode ;
   private String[] H002Z3_A295UbigeoDepartamentoCode ;
   private String[] H002Z4_A44UbigeoCode ;
   private String[] H002Z4_A188UbigeoDistrito ;
   private String[] H002Z4_A297UbigeoDistritoCode ;
   private String[] H002Z4_A295UbigeoDepartamentoCode ;
   private String[] H002Z4_A296UbigeoProvinciaCode ;
   private short[] H002Z5_A32EspecialidadId ;
   private String[] H002Z5_A71EspecialidadNombre ;
   private short[] H002Z6_A43PaisId ;
   private String[] H002Z6_A184PaisDescripcion ;
   private short[] H002Z7_A6SecUserId ;
   private int[] H002Z7_A31ProfesionalId ;
   private String[] H002Z8_A186UbigeoDepartamento ;
   private String[] H002Z8_A295UbigeoDepartamentoCode ;
   private String[] H002Z8_A44UbigeoCode ;
   private String[] H002Z9_A44UbigeoCode ;
   private short[] H002Z10_A43PaisId ;
   private String[] H002Z10_A184PaisDescripcion ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV73UploadedFiles ;
   private GXBaseCollection<com.projectthani.SdtFileUploadData> AV21FailedFiles ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion> AV58SDTProfesionalEducacions ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEducacion> GXv_objcol_SdtSDTProfesionalEducacion4[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede> AV59SDTProfesionalEspecialidadSedes ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalEspecialidadSede> GXv_objcol_SdtSDTProfesionalEspecialidadSede2[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral> AV60SDTProfesionalExperienciaLaborals ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalExperienciaLaboral> GXv_objcol_SdtSDTProfesionalExperienciaLaboral5[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral> AV61SDTProfesionalInformacionGeneral ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalInformacionGeneral> GXv_objcol_SdtSDTProfesionalInformacionGeneral3[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios> AV62SDTProfesionalPremioss ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalPremios> GXv_objcol_SdtSDTProfesionalPremios6[] ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios> AV63SDTProfesionalServicioss ;
   private GXBaseCollection<com.projectthani.SdtSDTProfesionalServicios> GXv_objcol_SdtSDTProfesionalServicios7[] ;
   private com.projectthani.wwpbaseobjects.SdtSecUser AV7SecUser ;
   private com.projectthani.SdtProfesional AV41Profesional ;
   private com.projectthani.SdtProfesional_Educacion AV10Educacion ;
   private com.projectthani.SdtProfesional_ExperienciaLaboral AV17ExperienciaLaboral ;
   private com.projectthani.SdtProfesional_Premios AV37Premios ;
   private com.projectthani.SdtProfesional_Servicios AV67Servicios ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext AV74WWPContext ;
   private com.projectthani.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class wpmiperfilmedico__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H002Z2", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z3", "SELECT [UbigeoCode], [UbigeoProvincia], SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode FROM [Ubigeo] WHERE SUBSTRING([UbigeoCode], 1, 2) = ? ORDER BY [UbigeoProvincia] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z4", "SELECT [UbigeoCode], [UbigeoDistrito], SUBSTRING([UbigeoCode], 5, 2) AS UbigeoDistritoCode, SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, SUBSTRING([UbigeoCode], 3, 2) AS UbigeoProvinciaCode FROM [Ubigeo] WHERE (SUBSTRING([UbigeoCode], 1, 2) = ?) AND (SUBSTRING([UbigeoCode], 3, 2) = ?) ORDER BY [UbigeoDistrito] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z5", "SELECT [EspecialidadId], [EspecialidadNombre] FROM [Especialidad] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z6", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z7", "SELECT [SecUserId], [ProfesionalId] FROM [Profesional] WHERE [SecUserId] = ? ORDER BY [SecUserId] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z8", "SELECT DISTINCT [UbigeoDepartamento], [UbigeoDepartamentoCode], NULL AS [UbigeoCode] FROM ( SELECT TOP(100) PERCENT [UbigeoDepartamento], SUBSTRING([UbigeoCode], 1, 2) AS UbigeoDepartamentoCode, [UbigeoCode] FROM [Ubigeo] ORDER BY [UbigeoDepartamento]) DistinctT ORDER BY [UbigeoDepartamento] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H002Z9", "SELECT [UbigeoCode] FROM [Ubigeo] WHERE [UbigeoCode] = ? ORDER BY [UbigeoCode] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H002Z10", "SELECT [PaisId], [PaisDescripcion] FROM [Pais] ORDER BY [PaisDescripcion] ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 100);
               stmt.setVarchar(2, (String)parms[1], 100);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 10);
               return;
      }
   }

}

